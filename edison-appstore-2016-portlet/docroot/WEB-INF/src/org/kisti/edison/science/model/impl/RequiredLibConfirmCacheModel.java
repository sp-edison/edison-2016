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

import org.kisti.edison.science.model.RequiredLibConfirm;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RequiredLibConfirm in entity cache.
 *
 * @author EDISON
 * @see RequiredLibConfirm
 * @generated
 */
public class RequiredLibConfirmCacheModel implements CacheModel<RequiredLibConfirm>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{requiredLibId=");
		sb.append(requiredLibId);
		sb.append(", scienceAppId=");
		sb.append(scienceAppId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", requiredDate=");
		sb.append(requiredDate);
		sb.append(", confirmDate=");
		sb.append(confirmDate);
		sb.append(", libraryName=");
		sb.append(libraryName);
		sb.append(", libraryVersion=");
		sb.append(libraryVersion);
		sb.append(", requiredContent=");
		sb.append(requiredContent);
		sb.append(", requiredState=");
		sb.append(requiredState);
		sb.append(", confirmContent=");
		sb.append(confirmContent);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RequiredLibConfirm toEntityModel() {
		RequiredLibConfirmImpl requiredLibConfirmImpl = new RequiredLibConfirmImpl();

		requiredLibConfirmImpl.setRequiredLibId(requiredLibId);
		requiredLibConfirmImpl.setScienceAppId(scienceAppId);
		requiredLibConfirmImpl.setCompanyId(companyId);
		requiredLibConfirmImpl.setUserId(userId);

		if (requiredDate == Long.MIN_VALUE) {
			requiredLibConfirmImpl.setRequiredDate(null);
		}
		else {
			requiredLibConfirmImpl.setRequiredDate(new Date(requiredDate));
		}

		if (confirmDate == Long.MIN_VALUE) {
			requiredLibConfirmImpl.setConfirmDate(null);
		}
		else {
			requiredLibConfirmImpl.setConfirmDate(new Date(confirmDate));
		}

		if (libraryName == null) {
			requiredLibConfirmImpl.setLibraryName(StringPool.BLANK);
		}
		else {
			requiredLibConfirmImpl.setLibraryName(libraryName);
		}

		if (libraryVersion == null) {
			requiredLibConfirmImpl.setLibraryVersion(StringPool.BLANK);
		}
		else {
			requiredLibConfirmImpl.setLibraryVersion(libraryVersion);
		}

		if (requiredContent == null) {
			requiredLibConfirmImpl.setRequiredContent(StringPool.BLANK);
		}
		else {
			requiredLibConfirmImpl.setRequiredContent(requiredContent);
		}

		if (requiredState == null) {
			requiredLibConfirmImpl.setRequiredState(StringPool.BLANK);
		}
		else {
			requiredLibConfirmImpl.setRequiredState(requiredState);
		}

		if (confirmContent == null) {
			requiredLibConfirmImpl.setConfirmContent(StringPool.BLANK);
		}
		else {
			requiredLibConfirmImpl.setConfirmContent(confirmContent);
		}

		requiredLibConfirmImpl.resetOriginalValues();

		return requiredLibConfirmImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		requiredLibId = objectInput.readLong();
		scienceAppId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		requiredDate = objectInput.readLong();
		confirmDate = objectInput.readLong();
		libraryName = objectInput.readUTF();
		libraryVersion = objectInput.readUTF();
		requiredContent = objectInput.readUTF();
		requiredState = objectInput.readUTF();
		confirmContent = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(requiredLibId);
		objectOutput.writeLong(scienceAppId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(requiredDate);
		objectOutput.writeLong(confirmDate);

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

		if (requiredContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(requiredContent);
		}

		if (requiredState == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(requiredState);
		}

		if (confirmContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(confirmContent);
		}
	}

	public long requiredLibId;
	public long scienceAppId;
	public long companyId;
	public long userId;
	public long requiredDate;
	public long confirmDate;
	public String libraryName;
	public String libraryVersion;
	public String requiredContent;
	public String requiredState;
	public String confirmContent;
}