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

import org.kisti.edison.science.service.ClpSerializer;
import org.kisti.edison.science.service.CommonLibLocalServiceUtil;
import org.kisti.edison.science.service.persistence.CommonLibPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class CommonLibClp extends BaseModelImpl<CommonLib> implements CommonLib {
	public CommonLibClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CommonLib.class;
	}

	@Override
	public String getModelClassName() {
		return CommonLib.class.getName();
	}

	@Override
	public CommonLibPK getPrimaryKey() {
		return new CommonLibPK(_libName, _libPath);
	}

	@Override
	public void setPrimaryKey(CommonLibPK primaryKey) {
		setLibName(primaryKey.libName);
		setLibPath(primaryKey.libPath);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new CommonLibPK(_libName, _libPath);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((CommonLibPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("libName", getLibName());
		attributes.put("libPath", getLibPath());
		attributes.put("libraryVersion", getLibraryVersion());
		attributes.put("cLibVer", getCLibVer());
		attributes.put("sysArch", getSysArch());
		attributes.put("kernelVer", getKernelVer());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String libName = (String)attributes.get("libName");

		if (libName != null) {
			setLibName(libName);
		}

		String libPath = (String)attributes.get("libPath");

		if (libPath != null) {
			setLibPath(libPath);
		}

		String libraryVersion = (String)attributes.get("libraryVersion");

		if (libraryVersion != null) {
			setLibraryVersion(libraryVersion);
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
	}

	@Override
	public String getLibName() {
		return _libName;
	}

	@Override
	public void setLibName(String libName) {
		_libName = libName;

		if (_commonLibRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibRemoteModel.getClass();

				Method method = clazz.getMethod("setLibName", String.class);

				method.invoke(_commonLibRemoteModel, libName);
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

		if (_commonLibRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibRemoteModel.getClass();

				Method method = clazz.getMethod("setLibPath", String.class);

				method.invoke(_commonLibRemoteModel, libPath);
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

		if (_commonLibRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryVersion",
						String.class);

				method.invoke(_commonLibRemoteModel, libraryVersion);
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

		if (_commonLibRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibRemoteModel.getClass();

				Method method = clazz.getMethod("setCLibVer", String.class);

				method.invoke(_commonLibRemoteModel, cLibVer);
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

		if (_commonLibRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibRemoteModel.getClass();

				Method method = clazz.getMethod("setSysArch", String.class);

				method.invoke(_commonLibRemoteModel, sysArch);
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

		if (_commonLibRemoteModel != null) {
			try {
				Class<?> clazz = _commonLibRemoteModel.getClass();

				Method method = clazz.getMethod("setKernelVer", String.class);

				method.invoke(_commonLibRemoteModel, kernelVer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCommonLibRemoteModel() {
		return _commonLibRemoteModel;
	}

	public void setCommonLibRemoteModel(BaseModel<?> commonLibRemoteModel) {
		_commonLibRemoteModel = commonLibRemoteModel;
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

		Class<?> remoteModelClass = _commonLibRemoteModel.getClass();

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

		Object returnValue = method.invoke(_commonLibRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CommonLibLocalServiceUtil.addCommonLib(this);
		}
		else {
			CommonLibLocalServiceUtil.updateCommonLib(this);
		}
	}

	@Override
	public CommonLib toEscapedModel() {
		return (CommonLib)ProxyUtil.newProxyInstance(CommonLib.class.getClassLoader(),
			new Class[] { CommonLib.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CommonLibClp clone = new CommonLibClp();

		clone.setLibName(getLibName());
		clone.setLibPath(getLibPath());
		clone.setLibraryVersion(getLibraryVersion());
		clone.setCLibVer(getCLibVer());
		clone.setSysArch(getSysArch());
		clone.setKernelVer(getKernelVer());

		return clone;
	}

	@Override
	public int compareTo(CommonLib commonLib) {
		CommonLibPK primaryKey = commonLib.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommonLibClp)) {
			return false;
		}

		CommonLibClp commonLib = (CommonLibClp)obj;

		CommonLibPK primaryKey = commonLib.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{libName=");
		sb.append(getLibName());
		sb.append(", libPath=");
		sb.append(getLibPath());
		sb.append(", libraryVersion=");
		sb.append(getLibraryVersion());
		sb.append(", cLibVer=");
		sb.append(getCLibVer());
		sb.append(", sysArch=");
		sb.append(getSysArch());
		sb.append(", kernelVer=");
		sb.append(getKernelVer());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.science.model.CommonLib");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>libName</column-name><column-value><![CDATA[");
		sb.append(getLibName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libPath</column-name><column-value><![CDATA[");
		sb.append(getLibPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryVersion</column-name><column-value><![CDATA[");
		sb.append(getLibraryVersion());
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

		sb.append("</model>");

		return sb.toString();
	}

	private String _libName;
	private String _libPath;
	private String _libraryVersion;
	private String _cLibVer;
	private String _sysArch;
	private String _kernelVer;
	private BaseModel<?> _commonLibRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.science.service.ClpSerializer.class;
}