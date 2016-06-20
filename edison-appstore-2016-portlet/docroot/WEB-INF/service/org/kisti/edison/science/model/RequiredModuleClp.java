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

package org.kisti.edison.science.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.kisti.edison.science.service.ClpSerializer;
import org.kisti.edison.science.service.RequiredModuleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class RequiredModuleClp extends BaseModelImpl<RequiredModule>
	implements RequiredModule {
	public RequiredModuleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RequiredModule.class;
	}

	@Override
	public String getModelClassName() {
		return RequiredModule.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _requiredModuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRequiredModuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _requiredModuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("requiredModuleId", getRequiredModuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("moduleName", getModuleName());
		attributes.put("moduleVersion", getModuleVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long requiredModuleId = (Long)attributes.get("requiredModuleId");

		if (requiredModuleId != null) {
			setRequiredModuleId(requiredModuleId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
		}

		String moduleVersion = (String)attributes.get("moduleVersion");

		if (moduleVersion != null) {
			setModuleVersion(moduleVersion);
		}
	}

	@Override
	public long getRequiredModuleId() {
		return _requiredModuleId;
	}

	@Override
	public void setRequiredModuleId(long requiredModuleId) {
		_requiredModuleId = requiredModuleId;

		if (_requiredModuleRemoteModel != null) {
			try {
				Class<?> clazz = _requiredModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiredModuleId",
						long.class);

				method.invoke(_requiredModuleRemoteModel, requiredModuleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_requiredModuleRemoteModel != null) {
			try {
				Class<?> clazz = _requiredModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_requiredModuleRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_requiredModuleRemoteModel != null) {
			try {
				Class<?> clazz = _requiredModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_requiredModuleRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_requiredModuleRemoteModel != null) {
			try {
				Class<?> clazz = _requiredModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_requiredModuleRemoteModel, userId);
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_requiredModuleRemoteModel != null) {
			try {
				Class<?> clazz = _requiredModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_requiredModuleRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_requiredModuleRemoteModel != null) {
			try {
				Class<?> clazz = _requiredModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_requiredModuleRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModuleName() {
		return _moduleName;
	}

	@Override
	public void setModuleName(String moduleName) {
		_moduleName = moduleName;

		if (_requiredModuleRemoteModel != null) {
			try {
				Class<?> clazz = _requiredModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setModuleName", String.class);

				method.invoke(_requiredModuleRemoteModel, moduleName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModuleVersion() {
		return _moduleVersion;
	}

	@Override
	public void setModuleVersion(String moduleVersion) {
		_moduleVersion = moduleVersion;

		if (_requiredModuleRemoteModel != null) {
			try {
				Class<?> clazz = _requiredModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setModuleVersion", String.class);

				method.invoke(_requiredModuleRemoteModel, moduleVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRequiredModuleRemoteModel() {
		return _requiredModuleRemoteModel;
	}

	public void setRequiredModuleRemoteModel(
		BaseModel<?> requiredModuleRemoteModel) {
		_requiredModuleRemoteModel = requiredModuleRemoteModel;
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

		Class<?> remoteModelClass = _requiredModuleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_requiredModuleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RequiredModuleLocalServiceUtil.addRequiredModule(this);
		}
		else {
			RequiredModuleLocalServiceUtil.updateRequiredModule(this);
		}
	}

	@Override
	public RequiredModule toEscapedModel() {
		return (RequiredModule)ProxyUtil.newProxyInstance(RequiredModule.class.getClassLoader(),
			new Class[] { RequiredModule.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RequiredModuleClp clone = new RequiredModuleClp();

		clone.setRequiredModuleId(getRequiredModuleId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setModuleName(getModuleName());
		clone.setModuleVersion(getModuleVersion());

		return clone;
	}

	@Override
	public int compareTo(RequiredModule requiredModule) {
		long primaryKey = requiredModule.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RequiredModuleClp)) {
			return false;
		}

		RequiredModuleClp requiredModule = (RequiredModuleClp)obj;

		long primaryKey = requiredModule.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
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
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{requiredModuleId=");
		sb.append(getRequiredModuleId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", moduleName=");
		sb.append(getModuleName());
		sb.append(", moduleVersion=");
		sb.append(getModuleVersion());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.science.model.RequiredModule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>requiredModuleId</column-name><column-value><![CDATA[");
		sb.append(getRequiredModuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moduleName</column-name><column-value><![CDATA[");
		sb.append(getModuleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moduleVersion</column-name><column-value><![CDATA[");
		sb.append(getModuleVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _requiredModuleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _moduleName;
	private String _moduleVersion;
	private BaseModel<?> _requiredModuleRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.science.service.ClpSerializer.class;
}