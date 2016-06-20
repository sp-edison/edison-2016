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

package org.kisti.edison.customauthmanager.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.kisti.edison.customauthmanager.service.ClpSerializer;
import org.kisti.edison.customauthmanager.service.UserGroupRoleCustomLocalServiceUtil;
import org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class UserGroupRoleCustomClp extends BaseModelImpl<UserGroupRoleCustom>
	implements UserGroupRoleCustom {
	public UserGroupRoleCustomClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserGroupRoleCustom.class;
	}

	@Override
	public String getModelClassName() {
		return UserGroupRoleCustom.class.getName();
	}

	@Override
	public UserGroupRoleCustomPK getPrimaryKey() {
		return new UserGroupRoleCustomPK(_userId, _groupId, _roleId, _customId);
	}

	@Override
	public void setPrimaryKey(UserGroupRoleCustomPK primaryKey) {
		setUserId(primaryKey.userId);
		setGroupId(primaryKey.groupId);
		setRoleId(primaryKey.roleId);
		setCustomId(primaryKey.customId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UserGroupRoleCustomPK(_userId, _groupId, _roleId, _customId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UserGroupRoleCustomPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("roleId", getRoleId());
		attributes.put("customId", getCustomId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Long customId = (Long)attributes.get("customId");

		if (customId != null) {
			setCustomId(customId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_userGroupRoleCustomRemoteModel != null) {
			try {
				Class<?> clazz = _userGroupRoleCustomRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userGroupRoleCustomRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_userGroupRoleCustomRemoteModel != null) {
			try {
				Class<?> clazz = _userGroupRoleCustomRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_userGroupRoleCustomRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_roleId = roleId;

		if (_userGroupRoleCustomRemoteModel != null) {
			try {
				Class<?> clazz = _userGroupRoleCustomRemoteModel.getClass();

				Method method = clazz.getMethod("setRoleId", long.class);

				method.invoke(_userGroupRoleCustomRemoteModel, roleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCustomId() {
		return _customId;
	}

	@Override
	public void setCustomId(long customId) {
		_customId = customId;

		if (_userGroupRoleCustomRemoteModel != null) {
			try {
				Class<?> clazz = _userGroupRoleCustomRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomId", long.class);

				method.invoke(_userGroupRoleCustomRemoteModel, customId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_userGroupRoleCustomRemoteModel != null) {
			try {
				Class<?> clazz = _userGroupRoleCustomRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_userGroupRoleCustomRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserGroupRoleCustomRemoteModel() {
		return _userGroupRoleCustomRemoteModel;
	}

	public void setUserGroupRoleCustomRemoteModel(
		BaseModel<?> userGroupRoleCustomRemoteModel) {
		_userGroupRoleCustomRemoteModel = userGroupRoleCustomRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _userGroupRoleCustomRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_userGroupRoleCustomRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserGroupRoleCustomLocalServiceUtil.addUserGroupRoleCustom(this);
		}
		else {
			UserGroupRoleCustomLocalServiceUtil.updateUserGroupRoleCustom(this);
		}
	}

	@Override
	public UserGroupRoleCustom toEscapedModel() {
		return (UserGroupRoleCustom)ProxyUtil.newProxyInstance(UserGroupRoleCustom.class.getClassLoader(),
			new Class[] { UserGroupRoleCustom.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserGroupRoleCustomClp clone = new UserGroupRoleCustomClp();

		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());
		clone.setRoleId(getRoleId());
		clone.setCustomId(getCustomId());
		clone.setCreateDate(getCreateDate());

		return clone;
	}

	@Override
	public int compareTo(UserGroupRoleCustom userGroupRoleCustom) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				userGroupRoleCustom.getCreateDate());

		value = value * -1;

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

		if (!(obj instanceof UserGroupRoleCustomClp)) {
			return false;
		}

		UserGroupRoleCustomClp userGroupRoleCustom = (UserGroupRoleCustomClp)obj;

		UserGroupRoleCustomPK primaryKey = userGroupRoleCustom.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", customId=");
		sb.append(getCustomId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"org.kisti.edison.customauthmanager.model.UserGroupRoleCustom");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customId</column-name><column-value><![CDATA[");
		sb.append(getCustomId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private long _groupId;
	private long _roleId;
	private long _customId;
	private Date _createDate;
	private BaseModel<?> _userGroupRoleCustomRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.customauthmanager.service.ClpSerializer.class;
}