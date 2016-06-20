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

import org.kisti.edison.content.service.persistence.OrgImgContentPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.content.service.http.OrgImgContentServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.content.service.http.OrgImgContentServiceSoap
 * @generated
 */
public class OrgImgContentSoap implements Serializable {
	public static OrgImgContentSoap toSoapModel(OrgImgContent model) {
		OrgImgContentSoap soapModel = new OrgImgContentSoap();

		soapModel.setOrgImgSeq(model.getOrgImgSeq());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setOrder(model.getOrder());
		soapModel.setOrgNm(model.getOrgNm());
		soapModel.setOrgLink(model.getOrgLink());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setInsertId(model.getInsertId());
		soapModel.setInsertDate(model.getInsertDate());
		soapModel.setUpdateId(model.getUpdateId());
		soapModel.setUpdateDate(model.getUpdateDate());

		return soapModel;
	}

	public static OrgImgContentSoap[] toSoapModels(OrgImgContent[] models) {
		OrgImgContentSoap[] soapModels = new OrgImgContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrgImgContentSoap[][] toSoapModels(OrgImgContent[][] models) {
		OrgImgContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrgImgContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrgImgContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrgImgContentSoap[] toSoapModels(List<OrgImgContent> models) {
		List<OrgImgContentSoap> soapModels = new ArrayList<OrgImgContentSoap>(models.size());

		for (OrgImgContent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrgImgContentSoap[soapModels.size()]);
	}

	public OrgImgContentSoap() {
	}

	public OrgImgContentPK getPrimaryKey() {
		return new OrgImgContentPK(_orgImgSeq, _groupId);
	}

	public void setPrimaryKey(OrgImgContentPK pk) {
		setOrgImgSeq(pk.orgImgSeq);
		setGroupId(pk.groupId);
	}

	public long getOrgImgSeq() {
		return _orgImgSeq;
	}

	public void setOrgImgSeq(long orgImgSeq) {
		_orgImgSeq = orgImgSeq;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getOrder() {
		return _order;
	}

	public void setOrder(long order) {
		_order = order;
	}

	public String getOrgNm() {
		return _orgNm;
	}

	public void setOrgNm(String orgNm) {
		_orgNm = orgNm;
	}

	public String getOrgLink() {
		return _orgLink;
	}

	public void setOrgLink(String orgLink) {
		_orgLink = orgLink;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
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

	private long _orgImgSeq;
	private long _groupId;
	private long _order;
	private String _orgNm;
	private String _orgLink;
	private long _fileEntryId;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
}