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

import com.kisti.science.platform.app.model.CommonLibrary;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CommonLibrary in entity cache.
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonLibrary
 * @generated
 */
public class CommonLibraryCacheModel implements CacheModel<CommonLibrary>,
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
		sb.append(", libName=");
		sb.append(libName);
		sb.append(", cLibVer=");
		sb.append(cLibVer);
		sb.append(", sysArch=");
		sb.append(sysArch);
		sb.append(", kernelVer=");
		sb.append(kernelVer);
		sb.append(", libPath=");
		sb.append(libPath);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CommonLibrary toEntityModel() {
		CommonLibraryImpl commonLibraryImpl = new CommonLibraryImpl();

		commonLibraryImpl.setGroupId(groupId);
		commonLibraryImpl.setCompanyId(companyId);
		commonLibraryImpl.setUserId(userId);

		if (userName == null) {
			commonLibraryImpl.setUserName(StringPool.BLANK);
		}
		else {
			commonLibraryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			commonLibraryImpl.setCreateDate(null);
		}
		else {
			commonLibraryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			commonLibraryImpl.setModifiedDate(null);
		}
		else {
			commonLibraryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (libName == null) {
			commonLibraryImpl.setLibName(StringPool.BLANK);
		}
		else {
			commonLibraryImpl.setLibName(libName);
		}

		if (cLibVer == null) {
			commonLibraryImpl.setCLibVer(StringPool.BLANK);
		}
		else {
			commonLibraryImpl.setCLibVer(cLibVer);
		}

		if (sysArch == null) {
			commonLibraryImpl.setSysArch(StringPool.BLANK);
		}
		else {
			commonLibraryImpl.setSysArch(sysArch);
		}

		if (kernelVer == null) {
			commonLibraryImpl.setKernelVer(StringPool.BLANK);
		}
		else {
			commonLibraryImpl.setKernelVer(kernelVer);
		}

		if (libPath == null) {
			commonLibraryImpl.setLibPath(StringPool.BLANK);
		}
		else {
			commonLibraryImpl.setLibPath(libPath);
		}

		commonLibraryImpl.resetOriginalValues();

		return commonLibraryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		libName = objectInput.readUTF();
		cLibVer = objectInput.readUTF();
		sysArch = objectInput.readUTF();
		kernelVer = objectInput.readUTF();
		libPath = objectInput.readUTF();
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

		if (libName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libName);
		}

		if (cLibVer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cLibVer);
		}

		if (sysArch == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sysArch);
		}

		if (kernelVer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(kernelVer);
		}

		if (libPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libPath);
		}
	}

	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String libName;
	public String cLibVer;
	public String sysArch;
	public String kernelVer;
	public String libPath;
}