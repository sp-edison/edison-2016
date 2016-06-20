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

import com.kisti.science.platform.app.model.ScienceAppManager;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ScienceAppManager in entity cache.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppManager
 * @generated
 */
public class ScienceAppManagerCacheModel implements CacheModel<ScienceAppManager>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{scienceAppManagerId=");
		sb.append(scienceAppManagerId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", scienceAppId=");
		sb.append(scienceAppId);
		sb.append(", managerId=");
		sb.append(managerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ScienceAppManager toEntityModel() {
		ScienceAppManagerImpl scienceAppManagerImpl = new ScienceAppManagerImpl();

		scienceAppManagerImpl.setScienceAppManagerId(scienceAppManagerId);
		scienceAppManagerImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			scienceAppManagerImpl.setCreateDate(null);
		}
		else {
			scienceAppManagerImpl.setCreateDate(new Date(createDate));
		}

		scienceAppManagerImpl.setScienceAppId(scienceAppId);
		scienceAppManagerImpl.setManagerId(managerId);

		scienceAppManagerImpl.resetOriginalValues();

		return scienceAppManagerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		scienceAppManagerId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		scienceAppId = objectInput.readLong();
		managerId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(scienceAppManagerId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(scienceAppId);
		objectOutput.writeLong(managerId);
	}

	public long scienceAppManagerId;
	public long userId;
	public long createDate;
	public long scienceAppId;
	public long managerId;
}