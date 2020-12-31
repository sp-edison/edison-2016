/**
 * 
 */
package kisti.edison.cloud.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.activation.MimetypesFileTypeMap;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.FileItem;
import kisti.edison.cloud.model.User;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.commons.codec.binary.Base64;


/**
 * @author root
 * 
 */
@Transactional
@Service("repositoryService")
public class RepositoryServiceImpl implements RepositoryService {
	private static String separator = "______";
	private final Logger LOG = Logger.getLogger(this.getClass());
	Base64 base64 = new Base64(180, "".getBytes());

	private String getTemporalDirectory(Cluster cluster, String userId) {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dir = cluster.getBaseDir() + Cloud.getInstance().getProp("data.basedir") + "/"
				+ userId + "/"
				+ Cloud.getInstance().getProp("user.repositorypath") + "/"
				+ sdf.format(now.getTime()) + "/";

		if (!(new File(dir)).exists()) {
			LOG.info("creating " + dir);
			(new File(dir)).mkdirs();
		}
		return dir;
	}
	
	
	private String makeRandomDir(Cluster cluster, User user) {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dir = cluster.getBaseDir() + "/" + user.getStorageSource() + "/" + Cloud.getInstance().getProp("user.repositorypath") + "/"
				+ sdf.format(now.getTime()) + "/";

		if (!(new File(dir)).exists()) {
			LOG.info("creating " + dir);
			(new File(dir)).mkdirs();
		}
		return dir;
	}
	
	// No Using dateFormat mkdir and Using File upload. 
	 private String makeDirforFile(Cluster cluster, User user) {
		   // Calendar now = Calendar.getInstance();
	        
//	        String dir = cluster.getBaseDir() + "/" + user.getStorageSource() + "/" + Cloud.getInstance().getProp("user.repositorypath") + "/";
//	        String dir = cluster.getBaseDir() + Cloud.getInstance().getProp("data.basedir") + "/"
//					+ user.getUserId() + "/" 	+ Cloud.getInstance().getProp("user.repositorypath") + "/";
		 
		    String dir = "/EDISON/"  + user.getStorageSource() + "repository/";
			
			String userHomeDir = "/EDISON/" + user.getStorageSource() + "repository/";
//			String filePath = dir + fileName;
			
			LOG.info("Cluster.GET BASE DIR : " + cluster.getBaseDir());
			LOG.debug("Cloud Get Instance() :" + Cloud.getInstance());
			
			LOG.info("USER HOME DIR : " + userHomeDir);
			LOG.info("DIR : " +  dir);
			
	        LOG.info((Object)("CREATE FOLDER PATH: " + dir));
	        if (!new File(dir).exists()) {
	            LOG.info((Object)("creating FILE" + dir));
	            //new File(dir).mkdir();
	            new File(dir).mkdirs(); //change mkdir -> mkdirs  
	        }
	        return dir;
	    }
	 
	 
	 
		// No using dateFormat mkdirs. for folder Create
	 private String makeDir(Cluster cluster, User user) {
	       // Calendar now = Calendar.getInstance();
	        
//	        String dir = String.valueOf(cluster.getBaseDir()) + "/" + user.getStorageSource() + "/" + Cloud.getInstance().getProp("user.repositorypath") + "/" ;
			
//		    String dir = cluster.getBaseDir() + Cloud.getInstance().getProp("data.basedir") + "/"
//					+ user.getUserId() + "/" 	+ Cloud.getInstance().getProp("user.repositorypath") + "/";
		 
			String dir = "/EDISON/"  + user.getStorageSource() + "repository/";
			
			LOG.info("Cluster.GET BASE DIR : " + cluster.getBaseDir());
			LOG.info("Cloud Get Instance() :" + Cloud.getInstance());
			
	        LOG.info("CREATE FOLDER PATH: " + dir);
	        
	        if (!(new File(dir)).exists()) {
	            this.LOG.info("This folder not exist .. then, creating " + dir);
	            (new File(dir)).mkdirs();
	        }
	        
	        return dir;
	    }	 

	private String getFilePath(String dir, String fileName) {
		return dir + UUID.randomUUID().toString().replaceAll("-", "") + RepositoryServiceImpl.separator + fileName;
	}

	private String getFileName(String filePath) {
		String[] tokens = filePath.split(RepositoryServiceImpl.separator);
		if (tokens != null && tokens.length == 2) {
			return tokens[1];
		} else {
			return filePath.substring(filePath.lastIndexOf('/') + 1);
		}
	}

	
	//Orignal Create function	
    @Override
	public void create(Cluster cluster, String userId, byte[] content, FileItem fileItem)
			throws IOException {
		LOG.info("RepositoryServiceImpl::create() : " + cluster.getName() + " : " + userId);
		String filePath = getFilePath(getTemporalDirectory(cluster, userId),
				fileItem.getName());
		FileOutputStream fos = new FileOutputStream(filePath);
		fos.write(content);
		fos.close();
		fileItem.setId(new String(base64.encode(filePath.getBytes())));
		fileItem.setPath(filePath);
		LOG.info(new String(base64.decode(fileItem.getId().getBytes())));
	}
    
    //Original Create function
//	@Override
//	public void create(Cluster cluster, User user, byte[] content, FileItem fileItem) throws IOException {
//		// TODO Auto-generated method stub
//		LOG.info("File Creating... : " + cluster.getName() + " : " + user.getUserId());
//		String filePath = getFilePath(makeRandomDir(cluster, user), fileItem.getName());
//		FileOutputStream fos = new FileOutputStream(filePath);
//		fos.write(content);
//		fos.close();
//		fileItem.setId(Base64.encode(filePath.getBytes()));
//		fileItem.setPath(filePath);
//		LOG.info(new String(Base64.decode(fileItem.getId())));
//	}
	

	
	@Override
	public void create(Cluster cluster, User user, byte[] content, FileItem fileItem) throws IOException {
		// TODO Auto-generated method stub
		LOG.info("File Creating... : " + cluster.getName() + " : " + user.getUserId());
		String homedir = makeDirforFile(cluster, user);
		String filePath = getFilePathNoTemp(homedir, fileItem.getName());
		
		FileOutputStream fos = new FileOutputStream(filePath);
		//FileOutputStream fos = new FileOutputStream(fileItem.getPath());
		LOG.info("FILE PATH : " + filePath);
		fos.write(content);
		fos.close();
		fileItem.setId(new String(base64.encode(filePath.getBytes())));
		fileItem.setPath(filePath);
		String filepath = new String(base64.decode(fileItem.getId().getBytes()));
		LOG.info(filepath);

		String grp = Cloud.getInstance().getProp("user.group.name");
		List<String> cmd = new ArrayList<String>();
		cmd.clear();
		cmd.add("/usr/bin/sudo");
		cmd.add("/bin/chown");
		cmd.add(user.getUserId()+":"+grp);
		cmd.add(filepath);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		CommandLine cmdLine = CommandLine.parse(cmd.get(0));
		for (int i=1, n=cmd.size() ; i<n ; i++ ) {
	        cmdLine.addArgument(cmd.get(i), false);
	    }
		int exitValue = -1;
		try {
			exitValue = executor.execute(cmdLine);
		} catch (ExecuteException e) {
			LOG.error("chown cmd fail: " + cmd.toString());
		} catch (IOException e) {
			LOG.error("chown command fail, IOException" + cmd.toString());
		}
		cmd.clear();
		cmd.add("/usr/bin/sudo");
		cmd.add("/bin/chmod");
		cmd.add("664");
		cmd.add(filepath);
		
		outputStream = new ByteArrayOutputStream();
		streamHandler = new PumpStreamHandler(outputStream);
		executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		cmdLine = CommandLine.parse(cmd.get(0));
		for (int i=1, n=cmd.size() ; i<n ; i++ ) {
	        cmdLine.addArgument(cmd.get(i), false);
	    }
		exitValue = -1;
		try {
			exitValue = executor.execute(cmdLine);
		} catch (ExecuteException e) {
			LOG.error("chown cmd fail: " + cmd.toString());
		} catch (IOException e) {
			LOG.error("chown command fail, IOException" + cmd.toString());
		}
	}

	public void createLargeFile(Cluster cluster, User user, MultipartFile file, FileItem fileItem, long fileSize) throws IOException {
		// TODO Auto-generated method stub
		LOG.info("File Creating... : " + cluster.getName() + " : " + user.getUserId());
		String homedir = makeDirforFile(cluster, user);
		String filePath = getFilePathNoTemp(homedir, fileItem.getName());
		
		FileOutputStream fos = new FileOutputStream(filePath);
		//FileOutputStream fos = new FileOutputStream(fileItem.getPath());
		LOG.info("FILE PATH LARGE: " + filePath);
		
		try {
			InputStream fis = file.getInputStream();
			LOG.info(fis.available());
			int c = 1;
			while ( fis.available() > 0 ) {
				int readSize = fis.available();
				byte[] buff;
				if ( readSize > 1024*1024*256 ) {
					buff = new byte[1024*1024*256];
				} else {
					buff = new byte[fis.available()];
				}
				c = fis.read(buff);
				//LOG.info("buff[0] : "+ buff[0]+ "reading buff = " + c);
				fos.write(buff);
			}
			fos.close();
		} catch ( IOException e ) {
			LOG.info("File Write Fail : " + user.toString() + " " + file.getName());
		}
		
		fileItem.setId(new String(base64.encode(filePath.getBytes())));
		fileItem.setPath(filePath);
		String filepath = new String(base64.decode(fileItem.getId().getBytes()));
		LOG.info(filepath);

		String grp = Cloud.getInstance().getProp("user.group.name");
		List<String> cmd = new ArrayList<String>();
		cmd.clear();
		cmd.add("/usr/bin/sudo");
		cmd.add("/bin/chown");
		cmd.add(user.getUserId()+":"+grp);
		cmd.add(filepath);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		CommandLine cmdLine = CommandLine.parse(cmd.get(0));
		for (int i=1, n=cmd.size() ; i<n ; i++ ) {
	        cmdLine.addArgument(cmd.get(i), false);
	    }
		int exitValue = -1;
		try {
			exitValue = executor.execute(cmdLine);
		} catch (ExecuteException e) {
			LOG.error("chown cmd fail: " + cmd.toString());
		} catch (IOException e) {
			LOG.error("chown command fail, IOException" + cmd.toString());
		}
		cmd.clear();
		cmd.add("/usr/bin/sudo");
		cmd.add("/bin/chmod");
		cmd.add("664");
		cmd.add(filepath);
		
		outputStream = new ByteArrayOutputStream();
		streamHandler = new PumpStreamHandler(outputStream);
		executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		cmdLine = CommandLine.parse(cmd.get(0));
		for (int i=1, n=cmd.size() ; i<n ; i++ ) {
	        cmdLine.addArgument(cmd.get(i), false);
	    }
		exitValue = -1;
		try {
			exitValue = executor.execute(cmdLine);
		} catch (ExecuteException e) {
			LOG.error("chown cmd fail: " + cmd.toString());
		} catch (IOException e) {
			LOG.error("chown command fail, IOException" + cmd.toString());
		}
	}
		
	
	
	
	@Override
	public FileItem find(String fileId) {
		// TODO Auto-generated method stub
		FileItem item = null;

		if (fileId != null && !fileId.isEmpty()) {
			
			String filePath = new String(base64.decode(fileId.getBytes()));
			//LOG.info("filePath : " + filePath);
			File f = new File(filePath);
			Date date = new Date(f.lastModified());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String fileDate = formatter.format(date);

			if (!f.exists()) {
				return null;
			}
			item = new FileItem();
			item.setId(fileId);
			item.setType(new MimetypesFileTypeMap().getContentType(f));
			item.setSize(f.length());
			item.setName(getFileName(filePath));
			item.setDescription("");
			item.setPath(filePath);
			item.setLastModified(fileDate);
			item.setParentPath(f.getParent());

		} else {
			LOG.info("fileId empty");
			return null;
		}

		return item;
	}

	@Override
	public byte[] read(FileItem fileItem) throws IOException {
		File file = new File(new String(base64.decode(fileItem.getId().getBytes())));
		InputStream is = new FileInputStream(file);
		long length = file.length();
		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			is.close();
			throw new IOException("Could not completely read file "
					+ file.getName());
		}

		is.close();
		return bytes;
	}

	@Override
	public void update(String fileId, byte[] contents, FileItem file) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String path) {
		// TODO Auto-generated method stub
		File target = new File(path);
		if ( target.exists() ) { 
			String filePath = target.getAbsolutePath();
			LOG.info("FOLDER PATH :" + filePath);
			String adminId = Cloud.getInstance().getProp("user.admin.id");
			List<String> cmd = new ArrayList<String>();
			cmd.clear();
			cmd.add("/usr/bin/sudo");
			cmd.add("/bin/chown");
			cmd.add("-R");
			cmd.add(adminId + ":");
			cmd.add(filePath);
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
			DefaultExecutor executor = new DefaultExecutor();
			executor.setStreamHandler(streamHandler);
			CommandLine cmdLine = CommandLine.parse(cmd.get(0));
			for (int i=1, n=cmd.size() ; i<n ; i++ ) {
		        cmdLine.addArgument(cmd.get(i), false);
		    }
			int exitValue = -1;
			try {
				exitValue = executor.execute(cmdLine);
			} catch (ExecuteException e) {
				LOG.error("chown cmd fail: " + cmd.toString());
			} catch (IOException e) {
				LOG.error("chown command fail, IOException" + cmd.toString());
			}
			
			if(target.isDirectory()){
				try {
					FileUtils.deleteDirectory(target);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				target.delete();
			}
		}
	}


	@Override
	public List<FileItem> getFiles(String directory) throws IOException {
		// TODO Auto-generated method stub
		List<FileItem> items = new LinkedList<FileItem>();
		
		File dir = new File(directory);
		if (!dir.exists() || !dir.isDirectory()) {
			LOG.info(directory + "not exists");
			return null;
		}
		

		for (File f : dir.listFiles()) {
			if (f.isFile()) {				

				// https://commons.apache.org/proper/commons-codec/apidocs/index.html?org/apache/commons/codec/binary/Base64.html
				String fileId = new String(base64.encode(f.getAbsolutePath().getBytes()));
				
//				LOG.info("FILE ID : " + fileId);				
				
//				Date date = new Date(f.lastModified());
//				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
//				String fileDate = formatter.format(date);
				FileItem item = find(fileId);
//				LOG.info(f.getAbsolutePath());
//							
//				
//				item.setId(Base64.encode(f.getAbsolutePath().getBytes()));
//				item.setName(f.getName());
//				item.setType(new MimetypesFileTypeMap().getContentType(f));
//				item.setSize(f.length());
//				item.setDescription("");
//				item.setPath(f.getAbsolutePath());
//				item.setLastModified(fileDate);
//				LOG.info(f.getParent());
//				item.setParentPath(f.getParent());
				
				items.add(item);
			}
		}

		return items;
	}

	@Override
	public synchronized FileItem getFile(String filePath) throws IOException {
		// TODO Auto-generated method stub
		FileItem item = new FileItem();
		File f = new File(filePath);
		String fileId = new String(base64.encode(f.getAbsolutePath().getBytes()));
		if (!f.exists()) {
			LOG.info(filePath + "not exists");
			return null;
		}
		
		if(f.isDirectory()) {
			LOG.info(filePath + "is not a file");
			return null;
		}
		
//		Date date = new Date(f.lastModified());
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		
//		String fileDate = formatter.format(date);
		
		item = find(fileId);
		
//		item.setId(Base64.encode(f.getAbsolutePath().getBytes()));
//		item.setName(f.getName());
//		item.setType(new MimetypesFileTypeMap().getContentType(f));
//		item.setSize(f.length());
//		item.setDescription("");
//		item.setPath(f.getAbsolutePath());
//		item.setLastModified(fileDate);
//		item.setParentPath(f.getParent());
		
		return item;
	}
	
	
	public FileItem getFolder(String folderPath) throws IOException {
		// TODO Auto-generated method stub
		FileItem item = new FileItem();
		File f = new File(folderPath);
		if (!f.exists()) {
			LOG.info(folderPath + "not exists");
			return null;
		}
		
		if(f.isFile()) {
			LOG.info(folderPath + "is not a folder");
			return null;
		}
		
		Date date = new Date(f.lastModified());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String fileDate = formatter.format(date);
		
		item.setId(new String(base64.encode(f.getAbsolutePath().getBytes())));
		item.setName(f.getName());
		item.setType(new MimetypesFileTypeMap().getContentType(f));
		item.setSize(f.length());
		item.setDescription("folder");
		item.setPath(f.getAbsolutePath());
		item.setLastModified(fileDate);
		item.setParentPath(f.getParent());
		
		return item;
	}

	public List<FileItem> getFolders(String directory) throws IOException
	 {
		    LinkedList<FileItem> items = new LinkedList<FileItem>();
//		    List<FileItem> folders = new List<FileItem>();

		    File dir = new File(directory);

//		    FileItemList list = new FileItemList();
//		    List<FileItem> folders = list.getFiles();
		    
		    if (!dir.exists()) 
		    {
		      this.LOG.info(directory + " Directory not exists");
		      return null;
		    }
		    	
		    Path dircetory = FileSystems.getDefault().getPath(dir.getAbsolutePath());
	        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dircetory,
	                filter)) {	        	
	            for (Path path : stream) {
	                // Iterate over the paths in the directory and print filenames
	                LOG.info(path.getFileName());
	                
	                FileItem item = new FileItem();
	                File f = path.toFile();
	                String fid =  new String(base64.encode(f.getAbsolutePath().getBytes()));
	                
//	                List<File> result = new ArrayList<File>();
//	                
//	                File[] files = dir.listFiles();
//	                files.toString();
	                
	                //String encode = Base64.encode(f.getAbsolutePath().getBytes());
	                
	               
	                	//String encode = Base64.encode(f.getAbsolutePath().getBytes("UTF-8"));
	                	item.setId(fid);
	                	item = findFolder(fid);
	                	items.add(item);
	              
//	                	String encode = Base64.encode(f.getAbsolutePath().getBytes("UTF-8"));
//		                String decode = new String(Base64.decode(encode));
//		                LOG.info(" ENCODING FOLDER ID::::::::: " + encode);
//		                LOG.info("DECODE INFO FOLDER ID : : :: : :  : : " + decode);
//		                
//		                item.setId(encode);
//		                item.setName(Name);
		                
//		                String folderId = item.getId();
//		                LOG.info("FOLDER FILE ID :::::::::::::::::::::::::::::::::::" + folderId);
		                
//		                String folderid = Base64.encode(f.getAbsolutePath().getBytes());
//		                item = findFolder(folderId);	                
		                
//		                File [] folderlist = dir.listFiles();
//		                folderlist.toString();
//		                
//		                FileItemList list = new FileItemList();
//		                
//		                List<FileItem> folders = list.getFiles();
		                
		                Date date = new Date(f.lastModified());
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						
						String fileDate = formatter.format(date);
												
//		                FileItem item = new FileItem();
//				        item.setId(Base64.encode(f.getAbsolutePath().getBytes()));
//		                item.setId(folderid); 
//		                
//				        item.setName(f.getName());
//				        item.setType(new MimetypesFileTypeMap().getContentType(f));
//				        item.setSize(Long.valueOf(f.length()));
//				        item.setDescription("");
//				        item.setPath(f.getAbsolutePath());
//				        item.setLastModified(fileDate);
//				        
//				        LOG.info(f.getParent());
//						item.setParentPath(f.getParent());

//						items.add(item);

	                }
	            	
			       
	            }
	        return items;
		    }


	public String renameFolder(String path, String dest, FileItem fileItem) throws IOException
	{
	    File target = new File(path);
	    File newName = new File(dest);
	
	    if (path == null) {
	    	throw new NullPointerException("Source must not be null");
	    }
	    if (dest == null){
	    	throw new NullPointerException("Destination must not be null");
	    }
	    if (!target.exists())
	    {
	    	throw new FileNotFoundException("Source '" + target + "' does not exist");
	    }
	    if (!target.isDirectory())
	    {
	    	throw new IOException("Source '" + target + "' is not a directory");
	    }
	    if (newName.exists()) 
	    {
	        throw new FileExistsException("Destination '" + newName + "' already exists");
	    }
	    
	    if ((target.isDirectory()) && (target != newName)) {
	    	final boolean rename = target.renameTo(new File(dest));
	    	
	    	if(!rename)
	    	{
	    		FileUtils.copyFile(target, newName);
	    		if(!target.delete()){
	    			FileUtils.deleteQuietly(newName);
	    			throw new IOException("Failed to delete original File" + target + "after copy to" + newName);
	    		}
	    	}
	    }
	    this.LOG.info(dest + "Folder Name was Changed");
	    return dest;
	    
//	    if ((target.isDirectory()) && (target != newName)) {
//	      target.renameTo(new File(dest));
//	    }
//	    else {
//	      newName.mkdir();
//	      target.renameTo(newName);
//	    }
//	
//	    this.LOG.info(dest + "Folder Name was Changed");
//	    return dest;
	 }
	
	public FileItem findFolder(String folderId) {
		
		FileItem item = null;
		LOG.info("FOLDER ID " + folderId);

		if (folderId != null && !folderId.isEmpty()) {
			
			String filePath = new String(new String(base64.decode(folderId.getBytes())));
			LOG.info("filePath : " + filePath);
			File f = new File(filePath);
			Date date = new Date(f.lastModified());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String fileDate = formatter.format(date);

			if (!f.exists()) {
				return null;
			}
			item = new FileItem();
			item.setId(folderId);
			item.setType(new MimetypesFileTypeMap().getContentType(f));
			item.setSize(f.length());
			item.setName(getFileName(filePath));
			item.setDescription("folder");
			item.setPath(f.getPath());
			item.setLastModified(fileDate);
			item.setParentPath(f.getParent());			

		} else {
			LOG.info("folderId empty");
			return null;
		}

		return item;
	}
	
	//using path

	public FileItem findFolderPath(String folderPath) {
		
		FileItem item = new FileItem();
		LOG.info("FOLDER path " + folderPath);

		if (folderPath != null && !folderPath.isEmpty()) {
			
			//String filePath = new String(Base64.decode(folderId));
			//LOG.info("filePath : " + filePath);
			File f = new File(folderPath);
			Date date = new Date(f.lastModified());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String fileDate = formatter.format(date);

			if (!f.exists()) {
				return null;
			}
			String folderId = new String(base64.encode(f.getAbsolutePath().getBytes()));
//			String folderId = Base64.encode(f.getAbsoluteFile().getPath().getBytes());
//			item = new FileItem();
			item.setId(folderId);
			item.setType(new MimetypesFileTypeMap().getContentType(f));
			item.setSize(f.length());
			item.setName(getFileName(folderPath));
			item.setDescription("folder");
			item.setPath(f.getPath());
			item.setLastModified(fileDate);
			item.setParentPath(f.getParent());			

		} else {
			LOG.info("folderId empty");
			return null;
		}

		return item;
	}
	
	  public long getDiskusage(String user_path)throws IOException
	  {
		    //String user_path = "/EDISON/TEST/DATA/" + userId;
	
		    File diskPartition = new File(user_path);
		    long totalCapacity = diskPartition.getTotalSpace();
	
		    this.LOG.info("Disk Usage::Disk_Used() called : " + user_path);
	
		    long freePartitionSpace = diskPartition.getFreeSpace();
		    long usablePatitionSpace = diskPartition.getUsableSpace();
		    long usedPartitionSpace = diskPartition.getTotalSpace() - diskPartition.getFreeSpace();
	
		    long usedSpace = usedPartitionSpace / 1073741824L;
		    long usedSpaceMB = usedPartitionSpace / 1048576L;
	
		    this.LOG.info("Usable Space : " + usablePatitionSpace / 1048576L + " MB");
		    this.LOG.info("Free Space : " + freePartitionSpace / 1048576L + " MB");
	
		    this.LOG.info("\n**** Sizes in Giga Bytes ****\n");
	
		    long usageSpace = usablePatitionSpace / 1073741824L;
	
		    this.LOG.info("Total partition size : " + totalCapacity / 1073741824L + " GB");
		    this.LOG.info("Usable Space : " + usageSpace);
		    this.LOG.info("Free Space : " + freePartitionSpace / 1073741824L + " GB");
		    this.LOG.info("Used Space :" + usedSpace);
	
		    return usedSpaceMB;
	  }

	  public long getDiskfree(String user_path)throws IOException
	  {
		    File diskPartition = new File(user_path);

		    this.LOG.info("Disk Usage::Disk_Used() called : " + user_path);

		    long freePartitionSpace = diskPartition.getFreeSpace();
		    long freeSize = freePartitionSpace / 1048576L;
		    long freeSizeG = freePartitionSpace / 1073741824L;

		    String freeSizeMB = freeSize + " MB";
		    String freeSizeGB = freeSizeG + " GB";

		    System.out.println("Free Space : " + freeSizeMB);
		    System.out.println("Free Space : " + freeSizeGB);

		    return freeSizeG;
	    }

	  public long getDiskspace(String user_path) throws IOException
	  {
	    File diskPartition = new File(user_path);

	    this.LOG.info("Disk Space::getDiskspace() called : " + user_path);
	    long totalCapacity = diskPartition.getTotalSpace();

	    long totalSpace = totalCapacity;

	    return totalSpace;
	  }

	  public String renameFile(String path, String dest, String userId)
	    throws IOException
	  {
	    File target = new File(path);
	    File newName = new File(dest);

	    if ((target.isFile()) && (target != newName)) {
	      target.renameTo(new File(dest));
	    }
	    else {
	      return null;
	    }
	    this.LOG.info(newName + "File Name was Changed");
	    return dest;
	  }

	  public void rename(String folderId)
	    throws IOException
	  {
	    String baseDir = "/EDISON";
	    Subject currentUser = SecurityUtils.getSubject();
	    File target = new File(folderId);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input = br.readLine();
	    String userHomeDir = baseDir + Cloud.getInstance().getProp("data.basedir").replace(".", "") + "/" + currentUser.getPrincipal().toString();
	    String new_name = userHomeDir + input;

	    if (target.isDirectory()) {
	      target.renameTo(new File(new_name));
	    }

	    this.LOG.info(new_name + "Folder Name was Changed");
	  }



	 public static Boolean fileIsLive(String isLivefile) 
	 {
		 File file = new File(isLivefile);
		 
		 if (file.exists()){
	      return Boolean.valueOf(true);
	      }
		 
		 return Boolean.valueOf(false);
	  }

	  public boolean isAvailable(File directory)
	  {
	    boolean result = false;

	    if ((directory.exists()) && (directory.isDirectory())) {
	      result = true;
	    }
	    return result;
	  }

	  public boolean acceptDir(File current, String name)
	  {
	    return new File(current, name).isDirectory();
	  }

	  public boolean acceptFile(File current, String name)
	  {
	    return new File(current, name).isDirectory();
	  }

	  boolean childCheck(File maybeChild, File possibleParent) throws IOException
	  {
	    File parent = possibleParent.getCanonicalFile();
	    if ((!parent.exists()) || (!parent.isDirectory()))
	    {
	      return false;
	    }

	    File child = maybeChild.getCanonicalFile();
	    while (child != null) {
	      if (child.equals(parent)) {
	        return true;
	      }

	    }

	    return false;
	  }

	  public List<FileItem> displayDirectoryContents(File dir)
	  {
	    List<FileItem> items = new LinkedList<FileItem>();
	    try {
	      for (File f : dir.listFiles()) {
	        if (f.isDirectory()) {
	          FileItem item = new FileItem();
	          item.setId(new String(base64.encode(f.getAbsolutePath().getBytes())));
	          item.setName(f.getName());
	          item.setType(new MimetypesFileTypeMap().getContentType(f));
	          item.setSize(Long.valueOf(f.length()));
	          item.setDescription("");

	          item.setPath(f.getAbsolutePath());

	          items.add(item);
	          System.out.println("directory:" + f.getCanonicalPath());
	          displayDirectoryContents(f);

	          this.LOG.info("DIRECTORY : " + items);
	          return items;
	        }
	        System.out.println("     file:" + f.getCanonicalPath());
	      }
	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	    return items;
	  }

	  public static void fileCopy(String inFileName, String outFileName)
	  {
	    try
	    {
	      FileInputStream fis = new FileInputStream(inFileName);
	      FileOutputStream fos = new FileOutputStream(outFileName);

	      int data = 0;
	      while ((data = fis.read()) != -1) {
	        fos.write(data);
	      }
	      fis.close();
	      fos.close();
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	  }

	public static String UpperCaseUrlEncode(String s) throws UnsupportedEncodingException
	  {
		// https://stackoverflow.com/questions/213506/java-net-urlencoder-encodestring-is-deprecated-what-should-i-use-instead
//	    char[] temp = URLEncoder.encode(s).toCharArray();
		char[] temp = URLEncoder.encode(s, java.nio.charset.StandardCharsets.UTF_8.toString()).toCharArray();
	    for (int i = 0; i < temp.length - 2; i++)
	    {
	      if (temp[i] == '%')
	      {
	        temp[(i + 1)] = Character.toUpperCase(temp[(i + 1)]);
	        temp[(i + 2)] = Character.toUpperCase(temp[(i + 2)]);
	      }
	    }
	    return new String(temp);
	  }

	  public static void Move(String srcFileName, String tarFileName)
	  {
	    try {
	      File srcFile = new File(srcFileName);
	      File destFile = new File(tarFileName);
	      if(srcFile.isFile()&& destFile.isFile())
	      {
	    	  FileUtils.moveFile(srcFile, destFile);
	      }
	     
	      FileUtils.deleteQuietly(srcFile);	      
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    } 
	  }
	  
	  public void moveInputFile(String srcFilepath, String tarFilePath)
	  {
		  LOG.info("MOVE FILE FUNCTION START!!!!!! FILE NAME = " + srcFilepath);
		  //Move(srcFilepath, tarFilePath);
	      File srcFile = new File(srcFilepath);
	      File destFile = new File(tarFilePath);
	      if(srcFile.isFile() )
	      {
	    	  LOG.info("try");
	    	  try {
				FileUtils.moveFile(srcFile, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				LOG.info("error - " + e.toString());
				e.printStackTrace();
			}
	      }
	  }
	  
	  public void copyInputFile(String srcFilepath, String tarFilePath)
	  {
		  LOG.info("copy FILE FUNCTION START!!!!!! FILE NAME = " + srcFilepath);
	    try {
	      FileInputStream fis = new FileInputStream(srcFilepath);
	      FileOutputStream fos = new FileOutputStream(tarFilePath);
	
	      int data = 0;
	      while ((data = fis.read()) != -1) {
	        fos.write(data);
	      }
	      fis.close();
	      fos.close();
	      LOG.info("FILE STREAM FUNCTION!! END !!!!");
	      File srcFile = new File(srcFilepath);
	      File destFile = new File(tarFilePath);
	      if(srcFile.isFile()&& destFile.isFile())
	      {
	    	  FileUtils.copyFile(srcFile, destFile);
	      }
	     LOG.info("COPY FILE FUNCTION ENDED !!!!!! " );
	      // FileUtils.deleteQuietly(srcFile);	      
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    } 
	  }

	public void deleteFolder(File file) {
		//to end the recursive loop
		LOG.info("DELETE METHOD !!! AND FILE EXIST CHECK" + file.getPath());
		if(!file.exists())
			return;
		//if directory, go inside and call recursively
		
		String filePath = file.getAbsolutePath();
		LOG.info("FOLDER PATH :" + filePath);
		String adminId = Cloud.getInstance().getProp("user.admin.id");
		List<String> cmd = new ArrayList<String>();
		cmd.clear();
		cmd.add("/usr/bin/sudo");
		cmd.add("/bin/chown");
		cmd.add("-R");
		cmd.add(adminId + ":");
		cmd.add(filePath);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		CommandLine cmdLine = CommandLine.parse(cmd.get(0));
		for (int i=1, n=cmd.size() ; i<n ; i++ ) {
	        cmdLine.addArgument(cmd.get(i), false);
	    }
		int exitValue = -1;
		try {
			exitValue = executor.execute(cmdLine);
		} catch (ExecuteException e) {
			LOG.error("chown cmd fail: " + cmd.toString());
		} catch (IOException e) {
			LOG.error("chown command fail, IOException" + cmd.toString());
		}
		
	    if(file.isDirectory()){
	    	LOG.info("IF FILE IS DIR");
	    	for(File f : file.listFiles()){
	    		//call recursively
	    		deleteFolder(f);
	    		LOG.info("DELETE FOLDER ");
	    	}
	    }
	  //call delete to delete files and empty directory
        file.delete();
        LOG.info("Deleted folder :" + file.getAbsolutePath());
	    
	}

//	@Override
//	public void folderCreate(Cluster c, User user, byte[] content, FileItem fileItem) throws IOException {
//		LOG.info("Folder Creating... : " + c.getName() + " : " + user.getUserId());
//		LOG.info("FILE NAME : ; : : : " + fileItem.getName());
//		String filePath = getFilePathNoTemp(makeDir(c, user.getUserId()), fileItem.getName());
//		FileOutputStream fos = new FileOutputStream(filePath);
//		fos.write(content);
//		fos.close();
//		//String Path = new File(filePath).getAbsolutePath();
//		fileItem.setId(Base64.encode(filePath.getBytes()));
//		fileItem.setPath(filePath);
//		LOG.info(new String(Base64.decode(fileItem.getId())));
//		File file = new File(filePath);
//		fileItem.setId(new String(Base64.encode(Path.getBytes())));
//		LOG.info("CREATED FOLDER ID : " + fileItem.getId());	
//	}
	
	@Override
	public void folderCreate(Cluster c, User user, byte[] content, FileItem fileItem) {
		LOG.info("Folder Creating... : " + c.getName() + " : " + user.getUserId());
		String filePath = getFilePathNoTemp(makeDir(c, user), fileItem.getName());
		LOG.info("FOLDER PATH :" + filePath);
		if (!new File(filePath).exists()) {
			this.LOG.info((Object)("creating " + filePath));
			new File(filePath).mkdir();
			
    		String grp = Cloud.getInstance().getProp("user.group.name");
    		List<String> cmd = new ArrayList<String>();
    		cmd.clear();
    		cmd.add("/usr/bin/sudo");
    		cmd.add("/bin/chown");
    		cmd.add(user.getUserId()+":"+grp);
    		cmd.add(filePath);
    		
    		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
    		DefaultExecutor executor = new DefaultExecutor();
    		executor.setStreamHandler(streamHandler);
    		CommandLine cmdLine = CommandLine.parse(cmd.get(0));
    		for (int i=1, n=cmd.size() ; i<n ; i++ ) {
    	        cmdLine.addArgument(cmd.get(i), false);
    	    }
    		int exitValue = -1;
    		try {
    			exitValue = executor.execute(cmdLine);
    		} catch (ExecuteException e) {
    			LOG.error("chown cmd fail: " + cmd.toString());
    		} catch (IOException e) {
    			LOG.error("chown command fail, IOException" + cmd.toString());
    		}
    		cmd.clear();
    		cmd.add("/usr/bin/sudo");
    		cmd.add("/bin/chmod");
    		cmd.add("775");
    		cmd.add(filePath);
    		
    		outputStream = new ByteArrayOutputStream();
    		streamHandler = new PumpStreamHandler(outputStream);
    		executor = new DefaultExecutor();
    		executor.setStreamHandler(streamHandler);
    		cmdLine = CommandLine.parse(cmd.get(0));
    		for (int i=1, n=cmd.size() ; i<n ; i++ ) {
    	        cmdLine.addArgument(cmd.get(i), false);
    	    }
    		exitValue = -1;
    		try {
    			exitValue = executor.execute(cmdLine);
    		} catch (ExecuteException e) {
    			LOG.error("chown cmd fail: " + cmd.toString());
    		} catch (IOException e) {
    			LOG.error("chown command fail, IOException" + cmd.toString());
    		}
        }
	}
	
	private String getFilePathNoTemp(String dir, String fileName) {
		return dir + fileName;
	}

	public DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
		@Override
		public boolean accept(Path file) throws IOException {
			return (Files.isDirectory(file));
		}
	};

	public static void copyDirectory(final File srcDir, final File destDir) throws IOException 
	{
		FileUtils.copyDirectory(srcDir, destDir, true);
	}

	public void moveFile(String srcPath, String targetPath, FileItem fileItem) throws IOException
	{		 

		File srcFile = new File(srcPath);
		File destFile = new File(targetPath + "/" + fileItem.getName() + "/");
		LOG.info("src File : " + srcFile.getName());
		LOG.info("SRC FILE is DIR?--" + srcFile.isDirectory());
		LOG.info("dest File : " + destFile.getName());
		LOG.info("dest File is DIR? --" + destFile.isDirectory());
		LOG.info("DEST PATH " + destFile.getPath());	      

		if(srcFile.isDirectory())
		{
			FileUtils.moveDirectoryToDirectory(srcFile, destFile, true);

			//	    	  FileUtils.copyDirectory(srcFile, destFile);
			//		      FileUtils.deleteQuietly(srcFile); 
		}

		FileUtils.copyFile(srcFile, destFile);
		FileUtils.deleteQuietly(srcFile); 
	}

	public void updateFile(String srcPath, String targetPath, FileItem fileItem) throws IOException
	{		 

		File srcFile = new File(srcPath);
		File destFile = new File(targetPath);
		LOG.info("src File : " + srcFile.getName());
		LOG.info("SRC FILE is DIR?--" + srcFile.isDirectory());
		LOG.info("dest File : " + destFile.getName());
		LOG.info("dest File is DIR? --" + destFile.isDirectory());
		LOG.info("DEST PATH " + destFile.getPath());	      

		if(srcFile.isDirectory())
		{
			FileUtils.moveDirectoryToDirectory(srcFile, destFile, true);

			//	    	  FileUtils.copyDirectory(srcFile, destFile);
			//		      FileUtils.deleteQuietly(srcFile); 
		}

		FileUtils.copyFile(srcFile, destFile);
		FileUtils.deleteQuietly(srcFile); 

	}

	public void movetargetFile(String srcPath, String targetPath, FileItem fileItem) throws IOException
	{		 

		File srcFile = new File(srcPath);
		File destFile = new File(targetPath);
		LOG.info("src File : " + srcFile.getName());
		LOG.info("SRC FILE is DIR?--" + srcFile.isDirectory());
		LOG.info("dest File : " + destFile.getName());
		LOG.info("dest File is DIR? --" + destFile.isDirectory());
		LOG.info("DEST PATH " + destFile.getPath());	      

		if(srcFile.isDirectory())
		{
			FileUtils.moveDirectoryToDirectory(srcFile, destFile, true);
			//FileUtils.deleteQuietly(srcFile); 
		}

		//FileUtils.copyFileToDirectory(srcFile, destFile);
		//FileUtils.deleteQuietly(srcFile); 
	}

	public String arrayJoin(String glue, String array[]) {
		String result = "";
		for (int i = 0; i < array.length; i++) {
			result += array[i];
			if (i < array.length - 1) result += glue;
		}
		return result;
	}

	public String solverUpload(Cluster cluster, String name, String version, String path) {
		List<String> cmd = new ArrayList<String>();
		ProcessBuilder builder = null;
		Process p = null;
		int retCode = 0;
		byte[] data = null;

		LOG.info("pushSolver - " + path + " ]");
		name.replaceAll(" ", "_");
		name.replaceAll("/", "_");
		String remoteSolverDir = String.format("SOLVERS/%s/", name);
		String remoteSolverVersDir = String.format("SOLVERS/%s/%s/", name, version);
		
		cmd.add("nurionssh");
		cmd.add(String.format("%s", cluster.getRemotePW()));
		cmd.add(String.format("%s", cluster.getRemoteOTP()));
		cmd.add("ssh");
		cmd.add("-p");
		cmd.add(cluster.getPort());
		cmd.add(cluster.getRemoteId()+"@"+cluster.getIp());
		cmd.add("mkdir");
		cmd.add("-p");
		cmd.add(remoteSolverDir);
		LOG.info("remote cmd: " + cmd.toString());
		builder = new ProcessBuilder(cmd);
		builder.redirectErrorStream(true);
		try {
			p = builder.start();
			retCode = p.waitFor();
			if (retCode == (-1)) {
				LOG.error(cmd.toString() + " fail");
				return "ERROR";
			}
			BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
			data = new byte[ef.available()];
			ef.read(data, 0, ef.available());
			ef.close();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cmd = new ArrayList<String>();
		cmd.add("nurionssh");
		cmd.add(String.format("%s", cluster.getRemotePW()));
		cmd.add(String.format("%s", cluster.getRemoteOTP()));
		cmd.add("scp");
		cmd.add("-C");
		cmd.add("-r");
		cmd.add("-P");
		cmd.add(cluster.getPort());
		cmd.add(path);
		cmd.add(cluster.getRemoteId()+"@"+cluster.getIp() + ":" + remoteSolverVersDir);
		LOG.info("remote cmd: " + cmd.toString());
		builder = new ProcessBuilder(cmd);
		builder.redirectErrorStream(true);
		try {
			p = builder.start();
			retCode = p.waitFor();
			if (retCode == (-1)) {
				LOG.error(cmd.toString() + " fail");
				return "ERROR";
			}
			BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
			data = new byte[ef.available()];
			ef.read(data, 0, ef.available());
			ef.close();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cmd = new ArrayList<String>();
		cmd.add("nurionssh");
		cmd.add(String.format("%s", cluster.getRemotePW()));
		cmd.add(String.format("%s", cluster.getRemoteOTP()));
		cmd.add("ssh");
		cmd.add("-p");
		cmd.add(cluster.getPort());
		cmd.add(cluster.getRemoteId()+"@"+cluster.getIp());
		cmd.add("chmod");
		cmd.add("-R");
		cmd.add("+x");
		cmd.add(remoteSolverVersDir);
		LOG.info("remote cmd: " + cmd.toString());
		builder = new ProcessBuilder(cmd);
		builder.redirectErrorStream(true);
		try {
			p = builder.start();
			retCode = p.waitFor();
			if (retCode == (-1)) {
				LOG.error(cmd.toString() + " fail");
				return "ERROR";
			}
			BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
			data = new byte[ef.available()];
			ef.read(data, 0, ef.available());
			ef.close();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		cmd = new ArrayList<String>();
		cmd.add("nurionssh");
		cmd.add(String.format("%s", cluster.getRemotePW()));
		cmd.add(String.format("%s", cluster.getRemoteOTP()));
		cmd.add("ssh");
		cmd.add("-p");
		cmd.add(cluster.getPort());
		cmd.add(cluster.getRemoteId()+"@"+cluster.getIp());
		cmd.add("ls");
		cmd.add("-d");
		cmd.add(String.format("$PWD/%s", remoteSolverVersDir));
		LOG.info("remote cmd: " + cmd.toString());
		builder = new ProcessBuilder(cmd);
		builder.redirectErrorStream(true);
		try {
			p = builder.start();
			retCode = p.waitFor();
			if (retCode == (-1)) {
				LOG.error(cmd.toString() + " fail");
				return "ERROR";
			}
			BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
			data = new byte[ef.available()];
			ef.read(data, 0, ef.available());
			ef.close();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String Result = new String(data);
		LOG.info("push solver result : " + Result);
		String[] solverPath = Result.split("\n");
		return (solverPath[solverPath.length-1].trim());
	}
	public String solverDelete(Cluster cluster, String name, String version) {
		List<String> cmd = new ArrayList<String>();
		ProcessBuilder builder = null;
		Process p = null;
		int retCode = 0;
		byte[] data = null;

		LOG.info("deleteSolver - " + name + " : " + version + " ]");
		name.replaceAll(" ", "_");
		name.replaceAll("/", "_");
		String remoteSolverVersDir = String.format("SOLVERS/%s/%s/", name, version);
		
		cmd.add("nurionssh");
		cmd.add(String.format("%s", cluster.getRemotePW()));
		cmd.add(String.format("%s", cluster.getRemoteOTP()));
		cmd.add("ssh");
		cmd.add("-p");
		cmd.add(cluster.getPort());
		cmd.add(cluster.getRemoteId()+"@"+cluster.getIp());
		cmd.add("rm -rf");
		cmd.add(remoteSolverVersDir);
		LOG.info("remote cmd: " + cmd.toString());
		builder = new ProcessBuilder(cmd);
		builder.redirectErrorStream(true);
		try {
			p = builder.start();
			retCode = p.waitFor();
			if (retCode == (-1)) {
				LOG.error(cmd.toString() + " fail");
				return "ERROR";
			}
			BufferedInputStream ef = new BufferedInputStream(p.getInputStream());
			data = new byte[ef.available()];
			ef.read(data, 0, ef.available());
			ef.close();
			p.getInputStream().close();
			p.getOutputStream().close();
			p.getErrorStream().close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String Result = new String(data);
		LOG.info("push solver result : " + Result);
		String[] ResultArr = Result.split("\n");
		ResultArr[0] = "";
		ResultArr[1] = "";
		return (ResultArr.toString());
	}
}
