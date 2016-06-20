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
import org.kisti.edison.science.service.DeveloperInfoLocalServiceUtil;
import org.kisti.edison.science.service.persistence.DeveloperInfoPK;

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
public class DeveloperInfoClp extends BaseModelImpl<DeveloperInfo>
	implements DeveloperInfo {
	public DeveloperInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DeveloperInfo.class;
	}

	@Override
	public String getModelClassName() {
		return DeveloperInfo.class.getName();
	}

	@Override
	public DeveloperInfoPK getPrimaryKey() {
		return new DeveloperInfoPK(_userId, _groupId);
	}

	@Override
	public void setPrimaryKey(DeveloperInfoPK primaryKey) {
		setUserId(primaryKey.userId);
		setGroupId(primaryKey.groupId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new DeveloperInfoPK(_userId, _groupId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((DeveloperInfoPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("screenName", getScreenName());
		attributes.put("firstName", getFirstName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("universityField", getUniversityField());
		attributes.put("majorField", getMajorField());
		attributes.put("useStart", getUseStart());
		attributes.put("useEnd", getUseEnd());
		attributes.put("developerSort", getDeveloperSort());
		attributes.put("languageFortran", getLanguageFortran());
		attributes.put("languageCpp", getLanguageCpp());
		attributes.put("languagePython", getLanguagePython());
		attributes.put("languageJava", getLanguageJava());
		attributes.put("languageOther", getLanguageOther());
		attributes.put("languageOtherDescription", getLanguageOtherDescription());
		attributes.put("rem", getRem());
		attributes.put("agreementYn", getAgreementYn());
		attributes.put("writtenOathLogical", getWrittenOathLogical());
		attributes.put("writtenOathPhysical", getWrittenOathPhysical());
		attributes.put("detailIp", getDetailIp());
		attributes.put("detailOs", getDetailOs());
		attributes.put("detailCpu", getDetailCpu());
		attributes.put("detailStorate", getDetailStorate());
		attributes.put("detailLibrary", getDetailLibrary());
		attributes.put("insertId", getInsertId());
		attributes.put("insertDate", getInsertDate());
		attributes.put("updateId", getUpdateId());
		attributes.put("updateDate", getUpdateDate());
		attributes.put("etc", getEtc());
		attributes.put("developerId", getDeveloperId());
		attributes.put("developerPassword", getDeveloperPassword());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String screenName = (String)attributes.get("screenName");

		if (screenName != null) {
			setScreenName(screenName);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String universityField = (String)attributes.get("universityField");

		if (universityField != null) {
			setUniversityField(universityField);
		}

		String majorField = (String)attributes.get("majorField");

		if (majorField != null) {
			setMajorField(majorField);
		}

		String useStart = (String)attributes.get("useStart");

		if (useStart != null) {
			setUseStart(useStart);
		}

		String useEnd = (String)attributes.get("useEnd");

		if (useEnd != null) {
			setUseEnd(useEnd);
		}

		String developerSort = (String)attributes.get("developerSort");

		if (developerSort != null) {
			setDeveloperSort(developerSort);
		}

		Boolean languageFortran = (Boolean)attributes.get("languageFortran");

		if (languageFortran != null) {
			setLanguageFortran(languageFortran);
		}

		Boolean languageCpp = (Boolean)attributes.get("languageCpp");

		if (languageCpp != null) {
			setLanguageCpp(languageCpp);
		}

		Boolean languagePython = (Boolean)attributes.get("languagePython");

		if (languagePython != null) {
			setLanguagePython(languagePython);
		}

		Boolean languageJava = (Boolean)attributes.get("languageJava");

		if (languageJava != null) {
			setLanguageJava(languageJava);
		}

		Boolean languageOther = (Boolean)attributes.get("languageOther");

		if (languageOther != null) {
			setLanguageOther(languageOther);
		}

		String languageOtherDescription = (String)attributes.get(
				"languageOtherDescription");

		if (languageOtherDescription != null) {
			setLanguageOtherDescription(languageOtherDescription);
		}

		String rem = (String)attributes.get("rem");

		if (rem != null) {
			setRem(rem);
		}

		Boolean agreementYn = (Boolean)attributes.get("agreementYn");

		if (agreementYn != null) {
			setAgreementYn(agreementYn);
		}

		String writtenOathLogical = (String)attributes.get("writtenOathLogical");

		if (writtenOathLogical != null) {
			setWrittenOathLogical(writtenOathLogical);
		}

		String writtenOathPhysical = (String)attributes.get(
				"writtenOathPhysical");

		if (writtenOathPhysical != null) {
			setWrittenOathPhysical(writtenOathPhysical);
		}

		String detailIp = (String)attributes.get("detailIp");

		if (detailIp != null) {
			setDetailIp(detailIp);
		}

		String detailOs = (String)attributes.get("detailOs");

		if (detailOs != null) {
			setDetailOs(detailOs);
		}

		String detailCpu = (String)attributes.get("detailCpu");

		if (detailCpu != null) {
			setDetailCpu(detailCpu);
		}

		String detailStorate = (String)attributes.get("detailStorate");

		if (detailStorate != null) {
			setDetailStorate(detailStorate);
		}

		String detailLibrary = (String)attributes.get("detailLibrary");

		if (detailLibrary != null) {
			setDetailLibrary(detailLibrary);
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

		String etc = (String)attributes.get("etc");

		if (etc != null) {
			setEtc(etc);
		}

		String developerId = (String)attributes.get("developerId");

		if (developerId != null) {
			setDeveloperId(developerId);
		}

		String developerPassword = (String)attributes.get("developerPassword");

		if (developerPassword != null) {
			setDeveloperPassword(developerPassword);
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_developerInfoRemoteModel, userId);
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
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_developerInfoRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getScreenName() {
		return _screenName;
	}

	@Override
	public void setScreenName(String screenName) {
		_screenName = screenName;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setScreenName", String.class);

				method.invoke(_developerInfoRemoteModel, screenName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_developerInfoRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_developerInfoRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUniversityField() {
		return _universityField;
	}

	@Override
	public void setUniversityField(String universityField) {
		_universityField = universityField;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUniversityField",
						String.class);

				method.invoke(_developerInfoRemoteModel, universityField);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMajorField() {
		return _majorField;
	}

	@Override
	public void setMajorField(String majorField) {
		_majorField = majorField;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setMajorField", String.class);

				method.invoke(_developerInfoRemoteModel, majorField);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUseStart() {
		return _useStart;
	}

	@Override
	public void setUseStart(String useStart) {
		_useStart = useStart;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUseStart", String.class);

				method.invoke(_developerInfoRemoteModel, useStart);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUseEnd() {
		return _useEnd;
	}

	@Override
	public void setUseEnd(String useEnd) {
		_useEnd = useEnd;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUseEnd", String.class);

				method.invoke(_developerInfoRemoteModel, useEnd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeveloperSort() {
		return _developerSort;
	}

	@Override
	public void setDeveloperSort(String developerSort) {
		_developerSort = developerSort;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDeveloperSort", String.class);

				method.invoke(_developerInfoRemoteModel, developerSort);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLanguageFortran() {
		return _languageFortran;
	}

	@Override
	public boolean isLanguageFortran() {
		return _languageFortran;
	}

	@Override
	public void setLanguageFortran(boolean languageFortran) {
		_languageFortran = languageFortran;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguageFortran",
						boolean.class);

				method.invoke(_developerInfoRemoteModel, languageFortran);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLanguageCpp() {
		return _languageCpp;
	}

	@Override
	public boolean isLanguageCpp() {
		return _languageCpp;
	}

	@Override
	public void setLanguageCpp(boolean languageCpp) {
		_languageCpp = languageCpp;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguageCpp", boolean.class);

				method.invoke(_developerInfoRemoteModel, languageCpp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLanguagePython() {
		return _languagePython;
	}

	@Override
	public boolean isLanguagePython() {
		return _languagePython;
	}

	@Override
	public void setLanguagePython(boolean languagePython) {
		_languagePython = languagePython;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguagePython",
						boolean.class);

				method.invoke(_developerInfoRemoteModel, languagePython);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLanguageJava() {
		return _languageJava;
	}

	@Override
	public boolean isLanguageJava() {
		return _languageJava;
	}

	@Override
	public void setLanguageJava(boolean languageJava) {
		_languageJava = languageJava;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguageJava", boolean.class);

				method.invoke(_developerInfoRemoteModel, languageJava);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLanguageOther() {
		return _languageOther;
	}

	@Override
	public boolean isLanguageOther() {
		return _languageOther;
	}

	@Override
	public void setLanguageOther(boolean languageOther) {
		_languageOther = languageOther;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguageOther",
						boolean.class);

				method.invoke(_developerInfoRemoteModel, languageOther);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLanguageOtherDescription() {
		return _languageOtherDescription;
	}

	@Override
	public void setLanguageOtherDescription(String languageOtherDescription) {
		_languageOtherDescription = languageOtherDescription;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguageOtherDescription",
						String.class);

				method.invoke(_developerInfoRemoteModel,
					languageOtherDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRem() {
		return _rem;
	}

	@Override
	public String getRem(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getRem(languageId);
	}

	@Override
	public String getRem(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getRem(languageId, useDefault);
	}

	@Override
	public String getRem(String languageId) {
		return LocalizationUtil.getLocalization(getRem(), languageId);
	}

	@Override
	public String getRem(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getRem(), languageId, useDefault);
	}

	@Override
	public String getRemCurrentLanguageId() {
		return _remCurrentLanguageId;
	}

	@Override
	public String getRemCurrentValue() {
		Locale locale = getLocale(_remCurrentLanguageId);

		return getRem(locale);
	}

	@Override
	public Map<Locale, String> getRemMap() {
		return LocalizationUtil.getLocalizationMap(getRem());
	}

	@Override
	public void setRem(String rem) {
		_rem = rem;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setRem", String.class);

				method.invoke(_developerInfoRemoteModel, rem);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setRem(String rem, Locale locale) {
		setRem(rem, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setRem(String rem, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(rem)) {
			setRem(LocalizationUtil.updateLocalization(getRem(), "Rem", rem,
					languageId, defaultLanguageId));
		}
		else {
			setRem(LocalizationUtil.removeLocalization(getRem(), "Rem",
					languageId));
		}
	}

	@Override
	public void setRemCurrentLanguageId(String languageId) {
		_remCurrentLanguageId = languageId;
	}

	@Override
	public void setRemMap(Map<Locale, String> remMap) {
		setRemMap(remMap, LocaleUtil.getDefault());
	}

	@Override
	public void setRemMap(Map<Locale, String> remMap, Locale defaultLocale) {
		if (remMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setRem(LocalizationUtil.updateLocalization(remMap, getRem(), "Rem",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public boolean getAgreementYn() {
		return _agreementYn;
	}

	@Override
	public boolean isAgreementYn() {
		return _agreementYn;
	}

	@Override
	public void setAgreementYn(boolean agreementYn) {
		_agreementYn = agreementYn;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setAgreementYn", boolean.class);

				method.invoke(_developerInfoRemoteModel, agreementYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWrittenOathLogical() {
		return _writtenOathLogical;
	}

	@Override
	public void setWrittenOathLogical(String writtenOathLogical) {
		_writtenOathLogical = writtenOathLogical;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setWrittenOathLogical",
						String.class);

				method.invoke(_developerInfoRemoteModel, writtenOathLogical);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWrittenOathPhysical() {
		return _writtenOathPhysical;
	}

	@Override
	public void setWrittenOathPhysical(String writtenOathPhysical) {
		_writtenOathPhysical = writtenOathPhysical;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setWrittenOathPhysical",
						String.class);

				method.invoke(_developerInfoRemoteModel, writtenOathPhysical);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDetailIp() {
		return _detailIp;
	}

	@Override
	public void setDetailIp(String detailIp) {
		_detailIp = detailIp;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDetailIp", String.class);

				method.invoke(_developerInfoRemoteModel, detailIp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDetailOs() {
		return _detailOs;
	}

	@Override
	public void setDetailOs(String detailOs) {
		_detailOs = detailOs;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDetailOs", String.class);

				method.invoke(_developerInfoRemoteModel, detailOs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDetailCpu() {
		return _detailCpu;
	}

	@Override
	public void setDetailCpu(String detailCpu) {
		_detailCpu = detailCpu;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDetailCpu", String.class);

				method.invoke(_developerInfoRemoteModel, detailCpu);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDetailStorate() {
		return _detailStorate;
	}

	@Override
	public void setDetailStorate(String detailStorate) {
		_detailStorate = detailStorate;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDetailStorate", String.class);

				method.invoke(_developerInfoRemoteModel, detailStorate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDetailLibrary() {
		return _detailLibrary;
	}

	@Override
	public void setDetailLibrary(String detailLibrary) {
		_detailLibrary = detailLibrary;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDetailLibrary", String.class);

				method.invoke(_developerInfoRemoteModel, detailLibrary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInsertId() {
		return _insertId;
	}

	@Override
	public void setInsertId(long insertId) {
		_insertId = insertId;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertId", long.class);

				method.invoke(_developerInfoRemoteModel, insertId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getInsertDate() {
		return _insertDate;
	}

	@Override
	public void setInsertDate(Date insertDate) {
		_insertDate = insertDate;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertDate", Date.class);

				method.invoke(_developerInfoRemoteModel, insertDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUpdateId() {
		return _updateId;
	}

	@Override
	public void setUpdateId(long updateId) {
		_updateId = updateId;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateId", long.class);

				method.invoke(_developerInfoRemoteModel, updateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdateDate() {
		return _updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateDate", Date.class);

				method.invoke(_developerInfoRemoteModel, updateDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEtc() {
		return _etc;
	}

	@Override
	public String getEtc(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getEtc(languageId);
	}

	@Override
	public String getEtc(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getEtc(languageId, useDefault);
	}

	@Override
	public String getEtc(String languageId) {
		return LocalizationUtil.getLocalization(getEtc(), languageId);
	}

	@Override
	public String getEtc(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getEtc(), languageId, useDefault);
	}

	@Override
	public String getEtcCurrentLanguageId() {
		return _etcCurrentLanguageId;
	}

	@Override
	public String getEtcCurrentValue() {
		Locale locale = getLocale(_etcCurrentLanguageId);

		return getEtc(locale);
	}

	@Override
	public Map<Locale, String> getEtcMap() {
		return LocalizationUtil.getLocalizationMap(getEtc());
	}

	@Override
	public void setEtc(String etc) {
		_etc = etc;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEtc", String.class);

				method.invoke(_developerInfoRemoteModel, etc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setEtc(String etc, Locale locale) {
		setEtc(etc, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setEtc(String etc, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(etc)) {
			setEtc(LocalizationUtil.updateLocalization(getEtc(), "Etc", etc,
					languageId, defaultLanguageId));
		}
		else {
			setEtc(LocalizationUtil.removeLocalization(getEtc(), "Etc",
					languageId));
		}
	}

	@Override
	public void setEtcCurrentLanguageId(String languageId) {
		_etcCurrentLanguageId = languageId;
	}

	@Override
	public void setEtcMap(Map<Locale, String> etcMap) {
		setEtcMap(etcMap, LocaleUtil.getDefault());
	}

	@Override
	public void setEtcMap(Map<Locale, String> etcMap, Locale defaultLocale) {
		if (etcMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setEtc(LocalizationUtil.updateLocalization(etcMap, getEtc(), "Etc",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getDeveloperId() {
		return _developerId;
	}

	@Override
	public void setDeveloperId(String developerId) {
		_developerId = developerId;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDeveloperId", String.class);

				method.invoke(_developerInfoRemoteModel, developerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeveloperPassword() {
		return _developerPassword;
	}

	@Override
	public void setDeveloperPassword(String developerPassword) {
		_developerPassword = developerPassword;

		if (_developerInfoRemoteModel != null) {
			try {
				Class<?> clazz = _developerInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDeveloperPassword",
						String.class);

				method.invoke(_developerInfoRemoteModel, developerPassword);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDeveloperInfoRemoteModel() {
		return _developerInfoRemoteModel;
	}

	public void setDeveloperInfoRemoteModel(
		BaseModel<?> developerInfoRemoteModel) {
		_developerInfoRemoteModel = developerInfoRemoteModel;
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

		Class<?> remoteModelClass = _developerInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_developerInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DeveloperInfoLocalServiceUtil.addDeveloperInfo(this);
		}
		else {
			DeveloperInfoLocalServiceUtil.updateDeveloperInfo(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> remMap = getRemMap();

		for (Map.Entry<Locale, String> entry : remMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> etcMap = getEtcMap();

		for (Map.Entry<Locale, String> entry : etcMap.entrySet()) {
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
		String xml = getRem();

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

		String rem = getRem(defaultLocale);

		if (Validator.isNull(rem)) {
			setRem(getRem(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setRem(getRem(defaultLocale), defaultLocale, defaultLocale);
		}

		String etc = getEtc(defaultLocale);

		if (Validator.isNull(etc)) {
			setEtc(getEtc(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setEtc(getEtc(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public DeveloperInfo toEscapedModel() {
		return (DeveloperInfo)ProxyUtil.newProxyInstance(DeveloperInfo.class.getClassLoader(),
			new Class[] { DeveloperInfo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DeveloperInfoClp clone = new DeveloperInfoClp();

		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());
		clone.setScreenName(getScreenName());
		clone.setFirstName(getFirstName());
		clone.setEmailAddress(getEmailAddress());
		clone.setUniversityField(getUniversityField());
		clone.setMajorField(getMajorField());
		clone.setUseStart(getUseStart());
		clone.setUseEnd(getUseEnd());
		clone.setDeveloperSort(getDeveloperSort());
		clone.setLanguageFortran(getLanguageFortran());
		clone.setLanguageCpp(getLanguageCpp());
		clone.setLanguagePython(getLanguagePython());
		clone.setLanguageJava(getLanguageJava());
		clone.setLanguageOther(getLanguageOther());
		clone.setLanguageOtherDescription(getLanguageOtherDescription());
		clone.setRem(getRem());
		clone.setAgreementYn(getAgreementYn());
		clone.setWrittenOathLogical(getWrittenOathLogical());
		clone.setWrittenOathPhysical(getWrittenOathPhysical());
		clone.setDetailIp(getDetailIp());
		clone.setDetailOs(getDetailOs());
		clone.setDetailCpu(getDetailCpu());
		clone.setDetailStorate(getDetailStorate());
		clone.setDetailLibrary(getDetailLibrary());
		clone.setInsertId(getInsertId());
		clone.setInsertDate(getInsertDate());
		clone.setUpdateId(getUpdateId());
		clone.setUpdateDate(getUpdateDate());
		clone.setEtc(getEtc());
		clone.setDeveloperId(getDeveloperId());
		clone.setDeveloperPassword(getDeveloperPassword());

		return clone;
	}

	@Override
	public int compareTo(DeveloperInfo developerInfo) {
		DeveloperInfoPK primaryKey = developerInfo.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DeveloperInfoClp)) {
			return false;
		}

		DeveloperInfoClp developerInfo = (DeveloperInfoClp)obj;

		DeveloperInfoPK primaryKey = developerInfo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(65);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", screenName=");
		sb.append(getScreenName());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", universityField=");
		sb.append(getUniversityField());
		sb.append(", majorField=");
		sb.append(getMajorField());
		sb.append(", useStart=");
		sb.append(getUseStart());
		sb.append(", useEnd=");
		sb.append(getUseEnd());
		sb.append(", developerSort=");
		sb.append(getDeveloperSort());
		sb.append(", languageFortran=");
		sb.append(getLanguageFortran());
		sb.append(", languageCpp=");
		sb.append(getLanguageCpp());
		sb.append(", languagePython=");
		sb.append(getLanguagePython());
		sb.append(", languageJava=");
		sb.append(getLanguageJava());
		sb.append(", languageOther=");
		sb.append(getLanguageOther());
		sb.append(", languageOtherDescription=");
		sb.append(getLanguageOtherDescription());
		sb.append(", rem=");
		sb.append(getRem());
		sb.append(", agreementYn=");
		sb.append(getAgreementYn());
		sb.append(", writtenOathLogical=");
		sb.append(getWrittenOathLogical());
		sb.append(", writtenOathPhysical=");
		sb.append(getWrittenOathPhysical());
		sb.append(", detailIp=");
		sb.append(getDetailIp());
		sb.append(", detailOs=");
		sb.append(getDetailOs());
		sb.append(", detailCpu=");
		sb.append(getDetailCpu());
		sb.append(", detailStorate=");
		sb.append(getDetailStorate());
		sb.append(", detailLibrary=");
		sb.append(getDetailLibrary());
		sb.append(", insertId=");
		sb.append(getInsertId());
		sb.append(", insertDate=");
		sb.append(getInsertDate());
		sb.append(", updateId=");
		sb.append(getUpdateId());
		sb.append(", updateDate=");
		sb.append(getUpdateDate());
		sb.append(", etc=");
		sb.append(getEtc());
		sb.append(", developerId=");
		sb.append(getDeveloperId());
		sb.append(", developerPassword=");
		sb.append(getDeveloperPassword());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(100);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.science.model.DeveloperInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>screenName</column-name><column-value><![CDATA[");
		sb.append(getScreenName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>universityField</column-name><column-value><![CDATA[");
		sb.append(getUniversityField());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>majorField</column-name><column-value><![CDATA[");
		sb.append(getMajorField());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>useStart</column-name><column-value><![CDATA[");
		sb.append(getUseStart());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>useEnd</column-name><column-value><![CDATA[");
		sb.append(getUseEnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>developerSort</column-name><column-value><![CDATA[");
		sb.append(getDeveloperSort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageFortran</column-name><column-value><![CDATA[");
		sb.append(getLanguageFortran());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageCpp</column-name><column-value><![CDATA[");
		sb.append(getLanguageCpp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languagePython</column-name><column-value><![CDATA[");
		sb.append(getLanguagePython());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageJava</column-name><column-value><![CDATA[");
		sb.append(getLanguageJava());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageOther</column-name><column-value><![CDATA[");
		sb.append(getLanguageOther());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageOtherDescription</column-name><column-value><![CDATA[");
		sb.append(getLanguageOtherDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rem</column-name><column-value><![CDATA[");
		sb.append(getRem());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>agreementYn</column-name><column-value><![CDATA[");
		sb.append(getAgreementYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writtenOathLogical</column-name><column-value><![CDATA[");
		sb.append(getWrittenOathLogical());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writtenOathPhysical</column-name><column-value><![CDATA[");
		sb.append(getWrittenOathPhysical());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>detailIp</column-name><column-value><![CDATA[");
		sb.append(getDetailIp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>detailOs</column-name><column-value><![CDATA[");
		sb.append(getDetailOs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>detailCpu</column-name><column-value><![CDATA[");
		sb.append(getDetailCpu());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>detailStorate</column-name><column-value><![CDATA[");
		sb.append(getDetailStorate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>detailLibrary</column-name><column-value><![CDATA[");
		sb.append(getDetailLibrary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertId</column-name><column-value><![CDATA[");
		sb.append(getInsertId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insertDate</column-name><column-value><![CDATA[");
		sb.append(getInsertDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateId</column-name><column-value><![CDATA[");
		sb.append(getUpdateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateDate</column-name><column-value><![CDATA[");
		sb.append(getUpdateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>etc</column-name><column-value><![CDATA[");
		sb.append(getEtc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>developerId</column-name><column-value><![CDATA[");
		sb.append(getDeveloperId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>developerPassword</column-name><column-value><![CDATA[");
		sb.append(getDeveloperPassword());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private long _groupId;
	private String _screenName;
	private String _firstName;
	private String _emailAddress;
	private String _universityField;
	private String _majorField;
	private String _useStart;
	private String _useEnd;
	private String _developerSort;
	private boolean _languageFortran;
	private boolean _languageCpp;
	private boolean _languagePython;
	private boolean _languageJava;
	private boolean _languageOther;
	private String _languageOtherDescription;
	private String _rem;
	private String _remCurrentLanguageId;
	private boolean _agreementYn;
	private String _writtenOathLogical;
	private String _writtenOathPhysical;
	private String _detailIp;
	private String _detailOs;
	private String _detailCpu;
	private String _detailStorate;
	private String _detailLibrary;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
	private String _etc;
	private String _etcCurrentLanguageId;
	private String _developerId;
	private String _developerPassword;
	private BaseModel<?> _developerInfoRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.science.service.ClpSerializer.class;
}