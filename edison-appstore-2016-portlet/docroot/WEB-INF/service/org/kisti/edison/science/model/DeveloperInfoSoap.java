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

import org.kisti.edison.science.service.persistence.DeveloperInfoPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.science.service.http.DeveloperInfoServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.science.service.http.DeveloperInfoServiceSoap
 * @generated
 */
public class DeveloperInfoSoap implements Serializable {
	public static DeveloperInfoSoap toSoapModel(DeveloperInfo model) {
		DeveloperInfoSoap soapModel = new DeveloperInfoSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setScreenName(model.getScreenName());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setUniversityField(model.getUniversityField());
		soapModel.setMajorField(model.getMajorField());
		soapModel.setUseStart(model.getUseStart());
		soapModel.setUseEnd(model.getUseEnd());
		soapModel.setDeveloperSort(model.getDeveloperSort());
		soapModel.setLanguageFortran(model.getLanguageFortran());
		soapModel.setLanguageCpp(model.getLanguageCpp());
		soapModel.setLanguagePython(model.getLanguagePython());
		soapModel.setLanguageJava(model.getLanguageJava());
		soapModel.setLanguageOther(model.getLanguageOther());
		soapModel.setLanguageOtherDescription(model.getLanguageOtherDescription());
		soapModel.setRem(model.getRem());
		soapModel.setAgreementYn(model.getAgreementYn());
		soapModel.setWrittenOathLogical(model.getWrittenOathLogical());
		soapModel.setWrittenOathPhysical(model.getWrittenOathPhysical());
		soapModel.setDetailIp(model.getDetailIp());
		soapModel.setDetailOs(model.getDetailOs());
		soapModel.setDetailCpu(model.getDetailCpu());
		soapModel.setDetailStorate(model.getDetailStorate());
		soapModel.setDetailLibrary(model.getDetailLibrary());
		soapModel.setInsertId(model.getInsertId());
		soapModel.setInsertDate(model.getInsertDate());
		soapModel.setUpdateId(model.getUpdateId());
		soapModel.setUpdateDate(model.getUpdateDate());
		soapModel.setEtc(model.getEtc());
		soapModel.setDeveloperId(model.getDeveloperId());
		soapModel.setDeveloperPassword(model.getDeveloperPassword());

		return soapModel;
	}

	public static DeveloperInfoSoap[] toSoapModels(DeveloperInfo[] models) {
		DeveloperInfoSoap[] soapModels = new DeveloperInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DeveloperInfoSoap[][] toSoapModels(DeveloperInfo[][] models) {
		DeveloperInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DeveloperInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DeveloperInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DeveloperInfoSoap[] toSoapModels(List<DeveloperInfo> models) {
		List<DeveloperInfoSoap> soapModels = new ArrayList<DeveloperInfoSoap>(models.size());

		for (DeveloperInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DeveloperInfoSoap[soapModels.size()]);
	}

	public DeveloperInfoSoap() {
	}

	public DeveloperInfoPK getPrimaryKey() {
		return new DeveloperInfoPK(_userId, _groupId);
	}

	public void setPrimaryKey(DeveloperInfoPK pk) {
		setUserId(pk.userId);
		setGroupId(pk.groupId);
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

	public String getScreenName() {
		return _screenName;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getUniversityField() {
		return _universityField;
	}

	public void setUniversityField(String universityField) {
		_universityField = universityField;
	}

	public String getMajorField() {
		return _majorField;
	}

	public void setMajorField(String majorField) {
		_majorField = majorField;
	}

	public String getUseStart() {
		return _useStart;
	}

	public void setUseStart(String useStart) {
		_useStart = useStart;
	}

	public String getUseEnd() {
		return _useEnd;
	}

	public void setUseEnd(String useEnd) {
		_useEnd = useEnd;
	}

	public String getDeveloperSort() {
		return _developerSort;
	}

	public void setDeveloperSort(String developerSort) {
		_developerSort = developerSort;
	}

	public boolean getLanguageFortran() {
		return _languageFortran;
	}

	public boolean isLanguageFortran() {
		return _languageFortran;
	}

	public void setLanguageFortran(boolean languageFortran) {
		_languageFortran = languageFortran;
	}

	public boolean getLanguageCpp() {
		return _languageCpp;
	}

	public boolean isLanguageCpp() {
		return _languageCpp;
	}

	public void setLanguageCpp(boolean languageCpp) {
		_languageCpp = languageCpp;
	}

	public boolean getLanguagePython() {
		return _languagePython;
	}

	public boolean isLanguagePython() {
		return _languagePython;
	}

	public void setLanguagePython(boolean languagePython) {
		_languagePython = languagePython;
	}

	public boolean getLanguageJava() {
		return _languageJava;
	}

	public boolean isLanguageJava() {
		return _languageJava;
	}

	public void setLanguageJava(boolean languageJava) {
		_languageJava = languageJava;
	}

	public boolean getLanguageOther() {
		return _languageOther;
	}

	public boolean isLanguageOther() {
		return _languageOther;
	}

	public void setLanguageOther(boolean languageOther) {
		_languageOther = languageOther;
	}

	public String getLanguageOtherDescription() {
		return _languageOtherDescription;
	}

	public void setLanguageOtherDescription(String languageOtherDescription) {
		_languageOtherDescription = languageOtherDescription;
	}

	public String getRem() {
		return _rem;
	}

	public void setRem(String rem) {
		_rem = rem;
	}

	public boolean getAgreementYn() {
		return _agreementYn;
	}

	public boolean isAgreementYn() {
		return _agreementYn;
	}

	public void setAgreementYn(boolean agreementYn) {
		_agreementYn = agreementYn;
	}

	public String getWrittenOathLogical() {
		return _writtenOathLogical;
	}

	public void setWrittenOathLogical(String writtenOathLogical) {
		_writtenOathLogical = writtenOathLogical;
	}

	public String getWrittenOathPhysical() {
		return _writtenOathPhysical;
	}

	public void setWrittenOathPhysical(String writtenOathPhysical) {
		_writtenOathPhysical = writtenOathPhysical;
	}

	public String getDetailIp() {
		return _detailIp;
	}

	public void setDetailIp(String detailIp) {
		_detailIp = detailIp;
	}

	public String getDetailOs() {
		return _detailOs;
	}

	public void setDetailOs(String detailOs) {
		_detailOs = detailOs;
	}

	public String getDetailCpu() {
		return _detailCpu;
	}

	public void setDetailCpu(String detailCpu) {
		_detailCpu = detailCpu;
	}

	public String getDetailStorate() {
		return _detailStorate;
	}

	public void setDetailStorate(String detailStorate) {
		_detailStorate = detailStorate;
	}

	public String getDetailLibrary() {
		return _detailLibrary;
	}

	public void setDetailLibrary(String detailLibrary) {
		_detailLibrary = detailLibrary;
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

	public String getEtc() {
		return _etc;
	}

	public void setEtc(String etc) {
		_etc = etc;
	}

	public String getDeveloperId() {
		return _developerId;
	}

	public void setDeveloperId(String developerId) {
		_developerId = developerId;
	}

	public String getDeveloperPassword() {
		return _developerPassword;
	}

	public void setDeveloperPassword(String developerPassword) {
		_developerPassword = developerPassword;
	}

	private long _userId;
	private long _groupId;
	private String _screenName;
	private String _firstName;
	private String _emailAddress;
	private String _universityField;
	private String _majorField;
	private String _useStart;
	private String _useEnd;
	private String _developerSort;
	private boolean _languageFortran;
	private boolean _languageCpp;
	private boolean _languagePython;
	private boolean _languageJava;
	private boolean _languageOther;
	private String _languageOtherDescription;
	private String _rem;
	private boolean _agreementYn;
	private String _writtenOathLogical;
	private String _writtenOathPhysical;
	private String _detailIp;
	private String _detailOs;
	private String _detailCpu;
	private String _detailStorate;
	private String _detailLibrary;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
	private String _etc;
	private String _developerId;
	private String _developerPassword;
}