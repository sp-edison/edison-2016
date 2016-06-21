/**
 * 
 */
package kisti.edison.cloud.dao;

import java.util.List;

import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.FileEntry;
import kisti.edison.cloud.model.Host;
import kisti.edison.cloud.model.User;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

/**
 * @author jlyu
 *
 */
@Repository("clusterDAO")
@SuppressWarnings("unchecked")
public class ClusterDAOImpl extends HibernateDAO implements ClusterDAO {

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.ClusterDAO#getCluster(org.hibernate.Session, java.lang.Long)
	 */
	@Override
	public Cluster getCluster(Session session, Long id) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		Cluster c = (Cluster)session.get(Cluster.class, id);
		return c;
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.ClusterDAO#getClusters(org.hibernate.Session)
	 */
	@Override
	public List<Cluster> getClusters(Session session) {
		// TODO Auto-generated method stub
		if(session == null) {
			session = getSession();
		}
		
		List<Cluster> clusters = null;
		clusters = session.createQuery("from Cluster order by id").list();
		return clusters;
		
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.ClusterDAO#createCluster(org.hibernate.Session, kisti.edison.cloud.model.Cluster)
	 */
	@Override
	public Cluster createCluster(Session session, Cluster cluster) {
		// TODO Auto-generated method stub
		Session s = null;
		if(session == null) {
			s = getSession();
		}
		else {
			s = session;
		}
		
		s.save(cluster.getRuntime());
		s.save(cluster);
		s.flush();
		return cluster;
	}

	/* (non-Javadoc)
	 * @see kisti.edison.cloud.dao.ClusterDAO#updateCluster(org.hibernate.Session, kisti.edison.cloud.model.Cluster)
	 */
	@Override
	public Cluster updateCluster(Session session, Cluster cluster) {
		// TODO Auto-generated method stub
		Session s = null;
		if(session == null) {
			s = getSession();
		}
		else {
			s = session;
		}
		
		Cluster.Runtime pRuntime = (Cluster.Runtime)s.load(Cluster.Runtime.class, cluster.getRuntime().getId());
		pRuntime.setTotalCores(cluster.getRuntime().getTotalCores());
		pRuntime.setBusyCores(cluster.getRuntime().getBusyCores());
		pRuntime.setDownCores(cluster.getRuntime().getDownCores());
		pRuntime.setFreeCores(cluster.getRuntime().getFreeCores());
		s.flush();
		
		Cluster pCluster = (Cluster)s.load(Cluster.class, cluster.getId());
		pCluster.setName(cluster.getName());
		pCluster.setIp(cluster.getIp());
		pCluster.setPort(cluster.getPort());
		pCluster.setJobManagerType(cluster.getJobManagerType());
		pCluster.setJobManagerVersion(cluster.getJobManagerVersion());
		pCluster.setQueues(cluster.getQueues());
		pCluster.setLastModified(cluster.getLastModified());
		pCluster.setRuntime(cluster.getRuntime());
		pCluster.setBaseDir(cluster.getBaseDir());
		s.flush();
	
		return pCluster;
	}

	@Override
	public Cluster findCluster(Session session, String name) {
		// TODO Auto-generated method stub
		Assert.hasText(name);
		if(session == null) {
			session = getSession();
		}
		String query = "from Cluster c where c.name = :name";
		Cluster c = (Cluster) session.createQuery(query).setString("name", name).uniqueResult();
		return c;
	}

	@Override
	public void deleteCluster(Session session, String name) {
		// TODO Auto-generated method stub
		Assert.hasText(name);
		if(session == null) {
			session = getSession();
		}
		
		Cluster c = findCluster(session, name);
		
		if (c != null) {
			session.delete(c.getRuntime());
			session.delete(c);
			session.flush();
		}
	}
}
