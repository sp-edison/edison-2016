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

package com.kisti.science.platform.app.model;

import com.kisti.science.platform.app.service.ClpSerializer;
import com.kisti.science.platform.app.service.PortTypeLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jerry H. Seo & Young Suh
 */
public class PortTypeClp extends BaseModelImpl<PortType> implements PortType {
	public PortTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PortType.class;
	}

	@Override
	public String getModelClassName() {
		return PortType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _portTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPortTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _portTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("portTypeId", getPortTypeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("defaultEditorId", getDefaultEditorId());
		attributes.put("defaultAnalyzerId", getDefaultAnalyzerId());
		attributes.put("name", getName());
		attributes.put("dataType", getDataType());
		attributes.put("sampleFilePath", getSampleFilePath());
		attributes.put("targetLanguage", getTargetLanguage());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long portTypeId = (Long)attributes.get("portTypeId");

		if (portTypeId != null) {
			setPortTypeId(portTypeId);
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

		Long defaultEditorId = (Long)attributes.get("defaultEditorId");

		if (defaultEditorId != null) {
			setDefaultEditorId(defaultEditorId);
		}

		Long defaultAnalyzerId = (Long)attributes.get("defaultAnalyzerId");

		if (defaultAnalyzerId != null) {
			setDefaultAnalyzerId(defaultAnalyzerId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String dataType = (String)attributes.get("dataType");

		if (dataType != null) {
			setDataType(dataType);
		}

		String sampleFilePath = (String)attributes.get("sampleFilePath");

		if (sampleFilePath != null) {
			setSampleFilePath(sampleFilePath);
		}

		String targetLanguage = (String)attributes.get("targetLanguage");

		if (targetLanguage != null) {
			setTargetLanguage(targetLanguage);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_portTypeRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_portTypeRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPortTypeId() {
		return _portTypeId;
	}

	@Override
	public void setPortTypeId(long portTypeId) {
		_portTypeId = portTypeId;

		if (_portTypeRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPortTypeId", long.class);

				method.invoke(_portTypeRemoteModel, portTypeId);
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

		if (_portTypeRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_portTypeRemoteModel, companyId);
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

		if (_portTypeRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_portTypeRemoteModel, userId);
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

		if (_portTypeRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_portTypeRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDefaultEditorId() {
		return _defaultEditorId;
	}

	@Override
	public void setDefaultEditorId(long defaultEditorId) {
		_defaultEditorId = defaultEditorId;

		if (_portTypeRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDefaultEditorId", long.class);

				method.invoke(_portTypeRemoteModel, defaultEditorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDefaultAnalyzerId() {
		return _defaultAnalyzerId;
	}

	@Override
	public void setDefaultAnalyzerId(long defaultAnalyzerId) {
		_defaultAnalyzerId = defaultAnalyzerId;

		if (_portTypeRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDefaultAnalyzerId",
						long.class);

				method.invoke(_portTypeRemoteModel, defaultAnalyzerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_portTypeRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_portTypeRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDataType() {
		return _dataType;
	}

	@Override
	public void setDataType(String dataType) {
		_dataType = dataType;

		if (_portTypeRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDataType", String.class);

				method.invoke(_portTypeRemoteModel, dataType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSampleFilePath() {
		return _sampleFilePath;
	}

	@Override
	public void setSampleFilePath(String sampleFilePath) {
		_sampleFilePath = sampleFilePath;

		if (_portTypeRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSampleFilePath",
						String.class);

				method.invoke(_portTypeRemoteModel, sampleFilePath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTargetLanguage() {
		return _targetLanguage;
	}

	@Override
	public void setTargetLanguage(String targetLanguage) {
		_targetLanguage = targetLanguage;

		if (_portTypeRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetLanguage",
						String.class);

				method.invoke(_portTypeRemoteModel, targetLanguage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_portTypeRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_portTypeRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPortTypeRemoteModel() {
		return _portTypeRemoteModel;
	}

	public void setPortTypeRemoteModel(BaseModel<?> portTypeRemoteModel) {
		_portTypeRemoteModel = portTypeRemoteModel;
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

		Class<?> remoteModelClass = _portTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_portTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PortTypeLocalServiceUtil.addPortType(this);
		}
		else {
			PortTypeLocalServiceUtil.updatePortType(this);
		}
	}

	@Override
	public PortType toEscapedModel() {
		return (PortType)ProxyUtil.newProxyInstance(PortType.class.getClassLoader(),
			new Class[] { PortType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PortTypeClp clone = new PortTypeClp();

		clone.setUuid(getUuid());
		clone.setPortTypeId(getPortTypeId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setDefaultEditorId(getDefaultEditorId());
		clone.setDefaultAnalyzerId(getDefaultAnalyzerId());
		clone.setName(getName());
		clone.setDataType(getDataType());
		clone.setSampleFilePath(getSampleFilePath());
		clone.setTargetLanguage(getTargetLanguage());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(PortType portType) {
		long primaryKey = portType.getPrimaryKey();

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

		if (!(obj instanceof PortTypeClp)) {
			return false;
		}

		PortTypeClp portType = (PortTypeClp)obj;

		long primaryKey = portType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", portTypeId=");
		sb.append(getPortTypeId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", defaultEditorId=");
		sb.append(getDefaultEditorId());
		sb.append(", defaultAnalyzerId=");
		sb.append(getDefaultAnalyzerId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", dataType=");
		sb.append(getDataType());
		sb.append(", sampleFilePath=");
		sb.append(getSampleFilePath());
		sb.append(", targetLanguage=");
		sb.append(getTargetLanguage());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.kisti.science.platform.app.model.PortType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portTypeId</column-name><column-value><![CDATA[");
		sb.append(getPortTypeId());
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
			"<column><column-name>defaultEditorId</column-name><column-value><![CDATA[");
		sb.append(getDefaultEditorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultAnalyzerId</column-name><column-value><![CDATA[");
		sb.append(getDefaultAnalyzerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataType</column-name><column-value><![CDATA[");
		sb.append(getDataType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sampleFilePath</column-name><column-value><![CDATA[");
		sb.append(getSampleFilePath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetLanguage</column-name><column-value><![CDATA[");
		sb.append(getTargetLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _portTypeId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private long _defaultEditorId;
	private long _defaultAnalyzerId;
	private String _name;
	private String _dataType;
	private String _sampleFilePath;
	private String _targetLanguage;
	private String _status;
	private BaseModel<?> _portTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.kisti.science.platform.app.service.ClpSerializer.class;
}