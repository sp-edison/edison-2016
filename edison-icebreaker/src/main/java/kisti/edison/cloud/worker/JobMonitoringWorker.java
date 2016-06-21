/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import kisti.edison.cloud.manager.Command;
import kisti.edison.cloud.manager.JobManager;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.service.ClusterService;
import kisti.edison.cloud.service.SimulationService;
import kisti.edison.cloud.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author eairs
 * 
 */
@Component
public class JobMonitoringWorker {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private Map<String, Job> monitoredJobs = new HashMap<String, Job>();

	private JobTasksExecutor jobTasksExecutor;

	public JobTasksExecutor getJobTasksExecutor() {
		return jobTasksExecutor;
	}

	@Autowired
	public void setJobTasksExecutor(JobTasksExecutor jobTasksExecutor) {
		this.jobTasksExecutor = jobTasksExecutor;
	}

	@Resource(name = "jobQueue")
	private BlockingQueue<Command<Job>> jobQueue;

	public BlockingQueue<Command<Job>> getJobQueue() {
		return jobQueue;
	}

	private JobManager jobManager;

	public JobManager getJobManager() {
		return jobManager;
	}

	@Autowired
	public void setJobManager(JobManager jobManager) {
		this.jobManager = jobManager;
	}
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private SimulationService simulationService;
	
	@Autowired
	public void setSimulationService(SimulationService simulationService) {
		this.simulationService = simulationService;
	}
	
	private ClusterService clusterService;

	public ClusterService getClusterService() {
		return clusterService;
	}
	
	@Autowired
	public void setClusterService(ClusterService clusterService) {
		this.clusterService = clusterService;
	}

	public void dispatchTasks() {

		try {
			LOG.info("JOB QUEUE SIZE : " + jobQueue.size());

			while (jobQueue.size() != 0) {
				Command<Job> cmd = jobQueue.take();

				if (cmd.getType() == "ADD") {
					if (monitoredJobs.put(cmd.getData().getUuid(),
							cmd.getData()) == null) {
						// LOG.info("Host ( hostID : " + cmd.getData().getId() +
						// " ) monitoring added.");
					} else {
						// LOG.info("Host ( hostID : " + cmd.getData().getId() +
						// " ) replaced in monitored hosts pool.");
					}
				} else if (cmd.getType() == "DELETE") {
					if (monitoredJobs.remove(cmd.getData().getUuid()) != null) {
						// LOG.info("Host ( hostID : " + cmd.getData().getId() +
						// " ) monitoring deleted.");
					} else {
						// LOG.info("Host ( hostID : " + cmd.getData().getId() +
						// " ) not found in monitored hosts pool.");
					}
				}
			}

			LOG.info("MONITORED JOB SIZE : " + monitoredJobs.size());

			if (monitoredJobs.size() != 0) {
				this.jobTasksExecutor.executeTasks(this.userService, this.clusterService, this.jobManager, this.simulationService, monitoredJobs, 12);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
