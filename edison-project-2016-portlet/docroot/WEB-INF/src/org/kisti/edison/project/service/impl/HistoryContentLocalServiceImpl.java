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
import org.kisti.edison.project.service.base.HistoryContentLocalServiceBaseImpl;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonExpndoUtil;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portlet.expando.model.ExpandoValue;

/**
 * The implementation of the history content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.project.service.HistoryContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.project.service.base.HistoryContentLocalServiceBaseImpl
 * @see org.kisti.edison.project.service.HistoryContentLocalServiceUtil
 */
public class HistoryContentLocalServiceImpl extends HistoryContentLocalServiceBaseImpl {

	
	public List<Map<String, Object>> getContentCenterList(String projectYn,  String propertyKey, Locale locale) throws Exception{
		
		List<Object[]> contentCenterList  = historyContentFinder.getContentCenterList(projectYn, propertyKey);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		
		for (int i = 0; i < contentCenterList.size(); i++) {
			Object[] contentCenterObj = (Object[])contentCenterList.get(i);
			resultRow = new HashMap<String, Object>();
			
			if(contentCenterObj != null){
				int projectCnt = 0;
				if(contentCenterObj[4] != null && contentCenterObj[5] != null){
					projectCnt = (Integer)contentCenterObj[4] + (Integer)contentCenterObj[5];
				}
				
				if(projectCnt > 0){
					resultRow.put("projectCategoryId", 	contentCenterObj[0]);    
					resultRow.put("projectCategoryNm", 	contentCenterObj[1]);    
					resultRow.put("prpertyKey", 		contentCenterObj[2]);    
					resultRow.put("propertyValue",		LanguageUtil.get(locale, CustomUtil.strNull(contentCenterObj[3])));    
					resultRow.put("projectCnt",		 	projectCnt);    
					
					returnList.add(resultRow);
				}
			}
			
		}
		return returnList;
	}
	
	public List<Map<String, Object>> getContentDatailList(String projectYn, long columnId, long categoryId, String languageId, Locale locale) throws Exception{
		
		List<Object[]> contentDetailList  = historyContentFinder.getContentDatailList(projectYn, columnId, categoryId, languageId);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		
		for (int i = 0; i < contentDetailList.size(); i++) {
			Object[] contentDetailObj = (Object[])contentDetailList.get(i);
			resultRow = new HashMap<String, Object>();
			
			if(contentDetailObj != null){
				resultRow.put("projectCategoryId", 	contentDetailObj[0]);    
				resultRow.put("projectCategoryNm", 	contentDetailObj[1]);    
				resultRow.put("prpertyKey", 		contentDetailObj[2]);    
				resultRow.put("propertyValue",		contentDetailObj[3]);    
				resultRow.put("title", 				contentDetailObj[4]);    
				resultRow.put("screenName", 		contentDetailObj[5]);    
				resultRow.put("firstName", 			contentDetailObj[6]);    
				resultRow.put("insertId", 			contentDetailObj[7]);    
				resultRow.put("insertDate", 		contentDetailObj[8]);    
				
				String affiliation = EdisonExpndoUtil.getCommonCdSearchFieldValue(String.valueOf(contentDetailObj[9]), EdisonExpando.CDNM, locale);
				resultRow.put("affiliation", 		affiliation);    
				
				returnList.add(resultRow);
			}
			
		}
		return returnList;
	}
}