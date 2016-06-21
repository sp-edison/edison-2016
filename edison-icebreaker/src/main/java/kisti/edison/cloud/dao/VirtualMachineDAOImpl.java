/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import kisti.edison.cloud.model.VirtualMachine;

/**
 * @author root
 * 
 */
@Repository("virtualMachineDAO")
@SuppressWarnings("unchecked")
public class VirtualMachineDAOImpl extends HibernateDAO implements
		VirtualMachineDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.dao.VirtualMachineDAO#getVirtualMachine(java.lang.
	 * Long)
	 */
	@Override
	public VirtualMachine getVirtualMachine(Session session, Long id) {
		if (session == null) {
			session = getSession();
		}
		VirtualMachine vm = (VirtualMachine) session.get(VirtualMachine.class,
				id);
		return vm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kisti.edison.cloud.dao.VirtualMachineDAO#getVirtualMachines()
	 */
	@Override
	public List<VirtualMachine> getVirtualMachines(Session session, String orderBy, String order) {
		if (session == null) {
			session = getSession();
		}
		List<VirtualMachine> vms = null;
		
		if(orderBy == null || order == null) {
			vms = session.createQuery(
					"from VirtualMachine order by id").list();	
		}
		else {
			vms = session.createQuery("from VirtualMachine order by " + orderBy + " " + order).list();
		}
		
		return vms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.dao.VirtualMachineDAO#getVirtualMachines(java.lang
	 * .String)
	 */
	@Override
	public List<VirtualMachine> getVirtualMachines(Session session,
			String userId, String orderBy, String order) {
		Assert.hasText(userId);
		if (session == null) {
			session = getSession();
		}
		
		String query = "";
		List<VirtualMachine> vms = null;
		
		if(orderBy == null || order == null) {
			query = "from VirtualMachine vm where vm.userId = :userId order by id";
		}
		else {
			query = "from VirtualMachine vm where vm.userId = :userId order by " + orderBy + " " + order;
		}
		
		vms = session.createQuery(query)
				.setString("userId", userId).list();
		 
		return vms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.dao.VirtualMachineDAO#createVirtualMachine(kisti.edison
	 * .cloud.model.VirtualMachine)
	 */
	@Override
	public VirtualMachine createVirtualMachine(Session session,
			VirtualMachine vm) {
		if (session == null) {
			session = getSession();
		}
		session.save(vm);
		session.flush();
		return vm;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.dao.VirtualMachineDAO#deleteVirtualMachine(java.lang
	 * .Long)
	 */
	@Override
	public void deleteVirtualMachine(Session session, Long id) {
		if (session == null) {
			session = getSession();
		}
		VirtualMachine vm = getVirtualMachine(session, id);
		if (vm != null) {
			session.delete(vm);
			session.flush();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.dao.VirtualMachineDAO#updateVirtualMachine(kisti.edison
	 * .cloud.model.VirtualMachine)
	 */
	@Override
	public VirtualMachine updateVirtualMachine(Session session,
			VirtualMachine vm) {
		// LOG.info("VirtualMachineDAOImpl::updateVirtualMachine() called.");
		Assert.notNull(vm.getId());

		if (session == null) {
			session = getSession();
		}

		if (getVirtualMachine(session, vm.getId()) == null) {
			LOG.info("VM ( " + vm.getId() + " ) DOES NOT EXIST.");
			return null;
		}

		VirtualMachine pvm = (VirtualMachine) session.load(
				VirtualMachine.class, vm.getId());
		// LOG.info("PVM ( " + pvm.getId() + " ) : " + pvm.toString());
		if (vm.getVersion() == pvm.getVersion()) {
			pvm.setUuid(vm.getUuid());
			pvm.setName(vm.getName());
			pvm.setState(vm.getState());
			pvm.setLcmState(vm.getLcmState());
			pvm.setCpu(vm.getCpu());
			pvm.setMemory(vm.getMemory());
			pvm.setNettx(vm.getNettx());
			pvm.setNetrx(vm.getNetrx());
			pvm.setVncUrl(vm.getVncUrl());
			pvm.setHostId(vm.getHostId());
			pvm.setHostUuid(vm.getHostUuid());
			pvm.setReqCpu(vm.getReqCpu());
			pvm.setReqMem(vm.getReqMem());
			pvm.setDisks(vm.getDisks());
			pvm.setNics(vm.getNics());
			session.flush();
			// LOG.info("VM ( " + vm.getId() + " ) UPDATE DONE.");
		} else {
			LOG.info("VM ( " + vm.getId() + " ) VERSION CONFLICT.");
		}
		return pvm;
	}

	@Override
	public VirtualMachine updateVirtualMachineState(Session session,
			VirtualMachine vm) {
		LOG.info("VirtualMachineDAOImpl::updateVirtualMachineState() called.");
		Assert.notNull(vm.getId());

		if (session == null) {
			session = getSession();
		}

		if (getVirtualMachine(session, vm.getId()) == null) {
			LOG.info("VM ( " + vm.getId() + " ) DOES NOT EXIST.");
			return null;
		}

		VirtualMachine pvm = (VirtualMachine) session.load(
				VirtualMachine.class, vm.getId());

		// LOG.info("PVM ( " + pvm.getId() + " ) : " + pvm.toString());

		if (vm.getVersion() == pvm.getVersion()) {
			pvm.setUuid(vm.getUuid());
			pvm.setName(vm.getName());
			pvm.setState(vm.getState());
			pvm.setLcmState(vm.getLcmState());
			pvm.setCpu(vm.getCpu());
			pvm.setMemory(vm.getMemory());
			pvm.setNettx(vm.getNettx());
			pvm.setNetrx(vm.getNetrx());
			pvm.setVncUrl(vm.getVncUrl());
			pvm.setHostId(vm.getHostId());
			pvm.setHostUuid(vm.getHostUuid());
			pvm.setReqCpu(vm.getReqCpu());
			pvm.setReqMem(vm.getReqMem());
			pvm.setReqState(vm.getReqState());
			session.flush();
			LOG.info("VM ( " + vm.getId() + " ) UPDATE DONE.");
		} else {
			LOG.info("VM ( " + vm.getId() + " ) VERSION CONFLICT.");
		}
		return pvm;
	}

	@Override
	public VirtualMachine changeVirtualMachineState(Session session, Long id,
			VirtualMachine.VirtualMachineState state) {
		if (session == null) {
			session = getSession();
		}

		if (getVirtualMachine(session, id) == null) {
			LOG.info("VM ( " + id + " ) DOES NOT EXIST.");
			return null;
		}

		VirtualMachine pvm = (VirtualMachine) session.load(
				VirtualMachine.class, id);
		pvm.setReqState(state);
		session.flush();

		return pvm;
	}

	@Override
	public int getVirtualMachinesCount(Session session, String userId,
			boolean allVMs, String state) {
		Assert.hasText(userId);
		if (session == null) {
			session = getSession();
		}

		int count = 0;
		if (allVMs == true) {
			if(state == null) {
				count = ((Long) session.createQuery(
						"select count(*) from VirtualMachine").uniqueResult())
						.intValue();
			}
			else {
				String query = "select count(*) from VirtualMachine where state = :vmState";
				count = ((Long) getSession().createQuery(query)
						.setString("vmState", state).uniqueResult()).intValue();
			}
		} else {
			String query = "select count(*) from VirtualMachine where userId = :userId";
			count = ((Long) session.createQuery(query)
					.setString("userId", userId).uniqueResult()).intValue();
		}

		return count;
	}

	@Override
	public List<VirtualMachine> queryVirtualMachines(Session session,
			String orderBy, String order, int startIndex, int maxResults) {
		if (session == null) {
			session = getSession();
		}
		Query q;
		if(orderBy == null || order == null) {
			q = session.createQuery("from VirtualMachine order by id");
		}
		else {
			q = session.createQuery("from VirtualMachine order by " + orderBy + " " + order);	
		}
		
		q.setFirstResult(startIndex);
		q.setMaxResults(maxResults);
		List<VirtualMachine> vms = q.list();
		return vms;
	}

	@Override
	public List<VirtualMachine> queryVirtualMachines(Session session,
			String userId, String orderBy, String order, int startIndex, int maxResults) {
		if (session == null) {
			session = getSession();
		}
		
		String query = "";
		
		if(orderBy == null || order == null) {
			query = "from VirtualMachine vm where vm.userId = :userId order by id";
		}
		else {
			query = "from VirtualMachine vm where vm.userId = :userId order by " + orderBy + " " + order;
		}
		
		Query q = session.createQuery(query).setString("userId", userId);
		q.setFirstResult(startIndex);
		q.setMaxResults(maxResults);
		List<VirtualMachine> vms = q.list();
		return vms;
	}

}
