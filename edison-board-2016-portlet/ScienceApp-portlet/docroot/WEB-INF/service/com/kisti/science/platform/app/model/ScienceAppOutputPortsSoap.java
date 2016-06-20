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

package com.kisti.science.platform.app.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Jerry H. Seo & Young Suh
 * @generated
 */
public class ScienceAppOutputPortsSoap implements Serializable {
	public static ScienceAppOutputPortsSoap toSoapModel(
		ScienceAppOutputPorts model) {
		ScienceAppOutputPortsSoap soapModel = new ScienceAppOutputPortsSoap();

		soapModel.setScienceAppId(model.getScienceAppId());
		soapModel.setOutputPorts(model.getOutputPorts());

		return soapModel;
	}

	public static ScienceAppOutputPortsSoap[] toSoapModels(
		ScienceAppOutputPorts[] models) {
		ScienceAppOutputPortsSoap[] soapModels = new ScienceAppOutputPortsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScienceAppOutputPortsSoap[][] toSoapModels(
		ScienceAppOutputPorts[][] models) {
		ScienceAppOutputPortsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScienceAppOutputPortsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScienceAppOutputPortsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScienceAppOutputPortsSoap[] toSoapModels(
		List<ScienceAppOutputPorts> models) {
		List<ScienceAppOutputPortsSoap> soapModels = new ArrayList<ScienceAppOutputPortsSoap>(models.size());

		for (ScienceAppOutputPorts model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScienceAppOutputPortsSoap[soapModels.size()]);
	}

	public ScienceAppOutputPortsSoap() {
	}

	public long getPrimaryKey() {
		return _scienceAppId;
	}

	public void setPrimaryKey(long pk) {
		setScienceAppId(pk);
	}

	public long getScienceAppId() {
		return _scienceAppId;
	}

	public void setScienceAppId(long scienceAppId) {
		_scienceAppId = scienceAppId;
	}

	public String getOutputPorts() {
		return _outputPorts;
	}

	public void setOutputPorts(String outputPorts) {
		_outputPorts = outputPorts;
	}

	private long _scienceAppId;
	private String _outputPorts;
}