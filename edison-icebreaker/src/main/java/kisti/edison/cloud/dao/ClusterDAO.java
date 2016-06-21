/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import org.hibernate.Session;

import kisti.edison.cloud.model.Cluster;

/**
 * @author jlyu
 *
 */
public interface ClusterDAO {
	
	public Cluster getCluster(Session session, Long id);
	
	public List<Cluster> getClusters(Session session);
	
	public Cluster createCluster(Session session, Cluster cluster);
	
	public Cluster updateCluster(Session session, Cluster cluster);
	
	public Cluster findCluster(Session session, String name);
	
	public void deleteCluster(Session session, String name);
		
}
