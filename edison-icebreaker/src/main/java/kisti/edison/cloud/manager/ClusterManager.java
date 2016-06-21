/**
 * 
 */
package kisti.edison.cloud.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.annotation.Resource;

import kisti.edison.cloud.dao.ClusterDAO;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Host;
import kisti.edison.cloud.plugin.spec.ClusterAdapter;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jlyu
 *
 */
@Component
public class ClusterManager {
	private final Logger LOG = Logger.getLogger(this.getClass());
	
	private ClusterDAO clusterDAO;
	public ClusterDAO getClusterDAO() {
		return clusterDAO;
	}
	@Autowired
	public void setClusterDAO(ClusterDAO clusterDAO) {
		this.clusterDAO = clusterDAO;
	}
	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Resource(name = "clusterQueue")
	private BlockingQueue<Command<Cluster>> clusterQueue;
	
	public BlockingQueue<Command<Cluster>> getClusterQueue() {
		return clusterQueue;
	}

	public void setClusterQueue(BlockingQueue<Command<Cluster>> clusterQueue) {
		this.clusterQueue = clusterQueue;
	}
	
	
	private Map<String, ClusterAdapter> clusterAdapters;
	
	
	public Map<String, ClusterAdapter> getClusterAdapters() {
		return clusterAdapters;
	}

	public void setClusterAdapters(Map<String, ClusterAdapter> clusterAdapters) {
		this.clusterAdapters = clusterAdapters;
	}

	@Transactional
	public synchronized void updateCluster(Cluster cluster) {
		ClusterAdapter adapter = clusterAdapters.get(cluster.getName());
		if(adapter != null) {
			Cluster aCluster;
			try {
				aCluster = adapter.getClusterRuntime(cluster);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LOG.info("[ " + cluster.getName() + " ] Exception !");
				this.notifyToWorker(new Command<Cluster>("ADD", cluster));
				return;
			}
			
			if(aCluster == null) {
				LOG.info("[ " + cluster.getName() + " ] GetRunTime() Fail !");
				this.notifyToWorker(new Command<Cluster>("ADD", cluster));
				return;
			}
			
			aCluster.setLastModified(new Date());
			
			Session session = null;
			Transaction tx = null;
			session = SessionFactoryUtils.getSession(this.sessionFactory, true);
			tx = session.beginTransaction();
			Cluster uCluster = clusterDAO.updateCluster(session, aCluster);
			tx.commit();
			SessionFactoryUtils.releaseSession(session, this.sessionFactory);
			if(uCluster != null) {
				LOG.info("[ " + uCluster.getName() + " ] Update Done. " + uCluster.toString());
				this.notifyToWorker(new Command<Cluster>("ADD", uCluster));
			}
			else {
				LOG.info("[ " + aCluster.getName() + " ] Update Fail");
				this.notifyToWorker(new Command<Cluster>("ADD", cluster));
			}
		}
		else {
			LOG.info("[ " + cluster.getName() + " ] CLUSTER ADAPTER NOT FOUND");
			this.notifyToWorker(new Command<Cluster>("ADD", cluster));
		}
	}
	
	public void notifyToWorker(Command<Cluster> cmd) {
		try {
			clusterQueue.put(cmd);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
