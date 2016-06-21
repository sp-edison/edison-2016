/**
 * 
 */
package kisti.edison.cloud.service;

import java.io.IOException;
import java.io.InputStream;
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

	public FileItem find(String fileId);

	public byte[] read(FileItem fileItem) throws IOException;

	public void update(String fileId, byte[] contents, FileItem fileItem);

	public void delete(String fileId);

	public List<FileItem> getFiles(String directory) throws IOException;
	
	public FileItem getFile(String filePath) throws IOException;

}
