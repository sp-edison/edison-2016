/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.model.EdisonAssetCategory;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;
import org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp;
import org.kisti.edison.virtuallaboratory.service.base.VirtualLabClassScienceAppLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;

/**
 * The implementation of the virtual lab class science app local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.virtuallaboratory.service.VirtualLabClassScienceAppLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.virtuallaboratory.service.base.VirtualLabClassScienceAppLocalServiceBaseImpl
 * @see org.kisti.edison.virtuallaboratory.service.VirtualLabClassScienceAppLocalServiceUtil
 */
public class VirtualLabClassScienceAppLocalServiceImpl
	extends VirtualLabClassScienceAppLocalServiceBaseImpl {
public List<Map<String, Object>> getVirtualLabClassScienceAppList (long companyId, long groupId, long classId, Locale locale) throws PortalException, SystemException {
	long entryId = 0;
	ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
	long columnId = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), EdisonExpando.USER_UNIVERSITY).getColumnId();
	Company company = CompanyLocalServiceUtil.getCompany(companyId);
	long companyGroupId = company.getGroupId();
	long vocabularyId = AssetVocabularyLocalServiceUtil.getGroupVocabulary(companyGroupId, EdisonAssetCategory.GLOBAL_DOMAIN).getVocabularyId();
	long parentGroupId = GroupLocalServiceUtil.getGroup(groupId).getParentGroupId();
	
	if(parentGroupId != 0) {
		entryId = AssetEntryLocalServiceUtil.fetchEntry(Group.class.getName(), groupId).getEntryId();
	}

	List<Object[]> scienceAppList = virtualLabClassScienceAppFinder.getVirtualLabClassScienceAppList(entryId, vocabularyId, columnId, classId, locale);
	List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
	
	Map <String, Object> resultRow = null;
	
	for(int i = 0; i < scienceAppList.size(); i++) {
		Object[] resultArray = scienceAppList.get(i);
		resultRow = new HashMap<String, Object>();
		resultRow.put("scienceAppId", CustomUtil.strNull(resultArray[0]));
		resultRow.put("scienceAppName", CustomUtil.strNull(CustomUtil.strNull(resultArray[1])));
		resultRow.put("scienceAppTitle", CustomUtil.strNull(LocalizationUtil.getLocalization(CustomUtil.strNull(resultArray[2]), locale.getLanguage())));
		resultRow.put("scienceAppVersion", CustomUtil.strNull(resultArray[3]));
		resultRow.put("userId", CustomUtil.strNull(resultArray[4]));
		resultRow.put("scienceAppUniversityNm", CustomUtil.strNull(resultArray[5]));
		resultRow.put("scienceAppUniversityId", CustomUtil.strNull(resultArray[6]));
		try {
			User user = userPersistence.fetchByPrimaryKey((Long) resultArray[4]);
			if(user != null) {
				resultRow.put("userFirstName", user.getFirstName());
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		returnList.add(resultRow);
	}
	
	return returnList;
}

public List<Map<String, Object>> getScienceAppList(long companyId, long groupId, long classId, String searchField, Locale locale) throws PortalException, SystemException {
	long entryId = 0;
	ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
	long columnId = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), EdisonExpando.USER_UNIVERSITY).getColumnId();
	Company company = CompanyLocalServiceUtil.getCompany(companyId);
	long companyGroupId = company.getGroupId();
	long vocabularyId = AssetVocabularyLocalServiceUtil.getGroupVocabulary(companyGroupId, EdisonAssetCategory.GLOBAL_DOMAIN).getVocabularyId();
	long parentGroupId = GroupLocalServiceUtil.getGroup(groupId).getParentGroupId();
	
	if(parentGroupId != 0) {
		entryId = AssetEntryLocalServiceUtil.fetchEntry(Group.class.getName(), groupId).getEntryId();
	}

	List<Object[]> scienceAppList = virtualLabClassScienceAppFinder.getScienceAppList(entryId, vocabularyId, columnId, classId, searchField, locale);
	List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
	
	Map <String, Object> resultRow = null;
	
	for(int i = 0; i < scienceAppList.size(); i++) {
		Object[] resultArray = scienceAppList.get(i);
		resultRow = new HashMap<String, Object>();
		resultRow.put("scienceAppId", CustomUtil.strNull(resultArray[0]));
		resultRow.put("scienceAppName", CustomUtil.strNull((CustomUtil.strNull(resultArray[1]))));
		resultRow.put("scienceAppVersion", CustomUtil.strNull(resultArray[2]));
		resultRow.put("userId", CustomUtil.strNull(resultArray[3]));
		resultRow.put("scienceAppTitle", CustomUtil.strNull(resultArray[4]));
		resultRow.put("scienceAppCheck", CustomUtil.strNull(resultArray[5]));
		try {
			User user = userPersistence.fetchByPrimaryKey((Long) resultArray[3]);
			if(user != null) {
				resultRow.put("userFirstName", user.getFirstName());
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		returnList.add(resultRow);
	}
	
	return returnList;
}

@Transactional
public void insertVirtualLabClassScienceApp(long classId, long scienceAppId) throws SystemException {
	VirtualLabClassScienceApp virtualLabClassScienceApp = virtualLabClassScienceAppPersistence.create(counterLocalService.increment("VirtualLabClassScienceApp"));
	virtualLabClassScienceApp.setCreateDate(new Date());
	virtualLabClassScienceApp.setScienceAppId(scienceAppId);
	
	virtualLabClassScienceAppPersistence.update(virtualLabClassScienceApp);
	virtualLabClassPersistence.addVirtualLabClassScienceApp(classId, virtualLabClassScienceApp.getScienceAppSeqNo());
}

@Transactional
public void insertVirtualLabClassScienceAppList(long companyId, long classId, long groupId, Object scienceAppCheck, Locale locale) throws PortalException, SystemException {
	long entryId = 0;
	ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId, User.class.getName(), ExpandoTableConstants.DEFAULT_TABLE_NAME);
	long columnId = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), EdisonExpando.USER_UNIVERSITY).getColumnId();
	Company company = CompanyLocalServiceUtil.getCompany(companyId);
	long companyGroupId = company.getGroupId();
	long vocabularyId = AssetVocabularyLocalServiceUtil.getGroupVocabulary(companyGroupId, EdisonAssetCategory.GLOBAL_DOMAIN).getVocabularyId();
	long parentGroupId = GroupLocalServiceUtil.getGroup(groupId).getParentGroupId();
	
	if(parentGroupId != 0) {
		entryId = AssetEntryLocalServiceUtil.fetchEntry(Group.class.getName(), groupId).getEntryId();
	}

	// 기존 설정 삭제
	List<Object[]> scienceAppList = virtualLabClassScienceAppFinder.getVirtualLabClassScienceAppList(entryId, vocabularyId, columnId, classId, locale);
	if(scienceAppList != null && scienceAppList.size() > 0) {
		for (int i = 0; i < scienceAppList.size(); i++) {
			virtualLabClassScienceAppPersistence.remove((Long) (scienceAppList.get(i)[6]));	// 6번째 sienceAppSeqNo
		}
	}
	
	// 새설정 적용
	if (scienceAppCheck != null) {
		if(scienceAppCheck instanceof String) {
			virtualLabClassScienceAppLocalService.insertVirtualLabClassScienceApp(classId, GetterUtil.get((String)scienceAppCheck, 0L));
		} else if(scienceAppCheck instanceof String[]) {
			String[] scienceAppId = (String[]) scienceAppCheck;
			for (int i = 0; i < scienceAppId.length; i++) {
				virtualLabClassScienceAppLocalService.insertVirtualLabClassScienceApp(classId, GetterUtil.get(scienceAppId[i], 0L));
			}
		}
	}
}
}