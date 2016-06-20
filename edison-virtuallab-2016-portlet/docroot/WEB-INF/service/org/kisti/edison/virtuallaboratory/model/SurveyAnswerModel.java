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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the SurveyAnswer service. Represents a row in the &quot;EDVIR_SurveyAnswer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerImpl}.
 * </p>
 *
 * @author EDISON
 * @see SurveyAnswer
 * @see org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerImpl
 * @see org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerModelImpl
 * @generated
 */
public interface SurveyAnswerModel extends BaseModel<SurveyAnswer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a survey answer model instance should use the {@link SurveyAnswer} interface instead.
	 */

	/**
	 * Returns the primary key of this survey answer.
	 *
	 * @return the primary key of this survey answer
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this survey answer.
	 *
	 * @param primaryKey the primary key of this survey answer
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the survey answer ID of this survey answer.
	 *
	 * @return the survey answer ID of this survey answer
	 */
	public long getSurveyAnswerId();

	/**
	 * Sets the survey answer ID of this survey answer.
	 *
	 * @param SurveyAnswerId the survey answer ID of this survey answer
	 */
	public void setSurveyAnswerId(long SurveyAnswerId);

	/**
	 * Returns the user ID of this survey answer.
	 *
	 * @return the user ID of this survey answer
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this survey answer.
	 *
	 * @param userId the user ID of this survey answer
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this survey answer.
	 *
	 * @return the user uuid of this survey answer
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this survey answer.
	 *
	 * @param userUuid the user uuid of this survey answer
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the virtual lab ID of this survey answer.
	 *
	 * @return the virtual lab ID of this survey answer
	 */
	public long getVirtualLabId();

	/**
	 * Sets the virtual lab ID of this survey answer.
	 *
	 * @param virtualLabId the virtual lab ID of this survey answer
	 */
	public void setVirtualLabId(long virtualLabId);

	/**
	 * Returns the class ID of this survey answer.
	 *
	 * @return the class ID of this survey answer
	 */
	public long getClassId();

	/**
	 * Sets the class ID of this survey answer.
	 *
	 * @param classId the class ID of this survey answer
	 */
	public void setClassId(long classId);

	/**
	 * Returns the subjectivity answer of this survey answer.
	 *
	 * @return the subjectivity answer of this survey answer
	 */
	public String getSubjectivityAnswer();

	/**
	 * Returns the localized subjectivity answer of this survey answer in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized subjectivity answer of this survey answer
	 */
	@AutoEscape
	public String getSubjectivityAnswer(Locale locale);

	/**
	 * Returns the localized subjectivity answer of this survey answer in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subjectivity answer of this survey answer. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getSubjectivityAnswer(Locale locale, boolean useDefault);

	/**
	 * Returns the localized subjectivity answer of this survey answer in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized subjectivity answer of this survey answer
	 */
	@AutoEscape
	public String getSubjectivityAnswer(String languageId);

	/**
	 * Returns the localized subjectivity answer of this survey answer in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subjectivity answer of this survey answer
	 */
	@AutoEscape
	public String getSubjectivityAnswer(String languageId, boolean useDefault);

	@AutoEscape
	public String getSubjectivityAnswerCurrentLanguageId();

	@AutoEscape
	public String getSubjectivityAnswerCurrentValue();

	/**
	 * Returns a map of the locales and localized subjectivity answers of this survey answer.
	 *
	 * @return the locales and localized subjectivity answers of this survey answer
	 */
	public Map<Locale, String> getSubjectivityAnswerMap();

	/**
	 * Sets the subjectivity answer of this survey answer.
	 *
	 * @param subjectivityAnswer the subjectivity answer of this survey answer
	 */
	public void setSubjectivityAnswer(String subjectivityAnswer);

	/**
	 * Sets the localized subjectivity answer of this survey answer in the language.
	 *
	 * @param subjectivityAnswer the localized subjectivity answer of this survey answer
	 * @param locale the locale of the language
	 */
	public void setSubjectivityAnswer(String subjectivityAnswer, Locale locale);

	/**
	 * Sets the localized subjectivity answer of this survey answer in the language, and sets the default locale.
	 *
	 * @param subjectivityAnswer the localized subjectivity answer of this survey answer
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setSubjectivityAnswer(String subjectivityAnswer, Locale locale,
		Locale defaultLocale);

	public void setSubjectivityAnswerCurrentLanguageId(String languageId);

	/**
	 * Sets the localized subjectivity answers of this survey answer from the map of locales and localized subjectivity answers.
	 *
	 * @param subjectivityAnswerMap the locales and localized subjectivity answers of this survey answer
	 */
	public void setSubjectivityAnswerMap(
		Map<Locale, String> subjectivityAnswerMap);

	/**
	 * Sets the localized subjectivity answers of this survey answer from the map of locales and localized subjectivity answers, and sets the default locale.
	 *
	 * @param subjectivityAnswerMap the locales and localized subjectivity answers of this survey answer
	 * @param defaultLocale the default locale
	 */
	public void setSubjectivityAnswerMap(
		Map<Locale, String> subjectivityAnswerMap, Locale defaultLocale);

	/**
	 * Returns the objecttivity answer of this survey answer.
	 *
	 * @return the objecttivity answer of this survey answer
	 */
	@AutoEscape
	public String getObjecttivityAnswer();

	/**
	 * Sets the objecttivity answer of this survey answer.
	 *
	 * @param objecttivityAnswer the objecttivity answer of this survey answer
	 */
	public void setObjecttivityAnswer(String objecttivityAnswer);

	/**
	 * Returns the answer date of this survey answer.
	 *
	 * @return the answer date of this survey answer
	 */
	public Date getAnswerDate();

	/**
	 * Sets the answer date of this survey answer.
	 *
	 * @param answerDate the answer date of this survey answer
	 */
	public void setAnswerDate(Date answerDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public String[] getAvailableLanguageIds();

	public String getDefaultLanguageId();

	public void prepareLocalizedFieldsForImport() throws LocaleException;

	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> toCacheModel();

	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer toEscapedModel();

	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}