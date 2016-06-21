package kisti.edison.cloud.service;

import org.apache.log4j.Logger;

import kisti.edison.cloud.dao.RoleDAO;
import kisti.edison.cloud.dao.UserDAO;
import kisti.edison.cloud.dao.ClusterDAO;
import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Role;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.util.AuthUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Default implementation of the {@link UserService} interface. This service
 * implements operations related to User data.
 */

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	private final Logger LOG = Logger.getLogger(this.getClass());
	private UserDAO userDAO;
	private RoleDAO roleDAO;
	private ClusterDAO clusterDAO;

	public ClusterDAO getClusterDAO() {
		return clusterDAO;
	}
	
	@Autowired
	public void setClusterDAO(ClusterDAO clusterDAO) {
		this.clusterDAO = clusterDAO;
	}

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Autowired
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	/*
	 * public User getCurrentUser() { final Long id = (Long)
	 * SecurityUtils.getSubject().getPrincipal(); logger.info("currentID :" +
	 * id); if( id != null ) { return getUser(id); } else { return null; } }
	 */

	public User createUser(User user) {
		if (user.getUserId().isEmpty() || user.getPassword().isEmpty())
			return null;

		List<Cluster> clusters = clusterDAO.getClusters(null);
		
		String reqPW = user.getPassword();
		
		user.setRegisteredDate(new Date());
		user.setState(User.UserState.ACTIVATED);
		
		User createdUser = userDAO.createUser(null, user);
	
		// LOG.info("userid : " + createdUser.getUserId());

		// AuthUtils.createUserDir(createdUser.getId(),
		// createdUser.getUserId());
		
		//AuthUtils.createDir(clusters, createdUser.getUserId());
		String storageSource = AuthUtils.createDirs(clusters, createdUser);

		// createdUser.setUID( Long.toString( (Long)(1100+createdUser.getId()) )
		// );
		// createdUser.setGID( Long.toString( (Long)(1100+createdUser.getId()) )
		// );

		createdUser.setStorageSource(Cloud.getInstance().getProp("data.basedir") + "/" + storageSource);

		createdUser.setPassword(reqPW);

		return updateUser(createdUser);
	}

	public List<User> getAllUsers(String orderBy, String order) {
		return userDAO.getAllUsers(null, orderBy, order);
	}

	public User getUser(String userid) {
		return userDAO.findUser(null, userid);
	}

	public void deleteUser(String userid) {
		User user = getUser(userid);
		// AuthUtils.deleteUserDir(userid);
		
		/* maintain the user's data directory even if the user is deleted */
		//AuthUtils.deleteDir(userid);
		
		userDAO.deleteUser(null, user.getId());
	}

	public User updateUser(User user) {
		return userDAO.updateUser(null, user);
	}

	public boolean isExist(String userid) {
		if (getUser(userid) == null) {
			return false;
		} else
			return true;
	}

	public Role findRole(String name) {
		return roleDAO.findRole(null, name);
	}

	@Override
	public void updateUserSessionToken(Long id, String token) {
		// TODO Auto-generated method stub
		userDAO.updateUserSessionToken(null, id, token);
	}

	@Override
	public void deleteUserSessionToken(Long id) {
		// TODO Auto-generated method stub
		userDAO.deleteUserSessionToken(null, id);
	}

	@Override
	public int getUsersCount() {
		// TODO Auto-generated method stub
		return userDAO.getUserCount(null);
	}

	@Override
	public List<User> queryUsers(String orderBy, String order, int startIndex, int maxResults) {
		// TODO Auto-generated method stub
		return userDAO.queryUsers(null, orderBy, order, startIndex, maxResults);
	}

}
