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
 * Provides a wrapper for {@link ScienceAppService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppService
 * @generated
 */
public class ScienceAppServiceWrapper implements ScienceAppService,
	ServiceWrapper<ScienceAppService> {
	public ScienceAppServiceWrapper(ScienceAppService scienceAppService) {
		_scienceAppService = scienceAppService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scienceAppService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scienceAppService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scienceAppService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppByAppType(
		long authorId, java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppService.getScienceAppByAppType(authorId, appType);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppByAppType(
		long authorId, java.lang.String appType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppService.getScienceAppByAppType(authorId, appType,
			start, end);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceApps(
		long authorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppService.getScienceApps(authorId, start, end);
	}

	@Override
	public int countByAuthorId(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppService.countByAuthorId(authorId);
	}

	@Override
	public int getCountAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppService.getCountAll();
	}

	@Override
	public java.lang.String getBinPath(long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppService.getBinPath(scienceAppId);
	}

	@Override
	public java.lang.String getSrcPath(long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppService.getSrcPath(scienceAppId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScienceAppService getWrappedScienceAppService() {
		return _scienceAppService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScienceAppService(ScienceAppService scienceAppService) {
		_scienceAppService = scienceAppService;
	}

	@Override
	public ScienceAppService getWrappedService() {
		return _scienceAppService;
	}

	@Override
	public void setWrappedService(ScienceAppService scienceAppService) {
		_scienceAppService = scienceAppService;
	}

	private ScienceAppService _scienceAppService;
}