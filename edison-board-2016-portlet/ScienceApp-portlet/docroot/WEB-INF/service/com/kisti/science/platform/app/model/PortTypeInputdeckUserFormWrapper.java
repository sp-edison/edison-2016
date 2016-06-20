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
 * This class is a wrapper for {@link PortTypeInputdeckUserForm}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeInputdeckUserForm
 * @generated
 */
public class PortTypeInputdeckUserFormWrapper
	implements PortTypeInputdeckUserForm,
		ModelWrapper<PortTypeInputdeckUserForm> {
	public PortTypeInputdeckUserFormWrapper(
		PortTypeInputdeckUserForm portTypeInputdeckUserForm) {
		_portTypeInputdeckUserForm = portTypeInputdeckUserForm;
	}

	@Override
	public Class<?> getModelClass() {
		return PortTypeInputdeckUserForm.class;
	}

	@Override
	public String getModelClassName() {
		return PortTypeInputdeckUserForm.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("inputdeckId", getInputdeckId());
		attributes.put("portTypeId", getPortTypeId());
		attributes.put("inputdeckUserForm", getInputdeckUserForm());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long inputdeckId = (Long)attributes.get("inputdeckId");

		if (inputdeckId != null) {
			setInputdeckId(inputdeckId);
		}

		Long portTypeId = (Long)attributes.get("portTypeId");

		if (portTypeId != null) {
			setPortTypeId(portTypeId);
		}

		String inputdeckUserForm = (String)attributes.get("inputdeckUserForm");

		if (inputdeckUserForm != null) {
			setInputdeckUserForm(inputdeckUserForm);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}
	}

	/**
	* Returns the primary key of this port type inputdeck user form.
	*
	* @return the primary key of this port type inputdeck user form
	*/
	@Override
	public long getPrimaryKey() {
		return _portTypeInputdeckUserForm.getPrimaryKey();
	}

	/**
	* Sets the primary key of this port type inputdeck user form.
	*
	* @param primaryKey the primary key of this port type inputdeck user form
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_portTypeInputdeckUserForm.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the inputdeck ID of this port type inputdeck user form.
	*
	* @return the inputdeck ID of this port type inputdeck user form
	*/
	@Override
	public long getInputdeckId() {
		return _portTypeInputdeckUserForm.getInputdeckId();
	}

	/**
	* Sets the inputdeck ID of this port type inputdeck user form.
	*
	* @param inputdeckId the inputdeck ID of this port type inputdeck user form
	*/
	@Override
	public void setInputdeckId(long inputdeckId) {
		_portTypeInputdeckUserForm.setInputdeckId(inputdeckId);
	}

	/**
	* Returns the port type ID of this port type inputdeck user form.
	*
	* @return the port type ID of this port type inputdeck user form
	*/
	@Override
	public long getPortTypeId() {
		return _portTypeInputdeckUserForm.getPortTypeId();
	}

	/**
	* Sets the port type ID of this port type inputdeck user form.
	*
	* @param portTypeId the port type ID of this port type inputdeck user form
	*/
	@Override
	public void setPortTypeId(long portTypeId) {
		_portTypeInputdeckUserForm.setPortTypeId(portTypeId);
	}

	/**
	* Returns the inputdeck user form of this port type inputdeck user form.
	*
	* @return the inputdeck user form of this port type inputdeck user form
	*/
	@Override
	public java.lang.String getInputdeckUserForm() {
		return _portTypeInputdeckUserForm.getInputdeckUserForm();
	}

	/**
	* Sets the inputdeck user form of this port type inputdeck user form.
	*
	* @param inputdeckUserForm the inputdeck user form of this port type inputdeck user form
	*/
	@Override
	public void setInputdeckUserForm(java.lang.String inputdeckUserForm) {
		_portTypeInputdeckUserForm.setInputdeckUserForm(inputdeckUserForm);
	}

	/**
	* Returns the user ID of this port type inputdeck user form.
	*
	* @return the user ID of this port type inputdeck user form
	*/
	@Override
	public long getUserId() {
		return _portTypeInputdeckUserForm.getUserId();
	}

	/**
	* Sets the user ID of this port type inputdeck user form.
	*
	* @param userId the user ID of this port type inputdeck user form
	*/
	@Override
	public void setUserId(long userId) {
		_portTypeInputdeckUserForm.setUserId(userId);
	}

	/**
	* Returns the user uuid of this port type inputdeck user form.
	*
	* @return the user uuid of this port type inputdeck user form
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserForm.getUserUuid();
	}

	/**
	* Sets the user uuid of this port type inputdeck user form.
	*
	* @param userUuid the user uuid of this port type inputdeck user form
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_portTypeInputdeckUserForm.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this port type inputdeck user form.
	*
	* @return the user name of this port type inputdeck user form
	*/
	@Override
	public java.lang.String getUserName() {
		return _portTypeInputdeckUserForm.getUserName();
	}

	/**
	* Sets the user name of this port type inputdeck user form.
	*
	* @param userName the user name of this port type inputdeck user form
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_portTypeInputdeckUserForm.setUserName(userName);
	}

	@Override
	public boolean isNew() {
		return _portTypeInputdeckUserForm.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_portTypeInputdeckUserForm.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _portTypeInputdeckUserForm.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_portTypeInputdeckUserForm.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _portTypeInputdeckUserForm.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _portTypeInputdeckUserForm.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_portTypeInputdeckUserForm.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _portTypeInputdeckUserForm.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_portTypeInputdeckUserForm.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_portTypeInputdeckUserForm.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_portTypeInputdeckUserForm.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PortTypeInputdeckUserFormWrapper((PortTypeInputdeckUserForm)_portTypeInputdeckUserForm.clone());
	}

	@Override
	public int compareTo(
		com.kisti.science.platform.app.model.PortTypeInputdeckUserForm portTypeInputdeckUserForm) {
		return _portTypeInputdeckUserForm.compareTo(portTypeInputdeckUserForm);
	}

	@Override
	public int hashCode() {
		return _portTypeInputdeckUserForm.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kisti.science.platform.app.model.PortTypeInputdeckUserForm> toCacheModel() {
		return _portTypeInputdeckUserForm.toCacheModel();
	}

	@Override
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm toEscapedModel() {
		return new PortTypeInputdeckUserFormWrapper(_portTypeInputdeckUserForm.toEscapedModel());
	}

	@Override
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm toUnescapedModel() {
		return new PortTypeInputdeckUserFormWrapper(_portTypeInputdeckUserForm.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _portTypeInputdeckUserForm.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _portTypeInputdeckUserForm.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_portTypeInputdeckUserForm.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PortTypeInputdeckUserFormWrapper)) {
			return false;
		}

		PortTypeInputdeckUserFormWrapper portTypeInputdeckUserFormWrapper = (PortTypeInputdeckUserFormWrapper)obj;

		if (Validator.equals(_portTypeInputdeckUserForm,
					portTypeInputdeckUserFormWrapper._portTypeInputdeckUserForm)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PortTypeInputdeckUserForm getWrappedPortTypeInputdeckUserForm() {
		return _portTypeInputdeckUserForm;
	}

	@Override
	public PortTypeInputdeckUserForm getWrappedModel() {
		return _portTypeInputdeckUserForm;
	}

	@Override
	public void resetOriginalValues() {
		_portTypeInputdeckUserForm.resetOriginalValues();
	}

	private PortTypeInputdeckUserForm _portTypeInputdeckUserForm;
}