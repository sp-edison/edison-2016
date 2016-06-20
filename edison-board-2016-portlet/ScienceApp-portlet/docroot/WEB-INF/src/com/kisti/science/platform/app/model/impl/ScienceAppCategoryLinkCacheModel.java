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

import com.kisti.science.platform.app.model.ScienceAppCategoryLink;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ScienceAppCategoryLink in entity cache.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppCategoryLink
 * @generated
 */
public class ScienceAppCategoryLinkCacheModel implements CacheModel<ScienceAppCategoryLink>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", scienceAppCategoryLinkId=");
		sb.append(scienceAppCategoryLinkId);
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
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", scienceAppId=");
		sb.append(scienceAppId);
		sb.append(", parentCategoryId=");
		sb.append(parentCategoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ScienceAppCategoryLink toEntityModel() {
		ScienceAppCategoryLinkImpl scienceAppCategoryLinkImpl = new ScienceAppCategoryLinkImpl();

		if (uuid == null) {
			scienceAppCategoryLinkImpl.setUuid(StringPool.BLANK);
		}
		else {
			scienceAppCategoryLinkImpl.setUuid(uuid);
		}

		scienceAppCategoryLinkImpl.setScienceAppCategoryLinkId(scienceAppCategoryLinkId);
		scienceAppCategoryLinkImpl.setGroupId(groupId);
		scienceAppCategoryLinkImpl.setCompanyId(companyId);
		scienceAppCategoryLinkImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			scienceAppCategoryLinkImpl.setCreateDate(null);
		}
		else {
			scienceAppCategoryLinkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			scienceAppCategoryLinkImpl.setModifiedDate(null);
		}
		else {
			scienceAppCategoryLinkImpl.setModifiedDate(new Date(modifiedDate));
		}

		scienceAppCategoryLinkImpl.setCategoryId(categoryId);
		scienceAppCategoryLinkImpl.setScienceAppId(scienceAppId);
		scienceAppCategoryLinkImpl.setParentCategoryId(parentCategoryId);

		scienceAppCategoryLinkImpl.resetOriginalValues();

		return scienceAppCategoryLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		scienceAppCategoryLinkId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		categoryId = objectInput.readLong();
		scienceAppId = objectInput.readLong();
		parentCategoryId = objectInput.readLong();
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

		objectOutput.writeLong(scienceAppCategoryLinkId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(categoryId);
		objectOutput.writeLong(scienceAppId);
		objectOutput.writeLong(parentCategoryId);
	}

	public String uuid;
	public long scienceAppCategoryLinkId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long categoryId;
	public long scienceAppId;
	public long parentCategoryId;
}