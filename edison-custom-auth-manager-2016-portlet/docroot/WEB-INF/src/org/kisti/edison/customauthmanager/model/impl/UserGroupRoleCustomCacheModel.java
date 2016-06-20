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

package org.kisti.edison.customauthmanager.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.customauthmanager.model.UserGroupRoleCustom;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserGroupRoleCustom in entity cache.
 *
 * @author EDISON
 * @see UserGroupRoleCustom
 * @generated
 */
public class UserGroupRoleCustomCacheModel implements CacheModel<UserGroupRoleCustom>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", customId=");
		sb.append(customId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserGroupRoleCustom toEntityModel() {
		UserGroupRoleCustomImpl userGroupRoleCustomImpl = new UserGroupRoleCustomImpl();

		userGroupRoleCustomImpl.setUserId(userId);
		userGroupRoleCustomImpl.setGroupId(groupId);
		userGroupRoleCustomImpl.setRoleId(roleId);
		userGroupRoleCustomImpl.setCustomId(customId);

		if (createDate == Long.MIN_VALUE) {
			userGroupRoleCustomImpl.setCreateDate(null);
		}
		else {
			userGroupRoleCustomImpl.setCreateDate(new Date(createDate));
		}

		userGroupRoleCustomImpl.resetOriginalValues();

		return userGroupRoleCustomImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		roleId = objectInput.readLong();
		customId = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(roleId);
		objectOutput.writeLong(customId);
		objectOutput.writeLong(createDate);
	}

	public long userId;
	public long groupId;
	public long roleId;
	public long customId;
	public long createDate;
}