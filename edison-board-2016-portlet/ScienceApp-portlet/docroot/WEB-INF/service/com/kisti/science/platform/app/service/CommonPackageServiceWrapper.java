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

package com.kisti.science.platform.app.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommonPackageService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonPackageService
 * @generated
 */
public class CommonPackageServiceWrapper implements CommonPackageService,
	ServiceWrapper<CommonPackageService> {
	public CommonPackageServiceWrapper(
		CommonPackageService commonPackageService) {
		_commonPackageService = commonPackageService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _commonPackageService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_commonPackageService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _commonPackageService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.CommonLibrary> retrieveAllPackages() {
		return _commonPackageService.retrieveAllPackages();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CommonPackageService getWrappedCommonPackageService() {
		return _commonPackageService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCommonPackageService(
		CommonPackageService commonPackageService) {
		_commonPackageService = commonPackageService;
	}

	@Override
	public CommonPackageService getWrappedService() {
		return _commonPackageService;
	}

	@Override
	public void setWrappedService(CommonPackageService commonPackageService) {
		_commonPackageService = commonPackageService;
	}

	private CommonPackageService _commonPackageService;
}