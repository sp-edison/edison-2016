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
import org.kisti.edison.science.service.ScienceAppFavoriteLocalServiceUtil;
import org.kisti.edison.science.service.persistence.ScienceAppFavoritePK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class ScienceAppFavoriteClp extends BaseModelImpl<ScienceAppFavorite>
	implements ScienceAppFavorite {
	public ScienceAppFavoriteClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ScienceAppFavorite.class;
	}

	@Override
	public String getModelClassName() {
		return ScienceAppFavorite.class.getName();
	}

	@Override
	public ScienceAppFavoritePK getPrimaryKey() {
		return new ScienceAppFavoritePK(_scienceAppId, _userId);
	}

	@Override
	public void setPrimaryKey(ScienceAppFavoritePK primaryKey) {
		setScienceAppId(primaryKey.scienceAppId);
		setUserId(primaryKey.userId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ScienceAppFavoritePK(_scienceAppId, _userId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ScienceAppFavoritePK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	@Override
	public long getScienceAppId() {
		return _scienceAppId;
	}

	@Override
	public void setScienceAppId(long scienceAppId) {
		_scienceAppId = scienceAppId;

		if (_scienceAppFavoriteRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppFavoriteRemoteModel.getClass();

				Method method = clazz.getMethod("setScienceAppId", long.class);

				method.invoke(_scienceAppFavoriteRemoteModel, scienceAppId);
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

		if (_scienceAppFavoriteRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppFavoriteRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_scienceAppFavoriteRemoteModel, userId);
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

		if (_scienceAppFavoriteRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppFavoriteRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_scienceAppFavoriteRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getScienceAppFavoriteRemoteModel() {
		return _scienceAppFavoriteRemoteModel;
	}

	public void setScienceAppFavoriteRemoteModel(
		BaseModel<?> scienceAppFavoriteRemoteModel) {
		_scienceAppFavoriteRemoteModel = scienceAppFavoriteRemoteModel;
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

		Class<?> remoteModelClass = _scienceAppFavoriteRemoteModel.getClass();

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

		Object returnValue = method.invoke(_scienceAppFavoriteRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ScienceAppFavoriteLocalServiceUtil.addScienceAppFavorite(this);
		}
		else {
			ScienceAppFavoriteLocalServiceUtil.updateScienceAppFavorite(this);
		}
	}

	@Override
	public ScienceAppFavorite toEscapedModel() {
		return (ScienceAppFavorite)ProxyUtil.newProxyInstance(ScienceAppFavorite.class.getClassLoader(),
			new Class[] { ScienceAppFavorite.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScienceAppFavoriteClp clone = new ScienceAppFavoriteClp();

		clone.setScienceAppId(getScienceAppId());
		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	@Override
	public int compareTo(ScienceAppFavorite scienceAppFavorite) {
		ScienceAppFavoritePK primaryKey = scienceAppFavorite.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScienceAppFavoriteClp)) {
			return false;
		}

		ScienceAppFavoriteClp scienceAppFavorite = (ScienceAppFavoriteClp)obj;

		ScienceAppFavoritePK primaryKey = scienceAppFavorite.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{scienceAppId=");
		sb.append(getScienceAppId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.science.model.ScienceAppFavorite");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scienceAppId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _scienceAppId;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private BaseModel<?> _scienceAppFavoriteRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.science.service.ClpSerializer.class;
}