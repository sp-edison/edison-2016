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

package org.kisti.edison.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.model.WorkflowInstance;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkflowInstance in entity cache.
 *
 * @author EDISON
 * @see WorkflowInstance
 * @generated
 */
public class WorkflowInstanceCacheModel implements CacheModel<WorkflowInstance>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{workflowInstanceId=");
		sb.append(workflowInstanceId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", status=");
		sb.append(status);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", workflowId=");
		sb.append(workflowId);
		sb.append(", workflowUUID=");
		sb.append(workflowUUID);
		sb.append(", screenLogic=");
		sb.append(screenLogic);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkflowInstance toEntityModel() {
		WorkflowInstanceImpl workflowInstanceImpl = new WorkflowInstanceImpl();

		workflowInstanceImpl.setWorkflowInstanceId(workflowInstanceId);
		workflowInstanceImpl.setCompanyId(companyId);
		workflowInstanceImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			workflowInstanceImpl.setCreateDate(null);
		}
		else {
			workflowInstanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workflowInstanceImpl.setModifiedDate(null);
		}
		else {
			workflowInstanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			workflowInstanceImpl.setTitle(StringPool.BLANK);
		}
		else {
			workflowInstanceImpl.setTitle(title);
		}

		if (status == null) {
			workflowInstanceImpl.setStatus(StringPool.BLANK);
		}
		else {
			workflowInstanceImpl.setStatus(status);
		}

		if (startTime == Long.MIN_VALUE) {
			workflowInstanceImpl.setStartTime(null);
		}
		else {
			workflowInstanceImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			workflowInstanceImpl.setEndTime(null);
		}
		else {
			workflowInstanceImpl.setEndTime(new Date(endTime));
		}

		workflowInstanceImpl.setWorkflowId(workflowId);

		if (workflowUUID == null) {
			workflowInstanceImpl.setWorkflowUUID(StringPool.BLANK);
		}
		else {
			workflowInstanceImpl.setWorkflowUUID(workflowUUID);
		}

		if (screenLogic == null) {
			workflowInstanceImpl.setScreenLogic(StringPool.BLANK);
		}
		else {
			workflowInstanceImpl.setScreenLogic(screenLogic);
		}

		workflowInstanceImpl.resetOriginalValues();

		return workflowInstanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workflowInstanceId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		status = objectInput.readUTF();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();
		workflowId = objectInput.readLong();
		workflowUUID = objectInput.readUTF();
		screenLogic = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(workflowInstanceId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);
		objectOutput.writeLong(workflowId);

		if (workflowUUID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workflowUUID);
		}

		if (screenLogic == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(screenLogic);
		}
	}

	public long workflowInstanceId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String status;
	public long startTime;
	public long endTime;
	public long workflowId;
	public String workflowUUID;
	public String screenLogic;
}