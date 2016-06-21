/**
 * 
 */
package kisti.edison.cloud.plugin.spec;

import kisti.edison.cloud.model.Cluster;

/**
 * @author jlyu
 *
 */
public interface ClusterAdapter {

	public String getVersion();
	
	public String getName();
	
	public Cluster getClusterRuntime(Cluster cluster) throws Exception;
	
}
