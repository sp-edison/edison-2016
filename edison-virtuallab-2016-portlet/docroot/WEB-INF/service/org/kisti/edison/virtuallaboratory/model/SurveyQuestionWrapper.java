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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SurveyQuestion}.
 * </p>
 *
 * @author EDISON
 * @see SurveyQuestion
 * @generated
 */
public class SurveyQuestionWrapper implements SurveyQuestion,
	ModelWrapper<SurveyQuestion> {
	public SurveyQuestionWrapper(SurveyQuestion surveyQuestion) {
		_surveyQuestion = surveyQuestion;
	}

	@Override
	public Class<?> getModelClass() {
		return SurveyQuestion.class;
	}

	@Override
	public String getModelClassName() {
		return SurveyQuestion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("questionSeqNo", getQuestionSeqNo());
		attributes.put("questionDivCd", getQuestionDivCd());
		attributes.put("questionTitle", getQuestionTitle());
		attributes.put("question1", getQuestion1());
		attributes.put("question2", getQuestion2());
		attributes.put("question3", getQuestion3());
		attributes.put("question4", getQuestion4());
		attributes.put("question5", getQuestion5());
		attributes.put("question6", getQuestion6());
		attributes.put("question7", getQuestion7());
		attributes.put("question8", getQuestion8());
		attributes.put("question9", getQuestion9());
		attributes.put("question10", getQuestion10());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long questionSeqNo = (Long)attributes.get("questionSeqNo");

		if (questionSeqNo != null) {
			setQuestionSeqNo(questionSeqNo);
		}

		String questionDivCd = (String)attributes.get("questionDivCd");

		if (questionDivCd != null) {
			setQuestionDivCd(questionDivCd);
		}

		String questionTitle = (String)attributes.get("questionTitle");

		if (questionTitle != null) {
			setQuestionTitle(questionTitle);
		}

		String question1 = (String)attributes.get("question1");

		if (question1 != null) {
			setQuestion1(question1);
		}

		String question2 = (String)attributes.get("question2");

		if (question2 != null) {
			setQuestion2(question2);
		}

		String question3 = (String)attributes.get("question3");

		if (question3 != null) {
			setQuestion3(question3);
		}

		String question4 = (String)attributes.get("question4");

		if (question4 != null) {
			setQuestion4(question4);
		}

		String question5 = (String)attributes.get("question5");

		if (question5 != null) {
			setQuestion5(question5);
		}

		String question6 = (String)attributes.get("question6");

		if (question6 != null) {
			setQuestion6(question6);
		}

		String question7 = (String)attributes.get("question7");

		if (question7 != null) {
			setQuestion7(question7);
		}

		String question8 = (String)attributes.get("question8");

		if (question8 != null) {
			setQuestion8(question8);
		}

		String question9 = (String)attributes.get("question9");

		if (question9 != null) {
			setQuestion9(question9);
		}

		String question10 = (String)attributes.get("question10");

		if (question10 != null) {
			setQuestion10(question10);
		}
	}

	/**
	* Returns the primary key of this survey question.
	*
	* @return the primary key of this survey question
	*/
	@Override
	public long getPrimaryKey() {
		return _surveyQuestion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this survey question.
	*
	* @param primaryKey the primary key of this survey question
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_surveyQuestion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the question seq no of this survey question.
	*
	* @return the question seq no of this survey question
	*/
	@Override
	public long getQuestionSeqNo() {
		return _surveyQuestion.getQuestionSeqNo();
	}

	/**
	* Sets the question seq no of this survey question.
	*
	* @param questionSeqNo the question seq no of this survey question
	*/
	@Override
	public void setQuestionSeqNo(long questionSeqNo) {
		_surveyQuestion.setQuestionSeqNo(questionSeqNo);
	}

	/**
	* Returns the question div cd of this survey question.
	*
	* @return the question div cd of this survey question
	*/
	@Override
	public java.lang.String getQuestionDivCd() {
		return _surveyQuestion.getQuestionDivCd();
	}

	/**
	* Sets the question div cd of this survey question.
	*
	* @param questionDivCd the question div cd of this survey question
	*/
	@Override
	public void setQuestionDivCd(java.lang.String questionDivCd) {
		_surveyQuestion.setQuestionDivCd(questionDivCd);
	}

	/**
	* Returns the question title of this survey question.
	*
	* @return the question title of this survey question
	*/
	@Override
	public java.lang.String getQuestionTitle() {
		return _surveyQuestion.getQuestionTitle();
	}

	/**
	* Returns the localized question title of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized question title of this survey question
	*/
	@Override
	public java.lang.String getQuestionTitle(java.util.Locale locale) {
		return _surveyQuestion.getQuestionTitle(locale);
	}

	/**
	* Returns the localized question title of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question title of this survey question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getQuestionTitle(java.util.Locale locale,
		boolean useDefault) {
		return _surveyQuestion.getQuestionTitle(locale, useDefault);
	}

	/**
	* Returns the localized question title of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized question title of this survey question
	*/
	@Override
	public java.lang.String getQuestionTitle(java.lang.String languageId) {
		return _surveyQuestion.getQuestionTitle(languageId);
	}

	/**
	* Returns the localized question title of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question title of this survey question
	*/
	@Override
	public java.lang.String getQuestionTitle(java.lang.String languageId,
		boolean useDefault) {
		return _surveyQuestion.getQuestionTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getQuestionTitleCurrentLanguageId() {
		return _surveyQuestion.getQuestionTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getQuestionTitleCurrentValue() {
		return _surveyQuestion.getQuestionTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized question titles of this survey question.
	*
	* @return the locales and localized question titles of this survey question
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getQuestionTitleMap() {
		return _surveyQuestion.getQuestionTitleMap();
	}

	/**
	* Sets the question title of this survey question.
	*
	* @param questionTitle the question title of this survey question
	*/
	@Override
	public void setQuestionTitle(java.lang.String questionTitle) {
		_surveyQuestion.setQuestionTitle(questionTitle);
	}

	/**
	* Sets the localized question title of this survey question in the language.
	*
	* @param questionTitle the localized question title of this survey question
	* @param locale the locale of the language
	*/
	@Override
	public void setQuestionTitle(java.lang.String questionTitle,
		java.util.Locale locale) {
		_surveyQuestion.setQuestionTitle(questionTitle, locale);
	}

	/**
	* Sets the localized question title of this survey question in the language, and sets the default locale.
	*
	* @param questionTitle the localized question title of this survey question
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestionTitle(java.lang.String questionTitle,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestionTitle(questionTitle, locale, defaultLocale);
	}

	@Override
	public void setQuestionTitleCurrentLanguageId(java.lang.String languageId) {
		_surveyQuestion.setQuestionTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized question titles of this survey question from the map of locales and localized question titles.
	*
	* @param questionTitleMap the locales and localized question titles of this survey question
	*/
	@Override
	public void setQuestionTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> questionTitleMap) {
		_surveyQuestion.setQuestionTitleMap(questionTitleMap);
	}

	/**
	* Sets the localized question titles of this survey question from the map of locales and localized question titles, and sets the default locale.
	*
	* @param questionTitleMap the locales and localized question titles of this survey question
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestionTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> questionTitleMap,
		java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestionTitleMap(questionTitleMap, defaultLocale);
	}

	/**
	* Returns the question1 of this survey question.
	*
	* @return the question1 of this survey question
	*/
	@Override
	public java.lang.String getQuestion1() {
		return _surveyQuestion.getQuestion1();
	}

	/**
	* Returns the localized question1 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized question1 of this survey question
	*/
	@Override
	public java.lang.String getQuestion1(java.util.Locale locale) {
		return _surveyQuestion.getQuestion1(locale);
	}

	/**
	* Returns the localized question1 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question1 of this survey question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getQuestion1(java.util.Locale locale,
		boolean useDefault) {
		return _surveyQuestion.getQuestion1(locale, useDefault);
	}

	/**
	* Returns the localized question1 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized question1 of this survey question
	*/
	@Override
	public java.lang.String getQuestion1(java.lang.String languageId) {
		return _surveyQuestion.getQuestion1(languageId);
	}

	/**
	* Returns the localized question1 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question1 of this survey question
	*/
	@Override
	public java.lang.String getQuestion1(java.lang.String languageId,
		boolean useDefault) {
		return _surveyQuestion.getQuestion1(languageId, useDefault);
	}

	@Override
	public java.lang.String getQuestion1CurrentLanguageId() {
		return _surveyQuestion.getQuestion1CurrentLanguageId();
	}

	@Override
	public java.lang.String getQuestion1CurrentValue() {
		return _surveyQuestion.getQuestion1CurrentValue();
	}

	/**
	* Returns a map of the locales and localized question1s of this survey question.
	*
	* @return the locales and localized question1s of this survey question
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getQuestion1Map() {
		return _surveyQuestion.getQuestion1Map();
	}

	/**
	* Sets the question1 of this survey question.
	*
	* @param question1 the question1 of this survey question
	*/
	@Override
	public void setQuestion1(java.lang.String question1) {
		_surveyQuestion.setQuestion1(question1);
	}

	/**
	* Sets the localized question1 of this survey question in the language.
	*
	* @param question1 the localized question1 of this survey question
	* @param locale the locale of the language
	*/
	@Override
	public void setQuestion1(java.lang.String question1, java.util.Locale locale) {
		_surveyQuestion.setQuestion1(question1, locale);
	}

	/**
	* Sets the localized question1 of this survey question in the language, and sets the default locale.
	*
	* @param question1 the localized question1 of this survey question
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion1(java.lang.String question1,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion1(question1, locale, defaultLocale);
	}

	@Override
	public void setQuestion1CurrentLanguageId(java.lang.String languageId) {
		_surveyQuestion.setQuestion1CurrentLanguageId(languageId);
	}

	/**
	* Sets the localized question1s of this survey question from the map of locales and localized question1s.
	*
	* @param question1Map the locales and localized question1s of this survey question
	*/
	@Override
	public void setQuestion1Map(
		java.util.Map<java.util.Locale, java.lang.String> question1Map) {
		_surveyQuestion.setQuestion1Map(question1Map);
	}

	/**
	* Sets the localized question1s of this survey question from the map of locales and localized question1s, and sets the default locale.
	*
	* @param question1Map the locales and localized question1s of this survey question
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion1Map(
		java.util.Map<java.util.Locale, java.lang.String> question1Map,
		java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion1Map(question1Map, defaultLocale);
	}

	/**
	* Returns the question2 of this survey question.
	*
	* @return the question2 of this survey question
	*/
	@Override
	public java.lang.String getQuestion2() {
		return _surveyQuestion.getQuestion2();
	}

	/**
	* Returns the localized question2 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized question2 of this survey question
	*/
	@Override
	public java.lang.String getQuestion2(java.util.Locale locale) {
		return _surveyQuestion.getQuestion2(locale);
	}

	/**
	* Returns the localized question2 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question2 of this survey question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getQuestion2(java.util.Locale locale,
		boolean useDefault) {
		return _surveyQuestion.getQuestion2(locale, useDefault);
	}

	/**
	* Returns the localized question2 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized question2 of this survey question
	*/
	@Override
	public java.lang.String getQuestion2(java.lang.String languageId) {
		return _surveyQuestion.getQuestion2(languageId);
	}

	/**
	* Returns the localized question2 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question2 of this survey question
	*/
	@Override
	public java.lang.String getQuestion2(java.lang.String languageId,
		boolean useDefault) {
		return _surveyQuestion.getQuestion2(languageId, useDefault);
	}

	@Override
	public java.lang.String getQuestion2CurrentLanguageId() {
		return _surveyQuestion.getQuestion2CurrentLanguageId();
	}

	@Override
	public java.lang.String getQuestion2CurrentValue() {
		return _surveyQuestion.getQuestion2CurrentValue();
	}

	/**
	* Returns a map of the locales and localized question2s of this survey question.
	*
	* @return the locales and localized question2s of this survey question
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getQuestion2Map() {
		return _surveyQuestion.getQuestion2Map();
	}

	/**
	* Sets the question2 of this survey question.
	*
	* @param question2 the question2 of this survey question
	*/
	@Override
	public void setQuestion2(java.lang.String question2) {
		_surveyQuestion.setQuestion2(question2);
	}

	/**
	* Sets the localized question2 of this survey question in the language.
	*
	* @param question2 the localized question2 of this survey question
	* @param locale the locale of the language
	*/
	@Override
	public void setQuestion2(java.lang.String question2, java.util.Locale locale) {
		_surveyQuestion.setQuestion2(question2, locale);
	}

	/**
	* Sets the localized question2 of this survey question in the language, and sets the default locale.
	*
	* @param question2 the localized question2 of this survey question
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion2(java.lang.String question2,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion2(question2, locale, defaultLocale);
	}

	@Override
	public void setQuestion2CurrentLanguageId(java.lang.String languageId) {
		_surveyQuestion.setQuestion2CurrentLanguageId(languageId);
	}

	/**
	* Sets the localized question2s of this survey question from the map of locales and localized question2s.
	*
	* @param question2Map the locales and localized question2s of this survey question
	*/
	@Override
	public void setQuestion2Map(
		java.util.Map<java.util.Locale, java.lang.String> question2Map) {
		_surveyQuestion.setQuestion2Map(question2Map);
	}

	/**
	* Sets the localized question2s of this survey question from the map of locales and localized question2s, and sets the default locale.
	*
	* @param question2Map the locales and localized question2s of this survey question
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion2Map(
		java.util.Map<java.util.Locale, java.lang.String> question2Map,
		java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion2Map(question2Map, defaultLocale);
	}

	/**
	* Returns the question3 of this survey question.
	*
	* @return the question3 of this survey question
	*/
	@Override
	public java.lang.String getQuestion3() {
		return _surveyQuestion.getQuestion3();
	}

	/**
	* Returns the localized question3 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized question3 of this survey question
	*/
	@Override
	public java.lang.String getQuestion3(java.util.Locale locale) {
		return _surveyQuestion.getQuestion3(locale);
	}

	/**
	* Returns the localized question3 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question3 of this survey question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getQuestion3(java.util.Locale locale,
		boolean useDefault) {
		return _surveyQuestion.getQuestion3(locale, useDefault);
	}

	/**
	* Returns the localized question3 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized question3 of this survey question
	*/
	@Override
	public java.lang.String getQuestion3(java.lang.String languageId) {
		return _surveyQuestion.getQuestion3(languageId);
	}

	/**
	* Returns the localized question3 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question3 of this survey question
	*/
	@Override
	public java.lang.String getQuestion3(java.lang.String languageId,
		boolean useDefault) {
		return _surveyQuestion.getQuestion3(languageId, useDefault);
	}

	@Override
	public java.lang.String getQuestion3CurrentLanguageId() {
		return _surveyQuestion.getQuestion3CurrentLanguageId();
	}

	@Override
	public java.lang.String getQuestion3CurrentValue() {
		return _surveyQuestion.getQuestion3CurrentValue();
	}

	/**
	* Returns a map of the locales and localized question3s of this survey question.
	*
	* @return the locales and localized question3s of this survey question
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getQuestion3Map() {
		return _surveyQuestion.getQuestion3Map();
	}

	/**
	* Sets the question3 of this survey question.
	*
	* @param question3 the question3 of this survey question
	*/
	@Override
	public void setQuestion3(java.lang.String question3) {
		_surveyQuestion.setQuestion3(question3);
	}

	/**
	* Sets the localized question3 of this survey question in the language.
	*
	* @param question3 the localized question3 of this survey question
	* @param locale the locale of the language
	*/
	@Override
	public void setQuestion3(java.lang.String question3, java.util.Locale locale) {
		_surveyQuestion.setQuestion3(question3, locale);
	}

	/**
	* Sets the localized question3 of this survey question in the language, and sets the default locale.
	*
	* @param question3 the localized question3 of this survey question
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion3(java.lang.String question3,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion3(question3, locale, defaultLocale);
	}

	@Override
	public void setQuestion3CurrentLanguageId(java.lang.String languageId) {
		_surveyQuestion.setQuestion3CurrentLanguageId(languageId);
	}

	/**
	* Sets the localized question3s of this survey question from the map of locales and localized question3s.
	*
	* @param question3Map the locales and localized question3s of this survey question
	*/
	@Override
	public void setQuestion3Map(
		java.util.Map<java.util.Locale, java.lang.String> question3Map) {
		_surveyQuestion.setQuestion3Map(question3Map);
	}

	/**
	* Sets the localized question3s of this survey question from the map of locales and localized question3s, and sets the default locale.
	*
	* @param question3Map the locales and localized question3s of this survey question
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion3Map(
		java.util.Map<java.util.Locale, java.lang.String> question3Map,
		java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion3Map(question3Map, defaultLocale);
	}

	/**
	* Returns the question4 of this survey question.
	*
	* @return the question4 of this survey question
	*/
	@Override
	public java.lang.String getQuestion4() {
		return _surveyQuestion.getQuestion4();
	}

	/**
	* Returns the localized question4 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized question4 of this survey question
	*/
	@Override
	public java.lang.String getQuestion4(java.util.Locale locale) {
		return _surveyQuestion.getQuestion4(locale);
	}

	/**
	* Returns the localized question4 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question4 of this survey question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getQuestion4(java.util.Locale locale,
		boolean useDefault) {
		return _surveyQuestion.getQuestion4(locale, useDefault);
	}

	/**
	* Returns the localized question4 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized question4 of this survey question
	*/
	@Override
	public java.lang.String getQuestion4(java.lang.String languageId) {
		return _surveyQuestion.getQuestion4(languageId);
	}

	/**
	* Returns the localized question4 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question4 of this survey question
	*/
	@Override
	public java.lang.String getQuestion4(java.lang.String languageId,
		boolean useDefault) {
		return _surveyQuestion.getQuestion4(languageId, useDefault);
	}

	@Override
	public java.lang.String getQuestion4CurrentLanguageId() {
		return _surveyQuestion.getQuestion4CurrentLanguageId();
	}

	@Override
	public java.lang.String getQuestion4CurrentValue() {
		return _surveyQuestion.getQuestion4CurrentValue();
	}

	/**
	* Returns a map of the locales and localized question4s of this survey question.
	*
	* @return the locales and localized question4s of this survey question
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getQuestion4Map() {
		return _surveyQuestion.getQuestion4Map();
	}

	/**
	* Sets the question4 of this survey question.
	*
	* @param question4 the question4 of this survey question
	*/
	@Override
	public void setQuestion4(java.lang.String question4) {
		_surveyQuestion.setQuestion4(question4);
	}

	/**
	* Sets the localized question4 of this survey question in the language.
	*
	* @param question4 the localized question4 of this survey question
	* @param locale the locale of the language
	*/
	@Override
	public void setQuestion4(java.lang.String question4, java.util.Locale locale) {
		_surveyQuestion.setQuestion4(question4, locale);
	}

	/**
	* Sets the localized question4 of this survey question in the language, and sets the default locale.
	*
	* @param question4 the localized question4 of this survey question
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion4(java.lang.String question4,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion4(question4, locale, defaultLocale);
	}

	@Override
	public void setQuestion4CurrentLanguageId(java.lang.String languageId) {
		_surveyQuestion.setQuestion4CurrentLanguageId(languageId);
	}

	/**
	* Sets the localized question4s of this survey question from the map of locales and localized question4s.
	*
	* @param question4Map the locales and localized question4s of this survey question
	*/
	@Override
	public void setQuestion4Map(
		java.util.Map<java.util.Locale, java.lang.String> question4Map) {
		_surveyQuestion.setQuestion4Map(question4Map);
	}

	/**
	* Sets the localized question4s of this survey question from the map of locales and localized question4s, and sets the default locale.
	*
	* @param question4Map the locales and localized question4s of this survey question
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion4Map(
		java.util.Map<java.util.Locale, java.lang.String> question4Map,
		java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion4Map(question4Map, defaultLocale);
	}

	/**
	* Returns the question5 of this survey question.
	*
	* @return the question5 of this survey question
	*/
	@Override
	public java.lang.String getQuestion5() {
		return _surveyQuestion.getQuestion5();
	}

	/**
	* Returns the localized question5 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized question5 of this survey question
	*/
	@Override
	public java.lang.String getQuestion5(java.util.Locale locale) {
		return _surveyQuestion.getQuestion5(locale);
	}

	/**
	* Returns the localized question5 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question5 of this survey question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getQuestion5(java.util.Locale locale,
		boolean useDefault) {
		return _surveyQuestion.getQuestion5(locale, useDefault);
	}

	/**
	* Returns the localized question5 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized question5 of this survey question
	*/
	@Override
	public java.lang.String getQuestion5(java.lang.String languageId) {
		return _surveyQuestion.getQuestion5(languageId);
	}

	/**
	* Returns the localized question5 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question5 of this survey question
	*/
	@Override
	public java.lang.String getQuestion5(java.lang.String languageId,
		boolean useDefault) {
		return _surveyQuestion.getQuestion5(languageId, useDefault);
	}

	@Override
	public java.lang.String getQuestion5CurrentLanguageId() {
		return _surveyQuestion.getQuestion5CurrentLanguageId();
	}

	@Override
	public java.lang.String getQuestion5CurrentValue() {
		return _surveyQuestion.getQuestion5CurrentValue();
	}

	/**
	* Returns a map of the locales and localized question5s of this survey question.
	*
	* @return the locales and localized question5s of this survey question
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getQuestion5Map() {
		return _surveyQuestion.getQuestion5Map();
	}

	/**
	* Sets the question5 of this survey question.
	*
	* @param question5 the question5 of this survey question
	*/
	@Override
	public void setQuestion5(java.lang.String question5) {
		_surveyQuestion.setQuestion5(question5);
	}

	/**
	* Sets the localized question5 of this survey question in the language.
	*
	* @param question5 the localized question5 of this survey question
	* @param locale the locale of the language
	*/
	@Override
	public void setQuestion5(java.lang.String question5, java.util.Locale locale) {
		_surveyQuestion.setQuestion5(question5, locale);
	}

	/**
	* Sets the localized question5 of this survey question in the language, and sets the default locale.
	*
	* @param question5 the localized question5 of this survey question
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion5(java.lang.String question5,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion5(question5, locale, defaultLocale);
	}

	@Override
	public void setQuestion5CurrentLanguageId(java.lang.String languageId) {
		_surveyQuestion.setQuestion5CurrentLanguageId(languageId);
	}

	/**
	* Sets the localized question5s of this survey question from the map of locales and localized question5s.
	*
	* @param question5Map the locales and localized question5s of this survey question
	*/
	@Override
	public void setQuestion5Map(
		java.util.Map<java.util.Locale, java.lang.String> question5Map) {
		_surveyQuestion.setQuestion5Map(question5Map);
	}

	/**
	* Sets the localized question5s of this survey question from the map of locales and localized question5s, and sets the default locale.
	*
	* @param question5Map the locales and localized question5s of this survey question
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion5Map(
		java.util.Map<java.util.Locale, java.lang.String> question5Map,
		java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion5Map(question5Map, defaultLocale);
	}

	/**
	* Returns the question6 of this survey question.
	*
	* @return the question6 of this survey question
	*/
	@Override
	public java.lang.String getQuestion6() {
		return _surveyQuestion.getQuestion6();
	}

	/**
	* Returns the localized question6 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized question6 of this survey question
	*/
	@Override
	public java.lang.String getQuestion6(java.util.Locale locale) {
		return _surveyQuestion.getQuestion6(locale);
	}

	/**
	* Returns the localized question6 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question6 of this survey question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getQuestion6(java.util.Locale locale,
		boolean useDefault) {
		return _surveyQuestion.getQuestion6(locale, useDefault);
	}

	/**
	* Returns the localized question6 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized question6 of this survey question
	*/
	@Override
	public java.lang.String getQuestion6(java.lang.String languageId) {
		return _surveyQuestion.getQuestion6(languageId);
	}

	/**
	* Returns the localized question6 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question6 of this survey question
	*/
	@Override
	public java.lang.String getQuestion6(java.lang.String languageId,
		boolean useDefault) {
		return _surveyQuestion.getQuestion6(languageId, useDefault);
	}

	@Override
	public java.lang.String getQuestion6CurrentLanguageId() {
		return _surveyQuestion.getQuestion6CurrentLanguageId();
	}

	@Override
	public java.lang.String getQuestion6CurrentValue() {
		return _surveyQuestion.getQuestion6CurrentValue();
	}

	/**
	* Returns a map of the locales and localized question6s of this survey question.
	*
	* @return the locales and localized question6s of this survey question
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getQuestion6Map() {
		return _surveyQuestion.getQuestion6Map();
	}

	/**
	* Sets the question6 of this survey question.
	*
	* @param question6 the question6 of this survey question
	*/
	@Override
	public void setQuestion6(java.lang.String question6) {
		_surveyQuestion.setQuestion6(question6);
	}

	/**
	* Sets the localized question6 of this survey question in the language.
	*
	* @param question6 the localized question6 of this survey question
	* @param locale the locale of the language
	*/
	@Override
	public void setQuestion6(java.lang.String question6, java.util.Locale locale) {
		_surveyQuestion.setQuestion6(question6, locale);
	}

	/**
	* Sets the localized question6 of this survey question in the language, and sets the default locale.
	*
	* @param question6 the localized question6 of this survey question
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion6(java.lang.String question6,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion6(question6, locale, defaultLocale);
	}

	@Override
	public void setQuestion6CurrentLanguageId(java.lang.String languageId) {
		_surveyQuestion.setQuestion6CurrentLanguageId(languageId);
	}

	/**
	* Sets the localized question6s of this survey question from the map of locales and localized question6s.
	*
	* @param question6Map the locales and localized question6s of this survey question
	*/
	@Override
	public void setQuestion6Map(
		java.util.Map<java.util.Locale, java.lang.String> question6Map) {
		_surveyQuestion.setQuestion6Map(question6Map);
	}

	/**
	* Sets the localized question6s of this survey question from the map of locales and localized question6s, and sets the default locale.
	*
	* @param question6Map the locales and localized question6s of this survey question
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion6Map(
		java.util.Map<java.util.Locale, java.lang.String> question6Map,
		java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion6Map(question6Map, defaultLocale);
	}

	/**
	* Returns the question7 of this survey question.
	*
	* @return the question7 of this survey question
	*/
	@Override
	public java.lang.String getQuestion7() {
		return _surveyQuestion.getQuestion7();
	}

	/**
	* Returns the localized question7 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized question7 of this survey question
	*/
	@Override
	public java.lang.String getQuestion7(java.util.Locale locale) {
		return _surveyQuestion.getQuestion7(locale);
	}

	/**
	* Returns the localized question7 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question7 of this survey question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getQuestion7(java.util.Locale locale,
		boolean useDefault) {
		return _surveyQuestion.getQuestion7(locale, useDefault);
	}

	/**
	* Returns the localized question7 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized question7 of this survey question
	*/
	@Override
	public java.lang.String getQuestion7(java.lang.String languageId) {
		return _surveyQuestion.getQuestion7(languageId);
	}

	/**
	* Returns the localized question7 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question7 of this survey question
	*/
	@Override
	public java.lang.String getQuestion7(java.lang.String languageId,
		boolean useDefault) {
		return _surveyQuestion.getQuestion7(languageId, useDefault);
	}

	@Override
	public java.lang.String getQuestion7CurrentLanguageId() {
		return _surveyQuestion.getQuestion7CurrentLanguageId();
	}

	@Override
	public java.lang.String getQuestion7CurrentValue() {
		return _surveyQuestion.getQuestion7CurrentValue();
	}

	/**
	* Returns a map of the locales and localized question7s of this survey question.
	*
	* @return the locales and localized question7s of this survey question
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getQuestion7Map() {
		return _surveyQuestion.getQuestion7Map();
	}

	/**
	* Sets the question7 of this survey question.
	*
	* @param question7 the question7 of this survey question
	*/
	@Override
	public void setQuestion7(java.lang.String question7) {
		_surveyQuestion.setQuestion7(question7);
	}

	/**
	* Sets the localized question7 of this survey question in the language.
	*
	* @param question7 the localized question7 of this survey question
	* @param locale the locale of the language
	*/
	@Override
	public void setQuestion7(java.lang.String question7, java.util.Locale locale) {
		_surveyQuestion.setQuestion7(question7, locale);
	}

	/**
	* Sets the localized question7 of this survey question in the language, and sets the default locale.
	*
	* @param question7 the localized question7 of this survey question
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion7(java.lang.String question7,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion7(question7, locale, defaultLocale);
	}

	@Override
	public void setQuestion7CurrentLanguageId(java.lang.String languageId) {
		_surveyQuestion.setQuestion7CurrentLanguageId(languageId);
	}

	/**
	* Sets the localized question7s of this survey question from the map of locales and localized question7s.
	*
	* @param question7Map the locales and localized question7s of this survey question
	*/
	@Override
	public void setQuestion7Map(
		java.util.Map<java.util.Locale, java.lang.String> question7Map) {
		_surveyQuestion.setQuestion7Map(question7Map);
	}

	/**
	* Sets the localized question7s of this survey question from the map of locales and localized question7s, and sets the default locale.
	*
	* @param question7Map the locales and localized question7s of this survey question
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion7Map(
		java.util.Map<java.util.Locale, java.lang.String> question7Map,
		java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion7Map(question7Map, defaultLocale);
	}

	/**
	* Returns the question8 of this survey question.
	*
	* @return the question8 of this survey question
	*/
	@Override
	public java.lang.String getQuestion8() {
		return _surveyQuestion.getQuestion8();
	}

	/**
	* Returns the localized question8 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized question8 of this survey question
	*/
	@Override
	public java.lang.String getQuestion8(java.util.Locale locale) {
		return _surveyQuestion.getQuestion8(locale);
	}

	/**
	* Returns the localized question8 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question8 of this survey question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getQuestion8(java.util.Locale locale,
		boolean useDefault) {
		return _surveyQuestion.getQuestion8(locale, useDefault);
	}

	/**
	* Returns the localized question8 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized question8 of this survey question
	*/
	@Override
	public java.lang.String getQuestion8(java.lang.String languageId) {
		return _surveyQuestion.getQuestion8(languageId);
	}

	/**
	* Returns the localized question8 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question8 of this survey question
	*/
	@Override
	public java.lang.String getQuestion8(java.lang.String languageId,
		boolean useDefault) {
		return _surveyQuestion.getQuestion8(languageId, useDefault);
	}

	@Override
	public java.lang.String getQuestion8CurrentLanguageId() {
		return _surveyQuestion.getQuestion8CurrentLanguageId();
	}

	@Override
	public java.lang.String getQuestion8CurrentValue() {
		return _surveyQuestion.getQuestion8CurrentValue();
	}

	/**
	* Returns a map of the locales and localized question8s of this survey question.
	*
	* @return the locales and localized question8s of this survey question
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getQuestion8Map() {
		return _surveyQuestion.getQuestion8Map();
	}

	/**
	* Sets the question8 of this survey question.
	*
	* @param question8 the question8 of this survey question
	*/
	@Override
	public void setQuestion8(java.lang.String question8) {
		_surveyQuestion.setQuestion8(question8);
	}

	/**
	* Sets the localized question8 of this survey question in the language.
	*
	* @param question8 the localized question8 of this survey question
	* @param locale the locale of the language
	*/
	@Override
	public void setQuestion8(java.lang.String question8, java.util.Locale locale) {
		_surveyQuestion.setQuestion8(question8, locale);
	}

	/**
	* Sets the localized question8 of this survey question in the language, and sets the default locale.
	*
	* @param question8 the localized question8 of this survey question
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion8(java.lang.String question8,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion8(question8, locale, defaultLocale);
	}

	@Override
	public void setQuestion8CurrentLanguageId(java.lang.String languageId) {
		_surveyQuestion.setQuestion8CurrentLanguageId(languageId);
	}

	/**
	* Sets the localized question8s of this survey question from the map of locales and localized question8s.
	*
	* @param question8Map the locales and localized question8s of this survey question
	*/
	@Override
	public void setQuestion8Map(
		java.util.Map<java.util.Locale, java.lang.String> question8Map) {
		_surveyQuestion.setQuestion8Map(question8Map);
	}

	/**
	* Sets the localized question8s of this survey question from the map of locales and localized question8s, and sets the default locale.
	*
	* @param question8Map the locales and localized question8s of this survey question
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion8Map(
		java.util.Map<java.util.Locale, java.lang.String> question8Map,
		java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion8Map(question8Map, defaultLocale);
	}

	/**
	* Returns the question9 of this survey question.
	*
	* @return the question9 of this survey question
	*/
	@Override
	public java.lang.String getQuestion9() {
		return _surveyQuestion.getQuestion9();
	}

	/**
	* Returns the localized question9 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized question9 of this survey question
	*/
	@Override
	public java.lang.String getQuestion9(java.util.Locale locale) {
		return _surveyQuestion.getQuestion9(locale);
	}

	/**
	* Returns the localized question9 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question9 of this survey question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getQuestion9(java.util.Locale locale,
		boolean useDefault) {
		return _surveyQuestion.getQuestion9(locale, useDefault);
	}

	/**
	* Returns the localized question9 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized question9 of this survey question
	*/
	@Override
	public java.lang.String getQuestion9(java.lang.String languageId) {
		return _surveyQuestion.getQuestion9(languageId);
	}

	/**
	* Returns the localized question9 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question9 of this survey question
	*/
	@Override
	public java.lang.String getQuestion9(java.lang.String languageId,
		boolean useDefault) {
		return _surveyQuestion.getQuestion9(languageId, useDefault);
	}

	@Override
	public java.lang.String getQuestion9CurrentLanguageId() {
		return _surveyQuestion.getQuestion9CurrentLanguageId();
	}

	@Override
	public java.lang.String getQuestion9CurrentValue() {
		return _surveyQuestion.getQuestion9CurrentValue();
	}

	/**
	* Returns a map of the locales and localized question9s of this survey question.
	*
	* @return the locales and localized question9s of this survey question
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getQuestion9Map() {
		return _surveyQuestion.getQuestion9Map();
	}

	/**
	* Sets the question9 of this survey question.
	*
	* @param question9 the question9 of this survey question
	*/
	@Override
	public void setQuestion9(java.lang.String question9) {
		_surveyQuestion.setQuestion9(question9);
	}

	/**
	* Sets the localized question9 of this survey question in the language.
	*
	* @param question9 the localized question9 of this survey question
	* @param locale the locale of the language
	*/
	@Override
	public void setQuestion9(java.lang.String question9, java.util.Locale locale) {
		_surveyQuestion.setQuestion9(question9, locale);
	}

	/**
	* Sets the localized question9 of this survey question in the language, and sets the default locale.
	*
	* @param question9 the localized question9 of this survey question
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion9(java.lang.String question9,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion9(question9, locale, defaultLocale);
	}

	@Override
	public void setQuestion9CurrentLanguageId(java.lang.String languageId) {
		_surveyQuestion.setQuestion9CurrentLanguageId(languageId);
	}

	/**
	* Sets the localized question9s of this survey question from the map of locales and localized question9s.
	*
	* @param question9Map the locales and localized question9s of this survey question
	*/
	@Override
	public void setQuestion9Map(
		java.util.Map<java.util.Locale, java.lang.String> question9Map) {
		_surveyQuestion.setQuestion9Map(question9Map);
	}

	/**
	* Sets the localized question9s of this survey question from the map of locales and localized question9s, and sets the default locale.
	*
	* @param question9Map the locales and localized question9s of this survey question
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion9Map(
		java.util.Map<java.util.Locale, java.lang.String> question9Map,
		java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion9Map(question9Map, defaultLocale);
	}

	/**
	* Returns the question10 of this survey question.
	*
	* @return the question10 of this survey question
	*/
	@Override
	public java.lang.String getQuestion10() {
		return _surveyQuestion.getQuestion10();
	}

	/**
	* Returns the localized question10 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized question10 of this survey question
	*/
	@Override
	public java.lang.String getQuestion10(java.util.Locale locale) {
		return _surveyQuestion.getQuestion10(locale);
	}

	/**
	* Returns the localized question10 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question10 of this survey question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getQuestion10(java.util.Locale locale,
		boolean useDefault) {
		return _surveyQuestion.getQuestion10(locale, useDefault);
	}

	/**
	* Returns the localized question10 of this survey question in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized question10 of this survey question
	*/
	@Override
	public java.lang.String getQuestion10(java.lang.String languageId) {
		return _surveyQuestion.getQuestion10(languageId);
	}

	/**
	* Returns the localized question10 of this survey question in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized question10 of this survey question
	*/
	@Override
	public java.lang.String getQuestion10(java.lang.String languageId,
		boolean useDefault) {
		return _surveyQuestion.getQuestion10(languageId, useDefault);
	}

	@Override
	public java.lang.String getQuestion10CurrentLanguageId() {
		return _surveyQuestion.getQuestion10CurrentLanguageId();
	}

	@Override
	public java.lang.String getQuestion10CurrentValue() {
		return _surveyQuestion.getQuestion10CurrentValue();
	}

	/**
	* Returns a map of the locales and localized question10s of this survey question.
	*
	* @return the locales and localized question10s of this survey question
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getQuestion10Map() {
		return _surveyQuestion.getQuestion10Map();
	}

	/**
	* Sets the question10 of this survey question.
	*
	* @param question10 the question10 of this survey question
	*/
	@Override
	public void setQuestion10(java.lang.String question10) {
		_surveyQuestion.setQuestion10(question10);
	}

	/**
	* Sets the localized question10 of this survey question in the language.
	*
	* @param question10 the localized question10 of this survey question
	* @param locale the locale of the language
	*/
	@Override
	public void setQuestion10(java.lang.String question10,
		java.util.Locale locale) {
		_surveyQuestion.setQuestion10(question10, locale);
	}

	/**
	* Sets the localized question10 of this survey question in the language, and sets the default locale.
	*
	* @param question10 the localized question10 of this survey question
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion10(java.lang.String question10,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion10(question10, locale, defaultLocale);
	}

	@Override
	public void setQuestion10CurrentLanguageId(java.lang.String languageId) {
		_surveyQuestion.setQuestion10CurrentLanguageId(languageId);
	}

	/**
	* Sets the localized question10s of this survey question from the map of locales and localized question10s.
	*
	* @param question10Map the locales and localized question10s of this survey question
	*/
	@Override
	public void setQuestion10Map(
		java.util.Map<java.util.Locale, java.lang.String> question10Map) {
		_surveyQuestion.setQuestion10Map(question10Map);
	}

	/**
	* Sets the localized question10s of this survey question from the map of locales and localized question10s, and sets the default locale.
	*
	* @param question10Map the locales and localized question10s of this survey question
	* @param defaultLocale the default locale
	*/
	@Override
	public void setQuestion10Map(
		java.util.Map<java.util.Locale, java.lang.String> question10Map,
		java.util.Locale defaultLocale) {
		_surveyQuestion.setQuestion10Map(question10Map, defaultLocale);
	}

	@Override
	public boolean isNew() {
		return _surveyQuestion.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_surveyQuestion.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _surveyQuestion.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_surveyQuestion.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _surveyQuestion.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _surveyQuestion.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_surveyQuestion.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _surveyQuestion.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_surveyQuestion.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_surveyQuestion.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_surveyQuestion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _surveyQuestion.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _surveyQuestion.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_surveyQuestion.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_surveyQuestion.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new SurveyQuestionWrapper((SurveyQuestion)_surveyQuestion.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion) {
		return _surveyQuestion.compareTo(surveyQuestion);
	}

	@Override
	public int hashCode() {
		return _surveyQuestion.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> toCacheModel() {
		return _surveyQuestion.toCacheModel();
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion toEscapedModel() {
		return new SurveyQuestionWrapper(_surveyQuestion.toEscapedModel());
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion toUnescapedModel() {
		return new SurveyQuestionWrapper(_surveyQuestion.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _surveyQuestion.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _surveyQuestion.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestion.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyQuestionWrapper)) {
			return false;
		}

		SurveyQuestionWrapper surveyQuestionWrapper = (SurveyQuestionWrapper)obj;

		if (Validator.equals(_surveyQuestion,
					surveyQuestionWrapper._surveyQuestion)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SurveyQuestion getWrappedSurveyQuestion() {
		return _surveyQuestion;
	}

	@Override
	public SurveyQuestion getWrappedModel() {
		return _surveyQuestion;
	}

	@Override
	public void resetOriginalValues() {
		_surveyQuestion.resetOriginalValues();
	}

	private SurveyQuestion _surveyQuestion;
}