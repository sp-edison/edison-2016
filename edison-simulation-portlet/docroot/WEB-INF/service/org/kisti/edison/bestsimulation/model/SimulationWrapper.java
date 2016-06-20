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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Simulation}.
 * </p>
 *
 * @author EDISON
 * @see Simulation
 * @generated
 */
public class SimulationWrapper implements Simulation, ModelWrapper<Simulation> {
	public SimulationWrapper(Simulation simulation) {
		_simulation = simulation;
	}

	@Override
	public Class<?> getModelClass() {
		return Simulation.class;
	}

	@Override
	public String getModelClassName() {
		return Simulation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("simulationUuid", getSimulationUuid());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("simulationTitle", getSimulationTitle());
		attributes.put("simulationDescription", getSimulationDescription());
		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("scienceAppName", getScienceAppName());
		attributes.put("simulationCreateDt", getSimulationCreateDt());
		attributes.put("cluster", getCluster());
		attributes.put("testYn", getTestYn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String simulationUuid = (String)attributes.get("simulationUuid");

		if (simulationUuid != null) {
			setSimulationUuid(simulationUuid);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String simulationTitle = (String)attributes.get("simulationTitle");

		if (simulationTitle != null) {
			setSimulationTitle(simulationTitle);
		}

		String simulationDescription = (String)attributes.get(
				"simulationDescription");

		if (simulationDescription != null) {
			setSimulationDescription(simulationDescription);
		}

		String scienceAppId = (String)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		String scienceAppName = (String)attributes.get("scienceAppName");

		if (scienceAppName != null) {
			setScienceAppName(scienceAppName);
		}

		Date simulationCreateDt = (Date)attributes.get("simulationCreateDt");

		if (simulationCreateDt != null) {
			setSimulationCreateDt(simulationCreateDt);
		}

		String cluster = (String)attributes.get("cluster");

		if (cluster != null) {
			setCluster(cluster);
		}

		String testYn = (String)attributes.get("testYn");

		if (testYn != null) {
			setTestYn(testYn);
		}
	}

	/**
	* Returns the primary key of this simulation.
	*
	* @return the primary key of this simulation
	*/
	@Override
	public org.kisti.edison.bestsimulation.service.persistence.SimulationPK getPrimaryKey() {
		return _simulation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this simulation.
	*
	* @param primaryKey the primary key of this simulation
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.bestsimulation.service.persistence.SimulationPK primaryKey) {
		_simulation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the simulation uuid of this simulation.
	*
	* @return the simulation uuid of this simulation
	*/
	@Override
	public java.lang.String getSimulationUuid() {
		return _simulation.getSimulationUuid();
	}

	/**
	* Sets the simulation uuid of this simulation.
	*
	* @param simulationUuid the simulation uuid of this simulation
	*/
	@Override
	public void setSimulationUuid(java.lang.String simulationUuid) {
		_simulation.setSimulationUuid(simulationUuid);
	}

	/**
	* Returns the group ID of this simulation.
	*
	* @return the group ID of this simulation
	*/
	@Override
	public long getGroupId() {
		return _simulation.getGroupId();
	}

	/**
	* Sets the group ID of this simulation.
	*
	* @param groupId the group ID of this simulation
	*/
	@Override
	public void setGroupId(long groupId) {
		_simulation.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this simulation.
	*
	* @return the user ID of this simulation
	*/
	@Override
	public long getUserId() {
		return _simulation.getUserId();
	}

	/**
	* Sets the user ID of this simulation.
	*
	* @param userId the user ID of this simulation
	*/
	@Override
	public void setUserId(long userId) {
		_simulation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this simulation.
	*
	* @return the user uuid of this simulation
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulation.getUserUuid();
	}

	/**
	* Sets the user uuid of this simulation.
	*
	* @param userUuid the user uuid of this simulation
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_simulation.setUserUuid(userUuid);
	}

	/**
	* Returns the simulation title of this simulation.
	*
	* @return the simulation title of this simulation
	*/
	@Override
	public java.lang.String getSimulationTitle() {
		return _simulation.getSimulationTitle();
	}

	/**
	* Returns the localized simulation title of this simulation in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized simulation title of this simulation
	*/
	@Override
	public java.lang.String getSimulationTitle(java.util.Locale locale) {
		return _simulation.getSimulationTitle(locale);
	}

	/**
	* Returns the localized simulation title of this simulation in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized simulation title of this simulation. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getSimulationTitle(java.util.Locale locale,
		boolean useDefault) {
		return _simulation.getSimulationTitle(locale, useDefault);
	}

	/**
	* Returns the localized simulation title of this simulation in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized simulation title of this simulation
	*/
	@Override
	public java.lang.String getSimulationTitle(java.lang.String languageId) {
		return _simulation.getSimulationTitle(languageId);
	}

	/**
	* Returns the localized simulation title of this simulation in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized simulation title of this simulation
	*/
	@Override
	public java.lang.String getSimulationTitle(java.lang.String languageId,
		boolean useDefault) {
		return _simulation.getSimulationTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getSimulationTitleCurrentLanguageId() {
		return _simulation.getSimulationTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getSimulationTitleCurrentValue() {
		return _simulation.getSimulationTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized simulation titles of this simulation.
	*
	* @return the locales and localized simulation titles of this simulation
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getSimulationTitleMap() {
		return _simulation.getSimulationTitleMap();
	}

	/**
	* Sets the simulation title of this simulation.
	*
	* @param simulationTitle the simulation title of this simulation
	*/
	@Override
	public void setSimulationTitle(java.lang.String simulationTitle) {
		_simulation.setSimulationTitle(simulationTitle);
	}

	/**
	* Sets the localized simulation title of this simulation in the language.
	*
	* @param simulationTitle the localized simulation title of this simulation
	* @param locale the locale of the language
	*/
	@Override
	public void setSimulationTitle(java.lang.String simulationTitle,
		java.util.Locale locale) {
		_simulation.setSimulationTitle(simulationTitle, locale);
	}

	/**
	* Sets the localized simulation title of this simulation in the language, and sets the default locale.
	*
	* @param simulationTitle the localized simulation title of this simulation
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSimulationTitle(java.lang.String simulationTitle,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_simulation.setSimulationTitle(simulationTitle, locale, defaultLocale);
	}

	@Override
	public void setSimulationTitleCurrentLanguageId(java.lang.String languageId) {
		_simulation.setSimulationTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized simulation titles of this simulation from the map of locales and localized simulation titles.
	*
	* @param simulationTitleMap the locales and localized simulation titles of this simulation
	*/
	@Override
	public void setSimulationTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> simulationTitleMap) {
		_simulation.setSimulationTitleMap(simulationTitleMap);
	}

	/**
	* Sets the localized simulation titles of this simulation from the map of locales and localized simulation titles, and sets the default locale.
	*
	* @param simulationTitleMap the locales and localized simulation titles of this simulation
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSimulationTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> simulationTitleMap,
		java.util.Locale defaultLocale) {
		_simulation.setSimulationTitleMap(simulationTitleMap, defaultLocale);
	}

	/**
	* Returns the simulation description of this simulation.
	*
	* @return the simulation description of this simulation
	*/
	@Override
	public java.lang.String getSimulationDescription() {
		return _simulation.getSimulationDescription();
	}

	/**
	* Returns the localized simulation description of this simulation in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized simulation description of this simulation
	*/
	@Override
	public java.lang.String getSimulationDescription(java.util.Locale locale) {
		return _simulation.getSimulationDescription(locale);
	}

	/**
	* Returns the localized simulation description of this simulation in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized simulation description of this simulation. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getSimulationDescription(java.util.Locale locale,
		boolean useDefault) {
		return _simulation.getSimulationDescription(locale, useDefault);
	}

	/**
	* Returns the localized simulation description of this simulation in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized simulation description of this simulation
	*/
	@Override
	public java.lang.String getSimulationDescription(
		java.lang.String languageId) {
		return _simulation.getSimulationDescription(languageId);
	}

	/**
	* Returns the localized simulation description of this simulation in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized simulation description of this simulation
	*/
	@Override
	public java.lang.String getSimulationDescription(
		java.lang.String languageId, boolean useDefault) {
		return _simulation.getSimulationDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getSimulationDescriptionCurrentLanguageId() {
		return _simulation.getSimulationDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getSimulationDescriptionCurrentValue() {
		return _simulation.getSimulationDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized simulation descriptions of this simulation.
	*
	* @return the locales and localized simulation descriptions of this simulation
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getSimulationDescriptionMap() {
		return _simulation.getSimulationDescriptionMap();
	}

	/**
	* Sets the simulation description of this simulation.
	*
	* @param simulationDescription the simulation description of this simulation
	*/
	@Override
	public void setSimulationDescription(java.lang.String simulationDescription) {
		_simulation.setSimulationDescription(simulationDescription);
	}

	/**
	* Sets the localized simulation description of this simulation in the language.
	*
	* @param simulationDescription the localized simulation description of this simulation
	* @param locale the locale of the language
	*/
	@Override
	public void setSimulationDescription(
		java.lang.String simulationDescription, java.util.Locale locale) {
		_simulation.setSimulationDescription(simulationDescription, locale);
	}

	/**
	* Sets the localized simulation description of this simulation in the language, and sets the default locale.
	*
	* @param simulationDescription the localized simulation description of this simulation
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSimulationDescription(
		java.lang.String simulationDescription, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_simulation.setSimulationDescription(simulationDescription, locale,
			defaultLocale);
	}

	@Override
	public void setSimulationDescriptionCurrentLanguageId(
		java.lang.String languageId) {
		_simulation.setSimulationDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized simulation descriptions of this simulation from the map of locales and localized simulation descriptions.
	*
	* @param simulationDescriptionMap the locales and localized simulation descriptions of this simulation
	*/
	@Override
	public void setSimulationDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> simulationDescriptionMap) {
		_simulation.setSimulationDescriptionMap(simulationDescriptionMap);
	}

	/**
	* Sets the localized simulation descriptions of this simulation from the map of locales and localized simulation descriptions, and sets the default locale.
	*
	* @param simulationDescriptionMap the locales and localized simulation descriptions of this simulation
	* @param defaultLocale the default locale
	*/
	@Override
	public void setSimulationDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> simulationDescriptionMap,
		java.util.Locale defaultLocale) {
		_simulation.setSimulationDescriptionMap(simulationDescriptionMap,
			defaultLocale);
	}

	/**
	* Returns the science app ID of this simulation.
	*
	* @return the science app ID of this simulation
	*/
	@Override
	public java.lang.String getScienceAppId() {
		return _simulation.getScienceAppId();
	}

	/**
	* Sets the science app ID of this simulation.
	*
	* @param scienceAppId the science app ID of this simulation
	*/
	@Override
	public void setScienceAppId(java.lang.String scienceAppId) {
		_simulation.setScienceAppId(scienceAppId);
	}

	/**
	* Returns the science app name of this simulation.
	*
	* @return the science app name of this simulation
	*/
	@Override
	public java.lang.String getScienceAppName() {
		return _simulation.getScienceAppName();
	}

	/**
	* Returns the localized science app name of this simulation in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized science app name of this simulation
	*/
	@Override
	public java.lang.String getScienceAppName(java.util.Locale locale) {
		return _simulation.getScienceAppName(locale);
	}

	/**
	* Returns the localized science app name of this simulation in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized science app name of this simulation. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getScienceAppName(java.util.Locale locale,
		boolean useDefault) {
		return _simulation.getScienceAppName(locale, useDefault);
	}

	/**
	* Returns the localized science app name of this simulation in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized science app name of this simulation
	*/
	@Override
	public java.lang.String getScienceAppName(java.lang.String languageId) {
		return _simulation.getScienceAppName(languageId);
	}

	/**
	* Returns the localized science app name of this simulation in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized science app name of this simulation
	*/
	@Override
	public java.lang.String getScienceAppName(java.lang.String languageId,
		boolean useDefault) {
		return _simulation.getScienceAppName(languageId, useDefault);
	}

	@Override
	public java.lang.String getScienceAppNameCurrentLanguageId() {
		return _simulation.getScienceAppNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getScienceAppNameCurrentValue() {
		return _simulation.getScienceAppNameCurrentValue();
	}

	/**
	* Returns a map of the locales and localized science app names of this simulation.
	*
	* @return the locales and localized science app names of this simulation
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getScienceAppNameMap() {
		return _simulation.getScienceAppNameMap();
	}

	/**
	* Sets the science app name of this simulation.
	*
	* @param scienceAppName the science app name of this simulation
	*/
	@Override
	public void setScienceAppName(java.lang.String scienceAppName) {
		_simulation.setScienceAppName(scienceAppName);
	}

	/**
	* Sets the localized science app name of this simulation in the language.
	*
	* @param scienceAppName the localized science app name of this simulation
	* @param locale the locale of the language
	*/
	@Override
	public void setScienceAppName(java.lang.String scienceAppName,
		java.util.Locale locale) {
		_simulation.setScienceAppName(scienceAppName, locale);
	}

	/**
	* Sets the localized science app name of this simulation in the language, and sets the default locale.
	*
	* @param scienceAppName the localized science app name of this simulation
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setScienceAppName(java.lang.String scienceAppName,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_simulation.setScienceAppName(scienceAppName, locale, defaultLocale);
	}

	@Override
	public void setScienceAppNameCurrentLanguageId(java.lang.String languageId) {
		_simulation.setScienceAppNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized science app names of this simulation from the map of locales and localized science app names.
	*
	* @param scienceAppNameMap the locales and localized science app names of this simulation
	*/
	@Override
	public void setScienceAppNameMap(
		java.util.Map<java.util.Locale, java.lang.String> scienceAppNameMap) {
		_simulation.setScienceAppNameMap(scienceAppNameMap);
	}

	/**
	* Sets the localized science app names of this simulation from the map of locales and localized science app names, and sets the default locale.
	*
	* @param scienceAppNameMap the locales and localized science app names of this simulation
	* @param defaultLocale the default locale
	*/
	@Override
	public void setScienceAppNameMap(
		java.util.Map<java.util.Locale, java.lang.String> scienceAppNameMap,
		java.util.Locale defaultLocale) {
		_simulation.setScienceAppNameMap(scienceAppNameMap, defaultLocale);
	}

	/**
	* Returns the simulation create dt of this simulation.
	*
	* @return the simulation create dt of this simulation
	*/
	@Override
	public java.util.Date getSimulationCreateDt() {
		return _simulation.getSimulationCreateDt();
	}

	/**
	* Sets the simulation create dt of this simulation.
	*
	* @param simulationCreateDt the simulation create dt of this simulation
	*/
	@Override
	public void setSimulationCreateDt(java.util.Date simulationCreateDt) {
		_simulation.setSimulationCreateDt(simulationCreateDt);
	}

	/**
	* Returns the cluster of this simulation.
	*
	* @return the cluster of this simulation
	*/
	@Override
	public java.lang.String getCluster() {
		return _simulation.getCluster();
	}

	/**
	* Sets the cluster of this simulation.
	*
	* @param cluster the cluster of this simulation
	*/
	@Override
	public void setCluster(java.lang.String cluster) {
		_simulation.setCluster(cluster);
	}

	/**
	* Returns the test yn of this simulation.
	*
	* @return the test yn of this simulation
	*/
	@Override
	public java.lang.String getTestYn() {
		return _simulation.getTestYn();
	}

	/**
	* Sets the test yn of this simulation.
	*
	* @param testYn the test yn of this simulation
	*/
	@Override
	public void setTestYn(java.lang.String testYn) {
		_simulation.setTestYn(testYn);
	}

	@Override
	public boolean isNew() {
		return _simulation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_simulation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _simulation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_simulation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _simulation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _simulation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_simulation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _simulation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_simulation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_simulation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_simulation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _simulation.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _simulation.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_simulation.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_simulation.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new SimulationWrapper((Simulation)_simulation.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.bestsimulation.model.Simulation simulation) {
		return _simulation.compareTo(simulation);
	}

	@Override
	public int hashCode() {
		return _simulation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.bestsimulation.model.Simulation> toCacheModel() {
		return _simulation.toCacheModel();
	}

	@Override
	public org.kisti.edison.bestsimulation.model.Simulation toEscapedModel() {
		return new SimulationWrapper(_simulation.toEscapedModel());
	}

	@Override
	public org.kisti.edison.bestsimulation.model.Simulation toUnescapedModel() {
		return new SimulationWrapper(_simulation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _simulation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _simulation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_simulation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SimulationWrapper)) {
			return false;
		}

		SimulationWrapper simulationWrapper = (SimulationWrapper)obj;

		if (Validator.equals(_simulation, simulationWrapper._simulation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Simulation getWrappedSimulation() {
		return _simulation;
	}

	@Override
	public Simulation getWrappedModel() {
		return _simulation;
	}

	@Override
	public void resetOriginalValues() {
		_simulation.resetOriginalValues();
	}

	private Simulation _simulation;
}