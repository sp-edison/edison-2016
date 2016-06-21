/**
 * 
 */
package kisti.edison.cloud.service;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import kisti.edison.cloud.dao.JobDAO;
import kisti.edison.cloud.dao.LocalAccountDAO;
import kisti.edison.cloud.dao.UserDAO;
import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.manager.Command;
import kisti.edison.cloud.manager.JobManager;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.Job.JobState;
import kisti.edison.cloud.model.LocalAccount;
import kisti.edison.cloud.model.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * @author root
 * 
 */
@Transactional
@Service("jobService")
public class JobServiceImpl implements JobService {
	private final Logger LOG = Logger.getLogger(this.getClass());
	
	private LocalAccountDAO localAccountDAO;
	@Autowired
	public void setLocalAccountDAO(LocalAccountDAO localAccountDAO) {
		this.localAccountDAO = localAccountDAO;
	}
	
	private JobDAO jobDAO;

	@Autowired
	public void setJobDAO(JobDAO jobDAO) {
		this.jobDAO = jobDAO;
	}

	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private JobManager jobManager;

	@Autowired
	public void setJobManager(JobManager jobManager) {
		this.jobManager = jobManager;
	}

	private SimulationService simulationService;

	@Autowired
	public void setSimulationService(SimulationService simulationService) {
		this.simulationService = simulationService;
	}
	
//	private String generateJobDir(Cluster cluster, String sim_uuid, String job_uuid, String userId) {
//		String dir = cluster.getBaseDir() + Cloud.getInstance().getProp("data.basedir") + "/"
//				+ userId + "/" + Cloud.getInstance().getProp("user.jobpath")
//				+ "/" + sim_uuid + "/" + job_uuid + ".job/";
//		
//		File file = new File(dir);
//		if (!file.exists()) {
//			LOG.info("creating " + dir);
//			file.mkdirs();
//			file.setExecutable(true, false);
//			file.setReadable(true, false);
//			file.setWritable(true, false);
//		}
//		
//		return dir;
//	}
	
	private String makeJobDir(Cluster cluster, String sim_uuid, String job_uuid, User user) {
		String dir = cluster.getBaseDir() + user.getStorageSource()+ "/" + Cloud.getInstance().getProp("user.jobpath")
				+ "/" + sim_uuid + "/" + job_uuid + ".job/";
		
		File file = new File(dir);
		if (!file.exists()) {
			LOG.info("creating " + dir);
			file.mkdirs();
			file.setExecutable(true, false);
			file.setReadable(true, false);
			file.setWritable(true, false);
			UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
			try {
				UserPrincipal userPrincipal = lookupService.lookupPrincipalByName(user.getUserId());
				Files.getFileAttributeView(file.toPath(), PosixFileAttributeView.class, LinkOption.NOFOLLOW_LINKS).setOwner(userPrincipal);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return dir;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.service.JobService#createJob(kisti.edison.cloud.model
	 * .Job)
	 */
	@Override
	public Job createJob(Cluster cluster, String sim_uuid, Job job) {
		if (job == null) {
			return job;
		}

		if (job.getFiles() != null) {
			Iterator<String> iter = job.getFiles().keySet().iterator();
			Velocity.init();
			VelocityContext context = new VelocityContext();
			while (iter.hasNext()) {
				String key = iter.next();
				String value = job.getFiles().get(key);
				context.put(key, new String(Base64.decode(value)));
			}

			String execution = job.getExecution();
			StringWriter writer = new StringWriter();
			Velocity.evaluate(context, writer, "edison:tag", execution);
			job.setFileStr(Job.Map2Str(job.getFiles()));
			job.setExecution(writer.toString());
		} else {
			job.setFileStr("");
			job.setExecution(job.getExecution());
		}

		if (job.getAttributes() != null) {
			job.setAttrStr(Job.Map2Str(job.getAttributes()));
		} else {
			job.setAttrStr("");
		}
		
		if (job.getDependencies() != null) {
			job.setDependenciesStr(Job.Map2Str(job.getDependencies()));
		}
		else {
			job.setDependenciesStr("");
		}

		job.setState(Job.JobState.INITIALIZED);
		job.setJobId("");
		

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date submittedTime = new Date();
		String sTime = df.format(submittedTime);
		try {
			job.setSubmittedTime(df.parse(sTime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		job.setSubmittedTime(new Date());
		
		/* Get the user object */
		User user = userService.getUser(job.getUserId());
		Job pJob = simulationService.addJob(sim_uuid, job);
//		pJob.setWorkingDir(generateJobDir(cluster, sim_uuid, pJob.getUuid(), pJob.getUserId()));
		pJob.setWorkingDir(makeJobDir(cluster, sim_uuid, pJob.getUuid(), user));


		
		/* Get the local account object */
		LocalAccount account = localAccountDAO.findLeastUsed(null, cluster.getName());
		pJob.setLocalAccount(account.getLocalId());
		
		Job submittedJob = jobManager.submit(user, cluster, pJob);
		// Job pJob = jobDAO.createJob(null, submittedJob);
		account.setUsedCount(account.getUsedCount()+1);
		localAccountDAO.update(null, account);
		
		Job updatedJob = jobDAO.updateJob(null, submittedJob);

		LOG.info(updatedJob.toString());

		if (updatedJob != null
				&& (updatedJob.getState().equals(Job.JobState.QUEUED) || updatedJob
						.getState().equals(Job.JobState.RUNNING))) {
			jobManager.notifyToWorker(new Command<Job>("ADD", updatedJob));
		}

		return updatedJob;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kisti.edison.cloud.service.JobService#getJob(java.lang.Long)
	 */
	@Override
	public Job findJobByUUID(String uuid) {
		// TODO Auto-generated method stub
		return jobDAO.findJobByUUID(null, uuid);
	}

	@Override
	public List<Job> findJobsByUserId(String userId) {
		// TODO Auto-generated method stub
		return jobDAO.findJobsByUserId(null, userId);
	}

	@Override
	public List<Job> findJobsByGroupId(String groupId) {
		// TODO Auto-generated method stub
		return jobDAO.findJobsByGroupId(null, groupId);
	}

	@Override
	public List<Job> findJobs(String userId, String groupId) {
		// TODO Auto-generated method stub
		return jobDAO.findJobs(null, userId, groupId);
	}

	@Override
	public Job cancel(Cluster cluster, Job job) {
		// TODO Auto-generated method stub
		job.setReqState(Job.JobState.CANCEL_REQUESTED);
		
		/* Get the user object */
		User user = userService.getUser(job.getUserId());

		Job canceledJob = jobManager.cancel(user, cluster, job);
		if (canceledJob != null) {
			jobManager.notifyToWorker(new Command<Job>("DELETE", canceledJob));
		}
		return canceledJob;
	}

	@Override
	public int getJobCount(String state) {
		// TODO Auto-generated method stub
		return jobDAO.getJobCount(null, state);
	}

	@Override
	// Get the job information from pbs job manager, update local database, and return the newest job information
	public Job update(Cluster cluster, Job job) {
		// TODO Auto-generated method stub
		/* Get the user object */
		User user = userService.getUser(job.getUserId());
		Job result = null;
		if(job != null && user != null) {
			if(jobManager.getLock(job.getUuid())){
				try{
					result = jobManager.update(user, cluster, job);
				}catch(Exception e){
					jobManager.releaseLock(job.getUuid());
					LOG.info("Update job failed:" + job);
				}
				if(jobManager.releaseLock(job.getUuid())){
				}
				else{
					//Something wrong..
					LOG.info("JobService::update release lock failed. No such job_uuid - " + job.getUuid());
				}
			}
			else{
				LOG.info("JobService::update update failed. can't get a lock - " + job.getUuid());
			}
			//return jobManager.update(user, cluster, job);
			return result;
		}
		else {
			return null;
		}
	}

	@Override
	public byte[] getErrorLog(Cluster cluster, Job job) {
		// TODO Auto-generated method stub
		/* Get the user object */
		User user = userService.getUser(job.getUserId());
		if(job != null && user != null) {
			return jobManager.getErrorLog(user, cluster, job);
		}
		else {
			return null;
		}
	}

	@Override
	public byte[] getOutputLog(Cluster cluster, Job job) {
		// TODO Auto-generated method stub
		/* Get the user object */
		User user = userService.getUser(job.getUserId());
		if(job != null && user != null) {
			return jobManager.getOutputLog(user, cluster, job);
		}
		else {
			return null;
		}
	}
}
