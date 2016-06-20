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

package org.kisti.edison.project.model;

import org.kisti.edison.project.service.persistence.HistoryScienceAppPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.project.service.http.HistoryScienceAppServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.project.service.http.HistoryScienceAppServiceSoap
 * @generated
 */
public class HistoryScienceAppSoap implements Serializable {
	public static HistoryScienceAppSoap toSoapModel(HistoryScienceApp model) {
		HistoryScienceAppSoap soapModel = new HistoryScienceAppSoap();

		soapModel.setScienceAppId(model.getScienceAppId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setProjectCategoryId(model.getProjectCategoryId());
		soapModel.setTitle(model.getTitle());
		soapModel.setVersion(model.getVersion());
		soapModel.setName(model.getName());
		soapModel.setAffiliation_id(model.getAffiliation_id());
		soapModel.setAppStatus(model.getAppStatus());
		soapModel.setUserId(model.getUserId());
		soapModel.setInsertDate(model.getInsertDate());

		return soapModel;
	}

	public static HistoryScienceAppSoap[] toSoapModels(
		HistoryScienceApp[] models) {
		HistoryScienceAppSoap[] soapModels = new HistoryScienceAppSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HistoryScienceAppSoap[][] toSoapModels(
		HistoryScienceApp[][] models) {
		HistoryScienceAppSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HistoryScienceAppSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HistoryScienceAppSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HistoryScienceAppSoap[] toSoapModels(
		List<HistoryScienceApp> models) {
		List<HistoryScienceAppSoap> soapModels = new ArrayList<HistoryScienceAppSoap>(models.size());

		for (HistoryScienceApp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HistoryScienceAppSoap[soapModels.size()]);
	}

	public HistoryScienceAppSoap() {
	}

	public HistoryScienceAppPK getPrimaryKey() {
		return new HistoryScienceAppPK(_scienceAppId, _groupId,
			_projectCategoryId);
	}

	public void setPrimaryKey(HistoryScienceAppPK pk) {
		setScienceAppId(pk.scienceAppId);
		setGroupId(pk.groupId);
		setProjectCategoryId(pk.projectCategoryId);
	}

	public long getScienceAppId() {
		return _scienceAppId;
	}

	public void setScienceAppId(long scienceAppId) {
		_scienceAppId = scienceAppId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getProjectCategoryId() {
		return _projectCategoryId;
	}

	public void setProjectCategoryId(long projectCategoryId) {
		_projectCategoryId = projectCategoryId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAffiliation_id() {
		return _affiliation_id;
	}

	public void setAffiliation_id(String affiliation_id) {
		_affiliation_id = affiliation_id;
	}

	public String getAppStatus() {
		return _AppStatus;
	}

	public void setAppStatus(String AppStatus) {
		_AppStatus = AppStatus;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getInsertDate() {
		return _insertDate;
	}

	public void setInsertDate(Date insertDate) {
		_insertDate = insertDate;
	}

	private long _scienceAppId;
	private long _groupId;
	private long _projectCategoryId;
	private String _title;
	private String _version;
	private String _name;
	private String _affiliation_id;
	private String _AppStatus;
	private long _userId;
	private Date _insertDate;
}