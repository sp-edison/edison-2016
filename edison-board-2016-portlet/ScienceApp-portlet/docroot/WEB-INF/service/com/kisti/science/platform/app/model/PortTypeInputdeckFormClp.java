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
import com.kisti.science.platform.app.service.PortTypeInputdeckFormLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jerry H. Seo & Young Suh
 */
public class PortTypeInputdeckFormClp extends BaseModelImpl<PortTypeInputdeckForm>
	implements PortTypeInputdeckForm {
	public PortTypeInputdeckFormClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PortTypeInputdeckForm.class;
	}

	@Override
	public String getModelClassName() {
		return PortTypeInputdeckForm.class.getName();
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

		attributes.put("portTypeId", getPortTypeId());
		attributes.put("inputdeckForm", getInputdeckForm());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long portTypeId = (Long)attributes.get("portTypeId");

		if (portTypeId != null) {
			setPortTypeId(portTypeId);
		}

		String inputdeckForm = (String)attributes.get("inputdeckForm");

		if (inputdeckForm != null) {
			setInputdeckForm(inputdeckForm);
		}
	}

	@Override
	public long getPortTypeId() {
		return _portTypeId;
	}

	@Override
	public void setPortTypeId(long portTypeId) {
		_portTypeId = portTypeId;

		if (_portTypeInputdeckFormRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeInputdeckFormRemoteModel.getClass();

				Method method = clazz.getMethod("setPortTypeId", long.class);

				method.invoke(_portTypeInputdeckFormRemoteModel, portTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInputdeckForm() {
		return _inputdeckForm;
	}

	@Override
	public void setInputdeckForm(String inputdeckForm) {
		_inputdeckForm = inputdeckForm;

		if (_portTypeInputdeckFormRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeInputdeckFormRemoteModel.getClass();

				Method method = clazz.getMethod("setInputdeckForm", String.class);

				method.invoke(_portTypeInputdeckFormRemoteModel, inputdeckForm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPortTypeInputdeckFormRemoteModel() {
		return _portTypeInputdeckFormRemoteModel;
	}

	public void setPortTypeInputdeckFormRemoteModel(
		BaseModel<?> portTypeInputdeckFormRemoteModel) {
		_portTypeInputdeckFormRemoteModel = portTypeInputdeckFormRemoteModel;
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

		Class<?> remoteModelClass = _portTypeInputdeckFormRemoteModel.getClass();

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

		Object returnValue = method.invoke(_portTypeInputdeckFormRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PortTypeInputdeckFormLocalServiceUtil.addPortTypeInputdeckForm(this);
		}
		else {
			PortTypeInputdeckFormLocalServiceUtil.updatePortTypeInputdeckForm(this);
		}
	}

	@Override
	public PortTypeInputdeckForm toEscapedModel() {
		return (PortTypeInputdeckForm)ProxyUtil.newProxyInstance(PortTypeInputdeckForm.class.getClassLoader(),
			new Class[] { PortTypeInputdeckForm.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PortTypeInputdeckFormClp clone = new PortTypeInputdeckFormClp();

		clone.setPortTypeId(getPortTypeId());
		clone.setInputdeckForm(getInputdeckForm());

		return clone;
	}

	@Override
	public int compareTo(PortTypeInputdeckForm portTypeInputdeckForm) {
		long primaryKey = portTypeInputdeckForm.getPrimaryKey();

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

		if (!(obj instanceof PortTypeInputdeckFormClp)) {
			return false;
		}

		PortTypeInputdeckFormClp portTypeInputdeckForm = (PortTypeInputdeckFormClp)obj;

		long primaryKey = portTypeInputdeckForm.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{portTypeId=");
		sb.append(getPortTypeId());
		sb.append(", inputdeckForm=");
		sb.append(getInputdeckForm());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.kisti.science.platform.app.model.PortTypeInputdeckForm");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>portTypeId</column-name><column-value><![CDATA[");
		sb.append(getPortTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inputdeckForm</column-name><column-value><![CDATA[");
		sb.append(getInputdeckForm());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _portTypeId;
	private String _inputdeckForm;
	private BaseModel<?> _portTypeInputdeckFormRemoteModel;
	private Class<?> _clpSerializerClass = com.kisti.science.platform.app.service.ClpSerializer.class;
}