/**
 * Copyright (c) 2012 KISTI. All rights reserved.
 * EDISON.
 * 
 * Package : kisti.edison.cloud.dao
 * File         : RoleDaoImpl.java
 * Date       : Jan 12, 2012 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import kisti.edison.cloud.model.Role;

/**
 * @author root
 * 
 */
@Repository("roleDAO")
public class RoleDAOImpl extends HibernateDAO implements RoleDAO {
	/*
	 * (non-Javadoc)
	 * 
	 * @see kisti.edison.cloud.dao.RoleDAO#getRole(java.lang.Long)
	 */
	@Override
	public Role getRole(Session session, Long id) {
		if(session == null) {
			session = getSession();
		}
		Role role = (Role) session.get(Role.class, id);
		return role;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see kisti.edison.cloud.dao.RoleDAO#findRole(java.lang.String)
	 */
	@Override
	public Role findRole(Session session, String name) {
		Assert.hasText(name);
		if(session == null) {
			session = getSession();
		}
		String query = "from Role r where r.name = :name";
		Role role = (Role) session.createQuery(query).setString("name", name)
				.uniqueResult();
		return role;
	}

	@Override
	public void deleteRole(Session session, Long id) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		
		Role role = getRole(session, id);
		if (role != null) {
			session.delete(role);
			session.flush();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoles(Session session) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		
		List<Role> roles = null;
		roles = (List<Role>)session.createQuery("from Role order by id").list();
		
		return roles;
	}

}
