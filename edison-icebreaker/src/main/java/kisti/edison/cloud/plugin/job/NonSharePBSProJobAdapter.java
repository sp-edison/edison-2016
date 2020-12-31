package kisti.edison.cloud.plugin.job;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread.State;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import javax.net.ssl.SSLEngineResult.Status;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.apache.commons.codec.binary.Base64;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.Job.JobState;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.plugin.spec.JobAdapter;
import kisti.edison.cloud.service.SimulationService;

@Component("NSPBSPro")
public class NonSharePBSProJobAdapter implements JobAdapter {
	private SimulationService simulationService;

	protected final Logger LOG = Logger.getLogger(this.getClass());
	
	protected final Pattern pattern = Pattern.compile("^\\[(.*)\\]-\\[(.*?)\\]$");

	@Override
	public String getVersion() {
		return "18.1.2";
	}

	@Override
	public String getName() {
		return "NSPBSPro";
	}
	
	private Job.JobState lcmState2State(String lcmState, String exitStatus) {
		if (lcmState.equals("F")) { // C -> F
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
		Base64 base64 = new Base64(180, "".getBytes());
//		String filePath = job.getWorkingDir() + "/.script";
		String remoteWorkDir = String.format("scratch/%s", job.getWorkingDir().replaceAll("^.+?(" + job.getUserId() + ".+)","$1"));

		LOG.info(job.getWorkingDir());
		String filePath = job.getWorkingDir() + "/remote-pbspro-script";
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			String s = "#!/bin/bash";
			out.write(s);
			out.newLine();
			s = "#PBS -N " + job.getUuid();
			out.write(s);
			out.newLine();
//			s = "#PBS -d " + job.getWorkingDir();
//			out.write(s);
//			out.newLine();
			s = "#PBS -q " + cluster.getQueues();
			out.write(s);
			out.newLine();
//			s = "#PBS -o " + job.getWorkingDir() + "/" + job.getUuid() + ".out";
			s = "#PBS -o " + remoteWorkDir + "/dummy.out";
			out.write(s);
			out.newLine();
			s = "#PBS -e " + remoteWorkDir + "/" + job.getUuid() + ".err";
			out.write(s);
			out.newLine();
			s = "#PBS -W " + "umask=002";
			out.write(s);
			out.newLine();
			s = "#PBS -A " + "etc";
			out.write(s);
			out.newLine();
			if(job.getnProcs() == 1) {
				s = "#PBS -l select=" + job.getnProcs() + ":ncpus=1";
			} else if (job.getnProcs() > cluster.getRuntime().getTotalCores()) {
				out.close();
				return null;
			} else {
				Map<String, Integer> result = minMultiplex(job.getnProcs(), Integer.parseInt(Cloud.getInstance().getProp("nCores")));
				s = "#PBS -l select=" + result.get("Nodes") + ":ncpus=" + result.get("PPN");
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
			
			s = "cd " + remoteWorkDir;
			out.write(s);
			out.newLine();
			
			String executable = job.getExecutable();
			s = "cp " + executable + " .";
			out.write(s);
			out.newLine();

			String executableName = job.getExecutable().substring(job.getExecutable().lastIndexOf('/')+1);
			if (job.getDependencies() != null) {
				// http://stackoverflow.com/questions/3657157/how-do-i-get-a-files-directory-using-the-file-object
				String dir=executable.replaceAll(executableName+"$", "");
				s = "TDIR=" + dir;
				out.write(s);
				out.newLine();
				
				s = "if [ -d ${TDIR} ]; then for i in ${TDIR}/*; do ln -s $i 2>/dev/null; done; fi";
				out.write(s);
				out.newLine();
			}
			
			/* env variable setup */
			s ="if [ -f " + "simrc ]; then";
			out.write(s);
			out.newLine();
		    s = "	source " + "simrc;";
		    out.write(s);
			out.newLine();
			s= "fi";
			out.write(s);
			out.newLine();
			
			/* Job Command Replacements */
			String jobCommand = job.getExecution();
			LOG.info("33334");
			for (String base64DepFilePath : job.getFiles().values()) {
				String depFilePath = new String(base64.decode(base64DepFilePath));
				LOG.info("change file path from " + depFilePath + " to " + FilenameUtils.getName(depFilePath));
				LOG.info("jobCommand (before) : " + jobCommand);
				jobCommand = jobCommand.replaceFirst(depFilePath, FilenameUtils.getName(depFilePath));
				LOG.info("jobCommand (after)  : " + jobCommand);
			}
			LOG.info("job command : " + jobCommand);
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
			
			//String executableName = job.getExecutable().substring(job.getExecutable().lastIndexOf('/')+1);
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
			
			/* instead of epilogue /SYSTEM/Scheduler_setting/mom_priv/epilogue  */
			String remoteWorkDir2 = String.format("~/%s", remoteWorkDir);
			String simpostPath = String.format("%ssimpost", remoteWorkDir2);

			s = String.format("if [ -f " + "%s ]; then", simpostPath);
			out.write(s);
			out.newLine();
			
			s = "	cd " + remoteWorkDir2;
			out.write(s);
			out.newLine();

		    s = "	/bin/bash " + simpostPath;
		    out.write(s);
			out.newLine();
			s= "fi";
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
		if (job == null) {
			return null;
		}

		String scriptPath = null;
		NonSharePBSProJob submittedJob = null;

		if (job.getType() instanceof Job.JobType) {
			if (job.getType().equals(Job.JobType.PARALLEL)) {
				if(!(job.getCategory() instanceof Job.JobCategory)) {
					job.setState(Job.JobState.SUBMISSION_FAILED);
					return job;
				}
			}
			LOG.info("NSPBSPro makeJobScriptFile");
			scriptPath = makeJobScriptFile(job, cluster);
			if(scriptPath == null) return null;
			File script = new File(scriptPath);
			script.setReadable(true, false);
		} else {
			job.setState(Job.JobState.SUBMISSION_FAILED);
			return job;
		}
		// ...add some scripts here...
		NonSharePBSProJob j = new NonSharePBSProJob(job.getUuid(), scriptPath);
		try {
			LOG.info(job);
			LOG.info(simulationService.getCallback(job.getUuid()));
			if ( simulationService.getCallback(job.getUuid()) != null ) {
				LOG.info("send callback: UPLOAD - " + job.getUuid());
				simulationService.pushCallback2(simulationService.getCallback(job.getUuid()), job, JobState.UPLOAD);
			}
			j.pushFiles(cluster, job);
			String jobId = j.queue(cluster, job);
			//simulationService.getCallback(job.getUuid());
			
			LOG.info("jobId: " + jobId);

			if (jobId != null && !jobId.isEmpty()) {
				LOG.info("call getJobById");
				submittedJob = NonSharePBSProJob.getJobById(cluster, job, jobId);
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
		if ( simulationService.getCallback(job.getUuid()) != null ) {
			LOG.info("send callback: QUEUE - " + job.getUuid());
			simulationService.pushCallback2(simulationService.getCallback(job.getUuid()), job, job.getState());
		}
		return job;
	}

	@Override
	public Job getInformation(User user, Cluster cluster, Job job) {
		if (job == null) {
			return null;
		}
		LOG.info("get information : " + job);
		NonSharePBSProJob j = null;

		try {
			j = NonSharePBSProJob.getJobById(cluster, job, job.getJobId());
			if (j == null || j.getId() == null || j.getId().isEmpty()) {
				LOG.info("NonSharePBSProJob.getJobById return null");
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOG.info("Job Status : " + job);
//		LOG.info("Job Status : " + j);

		JobState newState = lcmState2State(j.getStatus(), j.getExitStatus());
		if ( job.getState() == JobState.QUEUED && newState == JobState.RUNNING ) {
			if ( simulationService.getCallback(job.getUuid()) != null ) {
				LOG.info("send callback: CHANGED to RUNNING - " + job.getUuid());
				simulationService.pushCallback2(simulationService.getCallback(job.getUuid()), job, newState);
			}
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
			if ( job.getState().equals(Job.JobState.SUCCESS) || job.getState().equals(Job.JobState.FAILED) ) {
				if ( simulationService.getCallback(job.getUuid()) != null ) {
					LOG.info("CALLBACK - TRANSFER : " + job.getUuid());
					simulationService.pushCallback2(simulationService.getCallback(job.getUuid()), job, JobState.TRANSFER);
					j.pullFiles(cluster, job, !job.getState().equals(Job.JobState.RUNNING));
					LOG.info("CALLBACK - FINISHED : " + job.getUuid());
					simulationService.pushCallback2(simulationService.getCallback(job.getUuid()), job, job.getState());
				} else {
					j.pullFiles(cluster, job, !job.getState().equals(Job.JobState.RUNNING));
				}
			} else {
				j.pullFiles(cluster, job, !job.getState().equals(Job.JobState.RUNNING));
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
		NonSharePBSProJob j = new NonSharePBSProJob();
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
	
	public SimulationService getSimulationService() {
		return simulationService;
	}

	@Autowired
	public void setSimulationService(SimulationService simulationService) {
		this.simulationService = simulationService;
	}
//	public static void main(String[] args) {
//		
//		User user = new User("hgkim", "password");
//		Cluster cluster = new Cluster();
//		Job job = new Job();
//		
//		cluster.setQueues("workq");
////		cluster.getRuntime()
//		
//		job.setType(Job.JobType.SEQUENTIAL);
//		job.setUuid("111");
//		job.setWorkingDir("./");
//		job.setnProcs(1);
//		job.setExecutable("executable");
//		job.setDependencies(null);
//		job.setExecution("execution");
//		
//		NonSharePBSProJobAdapter pbspro = new RemotePBSProJobAdapter();
//		
//		Job ret_job = pbspro.submit(user, cluster, job);
//
//	}

}
