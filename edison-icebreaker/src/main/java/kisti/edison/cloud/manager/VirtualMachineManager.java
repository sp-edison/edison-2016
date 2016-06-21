/**
 * 
 */
package kisti.edison.cloud.manager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import kisti.edison.cloud.dao.VirtualMachineDAO;
import kisti.edison.cloud.model.Host;
//import kisti.edison.cloud.model.HostState;
import kisti.edison.cloud.model.VirtualImage;
import kisti.edison.cloud.model.VirtualMachine;
import kisti.edison.cloud.model.VirtualNetwork;
import kisti.edison.cloud.plugin.spec.VirtualMachineAdapter;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author root
 * 
 */
@Component
public class VirtualMachineManager {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private VirtualMachineDAO virtualMachineDAO;

	public VirtualMachineDAO getVirtualMachineDAO() {
		return virtualMachineDAO;
	}

	@Autowired
	public void setVirtualMachineDAO(VirtualMachineDAO virtualMachineDAO) {
		this.virtualMachineDAO = virtualMachineDAO;
	}

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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

	private VirtualMachineAdapter virtualMachineAdapter;

	public VirtualMachineAdapter getVirtualMachineAdapter() {
		return virtualMachineAdapter;
	}

	@Autowired
	public void setVirtualMachineAdapter(
			VirtualMachineAdapter virtualMachineAdapter) {
		this.virtualMachineAdapter = virtualMachineAdapter;
	}

	private VirtualImageManager virtualImageManager;

	public VirtualImageManager getVirtualImageManager() {
		return virtualImageManager;
	}

	@Autowired
	public void setVirtualImageManager(VirtualImageManager virtualImageManager) {
		this.virtualImageManager = virtualImageManager;
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

	private HostManager hostManager;

	public HostManager getHostManager() {
		return hostManager;
	}

	@Autowired
	public void setHostManager(HostManager hostManager) {
		this.hostManager = hostManager;
	}

	private void checkReleaseResources(VirtualMachine vm, Host host,
			VirtualNetwork nic, VirtualImage disk) {
		if ((host == null) || (nic == null) || (disk == null)) {
			if (host != null)
				hostManager.releaseHost(host.getId(), vm.getReqCpu());
			if (nic != null)
				virtualNetworkManager.releaseVirtualNetwork(nic.getId());
			if (disk != null)
				virtualImageManager.releaseVirtualImage(disk.getId());
		}
	}

	public VirtualMachineManager() {
	}

	@Transactional
	public synchronized VirtualMachine allocateVirtualMachine(VirtualMachine vm) {
		LOG.info("allocateVirtualMachine( VMID : " + vm.getId() + " )");
		VirtualMachine fvm = null;
		Long hostId = -1L;
		Long minCPU = Long.MAX_VALUE;

		/* TODO : SCHEDULING MODULE REQUIRED */
		List<Host> availHosts = hostManager.getHosts();
		for (Host host : availHosts) {
			if (host.getState().equals(Host.HostState.READY)) {
				if (host.getUsedCPU() < minCPU) {
					minCPU = host.getUsedCPU();
					hostId = host.getId();
				}
			}
		}

		if (availHosts == null || availHosts.size() == 0 || hostId.equals(-1L)) {
			LOG.info("allocateVirtualMachine() : NO (RUNNING) HOSTS");
			vm.setState(VirtualMachine.VirtualMachineState.ERROR);
			Session session = SessionFactoryUtils.getSession(
					this.sessionFactory, true);
			Transaction tx = session.beginTransaction();
			fvm = virtualMachineDAO.updateVirtualMachine(session, vm);
			tx.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);
			if (fvm != null) {
				notifyToWorker(new Command<VirtualMachine>("ADD", fvm));
			}
			// no available hosts
			return fvm;
		}

		Host host = hostManager.acquireHost(hostId, vm.getReqCpu());
		VirtualNetwork nic = virtualNetworkManager.acquireIdleVirtualNetwork();
		VirtualImage disk = virtualImageManager.acquireIdleVirtualImage();
		if ((host == null) || (nic == null) || (disk == null)) {
			LOG.info("allocateVirtualMachine() : NO RESOURCES");
			checkReleaseResources(vm, host, nic, disk);
			vm.setState(VirtualMachine.VirtualMachineState.ERROR);
			Session session = SessionFactoryUtils.getSession(
					this.sessionFactory, true);
			Transaction tx = session.beginTransaction();
			fvm = virtualMachineDAO.updateVirtualMachine(session, vm);
			tx.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);
			if (fvm != null) {
				notifyToWorker(new Command<VirtualMachine>("ADD", fvm));
			}
			// resource acquisition fail
			return fvm;
		}

		vm.setHostId(hostId);
		vm.setHostName(host.getName());
		vm.setHostUuid(host.getUuid());

		Set<VirtualImage> disks = new HashSet<VirtualImage>();
		disks.add(disk);
		vm.setDisks(disks);

		Set<VirtualNetwork> nics = new HashSet<VirtualNetwork>();
		nics.add(nic);
		vm.setNics(nics);

		/* TODO : XenVirtualMachineAdapter */
		VirtualMachine avm = virtualMachineAdapter.allocateVirtualMachine(host,
				vm);
		if (avm == null) {
			LOG.info("allocateVirtualMachine() : ADAPTER FAIL");
			checkReleaseResources(vm, host, nic, disk);
			vm.setState(VirtualMachine.VirtualMachineState.ERROR);
			Session session = SessionFactoryUtils.getSession(
					this.sessionFactory, true);
			Transaction tx = session.beginTransaction();
			fvm = virtualMachineDAO.updateVirtualMachine(session, vm);
			tx.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);
			if (fvm != null) {
				notifyToWorker(new Command<VirtualMachine>("ADD", fvm));
			}
			// adapter fail
			return fvm;
		}

		avm.setState(VirtualMachine.VirtualMachineState.STARTING);

		LOG.info("VM : " + avm.toString());
		Session session = SessionFactoryUtils.getSession(this.sessionFactory,
				true);
		Transaction tx = session.beginTransaction();
		fvm = virtualMachineDAO.updateVirtualMachine(session, avm);
		tx.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		if (fvm != null) {
			notifyToWorker(new Command<VirtualMachine>("ADD", fvm));
		}

		LOG.info("allocateVirtualMachine( VMID : " + vm.getId() + " ) SUCCESS.");
		return fvm;
	}

	@Transactional
	public synchronized void shutdownVirtualMachine(VirtualMachine vm) {
		LOG.info("shutdownVirtualMachine( VMID : " + vm.getId() + " )");

		if (vm.getUuid() != null && !vm.getUuid().isEmpty()) {
			VirtualMachine svm = virtualMachineAdapter
					.shutdownVirtualMachine(vm);
			if (svm != null) {
				Session session = SessionFactoryUtils.getSession(
						this.sessionFactory, true);
				Transaction tx = session.beginTransaction();
				Host host = hostManager.getHost(vm.getHostId());
				Set<VirtualImage> disks = vm.getDisks();
				Set<VirtualNetwork> nics = vm.getNics();
				if ((nics != null) && (nics.size() != 0)) {
					for (VirtualNetwork nic : nics) {
						virtualNetworkManager
								.releaseVirtualNetwork(nic.getId());
					}
				}

				if ((disks != null) && (disks.size() != 0)) {
					for (VirtualImage disk : disks) {
						virtualImageManager.releaseVirtualImage(disk.getId());
					}
				}

				if (host != null) {
					hostManager.releaseHost(host.getId(), vm.getReqCpu());
				}

				virtualMachineDAO.deleteVirtualMachine(session, vm.getId());
				tx.commit();
				SessionFactoryUtils
						.releaseSession(session, this.sessionFactory);

				notifyToWorker(new Command<VirtualMachine>("DELETE", vm));
			} else {
				LOG.info("shutdownVirtualMachine( VMID : " + vm.getId()
						+ " ) ADAPTER FAIL");
				return;
			}
		} else
			return;

		LOG.info("shutdownVirtualMachine( VMID : " + vm.getId() + " ) SUCCESS.");
	}

	@Transactional
	public synchronized void suspendVirtualMachine(VirtualMachine vm) {
		LOG.info("suspendVirtualMachine( VMID : " + vm.getId() + " )");

		if (vm.getUuid() == null || vm.getUuid().isEmpty()) {
			return;
		}
		VirtualMachine svm = virtualMachineAdapter.suspendVirtualMachine(vm);
		if (svm == null) {
			LOG.info("suspendVirtualMachine( VMID : " + vm.getId()
					+ " ) ADAPTER FAIL");
			return;
		}

		Session session = SessionFactoryUtils.getSession(this.sessionFactory,
				true);
		Transaction tx = session.beginTransaction();
		VirtualMachine fvm = virtualMachineDAO.updateVirtualMachine(session,
				svm);
		tx.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		if (fvm != null) {
			notifyToWorker(new Command<VirtualMachine>("ADD", fvm));
		}
		LOG.info("suspendVirtualMachine( VMID : " + vm.getId() + " ) SUCCESS.");
	}

	@Transactional
	public synchronized void resumeVirtualMachine(VirtualMachine vm) {
		LOG.info("resumeVirtualMachine( VMID : " + vm.getId() + " )");

		if (vm.getUuid() == null || vm.getUuid().isEmpty()) {
			return;
		}
		VirtualMachine rvm = virtualMachineAdapter.resumeVirtualMachine(vm);
		if (rvm == null) {
			LOG.info("resumeVirtualMachine( VMID : " + vm.getId()
					+ " ) ADAPTER FAIL");
			return;
		}

		Session session = SessionFactoryUtils.getSession(this.sessionFactory,
				true);
		Transaction tx = session.beginTransaction();
		VirtualMachine fvm = virtualMachineDAO.updateVirtualMachine(session,
				rvm);
		tx.commit();
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		if (fvm != null) {
			notifyToWorker(new Command<VirtualMachine>("ADD", fvm));
		}
		LOG.info("resumeVirtualMachine( VMID : " + vm.getId() + " ) SUCCESS.");
	}

	@Transactional
	public void purgeVirtualMachine(VirtualMachine vm) {
		if (vm != null) {
			Session session = SessionFactoryUtils.getSession(this.sessionFactory, true);
			Transaction tx = session.beginTransaction();
			
			Host host = hostManager.getHost(vm.getHostId());
			Set<VirtualImage> disks = vm.getDisks();
			Set<VirtualNetwork> nics = vm.getNics();
			if ((nics != null) && (nics.size() != 0)) {
				for (VirtualNetwork nic : nics) {
					virtualNetworkManager.releaseVirtualNetwork(nic.getId());
				}
			}
	
			if ((disks != null) && (disks.size() != 0)) {
				for (VirtualImage disk : disks) {
					virtualImageManager.releaseVirtualImage(disk.getId());
				}
			}
	
			if (host != null) {
				hostManager.releaseHost(host.getId(), vm.getReqCpu());
			}
	
			virtualMachineDAO.deleteVirtualMachine(session, vm.getId());
			tx.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		}
	}

	@Transactional
	public synchronized void updateVirtualMachine(VirtualMachine vm) {
		// LOG.info("updateVirtualMachine( VMID : " + vm.getId() + " )");
		VirtualMachine uvm = virtualMachineAdapter
				.retrieveVirtualMachineInfo(vm);

		if (uvm != null) {
			// LOG.info( "===== VM LCM STATE : " + uvm.getLcmState() );
			if (uvm.getLcmState().equals("RUNNING")) {
				Host host = hostManager.getHost(vm.getHostId());
				uvm.setState(VirtualMachine.VirtualMachineState.RUNNING);
				uvm.setVncUrl(host.getName() + "::" + (5900L + uvm.getId()));
			} else if (uvm.getLcmState().equals("SUSPENDED")) {
				uvm.setState(VirtualMachine.VirtualMachineState.SUSPENDED);
			} else {
				// LOG.info( "===== VM LCM STATE (ELSE) : " + uvm.getLcmState()
				// );
				// uvm.setState( VirtualMachine.VirtualMachineState.ERROR );
			}

			// LOG.info( "UVM : " + uvm.toString() );
			Session session = SessionFactoryUtils.getSession(
					this.sessionFactory, true);
			Transaction tx = session.beginTransaction();
			VirtualMachine fvm = virtualMachineDAO.updateVirtualMachine(
					session, uvm);
			tx.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);
			if (fvm != null) {
				// LOG.info( "FVM : " + fvm.toString() );
				notifyToWorker(new Command<VirtualMachine>("ADD", fvm));
			}
			// LOG.info("VM ( " + vm.getId() + ", " + uvm.getLcmState() +
			// " ) UPDATE DONE.");
		} else {
			LOG.info("updateVirtualMachine( VMID : " + vm.getId()
					+ " ) ADAPTER FAIL");
		}
	}

	public void notifyToWorker(Command<VirtualMachine> cmd) {
		try {
			virtualMachineQueue.put(cmd);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
