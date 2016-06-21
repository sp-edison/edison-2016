/**
 * 
 */
package kisti.edison.cloud.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.FileItem;
import kisti.edison.cloud.model.FileItemList;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.service.ClusterService;
import kisti.edison.cloud.service.RepositoryService;
import kisti.edison.cloud.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author root
 * 
 */
@Controller
public class FileController extends RestController {
	private RepositoryService repositoryService;
	@Autowired
	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}
	
	private ClusterService clusterService;
	public ClusterService getClusterService() {
		return clusterService;
	}
	@Autowired
	public void setClusterService(ClusterService clusterService) {
		this.clusterService = clusterService;
	}
	
	private UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/file/upload", headers = "Accept=application/json, application/xml")
	public ResponseEntity<FileItem> upload(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "cluster", required = true) String clusterName,
			@RequestParam("file") MultipartFile file) {
		LOG.info("FileController::upload() called");
		String fileName = "";
		Subject currentUser = SecurityUtils.getSubject();
		
		if(clusterName == null || clusterName.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		Cluster c = clusterService.findCluster(clusterName);
		if(c == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		User user = userService.getUser(currentUser.getPrincipal().toString());
		if(user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		if (name == null || name.isEmpty()) {
			fileName = file.getOriginalFilename();
		} else {
			fileName = name;
		}
		
		fileName = fileName.replaceAll("\\p{Space}", "_");

		FileItem fileItem = new FileItem();
		fileItem.setName(fileName);
		fileItem.setSize(file.getSize());
		fileItem.setType(file.getContentType());
		fileItem.setDescription(description);
		
		try {
			//repositoryService.create(c, currentUser.getPrincipal().toString(), file.getBytes(), fileItem);
			repositoryService.create(c, user, file.getBytes(), fileItem);
		} catch (IOException e) {
			e.printStackTrace();
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseWriter(currentUser, fileItem, new HttpHeaders(),
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/file/write", headers = "Accept=application/json, application/xml")
	public ResponseEntity<FileItem> write(
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "cluster", required = true) String clusterName,
			@RequestBody String content, HttpServletRequest request) {
		LOG.info("FileController::write() called");
		Subject currentUser = SecurityUtils.getSubject();
		
		if(clusterName == null || clusterName.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		Cluster c = clusterService.findCluster(clusterName);
		if(c == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		User user = userService.getUser(currentUser.getPrincipal().toString());
		if(user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		if (name == null || name.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		String fileName = name.replaceAll("\\p{Space}", "_");
		FileItem fileItem = new FileItem();
		fileItem.setName(fileName);
		fileItem.setType("text/plain");
		fileItem.setSize(Long.valueOf((long) content.length()));
		fileItem.setDescription(description);
		
		
		try {
			//repositoryService.create(c, currentUser.getPrincipal().toString(), content.getBytes(), fileItem);
			repositoryService.create(c, user, content.getBytes(), fileItem);
		} catch (IOException e) {
			e.printStackTrace();
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseWriter(currentUser, fileItem, new HttpHeaders(),
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/file/read")
	public ResponseEntity<String> read(
			@RequestParam(value = "id", required = true) String fileId) {
		LOG.info("FileController::read() called : " + fileId);
		Subject currentUser = SecurityUtils.getSubject();

		FileItem item = repositoryService.find(fileId);
		if (item == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		LOG.info(item.toString());

		if (item.getSize() > Long.parseLong(Cloud.getInstance().getProp(
				"file.max.read"))) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.REQUEST_ENTITY_TOO_LARGE);
		}

		byte[] contents = null;
		try {
			contents = repositoryService.read(item);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType(item.getType()));
		headers.setContentLength(item.getSize());
		return responseWriter(currentUser, new String(contents), headers,
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/file/download")
	public void download(
			@RequestParam(value = "id", required = true) String fileId,
			HttpServletRequest request, HttpServletResponse response) {
		LOG.info("FileController::download() called : " + fileId);
		Subject currentUser = SecurityUtils.getSubject();

		FileItem item = repositoryService.find(fileId);
		if (item == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return;
		}
		else
		{
			// security check, temporarily
			String filePath = item.getPath();
			String canonicalPath = null;
			File tmp = new File(filePath);
			try {
				canonicalPath = tmp.getCanonicalPath();
			} catch (IOException e) {
				LOG.error("getCanonicalPath fail : " + filePath);
			}

			if ( canonicalPath == null || canonicalPath.startsWith("/EDISON") == false )
			{
				LOG.error("Attack Detection. Requested filePath : " + filePath);
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				if (currentUser.isAuthenticated())
					currentUser.logout();
				return;
			}
		}

		//byte[] contents = null;
		File inf = null;
		FileInputStream fis = null;
		try {
			//contents = repositoryService.read(item);
			 inf = new File(item.getPath());
			 fis = new FileInputStream(inf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return;
		}

		response.setContentType(item.getType());
		//response.setContentLength((int)inf.length()); //2G over file download error
		response.setHeader("Content-Length", Long.toString(inf.length()));
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ item.getName() + "\"");
		try {
			FileCopyUtils.copy(fis, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (currentUser.isAuthenticated())
				currentUser.logout();
		}
		return;

	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/file/{fileId}")
	public ResponseEntity<String> delete(
			@PathVariable String fileId,
			HttpServletRequest request, 
			HttpServletResponse response) {
		LOG.info("FileController::delete() called : " + fileId);
		Subject currentUser = SecurityUtils.getSubject();

		FileItem item = repositoryService.find(fileId);
		if (item == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}
		// security check, temporarily
		String filePath = item.getPath();
		String canonicalPath = null;
		File tmp = new File(filePath);
		try {
			canonicalPath = tmp.getCanonicalPath();
			if (canonicalPath == null) {
				LOG.error("Can't get canonicalPath : " + filePath);
				if (currentUser.isAuthenticated())
					currentUser.logout();
				return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
			}
			else {
				String clusterName = Cloud.getInstance().getProp("resources").split(":")[0];
				String baseDir = "/EDISON"; 
				List<Cluster> clusters = clusterService.getClusters();
			
				for(Cluster c : clusters){
					if(c.getName().equals(clusterName)){
						baseDir = c.getBaseDir();
						break;
					}
				}
				//String userHomeDir = baseDir + Cloud.getInstance().getProp("data.basedir").replace(".","") + "/" + currentUser.getPrincipal().toString();
				String userHomeDir = baseDir + userService.getUser(currentUser.getPrincipal().toString()).getStorageSource().replace(".", "");
				File homeDir = new File(userHomeDir);
				if(canonicalPath.startsWith(homeDir.getCanonicalPath()) == false) {
					LOG.error("Attack Detection. Requested filePath : " + filePath);
					if (currentUser.isAuthenticated())
						currentUser.logout();
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.UNAUTHORIZED);
				}
				repositoryService.delete(canonicalPath);
				return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.OK);			
			}
		} 
		catch (IOException e) {
			LOG.error("getCanonicalPath fail : " + filePath);
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/file/repository")
	public ResponseEntity<String> repository_usage(
			HttpServletRequest request, 
			HttpServletResponse response) {
		LOG.info("FileController::repository_usage() called");
		Subject currentUser = SecurityUtils.getSubject();

		String clusterName = Cloud.getInstance().getProp("resources").split(":")[0];
		String baseDir = "/home/edison"; 
		List<Cluster> clusters = clusterService.getClusters();
		
		for(Cluster c : clusters){
			if(c.getName().equals(clusterName)){
				baseDir = c.getBaseDir();
				break;
			}
		}
		
		String userHomeDir = baseDir + Cloud.getInstance().getProp("data.basedir").replace(".","") + "/" + currentUser.getPrincipal().toString();
		//File homeDir = new File(userHomeDir);
		
		//long sum = this.getFolderSize(homeDir);
		String result = null;
		try{
			Process p = Runtime.getRuntime().exec("du -s " + userHomeDir );
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			while((line = br.readLine()) != null){
				result = line;
			}
			result = result.split("\t")[0];
		}catch(Exception e){
			LOG.info(e);
		}
		
		return responseWriter(currentUser, result , new HttpHeaders(),
				HttpStatus.OK);
		
	}
	private long getFolderSize(File dir){
	    long size = 0;
	    try{
	    for (File file : dir.listFiles()) {
	        if (file.isFile()) {
	            size += file.length();
	        }
	        else{
	            size += getFolderSize(file);
	        }
	    }}
	    catch(NullPointerException e){
	    	return size;
	    }
	    return size;
	}
	/*
	 * @RequestMapping(method=RequestMethod.GET, value="/file/list",
	 * headers="Accept=application/json, application/xml") public
	 * ResponseEntity<FileItemList> getFiles() {
	 * LOG.info("FileController::getFiles() called : "); Subject currentUser =
	 * SecurityUtils.getSubject();
	 * 
	 * try { List<FileItem> items = repositoryService.getFiles("/root"); if(
	 * items == null ) { return responseWriter(currentUser, null, new
	 * HttpHeaders(), HttpStatus.BAD_REQUEST); }
	 * 
	 * FileItemList list = new FileItemList(items); return
	 * responseWriter(currentUser, list, new HttpHeaders(), HttpStatus.OK); }
	 * catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); return responseWriter(currentUser, null, new
	 * HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
}
