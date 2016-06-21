/**
 * 
 */
package kisti.edison.cloud.manager;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import kisti.edison.cloud.dao.HostDAO;
import kisti.edison.cloud.model.Host;
import kisti.edison.cloud.plugin.spec.HostAdapter;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;

/**
 * @author root
 * 
 */

@Component
public class HostManager {
	private final Logger LOG = Logger.getLogger(this.getClass());

	private HostDAO hostDAO;

	@Autowired
	public void setHostDAO(HostDAO hostDAO) {
		this.hostDAO = hostDAO;
	}

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Resource(name = "hostQueue")
	private BlockingQueue<Command<Host>> hostQueue;

	public void setHostQueue(BlockingQueue<Command<Host>> hostQueue) {
		this.hostQueue = hostQueue;
	}

	public BlockingQueue<Command<Host>> getHostQueue() {
		return hostQueue;
	}

	private HostAdapter hostAdapter;

	public HostAdapter getHostAdapter() {
		return hostAdapter;
	}

	@Autowired
	public void setHostAdapter(HostAdapter hostAdapter) {
		this.hostAdapter = hostAdapter;
	}

	public HostManager() {
	}

	public Host getHost(Long id) {
		return hostDAO.getHost(id);
	}

	public List<Host> getHosts() {
		return hostDAO.getAllHosts(null, null);
	}

	public Host acquireHost(Long id, Long cpu) {
		return hostDAO.acquireHost(id, cpu);
	}

	public Host releaseHost(Long id, Long cpu) {
		return hostDAO.releaseHost(id, cpu);
	}

	public Host allocateHost(Host host) {
		return hostAdapter.allocateHost(host);
	}

	public Host deleteHost(Host host) {
		return hostAdapter.releaseHost(host);
	}

	@Transactional
	public synchronized void updateHost(Host host) {
		Session session = null;
		Transaction tx = null;
		Host retrievedHost = hostAdapter.getHostInformation(host);
		if (retrievedHost != null) {
			session = SessionFactoryUtils.getSession(this.sessionFactory, true);
			tx = session.beginTransaction();
			Host updatedHost = hostDAO.updateHost(retrievedHost);
			tx.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);

			if (updatedHost != null) {
				this.notifyToWorker(new Command<Host>("ADD", updatedHost));
			}

			LOG.info("HOST ( " + retrievedHost.getName() + " ) : "
					+ retrievedHost.getState().toString());
		} else {
			LOG.info("HOST ( " + host.getName() + " ) UPDATE FAILED.");
		}
	}

	
	@Transactional
	public synchronized void purgeHost(Host host) {
		if(host != null) {
			Session session = SessionFactoryUtils.getSession(this.sessionFactory, true);
			Transaction tx = session.beginTransaction();
			hostDAO.deleteHost(host.getId());
			tx.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		}
	}
	
	
	public void notifyToWorker(Command<Host> cmd) {
		try {
			hostQueue.put(cmd);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
