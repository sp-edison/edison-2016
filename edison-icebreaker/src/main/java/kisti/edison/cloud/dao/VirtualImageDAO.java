/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import kisti.edison.cloud.model.VirtualImage;

/**
 * @author root
 * 
 */
public interface VirtualImageDAO {

	public List<VirtualImage> getVirtualImages();

	public VirtualImage findVirtualImageByUUID(String uuid);

	public VirtualImage createVirtualImage(VirtualImage image);

	public VirtualImage updateVirtualImage(VirtualImage image);

	public VirtualImage deleteVirtualImage(Long id);

	public VirtualImage acquireIdleVirtualImage();

	public VirtualImage releaseVirtualImage(Long id);
}
