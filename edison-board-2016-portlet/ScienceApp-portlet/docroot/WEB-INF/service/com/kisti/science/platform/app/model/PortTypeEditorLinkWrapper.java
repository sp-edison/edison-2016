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
 * This class is a wrapper for {@link PortTypeEditorLink}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeEditorLink
 * @generated
 */
public class PortTypeEditorLinkWrapper implements PortTypeEditorLink,
	ModelWrapper<PortTypeEditorLink> {
	public PortTypeEditorLinkWrapper(PortTypeEditorLink portTypeEditorLink) {
		_portTypeEditorLink = portTypeEditorLink;
	}

	@Override
	public Class<?> getModelClass() {
		return PortTypeEditorLink.class;
	}

	@Override
	public String getModelClassName() {
		return PortTypeEditorLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("portTypeEditorLinkId", getPortTypeEditorLinkId());
		attributes.put("companyId", getCompanyId());
		attributes.put("portTypeId", getPortTypeId());
		attributes.put("editorId", getEditorId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long portTypeEditorLinkId = (Long)attributes.get("portTypeEditorLinkId");

		if (portTypeEditorLinkId != null) {
			setPortTypeEditorLinkId(portTypeEditorLinkId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long portTypeId = (Long)attributes.get("portTypeId");

		if (portTypeId != null) {
			setPortTypeId(portTypeId);
		}

		Long editorId = (Long)attributes.get("editorId");

		if (editorId != null) {
			setEditorId(editorId);
		}
	}

	/**
	* Returns the primary key of this port type editor link.
	*
	* @return the primary key of this port type editor link
	*/
	@Override
	public long getPrimaryKey() {
		return _portTypeEditorLink.getPrimaryKey();
	}

	/**
	* Sets the primary key of this port type editor link.
	*
	* @param primaryKey the primary key of this port type editor link
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_portTypeEditorLink.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this port type editor link.
	*
	* @return the uuid of this port type editor link
	*/
	@Override
	public java.lang.String getUuid() {
		return _portTypeEditorLink.getUuid();
	}

	/**
	* Sets the uuid of this port type editor link.
	*
	* @param uuid the uuid of this port type editor link
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_portTypeEditorLink.setUuid(uuid);
	}

	/**
	* Returns the port type editor link ID of this port type editor link.
	*
	* @return the port type editor link ID of this port type editor link
	*/
	@Override
	public long getPortTypeEditorLinkId() {
		return _portTypeEditorLink.getPortTypeEditorLinkId();
	}

	/**
	* Sets the port type editor link ID of this port type editor link.
	*
	* @param portTypeEditorLinkId the port type editor link ID of this port type editor link
	*/
	@Override
	public void setPortTypeEditorLinkId(long portTypeEditorLinkId) {
		_portTypeEditorLink.setPortTypeEditorLinkId(portTypeEditorLinkId);
	}

	/**
	* Returns the company ID of this port type editor link.
	*
	* @return the company ID of this port type editor link
	*/
	@Override
	public long getCompanyId() {
		return _portTypeEditorLink.getCompanyId();
	}

	/**
	* Sets the company ID of this port type editor link.
	*
	* @param companyId the company ID of this port type editor link
	*/
	@Override
	public void setCompanyId(long companyId) {
		_portTypeEditorLink.setCompanyId(companyId);
	}

	/**
	* Returns the port type ID of this port type editor link.
	*
	* @return the port type ID of this port type editor link
	*/
	@Override
	public long getPortTypeId() {
		return _portTypeEditorLink.getPortTypeId();
	}

	/**
	* Sets the port type ID of this port type editor link.
	*
	* @param portTypeId the port type ID of this port type editor link
	*/
	@Override
	public void setPortTypeId(long portTypeId) {
		_portTypeEditorLink.setPortTypeId(portTypeId);
	}

	/**
	* Returns the editor ID of this port type editor link.
	*
	* @return the editor ID of this port type editor link
	*/
	@Override
	public long getEditorId() {
		return _portTypeEditorLink.getEditorId();
	}

	/**
	* Sets the editor ID of this port type editor link.
	*
	* @param editorId the editor ID of this port type editor link
	*/
	@Override
	public void setEditorId(long editorId) {
		_portTypeEditorLink.setEditorId(editorId);
	}

	@Override
	public boolean isNew() {
		return _portTypeEditorLink.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_portTypeEditorLink.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _portTypeEditorLink.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_portTypeEditorLink.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _portTypeEditorLink.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _portTypeEditorLink.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_portTypeEditorLink.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _portTypeEditorLink.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_portTypeEditorLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_portTypeEditorLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_portTypeEditorLink.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PortTypeEditorLinkWrapper((PortTypeEditorLink)_portTypeEditorLink.clone());
	}

	@Override
	public int compareTo(
		com.kisti.science.platform.app.model.PortTypeEditorLink portTypeEditorLink) {
		return _portTypeEditorLink.compareTo(portTypeEditorLink);
	}

	@Override
	public int hashCode() {
		return _portTypeEditorLink.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kisti.science.platform.app.model.PortTypeEditorLink> toCacheModel() {
		return _portTypeEditorLink.toCacheModel();
	}

	@Override
	public com.kisti.science.platform.app.model.PortTypeEditorLink toEscapedModel() {
		return new PortTypeEditorLinkWrapper(_portTypeEditorLink.toEscapedModel());
	}

	@Override
	public com.kisti.science.platform.app.model.PortTypeEditorLink toUnescapedModel() {
		return new PortTypeEditorLinkWrapper(_portTypeEditorLink.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _portTypeEditorLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _portTypeEditorLink.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_portTypeEditorLink.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortTypeEditorLinkWrapper)) {
			return false;
		}

		PortTypeEditorLinkWrapper portTypeEditorLinkWrapper = (PortTypeEditorLinkWrapper)obj;

		if (Validator.equals(_portTypeEditorLink,
					portTypeEditorLinkWrapper._portTypeEditorLink)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PortTypeEditorLink getWrappedPortTypeEditorLink() {
		return _portTypeEditorLink;
	}

	@Override
	public PortTypeEditorLink getWrappedModel() {
		return _portTypeEditorLink;
	}

	@Override
	public void resetOriginalValues() {
		_portTypeEditorLink.resetOriginalValues();
	}

	private PortTypeEditorLink _portTypeEditorLink;
}