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
 * Provides a wrapper for {@link SimulationJobStatusLocalService}.
 *
 * @author EDISON
 * @see SimulationJobStatusLocalService
 * @generated
 */
public class SimulationJobStatusLocalServiceWrapper
	implements SimulationJobStatusLocalService,
		ServiceWrapper<SimulationJobStatusLocalService> {
	public SimulationJobStatusLocalServiceWrapper(
		SimulationJobStatusLocalService simulationJobStatusLocalService) {
		_simulationJobStatusLocalService = simulationJobStatusLocalService;
	}

	/**
	* Adds the simulation job status to the database. Also notifies the appropriate model listeners.
	*
	* @param simulationJobStatus the simulation job status
	* @return the simulation job status that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus addSimulationJobStatus(
		org.kisti.edison.bestsimulation.model.SimulationJobStatus simulationJobStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.addSimulationJobStatus(simulationJobStatus);
	}

	/**
	* Creates a new simulation job status with the primary key. Does not add the simulation job status to the database.
	*
	* @param simulationJobStatusPK the primary key for the new simulation job status
	* @return the new simulation job status
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus createSimulationJobStatus(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK simulationJobStatusPK) {
		return _simulationJobStatusLocalService.createSimulationJobStatus(simulationJobStatusPK);
	}

	/**
	* Deletes the simulation job status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param simulationJobStatusPK the primary key of the simulation job status
	* @return the simulation job status that was removed
	* @throws PortalException if a simulation job status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus deleteSimulationJobStatus(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK simulationJobStatusPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.deleteSimulationJobStatus(simulationJobStatusPK);
	}

	/**
	* Deletes the simulation job status from the database. Also notifies the appropriate model listeners.
	*
	* @param simulationJobStatus the simulation job status
	* @return the simulation job status that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus deleteSimulationJobStatus(
		org.kisti.edison.bestsimulation.model.SimulationJobStatus simulationJobStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.deleteSimulationJobStatus(simulationJobStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _simulationJobStatusLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus fetchSimulationJobStatus(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK simulationJobStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.fetchSimulationJobStatus(simulationJobStatusPK);
	}

	/**
	* Returns the simulation job status with the primary key.
	*
	* @param simulationJobStatusPK the primary key of the simulation job status
	* @return the simulation job status
	* @throws PortalException if a simulation job status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus getSimulationJobStatus(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK simulationJobStatusPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.getSimulationJobStatus(simulationJobStatusPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the simulation job statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of simulation job statuses
	* @param end the upper bound of the range of simulation job statuses (not inclusive)
	* @return the range of simulation job statuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.bestsimulation.model.SimulationJobStatus> getSimulationJobStatuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.getSimulationJobStatuses(start,
			end);
	}

	/**
	* Returns the number of simulation job statuses.
	*
	* @return the number of simulation job statuses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSimulationJobStatusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.getSimulationJobStatusesCount();
	}

	/**
	* Updates the simulation job status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param simulationJobStatus the simulation job status
	* @return the simulation job status that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus updateSimulationJobStatus(
		org.kisti.edison.bestsimulation.model.SimulationJobStatus simulationJobStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _simulationJobStatusLocalService.updateSimulationJobStatus(simulationJobStatus);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _simulationJobStatusLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_simulationJobStatusLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _simulationJobStatusLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus getSimulationJobStatusBySimulationUuidASMonitoring(
		long jobSeqNo, long groupId, java.lang.String simulationUuid,
		java.lang.String jobUuid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException {
		return _simulationJobStatusLocalService.getSimulationJobStatusBySimulationUuidASMonitoring(jobSeqNo,
			groupId, simulationUuid, jobUuid);
	}

	@Override
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus getSimulationJobStatusByJobCreate(
		long groupId, java.lang.String simulationUuid, java.lang.String jobUuid)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException {
		return _simulationJobStatusLocalService.getSimulationJobStatusByJobCreate(groupId,
			simulationUuid, jobUuid);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SimulationJobStatusLocalService getWrappedSimulationJobStatusLocalService() {
		return _simulationJobStatusLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSimulationJobStatusLocalService(
		SimulationJobStatusLocalService simulationJobStatusLocalService) {
		_simulationJobStatusLocalService = simulationJobStatusLocalService;
	}

	@Override
	public SimulationJobStatusLocalService getWrappedService() {
		return _simulationJobStatusLocalService;
	}

	@Override
	public void setWrappedService(
		SimulationJobStatusLocalService simulationJobStatusLocalService) {
		_simulationJobStatusLocalService = simulationJobStatusLocalService;
	}

	private SimulationJobStatusLocalService _simulationJobStatusLocalService;
}