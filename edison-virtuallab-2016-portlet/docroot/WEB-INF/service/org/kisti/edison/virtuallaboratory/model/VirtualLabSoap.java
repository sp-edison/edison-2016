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

package org.kisti.edison.virtuallaboratory.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.virtuallaboratory.service.http.VirtualLabServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.virtuallaboratory.service.http.VirtualLabServiceSoap
 * @generated
 */
public class VirtualLabSoap implements Serializable {
	public static VirtualLabSoap toSoapModel(VirtualLab model) {
		VirtualLabSoap soapModel = new VirtualLabSoap();

		soapModel.setVirtualLabId(model.getVirtualLabId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setVirtualLabPersonName(model.getVirtualLabPersonName());
		soapModel.setVirtualLabRequestDt(model.getVirtualLabRequestDt());
		soapModel.setVirtualLabConfirmDt(model.getVirtualLabConfirmDt());
		soapModel.setVirtualLabConfirmDescription(model.getVirtualLabConfirmDescription());
		soapModel.setVirtualLabStatus(model.getVirtualLabStatus());
		soapModel.setVirtualLabTitle(model.getVirtualLabTitle());
		soapModel.setVirtualLabDescription(model.getVirtualLabDescription());
		soapModel.setVirtualLabUseYn(model.getVirtualLabUseYn());
		soapModel.setVirtualLabUniversityField(model.getVirtualLabUniversityField());

		return soapModel;
	}

	public static VirtualLabSoap[] toSoapModels(VirtualLab[] models) {
		VirtualLabSoap[] soapModels = new VirtualLabSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VirtualLabSoap[][] toSoapModels(VirtualLab[][] models) {
		VirtualLabSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VirtualLabSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VirtualLabSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VirtualLabSoap[] toSoapModels(List<VirtualLab> models) {
		List<VirtualLabSoap> soapModels = new ArrayList<VirtualLabSoap>(models.size());

		for (VirtualLab model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VirtualLabSoap[soapModels.size()]);
	}

	public VirtualLabSoap() {
	}

	public long getPrimaryKey() {
		return _virtualLabId;
	}

	public void setPrimaryKey(long pk) {
		setVirtualLabId(pk);
	}

	public long getVirtualLabId() {
		return _virtualLabId;
	}

	public void setVirtualLabId(long virtualLabId) {
		_virtualLabId = virtualLabId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getVirtualLabPersonName() {
		return _virtualLabPersonName;
	}

	public void setVirtualLabPersonName(String virtualLabPersonName) {
		_virtualLabPersonName = virtualLabPersonName;
	}

	public Date getVirtualLabRequestDt() {
		return _virtualLabRequestDt;
	}

	public void setVirtualLabRequestDt(Date virtualLabRequestDt) {
		_virtualLabRequestDt = virtualLabRequestDt;
	}

	public Date getVirtualLabConfirmDt() {
		return _virtualLabConfirmDt;
	}

	public void setVirtualLabConfirmDt(Date virtualLabConfirmDt) {
		_virtualLabConfirmDt = virtualLabConfirmDt;
	}

	public String getVirtualLabConfirmDescription() {
		return _virtualLabConfirmDescription;
	}

	public void setVirtualLabConfirmDescription(
		String virtualLabConfirmDescription) {
		_virtualLabConfirmDescription = virtualLabConfirmDescription;
	}

	public String getVirtualLabStatus() {
		return _virtualLabStatus;
	}

	public void setVirtualLabStatus(String virtualLabStatus) {
		_virtualLabStatus = virtualLabStatus;
	}

	public String getVirtualLabTitle() {
		return _virtualLabTitle;
	}

	public void setVirtualLabTitle(String virtualLabTitle) {
		_virtualLabTitle = virtualLabTitle;
	}

	public String getVirtualLabDescription() {
		return _virtualLabDescription;
	}

	public void setVirtualLabDescription(String virtualLabDescription) {
		_virtualLabDescription = virtualLabDescription;
	}

	public String getVirtualLabUseYn() {
		return _virtualLabUseYn;
	}

	public void setVirtualLabUseYn(String virtualLabUseYn) {
		_virtualLabUseYn = virtualLabUseYn;
	}

	public String getVirtualLabUniversityField() {
		return _virtualLabUniversityField;
	}

	public void setVirtualLabUniversityField(String virtualLabUniversityField) {
		_virtualLabUniversityField = virtualLabUniversityField;
	}

	private long _virtualLabId;
	private long _groupId;
	private long _userId;
	private String _virtualLabPersonName;
	private Date _virtualLabRequestDt;
	private Date _virtualLabConfirmDt;
	private String _virtualLabConfirmDescription;
	private String _virtualLabStatus;
	private String _virtualLabTitle;
	private String _virtualLabDescription;
	private String _virtualLabUseYn;
	private String _virtualLabUniversityField;
}