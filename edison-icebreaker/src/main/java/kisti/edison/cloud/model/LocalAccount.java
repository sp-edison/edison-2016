/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author junglok
 *
 */
@Entity
@Table(name = "LOCALACCOUNTS")
@XmlRootElement(name = "localAccount")
public class LocalAccount implements Serializable {

	private static final long serialVersionUID = 7437646279564348637L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Long id = null;
	
	@Column(name = "resourceName")
	private String resourceName;
	
	@Column(name = "locaId")
	private String localId;
	
	@Column(name = "usedCount")
	private Long usedCount;
	
	
	public LocalAccount() {
	}
	
	public LocalAccount(String name, String id, Long usedCnt) {
		resourceName = name;
		localId = id;
		usedCount = usedCnt;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public Long getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(Long usedCount) {
		this.usedCount = usedCount;
	}

	@Override
	public String toString() {
		return "LocalAccount [id=" + id + ", resourceName=" + resourceName
				+ ", localId=" + localId + ", usedCount=" + usedCount + "]";
	}
	
	
}
