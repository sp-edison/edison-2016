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

import org.kisti.edison.science.model.RequiredModule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RequiredModule in entity cache.
 *
 * @author EDISON
 * @see RequiredModule
 * @generated
 */
public class RequiredModuleCacheModel implements CacheModel<RequiredModule>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{requiredModuleId=");
		sb.append(requiredModuleId);
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
	public RequiredModule toEntityModel() {
		RequiredModuleImpl requiredModuleImpl = new RequiredModuleImpl();

		requiredModuleImpl.setRequiredModuleId(requiredModuleId);
		requiredModuleImpl.setGroupId(groupId);
		requiredModuleImpl.setCompanyId(companyId);
		requiredModuleImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			requiredModuleImpl.setCreateDate(null);
		}
		else {
			requiredModuleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			requiredModuleImpl.setModifiedDate(null);
		}
		else {
			requiredModuleImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (moduleName == null) {
			requiredModuleImpl.setModuleName(StringPool.BLANK);
		}
		else {
			requiredModuleImpl.setModuleName(moduleName);
		}

		if (moduleVersion == null) {
			requiredModuleImpl.setModuleVersion(StringPool.BLANK);
		}
		else {
			requiredModuleImpl.setModuleVersion(moduleVersion);
		}

		requiredModuleImpl.resetOriginalValues();

		return requiredModuleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		requiredModuleId = objectInput.readLong();
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
		objectOutput.writeLong(requiredModuleId);
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

	public long requiredModuleId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String moduleName;
	public String moduleVersion;
}