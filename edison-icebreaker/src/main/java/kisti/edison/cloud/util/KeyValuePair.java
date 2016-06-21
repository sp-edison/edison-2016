/**
 * 
 */
package kisti.edison.cloud.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author root
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class KeyValuePair {

	@XmlAttribute
	private String key;

	@XmlAttribute
	private String value;

	public KeyValuePair() {
		super();
	}

	public KeyValuePair(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
