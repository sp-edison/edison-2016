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

package org.kisti.edison.science.model;

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

import org.kisti.edison.science.service.ClpSerializer;
import org.kisti.edison.science.service.ScienceAppDescriptionLocalServiceUtil;

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
public class ScienceAppDescriptionClp extends BaseModelImpl<ScienceAppDescription>
	implements ScienceAppDescription {
	public ScienceAppDescriptionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ScienceAppDescription.class;
	}

	@Override
	public String getModelClassName() {
		return ScienceAppDescription.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _descriptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDescriptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _descriptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("descriptionId", getDescriptionId());
		attributes.put("content", getContent());
		attributes.put("insertId", getInsertId());
		attributes.put("insertDt", getInsertDt());
		attributes.put("updateId", getUpdateId());
		attributes.put("updateDt", getUpdateDt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long descriptionId = (Long)attributes.get("descriptionId");

		if (descriptionId != null) {
			setDescriptionId(descriptionId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long insertId = (Long)attributes.get("insertId");

		if (insertId != null) {
			setInsertId(insertId);
		}

		Date insertDt = (Date)attributes.get("insertDt");

		if (insertDt != null) {
			setInsertDt(insertDt);
		}

		Long updateId = (Long)attributes.get("updateId");

		if (updateId != null) {
			setUpdateId(updateId);
		}

		Date updateDt = (Date)attributes.get("updateDt");

		if (updateDt != null) {
			setUpdateDt(updateDt);
		}
	}

	@Override
	public long getDescriptionId() {
		return _descriptionId;
	}

	@Override
	public void setDescriptionId(long descriptionId) {
		_descriptionId = descriptionId;

		if (_scienceAppDescriptionRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppDescriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setDescriptionId", long.class);

				method.invoke(_scienceAppDescriptionRemoteModel, descriptionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public String getContent(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getContent(languageId);
	}

	@Override
	public String getContent(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getContent(languageId, useDefault);
	}

	@Override
	public String getContent(String languageId) {
		return LocalizationUtil.getLocalization(getContent(), languageId);
	}

	@Override
	public String getContent(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getContent(), languageId,
			useDefault);
	}

	@Override
	public String getContentCurrentLanguageId() {
		return _contentCurrentLanguageId;
	}

	@Override
	public String getContentCurrentValue() {
		Locale locale = getLocale(_contentCurrentLanguageId);

		return getContent(locale);
	}

	@Override
	public Map<Locale, String> getContentMap() {
		return LocalizationUtil.getLocalizationMap(getContent());
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_scienceAppDescriptionRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppDescriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_scienceAppDescriptionRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setContent(String content, Locale locale) {
		setContent(content, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setContent(String content, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(content)) {
			setContent(LocalizationUtil.updateLocalization(getContent(),
					"Content", content, languageId, defaultLanguageId));
		}
		else {
			setContent(LocalizationUtil.removeLocalization(getContent(),
					"Content", languageId));
		}
	}

	@Override
	public void setContentCurrentLanguageId(String languageId) {
		_contentCurrentLanguageId = languageId;
	}

	@Override
	public void setContentMap(Map<Locale, String> contentMap) {
		setContentMap(contentMap, LocaleUtil.getDefault());
	}

	@Override
	public void setContentMap(Map<Locale, String> contentMap,
		Locale defaultLocale) {
		if (contentMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setContent(LocalizationUtil.updateLocalization(contentMap,
					getContent(), "Content",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public long getInsertId() {
		return _insertId;
	}

	@Override
	public void setInsertId(long insertId) {
		_insertId = insertId;

		if (_scienceAppDescriptionRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppDescriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertId", long.class);

				method.invoke(_scienceAppDescriptionRemoteModel, insertId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getInsertDt() {
		return _insertDt;
	}

	@Override
	public void setInsertDt(Date insertDt) {
		_insertDt = insertDt;

		if (_scienceAppDescriptionRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppDescriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertDt", Date.class);

				method.invoke(_scienceAppDescriptionRemoteModel, insertDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUpdateId() {
		return _updateId;
	}

	@Override
	public void setUpdateId(long updateId) {
		_updateId = updateId;

		if (_scienceAppDescriptionRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppDescriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateId", long.class);

				method.invoke(_scienceAppDescriptionRemoteModel, updateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdateDt() {
		return _updateDt;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		_updateDt = updateDt;

		if (_scienceAppDescriptionRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppDescriptionRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateDt", Date.class);

				method.invoke(_scienceAppDescriptionRemoteModel, updateDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getScienceAppDescriptionRemoteModel() {
		return _scienceAppDescriptionRemoteModel;
	}

	public void setScienceAppDescriptionRemoteModel(
		BaseModel<?> scienceAppDescriptionRemoteModel) {
		_scienceAppDescriptionRemoteModel = scienceAppDescriptionRemoteModel;
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

		Class<?> remoteModelClass = _scienceAppDescriptionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_scienceAppDescriptionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ScienceAppDescriptionLocalServiceUtil.addScienceAppDescription(this);
		}
		else {
			ScienceAppDescriptionLocalServiceUtil.updateScienceAppDescription(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> contentMap = getContentMap();

		for (Map.Entry<Locale, String> entry : contentMap.entrySet()) {
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
		String xml = getContent();

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

		String content = getContent(defaultLocale);

		if (Validator.isNull(content)) {
			setContent(getContent(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setContent(getContent(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public ScienceAppDescription toEscapedModel() {
		return (ScienceAppDescription)ProxyUtil.newProxyInstance(ScienceAppDescription.class.getClassLoader(),
			new Class[] { ScienceAppDescription.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScienceAppDescriptionClp clone = new ScienceAppDescriptionClp();

		clone.setDescriptionId(getDescriptionId());
		clone.setContent(getContent());
		clone.setInsertId(getInsertId());
		clone.setInsertDt(getInsertDt());
		clone.setUpdateId(getUpdateId());
		clone.setUpdateDt(getUpdateDt());

		return clone;
	}

	@Override
	public int compareTo(ScienceAppDescription scienceAppDescription) {
		int value = 0;

		value = DateUtil.compareTo(getInsertDt(),
				scienceAppDescription.getInsertDt());

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

		if (!(obj instanceof ScienceAppDescriptionClp)) {
			return false;
		}

		ScienceAppDescriptionClp scienceAppDescription = (ScienceAppDescriptionClp)obj;

		long primaryKey = scienceAppDescription.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{descriptionId=");
		sb.append(getDescriptionId());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", insertId=");
		sb.append(getInsertId());
		sb.append(", insertDt=");
		sb.append(getInsertDt());
		sb.append(", updateId=");
		sb.append(getUpdateId());
		sb.append(", updateDt=");
		sb.append(getUpdateDt());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.science.model.ScienceAppDescription");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>descriptionId</column-name><column-value><![CDATA[");
		sb.append(getDescriptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertId</column-name><column-value><![CDATA[");
		sb.append(getInsertId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertDt</column-name><column-value><![CDATA[");
		sb.append(getInsertDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateId</column-name><column-value><![CDATA[");
		sb.append(getUpdateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateDt</column-name><column-value><![CDATA[");
		sb.append(getUpdateDt());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _descriptionId;
	private String _content;
	private String _contentCurrentLanguageId;
	private long _insertId;
	private Date _insertDt;
	private long _updateId;
	private Date _updateDt;
	private BaseModel<?> _scienceAppDescriptionRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.science.service.ClpSerializer.class;
}