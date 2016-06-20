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

package org.kisti.edison.science.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.science.model.DeveloperRequest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DeveloperRequest in entity cache.
 *
 * @author EDISON
 * @see DeveloperRequest
 * @generated
 */
public class DeveloperRequestCacheModel implements CacheModel<DeveloperRequest>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{requestSeq=");
		sb.append(requestSeq);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", requestSort=");
		sb.append(requestSort);
		sb.append(", requestDate=");
		sb.append(requestDate);
		sb.append(", requestNote=");
		sb.append(requestNote);
		sb.append(", requestStatus=");
		sb.append(requestStatus);
		sb.append(", processDate=");
		sb.append(processDate);
		sb.append(", processNote=");
		sb.append(processNote);
		sb.append(", insertId=");
		sb.append(insertId);
		sb.append(", insertDate=");
		sb.append(insertDate);
		sb.append(", updateId=");
		sb.append(updateId);
		sb.append(", updateDate=");
		sb.append(updateDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DeveloperRequest toEntityModel() {
		DeveloperRequestImpl developerRequestImpl = new DeveloperRequestImpl();

		developerRequestImpl.setRequestSeq(requestSeq);
		developerRequestImpl.setUserId(userId);
		developerRequestImpl.setGroupId(groupId);

		if (requestSort == null) {
			developerRequestImpl.setRequestSort(StringPool.BLANK);
		}
		else {
			developerRequestImpl.setRequestSort(requestSort);
		}

		if (requestDate == Long.MIN_VALUE) {
			developerRequestImpl.setRequestDate(null);
		}
		else {
			developerRequestImpl.setRequestDate(new Date(requestDate));
		}

		if (requestNote == null) {
			developerRequestImpl.setRequestNote(StringPool.BLANK);
		}
		else {
			developerRequestImpl.setRequestNote(requestNote);
		}

		if (requestStatus == null) {
			developerRequestImpl.setRequestStatus(StringPool.BLANK);
		}
		else {
			developerRequestImpl.setRequestStatus(requestStatus);
		}

		if (processDate == Long.MIN_VALUE) {
			developerRequestImpl.setProcessDate(null);
		}
		else {
			developerRequestImpl.setProcessDate(new Date(processDate));
		}

		if (processNote == null) {
			developerRequestImpl.setProcessNote(StringPool.BLANK);
		}
		else {
			developerRequestImpl.setProcessNote(processNote);
		}

		developerRequestImpl.setInsertId(insertId);

		if (insertDate == Long.MIN_VALUE) {
			developerRequestImpl.setInsertDate(null);
		}
		else {
			developerRequestImpl.setInsertDate(new Date(insertDate));
		}

		developerRequestImpl.setUpdateId(updateId);

		if (updateDate == Long.MIN_VALUE) {
			developerRequestImpl.setUpdateDate(null);
		}
		else {
			developerRequestImpl.setUpdateDate(new Date(updateDate));
		}

		developerRequestImpl.resetOriginalValues();

		return developerRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		requestSeq = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		requestSort = objectInput.readUTF();
		requestDate = objectInput.readLong();
		requestNote = objectInput.readUTF();
		requestStatus = objectInput.readUTF();
		processDate = objectInput.readLong();
		processNote = objectInput.readUTF();
		insertId = objectInput.readLong();
		insertDate = objectInput.readLong();
		updateId = objectInput.readLong();
		updateDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(requestSeq);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(groupId);

		if (requestSort == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(requestSort);
		}

		objectOutput.writeLong(requestDate);

		if (requestNote == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(requestNote);
		}

		if (requestStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(requestStatus);
		}

		objectOutput.writeLong(processDate);

		if (processNote == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(processNote);
		}

		objectOutput.writeLong(insertId);
		objectOutput.writeLong(insertDate);
		objectOutput.writeLong(updateId);
		objectOutput.writeLong(updateDate);
	}

	public long requestSeq;
	public long userId;
	public long groupId;
	public String requestSort;
	public long requestDate;
	public String requestNote;
	public String requestStatus;
	public long processDate;
	public String processNote;
	public long insertId;
	public long insertDate;
	public long updateId;
	public long updateDate;
}