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
@XmlRootElement(name = "files")
public class PortInfoList {
	private int count;

	private List<PortInfo> files;

	public PortInfoList() {
	}

	public PortInfoList(List<PortInfo> files) {
		this.setFiles(files);
		this.setCount(files.size());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElement(name = "file")
	public List<PortInfo> getFiles() {
		return files;
	}

	public void setFiles(List<PortInfo> files) {
		this.files = files;
	}

}
