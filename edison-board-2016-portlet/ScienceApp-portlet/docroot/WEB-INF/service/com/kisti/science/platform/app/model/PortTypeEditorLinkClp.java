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
import com.kisti.science.platform.app.service.PortTypeEditorLinkLocalServiceUtil;

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
public class PortTypeEditorLinkClp extends BaseModelImpl<PortTypeEditorLink>
	implements PortTypeEditorLink {
	public PortTypeEditorLinkClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PortTypeEditorLink.class;
	}

	@Override
	public String getModelClassName() {
		return PortTypeEditorLink.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _portTypeEditorLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPortTypeEditorLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _portTypeEditorLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("portTypeEditorLinkId", getPortTypeEditorLinkId());
		attributes.put("companyId", getCompanyId());
		attributes.put("portTypeId", getPortTypeId());
		attributes.put("editorId", getEditorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long portTypeEditorLinkId = (Long)attributes.get("portTypeEditorLinkId");

		if (portTypeEditorLinkId != null) {
			setPortTypeEditorLinkId(portTypeEditorLinkId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long portTypeId = (Long)attributes.get("portTypeId");

		if (portTypeId != null) {
			setPortTypeId(portTypeId);
		}

		Long editorId = (Long)attributes.get("editorId");

		if (editorId != null) {
			setEditorId(editorId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_portTypeEditorLinkRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeEditorLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_portTypeEditorLinkRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPortTypeEditorLinkId() {
		return _portTypeEditorLinkId;
	}

	@Override
	public void setPortTypeEditorLinkId(long portTypeEditorLinkId) {
		_portTypeEditorLinkId = portTypeEditorLinkId;

		if (_portTypeEditorLinkRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeEditorLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setPortTypeEditorLinkId",
						long.class);

				method.invoke(_portTypeEditorLinkRemoteModel,
					portTypeEditorLinkId);
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

		if (_portTypeEditorLinkRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeEditorLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_portTypeEditorLinkRemoteModel, companyId);
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

		if (_portTypeEditorLinkRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeEditorLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setPortTypeId", long.class);

				method.invoke(_portTypeEditorLinkRemoteModel, portTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEditorId() {
		return _editorId;
	}

	@Override
	public void setEditorId(long editorId) {
		_editorId = editorId;

		if (_portTypeEditorLinkRemoteModel != null) {
			try {
				Class<?> clazz = _portTypeEditorLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setEditorId", long.class);

				method.invoke(_portTypeEditorLinkRemoteModel, editorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPortTypeEditorLinkRemoteModel() {
		return _portTypeEditorLinkRemoteModel;
	}

	public void setPortTypeEditorLinkRemoteModel(
		BaseModel<?> portTypeEditorLinkRemoteModel) {
		_portTypeEditorLinkRemoteModel = portTypeEditorLinkRemoteModel;
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

		Class<?> remoteModelClass = _portTypeEditorLinkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_portTypeEditorLinkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PortTypeEditorLinkLocalServiceUtil.addPortTypeEditorLink(this);
		}
		else {
			PortTypeEditorLinkLocalServiceUtil.updatePortTypeEditorLink(this);
		}
	}

	@Override
	public PortTypeEditorLink toEscapedModel() {
		return (PortTypeEditorLink)ProxyUtil.newProxyInstance(PortTypeEditorLink.class.getClassLoader(),
			new Class[] { PortTypeEditorLink.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PortTypeEditorLinkClp clone = new PortTypeEditorLinkClp();

		clone.setUuid(getUuid());
		clone.setPortTypeEditorLinkId(getPortTypeEditorLinkId());
		clone.setCompanyId(getCompanyId());
		clone.setPortTypeId(getPortTypeId());
		clone.setEditorId(getEditorId());

		return clone;
	}

	@Override
	public int compareTo(PortTypeEditorLink portTypeEditorLink) {
		long primaryKey = portTypeEditorLink.getPrimaryKey();

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

		if (!(obj instanceof PortTypeEditorLinkClp)) {
			return false;
		}

		PortTypeEditorLinkClp portTypeEditorLink = (PortTypeEditorLinkClp)obj;

		long primaryKey = portTypeEditorLink.getPrimaryKey();

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
		sb.append(", portTypeEditorLinkId=");
		sb.append(getPortTypeEditorLinkId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", portTypeId=");
		sb.append(getPortTypeId());
		sb.append(", editorId=");
		sb.append(getEditorId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.kisti.science.platform.app.model.PortTypeEditorLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portTypeEditorLinkId</column-name><column-value><![CDATA[");
		sb.append(getPortTypeEditorLinkId());
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
			"<column><column-name>editorId</column-name><column-value><![CDATA[");
		sb.append(getEditorId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _portTypeEditorLinkId;
	private long _companyId;
	private long _portTypeId;
	private long _editorId;
	private BaseModel<?> _portTypeEditorLinkRemoteModel;
	private Class<?> _clpSerializerClass = com.kisti.science.platform.app.service.ClpSerializer.class;
}