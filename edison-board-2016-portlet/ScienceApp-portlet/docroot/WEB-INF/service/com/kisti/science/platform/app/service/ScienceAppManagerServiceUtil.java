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
 * Provides the remote service utility for ScienceAppManager. This utility wraps
 * {@link com.kisti.science.platform.app.service.impl.ScienceAppManagerServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppManagerService
 * @see com.kisti.science.platform.app.service.base.ScienceAppManagerServiceBaseImpl
 * @see com.kisti.science.platform.app.service.impl.ScienceAppManagerServiceImpl
 * @generated
 */
public class ScienceAppManagerServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.kisti.science.platform.app.service.impl.ScienceAppManagerServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.kisti.science.platform.app.model.ScienceAppManager addScienceAppManager(
		long managerId, long scienceAppId,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addScienceAppManager(managerId, scienceAppId, sc);
	}

	public static void removeSicenceAppManager(long scienceAppManagerId)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().removeSicenceAppManager(scienceAppManagerId);
	}

	public static void removeScienceAppManagerByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeScienceAppManagerByManagerId(managerId);
	}

	public static void removeScienceAppManagerByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeScienceAppManagerByScienceAppId(scienceAppId);
	}

	public static void updateScienceAppManager(
		com.kisti.science.platform.app.model.ScienceAppManager appManager)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().updateScienceAppManager(appManager);
	}

	public static long[] getScienceAppIdsByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppIdsByManagerId(managerId);
	}

	public static long[] getManagetIdsByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getManagetIdsByScienceAppId(scienceAppId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ScienceAppManagerService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ScienceAppManagerService.class.getName());

			if (invokableService instanceof ScienceAppManagerService) {
				_service = (ScienceAppManagerService)invokableService;
			}
			else {
				_service = new ScienceAppManagerServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(ScienceAppManagerServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ScienceAppManagerService service) {
	}

	private static ScienceAppManagerService _service;
}