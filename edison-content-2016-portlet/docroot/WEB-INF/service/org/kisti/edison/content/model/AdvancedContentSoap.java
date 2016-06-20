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

import org.kisti.edison.content.service.persistence.AdvancedContentPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.content.service.http.AdvancedContentServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.content.service.http.AdvancedContentServiceSoap
 * @generated
 */
public class AdvancedContentSoap implements Serializable {
	public static AdvancedContentSoap toSoapModel(AdvancedContent model) {
		AdvancedContentSoap soapModel = new AdvancedContentSoap();

		soapModel.setContentSeq(model.getContentSeq());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTitle(model.getTitle());
		soapModel.setResume(model.getResume());
		soapModel.setContentFilePath(model.getContentFilePath());
		soapModel.setContentFileNm(model.getContentFileNm());
		soapModel.setContentStartFileNm(model.getContentStartFileNm());
		soapModel.setServiceLanguage(model.getServiceLanguage());
		soapModel.setViewCnt(model.getViewCnt());
		soapModel.setInsertId(model.getInsertId());
		soapModel.setInsertDate(model.getInsertDate());
		soapModel.setUpdateId(model.getUpdateId());
		soapModel.setUpdateDate(model.getUpdateDate());

		return soapModel;
	}

	public static AdvancedContentSoap[] toSoapModels(AdvancedContent[] models) {
		AdvancedContentSoap[] soapModels = new AdvancedContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AdvancedContentSoap[][] toSoapModels(
		AdvancedContent[][] models) {
		AdvancedContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AdvancedContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AdvancedContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AdvancedContentSoap[] toSoapModels(
		List<AdvancedContent> models) {
		List<AdvancedContentSoap> soapModels = new ArrayList<AdvancedContentSoap>(models.size());

		for (AdvancedContent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AdvancedContentSoap[soapModels.size()]);
	}

	public AdvancedContentSoap() {
	}

	public AdvancedContentPK getPrimaryKey() {
		return new AdvancedContentPK(_contentSeq, _groupId);
	}

	public void setPrimaryKey(AdvancedContentPK pk) {
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getResume() {
		return _resume;
	}

	public void setResume(String resume) {
		_resume = resume;
	}

	public String getContentFilePath() {
		return _contentFilePath;
	}

	public void setContentFilePath(String contentFilePath) {
		_contentFilePath = contentFilePath;
	}

	public String getContentFileNm() {
		return _contentFileNm;
	}

	public void setContentFileNm(String contentFileNm) {
		_contentFileNm = contentFileNm;
	}

	public String getContentStartFileNm() {
		return _contentStartFileNm;
	}

	public void setContentStartFileNm(String contentStartFileNm) {
		_contentStartFileNm = contentStartFileNm;
	}

	public String getServiceLanguage() {
		return _serviceLanguage;
	}

	public void setServiceLanguage(String serviceLanguage) {
		_serviceLanguage = serviceLanguage;
	}

	public long getViewCnt() {
		return _viewCnt;
	}

	public void setViewCnt(long viewCnt) {
		_viewCnt = viewCnt;
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
	private String _title;
	private String _resume;
	private String _contentFilePath;
	private String _contentFileNm;
	private String _contentStartFileNm;
	private String _serviceLanguage;
	private long _viewCnt;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
}