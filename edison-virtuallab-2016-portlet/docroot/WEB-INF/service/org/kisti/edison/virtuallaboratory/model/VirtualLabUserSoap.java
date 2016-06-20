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
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.virtuallaboratory.service.http.VirtualLabUserServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.virtuallaboratory.service.http.VirtualLabUserServiceSoap
 * @generated
 */
public class VirtualLabUserSoap implements Serializable {
	public static VirtualLabUserSoap toSoapModel(VirtualLabUser model) {
		VirtualLabUserSoap soapModel = new VirtualLabUserSoap();

		soapModel.setVirtualLabUserId(model.getVirtualLabUserId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserStudentNumber(model.getUserStudentNumber());
		soapModel.setAuthRole(model.getAuthRole());
		soapModel.setUserUseYn(model.getUserUseYn());
		soapModel.setRequestSort(model.getRequestSort());
		soapModel.setProcessNote(model.getProcessNote());
		soapModel.setProcessDate(model.getProcessDate());
		soapModel.setCreateDt(model.getCreateDt());
		soapModel.setUpdateDt(model.getUpdateDt());

		return soapModel;
	}

	public static VirtualLabUserSoap[] toSoapModels(VirtualLabUser[] models) {
		VirtualLabUserSoap[] soapModels = new VirtualLabUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VirtualLabUserSoap[][] toSoapModels(VirtualLabUser[][] models) {
		VirtualLabUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VirtualLabUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VirtualLabUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VirtualLabUserSoap[] toSoapModels(List<VirtualLabUser> models) {
		List<VirtualLabUserSoap> soapModels = new ArrayList<VirtualLabUserSoap>(models.size());

		for (VirtualLabUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VirtualLabUserSoap[soapModels.size()]);
	}

	public VirtualLabUserSoap() {
	}

	public long getPrimaryKey() {
		return _virtualLabUserId;
	}

	public void setPrimaryKey(long pk) {
		setVirtualLabUserId(pk);
	}

	public long getVirtualLabUserId() {
		return _virtualLabUserId;
	}

	public void setVirtualLabUserId(long virtualLabUserId) {
		_virtualLabUserId = virtualLabUserId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserStudentNumber() {
		return _userStudentNumber;
	}

	public void setUserStudentNumber(String userStudentNumber) {
		_userStudentNumber = userStudentNumber;
	}

	public String getAuthRole() {
		return _authRole;
	}

	public void setAuthRole(String authRole) {
		_authRole = authRole;
	}

	public String getUserUseYn() {
		return _userUseYn;
	}

	public void setUserUseYn(String userUseYn) {
		_userUseYn = userUseYn;
	}

	public String getRequestSort() {
		return _requestSort;
	}

	public void setRequestSort(String requestSort) {
		_requestSort = requestSort;
	}

	public String getProcessNote() {
		return _processNote;
	}

	public void setProcessNote(String processNote) {
		_processNote = processNote;
	}

	public Date getProcessDate() {
		return _processDate;
	}

	public void setProcessDate(Date processDate) {
		_processDate = processDate;
	}

	public Date getCreateDt() {
		return _createDt;
	}

	public void setCreateDt(Date createDt) {
		_createDt = createDt;
	}

	public Date getUpdateDt() {
		return _updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		_updateDt = updateDt;
	}

	private long _virtualLabUserId;
	private long _userId;
	private String _userStudentNumber;
	private String _authRole;
	private String _userUseYn;
	private String _requestSort;
	private String _processNote;
	private Date _processDate;
	private Date _createDt;
	private Date _updateDt;
}