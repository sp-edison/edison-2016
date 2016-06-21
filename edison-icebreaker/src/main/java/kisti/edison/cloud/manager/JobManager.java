/**
 * 
 */
package kisti.edison.cloud.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import kisti.edison.cloud.dao.JobDAO;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.model.VirtualMachine;
import kisti.edison.cloud.plugin.spec.JobAdapter;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author eairs
 * 
 */
@Component
@Scope(value = "singleton")
public class JobManager {
	private final Logger LOG = Logger.getLogger(this.getClass());
	private Map<String,String> locks;
	
	private JobDAO jobDAO;

	@Autowired
	public void setJobDAO(JobDAO jobDAO) {
		this.jobDAO = jobDAO;
	}

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Resource(name = "jobQueue")
	private BlockingQueue<Command<Job>> jobQueue;

	public BlockingQueue<Command<Job>> getJobQueue() {
		return jobQueue;
	}

	public void setJobQueue(BlockingQueue<Command<Job>> jobQueue) {
		this.jobQueue = jobQueue;
	}

	private Map<String, JobAdapter> jobAdapters;
	
	public Map<String, JobAdapter> getJobAdapters() {
		return jobAdapters;
	}

	public void setJobAdapters(Map<String, JobAdapter> jobAdapters) {
		this.jobAdapters = jobAdapters;
	}
	
	
	private JobAdapter getProperJobAdapter(Cluster cluster) {
		if(cluster == null) {
			return jobAdapters.get("TORQUE");
		}
		
		return jobAdapters.get(cluster.getJobManagerType().toString());
	}
	
	public JobManager() {
		locks = new HashMap<String,String>();
	}

	
	public byte[] getErrorLog(User user, Cluster cluster, Job job) {
		JobAdapter ja = getProperJobAdapter(cluster);
		byte[] log = null;
		try {
			log = ja.getErrorLog(user, cluster, job);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return log;
	}
	
	public byte[] getOutputLog(User user, Cluster cluster, Job job) {
		JobAdapter ja = getProperJobAdapter(cluster);
		byte[] log = null;
		try {
			log = ja.getOutputLog(user, cluster, job);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return log;
	}

	
	public Job submit(User user, Cluster cluster, Job job) {
		JobAdapter ja = getProperJobAdapter(cluster);
		return ja.submit(user, cluster, job);
	}

	public synchronized boolean getLock(String job_uuid){
		if(locks.containsKey(job_uuid)){
			return false;
		}
		else{
			locks.put(job_uuid, "");
			return true;
		}
	}
	public synchronized boolean releaseLock(String job_uuid){
		if(locks.containsKey(job_uuid)){
			locks.remove(job_uuid);
			return true;
		}
		else{
			return false;
		}
	}
	public Map<String,String> getLockMap(){
		return locks;
	}
//	@Transactional
//	public synchronized Job update(User user, Cluster cluster, Job job) {
//		synchronized(this) {
	public Job update(User user, Cluster cluster, Job job) throws Exception {
			//LOG.info("=============== START CRITICAL SECTION ==========================================================" + Thread.currentThread().getId());
			try{
				
				LOG.info("JobManager::update called. ( uuid = " + job.getUuid()
					+ " , jobId = " + job.getJobId() + " )");
			//Session session = SessionFactoryUtils.getSession(					this.sessionFactory, true);
			Session session = SessionFactoryUtils.getNewSession(this.sessionFactory);
			Transaction tx = session.beginTransaction();
			Job dbJob = jobDAO.getJob(session, job.getUuid());
			tx.commit();
			LOG.info("1: " + dbJob);
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);
			
			JobAdapter ja = getProperJobAdapter(cluster);
			Job retrievedJob = ja.getInformation(user, cluster, dbJob);
	
			/* TODO : DB Update */
			if (retrievedJob != null) {
					session = SessionFactoryUtils.getSession(
							this.sessionFactory, true);
					tx = session.beginTransaction();
					Job uJob = jobDAO.updateJob(session, retrievedJob);
					tx.commit();
					//SessionFactoryUtils.releaseSession(session, this.sessionFactory);
					session.close();
		
					if (uJob != null) {
						LOG.info("JOB ( " + uJob.getUuid() + " , " + uJob.getState()
								+ " ) UPDATE DONE.");
						
						LOG.info("2: " + uJob);
						if (uJob.getState().equals(Job.JobState.QUEUED)
								|| uJob.getState().equals(Job.JobState.RUNNING)) {
							this.notifyToWorker(new Command<Job>("ADD", uJob));
						} else if (uJob.getState().equals(Job.JobState.SUCCESS)
								|| uJob.getState().equals(Job.JobState.FAILED)
								|| uJob.getState().equals(Job.JobState.CANCELED)) {
							this.notifyToWorker(new Command<Job>("DELETE", uJob));
						} else {
							this.notifyToWorker(new Command<Job>("ADD", uJob));
						}
						//LOG.info("=============== END   CRITICAL SECTION ==========================================================" + Thread.currentThread().getId());
						return uJob;
					}
					else {
						//LOG.info("=============== END   CRITICAL SECTION ==========================================================" + Thread.currentThread().getId());
						return null;
					}
				
			} else {
				LOG.info("JOB RAW DATA UNAVAILABLE !");
				//LOG.info("=============== END   CRITICAL SECTION ==========================================================" + Thread.currentThread().getId());
				return null;
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public String getSimUuid(Job job) 
	{
		Session session = SessionFactoryUtils.getSession(
				this.sessionFactory, true);
//		Transaction tx = session.beginTransaction();
		Job dbJob = jobDAO.getJob(session, job.getUuid());
//		tx.commit();
		String simUuid = dbJob.getSimulation().getUuid();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		
		return simUuid;
	}

	public synchronized Job cancel(User user, Cluster cluster, Job job) {
		LOG.info("JobManager::cancel() called. ( uuid = " + job.getUuid()
				+ " , jobId = " + job.getJobId() + " )");
		JobAdapter ja = getProperJobAdapter(cluster);
		Job canceledJob = ja.cancel(user, cluster, job);
		Job uJob = null;
		if (canceledJob != null) {
			Session session = SessionFactoryUtils.getSession(
					this.sessionFactory, true);
			Transaction tx = session.beginTransaction();
			uJob = jobDAO.updateJob(session, canceledJob);
			tx.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);

			if (uJob != null) {
				LOG.info("JOB ( " + uJob.getUuid() + " , " + uJob.getState()
						+ " ) CANCEL DONE.");
				if (uJob.getState().equals(Job.JobState.QUEUED)
						|| uJob.getState().equals(Job.JobState.RUNNING)) {
					this.notifyToWorker(new Command<Job>("ADD", uJob));
				} else if (uJob.getState().equals(Job.JobState.SUCCESS)
						|| uJob.getState().equals(Job.JobState.FAILED)
						|| uJob.getState().equals(Job.JobState.CANCELED)) {
					this.notifyToWorker(new Command<Job>("DELETE", uJob));
				}
			}
		} else {
			/* fail to cancel the job */
			LOG.info("JOB ( " + job.getUuid() + " ) CANCEL FAILED!");
			return null;
		}

		return uJob;
	}

	
	public void notifyToWorker(Command<Job> cmd) {
		try {
			jobQueue.put(cmd);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
