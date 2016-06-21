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
public class FileItemList {
	private int count;

	private List<FileItem> files;

	public FileItemList() {
	}

	public FileItemList(List<FileItem> files) {
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
	public List<FileItem> getFiles() {
		return files;
	}

	public void setFiles(List<FileItem> files) {
		this.files = files;
	}

}
