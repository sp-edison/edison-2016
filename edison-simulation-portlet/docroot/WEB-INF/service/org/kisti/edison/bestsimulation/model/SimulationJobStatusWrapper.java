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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SimulationJobStatus}.
 * </p>
 *
 * @author EDISON
 * @see SimulationJobStatus
 * @generated
 */
public class SimulationJobStatusWrapper implements SimulationJobStatus,
	ModelWrapper<SimulationJobStatus> {
	public SimulationJobStatusWrapper(SimulationJobStatus simulationJobStatus) {
		_simulationJobStatus = simulationJobStatus;
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

	/**
	* Returns the primary key of this simulation job status.
	*
	* @return the primary key of this simulation job status
	*/
	@Override
	public org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK getPrimaryKey() {
		return _simulationJobStatus.getPrimaryKey();
	}

	/**
	* Sets the primary key of this simulation job status.
	*
	* @param primaryKey the primary key of this simulation job status
	*/
	@Override
	public void setPrimaryKey(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK primaryKey) {
		_simulationJobStatus.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the status seq of this simulation job status.
	*
	* @return the status seq of this simulation job status
	*/
	@Override
	public long getStatusSeq() {
		return _simulationJobStatus.getStatusSeq();
	}

	/**
	* Sets the status seq of this simulation job status.
	*
	* @param statusSeq the status seq of this simulation job status
	*/
	@Override
	public void setStatusSeq(long statusSeq) {
		_simulationJobStatus.setStatusSeq(statusSeq);
	}

	/**
	* Returns the group ID of this simulation job status.
	*
	* @return the group ID of this simulation job status
	*/
	@Override
	public long getGroupId() {
		return _simulationJobStatus.getGroupId();
	}

	/**
	* Sets the group ID of this simulation job status.
	*
	* @param groupId the group ID of this simulation job status
	*/
	@Override
	public void setGroupId(long groupId) {
		_simulationJobStatus.setGroupId(groupId);
	}

	/**
	* Returns the simulation uuid of this simulation job status.
	*
	* @return the simulation uuid of this simulation job status
	*/
	@Override
	public java.lang.String getSimulationUuid() {
		return _simulationJobStatus.getSimulationUuid();
	}

	/**
	* Sets the simulation uuid of this simulation job status.
	*
	* @param simulationUuid the simulation uuid of this simulation job status
	*/
	@Override
	public void setSimulationUuid(java.lang.String simulationUuid) {
		_simulationJobStatus.setSimulationUuid(simulationUuid);
	}

	/**
	* Returns the job uuid of this simulation job status.
	*
	* @return the job uuid of this simulation job status
	*/
	@Override
	public java.lang.String getJobUuid() {
		return _simulationJobStatus.getJobUuid();
	}

	/**
	* Sets the job uuid of this simulation job status.
	*
	* @param jobUuid the job uuid of this simulation job status
	*/
	@Override
	public void setJobUuid(java.lang.String jobUuid) {
		_simulationJobStatus.setJobUuid(jobUuid);
	}

	/**
	* Returns the job status of this simulation job status.
	*
	* @return the job status of this simulation job status
	*/
	@Override
	public long getJobStatus() {
		return _simulationJobStatus.getJobStatus();
	}

	/**
	* Sets the job status of this simulation job status.
	*
	* @param jobStatus the job status of this simulation job status
	*/
	@Override
	public void setJobStatus(long jobStatus) {
		_simulationJobStatus.setJobStatus(jobStatus);
	}

	/**
	* Returns the job start dt of this simulation job status.
	*
	* @return the job start dt of this simulation job status
	*/
	@Override
	public java.util.Date getJobStartDt() {
		return _simulationJobStatus.getJobStartDt();
	}

	/**
	* Sets the job start dt of this simulation job status.
	*
	* @param jobStartDt the job start dt of this simulation job status
	*/
	@Override
	public void setJobStartDt(java.util.Date jobStartDt) {
		_simulationJobStatus.setJobStartDt(jobStartDt);
	}

	/**
	* Returns the job end dt of this simulation job status.
	*
	* @return the job end dt of this simulation job status
	*/
	@Override
	public java.util.Date getJobEndDt() {
		return _simulationJobStatus.getJobEndDt();
	}

	/**
	* Sets the job end dt of this simulation job status.
	*
	* @param jobEndDt the job end dt of this simulation job status
	*/
	@Override
	public void setJobEndDt(java.util.Date jobEndDt) {
		_simulationJobStatus.setJobEndDt(jobEndDt);
	}

	/**
	* Returns the write dt of this simulation job status.
	*
	* @return the write dt of this simulation job status
	*/
	@Override
	public java.util.Date getWriteDt() {
		return _simulationJobStatus.getWriteDt();
	}

	/**
	* Sets the write dt of this simulation job status.
	*
	* @param writeDt the write dt of this simulation job status
	*/
	@Override
	public void setWriteDt(java.util.Date writeDt) {
		_simulationJobStatus.setWriteDt(writeDt);
	}

	@Override
	public boolean isNew() {
		return _simulationJobStatus.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_simulationJobStatus.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _simulationJobStatus.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_simulationJobStatus.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _simulationJobStatus.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _simulationJobStatus.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_simulationJobStatus.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _simulationJobStatus.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_simulationJobStatus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_simulationJobStatus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_simulationJobStatus.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SimulationJobStatusWrapper((SimulationJobStatus)_simulationJobStatus.clone());
	}

	@Override
	public int compareTo(
		org.kisti.edison.bestsimulation.model.SimulationJobStatus simulationJobStatus) {
		return _simulationJobStatus.compareTo(simulationJobStatus);
	}

	@Override
	public int hashCode() {
		return _simulationJobStatus.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.kisti.edison.bestsimulation.model.SimulationJobStatus> toCacheModel() {
		return _simulationJobStatus.toCacheModel();
	}

	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus toEscapedModel() {
		return new SimulationJobStatusWrapper(_simulationJobStatus.toEscapedModel());
	}

	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus toUnescapedModel() {
		return new SimulationJobStatusWrapper(_simulationJobStatus.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _simulationJobStatus.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _simulationJobStatus.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_simulationJobStatus.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SimulationJobStatusWrapper)) {
			return false;
		}

		SimulationJobStatusWrapper simulationJobStatusWrapper = (SimulationJobStatusWrapper)obj;

		if (Validator.equals(_simulationJobStatus,
					simulationJobStatusWrapper._simulationJobStatus)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SimulationJobStatus getWrappedSimulationJobStatus() {
		return _simulationJobStatus;
	}

	@Override
	public SimulationJobStatus getWrappedModel() {
		return _simulationJobStatus;
	}

	@Override
	public void resetOriginalValues() {
		_simulationJobStatus.resetOriginalValues();
	}

	private SimulationJobStatus _simulationJobStatus;
}