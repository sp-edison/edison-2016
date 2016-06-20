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
import com.kisti.science.platform.app.service.PortTypeAnalyzerLinkLocalServiceUtil;

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
public class PortTypeAnalyzerLinkClp extends BaseModelImpl<PortTypeAnalyzerLink>
	implements PortTypeAnalyzerLink {
	public PortTypeAnalyzerLinkClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PortTypeAnalyzerLink.class;
	}

	@Override
	public String getModelClassName() {
		return PortTypeAnalyzerLink.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _portTypeAnalyzerLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPortTypeAnalyzerLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _portTypeAnalyzerLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("portTypeAnalyzerLinkId", getPortTypeAnalyzerLinkId());
		attributes.put("companyId", getCompanyId());
		attributes.put("portTypeId", getPortTypeId());
		attributes.put("analyzerId", getAnalyzerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long portTypeAnalyzerLinkId = (Long)attributes.get(
				"portTypeAnalyzerLinkId");

		if (portTypeAnalyzerLinkId != null) {
			setPortTypeAnalyzerLinkId(portTypeAnalyzerLinkId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long portTypeId = (Long)attributes.get("portTypeId");

		if (portTypeId != null) {
			setPortTypeId(portTypeId);
		}

		Long analyzerId = (Long)attributes.get("analyzerId");

		if (analyzerId != null) {
			setAnalyzerId(analyzerId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_portTypeAnalyzerLinkRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeAnalyzerLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_portTypeAnalyzerLinkRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPortTypeAnalyzerLinkId() {
		return _portTypeAnalyzerLinkId;
	}

	@Override
	public void setPortTypeAnalyzerLinkId(long portTypeAnalyzerLinkId) {
		_portTypeAnalyzerLinkId = portTypeAnalyzerLinkId;

		if (_portTypeAnalyzerLinkRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeAnalyzerLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setPortTypeAnalyzerLinkId",
						long.class);

				method.invoke(_portTypeAnalyzerLinkRemoteModel,
					portTypeAnalyzerLinkId);
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

		if (_portTypeAnalyzerLinkRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeAnalyzerLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_portTypeAnalyzerLinkRemoteModel, companyId);
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

		if (_portTypeAnalyzerLinkRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeAnalyzerLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setPortTypeId", long.class);

				method.invoke(_portTypeAnalyzerLinkRemoteModel, portTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAnalyzerId() {
		return _analyzerId;
	}

	@Override
	public void setAnalyzerId(long analyzerId) {
		_analyzerId = analyzerId;

		if (_portTypeAnalyzerLinkRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeAnalyzerLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setAnalyzerId", long.class);

				method.invoke(_portTypeAnalyzerLinkRemoteModel, analyzerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPortTypeAnalyzerLinkRemoteModel() {
		return _portTypeAnalyzerLinkRemoteModel;
	}

	public void setPortTypeAnalyzerLinkRemoteModel(
		BaseModel<?> portTypeAnalyzerLinkRemoteModel) {
		_portTypeAnalyzerLinkRemoteModel = portTypeAnalyzerLinkRemoteModel;
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

		Class<?> remoteModelClass = _portTypeAnalyzerLinkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_portTypeAnalyzerLinkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PortTypeAnalyzerLinkLocalServiceUtil.addPortTypeAnalyzerLink(this);
		}
		else {
			PortTypeAnalyzerLinkLocalServiceUtil.updatePortTypeAnalyzerLink(this);
		}
	}

	@Override
	public PortTypeAnalyzerLink toEscapedModel() {
		return (PortTypeAnalyzerLink)ProxyUtil.newProxyInstance(PortTypeAnalyzerLink.class.getClassLoader(),
			new Class[] { PortTypeAnalyzerLink.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PortTypeAnalyzerLinkClp clone = new PortTypeAnalyzerLinkClp();

		clone.setUuid(getUuid());
		clone.setPortTypeAnalyzerLinkId(getPortTypeAnalyzerLinkId());
		clone.setCompanyId(getCompanyId());
		clone.setPortTypeId(getPortTypeId());
		clone.setAnalyzerId(getAnalyzerId());

		return clone;
	}

	@Override
	public int compareTo(PortTypeAnalyzerLink portTypeAnalyzerLink) {
		long primaryKey = portTypeAnalyzerLink.getPrimaryKey();

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

		if (!(obj instanceof PortTypeAnalyzerLinkClp)) {
			return false;
		}

		PortTypeAnalyzerLinkClp portTypeAnalyzerLink = (PortTypeAnalyzerLinkClp)obj;

		long primaryKey = portTypeAnalyzerLink.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", portTypeAnalyzerLinkId=");
		sb.append(getPortTypeAnalyzerLinkId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", portTypeId=");
		sb.append(getPortTypeId());
		sb.append(", analyzerId=");
		sb.append(getAnalyzerId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.kisti.science.platform.app.model.PortTypeAnalyzerLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portTypeAnalyzerLinkId</column-name><column-value><![CDATA[");
		sb.append(getPortTypeAnalyzerLinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portTypeId</column-name><column-value><![CDATA[");
		sb.append(getPortTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>analyzerId</column-name><column-value><![CDATA[");
		sb.append(getAnalyzerId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _portTypeAnalyzerLinkId;
	private long _companyId;
	private long _portTypeId;
	private long _analyzerId;
	private BaseModel<?> _portTypeAnalyzerLinkRemoteModel;
	private Class<?> _clpSerializerClass = com.kisti.science.platform.app.service.ClpSerializer.class;
}