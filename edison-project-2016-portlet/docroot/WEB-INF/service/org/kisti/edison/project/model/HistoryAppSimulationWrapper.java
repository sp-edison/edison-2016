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
 * This class is a wrapper for {@link HistoryAppSimulation}.
 * </p>
 *
 * @author EDISON
 * @see HistoryAppSimulation
 * @generated
 */
public class HistoryAppSimulationWrapper implements HistoryAppSimulation,
	ModelWrapper<HistoryAppSimulation> {
	public HistoryAppSimulationWrapper(
		HistoryAppSimulation historyAppSimulation) {
		_historyAppSimulation = historyAppSimulation;
	}

	@Override
	public Class<?> getModelClass() {
		return HistoryAppSimulation.class;
	}

	@Override
	public String getModelClassName() {
		return HistoryAppSimulation.class.getName();
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
		attributes.put("runtime", getRuntime());
		attributes.put("executeCount", getExecuteCount());
		attributes.put("averageRuntime", getAverageRuntime());
		attributes.put("userCount", getUserCount());
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

		Long runtime = (Long)attributes.get("runtime");

		if (runtime != null) {
			setRuntime(runtime);
		}

		Long executeCount = (Long)attributes.get("executeCount");

		if (executeCount != null) {
			setExecuteCount(executeCount);
		}

		Long averageRuntime = (Long)attributes.get("averageRuntime");

		if (averageRuntime != null) {
			setAverageRuntime(averageRuntime);
		}

		Long userCount = (Long)attributes.get("userCount");

		if (userCount != null) {
			setUserCount(userCount);
		}

		Date insertDate = (Date)attributes.get("insertDate");

		if (insertDate != null) {
			setInsertDate(insertDate);
		}
	}

	/**
	* Returns the primary key of this history app simulation.
	*
	* @return the primary key of this history app simulation
	*/
	@Override
	public org.kisti.edison.project.service.persistence.HistoryAppSimulationPK getPrimaryKey() {
		return _historyAppSimulation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this history app simulation.
	*
	* @param primaryKey the primary key of this history app simulation
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.project.service.persistence.HistoryAppSimulationPK primaryKey) {
		_historyAppSimulation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the science app ID of this history app simulation.
	*
	* @return the science app ID of this history app simulation
	*/
	@Override
	public long getScienceAppId() {
		return _historyAppSimulation.getScienceAppId();
	}

	/**
	* Sets the science app ID of this history app simulation.
	*
	* @param scienceAppId the science app ID of this history app simulation
	*/
	@Override
	public void setScienceAppId(long scienceAppId) {
		_historyAppSimulation.setScienceAppId(scienceAppId);
	}

	/**
	* Returns the group ID of this history app simulation.
	*
	* @return the group ID of this history app simulation
	*/
	@Override
	public long getGroupId() {
		return _historyAppSimulation.getGroupId();
	}

	/**
	* Sets the group ID of this history app simulation.
	*
	* @param groupId the group ID of this history app simulation
	*/
	@Override
	public void setGroupId(long groupId) {
		_historyAppSimulation.setGroupId(groupId);
	}

	/**
	* Returns the project category ID of this history app simulation.
	*
	* @return the project category ID of this history app simulation
	*/
	@Override
	public long getProjectCategoryId() {
		return _historyAppSimulation.getProjectCategoryId();
	}

	/**
	* Sets the project category ID of this history app simulation.
	*
	* @param projectCategoryId the project category ID of this history app simulation
	*/
	@Override
	public void setProjectCategoryId(long projectCategoryId) {
		_historyAppSimulation.setProjectCategoryId(projectCategoryId);
	}

	/**
	* Returns the title of this history app simulation.
	*
	* @return the title of this history app simulation
	*/
	@Override
	public java.lang.String getTitle() {
		return _historyAppSimulation.getTitle();
	}

	/**
	* Returns the localized title of this history app simulation in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this history app simulation
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _historyAppSimulation.getTitle(locale);
	}

	/**
	* Returns the localized title of this history app simulation in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this history app simulation. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _historyAppSimulation.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this history app simulation in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this history app simulation
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _historyAppSimulation.getTitle(languageId);
	}

	/**
	* Returns the localized title of this history app simulation in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this history app simulation
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _historyAppSimulation.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _historyAppSimulation.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _historyAppSimulation.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this history app simulation.
	*
	* @return the locales and localized titles of this history app simulation
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _historyAppSimulation.getTitleMap();
	}

	/**
	* Sets the title of this history app simulation.
	*
	* @param title the title of this history app simulation
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_historyAppSimulation.setTitle(title);
	}

	/**
	* Sets the localized title of this history app simulation in the language.
	*
	* @param title the localized title of this history app simulation
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_historyAppSimulation.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this history app simulation in the language, and sets the default locale.
	*
	* @param title the localized title of this history app simulation
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_historyAppSimulation.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_historyAppSimulation.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this history app simulation from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this history app simulation
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_historyAppSimulation.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this history app simulation from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this history app simulation
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_historyAppSimulation.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Returns the version of this history app simulation.
	*
	* @return the version of this history app simulation
	*/
	@Override
	public java.lang.String getVersion() {
		return _historyAppSimulation.getVersion();
	}

	/**
	* Sets the version of this history app simulation.
	*
	* @param version the version of this history app simulation
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_historyAppSimulation.setVersion(version);
	}

	/**
	* Returns the name of this history app simulation.
	*
	* @return the name of this history app simulation
	*/
	@Override
	public java.lang.String getName() {
		return _historyAppSimulation.getName();
	}

	/**
	* Returns the localized name of this history app simulation in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this history app simulation
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _historyAppSimulation.getName(locale);
	}

	/**
	* Returns the localized name of this history app simulation in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this history app simulation. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _historyAppSimulation.getName(locale, useDefault);
	}

	/**
	* Returns the localized name of this history app simulation in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this history app simulation
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _historyAppSimulation.getName(languageId);
	}

	/**
	* Returns the localized name of this history app simulation in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this history app simulation
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _historyAppSimulation.getName(languageId, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _historyAppSimulation.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _historyAppSimulation.getNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized names of this history app simulation.
	*
	* @return the locales and localized names of this history app simulation
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
		return _historyAppSimulation.getNameMap();
	}

	/**
	* Sets the name of this history app simulation.
	*
	* @param name the name of this history app simulation
	*/
	@Override
	public void setName(java.lang.String name) {
		_historyAppSimulation.setName(name);
	}

	/**
	* Sets the localized name of this history app simulation in the language.
	*
	* @param name the localized name of this history app simulation
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_historyAppSimulation.setName(name, locale);
	}

	/**
	* Sets the localized name of this history app simulation in the language, and sets the default locale.
	*
	* @param name the localized name of this history app simulation
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_historyAppSimulation.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_historyAppSimulation.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this history app simulation from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this history app simulation
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap) {
		_historyAppSimulation.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this history app simulation from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this history app simulation
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_historyAppSimulation.setNameMap(nameMap, defaultLocale);
	}

	/**
	* Returns the affiliation_id of this history app simulation.
	*
	* @return the affiliation_id of this history app simulation
	*/
	@Override
	public java.lang.String getAffiliation_id() {
		return _historyAppSimulation.getAffiliation_id();
	}

	/**
	* Sets the affiliation_id of this history app simulation.
	*
	* @param affiliation_id the affiliation_id of this history app simulation
	*/
	@Override
	public void setAffiliation_id(java.lang.String affiliation_id) {
		_historyAppSimulation.setAffiliation_id(affiliation_id);
	}

	/**
	* Returns the app status of this history app simulation.
	*
	* @return the app status of this history app simulation
	*/
	@Override
	public java.lang.String getAppStatus() {
		return _historyAppSimulation.getAppStatus();
	}

	/**
	* Sets the app status of this history app simulation.
	*
	* @param AppStatus the app status of this history app simulation
	*/
	@Override
	public void setAppStatus(java.lang.String AppStatus) {
		_historyAppSimulation.setAppStatus(AppStatus);
	}

	/**
	* Returns the user ID of this history app simulation.
	*
	* @return the user ID of this history app simulation
	*/
	@Override
	public long getUserId() {
		return _historyAppSimulation.getUserId();
	}

	/**
	* Sets the user ID of this history app simulation.
	*
	* @param userId the user ID of this history app simulation
	*/
	@Override
	public void setUserId(long userId) {
		_historyAppSimulation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this history app simulation.
	*
	* @return the user uuid of this history app simulation
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _historyAppSimulation.getUserUuid();
	}

	/**
	* Sets the user uuid of this history app simulation.
	*
	* @param userUuid the user uuid of this history app simulation
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_historyAppSimulation.setUserUuid(userUuid);
	}

	/**
	* Returns the runtime of this history app simulation.
	*
	* @return the runtime of this history app simulation
	*/
	@Override
	public long getRuntime() {
		return _historyAppSimulation.getRuntime();
	}

	/**
	* Sets the runtime of this history app simulation.
	*
	* @param runtime the runtime of this history app simulation
	*/
	@Override
	public void setRuntime(long runtime) {
		_historyAppSimulation.setRuntime(runtime);
	}

	/**
	* Returns the execute count of this history app simulation.
	*
	* @return the execute count of this history app simulation
	*/
	@Override
	public long getExecuteCount() {
		return _historyAppSimulation.getExecuteCount();
	}

	/**
	* Sets the execute count of this history app simulation.
	*
	* @param executeCount the execute count of this history app simulation
	*/
	@Override
	public void setExecuteCount(long executeCount) {
		_historyAppSimulation.setExecuteCount(executeCount);
	}

	/**
	* Returns the average runtime of this history app simulation.
	*
	* @return the average runtime of this history app simulation
	*/
	@Override
	public long getAverageRuntime() {
		return _historyAppSimulation.getAverageRuntime();
	}

	/**
	* Sets the average runtime of this history app simulation.
	*
	* @param averageRuntime the average runtime of this history app simulation
	*/
	@Override
	public void setAverageRuntime(long averageRuntime) {
		_historyAppSimulation.setAverageRuntime(averageRuntime);
	}

	/**
	* Returns the user count of this history app simulation.
	*
	* @return the user count of this history app simulation
	*/
	@Override
	public long getUserCount() {
		return _historyAppSimulation.getUserCount();
	}

	/**
	* Sets the user count of this history app simulation.
	*
	* @param userCount the user count of this history app simulation
	*/
	@Override
	public void setUserCount(long userCount) {
		_historyAppSimulation.setUserCount(userCount);
	}

	/**
	* Returns the insert date of this history app simulation.
	*
	* @return the insert date of this history app simulation
	*/
	@Override
	public java.util.Date getInsertDate() {
		return _historyAppSimulation.getInsertDate();
	}

	/**
	* Sets the insert date of this history app simulation.
	*
	* @param insertDate the insert date of this history app simulation
	*/
	@Override
	public void setInsertDate(java.util.Date insertDate) {
		_historyAppSimulation.setInsertDate(insertDate);
	}

	@Override
	public boolean isNew() {
		return _historyAppSimulation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_historyAppSimulation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _historyAppSimulation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_historyAppSimulation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _historyAppSimulation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _historyAppSimulation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_historyAppSimulation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _historyAppSimulation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_historyAppSimulation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_historyAppSimulation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_historyAppSimulation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _historyAppSimulation.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _historyAppSimulation.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_historyAppSimulation.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_historyAppSimulation.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new HistoryAppSimulationWrapper((HistoryAppSimulation)_historyAppSimulation.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.project.model.HistoryAppSimulation historyAppSimulation) {
		return _historyAppSimulation.compareTo(historyAppSimulation);
	}

	@Override
	public int hashCode() {
		return _historyAppSimulation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.project.model.HistoryAppSimulation> toCacheModel() {
		return _historyAppSimulation.toCacheModel();
	}

	@Override
	public org.kisti.edison.project.model.HistoryAppSimulation toEscapedModel() {
		return new HistoryAppSimulationWrapper(_historyAppSimulation.toEscapedModel());
	}

	@Override
	public org.kisti.edison.project.model.HistoryAppSimulation toUnescapedModel() {
		return new HistoryAppSimulationWrapper(_historyAppSimulation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _historyAppSimulation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _historyAppSimulation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_historyAppSimulation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistoryAppSimulationWrapper)) {
			return false;
		}

		HistoryAppSimulationWrapper historyAppSimulationWrapper = (HistoryAppSimulationWrapper)obj;

		if (Validator.equals(_historyAppSimulation,
					historyAppSimulationWrapper._historyAppSimulation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public HistoryAppSimulation getWrappedHistoryAppSimulation() {
		return _historyAppSimulation;
	}

	@Override
	public HistoryAppSimulation getWrappedModel() {
		return _historyAppSimulation;
	}

	@Override
	public void resetOriginalValues() {
		_historyAppSimulation.resetOriginalValues();
	}

	private HistoryAppSimulation _historyAppSimulation;
}