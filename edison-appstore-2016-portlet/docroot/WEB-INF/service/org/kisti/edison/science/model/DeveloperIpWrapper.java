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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DeveloperIp}.
 * </p>
 *
 * @author EDISON
 * @see DeveloperIp
 * @generated
 */
public class DeveloperIpWrapper implements DeveloperIp,
	ModelWrapper<DeveloperIp> {
	public DeveloperIpWrapper(DeveloperIp developerIp) {
		_developerIp = developerIp;
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

	/**
	* Returns the primary key of this developer ip.
	*
	* @return the primary key of this developer ip
	*/
	@Override
	public org.kisti.edison.science.service.persistence.DeveloperIpPK getPrimaryKey() {
		return _developerIp.getPrimaryKey();
	}

	/**
	* Sets the primary key of this developer ip.
	*
	* @param primaryKey the primary key of this developer ip
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.science.service.persistence.DeveloperIpPK primaryKey) {
		_developerIp.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ip seq of this developer ip.
	*
	* @return the ip seq of this developer ip
	*/
	@Override
	public long getIpSeq() {
		return _developerIp.getIpSeq();
	}

	/**
	* Sets the ip seq of this developer ip.
	*
	* @param ipSeq the ip seq of this developer ip
	*/
	@Override
	public void setIpSeq(long ipSeq) {
		_developerIp.setIpSeq(ipSeq);
	}

	/**
	* Returns the user ID of this developer ip.
	*
	* @return the user ID of this developer ip
	*/
	@Override
	public long getUserId() {
		return _developerIp.getUserId();
	}

	/**
	* Sets the user ID of this developer ip.
	*
	* @param userId the user ID of this developer ip
	*/
	@Override
	public void setUserId(long userId) {
		_developerIp.setUserId(userId);
	}

	/**
	* Returns the user uuid of this developer ip.
	*
	* @return the user uuid of this developer ip
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerIp.getUserUuid();
	}

	/**
	* Sets the user uuid of this developer ip.
	*
	* @param userUuid the user uuid of this developer ip
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_developerIp.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this developer ip.
	*
	* @return the group ID of this developer ip
	*/
	@Override
	public long getGroupId() {
		return _developerIp.getGroupId();
	}

	/**
	* Sets the group ID of this developer ip.
	*
	* @param groupId the group ID of this developer ip
	*/
	@Override
	public void setGroupId(long groupId) {
		_developerIp.setGroupId(groupId);
	}

	/**
	* Returns the ip1 of this developer ip.
	*
	* @return the ip1 of this developer ip
	*/
	@Override
	public java.lang.String getIp1() {
		return _developerIp.getIp1();
	}

	/**
	* Sets the ip1 of this developer ip.
	*
	* @param ip1 the ip1 of this developer ip
	*/
	@Override
	public void setIp1(java.lang.String ip1) {
		_developerIp.setIp1(ip1);
	}

	/**
	* Returns the ip2 of this developer ip.
	*
	* @return the ip2 of this developer ip
	*/
	@Override
	public java.lang.String getIp2() {
		return _developerIp.getIp2();
	}

	/**
	* Sets the ip2 of this developer ip.
	*
	* @param ip2 the ip2 of this developer ip
	*/
	@Override
	public void setIp2(java.lang.String ip2) {
		_developerIp.setIp2(ip2);
	}

	/**
	* Returns the ip3 of this developer ip.
	*
	* @return the ip3 of this developer ip
	*/
	@Override
	public java.lang.String getIp3() {
		return _developerIp.getIp3();
	}

	/**
	* Sets the ip3 of this developer ip.
	*
	* @param ip3 the ip3 of this developer ip
	*/
	@Override
	public void setIp3(java.lang.String ip3) {
		_developerIp.setIp3(ip3);
	}

	/**
	* Returns the ip4 of this developer ip.
	*
	* @return the ip4 of this developer ip
	*/
	@Override
	public java.lang.String getIp4() {
		return _developerIp.getIp4();
	}

	/**
	* Sets the ip4 of this developer ip.
	*
	* @param ip4 the ip4 of this developer ip
	*/
	@Override
	public void setIp4(java.lang.String ip4) {
		_developerIp.setIp4(ip4);
	}

	/**
	* Returns the insert ID of this developer ip.
	*
	* @return the insert ID of this developer ip
	*/
	@Override
	public long getInsertId() {
		return _developerIp.getInsertId();
	}

	/**
	* Sets the insert ID of this developer ip.
	*
	* @param insertId the insert ID of this developer ip
	*/
	@Override
	public void setInsertId(long insertId) {
		_developerIp.setInsertId(insertId);
	}

	/**
	* Returns the insert date of this developer ip.
	*
	* @return the insert date of this developer ip
	*/
	@Override
	public java.util.Date getInsertDate() {
		return _developerIp.getInsertDate();
	}

	/**
	* Sets the insert date of this developer ip.
	*
	* @param insertDate the insert date of this developer ip
	*/
	@Override
	public void setInsertDate(java.util.Date insertDate) {
		_developerIp.setInsertDate(insertDate);
	}

	/**
	* Returns the update ID of this developer ip.
	*
	* @return the update ID of this developer ip
	*/
	@Override
	public long getUpdateId() {
		return _developerIp.getUpdateId();
	}

	/**
	* Sets the update ID of this developer ip.
	*
	* @param updateId the update ID of this developer ip
	*/
	@Override
	public void setUpdateId(long updateId) {
		_developerIp.setUpdateId(updateId);
	}

	/**
	* Returns the update date of this developer ip.
	*
	* @return the update date of this developer ip
	*/
	@Override
	public java.util.Date getUpdateDate() {
		return _developerIp.getUpdateDate();
	}

	/**
	* Sets the update date of this developer ip.
	*
	* @param updateDate the update date of this developer ip
	*/
	@Override
	public void setUpdateDate(java.util.Date updateDate) {
		_developerIp.setUpdateDate(updateDate);
	}

	@Override
	public boolean isNew() {
		return _developerIp.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_developerIp.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _developerIp.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_developerIp.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _developerIp.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _developerIp.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_developerIp.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _developerIp.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_developerIp.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_developerIp.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_developerIp.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DeveloperIpWrapper((DeveloperIp)_developerIp.clone());
	}

	@Override
	public int compareTo(org.kisti.edison.science.model.DeveloperIp developerIp) {
		return _developerIp.compareTo(developerIp);
	}

	@Override
	public int hashCode() {
		return _developerIp.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.science.model.DeveloperIp> toCacheModel() {
		return _developerIp.toCacheModel();
	}

	@Override
	public org.kisti.edison.science.model.DeveloperIp toEscapedModel() {
		return new DeveloperIpWrapper(_developerIp.toEscapedModel());
	}

	@Override
	public org.kisti.edison.science.model.DeveloperIp toUnescapedModel() {
		return new DeveloperIpWrapper(_developerIp.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _developerIp.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _developerIp.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_developerIp.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DeveloperIpWrapper)) {
			return false;
		}

		DeveloperIpWrapper developerIpWrapper = (DeveloperIpWrapper)obj;

		if (Validator.equals(_developerIp, developerIpWrapper._developerIp)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DeveloperIp getWrappedDeveloperIp() {
		return _developerIp;
	}

	@Override
	public DeveloperIp getWrappedModel() {
		return _developerIp;
	}

	@Override
	public void resetOriginalValues() {
		_developerIp.resetOriginalValues();
	}

	private DeveloperIp _developerIp;
}