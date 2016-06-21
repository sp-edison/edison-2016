/**
 * 
 */
package kisti.edison.cloud.web;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Callback;
import kisti.edison.cloud.model.Count;
import kisti.edison.cloud.model.Simulation;
import kisti.edison.cloud.model.SimulationInfo;
import kisti.edison.cloud.model.SimulationInfoList;
import kisti.edison.cloud.service.SimulationService;
import kisti.edison.cloud.web.RestController.SORT;

/**
 * @author root
 * 
 */
@Controller
public class SimulationContoller extends RestController {
	private SimulationService simulationService;

	private enum FIELD {
		title("title"),
		userId("userId"),
		lastModifed("lastModified");
		
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
	
	public SimulationService getSimulationService() {
		return simulationService;
	}

	@Autowired
	public void setSimulationService(SimulationService simulationService) {
		this.simulationService = simulationService;
	}

	private SimulationInfo extract(Simulation simulation) {
		return new SimulationInfo(simulation);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/simulation/query", headers = "Accept=application/json, application/xml")
	public ResponseEntity<SimulationInfoList> querySimulations(
			@RequestParam(value = "userId", required = true) String userId,
			HttpServletRequest request) {
		LOG.info("querySimulations() called");
		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		if (userId == null || userId.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		List<Simulation> sims = simulationService
				.findSimulationsByUserId(userId, null, null);
		List<SimulationInfo> list = new LinkedList<SimulationInfo>();
		for (Simulation sim : sims) {
			list.add(extract(sim));
		}

		SimulationInfoList sim_list = new SimulationInfoList(list);
		return responseWriter(currentUser, sim_list, new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/simulation/list", headers = "Accept=application/json, application/xml")
	public ResponseEntity<SimulationInfoList> getSimulations(
			@RequestParam(value="userId", required = false) String userId,
			@RequestParam(value="startIndex", required = false) String startIndex,
			@RequestParam(value="maxResults", required = false) String maxResults,
			@RequestParam(value = "field", required = false) String field,
			@RequestParam(value = "sort", required = false) String sort,
			HttpServletRequest request) {
		LOG.info("getSimulations()");
		Subject currentUser = SecurityUtils.getSubject();
		String queryUserId = null;
		if(userId != null && !userId.isEmpty()) {
			queryUserId = userId;
		}
		
		String mField = null;
		String mSort = null;
		
		if(field == null || field.isEmpty()) {
			mField = "lastModified";
		} else {
			mField = field;
		}
		
		if(sort == null || sort.isEmpty()) {
			mSort = "desc";
		} else {
			mSort = sort;
		}
		
		if ( !(FIELD.fromString(mField) instanceof FIELD) || !(SORT.fromString(mSort) instanceof SORT) ) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		LOG.info("startIndex : " + startIndex);
		LOG.info("maxResults : " + maxResults);
		

		List<Simulation> sims = null;
		// normal users
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			if(queryUserId == null) {
				if (startIndex != null && !startIndex.isEmpty()
						&& maxResults != null && !maxResults.isEmpty()) {
					if (Integer.parseInt(startIndex) < 0 || Integer.parseInt(maxResults) < 1) {
						return responseWriter(currentUser, null, new HttpHeaders(),
								HttpStatus.BAD_REQUEST);
					}
					sims = simulationService.querySimulations(currentUser.getPrincipal().toString(), mField, mSort, Integer.parseInt(startIndex), Integer.parseInt(maxResults));
				} else if ((startIndex == null || startIndex.isEmpty())
						&& (maxResults != null && !maxResults.isEmpty())) {
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.BAD_REQUEST);
				} else if ((startIndex != null && !startIndex.isEmpty())
						&& (maxResults == null || maxResults.isEmpty())) {
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.BAD_REQUEST);
				} else {
					sims = simulationService.findSimulationsByUserId(currentUser.getPrincipal().toString(), mField, mSort);
				}
			}
			else {
				if (!queryUserId.equals(currentUser.getPrincipal().toString())) {
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.UNAUTHORIZED);
				}
				
				if (startIndex != null && !startIndex.isEmpty()
						&& maxResults != null && !maxResults.isEmpty()) {
					if (Integer.parseInt(startIndex) < 0 || Integer.parseInt(maxResults) < 1) {
						return responseWriter(currentUser, null, new HttpHeaders(),
								HttpStatus.BAD_REQUEST);
					}
					sims = simulationService.querySimulations(queryUserId, mField, mSort, Integer.parseInt(startIndex), Integer.parseInt(maxResults));
				} else if ((startIndex == null || startIndex.isEmpty())
						&& (maxResults != null && !maxResults.isEmpty())) {
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.BAD_REQUEST);
				} else if ((startIndex != null && !startIndex.isEmpty())
						&& (maxResults == null || maxResults.isEmpty())) {
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.BAD_REQUEST);
				} else {
					sims = simulationService.findSimulationsByUserId(queryUserId, mField, mSort);
				}
			}
		} else {
			
			LOG.info("userId : " + queryUserId);
			LOG.info("field : " + mField);
			LOG.info("sort : " + mSort);
			
			if(queryUserId == null) {
				if (startIndex != null && !startIndex.isEmpty()
						&& maxResults != null && !maxResults.isEmpty()) {
					if (Integer.parseInt(startIndex) < 0 || Integer.parseInt(maxResults) < 1) {
						return responseWriter(currentUser, null, new HttpHeaders(),
								HttpStatus.BAD_REQUEST);
					}
					sims = simulationService.querySimulations("*", mField, mSort, Integer.parseInt(startIndex), Integer.parseInt(maxResults));
				} else if ((startIndex == null || startIndex.isEmpty())
						&& (maxResults != null && !maxResults.isEmpty())) {
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.BAD_REQUEST);
				} else if ((startIndex != null && !startIndex.isEmpty())
						&& (maxResults == null || maxResults.isEmpty())) {
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.BAD_REQUEST);
				} else {
					sims = simulationService.getSimulations(mField, mSort);
				}
			}
			else {
				if (startIndex != null && !startIndex.isEmpty()
						&& maxResults != null && !maxResults.isEmpty()) {
					if (Integer.parseInt(startIndex) < 0 || Integer.parseInt(maxResults) < 1) {
						return responseWriter(currentUser, null, new HttpHeaders(),
								HttpStatus.BAD_REQUEST);
					}
					sims = simulationService.querySimulations(queryUserId, mField, mSort, Integer.parseInt(startIndex), Integer.parseInt(maxResults));
				} else if ((startIndex == null || startIndex.isEmpty())
						&& (maxResults != null && !maxResults.isEmpty())) {
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.BAD_REQUEST);
				} else if ((startIndex != null && !startIndex.isEmpty())
						&& (maxResults == null || maxResults.isEmpty())) {
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.BAD_REQUEST);
				} else {
					sims = simulationService.findSimulationsByUserId(queryUserId, mField, mSort);
				}
			}
		}

		List<SimulationInfo> list = new LinkedList<SimulationInfo>();
		for (Simulation sim : sims) {
			list.add(extract(sim));
		}

		SimulationInfoList sim_list = new SimulationInfoList(list);
		return responseWriter(currentUser, sim_list, new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/simulation/count", headers = "Accept=application/json, application/xml")
	public ResponseEntity<Count> getSimulationsCount(HttpServletRequest request) {
		LOG.info("getSimulationsCount() called");
		Subject currentUser = SecurityUtils.getSubject();
		String userId = currentUser.getPrincipal().toString();

		int simCnt = 0;
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			simCnt = simulationService.getSimulationsCount(userId, false);
		} else {
			simCnt = simulationService.getSimulationsCount(userId, true);
		}

		return responseWriter(currentUser, new Count(simCnt),
				new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/simulation/{uuid}/info", headers = "Accept=application/json, application/xml")
	public ResponseEntity<SimulationInfo> getSimulation(
			@PathVariable String uuid, HttpServletRequest request) {
		LOG.info("getSimulation() : " + uuid);
		Subject currentUser = SecurityUtils.getSubject();

		if (uuid == null || uuid.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		Simulation simulation = simulationService.getSimulation(uuid);

		if (currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, extract(simulation),
					new HttpHeaders(), HttpStatus.OK);
		} else {
			if (!(simulation.getUserId().equals(currentUser.getPrincipal()
					.toString()))) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.UNAUTHORIZED);
			} else {
				return responseWriter(currentUser, extract(simulation),
						new HttpHeaders(), HttpStatus.OK);
			}
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/simulation/create", headers = "Accept=application/json, application/xml")
	public ResponseEntity<SimulationInfo> createSimulation(
			@RequestParam(value = "zone", required = false) String zone,
			@RequestParam(value = "url", required = false) String url,
//			@RequestParam(value = "ip", required = false) String ip,
//			@RequestParam(value = "port", required = false) String port,
			@RequestParam(value = "gid", required = false) String gid,
			@RequestBody Simulation simulation, HttpServletRequest request) {
		LOG.info("createSimulation() called");
		Subject currentUser = SecurityUtils.getSubject();

		if ( simulation == null || simulation.getTitle().isEmpty() ) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		if(simulation.getSolverId() == null || simulation.getSolverId().isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		if(zone == null || zone.isEmpty()) {
			zone = "ko";
		}
		
		LOG.info(simulation.toString());
		simulation.setUserId(currentUser.getPrincipal().toString());
		Simulation createdSim = simulationService.createSimulation(simulation, zone);

		if(createdSim != null) {
			LOG.info(createdSim.toString());

			/*
			 * add callback
			 */
//			if (ip != null && port != null && gid != null)
			if (url != null && gid != null)
			{
//				Callback callback = new Callback(ip, port, gid, createdSim.getUuid());
				Callback callback = new Callback(url, gid, createdSim.getUuid());
				LOG.info(callback.toString());
				simulationService.addCallback(callback);
			}

			return responseWriter(currentUser, extract(createdSim),
					new HttpHeaders(), HttpStatus.CREATED);
		}
		else {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/simulation/{uuid}", headers = "Accept=application/json, application/xml")
	public ResponseEntity<SimulationInfo> deleteSimulation(
			@PathVariable String uuid, HttpServletRequest request) {
		LOG.info("deleteSimulation() called");
		Subject currentUser = SecurityUtils.getSubject();
		if (uuid == null || uuid.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		Simulation simulation = simulationService.getSimulation(uuid);
		if (simulation == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		if (simulation.getJobs().size() != 0) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		if (currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			simulationService.deleteSimulation(uuid);
		} else {
			if (!(simulation.getUserId().equals(currentUser.getPrincipal()
					.toString()))) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.UNAUTHORIZED);
			}
			simulationService.deleteSimulation(uuid);
		}

		return responseWriter(currentUser, null, new HttpHeaders(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/simulation/{uuid}", headers = "Accept=application/json, application/xml")
	public ResponseEntity<SimulationInfo> updateSimulation(
			@PathVariable String uuid, @RequestBody Simulation simulation,
			HttpServletRequest request) {
		LOG.info("updateSimulation() called");
		Subject currentUser = SecurityUtils.getSubject();

		if (uuid == null || uuid.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		if (simulation == null || simulation.getTitle().isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		Simulation storedSim = simulationService.getSimulation(uuid);
		Simulation updatedSim = null;

		simulation.setUuid(uuid);
		if (currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			updatedSim = simulationService.updateSimulation(simulation);
		} else {
			if (!(storedSim.getUserId().equals(currentUser.getPrincipal()
					.toString()))) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.UNAUTHORIZED);
			}
			updatedSim = simulationService.updateSimulation(simulation);
		}

		return responseWriter(currentUser, extract(updatedSim),
				new HttpHeaders(), HttpStatus.OK);
	}
}
