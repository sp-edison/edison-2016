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
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.science.service.http.RequiredLibServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.http.RequiredLibServiceSoap
 * @generated
 */
public class RequiredLibSoap implements Serializable {
	public static RequiredLibSoap toSoapModel(RequiredLib model) {
		RequiredLibSoap soapModel = new RequiredLibSoap();

		soapModel.setRequiredLibId(model.getRequiredLibId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLibraryName(model.getLibraryName());
		soapModel.setLibraryVersion(model.getLibraryVersion());
		soapModel.setLibraryType(model.getLibraryType());
		soapModel.setLibrarySrcPath(model.getLibrarySrcPath());
		soapModel.setInstallScript(model.getInstallScript());

		return soapModel;
	}

	public static RequiredLibSoap[] toSoapModels(RequiredLib[] models) {
		RequiredLibSoap[] soapModels = new RequiredLibSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RequiredLibSoap[][] toSoapModels(RequiredLib[][] models) {
		RequiredLibSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RequiredLibSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RequiredLibSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RequiredLibSoap[] toSoapModels(List<RequiredLib> models) {
		List<RequiredLibSoap> soapModels = new ArrayList<RequiredLibSoap>(models.size());

		for (RequiredLib model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RequiredLibSoap[soapModels.size()]);
	}

	public RequiredLibSoap() {
	}

	public long getPrimaryKey() {
		return _requiredLibId;
	}

	public void setPrimaryKey(long pk) {
		setRequiredLibId(pk);
	}

	public long getRequiredLibId() {
		return _requiredLibId;
	}

	public void setRequiredLibId(long requiredLibId) {
		_requiredLibId = requiredLibId;
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

	public String getLibraryName() {
		return _libraryName;
	}

	public void setLibraryName(String libraryName) {
		_libraryName = libraryName;
	}

	public String getLibraryVersion() {
		return _libraryVersion;
	}

	public void setLibraryVersion(String libraryVersion) {
		_libraryVersion = libraryVersion;
	}

	public String getLibraryType() {
		return _libraryType;
	}

	public void setLibraryType(String libraryType) {
		_libraryType = libraryType;
	}

	public String getLibrarySrcPath() {
		return _librarySrcPath;
	}

	public void setLibrarySrcPath(String librarySrcPath) {
		_librarySrcPath = librarySrcPath;
	}

	public String getInstallScript() {
		return _installScript;
	}

	public void setInstallScript(String installScript) {
		_installScript = installScript;
	}

	private long _requiredLibId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _libraryName;
	private String _libraryVersion;
	private String _libraryType;
	private String _librarySrcPath;
	private String _installScript;
}