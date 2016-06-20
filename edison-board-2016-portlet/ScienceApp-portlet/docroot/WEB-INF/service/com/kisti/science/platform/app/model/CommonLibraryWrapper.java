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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CommonLibrary}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonLibrary
 * @generated
 */
public class CommonLibraryWrapper implements CommonLibrary,
	ModelWrapper<CommonLibrary> {
	public CommonLibraryWrapper(CommonLibrary commonLibrary) {
		_commonLibrary = commonLibrary;
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

	/**
	* Returns the primary key of this common library.
	*
	* @return the primary key of this common library
	*/
	@Override
	public com.kisti.science.platform.app.service.persistence.CommonLibraryPK getPrimaryKey() {
		return _commonLibrary.getPrimaryKey();
	}

	/**
	* Sets the primary key of this common library.
	*
	* @param primaryKey the primary key of this common library
	*/
	@Override
	public void setPrimaryKey(
		com.kisti.science.platform.app.service.persistence.CommonLibraryPK primaryKey) {
		_commonLibrary.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group ID of this common library.
	*
	* @return the group ID of this common library
	*/
	@Override
	public long getGroupId() {
		return _commonLibrary.getGroupId();
	}

	/**
	* Sets the group ID of this common library.
	*
	* @param groupId the group ID of this common library
	*/
	@Override
	public void setGroupId(long groupId) {
		_commonLibrary.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this common library.
	*
	* @return the company ID of this common library
	*/
	@Override
	public long getCompanyId() {
		return _commonLibrary.getCompanyId();
	}

	/**
	* Sets the company ID of this common library.
	*
	* @param companyId the company ID of this common library
	*/
	@Override
	public void setCompanyId(long companyId) {
		_commonLibrary.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this common library.
	*
	* @return the user ID of this common library
	*/
	@Override
	public long getUserId() {
		return _commonLibrary.getUserId();
	}

	/**
	* Sets the user ID of this common library.
	*
	* @param userId the user ID of this common library
	*/
	@Override
	public void setUserId(long userId) {
		_commonLibrary.setUserId(userId);
	}

	/**
	* Returns the user uuid of this common library.
	*
	* @return the user uuid of this common library
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibrary.getUserUuid();
	}

	/**
	* Sets the user uuid of this common library.
	*
	* @param userUuid the user uuid of this common library
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_commonLibrary.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this common library.
	*
	* @return the user name of this common library
	*/
	@Override
	public java.lang.String getUserName() {
		return _commonLibrary.getUserName();
	}

	/**
	* Sets the user name of this common library.
	*
	* @param userName the user name of this common library
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_commonLibrary.setUserName(userName);
	}

	/**
	* Returns the create date of this common library.
	*
	* @return the create date of this common library
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _commonLibrary.getCreateDate();
	}

	/**
	* Sets the create date of this common library.
	*
	* @param createDate the create date of this common library
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_commonLibrary.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this common library.
	*
	* @return the modified date of this common library
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _commonLibrary.getModifiedDate();
	}

	/**
	* Sets the modified date of this common library.
	*
	* @param modifiedDate the modified date of this common library
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_commonLibrary.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the lib name of this common library.
	*
	* @return the lib name of this common library
	*/
	@Override
	public java.lang.String getLibName() {
		return _commonLibrary.getLibName();
	}

	/**
	* Sets the lib name of this common library.
	*
	* @param libName the lib name of this common library
	*/
	@Override
	public void setLibName(java.lang.String libName) {
		_commonLibrary.setLibName(libName);
	}

	/**
	* Returns the c lib ver of this common library.
	*
	* @return the c lib ver of this common library
	*/
	@Override
	public java.lang.String getCLibVer() {
		return _commonLibrary.getCLibVer();
	}

	/**
	* Sets the c lib ver of this common library.
	*
	* @param cLibVer the c lib ver of this common library
	*/
	@Override
	public void setCLibVer(java.lang.String cLibVer) {
		_commonLibrary.setCLibVer(cLibVer);
	}

	/**
	* Returns the sys arch of this common library.
	*
	* @return the sys arch of this common library
	*/
	@Override
	public java.lang.String getSysArch() {
		return _commonLibrary.getSysArch();
	}

	/**
	* Sets the sys arch of this common library.
	*
	* @param sysArch the sys arch of this common library
	*/
	@Override
	public void setSysArch(java.lang.String sysArch) {
		_commonLibrary.setSysArch(sysArch);
	}

	/**
	* Returns the kernel ver of this common library.
	*
	* @return the kernel ver of this common library
	*/
	@Override
	public java.lang.String getKernelVer() {
		return _commonLibrary.getKernelVer();
	}

	/**
	* Sets the kernel ver of this common library.
	*
	* @param kernelVer the kernel ver of this common library
	*/
	@Override
	public void setKernelVer(java.lang.String kernelVer) {
		_commonLibrary.setKernelVer(kernelVer);
	}

	/**
	* Returns the lib path of this common library.
	*
	* @return the lib path of this common library
	*/
	@Override
	public java.lang.String getLibPath() {
		return _commonLibrary.getLibPath();
	}

	/**
	* Sets the lib path of this common library.
	*
	* @param libPath the lib path of this common library
	*/
	@Override
	public void setLibPath(java.lang.String libPath) {
		_commonLibrary.setLibPath(libPath);
	}

	@Override
	public boolean isNew() {
		return _commonLibrary.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_commonLibrary.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _commonLibrary.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_commonLibrary.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _commonLibrary.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _commonLibrary.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_commonLibrary.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _commonLibrary.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_commonLibrary.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_commonLibrary.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_commonLibrary.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CommonLibraryWrapper((CommonLibrary)_commonLibrary.clone());
	}

	@Override
	public int compareTo(
		com.kisti.science.platform.app.model.CommonLibrary commonLibrary) {
		return _commonLibrary.compareTo(commonLibrary);
	}

	@Override
	public int hashCode() {
		return _commonLibrary.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kisti.science.platform.app.model.CommonLibrary> toCacheModel() {
		return _commonLibrary.toCacheModel();
	}

	@Override
	public com.kisti.science.platform.app.model.CommonLibrary toEscapedModel() {
		return new CommonLibraryWrapper(_commonLibrary.toEscapedModel());
	}

	@Override
	public com.kisti.science.platform.app.model.CommonLibrary toUnescapedModel() {
		return new CommonLibraryWrapper(_commonLibrary.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _commonLibrary.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _commonLibrary.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_commonLibrary.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommonLibraryWrapper)) {
			return false;
		}

		CommonLibraryWrapper commonLibraryWrapper = (CommonLibraryWrapper)obj;

		if (Validator.equals(_commonLibrary, commonLibraryWrapper._commonLibrary)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CommonLibrary getWrappedCommonLibrary() {
		return _commonLibrary;
	}

	@Override
	public CommonLibrary getWrappedModel() {
		return _commonLibrary;
	}

	@Override
	public void resetOriginalValues() {
		_commonLibrary.resetOriginalValues();
	}

	private CommonLibrary _commonLibrary;
}