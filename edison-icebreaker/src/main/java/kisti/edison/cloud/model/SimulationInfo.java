/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import kisti.edison.cloud.util.JsonDateSerializer;

/**
 * @author root
 * 
 */
@XmlType(propOrder = { "uuid", "title", "description", "solverId", "userId", "cluster", "jobCount",
		"lastModified" })
@XmlRootElement(name = "simulation")
public class SimulationInfo implements Serializable {
	private static final long serialVersionUID = -663771281784495743L;

	private String uuid;

	private String title;

	private String description;
	
	private String solverId;

	private String userId;

	private Date lastModified;

	private int jobCount;
	
	private String cluster;

	public SimulationInfo() {

	}

	public SimulationInfo(Simulation sim) {
		this.uuid = sim.getUuid();
		this.title = sim.getTitle();
		this.description = sim.getDescription();
		this.userId = sim.getUserId();
		this.lastModified = sim.getLastModified();
		this.jobCount = sim.getJobs().size();
		this.cluster = sim.getCluster();
		this.solverId = sim.getSolverId();
	}

	public String getSolverId() {
		return solverId;
	}

	public void setSolverId(String solverId) {
		this.solverId = solverId;
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

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public int getJobCount() {
		return jobCount;
	}

	public void setJobCount(int jobCount) {
		this.jobCount = jobCount;
	}
	
	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	@Override
	public String toString() {
		return "SimulationInfo [uuid=" + uuid + ", title=" + title
				+ ", description=" + description + ", solverId=" + solverId
				+ ", userId=" + userId + ", lastModified=" + lastModified
				+ ", jobCount=" + jobCount + ", cluster=" + cluster + "]";
	}


}
