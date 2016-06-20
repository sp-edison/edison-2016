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

package com.kisti.science.platform.app.model;

import com.kisti.science.platform.app.service.ClpSerializer;
import com.kisti.science.platform.app.service.ScienceAppCategoryLinkLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jerry H. Seo & Young Suh
 */
public class ScienceAppCategoryLinkClp extends BaseModelImpl<ScienceAppCategoryLink>
	implements ScienceAppCategoryLink {
	public ScienceAppCategoryLinkClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ScienceAppCategoryLink.class;
	}

	@Override
	public String getModelClassName() {
		return ScienceAppCategoryLink.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _scienceAppCategoryLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScienceAppCategoryLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scienceAppCategoryLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("scienceAppCategoryLinkId", getScienceAppCategoryLinkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("categoryId", getCategoryId());
		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("parentCategoryId", getParentCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long scienceAppCategoryLinkId = (Long)attributes.get(
				"scienceAppCategoryLinkId");

		if (scienceAppCategoryLinkId != null) {
			setScienceAppCategoryLinkId(scienceAppCategoryLinkId);
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

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		Long parentCategoryId = (Long)attributes.get("parentCategoryId");

		if (parentCategoryId != null) {
			setParentCategoryId(parentCategoryId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_scienceAppCategoryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppCategoryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_scienceAppCategoryLinkRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getScienceAppCategoryLinkId() {
		return _scienceAppCategoryLinkId;
	}

	@Override
	public void setScienceAppCategoryLinkId(long scienceAppCategoryLinkId) {
		_scienceAppCategoryLinkId = scienceAppCategoryLinkId;

		if (_scienceAppCategoryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppCategoryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setScienceAppCategoryLinkId",
						long.class);

				method.invoke(_scienceAppCategoryLinkRemoteModel,
					scienceAppCategoryLinkId);
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

		if (_scienceAppCategoryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppCategoryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_scienceAppCategoryLinkRemoteModel, groupId);
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

		if (_scienceAppCategoryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppCategoryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_scienceAppCategoryLinkRemoteModel, companyId);
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

		if (_scienceAppCategoryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppCategoryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_scienceAppCategoryLinkRemoteModel, userId);
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

		if (_scienceAppCategoryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppCategoryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_scienceAppCategoryLinkRemoteModel, createDate);
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

		if (_scienceAppCategoryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppCategoryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_scienceAppCategoryLinkRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_scienceAppCategoryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppCategoryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_scienceAppCategoryLinkRemoteModel, categoryId);
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

		if (_scienceAppCategoryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppCategoryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setScienceAppId", long.class);

				method.invoke(_scienceAppCategoryLinkRemoteModel, scienceAppId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentCategoryId() {
		return _parentCategoryId;
	}

	@Override
	public void setParentCategoryId(long parentCategoryId) {
		_parentCategoryId = parentCategoryId;

		if (_scienceAppCategoryLinkRemoteModel != null) {
			try {
				Class<?> clazz = _scienceAppCategoryLinkRemoteModel.getClass();

				Method method = clazz.getMethod("setParentCategoryId",
						long.class);

				method.invoke(_scienceAppCategoryLinkRemoteModel,
					parentCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ScienceAppCategoryLink.class.getName()));
	}

	public BaseModel<?> getScienceAppCategoryLinkRemoteModel() {
		return _scienceAppCategoryLinkRemoteModel;
	}

	public void setScienceAppCategoryLinkRemoteModel(
		BaseModel<?> scienceAppCategoryLinkRemoteModel) {
		_scienceAppCategoryLinkRemoteModel = scienceAppCategoryLinkRemoteModel;
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

		Class<?> remoteModelClass = _scienceAppCategoryLinkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_scienceAppCategoryLinkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ScienceAppCategoryLinkLocalServiceUtil.addScienceAppCategoryLink(this);
		}
		else {
			ScienceAppCategoryLinkLocalServiceUtil.updateScienceAppCategoryLink(this);
		}
	}

	@Override
	public ScienceAppCategoryLink toEscapedModel() {
		return (ScienceAppCategoryLink)ProxyUtil.newProxyInstance(ScienceAppCategoryLink.class.getClassLoader(),
			new Class[] { ScienceAppCategoryLink.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScienceAppCategoryLinkClp clone = new ScienceAppCategoryLinkClp();

		clone.setUuid(getUuid());
		clone.setScienceAppCategoryLinkId(getScienceAppCategoryLinkId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCategoryId(getCategoryId());
		clone.setScienceAppId(getScienceAppId());
		clone.setParentCategoryId(getParentCategoryId());

		return clone;
	}

	@Override
	public int compareTo(ScienceAppCategoryLink scienceAppCategoryLink) {
		long primaryKey = scienceAppCategoryLink.getPrimaryKey();

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

		if (!(obj instanceof ScienceAppCategoryLinkClp)) {
			return false;
		}

		ScienceAppCategoryLinkClp scienceAppCategoryLink = (ScienceAppCategoryLinkClp)obj;

		long primaryKey = scienceAppCategoryLink.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", scienceAppCategoryLinkId=");
		sb.append(getScienceAppCategoryLinkId());
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
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", scienceAppId=");
		sb.append(getScienceAppId());
		sb.append(", parentCategoryId=");
		sb.append(getParentCategoryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.kisti.science.platform.app.model.ScienceAppCategoryLink");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scienceAppCategoryLinkId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppCategoryLinkId());
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
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scienceAppId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentCategoryId</column-name><column-value><![CDATA[");
		sb.append(getParentCategoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _scienceAppCategoryLinkId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _categoryId;
	private long _scienceAppId;
	private long _parentCategoryId;
	private BaseModel<?> _scienceAppCategoryLinkRemoteModel;
	private Class<?> _clpSerializerClass = com.kisti.science.platform.app.service.ClpSerializer.class;
}