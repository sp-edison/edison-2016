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
 * This class is a wrapper for {@link Workflow}.
 * </p>
 *
 * @author EDISON
 * @see Workflow
 * @generated
 */
public class WorkflowWrapper implements Workflow, ModelWrapper<Workflow> {
	public WorkflowWrapper(Workflow workflow) {
		_workflow = workflow;
	}

	@Override
	public Class<?> getModelClass() {
		return Workflow.class;
	}

	@Override
	public String getModelClassName() {
		return Workflow.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workflowId", getWorkflowId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("isPublic", getIsPublic());
		attributes.put("parentWorkflowId", getParentWorkflowId());
		attributes.put("screenLogic", getScreenLogic());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workflowId = (Long)attributes.get("workflowId");

		if (workflowId != null) {
			setWorkflowId(workflowId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Boolean isPublic = (Boolean)attributes.get("isPublic");

		if (isPublic != null) {
			setIsPublic(isPublic);
		}

		Long parentWorkflowId = (Long)attributes.get("parentWorkflowId");

		if (parentWorkflowId != null) {
			setParentWorkflowId(parentWorkflowId);
		}

		String screenLogic = (String)attributes.get("screenLogic");

		if (screenLogic != null) {
			setScreenLogic(screenLogic);
		}
	}

	/**
	* Returns the primary key of this workflow.
	*
	* @return the primary key of this workflow
	*/
	@Override
	public long getPrimaryKey() {
		return _workflow.getPrimaryKey();
	}

	/**
	* Sets the primary key of this workflow.
	*
	* @param primaryKey the primary key of this workflow
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workflow.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the workflow ID of this workflow.
	*
	* @return the workflow ID of this workflow
	*/
	@Override
	public long getWorkflowId() {
		return _workflow.getWorkflowId();
	}

	/**
	* Sets the workflow ID of this workflow.
	*
	* @param workflowId the workflow ID of this workflow
	*/
	@Override
	public void setWorkflowId(long workflowId) {
		_workflow.setWorkflowId(workflowId);
	}

	/**
	* Returns the company ID of this workflow.
	*
	* @return the company ID of this workflow
	*/
	@Override
	public long getCompanyId() {
		return _workflow.getCompanyId();
	}

	/**
	* Sets the company ID of this workflow.
	*
	* @param companyId the company ID of this workflow
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workflow.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this workflow.
	*
	* @return the user ID of this workflow
	*/
	@Override
	public long getUserId() {
		return _workflow.getUserId();
	}

	/**
	* Sets the user ID of this workflow.
	*
	* @param userId the user ID of this workflow
	*/
	@Override
	public void setUserId(long userId) {
		_workflow.setUserId(userId);
	}

	/**
	* Returns the user uuid of this workflow.
	*
	* @return the user uuid of this workflow
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflow.getUserUuid();
	}

	/**
	* Sets the user uuid of this workflow.
	*
	* @param userUuid the user uuid of this workflow
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_workflow.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this workflow.
	*
	* @return the create date of this workflow
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _workflow.getCreateDate();
	}

	/**
	* Sets the create date of this workflow.
	*
	* @param createDate the create date of this workflow
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_workflow.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this workflow.
	*
	* @return the modified date of this workflow
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _workflow.getModifiedDate();
	}

	/**
	* Sets the modified date of this workflow.
	*
	* @param modifiedDate the modified date of this workflow
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_workflow.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this workflow.
	*
	* @return the title of this workflow
	*/
	@Override
	public java.lang.String getTitle() {
		return _workflow.getTitle();
	}

	/**
	* Returns the localized title of this workflow in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this workflow
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _workflow.getTitle(locale);
	}

	/**
	* Returns the localized title of this workflow in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this workflow. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _workflow.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this workflow in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this workflow
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _workflow.getTitle(languageId);
	}

	/**
	* Returns the localized title of this workflow in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this workflow
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _workflow.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _workflow.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _workflow.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this workflow.
	*
	* @return the locales and localized titles of this workflow
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _workflow.getTitleMap();
	}

	/**
	* Sets the title of this workflow.
	*
	* @param title the title of this workflow
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_workflow.setTitle(title);
	}

	/**
	* Sets the localized title of this workflow in the language.
	*
	* @param title the localized title of this workflow
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_workflow.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this workflow in the language, and sets the default locale.
	*
	* @param title the localized title of this workflow
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_workflow.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_workflow.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this workflow from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this workflow
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_workflow.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this workflow from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this workflow
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_workflow.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Returns the description of this workflow.
	*
	* @return the description of this workflow
	*/
	@Override
	public java.lang.String getDescription() {
		return _workflow.getDescription();
	}

	/**
	* Returns the localized description of this workflow in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this workflow
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _workflow.getDescription(locale);
	}

	/**
	* Returns the localized description of this workflow in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this workflow. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _workflow.getDescription(locale, useDefault);
	}

	/**
	* Returns the localized description of this workflow in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this workflow
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _workflow.getDescription(languageId);
	}

	/**
	* Returns the localized description of this workflow in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this workflow
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _workflow.getDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _workflow.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _workflow.getDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized descriptions of this workflow.
	*
	* @return the locales and localized descriptions of this workflow
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _workflow.getDescriptionMap();
	}

	/**
	* Sets the description of this workflow.
	*
	* @param description the description of this workflow
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_workflow.setDescription(description);
	}

	/**
	* Sets the localized description of this workflow in the language.
	*
	* @param description the localized description of this workflow
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_workflow.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this workflow in the language, and sets the default locale.
	*
	* @param description the localized description of this workflow
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_workflow.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_workflow.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this workflow from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this workflow
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap) {
		_workflow.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this workflow from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this workflow
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_workflow.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	* Returns the is public of this workflow.
	*
	* @return the is public of this workflow
	*/
	@Override
	public boolean getIsPublic() {
		return _workflow.getIsPublic();
	}

	/**
	* Returns <code>true</code> if this workflow is is public.
	*
	* @return <code>true</code> if this workflow is is public; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsPublic() {
		return _workflow.isIsPublic();
	}

	/**
	* Sets whether this workflow is is public.
	*
	* @param isPublic the is public of this workflow
	*/
	@Override
	public void setIsPublic(boolean isPublic) {
		_workflow.setIsPublic(isPublic);
	}

	/**
	* Returns the parent workflow ID of this workflow.
	*
	* @return the parent workflow ID of this workflow
	*/
	@Override
	public long getParentWorkflowId() {
		return _workflow.getParentWorkflowId();
	}

	/**
	* Sets the parent workflow ID of this workflow.
	*
	* @param parentWorkflowId the parent workflow ID of this workflow
	*/
	@Override
	public void setParentWorkflowId(long parentWorkflowId) {
		_workflow.setParentWorkflowId(parentWorkflowId);
	}

	/**
	* Returns the screen logic of this workflow.
	*
	* @return the screen logic of this workflow
	*/
	@Override
	public java.lang.String getScreenLogic() {
		return _workflow.getScreenLogic();
	}

	/**
	* Sets the screen logic of this workflow.
	*
	* @param screenLogic the screen logic of this workflow
	*/
	@Override
	public void setScreenLogic(java.lang.String screenLogic) {
		_workflow.setScreenLogic(screenLogic);
	}

	@Override
	public boolean isNew() {
		return _workflow.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_workflow.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _workflow.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workflow.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _workflow.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _workflow.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_workflow.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _workflow.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_workflow.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_workflow.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_workflow.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _workflow.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _workflow.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_workflow.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_workflow.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new WorkflowWrapper((Workflow)_workflow.clone());
	}

	@Override
	public int compareTo(org.kisti.edison.model.Workflow workflow) {
		return _workflow.compareTo(workflow);
	}

	@Override
	public int hashCode() {
		return _workflow.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.model.Workflow> toCacheModel() {
		return _workflow.toCacheModel();
	}

	@Override
	public org.kisti.edison.model.Workflow toEscapedModel() {
		return new WorkflowWrapper(_workflow.toEscapedModel());
	}

	@Override
	public org.kisti.edison.model.Workflow toUnescapedModel() {
		return new WorkflowWrapper(_workflow.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _workflow.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workflow.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflow.persist();
	}

	@Override
	public void setWorkflowModelAttributes(
		java.util.Map<java.lang.String, java.lang.Object> attributes) {
		_workflow.setWorkflowModelAttributes(attributes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkflowWrapper)) {
			return false;
		}

		WorkflowWrapper workflowWrapper = (WorkflowWrapper)obj;

		if (Validator.equals(_workflow, workflowWrapper._workflow)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Workflow getWrappedWorkflow() {
		return _workflow;
	}

	@Override
	public Workflow getWrappedModel() {
		return _workflow;
	}

	@Override
	public void resetOriginalValues() {
		_workflow.resetOriginalValues();
	}

	private Workflow _workflow;
}