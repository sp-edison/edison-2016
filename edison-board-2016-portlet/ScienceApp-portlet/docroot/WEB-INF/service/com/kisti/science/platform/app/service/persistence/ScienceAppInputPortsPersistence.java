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

package com.kisti.science.platform.app.service.persistence;

import com.kisti.science.platform.app.model.ScienceAppInputPorts;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the science app input ports service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppInputPortsPersistenceImpl
 * @see ScienceAppInputPortsUtil
 * @generated
 */
public interface ScienceAppInputPortsPersistence extends BasePersistence<ScienceAppInputPorts> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScienceAppInputPortsUtil} to access the science app input ports persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the science app input ports in the entity cache if it is enabled.
	*
	* @param scienceAppInputPorts the science app input ports
	*/
	public void cacheResult(
		com.kisti.science.platform.app.model.ScienceAppInputPorts scienceAppInputPorts);

	/**
	* Caches the science app input portses in the entity cache if it is enabled.
	*
	* @param scienceAppInputPortses the science app input portses
	*/
	public void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.ScienceAppInputPorts> scienceAppInputPortses);

	/**
	* Creates a new science app input ports with the primary key. Does not add the science app input ports to the database.
	*
	* @param scienceAppId the primary key for the new science app input ports
	* @return the new science app input ports
	*/
	public com.kisti.science.platform.app.model.ScienceAppInputPorts create(
		long scienceAppId);

	/**
	* Removes the science app input ports with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppId the primary key of the science app input ports
	* @return the science app input ports that was removed
	* @throws com.kisti.science.platform.app.NoSuchInputPortsException if a science app input ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppInputPorts remove(
		long scienceAppId)
		throws com.kisti.science.platform.app.NoSuchInputPortsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kisti.science.platform.app.model.ScienceAppInputPorts updateImpl(
		com.kisti.science.platform.app.model.ScienceAppInputPorts scienceAppInputPorts)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app input ports with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchInputPortsException} if it could not be found.
	*
	* @param scienceAppId the primary key of the science app input ports
	* @return the science app input ports
	* @throws com.kisti.science.platform.app.NoSuchInputPortsException if a science app input ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppInputPorts findByPrimaryKey(
		long scienceAppId)
		throws com.kisti.science.platform.app.NoSuchInputPortsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app input ports with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scienceAppId the primary key of the science app input ports
	* @return the science app input ports, or <code>null</code> if a science app input ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppInputPorts fetchByPrimaryKey(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science app input portses.
	*
	* @return the science app input portses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppInputPorts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the science app input portses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppInputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app input portses
	* @param end the upper bound of the range of science app input portses (not inclusive)
	* @return the range of science app input portses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppInputPorts> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the science app input portses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppInputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app input portses
	* @param end the upper bound of the range of science app input portses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of science app input portses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppInputPorts> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the science app input portses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science app input portses.
	*
	* @return the number of science app input portses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}