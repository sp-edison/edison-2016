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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.kisti.edison.multiboard.service.BoardDivLocalServiceUtil;
import org.kisti.edison.multiboard.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author mhkang
 */
public class BoardDivClp extends BaseModelImpl<BoardDiv> implements BoardDiv {
	public BoardDivClp() {
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
	public long getPrimaryKey() {
		return _divCd;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDivCd(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _divCd;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getDivCd() {
		return _divCd;
	}

	@Override
	public void setDivCd(long divCd) {
		_divCd = divCd;

		if (_boardDivRemoteModel != null) {
			try {
				Class<?> clazz = _boardDivRemoteModel.getClass();

				Method method = clazz.getMethod("setDivCd", long.class);

				method.invoke(_boardDivRemoteModel, divCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitleNm() {
		return _titleNm;
	}

	@Override
	public String getTitleNm(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitleNm(languageId);
	}

	@Override
	public String getTitleNm(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitleNm(languageId, useDefault);
	}

	@Override
	public String getTitleNm(String languageId) {
		return LocalizationUtil.getLocalization(getTitleNm(), languageId);
	}

	@Override
	public String getTitleNm(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getTitleNm(), languageId,
			useDefault);
	}

	@Override
	public String getTitleNmCurrentLanguageId() {
		return _titleNmCurrentLanguageId;
	}

	@Override
	public String getTitleNmCurrentValue() {
		Locale locale = getLocale(_titleNmCurrentLanguageId);

		return getTitleNm(locale);
	}

	@Override
	public Map<Locale, String> getTitleNmMap() {
		return LocalizationUtil.getLocalizationMap(getTitleNm());
	}

	@Override
	public void setTitleNm(String titleNm) {
		_titleNm = titleNm;

		if (_boardDivRemoteModel != null) {
			try {
				Class<?> clazz = _boardDivRemoteModel.getClass();

				Method method = clazz.getMethod("setTitleNm", String.class);

				method.invoke(_boardDivRemoteModel, titleNm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setTitleNm(String titleNm, Locale locale) {
		setTitleNm(titleNm, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setTitleNm(String titleNm, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(titleNm)) {
			setTitleNm(LocalizationUtil.updateLocalization(getTitleNm(),
					"TitleNm", titleNm, languageId, defaultLanguageId));
		}
		else {
			setTitleNm(LocalizationUtil.removeLocalization(getTitleNm(),
					"TitleNm", languageId));
		}
	}

	@Override
	public void setTitleNmCurrentLanguageId(String languageId) {
		_titleNmCurrentLanguageId = languageId;
	}

	@Override
	public void setTitleNmMap(Map<Locale, String> titleNmMap) {
		setTitleNmMap(titleNmMap, LocaleUtil.getDefault());
	}

	@Override
	public void setTitleNmMap(Map<Locale, String> titleNmMap,
		Locale defaultLocale) {
		if (titleNmMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setTitleNm(LocalizationUtil.updateLocalization(titleNmMap,
					getTitleNm(), "TitleNm",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getContentNm() {
		return _ContentNm;
	}

	@Override
	public String getContentNm(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getContentNm(languageId);
	}

	@Override
	public String getContentNm(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getContentNm(languageId, useDefault);
	}

	@Override
	public String getContentNm(String languageId) {
		return LocalizationUtil.getLocalization(getContentNm(), languageId);
	}

	@Override
	public String getContentNm(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getContentNm(), languageId,
			useDefault);
	}

	@Override
	public String getContentNmCurrentLanguageId() {
		return _ContentNmCurrentLanguageId;
	}

	@Override
	public String getContentNmCurrentValue() {
		Locale locale = getLocale(_ContentNmCurrentLanguageId);

		return getContentNm(locale);
	}

	@Override
	public Map<Locale, String> getContentNmMap() {
		return LocalizationUtil.getLocalizationMap(getContentNm());
	}

	@Override
	public void setContentNm(String ContentNm) {
		_ContentNm = ContentNm;

		if (_boardDivRemoteModel != null) {
			try {
				Class<?> clazz = _boardDivRemoteModel.getClass();

				Method method = clazz.getMethod("setContentNm", String.class);

				method.invoke(_boardDivRemoteModel, ContentNm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setContentNm(String ContentNm, Locale locale) {
		setContentNm(ContentNm, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setContentNm(String ContentNm, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(ContentNm)) {
			setContentNm(LocalizationUtil.updateLocalization(getContentNm(),
					"ContentNm", ContentNm, languageId, defaultLanguageId));
		}
		else {
			setContentNm(LocalizationUtil.removeLocalization(getContentNm(),
					"ContentNm", languageId));
		}
	}

	@Override
	public void setContentNmCurrentLanguageId(String languageId) {
		_ContentNmCurrentLanguageId = languageId;
	}

	@Override
	public void setContentNmMap(Map<Locale, String> ContentNmMap) {
		setContentNmMap(ContentNmMap, LocaleUtil.getDefault());
	}

	@Override
	public void setContentNmMap(Map<Locale, String> ContentNmMap,
		Locale defaultLocale) {
		if (ContentNmMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setContentNm(LocalizationUtil.updateLocalization(ContentNmMap,
					getContentNm(), "ContentNm",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getDivNm() {
		return _divNm;
	}

	@Override
	public void setDivNm(String divNm) {
		_divNm = divNm;

		if (_boardDivRemoteModel != null) {
			try {
				Class<?> clazz = _boardDivRemoteModel.getClass();

				Method method = clazz.getMethod("setDivNm", String.class);

				method.invoke(_boardDivRemoteModel, divNm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getFileUpLoadUseYn() {
		return _fileUpLoadUseYn;
	}

	@Override
	public boolean isFileUpLoadUseYn() {
		return _fileUpLoadUseYn;
	}

	@Override
	public void setFileUpLoadUseYn(boolean fileUpLoadUseYn) {
		_fileUpLoadUseYn = fileUpLoadUseYn;

		if (_boardDivRemoteModel != null) {
			try {
				Class<?> clazz = _boardDivRemoteModel.getClass();

				Method method = clazz.getMethod("setFileUpLoadUseYn",
						boolean.class);

				method.invoke(_boardDivRemoteModel, fileUpLoadUseYn);
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

		if (_boardDivRemoteModel != null) {
			try {
				Class<?> clazz = _boardDivRemoteModel.getClass();

				Method method = clazz.getMethod("setPopupYn", boolean.class);

				method.invoke(_boardDivRemoteModel, popupYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getReplyYn() {
		return _replyYn;
	}

	@Override
	public boolean isReplyYn() {
		return _replyYn;
	}

	@Override
	public void setReplyYn(boolean replyYn) {
		_replyYn = replyYn;

		if (_boardDivRemoteModel != null) {
			try {
				Class<?> clazz = _boardDivRemoteModel.getClass();

				Method method = clazz.getMethod("setReplyYn", boolean.class);

				method.invoke(_boardDivRemoteModel, replyYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBoardDivRemoteModel() {
		return _boardDivRemoteModel;
	}

	public void setBoardDivRemoteModel(BaseModel<?> boardDivRemoteModel) {
		_boardDivRemoteModel = boardDivRemoteModel;
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

		Class<?> remoteModelClass = _boardDivRemoteModel.getClass();

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

		Object returnValue = method.invoke(_boardDivRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BoardDivLocalServiceUtil.addBoardDiv(this);
		}
		else {
			BoardDivLocalServiceUtil.updateBoardDiv(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> titleNmMap = getTitleNmMap();

		for (Map.Entry<Locale, String> entry : titleNmMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> ContentNmMap = getContentNmMap();

		for (Map.Entry<Locale, String> entry : ContentNmMap.entrySet()) {
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
		String xml = getTitleNm();

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

		String titleNm = getTitleNm(defaultLocale);

		if (Validator.isNull(titleNm)) {
			setTitleNm(getTitleNm(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setTitleNm(getTitleNm(defaultLocale), defaultLocale, defaultLocale);
		}

		String ContentNm = getContentNm(defaultLocale);

		if (Validator.isNull(ContentNm)) {
			setContentNm(getContentNm(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setContentNm(getContentNm(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public BoardDiv toEscapedModel() {
		return (BoardDiv)ProxyUtil.newProxyInstance(BoardDiv.class.getClassLoader(),
			new Class[] { BoardDiv.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BoardDivClp clone = new BoardDivClp();

		clone.setDivCd(getDivCd());
		clone.setTitleNm(getTitleNm());
		clone.setContentNm(getContentNm());
		clone.setDivNm(getDivNm());
		clone.setFileUpLoadUseYn(getFileUpLoadUseYn());
		clone.setPopupYn(getPopupYn());
		clone.setReplyYn(getReplyYn());

		return clone;
	}

	@Override
	public int compareTo(BoardDiv boardDiv) {
		int value = 0;

		if (getDivCd() < boardDiv.getDivCd()) {
			value = -1;
		}
		else if (getDivCd() > boardDiv.getDivCd()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof BoardDivClp)) {
			return false;
		}

		BoardDivClp boardDiv = (BoardDivClp)obj;

		long primaryKey = boardDiv.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{divCd=");
		sb.append(getDivCd());
		sb.append(", titleNm=");
		sb.append(getTitleNm());
		sb.append(", ContentNm=");
		sb.append(getContentNm());
		sb.append(", divNm=");
		sb.append(getDivNm());
		sb.append(", fileUpLoadUseYn=");
		sb.append(getFileUpLoadUseYn());
		sb.append(", popupYn=");
		sb.append(getPopupYn());
		sb.append(", replyYn=");
		sb.append(getReplyYn());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.multiboard.model.BoardDiv");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>divCd</column-name><column-value><![CDATA[");
		sb.append(getDivCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleNm</column-name><column-value><![CDATA[");
		sb.append(getTitleNm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ContentNm</column-name><column-value><![CDATA[");
		sb.append(getContentNm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>divNm</column-name><column-value><![CDATA[");
		sb.append(getDivNm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileUpLoadUseYn</column-name><column-value><![CDATA[");
		sb.append(getFileUpLoadUseYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>popupYn</column-name><column-value><![CDATA[");
		sb.append(getPopupYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>replyYn</column-name><column-value><![CDATA[");
		sb.append(getReplyYn());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _divCd;
	private String _titleNm;
	private String _titleNmCurrentLanguageId;
	private String _ContentNm;
	private String _ContentNmCurrentLanguageId;
	private String _divNm;
	private boolean _fileUpLoadUseYn;
	private boolean _popupYn;
	private boolean _replyYn;
	private BaseModel<?> _boardDivRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.multiboard.service.ClpSerializer.class;
}