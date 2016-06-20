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
 * This class is used by SOAP remote services.
 *
 * @author EDISON
 * @generated
 */
public class WorkflowInstanceSoap implements Serializable {
	public static WorkflowInstanceSoap toSoapModel(WorkflowInstance model) {
		WorkflowInstanceSoap soapModel = new WorkflowInstanceSoap();

		soapModel.setWorkflowInstanceId(model.getWorkflowInstanceId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setStatus(model.getStatus());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setWorkflowId(model.getWorkflowId());
		soapModel.setWorkflowUUID(model.getWorkflowUUID());
		soapModel.setScreenLogic(model.getScreenLogic());

		return soapModel;
	}

	public static WorkflowInstanceSoap[] toSoapModels(WorkflowInstance[] models) {
		WorkflowInstanceSoap[] soapModels = new WorkflowInstanceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkflowInstanceSoap[][] toSoapModels(
		WorkflowInstance[][] models) {
		WorkflowInstanceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkflowInstanceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkflowInstanceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkflowInstanceSoap[] toSoapModels(
		List<WorkflowInstance> models) {
		List<WorkflowInstanceSoap> soapModels = new ArrayList<WorkflowInstanceSoap>(models.size());

		for (WorkflowInstance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkflowInstanceSoap[soapModels.size()]);
	}

	public WorkflowInstanceSoap() {
	}

	public long getPrimaryKey() {
		return _workflowInstanceId;
	}

	public void setPrimaryKey(long pk) {
		setWorkflowInstanceId(pk);
	}

	public long getWorkflowInstanceId() {
		return _workflowInstanceId;
	}

	public void setWorkflowInstanceId(long workflowInstanceId) {
		_workflowInstanceId = workflowInstanceId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public long getWorkflowId() {
		return _workflowId;
	}

	public void setWorkflowId(long workflowId) {
		_workflowId = workflowId;
	}

	public String getWorkflowUUID() {
		return _workflowUUID;
	}

	public void setWorkflowUUID(String workflowUUID) {
		_workflowUUID = workflowUUID;
	}

	public String getScreenLogic() {
		return _screenLogic;
	}

	public void setScreenLogic(String screenLogic) {
		_screenLogic = screenLogic;
	}

	private long _workflowInstanceId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _status;
	private Date _startTime;
	private Date _endTime;
	private long _workflowId;
	private String _workflowUUID;
	private String _screenLogic;
}