/**
 * Copyright (c) 2012 KISTI. All rights reserved.
 * EDISON.
 * 
 * Package : kisti.edison.cloud.env
 * File         : CloudEnvironment.java
 * Date       : Jan 12, 2012 
 */
package kisti.edison.cloud.env;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author root
 * 
 */
public class Cloud {
	private final Logger LOG = Logger.getLogger(this.getClass());
	private static Cloud cloud = null;

	public final static String HTTP_HEADER_AUTHORIZATION = "Authorization";
	public final static String HTTP_HEADER_BASIC = "Basic ";
	public final static String USERID = "userId";
	public final static String PASSWORD = "password";
	public final static String ROLE_ADMINISTRATOR = "administrator";
	public final static String ROLE_USER = "user";
	public final static String USER_ROOT_DIR = "/opt/edison/";
	public final static String ADMIN_USERID = "admin";
	
	public final class Error {
		public final static String USER_NOT_FOUND = "USER_NOT_FOUND";
		public final static String PASSWORD_INCORRECT = "PASSWORD_INCORRECT";
		public final static String USER_DEACTIVATED = "USER_DEACTIVATED";
		public Error(){};
	}

	private Map<String, String> env;

	private Cloud() {
		this.env = new HashMap<String, String>();
	}

	public static Cloud getInstance() {
		if (cloud == null) {
			cloud = new Cloud();
		}
		return cloud;
	}

	public void setProp(String key, String value) {
		this.env.put(key, value);
	}

	public String getProp(String key) {
		return this.env.get(key);
	}

	@Override
	public String toString() {
		String ret = "\n";
		Iterator<String> iter = this.env.keySet().iterator();
		while (iter.hasNext()) {
			String k = iter.next();
			ret += ("[ENV] " + k + ":" + this.env.get(k) + "\n");
		}

		return ret;
	}
}
