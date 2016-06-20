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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DeveloperInfo}.
 * </p>
 *
 * @author EDISON
 * @see DeveloperInfo
 * @generated
 */
public class DeveloperInfoWrapper implements DeveloperInfo,
	ModelWrapper<DeveloperInfo> {
	public DeveloperInfoWrapper(DeveloperInfo developerInfo) {
		_developerInfo = developerInfo;
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

	/**
	* Returns the primary key of this developer info.
	*
	* @return the primary key of this developer info
	*/
	@Override
	public org.kisti.edison.science.service.persistence.DeveloperInfoPK getPrimaryKey() {
		return _developerInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this developer info.
	*
	* @param primaryKey the primary key of this developer info
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK primaryKey) {
		_developerInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this developer info.
	*
	* @return the user ID of this developer info
	*/
	@Override
	public long getUserId() {
		return _developerInfo.getUserId();
	}

	/**
	* Sets the user ID of this developer info.
	*
	* @param userId the user ID of this developer info
	*/
	@Override
	public void setUserId(long userId) {
		_developerInfo.setUserId(userId);
	}

	/**
	* Returns the user uuid of this developer info.
	*
	* @return the user uuid of this developer info
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerInfo.getUserUuid();
	}

	/**
	* Sets the user uuid of this developer info.
	*
	* @param userUuid the user uuid of this developer info
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_developerInfo.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this developer info.
	*
	* @return the group ID of this developer info
	*/
	@Override
	public long getGroupId() {
		return _developerInfo.getGroupId();
	}

	/**
	* Sets the group ID of this developer info.
	*
	* @param groupId the group ID of this developer info
	*/
	@Override
	public void setGroupId(long groupId) {
		_developerInfo.setGroupId(groupId);
	}

	/**
	* Returns the screen name of this developer info.
	*
	* @return the screen name of this developer info
	*/
	@Override
	public java.lang.String getScreenName() {
		return _developerInfo.getScreenName();
	}

	/**
	* Sets the screen name of this developer info.
	*
	* @param screenName the screen name of this developer info
	*/
	@Override
	public void setScreenName(java.lang.String screenName) {
		_developerInfo.setScreenName(screenName);
	}

	/**
	* Returns the first name of this developer info.
	*
	* @return the first name of this developer info
	*/
	@Override
	public java.lang.String getFirstName() {
		return _developerInfo.getFirstName();
	}

	/**
	* Sets the first name of this developer info.
	*
	* @param firstName the first name of this developer info
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_developerInfo.setFirstName(firstName);
	}

	/**
	* Returns the email address of this developer info.
	*
	* @return the email address of this developer info
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _developerInfo.getEmailAddress();
	}

	/**
	* Sets the email address of this developer info.
	*
	* @param emailAddress the email address of this developer info
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_developerInfo.setEmailAddress(emailAddress);
	}

	/**
	* Returns the university field of this developer info.
	*
	* @return the university field of this developer info
	*/
	@Override
	public java.lang.String getUniversityField() {
		return _developerInfo.getUniversityField();
	}

	/**
	* Sets the university field of this developer info.
	*
	* @param universityField the university field of this developer info
	*/
	@Override
	public void setUniversityField(java.lang.String universityField) {
		_developerInfo.setUniversityField(universityField);
	}

	/**
	* Returns the major field of this developer info.
	*
	* @return the major field of this developer info
	*/
	@Override
	public java.lang.String getMajorField() {
		return _developerInfo.getMajorField();
	}

	/**
	* Sets the major field of this developer info.
	*
	* @param majorField the major field of this developer info
	*/
	@Override
	public void setMajorField(java.lang.String majorField) {
		_developerInfo.setMajorField(majorField);
	}

	/**
	* Returns the use start of this developer info.
	*
	* @return the use start of this developer info
	*/
	@Override
	public java.lang.String getUseStart() {
		return _developerInfo.getUseStart();
	}

	/**
	* Sets the use start of this developer info.
	*
	* @param useStart the use start of this developer info
	*/
	@Override
	public void setUseStart(java.lang.String useStart) {
		_developerInfo.setUseStart(useStart);
	}

	/**
	* Returns the use end of this developer info.
	*
	* @return the use end of this developer info
	*/
	@Override
	public java.lang.String getUseEnd() {
		return _developerInfo.getUseEnd();
	}

	/**
	* Sets the use end of this developer info.
	*
	* @param useEnd the use end of this developer info
	*/
	@Override
	public void setUseEnd(java.lang.String useEnd) {
		_developerInfo.setUseEnd(useEnd);
	}

	/**
	* Returns the developer sort of this developer info.
	*
	* @return the developer sort of this developer info
	*/
	@Override
	public java.lang.String getDeveloperSort() {
		return _developerInfo.getDeveloperSort();
	}

	/**
	* Sets the developer sort of this developer info.
	*
	* @param developerSort the developer sort of this developer info
	*/
	@Override
	public void setDeveloperSort(java.lang.String developerSort) {
		_developerInfo.setDeveloperSort(developerSort);
	}

	/**
	* Returns the language fortran of this developer info.
	*
	* @return the language fortran of this developer info
	*/
	@Override
	public boolean getLanguageFortran() {
		return _developerInfo.getLanguageFortran();
	}

	/**
	* Returns <code>true</code> if this developer info is language fortran.
	*
	* @return <code>true</code> if this developer info is language fortran; <code>false</code> otherwise
	*/
	@Override
	public boolean isLanguageFortran() {
		return _developerInfo.isLanguageFortran();
	}

	/**
	* Sets whether this developer info is language fortran.
	*
	* @param languageFortran the language fortran of this developer info
	*/
	@Override
	public void setLanguageFortran(boolean languageFortran) {
		_developerInfo.setLanguageFortran(languageFortran);
	}

	/**
	* Returns the language cpp of this developer info.
	*
	* @return the language cpp of this developer info
	*/
	@Override
	public boolean getLanguageCpp() {
		return _developerInfo.getLanguageCpp();
	}

	/**
	* Returns <code>true</code> if this developer info is language cpp.
	*
	* @return <code>true</code> if this developer info is language cpp; <code>false</code> otherwise
	*/
	@Override
	public boolean isLanguageCpp() {
		return _developerInfo.isLanguageCpp();
	}

	/**
	* Sets whether this developer info is language cpp.
	*
	* @param languageCpp the language cpp of this developer info
	*/
	@Override
	public void setLanguageCpp(boolean languageCpp) {
		_developerInfo.setLanguageCpp(languageCpp);
	}

	/**
	* Returns the language python of this developer info.
	*
	* @return the language python of this developer info
	*/
	@Override
	public boolean getLanguagePython() {
		return _developerInfo.getLanguagePython();
	}

	/**
	* Returns <code>true</code> if this developer info is language python.
	*
	* @return <code>true</code> if this developer info is language python; <code>false</code> otherwise
	*/
	@Override
	public boolean isLanguagePython() {
		return _developerInfo.isLanguagePython();
	}

	/**
	* Sets whether this developer info is language python.
	*
	* @param languagePython the language python of this developer info
	*/
	@Override
	public void setLanguagePython(boolean languagePython) {
		_developerInfo.setLanguagePython(languagePython);
	}

	/**
	* Returns the language java of this developer info.
	*
	* @return the language java of this developer info
	*/
	@Override
	public boolean getLanguageJava() {
		return _developerInfo.getLanguageJava();
	}

	/**
	* Returns <code>true</code> if this developer info is language java.
	*
	* @return <code>true</code> if this developer info is language java; <code>false</code> otherwise
	*/
	@Override
	public boolean isLanguageJava() {
		return _developerInfo.isLanguageJava();
	}

	/**
	* Sets whether this developer info is language java.
	*
	* @param languageJava the language java of this developer info
	*/
	@Override
	public void setLanguageJava(boolean languageJava) {
		_developerInfo.setLanguageJava(languageJava);
	}

	/**
	* Returns the language other of this developer info.
	*
	* @return the language other of this developer info
	*/
	@Override
	public boolean getLanguageOther() {
		return _developerInfo.getLanguageOther();
	}

	/**
	* Returns <code>true</code> if this developer info is language other.
	*
	* @return <code>true</code> if this developer info is language other; <code>false</code> otherwise
	*/
	@Override
	public boolean isLanguageOther() {
		return _developerInfo.isLanguageOther();
	}

	/**
	* Sets whether this developer info is language other.
	*
	* @param languageOther the language other of this developer info
	*/
	@Override
	public void setLanguageOther(boolean languageOther) {
		_developerInfo.setLanguageOther(languageOther);
	}

	/**
	* Returns the language other description of this developer info.
	*
	* @return the language other description of this developer info
	*/
	@Override
	public java.lang.String getLanguageOtherDescription() {
		return _developerInfo.getLanguageOtherDescription();
	}

	/**
	* Sets the language other description of this developer info.
	*
	* @param languageOtherDescription the language other description of this developer info
	*/
	@Override
	public void setLanguageOtherDescription(
		java.lang.String languageOtherDescription) {
		_developerInfo.setLanguageOtherDescription(languageOtherDescription);
	}

	/**
	* Returns the rem of this developer info.
	*
	* @return the rem of this developer info
	*/
	@Override
	public java.lang.String getRem() {
		return _developerInfo.getRem();
	}

	/**
	* Returns the localized rem of this developer info in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized rem of this developer info
	*/
	@Override
	public java.lang.String getRem(java.util.Locale locale) {
		return _developerInfo.getRem(locale);
	}

	/**
	* Returns the localized rem of this developer info in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized rem of this developer info. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getRem(java.util.Locale locale, boolean useDefault) {
		return _developerInfo.getRem(locale, useDefault);
	}

	/**
	* Returns the localized rem of this developer info in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized rem of this developer info
	*/
	@Override
	public java.lang.String getRem(java.lang.String languageId) {
		return _developerInfo.getRem(languageId);
	}

	/**
	* Returns the localized rem of this developer info in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized rem of this developer info
	*/
	@Override
	public java.lang.String getRem(java.lang.String languageId,
		boolean useDefault) {
		return _developerInfo.getRem(languageId, useDefault);
	}

	@Override
	public java.lang.String getRemCurrentLanguageId() {
		return _developerInfo.getRemCurrentLanguageId();
	}

	@Override
	public java.lang.String getRemCurrentValue() {
		return _developerInfo.getRemCurrentValue();
	}

	/**
	* Returns a map of the locales and localized rems of this developer info.
	*
	* @return the locales and localized rems of this developer info
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getRemMap() {
		return _developerInfo.getRemMap();
	}

	/**
	* Sets the rem of this developer info.
	*
	* @param rem the rem of this developer info
	*/
	@Override
	public void setRem(java.lang.String rem) {
		_developerInfo.setRem(rem);
	}

	/**
	* Sets the localized rem of this developer info in the language.
	*
	* @param rem the localized rem of this developer info
	* @param locale the locale of the language
	*/
	@Override
	public void setRem(java.lang.String rem, java.util.Locale locale) {
		_developerInfo.setRem(rem, locale);
	}

	/**
	* Sets the localized rem of this developer info in the language, and sets the default locale.
	*
	* @param rem the localized rem of this developer info
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setRem(java.lang.String rem, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_developerInfo.setRem(rem, locale, defaultLocale);
	}

	@Override
	public void setRemCurrentLanguageId(java.lang.String languageId) {
		_developerInfo.setRemCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized rems of this developer info from the map of locales and localized rems.
	*
	* @param remMap the locales and localized rems of this developer info
	*/
	@Override
	public void setRemMap(
		java.util.Map<java.util.Locale, java.lang.String> remMap) {
		_developerInfo.setRemMap(remMap);
	}

	/**
	* Sets the localized rems of this developer info from the map of locales and localized rems, and sets the default locale.
	*
	* @param remMap the locales and localized rems of this developer info
	* @param defaultLocale the default locale
	*/
	@Override
	public void setRemMap(
		java.util.Map<java.util.Locale, java.lang.String> remMap,
		java.util.Locale defaultLocale) {
		_developerInfo.setRemMap(remMap, defaultLocale);
	}

	/**
	* Returns the agreement yn of this developer info.
	*
	* @return the agreement yn of this developer info
	*/
	@Override
	public boolean getAgreementYn() {
		return _developerInfo.getAgreementYn();
	}

	/**
	* Returns <code>true</code> if this developer info is agreement yn.
	*
	* @return <code>true</code> if this developer info is agreement yn; <code>false</code> otherwise
	*/
	@Override
	public boolean isAgreementYn() {
		return _developerInfo.isAgreementYn();
	}

	/**
	* Sets whether this developer info is agreement yn.
	*
	* @param agreementYn the agreement yn of this developer info
	*/
	@Override
	public void setAgreementYn(boolean agreementYn) {
		_developerInfo.setAgreementYn(agreementYn);
	}

	/**
	* Returns the written oath logical of this developer info.
	*
	* @return the written oath logical of this developer info
	*/
	@Override
	public java.lang.String getWrittenOathLogical() {
		return _developerInfo.getWrittenOathLogical();
	}

	/**
	* Sets the written oath logical of this developer info.
	*
	* @param writtenOathLogical the written oath logical of this developer info
	*/
	@Override
	public void setWrittenOathLogical(java.lang.String writtenOathLogical) {
		_developerInfo.setWrittenOathLogical(writtenOathLogical);
	}

	/**
	* Returns the written oath physical of this developer info.
	*
	* @return the written oath physical of this developer info
	*/
	@Override
	public java.lang.String getWrittenOathPhysical() {
		return _developerInfo.getWrittenOathPhysical();
	}

	/**
	* Sets the written oath physical of this developer info.
	*
	* @param writtenOathPhysical the written oath physical of this developer info
	*/
	@Override
	public void setWrittenOathPhysical(java.lang.String writtenOathPhysical) {
		_developerInfo.setWrittenOathPhysical(writtenOathPhysical);
	}

	/**
	* Returns the detail ip of this developer info.
	*
	* @return the detail ip of this developer info
	*/
	@Override
	public java.lang.String getDetailIp() {
		return _developerInfo.getDetailIp();
	}

	/**
	* Sets the detail ip of this developer info.
	*
	* @param detailIp the detail ip of this developer info
	*/
	@Override
	public void setDetailIp(java.lang.String detailIp) {
		_developerInfo.setDetailIp(detailIp);
	}

	/**
	* Returns the detail os of this developer info.
	*
	* @return the detail os of this developer info
	*/
	@Override
	public java.lang.String getDetailOs() {
		return _developerInfo.getDetailOs();
	}

	/**
	* Sets the detail os of this developer info.
	*
	* @param detailOs the detail os of this developer info
	*/
	@Override
	public void setDetailOs(java.lang.String detailOs) {
		_developerInfo.setDetailOs(detailOs);
	}

	/**
	* Returns the detail cpu of this developer info.
	*
	* @return the detail cpu of this developer info
	*/
	@Override
	public java.lang.String getDetailCpu() {
		return _developerInfo.getDetailCpu();
	}

	/**
	* Sets the detail cpu of this developer info.
	*
	* @param detailCpu the detail cpu of this developer info
	*/
	@Override
	public void setDetailCpu(java.lang.String detailCpu) {
		_developerInfo.setDetailCpu(detailCpu);
	}

	/**
	* Returns the detail storate of this developer info.
	*
	* @return the detail storate of this developer info
	*/
	@Override
	public java.lang.String getDetailStorate() {
		return _developerInfo.getDetailStorate();
	}

	/**
	* Sets the detail storate of this developer info.
	*
	* @param detailStorate the detail storate of this developer info
	*/
	@Override
	public void setDetailStorate(java.lang.String detailStorate) {
		_developerInfo.setDetailStorate(detailStorate);
	}

	/**
	* Returns the detail library of this developer info.
	*
	* @return the detail library of this developer info
	*/
	@Override
	public java.lang.String getDetailLibrary() {
		return _developerInfo.getDetailLibrary();
	}

	/**
	* Sets the detail library of this developer info.
	*
	* @param detailLibrary the detail library of this developer info
	*/
	@Override
	public void setDetailLibrary(java.lang.String detailLibrary) {
		_developerInfo.setDetailLibrary(detailLibrary);
	}

	/**
	* Returns the insert ID of this developer info.
	*
	* @return the insert ID of this developer info
	*/
	@Override
	public long getInsertId() {
		return _developerInfo.getInsertId();
	}

	/**
	* Sets the insert ID of this developer info.
	*
	* @param insertId the insert ID of this developer info
	*/
	@Override
	public void setInsertId(long insertId) {
		_developerInfo.setInsertId(insertId);
	}

	/**
	* Returns the insert date of this developer info.
	*
	* @return the insert date of this developer info
	*/
	@Override
	public java.util.Date getInsertDate() {
		return _developerInfo.getInsertDate();
	}

	/**
	* Sets the insert date of this developer info.
	*
	* @param insertDate the insert date of this developer info
	*/
	@Override
	public void setInsertDate(java.util.Date insertDate) {
		_developerInfo.setInsertDate(insertDate);
	}

	/**
	* Returns the update ID of this developer info.
	*
	* @return the update ID of this developer info
	*/
	@Override
	public long getUpdateId() {
		return _developerInfo.getUpdateId();
	}

	/**
	* Sets the update ID of this developer info.
	*
	* @param updateId the update ID of this developer info
	*/
	@Override
	public void setUpdateId(long updateId) {
		_developerInfo.setUpdateId(updateId);
	}

	/**
	* Returns the update date of this developer info.
	*
	* @return the update date of this developer info
	*/
	@Override
	public java.util.Date getUpdateDate() {
		return _developerInfo.getUpdateDate();
	}

	/**
	* Sets the update date of this developer info.
	*
	* @param updateDate the update date of this developer info
	*/
	@Override
	public void setUpdateDate(java.util.Date updateDate) {
		_developerInfo.setUpdateDate(updateDate);
	}

	/**
	* Returns the etc of this developer info.
	*
	* @return the etc of this developer info
	*/
	@Override
	public java.lang.String getEtc() {
		return _developerInfo.getEtc();
	}

	/**
	* Returns the localized etc of this developer info in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized etc of this developer info
	*/
	@Override
	public java.lang.String getEtc(java.util.Locale locale) {
		return _developerInfo.getEtc(locale);
	}

	/**
	* Returns the localized etc of this developer info in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized etc of this developer info. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getEtc(java.util.Locale locale, boolean useDefault) {
		return _developerInfo.getEtc(locale, useDefault);
	}

	/**
	* Returns the localized etc of this developer info in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized etc of this developer info
	*/
	@Override
	public java.lang.String getEtc(java.lang.String languageId) {
		return _developerInfo.getEtc(languageId);
	}

	/**
	* Returns the localized etc of this developer info in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized etc of this developer info
	*/
	@Override
	public java.lang.String getEtc(java.lang.String languageId,
		boolean useDefault) {
		return _developerInfo.getEtc(languageId, useDefault);
	}

	@Override
	public java.lang.String getEtcCurrentLanguageId() {
		return _developerInfo.getEtcCurrentLanguageId();
	}

	@Override
	public java.lang.String getEtcCurrentValue() {
		return _developerInfo.getEtcCurrentValue();
	}

	/**
	* Returns a map of the locales and localized etcs of this developer info.
	*
	* @return the locales and localized etcs of this developer info
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getEtcMap() {
		return _developerInfo.getEtcMap();
	}

	/**
	* Sets the etc of this developer info.
	*
	* @param etc the etc of this developer info
	*/
	@Override
	public void setEtc(java.lang.String etc) {
		_developerInfo.setEtc(etc);
	}

	/**
	* Sets the localized etc of this developer info in the language.
	*
	* @param etc the localized etc of this developer info
	* @param locale the locale of the language
	*/
	@Override
	public void setEtc(java.lang.String etc, java.util.Locale locale) {
		_developerInfo.setEtc(etc, locale);
	}

	/**
	* Sets the localized etc of this developer info in the language, and sets the default locale.
	*
	* @param etc the localized etc of this developer info
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setEtc(java.lang.String etc, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_developerInfo.setEtc(etc, locale, defaultLocale);
	}

	@Override
	public void setEtcCurrentLanguageId(java.lang.String languageId) {
		_developerInfo.setEtcCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized etcs of this developer info from the map of locales and localized etcs.
	*
	* @param etcMap the locales and localized etcs of this developer info
	*/
	@Override
	public void setEtcMap(
		java.util.Map<java.util.Locale, java.lang.String> etcMap) {
		_developerInfo.setEtcMap(etcMap);
	}

	/**
	* Sets the localized etcs of this developer info from the map of locales and localized etcs, and sets the default locale.
	*
	* @param etcMap the locales and localized etcs of this developer info
	* @param defaultLocale the default locale
	*/
	@Override
	public void setEtcMap(
		java.util.Map<java.util.Locale, java.lang.String> etcMap,
		java.util.Locale defaultLocale) {
		_developerInfo.setEtcMap(etcMap, defaultLocale);
	}

	/**
	* Returns the developer ID of this developer info.
	*
	* @return the developer ID of this developer info
	*/
	@Override
	public java.lang.String getDeveloperId() {
		return _developerInfo.getDeveloperId();
	}

	/**
	* Sets the developer ID of this developer info.
	*
	* @param developerId the developer ID of this developer info
	*/
	@Override
	public void setDeveloperId(java.lang.String developerId) {
		_developerInfo.setDeveloperId(developerId);
	}

	/**
	* Returns the developer password of this developer info.
	*
	* @return the developer password of this developer info
	*/
	@Override
	public java.lang.String getDeveloperPassword() {
		return _developerInfo.getDeveloperPassword();
	}

	/**
	* Sets the developer password of this developer info.
	*
	* @param developerPassword the developer password of this developer info
	*/
	@Override
	public void setDeveloperPassword(java.lang.String developerPassword) {
		_developerInfo.setDeveloperPassword(developerPassword);
	}

	@Override
	public boolean isNew() {
		return _developerInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_developerInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _developerInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_developerInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _developerInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _developerInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_developerInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _developerInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_developerInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_developerInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_developerInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _developerInfo.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _developerInfo.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_developerInfo.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_developerInfo.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new DeveloperInfoWrapper((DeveloperInfo)_developerInfo.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.science.model.DeveloperInfo developerInfo) {
		return _developerInfo.compareTo(developerInfo);
	}

	@Override
	public int hashCode() {
		return _developerInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.science.model.DeveloperInfo> toCacheModel() {
		return _developerInfo.toCacheModel();
	}

	@Override
	public org.kisti.edison.science.model.DeveloperInfo toEscapedModel() {
		return new DeveloperInfoWrapper(_developerInfo.toEscapedModel());
	}

	@Override
	public org.kisti.edison.science.model.DeveloperInfo toUnescapedModel() {
		return new DeveloperInfoWrapper(_developerInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _developerInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _developerInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_developerInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DeveloperInfoWrapper)) {
			return false;
		}

		DeveloperInfoWrapper developerInfoWrapper = (DeveloperInfoWrapper)obj;

		if (Validator.equals(_developerInfo, developerInfoWrapper._developerInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DeveloperInfo getWrappedDeveloperInfo() {
		return _developerInfo;
	}

	@Override
	public DeveloperInfo getWrappedModel() {
		return _developerInfo;
	}

	@Override
	public void resetOriginalValues() {
		_developerInfo.resetOriginalValues();
	}

	private DeveloperInfo _developerInfo;
}