package kisti.edison.cloud.dao;

import kisti.edison.cloud.model.User;
import java.util.List;

import org.hibernate.Session;

/**
 * Data Access Object for User related operations.
 */
public interface UserDAO {

	public int getUserCount(Session session);

	public User getUser(Session session, Long id);

	public User findUser(Session session, String userid);
	
	public User getUser(Session session, String userid);

	public User createUser(Session session, User user);

	public List<User> getAllUsers(Session session, String orderBy, String order);

	public List<User> queryUsers(Session session, String orderBy, String order, int startIndex, int maxResults);

	public void deleteUser(Session session, Long id);

	public User updateUser(Session session, User user);

	public void updateUserSessionToken(Session session, Long id, String token);

	public void deleteUserSessionToken(Session session, Long id);
	
	public void updateUserAffliation(Session session, Long id, String affiliation);
	
	public User updateState(Session session, Long id, User.UserState state);
	
	public User updateStoragePath(Session session, Long id, String path);
}
