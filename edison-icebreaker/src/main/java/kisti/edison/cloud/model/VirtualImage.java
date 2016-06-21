/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author root
 * 
 */
@Entity
@Table(name = "VIRTUALIMAGE")
@XmlType(propOrder = { "id", "uuid", "name", "type", "state", "source", "size",
		"localUsed" })
@XmlRootElement(name = "disk")
public class VirtualImage implements Serializable {
	private static final long serialVersionUID = 9198029598309824925L;

	@Id
	@GeneratedValue
	@Column(name = "VI_ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "VI_UUID", nullable = false)
	private String uuid;

	@Column(name = "VI_NAME")
	private String name;

	@Column(name = "VI_TYPE")
	private String type;

	@Column(name = "VI_STATE")
	private String state;

	@Column(name = "VI_SOURCE")
	private String source;

	@Column(name = "VI_SIZE")
	private Long size;

	@Column(name = "VI_LOCALUSED")
	private boolean localUsed;

	@Version
	@Column(name = "VERSION")
	private int version = 0;

	public VirtualImage() {
	}

	public VirtualImage(String uuid, String name, String type, String state,
			String source, Long size) {
		this.uuid = uuid;
		this.name = name;
		this.type = type;
		this.state = state;
		this.source = source;
		this.size = size;
	}

	@XmlAttribute
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlAttribute
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public boolean isLocalUsed() {
		return localUsed;
	}

	public void setLocalUsed(boolean localUsed) {
		this.localUsed = localUsed;
	}

	@XmlAttribute
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "VirtualImage [id=" + id + ", uuid=" + uuid + ", name=" + name
				+ ", type=" + type + ", state=" + state + ", source=" + source
				+ ", size=" + size + ", localUsed=" + localUsed + ", version="
				+ version + "]";
	}
}
