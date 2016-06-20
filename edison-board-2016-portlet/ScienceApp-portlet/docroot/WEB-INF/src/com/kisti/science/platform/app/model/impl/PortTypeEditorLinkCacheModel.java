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

import com.kisti.science.platform.app.model.PortTypeEditorLink;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PortTypeEditorLink in entity cache.
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeEditorLink
 * @generated
 */
public class PortTypeEditorLinkCacheModel implements CacheModel<PortTypeEditorLink>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", portTypeEditorLinkId=");
		sb.append(portTypeEditorLinkId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", portTypeId=");
		sb.append(portTypeId);
		sb.append(", editorId=");
		sb.append(editorId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PortTypeEditorLink toEntityModel() {
		PortTypeEditorLinkImpl portTypeEditorLinkImpl = new PortTypeEditorLinkImpl();

		if (uuid == null) {
			portTypeEditorLinkImpl.setUuid(StringPool.BLANK);
		}
		else {
			portTypeEditorLinkImpl.setUuid(uuid);
		}

		portTypeEditorLinkImpl.setPortTypeEditorLinkId(portTypeEditorLinkId);
		portTypeEditorLinkImpl.setCompanyId(companyId);
		portTypeEditorLinkImpl.setPortTypeId(portTypeId);
		portTypeEditorLinkImpl.setEditorId(editorId);

		portTypeEditorLinkImpl.resetOriginalValues();

		return portTypeEditorLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		portTypeEditorLinkId = objectInput.readLong();
		companyId = objectInput.readLong();
		portTypeId = objectInput.readLong();
		editorId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(portTypeEditorLinkId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(portTypeId);
		objectOutput.writeLong(editorId);
	}

	public String uuid;
	public long portTypeEditorLinkId;
	public long companyId;
	public long portTypeId;
	public long editorId;
}