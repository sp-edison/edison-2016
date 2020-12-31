package kisti.edison.cloud.plugin.job;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.plugin.spec.JobAdapter;

@Component("Slurm")
public class RemoteSlurmJobAdapter implements JobAdapter {
	
	protected final Logger LOG = Logger.getLogger(this.getClass());
	
	protected final Pattern pattern = Pattern.compile("^\\[(.*)\\]-\\[(.*?)\\]$");

	@Override
	public String getVersion() {
		return "17.02.11";
	}

	@Override
	public String getName() {
		return "Slurm";
	}
	
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
	private Map<String, Integer> minMultiplex(int requestedCores, int maxPPN){
		Map<String, Integer> result = new HashMap<String,Integer>();
		int min = -1;
		int nodes, diff;
		int minNodes = 1, minPPN = requestedCores;
	
		if(requestedCores < maxPPN){
			result.put("Nodes", 1);
			result.put("PPN", requestedCores);
			return result;
		}
		for(int i=2; i <= maxPPN; i++){
			if(requestedCores % i != 0)
				nodes = requestedCores / i + 1;
			else
				nodes = requestedCores / i;
			diff = nodes * i - requestedCores;
			if(min < 0) {
				min = diff;
				minNodes = nodes;
				minPPN = i;
			}
			else if(diff <= min){
				min = diff;
				minNodes = nodes;
				minPPN = i;
			}
		}
		result.put("Nodes", minNodes);
		result.put("PPN", minPPN);		
		return result;
	}
	
	private String makeJobScriptFile(Job job, Cluster cluster) {
//		String filePath = job.getWorkingDir() + "/.script";
		String filePath = job.getWorkingDir() + "/remote-pbs-script";
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			String s = "#!/bin/bash";
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
			s = "#PBS -W " + "umask=002";
			out.write(s);
			out.newLine();
			if(job.getnProcs() == 1) {
				s = "#PBS -l nodes=" + job.getnProcs();
			} else if (job.getnProcs() > cluster.getRuntime().getTotalCores()) {
				out.close();
				return null;
			} else {
				Map<String, Integer> result = minMultiplex(job.getnProcs(), (int)Integer.parseInt(Cloud.getInstance().getProp("nCores")));
				s = "#PBS -l nodes=" + result.get("Nodes") + ":ppn=" + result.get("PPN");
				/*int nnodes = (job.getnProcs() / (int)Integer.parseInt(Cloud.getInstance().getProp("nCores")));
				if (nnodes != 0) {
					if ((job.getnProcs() % (int)Integer.parseInt(Cloud.getInstance().getProp("nCores"))) == 0) {
						s = "#PBS -l nodes=" + nnodes + ":ppn=" + Cloud.getInstance().getProp("nCores");
					} else {
						s = "#PBS -l nodes=" + (nnodes+1) + ":ppn=" + Cloud.getInstance().getProp("nCores");
					}
				} else {
					s = "#PBS -l nodes=" + 1 + ":ppn=" + Cloud.getInstance().getProp("nCores");
				}*/
			}
			out.write(s);
			out.newLine();
			
			out.newLine();
			
			s = "cd " + job.getWorkingDir();
			out.write(s);
			out.newLine();
			
			// Dependencies Setting
//			if (job.getDependencies() != null) {
//				Iterator<String> iter = job.getDependencies().keySet().iterator();
//				while (iter.hasNext()) {
//					String linkName = iter.next();
//					String target = job.getDependencies().get(linkName);
//					
//					s = "ln -sf " + target + " " + linkName;
//					out.write(s);
//					out.newLine();
//				}
//			}

			String executable = job.getExecutable();
			s = "cp " + executable + " .";
			out.write(s);
			out.newLine();

			if (job.getDependencies() != null) {
				// http://stackoverflow.com/questions/3657157/how-do-i-get-a-files-directory-using-the-file-object
				File tmpFilePath = new File(executable);
				String dir=tmpFilePath.getAbsolutePath().replaceAll(tmpFilePath.getName()+"$", "");
				s = "TDIR=" + dir;
				out.write(s);
				out.newLine();
				
				s = "if [ -d ${TDIR} ]; then for i in ${TDIR}/*; do ln -s $i 2>/dev/null; done; fi";
				out.write(s);
				out.newLine();
			}
			
			/* env variable setup */
			s ="if [ -f " + job.getWorkingDir() + "simrc ]; then";
			out.write(s);
			out.newLine();
		    s = "	source " + job.getWorkingDir() + "simrc;";
		    out.write(s);
			out.newLine();
			s= "fi";
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
			
			jobCommand = jobCommand.replaceAll("\\(", "\\\\(");
			jobCommand = jobCommand.replaceAll("\\)", "\\\\)");
			
			String executableName = job.getExecutable().substring(job.getExecutable().lastIndexOf('/')+1);
			if (job.getType().equals(Job.JobType.SEQUENTIAL)) {
				s = "./" + executableName + " " + jobCommand + " >" + job.getUuid() + ".out 2>&1";
				out.write(s);
			} else {
				/* GNU and INTEL OpenMP Support */
				if (job.getCategory().equals(Job.JobCategory.GNU_OPENMP) || job.getCategory().equals(Job.JobCategory.INTEL_OPENMP)) {
					s = "export OMP_NUM_THREADS=" + job.getnProcs() + ";";
					out.write(s);
					out.newLine();
					s = "./" + executableName + " " + jobCommand + " >" + job.getUuid() + ".out";
					out.write(s);
					out.newLine();
				}
				else if (job.getCategory().equals(Job.JobCategory.INTEL_MPICH_1)) {
					/*s = Cloud.getInstance().getProp("mpirun.path") + "/bin/mpirun"
						+ " -machinefile " + "$PBS_NODEFILE" + " -np "
						+ job.getnProcs() + " ./" + executableName + " "
						+ jobCommand;*/
					/*
					 * mpirun �ヂ�뜮?process �얜챷��?�욧퍙 by 筌ㅼ뮇媛�?
					 */
					s = "export MPICH_PROCESS_GROUP=no";
					out.write(s);
					out.newLine();

					s = Cloud.getInstance().getProp("mpirun.path") + "/bin/mpirun"
							+ " -machinefile " + "$PBS_NODEFILE" + " -np "
							+ job.getnProcs() + " ./" + executableName + " "
							+ jobCommand + " >" + job.getUuid() + ".out";
					out.write(s);
					out.newLine();
				} else if(job.getCategory().equals(Job.JobCategory.GNU_OPENMPI_1_4)){
//					s = "NCPU=`wc -l < $PBS_NODEFILE`";
//					out.write(s);
//					out.newLine();
//					s = "NNODES=`uniq $PBS_NODEFILE | wc -l`";
//					out.write(s);
//					out.newLine();
//					s = "echo ------------------------------------------------------";
//					out.write(s);
//					out.newLine();
//					s = "echo ' This job is allocated on '${NCPU}' cpu(s)'";
//					out.write(s);
//					out.newLine();
//					s = "echo 'Job is running on node(s): '";
//					out.write(s);
//					out.newLine();
//					s = "cat $PBS_NODEFILE";
//					out.write(s);
//					out.newLine();
//					s = "echo ------------------------------------------------------";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: qsub is running on $PBS_O_HOST";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: originating queue is $PBS_O_QUEUE";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: executing queue is $PBS_QUEUE";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: working directory is $PBS_O_WORKDIR";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: execution mode is $PBS_ENVIRONMENT";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: job identifier is $PBS_JOBID";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: job name is $PBS_JOBNAME";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: node file is $PBS_NODEFILE";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: number of nodes is $NNODES";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: current home directory is $PBS_O_HOME";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: PATH = $PBS_O_PATH";
//					out.write(s);
//					out.newLine();
//					s = "echo ------------------------------------------------------";
//					out.write(s);
//					out.newLine();
					s = "export LD_LIBRARY_PATH="+Cloud.getInstance().getProp("gcc.openmpi.path")+"/lib:$LD_LIBRARY_PATH";
					out.write(s);
					out.newLine();
					s = "MPIPATH="+Cloud.getInstance().getProp("gcc.openmpi.path")+"/bin";
					out.write(s);
					out.newLine();
					s = "${MPIPATH}/mpirun"
							+ " -machinefile " + "$PBS_NODEFILE" + " -np "
							+ job.getnProcs() + " ./" + executableName + " "
							+ jobCommand + " >" + job.getUuid() + ".out" + "";
					out.write(s);
					out.newLine();
				} else if(job.getCategory().equals(Job.JobCategory.INTEL_OPENMPI_1_4)) {
//					s = "NCPU=`wc -l < $PBS_NODEFILE`";
//					out.write(s);
//					out.newLine();
//					s = "NNODES=`uniq $PBS_NODEFILE | wc -l`";
//					out.write(s);
//					out.newLine();
//					s = "echo ------------------------------------------------------";
//					out.write(s);
//					out.newLine();
//					s = "echo ' This job is allocated on '${NCPU}' cpu(s)'";
//					out.write(s);
//					out.newLine();
//					s = "echo 'Job is running on node(s): '";
//					out.write(s);
//					out.newLine();
//					s = "cat $PBS_NODEFILE";
//					out.write(s);
//					out.newLine();
//					s = "echo ------------------------------------------------------";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: qsub is running on $PBS_O_HOST";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: originating queue is $PBS_O_QUEUE";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: executing queue is $PBS_QUEUE";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: working directory is $PBS_O_WORKDIR";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: execution mode is $PBS_ENVIRONMENT";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: job identifier is $PBS_JOBID";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: job name is $PBS_JOBNAME";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: node file is $PBS_NODEFILE";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: number of nodes is $NNODES";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: current home directory is $PBS_O_HOME";
//					out.write(s);
//					out.newLine();
//					s = "echo PBS: PATH = $PBS_O_PATH";
//					out.write(s);
//					out.newLine();
//					s = "echo ------------------------------------------------------";
//					out.write(s);
//					out.newLine();
					s = "export LD_LIBRARY_PATH="+Cloud.getInstance().getProp("intel.openmpi.path")+"/lib:$LD_LIBRARY_PATH";
					out.write(s);
					out.newLine();
					s = "MPIPATH="+Cloud.getInstance().getProp("intel.openmpi.path")+"/bin";
					out.write(s);
					out.newLine();
					s = "${MPIPATH}/mpirun"
							+ " -machinefile " + "$PBS_NODEFILE" + " -np "
							+ job.getnProcs() + " ./" + executableName + " "
							+ jobCommand + " >" + job.getUuid() + ".out" + "";
					out.write(s);
					out.newLine();
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

//			if (job.getDependencies() != null) {
//				s = "for i in *; do if [ -L $i ]; then unlink $i; fi; done";
//				out.write(s);
//				out.newLine();
//			}
//
//			s = "zip -r " + Cloud.getInstance().getProp("output.zipfile") + " "
//					+ Cloud.getInstance().getProp("output.basedir");
//			out.write(s);
//			out.newLine();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePath;
	}

	@Override
	public Job submit(User user, Cluster cluster, Job job) {
		if (job == null) {
			return null;
		}

		String scriptPath = null;
		RemoteSlurmJob submittedJob = null;

		if (job.getType() instanceof Job.JobType) {
			if (job.getType().equals(Job.JobType.PARALLEL)) {
				if(!(job.getCategory() instanceof Job.JobCategory)) {
					job.setState(Job.JobState.SUBMISSION_FAILED);
					return job;
				}
			}
			scriptPath = makeJobScriptFile(job, cluster);
			if(scriptPath == null) return null;
			File script = new File(scriptPath);
			script.setReadable(true, false);
		} else {
			job.setState(Job.JobState.SUBMISSION_FAILED);
			return job;
		}

		RemoteSlurmJob j = new RemoteSlurmJob(job.getUuid(), scriptPath);
		try {
			String jobId = j.queue(cluster, job);
			
			LOG.info("jobId: " + jobId);

			if (jobId != null && !jobId.isEmpty()) {
				LOG.info("call getJobById");
				submittedJob = RemoteSlurmJob.getJobById(cluster, job, jobId);
			} else {
				LOG.info("call queue SUBMISSION_FAILED");
				job.setState(Job.JobState.SUBMISSION_FAILED);
				return job;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
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

		RemoteSlurmJob j = null;

		try {
			j = RemoteSlurmJob.getJobById(cluster, job, job.getJobId());
			if (j.getId() == null || j.getId().isEmpty()) {
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
				e.printStackTrace();
			}
		}

		return job;
	}

	@Override
	public Job cancel(User user, Cluster cluster, Job job)
	{
		if (job == null) {
			return null;
		}
		RemoteSlurmJob j = new RemoteSlurmJob();
		Job job2 = j.cancel(user, cluster, job);
		
		return job2;
	}

	@Override
	public byte[] getErrorLog(User user, Cluster cluster, Job job) throws IOException {
		String errFilePath = job.getWorkingDir() + "/" + job.getUuid() + ".err";
		File file = new File(errFilePath);
		long length;
		byte[] bytes;
		if ( file.exists() == false ) {
			length = 0;
			bytes = new byte[0];
			return bytes;
		}
		
		InputStream is = new FileInputStream(file);
		
		length = file.length();
		bytes = new byte[(int) length];

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
