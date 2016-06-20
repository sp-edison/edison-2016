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

package org.kisti.edison.project.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.kisti.edison.project.model.HistoryAppSimulation;

/**
 * The persistence interface for the history app simulation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see HistoryAppSimulationPersistenceImpl
 * @see HistoryAppSimulationUtil
 * @generated
 */
public interface HistoryAppSimulationPersistence extends BasePersistence<HistoryAppSimulation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HistoryAppSimulationUtil} to access the history app simulation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the history app simulation in the entity cache if it is enabled.
	*
	* @param historyAppSimulation the history app simulation
	*/
	public void cacheResult(
		org.kisti.edison.project.model.HistoryAppSimulation historyAppSimulation);

	/**
	* Caches the history app simulations in the entity cache if it is enabled.
	*
	* @param historyAppSimulations the history app simulations
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.project.model.HistoryAppSimulation> historyAppSimulations);

	/**
	* Creates a new history app simulation with the primary key. Does not add the history app simulation to the database.
	*
	* @param historyAppSimulationPK the primary key for the new history app simulation
	* @return the new history app simulation
	*/
	public org.kisti.edison.project.model.HistoryAppSimulation create(
		org.kisti.edison.project.service.persistence.HistoryAppSimulationPK historyAppSimulationPK);

	/**
	* Removes the history app simulation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param historyAppSimulationPK the primary key of the history app simulation
	* @return the history app simulation that was removed
	* @throws org.kisti.edison.project.NoSuchHistoryAppSimulationException if a history app simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.project.model.HistoryAppSimulation remove(
		org.kisti.edison.project.service.persistence.HistoryAppSimulationPK historyAppSimulationPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.project.NoSuchHistoryAppSimulationException;

	public org.kisti.edison.project.model.HistoryAppSimulation updateImpl(
		org.kisti.edison.project.model.HistoryAppSimulation historyAppSimulation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the history app simulation with the primary key or throws a {@link org.kisti.edison.project.NoSuchHistoryAppSimulationException} if it could not be found.
	*
	* @param historyAppSimulationPK the primary key of the history app simulation
	* @return the history app simulation
	* @throws org.kisti.edison.project.NoSuchHistoryAppSimulationException if a history app simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.project.model.HistoryAppSimulation findByPrimaryKey(
		org.kisti.edison.project.service.persistence.HistoryAppSimulationPK historyAppSimulationPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.project.NoSuchHistoryAppSimulationException;

	/**
	* Returns the history app simulation with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param historyAppSimulationPK the primary key of the history app simulation
	* @return the history app simulation, or <code>null</code> if a history app simulation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.project.model.HistoryAppSimulation fetchByPrimaryKey(
		org.kisti.edison.project.service.persistence.HistoryAppSimulationPK historyAppSimulationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the history app simulations.
	*
	* @return the history app simulations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.project.model.HistoryAppSimulation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the history app simulations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.project.model.impl.HistoryAppSimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of history app simulations
	* @param end the upper bound of the range of history app simulations (not inclusive)
	* @return the range of history app simulations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.project.model.HistoryAppSimulation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the history app simulations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.project.model.impl.HistoryAppSimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of history app simulations
	* @param end the upper bound of the range of history app simulations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of history app simulations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.project.model.HistoryAppSimulation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the history app simulations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of history app simulations.
	*
	* @return the number of history app simulations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}