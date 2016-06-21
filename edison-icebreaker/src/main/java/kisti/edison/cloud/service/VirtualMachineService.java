/**
 * 
 */
package kisti.edison.cloud.service;

import java.util.List;

import kisti.edison.cloud.model.VirtualMachine;

/**
 * @author root
 * 
 */
public interface VirtualMachineService {

	public int getVirtualMachinesCount(String userId, boolean allVMs, String state);

	public VirtualMachine getVirtualMachine(Long id);

	public List<VirtualMachine> getVirtualMachines(String orderBy, String order);

	public List<VirtualMachine> getVirtualMachines(String userId, String orderBy, String order);

	public List<VirtualMachine> queryVirtualMachines(String orderBy, String order, int startIndex, int maxResults);

	public List<VirtualMachine> queryVirtualMachines(String userId, String orderBy, String order, int startIndex, int maxResults);

	public VirtualMachine createVirtualMachine(VirtualMachine vm);

	public VirtualMachine shutdownVirtualMachine(Long id);

	public VirtualMachine changeVirtualMachineState(Long id, VirtualMachine.VirtualMachineState state);

}
