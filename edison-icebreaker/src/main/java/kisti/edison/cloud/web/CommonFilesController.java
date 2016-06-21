/**
 * 
 */
package kisti.edison.cloud.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.FileItem;
import kisti.edison.cloud.model.FileItemList;
import kisti.edison.cloud.service.ClusterService;
import kisti.edison.cloud.service.RepositoryService;
import kisti.edison.cloud.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jlyu
 *
 */
@Controller
public class CommonFilesController extends RestController {
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
	
	private ClusterService clusterService;

	public ClusterService getClusterService() {
		return clusterService;
	}
	
	@Autowired
	public void setClusterService(ClusterService clusterService) {
		this.clusterService = clusterService;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/common/files/{solverDirectory}/{subDirectory}", headers = "Accept=application/json, application/xml")
	public ResponseEntity<FileItemList> getCommonFiles(
			@PathVariable String solverDirectory,
			@PathVariable String subDirectory,
			@RequestParam(value = "cluster", required = true) String clusterName,
			HttpServletRequest request)
	{
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("CommonFilesController::getCommonFiles() called (userId : " + currentUser.getPrincipal().toString() + ")");
		LOG.info("CommonFilesController::getCommonFiles() called (solverDirectory    : " + solverDirectory + ")");
		LOG.info("CommonFilesController::getCommonFiles() called (subDirectory    : " + subDirectory + ")");
		
		if (solverDirectory == null || solverDirectory.isEmpty() ) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		if (subDirectory == null || subDirectory.isEmpty() ) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		if(clusterName == null || clusterName.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		Cluster c = clusterService.findCluster(clusterName);
		
		if(c == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		List<FileItem> fileItems = null;
		try {
			
			fileItems = repositoryService.getFiles(c.getBaseDir() + '/' + 
									Cloud.getInstance().getProp("commonstorage.basedir") + '/' + solverDirectory + '/' + subDirectory);
					
			if (fileItems == null) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.BAD_REQUEST);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return responseWriter(currentUser, new FileItemList(fileItems),
				new HttpHeaders(), HttpStatus.OK);
	}
}
