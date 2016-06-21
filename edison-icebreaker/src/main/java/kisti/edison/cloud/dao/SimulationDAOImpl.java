/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.Simulation;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.model.VirtualMachine;

/**
 * @author root
 * 
 */
@Repository("simulationDAO")
@SuppressWarnings("unchecked")
public class SimulationDAOImpl extends HibernateDAO implements SimulationDAO {

	@Override
	public Simulation getSimulation(Session session, String uuid) {
		// TODO Auto-generated method stub
		if (session == null) {
			session = getSession();
		}
		Simulation simulation = (Simulation) session
				.get(Simulation.class, uuid);
		return simulation;
	}

	@Override
	public List<Simulation> getSimulations(Session session, String orderBy, String order) {
		if (session == null) {
			session = getSession();
		}
		List<Simulation> sims = null;
		if(orderBy == null || order == null) {
			sims = session.createQuery(
					"from Simulation order by lastModified desc").list();
		}
		else {
			sims = session.createQuery(
					"from Simulation order by " + orderBy + " " + order).list();
		}
		return sims;
	}

	@Override
	public Simulation createSimulation(Session session, Simulation simulation) {
		// TODO Auto-generated method stub
		if (session == null) {
			session = getSession();
		}
		session.save(simulation);
		session.flush();

		return simulation;
	}

	@Override
	public void deleteSimulation(Session session, String uuid) {
		// TODO Auto-generated method stub
		if (session == null) {
			session = getSession();
		}
		Simulation sim = getSimulation(session, uuid);
		if (sim != null) {
			session.delete(sim);
			session.flush();
		}
	}

	@Override
	public Simulation updateSimulation(Session session, Simulation simulation) {
		// TODO Auto-generated method stub
		if (session == null) {
			session = getSession();
		}
		Simulation loadedSim = (Simulation) session.load(Simulation.class,
				simulation.getUuid());
		loadedSim.setTitle(simulation.getTitle());
		loadedSim.setDescription(simulation.getDescription());
		loadedSim.setLastModified(simulation.getLastModified());
		session.flush();
		return loadedSim;
	}

	@Override
	public Job addJob(Session session, String uuid, Job job) {
		// TODO Auto-generated method stub
		if (session == null) {
			session = getSession();
		}
		Simulation simulation = (Simulation) session.load(Simulation.class,
				uuid);
		simulation.addJob(job);
		session.flush();
		return job;
	}

	@Override
	public List<Simulation> findSimulationsByUserId(Session session,
			String userId, String orderBy, String order) {
		Assert.hasText(userId);
		if (session == null) {
			session = getSession();
		}
		String query = "";
		if(orderBy == null || order == null) {
			query = "from Simulation sim where sim.userId = :userId order by sim.lastModified desc";
		}
		else {
			query = "from Simulation sim where sim.userId = :userId order by " + orderBy + " " + order;
		}
		
		List<Simulation> sims = session.createQuery(query).setString("userId", userId).list();
		return sims;
	}

	@Override
	public int getSimulationsCount(Session session, String userId,
			boolean allSims) {
		Assert.hasText(userId);
		if (session == null) {
			session = getSession();
		}

		int count = 0;
		if (allSims == true) {
			count = ((Long) session.createQuery(
					"select count(*) from Simulation").uniqueResult())
					.intValue();
		} else {
			String query = "select count(*) from Simulation where userId = :userId";
			count = ((Long) session.createQuery(query)
					.setString("userId", userId).uniqueResult()).intValue();
		}

		return count;
	}

	@Override
	public List<Simulation> querySimulations(Session session, String userId, String orderBy, String order,
			int startIndex, int maxResults) {
		if (session == null) {
			session = getSession();
		}
		
		String query = "";
		
		if(orderBy == null || order == null) {
			query = "from Simulation sim where sim.userId = :userId order by lastModified desc";
		}
		else {
			query = "from Simulation sim where sim.userId = :userId order by " + orderBy + " " + order;
		}
		
		Query q = session.createQuery(query).setString("userId", userId);
		q.setFirstResult(startIndex);
		q.setMaxResults(maxResults);
		List<Simulation> sims = q.list();
		return sims;
	}

	@Override
	public List<Simulation> querySimulations(Session session, String orderBy, String order, int startIndex,
			int maxResults) {
		if (session == null) {
			session = getSession();
		}
		Query q;
		if(orderBy == null || order == null) {
			q = session.createQuery("from Simulation order by lastModified desc");
		}
		else {
			q = session.createQuery("from Simulation order by " + orderBy + " " + order);
		}
		q.setFirstResult(startIndex);
		q.setMaxResults(maxResults);
		List<Simulation> sims = q.list();
		return sims;
	}

}
