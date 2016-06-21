/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kisti.edison.cloud.manager.JobManager;
import kisti.edison.cloud.model.Callback;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.model.Job.JobState;
import kisti.edison.cloud.service.ClusterService;
import kisti.edison.cloud.service.SimulationService;
import kisti.edison.cloud.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;

/**
 * @author eairs
 * 
 */
public class JobTasksExecutor {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private class JobTask implements Runnable {
		private JobManager jobManager;
		private UserService userService;
		private ClusterService clusterService;
		private SimulationService simulationService;
		private List<Job> jobs = new LinkedList<Job>();

		public JobTask(UserService userService, ClusterService clusterService, SimulationService simulationService, JobManager jobManager, List<Job> jobs) {
			this.jobManager = jobManager;
			this.userService = userService;
			this.clusterService = clusterService;
			this.simulationService = simulationService;
			for (int i = 0; i < jobs.size(); i++) {
				this.jobs.add(jobs.get(i));
			}
		}

		public void run() {
			for (int i = 0; i < jobs.size(); i++) {
				
				User user = userService.getUser(jobs.get(i).getUserId());
				Cluster cluster = clusterService.findCluster(jobs.get(i).getCluster());
				if(jobManager.getLock(jobs.get(i).getUuid())){
					Job dbJob = jobs.get(i);
					Job updateJob = null;
					try{
						 updateJob = jobManager.update(user, cluster, jobs.get(i));
					}catch(Exception e){
						jobManager.releaseLock(jobs.get(i).getUuid());
						LOG.error("Update job failed:" + dbJob);
						continue;
					}
					if(jobManager.releaseLock(jobs.get(i).getUuid())){
						LOG.info("JobTasksExecutor::JobTask release lock successfully - " + jobs.get(i).getUuid());
					}
					else{
						//Something wrong..
						LOG.error("JobTasksExecutor::JobTask release lock failed. No such job_uuid - " + jobs.get(i).getUuid());
					}
					
//					LOG.info("dbJob: " + dbJob.getState());
					if ( (updateJob != null ) && dbJob.getState() != updateJob.getState() )
					{
//						LOG.info("updateJob: " + updateJob.getState());

//						String sim_uuid = dbJob.getSimulation().getUuid();
						String sim_uuid = jobManager.getSimUuid(dbJob);
						Callback callback = simulationService.getCallback(sim_uuid);
						if ( callback != null )
						{
							simulationService.pushCallback(callback, sim_uuid, updateJob);
						}
					}
				}
				else{
					LOG.error("JobTasksExecutor::JobTask update failed. can't get a lock - " + jobs.get(i).getUuid());
					LOG.error(jobManager.getLockMap());
				}
			}
		}
	}

	private TaskExecutor taskExecutor;

	public JobTasksExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void executeTasks(UserService userService, ClusterService clusterService, JobManager jobManager, SimulationService simulationService, Map<String, Job> monitoredJobs, int nThreads) {
		List<List<Job>> jobList = new LinkedList<List<Job>>();

		for (int i = 0; i < nThreads; i++) {
			jobList.add(new LinkedList<Job>());
		}
		Iterator<String> iter = monitoredJobs.keySet().iterator();

		int index = 0;
		while (iter.hasNext()) {
			String key = iter.next();
			jobList.get(index).add(monitoredJobs.get(key));
			index++;
			if (index == nThreads)
				index = 0;
		}

		int createdThreads = 0;
		List<Thread> tasks = new LinkedList<Thread>();
		for (int i = 0; i < nThreads; i++) {
			if (jobList.get(i).size() != 0) {
				createdThreads++;
				//JobTask task = new JobTask(userService, clusterService, jobManager, jobList.get(i));
				Thread task = new Thread(new JobTask(userService, clusterService, simulationService, jobManager, jobList.get(i)));
				//taskExecutor.execute(task);
				task.start();
				tasks.add(task);
			}
		}
		LOG.info(createdThreads + " threads (job monitoring) executing ... waiting for finishing task(s)");
		
		for(int i = 0 ; i < tasks.size() ; i++) {
			Thread task = tasks.get(i);
			try {
				task.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		LOG.info(createdThreads + " job monitoring threads all completed !!");
	}
}
