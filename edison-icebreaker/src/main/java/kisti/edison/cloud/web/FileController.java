/**
 * 
 */
package kisti.edison.cloud.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Disk;
import kisti.edison.cloud.model.FileDirList;
import kisti.edison.cloud.model.FileItem;
import kisti.edison.cloud.model.FileItemList;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.service.ClusterService;
import kisti.edison.cloud.service.RepositoryService;
import kisti.edison.cloud.service.UserService;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.spi.RepositorySelector;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.codec.binary.Base64;

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


		//		String userHomeDir = "/EDISON/" + Cloud.getInstance().getProp("data.basedir") + "/" + currentUser.getPrincipal().toString() + "/repository/";

		fileName = fileName.replaceAll("\\p{Space}", "_");

		FileItem fileItem = new FileItem();
		fileItem.setName(fileName);
		fileItem.setSize(file.getSize());
		fileItem.setType(file.getContentType());
		fileItem.setDescription(description);


		try {
			if ( fileItem.getSize() > 1073741824 ) {
				LOG.debug("large file upload testing : " + file.getName());
				repositoryService.createLargeFile(c, user, file, fileItem, file.getSize());
			} else {
				repositoryService.create(c, user, file.getBytes(), fileItem);
			}

			//			LOG.info("CREATE AFTER FILE ID : " + fileItem.getId());
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

	/*original function
	 * @RequestMapping(method = RequestMethod.POST, value = "/file/write", headers = "Accept=application/json, application/xml")
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
	 */
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

		FileItem item = null;
		try {
			item = repositoryService.find(URLDecoder.decode(fileId, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			LOG.error("Encoding Error : " + fileId );
			item = repositoryService.find(fileId);
		}
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
				//				String clusterName = Cloud.getInstance().getProp("resources").split(":")[0];
				//				String baseDir = "/EDISON"; 
				//				List<Cluster> clusters = clusterService.getClusters();
				//			
				//				for(Cluster c : clusters){
				//					if(c.getName().equals(clusterName)){
				//						baseDir = c.getBaseDir();
				//						break;
				//					}
				//				}
				//String userHomeDir = baseDir + Cloud.getInstance().getProp("data.basedir").replace(".","") + "/" + currentUser.getPrincipal().toString();
				//				String userHomeDir = baseDir + userService.getUser(currentUser.getPrincipal().toString()).getStorageSource().replace(".", "");

				User user = userService.getUser(currentUser.getPrincipal().toString());
				String userHomeDir = "/EDISON/" + user.getStorageSource() + "repository/";
				File homeDir = new File(userHomeDir);
				if(canonicalPath.startsWith(homeDir.getCanonicalPath()) == false) {
					LOG.error("Attack Detection. Requested filePath : " + filePath);
					if (currentUser.isAuthenticated())
						currentUser.logout();
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.UNAUTHORIZED);
				}

				repositoryService.delete(canonicalPath);
				repositoryService.delete(filePath);
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

		//		String clusterName = Cloud.getInstance().getProp("resources").split(":")[0];
		//		String baseDir = "/home/edison"; 
		//		List<Cluster> clusters = clusterService.getClusters();
		//		
		//		for(Cluster c : clusters){
		//			if(c.getName().equals(clusterName)){
		//				baseDir = c.getBaseDir();
		//				break;
		//			}
		//		}
		//		
		//		String userHomeDir = baseDir + Cloud.getInstance().getProp("data.basedir").replace(".","") + "/" + currentUser.getPrincipal().toString();
		//		//File homeDir = new File(userHomeDir);
		//		
		//		//long sum = this.getFolderSize(homeDir);
		String result = null;

		List<String> cmd = new ArrayList<String>();
		//		cmd.add("du");
		//		cmd.add("-s");
		//		cmd.add(userHomeDir);
		cmd.add("ssh");
		cmd.add("-TTT");
		cmd.add("quota@ssd");
		cmd.add(currentUser.getPrincipal().toString());

		//		LOG.info("ssh cmd: " + cmd.toString());

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		CommandLine cmdLine = CommandLine.parse(cmd.get(0));
		for (int i=1, n=cmd.size() ; i<n ; i++ ) {
			cmdLine.addArgument(cmd.get(i));
		}
		int exitValue = -1;
		try {
			exitValue = executor.execute(cmdLine);
		} catch (ExecuteException e) {
			LOG.error("Get quota command fail");
			LOG.error("ssh cmd: " + cmd.toString());
		} catch (IOException e) {
			LOG.error("Get quota command fail, IOException");
		}

		if ( exitValue == -1 || exitValue != 0 ) result = "-1";
		else {
			result = outputStream.toString();
			result = result.split(":")[0];
		}

		return responseWriter(currentUser, result , new HttpHeaders(),
				HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/file/repository/{userId}")
	public ResponseEntity<String> repository_usage2(
			@PathVariable String userId,
			HttpServletResponse response) {
		LOG.info("FileController::repository_usage2() called");

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

		String result = null;

		List<String> cmd = new ArrayList<String>();
		cmd.add("ssh");
		cmd.add("-TTT");
		cmd.add("quota@ssd");
		cmd.add(userId);

		//		LOG.info("ssh cmd: " + cmd.toString());

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		CommandLine cmdLine = CommandLine.parse(cmd.get(0));
		for (int i=1, n=cmd.size() ; i<n ; i++ ) {
			cmdLine.addArgument(cmd.get(i));
		}
		int exitValue = -1;
		try {
			exitValue = executor.execute(cmdLine);
		} catch (ExecuteException e) {
			LOG.error("Get quota command fail");
			LOG.error("ssh cmd: " + cmd.toString());
		} catch (IOException e) {
			LOG.error("Get quota command fail, IOException");
		}

		if ( exitValue == -1 || exitValue != 0 ) result = "-1";
		else {
			result = outputStream.toString();
			result = result.split(":")[0];
		}

		return responseWriter(currentUser, result , new HttpHeaders(),
				HttpStatus.OK);

	}

	//	private long getFolderSize(File dir){
	//	    long size = 0;
	//	    try{
	//	    for (File file : dir.listFiles()) {
	//	        if (file.isFile()) {
	//	            size += file.length();
	//	        }
	//	        else{
	//	            size += getFolderSize(file);
	//	        }
	//	    }}
	//	    catch(NullPointerException e){
	//	    	return size;
	//	    }
	//	    return size;
	//	}
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

	@RequestMapping(method=RequestMethod.GET, value="/file/list", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItemList> getFiles(@RequestParam(value="userId", required=false) String userId, 
			@RequestParam(value="startIndex", required=false) String startIndex, @RequestParam(value="maxResults", required=false) String maxResults, @RequestParam(value="field", required=false) 
	String field, @RequestParam(value="sort", required=false) String sort, HttpServletRequest request)
	{
		this.LOG.info("================================getFilesLists()============================================");
		Subject currentUser = SecurityUtils.getSubject();
		//	    String queryUserId = null;


		User user = userService.getUser(currentUser.getPrincipal().toString());
		String userHomeDir = "/EDISON/" + user.getStorageSource() + "repository/";

		//	    String user = currentUser.toString();
		//	    String userHomeDir = cluster.getBaseDir() + Cloud.getInstance().getProp("data.basedir") + "/"
		//				+ userId + "/"
		//				+ Cloud.getInstance().getProp("user.repositorypath") + "/";

		//	    if ((userId != null) && (!userId.isEmpty())) {
		//	      queryUserId = userId;
		//	    }

		//	    String mField = null;
		//	    String mSort = null;
		//
		//	    if ((field == null) || (field.isEmpty()))
		//	      mField = "lastModified";
		//	    else {
		//	      mField = field;
		//	    }
		//
		//	    if ((sort == null) || (sort.isEmpty()))
		//	      mSort = "desc";
		//	    else {
		//	      mSort = sort;
		//	    }


		List<FileItem> files = null;
		try {
			files = this.repositoryService.getFiles(userHomeDir);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		FileItemList list = new FileItemList(files);

		//this.LOG.info("Files detail info : " + files + "\n");

		return responseWriter(currentUser, list, new HttpHeaders(), 
				HttpStatus.OK);  
	}


	@RequestMapping(method=RequestMethod.GET, value="/file/all", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileDirList> getAllFiles(@RequestParam(value="userId", required=false) String userId, 
			@RequestParam(value="startIndex", required=false) String startIndex, @RequestParam(value="maxResults", required=false) String maxResults, @RequestParam(value="field", required=false) 
	String field, @RequestParam(value="sort", required=false) String sort, HttpServletRequest request)
	{
		this.LOG.info("================================getFilesLists()============================================");
		Subject currentUser = SecurityUtils.getSubject();
		//	    String queryUserId = null;


		User user = userService.getUser(currentUser.getPrincipal().toString());
		String userHomeDir = "/EDISON/" + user.getStorageSource() + "repository/";

		List<FileItem> files = null;
		List<FileItem> dirs = null;
		try {
			files = this.repositoryService.getFiles(userHomeDir);
			dirs = this.repositoryService.getFolders(userHomeDir);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		FileItemList list = new FileItemList(files);
		FileItemList dirList = new FileItemList(dirs);
		HashMap<String, FileItemList> fdlist = new HashMap<String, FileItemList>();
		fdlist.put("files",  list);
		fdlist.put("folders", dirList);
		FileDirList alllist = new FileDirList(fdlist);

		return responseWriter(currentUser, alllist, new HttpHeaders(), 
				HttpStatus.OK);  
	}


	@RequestMapping(method=RequestMethod.GET, value="/file/{folderId}/list", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItemList> InFileList(@PathVariable String folderId, HttpServletRequest request, HttpServletResponse response) throws IOException
	{	
		LOG.info("folder ID :" + folderId);
		FileItem item = this.repositoryService.findFolder(folderId);
		LOG.info("FOLDER INFO ITEM:" + item);
		String FolderInfo = item.toString();
		String FolderPath = item.getPath();

		Subject currentUser = SecurityUtils.getSubject();
		if (FolderInfo == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		List<FileItem> files = null;
		try {
			files = this.repositoryService.getFiles(FolderPath);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		FileItemList list = new FileItemList(files);

		//this.LOG.info("List of Files within a Folder : " + files + "\n");
		return responseWriter(currentUser, list, new HttpHeaders(), 
				HttpStatus.OK);

	}

	@RequestMapping(method=RequestMethod.GET, value="/file/{folderId}/all", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileDirList> InAllFileList(@PathVariable String folderId, HttpServletRequest request, HttpServletResponse response) throws IOException
	{	
		LOG.info("folder ID :" + folderId);
		FileItem item = this.repositoryService.findFolder(folderId);
		LOG.info("FOLDER INFO ITEM:" + item);
		String FolderInfo = item.toString();
		String FolderPath = item.getPath();

		Subject currentUser = SecurityUtils.getSubject();
		if (FolderInfo == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		List<FileItem> files = null;
		List<FileItem> dirs = null;
		try {
			files = this.repositoryService.getFiles(FolderPath);
			dirs = this.repositoryService.getFolders(FolderPath);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		FileItemList list = new FileItemList(files);
		FileItemList dirList = new FileItemList(dirs);
		HashMap<String, FileItemList> fdlist = new HashMap<String, FileItemList>();
		fdlist.put("files",  list);
		fdlist.put("folders", dirList);
		FileDirList alllist = new FileDirList(fdlist);

		//this.LOG.info("List of Files within a Folder : " + files + "\n");
		return responseWriter(currentUser, alllist, new HttpHeaders(), 
				HttpStatus.OK);

	}

	@RequestMapping(method= RequestMethod.GET, value="/file/{fileId}", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItem> Fileinfo(@PathVariable String fileId, HttpServletRequest request, HttpServletResponse response)
	{
		/*		String[] split = fileId.split("/");  
		String str1 = split[0];
		String str2 = split[1];
		String fid = str1 + str2;
		LOG.info("FILE ID SPLIT and SUM File ID : " + fid);
		FileItem item = this.repositoryService.find(fid);*/

		FileItem item = this.repositoryService.find(fileId);

		this.LOG.info("FILE INFO ITEM:" + item);
		String FileInfo = item.toString();

		Subject currentUser = SecurityUtils.getSubject();
		if (FileInfo == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		return responseWriter(currentUser, item, new HttpHeaders(), 
				HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/file/move/", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItem> moveFile(@PathVariable String fileId, @PathVariable String destPath, HttpServletRequest request, HttpServletResponse response) throws IOException
	{this.LOG.info("Folder Controller::MOVE_File() called : " + fileId);
	Subject currentUser = SecurityUtils.getSubject();

	User user = this.userService.getUser(currentUser.getPrincipal().toString());
	if (user == null) {
		return responseWriter(currentUser, null, new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
	}

	//	    if ((dest == null) || (dest.isEmpty())) {
	//	      return responseWriter(currentUser, null, new HttpHeaders(), 
	//	        HttpStatus.BAD_REQUEST);
	//	    }

	FileItem item = repositoryService.findFolder(fileId);
	if (item == null) {
		if (currentUser.isAuthenticated())
			currentUser.logout();
		return responseWriter(currentUser, item, new HttpHeaders(), 
				HttpStatus.NOT_FOUND);
	}
	String filePath = item.getPath();
	String canonicalPath = null;

	File src = new File(filePath);

	try {
		canonicalPath = src.getCanonicalPath();
		if (canonicalPath == null) {
			LOG.error("Can't get canonicalPath : " + filePath);
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, item, new HttpHeaders(), 
					HttpStatus.UNAUTHORIZED);
		}
	}
	catch (IOException e)
	{
		LOG.error("getCanonicalPath fail : " + filePath);
		if (currentUser.isAuthenticated())
			currentUser.logout(); 
	}

	File parentFile = src.getParentFile();
	destPath = parentFile.getParent();
	//	      File dest = new File(destPath);

	LOG.info("destPath = " + destPath);

	LOG.info("----MOVE BEFORE----");
	FileItem destName = new FileItem();

	repositoryService.moveFile(filePath, destPath, item);
	LOG.info("-----MOVE AFTER----");

	String NewdestPath = destPath + "/" + src.getName();
	destName = repositoryService.getFolder(NewdestPath);

	//	      destName.setPath(destPath);
	//	      destName.setId(item.getId());
	//	      destName.setParentPath(dest.getParent());
	//	      destName.setName(item.getName());
	//	      destName.setSize(item.getSize());
	//	      
	//	      destName.setLastModified(item.getLastModified());
	destName.setType("file");
	destName.setDescription("moved File");

	return responseWriter(currentUser, destName, new HttpHeaders(), 
			HttpStatus.OK); 

	}


	@RequestMapping(method=RequestMethod.POST, value="/file/move", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItem> moveInputFile(@RequestBody Map<String,String> map, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		this.LOG.info("Folder Controller::MOVE_File() called : " );
		String fileId = map.get("fileId");
		String destPath = map.get("destPath");

		Subject currentUser = SecurityUtils.getSubject(); 

		User user = this.userService.getUser(currentUser.getPrincipal().toString());

		if (user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}

		//	    if ((dest == null) || (dest.isEmpty())) {
		//	      return responseWriter(currentUser, null, new HttpHeaders(), 
		//	        HttpStatus.BAD_REQUEST);
		//	    }

		FileItem item = repositoryService.find(fileId);
		if (item == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, item, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		String filePath = item.getPath();
		String canonicalPath = null;

		File src = new File(filePath);

		try {
			canonicalPath = src.getCanonicalPath();
			if (canonicalPath == null) {
				LOG.error("Can't get canonicalPath : " + filePath);
				if (currentUser.isAuthenticated())
					currentUser.logout();
				return responseWriter(currentUser, item, new HttpHeaders(), 
						HttpStatus.UNAUTHORIZED);
			}
		}
		catch (IOException e)
		{
			LOG.error("getCanonicalPath fail : " + filePath);
			if (currentUser.isAuthenticated())
				currentUser.logout(); 
		}


		File dest = new File(destPath);

		LOG.info("destPath = " + destPath);

		LOG.info("----MOVE BEFORE----");
		FileItem destName = new FileItem();

		repositoryService.moveInputFile(filePath, destPath);
		LOG.info("-----MOVE AFTER----");

		destName = repositoryService.getFile(destPath);
		destName.setPath(destPath);
		destName.setId(destName.getId());
		destName.setParentPath(dest.getParent());
		destName.setName(dest.getName());
		destName.setSize(destName.getSize());
		destName.setLastModified(destName.getLastModified());
		destName.setType("file");
		destName.setDescription("moved File");

		return responseWriter(currentUser, destName, new HttpHeaders(), 
				HttpStatus.OK); 

	}

	@RequestMapping(method=RequestMethod.PUT, value="/file/update/{fileId}", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItem> update(@PathVariable String fileId, @RequestBody Map<String,String> map, HttpServletRequest request, HttpServletResponse response) throws IOException
	{this.LOG.info("Folder Controller::Update_File() called : " + fileId);
	Subject currentUser = SecurityUtils.getSubject();

	User user = this.userService.getUser(currentUser.getPrincipal().toString());
	if (user == null) {
		return responseWriter(currentUser, null, new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
	}

	//	    if ((dest == null) || (dest.isEmpty())) {
	//	      return responseWriter(currentUser, null, new HttpHeaders(), 
	//	        HttpStatus.BAD_REQUEST);
	//	    }

	String destPath = map.get("destPath");

	FileItem item = repositoryService.find(fileId);
	if (item == null) {
		if (currentUser.isAuthenticated())
			currentUser.logout();
		return responseWriter(currentUser, item, new HttpHeaders(), 
				HttpStatus.NOT_FOUND);
	}
	String filePath = item.getPath();
	String canonicalPath = null;

	File src = new File(filePath);

	try {
		canonicalPath = src.getCanonicalPath();
		if (canonicalPath == null) {
			LOG.error("Can't get canonicalPath : " + filePath);
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, item, new HttpHeaders(), 
					HttpStatus.UNAUTHORIZED);
		}
	}
	catch (IOException e)
	{
		LOG.error("getCanonicalPath fail : " + filePath);
		if (currentUser.isAuthenticated())
			currentUser.logout(); 
	}


	//	      File dest = new File(destPath);

	LOG.info("destPath = " + destPath);

	LOG.info("----MOVE BEFORE----");
	FileItem destName = new FileItem();

	repositoryService.updateFile(filePath, destPath, item);
	LOG.info("-----MOVE AFTER----");


	destName = repositoryService.getFile(destPath);

	//	      destName.setPath(destPath);
	//	      destName.setId(item.getId());
	//	      destName.setParentPath(dest.getParent());
	//	      destName.setName(item.getName());
	//	      destName.setSize(item.getSize());
	//	      
	//	      destName.setLastModified(item.getLastModified());
	destName.setType("file");
	destName.setDescription("update File");

	return responseWriter(currentUser, destName, new HttpHeaders(), 
			HttpStatus.OK); 

	}

	@RequestMapping(method=RequestMethod.PUT, value="/file/move/{fileId}/{destfolderId}", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItem> moveTargetFile(@PathVariable String fileId, @PathVariable String destfolderId, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		this.LOG.info("Folder Controller::MOVE_Target Folder() called : " + fileId);
		Subject currentUser = SecurityUtils.getSubject();

		User user = this.userService.getUser(currentUser.getPrincipal().toString());
		if (user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}

		FileItem item = repositoryService.findFolder(fileId);
		FileItem destItem = repositoryService.findFolder(destfolderId);

		LOG.info("DESTNATION PATH : " + destItem.getPath());
		if (item == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, item, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		String filePath = item.getPath();
		String canonicalPath = null;
		String destPath = destItem.getPath();
		File src = new File(filePath);

		try {
			canonicalPath = src.getCanonicalPath();
			if (canonicalPath == null) {
				LOG.error("Can't get canonicalPath : " + filePath);
				if (currentUser.isAuthenticated())
					currentUser.logout();
				return responseWriter(currentUser, item, new HttpHeaders(), 
						HttpStatus.UNAUTHORIZED);
			}
		}
		catch (IOException e)
		{
			LOG.error("getCanonicalPath fail : " + filePath);
			if (currentUser.isAuthenticated())
				currentUser.logout();
		}   

		File destFile = new File(destPath); 

		LOG.info("destPath = " + destPath);	           
		LOG.info("----MOVE BEFORE----");

		//repositoryService.movetargetFile(folderPath, destPath, item);

		FileUtils.moveFileToDirectory(src, destFile, true);
		LOG.info("-----MOVE AFTER----");

		String NewdestPath = destPath + "/" + src.getName();

		FileItem destName = new FileItem();
		//	      File fDestFile = new File(NewdestPath);


		destName = repositoryService.getFile(NewdestPath);

		LOG.info("MOVED FOLDER ID :" + destName.getId());
		LOG.info("FINAL DEST PATH : " + destName.getPath());

		//	      destName.setPath(destName.getPath());
		//	      destName.setId(destName.getId());
		//	      destName.setName(fDestFile.getName());
		//	      destName.setSize(destName.getSize());
		//	      destName.setLastModified(destName.getLastModified());
		destName.setType("File");
		destName.setDescription("moved File");

		return responseWriter(currentUser, destName, new HttpHeaders(), 
				HttpStatus.OK);   
	}
	@RequestMapping(method=RequestMethod.POST, value="/file/copy", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItem> copyInputFile(@RequestBody Map<String,String> map, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		this.LOG.info("File Controller::copy_File() called : " );
		String fileId = map.get("fileId");
		String destPath = map.get("destPath");

		Subject currentUser = SecurityUtils.getSubject(); 

		User user = this.userService.getUser(currentUser.getPrincipal().toString());

		if (user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}

		//	    if ((dest == null) || (dest.isEmpty())) {
		//	      return responseWriter(currentUser, null, new HttpHeaders(), 
		//	        HttpStatus.BAD_REQUEST);
		//	    }

		FileItem item = repositoryService.find(fileId);
		if (item == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, item, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		String filePath = item.getPath();
		String canonicalPath = null;

		File src = new File(filePath);

		try {
			canonicalPath = src.getCanonicalPath();
			if (canonicalPath == null) {
				LOG.error("Can't get canonicalPath : " + filePath);
				if (currentUser.isAuthenticated())
					currentUser.logout();
				return responseWriter(currentUser, item, new HttpHeaders(), 
						HttpStatus.UNAUTHORIZED);
			}
		}
		catch (IOException e)
		{
			LOG.error("getCanonicalPath fail : " + filePath);
			if (currentUser.isAuthenticated())
				currentUser.logout(); 
		}


		File dest = new File(destPath);

		LOG.info("destPath = " + destPath);

		LOG.info("----MOVE BEFORE----");
		FileItem destName = new FileItem();

		repositoryService.copyInputFile(filePath, destPath);
		LOG.info("-----MOVE AFTER----");

		destName = repositoryService.getFile(destPath);
		destName.setPath(destPath);
		destName.setId(destName.getId());
		destName.setParentPath(dest.getParent());
		destName.setName(dest.getName());
		destName.setSize(destName.getSize());
		destName.setLastModified(destName.getLastModified());
		destName.setType("file");
		destName.setDescription("copied File");

		return responseWriter(currentUser, destName, new HttpHeaders(), 
				HttpStatus.OK); 

	}

	@RequestMapping(method=RequestMethod.PUT, value="/file/copy/{fileId}/{destfolderId}", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItem> copyFile(@PathVariable String fileId, @PathVariable String destfolderId, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		this.LOG.info("Folder Controller::COPY_Target Folder() called : " + fileId);
		Subject currentUser = SecurityUtils.getSubject();

		User user = this.userService.getUser(currentUser.getPrincipal().toString());
		if (user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}

		FileItem item = repositoryService.findFolder(fileId);
		FileItem destItem = repositoryService.findFolder(destfolderId);

		LOG.info("DESTNATION PATH : " + destItem.getPath());
		if (item == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, item, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		String filePath = item.getPath();
		String canonicalPath = null;
		String destPath = destItem.getPath();
		File src = new File(filePath);

		try {
			canonicalPath = src.getCanonicalPath();
			if (canonicalPath == null) {
				LOG.error("Can't get canonicalPath : " + filePath);
				if (currentUser.isAuthenticated())
					currentUser.logout();
				return responseWriter(currentUser, item, new HttpHeaders(), 
						HttpStatus.UNAUTHORIZED);
			}
		}
		catch (IOException e)
		{
			LOG.error("getCanonicalPath fail : " + filePath);
			if (currentUser.isAuthenticated())
				currentUser.logout();
		}   

		File destFile = new File(destPath); 

		LOG.info("destPath = " + destPath);	           
		LOG.info("----COPY BEFORE----");


		FileUtils.copyFileToDirectory(src, destFile, true);
		LOG.info("-----COPY AFTER----");

		String NewdestPath = destPath + "/" + src.getName();

		FileItem destName = new FileItem();
		//	      File fDestFile = new File(NewdestPath);


		destName = repositoryService.getFile(NewdestPath);

		LOG.info("COPY FILE ID :" + destName.getId());
		LOG.info("FINAL DEST PATH : " + destName.getPath());

		destName.setType("File");
		destName.setDescription("copied File");

		return responseWriter(currentUser, destName, new HttpHeaders(), 
				HttpStatus.OK);   
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/file/delete/{fileId}", headers="Accept=application/json, application/xml")
	public ResponseEntity<File> deleteFile(@PathVariable String fileId, HttpServletRequest request, HttpServletResponse response)
	{
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
				//					String clusterName = Cloud.getInstance().getProp("resources").split(":")[0];
				//					String baseDir = "/EDISON"; 
				//					List<Cluster> clusters = clusterService.getClusters();
				//				
				//					for(Cluster c : clusters){
				//						if(c.getName().equals(clusterName)){
				//							baseDir = c.getBaseDir();
				//							break;
				//						}
				//					}
				//String userHomeDir = baseDir + Cloud.getInstance().getProp("data.basedir").replace(".","") + "/" + currentUser.getPrincipal().toString();
				//					String userHomeDir = baseDir + userService.getUser(currentUser.getPrincipal().toString()).getStorageSource().replace(".", "");

				User user = userService.getUser(currentUser.getPrincipal().toString());
				String userHomeDir = "/EDISON/" + user.getStorageSource() + "repository/";
				File homeDir = new File(userHomeDir);
				if(canonicalPath.startsWith(homeDir.getCanonicalPath()) == false) {
					LOG.error("Attack Detection. Requested filePath : " + filePath);
					if (currentUser.isAuthenticated())
						currentUser.logout();
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.UNAUTHORIZED);
				}

				repositoryService.delete(canonicalPath);
				repositoryService.delete(filePath);
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

	// 현재폴더의 이름을 변경한다.
	@RequestMapping(method=RequestMethod.PUT, value="/file/{fileId}/{dest}", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItem> renameFile(@PathVariable String fileId, @PathVariable String dest, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		this.LOG.info("Folder Controller::Rename_Folder() called : " + fileId);
		Subject currentUser = SecurityUtils.getSubject();

		User user = this.userService.getUser(currentUser.getPrincipal().toString());
		if (user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}

		if ((dest == null) || (dest.isEmpty())) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}

		FileItem item = repositoryService.findFolder(fileId);
		if (item == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, item, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		String filePath = item.getPath();
		String canonicalPath = null;
		String destPath = null;
		File src = new File(filePath);

		try {
			canonicalPath = src.getCanonicalPath();
			if (canonicalPath == null) {
				LOG.error("Can't get canonicalPath : " + filePath);
				if (currentUser.isAuthenticated())
					currentUser.logout();
				return responseWriter(currentUser, item, new HttpHeaders(), 
						HttpStatus.UNAUTHORIZED);
			}
		}
		catch (IOException e)
		{
			LOG.error("getCanonicalPath fail : " + filePath);
			if (currentUser.isAuthenticated())
				currentUser.logout(); 
		}

		File parentFile = new File(filePath);
		String parent = parentFile.getParent();

		//String userHomeDir = "/EDISON" + Cloud.getInstance().getProp("data.basedir").replace(".", "") + "/" + currentUser.getPrincipal().toString() + "/repository" + "/";
		destPath = parent  + "/" + dest;

		//	      File destFile = new File(destPath);
		//	      FileItem destName = new FileItem();
		//	      destName.setPath(destPath);
		//	      destName.setId(item.getId());
		//	      destName.setParentPath(item.getParentPath());
		//	      destName.setName(dest);
		//	      destName.setType("folder");
		//	      destName.setLastModified(item.getLastModified());
		FileItem destName = new FileItem();
		repositoryService.renameFile(filePath, destPath, currentUser.toString());

		destName.setPath(destPath);
		destName.setId(item.getId());
		destName.setParentPath(item.getParentPath());
		destName.setName(dest);
		destName.setSize(item.getSize());
		destName.setType("folder");
		destName.setLastModified(item.getLastModified());
		destName.setDescription("renamed FILE");

		return responseWriter(currentUser, destName, new HttpHeaders(), 
				HttpStatus.OK);

	}

	@RequestMapping(method=RequestMethod.POST, value="/folder/create", headers="Accept=application/json, application/xml")
	@ResponseBody
	public ResponseEntity<FileItem> createFolder(@RequestParam(value="name", required=true) String name, @RequestParam(value="description", required=false) String description, @RequestParam(value="cluster", required=true) String clusterName, @RequestBody String content, HttpServletRequest request)
			throws IOException{
		LOG.info("FileController::CREATE FOLDER() called");
		Subject currentUser = SecurityUtils.getSubject();

		if ((clusterName == null) || (clusterName.isEmpty())) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}
		Cluster c = this.clusterService.findCluster(clusterName);
		if (c == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}

		User user = this.userService.getUser(currentUser.getPrincipal().toString());
		if (user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}

		if ((name == null) || (name.isEmpty())) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}

		String fileName = name.replaceAll("\\p{Space}", "_");
		String userHomeDir = "/EDISON/" + user.getStorageSource() + "repository/";

		FileItem fileItem = new FileItem();
		fileItem.setName(fileName);
		fileItem.setType("folder");
		fileItem.setSize(Long.valueOf(content.length()));
		fileItem.setDescription(description);
		fileItem.setPath(userHomeDir + fileName);	      
		fileItem.setId("");  


		repositoryService.folderCreate(c, user, content.getBytes(), fileItem);
		String Folderid = fileItem.getId();
		LOG.info("FILEITEM ID : === " + Folderid);
		fileItem.setId(Folderid);

		return responseWriter(currentUser, fileItem, new HttpHeaders(), 
				HttpStatus.CREATED); 
	}

	@RequestMapping(method=RequestMethod.GET, value="/folder/list", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItemList> getFolders(@RequestParam(value="userId", required=false) String userId, @RequestParam(value="startIndex", required=false) String startIndex, @RequestParam(value="maxResults", required=false) String maxResults, @RequestParam(value="field", required=false) String field, @RequestParam(value="sort", required=false) String sort, HttpServletRequest request)
	{
		this.LOG.info("================================getFoldersLists()============================================");
		Subject currentUser = SecurityUtils.getSubject();
		//	    String queryUserId = null;
		User user = userService.getUser(currentUser.getPrincipal().toString());
		String userHomeDir = "/EDISON/" + user.getStorageSource() + "repository/";

		//	    String user = currentUser.toString();
		//	    String userHomeDir = "/EDISON" + Cloud.getInstance().getProp("data.basedir").replace(".", "") + "/" + currentUser.getPrincipal().toString() + "/repository";




		//	    if ((userId != null) && (!userId.isEmpty())) {
		//	      queryUserId = userId;
		//	    }

		//	    String mField = null;
		//	    String mSort = null;
		//
		//	    if ((field == null) || (field.isEmpty()))
		//	      mField = "lastModified";
		//	    else {
		//	      mField = field;
		//	    }
		//
		//	    if ((sort == null) || (sort.isEmpty()))
		//	      mSort = "desc";
		//	    else {
		//	      mSort = sort;
		//	    }


		List<FileItem> files = null;
		try {
			files = this.repositoryService.getFolders(userHomeDir);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		FileItemList list = new FileItemList(files);

		this.LOG.info("Folders detail info : " + files + "\n");
		return responseWriter(currentUser, list, new HttpHeaders(), 
				HttpStatus.OK);
	}


	@RequestMapping(method={RequestMethod.GET,RequestMethod.PUT}, value="/folder/{folderId}", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItem> Folderinfo(@PathVariable String folderId, HttpServletRequest request, HttpServletResponse response) throws IOException
	{	   
		FileItem item = this.repositoryService.find(folderId);

		this.LOG.info("FOLDER INFO ITEM:" + item);
		String FolderInfo = item.toString();		    
		Subject currentUser = SecurityUtils.getSubject();
		if (FolderInfo == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		return responseWriter(currentUser, item, new HttpHeaders(), 
				HttpStatus.OK);
	}

	@RequestMapping(method={RequestMethod.GET,RequestMethod.PUT}, value="/folder/{folderId}/list", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItemList> InFolderList(@PathVariable String folderId, HttpServletRequest request, HttpServletResponse response) throws IOException
	{	
		LOG.info("folder ID :" + folderId);
		FileItem item = this.repositoryService.findFolder(folderId);
		this.LOG.info("FOLDER INFO ITEM:" + item);
		String FolderInfo = item.toString();
		String FolderPath = item.getPath();

		Subject currentUser = SecurityUtils.getSubject();
		if (FolderInfo == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		List<FileItem> files = null;
		try {
			files = this.repositoryService.getFolders(FolderPath);
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		FileItemList list = new FileItemList(files);

		this.LOG.info("Folders detail info : " + files + "\n");
		return responseWriter(currentUser, list, new HttpHeaders(), 
				HttpStatus.OK);

	}

	@RequestMapping(method=RequestMethod.DELETE, value="/folder/delete/{folderId}", headers="Accept=application/json, application/xml")
	public ResponseEntity<File> deleteFolder(@PathVariable String folderId, HttpServletRequest request, HttpServletResponse response)
	{
		this.LOG.info("Folder Controller::deleteFolder() called : " + folderId);
		Subject currentUser = SecurityUtils.getSubject();

		FileItem item = this.repositoryService.findFolder(folderId);

		if (item == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		File homeDir;

		LOG.info(" DELETE for USER ");
				String folderPath = item.getPath();
				String canonicalPath = null;
				File tmp = new File(folderPath);
				File file = new File(folderPath);

				LOG.info("DELETE FOLDER INFO : FILE file " + file.getName());
				try {
					canonicalPath = tmp.getCanonicalPath();
					if (canonicalPath == null) {
						this.LOG.error("Can't get canonicalPath : " + folderPath);
						if (currentUser.isAuthenticated())
							currentUser.logout();
						return responseWriter(currentUser, null, new HttpHeaders(), 
								HttpStatus.UNAUTHORIZED);
					}

					//	        String clusterName = Cloud.getInstance().getProp("resources").split(":")[0];
					//	        String baseDir = "/EDISON";
					//	        List<Cluster> clusters = this.clusterService.getClusters();
					//
					//	        for (Cluster c : clusters) {
					//	          if (c.getName().equals(clusterName)) {
					//	            baseDir = c.getBaseDir();
					//	            break;
					//	          }
					//	        }
					//	        String userHomeDir = baseDir + Cloud.getInstance().getProp("data.basedir").replace(".", "") + "/" + currentUser.getPrincipal().toString();
					User user = userService.getUser(currentUser.getPrincipal().toString());
					String userHomeDir = "/EDISON/" + user.getStorageSource() + "repository/";

					homeDir = new File(userHomeDir);
					LOG.info("home Dir INFO :" + homeDir);
					folderPath = file.getCanonicalPath();
					if (!canonicalPath.startsWith(((File)homeDir).getCanonicalPath())) {
						this.LOG.error("Attack Detection. Requested filePath : " + folderPath);
						if (currentUser.isAuthenticated())
							currentUser.logout();
						return responseWriter(currentUser, null, new HttpHeaders(), 
								HttpStatus.UNAUTHORIZED);
					}
					LOG.info("DELETING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					this.repositoryService.deleteFolder(file);
					//this.repositoryService.delete(folderPath);
					return responseWriter(currentUser, file, new HttpHeaders(), 
							HttpStatus.OK);
				}
				catch (IOException e)
				{
					this.LOG.error("getCanonicalPath fail : " + folderPath);
					if (currentUser.isAuthenticated())
						currentUser.logout();
					return responseWriter(currentUser, null, new HttpHeaders(), 
							HttpStatus.NOT_FOUND);
				}

	}


	// 현재폴더를 이동한다.

	/*	  @RequestMapping(method=RequestMethod.PUT, value="/folder/{folderId}/{dest}", headers="Accept=application/json, application/xml")
	  public ResponseEntity<FileItem> moveDestFolder(@PathVariable String folderId, @PathVariable String dest, HttpServletRequest request, HttpServletResponse response) throws IOException
	  {
	    this.LOG.info("Folder Controller::Rename_Folder() called : " + folderId);
	    Subject currentUser = SecurityUtils.getSubject();

	    User user = this.userService.getUser(currentUser.getPrincipal().toString());
	    if (user == null) {
	      return responseWriter(currentUser, null, new HttpHeaders(), 
	        HttpStatus.BAD_REQUEST);
	    }

	    if ((dest == null) || (dest.isEmpty())) {
	      return responseWriter(currentUser, null, new HttpHeaders(), 
	        HttpStatus.BAD_REQUEST);
	    }

	    FileItem item = repositoryService.findFolder(folderId);
	    if (item == null) {
	      if (currentUser.isAuthenticated())
	        currentUser.logout();
	      return responseWriter(currentUser, item, new HttpHeaders(), 
	        HttpStatus.NOT_FOUND);
	    }
	    String folderPath = item.getPath();
	    String canonicalPath = null;
	    String destPath = null;
	    File src = new File(folderPath);

	    try {
	      canonicalPath = src.getCanonicalPath();
	      if (canonicalPath == null) {
	        LOG.error("Can't get canonicalPath : " + folderPath);
	        if (currentUser.isAuthenticated())
	          currentUser.logout();
	        return responseWriter(currentUser, item, new HttpHeaders(), 
	          HttpStatus.UNAUTHORIZED);
	      }
	    }
	      catch (IOException e)
		    {
		      LOG.error("getCanonicalPath fail : " + folderPath);
		      if (currentUser.isAuthenticated())
		        currentUser.logout(); 
		    }

	      File parentFile = new File(folderPath);
	      String parent = parentFile.getParent();

	      //String userHomeDir = "/EDISON" + Cloud.getInstance().getProp("data.basedir").replace(".", "") + "/" + currentUser.getPrincipal().toString() + "/repository" + "/";
	      destPath = parent  + "/" + dest;

//	      File destFile = new File(destPath);
//	      FileItem destName = new FileItem();
//	      destName.setPath(destPath);
//	      destName.setId(item.getId());
//	      destName.setParentPath(item.getParentPath());
//	      destName.setName(dest);
//	      destName.setType("folder");
//	      destName.setLastModified(item.getLastModified());
	      FileItem destName = new FileItem();
	      repositoryService.renameFolder(folderPath, destPath, item);

	      destName.setPath(destPath);
	      destName.setId(item.getId());
	      destName.setParentPath(item.getParentPath());
	      destName.setName(dest);
	      destName.setSize(item.getSize());
	      destName.setType("folder");
	      destName.setLastModified(item.getLastModified());
	      destName.setDescription("renamed Folder");

	      return responseWriter(currentUser, destName, new HttpHeaders(), 
			        HttpStatus.OK);

	  }*/


	// 현재폴더의 이름을 변경한다.
	@RequestMapping(method=RequestMethod.PUT, value="/folder/{folderId}/{dest}", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItem> renameFolder(@PathVariable String folderId, @PathVariable String dest, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		this.LOG.info("Folder Controller::Rename_Folder() called : " + folderId);
		Subject currentUser = SecurityUtils.getSubject();

		User user = this.userService.getUser(currentUser.getPrincipal().toString());
		if (user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}

		if ((dest == null) || (dest.isEmpty())) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}

		FileItem item = repositoryService.findFolder(folderId);
		if (item == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, item, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		String folderPath = item.getPath();
		String canonicalPath = null;
		String destPath = null;
		File src = new File(folderPath);

		try {
			canonicalPath = src.getCanonicalPath();
			if (canonicalPath == null) {
				LOG.error("Can't get canonicalPath : " + folderPath);
				if (currentUser.isAuthenticated())
					currentUser.logout();
				return responseWriter(currentUser, item, new HttpHeaders(), 
						HttpStatus.UNAUTHORIZED);
			}
		}
		catch (IOException e)
		{
			LOG.error("getCanonicalPath fail : " + folderPath);
			if (currentUser.isAuthenticated())
				currentUser.logout(); 
		}

		File parentFile = new File(folderPath);
		String parent = parentFile.getParent();

		//String userHomeDir = "/EDISON" + Cloud.getInstance().getProp("data.basedir").replace(".", "") + "/" + currentUser.getPrincipal().toString() + "/repository" + "/";
		destPath = parent  + "/" + dest;

		//	      File destFile = new File(destPath);
		//	      FileItem destName = new FileItem();
		//	      destName.setPath(destPath);
		//	      destName.setId(item.getId());
		//	      destName.setParentPath(item.getParentPath());
		//	      destName.setName(dest);
		//	      destName.setType("folder");
		//	      destName.setLastModified(item.getLastModified());
		FileItem destName = new FileItem();
		repositoryService.renameFolder(folderPath, destPath, item);

		destName.setPath(destPath);
		destName.setId(item.getId());
		destName.setParentPath(item.getParentPath());
		destName.setName(dest);
		destName.setSize(item.getSize());
		destName.setType("folder");
		destName.setLastModified(item.getLastModified());
		destName.setDescription("renamed Folder");

		return responseWriter(currentUser, destName, new HttpHeaders(), 
				HttpStatus.OK);

	}

	//현재폴더의 상위폴더로 이동

	@RequestMapping(method=RequestMethod.PUT, value="/folder/move/{folderId}", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItem> moveFolder(@PathVariable String folderId, HttpServletRequest request, HttpServletResponse response) throws IOException
	{this.LOG.info("Folder Controller::MOVE_Folder() called : " + folderId);
	Subject currentUser = SecurityUtils.getSubject();

	User user = this.userService.getUser(currentUser.getPrincipal().toString());
	if (user == null) {
		return responseWriter(currentUser, null, new HttpHeaders(), 
				HttpStatus.BAD_REQUEST);
	}

	FileItem item = repositoryService.findFolder(folderId);
	if (item == null) {
		if (currentUser.isAuthenticated())
			currentUser.logout();
		return responseWriter(currentUser, item, new HttpHeaders(), 
				HttpStatus.NOT_FOUND);
	}
	String folderPath = item.getPath();
	String canonicalPath = null;
	String destPath = null;
	File src = new File(folderPath);

	try {
		canonicalPath = src.getCanonicalPath();
		if (canonicalPath == null) {
			LOG.error("Can't get canonicalPath : " + folderPath);
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, item, new HttpHeaders(), 
					HttpStatus.UNAUTHORIZED);
		}
	}
	catch (IOException e)
	{
		LOG.error("getCanonicalPath fail : " + folderPath);
		if (currentUser.isAuthenticated())
			currentUser.logout(); 
	}

	File parentFile = src.getParentFile();
	destPath = parentFile.getParent();
	//	      File dest = new File(destPath);

	String NewdestPath = destPath + "/" + src.getName();
	FileItem destName = new FileItem();	      

	LOG.info("destPath = " + destPath);

	LOG.info("----MOVE BEFORE----");

	repositoryService.movetargetFile(folderPath, destPath, item);
	LOG.info("-----MOVE AFTER----");
	destName = repositoryService.getFolder(NewdestPath);

	//	      destName.setPath(destPath);
	//	      destName.setId(item.getId());
	//	      destName.setParentPath(dest.getParent());
	//	      destName.setName(item.getName());
	//	      destName.setSize(item.getSize());
	//	      destName.setLastModified(item.getLastModified());

	destName.setType("folder");
	destName.setDescription("moved Folder");

	return responseWriter(currentUser, destName, new HttpHeaders(), 
			HttpStatus.OK); 

	}

	/*
	   repository/folder의 하위로 이동
	   ex> repository/folder/test
	 */ 
	//	  @RequestMapping(method=RequestMethod.PUT, value="/folder/move/{folderId}/{dest}", headers="Accept=application/json, application/xml")
	//	  public ResponseEntity<FileItem> moveFolder(@PathVariable String folderId, @PathVariable String dest, HttpServletRequest request, HttpServletResponse response) throws IOException
	//	  {this.LOG.info("Folder Controller::MOVE_Target Folder() called : " + folderId);
	//	    Subject currentUser = SecurityUtils.getSubject();
	//
	//	    User user = this.userService.getUser(currentUser.getPrincipal().toString());
	//	    if (user == null) {
	//	      return responseWriter(currentUser, null, new HttpHeaders(), 
	//	        HttpStatus.BAD_REQUEST);
	//	    }
	//
	//	    FileItem item = repositoryService.findFolder(folderId);
	//	    if (item == null) {
	//	      if (currentUser.isAuthenticated())
	//	        currentUser.logout();
	//	      return responseWriter(currentUser, item, new HttpHeaders(), 
	//	        HttpStatus.NOT_FOUND);
	//	    }
	//	    String folderPath = item.getPath();
	//	    String canonicalPath = null;
	//	    String destPath = null;
	//	    File src = new File(folderPath);
	//	    
	//	    try {
	//	      canonicalPath = src.getCanonicalPath();
	//	      if (canonicalPath == null) {
	//	        LOG.error("Can't get canonicalPath : " + folderPath);
	//	        if (currentUser.isAuthenticated())
	//	          currentUser.logout();
	//	        return responseWriter(currentUser, item, new HttpHeaders(), 
	//	          HttpStatus.UNAUTHORIZED);
	//	      }
	//	    }
	//	      catch (IOException e)
	//		    {
	//		      LOG.error("getCanonicalPath fail : " + folderPath);
	//		      if (currentUser.isAuthenticated())
	//		        currentUser.logout(); 
	//		    }
	//	    
	//	      String userHomeDir = "/EDISON" + Cloud.getInstance().getProp("data.basedir").replace(".", "") + "/" + currentUser.getPrincipal().toString() + "/repository/";
	//	      
	//	      destPath = userHomeDir + dest;	      
	//	      File destFile = new File(destPath);
	//	      
	//	      LOG.info("destPath = " + destPath);
	//	           
	//	      LOG.info("----MOVE BEFORE----");
	//	      
	//	      FileItem destName = new FileItem();
	//	      
	//	      repositoryService.movetargetFile(folderPath, destPath, item);
	//	      LOG.info("-----MOVE AFTER----");
	//	      
	//	      //destName = repositoryService.findFolder(destPath);
	//	      	      
	//	      destName.setPath(destPath);
	//	      destName.setId(destName.getId());
	//	      destName.setParentPath(destFile.getParent());
	//	      destName.setName(destName.getName());
	//	      destName.setSize(destName.getSize());
	//	      destName.setType("folder");
	//	      destName.setLastModified(destName.getLastModified());
	//	      destName.setDescription("moved Folder");
	//	     
	//		  return responseWriter(currentUser, destName, new HttpHeaders(), 
	//			        HttpStatus.OK); 
	//		  
	//	  }

	//폴더 id를 이용해서 해당 dest폴더로 이동 

	@RequestMapping(method=RequestMethod.PUT, value="/folder/move/{folderId}/{destfolderId}", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItem> moveTargetFolder(@PathVariable String folderId, @PathVariable String destfolderId, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		this.LOG.info("Folder Controller::MOVE_Target Folder() called : " + folderId);
		Subject currentUser = SecurityUtils.getSubject();

		User user = this.userService.getUser(currentUser.getPrincipal().toString());
		if (user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}

		FileItem item = repositoryService.findFolder(folderId);
		FileItem destItem = repositoryService.findFolder(destfolderId);

		LOG.info("DESTNATION PATH : " + destItem.getPath());
		if (item == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, item, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		String folderPath = item.getPath();
		String canonicalPath = null;
		String destPath = destItem.getPath();
		File src = new File(folderPath);

		try {
			canonicalPath = src.getCanonicalPath();
			if (canonicalPath == null) {
				LOG.error("Can't get canonicalPath : " + folderPath);
				if (currentUser.isAuthenticated())
					currentUser.logout();
				return responseWriter(currentUser, item, new HttpHeaders(), 
						HttpStatus.UNAUTHORIZED);
			}
		}
		catch (IOException e)
		{
			LOG.error("getCanonicalPath fail : " + folderPath);
			if (currentUser.isAuthenticated())
				currentUser.logout();
		}   

		File destFile = new File(destPath); 

		LOG.info("destPath = " + destPath);	           
		LOG.info("----MOVE BEFORE----");

		//repositoryService.movetargetFile(folderPath, destPath, item);

		FileUtils.moveDirectoryToDirectory(src, destFile, true);
		LOG.info("-----MOVE AFTER----");

		String NewdestPath = destPath + "/" + src.getName();

		FileItem destName = new FileItem();
		//	      File fDestFile = new File(NewdestPath);


		destName = repositoryService.getFolder(NewdestPath);

		LOG.info("MOVED FOLDER ID :" + destName.getId());
		LOG.info("FINAL DEST PATH : " + destName.getPath());

		//	      destName.setPath(destName.getPath());
		//	      destName.setId(destName.getId());
		//	      destName.setName(fDestFile.getName());
		//	      destName.setSize(destName.getSize());
		//	      destName.setLastModified(destName.getLastModified());
		destName.setType("folder");
		destName.setDescription("moved Folder");

		return responseWriter(currentUser, destName, new HttpHeaders(), 
				HttpStatus.OK);   
	}

	@RequestMapping(method=RequestMethod.PUT, value="/folder/copy/{folderId}/{destfolderId}", headers="Accept=application/json, application/xml")
	public ResponseEntity<FileItem> copyTargetFolder(@PathVariable String folderId, @PathVariable String destfolderId, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		this.LOG.info("Folder Controller::MOVE_Target Folder() called : " + folderId);
		Subject currentUser = SecurityUtils.getSubject();

		User user = this.userService.getUser(currentUser.getPrincipal().toString());
		if (user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.BAD_REQUEST);
		}

		FileItem item = repositoryService.findFolder(folderId);
		FileItem destItem = repositoryService.findFolder(destfolderId);

		LOG.info("DESTNATION PATH : " + destItem.getPath());
		if (item == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, item, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}
		String folderPath = item.getPath();
		String canonicalPath = null;
		String destPath = destItem.getPath();
		File src = new File(folderPath);

		try {
			canonicalPath = src.getCanonicalPath();
			if (canonicalPath == null) {
				LOG.error("Can't get canonicalPath : " + folderPath);
				if (currentUser.isAuthenticated())
					currentUser.logout();
				return responseWriter(currentUser, item, new HttpHeaders(), 
						HttpStatus.UNAUTHORIZED);
			}
		}
		catch (IOException e)
		{
			LOG.error("getCanonicalPath fail : " + folderPath);
			if (currentUser.isAuthenticated())
				currentUser.logout();
		}   

		File destFile = new File(destPath); 

		LOG.info("destPath = " + destPath);	           
		LOG.info("----COPY BEFORE----");

		//repositoryService.movetargetFile(folderPath, destPath, item);

		FileUtils.moveDirectoryToDirectory(src, destFile, true);
		LOG.info("-----COPY AFTER----");

		String NewdestPath = destPath + "/" + src.getName();

		FileItem destName = new FileItem();
		//	      File fDestFile = new File(NewdestPath);


		destName = repositoryService.getFolder(NewdestPath);

		LOG.info("copied FOLDER ID :" + destName.getId());
		LOG.info("FINAL DEST PATH : " + destName.getPath());

		//	      destName.setPath(destName.getPath());
		//	      destName.setId(destName.getId());
		//	      destName.setName(fDestFile.getName());
		//	      destName.setSize(destName.getSize());
		//	      destName.setLastModified(destName.getLastModified());
		destName.setType("folder");
		destName.setDescription("copied Folder");

		return responseWriter(currentUser, destName, new HttpHeaders(), 
				HttpStatus.OK);   
	}



	@RequestMapping(method=RequestMethod.GET, value="/disk/{userId}/used", headers="Accept=application/json, application/xml")
	public ResponseEntity<Disk> getUsedDisk(@PathVariable String userId, HttpServletRequest request)
			throws IOException
			{
		Subject currentUser = SecurityUtils.getSubject();

		this.LOG.info("===================== UserID called : =========================\n" + userId);

		String userHomeDir = "/EDISON" + Cloud.getInstance().getProp("data.basedir").replace(".", "") + "/" + currentUser.getPrincipal().toString() + "/repository";
		this.LOG.info("Disk Usage::Disk_Used() called : " + userHomeDir);
		long usageDisk = repositoryService.getDiskusage(userHomeDir);
		Disk disk = new Disk(usageDisk);

		return responseWriter(currentUser, disk, new HttpHeaders(), 
				HttpStatus.OK);
			}

	@RequestMapping(method=RequestMethod.GET, value="/disk/free", headers="Accept=application/json, application/xml")
	public ResponseEntity<Disk> getFreeDisk(HttpServletRequest request) throws IOException
	{
		Subject currentUser = SecurityUtils.getSubject();
		String userHomeDir = "/EDISON" + Cloud.getInstance().getProp("data.basedir").replace(".", "") + "/" + currentUser.getPrincipal().toString() + "/repository";
		this.LOG.info("===================== User Path called : =========================\n" + userHomeDir);

		this.LOG.info("Disk Free Size::Disk_Free() called : " + userHomeDir);
		long freeDisk = this.repositoryService.getDiskfree(userHomeDir); 	
		LOG.info(freeDisk);
		Disk disk = new Disk(freeDisk);

		return responseWriter(currentUser, disk, new HttpHeaders(), 
				HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value="/disk/space", headers="Accept=application/json, application/xml")
	public ResponseEntity<Disk> getSpaceDisk(HttpServletRequest request)
			throws IOException
			{
		Subject currentUser = SecurityUtils.getSubject();
		String userHomeDir = "/EDISON" + Cloud.getInstance().getProp("data.basedir").replace(".", "") + "/" + currentUser.getPrincipal().toString() + "/repository";
		this.LOG.info("===================== Disk Space called : =========================\n" + userHomeDir);

		this.LOG.info("Disk Space::Disk_Space() called : " + userHomeDir);
		long spaceDisk = repositoryService.getDiskspace(userHomeDir);

		Disk disk = new Disk(spaceDisk);

		return responseWriter(currentUser, disk, new HttpHeaders(), 
				HttpStatus.OK);
			}

	@RequestMapping(method=RequestMethod.PUT, value="/folder/{folderId}/permission", headers="Accept=application/json, application/xml")
	public ResponseEntity<File> permissionFolder(HttpServletRequest request, @PathVariable String folderId)
			throws IOException
			{
		this.LOG.info("Folder Controller::Rename_Folder() called : " + folderId);
		Subject currentUser = SecurityUtils.getSubject();

		FileItem item = this.repositoryService.find(folderId);
		if (item == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}

		File file = new File(item.getPath());
		if (file.isDirectory())
		{
			if (currentUser.hasRole("admin"))
			{
				file.setExecutable(true);
				file.setReadable(true);
				file.setWritable(true);
				//	        String print = "permission changed by admin";
				return responseWriter(currentUser, file, new HttpHeaders(), 
						HttpStatus.OK);
			}

			file.setExecutable(true);
			file.setReadable(true);
			//	      String print = "permission changed by user";
			return responseWriter(currentUser, file, new HttpHeaders(), 
					HttpStatus.OK);
		}

		//	    String print = "This is not Folder... Fail!!";
		return responseWriter(currentUser, null, new HttpHeaders(), 
				HttpStatus.NOT_FOUND);
			}

	@RequestMapping(method=RequestMethod.PUT, value="/file/{fileId}/permission", headers="Accept=application/json, application/xml")
	public ResponseEntity<File> permissionFile(HttpServletRequest request, @PathVariable String fileId)
			throws IOException
			{
		this.LOG.info("Folder Controller::Rename_Folder() called : " + fileId);
		Subject currentUser = SecurityUtils.getSubject();

		FileItem item = this.repositoryService.find(fileId);
		if (item == null) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, null, new HttpHeaders(), 
					HttpStatus.NOT_FOUND);
		}

		File file = new File(item.getPath());

		if (file.isFile()) {
			if (currentUser.hasRole("admin"))
			{
				file.setExecutable(true);
				file.setReadable(true);
				file.setWritable(true);
				//	        String print = "permission changed by admin!";
				return responseWriter(currentUser, file, new HttpHeaders(), 
						HttpStatus.OK);
			}

			file.setExecutable(true);
			file.setReadable(true);
			//	      String print = "permission changed by normal user!";
			return responseWriter(currentUser, file, new HttpHeaders(), 
					HttpStatus.OK);
		}

		//	    String print = "This is not File... Fail!!";
		return responseWriter(currentUser, file, new HttpHeaders(), 
				HttpStatus.NOT_FOUND);
			}


	/**
	 * @author majin
	 * parameter : path , return set fileid & path
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/file/encode", headers = "Accept=application/json, application/xml")
	public ResponseEntity<FileItem> encode(
			@RequestBody Map<String,String> map,
			HttpServletRequest request) throws IOException {
		Base64 base64 = new Base64(180, "".getBytes());

		LOG.info("FileController::checkFile Method() called");
		Subject currentUser = SecurityUtils.getSubject();
		String path = map.get("path");

		User user = userService.getUser(currentUser.getPrincipal().toString());
		if(user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		if (path == null || path.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		String userHomeDir = "/EDISON/" + user.getStorageSource() + "repository/";
		LOG.debug("USER HOME DIR: " + userHomeDir);

		String fileName = path.replaceAll("\\p{Space}", "_");
		//			String fullPath = userHomeDir + fileName;

		FileItem fileItem = new FileItem();
		fileItem.setPath(fileName);
		fileItem.setId(new String(base64.encode(fileName.getBytes())));
		//			fileItem.setType("text/plain");
		//			fileItem.setPath(path);
		//			fileItem.setSize(Long.valueOf((long) content.length()));

		return responseWriter(currentUser, fileItem, new HttpHeaders(), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/file/solver/upload", headers = "Accept=application/json, application/xml")
	public ResponseEntity<String> solverUpload(
			@RequestBody Map<String,String> map,
			@RequestParam(value = "cluster", required = true) String clusterName,
			HttpServletRequest request) throws IOException {

		LOG.info("FileController::solverUpload Method() called");
		Subject currentUser = SecurityUtils.getSubject();
		String path = map.get("path");
		String name = map.get("name");
		String version = map.get("version");

		User user = userService.getUser(currentUser.getPrincipal().toString());
		if(user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}
		if (path == null || path.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		if (version == null || version.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		Cluster cluster = clusterService.findCluster(clusterName);
		if ( cluster == null ) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		String resultPath = repositoryService.solverUpload(cluster, name, version, path);

		return responseWriter(currentUser, resultPath, new HttpHeaders(), HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.POST, value = "/file/solver/delete", headers = "Accept=application/json, application/xml")
	public ResponseEntity<String> solverDelete(
			@RequestBody Map<String,String> map,
			@RequestParam(value = "cluster", required = true) String clusterName,
			HttpServletRequest request) throws IOException {

		LOG.info("FileController::solverUpload Method() called");
		Subject currentUser = SecurityUtils.getSubject();
		String name = map.get("name");
		String version = map.get("version");

		User user = userService.getUser(currentUser.getPrincipal().toString());
		if(user == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}
		if (version == null || version.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		Cluster cluster = clusterService.findCluster(clusterName);
		if ( cluster == null ) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		String resultPath = repositoryService.solverDelete(cluster, name, version);

		return responseWriter(currentUser, resultPath, new HttpHeaders(), HttpStatus.OK);
	}
}
