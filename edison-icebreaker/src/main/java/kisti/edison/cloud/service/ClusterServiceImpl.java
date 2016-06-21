/**
 * 
 */
package kisti.edison.cloud.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kisti.edison.cloud.dao.ClusterDAO;
import kisti.edison.cloud.manager.ClusterManager;
import kisti.edison.cloud.model.Cluster;

/**
 * @author jlyu
 *
 */
@Transactional
@Service("clusterService")
public class ClusterServiceImpl implements ClusterService {
	private final Logger LOG = Logger.getLogger(this.getClass());
	
	private ClusterDAO clusterDAO;
	public ClusterDAO getClusterDAO() {
		return clusterDAO;
	}
	@Autowired
	public void setClusterDAO(ClusterDAO clusterDAO) {
		this.clusterDAO = clusterDAO;
	}
	
	private ClusterManager clusterManager;
	public ClusterManager getClusterManager() {
		return clusterManager;
	}
	@Autowired
	public void setClusterManager(ClusterManager clusterManager) {
		this.clusterManager = clusterManager;
	}
	
	
	/* (non-Javadoc)
	 * @see kisti.edison.cloud.service.ClusterService#getClusters()
	 */
	@Override
	public List<Cluster> getClusters() {
		// TODO Auto-generated method stub
		return clusterDAO.getClusters(null);
	}
	
	@Override
	public Cluster findCluster(String name) {
		// TODO Auto-generated method stub
		return clusterDAO.findCluster(null, name);
	}


}
