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

package org.kisti.edison.customauthmanager.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import org.kisti.edison.customauthmanager.model.UserGroupRoleCustom;
import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;

/**
 * @author EDISON
 * @generated
 */
public abstract class UserGroupRoleCustomActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public UserGroupRoleCustomActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(UserGroupRoleCustomLocalServiceUtil.getService());
		setClass(UserGroupRoleCustom.class);

		setClassLoader(org.kisti.edison.customauthmanager.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("primaryKey.userId");

		setGroupIdPropertyName("primaryKey.groupId");
	}
}