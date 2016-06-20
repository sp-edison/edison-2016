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

package org.kisti.edison.virtuallaboratory.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VirtualLabClassScienceApp}.
 * </p>
 *
 * @author EDISON
 * @see VirtualLabClassScienceApp
 * @generated
 */
public class VirtualLabClassScienceAppWrapper
	implements VirtualLabClassScienceApp,
		ModelWrapper<VirtualLabClassScienceApp> {
	public VirtualLabClassScienceAppWrapper(
		VirtualLabClassScienceApp virtualLabClassScienceApp) {
		_virtualLabClassScienceApp = virtualLabClassScienceApp;
	}

	@Override
	public Class<?> getModelClass() {
		return VirtualLabClassScienceApp.class;
	}

	@Override
	public String getModelClassName() {
		return VirtualLabClassScienceApp.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scienceAppSeqNo", getScienceAppSeqNo());
		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scienceAppSeqNo = (Long)attributes.get("scienceAppSeqNo");

		if (scienceAppSeqNo != null) {
			setScienceAppSeqNo(scienceAppSeqNo);
		}

		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this virtual lab class science app.
	*
	* @return the primary key of this virtual lab class science app
	*/
	@Override
	public long getPrimaryKey() {
		return _virtualLabClassScienceApp.getPrimaryKey();
	}

	/**
	* Sets the primary key of this virtual lab class science app.
	*
	* @param primaryKey the primary key of this virtual lab class science app
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_virtualLabClassScienceApp.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the science app seq no of this virtual lab class science app.
	*
	* @return the science app seq no of this virtual lab class science app
	*/
	@Override
	public long getScienceAppSeqNo() {
		return _virtualLabClassScienceApp.getScienceAppSeqNo();
	}

	/**
	* Sets the science app seq no of this virtual lab class science app.
	*
	* @param scienceAppSeqNo the science app seq no of this virtual lab class science app
	*/
	@Override
	public void setScienceAppSeqNo(long scienceAppSeqNo) {
		_virtualLabClassScienceApp.setScienceAppSeqNo(scienceAppSeqNo);
	}

	/**
	* Returns the science app ID of this virtual lab class science app.
	*
	* @return the science app ID of this virtual lab class science app
	*/
	@Override
	public long getScienceAppId() {
		return _virtualLabClassScienceApp.getScienceAppId();
	}

	/**
	* Sets the science app ID of this virtual lab class science app.
	*
	* @param scienceAppId the science app ID of this virtual lab class science app
	*/
	@Override
	public void setScienceAppId(long scienceAppId) {
		_virtualLabClassScienceApp.setScienceAppId(scienceAppId);
	}

	/**
	* Returns the create date of this virtual lab class science app.
	*
	* @return the create date of this virtual lab class science app
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _virtualLabClassScienceApp.getCreateDate();
	}

	/**
	* Sets the create date of this virtual lab class science app.
	*
	* @param createDate the create date of this virtual lab class science app
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_virtualLabClassScienceApp.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _virtualLabClassScienceApp.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_virtualLabClassScienceApp.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _virtualLabClassScienceApp.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_virtualLabClassScienceApp.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _virtualLabClassScienceApp.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _virtualLabClassScienceApp.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_virtualLabClassScienceApp.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _virtualLabClassScienceApp.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_virtualLabClassScienceApp.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_virtualLabClassScienceApp.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_virtualLabClassScienceApp.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VirtualLabClassScienceAppWrapper((VirtualLabClassScienceApp)_virtualLabClassScienceApp.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp) {
		return _virtualLabClassScienceApp.compareTo(virtualLabClassScienceApp);
	}

	@Override
	public int hashCode() {
		return _virtualLabClassScienceApp.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> toCacheModel() {
		return _virtualLabClassScienceApp.toCacheModel();
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp toEscapedModel() {
		return new VirtualLabClassScienceAppWrapper(_virtualLabClassScienceApp.toEscapedModel());
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp toUnescapedModel() {
		return new VirtualLabClassScienceAppWrapper(_virtualLabClassScienceApp.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _virtualLabClassScienceApp.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _virtualLabClassScienceApp.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassScienceApp.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VirtualLabClassScienceAppWrapper)) {
			return false;
		}

		VirtualLabClassScienceAppWrapper virtualLabClassScienceAppWrapper = (VirtualLabClassScienceAppWrapper)obj;

		if (Validator.equals(_virtualLabClassScienceApp,
					virtualLabClassScienceAppWrapper._virtualLabClassScienceApp)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VirtualLabClassScienceApp getWrappedVirtualLabClassScienceApp() {
		return _virtualLabClassScienceApp;
	}

	@Override
	public VirtualLabClassScienceApp getWrappedModel() {
		return _virtualLabClassScienceApp;
	}

	@Override
	public void resetOriginalValues() {
		_virtualLabClassScienceApp.resetOriginalValues();
	}

	private VirtualLabClassScienceApp _virtualLabClassScienceApp;
}