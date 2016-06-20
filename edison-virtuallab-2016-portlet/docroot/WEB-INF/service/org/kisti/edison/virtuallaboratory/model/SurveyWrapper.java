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
 * This class is a wrapper for {@link Survey}.
 * </p>
 *
 * @author EDISON
 * @see Survey
 * @generated
 */
public class SurveyWrapper implements Survey, ModelWrapper<Survey> {
	public SurveyWrapper(Survey survey) {
		_survey = survey;
	}

	@Override
	public Class<?> getModelClass() {
		return Survey.class;
	}

	@Override
	public String getModelClassName() {
		return Survey.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surveySeqNo", getSurveySeqNo());
		attributes.put("surveyUseYn", getSurveyUseYn());
		attributes.put("surveyTitle", getSurveyTitle());
		attributes.put("surveyStartDate", getSurveyStartDate());
		attributes.put("surveyEndDate", getSurveyEndDate());
		attributes.put("surveyStatus", getSurveyStatus());
		attributes.put("surveyCreateDate", getSurveyCreateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surveySeqNo = (Long)attributes.get("surveySeqNo");

		if (surveySeqNo != null) {
			setSurveySeqNo(surveySeqNo);
		}

		String surveyUseYn = (String)attributes.get("surveyUseYn");

		if (surveyUseYn != null) {
			setSurveyUseYn(surveyUseYn);
		}

		String surveyTitle = (String)attributes.get("surveyTitle");

		if (surveyTitle != null) {
			setSurveyTitle(surveyTitle);
		}

		String surveyStartDate = (String)attributes.get("surveyStartDate");

		if (surveyStartDate != null) {
			setSurveyStartDate(surveyStartDate);
		}

		String surveyEndDate = (String)attributes.get("surveyEndDate");

		if (surveyEndDate != null) {
			setSurveyEndDate(surveyEndDate);
		}

		String surveyStatus = (String)attributes.get("surveyStatus");

		if (surveyStatus != null) {
			setSurveyStatus(surveyStatus);
		}

		Date surveyCreateDate = (Date)attributes.get("surveyCreateDate");

		if (surveyCreateDate != null) {
			setSurveyCreateDate(surveyCreateDate);
		}
	}

	/**
	* Returns the primary key of this survey.
	*
	* @return the primary key of this survey
	*/
	@Override
	public long getPrimaryKey() {
		return _survey.getPrimaryKey();
	}

	/**
	* Sets the primary key of this survey.
	*
	* @param primaryKey the primary key of this survey
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_survey.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the survey seq no of this survey.
	*
	* @return the survey seq no of this survey
	*/
	@Override
	public long getSurveySeqNo() {
		return _survey.getSurveySeqNo();
	}

	/**
	* Sets the survey seq no of this survey.
	*
	* @param surveySeqNo the survey seq no of this survey
	*/
	@Override
	public void setSurveySeqNo(long surveySeqNo) {
		_survey.setSurveySeqNo(surveySeqNo);
	}

	/**
	* Returns the survey use yn of this survey.
	*
	* @return the survey use yn of this survey
	*/
	@Override
	public java.lang.String getSurveyUseYn() {
		return _survey.getSurveyUseYn();
	}

	/**
	* Sets the survey use yn of this survey.
	*
	* @param surveyUseYn the survey use yn of this survey
	*/
	@Override
	public void setSurveyUseYn(java.lang.String surveyUseYn) {
		_survey.setSurveyUseYn(surveyUseYn);
	}

	/**
	* Returns the survey title of this survey.
	*
	* @return the survey title of this survey
	*/
	@Override
	public java.lang.String getSurveyTitle() {
		return _survey.getSurveyTitle();
	}

	/**
	* Returns the localized survey title of this survey in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized survey title of this survey
	*/
	@Override
	public java.lang.String getSurveyTitle(java.util.Locale locale) {
		return _survey.getSurveyTitle(locale);
	}

	/**
	* Returns the localized survey title of this survey in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized survey title of this survey. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getSurveyTitle(java.util.Locale locale,
		boolean useDefault) {
		return _survey.getSurveyTitle(locale, useDefault);
	}

	/**
	* Returns the localized survey title of this survey in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized survey title of this survey
	*/
	@Override
	public java.lang.String getSurveyTitle(java.lang.String languageId) {
		return _survey.getSurveyTitle(languageId);
	}

	/**
	* Returns the localized survey title of this survey in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized survey title of this survey
	*/
	@Override
	public java.lang.String getSurveyTitle(java.lang.String languageId,
		boolean useDefault) {
		return _survey.getSurveyTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getSurveyTitleCurrentLanguageId() {
		return _survey.getSurveyTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getSurveyTitleCurrentValue() {
		return _survey.getSurveyTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized survey titles of this survey.
	*
	* @return the locales and localized survey titles of this survey
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getSurveyTitleMap() {
		return _survey.getSurveyTitleMap();
	}

	/**
	* Sets the survey title of this survey.
	*
	* @param surveyTitle the survey title of this survey
	*/
	@Override
	public void setSurveyTitle(java.lang.String surveyTitle) {
		_survey.setSurveyTitle(surveyTitle);
	}

	/**
	* Sets the localized survey title of this survey in the language.
	*
	* @param surveyTitle the localized survey title of this survey
	* @param locale the locale of the language
	*/
	@Override
	public void setSurveyTitle(java.lang.String surveyTitle,
		java.util.Locale locale) {
		_survey.setSurveyTitle(surveyTitle, locale);
	}

	/**
	* Sets the localized survey title of this survey in the language, and sets the default locale.
	*
	* @param surveyTitle the localized survey title of this survey
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSurveyTitle(java.lang.String surveyTitle,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_survey.setSurveyTitle(surveyTitle, locale, defaultLocale);
	}

	@Override
	public void setSurveyTitleCurrentLanguageId(java.lang.String languageId) {
		_survey.setSurveyTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized survey titles of this survey from the map of locales and localized survey titles.
	*
	* @param surveyTitleMap the locales and localized survey titles of this survey
	*/
	@Override
	public void setSurveyTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> surveyTitleMap) {
		_survey.setSurveyTitleMap(surveyTitleMap);
	}

	/**
	* Sets the localized survey titles of this survey from the map of locales and localized survey titles, and sets the default locale.
	*
	* @param surveyTitleMap the locales and localized survey titles of this survey
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSurveyTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> surveyTitleMap,
		java.util.Locale defaultLocale) {
		_survey.setSurveyTitleMap(surveyTitleMap, defaultLocale);
	}

	/**
	* Returns the survey start date of this survey.
	*
	* @return the survey start date of this survey
	*/
	@Override
	public java.lang.String getSurveyStartDate() {
		return _survey.getSurveyStartDate();
	}

	/**
	* Sets the survey start date of this survey.
	*
	* @param surveyStartDate the survey start date of this survey
	*/
	@Override
	public void setSurveyStartDate(java.lang.String surveyStartDate) {
		_survey.setSurveyStartDate(surveyStartDate);
	}

	/**
	* Returns the survey end date of this survey.
	*
	* @return the survey end date of this survey
	*/
	@Override
	public java.lang.String getSurveyEndDate() {
		return _survey.getSurveyEndDate();
	}

	/**
	* Sets the survey end date of this survey.
	*
	* @param surveyEndDate the survey end date of this survey
	*/
	@Override
	public void setSurveyEndDate(java.lang.String surveyEndDate) {
		_survey.setSurveyEndDate(surveyEndDate);
	}

	/**
	* Returns the survey status of this survey.
	*
	* @return the survey status of this survey
	*/
	@Override
	public java.lang.String getSurveyStatus() {
		return _survey.getSurveyStatus();
	}

	/**
	* Sets the survey status of this survey.
	*
	* @param surveyStatus the survey status of this survey
	*/
	@Override
	public void setSurveyStatus(java.lang.String surveyStatus) {
		_survey.setSurveyStatus(surveyStatus);
	}

	/**
	* Returns the survey create date of this survey.
	*
	* @return the survey create date of this survey
	*/
	@Override
	public java.util.Date getSurveyCreateDate() {
		return _survey.getSurveyCreateDate();
	}

	/**
	* Sets the survey create date of this survey.
	*
	* @param surveyCreateDate the survey create date of this survey
	*/
	@Override
	public void setSurveyCreateDate(java.util.Date surveyCreateDate) {
		_survey.setSurveyCreateDate(surveyCreateDate);
	}

	@Override
	public boolean isNew() {
		return _survey.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_survey.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _survey.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_survey.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _survey.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _survey.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_survey.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _survey.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_survey.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_survey.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_survey.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _survey.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _survey.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_survey.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_survey.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new SurveyWrapper((Survey)_survey.clone());
	}

	@Override
	public int compareTo(org.kisti.edison.virtuallaboratory.model.Survey survey) {
		return _survey.compareTo(survey);
	}

	@Override
	public int hashCode() {
		return _survey.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.virtuallaboratory.model.Survey> toCacheModel() {
		return _survey.toCacheModel();
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.Survey toEscapedModel() {
		return new SurveyWrapper(_survey.toEscapedModel());
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.Survey toUnescapedModel() {
		return new SurveyWrapper(_survey.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _survey.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _survey.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_survey.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyWrapper)) {
			return false;
		}

		SurveyWrapper surveyWrapper = (SurveyWrapper)obj;

		if (Validator.equals(_survey, surveyWrapper._survey)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Survey getWrappedSurvey() {
		return _survey;
	}

	@Override
	public Survey getWrappedModel() {
		return _survey;
	}

	@Override
	public void resetOriginalValues() {
		_survey.resetOriginalValues();
	}

	private Survey _survey;
}