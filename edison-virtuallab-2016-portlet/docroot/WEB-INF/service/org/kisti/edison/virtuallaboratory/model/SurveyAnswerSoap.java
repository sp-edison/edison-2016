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
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.virtuallaboratory.service.http.SurveyAnswerServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.virtuallaboratory.service.http.SurveyAnswerServiceSoap
 * @generated
 */
public class SurveyAnswerSoap implements Serializable {
	public static SurveyAnswerSoap toSoapModel(SurveyAnswer model) {
		SurveyAnswerSoap soapModel = new SurveyAnswerSoap();

		soapModel.setSurveyAnswerId(model.getSurveyAnswerId());
		soapModel.setUserId(model.getUserId());
		soapModel.setVirtualLabId(model.getVirtualLabId());
		soapModel.setClassId(model.getClassId());
		soapModel.setSubjectivityAnswer(model.getSubjectivityAnswer());
		soapModel.setObjecttivityAnswer(model.getObjecttivityAnswer());
		soapModel.setAnswerDate(model.getAnswerDate());

		return soapModel;
	}

	public static SurveyAnswerSoap[] toSoapModels(SurveyAnswer[] models) {
		SurveyAnswerSoap[] soapModels = new SurveyAnswerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SurveyAnswerSoap[][] toSoapModels(SurveyAnswer[][] models) {
		SurveyAnswerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SurveyAnswerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SurveyAnswerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SurveyAnswerSoap[] toSoapModels(List<SurveyAnswer> models) {
		List<SurveyAnswerSoap> soapModels = new ArrayList<SurveyAnswerSoap>(models.size());

		for (SurveyAnswer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SurveyAnswerSoap[soapModels.size()]);
	}

	public SurveyAnswerSoap() {
	}

	public long getPrimaryKey() {
		return _SurveyAnswerId;
	}

	public void setPrimaryKey(long pk) {
		setSurveyAnswerId(pk);
	}

	public long getSurveyAnswerId() {
		return _SurveyAnswerId;
	}

	public void setSurveyAnswerId(long SurveyAnswerId) {
		_SurveyAnswerId = SurveyAnswerId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public String getSubjectivityAnswer() {
		return _subjectivityAnswer;
	}

	public void setSubjectivityAnswer(String subjectivityAnswer) {
		_subjectivityAnswer = subjectivityAnswer;
	}

	public String getObjecttivityAnswer() {
		return _objecttivityAnswer;
	}

	public void setObjecttivityAnswer(String objecttivityAnswer) {
		_objecttivityAnswer = objecttivityAnswer;
	}

	public Date getAnswerDate() {
		return _answerDate;
	}

	public void setAnswerDate(Date answerDate) {
		_answerDate = answerDate;
	}

	private long _SurveyAnswerId;
	private long _userId;
	private long _virtualLabId;
	private long _classId;
	private String _subjectivityAnswer;
	private String _objecttivityAnswer;
	private Date _answerDate;
}