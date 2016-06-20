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

import org.kisti.edison.model.Workflow;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Workflow in entity cache.
 *
 * @author EDISON
 * @see Workflow
 * @generated
 */
public class WorkflowCacheModel implements CacheModel<Workflow>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{workflowId=");
		sb.append(workflowId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", isPublic=");
		sb.append(isPublic);
		sb.append(", parentWorkflowId=");
		sb.append(parentWorkflowId);
		sb.append(", screenLogic=");
		sb.append(screenLogic);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Workflow toEntityModel() {
		WorkflowImpl workflowImpl = new WorkflowImpl();

		workflowImpl.setWorkflowId(workflowId);
		workflowImpl.setCompanyId(companyId);
		workflowImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			workflowImpl.setCreateDate(null);
		}
		else {
			workflowImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workflowImpl.setModifiedDate(null);
		}
		else {
			workflowImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			workflowImpl.setTitle(StringPool.BLANK);
		}
		else {
			workflowImpl.setTitle(title);
		}

		if (description == null) {
			workflowImpl.setDescription(StringPool.BLANK);
		}
		else {
			workflowImpl.setDescription(description);
		}

		workflowImpl.setIsPublic(isPublic);
		workflowImpl.setParentWorkflowId(parentWorkflowId);

		if (screenLogic == null) {
			workflowImpl.setScreenLogic(StringPool.BLANK);
		}
		else {
			workflowImpl.setScreenLogic(screenLogic);
		}

		workflowImpl.resetOriginalValues();

		return workflowImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workflowId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		isPublic = objectInput.readBoolean();
		parentWorkflowId = objectInput.readLong();
		screenLogic = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(workflowId);
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

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeBoolean(isPublic);
		objectOutput.writeLong(parentWorkflowId);

		if (screenLogic == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(screenLogic);
		}
	}

	public long workflowId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public boolean isPublic;
	public long parentWorkflowId;
	public String screenLogic;
}