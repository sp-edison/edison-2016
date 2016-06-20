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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SimulationJobStatus. This utility wraps
 * {@link org.kisti.edison.bestsimulation.service.impl.SimulationJobStatusLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see SimulationJobStatusLocalService
 * @see org.kisti.edison.bestsimulation.service.base.SimulationJobStatusLocalServiceBaseImpl
 * @see org.kisti.edison.bestsimulation.service.impl.SimulationJobStatusLocalServiceImpl
 * @generated
 */
public class SimulationJobStatusLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.bestsimulation.service.impl.SimulationJobStatusLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the simulation job status to the database. Also notifies the appropriate model listeners.
	*
	* @param simulationJobStatus the simulation job status
	* @return the simulation job status that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.bestsimulation.model.SimulationJobStatus addSimulationJobStatus(
		org.kisti.edison.bestsimulation.model.SimulationJobStatus simulationJobStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSimulationJobStatus(simulationJobStatus);
	}

	/**
	* Creates a new simulation job status with the primary key. Does not add the simulation job status to the database.
	*
	* @param simulationJobStatusPK the primary key for the new simulation job status
	* @return the new simulation job status
	*/
	public static org.kisti.edison.bestsimulation.model.SimulationJobStatus createSimulationJobStatus(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK simulationJobStatusPK) {
		return getService().createSimulationJobStatus(simulationJobStatusPK);
	}

	/**
	* Deletes the simulation job status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param simulationJobStatusPK the primary key of the simulation job status
	* @return the simulation job status that was removed
	* @throws PortalException if a simulation job status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.bestsimulation.model.SimulationJobStatus deleteSimulationJobStatus(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK simulationJobStatusPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSimulationJobStatus(simulationJobStatusPK);
	}

	/**
	* Deletes the simulation job status from the database. Also notifies the appropriate model listeners.
	*
	* @param simulationJobStatus the simulation job status
	* @return the simulation job status that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.bestsimulation.model.SimulationJobStatus deleteSimulationJobStatus(
		org.kisti.edison.bestsimulation.model.SimulationJobStatus simulationJobStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSimulationJobStatus(simulationJobStatus);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.kisti.edison.bestsimulation.model.SimulationJobStatus fetchSimulationJobStatus(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK simulationJobStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSimulationJobStatus(simulationJobStatusPK);
	}

	/**
	* Returns the simulation job status with the primary key.
	*
	* @param simulationJobStatusPK the primary key of the simulation job status
	* @return the simulation job status
	* @throws PortalException if a simulation job status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.bestsimulation.model.SimulationJobStatus getSimulationJobStatus(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK simulationJobStatusPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSimulationJobStatus(simulationJobStatusPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.kisti.edison.bestsimulation.model.SimulationJobStatus> getSimulationJobStatuses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSimulationJobStatuses(start, end);
	}

	/**
	* Returns the number of simulation job statuses.
	*
	* @return the number of simulation job statuses
	* @throws SystemException if a system exception occurred
	*/
	public static int getSimulationJobStatusesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSimulationJobStatusesCount();
	}

	/**
	* Updates the simulation job status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param simulationJobStatus the simulation job status
	* @return the simulation job status that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.bestsimulation.model.SimulationJobStatus updateSimulationJobStatus(
		org.kisti.edison.bestsimulation.model.SimulationJobStatus simulationJobStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSimulationJobStatus(simulationJobStatus);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static org.kisti.edison.bestsimulation.model.SimulationJobStatus getSimulationJobStatusBySimulationUuidASMonitoring(
		long jobSeqNo, long groupId, java.lang.String simulationUuid,
		java.lang.String jobUuid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException {
		return getService()
				   .getSimulationJobStatusBySimulationUuidASMonitoring(jobSeqNo,
			groupId, simulationUuid, jobUuid);
	}

	public static org.kisti.edison.bestsimulation.model.SimulationJobStatus getSimulationJobStatusByJobCreate(
		long groupId, java.lang.String simulationUuid, java.lang.String jobUuid)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException {
		return getService()
				   .getSimulationJobStatusByJobCreate(groupId, simulationUuid,
			jobUuid);
	}

	public static void clearService() {
		_service = null;
	}

	public static SimulationJobStatusLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SimulationJobStatusLocalService.class.getName());

			if (invokableLocalService instanceof SimulationJobStatusLocalService) {
				_service = (SimulationJobStatusLocalService)invokableLocalService;
			}
			else {
				_service = new SimulationJobStatusLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SimulationJobStatusLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SimulationJobStatusLocalService service) {
	}

	private static SimulationJobStatusLocalService _service;
}