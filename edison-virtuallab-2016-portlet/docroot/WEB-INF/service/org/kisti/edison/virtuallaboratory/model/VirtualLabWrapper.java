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
 * This class is a wrapper for {@link VirtualLab}.
 * </p>
 *
 * @author EDISON
 * @see VirtualLab
 * @generated
 */
public class VirtualLabWrapper implements VirtualLab, ModelWrapper<VirtualLab> {
	public VirtualLabWrapper(VirtualLab virtualLab) {
		_virtualLab = virtualLab;
	}

	@Override
	public Class<?> getModelClass() {
		return VirtualLab.class;
	}

	@Override
	public String getModelClassName() {
		return VirtualLab.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("virtualLabId", getVirtualLabId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("virtualLabPersonName", getVirtualLabPersonName());
		attributes.put("virtualLabRequestDt", getVirtualLabRequestDt());
		attributes.put("virtualLabConfirmDt", getVirtualLabConfirmDt());
		attributes.put("virtualLabConfirmDescription",
			getVirtualLabConfirmDescription());
		attributes.put("virtualLabStatus", getVirtualLabStatus());
		attributes.put("virtualLabTitle", getVirtualLabTitle());
		attributes.put("virtualLabDescription", getVirtualLabDescription());
		attributes.put("virtualLabUseYn", getVirtualLabUseYn());
		attributes.put("virtualLabUniversityField",
			getVirtualLabUniversityField());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long virtualLabId = (Long)attributes.get("virtualLabId");

		if (virtualLabId != null) {
			setVirtualLabId(virtualLabId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String virtualLabPersonName = (String)attributes.get(
				"virtualLabPersonName");

		if (virtualLabPersonName != null) {
			setVirtualLabPersonName(virtualLabPersonName);
		}

		Date virtualLabRequestDt = (Date)attributes.get("virtualLabRequestDt");

		if (virtualLabRequestDt != null) {
			setVirtualLabRequestDt(virtualLabRequestDt);
		}

		Date virtualLabConfirmDt = (Date)attributes.get("virtualLabConfirmDt");

		if (virtualLabConfirmDt != null) {
			setVirtualLabConfirmDt(virtualLabConfirmDt);
		}

		String virtualLabConfirmDescription = (String)attributes.get(
				"virtualLabConfirmDescription");

		if (virtualLabConfirmDescription != null) {
			setVirtualLabConfirmDescription(virtualLabConfirmDescription);
		}

		String virtualLabStatus = (String)attributes.get("virtualLabStatus");

		if (virtualLabStatus != null) {
			setVirtualLabStatus(virtualLabStatus);
		}

		String virtualLabTitle = (String)attributes.get("virtualLabTitle");

		if (virtualLabTitle != null) {
			setVirtualLabTitle(virtualLabTitle);
		}

		String virtualLabDescription = (String)attributes.get(
				"virtualLabDescription");

		if (virtualLabDescription != null) {
			setVirtualLabDescription(virtualLabDescription);
		}

		String virtualLabUseYn = (String)attributes.get("virtualLabUseYn");

		if (virtualLabUseYn != null) {
			setVirtualLabUseYn(virtualLabUseYn);
		}

		String virtualLabUniversityField = (String)attributes.get(
				"virtualLabUniversityField");

		if (virtualLabUniversityField != null) {
			setVirtualLabUniversityField(virtualLabUniversityField);
		}
	}

	/**
	* Returns the primary key of this virtual lab.
	*
	* @return the primary key of this virtual lab
	*/
	@Override
	public long getPrimaryKey() {
		return _virtualLab.getPrimaryKey();
	}

	/**
	* Sets the primary key of this virtual lab.
	*
	* @param primaryKey the primary key of this virtual lab
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_virtualLab.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the virtual lab ID of this virtual lab.
	*
	* @return the virtual lab ID of this virtual lab
	*/
	@Override
	public long getVirtualLabId() {
		return _virtualLab.getVirtualLabId();
	}

	/**
	* Sets the virtual lab ID of this virtual lab.
	*
	* @param virtualLabId the virtual lab ID of this virtual lab
	*/
	@Override
	public void setVirtualLabId(long virtualLabId) {
		_virtualLab.setVirtualLabId(virtualLabId);
	}

	/**
	* Returns the group ID of this virtual lab.
	*
	* @return the group ID of this virtual lab
	*/
	@Override
	public long getGroupId() {
		return _virtualLab.getGroupId();
	}

	/**
	* Sets the group ID of this virtual lab.
	*
	* @param groupId the group ID of this virtual lab
	*/
	@Override
	public void setGroupId(long groupId) {
		_virtualLab.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this virtual lab.
	*
	* @return the user ID of this virtual lab
	*/
	@Override
	public long getUserId() {
		return _virtualLab.getUserId();
	}

	/**
	* Sets the user ID of this virtual lab.
	*
	* @param userId the user ID of this virtual lab
	*/
	@Override
	public void setUserId(long userId) {
		_virtualLab.setUserId(userId);
	}

	/**
	* Returns the user uuid of this virtual lab.
	*
	* @return the user uuid of this virtual lab
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLab.getUserUuid();
	}

	/**
	* Sets the user uuid of this virtual lab.
	*
	* @param userUuid the user uuid of this virtual lab
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_virtualLab.setUserUuid(userUuid);
	}

	/**
	* Returns the virtual lab person name of this virtual lab.
	*
	* @return the virtual lab person name of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabPersonName() {
		return _virtualLab.getVirtualLabPersonName();
	}

	/**
	* Returns the localized virtual lab person name of this virtual lab in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized virtual lab person name of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabPersonName(java.util.Locale locale) {
		return _virtualLab.getVirtualLabPersonName(locale);
	}

	/**
	* Returns the localized virtual lab person name of this virtual lab in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized virtual lab person name of this virtual lab. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getVirtualLabPersonName(java.util.Locale locale,
		boolean useDefault) {
		return _virtualLab.getVirtualLabPersonName(locale, useDefault);
	}

	/**
	* Returns the localized virtual lab person name of this virtual lab in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized virtual lab person name of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabPersonName(java.lang.String languageId) {
		return _virtualLab.getVirtualLabPersonName(languageId);
	}

	/**
	* Returns the localized virtual lab person name of this virtual lab in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized virtual lab person name of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabPersonName(
		java.lang.String languageId, boolean useDefault) {
		return _virtualLab.getVirtualLabPersonName(languageId, useDefault);
	}

	@Override
	public java.lang.String getVirtualLabPersonNameCurrentLanguageId() {
		return _virtualLab.getVirtualLabPersonNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getVirtualLabPersonNameCurrentValue() {
		return _virtualLab.getVirtualLabPersonNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized virtual lab person names of this virtual lab.
	*
	* @return the locales and localized virtual lab person names of this virtual lab
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getVirtualLabPersonNameMap() {
		return _virtualLab.getVirtualLabPersonNameMap();
	}

	/**
	* Sets the virtual lab person name of this virtual lab.
	*
	* @param virtualLabPersonName the virtual lab person name of this virtual lab
	*/
	@Override
	public void setVirtualLabPersonName(java.lang.String virtualLabPersonName) {
		_virtualLab.setVirtualLabPersonName(virtualLabPersonName);
	}

	/**
	* Sets the localized virtual lab person name of this virtual lab in the language.
	*
	* @param virtualLabPersonName the localized virtual lab person name of this virtual lab
	* @param locale the locale of the language
	*/
	@Override
	public void setVirtualLabPersonName(java.lang.String virtualLabPersonName,
		java.util.Locale locale) {
		_virtualLab.setVirtualLabPersonName(virtualLabPersonName, locale);
	}

	/**
	* Sets the localized virtual lab person name of this virtual lab in the language, and sets the default locale.
	*
	* @param virtualLabPersonName the localized virtual lab person name of this virtual lab
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setVirtualLabPersonName(java.lang.String virtualLabPersonName,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_virtualLab.setVirtualLabPersonName(virtualLabPersonName, locale,
			defaultLocale);
	}

	@Override
	public void setVirtualLabPersonNameCurrentLanguageId(
		java.lang.String languageId) {
		_virtualLab.setVirtualLabPersonNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized virtual lab person names of this virtual lab from the map of locales and localized virtual lab person names.
	*
	* @param virtualLabPersonNameMap the locales and localized virtual lab person names of this virtual lab
	*/
	@Override
	public void setVirtualLabPersonNameMap(
		java.util.Map<java.util.Locale, java.lang.String> virtualLabPersonNameMap) {
		_virtualLab.setVirtualLabPersonNameMap(virtualLabPersonNameMap);
	}

	/**
	* Sets the localized virtual lab person names of this virtual lab from the map of locales and localized virtual lab person names, and sets the default locale.
	*
	* @param virtualLabPersonNameMap the locales and localized virtual lab person names of this virtual lab
	* @param defaultLocale the default locale
	*/
	@Override
	public void setVirtualLabPersonNameMap(
		java.util.Map<java.util.Locale, java.lang.String> virtualLabPersonNameMap,
		java.util.Locale defaultLocale) {
		_virtualLab.setVirtualLabPersonNameMap(virtualLabPersonNameMap,
			defaultLocale);
	}

	/**
	* Returns the virtual lab request dt of this virtual lab.
	*
	* @return the virtual lab request dt of this virtual lab
	*/
	@Override
	public java.util.Date getVirtualLabRequestDt() {
		return _virtualLab.getVirtualLabRequestDt();
	}

	/**
	* Sets the virtual lab request dt of this virtual lab.
	*
	* @param virtualLabRequestDt the virtual lab request dt of this virtual lab
	*/
	@Override
	public void setVirtualLabRequestDt(java.util.Date virtualLabRequestDt) {
		_virtualLab.setVirtualLabRequestDt(virtualLabRequestDt);
	}

	/**
	* Returns the virtual lab confirm dt of this virtual lab.
	*
	* @return the virtual lab confirm dt of this virtual lab
	*/
	@Override
	public java.util.Date getVirtualLabConfirmDt() {
		return _virtualLab.getVirtualLabConfirmDt();
	}

	/**
	* Sets the virtual lab confirm dt of this virtual lab.
	*
	* @param virtualLabConfirmDt the virtual lab confirm dt of this virtual lab
	*/
	@Override
	public void setVirtualLabConfirmDt(java.util.Date virtualLabConfirmDt) {
		_virtualLab.setVirtualLabConfirmDt(virtualLabConfirmDt);
	}

	/**
	* Returns the virtual lab confirm description of this virtual lab.
	*
	* @return the virtual lab confirm description of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabConfirmDescription() {
		return _virtualLab.getVirtualLabConfirmDescription();
	}

	/**
	* Sets the virtual lab confirm description of this virtual lab.
	*
	* @param virtualLabConfirmDescription the virtual lab confirm description of this virtual lab
	*/
	@Override
	public void setVirtualLabConfirmDescription(
		java.lang.String virtualLabConfirmDescription) {
		_virtualLab.setVirtualLabConfirmDescription(virtualLabConfirmDescription);
	}

	/**
	* Returns the virtual lab status of this virtual lab.
	*
	* @return the virtual lab status of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabStatus() {
		return _virtualLab.getVirtualLabStatus();
	}

	/**
	* Sets the virtual lab status of this virtual lab.
	*
	* @param virtualLabStatus the virtual lab status of this virtual lab
	*/
	@Override
	public void setVirtualLabStatus(java.lang.String virtualLabStatus) {
		_virtualLab.setVirtualLabStatus(virtualLabStatus);
	}

	/**
	* Returns the virtual lab title of this virtual lab.
	*
	* @return the virtual lab title of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabTitle() {
		return _virtualLab.getVirtualLabTitle();
	}

	/**
	* Returns the localized virtual lab title of this virtual lab in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized virtual lab title of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabTitle(java.util.Locale locale) {
		return _virtualLab.getVirtualLabTitle(locale);
	}

	/**
	* Returns the localized virtual lab title of this virtual lab in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized virtual lab title of this virtual lab. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getVirtualLabTitle(java.util.Locale locale,
		boolean useDefault) {
		return _virtualLab.getVirtualLabTitle(locale, useDefault);
	}

	/**
	* Returns the localized virtual lab title of this virtual lab in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized virtual lab title of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabTitle(java.lang.String languageId) {
		return _virtualLab.getVirtualLabTitle(languageId);
	}

	/**
	* Returns the localized virtual lab title of this virtual lab in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized virtual lab title of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabTitle(java.lang.String languageId,
		boolean useDefault) {
		return _virtualLab.getVirtualLabTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getVirtualLabTitleCurrentLanguageId() {
		return _virtualLab.getVirtualLabTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getVirtualLabTitleCurrentValue() {
		return _virtualLab.getVirtualLabTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized virtual lab titles of this virtual lab.
	*
	* @return the locales and localized virtual lab titles of this virtual lab
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getVirtualLabTitleMap() {
		return _virtualLab.getVirtualLabTitleMap();
	}

	/**
	* Sets the virtual lab title of this virtual lab.
	*
	* @param virtualLabTitle the virtual lab title of this virtual lab
	*/
	@Override
	public void setVirtualLabTitle(java.lang.String virtualLabTitle) {
		_virtualLab.setVirtualLabTitle(virtualLabTitle);
	}

	/**
	* Sets the localized virtual lab title of this virtual lab in the language.
	*
	* @param virtualLabTitle the localized virtual lab title of this virtual lab
	* @param locale the locale of the language
	*/
	@Override
	public void setVirtualLabTitle(java.lang.String virtualLabTitle,
		java.util.Locale locale) {
		_virtualLab.setVirtualLabTitle(virtualLabTitle, locale);
	}

	/**
	* Sets the localized virtual lab title of this virtual lab in the language, and sets the default locale.
	*
	* @param virtualLabTitle the localized virtual lab title of this virtual lab
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setVirtualLabTitle(java.lang.String virtualLabTitle,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_virtualLab.setVirtualLabTitle(virtualLabTitle, locale, defaultLocale);
	}

	@Override
	public void setVirtualLabTitleCurrentLanguageId(java.lang.String languageId) {
		_virtualLab.setVirtualLabTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized virtual lab titles of this virtual lab from the map of locales and localized virtual lab titles.
	*
	* @param virtualLabTitleMap the locales and localized virtual lab titles of this virtual lab
	*/
	@Override
	public void setVirtualLabTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> virtualLabTitleMap) {
		_virtualLab.setVirtualLabTitleMap(virtualLabTitleMap);
	}

	/**
	* Sets the localized virtual lab titles of this virtual lab from the map of locales and localized virtual lab titles, and sets the default locale.
	*
	* @param virtualLabTitleMap the locales and localized virtual lab titles of this virtual lab
	* @param defaultLocale the default locale
	*/
	@Override
	public void setVirtualLabTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> virtualLabTitleMap,
		java.util.Locale defaultLocale) {
		_virtualLab.setVirtualLabTitleMap(virtualLabTitleMap, defaultLocale);
	}

	/**
	* Returns the virtual lab description of this virtual lab.
	*
	* @return the virtual lab description of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabDescription() {
		return _virtualLab.getVirtualLabDescription();
	}

	/**
	* Returns the localized virtual lab description of this virtual lab in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized virtual lab description of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabDescription(java.util.Locale locale) {
		return _virtualLab.getVirtualLabDescription(locale);
	}

	/**
	* Returns the localized virtual lab description of this virtual lab in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized virtual lab description of this virtual lab. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getVirtualLabDescription(java.util.Locale locale,
		boolean useDefault) {
		return _virtualLab.getVirtualLabDescription(locale, useDefault);
	}

	/**
	* Returns the localized virtual lab description of this virtual lab in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized virtual lab description of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabDescription(
		java.lang.String languageId) {
		return _virtualLab.getVirtualLabDescription(languageId);
	}

	/**
	* Returns the localized virtual lab description of this virtual lab in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized virtual lab description of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabDescription(
		java.lang.String languageId, boolean useDefault) {
		return _virtualLab.getVirtualLabDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getVirtualLabDescriptionCurrentLanguageId() {
		return _virtualLab.getVirtualLabDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getVirtualLabDescriptionCurrentValue() {
		return _virtualLab.getVirtualLabDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized virtual lab descriptions of this virtual lab.
	*
	* @return the locales and localized virtual lab descriptions of this virtual lab
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getVirtualLabDescriptionMap() {
		return _virtualLab.getVirtualLabDescriptionMap();
	}

	/**
	* Sets the virtual lab description of this virtual lab.
	*
	* @param virtualLabDescription the virtual lab description of this virtual lab
	*/
	@Override
	public void setVirtualLabDescription(java.lang.String virtualLabDescription) {
		_virtualLab.setVirtualLabDescription(virtualLabDescription);
	}

	/**
	* Sets the localized virtual lab description of this virtual lab in the language.
	*
	* @param virtualLabDescription the localized virtual lab description of this virtual lab
	* @param locale the locale of the language
	*/
	@Override
	public void setVirtualLabDescription(
		java.lang.String virtualLabDescription, java.util.Locale locale) {
		_virtualLab.setVirtualLabDescription(virtualLabDescription, locale);
	}

	/**
	* Sets the localized virtual lab description of this virtual lab in the language, and sets the default locale.
	*
	* @param virtualLabDescription the localized virtual lab description of this virtual lab
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setVirtualLabDescription(
		java.lang.String virtualLabDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_virtualLab.setVirtualLabDescription(virtualLabDescription, locale,
			defaultLocale);
	}

	@Override
	public void setVirtualLabDescriptionCurrentLanguageId(
		java.lang.String languageId) {
		_virtualLab.setVirtualLabDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized virtual lab descriptions of this virtual lab from the map of locales and localized virtual lab descriptions.
	*
	* @param virtualLabDescriptionMap the locales and localized virtual lab descriptions of this virtual lab
	*/
	@Override
	public void setVirtualLabDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> virtualLabDescriptionMap) {
		_virtualLab.setVirtualLabDescriptionMap(virtualLabDescriptionMap);
	}

	/**
	* Sets the localized virtual lab descriptions of this virtual lab from the map of locales and localized virtual lab descriptions, and sets the default locale.
	*
	* @param virtualLabDescriptionMap the locales and localized virtual lab descriptions of this virtual lab
	* @param defaultLocale the default locale
	*/
	@Override
	public void setVirtualLabDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> virtualLabDescriptionMap,
		java.util.Locale defaultLocale) {
		_virtualLab.setVirtualLabDescriptionMap(virtualLabDescriptionMap,
			defaultLocale);
	}

	/**
	* Returns the virtual lab use yn of this virtual lab.
	*
	* @return the virtual lab use yn of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabUseYn() {
		return _virtualLab.getVirtualLabUseYn();
	}

	/**
	* Sets the virtual lab use yn of this virtual lab.
	*
	* @param virtualLabUseYn the virtual lab use yn of this virtual lab
	*/
	@Override
	public void setVirtualLabUseYn(java.lang.String virtualLabUseYn) {
		_virtualLab.setVirtualLabUseYn(virtualLabUseYn);
	}

	/**
	* Returns the virtual lab university field of this virtual lab.
	*
	* @return the virtual lab university field of this virtual lab
	*/
	@Override
	public java.lang.String getVirtualLabUniversityField() {
		return _virtualLab.getVirtualLabUniversityField();
	}

	/**
	* Sets the virtual lab university field of this virtual lab.
	*
	* @param virtualLabUniversityField the virtual lab university field of this virtual lab
	*/
	@Override
	public void setVirtualLabUniversityField(
		java.lang.String virtualLabUniversityField) {
		_virtualLab.setVirtualLabUniversityField(virtualLabUniversityField);
	}

	@Override
	public boolean isNew() {
		return _virtualLab.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_virtualLab.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _virtualLab.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_virtualLab.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _virtualLab.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _virtualLab.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_virtualLab.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _virtualLab.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_virtualLab.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_virtualLab.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_virtualLab.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _virtualLab.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _virtualLab.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_virtualLab.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_virtualLab.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new VirtualLabWrapper((VirtualLab)_virtualLab.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab) {
		return _virtualLab.compareTo(virtualLab);
	}

	@Override
	public int hashCode() {
		return _virtualLab.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.virtuallaboratory.model.VirtualLab> toCacheModel() {
		return _virtualLab.toCacheModel();
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLab toEscapedModel() {
		return new VirtualLabWrapper(_virtualLab.toEscapedModel());
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLab toUnescapedModel() {
		return new VirtualLabWrapper(_virtualLab.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _virtualLab.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _virtualLab.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLab.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VirtualLabWrapper)) {
			return false;
		}

		VirtualLabWrapper virtualLabWrapper = (VirtualLabWrapper)obj;

		if (Validator.equals(_virtualLab, virtualLabWrapper._virtualLab)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VirtualLab getWrappedVirtualLab() {
		return _virtualLab;
	}

	@Override
	public VirtualLab getWrappedModel() {
		return _virtualLab;
	}

	@Override
	public void resetOriginalValues() {
		_virtualLab.resetOriginalValues();
	}

	private VirtualLab _virtualLab;
}