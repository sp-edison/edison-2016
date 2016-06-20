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
import org.kisti.edison.science.service.CommonModuleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class CommonModuleClp extends BaseModelImpl<CommonModule>
	implements CommonModule {
	public CommonModuleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CommonModule.class;
	}

	@Override
	public String getModelClassName() {
		return CommonModule.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _commonModuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommonModuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commonModuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commonModuleId", getCommonModuleId());
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
		Long commonModuleId = (Long)attributes.get("commonModuleId");

		if (commonModuleId != null) {
			setCommonModuleId(commonModuleId);
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
	public long getCommonModuleId() {
		return _commonModuleId;
	}

	@Override
	public void setCommonModuleId(long commonModuleId) {
		_commonModuleId = commonModuleId;

		if (_commonModuleRemoteModel != null) {
			try {
				Class<?> clazz = _commonModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCommonModuleId", long.class);

				method.invoke(_commonModuleRemoteModel, commonModuleId);
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

		if (_commonModuleRemoteModel != null) {
			try {
				Class<?> clazz = _commonModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_commonModuleRemoteModel, groupId);
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

		if (_commonModuleRemoteModel != null) {
			try {
				Class<?> clazz = _commonModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_commonModuleRemoteModel, companyId);
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

		if (_commonModuleRemoteModel != null) {
			try {
				Class<?> clazz = _commonModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_commonModuleRemoteModel, userId);
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

		if (_commonModuleRemoteModel != null) {
			try {
				Class<?> clazz = _commonModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_commonModuleRemoteModel, createDate);
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

		if (_commonModuleRemoteModel != null) {
			try {
				Class<?> clazz = _commonModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_commonModuleRemoteModel, modifiedDate);
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

		if (_commonModuleRemoteModel != null) {
			try {
				Class<?> clazz = _commonModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setModuleName", String.class);

				method.invoke(_commonModuleRemoteModel, moduleName);
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

		if (_commonModuleRemoteModel != null) {
			try {
				Class<?> clazz = _commonModuleRemoteModel.getClass();

				Method method = clazz.getMethod("setModuleVersion", String.class);

				method.invoke(_commonModuleRemoteModel, moduleVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCommonModuleRemoteModel() {
		return _commonModuleRemoteModel;
	}

	public void setCommonModuleRemoteModel(BaseModel<?> commonModuleRemoteModel) {
		_commonModuleRemoteModel = commonModuleRemoteModel;
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

		Class<?> remoteModelClass = _commonModuleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_commonModuleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CommonModuleLocalServiceUtil.addCommonModule(this);
		}
		else {
			CommonModuleLocalServiceUtil.updateCommonModule(this);
		}
	}

	@Override
	public CommonModule toEscapedModel() {
		return (CommonModule)ProxyUtil.newProxyInstance(CommonModule.class.getClassLoader(),
			new Class[] { CommonModule.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CommonModuleClp clone = new CommonModuleClp();

		clone.setCommonModuleId(getCommonModuleId());
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
	public int compareTo(CommonModule commonModule) {
		long primaryKey = commonModule.getPrimaryKey();

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

		if (!(obj instanceof CommonModuleClp)) {
			return false;
		}

		CommonModuleClp commonModule = (CommonModuleClp)obj;

		long primaryKey = commonModule.getPrimaryKey();

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

		sb.append("{commonModuleId=");
		sb.append(getCommonModuleId());
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
		sb.append("org.kisti.edison.science.model.CommonModule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>commonModuleId</column-name><column-value><![CDATA[");
		sb.append(getCommonModuleId());
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

	private long _commonModuleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _moduleName;
	private String _moduleVersion;
	private BaseModel<?> _commonModuleRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.science.service.ClpSerializer.class;
}