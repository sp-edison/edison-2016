/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.oxm.Unmarshaller;

//import cz.atlas.bubbles.it.stringtomap.StringToMap;
import kisti.edison.cloud.util.StringToMap;

import kisti.edison.cloud.util.HashMapAdapter;

/**
 * @author root
 * 
 */
@Entity
@Table(name = "JOBS")
// @XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "job")
public class Job implements Serializable {
	private static final long serialVersionUID = -2772183327348594815L;

	public static enum JobType {
		SEQUENTIAL, PARALLEL
	}

	public static enum JobCategory {
		GAMESS_PARALLEL, 
		GNU_OPENMP_MPI, 
		GNU_MPICH_1, 
		GNU_MPICH_2, 
		GNU_OPENMPI_1_4, 
		GNU_OPENMP, 
		INTEL_OPENMP_MPI, 
		INTEL_MPICH_1,
		INTEL_MPICH_2,
		INTEL_OPENMPI_1_4, 
		INTEL_OPENMP 
	}
	public static enum JobState {
		UNKNOWN, INITIALIZE_FAILED, INITIALIZED, SUBMISSION_FAILED, QUEUED, RUNNING, SUSPEND_REQUESTED, SUSPENDED, CANCEL_REQUESTED, CANCELED, SUCCESS, FAILED
	}

	@Id
	@GeneratedValue(generator = "system-uuid2")
	@GenericGenerator(name = "system-uuid2", strategy = "uuid2")
	@Column(name = "job_uuid", updatable = false, nullable = false)
	private String uuid;

	@Column(name = "solverId")
	private String solverId;
	
	@Column(name = "solverName")
	private String solverName;
	
	@Column(name = "jobid")
	private String jobId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sim_uuid")
	private Simulation simulation;

	@Column(name = "title")
	private String title;

	@Lob
	@Column(name = "description")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private JobType type;

	@Enumerated(EnumType.STRING)
	@Column(name = "category")
	private JobCategory category;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "state", nullable = false)
	private JobState state;

	@Column(name = "lcmstate")
	private String lcmState;

	@Lob
	@Column(name = "executable", nullable = false)
	private String executable;

	@Lob
	@Column(name = "execution")
	private String execution;

	@Lob
	@Column(name = "workingDir")
	private String workingDir;

	@Lob
	@Column(name = "zipFilePath")
	private String zipFilePath;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "submittedtime")
	private Date submittedTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "starttime")
	private Date startTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endtime")
	private Date endTime;

	@Transient
	private HashMap<String, String> files;

	@Lob
	@Column(name = "fileStr")
	private String fileStr;

	@Transient
	private HashMap<String, String> attributes;

	@Lob
	@Column(name = "attrStr")
	private String attrStr;
	
	@Transient
	private HashMap<String, String> dependencies;

	@Lob
	@Column(name = "dependenciesStr")
	private String dependenciesStr;
	
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "cyberLabId")
	private String cyberLabId;
	
	@Column(name = "classId")
	private String classId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "reqState")
	private JobState reqState;

	@Column(name = "nprocs")
	private int nProcs;
	
	@Column(name = "cluster")
	private String cluster;

	@Column(name = "localAccount")
	private String localAccount;
	
	@Version
	@Column(name = "version")
	private int version = 0;

	public Job() {
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@XmlAttribute
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public JobType getType() {
		return type;
	}

	public void setType(JobType type) {
		this.type = type;
	}

	public JobState getState() {
		return state;
	}

	public void setState(JobState state) {
		this.state = state;
	}

	public String getLcmState() {
		return lcmState;
	}

	public void setLcmState(String lcmState) {
		this.lcmState = lcmState;
	}

	public String getExecution() {
		return execution;
	}

	public void setExecution(String execution) {
		this.execution = execution;
	}

	public String getExecutable() {
		return executable;
	}

	public void setExecutable(String executable) {
		this.executable = executable;
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

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Date getSubmittedTime() {
		return submittedTime;
	}

	public void setSubmittedTime(Date submittedTime) {
		this.submittedTime = submittedTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public JobCategory getCategory() {
		return category;
	}

	public void setCategory(JobCategory category) {
		this.category = category;
	}
	
	public static String Map2Str(Map<String, String> props) {
		boolean isFirst = true;
		String str = "";
		Iterator<String> iter = props.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String value = props.get(key);
			if (!isFirst) {
				str += "|";
			} else {
				isFirst = false;
			}
			str += (key + ":" + value);
		}
		return str;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, String> Str2Map(String propStr) {
		Map<String, String> retMap = new HashMap<String, String>();
		if (propStr.isEmpty()) {
			return retMap;
		}
		retMap = (Map<String, String>) StringToMap.toMap(propStr.toCharArray());
		return retMap;
	}

	@Transient
	@XmlJavaTypeAdapter(value = HashMapAdapter.class)
	public HashMap<String, String> getFiles() {
		return files;
	}

	public void setFiles(HashMap<String, String> files) {
		this.files = files;
	}

	public String getFileStr() {
		return fileStr;
	}

	public void setFileStr(String fileStr) {
		this.fileStr = fileStr;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Transient
	@XmlJavaTypeAdapter(value = HashMapAdapter.class)
	public HashMap<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}

	public String getAttrStr() {
		return attrStr;
	}

	public void setAttrStr(String attrStr) {
		this.attrStr = attrStr;
	}

	@Transient
	@XmlJavaTypeAdapter(value = HashMapAdapter.class)
	public HashMap<String, String> getDependencies() {
		return dependencies;
	}

	public void setDependencies(HashMap<String, String> dependencies) {
		this.dependencies = dependencies;
	}
	
	public String getDependenciesStr() {
		return dependenciesStr;
	}

	public void setDependenciesStr(String dependenciesStr) {
		this.dependenciesStr = dependenciesStr;
	}
	
	public JobState getReqState() {
		return reqState;
	}

	public void setReqState(JobState reqState) {
		this.reqState = reqState;
	}

	public int getnProcs() {
		return nProcs;
	}

	public void setnProcs(int nProcs) {
		this.nProcs = nProcs;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlTransient
	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
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

	public String getLocalAccount() {
		return localAccount;
	}

	public void setLocalAccount(String localAccount) {
		this.localAccount = localAccount;
	}

	@Override
	public String toString() {
		return "Job [uuid=" + uuid + ", solverId=" + solverId + ", solverName="
				+ solverName + ", jobId=" + jobId + ", title=" + title
				+ ", description=" + description + ", type=" + type
				+ ", category=" + category + ", state=" + state + ", lcmState="
				+ lcmState + ", executable=" + executable + ", execution="
				+ execution + ", workingDir=" + workingDir + ", zipFilePath="
				+ zipFilePath + ", submittedTime=" + submittedTime
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", files=" + files + ", fileStr=" + fileStr + ", attributes="
				+ attributes + ", attrStr=" + attrStr + ", dependencies="
				+ dependencies + ", dependenciesStr=" + dependenciesStr
				+ ", userId=" + userId + ", cyberLabId=" + cyberLabId
				+ ", classId=" + classId + ", reqState=" + reqState
				+ ", nProcs=" + nProcs + ", cluster=" + cluster + ", localAccount=" + localAccount + ", version="
				+ version + "]";
	}

	public void afterUnmarshal(Unmarshaller u, Object parent) {
		this.simulation = (Simulation) parent;
	}

}
