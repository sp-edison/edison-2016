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

import org.kisti.edison.virtuallaboratory.model.VirtualLabClass;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VirtualLabClass in entity cache.
 *
 * @author EDISON
 * @see VirtualLabClass
 * @generated
 */
public class VirtualLabClassCacheModel implements CacheModel<VirtualLabClass>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{classId=");
		sb.append(classId);
		sb.append(", classTitle=");
		sb.append(classTitle);
		sb.append(", classStartDt=");
		sb.append(classStartDt);
		sb.append(", classEndDt=");
		sb.append(classEndDt);
		sb.append(", classUseYn=");
		sb.append(classUseYn);
		sb.append(", classDescription=");
		sb.append(classDescription);
		sb.append(", classPersonnel=");
		sb.append(classPersonnel);
		sb.append(", classCreateDt=");
		sb.append(classCreateDt);
		sb.append(", classUpdateDt=");
		sb.append(classUpdateDt);
		sb.append(", virtualClassCd=");
		sb.append(virtualClassCd);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VirtualLabClass toEntityModel() {
		VirtualLabClassImpl virtualLabClassImpl = new VirtualLabClassImpl();

		virtualLabClassImpl.setClassId(classId);

		if (classTitle == null) {
			virtualLabClassImpl.setClassTitle(StringPool.BLANK);
		}
		else {
			virtualLabClassImpl.setClassTitle(classTitle);
		}

		if (classStartDt == null) {
			virtualLabClassImpl.setClassStartDt(StringPool.BLANK);
		}
		else {
			virtualLabClassImpl.setClassStartDt(classStartDt);
		}

		if (classEndDt == null) {
			virtualLabClassImpl.setClassEndDt(StringPool.BLANK);
		}
		else {
			virtualLabClassImpl.setClassEndDt(classEndDt);
		}

		if (classUseYn == null) {
			virtualLabClassImpl.setClassUseYn(StringPool.BLANK);
		}
		else {
			virtualLabClassImpl.setClassUseYn(classUseYn);
		}

		if (classDescription == null) {
			virtualLabClassImpl.setClassDescription(StringPool.BLANK);
		}
		else {
			virtualLabClassImpl.setClassDescription(classDescription);
		}

		virtualLabClassImpl.setClassPersonnel(classPersonnel);

		if (classCreateDt == Long.MIN_VALUE) {
			virtualLabClassImpl.setClassCreateDt(null);
		}
		else {
			virtualLabClassImpl.setClassCreateDt(new Date(classCreateDt));
		}

		if (classUpdateDt == Long.MIN_VALUE) {
			virtualLabClassImpl.setClassUpdateDt(null);
		}
		else {
			virtualLabClassImpl.setClassUpdateDt(new Date(classUpdateDt));
		}

		if (virtualClassCd == null) {
			virtualLabClassImpl.setVirtualClassCd(StringPool.BLANK);
		}
		else {
			virtualLabClassImpl.setVirtualClassCd(virtualClassCd);
		}

		virtualLabClassImpl.resetOriginalValues();

		return virtualLabClassImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		classId = objectInput.readLong();
		classTitle = objectInput.readUTF();
		classStartDt = objectInput.readUTF();
		classEndDt = objectInput.readUTF();
		classUseYn = objectInput.readUTF();
		classDescription = objectInput.readUTF();
		classPersonnel = objectInput.readInt();
		classCreateDt = objectInput.readLong();
		classUpdateDt = objectInput.readLong();
		virtualClassCd = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(classId);

		if (classTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(classTitle);
		}

		if (classStartDt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(classStartDt);
		}

		if (classEndDt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(classEndDt);
		}

		if (classUseYn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(classUseYn);
		}

		if (classDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(classDescription);
		}

		objectOutput.writeInt(classPersonnel);
		objectOutput.writeLong(classCreateDt);
		objectOutput.writeLong(classUpdateDt);

		if (virtualClassCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(virtualClassCd);
		}
	}

	public long classId;
	public String classTitle;
	public String classStartDt;
	public String classEndDt;
	public String classUseYn;
	public String classDescription;
	public int classPersonnel;
	public long classCreateDt;
	public long classUpdateDt;
	public String virtualClassCd;
}