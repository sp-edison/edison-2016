/**
 * Copyright (c) 2012 KISTI. All rights reserved.
 * EDISON.
 * 
 * Package : kisti.edison.cloud.model
 * File    : User.java
 * Date    : Jan 6, 2012 2012
 *  
 */
package kisti.edison.cloud.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import kisti.edison.cloud.model.VirtualMachine.VirtualMachineState;

/**
 * @author jlyu
 * 
 */
@Entity
@Table(name = "USERS")
@XmlType(propOrder = { "id", "uuid", "userId", "password", "cyberLabId", "classId", "email",
		"userName", "affiliation", "major", "className", "registeredDate", "storageSource", "uid", "gid",
		"sessionToken", "roles", "tickets", "state"})
@XmlRootElement(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = -8638330478758675159L;

	public static enum UserState {
		UNKNOWN, ACTIVATED, DEACTIVATING, DEACTIVATED
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Long id = null;

	@Column(name = "userid", nullable = false)
	private String userId;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "uuid")
	private String uuid;

	@Column(name = "uid")
	private String uid;

	@Column(name = "gid")
	private String gid;

	@Column(name = "storagesource")
	private String storageSource;

	@Column(name = "userName")
	private String userName;
	
	@Column(name = "affiliation")
	private String affiliation;

	@Column(name = "major")
	private String major;
	
	@Column(name = "className")
	private String className;

	@Column(name = "sessiontoken")
	private String sessionToken;
	
	@Column(name = "cyberLabId")
	private String cyberLabId;
	
	@Column(name = "classId")
	private String classId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registeredDate")
	private Date registeredDate;
	
	@Column(name = "tickets")
	private Long tickets;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "state", nullable=true)
	private UserState state;
	
	@Version
	@Column(name = "version")
	private int version = 0;

	@ManyToMany
	@JoinTable(name = "USERS_ROLES")
	private Set<Role> roles = new HashSet<Role>();

	public User() {
	}

	public User(String userid, String password) {
		this.setUserId(userid);
		this.setPassword(password);
	}

	public User(String userid, String password, String email) {
		this.userId = userid;
		this.password = password;
		this.email = email;
	}

	public User(String userid, String password, String email, String uuid,
			String uid, String gid) {
		this.userId = userid;
		this.password = password;
		this.email = email;
		this.uuid = uuid;
		this.uid = uid;
		this.gid = gid;
	}

	@XmlAttribute
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userid) {
		this.userId = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlAttribute
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	@XmlAttribute
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getStorageSource() {
		return storageSource;
	}

	public void setStorageSource(String storageSource) {
		this.storageSource = storageSource;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCyberLabId() {
		return cyberLabId;
	}

	public void setCyberLabId(String cyberLabId) {
		this.cyberLabId = cyberLabId;
	}
	
	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public Long getTickets() {
		return tickets;
	}

	public void setTickets(Long tickets) {
		this.tickets = tickets;
	}
	
	public UserState getState() {
		return state;
	}

	public void setState(UserState state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", password="
				+ password + ", email=" + email + ", uuid=" + uuid + ", uid="
				+ uid + ", gid=" + gid + ", storageSource=" + storageSource
				+ ", userName=" + userName + ", affiliation=" + affiliation
				+ ", major=" + major + ", className=" + className
				+ ", state=" + state
				+ ", sessionToken=" + sessionToken + ", cyberLabId="
				+ cyberLabId + ", classId=" + classId + ", registeredDate="
				+ registeredDate + ", tickets=" + tickets + ", version="
				+ version + ", roles=" + roles + "]";
	}
	
}
