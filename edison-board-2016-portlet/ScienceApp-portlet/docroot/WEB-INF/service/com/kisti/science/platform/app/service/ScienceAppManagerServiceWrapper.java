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
 * Provides a wrapper for {@link ScienceAppManagerService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppManagerService
 * @generated
 */
public class ScienceAppManagerServiceWrapper implements ScienceAppManagerService,
	ServiceWrapper<ScienceAppManagerService> {
	public ScienceAppManagerServiceWrapper(
		ScienceAppManagerService scienceAppManagerService) {
		_scienceAppManagerService = scienceAppManagerService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scienceAppManagerService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scienceAppManagerService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scienceAppManagerService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceAppManager addScienceAppManager(
		long managerId, long scienceAppId,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppManagerService.addScienceAppManager(managerId,
			scienceAppId, sc);
	}

	@Override
	public void removeSicenceAppManager(long scienceAppManagerId)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException {
		_scienceAppManagerService.removeSicenceAppManager(scienceAppManagerId);
	}

	@Override
	public void removeScienceAppManagerByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppManagerService.removeScienceAppManagerByManagerId(managerId);
	}

	@Override
	public void removeScienceAppManagerByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppManagerService.removeScienceAppManagerByScienceAppId(scienceAppId);
	}

	@Override
	public void updateScienceAppManager(
		com.kisti.science.platform.app.model.ScienceAppManager appManager)
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppManagerService.updateScienceAppManager(appManager);
	}

	@Override
	public long[] getScienceAppIdsByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppManagerService.getScienceAppIdsByManagerId(managerId);
	}

	@Override
	public long[] getManagetIdsByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppManagerService.getManagetIdsByScienceAppId(scienceAppId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScienceAppManagerService getWrappedScienceAppManagerService() {
		return _scienceAppManagerService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScienceAppManagerService(
		ScienceAppManagerService scienceAppManagerService) {
		_scienceAppManagerService = scienceAppManagerService;
	}

	@Override
	public ScienceAppManagerService getWrappedService() {
		return _scienceAppManagerService;
	}

	@Override
	public void setWrappedService(
		ScienceAppManagerService scienceAppManagerService) {
		_scienceAppManagerService = scienceAppManagerService;
	}

	private ScienceAppManagerService _scienceAppManagerService;
}