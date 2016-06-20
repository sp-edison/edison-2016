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
 * This class is a wrapper for {@link PortTypeInputdeckForm}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeInputdeckForm
 * @generated
 */
public class PortTypeInputdeckFormWrapper implements PortTypeInputdeckForm,
	ModelWrapper<PortTypeInputdeckForm> {
	public PortTypeInputdeckFormWrapper(
		PortTypeInputdeckForm portTypeInputdeckForm) {
		_portTypeInputdeckForm = portTypeInputdeckForm;
	}

	@Override
	public Class<?> getModelClass() {
		return PortTypeInputdeckForm.class;
	}

	@Override
	public String getModelClassName() {
		return PortTypeInputdeckForm.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("portTypeId", getPortTypeId());
		attributes.put("inputdeckForm", getInputdeckForm());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long portTypeId = (Long)attributes.get("portTypeId");

		if (portTypeId != null) {
			setPortTypeId(portTypeId);
		}

		String inputdeckForm = (String)attributes.get("inputdeckForm");

		if (inputdeckForm != null) {
			setInputdeckForm(inputdeckForm);
		}
	}

	/**
	* Returns the primary key of this port type inputdeck form.
	*
	* @return the primary key of this port type inputdeck form
	*/
	@Override
	public long getPrimaryKey() {
		return _portTypeInputdeckForm.getPrimaryKey();
	}

	/**
	* Sets the primary key of this port type inputdeck form.
	*
	* @param primaryKey the primary key of this port type inputdeck form
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_portTypeInputdeckForm.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the port type ID of this port type inputdeck form.
	*
	* @return the port type ID of this port type inputdeck form
	*/
	@Override
	public long getPortTypeId() {
		return _portTypeInputdeckForm.getPortTypeId();
	}

	/**
	* Sets the port type ID of this port type inputdeck form.
	*
	* @param portTypeId the port type ID of this port type inputdeck form
	*/
	@Override
	public void setPortTypeId(long portTypeId) {
		_portTypeInputdeckForm.setPortTypeId(portTypeId);
	}

	/**
	* Returns the inputdeck form of this port type inputdeck form.
	*
	* @return the inputdeck form of this port type inputdeck form
	*/
	@Override
	public java.lang.String getInputdeckForm() {
		return _portTypeInputdeckForm.getInputdeckForm();
	}

	/**
	* Sets the inputdeck form of this port type inputdeck form.
	*
	* @param inputdeckForm the inputdeck form of this port type inputdeck form
	*/
	@Override
	public void setInputdeckForm(java.lang.String inputdeckForm) {
		_portTypeInputdeckForm.setInputdeckForm(inputdeckForm);
	}

	@Override
	public boolean isNew() {
		return _portTypeInputdeckForm.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_portTypeInputdeckForm.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _portTypeInputdeckForm.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_portTypeInputdeckForm.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _portTypeInputdeckForm.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _portTypeInputdeckForm.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_portTypeInputdeckForm.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _portTypeInputdeckForm.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_portTypeInputdeckForm.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_portTypeInputdeckForm.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_portTypeInputdeckForm.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PortTypeInputdeckFormWrapper((PortTypeInputdeckForm)_portTypeInputdeckForm.clone());
	}

	@Override
	public int compareTo(
		com.kisti.science.platform.app.model.PortTypeInputdeckForm portTypeInputdeckForm) {
		return _portTypeInputdeckForm.compareTo(portTypeInputdeckForm);
	}

	@Override
	public int hashCode() {
		return _portTypeInputdeckForm.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kisti.science.platform.app.model.PortTypeInputdeckForm> toCacheModel() {
		return _portTypeInputdeckForm.toCacheModel();
	}

	@Override
	public com.kisti.science.platform.app.model.PortTypeInputdeckForm toEscapedModel() {
		return new PortTypeInputdeckFormWrapper(_portTypeInputdeckForm.toEscapedModel());
	}

	@Override
	public com.kisti.science.platform.app.model.PortTypeInputdeckForm toUnescapedModel() {
		return new PortTypeInputdeckFormWrapper(_portTypeInputdeckForm.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _portTypeInputdeckForm.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _portTypeInputdeckForm.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_portTypeInputdeckForm.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortTypeInputdeckFormWrapper)) {
			return false;
		}

		PortTypeInputdeckFormWrapper portTypeInputdeckFormWrapper = (PortTypeInputdeckFormWrapper)obj;

		if (Validator.equals(_portTypeInputdeckForm,
					portTypeInputdeckFormWrapper._portTypeInputdeckForm)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PortTypeInputdeckForm getWrappedPortTypeInputdeckForm() {
		return _portTypeInputdeckForm;
	}

	@Override
	public PortTypeInputdeckForm getWrappedModel() {
		return _portTypeInputdeckForm;
	}

	@Override
	public void resetOriginalValues() {
		_portTypeInputdeckForm.resetOriginalValues();
	}

	private PortTypeInputdeckForm _portTypeInputdeckForm;
}