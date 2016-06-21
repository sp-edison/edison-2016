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
@XmlRootElement(name = "nics")
public class VirtualNetworkList {
	private int count;
	private List<VirtualNetwork> nics;

	public VirtualNetworkList() {
	}

	public VirtualNetworkList(List<VirtualNetwork> nics) {
		this.setNics(nics);
		this.setCount(nics.size());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElement(name = "nic")
	public List<VirtualNetwork> getNics() {
		return nics;
	}

	public void setNics(List<VirtualNetwork> nics) {
		this.nics = nics;
	}
}
