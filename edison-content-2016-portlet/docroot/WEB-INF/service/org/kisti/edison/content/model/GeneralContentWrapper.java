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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GeneralContent}.
 * </p>
 *
 * @author EDISON
 * @see GeneralContent
 * @generated
 */
public class GeneralContentWrapper implements GeneralContent,
	ModelWrapper<GeneralContent> {
	public GeneralContentWrapper(GeneralContent generalContent) {
		_generalContent = generalContent;
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

	/**
	* Returns the primary key of this general content.
	*
	* @return the primary key of this general content
	*/
	@Override
	public org.kisti.edison.content.service.persistence.GeneralContentPK getPrimaryKey() {
		return _generalContent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this general content.
	*
	* @param primaryKey the primary key of this general content
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.content.service.persistence.GeneralContentPK primaryKey) {
		_generalContent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the content seq of this general content.
	*
	* @return the content seq of this general content
	*/
	@Override
	public long getContentSeq() {
		return _generalContent.getContentSeq();
	}

	/**
	* Sets the content seq of this general content.
	*
	* @param contentSeq the content seq of this general content
	*/
	@Override
	public void setContentSeq(long contentSeq) {
		_generalContent.setContentSeq(contentSeq);
	}

	/**
	* Returns the group ID of this general content.
	*
	* @return the group ID of this general content
	*/
	@Override
	public long getGroupId() {
		return _generalContent.getGroupId();
	}

	/**
	* Sets the group ID of this general content.
	*
	* @param groupId the group ID of this general content
	*/
	@Override
	public void setGroupId(long groupId) {
		_generalContent.setGroupId(groupId);
	}

	/**
	* Returns the content div of this general content.
	*
	* @return the content div of this general content
	*/
	@Override
	public long getContentDiv() {
		return _generalContent.getContentDiv();
	}

	/**
	* Sets the content div of this general content.
	*
	* @param contentDiv the content div of this general content
	*/
	@Override
	public void setContentDiv(long contentDiv) {
		_generalContent.setContentDiv(contentDiv);
	}

	/**
	* Returns the title of this general content.
	*
	* @return the title of this general content
	*/
	@Override
	public java.lang.String getTitle() {
		return _generalContent.getTitle();
	}

	/**
	* Returns the localized title of this general content in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this general content
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _generalContent.getTitle(locale);
	}

	/**
	* Returns the localized title of this general content in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this general content. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _generalContent.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this general content in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this general content
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _generalContent.getTitle(languageId);
	}

	/**
	* Returns the localized title of this general content in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this general content
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _generalContent.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _generalContent.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _generalContent.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this general content.
	*
	* @return the locales and localized titles of this general content
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _generalContent.getTitleMap();
	}

	/**
	* Sets the title of this general content.
	*
	* @param title the title of this general content
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_generalContent.setTitle(title);
	}

	/**
	* Sets the localized title of this general content in the language.
	*
	* @param title the localized title of this general content
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_generalContent.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this general content in the language, and sets the default locale.
	*
	* @param title the localized title of this general content
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_generalContent.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_generalContent.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this general content from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this general content
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_generalContent.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this general content from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this general content
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_generalContent.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Returns the download cnt of this general content.
	*
	* @return the download cnt of this general content
	*/
	@Override
	public long getDownloadCnt() {
		return _generalContent.getDownloadCnt();
	}

	/**
	* Sets the download cnt of this general content.
	*
	* @param downloadCnt the download cnt of this general content
	*/
	@Override
	public void setDownloadCnt(long downloadCnt) {
		_generalContent.setDownloadCnt(downloadCnt);
	}

	/**
	* Returns the service language of this general content.
	*
	* @return the service language of this general content
	*/
	@Override
	public java.lang.String getServiceLanguage() {
		return _generalContent.getServiceLanguage();
	}

	/**
	* Sets the service language of this general content.
	*
	* @param serviceLanguage the service language of this general content
	*/
	@Override
	public void setServiceLanguage(java.lang.String serviceLanguage) {
		_generalContent.setServiceLanguage(serviceLanguage);
	}

	/**
	* Returns the project yn of this general content.
	*
	* @return the project yn of this general content
	*/
	@Override
	public java.lang.String getProjectYn() {
		return _generalContent.getProjectYn();
	}

	/**
	* Sets the project yn of this general content.
	*
	* @param projectYn the project yn of this general content
	*/
	@Override
	public void setProjectYn(java.lang.String projectYn) {
		_generalContent.setProjectYn(projectYn);
	}

	/**
	* Returns the project ID of this general content.
	*
	* @return the project ID of this general content
	*/
	@Override
	public long getProjectId() {
		return _generalContent.getProjectId();
	}

	/**
	* Sets the project ID of this general content.
	*
	* @param projectId the project ID of this general content
	*/
	@Override
	public void setProjectId(long projectId) {
		_generalContent.setProjectId(projectId);
	}

	/**
	* Returns the insert ID of this general content.
	*
	* @return the insert ID of this general content
	*/
	@Override
	public long getInsertId() {
		return _generalContent.getInsertId();
	}

	/**
	* Sets the insert ID of this general content.
	*
	* @param insertId the insert ID of this general content
	*/
	@Override
	public void setInsertId(long insertId) {
		_generalContent.setInsertId(insertId);
	}

	/**
	* Returns the insert date of this general content.
	*
	* @return the insert date of this general content
	*/
	@Override
	public java.util.Date getInsertDate() {
		return _generalContent.getInsertDate();
	}

	/**
	* Sets the insert date of this general content.
	*
	* @param insertDate the insert date of this general content
	*/
	@Override
	public void setInsertDate(java.util.Date insertDate) {
		_generalContent.setInsertDate(insertDate);
	}

	/**
	* Returns the update ID of this general content.
	*
	* @return the update ID of this general content
	*/
	@Override
	public long getUpdateId() {
		return _generalContent.getUpdateId();
	}

	/**
	* Sets the update ID of this general content.
	*
	* @param updateId the update ID of this general content
	*/
	@Override
	public void setUpdateId(long updateId) {
		_generalContent.setUpdateId(updateId);
	}

	/**
	* Returns the update date of this general content.
	*
	* @return the update date of this general content
	*/
	@Override
	public java.util.Date getUpdateDate() {
		return _generalContent.getUpdateDate();
	}

	/**
	* Sets the update date of this general content.
	*
	* @param updateDate the update date of this general content
	*/
	@Override
	public void setUpdateDate(java.util.Date updateDate) {
		_generalContent.setUpdateDate(updateDate);
	}

	@Override
	public boolean isNew() {
		return _generalContent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_generalContent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _generalContent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_generalContent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _generalContent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _generalContent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_generalContent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _generalContent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_generalContent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_generalContent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_generalContent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _generalContent.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _generalContent.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_generalContent.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_generalContent.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new GeneralContentWrapper((GeneralContent)_generalContent.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.content.model.GeneralContent generalContent) {
		return _generalContent.compareTo(generalContent);
	}

	@Override
	public int hashCode() {
		return _generalContent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.content.model.GeneralContent> toCacheModel() {
		return _generalContent.toCacheModel();
	}

	@Override
	public org.kisti.edison.content.model.GeneralContent toEscapedModel() {
		return new GeneralContentWrapper(_generalContent.toEscapedModel());
	}

	@Override
	public org.kisti.edison.content.model.GeneralContent toUnescapedModel() {
		return new GeneralContentWrapper(_generalContent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _generalContent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _generalContent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_generalContent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeneralContentWrapper)) {
			return false;
		}

		GeneralContentWrapper generalContentWrapper = (GeneralContentWrapper)obj;

		if (Validator.equals(_generalContent,
					generalContentWrapper._generalContent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GeneralContent getWrappedGeneralContent() {
		return _generalContent;
	}

	@Override
	public GeneralContent getWrappedModel() {
		return _generalContent;
	}

	@Override
	public void resetOriginalValues() {
		_generalContent.resetOriginalValues();
	}

	private GeneralContent _generalContent;
}