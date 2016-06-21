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
@Table(name = "VIRTUALNETWORK")
@XmlType(propOrder = { "id", "uuid", "name", "type", "bridge", "ip", "mac",
		"localUsed", "remoteUsed", "vmName" })
@XmlRootElement(name = "nic")
public class VirtualNetwork implements Serializable {
	private static final long serialVersionUID = 5379465880295410961L;

	@Id
	@GeneratedValue
	@Column(name = "VN_ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "VN_UUID", nullable = false)
	private String uuid;

	@Column(name = "VN_NAME")
	private String name;

	@Column(name = "VN_TYPE")
	private String type;

	@Column(name = "VN_BRIDGE")
	private String bridge;

	@Column(name = "VN_IP")
	private String ip;

	@Column(name = "VN_MAC")
	private String mac;

	@Column(name = "VN_LOCALUSED")
	private boolean localUsed;

	@Column(name = "VN_REMOTEUSED")
	private boolean remoteUsed;

	@Column(name = "VM_NAME")
	private String vmName;

	@Version
	@Column(name = "version")
	private int version = 0;

	public VirtualNetwork() {
	}

	public VirtualNetwork(String uuid) {
		this.uuid = uuid;
	}

	public VirtualNetwork(String uuid, String name, String type, String bridge,
			String ip, String mac, boolean localUsed, boolean remoteUsed,
			String vmName) {
		this.uuid = uuid;
		this.name = name;
		this.type = type;
		this.bridge = bridge;
		this.ip = ip;
		this.mac = mac;
		this.localUsed = localUsed;
		this.remoteUsed = remoteUsed;
		this.vmName = vmName;
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
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return this.name;
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

	public String getBridge() {
		return bridge;
	}

	public void setBridge(String bridge) {
		this.bridge = bridge;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return this.mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	@XmlAttribute
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isLocalUsed() {
		return localUsed;
	}

	public void setLocalUsed(boolean localUsed) {
		this.localUsed = localUsed;
	}

	public boolean isRemoteUsed() {
		return remoteUsed;
	}

	public void setRemoteUsed(boolean remoteUsed) {
		this.remoteUsed = remoteUsed;
	}

	public String getVmName() {
		return vmName;
	}

	public void setVmName(String vmName) {
		this.vmName = vmName;
	}

	@Override
	public String toString() {
		return "VirtualNetwork [id=" + id + ", uuid=" + uuid + ", name=" + name
				+ ", type=" + type + ", bridge=" + bridge + ", ip=" + ip
				+ ", mac=" + mac + ", localUsed=" + localUsed + ", remoteUsed="
				+ remoteUsed + ", vmName=" + vmName + ", version=" + version
				+ "]";
	}

}
