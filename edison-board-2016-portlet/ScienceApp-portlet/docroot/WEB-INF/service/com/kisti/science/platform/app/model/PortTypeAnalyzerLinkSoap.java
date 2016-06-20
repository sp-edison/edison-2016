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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.kisti.science.platform.app.service.http.PortTypeAnalyzerLinkServiceSoap}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see com.kisti.science.platform.app.service.http.PortTypeAnalyzerLinkServiceSoap
 * @generated
 */
public class PortTypeAnalyzerLinkSoap implements Serializable {
	public static PortTypeAnalyzerLinkSoap toSoapModel(
		PortTypeAnalyzerLink model) {
		PortTypeAnalyzerLinkSoap soapModel = new PortTypeAnalyzerLinkSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPortTypeAnalyzerLinkId(model.getPortTypeAnalyzerLinkId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setPortTypeId(model.getPortTypeId());
		soapModel.setAnalyzerId(model.getAnalyzerId());

		return soapModel;
	}

	public static PortTypeAnalyzerLinkSoap[] toSoapModels(
		PortTypeAnalyzerLink[] models) {
		PortTypeAnalyzerLinkSoap[] soapModels = new PortTypeAnalyzerLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PortTypeAnalyzerLinkSoap[][] toSoapModels(
		PortTypeAnalyzerLink[][] models) {
		PortTypeAnalyzerLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PortTypeAnalyzerLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PortTypeAnalyzerLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PortTypeAnalyzerLinkSoap[] toSoapModels(
		List<PortTypeAnalyzerLink> models) {
		List<PortTypeAnalyzerLinkSoap> soapModels = new ArrayList<PortTypeAnalyzerLinkSoap>(models.size());

		for (PortTypeAnalyzerLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PortTypeAnalyzerLinkSoap[soapModels.size()]);
	}

	public PortTypeAnalyzerLinkSoap() {
	}

	public long getPrimaryKey() {
		return _portTypeAnalyzerLinkId;
	}

	public void setPrimaryKey(long pk) {
		setPortTypeAnalyzerLinkId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPortTypeAnalyzerLinkId() {
		return _portTypeAnalyzerLinkId;
	}

	public void setPortTypeAnalyzerLinkId(long portTypeAnalyzerLinkId) {
		_portTypeAnalyzerLinkId = portTypeAnalyzerLinkId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getPortTypeId() {
		return _portTypeId;
	}

	public void setPortTypeId(long portTypeId) {
		_portTypeId = portTypeId;
	}

	public long getAnalyzerId() {
		return _analyzerId;
	}

	public void setAnalyzerId(long analyzerId) {
		_analyzerId = analyzerId;
	}

	private String _uuid;
	private long _portTypeAnalyzerLinkId;
	private long _companyId;
	private long _portTypeId;
	private long _analyzerId;
}