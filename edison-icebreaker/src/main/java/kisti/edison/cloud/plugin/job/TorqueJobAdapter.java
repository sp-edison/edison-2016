/**
 * 
 */
package kisti.edison.cloud.plugin.job;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.plugin.spec.JobAdapter;

/**
 * @author eairs
 * 
 */
@Component("TORQUE")
public class TorqueJobAdapter implements JobAdapter {
	protected final Logger LOG = Logger.getLogger(this.getClass());

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "3.0.5";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "TORQUE";
	}
	
	private String _replaceJobTitle(String source) {
		return source.replaceAll("\\p{Space}", "_");
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.plugin.spec.JobAdapter#submit(kisti.edison.cloud.model
	 * .Job)
	 */

	private Job.JobState lcmState2State(String lcmState, String exitStatus) {
		if (lcmState.equals("C")) {
			if (exitStatus.equals("0"))
				return Job.JobState.SUCCESS;
			else
				return Job.JobState.FAILED;
		} else if (lcmState.equals("Q")) {
			return Job.JobState.QUEUED;
		} else if (lcmState.equals("R")) {
			return Job.JobState.RUNNING;
		} else if (lcmState.equals("H") || lcmState.equals("S")) {
			return Job.JobState.SUSPENDED;
		} else if (lcmState.equals("E")) {
			return Job.JobState.RUNNING;
		} else {
			return Job.JobState.UNKNOWN;
		}
	}

	private String makeJobScriptFile(Job job, Cluster cluster) {
		String filePath = job.getWorkingDir() + "/.script";
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			String s = "#!/bin/sh";
			out.write(s);
			out.newLine();
			s = "#PBS -N " + job.getUuid();
			out.write(s);
			out.newLine();
			s = "#PBS -d " + job.getWorkingDir();
			out.write(s);
			out.newLine();
			s = "#PBS -q " + cluster.getQueues();
			out.write(s);
			out.newLine();
//			s = "#PBS -o " + job.getWorkingDir() + "/" + job.getUuid() + ".out";
			s = "#PBS -o " + job.getWorkingDir() + "/dummy.out";
			out.write(s);
			out.newLine();
			s = "#PBS -e " + job.getWorkingDir() + "/" + job.getUuid() + ".err";
			out.write(s);
			out.newLine();
			if(job.getnProcs() == 1) {
				s = "#PBS -l nodes=" + job.getnProcs();
			} else if (job.getnProcs() > cluster.getRuntime().getTotalCores()) {
				out.close();
				return null;
			} else {
				int nnodes = (job.getnProcs() / (int)Integer.parseInt(Cloud.getInstance().getProp("nCores")));
				if (nnodes != 0) {
					if ((job.getnProcs() % (int)Integer.parseInt(Cloud.getInstance().getProp("nCores"))) == 0) {
						s = "#PBS -l nodes=" + nnodes + ":ppn=" + Cloud.getInstance().getProp("nCores");
					} else {
						s = "#PBS -l nodes=" + (nnodes+1) + ":ppn=" + Cloud.getInstance().getProp("nCores");
					}
				} else {
					s = "#PBS -l nodes=" + 1 + ":ppn=" + Cloud.getInstance().getProp("nCores");
				}
			}
			out.write(s);
			out.newLine();
			
			out.newLine();
			
			s = "cd " + job.getWorkingDir();
			out.write(s);
			out.newLine();
			
			// Dependencies Setting
			if (job.getDependencies() != null) {
				Iterator<String> iter = job.getDependencies().keySet().iterator();
				while (iter.hasNext()) {
					String linkName = iter.next();
					String target = job.getDependencies().get(linkName);
					
					s = "ln -sf " + target + " " + linkName;
					out.write(s);
					out.newLine();
				}
			}

			s = "cp " + job.getExecutable() + " .";
			out.write(s);
			out.newLine();

			
			/* Job Command Replacements */
			String jobCommand = job.getExecution();
			if(jobCommand.contains("REDIRECTION_STDIN")) {
				jobCommand = jobCommand.replaceAll("REDIRECTION_STDIN", "<");
			}
			
			if(jobCommand.contains("REDIRECTION_STDOUT")) {
				jobCommand = jobCommand.replaceAll("REDIRECTION_STDOUT", ">");
			}
			
			if(jobCommand.contains("REDIRECTION_STDERR")) {
				jobCommand = jobCommand.replaceAll("REDIRECTION_STDERR", "2>");
			}
			
			if(jobCommand.contains("PIPE_LINE")) {
				jobCommand = jobCommand.replaceAll("PIPE_LINE", "|");
			}
			
			String executableName = job.getExecutable().substring(job.getExecutable().lastIndexOf('/')+1);
			if (job.getType().equals(Job.JobType.SEQUENTIAL)) {
				s = "./" + executableName + " " + jobCommand + " >" + job.getUuid() + ".out 2>&1";
				out.write(s);
			} else {
				/* GNU and INTEL OpenMP Support */
				if (job.getCategory().equals(Job.JobCategory.GNU_OPENMP) || job.getCategory().equals(Job.JobCategory.INTEL_OPENMP)) {
					s = "export OMP_NUM_THREADS=" + job.getnProcs();
					out.write(s);
					s = "./" + executableName + " " + jobCommand + " >" + job.getUuid() + ".out";
					out.write(s);
				}
				else if (job.getCategory().equals(Job.JobCategory.INTEL_MPICH_1)) {
					/*s = Cloud.getInstance().getProp("mpirun.path") + "/bin/mpirun"
						+ " -machinefile " + "$PBS_NODEFILE" + " -np "
						+ job.getnProcs() + " ./" + executableName + " "
						+ jobCommand;*/
					/*
					 * mpirun 좀비 process 문제 해결 by 최찬호
					 */
					s = "export MPICH_PROCESS_GROUP=no";
					out.write(s);
					out.newLine();

					s = Cloud.getInstance().getProp("mpirun.path") + "/bin/mpirun"
							+ " -machinefile " + "$PBS_NODEFILE" + " -np "
							+ job.getnProcs() + " ./" + executableName + " "
							+ jobCommand + " >" + job.getUuid() + ".out";
					out.write(s);
				} else if(job.getCategory().equals(Job.JobCategory.GNU_OPENMPI_1_4)){
					s = "NCPU=`wc -l < $PBS_NODEFILE`\r\n";
					out.write(s);
					s = "NNODES=`uniq $PBS_NODEFILE | wc -l`\r\n";
					out.write(s);
					s = "echo ------------------------------------------------------\r\n";
					out.write(s);
					s = "echo ' This job is allocated on '${NCPU}' cpu(s)'\r\n";
					out.write(s);
					s = "echo 'Job is running on node(s): '\r\n";
					out.write(s);
					s = "cat $PBS_NODEFILE\r\n";
					out.write(s);
					s = "echo ------------------------------------------------------\r\n";
					out.write(s);
					s = "echo PBS: qsub is running on $PBS_O_HOST\r\n";
					out.write(s);
					s = "echo PBS: originating queue is $PBS_O_QUEUE\r\n";
					out.write(s);
					s = "echo PBS: executing queue is $PBS_QUEUE\r\n";
					out.write(s);
					s = "echo PBS: working directory is $PBS_O_WORKDIR\r\n";
					out.write(s);
					s = "echo PBS: execution mode is $PBS_ENVIRONMENT\r\n";
					out.write(s);
					s = "echo PBS: job identifier is $PBS_JOBID\r\n";
					out.write(s);
					s = "echo PBS: job name is $PBS_JOBNAME\r\n";
					out.write(s);
					s = "echo PBS: node file is $PBS_NODEFILE\r\n";
					out.write(s);
					s = "echo PBS: number of nodes is $NNODES\r\n";
					out.write(s);
					s = "echo PBS: current home directory is $PBS_O_HOME\r\n";
					out.write(s);
					s = "echo PBS: PATH = $PBS_O_PATH\r\n";
					out.write(s);
					s = "echo ------------------------------------------------------\r\n";
					out.write(s);
					s = "export LD_LIBRARY_PATH="+Cloud.getInstance().getProp("gcc.openmpi.path")+"/lib:$LD_LIBRARY_PATH\r\n";
					out.write(s);
					s = "MPIPATH="+Cloud.getInstance().getProp("gcc.openmpi.path")+"/bin\r\n";
					out.write(s);
					s = "${MPIPATH}/mpirun"
							+ " -machinefile " + "$PBS_NODEFILE" + " -np "
							+ job.getnProcs() + " ./" + executableName + " "
							+ jobCommand + " >" + job.getUuid() + ".out" + "\r\n";
					out.write(s);
				} else if(job.getCategory().equals(Job.JobCategory.INTEL_OPENMPI_1_4)) {
					s = "NCPU=`wc -l < $PBS_NODEFILE`\r\n";
					out.write(s);
					s = "NNODES=`uniq $PBS_NODEFILE | wc -l`\r\n";
					out.write(s);
					s = "echo ------------------------------------------------------\r\n";
					out.write(s);
					s = "echo ' This job is allocated on '${NCPU}' cpu(s)'\r\n";
					out.write(s);
					s = "echo 'Job is running on node(s): '\r\n";
					out.write(s);
					s = "cat $PBS_NODEFILE\r\n";
					out.write(s);
					s = "echo ------------------------------------------------------\r\n";
					out.write(s);
					s = "echo PBS: qsub is running on $PBS_O_HOST\r\n";
					out.write(s);
					s = "echo PBS: originating queue is $PBS_O_QUEUE\r\n";
					out.write(s);
					s = "echo PBS: executing queue is $PBS_QUEUE\r\n";
					out.write(s);
					s = "echo PBS: working directory is $PBS_O_WORKDIR\r\n";
					out.write(s);
					s = "echo PBS: execution mode is $PBS_ENVIRONMENT\r\n";
					out.write(s);
					s = "echo PBS: job identifier is $PBS_JOBID\r\n";
					out.write(s);
					s = "echo PBS: job name is $PBS_JOBNAME\r\n";
					out.write(s);
					s = "echo PBS: node file is $PBS_NODEFILE\r\n";
					out.write(s);
					s = "echo PBS: number of nodes is $NNODES\r\n";
					out.write(s);
					s = "echo PBS: current home directory is $PBS_O_HOME\r\n";
					out.write(s);
					s = "echo PBS: PATH = $PBS_O_PATH\r\n";
					out.write(s);
					s = "echo ------------------------------------------------------\r\n";
					out.write(s);
					s = "export LD_LIBRARY_PATH="+Cloud.getInstance().getProp("intel.openmpi.path")+"/lib:$LD_LIBRARY_PATH\r\n";
					out.write(s);
					s = "MPIPATH="+Cloud.getInstance().getProp("intel.openmpi.path")+"/bin\r\n";
					out.write(s);
					s = "${MPIPATH}/mpirun"
							+ " -machinefile " + "$PBS_NODEFILE" + " -np "
							+ job.getnProcs() + " ./" + executableName + " "
							+ jobCommand + " >" + job.getUuid() + ".out" + "\r\n";
					out.write(s);
				} else {
					/* TODO: other categories should be supported in the near future */
				}
			}
			
			out.newLine();

			if(executableName.equals("rungms")) {
				s = "if [[ $? -ne 0 ]] ; then";
				out.write(s);
				out.newLine();
				s = "echo \"=================== INPUT FILE ==================\" >&2";
				out.write(s);
				out.newLine();
				s = "cat ./gamess_input.inp >&2";
				out.write(s);
				out.newLine();
				s = "echo \"=================== ERROR LOG ==================\" >&2";
				out.write(s);
				out.newLine();
				s = "cat ./result/gamess_output.log >&2";
				out.write(s);
				out.newLine();
				s = "	exit -1";
				out.write(s);
				out.newLine();
				s = "fi";
				out.write(s);
				out.newLine();
			}
			
			s = "zip -r " + Cloud.getInstance().getProp("output.zipfile") + " "
					+ Cloud.getInstance().getProp("output.basedir");
			out.write(s);
			out.newLine();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePath;
	}

	@Override
	public Job submit(User user, Cluster cluster, Job job) {
		// TODO Auto-generated method stub
		if (job == null) {
			return null;
		}

		String scriptPath = null;
		pbsTorque.Job submittedJob = null;

		if (job.getType() instanceof Job.JobType) {
			if (job.getType().equals(Job.JobType.PARALLEL)) {
				if(!(job.getCategory() instanceof Job.JobCategory)) {
					job.setState(Job.JobState.SUBMISSION_FAILED);
					return job;
				}
			}
			scriptPath = makeJobScriptFile(job, cluster);
			if(scriptPath == null) return null;
		} else {
			job.setState(Job.JobState.SUBMISSION_FAILED);
			return job;
		}

		pbsTorque.Job j = new pbsTorque.Job(job.getUuid(), scriptPath);
		try {
			String jobId = j.queue();

			if (jobId != null && !jobId.isEmpty()) {
				submittedJob = pbsTorque.Job.getJobById(jobId);
			} else {
				job.setState(Job.JobState.SUBMISSION_FAILED);
				return job;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(submittedJob == null) {
			job.setState(Job.JobState.SUBMISSION_FAILED);
			return job;
		}

		job.setJobId(submittedJob.getId());
		job.setLcmState(submittedJob.getStatus());
		job.setState(lcmState2State(submittedJob.getStatus(),
				submittedJob.getExitStatus()));

		return job;
	}

	@Override
	public Job getInformation(User user, Cluster cluster, Job job) {
		if (job == null) {
			return null;
		}

		pbsTorque.Job j = null;

		try {
			j = pbsTorque.Job.getJobById(job.getJobId());
			if (j.getId() == null || j.getId().isEmpty()) {
				return null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		job.setLcmState(j.getStatus());
		job.setState(lcmState2State(j.getStatus(), j.getExitStatus()));

		SimpleDateFormat df = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy", Locale.ENGLISH);
		if (job.getState().equals(Job.JobState.RUNNING)
				|| job.getState().equals(Job.JobState.SUCCESS)
				|| job.getState().equals(Job.JobState.FAILED)) {
			try {
				if(!j.getStime().equals("N/A")) {
					job.setStartTime(df.parse(j.getStime()));
				}
				if(!j.getComp_time().equals("N/A")) {
					job.setEndTime(df.parse(j.getComp_time()));
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return job;
	}

	@Override
	public Job cancel(User user, Cluster cluster, Job job) {
		if (job == null) {
			return null;
		}

		Process p = null;
		try {
			p = Runtime.getRuntime().exec("qdel " + job.getJobId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BufferedInputStream ef = new BufferedInputStream(p.getErrorStream());
		byte[] data = null;
		try {
			data = new byte[ef.available()];
			ef.read(data, 0, ef.available());
			ef.close();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String output = new String(data);
		LOG.info("Canceling " + job.getJobId());
		LOG.info("CANCEL OUTPUT : " + output);

		if (output.length() > 0) {
			return null;
		} else {
			job.setState(Job.JobState.CANCELED);
			return job;
		}
	}

	@Override
	public byte[] getErrorLog(User user, Cluster cluster, Job job) throws IOException {
		// TODO Auto-generated method stub
		String errFilePath = job.getWorkingDir() + "/" + job.getUuid() + ".err";
		File file = new File(errFilePath);
		
		InputStream is = new FileInputStream(file);
		long length = file.length();
		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			is.close();
			throw new IOException("Could not completely read file "
					+ file.getName());
		}

		is.close();
		return bytes;
	}

	@Override
	public byte[] getOutputLog(User user, Cluster cluster, Job job) throws IOException {
		// TODO Auto-generated method stub
		String errFilePath = job.getWorkingDir() + "/" + job.getUuid() + ".out";
		File file = new File(errFilePath);
		
		InputStream is = new FileInputStream(file);
		long length = file.length();
		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			is.close();
			throw new IOException("Could not completely read file "
					+ file.getName());
		}

		is.close();
		return bytes;
	}
}
