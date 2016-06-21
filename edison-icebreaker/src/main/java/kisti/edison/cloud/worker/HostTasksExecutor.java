/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kisti.edison.cloud.manager.HostManager;
import kisti.edison.cloud.model.Host;

import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;

/**
 * @author root
 * 
 */
public class HostTasksExecutor {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private class HostTask implements Runnable {
		private HostManager hostManager;
		private List<Host> hosts = new LinkedList<Host>();

		public HostTask(HostManager hostManager, List<Host> hosts) {
			this.hostManager = hostManager;
			for (int i = 0; i < hosts.size(); i++) {
				this.hosts.add(hosts.get(i));
			}
		}

		public void run() {
			// String threadName = Thread.currentThread().getName();
			// LOG.info(threadName + " task start. ( " +
			// Thread.currentThread().getId() + " )");
			for (int i = 0; i < hosts.size(); i++) {
				hostManager.updateHost(hosts.get(i));
			}
			// LOG.info(threadName + " task end. ( " +
			// Thread.currentThread().getId() + " )");
		}
	}

	private TaskExecutor taskExecutor;

	public HostTasksExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void executeTasks(HostManager hostManager,
			Map<Long, Host> monitoredHosts, int nThreads) {
		List<List<Host>> hostList = new LinkedList<List<Host>>();

		for (int i = 0; i < nThreads; i++) {
			hostList.add(new LinkedList<Host>());
		}
		Iterator<Long> iter = monitoredHosts.keySet().iterator();

		int index = 0;
		while (iter.hasNext()) {
			Long key = iter.next();
			hostList.get(index).add(monitoredHosts.get(key));
			index++;
			if (index == nThreads)
				index = 0;
		}

		int createdThreads = 0;
		for (int i = 0; i < nThreads; i++) {
			if (hostList.get(i).size() != 0) {
				createdThreads++;
				taskExecutor
						.execute(new HostTask(hostManager, hostList.get(i)));
			}
		}
		// LOG.info(createdThreads +
		// " threads (host monitoring) executing ...");
	}
}
