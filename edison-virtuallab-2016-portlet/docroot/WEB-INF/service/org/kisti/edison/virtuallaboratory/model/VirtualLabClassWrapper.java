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

package org.kisti.edison.virtuallaboratory.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VirtualLabClass}.
 * </p>
 *
 * @author EDISON
 * @see VirtualLabClass
 * @generated
 */
public class VirtualLabClassWrapper implements VirtualLabClass,
	ModelWrapper<VirtualLabClass> {
	public VirtualLabClassWrapper(VirtualLabClass virtualLabClass) {
		_virtualLabClass = virtualLabClass;
	}

	@Override
	public Class<?> getModelClass() {
		return VirtualLabClass.class;
	}

	@Override
	public String getModelClassName() {
		return VirtualLabClass.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("classId", getClassId());
		attributes.put("classTitle", getClassTitle());
		attributes.put("classStartDt", getClassStartDt());
		attributes.put("classEndDt", getClassEndDt());
		attributes.put("classUseYn", getClassUseYn());
		attributes.put("classDescription", getClassDescription());
		attributes.put("classPersonnel", getClassPersonnel());
		attributes.put("classCreateDt", getClassCreateDt());
		attributes.put("classUpdateDt", getClassUpdateDt());
		attributes.put("virtualClassCd", getVirtualClassCd());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long classId = (Long)attributes.get("classId");

		if (classId != null) {
			setClassId(classId);
		}

		String classTitle = (String)attributes.get("classTitle");

		if (classTitle != null) {
			setClassTitle(classTitle);
		}

		String classStartDt = (String)attributes.get("classStartDt");

		if (classStartDt != null) {
			setClassStartDt(classStartDt);
		}

		String classEndDt = (String)attributes.get("classEndDt");

		if (classEndDt != null) {
			setClassEndDt(classEndDt);
		}

		String classUseYn = (String)attributes.get("classUseYn");

		if (classUseYn != null) {
			setClassUseYn(classUseYn);
		}

		String classDescription = (String)attributes.get("classDescription");

		if (classDescription != null) {
			setClassDescription(classDescription);
		}

		Integer classPersonnel = (Integer)attributes.get("classPersonnel");

		if (classPersonnel != null) {
			setClassPersonnel(classPersonnel);
		}

		Date classCreateDt = (Date)attributes.get("classCreateDt");

		if (classCreateDt != null) {
			setClassCreateDt(classCreateDt);
		}

		Date classUpdateDt = (Date)attributes.get("classUpdateDt");

		if (classUpdateDt != null) {
			setClassUpdateDt(classUpdateDt);
		}

		String virtualClassCd = (String)attributes.get("virtualClassCd");

		if (virtualClassCd != null) {
			setVirtualClassCd(virtualClassCd);
		}
	}

	/**
	* Returns the primary key of this virtual lab class.
	*
	* @return the primary key of this virtual lab class
	*/
	@Override
	public long getPrimaryKey() {
		return _virtualLabClass.getPrimaryKey();
	}

	/**
	* Sets the primary key of this virtual lab class.
	*
	* @param primaryKey the primary key of this virtual lab class
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_virtualLabClass.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the class ID of this virtual lab class.
	*
	* @return the class ID of this virtual lab class
	*/
	@Override
	public long getClassId() {
		return _virtualLabClass.getClassId();
	}

	/**
	* Sets the class ID of this virtual lab class.
	*
	* @param classId the class ID of this virtual lab class
	*/
	@Override
	public void setClassId(long classId) {
		_virtualLabClass.setClassId(classId);
	}

	/**
	* Returns the class title of this virtual lab class.
	*
	* @return the class title of this virtual lab class
	*/
	@Override
	public java.lang.String getClassTitle() {
		return _virtualLabClass.getClassTitle();
	}

	/**
	* Returns the localized class title of this virtual lab class in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized class title of this virtual lab class
	*/
	@Override
	public java.lang.String getClassTitle(java.util.Locale locale) {
		return _virtualLabClass.getClassTitle(locale);
	}

	/**
	* Returns the localized class title of this virtual lab class in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized class title of this virtual lab class. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getClassTitle(java.util.Locale locale,
		boolean useDefault) {
		return _virtualLabClass.getClassTitle(locale, useDefault);
	}

	/**
	* Returns the localized class title of this virtual lab class in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized class title of this virtual lab class
	*/
	@Override
	public java.lang.String getClassTitle(java.lang.String languageId) {
		return _virtualLabClass.getClassTitle(languageId);
	}

	/**
	* Returns the localized class title of this virtual lab class in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized class title of this virtual lab class
	*/
	@Override
	public java.lang.String getClassTitle(java.lang.String languageId,
		boolean useDefault) {
		return _virtualLabClass.getClassTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getClassTitleCurrentLanguageId() {
		return _virtualLabClass.getClassTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getClassTitleCurrentValue() {
		return _virtualLabClass.getClassTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized class titles of this virtual lab class.
	*
	* @return the locales and localized class titles of this virtual lab class
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getClassTitleMap() {
		return _virtualLabClass.getClassTitleMap();
	}

	/**
	* Sets the class title of this virtual lab class.
	*
	* @param classTitle the class title of this virtual lab class
	*/
	@Override
	public void setClassTitle(java.lang.String classTitle) {
		_virtualLabClass.setClassTitle(classTitle);
	}

	/**
	* Sets the localized class title of this virtual lab class in the language.
	*
	* @param classTitle the localized class title of this virtual lab class
	* @param locale the locale of the language
	*/
	@Override
	public void setClassTitle(java.lang.String classTitle,
		java.util.Locale locale) {
		_virtualLabClass.setClassTitle(classTitle, locale);
	}

	/**
	* Sets the localized class title of this virtual lab class in the language, and sets the default locale.
	*
	* @param classTitle the localized class title of this virtual lab class
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setClassTitle(java.lang.String classTitle,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_virtualLabClass.setClassTitle(classTitle, locale, defaultLocale);
	}

	@Override
	public void setClassTitleCurrentLanguageId(java.lang.String languageId) {
		_virtualLabClass.setClassTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized class titles of this virtual lab class from the map of locales and localized class titles.
	*
	* @param classTitleMap the locales and localized class titles of this virtual lab class
	*/
	@Override
	public void setClassTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> classTitleMap) {
		_virtualLabClass.setClassTitleMap(classTitleMap);
	}

	/**
	* Sets the localized class titles of this virtual lab class from the map of locales and localized class titles, and sets the default locale.
	*
	* @param classTitleMap the locales and localized class titles of this virtual lab class
	* @param defaultLocale the default locale
	*/
	@Override
	public void setClassTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> classTitleMap,
		java.util.Locale defaultLocale) {
		_virtualLabClass.setClassTitleMap(classTitleMap, defaultLocale);
	}

	/**
	* Returns the class start dt of this virtual lab class.
	*
	* @return the class start dt of this virtual lab class
	*/
	@Override
	public java.lang.String getClassStartDt() {
		return _virtualLabClass.getClassStartDt();
	}

	/**
	* Sets the class start dt of this virtual lab class.
	*
	* @param classStartDt the class start dt of this virtual lab class
	*/
	@Override
	public void setClassStartDt(java.lang.String classStartDt) {
		_virtualLabClass.setClassStartDt(classStartDt);
	}

	/**
	* Returns the class end dt of this virtual lab class.
	*
	* @return the class end dt of this virtual lab class
	*/
	@Override
	public java.lang.String getClassEndDt() {
		return _virtualLabClass.getClassEndDt();
	}

	/**
	* Sets the class end dt of this virtual lab class.
	*
	* @param classEndDt the class end dt of this virtual lab class
	*/
	@Override
	public void setClassEndDt(java.lang.String classEndDt) {
		_virtualLabClass.setClassEndDt(classEndDt);
	}

	/**
	* Returns the class use yn of this virtual lab class.
	*
	* @return the class use yn of this virtual lab class
	*/
	@Override
	public java.lang.String getClassUseYn() {
		return _virtualLabClass.getClassUseYn();
	}

	/**
	* Sets the class use yn of this virtual lab class.
	*
	* @param classUseYn the class use yn of this virtual lab class
	*/
	@Override
	public void setClassUseYn(java.lang.String classUseYn) {
		_virtualLabClass.setClassUseYn(classUseYn);
	}

	/**
	* Returns the class description of this virtual lab class.
	*
	* @return the class description of this virtual lab class
	*/
	@Override
	public java.lang.String getClassDescription() {
		return _virtualLabClass.getClassDescription();
	}

	/**
	* Returns the localized class description of this virtual lab class in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized class description of this virtual lab class
	*/
	@Override
	public java.lang.String getClassDescription(java.util.Locale locale) {
		return _virtualLabClass.getClassDescription(locale);
	}

	/**
	* Returns the localized class description of this virtual lab class in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized class description of this virtual lab class. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getClassDescription(java.util.Locale locale,
		boolean useDefault) {
		return _virtualLabClass.getClassDescription(locale, useDefault);
	}

	/**
	* Returns the localized class description of this virtual lab class in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized class description of this virtual lab class
	*/
	@Override
	public java.lang.String getClassDescription(java.lang.String languageId) {
		return _virtualLabClass.getClassDescription(languageId);
	}

	/**
	* Returns the localized class description of this virtual lab class in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized class description of this virtual lab class
	*/
	@Override
	public java.lang.String getClassDescription(java.lang.String languageId,
		boolean useDefault) {
		return _virtualLabClass.getClassDescription(languageId, useDefault);
	}

	@Override
	public java.lang.String getClassDescriptionCurrentLanguageId() {
		return _virtualLabClass.getClassDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getClassDescriptionCurrentValue() {
		return _virtualLabClass.getClassDescriptionCurrentValue();
	}

	/**
	* Returns a map of the locales and localized class descriptions of this virtual lab class.
	*
	* @return the locales and localized class descriptions of this virtual lab class
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getClassDescriptionMap() {
		return _virtualLabClass.getClassDescriptionMap();
	}

	/**
	* Sets the class description of this virtual lab class.
	*
	* @param classDescription the class description of this virtual lab class
	*/
	@Override
	public void setClassDescription(java.lang.String classDescription) {
		_virtualLabClass.setClassDescription(classDescription);
	}

	/**
	* Sets the localized class description of this virtual lab class in the language.
	*
	* @param classDescription the localized class description of this virtual lab class
	* @param locale the locale of the language
	*/
	@Override
	public void setClassDescription(java.lang.String classDescription,
		java.util.Locale locale) {
		_virtualLabClass.setClassDescription(classDescription, locale);
	}

	/**
	* Sets the localized class description of this virtual lab class in the language, and sets the default locale.
	*
	* @param classDescription the localized class description of this virtual lab class
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setClassDescription(java.lang.String classDescription,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_virtualLabClass.setClassDescription(classDescription, locale,
			defaultLocale);
	}

	@Override
	public void setClassDescriptionCurrentLanguageId(
		java.lang.String languageId) {
		_virtualLabClass.setClassDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized class descriptions of this virtual lab class from the map of locales and localized class descriptions.
	*
	* @param classDescriptionMap the locales and localized class descriptions of this virtual lab class
	*/
	@Override
	public void setClassDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> classDescriptionMap) {
		_virtualLabClass.setClassDescriptionMap(classDescriptionMap);
	}

	/**
	* Sets the localized class descriptions of this virtual lab class from the map of locales and localized class descriptions, and sets the default locale.
	*
	* @param classDescriptionMap the locales and localized class descriptions of this virtual lab class
	* @param defaultLocale the default locale
	*/
	@Override
	public void setClassDescriptionMap(
		java.util.Map<java.util.Locale, java.lang.String> classDescriptionMap,
		java.util.Locale defaultLocale) {
		_virtualLabClass.setClassDescriptionMap(classDescriptionMap,
			defaultLocale);
	}

	/**
	* Returns the class personnel of this virtual lab class.
	*
	* @return the class personnel of this virtual lab class
	*/
	@Override
	public int getClassPersonnel() {
		return _virtualLabClass.getClassPersonnel();
	}

	/**
	* Sets the class personnel of this virtual lab class.
	*
	* @param classPersonnel the class personnel of this virtual lab class
	*/
	@Override
	public void setClassPersonnel(int classPersonnel) {
		_virtualLabClass.setClassPersonnel(classPersonnel);
	}

	/**
	* Returns the class create dt of this virtual lab class.
	*
	* @return the class create dt of this virtual lab class
	*/
	@Override
	public java.util.Date getClassCreateDt() {
		return _virtualLabClass.getClassCreateDt();
	}

	/**
	* Sets the class create dt of this virtual lab class.
	*
	* @param classCreateDt the class create dt of this virtual lab class
	*/
	@Override
	public void setClassCreateDt(java.util.Date classCreateDt) {
		_virtualLabClass.setClassCreateDt(classCreateDt);
	}

	/**
	* Returns the class update dt of this virtual lab class.
	*
	* @return the class update dt of this virtual lab class
	*/
	@Override
	public java.util.Date getClassUpdateDt() {
		return _virtualLabClass.getClassUpdateDt();
	}

	/**
	* Sets the class update dt of this virtual lab class.
	*
	* @param classUpdateDt the class update dt of this virtual lab class
	*/
	@Override
	public void setClassUpdateDt(java.util.Date classUpdateDt) {
		_virtualLabClass.setClassUpdateDt(classUpdateDt);
	}

	/**
	* Returns the virtual class cd of this virtual lab class.
	*
	* @return the virtual class cd of this virtual lab class
	*/
	@Override
	public java.lang.String getVirtualClassCd() {
		return _virtualLabClass.getVirtualClassCd();
	}

	/**
	* Sets the virtual class cd of this virtual lab class.
	*
	* @param virtualClassCd the virtual class cd of this virtual lab class
	*/
	@Override
	public void setVirtualClassCd(java.lang.String virtualClassCd) {
		_virtualLabClass.setVirtualClassCd(virtualClassCd);
	}

	@Override
	public boolean isNew() {
		return _virtualLabClass.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_virtualLabClass.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _virtualLabClass.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_virtualLabClass.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _virtualLabClass.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _virtualLabClass.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_virtualLabClass.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _virtualLabClass.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_virtualLabClass.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_virtualLabClass.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_virtualLabClass.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _virtualLabClass.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _virtualLabClass.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_virtualLabClass.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_virtualLabClass.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new VirtualLabClassWrapper((VirtualLabClass)_virtualLabClass.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass) {
		return _virtualLabClass.compareTo(virtualLabClass);
	}

	@Override
	public int hashCode() {
		return _virtualLabClass.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> toCacheModel() {
		return _virtualLabClass.toCacheModel();
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass toEscapedModel() {
		return new VirtualLabClassWrapper(_virtualLabClass.toEscapedModel());
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClass toUnescapedModel() {
		return new VirtualLabClassWrapper(_virtualLabClass.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _virtualLabClass.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _virtualLabClass.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClass.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VirtualLabClassWrapper)) {
			return false;
		}

		VirtualLabClassWrapper virtualLabClassWrapper = (VirtualLabClassWrapper)obj;

		if (Validator.equals(_virtualLabClass,
					virtualLabClassWrapper._virtualLabClass)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VirtualLabClass getWrappedVirtualLabClass() {
		return _virtualLabClass;
	}

	@Override
	public VirtualLabClass getWrappedModel() {
		return _virtualLabClass;
	}

	@Override
	public void resetOriginalValues() {
		_virtualLabClass.resetOriginalValues();
	}

	private VirtualLabClass _virtualLabClass;
}