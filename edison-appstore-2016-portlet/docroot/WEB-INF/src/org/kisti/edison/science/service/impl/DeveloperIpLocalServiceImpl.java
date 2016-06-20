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

package org.kisti.edison.science.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.science.NoSuchDeveloperIpException;
import org.kisti.edison.science.model.DeveloperIp;
import org.kisti.edison.science.service.base.DeveloperIpLocalServiceBaseImpl;
import org.kisti.edison.science.service.persistence.DeveloperIpPK;
import org.kisti.edison.util.CustomUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;

/**
 * The implementation of the developer ip local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.service.DeveloperIpLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jksang
 * @see org.kisti.edison.service.base.DeveloperIpLocalServiceBaseImpl
 * @see org.kisti.edison.service.DeveloperIpLocalServiceUtil
 */
public class DeveloperIpLocalServiceImpl extends DeveloperIpLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.service.DeveloperIpLocalServiceUtil} to access the developer ip local service.
	 */
	
	public List<Map<String, String>> getListCustomDeveloperIp(Map<String, String> params) throws NumberFormatException, SystemException {
		List<Map<String, String>> returnList = new ArrayList<Map<String, String>>();
		Map <String, String> resultRow = null;
		
		String userId = (String) params.get("userId");

		if (userId != null && userId.length() > 0) {
			List<DeveloperIp> developerIpList = developerIpPersistence.findByUserId(Long.parseLong(userId));
			for (int i = 0; i < developerIpList.size(); i++) {
				
				DeveloperIp developerIp = (DeveloperIp) developerIpList.get(i);
				
				resultRow = new HashMap<String, String>();
				if (developerIp != null) {
					resultRow.put("ipSeq", String.valueOf(developerIp.getIpSeq()));
					resultRow.put("userId", String.valueOf(developerIp.getUserId()));
					resultRow.put("ip1", developerIp.getIp1());
					resultRow.put("ip2", developerIp.getIp2());
					resultRow.put("ip3", developerIp.getIp3());
					resultRow.put("ip4", developerIp.getIp4());
					resultRow.put("insertId", String.valueOf(developerIp.getInsertId()));
					resultRow.put("insertDate", new SimpleDateFormat("yyyy-MM-dd").format(developerIp.getInsertDate()));
					resultRow.put("updateId", GetterUtil.get(developerIp.getInsertId(), ""));
					if(developerIp.getUpdateDate() != null) {
						resultRow.put("updateDate", new SimpleDateFormat("yyyy-MM-dd").format(developerIp.getUpdateDate()));
					} else {
						resultRow.put("updateDate", "");
					}
				}
				returnList.add(resultRow);
			}
		}
		return returnList;
	}
	
	public DeveloperIp insertCustomDeveloperIp(Map<String, Object> params) throws NoSuchModelException, SystemException, NoSuchDeveloperIpException, NumberFormatException {

		String userId = CustomUtil.strNull(params.get("userId"),"0");
		String groupId = CustomUtil.strNull(params.get("groupId"),"0");
		
		DeveloperIp developerIp = null;
		if(params.get("ipSeq") != null && !params.get("ipSeq").equals(0)) {
			developerIp = developerIpPersistence.findByPrimaryKey(Long.parseLong(String.valueOf(params.get("ipSeq"))));
		} else {
//			/
			long ipSeq = CounterLocalServiceUtil.increment(DeveloperIp.class.getName()); 
			developerIp = developerIpPersistence.create(new DeveloperIpPK(ipSeq, Long.parseLong(userId), Long.parseLong(groupId)));
			developerIp.setInsertId(Long.parseLong((String)params.get("userId")));
			developerIp.setInsertDate(new Date());
			developerIp.setGroupId((Long)params.get("groupId"));
		}
		developerIp.setUpdateDate(new Date());
		developerIp.setUpdateId(Long.parseLong((String)params.get("userId")));
		developerIp.setUserId(Long.parseLong((String)params.get("userId")));
		developerIp.setIp1(String.valueOf(params.get("ip1")));
		developerIp.setIp2(String.valueOf(params.get("ip2")));
		developerIp.setIp3(String.valueOf(params.get("ip3")));
		developerIp.setIp4(String.valueOf(params.get("ip4")));
		
		developerIp = developerIpPersistence.update(developerIp);
		return developerIp;
	}
	
	public void deleteCustomDeveloperIp(Map<String, String> params) throws NoSuchDeveloperIpException, NumberFormatException, SystemException {
		
		String userId = params.get("userId");

		if (userId != null && userId.length() > 0 && !userId.equals("0")) {
			List<DeveloperIp> developerIpList = developerIpPersistence.findByUserId(Long.parseLong(userId));
			if (developerIpList != null && developerIpList.size() > 0) {
				for (DeveloperIp developerIp : developerIpList) {
					developerIpPersistence.remove(developerIp);
				}
			}
		}
	}
}