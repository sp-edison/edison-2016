/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import kisti.edison.cloud.model.LocalAccount;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * @author junglok
 *
 */
@Repository("localAccountDAO")
public class LocalAccountDAOImpl extends HibernateDAO implements
		LocalAccountDAO {

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.LocalAccountDAO#get(org.hibernate.Session, java.lang.Long)
	 */
	@Override
	public LocalAccount get(Session session, Long id) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		LocalAccount account = (LocalAccount)session.get(LocalAccount.class, id);
		return account;
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.LocalAccountDAO#get(org.hibernate.Session)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LocalAccount> get(Session session) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		
		List<LocalAccount> accounts = null;
		accounts = session.createQuery("from LocalAccount order by id").list();
		return accounts;
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.LocalAccountDAO#create(org.hibernate.Session, kisti.edison.cloud.model.LocalAccount)
	 */
	@Override
	public LocalAccount create(Session session, LocalAccount account) {
		// TODO Auto-generated method stub
		Session s = null;
		if(session == null) {
			s = getSession();
		}
		else {
			s = session;
		}
		s.save(account);
		s.flush();
		return account;
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.LocalAccountDAO#delete(org.hibernate.Session, java.lang.Long)
	 */
	@Override
	public void delete(Session session, Long id) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		
		LocalAccount account = get(session, id);
		session.delete(account);
		session.flush();
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.LocalAccountDAO#update(org.hibernate.Session, kisti.edison.cloud.model.LocalAccount)
	 */
	@Override
	public LocalAccount update(Session session, LocalAccount account) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		
		LocalAccount pAccount = (LocalAccount)session.load(LocalAccount.class, account.getId());
		pAccount.setLocalId(account.getLocalId());
		pAccount.setResourceName(account.getResourceName());
		pAccount.setUsedCount(account.getUsedCount());
		
		session.flush();
		return pAccount;
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.LocalAccountDAO#findByResourceName(org.hibernate.Session, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LocalAccount> findByResourceName(Session session,
			String resourceName) {
		// TODO Auto-generated method stub
		Assert.hasText(resourceName);
		if (session == null) {
			session = getSession();
		}
		
		String query = "from LocalAccount a where a.resourceName = :resourceName";
		Query q = session.createQuery(query);
		q = q.setString("resourceName", resourceName);
		List<LocalAccount> accounts = q.list();

		return accounts;
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.LocalAccountDAO#findByLocalId(org.hibernate.Session, java.lang.String)
	 */
	@Override
	public LocalAccount findByLocalId(Session session, String localId) {
		// TODO Auto-generated method stub
		Assert.hasText(localId);
		if(session == null) {
			session = getSession();
		}
		
		String query = "from LocalAccount a where a.localId = :localId";
		LocalAccount account = (LocalAccount) session.createQuery(query).setString("localId", localId).uniqueResult();
		return account;
	}

	@Override
	public LocalAccount find(Session session, String resourceName, String localId) {
		// TODO Auto-generated method stub
		Assert.hasText(resourceName);
		Assert.hasText(localId);
		if (session == null) {
			session = getSession();
		}
		
		String query = "from LocalAccount a where a.resourceName = :resourceName and a.localId = :localId";
		Query q = session.createQuery(query);
		q = q.setString("resourceName", resourceName);
		q = q.setString("localId", localId);
		LocalAccount account = (LocalAccount)q.uniqueResult();

		return account;
	}

	@Override
	public LocalAccount findLeastUsed(Session session, String resourceName) {
		// TODO Auto-generated method stub
		Assert.hasText(resourceName);
		if (session == null) {
			session = getSession();
		}
		
		List<LocalAccount> accounts = findByResourceName(session, resourceName);
		LocalAccount min = accounts.get(0);
		for(LocalAccount account : accounts) {
			if(account.getUsedCount() <= min.getUsedCount()) {
				min = account;
			}
		}
		return min;
	}

}
