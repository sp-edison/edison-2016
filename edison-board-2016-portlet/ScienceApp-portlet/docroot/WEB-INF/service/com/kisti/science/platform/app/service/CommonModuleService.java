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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for CommonModule. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonModuleServiceUtil
 * @see com.kisti.science.platform.app.service.base.CommonModuleServiceBaseImpl
 * @see com.kisti.science.platform.app.service.impl.CommonModuleServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CommonModuleService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommonModuleServiceUtil} to access the common module remote service. Add custom service methods to {@link com.kisti.science.platform.app.service.impl.CommonModuleServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* Update the module table if any new module is found.
	*
	* @param headNodeIp the IP address of the head computing node on EDISON (e.g, 150.183.247.11)
	* @param headNodePort port number (e.g, 22002)
	* @param headNodeUserId userName for login (e.g., ldconfig-edison)
	* @param headNodePassword password for login (e.g., ldconfig-test)
	*/
	public boolean updateModules(java.lang.String headNodeIp, int headNodePort,
		java.lang.String headNodeUserId, java.lang.String headNodePassword);

	/**
	* Retrieve all modules already installed.
	*
	* @param headNodeIp the ip address of the head computing node
	* @param headNodePort port number for access
	* @param headNodeUserId user id for access
	* @param headNodePassword password for access
	* @return a list of all CommonModule objects
	*/
	public java.util.List<com.kisti.science.platform.app.model.CommonModule> retrieveAllModules(
		java.lang.String headNodeIp, int headNodePort,
		java.lang.String headNodeUserId, java.lang.String headNodePassword);

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
	public java.util.List<com.kisti.science.platform.app.model.CommonModule> retrieveModule(
		java.lang.String mod_name, java.lang.String headNodeIp,
		int headNodePort, java.lang.String headNodeUserId,
		java.lang.String headNodePassword)
		throws com.liferay.portal.kernel.exception.SystemException;
}