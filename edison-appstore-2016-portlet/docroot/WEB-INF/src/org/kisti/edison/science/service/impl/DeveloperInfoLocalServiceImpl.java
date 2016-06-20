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

package org.kisti.edison.science.service.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.science.NoSuchDeveloperInfoException;
import org.kisti.edison.science.model.DeveloperInfo;
import org.kisti.edison.science.model.DeveloperIp;
import org.kisti.edison.science.model.DeveloperRequest;
import org.kisti.edison.science.service.DeveloperIpLocalServiceUtil;
import org.kisti.edison.science.service.DeveloperRequestLocalServiceUtil;
import org.kisti.edison.science.service.base.DeveloperInfoLocalServiceBaseImpl;
import org.kisti.edison.science.service.persistence.DeveloperInfoPK;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.EdisonUserUtil;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the developer info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.service.DeveloperInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jksang
 * @see org.kisti.edison.service.base.DeveloperInfoLocalServiceBaseImpl
 * @see org.kisti.edison.service.DeveloperInfoLocalServiceUtil
 */
public class DeveloperInfoLocalServiceImpl
	extends DeveloperInfoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.service.DeveloperInfoLocalServiceUtil} to access the developer info local service.
	 */
	public int getScienceAppDeveloperInfoCount(long userId, long groupId) throws SystemException {
		int count = 0;
		if(userId != 0){
			DeveloperInfoPK developerInfoPK = new DeveloperInfoPK(userId, groupId);
			DeveloperInfo developerInfo =  developerInfoPersistence.fetchByPrimaryKey(developerInfoPK);
			if(developerInfo!=null){
				count = 1;
			}
		}
		return count;
	}
	
	
	public List<Map<String, Object>> getListCustomDeveloperInfo(Map<String, Object> params, Locale locale) {
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		List<Object[]> developerInfoList = developerInfoFinder.getListCustomDeveloperInfo(params);
		
		for (int i = 0; i < developerInfoList.size(); i++) {
			Object[] resultArray = developerInfoList.get(i);
			
			DeveloperInfo developerInfo = (DeveloperInfo) resultArray[0];
			DeveloperRequest developerRequest = (DeveloperRequest) resultArray[1];
			
			resultRow = new HashMap<String, Object>();
			if (developerInfo != null) {
				resultRow.put("userId", String.valueOf(developerInfo.getUserId()));
				resultRow.put("screenName", developerInfo.getScreenName());
				resultRow.put("firstName", developerInfo.getFirstName());
				resultRow.put("emailAddress", developerInfo.getEmailAddress());
				resultRow.put("universityField", developerInfo.getUniversityField());
//				resultRow.put("universityFieldNm", EdisonExpndoUtil.getCommonCdSearchFieldValue(developerInfo.getUniversityField(), EdisonExpando.CDNM + "_" + locale)); // 임시
				resultRow.put("majorField", developerInfo.getMajorField());
				resultRow.put("useStart", developerInfo.getUseStart());
				resultRow.put("useEnd", developerInfo.getUseEnd());
				resultRow.put("developerSort", developerInfo.getDeveloperSort());
				if(developerInfo.getLanguageFortran()) {
					resultRow.put("languageFortran", "Y");
				}
				if(developerInfo.getLanguageCpp()) {
					resultRow.put("languageCpp", "Y");
				}
				if(developerInfo.getLanguagePython()) {
					resultRow.put("languagePython", "Y");
				}
				if(developerInfo.getLanguageJava()) {
					resultRow.put("languageJava", "Y");
				}
				if(developerInfo.getLanguageOther()) {
					resultRow.put("languageOther", "Y");
					resultRow.put("languageOtherDescription", developerInfo.getLanguageOtherDescription());
				}
				resultRow.put("rem", developerInfo.getRem());
				if(developerInfo.getAgreementYn()) {
					resultRow.put("agreementYn", "Y");
				}
				resultRow.put("writtenOathLogical", developerInfo.getWrittenOathLogical());
				resultRow.put("writtenOathPhysical", developerInfo.getWrittenOathPhysical());
				resultRow.put("detailIp", developerInfo.getDetailIp());
				resultRow.put("detailOs", developerInfo.getDetailOs());
				resultRow.put("detailCpu", developerInfo.getDetailCpu());
				resultRow.put("detailStorate", developerInfo.getDetailStorate());
				resultRow.put("detailLibrary", developerInfo.getDetailLibrary());
				resultRow.put("etc", developerInfo.getEtc());
				resultRow.put("developerId", developerInfo.getDeveloperId());
				resultRow.put("developerPassword", developerInfo.getDeveloperPassword());
				resultRow.put("updateId", developerInfo.getUpdateId());
				if(developerInfo.getUpdateDate() != null) {
					resultRow.put("updateDate", new SimpleDateFormat("yyyy-MM-dd").format(developerInfo.getUpdateDate()));
				}
			}
			
			if (developerRequest != null) {
				resultRow.put("requestSeq", String.valueOf(developerRequest.getRequestSeq()));
				resultRow.put("requestSort", developerRequest.getRequestSort());
				if(developerRequest.getRequestDate() != null) {
					resultRow.put("requestDate", new SimpleDateFormat("yyyy-MM-dd").format(developerRequest.getRequestDate()));
				}
				resultRow.put("requestNote", developerRequest.getRequestNote());
				resultRow.put("requestStatus", developerRequest.getRequestStatus());
//				resultRow.put("processDate", new SimpleDateFormat("yyyy-MM-dd").format(developerRequest.getProcessDate()));
				resultRow.put("processNote", developerRequest.getProcessNote());
				if(developerRequest.getRequestStatus() != null && developerRequest.getRequestStatus().length() > 0) {
					resultRow.put("requestStatusNm", EdisonExpndoUtil.getCommonCdSearchFieldValue(developerRequest.getRequestStatus(), EdisonExpando.CDNM , locale)); // 임시
				}
			}
			returnList.add(resultRow);
		}
		return returnList;
	}
	
	public int getCountCustomDeveloperInfo(Map<String, Object> params) {
		return developerInfoFinder.getCountCustomDeveloperInfo(params);
	}
	
	public Map<String, Object> getCustomDeveloperInfo(Map<String, Object> params, Locale locale) {
		Map <String, Object> resultRow = null;
		Object[] developerInfoList = developerInfoFinder.getCustomDeveloperInfo(params);

		if(developerInfoList != null) {
			DeveloperInfo developerInfo = (DeveloperInfo) developerInfoList[0];
			DeveloperRequest developerRequest = (DeveloperRequest) developerInfoList[1];
			
			resultRow = new HashMap<String, Object>();
			
			if (developerInfo != null) {
				resultRow.put("userId", String.valueOf(developerInfo.getUserId()));
				resultRow.put("screenName", developerInfo.getScreenName());
				resultRow.put("firstName", developerInfo.getFirstName());
				resultRow.put("emailAddress", developerInfo.getEmailAddress());
				resultRow.put("universityField", developerInfo.getUniversityField());
//				resultRow.put("universityFieldNm", EdisonExpndoUtil.getCommonCdSearchFieldValue(developerInfo.getUniversityField(), EdisonExpando.CDNM + "_" + locale)); // 임시
				resultRow.put("majorField", developerInfo.getMajorField());
				resultRow.put("useStart", developerInfo.getUseStart());
				resultRow.put("useEnd", developerInfo.getUseEnd());
				resultRow.put("developerSort", developerInfo.getDeveloperSort());
				resultRow.put("developerSortNm", EdisonExpndoUtil.getCommonCdSearchFieldValue(developerInfo.getDeveloperSort(), EdisonExpando.CDNM , locale)); // 임시
				if(developerInfo.getLanguageFortran()) {
					resultRow.put("languageFortran", "Y");
				}
				if(developerInfo.getLanguageCpp()) {
					resultRow.put("languageCpp", "Y");
				}
				if(developerInfo.getLanguagePython()) {
					resultRow.put("languagePython", "Y");
				}
				if(developerInfo.getLanguageJava()) {
					resultRow.put("languageJava", "Y");
				}
				if(developerInfo.getLanguageOther()) {
					resultRow.put("languageOther", "Y");
					resultRow.put("languageOtherDescription", developerInfo.getLanguageOtherDescription());
				}
				resultRow.put("rem", developerInfo.getRem());
				if(developerInfo.getAgreementYn()) {
					resultRow.put("agreementYn", "Y");
				}
				resultRow.put("writtenOathLogical", developerInfo.getWrittenOathLogical());
				resultRow.put("writtenOathPhysical", developerInfo.getWrittenOathPhysical());
				resultRow.put("detailIp", developerInfo.getDetailIp());
				resultRow.put("detailOs", developerInfo.getDetailOs());
				resultRow.put("detailCpu", developerInfo.getDetailCpu());
				resultRow.put("detailStorate", developerInfo.getDetailStorate());
				resultRow.put("detailLibrary", developerInfo.getDetailLibrary());
				resultRow.put("etc", developerInfo.getEtc());
				resultRow.put("developerId", developerInfo.getDeveloperId());
				resultRow.put("developerPassword", developerInfo.getDeveloperPassword());
			}
			
			if (developerRequest != null) {
				resultRow.put("requestSeq", String.valueOf(developerRequest.getRequestSeq()));
				resultRow.put("requestSort", developerRequest.getRequestSort());
				resultRow.put("requestSortNm", EdisonExpndoUtil.getCommonCdSearchFieldValue(developerInfo.getDeveloperSort(), EdisonExpando.CDNM , locale));
				resultRow.put("requestDate", new SimpleDateFormat("yyyy-MM-dd").format(developerRequest.getRequestDate()));
				resultRow.put("requestNote", developerRequest.getRequestNote());
				resultRow.put("requestStatus", developerRequest.getRequestStatus());
				if(developerRequest.getProcessDate() != null) {
					resultRow.put("processDate", new SimpleDateFormat("yyyy-MM-dd").format(developerRequest.getProcessDate()));
				}
				resultRow.put("processNote", developerRequest.getProcessNote());
				resultRow.put("requestStatusNm", EdisonExpndoUtil.getCommonCdSearchFieldValue(developerRequest.getRequestStatus(), EdisonExpando.CDNM , locale)); // 임시
			}
		}
		

		return resultRow;
	}
	
	@Transactional
	public DeveloperInfo insertCustomDeveloperInfo(Map<String, Object> params) throws NoSuchDeveloperInfoException, NumberFormatException, SystemException {
		DeveloperInfo developerInfo = null;

		String userId = CustomUtil.strNull(params.get("userId"),"0");
		String groupId = CustomUtil.strNull(params.get("groupId"),"0");
		
		if (userId != null && userId.length() > 0) {
			developerInfo = developerInfoPersistence.create(new DeveloperInfoPK(Long.parseLong(userId), Long.parseLong(groupId)));
			
			developerInfo.setGroupId((Long)params.get("groupId"));
			developerInfo.setScreenName((String)params.get("screenName"));
			developerInfo.setFirstName((String)params.get("firstName"));
			developerInfo.setEmailAddress((String)params.get("emailAddress"));
			developerInfo.setUniversityField((String)params.get("universityField"));
			developerInfo.setMajorField((String)params.get("majorField"));
			developerInfo.setUseStart((String)params.get("useStart"));
			developerInfo.setUseEnd((String)params.get("useEnd"));
			developerInfo.setDeveloperSort((String)params.get("developerSort"));
			developerInfo.setDeveloperId((String)params.get("developerId"));
			developerInfo.setDeveloperPassword((String)params.get("developerPassword"));
			if(params.get("languageFortran") != null && params.get("languageFortran").equals("Y")) {
				developerInfo.setLanguageFortran(true);
			}
			if(params.get("languageCpp") != null && params.get("languageCpp").equals("Y")) {
				developerInfo.setLanguageCpp(true);
			}
			if(params.get("languagePython") != null && params.get("languagePython").equals("Y")) {
				developerInfo.setLanguagePython(true);
			}
			if(params.get("languageJava") != null && params.get("languageJava").equals("Y")) {
				developerInfo.setLanguageJava(true);
			}
			if(params.get("languageOther") != null && params.get("languageOther").equals("Y")) {
				developerInfo.setLanguageOther(true);
				developerInfo.setLanguageOtherDescription(CustomUtil.strNull(params.get("languageOtherDescription")));
			}
			developerInfo.setRem((String)params.get("rem"));
			
			if(params.get("agreementYn") != null && params.get("agreementYn").equals("Y")) {
				developerInfo.setAgreementYn(true);
			}

			developerInfo.setWrittenOathLogical((String)params.get("writtenOathLogical"));
			developerInfo.setWrittenOathPhysical((String)params.get("writtenOathPhysical"));
			developerInfo.setDetailIp((String)params.get("detailIp"));
			developerInfo.setDetailOs((String)params.get("detailOs"));
			developerInfo.setDetailCpu((String)params.get("detailCpu"));
			developerInfo.setDetailStorate((String)params.get("detailStorate"));
			developerInfo.setDetailLibrary((String)params.get("detailLibrary"));
			developerInfo.setInsertId(Long.parseLong(userId));
			developerInfo.setInsertDate(new Date());
			developerInfo.setUpdateId(Long.parseLong(userId));
			developerInfo.setUpdateDate(new Date());
			
			developerInfoPersistence.update(developerInfo);
		}
		return developerInfo;
	}
	
	public DeveloperInfo updateCustomDeveloperInfo(Map<String, Object> params) throws NumberFormatException, SystemException, NoSuchModelException {
		DeveloperInfo developerInfo = null;
		
		String userId = CustomUtil.strNull(params.get("userId"),"0");
		String groupId = CustomUtil.strNull(params.get("groupId"),"0");
		
		if (userId != null && userId.length() > 0) {
			developerInfo = developerInfoPersistence.findByPrimaryKey(new DeveloperInfoPK(Long.parseLong(userId), Long.parseLong(groupId)));
			
			if(params.get("useStart") != null) {
				developerInfo.setUseStart((String)params.get("useStart"));
			}
			if(params.get("setUseEnd") != null) {
				developerInfo.setUseEnd((String)params.get("setUseEnd"));
			}
			if(params.get("developerSort") != null) {
				developerInfo.setDeveloperSort((String)params.get("developerSort"));
			}
			if(params.get("developerId") != null) {
				developerInfo.setDeveloperId((String)params.get("developerId"));
			}
			if(params.get("developerPassword") != null) {
				developerInfo.setDeveloperPassword((String)params.get("developerPassword"));
			}
			if(params.get("etc") != null) {
				developerInfo.setEtc((String)params.get("etc"));
			}
			developerInfo.setUpdateId(Long.parseLong(userId));
			developerInfo.setUpdateDate(new Date());
			
			if(params.get("languageFortran") != null && params.get("languageFortran").equals("Y")) {
				developerInfo.setLanguageFortran(true);
			}
			if(params.get("languageCpp") != null && params.get("languageCpp").equals("Y")) {
				developerInfo.setLanguageCpp(true);
			}
			if(params.get("languagePython") != null && params.get("languagePython").equals("Y")) {
				developerInfo.setLanguagePython(true);
			}
			if(params.get("languageJava") != null && params.get("languageJava").equals("Y")) {
				developerInfo.setLanguageJava(true);
			}
			if(params.get("languageOther") != null && params.get("languageOther").equals("Y")) {
				developerInfo.setLanguageOther(true);
			}
			developerInfo.setRem((String)params.get("rem"));
			
			if(params.get("agreementYn") != null && params.get("agreementYn").equals("Y")) {
				developerInfo.setAgreementYn(true);
			}
			
			developerInfo.setWrittenOathLogical((String)params.get("writtenOathLogical"));
			developerInfo.setWrittenOathPhysical((String)params.get("writtenOathPhysical"));
			developerInfo.setDetailIp((String)params.get("detailIp"));
			developerInfo.setDetailOs((String)params.get("detailOs"));
			developerInfo.setDetailCpu((String)params.get("detailCpu"));
			developerInfo.setDetailStorate((String)params.get("detailStorate"));
			developerInfo.setDetailLibrary((String)params.get("detailLibrary"));

			developerInfoPersistence.update(developerInfo);
		}
		return developerInfo;
	}
	
	public DeveloperInfo deleteCustomDeveloperInfo(Map<String, String> params) throws NoSuchDeveloperInfoException, NumberFormatException, SystemException {
		DeveloperInfo developerInfo = null;
		
		String userId = CustomUtil.strNull(params.get("userId"),"0");
		String groupId = CustomUtil.strNull(params.get("groupId"),"0");
		
		if (userId != null && userId.length() > 0) {
			developerInfo = developerInfoPersistence.remove(new DeveloperInfoPK(Long.parseLong(userId), Long.parseLong(groupId)));
		}
		return developerInfo;
	}
	
	public List<Map<String, Object>> getDeveloperRequestStatus(long groupId, long userId, String requestStatus[], Locale locale, int begin, int end) {
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		List<Object[]> resultList = developerInfoFinder.getDeveloperRequestStatus(groupId, userId, requestStatus, begin, end);
		if(resultList != null) {
			for (Object[] result : resultList) {
				DeveloperInfo developerInfo = (DeveloperInfo) result[0];
				DeveloperRequest developerRequest = (DeveloperRequest) result[1];
				
				Map<String, Object> resultRow = new HashMap<String, Object>();
				resultRow.put("userId", developerInfo.getUserId());
				resultRow.put("userScreenName", developerInfo.getScreenName());
				resultRow.put("userFirstName", developerInfo.getFirstName());
				resultRow.put("userEmailAddress", developerInfo.getEmailAddress());
				resultRow.put("developerSort", EdisonExpndoUtil.getCommonCdSearchFieldValue(developerInfo.getDeveloperSort(), EdisonExpando.CDNM , locale));
				resultRow.put("developerId", developerInfo.getDeveloperId());
				resultRow.put("developerPassword", developerInfo.getDeveloperPassword());
				resultRow.put("useStart", developerInfo.getUseStart());
				resultRow.put("useEnd", developerInfo.getUseEnd());
				resultRow.put("groupId", developerInfo.getGroupId());
				Group group;
				try {
					group = GroupLocalServiceUtil.fetchGroup(developerInfo.getGroupId());
					if (group != null) {
						resultRow.put("groupName", group.getName());
					}
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				resultRow.put("requestDate", new SimpleDateFormat("yyyy-MM-dd").format(developerRequest.getRequestDate()));
				resultRow.put("requestStatusId", developerRequest.getRequestStatus());
				resultRow.put("requestStatus", EdisonExpndoUtil.getCommonCdSearchFieldValue(developerRequest.getRequestStatus(), EdisonExpando.CDNM , locale));
				resultRow.put("processNote", developerRequest.getProcessNote());
				
				returnList.add(resultRow);
			}
		}
		return returnList;
	}
	
	public int getCountDeveloperRequestStatus(long groupId, long userId, String requestStatus[]) {
		return developerInfoFinder.getCountDeveloperRequestStatus(groupId, userId, requestStatus);
	}
	
	public Map getCountRequestInfo(long groupId, String developerStatus, String virtualLabStatus,String libRequestStatus, String developerDeleteStatus) {
		Object[] requestArray = developerInfoFinder.getCountRequestInfo(groupId, developerStatus, virtualLabStatus, libRequestStatus, developerDeleteStatus);
		int developerRequestCount = (Integer) requestArray[0];
		int virtualLabRequestCount = (Integer) requestArray[1];
		Map returnMap = new HashMap();
		returnMap.put("developerRequestCount", developerRequestCount);
		returnMap.put("virtualLabRequestCount", virtualLabRequestCount);
		returnMap.put("totalCount", developerRequestCount + virtualLabRequestCount);
		
		if(!libRequestStatus.equals("")){
			int libRequestCount = (Integer) requestArray[2];
			returnMap.put("libRequestCount", libRequestCount);
			
			int developerDeleteCount = (Integer) requestArray[3];
			returnMap.put("developerDeleteCount", developerDeleteCount);
			
			returnMap.put("totalCount",  developerRequestCount + virtualLabRequestCount + libRequestCount + developerDeleteCount);
		}else{
			int developerDeleteCount = (Integer) requestArray[2];
			returnMap.put("developerDeleteCount", developerDeleteCount);
			returnMap.put("totalCount",  developerRequestCount + virtualLabRequestCount + developerDeleteCount);
		}
		
		return returnMap;
	}
	
	
	
	//WokrSpace 정보 전체 삭제
	public void deleteWorkSpace(long userId, long groupId) throws SystemException, PortalException, SQLException, IOException{
		//EDAPP_DeveloperRequest - 삭제
		List<DeveloperRequest> developerRequestList = developerRequestPersistence.findByUserId(userId, groupId);
		for(DeveloperRequest developerRequest:developerRequestList){
			DeveloperRequestLocalServiceUtil.deleteDeveloperRequest(developerRequest);
		}
		
		//EDAPP_DeveloperIp - 삭제
		List<DeveloperIp> developerIpList = developerIpPersistence.findByGroupId(userId, groupId);
		for(DeveloperIp developerIp:developerIpList){
			DeveloperIpLocalServiceUtil.deleteDeveloperIp(developerIp);
		}
		
		//EDAPP_DeveloperInfo - 삭제
		DeveloperInfoPK developerInfoPK = new DeveloperInfoPK(userId, groupId);
		developerInfoPersistence.remove(developerInfoPK);
		
		//보안서약서 파일 - 삭제
		EdisonFileUtil.deleteWorkspaceDocFile(groupId, "WORKSPACE_DOC", String.valueOf(userId));
		
		//해당 사이트에서의 개발자 권한 삭제
		User developerUser = UserLocalServiceUtil.getUser(userId);
		EdisonUserUtil.deleteSiteRole(developerUser, groupId, EdisonRoleConstants.SOLVER_OWNER);
		EdisonUserUtil.deleteSiteRole(developerUser, groupId, EdisonRoleConstants.SOLVER_MANAGER);
	}
	
	
}