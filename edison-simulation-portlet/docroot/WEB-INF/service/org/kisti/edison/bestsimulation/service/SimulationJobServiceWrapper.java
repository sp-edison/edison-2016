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

package org.kisti.edison.bestsimulation.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SimulationJobService}.
 *
 * @author EDISON
 * @see SimulationJobService
 * @generated
 */
public class SimulationJobServiceWrapper implements SimulationJobService,
	ServiceWrapper<SimulationJobService> {
	public SimulationJobServiceWrapper(
		SimulationJobService simulationJobService) {
		_simulationJobService = simulationJobService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _simulationJobService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_simulationJobService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _simulationJobService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public boolean updateSimulationJob(long gid,
		java.lang.String simulationUuid, long jobSeqNo,
		java.lang.String jobUuid, java.lang.String jobStatus,
		java.lang.String jobStartDt, java.lang.String jobEndDt) {
		return _simulationJobService.updateSimulationJob(gid, simulationUuid,
			jobSeqNo, jobUuid, jobStatus, jobStartDt, jobEndDt);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SimulationJobService getWrappedSimulationJobService() {
		return _simulationJobService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSimulationJobService(
		SimulationJobService simulationJobService) {
		_simulationJobService = simulationJobService;
	}

	@Override
	public SimulationJobService getWrappedService() {
		return _simulationJobService;
	}

	@Override
	public void setWrappedService(SimulationJobService simulationJobService) {
		_simulationJobService = simulationJobService;
	}

	private SimulationJobService _simulationJobService;
}