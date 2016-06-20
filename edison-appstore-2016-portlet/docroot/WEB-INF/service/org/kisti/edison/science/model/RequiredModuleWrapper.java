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
 * This class is a wrapper for {@link RequiredModule}.
 * </p>
 *
 * @author EDISON
 * @see RequiredModule
 * @generated
 */
public class RequiredModuleWrapper implements RequiredModule,
	ModelWrapper<RequiredModule> {
	public RequiredModuleWrapper(RequiredModule requiredModule) {
		_requiredModule = requiredModule;
	}

	@Override
	public Class<?> getModelClass() {
		return RequiredModule.class;
	}

	@Override
	public String getModelClassName() {
		return RequiredModule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("requiredModuleId", getRequiredModuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("moduleName", getModuleName());
		attributes.put("moduleVersion", getModuleVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long requiredModuleId = (Long)attributes.get("requiredModuleId");

		if (requiredModuleId != null) {
			setRequiredModuleId(requiredModuleId);
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

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
		}

		String moduleVersion = (String)attributes.get("moduleVersion");

		if (moduleVersion != null) {
			setModuleVersion(moduleVersion);
		}
	}

	/**
	* Returns the primary key of this required module.
	*
	* @return the primary key of this required module
	*/
	@Override
	public long getPrimaryKey() {
		return _requiredModule.getPrimaryKey();
	}

	/**
	* Sets the primary key of this required module.
	*
	* @param primaryKey the primary key of this required module
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_requiredModule.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the required module ID of this required module.
	*
	* @return the required module ID of this required module
	*/
	@Override
	public long getRequiredModuleId() {
		return _requiredModule.getRequiredModuleId();
	}

	/**
	* Sets the required module ID of this required module.
	*
	* @param requiredModuleId the required module ID of this required module
	*/
	@Override
	public void setRequiredModuleId(long requiredModuleId) {
		_requiredModule.setRequiredModuleId(requiredModuleId);
	}

	/**
	* Returns the group ID of this required module.
	*
	* @return the group ID of this required module
	*/
	@Override
	public long getGroupId() {
		return _requiredModule.getGroupId();
	}

	/**
	* Sets the group ID of this required module.
	*
	* @param groupId the group ID of this required module
	*/
	@Override
	public void setGroupId(long groupId) {
		_requiredModule.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this required module.
	*
	* @return the company ID of this required module
	*/
	@Override
	public long getCompanyId() {
		return _requiredModule.getCompanyId();
	}

	/**
	* Sets the company ID of this required module.
	*
	* @param companyId the company ID of this required module
	*/
	@Override
	public void setCompanyId(long companyId) {
		_requiredModule.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this required module.
	*
	* @return the user ID of this required module
	*/
	@Override
	public long getUserId() {
		return _requiredModule.getUserId();
	}

	/**
	* Sets the user ID of this required module.
	*
	* @param userId the user ID of this required module
	*/
	@Override
	public void setUserId(long userId) {
		_requiredModule.setUserId(userId);
	}

	/**
	* Returns the user uuid of this required module.
	*
	* @return the user uuid of this required module
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requiredModule.getUserUuid();
	}

	/**
	* Sets the user uuid of this required module.
	*
	* @param userUuid the user uuid of this required module
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_requiredModule.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this required module.
	*
	* @return the create date of this required module
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _requiredModule.getCreateDate();
	}

	/**
	* Sets the create date of this required module.
	*
	* @param createDate the create date of this required module
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_requiredModule.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this required module.
	*
	* @return the modified date of this required module
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _requiredModule.getModifiedDate();
	}

	/**
	* Sets the modified date of this required module.
	*
	* @param modifiedDate the modified date of this required module
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_requiredModule.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the module name of this required module.
	*
	* @return the module name of this required module
	*/
	@Override
	public java.lang.String getModuleName() {
		return _requiredModule.getModuleName();
	}

	/**
	* Sets the module name of this required module.
	*
	* @param moduleName the module name of this required module
	*/
	@Override
	public void setModuleName(java.lang.String moduleName) {
		_requiredModule.setModuleName(moduleName);
	}

	/**
	* Returns the module version of this required module.
	*
	* @return the module version of this required module
	*/
	@Override
	public java.lang.String getModuleVersion() {
		return _requiredModule.getModuleVersion();
	}

	/**
	* Sets the module version of this required module.
	*
	* @param moduleVersion the module version of this required module
	*/
	@Override
	public void setModuleVersion(java.lang.String moduleVersion) {
		_requiredModule.setModuleVersion(moduleVersion);
	}

	@Override
	public boolean isNew() {
		return _requiredModule.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_requiredModule.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _requiredModule.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_requiredModule.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _requiredModule.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _requiredModule.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_requiredModule.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _requiredModule.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_requiredModule.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_requiredModule.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_requiredModule.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RequiredModuleWrapper((RequiredModule)_requiredModule.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.science.model.RequiredModule requiredModule) {
		return _requiredModule.compareTo(requiredModule);
	}

	@Override
	public int hashCode() {
		return _requiredModule.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.science.model.RequiredModule> toCacheModel() {
		return _requiredModule.toCacheModel();
	}

	@Override
	public org.kisti.edison.science.model.RequiredModule toEscapedModel() {
		return new RequiredModuleWrapper(_requiredModule.toEscapedModel());
	}

	@Override
	public org.kisti.edison.science.model.RequiredModule toUnescapedModel() {
		return new RequiredModuleWrapper(_requiredModule.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _requiredModule.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _requiredModule.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_requiredModule.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RequiredModuleWrapper)) {
			return false;
		}

		RequiredModuleWrapper requiredModuleWrapper = (RequiredModuleWrapper)obj;

		if (Validator.equals(_requiredModule,
					requiredModuleWrapper._requiredModule)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RequiredModule getWrappedRequiredModule() {
		return _requiredModule;
	}

	@Override
	public RequiredModule getWrappedModel() {
		return _requiredModule;
	}

	@Override
	public void resetOriginalValues() {
		_requiredModule.resetOriginalValues();
	}

	private RequiredModule _requiredModule;
}