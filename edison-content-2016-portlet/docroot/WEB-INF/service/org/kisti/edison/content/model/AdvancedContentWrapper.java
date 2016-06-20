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
 * This class is a wrapper for {@link AdvancedContent}.
 * </p>
 *
 * @author EDISON
 * @see AdvancedContent
 * @generated
 */
public class AdvancedContentWrapper implements AdvancedContent,
	ModelWrapper<AdvancedContent> {
	public AdvancedContentWrapper(AdvancedContent advancedContent) {
		_advancedContent = advancedContent;
	}

	@Override
	public Class<?> getModelClass() {
		return AdvancedContent.class;
	}

	@Override
	public String getModelClassName() {
		return AdvancedContent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contentSeq", getContentSeq());
		attributes.put("groupId", getGroupId());
		attributes.put("title", getTitle());
		attributes.put("resume", getResume());
		attributes.put("contentFilePath", getContentFilePath());
		attributes.put("contentFileNm", getContentFileNm());
		attributes.put("contentStartFileNm", getContentStartFileNm());
		attributes.put("serviceLanguage", getServiceLanguage());
		attributes.put("viewCnt", getViewCnt());
		attributes.put("insertId", getInsertId());
		attributes.put("insertDate", getInsertDate());
		attributes.put("updateId", getUpdateId());
		attributes.put("updateDate", getUpdateDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contentSeq = (Long)attributes.get("contentSeq");

		if (contentSeq != null) {
			setContentSeq(contentSeq);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String resume = (String)attributes.get("resume");

		if (resume != null) {
			setResume(resume);
		}

		String contentFilePath = (String)attributes.get("contentFilePath");

		if (contentFilePath != null) {
			setContentFilePath(contentFilePath);
		}

		String contentFileNm = (String)attributes.get("contentFileNm");

		if (contentFileNm != null) {
			setContentFileNm(contentFileNm);
		}

		String contentStartFileNm = (String)attributes.get("contentStartFileNm");

		if (contentStartFileNm != null) {
			setContentStartFileNm(contentStartFileNm);
		}

		String serviceLanguage = (String)attributes.get("serviceLanguage");

		if (serviceLanguage != null) {
			setServiceLanguage(serviceLanguage);
		}

		Long viewCnt = (Long)attributes.get("viewCnt");

		if (viewCnt != null) {
			setViewCnt(viewCnt);
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
	* Returns the primary key of this advanced content.
	*
	* @return the primary key of this advanced content
	*/
	@Override
	public org.kisti.edison.content.service.persistence.AdvancedContentPK getPrimaryKey() {
		return _advancedContent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this advanced content.
	*
	* @param primaryKey the primary key of this advanced content
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.content.service.persistence.AdvancedContentPK primaryKey) {
		_advancedContent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the content seq of this advanced content.
	*
	* @return the content seq of this advanced content
	*/
	@Override
	public long getContentSeq() {
		return _advancedContent.getContentSeq();
	}

	/**
	* Sets the content seq of this advanced content.
	*
	* @param contentSeq the content seq of this advanced content
	*/
	@Override
	public void setContentSeq(long contentSeq) {
		_advancedContent.setContentSeq(contentSeq);
	}

	/**
	* Returns the group ID of this advanced content.
	*
	* @return the group ID of this advanced content
	*/
	@Override
	public long getGroupId() {
		return _advancedContent.getGroupId();
	}

	/**
	* Sets the group ID of this advanced content.
	*
	* @param groupId the group ID of this advanced content
	*/
	@Override
	public void setGroupId(long groupId) {
		_advancedContent.setGroupId(groupId);
	}

	/**
	* Returns the title of this advanced content.
	*
	* @return the title of this advanced content
	*/
	@Override
	public java.lang.String getTitle() {
		return _advancedContent.getTitle();
	}

	/**
	* Sets the title of this advanced content.
	*
	* @param title the title of this advanced content
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_advancedContent.setTitle(title);
	}

	/**
	* Returns the resume of this advanced content.
	*
	* @return the resume of this advanced content
	*/
	@Override
	public java.lang.String getResume() {
		return _advancedContent.getResume();
	}

	/**
	* Sets the resume of this advanced content.
	*
	* @param resume the resume of this advanced content
	*/
	@Override
	public void setResume(java.lang.String resume) {
		_advancedContent.setResume(resume);
	}

	/**
	* Returns the content file path of this advanced content.
	*
	* @return the content file path of this advanced content
	*/
	@Override
	public java.lang.String getContentFilePath() {
		return _advancedContent.getContentFilePath();
	}

	/**
	* Sets the content file path of this advanced content.
	*
	* @param contentFilePath the content file path of this advanced content
	*/
	@Override
	public void setContentFilePath(java.lang.String contentFilePath) {
		_advancedContent.setContentFilePath(contentFilePath);
	}

	/**
	* Returns the content file nm of this advanced content.
	*
	* @return the content file nm of this advanced content
	*/
	@Override
	public java.lang.String getContentFileNm() {
		return _advancedContent.getContentFileNm();
	}

	/**
	* Sets the content file nm of this advanced content.
	*
	* @param contentFileNm the content file nm of this advanced content
	*/
	@Override
	public void setContentFileNm(java.lang.String contentFileNm) {
		_advancedContent.setContentFileNm(contentFileNm);
	}

	/**
	* Returns the content start file nm of this advanced content.
	*
	* @return the content start file nm of this advanced content
	*/
	@Override
	public java.lang.String getContentStartFileNm() {
		return _advancedContent.getContentStartFileNm();
	}

	/**
	* Sets the content start file nm of this advanced content.
	*
	* @param contentStartFileNm the content start file nm of this advanced content
	*/
	@Override
	public void setContentStartFileNm(java.lang.String contentStartFileNm) {
		_advancedContent.setContentStartFileNm(contentStartFileNm);
	}

	/**
	* Returns the service language of this advanced content.
	*
	* @return the service language of this advanced content
	*/
	@Override
	public java.lang.String getServiceLanguage() {
		return _advancedContent.getServiceLanguage();
	}

	/**
	* Sets the service language of this advanced content.
	*
	* @param serviceLanguage the service language of this advanced content
	*/
	@Override
	public void setServiceLanguage(java.lang.String serviceLanguage) {
		_advancedContent.setServiceLanguage(serviceLanguage);
	}

	/**
	* Returns the view cnt of this advanced content.
	*
	* @return the view cnt of this advanced content
	*/
	@Override
	public long getViewCnt() {
		return _advancedContent.getViewCnt();
	}

	/**
	* Sets the view cnt of this advanced content.
	*
	* @param viewCnt the view cnt of this advanced content
	*/
	@Override
	public void setViewCnt(long viewCnt) {
		_advancedContent.setViewCnt(viewCnt);
	}

	/**
	* Returns the insert ID of this advanced content.
	*
	* @return the insert ID of this advanced content
	*/
	@Override
	public long getInsertId() {
		return _advancedContent.getInsertId();
	}

	/**
	* Sets the insert ID of this advanced content.
	*
	* @param insertId the insert ID of this advanced content
	*/
	@Override
	public void setInsertId(long insertId) {
		_advancedContent.setInsertId(insertId);
	}

	/**
	* Returns the insert date of this advanced content.
	*
	* @return the insert date of this advanced content
	*/
	@Override
	public java.util.Date getInsertDate() {
		return _advancedContent.getInsertDate();
	}

	/**
	* Sets the insert date of this advanced content.
	*
	* @param insertDate the insert date of this advanced content
	*/
	@Override
	public void setInsertDate(java.util.Date insertDate) {
		_advancedContent.setInsertDate(insertDate);
	}

	/**
	* Returns the update ID of this advanced content.
	*
	* @return the update ID of this advanced content
	*/
	@Override
	public long getUpdateId() {
		return _advancedContent.getUpdateId();
	}

	/**
	* Sets the update ID of this advanced content.
	*
	* @param updateId the update ID of this advanced content
	*/
	@Override
	public void setUpdateId(long updateId) {
		_advancedContent.setUpdateId(updateId);
	}

	/**
	* Returns the update date of this advanced content.
	*
	* @return the update date of this advanced content
	*/
	@Override
	public java.util.Date getUpdateDate() {
		return _advancedContent.getUpdateDate();
	}

	/**
	* Sets the update date of this advanced content.
	*
	* @param updateDate the update date of this advanced content
	*/
	@Override
	public void setUpdateDate(java.util.Date updateDate) {
		_advancedContent.setUpdateDate(updateDate);
	}

	@Override
	public boolean isNew() {
		return _advancedContent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_advancedContent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _advancedContent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_advancedContent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _advancedContent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _advancedContent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_advancedContent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _advancedContent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_advancedContent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_advancedContent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_advancedContent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AdvancedContentWrapper((AdvancedContent)_advancedContent.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.content.model.AdvancedContent advancedContent) {
		return _advancedContent.compareTo(advancedContent);
	}

	@Override
	public int hashCode() {
		return _advancedContent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.content.model.AdvancedContent> toCacheModel() {
		return _advancedContent.toCacheModel();
	}

	@Override
	public org.kisti.edison.content.model.AdvancedContent toEscapedModel() {
		return new AdvancedContentWrapper(_advancedContent.toEscapedModel());
	}

	@Override
	public org.kisti.edison.content.model.AdvancedContent toUnescapedModel() {
		return new AdvancedContentWrapper(_advancedContent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _advancedContent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _advancedContent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_advancedContent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdvancedContentWrapper)) {
			return false;
		}

		AdvancedContentWrapper advancedContentWrapper = (AdvancedContentWrapper)obj;

		if (Validator.equals(_advancedContent,
					advancedContentWrapper._advancedContent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AdvancedContent getWrappedAdvancedContent() {
		return _advancedContent;
	}

	@Override
	public AdvancedContent getWrappedModel() {
		return _advancedContent;
	}

	@Override
	public void resetOriginalValues() {
		_advancedContent.resetOriginalValues();
	}

	private AdvancedContent _advancedContent;
}