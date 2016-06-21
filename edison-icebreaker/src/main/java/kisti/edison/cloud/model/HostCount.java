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
@XmlRootElement(name = "hostCount")
public class HostCount implements Serializable {
	private static final long serialVersionUID = -6643840002212817535L;
	// UNKNOWN, PENDING, READY, DISABLED, REMOVED, ERROR
	
	private int count;
	private int UNKNOWN;
	private int PENDING;
	private int READY;
	private int DISABLED;
	private int REMOVED;
	private int ERROR;
	
	public HostCount() {}
	
	
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
	
	public int getREADY() {
		return READY;
	}
	
	public void setREADY(int rEADY) {
		READY = rEADY;
	}
	
	public int getDISABLED() {
		return DISABLED;
	}
	
	public void setDISABLED(int dISABLED) {
		DISABLED = dISABLED;
	}
	
	public int getREMOVED() {
		return REMOVED;
	}
	
	public void setREMOVED(int rEMOVED) {
		REMOVED = rEMOVED;
	}
	
	public int getERROR() {
		return ERROR;
	}
	
	public void setERROR(int eRROR) {
		ERROR = eRROR;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
