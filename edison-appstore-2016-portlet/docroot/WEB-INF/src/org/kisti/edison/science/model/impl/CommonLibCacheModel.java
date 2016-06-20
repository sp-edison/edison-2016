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

import org.kisti.edison.science.model.CommonLib;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CommonLib in entity cache.
 *
 * @author EDISON
 * @see CommonLib
 * @generated
 */
public class CommonLibCacheModel implements CacheModel<CommonLib>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{libName=");
		sb.append(libName);
		sb.append(", libPath=");
		sb.append(libPath);
		sb.append(", libraryVersion=");
		sb.append(libraryVersion);
		sb.append(", cLibVer=");
		sb.append(cLibVer);
		sb.append(", sysArch=");
		sb.append(sysArch);
		sb.append(", kernelVer=");
		sb.append(kernelVer);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CommonLib toEntityModel() {
		CommonLibImpl commonLibImpl = new CommonLibImpl();

		if (libName == null) {
			commonLibImpl.setLibName(StringPool.BLANK);
		}
		else {
			commonLibImpl.setLibName(libName);
		}

		if (libPath == null) {
			commonLibImpl.setLibPath(StringPool.BLANK);
		}
		else {
			commonLibImpl.setLibPath(libPath);
		}

		if (libraryVersion == null) {
			commonLibImpl.setLibraryVersion(StringPool.BLANK);
		}
		else {
			commonLibImpl.setLibraryVersion(libraryVersion);
		}

		if (cLibVer == null) {
			commonLibImpl.setCLibVer(StringPool.BLANK);
		}
		else {
			commonLibImpl.setCLibVer(cLibVer);
		}

		if (sysArch == null) {
			commonLibImpl.setSysArch(StringPool.BLANK);
		}
		else {
			commonLibImpl.setSysArch(sysArch);
		}

		if (kernelVer == null) {
			commonLibImpl.setKernelVer(StringPool.BLANK);
		}
		else {
			commonLibImpl.setKernelVer(kernelVer);
		}

		commonLibImpl.resetOriginalValues();

		return commonLibImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		libName = objectInput.readUTF();
		libPath = objectInput.readUTF();
		libraryVersion = objectInput.readUTF();
		cLibVer = objectInput.readUTF();
		sysArch = objectInput.readUTF();
		kernelVer = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (libName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libName);
		}

		if (libPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libPath);
		}

		if (libraryVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(libraryVersion);
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
	}

	public String libName;
	public String libPath;
	public String libraryVersion;
	public String cLibVer;
	public String sysArch;
	public String kernelVer;
}