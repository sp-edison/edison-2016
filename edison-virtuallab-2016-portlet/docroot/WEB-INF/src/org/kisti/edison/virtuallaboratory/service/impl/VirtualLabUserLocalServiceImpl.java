/**
 * Copyright (c) 2016-EDISON, KISTI. All rights reserved.
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

package org.kisti.edison.virtuallaboratory.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException;
import org.kisti.edison.virtuallaboratory.model.VirtualLabUser;
import org.kisti.edison.virtuallaboratory.service.base.VirtualLabUserLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.User;

/**
 * The implementation of the virtual lab user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.virtuallaboratory.service.VirtualLabUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jksang
 * @see org.kisti.edison.virtuallaboratory.service.base.VirtualLabUserLocalServiceBaseImpl
 * @see org.kisti.edison.virtuallaboratory.service.VirtualLabUserLocalServiceUtil
 */
public class VirtualLabUserLocalServiceImpl
	extends VirtualLabUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.virtuallaboratory.service.VirtualLabUserLocalServiceUtil} to access the virtual lab user local service.
	 */
	
	public VirtualLabUser addVirtualLabUser(long classId, long userId) throws SystemException {
		
		VirtualLabUser virtualLabUser = virtualLabUserPersistence.create(CounterLocalServiceUtil.increment(VirtualLabUser.class.getName()));
		virtualLabUser.setUserId(userId);
		virtualLabUser.setUserStudentNumber("GENERAL" + String.valueOf(CounterLocalServiceUtil.increment(VirtualLabUser.class.getName() + String.valueOf(classId))));
		virtualLabUser.setAuthRole("STUDENT");
		virtualLabUser.setUserUseYn("Y");
		virtualLabUser.setRequestSort("REQUEST");
		virtualLabUser.setProcessNote("승인 요청");
		virtualLabUser.setProcessDate(new Date());
		virtualLabUser.setCreateDt(new Date());
		virtualLabUser.setUpdateDt(new Date());
		
		virtualLabUserPersistence.update(virtualLabUser);
		virtualLabUserPersistence.addVirtualLabClass(virtualLabUser.getVirtualLabUserId(), classId);
		
		return virtualLabUser;
	}
	
	public VirtualLabUser addTempUser(long classId, long userId, String studentNumber) throws SystemException {
		
		VirtualLabUser virtualLabUser = virtualLabUserPersistence.create(CounterLocalServiceUtil.increment(VirtualLabUser.class.getName()));
		virtualLabUser.setUserId(userId);
		virtualLabUser.setUserStudentNumber(studentNumber);
		virtualLabUser.setAuthRole("STUDENT");
		virtualLabUser.setUserUseYn("Y");
		virtualLabUser.setRequestSort("TEMP");
		virtualLabUser.setProcessNote("승인 요청");
		virtualLabUser.setProcessDate(new Date());
		virtualLabUser.setCreateDt(new Date());
		virtualLabUser.setUpdateDt(new Date());
		
		virtualLabUserPersistence.update(virtualLabUser);
		virtualLabUserPersistence.addVirtualLabClass(virtualLabUser.getVirtualLabUserId(), classId);
		
		return virtualLabUser;
	}
	
	public List<Map<String, Object>> getVirtualClassStudentList(long virtualLabId, long classId, long questionSeqNo, String search_parameter, long groupId) {
		
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		if(classId > 0) {
			List<Object[]> studentList = virtualLabUserFinder.getVirtualClassStudentList(virtualLabId, classId, questionSeqNo, search_parameter, groupId);
			
			if(studentList != null && studentList.size() > 0) {
				for (int i = 0; i < studentList.size(); i++) {
					Object[] studentArray = studentList.get(i);
					
					VirtualLabUser virtualLabUser = (VirtualLabUser) studentArray[0];
					int surveyCheck = (Integer) studentArray[1];
					String executeCount = (String) studentArray[2];
					
					Map<String, Object> result = new HashMap<String, Object>();
					result.put("virtualLabUserId", virtualLabUser.getVirtualLabUserId());
					result.put("userStudentNumber", virtualLabUser.getUserStudentNumber());
					result.put("updateDt", new SimpleDateFormat("yyyy-MM-dd").format(virtualLabUser.getUpdateDt()));
					result.put("createDt", new SimpleDateFormat("yyyy-MM-dd").format(virtualLabUser.getCreateDt()));
					result.put("processDate", new SimpleDateFormat("yyyy-MM-dd").format(virtualLabUser.getProcessDate()));
					result.put("processNote", virtualLabUser.getProcessNote());
					result.put("requestSort", virtualLabUser.getRequestSort());
					result.put("userUseYn", virtualLabUser.getUserUseYn());
					result.put("authRole", virtualLabUser.getAuthRole());
					result.put("surveyCheck", surveyCheck);
					result.put("executeCount", executeCount);
					
					long userId = virtualLabUser.getUserId();
					result.put("userId", virtualLabUser.getUserId());
					try {
						User user = userPersistence.fetchByPrimaryKey(userId);
						if (user != null) {
							result.put("userScreenName", user.getScreenName());
							result.put("userFirstName", user.getFirstName());
						}
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					resultList.add(result);
				}
			}
		}
		return resultList;
	}
	
	public VirtualLabUser updateVirtualLabUser(long virtualLabUserId, String requestSort) throws SystemException {
		
		VirtualLabUser virtualLabUser = virtualLabUserPersistence.fetchByPrimaryKey(virtualLabUserId);
		if(virtualLabUser!= null) {
			virtualLabUser.setRequestSort(requestSort);
	//		virtualLabUser.setProcessNote(params.get("processNote"));	// 승인 요청 정보
			virtualLabUser.setProcessDate(new Date());
			virtualLabUser.setUpdateDt(new Date());
			
			virtualLabUserPersistence.update(virtualLabUser);
		}
		return virtualLabUser;
	}
	
	public VirtualLabUser updateVirtualLabUserProcessNote(Map params) throws SystemException {
		
		VirtualLabUser virtualLabUser = virtualLabUserPersistence.fetchByPrimaryKey(GetterUtil.get(params.get("virtualLabUserId"), 0));
		if(virtualLabUser!= null) {
			virtualLabUser.setRequestSort(GetterUtil.get(params.get("requestSort"), "DENIED"));
			virtualLabUser.setProcessNote(GetterUtil.get(params.get("processNote"), ""));	// 승인 요청 정보
			virtualLabUser.setProcessDate(new Date());
			virtualLabUser.setUpdateDt(new Date());
			
			virtualLabUserPersistence.update(virtualLabUser);
		}
		return virtualLabUser;
	}
	
	public void removeVirtualLabUser(long classId, long virtualUserId) throws SystemException {
		try {
			virtualLabUserPersistence.remove(virtualUserId);
		} catch (NoSuchVirtualLabUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object[] getCountVirtualClassRegisterUserList(long classId) {
		return virtualLabUserFinder.getCountVirtualClassRegisterUserList(classId);
	}
	
	public VirtualLabUser getVirtualLabUserInfo(long classId, long userId) {
		return virtualLabUserFinder.getVirtualLabUserInfo(classId, userId);
	}
	
	public int getStudentCount(long virtualLabId, long classId) {
		return virtualLabUserFinder.getStudentCount(virtualLabId, classId);
	}	
	
	public List<Map<String, Object>> getUserGroupClassUser(long userId, long groupId) {
		
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
			List<Object[]> studentList = virtualLabUserFinder.getUserGroupClassUser(userId, groupId);
			
			if(studentList != null && studentList.size() > 0) {
				for (int i = 0; i < studentList.size(); i++) {
					Object[] studentArray = studentList.get(i);
					
					Map<String, Object> result = new HashMap<String, Object>();
					result.put("virtualLabUserId", studentArray[0]);
					result.put("userId", studentArray[1]);
					result.put("groupId", studentArray[2]);
					result.put("classId", studentArray[3]);
					
					resultList.add(result);
				}
			}
		return resultList;
	}

	
}