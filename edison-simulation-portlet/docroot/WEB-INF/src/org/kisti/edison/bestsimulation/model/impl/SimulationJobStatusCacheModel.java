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

import org.kisti.edison.bestsimulation.model.SimulationJobStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SimulationJobStatus in entity cache.
 *
 * @author EDISON
 * @see SimulationJobStatus
 * @generated
 */
public class SimulationJobStatusCacheModel implements CacheModel<SimulationJobStatus>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{statusSeq=");
		sb.append(statusSeq);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", simulationUuid=");
		sb.append(simulationUuid);
		sb.append(", jobUuid=");
		sb.append(jobUuid);
		sb.append(", jobStatus=");
		sb.append(jobStatus);
		sb.append(", jobStartDt=");
		sb.append(jobStartDt);
		sb.append(", jobEndDt=");
		sb.append(jobEndDt);
		sb.append(", writeDt=");
		sb.append(writeDt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SimulationJobStatus toEntityModel() {
		SimulationJobStatusImpl simulationJobStatusImpl = new SimulationJobStatusImpl();

		simulationJobStatusImpl.setStatusSeq(statusSeq);
		simulationJobStatusImpl.setGroupId(groupId);

		if (simulationUuid == null) {
			simulationJobStatusImpl.setSimulationUuid(StringPool.BLANK);
		}
		else {
			simulationJobStatusImpl.setSimulationUuid(simulationUuid);
		}

		if (jobUuid == null) {
			simulationJobStatusImpl.setJobUuid(StringPool.BLANK);
		}
		else {
			simulationJobStatusImpl.setJobUuid(jobUuid);
		}

		simulationJobStatusImpl.setJobStatus(jobStatus);

		if (jobStartDt == Long.MIN_VALUE) {
			simulationJobStatusImpl.setJobStartDt(null);
		}
		else {
			simulationJobStatusImpl.setJobStartDt(new Date(jobStartDt));
		}

		if (jobEndDt == Long.MIN_VALUE) {
			simulationJobStatusImpl.setJobEndDt(null);
		}
		else {
			simulationJobStatusImpl.setJobEndDt(new Date(jobEndDt));
		}

		if (writeDt == Long.MIN_VALUE) {
			simulationJobStatusImpl.setWriteDt(null);
		}
		else {
			simulationJobStatusImpl.setWriteDt(new Date(writeDt));
		}

		simulationJobStatusImpl.resetOriginalValues();

		return simulationJobStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		statusSeq = objectInput.readLong();
		groupId = objectInput.readLong();
		simulationUuid = objectInput.readUTF();
		jobUuid = objectInput.readUTF();
		jobStatus = objectInput.readLong();
		jobStartDt = objectInput.readLong();
		jobEndDt = objectInput.readLong();
		writeDt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(statusSeq);
		objectOutput.writeLong(groupId);

		if (simulationUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(simulationUuid);
		}

		if (jobUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobUuid);
		}

		objectOutput.writeLong(jobStatus);
		objectOutput.writeLong(jobStartDt);
		objectOutput.writeLong(jobEndDt);
		objectOutput.writeLong(writeDt);
	}

	public long statusSeq;
	public long groupId;
	public String simulationUuid;
	public String jobUuid;
	public long jobStatus;
	public long jobStartDt;
	public long jobEndDt;
	public long writeDt;
}