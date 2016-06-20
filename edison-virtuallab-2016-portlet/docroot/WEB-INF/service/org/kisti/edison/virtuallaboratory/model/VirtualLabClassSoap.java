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
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.virtuallaboratory.service.http.VirtualLabClassServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.virtuallaboratory.service.http.VirtualLabClassServiceSoap
 * @generated
 */
public class VirtualLabClassSoap implements Serializable {
	public static VirtualLabClassSoap toSoapModel(VirtualLabClass model) {
		VirtualLabClassSoap soapModel = new VirtualLabClassSoap();

		soapModel.setClassId(model.getClassId());
		soapModel.setClassTitle(model.getClassTitle());
		soapModel.setClassStartDt(model.getClassStartDt());
		soapModel.setClassEndDt(model.getClassEndDt());
		soapModel.setClassUseYn(model.getClassUseYn());
		soapModel.setClassDescription(model.getClassDescription());
		soapModel.setClassPersonnel(model.getClassPersonnel());
		soapModel.setClassCreateDt(model.getClassCreateDt());
		soapModel.setClassUpdateDt(model.getClassUpdateDt());
		soapModel.setVirtualClassCd(model.getVirtualClassCd());

		return soapModel;
	}

	public static VirtualLabClassSoap[] toSoapModels(VirtualLabClass[] models) {
		VirtualLabClassSoap[] soapModels = new VirtualLabClassSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VirtualLabClassSoap[][] toSoapModels(
		VirtualLabClass[][] models) {
		VirtualLabClassSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VirtualLabClassSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VirtualLabClassSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VirtualLabClassSoap[] toSoapModels(
		List<VirtualLabClass> models) {
		List<VirtualLabClassSoap> soapModels = new ArrayList<VirtualLabClassSoap>(models.size());

		for (VirtualLabClass model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VirtualLabClassSoap[soapModels.size()]);
	}

	public VirtualLabClassSoap() {
	}

	public long getPrimaryKey() {
		return _classId;
	}

	public void setPrimaryKey(long pk) {
		setClassId(pk);
	}

	public long getClassId() {
		return _classId;
	}

	public void setClassId(long classId) {
		_classId = classId;
	}

	public String getClassTitle() {
		return _classTitle;
	}

	public void setClassTitle(String classTitle) {
		_classTitle = classTitle;
	}

	public String getClassStartDt() {
		return _classStartDt;
	}

	public void setClassStartDt(String classStartDt) {
		_classStartDt = classStartDt;
	}

	public String getClassEndDt() {
		return _classEndDt;
	}

	public void setClassEndDt(String classEndDt) {
		_classEndDt = classEndDt;
	}

	public String getClassUseYn() {
		return _classUseYn;
	}

	public void setClassUseYn(String classUseYn) {
		_classUseYn = classUseYn;
	}

	public String getClassDescription() {
		return _classDescription;
	}

	public void setClassDescription(String classDescription) {
		_classDescription = classDescription;
	}

	public int getClassPersonnel() {
		return _classPersonnel;
	}

	public void setClassPersonnel(int classPersonnel) {
		_classPersonnel = classPersonnel;
	}

	public Date getClassCreateDt() {
		return _classCreateDt;
	}

	public void setClassCreateDt(Date classCreateDt) {
		_classCreateDt = classCreateDt;
	}

	public Date getClassUpdateDt() {
		return _classUpdateDt;
	}

	public void setClassUpdateDt(Date classUpdateDt) {
		_classUpdateDt = classUpdateDt;
	}

	public String getVirtualClassCd() {
		return _virtualClassCd;
	}

	public void setVirtualClassCd(String virtualClassCd) {
		_virtualClassCd = virtualClassCd;
	}

	private long _classId;
	private String _classTitle;
	private String _classStartDt;
	private String _classEndDt;
	private String _classUseYn;
	private String _classDescription;
	private int _classPersonnel;
	private Date _classCreateDt;
	private Date _classUpdateDt;
	private String _virtualClassCd;
}