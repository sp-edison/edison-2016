package kisti.edison.cloud.plugin.job;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.UUID;

import org.apache.log4j.Logger;

public class sagaJob {
	
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
//	private String VariablesList="N/A";
	private String exitStatus = "N/A";
//	private static final String CLUSTERFINDWORDS="has been submitted to cluster";

	/**
	 *
	 * @param JobName
	 * @param ShellFile
	 * Creates a new Job.
	 */
	public sagaJob(String JobName, String ShellFile)
	{
		this.Name = JobName;
		this.executableFile = ShellFile;

	}
	public sagaJob()
	{}
	/**
	 *
	 * @return Job ID in the Server
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws Exception
	 *
	 * Add this Job to the Scheduler Queue.
	 */
	public String queue() throws IOException,InterruptedException,Exception
	{
		//StringBuilder excuter = new StringBuilder("/opt/python2.7.1/bin/python");
		StringBuilder excuter = new StringBuilder("python");

		excuter.append(" " + getExecutableFile());
		String st = excuter.toString();

		ProcessBuilder builder = new ProcessBuilder(st.split(" "));
		builder.redirectErrorStream(true);
		Process p = builder.start();

		int retCode = p.waitFor();

		if(retCode != 0) {
			LOG.debug("============ PYTHON SUBMIT SCRIPT RETURN NOT ZERO ==================");
			LOG.debug("============ PYTHON SUBMIT SCRIPT RETURN NOT ZERO ==================");
			LOG.debug("============ PYTHON SUBMIT SCRIPT RETURN NOT ZERO ==================");
		}
		// pbs4java-style
		/*
		BufferedInputStream errStream = new BufferedInputStream(p.getErrorStream());
		if (errStream.available()>0)
		{
			byte[] errdata = new byte[errStream.available()];
			errStream.read(errdata, 0, errStream.available());
			p.getOutputStream().close();
			p.getErrorStream().close();
			errStream.close();
			//String st = new String(errdata);
			throw new Exception(new String(errdata));

		}
		BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
		byte[] data = new byte[ef.available()];
		ef.read(data, 0, ef.available());
		ef.close();
		p.getOutputStream().close();
		p.getErrorStream().close();
		String Result = new String(data);
		*/

		/*
		 * [pbs+ssh://150.183.247.33]-[51]
		 */
		InputStream is = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		StringBuilder jobId = new StringBuilder("");
		String line=null;

		while ((line = br.readLine()) != null) {
			jobId.append(line);
		}

//		System.out.print("DEBUG:");
//		System.out.println(jobId.toString());

		
		p.getInputStream().close();
		p.getOutputStream().close();
		p.getErrorStream().close();
		br.close();
		isr.close();
		is.close();
		is = null;
		isr = null;
		br = null;
		
		return new String(jobId.toString());
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
	public static sagaJob getJobById(String id, String userid) throws IOException,InterruptedException,Exception
	{
		// id: [pbs+ssh://150.183.247.33]-[51]
		String[] Info  = getJobInfo(id, userid);
		
		sagaJob j = new sagaJob();
		
		if(Info == null) {
			j.setId(null);
			return j;
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

//				if (header.equals("Variable_List"))
//				{
//					while (Info[i+1].startsWith("\t"))
//					{
//						value += Info[i+1];
//						i++;
//					}
//					value=value.replaceAll("\t", "");
//					j.VariablesList=value;
//				}
				if ("Job Id".equals(header))
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
	
	private static String makeMonitorScriptFile(String rm, String jobid, String userid) {

		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String prefix="/tmp/" + uuid; 
		
		String filePath = prefix + "-qstat-script";
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			
			String s = "import os";
			out.write(s);
			out.newLine();
			
			//////////////////////////////////////////
			s = "import time";
			out.write(s);
			out.newLine();
			
			s = "import threading";
			out.write(s);
			out.newLine();
			
			out.newLine();
			
			s = "class _state_monitor(threading.Thread):";
			out.write(s);
			out.newLine();
			
			s = "    def run(self):";
			out.write(s);
			out.newLine();
			
			s = "        time.sleep(60)"; // timeout 60 seconds (1 min)
			out.write(s);
			out.newLine();
			
			s = "        import radical.utils.logger as rul";
			out.write(s);
			out.newLine();
			
			s = "        _logger  = rul.getLogger ('saga', 'qstat')";
			out.write(s);
			out.newLine();

			s = "        _logger.error('ssh infinite loop')";
			out.write(s);
			out.newLine();
			
			s = "        print 'exit_status = -1'";
			out.write(s);
			out.newLine();
			
			s = "        os._exit(-1)";
			out.write(s);
			out.newLine();

			out.newLine();
			
			s = "    def stop(self):";
			out.write(s);
			out.newLine();
			
			s = "        self._Thread__stop()";
			out.write(s);
			out.newLine();
			
			out.newLine();
			//////////////////////////////////////////
			
//			s = "os.environ['SAGA_VERBOSE'] = 'DEBUG'";
//			out.write(s);
//			out.newLine();
//
//			s = "os.environ['SAGA_LOG_TARGETS'] = '/tmp/" + uuid + ".log'";
//			out.write(s);
//			out.newLine();
			
			s = "import saga";
			out.write(s);
			out.newLine();
			
			//////////////////////////////////////////
			s = "mt = _state_monitor()";
			out.write(s);
			out.newLine();
			
			s = "mt.start()";
			out.write(s);
			out.newLine();
			//////////////////////////////////////////
			
			s = "ctx = saga.Context('ssh')";
			out.write(s);
			out.newLine();
			
			s = "ctx.user_id = '" + userid + "'";
			out.write(s);
			out.newLine();

			s = "session = saga.Session()";
			out.write(s);
			out.newLine();
			
			s = "session.add_context(ctx)";
			out.write(s);
			out.newLine();
			
			s = "try:";
			out.write(s);
			out.newLine();
			
			s = "    js = saga.job.Service('" + rm + "', session=session)";
			out.write(s);
			out.newLine();

			s = "    myjob = js.get_job('" + jobid + "')";
			out.write(s);
			out.newLine();
			
			s = "    print 'Job Id = ' + '" + jobid + "'";
			out.write(s);
			out.newLine();

			s = "    print 'job_state = ' + myjob.get_state()";
			out.write(s);
			out.newLine();
			
			s = "    print 'exit_status = ' + str(myjob._get_exit_code())";
			out.write(s);
			out.newLine();
			
			s = "    if myjob._get_started():";
			out.write(s);
			out.newLine();

			s = "        print 'start_time = ' + myjob._get_started()";
			out.write(s);
			out.newLine();
			
			s = "    if myjob._get_finished():";
			out.write(s);
			out.newLine();
			
			s = "        print 'comp_time = ' + myjob._get_finished()";
			out.write(s);
			out.newLine();
			
			s = "except Exception, msg:";
			out.write(s);
			out.newLine();
			
			s = "    import radical.utils.logger as rul";
			out.write(s);
			out.newLine();
			
			s = "    _logger  = rul.getLogger ('saga', 'submit')";
			out.write(s);
			out.newLine();
			
			s = "    _logger.error(msg)";
			out.write(s);
			out.newLine();
			
			out.newLine();
			s = "mt.stop()";
			out.write(s);
			out.newLine();
			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePath;
	}

	private static String[] getJobInfo(String JobID, String userid) throws Exception
	{
		/*
		 * id : [pbs+ssh://150.183.247.33]-[51]
		 * return:
		 *  monitorscript execution result
		 * 	null : when error
		 */
		// http://www.vogella.com/articles/JavaRegularExpressions/article.html
		Pattern pattern = Pattern.compile("^\\[(.*)\\]-\\[(.*?)\\]$");
		Matcher matcher = pattern.matcher(JobID);
		
		String rm=null;
//		String jobid=null;
		if ( matcher.find() == true && matcher.groupCount() == 2)
		{
			rm=matcher.group(1);
//			jobid=matcher.group(2);
		}
		
		StringBuilder excuter = new StringBuilder("python");
		String tmpFilename = makeMonitorScriptFile(rm, JobID, userid);
		excuter.append(" " + tmpFilename );
		String st = excuter.toString();
		
		//Process p = Runtime.getRuntime().exec("qstat -f " + JobID);
		ProcessBuilder builder = new ProcessBuilder(st.split(" "));
		builder.redirectErrorStream(true);
		Process p = builder.start();
		int retCode = p.waitFor();

		if (retCode == (-1)) {
			return null;
		}
		
		// remove temporary MonitoringScriptFile
		File tmpFile = new File(tmpFilename);
		tmpFile.delete();
		
		BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
		byte[] data = new byte[ef.available()];
		ef.read(data, 0, ef.available());
		ef.close();
		p.getInputStream().close();
		p.getOutputStream().close();
		p.getErrorStream().close();
		
		String Result = new String(data);
		return Result.split("\n");
		/*
		def monitor(self, job):
	        REMOTE_HOST = str(job.cluster['ip'])
	        
	        # later, handle port information
	        ctx = saga.Context("ssh")
	        ctx.user_id = PBS_USERID
	        
	        session = saga.Session()
	        session.add_context(ctx)
	    
	        js = saga.job.Service("pbs+ssh://%s" % REMOTE_HOST, session=session)
	    
	        myjob = js.get_job(job.jobid)
	        job.state=_saga_to_ncube_jobstate(myjob.state)
	        job.localstate=myjob.state

	        #job.starttime= myjob._get_started() # why doesn't work?
	        if myjob._get_started():
	            job.starttime= datetime.strptime(myjob._get_started(), '%c')
	        if myjob._get_finished():
	            job.endtime = datetime.strptime(myjob._get_finished(), '%c')
	      */  
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