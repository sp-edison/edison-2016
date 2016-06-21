/**
 * 
 */
package kisti.edison.cloud.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kisti.edison.cloud.dao.HostDAO;
import kisti.edison.cloud.manager.Command;
import kisti.edison.cloud.manager.HostManager;
import kisti.edison.cloud.model.Host;

/**
 * @author root
 * 
 */
@Transactional
@Service("hostService")
public class HostServiceImpl implements HostService {
	private final Logger LOG = Logger.getLogger(this.getClass());
	private HostDAO hostDAO;
	private HostManager hostManager;

	@Autowired
	public void setHostDAO(HostDAO hostDAO) {
		this.hostDAO = hostDAO;
	}

	public HostManager getHostManager() {
		return hostManager;
	}

	@Autowired
	public void setHostManager(HostManager hostManager) {
		this.hostManager = hostManager;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kisti.edison.cloud.service.HostService#getHost(java.lang.Long)
	 */
	@Override
	public Host getHost(Long id) {
		return hostDAO.getHost(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kisti.edison.cloud.service.HostService#getHosts()
	 */
	@Override
	public List<Host> getHosts(String orderBy, String order) {
		return hostDAO.getAllHosts(orderBy, order);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.service.HostService#createHost(kisti.edison.cloud.
	 * model.Host)
	 */
	@Override
	public Host createHost(Host host) {
		Host createdHost = null;

		if (host.getName().isEmpty()
				|| !(host.getHypervisor() instanceof Host.HostType)) {
			return null;
		}

		host.setRunningVMs(0L);
		host.setState(Host.HostState.UNKNOWN);
		host.setTotalCPU(0L);
		host.setUsedCPU(0L);
		host.setTotalMemory(0L);
		host.setUsedMemory(0L);

		Host allocatedHost = hostManager.allocateHost(host);
		if (allocatedHost != null) {
			createdHost = hostDAO.createHost(allocatedHost);
			if (createdHost != null) {
				hostManager
						.notifyToWorker(new Command<Host>("ADD", createdHost));
			}
		}

		return createdHost;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kisti.edison.cloud.service.HostService#deleteHost(java.lang.Long)
	 */
	@Override
	public void deleteHost(Long id) {
		// TODO Auto-generated method stub
		Host toBeDeleted = getHost(id);
		Host releasedHost = null;

		if (toBeDeleted != null) {
			releasedHost = hostManager.deleteHost(toBeDeleted);
			if (releasedHost != null) {
				releasedHost = hostDAO.deleteHost(id);
				hostManager.notifyToWorker(new Command<Host>("DELETE",
						toBeDeleted));
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.service.HostService#updateHost(kisti.edison.cloud.
	 * model.Host)
	 */
	@Override
	public Host updateHost(Host host) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.service.HostService#isAlreadyExist(java.lang.String)
	 */
	@Override
	public boolean isAlreadyExist(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getHostCount(String state) {
		// TODO Auto-generated method stub
		return hostDAO.getHostCount(state);
	}

	@Override
	public List<Host> queryHosts(String orderBy, String order, int startIndex, int maxResults) {
		// TODO Auto-generated method stub
		return hostDAO.queryHosts(orderBy, order, startIndex, maxResults);
	}
}
