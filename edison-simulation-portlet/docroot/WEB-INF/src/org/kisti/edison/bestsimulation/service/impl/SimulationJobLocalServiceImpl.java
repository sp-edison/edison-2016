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

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.bestsimulation.model.Simulation;
import org.kisti.edison.bestsimulation.model.SimulationJob;
import org.kisti.edison.bestsimulation.service.SimulationJobLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.SimulationLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.base.SimulationJobLocalServiceBaseImpl;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK;
import org.kisti.edison.bestsimulation.service.persistence.SimulationPK;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.IcebreakerVcToken;
import org.kisti.edison.science.model.ScienceAppOutputPorts;
import org.kisti.edison.science.service.ScienceAppOutputPortsLocalServiceUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;
import org.kisti.edison.util.MonitoringStatusConstatns;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * The implementation of the simulation job local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.bestsimulation.service.SimulationJobLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author mhkang
 * @see org.kisti.edison.bestsimulation.service.base.SimulationJobLocalServiceBaseImpl
 * @see org.kisti.edison.bestsimulation.service.SimulationJobLocalServiceUtil
 */
public class SimulationJobLocalServiceImpl
	extends SimulationJobLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.bestsimulation.service.SimulationJobLocalServiceUtil} to access the simulation job local service.
	 */
	
	public long getMaxJobSeqNoSimulationJob(long groupId, String simulationUuid){
		
		long maxJobSeqNo = 0;			
		
		maxJobSeqNo = simulationJobFinder.getMaxJobSeqNoSimulationJob(groupId, simulationUuid);
		
		return maxJobSeqNo;
	}	
	
	
	public int deleteSimulationJob(long groupId, String simulationUuid, long jobPhase, long jobSeqNo){		
		return simulationJobFinder.deleteSimulationJob(groupId, simulationUuid, jobPhase, jobSeqNo);
	}	
	


	public int deleteSimulationParameter(long groupId, String simulationUuid, long jobSeqNo){		
		return simulationJobFinder.deleteSimulationParameter(groupId, simulationUuid, jobSeqNo);
	}
	
	
	public int deleteSimulationCommandOption(long groupId, String simulationUuid, long optionSeq){		
		return simulationJobFinder.deleteSimulationCommandOption(groupId, simulationUuid, optionSeq);
	}
	
	
	
	public List getListSimulationJob(long groupId, String simulationUuid, long jobPhase, long jobSeqNo, Locale locale){
				
		List<SimulationJob> listObject = simulationJobFinder.getListSimulationJob(groupId, simulationUuid, jobPhase, jobSeqNo);
				
		List resultList = new ArrayList();
		SimulationJob simulationJob = null;
		Map result = null;
		for (int i = 0; i < listObject.size(); i++) {
			
			simulationJob = listObject.get(i);
			
			if(simulationJob != null) {				
				result = new HashMap<String, Object>();				
				result.put("jobSeqNo", simulationJob.getJobSeqNo());
				result.put("simulationUuid", simulationJob.getSimulationUuid());
				result.put("groupId", simulationJob.getGroupId());
				result.put("jobUuid", simulationJob.getJobUuid());
				result.put("jobStatus", simulationJob.getJobStatus());
				result.put("jobStatusNm", EdisonExpndoUtil.getCommonCdSearchFieldValue(String.valueOf(simulationJob.getJobStatus()), EdisonExpando.CDNM + "_" + locale.toString()));
				result.put("jobStartDt", simulationJob.getJobStartDt());
				result.put("jobEndDt", simulationJob.getJobEndDt());
				result.put("jobTitle", simulationJob.getJobTitle());
				result.put("jobExecPath", simulationJob.getJobExecPath());
				result.put("jobPhase", simulationJob.getJobPhase());
				result.put("jobPhaseNm", EdisonExpndoUtil.getCommonCdSearchFieldValue(String.valueOf(simulationJob.getJobPhase()), EdisonExpando.CDNM + "_" + locale.toString()));				
				result.put("jobSubmitDt", simulationJob.getJobSubmitDt());
				result.put("jobPostProcessor", simulationJob.getJobPostProcessor());
				result.put("jobUniversityField", simulationJob.getJobUniversityField());
				result.put("jobVirtualLabId", simulationJob.getJobVirtualLabId());
				result.put("jobClassId", simulationJob.getJobClassId());
				result.put("jobInputDeckYn", simulationJob.getJobInputDeckYn());
				result.put("jobInputDeckName", simulationJob.getJobInputDeckName());
				result.put("resultSize", simulationJob.getResultSize());
				
				resultList.add(result);
			}//if(simulationJob != null) {
			
		}//for
		
		return resultList;
	}	
	
	//화면 기본 조회
	public List<Map<String, Object>> getMonitoringList(long groupId, long userId,long jobVirtualLabId,long jobClassId, String searchValue, long jobStatus, int begin, int end) throws SystemException, PortalException, ParseException{
		return getMonitoringList(groupId, userId, jobVirtualLabId, jobClassId, searchValue, jobStatus, begin, end, "",0);
	}
	
	//모니터링 하위 JOB 조회
	public List<Map<String, Object>> getMonitoringJobList(long groupId,String simulationUuid) throws SystemException, PortalException, ParseException{
		return getMonitoringList(groupId, 0, 0, 0,"", 0, 0, 0, simulationUuid,0);
	}
	
	
	public Map<String,Object> getMonitoringJob(long groupId,String simulationUuid,long jobSeqNo) throws SystemException, PortalException, ParseException{
		List<Map<String, Object>> resultList = getMonitoringList(groupId, 0, 0, 0,"", 0, 0, 0, simulationUuid,jobSeqNo);
		return resultList.get(0);
	}
	
	protected List<Map<String, Object>> getMonitoringList(long groupId, long userId,long jobVirtualLabId,long jobClassId,String searchValue, long jobStatus, int begin, int end,String simulationUuid,long jobSeqNo) throws SystemException, PortalException, ParseException{
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		//simulationUuid가 있을 경우에는 simulationUuid를 기준으로 simulationJob을 조회 한다.
		List<Object[]> monitoringList = null;
		if(simulationUuid.equals("")){
			monitoringList = simulationJobFinder.getMonitoringList(groupId, userId, jobVirtualLabId, jobClassId,searchValue, jobStatus, begin, end);
		}else{
			monitoringList = simulationJobFinder.getMonitoringJobList(groupId, simulationUuid,jobSeqNo);
		}
		
		Map <String, Object> resultRow = null;
		for (int i = 0; i < monitoringList.size(); i++) {
			Object[] resultArray = monitoringList.get(i);
			if(resultArray != null) {
				Simulation simulation = (Simulation) resultArray[0];
				SimulationJob simulationJob = (SimulationJob) resultArray[1];
				String stayDt = CustomUtil.strNull(resultArray[2]);
				String executeDt = CustomUtil.strNull(resultArray[3]);
				String jobCnt = CustomUtil.strNull(resultArray[4]);
				
				resultRow = new HashMap<String, Object>();
				if (simulation != null) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					
					resultRow.put("simulationUuid",simulation.getSimulationUuid());
					resultRow.put("groupId",simulation.getGroupId());
					resultRow.put("userId",simulation.getUserId());
					//userNm
					User user = UserLocalServiceUtil.getUser(simulation.getUserId());
					resultRow.put("userNm",user.getScreenName());
					resultRow.put("simulationTitle",simulation.getSimulationTitle());
					resultRow.put("simulationDescription",simulation.getSimulationDescription());
					resultRow.put("scienceAppId",simulation.getScienceAppId());
					resultRow.put("scienceAppName",simulation.getScienceAppName());
					resultRow.put("simulationCreateDt",simulation.getSimulationCreateDt());
					resultRow.put("cluster",simulation.getCluster());

					resultRow.put("jobSeqNo",simulationJob.getJobSeqNo());
					resultRow.put("resultSize",simulationJob.getResultSize());
					resultRow.put("jobUuid",simulationJob.getJobUuid());
					resultRow.put("jobStatus",simulationJob.getJobStatus());
					//상태에 대한 이미지 파일 
					String jobStatusImg = EdisonExpndoUtil.getCommonCdSearchFieldValue(CustomUtil.strNull(simulationJob.getJobStatus()),EdisonExpando.OPTION1);
					resultRow.put("jobStatusImg",jobStatusImg);
					resultRow.put("jobStartDt",simulationJob.getJobStartDt());
					if(CustomUtil.strNull(simulationJob.getJobEndDt()).equals("")){
						resultRow.put("jobEndDt","");
					}else{
						resultRow.put("jobEndDt",simpleDateFormat.format(CustomUtil.StringToDateFormat(CustomUtil.strNull(simulationJob.getJobEndDt()), "yyyy-MM-dd HH:mm:ss")));
					}
					resultRow.put("jobTitle",simulationJob.getJobTitle());
					resultRow.put("jobExecPath",simulationJob.getJobExecPath());
					resultRow.put("jobPhase",simulationJob.getJobPhase());
					resultRow.put("jobSubmitDt",simpleDateFormat.format(CustomUtil.StringToDateFormat(CustomUtil.strNull(simulationJob.getJobSubmitDt()), "yyyy-MM-dd HH:mm:ss")));
					resultRow.put("jobPostProcessor",simulationJob.getJobPostProcessor());
					resultRow.put("jobPostProcessorYn","N");
					resultRow.put("jobMiddleFileProcessorYn","N");
					
					//후처리기 존재 여부
					long scienceAppId = GetterUtil.get(simulation.getScienceAppId(),0L);
					if(scienceAppId > 0L) {
						String outputPort = "";
						
						ScienceAppOutputPorts scienceAppOutputPorts = ScienceAppOutputPortsLocalServiceUtil.fetchScienceAppOutputPorts(scienceAppId);
						if(scienceAppOutputPorts != null) {
							outputPort = scienceAppOutputPorts.getOutputPorts();
						}
						if(outputPort != null && !outputPort.equals("")) {
							JSONObject outputPortJson = JSONObject.fromObject(JSONSerializer.toJSON(outputPort));
							Iterator<String> itr = outputPortJson.keys();
							int analyzerCount = 0;
							int middleFileCount = 0;
							while (itr.hasNext()) {
								String names = itr.next();
								if(!StringUtil.toUpperCase(names).equals("TEMP")) {
									JSONObject jsonPort = outputPortJson.getJSONObject(names);
									String analyzerId = GetterUtil.get(jsonPort.get("default-analyzer-id"), names);
									if(analyzerId != null && !analyzerId.equals("")) {
										analyzerCount++;
									}
								} else {
									middleFileCount++;
								}
							}
							
							if(analyzerCount > 0) {
								resultRow.put("jobPostProcessorYn","Y");
							}
							if(middleFileCount > 0) {
								resultRow.put("jobMiddleFileProcessorYn","Y");
							}
						}
					}
					
/*					if(CustomUtil.strNull(simulationJob.getJobPostProcessor()).equals("")){
						resultRow.put("jobPostProcessorYn","N");
					}else{
						String[] postArr = StringUtil.upperCase(simulationJob.getJobPostProcessor()).split(";");
						if(postArr.length>0){
							for1:for(String postProcessor : postArr){
								if(!postProcessor.equals("DOWNLOAD")){
									resultRow.put("jobPostProcessorYn","Y");
									break for1;
								}
							}
						}else{
							resultRow.put("jobPostProcessorYn","N");
						}
					}
					
					if(CustomUtil.strNull(resultRow.get("jobPostProcessorYn")).equals("")){
						resultRow.put("jobPostProcessorYn","N");
					}*/
					
					resultRow.put("jobUniversityField",simulationJob.getJobUniversityField());
					resultRow.put("jobVirtualLabId",simulationJob.getJobVirtualLabId());
					resultRow.put("jobClassId",simulationJob.getJobClassId());
					resultRow.put("jobInputDeckYn",simulationJob.getJobInputDeckYn());
					resultRow.put("jobInputDeckName",simulationJob.getJobInputDeckName());
					
					resultRow.put("stayDt", stayDt);
					resultRow.put("executeDt", executeDt);
					resultRow.put("jobCnt", jobCnt);
				}
				returnList.add(resultRow);
			}
		}
		return returnList;
	}
	
	//모니터링 카운트
	public int getMonitoringCount(long groupId, long userId, long jobVirtualLabId, long jobClassId, String searchValue,long jobStatus) throws SystemException{
		return simulationJobFinder.getMonitoringCount(groupId, userId, jobVirtualLabId, jobClassId, searchValue, jobStatus);
	}
	
	//가상클래스 삭제시 모니터링 데이터 삭제
	public boolean deleteMonitoringByJobClassId(long groupId, long jobClassId, User user) throws SystemException, PortalException{
		//제출 중인 데이터 조회
		boolean returnStatus = true;
		List<SimulationJob> simulationList = simulationJobPersistence.findByjobClassId(groupId, jobClassId, 1301003);
		root1:for(SimulationJob simulationJob:simulationList){
			String result = deleteMonitoring(simulationJob.getSimulationUuid(), groupId, simulationJob.getJobSeqNo(), user);
			if(!result.equals("SUCCESS")){returnStatus=false; break root1;}
		}
		return returnStatus; 
	}
	
	
	
	//simulation까지 삭제 할 경우에는 jobSeqNo = 0;
	//DELETE 모니터링
	public String deleteMonitoring(String simulationUuid, long groupId,long jobSeqNo,User user) throws PortalException, SystemException{
		String returnResult = "";
		if(jobSeqNo!=0){
			SimulationJobPK simulationJobPK = new SimulationJobPK(jobSeqNo, simulationUuid, groupId);
			SimulationJob simulationJob = SimulationJobLocalServiceUtil.getSimulationJob(simulationJobPK);
			try {
				returnResult = icebreakerCancleJobAndDeleteData(simulationJob, user);
			} catch (MalformedURLException e) {
				throw new PortalException(e);
			} catch (IOException e) {
				throw new PortalException(e);
			} catch (ParseException e) {
				throw new PortalException(e);
			}
			
			if(returnResult.equals("SUCCESS")){
				//삭제 하고자 하는 데이터의 jobSeqNo가 1일 경우
				//모니터링 목록에서 해당 job의 jobSeqNo가 1을 조회 하기 때문에 
				//해당 simulationUuid에 해당하는 jobSeqNo를 -1을 하여 update한다.
				if(jobSeqNo==1){
					List<Map<String,Object>> simulationJobList =  getListSimulationJob(groupId, simulationUuid, 1301003, 0, Locale.KOREA);
					if(simulationJobList.size()!=0){
						for(Map<String,Object> simulationJobMap : simulationJobList){
							long jobSeqNoModel = GetterUtil.getLong(simulationJobMap.get("jobSeqNo"),0);
							simulationJobFinder.updateSimulationJobSetJobSeqNo(jobSeqNoModel-1, jobSeqNoModel, simulationUuid, groupId);
						}
					}
				}
				
				//job을 제출 한 것에 대한 리스트를 조회
				List<SimulationJob> searchList = simulationJobFinder.getListSimulationJob(groupId, simulationUuid, 1301003, 0L); 
				if(searchList.size()==0){
					//simulation  삭제
					SimulationPK simulationPK = new SimulationPK(simulationUuid, groupId);
					SimulationLocalServiceUtil.deleteSimulation(simulationPK);
					
					//simulation을 삭제 할때 simulationjob에 아직 제출 되지 않은 Data가 있을 경우 해당 데이터를 삭제
					List<SimulationJob> deleteJobList = simulationJobPersistence.findBysimulationUuid(simulationUuid, groupId);
					if(deleteJobList.size()>0){
						for(SimulationJob deleteSimulation:deleteJobList){
							SimulationJobLocalServiceUtil.deleteSimulationJob(deleteSimulation);
						}
					}
				}
			}
		}else{
			List<SimulationJob> simulationList = simulationJobFinder.getListSimulationJob(groupId, simulationUuid, 1301003, 0L);
			for(SimulationJob simulationJob : simulationList){
				try {
					returnResult = icebreakerCancleJobAndDeleteData(simulationJob, user);
				} catch (MalformedURLException e) {
					throw new PortalException(e);
				} catch (IOException e) {
					throw new PortalException(e);
				} catch (ParseException e) {
					throw new PortalException(e);
				}
			}
			if(returnResult.equals("SUCCESS")){
				//simulation  삭제
				SimulationPK simulationPK = new SimulationPK(simulationUuid, groupId);
				SimulationLocalServiceUtil.deleteSimulation(simulationPK);
				
				//simulation을 삭제 할때 simulationjob에 아직 제출 되지 않은 Data가 있을 경우 해당 데이터를 삭제
				List<SimulationJob> deleteJobList = simulationJobPersistence.findBysimulationUuid(simulationUuid, groupId);
				if(deleteJobList.size()>0){
					for(SimulationJob deleteSimulation:deleteJobList){
						SimulationJobLocalServiceUtil.deleteSimulationJob(deleteSimulation);
					}
				}
			}
			
		}
		return returnResult;
	}
	
	protected String icebreakerCancleJobAndDeleteData(SimulationJob simulationJob,User user) throws PortalException, SystemException, MalformedURLException, IOException, ParseException{
		boolean cancleSuccess = true;
		String returnResult = "SUCCESS";
		SimulationJobPK simulationJobPK = new SimulationJobPK(simulationJob.getJobSeqNo(), simulationJob.getSimulationUuid(), simulationJob.getGroupId());
		
		if(simulationJob.getJobStatus()==MonitoringStatusConstatns.QUEUED||simulationJob.getJobStatus()==MonitoringStatusConstatns.RUNNING){
			String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(simulationJob.getGroupId()).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
			IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(simulationJob.getGroupId(), user);
			
			int cancleResult = SimulationLocalServiceUtil.cancleJob(icebreakerUrl, vcToken.getVcToken(), simulationJob.getSimulationUuid(), simulationJob.getJobUuid());
			if(cancleResult!=200){
				returnResult = "--simulation_uuid:"+simulationJob.getSimulationUuid();
				returnResult += ", job_uuid:"+simulationJob.getJobUuid();
				returnResult += ",canclejob error_code:"+String.valueOf(cancleResult);
				cancleSuccess = false;
			}
		}
		
		
		boolean deleteSuccess = true;
		if(cancleSuccess){
			String icebreakerUrl = (String) GroupLocalServiceUtil.getGroup(simulationJob.getGroupId()).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL);
			IcebreakerVcToken vcToken = SimulationLocalServiceUtil.getOrCreateToken(simulationJob.getGroupId(), user);
			
			int deleteResult = SimulationLocalServiceUtil.deleteSimulationJob(icebreakerUrl, vcToken.getVcToken(), simulationJob.getSimulationUuid(), simulationJob.getJobUuid());
			if(deleteResult!=200){
				returnResult = "--simulation_uuid:"+simulationJob.getSimulationUuid();
				returnResult += ", job_uuid:"+simulationJob.getJobUuid();
				returnResult += ",deletejob error_code:"+String.valueOf(deleteResult);
				deleteSuccess = false;
			}
		}
/*		if(cancleSuccess&&deleteSuccess){
			SimulationJobLocalServiceUtil.deleteSimulationJob(simulationJobPK);
			//MyFile Data가 있을 경우 삭제
			int myFileCnt = MyFileMgntLocalServiceUtil.getMyfileMgntCountByjobUuid(user.getUserId(), 1917002,simulationJob.getJobUuid());
			
			if(myFileCnt!=0){
				List<MyFileMgnt> fileList = MyFileMgntLocalServiceUtil.getMyFileListByjobUuid(user.getUserId(), 1917002,simulationJob.getJobUuid());
				for(MyFileMgnt myFileMgnt:fileList){
					//MyFileMgnt  삭제
					MyFileMgntLocalServiceUtil.deleteMyFileMgnt(myFileMgnt);
					
					//MyFileMgntAPIInfo 삭제
					MyFileMgntAPIInfoPK myFileMgntAPIInfoPK = new MyFileMgntAPIInfoPK(myFileMgnt.getFileSeq(), "POST");
					MyFileMgntAPIInfoLocalServiceUtil.deleteMyFileMgntAPIInfo(myFileMgntAPIInfoPK);
				}
			}
		}
*/		
		return returnResult;
	}

	
	public long getMaxStatusSeqSimulationJobStatus(long groupId, String simulationUuid, String jobUuid){
		
		long maxStatusSeq = 0;			
		
		maxStatusSeq = simulationJobFinder.getMaxStatusSeqSimulationJobStatus(groupId, simulationUuid, jobUuid);
		
		return maxStatusSeq;
	}	

	
	public long getStatusSimulationJobStatus(long groupId, String simulationUuid, String jobUuid){
		
		long jobStatus = 0;			
		
		jobStatus = simulationJobFinder.getStatusSimulationJobStatus(groupId, simulationUuid, jobUuid);
		
		return jobStatus;
	}	

	
	/**
	 * ###########################################################################################################################################################################
	 * ###########################################################################################################################################################################
	 * ###########################################################################################################################################################################
	 * ###########################################################################################################################################################################
	 * ##### 통계 Service #########################################################################################################################################################
	 * ###########################################################################################################################################################################
	 * ###########################################################################################################################################################################
	 * ###########################################################################################################################################################################
	 * ###########################################################################################################################################################################
	 */

	//기관 정보에 따른 실험실 목록
	public List<Map<String, Object>> getListVirtualLabSearchUni(long groupId, String languageId, long jobUniversityField) throws SystemException, PortalException, ParseException{
	List<Object[]> tempList = simulationJobFinder.getListVirtualLabSearchUni(groupId, languageId, jobUniversityField);
		List resultList = new ArrayList();
		Object[] objs = null;
		Map map = null;
		
		if(tempList != null){
			if(tempList.size() > 0){
				for(int i=0;i < tempList.size();i++){
					objs = (Object[])tempList.get(i);
					map = new HashMap();
					map.put("virtualLabId",		objs[0]);
					map.put("virtualLabTitle",		objs[1]);
					resultList.add(map);
				}
			}
		}		
		return resultList;
	}
	//실험실정보에 따른 수업목록
	public List<Map<String, Object>> getListVirtualClassSearchLab(long groupId, String languageId, long jobVirtualLabId) throws SystemException, PortalException, ParseException{
		List<Object[]> tempList = simulationJobFinder.getListVirtualClassSearchLab(groupId, languageId, jobVirtualLabId);
		List resultList = new ArrayList();
		Object[] objs = null;
		Map map = null;
		
		if(tempList != null){
			if(tempList.size() > 0){
				for(int i=0;i < tempList.size();i++){
					objs = (Object[])tempList.get(i);
					map = new HashMap();
					map.put("classId",		objs[0]);
					map.put("classTitle",		objs[1]);
					resultList.add(map);
				}
			}
		}		
		return resultList;
	}
	/**
	 * ##### 1. EXE START ###################################################################################################################################################
	 */	
	//시뮬레이션 실행현황 표 데이터
	public List<Map<String, Object>> getStatisticsExecTableOrganigation(long groupId, String languageId, String startDt, String endDt, long jobUniversityField) throws SystemException, PortalException, ParseException{		
		
		List<Object[]> tempList = simulationJobFinder.getStatisticsExecTableOrganigation(groupId, languageId, startDt, endDt, jobUniversityField);
		List resultList = new ArrayList();
		Object[] objs = null;
		Map map = null;
		
		if(tempList != null){
			if(tempList.size() > 0){
				for(int i=0;i < tempList.size();i++){
					objs = (Object[])tempList.get(i);
					map = new HashMap();
					map.put("affiliation",		objs[0]);
					map.put("userCnt",			objs[1]);
					map.put("averageRuntime",	objs[2]);
					map.put("jobCnt",			objs[3]);
					map.put("cputime",			objs[4]);
					map.put("topString",		objs[5]);
					
					String topStr = "";
					if(objs[5] != null){
						topStr = (String) objs[5];
						topStr = topStr.replaceAll("</br>", "\n").replaceAll("<br/>", "\n").replaceAll("<br>", "\n");
					}

					map.put("topStrBrRemove",		topStr);
					
					resultList.add(map);
				}
			}
		}		
		return resultList;
	}	
	//시뮬레이션 실행현황 파이 챠트 - 기관, 랩, 클래스
	public List<Map<String, Object>> getStatisticsExecPieChartOrganigation(long groupId, String languageId, String startDt, String endDt, long jobUniversityField) throws SystemException, PortalException, ParseException{
		List<Object[]> tempList = simulationJobFinder.getStatisticsExecPieChartOrganigation(groupId, languageId, startDt, endDt, jobUniversityField);
		List resultList = new ArrayList();
		Object[] objs = null;
		Map map = null;
		
		if(tempList != null){
			if(tempList.size() > 0){
				for(int i=0;i < tempList.size();i++){
					objs = (Object[])tempList.get(i);
					map = new HashMap();
					map.put("count",		objs[0]);
					map.put("affiliation",		objs[1]);					
					resultList.add(map);
				}
			}
		}		
		return resultList;
	}
	//시뮬레이션 실행현황 바 챠트 - 월별
	public List<Map<String, Object>> getStatisticsExecBarChartDate(long groupId, String languageId, String startDt, String endDt, long jobUniversityField) throws SystemException, PortalException, ParseException{
		List<Object[]> tempList = simulationJobFinder.getStatisticsExecBarChartDate(groupId, languageId, startDt, endDt, jobUniversityField);
		List resultList = new ArrayList();
		Object[] objs = null;
		Map map = null;
		
		if(tempList != null){
			if(tempList.size() > 0){
				for(int i=0;i < tempList.size();i++){
					objs = (Object[])tempList.get(i);
					map = new HashMap();
					map.put("month",		objs[0]);
					map.put("count",		objs[1]);
					resultList.add(map);
				}
			}
		}		
		return resultList;
	}
	
	/**
	 * ##### 1. EXE END ###################################################################################################################################################
	 */	
	
	/**
	 * ##### 2. Sw START ###################################################################################################################################################
	 */
	public List<Map<String, Object>> getStatisticsSwTableOrganigation(long entryId, long vocabularyId, long columnId, String languageId, String startDt, String endDt, long universityId) throws SystemException, PortalException, ParseException{		
		List<Object[]> tempList = simulationJobFinder.getStatisticsSwTableOrganigation(entryId, vocabularyId, columnId, languageId, startDt, endDt, universityId);
		List resultList = new ArrayList();
		Object[] objs = null;
		Map map = null;
		
		if(tempList != null){
			if(tempList.size() > 0){
				for(int i=0;i < tempList.size();i++){
					objs = (Object[])tempList.get(i);
					map = new HashMap();
					map.put("universityId",		objs[0]);
					map.put("universityNm",		objs[1]);
					map.put("cnt",		objs[2]);
					resultList.add(map);
				}
			}
		}		
		return resultList;
	}	

	public List<Map<String, Object>> getStatisticsSwBarChartDate(long entryId, long vocabularyId, long columnId, String startDt, String endDt, long universityId) throws SystemException, PortalException, ParseException{
		List<Object[]> tempList = simulationJobFinder.getStatisticsSwBarChartDate(entryId, vocabularyId, columnId, startDt, endDt, universityId);
		List resultList = new ArrayList();
		Object[] objs = null;
		Map map = null;
		
		if(tempList != null){
			if(tempList.size() > 0){
				for(int i=0;i < tempList.size();i++){
					objs = (Object[])tempList.get(i);
					map = new HashMap();
					map.put("month",		objs[0]);
					map.put("count",		objs[1]);
					resultList.add(map);
				}
			}
		}		
		return resultList;
	}
	/**
	 * ##### 2. Sw END ###################################################################################################################################################
	 */	

	/**
	 * ##### 3. SwExe START ###################################################################################################################################################
	 */	
	public List<Map<String, Object>> getStatisticsSwExeTableOrganigation(long groupId, String languageId, long columnId, String startDt, String endDt, long scienceAppId) throws SystemException, PortalException, ParseException{		
		List<Object[]> tempList = simulationJobFinder.getStatisticsSwExeTableOrganigation(groupId, languageId, columnId, startDt, endDt, scienceAppId);
		List resultList = new ArrayList();
		Object[] objs = null;
		Map map = null;
		
		if(tempList != null){
			if(tempList.size() > 0){
				for(int i=0;i < tempList.size();i++){
					objs = (Object[])tempList.get(i);
					map = new HashMap();
					map.put("scienceApp_name",		objs[0]);
					map.put("user_count",		objs[1]);
					map.put("averageRuntime",	objs[2]);
					map.put("exe_count",		objs[3]);
					
					map.put("scienceApp_affiliation_name",		objs[4]);
					map.put("mgtName",						objs[5]);
					map.put("mgtDate",						objs[6]);
					map.put("scienceApp_version",				objs[7]);
					
					resultList.add(map);
				}
			}
		}		
		return resultList;
	}	

	public List<Map<String, Object>> getStatisticsSwExeBarChartDate(long groupId, long columnId, String startDt, String endDt, long scienceAppId) throws SystemException, PortalException, ParseException{
		List<Object[]> tempList = simulationJobFinder.getStatisticsSwExeBarChartDate(groupId, columnId, startDt, endDt, scienceAppId);
		List resultList = new ArrayList();
		Object[] objs = null;
		Map map = null;
		
		if(tempList != null){
			if(tempList.size() > 0){
				for(int i=0;i < tempList.size();i++){
					objs = (Object[])tempList.get(i);
					map = new HashMap();
					map.put("month",		objs[0]);
					map.put("count",		objs[1]);
					resultList.add(map);
				}
			}
		}		
		return resultList;
	}
	/**
	 * ##### 3. SwExe END ###################################################################################################################################################
	 */
	
	/**
	 * ##### 4. Time START ###################################################################################################################################################
	 */	
	public List<Map<String, Object>> getStatisticsTimeTableOrganigation(long groupId, String startDt, String endDt) throws SystemException, PortalException, ParseException{		
		List<Object[]> tempList = simulationJobFinder.getStatisticsTimeTableOrganigation(groupId, startDt, endDt);
		List resultList = new ArrayList();
		Object[] objs = null;
		Map map = null;
		
		if(tempList != null){
			if(tempList.size() > 0){
				for(int i=0;i < tempList.size();i++){
					objs = (Object[])tempList.get(i);
					map = new HashMap();
					map.put("averageRuntime",		objs[0]);
					map.put("averageStandbyTime",	objs[1]);
					resultList.add(map);
				}
			}
		}		
		return resultList;
	}	
	/**
	 * ##### 4. Time END ###################################################################################################################################################
	 */
	
	/**
	 * ##### 5. User START ###################################################################################################################################################
	 */	
	public List<Map<String, Object>> getStatisticsUserTableOrganigation(long groupId, String languageId, String startDt, String endDt, long jobUniversityField) throws SystemException, PortalException, ParseException{		
		List<Object[]> tempList = simulationJobFinder.getStatisticsUserTableOrganigation(groupId, languageId, startDt, endDt, jobUniversityField);
		List resultList = new ArrayList();
		Object[] objs = null;
		Map map = null;
		
		if(tempList != null){
			if(tempList.size() > 0){
				for(int i=0;i < tempList.size();i++){
					objs = (Object[])tempList.get(i);
					map = new HashMap();
					map.put("affiliation",		objs[0]);
					map.put("virtualLabTitle",	objs[1]);
					map.put("classTitle",		objs[2]);
					map.put("user_count",		objs[3]);
					resultList.add(map);
				}
			}
		}		
		return resultList;
	}	
	public List<Map<String, Object>> getStatisticsUserPieChartOrganigation(long groupId, String languageId, String startDt, String endDt, long jobUniversityField) throws SystemException, PortalException, ParseException{
		List<Object[]> tempList = simulationJobFinder.getStatisticsUserPieChartOrganigation(groupId, languageId, startDt, endDt, jobUniversityField);
		List resultList = new ArrayList();
		Object[] objs = null;
		Map map = null;
		
		if(tempList != null){
			if(tempList.size() > 0){
				for(int i=0;i < tempList.size();i++){
					objs = (Object[])tempList.get(i);
					map = new HashMap();
					map.put("affiliation",	objs[0]);
					map.put("user_count",	objs[1]);
					if(jobUniversityField > 0){
						map.put("virtualLabTitle",	objs[2]);
						map.put("classTitle",		objs[3]);
					}
					
					resultList.add(map);
				}
			}
		}		
		return resultList;
	}
	public List<Map<String, Object>> getStatisticsUserBarChartDate(long groupId, String languageId, String startDt, String endDt, long jobUniversityField) throws SystemException, PortalException, ParseException{
		List<Object[]> tempList = simulationJobFinder.getStatisticsUserBarChartDate(groupId, languageId, startDt, endDt, jobUniversityField);
		List resultList = new ArrayList();
		Object[] objs = null;
		Map map = null;
		
		if(tempList != null){
			if(tempList.size() > 0){
				for(int i=0;i < tempList.size();i++){
					objs = (Object[])tempList.get(i);
					map = new HashMap();
					map.put("month",		objs[0]);
					map.put("count",		objs[1]);
					resultList.add(map);
				}
			}
		}		
		return resultList;
	}
	/**
	 * ##### 5. User END ###################################################################################################################################################
	 */
	
}