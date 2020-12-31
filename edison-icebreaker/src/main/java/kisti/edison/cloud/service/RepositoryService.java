/**
 * 
 */
package kisti.edison.cloud.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.FileItem;
import kisti.edison.cloud.model.User;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author root
 * 
 */
public interface RepositoryService {

	public void create(Cluster cluster, String userId, byte[] content, FileItem fileItem)
			throws IOException;
	
	public void create(Cluster cluster, User user, byte[] content, FileItem fileItem)
			throws IOException;

	public void createLargeFile(Cluster cluster, User user, MultipartFile file, FileItem fileItem, long fileSize)
			throws IOException;
	
	public FileItem find(String fileId);

	public byte[] read(FileItem fileItem) throws IOException;

	public void update(String fileId, byte[] contents, FileItem fileItem);

	public void delete(String fileId);

	public List<FileItem> getFiles(String directory) throws IOException;
	
	public FileItem getFile(String filePath) throws IOException;
	
	public FileItem getFolder(String folderPath) throws IOException; // for using File Management

	public void folderCreate(Cluster c, User user, byte[] content, FileItem fileItem) throws IOException; //for using File Management

	public void deleteFolder(File folder); //for using File Management
	
	public abstract List<FileItem> getFolders(String dir) throws IOException;  //for using File Management
	
	public abstract String renameFolder(String paramString1, String paramString2, FileItem fileItem)  //for using File Management
		    throws IOException;
		
	public abstract String renameFile(String paramString1, String paramString2, String paramString3)  //for using File Management
	    throws IOException;
	
	public abstract void rename(String paramString)  //for using File Management
	    throws IOException;
	
	public FileItem findFolder(String folderId); // for using File Management
	
	public FileItem findFolderPath(String path); //for using File management 
 	
	public abstract long getDiskusage(String paramString)  //for using File Management
	    throws IOException;
	
	public abstract long getDiskfree(String paramString)  //for using File Management
	    throws IOException;
	
	public abstract long getDiskspace(String paramString)  //for using File Management
	    throws IOException;
	
	public abstract void moveFile(String srcPath, String targetPath, FileItem fileItem )throws IOException;
	
	public void moveInputFile(String fileId, String targetPath )throws IOException;  // support gas S/W 
	
	public void copyInputFile(String fileId, String targetPath )throws IOException;  // support gas S/W 
	
	public void movetargetFile(String folderPath, String destPath, FileItem item) throws IOException;
	
	public void updateFile(String srcPath, String targetPath, FileItem fileItem) throws IOException;
	
	public String arrayJoin(String glue, String array[]);
	
	public String solverUpload(Cluster cluster, String name, String version, String path);
	public String solverDelete(Cluster cluster, String name, String version);


}
