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
 * This class is used by SOAP remote services, specifically {@link com.kisti.science.platform.app.service.http.PortTypeEditorLinkServiceSoap}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see com.kisti.science.platform.app.service.http.PortTypeEditorLinkServiceSoap
 * @generated
 */
public class PortTypeEditorLinkSoap implements Serializable {
	public static PortTypeEditorLinkSoap toSoapModel(PortTypeEditorLink model) {
		PortTypeEditorLinkSoap soapModel = new PortTypeEditorLinkSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPortTypeEditorLinkId(model.getPortTypeEditorLinkId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setPortTypeId(model.getPortTypeId());
		soapModel.setEditorId(model.getEditorId());

		return soapModel;
	}

	public static PortTypeEditorLinkSoap[] toSoapModels(
		PortTypeEditorLink[] models) {
		PortTypeEditorLinkSoap[] soapModels = new PortTypeEditorLinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PortTypeEditorLinkSoap[][] toSoapModels(
		PortTypeEditorLink[][] models) {
		PortTypeEditorLinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PortTypeEditorLinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PortTypeEditorLinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PortTypeEditorLinkSoap[] toSoapModels(
		List<PortTypeEditorLink> models) {
		List<PortTypeEditorLinkSoap> soapModels = new ArrayList<PortTypeEditorLinkSoap>(models.size());

		for (PortTypeEditorLink model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PortTypeEditorLinkSoap[soapModels.size()]);
	}

	public PortTypeEditorLinkSoap() {
	}

	public long getPrimaryKey() {
		return _portTypeEditorLinkId;
	}

	public void setPrimaryKey(long pk) {
		setPortTypeEditorLinkId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPortTypeEditorLinkId() {
		return _portTypeEditorLinkId;
	}

	public void setPortTypeEditorLinkId(long portTypeEditorLinkId) {
		_portTypeEditorLinkId = portTypeEditorLinkId;
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

	public long getEditorId() {
		return _editorId;
	}

	public void setEditorId(long editorId) {
		_editorId = editorId;
	}

	private String _uuid;
	private long _portTypeEditorLinkId;
	private long _companyId;
	private long _portTypeId;
	private long _editorId;
}