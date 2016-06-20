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

import com.kisti.science.platform.app.model.PortTypeAnalyzerLink;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PortTypeAnalyzerLink in entity cache.
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeAnalyzerLink
 * @generated
 */
public class PortTypeAnalyzerLinkCacheModel implements CacheModel<PortTypeAnalyzerLink>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", portTypeAnalyzerLinkId=");
		sb.append(portTypeAnalyzerLinkId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", portTypeId=");
		sb.append(portTypeId);
		sb.append(", analyzerId=");
		sb.append(analyzerId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PortTypeAnalyzerLink toEntityModel() {
		PortTypeAnalyzerLinkImpl portTypeAnalyzerLinkImpl = new PortTypeAnalyzerLinkImpl();

		if (uuid == null) {
			portTypeAnalyzerLinkImpl.setUuid(StringPool.BLANK);
		}
		else {
			portTypeAnalyzerLinkImpl.setUuid(uuid);
		}

		portTypeAnalyzerLinkImpl.setPortTypeAnalyzerLinkId(portTypeAnalyzerLinkId);
		portTypeAnalyzerLinkImpl.setCompanyId(companyId);
		portTypeAnalyzerLinkImpl.setPortTypeId(portTypeId);
		portTypeAnalyzerLinkImpl.setAnalyzerId(analyzerId);

		portTypeAnalyzerLinkImpl.resetOriginalValues();

		return portTypeAnalyzerLinkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		portTypeAnalyzerLinkId = objectInput.readLong();
		companyId = objectInput.readLong();
		portTypeId = objectInput.readLong();
		analyzerId = objectInput.readLong();
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

		objectOutput.writeLong(portTypeAnalyzerLinkId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(portTypeId);
		objectOutput.writeLong(analyzerId);
	}

	public String uuid;
	public long portTypeAnalyzerLinkId;
	public long companyId;
	public long portTypeId;
	public long analyzerId;
}