/**
 * 
 */
package kisti.edison.cloud.service;

import java.util.List;

import kisti.edison.cloud.model.Host;

/**
 * @author root
 * 
 */
public interface HostService {

	public int getHostCount(String state);

	public Host getHost(Long id);

	public List<Host> getHosts(String orderBy, String order);

	public List<Host> queryHosts(String orderBy, String order, int startIndex, int maxResults);

	public Host createHost(Host host);

	public void deleteHost(Long id);

	public Host updateHost(Host host);

	public boolean isAlreadyExist(String name);
}
