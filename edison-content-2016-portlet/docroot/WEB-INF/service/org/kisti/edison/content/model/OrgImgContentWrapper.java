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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OrgImgContent}.
 * </p>
 *
 * @author EDISON
 * @see OrgImgContent
 * @generated
 */
public class OrgImgContentWrapper implements OrgImgContent,
	ModelWrapper<OrgImgContent> {
	public OrgImgContentWrapper(OrgImgContent orgImgContent) {
		_orgImgContent = orgImgContent;
	}

	@Override
	public Class<?> getModelClass() {
		return OrgImgContent.class;
	}

	@Override
	public String getModelClassName() {
		return OrgImgContent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orgImgSeq", getOrgImgSeq());
		attributes.put("groupId", getGroupId());
		attributes.put("order", getOrder());
		attributes.put("orgNm", getOrgNm());
		attributes.put("orgLink", getOrgLink());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("insertId", getInsertId());
		attributes.put("insertDate", getInsertDate());
		attributes.put("updateId", getUpdateId());
		attributes.put("updateDate", getUpdateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orgImgSeq = (Long)attributes.get("orgImgSeq");

		if (orgImgSeq != null) {
			setOrgImgSeq(orgImgSeq);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long order = (Long)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String orgNm = (String)attributes.get("orgNm");

		if (orgNm != null) {
			setOrgNm(orgNm);
		}

		String orgLink = (String)attributes.get("orgLink");

		if (orgLink != null) {
			setOrgLink(orgLink);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
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
	* Returns the primary key of this org img content.
	*
	* @return the primary key of this org img content
	*/
	@Override
	public org.kisti.edison.content.service.persistence.OrgImgContentPK getPrimaryKey() {
		return _orgImgContent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this org img content.
	*
	* @param primaryKey the primary key of this org img content
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.content.service.persistence.OrgImgContentPK primaryKey) {
		_orgImgContent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the org img seq of this org img content.
	*
	* @return the org img seq of this org img content
	*/
	@Override
	public long getOrgImgSeq() {
		return _orgImgContent.getOrgImgSeq();
	}

	/**
	* Sets the org img seq of this org img content.
	*
	* @param orgImgSeq the org img seq of this org img content
	*/
	@Override
	public void setOrgImgSeq(long orgImgSeq) {
		_orgImgContent.setOrgImgSeq(orgImgSeq);
	}

	/**
	* Returns the group ID of this org img content.
	*
	* @return the group ID of this org img content
	*/
	@Override
	public long getGroupId() {
		return _orgImgContent.getGroupId();
	}

	/**
	* Sets the group ID of this org img content.
	*
	* @param groupId the group ID of this org img content
	*/
	@Override
	public void setGroupId(long groupId) {
		_orgImgContent.setGroupId(groupId);
	}

	/**
	* Returns the order of this org img content.
	*
	* @return the order of this org img content
	*/
	@Override
	public long getOrder() {
		return _orgImgContent.getOrder();
	}

	/**
	* Sets the order of this org img content.
	*
	* @param order the order of this org img content
	*/
	@Override
	public void setOrder(long order) {
		_orgImgContent.setOrder(order);
	}

	/**
	* Returns the org nm of this org img content.
	*
	* @return the org nm of this org img content
	*/
	@Override
	public java.lang.String getOrgNm() {
		return _orgImgContent.getOrgNm();
	}

	/**
	* Sets the org nm of this org img content.
	*
	* @param orgNm the org nm of this org img content
	*/
	@Override
	public void setOrgNm(java.lang.String orgNm) {
		_orgImgContent.setOrgNm(orgNm);
	}

	/**
	* Returns the org link of this org img content.
	*
	* @return the org link of this org img content
	*/
	@Override
	public java.lang.String getOrgLink() {
		return _orgImgContent.getOrgLink();
	}

	/**
	* Sets the org link of this org img content.
	*
	* @param orgLink the org link of this org img content
	*/
	@Override
	public void setOrgLink(java.lang.String orgLink) {
		_orgImgContent.setOrgLink(orgLink);
	}

	/**
	* Returns the file entry ID of this org img content.
	*
	* @return the file entry ID of this org img content
	*/
	@Override
	public long getFileEntryId() {
		return _orgImgContent.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this org img content.
	*
	* @param fileEntryId the file entry ID of this org img content
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_orgImgContent.setFileEntryId(fileEntryId);
	}

	/**
	* Returns the insert ID of this org img content.
	*
	* @return the insert ID of this org img content
	*/
	@Override
	public long getInsertId() {
		return _orgImgContent.getInsertId();
	}

	/**
	* Sets the insert ID of this org img content.
	*
	* @param insertId the insert ID of this org img content
	*/
	@Override
	public void setInsertId(long insertId) {
		_orgImgContent.setInsertId(insertId);
	}

	/**
	* Returns the insert date of this org img content.
	*
	* @return the insert date of this org img content
	*/
	@Override
	public java.util.Date getInsertDate() {
		return _orgImgContent.getInsertDate();
	}

	/**
	* Sets the insert date of this org img content.
	*
	* @param insertDate the insert date of this org img content
	*/
	@Override
	public void setInsertDate(java.util.Date insertDate) {
		_orgImgContent.setInsertDate(insertDate);
	}

	/**
	* Returns the update ID of this org img content.
	*
	* @return the update ID of this org img content
	*/
	@Override
	public long getUpdateId() {
		return _orgImgContent.getUpdateId();
	}

	/**
	* Sets the update ID of this org img content.
	*
	* @param updateId the update ID of this org img content
	*/
	@Override
	public void setUpdateId(long updateId) {
		_orgImgContent.setUpdateId(updateId);
	}

	/**
	* Returns the update date of this org img content.
	*
	* @return the update date of this org img content
	*/
	@Override
	public java.util.Date getUpdateDate() {
		return _orgImgContent.getUpdateDate();
	}

	/**
	* Sets the update date of this org img content.
	*
	* @param updateDate the update date of this org img content
	*/
	@Override
	public void setUpdateDate(java.util.Date updateDate) {
		_orgImgContent.setUpdateDate(updateDate);
	}

	@Override
	public boolean isNew() {
		return _orgImgContent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_orgImgContent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _orgImgContent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_orgImgContent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _orgImgContent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _orgImgContent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_orgImgContent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _orgImgContent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_orgImgContent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_orgImgContent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_orgImgContent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrgImgContentWrapper((OrgImgContent)_orgImgContent.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.content.model.OrgImgContent orgImgContent) {
		return _orgImgContent.compareTo(orgImgContent);
	}

	@Override
	public int hashCode() {
		return _orgImgContent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.content.model.OrgImgContent> toCacheModel() {
		return _orgImgContent.toCacheModel();
	}

	@Override
	public org.kisti.edison.content.model.OrgImgContent toEscapedModel() {
		return new OrgImgContentWrapper(_orgImgContent.toEscapedModel());
	}

	@Override
	public org.kisti.edison.content.model.OrgImgContent toUnescapedModel() {
		return new OrgImgContentWrapper(_orgImgContent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _orgImgContent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _orgImgContent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_orgImgContent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrgImgContentWrapper)) {
			return false;
		}

		OrgImgContentWrapper orgImgContentWrapper = (OrgImgContentWrapper)obj;

		if (Validator.equals(_orgImgContent, orgImgContentWrapper._orgImgContent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public OrgImgContent getWrappedOrgImgContent() {
		return _orgImgContent;
	}

	@Override
	public OrgImgContent getWrappedModel() {
		return _orgImgContent;
	}

	@Override
	public void resetOriginalValues() {
		_orgImgContent.resetOriginalValues();
	}

	private OrgImgContent _orgImgContent;
}