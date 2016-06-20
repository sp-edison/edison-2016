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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link HistoryScienceApp}.
 * </p>
 *
 * @author EDISON
 * @see HistoryScienceApp
 * @generated
 */
public class HistoryScienceAppWrapper implements HistoryScienceApp,
	ModelWrapper<HistoryScienceApp> {
	public HistoryScienceAppWrapper(HistoryScienceApp historyScienceApp) {
		_historyScienceApp = historyScienceApp;
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

	/**
	* Returns the primary key of this history science app.
	*
	* @return the primary key of this history science app
	*/
	@Override
	public org.kisti.edison.project.service.persistence.HistoryScienceAppPK getPrimaryKey() {
		return _historyScienceApp.getPrimaryKey();
	}

	/**
	* Sets the primary key of this history science app.
	*
	* @param primaryKey the primary key of this history science app
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.project.service.persistence.HistoryScienceAppPK primaryKey) {
		_historyScienceApp.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the science app ID of this history science app.
	*
	* @return the science app ID of this history science app
	*/
	@Override
	public long getScienceAppId() {
		return _historyScienceApp.getScienceAppId();
	}

	/**
	* Sets the science app ID of this history science app.
	*
	* @param scienceAppId the science app ID of this history science app
	*/
	@Override
	public void setScienceAppId(long scienceAppId) {
		_historyScienceApp.setScienceAppId(scienceAppId);
	}

	/**
	* Returns the group ID of this history science app.
	*
	* @return the group ID of this history science app
	*/
	@Override
	public long getGroupId() {
		return _historyScienceApp.getGroupId();
	}

	/**
	* Sets the group ID of this history science app.
	*
	* @param groupId the group ID of this history science app
	*/
	@Override
	public void setGroupId(long groupId) {
		_historyScienceApp.setGroupId(groupId);
	}

	/**
	* Returns the project category ID of this history science app.
	*
	* @return the project category ID of this history science app
	*/
	@Override
	public long getProjectCategoryId() {
		return _historyScienceApp.getProjectCategoryId();
	}

	/**
	* Sets the project category ID of this history science app.
	*
	* @param projectCategoryId the project category ID of this history science app
	*/
	@Override
	public void setProjectCategoryId(long projectCategoryId) {
		_historyScienceApp.setProjectCategoryId(projectCategoryId);
	}

	/**
	* Returns the title of this history science app.
	*
	* @return the title of this history science app
	*/
	@Override
	public java.lang.String getTitle() {
		return _historyScienceApp.getTitle();
	}

	/**
	* Returns the localized title of this history science app in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this history science app
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _historyScienceApp.getTitle(locale);
	}

	/**
	* Returns the localized title of this history science app in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this history science app. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _historyScienceApp.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this history science app in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this history science app
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _historyScienceApp.getTitle(languageId);
	}

	/**
	* Returns the localized title of this history science app in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this history science app
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _historyScienceApp.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _historyScienceApp.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _historyScienceApp.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this history science app.
	*
	* @return the locales and localized titles of this history science app
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _historyScienceApp.getTitleMap();
	}

	/**
	* Sets the title of this history science app.
	*
	* @param title the title of this history science app
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_historyScienceApp.setTitle(title);
	}

	/**
	* Sets the localized title of this history science app in the language.
	*
	* @param title the localized title of this history science app
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_historyScienceApp.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this history science app in the language, and sets the default locale.
	*
	* @param title the localized title of this history science app
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_historyScienceApp.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_historyScienceApp.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this history science app from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this history science app
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_historyScienceApp.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this history science app from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this history science app
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_historyScienceApp.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Returns the version of this history science app.
	*
	* @return the version of this history science app
	*/
	@Override
	public java.lang.String getVersion() {
		return _historyScienceApp.getVersion();
	}

	/**
	* Sets the version of this history science app.
	*
	* @param version the version of this history science app
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_historyScienceApp.setVersion(version);
	}

	/**
	* Returns the name of this history science app.
	*
	* @return the name of this history science app
	*/
	@Override
	public java.lang.String getName() {
		return _historyScienceApp.getName();
	}

	/**
	* Returns the localized name of this history science app in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this history science app
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _historyScienceApp.getName(locale);
	}

	/**
	* Returns the localized name of this history science app in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this history science app. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _historyScienceApp.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this history science app in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this history science app
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _historyScienceApp.getName(languageId);
	}

	/**
	* Returns the localized name of this history science app in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this history science app
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _historyScienceApp.getName(languageId, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _historyScienceApp.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _historyScienceApp.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this history science app.
	*
	* @return the locales and localized names of this history science app
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
		return _historyScienceApp.getNameMap();
	}

	/**
	* Sets the name of this history science app.
	*
	* @param name the name of this history science app
	*/
	@Override
	public void setName(java.lang.String name) {
		_historyScienceApp.setName(name);
	}

	/**
	* Sets the localized name of this history science app in the language.
	*
	* @param name the localized name of this history science app
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_historyScienceApp.setName(name, locale);
	}

	/**
	* Sets the localized name of this history science app in the language, and sets the default locale.
	*
	* @param name the localized name of this history science app
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_historyScienceApp.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_historyScienceApp.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this history science app from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this history science app
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap) {
		_historyScienceApp.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this history science app from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this history science app
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_historyScienceApp.setNameMap(nameMap, defaultLocale);
	}

	/**
	* Returns the affiliation_id of this history science app.
	*
	* @return the affiliation_id of this history science app
	*/
	@Override
	public java.lang.String getAffiliation_id() {
		return _historyScienceApp.getAffiliation_id();
	}

	/**
	* Sets the affiliation_id of this history science app.
	*
	* @param affiliation_id the affiliation_id of this history science app
	*/
	@Override
	public void setAffiliation_id(java.lang.String affiliation_id) {
		_historyScienceApp.setAffiliation_id(affiliation_id);
	}

	/**
	* Returns the app status of this history science app.
	*
	* @return the app status of this history science app
	*/
	@Override
	public java.lang.String getAppStatus() {
		return _historyScienceApp.getAppStatus();
	}

	/**
	* Sets the app status of this history science app.
	*
	* @param AppStatus the app status of this history science app
	*/
	@Override
	public void setAppStatus(java.lang.String AppStatus) {
		_historyScienceApp.setAppStatus(AppStatus);
	}

	/**
	* Returns the user ID of this history science app.
	*
	* @return the user ID of this history science app
	*/
	@Override
	public long getUserId() {
		return _historyScienceApp.getUserId();
	}

	/**
	* Sets the user ID of this history science app.
	*
	* @param userId the user ID of this history science app
	*/
	@Override
	public void setUserId(long userId) {
		_historyScienceApp.setUserId(userId);
	}

	/**
	* Returns the user uuid of this history science app.
	*
	* @return the user uuid of this history science app
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _historyScienceApp.getUserUuid();
	}

	/**
	* Sets the user uuid of this history science app.
	*
	* @param userUuid the user uuid of this history science app
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_historyScienceApp.setUserUuid(userUuid);
	}

	/**
	* Returns the insert date of this history science app.
	*
	* @return the insert date of this history science app
	*/
	@Override
	public java.util.Date getInsertDate() {
		return _historyScienceApp.getInsertDate();
	}

	/**
	* Sets the insert date of this history science app.
	*
	* @param insertDate the insert date of this history science app
	*/
	@Override
	public void setInsertDate(java.util.Date insertDate) {
		_historyScienceApp.setInsertDate(insertDate);
	}

	@Override
	public boolean isNew() {
		return _historyScienceApp.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_historyScienceApp.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _historyScienceApp.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_historyScienceApp.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _historyScienceApp.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _historyScienceApp.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_historyScienceApp.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _historyScienceApp.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_historyScienceApp.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_historyScienceApp.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_historyScienceApp.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _historyScienceApp.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _historyScienceApp.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_historyScienceApp.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_historyScienceApp.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new HistoryScienceAppWrapper((HistoryScienceApp)_historyScienceApp.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.project.model.HistoryScienceApp historyScienceApp) {
		return _historyScienceApp.compareTo(historyScienceApp);
	}

	@Override
	public int hashCode() {
		return _historyScienceApp.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.project.model.HistoryScienceApp> toCacheModel() {
		return _historyScienceApp.toCacheModel();
	}

	@Override
	public org.kisti.edison.project.model.HistoryScienceApp toEscapedModel() {
		return new HistoryScienceAppWrapper(_historyScienceApp.toEscapedModel());
	}

	@Override
	public org.kisti.edison.project.model.HistoryScienceApp toUnescapedModel() {
		return new HistoryScienceAppWrapper(_historyScienceApp.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _historyScienceApp.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _historyScienceApp.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_historyScienceApp.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistoryScienceAppWrapper)) {
			return false;
		}

		HistoryScienceAppWrapper historyScienceAppWrapper = (HistoryScienceAppWrapper)obj;

		if (Validator.equals(_historyScienceApp,
					historyScienceAppWrapper._historyScienceApp)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public HistoryScienceApp getWrappedHistoryScienceApp() {
		return _historyScienceApp;
	}

	@Override
	public HistoryScienceApp getWrappedModel() {
		return _historyScienceApp;
	}

	@Override
	public void resetOriginalValues() {
		_historyScienceApp.resetOriginalValues();
	}

	private HistoryScienceApp _historyScienceApp;
}