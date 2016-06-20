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
 * This class is a wrapper for {@link SimulationJob}.
 * </p>
 *
 * @author EDISON
 * @see SimulationJob
 * @generated
 */
public class SimulationJobWrapper implements SimulationJob,
	ModelWrapper<SimulationJob> {
	public SimulationJobWrapper(SimulationJob simulationJob) {
		_simulationJob = simulationJob;
	}

	@Override
	public Class<?> getModelClass() {
		return SimulationJob.class;
	}

	@Override
	public String getModelClassName() {
		return SimulationJob.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobSeqNo", getJobSeqNo());
		attributes.put("simulationUuid", getSimulationUuid());
		attributes.put("groupId", getGroupId());
		attributes.put("jobUuid", getJobUuid());
		attributes.put("jobStatus", getJobStatus());
		attributes.put("jobStartDt", getJobStartDt());
		attributes.put("jobEndDt", getJobEndDt());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("jobExecPath", getJobExecPath());
		attributes.put("jobPhase", getJobPhase());
		attributes.put("jobSubmitDt", getJobSubmitDt());
		attributes.put("jobPostProcessor", getJobPostProcessor());
		attributes.put("jobUniversityField", getJobUniversityField());
		attributes.put("jobVirtualLabId", getJobVirtualLabId());
		attributes.put("jobClassId", getJobClassId());
		attributes.put("jobInputDeckYn", getJobInputDeckYn());
		attributes.put("jobInputDeckName", getJobInputDeckName());
		attributes.put("resultSize", getResultSize());
		attributes.put("testYn", getTestYn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobSeqNo = (Long)attributes.get("jobSeqNo");

		if (jobSeqNo != null) {
			setJobSeqNo(jobSeqNo);
		}

		String simulationUuid = (String)attributes.get("simulationUuid");

		if (simulationUuid != null) {
			setSimulationUuid(simulationUuid);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String jobUuid = (String)attributes.get("jobUuid");

		if (jobUuid != null) {
			setJobUuid(jobUuid);
		}

		Long jobStatus = (Long)attributes.get("jobStatus");

		if (jobStatus != null) {
			setJobStatus(jobStatus);
		}

		Date jobStartDt = (Date)attributes.get("jobStartDt");

		if (jobStartDt != null) {
			setJobStartDt(jobStartDt);
		}

		Date jobEndDt = (Date)attributes.get("jobEndDt");

		if (jobEndDt != null) {
			setJobEndDt(jobEndDt);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		String jobExecPath = (String)attributes.get("jobExecPath");

		if (jobExecPath != null) {
			setJobExecPath(jobExecPath);
		}

		Long jobPhase = (Long)attributes.get("jobPhase");

		if (jobPhase != null) {
			setJobPhase(jobPhase);
		}

		Date jobSubmitDt = (Date)attributes.get("jobSubmitDt");

		if (jobSubmitDt != null) {
			setJobSubmitDt(jobSubmitDt);
		}

		String jobPostProcessor = (String)attributes.get("jobPostProcessor");

		if (jobPostProcessor != null) {
			setJobPostProcessor(jobPostProcessor);
		}

		Long jobUniversityField = (Long)attributes.get("jobUniversityField");

		if (jobUniversityField != null) {
			setJobUniversityField(jobUniversityField);
		}

		Long jobVirtualLabId = (Long)attributes.get("jobVirtualLabId");

		if (jobVirtualLabId != null) {
			setJobVirtualLabId(jobVirtualLabId);
		}

		Long jobClassId = (Long)attributes.get("jobClassId");

		if (jobClassId != null) {
			setJobClassId(jobClassId);
		}

		Boolean jobInputDeckYn = (Boolean)attributes.get("jobInputDeckYn");

		if (jobInputDeckYn != null) {
			setJobInputDeckYn(jobInputDeckYn);
		}

		String jobInputDeckName = (String)attributes.get("jobInputDeckName");

		if (jobInputDeckName != null) {
			setJobInputDeckName(jobInputDeckName);
		}

		Integer resultSize = (Integer)attributes.get("resultSize");

		if (resultSize != null) {
			setResultSize(resultSize);
		}

		String testYn = (String)attributes.get("testYn");

		if (testYn != null) {
			setTestYn(testYn);
		}
	}

	/**
	* Returns the primary key of this simulation job.
	*
	* @return the primary key of this simulation job
	*/
	@Override
	public org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK getPrimaryKey() {
		return _simulationJob.getPrimaryKey();
	}

	/**
	* Sets the primary key of this simulation job.
	*
	* @param primaryKey the primary key of this simulation job
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK primaryKey) {
		_simulationJob.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the job seq no of this simulation job.
	*
	* @return the job seq no of this simulation job
	*/
	@Override
	public long getJobSeqNo() {
		return _simulationJob.getJobSeqNo();
	}

	/**
	* Sets the job seq no of this simulation job.
	*
	* @param jobSeqNo the job seq no of this simulation job
	*/
	@Override
	public void setJobSeqNo(long jobSeqNo) {
		_simulationJob.setJobSeqNo(jobSeqNo);
	}

	/**
	* Returns the simulation uuid of this simulation job.
	*
	* @return the simulation uuid of this simulation job
	*/
	@Override
	public java.lang.String getSimulationUuid() {
		return _simulationJob.getSimulationUuid();
	}

	/**
	* Sets the simulation uuid of this simulation job.
	*
	* @param simulationUuid the simulation uuid of this simulation job
	*/
	@Override
	public void setSimulationUuid(java.lang.String simulationUuid) {
		_simulationJob.setSimulationUuid(simulationUuid);
	}

	/**
	* Returns the group ID of this simulation job.
	*
	* @return the group ID of this simulation job
	*/
	@Override
	public long getGroupId() {
		return _simulationJob.getGroupId();
	}

	/**
	* Sets the group ID of this simulation job.
	*
	* @param groupId the group ID of this simulation job
	*/
	@Override
	public void setGroupId(long groupId) {
		_simulationJob.setGroupId(groupId);
	}

	/**
	* Returns the job uuid of this simulation job.
	*
	* @return the job uuid of this simulation job
	*/
	@Override
	public java.lang.String getJobUuid() {
		return _simulationJob.getJobUuid();
	}

	/**
	* Sets the job uuid of this simulation job.
	*
	* @param jobUuid the job uuid of this simulation job
	*/
	@Override
	public void setJobUuid(java.lang.String jobUuid) {
		_simulationJob.setJobUuid(jobUuid);
	}

	/**
	* Returns the job status of this simulation job.
	*
	* @return the job status of this simulation job
	*/
	@Override
	public long getJobStatus() {
		return _simulationJob.getJobStatus();
	}

	/**
	* Sets the job status of this simulation job.
	*
	* @param jobStatus the job status of this simulation job
	*/
	@Override
	public void setJobStatus(long jobStatus) {
		_simulationJob.setJobStatus(jobStatus);
	}

	/**
	* Returns the job start dt of this simulation job.
	*
	* @return the job start dt of this simulation job
	*/
	@Override
	public java.util.Date getJobStartDt() {
		return _simulationJob.getJobStartDt();
	}

	/**
	* Sets the job start dt of this simulation job.
	*
	* @param jobStartDt the job start dt of this simulation job
	*/
	@Override
	public void setJobStartDt(java.util.Date jobStartDt) {
		_simulationJob.setJobStartDt(jobStartDt);
	}

	/**
	* Returns the job end dt of this simulation job.
	*
	* @return the job end dt of this simulation job
	*/
	@Override
	public java.util.Date getJobEndDt() {
		return _simulationJob.getJobEndDt();
	}

	/**
	* Sets the job end dt of this simulation job.
	*
	* @param jobEndDt the job end dt of this simulation job
	*/
	@Override
	public void setJobEndDt(java.util.Date jobEndDt) {
		_simulationJob.setJobEndDt(jobEndDt);
	}

	/**
	* Returns the job title of this simulation job.
	*
	* @return the job title of this simulation job
	*/
	@Override
	public java.lang.String getJobTitle() {
		return _simulationJob.getJobTitle();
	}

	/**
	* Returns the localized job title of this simulation job in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized job title of this simulation job
	*/
	@Override
	public java.lang.String getJobTitle(java.util.Locale locale) {
		return _simulationJob.getJobTitle(locale);
	}

	/**
	* Returns the localized job title of this simulation job in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized job title of this simulation job. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getJobTitle(java.util.Locale locale,
		boolean useDefault) {
		return _simulationJob.getJobTitle(locale, useDefault);
	}

	/**
	* Returns the localized job title of this simulation job in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized job title of this simulation job
	*/
	@Override
	public java.lang.String getJobTitle(java.lang.String languageId) {
		return _simulationJob.getJobTitle(languageId);
	}

	/**
	* Returns the localized job title of this simulation job in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized job title of this simulation job
	*/
	@Override
	public java.lang.String getJobTitle(java.lang.String languageId,
		boolean useDefault) {
		return _simulationJob.getJobTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getJobTitleCurrentLanguageId() {
		return _simulationJob.getJobTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getJobTitleCurrentValue() {
		return _simulationJob.getJobTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized job titles of this simulation job.
	*
	* @return the locales and localized job titles of this simulation job
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getJobTitleMap() {
		return _simulationJob.getJobTitleMap();
	}

	/**
	* Sets the job title of this simulation job.
	*
	* @param jobTitle the job title of this simulation job
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle) {
		_simulationJob.setJobTitle(jobTitle);
	}

	/**
	* Sets the localized job title of this simulation job in the language.
	*
	* @param jobTitle the localized job title of this simulation job
	* @param locale the locale of the language
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle, java.util.Locale locale) {
		_simulationJob.setJobTitle(jobTitle, locale);
	}

	/**
	* Sets the localized job title of this simulation job in the language, and sets the default locale.
	*
	* @param jobTitle the localized job title of this simulation job
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_simulationJob.setJobTitle(jobTitle, locale, defaultLocale);
	}

	@Override
	public void setJobTitleCurrentLanguageId(java.lang.String languageId) {
		_simulationJob.setJobTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized job titles of this simulation job from the map of locales and localized job titles.
	*
	* @param jobTitleMap the locales and localized job titles of this simulation job
	*/
	@Override
	public void setJobTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> jobTitleMap) {
		_simulationJob.setJobTitleMap(jobTitleMap);
	}

	/**
	* Sets the localized job titles of this simulation job from the map of locales and localized job titles, and sets the default locale.
	*
	* @param jobTitleMap the locales and localized job titles of this simulation job
	* @param defaultLocale the default locale
	*/
	@Override
	public void setJobTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> jobTitleMap,
		java.util.Locale defaultLocale) {
		_simulationJob.setJobTitleMap(jobTitleMap, defaultLocale);
	}

	/**
	* Returns the job exec path of this simulation job.
	*
	* @return the job exec path of this simulation job
	*/
	@Override
	public java.lang.String getJobExecPath() {
		return _simulationJob.getJobExecPath();
	}

	/**
	* Returns the localized job exec path of this simulation job in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized job exec path of this simulation job
	*/
	@Override
	public java.lang.String getJobExecPath(java.util.Locale locale) {
		return _simulationJob.getJobExecPath(locale);
	}

	/**
	* Returns the localized job exec path of this simulation job in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized job exec path of this simulation job. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getJobExecPath(java.util.Locale locale,
		boolean useDefault) {
		return _simulationJob.getJobExecPath(locale, useDefault);
	}

	/**
	* Returns the localized job exec path of this simulation job in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized job exec path of this simulation job
	*/
	@Override
	public java.lang.String getJobExecPath(java.lang.String languageId) {
		return _simulationJob.getJobExecPath(languageId);
	}

	/**
	* Returns the localized job exec path of this simulation job in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized job exec path of this simulation job
	*/
	@Override
	public java.lang.String getJobExecPath(java.lang.String languageId,
		boolean useDefault) {
		return _simulationJob.getJobExecPath(languageId, useDefault);
	}

	@Override
	public java.lang.String getJobExecPathCurrentLanguageId() {
		return _simulationJob.getJobExecPathCurrentLanguageId();
	}

	@Override
	public java.lang.String getJobExecPathCurrentValue() {
		return _simulationJob.getJobExecPathCurrentValue();
	}

	/**
	* Returns a map of the locales and localized job exec paths of this simulation job.
	*
	* @return the locales and localized job exec paths of this simulation job
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getJobExecPathMap() {
		return _simulationJob.getJobExecPathMap();
	}

	/**
	* Sets the job exec path of this simulation job.
	*
	* @param jobExecPath the job exec path of this simulation job
	*/
	@Override
	public void setJobExecPath(java.lang.String jobExecPath) {
		_simulationJob.setJobExecPath(jobExecPath);
	}

	/**
	* Sets the localized job exec path of this simulation job in the language.
	*
	* @param jobExecPath the localized job exec path of this simulation job
	* @param locale the locale of the language
	*/
	@Override
	public void setJobExecPath(java.lang.String jobExecPath,
		java.util.Locale locale) {
		_simulationJob.setJobExecPath(jobExecPath, locale);
	}

	/**
	* Sets the localized job exec path of this simulation job in the language, and sets the default locale.
	*
	* @param jobExecPath the localized job exec path of this simulation job
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setJobExecPath(java.lang.String jobExecPath,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_simulationJob.setJobExecPath(jobExecPath, locale, defaultLocale);
	}

	@Override
	public void setJobExecPathCurrentLanguageId(java.lang.String languageId) {
		_simulationJob.setJobExecPathCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized job exec paths of this simulation job from the map of locales and localized job exec paths.
	*
	* @param jobExecPathMap the locales and localized job exec paths of this simulation job
	*/
	@Override
	public void setJobExecPathMap(
		java.util.Map<java.util.Locale, java.lang.String> jobExecPathMap) {
		_simulationJob.setJobExecPathMap(jobExecPathMap);
	}

	/**
	* Sets the localized job exec paths of this simulation job from the map of locales and localized job exec paths, and sets the default locale.
	*
	* @param jobExecPathMap the locales and localized job exec paths of this simulation job
	* @param defaultLocale the default locale
	*/
	@Override
	public void setJobExecPathMap(
		java.util.Map<java.util.Locale, java.lang.String> jobExecPathMap,
		java.util.Locale defaultLocale) {
		_simulationJob.setJobExecPathMap(jobExecPathMap, defaultLocale);
	}

	/**
	* Returns the job phase of this simulation job.
	*
	* @return the job phase of this simulation job
	*/
	@Override
	public long getJobPhase() {
		return _simulationJob.getJobPhase();
	}

	/**
	* Sets the job phase of this simulation job.
	*
	* @param jobPhase the job phase of this simulation job
	*/
	@Override
	public void setJobPhase(long jobPhase) {
		_simulationJob.setJobPhase(jobPhase);
	}

	/**
	* Returns the job submit dt of this simulation job.
	*
	* @return the job submit dt of this simulation job
	*/
	@Override
	public java.util.Date getJobSubmitDt() {
		return _simulationJob.getJobSubmitDt();
	}

	/**
	* Sets the job submit dt of this simulation job.
	*
	* @param jobSubmitDt the job submit dt of this simulation job
	*/
	@Override
	public void setJobSubmitDt(java.util.Date jobSubmitDt) {
		_simulationJob.setJobSubmitDt(jobSubmitDt);
	}

	/**
	* Returns the job post processor of this simulation job.
	*
	* @return the job post processor of this simulation job
	*/
	@Override
	public java.lang.String getJobPostProcessor() {
		return _simulationJob.getJobPostProcessor();
	}

	/**
	* Sets the job post processor of this simulation job.
	*
	* @param jobPostProcessor the job post processor of this simulation job
	*/
	@Override
	public void setJobPostProcessor(java.lang.String jobPostProcessor) {
		_simulationJob.setJobPostProcessor(jobPostProcessor);
	}

	/**
	* Returns the job university field of this simulation job.
	*
	* @return the job university field of this simulation job
	*/
	@Override
	public long getJobUniversityField() {
		return _simulationJob.getJobUniversityField();
	}

	/**
	* Sets the job university field of this simulation job.
	*
	* @param jobUniversityField the job university field of this simulation job
	*/
	@Override
	public void setJobUniversityField(long jobUniversityField) {
		_simulationJob.setJobUniversityField(jobUniversityField);
	}

	/**
	* Returns the job virtual lab ID of this simulation job.
	*
	* @return the job virtual lab ID of this simulation job
	*/
	@Override
	public long getJobVirtualLabId() {
		return _simulationJob.getJobVirtualLabId();
	}

	/**
	* Sets the job virtual lab ID of this simulation job.
	*
	* @param jobVirtualLabId the job virtual lab ID of this simulation job
	*/
	@Override
	public void setJobVirtualLabId(long jobVirtualLabId) {
		_simulationJob.setJobVirtualLabId(jobVirtualLabId);
	}

	/**
	* Returns the job class ID of this simulation job.
	*
	* @return the job class ID of this simulation job
	*/
	@Override
	public long getJobClassId() {
		return _simulationJob.getJobClassId();
	}

	/**
	* Sets the job class ID of this simulation job.
	*
	* @param jobClassId the job class ID of this simulation job
	*/
	@Override
	public void setJobClassId(long jobClassId) {
		_simulationJob.setJobClassId(jobClassId);
	}

	/**
	* Returns the job input deck yn of this simulation job.
	*
	* @return the job input deck yn of this simulation job
	*/
	@Override
	public boolean getJobInputDeckYn() {
		return _simulationJob.getJobInputDeckYn();
	}

	/**
	* Returns <code>true</code> if this simulation job is job input deck yn.
	*
	* @return <code>true</code> if this simulation job is job input deck yn; <code>false</code> otherwise
	*/
	@Override
	public boolean isJobInputDeckYn() {
		return _simulationJob.isJobInputDeckYn();
	}

	/**
	* Sets whether this simulation job is job input deck yn.
	*
	* @param jobInputDeckYn the job input deck yn of this simulation job
	*/
	@Override
	public void setJobInputDeckYn(boolean jobInputDeckYn) {
		_simulationJob.setJobInputDeckYn(jobInputDeckYn);
	}

	/**
	* Returns the job input deck name of this simulation job.
	*
	* @return the job input deck name of this simulation job
	*/
	@Override
	public java.lang.String getJobInputDeckName() {
		return _simulationJob.getJobInputDeckName();
	}

	/**
	* Sets the job input deck name of this simulation job.
	*
	* @param jobInputDeckName the job input deck name of this simulation job
	*/
	@Override
	public void setJobInputDeckName(java.lang.String jobInputDeckName) {
		_simulationJob.setJobInputDeckName(jobInputDeckName);
	}

	/**
	* Returns the result size of this simulation job.
	*
	* @return the result size of this simulation job
	*/
	@Override
	public int getResultSize() {
		return _simulationJob.getResultSize();
	}

	/**
	* Sets the result size of this simulation job.
	*
	* @param resultSize the result size of this simulation job
	*/
	@Override
	public void setResultSize(int resultSize) {
		_simulationJob.setResultSize(resultSize);
	}

	/**
	* Returns the test yn of this simulation job.
	*
	* @return the test yn of this simulation job
	*/
	@Override
	public java.lang.String getTestYn() {
		return _simulationJob.getTestYn();
	}

	/**
	* Sets the test yn of this simulation job.
	*
	* @param testYn the test yn of this simulation job
	*/
	@Override
	public void setTestYn(java.lang.String testYn) {
		_simulationJob.setTestYn(testYn);
	}

	@Override
	public boolean isNew() {
		return _simulationJob.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_simulationJob.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _simulationJob.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_simulationJob.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _simulationJob.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _simulationJob.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_simulationJob.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _simulationJob.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_simulationJob.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_simulationJob.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_simulationJob.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _simulationJob.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _simulationJob.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_simulationJob.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_simulationJob.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new SimulationJobWrapper((SimulationJob)_simulationJob.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.bestsimulation.model.SimulationJob simulationJob) {
		return _simulationJob.compareTo(simulationJob);
	}

	@Override
	public int hashCode() {
		return _simulationJob.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.bestsimulation.model.SimulationJob> toCacheModel() {
		return _simulationJob.toCacheModel();
	}

	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJob toEscapedModel() {
		return new SimulationJobWrapper(_simulationJob.toEscapedModel());
	}

	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJob toUnescapedModel() {
		return new SimulationJobWrapper(_simulationJob.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _simulationJob.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _simulationJob.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_simulationJob.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SimulationJobWrapper)) {
			return false;
		}

		SimulationJobWrapper simulationJobWrapper = (SimulationJobWrapper)obj;

		if (Validator.equals(_simulationJob, simulationJobWrapper._simulationJob)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SimulationJob getWrappedSimulationJob() {
		return _simulationJob;
	}

	@Override
	public SimulationJob getWrappedModel() {
		return _simulationJob;
	}

	@Override
	public void resetOriginalValues() {
		_simulationJob.resetOriginalValues();
	}

	private SimulationJob _simulationJob;
}