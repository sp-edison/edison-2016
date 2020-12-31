
package kisti.edison.cloud.plugin.cluster;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.plugin.spec.ClusterAdapter;

/**
 * @author hgkim
 *
 */

@Component("KISTI-KAT")
public class KISTI_KAT  implements ClusterAdapter  {

	protected final Logger LOG = Logger.getLogger(this.getClass());

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public String getName() {
		return "KISTI-KAT";
	}

	@Override
	public Cluster getClusterRuntime(Cluster cluster) {

		Long numTotalCores = 2L;
		Long numDownCores = 0L;
		Long numBusyCores = 0L;

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
