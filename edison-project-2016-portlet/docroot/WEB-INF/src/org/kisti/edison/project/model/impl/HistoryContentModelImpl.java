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

package org.kisti.edison.project.model.impl;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.kisti.edison.project.model.HistoryContent;
import org.kisti.edison.project.model.HistoryContentModel;
import org.kisti.edison.project.model.HistoryContentSoap;
import org.kisti.edison.project.service.persistence.HistoryContentPK;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the HistoryContent service. Represents a row in the &quot;EDPRJ_HistoryContent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.kisti.edison.project.model.HistoryContentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HistoryContentImpl}.
 * </p>
 *
 * @author EDISON
 * @see HistoryContentImpl
 * @see org.kisti.edison.project.model.HistoryContent
 * @see org.kisti.edison.project.model.HistoryContentModel
 * @generated
 */
@JSON(strict = true)
public class HistoryContentModelImpl extends BaseModelImpl<HistoryContent>
	implements HistoryContentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a history content model instance should use the {@link org.kisti.edison.project.model.HistoryContent} interface instead.
	 */
	public static final String TABLE_NAME = "EDPRJ_HistoryContent";
	public static final Object[][] TABLE_COLUMNS = {
			{ "contentSeq", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "projectCategoryId", Types.BIGINT },
			{ "contentDiv", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "insertId", Types.BIGINT },
			{ "insertDate", Types.TIMESTAMP },
			{ "updateId", Types.BIGINT },
			{ "updateDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table EDPRJ_HistoryContent (contentSeq LONG not null,groupId LONG not null,projectCategoryId LONG not null,contentDiv LONG,title STRING null,insertId LONG,insertDate DATE null,updateId LONG,updateDate DATE null,primary key (contentSeq, groupId, projectCategoryId))";
	public static final String TABLE_SQL_DROP = "drop table EDPRJ_HistoryContent";
	public static final String ORDER_BY_JPQL = " ORDER BY historyContent.id.contentSeq ASC, historyContent.id.groupId ASC, historyContent.id.projectCategoryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY EDPRJ_HistoryContent.contentSeq ASC, EDPRJ_HistoryContent.groupId ASC, EDPRJ_HistoryContent.projectCategoryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.kisti.edison.project.model.HistoryContent"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.kisti.edison.project.model.HistoryContent"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static HistoryContent toModel(HistoryContentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		HistoryContent model = new HistoryContentImpl();

		model.setContentSeq(soapModel.getContentSeq());
		model.setGroupId(soapModel.getGroupId());
		model.setProjectCategoryId(soapModel.getProjectCategoryId());
		model.setContentDiv(soapModel.getContentDiv());
		model.setTitle(soapModel.getTitle());
		model.setInsertId(soapModel.getInsertId());
		model.setInsertDate(soapModel.getInsertDate());
		model.setUpdateId(soapModel.getUpdateId());
		model.setUpdateDate(soapModel.getUpdateDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<HistoryContent> toModels(HistoryContentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<HistoryContent> models = new ArrayList<HistoryContent>(soapModels.length);

		for (HistoryContentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.kisti.edison.project.model.HistoryContent"));

	public HistoryContentModelImpl() {
	}

	@Override
	public HistoryContentPK getPrimaryKey() {
		return new HistoryContentPK(_contentSeq, _groupId, _projectCategoryId);
	}

	@Override
	public void setPrimaryKey(HistoryContentPK primaryKey) {
		setContentSeq(primaryKey.contentSeq);
		setGroupId(primaryKey.groupId);
		setProjectCategoryId(primaryKey.projectCategoryId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new HistoryContentPK(_contentSeq, _groupId, _projectCategoryId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((HistoryContentPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return HistoryContent.class;
	}

	@Override
	public String getModelClassName() {
		return HistoryContent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentSeq", getContentSeq());
		attributes.put("groupId", getGroupId());
		attributes.put("projectCategoryId", getProjectCategoryId());
		attributes.put("contentDiv", getContentDiv());
		attributes.put("title", getTitle());
		attributes.put("insertId", getInsertId());
		attributes.put("insertDate", getInsertDate());
		attributes.put("updateId", getUpdateId());
		attributes.put("updateDate", getUpdateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contentSeq = (Long)attributes.get("contentSeq");

		if (contentSeq != null) {
			setContentSeq(contentSeq);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long projectCategoryId = (Long)attributes.get("projectCategoryId");

		if (projectCategoryId != null) {
			setProjectCategoryId(projectCategoryId);
		}

		Long contentDiv = (Long)attributes.get("contentDiv");

		if (contentDiv != null) {
			setContentDiv(contentDiv);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
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
	}

	@JSON
	@Override
	public long getContentSeq() {
		return _contentSeq;
	}

	@Override
	public void setContentSeq(long contentSeq) {
		_contentSeq = contentSeq;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getProjectCategoryId() {
		return _projectCategoryId;
	}

	@Override
	public void setProjectCategoryId(long projectCategoryId) {
		_projectCategoryId = projectCategoryId;
	}

	@JSON
	@Override
	public long getContentDiv() {
		return _contentDiv;
	}

	@Override
	public void setContentDiv(long contentDiv) {
		_contentDiv = contentDiv;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
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

	@JSON
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

		setTitle(LocalizationUtil.updateLocalization(titleMap, getTitle(),
				"Title", LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public long getInsertId() {
		return _insertId;
	}

	@Override
	public void setInsertId(long insertId) {
		_insertId = insertId;
	}

	@JSON
	@Override
	public Date getInsertDate() {
		return _insertDate;
	}

	@Override
	public void setInsertDate(Date insertDate) {
		_insertDate = insertDate;
	}

	@JSON
	@Override
	public long getUpdateId() {
		return _updateId;
	}

	@Override
	public void setUpdateId(long updateId) {
		_updateId = updateId;
	}

	@JSON
	@Override
	public Date getUpdateDate() {
		return _updateDate;
	}

	@Override
	public void setUpdateDate(Date updateDate) {
		_updateDate = updateDate;
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
	}

	@Override
	public HistoryContent toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (HistoryContent)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		HistoryContentImpl historyContentImpl = new HistoryContentImpl();

		historyContentImpl.setContentSeq(getContentSeq());
		historyContentImpl.setGroupId(getGroupId());
		historyContentImpl.setProjectCategoryId(getProjectCategoryId());
		historyContentImpl.setContentDiv(getContentDiv());
		historyContentImpl.setTitle(getTitle());
		historyContentImpl.setInsertId(getInsertId());
		historyContentImpl.setInsertDate(getInsertDate());
		historyContentImpl.setUpdateId(getUpdateId());
		historyContentImpl.setUpdateDate(getUpdateDate());

		historyContentImpl.resetOriginalValues();

		return historyContentImpl;
	}

	@Override
	public int compareTo(HistoryContent historyContent) {
		HistoryContentPK primaryKey = historyContent.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistoryContent)) {
			return false;
		}

		HistoryContent historyContent = (HistoryContent)obj;

		HistoryContentPK primaryKey = historyContent.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<HistoryContent> toCacheModel() {
		HistoryContentCacheModel historyContentCacheModel = new HistoryContentCacheModel();

		historyContentCacheModel.contentSeq = getContentSeq();

		historyContentCacheModel.groupId = getGroupId();

		historyContentCacheModel.projectCategoryId = getProjectCategoryId();

		historyContentCacheModel.contentDiv = getContentDiv();

		historyContentCacheModel.title = getTitle();

		String title = historyContentCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			historyContentCacheModel.title = null;
		}

		historyContentCacheModel.insertId = getInsertId();

		Date insertDate = getInsertDate();

		if (insertDate != null) {
			historyContentCacheModel.insertDate = insertDate.getTime();
		}
		else {
			historyContentCacheModel.insertDate = Long.MIN_VALUE;
		}

		historyContentCacheModel.updateId = getUpdateId();

		Date updateDate = getUpdateDate();

		if (updateDate != null) {
			historyContentCacheModel.updateDate = updateDate.getTime();
		}
		else {
			historyContentCacheModel.updateDate = Long.MIN_VALUE;
		}

		return historyContentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{contentSeq=");
		sb.append(getContentSeq());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", projectCategoryId=");
		sb.append(getProjectCategoryId());
		sb.append(", contentDiv=");
		sb.append(getContentDiv());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", insertId=");
		sb.append(getInsertId());
		sb.append(", insertDate=");
		sb.append(getInsertDate());
		sb.append(", updateId=");
		sb.append(getUpdateId());
		sb.append(", updateDate=");
		sb.append(getUpdateDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.project.model.HistoryContent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>contentSeq</column-name><column-value><![CDATA[");
		sb.append(getContentSeq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectCategoryId</column-name><column-value><![CDATA[");
		sb.append(getProjectCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentDiv</column-name><column-value><![CDATA[");
		sb.append(getContentDiv());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
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

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = HistoryContent.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			HistoryContent.class
		};
	private long _contentSeq;
	private long _groupId;
	private long _projectCategoryId;
	private long _contentDiv;
	private String _title;
	private String _titleCurrentLanguageId;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
	private HistoryContent _escapedModel;
}