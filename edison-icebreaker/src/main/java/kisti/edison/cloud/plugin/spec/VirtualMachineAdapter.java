/**
 * 
 */
package kisti.edison.cloud.plugin.spec;

import kisti.edison.cloud.model.Host;
import kisti.edison.cloud.model.VirtualMachine;

/**
 * @author root
 * 
 */
public interface VirtualMachineAdapter {

	public VirtualMachine allocateVirtualMachine(Host host, VirtualMachine vm);

	public VirtualMachine shutdownVirtualMachine(VirtualMachine vm);

	public VirtualMachine retrieveVirtualMachineInfo(VirtualMachine vm);

	public VirtualMachine suspendVirtualMachine(VirtualMachine vm);

	public VirtualMachine resumeVirtualMachine(VirtualMachine vm);

	public VirtualMachine migrateVirtualMacine(Host destHost, VirtualMachine vm);

}
