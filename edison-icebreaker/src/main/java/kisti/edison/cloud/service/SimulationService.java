/**
 * 
 */
package kisti.edison.cloud.service;

import java.io.IOException;
import java.util.List;

import kisti.edison.cloud.model.Callback;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.Simulation;

/**
 * @author root
 * 
 */
public interface SimulationService {

	public int getSimulationsCount(String userId, boolean allSims);

	public Simulation getSimulation(String uuid);

	public List<Simulation> getSimulations(String orderBy, String order);

	public List<Simulation> findSimulationsByUserId(String userId, String orderBy, String order);
	
	public List<Simulation> querySimulations(String userId, String orderBy, String order, int startIndex, int maxResults);

	public Simulation createSimulation(Simulation simulation, String zone);
	
	public void addCallback(Callback callback);
	
	public void pushCallback(Callback callback, String uuid, Job job);
	
	public Callback getCallback(String sim_uuid);

	public void deleteSimulation(String uuid);

	public Simulation updateSimulation(Simulation simulation);

	public Job addJob(String uuid, Job job);
}
