/**
 * 
 */
package kisti.edison.cloud.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author root
 * 
 */
@XmlRootElement(name = "login")
public class Login implements Serializable {
	private static final long serialVersionUID = 4353189591501954422L;

	private String userId;

	private String password;

	public Login() {
	}

	public Login(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
