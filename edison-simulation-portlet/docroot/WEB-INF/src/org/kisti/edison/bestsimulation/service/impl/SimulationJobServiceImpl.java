/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.kisti.edison.bestsimulation.service.impl;

import java.text.ParseException;
import java.util.Date;

import org.kisti.edison.bestsimulation.model.SimulationJob;
import org.kisti.edison.bestsimulation.service.SimulationJobLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.base.SimulationJobServiceBaseImpl;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK;
import org.kisti.edison.util.CustomUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.ac.AccessControlled;

/**
 * The implementation of the simulation job remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.bestsimulation.service.SimulationJobService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author mhkang
 * @see org.kisti.edison.bestsimulation.service.base.SimulationJobServiceBaseImpl
 * @see org.kisti.edison.bestsimulation.service.SimulationJobServiceUtil
 */
public class SimulationJobServiceImpl extends SimulationJobServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.bestsimulation.service.SimulationJobServiceUtil} to access the simulation job remote service.
	 */
	
	private static Log log = LogFactoryUtil.getLog(SimulationJobServiceImpl.class);
	
	@AccessControlled(guestAccessEnabled=true)
	public boolean updateSimulationJob(long gid, String simulationUuid, long jobSeqNo, String jobUuid, String jobStatus, String jobStartDt, String jobEndDt) {

		if(gid == 0L) gid = 0;
		if(simulationUuid == null) simulationUuid = "";
		if(jobUuid == null) jobUuid = "";
		if(jobStartDt == null) jobStartDt = ""; 
		if(jobEndDt == null) jobEndDt = ""; 
		
		simulationUuid = simulationUuid.trim();
		jobUuid = jobUuid.trim();
		jobStartDt = jobStartDt.trim(); 
		jobEndDt = jobEndDt.trim();
		
		SimulationJob simulationJob = null;
				
		boolean result = false;
		
		log.debug("==================================================================================================================");
		log.debug("Icebreaker to Portal Sync Start, Info[(simulationUuid)/(jobUuid)/(jobStatus)]");
		log.debug("Info : ("+simulationUuid+") / ("+jobUuid+") / ("+jobStatus+")");
		log.debug("Sync Time : "+new Date());
		log.debug("==================================================================================================================");
		log.debug("jobSeqNo : " + jobSeqNo);
		log.debug("gid : " + gid);
		if(gid > 0 && !simulationUuid.equals("") && !jobUuid.equals("")){
			try{
				SimulationJobPK simulationJobPK = new SimulationJobPK(jobSeqNo, simulationUuid, gid);
				
				simulationJob = SimulationJobLocalServiceUtil.getSimulationJob(simulationJobPK);
				
				String jobStatusPortal = CustomUtil.getStatusConvertIceToPortal(jobStatus);
						
				if(jobStatusPortal.equals("codeConvertError")){
					log.error("Error Sync Icebreaker to Portal [ CODE CONVERT ] in updateSimulationJob");
					result = false;
				}else{
					simulationJob.setJobStatus(Long.parseLong(jobStatusPortal));
	
					if(!jobStartDt.equals("")){
						if(jobStartDt.length()==19){
							simulationJob.setJobStartDt(CustomUtil.StringToDateFormat(jobStartDt, "yyyy-MM-dd HH:mm:ss"));
						}else{
							log.error("Error Sync Icebreaker to Portal [ jobStartDt Format Error != size(19)] in updateSimulationJob");
						}
					}
					if(!jobEndDt.equals("")){
						if(jobEndDt.length()==19){
							simulationJob.setJobEndDt(CustomUtil.StringToDateFormat(jobEndDt, "yyyy-MM-dd HH:mm:ss"));
						}else if(jobEndDt.toLowerCase().equals("none")){
							
						}else{
							log.error("Error Sync Icebreaker to Portal [ jobEndDt Format Error != size(19)] in updateSimulationJob==>"+jobEndDt);
						}
					}
									
					simulationJob = SimulationJobLocalServiceUtil.updateSimulationJob(simulationJob);
				}				
				
				result = true;
				
			} catch (PortalException e) {
				log.error("Error Sync Icebreaker to Portal [ PortalException ] in updateSimulationJob");
				log.error("PortalException : " + e.toString());
				
				result = false;
				
			} catch (SystemException e) {
				log.error("Error Sync Icebreaker to Portal [ SystemException ] in updateSimulationJob");
				log.error("SystemException : " + e.toString());

				result = false;
			} catch (ParseException e) {
				log.error("Error Sync Icebreaker to Portal [ ParseException ] in updateSimulationJob");
				log.error("ParseException : " + e.toString());
				result = false;
			}
		}else{
			log.error("Error Sync Icebreaker to Portal [ REQUEST ARGUMENT ] in updateSimulationJob");
			result = false;
		}
		
		
		return result;
	}

}


