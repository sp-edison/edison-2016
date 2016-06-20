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

package org.kisti.edison.science.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import org.kisti.edison.science.model.CommonModule;
import org.kisti.edison.science.model.CommonModuleModel;
import org.kisti.edison.science.model.CommonModuleSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CommonModule service. Represents a row in the &quot;EDAPP_CommonModule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link org.kisti.edison.science.model.CommonModuleModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommonModuleImpl}.
 * </p>
 *
 * @author EDISON
 * @see CommonModuleImpl
 * @see org.kisti.edison.science.model.CommonModule
 * @see org.kisti.edison.science.model.CommonModuleModel
 * @generated
 */
@JSON(strict = true)
public class CommonModuleModelImpl extends BaseModelImpl<CommonModule>
	implements CommonModuleModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a common module model instance should use the {@link org.kisti.edison.science.model.CommonModule} interface instead.
	 */
	public static final String TABLE_NAME = "EDAPP_CommonModule";
	public static final Object[][] TABLE_COLUMNS = {
			{ "commonModuleId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "moduleName", Types.VARCHAR },
			{ "moduleVersion", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table EDAPP_CommonModule (commonModuleId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,moduleName VARCHAR(75) null,moduleVersion VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table EDAPP_CommonModule";
	public static final String ORDER_BY_JPQL = " ORDER BY commonModule.commonModuleId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY EDAPP_CommonModule.commonModuleId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.org.kisti.edison.science.model.CommonModule"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.org.kisti.edison.science.model.CommonModule"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommonModule toModel(CommonModuleSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommonModule model = new CommonModuleImpl();

		model.setCommonModuleId(soapModel.getCommonModuleId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setModuleName(soapModel.getModuleName());
		model.setModuleVersion(soapModel.getModuleVersion());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommonModule> toModels(CommonModuleSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CommonModule> models = new ArrayList<CommonModule>(soapModels.length);

		for (CommonModuleSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.org.kisti.edison.science.model.CommonModule"));

	public CommonModuleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commonModuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommonModuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commonModuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommonModule.class;
	}

	@Override
	public String getModelClassName() {
		return CommonModule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("commonModuleId", getCommonModuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("moduleName", getModuleName());
		attributes.put("moduleVersion", getModuleVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long commonModuleId = (Long)attributes.get("commonModuleId");

		if (commonModuleId != null) {
			setCommonModuleId(commonModuleId);
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

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
		}

		String moduleVersion = (String)attributes.get("moduleVersion");

		if (moduleVersion != null) {
			setModuleVersion(moduleVersion);
		}
	}

	@JSON
	@Override
	public long getCommonModuleId() {
		return _commonModuleId;
	}

	@Override
	public void setCommonModuleId(long commonModuleId) {
		_commonModuleId = commonModuleId;
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
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getModuleName() {
		if (_moduleName == null) {
			return StringPool.BLANK;
		}
		else {
			return _moduleName;
		}
	}

	@Override
	public void setModuleName(String moduleName) {
		_moduleName = moduleName;
	}

	@JSON
	@Override
	public String getModuleVersion() {
		if (_moduleVersion == null) {
			return StringPool.BLANK;
		}
		else {
			return _moduleVersion;
		}
	}

	@Override
	public void setModuleVersion(String moduleVersion) {
		_moduleVersion = moduleVersion;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CommonModule.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommonModule toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CommonModule)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommonModuleImpl commonModuleImpl = new CommonModuleImpl();

		commonModuleImpl.setCommonModuleId(getCommonModuleId());
		commonModuleImpl.setGroupId(getGroupId());
		commonModuleImpl.setCompanyId(getCompanyId());
		commonModuleImpl.setUserId(getUserId());
		commonModuleImpl.setCreateDate(getCreateDate());
		commonModuleImpl.setModifiedDate(getModifiedDate());
		commonModuleImpl.setModuleName(getModuleName());
		commonModuleImpl.setModuleVersion(getModuleVersion());

		commonModuleImpl.resetOriginalValues();

		return commonModuleImpl;
	}

	@Override
	public int compareTo(CommonModule commonModule) {
		long primaryKey = commonModule.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommonModule)) {
			return false;
		}

		CommonModule commonModule = (CommonModule)obj;

		long primaryKey = commonModule.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<CommonModule> toCacheModel() {
		CommonModuleCacheModel commonModuleCacheModel = new CommonModuleCacheModel();

		commonModuleCacheModel.commonModuleId = getCommonModuleId();

		commonModuleCacheModel.groupId = getGroupId();

		commonModuleCacheModel.companyId = getCompanyId();

		commonModuleCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			commonModuleCacheModel.createDate = createDate.getTime();
		}
		else {
			commonModuleCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commonModuleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commonModuleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commonModuleCacheModel.moduleName = getModuleName();

		String moduleName = commonModuleCacheModel.moduleName;

		if ((moduleName != null) && (moduleName.length() == 0)) {
			commonModuleCacheModel.moduleName = null;
		}

		commonModuleCacheModel.moduleVersion = getModuleVersion();

		String moduleVersion = commonModuleCacheModel.moduleVersion;

		if ((moduleVersion != null) && (moduleVersion.length() == 0)) {
			commonModuleCacheModel.moduleVersion = null;
		}

		return commonModuleCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{commonModuleId=");
		sb.append(getCommonModuleId());
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
		sb.append(", moduleName=");
		sb.append(getModuleName());
		sb.append(", moduleVersion=");
		sb.append(getModuleVersion());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.science.model.CommonModule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>commonModuleId</column-name><column-value><![CDATA[");
		sb.append(getCommonModuleId());
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
			"<column><column-name>moduleName</column-name><column-value><![CDATA[");
		sb.append(getModuleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moduleVersion</column-name><column-value><![CDATA[");
		sb.append(getModuleVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CommonModule.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CommonModule.class
		};
	private long _commonModuleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _moduleName;
	private String _moduleVersion;
	private CommonModule _escapedModel;
}