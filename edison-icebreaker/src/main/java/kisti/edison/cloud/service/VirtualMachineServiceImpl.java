/**
 * 
 */
package kisti.edison.cloud.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kisti.edison.cloud.dao.VirtualMachineDAO;
import kisti.edison.cloud.manager.Command;
import kisti.edison.cloud.manager.VirtualMachineManager;
import kisti.edison.cloud.model.VirtualMachine;

/**
 * @author root
 * 
 */
@Transactional
@Service("virtualMachineService")
public class VirtualMachineServiceImpl implements VirtualMachineService {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private VirtualMachineDAO virtualMachineDAO;

	public VirtualMachineDAO getVirtualMachineDAO() {
		return virtualMachineDAO;
	}

	@Autowired
	public void setVirtualMachineDAO(VirtualMachineDAO virtualMachineDAO) {
		this.virtualMachineDAO = virtualMachineDAO;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.service.VirtualMachineService#getVirtualMachine(java
	 * .lang.Long)
	 */
	@Override
	public VirtualMachine getVirtualMachine(Long id) {
		return virtualMachineDAO.getVirtualMachine(null, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.service.VirtualMachineService#getVirtualMachines()
	 */
	@Override
	public List<VirtualMachine> getVirtualMachines(String orderBy, String order) {
		return virtualMachineDAO.getVirtualMachines(null, orderBy, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.service.VirtualMachineService#getVirtualMachines(java
	 * .lang.String)
	 */
	@Override
	public List<VirtualMachine> getVirtualMachines(String userId, String orderBy, String order) {
		// TODO Auto-generated method stub
		return virtualMachineDAO.getVirtualMachines(null, userId, orderBy, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.service.VirtualMachineService#createVirtualMachine
	 * (kisti.edison.cloud.model.VirtualMachine)
	 */
	@Override
	public VirtualMachine createVirtualMachine(VirtualMachine vm) {
		vm.setState(VirtualMachine.VirtualMachineState.PENDING);
		// vm.setReqCpu(50L);
		// vm.setReqMem(512L);
		// vm.setReqVcpus(2L);

		VirtualMachine cvm = virtualMachineDAO.createVirtualMachine(null, vm);

		if (cvm != null) {
			VirtualMachine createdVM = virtualMachineManager
					.allocateVirtualMachine(cvm);
			if (createdVM != null) {
				virtualMachineManager
						.notifyToWorker(new Command<VirtualMachine>("ADD",
								createdVM));
			}
			return createdVM;
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.service.VirtualMachineService#shutdownVirtualMachine
	 * (java.lang.Long)
	 */
	@Override
	public VirtualMachine shutdownVirtualMachine(Long id) {
		// TODO Auto-generated method stub
		VirtualMachine vm = getVirtualMachine(id);
		vm.setReqState(VirtualMachine.VirtualMachineState.SHUTDOWN_REQ);

		VirtualMachine uvm = virtualMachineDAO.updateVirtualMachineState(null,
				vm);
		if (uvm != null) {
			virtualMachineManager.notifyToWorker(new Command<VirtualMachine>(
					"ADD", uvm));
		}

		return uvm;
	}

	@Override
	public VirtualMachine changeVirtualMachineState(Long id,
			VirtualMachine.VirtualMachineState state) {
		VirtualMachine uvm = virtualMachineDAO.changeVirtualMachineState(null,
				id, state);
		if (uvm != null) {
			virtualMachineManager.notifyToWorker(new Command<VirtualMachine>(
					"ADD", uvm));
		}
		return uvm;
	}

	@Override
	public int getVirtualMachinesCount(String userId, boolean allVMs, String state) {
		return virtualMachineDAO.getVirtualMachinesCount(null, userId, allVMs, state);
	}

	@Override
	public List<VirtualMachine> queryVirtualMachines(String orderBy, String order, int startIndex,
			int maxResults) {
		// TODO Auto-generated method stub
		return virtualMachineDAO.queryVirtualMachines(null, orderBy, order, startIndex,
				maxResults);
	}

	@Override
	public List<VirtualMachine> queryVirtualMachines(String userId, String orderBy, String order,
			int startIndex, int maxResults) {
		// TODO Auto-generated method stub
		return virtualMachineDAO.queryVirtualMachines(null, userId, orderBy, order, startIndex,
				maxResults);
	}
}
