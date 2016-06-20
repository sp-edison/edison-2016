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

package org.kisti.edison.customauthmanager.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserGroupRoleCustomService}.
 *
 * @author EDISON
 * @see UserGroupRoleCustomService
 * @generated
 */
public class UserGroupRoleCustomServiceWrapper
	implements UserGroupRoleCustomService,
		ServiceWrapper<UserGroupRoleCustomService> {
	public UserGroupRoleCustomServiceWrapper(
		UserGroupRoleCustomService userGroupRoleCustomService) {
		_userGroupRoleCustomService = userGroupRoleCustomService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userGroupRoleCustomService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userGroupRoleCustomService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userGroupRoleCustomService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserGroupRoleCustomService getWrappedUserGroupRoleCustomService() {
		return _userGroupRoleCustomService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserGroupRoleCustomService(
		UserGroupRoleCustomService userGroupRoleCustomService) {
		_userGroupRoleCustomService = userGroupRoleCustomService;
	}

	@Override
	public UserGroupRoleCustomService getWrappedService() {
		return _userGroupRoleCustomService;
	}

	@Override
	public void setWrappedService(
		UserGroupRoleCustomService userGroupRoleCustomService) {
		_userGroupRoleCustomService = userGroupRoleCustomService;
	}

	private UserGroupRoleCustomService _userGroupRoleCustomService;
}