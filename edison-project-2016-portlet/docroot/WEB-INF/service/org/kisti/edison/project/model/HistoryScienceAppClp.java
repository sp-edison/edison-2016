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

package org.kisti.edison.project.model;

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

import org.kisti.edison.project.service.ClpSerializer;
import org.kisti.edison.project.service.HistoryScienceAppLocalServiceUtil;
import org.kisti.edison.project.service.persistence.HistoryScienceAppPK;

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
public class HistoryScienceAppClp extends BaseModelImpl<HistoryScienceApp>
	implements HistoryScienceApp {
	public HistoryScienceAppClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return HistoryScienceApp.class;
	}

	@Override
	public String getModelClassName() {
		return HistoryScienceApp.class.getName();
	}

	@Override
	public HistoryScienceAppPK getPrimaryKey() {
		return new HistoryScienceAppPK(_scienceAppId, _groupId,
			_projectCategoryId);
	}

	@Override
	public void setPrimaryKey(HistoryScienceAppPK primaryKey) {
		setScienceAppId(primaryKey.scienceAppId);
		setGroupId(primaryKey.groupId);
		setProjectCategoryId(primaryKey.projectCategoryId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new HistoryScienceAppPK(_scienceAppId, _groupId,
			_projectCategoryId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((HistoryScienceAppPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("groupId", getGroupId());
		attributes.put("projectCategoryId", getProjectCategoryId());
		attributes.put("title", getTitle());
		attributes.put("version", getVersion());
		attributes.put("name", getName());
		attributes.put("affiliation_id", getAffiliation_id());
		attributes.put("AppStatus", getAppStatus());
		attributes.put("userId", getUserId());
		attributes.put("insertDate", getInsertDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long projectCategoryId = (Long)attributes.get("projectCategoryId");

		if (projectCategoryId != null) {
			setProjectCategoryId(projectCategoryId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String affiliation_id = (String)attributes.get("affiliation_id");

		if (affiliation_id != null) {
			setAffiliation_id(affiliation_id);
		}

		String AppStatus = (String)attributes.get("AppStatus");

		if (AppStatus != null) {
			setAppStatus(AppStatus);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date insertDate = (Date)attributes.get("insertDate");

		if (insertDate != null) {
			setInsertDate(insertDate);
		}
	}

	@Override
	public long getScienceAppId() {
		return _scienceAppId;
	}

	@Override
	public void setScienceAppId(long scienceAppId) {
		_scienceAppId = scienceAppId;

		if (_historyScienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _historyScienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setScienceAppId", long.class);

				method.invoke(_historyScienceAppRemoteModel, scienceAppId);
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

		if (_historyScienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _historyScienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_historyScienceAppRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProjectCategoryId() {
		return _projectCategoryId;
	}

	@Override
	public void setProjectCategoryId(long projectCategoryId) {
		_projectCategoryId = projectCategoryId;

		if (_historyScienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _historyScienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectCategoryId",
						long.class);

				method.invoke(_historyScienceAppRemoteModel, projectCategoryId);
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

		if (_historyScienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _historyScienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_historyScienceAppRemoteModel, title);
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
	public String getVersion() {
		return _version;
	}

	@Override
	public void setVersion(String version) {
		_version = version;

		if (_historyScienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _historyScienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_historyScienceAppRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getName(), languageId,
			useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_historyScienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _historyScienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_historyScienceAppRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(LocalizationUtil.updateLocalization(getName(), "Name",
					name, languageId, defaultLanguageId));
		}
		else {
			setName(LocalizationUtil.removeLocalization(getName(), "Name",
					languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setName(LocalizationUtil.updateLocalization(nameMap, getName(),
					"Name", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getAffiliation_id() {
		return _affiliation_id;
	}

	@Override
	public void setAffiliation_id(String affiliation_id) {
		_affiliation_id = affiliation_id;

		if (_historyScienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _historyScienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setAffiliation_id",
						String.class);

				method.invoke(_historyScienceAppRemoteModel, affiliation_id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAppStatus() {
		return _AppStatus;
	}

	@Override
	public void setAppStatus(String AppStatus) {
		_AppStatus = AppStatus;

		if (_historyScienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _historyScienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setAppStatus", String.class);

				method.invoke(_historyScienceAppRemoteModel, AppStatus);
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

		if (_historyScienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _historyScienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_historyScienceAppRemoteModel, userId);
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
	public Date getInsertDate() {
		return _insertDate;
	}

	@Override
	public void setInsertDate(Date insertDate) {
		_insertDate = insertDate;

		if (_historyScienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _historyScienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertDate", Date.class);

				method.invoke(_historyScienceAppRemoteModel, insertDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getHistoryScienceAppRemoteModel() {
		return _historyScienceAppRemoteModel;
	}

	public void setHistoryScienceAppRemoteModel(
		BaseModel<?> historyScienceAppRemoteModel) {
		_historyScienceAppRemoteModel = historyScienceAppRemoteModel;
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

		Class<?> remoteModelClass = _historyScienceAppRemoteModel.getClass();

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

		Object returnValue = method.invoke(_historyScienceAppRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			HistoryScienceAppLocalServiceUtil.addHistoryScienceApp(this);
		}
		else {
			HistoryScienceAppLocalServiceUtil.updateHistoryScienceApp(this);
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

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
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

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public HistoryScienceApp toEscapedModel() {
		return (HistoryScienceApp)ProxyUtil.newProxyInstance(HistoryScienceApp.class.getClassLoader(),
			new Class[] { HistoryScienceApp.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HistoryScienceAppClp clone = new HistoryScienceAppClp();

		clone.setScienceAppId(getScienceAppId());
		clone.setGroupId(getGroupId());
		clone.setProjectCategoryId(getProjectCategoryId());
		clone.setTitle(getTitle());
		clone.setVersion(getVersion());
		clone.setName(getName());
		clone.setAffiliation_id(getAffiliation_id());
		clone.setAppStatus(getAppStatus());
		clone.setUserId(getUserId());
		clone.setInsertDate(getInsertDate());

		return clone;
	}

	@Override
	public int compareTo(HistoryScienceApp historyScienceApp) {
		HistoryScienceAppPK primaryKey = historyScienceApp.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistoryScienceAppClp)) {
			return false;
		}

		HistoryScienceAppClp historyScienceApp = (HistoryScienceAppClp)obj;

		HistoryScienceAppPK primaryKey = historyScienceApp.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{scienceAppId=");
		sb.append(getScienceAppId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", projectCategoryId=");
		sb.append(getProjectCategoryId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", affiliation_id=");
		sb.append(getAffiliation_id());
		sb.append(", AppStatus=");
		sb.append(getAppStatus());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", insertDate=");
		sb.append(getInsertDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.project.model.HistoryScienceApp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scienceAppId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectCategoryId</column-name><column-value><![CDATA[");
		sb.append(getProjectCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>affiliation_id</column-name><column-value><![CDATA[");
		sb.append(getAffiliation_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AppStatus</column-name><column-value><![CDATA[");
		sb.append(getAppStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertDate</column-name><column-value><![CDATA[");
		sb.append(getInsertDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _scienceAppId;
	private long _groupId;
	private long _projectCategoryId;
	private String _title;
	private String _titleCurrentLanguageId;
	private String _version;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _affiliation_id;
	private String _AppStatus;
	private long _userId;
	private String _userUuid;
	private Date _insertDate;
	private BaseModel<?> _historyScienceAppRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.project.service.ClpSerializer.class;
}