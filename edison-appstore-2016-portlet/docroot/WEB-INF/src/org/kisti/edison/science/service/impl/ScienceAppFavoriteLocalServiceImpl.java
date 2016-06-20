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

package org.kisti.edison.science.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.model.EdisonAssetCategory;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.science.NoSuchScienceAppFavoriteException;
import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.model.ScienceAppFavorite;
import org.kisti.edison.science.service.base.ScienceAppFavoriteLocalServiceBaseImpl;
import org.kisti.edison.science.service.persistence.ScienceAppFavoritePK;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoTable;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;
import com.liferay.portlet.expando.service.ExpandoTableLocalServiceUtil;

/**
 * The implementation of the science app favorite local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.science.service.ScienceAppFavoriteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.base.ScienceAppFavoriteLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.ScienceAppFavoriteLocalServiceUtil
 */
public class ScienceAppFavoriteLocalServiceImpl
	extends ScienceAppFavoriteLocalServiceBaseImpl {
	
	public int getScienceAppFavoriteCount(long scienceAppId, long userId) throws SystemException {
		
		int favoriteCount = 0;
		if(scienceAppId != 0){
			ScienceAppFavoritePK scienceAppFavoritePK = new ScienceAppFavoritePK(scienceAppId, userId);
			ScienceAppFavorite solverFavorite = scienceAppFavoritePersistence.fetchByPrimaryKey(scienceAppFavoritePK);
			if (solverFavorite != null) {
				favoriteCount = 1;
			}
		}
		return favoriteCount;
	}
	
	public int updateScienceAppFavorite(long userId, long scienceAppId, long groupId) throws NoSuchScienceAppFavoriteException, SystemException {
		int favoriteCount = 0;
		if(scienceAppId != 0){
			
			ScienceAppFavoritePK scienceAppFavoritePK = new ScienceAppFavoritePK(scienceAppId, userId);
			ScienceAppFavorite scienceAppFavorite = scienceAppFavoritePersistence.fetchByPrimaryKey(scienceAppFavoritePK);		
			if(scienceAppFavorite != null){
				scienceAppFavoritePersistence.remove(scienceAppFavoritePK);
				favoriteCount = 1;
			}else {
				scienceAppFavorite = scienceAppFavoritePersistence.create(scienceAppFavoritePK);
				scienceAppFavorite.setGroupId(groupId);
				scienceAppFavoritePersistence.update(scienceAppFavorite);
				favoriteCount = 0;
			}
		}
		return favoriteCount;
	}
	
	public List<Map<String, Object>> getFavoriteAppList(long companyId, long groupId, long userId, Locale locale, boolean widthFile) throws SystemException {
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		
		try {
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
			
			List<Object[]> resultList = scienceAppFinder.getFavoriteAppList(entryId, vocabularyId, columnId, userId, locale);
			if(resultList != null) {
				for (int i = 0; i < resultList.size(); i++) {
					Object[] resultArray = resultList.get(i);
					ScienceApp scienceApp = (ScienceApp) resultArray[0];
					long universityId = (Long) resultArray[1];
					
					Map<String, Object> resultRow = new HashMap<String, Object>();
					resultRow.put("scienceAppId", scienceApp.getScienceAppId());
					resultRow.put("userId", scienceApp.getUserId());
					resultRow.put("groupId", scienceApp.getGroupId());
					resultRow.put("name", scienceApp.getName());
					resultRow.put("title", scienceApp.getTitle(locale));
					resultRow.put("version", scienceApp.getVersion());
					resultRow.put("createDate", CustomUtil.StringToDateFormat(CustomUtil.strNull(scienceApp.getCreateDate()), "yyyy-MM-dd HH:mm:ss"));
					resultRow.put("developersTextArea",scienceApp.getDevelopers());
					resultRow.put("developers", StringUtil.split(scienceApp.getDevelopers(locale), StringPool.NEW_LINE));
					
					User user = userPersistence.fetchByPrimaryKey(scienceApp.getUserId());
					if(user != null) {
						resultRow.put("screenName", user.getScreenName());
						resultRow.put("userFirstName", user.getFirstName());
						resultRow.put("affiliationId", universityId);
						resultRow.put("affiliation", EdisonExpndoUtil.getCommonCdSearchFieldValue(universityId, EdisonExpando.CDNM, locale));
					}
					
					if(widthFile){
						//파일 - icon
						if(scienceApp.getIconId()!=0){
							resultRow.put("iconId", scienceApp.getIconId());
							DLFileEntry iconDl =  DLFileEntryLocalServiceUtil.getDLFileEntry(scienceApp.getIconId());
							resultRow.put("iconRepositoryId", iconDl.getRepositoryId());
							resultRow.put("iconUuid", iconDl.getUuid());
							resultRow.put("iconTitle", iconDl.getTitle());
						}
						
						//메뉴얼
						long manualId = GetterUtil.getLong(scienceApp.getManualId(locale),0l);
						if(manualId !=0){
							resultRow.put("manualId", manualId);
							DLFileEntry manualDl =DLFileEntryLocalServiceUtil.getDLFileEntry(manualId);
							resultRow.put("manualRepositoryId", manualDl.getRepositoryId());
							resultRow.put("manualUuid", manualDl.getUuid());
							resultRow.put("manualTitle", manualDl.getTitle());
						}
					}
					
					returnList.add(resultRow);
				}
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnList;
	}
	
	public ScienceAppFavorite deleteFavoriteApp(long scienceAppId, long userId) throws NoSuchScienceAppFavoriteException, SystemException {
		return scienceAppFavoritePersistence.remove(new ScienceAppFavoritePK(scienceAppId, userId));
	}
	
	public void deleteFavoriteApp(long scienceAppId) throws SystemException {
		scienceAppFavoritePersistence.removeByselectFavoriteList(scienceAppId);
	}
	
}