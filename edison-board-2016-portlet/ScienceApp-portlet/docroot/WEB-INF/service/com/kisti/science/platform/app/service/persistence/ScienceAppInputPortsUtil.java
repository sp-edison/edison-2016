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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the science app input ports service. This utility wraps {@link ScienceAppInputPortsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppInputPortsPersistence
 * @see ScienceAppInputPortsPersistenceImpl
 * @generated
 */
public class ScienceAppInputPortsUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ScienceAppInputPorts scienceAppInputPorts) {
		getPersistence().clearCache(scienceAppInputPorts);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ScienceAppInputPorts> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ScienceAppInputPorts> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ScienceAppInputPorts> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ScienceAppInputPorts update(
		ScienceAppInputPorts scienceAppInputPorts) throws SystemException {
		return getPersistence().update(scienceAppInputPorts);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ScienceAppInputPorts update(
		ScienceAppInputPorts scienceAppInputPorts, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(scienceAppInputPorts, serviceContext);
	}

	/**
	* Caches the science app input ports in the entity cache if it is enabled.
	*
	* @param scienceAppInputPorts the science app input ports
	*/
	public static void cacheResult(
		com.kisti.science.platform.app.model.ScienceAppInputPorts scienceAppInputPorts) {
		getPersistence().cacheResult(scienceAppInputPorts);
	}

	/**
	* Caches the science app input portses in the entity cache if it is enabled.
	*
	* @param scienceAppInputPortses the science app input portses
	*/
	public static void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.ScienceAppInputPorts> scienceAppInputPortses) {
		getPersistence().cacheResult(scienceAppInputPortses);
	}

	/**
	* Creates a new science app input ports with the primary key. Does not add the science app input ports to the database.
	*
	* @param scienceAppId the primary key for the new science app input ports
	* @return the new science app input ports
	*/
	public static com.kisti.science.platform.app.model.ScienceAppInputPorts create(
		long scienceAppId) {
		return getPersistence().create(scienceAppId);
	}

	/**
	* Removes the science app input ports with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppId the primary key of the science app input ports
	* @return the science app input ports that was removed
	* @throws com.kisti.science.platform.app.NoSuchInputPortsException if a science app input ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppInputPorts remove(
		long scienceAppId)
		throws com.kisti.science.platform.app.NoSuchInputPortsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(scienceAppId);
	}

	public static com.kisti.science.platform.app.model.ScienceAppInputPorts updateImpl(
		com.kisti.science.platform.app.model.ScienceAppInputPorts scienceAppInputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(scienceAppInputPorts);
	}

	/**
	* Returns the science app input ports with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchInputPortsException} if it could not be found.
	*
	* @param scienceAppId the primary key of the science app input ports
	* @return the science app input ports
	* @throws com.kisti.science.platform.app.NoSuchInputPortsException if a science app input ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppInputPorts findByPrimaryKey(
		long scienceAppId)
		throws com.kisti.science.platform.app.NoSuchInputPortsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(scienceAppId);
	}

	/**
	* Returns the science app input ports with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scienceAppId the primary key of the science app input ports
	* @return the science app input ports, or <code>null</code> if a science app input ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppInputPorts fetchByPrimaryKey(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(scienceAppId);
	}

	/**
	* Returns all the science app input portses.
	*
	* @return the science app input portses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppInputPorts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppInputPorts> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppInputPorts> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the science app input portses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of science app input portses.
	*
	* @return the number of science app input portses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ScienceAppInputPortsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ScienceAppInputPortsPersistence)PortletBeanLocatorUtil.locate(com.kisti.science.platform.app.service.ClpSerializer.getServletContextName(),
					ScienceAppInputPortsPersistence.class.getName());

			ReferenceRegistry.registerReference(ScienceAppInputPortsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ScienceAppInputPortsPersistence persistence) {
	}

	private static ScienceAppInputPortsPersistence _persistence;
}