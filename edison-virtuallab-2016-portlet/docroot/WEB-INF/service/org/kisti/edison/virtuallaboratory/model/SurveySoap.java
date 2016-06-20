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
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.virtuallaboratory.service.http.SurveyServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.virtuallaboratory.service.http.SurveyServiceSoap
 * @generated
 */
public class SurveySoap implements Serializable {
	public static SurveySoap toSoapModel(Survey model) {
		SurveySoap soapModel = new SurveySoap();

		soapModel.setSurveySeqNo(model.getSurveySeqNo());
		soapModel.setSurveyUseYn(model.getSurveyUseYn());
		soapModel.setSurveyTitle(model.getSurveyTitle());
		soapModel.setSurveyStartDate(model.getSurveyStartDate());
		soapModel.setSurveyEndDate(model.getSurveyEndDate());
		soapModel.setSurveyStatus(model.getSurveyStatus());
		soapModel.setSurveyCreateDate(model.getSurveyCreateDate());

		return soapModel;
	}

	public static SurveySoap[] toSoapModels(Survey[] models) {
		SurveySoap[] soapModels = new SurveySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SurveySoap[][] toSoapModels(Survey[][] models) {
		SurveySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SurveySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SurveySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SurveySoap[] toSoapModels(List<Survey> models) {
		List<SurveySoap> soapModels = new ArrayList<SurveySoap>(models.size());

		for (Survey model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SurveySoap[soapModels.size()]);
	}

	public SurveySoap() {
	}

	public long getPrimaryKey() {
		return _surveySeqNo;
	}

	public void setPrimaryKey(long pk) {
		setSurveySeqNo(pk);
	}

	public long getSurveySeqNo() {
		return _surveySeqNo;
	}

	public void setSurveySeqNo(long surveySeqNo) {
		_surveySeqNo = surveySeqNo;
	}

	public String getSurveyUseYn() {
		return _surveyUseYn;
	}

	public void setSurveyUseYn(String surveyUseYn) {
		_surveyUseYn = surveyUseYn;
	}

	public String getSurveyTitle() {
		return _surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		_surveyTitle = surveyTitle;
	}

	public String getSurveyStartDate() {
		return _surveyStartDate;
	}

	public void setSurveyStartDate(String surveyStartDate) {
		_surveyStartDate = surveyStartDate;
	}

	public String getSurveyEndDate() {
		return _surveyEndDate;
	}

	public void setSurveyEndDate(String surveyEndDate) {
		_surveyEndDate = surveyEndDate;
	}

	public String getSurveyStatus() {
		return _surveyStatus;
	}

	public void setSurveyStatus(String surveyStatus) {
		_surveyStatus = surveyStatus;
	}

	public Date getSurveyCreateDate() {
		return _surveyCreateDate;
	}

	public void setSurveyCreateDate(Date surveyCreateDate) {
		_surveyCreateDate = surveyCreateDate;
	}

	private long _surveySeqNo;
	private String _surveyUseYn;
	private String _surveyTitle;
	private String _surveyStartDate;
	private String _surveyEndDate;
	private String _surveyStatus;
	private Date _surveyCreateDate;
}