package kisti.edison.cloud.plugin.security;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.Sha256CredentialsMatcher;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;

import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Component;

import kisti.edison.cloud.dao.UserDAO;
import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Role;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.model.User.UserState;
import kisti.edison.cloud.util.DateUtil;

/**
 * The Spring/Hibernate sample application's one and only configured Apache
 * Shiro Realm.
 * 
 * <p>
 * Because a Realm is really just a security-specific DAO, we could have just
 * made Hibernate calls directly in the implementation and named it a
 * 'HibernateRealm' or something similar.
 * </p>
 * 
 * <p>
 * But we've decided to make the calls to the database using a UserDAO, since a
 * DAO would be used in other areas of a 'real' application in addition to here.
 * We felt it better to use that same DAO to show code re-use.
 * </p>
 */
@Component
public class SimpleRealm extends AuthorizingRealm {
	private final Logger logger = Logger.getLogger(this.getClass());
	protected UserDAO userDAO = null;
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SimpleRealm() {
		setName("simpleRealm"); // This name must match the name in the User
								// class's getPrincipals() method
		setCredentialsMatcher(new Sha256CredentialsMatcher());
		// setCredentialsMatcher(new SimpleCredentialsMatcher());
	}

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
//		logger.debug("doGetAuthenticationInfo()");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

		logger.info("Login userId : " + token.getUsername());
//		logger.info("doGetAuthenticationInfo() : token credential : "
//				+ new String(token.getPassword()));
//		logger.debug("doGetAuthenticationInfo() : token host : "
//				+ token.getHost());

		Session session = SessionFactoryUtils.getSession(this.sessionFactory,
				true);
		User user = userDAO.findUser(null, token.getUsername());
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);

		if (user != null) {
			if(!(user.getState().equals(UserState.ACTIVATED))) {
				logger.info("DEACTIVATED USER : " + token.getUsername());
				throw new AuthenticationException(Cloud.Error.USER_DEACTIVATED);
				//return null;
			}
			logger.debug("doGetAuthenticationInfo() : userid : " + user.getUserId());
			logger.debug("doGetAuthenticationInfo() : password : " + user.getPassword());
			if ((new String(token.getPassword())).indexOf(Cloud.getInstance()
					.getProp("global.seperator")) == (-1)) {
				String credential = new String(token.getPassword());
				logger.debug("normal login : " + new Sha256Hash(credential.toCharArray()).toHex());
				return new SimpleAuthenticationInfo(user.getUserId(),
						user.getPassword(), getName());
			} else {
				String credential = new String(token.getPassword());
				logger.debug("login with session token : " + new Sha256Hash(credential.toCharArray()).toHex());
				String expired = credential.substring(credential.indexOf(Cloud.getInstance().getProp("global.seperator"))
						+ (int) (Cloud.getInstance().getProp("global.seperator").length()));
				Date expiredDate = new Date(DateUtil.getLocalTime(Long.parseLong(expired)));
				if (expiredDate.compareTo(new Date()) < 0) {
					logger.debug("TOKEN EXPIRED");
					return new SimpleAuthenticationInfo(user.getUserId(), "TOKENEXPIRED", getName());
				} else {
					logger.debug("TOKEN VALID");
					return new SimpleAuthenticationInfo(user.getUserId(), new Sha256Hash(credential.toCharArray()).toHex(), getName());
				}

			}
		} else {
			logger.info("USER NOT FOUND");
			throw new AuthenticationException(Cloud.Error.USER_NOT_FOUND);
			//return null;
		}
	}

	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		logger.debug("doGetAuthorizationInfo()");
		String userId = (String) principals.fromRealm(getName()).iterator()
				.next();
		Session session = SessionFactoryUtils.getSession(this.sessionFactory,
				true);
		User user = userDAO.findUser(null, userId);
		SessionFactoryUtils.releaseSession(session, this.sessionFactory);
		if (user != null) {
			logger.debug("doGetAuthorizationInfo() : userid : "
					+ user.getUserId());
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			for (Role role : user.getRoles()) {
				logger.debug("doGetAuthorizationInfo() role : "
						+ role.getName());
				info.addRole(role.getName());
				info.addStringPermissions(role.getPermissions());
			}
			return info;
		} else {
			return null;
		}
	}

}
