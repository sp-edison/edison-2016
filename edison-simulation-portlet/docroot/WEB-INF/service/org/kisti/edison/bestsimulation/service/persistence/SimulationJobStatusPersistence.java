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

package org.kisti.edison.bestsimulation.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.kisti.edison.bestsimulation.model.SimulationJobStatus;

/**
 * The persistence interface for the simulation job status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see SimulationJobStatusPersistenceImpl
 * @see SimulationJobStatusUtil
 * @generated
 */
public interface SimulationJobStatusPersistence extends BasePersistence<SimulationJobStatus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SimulationJobStatusUtil} to access the simulation job status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the simulation job statuses where groupId = &#63; and simulationUuid = &#63; and jobUuid = &#63;.
	*
	* @param groupId the group ID
	* @param simulationUuid the simulation uuid
	* @param jobUuid the job uuid
	* @return the matching simulation job statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.bestsimulation.model.SimulationJobStatus> findBysimulationUuid(
		long groupId, java.lang.String simulationUuid, java.lang.String jobUuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the simulation job statuses where groupId = &#63; and simulationUuid = &#63; and jobUuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param simulationUuid the simulation uuid
	* @param jobUuid the job uuid
	* @param start the lower bound of the range of simulation job statuses
	* @param end the upper bound of the range of simulation job statuses (not inclusive)
	* @return the range of matching simulation job statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.bestsimulation.model.SimulationJobStatus> findBysimulationUuid(
		long groupId, java.lang.String simulationUuid,
		java.lang.String jobUuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the simulation job statuses where groupId = &#63; and simulationUuid = &#63; and jobUuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param simulationUuid the simulation uuid
	* @param jobUuid the job uuid
	* @param start the lower bound of the range of simulation job statuses
	* @param end the upper bound of the range of simulation job statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching simulation job statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.bestsimulation.model.SimulationJobStatus> findBysimulationUuid(
		long groupId, java.lang.String simulationUuid,
		java.lang.String jobUuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first simulation job status in the ordered set where groupId = &#63; and simulationUuid = &#63; and jobUuid = &#63;.
	*
	* @param groupId the group ID
	* @param simulationUuid the simulation uuid
	* @param jobUuid the job uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching simulation job status
	* @throws org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException if a matching simulation job status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus findBysimulationUuid_First(
		long groupId, java.lang.String simulationUuid,
		java.lang.String jobUuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException;

	/**
	* Returns the first simulation job status in the ordered set where groupId = &#63; and simulationUuid = &#63; and jobUuid = &#63;.
	*
	* @param groupId the group ID
	* @param simulationUuid the simulation uuid
	* @param jobUuid the job uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching simulation job status, or <code>null</code> if a matching simulation job status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus fetchBysimulationUuid_First(
		long groupId, java.lang.String simulationUuid,
		java.lang.String jobUuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last simulation job status in the ordered set where groupId = &#63; and simulationUuid = &#63; and jobUuid = &#63;.
	*
	* @param groupId the group ID
	* @param simulationUuid the simulation uuid
	* @param jobUuid the job uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching simulation job status
	* @throws org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException if a matching simulation job status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus findBysimulationUuid_Last(
		long groupId, java.lang.String simulationUuid,
		java.lang.String jobUuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException;

	/**
	* Returns the last simulation job status in the ordered set where groupId = &#63; and simulationUuid = &#63; and jobUuid = &#63;.
	*
	* @param groupId the group ID
	* @param simulationUuid the simulation uuid
	* @param jobUuid the job uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching simulation job status, or <code>null</code> if a matching simulation job status could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus fetchBysimulationUuid_Last(
		long groupId, java.lang.String simulationUuid,
		java.lang.String jobUuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the simulation job statuses before and after the current simulation job status in the ordered set where groupId = &#63; and simulationUuid = &#63; and jobUuid = &#63;.
	*
	* @param simulationJobStatusPK the primary key of the current simulation job status
	* @param groupId the group ID
	* @param simulationUuid the simulation uuid
	* @param jobUuid the job uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next simulation job status
	* @throws org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException if a simulation job status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus[] findBysimulationUuid_PrevAndNext(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK simulationJobStatusPK,
		long groupId, java.lang.String simulationUuid,
		java.lang.String jobUuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException;

	/**
	* Removes all the simulation job statuses where groupId = &#63; and simulationUuid = &#63; and jobUuid = &#63; from the database.
	*
	* @param groupId the group ID
	* @param simulationUuid the simulation uuid
	* @param jobUuid the job uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeBysimulationUuid(long groupId,
		java.lang.String simulationUuid, java.lang.String jobUuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of simulation job statuses where groupId = &#63; and simulationUuid = &#63; and jobUuid = &#63;.
	*
	* @param groupId the group ID
	* @param simulationUuid the simulation uuid
	* @param jobUuid the job uuid
	* @return the number of matching simulation job statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countBysimulationUuid(long groupId,
		java.lang.String simulationUuid, java.lang.String jobUuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the simulation job status in the entity cache if it is enabled.
	*
	* @param simulationJobStatus the simulation job status
	*/
	public void cacheResult(
		org.kisti.edison.bestsimulation.model.SimulationJobStatus simulationJobStatus);

	/**
	* Caches the simulation job statuses in the entity cache if it is enabled.
	*
	* @param simulationJobStatuses the simulation job statuses
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.bestsimulation.model.SimulationJobStatus> simulationJobStatuses);

	/**
	* Creates a new simulation job status with the primary key. Does not add the simulation job status to the database.
	*
	* @param simulationJobStatusPK the primary key for the new simulation job status
	* @return the new simulation job status
	*/
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus create(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK simulationJobStatusPK);

	/**
	* Removes the simulation job status with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param simulationJobStatusPK the primary key of the simulation job status
	* @return the simulation job status that was removed
	* @throws org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException if a simulation job status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus remove(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK simulationJobStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException;

	public org.kisti.edison.bestsimulation.model.SimulationJobStatus updateImpl(
		org.kisti.edison.bestsimulation.model.SimulationJobStatus simulationJobStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the simulation job status with the primary key or throws a {@link org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException} if it could not be found.
	*
	* @param simulationJobStatusPK the primary key of the simulation job status
	* @return the simulation job status
	* @throws org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException if a simulation job status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus findByPrimaryKey(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK simulationJobStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.bestsimulation.NoSuchSimulationJobStatusException;

	/**
	* Returns the simulation job status with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param simulationJobStatusPK the primary key of the simulation job status
	* @return the simulation job status, or <code>null</code> if a simulation job status with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.bestsimulation.model.SimulationJobStatus fetchByPrimaryKey(
		org.kisti.edison.bestsimulation.service.persistence.SimulationJobStatusPK simulationJobStatusPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the simulation job statuses.
	*
	* @return the simulation job statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.bestsimulation.model.SimulationJobStatus> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.bestsimulation.model.SimulationJobStatus> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the simulation job statuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of simulation job statuses
	* @param end the upper bound of the range of simulation job statuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of simulation job statuses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.bestsimulation.model.SimulationJobStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the simulation job statuses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of simulation job statuses.
	*
	* @return the number of simulation job statuses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}