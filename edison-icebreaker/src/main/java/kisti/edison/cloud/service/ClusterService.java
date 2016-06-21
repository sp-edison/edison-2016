/**
 * 
 */
package kisti.edison.cloud.service;

import java.util.List;

import kisti.edison.cloud.model.Cluster;

/**
 * @author jlyu
 *
 */
public interface ClusterService {
	
	public List<Cluster> getClusters();
	
	public Cluster findCluster(String name);
}
