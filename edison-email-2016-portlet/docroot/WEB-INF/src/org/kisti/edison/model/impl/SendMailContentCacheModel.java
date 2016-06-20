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

package org.kisti.edison.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.model.SendMailContent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SendMailContent in entity cache.
 *
 * @author EDISON
 * @see SendMailContent
 * @generated
 */
public class SendMailContentCacheModel implements CacheModel<SendMailContent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{sendMailId=");
		sb.append(sendMailId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", sendCount=");
		sb.append(sendCount);
		sb.append(", successCount=");
		sb.append(successCount);
		sb.append(", failCount=");
		sb.append(failCount);
		sb.append(", sendDate=");
		sb.append(sendDate);
		sb.append(", siteGroup=");
		sb.append(siteGroup);
		sb.append(", userGroup=");
		sb.append(userGroup);
		sb.append(", state=");
		sb.append(state);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SendMailContent toEntityModel() {
		SendMailContentImpl sendMailContentImpl = new SendMailContentImpl();

		sendMailContentImpl.setSendMailId(sendMailId);
		sendMailContentImpl.setUserId(userId);
		sendMailContentImpl.setSendCount(sendCount);
		sendMailContentImpl.setSuccessCount(successCount);
		sendMailContentImpl.setFailCount(failCount);

		if (sendDate == Long.MIN_VALUE) {
			sendMailContentImpl.setSendDate(null);
		}
		else {
			sendMailContentImpl.setSendDate(new Date(sendDate));
		}

		if (siteGroup == null) {
			sendMailContentImpl.setSiteGroup(StringPool.BLANK);
		}
		else {
			sendMailContentImpl.setSiteGroup(siteGroup);
		}

		if (userGroup == null) {
			sendMailContentImpl.setUserGroup(StringPool.BLANK);
		}
		else {
			sendMailContentImpl.setUserGroup(userGroup);
		}

		if (state == null) {
			sendMailContentImpl.setState(StringPool.BLANK);
		}
		else {
			sendMailContentImpl.setState(state);
		}

		if (title == null) {
			sendMailContentImpl.setTitle(StringPool.BLANK);
		}
		else {
			sendMailContentImpl.setTitle(title);
		}

		if (content == null) {
			sendMailContentImpl.setContent(StringPool.BLANK);
		}
		else {
			sendMailContentImpl.setContent(content);
		}

		sendMailContentImpl.resetOriginalValues();

		return sendMailContentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sendMailId = objectInput.readLong();
		userId = objectInput.readLong();
		sendCount = objectInput.readInt();
		successCount = objectInput.readInt();
		failCount = objectInput.readInt();
		sendDate = objectInput.readLong();
		siteGroup = objectInput.readUTF();
		userGroup = objectInput.readUTF();
		state = objectInput.readUTF();
		title = objectInput.readUTF();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(sendMailId);
		objectOutput.writeLong(userId);
		objectOutput.writeInt(sendCount);
		objectOutput.writeInt(successCount);
		objectOutput.writeInt(failCount);
		objectOutput.writeLong(sendDate);

		if (siteGroup == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(siteGroup);
		}

		if (userGroup == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userGroup);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public long sendMailId;
	public long userId;
	public int sendCount;
	public int successCount;
	public int failCount;
	public long sendDate;
	public String siteGroup;
	public String userGroup;
	public String state;
	public String title;
	public String content;
}