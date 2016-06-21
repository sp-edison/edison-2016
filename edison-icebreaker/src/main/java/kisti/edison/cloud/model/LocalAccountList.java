/**
 * 
 */
package kisti.edison.cloud.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author junglok
 *
 */
@XmlRootElement(name = "localAccounts")
public class LocalAccountList {
	private int count;
	private List<LocalAccount> localAccounts;
	
	public LocalAccountList() {
	}
	
	public LocalAccountList(List<LocalAccount> accounts) {
		count = accounts.size();
		localAccounts = accounts;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElement(name = "localAccount")
	public List<LocalAccount> getLocalAccounts() {
		return localAccounts;
	}

	public void setLocalAccounts(List<LocalAccount> localAccounts) {
		this.localAccounts = localAccounts;
	}
}
