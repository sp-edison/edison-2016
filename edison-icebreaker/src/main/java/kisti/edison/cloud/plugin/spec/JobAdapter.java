/**
 * 
 */
package kisti.edison.cloud.plugin.spec;

import java.io.IOException;

import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.User;

/**
 * @author eairs
 * 
 */
public interface JobAdapter {
	public String getVersion();
	
	public String getName();
		
	public Job submit(User user, Cluster cluster, Job job);

	public Job getInformation(User user, Cluster cluster, Job job);

	public Job cancel(User user, Cluster cluster, Job job);
	
	public byte[] getErrorLog(User user, Cluster cluster, Job job) throws IOException;
	
	public byte[] getOutputLog(User user, Cluster cluster, Job job) throws IOException;
}
