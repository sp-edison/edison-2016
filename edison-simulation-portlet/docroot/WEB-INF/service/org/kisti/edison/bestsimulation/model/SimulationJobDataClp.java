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
import org.kisti.edison.bestsimulation.service.SimulationJobDataLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author EDISON
 */
public class SimulationJobDataClp extends BaseModelImpl<SimulationJobData>
	implements SimulationJobData {
	public SimulationJobDataClp() {
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
	public String getPrimaryKey() {
		return _jobUuid;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setJobUuid(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jobUuid;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
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

	@Override
	public String getJobUuid() {
		return _jobUuid;
	}

	@Override
	public void setJobUuid(String jobUuid) {
		_jobUuid = jobUuid;

		if (_simulationJobDataRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobDataRemoteModel.getClass();

				Method method = clazz.getMethod("setJobUuid", String.class);

				method.invoke(_simulationJobDataRemoteModel, jobUuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobData() {
		return _jobData;
	}

	@Override
	public String getJobData(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getJobData(languageId);
	}

	@Override
	public String getJobData(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getJobData(languageId, useDefault);
	}

	@Override
	public String getJobData(String languageId) {
		return LocalizationUtil.getLocalization(getJobData(), languageId);
	}

	@Override
	public String getJobData(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getJobData(), languageId,
			useDefault);
	}

	@Override
	public String getJobDataCurrentLanguageId() {
		return _jobDataCurrentLanguageId;
	}

	@Override
	public String getJobDataCurrentValue() {
		Locale locale = getLocale(_jobDataCurrentLanguageId);

		return getJobData(locale);
	}

	@Override
	public Map<Locale, String> getJobDataMap() {
		return LocalizationUtil.getLocalizationMap(getJobData());
	}

	@Override
	public void setJobData(String jobData) {
		_jobData = jobData;

		if (_simulationJobDataRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobDataRemoteModel.getClass();

				Method method = clazz.getMethod("setJobData", String.class);

				method.invoke(_simulationJobDataRemoteModel, jobData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setJobData(String jobData, Locale locale) {
		setJobData(jobData, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setJobData(String jobData, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(jobData)) {
			setJobData(LocalizationUtil.updateLocalization(getJobData(),
					"JobData", jobData, languageId, defaultLanguageId));
		}
		else {
			setJobData(LocalizationUtil.removeLocalization(getJobData(),
					"JobData", languageId));
		}
	}

	@Override
	public void setJobDataCurrentLanguageId(String languageId) {
		_jobDataCurrentLanguageId = languageId;
	}

	@Override
	public void setJobDataMap(Map<Locale, String> jobDataMap) {
		setJobDataMap(jobDataMap, LocaleUtil.getDefault());
	}

	@Override
	public void setJobDataMap(Map<Locale, String> jobDataMap,
		Locale defaultLocale) {
		if (jobDataMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setJobData(LocalizationUtil.updateLocalization(jobDataMap,
					getJobData(), "JobData",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	public BaseModel<?> getSimulationJobDataRemoteModel() {
		return _simulationJobDataRemoteModel;
	}

	public void setSimulationJobDataRemoteModel(
		BaseModel<?> simulationJobDataRemoteModel) {
		_simulationJobDataRemoteModel = simulationJobDataRemoteModel;
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

		Class<?> remoteModelClass = _simulationJobDataRemoteModel.getClass();

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

		Object returnValue = method.invoke(_simulationJobDataRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SimulationJobDataLocalServiceUtil.addSimulationJobData(this);
		}
		else {
			SimulationJobDataLocalServiceUtil.updateSimulationJobData(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> jobDataMap = getJobDataMap();

		for (Map.Entry<Locale, String> entry : jobDataMap.entrySet()) {
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
		String xml = getJobData();

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

		String jobData = getJobData(defaultLocale);

		if (Validator.isNull(jobData)) {
			setJobData(getJobData(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setJobData(getJobData(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public SimulationJobData toEscapedModel() {
		return (SimulationJobData)ProxyUtil.newProxyInstance(SimulationJobData.class.getClassLoader(),
			new Class[] { SimulationJobData.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SimulationJobDataClp clone = new SimulationJobDataClp();

		clone.setJobUuid(getJobUuid());
		clone.setJobData(getJobData());

		return clone;
	}

	@Override
	public int compareTo(SimulationJobData simulationJobData) {
		String primaryKey = simulationJobData.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SimulationJobDataClp)) {
			return false;
		}

		SimulationJobDataClp simulationJobData = (SimulationJobDataClp)obj;

		String primaryKey = simulationJobData.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{jobUuid=");
		sb.append(getJobUuid());
		sb.append(", jobData=");
		sb.append(getJobData());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.bestsimulation.model.SimulationJobData");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jobUuid</column-name><column-value><![CDATA[");
		sb.append(getJobUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobData</column-name><column-value><![CDATA[");
		sb.append(getJobData());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _jobUuid;
	private String _jobData;
	private String _jobDataCurrentLanguageId;
	private BaseModel<?> _simulationJobDataRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.bestsimulation.service.ClpSerializer.class;
}