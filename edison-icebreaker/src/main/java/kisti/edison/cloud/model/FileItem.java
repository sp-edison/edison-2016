/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author root
 * 
 */
@XmlType(propOrder = { "id", "name", "type", "size", "description", "path", "lastModified", "parentPath" })
@XmlRootElement(name = "file")
public class FileItem implements Serializable {
	private static final long serialVersionUID = -7554401562930725502L;

	private String id;

	private String name;

	private String type;

	private Long size;

	private String description;

	private String path;
	
	private String lastModified;
	
	private String parentPath;

	public FileItem() {
	}

	public FileItem(String id, String name, String type, Long size,
			String description, String path, String lastModified, String parentPath) {
		this.setId(id);
		this.setName(name);
		this.setType(type);
		this.setSize(size);
		this.setDescription(description);
		this.setPath(path);
		this.setLastModified(lastModified);
		this.setParentPath(parentPath);
	}

	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * @return the lastModified
	 */
	public String getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	
	public String getParentPath(){
		return parentPath;	
	}
	
	public void setParentPath(String parentPath){
		this.parentPath = parentPath;
	}


	@Override
	public String toString() {
		return "FileItem [id=" + id + ", name=" + name + ", type=" + type
				+ ", size=" + size + ", description=" + description + ", path="
				+ path + ", lastModified =" + lastModified + ", parentPath =" + parentPath + "]";
		
	}

}
