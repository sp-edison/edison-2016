/**
 * 
 */
package kisti.edison.cloud.manager;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import kisti.edison.cloud.dao.VirtualNetworkDAO;
import kisti.edison.cloud.model.VirtualNetwork;
import kisti.edison.cloud.plugin.spec.VirtualNetworkAdapter;

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
public class VirtualNetworkManager {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private VirtualNetworkDAO virtualNetworkDAO;

	public VirtualNetworkDAO getVirtualNetworkDAO() {
		return virtualNetworkDAO;
	}

	@Autowired
	public void setVirtualNetworkDAO(VirtualNetworkDAO virtualNetworkDAO) {
		this.virtualNetworkDAO = virtualNetworkDAO;
	}

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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

	private VirtualNetworkAdapter virtualNetworkAdapter;

	public VirtualNetworkAdapter getVirtualNetworkAdapter() {
		return virtualNetworkAdapter;
	}

	@Autowired
	public void setVirtualNetworkAdapter(
			VirtualNetworkAdapter virtualNetworkAdapter) {
		this.virtualNetworkAdapter = virtualNetworkAdapter;
	}

	public VirtualNetworkManager() {
	}

	public VirtualNetwork acquireIdleVirtualNetwork() {
		return virtualNetworkDAO.acquireIdleVirtualNetwork();
	}

	public VirtualNetwork releaseVirtualNetwork(Long id) {
		return virtualNetworkDAO.releaseVirtualNetwork(id);
	}
	
	@Transactional
	public void purgeVirtualNetwork(VirtualNetwork vn) {
		if( vn != null ) {
			Session session = SessionFactoryUtils.getSession(this.sessionFactory, true);
			Transaction tx = session.beginTransaction();
			virtualNetworkDAO.deleteVirtualNetwork(vn.getId());
			tx.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		}
	}

	@Transactional
	public void updateVirtualNetworks(VirtualNetwork vn) {
		List<VirtualNetwork> vns = this.virtualNetworkAdapter
				.retrieveVirtualNetworks(vn.getUuid());

		if (vns != null) {
			Session session = SessionFactoryUtils.getSession(
					this.sessionFactory, true);
			Transaction tx = session.beginTransaction();
			for (VirtualNetwork aVN : vns) {
				VirtualNetwork foundVN = null;
				if ((foundVN = virtualNetworkDAO.findVirtualNetworkByIP(aVN
						.getIp())) != null) {
					aVN.setId(foundVN.getId());
					virtualNetworkDAO.updateVirtualNetwork(aVN);
				} else {
					virtualNetworkDAO.createVirtualNetwork(aVN);
				}
			}
			tx.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);

			LOG.info("VIRTUAL NETWORK ( IP POOL SIZE : " + vns.size()
					+ " ) UPDATE SUCCESS.");
		} else {
			LOG.info("VIRTUAL NETWORK ( UUID : " + vn.getUuid()
					+ " ) UPDATE FAILED.");
		}
	}

	public void notifyToWorker(Command<VirtualNetwork> cmd) {
		try {
			virtualNetworkQueue.put(cmd);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
