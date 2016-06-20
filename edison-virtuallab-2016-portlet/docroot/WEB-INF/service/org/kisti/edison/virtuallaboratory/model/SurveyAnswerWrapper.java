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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SurveyAnswer}.
 * </p>
 *
 * @author EDISON
 * @see SurveyAnswer
 * @generated
 */
public class SurveyAnswerWrapper implements SurveyAnswer,
	ModelWrapper<SurveyAnswer> {
	public SurveyAnswerWrapper(SurveyAnswer surveyAnswer) {
		_surveyAnswer = surveyAnswer;
	}

	@Override
	public Class<?> getModelClass() {
		return SurveyAnswer.class;
	}

	@Override
	public String getModelClassName() {
		return SurveyAnswer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("SurveyAnswerId", getSurveyAnswerId());
		attributes.put("userId", getUserId());
		attributes.put("virtualLabId", getVirtualLabId());
		attributes.put("classId", getClassId());
		attributes.put("subjectivityAnswer", getSubjectivityAnswer());
		attributes.put("objecttivityAnswer", getObjecttivityAnswer());
		attributes.put("answerDate", getAnswerDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long SurveyAnswerId = (Long)attributes.get("SurveyAnswerId");

		if (SurveyAnswerId != null) {
			setSurveyAnswerId(SurveyAnswerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long virtualLabId = (Long)attributes.get("virtualLabId");

		if (virtualLabId != null) {
			setVirtualLabId(virtualLabId);
		}

		Long classId = (Long)attributes.get("classId");

		if (classId != null) {
			setClassId(classId);
		}

		String subjectivityAnswer = (String)attributes.get("subjectivityAnswer");

		if (subjectivityAnswer != null) {
			setSubjectivityAnswer(subjectivityAnswer);
		}

		String objecttivityAnswer = (String)attributes.get("objecttivityAnswer");

		if (objecttivityAnswer != null) {
			setObjecttivityAnswer(objecttivityAnswer);
		}

		Date answerDate = (Date)attributes.get("answerDate");

		if (answerDate != null) {
			setAnswerDate(answerDate);
		}
	}

	/**
	* Returns the primary key of this survey answer.
	*
	* @return the primary key of this survey answer
	*/
	@Override
	public long getPrimaryKey() {
		return _surveyAnswer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this survey answer.
	*
	* @param primaryKey the primary key of this survey answer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_surveyAnswer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the survey answer ID of this survey answer.
	*
	* @return the survey answer ID of this survey answer
	*/
	@Override
	public long getSurveyAnswerId() {
		return _surveyAnswer.getSurveyAnswerId();
	}

	/**
	* Sets the survey answer ID of this survey answer.
	*
	* @param SurveyAnswerId the survey answer ID of this survey answer
	*/
	@Override
	public void setSurveyAnswerId(long SurveyAnswerId) {
		_surveyAnswer.setSurveyAnswerId(SurveyAnswerId);
	}

	/**
	* Returns the user ID of this survey answer.
	*
	* @return the user ID of this survey answer
	*/
	@Override
	public long getUserId() {
		return _surveyAnswer.getUserId();
	}

	/**
	* Sets the user ID of this survey answer.
	*
	* @param userId the user ID of this survey answer
	*/
	@Override
	public void setUserId(long userId) {
		_surveyAnswer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this survey answer.
	*
	* @return the user uuid of this survey answer
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswer.getUserUuid();
	}

	/**
	* Sets the user uuid of this survey answer.
	*
	* @param userUuid the user uuid of this survey answer
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_surveyAnswer.setUserUuid(userUuid);
	}

	/**
	* Returns the virtual lab ID of this survey answer.
	*
	* @return the virtual lab ID of this survey answer
	*/
	@Override
	public long getVirtualLabId() {
		return _surveyAnswer.getVirtualLabId();
	}

	/**
	* Sets the virtual lab ID of this survey answer.
	*
	* @param virtualLabId the virtual lab ID of this survey answer
	*/
	@Override
	public void setVirtualLabId(long virtualLabId) {
		_surveyAnswer.setVirtualLabId(virtualLabId);
	}

	/**
	* Returns the class ID of this survey answer.
	*
	* @return the class ID of this survey answer
	*/
	@Override
	public long getClassId() {
		return _surveyAnswer.getClassId();
	}

	/**
	* Sets the class ID of this survey answer.
	*
	* @param classId the class ID of this survey answer
	*/
	@Override
	public void setClassId(long classId) {
		_surveyAnswer.setClassId(classId);
	}

	/**
	* Returns the subjectivity answer of this survey answer.
	*
	* @return the subjectivity answer of this survey answer
	*/
	@Override
	public java.lang.String getSubjectivityAnswer() {
		return _surveyAnswer.getSubjectivityAnswer();
	}

	/**
	* Returns the localized subjectivity answer of this survey answer in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized subjectivity answer of this survey answer
	*/
	@Override
	public java.lang.String getSubjectivityAnswer(java.util.Locale locale) {
		return _surveyAnswer.getSubjectivityAnswer(locale);
	}

	/**
	* Returns the localized subjectivity answer of this survey answer in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized subjectivity answer of this survey answer. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getSubjectivityAnswer(java.util.Locale locale,
		boolean useDefault) {
		return _surveyAnswer.getSubjectivityAnswer(locale, useDefault);
	}

	/**
	* Returns the localized subjectivity answer of this survey answer in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized subjectivity answer of this survey answer
	*/
	@Override
	public java.lang.String getSubjectivityAnswer(java.lang.String languageId) {
		return _surveyAnswer.getSubjectivityAnswer(languageId);
	}

	/**
	* Returns the localized subjectivity answer of this survey answer in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized subjectivity answer of this survey answer
	*/
	@Override
	public java.lang.String getSubjectivityAnswer(java.lang.String languageId,
		boolean useDefault) {
		return _surveyAnswer.getSubjectivityAnswer(languageId, useDefault);
	}

	@Override
	public java.lang.String getSubjectivityAnswerCurrentLanguageId() {
		return _surveyAnswer.getSubjectivityAnswerCurrentLanguageId();
	}

	@Override
	public java.lang.String getSubjectivityAnswerCurrentValue() {
		return _surveyAnswer.getSubjectivityAnswerCurrentValue();
	}

	/**
	* Returns a map of the locales and localized subjectivity answers of this survey answer.
	*
	* @return the locales and localized subjectivity answers of this survey answer
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getSubjectivityAnswerMap() {
		return _surveyAnswer.getSubjectivityAnswerMap();
	}

	/**
	* Sets the subjectivity answer of this survey answer.
	*
	* @param subjectivityAnswer the subjectivity answer of this survey answer
	*/
	@Override
	public void setSubjectivityAnswer(java.lang.String subjectivityAnswer) {
		_surveyAnswer.setSubjectivityAnswer(subjectivityAnswer);
	}

	/**
	* Sets the localized subjectivity answer of this survey answer in the language.
	*
	* @param subjectivityAnswer the localized subjectivity answer of this survey answer
	* @param locale the locale of the language
	*/
	@Override
	public void setSubjectivityAnswer(java.lang.String subjectivityAnswer,
		java.util.Locale locale) {
		_surveyAnswer.setSubjectivityAnswer(subjectivityAnswer, locale);
	}

	/**
	* Sets the localized subjectivity answer of this survey answer in the language, and sets the default locale.
	*
	* @param subjectivityAnswer the localized subjectivity answer of this survey answer
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSubjectivityAnswer(java.lang.String subjectivityAnswer,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_surveyAnswer.setSubjectivityAnswer(subjectivityAnswer, locale,
			defaultLocale);
	}

	@Override
	public void setSubjectivityAnswerCurrentLanguageId(
		java.lang.String languageId) {
		_surveyAnswer.setSubjectivityAnswerCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized subjectivity answers of this survey answer from the map of locales and localized subjectivity answers.
	*
	* @param subjectivityAnswerMap the locales and localized subjectivity answers of this survey answer
	*/
	@Override
	public void setSubjectivityAnswerMap(
		java.util.Map<java.util.Locale, java.lang.String> subjectivityAnswerMap) {
		_surveyAnswer.setSubjectivityAnswerMap(subjectivityAnswerMap);
	}

	/**
	* Sets the localized subjectivity answers of this survey answer from the map of locales and localized subjectivity answers, and sets the default locale.
	*
	* @param subjectivityAnswerMap the locales and localized subjectivity answers of this survey answer
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSubjectivityAnswerMap(
		java.util.Map<java.util.Locale, java.lang.String> subjectivityAnswerMap,
		java.util.Locale defaultLocale) {
		_surveyAnswer.setSubjectivityAnswerMap(subjectivityAnswerMap,
			defaultLocale);
	}

	/**
	* Returns the objecttivity answer of this survey answer.
	*
	* @return the objecttivity answer of this survey answer
	*/
	@Override
	public java.lang.String getObjecttivityAnswer() {
		return _surveyAnswer.getObjecttivityAnswer();
	}

	/**
	* Sets the objecttivity answer of this survey answer.
	*
	* @param objecttivityAnswer the objecttivity answer of this survey answer
	*/
	@Override
	public void setObjecttivityAnswer(java.lang.String objecttivityAnswer) {
		_surveyAnswer.setObjecttivityAnswer(objecttivityAnswer);
	}

	/**
	* Returns the answer date of this survey answer.
	*
	* @return the answer date of this survey answer
	*/
	@Override
	public java.util.Date getAnswerDate() {
		return _surveyAnswer.getAnswerDate();
	}

	/**
	* Sets the answer date of this survey answer.
	*
	* @param answerDate the answer date of this survey answer
	*/
	@Override
	public void setAnswerDate(java.util.Date answerDate) {
		_surveyAnswer.setAnswerDate(answerDate);
	}

	@Override
	public boolean isNew() {
		return _surveyAnswer.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_surveyAnswer.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _surveyAnswer.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_surveyAnswer.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _surveyAnswer.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _surveyAnswer.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_surveyAnswer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _surveyAnswer.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_surveyAnswer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_surveyAnswer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_surveyAnswer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _surveyAnswer.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _surveyAnswer.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_surveyAnswer.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_surveyAnswer.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new SurveyAnswerWrapper((SurveyAnswer)_surveyAnswer.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer) {
		return _surveyAnswer.compareTo(surveyAnswer);
	}

	@Override
	public int hashCode() {
		return _surveyAnswer.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> toCacheModel() {
		return _surveyAnswer.toCacheModel();
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer toEscapedModel() {
		return new SurveyAnswerWrapper(_surveyAnswer.toEscapedModel());
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer toUnescapedModel() {
		return new SurveyAnswerWrapper(_surveyAnswer.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _surveyAnswer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _surveyAnswer.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyAnswer.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyAnswerWrapper)) {
			return false;
		}

		SurveyAnswerWrapper surveyAnswerWrapper = (SurveyAnswerWrapper)obj;

		if (Validator.equals(_surveyAnswer, surveyAnswerWrapper._surveyAnswer)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SurveyAnswer getWrappedSurveyAnswer() {
		return _surveyAnswer;
	}

	@Override
	public SurveyAnswer getWrappedModel() {
		return _surveyAnswer;
	}

	@Override
	public void resetOriginalValues() {
		_surveyAnswer.resetOriginalValues();
	}

	private SurveyAnswer _surveyAnswer;
}