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
import com.kisti.science.platform.app.service.ScienceAppOutputPortsLocalServiceUtil;

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
public class ScienceAppOutputPortsClp extends BaseModelImpl<ScienceAppOutputPorts>
	implements ScienceAppOutputPorts {
	public ScienceAppOutputPortsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ScienceAppOutputPorts.class;
	}

	@Override
	public String getModelClassName() {
		return ScienceAppOutputPorts.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _scienceAppId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScienceAppId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scienceAppId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("outputPorts", getOutputPorts());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		String outputPorts = (String)attributes.get("outputPorts");

		if (outputPorts != null) {
			setOutputPorts(outputPorts);
		}
	}

	@Override
	public long getScienceAppId() {
		return _scienceAppId;
	}

	@Override
	public void setScienceAppId(long scienceAppId) {
		_scienceAppId = scienceAppId;

		if (_scienceAppOutputPortsRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppOutputPortsRemoteModel.getClass();

				Method method = clazz.getMethod("setScienceAppId", long.class);

				method.invoke(_scienceAppOutputPortsRemoteModel, scienceAppId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOutputPorts() {
		return _outputPorts;
	}

	@Override
	public void setOutputPorts(String outputPorts) {
		_outputPorts = outputPorts;

		if (_scienceAppOutputPortsRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppOutputPortsRemoteModel.getClass();

				Method method = clazz.getMethod("setOutputPorts", String.class);

				method.invoke(_scienceAppOutputPortsRemoteModel, outputPorts);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getScienceAppOutputPortsRemoteModel() {
		return _scienceAppOutputPortsRemoteModel;
	}

	public void setScienceAppOutputPortsRemoteModel(
		BaseModel<?> scienceAppOutputPortsRemoteModel) {
		_scienceAppOutputPortsRemoteModel = scienceAppOutputPortsRemoteModel;
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

		Class<?> remoteModelClass = _scienceAppOutputPortsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_scienceAppOutputPortsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ScienceAppOutputPortsLocalServiceUtil.addScienceAppOutputPorts(this);
		}
		else {
			ScienceAppOutputPortsLocalServiceUtil.updateScienceAppOutputPorts(this);
		}
	}

	@Override
	public ScienceAppOutputPorts toEscapedModel() {
		return (ScienceAppOutputPorts)ProxyUtil.newProxyInstance(ScienceAppOutputPorts.class.getClassLoader(),
			new Class[] { ScienceAppOutputPorts.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScienceAppOutputPortsClp clone = new ScienceAppOutputPortsClp();

		clone.setScienceAppId(getScienceAppId());
		clone.setOutputPorts(getOutputPorts());

		return clone;
	}

	@Override
	public int compareTo(ScienceAppOutputPorts scienceAppOutputPorts) {
		long primaryKey = scienceAppOutputPorts.getPrimaryKey();

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

		if (!(obj instanceof ScienceAppOutputPortsClp)) {
			return false;
		}

		ScienceAppOutputPortsClp scienceAppOutputPorts = (ScienceAppOutputPortsClp)obj;

		long primaryKey = scienceAppOutputPorts.getPrimaryKey();

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

		sb.append("{scienceAppId=");
		sb.append(getScienceAppId());
		sb.append(", outputPorts=");
		sb.append(getOutputPorts());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.kisti.science.platform.app.model.ScienceAppOutputPorts");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scienceAppId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outputPorts</column-name><column-value><![CDATA[");
		sb.append(getOutputPorts());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _scienceAppId;
	private String _outputPorts;
	private BaseModel<?> _scienceAppOutputPortsRemoteModel;
	private Class<?> _clpSerializerClass = com.kisti.science.platform.app.service.ClpSerializer.class;
}