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

import com.kisti.science.platform.app.model.ScienceAppOutputPorts;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ScienceAppOutputPorts in entity cache.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppOutputPorts
 * @generated
 */
public class ScienceAppOutputPortsCacheModel implements CacheModel<ScienceAppOutputPorts>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{scienceAppId=");
		sb.append(scienceAppId);
		sb.append(", outputPorts=");
		sb.append(outputPorts);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ScienceAppOutputPorts toEntityModel() {
		ScienceAppOutputPortsImpl scienceAppOutputPortsImpl = new ScienceAppOutputPortsImpl();

		scienceAppOutputPortsImpl.setScienceAppId(scienceAppId);

		if (outputPorts == null) {
			scienceAppOutputPortsImpl.setOutputPorts(StringPool.BLANK);
		}
		else {
			scienceAppOutputPortsImpl.setOutputPorts(outputPorts);
		}

		scienceAppOutputPortsImpl.resetOriginalValues();

		return scienceAppOutputPortsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		scienceAppId = objectInput.readLong();
		outputPorts = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(scienceAppId);

		if (outputPorts == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(outputPorts);
		}
	}

	public long scienceAppId;
	public String outputPorts;
}