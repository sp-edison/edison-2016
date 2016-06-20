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
 * This class is used by SOAP remote services, specifically {@link com.kisti.science.platform.app.service.http.ScienceAppManagerServiceSoap}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see com.kisti.science.platform.app.service.http.ScienceAppManagerServiceSoap
 * @generated
 */
public class ScienceAppManagerSoap implements Serializable {
	public static ScienceAppManagerSoap toSoapModel(ScienceAppManager model) {
		ScienceAppManagerSoap soapModel = new ScienceAppManagerSoap();

		soapModel.setScienceAppManagerId(model.getScienceAppManagerId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setScienceAppId(model.getScienceAppId());
		soapModel.setManagerId(model.getManagerId());

		return soapModel;
	}

	public static ScienceAppManagerSoap[] toSoapModels(
		ScienceAppManager[] models) {
		ScienceAppManagerSoap[] soapModels = new ScienceAppManagerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScienceAppManagerSoap[][] toSoapModels(
		ScienceAppManager[][] models) {
		ScienceAppManagerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScienceAppManagerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScienceAppManagerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScienceAppManagerSoap[] toSoapModels(
		List<ScienceAppManager> models) {
		List<ScienceAppManagerSoap> soapModels = new ArrayList<ScienceAppManagerSoap>(models.size());

		for (ScienceAppManager model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScienceAppManagerSoap[soapModels.size()]);
	}

	public ScienceAppManagerSoap() {
	}

	public long getPrimaryKey() {
		return _scienceAppManagerId;
	}

	public void setPrimaryKey(long pk) {
		setScienceAppManagerId(pk);
	}

	public long getScienceAppManagerId() {
		return _scienceAppManagerId;
	}

	public void setScienceAppManagerId(long scienceAppManagerId) {
		_scienceAppManagerId = scienceAppManagerId;
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

	public long getScienceAppId() {
		return _scienceAppId;
	}

	public void setScienceAppId(long scienceAppId) {
		_scienceAppId = scienceAppId;
	}

	public long getManagerId() {
		return _managerId;
	}

	public void setManagerId(long managerId) {
		_managerId = managerId;
	}

	private long _scienceAppManagerId;
	private long _userId;
	private Date _createDate;
	private long _scienceAppId;
	private long _managerId;
}