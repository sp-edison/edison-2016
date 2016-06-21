/**
 * 
 */
package kisti.edison.cloud.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author jlyu
 *
 */
@XmlRootElement(name = "file_entries")
public class FileEntryList  {
	private int count;
	
	private List<FileEntry> fileEntries;
	
	public FileEntryList() {
		
	}
	
	public FileEntryList(List<FileEntry> fileEntries) {
		this.setFileEntries(fileEntries);
		this.setCount(fileEntries.size());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElement(name = "file_entry")
	public List<FileEntry> getFileEntries() {
		return fileEntries;
	}

	public void setFileEntries(List<FileEntry> fileEntries) {
		this.fileEntries = fileEntries;
	}
}
