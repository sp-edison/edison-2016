/**
 * Copyright (c) 2012 KISTI. All rights reserved.
 * EDISON.
 * 
 * Package : kisti.edison.cloud.model
 * File    : Role.java
 * Date    : Jan 6, 2012 2012
 *  
 */
package kisti.edison.cloud.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author jlyu
 * 
 */
@XmlRootElement(name = "users")
public class UserList {
	private int count;
	private List<User> users;

	public UserList() {
	}

	public UserList(List<User> users) {
		this.setUsers(users);
		this.setCount(users.size());
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@XmlElement(name = "user")
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
