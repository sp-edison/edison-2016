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

import org.kisti.edison.bestsimulation.service.persistence.SimulationPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.bestsimulation.service.http.SimulationServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.bestsimulation.service.http.SimulationServiceSoap
 * @generated
 */
public class SimulationSoap implements Serializable {
	public static SimulationSoap toSoapModel(Simulation model) {
		SimulationSoap soapModel = new SimulationSoap();

		soapModel.setSimulationUuid(model.getSimulationUuid());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setSimulationTitle(model.getSimulationTitle());
		soapModel.setSimulationDescription(model.getSimulationDescription());
		soapModel.setScienceAppId(model.getScienceAppId());
		soapModel.setScienceAppName(model.getScienceAppName());
		soapModel.setSimulationCreateDt(model.getSimulationCreateDt());
		soapModel.setCluster(model.getCluster());
		soapModel.setTestYn(model.getTestYn());

		return soapModel;
	}

	public static SimulationSoap[] toSoapModels(Simulation[] models) {
		SimulationSoap[] soapModels = new SimulationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SimulationSoap[][] toSoapModels(Simulation[][] models) {
		SimulationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SimulationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SimulationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SimulationSoap[] toSoapModels(List<Simulation> models) {
		List<SimulationSoap> soapModels = new ArrayList<SimulationSoap>(models.size());

		for (Simulation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SimulationSoap[soapModels.size()]);
	}

	public SimulationSoap() {
	}

	public SimulationPK getPrimaryKey() {
		return new SimulationPK(_simulationUuid, _groupId);
	}

	public void setPrimaryKey(SimulationPK pk) {
		setSimulationUuid(pk.simulationUuid);
		setGroupId(pk.groupId);
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getSimulationTitle() {
		return _simulationTitle;
	}

	public void setSimulationTitle(String simulationTitle) {
		_simulationTitle = simulationTitle;
	}

	public String getSimulationDescription() {
		return _simulationDescription;
	}

	public void setSimulationDescription(String simulationDescription) {
		_simulationDescription = simulationDescription;
	}

	public String getScienceAppId() {
		return _scienceAppId;
	}

	public void setScienceAppId(String scienceAppId) {
		_scienceAppId = scienceAppId;
	}

	public String getScienceAppName() {
		return _scienceAppName;
	}

	public void setScienceAppName(String scienceAppName) {
		_scienceAppName = scienceAppName;
	}

	public Date getSimulationCreateDt() {
		return _simulationCreateDt;
	}

	public void setSimulationCreateDt(Date simulationCreateDt) {
		_simulationCreateDt = simulationCreateDt;
	}

	public String getCluster() {
		return _cluster;
	}

	public void setCluster(String cluster) {
		_cluster = cluster;
	}

	public String getTestYn() {
		return _testYn;
	}

	public void setTestYn(String testYn) {
		_testYn = testYn;
	}

	private String _simulationUuid;
	private long _groupId;
	private long _userId;
	private String _simulationTitle;
	private String _simulationDescription;
	private String _scienceAppId;
	private String _scienceAppName;
	private Date _simulationCreateDt;
	private String _cluster;
	private String _testYn;
}