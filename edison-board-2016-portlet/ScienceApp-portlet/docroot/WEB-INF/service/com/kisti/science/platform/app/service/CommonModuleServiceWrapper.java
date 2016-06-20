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
 * Provides a wrapper for {@link CommonModuleService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonModuleService
 * @generated
 */
public class CommonModuleServiceWrapper implements CommonModuleService,
	ServiceWrapper<CommonModuleService> {
	public CommonModuleServiceWrapper(CommonModuleService commonModuleService) {
		_commonModuleService = commonModuleService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _commonModuleService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_commonModuleService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _commonModuleService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Update the module table if any new module is found.
	*
	* @param headNodeIp the IP address of the head computing node on EDISON (e.g, 150.183.247.11)
	* @param headNodePort port number (e.g, 22002)
	* @param headNodeUserId userName for login (e.g., ldconfig-edison)
	* @param headNodePassword password for login (e.g., ldconfig-test)
	*/
	@Override
	public boolean updateModules(java.lang.String headNodeIp, int headNodePort,
		java.lang.String headNodeUserId, java.lang.String headNodePassword) {
		return _commonModuleService.updateModules(headNodeIp, headNodePort,
			headNodeUserId, headNodePassword);
	}

	/**
	* Retrieve all modules already installed.
	*
	* @param headNodeIp the ip address of the head computing node
	* @param headNodePort port number for access
	* @param headNodeUserId user id for access
	* @param headNodePassword password for access
	* @return a list of all CommonModule objects
	*/
	@Override
	public java.util.List<com.kisti.science.platform.app.model.CommonModule> retrieveAllModules(
		java.lang.String headNodeIp, int headNodePort,
		java.lang.String headNodeUserId, java.lang.String headNodePassword) {
		return _commonModuleService.retrieveAllModules(headNodeIp,
			headNodePort, headNodeUserId, headNodePassword);
	}

	/**
	* Retrieve installed modules by keyword
	*
	* @param mod_name module name
	* @param headNodeIp the ip address of the head computing node
	* @param headNodePort port number for access
	* @param headNodeUserId user id for access
	* @param headNodePassword password for access
	* @return a list of modules found
	* @throws SystemException system exception thrown in this routine
	*/
	@Override
	public java.util.List<com.kisti.science.platform.app.model.CommonModule> retrieveModule(
		java.lang.String mod_name, java.lang.String headNodeIp,
		int headNodePort, java.lang.String headNodeUserId,
		java.lang.String headNodePassword)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonModuleService.retrieveModule(mod_name, headNodeIp,
			headNodePort, headNodeUserId, headNodePassword);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CommonModuleService getWrappedCommonModuleService() {
		return _commonModuleService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCommonModuleService(
		CommonModuleService commonModuleService) {
		_commonModuleService = commonModuleService;
	}

	@Override
	public CommonModuleService getWrappedService() {
		return _commonModuleService;
	}

	@Override
	public void setWrappedService(CommonModuleService commonModuleService) {
		_commonModuleService = commonModuleService;
	}

	private CommonModuleService _commonModuleService;
}