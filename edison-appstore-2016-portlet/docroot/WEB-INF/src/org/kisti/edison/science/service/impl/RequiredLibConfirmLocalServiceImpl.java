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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.science.model.RequiredLibConfirm;
import org.kisti.edison.science.service.base.RequiredLibConfirmLocalServiceBaseImpl;
import org.kisti.edison.util.CustomUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the required lib confirm local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.science.service.RequiredLibConfirmLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.base.RequiredLibConfirmLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.RequiredLibConfirmLocalServiceUtil
 */
public class RequiredLibConfirmLocalServiceImpl
	extends RequiredLibConfirmLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.science.service.RequiredLibConfirmLocalServiceUtil} to access the required lib confirm local service.
	 */
	public int countByScienceAppId(long scienceAppId) throws SystemException{
		return requiredLibConfirmPersistence.countByScienceAppId(scienceAppId);
	}
	
	public List<RequiredLibConfirm> findByScienceAppId(long scienceAppId, int start,int end,OrderByComparator orderByComparator) throws SystemException{
		return requiredLibConfirmPersistence.findByScienceAppId(scienceAppId, start, end, orderByComparator);
	}
	
	
	public int getCountRequiredConfirm(Map<String,Object> searchParam) throws SystemException, PortalException{
		return requiredLibFinder.getCountRequiredLib(searchParam);
	}
	
	public List<Map<String, Object>> getRequiredLibConfirmList(Map<String,Object> searchParam, int begin, int end) throws SystemException, PortalException{
		searchParam.put("begin", begin);
		searchParam.put("end", end);
		List<Object[]> requiredLibList = requiredLibFinder.getRequiredLibList(searchParam);
		
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		try{
			for (int i = 0; i < requiredLibList.size(); i++) {
				Object[] resultArray = requiredLibList.get(i);
				RequiredLibConfirm requiredLibConfirm = (RequiredLibConfirm) resultArray[0];
				String scienceAppName = (String) resultArray[1];
				
				Map<String, Object> resultRow = getRequiredLibConfirmMapWithAppName(requiredLibConfirm , scienceAppName);
				
				returnList.add(resultRow);
			}
		}catch(Exception e){
			throw new SystemException(e);
		}
		
		return returnList;
	}
	
	public Map<String, Object> getRequiredLibConfirmMap(Map<String,Object> searchParam) throws SystemException, PortalException{
		List<Object[]> requiredLibList = requiredLibFinder.getRequiredLib(searchParam);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try{
			Object[] resultArray = requiredLibList.get(0);
			RequiredLibConfirm requiredLibConfirm = (RequiredLibConfirm) resultArray[0];
			String scienceAppName = (String) resultArray[1];
			
			 resultMap = getRequiredLibConfirmMapWithAppName(requiredLibConfirm , scienceAppName);
			
		}catch(Exception e){
			throw new SystemException(e);
		}
		
		return resultMap;
	}
	
	public RequiredLibConfirm getRequiredLibConfirmObject(Map<String,Object> searchParam) throws SystemException, PortalException{
		List<Object[]> requiredLibList = requiredLibFinder.getRequiredLib(searchParam);
		RequiredLibConfirm requiredLibConfirm;
		try{
			Object[] resultArray = requiredLibList.get(0);
			requiredLibConfirm = (RequiredLibConfirm) resultArray[0];
			
		}catch(Exception e){
			throw new SystemException(e);
		}
		
		return requiredLibConfirm;
	}
	
	protected Map<String, Object> getRequiredLibConfirmMapWithAppName(
			RequiredLibConfirm requiredLibConfirm, String scienceAppName
	      )throws ParseException, PortalException, SystemException{
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Map<String, Object> resultRow = new HashMap<String, Object>();
	    resultRow.put("requiredLibId", requiredLibConfirm.getRequiredLibId());
	    resultRow.put("libraryName", requiredLibConfirm.getLibraryName());
	    resultRow.put("libraryVersion", requiredLibConfirm.getLibraryVersion());
	    resultRow.put("confirmContent", requiredLibConfirm.getConfirmContent());
	    resultRow.put("requiredContent", requiredLibConfirm.getRequiredContent());
	    resultRow.put("state", requiredLibConfirm.getRequiredState());
	    if(requiredLibConfirm.getRequiredDate() != null){
	    	resultRow.put("requiredDate", df.format(requiredLibConfirm.getRequiredDate()));
	    }
	    if(requiredLibConfirm.getConfirmDate() != null){
	    	resultRow.put("confirmDate", df.format(requiredLibConfirm.getConfirmDate()));
	    }
	    resultRow.put("scienceAppId", requiredLibConfirm.getScienceAppId());
	    
	    resultRow.put("scienceAppName", scienceAppName);
	    
	    return resultRow;
	}
}