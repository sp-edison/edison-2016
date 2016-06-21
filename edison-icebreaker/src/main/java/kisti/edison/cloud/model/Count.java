/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author jlyu
 * 
 */
@XmlRootElement(name = "count")
public class Count implements Serializable {

	private static final long serialVersionUID = 864818457117184075L;

	private int count;

	public Count() {
	}

	public Count(int cnt) {
		setCount(cnt);
	}

	@XmlValue
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
