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
public class WorkflowSoap implements Serializable {
	public static WorkflowSoap toSoapModel(Workflow model) {
		WorkflowSoap soapModel = new WorkflowSoap();

		soapModel.setWorkflowId(model.getWorkflowId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setIsPublic(model.getIsPublic());
		soapModel.setParentWorkflowId(model.getParentWorkflowId());
		soapModel.setScreenLogic(model.getScreenLogic());

		return soapModel;
	}

	public static WorkflowSoap[] toSoapModels(Workflow[] models) {
		WorkflowSoap[] soapModels = new WorkflowSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkflowSoap[][] toSoapModels(Workflow[][] models) {
		WorkflowSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkflowSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkflowSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkflowSoap[] toSoapModels(List<Workflow> models) {
		List<WorkflowSoap> soapModels = new ArrayList<WorkflowSoap>(models.size());

		for (Workflow model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkflowSoap[soapModels.size()]);
	}

	public WorkflowSoap() {
	}

	public long getPrimaryKey() {
		return _workflowId;
	}

	public void setPrimaryKey(long pk) {
		setWorkflowId(pk);
	}

	public long getWorkflowId() {
		return _workflowId;
	}

	public void setWorkflowId(long workflowId) {
		_workflowId = workflowId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getIsPublic() {
		return _isPublic;
	}

	public boolean isIsPublic() {
		return _isPublic;
	}

	public void setIsPublic(boolean isPublic) {
		_isPublic = isPublic;
	}

	public long getParentWorkflowId() {
		return _parentWorkflowId;
	}

	public void setParentWorkflowId(long parentWorkflowId) {
		_parentWorkflowId = parentWorkflowId;
	}

	public String getScreenLogic() {
		return _screenLogic;
	}

	public void setScreenLogic(String screenLogic) {
		_screenLogic = screenLogic;
	}

	private long _workflowId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _description;
	private boolean _isPublic;
	private long _parentWorkflowId;
	private String _screenLogic;
}