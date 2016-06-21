package kisti.edison.cloud.plugin.job;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.User;

//import net.neoremind.sshxcute.core.ConnBean;
//import net.neoremind.sshxcute.core.Result;
//import net.neoremind.sshxcute.core.SSHExec;
//import net.neoremind.sshxcute.core.TaskExecFailException;

import org.apache.log4j.Logger;

public class RemoteTorqueJob {
	
	protected final Logger LOG = Logger.getLogger(this.getClass());
	
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
	private String VariablesList="N/A";
	private String exitStatus = "N/A";
//	private static final String CLUSTERFINDWORDS="has been submitted to cluster";

	/**
	 *
	 * @param JobName
	 * @param ShellFile
	 * Creates a new Job.
	 */
	public RemoteTorqueJob(String JobName, String ShellFile)
	{
		this.Name = JobName;
		this.executableFile = ShellFile;

	}
	public RemoteTorqueJob()
	{}
	
	public String queue(Cluster cluster, Job job)
	{
		List<String> cmd = new ArrayList<String>();
		cmd.add("ssh");
		cmd.add("-p");
		cmd.add(cluster.getPort());
		cmd.add(job.getLocalAccount()+"@"+cluster.getIp());
		cmd.add("qsub");
		cmd.add(getExecutableFile());
		
//		LOG.info("qsub cmd: " + cmd.toString());
		
		ProcessBuilder builder = new ProcessBuilder(cmd);
		builder.redirectErrorStream(true);
		Process p = null;
		int retCode = 0;
		byte[] data = null;
		
		try {
			p = builder.start();
			
			retCode = p.waitFor();
			
			if (retCode == (-1)) {
//				LOG.info("ssh_connection_counter: " + ssh_connection_counter);
				LOG.error("ssh qsub submit fail");
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
		jobId = jobId.replaceAll("\\r|\\n", "");
		
		// pattern match 필요함
//		5167.dev211.edison.re.kr
		// http://www.vogella.com/articles/JavaRegularExpressions/article.html
		// [pbs+ssh://150.183.247.33]-[51]
		Pattern pattern = Pattern.compile("^(\\d+)(\\.)(.*)$");
		Matcher matcher = pattern.matcher(jobId);
		
		if (matcher.find() == false)
		{
			LOG.error("ssh qsub error: " + jobId);
			jobId = null;
		}

		return jobId;
//		int port = 22002;
//		port = Integer.parseInt(cluster.getPort());
//
////		LOG.info("user.getUserId(): " + user.getUserId());
//		ConnBean cb = new ConnBean(cluster.getIp(), "root", port, "/root/.ssh/id_rsa");
//		
//		SSHExec ssh = SSHExec.getInstance(cb);
//		boolean ret = ssh.connect();
//		
//		if (ret == false) 
//		{
//			LOG.error("ssh.connect fail");
//			return null;
//		}
//		
//		String cmd = "qsub " + getExecutableFile();
//		LOG.info("cmd: " + cmd);
//		
//		Result res = null;
//		try {
//			res = ssh.exec(cmd);
//		} catch (TaskExecFailException e) {
//			e.printStackTrace();
//			ssh.disconnect();
//			return null;
//		}
//		
//		String jobId = null;
//		if (res.isSuccess)
//		{
////			4070.dev211.edison.re.kr
//			jobId = res.sysout.replaceAll("\\r|\\n", "");
//		}
//		else
//		{
//			LOG.error(res.error_msg);
//		}
//		
//		ssh.disconnect();
//
	}
	
	public Job cancel(User user, Cluster cluster, Job job)
	{
		List<String> cmd = new ArrayList<String>();
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
		int retCode = -1;
		byte[] data = null;
		
		try {
			p = builder.start();
			
			retCode = p.waitFor();
			
			if (retCode == (-1)) {
				LOG.error("ssh qdel cancel fail");
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

//	private void analyzeVariableList(String Variables) {
//
//		String[] vars = Variables.split(",");
//		variables=new HashMap<String, String>();
//		String[] couple;
//		String header,value;
//		for (int i=0;i<vars.length;i++)
//		{
//			couple = vars[i].split("=");
//			header = couple[0].trim();
//			value = couple[1].trim();
//			variables.put(header, value);
//		}
//	}
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
		ArrayList<String> FoundJobs= new ArrayList<String>();
		Process p = Runtime.getRuntime().exec("qstat");
		p.waitFor();

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
		return ((String[]) FoundJobs.toArray(new String[FoundJobs.size()]));

	}
	
//	private static String sagaState2pbsState(String sagaState) {
//		if (sagaState.equals("Done")) {
//			return "C";
//		} else if (sagaState.equals("Running")) {
//			return "R";
//		} else if (sagaState.equals("Pending")) {
//			return "Q";
//		} else if (sagaState.equals("Canceled")) {
//			return "X";
//		} else {
//			return "UNKNOWN";
//		}
//	}

	/***
	 *
	 * @param id Job ID to Fetech
	 * @return Job Information
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws Exception
	 */
	public static RemoteTorqueJob getJobById(Cluster cluster, Job job, String id) throws IOException,InterruptedException,Exception
	{
		Logger LOG2 = Logger.getLogger("getJobById");
		
		String[] Info  = getJobInfo(cluster, job, id);
		
		RemoteTorqueJob j = new RemoteTorqueJob();
		
		if(Info == null) {
//			j.setId(null);
//			return j;
			return null;
		}
		else if ( Info[0].startsWith("Job Id") == false)
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
		
		for (int i=0; i<Info.length; i++)
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

				if (header.equals("Variable_List"))
				{
					while (Info[i+1].startsWith("\t"))
					{
						value += Info[i+1];
						i++;
					}
					value=value.replaceAll("\t", "");
					j.VariablesList=value;
				}
				else if ("Job Id".equals(header))
//					j.setId(value);
					j.setId(id);
				/*
				else if("Job_Name".equals(header))
					j.setName(value);

				else if("Job_Owner".equals(header))
					j.setOwner(value);

				else if("resources_used.cput".equals(header))
					j.setUsedcput(value);

				else if("resources_used.mem".equals(header))
					j.setUsedMem(value);

				else if("resources_used.walltime".equals(header))
					j.setEllapsedTime(value);
				*/
				else if("job_state".equals(header))
					j.setStatus(value);
				/*
				 * 	j.setStatus(sagaState2pbsState(value));
				 */

				/*
				else if("queue".equals(header))
					j.setQueue(value);

				else if("ctime".equals(header))
					j.setCtime(value);

				else if("qtime".equals(header))
					j.setQtime(value);

				else if("mtime".equals(header))
					j.setMtime(value);
				*/
				else if ("start_time".equals(header))
				{
//					System.out.println("start_time: " + value);
					j.setStime(value);
				}
				else if ("comp_time".equals(header))
				{
//					System.out.println("comp_time: " + value);
					j.setComp_time(value);
				}
				else if("exec_host".equals(header))
					j.setExecuteNode(value);
                else if("exit_status".equals(header))
             	   j.setExitStatus(value);

				/*
				else if("Output_Path".equals(header))
				{
					if (Info[i+1].contains("=") || Info[i+1].contains(":"))
						j.setOutputPath(value);
					else
					{
						j.setOutputPath(value + Info[i+1].trim());
						i++;
					}
				}

				else if("Error_Path".equals(header))
				{
					if (Info[i+1].contains("=") || Info[i+1].contains(":"))
						j.setErrrorPath(value);
					else
					{
						String st =Info[i+1].trim();
						j.setErrrorPath(value + st);
						i++;
					}

				}
				else if("submit_args".equals(header))
				{
					while (i+1<Info.length)
					{
						if (Info[i+1].startsWith("\t"))
						{
							value += Info[i+1];
							i++;
						}
						else
							break;
					}
					value=value.replaceAll("\t", "");
					j.setSubmitArgs (value);
				}
				*/
			}
		}
		return j;
	}

	private static String[] getJobInfo(Cluster cluster, Job job, String JobID) throws Exception
	{
		/*
		 * id : 4070.dev211.edison.re.kr
		 * return:
		 *  monitorscript execution result
		 * 	null : when error
		 */
		Logger LOG2 = Logger.getLogger("TEMP");

//		ssh -p 22002 150.183.247.211 "/usr/local/bin/qstat -f 4083"
//		StringBuilder command usage
//		http://egloos.zum.com/lempel/v/10961361
		List<String> cmd = new ArrayList<String>();
		cmd.add("ssh");
		cmd.add("-p");
		cmd.add(cluster.getPort());
		cmd.add(job.getLocalAccount()+"@"+cluster.getIp());
		cmd.add("/usr/local/bin/qstat");
		cmd.add("-f");
		cmd.add(JobID);
		
//		LOG2.info("qstat cmd: " + cmd.toString());
		
		ProcessBuilder builder = new ProcessBuilder(cmd);
		builder.redirectErrorStream(true);
		
		Process p = null;
		int retCode = 0;
		byte[] data = null;
		
		p = builder.start();
		retCode = p.waitFor();

		if (retCode == (-1)) {
			LOG2.error("ssh qstat fail");
			return null;
		}
		
		BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
		data = new byte[ef.available()];
		ef.read(data, 0, ef.available());
		ef.close();
		p.getInputStream().close();
		p.getOutputStream().close();
		p.getErrorStream().close();
		
		String Result = new String(data);
//		LOG2.info("qstat result: " + Result);
		return Result.split("\n");
//		ConnBean cb = new ConnBean(cluster.getIp(), "root", port, "/root/.ssh/id_rsa");
//		
//		SSHExec ssh = SSHExec.getInstance(cb);
//		boolean ret = ssh.connect();
//		
//		if (ret == false) 
//		{
//			LOG2.error("ssh.connect fail");
//			return null;
//		}
//		
//		String cmd = "/usr/local/bin/qstat.py " + JobID;
//		LOG2.info("cmd: " + cmd);
//		
//		Result res = null;
//		try {
//			res = ssh.exec(cmd);
//		} catch (TaskExecFailException e) {
//			e.printStackTrace();
//			ssh.disconnect();
//			return null;
//		}
//		
//		String Result = null;
//		if (res.isSuccess)
//		{
//			Result = res.sysout;
//			LOG2.info("Result: " + Result);
//		}
//		else
//		{
//			LOG2.error(res.error_msg);
//		}
//		
//		ssh.disconnect();

//		if ( Result != null )
//			return Result.split("\n");
//		else
//			return null;
	}

//	public static String getJobStatus(String JobID, String clusterName, User user) throws Exception
//	{
//
//		String[] Info =  getJobInfo(JobID, user);
//
//		String[] infoArray = Info[Info.length-1].split("!");
//
//		String value=infoArray[0];
//
//		return value;
//	}
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
//		sb.append("ctime: " + this.ctime+"\n");
//		sb.append("qtime:" + qtime+"\n");
//		sb.append("mtime: " + mtime+"\n");
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