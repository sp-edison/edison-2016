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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.virtuallaboratory.service.http.SurveyQuestionServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.virtuallaboratory.service.http.SurveyQuestionServiceSoap
 * @generated
 */
public class SurveyQuestionSoap implements Serializable {
	public static SurveyQuestionSoap toSoapModel(SurveyQuestion model) {
		SurveyQuestionSoap soapModel = new SurveyQuestionSoap();

		soapModel.setQuestionSeqNo(model.getQuestionSeqNo());
		soapModel.setQuestionDivCd(model.getQuestionDivCd());
		soapModel.setQuestionTitle(model.getQuestionTitle());
		soapModel.setQuestion1(model.getQuestion1());
		soapModel.setQuestion2(model.getQuestion2());
		soapModel.setQuestion3(model.getQuestion3());
		soapModel.setQuestion4(model.getQuestion4());
		soapModel.setQuestion5(model.getQuestion5());
		soapModel.setQuestion6(model.getQuestion6());
		soapModel.setQuestion7(model.getQuestion7());
		soapModel.setQuestion8(model.getQuestion8());
		soapModel.setQuestion9(model.getQuestion9());
		soapModel.setQuestion10(model.getQuestion10());

		return soapModel;
	}

	public static SurveyQuestionSoap[] toSoapModels(SurveyQuestion[] models) {
		SurveyQuestionSoap[] soapModels = new SurveyQuestionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SurveyQuestionSoap[][] toSoapModels(SurveyQuestion[][] models) {
		SurveyQuestionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SurveyQuestionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SurveyQuestionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SurveyQuestionSoap[] toSoapModels(List<SurveyQuestion> models) {
		List<SurveyQuestionSoap> soapModels = new ArrayList<SurveyQuestionSoap>(models.size());

		for (SurveyQuestion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SurveyQuestionSoap[soapModels.size()]);
	}

	public SurveyQuestionSoap() {
	}

	public long getPrimaryKey() {
		return _questionSeqNo;
	}

	public void setPrimaryKey(long pk) {
		setQuestionSeqNo(pk);
	}

	public long getQuestionSeqNo() {
		return _questionSeqNo;
	}

	public void setQuestionSeqNo(long questionSeqNo) {
		_questionSeqNo = questionSeqNo;
	}

	public String getQuestionDivCd() {
		return _questionDivCd;
	}

	public void setQuestionDivCd(String questionDivCd) {
		_questionDivCd = questionDivCd;
	}

	public String getQuestionTitle() {
		return _questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		_questionTitle = questionTitle;
	}

	public String getQuestion1() {
		return _question1;
	}

	public void setQuestion1(String question1) {
		_question1 = question1;
	}

	public String getQuestion2() {
		return _question2;
	}

	public void setQuestion2(String question2) {
		_question2 = question2;
	}

	public String getQuestion3() {
		return _question3;
	}

	public void setQuestion3(String question3) {
		_question3 = question3;
	}

	public String getQuestion4() {
		return _question4;
	}

	public void setQuestion4(String question4) {
		_question4 = question4;
	}

	public String getQuestion5() {
		return _question5;
	}

	public void setQuestion5(String question5) {
		_question5 = question5;
	}

	public String getQuestion6() {
		return _question6;
	}

	public void setQuestion6(String question6) {
		_question6 = question6;
	}

	public String getQuestion7() {
		return _question7;
	}

	public void setQuestion7(String question7) {
		_question7 = question7;
	}

	public String getQuestion8() {
		return _question8;
	}

	public void setQuestion8(String question8) {
		_question8 = question8;
	}

	public String getQuestion9() {
		return _question9;
	}

	public void setQuestion9(String question9) {
		_question9 = question9;
	}

	public String getQuestion10() {
		return _question10;
	}

	public void setQuestion10(String question10) {
		_question10 = question10;
	}

	private long _questionSeqNo;
	private String _questionDivCd;
	private String _questionTitle;
	private String _question1;
	private String _question2;
	private String _question3;
	private String _question4;
	private String _question5;
	private String _question6;
	private String _question7;
	private String _question8;
	private String _question9;
	private String _question10;
}