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
import com.liferay.portal.util.PortalUtil;

import org.kisti.edison.virtuallaboratory.service.ClpSerializer;
import org.kisti.edison.virtuallaboratory.service.VirtualLabLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author EDISON
 */
public class VirtualLabClp extends BaseModelImpl<VirtualLab>
	implements VirtualLab {
	public VirtualLabClp() {
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
	public long getPrimaryKey() {
		return _virtualLabId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVirtualLabId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _virtualLabId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getVirtualLabId() {
		return _virtualLabId;
	}

	@Override
	public void setVirtualLabId(long virtualLabId) {
		_virtualLabId = virtualLabId;

		if (_virtualLabRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualLabId", long.class);

				method.invoke(_virtualLabRemoteModel, virtualLabId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
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

		if (_virtualLabRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_virtualLabRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_virtualLabRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_virtualLabRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getVirtualLabPersonName() {
		return _virtualLabPersonName;
	}

	@Override
	public String getVirtualLabPersonName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getVirtualLabPersonName(languageId);
	}

	@Override
	public String getVirtualLabPersonName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getVirtualLabPersonName(languageId, useDefault);
	}

	@Override
	public String getVirtualLabPersonName(String languageId) {
		return LocalizationUtil.getLocalization(getVirtualLabPersonName(),
			languageId);
	}

	@Override
	public String getVirtualLabPersonName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getVirtualLabPersonName(),
			languageId, useDefault);
	}

	@Override
	public String getVirtualLabPersonNameCurrentLanguageId() {
		return _virtualLabPersonNameCurrentLanguageId;
	}

	@Override
	public String getVirtualLabPersonNameCurrentValue() {
		Locale locale = getLocale(_virtualLabPersonNameCurrentLanguageId);

		return getVirtualLabPersonName(locale);
	}

	@Override
	public Map<Locale, String> getVirtualLabPersonNameMap() {
		return LocalizationUtil.getLocalizationMap(getVirtualLabPersonName());
	}

	@Override
	public void setVirtualLabPersonName(String virtualLabPersonName) {
		_virtualLabPersonName = virtualLabPersonName;

		if (_virtualLabRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualLabPersonName",
						String.class);

				method.invoke(_virtualLabRemoteModel, virtualLabPersonName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setVirtualLabPersonName(String virtualLabPersonName,
		Locale locale) {
		setVirtualLabPersonName(virtualLabPersonName, locale,
			LocaleUtil.getDefault());
	}

	@Override
	public void setVirtualLabPersonName(String virtualLabPersonName,
		Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(virtualLabPersonName)) {
			setVirtualLabPersonName(LocalizationUtil.updateLocalization(
					getVirtualLabPersonName(), "VirtualLabPersonName",
					virtualLabPersonName, languageId, defaultLanguageId));
		}
		else {
			setVirtualLabPersonName(LocalizationUtil.removeLocalization(
					getVirtualLabPersonName(), "VirtualLabPersonName",
					languageId));
		}
	}

	@Override
	public void setVirtualLabPersonNameCurrentLanguageId(String languageId) {
		_virtualLabPersonNameCurrentLanguageId = languageId;
	}

	@Override
	public void setVirtualLabPersonNameMap(
		Map<Locale, String> virtualLabPersonNameMap) {
		setVirtualLabPersonNameMap(virtualLabPersonNameMap,
			LocaleUtil.getDefault());
	}

	@Override
	public void setVirtualLabPersonNameMap(
		Map<Locale, String> virtualLabPersonNameMap, Locale defaultLocale) {
		if (virtualLabPersonNameMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setVirtualLabPersonName(LocalizationUtil.updateLocalization(
					virtualLabPersonNameMap, getVirtualLabPersonName(),
					"VirtualLabPersonName",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public Date getVirtualLabRequestDt() {
		return _virtualLabRequestDt;
	}

	@Override
	public void setVirtualLabRequestDt(Date virtualLabRequestDt) {
		_virtualLabRequestDt = virtualLabRequestDt;

		if (_virtualLabRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualLabRequestDt",
						Date.class);

				method.invoke(_virtualLabRemoteModel, virtualLabRequestDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getVirtualLabConfirmDt() {
		return _virtualLabConfirmDt;
	}

	@Override
	public void setVirtualLabConfirmDt(Date virtualLabConfirmDt) {
		_virtualLabConfirmDt = virtualLabConfirmDt;

		if (_virtualLabRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualLabConfirmDt",
						Date.class);

				method.invoke(_virtualLabRemoteModel, virtualLabConfirmDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVirtualLabConfirmDescription() {
		return _virtualLabConfirmDescription;
	}

	@Override
	public void setVirtualLabConfirmDescription(
		String virtualLabConfirmDescription) {
		_virtualLabConfirmDescription = virtualLabConfirmDescription;

		if (_virtualLabRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualLabConfirmDescription",
						String.class);

				method.invoke(_virtualLabRemoteModel,
					virtualLabConfirmDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVirtualLabStatus() {
		return _virtualLabStatus;
	}

	@Override
	public void setVirtualLabStatus(String virtualLabStatus) {
		_virtualLabStatus = virtualLabStatus;

		if (_virtualLabRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualLabStatus",
						String.class);

				method.invoke(_virtualLabRemoteModel, virtualLabStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVirtualLabTitle() {
		return _virtualLabTitle;
	}

	@Override
	public String getVirtualLabTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getVirtualLabTitle(languageId);
	}

	@Override
	public String getVirtualLabTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getVirtualLabTitle(languageId, useDefault);
	}

	@Override
	public String getVirtualLabTitle(String languageId) {
		return LocalizationUtil.getLocalization(getVirtualLabTitle(), languageId);
	}

	@Override
	public String getVirtualLabTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getVirtualLabTitle(),
			languageId, useDefault);
	}

	@Override
	public String getVirtualLabTitleCurrentLanguageId() {
		return _virtualLabTitleCurrentLanguageId;
	}

	@Override
	public String getVirtualLabTitleCurrentValue() {
		Locale locale = getLocale(_virtualLabTitleCurrentLanguageId);

		return getVirtualLabTitle(locale);
	}

	@Override
	public Map<Locale, String> getVirtualLabTitleMap() {
		return LocalizationUtil.getLocalizationMap(getVirtualLabTitle());
	}

	@Override
	public void setVirtualLabTitle(String virtualLabTitle) {
		_virtualLabTitle = virtualLabTitle;

		if (_virtualLabRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualLabTitle",
						String.class);

				method.invoke(_virtualLabRemoteModel, virtualLabTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setVirtualLabTitle(String virtualLabTitle, Locale locale) {
		setVirtualLabTitle(virtualLabTitle, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setVirtualLabTitle(String virtualLabTitle, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(virtualLabTitle)) {
			setVirtualLabTitle(LocalizationUtil.updateLocalization(
					getVirtualLabTitle(), "VirtualLabTitle", virtualLabTitle,
					languageId, defaultLanguageId));
		}
		else {
			setVirtualLabTitle(LocalizationUtil.removeLocalization(
					getVirtualLabTitle(), "VirtualLabTitle", languageId));
		}
	}

	@Override
	public void setVirtualLabTitleCurrentLanguageId(String languageId) {
		_virtualLabTitleCurrentLanguageId = languageId;
	}

	@Override
	public void setVirtualLabTitleMap(Map<Locale, String> virtualLabTitleMap) {
		setVirtualLabTitleMap(virtualLabTitleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setVirtualLabTitleMap(Map<Locale, String> virtualLabTitleMap,
		Locale defaultLocale) {
		if (virtualLabTitleMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setVirtualLabTitle(LocalizationUtil.updateLocalization(
					virtualLabTitleMap, getVirtualLabTitle(),
					"VirtualLabTitle", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getVirtualLabDescription() {
		return _virtualLabDescription;
	}

	@Override
	public String getVirtualLabDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getVirtualLabDescription(languageId);
	}

	@Override
	public String getVirtualLabDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getVirtualLabDescription(languageId, useDefault);
	}

	@Override
	public String getVirtualLabDescription(String languageId) {
		return LocalizationUtil.getLocalization(getVirtualLabDescription(),
			languageId);
	}

	@Override
	public String getVirtualLabDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getVirtualLabDescription(),
			languageId, useDefault);
	}

	@Override
	public String getVirtualLabDescriptionCurrentLanguageId() {
		return _virtualLabDescriptionCurrentLanguageId;
	}

	@Override
	public String getVirtualLabDescriptionCurrentValue() {
		Locale locale = getLocale(_virtualLabDescriptionCurrentLanguageId);

		return getVirtualLabDescription(locale);
	}

	@Override
	public Map<Locale, String> getVirtualLabDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getVirtualLabDescription());
	}

	@Override
	public void setVirtualLabDescription(String virtualLabDescription) {
		_virtualLabDescription = virtualLabDescription;

		if (_virtualLabRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualLabDescription",
						String.class);

				method.invoke(_virtualLabRemoteModel, virtualLabDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setVirtualLabDescription(String virtualLabDescription,
		Locale locale) {
		setVirtualLabDescription(virtualLabDescription, locale,
			LocaleUtil.getDefault());
	}

	@Override
	public void setVirtualLabDescription(String virtualLabDescription,
		Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(virtualLabDescription)) {
			setVirtualLabDescription(LocalizationUtil.updateLocalization(
					getVirtualLabDescription(), "VirtualLabDescription",
					virtualLabDescription, languageId, defaultLanguageId));
		}
		else {
			setVirtualLabDescription(LocalizationUtil.removeLocalization(
					getVirtualLabDescription(), "VirtualLabDescription",
					languageId));
		}
	}

	@Override
	public void setVirtualLabDescriptionCurrentLanguageId(String languageId) {
		_virtualLabDescriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setVirtualLabDescriptionMap(
		Map<Locale, String> virtualLabDescriptionMap) {
		setVirtualLabDescriptionMap(virtualLabDescriptionMap,
			LocaleUtil.getDefault());
	}

	@Override
	public void setVirtualLabDescriptionMap(
		Map<Locale, String> virtualLabDescriptionMap, Locale defaultLocale) {
		if (virtualLabDescriptionMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setVirtualLabDescription(LocalizationUtil.updateLocalization(
					virtualLabDescriptionMap, getVirtualLabDescription(),
					"VirtualLabDescription",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getVirtualLabUseYn() {
		return _virtualLabUseYn;
	}

	@Override
	public void setVirtualLabUseYn(String virtualLabUseYn) {
		_virtualLabUseYn = virtualLabUseYn;

		if (_virtualLabRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualLabUseYn",
						String.class);

				method.invoke(_virtualLabRemoteModel, virtualLabUseYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVirtualLabUniversityField() {
		return _virtualLabUniversityField;
	}

	@Override
	public void setVirtualLabUniversityField(String virtualLabUniversityField) {
		_virtualLabUniversityField = virtualLabUniversityField;

		if (_virtualLabRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualLabUniversityField",
						String.class);

				method.invoke(_virtualLabRemoteModel, virtualLabUniversityField);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVirtualLabRemoteModel() {
		return _virtualLabRemoteModel;
	}

	public void setVirtualLabRemoteModel(BaseModel<?> virtualLabRemoteModel) {
		_virtualLabRemoteModel = virtualLabRemoteModel;
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

		Class<?> remoteModelClass = _virtualLabRemoteModel.getClass();

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

		Object returnValue = method.invoke(_virtualLabRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VirtualLabLocalServiceUtil.addVirtualLab(this);
		}
		else {
			VirtualLabLocalServiceUtil.updateVirtualLab(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> virtualLabPersonNameMap = getVirtualLabPersonNameMap();

		for (Map.Entry<Locale, String> entry : virtualLabPersonNameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> virtualLabTitleMap = getVirtualLabTitleMap();

		for (Map.Entry<Locale, String> entry : virtualLabTitleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> virtualLabDescriptionMap = getVirtualLabDescriptionMap();

		for (Map.Entry<Locale, String> entry : virtualLabDescriptionMap.entrySet()) {
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
		String xml = getVirtualLabPersonName();

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

		String virtualLabPersonName = getVirtualLabPersonName(defaultLocale);

		if (Validator.isNull(virtualLabPersonName)) {
			setVirtualLabPersonName(getVirtualLabPersonName(
					modelDefaultLanguageId), defaultLocale);
		}
		else {
			setVirtualLabPersonName(getVirtualLabPersonName(defaultLocale),
				defaultLocale, defaultLocale);
		}

		String virtualLabTitle = getVirtualLabTitle(defaultLocale);

		if (Validator.isNull(virtualLabTitle)) {
			setVirtualLabTitle(getVirtualLabTitle(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setVirtualLabTitle(getVirtualLabTitle(defaultLocale),
				defaultLocale, defaultLocale);
		}

		String virtualLabDescription = getVirtualLabDescription(defaultLocale);

		if (Validator.isNull(virtualLabDescription)) {
			setVirtualLabDescription(getVirtualLabDescription(
					modelDefaultLanguageId), defaultLocale);
		}
		else {
			setVirtualLabDescription(getVirtualLabDescription(defaultLocale),
				defaultLocale, defaultLocale);
		}
	}

	@Override
	public VirtualLab toEscapedModel() {
		return (VirtualLab)ProxyUtil.newProxyInstance(VirtualLab.class.getClassLoader(),
			new Class[] { VirtualLab.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VirtualLabClp clone = new VirtualLabClp();

		clone.setVirtualLabId(getVirtualLabId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setVirtualLabPersonName(getVirtualLabPersonName());
		clone.setVirtualLabRequestDt(getVirtualLabRequestDt());
		clone.setVirtualLabConfirmDt(getVirtualLabConfirmDt());
		clone.setVirtualLabConfirmDescription(getVirtualLabConfirmDescription());
		clone.setVirtualLabStatus(getVirtualLabStatus());
		clone.setVirtualLabTitle(getVirtualLabTitle());
		clone.setVirtualLabDescription(getVirtualLabDescription());
		clone.setVirtualLabUseYn(getVirtualLabUseYn());
		clone.setVirtualLabUniversityField(getVirtualLabUniversityField());

		return clone;
	}

	@Override
	public int compareTo(VirtualLab virtualLab) {
		int value = 0;

		value = DateUtil.compareTo(getVirtualLabConfirmDt(),
				virtualLab.getVirtualLabConfirmDt());

		value = value * -1;

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

		if (!(obj instanceof VirtualLabClp)) {
			return false;
		}

		VirtualLabClp virtualLab = (VirtualLabClp)obj;

		long primaryKey = virtualLab.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{virtualLabId=");
		sb.append(getVirtualLabId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", virtualLabPersonName=");
		sb.append(getVirtualLabPersonName());
		sb.append(", virtualLabRequestDt=");
		sb.append(getVirtualLabRequestDt());
		sb.append(", virtualLabConfirmDt=");
		sb.append(getVirtualLabConfirmDt());
		sb.append(", virtualLabConfirmDescription=");
		sb.append(getVirtualLabConfirmDescription());
		sb.append(", virtualLabStatus=");
		sb.append(getVirtualLabStatus());
		sb.append(", virtualLabTitle=");
		sb.append(getVirtualLabTitle());
		sb.append(", virtualLabDescription=");
		sb.append(getVirtualLabDescription());
		sb.append(", virtualLabUseYn=");
		sb.append(getVirtualLabUseYn());
		sb.append(", virtualLabUniversityField=");
		sb.append(getVirtualLabUniversityField());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.virtuallaboratory.model.VirtualLab");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>virtualLabId</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualLabPersonName</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabPersonName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualLabRequestDt</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabRequestDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualLabConfirmDt</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabConfirmDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualLabConfirmDescription</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabConfirmDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualLabStatus</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualLabTitle</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualLabDescription</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualLabUseYn</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabUseYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualLabUniversityField</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabUniversityField());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _virtualLabId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _virtualLabPersonName;
	private String _virtualLabPersonNameCurrentLanguageId;
	private Date _virtualLabRequestDt;
	private Date _virtualLabConfirmDt;
	private String _virtualLabConfirmDescription;
	private String _virtualLabStatus;
	private String _virtualLabTitle;
	private String _virtualLabTitleCurrentLanguageId;
	private String _virtualLabDescription;
	private String _virtualLabDescriptionCurrentLanguageId;
	private String _virtualLabUseYn;
	private String _virtualLabUniversityField;
	private BaseModel<?> _virtualLabRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.virtuallaboratory.service.ClpSerializer.class;
}