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

import com.kisti.science.platform.app.model.ScienceAppOutputPorts;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the science app output ports service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppOutputPortsPersistenceImpl
 * @see ScienceAppOutputPortsUtil
 * @generated
 */
public interface ScienceAppOutputPortsPersistence extends BasePersistence<ScienceAppOutputPorts> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScienceAppOutputPortsUtil} to access the science app output ports persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the science app output ports in the entity cache if it is enabled.
	*
	* @param scienceAppOutputPorts the science app output ports
	*/
	public void cacheResult(
		com.kisti.science.platform.app.model.ScienceAppOutputPorts scienceAppOutputPorts);

	/**
	* Caches the science app output portses in the entity cache if it is enabled.
	*
	* @param scienceAppOutputPortses the science app output portses
	*/
	public void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.ScienceAppOutputPorts> scienceAppOutputPortses);

	/**
	* Creates a new science app output ports with the primary key. Does not add the science app output ports to the database.
	*
	* @param scienceAppId the primary key for the new science app output ports
	* @return the new science app output ports
	*/
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts create(
		long scienceAppId);

	/**
	* Removes the science app output ports with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppId the primary key of the science app output ports
	* @return the science app output ports that was removed
	* @throws com.kisti.science.platform.app.NoSuchOutputPortsException if a science app output ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts remove(
		long scienceAppId)
		throws com.kisti.science.platform.app.NoSuchOutputPortsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kisti.science.platform.app.model.ScienceAppOutputPorts updateImpl(
		com.kisti.science.platform.app.model.ScienceAppOutputPorts scienceAppOutputPorts)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app output ports with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchOutputPortsException} if it could not be found.
	*
	* @param scienceAppId the primary key of the science app output ports
	* @return the science app output ports
	* @throws com.kisti.science.platform.app.NoSuchOutputPortsException if a science app output ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts findByPrimaryKey(
		long scienceAppId)
		throws com.kisti.science.platform.app.NoSuchOutputPortsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app output ports with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scienceAppId the primary key of the science app output ports
	* @return the science app output ports, or <code>null</code> if a science app output ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts fetchByPrimaryKey(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science app output portses.
	*
	* @return the science app output portses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppOutputPorts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the science app output portses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppOutputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app output portses
	* @param end the upper bound of the range of science app output portses (not inclusive)
	* @return the range of science app output portses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppOutputPorts> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the science app output portses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppOutputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app output portses
	* @param end the upper bound of the range of science app output portses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of science app output portses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppOutputPorts> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the science app output portses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science app output portses.
	*
	* @return the number of science app output portses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}