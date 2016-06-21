/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import org.hibernate.Session;

import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.Simulation;

/**
 * @author root
 * 
 */
public interface SimulationDAO {

	public int getSimulationsCount(Session session, String userId, boolean allSims);

	public Simulation getSimulation(Session session, String uuid);

	public List<Simulation> getSimulations(Session session, String orderBy, String order);

	public Simulation createSimulation(Session session, Simulation simulation);

	public void deleteSimulation(Session session, String uuid);

	public Simulation updateSimulation(Session session, Simulation simulation);

	public Job addJob(Session session, String uuid, Job job);

	public List<Simulation> findSimulationsByUserId(Session session, String userId, String orderBy, String order);

	public List<Simulation> querySimulations(Session session, String userId, String orderBy, String order, int startIndex, int maxResults);
	
	public List<Simulation> querySimulations(Session session, String orderBy, String order, int startIndex, int maxResults);
}
