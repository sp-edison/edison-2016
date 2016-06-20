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

package org.kisti.edison.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.model.SendMailContent;
import org.kisti.edison.service.base.SendMailContentLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the send mail content local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.service.SendMailContentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jeong dh
 * @see org.kisti.edison.service.base.SendMailContentLocalServiceBaseImpl
 * @see org.kisti.edison.service.SendMailContentLocalServiceUtil
 */
public class SendMailContentLocalServiceImpl
	extends SendMailContentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.service.SendMailContentLocalServiceUtil} to access the send mail content local service.
	 */
	
	public int retrieveCountSentMailContent(Map<String,Object> searchParam) throws SystemException, PortalException{
		return sendMailContentFinder.retrieveCountSentMailContent(searchParam);
	}
	
	public List<Map<String, Object>> retrieveSentMailContentList(Map<String,Object> searchParam, int begin, int end) throws SystemException, PortalException{
		searchParam.put("begin", begin);
		searchParam.put("end", end);
		List<Object[]> sentMailList = sendMailContentFinder.retrieveSentMailContent(searchParam);
		List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();
		try{
			for (int i = 0; i < sentMailList.size(); i++){
				Object[] resultArray = sentMailList.get(i);
				SendMailContent sendMailContent = (SendMailContent) resultArray[0];
				String screenName = (String) resultArray[1];
				
				Map<String, Object> resultRow = getSendMailContentMapWithScreenName(sendMailContent , screenName);
				
				returnList.add(resultRow);
			}
		}catch(Exception e){
			throw new SystemException(e);
		}
		
		return returnList;
	}
	
	protected Map<String, Object> getSendMailContentMapWithScreenName(
			SendMailContent sendMailContent, String screenName
	      )throws ParseException, PortalException, SystemException{
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Map<String, Object> resultRow = new HashMap<String, Object>();
	    resultRow.put("sendMailId", sendMailContent.getSendMailId());
	    resultRow.put("userId", sendMailContent.getUserId());
	    resultRow.put("sendCount", sendMailContent.getSendCount());
	    resultRow.put("successCount", sendMailContent.getSuccessCount());
	    resultRow.put("failCount", sendMailContent.getFailCount());
	    if(sendMailContent.getSendDate() != null){
	    	resultRow.put("sendDate", df.format(sendMailContent.getSendDate()));
	    }
	    resultRow.put("siteGroup", sendMailContent.getSiteGroup());
	    resultRow.put("userGroup", sendMailContent.getUserGroup());
	    resultRow.put("state", sendMailContent.getState());
	    resultRow.put("title", sendMailContent.getTitle());
	    resultRow.put("content", sendMailContent.getContent());
	    
	    resultRow.put("screenName", screenName);
	    
	    return resultRow;
	}
}