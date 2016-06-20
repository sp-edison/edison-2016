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

package org.kisti.edison.content.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.content.model.GeneralContent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GeneralContent in entity cache.
 *
 * @author EDISON
 * @see GeneralContent
 * @generated
 */
public class GeneralContentCacheModel implements CacheModel<GeneralContent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{contentSeq=");
		sb.append(contentSeq);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", contentDiv=");
		sb.append(contentDiv);
		sb.append(", title=");
		sb.append(title);
		sb.append(", downloadCnt=");
		sb.append(downloadCnt);
		sb.append(", serviceLanguage=");
		sb.append(serviceLanguage);
		sb.append(", projectYn=");
		sb.append(projectYn);
		sb.append(", projectId=");
		sb.append(projectId);
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
	public GeneralContent toEntityModel() {
		GeneralContentImpl generalContentImpl = new GeneralContentImpl();

		generalContentImpl.setContentSeq(contentSeq);
		generalContentImpl.setGroupId(groupId);
		generalContentImpl.setContentDiv(contentDiv);

		if (title == null) {
			generalContentImpl.setTitle(StringPool.BLANK);
		}
		else {
			generalContentImpl.setTitle(title);
		}

		generalContentImpl.setDownloadCnt(downloadCnt);

		if (serviceLanguage == null) {
			generalContentImpl.setServiceLanguage(StringPool.BLANK);
		}
		else {
			generalContentImpl.setServiceLanguage(serviceLanguage);
		}

		if (projectYn == null) {
			generalContentImpl.setProjectYn(StringPool.BLANK);
		}
		else {
			generalContentImpl.setProjectYn(projectYn);
		}

		generalContentImpl.setProjectId(projectId);
		generalContentImpl.setInsertId(insertId);

		if (insertDate == Long.MIN_VALUE) {
			generalContentImpl.setInsertDate(null);
		}
		else {
			generalContentImpl.setInsertDate(new Date(insertDate));
		}

		generalContentImpl.setUpdateId(updateId);

		if (updateDate == Long.MIN_VALUE) {
			generalContentImpl.setUpdateDate(null);
		}
		else {
			generalContentImpl.setUpdateDate(new Date(updateDate));
		}

		generalContentImpl.resetOriginalValues();

		return generalContentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contentSeq = objectInput.readLong();
		groupId = objectInput.readLong();
		contentDiv = objectInput.readLong();
		title = objectInput.readUTF();
		downloadCnt = objectInput.readLong();
		serviceLanguage = objectInput.readUTF();
		projectYn = objectInput.readUTF();
		projectId = objectInput.readLong();
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
		objectOutput.writeLong(contentDiv);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(downloadCnt);

		if (serviceLanguage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceLanguage);
		}

		if (projectYn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectYn);
		}

		objectOutput.writeLong(projectId);
		objectOutput.writeLong(insertId);
		objectOutput.writeLong(insertDate);
		objectOutput.writeLong(updateId);
		objectOutput.writeLong(updateDate);
	}

	public long contentSeq;
	public long groupId;
	public long contentDiv;
	public String title;
	public long downloadCnt;
	public String serviceLanguage;
	public String projectYn;
	public long projectId;
	public long insertId;
	public long insertDate;
	public long updateId;
	public long updateDate;
}