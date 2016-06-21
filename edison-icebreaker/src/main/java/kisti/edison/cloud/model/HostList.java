/**
 * 
 */
package kisti.edison.cloud.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author root
 * 
 */
@XmlRootElement(name = "hosts")
public class HostList {
	private int count;
	private List<Host> hosts;

	public HostList() {
	}

	public HostList(List<Host> hosts) {
		this.setHosts(hosts);
		this.setCount(hosts.size());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElement(name = "host")
	public List<Host> getHosts() {
		return hosts;
	}

	public void setHosts(List<Host> hosts) {
		this.hosts = hosts;
	}
}
