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
import com.kisti.science.platform.app.service.CommonPackageLocalServiceUtil;
import com.kisti.science.platform.app.service.persistence.CommonPackagePK;

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
public class CommonPackageClp extends BaseModelImpl<CommonPackage>
	implements CommonPackage {
	public CommonPackageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CommonPackage.class;
	}

	@Override
	public String getModelClassName() {
		return CommonPackage.class.getName();
	}

	@Override
	public CommonPackagePK getPrimaryKey() {
		return new CommonPackagePK(_pkgName, _pkgVersion);
	}

	@Override
	public void setPrimaryKey(CommonPackagePK primaryKey) {
		setPkgName(primaryKey.pkgName);
		setPkgVersion(primaryKey.pkgVersion);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new CommonPackagePK(_pkgName, _pkgVersion);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((CommonPackagePK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("pkgName", getPkgName());
		attributes.put("pkgVersion", getPkgVersion());
		attributes.put("sysArch", getSysArch());
		attributes.put("installMethod", getInstallMethod());
		attributes.put("installPath", getInstallPath());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String pkgName = (String)attributes.get("pkgName");

		if (pkgName != null) {
			setPkgName(pkgName);
		}

		String pkgVersion = (String)attributes.get("pkgVersion");

		if (pkgVersion != null) {
			setPkgVersion(pkgVersion);
		}

		String sysArch = (String)attributes.get("sysArch");

		if (sysArch != null) {
			setSysArch(sysArch);
		}

		String installMethod = (String)attributes.get("installMethod");

		if (installMethod != null) {
			setInstallMethod(installMethod);
		}

		String installPath = (String)attributes.get("installPath");

		if (installPath != null) {
			setInstallPath(installPath);
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_commonPackageRemoteModel != null) {
			try {
				Class<?> clazz = _commonPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_commonPackageRemoteModel, groupId);
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

		if (_commonPackageRemoteModel != null) {
			try {
				Class<?> clazz = _commonPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_commonPackageRemoteModel, companyId);
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

		if (_commonPackageRemoteModel != null) {
			try {
				Class<?> clazz = _commonPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_commonPackageRemoteModel, userId);
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

		if (_commonPackageRemoteModel != null) {
			try {
				Class<?> clazz = _commonPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_commonPackageRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_commonPackageRemoteModel != null) {
			try {
				Class<?> clazz = _commonPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_commonPackageRemoteModel, createDate);
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

		if (_commonPackageRemoteModel != null) {
			try {
				Class<?> clazz = _commonPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_commonPackageRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPkgName() {
		return _pkgName;
	}

	@Override
	public void setPkgName(String pkgName) {
		_pkgName = pkgName;

		if (_commonPackageRemoteModel != null) {
			try {
				Class<?> clazz = _commonPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setPkgName", String.class);

				method.invoke(_commonPackageRemoteModel, pkgName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPkgVersion() {
		return _pkgVersion;
	}

	@Override
	public void setPkgVersion(String pkgVersion) {
		_pkgVersion = pkgVersion;

		if (_commonPackageRemoteModel != null) {
			try {
				Class<?> clazz = _commonPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setPkgVersion", String.class);

				method.invoke(_commonPackageRemoteModel, pkgVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSysArch() {
		return _sysArch;
	}

	@Override
	public void setSysArch(String sysArch) {
		_sysArch = sysArch;

		if (_commonPackageRemoteModel != null) {
			try {
				Class<?> clazz = _commonPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setSysArch", String.class);

				method.invoke(_commonPackageRemoteModel, sysArch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInstallMethod() {
		return _installMethod;
	}

	@Override
	public void setInstallMethod(String installMethod) {
		_installMethod = installMethod;

		if (_commonPackageRemoteModel != null) {
			try {
				Class<?> clazz = _commonPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setInstallMethod", String.class);

				method.invoke(_commonPackageRemoteModel, installMethod);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInstallPath() {
		return _installPath;
	}

	@Override
	public void setInstallPath(String installPath) {
		_installPath = installPath;

		if (_commonPackageRemoteModel != null) {
			try {
				Class<?> clazz = _commonPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setInstallPath", String.class);

				method.invoke(_commonPackageRemoteModel, installPath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCommonPackageRemoteModel() {
		return _commonPackageRemoteModel;
	}

	public void setCommonPackageRemoteModel(
		BaseModel<?> commonPackageRemoteModel) {
		_commonPackageRemoteModel = commonPackageRemoteModel;
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

		Class<?> remoteModelClass = _commonPackageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_commonPackageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CommonPackageLocalServiceUtil.addCommonPackage(this);
		}
		else {
			CommonPackageLocalServiceUtil.updateCommonPackage(this);
		}
	}

	@Override
	public CommonPackage toEscapedModel() {
		return (CommonPackage)ProxyUtil.newProxyInstance(CommonPackage.class.getClassLoader(),
			new Class[] { CommonPackage.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CommonPackageClp clone = new CommonPackageClp();

		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setPkgName(getPkgName());
		clone.setPkgVersion(getPkgVersion());
		clone.setSysArch(getSysArch());
		clone.setInstallMethod(getInstallMethod());
		clone.setInstallPath(getInstallPath());

		return clone;
	}

	@Override
	public int compareTo(CommonPackage commonPackage) {
		CommonPackagePK primaryKey = commonPackage.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommonPackageClp)) {
			return false;
		}

		CommonPackageClp commonPackage = (CommonPackageClp)obj;

		CommonPackagePK primaryKey = commonPackage.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", pkgName=");
		sb.append(getPkgName());
		sb.append(", pkgVersion=");
		sb.append(getPkgVersion());
		sb.append(", sysArch=");
		sb.append(getSysArch());
		sb.append(", installMethod=");
		sb.append(getInstallMethod());
		sb.append(", installPath=");
		sb.append(getInstallPath());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.kisti.science.platform.app.model.CommonPackage");
		sb.append("</model-name>");

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
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>pkgName</column-name><column-value><![CDATA[");
		sb.append(getPkgName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pkgVersion</column-name><column-value><![CDATA[");
		sb.append(getPkgVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sysArch</column-name><column-value><![CDATA[");
		sb.append(getSysArch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>installMethod</column-name><column-value><![CDATA[");
		sb.append(getInstallMethod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>installPath</column-name><column-value><![CDATA[");
		sb.append(getInstallPath());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _pkgName;
	private String _pkgVersion;
	private String _sysArch;
	private String _installMethod;
	private String _installPath;
	private BaseModel<?> _commonPackageRemoteModel;
	private Class<?> _clpSerializerClass = com.kisti.science.platform.app.service.ClpSerializer.class;
}