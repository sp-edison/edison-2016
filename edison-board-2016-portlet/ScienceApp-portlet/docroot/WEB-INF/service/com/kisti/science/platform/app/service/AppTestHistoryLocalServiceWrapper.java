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
 * Provides a wrapper for {@link AppTestHistoryLocalService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see AppTestHistoryLocalService
 * @generated
 */
public class AppTestHistoryLocalServiceWrapper
	implements AppTestHistoryLocalService,
		ServiceWrapper<AppTestHistoryLocalService> {
	public AppTestHistoryLocalServiceWrapper(
		AppTestHistoryLocalService appTestHistoryLocalService) {
		_appTestHistoryLocalService = appTestHistoryLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _appTestHistoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_appTestHistoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _appTestHistoryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AppTestHistoryLocalService getWrappedAppTestHistoryLocalService() {
		return _appTestHistoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAppTestHistoryLocalService(
		AppTestHistoryLocalService appTestHistoryLocalService) {
		_appTestHistoryLocalService = appTestHistoryLocalService;
	}

	@Override
	public AppTestHistoryLocalService getWrappedService() {
		return _appTestHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		AppTestHistoryLocalService appTestHistoryLocalService) {
		_appTestHistoryLocalService = appTestHistoryLocalService;
	}

	private AppTestHistoryLocalService _appTestHistoryLocalService;
}