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
 * This class is used by SOAP remote services.
 *
 * @author Jerry H. Seo & Young Suh
 * @generated
 */
public class PortTypeInputdeckFormSoap implements Serializable {
	public static PortTypeInputdeckFormSoap toSoapModel(
		PortTypeInputdeckForm model) {
		PortTypeInputdeckFormSoap soapModel = new PortTypeInputdeckFormSoap();

		soapModel.setPortTypeId(model.getPortTypeId());
		soapModel.setInputdeckForm(model.getInputdeckForm());

		return soapModel;
	}

	public static PortTypeInputdeckFormSoap[] toSoapModels(
		PortTypeInputdeckForm[] models) {
		PortTypeInputdeckFormSoap[] soapModels = new PortTypeInputdeckFormSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PortTypeInputdeckFormSoap[][] toSoapModels(
		PortTypeInputdeckForm[][] models) {
		PortTypeInputdeckFormSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PortTypeInputdeckFormSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PortTypeInputdeckFormSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PortTypeInputdeckFormSoap[] toSoapModels(
		List<PortTypeInputdeckForm> models) {
		List<PortTypeInputdeckFormSoap> soapModels = new ArrayList<PortTypeInputdeckFormSoap>(models.size());

		for (PortTypeInputdeckForm model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PortTypeInputdeckFormSoap[soapModels.size()]);
	}

	public PortTypeInputdeckFormSoap() {
	}

	public long getPrimaryKey() {
		return _portTypeId;
	}

	public void setPrimaryKey(long pk) {
		setPortTypeId(pk);
	}

	public long getPortTypeId() {
		return _portTypeId;
	}

	public void setPortTypeId(long portTypeId) {
		_portTypeId = portTypeId;
	}

	public String getInputdeckForm() {
		return _inputdeckForm;
	}

	public void setInputdeckForm(String inputdeckForm) {
		_inputdeckForm = inputdeckForm;
	}

	private long _portTypeId;
	private String _inputdeckForm;
}