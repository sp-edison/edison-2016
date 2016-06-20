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

import org.kisti.edison.science.service.persistence.CommonLibPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.science.service.http.CommonLibServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.http.CommonLibServiceSoap
 * @generated
 */
public class CommonLibSoap implements Serializable {
	public static CommonLibSoap toSoapModel(CommonLib model) {
		CommonLibSoap soapModel = new CommonLibSoap();

		soapModel.setLibName(model.getLibName());
		soapModel.setLibPath(model.getLibPath());
		soapModel.setLibraryVersion(model.getLibraryVersion());
		soapModel.setCLibVer(model.getCLibVer());
		soapModel.setSysArch(model.getSysArch());
		soapModel.setKernelVer(model.getKernelVer());

		return soapModel;
	}

	public static CommonLibSoap[] toSoapModels(CommonLib[] models) {
		CommonLibSoap[] soapModels = new CommonLibSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CommonLibSoap[][] toSoapModels(CommonLib[][] models) {
		CommonLibSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CommonLibSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CommonLibSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CommonLibSoap[] toSoapModels(List<CommonLib> models) {
		List<CommonLibSoap> soapModels = new ArrayList<CommonLibSoap>(models.size());

		for (CommonLib model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CommonLibSoap[soapModels.size()]);
	}

	public CommonLibSoap() {
	}

	public CommonLibPK getPrimaryKey() {
		return new CommonLibPK(_libName, _libPath);
	}

	public void setPrimaryKey(CommonLibPK pk) {
		setLibName(pk.libName);
		setLibPath(pk.libPath);
	}

	public String getLibName() {
		return _libName;
	}

	public void setLibName(String libName) {
		_libName = libName;
	}

	public String getLibPath() {
		return _libPath;
	}

	public void setLibPath(String libPath) {
		_libPath = libPath;
	}

	public String getLibraryVersion() {
		return _libraryVersion;
	}

	public void setLibraryVersion(String libraryVersion) {
		_libraryVersion = libraryVersion;
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

	private String _libName;
	private String _libPath;
	private String _libraryVersion;
	private String _cLibVer;
	private String _sysArch;
	private String _kernelVer;
}