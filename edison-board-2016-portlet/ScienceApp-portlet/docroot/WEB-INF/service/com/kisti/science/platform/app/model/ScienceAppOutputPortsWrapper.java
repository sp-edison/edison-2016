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
 * This class is a wrapper for {@link ScienceAppOutputPorts}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppOutputPorts
 * @generated
 */
public class ScienceAppOutputPortsWrapper implements ScienceAppOutputPorts,
	ModelWrapper<ScienceAppOutputPorts> {
	public ScienceAppOutputPortsWrapper(
		ScienceAppOutputPorts scienceAppOutputPorts) {
		_scienceAppOutputPorts = scienceAppOutputPorts;
	}

	@Override
	public Class<?> getModelClass() {
		return ScienceAppOutputPorts.class;
	}

	@Override
	public String getModelClassName() {
		return ScienceAppOutputPorts.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("outputPorts", getOutputPorts());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		String outputPorts = (String)attributes.get("outputPorts");

		if (outputPorts != null) {
			setOutputPorts(outputPorts);
		}
	}

	/**
	* Returns the primary key of this science app output ports.
	*
	* @return the primary key of this science app output ports
	*/
	@Override
	public long getPrimaryKey() {
		return _scienceAppOutputPorts.getPrimaryKey();
	}

	/**
	* Sets the primary key of this science app output ports.
	*
	* @param primaryKey the primary key of this science app output ports
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_scienceAppOutputPorts.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the science app ID of this science app output ports.
	*
	* @return the science app ID of this science app output ports
	*/
	@Override
	public long getScienceAppId() {
		return _scienceAppOutputPorts.getScienceAppId();
	}

	/**
	* Sets the science app ID of this science app output ports.
	*
	* @param scienceAppId the science app ID of this science app output ports
	*/
	@Override
	public void setScienceAppId(long scienceAppId) {
		_scienceAppOutputPorts.setScienceAppId(scienceAppId);
	}

	/**
	* Returns the output ports of this science app output ports.
	*
	* @return the output ports of this science app output ports
	*/
	@Override
	public java.lang.String getOutputPorts() {
		return _scienceAppOutputPorts.getOutputPorts();
	}

	/**
	* Sets the output ports of this science app output ports.
	*
	* @param outputPorts the output ports of this science app output ports
	*/
	@Override
	public void setOutputPorts(java.lang.String outputPorts) {
		_scienceAppOutputPorts.setOutputPorts(outputPorts);
	}

	@Override
	public boolean isNew() {
		return _scienceAppOutputPorts.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_scienceAppOutputPorts.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _scienceAppOutputPorts.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_scienceAppOutputPorts.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _scienceAppOutputPorts.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _scienceAppOutputPorts.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_scienceAppOutputPorts.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _scienceAppOutputPorts.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_scienceAppOutputPorts.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_scienceAppOutputPorts.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_scienceAppOutputPorts.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ScienceAppOutputPortsWrapper((ScienceAppOutputPorts)_scienceAppOutputPorts.clone());
	}

	@Override
	public int compareTo(
		com.kisti.science.platform.app.model.ScienceAppOutputPorts scienceAppOutputPorts) {
		return _scienceAppOutputPorts.compareTo(scienceAppOutputPorts);
	}

	@Override
	public int hashCode() {
		return _scienceAppOutputPorts.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kisti.science.platform.app.model.ScienceAppOutputPorts> toCacheModel() {
		return _scienceAppOutputPorts.toCacheModel();
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts toEscapedModel() {
		return new ScienceAppOutputPortsWrapper(_scienceAppOutputPorts.toEscapedModel());
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts toUnescapedModel() {
		return new ScienceAppOutputPortsWrapper(_scienceAppOutputPorts.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _scienceAppOutputPorts.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _scienceAppOutputPorts.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppOutputPorts.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScienceAppOutputPortsWrapper)) {
			return false;
		}

		ScienceAppOutputPortsWrapper scienceAppOutputPortsWrapper = (ScienceAppOutputPortsWrapper)obj;

		if (Validator.equals(_scienceAppOutputPorts,
					scienceAppOutputPortsWrapper._scienceAppOutputPorts)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ScienceAppOutputPorts getWrappedScienceAppOutputPorts() {
		return _scienceAppOutputPorts;
	}

	@Override
	public ScienceAppOutputPorts getWrappedModel() {
		return _scienceAppOutputPorts;
	}

	@Override
	public void resetOriginalValues() {
		_scienceAppOutputPorts.resetOriginalValues();
	}

	private ScienceAppOutputPorts _scienceAppOutputPorts;
}