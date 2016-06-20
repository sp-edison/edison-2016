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

package org.kisti.edison.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.kisti.edison.service.ClpSerializer;
import org.kisti.edison.service.SendMailContentLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class SendMailContentClp extends BaseModelImpl<SendMailContent>
	implements SendMailContent {
	public SendMailContentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SendMailContent.class;
	}

	@Override
	public String getModelClassName() {
		return SendMailContent.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _sendMailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSendMailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sendMailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sendMailId", getSendMailId());
		attributes.put("userId", getUserId());
		attributes.put("sendCount", getSendCount());
		attributes.put("successCount", getSuccessCount());
		attributes.put("failCount", getFailCount());
		attributes.put("sendDate", getSendDate());
		attributes.put("siteGroup", getSiteGroup());
		attributes.put("userGroup", getUserGroup());
		attributes.put("state", getState());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sendMailId = (Long)attributes.get("sendMailId");

		if (sendMailId != null) {
			setSendMailId(sendMailId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Integer sendCount = (Integer)attributes.get("sendCount");

		if (sendCount != null) {
			setSendCount(sendCount);
		}

		Integer successCount = (Integer)attributes.get("successCount");

		if (successCount != null) {
			setSuccessCount(successCount);
		}

		Integer failCount = (Integer)attributes.get("failCount");

		if (failCount != null) {
			setFailCount(failCount);
		}

		Date sendDate = (Date)attributes.get("sendDate");

		if (sendDate != null) {
			setSendDate(sendDate);
		}

		String siteGroup = (String)attributes.get("siteGroup");

		if (siteGroup != null) {
			setSiteGroup(siteGroup);
		}

		String userGroup = (String)attributes.get("userGroup");

		if (userGroup != null) {
			setUserGroup(userGroup);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	@Override
	public long getSendMailId() {
		return _sendMailId;
	}

	@Override
	public void setSendMailId(long sendMailId) {
		_sendMailId = sendMailId;

		if (_sendMailContentRemoteModel != null) {
			try {
				Class<?> clazz = _sendMailContentRemoteModel.getClass();

				Method method = clazz.getMethod("setSendMailId", long.class);

				method.invoke(_sendMailContentRemoteModel, sendMailId);
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

		if (_sendMailContentRemoteModel != null) {
			try {
				Class<?> clazz = _sendMailContentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_sendMailContentRemoteModel, userId);
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
	public int getSendCount() {
		return _sendCount;
	}

	@Override
	public void setSendCount(int sendCount) {
		_sendCount = sendCount;

		if (_sendMailContentRemoteModel != null) {
			try {
				Class<?> clazz = _sendMailContentRemoteModel.getClass();

				Method method = clazz.getMethod("setSendCount", int.class);

				method.invoke(_sendMailContentRemoteModel, sendCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSuccessCount() {
		return _successCount;
	}

	@Override
	public void setSuccessCount(int successCount) {
		_successCount = successCount;

		if (_sendMailContentRemoteModel != null) {
			try {
				Class<?> clazz = _sendMailContentRemoteModel.getClass();

				Method method = clazz.getMethod("setSuccessCount", int.class);

				method.invoke(_sendMailContentRemoteModel, successCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFailCount() {
		return _failCount;
	}

	@Override
	public void setFailCount(int failCount) {
		_failCount = failCount;

		if (_sendMailContentRemoteModel != null) {
			try {
				Class<?> clazz = _sendMailContentRemoteModel.getClass();

				Method method = clazz.getMethod("setFailCount", int.class);

				method.invoke(_sendMailContentRemoteModel, failCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSendDate() {
		return _sendDate;
	}

	@Override
	public void setSendDate(Date sendDate) {
		_sendDate = sendDate;

		if (_sendMailContentRemoteModel != null) {
			try {
				Class<?> clazz = _sendMailContentRemoteModel.getClass();

				Method method = clazz.getMethod("setSendDate", Date.class);

				method.invoke(_sendMailContentRemoteModel, sendDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSiteGroup() {
		return _siteGroup;
	}

	@Override
	public void setSiteGroup(String siteGroup) {
		_siteGroup = siteGroup;

		if (_sendMailContentRemoteModel != null) {
			try {
				Class<?> clazz = _sendMailContentRemoteModel.getClass();

				Method method = clazz.getMethod("setSiteGroup", String.class);

				method.invoke(_sendMailContentRemoteModel, siteGroup);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserGroup() {
		return _userGroup;
	}

	@Override
	public void setUserGroup(String userGroup) {
		_userGroup = userGroup;

		if (_sendMailContentRemoteModel != null) {
			try {
				Class<?> clazz = _sendMailContentRemoteModel.getClass();

				Method method = clazz.getMethod("setUserGroup", String.class);

				method.invoke(_sendMailContentRemoteModel, userGroup);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getState() {
		return _state;
	}

	@Override
	public void setState(String state) {
		_state = state;

		if (_sendMailContentRemoteModel != null) {
			try {
				Class<?> clazz = _sendMailContentRemoteModel.getClass();

				Method method = clazz.getMethod("setState", String.class);

				method.invoke(_sendMailContentRemoteModel, state);
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

		if (_sendMailContentRemoteModel != null) {
			try {
				Class<?> clazz = _sendMailContentRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_sendMailContentRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_sendMailContentRemoteModel != null) {
			try {
				Class<?> clazz = _sendMailContentRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_sendMailContentRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSendMailContentRemoteModel() {
		return _sendMailContentRemoteModel;
	}

	public void setSendMailContentRemoteModel(
		BaseModel<?> sendMailContentRemoteModel) {
		_sendMailContentRemoteModel = sendMailContentRemoteModel;
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

		Class<?> remoteModelClass = _sendMailContentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_sendMailContentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SendMailContentLocalServiceUtil.addSendMailContent(this);
		}
		else {
			SendMailContentLocalServiceUtil.updateSendMailContent(this);
		}
	}

	@Override
	public SendMailContent toEscapedModel() {
		return (SendMailContent)ProxyUtil.newProxyInstance(SendMailContent.class.getClassLoader(),
			new Class[] { SendMailContent.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SendMailContentClp clone = new SendMailContentClp();

		clone.setSendMailId(getSendMailId());
		clone.setUserId(getUserId());
		clone.setSendCount(getSendCount());
		clone.setSuccessCount(getSuccessCount());
		clone.setFailCount(getFailCount());
		clone.setSendDate(getSendDate());
		clone.setSiteGroup(getSiteGroup());
		clone.setUserGroup(getUserGroup());
		clone.setState(getState());
		clone.setTitle(getTitle());
		clone.setContent(getContent());

		return clone;
	}

	@Override
	public int compareTo(SendMailContent sendMailContent) {
		long primaryKey = sendMailContent.getPrimaryKey();

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

		if (!(obj instanceof SendMailContentClp)) {
			return false;
		}

		SendMailContentClp sendMailContent = (SendMailContentClp)obj;

		long primaryKey = sendMailContent.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{sendMailId=");
		sb.append(getSendMailId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", sendCount=");
		sb.append(getSendCount());
		sb.append(", successCount=");
		sb.append(getSuccessCount());
		sb.append(", failCount=");
		sb.append(getFailCount());
		sb.append(", sendDate=");
		sb.append(getSendDate());
		sb.append(", siteGroup=");
		sb.append(getSiteGroup());
		sb.append(", userGroup=");
		sb.append(getUserGroup());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", content=");
		sb.append(getContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.model.SendMailContent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sendMailId</column-name><column-value><![CDATA[");
		sb.append(getSendMailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendCount</column-name><column-value><![CDATA[");
		sb.append(getSendCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>successCount</column-name><column-value><![CDATA[");
		sb.append(getSuccessCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>failCount</column-name><column-value><![CDATA[");
		sb.append(getFailCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendDate</column-name><column-value><![CDATA[");
		sb.append(getSendDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>siteGroup</column-name><column-value><![CDATA[");
		sb.append(getSiteGroup());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userGroup</column-name><column-value><![CDATA[");
		sb.append(getUserGroup());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _sendMailId;
	private long _userId;
	private String _userUuid;
	private int _sendCount;
	private int _successCount;
	private int _failCount;
	private Date _sendDate;
	private String _siteGroup;
	private String _userGroup;
	private String _state;
	private String _title;
	private String _content;
	private BaseModel<?> _sendMailContentRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.service.ClpSerializer.class;
}