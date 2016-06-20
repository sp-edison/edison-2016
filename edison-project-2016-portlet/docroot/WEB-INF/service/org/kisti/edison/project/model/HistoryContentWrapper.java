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
 * This class is a wrapper for {@link HistoryContent}.
 * </p>
 *
 * @author EDISON
 * @see HistoryContent
 * @generated
 */
public class HistoryContentWrapper implements HistoryContent,
	ModelWrapper<HistoryContent> {
	public HistoryContentWrapper(HistoryContent historyContent) {
		_historyContent = historyContent;
	}

	@Override
	public Class<?> getModelClass() {
		return HistoryContent.class;
	}

	@Override
	public String getModelClassName() {
		return HistoryContent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentSeq", getContentSeq());
		attributes.put("groupId", getGroupId());
		attributes.put("projectCategoryId", getProjectCategoryId());
		attributes.put("contentDiv", getContentDiv());
		attributes.put("title", getTitle());
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

		Long projectCategoryId = (Long)attributes.get("projectCategoryId");

		if (projectCategoryId != null) {
			setProjectCategoryId(projectCategoryId);
		}

		Long contentDiv = (Long)attributes.get("contentDiv");

		if (contentDiv != null) {
			setContentDiv(contentDiv);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
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
	* Returns the primary key of this history content.
	*
	* @return the primary key of this history content
	*/
	@Override
	public org.kisti.edison.project.service.persistence.HistoryContentPK getPrimaryKey() {
		return _historyContent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this history content.
	*
	* @param primaryKey the primary key of this history content
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.project.service.persistence.HistoryContentPK primaryKey) {
		_historyContent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the content seq of this history content.
	*
	* @return the content seq of this history content
	*/
	@Override
	public long getContentSeq() {
		return _historyContent.getContentSeq();
	}

	/**
	* Sets the content seq of this history content.
	*
	* @param contentSeq the content seq of this history content
	*/
	@Override
	public void setContentSeq(long contentSeq) {
		_historyContent.setContentSeq(contentSeq);
	}

	/**
	* Returns the group ID of this history content.
	*
	* @return the group ID of this history content
	*/
	@Override
	public long getGroupId() {
		return _historyContent.getGroupId();
	}

	/**
	* Sets the group ID of this history content.
	*
	* @param groupId the group ID of this history content
	*/
	@Override
	public void setGroupId(long groupId) {
		_historyContent.setGroupId(groupId);
	}

	/**
	* Returns the project category ID of this history content.
	*
	* @return the project category ID of this history content
	*/
	@Override
	public long getProjectCategoryId() {
		return _historyContent.getProjectCategoryId();
	}

	/**
	* Sets the project category ID of this history content.
	*
	* @param projectCategoryId the project category ID of this history content
	*/
	@Override
	public void setProjectCategoryId(long projectCategoryId) {
		_historyContent.setProjectCategoryId(projectCategoryId);
	}

	/**
	* Returns the content div of this history content.
	*
	* @return the content div of this history content
	*/
	@Override
	public long getContentDiv() {
		return _historyContent.getContentDiv();
	}

	/**
	* Sets the content div of this history content.
	*
	* @param contentDiv the content div of this history content
	*/
	@Override
	public void setContentDiv(long contentDiv) {
		_historyContent.setContentDiv(contentDiv);
	}

	/**
	* Returns the title of this history content.
	*
	* @return the title of this history content
	*/
	@Override
	public java.lang.String getTitle() {
		return _historyContent.getTitle();
	}

	/**
	* Returns the localized title of this history content in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this history content
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _historyContent.getTitle(locale);
	}

	/**
	* Returns the localized title of this history content in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this history content. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _historyContent.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this history content in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this history content
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _historyContent.getTitle(languageId);
	}

	/**
	* Returns the localized title of this history content in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this history content
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _historyContent.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _historyContent.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _historyContent.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this history content.
	*
	* @return the locales and localized titles of this history content
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _historyContent.getTitleMap();
	}

	/**
	* Sets the title of this history content.
	*
	* @param title the title of this history content
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_historyContent.setTitle(title);
	}

	/**
	* Sets the localized title of this history content in the language.
	*
	* @param title the localized title of this history content
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_historyContent.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this history content in the language, and sets the default locale.
	*
	* @param title the localized title of this history content
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_historyContent.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_historyContent.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this history content from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this history content
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_historyContent.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this history content from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this history content
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_historyContent.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Returns the insert ID of this history content.
	*
	* @return the insert ID of this history content
	*/
	@Override
	public long getInsertId() {
		return _historyContent.getInsertId();
	}

	/**
	* Sets the insert ID of this history content.
	*
	* @param insertId the insert ID of this history content
	*/
	@Override
	public void setInsertId(long insertId) {
		_historyContent.setInsertId(insertId);
	}

	/**
	* Returns the insert date of this history content.
	*
	* @return the insert date of this history content
	*/
	@Override
	public java.util.Date getInsertDate() {
		return _historyContent.getInsertDate();
	}

	/**
	* Sets the insert date of this history content.
	*
	* @param insertDate the insert date of this history content
	*/
	@Override
	public void setInsertDate(java.util.Date insertDate) {
		_historyContent.setInsertDate(insertDate);
	}

	/**
	* Returns the update ID of this history content.
	*
	* @return the update ID of this history content
	*/
	@Override
	public long getUpdateId() {
		return _historyContent.getUpdateId();
	}

	/**
	* Sets the update ID of this history content.
	*
	* @param updateId the update ID of this history content
	*/
	@Override
	public void setUpdateId(long updateId) {
		_historyContent.setUpdateId(updateId);
	}

	/**
	* Returns the update date of this history content.
	*
	* @return the update date of this history content
	*/
	@Override
	public java.util.Date getUpdateDate() {
		return _historyContent.getUpdateDate();
	}

	/**
	* Sets the update date of this history content.
	*
	* @param updateDate the update date of this history content
	*/
	@Override
	public void setUpdateDate(java.util.Date updateDate) {
		_historyContent.setUpdateDate(updateDate);
	}

	@Override
	public boolean isNew() {
		return _historyContent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_historyContent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _historyContent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_historyContent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _historyContent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _historyContent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_historyContent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _historyContent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_historyContent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_historyContent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_historyContent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _historyContent.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _historyContent.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_historyContent.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_historyContent.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new HistoryContentWrapper((HistoryContent)_historyContent.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.project.model.HistoryContent historyContent) {
		return _historyContent.compareTo(historyContent);
	}

	@Override
	public int hashCode() {
		return _historyContent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.project.model.HistoryContent> toCacheModel() {
		return _historyContent.toCacheModel();
	}

	@Override
	public org.kisti.edison.project.model.HistoryContent toEscapedModel() {
		return new HistoryContentWrapper(_historyContent.toEscapedModel());
	}

	@Override
	public org.kisti.edison.project.model.HistoryContent toUnescapedModel() {
		return new HistoryContentWrapper(_historyContent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _historyContent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _historyContent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_historyContent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistoryContentWrapper)) {
			return false;
		}

		HistoryContentWrapper historyContentWrapper = (HistoryContentWrapper)obj;

		if (Validator.equals(_historyContent,
					historyContentWrapper._historyContent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public HistoryContent getWrappedHistoryContent() {
		return _historyContent;
	}

	@Override
	public HistoryContent getWrappedModel() {
		return _historyContent;
	}

	@Override
	public void resetOriginalValues() {
		_historyContent.resetOriginalValues();
	}

	private HistoryContent _historyContent;
}