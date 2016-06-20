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

package org.kisti.edison.bestsimulation.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.kisti.edison.bestsimulation.service.SimulationJobServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link org.kisti.edison.bestsimulation.service.SimulationJobServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link org.kisti.edison.bestsimulation.model.SimulationJobSoap}.
 * If the method in the service utility returns a
 * {@link org.kisti.edison.bestsimulation.model.SimulationJob}, that is translated to a
 * {@link org.kisti.edison.bestsimulation.model.SimulationJobSoap}. Methods that SOAP cannot
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
 * @author EDISON
 * @see SimulationJobServiceHttp
 * @see org.kisti.edison.bestsimulation.model.SimulationJobSoap
 * @see org.kisti.edison.bestsimulation.service.SimulationJobServiceUtil
 * @generated
 */
public class SimulationJobServiceSoap {
	public static boolean updateSimulationJob(long gid,
		java.lang.String simulationUuid, long jobSeqNo,
		java.lang.String jobUuid, java.lang.String jobStatus,
		java.lang.String jobStartDt, java.lang.String jobEndDt)
		throws RemoteException {
		try {
			boolean returnValue = SimulationJobServiceUtil.updateSimulationJob(gid,
					simulationUuid, jobSeqNo, jobUuid, jobStatus, jobStartDt,
					jobEndDt);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SimulationJobServiceSoap.class);
}