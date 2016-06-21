/**
 * 
 */
package kisti.edison.cloud.core;

import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.Simulation;

/**
 * @author jlyu
 *
 */
public interface Scheduler {
	
	public Cluster schedule (Simulation simulation, String zone);
	public Cluster schedule (Job job);
	
}
