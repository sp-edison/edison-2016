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

import com.kisti.science.platform.app.model.ScienceAppInputPorts;
import com.kisti.science.platform.app.service.base.ScienceAppInputPortsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the science app input ports local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.kisti.science.platform.app.service.ScienceAppInputPortsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Jerry H. Seo
 * @see com.kisti.science.platform.app.service.base.ScienceAppInputPortsLocalServiceBaseImpl
 * @see com.kisti.science.platform.app.service.ScienceAppInputPortsLocalServiceUtil
 */
public class ScienceAppInputPortsLocalServiceImpl
	extends ScienceAppInputPortsLocalServiceBaseImpl {
	public ScienceAppInputPorts create(long scienceAppId, String inputPorts) throws SystemException{
		ScienceAppInputPorts ports = null;
		try {
			ports = super.getScienceAppInputPorts(scienceAppId);
		} catch (PortalException e) {
			ports = super.createScienceAppInputPorts(scienceAppId);
		} catch (SystemException e) {
			throw e;
		}

		ports.setInputPorts(inputPorts);
		super.addScienceAppInputPorts(ports);
		
		return ports;
	}
	
	public String getInputPortsJsonString(long scienceAppId) throws SystemException{
		ScienceAppInputPorts ports = super.fetchScienceAppInputPorts(scienceAppId);
		return ports.getInputPorts();
	}
	
	public void removeAllInputPorts() throws SystemException{
		super.scienceAppInputPortsPersistence.removeAll();
	}
}