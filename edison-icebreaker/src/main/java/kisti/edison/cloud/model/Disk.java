package kisti.edison.cloud.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author majin
 * 
 */
//@XmlType(propOrder = { "id", "name", "type", "size", "description", "path" })
@XmlType(propOrder = {"size", "sizeGB"})

@XmlRootElement(name = "disk")
public class Disk implements Serializable {
	private static final long serialVersionUID = -7554401562930725502L;

//	private String id;
//
//	private String name;
//
//	private String type;

	private Long size;
	
	private String sizeGB;

//	private String description;
//
//	private String path;

	public Disk() {
	}

	public Disk(long size) {		
		this.setSizeGB(size);
		this.setSize(size);
	}

	@XmlAttribute
/*	public String getId() {
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
	}*/

	public Long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
	
	public String getSizeGB(long size)
	{
		return sizeGB = Long.toString(size);
	}
	
	public void setSizeGB(long size)
	{
		
		this.sizeGB = Long.toString(size);
	}

/*	public String getDescription() {
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
	}*/

	@Override
	public String toString() {
		return "Disk [sizeGB=" + sizeGB + ", size=" + size +"]";
	}
/*	public String toString() {
		return "Disk [id=" + id + ", name=" + name + ", type=" + type
				+ ", size=" + size + ", description=" + description + ", path="
				+ path + "]";
	}*/

}