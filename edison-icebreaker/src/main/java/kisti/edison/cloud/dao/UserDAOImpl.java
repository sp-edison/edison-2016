package kisti.edison.cloud.dao;

import kisti.edison.cloud.model.User;
import kisti.edison.cloud.model.User.UserState;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

@Repository("userDAO")
@SuppressWarnings("unchecked")
public class UserDAOImpl extends HibernateDAO implements UserDAO {
	public User getUser(Session session, Long id) {
		if(session == null) {
			session = getSession();
		}
		User user = (User) session.get(User.class, id);
		return user;
	}

	public User findUser(Session session, String userid) {
		Assert.hasText(userid);
		if(session == null) {
			session = getSession();
		}
		
		String query = "from User u where u.userId = :userid";
		User user = (User) session.createQuery(query)
				.setString("userid", userid).uniqueResult();
		return user;
	}

	public User createUser(Session session, User user) {
		LOG.info("createUser() : pw = " + user.getPassword());
		LOG.info("createUser() : pw (tobe) = "
				+ new Sha256Hash("gmlwjd").toHex());
		LOG.info("createUser() : pw (orig-str) = "
				+ new Sha256Hash(user.getPassword()).toHex());
		LOG.info("createUser() : pw (orig-ca)  = "
				+ new Sha256Hash(user.getPassword().toCharArray()).toHex());
		if(session == null) {
			session = getSession();
		}
		
		user.setPassword(new Sha256Hash(user.getPassword().toCharArray())
				.toHex());
		session.save(user);
		session.flush();
		return user;
	}

	public List<User> getAllUsers(Session session, String orderBy, String order) {
		if(session == null) {
			session = getSession();
		}
		
		List<User> users = null;
		if(orderBy == null || order == null) {
			users = session.createQuery("from User order by id")
					.list();
		}
		else {
			users = session.createQuery("from User order by " + orderBy + " " + order).list();
		}
		
		return users;
	}

	public void deleteUser(Session session, Long id) {
		User user = getUser(session, id);
		if (user != null) {
			if(session == null) {
				session = getSession();
			}
			session.delete(user);
			session.flush();
		}
	}

	public User updateUser(Session session, User user) {
		// Transaction tr = session.beginTransaction();

		LOG.info("updateUser() : pw = " + user.getPassword());
		LOG.info("updateUser() : pw (tobe) = "
				+ new Sha256Hash("gmlwjd").toHex());
		LOG.info("updateUser() : pw (orig-str) = "
				+ new Sha256Hash(user.getPassword()).toHex());
		LOG.info("updateUser() : pw (orig-ca)  = "
				+ new Sha256Hash(user.getPassword().toCharArray()).toHex());
		
		if(session == null) {
			session = getSession();
		}
		
		User loadeduser = (User) session.load(User.class, user.getId());

		loadeduser.setEmail(user.getEmail());
		loadeduser.setPassword(new Sha256Hash(user.getPassword().toCharArray())
				.toHex());
		loadeduser.setAffiliation(user.getAffiliation());
		loadeduser.setClassName(user.getClassName());
		loadeduser.setMajor(user.getMajor());
		loadeduser.setUserName(user.getUserName());
		loadeduser.setCyberLabId(user.getCyberLabId());
		loadeduser.setClassId(user.getClassId());
		loadeduser.setStorageSource(user.getStorageSource());
		loadeduser.setRegisteredDate(user.getRegisteredDate());
		loadeduser.setTickets(user.getTickets());
		loadeduser.setClassId(user.getClassId());
		loadeduser.setCyberLabId(user.getCyberLabId());
		loadeduser.setGid(user.getGid());
		loadeduser.setUid(user.getUid());
		loadeduser.setState(user.getState());
		// loadeduser.setUserId(user.getUserId());
		// session.update(user);
		session.flush();
		// tr.commit();

		return loadeduser;
	}

	@Override
	public void updateUserSessionToken(Session session, Long id, String token) {
		if(session == null) {
			session = getSession();
		}
		
		User loadeduser = (User) session.load(User.class, id);

		loadeduser.setSessionToken(token);
		session.flush();
	}

	@Override
	public void deleteUserSessionToken(Session session, Long id) {
		if(session == null) {
			session = getSession();
		}
		
		User loadeduser = (User) session.load(User.class, id);

		loadeduser.setSessionToken("");
		session.flush();

	}

	@Override
	public int getUserCount(Session session) {
		// TODO Auto-generated method stub
		if(session == null) session = getSession();
		
		int count = ((Long) session.createQuery(
				"select count(*) from User").uniqueResult()).intValue();
		return count;
	}

	@Override
	public List<User> queryUsers(Session session, String orderBy, String order, int startIndex, int maxResults) {
		// TODO Auto-generated method stub
		if (startIndex < 0) {
			return null;
		}
		
		if(session == null) {
			session = getSession();
		}
		
		Query q;
		if(orderBy == null || order == null) {
			q = session.createQuery("from User order by id");
		}
		else {
			q = session.createQuery("from User order by " + orderBy + " " + order);	
		}
		q.setFirstResult(startIndex);
		q.setMaxResults(maxResults);

		List<User> users = q.list();
		return users;
	}

	@Override
	public User getUser(Session session, String userid) {
		// TODO Auto-generated method stub
		
		if (session == null) {
			session = getSession();
		}
		String query = "from User u where u.userId = :userid";
		User user = (User) session.createQuery(query)
				.setString("userid", userid).uniqueResult();
		return user;
	}

	@Override
	public void updateUserAffliation(Session session, Long id, String affiliation) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		User loadeduser = (User) session.load(User.class, id);

		loadeduser.setAffiliation(affiliation);
		session.flush();
	}


	@Override
	public User updateState(Session session, Long id, UserState state) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		User loadeduser = (User) session.load(User.class, id);
		loadeduser.setState(state);
		session.flush();
		
		return loadeduser;
	}

	@Override
	public User updateStoragePath(Session session, Long id, String path) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		User loadeduser = (User) session.load(User.class, id);
		loadeduser.setStorageSource(path);
		session.flush();
		
		return loadeduser;
	}
}
