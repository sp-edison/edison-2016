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

package com.kisti.science.platform.app.model.impl;

import com.kisti.science.platform.app.model.PortType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PortType in entity cache.
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortType
 * @generated
 */
public class PortTypeCacheModel implements CacheModel<PortType>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", portTypeId=");
		sb.append(portTypeId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", defaultEditorId=");
		sb.append(defaultEditorId);
		sb.append(", defaultAnalyzerId=");
		sb.append(defaultAnalyzerId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", dataType=");
		sb.append(dataType);
		sb.append(", sampleFilePath=");
		sb.append(sampleFilePath);
		sb.append(", targetLanguage=");
		sb.append(targetLanguage);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PortType toEntityModel() {
		PortTypeImpl portTypeImpl = new PortTypeImpl();

		if (uuid == null) {
			portTypeImpl.setUuid(StringPool.BLANK);
		}
		else {
			portTypeImpl.setUuid(uuid);
		}

		portTypeImpl.setPortTypeId(portTypeId);
		portTypeImpl.setCompanyId(companyId);
		portTypeImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			portTypeImpl.setCreateDate(null);
		}
		else {
			portTypeImpl.setCreateDate(new Date(createDate));
		}

		portTypeImpl.setDefaultEditorId(defaultEditorId);
		portTypeImpl.setDefaultAnalyzerId(defaultAnalyzerId);

		if (name == null) {
			portTypeImpl.setName(StringPool.BLANK);
		}
		else {
			portTypeImpl.setName(name);
		}

		if (dataType == null) {
			portTypeImpl.setDataType(StringPool.BLANK);
		}
		else {
			portTypeImpl.setDataType(dataType);
		}

		if (sampleFilePath == null) {
			portTypeImpl.setSampleFilePath(StringPool.BLANK);
		}
		else {
			portTypeImpl.setSampleFilePath(sampleFilePath);
		}

		if (targetLanguage == null) {
			portTypeImpl.setTargetLanguage(StringPool.BLANK);
		}
		else {
			portTypeImpl.setTargetLanguage(targetLanguage);
		}

		if (status == null) {
			portTypeImpl.setStatus(StringPool.BLANK);
		}
		else {
			portTypeImpl.setStatus(status);
		}

		portTypeImpl.resetOriginalValues();

		return portTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		portTypeId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		defaultEditorId = objectInput.readLong();
		defaultAnalyzerId = objectInput.readLong();
		name = objectInput.readUTF();
		dataType = objectInput.readUTF();
		sampleFilePath = objectInput.readUTF();
		targetLanguage = objectInput.readUTF();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(portTypeId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(defaultEditorId);
		objectOutput.writeLong(defaultAnalyzerId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (dataType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dataType);
		}

		if (sampleFilePath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sampleFilePath);
		}

		if (targetLanguage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(targetLanguage);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public String uuid;
	public long portTypeId;
	public long companyId;
	public long userId;
	public long createDate;
	public long defaultEditorId;
	public long defaultAnalyzerId;
	public String name;
	public String dataType;
	public String sampleFilePath;
	public String targetLanguage;
	public String status;
}