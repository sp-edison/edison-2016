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

package org.kisti.edison.virtuallaboratory.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException;
import org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp;
import org.kisti.edison.virtuallaboratory.service.base.VirtualLabUserTempLocalServiceBaseImpl;
import org.kisti.edison.virtuallaboratory.service.persistence.VirtualLabUserTempPK;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the virtual lab user temp local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.service.VirtualLabUserTempLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jksang
 * @see org.kisti.edison.service.base.VirtualLabUserTempLocalServiceBaseImpl
 * @see org.kisti.edison.service.VirtualLabUserTempLocalServiceUtil
 */
public class VirtualLabUserTempLocalServiceImpl
	extends VirtualLabUserTempLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.service.VirtualLabUserTempLocalServiceUtil} to access the virtual lab user temp local service.
	 */
	
	public VirtualLabUserTemp addVirtualLabUserTemp(Map <String, Object> params) throws SystemException {
		VirtualLabUserTemp virtualLabUserTemp = null;
		String seqNo = CustomUtil.strNull(params.get("seqNo"));
		String virtualLabId = CustomUtil.strNull(params.get("virtualLabId"));
		String classId = CustomUtil.strNull(params.get("classId"));
		if(!seqNo.equals("") && !virtualLabId.equals("") && !classId.equals("")) {
			VirtualLabUserTempPK virtualLabUserTempPK = new VirtualLabUserTempPK(Long.parseLong(seqNo), Long.parseLong(virtualLabId), Long.parseLong(classId));
			virtualLabUserTemp = virtualLabUserTempPersistence.fetchByPrimaryKey(virtualLabUserTempPK);
			if(virtualLabUserTemp == null) {
				virtualLabUserTemp = virtualLabUserTempPersistence.create(virtualLabUserTempPK);
			}
			virtualLabUserTemp.setUserStudentNumber(CustomUtil.strNull(params.get("userStudentNumber")));
			virtualLabUserTemp.setUserName(CustomUtil.strNull(params.get("userName")));
			virtualLabUserTemp.setStatus(CustomUtil.strNull(params.get("status")).equals("TRUE"));
			virtualLabUserTempPersistence.update(virtualLabUserTemp);
		}
		return virtualLabUserTemp;
	}
	
	public VirtualLabUserTemp removeVirtualLabUserTemp(Map <String, Object> params) throws NoSuchVirtualLabUserTempException, SystemException {
		VirtualLabUserTemp virtualLabUserTemp = null;
		String seqNo = CustomUtil.strNull(params.get("seqNo"));
		String virtualLabId = CustomUtil.strNull(params.get("virtualLabId"));
		String classId = CustomUtil.strNull(params.get("classId"));

		if(!seqNo.equals("") && !virtualLabId.equals("") && !classId.equals("")) {
			VirtualLabUserTempPK virtualLabUserTempPK = new VirtualLabUserTempPK(Long.parseLong(seqNo), Long.parseLong(virtualLabId), Long.parseLong(classId));
			virtualLabUserTemp = virtualLabUserTempPersistence.remove(virtualLabUserTempPK);
		}
		return virtualLabUserTemp;
	}
	
	public List<Map <String, Object>> getListVirtualLabUserTemp(Map <String, Object> params) throws NumberFormatException, SystemException {
		List<Map<String, Object>> resultList = new ArrayList<Map <String, Object>>();
		
		String virtualLabId = CustomUtil.strNull(params.get("virtualLabId"));
		String classId = CustomUtil.strNull(params.get("classId"));
		
		List<VirtualLabUserTemp> virtualLabUserTempList = virtualLabUserTempPersistence.findBygetListTempUser(Long.parseLong(virtualLabId), Long.parseLong(classId));
		for (VirtualLabUserTemp virtualLabUserTemp : virtualLabUserTempList) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("seqNo", virtualLabUserTemp.getSeqNo());
			result.put("virtualLabId", virtualLabUserTemp.getVirtualLabId());
			result.put("classId", virtualLabUserTemp.getClassId());
			result.put("userStudentNumber", virtualLabUserTemp.getUserStudentNumber());
			result.put("userName", virtualLabUserTemp.getUserName());
			result.put("status", virtualLabUserTemp.getStatus());
			resultList.add(result);
		}
		return resultList;
	}
	
	public Map<String, Object> getVirtualLabUserTemp(Long seqNo, Long virtualLabId, Long classId) throws SystemException {
		VirtualLabUserTemp virtualLabUserTemp = null;
		VirtualLabUserTempPK virtualLabUserTempPK = new VirtualLabUserTempPK(seqNo, virtualLabId, classId);
		virtualLabUserTemp = virtualLabUserTempPersistence.fetchByPrimaryKey(virtualLabUserTempPK);
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("seqNo", virtualLabUserTemp.getSeqNo());
		result.put("virtualLabId", virtualLabUserTemp.getVirtualLabId());
		result.put("classId", virtualLabUserTemp.getClassId());
		result.put("userStudentNumber", virtualLabUserTemp.getUserStudentNumber());
		result.put("userScreenName", "c" + virtualLabUserTemp.getClassId() + virtualLabUserTemp.getUserStudentNumber());
		result.put("userName", virtualLabUserTemp.getUserName());
		result.put("status", virtualLabUserTemp.getStatus());
		return result;
	}
}