/**
 * 
 */
package kisti.edison.cloud.model;

import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author root
 * 
 */
@XmlRootElement(name = "items")
public class FileDirList {
	private HashMap <String, FileItemList> fdlist;

	public FileDirList() {
	}
	
	public FileDirList( HashMap<String, FileItemList> fdlist ) {
		this.fdlist = fdlist;
	}

	@XmlElement(name = "list")
	public HashMap<String, FileItemList> getFiles() {
		return fdlist;
	}


}
