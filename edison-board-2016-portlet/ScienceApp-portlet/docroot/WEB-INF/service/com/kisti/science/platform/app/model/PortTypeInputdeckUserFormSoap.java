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
public class PortTypeInputdeckUserFormSoap implements Serializable {
	public static PortTypeInputdeckUserFormSoap toSoapModel(
		PortTypeInputdeckUserForm model) {
		PortTypeInputdeckUserFormSoap soapModel = new PortTypeInputdeckUserFormSoap();

		soapModel.setInputdeckId(model.getInputdeckId());
		soapModel.setPortTypeId(model.getPortTypeId());
		soapModel.setInputdeckUserForm(model.getInputdeckUserForm());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());

		return soapModel;
	}

	public static PortTypeInputdeckUserFormSoap[] toSoapModels(
		PortTypeInputdeckUserForm[] models) {
		PortTypeInputdeckUserFormSoap[] soapModels = new PortTypeInputdeckUserFormSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PortTypeInputdeckUserFormSoap[][] toSoapModels(
		PortTypeInputdeckUserForm[][] models) {
		PortTypeInputdeckUserFormSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PortTypeInputdeckUserFormSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PortTypeInputdeckUserFormSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PortTypeInputdeckUserFormSoap[] toSoapModels(
		List<PortTypeInputdeckUserForm> models) {
		List<PortTypeInputdeckUserFormSoap> soapModels = new ArrayList<PortTypeInputdeckUserFormSoap>(models.size());

		for (PortTypeInputdeckUserForm model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PortTypeInputdeckUserFormSoap[soapModels.size()]);
	}

	public PortTypeInputdeckUserFormSoap() {
	}

	public long getPrimaryKey() {
		return _inputdeckId;
	}

	public void setPrimaryKey(long pk) {
		setInputdeckId(pk);
	}

	public long getInputdeckId() {
		return _inputdeckId;
	}

	public void setInputdeckId(long inputdeckId) {
		_inputdeckId = inputdeckId;
	}

	public long getPortTypeId() {
		return _portTypeId;
	}

	public void setPortTypeId(long portTypeId) {
		_portTypeId = portTypeId;
	}

	public String getInputdeckUserForm() {
		return _inputdeckUserForm;
	}

	public void setInputdeckUserForm(String inputdeckUserForm) {
		_inputdeckUserForm = inputdeckUserForm;
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

	private long _inputdeckId;
	private long _portTypeId;
	private String _inputdeckUserForm;
	private long _userId;
	private String _userName;
}