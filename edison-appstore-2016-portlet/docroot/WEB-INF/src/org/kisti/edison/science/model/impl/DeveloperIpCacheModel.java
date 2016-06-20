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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.science.model.DeveloperIp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DeveloperIp in entity cache.
 *
 * @author EDISON
 * @see DeveloperIp
 * @generated
 */
public class DeveloperIpCacheModel implements CacheModel<DeveloperIp>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{ipSeq=");
		sb.append(ipSeq);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", ip1=");
		sb.append(ip1);
		sb.append(", ip2=");
		sb.append(ip2);
		sb.append(", ip3=");
		sb.append(ip3);
		sb.append(", ip4=");
		sb.append(ip4);
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
	public DeveloperIp toEntityModel() {
		DeveloperIpImpl developerIpImpl = new DeveloperIpImpl();

		developerIpImpl.setIpSeq(ipSeq);
		developerIpImpl.setUserId(userId);
		developerIpImpl.setGroupId(groupId);

		if (ip1 == null) {
			developerIpImpl.setIp1(StringPool.BLANK);
		}
		else {
			developerIpImpl.setIp1(ip1);
		}

		if (ip2 == null) {
			developerIpImpl.setIp2(StringPool.BLANK);
		}
		else {
			developerIpImpl.setIp2(ip2);
		}

		if (ip3 == null) {
			developerIpImpl.setIp3(StringPool.BLANK);
		}
		else {
			developerIpImpl.setIp3(ip3);
		}

		if (ip4 == null) {
			developerIpImpl.setIp4(StringPool.BLANK);
		}
		else {
			developerIpImpl.setIp4(ip4);
		}

		developerIpImpl.setInsertId(insertId);

		if (insertDate == Long.MIN_VALUE) {
			developerIpImpl.setInsertDate(null);
		}
		else {
			developerIpImpl.setInsertDate(new Date(insertDate));
		}

		developerIpImpl.setUpdateId(updateId);

		if (updateDate == Long.MIN_VALUE) {
			developerIpImpl.setUpdateDate(null);
		}
		else {
			developerIpImpl.setUpdateDate(new Date(updateDate));
		}

		developerIpImpl.resetOriginalValues();

		return developerIpImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ipSeq = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		ip1 = objectInput.readUTF();
		ip2 = objectInput.readUTF();
		ip3 = objectInput.readUTF();
		ip4 = objectInput.readUTF();
		insertId = objectInput.readLong();
		insertDate = objectInput.readLong();
		updateId = objectInput.readLong();
		updateDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ipSeq);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(groupId);

		if (ip1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ip1);
		}

		if (ip2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ip2);
		}

		if (ip3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ip3);
		}

		if (ip4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ip4);
		}

		objectOutput.writeLong(insertId);
		objectOutput.writeLong(insertDate);
		objectOutput.writeLong(updateId);
		objectOutput.writeLong(updateDate);
	}

	public long ipSeq;
	public long userId;
	public long groupId;
	public String ip1;
	public String ip2;
	public String ip3;
	public String ip4;
	public long insertId;
	public long insertDate;
	public long updateId;
	public long updateDate;
}