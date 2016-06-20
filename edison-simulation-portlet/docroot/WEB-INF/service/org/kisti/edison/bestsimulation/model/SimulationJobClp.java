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

import org.kisti.edison.bestsimulation.service.ClpSerializer;
import org.kisti.edison.bestsimulation.service.SimulationJobLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK;

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
public class SimulationJobClp extends BaseModelImpl<SimulationJob>
	implements SimulationJob {
	public SimulationJobClp() {
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
	public SimulationJobPK getPrimaryKey() {
		return new SimulationJobPK(_jobSeqNo, _simulationUuid, _groupId);
	}

	@Override
	public void setPrimaryKey(SimulationJobPK primaryKey) {
		setJobSeqNo(primaryKey.jobSeqNo);
		setSimulationUuid(primaryKey.simulationUuid);
		setGroupId(primaryKey.groupId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new SimulationJobPK(_jobSeqNo, _simulationUuid, _groupId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((SimulationJobPK)primaryKeyObj);
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

	@Override
	public long getJobSeqNo() {
		return _jobSeqNo;
	}

	@Override
	public void setJobSeqNo(long jobSeqNo) {
		_jobSeqNo = jobSeqNo;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobSeqNo", long.class);

				method.invoke(_simulationJobRemoteModel, jobSeqNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSimulationUuid() {
		return _simulationUuid;
	}

	@Override
	public void setSimulationUuid(String simulationUuid) {
		_simulationUuid = simulationUuid;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setSimulationUuid",
						String.class);

				method.invoke(_simulationJobRemoteModel, simulationUuid);
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

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_simulationJobRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobUuid() {
		return _jobUuid;
	}

	@Override
	public void setJobUuid(String jobUuid) {
		_jobUuid = jobUuid;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobUuid", String.class);

				method.invoke(_simulationJobRemoteModel, jobUuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobStatus() {
		return _jobStatus;
	}

	@Override
	public void setJobStatus(long jobStatus) {
		_jobStatus = jobStatus;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobStatus", long.class);

				method.invoke(_simulationJobRemoteModel, jobStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getJobStartDt() {
		return _jobStartDt;
	}

	@Override
	public void setJobStartDt(Date jobStartDt) {
		_jobStartDt = jobStartDt;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobStartDt", Date.class);

				method.invoke(_simulationJobRemoteModel, jobStartDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getJobEndDt() {
		return _jobEndDt;
	}

	@Override
	public void setJobEndDt(Date jobEndDt) {
		_jobEndDt = jobEndDt;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobEndDt", Date.class);

				method.invoke(_simulationJobRemoteModel, jobEndDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobTitle() {
		return _jobTitle;
	}

	@Override
	public String getJobTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getJobTitle(languageId);
	}

	@Override
	public String getJobTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getJobTitle(languageId, useDefault);
	}

	@Override
	public String getJobTitle(String languageId) {
		return LocalizationUtil.getLocalization(getJobTitle(), languageId);
	}

	@Override
	public String getJobTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getJobTitle(), languageId,
			useDefault);
	}

	@Override
	public String getJobTitleCurrentLanguageId() {
		return _jobTitleCurrentLanguageId;
	}

	@Override
	public String getJobTitleCurrentValue() {
		Locale locale = getLocale(_jobTitleCurrentLanguageId);

		return getJobTitle(locale);
	}

	@Override
	public Map<Locale, String> getJobTitleMap() {
		return LocalizationUtil.getLocalizationMap(getJobTitle());
	}

	@Override
	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobTitle", String.class);

				method.invoke(_simulationJobRemoteModel, jobTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setJobTitle(String jobTitle, Locale locale) {
		setJobTitle(jobTitle, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setJobTitle(String jobTitle, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(jobTitle)) {
			setJobTitle(LocalizationUtil.updateLocalization(getJobTitle(),
					"JobTitle", jobTitle, languageId, defaultLanguageId));
		}
		else {
			setJobTitle(LocalizationUtil.removeLocalization(getJobTitle(),
					"JobTitle", languageId));
		}
	}

	@Override
	public void setJobTitleCurrentLanguageId(String languageId) {
		_jobTitleCurrentLanguageId = languageId;
	}

	@Override
	public void setJobTitleMap(Map<Locale, String> jobTitleMap) {
		setJobTitleMap(jobTitleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setJobTitleMap(Map<Locale, String> jobTitleMap,
		Locale defaultLocale) {
		if (jobTitleMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setJobTitle(LocalizationUtil.updateLocalization(jobTitleMap,
					getJobTitle(), "JobTitle",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getJobExecPath() {
		return _jobExecPath;
	}

	@Override
	public String getJobExecPath(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getJobExecPath(languageId);
	}

	@Override
	public String getJobExecPath(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getJobExecPath(languageId, useDefault);
	}

	@Override
	public String getJobExecPath(String languageId) {
		return LocalizationUtil.getLocalization(getJobExecPath(), languageId);
	}

	@Override
	public String getJobExecPath(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getJobExecPath(), languageId,
			useDefault);
	}

	@Override
	public String getJobExecPathCurrentLanguageId() {
		return _jobExecPathCurrentLanguageId;
	}

	@Override
	public String getJobExecPathCurrentValue() {
		Locale locale = getLocale(_jobExecPathCurrentLanguageId);

		return getJobExecPath(locale);
	}

	@Override
	public Map<Locale, String> getJobExecPathMap() {
		return LocalizationUtil.getLocalizationMap(getJobExecPath());
	}

	@Override
	public void setJobExecPath(String jobExecPath) {
		_jobExecPath = jobExecPath;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobExecPath", String.class);

				method.invoke(_simulationJobRemoteModel, jobExecPath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setJobExecPath(String jobExecPath, Locale locale) {
		setJobExecPath(jobExecPath, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setJobExecPath(String jobExecPath, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(jobExecPath)) {
			setJobExecPath(LocalizationUtil.updateLocalization(
					getJobExecPath(), "JobExecPath", jobExecPath, languageId,
					defaultLanguageId));
		}
		else {
			setJobExecPath(LocalizationUtil.removeLocalization(
					getJobExecPath(), "JobExecPath", languageId));
		}
	}

	@Override
	public void setJobExecPathCurrentLanguageId(String languageId) {
		_jobExecPathCurrentLanguageId = languageId;
	}

	@Override
	public void setJobExecPathMap(Map<Locale, String> jobExecPathMap) {
		setJobExecPathMap(jobExecPathMap, LocaleUtil.getDefault());
	}

	@Override
	public void setJobExecPathMap(Map<Locale, String> jobExecPathMap,
		Locale defaultLocale) {
		if (jobExecPathMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setJobExecPath(LocalizationUtil.updateLocalization(jobExecPathMap,
					getJobExecPath(), "JobExecPath",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public long getJobPhase() {
		return _jobPhase;
	}

	@Override
	public void setJobPhase(long jobPhase) {
		_jobPhase = jobPhase;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobPhase", long.class);

				method.invoke(_simulationJobRemoteModel, jobPhase);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getJobSubmitDt() {
		return _jobSubmitDt;
	}

	@Override
	public void setJobSubmitDt(Date jobSubmitDt) {
		_jobSubmitDt = jobSubmitDt;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobSubmitDt", Date.class);

				method.invoke(_simulationJobRemoteModel, jobSubmitDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobPostProcessor() {
		return _jobPostProcessor;
	}

	@Override
	public void setJobPostProcessor(String jobPostProcessor) {
		_jobPostProcessor = jobPostProcessor;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobPostProcessor",
						String.class);

				method.invoke(_simulationJobRemoteModel, jobPostProcessor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobUniversityField() {
		return _jobUniversityField;
	}

	@Override
	public void setJobUniversityField(long jobUniversityField) {
		_jobUniversityField = jobUniversityField;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobUniversityField",
						long.class);

				method.invoke(_simulationJobRemoteModel, jobUniversityField);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobVirtualLabId() {
		return _jobVirtualLabId;
	}

	@Override
	public void setJobVirtualLabId(long jobVirtualLabId) {
		_jobVirtualLabId = jobVirtualLabId;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobVirtualLabId", long.class);

				method.invoke(_simulationJobRemoteModel, jobVirtualLabId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobClassId() {
		return _jobClassId;
	}

	@Override
	public void setJobClassId(long jobClassId) {
		_jobClassId = jobClassId;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobClassId", long.class);

				method.invoke(_simulationJobRemoteModel, jobClassId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getJobInputDeckYn() {
		return _jobInputDeckYn;
	}

	@Override
	public boolean isJobInputDeckYn() {
		return _jobInputDeckYn;
	}

	@Override
	public void setJobInputDeckYn(boolean jobInputDeckYn) {
		_jobInputDeckYn = jobInputDeckYn;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobInputDeckYn",
						boolean.class);

				method.invoke(_simulationJobRemoteModel, jobInputDeckYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobInputDeckName() {
		return _jobInputDeckName;
	}

	@Override
	public void setJobInputDeckName(String jobInputDeckName) {
		_jobInputDeckName = jobInputDeckName;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setJobInputDeckName",
						String.class);

				method.invoke(_simulationJobRemoteModel, jobInputDeckName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getResultSize() {
		return _resultSize;
	}

	@Override
	public void setResultSize(int resultSize) {
		_resultSize = resultSize;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setResultSize", int.class);

				method.invoke(_simulationJobRemoteModel, resultSize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTestYn() {
		return _testYn;
	}

	@Override
	public void setTestYn(String testYn) {
		_testYn = testYn;

		if (_simulationJobRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobRemoteModel.getClass();

				Method method = clazz.getMethod("setTestYn", String.class);

				method.invoke(_simulationJobRemoteModel, testYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSimulationJobRemoteModel() {
		return _simulationJobRemoteModel;
	}

	public void setSimulationJobRemoteModel(
		BaseModel<?> simulationJobRemoteModel) {
		_simulationJobRemoteModel = simulationJobRemoteModel;
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

		Class<?> remoteModelClass = _simulationJobRemoteModel.getClass();

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

		Object returnValue = method.invoke(_simulationJobRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SimulationJobLocalServiceUtil.addSimulationJob(this);
		}
		else {
			SimulationJobLocalServiceUtil.updateSimulationJob(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> jobTitleMap = getJobTitleMap();

		for (Map.Entry<Locale, String> entry : jobTitleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> jobExecPathMap = getJobExecPathMap();

		for (Map.Entry<Locale, String> entry : jobExecPathMap.entrySet()) {
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
		String xml = getJobTitle();

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

		String jobTitle = getJobTitle(defaultLocale);

		if (Validator.isNull(jobTitle)) {
			setJobTitle(getJobTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setJobTitle(getJobTitle(defaultLocale), defaultLocale, defaultLocale);
		}

		String jobExecPath = getJobExecPath(defaultLocale);

		if (Validator.isNull(jobExecPath)) {
			setJobExecPath(getJobExecPath(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setJobExecPath(getJobExecPath(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public SimulationJob toEscapedModel() {
		return (SimulationJob)ProxyUtil.newProxyInstance(SimulationJob.class.getClassLoader(),
			new Class[] { SimulationJob.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SimulationJobClp clone = new SimulationJobClp();

		clone.setJobSeqNo(getJobSeqNo());
		clone.setSimulationUuid(getSimulationUuid());
		clone.setGroupId(getGroupId());
		clone.setJobUuid(getJobUuid());
		clone.setJobStatus(getJobStatus());
		clone.setJobStartDt(getJobStartDt());
		clone.setJobEndDt(getJobEndDt());
		clone.setJobTitle(getJobTitle());
		clone.setJobExecPath(getJobExecPath());
		clone.setJobPhase(getJobPhase());
		clone.setJobSubmitDt(getJobSubmitDt());
		clone.setJobPostProcessor(getJobPostProcessor());
		clone.setJobUniversityField(getJobUniversityField());
		clone.setJobVirtualLabId(getJobVirtualLabId());
		clone.setJobClassId(getJobClassId());
		clone.setJobInputDeckYn(getJobInputDeckYn());
		clone.setJobInputDeckName(getJobInputDeckName());
		clone.setResultSize(getResultSize());
		clone.setTestYn(getTestYn());

		return clone;
	}

	@Override
	public int compareTo(SimulationJob simulationJob) {
		int value = 0;

		if (getJobStatus() < simulationJob.getJobStatus()) {
			value = -1;
		}
		else if (getJobStatus() > simulationJob.getJobStatus()) {
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

		if (!(obj instanceof SimulationJobClp)) {
			return false;
		}

		SimulationJobClp simulationJob = (SimulationJobClp)obj;

		SimulationJobPK primaryKey = simulationJob.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{jobSeqNo=");
		sb.append(getJobSeqNo());
		sb.append(", simulationUuid=");
		sb.append(getSimulationUuid());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", jobUuid=");
		sb.append(getJobUuid());
		sb.append(", jobStatus=");
		sb.append(getJobStatus());
		sb.append(", jobStartDt=");
		sb.append(getJobStartDt());
		sb.append(", jobEndDt=");
		sb.append(getJobEndDt());
		sb.append(", jobTitle=");
		sb.append(getJobTitle());
		sb.append(", jobExecPath=");
		sb.append(getJobExecPath());
		sb.append(", jobPhase=");
		sb.append(getJobPhase());
		sb.append(", jobSubmitDt=");
		sb.append(getJobSubmitDt());
		sb.append(", jobPostProcessor=");
		sb.append(getJobPostProcessor());
		sb.append(", jobUniversityField=");
		sb.append(getJobUniversityField());
		sb.append(", jobVirtualLabId=");
		sb.append(getJobVirtualLabId());
		sb.append(", jobClassId=");
		sb.append(getJobClassId());
		sb.append(", jobInputDeckYn=");
		sb.append(getJobInputDeckYn());
		sb.append(", jobInputDeckName=");
		sb.append(getJobInputDeckName());
		sb.append(", resultSize=");
		sb.append(getResultSize());
		sb.append(", testYn=");
		sb.append(getTestYn());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.bestsimulation.model.SimulationJob");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jobSeqNo</column-name><column-value><![CDATA[");
		sb.append(getJobSeqNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>simulationUuid</column-name><column-value><![CDATA[");
		sb.append(getSimulationUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobUuid</column-name><column-value><![CDATA[");
		sb.append(getJobUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobStatus</column-name><column-value><![CDATA[");
		sb.append(getJobStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobStartDt</column-name><column-value><![CDATA[");
		sb.append(getJobStartDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobEndDt</column-name><column-value><![CDATA[");
		sb.append(getJobEndDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobTitle</column-name><column-value><![CDATA[");
		sb.append(getJobTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobExecPath</column-name><column-value><![CDATA[");
		sb.append(getJobExecPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobPhase</column-name><column-value><![CDATA[");
		sb.append(getJobPhase());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobSubmitDt</column-name><column-value><![CDATA[");
		sb.append(getJobSubmitDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobPostProcessor</column-name><column-value><![CDATA[");
		sb.append(getJobPostProcessor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobUniversityField</column-name><column-value><![CDATA[");
		sb.append(getJobUniversityField());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobVirtualLabId</column-name><column-value><![CDATA[");
		sb.append(getJobVirtualLabId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobClassId</column-name><column-value><![CDATA[");
		sb.append(getJobClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobInputDeckYn</column-name><column-value><![CDATA[");
		sb.append(getJobInputDeckYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobInputDeckName</column-name><column-value><![CDATA[");
		sb.append(getJobInputDeckName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resultSize</column-name><column-value><![CDATA[");
		sb.append(getResultSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>testYn</column-name><column-value><![CDATA[");
		sb.append(getTestYn());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _jobSeqNo;
	private String _simulationUuid;
	private long _groupId;
	private String _jobUuid;
	private long _jobStatus;
	private Date _jobStartDt;
	private Date _jobEndDt;
	private String _jobTitle;
	private String _jobTitleCurrentLanguageId;
	private String _jobExecPath;
	private String _jobExecPathCurrentLanguageId;
	private long _jobPhase;
	private Date _jobSubmitDt;
	private String _jobPostProcessor;
	private long _jobUniversityField;
	private long _jobVirtualLabId;
	private long _jobClassId;
	private boolean _jobInputDeckYn;
	private String _jobInputDeckName;
	private int _resultSize;
	private String _testYn;
	private BaseModel<?> _simulationJobRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.bestsimulation.service.ClpSerializer.class;
}