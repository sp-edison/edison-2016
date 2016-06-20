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

import org.kisti.edison.bestsimulation.model.SimulationJob;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SimulationJob in entity cache.
 *
 * @author EDISON
 * @see SimulationJob
 * @generated
 */
public class SimulationJobCacheModel implements CacheModel<SimulationJob>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{jobSeqNo=");
		sb.append(jobSeqNo);
		sb.append(", simulationUuid=");
		sb.append(simulationUuid);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", jobUuid=");
		sb.append(jobUuid);
		sb.append(", jobStatus=");
		sb.append(jobStatus);
		sb.append(", jobStartDt=");
		sb.append(jobStartDt);
		sb.append(", jobEndDt=");
		sb.append(jobEndDt);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", jobExecPath=");
		sb.append(jobExecPath);
		sb.append(", jobPhase=");
		sb.append(jobPhase);
		sb.append(", jobSubmitDt=");
		sb.append(jobSubmitDt);
		sb.append(", jobPostProcessor=");
		sb.append(jobPostProcessor);
		sb.append(", jobUniversityField=");
		sb.append(jobUniversityField);
		sb.append(", jobVirtualLabId=");
		sb.append(jobVirtualLabId);
		sb.append(", jobClassId=");
		sb.append(jobClassId);
		sb.append(", jobInputDeckYn=");
		sb.append(jobInputDeckYn);
		sb.append(", jobInputDeckName=");
		sb.append(jobInputDeckName);
		sb.append(", resultSize=");
		sb.append(resultSize);
		sb.append(", testYn=");
		sb.append(testYn);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SimulationJob toEntityModel() {
		SimulationJobImpl simulationJobImpl = new SimulationJobImpl();

		simulationJobImpl.setJobSeqNo(jobSeqNo);

		if (simulationUuid == null) {
			simulationJobImpl.setSimulationUuid(StringPool.BLANK);
		}
		else {
			simulationJobImpl.setSimulationUuid(simulationUuid);
		}

		simulationJobImpl.setGroupId(groupId);

		if (jobUuid == null) {
			simulationJobImpl.setJobUuid(StringPool.BLANK);
		}
		else {
			simulationJobImpl.setJobUuid(jobUuid);
		}

		simulationJobImpl.setJobStatus(jobStatus);

		if (jobStartDt == Long.MIN_VALUE) {
			simulationJobImpl.setJobStartDt(null);
		}
		else {
			simulationJobImpl.setJobStartDt(new Date(jobStartDt));
		}

		if (jobEndDt == Long.MIN_VALUE) {
			simulationJobImpl.setJobEndDt(null);
		}
		else {
			simulationJobImpl.setJobEndDt(new Date(jobEndDt));
		}

		if (jobTitle == null) {
			simulationJobImpl.setJobTitle(StringPool.BLANK);
		}
		else {
			simulationJobImpl.setJobTitle(jobTitle);
		}

		if (jobExecPath == null) {
			simulationJobImpl.setJobExecPath(StringPool.BLANK);
		}
		else {
			simulationJobImpl.setJobExecPath(jobExecPath);
		}

		simulationJobImpl.setJobPhase(jobPhase);

		if (jobSubmitDt == Long.MIN_VALUE) {
			simulationJobImpl.setJobSubmitDt(null);
		}
		else {
			simulationJobImpl.setJobSubmitDt(new Date(jobSubmitDt));
		}

		if (jobPostProcessor == null) {
			simulationJobImpl.setJobPostProcessor(StringPool.BLANK);
		}
		else {
			simulationJobImpl.setJobPostProcessor(jobPostProcessor);
		}

		simulationJobImpl.setJobUniversityField(jobUniversityField);
		simulationJobImpl.setJobVirtualLabId(jobVirtualLabId);
		simulationJobImpl.setJobClassId(jobClassId);
		simulationJobImpl.setJobInputDeckYn(jobInputDeckYn);

		if (jobInputDeckName == null) {
			simulationJobImpl.setJobInputDeckName(StringPool.BLANK);
		}
		else {
			simulationJobImpl.setJobInputDeckName(jobInputDeckName);
		}

		simulationJobImpl.setResultSize(resultSize);

		if (testYn == null) {
			simulationJobImpl.setTestYn(StringPool.BLANK);
		}
		else {
			simulationJobImpl.setTestYn(testYn);
		}

		simulationJobImpl.resetOriginalValues();

		return simulationJobImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jobSeqNo = objectInput.readLong();
		simulationUuid = objectInput.readUTF();
		groupId = objectInput.readLong();
		jobUuid = objectInput.readUTF();
		jobStatus = objectInput.readLong();
		jobStartDt = objectInput.readLong();
		jobEndDt = objectInput.readLong();
		jobTitle = objectInput.readUTF();
		jobExecPath = objectInput.readUTF();
		jobPhase = objectInput.readLong();
		jobSubmitDt = objectInput.readLong();
		jobPostProcessor = objectInput.readUTF();
		jobUniversityField = objectInput.readLong();
		jobVirtualLabId = objectInput.readLong();
		jobClassId = objectInput.readLong();
		jobInputDeckYn = objectInput.readBoolean();
		jobInputDeckName = objectInput.readUTF();
		resultSize = objectInput.readInt();
		testYn = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jobSeqNo);

		if (simulationUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(simulationUuid);
		}

		objectOutput.writeLong(groupId);

		if (jobUuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobUuid);
		}

		objectOutput.writeLong(jobStatus);
		objectOutput.writeLong(jobStartDt);
		objectOutput.writeLong(jobEndDt);

		if (jobTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}

		if (jobExecPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobExecPath);
		}

		objectOutput.writeLong(jobPhase);
		objectOutput.writeLong(jobSubmitDt);

		if (jobPostProcessor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobPostProcessor);
		}

		objectOutput.writeLong(jobUniversityField);
		objectOutput.writeLong(jobVirtualLabId);
		objectOutput.writeLong(jobClassId);
		objectOutput.writeBoolean(jobInputDeckYn);

		if (jobInputDeckName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobInputDeckName);
		}

		objectOutput.writeInt(resultSize);

		if (testYn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(testYn);
		}
	}

	public long jobSeqNo;
	public String simulationUuid;
	public long groupId;
	public String jobUuid;
	public long jobStatus;
	public long jobStartDt;
	public long jobEndDt;
	public String jobTitle;
	public String jobExecPath;
	public long jobPhase;
	public long jobSubmitDt;
	public String jobPostProcessor;
	public long jobUniversityField;
	public long jobVirtualLabId;
	public long jobClassId;
	public boolean jobInputDeckYn;
	public String jobInputDeckName;
	public int resultSize;
	public String testYn;
}