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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for ScienceApp. This utility wraps
 * {@link com.kisti.science.platform.app.service.impl.ScienceAppServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppService
 * @see com.kisti.science.platform.app.service.base.ScienceAppServiceBaseImpl
 * @see com.kisti.science.platform.app.service.impl.ScienceAppServiceImpl
 * @generated
 */
public class ScienceAppServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.kisti.science.platform.app.service.impl.ScienceAppServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppByAppType(
		long authorId, java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppByAppType(authorId, appType);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceAppByAppType(
		long authorId, java.lang.String appType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppByAppType(authorId, appType, start, end);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> getScienceApps(
		long authorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceApps(authorId, start, end);
	}

	public static int countByAuthorId(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByAuthorId(authorId);
	}

	public static int getCountAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountAll();
	}

	public static java.lang.String getBinPath(long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBinPath(scienceAppId);
	}

	public static java.lang.String getSrcPath(long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSrcPath(scienceAppId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ScienceAppService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ScienceAppService.class.getName());

			if (invokableService instanceof ScienceAppService) {
				_service = (ScienceAppService)invokableService;
			}
			else {
				_service = new ScienceAppServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ScienceAppServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ScienceAppService service) {
	}

	private static ScienceAppService _service;
}