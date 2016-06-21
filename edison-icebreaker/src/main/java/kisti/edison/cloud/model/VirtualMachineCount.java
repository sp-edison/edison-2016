/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author jlyu
 *
 */
@XmlRootElement(name = "virtualMachineCount")
public class VirtualMachineCount implements Serializable {
	private static final long serialVersionUID = -8406547985648404954L;
	//UNKNOWN, PENDING, STARTING, RUNNING, SUSPENDED, MIGRATING, HALTING, STOPPED, SUSPEND_REQ, RESUME_REQ, SHUTDOWN_REQ, ERROR
	
	private int count;
	private int UNKNOWN;
	private int PENDING;
	private int STARTING;
	private int RUNNING;
	private int SUSPENDED;
	private int STOPPED;
	private int ERROR;
	
	public VirtualMachineCount() {
		setCount(0);
		setUNKNOWN(0);
		setPENDING(0);
		setSTARTING(0);
		setSUSPENDED(0);
		setRUNNING(0);
		setERROR(0);
		setSTOPPED(0);
	}
	
	
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
	public int getPENDING() {
		return PENDING;
	}
	public void setPENDING(int pENDING) {
		PENDING = pENDING;
	}
	public int getSTARTING() {
		return STARTING;
	}
	public void setSTARTING(int sTARTING) {
		STARTING = sTARTING;
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
	public int getERROR() {
		return ERROR;
	}
	public void setERROR(int eRROR) {
		ERROR = eRROR;
	}
	public int getSTOPPED() {
		return STOPPED;
	}
	public void setSTOPPED(int sTOPPED) {
		STOPPED = sTOPPED;
	}
	
}
