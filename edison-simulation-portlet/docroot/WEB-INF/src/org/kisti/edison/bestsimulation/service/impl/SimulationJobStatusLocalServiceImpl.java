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

import java.util.List;

import org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException;
import org.kisti.edison.bestsimulation.model.SimulationJob;
import org.kisti.edison.bestsimulation.model.SimulationJobStatus;
import org.kisti.edison.bestsimulation.service.SimulationJobLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.base.SimulationJobStatusLocalServiceBaseImpl;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;

/**
 * The implementation of the simulation job status local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author mhkang
 * @see org.kisti.edison.bestsimulation.service.base.SimulationJobStatusLocalServiceBaseImpl
 * @see org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalServiceUtil
 */
public class SimulationJobStatusLocalServiceImpl
	extends SimulationJobStatusLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalServiceUtil} to access the simulation job status local service.
	 */
	
	public SimulationJobStatus getSimulationJobStatusBySimulationUuidASMonitoring(long jobSeqNo,long groupId, String simulationUuid, String jobUuid) throws SystemException, NoSuchSimulationJobStatusException, PortalException{
//		int end = simulationJobStatusPersistence.countBysimulationUuid(groupId, simulationUuid, jobUuid);
//		OrderByComparator orderByComparator = OrderByComparatorFactoryUtil.create("EDSIM_SimulationJobStatus", "statusSeq", false);
		
//		List<SimulationJobStatus> statusList = simulationJobStatusPersistence.findBysimulationUuid(groupId, simulationUuid, jobUuid, 1, 10, orderByComparator);
		List<SimulationJobStatus> statusList = simulationJobStatusPersistence.findBysimulationUuid(groupId, simulationUuid, jobUuid);
		
		SimulationJobStatus simulationJobStatus = null;
		if(statusList.size()!=0){
			simulationJobStatus = statusList.get(0);
			
			if(statusList.size()>1){
				//전체 데이터 삭제
				simulationJobStatusPersistence.removeBysimulationUuid(groupId, simulationUuid, jobUuid);
			}else{
				SimulationJobStatusPK simulationJobStatusPK = new SimulationJobStatusPK(simulationJobStatus.getStatusSeq(), groupId, simulationUuid, jobUuid);
				simulationJobStatusPersistence.remove(simulationJobStatusPK);
			}
			
			
			//SimulationJob상태 update
			SimulationJobPK simulationJobPK = new SimulationJobPK(jobSeqNo, simulationUuid, groupId);
			SimulationJob simulationJob = SimulationJobLocalServiceUtil.getSimulationJob(simulationJobPK);
			
			if(simulationJob.getJobStatus()<simulationJobStatus.getJobStatus()){
				simulationJob.setJobStatus(simulationJobStatus.getJobStatus());
				
				if(simulationJobStatus.getJobStartDt()!=null){
					simulationJob.setJobStartDt(simulationJobStatus.getJobStartDt());
				}
				
				if(simulationJobStatus.getJobEndDt()!=null){
					simulationJob.setJobEndDt(simulationJobStatus.getJobEndDt());
				}
				
				simulationJobPersistence.update(simulationJob);
			}
		}
		
		return simulationJobStatus;
	}
	
	public SimulationJobStatus getSimulationJobStatusByJobCreate(long groupId, String simulationUuid, String jobUuid) throws SystemException, NoSuchSimulationJobStatusException {
		List<SimulationJobStatus> statusList = simulationJobStatusPersistence.findBysimulationUuid(groupId, simulationUuid, jobUuid);
		SimulationJobStatus simulationJobStatus = null;
		if(statusList.size()>0){
			simulationJobStatus = statusList.get(0);
			//전체 데이터 삭제
			simulationJobStatusPersistence.removeBysimulationUuid(groupId, simulationUuid, jobUuid);
		}
		return simulationJobStatus;
	}
}