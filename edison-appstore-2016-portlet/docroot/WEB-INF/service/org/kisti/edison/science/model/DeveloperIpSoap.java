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

import org.kisti.edison.science.service.persistence.DeveloperIpPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.science.service.http.DeveloperIpServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.http.DeveloperIpServiceSoap
 * @generated
 */
public class DeveloperIpSoap implements Serializable {
	public static DeveloperIpSoap toSoapModel(DeveloperIp model) {
		DeveloperIpSoap soapModel = new DeveloperIpSoap();

		soapModel.setIpSeq(model.getIpSeq());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setIp1(model.getIp1());
		soapModel.setIp2(model.getIp2());
		soapModel.setIp3(model.getIp3());
		soapModel.setIp4(model.getIp4());
		soapModel.setInsertId(model.getInsertId());
		soapModel.setInsertDate(model.getInsertDate());
		soapModel.setUpdateId(model.getUpdateId());
		soapModel.setUpdateDate(model.getUpdateDate());

		return soapModel;
	}

	public static DeveloperIpSoap[] toSoapModels(DeveloperIp[] models) {
		DeveloperIpSoap[] soapModels = new DeveloperIpSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DeveloperIpSoap[][] toSoapModels(DeveloperIp[][] models) {
		DeveloperIpSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DeveloperIpSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DeveloperIpSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DeveloperIpSoap[] toSoapModels(List<DeveloperIp> models) {
		List<DeveloperIpSoap> soapModels = new ArrayList<DeveloperIpSoap>(models.size());

		for (DeveloperIp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DeveloperIpSoap[soapModels.size()]);
	}

	public DeveloperIpSoap() {
	}

	public DeveloperIpPK getPrimaryKey() {
		return new DeveloperIpPK(_ipSeq, _userId, _groupId);
	}

	public void setPrimaryKey(DeveloperIpPK pk) {
		setIpSeq(pk.ipSeq);
		setUserId(pk.userId);
		setGroupId(pk.groupId);
	}

	public long getIpSeq() {
		return _ipSeq;
	}

	public void setIpSeq(long ipSeq) {
		_ipSeq = ipSeq;
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

	public String getIp1() {
		return _ip1;
	}

	public void setIp1(String ip1) {
		_ip1 = ip1;
	}

	public String getIp2() {
		return _ip2;
	}

	public void setIp2(String ip2) {
		_ip2 = ip2;
	}

	public String getIp3() {
		return _ip3;
	}

	public void setIp3(String ip3) {
		_ip3 = ip3;
	}

	public String getIp4() {
		return _ip4;
	}

	public void setIp4(String ip4) {
		_ip4 = ip4;
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

	private long _ipSeq;
	private long _userId;
	private long _groupId;
	private String _ip1;
	private String _ip2;
	private String _ip3;
	private String _ip4;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
}