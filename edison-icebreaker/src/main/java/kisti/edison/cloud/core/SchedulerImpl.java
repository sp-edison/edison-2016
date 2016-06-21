/**
 * 
 */
package kisti.edison.cloud.core;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kisti.edison.cloud.dao.ClusterDAO;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.Simulation;

/**
 * @author jlyu
 *
 */
@Component
public class SchedulerImpl implements Scheduler {
	private final Logger LOG = Logger.getLogger(this.getClass());
	
	private ClusterDAO clusterDAO;
	
	public ClusterDAO getClusterDAO() {
		return clusterDAO;
	}
	@Autowired
	public void setClusterDAO(ClusterDAO clusterDAO) {
		this.clusterDAO = clusterDAO;
	}
	
	/* (non-Javadoc)
	 * @see kisti.edison.cloud.core.Scheduler#schedule(kisti.edison.cloud.model.Simulation)
	 */
	@Override
	public Cluster schedule(Simulation simulation, String zone) {
		// TODO Auto-generated method stub
		if(simulation == null || zone == null) {
			return null;
		}
		
		List<Cluster> clusters = clusterDAO.getClusters(null);
		Cluster target = null;
		Long inf = Long.MIN_VALUE;
		
		for(Cluster c : clusters) {
			if(c.isEnabled() && c.getZone().equals(zone)) {
				if(c.getRuntime().getFreeCores() >= inf) {
					inf = c.getRuntime().getFreeCores();
					target = c;
				}
			}
		}
		
		return target;
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.core.Scheduler#schedule(kisti.edison.cloud.model.Job)
	 */
	@Override
	public Cluster schedule(Job job) {
		// TODO Auto-generated method stub
		if(job == null) return null;
		return null;
	}

}
