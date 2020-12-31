package kisti.edison.cloud.plugin.job;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.apache.commons.codec.binary.Base64;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.util.AuthUtils;

public class NonSharePBSProJob {
	
	protected final Logger LOG = Logger.getLogger(this.getClass());
	
	private String key = Cloud.getInstance().getProp("user.admin.password");
	
	private String id;
	private String Name="N/A";
	private String nodes="N/A";
	private String ppn="N/A";
	private ArrayList<String> afterany=new ArrayList<String>();
	private ArrayList<String> afterOK=new ArrayList<String>();
	private HashMap<String,String> variables=new HashMap<String, String>();
	private String SubmitArgs="N/A";
	private String ctime="N/A";
	private String qtime="N/A";
	private String mtime="N/A";
	private String stime="N/A";
	private String comp_time="N/A";

	private String owner="N/A";
	private String executableFile="N/A";
	private String wallTime="N/A";
	private String queue="N/A";
	private String status="N/A";
	private String executeNode="N/A";
	private String ellapsedTime="N/A";
	private String usedMem="N/A";
	private String usedcput="N/A";
	private String errrorPath="N/A";
	private String outputPath="N/A";
	private String exitStatus = "N/A";

	/**
	 *
	 * @param JobName
	 * @param ShellFile
	 * Creates a new Job.
	 */
	public NonSharePBSProJob(String JobName, String ShellFile)
	{
		this.Name = JobName;
		this.executableFile = ShellFile;

	}
	public NonSharePBSProJob()
	{}
	
	public void pushFiles(Cluster cluster, Job job) {
		List<String> cmd = new ArrayList<String>();
		ProcessBuilder builder = null;
		Process p = null;
		boolean retCode = false;
		byte[] data = null;
		Base64 base64 = new Base64(180, "".getBytes());

		LOG.info("pushFile - " + job.getSimulation().getUuid() + " ]");
		String remoteWorkDir = String.format("scratch/%s", job.getWorkingDir().replaceAll("^.+?(" + job.getUserId() + ".+)","$1"));
		
		cmd.add("nurionssh");
		cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemotePW(), key)));
		cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemoteOTP(), key)));
		cmd.add("ssh");
		cmd.add("-p");
		cmd.add(cluster.getPort());
		cmd.add(cluster.getRemoteId()+"@"+cluster.getIp());
		cmd.add("mkdir");
		cmd.add("-p");
		cmd.add(remoteWorkDir);
//		LOG.info("remote mkdir cmd: " + cmd.toString());
		builder = new ProcessBuilder(cmd);
		builder.redirectErrorStream(true);
		try {
			p = builder.start();
			retCode = p.waitFor(15, TimeUnit.SECONDS);
			if (retCode == false) {
				// http://www.java2s.com/example/java-api/java/lang/process/waitfor-2-1.html
				if (p.isAlive()) p.destroyForcibly();
				cmd.set(1, "***");
				cmd.set(2, "***");
				LOG.error(cmd.toString() + " fail");
				return;
			}
			BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
			data = new byte[ef.available()];
			ef.read(data, 0, ef.available());
			ef.close();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cmd = new ArrayList<String>();
		cmd.add("nurionssh");
		cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemotePW(), key)));
		cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemoteOTP(), key)));
		cmd.add("scp");
		cmd.add("-C");
		cmd.add("-P");
		cmd.add(cluster.getPort());
		cmd.add(getExecutableFile());
		cmd.add(cluster.getRemoteId()+"@"+cluster.getIp() + ":" + remoteWorkDir);
//		LOG.info("remote push script: " + cmd.toString());
		builder = new ProcessBuilder(cmd);
		builder.redirectErrorStream(true);
		try {
			p = builder.start();
			retCode = p.waitFor(15, TimeUnit.SECONDS);
			if (retCode == false) {
				if (p.isAlive()) p.destroyForcibly();
				cmd.set(1, "***");
				cmd.set(2, "***");
				LOG.error(cmd.toString() + " fail");
				return;
			}
			BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
			data = new byte[ef.available()];
			ef.read(data, 0, ef.available());
			ef.close();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (String base64FilePath : job.getFiles().values()) {
			String filePath = new String(base64.decode(base64FilePath));
			
			// TODO
			if ( filePath.endsWith("directory") ) {
				/*
				 *
				 */
				String filePath2 = null;
				String remoteWorkDir2 = null;
				File src = new File(filePath);
				List<String> lines = null;

				try {
					lines = FileUtils.readLines(src, "UTF-8");
			        filePath2 = lines.get(0);
			        remoteWorkDir2 = String.format("scratch/%s", filePath2.replaceAll("^.+?(" + job.getUserId() + ".+)","$1"));
			        LOG.info("remoteWorkDir" + remoteWorkDir2);

			        // mkdir remote directory in 5th supercomputer
			        cmd.clear();
					cmd.add("nurionssh");
					cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemotePW(), key)));
					cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemoteOTP(), key)));
					cmd.add("ssh");
					cmd.add("-p");
					cmd.add(cluster.getPort());
					cmd.add(cluster.getRemoteId()+"@"+cluster.getIp());
					cmd.add("mkdir");
					cmd.add("-p");
					cmd.add(remoteWorkDir2);
//					LOG.info("remote mkdir cmd: " + cmd.toString());
					builder = new ProcessBuilder(cmd);
					builder.redirectErrorStream(true);
					
					p = builder.start();
					retCode = p.waitFor(15, TimeUnit.SECONDS);
					if (retCode == false) {
						// http://www.java2s.com/example/java-api/java/lang/process/waitfor-2-1.html
						if (p.isAlive()) p.destroyForcibly();
						cmd.set(1, "***");
						cmd.set(2, "***");
						LOG.error(cmd.toString() + " fail");
						return;
					}
					BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
					data = new byte[ef.available()];
					ef.read(data, 0, ef.available());
					ef.close();
					p.getInputStream().close();
					p.getOutputStream().close();
					p.getErrorStream().close();
					
					String remoteWorkDir3 = remoteWorkDir2.replaceAll("result$", "");
					// copy files - scp -r
					cmd.clear();
					cmd.add("nurionssh");
					cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemotePW(), key)));
					cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemoteOTP(), key)));
					cmd.add("scp");
					cmd.add("-C");
					cmd.add("-r");
					cmd.add("-P");
					cmd.add(cluster.getPort());
					cmd.add(filePath2);
					cmd.add(cluster.getRemoteId() + "@" + cluster.getIp() + ":" + remoteWorkDir3);
		//			LOG.info("remote push script: " + cmd.toString());
					builder = new ProcessBuilder(cmd);
					builder.redirectErrorStream(true);
					
					p = builder.start();
					//retCode = p.waitFor(15, TimeUnit.SECONDS);
					retCode = p.waitFor(5, TimeUnit.MINUTES);
					if (retCode == false) {
						if (p.isAlive()) p.destroyForcibly();
						cmd.set(1, "***");
						cmd.set(2, "***");
						LOG.error(cmd.toString() + " fail");
						return;
					}
					ef = new BufferedInputStream(p.getInputStream());
					data = new byte[ef.available()];
					ef.read(data, 0, ef.available());
					ef.close();
					p.getInputStream().close();
					p.getOutputStream().close();
					p.getErrorStream().close();
					
					// create new directory file and upload it
					remoteWorkDir2 = "~/" + remoteWorkDir2; 
			        
			        File file = File.createTempFile("temp", null);
			        String tmpFilePath = file.getAbsolutePath();
			        FileUtils.writeStringToFile(file, remoteWorkDir2, "UTF-8");
			        
			        cmd.clear();
					cmd.add("nurionssh");
					cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemotePW(), key)));
					cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemoteOTP(), key)));
					cmd.add("scp");
					cmd.add("-C");
//					cmd.add("-r");
					cmd.add("-P");
					cmd.add(cluster.getPort());
					cmd.add(tmpFilePath);
					cmd.add(cluster.getRemoteId() + "@" + cluster.getIp() + ":" + remoteWorkDir + "directory");
		//			LOG.info("remote push script: " + cmd.toString());
					builder = new ProcessBuilder(cmd);
					builder.redirectErrorStream(true);
					
					p = builder.start();
					retCode = p.waitFor(15, TimeUnit.SECONDS);
					if (retCode == false) {
						if (p.isAlive()) p.destroyForcibly();
						cmd.set(1, "***");
						cmd.set(2, "***");
						LOG.error(cmd.toString() + " fail");
						return;
					}
					ef = new BufferedInputStream(p.getInputStream());
					data = new byte[ef.available()];
					ef.read(data, 0, ef.available());
					ef.close();
					p.getInputStream().close();
					p.getOutputStream().close();
					p.getErrorStream().close();
		        
//			        file.deleteOnExit();
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	
				
			}
			/*
			 * filePath not "directory"
			 */
			else {
				cmd = new ArrayList<String>();
				cmd.add("nurionssh");
				cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemotePW(), key)));
				cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemoteOTP(), key)));
				cmd.add("scp");
				cmd.add("-C");
				cmd.add("-r");
				cmd.add("-P");
				cmd.add(cluster.getPort());
				cmd.add(filePath);
				cmd.add(cluster.getRemoteId() + "@" + cluster.getIp() + ":" + remoteWorkDir);
	//			LOG.info("remote push script: " + cmd.toString());
				builder = new ProcessBuilder(cmd);
				builder.redirectErrorStream(true);
				try {
					p = builder.start();
					retCode = p.waitFor(15, TimeUnit.SECONDS);
					if (retCode == false) {
						if (p.isAlive()) p.destroyForcibly();
						cmd.set(1, "***");
						cmd.set(2, "***");
						LOG.error(cmd.toString() + " fail");
						return;
					}
					BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
					data = new byte[ef.available()];
					ef.read(data, 0, ef.available());
					ef.close();
					p.getInputStream().close();
					p.getOutputStream().close();
					p.getErrorStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void pullFiles(Cluster cluster, Job job, boolean finished) {
		List <String> files = new ArrayList <String>();
		files.add(job.getUuid() + ".out");
		files.add(job.getUuid() + ".err");
		if ( finished ) {
			files.add("result");
		}
		for ( String fileName : files ) {
			pullFiles(cluster, job, fileName);
		}
	}

	public void pullFiles(Cluster cluster, Job job, String fileName) {
		List<String> cmd = new ArrayList<String>();
		ProcessBuilder builder = null;
		Process p = null;
		boolean retCode = false;
		byte[] data = null;

		LOG.info("pullFile - from " + fileName + " to " + job.getWorkingDir());
		String remoteWorkDir = String.format("scratch/%s", job.getWorkingDir().replaceAll("^.+?(" + job.getUserId() + ".+)","$1"));
		
		cmd = new ArrayList<String>();
		cmd.add("nurionssh");
		cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemotePW(), key)));
		cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemoteOTP(), key)));
		cmd.add("scp");
		cmd.add("-C");
		cmd.add("-r");
		cmd.add("-P");
		cmd.add(cluster.getPort());
		cmd.add(cluster.getRemoteId()+"@"+cluster.getIp() + ":" + remoteWorkDir + "/" + fileName);
		cmd.add(job.getWorkingDir());
		//LOG.info("remote pull script: " + cmd.toString());
		builder = new ProcessBuilder(cmd);
		builder.redirectErrorStream(true);
		try {
			p = builder.start();
			/*
			 * TODO
			 * 큰 파일의 경우 문제 계속 발생할 수 있음
			 */
			retCode = p.waitFor(15, TimeUnit.MINUTES);
			if (retCode == false) {
				if (p.isAlive()) p.destroyForcibly();
				cmd.set(1, "***");
				cmd.set(2, "***");
				LOG.info(cmd.toString() + " fail");
				return;
			}
			BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
			data = new byte[ef.available()];
			ef.read(data, 0, ef.available());
			ef.close();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String queue(Cluster cluster, Job job)
	{
		LOG.info("queuing");
		String remoteWorkDir = String.format("scratch/%s", job.getWorkingDir().replaceAll("^.+?(" + job.getUserId() + ".+)","$1"));
		//
		//pushFiles(cluster, job);
		//
		List<String> cmd = new ArrayList<String>();
		cmd.add("nurionssh");
		cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemotePW(), key)));
		cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemoteOTP(), key)));
		cmd.add("ssh");
		cmd.add("-p");
		cmd.add(cluster.getPort());
//		cmd.add("-i");
//		cmd.add(job.getWorkingDir()+"/../../../.ssh/id_rsa");
		cmd.add(cluster.getRemoteId()+"@"+cluster.getIp());
		cmd.add("~/bin/qsub");
		cmd.add(remoteWorkDir + "/" + FilenameUtils.getName(getExecutableFile()));
		
		//LOG.info("qsub cmd: " + cmd.toString());
		
		ProcessBuilder builder = new ProcessBuilder(cmd);
		builder.redirectErrorStream(true);
		Process p = null;
		boolean retCode = false;
		byte[] data = null;
		
		try {
			p = builder.start();
			
			retCode = p.waitFor(15, TimeUnit.SECONDS);
			
			if (retCode == false) {
//				LOG.info("ssh_connection_counter: " + ssh_connection_counter);
				if (p.isAlive()) p.destroyForcibly();
				cmd.set(1, "***");
				cmd.set(2, "***");
				LOG.error("ssh qsub submit fail" + cmd.toString());
				return null;
			}
			
			BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
			data = new byte[ef.available()];
			ef.read(data, 0, ef.available());
			ef.close();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String jobId = new String(data);
		//jobId = jobId.replaceAll("\\r|\\n", "");
		
		// pattern match 필요함
//		5167.dev211.edison.re.kr
		// http://www.vogella.com/articles/JavaRegularExpressions/article.html
		// [pbs+ssh://150.183.247.33]-[51]
		Pattern pattern = Pattern.compile("(?:^|[\\r\\n]+)((\\d+)(\\.)(.*))(?:[\\r\\n]+|$)");
		Matcher matcher = pattern.matcher(jobId);
		
		if (matcher.find() == false) {
			LOG.error("ssh qsub error: " + jobId);
			jobId = null;
		} else {
			jobId = matcher.group(1);
			jobId = jobId.replaceAll("\\r|\\n", "");
		}

		return jobId;
	}
	
	public Job cancel(User user, Cluster cluster, Job job)
	{
		List<String> cmd = new ArrayList<String>();
		cmd.add("nurionssh");
		cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemotePW(), key)));
		cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemoteOTP(), key)));
		cmd.add("ssh");
		cmd.add("-p");
		cmd.add(cluster.getPort());
		cmd.add(cluster.getIp());
		cmd.add("qdel");
		cmd.add(job.getJobId());
		
//		LOG.info("qdel cmd: " + cmd.toString());
		
		ProcessBuilder builder = new ProcessBuilder(cmd);
		builder.redirectErrorStream(true);
		Process p = null;
		boolean retCode = false;
		byte[] data = null;
		
		try {
			p = builder.start();
			
			retCode = p.waitFor(15, TimeUnit.SECONDS);
			
			if (retCode == false) {
				if (p.isAlive()) p.destroyForcibly();
				cmd.set(1, "***");
				cmd.set(2, "***");
				LOG.error("ssh qdel cancel fail" + cmd.toString());
				return null;
			}
			
			BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
			data = new byte[ef.available()];
			ef.read(data, 0, ef.available());
			ef.close();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
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

	/**
	 *
	 * @param Name : Name to find
	 * @param ExactMatch : if exact match is required
	 * @return Array of found Jobs IDs
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static String[] SearchJobsByName(String Name, Boolean ExactMatch) throws IOException, InterruptedException
	{
		Logger LOG2 = Logger.getLogger("SearchJobsByName");
		
		ArrayList<String> FoundJobs= new ArrayList<String>();
		Process p = Runtime.getRuntime().exec("qstat");
		boolean retCode = p.waitFor(15, TimeUnit.SECONDS);
		
		if (retCode == false) {
			if (p.isAlive()) p.destroyForcibly();
			LOG2.error("ssh qstat fail");
			return null;
		}

		BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
		byte[] data = new byte[ef.available()];
		ef.read(data, 0, ef.available());
		ef.close();
		p.getInputStream().close();
		p.getOutputStream().close();
		p.getErrorStream().close();
		String Result = new String(data);
		String[] Jobs  = Result.split("\n");
		String JobName;
		for (int i=2; i<Jobs.length; i++)
		{

			JobName = Jobs[i].substring(25,Jobs[i].indexOf(" ", 26));
			JobName=JobName.trim();

			if (ExactMatch)
			{
				if (JobName.equalsIgnoreCase(Name))
				{
					//System.out.println("Found: " + JobName);

					FoundJobs.add(Jobs[i].substring(0,Jobs[i].indexOf(" ")));
				}
			}
			else
			{
				if (JobName.indexOf(Name)>-1)
				{
					//FoundJobs.add(JobName);
					String JID = Jobs[i].substring(0,Jobs[i].indexOf(" "));
					FoundJobs.add(JID);
					//System.out.println("F: "+ JID);
				}
			}
		}
		return FoundJobs.toArray(new String[FoundJobs.size()]);

	}

	
	/***
	 *
	 * @param id : pbspro job id - 11.v8a081
	 * @return Job Information
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws Exception
	 */
	public static NonSharePBSProJob getJobById(Cluster cluster, Job job, String id) throws IOException,InterruptedException,Exception
	{
		Logger LOG2 = Logger.getLogger("getJobById");
		
		String[] Info  = getJobInfo(cluster, job, id);
		
		NonSharePBSProJob j = new NonSharePBSProJob();
		
		if(Info == null) {
//			j.setId(null);
//			return j;
			return null;
		}
		else if ( Info[3].startsWith("Job Id") == false)
		{
//			LOG2.error("ssh_connection_counter: " + ssh_connection_counter);
//			LOG2.error("ssh qstat fail: String[] info - " + Info.toString());
			for (String str : Info) {
				LOG2.error("ssh qstat fail: String - " + str);
			}
			return null;
		}
		
		String header = "";
		String value="";
		String[] line;
		
		for (int i=3; i<Info.length; i++)
		{
//			System.out.println("DEBUG: " + Info[i]);
			
			if (Info[i].contains("="))
			{
				line=Info[i].split("=",2);
			}
			else
			{
				line=Info[i].split(":",2);
			}
			if (line.length>=2)
			{
				header = line[0].trim();
				// System.out.println("Header = " + header);
				value = line[1].trim();
				// System.out.println("value = " + value);

				if ("Job Id".equals(header))
					j.setId(id);
				else if("job_state".equals(header))
					j.setStatus(value);
				else if ("stime".equals(header))
				{
//					System.out.println("start_time: " + value);
					j.setStime(value);
				}
				else if ("mtime".equals(header))
				{
//					System.out.println("comp_time: " + value);
					j.setComp_time(value);
				}
				else if("exec_host".equals(header))
					j.setExecuteNode(value);
                else if("Exit_status".equals(header))
             	   j.setExitStatus(value);

			}
		}
		return j;
	}

	private static String[] getJobInfo(Cluster cluster, Job job, String JobID) throws Exception
	{
		/*
		 * id : 11.v8a081
		 * return:
		 *  monitorscript execution result
		 * 	null : when error
		 */
		Logger LOG2 = Logger.getLogger("NonSharePBSProJob");
		String key2 = Cloud.getInstance().getProp("user.admin.password");

//		ssh -p 22002 150.183.247.211 "/usr/local/bin/qstat -f 4083"
//		StringBuilder command usage
//		http://egloos.zum.com/lempel/v/10961361
		String userId = cluster.getRemoteId();
		List<String> cmd = new ArrayList<String>();
		cmd.add("nurionssh");
		cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemotePW(), key2)));
		cmd.add(String.format("%s", AuthUtils.decrypt(cluster.getRemoteOTP(), key2)));
		cmd.add("ssh");
		cmd.add("-p");
		cmd.add(cluster.getPort());
		cmd.add(userId + "@"+cluster.getIp());
//		cmd.add(job.getLocalAccount()+"@"+cluster.getIp());
//		cmd.add("/usr/local/bin/qstat");
		cmd.add("/opt/pbs/bin/qstat");
		cmd.add("-xfw");
		cmd.add(JobID);
		
//		LOG2.info("qstat cmd: " + cmd.toString());
		/*
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
		
		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		
		CommandLine cmdLine = CommandLine.parse(cmd.get(0));
		for (int i=1, n=cmd.size() ; i<n ; i++ ) {
	        cmdLine.addArgument(cmd.get(i));
	    }
		
		int exitValue = -1;
		try {
			exitValue = executor.execute(cmdLine);
		} catch (ExecuteException e) {
			LOG2.error("qstat -xfw command fail");
			LOG2.error("ssh cmd: " + cmd.toString());
		} catch (IOException e) {
			LOG2.error("qstat -xfw command fail, IOException");
		}
		LOG2.info("exit value: " + exitValue);
		
		String Result = outputStream.toString();
		*/

		
		ProcessBuilder builder = new ProcessBuilder(cmd);
		builder.redirectErrorStream(true);
		Process p = null;
		boolean retCode = false;
		byte[] data = null;
		
		try {
			p = builder.start();
			
			retCode = p.waitFor(15, TimeUnit.SECONDS);
			
			if (retCode == false) {
				// http://www.java2s.com/example/java-api/java/lang/process/waitfor-2-1.html
				if (p.isAlive()) p.destroyForcibly();
				//				LOG.info("ssh_connection_counter: " + ssh_connection_counter);
				LOG2.info("ssh qstat fail:" + JobID);
				return null;
			}
			
			BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
			data = new byte[ef.available()];
			ef.read(data, 0, ef.available());
			ef.close();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String Result = new String(data);
		
//		LOG2.info("qstat result: " + Result);
		return Result.split("\n");
	}


	/**
	 *
	 * @return String Representation of a Job
	 */
	@Override
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("Job ID: " + this.id + "\n");
		sb.append("Job Name: " + this.Name + "\n");
		sb.append("Job Owner: " + this.owner + "\n");
		sb.append("Job Status: " + this.status + "\n");
		sb.append("Job Queue: " + this.queue + "\n");
		sb.append("\n");
		sb.append("Resources\n");
		sb.append("CPU Time: " + this.usedcput + "\n");
		sb.append("Mem Used: " + this.usedMem + "\n");
		sb.append("Used WallTime: " + this.ellapsedTime + "\n");
		sb.append("execute Node : " + this.executeNode+"\n");
		sb.append("\nTimes:\n");
		sb.append("stime: " + this.stime+"\n");
		sb.append("comp_time: " + this.comp_time+"\n");
		sb.append("\n");
		sb.append("Files\n");
		sb.append("Output File: " + this.outputPath + "\n");
		sb.append("Error File: " + this.errrorPath + "\n");
		return sb.toString();
	}
	/**
	 *
	 * @return HTML Format of toString()
	 */
	public String toHTMLString()
	{
		StringBuffer sb = new StringBuffer("<html>");
		sb.append("Job ID: " + this.id + "<br/>");
		sb.append("Job Name: " + this.Name + "<br/>");
		sb.append("Job Owner: " + this.owner + "<br/>");
		sb.append("Job Status: " + this.status + "<br/>");
		sb.append("Job Queue: " + this.queue + "<br/>");
		sb.append("<br/>");
		sb.append("<b>Resources:</b><br/>");
		sb.append("CPU Time: " + this.usedcput + "<br/>");
		sb.append("Mem Used: " + this.usedMem + "<br/>");
		sb.append("Used WallTime: " + this.ellapsedTime + "<br/>");
		sb.append("execute Node : " + this.executeNode+"<br/>");
		sb.append("<br/>");
		sb.append("<b>Times:</b><br/>");
		sb.append("ctime: " + this.ctime+"<br/>");
		sb.append("qtime:" + qtime+"<br/>");
		sb.append("mtime: " + mtime+"<br/>");
		sb.append("<b>Files</b><br/>");
		sb.append("Output File: " + this.outputPath + "<br/>");
		sb.append("Error File: " + this.errrorPath + "<br/>");
		sb.append("<b>Submit args:</b>" + SubmitArgs+"<br/>");
		String st = "";
		String[] keys = variables.keySet().toArray(new String[variables.keySet().size()]);

		for (int i=0; i<keys.length; i++)
		{
			st +=  "    " + keys[i] + " : "  + variables.get(keys[i]) + "<br/>";
		}
		sb.append("<b>VariableList: </b>" + st +"<br/>");

		sb.append("</html>");
		return sb.toString();
	}
	/**
	 * @return the nodes
	 */
	public String getNodes() {
		return nodes;
	}

	/**
	 * @param nodes the nodes to set
	 */
	public void setNodes(String nodes) {
		this.nodes = nodes;
	}

	/**
	 * @return the ppn
	 */
	public String getPpn() {
		return ppn;
	}

	/**
	 * @param ppn the ppn to set
	 */
	public void setPpn(String ppn) {
		this.ppn = ppn;
	}

	/**
	 * @return the executableFile
	 */
	public String getExecutableFile() {
		return executableFile;
	}

	/**
	 * @param executableFile the executableFile to set
	 */
	public void setExecutableFile(String executableFile) {
		this.executableFile = executableFile;
	}

	/**
	 * @return the wallTime
	 */
	public String getWallTime() {
		return wallTime;
	}

	/**
	 * @param wallTime the wallTime to set
	 */
	public void setWallTime(String wallTime) {
		this.wallTime = wallTime;
	}

	/**
	 * @return the queue
	 */
	public String getQueue() {
		return queue;
	}

	/**
	 * @param queue the queue to set
	 */
	public void setQueue(String queue) {
		this.queue = queue;
	}

	/**
	 * @return the executeNode
	 */
	public String getExecuteNode() {
		return executeNode;
	}

	/**
	 * @param executeNode the executeNode to set
	 */
	public void setExecuteNode(String executeNode) {
		this.executeNode = executeNode;
	}

	/**
	 * @return the ellapsedTime
	 */
	public String getEllapsedTime() {
		return ellapsedTime;
	}

	/**
	 * @param ellapsedTime the ellapsedTime to set
	 */
	public void setEllapsedTime(String ellapsedTime) {
		this.ellapsedTime = ellapsedTime;
	}

	/**
	 * @return the usedMem
	 */
	public String getUsedMem() {
		return usedMem;
	}

	/**
	 * @param usedMem the usedMem to set
	 */
	public void setUsedMem(String usedMem) {
		this.usedMem = usedMem;
	}

	/**
	 * @return the usedcput
	 */
	public String getUsedcput() {
		return usedcput;
	}

	/**
	 * @param usedcput the usedcput to set
	 */
	public void setUsedcput(String usedcput) {
		this.usedcput = usedcput;
	}

	/**
	 * @return the errrorPath
	 */
	public String getErrrorPath() {
		return errrorPath;
	}

	/**
	 * @param errrorPath the errrorPath to set
	 */
	public void setErrrorPath(String errrorPath) {
		this.errrorPath = errrorPath;
	}

	/**
	 * @return the outputPath
	 */
	public String getOutputPath() {
		return outputPath;
	}

	/**
	 * @param outputPath the outputPath to set
	 */
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	/**
	 * @return the afterany
	 */
	public ArrayList<String> getAfterany() {
		return afterany;
	}

	/**
	 * @param afterany the afterany to set
	 */
	public void setAfterany(ArrayList<String> afterany) {
		this.setAfterany(afterany);
	}


	/**
	 * @return the afterOK
	 */
	public ArrayList<String> getAfterOK() {
		return afterOK;
	}

	/**
	 * @param afterOK the afterOK to set
	 */
	public void setAfterOK(ArrayList<String> afterok) {
		this.afterOK =afterok;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the Name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param Name the Name to set
	 */
	public void setName(String Name) {
		this.Name = Name;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the time the job was created
	 */
	public String getCtime() {
		return ctime;
	}

	/**
	 * @return the time the job was queued
	 */
	public String getQtime() {
		return qtime;
	}

	/**
	 * @return the last time the job is modified
	 */
	public String getMtime() {
		return mtime;
	}


	/**
	 * @param ctime the ctime to set
	 */
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	/**
	 * @param qtime the qtime to set
	 */
	public void setQtime(String qtime) {
		this.qtime = qtime;
	}

	/**
	 * @param mtime the mtime to set
	 */
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}

	public void setVariables(HashMap<String, String> variables) {
		this.variables = variables;
	}

	public HashMap<String, String> getVariables() {
		return variables;
	}

	public Boolean isComplete()
	{
		if ("C".equals(this.status))
			return true;
		else
			return false;
	}
	public String Duration()
	{
		DateFormat df = DateFormat.getTimeInstance(DateFormat.FULL);
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		try
		{
			Date date1 = df.parse(this.ctime);
			Date date2 = df.parse(this.mtime);
			long remainder = date2.getTime() - date1.getTime();
			return df.format(remainder);
		}
		catch(Exception exp)
		{
			return null;
		}

	}

	public String getSubmitArgs() {
		return SubmitArgs;
	}

	public void setSubmitArgs(String SubmitArgs) {
		this.SubmitArgs = SubmitArgs;
	}

	/**
	 * @return the stime
	 */
	public String getStime() {
		return stime;
	}

	/**
	 * @param stime the stime to set
	 */
	public void setStime(String stime) {
		this.stime = stime;
	}

	/**
	 * @return the comp_time
	 */
	public String getComp_time() {
		return comp_time;
	}

	/**
	 * @param comp_time the comp_time to set
	 */
	public void setComp_time(String comp_time) {
		this.comp_time = comp_time;
	}

	/** add by hgkim 2013/04/02
	 */
	public String getExitStatus()
	{
		return exitStatus;
	}

	public void setExitStatus(String exitStatus)
	{
		this.exitStatus = exitStatus;
	}

}
