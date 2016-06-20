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

import com.kisti.science.platform.app.model.PortTypeInputdeckForm;
import com.kisti.science.platform.app.service.base.PortTypeInputdeckFormLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the port type inputdeck form local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.science.platform.app.service.PortTypeInputdeckFormLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.kisti.science.platform.app.service.base.PortTypeInputdeckFormLocalServiceBaseImpl
 * @see com.kisti.science.platform.app.service.PortTypeInputdeckFormLocalServiceUtil
 */
public class PortTypeInputdeckFormLocalServiceImpl
	extends PortTypeInputdeckFormLocalServiceBaseImpl {
	
	public List<PortTypeInputdeckForm> getAll() throws SystemException
	{
		return portTypeInputdeckFormPersistence.findAll();
	}
	
	public PortTypeInputdeckForm createPortTypeInputdeckForm(String inputdeckFormData, ServiceContext sc) throws SystemException
	{
		PortTypeInputdeckForm inputdeckForm = null;
		
		long newFormId = super.counterLocalService.increment();
		inputdeckForm = super.portTypeInputdeckFormPersistence.create(newFormId);
		inputdeckForm.setInputdeckForm(inputdeckFormData);
		
		return super.portTypeInputdeckFormPersistence.update(inputdeckForm);
	}
	
	public PortTypeInputdeckForm create(long portTypeId, String inputdeckForm) throws SystemException{
		PortTypeInputdeckForm form = null;
		try {
			form = super.getPortTypeInputdeckForm(portTypeId);
		} catch (PortalException e) {
			form = super.createPortTypeInputdeckForm(portTypeId);
		} catch (SystemException e) {
			throw e;
		}

		form.setInputdeckForm(inputdeckForm);
		super.addPortTypeInputdeckForm(form);
		
		return form;
	}
	
	public String getInputdeckFormJsonString(long portTypeId) throws SystemException{
		PortTypeInputdeckForm form = super.fetchPortTypeInputdeckForm(portTypeId);
		return form.getInputdeckForm();
	}
}