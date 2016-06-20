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

import org.kisti.edison.project.model.HistoryContent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HistoryContent in entity cache.
 *
 * @author EDISON
 * @see HistoryContent
 * @generated
 */
public class HistoryContentCacheModel implements CacheModel<HistoryContent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{contentSeq=");
		sb.append(contentSeq);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", projectCategoryId=");
		sb.append(projectCategoryId);
		sb.append(", contentDiv=");
		sb.append(contentDiv);
		sb.append(", title=");
		sb.append(title);
		sb.append(", insertId=");
		sb.append(insertId);
		sb.append(", insertDate=");
		sb.append(insertDate);
		sb.append(", updateId=");
		sb.append(updateId);
		sb.append(", updateDate=");
		sb.append(updateDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HistoryContent toEntityModel() {
		HistoryContentImpl historyContentImpl = new HistoryContentImpl();

		historyContentImpl.setContentSeq(contentSeq);
		historyContentImpl.setGroupId(groupId);
		historyContentImpl.setProjectCategoryId(projectCategoryId);
		historyContentImpl.setContentDiv(contentDiv);

		if (title == null) {
			historyContentImpl.setTitle(StringPool.BLANK);
		}
		else {
			historyContentImpl.setTitle(title);
		}

		historyContentImpl.setInsertId(insertId);

		if (insertDate == Long.MIN_VALUE) {
			historyContentImpl.setInsertDate(null);
		}
		else {
			historyContentImpl.setInsertDate(new Date(insertDate));
		}

		historyContentImpl.setUpdateId(updateId);

		if (updateDate == Long.MIN_VALUE) {
			historyContentImpl.setUpdateDate(null);
		}
		else {
			historyContentImpl.setUpdateDate(new Date(updateDate));
		}

		historyContentImpl.resetOriginalValues();

		return historyContentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contentSeq = objectInput.readLong();
		groupId = objectInput.readLong();
		projectCategoryId = objectInput.readLong();
		contentDiv = objectInput.readLong();
		title = objectInput.readUTF();
		insertId = objectInput.readLong();
		insertDate = objectInput.readLong();
		updateId = objectInput.readLong();
		updateDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(contentSeq);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(projectCategoryId);
		objectOutput.writeLong(contentDiv);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(insertId);
		objectOutput.writeLong(insertDate);
		objectOutput.writeLong(updateId);
		objectOutput.writeLong(updateDate);
	}

	public long contentSeq;
	public long groupId;
	public long projectCategoryId;
	public long contentDiv;
	public String title;
	public long insertId;
	public long insertDate;
	public long updateId;
	public long updateDate;
}