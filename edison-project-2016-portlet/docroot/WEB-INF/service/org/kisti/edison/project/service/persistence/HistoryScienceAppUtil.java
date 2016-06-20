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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.kisti.edison.project.model.HistoryScienceApp;

import java.util.List;

/**
 * The persistence utility for the history science app service. This utility wraps {@link HistoryScienceAppPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see HistoryScienceAppPersistence
 * @see HistoryScienceAppPersistenceImpl
 * @generated
 */
public class HistoryScienceAppUtil {
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
	public static void clearCache(HistoryScienceApp historyScienceApp) {
		getPersistence().clearCache(historyScienceApp);
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
	public static List<HistoryScienceApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HistoryScienceApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HistoryScienceApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static HistoryScienceApp update(HistoryScienceApp historyScienceApp)
		throws SystemException {
		return getPersistence().update(historyScienceApp);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static HistoryScienceApp update(
		HistoryScienceApp historyScienceApp, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(historyScienceApp, serviceContext);
	}

	/**
	* Caches the history science app in the entity cache if it is enabled.
	*
	* @param historyScienceApp the history science app
	*/
	public static void cacheResult(
		org.kisti.edison.project.model.HistoryScienceApp historyScienceApp) {
		getPersistence().cacheResult(historyScienceApp);
	}

	/**
	* Caches the history science apps in the entity cache if it is enabled.
	*
	* @param historyScienceApps the history science apps
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.project.model.HistoryScienceApp> historyScienceApps) {
		getPersistence().cacheResult(historyScienceApps);
	}

	/**
	* Creates a new history science app with the primary key. Does not add the history science app to the database.
	*
	* @param historyScienceAppPK the primary key for the new history science app
	* @return the new history science app
	*/
	public static org.kisti.edison.project.model.HistoryScienceApp create(
		org.kisti.edison.project.service.persistence.HistoryScienceAppPK historyScienceAppPK) {
		return getPersistence().create(historyScienceAppPK);
	}

	/**
	* Removes the history science app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param historyScienceAppPK the primary key of the history science app
	* @return the history science app that was removed
	* @throws org.kisti.edison.project.NoSuchHistoryScienceAppException if a history science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.project.model.HistoryScienceApp remove(
		org.kisti.edison.project.service.persistence.HistoryScienceAppPK historyScienceAppPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.project.NoSuchHistoryScienceAppException {
		return getPersistence().remove(historyScienceAppPK);
	}

	public static org.kisti.edison.project.model.HistoryScienceApp updateImpl(
		org.kisti.edison.project.model.HistoryScienceApp historyScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(historyScienceApp);
	}

	/**
	* Returns the history science app with the primary key or throws a {@link org.kisti.edison.project.NoSuchHistoryScienceAppException} if it could not be found.
	*
	* @param historyScienceAppPK the primary key of the history science app
	* @return the history science app
	* @throws org.kisti.edison.project.NoSuchHistoryScienceAppException if a history science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.project.model.HistoryScienceApp findByPrimaryKey(
		org.kisti.edison.project.service.persistence.HistoryScienceAppPK historyScienceAppPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.project.NoSuchHistoryScienceAppException {
		return getPersistence().findByPrimaryKey(historyScienceAppPK);
	}

	/**
	* Returns the history science app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param historyScienceAppPK the primary key of the history science app
	* @return the history science app, or <code>null</code> if a history science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.project.model.HistoryScienceApp fetchByPrimaryKey(
		org.kisti.edison.project.service.persistence.HistoryScienceAppPK historyScienceAppPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(historyScienceAppPK);
	}

	/**
	* Returns all the history science apps.
	*
	* @return the history science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.project.model.HistoryScienceApp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the history science apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.project.model.impl.HistoryScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of history science apps
	* @param end the upper bound of the range of history science apps (not inclusive)
	* @return the range of history science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.project.model.HistoryScienceApp> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the history science apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.project.model.impl.HistoryScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of history science apps
	* @param end the upper bound of the range of history science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of history science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.project.model.HistoryScienceApp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the history science apps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of history science apps.
	*
	* @return the number of history science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HistoryScienceAppPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HistoryScienceAppPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.project.service.ClpSerializer.getServletContextName(),
					HistoryScienceAppPersistence.class.getName());

			ReferenceRegistry.registerReference(HistoryScienceAppUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(HistoryScienceAppPersistence persistence) {
	}

	private static HistoryScienceAppPersistence _persistence;
}