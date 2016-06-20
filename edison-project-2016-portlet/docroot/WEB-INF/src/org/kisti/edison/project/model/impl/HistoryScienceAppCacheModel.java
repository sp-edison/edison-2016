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

package org.kisti.edison.project.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.project.model.HistoryScienceApp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HistoryScienceApp in entity cache.
 *
 * @author EDISON
 * @see HistoryScienceApp
 * @generated
 */
public class HistoryScienceAppCacheModel implements CacheModel<HistoryScienceApp>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{scienceAppId=");
		sb.append(scienceAppId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", projectCategoryId=");
		sb.append(projectCategoryId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", version=");
		sb.append(version);
		sb.append(", name=");
		sb.append(name);
		sb.append(", affiliation_id=");
		sb.append(affiliation_id);
		sb.append(", AppStatus=");
		sb.append(AppStatus);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", insertDate=");
		sb.append(insertDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HistoryScienceApp toEntityModel() {
		HistoryScienceAppImpl historyScienceAppImpl = new HistoryScienceAppImpl();

		historyScienceAppImpl.setScienceAppId(scienceAppId);
		historyScienceAppImpl.setGroupId(groupId);
		historyScienceAppImpl.setProjectCategoryId(projectCategoryId);

		if (title == null) {
			historyScienceAppImpl.setTitle(StringPool.BLANK);
		}
		else {
			historyScienceAppImpl.setTitle(title);
		}

		if (version == null) {
			historyScienceAppImpl.setVersion(StringPool.BLANK);
		}
		else {
			historyScienceAppImpl.setVersion(version);
		}

		if (name == null) {
			historyScienceAppImpl.setName(StringPool.BLANK);
		}
		else {
			historyScienceAppImpl.setName(name);
		}

		if (affiliation_id == null) {
			historyScienceAppImpl.setAffiliation_id(StringPool.BLANK);
		}
		else {
			historyScienceAppImpl.setAffiliation_id(affiliation_id);
		}

		if (AppStatus == null) {
			historyScienceAppImpl.setAppStatus(StringPool.BLANK);
		}
		else {
			historyScienceAppImpl.setAppStatus(AppStatus);
		}

		historyScienceAppImpl.setUserId(userId);

		if (insertDate == Long.MIN_VALUE) {
			historyScienceAppImpl.setInsertDate(null);
		}
		else {
			historyScienceAppImpl.setInsertDate(new Date(insertDate));
		}

		historyScienceAppImpl.resetOriginalValues();

		return historyScienceAppImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		scienceAppId = objectInput.readLong();
		groupId = objectInput.readLong();
		projectCategoryId = objectInput.readLong();
		title = objectInput.readUTF();
		version = objectInput.readUTF();
		name = objectInput.readUTF();
		affiliation_id = objectInput.readUTF();
		AppStatus = objectInput.readUTF();
		userId = objectInput.readLong();
		insertDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(scienceAppId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(projectCategoryId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (version == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(version);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (affiliation_id == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(affiliation_id);
		}

		if (AppStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(AppStatus);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(insertDate);
	}

	public long scienceAppId;
	public long groupId;
	public long projectCategoryId;
	public String title;
	public String version;
	public String name;
	public String affiliation_id;
	public String AppStatus;
	public long userId;
	public long insertDate;
}