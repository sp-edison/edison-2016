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
 * This class is a wrapper for {@link DeveloperRequest}.
 * </p>
 *
 * @author EDISON
 * @see DeveloperRequest
 * @generated
 */
public class DeveloperRequestWrapper implements DeveloperRequest,
	ModelWrapper<DeveloperRequest> {
	public DeveloperRequestWrapper(DeveloperRequest developerRequest) {
		_developerRequest = developerRequest;
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

	/**
	* Returns the primary key of this developer request.
	*
	* @return the primary key of this developer request
	*/
	@Override
	public org.kisti.edison.science.service.persistence.DeveloperRequestPK getPrimaryKey() {
		return _developerRequest.getPrimaryKey();
	}

	/**
	* Sets the primary key of this developer request.
	*
	* @param primaryKey the primary key of this developer request
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK primaryKey) {
		_developerRequest.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the request seq of this developer request.
	*
	* @return the request seq of this developer request
	*/
	@Override
	public long getRequestSeq() {
		return _developerRequest.getRequestSeq();
	}

	/**
	* Sets the request seq of this developer request.
	*
	* @param requestSeq the request seq of this developer request
	*/
	@Override
	public void setRequestSeq(long requestSeq) {
		_developerRequest.setRequestSeq(requestSeq);
	}

	/**
	* Returns the user ID of this developer request.
	*
	* @return the user ID of this developer request
	*/
	@Override
	public long getUserId() {
		return _developerRequest.getUserId();
	}

	/**
	* Sets the user ID of this developer request.
	*
	* @param userId the user ID of this developer request
	*/
	@Override
	public void setUserId(long userId) {
		_developerRequest.setUserId(userId);
	}

	/**
	* Returns the user uuid of this developer request.
	*
	* @return the user uuid of this developer request
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerRequest.getUserUuid();
	}

	/**
	* Sets the user uuid of this developer request.
	*
	* @param userUuid the user uuid of this developer request
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_developerRequest.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this developer request.
	*
	* @return the group ID of this developer request
	*/
	@Override
	public long getGroupId() {
		return _developerRequest.getGroupId();
	}

	/**
	* Sets the group ID of this developer request.
	*
	* @param groupId the group ID of this developer request
	*/
	@Override
	public void setGroupId(long groupId) {
		_developerRequest.setGroupId(groupId);
	}

	/**
	* Returns the request sort of this developer request.
	*
	* @return the request sort of this developer request
	*/
	@Override
	public java.lang.String getRequestSort() {
		return _developerRequest.getRequestSort();
	}

	/**
	* Sets the request sort of this developer request.
	*
	* @param requestSort the request sort of this developer request
	*/
	@Override
	public void setRequestSort(java.lang.String requestSort) {
		_developerRequest.setRequestSort(requestSort);
	}

	/**
	* Returns the request date of this developer request.
	*
	* @return the request date of this developer request
	*/
	@Override
	public java.util.Date getRequestDate() {
		return _developerRequest.getRequestDate();
	}

	/**
	* Sets the request date of this developer request.
	*
	* @param requestDate the request date of this developer request
	*/
	@Override
	public void setRequestDate(java.util.Date requestDate) {
		_developerRequest.setRequestDate(requestDate);
	}

	/**
	* Returns the request note of this developer request.
	*
	* @return the request note of this developer request
	*/
	@Override
	public java.lang.String getRequestNote() {
		return _developerRequest.getRequestNote();
	}

	/**
	* Returns the localized request note of this developer request in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized request note of this developer request
	*/
	@Override
	public java.lang.String getRequestNote(java.util.Locale locale) {
		return _developerRequest.getRequestNote(locale);
	}

	/**
	* Returns the localized request note of this developer request in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized request note of this developer request. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getRequestNote(java.util.Locale locale,
		boolean useDefault) {
		return _developerRequest.getRequestNote(locale, useDefault);
	}

	/**
	* Returns the localized request note of this developer request in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized request note of this developer request
	*/
	@Override
	public java.lang.String getRequestNote(java.lang.String languageId) {
		return _developerRequest.getRequestNote(languageId);
	}

	/**
	* Returns the localized request note of this developer request in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized request note of this developer request
	*/
	@Override
	public java.lang.String getRequestNote(java.lang.String languageId,
		boolean useDefault) {
		return _developerRequest.getRequestNote(languageId, useDefault);
	}

	@Override
	public java.lang.String getRequestNoteCurrentLanguageId() {
		return _developerRequest.getRequestNoteCurrentLanguageId();
	}

	@Override
	public java.lang.String getRequestNoteCurrentValue() {
		return _developerRequest.getRequestNoteCurrentValue();
	}

	/**
	* Returns a map of the locales and localized request notes of this developer request.
	*
	* @return the locales and localized request notes of this developer request
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getRequestNoteMap() {
		return _developerRequest.getRequestNoteMap();
	}

	/**
	* Sets the request note of this developer request.
	*
	* @param requestNote the request note of this developer request
	*/
	@Override
	public void setRequestNote(java.lang.String requestNote) {
		_developerRequest.setRequestNote(requestNote);
	}

	/**
	* Sets the localized request note of this developer request in the language.
	*
	* @param requestNote the localized request note of this developer request
	* @param locale the locale of the language
	*/
	@Override
	public void setRequestNote(java.lang.String requestNote,
		java.util.Locale locale) {
		_developerRequest.setRequestNote(requestNote, locale);
	}

	/**
	* Sets the localized request note of this developer request in the language, and sets the default locale.
	*
	* @param requestNote the localized request note of this developer request
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setRequestNote(java.lang.String requestNote,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_developerRequest.setRequestNote(requestNote, locale, defaultLocale);
	}

	@Override
	public void setRequestNoteCurrentLanguageId(java.lang.String languageId) {
		_developerRequest.setRequestNoteCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized request notes of this developer request from the map of locales and localized request notes.
	*
	* @param requestNoteMap the locales and localized request notes of this developer request
	*/
	@Override
	public void setRequestNoteMap(
		java.util.Map<java.util.Locale, java.lang.String> requestNoteMap) {
		_developerRequest.setRequestNoteMap(requestNoteMap);
	}

	/**
	* Sets the localized request notes of this developer request from the map of locales and localized request notes, and sets the default locale.
	*
	* @param requestNoteMap the locales and localized request notes of this developer request
	* @param defaultLocale the default locale
	*/
	@Override
	public void setRequestNoteMap(
		java.util.Map<java.util.Locale, java.lang.String> requestNoteMap,
		java.util.Locale defaultLocale) {
		_developerRequest.setRequestNoteMap(requestNoteMap, defaultLocale);
	}

	/**
	* Returns the request status of this developer request.
	*
	* @return the request status of this developer request
	*/
	@Override
	public java.lang.String getRequestStatus() {
		return _developerRequest.getRequestStatus();
	}

	/**
	* Sets the request status of this developer request.
	*
	* @param requestStatus the request status of this developer request
	*/
	@Override
	public void setRequestStatus(java.lang.String requestStatus) {
		_developerRequest.setRequestStatus(requestStatus);
	}

	/**
	* Returns the process date of this developer request.
	*
	* @return the process date of this developer request
	*/
	@Override
	public java.util.Date getProcessDate() {
		return _developerRequest.getProcessDate();
	}

	/**
	* Sets the process date of this developer request.
	*
	* @param processDate the process date of this developer request
	*/
	@Override
	public void setProcessDate(java.util.Date processDate) {
		_developerRequest.setProcessDate(processDate);
	}

	/**
	* Returns the process note of this developer request.
	*
	* @return the process note of this developer request
	*/
	@Override
	public java.lang.String getProcessNote() {
		return _developerRequest.getProcessNote();
	}

	/**
	* Returns the localized process note of this developer request in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized process note of this developer request
	*/
	@Override
	public java.lang.String getProcessNote(java.util.Locale locale) {
		return _developerRequest.getProcessNote(locale);
	}

	/**
	* Returns the localized process note of this developer request in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized process note of this developer request. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getProcessNote(java.util.Locale locale,
		boolean useDefault) {
		return _developerRequest.getProcessNote(locale, useDefault);
	}

	/**
	* Returns the localized process note of this developer request in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized process note of this developer request
	*/
	@Override
	public java.lang.String getProcessNote(java.lang.String languageId) {
		return _developerRequest.getProcessNote(languageId);
	}

	/**
	* Returns the localized process note of this developer request in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized process note of this developer request
	*/
	@Override
	public java.lang.String getProcessNote(java.lang.String languageId,
		boolean useDefault) {
		return _developerRequest.getProcessNote(languageId, useDefault);
	}

	@Override
	public java.lang.String getProcessNoteCurrentLanguageId() {
		return _developerRequest.getProcessNoteCurrentLanguageId();
	}

	@Override
	public java.lang.String getProcessNoteCurrentValue() {
		return _developerRequest.getProcessNoteCurrentValue();
	}

	/**
	* Returns a map of the locales and localized process notes of this developer request.
	*
	* @return the locales and localized process notes of this developer request
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getProcessNoteMap() {
		return _developerRequest.getProcessNoteMap();
	}

	/**
	* Sets the process note of this developer request.
	*
	* @param processNote the process note of this developer request
	*/
	@Override
	public void setProcessNote(java.lang.String processNote) {
		_developerRequest.setProcessNote(processNote);
	}

	/**
	* Sets the localized process note of this developer request in the language.
	*
	* @param processNote the localized process note of this developer request
	* @param locale the locale of the language
	*/
	@Override
	public void setProcessNote(java.lang.String processNote,
		java.util.Locale locale) {
		_developerRequest.setProcessNote(processNote, locale);
	}

	/**
	* Sets the localized process note of this developer request in the language, and sets the default locale.
	*
	* @param processNote the localized process note of this developer request
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setProcessNote(java.lang.String processNote,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_developerRequest.setProcessNote(processNote, locale, defaultLocale);
	}

	@Override
	public void setProcessNoteCurrentLanguageId(java.lang.String languageId) {
		_developerRequest.setProcessNoteCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized process notes of this developer request from the map of locales and localized process notes.
	*
	* @param processNoteMap the locales and localized process notes of this developer request
	*/
	@Override
	public void setProcessNoteMap(
		java.util.Map<java.util.Locale, java.lang.String> processNoteMap) {
		_developerRequest.setProcessNoteMap(processNoteMap);
	}

	/**
	* Sets the localized process notes of this developer request from the map of locales and localized process notes, and sets the default locale.
	*
	* @param processNoteMap the locales and localized process notes of this developer request
	* @param defaultLocale the default locale
	*/
	@Override
	public void setProcessNoteMap(
		java.util.Map<java.util.Locale, java.lang.String> processNoteMap,
		java.util.Locale defaultLocale) {
		_developerRequest.setProcessNoteMap(processNoteMap, defaultLocale);
	}

	/**
	* Returns the insert ID of this developer request.
	*
	* @return the insert ID of this developer request
	*/
	@Override
	public long getInsertId() {
		return _developerRequest.getInsertId();
	}

	/**
	* Sets the insert ID of this developer request.
	*
	* @param insertId the insert ID of this developer request
	*/
	@Override
	public void setInsertId(long insertId) {
		_developerRequest.setInsertId(insertId);
	}

	/**
	* Returns the insert date of this developer request.
	*
	* @return the insert date of this developer request
	*/
	@Override
	public java.util.Date getInsertDate() {
		return _developerRequest.getInsertDate();
	}

	/**
	* Sets the insert date of this developer request.
	*
	* @param insertDate the insert date of this developer request
	*/
	@Override
	public void setInsertDate(java.util.Date insertDate) {
		_developerRequest.setInsertDate(insertDate);
	}

	/**
	* Returns the update ID of this developer request.
	*
	* @return the update ID of this developer request
	*/
	@Override
	public long getUpdateId() {
		return _developerRequest.getUpdateId();
	}

	/**
	* Sets the update ID of this developer request.
	*
	* @param updateId the update ID of this developer request
	*/
	@Override
	public void setUpdateId(long updateId) {
		_developerRequest.setUpdateId(updateId);
	}

	/**
	* Returns the update date of this developer request.
	*
	* @return the update date of this developer request
	*/
	@Override
	public java.util.Date getUpdateDate() {
		return _developerRequest.getUpdateDate();
	}

	/**
	* Sets the update date of this developer request.
	*
	* @param updateDate the update date of this developer request
	*/
	@Override
	public void setUpdateDate(java.util.Date updateDate) {
		_developerRequest.setUpdateDate(updateDate);
	}

	@Override
	public boolean isNew() {
		return _developerRequest.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_developerRequest.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _developerRequest.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_developerRequest.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _developerRequest.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _developerRequest.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_developerRequest.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _developerRequest.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_developerRequest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_developerRequest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_developerRequest.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _developerRequest.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _developerRequest.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_developerRequest.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_developerRequest.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new DeveloperRequestWrapper((DeveloperRequest)_developerRequest.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.science.model.DeveloperRequest developerRequest) {
		return _developerRequest.compareTo(developerRequest);
	}

	@Override
	public int hashCode() {
		return _developerRequest.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.science.model.DeveloperRequest> toCacheModel() {
		return _developerRequest.toCacheModel();
	}

	@Override
	public org.kisti.edison.science.model.DeveloperRequest toEscapedModel() {
		return new DeveloperRequestWrapper(_developerRequest.toEscapedModel());
	}

	@Override
	public org.kisti.edison.science.model.DeveloperRequest toUnescapedModel() {
		return new DeveloperRequestWrapper(_developerRequest.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _developerRequest.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _developerRequest.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_developerRequest.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DeveloperRequestWrapper)) {
			return false;
		}

		DeveloperRequestWrapper developerRequestWrapper = (DeveloperRequestWrapper)obj;

		if (Validator.equals(_developerRequest,
					developerRequestWrapper._developerRequest)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DeveloperRequest getWrappedDeveloperRequest() {
		return _developerRequest;
	}

	@Override
	public DeveloperRequest getWrappedModel() {
		return _developerRequest;
	}

	@Override
	public void resetOriginalValues() {
		_developerRequest.resetOriginalValues();
	}

	private DeveloperRequest _developerRequest;
}