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

import org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.bestsimulation.service.http.SimulationJobStatusServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.bestsimulation.service.http.SimulationJobStatusServiceSoap
 * @generated
 */
public class SimulationJobStatusSoap implements Serializable {
	public static SimulationJobStatusSoap toSoapModel(SimulationJobStatus model) {
		SimulationJobStatusSoap soapModel = new SimulationJobStatusSoap();

		soapModel.setStatusSeq(model.getStatusSeq());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setSimulationUuid(model.getSimulationUuid());
		soapModel.setJobUuid(model.getJobUuid());
		soapModel.setJobStatus(model.getJobStatus());
		soapModel.setJobStartDt(model.getJobStartDt());
		soapModel.setJobEndDt(model.getJobEndDt());
		soapModel.setWriteDt(model.getWriteDt());

		return soapModel;
	}

	public static SimulationJobStatusSoap[] toSoapModels(
		SimulationJobStatus[] models) {
		SimulationJobStatusSoap[] soapModels = new SimulationJobStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SimulationJobStatusSoap[][] toSoapModels(
		SimulationJobStatus[][] models) {
		SimulationJobStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SimulationJobStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SimulationJobStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SimulationJobStatusSoap[] toSoapModels(
		List<SimulationJobStatus> models) {
		List<SimulationJobStatusSoap> soapModels = new ArrayList<SimulationJobStatusSoap>(models.size());

		for (SimulationJobStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SimulationJobStatusSoap[soapModels.size()]);
	}

	public SimulationJobStatusSoap() {
	}

	public SimulationJobStatusPK getPrimaryKey() {
		return new SimulationJobStatusPK(_statusSeq, _groupId, _simulationUuid,
			_jobUuid);
	}

	public void setPrimaryKey(SimulationJobStatusPK pk) {
		setStatusSeq(pk.statusSeq);
		setGroupId(pk.groupId);
		setSimulationUuid(pk.simulationUuid);
		setJobUuid(pk.jobUuid);
	}

	public long getStatusSeq() {
		return _statusSeq;
	}

	public void setStatusSeq(long statusSeq) {
		_statusSeq = statusSeq;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getSimulationUuid() {
		return _simulationUuid;
	}

	public void setSimulationUuid(String simulationUuid) {
		_simulationUuid = simulationUuid;
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

	public Date getWriteDt() {
		return _writeDt;
	}

	public void setWriteDt(Date writeDt) {
		_writeDt = writeDt;
	}

	private long _statusSeq;
	private long _groupId;
	private String _simulationUuid;
	private String _jobUuid;
	private long _jobStatus;
	private Date _jobStartDt;
	private Date _jobEndDt;
	private Date _writeDt;
}