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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.service.http.SendMailContentServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.service.http.SendMailContentServiceSoap
 * @generated
 */
public class SendMailContentSoap implements Serializable {
	public static SendMailContentSoap toSoapModel(SendMailContent model) {
		SendMailContentSoap soapModel = new SendMailContentSoap();

		soapModel.setSendMailId(model.getSendMailId());
		soapModel.setUserId(model.getUserId());
		soapModel.setSendCount(model.getSendCount());
		soapModel.setSuccessCount(model.getSuccessCount());
		soapModel.setFailCount(model.getFailCount());
		soapModel.setSendDate(model.getSendDate());
		soapModel.setSiteGroup(model.getSiteGroup());
		soapModel.setUserGroup(model.getUserGroup());
		soapModel.setState(model.getState());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static SendMailContentSoap[] toSoapModels(SendMailContent[] models) {
		SendMailContentSoap[] soapModels = new SendMailContentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SendMailContentSoap[][] toSoapModels(
		SendMailContent[][] models) {
		SendMailContentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SendMailContentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SendMailContentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SendMailContentSoap[] toSoapModels(
		List<SendMailContent> models) {
		List<SendMailContentSoap> soapModels = new ArrayList<SendMailContentSoap>(models.size());

		for (SendMailContent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SendMailContentSoap[soapModels.size()]);
	}

	public SendMailContentSoap() {
	}

	public long getPrimaryKey() {
		return _sendMailId;
	}

	public void setPrimaryKey(long pk) {
		setSendMailId(pk);
	}

	public long getSendMailId() {
		return _sendMailId;
	}

	public void setSendMailId(long sendMailId) {
		_sendMailId = sendMailId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public int getSendCount() {
		return _sendCount;
	}

	public void setSendCount(int sendCount) {
		_sendCount = sendCount;
	}

	public int getSuccessCount() {
		return _successCount;
	}

	public void setSuccessCount(int successCount) {
		_successCount = successCount;
	}

	public int getFailCount() {
		return _failCount;
	}

	public void setFailCount(int failCount) {
		_failCount = failCount;
	}

	public Date getSendDate() {
		return _sendDate;
	}

	public void setSendDate(Date sendDate) {
		_sendDate = sendDate;
	}

	public String getSiteGroup() {
		return _siteGroup;
	}

	public void setSiteGroup(String siteGroup) {
		_siteGroup = siteGroup;
	}

	public String getUserGroup() {
		return _userGroup;
	}

	public void setUserGroup(String userGroup) {
		_userGroup = userGroup;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private long _sendMailId;
	private long _userId;
	private int _sendCount;
	private int _successCount;
	private int _failCount;
	private Date _sendDate;
	private String _siteGroup;
	private String _userGroup;
	private String _state;
	private String _title;
	private String _content;
}