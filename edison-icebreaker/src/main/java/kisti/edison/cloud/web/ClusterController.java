/**
 * 
 */
package kisti.edison.cloud.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.ClusterList;
import kisti.edison.cloud.model.HostList;
import kisti.edison.cloud.service.ClusterService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jlyu
 *
 */
@Controller
public class ClusterController extends RestController {
	private ClusterService clusterService;

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
}
