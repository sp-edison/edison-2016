package kisti.edison.cloud.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

/**
 * Convenience superclass for DAOs that contains annotations for injecting the
 * session factory and accessing the session.
 */
public abstract class HibernateDAO {
	protected final Logger LOG = Logger.getLogger(this.getClass());
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void setExternalSessionFactory (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		Session session = SessionFactoryUtils.getSession(this.sessionFactory,
				true);
		// LOG.info("Transactional Session ? " +
		// SessionFactoryUtils.isSessionTransactional(session,
		// this.sessionFactory));
		return session;

	}
	
	public void closeSession(Session session) {
		session.close();
	}
}
