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

import org.kisti.edison.science.service.ClpSerializer;
import org.kisti.edison.science.service.DeveloperRequestLocalServiceUtil;
import org.kisti.edison.science.service.persistence.DeveloperRequestPK;

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
public class DeveloperRequestClp extends BaseModelImpl<DeveloperRequest>
	implements DeveloperRequest {
	public DeveloperRequestClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DeveloperRequest.class;
	}

	@Override
	public String getModelClassName() {
		return DeveloperRequest.class.getName();
	}

	@Override
	public DeveloperRequestPK getPrimaryKey() {
		return new DeveloperRequestPK(_requestSeq, _userId, _groupId);
	}

	@Override
	public void setPrimaryKey(DeveloperRequestPK primaryKey) {
		setRequestSeq(primaryKey.requestSeq);
		setUserId(primaryKey.userId);
		setGroupId(primaryKey.groupId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new DeveloperRequestPK(_requestSeq, _userId, _groupId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((DeveloperRequestPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("requestSeq", getRequestSeq());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("requestSort", getRequestSort());
		attributes.put("requestDate", getRequestDate());
		attributes.put("requestNote", getRequestNote());
		attributes.put("requestStatus", getRequestStatus());
		attributes.put("processDate", getProcessDate());
		attributes.put("processNote", getProcessNote());
		attributes.put("insertId", getInsertId());
		attributes.put("insertDate", getInsertDate());
		attributes.put("updateId", getUpdateId());
		attributes.put("updateDate", getUpdateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long requestSeq = (Long)attributes.get("requestSeq");

		if (requestSeq != null) {
			setRequestSeq(requestSeq);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String requestSort = (String)attributes.get("requestSort");

		if (requestSort != null) {
			setRequestSort(requestSort);
		}

		Date requestDate = (Date)attributes.get("requestDate");

		if (requestDate != null) {
			setRequestDate(requestDate);
		}

		String requestNote = (String)attributes.get("requestNote");

		if (requestNote != null) {
			setRequestNote(requestNote);
		}

		String requestStatus = (String)attributes.get("requestStatus");

		if (requestStatus != null) {
			setRequestStatus(requestStatus);
		}

		Date processDate = (Date)attributes.get("processDate");

		if (processDate != null) {
			setProcessDate(processDate);
		}

		String processNote = (String)attributes.get("processNote");

		if (processNote != null) {
			setProcessNote(processNote);
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

	@Override
	public long getRequestSeq() {
		return _requestSeq;
	}

	@Override
	public void setRequestSeq(long requestSeq) {
		_requestSeq = requestSeq;

		if (_developerRequestRemoteModel != null) {
			try {
				Class<?> clazz = _developerRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestSeq", long.class);

				method.invoke(_developerRequestRemoteModel, requestSeq);
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

		if (_developerRequestRemoteModel != null) {
			try {
				Class<?> clazz = _developerRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_developerRequestRemoteModel, userId);
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
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_developerRequestRemoteModel != null) {
			try {
				Class<?> clazz = _developerRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_developerRequestRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRequestSort() {
		return _requestSort;
	}

	@Override
	public void setRequestSort(String requestSort) {
		_requestSort = requestSort;

		if (_developerRequestRemoteModel != null) {
			try {
				Class<?> clazz = _developerRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestSort", String.class);

				method.invoke(_developerRequestRemoteModel, requestSort);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRequestDate() {
		return _requestDate;
	}

	@Override
	public void setRequestDate(Date requestDate) {
		_requestDate = requestDate;

		if (_developerRequestRemoteModel != null) {
			try {
				Class<?> clazz = _developerRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestDate", Date.class);

				method.invoke(_developerRequestRemoteModel, requestDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRequestNote() {
		return _requestNote;
	}

	@Override
	public String getRequestNote(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getRequestNote(languageId);
	}

	@Override
	public String getRequestNote(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getRequestNote(languageId, useDefault);
	}

	@Override
	public String getRequestNote(String languageId) {
		return LocalizationUtil.getLocalization(getRequestNote(), languageId);
	}

	@Override
	public String getRequestNote(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getRequestNote(), languageId,
			useDefault);
	}

	@Override
	public String getRequestNoteCurrentLanguageId() {
		return _requestNoteCurrentLanguageId;
	}

	@Override
	public String getRequestNoteCurrentValue() {
		Locale locale = getLocale(_requestNoteCurrentLanguageId);

		return getRequestNote(locale);
	}

	@Override
	public Map<Locale, String> getRequestNoteMap() {
		return LocalizationUtil.getLocalizationMap(getRequestNote());
	}

	@Override
	public void setRequestNote(String requestNote) {
		_requestNote = requestNote;

		if (_developerRequestRemoteModel != null) {
			try {
				Class<?> clazz = _developerRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestNote", String.class);

				method.invoke(_developerRequestRemoteModel, requestNote);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setRequestNote(String requestNote, Locale locale) {
		setRequestNote(requestNote, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setRequestNote(String requestNote, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(requestNote)) {
			setRequestNote(LocalizationUtil.updateLocalization(
					getRequestNote(), "RequestNote", requestNote, languageId,
					defaultLanguageId));
		}
		else {
			setRequestNote(LocalizationUtil.removeLocalization(
					getRequestNote(), "RequestNote", languageId));
		}
	}

	@Override
	public void setRequestNoteCurrentLanguageId(String languageId) {
		_requestNoteCurrentLanguageId = languageId;
	}

	@Override
	public void setRequestNoteMap(Map<Locale, String> requestNoteMap) {
		setRequestNoteMap(requestNoteMap, LocaleUtil.getDefault());
	}

	@Override
	public void setRequestNoteMap(Map<Locale, String> requestNoteMap,
		Locale defaultLocale) {
		if (requestNoteMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setRequestNote(LocalizationUtil.updateLocalization(requestNoteMap,
					getRequestNote(), "RequestNote",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getRequestStatus() {
		return _requestStatus;
	}

	@Override
	public void setRequestStatus(String requestStatus) {
		_requestStatus = requestStatus;

		if (_developerRequestRemoteModel != null) {
			try {
				Class<?> clazz = _developerRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestStatus", String.class);

				method.invoke(_developerRequestRemoteModel, requestStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getProcessDate() {
		return _processDate;
	}

	@Override
	public void setProcessDate(Date processDate) {
		_processDate = processDate;

		if (_developerRequestRemoteModel != null) {
			try {
				Class<?> clazz = _developerRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessDate", Date.class);

				method.invoke(_developerRequestRemoteModel, processDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProcessNote() {
		return _processNote;
	}

	@Override
	public String getProcessNote(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getProcessNote(languageId);
	}

	@Override
	public String getProcessNote(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getProcessNote(languageId, useDefault);
	}

	@Override
	public String getProcessNote(String languageId) {
		return LocalizationUtil.getLocalization(getProcessNote(), languageId);
	}

	@Override
	public String getProcessNote(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getProcessNote(), languageId,
			useDefault);
	}

	@Override
	public String getProcessNoteCurrentLanguageId() {
		return _processNoteCurrentLanguageId;
	}

	@Override
	public String getProcessNoteCurrentValue() {
		Locale locale = getLocale(_processNoteCurrentLanguageId);

		return getProcessNote(locale);
	}

	@Override
	public Map<Locale, String> getProcessNoteMap() {
		return LocalizationUtil.getLocalizationMap(getProcessNote());
	}

	@Override
	public void setProcessNote(String processNote) {
		_processNote = processNote;

		if (_developerRequestRemoteModel != null) {
			try {
				Class<?> clazz = _developerRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessNote", String.class);

				method.invoke(_developerRequestRemoteModel, processNote);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setProcessNote(String processNote, Locale locale) {
		setProcessNote(processNote, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setProcessNote(String processNote, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(processNote)) {
			setProcessNote(LocalizationUtil.updateLocalization(
					getProcessNote(), "ProcessNote", processNote, languageId,
					defaultLanguageId));
		}
		else {
			setProcessNote(LocalizationUtil.removeLocalization(
					getProcessNote(), "ProcessNote", languageId));
		}
	}

	@Override
	public void setProcessNoteCurrentLanguageId(String languageId) {
		_processNoteCurrentLanguageId = languageId;
	}

	@Override
	public void setProcessNoteMap(Map<Locale, String> processNoteMap) {
		setProcessNoteMap(processNoteMap, LocaleUtil.getDefault());
	}

	@Override
	public void setProcessNoteMap(Map<Locale, String> processNoteMap,
		Locale defaultLocale) {
		if (processNoteMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setProcessNote(LocalizationUtil.updateLocalization(processNoteMap,
					getProcessNote(), "ProcessNote",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
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

		if (_developerRequestRemoteModel != null) {
			try {
				Class<?> clazz = _developerRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertId", long.class);

				method.invoke(_developerRequestRemoteModel, insertId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getInsertDate() {
		return _insertDate;
	}

	@Override
	public void setInsertDate(Date insertDate) {
		_insertDate = insertDate;

		if (_developerRequestRemoteModel != null) {
			try {
				Class<?> clazz = _developerRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertDate", Date.class);

				method.invoke(_developerRequestRemoteModel, insertDate);
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

		if (_developerRequestRemoteModel != null) {
			try {
				Class<?> clazz = _developerRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateId", long.class);

				method.invoke(_developerRequestRemoteModel, updateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdateDate() {
		return _updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;

		if (_developerRequestRemoteModel != null) {
			try {
				Class<?> clazz = _developerRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateDate", Date.class);

				method.invoke(_developerRequestRemoteModel, updateDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDeveloperRequestRemoteModel() {
		return _developerRequestRemoteModel;
	}

	public void setDeveloperRequestRemoteModel(
		BaseModel<?> developerRequestRemoteModel) {
		_developerRequestRemoteModel = developerRequestRemoteModel;
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

		Class<?> remoteModelClass = _developerRequestRemoteModel.getClass();

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

		Object returnValue = method.invoke(_developerRequestRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DeveloperRequestLocalServiceUtil.addDeveloperRequest(this);
		}
		else {
			DeveloperRequestLocalServiceUtil.updateDeveloperRequest(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> requestNoteMap = getRequestNoteMap();

		for (Map.Entry<Locale, String> entry : requestNoteMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> processNoteMap = getProcessNoteMap();

		for (Map.Entry<Locale, String> entry : processNoteMap.entrySet()) {
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
		String xml = getRequestNote();

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

		String requestNote = getRequestNote(defaultLocale);

		if (Validator.isNull(requestNote)) {
			setRequestNote(getRequestNote(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setRequestNote(getRequestNote(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String processNote = getProcessNote(defaultLocale);

		if (Validator.isNull(processNote)) {
			setProcessNote(getProcessNote(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setProcessNote(getProcessNote(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public DeveloperRequest toEscapedModel() {
		return (DeveloperRequest)ProxyUtil.newProxyInstance(DeveloperRequest.class.getClassLoader(),
			new Class[] { DeveloperRequest.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DeveloperRequestClp clone = new DeveloperRequestClp();

		clone.setRequestSeq(getRequestSeq());
		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());
		clone.setRequestSort(getRequestSort());
		clone.setRequestDate(getRequestDate());
		clone.setRequestNote(getRequestNote());
		clone.setRequestStatus(getRequestStatus());
		clone.setProcessDate(getProcessDate());
		clone.setProcessNote(getProcessNote());
		clone.setInsertId(getInsertId());
		clone.setInsertDate(getInsertDate());
		clone.setUpdateId(getUpdateId());
		clone.setUpdateDate(getUpdateDate());

		return clone;
	}

	@Override
	public int compareTo(DeveloperRequest developerRequest) {
		int value = 0;

		value = DateUtil.compareTo(getInsertDate(),
				developerRequest.getInsertDate());

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

		if (!(obj instanceof DeveloperRequestClp)) {
			return false;
		}

		DeveloperRequestClp developerRequest = (DeveloperRequestClp)obj;

		DeveloperRequestPK primaryKey = developerRequest.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{requestSeq=");
		sb.append(getRequestSeq());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", requestSort=");
		sb.append(getRequestSort());
		sb.append(", requestDate=");
		sb.append(getRequestDate());
		sb.append(", requestNote=");
		sb.append(getRequestNote());
		sb.append(", requestStatus=");
		sb.append(getRequestStatus());
		sb.append(", processDate=");
		sb.append(getProcessDate());
		sb.append(", processNote=");
		sb.append(getProcessNote());
		sb.append(", insertId=");
		sb.append(getInsertId());
		sb.append(", insertDate=");
		sb.append(getInsertDate());
		sb.append(", updateId=");
		sb.append(getUpdateId());
		sb.append(", updateDate=");
		sb.append(getUpdateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.science.model.DeveloperRequest");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>requestSeq</column-name><column-value><![CDATA[");
		sb.append(getRequestSeq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestSort</column-name><column-value><![CDATA[");
		sb.append(getRequestSort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestDate</column-name><column-value><![CDATA[");
		sb.append(getRequestDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestNote</column-name><column-value><![CDATA[");
		sb.append(getRequestNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestStatus</column-name><column-value><![CDATA[");
		sb.append(getRequestStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processDate</column-name><column-value><![CDATA[");
		sb.append(getProcessDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processNote</column-name><column-value><![CDATA[");
		sb.append(getProcessNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertId</column-name><column-value><![CDATA[");
		sb.append(getInsertId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertDate</column-name><column-value><![CDATA[");
		sb.append(getInsertDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateId</column-name><column-value><![CDATA[");
		sb.append(getUpdateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateDate</column-name><column-value><![CDATA[");
		sb.append(getUpdateDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _requestSeq;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private String _requestSort;
	private Date _requestDate;
	private String _requestNote;
	private String _requestNoteCurrentLanguageId;
	private String _requestStatus;
	private Date _processDate;
	private String _processNote;
	private String _processNoteCurrentLanguageId;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
	private BaseModel<?> _developerRequestRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.science.service.ClpSerializer.class;
}