/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import kisti.edison.cloud.model.FileEntry;
import kisti.edison.cloud.model.Job;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * @author jlyu
 *
 */
@Repository("fileEntryDAO")
public class FileEntryDAOImpl extends HibernateDAO implements FileEntryDAO {

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.FileEntryDAO#createEntry(org.hibernate.Session, kisti.edison.cloud.model.FileEntry)
	 */
	@Override
	public FileEntry createEntry(Session session, FileEntry e) {
		// TODO Auto-generated method stub
		Session s = null;
		
		if(session == null) {
			s = getSession();
		}
		else {
			s = session;
		}
		
		s.save(e);
		s.flush();
		
		return e;
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.FileEntryDAO#deleteEntry(org.hibernate.Session, java.lang.String)
	 */
	@Override
	public FileEntry deleteEntry(Session session, String uuid) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		
		FileEntry e = getEntry(session, uuid);
		if(e == null) return e;
		
		session.delete(e);
		session.flush();
		
		return e;
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.FileEntryDAO#updateEntry(org.hibernate.Session, kisti.edison.cloud.model.FileEntry)
	 */
	@Override
	public FileEntry updateEntry(Session session, FileEntry e) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.FileEntryDAO#getEntry(org.hibernate.Session, java.lang.String)
	 */
	@Override
	public FileEntry getEntry(Session session, String uuid) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		FileEntry e = (FileEntry)session.get(FileEntry.class, uuid);
		return e;
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.FileEntryDAO#findEntryByOwner(org.hibernate.Session, java.lang.String)
	 */
	@Override
	public List<FileEntry> findEntryByOwner(Session session, String owner) {
		// TODO Auto-generated method stub
		Assert.hasText(owner);
		if(session == null) {
			session = getSession();
		}
		
		String q = "from FileEntry entry where entry.ownedBy = :owner order by entry.lastModified desc";
		
		@SuppressWarnings("unchecked")
		List<FileEntry> entries = session.createQuery(q).setString("owner", owner).list();
		return entries;
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.FileEntryDAO#findEntryByName(org.hibernate.Session, java.lang.String)
	 */
	@Override
	public List<FileEntry> findEntryByName(Session session, String name) {
		// TODO Auto-generated method stub
		Assert.hasText(name);
		if(session == null) {
			session = getSession();
		}
		String q = "from FileEntry entry where entry.name = :name order by entry.lastModified desc";
		@SuppressWarnings("unchecked")
		List<FileEntry> entries = session.createQuery(q).setString("name", name).list();
		
		return entries;
	}

	@Override
	public List<FileEntry> findEntry(Session session, String owner, String name) {
		// TODO Auto-generated method stub
		Assert.hasText(owner);
		Assert.hasText(name);
		
		if (session == null) {
			session = getSession();
		}

		String query = "from FileEntry entry where entry.name = :name and entry.ownedBy = :owner";
		Query q = session.createQuery(query);
		q = q.setString("name", name);
		q = q.setString("owner", owner);
		List<FileEntry> entries = q.list();

		return entries;
	}

}
