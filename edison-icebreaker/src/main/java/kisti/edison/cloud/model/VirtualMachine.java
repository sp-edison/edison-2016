/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author root
 * 
 */
@Entity
@Table(name = "VIRTUALMACHINE")
@XmlType(propOrder = { "id", "uuid", "name", "state", "userId", "cpu",
		"memory", "nettx", "netrx", "hostId", "hostName", "hostUuid", "reqCpu",
		"reqMem", "reqVcpus", "reqState", "lcmState", "disks", "nics", "vncUrl" })
@XmlRootElement(name = "vm")
public class VirtualMachine implements Serializable {
	private static final long serialVersionUID = -4320464833708603201L;

	public static enum VirtualMachineState {
		UNKNOWN, PENDING, STARTING, RUNNING, SUSPENDED, MIGRATING, HALTING, STOPPED, SUSPEND_REQ, RESUME_REQ, SHUTDOWN_REQ, ERROR
	}

	@Id
	@GeneratedValue
	@Column(name = "VM_ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "VM_UUID")
	private String uuid;

	@Column(name = "VM_NAME")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "VM_STATE", nullable = false)
	private VirtualMachineState state;

	@Column(name = "VM_LCMSTATE")
	private String lcmState;

	@Column(name = "VM_CPU")
	private Long cpu;

	@Column(name = "VM_MEMORY")
	private Long memory;

	@Column(name = "VM_NETTX")
	private Long nettx;

	@Column(name = "VM_NETRX")
	private Long netrx;

	@Column(name = "VM_VNCURL")
	private String vncUrl;

	@Column(name = "VM_HOSTID")
	private Long hostId;

	@Column(name = "VM_HOSTNAME")
	private String hostName;

	@Column(name = "VM_HOSTUUID")
	private String hostUuid;

	@Column(name = "VM_USERID", nullable = false)
	private String userId;

	@Column(name = "VM_REQCPU")
	private Long reqCpu;

	@Column(name = "VM_REQMEM")
	private Long reqMem;

	@Column(name = "VM_REQVCPUS")
	private Long reqVcpus;

	@Enumerated(EnumType.STRING)
	@Column(name = "VM_REQSTATE")
	private VirtualMachineState reqState;

	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "VIRTUALMACHINE_VIRTUALIMAGE", joinColumns = {
	 * @JoinColumn(name = "VM_ID") }, inverseJoinColumns = { @JoinColumn(name =
	 * "VI_ID") }) private Set<VirtualImage> disks = new
	 * HashSet<VirtualImage>();
	 * 
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "VIRTUALMACHINE_VIRTUALNETWORK", joinColumns = {
	 * @JoinColumn(name = "VM_ID") }, inverseJoinColumns = { @JoinColumn(name =
	 * "VN_ID") }) private Set<VirtualNetwork> nics = new
	 * HashSet<VirtualNetwork>();
	 */

	@ManyToMany
	@JoinTable(name = "VIRTUALMACHINE_VIRTUALIMAGE")
	private Set<VirtualImage> disks = new HashSet<VirtualImage>();

	@ManyToMany
	@JoinTable(name = "VIRTUALMACHINE_VIRTUALNETWORK")
	private Set<VirtualNetwork> nics = new HashSet<VirtualNetwork>();

	@Version
	@Column(name = "version")
	private int version = 0;

	public VirtualMachine() {
	}

	public VirtualMachine(String userId) {
		this.userId = userId;
	}

	public VirtualMachine(String uuid, String name, Long hostId, String userId,
			Set<VirtualImage> disks, Set<VirtualNetwork> nics) {
		this.uuid = uuid;
		this.name = name;
		this.setHostId(hostId);
		this.setUserId(userId);
		this.disks = disks;
		this.nics = nics;
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
		return this.uuid;
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

	@XmlElement(name = "disks")
	public Set<VirtualImage> getDisks() {
		return disks;
	}

	public void setDisks(Set<VirtualImage> disks) {
		this.disks = disks;
	}

	@XmlElement(name = "nics")
	public Set<VirtualNetwork> getNics() {
		return nics;
	}

	public void setNics(Set<VirtualNetwork> nics) {
		this.nics = nics;
	}

	@XmlAttribute
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Long getCpu() {
		return cpu;
	}

	public void setCpu(Long cpu) {
		this.cpu = cpu;
	}

	public Long getMemory() {
		return memory;
	}

	public void setMemory(Long memory) {
		this.memory = memory;
	}

	public Long getNettx() {
		return nettx;
	}

	public void setNettx(Long nettx) {
		this.nettx = nettx;
	}

	public Long getNetrx() {
		return netrx;
	}

	public void setNetrx(Long netrx) {
		this.netrx = netrx;
	}

	public Long getHostId() {
		return hostId;
	}

	public void setHostId(Long hostId) {
		this.hostId = hostId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVncUrl() {
		return vncUrl;
	}

	public void setVncUrl(String vncUrl) {
		this.vncUrl = vncUrl;
	}

	public String getLcmState() {
		return lcmState;
	}

	public void setLcmState(String lcmState) {
		this.lcmState = lcmState;
	}

	public VirtualMachineState getState() {
		return state;
	}

	public void setState(VirtualMachineState state) {
		this.state = state;
	}

	public String getHostUuid() {
		return hostUuid;
	}

	public void setHostUuid(String hostUuid) {
		this.hostUuid = hostUuid;
	}

	public Long getReqCpu() {
		return reqCpu;
	}

	public void setReqCpu(Long reqCpu) {
		this.reqCpu = reqCpu;
	}

	public Long getReqMem() {
		return reqMem;
	}

	public void setReqMem(Long reqMem) {
		this.reqMem = reqMem;
	}

	public VirtualMachineState getReqState() {
		return reqState;
	}

	public void setReqState(VirtualMachineState reqState) {
		this.reqState = reqState;
	}

	public Long getReqVcpus() {
		return reqVcpus;
	}

	public void setReqVcpus(Long reqVcpus) {
		this.reqVcpus = reqVcpus;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	@Override
	public String toString() {
		return "VirtualMachine [id=" + id + ", uuid=" + uuid + ", name=" + name
				+ ", state=" + state + ", lcmState=" + lcmState + ", cpu="
				+ cpu + ", memory=" + memory + ", nettx=" + nettx + ", netrx="
				+ netrx + ", vncUrl=" + vncUrl + ", hostId=" + hostId
				+ ", hostName=" + hostName + ", hostUuid=" + hostUuid
				+ ", userId=" + userId + ", reqCpu=" + reqCpu + ", reqMem="
				+ reqMem + ", reqVcpus=" + reqVcpus + ", reqState=" + reqState
				+ ", disks=" + disks + ", nics=" + nics + ", version="
				+ version + "]";
	}

}
