/**
 * 
 */
package kisti.edison.cloud.plugin.cluster;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import pbsTorque.Core;
import pbsTorque.Machine;

import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.plugin.spec.ClusterAdapter;

/**
 * @author jlyu
 *
 */
@Component("vCluster")
public class VClusterAdapter implements ClusterAdapter {
	protected final Logger LOG = Logger.getLogger(this.getClass());
	
	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "1.0";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "vCluster";
	}
	
	/* (non-Javadoc)
	 * @see kisti.edison.cloud.plugin.spec.ClusterAdapter#getClusterRuntime(kisti.edison.cloud.model.Cluster)
	 */
	@Override
	public Cluster getClusterRuntime(Cluster cluster) {
		// currently supports only local mode
		if( !cluster.getPort().equals("0") ) {
			return null;
		}
		
		pbsTorque.Cluster vCluster = null;
		try {
			vCluster = pbsTorque.Cluster.getCluster();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		Long numTotalCores = 0L;
		Long numDownCores = 0L;
		Long numBusyCores = 0L;
		
		for(int i = 0 ; i < vCluster.getNodes().length ; i++) {
			Machine n = vCluster.getNodes()[i];
			numTotalCores += Long.parseLong(n.getNp());
			if(!n.getState().equals("down")) {
//				numTotalCores += Long.parseLong(n.getNp());
						
				Core[] cores = n.getCores();	
				for(int j = 0 ; j < cores.length ; j++) {
					Core c = n.getCores()[j];
					if(c.getJob() != null) {
						numBusyCores++;
					}
				}
			}
			else {
				numDownCores += Long.parseLong(n.getNp());
			}
		}
		
		cluster.getRuntime().setTotalCores(numTotalCores);
		cluster.getRuntime().setBusyCores(numBusyCores);
		cluster.getRuntime().setDownCores(numDownCores);
		cluster.getRuntime().setFreeCores((numTotalCores - numBusyCores - numDownCores));
		
		return cluster;
	}

	@Override
	public int getClusterRunCore(Cluster cluster, String username) {
		return 0;
	}

}
