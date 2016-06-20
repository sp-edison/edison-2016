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

package org.kisti.edison.multiboard.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BoardDiv}.
 * </p>
 *
 * @author mhkang
 * @see BoardDiv
 * @generated
 */
public class BoardDivWrapper implements BoardDiv, ModelWrapper<BoardDiv> {
	public BoardDivWrapper(BoardDiv boardDiv) {
		_boardDiv = boardDiv;
	}

	@Override
	public Class<?> getModelClass() {
		return BoardDiv.class;
	}

	@Override
	public String getModelClassName() {
		return BoardDiv.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("divCd", getDivCd());
		attributes.put("titleNm", getTitleNm());
		attributes.put("ContentNm", getContentNm());
		attributes.put("divNm", getDivNm());
		attributes.put("fileUpLoadUseYn", getFileUpLoadUseYn());
		attributes.put("popupYn", getPopupYn());
		attributes.put("replyYn", getReplyYn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long divCd = (Long)attributes.get("divCd");

		if (divCd != null) {
			setDivCd(divCd);
		}

		String titleNm = (String)attributes.get("titleNm");

		if (titleNm != null) {
			setTitleNm(titleNm);
		}

		String ContentNm = (String)attributes.get("ContentNm");

		if (ContentNm != null) {
			setContentNm(ContentNm);
		}

		String divNm = (String)attributes.get("divNm");

		if (divNm != null) {
			setDivNm(divNm);
		}

		Boolean fileUpLoadUseYn = (Boolean)attributes.get("fileUpLoadUseYn");

		if (fileUpLoadUseYn != null) {
			setFileUpLoadUseYn(fileUpLoadUseYn);
		}

		Boolean popupYn = (Boolean)attributes.get("popupYn");

		if (popupYn != null) {
			setPopupYn(popupYn);
		}

		Boolean replyYn = (Boolean)attributes.get("replyYn");

		if (replyYn != null) {
			setReplyYn(replyYn);
		}
	}

	/**
	* Returns the primary key of this board div.
	*
	* @return the primary key of this board div
	*/
	@Override
	public long getPrimaryKey() {
		return _boardDiv.getPrimaryKey();
	}

	/**
	* Sets the primary key of this board div.
	*
	* @param primaryKey the primary key of this board div
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_boardDiv.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the div cd of this board div.
	*
	* @return the div cd of this board div
	*/
	@Override
	public long getDivCd() {
		return _boardDiv.getDivCd();
	}

	/**
	* Sets the div cd of this board div.
	*
	* @param divCd the div cd of this board div
	*/
	@Override
	public void setDivCd(long divCd) {
		_boardDiv.setDivCd(divCd);
	}

	/**
	* Returns the title nm of this board div.
	*
	* @return the title nm of this board div
	*/
	@Override
	public java.lang.String getTitleNm() {
		return _boardDiv.getTitleNm();
	}

	/**
	* Returns the localized title nm of this board div in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title nm of this board div
	*/
	@Override
	public java.lang.String getTitleNm(java.util.Locale locale) {
		return _boardDiv.getTitleNm(locale);
	}

	/**
	* Returns the localized title nm of this board div in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title nm of this board div. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitleNm(java.util.Locale locale,
		boolean useDefault) {
		return _boardDiv.getTitleNm(locale, useDefault);
	}

	/**
	* Returns the localized title nm of this board div in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title nm of this board div
	*/
	@Override
	public java.lang.String getTitleNm(java.lang.String languageId) {
		return _boardDiv.getTitleNm(languageId);
	}

	/**
	* Returns the localized title nm of this board div in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title nm of this board div
	*/
	@Override
	public java.lang.String getTitleNm(java.lang.String languageId,
		boolean useDefault) {
		return _boardDiv.getTitleNm(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleNmCurrentLanguageId() {
		return _boardDiv.getTitleNmCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleNmCurrentValue() {
		return _boardDiv.getTitleNmCurrentValue();
	}

	/**
	* Returns a map of the locales and localized title nms of this board div.
	*
	* @return the locales and localized title nms of this board div
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTitleNmMap() {
		return _boardDiv.getTitleNmMap();
	}

	/**
	* Sets the title nm of this board div.
	*
	* @param titleNm the title nm of this board div
	*/
	@Override
	public void setTitleNm(java.lang.String titleNm) {
		_boardDiv.setTitleNm(titleNm);
	}

	/**
	* Sets the localized title nm of this board div in the language.
	*
	* @param titleNm the localized title nm of this board div
	* @param locale the locale of the language
	*/
	@Override
	public void setTitleNm(java.lang.String titleNm, java.util.Locale locale) {
		_boardDiv.setTitleNm(titleNm, locale);
	}

	/**
	* Sets the localized title nm of this board div in the language, and sets the default locale.
	*
	* @param titleNm the localized title nm of this board div
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleNm(java.lang.String titleNm, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_boardDiv.setTitleNm(titleNm, locale, defaultLocale);
	}

	@Override
	public void setTitleNmCurrentLanguageId(java.lang.String languageId) {
		_boardDiv.setTitleNmCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized title nms of this board div from the map of locales and localized title nms.
	*
	* @param titleNmMap the locales and localized title nms of this board div
	*/
	@Override
	public void setTitleNmMap(
		java.util.Map<java.util.Locale, java.lang.String> titleNmMap) {
		_boardDiv.setTitleNmMap(titleNmMap);
	}

	/**
	* Sets the localized title nms of this board div from the map of locales and localized title nms, and sets the default locale.
	*
	* @param titleNmMap the locales and localized title nms of this board div
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleNmMap(
		java.util.Map<java.util.Locale, java.lang.String> titleNmMap,
		java.util.Locale defaultLocale) {
		_boardDiv.setTitleNmMap(titleNmMap, defaultLocale);
	}

	/**
	* Returns the content nm of this board div.
	*
	* @return the content nm of this board div
	*/
	@Override
	public java.lang.String getContentNm() {
		return _boardDiv.getContentNm();
	}

	/**
	* Returns the localized content nm of this board div in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized content nm of this board div
	*/
	@Override
	public java.lang.String getContentNm(java.util.Locale locale) {
		return _boardDiv.getContentNm(locale);
	}

	/**
	* Returns the localized content nm of this board div in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized content nm of this board div. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getContentNm(java.util.Locale locale,
		boolean useDefault) {
		return _boardDiv.getContentNm(locale, useDefault);
	}

	/**
	* Returns the localized content nm of this board div in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized content nm of this board div
	*/
	@Override
	public java.lang.String getContentNm(java.lang.String languageId) {
		return _boardDiv.getContentNm(languageId);
	}

	/**
	* Returns the localized content nm of this board div in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized content nm of this board div
	*/
	@Override
	public java.lang.String getContentNm(java.lang.String languageId,
		boolean useDefault) {
		return _boardDiv.getContentNm(languageId, useDefault);
	}

	@Override
	public java.lang.String getContentNmCurrentLanguageId() {
		return _boardDiv.getContentNmCurrentLanguageId();
	}

	@Override
	public java.lang.String getContentNmCurrentValue() {
		return _boardDiv.getContentNmCurrentValue();
	}

	/**
	* Returns a map of the locales and localized content nms of this board div.
	*
	* @return the locales and localized content nms of this board div
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getContentNmMap() {
		return _boardDiv.getContentNmMap();
	}

	/**
	* Sets the content nm of this board div.
	*
	* @param ContentNm the content nm of this board div
	*/
	@Override
	public void setContentNm(java.lang.String ContentNm) {
		_boardDiv.setContentNm(ContentNm);
	}

	/**
	* Sets the localized content nm of this board div in the language.
	*
	* @param ContentNm the localized content nm of this board div
	* @param locale the locale of the language
	*/
	@Override
	public void setContentNm(java.lang.String ContentNm, java.util.Locale locale) {
		_boardDiv.setContentNm(ContentNm, locale);
	}

	/**
	* Sets the localized content nm of this board div in the language, and sets the default locale.
	*
	* @param ContentNm the localized content nm of this board div
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setContentNm(java.lang.String ContentNm,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_boardDiv.setContentNm(ContentNm, locale, defaultLocale);
	}

	@Override
	public void setContentNmCurrentLanguageId(java.lang.String languageId) {
		_boardDiv.setContentNmCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized content nms of this board div from the map of locales and localized content nms.
	*
	* @param ContentNmMap the locales and localized content nms of this board div
	*/
	@Override
	public void setContentNmMap(
		java.util.Map<java.util.Locale, java.lang.String> ContentNmMap) {
		_boardDiv.setContentNmMap(ContentNmMap);
	}

	/**
	* Sets the localized content nms of this board div from the map of locales and localized content nms, and sets the default locale.
	*
	* @param ContentNmMap the locales and localized content nms of this board div
	* @param defaultLocale the default locale
	*/
	@Override
	public void setContentNmMap(
		java.util.Map<java.util.Locale, java.lang.String> ContentNmMap,
		java.util.Locale defaultLocale) {
		_boardDiv.setContentNmMap(ContentNmMap, defaultLocale);
	}

	/**
	* Returns the div nm of this board div.
	*
	* @return the div nm of this board div
	*/
	@Override
	public java.lang.String getDivNm() {
		return _boardDiv.getDivNm();
	}

	/**
	* Sets the div nm of this board div.
	*
	* @param divNm the div nm of this board div
	*/
	@Override
	public void setDivNm(java.lang.String divNm) {
		_boardDiv.setDivNm(divNm);
	}

	/**
	* Returns the file up load use yn of this board div.
	*
	* @return the file up load use yn of this board div
	*/
	@Override
	public boolean getFileUpLoadUseYn() {
		return _boardDiv.getFileUpLoadUseYn();
	}

	/**
	* Returns <code>true</code> if this board div is file up load use yn.
	*
	* @return <code>true</code> if this board div is file up load use yn; <code>false</code> otherwise
	*/
	@Override
	public boolean isFileUpLoadUseYn() {
		return _boardDiv.isFileUpLoadUseYn();
	}

	/**
	* Sets whether this board div is file up load use yn.
	*
	* @param fileUpLoadUseYn the file up load use yn of this board div
	*/
	@Override
	public void setFileUpLoadUseYn(boolean fileUpLoadUseYn) {
		_boardDiv.setFileUpLoadUseYn(fileUpLoadUseYn);
	}

	/**
	* Returns the popup yn of this board div.
	*
	* @return the popup yn of this board div
	*/
	@Override
	public boolean getPopupYn() {
		return _boardDiv.getPopupYn();
	}

	/**
	* Returns <code>true</code> if this board div is popup yn.
	*
	* @return <code>true</code> if this board div is popup yn; <code>false</code> otherwise
	*/
	@Override
	public boolean isPopupYn() {
		return _boardDiv.isPopupYn();
	}

	/**
	* Sets whether this board div is popup yn.
	*
	* @param popupYn the popup yn of this board div
	*/
	@Override
	public void setPopupYn(boolean popupYn) {
		_boardDiv.setPopupYn(popupYn);
	}

	/**
	* Returns the reply yn of this board div.
	*
	* @return the reply yn of this board div
	*/
	@Override
	public boolean getReplyYn() {
		return _boardDiv.getReplyYn();
	}

	/**
	* Returns <code>true</code> if this board div is reply yn.
	*
	* @return <code>true</code> if this board div is reply yn; <code>false</code> otherwise
	*/
	@Override
	public boolean isReplyYn() {
		return _boardDiv.isReplyYn();
	}

	/**
	* Sets whether this board div is reply yn.
	*
	* @param replyYn the reply yn of this board div
	*/
	@Override
	public void setReplyYn(boolean replyYn) {
		_boardDiv.setReplyYn(replyYn);
	}

	@Override
	public boolean isNew() {
		return _boardDiv.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_boardDiv.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _boardDiv.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_boardDiv.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _boardDiv.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _boardDiv.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_boardDiv.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _boardDiv.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_boardDiv.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_boardDiv.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_boardDiv.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _boardDiv.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _boardDiv.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_boardDiv.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_boardDiv.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new BoardDivWrapper((BoardDiv)_boardDiv.clone());
	}

	@Override
	public int compareTo(org.kisti.edison.multiboard.model.BoardDiv boardDiv) {
		return _boardDiv.compareTo(boardDiv);
	}

	@Override
	public int hashCode() {
		return _boardDiv.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.multiboard.model.BoardDiv> toCacheModel() {
		return _boardDiv.toCacheModel();
	}

	@Override
	public org.kisti.edison.multiboard.model.BoardDiv toEscapedModel() {
		return new BoardDivWrapper(_boardDiv.toEscapedModel());
	}

	@Override
	public org.kisti.edison.multiboard.model.BoardDiv toUnescapedModel() {
		return new BoardDivWrapper(_boardDiv.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _boardDiv.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _boardDiv.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_boardDiv.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BoardDivWrapper)) {
			return false;
		}

		BoardDivWrapper boardDivWrapper = (BoardDivWrapper)obj;

		if (Validator.equals(_boardDiv, boardDivWrapper._boardDiv)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BoardDiv getWrappedBoardDiv() {
		return _boardDiv;
	}

	@Override
	public BoardDiv getWrappedModel() {
		return _boardDiv;
	}

	@Override
	public void resetOriginalValues() {
		_boardDiv.resetOriginalValues();
	}

	private BoardDiv _boardDiv;
}