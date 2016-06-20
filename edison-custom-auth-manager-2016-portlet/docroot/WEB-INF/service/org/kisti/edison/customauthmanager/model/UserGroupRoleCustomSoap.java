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

import org.kisti.edison.customauthmanager.service.persistence.UserGroupRoleCustomPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.customauthmanager.service.http.UserGroupRoleCustomServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.customauthmanager.service.http.UserGroupRoleCustomServiceSoap
 * @generated
 */
public class UserGroupRoleCustomSoap implements Serializable {
	public static UserGroupRoleCustomSoap toSoapModel(UserGroupRoleCustom model) {
		UserGroupRoleCustomSoap soapModel = new UserGroupRoleCustomSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setCustomId(model.getCustomId());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static UserGroupRoleCustomSoap[] toSoapModels(
		UserGroupRoleCustom[] models) {
		UserGroupRoleCustomSoap[] soapModels = new UserGroupRoleCustomSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserGroupRoleCustomSoap[][] toSoapModels(
		UserGroupRoleCustom[][] models) {
		UserGroupRoleCustomSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserGroupRoleCustomSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserGroupRoleCustomSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserGroupRoleCustomSoap[] toSoapModels(
		List<UserGroupRoleCustom> models) {
		List<UserGroupRoleCustomSoap> soapModels = new ArrayList<UserGroupRoleCustomSoap>(models.size());

		for (UserGroupRoleCustom model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserGroupRoleCustomSoap[soapModels.size()]);
	}

	public UserGroupRoleCustomSoap() {
	}

	public UserGroupRoleCustomPK getPrimaryKey() {
		return new UserGroupRoleCustomPK(_userId, _groupId, _roleId, _customId);
	}

	public void setPrimaryKey(UserGroupRoleCustomPK pk) {
		setUserId(pk.userId);
		setGroupId(pk.groupId);
		setRoleId(pk.roleId);
		setCustomId(pk.customId);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public long getCustomId() {
		return _customId;
	}

	public void setCustomId(long customId) {
		_customId = customId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _userId;
	private long _groupId;
	private long _roleId;
	private long _customId;
	private Date _createDate;
}