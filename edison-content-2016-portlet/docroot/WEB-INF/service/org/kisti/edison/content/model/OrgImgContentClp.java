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

package org.kisti.edison.content.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.kisti.edison.content.service.ClpSerializer;
import org.kisti.edison.content.service.OrgImgContentLocalServiceUtil;
import org.kisti.edison.content.service.persistence.OrgImgContentPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class OrgImgContentClp extends BaseModelImpl<OrgImgContent>
	implements OrgImgContent {
	public OrgImgContentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return OrgImgContent.class;
	}

	@Override
	public String getModelClassName() {
		return OrgImgContent.class.getName();
	}

	@Override
	public OrgImgContentPK getPrimaryKey() {
		return new OrgImgContentPK(_orgImgSeq, _groupId);
	}

	@Override
	public void setPrimaryKey(OrgImgContentPK primaryKey) {
		setOrgImgSeq(primaryKey.orgImgSeq);
		setGroupId(primaryKey.groupId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new OrgImgContentPK(_orgImgSeq, _groupId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((OrgImgContentPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orgImgSeq", getOrgImgSeq());
		attributes.put("groupId", getGroupId());
		attributes.put("order", getOrder());
		attributes.put("orgNm", getOrgNm());
		attributes.put("orgLink", getOrgLink());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("insertId", getInsertId());
		attributes.put("insertDate", getInsertDate());
		attributes.put("updateId", getUpdateId());
		attributes.put("updateDate", getUpdateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orgImgSeq = (Long)attributes.get("orgImgSeq");

		if (orgImgSeq != null) {
			setOrgImgSeq(orgImgSeq);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long order = (Long)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String orgNm = (String)attributes.get("orgNm");

		if (orgNm != null) {
			setOrgNm(orgNm);
		}

		String orgLink = (String)attributes.get("orgLink");

		if (orgLink != null) {
			setOrgLink(orgLink);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
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

	@Override
	public long getOrgImgSeq() {
		return _orgImgSeq;
	}

	@Override
	public void setOrgImgSeq(long orgImgSeq) {
		_orgImgSeq = orgImgSeq;

		if (_orgImgContentRemoteModel != null) {
			try {
				Class<?> clazz = _orgImgContentRemoteModel.getClass();

				Method method = clazz.getMethod("setOrgImgSeq", long.class);

				method.invoke(_orgImgContentRemoteModel, orgImgSeq);
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

		if (_orgImgContentRemoteModel != null) {
			try {
				Class<?> clazz = _orgImgContentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_orgImgContentRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrder() {
		return _order;
	}

	@Override
	public void setOrder(long order) {
		_order = order;

		if (_orgImgContentRemoteModel != null) {
			try {
				Class<?> clazz = _orgImgContentRemoteModel.getClass();

				Method method = clazz.getMethod("setOrder", long.class);

				method.invoke(_orgImgContentRemoteModel, order);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrgNm() {
		return _orgNm;
	}

	@Override
	public void setOrgNm(String orgNm) {
		_orgNm = orgNm;

		if (_orgImgContentRemoteModel != null) {
			try {
				Class<?> clazz = _orgImgContentRemoteModel.getClass();

				Method method = clazz.getMethod("setOrgNm", String.class);

				method.invoke(_orgImgContentRemoteModel, orgNm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrgLink() {
		return _orgLink;
	}

	@Override
	public void setOrgLink(String orgLink) {
		_orgLink = orgLink;

		if (_orgImgContentRemoteModel != null) {
			try {
				Class<?> clazz = _orgImgContentRemoteModel.getClass();

				Method method = clazz.getMethod("setOrgLink", String.class);

				method.invoke(_orgImgContentRemoteModel, orgLink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;

		if (_orgImgContentRemoteModel != null) {
			try {
				Class<?> clazz = _orgImgContentRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryId", long.class);

				method.invoke(_orgImgContentRemoteModel, fileEntryId);
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

		if (_orgImgContentRemoteModel != null) {
			try {
				Class<?> clazz = _orgImgContentRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertId", long.class);

				method.invoke(_orgImgContentRemoteModel, insertId);
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

		if (_orgImgContentRemoteModel != null) {
			try {
				Class<?> clazz = _orgImgContentRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertDate", Date.class);

				method.invoke(_orgImgContentRemoteModel, insertDate);
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

		if (_orgImgContentRemoteModel != null) {
			try {
				Class<?> clazz = _orgImgContentRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateId", long.class);

				method.invoke(_orgImgContentRemoteModel, updateId);
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

		if (_orgImgContentRemoteModel != null) {
			try {
				Class<?> clazz = _orgImgContentRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateDate", Date.class);

				method.invoke(_orgImgContentRemoteModel, updateDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOrgImgContentRemoteModel() {
		return _orgImgContentRemoteModel;
	}

	public void setOrgImgContentRemoteModel(
		BaseModel<?> orgImgContentRemoteModel) {
		_orgImgContentRemoteModel = orgImgContentRemoteModel;
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

		Class<?> remoteModelClass = _orgImgContentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_orgImgContentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OrgImgContentLocalServiceUtil.addOrgImgContent(this);
		}
		else {
			OrgImgContentLocalServiceUtil.updateOrgImgContent(this);
		}
	}

	@Override
	public OrgImgContent toEscapedModel() {
		return (OrgImgContent)ProxyUtil.newProxyInstance(OrgImgContent.class.getClassLoader(),
			new Class[] { OrgImgContent.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrgImgContentClp clone = new OrgImgContentClp();

		clone.setOrgImgSeq(getOrgImgSeq());
		clone.setGroupId(getGroupId());
		clone.setOrder(getOrder());
		clone.setOrgNm(getOrgNm());
		clone.setOrgLink(getOrgLink());
		clone.setFileEntryId(getFileEntryId());
		clone.setInsertId(getInsertId());
		clone.setInsertDate(getInsertDate());
		clone.setUpdateId(getUpdateId());
		clone.setUpdateDate(getUpdateDate());

		return clone;
	}

	@Override
	public int compareTo(OrgImgContent orgImgContent) {
		int value = 0;

		if (getOrder() < orgImgContent.getOrder()) {
			value = -1;
		}
		else if (getOrder() > orgImgContent.getOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof OrgImgContentClp)) {
			return false;
		}

		OrgImgContentClp orgImgContent = (OrgImgContentClp)obj;

		OrgImgContentPK primaryKey = orgImgContent.getPrimaryKey();

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

		sb.append("{orgImgSeq=");
		sb.append(getOrgImgSeq());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", order=");
		sb.append(getOrder());
		sb.append(", orgNm=");
		sb.append(getOrgNm());
		sb.append(", orgLink=");
		sb.append(getOrgLink());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.content.model.OrgImgContent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orgImgSeq</column-name><column-value><![CDATA[");
		sb.append(getOrgImgSeq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>order</column-name><column-value><![CDATA[");
		sb.append(getOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgNm</column-name><column-value><![CDATA[");
		sb.append(getOrgNm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgLink</column-name><column-value><![CDATA[");
		sb.append(getOrgLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
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

	private long _orgImgSeq;
	private long _groupId;
	private long _order;
	private String _orgNm;
	private String _orgLink;
	private long _fileEntryId;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
	private BaseModel<?> _orgImgContentRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.content.service.ClpSerializer.class;
}