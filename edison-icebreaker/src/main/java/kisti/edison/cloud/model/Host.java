/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "HOSTS")
@XmlType(propOrder = { "id", "uuid", "name", "hypervisor", "state",
		"architecture", "model", "cpuSpeed", "totalCPU", "usedCPU",
		"totalMemory", "usedMemory", "runningVMs", "connectUrl" })
@XmlRootElement(name = "host")
public class Host implements Serializable {
	private static final long serialVersionUID = -1495650328581359330L;

	public static enum HostState {
		UNKNOWN, PENDING, READY, DISABLED, REMOVED, ERROR
	}

	public static enum HostType {
		XEN, KVM, VMWARE
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Long id = null;

	@Column(name = "uuid")
	private String uuid;

	@Column(name = "name", nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private HostType hypervisor;

	@Column(name = "architecture")
	private String architecture;

	@Column(name = "model")
	private String model;

	@Column(name = "cpuSpeed")
	private Long cpuSpeed;

	@Enumerated(EnumType.STRING)
	@Column(name = "state", nullable = false)
	private HostState state;

	@Column(name = "connectUrl")
	private String connectUrl;

	@Column(name = "totalCPU")
	private Long totalCPU;

	@Column(name = "usedCPU")
	private Long usedCPU;

	@Column(name = "totalMemory")
	private Long totalMemory;

	@Column(name = "usedMemory")
	private Long usedMemory;

	@Column(name = "runningVMs")
	private Long runningVMs;

	@Version
	@Column(name = "version")
	private int version = 0;

	public Host() {
	}

	public Host(String name, HostType hypervisor, String connectUrl) {
		this.name = name;
		this.hypervisor = hypervisor;
		this.connectUrl = connectUrl;
	}

	// @XmlAttribute
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

	public HostType getHypervisor() {
		return hypervisor;
	}

	public void setHypervisor(HostType hypervisor) {
		this.hypervisor = hypervisor;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	public HostState getState() {
		return state;
	}

	public void setState(HostState state) {
		this.state = state;
	}

	public String getConnectUrl() {
		return connectUrl;
	}

	public void setConnectUrl(String connectUrl) {
		this.connectUrl = connectUrl;
	}

	public Long getTotalCPU() {
		return totalCPU;
	}

	public void setTotalCPU(Long totalCPU) {
		this.totalCPU = totalCPU;
	}

	public Long getUsedCPU() {
		return usedCPU;
	}

	public void setUsedCPU(Long usedCPU) {
		this.usedCPU = usedCPU;
	}

	public Long getUsedMemory() {
		return usedMemory;
	}

	public void setUsedMemory(Long usedMemory) {
		this.usedMemory = usedMemory;
	}

	public Long getTotalMemory() {
		return totalMemory;
	}

	public void setTotalMemory(Long totalMemory) {
		this.totalMemory = totalMemory;
	}

	public Long getRunningVMs() {
		return runningVMs;
	}

	public void setRunningVMs(Long runningVMs) {
		this.runningVMs = runningVMs;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Long getCpuSpeed() {
		return cpuSpeed;
	}

	public void setCpuSpeed(Long cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
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
		String ret = "";
		ret += "\n";
		ret += "ID 	   : " + getId() + "\n";
		ret += "NAME   : " + getName() + "\n";
		ret += "TYPE   : " + getHypervisor().toString() + "\n";
		ret += "CONNECT_URL : " + getConnectUrl() + "\n";
		ret += "STATE  : " + getState().toString() + "\n";
		ret += "UUID   : " + getUuid() + "\n";
		ret += "ARCH   : " + getArchitecture() + "\n";
		ret += "MODEL  : " + getModel() + "\n";
		ret += "CPUSPEED   : " + getCpuSpeed() + "\n";
		ret += "TOTALCPU   : " + getTotalCPU() + "\n";
		ret += "USEDCPU    : " + getUsedCPU() + "\n";
		ret += "TOTALMEM   : " + getTotalMemory() + "\n";
		ret += "USEDMEM    : " + getUsedMemory() + "\n";
		ret += "RUNNING_VMS  : " + getRunningVMs() + "\n";
		ret += "VERSION: " + getVersion() + "\n";

		return ret;
	}

}
