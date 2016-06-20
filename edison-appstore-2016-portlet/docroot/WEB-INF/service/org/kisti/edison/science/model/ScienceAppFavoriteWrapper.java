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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ScienceAppFavorite}.
 * </p>
 *
 * @author EDISON
 * @see ScienceAppFavorite
 * @generated
 */
public class ScienceAppFavoriteWrapper implements ScienceAppFavorite,
	ModelWrapper<ScienceAppFavorite> {
	public ScienceAppFavoriteWrapper(ScienceAppFavorite scienceAppFavorite) {
		_scienceAppFavorite = scienceAppFavorite;
	}

	@Override
	public Class<?> getModelClass() {
		return ScienceAppFavorite.class;
	}

	@Override
	public String getModelClassName() {
		return ScienceAppFavorite.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
	}

	/**
	* Returns the primary key of this science app favorite.
	*
	* @return the primary key of this science app favorite
	*/
	@Override
	public org.kisti.edison.science.service.persistence.ScienceAppFavoritePK getPrimaryKey() {
		return _scienceAppFavorite.getPrimaryKey();
	}

	/**
	* Sets the primary key of this science app favorite.
	*
	* @param primaryKey the primary key of this science app favorite
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.science.service.persistence.ScienceAppFavoritePK primaryKey) {
		_scienceAppFavorite.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the science app ID of this science app favorite.
	*
	* @return the science app ID of this science app favorite
	*/
	@Override
	public long getScienceAppId() {
		return _scienceAppFavorite.getScienceAppId();
	}

	/**
	* Sets the science app ID of this science app favorite.
	*
	* @param scienceAppId the science app ID of this science app favorite
	*/
	@Override
	public void setScienceAppId(long scienceAppId) {
		_scienceAppFavorite.setScienceAppId(scienceAppId);
	}

	/**
	* Returns the user ID of this science app favorite.
	*
	* @return the user ID of this science app favorite
	*/
	@Override
	public long getUserId() {
		return _scienceAppFavorite.getUserId();
	}

	/**
	* Sets the user ID of this science app favorite.
	*
	* @param userId the user ID of this science app favorite
	*/
	@Override
	public void setUserId(long userId) {
		_scienceAppFavorite.setUserId(userId);
	}

	/**
	* Returns the user uuid of this science app favorite.
	*
	* @return the user uuid of this science app favorite
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppFavorite.getUserUuid();
	}

	/**
	* Sets the user uuid of this science app favorite.
	*
	* @param userUuid the user uuid of this science app favorite
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_scienceAppFavorite.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this science app favorite.
	*
	* @return the group ID of this science app favorite
	*/
	@Override
	public long getGroupId() {
		return _scienceAppFavorite.getGroupId();
	}

	/**
	* Sets the group ID of this science app favorite.
	*
	* @param groupId the group ID of this science app favorite
	*/
	@Override
	public void setGroupId(long groupId) {
		_scienceAppFavorite.setGroupId(groupId);
	}

	@Override
	public boolean isNew() {
		return _scienceAppFavorite.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_scienceAppFavorite.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _scienceAppFavorite.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_scienceAppFavorite.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _scienceAppFavorite.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _scienceAppFavorite.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_scienceAppFavorite.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _scienceAppFavorite.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_scienceAppFavorite.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_scienceAppFavorite.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_scienceAppFavorite.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ScienceAppFavoriteWrapper((ScienceAppFavorite)_scienceAppFavorite.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.science.model.ScienceAppFavorite scienceAppFavorite) {
		return _scienceAppFavorite.compareTo(scienceAppFavorite);
	}

	@Override
	public int hashCode() {
		return _scienceAppFavorite.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.science.model.ScienceAppFavorite> toCacheModel() {
		return _scienceAppFavorite.toCacheModel();
	}

	@Override
	public org.kisti.edison.science.model.ScienceAppFavorite toEscapedModel() {
		return new ScienceAppFavoriteWrapper(_scienceAppFavorite.toEscapedModel());
	}

	@Override
	public org.kisti.edison.science.model.ScienceAppFavorite toUnescapedModel() {
		return new ScienceAppFavoriteWrapper(_scienceAppFavorite.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _scienceAppFavorite.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _scienceAppFavorite.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppFavorite.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScienceAppFavoriteWrapper)) {
			return false;
		}

		ScienceAppFavoriteWrapper scienceAppFavoriteWrapper = (ScienceAppFavoriteWrapper)obj;

		if (Validator.equals(_scienceAppFavorite,
					scienceAppFavoriteWrapper._scienceAppFavorite)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ScienceAppFavorite getWrappedScienceAppFavorite() {
		return _scienceAppFavorite;
	}

	@Override
	public ScienceAppFavorite getWrappedModel() {
		return _scienceAppFavorite;
	}

	@Override
	public void resetOriginalValues() {
		_scienceAppFavorite.resetOriginalValues();
	}

	private ScienceAppFavorite _scienceAppFavorite;
}