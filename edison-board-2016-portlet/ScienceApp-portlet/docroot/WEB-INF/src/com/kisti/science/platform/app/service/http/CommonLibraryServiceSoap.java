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

import com.kisti.science.platform.app.service.CommonLibraryServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.kisti.science.platform.app.service.CommonLibraryServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.kisti.science.platform.app.model.CommonLibrarySoap}.
 * If the method in the service utility returns a
 * {@link com.kisti.science.platform.app.model.CommonLibrary}, that is translated to a
 * {@link com.kisti.science.platform.app.model.CommonLibrarySoap}. Methods that SOAP cannot
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
 * @see CommonLibraryServiceHttp
 * @see com.kisti.science.platform.app.model.CommonLibrarySoap
 * @see com.kisti.science.platform.app.service.CommonLibraryServiceUtil
 * @generated
 */
public class CommonLibraryServiceSoap {
	/**
	* Update the library table if any new library is found.
	*
	* @param headNodeIp the IP address of the head computing node on EDISON (e.g, 150.183.247.11)
	* @param headNodePort port number (e.g, 22002)
	* @param headNodeUserId userName for login (e.g., ldconfig-edison)
	* @param headNodePassword password for login (e.g., ldconfig-test)
	*/
	public static void updateAllLibraries(java.lang.String headNodeIp,
		int headNodePort, java.lang.String headNodeUserId,
		java.lang.String headNodePassword) throws RemoteException {
		try {
			CommonLibraryServiceUtil.updateAllLibraries(headNodeIp,
				headNodePort, headNodeUserId, headNodePassword);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Retrieve all libraries installed on EDISON cluster.
	* If there's a new library found, then database will be updated with that entry.
	*
	* @param libName library name, but not used
	* @param headNodeIp the ip address of the head computing node
	* @param headNodePort port number for access
	* @param headNodeUserId user id for access
	* @param headNodePassword password for access
	* @return a list of all CommonLibrary objects
	*/
	public static com.kisti.science.platform.app.model.CommonLibrarySoap[] retrieveAllLibraries(
		java.lang.String libName, java.lang.String headNodeIp,
		int headNodePort, java.lang.String headNodeUserId,
		java.lang.String headNodePassword) throws RemoteException {
		try {
			java.util.List<com.kisti.science.platform.app.model.CommonLibrary> returnValue =
				CommonLibraryServiceUtil.retrieveAllLibraries(libName,
					headNodeIp, headNodePort, headNodeUserId, headNodePassword);

			return com.kisti.science.platform.app.model.CommonLibrarySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Retrieve specific library records matching a given name.
	*
	* @param name library name
	* @param headNodeIp the IP address of the head node
	* @param headNodePort port number
	* @param headNodeUserId user id for access
	* @param headNodePassword password
	* @return a list of CommonLibrary objects matching the condition of a given name
	*/
	public static com.kisti.science.platform.app.model.CommonLibrarySoap[] retrieveLibrary(
		java.lang.String name, java.lang.String headNodeIp, int headNodePort,
		java.lang.String headNodeUserId, java.lang.String headNodePassword)
		throws RemoteException {
		try {
			java.util.List<com.kisti.science.platform.app.model.CommonLibrary> returnValue =
				CommonLibraryServiceUtil.retrieveLibrary(name, headNodeIp,
					headNodePort, headNodeUserId, headNodePassword);

			return com.kisti.science.platform.app.model.CommonLibrarySoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CommonLibraryServiceSoap.class);
}