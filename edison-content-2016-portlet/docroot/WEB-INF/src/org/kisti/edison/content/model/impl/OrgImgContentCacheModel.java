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

import org.kisti.edison.content.model.OrgImgContent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OrgImgContent in entity cache.
 *
 * @author EDISON
 * @see OrgImgContent
 * @generated
 */
public class OrgImgContentCacheModel implements CacheModel<OrgImgContent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{orgImgSeq=");
		sb.append(orgImgSeq);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", order=");
		sb.append(order);
		sb.append(", orgNm=");
		sb.append(orgNm);
		sb.append(", orgLink=");
		sb.append(orgLink);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
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
	public OrgImgContent toEntityModel() {
		OrgImgContentImpl orgImgContentImpl = new OrgImgContentImpl();

		orgImgContentImpl.setOrgImgSeq(orgImgSeq);
		orgImgContentImpl.setGroupId(groupId);
		orgImgContentImpl.setOrder(order);

		if (orgNm == null) {
			orgImgContentImpl.setOrgNm(StringPool.BLANK);
		}
		else {
			orgImgContentImpl.setOrgNm(orgNm);
		}

		if (orgLink == null) {
			orgImgContentImpl.setOrgLink(StringPool.BLANK);
		}
		else {
			orgImgContentImpl.setOrgLink(orgLink);
		}

		orgImgContentImpl.setFileEntryId(fileEntryId);
		orgImgContentImpl.setInsertId(insertId);

		if (insertDate == Long.MIN_VALUE) {
			orgImgContentImpl.setInsertDate(null);
		}
		else {
			orgImgContentImpl.setInsertDate(new Date(insertDate));
		}

		orgImgContentImpl.setUpdateId(updateId);

		if (updateDate == Long.MIN_VALUE) {
			orgImgContentImpl.setUpdateDate(null);
		}
		else {
			orgImgContentImpl.setUpdateDate(new Date(updateDate));
		}

		orgImgContentImpl.resetOriginalValues();

		return orgImgContentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		orgImgSeq = objectInput.readLong();
		groupId = objectInput.readLong();
		order = objectInput.readLong();
		orgNm = objectInput.readUTF();
		orgLink = objectInput.readUTF();
		fileEntryId = objectInput.readLong();
		insertId = objectInput.readLong();
		insertDate = objectInput.readLong();
		updateId = objectInput.readLong();
		updateDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(orgImgSeq);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(order);

		if (orgNm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orgNm);
		}

		if (orgLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orgLink);
		}

		objectOutput.writeLong(fileEntryId);
		objectOutput.writeLong(insertId);
		objectOutput.writeLong(insertDate);
		objectOutput.writeLong(updateId);
		objectOutput.writeLong(updateDate);
	}

	public long orgImgSeq;
	public long groupId;
	public long order;
	public String orgNm;
	public String orgLink;
	public long fileEntryId;
	public long insertId;
	public long insertDate;
	public long updateId;
	public long updateDate;
}