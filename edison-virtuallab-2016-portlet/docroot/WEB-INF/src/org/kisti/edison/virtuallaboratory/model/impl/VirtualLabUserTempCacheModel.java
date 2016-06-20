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

package org.kisti.edison.virtuallaboratory.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing VirtualLabUserTemp in entity cache.
 *
 * @author EDISON
 * @see VirtualLabUserTemp
 * @generated
 */
public class VirtualLabUserTempCacheModel implements CacheModel<VirtualLabUserTemp>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{seqNo=");
		sb.append(seqNo);
		sb.append(", virtualLabId=");
		sb.append(virtualLabId);
		sb.append(", classId=");
		sb.append(classId);
		sb.append(", userStudentNumber=");
		sb.append(userStudentNumber);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VirtualLabUserTemp toEntityModel() {
		VirtualLabUserTempImpl virtualLabUserTempImpl = new VirtualLabUserTempImpl();

		virtualLabUserTempImpl.setSeqNo(seqNo);
		virtualLabUserTempImpl.setVirtualLabId(virtualLabId);
		virtualLabUserTempImpl.setClassId(classId);

		if (userStudentNumber == null) {
			virtualLabUserTempImpl.setUserStudentNumber(StringPool.BLANK);
		}
		else {
			virtualLabUserTempImpl.setUserStudentNumber(userStudentNumber);
		}

		if (userName == null) {
			virtualLabUserTempImpl.setUserName(StringPool.BLANK);
		}
		else {
			virtualLabUserTempImpl.setUserName(userName);
		}

		virtualLabUserTempImpl.setStatus(status);

		virtualLabUserTempImpl.resetOriginalValues();

		return virtualLabUserTempImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		seqNo = objectInput.readLong();
		virtualLabId = objectInput.readLong();
		classId = objectInput.readLong();
		userStudentNumber = objectInput.readUTF();
		userName = objectInput.readUTF();
		status = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(seqNo);
		objectOutput.writeLong(virtualLabId);
		objectOutput.writeLong(classId);

		if (userStudentNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userStudentNumber);
		}

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeBoolean(status);
	}

	public long seqNo;
	public long virtualLabId;
	public long classId;
	public String userStudentNumber;
	public String userName;
	public boolean status;
}