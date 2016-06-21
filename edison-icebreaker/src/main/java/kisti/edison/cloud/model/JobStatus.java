/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import kisti.edison.cloud.util.JsonDateSerializer;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author jlyu
 * 
 */
@XmlType(propOrder = { "title", "description", "uuid", "simulationUuid",
		"jobId", "status", "submittedTime", "startTime", "endTime",
		"executable", "execution", "workingDir", "zipFilePath", "solverId", "solverName", "cyberLabId", "classId", "cluster" })
@XmlRootElement(name = "jobStatus")
public class JobStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private String description;
	private String uuid;
	private String simulationUuid;
	private String jobId;
	private Job.JobState status;
	private Date submittedTime;
	private Date startTime;
	private Date endTime;
	private String executable;
	private String execution;
	private String workingDir;
	private String zipFilePath;
	
	private String solverId;
	private String solverName;
	private String cyberLabId;
	private String classId;
	
	private String cluster;

	public JobStatus() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Job.JobState getStatus() {
		return status;
	}

	public void setStatus(Job.JobState status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSimulationUuid() {
		return simulationUuid;
	}

	public void setSimulationUuid(String simulationUuid) {
		this.simulationUuid = simulationUuid;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getSubmittedTime() {
		return submittedTime;
	}

	public void setSubmittedTime(Date submittedTime) {
		this.submittedTime = submittedTime;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getExecutable() {
		return executable;
	}

	public void setExecutable(String executable) {
		this.executable = executable;
	}

	public String getExecution() {
		return execution;
	}

	public void setExecution(String execution) {
		this.execution = execution;
	}

	public String getWorkingDir() {
		return workingDir;
	}

	public void setWorkingDir(String workingDir) {
		this.workingDir = workingDir;
	}

	public String getZipFilePath() {
		return zipFilePath;
	}

	public void setZipFilePath(String zipFilePath) {
		this.zipFilePath = zipFilePath;
	}

	public String getSolverId() {
		return solverId;
	}

	public void setSolverId(String solverId) {
		this.solverId = solverId;
	}

	public String getSolverName() {
		return solverName;
	}

	public void setSolverName(String solverName) {
		this.solverName = solverName;
	}

	public String getCyberLabId() {
		return cyberLabId;
	}

	public void setCyberLabId(String cyberLabId) {
		this.cyberLabId = cyberLabId;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}
}
