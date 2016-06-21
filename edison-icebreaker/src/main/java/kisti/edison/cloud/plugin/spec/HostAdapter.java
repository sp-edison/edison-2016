/**
 * 
 */
package kisti.edison.cloud.plugin.spec;

import kisti.edison.cloud.model.Host;

/**
 * @author root
 * 
 */
public interface HostAdapter {
	public Host allocateHost(Host host);

	public Host releaseHost(Host host);

	public Host getHostInformation(Host host);
}
