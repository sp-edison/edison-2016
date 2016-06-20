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

package org.kisti.edison.bestsimulation.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SimulationJobData}.
 * </p>
 *
 * @author EDISON
 * @see SimulationJobData
 * @generated
 */
public class SimulationJobDataWrapper implements SimulationJobData,
	ModelWrapper<SimulationJobData> {
	public SimulationJobDataWrapper(SimulationJobData simulationJobData) {
		_simulationJobData = simulationJobData;
	}

	@Override
	public Class<?> getModelClass() {
		return SimulationJobData.class;
	}

	@Override
	public String getModelClassName() {
		return SimulationJobData.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobUuid", getJobUuid());
		attributes.put("jobData", getJobData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String jobUuid = (String)attributes.get("jobUuid");

		if (jobUuid != null) {
			setJobUuid(jobUuid);
		}

		String jobData = (String)attributes.get("jobData");

		if (jobData != null) {
			setJobData(jobData);
		}
	}

	/**
	* Returns the primary key of this simulation job data.
	*
	* @return the primary key of this simulation job data
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _simulationJobData.getPrimaryKey();
	}

	/**
	* Sets the primary key of this simulation job data.
	*
	* @param primaryKey the primary key of this simulation job data
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_simulationJobData.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the job uuid of this simulation job data.
	*
	* @return the job uuid of this simulation job data
	*/
	@Override
	public java.lang.String getJobUuid() {
		return _simulationJobData.getJobUuid();
	}

	/**
	* Sets the job uuid of this simulation job data.
	*
	* @param jobUuid the job uuid of this simulation job data
	*/
	@Override
	public void setJobUuid(java.lang.String jobUuid) {
		_simulationJobData.setJobUuid(jobUuid);
	}

	/**
	* Returns the job data of this simulation job data.
	*
	* @return the job data of this simulation job data
	*/
	@Override
	public java.lang.String getJobData() {
		return _simulationJobData.getJobData();
	}

	/**
	* Returns the localized job data of this simulation job data in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized job data of this simulation job data
	*/
	@Override
	public java.lang.String getJobData(java.util.Locale locale) {
		return _simulationJobData.getJobData(locale);
	}

	/**
	* Returns the localized job data of this simulation job data in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized job data of this simulation job data. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getJobData(java.util.Locale locale,
		boolean useDefault) {
		return _simulationJobData.getJobData(locale, useDefault);
	}

	/**
	* Returns the localized job data of this simulation job data in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized job data of this simulation job data
	*/
	@Override
	public java.lang.String getJobData(java.lang.String languageId) {
		return _simulationJobData.getJobData(languageId);
	}

	/**
	* Returns the localized job data of this simulation job data in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized job data of this simulation job data
	*/
	@Override
	public java.lang.String getJobData(java.lang.String languageId,
		boolean useDefault) {
		return _simulationJobData.getJobData(languageId, useDefault);
	}

	@Override
	public java.lang.String getJobDataCurrentLanguageId() {
		return _simulationJobData.getJobDataCurrentLanguageId();
	}

	@Override
	public java.lang.String getJobDataCurrentValue() {
		return _simulationJobData.getJobDataCurrentValue();
	}

	/**
	* Returns a map of the locales and localized job datas of this simulation job data.
	*
	* @return the locales and localized job datas of this simulation job data
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getJobDataMap() {
		return _simulationJobData.getJobDataMap();
	}

	/**
	* Sets the job data of this simulation job data.
	*
	* @param jobData the job data of this simulation job data
	*/
	@Override
	public void setJobData(java.lang.String jobData) {
		_simulationJobData.setJobData(jobData);
	}

	/**
	* Sets the localized job data of this simulation job data in the language.
	*
	* @param jobData the localized job data of this simulation job data
	* @param locale the locale of the language
	*/
	@Override
	public void setJobData(java.lang.String jobData, java.util.Locale locale) {
		_simulationJobData.setJobData(jobData, locale);
	}

	/**
	* Sets the localized job data of this simulation job data in the language, and sets the default locale.
	*
	* @param jobData the localized job data of this simulation job data
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setJobData(java.lang.String jobData, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_simulationJobData.setJobData(jobData, locale, defaultLocale);
	}

	@Override
	public void setJobDataCurrentLanguageId(java.lang.String languageId) {
		_simulationJobData.setJobDataCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized job datas of this simulation job data from the map of locales and localized job datas.
	*
	* @param jobDataMap the locales and localized job datas of this simulation job data
	*/
	@Override
	public void setJobDataMap(
		java.util.Map<java.util.Locale, java.lang.String> jobDataMap) {
		_simulationJobData.setJobDataMap(jobDataMap);
	}

	/**
	* Sets the localized job datas of this simulation job data from the map of locales and localized job datas, and sets the default locale.
	*
	* @param jobDataMap the locales and localized job datas of this simulation job data
	* @param defaultLocale the default locale
	*/
	@Override
	public void setJobDataMap(
		java.util.Map<java.util.Locale, java.lang.String> jobDataMap,
		java.util.Locale defaultLocale) {
		_simulationJobData.setJobDataMap(jobDataMap, defaultLocale);
	}

	@Override
	public boolean isNew() {
		return _simulationJobData.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_simulationJobData.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _simulationJobData.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_simulationJobData.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _simulationJobData.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _simulationJobData.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_simulationJobData.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _simulationJobData.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_simulationJobData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_simulationJobData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_simulationJobData.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _simulationJobData.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _simulationJobData.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_simulationJobData.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_simulationJobData.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new SimulationJobDataWrapper((SimulationJobData)_simulationJobData.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.bestsimulation.model.SimulationJobData simulationJobData) {
		return _simulationJobData.compareTo(simulationJobData);
	}

	@Override
	public int hashCode() {
		return _simulationJobData.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.bestsimulation.model.SimulationJobData> toCacheModel() {
		return _simulationJobData.toCacheModel();
	}

	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobData toEscapedModel() {
		return new SimulationJobDataWrapper(_simulationJobData.toEscapedModel());
	}

	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobData toUnescapedModel() {
		return new SimulationJobDataWrapper(_simulationJobData.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _simulationJobData.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _simulationJobData.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_simulationJobData.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SimulationJobDataWrapper)) {
			return false;
		}

		SimulationJobDataWrapper simulationJobDataWrapper = (SimulationJobDataWrapper)obj;

		if (Validator.equals(_simulationJobData,
					simulationJobDataWrapper._simulationJobData)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SimulationJobData getWrappedSimulationJobData() {
		return _simulationJobData;
	}

	@Override
	public SimulationJobData getWrappedModel() {
		return _simulationJobData;
	}

	@Override
	public void resetOriginalValues() {
		_simulationJobData.resetOriginalValues();
	}

	private SimulationJobData _simulationJobData;
}