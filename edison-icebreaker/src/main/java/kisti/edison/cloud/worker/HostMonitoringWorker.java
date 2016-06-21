/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import kisti.edison.cloud.manager.Command;
import kisti.edison.cloud.manager.HostManager;
import kisti.edison.cloud.model.Host;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author root
 * 
 */
@Component
public class HostMonitoringWorker {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private Map<Long, Host> monitoredHosts = new HashMap<Long, Host>();

	private HostTasksExecutor hostTasksExecutor;

	@Autowired
	public void setHostTasksExecutor(HostTasksExecutor hostTasksExecutor) {
		this.hostTasksExecutor = hostTasksExecutor;
	}

	@Resource(name = "hostQueue")
	private BlockingQueue<Command<Host>> hostQueue;

	public BlockingQueue<Command<Host>> getHostQueue() {
		return hostQueue;
	}

	public void setHostQueue(BlockingQueue<Command<Host>> hostQueue) {
		this.hostQueue = hostQueue;
	}

	private HostManager hostManager;

	public HostManager getHostManager() {
		return hostManager;
	}

	@Autowired
	public void setHostManager(HostManager hostManager) {
		this.hostManager = hostManager;
	}

	public void dispatchTasks() {
		try {
			// LOG.info("HOST QUEUE SIZE : " + hostQueue.size());

			while (hostQueue.size() != 0) {
				Command<Host> cmd = hostQueue.take();

				if (cmd.getType() == "ADD") {
					if (monitoredHosts
							.put(cmd.getData().getId(), cmd.getData()) == null) {
						// LOG.info("Host ( hostID : " + cmd.getData().getId() +
						// " ) monitoring added.");
					} else {
						// LOG.info("Host ( hostID : " + cmd.getData().getId() +
						// " ) replaced in monitored hosts pool.");
					}
				} else if (cmd.getType() == "DELETE") {
					if (monitoredHosts.remove(cmd.getData().getId()) != null) {
						// LOG.info("Host ( hostID : " + cmd.getData().getId() +
						// " ) monitoring deleted.");
					} else {
						// LOG.info("Host ( hostID : " + cmd.getData().getId() +
						// " ) not found in monitored hosts pool.");
					}
				}
			}

			LOG.info("MONITORED HOSTS SIZE : " + monitoredHosts.size());

			if (monitoredHosts.size() != 0) {
				this.hostTasksExecutor.executeTasks(this.hostManager, monitoredHosts, 1);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
