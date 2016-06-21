/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import org.hibernate.Session;

import kisti.edison.cloud.model.FileEntry;

/**
 * @author jlyu
 *
 */
public interface FileEntryDAO {

	public FileEntry createEntry(Session session, FileEntry e);
	
	public FileEntry deleteEntry(Session session, String uuid);
	
	public FileEntry updateEntry(Session session, FileEntry e);

	public FileEntry getEntry(Session session, String uuid);
	
	public List<FileEntry> findEntryByOwner(Session session, String owner);
	
	public List<FileEntry> findEntryByName(Session session, String name);
	
	public List<FileEntry> findEntry(Session session, String owner, String name);
	
}
