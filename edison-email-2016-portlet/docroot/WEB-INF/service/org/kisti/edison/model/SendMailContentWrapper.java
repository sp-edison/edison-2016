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

package org.kisti.edison.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SendMailContent}.
 * </p>
 *
 * @author EDISON
 * @see SendMailContent
 * @generated
 */
public class SendMailContentWrapper implements SendMailContent,
	ModelWrapper<SendMailContent> {
	public SendMailContentWrapper(SendMailContent sendMailContent) {
		_sendMailContent = sendMailContent;
	}

	@Override
	public Class<?> getModelClass() {
		return SendMailContent.class;
	}

	@Override
	public String getModelClassName() {
		return SendMailContent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sendMailId", getSendMailId());
		attributes.put("userId", getUserId());
		attributes.put("sendCount", getSendCount());
		attributes.put("successCount", getSuccessCount());
		attributes.put("failCount", getFailCount());
		attributes.put("sendDate", getSendDate());
		attributes.put("siteGroup", getSiteGroup());
		attributes.put("userGroup", getUserGroup());
		attributes.put("state", getState());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sendMailId = (Long)attributes.get("sendMailId");

		if (sendMailId != null) {
			setSendMailId(sendMailId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Integer sendCount = (Integer)attributes.get("sendCount");

		if (sendCount != null) {
			setSendCount(sendCount);
		}

		Integer successCount = (Integer)attributes.get("successCount");

		if (successCount != null) {
			setSuccessCount(successCount);
		}

		Integer failCount = (Integer)attributes.get("failCount");

		if (failCount != null) {
			setFailCount(failCount);
		}

		Date sendDate = (Date)attributes.get("sendDate");

		if (sendDate != null) {
			setSendDate(sendDate);
		}

		String siteGroup = (String)attributes.get("siteGroup");

		if (siteGroup != null) {
			setSiteGroup(siteGroup);
		}

		String userGroup = (String)attributes.get("userGroup");

		if (userGroup != null) {
			setUserGroup(userGroup);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}
	}

	/**
	* Returns the primary key of this send mail content.
	*
	* @return the primary key of this send mail content
	*/
	@Override
	public long getPrimaryKey() {
		return _sendMailContent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this send mail content.
	*
	* @param primaryKey the primary key of this send mail content
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sendMailContent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the send mail ID of this send mail content.
	*
	* @return the send mail ID of this send mail content
	*/
	@Override
	public long getSendMailId() {
		return _sendMailContent.getSendMailId();
	}

	/**
	* Sets the send mail ID of this send mail content.
	*
	* @param sendMailId the send mail ID of this send mail content
	*/
	@Override
	public void setSendMailId(long sendMailId) {
		_sendMailContent.setSendMailId(sendMailId);
	}

	/**
	* Returns the user ID of this send mail content.
	*
	* @return the user ID of this send mail content
	*/
	@Override
	public long getUserId() {
		return _sendMailContent.getUserId();
	}

	/**
	* Sets the user ID of this send mail content.
	*
	* @param userId the user ID of this send mail content
	*/
	@Override
	public void setUserId(long userId) {
		_sendMailContent.setUserId(userId);
	}

	/**
	* Returns the user uuid of this send mail content.
	*
	* @return the user uuid of this send mail content
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sendMailContent.getUserUuid();
	}

	/**
	* Sets the user uuid of this send mail content.
	*
	* @param userUuid the user uuid of this send mail content
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_sendMailContent.setUserUuid(userUuid);
	}

	/**
	* Returns the send count of this send mail content.
	*
	* @return the send count of this send mail content
	*/
	@Override
	public int getSendCount() {
		return _sendMailContent.getSendCount();
	}

	/**
	* Sets the send count of this send mail content.
	*
	* @param sendCount the send count of this send mail content
	*/
	@Override
	public void setSendCount(int sendCount) {
		_sendMailContent.setSendCount(sendCount);
	}

	/**
	* Returns the success count of this send mail content.
	*
	* @return the success count of this send mail content
	*/
	@Override
	public int getSuccessCount() {
		return _sendMailContent.getSuccessCount();
	}

	/**
	* Sets the success count of this send mail content.
	*
	* @param successCount the success count of this send mail content
	*/
	@Override
	public void setSuccessCount(int successCount) {
		_sendMailContent.setSuccessCount(successCount);
	}

	/**
	* Returns the fail count of this send mail content.
	*
	* @return the fail count of this send mail content
	*/
	@Override
	public int getFailCount() {
		return _sendMailContent.getFailCount();
	}

	/**
	* Sets the fail count of this send mail content.
	*
	* @param failCount the fail count of this send mail content
	*/
	@Override
	public void setFailCount(int failCount) {
		_sendMailContent.setFailCount(failCount);
	}

	/**
	* Returns the send date of this send mail content.
	*
	* @return the send date of this send mail content
	*/
	@Override
	public java.util.Date getSendDate() {
		return _sendMailContent.getSendDate();
	}

	/**
	* Sets the send date of this send mail content.
	*
	* @param sendDate the send date of this send mail content
	*/
	@Override
	public void setSendDate(java.util.Date sendDate) {
		_sendMailContent.setSendDate(sendDate);
	}

	/**
	* Returns the site group of this send mail content.
	*
	* @return the site group of this send mail content
	*/
	@Override
	public java.lang.String getSiteGroup() {
		return _sendMailContent.getSiteGroup();
	}

	/**
	* Sets the site group of this send mail content.
	*
	* @param siteGroup the site group of this send mail content
	*/
	@Override
	public void setSiteGroup(java.lang.String siteGroup) {
		_sendMailContent.setSiteGroup(siteGroup);
	}

	/**
	* Returns the user group of this send mail content.
	*
	* @return the user group of this send mail content
	*/
	@Override
	public java.lang.String getUserGroup() {
		return _sendMailContent.getUserGroup();
	}

	/**
	* Sets the user group of this send mail content.
	*
	* @param userGroup the user group of this send mail content
	*/
	@Override
	public void setUserGroup(java.lang.String userGroup) {
		_sendMailContent.setUserGroup(userGroup);
	}

	/**
	* Returns the state of this send mail content.
	*
	* @return the state of this send mail content
	*/
	@Override
	public java.lang.String getState() {
		return _sendMailContent.getState();
	}

	/**
	* Sets the state of this send mail content.
	*
	* @param state the state of this send mail content
	*/
	@Override
	public void setState(java.lang.String state) {
		_sendMailContent.setState(state);
	}

	/**
	* Returns the title of this send mail content.
	*
	* @return the title of this send mail content
	*/
	@Override
	public java.lang.String getTitle() {
		return _sendMailContent.getTitle();
	}

	/**
	* Sets the title of this send mail content.
	*
	* @param title the title of this send mail content
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_sendMailContent.setTitle(title);
	}

	/**
	* Returns the content of this send mail content.
	*
	* @return the content of this send mail content
	*/
	@Override
	public java.lang.String getContent() {
		return _sendMailContent.getContent();
	}

	/**
	* Sets the content of this send mail content.
	*
	* @param content the content of this send mail content
	*/
	@Override
	public void setContent(java.lang.String content) {
		_sendMailContent.setContent(content);
	}

	@Override
	public boolean isNew() {
		return _sendMailContent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sendMailContent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sendMailContent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sendMailContent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sendMailContent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sendMailContent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sendMailContent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sendMailContent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sendMailContent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sendMailContent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sendMailContent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SendMailContentWrapper((SendMailContent)_sendMailContent.clone());
	}

	@Override
	public int compareTo(org.kisti.edison.model.SendMailContent sendMailContent) {
		return _sendMailContent.compareTo(sendMailContent);
	}

	@Override
	public int hashCode() {
		return _sendMailContent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.model.SendMailContent> toCacheModel() {
		return _sendMailContent.toCacheModel();
	}

	@Override
	public org.kisti.edison.model.SendMailContent toEscapedModel() {
		return new SendMailContentWrapper(_sendMailContent.toEscapedModel());
	}

	@Override
	public org.kisti.edison.model.SendMailContent toUnescapedModel() {
		return new SendMailContentWrapper(_sendMailContent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sendMailContent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sendMailContent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sendMailContent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SendMailContentWrapper)) {
			return false;
		}

		SendMailContentWrapper sendMailContentWrapper = (SendMailContentWrapper)obj;

		if (Validator.equals(_sendMailContent,
					sendMailContentWrapper._sendMailContent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SendMailContent getWrappedSendMailContent() {
		return _sendMailContent;
	}

	@Override
	public SendMailContent getWrappedModel() {
		return _sendMailContent;
	}

	@Override
	public void resetOriginalValues() {
		_sendMailContent.resetOriginalValues();
	}

	private SendMailContent _sendMailContent;
}