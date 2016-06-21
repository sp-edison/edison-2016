/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import kisti.edison.cloud.model.Host;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.Job.JobState;
import kisti.edison.cloud.model.VirtualMachine;

import org.hibernate.CacheMode;
import org.hibernate.OptimisticLockException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StaleStateException;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * @author root
 * 
 */
@Repository("jobDAO")
@SuppressWarnings("unchecked")
public class JobDAOImpl extends HibernateDAO implements JobDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.dao.JobDAO#createJob(kisti.edison.cloud.model.Job)
	 */
	@Override
	public Job createJob(Session session, Job job) {
		// TODO Auto-generated method stub
		if (session == null) {
			session = getSession();
		}
		session.save(job);
		session.flush();
		return job;
	}

	@Override
	public Job getJob(Session session, String job_uuid) {
		if (session == null) {
			session = getSession();
		}
		
		session.setCacheMode(CacheMode.REFRESH);
		
		Job job = (Job) session.get(Job.class, job_uuid);
		return job;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kisti.edison.cloud.dao.JobDAO#getJob(java.lang.Long)
	 */
	@Override
	public Job findJobByUUID(Session session, String uuid) {
		Assert.hasText(uuid);
		if (session == null) {
			session = getSession();
		}
		String query = "from Job job where job.uuid = :uuid";
		Job job = (Job) session.createQuery(query).setString("uuid", uuid)
				.uniqueResult();
		return job;
	}

	@Override
	public Job updateJob(Session session, Job job) {
		Assert.notNull(job.getUuid());

		if (session == null) {
			session = getSession();
		}
/*
		if (getJob(session, job.getUuid()) == null) {
			LOG.info("JOB ( " + job.getUuid() + " ) DOES NOT EXIST.");
			return null;
		}
*/
		session.setCacheMode(CacheMode.REFRESH);
		
		Job pJob = null;
		try {
		pJob = (Job) session.get(Job.class, job.getUuid());
			if (job.getVersion() == pJob.getVersion()) {
				pJob.setTitle(job.getTitle());
				pJob.setDescription(job.getDescription());
				pJob.setState(job.getState());
				pJob.setLcmState(job.getLcmState());
				pJob.setEndTime(job.getEndTime());
				pJob.setStartTime(job.getStartTime());
				pJob.setSubmittedTime(job.getSubmittedTime());
				pJob.setExecutable(job.getExecutable());
				pJob.setExecution(job.getExecution());
	
				pJob.setFileStr(job.getFileStr());
				pJob.setAttrStr(job.getAttrStr());
				pJob.setJobId(job.getJobId());
				pJob.setType(job.getType());
				pJob.setCategory(job.getCategory());
				pJob.setCyberLabId(job.getCyberLabId());
				pJob.setClassId(job.getClassId());
				pJob.setSolverId(job.getSolverId());
				pJob.setSolverName(job.getSolverName());
				
				pJob.setUserId(job.getUserId());
				pJob.setWorkingDir(job.getWorkingDir());
				pJob.setZipFilePath(job.getZipFilePath());
				pJob.setCluster(job.getCluster());
				pJob.setLocalAccount(job.getLocalAccount());
				pJob.setDependenciesStr(job.getDependenciesStr());
				pJob.setReqState(job.getReqState());
				pJob.setnProcs(job.getnProcs());
				
				//session.save(pJob);
				session.flush();
				//session.clear();
			} else {
				LOG.info("JOB ( " + job.getUuid() + " ) VERSION CONFLICT.");
			}
		} catch (OptimisticLockException e) {
			LOG.info("======================================================= STALE DATA ================================================");
			//e.printStackTrace();
			return null;
		} catch (StaleStateException e) {
			LOG.info("======================================================= STALE DATA ================================================");
			//e.printStackTrace();
			return null;
		}
		return pJob;
	}

	@Override
	public List<Job> findJobsByUserId(Session session, String userId) {
		// TODO Auto-generated method stub
		Assert.hasText(userId);
		if (session == null) {
			session = getSession();
		}
		String query = "from Job job where job.userId = :userId";
		List<Job> jobs = session.createQuery(query).setString("userId", userId)
				.list();
		return jobs;
	}

	@Override
	public List<Job> findJobsByGroupId(Session session, String groupId) {
		Assert.hasText(groupId);
		if (session == null) {
			session = getSession();
		}
		String query = "from Job job where job.groupId = :groupId";
		List<Job> jobs = session.createQuery(query)
				.setString("groupId", groupId).list();
		return jobs;
	}

	@Override
	public List<Job> findJobs(Session session, String userId, String groupId) {
		Assert.hasText(userId);
		Assert.hasText(groupId);
		if (session == null) {
			session = getSession();
		}

		String query = "from Job job where job.userId = :userId and job.groupId = :groupId";
		Query q = session.createQuery(query);
		q = q.setString("userId", userId);
		q = q.setString("groupId", groupId);
		List<Job> jobs = q.list();

		return jobs;
	}

	@Override
	public Job updateJobState(Session session, String uuid, JobState state) {
		// TODO Auto-generated method stub
		if (session == null) {
			session = getSession();
		}

		Job job = null;

		if ((job = getJob(session, uuid)) == null) {
			LOG.info("JOB ( " + uuid + " ) DOES NOT EXIST.");
			return null;
		}

		Job pJob = (Job) session.load(Job.class, job.getUuid());
		pJob.setState(state);
		session.flush();

		return pJob;
	}

	@Override
	public List<Job> getJobs(Session session, int startIndex, int maxResults) {
		// TODO Auto-generated method stub
		if(startIndex < 0) {
			return null;
		}
		
		if(session == null) {
			session = getSession();
		}
		
		Query q = session.createQuery("from Job order by uuid");
		q.setFirstResult(startIndex);
		q.setMaxResults(maxResults);
		List<Job> jobs = q.list();
		return jobs;
	}

	@Override
	public int getJobCount(Session session, String state) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		
		int count = 0;
		if(state == null) {
			count = ((Long) session.createQuery(
				"select count(*) from Job").uniqueResult()).intValue();
		}
		else {
			String query = "select count(*) from Job where state = :jobState";
			count = ((Long) getSession().createQuery(query)
					.setString("jobState", state).uniqueResult()).intValue();
		}
		return count;
	}

	@Override
	public int getJobCount(Session session) {
		// TODO Auto-generated method stub
		if(session == null) session = getSession();
		
		int count = ((Long) session.createQuery(
				"select count(*) from Job").uniqueResult()).intValue();
		return count;
	}

	@Override
	public List<Job> getAllJobs(Session session) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		List<Job> jobs = null;
		jobs = session.createQuery("from Job order by uuid").list();
		
		return jobs;
	}

	@Override
	public List<Job> getActiveJobs(Session session) {
		// TODO Auto-generated method stub
		if (session == null) {
			session = getSession();
		}

		String query = "from Job job where job.state = :running or job.state = :queued";
		Query q = session.createQuery(query);
		q = q.setString("running", Job.JobState.RUNNING.toString());
		q = q.setString("queued", Job.JobState.QUEUED.toString());
		List<Job> jobs = q.list();

		return jobs;
	}

	@Override
	public List<Job> getFailedJobs(Session session) {
		// TODO Auto-generated method stub
		if (session == null) {
			session = getSession();
		}

		String query = "from Job job where job.state = :failed";
		Query q = session.createQuery(query);
		q = q.setString("failed", Job.JobState.FAILED.toString());
		List<Job> jobs = q.list();

		return jobs;
	}

}
