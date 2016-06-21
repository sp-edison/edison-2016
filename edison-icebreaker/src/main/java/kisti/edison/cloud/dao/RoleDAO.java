/**
 * Copyright (c) 2012 KISTI. All rights reserved.
 * EDISON.
 * 
 * Package : kisti.edison.cloud.dao
 * File         : RoleDAO.java
 * Date       : Jan 12, 2012 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import org.hibernate.Session;

import kisti.edison.cloud.model.Role;

/**
 * @author root
 * 
 */
public interface RoleDAO {

	public List<Role> getRoles(Session session);
	
	public Role getRole(Session session, Long id);

	public Role findRole(Session session, String name);
	
	public void deleteRole(Session session, Long id);

}
