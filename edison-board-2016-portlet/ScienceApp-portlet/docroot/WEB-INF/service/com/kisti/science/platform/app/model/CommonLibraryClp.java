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
import com.kisti.science.platform.app.service.CommonLibraryLocalServiceUtil;
import com.kisti.science.platform.app.service.persistence.CommonLibraryPK;

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
public class CommonLibraryClp extends BaseModelImpl<CommonLibrary>
	implements CommonLibrary {
	public CommonLibraryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CommonLibrary.class;
	}

	@Override
	public String getModelClassName() {
		return CommonLibrary.class.getName();
	}

	@Override
	public CommonLibraryPK getPrimaryKey() {
		return new CommonLibraryPK(_libName, _libPath);
	}

	@Override
	public void setPrimaryKey(CommonLibraryPK primaryKey) {
		setLibName(primaryKey.libName);
		setLibPath(primaryKey.libPath);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new CommonLibraryPK(_libName, _libPath);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((CommonLibraryPK)primaryKeyObj);
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
		attributes.put("libName", getLibName());
		attributes.put("cLibVer", getCLibVer());
		attributes.put("sysArch", getSysArch());
		attributes.put("kernelVer", getKernelVer());
		attributes.put("libPath", getLibPath());

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

		String libName = (String)attributes.get("libName");

		if (libName != null) {
			setLibName(libName);
		}

		String cLibVer = (String)attributes.get("cLibVer");

		if (cLibVer != null) {
			setCLibVer(cLibVer);
		}

		String sysArch = (String)attributes.get("sysArch");

		if (sysArch != null) {
			setSysArch(sysArch);
		}

		String kernelVer = (String)attributes.get("kernelVer");

		if (kernelVer != null) {
			setKernelVer(kernelVer);
		}

		String libPath = (String)attributes.get("libPath");

		if (libPath != null) {
			setLibPath(libPath);
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_commonLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_commonLibraryRemoteModel, groupId);
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

		if (_commonLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_commonLibraryRemoteModel, companyId);
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

		if (_commonLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_commonLibraryRemoteModel, userId);
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

		if (_commonLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_commonLibraryRemoteModel, userName);
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

		if (_commonLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_commonLibraryRemoteModel, createDate);
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

		if (_commonLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_commonLibraryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLibName() {
		return _libName;
	}

	@Override
	public void setLibName(String libName) {
		_libName = libName;

		if (_commonLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setLibName", String.class);

				method.invoke(_commonLibraryRemoteModel, libName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCLibVer() {
		return _cLibVer;
	}

	@Override
	public void setCLibVer(String cLibVer) {
		_cLibVer = cLibVer;

		if (_commonLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setCLibVer", String.class);

				method.invoke(_commonLibraryRemoteModel, cLibVer);
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

		if (_commonLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setSysArch", String.class);

				method.invoke(_commonLibraryRemoteModel, sysArch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKernelVer() {
		return _kernelVer;
	}

	@Override
	public void setKernelVer(String kernelVer) {
		_kernelVer = kernelVer;

		if (_commonLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setKernelVer", String.class);

				method.invoke(_commonLibraryRemoteModel, kernelVer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLibPath() {
		return _libPath;
	}

	@Override
	public void setLibPath(String libPath) {
		_libPath = libPath;

		if (_commonLibraryRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibraryRemoteModel.getClass();

				Method method = clazz.getMethod("setLibPath", String.class);

				method.invoke(_commonLibraryRemoteModel, libPath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCommonLibraryRemoteModel() {
		return _commonLibraryRemoteModel;
	}

	public void setCommonLibraryRemoteModel(
		BaseModel<?> commonLibraryRemoteModel) {
		_commonLibraryRemoteModel = commonLibraryRemoteModel;
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

		Class<?> remoteModelClass = _commonLibraryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_commonLibraryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CommonLibraryLocalServiceUtil.addCommonLibrary(this);
		}
		else {
			CommonLibraryLocalServiceUtil.updateCommonLibrary(this);
		}
	}

	@Override
	public CommonLibrary toEscapedModel() {
		return (CommonLibrary)ProxyUtil.newProxyInstance(CommonLibrary.class.getClassLoader(),
			new Class[] { CommonLibrary.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CommonLibraryClp clone = new CommonLibraryClp();

		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLibName(getLibName());
		clone.setCLibVer(getCLibVer());
		clone.setSysArch(getSysArch());
		clone.setKernelVer(getKernelVer());
		clone.setLibPath(getLibPath());

		return clone;
	}

	@Override
	public int compareTo(CommonLibrary commonLibrary) {
		CommonLibraryPK primaryKey = commonLibrary.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommonLibraryClp)) {
			return false;
		}

		CommonLibraryClp commonLibrary = (CommonLibraryClp)obj;

		CommonLibraryPK primaryKey = commonLibrary.getPrimaryKey();

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
		sb.append(", libName=");
		sb.append(getLibName());
		sb.append(", cLibVer=");
		sb.append(getCLibVer());
		sb.append(", sysArch=");
		sb.append(getSysArch());
		sb.append(", kernelVer=");
		sb.append(getKernelVer());
		sb.append(", libPath=");
		sb.append(getLibPath());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.kisti.science.platform.app.model.CommonLibrary");
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
			"<column><column-name>libName</column-name><column-value><![CDATA[");
		sb.append(getLibName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cLibVer</column-name><column-value><![CDATA[");
		sb.append(getCLibVer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sysArch</column-name><column-value><![CDATA[");
		sb.append(getSysArch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>kernelVer</column-name><column-value><![CDATA[");
		sb.append(getKernelVer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libPath</column-name><column-value><![CDATA[");
		sb.append(getLibPath());
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
	private String _libName;
	private String _cLibVer;
	private String _sysArch;
	private String _kernelVer;
	private String _libPath;
	private BaseModel<?> _commonLibraryRemoteModel;
	private Class<?> _clpSerializerClass = com.kisti.science.platform.app.service.ClpSerializer.class;
}