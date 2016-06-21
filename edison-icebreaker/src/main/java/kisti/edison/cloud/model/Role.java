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

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import javax.persistence.Version;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.CollectionOfElements;

/**
 * @author jlyu
 * 
 */
@Entity
@Table(name = "ROLES")
@XmlType(propOrder = { "id", "name", "description", "permissions" })
@XmlRootElement(name = "role")
public class Role implements Serializable {
	private static final long serialVersionUID = 5576906640567022861L;

	@Id
	@GeneratedValue
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;

	@CollectionOfElements
	@JoinTable(name = "ROLES_PERMISSIONS")
	private Set<String> permissions;

	@Version
	@Column(name = "version")
	private int version = 0;

	protected Role() {
	}

	public Role(String name, String description, Set<String> permissions) {
		this.setName(name);
		this.setDescription(description);
		this.setPermissions(permissions);
	}

	@XmlAttribute
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// @XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	@XmlAttribute
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
