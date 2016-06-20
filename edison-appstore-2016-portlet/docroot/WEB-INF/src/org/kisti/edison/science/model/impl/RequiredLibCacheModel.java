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

import org.kisti.edison.science.model.RequiredLib;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RequiredLib in entity cache.
 *
 * @author EDISON
 * @see RequiredLib
 * @generated
 */
public class RequiredLibCacheModel implements CacheModel<RequiredLib>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{requiredLibId=");
		sb.append(requiredLibId);
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
		sb.append(", libraryName=");
		sb.append(libraryName);
		sb.append(", libraryVersion=");
		sb.append(libraryVersion);
		sb.append(", libraryType=");
		sb.append(libraryType);
		sb.append(", librarySrcPath=");
		sb.append(librarySrcPath);
		sb.append(", installScript=");
		sb.append(installScript);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RequiredLib toEntityModel() {
		RequiredLibImpl requiredLibImpl = new RequiredLibImpl();

		requiredLibImpl.setRequiredLibId(requiredLibId);
		requiredLibImpl.setGroupId(groupId);
		requiredLibImpl.setCompanyId(companyId);
		requiredLibImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			requiredLibImpl.setCreateDate(null);
		}
		else {
			requiredLibImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			requiredLibImpl.setModifiedDate(null);
		}
		else {
			requiredLibImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (libraryName == null) {
			requiredLibImpl.setLibraryName(StringPool.BLANK);
		}
		else {
			requiredLibImpl.setLibraryName(libraryName);
		}

		if (libraryVersion == null) {
			requiredLibImpl.setLibraryVersion(StringPool.BLANK);
		}
		else {
			requiredLibImpl.setLibraryVersion(libraryVersion);
		}

		if (libraryType == null) {
			requiredLibImpl.setLibraryType(StringPool.BLANK);
		}
		else {
			requiredLibImpl.setLibraryType(libraryType);
		}

		if (librarySrcPath == null) {
			requiredLibImpl.setLibrarySrcPath(StringPool.BLANK);
		}
		else {
			requiredLibImpl.setLibrarySrcPath(librarySrcPath);
		}

		if (installScript == null) {
			requiredLibImpl.setInstallScript(StringPool.BLANK);
		}
		else {
			requiredLibImpl.setInstallScript(installScript);
		}

		requiredLibImpl.resetOriginalValues();

		return requiredLibImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		requiredLibId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		libraryName = objectInput.readUTF();
		libraryVersion = objectInput.readUTF();
		libraryType = objectInput.readUTF();
		librarySrcPath = objectInput.readUTF();
		installScript = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(requiredLibId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (libraryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libraryName);
		}

		if (libraryVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libraryVersion);
		}

		if (libraryType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libraryType);
		}

		if (librarySrcPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(librarySrcPath);
		}

		if (installScript == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(installScript);
		}
	}

	public long requiredLibId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String libraryName;
	public String libraryVersion;
	public String libraryType;
	public String librarySrcPath;
	public String installScript;
}