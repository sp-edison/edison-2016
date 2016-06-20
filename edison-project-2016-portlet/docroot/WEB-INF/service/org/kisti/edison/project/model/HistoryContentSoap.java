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

package org.kisti.edison.project.model;

import org.kisti.edison.project.service.persistence.HistoryContentPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.project.service.http.HistoryContentServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.project.service.http.HistoryContentServiceSoap
 * @generated
 */
public class HistoryContentSoap implements Serializable {
	public static HistoryContentSoap toSoapModel(HistoryContent model) {
		HistoryContentSoap soapModel = new HistoryContentSoap();

		soapModel.setContentSeq(model.getContentSeq());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setProjectCategoryId(model.getProjectCategoryId());
		soapModel.setContentDiv(model.getContentDiv());
		soapModel.setTitle(model.getTitle());
		soapModel.setInsertId(model.getInsertId());
		soapModel.setInsertDate(model.getInsertDate());
		soapModel.setUpdateId(model.getUpdateId());
		soapModel.setUpdateDate(model.getUpdateDate());

		return soapModel;
	}

	public static HistoryContentSoap[] toSoapModels(HistoryContent[] models) {
		HistoryContentSoap[] soapModels = new HistoryContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HistoryContentSoap[][] toSoapModels(HistoryContent[][] models) {
		HistoryContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HistoryContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HistoryContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HistoryContentSoap[] toSoapModels(List<HistoryContent> models) {
		List<HistoryContentSoap> soapModels = new ArrayList<HistoryContentSoap>(models.size());

		for (HistoryContent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HistoryContentSoap[soapModels.size()]);
	}

	public HistoryContentSoap() {
	}

	public HistoryContentPK getPrimaryKey() {
		return new HistoryContentPK(_contentSeq, _groupId, _projectCategoryId);
	}

	public void setPrimaryKey(HistoryContentPK pk) {
		setContentSeq(pk.contentSeq);
		setGroupId(pk.groupId);
		setProjectCategoryId(pk.projectCategoryId);
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

	public long getProjectCategoryId() {
		return _projectCategoryId;
	}

	public void setProjectCategoryId(long projectCategoryId) {
		_projectCategoryId = projectCategoryId;
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
	private long _projectCategoryId;
	private long _contentDiv;
	private String _title;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
}