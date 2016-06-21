/**
 * Copyright (c) 2012 KISTI. All rights reserved.
 * EDISON.
 * 
 * Package : kisti.edison.cloud.web
 * File         : UserController.java
 * Date       : Jan 11, 2012 
 */
package kisti.edison.cloud.web;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Count;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.Login;
import kisti.edison.cloud.model.ResourceUsage;
import kisti.edison.cloud.model.Role;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.model.User.UserState;
import kisti.edison.cloud.model.UserList;
import kisti.edison.cloud.service.BackupService;
import kisti.edison.cloud.service.JobService;
import kisti.edison.cloud.service.UserService;
import kisti.edison.cloud.util.AuthUtils;
import kisti.edison.cloud.util.DateUtil;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import com.sun.syndication.io.impl.Base64;
import kisti.edison.cloud.util.Base64;

/**
 * @author root
 * 
 */
@Controller
public class UserController extends RestController {
	private UserService userService;
	private BackupService backupService;
	private JobService jobService;

	private enum FIELD {
		id("id"),
		userId("userId"),
		email("email");
		
		private String field;
		
		FIELD(String f) {
			this.field = f;
		}
		
		public String getField() { return this.field; }
		
		public static FIELD fromString(String field) {
			if(field != null) {
				for(FIELD f : FIELD.values()) {
					if(field.equals(f.field)) {
						return f;
					}
				}
			}
			return null;
		}
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public BackupService getBackupService() {
		return backupService;
	}
	@Autowired
	public void setBackupService(BackupService backupService) {
		this.backupService = backupService;
	}
	public JobService getJobService() {
		return jobService;
	}
	@Autowired
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/core/usage", headers = "Accept=application/json, application/xml")
	public ResponseEntity<ResourceUsage> getResourceUsage(HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("getResourceUsage() called : " + currentUser.getPrincipal().toString());
		
		String userId = currentUser.getPrincipal().toString();
		List<Job> jobs = jobService.findJobsByUserId(userId);
		ResourceUsage usage = new ResourceUsage();
		
		if (jobs == null || jobs.isEmpty()) {
			usage.setJobCount(0);
			usage.setCoresCanceled(0);
			usage.setCoresCompleted(0);
			usage.setCoresQueued(0);
			usage.setCoresRunning(0);
		} else {
			usage.setJobCount(jobs.size());
			int canceledcores = 0;
			int completedcores = 0;
			int queuedcores = 0;
			int runningcores = 0;
			for(Job job : jobs) {
				if(job.getState().equals(Job.JobState.RUNNING)) {
					runningcores += job.getnProcs();
				} else if(job.getState().equals(Job.JobState.QUEUED)) {
					queuedcores += job.getnProcs();
				} else if(job.getState().equals(Job.JobState.CANCELED)) {
					canceledcores += job.getnProcs();
				} else if(job.getState().equals(Job.JobState.FAILED) || job.getState().equals(Job.JobState.SUCCESS)) {
					completedcores += job.getnProcs();
				}
			}
			usage.setCoresCanceled(canceledcores);
			usage.setCoresCompleted(completedcores);
			usage.setCoresQueued(queuedcores);
			usage.setCoresRunning(runningcores);
		}
		return responseWriter(currentUser, usage, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/login", headers = "Accept=application/json, application/xml")
	public ResponseEntity<String> login(@RequestBody Login login,
			HttpServletRequest request) {
		String response = "";
		String session = "";
		String userId = login.getUserId();
		String password = login.getPassword();
		LOG.info("login() called : " + userId);
		Subject currentUser = SecurityUtils.getSubject();
		
		
		if (userId.isEmpty() || password.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		UsernamePasswordToken token = new UsernamePasswordToken(userId, password);
		try {
			currentUser.login(token);
			/*
			 * keys = AuthUtils.getKeyPairs( login.getUserId(),
			 * login.getPassword() ); Iterator<String> iter =
			 * keys.keySet().iterator(); String pubKey = "", privKey = "";
			 * 
			 * while( iter.hasNext() ) { pubKey = iter.next(); privKey =
			 * keys.get(pubKey); LOG.info("Token : " + pubKey);
			 * LOG.info("Secret : " + privKey); }
			 * 
			 * User user = userService.getUser(login.getUserId()); if(user ==
			 * null) { return responseWriter(currentUser, null, new
			 * HttpHeaders(), HttpStatus.NOT_FOUND); } user.setPublicKey(new
			 * Sha256Hash(pubKey).toHex()); user.setPrivateKey(privKey);
			 * 
			 * User updatedUser = userService.updateUserKeys(user); if(
			 * updatedUser == null ) { return responseWriter(currentUser, null,
			 * new HttpHeaders(), HttpStatus.BAD_REQUEST); }
			 * 
			 * LOG.info(updatedUser.toString()); response = "Token:" + pubKey +
			 * "\n"; response += "Secret:" + privKey;
			 */

			long started = DateUtil.getUTCTime();
			long expired = started
					+ Long.parseLong(Cloud.getInstance().getProp(
							"token.valid.period")) * 1000L;
			session = Base64.encode(userId + ":" + Long.toString(started)
					+ Cloud.getInstance().getProp("global.seperator")
					+ Long.toString(expired));
//			tokenStr = Long.toString(started)
//					+ Cloud.getInstance().getProp("global.seperator")
//					+ Long.toString(expired);

			User user = userService.getUser(userId);
			if (user == null) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.BAD_REQUEST);
			}

//			userService.updateUserSessionToken(user.getId(), new Sha256Hash(
//					tokenStr.toCharArray()).toHex());

			Session s = currentUser.getSession();
			LOG.info("sessionId: " + s.getId().toString());
			
			response += "Token: " + session + "\n";
			response += "Expired: " + new Date(DateUtil.getLocalTime(expired));

		} catch (AuthenticationException e) {
			LOG.info("LOGIN FAILED (userId : " + userId + "), " + e.getMessage());
			if(e.getMessage().equals(Cloud.Error.USER_NOT_FOUND)) {
				return responseWriter(currentUser, null, new HttpHeaders(), HttpStatus.NOT_FOUND);
			}
			else {
				return responseWriter(currentUser, null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
			}
		}

		LOG.info("LOGIN SUCCESS (userId : " + userId + ")");
		return responseWriter(currentUser, response, new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/logout", headers = "Accept=application/json, application/xml")
	public ResponseEntity<String> logout(HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("logout() called : " + currentUser.getPrincipal().toString());
		return responseWriter(currentUser, "OK", new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/count", headers = "Accept=application/json, application/xml")
	public ResponseEntity<Count> getUserCount(HttpServletRequest request) {
		LOG.info("getUserCount() called");
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		int userCnt = userService.getUsersCount();

		return responseWriter(currentUser, new Count(userCnt),
				new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/list", headers = "Accept=application/json, application/xml")
	public ResponseEntity<UserList> getUserList(
			@RequestParam(value = "startIndex", required = false) String startIndex,
			@RequestParam(value = "maxResults", required = false) String maxResults,
			@RequestParam(value = "field", required = false) String field,
			@RequestParam(value = "sort", required = false) String sort,
			HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("getUserList() called : " + currentUser.getPrincipal().toString());

		String mField = null;
		String mSort = null;
		
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		if(field == null || field.isEmpty()) {
			mField = "id";
		} else {
			mField = field;
		}
		
		if(sort == null || sort.isEmpty()) {
			mSort = "asc";
		} else {
			mSort = sort;
		}
		
		if ( !(FIELD.fromString(mField) instanceof FIELD) || !(SORT.fromString(mSort) instanceof SORT) ) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}


		List<User> users = null;
		if (startIndex != null && !startIndex.isEmpty() && maxResults != null
				&& !maxResults.isEmpty()) {
			if (Integer.parseInt(startIndex) < 0 || Integer.parseInt(maxResults) < 1) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.BAD_REQUEST);
			}
			users = userService.queryUsers(mField, mSort, Integer.parseInt(startIndex),
					Integer.parseInt(maxResults));
		} else if ((startIndex == null || startIndex.isEmpty())
				&& (maxResults != null && !maxResults.isEmpty())) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		} else if ((startIndex != null && !startIndex.isEmpty())
				&& (maxResults == null || maxResults.isEmpty())) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		} else {
			users = userService.getAllUsers(mField, mSort);
		}

		UserList list = new UserList(users);

		return responseWriter(currentUser, list, new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{userId}/info", headers = "Accept=application/json, application/xml")
	public ResponseEntity<User> getUser(@PathVariable String userId,
			HttpServletRequest request) {
		LOG.info("getUser() called");
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("currentUser : " + currentUser.getPrincipal().toString());

		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)
				&& (!userId.equals(currentUser.getPrincipal().toString()))) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		User user = userService.getUser(userId);
		if (user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		return responseWriter(currentUser, user, new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/user/register", headers = "Accept=application/json, application/xml")
	public ResponseEntity<User> postUser(@RequestBody User user,
			HttpServletRequest request) {
		LOG.info("postUser() called : " + user.getUserId());
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("currentUser : " + currentUser.getPrincipal().toString());

		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		if(user.getUserId() != null) {
			user.setUserId(user.getUserId().trim());
		}
		if(user.getPassword() != null) {
			user.setPassword(user.getPassword().trim());
		}
		if(user.getEmail() != null) {
			user.setEmail(user.getEmail().trim());
		}
		
		if (userService.isExist(user.getUserId())) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.CONFLICT);
		}
		if (user.getRoles().size() == 0) {
			/* if the user's role is not defined, default has "user" role */
			Role defaultRole = userService.findRole(Cloud.ROLE_USER);
			Set<Role> roles = new HashSet<Role>();
			roles.add(defaultRole);
			user.setRoles(roles);
		} else {
			/* TODO: role management */
		}

		user.setUid("");
		user.setGid("");
		user.setUuid("");
		user.setSessionToken("");
		
		if(user.getCyberLabId() == null) {
			user.setCyberLabId("");
		}
		if(user.getClassId() == null) {
			user.setClassId("");
		}
		
		User createdUser = userService.createUser(user);

		if (createdUser == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		return responseWriter(currentUser, createdUser, new HttpHeaders(),
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/user/{userId}", headers = "Accept=application/json, application/xml")
	public ResponseEntity<User> updateUser(@PathVariable String userId,
			@RequestBody User user, HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("currentUser : " + currentUser.getPrincipal().toString());

		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)
				&& (!userId.equals(currentUser.getPrincipal().toString()))) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		if (!userService.isExist(userId)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		if (user.getUserId().isEmpty() || user.getPassword().isEmpty()
				|| user.getEmail().isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		User findedUser = userService.getUser(userId);
		user.setId(findedUser.getId());
		User updatedUser = userService.updateUser(user);
		return responseWriter(currentUser, updatedUser, new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/user/{userId}", headers = "Accept=application/json, application/xml")
	public ResponseEntity<User> deleteUser(@PathVariable String userId,
			HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("currentUser : " + currentUser.getPrincipal().toString());

		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		if (!userService.isExist(userId)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		} else if (userId.equals(Cloud.ADMIN_USERID)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.FORBIDDEN);
		}

		userService.deleteUser(userId);
		return responseWriter(currentUser, null, new HttpHeaders(),
				HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/user/deactivate", headers = "Accept=application/json, application/xml")
	public ResponseEntity<UserList> deactivateUsers(@RequestBody UserList users,
			HttpServletRequest request) {
		LOG.info("deactivateUsers() called");
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("currentUser : " + currentUser.getPrincipal().toString());
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}
		
		if(users == null | users.getUsers().size() == 0) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		List<User> userList = new LinkedList<User>();
		
		for(User user : users.getUsers()) {
			LOG.info(user);
			User u = userService.getUser(user.getUserId());
			if((u == null) || (u.getUserId().equals(Cloud.getInstance().getProp("user.admin.id"))) ||
					(u.getState().equals(UserState.DEACTIVATING)) || 
					(u.getState().equals(UserState.DEACTIVATED)) ) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.BAD_REQUEST);
			}
			userList.add(u);
		}
		
		List<User> rusers = new LinkedList<User>();
		for(User user : userList) {
			User uu = backupService.backupUserData(user, false);
			rusers.add(uu);
		}
		
		UserList list = new UserList(rusers);
		return responseWriter(currentUser, list, new HttpHeaders(),
				HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "/user/query", headers = "Accept=application/json, application/xml")
	public ResponseEntity<UserList> queryUsers(
			@RequestParam(value = "startIndex", required = true) int startIndex,
			@RequestParam(value = "maxResults", required = true) int maxResults,
			HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("currentUser : " + currentUser.getPrincipal().toString());

		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		if (startIndex < 0) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		List<User> users = userService.queryUsers(null, null, startIndex, maxResults);
		UserList list = new UserList(users);

		return responseWriter(currentUser, list, new HttpHeaders(),
				HttpStatus.OK);
	}
}
