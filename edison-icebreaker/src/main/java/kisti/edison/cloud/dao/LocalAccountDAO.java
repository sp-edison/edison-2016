/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import kisti.edison.cloud.model.LocalAccount;

import org.hibernate.Session;

/**
 * @author junglok
 *
 */
public interface LocalAccountDAO {

	public LocalAccount get(Session session, Long id);
	
	public List<LocalAccount> get(Session session);
	
	public LocalAccount create(Session session, LocalAccount account);
	
	public void delete(Session session, Long id);
	
	public LocalAccount update(Session session, LocalAccount account);
	
	public List<LocalAccount> findByResourceName(Session session, String resourceName);
	
	public LocalAccount findByLocalId(Session session, String localId);
	
	public LocalAccount find(Session session, String resourceName, String localId);
	
	public LocalAccount findLeastUsed(Session session, String resourceName);
	
}
