/**
 * 
 */
package kisti.edison.cloud.plugin.xen;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.opennebula.client.Client;
import org.opennebula.client.OneResponse;
import org.opennebula.client.image.Image;
import org.opennebula.client.image.ImagePool;
import org.springframework.stereotype.Component;

import kisti.edison.cloud.model.VirtualImage;
import kisti.edison.cloud.plugin.spec.VirtualImageAdapter;

/**
 * @author root
 * 
 */
@Component("xenVirtualImageAdapter")
public class XenVirtualImageAdapter extends XenAdapter implements
		VirtualImageAdapter {

	@Override
	public List<VirtualImage> retrieveVirtualImages() {
		// LOG.info("XenVirtualImageAdapter::retrieveVirtualImages() called");
		List<VirtualImage> images = new LinkedList<VirtualImage>();

		try {
			Client oneClient = getClient();
			ImagePool imagePool = new ImagePool(oneClient);
			OneResponse rc = imagePool.infoAll();
			if (rc.isError()) {
				LOG.info("retrieveVirtualImages() failed");
				throw new Exception(rc.getErrorMessage());
			}

			Iterator<Image> it = imagePool.iterator();
			while (it.hasNext()) {
				Image image = it.next();
				// LOG.info("Image UUID : " + image.getId());
				// LOG.info("Image NAME : " + image.xpath("NAME"));
				// LOG.info("Image STATE : " + image.stateString());
				// LOG.info("Image TYPE : " + image.typeStr());
				// LOG.info("Image SOURCE : " + image.xpath("SOURCE"));
				// LOG.info("Image SIZE : " + image.xpath("SIZE"));

				VirtualImage vi = new VirtualImage(image.getId(),
						image.xpath("NAME"), image.typeStr(),
						image.stateString(), image.xpath("SOURCE"),
						Long.parseLong(image.xpath("SIZE")));
				images.add(vi);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return images;
	}

	@Override
	public VirtualImage retrieveVirtualImage(String uuid) {
		// LOG.info("XenVirtualImageAdapter::retrieveVirtualImage() called");
		VirtualImage retrievedImage = null;
		if (uuid == null || uuid.isEmpty()) {
			return null;
		}

		try {
			Client oneClient = getClient();

			Image image = new Image(Integer.parseInt(uuid), oneClient);
			OneResponse rc = image.info();
			if (rc.isError()) {
				LOG.info("retrieveVirtualImage() failed");
				throw new Exception(rc.getErrorMessage());
			}
			retrievedImage = new VirtualImage(image.getId(),
					image.xpath("NAME"), image.typeStr(), image.stateString(),
					image.xpath("SOURCE"), Long.parseLong(image.xpath("SIZE")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return retrievedImage;
	}

}
