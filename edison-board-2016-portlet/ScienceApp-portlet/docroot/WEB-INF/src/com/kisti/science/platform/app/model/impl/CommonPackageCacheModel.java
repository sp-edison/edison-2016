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

import com.kisti.science.platform.app.model.CommonPackage;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CommonPackage in entity cache.
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonPackage
 * @generated
 */
public class CommonPackageCacheModel implements CacheModel<CommonPackage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

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
		sb.append(", pkgName=");
		sb.append(pkgName);
		sb.append(", pkgVersion=");
		sb.append(pkgVersion);
		sb.append(", sysArch=");
		sb.append(sysArch);
		sb.append(", installMethod=");
		sb.append(installMethod);
		sb.append(", installPath=");
		sb.append(installPath);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CommonPackage toEntityModel() {
		CommonPackageImpl commonPackageImpl = new CommonPackageImpl();

		commonPackageImpl.setGroupId(groupId);
		commonPackageImpl.setCompanyId(companyId);
		commonPackageImpl.setUserId(userId);

		if (userName == null) {
			commonPackageImpl.setUserName(StringPool.BLANK);
		}
		else {
			commonPackageImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			commonPackageImpl.setCreateDate(null);
		}
		else {
			commonPackageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			commonPackageImpl.setModifiedDate(null);
		}
		else {
			commonPackageImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (pkgName == null) {
			commonPackageImpl.setPkgName(StringPool.BLANK);
		}
		else {
			commonPackageImpl.setPkgName(pkgName);
		}

		if (pkgVersion == null) {
			commonPackageImpl.setPkgVersion(StringPool.BLANK);
		}
		else {
			commonPackageImpl.setPkgVersion(pkgVersion);
		}

		if (sysArch == null) {
			commonPackageImpl.setSysArch(StringPool.BLANK);
		}
		else {
			commonPackageImpl.setSysArch(sysArch);
		}

		if (installMethod == null) {
			commonPackageImpl.setInstallMethod(StringPool.BLANK);
		}
		else {
			commonPackageImpl.setInstallMethod(installMethod);
		}

		if (installPath == null) {
			commonPackageImpl.setInstallPath(StringPool.BLANK);
		}
		else {
			commonPackageImpl.setInstallPath(installPath);
		}

		commonPackageImpl.resetOriginalValues();

		return commonPackageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		pkgName = objectInput.readUTF();
		pkgVersion = objectInput.readUTF();
		sysArch = objectInput.readUTF();
		installMethod = objectInput.readUTF();
		installPath = objectInput.readUTF();
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

		if (pkgName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pkgName);
		}

		if (pkgVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pkgVersion);
		}

		if (sysArch == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sysArch);
		}

		if (installMethod == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(installMethod);
		}

		if (installPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(installPath);
		}
	}

	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String pkgName;
	public String pkgVersion;
	public String sysArch;
	public String installMethod;
	public String installPath;
}