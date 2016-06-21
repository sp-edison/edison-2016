/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import kisti.edison.cloud.model.VirtualImage;
import kisti.edison.cloud.model.VirtualNetwork;

/**
 * @author root
 * 
 */
@Repository("virtualNetworkDAO")
@SuppressWarnings("unchecked")
public class VirtualNetworkDAOImpl extends HibernateDAO implements
		VirtualNetworkDAO {
	@Override
	public VirtualNetwork findVirtualNetworkByIP(String ip) {
		Assert.hasText(ip);
		Session session = getSession();
		String query = "from VirtualNetwork vn where vn.ip = :ip";
		VirtualNetwork vn = (VirtualNetwork) session.createQuery(query)
				.setString("ip", ip).uniqueResult();
		return vn;
	}

	@Override
	public VirtualNetwork createVirtualNetwork(VirtualNetwork virtualNetwork) {

		if (virtualNetwork.getUuid().isEmpty()
				|| virtualNetwork.getBridge().isEmpty()
				|| virtualNetwork.getIp().isEmpty()
				|| virtualNetwork.getMac().isEmpty()) {
			return null;
		}

		Session session = getSession();
		session.save(virtualNetwork);
		session.flush();

		return virtualNetwork;
	}

	@Override
	public VirtualNetwork updateVirtualNetwork(VirtualNetwork virtualNetwork) {
		Session session = getSession();

		VirtualNetwork loadedVN = (VirtualNetwork) session.load(
				VirtualNetwork.class, virtualNetwork.getId());
		loadedVN.setUuid(virtualNetwork.getUuid());
		loadedVN.setName(virtualNetwork.getName());
		loadedVN.setType(virtualNetwork.getType());
		loadedVN.setBridge(virtualNetwork.getBridge());
		loadedVN.setIp(virtualNetwork.getIp());
		loadedVN.setMac(virtualNetwork.getMac());
		loadedVN.setRemoteUsed(virtualNetwork.isRemoteUsed());
		session.flush();

		return loadedVN;
	}

	@Override
	public VirtualNetwork acquireIdleVirtualNetwork() {
		Session session = getSession();
		String query = "from VirtualNetwork nic where nic.localUsed = :localUsed";
		List<VirtualNetwork> nics = session.createQuery(query)
				.setBoolean("localUsed", false).list();

		if (nics.size() == 0) {
			return null;
		}

		VirtualNetwork loadedVN = (VirtualNetwork) session.load(
				VirtualNetwork.class, nics.get(0).getId());
		loadedVN.setLocalUsed(true);
		session.flush();

		return nics.get(0);
	}

	@Override
	public VirtualNetwork releaseVirtualNetwork(Long id) {
		Session session = getSession();

		VirtualNetwork loadedVN = (VirtualNetwork) session.load(
				VirtualNetwork.class, id);
		loadedVN.setLocalUsed(false);
		session.flush();

		return loadedVN;
	}

	@Override
	public void deleteVirtualNetwork(Long id) {
		Session session = getSession();
		VirtualNetwork nic = (VirtualNetwork) session.get(VirtualNetwork.class, id);
		if(nic != null) {
			session.delete(nic);
			session.flush();
		}
	}

	@Override
	public List<VirtualNetwork> getVirtualNetworks() {
		Session session = getSession();
		List<VirtualNetwork> nics = session.createQuery("from VirtualNetwork order by id").list();
		return nics;
	}

}
