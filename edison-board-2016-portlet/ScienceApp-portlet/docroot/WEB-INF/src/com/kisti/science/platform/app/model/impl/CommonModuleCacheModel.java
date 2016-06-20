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

import com.kisti.science.platform.app.model.CommonModule;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CommonModule in entity cache.
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonModule
 * @generated
 */
public class CommonModuleCacheModel implements CacheModel<CommonModule>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", moduleName=");
		sb.append(moduleName);
		sb.append(", moduleRootDir=");
		sb.append(moduleRootDir);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CommonModule toEntityModel() {
		CommonModuleImpl commonModuleImpl = new CommonModuleImpl();

		commonModuleImpl.setGroupId(groupId);
		commonModuleImpl.setCompanyId(companyId);
		commonModuleImpl.setUserId(userId);

		if (userName == null) {
			commonModuleImpl.setUserName(StringPool.BLANK);
		}
		else {
			commonModuleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			commonModuleImpl.setCreateDate(null);
		}
		else {
			commonModuleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			commonModuleImpl.setModifiedDate(null);
		}
		else {
			commonModuleImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (moduleName == null) {
			commonModuleImpl.setModuleName(StringPool.BLANK);
		}
		else {
			commonModuleImpl.setModuleName(moduleName);
		}

		if (moduleRootDir == null) {
			commonModuleImpl.setModuleRootDir(StringPool.BLANK);
		}
		else {
			commonModuleImpl.setModuleRootDir(moduleRootDir);
		}

		commonModuleImpl.resetOriginalValues();

		return commonModuleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		moduleName = objectInput.readUTF();
		moduleRootDir = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (moduleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moduleName);
		}

		if (moduleRootDir == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moduleRootDir);
		}
	}

	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String moduleName;
	public String moduleRootDir;
}