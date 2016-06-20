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
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.science.model.ScienceAppFavorite;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ScienceAppFavorite in entity cache.
 *
 * @author EDISON
 * @see ScienceAppFavorite
 * @generated
 */
public class ScienceAppFavoriteCacheModel implements CacheModel<ScienceAppFavorite>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{scienceAppId=");
		sb.append(scienceAppId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ScienceAppFavorite toEntityModel() {
		ScienceAppFavoriteImpl scienceAppFavoriteImpl = new ScienceAppFavoriteImpl();

		scienceAppFavoriteImpl.setScienceAppId(scienceAppId);
		scienceAppFavoriteImpl.setUserId(userId);
		scienceAppFavoriteImpl.setGroupId(groupId);

		scienceAppFavoriteImpl.resetOriginalValues();

		return scienceAppFavoriteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		scienceAppId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(scienceAppId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(groupId);
	}

	public long scienceAppId;
	public long userId;
	public long groupId;
}