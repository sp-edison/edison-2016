/**
 * 
 */
package kisti.edison.cloud.plugin.xen;

import org.opennebula.client.Client;
import org.opennebula.client.OneResponse;
import org.springframework.stereotype.Component;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Host;
//import kisti.edison.cloud.model.HostState;
import kisti.edison.cloud.plugin.spec.HostAdapter;

/**
 * @author root
 * 
 */
@Component("xenHostAdapter")
public class XenHostAdapter extends XenAdapter implements HostAdapter {
	private boolean validate(Host host) {
		if (host.getHypervisor() != Host.HostType.XEN
				|| host.getName().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	private Host.HostState translateState(String oneState) {
		if (oneState.equals("2")) {
			return Host.HostState.READY;
		} else if (oneState.equals("3")) {
			return Host.HostState.ERROR;
		} else if (oneState.equals("4")) {
			return Host.HostState.DISABLED;
		} else if (oneState.equals("1")) {
			return Host.HostState.PENDING;
		} else {
			return Host.HostState.UNKNOWN;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * kisti.edison.cloud.plugin.host.HostAdapter#getHostInformation(kisti.edison
	 * .cloud.model.Host)
	 */

	@Override
	public Host allocateHost(Host host) {
		LOG.info("XenHostAdapter::allocateHost() called : " + host.getName());
		if (!validate(host))
			return null;

		try {
			Client oneClient = getClient();
			OneResponse rc = org.opennebula.client.host.Host.allocate(
					oneClient, host.getName(),
					Cloud.getInstance().getProp("xen.adapter.im"), Cloud
							.getInstance().getProp("xen.adapter.vmm"), Cloud
							.getInstance().getProp("xen.adapter.vnm"), Cloud
							.getInstance().getProp("xen.adapter.tm"));
			if (rc.isError()) {
				LOG.info("addHost() failed : " + rc.getErrorMessage());
				throw new Exception(rc.getErrorMessage());
			}
			LOG.info("allocateHost() success. (host_id : " + rc.getMessage()
					+ ")");
			host.setUuid(rc.getMessage());
			host.setState(Host.HostState.PENDING);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return host;
	}

	@Override
	public Host releaseHost(Host host) {
		// TODO Auto-generated method stub
		LOG.info("XenHostAdapter::releaseHost() called");
		if (!validate(host) || host.getUuid().isEmpty())
			return null;

		try {
			Client oneClient = getClient();
			String hostID = host.getUuid();

			OneResponse rc = org.opennebula.client.host.Host.delete(oneClient,
					Integer.parseInt(hostID));
			if (rc.isError()) {
				LOG.info("releaseHost() failed");
				throw new Exception(rc.getErrorMessage());
			}
			host.setState(Host.HostState.REMOVED);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return host;
	}

	@Override
	public Host getHostInformation(Host host) {
		// TODO Auto-generated method stub
		// LOG.info("XenHostAdapter::getHostInformation() called");

		org.opennebula.client.host.Host retrievedHost = null;

		if (!validate(host) || host.getUuid().isEmpty())
			return null;
		try {
			Client oneClient = getClient();
			String hostID = host.getUuid();

			retrievedHost = new org.opennebula.client.host.Host(
					Integer.parseInt(hostID), oneClient);
			retrievedHost.info();
			// LOG.info("STATE: " + retrievedHost.stateStr());
			String hostId = retrievedHost.xpath("ID");
			String name = retrievedHost.xpath("NAME");
			String architecture = retrievedHost.xpath("TEMPLATE/ARCH");
			String model = retrievedHost.xpath("TEMPLATE/MODELNAME");
			String cpuSpeed = retrievedHost.xpath("TEMPLATE/CPUSPEED");
			String totalCpu = retrievedHost.xpath("HOST_SHARE/MAX_CPU");
			String usedCpu = retrievedHost.xpath("HOST_SHARE/CPU_USAGE");
			String totalMem = retrievedHost.xpath("HOST_SHARE/MAX_MEM");
			String usedMem = retrievedHost.xpath("HOST_SHARE/USED_MEM");
			String connectUrl = Cloud.getInstance().getProp(
					"xen.adapter.xmlrpc");
			String runningVMs = retrievedHost.xpath("HOST_SHARE/RUNNING_VMS");
			Host.HostState state = translateState(retrievedHost.xpath("STATE"));

			host.setArchitecture(architecture);
			host.setConnectUrl(connectUrl);
			host.setUuid(hostId);
			host.setName(name);
			host.setRunningVMs(Long.parseLong(runningVMs));
			host.setState(state);
			host.setTotalCPU(Long.parseLong(totalCpu));
			host.setUsedCPU(Long.parseLong(usedCpu));
			host.setTotalMemory(Long.parseLong(totalMem));
			host.setUsedMemory(Long.parseLong(usedMem));
			host.setModel(model);
			if (!cpuSpeed.isEmpty())
				host.setCpuSpeed(Long.parseLong(cpuSpeed));
			else
				host.setCpuSpeed(0L);

			// LOG.info(host.toString());

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return host;
	}

}
