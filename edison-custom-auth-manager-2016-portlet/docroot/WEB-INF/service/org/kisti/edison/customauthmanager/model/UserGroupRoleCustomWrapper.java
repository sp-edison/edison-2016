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

package org.kisti.edison.customauthmanager.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserGroupRoleCustom}.
 * </p>
 *
 * @author EDISON
 * @see UserGroupRoleCustom
 * @generated
 */
public class UserGroupRoleCustomWrapper implements UserGroupRoleCustom,
	ModelWrapper<UserGroupRoleCustom> {
	public UserGroupRoleCustomWrapper(UserGroupRoleCustom userGroupRoleCustom) {
		_userGroupRoleCustom = userGroupRoleCustom;
	}

	@Override
	public Class<?> getModelClass() {
		return UserGroupRoleCustom.class;
	}

	@Override
	public String getModelClassName() {
		return UserGroupRoleCustom.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("roleId", getRoleId());
		attributes.put("customId", getCustomId());
		attributes.put("createDate", getCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Long customId = (Long)attributes.get("customId");

		if (customId != null) {
			setCustomId(customId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}
	}

	/**
	* Returns the primary key of this user group role custom.
	*
	* @return the primary key of this user group role custom
	*/
	@Override
	public org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK getPrimaryKey() {
		return _userGroupRoleCustom.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user group role custom.
	*
	* @param primaryKey the primary key of this user group role custom
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK primaryKey) {
		_userGroupRoleCustom.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this user group role custom.
	*
	* @return the user ID of this user group role custom
	*/
	@Override
	public long getUserId() {
		return _userGroupRoleCustom.getUserId();
	}

	/**
	* Sets the user ID of this user group role custom.
	*
	* @param userId the user ID of this user group role custom
	*/
	@Override
	public void setUserId(long userId) {
		_userGroupRoleCustom.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user group role custom.
	*
	* @return the user uuid of this user group role custom
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userGroupRoleCustom.getUserUuid();
	}

	/**
	* Sets the user uuid of this user group role custom.
	*
	* @param userUuid the user uuid of this user group role custom
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userGroupRoleCustom.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this user group role custom.
	*
	* @return the group ID of this user group role custom
	*/
	@Override
	public long getGroupId() {
		return _userGroupRoleCustom.getGroupId();
	}

	/**
	* Sets the group ID of this user group role custom.
	*
	* @param groupId the group ID of this user group role custom
	*/
	@Override
	public void setGroupId(long groupId) {
		_userGroupRoleCustom.setGroupId(groupId);
	}

	/**
	* Returns the role ID of this user group role custom.
	*
	* @return the role ID of this user group role custom
	*/
	@Override
	public long getRoleId() {
		return _userGroupRoleCustom.getRoleId();
	}

	/**
	* Sets the role ID of this user group role custom.
	*
	* @param roleId the role ID of this user group role custom
	*/
	@Override
	public void setRoleId(long roleId) {
		_userGroupRoleCustom.setRoleId(roleId);
	}

	/**
	* Returns the custom ID of this user group role custom.
	*
	* @return the custom ID of this user group role custom
	*/
	@Override
	public long getCustomId() {
		return _userGroupRoleCustom.getCustomId();
	}

	/**
	* Sets the custom ID of this user group role custom.
	*
	* @param customId the custom ID of this user group role custom
	*/
	@Override
	public void setCustomId(long customId) {
		_userGroupRoleCustom.setCustomId(customId);
	}

	/**
	* Returns the create date of this user group role custom.
	*
	* @return the create date of this user group role custom
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _userGroupRoleCustom.getCreateDate();
	}

	/**
	* Sets the create date of this user group role custom.
	*
	* @param createDate the create date of this user group role custom
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_userGroupRoleCustom.setCreateDate(createDate);
	}

	@Override
	public boolean isNew() {
		return _userGroupRoleCustom.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userGroupRoleCustom.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userGroupRoleCustom.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userGroupRoleCustom.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userGroupRoleCustom.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userGroupRoleCustom.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userGroupRoleCustom.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userGroupRoleCustom.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userGroupRoleCustom.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userGroupRoleCustom.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userGroupRoleCustom.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserGroupRoleCustomWrapper((UserGroupRoleCustom)_userGroupRoleCustom.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.customauthmanager.model.UserGroupRoleCustom userGroupRoleCustom) {
		return _userGroupRoleCustom.compareTo(userGroupRoleCustom);
	}

	@Override
	public int hashCode() {
		return _userGroupRoleCustom.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> toCacheModel() {
		return _userGroupRoleCustom.toCacheModel();
	}

	@Override
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom toEscapedModel() {
		return new UserGroupRoleCustomWrapper(_userGroupRoleCustom.toEscapedModel());
	}

	@Override
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom toUnescapedModel() {
		return new UserGroupRoleCustomWrapper(_userGroupRoleCustom.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userGroupRoleCustom.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userGroupRoleCustom.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userGroupRoleCustom.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserGroupRoleCustomWrapper)) {
			return false;
		}

		UserGroupRoleCustomWrapper userGroupRoleCustomWrapper = (UserGroupRoleCustomWrapper)obj;

		if (Validator.equals(_userGroupRoleCustom,
					userGroupRoleCustomWrapper._userGroupRoleCustom)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserGroupRoleCustom getWrappedUserGroupRoleCustom() {
		return _userGroupRoleCustom;
	}

	@Override
	public UserGroupRoleCustom getWrappedModel() {
		return _userGroupRoleCustom;
	}

	@Override
	public void resetOriginalValues() {
		_userGroupRoleCustom.resetOriginalValues();
	}

	private UserGroupRoleCustom _userGroupRoleCustom;
}