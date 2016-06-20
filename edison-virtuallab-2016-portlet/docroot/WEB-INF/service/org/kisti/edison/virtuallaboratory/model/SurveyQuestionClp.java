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
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.kisti.edison.virtuallaboratory.service.ClpSerializer;
import org.kisti.edison.virtuallaboratory.service.SurveyQuestionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author EDISON
 */
public class SurveyQuestionClp extends BaseModelImpl<SurveyQuestion>
	implements SurveyQuestion {
	public SurveyQuestionClp() {
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
	public long getPrimaryKey() {
		return _questionSeqNo;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setQuestionSeqNo(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _questionSeqNo;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getQuestionSeqNo() {
		return _questionSeqNo;
	}

	@Override
	public void setQuestionSeqNo(long questionSeqNo) {
		_questionSeqNo = questionSeqNo;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestionSeqNo", long.class);

				method.invoke(_surveyQuestionRemoteModel, questionSeqNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQuestionDivCd() {
		return _questionDivCd;
	}

	@Override
	public void setQuestionDivCd(String questionDivCd) {
		_questionDivCd = questionDivCd;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestionDivCd", String.class);

				method.invoke(_surveyQuestionRemoteModel, questionDivCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQuestionTitle() {
		return _questionTitle;
	}

	@Override
	public String getQuestionTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestionTitle(languageId);
	}

	@Override
	public String getQuestionTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestionTitle(languageId, useDefault);
	}

	@Override
	public String getQuestionTitle(String languageId) {
		return LocalizationUtil.getLocalization(getQuestionTitle(), languageId);
	}

	@Override
	public String getQuestionTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getQuestionTitle(), languageId,
			useDefault);
	}

	@Override
	public String getQuestionTitleCurrentLanguageId() {
		return _questionTitleCurrentLanguageId;
	}

	@Override
	public String getQuestionTitleCurrentValue() {
		Locale locale = getLocale(_questionTitleCurrentLanguageId);

		return getQuestionTitle(locale);
	}

	@Override
	public Map<Locale, String> getQuestionTitleMap() {
		return LocalizationUtil.getLocalizationMap(getQuestionTitle());
	}

	@Override
	public void setQuestionTitle(String questionTitle) {
		_questionTitle = questionTitle;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestionTitle", String.class);

				method.invoke(_surveyQuestionRemoteModel, questionTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setQuestionTitle(String questionTitle, Locale locale) {
		setQuestionTitle(questionTitle, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestionTitle(String questionTitle, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(questionTitle)) {
			setQuestionTitle(LocalizationUtil.updateLocalization(
					getQuestionTitle(), "QuestionTitle", questionTitle,
					languageId, defaultLanguageId));
		}
		else {
			setQuestionTitle(LocalizationUtil.removeLocalization(
					getQuestionTitle(), "QuestionTitle", languageId));
		}
	}

	@Override
	public void setQuestionTitleCurrentLanguageId(String languageId) {
		_questionTitleCurrentLanguageId = languageId;
	}

	@Override
	public void setQuestionTitleMap(Map<Locale, String> questionTitleMap) {
		setQuestionTitleMap(questionTitleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestionTitleMap(Map<Locale, String> questionTitleMap,
		Locale defaultLocale) {
		if (questionTitleMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setQuestionTitle(LocalizationUtil.updateLocalization(
					questionTitleMap, getQuestionTitle(), "QuestionTitle",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getQuestion1() {
		return _question1;
	}

	@Override
	public String getQuestion1(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion1(languageId);
	}

	@Override
	public String getQuestion1(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion1(languageId, useDefault);
	}

	@Override
	public String getQuestion1(String languageId) {
		return LocalizationUtil.getLocalization(getQuestion1(), languageId);
	}

	@Override
	public String getQuestion1(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getQuestion1(), languageId,
			useDefault);
	}

	@Override
	public String getQuestion1CurrentLanguageId() {
		return _question1CurrentLanguageId;
	}

	@Override
	public String getQuestion1CurrentValue() {
		Locale locale = getLocale(_question1CurrentLanguageId);

		return getQuestion1(locale);
	}

	@Override
	public Map<Locale, String> getQuestion1Map() {
		return LocalizationUtil.getLocalizationMap(getQuestion1());
	}

	@Override
	public void setQuestion1(String question1) {
		_question1 = question1;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion1", String.class);

				method.invoke(_surveyQuestionRemoteModel, question1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setQuestion1(String question1, Locale locale) {
		setQuestion1(question1, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion1(String question1, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(question1)) {
			setQuestion1(LocalizationUtil.updateLocalization(getQuestion1(),
					"Question1", question1, languageId, defaultLanguageId));
		}
		else {
			setQuestion1(LocalizationUtil.removeLocalization(getQuestion1(),
					"Question1", languageId));
		}
	}

	@Override
	public void setQuestion1CurrentLanguageId(String languageId) {
		_question1CurrentLanguageId = languageId;
	}

	@Override
	public void setQuestion1Map(Map<Locale, String> question1Map) {
		setQuestion1Map(question1Map, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion1Map(Map<Locale, String> question1Map,
		Locale defaultLocale) {
		if (question1Map == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setQuestion1(LocalizationUtil.updateLocalization(question1Map,
					getQuestion1(), "Question1",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getQuestion2() {
		return _question2;
	}

	@Override
	public String getQuestion2(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion2(languageId);
	}

	@Override
	public String getQuestion2(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion2(languageId, useDefault);
	}

	@Override
	public String getQuestion2(String languageId) {
		return LocalizationUtil.getLocalization(getQuestion2(), languageId);
	}

	@Override
	public String getQuestion2(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getQuestion2(), languageId,
			useDefault);
	}

	@Override
	public String getQuestion2CurrentLanguageId() {
		return _question2CurrentLanguageId;
	}

	@Override
	public String getQuestion2CurrentValue() {
		Locale locale = getLocale(_question2CurrentLanguageId);

		return getQuestion2(locale);
	}

	@Override
	public Map<Locale, String> getQuestion2Map() {
		return LocalizationUtil.getLocalizationMap(getQuestion2());
	}

	@Override
	public void setQuestion2(String question2) {
		_question2 = question2;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion2", String.class);

				method.invoke(_surveyQuestionRemoteModel, question2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setQuestion2(String question2, Locale locale) {
		setQuestion2(question2, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion2(String question2, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(question2)) {
			setQuestion2(LocalizationUtil.updateLocalization(getQuestion2(),
					"Question2", question2, languageId, defaultLanguageId));
		}
		else {
			setQuestion2(LocalizationUtil.removeLocalization(getQuestion2(),
					"Question2", languageId));
		}
	}

	@Override
	public void setQuestion2CurrentLanguageId(String languageId) {
		_question2CurrentLanguageId = languageId;
	}

	@Override
	public void setQuestion2Map(Map<Locale, String> question2Map) {
		setQuestion2Map(question2Map, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion2Map(Map<Locale, String> question2Map,
		Locale defaultLocale) {
		if (question2Map == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setQuestion2(LocalizationUtil.updateLocalization(question2Map,
					getQuestion2(), "Question2",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getQuestion3() {
		return _question3;
	}

	@Override
	public String getQuestion3(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion3(languageId);
	}

	@Override
	public String getQuestion3(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion3(languageId, useDefault);
	}

	@Override
	public String getQuestion3(String languageId) {
		return LocalizationUtil.getLocalization(getQuestion3(), languageId);
	}

	@Override
	public String getQuestion3(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getQuestion3(), languageId,
			useDefault);
	}

	@Override
	public String getQuestion3CurrentLanguageId() {
		return _question3CurrentLanguageId;
	}

	@Override
	public String getQuestion3CurrentValue() {
		Locale locale = getLocale(_question3CurrentLanguageId);

		return getQuestion3(locale);
	}

	@Override
	public Map<Locale, String> getQuestion3Map() {
		return LocalizationUtil.getLocalizationMap(getQuestion3());
	}

	@Override
	public void setQuestion3(String question3) {
		_question3 = question3;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion3", String.class);

				method.invoke(_surveyQuestionRemoteModel, question3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setQuestion3(String question3, Locale locale) {
		setQuestion3(question3, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion3(String question3, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(question3)) {
			setQuestion3(LocalizationUtil.updateLocalization(getQuestion3(),
					"Question3", question3, languageId, defaultLanguageId));
		}
		else {
			setQuestion3(LocalizationUtil.removeLocalization(getQuestion3(),
					"Question3", languageId));
		}
	}

	@Override
	public void setQuestion3CurrentLanguageId(String languageId) {
		_question3CurrentLanguageId = languageId;
	}

	@Override
	public void setQuestion3Map(Map<Locale, String> question3Map) {
		setQuestion3Map(question3Map, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion3Map(Map<Locale, String> question3Map,
		Locale defaultLocale) {
		if (question3Map == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setQuestion3(LocalizationUtil.updateLocalization(question3Map,
					getQuestion3(), "Question3",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getQuestion4() {
		return _question4;
	}

	@Override
	public String getQuestion4(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion4(languageId);
	}

	@Override
	public String getQuestion4(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion4(languageId, useDefault);
	}

	@Override
	public String getQuestion4(String languageId) {
		return LocalizationUtil.getLocalization(getQuestion4(), languageId);
	}

	@Override
	public String getQuestion4(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getQuestion4(), languageId,
			useDefault);
	}

	@Override
	public String getQuestion4CurrentLanguageId() {
		return _question4CurrentLanguageId;
	}

	@Override
	public String getQuestion4CurrentValue() {
		Locale locale = getLocale(_question4CurrentLanguageId);

		return getQuestion4(locale);
	}

	@Override
	public Map<Locale, String> getQuestion4Map() {
		return LocalizationUtil.getLocalizationMap(getQuestion4());
	}

	@Override
	public void setQuestion4(String question4) {
		_question4 = question4;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion4", String.class);

				method.invoke(_surveyQuestionRemoteModel, question4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setQuestion4(String question4, Locale locale) {
		setQuestion4(question4, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion4(String question4, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(question4)) {
			setQuestion4(LocalizationUtil.updateLocalization(getQuestion4(),
					"Question4", question4, languageId, defaultLanguageId));
		}
		else {
			setQuestion4(LocalizationUtil.removeLocalization(getQuestion4(),
					"Question4", languageId));
		}
	}

	@Override
	public void setQuestion4CurrentLanguageId(String languageId) {
		_question4CurrentLanguageId = languageId;
	}

	@Override
	public void setQuestion4Map(Map<Locale, String> question4Map) {
		setQuestion4Map(question4Map, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion4Map(Map<Locale, String> question4Map,
		Locale defaultLocale) {
		if (question4Map == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setQuestion4(LocalizationUtil.updateLocalization(question4Map,
					getQuestion4(), "Question4",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getQuestion5() {
		return _question5;
	}

	@Override
	public String getQuestion5(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion5(languageId);
	}

	@Override
	public String getQuestion5(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion5(languageId, useDefault);
	}

	@Override
	public String getQuestion5(String languageId) {
		return LocalizationUtil.getLocalization(getQuestion5(), languageId);
	}

	@Override
	public String getQuestion5(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getQuestion5(), languageId,
			useDefault);
	}

	@Override
	public String getQuestion5CurrentLanguageId() {
		return _question5CurrentLanguageId;
	}

	@Override
	public String getQuestion5CurrentValue() {
		Locale locale = getLocale(_question5CurrentLanguageId);

		return getQuestion5(locale);
	}

	@Override
	public Map<Locale, String> getQuestion5Map() {
		return LocalizationUtil.getLocalizationMap(getQuestion5());
	}

	@Override
	public void setQuestion5(String question5) {
		_question5 = question5;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion5", String.class);

				method.invoke(_surveyQuestionRemoteModel, question5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setQuestion5(String question5, Locale locale) {
		setQuestion5(question5, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion5(String question5, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(question5)) {
			setQuestion5(LocalizationUtil.updateLocalization(getQuestion5(),
					"Question5", question5, languageId, defaultLanguageId));
		}
		else {
			setQuestion5(LocalizationUtil.removeLocalization(getQuestion5(),
					"Question5", languageId));
		}
	}

	@Override
	public void setQuestion5CurrentLanguageId(String languageId) {
		_question5CurrentLanguageId = languageId;
	}

	@Override
	public void setQuestion5Map(Map<Locale, String> question5Map) {
		setQuestion5Map(question5Map, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion5Map(Map<Locale, String> question5Map,
		Locale defaultLocale) {
		if (question5Map == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setQuestion5(LocalizationUtil.updateLocalization(question5Map,
					getQuestion5(), "Question5",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getQuestion6() {
		return _question6;
	}

	@Override
	public String getQuestion6(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion6(languageId);
	}

	@Override
	public String getQuestion6(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion6(languageId, useDefault);
	}

	@Override
	public String getQuestion6(String languageId) {
		return LocalizationUtil.getLocalization(getQuestion6(), languageId);
	}

	@Override
	public String getQuestion6(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getQuestion6(), languageId,
			useDefault);
	}

	@Override
	public String getQuestion6CurrentLanguageId() {
		return _question6CurrentLanguageId;
	}

	@Override
	public String getQuestion6CurrentValue() {
		Locale locale = getLocale(_question6CurrentLanguageId);

		return getQuestion6(locale);
	}

	@Override
	public Map<Locale, String> getQuestion6Map() {
		return LocalizationUtil.getLocalizationMap(getQuestion6());
	}

	@Override
	public void setQuestion6(String question6) {
		_question6 = question6;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion6", String.class);

				method.invoke(_surveyQuestionRemoteModel, question6);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setQuestion6(String question6, Locale locale) {
		setQuestion6(question6, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion6(String question6, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(question6)) {
			setQuestion6(LocalizationUtil.updateLocalization(getQuestion6(),
					"Question6", question6, languageId, defaultLanguageId));
		}
		else {
			setQuestion6(LocalizationUtil.removeLocalization(getQuestion6(),
					"Question6", languageId));
		}
	}

	@Override
	public void setQuestion6CurrentLanguageId(String languageId) {
		_question6CurrentLanguageId = languageId;
	}

	@Override
	public void setQuestion6Map(Map<Locale, String> question6Map) {
		setQuestion6Map(question6Map, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion6Map(Map<Locale, String> question6Map,
		Locale defaultLocale) {
		if (question6Map == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setQuestion6(LocalizationUtil.updateLocalization(question6Map,
					getQuestion6(), "Question6",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getQuestion7() {
		return _question7;
	}

	@Override
	public String getQuestion7(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion7(languageId);
	}

	@Override
	public String getQuestion7(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion7(languageId, useDefault);
	}

	@Override
	public String getQuestion7(String languageId) {
		return LocalizationUtil.getLocalization(getQuestion7(), languageId);
	}

	@Override
	public String getQuestion7(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getQuestion7(), languageId,
			useDefault);
	}

	@Override
	public String getQuestion7CurrentLanguageId() {
		return _question7CurrentLanguageId;
	}

	@Override
	public String getQuestion7CurrentValue() {
		Locale locale = getLocale(_question7CurrentLanguageId);

		return getQuestion7(locale);
	}

	@Override
	public Map<Locale, String> getQuestion7Map() {
		return LocalizationUtil.getLocalizationMap(getQuestion7());
	}

	@Override
	public void setQuestion7(String question7) {
		_question7 = question7;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion7", String.class);

				method.invoke(_surveyQuestionRemoteModel, question7);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setQuestion7(String question7, Locale locale) {
		setQuestion7(question7, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion7(String question7, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(question7)) {
			setQuestion7(LocalizationUtil.updateLocalization(getQuestion7(),
					"Question7", question7, languageId, defaultLanguageId));
		}
		else {
			setQuestion7(LocalizationUtil.removeLocalization(getQuestion7(),
					"Question7", languageId));
		}
	}

	@Override
	public void setQuestion7CurrentLanguageId(String languageId) {
		_question7CurrentLanguageId = languageId;
	}

	@Override
	public void setQuestion7Map(Map<Locale, String> question7Map) {
		setQuestion7Map(question7Map, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion7Map(Map<Locale, String> question7Map,
		Locale defaultLocale) {
		if (question7Map == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setQuestion7(LocalizationUtil.updateLocalization(question7Map,
					getQuestion7(), "Question7",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getQuestion8() {
		return _question8;
	}

	@Override
	public String getQuestion8(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion8(languageId);
	}

	@Override
	public String getQuestion8(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion8(languageId, useDefault);
	}

	@Override
	public String getQuestion8(String languageId) {
		return LocalizationUtil.getLocalization(getQuestion8(), languageId);
	}

	@Override
	public String getQuestion8(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getQuestion8(), languageId,
			useDefault);
	}

	@Override
	public String getQuestion8CurrentLanguageId() {
		return _question8CurrentLanguageId;
	}

	@Override
	public String getQuestion8CurrentValue() {
		Locale locale = getLocale(_question8CurrentLanguageId);

		return getQuestion8(locale);
	}

	@Override
	public Map<Locale, String> getQuestion8Map() {
		return LocalizationUtil.getLocalizationMap(getQuestion8());
	}

	@Override
	public void setQuestion8(String question8) {
		_question8 = question8;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion8", String.class);

				method.invoke(_surveyQuestionRemoteModel, question8);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setQuestion8(String question8, Locale locale) {
		setQuestion8(question8, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion8(String question8, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(question8)) {
			setQuestion8(LocalizationUtil.updateLocalization(getQuestion8(),
					"Question8", question8, languageId, defaultLanguageId));
		}
		else {
			setQuestion8(LocalizationUtil.removeLocalization(getQuestion8(),
					"Question8", languageId));
		}
	}

	@Override
	public void setQuestion8CurrentLanguageId(String languageId) {
		_question8CurrentLanguageId = languageId;
	}

	@Override
	public void setQuestion8Map(Map<Locale, String> question8Map) {
		setQuestion8Map(question8Map, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion8Map(Map<Locale, String> question8Map,
		Locale defaultLocale) {
		if (question8Map == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setQuestion8(LocalizationUtil.updateLocalization(question8Map,
					getQuestion8(), "Question8",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getQuestion9() {
		return _question9;
	}

	@Override
	public String getQuestion9(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion9(languageId);
	}

	@Override
	public String getQuestion9(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion9(languageId, useDefault);
	}

	@Override
	public String getQuestion9(String languageId) {
		return LocalizationUtil.getLocalization(getQuestion9(), languageId);
	}

	@Override
	public String getQuestion9(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getQuestion9(), languageId,
			useDefault);
	}

	@Override
	public String getQuestion9CurrentLanguageId() {
		return _question9CurrentLanguageId;
	}

	@Override
	public String getQuestion9CurrentValue() {
		Locale locale = getLocale(_question9CurrentLanguageId);

		return getQuestion9(locale);
	}

	@Override
	public Map<Locale, String> getQuestion9Map() {
		return LocalizationUtil.getLocalizationMap(getQuestion9());
	}

	@Override
	public void setQuestion9(String question9) {
		_question9 = question9;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion9", String.class);

				method.invoke(_surveyQuestionRemoteModel, question9);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setQuestion9(String question9, Locale locale) {
		setQuestion9(question9, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion9(String question9, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(question9)) {
			setQuestion9(LocalizationUtil.updateLocalization(getQuestion9(),
					"Question9", question9, languageId, defaultLanguageId));
		}
		else {
			setQuestion9(LocalizationUtil.removeLocalization(getQuestion9(),
					"Question9", languageId));
		}
	}

	@Override
	public void setQuestion9CurrentLanguageId(String languageId) {
		_question9CurrentLanguageId = languageId;
	}

	@Override
	public void setQuestion9Map(Map<Locale, String> question9Map) {
		setQuestion9Map(question9Map, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion9Map(Map<Locale, String> question9Map,
		Locale defaultLocale) {
		if (question9Map == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setQuestion9(LocalizationUtil.updateLocalization(question9Map,
					getQuestion9(), "Question9",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getQuestion10() {
		return _question10;
	}

	@Override
	public String getQuestion10(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion10(languageId);
	}

	@Override
	public String getQuestion10(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getQuestion10(languageId, useDefault);
	}

	@Override
	public String getQuestion10(String languageId) {
		return LocalizationUtil.getLocalization(getQuestion10(), languageId);
	}

	@Override
	public String getQuestion10(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getQuestion10(), languageId,
			useDefault);
	}

	@Override
	public String getQuestion10CurrentLanguageId() {
		return _question10CurrentLanguageId;
	}

	@Override
	public String getQuestion10CurrentValue() {
		Locale locale = getLocale(_question10CurrentLanguageId);

		return getQuestion10(locale);
	}

	@Override
	public Map<Locale, String> getQuestion10Map() {
		return LocalizationUtil.getLocalizationMap(getQuestion10());
	}

	@Override
	public void setQuestion10(String question10) {
		_question10 = question10;

		if (_surveyQuestionRemoteModel != null) {
			try {
				Class<?> clazz = _surveyQuestionRemoteModel.getClass();

				Method method = clazz.getMethod("setQuestion10", String.class);

				method.invoke(_surveyQuestionRemoteModel, question10);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setQuestion10(String question10, Locale locale) {
		setQuestion10(question10, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion10(String question10, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(question10)) {
			setQuestion10(LocalizationUtil.updateLocalization(getQuestion10(),
					"Question10", question10, languageId, defaultLanguageId));
		}
		else {
			setQuestion10(LocalizationUtil.removeLocalization(getQuestion10(),
					"Question10", languageId));
		}
	}

	@Override
	public void setQuestion10CurrentLanguageId(String languageId) {
		_question10CurrentLanguageId = languageId;
	}

	@Override
	public void setQuestion10Map(Map<Locale, String> question10Map) {
		setQuestion10Map(question10Map, LocaleUtil.getDefault());
	}

	@Override
	public void setQuestion10Map(Map<Locale, String> question10Map,
		Locale defaultLocale) {
		if (question10Map == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setQuestion10(LocalizationUtil.updateLocalization(question10Map,
					getQuestion10(), "Question10",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public BaseModel<?> getSurveyQuestionRemoteModel() {
		return _surveyQuestionRemoteModel;
	}

	public void setSurveyQuestionRemoteModel(
		BaseModel<?> surveyQuestionRemoteModel) {
		_surveyQuestionRemoteModel = surveyQuestionRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _surveyQuestionRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_surveyQuestionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SurveyQuestionLocalServiceUtil.addSurveyQuestion(this);
		}
		else {
			SurveyQuestionLocalServiceUtil.updateSurveyQuestion(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> questionTitleMap = getQuestionTitleMap();

		for (Map.Entry<Locale, String> entry : questionTitleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> question1Map = getQuestion1Map();

		for (Map.Entry<Locale, String> entry : question1Map.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> question2Map = getQuestion2Map();

		for (Map.Entry<Locale, String> entry : question2Map.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> question3Map = getQuestion3Map();

		for (Map.Entry<Locale, String> entry : question3Map.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> question4Map = getQuestion4Map();

		for (Map.Entry<Locale, String> entry : question4Map.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> question5Map = getQuestion5Map();

		for (Map.Entry<Locale, String> entry : question5Map.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> question6Map = getQuestion6Map();

		for (Map.Entry<Locale, String> entry : question6Map.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> question7Map = getQuestion7Map();

		for (Map.Entry<Locale, String> entry : question7Map.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> question8Map = getQuestion8Map();

		for (Map.Entry<Locale, String> entry : question8Map.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> question9Map = getQuestion9Map();

		for (Map.Entry<Locale, String> entry : question9Map.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> question10Map = getQuestion10Map();

		for (Map.Entry<Locale, String> entry : question10Map.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getQuestionTitle();

		if (xml == null) {
			return StringPool.BLANK;
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String questionTitle = getQuestionTitle(defaultLocale);

		if (Validator.isNull(questionTitle)) {
			setQuestionTitle(getQuestionTitle(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setQuestionTitle(getQuestionTitle(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String question1 = getQuestion1(defaultLocale);

		if (Validator.isNull(question1)) {
			setQuestion1(getQuestion1(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setQuestion1(getQuestion1(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String question2 = getQuestion2(defaultLocale);

		if (Validator.isNull(question2)) {
			setQuestion2(getQuestion2(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setQuestion2(getQuestion2(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String question3 = getQuestion3(defaultLocale);

		if (Validator.isNull(question3)) {
			setQuestion3(getQuestion3(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setQuestion3(getQuestion3(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String question4 = getQuestion4(defaultLocale);

		if (Validator.isNull(question4)) {
			setQuestion4(getQuestion4(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setQuestion4(getQuestion4(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String question5 = getQuestion5(defaultLocale);

		if (Validator.isNull(question5)) {
			setQuestion5(getQuestion5(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setQuestion5(getQuestion5(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String question6 = getQuestion6(defaultLocale);

		if (Validator.isNull(question6)) {
			setQuestion6(getQuestion6(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setQuestion6(getQuestion6(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String question7 = getQuestion7(defaultLocale);

		if (Validator.isNull(question7)) {
			setQuestion7(getQuestion7(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setQuestion7(getQuestion7(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String question8 = getQuestion8(defaultLocale);

		if (Validator.isNull(question8)) {
			setQuestion8(getQuestion8(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setQuestion8(getQuestion8(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String question9 = getQuestion9(defaultLocale);

		if (Validator.isNull(question9)) {
			setQuestion9(getQuestion9(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setQuestion9(getQuestion9(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String question10 = getQuestion10(defaultLocale);

		if (Validator.isNull(question10)) {
			setQuestion10(getQuestion10(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setQuestion10(getQuestion10(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public SurveyQuestion toEscapedModel() {
		return (SurveyQuestion)ProxyUtil.newProxyInstance(SurveyQuestion.class.getClassLoader(),
			new Class[] { SurveyQuestion.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SurveyQuestionClp clone = new SurveyQuestionClp();

		clone.setQuestionSeqNo(getQuestionSeqNo());
		clone.setQuestionDivCd(getQuestionDivCd());
		clone.setQuestionTitle(getQuestionTitle());
		clone.setQuestion1(getQuestion1());
		clone.setQuestion2(getQuestion2());
		clone.setQuestion3(getQuestion3());
		clone.setQuestion4(getQuestion4());
		clone.setQuestion5(getQuestion5());
		clone.setQuestion6(getQuestion6());
		clone.setQuestion7(getQuestion7());
		clone.setQuestion8(getQuestion8());
		clone.setQuestion9(getQuestion9());
		clone.setQuestion10(getQuestion10());

		return clone;
	}

	@Override
	public int compareTo(SurveyQuestion surveyQuestion) {
		int value = 0;

		if (getQuestionSeqNo() < surveyQuestion.getQuestionSeqNo()) {
			value = -1;
		}
		else if (getQuestionSeqNo() > surveyQuestion.getQuestionSeqNo()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyQuestionClp)) {
			return false;
		}

		SurveyQuestionClp surveyQuestion = (SurveyQuestionClp)obj;

		long primaryKey = surveyQuestion.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{questionSeqNo=");
		sb.append(getQuestionSeqNo());
		sb.append(", questionDivCd=");
		sb.append(getQuestionDivCd());
		sb.append(", questionTitle=");
		sb.append(getQuestionTitle());
		sb.append(", question1=");
		sb.append(getQuestion1());
		sb.append(", question2=");
		sb.append(getQuestion2());
		sb.append(", question3=");
		sb.append(getQuestion3());
		sb.append(", question4=");
		sb.append(getQuestion4());
		sb.append(", question5=");
		sb.append(getQuestion5());
		sb.append(", question6=");
		sb.append(getQuestion6());
		sb.append(", question7=");
		sb.append(getQuestion7());
		sb.append(", question8=");
		sb.append(getQuestion8());
		sb.append(", question9=");
		sb.append(getQuestion9());
		sb.append(", question10=");
		sb.append(getQuestion10());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.virtuallaboratory.model.SurveyQuestion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>questionSeqNo</column-name><column-value><![CDATA[");
		sb.append(getQuestionSeqNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questionDivCd</column-name><column-value><![CDATA[");
		sb.append(getQuestionDivCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>questionTitle</column-name><column-value><![CDATA[");
		sb.append(getQuestionTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question1</column-name><column-value><![CDATA[");
		sb.append(getQuestion1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question2</column-name><column-value><![CDATA[");
		sb.append(getQuestion2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question3</column-name><column-value><![CDATA[");
		sb.append(getQuestion3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question4</column-name><column-value><![CDATA[");
		sb.append(getQuestion4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question5</column-name><column-value><![CDATA[");
		sb.append(getQuestion5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question6</column-name><column-value><![CDATA[");
		sb.append(getQuestion6());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question7</column-name><column-value><![CDATA[");
		sb.append(getQuestion7());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question8</column-name><column-value><![CDATA[");
		sb.append(getQuestion8());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question9</column-name><column-value><![CDATA[");
		sb.append(getQuestion9());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question10</column-name><column-value><![CDATA[");
		sb.append(getQuestion10());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _questionSeqNo;
	private String _questionDivCd;
	private String _questionTitle;
	private String _questionTitleCurrentLanguageId;
	private String _question1;
	private String _question1CurrentLanguageId;
	private String _question2;
	private String _question2CurrentLanguageId;
	private String _question3;
	private String _question3CurrentLanguageId;
	private String _question4;
	private String _question4CurrentLanguageId;
	private String _question5;
	private String _question5CurrentLanguageId;
	private String _question6;
	private String _question6CurrentLanguageId;
	private String _question7;
	private String _question7CurrentLanguageId;
	private String _question8;
	private String _question8CurrentLanguageId;
	private String _question9;
	private String _question9CurrentLanguageId;
	private String _question10;
	private String _question10CurrentLanguageId;
	private BaseModel<?> _surveyQuestionRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.virtuallaboratory.service.ClpSerializer.class;
}