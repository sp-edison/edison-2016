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
import java.util.List;
import java.util.Map;

import org.kisti.edison.science.model.PortTypeAnalyzerLink;
import org.kisti.edison.science.service.base.PortTypeAnalyzerLinkLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the port type analyzer link local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.science.service.PortTypeAnalyzerLinkLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.base.PortTypeAnalyzerLinkLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.PortTypeAnalyzerLinkLocalServiceUtil
 */
public class PortTypeAnalyzerLinkLocalServiceImpl
	extends PortTypeAnalyzerLinkLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.science.service.PortTypeAnalyzerLinkLocalServiceUtil} to access the port type analyzer link local service.
	 */
	
	public List<Map<String,Object>> findByPortTypeAnalyzerWithAppName(long companyId, long portTypeId) throws SystemException{
		  List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		  
		  List<Object[]> resultList = portTypeAnalyzerLinkFinder.retrieveListPortTypeAnalyzerLinkWithAppName(companyId, portTypeId);
		  
		  if(resultList != null) {
			  try{
				  for (Object[] result : resultList) {
					  PortTypeAnalyzerLink portTypeAnalyzerLink = (PortTypeAnalyzerLink)result[0];
					  String name = (String) result[1];
					  
					  Map<String, Object> resultRow = portTypeAnalyzerLink.getModelAttributes();
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