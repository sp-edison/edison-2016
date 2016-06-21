/**
 * 
 */
package kisti.edison.cloud.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Count;
import kisti.edison.cloud.model.Host;
import kisti.edison.cloud.model.VirtualMachine;
import kisti.edison.cloud.model.VirtualMachineCount;
import kisti.edison.cloud.model.VirtualMachineList;
import kisti.edison.cloud.service.VirtualMachineService;
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
public class VirtualMachineController extends RestController {
	private VirtualMachineService virtualMachineService;

	private enum FIELD {
		id("id"),
		name("name"),
		state("state"),
		userId("userId");
		
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
	
	public VirtualMachineService getVirtualMachineService() {
		return virtualMachineService;
	}

	@Autowired
	public void setVirtualMachineService(
			VirtualMachineService virtualMachineService) {
		this.virtualMachineService = virtualMachineService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/vm/list", headers = "Accept=application/json, application/xml")
	public ResponseEntity<VirtualMachineList> getVirtualMachines(
			@RequestParam(value = "startIndex", required = false) String startIndex,
			@RequestParam(value = "maxResults", required = false) String maxResults,
			@RequestParam(value = "field", required = false) String field,
			@RequestParam(value = "sort", required = false) String sort,
			HttpServletRequest request) {
		LOG.info("getVirtualMachines() called");
		Subject currentUser = SecurityUtils.getSubject();
		
		String mField = null;
		String mSort = null;
		
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
		
		
		LOG.info("startIndex : " +  startIndex);
		LOG.info("maxResults : " +  maxResults);
		
		List<VirtualMachine> vms = null;

		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			if (startIndex != null && !startIndex.isEmpty()
					&& maxResults != null && !maxResults.isEmpty()) {
				if (Integer.parseInt(startIndex) < 0 || Integer.parseInt(maxResults) < 1) {
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.BAD_REQUEST);
				}
				vms = virtualMachineService.queryVirtualMachines(currentUser
						.getPrincipal().toString(), mField, mSort, Integer
						.parseInt(startIndex), Integer.parseInt(maxResults));
			} else if ((startIndex == null || startIndex.isEmpty())
					&& (maxResults != null && !maxResults.isEmpty())) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.BAD_REQUEST);
			} else if ((startIndex != null && !startIndex.isEmpty())
					&& (maxResults == null || maxResults.isEmpty())) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.BAD_REQUEST);
			} else {
				vms = virtualMachineService.getVirtualMachines(currentUser
						.getPrincipal().toString(), mField, mSort);
			}
		} else {

			if (startIndex != null && !startIndex.isEmpty()
					&& maxResults != null && !maxResults.isEmpty()) {
				if (Integer.parseInt(startIndex) < 0 || Integer.parseInt(maxResults) < 1) {
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.BAD_REQUEST);
				}
				vms = virtualMachineService.queryVirtualMachines(mField, mSort,
						Integer.parseInt(startIndex),
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
				vms = virtualMachineService.getVirtualMachines(mField, mSort);
			}
		}

		VirtualMachineList list = new VirtualMachineList(vms);
		return responseWriter(currentUser, list, new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/vm/count", headers = "Accept=application/json, application/xml")
	public ResponseEntity<VirtualMachineCount> getVirtualMachinesCount(
			HttpServletRequest request) {
		LOG.info("getVirtualMachinesCount() called");
		Subject currentUser = SecurityUtils.getSubject();

		VirtualMachineCount vmCount = new VirtualMachineCount();
		int vmCnt = 0;

		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			vmCnt = virtualMachineService.getVirtualMachinesCount(currentUser
					.getPrincipal().toString(), false, null);
		} else {
			vmCnt = virtualMachineService.getVirtualMachinesCount(currentUser.getPrincipal().toString(), true, null);
			for(VirtualMachine.VirtualMachineState s : VirtualMachine.VirtualMachineState.values()) {
				if(s.name().equals(VirtualMachine.VirtualMachineState.RUNNING.toString())) {
					vmCount.setRUNNING(virtualMachineService.getVirtualMachinesCount(currentUser.getPrincipal().toString(), true, s.toString()));
				}
				else if(s.name().equals(VirtualMachine.VirtualMachineState.ERROR.toString())) {
					vmCount.setERROR(virtualMachineService.getVirtualMachinesCount(currentUser.getPrincipal().toString(), true, s.toString()));
				}
				else if(s.name().equals(VirtualMachine.VirtualMachineState.PENDING.toString())) {
					vmCount.setPENDING(virtualMachineService.getVirtualMachinesCount(currentUser.getPrincipal().toString(), true, s.toString()));
				}
				else if(s.name().equals(VirtualMachine.VirtualMachineState.STARTING.toString())) {
					vmCount.setSTARTING(virtualMachineService.getVirtualMachinesCount(currentUser.getPrincipal().toString(), true, s.toString()));
				}
				else if(s.name().equals(VirtualMachine.VirtualMachineState.SUSPENDED.toString())) {
					vmCount.setSUSPENDED(virtualMachineService.getVirtualMachinesCount(currentUser.getPrincipal().toString(), true, s.toString()));
				}
				else if(s.name().equals(VirtualMachine.VirtualMachineState.UNKNOWN.toString())) {
					vmCount.setUNKNOWN(virtualMachineService.getVirtualMachinesCount(currentUser.getPrincipal().toString(), true, s.toString()));
				}
				else if(s.name().equals(VirtualMachine.VirtualMachineState.STOPPED.toString())) {
					vmCount.setSTOPPED(virtualMachineService.getVirtualMachinesCount(currentUser.getPrincipal().toString(), true, s.toString()));
				}
			}
		}

		vmCount.setCount(vmCnt);
		return responseWriter(currentUser, vmCount, new HttpHeaders(), HttpStatus.OK);
	}

	/*
	 * @RequestMapping(method=RequestMethod.GET, value="/vm/list/own",
	 * headers="Accept=application/json, application/xml") public
	 * ResponseEntity<VirtualMachineList>
	 * getOwnVirtualMachines(HttpServletRequest request) {
	 * LOG.info("getOwnVirtualMachines() called"); Subject currentUser =
	 * SecurityUtils.getSubject();
	 * 
	 * List<VirtualMachine> vms =
	 * virtualMachineService.getVirtualMachines(currentUser
	 * .getPrincipal().toString()); VirtualMachineList list = new
	 * VirtualMachineList(vms);
	 * 
	 * return responseWriter(currentUser, list, new HttpHeaders(),
	 * HttpStatus.OK); }
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/vm/{vmId}/info", headers = "Accept=application/json, application/xml")
	public ResponseEntity<VirtualMachine> getVirtualMachine(
			@PathVariable Long vmId, HttpServletRequest request) {
		LOG.info("getVirtualMachine() called");
		Subject currentUser = SecurityUtils.getSubject();

		VirtualMachine vm = virtualMachineService.getVirtualMachine(vmId);
		if (vm == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		if (currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, vm, new HttpHeaders(),
					HttpStatus.OK);
		}

		if (!vm.getUserId().equals(currentUser.getPrincipal().toString())) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		return responseWriter(currentUser, vm, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/vm/provision", headers = "Accept=application/json, application/xml")
	public ResponseEntity<VirtualMachine> createVirtualMachine(
			@RequestBody VirtualMachine vm, HttpServletRequest request) {
		LOG.info("createVirtualMachine() called");
		Subject currentUser = SecurityUtils.getSubject();

		LOG.info("VM's request cpu : " + vm.getReqCpu());
		LOG.info("VM's requeme memory : " + vm.getReqMem());
		LOG.info("VM's request vcpus : " + vm.getReqVcpus());
		vm.setUserId(currentUser.getPrincipal().toString());
		VirtualMachine cvm = virtualMachineService.createVirtualMachine(vm);

		if (cvm == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		return responseWriter(currentUser, cvm, new HttpHeaders(),
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/vm/{vmId}/suspend", headers = "Accept=application/json, application/xml")
	public ResponseEntity<VirtualMachine> suspendVirtualMachine(
			@PathVariable Long vmId, HttpServletRequest request) {
		LOG.info("suspendVirtualMachine() called");
		Subject currentUser = SecurityUtils.getSubject();
		VirtualMachine svm = null;
		VirtualMachine vm = virtualMachineService.getVirtualMachine(vmId);
		if (vm == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		if (!vm.getState().equals(VirtualMachine.VirtualMachineState.RUNNING)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		if (currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			svm = virtualMachineService.changeVirtualMachineState(vmId,
					VirtualMachine.VirtualMachineState.SUSPEND_REQ);
		} else {
			if (!vm.getUserId().equals(currentUser.getPrincipal().toString())) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.UNAUTHORIZED);
			}
			svm = virtualMachineService.changeVirtualMachineState(vmId,
					VirtualMachine.VirtualMachineState.SUSPEND_REQ);
		}

		if (svm == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		return responseWriter(currentUser, svm, new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/vm/{vmId}/resume", headers = "Accept=application/json, application/xml")
	public ResponseEntity<VirtualMachine> resumeVirtualMachine(
			@PathVariable Long vmId, HttpServletRequest request) {
		LOG.info("resumeVirtualMachine() called");
		Subject currentUser = SecurityUtils.getSubject();
		VirtualMachine rvm = null;
		VirtualMachine vm = virtualMachineService.getVirtualMachine(vmId);
		if (vm == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		if (!vm.getState().equals(VirtualMachine.VirtualMachineState.SUSPENDED)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		if (currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			rvm = virtualMachineService.changeVirtualMachineState(vmId,
					VirtualMachine.VirtualMachineState.RESUME_REQ);
		} else {
			if (!vm.getUserId().equals(currentUser.getPrincipal().toString())) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.UNAUTHORIZED);
			}
			rvm = virtualMachineService.changeVirtualMachineState(vmId,
					VirtualMachine.VirtualMachineState.RESUME_REQ);
		}

		if (rvm == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		return responseWriter(currentUser, rvm, new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/vm/{vmId}/shutdown", headers = "Accept=application/json, application/xml")
	public ResponseEntity<VirtualMachine> deleteVirtualMachine(
			@PathVariable Long vmId, HttpServletRequest request) {
		LOG.info("deleteVirtualMachine() called");
		Subject currentUser = SecurityUtils.getSubject();
		VirtualMachine dvm = null;
		VirtualMachine vm = virtualMachineService.getVirtualMachine(vmId);
		if (vm == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		if (currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			dvm = virtualMachineService.shutdownVirtualMachine(vmId);
		} else {
			if (!vm.getUserId().equals(currentUser.getPrincipal().toString())) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.UNAUTHORIZED);
			}
			dvm = virtualMachineService.shutdownVirtualMachine(vmId);
		}

		if (dvm == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		return responseWriter(currentUser, dvm, new HttpHeaders(),
				HttpStatus.OK);
	}
	
	
	// TODO : FORCE TO DELETE VM (admin purpose)
	@RequestMapping(method = RequestMethod.DELETE, value = "/vms/purge", headers = "Accept=application/json, application/xml")
	public ResponseEntity<String> purgeVirtualMachines(HttpServletRequest request) {
		LOG.info("============= purgeVirtualMachines() called =============");
		Subject currentUser = SecurityUtils.getSubject();
		if ( !currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR) ) {
			return responseWriter(currentUser, null, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
		}
		
		LOG.info("====================== DONE !!! =========================");
		
		return null;
	}
}
