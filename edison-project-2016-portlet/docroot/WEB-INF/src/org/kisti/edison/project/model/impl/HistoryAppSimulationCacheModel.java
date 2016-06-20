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

import org.kisti.edison.project.model.HistoryAppSimulation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HistoryAppSimulation in entity cache.
 *
 * @author EDISON
 * @see HistoryAppSimulation
 * @generated
 */
public class HistoryAppSimulationCacheModel implements CacheModel<HistoryAppSimulation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

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
		sb.append(", runtime=");
		sb.append(runtime);
		sb.append(", executeCount=");
		sb.append(executeCount);
		sb.append(", averageRuntime=");
		sb.append(averageRuntime);
		sb.append(", userCount=");
		sb.append(userCount);
		sb.append(", insertDate=");
		sb.append(insertDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HistoryAppSimulation toEntityModel() {
		HistoryAppSimulationImpl historyAppSimulationImpl = new HistoryAppSimulationImpl();

		historyAppSimulationImpl.setScienceAppId(scienceAppId);
		historyAppSimulationImpl.setGroupId(groupId);
		historyAppSimulationImpl.setProjectCategoryId(projectCategoryId);

		if (title == null) {
			historyAppSimulationImpl.setTitle(StringPool.BLANK);
		}
		else {
			historyAppSimulationImpl.setTitle(title);
		}

		if (version == null) {
			historyAppSimulationImpl.setVersion(StringPool.BLANK);
		}
		else {
			historyAppSimulationImpl.setVersion(version);
		}

		if (name == null) {
			historyAppSimulationImpl.setName(StringPool.BLANK);
		}
		else {
			historyAppSimulationImpl.setName(name);
		}

		if (affiliation_id == null) {
			historyAppSimulationImpl.setAffiliation_id(StringPool.BLANK);
		}
		else {
			historyAppSimulationImpl.setAffiliation_id(affiliation_id);
		}

		if (AppStatus == null) {
			historyAppSimulationImpl.setAppStatus(StringPool.BLANK);
		}
		else {
			historyAppSimulationImpl.setAppStatus(AppStatus);
		}

		historyAppSimulationImpl.setUserId(userId);
		historyAppSimulationImpl.setRuntime(runtime);
		historyAppSimulationImpl.setExecuteCount(executeCount);
		historyAppSimulationImpl.setAverageRuntime(averageRuntime);
		historyAppSimulationImpl.setUserCount(userCount);

		if (insertDate == Long.MIN_VALUE) {
			historyAppSimulationImpl.setInsertDate(null);
		}
		else {
			historyAppSimulationImpl.setInsertDate(new Date(insertDate));
		}

		historyAppSimulationImpl.resetOriginalValues();

		return historyAppSimulationImpl;
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
		runtime = objectInput.readLong();
		executeCount = objectInput.readLong();
		averageRuntime = objectInput.readLong();
		userCount = objectInput.readLong();
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
		objectOutput.writeLong(runtime);
		objectOutput.writeLong(executeCount);
		objectOutput.writeLong(averageRuntime);
		objectOutput.writeLong(userCount);
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
	public long runtime;
	public long executeCount;
	public long averageRuntime;
	public long userCount;
	public long insertDate;
}