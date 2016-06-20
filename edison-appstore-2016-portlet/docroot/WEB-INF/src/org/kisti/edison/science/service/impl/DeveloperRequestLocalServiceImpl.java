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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.science.NoSuchDeveloperRequestException;
import org.kisti.edison.science.model.DeveloperRequest;
import org.kisti.edison.science.service.base.DeveloperRequestLocalServiceBaseImpl;
import org.kisti.edison.science.service.persistence.DeveloperRequestPK;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;

/**
 * The implementation of the developer request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.service.DeveloperRequestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jksang
 * @see org.kisti.edison.service.base.DeveloperRequestLocalServiceBaseImpl
 * @see org.kisti.edison.service.DeveloperRequestLocalServiceUtil
 */
public class DeveloperRequestLocalServiceImpl
	extends DeveloperRequestLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.service.DeveloperRequestLocalServiceUtil} to access the developer request local service.
	 */
	public List<Map<String, Object>> getListCustomDeveloperRequest(Map<String, Object> params, Locale locale) throws NumberFormatException, SystemException {
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		String userId = CustomUtil.strNull(params.get("userId"),"0");
		String groupId = CustomUtil.strNull(params.get("groupId"),"0");

		if (userId != null && userId.length() > 0) {
			List<DeveloperRequest> developerRequestList = developerRequestPersistence.findByUserId(Long.parseLong(userId), Long.parseLong(groupId));
			
			for (int i = 0; i < developerRequestList.size(); i++) {
				
				DeveloperRequest developerRequest = (DeveloperRequest) developerRequestList.get(i);
				
				resultRow = new HashMap<String, Object>();
				if (developerRequest != null) {
					resultRow.put("requestSeq", String.valueOf(developerRequest.getRequestSeq()));
					resultRow.put("userId", String.valueOf(developerRequest.getUserId()));
					resultRow.put("requestSort", developerRequest.getRequestSort());
					resultRow.put("requestSortNm", EdisonExpndoUtil.getCommonCdSearchFieldValue(developerRequest.getRequestSort(), EdisonExpando.CDNM , locale));	//임시
					resultRow.put("requestNote", developerRequest.getRequestNote());
					resultRow.put("requestStatus", developerRequest.getRequestStatus());
					resultRow.put("requestStatusNm", EdisonExpndoUtil.getCommonCdSearchFieldValue(developerRequest.getRequestStatus(), EdisonExpando.CDNM , locale)); //임시
					if(developerRequest.getProcessDate() != null) {
						resultRow.put("processDate", new SimpleDateFormat("yyyy-MM-dd").format(developerRequest.getProcessDate()));
					}
					resultRow.put("processNote", developerRequest.getProcessNote());
					resultRow.put("insertId", String.valueOf(developerRequest.getInsertId()));
					resultRow.put("insertDate", new SimpleDateFormat("yyyy-MM-dd").format(developerRequest.getInsertDate()));
					resultRow.put("updateId", GetterUtil.get(developerRequest.getUpdateId(),""));
					if(developerRequest.getUpdateDate() != null) {
						resultRow.put("updateDate", new SimpleDateFormat("yyyy-MM-dd").format(developerRequest.getUpdateDate()));
					} else {
						resultRow.put("updateDate", "");
					}
				}
				returnList.add(resultRow);
			}
		}
		return returnList;
	}
	
	public DeveloperRequest insertCustomDeveloperRequest(Map<String, Object> params) throws SystemException, NumberFormatException, NoSuchModelException {
		DeveloperRequest developerRequest = null;

		String userId = CustomUtil.strNull(params.get("userId"),"0");
		String groupId = CustomUtil.strNull(params.get("groupId"),"0");
		long requestSeq = Long.parseLong(CustomUtil.strNull(params.get("requestSeq"),"0"));
		
		if(params.get("requestSeq") != null && !params.get("requestSeq").equals(0)) {
			developerRequest = developerRequestPersistence.findByPrimaryKey(new DeveloperRequestPK(requestSeq, Long.parseLong(userId), Long.parseLong(groupId)));
		} else {
			requestSeq = CounterLocalServiceUtil.increment(DeveloperRequest.class.getName());
			developerRequest = developerRequestPersistence.create(new DeveloperRequestPK(requestSeq, Long.parseLong(userId), Long.parseLong(groupId)));
			developerRequest.setInsertId(Long.parseLong((String)params.get("userId")));
			developerRequest.setUserId(Long.parseLong((String)params.get("userId")));
			developerRequest.setInsertDate(new Date());
			developerRequest.setGroupId((Long)params.get("groupId"));
		}
		developerRequest.setUpdateId(Long.parseLong((String)params.get("userId")));
		developerRequest.setUpdateDate(new Date());
		String requestSort = (String) params.get("requestSort");
		if(requestSort != null && requestSort.length() > 0) {
			developerRequest.setRequestSort((String)params.get("requestSort"));
			developerRequest.setRequestNote((String)params.get("requestNote"));
		}
		developerRequest.setRequestDate(new Date());
		developerRequest.setRequestStatus((String)params.get("requestStatus"));
		developerRequest.setProcessDate(new Date());
		String processNote = (String) params.get("processNote");
		if (processNote != null && processNote.length() > 0) {
			developerRequest.setProcessNote((String)params.get("processNote"));
		}
		
		developerRequest = developerRequestPersistence.update(developerRequest);
		return developerRequest;
	}
	
	public DeveloperRequest deleteCustomDeveloperRequest(Map<String, String> params) throws NumberFormatException, SystemException, NoSuchDeveloperRequestException {
		DeveloperRequest developerRequest = null;
		
		String requestSeq = CustomUtil.strNull(params.get("requestSeq"),"0");
		String userId = CustomUtil.strNull(params.get("userId"),"0");
		String groupId = CustomUtil.strNull(params.get("groupId"),"0");

		if (requestSeq != null && requestSeq.length() != 0) {
			developerRequest = developerRequestPersistence.remove(new DeveloperRequestPK(Long.parseLong(requestSeq), Long.parseLong(userId), Long.parseLong(groupId)));
		}
		
		return developerRequest;
	}
	

	/*
	 * WORKSPACE RequestStatus UPDATE
	 * */
	public void updateDeveloperRequestStatus(long userId, long groupId, String workspaceStatus) throws SystemException {
		if(userId > 0 && groupId > 0){
			List<DeveloperRequest> requestList = developerRequestPersistence.findByUserIdAndGroupId(userId, groupId);
			
			if(requestList != null){
				for(DeveloperRequest devleoper : requestList){
					devleoper.setRequestStatus(workspaceStatus);
					developerRequestPersistence.update(devleoper);
				}
			}
		}
	}
}