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
 * Provides the remote service utility for CommonModule. This utility wraps
 * {@link com.kisti.science.platform.app.service.impl.CommonModuleServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonModuleService
 * @see com.kisti.science.platform.app.service.base.CommonModuleServiceBaseImpl
 * @see com.kisti.science.platform.app.service.impl.CommonModuleServiceImpl
 * @generated
 */
public class CommonModuleServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.kisti.science.platform.app.service.impl.CommonModuleServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	/**
	* Update the module table if any new module is found.
	*
	* @param headNodeIp the IP address of the head computing node on EDISON (e.g, 150.183.247.11)
	* @param headNodePort port number (e.g, 22002)
	* @param headNodeUserId userName for login (e.g., ldconfig-edison)
	* @param headNodePassword password for login (e.g., ldconfig-test)
	*/
	public static boolean updateModules(java.lang.String headNodeIp,
		int headNodePort, java.lang.String headNodeUserId,
		java.lang.String headNodePassword) {
		return getService()
				   .updateModules(headNodeIp, headNodePort, headNodeUserId,
			headNodePassword);
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
	public static java.util.List<com.kisti.science.platform.app.model.CommonModule> retrieveAllModules(
		java.lang.String headNodeIp, int headNodePort,
		java.lang.String headNodeUserId, java.lang.String headNodePassword) {
		return getService()
				   .retrieveAllModules(headNodeIp, headNodePort,
			headNodeUserId, headNodePassword);
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
	public static java.util.List<com.kisti.science.platform.app.model.CommonModule> retrieveModule(
		java.lang.String mod_name, java.lang.String headNodeIp,
		int headNodePort, java.lang.String headNodeUserId,
		java.lang.String headNodePassword)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .retrieveModule(mod_name, headNodeIp, headNodePort,
			headNodeUserId, headNodePassword);
	}

	public static void clearService() {
		_service = null;
	}

	public static CommonModuleService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CommonModuleService.class.getName());

			if (invokableService instanceof CommonModuleService) {
				_service = (CommonModuleService)invokableService;
			}
			else {
				_service = new CommonModuleServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(CommonModuleServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CommonModuleService service) {
	}

	private static CommonModuleService _service;
}