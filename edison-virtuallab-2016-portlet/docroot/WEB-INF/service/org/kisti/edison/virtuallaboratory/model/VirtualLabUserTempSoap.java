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

import org.kisti.edison.virtuallaboratory.service.persistence.VirtualLabUserTempPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.virtuallaboratory.service.http.VirtualLabUserTempServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.virtuallaboratory.service.http.VirtualLabUserTempServiceSoap
 * @generated
 */
public class VirtualLabUserTempSoap implements Serializable {
	public static VirtualLabUserTempSoap toSoapModel(VirtualLabUserTemp model) {
		VirtualLabUserTempSoap soapModel = new VirtualLabUserTempSoap();

		soapModel.setSeqNo(model.getSeqNo());
		soapModel.setVirtualLabId(model.getVirtualLabId());
		soapModel.setClassId(model.getClassId());
		soapModel.setUserStudentNumber(model.getUserStudentNumber());
		soapModel.setUserName(model.getUserName());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static VirtualLabUserTempSoap[] toSoapModels(
		VirtualLabUserTemp[] models) {
		VirtualLabUserTempSoap[] soapModels = new VirtualLabUserTempSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VirtualLabUserTempSoap[][] toSoapModels(
		VirtualLabUserTemp[][] models) {
		VirtualLabUserTempSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VirtualLabUserTempSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VirtualLabUserTempSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VirtualLabUserTempSoap[] toSoapModels(
		List<VirtualLabUserTemp> models) {
		List<VirtualLabUserTempSoap> soapModels = new ArrayList<VirtualLabUserTempSoap>(models.size());

		for (VirtualLabUserTemp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VirtualLabUserTempSoap[soapModels.size()]);
	}

	public VirtualLabUserTempSoap() {
	}

	public VirtualLabUserTempPK getPrimaryKey() {
		return new VirtualLabUserTempPK(_seqNo, _virtualLabId, _classId);
	}

	public void setPrimaryKey(VirtualLabUserTempPK pk) {
		setSeqNo(pk.seqNo);
		setVirtualLabId(pk.virtualLabId);
		setClassId(pk.classId);
	}

	public long getSeqNo() {
		return _seqNo;
	}

	public void setSeqNo(long seqNo) {
		_seqNo = seqNo;
	}

	public long getVirtualLabId() {
		return _virtualLabId;
	}

	public void setVirtualLabId(long virtualLabId) {
		_virtualLabId = virtualLabId;
	}

	public long getClassId() {
		return _classId;
	}

	public void setClassId(long classId) {
		_classId = classId;
	}

	public String getUserStudentNumber() {
		return _userStudentNumber;
	}

	public void setUserStudentNumber(String userStudentNumber) {
		_userStudentNumber = userStudentNumber;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	private long _seqNo;
	private long _virtualLabId;
	private long _classId;
	private String _userStudentNumber;
	private String _userName;
	private boolean _status;
}