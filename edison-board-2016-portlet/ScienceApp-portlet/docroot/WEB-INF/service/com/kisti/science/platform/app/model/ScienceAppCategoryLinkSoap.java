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
 * This class is used by SOAP remote services, specifically {@link com.kisti.science.platform.app.service.http.ScienceAppCategoryLinkServiceSoap}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see com.kisti.science.platform.app.service.http.ScienceAppCategoryLinkServiceSoap
 * @generated
 */
public class ScienceAppCategoryLinkSoap implements Serializable {
	public static ScienceAppCategoryLinkSoap toSoapModel(
		ScienceAppCategoryLink model) {
		ScienceAppCategoryLinkSoap soapModel = new ScienceAppCategoryLinkSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setScienceAppCategoryLinkId(model.getScienceAppCategoryLinkId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setScienceAppId(model.getScienceAppId());
		soapModel.setParentCategoryId(model.getParentCategoryId());

		return soapModel;
	}

	public static ScienceAppCategoryLinkSoap[] toSoapModels(
		ScienceAppCategoryLink[] models) {
		ScienceAppCategoryLinkSoap[] soapModels = new ScienceAppCategoryLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScienceAppCategoryLinkSoap[][] toSoapModels(
		ScienceAppCategoryLink[][] models) {
		ScienceAppCategoryLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScienceAppCategoryLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScienceAppCategoryLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScienceAppCategoryLinkSoap[] toSoapModels(
		List<ScienceAppCategoryLink> models) {
		List<ScienceAppCategoryLinkSoap> soapModels = new ArrayList<ScienceAppCategoryLinkSoap>(models.size());

		for (ScienceAppCategoryLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScienceAppCategoryLinkSoap[soapModels.size()]);
	}

	public ScienceAppCategoryLinkSoap() {
	}

	public long getPrimaryKey() {
		return _scienceAppCategoryLinkId;
	}

	public void setPrimaryKey(long pk) {
		setScienceAppCategoryLinkId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getScienceAppCategoryLinkId() {
		return _scienceAppCategoryLinkId;
	}

	public void setScienceAppCategoryLinkId(long scienceAppCategoryLinkId) {
		_scienceAppCategoryLinkId = scienceAppCategoryLinkId;
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

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getScienceAppId() {
		return _scienceAppId;
	}

	public void setScienceAppId(long scienceAppId) {
		_scienceAppId = scienceAppId;
	}

	public long getParentCategoryId() {
		return _parentCategoryId;
	}

	public void setParentCategoryId(long parentCategoryId) {
		_parentCategoryId = parentCategoryId;
	}

	private String _uuid;
	private long _scienceAppCategoryLinkId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _categoryId;
	private long _scienceAppId;
	private long _parentCategoryId;
}