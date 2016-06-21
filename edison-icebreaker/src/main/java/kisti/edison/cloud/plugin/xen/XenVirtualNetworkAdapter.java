/**
 * 
 */
package kisti.edison.cloud.plugin.xen;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.opennebula.client.Client;
import org.opennebula.client.OneResponse;
import org.springframework.stereotype.Component;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.VirtualNetwork;
import kisti.edison.cloud.plugin.spec.VirtualNetworkAdapter;

/**
 * @author root
 * 
 */
@Component("xenVirtualNetworkAdapter")
public class XenVirtualNetworkAdapter extends XenAdapter implements
		VirtualNetworkAdapter {
	private int count;

	public XenVirtualNetworkAdapter() {
		this.count = 0;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public List<VirtualNetwork> retrieveVirtualNetworks(String uuid) {
		// LOG.info("XenVirtualNetworkAdapter::retrieveVirtualNetworks() called");
		List<VirtualNetwork> vns = new LinkedList<VirtualNetwork>();

		if (uuid == null || uuid.isEmpty())
			return null;

		try {
			Client oneClient = getClient();
			org.opennebula.client.vnet.VirtualNetwork vn = new org.opennebula.client.vnet.VirtualNetwork(
					Integer.parseInt(uuid), oneClient);

			OneResponse rc = vn.info();
			if (rc.isError()) {
				LOG.info("retrieveVirtualNetworks() failed");
				throw new Exception(rc.getErrorMessage());
			}

			String name = vn.xpath("NAME");
			String type = vn.xpath("TYPE");
			String bridge = vn.xpath("BRIDGE");
			for (int i = 1;; i++) {
				String ip = "";
				String mac = "";
				String vmName = "";
				if(Cloud.getInstance().getProp("build.target").equals("KISTI-NANO") ||
						Cloud.getInstance().getProp("build.target").equals("KISTI-NANO-EN")) {
					vmName = "n" + i;
				}
				else if(Cloud.getInstance().getProp("build.target").equals("KISTI-CHEM") ||
						Cloud.getInstance().getProp("build.target").equals("KISTI-CHEM-EN")) {
					vmName = "c" + i;
				}
				else {
					vmName = "vm" + i;
				}

				boolean remoteUsed = false;
				String exprIP = "LEASES/LEASE[" + i + "]/IP";
				String exprMAC = "LEASES/LEASE[" + i + "]/MAC";
				String exprUsed = "LEASES/LEASE[" + i + "]/USED";

				if (!vn.xpath(exprIP).isEmpty()) {
					ip = vn.xpath(exprIP);
					mac = vn.xpath(exprMAC);
					if (vn.xpath(exprUsed).equals("1")) {
						remoteUsed = true;
					}
				} else {
					break;
				}
				vns.add(new VirtualNetwork(uuid, name, type, bridge, ip, mac,
						false, remoteUsed, vmName));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return vns;
	}

}
