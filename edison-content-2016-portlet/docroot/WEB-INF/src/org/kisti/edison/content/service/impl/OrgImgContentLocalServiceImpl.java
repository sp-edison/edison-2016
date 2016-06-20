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
import java.util.Map;

import org.kisti.edison.content.NoSuchOrgImgContentException;
import org.kisti.edison.content.model.OrgImgContent;
import org.kisti.edison.content.service.base.OrgImgContentLocalServiceBaseImpl;
import org.kisti.edison.content.service.persistence.OrgImgContentPK;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonFileUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

/**
 * The implementation of the org img content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.content.service.OrgImgContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.content.service.base.OrgImgContentLocalServiceBaseImpl
 * @see org.kisti.edison.content.service.OrgImgContentLocalServiceUtil
 */
public class OrgImgContentLocalServiceImpl
	extends OrgImgContentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.content.service.OrgImgContentLocalServiceUtil} to access the org img content local service.
	 */
	@Override
	public List<Map<String,Object>> getOrgImgContentListByGroupId(long groupId,ThemeDisplay themeDisplay) throws SystemException,NoSuchOrgImgContentException{
		List<OrgImgContent> orgImgContentList = orgImgContentPersistence.findByGroupId(groupId);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		Map <String, Object> resultRow = null;
		
		for(OrgImgContent orgImgContent:orgImgContentList){
			resultRow = new HashMap<String, Object>();
			
			resultRow.put("groupId", String.valueOf(orgImgContent.getGroupId()));
			resultRow.put("order", String.valueOf(orgImgContent.getOrder()));
			resultRow.put("orgImgSeq", String.valueOf(orgImgContent.getOrgImgSeq()));
			resultRow.put("orgNm", String.valueOf(orgImgContent.getOrgNm()));
			resultRow.put("orgLink", String.valueOf(orgImgContent.getOrgLink()));
			resultRow.put("fileEntryId", String.valueOf(orgImgContent.getFileEntryId()));
			
			try {
				FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(orgImgContent.getFileEntryId());
				String queryString = "&imageThumbnail=1";
				String url = DLUtil.getPreviewURL(fileEntry,fileEntry.getFileVersion(),themeDisplay, queryString,false,false);
				resultRow.put("fileUrl", url);
			} catch (PortalException e) {
				deleteResetOrder(groupId, orgImgContent.getOrgImgSeq(), orgImgContent.getOrder(), 0);
				e.printStackTrace();
			}
			returnList.add(resultRow);
		}
		return returnList;
	}
	
	@Override
	public int getOrgImgContentCountByGroupId(long groupId) throws SystemException{
		return orgImgContentPersistence.countByGroupId(groupId);
	}
	
	/**
	 * 데이터 삭제시 테이터 Reorder
	 */
	@Override
	public void deleteResetOrder(long groupId, long deleteOrgImgSeq, long deleteOrder, long fileEntryId) throws NoSuchOrgImgContentException, SystemException{
		
		OrgImgContentPK orgImgContentPK = new OrgImgContentPK(deleteOrgImgSeq,groupId);
		//데이터 삭제
		orgImgContentPersistence.remove(orgImgContentPK);
		//파일 삭제
		if(fileEntryId!=0){
			EdisonFileUtil.deleteSingleEdisonFile(Long.valueOf(fileEntryId));
		}
		
		//orderList get
		List<OrgImgContent> orderOrgImgContentList = orgImgContentFinder.getOrderOrgImgContentList(groupId, deleteOrder);
		for(OrgImgContent orgImgContent:orderOrgImgContentList){
			orgImgContent.setOrder(deleteOrder);
			orgImgContentPersistence.updateImpl(orgImgContent);
			deleteOrder++;
		}
	}
	
	
	/**
	 * 데이터 업데이트 및 순번 수정
	 * @param groupId
	 * @param param
	 * @throws SystemException
	 */
	@Override
	public void updateOrgImgContentWithOrder(long groupId, Map param) throws SystemException{
		List<OrgImgContent> orgImgContentList = orgImgContentPersistence.findByGroupId(groupId);
		
		for(OrgImgContent orgImgContent:orgImgContentList){
			long orgImgSeq = orgImgContent.getOrgImgSeq();
			if(!CustomUtil.strNull(param.get(orgImgSeq+"_orgNm")).equals("")){
				orgImgContent.setOrgNm(CustomUtil.strNull(param.get(orgImgSeq+"_orgNm")));
				orgImgContent.setOrgLink(CustomUtil.strNull(param.get(orgImgSeq+"_orgLink")));
				
				if(!CustomUtil.strNull(param.get(orgImgSeq+"_row_nOrder")).equals("")){
					long order = Long.valueOf(CustomUtil.strNull(param.get(orgImgSeq+"_row_nOrder")));
					orgImgContent.setOrder(order);
				}
				orgImgContentPersistence.updateImpl(orgImgContent);
			}
		}
	}
}