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

package org.kisti.edison.science.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.kisti.edison.science.service.ClpSerializer;
import org.kisti.edison.science.service.DeveloperIpLocalServiceUtil;
import org.kisti.edison.science.service.persistence.DeveloperIpPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class DeveloperIpClp extends BaseModelImpl<DeveloperIp>
	implements DeveloperIp {
	public DeveloperIpClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DeveloperIp.class;
	}

	@Override
	public String getModelClassName() {
		return DeveloperIp.class.getName();
	}

	@Override
	public DeveloperIpPK getPrimaryKey() {
		return new DeveloperIpPK(_ipSeq, _userId, _groupId);
	}

	@Override
	public void setPrimaryKey(DeveloperIpPK primaryKey) {
		setIpSeq(primaryKey.ipSeq);
		setUserId(primaryKey.userId);
		setGroupId(primaryKey.groupId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new DeveloperIpPK(_ipSeq, _userId, _groupId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((DeveloperIpPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ipSeq", getIpSeq());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("ip1", getIp1());
		attributes.put("ip2", getIp2());
		attributes.put("ip3", getIp3());
		attributes.put("ip4", getIp4());
		attributes.put("insertId", getInsertId());
		attributes.put("insertDate", getInsertDate());
		attributes.put("updateId", getUpdateId());
		attributes.put("updateDate", getUpdateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ipSeq = (Long)attributes.get("ipSeq");

		if (ipSeq != null) {
			setIpSeq(ipSeq);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String ip1 = (String)attributes.get("ip1");

		if (ip1 != null) {
			setIp1(ip1);
		}

		String ip2 = (String)attributes.get("ip2");

		if (ip2 != null) {
			setIp2(ip2);
		}

		String ip3 = (String)attributes.get("ip3");

		if (ip3 != null) {
			setIp3(ip3);
		}

		String ip4 = (String)attributes.get("ip4");

		if (ip4 != null) {
			setIp4(ip4);
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
	public long getIpSeq() {
		return _ipSeq;
	}

	@Override
	public void setIpSeq(long ipSeq) {
		_ipSeq = ipSeq;

		if (_developerIpRemoteModel != null) {
			try {
				Class<?> clazz = _developerIpRemoteModel.getClass();

				Method method = clazz.getMethod("setIpSeq", long.class);

				method.invoke(_developerIpRemoteModel, ipSeq);
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

		if (_developerIpRemoteModel != null) {
			try {
				Class<?> clazz = _developerIpRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_developerIpRemoteModel, userId);
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
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_developerIpRemoteModel != null) {
			try {
				Class<?> clazz = _developerIpRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_developerIpRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIp1() {
		return _ip1;
	}

	@Override
	public void setIp1(String ip1) {
		_ip1 = ip1;

		if (_developerIpRemoteModel != null) {
			try {
				Class<?> clazz = _developerIpRemoteModel.getClass();

				Method method = clazz.getMethod("setIp1", String.class);

				method.invoke(_developerIpRemoteModel, ip1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIp2() {
		return _ip2;
	}

	@Override
	public void setIp2(String ip2) {
		_ip2 = ip2;

		if (_developerIpRemoteModel != null) {
			try {
				Class<?> clazz = _developerIpRemoteModel.getClass();

				Method method = clazz.getMethod("setIp2", String.class);

				method.invoke(_developerIpRemoteModel, ip2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIp3() {
		return _ip3;
	}

	@Override
	public void setIp3(String ip3) {
		_ip3 = ip3;

		if (_developerIpRemoteModel != null) {
			try {
				Class<?> clazz = _developerIpRemoteModel.getClass();

				Method method = clazz.getMethod("setIp3", String.class);

				method.invoke(_developerIpRemoteModel, ip3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIp4() {
		return _ip4;
	}

	@Override
	public void setIp4(String ip4) {
		_ip4 = ip4;

		if (_developerIpRemoteModel != null) {
			try {
				Class<?> clazz = _developerIpRemoteModel.getClass();

				Method method = clazz.getMethod("setIp4", String.class);

				method.invoke(_developerIpRemoteModel, ip4);
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

		if (_developerIpRemoteModel != null) {
			try {
				Class<?> clazz = _developerIpRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertId", long.class);

				method.invoke(_developerIpRemoteModel, insertId);
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

		if (_developerIpRemoteModel != null) {
			try {
				Class<?> clazz = _developerIpRemoteModel.getClass();

				Method method = clazz.getMethod("setInsertDate", Date.class);

				method.invoke(_developerIpRemoteModel, insertDate);
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

		if (_developerIpRemoteModel != null) {
			try {
				Class<?> clazz = _developerIpRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateId", long.class);

				method.invoke(_developerIpRemoteModel, updateId);
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

		if (_developerIpRemoteModel != null) {
			try {
				Class<?> clazz = _developerIpRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateDate", Date.class);

				method.invoke(_developerIpRemoteModel, updateDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDeveloperIpRemoteModel() {
		return _developerIpRemoteModel;
	}

	public void setDeveloperIpRemoteModel(BaseModel<?> developerIpRemoteModel) {
		_developerIpRemoteModel = developerIpRemoteModel;
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

		Class<?> remoteModelClass = _developerIpRemoteModel.getClass();

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

		Object returnValue = method.invoke(_developerIpRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DeveloperIpLocalServiceUtil.addDeveloperIp(this);
		}
		else {
			DeveloperIpLocalServiceUtil.updateDeveloperIp(this);
		}
	}

	@Override
	public DeveloperIp toEscapedModel() {
		return (DeveloperIp)ProxyUtil.newProxyInstance(DeveloperIp.class.getClassLoader(),
			new Class[] { DeveloperIp.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DeveloperIpClp clone = new DeveloperIpClp();

		clone.setIpSeq(getIpSeq());
		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());
		clone.setIp1(getIp1());
		clone.setIp2(getIp2());
		clone.setIp3(getIp3());
		clone.setIp4(getIp4());
		clone.setInsertId(getInsertId());
		clone.setInsertDate(getInsertDate());
		clone.setUpdateId(getUpdateId());
		clone.setUpdateDate(getUpdateDate());

		return clone;
	}

	@Override
	public int compareTo(DeveloperIp developerIp) {
		int value = 0;

		if (getIpSeq() < developerIp.getIpSeq()) {
			value = -1;
		}
		else if (getIpSeq() > developerIp.getIpSeq()) {
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

		if (!(obj instanceof DeveloperIpClp)) {
			return false;
		}

		DeveloperIpClp developerIp = (DeveloperIpClp)obj;

		DeveloperIpPK primaryKey = developerIp.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{ipSeq=");
		sb.append(getIpSeq());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", ip1=");
		sb.append(getIp1());
		sb.append(", ip2=");
		sb.append(getIp2());
		sb.append(", ip3=");
		sb.append(getIp3());
		sb.append(", ip4=");
		sb.append(getIp4());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.science.model.DeveloperIp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ipSeq</column-name><column-value><![CDATA[");
		sb.append(getIpSeq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ip1</column-name><column-value><![CDATA[");
		sb.append(getIp1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ip2</column-name><column-value><![CDATA[");
		sb.append(getIp2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ip3</column-name><column-value><![CDATA[");
		sb.append(getIp3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ip4</column-name><column-value><![CDATA[");
		sb.append(getIp4());
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

	private long _ipSeq;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private String _ip1;
	private String _ip2;
	private String _ip3;
	private String _ip4;
	private long _insertId;
	private Date _insertDate;
	private long _updateId;
	private Date _updateDate;
	private BaseModel<?> _developerIpRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.science.service.ClpSerializer.class;
}