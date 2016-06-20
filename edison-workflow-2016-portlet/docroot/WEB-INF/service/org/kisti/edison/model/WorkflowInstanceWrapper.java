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

package org.kisti.edison.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WorkflowInstance}.
 * </p>
 *
 * @author EDISON
 * @see WorkflowInstance
 * @generated
 */
public class WorkflowInstanceWrapper implements WorkflowInstance,
	ModelWrapper<WorkflowInstance> {
	public WorkflowInstanceWrapper(WorkflowInstance workflowInstance) {
		_workflowInstance = workflowInstance;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkflowInstance.class;
	}

	@Override
	public String getModelClassName() {
		return WorkflowInstance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workflowInstanceId", getWorkflowInstanceId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("status", getStatus());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("workflowId", getWorkflowId());
		attributes.put("workflowUUID", getWorkflowUUID());
		attributes.put("screenLogic", getScreenLogic());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workflowInstanceId = (Long)attributes.get("workflowInstanceId");

		if (workflowInstanceId != null) {
			setWorkflowInstanceId(workflowInstanceId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Long workflowId = (Long)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
		}

		String workflowUUID = (String)attributes.get("workflowUUID");

		if (workflowUUID != null) {
			setWorkflowUUID(workflowUUID);
		}

		String screenLogic = (String)attributes.get("screenLogic");

		if (screenLogic != null) {
			setScreenLogic(screenLogic);
		}
	}

	/**
	* Returns the primary key of this workflow instance.
	*
	* @return the primary key of this workflow instance
	*/
	@Override
	public long getPrimaryKey() {
		return _workflowInstance.getPrimaryKey();
	}

	/**
	* Sets the primary key of this workflow instance.
	*
	* @param primaryKey the primary key of this workflow instance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workflowInstance.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the workflow instance ID of this workflow instance.
	*
	* @return the workflow instance ID of this workflow instance
	*/
	@Override
	public long getWorkflowInstanceId() {
		return _workflowInstance.getWorkflowInstanceId();
	}

	/**
	* Sets the workflow instance ID of this workflow instance.
	*
	* @param workflowInstanceId the workflow instance ID of this workflow instance
	*/
	@Override
	public void setWorkflowInstanceId(long workflowInstanceId) {
		_workflowInstance.setWorkflowInstanceId(workflowInstanceId);
	}

	/**
	* Returns the company ID of this workflow instance.
	*
	* @return the company ID of this workflow instance
	*/
	@Override
	public long getCompanyId() {
		return _workflowInstance.getCompanyId();
	}

	/**
	* Sets the company ID of this workflow instance.
	*
	* @param companyId the company ID of this workflow instance
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workflowInstance.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this workflow instance.
	*
	* @return the user ID of this workflow instance
	*/
	@Override
	public long getUserId() {
		return _workflowInstance.getUserId();
	}

	/**
	* Sets the user ID of this workflow instance.
	*
	* @param userId the user ID of this workflow instance
	*/
	@Override
	public void setUserId(long userId) {
		_workflowInstance.setUserId(userId);
	}

	/**
	* Returns the user uuid of this workflow instance.
	*
	* @return the user uuid of this workflow instance
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstance.getUserUuid();
	}

	/**
	* Sets the user uuid of this workflow instance.
	*
	* @param userUuid the user uuid of this workflow instance
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_workflowInstance.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this workflow instance.
	*
	* @return the create date of this workflow instance
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _workflowInstance.getCreateDate();
	}

	/**
	* Sets the create date of this workflow instance.
	*
	* @param createDate the create date of this workflow instance
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_workflowInstance.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this workflow instance.
	*
	* @return the modified date of this workflow instance
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _workflowInstance.getModifiedDate();
	}

	/**
	* Sets the modified date of this workflow instance.
	*
	* @param modifiedDate the modified date of this workflow instance
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_workflowInstance.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this workflow instance.
	*
	* @return the title of this workflow instance
	*/
	@Override
	public java.lang.String getTitle() {
		return _workflowInstance.getTitle();
	}

	/**
	* Returns the localized title of this workflow instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this workflow instance
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _workflowInstance.getTitle(locale);
	}

	/**
	* Returns the localized title of this workflow instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this workflow instance. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _workflowInstance.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this workflow instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this workflow instance
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _workflowInstance.getTitle(languageId);
	}

	/**
	* Returns the localized title of this workflow instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this workflow instance
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _workflowInstance.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _workflowInstance.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _workflowInstance.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this workflow instance.
	*
	* @return the locales and localized titles of this workflow instance
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _workflowInstance.getTitleMap();
	}

	/**
	* Sets the title of this workflow instance.
	*
	* @param title the title of this workflow instance
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_workflowInstance.setTitle(title);
	}

	/**
	* Sets the localized title of this workflow instance in the language.
	*
	* @param title the localized title of this workflow instance
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_workflowInstance.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this workflow instance in the language, and sets the default locale.
	*
	* @param title the localized title of this workflow instance
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_workflowInstance.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_workflowInstance.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this workflow instance from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this workflow instance
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_workflowInstance.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this workflow instance from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this workflow instance
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_workflowInstance.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Returns the status of this workflow instance.
	*
	* @return the status of this workflow instance
	*/
	@Override
	public java.lang.String getStatus() {
		return _workflowInstance.getStatus();
	}

	/**
	* Returns the localized status of this workflow instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized status of this workflow instance
	*/
	@Override
	public java.lang.String getStatus(java.util.Locale locale) {
		return _workflowInstance.getStatus(locale);
	}

	/**
	* Returns the localized status of this workflow instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized status of this workflow instance. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getStatus(java.util.Locale locale,
		boolean useDefault) {
		return _workflowInstance.getStatus(locale, useDefault);
	}

	/**
	* Returns the localized status of this workflow instance in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized status of this workflow instance
	*/
	@Override
	public java.lang.String getStatus(java.lang.String languageId) {
		return _workflowInstance.getStatus(languageId);
	}

	/**
	* Returns the localized status of this workflow instance in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized status of this workflow instance
	*/
	@Override
	public java.lang.String getStatus(java.lang.String languageId,
		boolean useDefault) {
		return _workflowInstance.getStatus(languageId, useDefault);
	}

	@Override
	public java.lang.String getStatusCurrentLanguageId() {
		return _workflowInstance.getStatusCurrentLanguageId();
	}

	@Override
	public java.lang.String getStatusCurrentValue() {
		return _workflowInstance.getStatusCurrentValue();
	}

	/**
	* Returns a map of the locales and localized statuses of this workflow instance.
	*
	* @return the locales and localized statuses of this workflow instance
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getStatusMap() {
		return _workflowInstance.getStatusMap();
	}

	/**
	* Sets the status of this workflow instance.
	*
	* @param status the status of this workflow instance
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_workflowInstance.setStatus(status);
	}

	/**
	* Sets the localized status of this workflow instance in the language.
	*
	* @param status the localized status of this workflow instance
	* @param locale the locale of the language
	*/
	@Override
	public void setStatus(java.lang.String status, java.util.Locale locale) {
		_workflowInstance.setStatus(status, locale);
	}

	/**
	* Sets the localized status of this workflow instance in the language, and sets the default locale.
	*
	* @param status the localized status of this workflow instance
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setStatus(java.lang.String status, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_workflowInstance.setStatus(status, locale, defaultLocale);
	}

	@Override
	public void setStatusCurrentLanguageId(java.lang.String languageId) {
		_workflowInstance.setStatusCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized statuses of this workflow instance from the map of locales and localized statuses.
	*
	* @param statusMap the locales and localized statuses of this workflow instance
	*/
	@Override
	public void setStatusMap(
		java.util.Map<java.util.Locale, java.lang.String> statusMap) {
		_workflowInstance.setStatusMap(statusMap);
	}

	/**
	* Sets the localized statuses of this workflow instance from the map of locales and localized statuses, and sets the default locale.
	*
	* @param statusMap the locales and localized statuses of this workflow instance
	* @param defaultLocale the default locale
	*/
	@Override
	public void setStatusMap(
		java.util.Map<java.util.Locale, java.lang.String> statusMap,
		java.util.Locale defaultLocale) {
		_workflowInstance.setStatusMap(statusMap, defaultLocale);
	}

	/**
	* Returns the start time of this workflow instance.
	*
	* @return the start time of this workflow instance
	*/
	@Override
	public java.util.Date getStartTime() {
		return _workflowInstance.getStartTime();
	}

	/**
	* Sets the start time of this workflow instance.
	*
	* @param startTime the start time of this workflow instance
	*/
	@Override
	public void setStartTime(java.util.Date startTime) {
		_workflowInstance.setStartTime(startTime);
	}

	/**
	* Returns the end time of this workflow instance.
	*
	* @return the end time of this workflow instance
	*/
	@Override
	public java.util.Date getEndTime() {
		return _workflowInstance.getEndTime();
	}

	/**
	* Sets the end time of this workflow instance.
	*
	* @param endTime the end time of this workflow instance
	*/
	@Override
	public void setEndTime(java.util.Date endTime) {
		_workflowInstance.setEndTime(endTime);
	}

	/**
	* Returns the workflow ID of this workflow instance.
	*
	* @return the workflow ID of this workflow instance
	*/
	@Override
	public long getWorkflowId() {
		return _workflowInstance.getWorkflowId();
	}

	/**
	* Sets the workflow ID of this workflow instance.
	*
	* @param workflowId the workflow ID of this workflow instance
	*/
	@Override
	public void setWorkflowId(long workflowId) {
		_workflowInstance.setWorkflowId(workflowId);
	}

	/**
	* Returns the workflow u u i d of this workflow instance.
	*
	* @return the workflow u u i d of this workflow instance
	*/
	@Override
	public java.lang.String getWorkflowUUID() {
		return _workflowInstance.getWorkflowUUID();
	}

	/**
	* Sets the workflow u u i d of this workflow instance.
	*
	* @param workflowUUID the workflow u u i d of this workflow instance
	*/
	@Override
	public void setWorkflowUUID(java.lang.String workflowUUID) {
		_workflowInstance.setWorkflowUUID(workflowUUID);
	}

	/**
	* Returns the screen logic of this workflow instance.
	*
	* @return the screen logic of this workflow instance
	*/
	@Override
	public java.lang.String getScreenLogic() {
		return _workflowInstance.getScreenLogic();
	}

	/**
	* Sets the screen logic of this workflow instance.
	*
	* @param screenLogic the screen logic of this workflow instance
	*/
	@Override
	public void setScreenLogic(java.lang.String screenLogic) {
		_workflowInstance.setScreenLogic(screenLogic);
	}

	@Override
	public boolean isNew() {
		return _workflowInstance.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_workflowInstance.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _workflowInstance.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workflowInstance.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _workflowInstance.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _workflowInstance.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_workflowInstance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _workflowInstance.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_workflowInstance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_workflowInstance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_workflowInstance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _workflowInstance.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _workflowInstance.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_workflowInstance.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_workflowInstance.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new WorkflowInstanceWrapper((WorkflowInstance)_workflowInstance.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.model.WorkflowInstance workflowInstance) {
		return _workflowInstance.compareTo(workflowInstance);
	}

	@Override
	public int hashCode() {
		return _workflowInstance.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.model.WorkflowInstance> toCacheModel() {
		return _workflowInstance.toCacheModel();
	}

	@Override
	public org.kisti.edison.model.WorkflowInstance toEscapedModel() {
		return new WorkflowInstanceWrapper(_workflowInstance.toEscapedModel());
	}

	@Override
	public org.kisti.edison.model.WorkflowInstance toUnescapedModel() {
		return new WorkflowInstanceWrapper(_workflowInstance.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _workflowInstance.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workflowInstance.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflowInstance.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkflowInstanceWrapper)) {
			return false;
		}

		WorkflowInstanceWrapper workflowInstanceWrapper = (WorkflowInstanceWrapper)obj;

		if (Validator.equals(_workflowInstance,
					workflowInstanceWrapper._workflowInstance)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WorkflowInstance getWrappedWorkflowInstance() {
		return _workflowInstance;
	}

	@Override
	public WorkflowInstance getWrappedModel() {
		return _workflowInstance;
	}

	@Override
	public void resetOriginalValues() {
		_workflowInstance.resetOriginalValues();
	}

	private WorkflowInstance _workflowInstance;
}