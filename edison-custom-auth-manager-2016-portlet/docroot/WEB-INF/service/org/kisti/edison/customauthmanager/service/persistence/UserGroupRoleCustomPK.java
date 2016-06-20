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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author EDISON
 * @generated
 */
public class UserGroupRoleCustomPK implements Comparable<UserGroupRoleCustomPK>,
	Serializable {
	public long userId;
	public long groupId;
	public long roleId;
	public long customId;

	public UserGroupRoleCustomPK() {
	}

	public UserGroupRoleCustomPK(long userId, long groupId, long roleId,
		long customId) {
		this.userId = userId;
		this.groupId = groupId;
		this.roleId = roleId;
		this.customId = customId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getCustomId() {
		return customId;
	}

	public void setCustomId(long customId) {
		this.customId = customId;
	}

	@Override
	public int compareTo(UserGroupRoleCustomPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (userId < pk.userId) {
			value = -1;
		}
		else if (userId > pk.userId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (groupId < pk.groupId) {
			value = -1;
		}
		else if (groupId > pk.groupId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (roleId < pk.roleId) {
			value = -1;
		}
		else if (roleId > pk.roleId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (customId < pk.customId) {
			value = -1;
		}
		else if (customId > pk.customId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserGroupRoleCustomPK)) {
			return false;
		}

		UserGroupRoleCustomPK pk = (UserGroupRoleCustomPK)obj;

		if ((userId == pk.userId) && (groupId == pk.groupId) &&
				(roleId == pk.roleId) && (customId == pk.customId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(userId) + String.valueOf(groupId) +
		String.valueOf(roleId) + String.valueOf(customId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(20);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("userId");
		sb.append(StringPool.EQUAL);
		sb.append(userId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("groupId");
		sb.append(StringPool.EQUAL);
		sb.append(groupId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("roleId");
		sb.append(StringPool.EQUAL);
		sb.append(roleId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("customId");
		sb.append(StringPool.EQUAL);
		sb.append(customId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}