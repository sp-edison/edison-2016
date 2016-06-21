/**
 * 
 */
package kisti.edison.cloud.service;

import java.util.List;

import kisti.edison.cloud.model.FileEntry;

/**
 * @author jlyu
 *
 */
public interface FileService {

	public FileEntry createFile (byte[] content, FileEntry fileEntry);
	
	public FileEntry deleteFile (String uuid);
	
	public List<FileEntry> getFiles (String owner);
	
	public FileEntry getFile(String uuid);
	
	public FileEntry updateFile (byte[] content, FileEntry fileEntry);
	
	public boolean isExist(String owner, String name);
	
}
