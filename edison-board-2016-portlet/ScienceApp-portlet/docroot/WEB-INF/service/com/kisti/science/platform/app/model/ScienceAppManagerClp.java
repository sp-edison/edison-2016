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
import com.kisti.science.platform.app.service.ScienceAppManagerLocalServiceUtil;

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
public class ScienceAppManagerClp extends BaseModelImpl<ScienceAppManager>
	implements ScienceAppManager {
	public ScienceAppManagerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ScienceAppManager.class;
	}

	@Override
	public String getModelClassName() {
		return ScienceAppManager.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _scienceAppManagerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScienceAppManagerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scienceAppManagerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scienceAppManagerId", getScienceAppManagerId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("managerId", getManagerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scienceAppManagerId = (Long)attributes.get("scienceAppManagerId");

		if (scienceAppManagerId != null) {
			setScienceAppManagerId(scienceAppManagerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		Long managerId = (Long)attributes.get("managerId");

		if (managerId != null) {
			setManagerId(managerId);
		}
	}

	@Override
	public long getScienceAppManagerId() {
		return _scienceAppManagerId;
	}

	@Override
	public void setScienceAppManagerId(long scienceAppManagerId) {
		_scienceAppManagerId = scienceAppManagerId;

		if (_scienceAppManagerRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppManagerRemoteModel.getClass();

				Method method = clazz.getMethod("setScienceAppManagerId",
						long.class);

				method.invoke(_scienceAppManagerRemoteModel, scienceAppManagerId);
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

		if (_scienceAppManagerRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppManagerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_scienceAppManagerRemoteModel, userId);
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

		if (_scienceAppManagerRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppManagerRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_scienceAppManagerRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getScienceAppId() {
		return _scienceAppId;
	}

	@Override
	public void setScienceAppId(long scienceAppId) {
		_scienceAppId = scienceAppId;

		if (_scienceAppManagerRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppManagerRemoteModel.getClass();

				Method method = clazz.getMethod("setScienceAppId", long.class);

				method.invoke(_scienceAppManagerRemoteModel, scienceAppId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getManagerId() {
		return _managerId;
	}

	@Override
	public void setManagerId(long managerId) {
		_managerId = managerId;

		if (_scienceAppManagerRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppManagerRemoteModel.getClass();

				Method method = clazz.getMethod("setManagerId", long.class);

				method.invoke(_scienceAppManagerRemoteModel, managerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getScienceAppManagerRemoteModel() {
		return _scienceAppManagerRemoteModel;
	}

	public void setScienceAppManagerRemoteModel(
		BaseModel<?> scienceAppManagerRemoteModel) {
		_scienceAppManagerRemoteModel = scienceAppManagerRemoteModel;
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

		Class<?> remoteModelClass = _scienceAppManagerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_scienceAppManagerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ScienceAppManagerLocalServiceUtil.addScienceAppManager(this);
		}
		else {
			ScienceAppManagerLocalServiceUtil.updateScienceAppManager(this);
		}
	}

	@Override
	public ScienceAppManager toEscapedModel() {
		return (ScienceAppManager)ProxyUtil.newProxyInstance(ScienceAppManager.class.getClassLoader(),
			new Class[] { ScienceAppManager.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScienceAppManagerClp clone = new ScienceAppManagerClp();

		clone.setScienceAppManagerId(getScienceAppManagerId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setScienceAppId(getScienceAppId());
		clone.setManagerId(getManagerId());

		return clone;
	}

	@Override
	public int compareTo(ScienceAppManager scienceAppManager) {
		long primaryKey = scienceAppManager.getPrimaryKey();

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

		if (!(obj instanceof ScienceAppManagerClp)) {
			return false;
		}

		ScienceAppManagerClp scienceAppManager = (ScienceAppManagerClp)obj;

		long primaryKey = scienceAppManager.getPrimaryKey();

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

		sb.append("{scienceAppManagerId=");
		sb.append(getScienceAppManagerId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", scienceAppId=");
		sb.append(getScienceAppId());
		sb.append(", managerId=");
		sb.append(getManagerId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.kisti.science.platform.app.model.ScienceAppManager");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scienceAppManagerId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppManagerId());
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
			"<column><column-name>scienceAppId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>managerId</column-name><column-value><![CDATA[");
		sb.append(getManagerId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _scienceAppManagerId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private long _scienceAppId;
	private long _managerId;
	private BaseModel<?> _scienceAppManagerRemoteModel;
	private Class<?> _clpSerializerClass = com.kisti.science.platform.app.service.ClpSerializer.class;
}