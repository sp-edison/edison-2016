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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.kisti.science.platform.app.service.http.CommonModuleServiceSoap}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see com.kisti.science.platform.app.service.http.CommonModuleServiceSoap
 * @generated
 */
public class CommonModuleSoap implements Serializable {
	public static CommonModuleSoap toSoapModel(CommonModule model) {
		CommonModuleSoap soapModel = new CommonModuleSoap();

		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModuleName(model.getModuleName());
		soapModel.setModuleRootDir(model.getModuleRootDir());

		return soapModel;
	}

	public static CommonModuleSoap[] toSoapModels(CommonModule[] models) {
		CommonModuleSoap[] soapModels = new CommonModuleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CommonModuleSoap[][] toSoapModels(CommonModule[][] models) {
		CommonModuleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CommonModuleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CommonModuleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CommonModuleSoap[] toSoapModels(List<CommonModule> models) {
		List<CommonModuleSoap> soapModels = new ArrayList<CommonModuleSoap>(models.size());

		for (CommonModule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CommonModuleSoap[soapModels.size()]);
	}

	public CommonModuleSoap() {
	}

	public String getPrimaryKey() {
		return _moduleName;
	}

	public void setPrimaryKey(String pk) {
		setModuleName(pk);
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public String getModuleRootDir() {
		return _moduleRootDir;
	}

	public void setModuleRootDir(String moduleRootDir) {
		_moduleRootDir = moduleRootDir;
	}

	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _moduleName;
	private String _moduleRootDir;
}