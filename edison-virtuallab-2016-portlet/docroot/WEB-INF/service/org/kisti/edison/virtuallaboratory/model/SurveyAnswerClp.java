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
import com.liferay.portal.util.PortalUtil;

import org.kisti.edison.virtuallaboratory.service.ClpSerializer;
import org.kisti.edison.virtuallaboratory.service.SurveyAnswerLocalServiceUtil;

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
public class SurveyAnswerClp extends BaseModelImpl<SurveyAnswer>
	implements SurveyAnswer {
	public SurveyAnswerClp() {
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
	public long getPrimaryKey() {
		return _SurveyAnswerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSurveyAnswerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _SurveyAnswerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSurveyAnswerId() {
		return _SurveyAnswerId;
	}

	@Override
	public void setSurveyAnswerId(long SurveyAnswerId) {
		_SurveyAnswerId = SurveyAnswerId;

		if (_surveyAnswerRemoteModel != null) {
			try {
				Class<?> clazz = _surveyAnswerRemoteModel.getClass();

				Method method = clazz.getMethod("setSurveyAnswerId", long.class);

				method.invoke(_surveyAnswerRemoteModel, SurveyAnswerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_surveyAnswerRemoteModel != null) {
			try {
				Class<?> clazz = _surveyAnswerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_surveyAnswerRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public long getVirtualLabId() {
		return _virtualLabId;
	}

	@Override
	public void setVirtualLabId(long virtualLabId) {
		_virtualLabId = virtualLabId;

		if (_surveyAnswerRemoteModel != null) {
			try {
				Class<?> clazz = _surveyAnswerRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualLabId", long.class);

				method.invoke(_surveyAnswerRemoteModel, virtualLabId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassId() {
		return _classId;
	}

	@Override
	public void setClassId(long classId) {
		_classId = classId;

		if (_surveyAnswerRemoteModel != null) {
			try {
				Class<?> clazz = _surveyAnswerRemoteModel.getClass();

				Method method = clazz.getMethod("setClassId", long.class);

				method.invoke(_surveyAnswerRemoteModel, classId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubjectivityAnswer() {
		return _subjectivityAnswer;
	}

	@Override
	public String getSubjectivityAnswer(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSubjectivityAnswer(languageId);
	}

	@Override
	public String getSubjectivityAnswer(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSubjectivityAnswer(languageId, useDefault);
	}

	@Override
	public String getSubjectivityAnswer(String languageId) {
		return LocalizationUtil.getLocalization(getSubjectivityAnswer(),
			languageId);
	}

	@Override
	public String getSubjectivityAnswer(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getSubjectivityAnswer(),
			languageId, useDefault);
	}

	@Override
	public String getSubjectivityAnswerCurrentLanguageId() {
		return _subjectivityAnswerCurrentLanguageId;
	}

	@Override
	public String getSubjectivityAnswerCurrentValue() {
		Locale locale = getLocale(_subjectivityAnswerCurrentLanguageId);

		return getSubjectivityAnswer(locale);
	}

	@Override
	public Map<Locale, String> getSubjectivityAnswerMap() {
		return LocalizationUtil.getLocalizationMap(getSubjectivityAnswer());
	}

	@Override
	public void setSubjectivityAnswer(String subjectivityAnswer) {
		_subjectivityAnswer = subjectivityAnswer;

		if (_surveyAnswerRemoteModel != null) {
			try {
				Class<?> clazz = _surveyAnswerRemoteModel.getClass();

				Method method = clazz.getMethod("setSubjectivityAnswer",
						String.class);

				method.invoke(_surveyAnswerRemoteModel, subjectivityAnswer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setSubjectivityAnswer(String subjectivityAnswer, Locale locale) {
		setSubjectivityAnswer(subjectivityAnswer, locale,
			LocaleUtil.getDefault());
	}

	@Override
	public void setSubjectivityAnswer(String subjectivityAnswer, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(subjectivityAnswer)) {
			setSubjectivityAnswer(LocalizationUtil.updateLocalization(
					getSubjectivityAnswer(), "SubjectivityAnswer",
					subjectivityAnswer, languageId, defaultLanguageId));
		}
		else {
			setSubjectivityAnswer(LocalizationUtil.removeLocalization(
					getSubjectivityAnswer(), "SubjectivityAnswer", languageId));
		}
	}

	@Override
	public void setSubjectivityAnswerCurrentLanguageId(String languageId) {
		_subjectivityAnswerCurrentLanguageId = languageId;
	}

	@Override
	public void setSubjectivityAnswerMap(
		Map<Locale, String> subjectivityAnswerMap) {
		setSubjectivityAnswerMap(subjectivityAnswerMap, LocaleUtil.getDefault());
	}

	@Override
	public void setSubjectivityAnswerMap(
		Map<Locale, String> subjectivityAnswerMap, Locale defaultLocale) {
		if (subjectivityAnswerMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setSubjectivityAnswer(LocalizationUtil.updateLocalization(
					subjectivityAnswerMap, getSubjectivityAnswer(),
					"SubjectivityAnswer", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getObjecttivityAnswer() {
		return _objecttivityAnswer;
	}

	@Override
	public void setObjecttivityAnswer(String objecttivityAnswer) {
		_objecttivityAnswer = objecttivityAnswer;

		if (_surveyAnswerRemoteModel != null) {
			try {
				Class<?> clazz = _surveyAnswerRemoteModel.getClass();

				Method method = clazz.getMethod("setObjecttivityAnswer",
						String.class);

				method.invoke(_surveyAnswerRemoteModel, objecttivityAnswer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAnswerDate() {
		return _answerDate;
	}

	@Override
	public void setAnswerDate(Date answerDate) {
		_answerDate = answerDate;

		if (_surveyAnswerRemoteModel != null) {
			try {
				Class<?> clazz = _surveyAnswerRemoteModel.getClass();

				Method method = clazz.getMethod("setAnswerDate", Date.class);

				method.invoke(_surveyAnswerRemoteModel, answerDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSurveyAnswerRemoteModel() {
		return _surveyAnswerRemoteModel;
	}

	public void setSurveyAnswerRemoteModel(BaseModel<?> surveyAnswerRemoteModel) {
		_surveyAnswerRemoteModel = surveyAnswerRemoteModel;
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

		Class<?> remoteModelClass = _surveyAnswerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_surveyAnswerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SurveyAnswerLocalServiceUtil.addSurveyAnswer(this);
		}
		else {
			SurveyAnswerLocalServiceUtil.updateSurveyAnswer(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> subjectivityAnswerMap = getSubjectivityAnswerMap();

		for (Map.Entry<Locale, String> entry : subjectivityAnswerMap.entrySet()) {
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
		String xml = getSubjectivityAnswer();

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

		String subjectivityAnswer = getSubjectivityAnswer(defaultLocale);

		if (Validator.isNull(subjectivityAnswer)) {
			setSubjectivityAnswer(getSubjectivityAnswer(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setSubjectivityAnswer(getSubjectivityAnswer(defaultLocale),
				defaultLocale, defaultLocale);
		}
	}

	@Override
	public SurveyAnswer toEscapedModel() {
		return (SurveyAnswer)ProxyUtil.newProxyInstance(SurveyAnswer.class.getClassLoader(),
			new Class[] { SurveyAnswer.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SurveyAnswerClp clone = new SurveyAnswerClp();

		clone.setSurveyAnswerId(getSurveyAnswerId());
		clone.setUserId(getUserId());
		clone.setVirtualLabId(getVirtualLabId());
		clone.setClassId(getClassId());
		clone.setSubjectivityAnswer(getSubjectivityAnswer());
		clone.setObjecttivityAnswer(getObjecttivityAnswer());
		clone.setAnswerDate(getAnswerDate());

		return clone;
	}

	@Override
	public int compareTo(SurveyAnswer surveyAnswer) {
		long primaryKey = surveyAnswer.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SurveyAnswerClp)) {
			return false;
		}

		SurveyAnswerClp surveyAnswer = (SurveyAnswerClp)obj;

		long primaryKey = surveyAnswer.getPrimaryKey();

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

		sb.append("{SurveyAnswerId=");
		sb.append(getSurveyAnswerId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", virtualLabId=");
		sb.append(getVirtualLabId());
		sb.append(", classId=");
		sb.append(getClassId());
		sb.append(", subjectivityAnswer=");
		sb.append(getSubjectivityAnswer());
		sb.append(", objecttivityAnswer=");
		sb.append(getObjecttivityAnswer());
		sb.append(", answerDate=");
		sb.append(getAnswerDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.virtuallaboratory.model.SurveyAnswer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>SurveyAnswerId</column-name><column-value><![CDATA[");
		sb.append(getSurveyAnswerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualLabId</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classId</column-name><column-value><![CDATA[");
		sb.append(getClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subjectivityAnswer</column-name><column-value><![CDATA[");
		sb.append(getSubjectivityAnswer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>objecttivityAnswer</column-name><column-value><![CDATA[");
		sb.append(getObjecttivityAnswer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answerDate</column-name><column-value><![CDATA[");
		sb.append(getAnswerDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _SurveyAnswerId;
	private long _userId;
	private String _userUuid;
	private long _virtualLabId;
	private long _classId;
	private String _subjectivityAnswer;
	private String _subjectivityAnswerCurrentLanguageId;
	private String _objecttivityAnswer;
	private Date _answerDate;
	private BaseModel<?> _surveyAnswerRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.virtuallaboratory.service.ClpSerializer.class;
}