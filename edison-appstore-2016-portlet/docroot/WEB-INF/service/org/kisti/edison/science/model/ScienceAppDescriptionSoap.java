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
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.science.service.http.ScienceAppDescriptionServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.http.ScienceAppDescriptionServiceSoap
 * @generated
 */
public class ScienceAppDescriptionSoap implements Serializable {
	public static ScienceAppDescriptionSoap toSoapModel(
		ScienceAppDescription model) {
		ScienceAppDescriptionSoap soapModel = new ScienceAppDescriptionSoap();

		soapModel.setDescriptionId(model.getDescriptionId());
		soapModel.setContent(model.getContent());
		soapModel.setInsertId(model.getInsertId());
		soapModel.setInsertDt(model.getInsertDt());
		soapModel.setUpdateId(model.getUpdateId());
		soapModel.setUpdateDt(model.getUpdateDt());

		return soapModel;
	}

	public static ScienceAppDescriptionSoap[] toSoapModels(
		ScienceAppDescription[] models) {
		ScienceAppDescriptionSoap[] soapModels = new ScienceAppDescriptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScienceAppDescriptionSoap[][] toSoapModels(
		ScienceAppDescription[][] models) {
		ScienceAppDescriptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScienceAppDescriptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScienceAppDescriptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScienceAppDescriptionSoap[] toSoapModels(
		List<ScienceAppDescription> models) {
		List<ScienceAppDescriptionSoap> soapModels = new ArrayList<ScienceAppDescriptionSoap>(models.size());

		for (ScienceAppDescription model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScienceAppDescriptionSoap[soapModels.size()]);
	}

	public ScienceAppDescriptionSoap() {
	}

	public long getPrimaryKey() {
		return _descriptionId;
	}

	public void setPrimaryKey(long pk) {
		setDescriptionId(pk);
	}

	public long getDescriptionId() {
		return _descriptionId;
	}

	public void setDescriptionId(long descriptionId) {
		_descriptionId = descriptionId;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public long getInsertId() {
		return _insertId;
	}

	public void setInsertId(long insertId) {
		_insertId = insertId;
	}

	public Date getInsertDt() {
		return _insertDt;
	}

	public void setInsertDt(Date insertDt) {
		_insertDt = insertDt;
	}

	public long getUpdateId() {
		return _updateId;
	}

	public void setUpdateId(long updateId) {
		_updateId = updateId;
	}

	public Date getUpdateDt() {
		return _updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		_updateDt = updateDt;
	}

	private long _descriptionId;
	private String _content;
	private long _insertId;
	private Date _insertDt;
	private long _updateId;
	private Date _updateDt;
}