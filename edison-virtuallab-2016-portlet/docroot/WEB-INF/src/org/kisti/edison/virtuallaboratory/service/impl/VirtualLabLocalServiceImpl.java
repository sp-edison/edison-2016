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

package org.kisti.edison.virtuallaboratory.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.customauthmanager.model.UserGroupRoleCustom;
import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException;
import org.kisti.edison.virtuallaboratory.model.VirtualLab;
import org.kisti.edison.virtuallaboratory.model.VirtualLabClass;
import org.kisti.edison.virtuallaboratory.model.VirtualLabUser;
import org.kisti.edison.virtuallaboratory.service.VirtualLabClassLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.base.VirtualLabLocalServiceBaseImpl;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the virtual lab local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.service.VirtualLabLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jksang
 * @see org.kisti.edison.service.base.VirtualLabLocalServiceBaseImpl
 * @see org.kisti.edison.service.VirtualLabLocalServiceUtil
 */
public class VirtualLabLocalServiceImpl extends VirtualLabLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.service.VirtualLabLocalServiceUtil} to access the virtual lab local service.
	 */
	
	public VirtualLab addVirtualLab(Map<String, String> param, Locale locale) throws SystemException {
		VirtualLab virtualLab = null;
		if(!param.get("virtualLabId").equals("0")) {
			try {
				virtualLab = virtualLabPersistence.findByPrimaryKey(Long.parseLong(param.get("virtualLabId")));
				virtualLab.setGroupId(Long.parseLong(param.get("groupId")));
				virtualLab.setVirtualLabUniversityField(param.get("virtualLabUniversityField"));
				virtualLab.setVirtualLabDescriptionMap(CustomUtil.getLocalizationMap(param,"virtualLabDescription"));
				virtualLab.setVirtualLabTitleMap(CustomUtil.getLocalizationMap(param,"virtualLabTitle"));
				virtualLab.setVirtualLabPersonNameMap(CustomUtil.getLocalizationMap(param, "virtualLabPersonName"));
				virtualLab.setVirtualLabStatus(param.get("statusSort"));
				virtualLabPersistence.update(virtualLab);
			} catch (NoSuchVirtualLabException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			virtualLab = virtualLabPersistence.create(CounterLocalServiceUtil.increment(VirtualLab.class.getName()));
			virtualLab.setUserId(Long.parseLong(param.get("userId")));
			virtualLab.setGroupId(Long.parseLong(param.get("groupId")));
			virtualLab.setVirtualLabUniversityField(param.get("virtualLabUniversityField"));
			virtualLab.setVirtualLabDescriptionMap(CustomUtil.getLocalizationMap(param,"virtualLabDescription"));
			virtualLab.setVirtualLabTitleMap(CustomUtil.getLocalizationMap(param,"virtualLabTitle"));
			virtualLab.setVirtualLabPersonNameMap(CustomUtil.getLocalizationMap(param,"virtualLabPersonName"));
			virtualLab.setVirtualLabConfirmDt(new Date());
			virtualLab.setVirtualLabStatus(param.get("statusSort"));
			virtualLab.setVirtualLabUseYn("Y");
			virtualLab.setVirtualLabRequestDt(new Date());

			virtualLab = virtualLabPersistence.update(virtualLab); //가상 실험실 생성
		}
		return virtualLab;
	}
	
	public List<Map<String, Object>> getVirtualLabAuthList(long groupId, long userId, Locale locale) throws SystemException {
		List<Object[]> virtualLabList = virtualLabFinder.getVirtualLabAuthList(groupId, userId);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		
		Map <String, Object> resultRow = null;
		
		for (int i = 0; i < virtualLabList.size(); i++) {
			Object[] resultArray = virtualLabList.get(i);
			
			VirtualLab virtualLab = (VirtualLab) resultArray[0];
			VirtualLabClass virtualLabClass = (VirtualLabClass) resultArray[1];
			int classCount = (Integer) resultArray[2];
			
			resultRow = new HashMap<String, Object>();
			if (virtualLab != null) {
				resultRow.put("virtualLabId", String.valueOf(virtualLab.getVirtualLabId()));
				resultRow.put("userId", String.valueOf(virtualLab.getUserId()));
				resultRow.put("virtualLabTitle", virtualLab.getVirtualLabTitle(locale, true));
				resultRow.put("virtualLabPersonName", virtualLab.getVirtualLabPersonName(locale, true));
				resultRow.put("virtualLabConfirmDescription", virtualLab.getVirtualLabConfirmDescription());
				resultRow.put("virtualLabUseYn", virtualLab.getVirtualLabUseYn());
				resultRow.put("virtualLabStatus", virtualLab.getVirtualLabStatus());
				resultRow.put("virtualLabUniversityField", EdisonExpndoUtil.getCommonCdSearchFieldValue(virtualLab.getVirtualLabUniversityField(), EdisonExpando.CDNM, locale));
				resultRow.put("classCount", String.valueOf(classCount));
			}

			if (classCount > 0 && virtualLabClass != null) {
				resultRow.put("classId", String.valueOf(virtualLabClass.getClassId()));
				resultRow.put("classTitle", virtualLabClass.getClassTitle(locale, true));
				resultRow.put("classCreateDt", new SimpleDateFormat("yyyy-MM-dd").format(virtualLabClass.getClassCreateDt()));
				resultRow.put("classPersonnel", String.valueOf(virtualLabClass.getClassPersonnel()));
			}

			returnList.add(resultRow);
		}
		return returnList;
	}
	
	public List<Map<String, Object>> getVirtualLabClassRegisterList(long groupId, long userId, Locale locale) throws SystemException {
		List<Object[]> virtualLabClassRegisterList = virtualLabFinder.getVirtualLabClassRegisterList(groupId, userId);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		
		Map <String, Object> resultRow = null;
		
		for (int i = 0; i < virtualLabClassRegisterList.size(); i++) {
			Object[] resultArray = virtualLabClassRegisterList.get(i);
			
			VirtualLab virtualLab = (VirtualLab) resultArray[0];
			VirtualLabClass virtualLabClass = (VirtualLabClass) resultArray[1];
			VirtualLabUser virtualLabUser = (VirtualLabUser) resultArray[2];
			
				resultRow = new HashMap<String, Object>();
				
				if(virtualLab != null) {
					resultRow.put("virtualLabId", String.valueOf(virtualLab.getVirtualLabId()));
					resultRow.put("userId", String.valueOf(virtualLab.getUserId()));
					resultRow.put("virtualLabTitle", virtualLab.getVirtualLabTitle(locale, true));
					resultRow.put("virtualLabPersonName", virtualLab.getVirtualLabPersonName(locale, true));
					resultRow.put("virtualLabConfirmDescription", virtualLab.getVirtualLabConfirmDescription());
					resultRow.put("virtualLabStatus", virtualLab.getVirtualLabStatus());
					resultRow.put("virtualLabUniversityField", EdisonExpndoUtil.getCommonCdSearchFieldValue(virtualLab.getVirtualLabUniversityField(), EdisonExpando.CDNM, locale));
					resultRow.put("groupId", String.valueOf(virtualLab.getGroupId()));
					Group group;
					try {
						group = GroupLocalServiceUtil.fetchGroup(virtualLab.getGroupId());
						if (group != null) {
							resultRow.put("groupName", group.getName());
						}
					} catch (SystemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if(virtualLabClass != null) {
					resultRow.put("classId", String.valueOf(virtualLabClass.getClassId()));
					resultRow.put("classTitle", virtualLabClass.getClassTitle(locale, true));
					resultRow.put("classCreateDt", new SimpleDateFormat("yyyy-MM-dd").format(virtualLabClass.getClassCreateDt()));
					resultRow.put("classPersonnel", String.valueOf(virtualLabClass.getClassPersonnel()));
				}
				
				if(virtualLabUser != null) {
					resultRow.put("processNote", String.valueOf(virtualLabUser.getProcessNote()));
					resultRow.put("requestSort", String.valueOf(virtualLabUser.getRequestSort()));
					resultRow.put("createDt", new SimpleDateFormat("yyyy-MM-dd").format(virtualLabUser.getCreateDt()));
				}

			returnList.add(resultRow);
		}
		return returnList;
	}
	
	public Map<String, Object> getVirtualLabClassRegisterInfo(long classId, long userId, long groupId, Locale locale) throws SystemException {
		Object[] virtualLabClassUserInfo = virtualLabFinder.getVirtualLabClassRegisterInfo(classId, userId, groupId);
		Map <String, Object> resultRow = null;
		
		if (virtualLabClassUserInfo != null) {
			VirtualLab virtualLab = (VirtualLab) virtualLabClassUserInfo[0];
			VirtualLabClass virtualLabClass = (VirtualLabClass) virtualLabClassUserInfo[1];
			VirtualLabUser virtualLabUser = (VirtualLabUser) virtualLabClassUserInfo[2];
				
			resultRow = new HashMap<String, Object>();
			
			if(virtualLab != null) {
				resultRow.put("virtualLabId", String.valueOf(virtualLab.getVirtualLabId()));
				resultRow.put("virtualLabTitle", virtualLab.getVirtualLabTitle(locale, true));
				resultRow.put("virtualLabPersonName", virtualLab.getVirtualLabPersonName(locale, true));
				resultRow.put("virtualLabConfirmDescription", virtualLab.getVirtualLabConfirmDescription());
				resultRow.put("virtualLabStatus", virtualLab.getVirtualLabStatus());
				resultRow.put("virtualLabUniversityField", EdisonExpndoUtil.getCommonCdSearchFieldValue(virtualLab.getVirtualLabUniversityField(), EdisonExpando.CDNM, locale));
			}
			
			if(virtualLabClass != null) {
				resultRow.put("classId", virtualLabClass.getClassId());
				resultRow.put("classTitle", virtualLabClass.getClassTitle(locale, true));
				resultRow.put("classStartDt", virtualLabClass.getClassStartDt());
				resultRow.put("classEndDt",virtualLabClass.getClassEndDt());
				resultRow.put("classDescription",virtualLabClass.getClassDescription(locale, true));
				resultRow.put("classPersonnel",virtualLabClass.getClassPersonnel());
				resultRow.put("classCreateDt",virtualLabClass.getClassCreateDt());
			}
			
			if (virtualLabUser != null) {
				resultRow.put("virtualUserId", virtualLabUser.getVirtualLabUserId());
				resultRow.put("userId",virtualLabUser.getUserId());
				resultRow.put("userUseYn",virtualLabUser.getUserUseYn());
				resultRow.put("requestSort",virtualLabUser.getRequestSort());
				resultRow.put("processNote",virtualLabUser.getProcessNote());
				resultRow.put("userStudentNumber", virtualLabUser.getUserStudentNumber());
			}
		}
		return resultRow;
	}
	
	public Map<String, Object> getVirtualLabInfomation(long virtualLabId, Locale locale) throws NoSuchVirtualLabException, SystemException {
		VirtualLab virtualLab = virtualLabPersistence.fetchByPrimaryKey(virtualLabId);
		Map <String, Object> resultRow = null;
		if (virtualLab != null) {
			resultRow = new HashMap<String, Object>();
			User user = UserLocalServiceUtil.fetchUserById(virtualLab.getUserId());
			if (user != null) {
				resultRow.put("userName", user.getFullName());
				resultRow.put("userScreenName", user.getScreenName());
			} else {
				resultRow.put("userName", virtualLab.getUserId());
				resultRow.put("userScreenName", virtualLab.getUserId());
			}
			resultRow.put("virtualLabTitleMap", virtualLab.getVirtualLabTitle());
			resultRow.put("virtualLabPersonNameMap", virtualLab.getVirtualLabPersonName());
			resultRow.put("virtualLabDescriptionMap", virtualLab.getVirtualLabDescription());
			
			resultRow.put("virtualLabId", String.valueOf(virtualLab.getVirtualLabId()));
			resultRow.put("requestUserId", String.valueOf(virtualLab.getUserId()));
			resultRow.put("virtualLabTitle", virtualLab.getVirtualLabTitle(locale, true));
			resultRow.put("virtualLabPersonName", virtualLab.getVirtualLabPersonName(locale, true));
			resultRow.put("virtualLabDescription", virtualLab.getVirtualLabDescription(locale, true));
			resultRow.put("virtualLabConfirmDescription", virtualLab.getVirtualLabConfirmDescription());
			resultRow.put("virtualLabUseYn", virtualLab.getVirtualLabUseYn());
			resultRow.put("virtualLabStatus", virtualLab.getVirtualLabStatus());
			resultRow.put("virtualLabUniversityField", virtualLab.getVirtualLabUniversityField());
			resultRow.put("virtualLabUniversityFieldNm", EdisonExpndoUtil.getCommonCdSearchFieldValue(virtualLab.getVirtualLabUniversityField(), EdisonExpando.CDNM, locale));
			resultRow.put("virtualLabRequestDt", new SimpleDateFormat("yyyy-MM-dd").format(virtualLab.getVirtualLabRequestDt()));
			resultRow.put("virtualLabConfirmDt", new SimpleDateFormat("yyyy-MM-dd").format(virtualLab.getVirtualLabConfirmDt()));
		}
		return resultRow;
	}
	
	public VirtualLab updateVirtualLabStatus(Map<String, String> params) throws NoSuchVirtualLabException, SystemException {
		VirtualLab virtualLab = virtualLabPersistence.findByPrimaryKey(Long.parseLong(params.get("virtualLabId")));
		
		virtualLab.setVirtualLabStatus(String.valueOf(params.get("virtualLabStatus")));
		virtualLab.setVirtualLabConfirmDescription(String.valueOf(params.get("virtualLabConfirmDescription")));
		virtualLab.setVirtualLabConfirmDt(new Date());
		
		virtualLab = virtualLabPersistence.update(virtualLab);
		
		return virtualLab;
	}
	
	public List<Map<String, Object>> getListVirtualLab(Map<String, Object> params, Locale locale) throws SystemException {
		
		List<Object[]> virtualLabList = virtualLabFinder.getListVirtualLab(params, locale);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		
		if (virtualLabList != null) {
			Map <String, Object> resultRow = null;
			
			for (int i = 0; i < virtualLabList.size(); i++) {
				Object[] resultArray = virtualLabList.get(i);
				
				VirtualLab virtualLab = (VirtualLab) resultArray[0];
				int classCount = (Integer) resultArray[1];
				
				resultRow = new HashMap<String, Object>();
				if (virtualLab != null) {
					resultRow.put("virtualLabId", String.valueOf(virtualLab.getVirtualLabId()));
					resultRow.put("userId", String.valueOf(virtualLab.getUserId()));
					resultRow.put("groupId", String.valueOf(virtualLab.getGroupId()));
					Group group = GroupLocalServiceUtil.fetchGroup(virtualLab.getGroupId());
					if (group != null) {
						resultRow.put("groupName", group.getName());
					}
					resultRow.put("virtualLabTitle", virtualLab.getVirtualLabTitle(locale, true));
					resultRow.put("virtualLabTitle", virtualLab.getVirtualLabTitle(locale, true));
					resultRow.put("virtualLabPersonName", virtualLab.getVirtualLabPersonName(locale, true));
					resultRow.put("virtualLabConfirmDescription", virtualLab.getVirtualLabConfirmDescription());
					resultRow.put("virtualLabStatus", virtualLab.getVirtualLabStatus());
					resultRow.put("virtualLabStatusNm", EdisonExpndoUtil.getCommonCdSearchFieldValue(virtualLab.getVirtualLabStatus(), EdisonExpando.CDNM, locale));
					resultRow.put("virtualLabRequestDt", new SimpleDateFormat("yyyy-MM-dd").format(virtualLab.getVirtualLabRequestDt()));
					resultRow.put("virtualLabUniversityField", EdisonExpndoUtil.getCommonCdSearchFieldValue(virtualLab.getVirtualLabUniversityField(), EdisonExpando.CDNM, locale));
					resultRow.put("classCount", String.valueOf(classCount));
					if(virtualLab.getUserId() > 0) {
						User user = userPersistence.fetchByPrimaryKey(virtualLab.getUserId());
						if(user != null) {
							resultRow.put("userScreenName", user.getScreenName());
							resultRow.put("userFirstName", user.getFirstName());
							resultRow.put("userName", user.getFullName() + "(" + user.getScreenName() + ")");
							resultRow.put("virtualLabOwnerName", user.getFirstName() + "(" + user.getScreenName() + ")");
						} else {
							resultRow.put("userScreenName", virtualLab.getUserId());
							resultRow.put("userFirstName", virtualLab.getUserId());
							resultRow.put("userName", virtualLab.getUserId() + "(" + virtualLab.getUserId() + ")");
							resultRow.put("virtualLabOwnerName", virtualLab.getUserId() + "(" + virtualLab.getUserId() + ")");
						}
					}
				}
				
				returnList.add(resultRow);
			}
		}
		return returnList;
	}
	
	public int getCountVirtualLab(Map<String, Object> params, Locale locale) {
		return virtualLabFinder.getCountVirtualLab(params, locale);
	}
	
	public VirtualLab updateVirtualLabInfomation(Map<String, String> params, Locale locale) throws NoSuchVirtualLabException, NumberFormatException, SystemException {
		VirtualLab virtualLab = virtualLabPersistence.findByPrimaryKey(Long.parseLong(params.get("virtualLabId")));
		
		virtualLab.setVirtualLabUniversityField(CustomUtil.strNull(params.get("universityField")));
		virtualLab.setVirtualLabDescriptionMap(CustomUtil.getLocalizationMap(params,"virtualLabDescription"));
		virtualLab.setVirtualLabTitleMap(CustomUtil.getLocalizationMap(params,"virtualLabTitle"));
		virtualLab.setVirtualLabPersonNameMap(CustomUtil.getLocalizationMap(params,"virtualLabPersonName"));
		
		virtualLab = virtualLabPersistence.update(virtualLab);
		return virtualLab;
	}
	
	public VirtualLab updateVirtualLabDisable(long virtualLabId, String disableFlag) throws NoSuchVirtualLabException, NumberFormatException, SystemException {
		VirtualLab virtualLab = virtualLabPersistence.fetchByPrimaryKey(virtualLabId);
		
		if(virtualLab != null) {
			if(disableFlag.equals("Y") || disableFlag.equals("N")) {
				virtualLab.setVirtualLabUseYn(disableFlag);
				virtualLab = virtualLabPersistence.update(virtualLab);
			}
		}
		
		return virtualLab;
	}
	
	@Transactional
	public void transferVirtualLabOwner(long virtualLabId, long userId, long roleId, long companyId) throws NumberFormatException, SystemException, PortalException {
		VirtualLab virtualLab = virtualLabPersistence.fetchByPrimaryKey(virtualLabId);
		if (virtualLab != null) {
			UserGroupRoleCustom userGroupRoleCustom = UserGroupRoleCustomLocalServiceUtil.getUserGroupRoleCustom(virtualLab.getUserId(), virtualLab.getGroupId(), roleId, virtualLabId);
			Role labManagerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);
			Role classOwnerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER);
			Role classManagerRole = RoleLocalServiceUtil.getRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);

			long previousOwnerId = virtualLab.getUserId();
			long groupId = virtualLab.getGroupId();
			// 실험실 관리자 권한 삭제
			if(UserGroupRoleCustomLocalServiceUtil.isRoleCustom(userId, groupId, labManagerRole.getRoleId(), virtualLabId)) {
				UserGroupRoleCustomLocalServiceUtil.removeUserGroupRoleCustom(userId, groupId, labManagerRole.getRoleId(), virtualLabId);
			}
			
			// 클래스 리스트 검색 및 Class Owner 소유자 이전, Class Manager 권한 삭제
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("virtualLabId", virtualLabId);
			params.put("groupId", groupId);
			
			List<Map<String, Object>> classList = VirtualLabClassLocalServiceUtil.getVirtualClassList(params, null);
			if(classList != null) {
				for (Map<String, Object> map : classList) {
					long classId = GetterUtil.get(map.get("classId"), 0L);
					if(classId != 0) {
						// 클래스 매니저로 지정되어 있을경우 매니저 권한 삭제
						if(UserGroupRoleCustomLocalServiceUtil.isRoleCustom(userId, groupId, classManagerRole.getRoleId(), classId)) {
							UserGroupRoleCustomLocalServiceUtil.removeUserGroupRoleCustom(userId, groupId, classManagerRole.getRoleId(), classId);
						}
						// 이전 실험실 소유주가 클래스 소유 권한을 가지고 있을경우 이전
						if(UserGroupRoleCustomLocalServiceUtil.isRoleCustom(previousOwnerId, groupId, classOwnerRole.getRoleId(), classId)) {
							UserGroupRoleCustomLocalServiceUtil.removeUserGroupRoleCustom(previousOwnerId, groupId, classOwnerRole.getRoleId(), classId);
							UserGroupRoleCustomLocalServiceUtil.addUserGroupRoleCustom(userId, groupId,  classOwnerRole.getRoleId(), classId);
						}
					}
				}
			}
			if(userGroupRoleCustom != null) {
				
				userGroupRoleCustom.setUserId(userId);
				virtualLab.setUserId(userId);
				
				virtualLabPersistence.update(virtualLab);
				UserGroupRoleCustomLocalServiceUtil.updateUserGroupRoleCustom(userGroupRoleCustom);
				
				User user = userPersistence.findByPrimaryKey(userId);
				EdisonUserUtil.addSiteRole(user, virtualLab.getGroupId(), EdisonRoleConstants.VIRTUAL_LAB_OWNER);	// VIRTUAL LAB OWNER 권한 추가
				
				UserGroupRoleCustomLocalServiceUtil.removeUserGroupRoleCustom(previousOwnerId, groupId, roleId, virtualLabId); // 이전 소유자 권한 삭제
				
				List<Map<String,String>> customList =  UserGroupRoleCustomLocalServiceUtil.getCustomList(previousOwnerId, groupId, roleId); // 이전 소유자 나머지 소유 갯수 체크
				
				if (customList == null || customList.size() == 0) {	// VIRTUAL LAB OWNER CUSTOM ROLE이 남아있는지 체크
					EdisonUserUtil.deleteSiteRole(UserLocalServiceUtil.getUser(previousOwnerId), groupId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);	// 없으면 삭제
				}
			} else {
				UserGroupRoleCustomLocalServiceUtil.addUserGroupRoleCustom(userId, groupId, roleId, virtualLabId);
				
				virtualLab.setUserId(userId);
				virtualLabPersistence.update(virtualLab);
				
				User user = userPersistence.findByPrimaryKey(userId);
				EdisonUserUtil.addSiteRole(user, virtualLab.getGroupId(), EdisonRoleConstants.VIRTUAL_LAB_OWNER);	// VIRTUAL LAB OWNER 권한 추가
			}
		}
	}
}