/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import kisti.edison.cloud.model.Host;

/**
 * @author root
 * 
 */
public interface HostDAO {

	public int getHostCount(String state);

	public Host getHost(Long id);

	public List<Host> getAllHosts(String orderBy, String order);

	public List<Host> queryHosts(String orderBy, String order, int startIndex, int maxResults);

	public Host createHost(Host host);

	public Host findHost(String name);

	public Host deleteHost(Long id);

	public Host updateHost(Host host);

	public Host acquireHost(Long id, Long cpu);

	public Host releaseHost(Long id, Long cpu);
}
