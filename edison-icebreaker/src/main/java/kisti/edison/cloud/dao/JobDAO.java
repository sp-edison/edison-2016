/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import org.hibernate.Session;

import kisti.edison.cloud.model.Job;

/**
 * @author root
 * 
 */
public interface JobDAO {

	public int getJobCount(Session session);
	
	public int getJobCount(Session session, String state);
	
	public Job createJob(Session session, Job job);

	public Job getJob(Session session, String job_uuid);
	
	public List<Job> getJobs(Session session, int startIndex, int maxResults);

	public Job findJobByUUID(Session session, String uuid);

	public List<Job> findJobsByUserId(Session session, String userId);

	public List<Job> findJobsByGroupId(Session session, String groupId);

	public List<Job> findJobs(Session session, String userId, String groupId);

	public Job updateJob(Session session, Job job);

	public Job updateJobState(Session session, String uuid, Job.JobState state);
	
	public List<Job> getAllJobs(Session session);
	
	public List<Job> getActiveJobs(Session session);
	
	public List<Job> getFailedJobs(Session session);

}
