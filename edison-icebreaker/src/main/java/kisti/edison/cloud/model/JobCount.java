/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author jlyu
 *
 */
@XmlType(propOrder = { "count", "UNKNOWN", "INITIALIZE_FAILED", "INITIALIZED", "SUBMISSION_FAILED",
		"QUEUED", "RUNNING", "SUSPENDED", "CANCELED", "SUCCESS", "FAILED" })
@XmlRootElement(name = "jobCount")
public class JobCount implements Serializable {
	private static final long serialVersionUID = 907738490362003739L;
	
	//UNKNOWN, INITIALIZE_FAILED, INITIALIZED, SUBMISSION_FAILED, QUEUED, RUNNING, SUSPEND_REQUESTED, SUSPENDED, CANCEL_REQUESTED, CANCELED, SUCCESS, FAILED
	
	private int count;
	private int UNKNOWN;
	private int INITIALIZE_FAILED;
	private int INITIALIZED;
	private int SUBMISSION_FAILED;
	private int QUEUED;
	private int RUNNING;
	private int SUSPENDED;
	private int CANCELED;
	private int SUCCESS;
	private int FAILED;
	
	public JobCount() {}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getUNKNOWN() {
		return UNKNOWN;
	}
	public void setUNKNOWN(int uNKNOWN) {
		UNKNOWN = uNKNOWN;
	}
	public int getINITIALIZE_FAILED() {
		return INITIALIZE_FAILED;
	}
	public void setINITIALIZE_FAILED(int iNITIALIZE_FAILED) {
		INITIALIZE_FAILED = iNITIALIZE_FAILED;
	}
	public int getINITIALIZED() {
		return INITIALIZED;
	}
	public void setINITIALIZED(int iNITIALIZED) {
		INITIALIZED = iNITIALIZED;
	}
	public int getSUBMISSION_FAILED() {
		return SUBMISSION_FAILED;
	}
	public void setSUBMISSION_FAILED(int sUBMISSION_FAILED) {
		SUBMISSION_FAILED = sUBMISSION_FAILED;
	}
	public int getQUEUED() {
		return QUEUED;
	}
	public void setQUEUED(int qUEUED) {
		QUEUED = qUEUED;
	}
	public int getRUNNING() {
		return RUNNING;
	}
	public void setRUNNING(int rUNNING) {
		RUNNING = rUNNING;
	}
	public int getSUSPENDED() {
		return SUSPENDED;
	}
	public void setSUSPENDED(int sUSPENDED) {
		SUSPENDED = sUSPENDED;
	}
	public int getCANCELED() {
		return CANCELED;
	}
	public void setCANCELED(int cANCELED) {
		CANCELED = cANCELED;
	}
	public int getFAILED() {
		return FAILED;
	}
	public void setFAILED(int fAILED) {
		FAILED = fAILED;
	}
	public int getSUCCESS() {
		return SUCCESS;
	}
	public void setSUCCESS(int sUCCESS) {
		SUCCESS = sUCCESS;
	}
	
}
