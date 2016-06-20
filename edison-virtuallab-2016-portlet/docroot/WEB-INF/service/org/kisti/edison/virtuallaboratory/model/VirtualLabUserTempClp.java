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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.kisti.edison.virtuallaboratory.service.ClpSerializer;
import org.kisti.edison.virtuallaboratory.service.VirtualLabUserTempLocalServiceUtil;
import org.kisti.edison.virtuallaboratory.service.persistence.VirtualLabUserTempPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class VirtualLabUserTempClp extends BaseModelImpl<VirtualLabUserTemp>
	implements VirtualLabUserTemp {
	public VirtualLabUserTempClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VirtualLabUserTemp.class;
	}

	@Override
	public String getModelClassName() {
		return VirtualLabUserTemp.class.getName();
	}

	@Override
	public VirtualLabUserTempPK getPrimaryKey() {
		return new VirtualLabUserTempPK(_seqNo, _virtualLabId, _classId);
	}

	@Override
	public void setPrimaryKey(VirtualLabUserTempPK primaryKey) {
		setSeqNo(primaryKey.seqNo);
		setVirtualLabId(primaryKey.virtualLabId);
		setClassId(primaryKey.classId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new VirtualLabUserTempPK(_seqNo, _virtualLabId, _classId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VirtualLabUserTempPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("seqNo", getSeqNo());
		attributes.put("virtualLabId", getVirtualLabId());
		attributes.put("classId", getClassId());
		attributes.put("userStudentNumber", getUserStudentNumber());
		attributes.put("userName", getUserName());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long seqNo = (Long)attributes.get("seqNo");

		if (seqNo != null) {
			setSeqNo(seqNo);
		}

		Long virtualLabId = (Long)attributes.get("virtualLabId");

		if (virtualLabId != null) {
			setVirtualLabId(virtualLabId);
		}

		Long classId = (Long)attributes.get("classId");

		if (classId != null) {
			setClassId(classId);
		}

		String userStudentNumber = (String)attributes.get("userStudentNumber");

		if (userStudentNumber != null) {
			setUserStudentNumber(userStudentNumber);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getSeqNo() {
		return _seqNo;
	}

	@Override
	public void setSeqNo(long seqNo) {
		_seqNo = seqNo;

		if (_virtualLabUserTempRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserTempRemoteModel.getClass();

				Method method = clazz.getMethod("setSeqNo", long.class);

				method.invoke(_virtualLabUserTempRemoteModel, seqNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVirtualLabId() {
		return _virtualLabId;
	}

	@Override
	public void setVirtualLabId(long virtualLabId) {
		_virtualLabId = virtualLabId;

		if (_virtualLabUserTempRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserTempRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualLabId", long.class);

				method.invoke(_virtualLabUserTempRemoteModel, virtualLabId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassId() {
		return _classId;
	}

	@Override
	public void setClassId(long classId) {
		_classId = classId;

		if (_virtualLabUserTempRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserTempRemoteModel.getClass();

				Method method = clazz.getMethod("setClassId", long.class);

				method.invoke(_virtualLabUserTempRemoteModel, classId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserStudentNumber() {
		return _userStudentNumber;
	}

	@Override
	public void setUserStudentNumber(String userStudentNumber) {
		_userStudentNumber = userStudentNumber;

		if (_virtualLabUserTempRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserTempRemoteModel.getClass();

				Method method = clazz.getMethod("setUserStudentNumber",
						String.class);

				method.invoke(_virtualLabUserTempRemoteModel, userStudentNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_virtualLabUserTempRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserTempRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_virtualLabUserTempRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getStatus() {
		return _status;
	}

	@Override
	public boolean isStatus() {
		return _status;
	}

	@Override
	public void setStatus(boolean status) {
		_status = status;

		if (_virtualLabUserTempRemoteModel != null) {
			try {
				Class<?> clazz = _virtualLabUserTempRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", boolean.class);

				method.invoke(_virtualLabUserTempRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVirtualLabUserTempRemoteModel() {
		return _virtualLabUserTempRemoteModel;
	}

	public void setVirtualLabUserTempRemoteModel(
		BaseModel<?> virtualLabUserTempRemoteModel) {
		_virtualLabUserTempRemoteModel = virtualLabUserTempRemoteModel;
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

		Class<?> remoteModelClass = _virtualLabUserTempRemoteModel.getClass();

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

		Object returnValue = method.invoke(_virtualLabUserTempRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VirtualLabUserTempLocalServiceUtil.addVirtualLabUserTemp(this);
		}
		else {
			VirtualLabUserTempLocalServiceUtil.updateVirtualLabUserTemp(this);
		}
	}

	@Override
	public VirtualLabUserTemp toEscapedModel() {
		return (VirtualLabUserTemp)ProxyUtil.newProxyInstance(VirtualLabUserTemp.class.getClassLoader(),
			new Class[] { VirtualLabUserTemp.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VirtualLabUserTempClp clone = new VirtualLabUserTempClp();

		clone.setSeqNo(getSeqNo());
		clone.setVirtualLabId(getVirtualLabId());
		clone.setClassId(getClassId());
		clone.setUserStudentNumber(getUserStudentNumber());
		clone.setUserName(getUserName());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(VirtualLabUserTemp virtualLabUserTemp) {
		int value = 0;

		value = getUserName().compareTo(virtualLabUserTemp.getUserName());

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

		if (!(obj instanceof VirtualLabUserTempClp)) {
			return false;
		}

		VirtualLabUserTempClp virtualLabUserTemp = (VirtualLabUserTempClp)obj;

		VirtualLabUserTempPK primaryKey = virtualLabUserTemp.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{seqNo=");
		sb.append(getSeqNo());
		sb.append(", virtualLabId=");
		sb.append(getVirtualLabId());
		sb.append(", classId=");
		sb.append(getClassId());
		sb.append(", userStudentNumber=");
		sb.append(getUserStudentNumber());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>seqNo</column-name><column-value><![CDATA[");
		sb.append(getSeqNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualLabId</column-name><column-value><![CDATA[");
		sb.append(getVirtualLabId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classId</column-name><column-value><![CDATA[");
		sb.append(getClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userStudentNumber</column-name><column-value><![CDATA[");
		sb.append(getUserStudentNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _seqNo;
	private long _virtualLabId;
	private long _classId;
	private String _userStudentNumber;
	private String _userName;
	private boolean _status;
	private BaseModel<?> _virtualLabUserTempRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.virtuallaboratory.service.ClpSerializer.class;
}