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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ScienceAppDescription}.
 * </p>
 *
 * @author EDISON
 * @see ScienceAppDescription
 * @generated
 */
public class ScienceAppDescriptionWrapper implements ScienceAppDescription,
	ModelWrapper<ScienceAppDescription> {
	public ScienceAppDescriptionWrapper(
		ScienceAppDescription scienceAppDescription) {
		_scienceAppDescription = scienceAppDescription;
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

	/**
	* Returns the primary key of this science app description.
	*
	* @return the primary key of this science app description
	*/
	@Override
	public long getPrimaryKey() {
		return _scienceAppDescription.getPrimaryKey();
	}

	/**
	* Sets the primary key of this science app description.
	*
	* @param primaryKey the primary key of this science app description
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_scienceAppDescription.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the description ID of this science app description.
	*
	* @return the description ID of this science app description
	*/
	@Override
	public long getDescriptionId() {
		return _scienceAppDescription.getDescriptionId();
	}

	/**
	* Sets the description ID of this science app description.
	*
	* @param descriptionId the description ID of this science app description
	*/
	@Override
	public void setDescriptionId(long descriptionId) {
		_scienceAppDescription.setDescriptionId(descriptionId);
	}

	/**
	* Returns the content of this science app description.
	*
	* @return the content of this science app description
	*/
	@Override
	public java.lang.String getContent() {
		return _scienceAppDescription.getContent();
	}

	/**
	* Returns the localized content of this science app description in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized content of this science app description
	*/
	@Override
	public java.lang.String getContent(java.util.Locale locale) {
		return _scienceAppDescription.getContent(locale);
	}

	/**
	* Returns the localized content of this science app description in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized content of this science app description. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getContent(java.util.Locale locale,
		boolean useDefault) {
		return _scienceAppDescription.getContent(locale, useDefault);
	}

	/**
	* Returns the localized content of this science app description in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized content of this science app description
	*/
	@Override
	public java.lang.String getContent(java.lang.String languageId) {
		return _scienceAppDescription.getContent(languageId);
	}

	/**
	* Returns the localized content of this science app description in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized content of this science app description
	*/
	@Override
	public java.lang.String getContent(java.lang.String languageId,
		boolean useDefault) {
		return _scienceAppDescription.getContent(languageId, useDefault);
	}

	@Override
	public java.lang.String getContentCurrentLanguageId() {
		return _scienceAppDescription.getContentCurrentLanguageId();
	}

	@Override
	public java.lang.String getContentCurrentValue() {
		return _scienceAppDescription.getContentCurrentValue();
	}

	/**
	* Returns a map of the locales and localized contents of this science app description.
	*
	* @return the locales and localized contents of this science app description
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getContentMap() {
		return _scienceAppDescription.getContentMap();
	}

	/**
	* Sets the content of this science app description.
	*
	* @param content the content of this science app description
	*/
	@Override
	public void setContent(java.lang.String content) {
		_scienceAppDescription.setContent(content);
	}

	/**
	* Sets the localized content of this science app description in the language.
	*
	* @param content the localized content of this science app description
	* @param locale the locale of the language
	*/
	@Override
	public void setContent(java.lang.String content, java.util.Locale locale) {
		_scienceAppDescription.setContent(content, locale);
	}

	/**
	* Sets the localized content of this science app description in the language, and sets the default locale.
	*
	* @param content the localized content of this science app description
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setContent(java.lang.String content, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_scienceAppDescription.setContent(content, locale, defaultLocale);
	}

	@Override
	public void setContentCurrentLanguageId(java.lang.String languageId) {
		_scienceAppDescription.setContentCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized contents of this science app description from the map of locales and localized contents.
	*
	* @param contentMap the locales and localized contents of this science app description
	*/
	@Override
	public void setContentMap(
		java.util.Map<java.util.Locale, java.lang.String> contentMap) {
		_scienceAppDescription.setContentMap(contentMap);
	}

	/**
	* Sets the localized contents of this science app description from the map of locales and localized contents, and sets the default locale.
	*
	* @param contentMap the locales and localized contents of this science app description
	* @param defaultLocale the default locale
	*/
	@Override
	public void setContentMap(
		java.util.Map<java.util.Locale, java.lang.String> contentMap,
		java.util.Locale defaultLocale) {
		_scienceAppDescription.setContentMap(contentMap, defaultLocale);
	}

	/**
	* Returns the insert ID of this science app description.
	*
	* @return the insert ID of this science app description
	*/
	@Override
	public long getInsertId() {
		return _scienceAppDescription.getInsertId();
	}

	/**
	* Sets the insert ID of this science app description.
	*
	* @param insertId the insert ID of this science app description
	*/
	@Override
	public void setInsertId(long insertId) {
		_scienceAppDescription.setInsertId(insertId);
	}

	/**
	* Returns the insert dt of this science app description.
	*
	* @return the insert dt of this science app description
	*/
	@Override
	public java.util.Date getInsertDt() {
		return _scienceAppDescription.getInsertDt();
	}

	/**
	* Sets the insert dt of this science app description.
	*
	* @param insertDt the insert dt of this science app description
	*/
	@Override
	public void setInsertDt(java.util.Date insertDt) {
		_scienceAppDescription.setInsertDt(insertDt);
	}

	/**
	* Returns the update ID of this science app description.
	*
	* @return the update ID of this science app description
	*/
	@Override
	public long getUpdateId() {
		return _scienceAppDescription.getUpdateId();
	}

	/**
	* Sets the update ID of this science app description.
	*
	* @param updateId the update ID of this science app description
	*/
	@Override
	public void setUpdateId(long updateId) {
		_scienceAppDescription.setUpdateId(updateId);
	}

	/**
	* Returns the update dt of this science app description.
	*
	* @return the update dt of this science app description
	*/
	@Override
	public java.util.Date getUpdateDt() {
		return _scienceAppDescription.getUpdateDt();
	}

	/**
	* Sets the update dt of this science app description.
	*
	* @param updateDt the update dt of this science app description
	*/
	@Override
	public void setUpdateDt(java.util.Date updateDt) {
		_scienceAppDescription.setUpdateDt(updateDt);
	}

	@Override
	public boolean isNew() {
		return _scienceAppDescription.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_scienceAppDescription.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _scienceAppDescription.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_scienceAppDescription.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _scienceAppDescription.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _scienceAppDescription.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_scienceAppDescription.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _scienceAppDescription.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_scienceAppDescription.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_scienceAppDescription.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_scienceAppDescription.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _scienceAppDescription.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _scienceAppDescription.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_scienceAppDescription.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_scienceAppDescription.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new ScienceAppDescriptionWrapper((ScienceAppDescription)_scienceAppDescription.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.science.model.ScienceAppDescription scienceAppDescription) {
		return _scienceAppDescription.compareTo(scienceAppDescription);
	}

	@Override
	public int hashCode() {
		return _scienceAppDescription.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.science.model.ScienceAppDescription> toCacheModel() {
		return _scienceAppDescription.toCacheModel();
	}

	@Override
	public org.kisti.edison.science.model.ScienceAppDescription toEscapedModel() {
		return new ScienceAppDescriptionWrapper(_scienceAppDescription.toEscapedModel());
	}

	@Override
	public org.kisti.edison.science.model.ScienceAppDescription toUnescapedModel() {
		return new ScienceAppDescriptionWrapper(_scienceAppDescription.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _scienceAppDescription.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _scienceAppDescription.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppDescription.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScienceAppDescriptionWrapper)) {
			return false;
		}

		ScienceAppDescriptionWrapper scienceAppDescriptionWrapper = (ScienceAppDescriptionWrapper)obj;

		if (Validator.equals(_scienceAppDescription,
					scienceAppDescriptionWrapper._scienceAppDescription)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ScienceAppDescription getWrappedScienceAppDescription() {
		return _scienceAppDescription;
	}

	@Override
	public ScienceAppDescription getWrappedModel() {
		return _scienceAppDescription;
	}

	@Override
	public void resetOriginalValues() {
		_scienceAppDescription.resetOriginalValues();
	}

	private ScienceAppDescription _scienceAppDescription;
}