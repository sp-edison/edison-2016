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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.kisti.edison.bestsimulation.service.ClpSerializer;
import org.kisti.edison.bestsimulation.service.SimulationJobStatusLocalServiceUtil;
import org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author EDISON
 */
public class SimulationJobStatusClp extends BaseModelImpl<SimulationJobStatus>
	implements SimulationJobStatus {
	public SimulationJobStatusClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SimulationJobStatus.class;
	}

	@Override
	public String getModelClassName() {
		return SimulationJobStatus.class.getName();
	}

	@Override
	public SimulationJobStatusPK getPrimaryKey() {
		return new SimulationJobStatusPK(_statusSeq, _groupId, _simulationUuid,
			_jobUuid);
	}

	@Override
	public void setPrimaryKey(SimulationJobStatusPK primaryKey) {
		setStatusSeq(primaryKey.statusSeq);
		setGroupId(primaryKey.groupId);
		setSimulationUuid(primaryKey.simulationUuid);
		setJobUuid(primaryKey.jobUuid);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new SimulationJobStatusPK(_statusSeq, _groupId, _simulationUuid,
			_jobUuid);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((SimulationJobStatusPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("statusSeq", getStatusSeq());
		attributes.put("groupId", getGroupId());
		attributes.put("simulationUuid", getSimulationUuid());
		attributes.put("jobUuid", getJobUuid());
		attributes.put("jobStatus", getJobStatus());
		attributes.put("jobStartDt", getJobStartDt());
		attributes.put("jobEndDt", getJobEndDt());
		attributes.put("writeDt", getWriteDt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long statusSeq = (Long)attributes.get("statusSeq");

		if (statusSeq != null) {
			setStatusSeq(statusSeq);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String simulationUuid = (String)attributes.get("simulationUuid");

		if (simulationUuid != null) {
			setSimulationUuid(simulationUuid);
		}

		String jobUuid = (String)attributes.get("jobUuid");

		if (jobUuid != null) {
			setJobUuid(jobUuid);
		}

		Long jobStatus = (Long)attributes.get("jobStatus");

		if (jobStatus != null) {
			setJobStatus(jobStatus);
		}

		Date jobStartDt = (Date)attributes.get("jobStartDt");

		if (jobStartDt != null) {
			setJobStartDt(jobStartDt);
		}

		Date jobEndDt = (Date)attributes.get("jobEndDt");

		if (jobEndDt != null) {
			setJobEndDt(jobEndDt);
		}

		Date writeDt = (Date)attributes.get("writeDt");

		if (writeDt != null) {
			setWriteDt(writeDt);
		}
	}

	@Override
	public long getStatusSeq() {
		return _statusSeq;
	}

	@Override
	public void setStatusSeq(long statusSeq) {
		_statusSeq = statusSeq;

		if (_simulationJobStatusRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusSeq", long.class);

				method.invoke(_simulationJobStatusRemoteModel, statusSeq);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_simulationJobStatusRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_simulationJobStatusRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSimulationUuid() {
		return _simulationUuid;
	}

	@Override
	public void setSimulationUuid(String simulationUuid) {
		_simulationUuid = simulationUuid;

		if (_simulationJobStatusRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setSimulationUuid",
						String.class);

				method.invoke(_simulationJobStatusRemoteModel, simulationUuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobUuid() {
		return _jobUuid;
	}

	@Override
	public void setJobUuid(String jobUuid) {
		_jobUuid = jobUuid;

		if (_simulationJobStatusRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setJobUuid", String.class);

				method.invoke(_simulationJobStatusRemoteModel, jobUuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getJobStatus() {
		return _jobStatus;
	}

	@Override
	public void setJobStatus(long jobStatus) {
		_jobStatus = jobStatus;

		if (_simulationJobStatusRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setJobStatus", long.class);

				method.invoke(_simulationJobStatusRemoteModel, jobStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getJobStartDt() {
		return _jobStartDt;
	}

	@Override
	public void setJobStartDt(Date jobStartDt) {
		_jobStartDt = jobStartDt;

		if (_simulationJobStatusRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setJobStartDt", Date.class);

				method.invoke(_simulationJobStatusRemoteModel, jobStartDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getJobEndDt() {
		return _jobEndDt;
	}

	@Override
	public void setJobEndDt(Date jobEndDt) {
		_jobEndDt = jobEndDt;

		if (_simulationJobStatusRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setJobEndDt", Date.class);

				method.invoke(_simulationJobStatusRemoteModel, jobEndDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getWriteDt() {
		return _writeDt;
	}

	@Override
	public void setWriteDt(Date writeDt) {
		_writeDt = writeDt;

		if (_simulationJobStatusRemoteModel != null) {
			try {
				Class<?> clazz = _simulationJobStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setWriteDt", Date.class);

				method.invoke(_simulationJobStatusRemoteModel, writeDt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSimulationJobStatusRemoteModel() {
		return _simulationJobStatusRemoteModel;
	}

	public void setSimulationJobStatusRemoteModel(
		BaseModel<?> simulationJobStatusRemoteModel) {
		_simulationJobStatusRemoteModel = simulationJobStatusRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _simulationJobStatusRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_simulationJobStatusRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SimulationJobStatusLocalServiceUtil.addSimulationJobStatus(this);
		}
		else {
			SimulationJobStatusLocalServiceUtil.updateSimulationJobStatus(this);
		}
	}

	@Override
	public SimulationJobStatus toEscapedModel() {
		return (SimulationJobStatus)ProxyUtil.newProxyInstance(SimulationJobStatus.class.getClassLoader(),
			new Class[] { SimulationJobStatus.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SimulationJobStatusClp clone = new SimulationJobStatusClp();

		clone.setStatusSeq(getStatusSeq());
		clone.setGroupId(getGroupId());
		clone.setSimulationUuid(getSimulationUuid());
		clone.setJobUuid(getJobUuid());
		clone.setJobStatus(getJobStatus());
		clone.setJobStartDt(getJobStartDt());
		clone.setJobEndDt(getJobEndDt());
		clone.setWriteDt(getWriteDt());

		return clone;
	}

	@Override
	public int compareTo(SimulationJobStatus simulationJobStatus) {
		int value = 0;

		if (getStatusSeq() < simulationJobStatus.getStatusSeq()) {
			value = -1;
		}
		else if (getStatusSeq() > simulationJobStatus.getStatusSeq()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SimulationJobStatusClp)) {
			return false;
		}

		SimulationJobStatusClp simulationJobStatus = (SimulationJobStatusClp)obj;

		SimulationJobStatusPK primaryKey = simulationJobStatus.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{statusSeq=");
		sb.append(getStatusSeq());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", simulationUuid=");
		sb.append(getSimulationUuid());
		sb.append(", jobUuid=");
		sb.append(getJobUuid());
		sb.append(", jobStatus=");
		sb.append(getJobStatus());
		sb.append(", jobStartDt=");
		sb.append(getJobStartDt());
		sb.append(", jobEndDt=");
		sb.append(getJobEndDt());
		sb.append(", writeDt=");
		sb.append(getWriteDt());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("org.kisti.edison.bestsimulation.model.SimulationJobStatus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>statusSeq</column-name><column-value><![CDATA[");
		sb.append(getStatusSeq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>simulationUuid</column-name><column-value><![CDATA[");
		sb.append(getSimulationUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobUuid</column-name><column-value><![CDATA[");
		sb.append(getJobUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobStatus</column-name><column-value><![CDATA[");
		sb.append(getJobStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobStartDt</column-name><column-value><![CDATA[");
		sb.append(getJobStartDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobEndDt</column-name><column-value><![CDATA[");
		sb.append(getJobEndDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>writeDt</column-name><column-value><![CDATA[");
		sb.append(getWriteDt());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _statusSeq;
	private long _groupId;
	private String _simulationUuid;
	private String _jobUuid;
	private long _jobStatus;
	private Date _jobStartDt;
	private Date _jobEndDt;
	private Date _writeDt;
	private BaseModel<?> _simulationJobStatusRemoteModel;
	private Class<?> _clpSerializerClass = org.kisti.edison.bestsimulation.service.ClpSerializer.class;
}