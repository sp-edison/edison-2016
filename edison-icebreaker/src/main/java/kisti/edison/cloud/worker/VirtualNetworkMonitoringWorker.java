/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import kisti.edison.cloud.manager.Command;
import kisti.edison.cloud.manager.VirtualNetworkManager;
import kisti.edison.cloud.model.VirtualNetwork;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author root
 * 
 */
@Component
public class VirtualNetworkMonitoringWorker {
	private final Logger LOG = Logger.getLogger(this.getClass());
	private Map<Long, VirtualNetwork> monitoredVNS = new HashMap<Long, VirtualNetwork>();

	private VirtualNetworkTasksExecutor virtualNetworkTasksExecutor;

	@Autowired
	public void setVirtualNetworkTasksExecutor(
			VirtualNetworkTasksExecutor virtualNetworkTasksExecutor) {
		this.virtualNetworkTasksExecutor = virtualNetworkTasksExecutor;
	}

	@Resource(name = "virtualNetworkQueue")
	private BlockingQueue<Command<VirtualNetwork>> virtualNetworkQueue;

	public BlockingQueue<Command<VirtualNetwork>> getVirtualNetworkQueue() {
		return virtualNetworkQueue;
	}

	public void setVirtualNetworkQueue(
			BlockingQueue<Command<VirtualNetwork>> virtualNetworkQueue) {
		this.virtualNetworkQueue = virtualNetworkQueue;
	}

	private VirtualNetworkManager virtualNetworkManager;

	public VirtualNetworkManager getVirtualNetworkManager() {
		return virtualNetworkManager;
	}

	@Autowired
	public void setVirtualNetworkManager(
			VirtualNetworkManager virtualNetworkManager) {
		this.virtualNetworkManager = virtualNetworkManager;
	}

	public void dispatchTasks() {
		// String threadName = Thread.currentThread().getName();
		// LOG.info("   " + threadName + " has began working. ( " +
		// Thread.currentThread().getId() + " )");

		try {
			// LOG.info("VN QUEUE SIZE : " + virtualNetworkQueue.size());

			while (virtualNetworkQueue.size() != 0) {
				Command<VirtualNetwork> cmd = virtualNetworkQueue.take();

				if (cmd.getType() == "ADD") {
					if (monitoredVNS.put(cmd.getData().getId(), cmd.getData()) == null) {
						 //LOG.info("VirtualNetwork ( ID : " +
						 //cmd.getData().getId() + " ) monitoring added.");
					} else {
						// LOG.info("VirtualNetwork ( ID : " +
						// cmd.getData().getId() + " ) replaced.");
					}
				} else if (cmd.getType() == "DELETE") {
					if (monitoredVNS.remove(cmd.getData().getId()) != null) {
						// LOG.info("VirtualNetwork ( ID : " +
						// cmd.getData().getId() + " ) monitoring deleted.");
					} else {
						// LOG.info("VirtualNetwork ( ID : " +
						// cmd.getData().getId() + " ) not found.");
					}
				}
			}

			LOG.info("MONITORED VNS SIZE : " + monitoredVNS.size());
			if (monitoredVNS.size() != 0) {
				this.virtualNetworkTasksExecutor.executeTasks(this.virtualNetworkManager, monitoredVNS, 1);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		// LOG.info("   " + threadName + " has completed work.");
	}
}
