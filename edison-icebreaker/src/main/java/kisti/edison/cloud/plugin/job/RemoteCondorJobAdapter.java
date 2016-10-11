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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.Job.JobType;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.plugin.spec.JobAdapter;

/**
 * @author hgkim@kisti.re.kr
 * 
 */
@Component("Condor")
public class RemoteCondorJobAdapter implements JobAdapter {
	protected final Logger LOG = Logger.getLogger(this.getClass());
	
	protected final Pattern pattern = Pattern.compile("^\\[(.*)\\]-\\[(.*?)\\]$");

	@Override
	public String getVersion() {
		/*
		 * # condor_q -version
			$CondorVersion: 7.8.8 Mar 20 2013 BuildID: 110288 $
			$CondorPlatform: x86_64_rhap_6.3 $
		 */
		return "7.8.8";
	}

	@Override
	public String getName() {
		return "Condor";
	}
	
	/*
	 * http://pages.cs.wisc.edu/~adesmet/status.html
	 * JobStatus in job ClassAds
		0	Unexpanded	U
		1	Idle	I
		2	Running	R
		3	Removed	X
		4	Completed	C
		5	Held	H
		6	Submission_err	E
	 */
	private Job.JobState lcmState2State(String lcmState, String exitStatus) {
		if (lcmState.equals("4")) {
			if (exitStatus.equals("0"))
				return Job.JobState.SUCCESS;
			else
				return Job.JobState.FAILED;
		} else if (lcmState.equals("1")) {
			return Job.JobState.QUEUED;
		} else if (lcmState.equals("2")) {
			return Job.JobState.RUNNING;
		} else if (lcmState.equals("5")) {
			return Job.JobState.SUSPENDED;
		} else if (lcmState.equals("6")) {
			return Job.JobState.FAILED;
		} else { /* 0, 3 */
			return Job.JobState.UNKNOWN;
		}
	}
	
	private String makeJobScriptFile(Job job, Cluster cluster) {
		String wdir = job.getWorkingDir();
		String filePath = wdir + "/condor-script";
		String filePath2 = wdir + "/exec.sh";
		
		boolean parallel = false;
		boolean openmp = false;
		if (job.getnProcs() > 1) parallel = true;
		
		if ( parallel == true ) {
			if (job.getCategory().equals(Job.JobCategory.GNU_OPENMP) 
					|| job.getCategory().equals(Job.JobCategory.INTEL_OPENMP)) openmp=true;
		}
		
		try {
			BufferedWriter condor_script = new BufferedWriter(new FileWriter(filePath));
			String s = "";
			if (job.getType().equals(Job.JobType.SEQUENTIAL)) {
				s = "Universe = vanilla";
				condor_script.write(s);
				condor_script.newLine();
			}
			else
			{
				if (openmp) {
					s = "Universe = vanilla";
					condor_script.write(s);
					condor_script.newLine();
				}
				else {
					s = "Universe = parallel";
					condor_script.write(s);
					condor_script.newLine();
					s = "machine_count = " + job.getnProcs();
					condor_script.write(s);
					condor_script.newLine();
				}
			}
			
			s = "Executable = " + wdir + "/exec.sh";
			condor_script.write(s);
			condor_script.newLine();
			
			s = "Output = " + wdir + "/dummy.out";
			condor_script.write(s);
			condor_script.newLine();
			
			s = "Error = " + wdir + "/" + job.getUuid() + ".err";
			condor_script.write(s);
			condor_script.newLine();
			
			s = "queue";
			condor_script.write(s);
			condor_script.newLine();
			condor_script.close();

			BufferedWriter out = new BufferedWriter(new FileWriter(filePath2));
			s = "#!/bin/sh";
			out.write(s);
			out.newLine();
//			s = "#PBS -N " + job.getUuid();
//			out.write(s);
//			out.newLine();
//			s = "#PBS -d " + job.getWorkingDir();
//			out.write(s);
//			out.newLine();
//			s = "#PBS -q " + cluster.getQueues();
//			out.write(s);
//			out.newLine();
			
//			if(job.getnProcs() == 1) {
//				s = "#PBS -l nodes=" + job.getnProcs();
//			} else if (job.getnProcs() > cluster.getRuntime().getTotalCores()) {
//				out.close();
//				return null;
//			} else {
//				Map<String, Integer> result = minMultiplex(job.getnProcs(), (int)Integer.parseInt(Cloud.getInstance().getProp("nCores")));
//				s = "#PBS -l nodes=" + result.get("Nodes") + ":ppn=" + result.get("PPN");
//			}
//			out.write(s);
//			out.newLine();
			
//			out.newLine();

			if(parallel == true && openmp == false) {
				s = "_CONDOR_PROCNO=$_CONDOR_PROCNO";
				out.write(s);
				out.newLine();
				s = "_CONDOR_NPROCS=$_CONDOR_NPROCS";
				out.write(s);
				out.newLine();
				
				out.newLine();
				
				s = "CONDOR_SSH=`condor_config_val libexec`";
				out.write(s);
				out.newLine();
				s = "CONDOR_SSH=$CONDOR_SSH/condor_ssh";
				out.write(s);
				out.newLine();
				
				out.newLine();
				s = "SSHD_SH=`condor_config_val libexec`";
				out.write(s);
				out.newLine();
				s = "SSHD_SH=$SSHD_SH/sshd.sh";
				out.write(s);
				out.newLine();
				
				out.newLine();
				s = ". $SSHD_SH $_CONDOR_PROCNO $_CONDOR_NPROCS";
				out.write(s);
				out.newLine();
				
				out.newLine();
				s = "if [ $_CONDOR_PROCNO -ne 0 ]";
				out.write(s);
				out.newLine();
				s = "then";
				out.write(s);
				out.newLine();
				s = "                wait";
				out.write(s);
				out.newLine();
				s = "                sshd_cleanup";
				out.write(s);
				out.newLine();
				s = "                exit 0";
				out.write(s);
				out.newLine();
				s = "fi";
				out.write(s);
				out.newLine();
				s = "export P4_RSHCOMMAND=$CONDOR_SSH";
				out.write(s);
				out.newLine();
				
				out.newLine();
				s = "CONDOR_CONTACT_FILE=$_CONDOR_SCRATCH_DIR/contact";
				out.write(s);
				out.newLine();
				s = "export CONDOR_CONTACT_FILE";
				out.write(s);
				out.newLine();
			}
			
			s = "cd " + job.getWorkingDir();
			out.write(s);
			out.newLine();
			
//			// Dependencies Setting
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
			
			if(parallel == true && openmp == false) {
				s = "sort -n -k 1 < $CONDOR_CONTACT_FILE | awk '{print $2}' > machines";
				out.write(s);
				out.newLine();
			}

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
			s ="if [ -f " + wdir + "simrc ]; then";
			out.write(s);
			out.newLine();
		    s = "	source " + wdir + "simrc;";
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

//					s = Cloud.getInstance().getProp("mpirun.path") + "/bin/mpirun"
//							+ " -machinefile " + "$PBS_NODEFILE" + " -np "
//							+ job.getnProcs() + " ./" + executableName + " "
//							+ jobCommand + " >" + job.getUuid() + ".out";
					s = Cloud.getInstance().getProp("mpirun.path") + "/bin/mpirun"
					+ " -machinefile machines" + " -np "+ job.getnProcs() 
					+ " " + job.getWorkingDir() + executableName + " "
					+ jobCommand + " >" + job.getUuid() + ".out";
					out.write(s);
					out.newLine();
				} else if(job.getCategory().equals(Job.JobCategory.GNU_OPENMPI_1_4)){
//					s = "NCPU=`wc -l < $PBS_NODEFILE`\r\n";
//					out.write(s);
//					s = "NNODES=`uniq $PBS_NODEFILE | wc -l`\r\n";
//					out.write(s);
//					s = "echo ------------------------------------------------------\r\n";
//					out.write(s);
//					s = "echo ' This job is allocated on '${NCPU}' cpu(s)'\r\n";
//					out.write(s);
//					s = "echo 'Job is running on node(s): '\r\n";
//					out.write(s);
//					s = "cat $PBS_NODEFILE\r\n";
//					out.write(s);
//					s = "echo ------------------------------------------------------\r\n";
//					out.write(s);
//					s = "echo PBS: qsub is running on $PBS_O_HOST\r\n";
//					out.write(s);
//					s = "echo PBS: originating queue is $PBS_O_QUEUE\r\n";
//					out.write(s);
//					s = "echo PBS: executing queue is $PBS_QUEUE\r\n";
//					out.write(s);
//					s = "echo PBS: working directory is $PBS_O_WORKDIR\r\n";
//					out.write(s);
//					s = "echo PBS: execution mode is $PBS_ENVIRONMENT\r\n";
//					out.write(s);
//					s = "echo PBS: job identifier is $PBS_JOBID\r\n";
//					out.write(s);
//					s = "echo PBS: job name is $PBS_JOBNAME\r\n";
//					out.write(s);
//					s = "echo PBS: node file is $PBS_NODEFILE\r\n";
//					out.write(s);
//					s = "echo PBS: number of nodes is $NNODES\r\n";
//					out.write(s);
//					s = "echo PBS: current home directory is $PBS_O_HOME\r\n";
//					out.write(s);
//					s = "echo PBS: PATH = $PBS_O_PATH\r\n";
//					out.write(s);
//					s = "echo ------------------------------------------------------\r\n";
//					out.write(s);
					s = "export LD_LIBRARY_PATH="+Cloud.getInstance().getProp("gcc.openmpi.path")+"/lib:$LD_LIBRARY_PATH";
					out.write(s);
					out.newLine();
					s = "MPIPATH="+Cloud.getInstance().getProp("gcc.openmpi.path")+"/bin";
					out.write(s);
					out.newLine();
					s = "${MPIPATH}/mpirun"
//							+ " -machinefile " + "$PBS_NODEFILE" + " -np "
							+ " -machinefile " +
							"" +
							"machines" + " -np "
							+ job.getnProcs() + " ./" + executableName + " "
							+ jobCommand + " >" + job.getUuid() + ".out";
					out.write(s);
					out.newLine();
				} else if(job.getCategory().equals(Job.JobCategory.INTEL_OPENMPI_1_4)) {
//					s = "NCPU=`wc -l < $PBS_NODEFILE`\r\n";
//					out.write(s);
//					s = "NNODES=`uniq $PBS_NODEFILE | wc -l`\r\n";
//					out.write(s);
//					s = "echo ------------------------------------------------------\r\n";
//					out.write(s);
//					s = "echo ' This job is allocated on '${NCPU}' cpu(s)'\r\n";
//					out.write(s);
//					s = "echo 'Job is running on node(s): '\r\n";
//					out.write(s);
//					s = "cat $PBS_NODEFILE\r\n";
//					out.write(s);
//					s = "echo ------------------------------------------------------\r\n";
//					out.write(s);
//					s = "echo PBS: qsub is running on $PBS_O_HOST\r\n";
//					out.write(s);
//					s = "echo PBS: originating queue is $PBS_O_QUEUE\r\n";
//					out.write(s);
//					s = "echo PBS: executing queue is $PBS_QUEUE\r\n";
//					out.write(s);
//					s = "echo PBS: working directory is $PBS_O_WORKDIR\r\n";
//					out.write(s);
//					s = "echo PBS: execution mode is $PBS_ENVIRONMENT\r\n";
//					out.write(s);
//					s = "echo PBS: job identifier is $PBS_JOBID\r\n";
//					out.write(s);
//					s = "echo PBS: job name is $PBS_JOBNAME\r\n";
//					out.write(s);
//					s = "echo PBS: node file is $PBS_NODEFILE\r\n";
//					out.write(s);
//					s = "echo PBS: number of nodes is $NNODES\r\n";
//					out.write(s);
//					s = "echo PBS: current home directory is $PBS_O_HOME\r\n";
//					out.write(s);
//					s = "echo PBS: PATH = $PBS_O_PATH\r\n";
//					out.write(s);
//					s = "echo ------------------------------------------------------\r\n";
//					out.write(s);
					s = "export LD_LIBRARY_PATH="+Cloud.getInstance().getProp("intel.openmpi.path")+"/lib:$LD_LIBRARY_PATH";
					out.write(s);
					out.newLine();
					s = "MPIPATH="+Cloud.getInstance().getProp("intel.openmpi.path")+"/bin";
					out.write(s);
					out.newLine();
					s = "${MPIPATH}/mpirun"
//							+ " -machinefile " + "$PBS_NODEFILE" + " -np "
							+ " -machinefile machines" + " -np "
							+ job.getnProcs() + " ./" + executableName + " "
							+ jobCommand + " >" + job.getUuid() + ".out";
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
			
			if(parallel == true && openmp == false) {
				s = "sshd_cleanup";
				out.write(s);
				out.newLine();
//				s = "rm -f machines";
//				out.write(s);
//				out.newLine();
			}
			
			if (job.getDependencies() != null) {
				s = "for i in *; do if [ -L $i ]; then unlink $i; fi; done";
				out.write(s);
				out.newLine();
			}
			
//			s = "zip -r " + Cloud.getInstance().getProp("output.zipfile") + " "
//					+ Cloud.getInstance().getProp("output.basedir");
			s = "zip -r result.zip ./result/*"; 
			out.write(s);
			out.newLine();
			out.close();

			// http://www.mkyong.com/java/how-to-set-the-file-permission-in-java/
			File file = new File(filePath2);
			file.setExecutable(true, false);
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
		RemoteCondorJob submittedJob = null;

		if (job.getType() instanceof Job.JobType) {
			if (job.getType().equals(Job.JobType.PARALLEL)) {
				if(!(job.getCategory() instanceof Job.JobCategory)) {
					job.setState(Job.JobState.SUBMISSION_FAILED);
					return job;
				}
			}
			scriptPath = makeJobScriptFile(job, cluster);
			if(scriptPath == null) return null;
			
//			// change owner
//			String grp = "EDISON";
//			String homedir = job.getWorkingDir();
//			List<String> cmd = new ArrayList<String>();
//			cmd.clear();
//			cmd.add("/usr/bin/sudo");
//			cmd.add("/bin/chown");
//			cmd.add("-R");
//			cmd.add(user.getUserId()+":"+grp);
//			cmd.add(homedir);
//			
//			LOG.info("chown cmd: " + cmd.toString());
//			ProcessBuilder builder = new ProcessBuilder(cmd);
//			builder.redirectErrorStream(true);
//			Process p = null;
//			int retCode = 0;
//			byte[] data = null;
//			
//			try {
//				p = builder.start();
//				retCode = p.waitFor();
//				LOG.info("Exit Value : " + p.exitValue());
//				
//				if (retCode == (-1)) {
//					LOG.error("chown fail" + cmd);
//				}
//				
//				BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
//				data = new byte[ef.available()];
//				ef.read(data, 0, ef.available());
//				ef.close();
//				p.getInputStream().close();
//				p.getOutputStream().close();
//				p.getErrorStream().close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}

		} else {
			job.setState(Job.JobState.SUBMISSION_FAILED);
			return job;
		}

		RemoteCondorJob j = new RemoteCondorJob(job.getUuid(), scriptPath);
		try {
			String jobId = j.queue(cluster, job);
			
			LOG.info("condor jobId: " + jobId);

			if (jobId != null && !jobId.isEmpty()) {
				LOG.info("CALL RemoteCondorJob.getJobById in RemoteCondorJobAdapter");
				submittedJob = RemoteCondorJob.getJobById(cluster, job, jobId);
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

		RemoteCondorJob j = null;

		try {
			j = RemoteCondorJob.getJobById(cluster, job, job.getJobId());
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
//		if (job.getState().equals(Job.JobState.RUNNING)
//				|| job.getState().equals(Job.JobState.SUCCESS)
//				|| job.getState().equals(Job.JobState.FAILED)) {
//			try {
//				if(!j.getStime().equals("N/A")) {
//					job.setStartTime(df.parse(j.getStime()));
//				}
//				if(!j.getComp_time().equals("N/A")) {
//					job.setEndTime(df.parse(j.getComp_time()));
//				}
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//		}
		try {
			if(!j.getStime().equals("N/A")) {
				job.setStartTime(df.parse(j.getStime()));
			}
			if(!j.getComp_time().equals("N/A")) {
				job.setEndTime(df.parse(j.getComp_time()));
			}
		} catch (ParseException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();
		}

		return job;
	}

	@Override
	public Job cancel(User user, Cluster cluster, Job job)
	{
		if (job == null) {
			return null;
		}
		RemoteCondorJob j = new RemoteCondorJob();
		Job job2 = j.cancel(user, cluster, job);
		
		return job2;
		
//		List<String> cmd = new ArrayList<String>();
//		cmd.add("ssh");
//		cmd.add("-p");
//		cmd.add(cluster.getPort());
//		cmd.add(cluster.getIp());
//		cmd.add("qdel");
//		cmd.add(job.getJobId());
//		
//		LOG.info("qdel cmd: " + cmd.toString());
//		
//		ProcessBuilder builder = new ProcessBuilder(cmd);
//		builder.redirectErrorStream(true);
//		Process p = null;
//		int retCode = -1;
//		byte[] data = null;
//		try {
//			p = builder.start();
//			
//			retCode = p.waitFor();
//			
//			if (retCode == (-1)) {
//				LOG.error("ssh qdel cancel fail");
//				return null;
//			}
//			
//			BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
//			data = new byte[ef.available()];
//			ef.read(data, 0, ef.available());
//			ef.close();
//			p.getInputStream().close();
//			p.getOutputStream().close();
//			p.getErrorStream().close();
//			
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		String output = new String(data);
//		LOG.info("Canceling " + job.getJobId());
//		LOG.info("CANCEL OUTPUT : " + output);
//
//		if (output.length() > 0) {
//			return null;
//		} else {
//			job.setState(Job.JobState.CANCELED);
//			return job;
//		}
		
		
		
		
//		Process p = null;
//		try {
//			p = Runtime.getRuntime().exec("qdel " + job.getJobId());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			p.waitFor();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		BufferedInputStream ef = new BufferedInputStream(p.getErrorStream());
//		byte[] data = null;
//		try {
//			data = new byte[ef.available()];
//			ef.read(data, 0, ef.available());
//			ef.close();
//			p.getInputStream().close();
//			p.getOutputStream().close();
//			p.getErrorStream().close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		String output = new String(data);
//		LOG.info("Canceling " + job.getJobId());
//		LOG.info("CANCEL OUTPUT : " + output);
//
//		if (output.length() > 0) {
//			return null;
//		} else {
//			job.setState(Job.JobState.CANCELED);
//			return job;
//		}
	}

	@Override
	public byte[] getErrorLog(User user, Cluster cluster, Job job) throws IOException {
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
	
	public static void main(String[] args)
	{
		Cluster cluster = new Cluster();
		User user = new User();
		Job job = new Job();
		job.setUuid("11");
		job.setType(JobType.SEQUENTIAL);
		job.setWorkingDir("/EDISON/TEST/DATA/admin/jobs/11");
//		job.setDependencies(null);
		job.setExecutable("/EDISON/TEST/SOLVERS/solver.sh");
		job.setExecution("");
		JobAdapter ja = new RemoteCondorJobAdapter();
		ja.submit(user, cluster, job);
	}
}