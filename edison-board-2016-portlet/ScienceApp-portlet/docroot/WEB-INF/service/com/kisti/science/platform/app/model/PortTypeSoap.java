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
 * This class is used by SOAP remote services, specifically {@link com.kisti.science.platform.app.service.http.PortTypeServiceSoap}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see com.kisti.science.platform.app.service.http.PortTypeServiceSoap
 * @generated
 */
public class PortTypeSoap implements Serializable {
	public static PortTypeSoap toSoapModel(PortType model) {
		PortTypeSoap soapModel = new PortTypeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPortTypeId(model.getPortTypeId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setDefaultEditorId(model.getDefaultEditorId());
		soapModel.setDefaultAnalyzerId(model.getDefaultAnalyzerId());
		soapModel.setName(model.getName());
		soapModel.setDataType(model.getDataType());
		soapModel.setSampleFilePath(model.getSampleFilePath());
		soapModel.setTargetLanguage(model.getTargetLanguage());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static PortTypeSoap[] toSoapModels(PortType[] models) {
		PortTypeSoap[] soapModels = new PortTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PortTypeSoap[][] toSoapModels(PortType[][] models) {
		PortTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PortTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PortTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PortTypeSoap[] toSoapModels(List<PortType> models) {
		List<PortTypeSoap> soapModels = new ArrayList<PortTypeSoap>(models.size());

		for (PortType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PortTypeSoap[soapModels.size()]);
	}

	public PortTypeSoap() {
	}

	public long getPrimaryKey() {
		return _portTypeId;
	}

	public void setPrimaryKey(long pk) {
		setPortTypeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPortTypeId() {
		return _portTypeId;
	}

	public void setPortTypeId(long portTypeId) {
		_portTypeId = portTypeId;
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

	public long getDefaultEditorId() {
		return _defaultEditorId;
	}

	public void setDefaultEditorId(long defaultEditorId) {
		_defaultEditorId = defaultEditorId;
	}

	public long getDefaultAnalyzerId() {
		return _defaultAnalyzerId;
	}

	public void setDefaultAnalyzerId(long defaultAnalyzerId) {
		_defaultAnalyzerId = defaultAnalyzerId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDataType() {
		return _dataType;
	}

	public void setDataType(String dataType) {
		_dataType = dataType;
	}

	public String getSampleFilePath() {
		return _sampleFilePath;
	}

	public void setSampleFilePath(String sampleFilePath) {
		_sampleFilePath = sampleFilePath;
	}

	public String getTargetLanguage() {
		return _targetLanguage;
	}

	public void setTargetLanguage(String targetLanguage) {
		_targetLanguage = targetLanguage;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private String _uuid;
	private long _portTypeId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private long _defaultEditorId;
	private long _defaultAnalyzerId;
	private String _name;
	private String _dataType;
	private String _sampleFilePath;
	private String _targetLanguage;
	private String _status;
}