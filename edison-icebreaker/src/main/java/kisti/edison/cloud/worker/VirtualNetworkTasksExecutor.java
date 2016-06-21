/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kisti.edison.cloud.manager.VirtualNetworkManager;
import kisti.edison.cloud.model.VirtualNetwork;

import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;

/**
 * @author root
 * 
 */
public class VirtualNetworkTasksExecutor {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private class VirtualNetworkTask implements Runnable {
		private VirtualNetworkManager vnManager;
		private List<VirtualNetwork> VNS = new LinkedList<VirtualNetwork>();

		public VirtualNetworkTask(VirtualNetworkManager vnManager,
				List<VirtualNetwork> VNS) {
			this.vnManager = vnManager;
			for (int i = 0; i < VNS.size(); i++) {
				this.VNS.add(VNS.get(i));
			}
		}

		public void run() {
			// String threadName = Thread.currentThread().getName();
			// LOG.info(threadName + " task start. ( " +
			// Thread.currentThread().getId() + " )");
			for (int i = 0; i < VNS.size(); i++) {
				vnManager.updateVirtualNetworks(VNS.get(i));
			}
			// LOG.info(threadName + " task end. ( " +
			// Thread.currentThread().getId() + " )");
		}
	}

	private TaskExecutor taskExecutor;

	public VirtualNetworkTasksExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void executeTasks(VirtualNetworkManager vnManager,
			Map<Long, VirtualNetwork> monitoredVNS, int nThreads) {
		List<List<VirtualNetwork>> netList = new LinkedList<List<VirtualNetwork>>();

		for (int i = 0; i < nThreads; i++) {
			netList.add(new LinkedList<VirtualNetwork>());
		}
		Iterator<Long> iter = monitoredVNS.keySet().iterator();

		int index = 0;
		while (iter.hasNext()) {
			Long key = iter.next();
			netList.get(index).add(monitoredVNS.get(key));
			index++;
			if (index == nThreads)
				index = 0;
		}

		int createdThreads = 0;
		for (int i = 0; i < nThreads; i++) {
			if (netList.get(i).size() != 0) {
				createdThreads++;
				taskExecutor.execute(new VirtualNetworkTask(vnManager, netList
						.get(i)));
			}
		}
		// LOG.info(createdThreads +
		// " threads (virtual network monitoring) executing ...");
	}
}
