/**
 * 
 */
package kisti.edison.cloud.web;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.ClusterList;
import kisti.edison.cloud.model.Role;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.plugin.spec.ClusterAdapter;
import kisti.edison.cloud.service.ClusterService;
import kisti.edison.cloud.util.AuthUtils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jlyu
 *
 */
@Controller
public class ClusterController extends RestController {
	private ClusterService clusterService;
	
	private String key = Cloud.getInstance().getProp("user.admin.password");

	public ClusterService getClusterService() {
		return clusterService;
	}
	
	@Autowired
	public void setClusterService(ClusterService clusterService) {
		this.clusterService = clusterService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cluster/list", headers = "Accept=application/json, application/xml")
	public ResponseEntity<ClusterList> getClusters(HttpServletRequest request) {
		//Subject currentUser = SecurityUtils.getSubject();
		//LOG.info("getClusters() called : " + currentUser.getPrincipal().toString());
		
		List<Cluster> clusters = clusterService.getClusters();
		
		ClusterList list = new ClusterList(clusters);
		return responseWriter(null, list, new HttpHeaders(),
				HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/cluster/setPW", headers = "Accept=application/json, application/xml")
	public ResponseEntity<String> setPW(@RequestBody HashMap<String,String> input, HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		LOG.info("setPW called() : " + currentUser.getPrincipal().toString());
		
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		try {
			Cluster cluster = clusterService.findCluster(input.get("cluster"));
//			cluster.setRemotePW(input.get("remotePW"));
//			cluster.setRemoteOTP(input.get("remoteOTP"));
			cluster.setRemotePW(AuthUtils.encrypt(input.get("remotePW"), key));
			cluster.setRemoteOTP(AuthUtils.encrypt(input.get("remoteOTP"), key));
			//LOG.info(cluster.getRemoteOTP());
			//LOG.info(cluster.getRemotePW());
			LOG.info(cluster.getRemoteId());
			clusterService.updateCluster(cluster);
		} catch (Exception e){
			LOG.error(e);
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		return responseWriter(currentUser, null, new HttpHeaders(),
				HttpStatus.OK);
	}

}
