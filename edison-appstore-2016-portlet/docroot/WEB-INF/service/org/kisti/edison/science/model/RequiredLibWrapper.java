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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RequiredLib}.
 * </p>
 *
 * @author EDISON
 * @see RequiredLib
 * @generated
 */
public class RequiredLibWrapper implements RequiredLib,
	ModelWrapper<RequiredLib> {
	public RequiredLibWrapper(RequiredLib requiredLib) {
		_requiredLib = requiredLib;
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

	/**
	* Returns the primary key of this required lib.
	*
	* @return the primary key of this required lib
	*/
	@Override
	public long getPrimaryKey() {
		return _requiredLib.getPrimaryKey();
	}

	/**
	* Sets the primary key of this required lib.
	*
	* @param primaryKey the primary key of this required lib
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_requiredLib.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the required lib ID of this required lib.
	*
	* @return the required lib ID of this required lib
	*/
	@Override
	public long getRequiredLibId() {
		return _requiredLib.getRequiredLibId();
	}

	/**
	* Sets the required lib ID of this required lib.
	*
	* @param requiredLibId the required lib ID of this required lib
	*/
	@Override
	public void setRequiredLibId(long requiredLibId) {
		_requiredLib.setRequiredLibId(requiredLibId);
	}

	/**
	* Returns the group ID of this required lib.
	*
	* @return the group ID of this required lib
	*/
	@Override
	public long getGroupId() {
		return _requiredLib.getGroupId();
	}

	/**
	* Sets the group ID of this required lib.
	*
	* @param groupId the group ID of this required lib
	*/
	@Override
	public void setGroupId(long groupId) {
		_requiredLib.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this required lib.
	*
	* @return the company ID of this required lib
	*/
	@Override
	public long getCompanyId() {
		return _requiredLib.getCompanyId();
	}

	/**
	* Sets the company ID of this required lib.
	*
	* @param companyId the company ID of this required lib
	*/
	@Override
	public void setCompanyId(long companyId) {
		_requiredLib.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this required lib.
	*
	* @return the user ID of this required lib
	*/
	@Override
	public long getUserId() {
		return _requiredLib.getUserId();
	}

	/**
	* Sets the user ID of this required lib.
	*
	* @param userId the user ID of this required lib
	*/
	@Override
	public void setUserId(long userId) {
		_requiredLib.setUserId(userId);
	}

	/**
	* Returns the user uuid of this required lib.
	*
	* @return the user uuid of this required lib
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requiredLib.getUserUuid();
	}

	/**
	* Sets the user uuid of this required lib.
	*
	* @param userUuid the user uuid of this required lib
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_requiredLib.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this required lib.
	*
	* @return the create date of this required lib
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _requiredLib.getCreateDate();
	}

	/**
	* Sets the create date of this required lib.
	*
	* @param createDate the create date of this required lib
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_requiredLib.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this required lib.
	*
	* @return the modified date of this required lib
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _requiredLib.getModifiedDate();
	}

	/**
	* Sets the modified date of this required lib.
	*
	* @param modifiedDate the modified date of this required lib
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_requiredLib.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the library name of this required lib.
	*
	* @return the library name of this required lib
	*/
	@Override
	public java.lang.String getLibraryName() {
		return _requiredLib.getLibraryName();
	}

	/**
	* Sets the library name of this required lib.
	*
	* @param libraryName the library name of this required lib
	*/
	@Override
	public void setLibraryName(java.lang.String libraryName) {
		_requiredLib.setLibraryName(libraryName);
	}

	/**
	* Returns the library version of this required lib.
	*
	* @return the library version of this required lib
	*/
	@Override
	public java.lang.String getLibraryVersion() {
		return _requiredLib.getLibraryVersion();
	}

	/**
	* Sets the library version of this required lib.
	*
	* @param libraryVersion the library version of this required lib
	*/
	@Override
	public void setLibraryVersion(java.lang.String libraryVersion) {
		_requiredLib.setLibraryVersion(libraryVersion);
	}

	/**
	* Returns the library type of this required lib.
	*
	* @return the library type of this required lib
	*/
	@Override
	public java.lang.String getLibraryType() {
		return _requiredLib.getLibraryType();
	}

	/**
	* Sets the library type of this required lib.
	*
	* @param libraryType the library type of this required lib
	*/
	@Override
	public void setLibraryType(java.lang.String libraryType) {
		_requiredLib.setLibraryType(libraryType);
	}

	/**
	* Returns the library src path of this required lib.
	*
	* @return the library src path of this required lib
	*/
	@Override
	public java.lang.String getLibrarySrcPath() {
		return _requiredLib.getLibrarySrcPath();
	}

	/**
	* Sets the library src path of this required lib.
	*
	* @param librarySrcPath the library src path of this required lib
	*/
	@Override
	public void setLibrarySrcPath(java.lang.String librarySrcPath) {
		_requiredLib.setLibrarySrcPath(librarySrcPath);
	}

	/**
	* Returns the install script of this required lib.
	*
	* @return the install script of this required lib
	*/
	@Override
	public java.lang.String getInstallScript() {
		return _requiredLib.getInstallScript();
	}

	/**
	* Sets the install script of this required lib.
	*
	* @param installScript the install script of this required lib
	*/
	@Override
	public void setInstallScript(java.lang.String installScript) {
		_requiredLib.setInstallScript(installScript);
	}

	@Override
	public boolean isNew() {
		return _requiredLib.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_requiredLib.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _requiredLib.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_requiredLib.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _requiredLib.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _requiredLib.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_requiredLib.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _requiredLib.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_requiredLib.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_requiredLib.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_requiredLib.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RequiredLibWrapper((RequiredLib)_requiredLib.clone());
	}

	@Override
	public int compareTo(org.kisti.edison.science.model.RequiredLib requiredLib) {
		return _requiredLib.compareTo(requiredLib);
	}

	@Override
	public int hashCode() {
		return _requiredLib.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.science.model.RequiredLib> toCacheModel() {
		return _requiredLib.toCacheModel();
	}

	@Override
	public org.kisti.edison.science.model.RequiredLib toEscapedModel() {
		return new RequiredLibWrapper(_requiredLib.toEscapedModel());
	}

	@Override
	public org.kisti.edison.science.model.RequiredLib toUnescapedModel() {
		return new RequiredLibWrapper(_requiredLib.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _requiredLib.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _requiredLib.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_requiredLib.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RequiredLibWrapper)) {
			return false;
		}

		RequiredLibWrapper requiredLibWrapper = (RequiredLibWrapper)obj;

		if (Validator.equals(_requiredLib, requiredLibWrapper._requiredLib)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RequiredLib getWrappedRequiredLib() {
		return _requiredLib;
	}

	@Override
	public RequiredLib getWrappedModel() {
		return _requiredLib;
	}

	@Override
	public void resetOriginalValues() {
		_requiredLib.resetOriginalValues();
	}

	private RequiredLib _requiredLib;
}