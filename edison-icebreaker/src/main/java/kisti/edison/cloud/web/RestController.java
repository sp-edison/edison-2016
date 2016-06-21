/**
 * 
 */
package kisti.edison.cloud.web;

import org.apache.log4j.Logger;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author root
 * 
 */
public class RestController {
	protected final Logger LOG = Logger.getLogger(this.getClass());

	protected enum SORT {
		asc("asc"),
		desc("desc");
		
		private String sort;
		SORT(String sort) {
			this.sort = sort;
		}
		
		public String getSort() { return this.sort; }
		
		public static SORT fromString(String sort) {
			if(sort != null) {
				for(SORT s : SORT.values()) {
					if(sort.equals(s.sort)) {
						return s;
					}
				}
			}
			return null;
		}
	}
	
	protected <T> ResponseEntity<T> responseWriter(Subject currentUser,
			T value, HttpHeaders header, HttpStatus status) {
		if (currentUser != null && currentUser.isAuthenticated()) {
			LOG.debug("Will be session logged out (userId : "
					+ currentUser.getPrincipals().getPrimaryPrincipal() + ")");
			currentUser.logout();
		}
		return new ResponseEntity<T>(value, header, status);
	}
}
