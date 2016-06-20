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
import com.liferay.portal.kernel.util.DateUtil;
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
import org.kisti.edison.virtuallaboratory.service.SurveyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author EDISON
 */
public class SurveyClp extends BaseModelImpl<Survey> implements Survey {
	public SurveyClp() {
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
	public long getPrimaryKey() {
		return _surveySeqNo;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSurveySeqNo(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _surveySeqNo;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSurveySeqNo() {
		return _surveySeqNo;
	}

	@Override
	public void setSurveySeqNo(long surveySeqNo) {
		_surveySeqNo = surveySeqNo;

		if (_surveyRemoteModel != null) {
			try {
				Class<?> clazz = _surveyRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveySeqNo", long.class);

				method.invoke(_surveyRemoteModel, surveySeqNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSurveyUseYn() {
		return _surveyUseYn;
	}

	@Override
	public void setSurveyUseYn(String surveyUseYn) {
		_surveyUseYn = surveyUseYn;

		if (_surveyRemoteModel != null) {
			try {
				Class<?> clazz = _surveyRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyUseYn", String.class);

				method.invoke(_surveyRemoteModel, surveyUseYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSurveyTitle() {
		return _surveyTitle;
	}

	@Override
	public String getSurveyTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSurveyTitle(languageId);
	}

	@Override
	public String getSurveyTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSurveyTitle(languageId, useDefault);
	}

	@Override
	public String getSurveyTitle(String languageId) {
		return LocalizationUtil.getLocalization(getSurveyTitle(), languageId);
	}

	@Override
	public String getSurveyTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getSurveyTitle(), languageId,
			useDefault);
	}

	@Override
	public String getSurveyTitleCurrentLanguageId() {
		return _surveyTitleCurrentLanguageId;
	}

	@Override
	public String getSurveyTitleCurrentValue() {
		Locale locale = getLocale(_surveyTitleCurrentLanguageId);

		return getSurveyTitle(locale);
	}

	@Override
	public Map<Locale, String> getSurveyTitleMap() {
		return LocalizationUtil.getLocalizationMap(getSurveyTitle());
	}

	@Override
	public void setSurveyTitle(String surveyTitle) {
		_surveyTitle = surveyTitle;

		if (_surveyRemoteModel != null) {
			try {
				Class<?> clazz = _surveyRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyTitle", String.class);

				method.invoke(_surveyRemoteModel, surveyTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setSurveyTitle(String surveyTitle, Locale locale) {
		setSurveyTitle(surveyTitle, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setSurveyTitle(String surveyTitle, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(surveyTitle)) {
			setSurveyTitle(LocalizationUtil.updateLocalization(
					getSurveyTitle(), "SurveyTitle", surveyTitle, languageId,
					defaultLanguageId));
		}
		else {
			setSurveyTitle(LocalizationUtil.removeLocalization(
					getSurveyTitle(), "SurveyTitle", languageId));
		}
	}

	@Override
	public void setSurveyTitleCurrentLanguageId(String languageId) {
		_surveyTitleCurrentLanguageId = languageId;
	}

	@Override
	public void setSurveyTitleMap(Map<Locale, String> surveyTitleMap) {
		setSurveyTitleMap(surveyTitleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setSurveyTitleMap(Map<Locale, String> surveyTitleMap,
		Locale defaultLocale) {
		if (surveyTitleMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setSurveyTitle(LocalizationUtil.updateLocalization(surveyTitleMap,
					getSurveyTitle(), "SurveyTitle",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getSurveyStartDate() {
		return _surveyStartDate;
	}

	@Override
	public void setSurveyStartDate(String surveyStartDate) {
		_surveyStartDate = surveyStartDate;

		if (_surveyRemoteModel != null) {
			try {
				Class<?> clazz = _surveyRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyStartDate",
						String.class);

				method.invoke(_surveyRemoteModel, surveyStartDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSurveyEndDate() {
		return _surveyEndDate;
	}

	@Override
	public void setSurveyEndDate(String surveyEndDate) {
		_surveyEndDate = surveyEndDate;

		if (_surveyRemoteModel != null) {
			try {
				Class<?> clazz = _surveyRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyEndDate", String.class);

				method.invoke(_surveyRemoteModel, surveyEndDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSurveyStatus() {
		return _surveyStatus;
	}

	@Override
	public void setSurveyStatus(String surveyStatus) {
		_surveyStatus = surveyStatus;

		if (_surveyRemoteModel != null) {
			try {
				Class<?> clazz = _surveyRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyStatus", String.class);

				method.invoke(_surveyRemoteModel, surveyStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSurveyCreateDate() {
		return _surveyCreateDate;
	}

	@Override
	public void setSurveyCreateDate(Date surveyCreateDate) {
		_surveyCreateDate = surveyCreateDate;

		if (_surveyRemoteModel != null) {
			try {
				Class<?> clazz = _surveyRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyCreateDate",
						Date.class);

				method.invoke(_surveyRemoteModel, surveyCreateDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSurveyRemoteModel() {
		return _surveyRemoteModel;
	}

	public void setSurveyRemoteModel(BaseModel<?> surveyRemoteModel) {
		_surveyRemoteModel = surveyRemoteModel;
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

		Class<?> remoteModelClass = _surveyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_surveyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SurveyLocalServiceUtil.addSurvey(this);
		}
		else {
			SurveyLocalServiceUtil.updateSurvey(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> surveyTitleMap = getSurveyTitleMap();

		for (Map.Entry<Locale, String> entry : surveyTitleMap.entrySet()) {
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
		String xml = getSurveyTitle();

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

		String surveyTitle = getSurveyTitle(defaultLocale);

		if (Validator.isNull(surveyTitle)) {
			setSurveyTitle(getSurveyTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setSurveyTitle(getSurveyTitle(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public Survey toEscapedModel() {
		return (Survey)ProxyUtil.newProxyInstance(Survey.class.getClassLoader(),
			new Class[] { Survey.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SurveyClp clone = new SurveyClp();

		clone.setSurveySeqNo(getSurveySeqNo());
		clone.setSurveyUseYn(getSurveyUseYn());
		clone.setSurveyTitle(getSurveyTitle());
		clone.setSurveyStartDate(getSurveyStartDate());
		clone.setSurveyEndDate(getSurveyEndDate());
		clone.setSurveyStatus(getSurveyStatus());
		clone.setSurveyCreateDate(getSurveyCreateDate());

		return clone;
	}

	@Override
	public int compareTo(Survey survey) {
		int value = 0;

		value = DateUtil.compareTo(getSurveyCreateDate(),
				survey.getSurveyCreateDate());

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

		if (!(obj instanceof SurveyClp)) {
			return false;
		}

		SurveyClp survey = (SurveyClp)obj;

		long primaryKey = survey.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{surveySeqNo=");
		sb.append(getSurveySeqNo());
		sb.append(", surveyUseYn=");
		sb.append(getSurveyUseYn());
		sb.append(", surveyTitle=");
		sb.append(getSurveyTitle());
		sb.append(", surveyStartDate=");
		sb.append(getSurveyStartDate());
		sb.append(", surveyEndDate=");
		sb.append(getSurveyEndDate());
		sb.append(", surveyStatus=");
		sb.append(getSurveyStatus());
		sb.append(", surveyCreateDate=");
		sb.append(getSurveyCreateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.virtuallaboratory.model.Survey");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>surveySeqNo</column-name><column-value><![CDATA[");
		sb.append(getSurveySeqNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyUseYn</column-name><column-value><![CDATA[");
		sb.append(getSurveyUseYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyTitle</column-name><column-value><![CDATA[");
		sb.append(getSurveyTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyStartDate</column-name><column-value><![CDATA[");
		sb.append(getSurveyStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyEndDate</column-name><column-value><![CDATA[");
		sb.append(getSurveyEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyStatus</column-name><column-value><![CDATA[");
		sb.append(getSurveyStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surveyCreateDate</column-name><column-value><![CDATA[");
		sb.append(getSurveyCreateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _surveySeqNo;
	private String _surveyUseYn;
	private String _surveyTitle;
	private String _surveyTitleCurrentLanguageId;
	private String _surveyStartDate;
	private String _surveyEndDate;
	private String _surveyStatus;
	private Date _surveyCreateDate;
	private BaseModel<?> _surveyRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.virtuallaboratory.service.ClpSerializer.class;
}