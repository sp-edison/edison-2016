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
 * This class is a wrapper for {@link CommonPackage}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonPackage
 * @generated
 */
public class CommonPackageWrapper implements CommonPackage,
	ModelWrapper<CommonPackage> {
	public CommonPackageWrapper(CommonPackage commonPackage) {
		_commonPackage = commonPackage;
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

	/**
	* Returns the primary key of this common package.
	*
	* @return the primary key of this common package
	*/
	@Override
	public com.kisti.science.platform.app.service.persistence.CommonPackagePK getPrimaryKey() {
		return _commonPackage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this common package.
	*
	* @param primaryKey the primary key of this common package
	*/
	@Override
	public void setPrimaryKey(
		com.kisti.science.platform.app.service.persistence.CommonPackagePK primaryKey) {
		_commonPackage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group ID of this common package.
	*
	* @return the group ID of this common package
	*/
	@Override
	public long getGroupId() {
		return _commonPackage.getGroupId();
	}

	/**
	* Sets the group ID of this common package.
	*
	* @param groupId the group ID of this common package
	*/
	@Override
	public void setGroupId(long groupId) {
		_commonPackage.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this common package.
	*
	* @return the company ID of this common package
	*/
	@Override
	public long getCompanyId() {
		return _commonPackage.getCompanyId();
	}

	/**
	* Sets the company ID of this common package.
	*
	* @param companyId the company ID of this common package
	*/
	@Override
	public void setCompanyId(long companyId) {
		_commonPackage.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this common package.
	*
	* @return the user ID of this common package
	*/
	@Override
	public long getUserId() {
		return _commonPackage.getUserId();
	}

	/**
	* Sets the user ID of this common package.
	*
	* @param userId the user ID of this common package
	*/
	@Override
	public void setUserId(long userId) {
		_commonPackage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this common package.
	*
	* @return the user uuid of this common package
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonPackage.getUserUuid();
	}

	/**
	* Sets the user uuid of this common package.
	*
	* @param userUuid the user uuid of this common package
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_commonPackage.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this common package.
	*
	* @return the user name of this common package
	*/
	@Override
	public java.lang.String getUserName() {
		return _commonPackage.getUserName();
	}

	/**
	* Sets the user name of this common package.
	*
	* @param userName the user name of this common package
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_commonPackage.setUserName(userName);
	}

	/**
	* Returns the create date of this common package.
	*
	* @return the create date of this common package
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _commonPackage.getCreateDate();
	}

	/**
	* Sets the create date of this common package.
	*
	* @param createDate the create date of this common package
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_commonPackage.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this common package.
	*
	* @return the modified date of this common package
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _commonPackage.getModifiedDate();
	}

	/**
	* Sets the modified date of this common package.
	*
	* @param modifiedDate the modified date of this common package
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_commonPackage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the pkg name of this common package.
	*
	* @return the pkg name of this common package
	*/
	@Override
	public java.lang.String getPkgName() {
		return _commonPackage.getPkgName();
	}

	/**
	* Sets the pkg name of this common package.
	*
	* @param pkgName the pkg name of this common package
	*/
	@Override
	public void setPkgName(java.lang.String pkgName) {
		_commonPackage.setPkgName(pkgName);
	}

	/**
	* Returns the pkg version of this common package.
	*
	* @return the pkg version of this common package
	*/
	@Override
	public java.lang.String getPkgVersion() {
		return _commonPackage.getPkgVersion();
	}

	/**
	* Sets the pkg version of this common package.
	*
	* @param pkgVersion the pkg version of this common package
	*/
	@Override
	public void setPkgVersion(java.lang.String pkgVersion) {
		_commonPackage.setPkgVersion(pkgVersion);
	}

	/**
	* Returns the sys arch of this common package.
	*
	* @return the sys arch of this common package
	*/
	@Override
	public java.lang.String getSysArch() {
		return _commonPackage.getSysArch();
	}

	/**
	* Sets the sys arch of this common package.
	*
	* @param sysArch the sys arch of this common package
	*/
	@Override
	public void setSysArch(java.lang.String sysArch) {
		_commonPackage.setSysArch(sysArch);
	}

	/**
	* Returns the install method of this common package.
	*
	* @return the install method of this common package
	*/
	@Override
	public java.lang.String getInstallMethod() {
		return _commonPackage.getInstallMethod();
	}

	/**
	* Sets the install method of this common package.
	*
	* @param installMethod the install method of this common package
	*/
	@Override
	public void setInstallMethod(java.lang.String installMethod) {
		_commonPackage.setInstallMethod(installMethod);
	}

	/**
	* Returns the install path of this common package.
	*
	* @return the install path of this common package
	*/
	@Override
	public java.lang.String getInstallPath() {
		return _commonPackage.getInstallPath();
	}

	/**
	* Sets the install path of this common package.
	*
	* @param installPath the install path of this common package
	*/
	@Override
	public void setInstallPath(java.lang.String installPath) {
		_commonPackage.setInstallPath(installPath);
	}

	@Override
	public boolean isNew() {
		return _commonPackage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_commonPackage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _commonPackage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_commonPackage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _commonPackage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _commonPackage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_commonPackage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _commonPackage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_commonPackage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_commonPackage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_commonPackage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CommonPackageWrapper((CommonPackage)_commonPackage.clone());
	}

	@Override
	public int compareTo(
		com.kisti.science.platform.app.model.CommonPackage commonPackage) {
		return _commonPackage.compareTo(commonPackage);
	}

	@Override
	public int hashCode() {
		return _commonPackage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kisti.science.platform.app.model.CommonPackage> toCacheModel() {
		return _commonPackage.toCacheModel();
	}

	@Override
	public com.kisti.science.platform.app.model.CommonPackage toEscapedModel() {
		return new CommonPackageWrapper(_commonPackage.toEscapedModel());
	}

	@Override
	public com.kisti.science.platform.app.model.CommonPackage toUnescapedModel() {
		return new CommonPackageWrapper(_commonPackage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _commonPackage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _commonPackage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_commonPackage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommonPackageWrapper)) {
			return false;
		}

		CommonPackageWrapper commonPackageWrapper = (CommonPackageWrapper)obj;

		if (Validator.equals(_commonPackage, commonPackageWrapper._commonPackage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CommonPackage getWrappedCommonPackage() {
		return _commonPackage;
	}

	@Override
	public CommonPackage getWrappedModel() {
		return _commonPackage;
	}

	@Override
	public void resetOriginalValues() {
		_commonPackage.resetOriginalValues();
	}

	private CommonPackage _commonPackage;
}