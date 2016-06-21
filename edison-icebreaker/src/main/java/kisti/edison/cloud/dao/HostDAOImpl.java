package kisti.edison.cloud.dao;

import java.util.List;

import kisti.edison.cloud.model.Host;
import kisti.edison.cloud.model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("hostDAO")
@SuppressWarnings("unchecked")
public class HostDAOImpl extends HibernateDAO implements HostDAO {
	@Override
	public Host getHost(Long id) {
		Session session = getSession();
		Host host = (Host) session.get(Host.class, id);
		return host;
	}

	@Override
	public List<Host> getAllHosts(String orderBy, String order) {
		Session session = getSession();
		List<Host> hosts = null;
		if(orderBy == null || order == null) {
			hosts = session.createQuery("from Host order by id").list();
		}
		else {
			hosts = session.createQuery("from Host order by " + orderBy + " " + order).list();
		}
		
		return hosts;
	}

	@Override
	public Host createHost(Host host) {
		Session session = getSession();
		session.save(host);
		session.flush();
		return host;
	}

	@Override
	public Host findHost(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Host deleteHost(Long id) {
		Host host = getHost(id);
		if (host != null) {
			Session session = getSession();
			session.delete(host);
			session.flush();
		}

		return host;
	}

	@Override
	public Host updateHost(Host host) {
		if (getHost(host.getId()) == null) {
			LOG.info("HOST ENTITY NOT EXIST.");
			return null;
		}

		Session session = getSession();
		Host persistentHost = (Host) session.load(Host.class, host.getId());

		// if( persistentHost.getVersion() == host.getVersion() ) {
		persistentHost.setArchitecture(host.getArchitecture());
		persistentHost.setConnectUrl(host.getConnectUrl());
		persistentHost.setUuid(host.getUuid());
		persistentHost.setName(host.getName());
		persistentHost.setRunningVMs(host.getRunningVMs());
		persistentHost.setState(host.getState());
		persistentHost.setTotalCPU(host.getTotalCPU());
		// persistentHost.setUsedCPU(host.getUsedCPU());
		persistentHost.setTotalMemory(host.getTotalMemory());
		persistentHost.setUsedMemory(host.getUsedMemory());
		persistentHost.setModel(host.getModel());
		persistentHost.setCpuSpeed(host.getCpuSpeed());
		session.flush();
		//LOG.info("UPDATE HOST DONE.");
		// }
		// else {
		// LOG.info("HOST VERSION CONFLICTING.");
		// }

		return persistentHost;
	}

	@Override
	public Host acquireHost(Long id, Long cpu) {
		Session session = getSession();
		Host phost = (Host) session.load(Host.class, id);
		if (phost != null) {
			if ((phost.getUsedCPU() + cpu) > phost.getTotalCPU()) {
				return null;
			}
			phost.setUsedCPU(phost.getUsedCPU() + cpu);
			session.flush();
			return phost;
		} else
			return phost;
	}

	@Override
	public Host releaseHost(Long id, Long cpu) {
		Session session = getSession();
		Host phost = (Host) session.load(Host.class, id);
		if (phost != null) {
			if ((phost.getUsedCPU() - cpu) < 0) {
				return null;
			}
			phost.setUsedCPU(phost.getUsedCPU() - cpu);
			session.flush();
			return phost;
		} else
			return phost;
	}

	@Override
	public int getHostCount(String state) {
		
		// TODO Auto-generated method stub
		int count = 0;
		if(state == null) {
			count = ((Long) getSession().createQuery(
				"select count(*) from Host").uniqueResult()).intValue();
		}
		else {
			String query = "select count(*) from Host where state = :hostState";
			count = ((Long) getSession().createQuery(query)
					.setString("hostState", state).uniqueResult()).intValue();
		}
		
		return count;
	}

	@Override
	public List<Host> queryHosts(String orderBy, String order, int startIndex, int maxResults) {
		// TODO Auto-generated method stub
		if (startIndex < 0) {
			return null;
		}
		
		Session session = getSession();
		Query q;
		if(orderBy == null || order == null) {
			q = session.createQuery("from Host order by id");
		}
		else {
			q = session.createQuery("from Host order by " + orderBy + " " + order);	
		}
		
		q.setFirstResult(startIndex);
		q.setMaxResults(maxResults);

		List<Host> hosts = q.list();
		return hosts;
	}

}
