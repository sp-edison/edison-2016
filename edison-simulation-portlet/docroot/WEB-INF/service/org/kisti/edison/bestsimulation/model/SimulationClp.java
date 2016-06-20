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

import org.kisti.edison.bestsimulation.service.ClpSerializer;
import org.kisti.edison.bestsimulation.service.SimulationLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.persistence.SimulationPK;

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
public class SimulationClp extends BaseModelImpl<Simulation>
	implements Simulation {
	public SimulationClp() {
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
	public SimulationPK getPrimaryKey() {
		return new SimulationPK(_simulationUuid, _groupId);
	}

	@Override
	public void setPrimaryKey(SimulationPK primaryKey) {
		setSimulationUuid(primaryKey.simulationUuid);
		setGroupId(primaryKey.groupId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new SimulationPK(_simulationUuid, _groupId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((SimulationPK)primaryKeyObj);
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

	@Override
	public String getSimulationUuid() {
		return _simulationUuid;
	}

	@Override
	public void setSimulationUuid(String simulationUuid) {
		_simulationUuid = simulationUuid;

		if (_simulationRemoteModel != null) {
			try {
				Class<?> clazz = _simulationRemoteModel.getClass();

				Method method = clazz.getMethod("setSimulationUuid",
						String.class);

				method.invoke(_simulationRemoteModel, simulationUuid);
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

		if (_simulationRemoteModel != null) {
			try {
				Class<?> clazz = _simulationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_simulationRemoteModel, groupId);
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

		if (_simulationRemoteModel != null) {
			try {
				Class<?> clazz = _simulationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_simulationRemoteModel, userId);
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
	public String getSimulationTitle() {
		return _simulationTitle;
	}

	@Override
	public String getSimulationTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSimulationTitle(languageId);
	}

	@Override
	public String getSimulationTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSimulationTitle(languageId, useDefault);
	}

	@Override
	public String getSimulationTitle(String languageId) {
		return LocalizationUtil.getLocalization(getSimulationTitle(), languageId);
	}

	@Override
	public String getSimulationTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getSimulationTitle(),
			languageId, useDefault);
	}

	@Override
	public String getSimulationTitleCurrentLanguageId() {
		return _simulationTitleCurrentLanguageId;
	}

	@Override
	public String getSimulationTitleCurrentValue() {
		Locale locale = getLocale(_simulationTitleCurrentLanguageId);

		return getSimulationTitle(locale);
	}

	@Override
	public Map<Locale, String> getSimulationTitleMap() {
		return LocalizationUtil.getLocalizationMap(getSimulationTitle());
	}

	@Override
	public void setSimulationTitle(String simulationTitle) {
		_simulationTitle = simulationTitle;

		if (_simulationRemoteModel != null) {
			try {
				Class<?> clazz = _simulationRemoteModel.getClass();

				Method method = clazz.getMethod("setSimulationTitle",
						String.class);

				method.invoke(_simulationRemoteModel, simulationTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setSimulationTitle(String simulationTitle, Locale locale) {
		setSimulationTitle(simulationTitle, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setSimulationTitle(String simulationTitle, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(simulationTitle)) {
			setSimulationTitle(LocalizationUtil.updateLocalization(
					getSimulationTitle(), "SimulationTitle", simulationTitle,
					languageId, defaultLanguageId));
		}
		else {
			setSimulationTitle(LocalizationUtil.removeLocalization(
					getSimulationTitle(), "SimulationTitle", languageId));
		}
	}

	@Override
	public void setSimulationTitleCurrentLanguageId(String languageId) {
		_simulationTitleCurrentLanguageId = languageId;
	}

	@Override
	public void setSimulationTitleMap(Map<Locale, String> simulationTitleMap) {
		setSimulationTitleMap(simulationTitleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setSimulationTitleMap(Map<Locale, String> simulationTitleMap,
		Locale defaultLocale) {
		if (simulationTitleMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setSimulationTitle(LocalizationUtil.updateLocalization(
					simulationTitleMap, getSimulationTitle(),
					"SimulationTitle", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getSimulationDescription() {
		return _simulationDescription;
	}

	@Override
	public String getSimulationDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSimulationDescription(languageId);
	}

	@Override
	public String getSimulationDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getSimulationDescription(languageId, useDefault);
	}

	@Override
	public String getSimulationDescription(String languageId) {
		return LocalizationUtil.getLocalization(getSimulationDescription(),
			languageId);
	}

	@Override
	public String getSimulationDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getSimulationDescription(),
			languageId, useDefault);
	}

	@Override
	public String getSimulationDescriptionCurrentLanguageId() {
		return _simulationDescriptionCurrentLanguageId;
	}

	@Override
	public String getSimulationDescriptionCurrentValue() {
		Locale locale = getLocale(_simulationDescriptionCurrentLanguageId);

		return getSimulationDescription(locale);
	}

	@Override
	public Map<Locale, String> getSimulationDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getSimulationDescription());
	}

	@Override
	public void setSimulationDescription(String simulationDescription) {
		_simulationDescription = simulationDescription;

		if (_simulationRemoteModel != null) {
			try {
				Class<?> clazz = _simulationRemoteModel.getClass();

				Method method = clazz.getMethod("setSimulationDescription",
						String.class);

				method.invoke(_simulationRemoteModel, simulationDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setSimulationDescription(String simulationDescription,
		Locale locale) {
		setSimulationDescription(simulationDescription, locale,
			LocaleUtil.getDefault());
	}

	@Override
	public void setSimulationDescription(String simulationDescription,
		Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(simulationDescription)) {
			setSimulationDescription(LocalizationUtil.updateLocalization(
					getSimulationDescription(), "SimulationDescription",
					simulationDescription, languageId, defaultLanguageId));
		}
		else {
			setSimulationDescription(LocalizationUtil.removeLocalization(
					getSimulationDescription(), "SimulationDescription",
					languageId));
		}
	}

	@Override
	public void setSimulationDescriptionCurrentLanguageId(String languageId) {
		_simulationDescriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setSimulationDescriptionMap(
		Map<Locale, String> simulationDescriptionMap) {
		setSimulationDescriptionMap(simulationDescriptionMap,
			LocaleUtil.getDefault());
	}

	@Override
	public void setSimulationDescriptionMap(
		Map<Locale, String> simulationDescriptionMap, Locale defaultLocale) {
		if (simulationDescriptionMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setSimulationDescription(LocalizationUtil.updateLocalization(
					simulationDescriptionMap, getSimulationDescription(),
					"SimulationDescription",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getScienceAppId() {
		return _scienceAppId;
	}

	@Override
	public void setScienceAppId(String scienceAppId) {
		_scienceAppId = scienceAppId;

		if (_simulationRemoteModel != null) {
			try {
				Class<?> clazz = _simulationRemoteModel.getClass();

				Method method = clazz.getMethod("setScienceAppId", String.class);

				method.invoke(_simulationRemoteModel, scienceAppId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getScienceAppName() {
		return _scienceAppName;
	}

	@Override
	public String getScienceAppName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getScienceAppName(languageId);
	}

	@Override
	public String getScienceAppName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getScienceAppName(languageId, useDefault);
	}

	@Override
	public String getScienceAppName(String languageId) {
		return LocalizationUtil.getLocalization(getScienceAppName(), languageId);
	}

	@Override
	public String getScienceAppName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getScienceAppName(),
			languageId, useDefault);
	}

	@Override
	public String getScienceAppNameCurrentLanguageId() {
		return _scienceAppNameCurrentLanguageId;
	}

	@Override
	public String getScienceAppNameCurrentValue() {
		Locale locale = getLocale(_scienceAppNameCurrentLanguageId);

		return getScienceAppName(locale);
	}

	@Override
	public Map<Locale, String> getScienceAppNameMap() {
		return LocalizationUtil.getLocalizationMap(getScienceAppName());
	}

	@Override
	public void setScienceAppName(String scienceAppName) {
		_scienceAppName = scienceAppName;

		if (_simulationRemoteModel != null) {
			try {
				Class<?> clazz = _simulationRemoteModel.getClass();

				Method method = clazz.getMethod("setScienceAppName",
						String.class);

				method.invoke(_simulationRemoteModel, scienceAppName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setScienceAppName(String scienceAppName, Locale locale) {
		setScienceAppName(scienceAppName, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setScienceAppName(String scienceAppName, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(scienceAppName)) {
			setScienceAppName(LocalizationUtil.updateLocalization(
					getScienceAppName(), "ScienceAppName", scienceAppName,
					languageId, defaultLanguageId));
		}
		else {
			setScienceAppName(LocalizationUtil.removeLocalization(
					getScienceAppName(), "ScienceAppName", languageId));
		}
	}

	@Override
	public void setScienceAppNameCurrentLanguageId(String languageId) {
		_scienceAppNameCurrentLanguageId = languageId;
	}

	@Override
	public void setScienceAppNameMap(Map<Locale, String> scienceAppNameMap) {
		setScienceAppNameMap(scienceAppNameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setScienceAppNameMap(Map<Locale, String> scienceAppNameMap,
		Locale defaultLocale) {
		if (scienceAppNameMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setScienceAppName(LocalizationUtil.updateLocalization(
					scienceAppNameMap, getScienceAppName(), "ScienceAppName",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public Date getSimulationCreateDt() {
		return _simulationCreateDt;
	}

	@Override
	public void setSimulationCreateDt(Date simulationCreateDt) {
		_simulationCreateDt = simulationCreateDt;

		if (_simulationRemoteModel != null) {
			try {
				Class<?> clazz = _simulationRemoteModel.getClass();

				Method method = clazz.getMethod("setSimulationCreateDt",
						Date.class);

				method.invoke(_simulationRemoteModel, simulationCreateDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCluster() {
		return _cluster;
	}

	@Override
	public void setCluster(String cluster) {
		_cluster = cluster;

		if (_simulationRemoteModel != null) {
			try {
				Class<?> clazz = _simulationRemoteModel.getClass();

				Method method = clazz.getMethod("setCluster", String.class);

				method.invoke(_simulationRemoteModel, cluster);
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

		if (_simulationRemoteModel != null) {
			try {
				Class<?> clazz = _simulationRemoteModel.getClass();

				Method method = clazz.getMethod("setTestYn", String.class);

				method.invoke(_simulationRemoteModel, testYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSimulationRemoteModel() {
		return _simulationRemoteModel;
	}

	public void setSimulationRemoteModel(BaseModel<?> simulationRemoteModel) {
		_simulationRemoteModel = simulationRemoteModel;
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

		Class<?> remoteModelClass = _simulationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_simulationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SimulationLocalServiceUtil.addSimulation(this);
		}
		else {
			SimulationLocalServiceUtil.updateSimulation(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> simulationTitleMap = getSimulationTitleMap();

		for (Map.Entry<Locale, String> entry : simulationTitleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> simulationDescriptionMap = getSimulationDescriptionMap();

		for (Map.Entry<Locale, String> entry : simulationDescriptionMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> scienceAppNameMap = getScienceAppNameMap();

		for (Map.Entry<Locale, String> entry : scienceAppNameMap.entrySet()) {
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
		String xml = getSimulationTitle();

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

		String simulationTitle = getSimulationTitle(defaultLocale);

		if (Validator.isNull(simulationTitle)) {
			setSimulationTitle(getSimulationTitle(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setSimulationTitle(getSimulationTitle(defaultLocale),
				defaultLocale, defaultLocale);
		}

		String simulationDescription = getSimulationDescription(defaultLocale);

		if (Validator.isNull(simulationDescription)) {
			setSimulationDescription(getSimulationDescription(
					modelDefaultLanguageId), defaultLocale);
		}
		else {
			setSimulationDescription(getSimulationDescription(defaultLocale),
				defaultLocale, defaultLocale);
		}

		String scienceAppName = getScienceAppName(defaultLocale);

		if (Validator.isNull(scienceAppName)) {
			setScienceAppName(getScienceAppName(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setScienceAppName(getScienceAppName(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public Simulation toEscapedModel() {
		return (Simulation)ProxyUtil.newProxyInstance(Simulation.class.getClassLoader(),
			new Class[] { Simulation.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SimulationClp clone = new SimulationClp();

		clone.setSimulationUuid(getSimulationUuid());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setSimulationTitle(getSimulationTitle());
		clone.setSimulationDescription(getSimulationDescription());
		clone.setScienceAppId(getScienceAppId());
		clone.setScienceAppName(getScienceAppName());
		clone.setSimulationCreateDt(getSimulationCreateDt());
		clone.setCluster(getCluster());
		clone.setTestYn(getTestYn());

		return clone;
	}

	@Override
	public int compareTo(Simulation simulation) {
		int value = 0;

		value = DateUtil.compareTo(getSimulationCreateDt(),
				simulation.getSimulationCreateDt());

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

		if (!(obj instanceof SimulationClp)) {
			return false;
		}

		SimulationClp simulation = (SimulationClp)obj;

		SimulationPK primaryKey = simulation.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{simulationUuid=");
		sb.append(getSimulationUuid());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", simulationTitle=");
		sb.append(getSimulationTitle());
		sb.append(", simulationDescription=");
		sb.append(getSimulationDescription());
		sb.append(", scienceAppId=");
		sb.append(getScienceAppId());
		sb.append(", scienceAppName=");
		sb.append(getScienceAppName());
		sb.append(", simulationCreateDt=");
		sb.append(getSimulationCreateDt());
		sb.append(", cluster=");
		sb.append(getCluster());
		sb.append(", testYn=");
		sb.append(getTestYn());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.bestsimulation.model.Simulation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>simulationUuid</column-name><column-value><![CDATA[");
		sb.append(getSimulationUuid());
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
			"<column><column-name>simulationTitle</column-name><column-value><![CDATA[");
		sb.append(getSimulationTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>simulationDescription</column-name><column-value><![CDATA[");
		sb.append(getSimulationDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scienceAppId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scienceAppName</column-name><column-value><![CDATA[");
		sb.append(getScienceAppName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>simulationCreateDt</column-name><column-value><![CDATA[");
		sb.append(getSimulationCreateDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cluster</column-name><column-value><![CDATA[");
		sb.append(getCluster());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>testYn</column-name><column-value><![CDATA[");
		sb.append(getTestYn());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _simulationUuid;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private String _simulationTitle;
	private String _simulationTitleCurrentLanguageId;
	private String _simulationDescription;
	private String _simulationDescriptionCurrentLanguageId;
	private String _scienceAppId;
	private String _scienceAppName;
	private String _scienceAppNameCurrentLanguageId;
	private Date _simulationCreateDt;
	private String _cluster;
	private String _testYn;
	private BaseModel<?> _simulationRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.bestsimulation.service.ClpSerializer.class;
}