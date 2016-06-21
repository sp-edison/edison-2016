/**
 * 
 */
package kisti.edison.cloud.worker;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kisti.edison.cloud.manager.Command;
import kisti.edison.cloud.manager.VirtualMachineManager;
import kisti.edison.cloud.model.VirtualMachine;

import org.apache.log4j.Logger;
import org.springframework.core.task.TaskExecutor;

/**
 * @author root
 * 
 */
public class VirtualMachineTasksExecutor {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private class VirtualMachineTask implements Runnable {
		private VirtualMachineManager virtualMachineManager;
		private List<VirtualMachine> vms = new LinkedList<VirtualMachine>();

		public VirtualMachineTask(VirtualMachineManager virtualMachineManager,
				List<VirtualMachine> vms) {
			this.virtualMachineManager = virtualMachineManager;
			for (int i = 0; i < vms.size(); i++) {
				this.vms.add(vms.get(i));
			}
		}

		public void run() {
			String threadName = Thread.currentThread().getName();
			// LOG.info(threadName + " task start. ( " +
			// Thread.currentThread().getId() + " )");
			for (VirtualMachine vm : vms) {
				if (vm.getState().equals(
						VirtualMachine.VirtualMachineState.PENDING)) {
					virtualMachineManager.allocateVirtualMachine(vm);
				} else if (vm.getState().equals(
						VirtualMachine.VirtualMachineState.STARTING)
						|| vm.getState().equals(
								VirtualMachine.VirtualMachineState.RUNNING)
						|| vm.getState().equals(
								VirtualMachine.VirtualMachineState.SUSPENDED)) {
					virtualMachineManager.updateVirtualMachine(vm);
				} else {

					// "ERROR" state
					LOG.info("VMID ( " + vm.getId() + " : " + vm.getState()
							+ " )");
					virtualMachineManager
							.notifyToWorker(new Command<VirtualMachine>("ADD",
									vm));
				}

				if (vm.getReqState() != null
						&& vm.getReqState()
								.equals(VirtualMachine.VirtualMachineState.SHUTDOWN_REQ)
						&& (vm.getLcmState() != null
						&& vm.getLcmState().equals("RUNNING")) || (vm.getLcmState() != null
								&& vm.getLcmState().equals("UNKNOWN"))) {
					virtualMachineManager.shutdownVirtualMachine(vm);
				} else if (vm.getReqState() != null
						&& vm.getReqState().equals(
								VirtualMachine.VirtualMachineState.SUSPEND_REQ)
						&& vm.getLcmState() != null
						&& vm.getLcmState().equals("RUNNING")) {
					virtualMachineManager.suspendVirtualMachine(vm);
				} else if (vm.getReqState() != null
						&& vm.getReqState().equals(
								VirtualMachine.VirtualMachineState.RESUME_REQ)
						&& vm.getLcmState() != null
						&& vm.getLcmState().equals("SUSPENDED")) {
					virtualMachineManager.resumeVirtualMachine(vm);
				}

			}
			// LOG.info(threadName + " task end. ( " +
			// Thread.currentThread().getId() + " )");
		}
	}

	private TaskExecutor taskExecutor;

	public VirtualMachineTasksExecutor(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void executeTasks(VirtualMachineManager virtualMachineManager,
			Map<Long, VirtualMachine> mVMs, int nThreads) {
		List<List<VirtualMachine>> vmsList = new LinkedList<List<VirtualMachine>>();

		for (int i = 0; i < nThreads; i++) {
			vmsList.add(new LinkedList<VirtualMachine>());
		}
		Iterator<Long> iter = mVMs.keySet().iterator();

		int index = 0;
		while (iter.hasNext()) {
			Long key = iter.next();
			vmsList.get(index).add(mVMs.get(key));
			index++;
			if (index == nThreads)
				index = 0;
		}

		int createdThreads = 0;
		for (int i = 0; i < nThreads; i++) {
			if (vmsList.get(i).size() != 0) {
				createdThreads++;
				taskExecutor.execute(new VirtualMachineTask(
						virtualMachineManager, vmsList.get(i)));
			}
		}
		// LOG.info(createdThreads + " threads (vm monitoring) executing ...");
	}
}
