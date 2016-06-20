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

import org.kisti.edison.virtuallaboratory.model.VirtualLab;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VirtualLab in entity cache.
 *
 * @author EDISON
 * @see VirtualLab
 * @generated
 */
public class VirtualLabCacheModel implements CacheModel<VirtualLab>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{virtualLabId=");
		sb.append(virtualLabId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", virtualLabPersonName=");
		sb.append(virtualLabPersonName);
		sb.append(", virtualLabRequestDt=");
		sb.append(virtualLabRequestDt);
		sb.append(", virtualLabConfirmDt=");
		sb.append(virtualLabConfirmDt);
		sb.append(", virtualLabConfirmDescription=");
		sb.append(virtualLabConfirmDescription);
		sb.append(", virtualLabStatus=");
		sb.append(virtualLabStatus);
		sb.append(", virtualLabTitle=");
		sb.append(virtualLabTitle);
		sb.append(", virtualLabDescription=");
		sb.append(virtualLabDescription);
		sb.append(", virtualLabUseYn=");
		sb.append(virtualLabUseYn);
		sb.append(", virtualLabUniversityField=");
		sb.append(virtualLabUniversityField);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VirtualLab toEntityModel() {
		VirtualLabImpl virtualLabImpl = new VirtualLabImpl();

		virtualLabImpl.setVirtualLabId(virtualLabId);
		virtualLabImpl.setGroupId(groupId);
		virtualLabImpl.setUserId(userId);

		if (virtualLabPersonName == null) {
			virtualLabImpl.setVirtualLabPersonName(StringPool.BLANK);
		}
		else {
			virtualLabImpl.setVirtualLabPersonName(virtualLabPersonName);
		}

		if (virtualLabRequestDt == Long.MIN_VALUE) {
			virtualLabImpl.setVirtualLabRequestDt(null);
		}
		else {
			virtualLabImpl.setVirtualLabRequestDt(new Date(virtualLabRequestDt));
		}

		if (virtualLabConfirmDt == Long.MIN_VALUE) {
			virtualLabImpl.setVirtualLabConfirmDt(null);
		}
		else {
			virtualLabImpl.setVirtualLabConfirmDt(new Date(virtualLabConfirmDt));
		}

		if (virtualLabConfirmDescription == null) {
			virtualLabImpl.setVirtualLabConfirmDescription(StringPool.BLANK);
		}
		else {
			virtualLabImpl.setVirtualLabConfirmDescription(virtualLabConfirmDescription);
		}

		if (virtualLabStatus == null) {
			virtualLabImpl.setVirtualLabStatus(StringPool.BLANK);
		}
		else {
			virtualLabImpl.setVirtualLabStatus(virtualLabStatus);
		}

		if (virtualLabTitle == null) {
			virtualLabImpl.setVirtualLabTitle(StringPool.BLANK);
		}
		else {
			virtualLabImpl.setVirtualLabTitle(virtualLabTitle);
		}

		if (virtualLabDescription == null) {
			virtualLabImpl.setVirtualLabDescription(StringPool.BLANK);
		}
		else {
			virtualLabImpl.setVirtualLabDescription(virtualLabDescription);
		}

		if (virtualLabUseYn == null) {
			virtualLabImpl.setVirtualLabUseYn(StringPool.BLANK);
		}
		else {
			virtualLabImpl.setVirtualLabUseYn(virtualLabUseYn);
		}

		if (virtualLabUniversityField == null) {
			virtualLabImpl.setVirtualLabUniversityField(StringPool.BLANK);
		}
		else {
			virtualLabImpl.setVirtualLabUniversityField(virtualLabUniversityField);
		}

		virtualLabImpl.resetOriginalValues();

		return virtualLabImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		virtualLabId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		virtualLabPersonName = objectInput.readUTF();
		virtualLabRequestDt = objectInput.readLong();
		virtualLabConfirmDt = objectInput.readLong();
		virtualLabConfirmDescription = objectInput.readUTF();
		virtualLabStatus = objectInput.readUTF();
		virtualLabTitle = objectInput.readUTF();
		virtualLabDescription = objectInput.readUTF();
		virtualLabUseYn = objectInput.readUTF();
		virtualLabUniversityField = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(virtualLabId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (virtualLabPersonName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(virtualLabPersonName);
		}

		objectOutput.writeLong(virtualLabRequestDt);
		objectOutput.writeLong(virtualLabConfirmDt);

		if (virtualLabConfirmDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(virtualLabConfirmDescription);
		}

		if (virtualLabStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(virtualLabStatus);
		}

		if (virtualLabTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(virtualLabTitle);
		}

		if (virtualLabDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(virtualLabDescription);
		}

		if (virtualLabUseYn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(virtualLabUseYn);
		}

		if (virtualLabUniversityField == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(virtualLabUniversityField);
		}
	}

	public long virtualLabId;
	public long groupId;
	public long userId;
	public String virtualLabPersonName;
	public long virtualLabRequestDt;
	public long virtualLabConfirmDt;
	public String virtualLabConfirmDescription;
	public String virtualLabStatus;
	public String virtualLabTitle;
	public String virtualLabDescription;
	public String virtualLabUseYn;
	public String virtualLabUniversityField;
}