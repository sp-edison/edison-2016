/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CALLBACKS")
public class Callback implements Serializable {

	private static final long serialVersionUID = 7782324458212279735L;
	
	@Id
	@GeneratedValue(generator = "system-uuid2")
	@GenericGenerator(name = "system-uuid2", strategy = "uuid2")
	@Column(name = "callback_uuid", updatable = false, nullable = false)
	private String uuid;
	
//	@Column(name = "ip")
//	private String ip;
//	
//	@Column(name = "port")
//	private String port;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "gid")
	private String gid;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "submittedtime")
	private Date submittedTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "state", nullable = false)
	private Job.JobState state;
	
	@Column(name = "retry", nullable = false)
	private Boolean retry;
	
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "sim_uuid")
//	private Simulation simulation;
	@Column(name = "sim_uuid", nullable = false)
	private String sim_uuid;
	
//	public Callback(String ip, String port, String gid, String sim_uuid) {
	public Callback(String url, String gid, String sim_uuid) {
//		this.ip = ip;
//		this.port = port;
		this.url = url;
		this.gid = gid;
		this.state = Job.JobState.INITIALIZED;
		this.retry = false;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date submittedTime = new Date();
		String sTime = df.format(submittedTime);
		try {
			this.submittedTime = df.parse(sTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.sim_uuid = sim_uuid;
	}

//	public String getIp() {
//		return ip;
//	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

//	public void setIp(String ip) {
//		this.ip = ip;
//	}

//	public String getPort() {
//		return port;
//	}

//	public void setPort(String port) {
//		this.port = port;
//	}

	public String getGid() {
		return gid;
	}

	public Callback() {
	}

	public void setGid(String gid) {
		this.gid = gid;
	}
	
	public Job.JobState getState() {
		return state;
	}

	public void setState(Job.JobState state) {
		this.state = state;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getRetry() {
		return retry;
	}

	public void setRetry(Boolean retry) {
		this.retry = retry;
	}

	@Override
	public String toString() {
		return "Callback [uuid=" + uuid + ", url=" + url + ", gid=" + gid
				+ ", submittedTime=" + submittedTime + ", state=" + state
				+ ", retry=" + retry + ", sim_uuid=" + sim_uuid + "]";
	}
	
}