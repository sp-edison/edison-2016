/**
 * 
 */
package kisti.edison.cloud.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.util.RegExPatternMatcher;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kisti.edison.cloud.core.Scheduler;
import kisti.edison.cloud.dao.CallbackDAO;
import kisti.edison.cloud.dao.JobDAO;
import kisti.edison.cloud.dao.SimulationDAO;
import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Callback;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.Job.JobState;
import kisti.edison.cloud.model.Simulation;
import kisti.edison.cloud.model.User;

/**
 * @author root
 * 
 */
@Transactional
@Service("simulationService")
public class SimulationServiceImpl implements SimulationService {
	private final Logger LOG = Logger.getLogger(this.getClass());
	private SimulationDAO simulationDAO;
	private CallbackDAO callbackDAO;
	private RepositoryService repositoryService;
	private ClusterService clusterService;

	public ClusterService getClusterService() {
		return clusterService;
	}
	
	@Autowired
	public void setClusterService(ClusterService clusterService) {
		this.clusterService = clusterService;
	}
	
	public SimulationDAO getSimulationDAO() {
		return simulationDAO;
	}
	
	public CallbackDAO getCallbackDAO() {
		return callbackDAO;
	}
	
	private Scheduler scheduler;
	public Scheduler getScheduler() {
		return scheduler;
	}
	@Autowired
	public void setScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	@Autowired
	public void setSimulationDAO(SimulationDAO simulationDAO) {
		this.simulationDAO = simulationDAO;
	}
	
	@Autowired
	public void setCallbackDAO(CallbackDAO callbackDAO) {
		this.callbackDAO = callbackDAO;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.service.SimulationService#getSimulation(java.lang.
	 * String)
	 */
	@Override
	public Simulation getSimulation(String uuid) {
		// TODO Auto-generated method stub
		return simulationDAO.getSimulation(null, uuid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kisti.edison.cloud.service.SimulationService#getSimulations()
	 */
	@Override
	public List<Simulation> getSimulations(String orderBy, String order) {
		// TODO Auto-generated method stub
		return simulationDAO.getSimulations(null, orderBy, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.service.SimulationService#createSimulation(kisti.edison
	 * .cloud.model.Simulation)
	 */
	@Override
	public Simulation createSimulation(Simulation simulation, String zone) {
		// TODO Auto-generated method stub
		simulation.setLastModified(new Date());
		Cluster c = scheduler.schedule(simulation, zone);
		if(c == null) {
			return null;
		}
		else {
			simulation.setCluster(c.getName());
			return simulationDAO.createSimulation(null, simulation);
		}
	}
	
	@Override
	public void addCallback(Callback callback) {
		callbackDAO.addCallback(null, callback);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.service.SimulationService#deleteSimulation(java.lang
	 * .String)
	 */
	@Override
	public void deleteSimulation(String uuid) {
		// TODO Auto-generated method stub
		Simulation sim = simulationDAO.getSimulation(null, uuid);
		List <Job> jobs = sim.getJobs();
		for(Job job: jobs) {
			File workingDir = new File(job.getWorkingDir());
			String canonicalPath = null;
			String jobUuid = job.getUuid();
			try {
				canonicalPath = workingDir.getCanonicalPath();
				if (canonicalPath != null) {
					String clusterName = Cloud.getInstance().getProp("resources").split(":")[0];
					String baseDir = "/EDISON"; 
					List<Cluster> clusters = clusterService.getClusters();

					for(Cluster c : clusters){
						if(c.getName().equals(clusterName)){
							baseDir = c.getBaseDir();
							break;
						}
					}
					repositoryService.delete(canonicalPath);
				}
			} catch (IOException e) {
				LOG.error("getCanonicalPath fail : " + job.getWorkingDir());
			}
			//jobDAO.deleteJob(null, jobUuid);
		}
		simulationDAO.deleteSimulation(null, uuid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.service.SimulationService#updateSimulation(kisti.edison
	 * .cloud.model.Simulation)
	 */
	@Override
	public Simulation updateSimulation(Simulation simulation) {
		// TODO Auto-generated method stub
		simulation.setLastModified(new Date());
		return simulationDAO.updateSimulation(null, simulation);
	}

	@Override
	public Job addJob(String uuid, Job job) {
		// TODO Auto-generated method stub
		return simulationDAO.addJob(null, uuid, job);
	}

	@Override
	public List<Simulation> findSimulationsByUserId(String userId, String orderBy, String order) {
		// TODO Auto-generated method stub
		return simulationDAO.findSimulationsByUserId(null, userId, orderBy, order);
	}

	@Override
	public int getSimulationsCount(String userId, boolean allSims) {
		// TODO Auto-generated method stub
		return simulationDAO.getSimulationsCount(null, userId, allSims);
	}

	@Override
	public List<Simulation> querySimulations(String userId, String orderBy, String order, int startIndex,
			int maxResults) {
		// TODO Auto-generated method stub
		if("*".equals(userId)) {
			return simulationDAO.querySimulations(null, orderBy, order, startIndex, maxResults);
		}
		else {
			return simulationDAO.querySimulations(null, userId, orderBy, order, startIndex, maxResults);
		}
	}

	@Override
	public void pushCallback(Callback callback, Job job) {
		this.pushCallback(callback, job, job.getState());
/*		LOG.info("*** pushCallback ***");
		LOG.info(job.toString());
		callback.setState(job.getState());
		Callback newCallback = callbackDAO.updateCallback(null, callback);
		StringBuilder excuter = new StringBuilder("/usr/bin/curl");

//		excuter.append(" -H \"User-Agent: Mozilla/5.0\" http://");
//		excuter.append(callback.getIp());
//		excuter.append(":");
//		excuter.append(callback.getPort());
		excuter.append(" -H \"User-Agent: Mozilla/5.0\" ");
		excuter.append("\"");
		excuter.append(callback.getUrl());
//		excuter.append("/api/jsonws/edison-simulation-portlet.simulationjob/update-simulation-job?");
//		excuter.append("gid=" + callback.getGid());
//		excuter.append("&simulationUuid=" + uuid);
		excuter.append("&jobUuid=" + job.getUuid());
		excuter.append("&jobStatus=" + job.getState());
		
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		excuter.append("&jobStartDt=");
		if ( job.getStartTime() != null ) {
			excuter.append(format.format(job.getStartTime()).replaceAll(" ", "%20"));
		} else {
			excuter.append("NULL");
		}
		
		excuter.append("&jobEndDt=");
		if ( job.getEndTime() != null ) {
			excuter.append(format.format(job.getEndTime()).replaceAll(" ", "%20"));
		} else {
			excuter.append("NULL");
		}
		excuter.append("\"");
		
		String st = excuter.toString();
		LOG.info("cmd: " + st);
		ProcessBuilder builder = new ProcessBuilder(st.split(" "));
		builder.redirectErrorStream(true);
		Process p = null;
		try {
			p = builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int retCode = 0;
		Callback tmpCallback = null;
		try {
			retCode = p.waitFor();
		} catch (InterruptedException e) {
			LOG.error("============ CURL Exception ==================");
			newCallback.setRetry(true);
			tmpCallback = callbackDAO.updateCallback(null, newCallback);

		}

		if(retCode != 0) {
			LOG.error("============ CURL RETURN NOT ZERO ==================");
			newCallback.setRetry(true);
			tmpCallback = callbackDAO.updateCallback(null, newCallback);
		}
		LOG.info("callback end");*/
	}
	@Override
	public void pushCallback(Callback callback, Job job, JobState jobState) {
		LOG.info("*** pushCallback ***");
		LOG.info(job.toString());
		callback.setState(job.getState());
		Callback newCallback = callbackDAO.updateCallback(null, callback);
		StringBuilder excuter = new StringBuilder("/usr/bin/curl");

//		excuter.append(" -H \"User-Agent: Mozilla/5.0\" http://");
//		excuter.append(callback.getIp());
//		excuter.append(":");
//		excuter.append(callback.getPort());
		excuter.append(" -H \"User-Agent: Mozilla/5.0\" ");
		excuter.append(callback.getUrl());
//		excuter.append("/api/jsonws/edison-simulation-portlet.simulationjob/update-simulation-job?");
//		excuter.append("gid=" + callback.getGid());
//		excuter.append("&simulationUuid=" + uuid);
		excuter.append("&jobUuid=" + job.getUuid());
		excuter.append("&jobStatus=" + jobState);
		
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		excuter.append("&jobStartDt=");
		if ( job.getStartTime() != null ) {
			excuter.append(format.format(job.getStartTime()).replaceAll(" ", "%20"));
		} else {
			excuter.append("NULL");
		}
		
		excuter.append("&jobEndDt=");
		if ( job.getEndTime() != null ) {
			excuter.append(format.format(job.getEndTime()).replaceAll(" ", "%20"));
		} else {
			excuter.append("NULL");
		}
		
		String st = excuter.toString();
		LOG.info("cmd: " + st);
		ProcessBuilder builder = new ProcessBuilder(st.split(" "));
		builder.redirectErrorStream(true);
		Process p = null;
		try {
			p = builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int retCode = 0;
		Callback tmpCallback = null;
		try {
			retCode = p.waitFor();
		} catch (InterruptedException e) {
			LOG.error("============ CURL Exception ==================");
			newCallback.setRetry(true);
			tmpCallback = callbackDAO.updateCallback(null, newCallback);
		}
		if(retCode != 0) {
			LOG.error("============ CURL RETURN NOT ZERO ==================");
			LOG.error("error code " + retCode);
			//newCallback.setRetry(true);
			//tmpCallback = callbackDAO.updateCallback(null, newCallback);
		}
	}
	@Override
	public void pushCallback2(Callback callback, Job job, JobState jobState) {
		LOG.info("*** pushCallback2 ***");
		LOG.info(job.toString());
		callback.setState(job.getState());
		Callback newCallback = callbackDAO.updateCallback(null, callback);
		
		
		String url = newCallback.getUrl();
		url = url.replaceAll("&$", "");
		SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd%20HH:mm:ss");
		String starttime = null;
		String endtime = null;
		if ( job.getStartTime() == null ) {
			starttime = "NULL";
			endtime = "NULL";
		} else if ( job.getEndTime() == null ) {
			starttime = dateform.format(job.getStartTime());
			endtime = "NULL";
		} else {
			starttime = dateform.format(job.getStartTime());
			endtime = dateform.format(job.getEndTime());
		}
		String finalUrl = String.format("%s&jobUuid=%s&jobStatus=%s&jobStartDt=%s&jobEndDt=%s",
				url, job.getUuid(), jobState, starttime, endtime);
		LOG.info("callback FinalURL : " + finalUrl);
		DefaultHttpClient client = null;
		try {
			client = new DefaultHttpClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpGet request = new HttpGet(finalUrl);
		HttpResponse response = null;
		int StatusCode=0;
		try {
			response = client.execute(request);
			StatusCode=response.getStatusLine().getStatusCode();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if ( StatusCode == 200 ) {
			LOG.info("callback, Response Code : {}"+ StatusCode);
		}
		else {
			LOG.error("callback, Response Code : {}"+ StatusCode);
		}
	}
	
	@Override
	public Callback getCallback(String job_uuid) {
		Callback callback = callbackDAO.findCallbackByUUID(null, job_uuid);
		return callback;
	}

}
