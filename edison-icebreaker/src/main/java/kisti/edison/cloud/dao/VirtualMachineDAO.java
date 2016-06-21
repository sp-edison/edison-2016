/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import org.hibernate.Session;

import kisti.edison.cloud.model.VirtualMachine;

/**
 * @author root
 * 
 */
public interface VirtualMachineDAO {

	public int getVirtualMachinesCount(Session session, String userId,
			boolean allVMs, String state);

	public VirtualMachine getVirtualMachine(Session session, Long id);

	public List<VirtualMachine> getVirtualMachines(Session session, String orderBy, String order);

	public List<VirtualMachine> getVirtualMachines(Session session, String userId, String orderBy, String order);

	public List<VirtualMachine> queryVirtualMachines(Session session, String orderBy, String order, int startIndex, int maxResults);

	public List<VirtualMachine> queryVirtualMachines(Session session, String userId, String orderBy, String order, int startIndex, int maxResults);

	public VirtualMachine createVirtualMachine(Session session, VirtualMachine vm);

	public void deleteVirtualMachine(Session session, Long id);

	public VirtualMachine updateVirtualMachine(Session session, VirtualMachine vm);

	public VirtualMachine updateVirtualMachineState(Session session, VirtualMachine vm);

	public VirtualMachine changeVirtualMachineState(Session session, Long id, VirtualMachine.VirtualMachineState state);

}
