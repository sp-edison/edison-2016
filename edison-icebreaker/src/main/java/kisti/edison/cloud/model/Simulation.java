/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author root
 * 
 */
@Entity
@Table(name = "SIMULATIONS")
@XmlRootElement(name = "simulation_info")
public class Simulation implements Serializable {
	private static final long serialVersionUID = 5208772789840131080L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	@Column(name = "sim_uuid", nullable = false)
	private String uuid;

	@Column(name = "title")
	private String title;

	@Lob
	@Column(name = "description")
	private String description;
	
	@Column(name = "solverId")
	private String solverId;

	@Column(name = "userId")
	private String userId;

	// @Type(type = "kisti.edison.cloud.util.UtcTimestampType")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastModified")
	private Date lastModified;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "simulation", cascade = {
			CascadeType.PERSIST, CascadeType.REMOVE })
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	// @JoinColumn(name = "sim_uuid")
	private List<Job> jobs = new LinkedList<Job>();

	@Column(name = "cluster")
	private String cluster;
	
	@Version
	@Column(name = "version")
	private int version = 0;

	public Simulation() {
		this("", "");
	}

	public Simulation(String title, String description) {
		this.setTitle(title);
		this.setDescription(description);
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@XmlElement(name = "job")
	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@XmlAttribute
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void addJob(Job job) {
		job.setSimulation(this);
		this.getJobs().add(job);
	}
	
	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getSolverId() {
		return solverId;
	}

	public void setSolverId(String solverId) {
		this.solverId = solverId;
	}

	@Override
	public String toString() {
		return "Simulation [uuid=" + uuid + ", title=" + title
				+ ", description=" + description + ", solverId=" + solverId
				+ ", userId=" + userId + ", lastModified=" + lastModified
				+ ", jobs=" + jobs + ", cluster=" + cluster + ", version="
				+ version + "]";
	}

}
