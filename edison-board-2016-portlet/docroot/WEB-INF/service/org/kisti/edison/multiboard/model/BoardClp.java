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

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.kisti.edison.multiboard.service.BoardLocalServiceUtil;
import org.kisti.edison.multiboard.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author mhkang
 */
public class BoardClp extends BaseModelImpl<Board> implements Board {
	public BoardClp() {
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
	public long getPrimaryKey() {
		return _boardSeq;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBoardSeq(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _boardSeq;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getBoardSeq() {
		return _boardSeq;
	}

	@Override
	public void setBoardSeq(long boardSeq) {
		_boardSeq = boardSeq;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setBoardSeq", long.class);

				method.invoke(_boardRemoteModel, boardSeq);
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

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_boardRemoteModel, title);
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
	public String getContent() {
		return _content;
	}

	@Override
	public String getContent(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getContent(languageId);
	}

	@Override
	public String getContent(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getContent(languageId, useDefault);
	}

	@Override
	public String getContent(String languageId) {
		return LocalizationUtil.getLocalization(getContent(), languageId);
	}

	@Override
	public String getContent(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getContent(), languageId,
			useDefault);
	}

	@Override
	public String getContentCurrentLanguageId() {
		return _contentCurrentLanguageId;
	}

	@Override
	public String getContentCurrentValue() {
		Locale locale = getLocale(_contentCurrentLanguageId);

		return getContent(locale);
	}

	@Override
	public Map<Locale, String> getContentMap() {
		return LocalizationUtil.getLocalizationMap(getContent());
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_boardRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setContent(String content, Locale locale) {
		setContent(content, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setContent(String content, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(content)) {
			setContent(LocalizationUtil.updateLocalization(getContent(),
					"Content", content, languageId, defaultLanguageId));
		}
		else {
			setContent(LocalizationUtil.removeLocalization(getContent(),
					"Content", languageId));
		}
	}

	@Override
	public void setContentCurrentLanguageId(String languageId) {
		_contentCurrentLanguageId = languageId;
	}

	@Override
	public void setContentMap(Map<Locale, String> contentMap) {
		setContentMap(contentMap, LocaleUtil.getDefault());
	}

	@Override
	public void setContentMap(Map<Locale, String> contentMap,
		Locale defaultLocale) {
		if (contentMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setContent(LocalizationUtil.updateLocalization(contentMap,
					getContent(), "Content",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
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

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_boardRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCustomId() {
		return _customId;
	}

	@Override
	public void setCustomId(String customId) {
		_customId = customId;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setCustomId", String.class);

				method.invoke(_boardRemoteModel, customId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWriterId() {
		return _writerId;
	}

	@Override
	public void setWriterId(long writerId) {
		_writerId = writerId;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setWriterId", long.class);

				method.invoke(_boardRemoteModel, writerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getWriterDate() {
		return _writerDate;
	}

	@Override
	public void setWriterDate(Date writerDate) {
		_writerDate = writerDate;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setWriterDate", Date.class);

				method.invoke(_boardRemoteModel, writerDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getReadCnt() {
		return _readCnt;
	}

	@Override
	public void setReadCnt(int readCnt) {
		_readCnt = readCnt;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setReadCnt", int.class);

				method.invoke(_boardRemoteModel, readCnt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGroupBoardSeq() {
		return _groupBoardSeq;
	}

	@Override
	public void setGroupBoardSeq(int groupBoardSeq) {
		_groupBoardSeq = groupBoardSeq;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupBoardSeq", int.class);

				method.invoke(_boardRemoteModel, groupBoardSeq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGroupBoardTurn() {
		return _groupBoardTurn;
	}

	@Override
	public void setGroupBoardTurn(int groupBoardTurn) {
		_groupBoardTurn = groupBoardTurn;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupBoardTurn", int.class);

				method.invoke(_boardRemoteModel, groupBoardTurn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getReplyDepth() {
		return _replyDepth;
	}

	@Override
	public void setReplyDepth(int replyDepth) {
		_replyDepth = replyDepth;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setReplyDepth", int.class);

				method.invoke(_boardRemoteModel, replyDepth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSiteGroup() {
		return _siteGroup;
	}

	@Override
	public void setSiteGroup(String siteGroup) {
		_siteGroup = siteGroup;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setSiteGroup", String.class);

				method.invoke(_boardRemoteModel, siteGroup);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPopupYn() {
		return _popupYn;
	}

	@Override
	public boolean isPopupYn() {
		return _popupYn;
	}

	@Override
	public void setPopupYn(boolean popupYn) {
		_popupYn = popupYn;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setPopupYn", boolean.class);

				method.invoke(_boardRemoteModel, popupYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPopupStartDt() {
		return _popupStartDt;
	}

	@Override
	public void setPopupStartDt(Date popupStartDt) {
		_popupStartDt = popupStartDt;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setPopupStartDt", Date.class);

				method.invoke(_boardRemoteModel, popupStartDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPopupEndDt() {
		return _popupEndDt;
	}

	@Override
	public void setPopupEndDt(Date popupEndDt) {
		_popupEndDt = popupEndDt;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setPopupEndDt", Date.class);

				method.invoke(_boardRemoteModel, popupEndDt);
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

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertId", long.class);

				method.invoke(_boardRemoteModel, insertId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getInsertDt() {
		return _insertDt;
	}

	@Override
	public void setInsertDt(Date insertDt) {
		_insertDt = insertDt;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertDt", Date.class);

				method.invoke(_boardRemoteModel, insertDt);
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

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateId", long.class);

				method.invoke(_boardRemoteModel, updateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdateDt() {
		return _updateDt;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		_updateDt = updateDt;

		if (_boardRemoteModel != null) {
			try {
				Class<?> clazz = _boardRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateDt", Date.class);

				method.invoke(_boardRemoteModel, updateDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBoardRemoteModel() {
		return _boardRemoteModel;
	}

	public void setBoardRemoteModel(BaseModel<?> boardRemoteModel) {
		_boardRemoteModel = boardRemoteModel;
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

		Class<?> remoteModelClass = _boardRemoteModel.getClass();

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

		Object returnValue = method.invoke(_boardRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BoardLocalServiceUtil.addBoard(this);
		}
		else {
			BoardLocalServiceUtil.updateBoard(this);
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

		Map<Locale, String> contentMap = getContentMap();

		for (Map.Entry<Locale, String> entry : contentMap.entrySet()) {
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

		String content = getContent(defaultLocale);

		if (Validator.isNull(content)) {
			setContent(getContent(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setContent(getContent(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public Board toEscapedModel() {
		return (Board)ProxyUtil.newProxyInstance(Board.class.getClassLoader(),
			new Class[] { Board.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BoardClp clone = new BoardClp();

		clone.setBoardSeq(getBoardSeq());
		clone.setTitle(getTitle());
		clone.setContent(getContent());
		clone.setGroupId(getGroupId());
		clone.setCustomId(getCustomId());
		clone.setWriterId(getWriterId());
		clone.setWriterDate(getWriterDate());
		clone.setReadCnt(getReadCnt());
		clone.setGroupBoardSeq(getGroupBoardSeq());
		clone.setGroupBoardTurn(getGroupBoardTurn());
		clone.setReplyDepth(getReplyDepth());
		clone.setSiteGroup(getSiteGroup());
		clone.setPopupYn(getPopupYn());
		clone.setPopupStartDt(getPopupStartDt());
		clone.setPopupEndDt(getPopupEndDt());
		clone.setInsertId(getInsertId());
		clone.setInsertDt(getInsertDt());
		clone.setUpdateId(getUpdateId());
		clone.setUpdateDt(getUpdateDt());

		return clone;
	}

	@Override
	public int compareTo(Board board) {
		int value = 0;

		value = DateUtil.compareTo(getWriterDate(), board.getWriterDate());

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

		if (!(obj instanceof BoardClp)) {
			return false;
		}

		BoardClp board = (BoardClp)obj;

		long primaryKey = board.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
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
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{boardSeq=");
		sb.append(getBoardSeq());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", customId=");
		sb.append(getCustomId());
		sb.append(", writerId=");
		sb.append(getWriterId());
		sb.append(", writerDate=");
		sb.append(getWriterDate());
		sb.append(", readCnt=");
		sb.append(getReadCnt());
		sb.append(", groupBoardSeq=");
		sb.append(getGroupBoardSeq());
		sb.append(", groupBoardTurn=");
		sb.append(getGroupBoardTurn());
		sb.append(", replyDepth=");
		sb.append(getReplyDepth());
		sb.append(", siteGroup=");
		sb.append(getSiteGroup());
		sb.append(", popupYn=");
		sb.append(getPopupYn());
		sb.append(", popupStartDt=");
		sb.append(getPopupStartDt());
		sb.append(", popupEndDt=");
		sb.append(getPopupEndDt());
		sb.append(", insertId=");
		sb.append(getInsertId());
		sb.append(", insertDt=");
		sb.append(getInsertDt());
		sb.append(", updateId=");
		sb.append(getUpdateId());
		sb.append(", updateDt=");
		sb.append(getUpdateDt());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.multiboard.model.Board");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>boardSeq</column-name><column-value><![CDATA[");
		sb.append(getBoardSeq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>customId</column-name><column-value><![CDATA[");
		sb.append(getCustomId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writerId</column-name><column-value><![CDATA[");
		sb.append(getWriterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writerDate</column-name><column-value><![CDATA[");
		sb.append(getWriterDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>readCnt</column-name><column-value><![CDATA[");
		sb.append(getReadCnt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupBoardSeq</column-name><column-value><![CDATA[");
		sb.append(getGroupBoardSeq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupBoardTurn</column-name><column-value><![CDATA[");
		sb.append(getGroupBoardTurn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>replyDepth</column-name><column-value><![CDATA[");
		sb.append(getReplyDepth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteGroup</column-name><column-value><![CDATA[");
		sb.append(getSiteGroup());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>popupYn</column-name><column-value><![CDATA[");
		sb.append(getPopupYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>popupStartDt</column-name><column-value><![CDATA[");
		sb.append(getPopupStartDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>popupEndDt</column-name><column-value><![CDATA[");
		sb.append(getPopupEndDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertId</column-name><column-value><![CDATA[");
		sb.append(getInsertId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertDt</column-name><column-value><![CDATA[");
		sb.append(getInsertDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateId</column-name><column-value><![CDATA[");
		sb.append(getUpdateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateDt</column-name><column-value><![CDATA[");
		sb.append(getUpdateDt());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _boardSeq;
	private String _title;
	private String _titleCurrentLanguageId;
	private String _content;
	private String _contentCurrentLanguageId;
	private long _groupId;
	private String _customId;
	private long _writerId;
	private Date _writerDate;
	private int _readCnt;
	private int _groupBoardSeq;
	private int _groupBoardTurn;
	private int _replyDepth;
	private String _siteGroup;
	private boolean _popupYn;
	private Date _popupStartDt;
	private Date _popupEndDt;
	private long _insertId;
	private Date _insertDt;
	private long _updateId;
	private Date _updateDt;
	private BaseModel<?> _boardRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.multiboard.service.ClpSerializer.class;
}