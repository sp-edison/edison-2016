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

package org.kisti.edison.virtuallaboratory.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VirtualLabClassService}.
 *
 * @author EDISON
 * @see VirtualLabClassService
 * @generated
 */
public class VirtualLabClassServiceWrapper implements VirtualLabClassService,
	ServiceWrapper<VirtualLabClassService> {
	public VirtualLabClassServiceWrapper(
		VirtualLabClassService virtualLabClassService) {
		_virtualLabClassService = virtualLabClassService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _virtualLabClassService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_virtualLabClassService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _virtualLabClassService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VirtualLabClassService getWrappedVirtualLabClassService() {
		return _virtualLabClassService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVirtualLabClassService(
		VirtualLabClassService virtualLabClassService) {
		_virtualLabClassService = virtualLabClassService;
	}

	@Override
	public VirtualLabClassService getWrappedService() {
		return _virtualLabClassService;
	}

	@Override
	public void setWrappedService(VirtualLabClassService virtualLabClassService) {
		_virtualLabClassService = virtualLabClassService;
	}

	private VirtualLabClassService _virtualLabClassService;
}