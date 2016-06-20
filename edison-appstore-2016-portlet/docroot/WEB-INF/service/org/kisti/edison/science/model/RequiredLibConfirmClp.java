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
import org.kisti.edison.science.service.RequiredLibConfirmLocalServiceUtil;
import org.kisti.edison.science.service.persistence.RequiredLibConfirmPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class RequiredLibConfirmClp extends BaseModelImpl<RequiredLibConfirm>
	implements RequiredLibConfirm {
	public RequiredLibConfirmClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return RequiredLibConfirm.class;
	}

	@Override
	public String getModelClassName() {
		return RequiredLibConfirm.class.getName();
	}

	@Override
	public RequiredLibConfirmPK getPrimaryKey() {
		return new RequiredLibConfirmPK(_requiredLibId, _scienceAppId);
	}

	@Override
	public void setPrimaryKey(RequiredLibConfirmPK primaryKey) {
		setRequiredLibId(primaryKey.requiredLibId);
		setScienceAppId(primaryKey.scienceAppId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new RequiredLibConfirmPK(_requiredLibId, _scienceAppId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((RequiredLibConfirmPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("requiredLibId", getRequiredLibId());
		attributes.put("scienceAppId", getScienceAppId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("requiredDate", getRequiredDate());
		attributes.put("confirmDate", getConfirmDate());
		attributes.put("libraryName", getLibraryName());
		attributes.put("libraryVersion", getLibraryVersion());
		attributes.put("requiredContent", getRequiredContent());
		attributes.put("requiredState", getRequiredState());
		attributes.put("confirmContent", getConfirmContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long requiredLibId = (Long)attributes.get("requiredLibId");

		if (requiredLibId != null) {
			setRequiredLibId(requiredLibId);
		}

		Long scienceAppId = (Long)attributes.get("scienceAppId");

		if (scienceAppId != null) {
			setScienceAppId(scienceAppId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date requiredDate = (Date)attributes.get("requiredDate");

		if (requiredDate != null) {
			setRequiredDate(requiredDate);
		}

		Date confirmDate = (Date)attributes.get("confirmDate");

		if (confirmDate != null) {
			setConfirmDate(confirmDate);
		}

		String libraryName = (String)attributes.get("libraryName");

		if (libraryName != null) {
			setLibraryName(libraryName);
		}

		String libraryVersion = (String)attributes.get("libraryVersion");

		if (libraryVersion != null) {
			setLibraryVersion(libraryVersion);
		}

		String requiredContent = (String)attributes.get("requiredContent");

		if (requiredContent != null) {
			setRequiredContent(requiredContent);
		}

		String requiredState = (String)attributes.get("requiredState");

		if (requiredState != null) {
			setRequiredState(requiredState);
		}

		String confirmContent = (String)attributes.get("confirmContent");

		if (confirmContent != null) {
			setConfirmContent(confirmContent);
		}
	}

	@Override
	public long getRequiredLibId() {
		return _requiredLibId;
	}

	@Override
	public void setRequiredLibId(long requiredLibId) {
		_requiredLibId = requiredLibId;

		if (_requiredLibConfirmRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibConfirmRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiredLibId", long.class);

				method.invoke(_requiredLibConfirmRemoteModel, requiredLibId);
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

		if (_requiredLibConfirmRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibConfirmRemoteModel.getClass();

				Method method = clazz.getMethod("setScienceAppId", long.class);

				method.invoke(_requiredLibConfirmRemoteModel, scienceAppId);
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

		if (_requiredLibConfirmRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibConfirmRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_requiredLibConfirmRemoteModel, companyId);
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

		if (_requiredLibConfirmRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibConfirmRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_requiredLibConfirmRemoteModel, userId);
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
	public Date getRequiredDate() {
		return _requiredDate;
	}

	@Override
	public void setRequiredDate(Date requiredDate) {
		_requiredDate = requiredDate;

		if (_requiredLibConfirmRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibConfirmRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiredDate", Date.class);

				method.invoke(_requiredLibConfirmRemoteModel, requiredDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getConfirmDate() {
		return _confirmDate;
	}

	@Override
	public void setConfirmDate(Date confirmDate) {
		_confirmDate = confirmDate;

		if (_requiredLibConfirmRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibConfirmRemoteModel.getClass();

				Method method = clazz.getMethod("setConfirmDate", Date.class);

				method.invoke(_requiredLibConfirmRemoteModel, confirmDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLibraryName() {
		return _libraryName;
	}

	@Override
	public void setLibraryName(String libraryName) {
		_libraryName = libraryName;

		if (_requiredLibConfirmRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibConfirmRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryName", String.class);

				method.invoke(_requiredLibConfirmRemoteModel, libraryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLibraryVersion() {
		return _libraryVersion;
	}

	@Override
	public void setLibraryVersion(String libraryVersion) {
		_libraryVersion = libraryVersion;

		if (_requiredLibConfirmRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibConfirmRemoteModel.getClass();

				Method method = clazz.getMethod("setLibraryVersion",
						String.class);

				method.invoke(_requiredLibConfirmRemoteModel, libraryVersion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRequiredContent() {
		return _requiredContent;
	}

	@Override
	public void setRequiredContent(String requiredContent) {
		_requiredContent = requiredContent;

		if (_requiredLibConfirmRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibConfirmRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiredContent",
						String.class);

				method.invoke(_requiredLibConfirmRemoteModel, requiredContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRequiredState() {
		return _requiredState;
	}

	@Override
	public void setRequiredState(String requiredState) {
		_requiredState = requiredState;

		if (_requiredLibConfirmRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibConfirmRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiredState", String.class);

				method.invoke(_requiredLibConfirmRemoteModel, requiredState);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getConfirmContent() {
		return _confirmContent;
	}

	@Override
	public void setConfirmContent(String confirmContent) {
		_confirmContent = confirmContent;

		if (_requiredLibConfirmRemoteModel != null) {
			try {
				Class<?> clazz = _requiredLibConfirmRemoteModel.getClass();

				Method method = clazz.getMethod("setConfirmContent",
						String.class);

				method.invoke(_requiredLibConfirmRemoteModel, confirmContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getRequiredLibConfirmRemoteModel() {
		return _requiredLibConfirmRemoteModel;
	}

	public void setRequiredLibConfirmRemoteModel(
		BaseModel<?> requiredLibConfirmRemoteModel) {
		_requiredLibConfirmRemoteModel = requiredLibConfirmRemoteModel;
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

		Class<?> remoteModelClass = _requiredLibConfirmRemoteModel.getClass();

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

		Object returnValue = method.invoke(_requiredLibConfirmRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RequiredLibConfirmLocalServiceUtil.addRequiredLibConfirm(this);
		}
		else {
			RequiredLibConfirmLocalServiceUtil.updateRequiredLibConfirm(this);
		}
	}

	@Override
	public RequiredLibConfirm toEscapedModel() {
		return (RequiredLibConfirm)ProxyUtil.newProxyInstance(RequiredLibConfirm.class.getClassLoader(),
			new Class[] { RequiredLibConfirm.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RequiredLibConfirmClp clone = new RequiredLibConfirmClp();

		clone.setRequiredLibId(getRequiredLibId());
		clone.setScienceAppId(getScienceAppId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setRequiredDate(getRequiredDate());
		clone.setConfirmDate(getConfirmDate());
		clone.setLibraryName(getLibraryName());
		clone.setLibraryVersion(getLibraryVersion());
		clone.setRequiredContent(getRequiredContent());
		clone.setRequiredState(getRequiredState());
		clone.setConfirmContent(getConfirmContent());

		return clone;
	}

	@Override
	public int compareTo(RequiredLibConfirm requiredLibConfirm) {
		RequiredLibConfirmPK primaryKey = requiredLibConfirm.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RequiredLibConfirmClp)) {
			return false;
		}

		RequiredLibConfirmClp requiredLibConfirm = (RequiredLibConfirmClp)obj;

		RequiredLibConfirmPK primaryKey = requiredLibConfirm.getPrimaryKey();

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

		sb.append("{requiredLibId=");
		sb.append(getRequiredLibId());
		sb.append(", scienceAppId=");
		sb.append(getScienceAppId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", requiredDate=");
		sb.append(getRequiredDate());
		sb.append(", confirmDate=");
		sb.append(getConfirmDate());
		sb.append(", libraryName=");
		sb.append(getLibraryName());
		sb.append(", libraryVersion=");
		sb.append(getLibraryVersion());
		sb.append(", requiredContent=");
		sb.append(getRequiredContent());
		sb.append(", requiredState=");
		sb.append(getRequiredState());
		sb.append(", confirmContent=");
		sb.append(getConfirmContent());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.science.model.RequiredLibConfirm");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>requiredLibId</column-name><column-value><![CDATA[");
		sb.append(getRequiredLibId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scienceAppId</column-name><column-value><![CDATA[");
		sb.append(getScienceAppId());
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
			"<column><column-name>requiredDate</column-name><column-value><![CDATA[");
		sb.append(getRequiredDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>confirmDate</column-name><column-value><![CDATA[");
		sb.append(getConfirmDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryName</column-name><column-value><![CDATA[");
		sb.append(getLibraryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>libraryVersion</column-name><column-value><![CDATA[");
		sb.append(getLibraryVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requiredContent</column-name><column-value><![CDATA[");
		sb.append(getRequiredContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requiredState</column-name><column-value><![CDATA[");
		sb.append(getRequiredState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>confirmContent</column-name><column-value><![CDATA[");
		sb.append(getConfirmContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _requiredLibId;
	private long _scienceAppId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _requiredDate;
	private Date _confirmDate;
	private String _libraryName;
	private String _libraryVersion;
	private String _requiredContent;
	private String _requiredState;
	private String _confirmContent;
	private BaseModel<?> _requiredLibConfirmRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.science.service.ClpSerializer.class;
}