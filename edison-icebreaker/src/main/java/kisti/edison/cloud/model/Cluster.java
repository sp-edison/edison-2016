/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import kisti.edison.cloud.util.JsonDateSerializer;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author jlyu
 *
 */
@Entity
@Table(name = "CLUSTERS")
@XmlRootElement(name = "cluster")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "name", "ip", "port", "jobManagerType", "jobManagerVersion",
		"queues", "baseDir", "zone", "enabled", "lastModified", "runtime", "version"})
public class Cluster implements Serializable {
	private static final long serialVersionUID = 3308510202966329916L;

	public static enum JobManagerType {
		TORQUE, LoadL, SGE, OpenPBS, Condor, UNKNOWN
	}
	
	@Entity
	@Table(name = "RUNTIMES")
	public static class Runtime implements Serializable{
		private static final long serialVersionUID = 3406537516888125176L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(updatable = false, nullable = false)
		private Long id;
		
		@Column(name = "totalCores")
		private Long totalCores;
		
		@Column(name = "busyCores")
		private Long busyCores;
		
		@Column(name = "downCores")
		private Long downCores;
		
		@Column(name = "freeCores")
		private Long freeCores;
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getTotalCores() {
			return totalCores;
		}

		public void setTotalCores(Long totalCores) {
			this.totalCores = totalCores;
		}

		public Long getBusyCores() {
			return busyCores;
		}

		public void setBusyCores(Long busyCores) {
			this.busyCores = busyCores;
		}

		public Long getDownCores() {
			return downCores;
		}

		public void setDownCores(Long downCores) {
			this.downCores = downCores;
		}

		public Long getFreeCores() {
			return freeCores;
		}

		public void setFreeCores(Long freeCores) {
			this.freeCores = freeCores;
		}

		@Override
		public String toString() {
			return "Runtime [id=" + id + ", totalCores=" + totalCores
					+ ", busyCores=" + busyCores + ", downCores=" + downCores
					+ ", freeCores=" + freeCores + "]";
		}
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Long id = null;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	
	@Column(name = "ip")
	private String ip;
	
	@Column(name = "port")
	private String port;


	@Enumerated(EnumType.STRING)
	@Column(name = "jobManagerType", nullable = false)
	private JobManagerType jobManagerType;
	
	@Column(name = "jobManagerVersion")
	private String jobManagerVersion;
	
	@Column(name = "queues")
	private String queues;
	
	@Version
	@Column(name = "version")
	private int version = 0;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@XmlElement(name = "runtime")
	public Cluster.Runtime runtime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastModified")
	private Date lastModified;
	
	@Column(name = "baseDir")
	private String baseDir;
	
	@Column(name = "zone")
	private String zone;

	@Column(name = "enabled")
	private boolean enabled;
	
	public Cluster() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JobManagerType getJobManagerType() {
		return jobManagerType;
	}

	public void setJobManagerType(JobManagerType jobManagerType) {
		this.jobManagerType = jobManagerType;
	}

	public String getJobManagerVersion() {
		return jobManagerVersion;
	}

	public void setJobManagerVersion(String jobManagerVersion) {
		this.jobManagerVersion = jobManagerVersion;
	}

	public String getQueues() {
		return queues;
	}

	public void setQueues(String queues) {
		this.queues = queues;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	public Cluster.Runtime getRuntime() {
		return runtime;
	}

	public void setRuntime(Cluster.Runtime runtime) {
		this.runtime = runtime;
	}
	
	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}
	
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Cluster [id=" + id + ", name=" + name + ", ip=" + ip
				+ ", port=" + port + ", jobManagerType=" + jobManagerType
				+ ", jobManagerVersion=" + jobManagerVersion + ", queues="
				+ queues + ", version=" + version + ", runtime=" + runtime
				+ ", lastModified=" + lastModified + ", baseDir=" + baseDir
				+ ", zone=" + zone + ", enabled=" + enabled + "]";
	}


	
}
