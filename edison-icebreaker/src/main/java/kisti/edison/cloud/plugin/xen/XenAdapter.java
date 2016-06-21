/**
 * 
 */
package kisti.edison.cloud.plugin.xen;

import kisti.edison.cloud.env.Cloud;

import org.apache.log4j.Logger;
import org.opennebula.client.Client;

/**
 * @author root
 * 
 */
public class XenAdapter {
	protected final Logger LOG = Logger.getLogger(this.getClass());

	protected Client getClient() throws Exception {
		return new Client(Cloud.getInstance().getProp("xen.adapter.auth"),
				Cloud.getInstance().getProp("xen.adapter.xmlrpc"));

	}
}
