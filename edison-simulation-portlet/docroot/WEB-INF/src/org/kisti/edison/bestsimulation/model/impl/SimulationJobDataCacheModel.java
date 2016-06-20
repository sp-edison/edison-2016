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

package org.kisti.edison.bestsimulation.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.kisti.edison.bestsimulation.model.SimulationJobData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SimulationJobData in entity cache.
 *
 * @author EDISON
 * @see SimulationJobData
 * @generated
 */
public class SimulationJobDataCacheModel implements CacheModel<SimulationJobData>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{jobUuid=");
		sb.append(jobUuid);
		sb.append(", jobData=");
		sb.append(jobData);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SimulationJobData toEntityModel() {
		SimulationJobDataImpl simulationJobDataImpl = new SimulationJobDataImpl();

		if (jobUuid == null) {
			simulationJobDataImpl.setJobUuid(StringPool.BLANK);
		}
		else {
			simulationJobDataImpl.setJobUuid(jobUuid);
		}

		if (jobData == null) {
			simulationJobDataImpl.setJobData(StringPool.BLANK);
		}
		else {
			simulationJobDataImpl.setJobData(jobData);
		}

		simulationJobDataImpl.resetOriginalValues();

		return simulationJobDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jobUuid = objectInput.readUTF();
		jobData = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (jobUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobUuid);
		}

		if (jobData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobData);
		}
	}

	public String jobUuid;
	public String jobData;
}