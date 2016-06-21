/**
 * 
 */
package kisti.edison.cloud.plugin.spec;

import java.util.List;
import kisti.edison.cloud.model.VirtualNetwork;

/**
 * @author root
 * 
 */
public interface VirtualNetworkAdapter {
	/**
	 * Retrieve virtual network details for the given uuid.
	 * 
	 * @param uuid
	 * @return if successful, list of virtual networks (e.g., bridge name, ip
	 *         and mac pairs, etc.) or null
	 */
	public List<VirtualNetwork> retrieveVirtualNetworks(String uuid);

}
