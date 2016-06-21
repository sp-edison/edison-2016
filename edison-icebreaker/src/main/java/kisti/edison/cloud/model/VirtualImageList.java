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
@XmlRootElement(name = "disks")
public class VirtualImageList {
	private int count;
	private List<VirtualImage> images;

	public VirtualImageList() {
	}

	public VirtualImageList(List<VirtualImage> images) {
		this.setImages(images);
		this.setCount(images.size());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElement(name = "disk")
	public List<VirtualImage> getImages() {
		return images;
	}

	public void setImages(List<VirtualImage> images) {
		this.images = images;
	}
}
