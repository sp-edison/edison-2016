/**
 * 
 */
package kisti.edison.cloud.web;

import kisti.edison.cloud.service.RepositoryService;
import kisti.edison.cloud.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author jlyu
 *
 */
@Controller
public class RepositoryController extends RestController {

	private RepositoryService repositoryService;
	private UserService userService;
	
	public RepositoryService getRepositoryService() {
		return repositoryService;
	}

	@Autowired
	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	public UserService getUserService() {
		return userService;
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
