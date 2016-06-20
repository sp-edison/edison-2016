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

import org.kisti.edison.science.model.PortTypeInputdeckForm;
import org.kisti.edison.science.service.base.PortTypeInputdeckFormLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the port type inputdeck form local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.science.service.PortTypeInputdeckFormLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.base.PortTypeInputdeckFormLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.PortTypeInputdeckFormLocalServiceUtil
 */
public class PortTypeInputdeckFormLocalServiceImpl
	extends PortTypeInputdeckFormLocalServiceBaseImpl {
	
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