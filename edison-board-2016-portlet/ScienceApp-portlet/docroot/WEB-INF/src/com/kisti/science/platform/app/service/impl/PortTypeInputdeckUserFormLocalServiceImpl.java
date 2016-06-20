/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.kisti.science.platform.app.service.impl;

import java.util.List;

import com.kisti.science.platform.app.model.PortTypeInputdeckUserForm;
import com.kisti.science.platform.app.service.base.PortTypeInputdeckUserFormLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the port type inputdeck user form local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.science.platform.app.service.PortTypeInputdeckUserFormLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.kisti.science.platform.app.service.base.PortTypeInputdeckUserFormLocalServiceBaseImpl
 * @see com.kisti.science.platform.app.service.PortTypeInputdeckUserFormLocalServiceUtil
 */
public class PortTypeInputdeckUserFormLocalServiceImpl extends PortTypeInputdeckUserFormLocalServiceBaseImpl 
{
	public List<PortTypeInputdeckUserForm> getAll() throws SystemException
	{
		return portTypeInputdeckUserFormPersistence.findAll();
	}
	
	public PortTypeInputdeckUserForm createPortTypeInputdeckUserForm(long userId, String userName, String inputdeckUserData, long portTypeId,ServiceContext sc) throws SystemException
	{
		PortTypeInputdeckUserForm inputdeckUserForm = null;
		
		long newFormId = super.counterLocalService.increment();
		inputdeckUserForm = super.portTypeInputdeckUserFormPersistence.create(newFormId);
		
		inputdeckUserForm.setUserId(userId);
		inputdeckUserForm.setUserName(userName);
		inputdeckUserForm.setUserId(userId);
		inputdeckUserForm.setInputdeckUserForm(inputdeckUserData);
		inputdeckUserForm.setPortTypeId(portTypeId);
		return super.portTypeInputdeckUserFormPersistence.update(inputdeckUserForm);
	}
}