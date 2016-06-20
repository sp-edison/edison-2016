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

package org.kisti.edison.project.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.project.service.base.HistoryScienceAppLocalServiceBaseImpl;
import org.kisti.edison.project.service.persistence.HistoryScienceAppFinder;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.util.PortalUtil;

/**
 * The implementation of the history science app local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.project.service.HistoryScienceAppLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.project.service.base.HistoryScienceAppLocalServiceBaseImpl
 * @see org.kisti.edison.project.service.HistoryScienceAppLocalServiceUtil
 */
public class HistoryScienceAppLocalServiceImpl extends HistoryScienceAppLocalServiceBaseImpl {

	public List<Map<String, Object>> getMajorAchievementsList(String projectYn, String key, long groupId) throws Exception{
	
		List<Object[]> majorAchievementList  = historyScienceAppFinder.getMajorAchievementsList(projectYn, key);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		

		long appDetailPlid = PortalUtil.getPlidFromPortletId(groupId, false, "edisonprojectapp_WAR_edisonproject2016portlet");
		long contentDetailPlid = PortalUtil.getPlidFromPortletId(groupId, false, "edisonprojectcontent_WAR_edisonproject2016portlet");
		
		for (int i = 0; i < majorAchievementList.size(); i++) {
			Object[] achievementObj = (Object[])majorAchievementList.get(i);
			resultRow = new HashMap<String, Object>();
			
			if(achievementObj != null ){
				resultRow.put("projectCategoryId", 	achievementObj[0]);    
				resultRow.put("projectCategoryNm", 	achievementObj[1]);    
				resultRow.put("propertyKey", 		achievementObj[2]);    
				resultRow.put("propertyValue",		achievementObj[3]);
				resultRow.put("conCnt",				achievementObj[4]);
				resultRow.put("hisConCnt",			achievementObj[5]);
				resultRow.put("appCnt",				achievementObj[6]);
				resultRow.put("hisAppCnt",			achievementObj[7]);
				resultRow.put("appDetailPlid",		appDetailPlid);
				resultRow.put("contentDetailPlid",	contentDetailPlid);

				returnList.add(resultRow);
			}
			
		}
		return returnList;
	}

	public List<Map<String, Object>> getScienceAppCenterList(String propertyKey, Locale locale) throws Exception{
		
		List<Object[]> scienceAppCenterList  = historyScienceAppFinder.getScienceAppCenterList(propertyKey);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		
		for (int i = 0; i < scienceAppCenterList.size(); i++) {
			Object[] scienceAppCenterObj = (Object[])scienceAppCenterList.get(i);
			resultRow = new HashMap<String, Object>();
			
			if(scienceAppCenterObj != null){
				int projectCnt = 0;
				if(scienceAppCenterObj[4] != null && scienceAppCenterObj[5] != null){
					projectCnt = (Integer)scienceAppCenterObj[4] + (Integer)scienceAppCenterObj[5];
				}
				
				if(projectCnt > 0){
					resultRow.put("projectCategoryId", 	scienceAppCenterObj[0]);
					resultRow.put("projectCategoryNm", 	scienceAppCenterObj[1]);    
					resultRow.put("prpertyKey", 		scienceAppCenterObj[2]);    
					resultRow.put("propertyValue",		LanguageUtil.get(locale, CustomUtil.strNull(scienceAppCenterObj[3])));    
					resultRow.put("projectCnt",		 	projectCnt);    
					
					
					returnList.add(resultRow);
				}
			}
			
		}
		return returnList;
	}
	
	
	public List<Map<String, Object>> getAppDetailList(long jobPhase, long columnId, long categoryId, String languageId, Locale locale) throws Exception{
		
		List<Object[]> appDetailList  = historyScienceAppFinder.getAppDetailList(jobPhase, columnId, categoryId, languageId);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		
		for (int i = 0; i < appDetailList.size(); i++) {
			Object[] appDetailObj = (Object[])appDetailList.get(i);
			resultRow = new HashMap<String, Object>();
			
			if(appDetailObj != null){
				resultRow.put("scienceAppId", 		appDetailObj[0]);    
				resultRow.put("groupId", 			appDetailObj[1]);    
				resultRow.put("projectCategoryId", 	appDetailObj[2]);    
				resultRow.put("projectCategoryNm", 	appDetailObj[3]);    
				resultRow.put("propertyKey", 		appDetailObj[4]);    
				resultRow.put("propertyValue",		appDetailObj[5]);    
				resultRow.put("appTitle", 			appDetailObj[6]);    
				
				String affiliation = "";
				if(!"".equals(String.valueOf(appDetailObj[7])) && !"0".equals(String.valueOf(appDetailObj[7]))){
					affiliation = EdisonExpndoUtil.getCommonCdSearchFieldValue(String.valueOf(appDetailObj[7]), EdisonExpando.CDNM, locale);
				}
				resultRow.put("affiliation", 		affiliation);    
				resultRow.put("authorId", 			appDetailObj[8]);    
				resultRow.put("firstName", 			appDetailObj[9]);    
				resultRow.put("screenName", 		appDetailObj[10]);    
				resultRow.put("appVersion", 		appDetailObj[11]);    
				resultRow.put("runtime", 			appDetailObj[12]);    
				resultRow.put("executeCount", 		appDetailObj[13]);    
				resultRow.put("averageRuntime", 	appDetailObj[14]);   
				resultRow.put("userCount", 			appDetailObj[15]);   
				resultRow.put("createDate", 		appDetailObj[16]);   
				
				returnList.add(resultRow);
			}
			
		}
		return returnList;
	}
}