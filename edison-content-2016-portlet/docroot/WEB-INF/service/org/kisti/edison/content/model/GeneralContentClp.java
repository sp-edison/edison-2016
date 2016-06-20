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

package org.kisti.edison.content.model;

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

import org.kisti.edison.content.service.ClpSerializer;
import org.kisti.edison.content.service.GeneralContentLocalServiceUtil;
import org.kisti.edison.content.service.persistence.GeneralContentPK;

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
public class GeneralContentClp extends BaseModelImpl<GeneralContent>
	implements GeneralContent {
	public GeneralContentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GeneralContent.class;
	}

	@Override
	public String getModelClassName() {
		return GeneralContent.class.getName();
	}

	@Override
	public GeneralContentPK getPrimaryKey() {
		return new GeneralContentPK(_contentSeq, _groupId);
	}

	@Override
	public void setPrimaryKey(GeneralContentPK primaryKey) {
		setContentSeq(primaryKey.contentSeq);
		setGroupId(primaryKey.groupId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new GeneralContentPK(_contentSeq, _groupId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((GeneralContentPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentSeq", getContentSeq());
		attributes.put("groupId", getGroupId());
		attributes.put("contentDiv", getContentDiv());
		attributes.put("title", getTitle());
		attributes.put("downloadCnt", getDownloadCnt());
		attributes.put("serviceLanguage", getServiceLanguage());
		attributes.put("projectYn", getProjectYn());
		attributes.put("projectId", getProjectId());
		attributes.put("insertId", getInsertId());
		attributes.put("insertDate", getInsertDate());
		attributes.put("updateId", getUpdateId());
		attributes.put("updateDate", getUpdateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contentSeq = (Long)attributes.get("contentSeq");

		if (contentSeq != null) {
			setContentSeq(contentSeq);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long contentDiv = (Long)attributes.get("contentDiv");

		if (contentDiv != null) {
			setContentDiv(contentDiv);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Long downloadCnt = (Long)attributes.get("downloadCnt");

		if (downloadCnt != null) {
			setDownloadCnt(downloadCnt);
		}

		String serviceLanguage = (String)attributes.get("serviceLanguage");

		if (serviceLanguage != null) {
			setServiceLanguage(serviceLanguage);
		}

		String projectYn = (String)attributes.get("projectYn");

		if (projectYn != null) {
			setProjectYn(projectYn);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long insertId = (Long)attributes.get("insertId");

		if (insertId != null) {
			setInsertId(insertId);
		}

		Date insertDate = (Date)attributes.get("insertDate");

		if (insertDate != null) {
			setInsertDate(insertDate);
		}

		Long updateId = (Long)attributes.get("updateId");

		if (updateId != null) {
			setUpdateId(updateId);
		}

		Date updateDate = (Date)attributes.get("updateDate");

		if (updateDate != null) {
			setUpdateDate(updateDate);
		}
	}

	@Override
	public long getContentSeq() {
		return _contentSeq;
	}

	@Override
	public void setContentSeq(long contentSeq) {
		_contentSeq = contentSeq;

		if (_generalContentRemoteModel != null) {
			try {
				Class<?> clazz = _generalContentRemoteModel.getClass();

				Method method = clazz.getMethod("setContentSeq", long.class);

				method.invoke(_generalContentRemoteModel, contentSeq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_generalContentRemoteModel != null) {
			try {
				Class<?> clazz = _generalContentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_generalContentRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getContentDiv() {
		return _contentDiv;
	}

	@Override
	public void setContentDiv(long contentDiv) {
		_contentDiv = contentDiv;

		if (_generalContentRemoteModel != null) {
			try {
				Class<?> clazz = _generalContentRemoteModel.getClass();

				Method method = clazz.getMethod("setContentDiv", long.class);

				method.invoke(_generalContentRemoteModel, contentDiv);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public String getTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId);
	}

	@Override
	public String getTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId, useDefault);
	}

	@Override
	public String getTitle(String languageId) {
		return LocalizationUtil.getLocalization(getTitle(), languageId);
	}

	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getTitle(), languageId,
			useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return _titleCurrentLanguageId;
	}

	@Override
	public String getTitleCurrentValue() {
		Locale locale = getLocale(_titleCurrentLanguageId);

		return getTitle(locale);
	}

	@Override
	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_generalContentRemoteModel != null) {
			try {
				Class<?> clazz = _generalContentRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_generalContentRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setTitle(String title, Locale locale) {
		setTitle(title, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setTitle(String title, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(title)) {
			setTitle(LocalizationUtil.updateLocalization(getTitle(), "Title",
					title, languageId, defaultLanguageId));
		}
		else {
			setTitle(LocalizationUtil.removeLocalization(getTitle(), "Title",
					languageId));
		}
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		_titleCurrentLanguageId = languageId;
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap) {
		setTitleMap(titleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale) {
		if (titleMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setTitle(LocalizationUtil.updateLocalization(titleMap, getTitle(),
					"Title", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public long getDownloadCnt() {
		return _downloadCnt;
	}

	@Override
	public void setDownloadCnt(long downloadCnt) {
		_downloadCnt = downloadCnt;

		if (_generalContentRemoteModel != null) {
			try {
				Class<?> clazz = _generalContentRemoteModel.getClass();

				Method method = clazz.getMethod("setDownloadCnt", long.class);

				method.invoke(_generalContentRemoteModel, downloadCnt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceLanguage() {
		return _serviceLanguage;
	}

	@Override
	public void setServiceLanguage(String serviceLanguage) {
		_serviceLanguage = serviceLanguage;

		if (_generalContentRemoteModel != null) {
			try {
				Class<?> clazz = _generalContentRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceLanguage",
						String.class);

				method.invoke(_generalContentRemoteModel, serviceLanguage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjectYn() {
		return _projectYn;
	}

	@Override
	public void setProjectYn(String projectYn) {
		_projectYn = projectYn;

		if (_generalContentRemoteModel != null) {
			try {
				Class<?> clazz = _generalContentRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectYn", String.class);

				method.invoke(_generalContentRemoteModel, projectYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_projectId = projectId;

		if (_generalContentRemoteModel != null) {
			try {
				Class<?> clazz = _generalContentRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectId", long.class);

				method.invoke(_generalContentRemoteModel, projectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
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

		if (_generalContentRemoteModel != null) {
			try {
				Class<?> clazz = _generalContentRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertId", long.class);

				method.invoke(_generalContentRemoteModel, insertId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getInsertDate() {
		return _insertDate;
	}

	@Override
	public void setInsertDate(Date insertDate) {
		_insertDate = insertDate;

		if (_generalContentRemoteModel != null) {
			try {
				Class<?> clazz = _generalContentRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertDate", Date.class);

				method.invoke(_generalContentRemoteModel, insertDate);
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

		if (_generalContentRemoteModel != null) {
			try {
				Class<?> clazz = _generalContentRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateId", long.class);

				method.invoke(_generalContentRemoteModel, updateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdateDate() {
		return _updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;

		if (_generalContentRemoteModel != null) {
			try {
				Class<?> clazz = _generalContentRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateDate", Date.class);

				method.invoke(_generalContentRemoteModel, updateDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGeneralContentRemoteModel() {
		return _generalContentRemoteModel;
	}

	public void setGeneralContentRemoteModel(
		BaseModel<?> generalContentRemoteModel) {
		_generalContentRemoteModel = generalContentRemoteModel;
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

		Class<?> remoteModelClass = _generalContentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_generalContentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GeneralContentLocalServiceUtil.addGeneralContent(this);
		}
		else {
			GeneralContentLocalServiceUtil.updateGeneralContent(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> titleMap = getTitleMap();

		for (Map.Entry<Locale, String> entry : titleMap.entrySet()) {
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
		String xml = getTitle();

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

		String title = getTitle(defaultLocale);

		if (Validator.isNull(title)) {
			setTitle(getTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setTitle(getTitle(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public GeneralContent toEscapedModel() {
		return (GeneralContent)ProxyUtil.newProxyInstance(GeneralContent.class.getClassLoader(),
			new Class[] { GeneralContent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GeneralContentClp clone = new GeneralContentClp();

		clone.setContentSeq(getContentSeq());
		clone.setGroupId(getGroupId());
		clone.setContentDiv(getContentDiv());
		clone.setTitle(getTitle());
		clone.setDownloadCnt(getDownloadCnt());
		clone.setServiceLanguage(getServiceLanguage());
		clone.setProjectYn(getProjectYn());
		clone.setProjectId(getProjectId());
		clone.setInsertId(getInsertId());
		clone.setInsertDate(getInsertDate());
		clone.setUpdateId(getUpdateId());
		clone.setUpdateDate(getUpdateDate());

		return clone;
	}

	@Override
	public int compareTo(GeneralContent generalContent) {
		int value = 0;

		if (getContentSeq() < generalContent.getContentSeq()) {
			value = -1;
		}
		else if (getContentSeq() > generalContent.getContentSeq()) {
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

		if (!(obj instanceof GeneralContentClp)) {
			return false;
		}

		GeneralContentClp generalContent = (GeneralContentClp)obj;

		GeneralContentPK primaryKey = generalContent.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{contentSeq=");
		sb.append(getContentSeq());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", contentDiv=");
		sb.append(getContentDiv());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", downloadCnt=");
		sb.append(getDownloadCnt());
		sb.append(", serviceLanguage=");
		sb.append(getServiceLanguage());
		sb.append(", projectYn=");
		sb.append(getProjectYn());
		sb.append(", projectId=");
		sb.append(getProjectId());
		sb.append(", insertId=");
		sb.append(getInsertId());
		sb.append(", insertDate=");
		sb.append(getInsertDate());
		sb.append(", updateId=");
		sb.append(getUpdateId());
		sb.append(", updateDate=");
		sb.append(getUpdateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.content.model.GeneralContent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contentSeq</column-name><column-value><![CDATA[");
		sb.append(getContentSeq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentDiv</column-name><column-value><![CDATA[");
		sb.append(getContentDiv());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>downloadCnt</column-name><column-value><![CDATA[");
		sb.append(getDownloadCnt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceLanguage</column-name><column-value><![CDATA[");
		sb.append(getServiceLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectYn</column-name><column-value><![CDATA[");
		sb.append(getProjectYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectId</column-name><column-value><![CDATA[");
		sb.append(getProjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertId</column-name><column-value><![CDATA[");
		sb.append(getInsertId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertDate</column-name><column-value><![CDATA[");
		sb.append(getInsertDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateId</column-name><column-value><![CDATA[");
		sb.append(getUpdateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateDate</column-name><column-value><![CDATA[");
		sb.append(getUpdateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _contentSeq;
	private long _groupId;
	private long _contentDiv;
	private String _title;
	private String _titleCurrentLanguageId;
	private long _downloadCnt;
	private String _serviceLanguage;
	private String _projectYn;
	private long _projectId;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
	private BaseModel<?> _generalContentRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.content.service.ClpSerializer.class;
}