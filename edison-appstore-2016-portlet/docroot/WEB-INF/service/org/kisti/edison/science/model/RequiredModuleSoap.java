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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.science.service.http.RequiredModuleServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.http.RequiredModuleServiceSoap
 * @generated
 */
public class RequiredModuleSoap implements Serializable {
	public static RequiredModuleSoap toSoapModel(RequiredModule model) {
		RequiredModuleSoap soapModel = new RequiredModuleSoap();

		soapModel.setRequiredModuleId(model.getRequiredModuleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModuleName(model.getModuleName());
		soapModel.setModuleVersion(model.getModuleVersion());

		return soapModel;
	}

	public static RequiredModuleSoap[] toSoapModels(RequiredModule[] models) {
		RequiredModuleSoap[] soapModels = new RequiredModuleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RequiredModuleSoap[][] toSoapModels(RequiredModule[][] models) {
		RequiredModuleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RequiredModuleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RequiredModuleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RequiredModuleSoap[] toSoapModels(List<RequiredModule> models) {
		List<RequiredModuleSoap> soapModels = new ArrayList<RequiredModuleSoap>(models.size());

		for (RequiredModule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RequiredModuleSoap[soapModels.size()]);
	}

	public RequiredModuleSoap() {
	}

	public long getPrimaryKey() {
		return _requiredModuleId;
	}

	public void setPrimaryKey(long pk) {
		setRequiredModuleId(pk);
	}

	public long getRequiredModuleId() {
		return _requiredModuleId;
	}

	public void setRequiredModuleId(long requiredModuleId) {
		_requiredModuleId = requiredModuleId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getModuleName() {
		return _moduleName;
	}

	public void setModuleName(String moduleName) {
		_moduleName = moduleName;
	}

	public String getModuleVersion() {
		return _moduleVersion;
	}

	public void setModuleVersion(String moduleVersion) {
		_moduleVersion = moduleVersion;
	}

	private long _requiredModuleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _moduleName;
	private String _moduleVersion;
}