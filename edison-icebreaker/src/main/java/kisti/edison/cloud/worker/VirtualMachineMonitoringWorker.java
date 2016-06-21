/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import kisti.edison.cloud.manager.Command;
import kisti.edison.cloud.manager.VirtualMachineManager;
import kisti.edison.cloud.model.VirtualMachine;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author root
 * 
 */
@Component
public class VirtualMachineMonitoringWorker {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private Map<Long, VirtualMachine> mVMs = new HashMap<Long, VirtualMachine>();

	private VirtualMachineTasksExecutor virtualMachineTasksExecutor;

	public VirtualMachineTasksExecutor getVirtualMachineTasksExecutor() {
		return virtualMachineTasksExecutor;
	}

	@Autowired
	public void setVirtualMachineTasksExecutor(
			VirtualMachineTasksExecutor virtualMachineTasksExecutor) {
		this.virtualMachineTasksExecutor = virtualMachineTasksExecutor;
	}

	@Resource(name = "virtualMachineQueue")
	private BlockingQueue<Command<VirtualMachine>> virtualMachineQueue;

	public BlockingQueue<Command<VirtualMachine>> getVirtualMachineQueue() {
		return virtualMachineQueue;
	}

	public void setVirtualMachineQueue(
			BlockingQueue<Command<VirtualMachine>> virtualMachineQueue) {
		this.virtualMachineQueue = virtualMachineQueue;
	}

	private VirtualMachineManager virtualMachineManager;

	public VirtualMachineManager getVirtualMachineManager() {
		return virtualMachineManager;
	}

	@Autowired
	public void setVirtualMachineManager(
			VirtualMachineManager virtualMachineManager) {
		this.virtualMachineManager = virtualMachineManager;
	}

	public void dispatchTasks() {
		// String threadName = Thread.currentThread().getName();
		// LOG.info("   " + threadName + " has began working. ( " +
		// Thread.currentThread().getId() + " )");
		try {
			// LOG.info("VM QUEUE SIZE : " + virtualMachineQueue.size());

			while (virtualMachineQueue.size() != 0) {
				Command<VirtualMachine> cmd = virtualMachineQueue.take();

				if (cmd.getType() == "ADD") {
					if (mVMs.put(cmd.getData().getId(), cmd.getData()) == null) {
						// LOG.info("VM ( ID : " + cmd.getData().getId() +
						// " ) monitoring added.");
					} else {
						// LOG.info("VM ( ID : " + cmd.getData().getId() +
						// " ) replaced in monitored VMs pool.");
					}
				} else if (cmd.getType() == "DELETE") {
					if (mVMs.remove(cmd.getData().getId()) != null) {
						// LOG.info("VM ( ID : " + cmd.getData().getId() +
						// " ) monitoring deleted.");
					} else {
						// LOG.info("VM ( ID : " + cmd.getData().getId() +
						// " ) not found in monitored VMs pool.");
					}
				}
			}

			LOG.info("MONITORED VM SIZE : " + mVMs.size());

			if (mVMs.size() != 0) {
				// this.virtualMachineTasksExecutor.executeTasks(this.virtualMachineManager,
				// mVMs, 8);
				this.virtualMachineTasksExecutor.executeTasks(this.virtualMachineManager, mVMs, 1);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		// LOG.info("   " + threadName + " has completed work.");
	}
}
