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

import org.kisti.edison.content.service.AdvancedContentLocalServiceUtil;
import org.kisti.edison.content.service.ClpSerializer;
import org.kisti.edison.content.service.persistence.AdvancedContentPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class AdvancedContentClp extends BaseModelImpl<AdvancedContent>
	implements AdvancedContent {
	public AdvancedContentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AdvancedContent.class;
	}

	@Override
	public String getModelClassName() {
		return AdvancedContent.class.getName();
	}

	@Override
	public AdvancedContentPK getPrimaryKey() {
		return new AdvancedContentPK(_contentSeq, _groupId);
	}

	@Override
	public void setPrimaryKey(AdvancedContentPK primaryKey) {
		setContentSeq(primaryKey.contentSeq);
		setGroupId(primaryKey.groupId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new AdvancedContentPK(_contentSeq, _groupId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((AdvancedContentPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentSeq", getContentSeq());
		attributes.put("groupId", getGroupId());
		attributes.put("title", getTitle());
		attributes.put("resume", getResume());
		attributes.put("contentFilePath", getContentFilePath());
		attributes.put("contentFileNm", getContentFileNm());
		attributes.put("contentStartFileNm", getContentStartFileNm());
		attributes.put("serviceLanguage", getServiceLanguage());
		attributes.put("viewCnt", getViewCnt());
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String resume = (String)attributes.get("resume");

		if (resume != null) {
			setResume(resume);
		}

		String contentFilePath = (String)attributes.get("contentFilePath");

		if (contentFilePath != null) {
			setContentFilePath(contentFilePath);
		}

		String contentFileNm = (String)attributes.get("contentFileNm");

		if (contentFileNm != null) {
			setContentFileNm(contentFileNm);
		}

		String contentStartFileNm = (String)attributes.get("contentStartFileNm");

		if (contentStartFileNm != null) {
			setContentStartFileNm(contentStartFileNm);
		}

		String serviceLanguage = (String)attributes.get("serviceLanguage");

		if (serviceLanguage != null) {
			setServiceLanguage(serviceLanguage);
		}

		Long viewCnt = (Long)attributes.get("viewCnt");

		if (viewCnt != null) {
			setViewCnt(viewCnt);
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
	public long getContentSeq() {
		return _contentSeq;
	}

	@Override
	public void setContentSeq(long contentSeq) {
		_contentSeq = contentSeq;

		if (_advancedContentRemoteModel != null) {
			try {
				Class<?> clazz = _advancedContentRemoteModel.getClass();

				Method method = clazz.getMethod("setContentSeq", long.class);

				method.invoke(_advancedContentRemoteModel, contentSeq);
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

		if (_advancedContentRemoteModel != null) {
			try {
				Class<?> clazz = _advancedContentRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_advancedContentRemoteModel, groupId);
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
	public void setTitle(String title) {
		_title = title;

		if (_advancedContentRemoteModel != null) {
			try {
				Class<?> clazz = _advancedContentRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_advancedContentRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResume() {
		return _resume;
	}

	@Override
	public void setResume(String resume) {
		_resume = resume;

		if (_advancedContentRemoteModel != null) {
			try {
				Class<?> clazz = _advancedContentRemoteModel.getClass();

				Method method = clazz.getMethod("setResume", String.class);

				method.invoke(_advancedContentRemoteModel, resume);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContentFilePath() {
		return _contentFilePath;
	}

	@Override
	public void setContentFilePath(String contentFilePath) {
		_contentFilePath = contentFilePath;

		if (_advancedContentRemoteModel != null) {
			try {
				Class<?> clazz = _advancedContentRemoteModel.getClass();

				Method method = clazz.getMethod("setContentFilePath",
						String.class);

				method.invoke(_advancedContentRemoteModel, contentFilePath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContentFileNm() {
		return _contentFileNm;
	}

	@Override
	public void setContentFileNm(String contentFileNm) {
		_contentFileNm = contentFileNm;

		if (_advancedContentRemoteModel != null) {
			try {
				Class<?> clazz = _advancedContentRemoteModel.getClass();

				Method method = clazz.getMethod("setContentFileNm", String.class);

				method.invoke(_advancedContentRemoteModel, contentFileNm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContentStartFileNm() {
		return _contentStartFileNm;
	}

	@Override
	public void setContentStartFileNm(String contentStartFileNm) {
		_contentStartFileNm = contentStartFileNm;

		if (_advancedContentRemoteModel != null) {
			try {
				Class<?> clazz = _advancedContentRemoteModel.getClass();

				Method method = clazz.getMethod("setContentStartFileNm",
						String.class);

				method.invoke(_advancedContentRemoteModel, contentStartFileNm);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceLanguage() {
		return _serviceLanguage;
	}

	@Override
	public void setServiceLanguage(String serviceLanguage) {
		_serviceLanguage = serviceLanguage;

		if (_advancedContentRemoteModel != null) {
			try {
				Class<?> clazz = _advancedContentRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceLanguage",
						String.class);

				method.invoke(_advancedContentRemoteModel, serviceLanguage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getViewCnt() {
		return _viewCnt;
	}

	@Override
	public void setViewCnt(long viewCnt) {
		_viewCnt = viewCnt;

		if (_advancedContentRemoteModel != null) {
			try {
				Class<?> clazz = _advancedContentRemoteModel.getClass();

				Method method = clazz.getMethod("setViewCnt", long.class);

				method.invoke(_advancedContentRemoteModel, viewCnt);
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

		if (_advancedContentRemoteModel != null) {
			try {
				Class<?> clazz = _advancedContentRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertId", long.class);

				method.invoke(_advancedContentRemoteModel, insertId);
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

		if (_advancedContentRemoteModel != null) {
			try {
				Class<?> clazz = _advancedContentRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertDate", Date.class);

				method.invoke(_advancedContentRemoteModel, insertDate);
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

		if (_advancedContentRemoteModel != null) {
			try {
				Class<?> clazz = _advancedContentRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateId", long.class);

				method.invoke(_advancedContentRemoteModel, updateId);
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

		if (_advancedContentRemoteModel != null) {
			try {
				Class<?> clazz = _advancedContentRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateDate", Date.class);

				method.invoke(_advancedContentRemoteModel, updateDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAdvancedContentRemoteModel() {
		return _advancedContentRemoteModel;
	}

	public void setAdvancedContentRemoteModel(
		BaseModel<?> advancedContentRemoteModel) {
		_advancedContentRemoteModel = advancedContentRemoteModel;
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

		Class<?> remoteModelClass = _advancedContentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_advancedContentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AdvancedContentLocalServiceUtil.addAdvancedContent(this);
		}
		else {
			AdvancedContentLocalServiceUtil.updateAdvancedContent(this);
		}
	}

	@Override
	public AdvancedContent toEscapedModel() {
		return (AdvancedContent)ProxyUtil.newProxyInstance(AdvancedContent.class.getClassLoader(),
			new Class[] { AdvancedContent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AdvancedContentClp clone = new AdvancedContentClp();

		clone.setContentSeq(getContentSeq());
		clone.setGroupId(getGroupId());
		clone.setTitle(getTitle());
		clone.setResume(getResume());
		clone.setContentFilePath(getContentFilePath());
		clone.setContentFileNm(getContentFileNm());
		clone.setContentStartFileNm(getContentStartFileNm());
		clone.setServiceLanguage(getServiceLanguage());
		clone.setViewCnt(getViewCnt());
		clone.setInsertId(getInsertId());
		clone.setInsertDate(getInsertDate());
		clone.setUpdateId(getUpdateId());
		clone.setUpdateDate(getUpdateDate());

		return clone;
	}

	@Override
	public int compareTo(AdvancedContent advancedContent) {
		int value = 0;

		if (getContentSeq() < advancedContent.getContentSeq()) {
			value = -1;
		}
		else if (getContentSeq() > advancedContent.getContentSeq()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof AdvancedContentClp)) {
			return false;
		}

		AdvancedContentClp advancedContent = (AdvancedContentClp)obj;

		AdvancedContentPK primaryKey = advancedContent.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{contentSeq=");
		sb.append(getContentSeq());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", resume=");
		sb.append(getResume());
		sb.append(", contentFilePath=");
		sb.append(getContentFilePath());
		sb.append(", contentFileNm=");
		sb.append(getContentFileNm());
		sb.append(", contentStartFileNm=");
		sb.append(getContentStartFileNm());
		sb.append(", serviceLanguage=");
		sb.append(getServiceLanguage());
		sb.append(", viewCnt=");
		sb.append(getViewCnt());
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
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.content.model.AdvancedContent");
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
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resume</column-name><column-value><![CDATA[");
		sb.append(getResume());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentFilePath</column-name><column-value><![CDATA[");
		sb.append(getContentFilePath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentFileNm</column-name><column-value><![CDATA[");
		sb.append(getContentFileNm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contentStartFileNm</column-name><column-value><![CDATA[");
		sb.append(getContentStartFileNm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceLanguage</column-name><column-value><![CDATA[");
		sb.append(getServiceLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>viewCnt</column-name><column-value><![CDATA[");
		sb.append(getViewCnt());
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

	private long _contentSeq;
	private long _groupId;
	private String _title;
	private String _resume;
	private String _contentFilePath;
	private String _contentFileNm;
	private String _contentStartFileNm;
	private String _serviceLanguage;
	private long _viewCnt;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
	private BaseModel<?> _advancedContentRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.content.service.ClpSerializer.class;
}