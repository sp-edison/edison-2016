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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.kisti.edison.virtuallaboratory.service.ClpSerializer;
import org.kisti.edison.virtuallaboratory.service.VirtualLabUserLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class VirtualLabUserClp extends BaseModelImpl<VirtualLabUser>
	implements VirtualLabUser {
	public VirtualLabUserClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VirtualLabUser.class;
	}

	@Override
	public String getModelClassName() {
		return VirtualLabUser.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _virtualLabUserId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVirtualLabUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _virtualLabUserId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("virtualLabUserId", getVirtualLabUserId());
		attributes.put("userId", getUserId());
		attributes.put("userStudentNumber", getUserStudentNumber());
		attributes.put("authRole", getAuthRole());
		attributes.put("userUseYn", getUserUseYn());
		attributes.put("requestSort", getRequestSort());
		attributes.put("processNote", getProcessNote());
		attributes.put("processDate", getProcessDate());
		attributes.put("createDt", getCreateDt());
		attributes.put("updateDt", getUpdateDt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long virtualLabUserId = (Long)attributes.get("virtualLabUserId");

		if (virtualLabUserId != null) {
			setVirtualLabUserId(virtualLabUserId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userStudentNumber = (String)attributes.get("userStudentNumber");

		if (userStudentNumber != null) {
			setUserStudentNumber(userStudentNumber);
		}

		String authRole = (String)attributes.get("authRole");

		if (authRole != null) {
			setAuthRole(authRole);
		}

		String userUseYn = (String)attributes.get("userUseYn");

		if (userUseYn != null) {
			setUserUseYn(userUseYn);
		}

		String requestSort = (String)attributes.get("requestSort");

		if (requestSort != null) {
			setRequestSort(requestSort);
		}

		String processNote = (String)attributes.get("processNote");

		if (processNote != null) {
			setProcessNote(processNote);
		}

		Date processDate = (Date)attributes.get("processDate");

		if (processDate != null) {
			setProcessDate(processDate);
		}

		Date createDt = (Date)attributes.get("createDt");

		if (createDt != null) {
			setCreateDt(createDt);
		}

		Date updateDt = (Date)attributes.get("updateDt");

		if (updateDt != null) {
			setUpdateDt(updateDt);
		}
	}

	@Override
	public long getVirtualLabUserId() {
		return _virtualLabUserId;
	}

	@Override
	public void setVirtualLabUserId(long virtualLabUserId) {
		_virtualLabUserId = virtualLabUserId;

		if (_virtualLabUserRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualLabUserId",
						long.class);

				method.invoke(_virtualLabUserRemoteModel, virtualLabUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVirtualLabUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getVirtualLabUserId(), "uuid",
			_virtualLabUserUuid);
	}

	@Override
	public void setVirtualLabUserUuid(String virtualLabUserUuid) {
		_virtualLabUserUuid = virtualLabUserUuid;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_virtualLabUserRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_virtualLabUserRemoteModel, userId);
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
	public String getUserStudentNumber() {
		return _userStudentNumber;
	}

	@Override
	public void setUserStudentNumber(String userStudentNumber) {
		_userStudentNumber = userStudentNumber;

		if (_virtualLabUserRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserStudentNumber",
						String.class);

				method.invoke(_virtualLabUserRemoteModel, userStudentNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthRole() {
		return _authRole;
	}

	@Override
	public void setAuthRole(String authRole) {
		_authRole = authRole;

		if (_virtualLabUserRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthRole", String.class);

				method.invoke(_virtualLabUserRemoteModel, authRole);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUseYn() {
		return _userUseYn;
	}

	@Override
	public void setUserUseYn(String userUseYn) {
		_userUseYn = userUseYn;

		if (_virtualLabUserRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUserUseYn", String.class);

				method.invoke(_virtualLabUserRemoteModel, userUseYn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRequestSort() {
		return _requestSort;
	}

	@Override
	public void setRequestSort(String requestSort) {
		_requestSort = requestSort;

		if (_virtualLabUserRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestSort", String.class);

				method.invoke(_virtualLabUserRemoteModel, requestSort);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProcessNote() {
		return _processNote;
	}

	@Override
	public void setProcessNote(String processNote) {
		_processNote = processNote;

		if (_virtualLabUserRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessNote", String.class);

				method.invoke(_virtualLabUserRemoteModel, processNote);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getProcessDate() {
		return _processDate;
	}

	@Override
	public void setProcessDate(Date processDate) {
		_processDate = processDate;

		if (_virtualLabUserRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessDate", Date.class);

				method.invoke(_virtualLabUserRemoteModel, processDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDt() {
		return _createDt;
	}

	@Override
	public void setCreateDt(Date createDt) {
		_createDt = createDt;

		if (_virtualLabUserRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDt", Date.class);

				method.invoke(_virtualLabUserRemoteModel, createDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdateDt() {
		return _updateDt;
	}

	@Override
	public void setUpdateDt(Date updateDt) {
		_updateDt = updateDt;

		if (_virtualLabUserRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateDt", Date.class);

				method.invoke(_virtualLabUserRemoteModel, updateDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVirtualLabUserRemoteModel() {
		return _virtualLabUserRemoteModel;
	}

	public void setVirtualLabUserRemoteModel(
		BaseModel<?> virtualLabUserRemoteModel) {
		_virtualLabUserRemoteModel = virtualLabUserRemoteModel;
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

		Class<?> remoteModelClass = _virtualLabUserRemoteModel.getClass();

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

		Object returnValue = method.invoke(_virtualLabUserRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VirtualLabUserLocalServiceUtil.addVirtualLabUser(this);
		}
		else {
			VirtualLabUserLocalServiceUtil.updateVirtualLabUser(this);
		}
	}

	@Override
	public VirtualLabUser toEscapedModel() {
		return (VirtualLabUser)ProxyUtil.newProxyInstance(VirtualLabUser.class.getClassLoader(),
			new Class[] { VirtualLabUser.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VirtualLabUserClp clone = new VirtualLabUserClp();

		clone.setVirtualLabUserId(getVirtualLabUserId());
		clone.setUserId(getUserId());
		clone.setUserStudentNumber(getUserStudentNumber());
		clone.setAuthRole(getAuthRole());
		clone.setUserUseYn(getUserUseYn());
		clone.setRequestSort(getRequestSort());
		clone.setProcessNote(getProcessNote());
		clone.setProcessDate(getProcessDate());
		clone.setCreateDt(getCreateDt());
		clone.setUpdateDt(getUpdateDt());

		return clone;
	}

	@Override
	public int compareTo(VirtualLabUser virtualLabUser) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDt(), virtualLabUser.getCreateDt());

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

		if (!(obj instanceof VirtualLabUserClp)) {
			return false;
		}

		VirtualLabUserClp virtualLabUser = (VirtualLabUserClp)obj;

		long primaryKey = virtualLabUser.getPrimaryKey();

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

		sb.append("{virtualLabUserId=");
		sb.append(getVirtualLabUserId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userStudentNumber=");
		sb.append(getUserStudentNumber());
		sb.append(", authRole=");
		sb.append(getAuthRole());
		sb.append(", userUseYn=");
		sb.append(getUserUseYn());
		sb.append(", requestSort=");
		sb.append(getRequestSort());
		sb.append(", processNote=");
		sb.append(getProcessNote());
		sb.append(", processDate=");
		sb.append(getProcessDate());
		sb.append(", createDt=");
		sb.append(getCreateDt());
		sb.append(", updateDt=");
		sb.append(getUpdateDt());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.virtuallaboratory.model.VirtualLabUser");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>virtualLabUserId</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userStudentNumber</column-name><column-value><![CDATA[");
		sb.append(getUserStudentNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authRole</column-name><column-value><![CDATA[");
		sb.append(getAuthRole());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userUseYn</column-name><column-value><![CDATA[");
		sb.append(getUserUseYn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestSort</column-name><column-value><![CDATA[");
		sb.append(getRequestSort());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processNote</column-name><column-value><![CDATA[");
		sb.append(getProcessNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processDate</column-name><column-value><![CDATA[");
		sb.append(getProcessDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDt</column-name><column-value><![CDATA[");
		sb.append(getCreateDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateDt</column-name><column-value><![CDATA[");
		sb.append(getUpdateDt());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _virtualLabUserId;
	private String _virtualLabUserUuid;
	private long _userId;
	private String _userUuid;
	private String _userStudentNumber;
	private String _authRole;
	private String _userUseYn;
	private String _requestSort;
	private String _processNote;
	private Date _processDate;
	private Date _createDt;
	private Date _updateDt;
	private BaseModel<?> _virtualLabUserRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.virtuallaboratory.service.ClpSerializer.class;
}