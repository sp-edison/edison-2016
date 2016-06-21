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
@XmlRootElement(name = "vms")
public class VirtualMachineList {
	private int count;
	private List<VirtualMachine> vms;

	public VirtualMachineList() {
	}

	public VirtualMachineList(List<VirtualMachine> vms) {
		this.setVms(vms);
		this.setCount(vms.size());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElement(name = "vm")
	public List<VirtualMachine> getVms() {
		return vms;
	}

	public void setVms(List<VirtualMachine> vms) {
		this.vms = vms;
	}
}
