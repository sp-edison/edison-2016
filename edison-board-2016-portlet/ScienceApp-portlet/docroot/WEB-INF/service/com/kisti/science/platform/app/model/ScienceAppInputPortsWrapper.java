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
 * This class is a wrapper for {@link ScienceAppInputPorts}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppInputPorts
 * @generated
 */
public class ScienceAppInputPortsWrapper implements ScienceAppInputPorts,
	ModelWrapper<ScienceAppInputPorts> {
	public ScienceAppInputPortsWrapper(
		ScienceAppInputPorts scienceAppInputPorts) {
		_scienceAppInputPorts = scienceAppInputPorts;
	}

	@Override
	public Class<?> getModelClass() {
		return ScienceAppInputPorts.class;
	}

	@Override
	public String getModelClassName() {
		return ScienceAppInputPorts.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("inputPorts", getInputPorts());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		String inputPorts = (String)attributes.get("inputPorts");

		if (inputPorts != null) {
			setInputPorts(inputPorts);
		}
	}

	/**
	* Returns the primary key of this science app input ports.
	*
	* @return the primary key of this science app input ports
	*/
	@Override
	public long getPrimaryKey() {
		return _scienceAppInputPorts.getPrimaryKey();
	}

	/**
	* Sets the primary key of this science app input ports.
	*
	* @param primaryKey the primary key of this science app input ports
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_scienceAppInputPorts.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the science app ID of this science app input ports.
	*
	* @return the science app ID of this science app input ports
	*/
	@Override
	public long getScienceAppId() {
		return _scienceAppInputPorts.getScienceAppId();
	}

	/**
	* Sets the science app ID of this science app input ports.
	*
	* @param scienceAppId the science app ID of this science app input ports
	*/
	@Override
	public void setScienceAppId(long scienceAppId) {
		_scienceAppInputPorts.setScienceAppId(scienceAppId);
	}

	/**
	* Returns the input ports of this science app input ports.
	*
	* @return the input ports of this science app input ports
	*/
	@Override
	public java.lang.String getInputPorts() {
		return _scienceAppInputPorts.getInputPorts();
	}

	/**
	* Sets the input ports of this science app input ports.
	*
	* @param inputPorts the input ports of this science app input ports
	*/
	@Override
	public void setInputPorts(java.lang.String inputPorts) {
		_scienceAppInputPorts.setInputPorts(inputPorts);
	}

	@Override
	public boolean isNew() {
		return _scienceAppInputPorts.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_scienceAppInputPorts.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _scienceAppInputPorts.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_scienceAppInputPorts.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _scienceAppInputPorts.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _scienceAppInputPorts.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_scienceAppInputPorts.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _scienceAppInputPorts.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_scienceAppInputPorts.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_scienceAppInputPorts.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_scienceAppInputPorts.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ScienceAppInputPortsWrapper((ScienceAppInputPorts)_scienceAppInputPorts.clone());
	}

	@Override
	public int compareTo(
		com.kisti.science.platform.app.model.ScienceAppInputPorts scienceAppInputPorts) {
		return _scienceAppInputPorts.compareTo(scienceAppInputPorts);
	}

	@Override
	public int hashCode() {
		return _scienceAppInputPorts.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kisti.science.platform.app.model.ScienceAppInputPorts> toCacheModel() {
		return _scienceAppInputPorts.toCacheModel();
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceAppInputPorts toEscapedModel() {
		return new ScienceAppInputPortsWrapper(_scienceAppInputPorts.toEscapedModel());
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceAppInputPorts toUnescapedModel() {
		return new ScienceAppInputPortsWrapper(_scienceAppInputPorts.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _scienceAppInputPorts.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _scienceAppInputPorts.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppInputPorts.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScienceAppInputPortsWrapper)) {
			return false;
		}

		ScienceAppInputPortsWrapper scienceAppInputPortsWrapper = (ScienceAppInputPortsWrapper)obj;

		if (Validator.equals(_scienceAppInputPorts,
					scienceAppInputPortsWrapper._scienceAppInputPorts)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ScienceAppInputPorts getWrappedScienceAppInputPorts() {
		return _scienceAppInputPorts;
	}

	@Override
	public ScienceAppInputPorts getWrappedModel() {
		return _scienceAppInputPorts;
	}

	@Override
	public void resetOriginalValues() {
		_scienceAppInputPorts.resetOriginalValues();
	}

	private ScienceAppInputPorts _scienceAppInputPorts;
}