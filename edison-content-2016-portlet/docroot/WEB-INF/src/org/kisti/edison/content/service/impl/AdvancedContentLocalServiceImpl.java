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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.content.model.AdvancedContent;
import org.kisti.edison.content.service.base.AdvancedContentLocalServiceBaseImpl;
import org.kisti.edison.model.EdisonFileConstants;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileEntryTypeConstants;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

/**
 * The implementation of the advanced content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.content.service.AdvancedContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.content.service.base.AdvancedContentLocalServiceBaseImpl
 * @see org.kisti.edison.content.service.AdvancedContentLocalServiceUtil
 */
public class AdvancedContentLocalServiceImpl
	extends AdvancedContentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.content.service.AdvancedContentLocalServiceUtil} to access the advanced content local service.
	 */
	public List<Map<String, Object>> getAdvancedContentListByGroupId(long groupId,Locale locale) throws SystemException{
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		
		
		List<AdvancedContent> advancedContentList = advancedContentPersistence.findByGroupId(groupId);
		
		for(AdvancedContent aContent:advancedContentList){
			resultRow = new HashMap<String, Object>();
			resultRow.put("contentSeq", String.valueOf(aContent.getContentSeq()));
			resultRow.put("title", String.valueOf(aContent.getTitle()));
			resultRow.put("viewCnt", aContent.getViewCnt());
			returnList.add(resultRow);
		}
		return returnList;
	}
	
	public List<Map<String, Object>> getAdvancedContentListByGroupId(long groupId,User user,Locale locale,ThemeDisplay themeDisplay) throws Exception{
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		
		String updateAuth = "false";
		if(user != null){
			if(EdisonUserUtil.isPowerUserThan(user)){
				//수정 권한 체크 - edison 관리자일 경우 
				if(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR)){
					updateAuth = "true";
				}else{
					//해당 사이트의 관리자일경우
					if(EdisonUserUtil.isSiteRole(user, groupId, RoleConstants.SITE_ADMINISTRATOR)){
						updateAuth = "true";
					}
				}
			}
		}
		
		List<AdvancedContent> advancedContentList = new ArrayList<AdvancedContent>();
		if(updateAuth.equals("true")){
			advancedContentList = advancedContentPersistence.findByGroupId(groupId);
		}else if(updateAuth.equals("false")){
			advancedContentList = advancedContentPersistence.findByGroupIdSeriveLang(groupId, locale.toString());
		}
		
		for(AdvancedContent aContent:advancedContentList){
			resultRow = new HashMap<String, Object>();
			
			resultRow.put("updateAuth", updateAuth);
			
			
			
			long contentSeq = aContent.getContentSeq();
			String folderName = groupId+"_"+contentSeq;
			DLFolder edisonFolder = DLFolderLocalServiceUtil.getFolder(groupId, DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT, String.valueOf(groupId)+"_EDISON_FILE");
			DLFolder contentFolder = DLFolderLocalServiceUtil.getFolder(groupId,edisonFolder.getFolderId(), EdisonFileConstants.CONTENTS_ADVANCED);
			DLFolder dLFolder = DLFolderLocalServiceUtil.getFolder(groupId, contentFolder.getFolderId(), folderName);
			
			List<DLFileEntry> fileList = DLFileEntryLocalServiceUtil.getFileEntries(groupId, dLFolder.getFolderId());
			
			if(fileList ==null){
				resultRow.put("fileUrl", "");
			}else{
				DLFileEntry dLFileEntry = fileList.get(0);
				
				FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(dLFileEntry.getFileEntryId());
				String url = DLUtil.getPreviewURL(fileEntry,fileEntry.getFileVersion(),themeDisplay, "" ,false,false);
				resultRow.put("fileUrl", url);
			}
			
			
			resultRow.put("serviceLanguage", String.valueOf(aContent.getServiceLanguage()));
			resultRow.put("contentSeq", String.valueOf(aContent.getContentSeq()));
			resultRow.put("groupId", String.valueOf(aContent.getGroupId()));
			resultRow.put("title", String.valueOf(aContent.getTitle()));
			resultRow.put("resume", HtmlUtil.replaceNewLine(String.valueOf(aContent.getResume())));
			resultRow.put("contentFilePath", aContent.getContentFilePath());
			resultRow.put("contentFileNm", aContent.getContentFileNm());
			

			String contentStartFileNm = "";
			String contentFileNm = aContent.getContentFileNm();
			if(contentFileNm != null){
				if(contentFileNm.contains("zip") && contentFileNm.split(".zip").length > 0 ){
					String preFolderNm = contentFileNm.split(".zip")[0];
					contentStartFileNm = preFolderNm +"/"+ aContent.getContentStartFileNm();
				}else{
					contentStartFileNm = contentFileNm;
				}
			}
			
			resultRow.put("contentStartFileNm", contentStartFileNm);
			
			returnList.add(resultRow);
		}
		return returnList;
	}
}