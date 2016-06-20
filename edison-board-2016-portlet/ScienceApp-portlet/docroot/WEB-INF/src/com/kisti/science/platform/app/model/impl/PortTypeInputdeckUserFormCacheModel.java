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

package com.kisti.science.platform.app.model.impl;

import com.kisti.science.platform.app.model.PortTypeInputdeckUserForm;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PortTypeInputdeckUserForm in entity cache.
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeInputdeckUserForm
 * @generated
 */
public class PortTypeInputdeckUserFormCacheModel implements CacheModel<PortTypeInputdeckUserForm>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{inputdeckId=");
		sb.append(inputdeckId);
		sb.append(", portTypeId=");
		sb.append(portTypeId);
		sb.append(", inputdeckUserForm=");
		sb.append(inputdeckUserForm);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PortTypeInputdeckUserForm toEntityModel() {
		PortTypeInputdeckUserFormImpl portTypeInputdeckUserFormImpl = new PortTypeInputdeckUserFormImpl();

		portTypeInputdeckUserFormImpl.setInputdeckId(inputdeckId);
		portTypeInputdeckUserFormImpl.setPortTypeId(portTypeId);

		if (inputdeckUserForm == null) {
			portTypeInputdeckUserFormImpl.setInputdeckUserForm(StringPool.BLANK);
		}
		else {
			portTypeInputdeckUserFormImpl.setInputdeckUserForm(inputdeckUserForm);
		}

		portTypeInputdeckUserFormImpl.setUserId(userId);

		if (userName == null) {
			portTypeInputdeckUserFormImpl.setUserName(StringPool.BLANK);
		}
		else {
			portTypeInputdeckUserFormImpl.setUserName(userName);
		}

		portTypeInputdeckUserFormImpl.resetOriginalValues();

		return portTypeInputdeckUserFormImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		inputdeckId = objectInput.readLong();
		portTypeId = objectInput.readLong();
		inputdeckUserForm = objectInput.readUTF();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(inputdeckId);
		objectOutput.writeLong(portTypeId);

		if (inputdeckUserForm == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(inputdeckUserForm);
		}

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}
	}

	public long inputdeckId;
	public long portTypeId;
	public String inputdeckUserForm;
	public long userId;
	public String userName;
}