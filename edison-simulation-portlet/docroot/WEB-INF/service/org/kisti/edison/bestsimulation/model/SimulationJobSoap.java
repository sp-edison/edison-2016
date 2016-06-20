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

package org.kisti.edison.bestsimulation.model;

import org.kisti.edison.bestsimulation.service.persistence.SimulationJobPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.bestsimulation.service.http.SimulationJobServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.bestsimulation.service.http.SimulationJobServiceSoap
 * @generated
 */
public class SimulationJobSoap implements Serializable {
	public static SimulationJobSoap toSoapModel(SimulationJob model) {
		SimulationJobSoap soapModel = new SimulationJobSoap();

		soapModel.setJobSeqNo(model.getJobSeqNo());
		soapModel.setSimulationUuid(model.getSimulationUuid());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setJobUuid(model.getJobUuid());
		soapModel.setJobStatus(model.getJobStatus());
		soapModel.setJobStartDt(model.getJobStartDt());
		soapModel.setJobEndDt(model.getJobEndDt());
		soapModel.setJobTitle(model.getJobTitle());
		soapModel.setJobExecPath(model.getJobExecPath());
		soapModel.setJobPhase(model.getJobPhase());
		soapModel.setJobSubmitDt(model.getJobSubmitDt());
		soapModel.setJobPostProcessor(model.getJobPostProcessor());
		soapModel.setJobUniversityField(model.getJobUniversityField());
		soapModel.setJobVirtualLabId(model.getJobVirtualLabId());
		soapModel.setJobClassId(model.getJobClassId());
		soapModel.setJobInputDeckYn(model.getJobInputDeckYn());
		soapModel.setJobInputDeckName(model.getJobInputDeckName());
		soapModel.setResultSize(model.getResultSize());
		soapModel.setTestYn(model.getTestYn());

		return soapModel;
	}

	public static SimulationJobSoap[] toSoapModels(SimulationJob[] models) {
		SimulationJobSoap[] soapModels = new SimulationJobSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SimulationJobSoap[][] toSoapModels(SimulationJob[][] models) {
		SimulationJobSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SimulationJobSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SimulationJobSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SimulationJobSoap[] toSoapModels(List<SimulationJob> models) {
		List<SimulationJobSoap> soapModels = new ArrayList<SimulationJobSoap>(models.size());

		for (SimulationJob model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SimulationJobSoap[soapModels.size()]);
	}

	public SimulationJobSoap() {
	}

	public SimulationJobPK getPrimaryKey() {
		return new SimulationJobPK(_jobSeqNo, _simulationUuid, _groupId);
	}

	public void setPrimaryKey(SimulationJobPK pk) {
		setJobSeqNo(pk.jobSeqNo);
		setSimulationUuid(pk.simulationUuid);
		setGroupId(pk.groupId);
	}

	public long getJobSeqNo() {
		return _jobSeqNo;
	}

	public void setJobSeqNo(long jobSeqNo) {
		_jobSeqNo = jobSeqNo;
	}

	public String getSimulationUuid() {
		return _simulationUuid;
	}

	public void setSimulationUuid(String simulationUuid) {
		_simulationUuid = simulationUuid;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getJobUuid() {
		return _jobUuid;
	}

	public void setJobUuid(String jobUuid) {
		_jobUuid = jobUuid;
	}

	public long getJobStatus() {
		return _jobStatus;
	}

	public void setJobStatus(long jobStatus) {
		_jobStatus = jobStatus;
	}

	public Date getJobStartDt() {
		return _jobStartDt;
	}

	public void setJobStartDt(Date jobStartDt) {
		_jobStartDt = jobStartDt;
	}

	public Date getJobEndDt() {
		return _jobEndDt;
	}

	public void setJobEndDt(Date jobEndDt) {
		_jobEndDt = jobEndDt;
	}

	public String getJobTitle() {
		return _jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	public String getJobExecPath() {
		return _jobExecPath;
	}

	public void setJobExecPath(String jobExecPath) {
		_jobExecPath = jobExecPath;
	}

	public long getJobPhase() {
		return _jobPhase;
	}

	public void setJobPhase(long jobPhase) {
		_jobPhase = jobPhase;
	}

	public Date getJobSubmitDt() {
		return _jobSubmitDt;
	}

	public void setJobSubmitDt(Date jobSubmitDt) {
		_jobSubmitDt = jobSubmitDt;
	}

	public String getJobPostProcessor() {
		return _jobPostProcessor;
	}

	public void setJobPostProcessor(String jobPostProcessor) {
		_jobPostProcessor = jobPostProcessor;
	}

	public long getJobUniversityField() {
		return _jobUniversityField;
	}

	public void setJobUniversityField(long jobUniversityField) {
		_jobUniversityField = jobUniversityField;
	}

	public long getJobVirtualLabId() {
		return _jobVirtualLabId;
	}

	public void setJobVirtualLabId(long jobVirtualLabId) {
		_jobVirtualLabId = jobVirtualLabId;
	}

	public long getJobClassId() {
		return _jobClassId;
	}

	public void setJobClassId(long jobClassId) {
		_jobClassId = jobClassId;
	}

	public boolean getJobInputDeckYn() {
		return _jobInputDeckYn;
	}

	public boolean isJobInputDeckYn() {
		return _jobInputDeckYn;
	}

	public void setJobInputDeckYn(boolean jobInputDeckYn) {
		_jobInputDeckYn = jobInputDeckYn;
	}

	public String getJobInputDeckName() {
		return _jobInputDeckName;
	}

	public void setJobInputDeckName(String jobInputDeckName) {
		_jobInputDeckName = jobInputDeckName;
	}

	public int getResultSize() {
		return _resultSize;
	}

	public void setResultSize(int resultSize) {
		_resultSize = resultSize;
	}

	public String getTestYn() {
		return _testYn;
	}

	public void setTestYn(String testYn) {
		_testYn = testYn;
	}

	private long _jobSeqNo;
	private String _simulationUuid;
	private long _groupId;
	private String _jobUuid;
	private long _jobStatus;
	private Date _jobStartDt;
	private Date _jobEndDt;
	private String _jobTitle;
	private String _jobExecPath;
	private long _jobPhase;
	private Date _jobSubmitDt;
	private String _jobPostProcessor;
	private long _jobUniversityField;
	private long _jobVirtualLabId;
	private long _jobClassId;
	private boolean _jobInputDeckYn;
	private String _jobInputDeckName;
	private int _resultSize;
	private String _testYn;
}