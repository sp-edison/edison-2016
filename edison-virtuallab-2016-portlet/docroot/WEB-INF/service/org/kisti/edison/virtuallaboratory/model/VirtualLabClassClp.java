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

import org.kisti.edison.virtuallaboratory.service.ClpSerializer;
import org.kisti.edison.virtuallaboratory.service.VirtualLabClassLocalServiceUtil;

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
public class VirtualLabClassClp extends BaseModelImpl<VirtualLabClass>
	implements VirtualLabClass {
	public VirtualLabClassClp() {
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
	public long getPrimaryKey() {
		return _classId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setClassId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _classId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getClassId() {
		return _classId;
	}

	@Override
	public void setClassId(long classId) {
		_classId = classId;

		if (_virtualLabClassRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabClassRemoteModel.getClass();

				Method method = clazz.getMethod("setClassId", long.class);

				method.invoke(_virtualLabClassRemoteModel, classId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassTitle() {
		return _classTitle;
	}

	@Override
	public String getClassTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getClassTitle(languageId);
	}

	@Override
	public String getClassTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getClassTitle(languageId, useDefault);
	}

	@Override
	public String getClassTitle(String languageId) {
		return LocalizationUtil.getLocalization(getClassTitle(), languageId);
	}

	@Override
	public String getClassTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getClassTitle(), languageId,
			useDefault);
	}

	@Override
	public String getClassTitleCurrentLanguageId() {
		return _classTitleCurrentLanguageId;
	}

	@Override
	public String getClassTitleCurrentValue() {
		Locale locale = getLocale(_classTitleCurrentLanguageId);

		return getClassTitle(locale);
	}

	@Override
	public Map<Locale, String> getClassTitleMap() {
		return LocalizationUtil.getLocalizationMap(getClassTitle());
	}

	@Override
	public void setClassTitle(String classTitle) {
		_classTitle = classTitle;

		if (_virtualLabClassRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabClassRemoteModel.getClass();

				Method method = clazz.getMethod("setClassTitle", String.class);

				method.invoke(_virtualLabClassRemoteModel, classTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setClassTitle(String classTitle, Locale locale) {
		setClassTitle(classTitle, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setClassTitle(String classTitle, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(classTitle)) {
			setClassTitle(LocalizationUtil.updateLocalization(getClassTitle(),
					"ClassTitle", classTitle, languageId, defaultLanguageId));
		}
		else {
			setClassTitle(LocalizationUtil.removeLocalization(getClassTitle(),
					"ClassTitle", languageId));
		}
	}

	@Override
	public void setClassTitleCurrentLanguageId(String languageId) {
		_classTitleCurrentLanguageId = languageId;
	}

	@Override
	public void setClassTitleMap(Map<Locale, String> classTitleMap) {
		setClassTitleMap(classTitleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setClassTitleMap(Map<Locale, String> classTitleMap,
		Locale defaultLocale) {
		if (classTitleMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setClassTitle(LocalizationUtil.updateLocalization(classTitleMap,
					getClassTitle(), "ClassTitle",
					LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public String getClassStartDt() {
		return _classStartDt;
	}

	@Override
	public void setClassStartDt(String classStartDt) {
		_classStartDt = classStartDt;

		if (_virtualLabClassRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabClassRemoteModel.getClass();

				Method method = clazz.getMethod("setClassStartDt", String.class);

				method.invoke(_virtualLabClassRemoteModel, classStartDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassEndDt() {
		return _classEndDt;
	}

	@Override
	public void setClassEndDt(String classEndDt) {
		_classEndDt = classEndDt;

		if (_virtualLabClassRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabClassRemoteModel.getClass();

				Method method = clazz.getMethod("setClassEndDt", String.class);

				method.invoke(_virtualLabClassRemoteModel, classEndDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassUseYn() {
		return _classUseYn;
	}

	@Override
	public void setClassUseYn(String classUseYn) {
		_classUseYn = classUseYn;

		if (_virtualLabClassRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabClassRemoteModel.getClass();

				Method method = clazz.getMethod("setClassUseYn", String.class);

				method.invoke(_virtualLabClassRemoteModel, classUseYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassDescription() {
		return _classDescription;
	}

	@Override
	public String getClassDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getClassDescription(languageId);
	}

	@Override
	public String getClassDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getClassDescription(languageId, useDefault);
	}

	@Override
	public String getClassDescription(String languageId) {
		return LocalizationUtil.getLocalization(getClassDescription(),
			languageId);
	}

	@Override
	public String getClassDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getClassDescription(),
			languageId, useDefault);
	}

	@Override
	public String getClassDescriptionCurrentLanguageId() {
		return _classDescriptionCurrentLanguageId;
	}

	@Override
	public String getClassDescriptionCurrentValue() {
		Locale locale = getLocale(_classDescriptionCurrentLanguageId);

		return getClassDescription(locale);
	}

	@Override
	public Map<Locale, String> getClassDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getClassDescription());
	}

	@Override
	public void setClassDescription(String classDescription) {
		_classDescription = classDescription;

		if (_virtualLabClassRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabClassRemoteModel.getClass();

				Method method = clazz.getMethod("setClassDescription",
						String.class);

				method.invoke(_virtualLabClassRemoteModel, classDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setClassDescription(String classDescription, Locale locale) {
		setClassDescription(classDescription, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setClassDescription(String classDescription, Locale locale,
		Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(classDescription)) {
			setClassDescription(LocalizationUtil.updateLocalization(
					getClassDescription(), "ClassDescription",
					classDescription, languageId, defaultLanguageId));
		}
		else {
			setClassDescription(LocalizationUtil.removeLocalization(
					getClassDescription(), "ClassDescription", languageId));
		}
	}

	@Override
	public void setClassDescriptionCurrentLanguageId(String languageId) {
		_classDescriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setClassDescriptionMap(Map<Locale, String> classDescriptionMap) {
		setClassDescriptionMap(classDescriptionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setClassDescriptionMap(
		Map<Locale, String> classDescriptionMap, Locale defaultLocale) {
		if (classDescriptionMap == null) {
			return;
		}

		ClassLoader portalClassLoader = PortalClassLoaderUtil.getClassLoader();

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(portalClassLoader);
			}

			setClassDescription(LocalizationUtil.updateLocalization(
					classDescriptionMap, getClassDescription(),
					"ClassDescription", LocaleUtil.toLanguageId(defaultLocale)));
		}
		finally {
			if (contextClassLoader != portalClassLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	@Override
	public int getClassPersonnel() {
		return _classPersonnel;
	}

	@Override
	public void setClassPersonnel(int classPersonnel) {
		_classPersonnel = classPersonnel;

		if (_virtualLabClassRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabClassRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPersonnel", int.class);

				method.invoke(_virtualLabClassRemoteModel, classPersonnel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getClassCreateDt() {
		return _classCreateDt;
	}

	@Override
	public void setClassCreateDt(Date classCreateDt) {
		_classCreateDt = classCreateDt;

		if (_virtualLabClassRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabClassRemoteModel.getClass();

				Method method = clazz.getMethod("setClassCreateDt", Date.class);

				method.invoke(_virtualLabClassRemoteModel, classCreateDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getClassUpdateDt() {
		return _classUpdateDt;
	}

	@Override
	public void setClassUpdateDt(Date classUpdateDt) {
		_classUpdateDt = classUpdateDt;

		if (_virtualLabClassRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabClassRemoteModel.getClass();

				Method method = clazz.getMethod("setClassUpdateDt", Date.class);

				method.invoke(_virtualLabClassRemoteModel, classUpdateDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVirtualClassCd() {
		return _virtualClassCd;
	}

	@Override
	public void setVirtualClassCd(String virtualClassCd) {
		_virtualClassCd = virtualClassCd;

		if (_virtualLabClassRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabClassRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualClassCd",
						String.class);

				method.invoke(_virtualLabClassRemoteModel, virtualClassCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVirtualLabClassRemoteModel() {
		return _virtualLabClassRemoteModel;
	}

	public void setVirtualLabClassRemoteModel(
		BaseModel<?> virtualLabClassRemoteModel) {
		_virtualLabClassRemoteModel = virtualLabClassRemoteModel;
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

		Class<?> remoteModelClass = _virtualLabClassRemoteModel.getClass();

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

		Object returnValue = method.invoke(_virtualLabClassRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VirtualLabClassLocalServiceUtil.addVirtualLabClass(this);
		}
		else {
			VirtualLabClassLocalServiceUtil.updateVirtualLabClass(this);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> classTitleMap = getClassTitleMap();

		for (Map.Entry<Locale, String> entry : classTitleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> classDescriptionMap = getClassDescriptionMap();

		for (Map.Entry<Locale, String> entry : classDescriptionMap.entrySet()) {
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
		String xml = getClassTitle();

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

		String classTitle = getClassTitle(defaultLocale);

		if (Validator.isNull(classTitle)) {
			setClassTitle(getClassTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setClassTitle(getClassTitle(defaultLocale), defaultLocale,
				defaultLocale);
		}

		String classDescription = getClassDescription(defaultLocale);

		if (Validator.isNull(classDescription)) {
			setClassDescription(getClassDescription(modelDefaultLanguageId),
				defaultLocale);
		}
		else {
			setClassDescription(getClassDescription(defaultLocale),
				defaultLocale, defaultLocale);
		}
	}

	@Override
	public VirtualLabClass toEscapedModel() {
		return (VirtualLabClass)ProxyUtil.newProxyInstance(VirtualLabClass.class.getClassLoader(),
			new Class[] { VirtualLabClass.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VirtualLabClassClp clone = new VirtualLabClassClp();

		clone.setClassId(getClassId());
		clone.setClassTitle(getClassTitle());
		clone.setClassStartDt(getClassStartDt());
		clone.setClassEndDt(getClassEndDt());
		clone.setClassUseYn(getClassUseYn());
		clone.setClassDescription(getClassDescription());
		clone.setClassPersonnel(getClassPersonnel());
		clone.setClassCreateDt(getClassCreateDt());
		clone.setClassUpdateDt(getClassUpdateDt());
		clone.setVirtualClassCd(getVirtualClassCd());

		return clone;
	}

	@Override
	public int compareTo(VirtualLabClass virtualLabClass) {
		int value = 0;

		value = DateUtil.compareTo(getClassCreateDt(),
				virtualLabClass.getClassCreateDt());

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

		if (!(obj instanceof VirtualLabClassClp)) {
			return false;
		}

		VirtualLabClassClp virtualLabClass = (VirtualLabClassClp)obj;

		long primaryKey = virtualLabClass.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{classId=");
		sb.append(getClassId());
		sb.append(", classTitle=");
		sb.append(getClassTitle());
		sb.append(", classStartDt=");
		sb.append(getClassStartDt());
		sb.append(", classEndDt=");
		sb.append(getClassEndDt());
		sb.append(", classUseYn=");
		sb.append(getClassUseYn());
		sb.append(", classDescription=");
		sb.append(getClassDescription());
		sb.append(", classPersonnel=");
		sb.append(getClassPersonnel());
		sb.append(", classCreateDt=");
		sb.append(getClassCreateDt());
		sb.append(", classUpdateDt=");
		sb.append(getClassUpdateDt());
		sb.append(", virtualClassCd=");
		sb.append(getVirtualClassCd());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.virtuallaboratory.model.VirtualLabClass");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>classId</column-name><column-value><![CDATA[");
		sb.append(getClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classTitle</column-name><column-value><![CDATA[");
		sb.append(getClassTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classStartDt</column-name><column-value><![CDATA[");
		sb.append(getClassStartDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classEndDt</column-name><column-value><![CDATA[");
		sb.append(getClassEndDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classUseYn</column-name><column-value><![CDATA[");
		sb.append(getClassUseYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classDescription</column-name><column-value><![CDATA[");
		sb.append(getClassDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPersonnel</column-name><column-value><![CDATA[");
		sb.append(getClassPersonnel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classCreateDt</column-name><column-value><![CDATA[");
		sb.append(getClassCreateDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classUpdateDt</column-name><column-value><![CDATA[");
		sb.append(getClassUpdateDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualClassCd</column-name><column-value><![CDATA[");
		sb.append(getVirtualClassCd());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _classId;
	private String _classTitle;
	private String _classTitleCurrentLanguageId;
	private String _classStartDt;
	private String _classEndDt;
	private String _classUseYn;
	private String _classDescription;
	private String _classDescriptionCurrentLanguageId;
	private int _classPersonnel;
	private Date _classCreateDt;
	private Date _classUpdateDt;
	private String _virtualClassCd;
	private BaseModel<?> _virtualLabClassRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.virtuallaboratory.service.ClpSerializer.class;
}