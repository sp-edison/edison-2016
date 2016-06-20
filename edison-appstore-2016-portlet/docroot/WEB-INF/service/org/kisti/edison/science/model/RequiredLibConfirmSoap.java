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

import org.kisti.edison.science.service.persistence.RequiredLibConfirmPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.science.service.http.RequiredLibConfirmServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.http.RequiredLibConfirmServiceSoap
 * @generated
 */
public class RequiredLibConfirmSoap implements Serializable {
	public static RequiredLibConfirmSoap toSoapModel(RequiredLibConfirm model) {
		RequiredLibConfirmSoap soapModel = new RequiredLibConfirmSoap();

		soapModel.setRequiredLibId(model.getRequiredLibId());
		soapModel.setScienceAppId(model.getScienceAppId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setRequiredDate(model.getRequiredDate());
		soapModel.setConfirmDate(model.getConfirmDate());
		soapModel.setLibraryName(model.getLibraryName());
		soapModel.setLibraryVersion(model.getLibraryVersion());
		soapModel.setRequiredContent(model.getRequiredContent());
		soapModel.setRequiredState(model.getRequiredState());
		soapModel.setConfirmContent(model.getConfirmContent());

		return soapModel;
	}

	public static RequiredLibConfirmSoap[] toSoapModels(
		RequiredLibConfirm[] models) {
		RequiredLibConfirmSoap[] soapModels = new RequiredLibConfirmSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RequiredLibConfirmSoap[][] toSoapModels(
		RequiredLibConfirm[][] models) {
		RequiredLibConfirmSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RequiredLibConfirmSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RequiredLibConfirmSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RequiredLibConfirmSoap[] toSoapModels(
		List<RequiredLibConfirm> models) {
		List<RequiredLibConfirmSoap> soapModels = new ArrayList<RequiredLibConfirmSoap>(models.size());

		for (RequiredLibConfirm model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RequiredLibConfirmSoap[soapModels.size()]);
	}

	public RequiredLibConfirmSoap() {
	}

	public RequiredLibConfirmPK getPrimaryKey() {
		return new RequiredLibConfirmPK(_requiredLibId, _scienceAppId);
	}

	public void setPrimaryKey(RequiredLibConfirmPK pk) {
		setRequiredLibId(pk.requiredLibId);
		setScienceAppId(pk.scienceAppId);
	}

	public long getRequiredLibId() {
		return _requiredLibId;
	}

	public void setRequiredLibId(long requiredLibId) {
		_requiredLibId = requiredLibId;
	}

	public long getScienceAppId() {
		return _scienceAppId;
	}

	public void setScienceAppId(long scienceAppId) {
		_scienceAppId = scienceAppId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getRequiredDate() {
		return _requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		_requiredDate = requiredDate;
	}

	public Date getConfirmDate() {
		return _confirmDate;
	}

	public void setConfirmDate(Date confirmDate) {
		_confirmDate = confirmDate;
	}

	public String getLibraryName() {
		return _libraryName;
	}

	public void setLibraryName(String libraryName) {
		_libraryName = libraryName;
	}

	public String getLibraryVersion() {
		return _libraryVersion;
	}

	public void setLibraryVersion(String libraryVersion) {
		_libraryVersion = libraryVersion;
	}

	public String getRequiredContent() {
		return _requiredContent;
	}

	public void setRequiredContent(String requiredContent) {
		_requiredContent = requiredContent;
	}

	public String getRequiredState() {
		return _requiredState;
	}

	public void setRequiredState(String requiredState) {
		_requiredState = requiredState;
	}

	public String getConfirmContent() {
		return _confirmContent;
	}

	public void setConfirmContent(String confirmContent) {
		_confirmContent = confirmContent;
	}

	private long _requiredLibId;
	private long _scienceAppId;
	private long _companyId;
	private long _userId;
	private Date _requiredDate;
	private Date _confirmDate;
	private String _libraryName;
	private String _libraryVersion;
	private String _requiredContent;
	private String _requiredState;
	private String _confirmContent;
}