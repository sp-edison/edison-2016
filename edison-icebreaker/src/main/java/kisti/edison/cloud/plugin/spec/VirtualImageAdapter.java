/**
 * 
 */
package kisti.edison.cloud.plugin.spec;

import java.util.List;

import kisti.edison.cloud.model.VirtualImage;

/**
 * @author root
 * 
 */
public interface VirtualImageAdapter {

	public List<VirtualImage> retrieveVirtualImages();

	public VirtualImage retrieveVirtualImage(String uuid);

}
