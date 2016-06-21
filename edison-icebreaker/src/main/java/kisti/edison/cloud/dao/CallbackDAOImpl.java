package kisti.edison.cloud.dao;

import kisti.edison.cloud.model.Callback;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository("callbackDAO")
@SuppressWarnings("unchecked")
public class CallbackDAOImpl  extends HibernateDAO implements CallbackDAO {
	
	@Override
	public Callback getCallback(Session session, String uuid) {
		if (session == null) {
			session = getSession();
		}
		Callback callback = (Callback) session
				.get(Callback.class, uuid);
		return callback;
	}

	@Override
	public boolean deleteCallback(Session session, String uuid) {
		if (session == null) {
			session = getSession();
		}
		Callback callback = getCallback(session, uuid);
		if (callback != null) {
			session.delete(callback);
			session.flush();
			return true;
		}
		return false;
	}

	@Override
	public Callback updateCallback(Session session, Callback callback) {
		if (session == null) {
			session = getSession();
		}
		Callback loadedCallback = (Callback) session.load(Callback.class,
				callback.getUuid());
		loadedCallback.setState(callback.getState());
		session.flush();
		return loadedCallback;
	}

	@Override
	public void addCallback(Session session, Callback callback) {
		if (session == null) {
			session = getSession();
		}
		session.save(callback);
		session.flush();
	}

	@Override
	public Callback findCallbackByUUID(Session session, String uuid) {
		Assert.hasText(uuid);
		if (session == null) {
			session = getSession();
		}
		String query = "from Callback callback where callback.sim_uuid = :uuid";
		Callback callback = (Callback) session.createQuery(query).setString("uuid", uuid)
				.uniqueResult();
		return callback;

	}

}
