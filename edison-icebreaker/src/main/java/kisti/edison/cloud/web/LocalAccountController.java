/**
 * 
 */
package kisti.edison.cloud.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kisti.edison.cloud.dao.LocalAccountDAO;
import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.LocalAccount;
import kisti.edison.cloud.model.LocalAccountList;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author junglok
 *
 */
@Controller
public class LocalAccountController extends RestController {

	private LocalAccountDAO localAccountDAO;
	@Autowired
	public void setLocalAccountDAO(LocalAccountDAO localAccountDAO) {
		this.localAccountDAO = localAccountDAO;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/localaccount/{resourceName}/list", headers = "Accept=application/json, application/xml")
	public ResponseEntity<LocalAccountList> getLocalAccounts(@PathVariable String resourceName,	HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("getLocalAccounts() called : " + resourceName);
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),	HttpStatus.UNAUTHORIZED);
		}
		
		List<LocalAccount> accounts = localAccountDAO.findByResourceName(null, resourceName);
		LocalAccountList list = new LocalAccountList(accounts);

		return responseWriter(currentUser, list, new HttpHeaders(),HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/localaccount", headers = "Accept=application/json, application/xml")
	public ResponseEntity<LocalAccount> createLocalAccount(@RequestBody LocalAccount account, HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("createLocalAccount() called." + account);
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),	HttpStatus.UNAUTHORIZED);
		}
		
		LocalAccount a = localAccountDAO.find(null, account.getResourceName(), account.getLocalId());
		if(a != null) {
			return responseWriter(currentUser, null, new HttpHeaders(),	HttpStatus.BAD_REQUEST);
		}
		
		account.setUsedCount(0L);
		LocalAccount created = localAccountDAO.create(null, account);
		if(created == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),	HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		LOG.info(created);
		return responseWriter(currentUser, created, new HttpHeaders(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/localaccount/{resourceName}/{localId}", headers = "Accept=application/json, application/xml")
	public ResponseEntity<LocalAccount> deleteLocalAccount(@PathVariable String resourceName, @PathVariable String localId, HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("deleteLocalAccount() called." + resourceName + ":" + localId);
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),	HttpStatus.UNAUTHORIZED);
		}
		
		LocalAccount a = localAccountDAO.find(null, resourceName, localId);
		if(a == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),	HttpStatus.NOT_FOUND);
		}
		localAccountDAO.delete(null, a.getId());
		return responseWriter(currentUser, null, new HttpHeaders(),HttpStatus.OK);
	}

}
