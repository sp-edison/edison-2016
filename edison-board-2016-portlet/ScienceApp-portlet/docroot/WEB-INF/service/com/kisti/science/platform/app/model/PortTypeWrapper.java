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
 * This class is a wrapper for {@link PortType}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortType
 * @generated
 */
public class PortTypeWrapper implements PortType, ModelWrapper<PortType> {
	public PortTypeWrapper(PortType portType) {
		_portType = portType;
	}

	@Override
	public Class<?> getModelClass() {
		return PortType.class;
	}

	@Override
	public String getModelClassName() {
		return PortType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("portTypeId", getPortTypeId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("defaultEditorId", getDefaultEditorId());
		attributes.put("defaultAnalyzerId", getDefaultAnalyzerId());
		attributes.put("name", getName());
		attributes.put("dataType", getDataType());
		attributes.put("sampleFilePath", getSampleFilePath());
		attributes.put("targetLanguage", getTargetLanguage());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long portTypeId = (Long)attributes.get("portTypeId");

		if (portTypeId != null) {
			setPortTypeId(portTypeId);
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

		Long defaultEditorId = (Long)attributes.get("defaultEditorId");

		if (defaultEditorId != null) {
			setDefaultEditorId(defaultEditorId);
		}

		Long defaultAnalyzerId = (Long)attributes.get("defaultAnalyzerId");

		if (defaultAnalyzerId != null) {
			setDefaultAnalyzerId(defaultAnalyzerId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String dataType = (String)attributes.get("dataType");

		if (dataType != null) {
			setDataType(dataType);
		}

		String sampleFilePath = (String)attributes.get("sampleFilePath");

		if (sampleFilePath != null) {
			setSampleFilePath(sampleFilePath);
		}

		String targetLanguage = (String)attributes.get("targetLanguage");

		if (targetLanguage != null) {
			setTargetLanguage(targetLanguage);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this port type.
	*
	* @return the primary key of this port type
	*/
	@Override
	public long getPrimaryKey() {
		return _portType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this port type.
	*
	* @param primaryKey the primary key of this port type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_portType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this port type.
	*
	* @return the uuid of this port type
	*/
	@Override
	public java.lang.String getUuid() {
		return _portType.getUuid();
	}

	/**
	* Sets the uuid of this port type.
	*
	* @param uuid the uuid of this port type
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_portType.setUuid(uuid);
	}

	/**
	* Returns the port type ID of this port type.
	*
	* @return the port type ID of this port type
	*/
	@Override
	public long getPortTypeId() {
		return _portType.getPortTypeId();
	}

	/**
	* Sets the port type ID of this port type.
	*
	* @param portTypeId the port type ID of this port type
	*/
	@Override
	public void setPortTypeId(long portTypeId) {
		_portType.setPortTypeId(portTypeId);
	}

	/**
	* Returns the company ID of this port type.
	*
	* @return the company ID of this port type
	*/
	@Override
	public long getCompanyId() {
		return _portType.getCompanyId();
	}

	/**
	* Sets the company ID of this port type.
	*
	* @param companyId the company ID of this port type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_portType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this port type.
	*
	* @return the user ID of this port type
	*/
	@Override
	public long getUserId() {
		return _portType.getUserId();
	}

	/**
	* Sets the user ID of this port type.
	*
	* @param userId the user ID of this port type
	*/
	@Override
	public void setUserId(long userId) {
		_portType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this port type.
	*
	* @return the user uuid of this port type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portType.getUserUuid();
	}

	/**
	* Sets the user uuid of this port type.
	*
	* @param userUuid the user uuid of this port type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_portType.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this port type.
	*
	* @return the create date of this port type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _portType.getCreateDate();
	}

	/**
	* Sets the create date of this port type.
	*
	* @param createDate the create date of this port type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_portType.setCreateDate(createDate);
	}

	/**
	* Returns the default editor ID of this port type.
	*
	* @return the default editor ID of this port type
	*/
	@Override
	public long getDefaultEditorId() {
		return _portType.getDefaultEditorId();
	}

	/**
	* Sets the default editor ID of this port type.
	*
	* @param defaultEditorId the default editor ID of this port type
	*/
	@Override
	public void setDefaultEditorId(long defaultEditorId) {
		_portType.setDefaultEditorId(defaultEditorId);
	}

	/**
	* Returns the default analyzer ID of this port type.
	*
	* @return the default analyzer ID of this port type
	*/
	@Override
	public long getDefaultAnalyzerId() {
		return _portType.getDefaultAnalyzerId();
	}

	/**
	* Sets the default analyzer ID of this port type.
	*
	* @param defaultAnalyzerId the default analyzer ID of this port type
	*/
	@Override
	public void setDefaultAnalyzerId(long defaultAnalyzerId) {
		_portType.setDefaultAnalyzerId(defaultAnalyzerId);
	}

	/**
	* Returns the name of this port type.
	*
	* @return the name of this port type
	*/
	@Override
	public java.lang.String getName() {
		return _portType.getName();
	}

	/**
	* Sets the name of this port type.
	*
	* @param name the name of this port type
	*/
	@Override
	public void setName(java.lang.String name) {
		_portType.setName(name);
	}

	/**
	* Returns the data type of this port type.
	*
	* @return the data type of this port type
	*/
	@Override
	public java.lang.String getDataType() {
		return _portType.getDataType();
	}

	/**
	* Sets the data type of this port type.
	*
	* @param dataType the data type of this port type
	*/
	@Override
	public void setDataType(java.lang.String dataType) {
		_portType.setDataType(dataType);
	}

	/**
	* Returns the sample file path of this port type.
	*
	* @return the sample file path of this port type
	*/
	@Override
	public java.lang.String getSampleFilePath() {
		return _portType.getSampleFilePath();
	}

	/**
	* Sets the sample file path of this port type.
	*
	* @param sampleFilePath the sample file path of this port type
	*/
	@Override
	public void setSampleFilePath(java.lang.String sampleFilePath) {
		_portType.setSampleFilePath(sampleFilePath);
	}

	/**
	* Returns the target language of this port type.
	*
	* @return the target language of this port type
	*/
	@Override
	public java.lang.String getTargetLanguage() {
		return _portType.getTargetLanguage();
	}

	/**
	* Sets the target language of this port type.
	*
	* @param targetLanguage the target language of this port type
	*/
	@Override
	public void setTargetLanguage(java.lang.String targetLanguage) {
		_portType.setTargetLanguage(targetLanguage);
	}

	/**
	* Returns the status of this port type.
	*
	* @return the status of this port type
	*/
	@Override
	public java.lang.String getStatus() {
		return _portType.getStatus();
	}

	/**
	* Sets the status of this port type.
	*
	* @param status the status of this port type
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_portType.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _portType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_portType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _portType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_portType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _portType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _portType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_portType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _portType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_portType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_portType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_portType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PortTypeWrapper((PortType)_portType.clone());
	}

	@Override
	public int compareTo(com.kisti.science.platform.app.model.PortType portType) {
		return _portType.compareTo(portType);
	}

	@Override
	public int hashCode() {
		return _portType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kisti.science.platform.app.model.PortType> toCacheModel() {
		return _portType.toCacheModel();
	}

	@Override
	public com.kisti.science.platform.app.model.PortType toEscapedModel() {
		return new PortTypeWrapper(_portType.toEscapedModel());
	}

	@Override
	public com.kisti.science.platform.app.model.PortType toUnescapedModel() {
		return new PortTypeWrapper(_portType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _portType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _portType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_portType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortTypeWrapper)) {
			return false;
		}

		PortTypeWrapper portTypeWrapper = (PortTypeWrapper)obj;

		if (Validator.equals(_portType, portTypeWrapper._portType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PortType getWrappedPortType() {
		return _portType;
	}

	@Override
	public PortType getWrappedModel() {
		return _portType;
	}

	@Override
	public void resetOriginalValues() {
		_portType.resetOriginalValues();
	}

	private PortType _portType;
}