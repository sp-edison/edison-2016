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

package com.kisti.science.platform.app.service.impl;

import com.kisti.science.platform.app.model.PortType;
import com.kisti.science.platform.app.service.base.PortTypeLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

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
 * @author Jerry H. Seo
 * @see com.kisti.science.platform.service.base.PortTypeLocalServiceBaseImpl
 * @see com.kisti.science.platform.service.PortTypeLocalServiceUtil
 */
public class PortTypeLocalServiceImpl extends PortTypeLocalServiceBaseImpl {
	
	/**
	 * Create a port type of a science app. If provided new port type name already exist, returns null instance.
	 * Created new port type is not saved in database physically.
	 * 
	 * @author Jerry H. Seo
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
}