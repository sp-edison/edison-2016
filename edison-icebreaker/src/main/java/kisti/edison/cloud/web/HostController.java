/**
 * 
 */
package kisti.edison.cloud.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Count;
import kisti.edison.cloud.model.Host;
import kisti.edison.cloud.model.HostCount;
import kisti.edison.cloud.model.HostList;
import kisti.edison.cloud.service.HostService;
import kisti.edison.cloud.web.RestController.SORT;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author root
 * 
 */
@Controller
public class HostController extends RestController {
	private HostService hostService;

	private enum FIELD {
		id("id"),
		name("name"),
		state("state");
		
		private String field;
		
		FIELD(String f) {
			this.field = f;
		}
		
		public String getField() { return this.field; }
		
		public static FIELD fromString(String field) {
			if(field != null) {
				for(FIELD f : FIELD.values()) {
					if(field.equals(f.field)) {
						return f;
					}
				}
			}
			return null;
		}
	}
	
	public HostService getHostService() {
		return hostService;
	}

	@Autowired
	public void setHostService(HostService hostService) {
		this.hostService = hostService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/host/list", headers = "Accept=application/json, application/xml")
	public ResponseEntity<HostList> getHostList(
			@RequestParam(value = "startIndex", required = false) String startIndex,
			@RequestParam(value = "maxResults", required = false) String maxResults,
			@RequestParam(value = "field", required = false) String field,
			@RequestParam(value = "sort", required = false) String sort,
			HttpServletRequest request) {
		
		LOG.info("getHostList() called");
		Subject currentUser = SecurityUtils.getSubject();

		String mField = null;
		String mSort = null;
		
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}
		
		if(field == null || field.isEmpty()) {
			mField = "id";
		} else {
			mField = field;
		}
		
		if(sort == null || sort.isEmpty()) {
			mSort = "asc";
		} else {
			mSort = sort;
		}
		
		if ( !(FIELD.fromString(mField) instanceof FIELD) || !(SORT.fromString(mSort) instanceof SORT) ) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		List<Host> hosts = null;

		if (startIndex != null && !startIndex.isEmpty() && maxResults != null
				&& !maxResults.isEmpty()) {
			if (Integer.parseInt(startIndex) < 0 || Integer.parseInt(maxResults) < 1) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.BAD_REQUEST);
			}
			hosts = hostService.queryHosts(mField, mSort, Integer.parseInt(startIndex),
					Integer.parseInt(maxResults));
		} else if ((startIndex == null || startIndex.isEmpty())
				&& (maxResults != null && !maxResults.isEmpty())) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		} else if ((startIndex != null && !startIndex.isEmpty())
				&& (maxResults == null || maxResults.isEmpty())) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		} else {
			hosts = hostService.getHosts(mField, mSort);
		}
		HostList list = new HostList(hosts);
		return responseWriter(currentUser, list, new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/host/query", headers = "Accept=application/json, application/xml")
	public ResponseEntity<HostList> queryHosts(
			@RequestParam(value = "startIndex", required = true) int startIndex,
			@RequestParam(value = "maxResults", required = true) int maxResults,
			HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		if (startIndex < 0) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		List<Host> hosts = hostService.queryHosts(null, null, startIndex, maxResults);
		HostList list = new HostList(hosts);
		return responseWriter(currentUser, list, new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/host/count", headers = "Accept=application/json, application/xml")
	public ResponseEntity<HostCount> getHostCount(HttpServletRequest request) {
		LOG.info("getHostCount() called");
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		int hostCnt = hostService.getHostCount(null);
		
		HostCount hCount = new HostCount();
		hCount.setCount(hostCnt);
		
		for(Host.HostState s : Host.HostState.values()) {
			if(s.name().equals(Host.HostState.DISABLED.toString())) {
				hCount.setDISABLED(hostService.getHostCount(s.toString()));
			}
			else if(s.name().equals(Host.HostState.ERROR.toString())) {
				hCount.setERROR(hostService.getHostCount(s.toString()));
			}
			else if(s.name().equals(Host.HostState.PENDING.toString())) {
				hCount.setPENDING(hostService.getHostCount(s.toString()));
			}
			else if(s.name().equals(Host.HostState.READY.toString())) {
				hCount.setREADY(hostService.getHostCount(s.toString()));
			}
			else if(s.name().equals(Host.HostState.REMOVED.toString())) {
				hCount.setREMOVED(hostService.getHostCount(s.toString()));
			}
			else if(s.name().equals(Host.HostState.UNKNOWN.toString())) {
				hCount.setUNKNOWN(hostService.getHostCount(s.toString()));
			}
		}
		return responseWriter(currentUser, hCount, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/host/{hostId}/info", headers = "Accept=application/json, application/xml")
	public ResponseEntity<Host> getHost(@PathVariable Long hostId,
			HttpServletRequest request) {
		LOG.info("getHost() called");
		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		Host host = hostService.getHost(hostId);
		if (host == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		return responseWriter(currentUser, host, new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/host/register", headers = "Accept=application/json, application/xml")
	public ResponseEntity<Host> createHost(@RequestBody Host host,
			HttpServletRequest request) {

		LOG.info("createHost() called");
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		if (host.getName().isEmpty()) {
			responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		if (hostService.isAlreadyExist(host.getName())) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.CONFLICT);
		}

		Host createdHost = hostService.createHost(host);

		if (createdHost == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		return responseWriter(currentUser, createdHost, new HttpHeaders(),
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/host/{hostId}", headers = "Accept=application/json, application/xml")
	public ResponseEntity<Host> deleteHost(@PathVariable Long hostId,
			HttpServletRequest request) {
		LOG.info("deleteHost() called");
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		Host host = null;
		if ((host = hostService.getHost(hostId)) == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		if (host.getUsedCPU().equals(0L) && host.getRunningVMs().equals(0L)) {
			hostService.deleteHost(hostId);
		} else {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		return responseWriter(currentUser, null, new HttpHeaders(),
				HttpStatus.OK);
	}
}
