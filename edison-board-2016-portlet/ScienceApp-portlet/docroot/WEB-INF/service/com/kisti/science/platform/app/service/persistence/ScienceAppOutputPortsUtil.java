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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the science app output ports service. This utility wraps {@link ScienceAppOutputPortsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppOutputPortsPersistence
 * @see ScienceAppOutputPortsPersistenceImpl
 * @generated
 */
public class ScienceAppOutputPortsUtil {
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
	public static void clearCache(ScienceAppOutputPorts scienceAppOutputPorts) {
		getPersistence().clearCache(scienceAppOutputPorts);
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
	public static List<ScienceAppOutputPorts> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ScienceAppOutputPorts> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ScienceAppOutputPorts> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ScienceAppOutputPorts update(
		ScienceAppOutputPorts scienceAppOutputPorts) throws SystemException {
		return getPersistence().update(scienceAppOutputPorts);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ScienceAppOutputPorts update(
		ScienceAppOutputPorts scienceAppOutputPorts,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(scienceAppOutputPorts, serviceContext);
	}

	/**
	* Caches the science app output ports in the entity cache if it is enabled.
	*
	* @param scienceAppOutputPorts the science app output ports
	*/
	public static void cacheResult(
		com.kisti.science.platform.app.model.ScienceAppOutputPorts scienceAppOutputPorts) {
		getPersistence().cacheResult(scienceAppOutputPorts);
	}

	/**
	* Caches the science app output portses in the entity cache if it is enabled.
	*
	* @param scienceAppOutputPortses the science app output portses
	*/
	public static void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.ScienceAppOutputPorts> scienceAppOutputPortses) {
		getPersistence().cacheResult(scienceAppOutputPortses);
	}

	/**
	* Creates a new science app output ports with the primary key. Does not add the science app output ports to the database.
	*
	* @param scienceAppId the primary key for the new science app output ports
	* @return the new science app output ports
	*/
	public static com.kisti.science.platform.app.model.ScienceAppOutputPorts create(
		long scienceAppId) {
		return getPersistence().create(scienceAppId);
	}

	/**
	* Removes the science app output ports with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppId the primary key of the science app output ports
	* @return the science app output ports that was removed
	* @throws com.kisti.science.platform.app.NoSuchOutputPortsException if a science app output ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppOutputPorts remove(
		long scienceAppId)
		throws com.kisti.science.platform.app.NoSuchOutputPortsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(scienceAppId);
	}

	public static com.kisti.science.platform.app.model.ScienceAppOutputPorts updateImpl(
		com.kisti.science.platform.app.model.ScienceAppOutputPorts scienceAppOutputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(scienceAppOutputPorts);
	}

	/**
	* Returns the science app output ports with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchOutputPortsException} if it could not be found.
	*
	* @param scienceAppId the primary key of the science app output ports
	* @return the science app output ports
	* @throws com.kisti.science.platform.app.NoSuchOutputPortsException if a science app output ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppOutputPorts findByPrimaryKey(
		long scienceAppId)
		throws com.kisti.science.platform.app.NoSuchOutputPortsException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(scienceAppId);
	}

	/**
	* Returns the science app output ports with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scienceAppId the primary key of the science app output ports
	* @return the science app output ports, or <code>null</code> if a science app output ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppOutputPorts fetchByPrimaryKey(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(scienceAppId);
	}

	/**
	* Returns all the science app output portses.
	*
	* @return the science app output portses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppOutputPorts> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppOutputPorts> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppOutputPorts> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the science app output portses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of science app output portses.
	*
	* @return the number of science app output portses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ScienceAppOutputPortsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ScienceAppOutputPortsPersistence)PortletBeanLocatorUtil.locate(com.kisti.science.platform.app.service.ClpSerializer.getServletContextName(),
					ScienceAppOutputPortsPersistence.class.getName());

			ReferenceRegistry.registerReference(ScienceAppOutputPortsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ScienceAppOutputPortsPersistence persistence) {
	}

	private static ScienceAppOutputPortsPersistence _persistence;
}