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

package org.kisti.edison.content.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.kisti.edison.content.model.GeneralContent;
import org.kisti.edison.content.service.base.GeneralContentLocalServiceBaseImpl;
import org.kisti.edison.content.service.persistence.GeneralContentPK;
import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonFileConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.util.EdisonExpndoUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.xml.sax.SAXException;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the general content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.content.service.GeneralContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.content.service.base.GeneralContentLocalServiceBaseImpl
 * @see org.kisti.edison.content.service.GeneralContentLocalServiceUtil
 */
public class GeneralContentLocalServiceImpl
	extends GeneralContentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.content.service.GeneralContentLocalServiceUtil} to access the general content local service.
	 */
	public List<Map<String, Object>> getGeneralContentStsList(long groupId,long contentDiv,int start, int end,Locale locale)throws Exception{
		List<GeneralContent> generalContentList = null;
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		
		if(contentDiv==0){
			generalContentList = generalContentPersistence.findByGroupId(groupId, start, end, OrderByComparatorFactoryUtil.create("EDMED_GeneralContent", "downloadCnt",false));
		}else{
			generalContentList = generalContentPersistence.findByContentDiv(groupId, contentDiv, start, end,OrderByComparatorFactoryUtil.create("EDMED_GeneralContent", "downloadCnt",false));
		}
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		for(GeneralContent gContent:generalContentList){
			resultRow = new HashMap<String, Object>();
			resultRow.put("contentDiv", String.valueOf(gContent.getContentDiv()));
			resultRow.put("title", gContent.getTitle(locale,true));
			String insertDate = simpleDateFormat.format(gContent.getInsertDate());
			resultRow.put("insertDate", insertDate);
			resultRow.put("downloadCnt",gContent.getDownloadCnt());
			
			returnList.add(resultRow);
		}
		
		return returnList;
	}
	
	public List<Map<String, Object>> getGeneralContentList(long groupId, long companyId, long contentDiv, String searchText , int start, int end, User user, Locale locale) throws Exception{
		
		List<Object[]> generalContentList = null;
		
		generalContentList = generalContentFinder.getGeneralContentList(groupId, contentDiv, searchText, start, end, locale);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		
		boolean rowAuthCheck = true;
		if(user != null){
			//수정 권한 체크 - edison 관리자일 경우 수정권한 체크 false
			if(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)){
				rowAuthCheck = false;
			}else{
				//해당 사이트의 관리자일경우 해당 사이트 글에 대한 수정권한 체크 false
				if(EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR)){
					rowAuthCheck = false;
				}
			}
		}
		
		//for(GeneralContent gContent:generalContentList){
		for (int i = 0; i < generalContentList.size(); i++) {
			GeneralContent gContent = (GeneralContent)generalContentList.get(i)[0];
			resultRow = new HashMap<String, Object>();
			
			long contentSeq = gContent.getContentSeq();

			List resultFileList = EdisonFileUtil.getListEdisonFile( groupId, "", String.valueOf(contentSeq), EdisonFileConstants.CONTENTS_DEFAULT);
			
			
			resultRow.put("contentSeq", String.valueOf(contentSeq));
			resultRow.put("groupId", String.valueOf(gContent.getGroupId()));
			resultRow.put("contentDiv", String.valueOf(gContent.getContentDiv()));
			resultRow.put("title", gContent.getTitle(locale,false));
			resultRow.put("serviceLanguage", gContent.getServiceLanguage());
			resultRow.put("projectYn", gContent.getProjectYn());
			resultRow.put("projectId", gContent.getProjectId());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String insertDate = simpleDateFormat.format(gContent.getInsertDate());
			resultRow.put("insertDate", insertDate);
			resultRow.put("fileList", resultFileList);
			resultRow.put("downloadCnt", String.valueOf(gContent.getDownloadCnt()));

			resultRow.put("screenName", generalContentList.get(i)[1]);
			
			Boolean roleOwnerCheck = false;
			Boolean roleManagerCheck = false;
			if(user != null){
				//글에 대한 수정 권한 체크
				if(rowAuthCheck){
					if(user.getUserId()==gContent.getInsertId()){
						resultRow.put("updateAuth", "true");
					}else{
						resultRow.put("updateAuth", "false");
					}
				}else{
					resultRow.put("updateAuth", "true");
				}

				//owner, manager 검사
				Role contentOwnerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.CONTENT_OWNER);
				Role contentManagerRole = RoleLocalServiceUtil.fetchRole(companyId, EdisonRoleConstants.CONTENT_MANAGER);
				
				if(UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, contentOwnerRole.getRoleId(), contentSeq)){
					roleOwnerCheck = true;
				}
				if(UserGroupRoleCustomLocalServiceUtil.isRoleCustom(user.getUserId(), groupId, contentManagerRole.getRoleId(), contentSeq)){
					roleManagerCheck = true;
				}
			}else{
				resultRow.put("updateAuth", "false");
			}

			resultRow.put("siteOwnerRole", roleOwnerCheck);
			resultRow.put("siteManagerRole", roleManagerCheck);
			
			returnList.add(resultRow);
		}
		return returnList;
	}
	
	
	public int getGeneralContentCountByGroupId(long groupId, long contentDiv, String searchText,Locale locale) throws IOException, ParserConfigurationException, SAXException, SystemException{
		return generalContentFinder.getGeneralContentCount(groupId, contentDiv, searchText, locale);
	}
	
	public void updateContentInsertId(long groupId, long contentSeq, long userId, String projectYn, long projectId) throws Exception{
		
		if(contentSeq != 0){
			GeneralContentPK generalContentPK = new GeneralContentPK(contentSeq, groupId);
			GeneralContent generalContent = generalContentPersistence.findByPrimaryKey(generalContentPK);
			
			if(generalContent != null){
				generalContent.setInsertId(userId);
				generalContent.setProjectYn(projectYn);
				generalContent.setProjectId(projectId);
				generalContentPersistence.update(generalContent);
			}
		}
	}
	
	public List<Map<String, Object>> getGeneralContentForProjectList(long userId, String searchText, String projectCategoryId, String languageId, int start, int end, Locale locale) throws Exception{
		List<Object[]> generalContentList = generalContentFinder.getGeneralContentForProjectList(userId ,searchText, projectCategoryId, languageId, start, end);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		
		//for(GeneralContent gContent:generalContentList){
		for (int i = 0; i < generalContentList.size(); i++) {
			GeneralContent gContent = (GeneralContent)generalContentList.get(i)[0];
			resultRow = new HashMap<String, Object>();
			
			long contentSeq = gContent.getContentSeq();
			
			resultRow.put("contentSeq", String.valueOf(contentSeq));
			resultRow.put("groupId", String.valueOf(gContent.getGroupId()));
			resultRow.put("contentDiv", String.valueOf(gContent.getContentDiv()));
			resultRow.put("title", gContent.getTitle(locale,false));
			resultRow.put("serviceLanguage", gContent.getServiceLanguage());
			resultRow.put("projectYn", gContent.getProjectYn());
			resultRow.put("projectId", gContent.getProjectId());
			

			User contentUser = UserLocalServiceUtil.getUser(gContent.getInsertId());
			long classPK = GetterUtil.getLong(contentUser.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY),0);
			String affiliation = EdisonExpndoUtil.getCommonCdSearchFieldValue(classPK, EdisonExpando.CDNM, locale);
			resultRow.put("affiliation", affiliation);
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String insertDate = simpleDateFormat.format(gContent.getInsertDate());
			resultRow.put("insertDate", insertDate);
			resultRow.put("screenName", generalContentList.get(i)[1]);
			resultRow.put("firstName", generalContentList.get(i)[2]);
			
			returnList.add(resultRow);
			
		}
		return returnList;
	}
	
	public GeneralContent getGeneralContentForProjectObj(long contentSeq) throws Exception{
		List<GeneralContent> generalContentList = generalContentPersistence.findByContentSeq(contentSeq);
		GeneralContent returnGeneral = null;
		if(generalContentList.size() == 1){
			returnGeneral = generalContentList.get(0);
		}
		
		return returnGeneral;
	}
	
	public int getGeneralContentCountByGroupIdForProjectList(long userId, String searchText,  String projectCategoryId, String languageId) throws IOException, ParserConfigurationException, SAXException, SystemException{
		return generalContentFinder.getGeneralContentForProjectListCount(userId, searchText, projectCategoryId, languageId);
	}
}