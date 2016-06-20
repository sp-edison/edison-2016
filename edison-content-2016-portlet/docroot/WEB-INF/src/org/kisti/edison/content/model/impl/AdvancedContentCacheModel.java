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

import org.kisti.edison.content.model.AdvancedContent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AdvancedContent in entity cache.
 *
 * @author EDISON
 * @see AdvancedContent
 * @generated
 */
public class AdvancedContentCacheModel implements CacheModel<AdvancedContent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{contentSeq=");
		sb.append(contentSeq);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", resume=");
		sb.append(resume);
		sb.append(", contentFilePath=");
		sb.append(contentFilePath);
		sb.append(", contentFileNm=");
		sb.append(contentFileNm);
		sb.append(", contentStartFileNm=");
		sb.append(contentStartFileNm);
		sb.append(", serviceLanguage=");
		sb.append(serviceLanguage);
		sb.append(", viewCnt=");
		sb.append(viewCnt);
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
	public AdvancedContent toEntityModel() {
		AdvancedContentImpl advancedContentImpl = new AdvancedContentImpl();

		advancedContentImpl.setContentSeq(contentSeq);
		advancedContentImpl.setGroupId(groupId);

		if (title == null) {
			advancedContentImpl.setTitle(StringPool.BLANK);
		}
		else {
			advancedContentImpl.setTitle(title);
		}

		if (resume == null) {
			advancedContentImpl.setResume(StringPool.BLANK);
		}
		else {
			advancedContentImpl.setResume(resume);
		}

		if (contentFilePath == null) {
			advancedContentImpl.setContentFilePath(StringPool.BLANK);
		}
		else {
			advancedContentImpl.setContentFilePath(contentFilePath);
		}

		if (contentFileNm == null) {
			advancedContentImpl.setContentFileNm(StringPool.BLANK);
		}
		else {
			advancedContentImpl.setContentFileNm(contentFileNm);
		}

		if (contentStartFileNm == null) {
			advancedContentImpl.setContentStartFileNm(StringPool.BLANK);
		}
		else {
			advancedContentImpl.setContentStartFileNm(contentStartFileNm);
		}

		if (serviceLanguage == null) {
			advancedContentImpl.setServiceLanguage(StringPool.BLANK);
		}
		else {
			advancedContentImpl.setServiceLanguage(serviceLanguage);
		}

		advancedContentImpl.setViewCnt(viewCnt);
		advancedContentImpl.setInsertId(insertId);

		if (insertDate == Long.MIN_VALUE) {
			advancedContentImpl.setInsertDate(null);
		}
		else {
			advancedContentImpl.setInsertDate(new Date(insertDate));
		}

		advancedContentImpl.setUpdateId(updateId);

		if (updateDate == Long.MIN_VALUE) {
			advancedContentImpl.setUpdateDate(null);
		}
		else {
			advancedContentImpl.setUpdateDate(new Date(updateDate));
		}

		advancedContentImpl.resetOriginalValues();

		return advancedContentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contentSeq = objectInput.readLong();
		groupId = objectInput.readLong();
		title = objectInput.readUTF();
		resume = objectInput.readUTF();
		contentFilePath = objectInput.readUTF();
		contentFileNm = objectInput.readUTF();
		contentStartFileNm = objectInput.readUTF();
		serviceLanguage = objectInput.readUTF();
		viewCnt = objectInput.readLong();
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

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (resume == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(resume);
		}

		if (contentFilePath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contentFilePath);
		}

		if (contentFileNm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contentFileNm);
		}

		if (contentStartFileNm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contentStartFileNm);
		}

		if (serviceLanguage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceLanguage);
		}

		objectOutput.writeLong(viewCnt);
		objectOutput.writeLong(insertId);
		objectOutput.writeLong(insertDate);
		objectOutput.writeLong(updateId);
		objectOutput.writeLong(updateDate);
	}

	public long contentSeq;
	public long groupId;
	public String title;
	public String resume;
	public String contentFilePath;
	public String contentFileNm;
	public String contentStartFileNm;
	public String serviceLanguage;
	public long viewCnt;
	public long insertId;
	public long insertDate;
	public long updateId;
	public long updateDate;
}