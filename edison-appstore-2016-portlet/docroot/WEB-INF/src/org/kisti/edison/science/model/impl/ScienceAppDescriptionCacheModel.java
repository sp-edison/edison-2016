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

import org.kisti.edison.science.model.ScienceAppDescription;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ScienceAppDescription in entity cache.
 *
 * @author EDISON
 * @see ScienceAppDescription
 * @generated
 */
public class ScienceAppDescriptionCacheModel implements CacheModel<ScienceAppDescription>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{descriptionId=");
		sb.append(descriptionId);
		sb.append(", content=");
		sb.append(content);
		sb.append(", insertId=");
		sb.append(insertId);
		sb.append(", insertDt=");
		sb.append(insertDt);
		sb.append(", updateId=");
		sb.append(updateId);
		sb.append(", updateDt=");
		sb.append(updateDt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ScienceAppDescription toEntityModel() {
		ScienceAppDescriptionImpl scienceAppDescriptionImpl = new ScienceAppDescriptionImpl();

		scienceAppDescriptionImpl.setDescriptionId(descriptionId);

		if (content == null) {
			scienceAppDescriptionImpl.setContent(StringPool.BLANK);
		}
		else {
			scienceAppDescriptionImpl.setContent(content);
		}

		scienceAppDescriptionImpl.setInsertId(insertId);

		if (insertDt == Long.MIN_VALUE) {
			scienceAppDescriptionImpl.setInsertDt(null);
		}
		else {
			scienceAppDescriptionImpl.setInsertDt(new Date(insertDt));
		}

		scienceAppDescriptionImpl.setUpdateId(updateId);

		if (updateDt == Long.MIN_VALUE) {
			scienceAppDescriptionImpl.setUpdateDt(null);
		}
		else {
			scienceAppDescriptionImpl.setUpdateDt(new Date(updateDt));
		}

		scienceAppDescriptionImpl.resetOriginalValues();

		return scienceAppDescriptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		descriptionId = objectInput.readLong();
		content = objectInput.readUTF();
		insertId = objectInput.readLong();
		insertDt = objectInput.readLong();
		updateId = objectInput.readLong();
		updateDt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(descriptionId);

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(insertId);
		objectOutput.writeLong(insertDt);
		objectOutput.writeLong(updateId);
		objectOutput.writeLong(updateDt);
	}

	public long descriptionId;
	public String content;
	public long insertId;
	public long insertDt;
	public long updateId;
	public long updateDt;
}