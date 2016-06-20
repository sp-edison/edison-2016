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
import com.liferay.portal.kernel.lar.StagedModelType;
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
import org.kisti.edison.science.service.ScienceAppLocalServiceUtil;

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
public class ScienceAppClp extends BaseModelImpl<ScienceApp>
	implements ScienceApp {
	public ScienceAppClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ScienceApp.class;
	}

	@Override
	public String getModelClassName() {
		return ScienceApp.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _scienceAppId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScienceAppId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scienceAppId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("version", getVersion());
		attributes.put("title", getTitle());
		attributes.put("descriptionId", getDescriptionId());
		attributes.put("previousVersionId", getPreviousVersionId());
		attributes.put("iconId", getIconId());
		attributes.put("manualId", getManualId());
		attributes.put("exeFileName", getExeFileName());
		attributes.put("appType", getAppType());
		attributes.put("runType", getRunType());
		attributes.put("authorId", getAuthorId());
		attributes.put("stage", getStage());
		attributes.put("status", getStatus());
		attributes.put("recentModifierId", getRecentModifierId());
		attributes.put("parallelModule", getParallelModule());
		attributes.put("maxCpus", getMaxCpus());
		attributes.put("defaultCpus", getDefaultCpus());
		attributes.put("statusDate", getStatusDate());
		attributes.put("openLevel", getOpenLevel());
		attributes.put("license", getLicense());
		attributes.put("srcFileName", getSrcFileName());
		attributes.put("targetLanguage", getTargetLanguage());
		attributes.put("developers", getDevelopers());
		attributes.put("editorType", getEditorType());
		attributes.put("swTest", getSwTest());
		attributes.put("projectCategoryId", getProjectCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Long descriptionId = (Long)attributes.get("descriptionId");

		if (descriptionId != null) {
			setDescriptionId(descriptionId);
		}

		Long previousVersionId = (Long)attributes.get("previousVersionId");

		if (previousVersionId != null) {
			setPreviousVersionId(previousVersionId);
		}

		Long iconId = (Long)attributes.get("iconId");

		if (iconId != null) {
			setIconId(iconId);
		}

		String manualId = (String)attributes.get("manualId");

		if (manualId != null) {
			setManualId(manualId);
		}

		String exeFileName = (String)attributes.get("exeFileName");

		if (exeFileName != null) {
			setExeFileName(exeFileName);
		}

		String appType = (String)attributes.get("appType");

		if (appType != null) {
			setAppType(appType);
		}

		String runType = (String)attributes.get("runType");

		if (runType != null) {
			setRunType(runType);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		String stage = (String)attributes.get("stage");

		if (stage != null) {
			setStage(stage);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long recentModifierId = (Long)attributes.get("recentModifierId");

		if (recentModifierId != null) {
			setRecentModifierId(recentModifierId);
		}

		String parallelModule = (String)attributes.get("parallelModule");

		if (parallelModule != null) {
			setParallelModule(parallelModule);
		}

		Integer maxCpus = (Integer)attributes.get("maxCpus");

		if (maxCpus != null) {
			setMaxCpus(maxCpus);
		}

		Integer defaultCpus = (Integer)attributes.get("defaultCpus");

		if (defaultCpus != null) {
			setDefaultCpus(defaultCpus);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String openLevel = (String)attributes.get("openLevel");

		if (openLevel != null) {
			setOpenLevel(openLevel);
		}

		String license = (String)attributes.get("license");

		if (license != null) {
			setLicense(license);
		}

		String srcFileName = (String)attributes.get("srcFileName");

		if (srcFileName != null) {
			setSrcFileName(srcFileName);
		}

		String targetLanguage = (String)attributes.get("targetLanguage");

		if (targetLanguage != null) {
			setTargetLanguage(targetLanguage);
		}

		String developers = (String)attributes.get("developers");

		if (developers != null) {
			setDevelopers(developers);
		}

		String editorType = (String)attributes.get("editorType");

		if (editorType != null) {
			setEditorType(editorType);
		}

		Boolean swTest = (Boolean)attributes.get("swTest");

		if (swTest != null) {
			setSwTest(swTest);
		}

		Long projectCategoryId = (Long)attributes.get("projectCategoryId");

		if (projectCategoryId != null) {
			setProjectCategoryId(projectCategoryId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_scienceAppRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getScienceAppId() {
		return _scienceAppId;
	}

	@Override
	public void setScienceAppId(long scienceAppId) {
		_scienceAppId = scienceAppId;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setScienceAppId", long.class);

				method.invoke(_scienceAppRemoteModel, scienceAppId);
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

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_scienceAppRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_scienceAppRemoteModel, companyId);
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

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_scienceAppRemoteModel, userId);
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_scienceAppRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_scienceAppRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_scienceAppRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVersion() {
		return _version;
	}

	@Override
	public void setVersion(String version) {
		_version = version;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_scienceAppRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public String getTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId);
	}

	@Override
	public String getTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId, useDefault);
	}

	@Override
	public String getTitle(String languageId) {
		return LocalizationUtil.getLocalization(getTitle(), languageId);
	}

	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getTitle(), languageId,
			useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return _titleCurrentLanguageId;
	}

	@Override
	public String getTitleCurrentValue() {
		Locale locale = getLocale(_titleCurrentLanguageId);

		return getTitle(locale);
	}

	@Override
	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_scienceAppRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setTitle(String title, Locale locale) {
		setTitle(title, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setTitle(String title, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(title)) {
			setTitle(LocalizationUtil.updateLocalization(getTitle(), "Title",
					title, languageId, defaultLanguageId));
		}
		else {
			setTitle(LocalizationUtil.removeLocalization(getTitle(), "Title",
					languageId));
		}
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		_titleCurrentLanguageId = languageId;
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap) {
		setTitleMap(titleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale) {
		if (titleMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setTitle(LocalizationUtil.updateLocalization(titleMap, getTitle(),
					"Title", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public long getDescriptionId() {
		return _descriptionId;
	}

	@Override
	public void setDescriptionId(long descriptionId) {
		_descriptionId = descriptionId;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setDescriptionId", long.class);

				method.invoke(_scienceAppRemoteModel, descriptionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPreviousVersionId() {
		return _previousVersionId;
	}

	@Override
	public void setPreviousVersionId(long previousVersionId) {
		_previousVersionId = previousVersionId;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setPreviousVersionId",
						long.class);

				method.invoke(_scienceAppRemoteModel, previousVersionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIconId() {
		return _iconId;
	}

	@Override
	public void setIconId(long iconId) {
		_iconId = iconId;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setIconId", long.class);

				method.invoke(_scienceAppRemoteModel, iconId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getManualId() {
		return _manualId;
	}

	@Override
	public String getManualId(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getManualId(languageId);
	}

	@Override
	public String getManualId(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getManualId(languageId, useDefault);
	}

	@Override
	public String getManualId(String languageId) {
		return LocalizationUtil.getLocalization(getManualId(), languageId);
	}

	@Override
	public String getManualId(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getManualId(), languageId,
			useDefault);
	}

	@Override
	public String getManualIdCurrentLanguageId() {
		return _manualIdCurrentLanguageId;
	}

	@Override
	public String getManualIdCurrentValue() {
		Locale locale = getLocale(_manualIdCurrentLanguageId);

		return getManualId(locale);
	}

	@Override
	public Map<Locale, String> getManualIdMap() {
		return LocalizationUtil.getLocalizationMap(getManualId());
	}

	@Override
	public void setManualId(String manualId) {
		_manualId = manualId;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setManualId", String.class);

				method.invoke(_scienceAppRemoteModel, manualId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setManualId(String manualId, Locale locale) {
		setManualId(manualId, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setManualId(String manualId, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(manualId)) {
			setManualId(LocalizationUtil.updateLocalization(getManualId(),
					"ManualId", manualId, languageId, defaultLanguageId));
		}
		else {
			setManualId(LocalizationUtil.removeLocalization(getManualId(),
					"ManualId", languageId));
		}
	}

	@Override
	public void setManualIdCurrentLanguageId(String languageId) {
		_manualIdCurrentLanguageId = languageId;
	}

	@Override
	public void setManualIdMap(Map<Locale, String> manualIdMap) {
		setManualIdMap(manualIdMap, LocaleUtil.getDefault());
	}

	@Override
	public void setManualIdMap(Map<Locale, String> manualIdMap,
		Locale defaultLocale) {
		if (manualIdMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setManualId(LocalizationUtil.updateLocalization(manualIdMap,
					getManualId(), "ManualId",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getExeFileName() {
		return _exeFileName;
	}

	@Override
	public void setExeFileName(String exeFileName) {
		_exeFileName = exeFileName;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setExeFileName", String.class);

				method.invoke(_scienceAppRemoteModel, exeFileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAppType() {
		return _appType;
	}

	@Override
	public void setAppType(String appType) {
		_appType = appType;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setAppType", String.class);

				method.invoke(_scienceAppRemoteModel, appType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRunType() {
		return _runType;
	}

	@Override
	public void setRunType(String runType) {
		_runType = runType;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setRunType", String.class);

				method.invoke(_scienceAppRemoteModel, runType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAuthorId() {
		return _authorId;
	}

	@Override
	public void setAuthorId(long authorId) {
		_authorId = authorId;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthorId", long.class);

				method.invoke(_scienceAppRemoteModel, authorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStage() {
		return _stage;
	}

	@Override
	public void setStage(String stage) {
		_stage = stage;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setStage", String.class);

				method.invoke(_scienceAppRemoteModel, stage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_scienceAppRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRecentModifierId() {
		return _recentModifierId;
	}

	@Override
	public void setRecentModifierId(long recentModifierId) {
		_recentModifierId = recentModifierId;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setRecentModifierId",
						long.class);

				method.invoke(_scienceAppRemoteModel, recentModifierId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getParallelModule() {
		return _parallelModule;
	}

	@Override
	public void setParallelModule(String parallelModule) {
		_parallelModule = parallelModule;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setParallelModule",
						String.class);

				method.invoke(_scienceAppRemoteModel, parallelModule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getMaxCpus() {
		return _maxCpus;
	}

	@Override
	public void setMaxCpus(int maxCpus) {
		_maxCpus = maxCpus;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setMaxCpus", int.class);

				method.invoke(_scienceAppRemoteModel, maxCpus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDefaultCpus() {
		return _defaultCpus;
	}

	@Override
	public void setDefaultCpus(int defaultCpus) {
		_defaultCpus = defaultCpus;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setDefaultCpus", int.class);

				method.invoke(_scienceAppRemoteModel, defaultCpus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusDate", Date.class);

				method.invoke(_scienceAppRemoteModel, statusDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOpenLevel() {
		return _openLevel;
	}

	@Override
	public void setOpenLevel(String openLevel) {
		_openLevel = openLevel;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setOpenLevel", String.class);

				method.invoke(_scienceAppRemoteModel, openLevel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLicense() {
		return _license;
	}

	@Override
	public void setLicense(String license) {
		_license = license;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setLicense", String.class);

				method.invoke(_scienceAppRemoteModel, license);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSrcFileName() {
		return _srcFileName;
	}

	@Override
	public void setSrcFileName(String srcFileName) {
		_srcFileName = srcFileName;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setSrcFileName", String.class);

				method.invoke(_scienceAppRemoteModel, srcFileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTargetLanguage() {
		return _targetLanguage;
	}

	@Override
	public void setTargetLanguage(String targetLanguage) {
		_targetLanguage = targetLanguage;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setTargetLanguage",
						String.class);

				method.invoke(_scienceAppRemoteModel, targetLanguage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDevelopers() {
		return _developers;
	}

	@Override
	public String getDevelopers(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDevelopers(languageId);
	}

	@Override
	public String getDevelopers(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDevelopers(languageId, useDefault);
	}

	@Override
	public String getDevelopers(String languageId) {
		return LocalizationUtil.getLocalization(getDevelopers(), languageId);
	}

	@Override
	public String getDevelopers(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getDevelopers(), languageId,
			useDefault);
	}

	@Override
	public String getDevelopersCurrentLanguageId() {
		return _developersCurrentLanguageId;
	}

	@Override
	public String getDevelopersCurrentValue() {
		Locale locale = getLocale(_developersCurrentLanguageId);

		return getDevelopers(locale);
	}

	@Override
	public Map<Locale, String> getDevelopersMap() {
		return LocalizationUtil.getLocalizationMap(getDevelopers());
	}

	@Override
	public void setDevelopers(String developers) {
		_developers = developers;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setDevelopers", String.class);

				method.invoke(_scienceAppRemoteModel, developers);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setDevelopers(String developers, Locale locale) {
		setDevelopers(developers, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDevelopers(String developers, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(developers)) {
			setDevelopers(LocalizationUtil.updateLocalization(getDevelopers(),
					"Developers", developers, languageId, defaultLanguageId));
		}
		else {
			setDevelopers(LocalizationUtil.removeLocalization(getDevelopers(),
					"Developers", languageId));
		}
	}

	@Override
	public void setDevelopersCurrentLanguageId(String languageId) {
		_developersCurrentLanguageId = languageId;
	}

	@Override
	public void setDevelopersMap(Map<Locale, String> developersMap) {
		setDevelopersMap(developersMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDevelopersMap(Map<Locale, String> developersMap,
		Locale defaultLocale) {
		if (developersMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setDevelopers(LocalizationUtil.updateLocalization(developersMap,
					getDevelopers(), "Developers",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getEditorType() {
		return _editorType;
	}

	@Override
	public void setEditorType(String editorType) {
		_editorType = editorType;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setEditorType", String.class);

				method.invoke(_scienceAppRemoteModel, editorType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getSwTest() {
		return _swTest;
	}

	@Override
	public boolean isSwTest() {
		return _swTest;
	}

	@Override
	public void setSwTest(boolean swTest) {
		_swTest = swTest;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setSwTest", boolean.class);

				method.invoke(_scienceAppRemoteModel, swTest);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProjectCategoryId() {
		return _projectCategoryId;
	}

	@Override
	public void setProjectCategoryId(long projectCategoryId) {
		_projectCategoryId = projectCategoryId;

		if (_scienceAppRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectCategoryId",
						long.class);

				method.invoke(_scienceAppRemoteModel, projectCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean isApproved() {
		try {
			String methodName = "isApproved";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getBinPath() {
		try {
			String methodName = "getBinPath";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getSrcPath() {
		try {
			String methodName = "getSrcPath";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ScienceApp.class.getName()));
	}

	public BaseModel<?> getScienceAppRemoteModel() {
		return _scienceAppRemoteModel;
	}

	public void setScienceAppRemoteModel(BaseModel<?> scienceAppRemoteModel) {
		_scienceAppRemoteModel = scienceAppRemoteModel;
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

		Class<?> remoteModelClass = _scienceAppRemoteModel.getClass();

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

		Object returnValue = method.invoke(_scienceAppRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ScienceAppLocalServiceUtil.addScienceApp(this);
		}
		else {
			ScienceAppLocalServiceUtil.updateScienceApp(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> titleMap = getTitleMap();

		for (Map.Entry<Locale, String> entry : titleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> manualIdMap = getManualIdMap();

		for (Map.Entry<Locale, String> entry : manualIdMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> developersMap = getDevelopersMap();

		for (Map.Entry<Locale, String> entry : developersMap.entrySet()) {
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
		String xml = getTitle();

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

		String title = getTitle(defaultLocale);

		if (Validator.isNull(title)) {
			setTitle(getTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setTitle(getTitle(defaultLocale), defaultLocale, defaultLocale);
		}

		String manualId = getManualId(defaultLocale);

		if (Validator.isNull(manualId)) {
			setManualId(getManualId(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setManualId(getManualId(defaultLocale), defaultLocale, defaultLocale);
		}

		String developers = getDevelopers(defaultLocale);

		if (Validator.isNull(developers)) {
			setDevelopers(getDevelopers(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDevelopers(getDevelopers(defaultLocale), defaultLocale,
				defaultLocale);
		}
	}

	@Override
	public ScienceApp toEscapedModel() {
		return (ScienceApp)ProxyUtil.newProxyInstance(ScienceApp.class.getClassLoader(),
			new Class[] { ScienceApp.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScienceAppClp clone = new ScienceAppClp();

		clone.setUuid(getUuid());
		clone.setScienceAppId(getScienceAppId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setVersion(getVersion());
		clone.setTitle(getTitle());
		clone.setDescriptionId(getDescriptionId());
		clone.setPreviousVersionId(getPreviousVersionId());
		clone.setIconId(getIconId());
		clone.setManualId(getManualId());
		clone.setExeFileName(getExeFileName());
		clone.setAppType(getAppType());
		clone.setRunType(getRunType());
		clone.setAuthorId(getAuthorId());
		clone.setStage(getStage());
		clone.setStatus(getStatus());
		clone.setRecentModifierId(getRecentModifierId());
		clone.setParallelModule(getParallelModule());
		clone.setMaxCpus(getMaxCpus());
		clone.setDefaultCpus(getDefaultCpus());
		clone.setStatusDate(getStatusDate());
		clone.setOpenLevel(getOpenLevel());
		clone.setLicense(getLicense());
		clone.setSrcFileName(getSrcFileName());
		clone.setTargetLanguage(getTargetLanguage());
		clone.setDevelopers(getDevelopers());
		clone.setEditorType(getEditorType());
		clone.setSwTest(getSwTest());
		clone.setProjectCategoryId(getProjectCategoryId());

		return clone;
	}

	@Override
	public int compareTo(ScienceApp scienceApp) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), scienceApp.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		value = getVersion().compareTo(scienceApp.getVersion());

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

		if (!(obj instanceof ScienceAppClp)) {
			return false;
		}

		ScienceAppClp scienceApp = (ScienceAppClp)obj;

		long primaryKey = scienceApp.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
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
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(67);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", scienceAppId=");
		sb.append(getScienceAppId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", descriptionId=");
		sb.append(getDescriptionId());
		sb.append(", previousVersionId=");
		sb.append(getPreviousVersionId());
		sb.append(", iconId=");
		sb.append(getIconId());
		sb.append(", manualId=");
		sb.append(getManualId());
		sb.append(", exeFileName=");
		sb.append(getExeFileName());
		sb.append(", appType=");
		sb.append(getAppType());
		sb.append(", runType=");
		sb.append(getRunType());
		sb.append(", authorId=");
		sb.append(getAuthorId());
		sb.append(", stage=");
		sb.append(getStage());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", recentModifierId=");
		sb.append(getRecentModifierId());
		sb.append(", parallelModule=");
		sb.append(getParallelModule());
		sb.append(", maxCpus=");
		sb.append(getMaxCpus());
		sb.append(", defaultCpus=");
		sb.append(getDefaultCpus());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", openLevel=");
		sb.append(getOpenLevel());
		sb.append(", license=");
		sb.append(getLicense());
		sb.append(", srcFileName=");
		sb.append(getSrcFileName());
		sb.append(", targetLanguage=");
		sb.append(getTargetLanguage());
		sb.append(", developers=");
		sb.append(getDevelopers());
		sb.append(", editorType=");
		sb.append(getEditorType());
		sb.append(", swTest=");
		sb.append(getSwTest());
		sb.append(", projectCategoryId=");
		sb.append(getProjectCategoryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(103);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.science.model.ScienceApp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scienceAppId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descriptionId</column-name><column-value><![CDATA[");
		sb.append(getDescriptionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>previousVersionId</column-name><column-value><![CDATA[");
		sb.append(getPreviousVersionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>iconId</column-name><column-value><![CDATA[");
		sb.append(getIconId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>manualId</column-name><column-value><![CDATA[");
		sb.append(getManualId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>exeFileName</column-name><column-value><![CDATA[");
		sb.append(getExeFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>appType</column-name><column-value><![CDATA[");
		sb.append(getAppType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>runType</column-name><column-value><![CDATA[");
		sb.append(getRunType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authorId</column-name><column-value><![CDATA[");
		sb.append(getAuthorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stage</column-name><column-value><![CDATA[");
		sb.append(getStage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recentModifierId</column-name><column-value><![CDATA[");
		sb.append(getRecentModifierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parallelModule</column-name><column-value><![CDATA[");
		sb.append(getParallelModule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxCpus</column-name><column-value><![CDATA[");
		sb.append(getMaxCpus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultCpus</column-name><column-value><![CDATA[");
		sb.append(getDefaultCpus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>openLevel</column-name><column-value><![CDATA[");
		sb.append(getOpenLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>license</column-name><column-value><![CDATA[");
		sb.append(getLicense());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>srcFileName</column-name><column-value><![CDATA[");
		sb.append(getSrcFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>targetLanguage</column-name><column-value><![CDATA[");
		sb.append(getTargetLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>developers</column-name><column-value><![CDATA[");
		sb.append(getDevelopers());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>editorType</column-name><column-value><![CDATA[");
		sb.append(getEditorType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>swTest</column-name><column-value><![CDATA[");
		sb.append(getSwTest());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectCategoryId</column-name><column-value><![CDATA[");
		sb.append(getProjectCategoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _scienceAppId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _version;
	private String _title;
	private String _titleCurrentLanguageId;
	private long _descriptionId;
	private long _previousVersionId;
	private long _iconId;
	private String _manualId;
	private String _manualIdCurrentLanguageId;
	private String _exeFileName;
	private String _appType;
	private String _runType;
	private long _authorId;
	private String _stage;
	private int _status;
	private long _recentModifierId;
	private String _parallelModule;
	private int _maxCpus;
	private int _defaultCpus;
	private Date _statusDate;
	private String _openLevel;
	private String _license;
	private String _srcFileName;
	private String _targetLanguage;
	private String _developers;
	private String _developersCurrentLanguageId;
	private String _editorType;
	private boolean _swTest;
	private long _projectCategoryId;
	private BaseModel<?> _scienceAppRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.science.service.ClpSerializer.class;
}