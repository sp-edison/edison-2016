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
 * Provides a wrapper for {@link CommonLibraryService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonLibraryService
 * @generated
 */
public class CommonLibraryServiceWrapper implements CommonLibraryService,
	ServiceWrapper<CommonLibraryService> {
	public CommonLibraryServiceWrapper(
		CommonLibraryService commonLibraryService) {
		_commonLibraryService = commonLibraryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _commonLibraryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_commonLibraryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _commonLibraryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Update the library table if any new library is found.
	*
	* @param headNodeIp the IP address of the head computing node on EDISON (e.g, 150.183.247.11)
	* @param headNodePort port number (e.g, 22002)
	* @param headNodeUserId userName for login (e.g., ldconfig-edison)
	* @param headNodePassword password for login (e.g., ldconfig-test)
	*/
	@Override
	public void updateAllLibraries(java.lang.String headNodeIp,
		int headNodePort, java.lang.String headNodeUserId,
		java.lang.String headNodePassword) {
		_commonLibraryService.updateAllLibraries(headNodeIp, headNodePort,
			headNodeUserId, headNodePassword);
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
	@Override
	public java.util.List<com.kisti.science.platform.app.model.CommonLibrary> retrieveAllLibraries(
		java.lang.String libName, java.lang.String headNodeIp,
		int headNodePort, java.lang.String headNodeUserId,
		java.lang.String headNodePassword) {
		return _commonLibraryService.retrieveAllLibraries(libName, headNodeIp,
			headNodePort, headNodeUserId, headNodePassword);
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
	@Override
	public java.util.List<com.kisti.science.platform.app.model.CommonLibrary> retrieveLibrary(
		java.lang.String name, java.lang.String headNodeIp, int headNodePort,
		java.lang.String headNodeUserId, java.lang.String headNodePassword) {
		return _commonLibraryService.retrieveLibrary(name, headNodeIp,
			headNodePort, headNodeUserId, headNodePassword);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CommonLibraryService getWrappedCommonLibraryService() {
		return _commonLibraryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCommonLibraryService(
		CommonLibraryService commonLibraryService) {
		_commonLibraryService = commonLibraryService;
	}

	@Override
	public CommonLibraryService getWrappedService() {
		return _commonLibraryService;
	}

	@Override
	public void setWrappedService(CommonLibraryService commonLibraryService) {
		_commonLibraryService = commonLibraryService;
	}

	private CommonLibraryService _commonLibraryService;
}