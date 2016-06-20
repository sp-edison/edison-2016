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

import com.kisti.science.platform.app.service.persistence.CommonPackagePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.kisti.science.platform.app.service.http.CommonPackageServiceSoap}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see com.kisti.science.platform.app.service.http.CommonPackageServiceSoap
 * @generated
 */
public class CommonPackageSoap implements Serializable {
	public static CommonPackageSoap toSoapModel(CommonPackage model) {
		CommonPackageSoap soapModel = new CommonPackageSoap();

		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPkgName(model.getPkgName());
		soapModel.setPkgVersion(model.getPkgVersion());
		soapModel.setSysArch(model.getSysArch());
		soapModel.setInstallMethod(model.getInstallMethod());
		soapModel.setInstallPath(model.getInstallPath());

		return soapModel;
	}

	public static CommonPackageSoap[] toSoapModels(CommonPackage[] models) {
		CommonPackageSoap[] soapModels = new CommonPackageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CommonPackageSoap[][] toSoapModels(CommonPackage[][] models) {
		CommonPackageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CommonPackageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CommonPackageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CommonPackageSoap[] toSoapModels(List<CommonPackage> models) {
		List<CommonPackageSoap> soapModels = new ArrayList<CommonPackageSoap>(models.size());

		for (CommonPackage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CommonPackageSoap[soapModels.size()]);
	}

	public CommonPackageSoap() {
	}

	public CommonPackagePK getPrimaryKey() {
		return new CommonPackagePK(_pkgName, _pkgVersion);
	}

	public void setPrimaryKey(CommonPackagePK pk) {
		setPkgName(pk.pkgName);
		setPkgVersion(pk.pkgVersion);
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

	public String getPkgName() {
		return _pkgName;
	}

	public void setPkgName(String pkgName) {
		_pkgName = pkgName;
	}

	public String getPkgVersion() {
		return _pkgVersion;
	}

	public void setPkgVersion(String pkgVersion) {
		_pkgVersion = pkgVersion;
	}

	public String getSysArch() {
		return _sysArch;
	}

	public void setSysArch(String sysArch) {
		_sysArch = sysArch;
	}

	public String getInstallMethod() {
		return _installMethod;
	}

	public void setInstallMethod(String installMethod) {
		_installMethod = installMethod;
	}

	public String getInstallPath() {
		return _installPath;
	}

	public void setInstallPath(String installPath) {
		_installPath = installPath;
	}

	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _pkgName;
	private String _pkgVersion;
	private String _sysArch;
	private String _installMethod;
	private String _installPath;
}