/**
 * Copyright (c) 2015-present KISTI. All rights reserved.
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.science.model.PortType;
import org.kisti.edison.science.model.PortTypeAnalyzerLink;
import org.kisti.edison.science.model.PortTypeEditorLink;
import org.kisti.edison.science.service.base.PortTypeLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

// TODO: Auto-generated Javadoc
/**
 * The implementation of the port type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.science.platform.service.PortTypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 *@author EDISON
 * @see org.kisti.edison.science.service.base.PortTypeLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.PortTypeLocalServiceUtil
 */
public class PortTypeLocalServiceImpl extends PortTypeLocalServiceBaseImpl {

	/**
	 * Create a port type of a science app. If provided new port type name already exist, returns null instance.
	 * Created new port type is not saved in database physically.
	 * 
	 * @author EDISON
	 * @param String portTypeName
	 * @param ServiceContext sc
	 * @throws SystemException
	 * @return PortType instance
	 */
	public PortType createPortType(String portTypeName, ServiceContext sc ) throws SystemException{
		if(this.existPortType(portTypeName))	return null;
		
		long portTypeId = super.counterLocalService.increment(PortType.class.getName());
		PortType portType = super.portTypePersistence.create(portTypeId);

		portType.setName(portTypeName);
		portType.setCreateDate(sc.getCreateDate());
		portType.setUserId(sc.getUserId());
		
		return portType;
	}
	
	/**
	 * @param portTypeName
	 * @return
	 * @throws SystemException
	 *
	 * @see com.kisti.science.platform.service.PortTypeLocalService#existPortType(java.lang.String)
	 */
	public boolean existPortType(String portTypeName) throws SystemException{
		int count = super.portTypePersistence.countByName(portTypeName);
		if(count > 0)	return true;
		else		return false;
	}
	
	public void setPortTypeInputdeckForm(long portTypeId, String inputdeckForm) throws PortalException, SystemException{
		super.portTypeInputdeckFormLocalService.create(portTypeId, inputdeckForm);
	}
	
	public PortType deletePortType(long portTypeId) throws SystemException, PortalException{
		PortType portType = super.fetchPortType(portTypeId);
		return this.deletePortType(portType);
	}
	
	public PortType deletePortType(PortType portType) throws SystemException, PortalException{
		this.cleanIntegratedData(portType.getPortTypeId());
		return super.deletePortType(portType);
	}

	
	/**
	 * For reserving integration
	 *
	 * @param portTypeId the port type id
	 * @throws SystemException the system exception
	 * @throws PortalException 
	 */
	protected void cleanIntegratedData(long portTypeId) throws SystemException, PortalException{
		super.portTypeInputdeckFormLocalService.deletePortTypeInputdeckForm(portTypeId);
	}
	
	/**********************************   ADD GPLUS SERVICE   ******************************/
	public int countPortType(long companyGroupId,Locale locale, Map<String,Object> searchParam) throws PortalException, SystemException{
		Map<String,Object> search = settingPortTypeParameter(companyGroupId, locale, searchParam, 0, 0);
		return portTypeFinder.countPortType(search);
	}
	
	public List<Map<String, Object>> retrieveListPortType(long companyGroupId, Locale locale, Map<String,Object> searchParam,int begin, int end) throws PortalException, SystemException{
		Map<String,Object> search = settingPortTypeParameter(companyGroupId, locale, searchParam, begin, end);
		List<Object[]> portTypeList = portTypeFinder.retrieveListPortType(search);
				
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < portTypeList.size(); i++) {
			Object[] resultArray = portTypeList.get(i);
			PortType portType = (PortType) resultArray[0];
			int editorCnt = (Integer) resultArray[1];
			int analyzerCnt = (Integer) resultArray[2];
			int inputdeckCnt = (Integer) resultArray[3];
			
			Map<String, Object> resultRow = portType.getModelAttributes();
			if(!portType.getSampleFilePath().equals("0")){
				DLFileEntry sampleFile =  DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(portType.getSampleFilePath()));
				resultRow.put("sampleRepositoryId", sampleFile.getRepositoryId());
				resultRow.put("sampleUuid", 		sampleFile.getUuid());
				resultRow.put("sampleTitle", 		sampleFile.getTitle());
			}
			
			resultRow.put("editorCnt", editorCnt);
			resultRow.put("analyzerCnt", analyzerCnt);
			resultRow.put("inputdeckCnt", inputdeckCnt);
			returnList.add(resultRow);
		}
		return returnList;
	}
	
	public void createPortType(ServiceContext sc, Map params) throws SystemException{
		long defaultEditorId = GetterUtil.getLong(params.get("defaultEditor"),0);
		long defaultAnalyzerId = GetterUtil.getLong(params.get("defaultAnalyzer"),0);
		String name = GetterUtil.getString(params.get("portTypeName"), "");
		String sampleFilePath = GetterUtil.getString(params.get("sampleFilePath"), "0");
		sampleFilePath = sampleFilePath.equals("")?"0":sampleFilePath;
		
		String targetLanguage = GetterUtil.getString(params.get("availableLanguages"), "").replace("{", "").replace("}", "");
		
		String portTypeEditorStr = GetterUtil.getString(params.get("editor"),"");
		String portTypeAnalyzerStr = GetterUtil.getString(params.get("analyzer"),"");
		
		
		//create PortTypeId
		long portTypeId = super.counterLocalService.increment(PortType.class.getName());
		
		
		//insert PortTypeEditorLink
		if(!portTypeEditorStr.equals("")){
			String[] portTypeEditorArray = portTypeEditorStr.split(",");
			for(String portTypeEditorId : portTypeEditorArray){
				long editorId = GetterUtil.getLong(portTypeEditorId);
				long portTypeEditorLinkId = super.counterLocalService.increment(PortTypeEditorLink.class.getName());
				PortTypeEditorLink portTypeEditorLink = portTypeEditorLinkLocalService.createPortTypeEditorLink(portTypeEditorLinkId);
				portTypeEditorLink.setCompanyId(sc.getCompanyId());
				portTypeEditorLink.setPortTypeId(portTypeId);
				portTypeEditorLink.setEditorId(editorId);
				portTypeEditorLinkLocalService.updatePortTypeEditorLink(portTypeEditorLink);
			}
		}
		
		//insert PortTypeAnalyzerLink
		if(!portTypeAnalyzerStr.equals("")){
			String[] portTypeAnalyzerArray = portTypeAnalyzerStr.split(",");
			for(String portTypeAnalyzerId : portTypeAnalyzerArray){
				long analyzerId = GetterUtil.getLong(portTypeAnalyzerId);
				long portTypeAnaluzerLinkId = super.counterLocalService.increment(PortTypeAnalyzerLink.class.getName());
				PortTypeAnalyzerLink portTypeAnalyzerLink =  portTypeAnalyzerLinkLocalService.createPortTypeAnalyzerLink(portTypeAnaluzerLinkId);
				portTypeAnalyzerLink.setCompanyId(sc.getCompanyId());
				portTypeAnalyzerLink.setPortTypeId(portTypeId);
				portTypeAnalyzerLink.setAnalyzerId(analyzerId);
				portTypeAnalyzerLinkLocalService.updatePortTypeAnalyzerLink(portTypeAnalyzerLink);
			}
		}
		
		//insert default PortTypeEditorLink
		long defaultPortTypeEditorLinkId = 0;
		if(defaultEditorId!=0){
			defaultPortTypeEditorLinkId = super.counterLocalService.increment(PortTypeEditorLink.class.getName());
			PortTypeEditorLink portTypeEditorLink = portTypeEditorLinkLocalService.createPortTypeEditorLink(defaultPortTypeEditorLinkId);
			portTypeEditorLink.setCompanyId(sc.getCompanyId());
			portTypeEditorLink.setPortTypeId(portTypeId);
			portTypeEditorLink.setEditorId(defaultEditorId);
			portTypeEditorLinkLocalService.updatePortTypeEditorLink(portTypeEditorLink);
		}
		//insert default PortTypeAnalyzerLink
		long defaultPortTypeAnaluzerLinkId = 0;
		if(defaultAnalyzerId!=0){
			defaultPortTypeAnaluzerLinkId = super.counterLocalService.increment(PortTypeAnalyzerLink.class.getName());
			PortTypeAnalyzerLink portTypeAnalyzerLink =  portTypeAnalyzerLinkLocalService.createPortTypeAnalyzerLink(defaultPortTypeAnaluzerLinkId);
			portTypeAnalyzerLink.setCompanyId(sc.getCompanyId());
			portTypeAnalyzerLink.setPortTypeId(portTypeId);
			portTypeAnalyzerLink.setAnalyzerId(defaultAnalyzerId);
			portTypeAnalyzerLinkLocalService.updatePortTypeAnalyzerLink(portTypeAnalyzerLink);
		}
		
		boolean inputDeckExist = GetterUtil.getBoolean(params.get("inputDeckExist"),false);
		if(inputDeckExist){
			//insert PortTypeInputdeckForm
			String inputdeckForm = GetterUtil.get(params.get("inputdeckFormJSON"), "");
			portTypeInputdeckFormLocalService.create(portTypeId, inputdeckForm);
		}
		
		//insert PortType
		PortType portType = portTypeLocalService.createPortType(portTypeId);
		portType.setCompanyId(sc.getCompanyId());
		portType.setCreateDate(new Date());
		portType.setDefaultEditorId(defaultPortTypeEditorLinkId);
		//defaultAnalyzerId
		portType.setDefaultAnalyzerId(defaultPortTypeAnaluzerLinkId);
		portType.setName(name);
		portType.setSampleFilePath(sampleFilePath);
		portType.setTargetLanguage(targetLanguage);
		portType.setUserId(sc.getUserId());
		portTypeLocalService.updatePortType(portType);
	}
	
	protected Map<String,Object> settingPortTypeParameter(long companyGroupId, Locale locale, Map<String,Object> searchParam, int begin, int end) throws PortalException, SystemException{
		String targetLanguage = LocaleUtil.toLanguageId(locale);
		searchParam.put("targetLanguage", targetLanguage);
		searchParam.put("companyId", GroupLocalServiceUtil.getGroup(companyGroupId).getCompanyId());
		
		//페이징
		if(end!=0){
			searchParam.put("begin", begin);
			searchParam.put("end", end);
		}
		
		return searchParam;
	}
	
	
}