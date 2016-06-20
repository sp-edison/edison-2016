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

package org.kisti.edison.customauthmanager.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;
import org.kisti.edison.customauthmanager.model.UserGroupRoleCustom;
import org.kisti.edison.customauthmanager.service.base.UserGroupRoleCustomLocalServiceBaseImpl;
import org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.GBatisUtil;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * The implementation of the user group role custom local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.customauthmanager.service.base.UserGroupRoleCustomLocalServiceBaseImpl
 * @see org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil
 */
public class UserGroupRoleCustomLocalServiceImpl
	extends UserGroupRoleCustomLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil} to access the user group role custom local service.
	 */
	public boolean isRoleCustom(long userId, long groupId, long roleId, long customId) {
		UserGroupRoleCustomPK userGroupRoleCustomPK = new UserGroupRoleCustomPK(userId, groupId, roleId, customId);
		UserGroupRoleCustom userGroupRoleCustom;
		try {
			userGroupRoleCustom = userGroupRoleCustomPersistence.fetchByPrimaryKey(userGroupRoleCustomPK);
			if (userGroupRoleCustom == null) {
				return false;
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public UserGroupRoleCustom getUserGroupRoleCustom(long userId, long groupId, long roleId, long customId) throws SystemException {
		UserGroupRoleCustomPK userGroupRoleCustomPK = new UserGroupRoleCustomPK(userId, groupId, roleId, customId);
		return userGroupRoleCustomPersistence.fetchByPrimaryKey(userGroupRoleCustomPK);
	}
	
	public UserGroupRoleCustom addUserGroupRoleCustom(long userId, long groupId, long roleId, long customId) {
		UserGroupRoleCustomPK userGroupRoleCustomPK = new UserGroupRoleCustomPK(userId, groupId, roleId, customId);
		UserGroupRoleCustom userGroupRoleCustom = null;
		try {
			userGroupRoleCustom = userGroupRoleCustomPersistence.fetchByPrimaryKey(userGroupRoleCustomPK);
			if(userGroupRoleCustom == null) {
				userGroupRoleCustom = userGroupRoleCustomPersistence.create(userGroupRoleCustomPK);
				userGroupRoleCustom.setCreateDate(new Date());
				userGroupRoleCustomPersistence.update(userGroupRoleCustom);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userGroupRoleCustom;
	}
	
	public UserGroupRoleCustom removeUserGroupRoleCustom(long userId, long groupId, long roleId, long customId) {
		UserGroupRoleCustomPK userGroupRoleCustomPK = new UserGroupRoleCustomPK(userId, groupId, roleId, customId);
		UserGroupRoleCustom userGroupRoleCustom = null;
		try {
			userGroupRoleCustom = userGroupRoleCustomPersistence.remove(userGroupRoleCustomPK);
		} catch (NoSuchUserGroupRoleCustomException e) {
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userGroupRoleCustom;
	}
	
	public List<Map<String, String>> getUserCustomList(long groupId, long roleId) throws SystemException {
		List<Map<String, String>> resultList = null;
		List<UserGroupRoleCustom> userGroupRoleCustomList = userGroupRoleCustomPersistence.findByGroupIdRoleId(groupId, roleId);
		if(userGroupRoleCustomList != null && userGroupRoleCustomList.size() > 0) {
			resultList = new ArrayList<Map<String, String>>();
			for (UserGroupRoleCustom userGroupRoleCustom : userGroupRoleCustomList) {
				Map<String, String> result = new HashMap<String, String>();
				
				User user = UserLocalServiceUtil.fetchUserById(userGroupRoleCustom.getUserId());
				if(user != null) {
					result.put("userScreenName", user.getScreenName());
					result.put("userFullName", user.getFullName());
					result.put("userFirstName", user.getFirstName());
					result.put("userEmailAddress", user.getEmailAddress());
					result.put("userJobTitle", user.getJobTitle());
				}
				
				result.put("userId", String.valueOf(userGroupRoleCustom.getUserId()));
				result.put("groupId", String.valueOf(userGroupRoleCustom.getGroupId()));
				result.put("roleId", String.valueOf(userGroupRoleCustom.getRoleId()));
				result.put("customId", String.valueOf(userGroupRoleCustom.getCustomId()));
				result.put("createDate", new SimpleDateFormat("yyyy-MM-dd").format(userGroupRoleCustom.getCreateDate()));
				resultList.add(result);
			}
		}
		return resultList;
	}
	
	public List<Map<String, String>> getCustomList(long userId, long groupId, long roleId) throws SystemException {
		List<Map<String, String>> resultList = null;
		List<UserGroupRoleCustom> userGroupRoleCustomList = userGroupRoleCustomPersistence.findByUserIdGroupIdRoleId(userId, groupId, roleId);
		
		if(userGroupRoleCustomList != null && userGroupRoleCustomList.size() > 0) {
			resultList = new ArrayList<Map<String, String>>();
			for (UserGroupRoleCustom userGroupRoleCustom : userGroupRoleCustomList) {
				Map<String, String> result = new HashMap<String, String>();
				
				User user = UserLocalServiceUtil.fetchUserById(userGroupRoleCustom.getUserId());
				if(user != null) {
					result.put("userScreenName", user.getScreenName());
					result.put("userFullName", user.getFullName());
					result.put("userFirstName", user.getFirstName());
					result.put("userEmailAddress", user.getEmailAddress());
					result.put("userJobTitle", user.getJobTitle());
				}
				
				result.put("userId", String.valueOf(userGroupRoleCustom.getUserId()));
				result.put("groupId", String.valueOf(userGroupRoleCustom.getGroupId()));
				result.put("roleId", String.valueOf(userGroupRoleCustom.getRoleId()));
				result.put("customId", String.valueOf(userGroupRoleCustom.getCustomId()));
				result.put("createDate", new SimpleDateFormat("yyyy-MM-dd").format(userGroupRoleCustom.getCreateDate()));

				resultList.add(result);
			}
		}
		return resultList;
	}
	
	public List<Long> getCustomIdList(long userId, long groupId, long roleId) throws SystemException {
		List<Long> resultList = null;
		List<UserGroupRoleCustom> userGroupRoleCustomList = userGroupRoleCustomPersistence.findByUserIdGroupIdRoleId(userId, groupId, roleId);
		
		if(userGroupRoleCustomList != null && userGroupRoleCustomList.size() > 0) {
			resultList = new ArrayList<Long>();
			for (UserGroupRoleCustom userGroupRoleCustom : userGroupRoleCustomList) {
				resultList.add(userGroupRoleCustom.getCustomId());
			}
		}
		return resultList;
	}
	
	public List<Map<String, String>> getUserList(long groupId, long roleId, long customId) throws SystemException {
		List<Map<String, String>> resultList = null;
		List<UserGroupRoleCustom> userGroupRoleCustomList = userGroupRoleCustomPersistence.findByGroupIdRoleIdCustomId(groupId, roleId, customId);
		
		if(userGroupRoleCustomList != null && userGroupRoleCustomList.size() > 0) {
			resultList = new ArrayList<Map<String, String>>();
			for (UserGroupRoleCustom userGroupRoleCustom : userGroupRoleCustomList) {
				Map<String, String> result = new HashMap<String, String>();
				
				User user = UserLocalServiceUtil.fetchUserById(userGroupRoleCustom.getUserId());
				if(user != null) {
					result.put("userScreenName", user.getScreenName());
					result.put("userFullName", user.getFullName());
					result.put("userFirstName", user.getFirstName());
					result.put("userEmailAddress", user.getEmailAddress());
					result.put("userJobTitle", user.getJobTitle());
				}
				
				result.put("userId", String.valueOf(userGroupRoleCustom.getUserId()));
				result.put("groupId", String.valueOf(userGroupRoleCustom.getGroupId()));
				result.put("roleId", String.valueOf(userGroupRoleCustom.getRoleId()));
				result.put("customId", String.valueOf(userGroupRoleCustom.getCustomId()));
				result.put("createDate", new SimpleDateFormat("yyyy-MM-dd").format(userGroupRoleCustom.getCreateDate()));

				resultList.add(result);
			}
		}
		
		return resultList;
	}
	
	public List<Long> getUserIdList(long groupId, long roleId, long customId) throws SystemException {
		List<UserGroupRoleCustom> userGroupRoleCustomList = userGroupRoleCustomPersistence.findByGroupIdRoleIdCustomId(groupId, roleId, customId);
		List<Long> userIdArray = null;
		
		if(userGroupRoleCustomList != null && userGroupRoleCustomList.size() > 0) {
			userIdArray = new ArrayList<Long>();
			for (int i = 0; i < userGroupRoleCustomList.size(); i++) {
				userIdArray.add(userGroupRoleCustomList.get(i).getUserId());
			}
		}
		return userIdArray;
	}
	
	public String checkRoleVirtualLabClass(long companyId, long groupId, long userId, long virtualLabId, long classId) throws SystemException {
		Role virtualLabOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);
		Role virtualLabManagerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);
		Role virtualClassOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER);
		Role virtualClassManagerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);

		if (isRoleCustom(userId, groupId, virtualLabOwnerRole.getRoleId(), virtualLabId)) {
			return virtualLabOwnerRole.getName();
		} else if(isRoleCustom(userId, groupId, virtualLabManagerRole.getRoleId(), virtualLabId)) {
			return virtualLabManagerRole.getName(); 
		}
		
		if(classId > 0) {
			if(isRoleCustom(userId, groupId, virtualClassOwnerRole.getRoleId(), classId)) {
				return virtualClassOwnerRole.getName(); 
			} else if(isRoleCustom(userId, groupId, virtualClassManagerRole.getRoleId(), classId)) {
				return virtualClassManagerRole.getName(); 
			}
		}
		return null;
	}
	
	/*
	 * 솔버 오너 또는 매니저 인지 확인하는 메서드
	 * return true : 오너 또는 매니저 false : 그외
	 */
	public boolean isAdminRoleSolver(long companyId, long groupId, long userId, long solverId) throws SystemException {
		Role solverOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.SOLVER_OWNER);
		Role solverManagerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.SOLVER_MANAGER);

		if(solverId > 0) {
			if (isRoleCustom(userId, groupId, solverOwnerRole.getRoleId(), solverId)) {
				return true;
			} else if(isRoleCustom(userId, groupId, solverManagerRole.getRoleId(), solverId)) {
				return true; 
			}
		}
		
		return false;
	}
	
	/*
	 * 가상실험실, 가상 클래스 오너 또는 매니저 인지 확인하는 메서드
	 * return true : 오너 또는 매니저 false : 그외
	 */
	public boolean isAdminRoleVirtualLabClass(long companyId, long groupId, long userId, long classId) throws SystemException {
		Role virtualLabOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_OWNER);
		Role virtualLabManagerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_LAB_MANAGER);
		Role virtualClassOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_OWNER);
		Role virtualClassManagerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.VIRTUAL_CLASS_MANAGER);
		
		long virtualLabId = GetterUtil.get(userGroupRoleCustomFinder.getClassVirtualLabId(classId), 0L);
		
		if(virtualLabId > 0) {
			if (isRoleCustom(userId, groupId, virtualLabOwnerRole.getRoleId(), virtualLabId)) {
				return true;
			} else if(isRoleCustom(userId, groupId, virtualLabManagerRole.getRoleId(), virtualLabId)) {
				return true; 
			}
		}
		
		if(classId > 0) {
			if(isRoleCustom(userId, groupId, virtualClassOwnerRole.getRoleId(), classId)) {
				return true; 
			} else if(isRoleCustom(userId, groupId, virtualClassManagerRole.getRoleId(), classId)) {
				return true; 
			}
		}
		return false;
	}
	
	public Integer getSiteLeaveOwnerTotalCnt(long userId, long labRoleId, long groupId,  long classRoleId) {
		Object[] userGroupRoleCustomTotalArray = userGroupRoleCustomFinder.getSiteLeaveOwnerTotalCnt(userId, labRoleId,groupId, classRoleId);
		
		int totalCnt = 0;
		if(userGroupRoleCustomTotalArray != null){
			for(Object userGroupRoleCustom : userGroupRoleCustomTotalArray){
				totalCnt += Integer.parseInt(CustomUtil.strNull(userGroupRoleCustom,"0"));
			}
			
		}
		return totalCnt;
	}
	
	
	/* 
	 * 내 사이트에서 탈퇴시 owner인 content 리스트 반환
	 * */
	public List<Map<String, String>> getContentOwnerList(long userId, long roleId, long groupId, String languageId) throws SystemException {
		List<Map<String, String>> resultList = null;
		List<Object[]> userGroupRoleCustomList = userGroupRoleCustomFinder.getContentOwnerList(userId, roleId, groupId,languageId);
		
		if(userGroupRoleCustomList != null && userGroupRoleCustomList.size() > 0) {
			resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < userGroupRoleCustomList.size(); i++) {
				Object[] obj = userGroupRoleCustomList.get(i);
				
				Map<String, String> result = new HashMap<String, String>();
				result.put("userId", String.valueOf(obj[0]));
				result.put("groupId", String.valueOf(obj[1]));
				result.put("customId", String.valueOf(obj[2]));
				result.put("contentDiv", String.valueOf(obj[3]));
				result.put("title", String.valueOf(obj[4]));

				resultList.add(result);
			}
		}
		
		return resultList;
	}
	/* 
	 * 내 사이트에서 탈퇴시 owner인 virtaulLab 리스트 반환
	 * */
	public List<Map<String, String>> getVirtualLabOwnerList(long userId, long roleId, long groupId,  String languageId) throws SystemException {
		List<Map<String, String>> resultList = null;
		List<Object[]> userGroupRoleCustomList = userGroupRoleCustomFinder.getVirtualLabOwnerList(userId, roleId, groupId, languageId);
		
		if(userGroupRoleCustomList != null && userGroupRoleCustomList.size() > 0) {
			resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < userGroupRoleCustomList.size(); i++) {
				Object[] obj = userGroupRoleCustomList.get(i);
				
				Map<String, String> result = new HashMap<String, String>();
				result.put("userId", String.valueOf(obj[0]));
				result.put("groupId", String.valueOf(obj[1]));
				result.put("virtualLabPersonName", String.valueOf(obj[2]));
				result.put("virtualLabTitle", String.valueOf(obj[3]));
				
				resultList.add(result);
			}
		}
		
		return resultList;
	}
	/* 
	 * 내 사이트에서 탈퇴시 owner인 virtaulLab 리스트 반환
	 * */
	public List<Map<String, String>> getVirtaulClassOwnerList(long userId, long roleId, long groupId, String languageId) throws SystemException {
		List<Map<String, String>> resultList = null;
		List<Object[]> userGroupRoleCustomList = userGroupRoleCustomFinder.getVirtaulClassOwnerList(userId, roleId, groupId, languageId);
		
		if(userGroupRoleCustomList != null && userGroupRoleCustomList.size() > 0) {
			resultList = new ArrayList<Map<String, String>>();
			for (int i = 0; i < userGroupRoleCustomList.size(); i++) {
				Object[] obj = userGroupRoleCustomList.get(i);
				
				Map<String, String> result = new HashMap<String, String>();
				result.put("userId", String.valueOf(obj[0]));
				result.put("groupId", String.valueOf(obj[1]));
				result.put("classTitle", String.valueOf(obj[2]));
				
				resultList.add(result);
			}
		}
		
		return resultList;
	}
	
	
	public UserGroupRoleCustom deleteUserGroupRoleCustomManager(long userId, long groupId, long roleId, long customId) throws SystemException, NoSuchUserGroupRoleCustomException {
		UserGroupRoleCustomPK userGroupRoleCustomPK = new UserGroupRoleCustomPK(userId, groupId, roleId, customId);
		return userGroupRoleCustomPersistence.remove(userGroupRoleCustomPK);
	}

}