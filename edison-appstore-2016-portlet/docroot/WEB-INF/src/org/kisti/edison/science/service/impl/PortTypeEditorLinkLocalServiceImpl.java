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

package org.kisti.edison.science.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.kisti.edison.science.model.PortTypeEditorLink;
import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.service.base.PortTypeEditorLinkLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the port type editor link local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.kisti.edison.science.service.PortTypeEditorLinkLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.base.PortTypeEditorLinkLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.PortTypeEditorLinkLocalServiceUtil
 */
public class PortTypeEditorLinkLocalServiceImpl extends PortTypeEditorLinkLocalServiceBaseImpl{

  public List<Map<String, Object>> findByPortTypeId(long portTypeId, Locale locale) throws SystemException{
    List<Map<String, Object>> portTypeEditorLinks = new ArrayList<Map<String, Object>>();
    List<Object[]> editorArrays = portTypeEditorLinkFinder.retrieveListPortTypeEditorLink(portTypeId);
    if(editorArrays != null) {
    	for(Object[] editorArray : editorArrays){
    		Map<String, Object> portTypeEditorLinkScienceApp = new HashMap<String, Object>();
    		PortTypeEditorLink portTypeEditorLink = (PortTypeEditorLink)editorArray[0];
    		ScienceApp scienceApp = (ScienceApp)editorArray[1];
    		portTypeEditorLinkScienceApp.putAll(portTypeEditorLink.getModelAttributes());
    		portTypeEditorLinkScienceApp.putAll(scienceApp.getModelAttributes());
    		portTypeEditorLinkScienceApp.put("title", scienceApp.getTitle(locale)); 
    		portTypeEditorLinks.add(portTypeEditorLinkScienceApp);
    	}
    	return portTypeEditorLinks;
    } else {
    	return null;
    }
    
  }
  
  
  public List<Map<String,Object>> findByPortTypeEditorWithAppName(long companyId, long portTypeId) throws SystemException{
	  List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
	  
	  List<Object[]> resultList = portTypeEditorLinkFinder.retrieveListPortTypeEditorLinkWithAppName(companyId, portTypeId);
	  
	  if(resultList != null) {
		  try{
			  for (Object[] result : resultList) {
				  PortTypeEditorLink portTypeEditorLink = (PortTypeEditorLink) result[0];
				  String name = (String) result[1];
				  
				  Map<String, Object> resultRow = portTypeEditorLink.getModelAttributes();
				  resultRow.put("name",name);
				  
				  returnList.add(resultRow);
			  }
		  }catch (Exception e) {
				throw new SystemException(e);
			}
	  }
	  
	  return returnList;
  }
}