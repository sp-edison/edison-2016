/**
 * 
 */
package kisti.edison.cloud.plugin.cluster;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import kisti.edison.cloud.env.Cloud;
//import pbsTorque.Core;
//import pbsTorque.Machine;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.plugin.spec.ClusterAdapter;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author jlyu
 *
 */
@Component("kisti.sinbaram")
public class PCluster2Adapter implements ClusterAdapter {

	protected final Logger LOG = Logger.getLogger(this.getClass());
	

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "1.0";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "kisti.sinbaram";
	}
	
	/* (non-Javadoc)
	 * @see kisti.edison.cloud.plugin.spec.ClusterAdapter#getClusterRuntime(kisti.edison.cloud.model.Cluster)
	 */
	@Override
	public Cluster getClusterRuntime(Cluster cluster) {
		
		Long numTotalCores = 0L;
		Long numDownCores = 0L;
		Long numBusyCores = 0L;
		
		String userId = Cloud.getInstance().getProp("user.admin.id");
		List<String> cmd = new ArrayList<String>();
		cmd.add("ssh");
		cmd.add("-p");
		cmd.add(cluster.getPort());
		cmd.add(userId + "@"+ cluster.getIp());
		cmd.add("/SYSTEM/loadl-cores.py");
		cmd.add(cluster.getName());
		cmd.add(cluster.getQueues());
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);
		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);
		CommandLine cmdLine = CommandLine.parse(cmd.get(0));
		for (int i=1, n=cmd.size() ; i<n ; i++ ) {
	        cmdLine.addArgument(cmd.get(i));
	    }
		int exitValue = -1;
		try {
			exitValue = executor.execute(cmdLine);
		} catch (ExecuteException e) {
			LOG.error("Get pbs-cores command fail");
			LOG.error("ssh cmd: " + cmd.toString());
		} catch (IOException e) {
			LOG.error("Get pbs-cores command fail, IOException");
		}

		if ( exitValue != 0) return null;
		
		String res = outputStream.toString();
		String[] cores = res.trim().split(":");

		numTotalCores = Long.parseLong(cores[0]);
		numBusyCores = Long.parseLong(cores[1]);
		numDownCores = Long.parseLong(cores[2]);
		
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
