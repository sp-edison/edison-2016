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

import com.kisti.science.platform.app.model.ScienceAppManager;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the science app manager service. This utility wraps {@link ScienceAppManagerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppManagerPersistence
 * @see ScienceAppManagerPersistenceImpl
 * @generated
 */
public class ScienceAppManagerUtil {
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
	public static void clearCache(ScienceAppManager scienceAppManager) {
		getPersistence().clearCache(scienceAppManager);
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
	public static List<ScienceAppManager> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ScienceAppManager> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ScienceAppManager> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ScienceAppManager update(ScienceAppManager scienceAppManager)
		throws SystemException {
		return getPersistence().update(scienceAppManager);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ScienceAppManager update(
		ScienceAppManager scienceAppManager, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(scienceAppManager, serviceContext);
	}

	/**
	* Returns all the science app managers where scienceAppId = &#63; and managerId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param managerId the manager ID
	* @return the matching science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> findByAppIdManagerId(
		long scienceAppId, long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAppIdManagerId(scienceAppId, managerId);
	}

	/**
	* Returns a range of all the science app managers where scienceAppId = &#63; and managerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scienceAppId the science app ID
	* @param managerId the manager ID
	* @param start the lower bound of the range of science app managers
	* @param end the upper bound of the range of science app managers (not inclusive)
	* @return the range of matching science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> findByAppIdManagerId(
		long scienceAppId, long managerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppIdManagerId(scienceAppId, managerId, start, end);
	}

	/**
	* Returns an ordered range of all the science app managers where scienceAppId = &#63; and managerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scienceAppId the science app ID
	* @param managerId the manager ID
	* @param start the lower bound of the range of science app managers
	* @param end the upper bound of the range of science app managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> findByAppIdManagerId(
		long scienceAppId, long managerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppIdManagerId(scienceAppId, managerId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first science app manager in the ordered set where scienceAppId = &#63; and managerId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param managerId the manager ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app manager
	* @throws com.kisti.science.platform.app.NoSuchManagerException if a matching science app manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager findByAppIdManagerId_First(
		long scienceAppId, long managerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppIdManagerId_First(scienceAppId, managerId,
			orderByComparator);
	}

	/**
	* Returns the first science app manager in the ordered set where scienceAppId = &#63; and managerId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param managerId the manager ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app manager, or <code>null</code> if a matching science app manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager fetchByAppIdManagerId_First(
		long scienceAppId, long managerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAppIdManagerId_First(scienceAppId, managerId,
			orderByComparator);
	}

	/**
	* Returns the last science app manager in the ordered set where scienceAppId = &#63; and managerId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param managerId the manager ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app manager
	* @throws com.kisti.science.platform.app.NoSuchManagerException if a matching science app manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager findByAppIdManagerId_Last(
		long scienceAppId, long managerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppIdManagerId_Last(scienceAppId, managerId,
			orderByComparator);
	}

	/**
	* Returns the last science app manager in the ordered set where scienceAppId = &#63; and managerId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param managerId the manager ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app manager, or <code>null</code> if a matching science app manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager fetchByAppIdManagerId_Last(
		long scienceAppId, long managerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAppIdManagerId_Last(scienceAppId, managerId,
			orderByComparator);
	}

	/**
	* Returns the science app managers before and after the current science app manager in the ordered set where scienceAppId = &#63; and managerId = &#63;.
	*
	* @param scienceAppManagerId the primary key of the current science app manager
	* @param scienceAppId the science app ID
	* @param managerId the manager ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app manager
	* @throws com.kisti.science.platform.app.NoSuchManagerException if a science app manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager[] findByAppIdManagerId_PrevAndNext(
		long scienceAppManagerId, long scienceAppId, long managerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppIdManagerId_PrevAndNext(scienceAppManagerId,
			scienceAppId, managerId, orderByComparator);
	}

	/**
	* Removes all the science app managers where scienceAppId = &#63; and managerId = &#63; from the database.
	*
	* @param scienceAppId the science app ID
	* @param managerId the manager ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAppIdManagerId(long scienceAppId, long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAppIdManagerId(scienceAppId, managerId);
	}

	/**
	* Returns the number of science app managers where scienceAppId = &#63; and managerId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param managerId the manager ID
	* @return the number of matching science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAppIdManagerId(long scienceAppId, long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAppIdManagerId(scienceAppId, managerId);
	}

	/**
	* Returns all the science app managers where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @return the matching science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> findByAppId(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAppId(scienceAppId);
	}

	/**
	* Returns a range of all the science app managers where scienceAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scienceAppId the science app ID
	* @param start the lower bound of the range of science app managers
	* @param end the upper bound of the range of science app managers (not inclusive)
	* @return the range of matching science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> findByAppId(
		long scienceAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAppId(scienceAppId, start, end);
	}

	/**
	* Returns an ordered range of all the science app managers where scienceAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scienceAppId the science app ID
	* @param start the lower bound of the range of science app managers
	* @param end the upper bound of the range of science app managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> findByAppId(
		long scienceAppId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppId(scienceAppId, start, end, orderByComparator);
	}

	/**
	* Returns the first science app manager in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app manager
	* @throws com.kisti.science.platform.app.NoSuchManagerException if a matching science app manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager findByAppId_First(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppId_First(scienceAppId, orderByComparator);
	}

	/**
	* Returns the first science app manager in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app manager, or <code>null</code> if a matching science app manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager fetchByAppId_First(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAppId_First(scienceAppId, orderByComparator);
	}

	/**
	* Returns the last science app manager in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app manager
	* @throws com.kisti.science.platform.app.NoSuchManagerException if a matching science app manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager findByAppId_Last(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAppId_Last(scienceAppId, orderByComparator);
	}

	/**
	* Returns the last science app manager in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app manager, or <code>null</code> if a matching science app manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager fetchByAppId_Last(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAppId_Last(scienceAppId, orderByComparator);
	}

	/**
	* Returns the science app managers before and after the current science app manager in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppManagerId the primary key of the current science app manager
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app manager
	* @throws com.kisti.science.platform.app.NoSuchManagerException if a science app manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager[] findByAppId_PrevAndNext(
		long scienceAppManagerId, long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppId_PrevAndNext(scienceAppManagerId, scienceAppId,
			orderByComparator);
	}

	/**
	* Removes all the science app managers where scienceAppId = &#63; from the database.
	*
	* @param scienceAppId the science app ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAppId(scienceAppId);
	}

	/**
	* Returns the number of science app managers where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @return the number of matching science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAppId(scienceAppId);
	}

	/**
	* Returns all the science app managers where managerId = &#63;.
	*
	* @param managerId the manager ID
	* @return the matching science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> findByManagerId(
		long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByManagerId(managerId);
	}

	/**
	* Returns a range of all the science app managers where managerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param managerId the manager ID
	* @param start the lower bound of the range of science app managers
	* @param end the upper bound of the range of science app managers (not inclusive)
	* @return the range of matching science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> findByManagerId(
		long managerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByManagerId(managerId, start, end);
	}

	/**
	* Returns an ordered range of all the science app managers where managerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param managerId the manager ID
	* @param start the lower bound of the range of science app managers
	* @param end the upper bound of the range of science app managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> findByManagerId(
		long managerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByManagerId(managerId, start, end, orderByComparator);
	}

	/**
	* Returns the first science app manager in the ordered set where managerId = &#63;.
	*
	* @param managerId the manager ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app manager
	* @throws com.kisti.science.platform.app.NoSuchManagerException if a matching science app manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager findByManagerId_First(
		long managerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByManagerId_First(managerId, orderByComparator);
	}

	/**
	* Returns the first science app manager in the ordered set where managerId = &#63;.
	*
	* @param managerId the manager ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app manager, or <code>null</code> if a matching science app manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager fetchByManagerId_First(
		long managerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByManagerId_First(managerId, orderByComparator);
	}

	/**
	* Returns the last science app manager in the ordered set where managerId = &#63;.
	*
	* @param managerId the manager ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app manager
	* @throws com.kisti.science.platform.app.NoSuchManagerException if a matching science app manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager findByManagerId_Last(
		long managerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByManagerId_Last(managerId, orderByComparator);
	}

	/**
	* Returns the last science app manager in the ordered set where managerId = &#63;.
	*
	* @param managerId the manager ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app manager, or <code>null</code> if a matching science app manager could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager fetchByManagerId_Last(
		long managerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByManagerId_Last(managerId, orderByComparator);
	}

	/**
	* Returns the science app managers before and after the current science app manager in the ordered set where managerId = &#63;.
	*
	* @param scienceAppManagerId the primary key of the current science app manager
	* @param managerId the manager ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app manager
	* @throws com.kisti.science.platform.app.NoSuchManagerException if a science app manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager[] findByManagerId_PrevAndNext(
		long scienceAppManagerId, long managerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByManagerId_PrevAndNext(scienceAppManagerId, managerId,
			orderByComparator);
	}

	/**
	* Removes all the science app managers where managerId = &#63; from the database.
	*
	* @param managerId the manager ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByManagerId(managerId);
	}

	/**
	* Returns the number of science app managers where managerId = &#63;.
	*
	* @param managerId the manager ID
	* @return the number of matching science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByManagerId(managerId);
	}

	/**
	* Caches the science app manager in the entity cache if it is enabled.
	*
	* @param scienceAppManager the science app manager
	*/
	public static void cacheResult(
		com.kisti.science.platform.app.model.ScienceAppManager scienceAppManager) {
		getPersistence().cacheResult(scienceAppManager);
	}

	/**
	* Caches the science app managers in the entity cache if it is enabled.
	*
	* @param scienceAppManagers the science app managers
	*/
	public static void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> scienceAppManagers) {
		getPersistence().cacheResult(scienceAppManagers);
	}

	/**
	* Creates a new science app manager with the primary key. Does not add the science app manager to the database.
	*
	* @param scienceAppManagerId the primary key for the new science app manager
	* @return the new science app manager
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager create(
		long scienceAppManagerId) {
		return getPersistence().create(scienceAppManagerId);
	}

	/**
	* Removes the science app manager with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppManagerId the primary key of the science app manager
	* @return the science app manager that was removed
	* @throws com.kisti.science.platform.app.NoSuchManagerException if a science app manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager remove(
		long scienceAppManagerId)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(scienceAppManagerId);
	}

	public static com.kisti.science.platform.app.model.ScienceAppManager updateImpl(
		com.kisti.science.platform.app.model.ScienceAppManager scienceAppManager)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(scienceAppManager);
	}

	/**
	* Returns the science app manager with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchManagerException} if it could not be found.
	*
	* @param scienceAppManagerId the primary key of the science app manager
	* @return the science app manager
	* @throws com.kisti.science.platform.app.NoSuchManagerException if a science app manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager findByPrimaryKey(
		long scienceAppManagerId)
		throws com.kisti.science.platform.app.NoSuchManagerException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(scienceAppManagerId);
	}

	/**
	* Returns the science app manager with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scienceAppManagerId the primary key of the science app manager
	* @return the science app manager, or <code>null</code> if a science app manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager fetchByPrimaryKey(
		long scienceAppManagerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(scienceAppManagerId);
	}

	/**
	* Returns all the science app managers.
	*
	* @return the science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the science app managers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app managers
	* @param end the upper bound of the range of science app managers (not inclusive)
	* @return the range of science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the science app managers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app managers
	* @param end the upper bound of the range of science app managers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the science app managers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of science app managers.
	*
	* @return the number of science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ScienceAppManagerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ScienceAppManagerPersistence)PortletBeanLocatorUtil.locate(com.kisti.science.platform.app.service.ClpSerializer.getServletContextName(),
					ScienceAppManagerPersistence.class.getName());

			ReferenceRegistry.registerReference(ScienceAppManagerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ScienceAppManagerPersistence persistence) {
	}

	private static ScienceAppManagerPersistence _persistence;
}