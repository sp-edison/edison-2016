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
import com.kisti.science.platform.app.service.PortTypeInputdeckUserFormLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jerry H. Seo & Young Suh
 */
public class PortTypeInputdeckUserFormClp extends BaseModelImpl<PortTypeInputdeckUserForm>
	implements PortTypeInputdeckUserForm {
	public PortTypeInputdeckUserFormClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PortTypeInputdeckUserForm.class;
	}

	@Override
	public String getModelClassName() {
		return PortTypeInputdeckUserForm.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _inputdeckId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInputdeckId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _inputdeckId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("inputdeckId", getInputdeckId());
		attributes.put("portTypeId", getPortTypeId());
		attributes.put("inputdeckUserForm", getInputdeckUserForm());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long inputdeckId = (Long)attributes.get("inputdeckId");

		if (inputdeckId != null) {
			setInputdeckId(inputdeckId);
		}

		Long portTypeId = (Long)attributes.get("portTypeId");

		if (portTypeId != null) {
			setPortTypeId(portTypeId);
		}

		String inputdeckUserForm = (String)attributes.get("inputdeckUserForm");

		if (inputdeckUserForm != null) {
			setInputdeckUserForm(inputdeckUserForm);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}
	}

	@Override
	public long getInputdeckId() {
		return _inputdeckId;
	}

	@Override
	public void setInputdeckId(long inputdeckId) {
		_inputdeckId = inputdeckId;

		if (_portTypeInputdeckUserFormRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeInputdeckUserFormRemoteModel.getClass();

				Method method = clazz.getMethod("setInputdeckId", long.class);

				method.invoke(_portTypeInputdeckUserFormRemoteModel, inputdeckId);
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

		if (_portTypeInputdeckUserFormRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeInputdeckUserFormRemoteModel.getClass();

				Method method = clazz.getMethod("setPortTypeId", long.class);

				method.invoke(_portTypeInputdeckUserFormRemoteModel, portTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInputdeckUserForm() {
		return _inputdeckUserForm;
	}

	@Override
	public void setInputdeckUserForm(String inputdeckUserForm) {
		_inputdeckUserForm = inputdeckUserForm;

		if (_portTypeInputdeckUserFormRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeInputdeckUserFormRemoteModel.getClass();

				Method method = clazz.getMethod("setInputdeckUserForm",
						String.class);

				method.invoke(_portTypeInputdeckUserFormRemoteModel,
					inputdeckUserForm);
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

		if (_portTypeInputdeckUserFormRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeInputdeckUserFormRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_portTypeInputdeckUserFormRemoteModel, userId);
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
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_portTypeInputdeckUserFormRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeInputdeckUserFormRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_portTypeInputdeckUserFormRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPortTypeInputdeckUserFormRemoteModel() {
		return _portTypeInputdeckUserFormRemoteModel;
	}

	public void setPortTypeInputdeckUserFormRemoteModel(
		BaseModel<?> portTypeInputdeckUserFormRemoteModel) {
		_portTypeInputdeckUserFormRemoteModel = portTypeInputdeckUserFormRemoteModel;
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

		Class<?> remoteModelClass = _portTypeInputdeckUserFormRemoteModel.getClass();

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

		Object returnValue = method.invoke(_portTypeInputdeckUserFormRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PortTypeInputdeckUserFormLocalServiceUtil.addPortTypeInputdeckUserForm(this);
		}
		else {
			PortTypeInputdeckUserFormLocalServiceUtil.updatePortTypeInputdeckUserForm(this);
		}
	}

	@Override
	public PortTypeInputdeckUserForm toEscapedModel() {
		return (PortTypeInputdeckUserForm)ProxyUtil.newProxyInstance(PortTypeInputdeckUserForm.class.getClassLoader(),
			new Class[] { PortTypeInputdeckUserForm.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PortTypeInputdeckUserFormClp clone = new PortTypeInputdeckUserFormClp();

		clone.setInputdeckId(getInputdeckId());
		clone.setPortTypeId(getPortTypeId());
		clone.setInputdeckUserForm(getInputdeckUserForm());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());

		return clone;
	}

	@Override
	public int compareTo(PortTypeInputdeckUserForm portTypeInputdeckUserForm) {
		long primaryKey = portTypeInputdeckUserForm.getPrimaryKey();

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

		if (!(obj instanceof PortTypeInputdeckUserFormClp)) {
			return false;
		}

		PortTypeInputdeckUserFormClp portTypeInputdeckUserForm = (PortTypeInputdeckUserFormClp)obj;

		long primaryKey = portTypeInputdeckUserForm.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{inputdeckId=");
		sb.append(getInputdeckId());
		sb.append(", portTypeId=");
		sb.append(getPortTypeId());
		sb.append(", inputdeckUserForm=");
		sb.append(getInputdeckUserForm());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"com.kisti.science.platform.app.model.PortTypeInputdeckUserForm");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>inputdeckId</column-name><column-value><![CDATA[");
		sb.append(getInputdeckId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portTypeId</column-name><column-value><![CDATA[");
		sb.append(getPortTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inputdeckUserForm</column-name><column-value><![CDATA[");
		sb.append(getInputdeckUserForm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _inputdeckId;
	private long _portTypeId;
	private String _inputdeckUserForm;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private BaseModel<?> _portTypeInputdeckUserFormRemoteModel;
	private Class<?> _clpSerializerClass = com.kisti.science.platform.app.service.ClpSerializer.class;
}