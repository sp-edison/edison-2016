/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author jlyu
 *
 */
@Entity
@Table(name = "FILES")
@XmlRootElement(name = "file_entry")
public class FileEntry implements Serializable {
	private static final long serialVersionUID = -3272878982874541921L;

	@Id
	@GeneratedValue(generator = "system-uuid2")
	@GenericGenerator(name = "system-uuid2", strategy = "uuid2")
	@Column(name = "uuid", updatable = false, nullable = false)
	private String uuid;
	
	@Column(name = "owner")
	private String owner;
		
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "isDirectory")
	private boolean isDirectory;
	
	@Column(name = "mimeType")
	private String mimeType;
	
	@Column(name = "size")
	private Long size;
	
	@Column(name = "path")
	private String path;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastModified")
	private Date lastModified;
	
	@Version
	@Column(name = "version")
	private int version = 0;
	
	public FileEntry() {}
	
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the ownedBy
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param ownedBy the ownedBy to set
	 */
	public void setOwner(String ownedBy) {
		this.owner = ownedBy;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the isDirectory
	 */
	public boolean isDirectory() {
		return isDirectory;
	}

	/**
	 * @param isDirectory the isDirectory to set
	 */
	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}

	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * @param mimeType the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Long size) {
		this.size = size;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	
	
}
