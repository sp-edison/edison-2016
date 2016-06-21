/**
 * 
 */
package kisti.edison.cloud.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import kisti.edison.cloud.core.Scheduler;
import kisti.edison.cloud.dao.CallbackDAO;
import kisti.edison.cloud.dao.SimulationDAO;
import kisti.edison.cloud.model.Callback;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.Simulation;

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
	public void pushCallback(Callback callback, String uuid, Job job) {
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
		excuter.append("/api/jsonws/edison-simulation-portlet.simulationjob/update-simulation-job?");
		excuter.append("gid=" + callback.getGid());
		excuter.append("&simulationUuid=" + uuid);
		excuter.append("&jobUuid=" + job.getUuid());
		excuter.append("&jobStatus=" + job.getState());
		
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		excuter.append("&jobStartDt=");
		if ( job.getStartTime() != null )
			excuter.append(format.format(job.getStartTime()).replaceAll(" ", "%20"));
		
		excuter.append("&jobEndDt=");
		if ( job.getEndTime() != null )
			excuter.append(format.format(job.getEndTime()).replaceAll(" ", "%20"));
		
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
	}

	@Override
	public Callback getCallback(String sim_uuid) {
		Callback callback = callbackDAO.findCallbackByUUID(null, sim_uuid);
		return callback;
	}

}
