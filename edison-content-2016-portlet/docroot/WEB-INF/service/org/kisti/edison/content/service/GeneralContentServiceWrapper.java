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

package org.kisti.edison.content.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GeneralContentService}.
 *
 * @author EDISON
 * @see GeneralContentService
 * @generated
 */
public class GeneralContentServiceWrapper implements GeneralContentService,
	ServiceWrapper<GeneralContentService> {
	public GeneralContentServiceWrapper(
		GeneralContentService generalContentService) {
		_generalContentService = generalContentService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _generalContentService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_generalContentService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _generalContentService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GeneralContentService getWrappedGeneralContentService() {
		return _generalContentService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGeneralContentService(
		GeneralContentService generalContentService) {
		_generalContentService = generalContentService;
	}

	@Override
	public GeneralContentService getWrappedService() {
		return _generalContentService;
	}

	@Override
	public void setWrappedService(GeneralContentService generalContentService) {
		_generalContentService = generalContentService;
	}

	private GeneralContentService _generalContentService;
}