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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Board}.
 * </p>
 *
 * @author mhkang
 * @see Board
 * @generated
 */
public class BoardWrapper implements Board, ModelWrapper<Board> {
	public BoardWrapper(Board board) {
		_board = board;
	}

	@Override
	public Class<?> getModelClass() {
		return Board.class;
	}

	@Override
	public String getModelClassName() {
		return Board.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("boardSeq", getBoardSeq());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("groupId", getGroupId());
		attributes.put("customId", getCustomId());
		attributes.put("writerId", getWriterId());
		attributes.put("writerDate", getWriterDate());
		attributes.put("readCnt", getReadCnt());
		attributes.put("groupBoardSeq", getGroupBoardSeq());
		attributes.put("groupBoardTurn", getGroupBoardTurn());
		attributes.put("replyDepth", getReplyDepth());
		attributes.put("siteGroup", getSiteGroup());
		attributes.put("popupYn", getPopupYn());
		attributes.put("popupStartDt", getPopupStartDt());
		attributes.put("popupEndDt", getPopupEndDt());
		attributes.put("insertId", getInsertId());
		attributes.put("insertDt", getInsertDt());
		attributes.put("updateId", getUpdateId());
		attributes.put("updateDt", getUpdateDt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long boardSeq = (Long)attributes.get("boardSeq");

		if (boardSeq != null) {
			setBoardSeq(boardSeq);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String customId = (String)attributes.get("customId");

		if (customId != null) {
			setCustomId(customId);
		}

		Long writerId = (Long)attributes.get("writerId");

		if (writerId != null) {
			setWriterId(writerId);
		}

		Date writerDate = (Date)attributes.get("writerDate");

		if (writerDate != null) {
			setWriterDate(writerDate);
		}

		Integer readCnt = (Integer)attributes.get("readCnt");

		if (readCnt != null) {
			setReadCnt(readCnt);
		}

		Integer groupBoardSeq = (Integer)attributes.get("groupBoardSeq");

		if (groupBoardSeq != null) {
			setGroupBoardSeq(groupBoardSeq);
		}

		Integer groupBoardTurn = (Integer)attributes.get("groupBoardTurn");

		if (groupBoardTurn != null) {
			setGroupBoardTurn(groupBoardTurn);
		}

		Integer replyDepth = (Integer)attributes.get("replyDepth");

		if (replyDepth != null) {
			setReplyDepth(replyDepth);
		}

		String siteGroup = (String)attributes.get("siteGroup");

		if (siteGroup != null) {
			setSiteGroup(siteGroup);
		}

		Boolean popupYn = (Boolean)attributes.get("popupYn");

		if (popupYn != null) {
			setPopupYn(popupYn);
		}

		Date popupStartDt = (Date)attributes.get("popupStartDt");

		if (popupStartDt != null) {
			setPopupStartDt(popupStartDt);
		}

		Date popupEndDt = (Date)attributes.get("popupEndDt");

		if (popupEndDt != null) {
			setPopupEndDt(popupEndDt);
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
	* Returns the primary key of this board.
	*
	* @return the primary key of this board
	*/
	@Override
	public long getPrimaryKey() {
		return _board.getPrimaryKey();
	}

	/**
	* Sets the primary key of this board.
	*
	* @param primaryKey the primary key of this board
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_board.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the board seq of this board.
	*
	* @return the board seq of this board
	*/
	@Override
	public long getBoardSeq() {
		return _board.getBoardSeq();
	}

	/**
	* Sets the board seq of this board.
	*
	* @param boardSeq the board seq of this board
	*/
	@Override
	public void setBoardSeq(long boardSeq) {
		_board.setBoardSeq(boardSeq);
	}

	/**
	* Returns the title of this board.
	*
	* @return the title of this board
	*/
	@Override
	public java.lang.String getTitle() {
		return _board.getTitle();
	}

	/**
	* Returns the localized title of this board in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this board
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _board.getTitle(locale);
	}

	/**
	* Returns the localized title of this board in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this board. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _board.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this board in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this board
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _board.getTitle(languageId);
	}

	/**
	* Returns the localized title of this board in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this board
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _board.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _board.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _board.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this board.
	*
	* @return the locales and localized titles of this board
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _board.getTitleMap();
	}

	/**
	* Sets the title of this board.
	*
	* @param title the title of this board
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_board.setTitle(title);
	}

	/**
	* Sets the localized title of this board in the language.
	*
	* @param title the localized title of this board
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_board.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this board in the language, and sets the default locale.
	*
	* @param title the localized title of this board
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_board.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_board.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this board from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this board
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_board.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this board from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this board
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_board.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Returns the content of this board.
	*
	* @return the content of this board
	*/
	@Override
	public java.lang.String getContent() {
		return _board.getContent();
	}

	/**
	* Returns the localized content of this board in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized content of this board
	*/
	@Override
	public java.lang.String getContent(java.util.Locale locale) {
		return _board.getContent(locale);
	}

	/**
	* Returns the localized content of this board in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized content of this board. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getContent(java.util.Locale locale,
		boolean useDefault) {
		return _board.getContent(locale, useDefault);
	}

	/**
	* Returns the localized content of this board in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized content of this board
	*/
	@Override
	public java.lang.String getContent(java.lang.String languageId) {
		return _board.getContent(languageId);
	}

	/**
	* Returns the localized content of this board in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized content of this board
	*/
	@Override
	public java.lang.String getContent(java.lang.String languageId,
		boolean useDefault) {
		return _board.getContent(languageId, useDefault);
	}

	@Override
	public java.lang.String getContentCurrentLanguageId() {
		return _board.getContentCurrentLanguageId();
	}

	@Override
	public java.lang.String getContentCurrentValue() {
		return _board.getContentCurrentValue();
	}

	/**
	* Returns a map of the locales and localized contents of this board.
	*
	* @return the locales and localized contents of this board
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getContentMap() {
		return _board.getContentMap();
	}

	/**
	* Sets the content of this board.
	*
	* @param content the content of this board
	*/
	@Override
	public void setContent(java.lang.String content) {
		_board.setContent(content);
	}

	/**
	* Sets the localized content of this board in the language.
	*
	* @param content the localized content of this board
	* @param locale the locale of the language
	*/
	@Override
	public void setContent(java.lang.String content, java.util.Locale locale) {
		_board.setContent(content, locale);
	}

	/**
	* Sets the localized content of this board in the language, and sets the default locale.
	*
	* @param content the localized content of this board
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setContent(java.lang.String content, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_board.setContent(content, locale, defaultLocale);
	}

	@Override
	public void setContentCurrentLanguageId(java.lang.String languageId) {
		_board.setContentCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized contents of this board from the map of locales and localized contents.
	*
	* @param contentMap the locales and localized contents of this board
	*/
	@Override
	public void setContentMap(
		java.util.Map<java.util.Locale, java.lang.String> contentMap) {
		_board.setContentMap(contentMap);
	}

	/**
	* Sets the localized contents of this board from the map of locales and localized contents, and sets the default locale.
	*
	* @param contentMap the locales and localized contents of this board
	* @param defaultLocale the default locale
	*/
	@Override
	public void setContentMap(
		java.util.Map<java.util.Locale, java.lang.String> contentMap,
		java.util.Locale defaultLocale) {
		_board.setContentMap(contentMap, defaultLocale);
	}

	/**
	* Returns the group ID of this board.
	*
	* @return the group ID of this board
	*/
	@Override
	public long getGroupId() {
		return _board.getGroupId();
	}

	/**
	* Sets the group ID of this board.
	*
	* @param groupId the group ID of this board
	*/
	@Override
	public void setGroupId(long groupId) {
		_board.setGroupId(groupId);
	}

	/**
	* Returns the custom ID of this board.
	*
	* @return the custom ID of this board
	*/
	@Override
	public java.lang.String getCustomId() {
		return _board.getCustomId();
	}

	/**
	* Sets the custom ID of this board.
	*
	* @param customId the custom ID of this board
	*/
	@Override
	public void setCustomId(java.lang.String customId) {
		_board.setCustomId(customId);
	}

	/**
	* Returns the writer ID of this board.
	*
	* @return the writer ID of this board
	*/
	@Override
	public long getWriterId() {
		return _board.getWriterId();
	}

	/**
	* Sets the writer ID of this board.
	*
	* @param writerId the writer ID of this board
	*/
	@Override
	public void setWriterId(long writerId) {
		_board.setWriterId(writerId);
	}

	/**
	* Returns the writer date of this board.
	*
	* @return the writer date of this board
	*/
	@Override
	public java.util.Date getWriterDate() {
		return _board.getWriterDate();
	}

	/**
	* Sets the writer date of this board.
	*
	* @param writerDate the writer date of this board
	*/
	@Override
	public void setWriterDate(java.util.Date writerDate) {
		_board.setWriterDate(writerDate);
	}

	/**
	* Returns the read cnt of this board.
	*
	* @return the read cnt of this board
	*/
	@Override
	public int getReadCnt() {
		return _board.getReadCnt();
	}

	/**
	* Sets the read cnt of this board.
	*
	* @param readCnt the read cnt of this board
	*/
	@Override
	public void setReadCnt(int readCnt) {
		_board.setReadCnt(readCnt);
	}

	/**
	* Returns the group board seq of this board.
	*
	* @return the group board seq of this board
	*/
	@Override
	public int getGroupBoardSeq() {
		return _board.getGroupBoardSeq();
	}

	/**
	* Sets the group board seq of this board.
	*
	* @param groupBoardSeq the group board seq of this board
	*/
	@Override
	public void setGroupBoardSeq(int groupBoardSeq) {
		_board.setGroupBoardSeq(groupBoardSeq);
	}

	/**
	* Returns the group board turn of this board.
	*
	* @return the group board turn of this board
	*/
	@Override
	public int getGroupBoardTurn() {
		return _board.getGroupBoardTurn();
	}

	/**
	* Sets the group board turn of this board.
	*
	* @param groupBoardTurn the group board turn of this board
	*/
	@Override
	public void setGroupBoardTurn(int groupBoardTurn) {
		_board.setGroupBoardTurn(groupBoardTurn);
	}

	/**
	* Returns the reply depth of this board.
	*
	* @return the reply depth of this board
	*/
	@Override
	public int getReplyDepth() {
		return _board.getReplyDepth();
	}

	/**
	* Sets the reply depth of this board.
	*
	* @param replyDepth the reply depth of this board
	*/
	@Override
	public void setReplyDepth(int replyDepth) {
		_board.setReplyDepth(replyDepth);
	}

	/**
	* Returns the site group of this board.
	*
	* @return the site group of this board
	*/
	@Override
	public java.lang.String getSiteGroup() {
		return _board.getSiteGroup();
	}

	/**
	* Sets the site group of this board.
	*
	* @param siteGroup the site group of this board
	*/
	@Override
	public void setSiteGroup(java.lang.String siteGroup) {
		_board.setSiteGroup(siteGroup);
	}

	/**
	* Returns the popup yn of this board.
	*
	* @return the popup yn of this board
	*/
	@Override
	public boolean getPopupYn() {
		return _board.getPopupYn();
	}

	/**
	* Returns <code>true</code> if this board is popup yn.
	*
	* @return <code>true</code> if this board is popup yn; <code>false</code> otherwise
	*/
	@Override
	public boolean isPopupYn() {
		return _board.isPopupYn();
	}

	/**
	* Sets whether this board is popup yn.
	*
	* @param popupYn the popup yn of this board
	*/
	@Override
	public void setPopupYn(boolean popupYn) {
		_board.setPopupYn(popupYn);
	}

	/**
	* Returns the popup start dt of this board.
	*
	* @return the popup start dt of this board
	*/
	@Override
	public java.util.Date getPopupStartDt() {
		return _board.getPopupStartDt();
	}

	/**
	* Sets the popup start dt of this board.
	*
	* @param popupStartDt the popup start dt of this board
	*/
	@Override
	public void setPopupStartDt(java.util.Date popupStartDt) {
		_board.setPopupStartDt(popupStartDt);
	}

	/**
	* Returns the popup end dt of this board.
	*
	* @return the popup end dt of this board
	*/
	@Override
	public java.util.Date getPopupEndDt() {
		return _board.getPopupEndDt();
	}

	/**
	* Sets the popup end dt of this board.
	*
	* @param popupEndDt the popup end dt of this board
	*/
	@Override
	public void setPopupEndDt(java.util.Date popupEndDt) {
		_board.setPopupEndDt(popupEndDt);
	}

	/**
	* Returns the insert ID of this board.
	*
	* @return the insert ID of this board
	*/
	@Override
	public long getInsertId() {
		return _board.getInsertId();
	}

	/**
	* Sets the insert ID of this board.
	*
	* @param insertId the insert ID of this board
	*/
	@Override
	public void setInsertId(long insertId) {
		_board.setInsertId(insertId);
	}

	/**
	* Returns the insert dt of this board.
	*
	* @return the insert dt of this board
	*/
	@Override
	public java.util.Date getInsertDt() {
		return _board.getInsertDt();
	}

	/**
	* Sets the insert dt of this board.
	*
	* @param insertDt the insert dt of this board
	*/
	@Override
	public void setInsertDt(java.util.Date insertDt) {
		_board.setInsertDt(insertDt);
	}

	/**
	* Returns the update ID of this board.
	*
	* @return the update ID of this board
	*/
	@Override
	public long getUpdateId() {
		return _board.getUpdateId();
	}

	/**
	* Sets the update ID of this board.
	*
	* @param updateId the update ID of this board
	*/
	@Override
	public void setUpdateId(long updateId) {
		_board.setUpdateId(updateId);
	}

	/**
	* Returns the update dt of this board.
	*
	* @return the update dt of this board
	*/
	@Override
	public java.util.Date getUpdateDt() {
		return _board.getUpdateDt();
	}

	/**
	* Sets the update dt of this board.
	*
	* @param updateDt the update dt of this board
	*/
	@Override
	public void setUpdateDt(java.util.Date updateDt) {
		_board.setUpdateDt(updateDt);
	}

	@Override
	public boolean isNew() {
		return _board.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_board.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _board.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_board.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _board.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _board.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_board.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _board.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_board.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_board.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_board.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _board.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _board.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_board.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_board.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new BoardWrapper((Board)_board.clone());
	}

	@Override
	public int compareTo(org.kisti.edison.multiboard.model.Board board) {
		return _board.compareTo(board);
	}

	@Override
	public int hashCode() {
		return _board.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.multiboard.model.Board> toCacheModel() {
		return _board.toCacheModel();
	}

	@Override
	public org.kisti.edison.multiboard.model.Board toEscapedModel() {
		return new BoardWrapper(_board.toEscapedModel());
	}

	@Override
	public org.kisti.edison.multiboard.model.Board toUnescapedModel() {
		return new BoardWrapper(_board.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _board.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _board.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_board.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BoardWrapper)) {
			return false;
		}

		BoardWrapper boardWrapper = (BoardWrapper)obj;

		if (Validator.equals(_board, boardWrapper._board)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Board getWrappedBoard() {
		return _board;
	}

	@Override
	public Board getWrappedModel() {
		return _board;
	}

	@Override
	public void resetOriginalValues() {
		_board.resetOriginalValues();
	}

	private Board _board;
}