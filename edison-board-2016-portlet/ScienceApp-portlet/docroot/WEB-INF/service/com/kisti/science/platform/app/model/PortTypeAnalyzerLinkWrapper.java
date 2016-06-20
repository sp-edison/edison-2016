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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PortTypeAnalyzerLink}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeAnalyzerLink
 * @generated
 */
public class PortTypeAnalyzerLinkWrapper implements PortTypeAnalyzerLink,
	ModelWrapper<PortTypeAnalyzerLink> {
	public PortTypeAnalyzerLinkWrapper(
		PortTypeAnalyzerLink portTypeAnalyzerLink) {
		_portTypeAnalyzerLink = portTypeAnalyzerLink;
	}

	@Override
	public Class<?> getModelClass() {
		return PortTypeAnalyzerLink.class;
	}

	@Override
	public String getModelClassName() {
		return PortTypeAnalyzerLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("portTypeAnalyzerLinkId", getPortTypeAnalyzerLinkId());
		attributes.put("companyId", getCompanyId());
		attributes.put("portTypeId", getPortTypeId());
		attributes.put("analyzerId", getAnalyzerId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long portTypeAnalyzerLinkId = (Long)attributes.get(
				"portTypeAnalyzerLinkId");

		if (portTypeAnalyzerLinkId != null) {
			setPortTypeAnalyzerLinkId(portTypeAnalyzerLinkId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long portTypeId = (Long)attributes.get("portTypeId");

		if (portTypeId != null) {
			setPortTypeId(portTypeId);
		}

		Long analyzerId = (Long)attributes.get("analyzerId");

		if (analyzerId != null) {
			setAnalyzerId(analyzerId);
		}
	}

	/**
	* Returns the primary key of this port type analyzer link.
	*
	* @return the primary key of this port type analyzer link
	*/
	@Override
	public long getPrimaryKey() {
		return _portTypeAnalyzerLink.getPrimaryKey();
	}

	/**
	* Sets the primary key of this port type analyzer link.
	*
	* @param primaryKey the primary key of this port type analyzer link
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_portTypeAnalyzerLink.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this port type analyzer link.
	*
	* @return the uuid of this port type analyzer link
	*/
	@Override
	public java.lang.String getUuid() {
		return _portTypeAnalyzerLink.getUuid();
	}

	/**
	* Sets the uuid of this port type analyzer link.
	*
	* @param uuid the uuid of this port type analyzer link
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_portTypeAnalyzerLink.setUuid(uuid);
	}

	/**
	* Returns the port type analyzer link ID of this port type analyzer link.
	*
	* @return the port type analyzer link ID of this port type analyzer link
	*/
	@Override
	public long getPortTypeAnalyzerLinkId() {
		return _portTypeAnalyzerLink.getPortTypeAnalyzerLinkId();
	}

	/**
	* Sets the port type analyzer link ID of this port type analyzer link.
	*
	* @param portTypeAnalyzerLinkId the port type analyzer link ID of this port type analyzer link
	*/
	@Override
	public void setPortTypeAnalyzerLinkId(long portTypeAnalyzerLinkId) {
		_portTypeAnalyzerLink.setPortTypeAnalyzerLinkId(portTypeAnalyzerLinkId);
	}

	/**
	* Returns the company ID of this port type analyzer link.
	*
	* @return the company ID of this port type analyzer link
	*/
	@Override
	public long getCompanyId() {
		return _portTypeAnalyzerLink.getCompanyId();
	}

	/**
	* Sets the company ID of this port type analyzer link.
	*
	* @param companyId the company ID of this port type analyzer link
	*/
	@Override
	public void setCompanyId(long companyId) {
		_portTypeAnalyzerLink.setCompanyId(companyId);
	}

	/**
	* Returns the port type ID of this port type analyzer link.
	*
	* @return the port type ID of this port type analyzer link
	*/
	@Override
	public long getPortTypeId() {
		return _portTypeAnalyzerLink.getPortTypeId();
	}

	/**
	* Sets the port type ID of this port type analyzer link.
	*
	* @param portTypeId the port type ID of this port type analyzer link
	*/
	@Override
	public void setPortTypeId(long portTypeId) {
		_portTypeAnalyzerLink.setPortTypeId(portTypeId);
	}

	/**
	* Returns the analyzer ID of this port type analyzer link.
	*
	* @return the analyzer ID of this port type analyzer link
	*/
	@Override
	public long getAnalyzerId() {
		return _portTypeAnalyzerLink.getAnalyzerId();
	}

	/**
	* Sets the analyzer ID of this port type analyzer link.
	*
	* @param analyzerId the analyzer ID of this port type analyzer link
	*/
	@Override
	public void setAnalyzerId(long analyzerId) {
		_portTypeAnalyzerLink.setAnalyzerId(analyzerId);
	}

	@Override
	public boolean isNew() {
		return _portTypeAnalyzerLink.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_portTypeAnalyzerLink.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _portTypeAnalyzerLink.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_portTypeAnalyzerLink.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _portTypeAnalyzerLink.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _portTypeAnalyzerLink.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_portTypeAnalyzerLink.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _portTypeAnalyzerLink.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_portTypeAnalyzerLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_portTypeAnalyzerLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_portTypeAnalyzerLink.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PortTypeAnalyzerLinkWrapper((PortTypeAnalyzerLink)_portTypeAnalyzerLink.clone());
	}

	@Override
	public int compareTo(
		com.kisti.science.platform.app.model.PortTypeAnalyzerLink portTypeAnalyzerLink) {
		return _portTypeAnalyzerLink.compareTo(portTypeAnalyzerLink);
	}

	@Override
	public int hashCode() {
		return _portTypeAnalyzerLink.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> toCacheModel() {
		return _portTypeAnalyzerLink.toCacheModel();
	}

	@Override
	public com.kisti.science.platform.app.model.PortTypeAnalyzerLink toEscapedModel() {
		return new PortTypeAnalyzerLinkWrapper(_portTypeAnalyzerLink.toEscapedModel());
	}

	@Override
	public com.kisti.science.platform.app.model.PortTypeAnalyzerLink toUnescapedModel() {
		return new PortTypeAnalyzerLinkWrapper(_portTypeAnalyzerLink.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _portTypeAnalyzerLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _portTypeAnalyzerLink.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_portTypeAnalyzerLink.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortTypeAnalyzerLinkWrapper)) {
			return false;
		}

		PortTypeAnalyzerLinkWrapper portTypeAnalyzerLinkWrapper = (PortTypeAnalyzerLinkWrapper)obj;

		if (Validator.equals(_portTypeAnalyzerLink,
					portTypeAnalyzerLinkWrapper._portTypeAnalyzerLink)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PortTypeAnalyzerLink getWrappedPortTypeAnalyzerLink() {
		return _portTypeAnalyzerLink;
	}

	@Override
	public PortTypeAnalyzerLink getWrappedModel() {
		return _portTypeAnalyzerLink;
	}

	@Override
	public void resetOriginalValues() {
		_portTypeAnalyzerLink.resetOriginalValues();
	}

	private PortTypeAnalyzerLink _portTypeAnalyzerLink;
}