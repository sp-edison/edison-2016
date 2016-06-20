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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ScienceAppCategoryLink}.
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppCategoryLink
 * @generated
 */
public class ScienceAppCategoryLinkWrapper implements ScienceAppCategoryLink,
	ModelWrapper<ScienceAppCategoryLink> {
	public ScienceAppCategoryLinkWrapper(
		ScienceAppCategoryLink scienceAppCategoryLink) {
		_scienceAppCategoryLink = scienceAppCategoryLink;
	}

	@Override
	public Class<?> getModelClass() {
		return ScienceAppCategoryLink.class;
	}

	@Override
	public String getModelClassName() {
		return ScienceAppCategoryLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("scienceAppCategoryLinkId", getScienceAppCategoryLinkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryId", getCategoryId());
		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("parentCategoryId", getParentCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long scienceAppCategoryLinkId = (Long)attributes.get(
				"scienceAppCategoryLinkId");

		if (scienceAppCategoryLinkId != null) {
			setScienceAppCategoryLinkId(scienceAppCategoryLinkId);
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

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		Long parentCategoryId = (Long)attributes.get("parentCategoryId");

		if (parentCategoryId != null) {
			setParentCategoryId(parentCategoryId);
		}
	}

	/**
	* Returns the primary key of this science app category link.
	*
	* @return the primary key of this science app category link
	*/
	@Override
	public long getPrimaryKey() {
		return _scienceAppCategoryLink.getPrimaryKey();
	}

	/**
	* Sets the primary key of this science app category link.
	*
	* @param primaryKey the primary key of this science app category link
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_scienceAppCategoryLink.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this science app category link.
	*
	* @return the uuid of this science app category link
	*/
	@Override
	public java.lang.String getUuid() {
		return _scienceAppCategoryLink.getUuid();
	}

	/**
	* Sets the uuid of this science app category link.
	*
	* @param uuid the uuid of this science app category link
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_scienceAppCategoryLink.setUuid(uuid);
	}

	/**
	* Returns the science app category link ID of this science app category link.
	*
	* @return the science app category link ID of this science app category link
	*/
	@Override
	public long getScienceAppCategoryLinkId() {
		return _scienceAppCategoryLink.getScienceAppCategoryLinkId();
	}

	/**
	* Sets the science app category link ID of this science app category link.
	*
	* @param scienceAppCategoryLinkId the science app category link ID of this science app category link
	*/
	@Override
	public void setScienceAppCategoryLinkId(long scienceAppCategoryLinkId) {
		_scienceAppCategoryLink.setScienceAppCategoryLinkId(scienceAppCategoryLinkId);
	}

	/**
	* Returns the group ID of this science app category link.
	*
	* @return the group ID of this science app category link
	*/
	@Override
	public long getGroupId() {
		return _scienceAppCategoryLink.getGroupId();
	}

	/**
	* Sets the group ID of this science app category link.
	*
	* @param groupId the group ID of this science app category link
	*/
	@Override
	public void setGroupId(long groupId) {
		_scienceAppCategoryLink.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this science app category link.
	*
	* @return the company ID of this science app category link
	*/
	@Override
	public long getCompanyId() {
		return _scienceAppCategoryLink.getCompanyId();
	}

	/**
	* Sets the company ID of this science app category link.
	*
	* @param companyId the company ID of this science app category link
	*/
	@Override
	public void setCompanyId(long companyId) {
		_scienceAppCategoryLink.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this science app category link.
	*
	* @return the user ID of this science app category link
	*/
	@Override
	public long getUserId() {
		return _scienceAppCategoryLink.getUserId();
	}

	/**
	* Sets the user ID of this science app category link.
	*
	* @param userId the user ID of this science app category link
	*/
	@Override
	public void setUserId(long userId) {
		_scienceAppCategoryLink.setUserId(userId);
	}

	/**
	* Returns the user uuid of this science app category link.
	*
	* @return the user uuid of this science app category link
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppCategoryLink.getUserUuid();
	}

	/**
	* Sets the user uuid of this science app category link.
	*
	* @param userUuid the user uuid of this science app category link
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_scienceAppCategoryLink.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this science app category link.
	*
	* @return the create date of this science app category link
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _scienceAppCategoryLink.getCreateDate();
	}

	/**
	* Sets the create date of this science app category link.
	*
	* @param createDate the create date of this science app category link
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_scienceAppCategoryLink.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this science app category link.
	*
	* @return the modified date of this science app category link
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _scienceAppCategoryLink.getModifiedDate();
	}

	/**
	* Sets the modified date of this science app category link.
	*
	* @param modifiedDate the modified date of this science app category link
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_scienceAppCategoryLink.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category ID of this science app category link.
	*
	* @return the category ID of this science app category link
	*/
	@Override
	public long getCategoryId() {
		return _scienceAppCategoryLink.getCategoryId();
	}

	/**
	* Sets the category ID of this science app category link.
	*
	* @param categoryId the category ID of this science app category link
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_scienceAppCategoryLink.setCategoryId(categoryId);
	}

	/**
	* Returns the science app ID of this science app category link.
	*
	* @return the science app ID of this science app category link
	*/
	@Override
	public long getScienceAppId() {
		return _scienceAppCategoryLink.getScienceAppId();
	}

	/**
	* Sets the science app ID of this science app category link.
	*
	* @param scienceAppId the science app ID of this science app category link
	*/
	@Override
	public void setScienceAppId(long scienceAppId) {
		_scienceAppCategoryLink.setScienceAppId(scienceAppId);
	}

	/**
	* Returns the parent category ID of this science app category link.
	*
	* @return the parent category ID of this science app category link
	*/
	@Override
	public long getParentCategoryId() {
		return _scienceAppCategoryLink.getParentCategoryId();
	}

	/**
	* Sets the parent category ID of this science app category link.
	*
	* @param parentCategoryId the parent category ID of this science app category link
	*/
	@Override
	public void setParentCategoryId(long parentCategoryId) {
		_scienceAppCategoryLink.setParentCategoryId(parentCategoryId);
	}

	@Override
	public boolean isNew() {
		return _scienceAppCategoryLink.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_scienceAppCategoryLink.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _scienceAppCategoryLink.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_scienceAppCategoryLink.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _scienceAppCategoryLink.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _scienceAppCategoryLink.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_scienceAppCategoryLink.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _scienceAppCategoryLink.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_scienceAppCategoryLink.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_scienceAppCategoryLink.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_scienceAppCategoryLink.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ScienceAppCategoryLinkWrapper((ScienceAppCategoryLink)_scienceAppCategoryLink.clone());
	}

	@Override
	public int compareTo(
		com.kisti.science.platform.app.model.ScienceAppCategoryLink scienceAppCategoryLink) {
		return _scienceAppCategoryLink.compareTo(scienceAppCategoryLink);
	}

	@Override
	public int hashCode() {
		return _scienceAppCategoryLink.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.kisti.science.platform.app.model.ScienceAppCategoryLink> toCacheModel() {
		return _scienceAppCategoryLink.toCacheModel();
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink toEscapedModel() {
		return new ScienceAppCategoryLinkWrapper(_scienceAppCategoryLink.toEscapedModel());
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink toUnescapedModel() {
		return new ScienceAppCategoryLinkWrapper(_scienceAppCategoryLink.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _scienceAppCategoryLink.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _scienceAppCategoryLink.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppCategoryLink.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScienceAppCategoryLinkWrapper)) {
			return false;
		}

		ScienceAppCategoryLinkWrapper scienceAppCategoryLinkWrapper = (ScienceAppCategoryLinkWrapper)obj;

		if (Validator.equals(_scienceAppCategoryLink,
					scienceAppCategoryLinkWrapper._scienceAppCategoryLink)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _scienceAppCategoryLink.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ScienceAppCategoryLink getWrappedScienceAppCategoryLink() {
		return _scienceAppCategoryLink;
	}

	@Override
	public ScienceAppCategoryLink getWrappedModel() {
		return _scienceAppCategoryLink;
	}

	@Override
	public void resetOriginalValues() {
		_scienceAppCategoryLink.resetOriginalValues();
	}

	private ScienceAppCategoryLink _scienceAppCategoryLink;
}