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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VirtualLabUser}.
 * </p>
 *
 * @author EDISON
 * @see VirtualLabUser
 * @generated
 */
public class VirtualLabUserWrapper implements VirtualLabUser,
	ModelWrapper<VirtualLabUser> {
	public VirtualLabUserWrapper(VirtualLabUser virtualLabUser) {
		_virtualLabUser = virtualLabUser;
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

	/**
	* Returns the primary key of this virtual lab user.
	*
	* @return the primary key of this virtual lab user
	*/
	@Override
	public long getPrimaryKey() {
		return _virtualLabUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this virtual lab user.
	*
	* @param primaryKey the primary key of this virtual lab user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_virtualLabUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the virtual lab user ID of this virtual lab user.
	*
	* @return the virtual lab user ID of this virtual lab user
	*/
	@Override
	public long getVirtualLabUserId() {
		return _virtualLabUser.getVirtualLabUserId();
	}

	/**
	* Sets the virtual lab user ID of this virtual lab user.
	*
	* @param virtualLabUserId the virtual lab user ID of this virtual lab user
	*/
	@Override
	public void setVirtualLabUserId(long virtualLabUserId) {
		_virtualLabUser.setVirtualLabUserId(virtualLabUserId);
	}

	/**
	* Returns the virtual lab user uuid of this virtual lab user.
	*
	* @return the virtual lab user uuid of this virtual lab user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getVirtualLabUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUser.getVirtualLabUserUuid();
	}

	/**
	* Sets the virtual lab user uuid of this virtual lab user.
	*
	* @param virtualLabUserUuid the virtual lab user uuid of this virtual lab user
	*/
	@Override
	public void setVirtualLabUserUuid(java.lang.String virtualLabUserUuid) {
		_virtualLabUser.setVirtualLabUserUuid(virtualLabUserUuid);
	}

	/**
	* Returns the user ID of this virtual lab user.
	*
	* @return the user ID of this virtual lab user
	*/
	@Override
	public long getUserId() {
		return _virtualLabUser.getUserId();
	}

	/**
	* Sets the user ID of this virtual lab user.
	*
	* @param userId the user ID of this virtual lab user
	*/
	@Override
	public void setUserId(long userId) {
		_virtualLabUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this virtual lab user.
	*
	* @return the user uuid of this virtual lab user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this virtual lab user.
	*
	* @param userUuid the user uuid of this virtual lab user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_virtualLabUser.setUserUuid(userUuid);
	}

	/**
	* Returns the user student number of this virtual lab user.
	*
	* @return the user student number of this virtual lab user
	*/
	@Override
	public java.lang.String getUserStudentNumber() {
		return _virtualLabUser.getUserStudentNumber();
	}

	/**
	* Sets the user student number of this virtual lab user.
	*
	* @param userStudentNumber the user student number of this virtual lab user
	*/
	@Override
	public void setUserStudentNumber(java.lang.String userStudentNumber) {
		_virtualLabUser.setUserStudentNumber(userStudentNumber);
	}

	/**
	* Returns the auth role of this virtual lab user.
	*
	* @return the auth role of this virtual lab user
	*/
	@Override
	public java.lang.String getAuthRole() {
		return _virtualLabUser.getAuthRole();
	}

	/**
	* Sets the auth role of this virtual lab user.
	*
	* @param authRole the auth role of this virtual lab user
	*/
	@Override
	public void setAuthRole(java.lang.String authRole) {
		_virtualLabUser.setAuthRole(authRole);
	}

	/**
	* Returns the user use yn of this virtual lab user.
	*
	* @return the user use yn of this virtual lab user
	*/
	@Override
	public java.lang.String getUserUseYn() {
		return _virtualLabUser.getUserUseYn();
	}

	/**
	* Sets the user use yn of this virtual lab user.
	*
	* @param userUseYn the user use yn of this virtual lab user
	*/
	@Override
	public void setUserUseYn(java.lang.String userUseYn) {
		_virtualLabUser.setUserUseYn(userUseYn);
	}

	/**
	* Returns the request sort of this virtual lab user.
	*
	* @return the request sort of this virtual lab user
	*/
	@Override
	public java.lang.String getRequestSort() {
		return _virtualLabUser.getRequestSort();
	}

	/**
	* Sets the request sort of this virtual lab user.
	*
	* @param requestSort the request sort of this virtual lab user
	*/
	@Override
	public void setRequestSort(java.lang.String requestSort) {
		_virtualLabUser.setRequestSort(requestSort);
	}

	/**
	* Returns the process note of this virtual lab user.
	*
	* @return the process note of this virtual lab user
	*/
	@Override
	public java.lang.String getProcessNote() {
		return _virtualLabUser.getProcessNote();
	}

	/**
	* Sets the process note of this virtual lab user.
	*
	* @param processNote the process note of this virtual lab user
	*/
	@Override
	public void setProcessNote(java.lang.String processNote) {
		_virtualLabUser.setProcessNote(processNote);
	}

	/**
	* Returns the process date of this virtual lab user.
	*
	* @return the process date of this virtual lab user
	*/
	@Override
	public java.util.Date getProcessDate() {
		return _virtualLabUser.getProcessDate();
	}

	/**
	* Sets the process date of this virtual lab user.
	*
	* @param processDate the process date of this virtual lab user
	*/
	@Override
	public void setProcessDate(java.util.Date processDate) {
		_virtualLabUser.setProcessDate(processDate);
	}

	/**
	* Returns the create dt of this virtual lab user.
	*
	* @return the create dt of this virtual lab user
	*/
	@Override
	public java.util.Date getCreateDt() {
		return _virtualLabUser.getCreateDt();
	}

	/**
	* Sets the create dt of this virtual lab user.
	*
	* @param createDt the create dt of this virtual lab user
	*/
	@Override
	public void setCreateDt(java.util.Date createDt) {
		_virtualLabUser.setCreateDt(createDt);
	}

	/**
	* Returns the update dt of this virtual lab user.
	*
	* @return the update dt of this virtual lab user
	*/
	@Override
	public java.util.Date getUpdateDt() {
		return _virtualLabUser.getUpdateDt();
	}

	/**
	* Sets the update dt of this virtual lab user.
	*
	* @param updateDt the update dt of this virtual lab user
	*/
	@Override
	public void setUpdateDt(java.util.Date updateDt) {
		_virtualLabUser.setUpdateDt(updateDt);
	}

	@Override
	public boolean isNew() {
		return _virtualLabUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_virtualLabUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _virtualLabUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_virtualLabUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _virtualLabUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _virtualLabUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_virtualLabUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _virtualLabUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_virtualLabUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_virtualLabUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_virtualLabUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VirtualLabUserWrapper((VirtualLabUser)_virtualLabUser.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser) {
		return _virtualLabUser.compareTo(virtualLabUser);
	}

	@Override
	public int hashCode() {
		return _virtualLabUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> toCacheModel() {
		return _virtualLabUser.toCacheModel();
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser toEscapedModel() {
		return new VirtualLabUserWrapper(_virtualLabUser.toEscapedModel());
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser toUnescapedModel() {
		return new VirtualLabUserWrapper(_virtualLabUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _virtualLabUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _virtualLabUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VirtualLabUserWrapper)) {
			return false;
		}

		VirtualLabUserWrapper virtualLabUserWrapper = (VirtualLabUserWrapper)obj;

		if (Validator.equals(_virtualLabUser,
					virtualLabUserWrapper._virtualLabUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VirtualLabUser getWrappedVirtualLabUser() {
		return _virtualLabUser;
	}

	@Override
	public VirtualLabUser getWrappedModel() {
		return _virtualLabUser;
	}

	@Override
	public void resetOriginalValues() {
		_virtualLabUser.resetOriginalValues();
	}

	private VirtualLabUser _virtualLabUser;
}