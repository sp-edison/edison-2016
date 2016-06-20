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

package com.kisti.science.platform.app.service.http;

import com.kisti.science.platform.app.service.ScienceAppManagerServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.kisti.science.platform.app.service.ScienceAppManagerServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.kisti.science.platform.app.model.ScienceAppManagerSoap}.
 * If the method in the service utility returns a
 * {@link com.kisti.science.platform.app.model.ScienceAppManager}, that is translated to a
 * {@link com.kisti.science.platform.app.model.ScienceAppManagerSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppManagerServiceHttp
 * @see com.kisti.science.platform.app.model.ScienceAppManagerSoap
 * @see com.kisti.science.platform.app.service.ScienceAppManagerServiceUtil
 * @generated
 */
public class ScienceAppManagerServiceSoap {
	public static com.kisti.science.platform.app.model.ScienceAppManagerSoap addScienceAppManager(
		long managerId, long scienceAppId,
		com.liferay.portal.service.ServiceContext sc) throws RemoteException {
		try {
			com.kisti.science.platform.app.model.ScienceAppManager returnValue = ScienceAppManagerServiceUtil.addScienceAppManager(managerId,
					scienceAppId, sc);

			return com.kisti.science.platform.app.model.ScienceAppManagerSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void removeSicenceAppManager(long scienceAppManagerId)
		throws RemoteException {
		try {
			ScienceAppManagerServiceUtil.removeSicenceAppManager(scienceAppManagerId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void removeScienceAppManagerByManagerId(long managerId)
		throws RemoteException {
		try {
			ScienceAppManagerServiceUtil.removeScienceAppManagerByManagerId(managerId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void removeScienceAppManagerByScienceAppId(long scienceAppId)
		throws RemoteException {
		try {
			ScienceAppManagerServiceUtil.removeScienceAppManagerByScienceAppId(scienceAppId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void updateScienceAppManager(
		com.kisti.science.platform.app.model.ScienceAppManagerSoap appManager)
		throws RemoteException {
		try {
			ScienceAppManagerServiceUtil.updateScienceAppManager(com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl.toModel(
					appManager));
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long[] getScienceAppIdsByManagerId(long managerId)
		throws RemoteException {
		try {
			long[] returnValue = ScienceAppManagerServiceUtil.getScienceAppIdsByManagerId(managerId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static long[] getManagetIdsByScienceAppId(long scienceAppId)
		throws RemoteException {
		try {
			long[] returnValue = ScienceAppManagerServiceUtil.getManagetIdsByScienceAppId(scienceAppId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ScienceAppManagerServiceSoap.class);
}