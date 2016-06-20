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

import org.kisti.edison.science.model.CommonModule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CommonModule in entity cache.
 *
 * @author EDISON
 * @see CommonModule
 * @generated
 */
public class CommonModuleCacheModel implements CacheModel<CommonModule>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{commonModuleId=");
		sb.append(commonModuleId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", moduleName=");
		sb.append(moduleName);
		sb.append(", moduleVersion=");
		sb.append(moduleVersion);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CommonModule toEntityModel() {
		CommonModuleImpl commonModuleImpl = new CommonModuleImpl();

		commonModuleImpl.setCommonModuleId(commonModuleId);
		commonModuleImpl.setGroupId(groupId);
		commonModuleImpl.setCompanyId(companyId);
		commonModuleImpl.setUserId(userId);

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

		if (moduleVersion == null) {
			commonModuleImpl.setModuleVersion(StringPool.BLANK);
		}
		else {
			commonModuleImpl.setModuleVersion(moduleVersion);
		}

		commonModuleImpl.resetOriginalValues();

		return commonModuleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		commonModuleId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		moduleName = objectInput.readUTF();
		moduleVersion = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(commonModuleId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (moduleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moduleName);
		}

		if (moduleVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moduleVersion);
		}
	}

	public long commonModuleId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String moduleName;
	public String moduleVersion;
}