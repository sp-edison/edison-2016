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

import org.kisti.edison.science.service.persistence.DeveloperRequestPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.science.service.http.DeveloperRequestServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.http.DeveloperRequestServiceSoap
 * @generated
 */
public class DeveloperRequestSoap implements Serializable {
	public static DeveloperRequestSoap toSoapModel(DeveloperRequest model) {
		DeveloperRequestSoap soapModel = new DeveloperRequestSoap();

		soapModel.setRequestSeq(model.getRequestSeq());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setRequestSort(model.getRequestSort());
		soapModel.setRequestDate(model.getRequestDate());
		soapModel.setRequestNote(model.getRequestNote());
		soapModel.setRequestStatus(model.getRequestStatus());
		soapModel.setProcessDate(model.getProcessDate());
		soapModel.setProcessNote(model.getProcessNote());
		soapModel.setInsertId(model.getInsertId());
		soapModel.setInsertDate(model.getInsertDate());
		soapModel.setUpdateId(model.getUpdateId());
		soapModel.setUpdateDate(model.getUpdateDate());

		return soapModel;
	}

	public static DeveloperRequestSoap[] toSoapModels(DeveloperRequest[] models) {
		DeveloperRequestSoap[] soapModels = new DeveloperRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DeveloperRequestSoap[][] toSoapModels(
		DeveloperRequest[][] models) {
		DeveloperRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DeveloperRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DeveloperRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DeveloperRequestSoap[] toSoapModels(
		List<DeveloperRequest> models) {
		List<DeveloperRequestSoap> soapModels = new ArrayList<DeveloperRequestSoap>(models.size());

		for (DeveloperRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DeveloperRequestSoap[soapModels.size()]);
	}

	public DeveloperRequestSoap() {
	}

	public DeveloperRequestPK getPrimaryKey() {
		return new DeveloperRequestPK(_requestSeq, _userId, _groupId);
	}

	public void setPrimaryKey(DeveloperRequestPK pk) {
		setRequestSeq(pk.requestSeq);
		setUserId(pk.userId);
		setGroupId(pk.groupId);
	}

	public long getRequestSeq() {
		return _requestSeq;
	}

	public void setRequestSeq(long requestSeq) {
		_requestSeq = requestSeq;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getRequestSort() {
		return _requestSort;
	}

	public void setRequestSort(String requestSort) {
		_requestSort = requestSort;
	}

	public Date getRequestDate() {
		return _requestDate;
	}

	public void setRequestDate(Date requestDate) {
		_requestDate = requestDate;
	}

	public String getRequestNote() {
		return _requestNote;
	}

	public void setRequestNote(String requestNote) {
		_requestNote = requestNote;
	}

	public String getRequestStatus() {
		return _requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		_requestStatus = requestStatus;
	}

	public Date getProcessDate() {
		return _processDate;
	}

	public void setProcessDate(Date processDate) {
		_processDate = processDate;
	}

	public String getProcessNote() {
		return _processNote;
	}

	public void setProcessNote(String processNote) {
		_processNote = processNote;
	}

	public long getInsertId() {
		return _insertId;
	}

	public void setInsertId(long insertId) {
		_insertId = insertId;
	}

	public Date getInsertDate() {
		return _insertDate;
	}

	public void setInsertDate(Date insertDate) {
		_insertDate = insertDate;
	}

	public long getUpdateId() {
		return _updateId;
	}

	public void setUpdateId(long updateId) {
		_updateId = updateId;
	}

	public Date getUpdateDate() {
		return _updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;
	}

	private long _requestSeq;
	private long _userId;
	private long _groupId;
	private String _requestSort;
	private Date _requestDate;
	private String _requestNote;
	private String _requestStatus;
	private Date _processDate;
	private String _processNote;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
}