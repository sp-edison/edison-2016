/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import kisti.edison.cloud.manager.ClusterManager;
import kisti.edison.cloud.manager.Command;
import kisti.edison.cloud.model.Cluster;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jlyu
 *
 */
@Component
public class ClusterMonitor {
	private final Logger LOG = Logger.getLogger(this.getClass());
	
	private Map<Long, Cluster> mClusters = new HashMap<Long, Cluster>();

	private ClusterTasks clusterTasks;
	
	public ClusterTasks getClusterTasks() {
		return clusterTasks;
	}
	@Autowired
	public void setClusterTasks(ClusterTasks clusterTasks) {
		this.clusterTasks = clusterTasks;
	}
	
	
	@Resource(name = "clusterQueue")
	private BlockingQueue<Command<Cluster>> clusterQueue;
	
	public BlockingQueue<Command<Cluster>> getClusterQueue() {
		return clusterQueue;
	}

	public void setClusterQueue(BlockingQueue<Command<Cluster>> clusterQueue) {
		this.clusterQueue = clusterQueue;
	}

	
	private ClusterManager clusterManager;
	
	public ClusterManager getClusterManager() {
		return clusterManager;
	}
	@Autowired
	public void setClusterManager(ClusterManager clusterManager) {
		this.clusterManager = clusterManager;
	}
	
	public void dispatchTasks() {
		try {
			while (clusterQueue.size() != 0) {
				Command<Cluster> cmd = clusterQueue.take();
				if (cmd.getType() == "ADD") {
					mClusters.put(cmd.getData().getId(), cmd.getData());
				} 
				else if (cmd.getType() == "DELETE") {
					mClusters.remove(cmd.getData().getId());
				}
			}
			
			LOG.info("MONITORED CLUSTERS SIZE : " + mClusters.size());

			if (mClusters.size() != 0) {
				this.clusterTasks.executeTasks(this.clusterManager, mClusters, 1);
			}
			
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}


}
