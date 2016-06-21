/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import kisti.edison.cloud.model.VirtualNetwork;

/**
 * @author root
 * 
 */
public interface VirtualNetworkDAO {

	public List<VirtualNetwork> getVirtualNetworks();
	
	public VirtualNetwork findVirtualNetworkByIP(String ip);

	public VirtualNetwork createVirtualNetwork(VirtualNetwork virtualNetwork);

	public VirtualNetwork updateVirtualNetwork(VirtualNetwork virtualNetwork);
	
	public void deleteVirtualNetwork(Long id);

	public VirtualNetwork acquireIdleVirtualNetwork();

	public VirtualNetwork releaseVirtualNetwork(Long id);
}
