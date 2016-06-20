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

package org.kisti.edison.content.model;

import org.kisti.edison.content.service.persistence.GeneralContentPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.content.service.http.GeneralContentServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.content.service.http.GeneralContentServiceSoap
 * @generated
 */
public class GeneralContentSoap implements Serializable {
	public static GeneralContentSoap toSoapModel(GeneralContent model) {
		GeneralContentSoap soapModel = new GeneralContentSoap();

		soapModel.setContentSeq(model.getContentSeq());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setContentDiv(model.getContentDiv());
		soapModel.setTitle(model.getTitle());
		soapModel.setDownloadCnt(model.getDownloadCnt());
		soapModel.setServiceLanguage(model.getServiceLanguage());
		soapModel.setProjectYn(model.getProjectYn());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setInsertId(model.getInsertId());
		soapModel.setInsertDate(model.getInsertDate());
		soapModel.setUpdateId(model.getUpdateId());
		soapModel.setUpdateDate(model.getUpdateDate());

		return soapModel;
	}

	public static GeneralContentSoap[] toSoapModels(GeneralContent[] models) {
		GeneralContentSoap[] soapModels = new GeneralContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeneralContentSoap[][] toSoapModels(GeneralContent[][] models) {
		GeneralContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeneralContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeneralContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeneralContentSoap[] toSoapModels(List<GeneralContent> models) {
		List<GeneralContentSoap> soapModels = new ArrayList<GeneralContentSoap>(models.size());

		for (GeneralContent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeneralContentSoap[soapModels.size()]);
	}

	public GeneralContentSoap() {
	}

	public GeneralContentPK getPrimaryKey() {
		return new GeneralContentPK(_contentSeq, _groupId);
	}

	public void setPrimaryKey(GeneralContentPK pk) {
		setContentSeq(pk.contentSeq);
		setGroupId(pk.groupId);
	}

	public long getContentSeq() {
		return _contentSeq;
	}

	public void setContentSeq(long contentSeq) {
		_contentSeq = contentSeq;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getContentDiv() {
		return _contentDiv;
	}

	public void setContentDiv(long contentDiv) {
		_contentDiv = contentDiv;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public long getDownloadCnt() {
		return _downloadCnt;
	}

	public void setDownloadCnt(long downloadCnt) {
		_downloadCnt = downloadCnt;
	}

	public String getServiceLanguage() {
		return _serviceLanguage;
	}

	public void setServiceLanguage(String serviceLanguage) {
		_serviceLanguage = serviceLanguage;
	}

	public String getProjectYn() {
		return _projectYn;
	}

	public void setProjectYn(String projectYn) {
		_projectYn = projectYn;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
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

	private long _contentSeq;
	private long _groupId;
	private long _contentDiv;
	private String _title;
	private long _downloadCnt;
	private String _serviceLanguage;
	private String _projectYn;
	private long _projectId;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
}