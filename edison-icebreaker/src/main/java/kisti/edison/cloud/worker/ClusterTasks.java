/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kisti.edison.cloud.manager.ClusterManager;
import kisti.edison.cloud.manager.HostManager;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Host;

import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;

/**
 * @author jlyu
 *
 */
public class ClusterTasks {
	private final Logger LOG = Logger.getLogger(this.getClass());
	
	private class ClusterTask implements Runnable {
		private ClusterManager clusterManager;
		private List<Cluster> clusters = new LinkedList<Cluster>();

		public ClusterTask(ClusterManager clusterManager, List<Cluster> clusters) {
			this.clusterManager = clusterManager;
			for (int i = 0; i < clusters.size(); i++) {
				this.clusters.add(clusters.get(i));
			}
		}

		public void run() {
			for (int i = 0; i < clusters.size(); i++) {
				clusterManager.updateCluster(clusters.get(i));
			}
		}
	}
	
	private TaskExecutor taskExecutor;

	public ClusterTasks(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}
	
	
	public void executeTasks(ClusterManager clusterManager, Map<Long, Cluster> mClusters, int nThreads) {
		List<List<Cluster>> clusterList = new LinkedList<List<Cluster>>();

		for (int i = 0; i < nThreads; i++) {
			clusterList.add(new LinkedList<Cluster>());
		}
		Iterator<Long> iter = mClusters.keySet().iterator();

		int index = 0;
		while (iter.hasNext()) {
			Long key = iter.next();
			clusterList.get(index).add(mClusters.get(key));
			index++;
			if (index == nThreads)
				index = 0;
		}

		int createdThreads = 0;
		for (int i = 0; i < nThreads; i++) {
			if (clusterList.get(i).size() != 0) {
				createdThreads++;
				taskExecutor.execute(new ClusterTask(clusterManager, clusterList.get(i)));
			}
		}
	}
}
