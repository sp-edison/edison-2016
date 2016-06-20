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

package org.kisti.edison.virtuallaboratory.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.virtuallaboratory.model.VirtualLabUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VirtualLabUser in entity cache.
 *
 * @author EDISON
 * @see VirtualLabUser
 * @generated
 */
public class VirtualLabUserCacheModel implements CacheModel<VirtualLabUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{virtualLabUserId=");
		sb.append(virtualLabUserId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userStudentNumber=");
		sb.append(userStudentNumber);
		sb.append(", authRole=");
		sb.append(authRole);
		sb.append(", userUseYn=");
		sb.append(userUseYn);
		sb.append(", requestSort=");
		sb.append(requestSort);
		sb.append(", processNote=");
		sb.append(processNote);
		sb.append(", processDate=");
		sb.append(processDate);
		sb.append(", createDt=");
		sb.append(createDt);
		sb.append(", updateDt=");
		sb.append(updateDt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VirtualLabUser toEntityModel() {
		VirtualLabUserImpl virtualLabUserImpl = new VirtualLabUserImpl();

		virtualLabUserImpl.setVirtualLabUserId(virtualLabUserId);
		virtualLabUserImpl.setUserId(userId);

		if (userStudentNumber == null) {
			virtualLabUserImpl.setUserStudentNumber(StringPool.BLANK);
		}
		else {
			virtualLabUserImpl.setUserStudentNumber(userStudentNumber);
		}

		if (authRole == null) {
			virtualLabUserImpl.setAuthRole(StringPool.BLANK);
		}
		else {
			virtualLabUserImpl.setAuthRole(authRole);
		}

		if (userUseYn == null) {
			virtualLabUserImpl.setUserUseYn(StringPool.BLANK);
		}
		else {
			virtualLabUserImpl.setUserUseYn(userUseYn);
		}

		if (requestSort == null) {
			virtualLabUserImpl.setRequestSort(StringPool.BLANK);
		}
		else {
			virtualLabUserImpl.setRequestSort(requestSort);
		}

		if (processNote == null) {
			virtualLabUserImpl.setProcessNote(StringPool.BLANK);
		}
		else {
			virtualLabUserImpl.setProcessNote(processNote);
		}

		if (processDate == Long.MIN_VALUE) {
			virtualLabUserImpl.setProcessDate(null);
		}
		else {
			virtualLabUserImpl.setProcessDate(new Date(processDate));
		}

		if (createDt == Long.MIN_VALUE) {
			virtualLabUserImpl.setCreateDt(null);
		}
		else {
			virtualLabUserImpl.setCreateDt(new Date(createDt));
		}

		if (updateDt == Long.MIN_VALUE) {
			virtualLabUserImpl.setUpdateDt(null);
		}
		else {
			virtualLabUserImpl.setUpdateDt(new Date(updateDt));
		}

		virtualLabUserImpl.resetOriginalValues();

		return virtualLabUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		virtualLabUserId = objectInput.readLong();
		userId = objectInput.readLong();
		userStudentNumber = objectInput.readUTF();
		authRole = objectInput.readUTF();
		userUseYn = objectInput.readUTF();
		requestSort = objectInput.readUTF();
		processNote = objectInput.readUTF();
		processDate = objectInput.readLong();
		createDt = objectInput.readLong();
		updateDt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(virtualLabUserId);
		objectOutput.writeLong(userId);

		if (userStudentNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userStudentNumber);
		}

		if (authRole == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(authRole);
		}

		if (userUseYn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userUseYn);
		}

		if (requestSort == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(requestSort);
		}

		if (processNote == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(processNote);
		}

		objectOutput.writeLong(processDate);
		objectOutput.writeLong(createDt);
		objectOutput.writeLong(updateDt);
	}

	public long virtualLabUserId;
	public long userId;
	public String userStudentNumber;
	public String authRole;
	public String userUseYn;
	public String requestSort;
	public String processNote;
	public long processDate;
	public long createDt;
	public long updateDt;
}