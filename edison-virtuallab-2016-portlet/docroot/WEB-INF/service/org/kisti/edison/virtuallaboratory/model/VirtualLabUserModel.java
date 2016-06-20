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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the VirtualLabUser service. Represents a row in the &quot;EDVIR_VirtualLabUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserImpl}.
 * </p>
 *
 * @author EDISON
 * @see VirtualLabUser
 * @see org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserImpl
 * @see org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl
 * @generated
 */
public interface VirtualLabUserModel extends BaseModel<VirtualLabUser> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a virtual lab user model instance should use the {@link VirtualLabUser} interface instead.
	 */

	/**
	 * Returns the primary key of this virtual lab user.
	 *
	 * @return the primary key of this virtual lab user
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this virtual lab user.
	 *
	 * @param primaryKey the primary key of this virtual lab user
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the virtual lab user ID of this virtual lab user.
	 *
	 * @return the virtual lab user ID of this virtual lab user
	 */
	public long getVirtualLabUserId();

	/**
	 * Sets the virtual lab user ID of this virtual lab user.
	 *
	 * @param virtualLabUserId the virtual lab user ID of this virtual lab user
	 */
	public void setVirtualLabUserId(long virtualLabUserId);

	/**
	 * Returns the virtual lab user uuid of this virtual lab user.
	 *
	 * @return the virtual lab user uuid of this virtual lab user
	 * @throws SystemException if a system exception occurred
	 */
	public String getVirtualLabUserUuid() throws SystemException;

	/**
	 * Sets the virtual lab user uuid of this virtual lab user.
	 *
	 * @param virtualLabUserUuid the virtual lab user uuid of this virtual lab user
	 */
	public void setVirtualLabUserUuid(String virtualLabUserUuid);

	/**
	 * Returns the user ID of this virtual lab user.
	 *
	 * @return the user ID of this virtual lab user
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this virtual lab user.
	 *
	 * @param userId the user ID of this virtual lab user
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this virtual lab user.
	 *
	 * @return the user uuid of this virtual lab user
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this virtual lab user.
	 *
	 * @param userUuid the user uuid of this virtual lab user
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user student number of this virtual lab user.
	 *
	 * @return the user student number of this virtual lab user
	 */
	@AutoEscape
	public String getUserStudentNumber();

	/**
	 * Sets the user student number of this virtual lab user.
	 *
	 * @param userStudentNumber the user student number of this virtual lab user
	 */
	public void setUserStudentNumber(String userStudentNumber);

	/**
	 * Returns the auth role of this virtual lab user.
	 *
	 * @return the auth role of this virtual lab user
	 */
	@AutoEscape
	public String getAuthRole();

	/**
	 * Sets the auth role of this virtual lab user.
	 *
	 * @param authRole the auth role of this virtual lab user
	 */
	public void setAuthRole(String authRole);

	/**
	 * Returns the user use yn of this virtual lab user.
	 *
	 * @return the user use yn of this virtual lab user
	 */
	@AutoEscape
	public String getUserUseYn();

	/**
	 * Sets the user use yn of this virtual lab user.
	 *
	 * @param userUseYn the user use yn of this virtual lab user
	 */
	public void setUserUseYn(String userUseYn);

	/**
	 * Returns the request sort of this virtual lab user.
	 *
	 * @return the request sort of this virtual lab user
	 */
	@AutoEscape
	public String getRequestSort();

	/**
	 * Sets the request sort of this virtual lab user.
	 *
	 * @param requestSort the request sort of this virtual lab user
	 */
	public void setRequestSort(String requestSort);

	/**
	 * Returns the process note of this virtual lab user.
	 *
	 * @return the process note of this virtual lab user
	 */
	@AutoEscape
	public String getProcessNote();

	/**
	 * Sets the process note of this virtual lab user.
	 *
	 * @param processNote the process note of this virtual lab user
	 */
	public void setProcessNote(String processNote);

	/**
	 * Returns the process date of this virtual lab user.
	 *
	 * @return the process date of this virtual lab user
	 */
	public Date getProcessDate();

	/**
	 * Sets the process date of this virtual lab user.
	 *
	 * @param processDate the process date of this virtual lab user
	 */
	public void setProcessDate(Date processDate);

	/**
	 * Returns the create dt of this virtual lab user.
	 *
	 * @return the create dt of this virtual lab user
	 */
	public Date getCreateDt();

	/**
	 * Sets the create dt of this virtual lab user.
	 *
	 * @param createDt the create dt of this virtual lab user
	 */
	public void setCreateDt(Date createDt);

	/**
	 * Returns the update dt of this virtual lab user.
	 *
	 * @return the update dt of this virtual lab user
	 */
	public Date getUpdateDt();

	/**
	 * Sets the update dt of this virtual lab user.
	 *
	 * @param updateDt the update dt of this virtual lab user
	 */
	public void setUpdateDt(Date updateDt);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser);

	@Override
	public int hashCode();

	@Override
	public CacheModel<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> toCacheModel();

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser toEscapedModel();

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabUser toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}