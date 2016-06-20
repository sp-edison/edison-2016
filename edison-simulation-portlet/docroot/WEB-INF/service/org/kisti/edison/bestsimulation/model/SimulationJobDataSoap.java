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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.kisti.edison.bestsimulation.service.http.SimulationJobDataServiceSoap}.
 *
 * @author EDISON
 * @see org.kisti.edison.bestsimulation.service.http.SimulationJobDataServiceSoap
 * @generated
 */
public class SimulationJobDataSoap implements Serializable {
	public static SimulationJobDataSoap toSoapModel(SimulationJobData model) {
		SimulationJobDataSoap soapModel = new SimulationJobDataSoap();

		soapModel.setJobUuid(model.getJobUuid());
		soapModel.setJobData(model.getJobData());

		return soapModel;
	}

	public static SimulationJobDataSoap[] toSoapModels(
		SimulationJobData[] models) {
		SimulationJobDataSoap[] soapModels = new SimulationJobDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SimulationJobDataSoap[][] toSoapModels(
		SimulationJobData[][] models) {
		SimulationJobDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SimulationJobDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SimulationJobDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SimulationJobDataSoap[] toSoapModels(
		List<SimulationJobData> models) {
		List<SimulationJobDataSoap> soapModels = new ArrayList<SimulationJobDataSoap>(models.size());

		for (SimulationJobData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SimulationJobDataSoap[soapModels.size()]);
	}

	public SimulationJobDataSoap() {
	}

	public String getPrimaryKey() {
		return _jobUuid;
	}

	public void setPrimaryKey(String pk) {
		setJobUuid(pk);
	}

	public String getJobUuid() {
		return _jobUuid;
	}

	public void setJobUuid(String jobUuid) {
		_jobUuid = jobUuid;
	}

	public String getJobData() {
		return _jobData;
	}

	public void setJobData(String jobData) {
		_jobData = jobData;
	}

	private String _jobUuid;
	private String _jobData;
}