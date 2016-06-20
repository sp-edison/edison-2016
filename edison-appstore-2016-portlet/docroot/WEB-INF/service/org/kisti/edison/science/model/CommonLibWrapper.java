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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CommonLib}.
 * </p>
 *
 * @author EDISON
 * @see CommonLib
 * @generated
 */
public class CommonLibWrapper implements CommonLib, ModelWrapper<CommonLib> {
	public CommonLibWrapper(CommonLib commonLib) {
		_commonLib = commonLib;
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

	/**
	* Returns the primary key of this common lib.
	*
	* @return the primary key of this common lib
	*/
	@Override
	public org.kisti.edison.science.service.persistence.CommonLibPK getPrimaryKey() {
		return _commonLib.getPrimaryKey();
	}

	/**
	* Sets the primary key of this common lib.
	*
	* @param primaryKey the primary key of this common lib
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.science.service.persistence.CommonLibPK primaryKey) {
		_commonLib.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the lib name of this common lib.
	*
	* @return the lib name of this common lib
	*/
	@Override
	public java.lang.String getLibName() {
		return _commonLib.getLibName();
	}

	/**
	* Sets the lib name of this common lib.
	*
	* @param libName the lib name of this common lib
	*/
	@Override
	public void setLibName(java.lang.String libName) {
		_commonLib.setLibName(libName);
	}

	/**
	* Returns the lib path of this common lib.
	*
	* @return the lib path of this common lib
	*/
	@Override
	public java.lang.String getLibPath() {
		return _commonLib.getLibPath();
	}

	/**
	* Sets the lib path of this common lib.
	*
	* @param libPath the lib path of this common lib
	*/
	@Override
	public void setLibPath(java.lang.String libPath) {
		_commonLib.setLibPath(libPath);
	}

	/**
	* Returns the library version of this common lib.
	*
	* @return the library version of this common lib
	*/
	@Override
	public java.lang.String getLibraryVersion() {
		return _commonLib.getLibraryVersion();
	}

	/**
	* Sets the library version of this common lib.
	*
	* @param libraryVersion the library version of this common lib
	*/
	@Override
	public void setLibraryVersion(java.lang.String libraryVersion) {
		_commonLib.setLibraryVersion(libraryVersion);
	}

	/**
	* Returns the c lib ver of this common lib.
	*
	* @return the c lib ver of this common lib
	*/
	@Override
	public java.lang.String getCLibVer() {
		return _commonLib.getCLibVer();
	}

	/**
	* Sets the c lib ver of this common lib.
	*
	* @param cLibVer the c lib ver of this common lib
	*/
	@Override
	public void setCLibVer(java.lang.String cLibVer) {
		_commonLib.setCLibVer(cLibVer);
	}

	/**
	* Returns the sys arch of this common lib.
	*
	* @return the sys arch of this common lib
	*/
	@Override
	public java.lang.String getSysArch() {
		return _commonLib.getSysArch();
	}

	/**
	* Sets the sys arch of this common lib.
	*
	* @param sysArch the sys arch of this common lib
	*/
	@Override
	public void setSysArch(java.lang.String sysArch) {
		_commonLib.setSysArch(sysArch);
	}

	/**
	* Returns the kernel ver of this common lib.
	*
	* @return the kernel ver of this common lib
	*/
	@Override
	public java.lang.String getKernelVer() {
		return _commonLib.getKernelVer();
	}

	/**
	* Sets the kernel ver of this common lib.
	*
	* @param kernelVer the kernel ver of this common lib
	*/
	@Override
	public void setKernelVer(java.lang.String kernelVer) {
		_commonLib.setKernelVer(kernelVer);
	}

	@Override
	public boolean isNew() {
		return _commonLib.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_commonLib.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _commonLib.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_commonLib.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _commonLib.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _commonLib.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_commonLib.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _commonLib.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_commonLib.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_commonLib.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_commonLib.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CommonLibWrapper((CommonLib)_commonLib.clone());
	}

	@Override
	public int compareTo(org.kisti.edison.science.model.CommonLib commonLib) {
		return _commonLib.compareTo(commonLib);
	}

	@Override
	public int hashCode() {
		return _commonLib.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.science.model.CommonLib> toCacheModel() {
		return _commonLib.toCacheModel();
	}

	@Override
	public org.kisti.edison.science.model.CommonLib toEscapedModel() {
		return new CommonLibWrapper(_commonLib.toEscapedModel());
	}

	@Override
	public org.kisti.edison.science.model.CommonLib toUnescapedModel() {
		return new CommonLibWrapper(_commonLib.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _commonLib.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _commonLib.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_commonLib.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommonLibWrapper)) {
			return false;
		}

		CommonLibWrapper commonLibWrapper = (CommonLibWrapper)obj;

		if (Validator.equals(_commonLib, commonLibWrapper._commonLib)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CommonLib getWrappedCommonLib() {
		return _commonLib;
	}

	@Override
	public CommonLib getWrappedModel() {
		return _commonLib;
	}

	@Override
	public void resetOriginalValues() {
		_commonLib.resetOriginalValues();
	}

	private CommonLib _commonLib;
}