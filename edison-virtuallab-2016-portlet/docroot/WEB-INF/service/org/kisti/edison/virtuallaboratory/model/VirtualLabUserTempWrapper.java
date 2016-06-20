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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VirtualLabUserTemp}.
 * </p>
 *
 * @author EDISON
 * @see VirtualLabUserTemp
 * @generated
 */
public class VirtualLabUserTempWrapper implements VirtualLabUserTemp,
	ModelWrapper<VirtualLabUserTemp> {
	public VirtualLabUserTempWrapper(VirtualLabUserTemp virtualLabUserTemp) {
		_virtualLabUserTemp = virtualLabUserTemp;
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

	/**
	* Returns the primary key of this virtual lab user temp.
	*
	* @return the primary key of this virtual lab user temp
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.service.persistence.VirtualLabUserTempPK getPrimaryKey() {
		return _virtualLabUserTemp.getPrimaryKey();
	}

	/**
	* Sets the primary key of this virtual lab user temp.
	*
	* @param primaryKey the primary key of this virtual lab user temp
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.virtuallaboratory.service.persistence.VirtualLabUserTempPK primaryKey) {
		_virtualLabUserTemp.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the seq no of this virtual lab user temp.
	*
	* @return the seq no of this virtual lab user temp
	*/
	@Override
	public long getSeqNo() {
		return _virtualLabUserTemp.getSeqNo();
	}

	/**
	* Sets the seq no of this virtual lab user temp.
	*
	* @param seqNo the seq no of this virtual lab user temp
	*/
	@Override
	public void setSeqNo(long seqNo) {
		_virtualLabUserTemp.setSeqNo(seqNo);
	}

	/**
	* Returns the virtual lab ID of this virtual lab user temp.
	*
	* @return the virtual lab ID of this virtual lab user temp
	*/
	@Override
	public long getVirtualLabId() {
		return _virtualLabUserTemp.getVirtualLabId();
	}

	/**
	* Sets the virtual lab ID of this virtual lab user temp.
	*
	* @param virtualLabId the virtual lab ID of this virtual lab user temp
	*/
	@Override
	public void setVirtualLabId(long virtualLabId) {
		_virtualLabUserTemp.setVirtualLabId(virtualLabId);
	}

	/**
	* Returns the class ID of this virtual lab user temp.
	*
	* @return the class ID of this virtual lab user temp
	*/
	@Override
	public long getClassId() {
		return _virtualLabUserTemp.getClassId();
	}

	/**
	* Sets the class ID of this virtual lab user temp.
	*
	* @param classId the class ID of this virtual lab user temp
	*/
	@Override
	public void setClassId(long classId) {
		_virtualLabUserTemp.setClassId(classId);
	}

	/**
	* Returns the user student number of this virtual lab user temp.
	*
	* @return the user student number of this virtual lab user temp
	*/
	@Override
	public java.lang.String getUserStudentNumber() {
		return _virtualLabUserTemp.getUserStudentNumber();
	}

	/**
	* Sets the user student number of this virtual lab user temp.
	*
	* @param userStudentNumber the user student number of this virtual lab user temp
	*/
	@Override
	public void setUserStudentNumber(java.lang.String userStudentNumber) {
		_virtualLabUserTemp.setUserStudentNumber(userStudentNumber);
	}

	/**
	* Returns the user name of this virtual lab user temp.
	*
	* @return the user name of this virtual lab user temp
	*/
	@Override
	public java.lang.String getUserName() {
		return _virtualLabUserTemp.getUserName();
	}

	/**
	* Sets the user name of this virtual lab user temp.
	*
	* @param userName the user name of this virtual lab user temp
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_virtualLabUserTemp.setUserName(userName);
	}

	/**
	* Returns the status of this virtual lab user temp.
	*
	* @return the status of this virtual lab user temp
	*/
	@Override
	public boolean getStatus() {
		return _virtualLabUserTemp.getStatus();
	}

	/**
	* Returns <code>true</code> if this virtual lab user temp is status.
	*
	* @return <code>true</code> if this virtual lab user temp is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _virtualLabUserTemp.isStatus();
	}

	/**
	* Sets whether this virtual lab user temp is status.
	*
	* @param status the status of this virtual lab user temp
	*/
	@Override
	public void setStatus(boolean status) {
		_virtualLabUserTemp.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _virtualLabUserTemp.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_virtualLabUserTemp.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _virtualLabUserTemp.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_virtualLabUserTemp.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _virtualLabUserTemp.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _virtualLabUserTemp.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_virtualLabUserTemp.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _virtualLabUserTemp.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_virtualLabUserTemp.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_virtualLabUserTemp.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_virtualLabUserTemp.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VirtualLabUserTempWrapper((VirtualLabUserTemp)_virtualLabUserTemp.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp virtualLabUserTemp) {
		return _virtualLabUserTemp.compareTo(virtualLabUserTemp);
	}

	@Override
	public int hashCode() {
		return _virtualLabUserTemp.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp> toCacheModel() {
		return _virtualLabUserTemp.toCacheModel();
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp toEscapedModel() {
		return new VirtualLabUserTempWrapper(_virtualLabUserTemp.toEscapedModel());
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp toUnescapedModel() {
		return new VirtualLabUserTempWrapper(_virtualLabUserTemp.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _virtualLabUserTemp.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _virtualLabUserTemp.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabUserTemp.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VirtualLabUserTempWrapper)) {
			return false;
		}

		VirtualLabUserTempWrapper virtualLabUserTempWrapper = (VirtualLabUserTempWrapper)obj;

		if (Validator.equals(_virtualLabUserTemp,
					virtualLabUserTempWrapper._virtualLabUserTemp)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VirtualLabUserTemp getWrappedVirtualLabUserTemp() {
		return _virtualLabUserTemp;
	}

	@Override
	public VirtualLabUserTemp getWrappedModel() {
		return _virtualLabUserTemp;
	}

	@Override
	public void resetOriginalValues() {
		_virtualLabUserTemp.resetOriginalValues();
	}

	private VirtualLabUserTemp _virtualLabUserTemp;
}