/**
 * 
 */
package kisti.edison.cloud.service;

import java.util.List;

import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.User;

/**
 * @author root
 * 
 */
public interface JobService {

	public int getJobCount(String state);
	
	public Job createJob(Cluster cluster, String sim_uuid, Job job);

	public Job findJobByUUID(String uuid);

	public List<Job> findJobsByUserId(String userId);

	public List<Job> findJobsByGroupId(String groupId);

	public List<Job> findJobs(String userId, String groupId);

	public Job cancel(Cluster cluster, Job job);

	public Job update(Cluster cluster, Job job);
	
	public byte[] getErrorLog(Cluster cluster, Job job);
	
	public byte[] getOutputLog(Cluster cluster, Job job);
}
