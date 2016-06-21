/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author admin
 *
 */
@XmlType(propOrder = { "jobCount", "coresRunning", "coresQueued", "coresCanceled", "coresCompleted" })
@XmlRootElement(name = "ResourceUsage")
public class ResourceUsage implements Serializable {
	private static final long serialVersionUID = -2021555166588424030L;

	private int jobCount;
	private int coresRunning;
	private int coresQueued;
	private int coresCanceled;
	private int coresCompleted;
	
	public ResourceUsage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the jobCount
	 */
	public int getJobCount() {
		return jobCount;
	}

	/**
	 * @param jobCount the jobCount to set
	 */
	public void setJobCount(int jobCount) {
		this.jobCount = jobCount;
	}

	/**
	 * @return the coresRunning
	 */
	public int getCoresRunning() {
		return coresRunning;
	}

	/**
	 * @param coresRunning the coresRunning to set
	 */
	public void setCoresRunning(int coresRunning) {
		this.coresRunning = coresRunning;
	}

	/**
	 * @return the coresQueueud
	 */
	public int getCoresQueued() {
		return coresQueued;
	}

	/**
	 * @param coresQueueud the coresQueueud to set
	 */
	public void setCoresQueued(int coresQueued) {
		this.coresQueued = coresQueued;
	}

	/**
	 * @return the coresCanceled
	 */
	public int getCoresCanceled() {
		return coresCanceled;
	}

	/**
	 * @param coresCanceled the coresCanceled to set
	 */
	public void setCoresCanceled(int coresCanceled) {
		this.coresCanceled = coresCanceled;
	}

	/**
	 * @return the coresCompleted
	 */
	public int getCoresCompleted() {
		return coresCompleted;
	}

	/**
	 * @param coresCompleted the coresCompleted to set
	 */
	public void setCoresCompleted(int coresCompleted) {
		this.coresCompleted = coresCompleted;
	}

}
