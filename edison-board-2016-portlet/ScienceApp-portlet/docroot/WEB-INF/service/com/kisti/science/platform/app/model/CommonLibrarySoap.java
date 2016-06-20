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

import com.kisti.science.platform.app.service.persistence.CommonLibraryPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.kisti.science.platform.app.service.http.CommonLibraryServiceSoap}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see com.kisti.science.platform.app.service.http.CommonLibraryServiceSoap
 * @generated
 */
public class CommonLibrarySoap implements Serializable {
	public static CommonLibrarySoap toSoapModel(CommonLibrary model) {
		CommonLibrarySoap soapModel = new CommonLibrarySoap();

		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLibName(model.getLibName());
		soapModel.setCLibVer(model.getCLibVer());
		soapModel.setSysArch(model.getSysArch());
		soapModel.setKernelVer(model.getKernelVer());
		soapModel.setLibPath(model.getLibPath());

		return soapModel;
	}

	public static CommonLibrarySoap[] toSoapModels(CommonLibrary[] models) {
		CommonLibrarySoap[] soapModels = new CommonLibrarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CommonLibrarySoap[][] toSoapModels(CommonLibrary[][] models) {
		CommonLibrarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CommonLibrarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CommonLibrarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CommonLibrarySoap[] toSoapModels(List<CommonLibrary> models) {
		List<CommonLibrarySoap> soapModels = new ArrayList<CommonLibrarySoap>(models.size());

		for (CommonLibrary model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CommonLibrarySoap[soapModels.size()]);
	}

	public CommonLibrarySoap() {
	}

	public CommonLibraryPK getPrimaryKey() {
		return new CommonLibraryPK(_libName, _libPath);
	}

	public void setPrimaryKey(CommonLibraryPK pk) {
		setLibName(pk.libName);
		setLibPath(pk.libPath);
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

	public String getLibName() {
		return _libName;
	}

	public void setLibName(String libName) {
		_libName = libName;
	}

	public String getCLibVer() {
		return _cLibVer;
	}

	public void setCLibVer(String cLibVer) {
		_cLibVer = cLibVer;
	}

	public String getSysArch() {
		return _sysArch;
	}

	public void setSysArch(String sysArch) {
		_sysArch = sysArch;
	}

	public String getKernelVer() {
		return _kernelVer;
	}

	public void setKernelVer(String kernelVer) {
		_kernelVer = kernelVer;
	}

	public String getLibPath() {
		return _libPath;
	}

	public void setLibPath(String libPath) {
		_libPath = libPath;
	}

	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _libName;
	private String _cLibVer;
	private String _sysArch;
	private String _kernelVer;
	private String _libPath;
}