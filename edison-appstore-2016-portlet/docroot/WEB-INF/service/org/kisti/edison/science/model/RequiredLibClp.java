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
import org.kisti.edison.science.service.RequiredLibLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class RequiredLibClp extends BaseModelImpl<RequiredLib>
	implements RequiredLib {
	public RequiredLibClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RequiredLib.class;
	}

	@Override
	public String getModelClassName() {
		return RequiredLib.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _requiredLibId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRequiredLibId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _requiredLibId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("requiredLibId", getRequiredLibId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("libraryName", getLibraryName());
		attributes.put("libraryVersion", getLibraryVersion());
		attributes.put("libraryType", getLibraryType());
		attributes.put("librarySrcPath", getLibrarySrcPath());
		attributes.put("installScript", getInstallScript());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long requiredLibId = (Long)attributes.get("requiredLibId");

		if (requiredLibId != null) {
			setRequiredLibId(requiredLibId);
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

		String libraryName = (String)attributes.get("libraryName");

		if (libraryName != null) {
			setLibraryName(libraryName);
		}

		String libraryVersion = (String)attributes.get("libraryVersion");

		if (libraryVersion != null) {
			setLibraryVersion(libraryVersion);
		}

		String libraryType = (String)attributes.get("libraryType");

		if (libraryType != null) {
			setLibraryType(libraryType);
		}

		String librarySrcPath = (String)attributes.get("librarySrcPath");

		if (librarySrcPath != null) {
			setLibrarySrcPath(librarySrcPath);
		}

		String installScript = (String)attributes.get("installScript");

		if (installScript != null) {
			setInstallScript(installScript);
		}
	}

	@Override
	public long getRequiredLibId() {
		return _requiredLibId;
	}

	@Override
	public void setRequiredLibId(long requiredLibId) {
		_requiredLibId = requiredLibId;

		if (_requiredLibRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiredLibId", long.class);

				method.invoke(_requiredLibRemoteModel, requiredLibId);
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

		if (_requiredLibRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_requiredLibRemoteModel, groupId);
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

		if (_requiredLibRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_requiredLibRemoteModel, companyId);
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

		if (_requiredLibRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_requiredLibRemoteModel, userId);
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

		if (_requiredLibRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_requiredLibRemoteModel, createDate);
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

		if (_requiredLibRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_requiredLibRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLibraryName() {
		return _libraryName;
	}

	@Override
	public void setLibraryName(String libraryName) {
		_libraryName = libraryName;

		if (_requiredLibRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryName", String.class);

				method.invoke(_requiredLibRemoteModel, libraryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLibraryVersion() {
		return _libraryVersion;
	}

	@Override
	public void setLibraryVersion(String libraryVersion) {
		_libraryVersion = libraryVersion;

		if (_requiredLibRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryVersion",
						String.class);

				method.invoke(_requiredLibRemoteModel, libraryVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLibraryType() {
		return _libraryType;
	}

	@Override
	public void setLibraryType(String libraryType) {
		_libraryType = libraryType;

		if (_requiredLibRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryType", String.class);

				method.invoke(_requiredLibRemoteModel, libraryType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLibrarySrcPath() {
		return _librarySrcPath;
	}

	@Override
	public void setLibrarySrcPath(String librarySrcPath) {
		_librarySrcPath = librarySrcPath;

		if (_requiredLibRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibRemoteModel.getClass();

				Method method = clazz.getMethod("setLibrarySrcPath",
						String.class);

				method.invoke(_requiredLibRemoteModel, librarySrcPath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInstallScript() {
		return _installScript;
	}

	@Override
	public void setInstallScript(String installScript) {
		_installScript = installScript;

		if (_requiredLibRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibRemoteModel.getClass();

				Method method = clazz.getMethod("setInstallScript", String.class);

				method.invoke(_requiredLibRemoteModel, installScript);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRequiredLibRemoteModel() {
		return _requiredLibRemoteModel;
	}

	public void setRequiredLibRemoteModel(BaseModel<?> requiredLibRemoteModel) {
		_requiredLibRemoteModel = requiredLibRemoteModel;
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

		Class<?> remoteModelClass = _requiredLibRemoteModel.getClass();

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

		Object returnValue = method.invoke(_requiredLibRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RequiredLibLocalServiceUtil.addRequiredLib(this);
		}
		else {
			RequiredLibLocalServiceUtil.updateRequiredLib(this);
		}
	}

	@Override
	public RequiredLib toEscapedModel() {
		return (RequiredLib)ProxyUtil.newProxyInstance(RequiredLib.class.getClassLoader(),
			new Class[] { RequiredLib.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RequiredLibClp clone = new RequiredLibClp();

		clone.setRequiredLibId(getRequiredLibId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLibraryName(getLibraryName());
		clone.setLibraryVersion(getLibraryVersion());
		clone.setLibraryType(getLibraryType());
		clone.setLibrarySrcPath(getLibrarySrcPath());
		clone.setInstallScript(getInstallScript());

		return clone;
	}

	@Override
	public int compareTo(RequiredLib requiredLib) {
		long primaryKey = requiredLib.getPrimaryKey();

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

		if (!(obj instanceof RequiredLibClp)) {
			return false;
		}

		RequiredLibClp requiredLib = (RequiredLibClp)obj;

		long primaryKey = requiredLib.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{requiredLibId=");
		sb.append(getRequiredLibId());
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
		sb.append(", libraryName=");
		sb.append(getLibraryName());
		sb.append(", libraryVersion=");
		sb.append(getLibraryVersion());
		sb.append(", libraryType=");
		sb.append(getLibraryType());
		sb.append(", librarySrcPath=");
		sb.append(getLibrarySrcPath());
		sb.append(", installScript=");
		sb.append(getInstallScript());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.science.model.RequiredLib");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>requiredLibId</column-name><column-value><![CDATA[");
		sb.append(getRequiredLibId());
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
			"<column><column-name>libraryName</column-name><column-value><![CDATA[");
		sb.append(getLibraryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryVersion</column-name><column-value><![CDATA[");
		sb.append(getLibraryVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryType</column-name><column-value><![CDATA[");
		sb.append(getLibraryType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>librarySrcPath</column-name><column-value><![CDATA[");
		sb.append(getLibrarySrcPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>installScript</column-name><column-value><![CDATA[");
		sb.append(getInstallScript());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _requiredLibId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _libraryName;
	private String _libraryVersion;
	private String _libraryType;
	private String _librarySrcPath;
	private String _installScript;
	private BaseModel<?> _requiredLibRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.science.service.ClpSerializer.class;
}