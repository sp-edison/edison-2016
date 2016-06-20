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
 * This class is a wrapper for {@link RequiredLibConfirm}.
 * </p>
 *
 * @author EDISON
 * @see RequiredLibConfirm
 * @generated
 */
public class RequiredLibConfirmWrapper implements RequiredLibConfirm,
	ModelWrapper<RequiredLibConfirm> {
	public RequiredLibConfirmWrapper(RequiredLibConfirm requiredLibConfirm) {
		_requiredLibConfirm = requiredLibConfirm;
	}

	@Override
	public Class<?> getModelClass() {
		return RequiredLibConfirm.class;
	}

	@Override
	public String getModelClassName() {
		return RequiredLibConfirm.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("requiredLibId", getRequiredLibId());
		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("requiredDate", getRequiredDate());
		attributes.put("confirmDate", getConfirmDate());
		attributes.put("libraryName", getLibraryName());
		attributes.put("libraryVersion", getLibraryVersion());
		attributes.put("requiredContent", getRequiredContent());
		attributes.put("requiredState", getRequiredState());
		attributes.put("confirmContent", getConfirmContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long requiredLibId = (Long)attributes.get("requiredLibId");

		if (requiredLibId != null) {
			setRequiredLibId(requiredLibId);
		}

		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date requiredDate = (Date)attributes.get("requiredDate");

		if (requiredDate != null) {
			setRequiredDate(requiredDate);
		}

		Date confirmDate = (Date)attributes.get("confirmDate");

		if (confirmDate != null) {
			setConfirmDate(confirmDate);
		}

		String libraryName = (String)attributes.get("libraryName");

		if (libraryName != null) {
			setLibraryName(libraryName);
		}

		String libraryVersion = (String)attributes.get("libraryVersion");

		if (libraryVersion != null) {
			setLibraryVersion(libraryVersion);
		}

		String requiredContent = (String)attributes.get("requiredContent");

		if (requiredContent != null) {
			setRequiredContent(requiredContent);
		}

		String requiredState = (String)attributes.get("requiredState");

		if (requiredState != null) {
			setRequiredState(requiredState);
		}

		String confirmContent = (String)attributes.get("confirmContent");

		if (confirmContent != null) {
			setConfirmContent(confirmContent);
		}
	}

	/**
	* Returns the primary key of this required lib confirm.
	*
	* @return the primary key of this required lib confirm
	*/
	@Override
	public org.kisti.edison.science.service.persistence.RequiredLibConfirmPK getPrimaryKey() {
		return _requiredLibConfirm.getPrimaryKey();
	}

	/**
	* Sets the primary key of this required lib confirm.
	*
	* @param primaryKey the primary key of this required lib confirm
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.science.service.persistence.RequiredLibConfirmPK primaryKey) {
		_requiredLibConfirm.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the required lib ID of this required lib confirm.
	*
	* @return the required lib ID of this required lib confirm
	*/
	@Override
	public long getRequiredLibId() {
		return _requiredLibConfirm.getRequiredLibId();
	}

	/**
	* Sets the required lib ID of this required lib confirm.
	*
	* @param requiredLibId the required lib ID of this required lib confirm
	*/
	@Override
	public void setRequiredLibId(long requiredLibId) {
		_requiredLibConfirm.setRequiredLibId(requiredLibId);
	}

	/**
	* Returns the science app ID of this required lib confirm.
	*
	* @return the science app ID of this required lib confirm
	*/
	@Override
	public long getScienceAppId() {
		return _requiredLibConfirm.getScienceAppId();
	}

	/**
	* Sets the science app ID of this required lib confirm.
	*
	* @param scienceAppId the science app ID of this required lib confirm
	*/
	@Override
	public void setScienceAppId(long scienceAppId) {
		_requiredLibConfirm.setScienceAppId(scienceAppId);
	}

	/**
	* Returns the company ID of this required lib confirm.
	*
	* @return the company ID of this required lib confirm
	*/
	@Override
	public long getCompanyId() {
		return _requiredLibConfirm.getCompanyId();
	}

	/**
	* Sets the company ID of this required lib confirm.
	*
	* @param companyId the company ID of this required lib confirm
	*/
	@Override
	public void setCompanyId(long companyId) {
		_requiredLibConfirm.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this required lib confirm.
	*
	* @return the user ID of this required lib confirm
	*/
	@Override
	public long getUserId() {
		return _requiredLibConfirm.getUserId();
	}

	/**
	* Sets the user ID of this required lib confirm.
	*
	* @param userId the user ID of this required lib confirm
	*/
	@Override
	public void setUserId(long userId) {
		_requiredLibConfirm.setUserId(userId);
	}

	/**
	* Returns the user uuid of this required lib confirm.
	*
	* @return the user uuid of this required lib confirm
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requiredLibConfirm.getUserUuid();
	}

	/**
	* Sets the user uuid of this required lib confirm.
	*
	* @param userUuid the user uuid of this required lib confirm
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_requiredLibConfirm.setUserUuid(userUuid);
	}

	/**
	* Returns the required date of this required lib confirm.
	*
	* @return the required date of this required lib confirm
	*/
	@Override
	public java.util.Date getRequiredDate() {
		return _requiredLibConfirm.getRequiredDate();
	}

	/**
	* Sets the required date of this required lib confirm.
	*
	* @param requiredDate the required date of this required lib confirm
	*/
	@Override
	public void setRequiredDate(java.util.Date requiredDate) {
		_requiredLibConfirm.setRequiredDate(requiredDate);
	}

	/**
	* Returns the confirm date of this required lib confirm.
	*
	* @return the confirm date of this required lib confirm
	*/
	@Override
	public java.util.Date getConfirmDate() {
		return _requiredLibConfirm.getConfirmDate();
	}

	/**
	* Sets the confirm date of this required lib confirm.
	*
	* @param confirmDate the confirm date of this required lib confirm
	*/
	@Override
	public void setConfirmDate(java.util.Date confirmDate) {
		_requiredLibConfirm.setConfirmDate(confirmDate);
	}

	/**
	* Returns the library name of this required lib confirm.
	*
	* @return the library name of this required lib confirm
	*/
	@Override
	public java.lang.String getLibraryName() {
		return _requiredLibConfirm.getLibraryName();
	}

	/**
	* Sets the library name of this required lib confirm.
	*
	* @param libraryName the library name of this required lib confirm
	*/
	@Override
	public void setLibraryName(java.lang.String libraryName) {
		_requiredLibConfirm.setLibraryName(libraryName);
	}

	/**
	* Returns the library version of this required lib confirm.
	*
	* @return the library version of this required lib confirm
	*/
	@Override
	public java.lang.String getLibraryVersion() {
		return _requiredLibConfirm.getLibraryVersion();
	}

	/**
	* Sets the library version of this required lib confirm.
	*
	* @param libraryVersion the library version of this required lib confirm
	*/
	@Override
	public void setLibraryVersion(java.lang.String libraryVersion) {
		_requiredLibConfirm.setLibraryVersion(libraryVersion);
	}

	/**
	* Returns the required content of this required lib confirm.
	*
	* @return the required content of this required lib confirm
	*/
	@Override
	public java.lang.String getRequiredContent() {
		return _requiredLibConfirm.getRequiredContent();
	}

	/**
	* Sets the required content of this required lib confirm.
	*
	* @param requiredContent the required content of this required lib confirm
	*/
	@Override
	public void setRequiredContent(java.lang.String requiredContent) {
		_requiredLibConfirm.setRequiredContent(requiredContent);
	}

	/**
	* Returns the required state of this required lib confirm.
	*
	* @return the required state of this required lib confirm
	*/
	@Override
	public java.lang.String getRequiredState() {
		return _requiredLibConfirm.getRequiredState();
	}

	/**
	* Sets the required state of this required lib confirm.
	*
	* @param requiredState the required state of this required lib confirm
	*/
	@Override
	public void setRequiredState(java.lang.String requiredState) {
		_requiredLibConfirm.setRequiredState(requiredState);
	}

	/**
	* Returns the confirm content of this required lib confirm.
	*
	* @return the confirm content of this required lib confirm
	*/
	@Override
	public java.lang.String getConfirmContent() {
		return _requiredLibConfirm.getConfirmContent();
	}

	/**
	* Sets the confirm content of this required lib confirm.
	*
	* @param confirmContent the confirm content of this required lib confirm
	*/
	@Override
	public void setConfirmContent(java.lang.String confirmContent) {
		_requiredLibConfirm.setConfirmContent(confirmContent);
	}

	@Override
	public boolean isNew() {
		return _requiredLibConfirm.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_requiredLibConfirm.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _requiredLibConfirm.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_requiredLibConfirm.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _requiredLibConfirm.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _requiredLibConfirm.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_requiredLibConfirm.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _requiredLibConfirm.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_requiredLibConfirm.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_requiredLibConfirm.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_requiredLibConfirm.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RequiredLibConfirmWrapper((RequiredLibConfirm)_requiredLibConfirm.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.science.model.RequiredLibConfirm requiredLibConfirm) {
		return _requiredLibConfirm.compareTo(requiredLibConfirm);
	}

	@Override
	public int hashCode() {
		return _requiredLibConfirm.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.science.model.RequiredLibConfirm> toCacheModel() {
		return _requiredLibConfirm.toCacheModel();
	}

	@Override
	public org.kisti.edison.science.model.RequiredLibConfirm toEscapedModel() {
		return new RequiredLibConfirmWrapper(_requiredLibConfirm.toEscapedModel());
	}

	@Override
	public org.kisti.edison.science.model.RequiredLibConfirm toUnescapedModel() {
		return new RequiredLibConfirmWrapper(_requiredLibConfirm.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _requiredLibConfirm.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _requiredLibConfirm.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_requiredLibConfirm.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RequiredLibConfirmWrapper)) {
			return false;
		}

		RequiredLibConfirmWrapper requiredLibConfirmWrapper = (RequiredLibConfirmWrapper)obj;

		if (Validator.equals(_requiredLibConfirm,
					requiredLibConfirmWrapper._requiredLibConfirm)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RequiredLibConfirm getWrappedRequiredLibConfirm() {
		return _requiredLibConfirm;
	}

	@Override
	public RequiredLibConfirm getWrappedModel() {
		return _requiredLibConfirm;
	}

	@Override
	public void resetOriginalValues() {
		_requiredLibConfirm.resetOriginalValues();
	}

	private RequiredLibConfirm _requiredLibConfirm;
}