/**
 * 
 */
package kisti.edison.cloud.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kisti.edison.cloud.env.Cloud;
import kisti.edison.cloud.model.Callback;
import kisti.edison.cloud.model.Cluster;
import kisti.edison.cloud.model.Count;
import kisti.edison.cloud.model.FileItem;
import kisti.edison.cloud.model.FileItemList;
import kisti.edison.cloud.model.Job;
import kisti.edison.cloud.model.JobCount;
import kisti.edison.cloud.model.JobStatus;
import kisti.edison.cloud.model.JobStatusList;
import kisti.edison.cloud.model.Simulation;
import kisti.edison.cloud.model.User;
import kisti.edison.cloud.service.ClusterService;
import kisti.edison.cloud.service.JobService;
import kisti.edison.cloud.service.RepositoryService;
import kisti.edison.cloud.service.SimulationService;
import kisti.edison.cloud.service.UserService;
import kisti.edison.cloud.web.RestController.SORT;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * @author root
 * 
 */
@Controller
public class JobController extends RestController {
	private static String NPROCS_STR = "np";
	private JobService jobService;
	private SimulationService simulationService;
	private RepositoryService repositoryService;
	private UserService userService;

	private enum FIELD {
		title("title"),
		state("state"),
		jobId("jobId"),
		submittedTime("submittedTime");
		
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
	
	public JobService getJobService() {
		return jobService;
	}

	@Autowired
	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}

	public SimulationService getSimulationService() {
		return simulationService;
	}

	@Autowired
	public void setSimulationService(SimulationService simulationService) {
		this.simulationService = simulationService;
	}

	public RepositoryService getRepositoryService() {
		return repositoryService;
	}

	@Autowired
	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	public UserService getUserService() {
		return userService;
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private ClusterService clusterService;

	public ClusterService getClusterService() {
		return clusterService;
	}
	
	@Autowired
	public void setClusterService(ClusterService clusterService) {
		this.clusterService = clusterService;
	}
	
	private JobStatus getJobStatus(Job job) {
		JobStatus jobStatus = new JobStatus();
		jobStatus.setTitle(job.getTitle());
		jobStatus.setDescription(job.getDescription());
		jobStatus.setUuid(job.getUuid());
		jobStatus.setSimulationUuid(job.getSimulation().getUuid());

		jobStatus.setJobId(job.getJobId());
		jobStatus.setStatus(job.getState());
		// jobStatus.setExecutable(job.getExecutable());
		// jobStatus.setExecution(job.getExecution());
		jobStatus.setExecutable(null);
		jobStatus.setExecution(null);
		jobStatus.setWorkingDir(job.getWorkingDir());
		jobStatus.setZipFilePath(job.getZipFilePath());

		// java.text.SimpleDateFormat format = new
		// java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (job.getSubmittedTime() != null) {
			// jobStatus.setSubmittedTime(format.format(job.getSubmittedTime()));
			jobStatus.setSubmittedTime(job.getSubmittedTime());
		}
		if (job.getStartTime() != null) {
			// jobStatus.setStartTime(format.format(job.getStartTime()));
			jobStatus.setStartTime(job.getStartTime());
		}
		if (job.getEndTime() != null) {
			// jobStatus.setEndTime(format.format(job.getEndTime()));
			jobStatus.setEndTime(job.getEndTime());
		}

		jobStatus.setSolverId(job.getSolverId());
		jobStatus.setSolverName(job.getSolverName());
		jobStatus.setCyberLabId(job.getCyberLabId());
		jobStatus.setClassId(job.getClassId());
		jobStatus.setCluster(job.getCluster());
		return jobStatus;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/job/count", headers = "Accept=application/json, application/xml")
	public ResponseEntity<JobCount> getAllJobsCount(HttpServletRequest request) {
		//UNKNOWN, INITIALIZE_FAILED, INITIALIZED, SUBMISSION_FAILED, QUEUED, RUNNING, SUSPENDED, CANCELED, SUCCESS, FAILED
		LOG.info("getAllJobsCount() called");
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.hasRole(Cloud.ROLE_ADMINISTRATOR)) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}
		
		int jobCnt = jobService.getJobCount(null);
		JobCount jCount = new JobCount();
		jCount.setCount(jobCnt);
		
		for(Job.JobState s : Job.JobState.values()) {
			if(s.name().equals(Job.JobState.UNKNOWN.toString())) {
				jCount.setUNKNOWN(jobService.getJobCount(s.toString()));
			}
			else if(s.name().equals(Job.JobState.INITIALIZE_FAILED.toString())) {
				jCount.setINITIALIZE_FAILED(jobService.getJobCount(s.toString()));
			}
			else if(s.name().equals(Job.JobState.INITIALIZED.toString())) {
				jCount.setINITIALIZED(jobService.getJobCount(s.toString()));
			}
			else if(s.name().equals(Job.JobState.SUBMISSION_FAILED.toString())) {
				jCount.setSUBMISSION_FAILED(jobService.getJobCount(s.toString()));
			}
			else if(s.name().equals(Job.JobState.QUEUED.toString())) {
				jCount.setQUEUED(jobService.getJobCount(s.toString()));
			}
			else if(s.name().equals(Job.JobState.RUNNING.toString())) {
				jCount.setRUNNING(jobService.getJobCount(s.toString()));
			}
			else if(s.name().equals(Job.JobState.SUSPENDED.toString())) {
				jCount.setSUSPENDED(jobService.getJobCount(s.toString()));
			}
			else if(s.name().equals(Job.JobState.CANCELED.toString())) {
				jCount.setCANCELED(jobService.getJobCount(s.toString()));
			}
			else if(s.name().equals(Job.JobState.SUCCESS.toString())) {
				jCount.setSUCCESS(jobService.getJobCount(s.toString()));
			}
			else if(s.name().equals(Job.JobState.FAILED.toString())) {
				jCount.setFAILED(jobService.getJobCount(s.toString()));
			}
		}
		
		return responseWriter(currentUser, jCount, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/simulation/{sim_uuid}/job/list", headers = "Accept=application/json, application/xml")
	public ResponseEntity<JobStatusList> getJobs(@PathVariable String sim_uuid,
			@RequestParam(value = "field", required = false) String field,
			@RequestParam(value = "sort", required = false) String sort,
			HttpServletRequest request) {
		LOG.info("getJobs() called (sim_uuid : " + sim_uuid + ")");
		Subject currentUser = SecurityUtils.getSubject();
		if (sim_uuid == null || sim_uuid.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		Simulation sim = simulationService.getSimulation(sim_uuid);
		if (sim == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		
		String mField = null;
		String mSort = null;
		
		if(field == null || field.isEmpty()) {
			mField = "submittedTime";
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
		
		LOG.info("field : " + mField);
		LOG.info("sort  : " + mSort);
		
		List<JobStatus> jobStatues = new LinkedList<JobStatus>();
		
		Map<Object, List<Job>> sortedJobs = null;
		
		if(mSort.equals("asc")) {
			sortedJobs = new TreeMap<Object, List<Job>>();
		}
		else {
			sortedJobs = new TreeMap<Object, List<Job>>(Collections.reverseOrder());
		}
		
		for(Job job : sim.getJobs()) {
			if(mField.equals("submittedTime")) {
				
				List<Job> lJobs = sortedJobs.get(job.getSubmittedTime());
				if(lJobs == null) {
					lJobs = new LinkedList<Job>();
				}
				lJobs.add(job);
				sortedJobs.put(job.getSubmittedTime(), lJobs);
			}
			else if(mField.equals("title")) {
				List<Job> lJobs = sortedJobs.get(job.getTitle());
				if(lJobs == null) {
					lJobs = new LinkedList<Job>();
				}
				lJobs.add(job);
				sortedJobs.put(job.getTitle(), lJobs);
			}
			else if(mField.equals("state")) {
				
				List<Job> lJobs = sortedJobs.get(job.getState());
				if(lJobs == null) {
					lJobs = new LinkedList<Job>();
				}
				lJobs.add(job);
				sortedJobs.put(job.getState(), lJobs);
				
			}
			else if(mField.equals("jobId")) {
				List<Job> lJobs = sortedJobs.get(job.getJobId());
				if(lJobs == null) {
					lJobs = new LinkedList<Job>();
				}
				lJobs.add(job);
				sortedJobs.put(job.getJobId(), lJobs);
			}
		}
		
		Iterator<Object> sortedJobsIter = sortedJobs.keySet().iterator();
		
		while(sortedJobsIter.hasNext()) {
			Object key = sortedJobsIter.next();
			List<Job> values = (List<Job>)sortedJobs.get(key);
			for(Job j : values) {
				JobStatus js = getJobStatus(j);
				jobStatues.add(js);
			}
		}
		
		if (currentUser.hasRole(Cloud.getInstance().getProp("user.role.admin"))) {
			return responseWriter(currentUser, new JobStatusList(jobStatues),
					new HttpHeaders(), HttpStatus.OK);
		} else {
			if (!sim.getUserId().equals(currentUser.getPrincipal().toString())) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.UNAUTHORIZED);
			}
			return responseWriter(currentUser, new JobStatusList(jobStatues),
					new HttpHeaders(), HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/simulation/{sim_uuid}/job/count", headers = "Accept=application/json, application/xml")
	public ResponseEntity<Count> getJobsCount(@PathVariable String sim_uuid,
			HttpServletRequest request) {
		LOG.info("getJobsCount() called (sim_uuid : " + sim_uuid + ")");
		Subject currentUser = SecurityUtils.getSubject();
		if (sim_uuid == null || sim_uuid.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		Simulation sim = simulationService.getSimulation(sim_uuid);
		if (sim == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		if (!currentUser
				.hasRole(Cloud.getInstance().getProp("user.role.admin"))) {
			if (!sim.getUserId().equals(currentUser.getPrincipal().toString())) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.UNAUTHORIZED);
			}
		}

		int jobCnt = 0;
		jobCnt = sim.getJobs().size();
		return responseWriter(currentUser, new Count(jobCnt),
				new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/simulation/{sim_uuid}/job/submit", headers = "Accept=application/json, application/xml")
	public ResponseEntity<JobStatus> submit(@PathVariable String sim_uuid,
			@RequestBody Job job, HttpServletRequest request) {
		LOG.info("submit() called");
		Subject currentUser = SecurityUtils.getSubject();

		LOG.info(job.toString());
		if (sim_uuid == null || sim_uuid.isEmpty()) {
			LOG.info("simUUID is null");
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		if( job.getCluster() == null || job.getCluster().isEmpty() ) {
			LOG.info("cluster is null");
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		if ((job.getTitle() == null || job.getTitle().isEmpty())
				|| (job.getType() == null || !(job.getType() instanceof Job.JobType))) {
			LOG.info("job title or type is null");
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		if( (job.getExecutable() == null || job.getExecutable().isEmpty()) ||
				(job.getExecution() == null) ) {
			LOG.info("job executable is null");
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		if (job.getType().equals(Job.JobType.PARALLEL)
				&& (job.getAttributes().get(NPROCS_STR) == null || job
						.getAttributes().get(NPROCS_STR).isEmpty())) {
			LOG.info("parallel job, but nprocs is null");
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		if (job.getType().equals(Job.JobType.SEQUENTIAL)) {
			job.setnProcs(1);
		} else if (job.getType().equals(Job.JobType.PARALLEL)) {
			
			if ((job.getCategory() == null) || !(job.getCategory() instanceof Job.JobCategory)) {
				LOG.info("job category is null");
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.BAD_REQUEST);
			}
			
			if (job.getAttributes().get(NPROCS_STR) == null || job
					.getAttributes().get(NPROCS_STR).isEmpty()) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.BAD_REQUEST);
			}
			job.setnProcs(Integer.parseInt(job.getAttributes().get("np")));
		} else {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		if (job.getSolverId() == null || job.getSolverId().isEmpty()) {
			LOG.info("job solerId is null");
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		if (job.getSolverName() == null || job.getSolverName().isEmpty()) {
			LOG.info("job solerName is null");
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		// TODO : normal users have no cyberLabId and/or classId
		if(job.getCyberLabId() == null || job.getCyberLabId().isEmpty()) {
			LOG.info("job cyberLabId is null");
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		if(job.getClassId() == null || job.getClassId().isEmpty()) {
			LOG.info("job classId is null");
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}
		
		Cluster cluster = clusterService.findCluster(job.getCluster());
		
		if(cluster == null) {
			LOG.info("cluster can not be found");
			return responseWriter(currentUser, null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}

		if (job.getTitle() != null) {
			job.setTitle(job.getTitle().trim());
		}

		if (job.getExecutable() != null) {
			job.setExecutable(job.getExecutable().trim());
		}

		if (job.getExecution() != null) {
			job.setExecution(job.getExecution().trim());
		}

		
		/*
		User user = userService.getUser(currentUser.getPrincipal().toString());
		
		if (user.getCyberLabId() == null || user.getCyberLabId().isEmpty()) {
			job.setCyberLabId(user.getAffiliation());
		} else {
			job.setCyberLabId(user.getCyberLabId());
		}
		if (user.getClassId() == null || user.getClassId().isEmpty()) {
			job.setClassId(user.getClassName());
		} else {
			job.setClassId(user.getClassId());
		}
		*/
		
		
		job.setUserId(currentUser.getPrincipal().toString());
		Job createdJob = jobService.createJob(cluster, sim_uuid, job);
		Callback callback = simulationService.getCallback(sim_uuid);
		if ( callback != null )
		{
			simulationService.pushCallback(callback, sim_uuid, job);
		}

		LOG.info(createdJob.toString());
		// LOG.info( Job.Map2Str(job.getFiles()) );
		// LOG.info( Job.Str2Map( Job.Map2Str(job.getFiles()) ) );
		LOG.info("jobUUID : " + createdJob.getUuid() + " created done!!!!!!!!!!!!!!!");
		return responseWriter(currentUser, getJobStatus(createdJob),
				new HttpHeaders(), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/simulation/{sim_uuid}/job/{job_uuid}/cancel", headers = "Accept=application/json, application/xml")
	public ResponseEntity<JobStatus> cancel(@PathVariable String sim_uuid,
			@PathVariable String job_uuid, HttpServletRequest request) {
		LOG.info("cancel() called (" + job_uuid + ")");
		Job cancelingJob = null;
		Subject currentUser = SecurityUtils.getSubject();
		if (sim_uuid == null || sim_uuid.isEmpty() || job_uuid == null
				|| job_uuid.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		Job job = jobService.findJobByUUID(job_uuid);
		if (job == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

/*		if (job.getSimulation() == null) {
			LOG.info("simulation is null");
		} else {
			LOG.info("sim uuid : " + job.getSimulation().getUuid());
		}
*/
		
		Cluster cluster = clusterService.findCluster(job.getCluster());
		if(cluster == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
		
		if (job.getState().equals(Job.JobState.QUEUED)
				|| job.getState().equals(Job.JobState.RUNNING)) {
			if (currentUser.hasRole(Cloud.getInstance().getProp(
					"user.role.admin"))) {
				cancelingJob = jobService.cancel(cluster, job);
			} else {
				if (!job.getUserId().equals(
						currentUser.getPrincipal().toString())) {
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.UNAUTHORIZED);
				}
				cancelingJob = jobService.cancel(cluster, job);
			}
			
			if (cancelingJob == null) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.BAD_REQUEST);
			}
			else
			{
				Callback callback = simulationService.getCallback(sim_uuid);
				if ( callback != null )
				{
					simulationService.pushCallback(callback, sim_uuid, cancelingJob);
				}
			}
			return responseWriter(currentUser, getJobStatus(cancelingJob),
					new HttpHeaders(), HttpStatus.OK);
		} else {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.METHOD_NOT_ALLOWED);
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/simulation/{sim_uuid}/job/{job_uuid}/status", headers = "Accept=application/json, application/xml")
	public ResponseEntity<JobStatus> getJob(@PathVariable String sim_uuid,
			@PathVariable String job_uuid, HttpServletRequest request) {
		LOG.info("getJob() called (" + job_uuid + ")");
		Subject currentUser = SecurityUtils.getSubject();
		if (sim_uuid == null || sim_uuid.isEmpty() || job_uuid == null
				|| job_uuid.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		Job job = jobService.findJobByUUID(job_uuid);
		if (job == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}
/*
		if (job.getSimulation() == null) {
			LOG.debug("simulation is null");
		} else {
			LOG.debug("sim uuid : " + job.getSimulation().getUuid());
		}

		Cluster cluster = clusterService.findCluster(job.getCluster());
		if(cluster == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
		
		Job renewedJob = null;
		if(job.getState().equals(Job.JobState.FAILED) || 
				job.getState().equals(Job.JobState.CANCELED) ||
				job.getState().equals(Job.JobState.INITIALIZE_FAILED) || 
				job.getState().equals(Job.JobState.SUBMISSION_FAILED) ||
				job.getState().equals(Job.JobState.SUCCESS)) {
			renewedJob = job;
		}
		else {
			renewedJob = jobService.update(cluster, job);
		}

		
		if(renewedJob == null) {
			return responseWriter(currentUser, getJobStatus(job), new HttpHeaders(),
					HttpStatus.OK);
		}
*/
		
		Job renewedJob = job;
		
		if (currentUser.hasRole(Cloud.getInstance().getProp("user.role.admin"))) {
			LOG.info(job.toString());
			return responseWriter(currentUser, getJobStatus(renewedJob),
					new HttpHeaders(), HttpStatus.OK);
		} else {
			if (!job.getUserId().equals(currentUser.getPrincipal().toString())) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.UNAUTHORIZED);
			} else {
				LOG.info(job.toString());
				return responseWriter(currentUser, getJobStatus(renewedJob),
						new HttpHeaders(), HttpStatus.OK);		
			}
		}
	}
	
	@RequestMapping(method = RequestMethod.GET,
					value = "/job/{job_uuid}/log/error",
					headers = "Accept=text/plain")
	public ResponseEntity<String> getErrorLog(@PathVariable String job_uuid, HttpServletRequest request) {
		LOG.info("getErrorLog() called : " + job_uuid);
		Subject currentUser = SecurityUtils.getSubject();
		if (job_uuid == null || job_uuid.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		Job job = jobService.findJobByUUID(job_uuid);
		if (job == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}
		
		Cluster cluster = clusterService.findCluster(job.getCluster());
		if(cluster == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
		
		/* merge output and error log */
		byte[] errlog = jobService.getErrorLog(cluster, job);
		byte[] outlog = jobService.getOutputLog(cluster, job);
		
		String log = null;
		
		if(errlog != null) 
			log = new String(errlog);
		if(outlog != null)
			log = log + new String(outlog);
		
		if(log == null || log.isEmpty()) {
			log = "No Contents!";
		}
		
		log = log.replaceAll("'", " ");
		log = log.replaceAll("\"", " ");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		headers.setContentLength(log.length());
		
		if (currentUser.hasRole(Cloud.getInstance().getProp("user.role.admin"))) {
			return responseWriter(currentUser, log, headers, HttpStatus.OK);
		}

		if (!job.getUserId().equals(currentUser.getPrincipal().toString())) {
			return responseWriter(currentUser, null, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
		}
		

		return responseWriter(currentUser, log, headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET,
			value = "/job/{job_uuid}/log/output",
			headers = "Accept=text/plain")
	public ResponseEntity<String> getOutputLog(@PathVariable String job_uuid, HttpServletRequest request) {
		LOG.info("getOutputLog() called : " + job_uuid);
		Subject currentUser = SecurityUtils.getSubject();
		if (job_uuid == null || job_uuid.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		Job job = jobService.findJobByUUID(job_uuid);
		if (job == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}
		
		Cluster cluster = clusterService.findCluster(job.getCluster());
		if(cluster == null) {
			return responseWriter(currentUser, null, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
		
		byte[] log = jobService.getOutputLog(cluster, job);
		if(log == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		headers.setContentLength(log.length);
		
		if (currentUser.hasRole(Cloud.getInstance().getProp("user.role.admin"))) {
			return responseWriter(currentUser, new String(log), headers, HttpStatus.OK);
		}

		if (!job.getUserId().equals(currentUser.getPrincipal().toString())) {
			return responseWriter(currentUser, null, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
		}
		
		String result = new String(log);
		result = result.replaceAll("'", " ");
		result = result.replaceAll("\"", " ");
		return responseWriter(currentUser, result, headers, HttpStatus.OK);
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/job/{job_uuid}/input", headers = "Accept=application/json, application/xml")
	public ResponseEntity<FileItemList> getJobInputs(
			@PathVariable String job_uuid, HttpServletRequest request) {
		LOG.info("JobController::getJobInputs() called (" + job_uuid + ")");
		Subject currentUser = SecurityUtils.getSubject();
		if (job_uuid == null || job_uuid.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		Job job = jobService.findJobByUUID(job_uuid);
		if (job == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		Map<String, String> files = Job.Str2Map(job.getFileStr());
		List<FileItem> fileItems = new LinkedList<FileItem>();

		Iterator<String> iter = files.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String fileId = files.get(key);
			fileItems.add(repositoryService.find(fileId));
		}

		if (currentUser.hasRole(Cloud.getInstance().getProp("user.role.admin"))) {
			return responseWriter(currentUser, new FileItemList(fileItems),
					new HttpHeaders(), HttpStatus.OK);
		}

		if (!job.getUserId().equals(currentUser.getPrincipal().toString())) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		return responseWriter(currentUser, new FileItemList(fileItems),
				new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/job/{job_uuid}/output", headers = "Accept=application/json, application/xml")
	public ResponseEntity<FileItemList> getJobOutputs(
			@PathVariable String job_uuid,
			@RequestParam(value = "dir", required = true) String dir,
			HttpServletRequest request) {
		LOG.info("JobController::getJobOutputs() called (" + job_uuid + ")");
		Subject currentUser = SecurityUtils.getSubject();
		if (job_uuid == null || job_uuid.isEmpty() || dir == null
				|| dir.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		Job job = jobService.findJobByUUID(job_uuid);
		if (job == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		List<FileItem> fileItems = null;
		try {
			fileItems = repositoryService.getFiles(job.getWorkingDir() + dir);
			if (fileItems == null) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.BAD_REQUEST);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (currentUser.hasRole(Cloud.getInstance().getProp("user.role.admin"))) {
			return responseWriter(currentUser, new FileItemList(fileItems),
					new HttpHeaders(), HttpStatus.OK);
		}

		if (!job.getUserId().equals(currentUser.getPrincipal().toString())) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		return responseWriter(currentUser, new FileItemList(fileItems),
				new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/job/{job_uuid}/file", headers = "Accept=application/json, application/xml")
	public ResponseEntity<FileItem> getJobFile(
			@PathVariable String job_uuid,
			@RequestParam(value = "name", required = true) String name,
			HttpServletRequest request) {
		LOG.info("JobController::getJobFile() called (" + job_uuid + ")");
		Subject currentUser = SecurityUtils.getSubject();
		if (job_uuid == null || job_uuid.isEmpty() || name == null || name.isEmpty()) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.BAD_REQUEST);
		}

		Job job = jobService.findJobByUUID(job_uuid);
		if (job == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		FileItem fileItem = null;
		try {
			fileItem = repositoryService.getFile(job.getWorkingDir() + name);
			if (fileItem == null) {
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.BAD_REQUEST);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (currentUser.hasRole(Cloud.getInstance().getProp("user.role.admin"))) {
			return responseWriter(currentUser, fileItem, new HttpHeaders(), HttpStatus.OK);
		}

		if (!job.getUserId().equals(currentUser.getPrincipal().toString())) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}

		return responseWriter(currentUser, fileItem, new HttpHeaders(), HttpStatus.OK);
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/job/{job_uuid}/download/zip")
	public void downloadJobOutputZip(@PathVariable String job_uuid,
			HttpServletRequest request, HttpServletResponse response) {
		LOG.info("JobController::downloadJobOutputZip() called (" + job_uuid
				+ ")");
		Subject currentUser = SecurityUtils.getSubject();
		if (job_uuid == null || job_uuid.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return;
		}

		Job job = jobService.findJobByUUID(job_uuid);
		if (job == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return;
		}

		String zipPath = job.getWorkingDir()
				+ Cloud.getInstance().getProp("output.zipfile");
		String fileId = Base64.encode(zipPath.getBytes());

		FileItem item = repositoryService.find(fileId);
		if (item == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return;
		}

		LOG.info(item.toString());

		//byte[] contents = null;
		File inf = null;
		FileInputStream fis = null;
		try {
			//contents = repositoryService.read(item);
			 inf = new File(item.getPath());
			 fis = new FileInputStream(inf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return;
		}

		response.setContentType(item.getType());
		response.setContentLength((int)inf.length());
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ item.getName() + "\"");
		try {
			FileCopyUtils.copy(fis, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			if (currentUser.isAuthenticated())
				currentUser.logout();
		}
		return;

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/simulation/{sim_uuid}/job/{job_uuid}")
	public ResponseEntity<String> deleteJobDir(@PathVariable String job_uuid,
			HttpServletRequest request, HttpServletResponse response) {
		LOG.info("JobController::deleteJobDir() called (" + job_uuid
				+ ")");
		Subject currentUser = SecurityUtils.getSubject();
		if (job_uuid == null || job_uuid.isEmpty()) {
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		Job job = jobService.findJobByUUID(job_uuid);
		if (job == null) {
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.NOT_FOUND);
		}

		File workingDir = new File(job.getWorkingDir());
		String canonicalPath = null;
		try {
			canonicalPath = workingDir.getCanonicalPath();

			if (canonicalPath == null) {
				LOG.error("Can't get canonicalPath : " + job.getWorkingDir());
				if (currentUser.isAuthenticated())
					currentUser.logout();
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.UNAUTHORIZED);
			}
			else {
				String clusterName = Cloud.getInstance().getProp("resources").split(":")[0];
				String baseDir = "/EDISON"; 
				List<Cluster> clusters = clusterService.getClusters();

				for(Cluster c : clusters){
					if(c.getName().equals(clusterName)){
						baseDir = c.getBaseDir();
						break;
					}
				}
				User user = userService.getUser(currentUser.getPrincipal().toString());
				String userHomeDir = baseDir + user.getStorageSource();
				File homeDir = new File(userHomeDir);
				if(canonicalPath.startsWith(homeDir.getCanonicalPath()) == false) {
					LOG.error("Attack Detection. Requested filePath : " + job.getWorkingDir());
					if (currentUser.isAuthenticated())
						currentUser.logout();
					return responseWriter(currentUser, null, new HttpHeaders(),
							HttpStatus.UNAUTHORIZED);
				}
				repositoryService.delete(canonicalPath);
				return responseWriter(currentUser, null, new HttpHeaders(),
						HttpStatus.OK);	
			}
		} catch (IOException e) {
			LOG.error("getCanonicalPath fail : " + job.getWorkingDir());
			if (currentUser.isAuthenticated())
				currentUser.logout();
			return responseWriter(currentUser, null, new HttpHeaders(),
					HttpStatus.UNAUTHORIZED);
		}
	}
	/*
	 * @RequestMapping(method=RequestMethod.GET,
	 * value="/simulation/{sim_uuid}/job/{job_uuid}/info",
	 * headers="Accept=application/json, application/xml") public
	 * ResponseEntity<Job> getJobDetails(@PathVariable String sim_uuid,
	 * @PathVariable String job_uuid, HttpServletRequest request) {
	 * LOG.info("JobController::getJobDetails() called (" + job_uuid + ")");
	 * Subject currentUser = SecurityUtils.getSubject(); if (sim_uuid == null ||
	 * sim_uuid.isEmpty() || job_uuid == null || job_uuid.isEmpty()) { return
	 * responseWriter(currentUser, null, new HttpHeaders(),
	 * HttpStatus.BAD_REQUEST); }
	 * 
	 * Job job = jobService.findJobByUUID(job_uuid); if (job == null) { return
	 * responseWriter(currentUser, null, new HttpHeaders(),
	 * HttpStatus.NOT_FOUND); }
	 * 
	 * Simulation sim = job.getSimulation(); // job.setSimulation(null);
	 * 
	 * if( currentUser.hasRole(Cloud.getInstance().getProp("user.role.admin")) )
	 * { return responseWriter(currentUser, job, new HttpHeaders(),
	 * HttpStatus.OK); }
	 * 
	 * if( !job.getUserId().equals(currentUser.getPrincipal().toString()) ) {
	 * return responseWriter(currentUser, null, new HttpHeaders(),
	 * HttpStatus.UNAUTHORIZED); } return responseWriter(currentUser, job, new
	 * HttpHeaders(), HttpStatus.OK); }
	 */

	/*
	 * @RequestMapping(method=RequestMethod.GET,
	 * value="/job/user/{userId}/list",
	 * headers="Accept=application/json, application/xml") public
	 * ResponseEntity<JobStatusList> findJobsByUserId(@PathVariable String
	 * userId, HttpServletRequest reqeust) {
	 * LOG.info("JobController::findJobsByUserId() called ( userId = " + userId
	 * + ")"); Subject currentUser = SecurityUtils.getSubject(); if (userId ==
	 * null || userId.isEmpty()) { return responseWriter(currentUser, null, new
	 * HttpHeaders(), HttpStatus.BAD_REQUEST); }
	 * 
	 * if( !currentUser.hasRole(Cloud.getInstance().getProp("user.role.admin"))
	 * && ( !userId.equals(currentUser.getPrincipal().toString()) ) ) { return
	 * responseWriter(currentUser, null, new HttpHeaders(),
	 * HttpStatus.FORBIDDEN); }
	 * 
	 * List<Job> jobs = jobService.findJobsByUserId(userId); List<JobStatus>
	 * jobStatues = new LinkedList<JobStatus>();
	 * 
	 * for(Job job : jobs) { JobStatus js = getJobStatus(job);
	 * jobStatues.add(js); }
	 * 
	 * return responseWriter(currentUser, new JobStatusList(jobStatues), new
	 * HttpHeaders(), HttpStatus.OK);
	 * 
	 * }
	 * 
	 * @RequestMapping(method=RequestMethod.GET,
	 * value="/job/group/{groupId}/list",
	 * headers="Accept=application/json, application/xml") public
	 * ResponseEntity<JobStatusList> findJobsByGroupId(@PathVariable String
	 * groupId, HttpServletRequest request) {
	 * LOG.info("JobController::findJobsByGroupId() called ( groupId = " +
	 * groupId + ")"); Subject currentUser = SecurityUtils.getSubject(); if
	 * (groupId == null || groupId.isEmpty()) { return
	 * responseWriter(currentUser, null, new HttpHeaders(),
	 * HttpStatus.BAD_REQUEST); }
	 * 
	 * List<Job> jobs = null; List<JobStatus> jobStatues = null;
	 * 
	 * if( currentUser.hasRole(Cloud.getInstance().getProp("user.role.admin")) )
	 * { jobs = jobService.findJobsByGroupId(groupId); } else { jobs =
	 * jobService.findJobs(currentUser.getPrincipal().toString(), groupId); }
	 * 
	 * jobStatues = new LinkedList<JobStatus>();
	 * 
	 * for(Job job : jobs) { JobStatus js = getJobStatus(job);
	 * jobStatues.add(js); }
	 * 
	 * return responseWriter(currentUser, new JobStatusList(jobStatues), new
	 * HttpHeaders(), HttpStatus.OK); }
	 */

}
