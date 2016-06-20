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

package org.kisti.edison.science.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.kisti.edison.science.model.ScienceApp;

import java.util.List;

/**
 * The persistence utility for the science app service. This utility wraps {@link ScienceAppPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see ScienceAppPersistence
 * @see ScienceAppPersistenceImpl
 * @generated
 */
public class ScienceAppUtil {
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
	public static void clearCache(ScienceApp scienceApp) {
		getPersistence().clearCache(scienceApp);
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
	public static List<ScienceApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ScienceApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ScienceApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ScienceApp update(ScienceApp scienceApp)
		throws SystemException {
		return getPersistence().update(scienceApp);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ScienceApp update(ScienceApp scienceApp,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(scienceApp, serviceContext);
	}

	/**
	* Returns all the science apps where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the science apps where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where uuid = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByUuid_PrevAndNext(
		long scienceAppId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByUuid_PrevAndNext(scienceAppId, uuid, orderByComparator);
	}

	/**
	* Removes all the science apps where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of science apps where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the science app where uuid = &#63; and groupId = &#63; or throws a {@link org.kisti.edison.science.NoSuchScienceAppException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the science app where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the science app where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the science app where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the science app that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of science apps where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the science apps where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the science apps where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByUuid_C_PrevAndNext(
		long scienceAppId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(scienceAppId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the science apps where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of science apps where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the science apps where name = &#63;.
	*
	* @param name the name
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns a range of all the science apps where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where name = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByName_PrevAndNext(
		long scienceAppId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByName_PrevAndNext(scienceAppId, name, orderByComparator);
	}

	/**
	* Removes all the science apps where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of science apps where name = &#63;.
	*
	* @param name the name
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns all the science apps where appType = &#63;.
	*
	* @param appType the app type
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppType(
		java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAppType(appType);
	}

	/**
	* Returns a range of all the science apps where appType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appType the app type
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppType(
		java.lang.String appType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAppType(appType, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where appType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appType the app type
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppType(
		java.lang.String appType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppType(appType, start, end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where appType = &#63;.
	*
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAppType_First(
		java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByAppType_First(appType, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where appType = &#63;.
	*
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAppType_First(
		java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAppType_First(appType, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where appType = &#63;.
	*
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAppType_Last(
		java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByAppType_Last(appType, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where appType = &#63;.
	*
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAppType_Last(
		java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAppType_Last(appType, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where appType = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByAppType_PrevAndNext(
		long scienceAppId, java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAppType_PrevAndNext(scienceAppId, appType,
			orderByComparator);
	}

	/**
	* Removes all the science apps where appType = &#63; from the database.
	*
	* @param appType the app type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAppType(java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAppType(appType);
	}

	/**
	* Returns the number of science apps where appType = &#63;.
	*
	* @param appType the app type
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAppType(java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAppType(appType);
	}

	/**
	* Returns all the science apps where appType = &#63; and runType = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppRunType(
		java.lang.String appType, java.lang.String runType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAppRunType(appType, runType);
	}

	/**
	* Returns a range of all the science apps where appType = &#63; and runType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appType the app type
	* @param runType the run type
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppRunType(
		java.lang.String appType, java.lang.String runType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAppRunType(appType, runType, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where appType = &#63; and runType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appType the app type
	* @param runType the run type
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppRunType(
		java.lang.String appType, java.lang.String runType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppRunType(appType, runType, start, end,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where appType = &#63; and runType = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAppRunType_First(
		java.lang.String appType, java.lang.String runType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAppRunType_First(appType, runType, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where appType = &#63; and runType = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAppRunType_First(
		java.lang.String appType, java.lang.String runType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAppRunType_First(appType, runType, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where appType = &#63; and runType = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAppRunType_Last(
		java.lang.String appType, java.lang.String runType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAppRunType_Last(appType, runType, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where appType = &#63; and runType = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAppRunType_Last(
		java.lang.String appType, java.lang.String runType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAppRunType_Last(appType, runType, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where appType = &#63; and runType = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param appType the app type
	* @param runType the run type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByAppRunType_PrevAndNext(
		long scienceAppId, java.lang.String appType, java.lang.String runType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAppRunType_PrevAndNext(scienceAppId, appType,
			runType, orderByComparator);
	}

	/**
	* Removes all the science apps where appType = &#63; and runType = &#63; from the database.
	*
	* @param appType the app type
	* @param runType the run type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAppRunType(java.lang.String appType,
		java.lang.String runType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAppRunType(appType, runType);
	}

	/**
	* Returns the number of science apps where appType = &#63; and runType = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAppRunType(java.lang.String appType,
		java.lang.String runType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAppRunType(appType, runType);
	}

	/**
	* Returns all the science apps where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorId(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAuthorId(authorId);
	}

	/**
	* Returns a range of all the science apps where authorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorId(
		long authorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAuthorId(authorId, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where authorId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorId(
		long authorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorId(authorId, start, end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAuthorId_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByAuthorId_First(authorId, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAuthorId_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAuthorId_First(authorId, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAuthorId_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByAuthorId_Last(authorId, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAuthorId_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAuthorId_Last(authorId, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where authorId = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByAuthorId_PrevAndNext(
		long scienceAppId, long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorId_PrevAndNext(scienceAppId, authorId,
			orderByComparator);
	}

	/**
	* Removes all the science apps where authorId = &#63; from the database.
	*
	* @param authorId the author ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAuthorId(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAuthorId(authorId);
	}

	/**
	* Returns the number of science apps where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAuthorId(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAuthorId(authorId);
	}

	/**
	* Returns all the science apps where stage = &#63;.
	*
	* @param stage the stage
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByStage(
		java.lang.String stage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStage(stage);
	}

	/**
	* Returns a range of all the science apps where stage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stage the stage
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByStage(
		java.lang.String stage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStage(stage, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where stage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stage the stage
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByStage(
		java.lang.String stage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStage(stage, start, end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where stage = &#63;.
	*
	* @param stage the stage
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByStage_First(
		java.lang.String stage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByStage_First(stage, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where stage = &#63;.
	*
	* @param stage the stage
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByStage_First(
		java.lang.String stage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStage_First(stage, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where stage = &#63;.
	*
	* @param stage the stage
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByStage_Last(
		java.lang.String stage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByStage_Last(stage, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where stage = &#63;.
	*
	* @param stage the stage
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByStage_Last(
		java.lang.String stage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStage_Last(stage, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where stage = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param stage the stage
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByStage_PrevAndNext(
		long scienceAppId, java.lang.String stage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByStage_PrevAndNext(scienceAppId, stage,
			orderByComparator);
	}

	/**
	* Removes all the science apps where stage = &#63; from the database.
	*
	* @param stage the stage
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStage(java.lang.String stage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStage(stage);
	}

	/**
	* Returns the number of science apps where stage = &#63;.
	*
	* @param stage the stage
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStage(java.lang.String stage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStage(stage);
	}

	/**
	* Returns all the science apps where status = &#63;.
	*
	* @param status the status
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the science apps where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where status = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByStatus_PrevAndNext(
		long scienceAppId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByStatus_PrevAndNext(scienceAppId, status,
			orderByComparator);
	}

	/**
	* Removes all the science apps where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of science apps where status = &#63;.
	*
	* @param status the status
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Returns all the science apps where title LIKE &#63;.
	*
	* @param title the title
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title);
	}

	/**
	* Returns a range of all the science apps where title LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where title LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where title LIKE &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByTitle_PrevAndNext(
		long scienceAppId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByTitle_PrevAndNext(scienceAppId, title,
			orderByComparator);
	}

	/**
	* Removes all the science apps where title LIKE &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitle(title);
	}

	/**
	* Returns the number of science apps where title LIKE &#63;.
	*
	* @param title the title
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitle(title);
	}

	/**
	* Returns the science app where name = &#63; and version = &#63; or throws a {@link org.kisti.edison.science.NoSuchScienceAppException} if it could not be found.
	*
	* @param name the name
	* @param version the version
	* @return the matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByNameVersion(
		java.lang.String name, java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByNameVersion(name, version);
	}

	/**
	* Returns the science app where name = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param version the version
	* @return the matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByNameVersion(
		java.lang.String name, java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNameVersion(name, version);
	}

	/**
	* Returns the science app where name = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param version the version
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByNameVersion(
		java.lang.String name, java.lang.String version,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameVersion(name, version, retrieveFromCache);
	}

	/**
	* Removes the science app where name = &#63; and version = &#63; from the database.
	*
	* @param name the name
	* @param version the version
	* @return the science app that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp removeByNameVersion(
		java.lang.String name, java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().removeByNameVersion(name, version);
	}

	/**
	* Returns the number of science apps where name = &#63; and version = &#63;.
	*
	* @param name the name
	* @param version the version
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameVersion(java.lang.String name,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNameVersion(name, version);
	}

	/**
	* Returns all the science apps where authorId = &#63; and appType = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdAppType(
		long authorId, java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAuthorIdAppType(authorId, appType);
	}

	/**
	* Returns a range of all the science apps where authorId = &#63; and appType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdAppType(
		long authorId, java.lang.String appType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorIdAppType(authorId, appType, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where authorId = &#63; and appType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdAppType(
		long authorId, java.lang.String appType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorIdAppType(authorId, appType, start, end,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where authorId = &#63; and appType = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAuthorIdAppType_First(
		long authorId, java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdAppType_First(authorId, appType,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where authorId = &#63; and appType = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAuthorIdAppType_First(
		long authorId, java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAuthorIdAppType_First(authorId, appType,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where authorId = &#63; and appType = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAuthorIdAppType_Last(
		long authorId, java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdAppType_Last(authorId, appType,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where authorId = &#63; and appType = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAuthorIdAppType_Last(
		long authorId, java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAuthorIdAppType_Last(authorId, appType,
			orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where authorId = &#63; and appType = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param authorId the author ID
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByAuthorIdAppType_PrevAndNext(
		long scienceAppId, long authorId, java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdAppType_PrevAndNext(scienceAppId, authorId,
			appType, orderByComparator);
	}

	/**
	* Removes all the science apps where authorId = &#63; and appType = &#63; from the database.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAuthorIdAppType(long authorId,
		java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAuthorIdAppType(authorId, appType);
	}

	/**
	* Returns the number of science apps where authorId = &#63; and appType = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAuthorIdAppType(long authorId,
		java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAuthorIdAppType(authorId, appType);
	}

	/**
	* Returns all the science apps where authorId = &#63; and status = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdStatus(
		long authorId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAuthorIdStatus(authorId, status);
	}

	/**
	* Returns a range of all the science apps where authorId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param status the status
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdStatus(
		long authorId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorIdStatus(authorId, status, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where authorId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param status the status
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdStatus(
		long authorId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorIdStatus(authorId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where authorId = &#63; and status = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAuthorIdStatus_First(
		long authorId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdStatus_First(authorId, status,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where authorId = &#63; and status = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAuthorIdStatus_First(
		long authorId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAuthorIdStatus_First(authorId, status,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where authorId = &#63; and status = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAuthorIdStatus_Last(
		long authorId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdStatus_Last(authorId, status,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where authorId = &#63; and status = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAuthorIdStatus_Last(
		long authorId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAuthorIdStatus_Last(authorId, status,
			orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where authorId = &#63; and status = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param authorId the author ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByAuthorIdStatus_PrevAndNext(
		long scienceAppId, long authorId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdStatus_PrevAndNext(scienceAppId, authorId,
			status, orderByComparator);
	}

	/**
	* Removes all the science apps where authorId = &#63; and status = &#63; from the database.
	*
	* @param authorId the author ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAuthorIdStatus(long authorId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAuthorIdStatus(authorId, status);
	}

	/**
	* Returns the number of science apps where authorId = &#63; and status = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAuthorIdStatus(long authorId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAuthorIdStatus(authorId, status);
	}

	/**
	* Returns all the science apps where openLevel = &#63;.
	*
	* @param openLevel the open level
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByOpenLevel(
		java.lang.String openLevel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOpenLevel(openLevel);
	}

	/**
	* Returns a range of all the science apps where openLevel = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param openLevel the open level
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByOpenLevel(
		java.lang.String openLevel, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOpenLevel(openLevel, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where openLevel = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param openLevel the open level
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByOpenLevel(
		java.lang.String openLevel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOpenLevel(openLevel, start, end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where openLevel = &#63;.
	*
	* @param openLevel the open level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByOpenLevel_First(
		java.lang.String openLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByOpenLevel_First(openLevel, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where openLevel = &#63;.
	*
	* @param openLevel the open level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByOpenLevel_First(
		java.lang.String openLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOpenLevel_First(openLevel, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where openLevel = &#63;.
	*
	* @param openLevel the open level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByOpenLevel_Last(
		java.lang.String openLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByOpenLevel_Last(openLevel, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where openLevel = &#63;.
	*
	* @param openLevel the open level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByOpenLevel_Last(
		java.lang.String openLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOpenLevel_Last(openLevel, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where openLevel = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param openLevel the open level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByOpenLevel_PrevAndNext(
		long scienceAppId, java.lang.String openLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByOpenLevel_PrevAndNext(scienceAppId, openLevel,
			orderByComparator);
	}

	/**
	* Removes all the science apps where openLevel = &#63; from the database.
	*
	* @param openLevel the open level
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOpenLevel(java.lang.String openLevel)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOpenLevel(openLevel);
	}

	/**
	* Returns the number of science apps where openLevel = &#63;.
	*
	* @param openLevel the open level
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOpenLevel(java.lang.String openLevel)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOpenLevel(openLevel);
	}

	/**
	* Returns all the science apps where name = &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameWithTarget(
		java.lang.String name, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNameWithTarget(name, targetLanguage);
	}

	/**
	* Returns a range of all the science apps where name = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameWithTarget(
		java.lang.String name, java.lang.String targetLanguage, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNameWithTarget(name, targetLanguage, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where name = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameWithTarget(
		java.lang.String name, java.lang.String targetLanguage, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNameWithTarget(name, targetLanguage, start, end,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where name = &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByNameWithTarget_First(
		java.lang.String name, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByNameWithTarget_First(name, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where name = &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByNameWithTarget_First(
		java.lang.String name, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameWithTarget_First(name, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where name = &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByNameWithTarget_Last(
		java.lang.String name, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByNameWithTarget_Last(name, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where name = &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByNameWithTarget_Last(
		java.lang.String name, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameWithTarget_Last(name, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where name = &#63; and targetLanguage = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param name the name
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByNameWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String name,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByNameWithTarget_PrevAndNext(scienceAppId, name,
			targetLanguage, orderByComparator);
	}

	/**
	* Removes all the science apps where name = &#63; and targetLanguage = &#63; from the database.
	*
	* @param name the name
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNameWithTarget(java.lang.String name,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNameWithTarget(name, targetLanguage);
	}

	/**
	* Returns the number of science apps where name = &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameWithTarget(java.lang.String name,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNameWithTarget(name, targetLanguage);
	}

	/**
	* Returns all the science apps where appType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppTypeWithTarget(
		java.lang.String appType, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAppTypeWithTarget(appType, targetLanguage);
	}

	/**
	* Returns a range of all the science apps where appType = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppTypeWithTarget(
		java.lang.String appType, java.lang.String targetLanguage, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppTypeWithTarget(appType, targetLanguage, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where appType = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppTypeWithTarget(
		java.lang.String appType, java.lang.String targetLanguage, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppTypeWithTarget(appType, targetLanguage, start,
			end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where appType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAppTypeWithTarget_First(
		java.lang.String appType, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAppTypeWithTarget_First(appType, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where appType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAppTypeWithTarget_First(
		java.lang.String appType, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAppTypeWithTarget_First(appType, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where appType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAppTypeWithTarget_Last(
		java.lang.String appType, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAppTypeWithTarget_Last(appType, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where appType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAppTypeWithTarget_Last(
		java.lang.String appType, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAppTypeWithTarget_Last(appType, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where appType = &#63; and targetLanguage = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param appType the app type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByAppTypeWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String appType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAppTypeWithTarget_PrevAndNext(scienceAppId, appType,
			targetLanguage, orderByComparator);
	}

	/**
	* Removes all the science apps where appType = &#63; and targetLanguage = &#63; from the database.
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAppTypeWithTarget(java.lang.String appType,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAppTypeWithTarget(appType, targetLanguage);
	}

	/**
	* Returns the number of science apps where appType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAppTypeWithTarget(java.lang.String appType,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAppTypeWithTarget(appType, targetLanguage);
	}

	/**
	* Returns all the science apps where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppRunTypeWithTarget(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppRunTypeWithTarget(appType, runType, targetLanguage);
	}

	/**
	* Returns a range of all the science apps where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appType the app type
	* @param runType the run type
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppRunTypeWithTarget(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppRunTypeWithTarget(appType, runType,
			targetLanguage, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param appType the app type
	* @param runType the run type
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppRunTypeWithTarget(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAppRunTypeWithTarget(appType, runType,
			targetLanguage, start, end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAppRunTypeWithTarget_First(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAppRunTypeWithTarget_First(appType, runType,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAppRunTypeWithTarget_First(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAppRunTypeWithTarget_First(appType, runType,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAppRunTypeWithTarget_Last(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAppRunTypeWithTarget_Last(appType, runType,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAppRunTypeWithTarget_Last(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAppRunTypeWithTarget_Last(appType, runType,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param appType the app type
	* @param runType the run type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByAppRunTypeWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAppRunTypeWithTarget_PrevAndNext(scienceAppId,
			appType, runType, targetLanguage, orderByComparator);
	}

	/**
	* Removes all the science apps where appType = &#63; and runType = &#63; and targetLanguage = &#63; from the database.
	*
	* @param appType the app type
	* @param runType the run type
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAppRunTypeWithTarget(java.lang.String appType,
		java.lang.String runType, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByAppRunTypeWithTarget(appType, runType, targetLanguage);
	}

	/**
	* Returns the number of science apps where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAppRunTypeWithTarget(java.lang.String appType,
		java.lang.String runType, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByAppRunTypeWithTarget(appType, runType, targetLanguage);
	}

	/**
	* Returns all the science apps where authorId = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdWithTarget(
		long authorId, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorIdWithTarget(authorId, targetLanguage);
	}

	/**
	* Returns a range of all the science apps where authorId = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdWithTarget(
		long authorId, java.lang.String targetLanguage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorIdWithTarget(authorId, targetLanguage, start,
			end);
	}

	/**
	* Returns an ordered range of all the science apps where authorId = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdWithTarget(
		long authorId, java.lang.String targetLanguage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorIdWithTarget(authorId, targetLanguage, start,
			end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where authorId = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAuthorIdWithTarget_First(
		long authorId, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdWithTarget_First(authorId, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where authorId = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAuthorIdWithTarget_First(
		long authorId, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAuthorIdWithTarget_First(authorId, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where authorId = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAuthorIdWithTarget_Last(
		long authorId, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdWithTarget_Last(authorId, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where authorId = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAuthorIdWithTarget_Last(
		long authorId, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAuthorIdWithTarget_Last(authorId, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where authorId = &#63; and targetLanguage = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByAuthorIdWithTarget_PrevAndNext(
		long scienceAppId, long authorId, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdWithTarget_PrevAndNext(scienceAppId,
			authorId, targetLanguage, orderByComparator);
	}

	/**
	* Removes all the science apps where authorId = &#63; and targetLanguage = &#63; from the database.
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAuthorIdWithTarget(long authorId,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAuthorIdWithTarget(authorId, targetLanguage);
	}

	/**
	* Returns the number of science apps where authorId = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAuthorIdWithTarget(long authorId,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByAuthorIdWithTarget(authorId, targetLanguage);
	}

	/**
	* Returns all the science apps where stage = &#63; and targetLanguage = &#63;.
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByStageWithTarget(
		java.lang.String stage, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStageWithTarget(stage, targetLanguage);
	}

	/**
	* Returns a range of all the science apps where stage = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByStageWithTarget(
		java.lang.String stage, java.lang.String targetLanguage, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStageWithTarget(stage, targetLanguage, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where stage = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByStageWithTarget(
		java.lang.String stage, java.lang.String targetLanguage, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStageWithTarget(stage, targetLanguage, start, end,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where stage = &#63; and targetLanguage = &#63;.
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByStageWithTarget_First(
		java.lang.String stage, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByStageWithTarget_First(stage, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where stage = &#63; and targetLanguage = &#63;.
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByStageWithTarget_First(
		java.lang.String stage, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStageWithTarget_First(stage, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where stage = &#63; and targetLanguage = &#63;.
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByStageWithTarget_Last(
		java.lang.String stage, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByStageWithTarget_Last(stage, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where stage = &#63; and targetLanguage = &#63;.
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByStageWithTarget_Last(
		java.lang.String stage, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStageWithTarget_Last(stage, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where stage = &#63; and targetLanguage = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param stage the stage
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByStageWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String stage,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByStageWithTarget_PrevAndNext(scienceAppId, stage,
			targetLanguage, orderByComparator);
	}

	/**
	* Removes all the science apps where stage = &#63; and targetLanguage = &#63; from the database.
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStageWithTarget(java.lang.String stage,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStageWithTarget(stage, targetLanguage);
	}

	/**
	* Returns the number of science apps where stage = &#63; and targetLanguage = &#63;.
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStageWithTarget(java.lang.String stage,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStageWithTarget(stage, targetLanguage);
	}

	/**
	* Returns all the science apps where status = &#63; and targetLanguage = &#63;.
	*
	* @param status the status
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByStatusWithTarget(
		int status, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatusWithTarget(status, targetLanguage);
	}

	/**
	* Returns a range of all the science apps where status = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByStatusWithTarget(
		int status, java.lang.String targetLanguage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusWithTarget(status, targetLanguage, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where status = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByStatusWithTarget(
		int status, java.lang.String targetLanguage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatusWithTarget(status, targetLanguage, start, end,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where status = &#63; and targetLanguage = &#63;.
	*
	* @param status the status
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByStatusWithTarget_First(
		int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByStatusWithTarget_First(status, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where status = &#63; and targetLanguage = &#63;.
	*
	* @param status the status
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByStatusWithTarget_First(
		int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusWithTarget_First(status, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where status = &#63; and targetLanguage = &#63;.
	*
	* @param status the status
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByStatusWithTarget_Last(
		int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByStatusWithTarget_Last(status, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where status = &#63; and targetLanguage = &#63;.
	*
	* @param status the status
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByStatusWithTarget_Last(
		int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByStatusWithTarget_Last(status, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where status = &#63; and targetLanguage = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param status the status
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByStatusWithTarget_PrevAndNext(
		long scienceAppId, int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByStatusWithTarget_PrevAndNext(scienceAppId, status,
			targetLanguage, orderByComparator);
	}

	/**
	* Removes all the science apps where status = &#63; and targetLanguage = &#63; from the database.
	*
	* @param status the status
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatusWithTarget(int status,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatusWithTarget(status, targetLanguage);
	}

	/**
	* Returns the number of science apps where status = &#63; and targetLanguage = &#63;.
	*
	* @param status the status
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatusWithTarget(int status,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatusWithTarget(status, targetLanguage);
	}

	/**
	* Returns all the science apps where title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param title the title
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByTitleWithTarget(
		java.lang.String title, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitleWithTarget(title, targetLanguage);
	}

	/**
	* Returns a range of all the science apps where title LIKE &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByTitleWithTarget(
		java.lang.String title, java.lang.String targetLanguage, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTitleWithTarget(title, targetLanguage, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where title LIKE &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByTitleWithTarget(
		java.lang.String title, java.lang.String targetLanguage, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTitleWithTarget(title, targetLanguage, start, end,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param title the title
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByTitleWithTarget_First(
		java.lang.String title, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByTitleWithTarget_First(title, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param title the title
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByTitleWithTarget_First(
		java.lang.String title, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTitleWithTarget_First(title, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param title the title
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByTitleWithTarget_Last(
		java.lang.String title, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByTitleWithTarget_Last(title, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param title the title
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByTitleWithTarget_Last(
		java.lang.String title, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTitleWithTarget_Last(title, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param title the title
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByTitleWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String title,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByTitleWithTarget_PrevAndNext(scienceAppId, title,
			targetLanguage, orderByComparator);
	}

	/**
	* Removes all the science apps where title LIKE &#63; and targetLanguage = &#63; from the database.
	*
	* @param title the title
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitleWithTarget(java.lang.String title,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitleWithTarget(title, targetLanguage);
	}

	/**
	* Returns the number of science apps where title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param title the title
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitleWithTarget(java.lang.String title,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitleWithTarget(title, targetLanguage);
	}

	/**
	* Returns all the science apps where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdAppTypeWithTarget(
		long authorId, java.lang.String appType, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorIdAppTypeWithTarget(authorId, appType,
			targetLanguage);
	}

	/**
	* Returns a range of all the science apps where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdAppTypeWithTarget(
		long authorId, java.lang.String appType,
		java.lang.String targetLanguage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorIdAppTypeWithTarget(authorId, appType,
			targetLanguage, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdAppTypeWithTarget(
		long authorId, java.lang.String appType,
		java.lang.String targetLanguage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorIdAppTypeWithTarget(authorId, appType,
			targetLanguage, start, end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAuthorIdAppTypeWithTarget_First(
		long authorId, java.lang.String appType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdAppTypeWithTarget_First(authorId, appType,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAuthorIdAppTypeWithTarget_First(
		long authorId, java.lang.String appType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAuthorIdAppTypeWithTarget_First(authorId, appType,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAuthorIdAppTypeWithTarget_Last(
		long authorId, java.lang.String appType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdAppTypeWithTarget_Last(authorId, appType,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAuthorIdAppTypeWithTarget_Last(
		long authorId, java.lang.String appType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAuthorIdAppTypeWithTarget_Last(authorId, appType,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param authorId the author ID
	* @param appType the app type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByAuthorIdAppTypeWithTarget_PrevAndNext(
		long scienceAppId, long authorId, java.lang.String appType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdAppTypeWithTarget_PrevAndNext(scienceAppId,
			authorId, appType, targetLanguage, orderByComparator);
	}

	/**
	* Removes all the science apps where authorId = &#63; and appType = &#63; and targetLanguage = &#63; from the database.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAuthorIdAppTypeWithTarget(long authorId,
		java.lang.String appType, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByAuthorIdAppTypeWithTarget(authorId, appType, targetLanguage);
	}

	/**
	* Returns the number of science apps where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAuthorIdAppTypeWithTarget(long authorId,
		java.lang.String appType, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByAuthorIdAppTypeWithTarget(authorId, appType,
			targetLanguage);
	}

	/**
	* Returns all the science apps where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdStatusWithTarget(
		long authorId, int status, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorIdStatusWithTarget(authorId, status,
			targetLanguage);
	}

	/**
	* Returns a range of all the science apps where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param status the status
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdStatusWithTarget(
		long authorId, int status, java.lang.String targetLanguage, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorIdStatusWithTarget(authorId, status,
			targetLanguage, start, end);
	}

	/**
	* Returns an ordered range of all the science apps where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param authorId the author ID
	* @param status the status
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdStatusWithTarget(
		long authorId, int status, java.lang.String targetLanguage, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAuthorIdStatusWithTarget(authorId, status,
			targetLanguage, start, end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAuthorIdStatusWithTarget_First(
		long authorId, int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdStatusWithTarget_First(authorId, status,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAuthorIdStatusWithTarget_First(
		long authorId, int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAuthorIdStatusWithTarget_First(authorId, status,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByAuthorIdStatusWithTarget_Last(
		long authorId, int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdStatusWithTarget_Last(authorId, status,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByAuthorIdStatusWithTarget_Last(
		long authorId, int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAuthorIdStatusWithTarget_Last(authorId, status,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param authorId the author ID
	* @param status the status
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByAuthorIdStatusWithTarget_PrevAndNext(
		long scienceAppId, long authorId, int status,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByAuthorIdStatusWithTarget_PrevAndNext(scienceAppId,
			authorId, status, targetLanguage, orderByComparator);
	}

	/**
	* Removes all the science apps where authorId = &#63; and status = &#63; and targetLanguage = &#63; from the database.
	*
	* @param authorId the author ID
	* @param status the status
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAuthorIdStatusWithTarget(long authorId,
		int status, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByAuthorIdStatusWithTarget(authorId, status, targetLanguage);
	}

	/**
	* Returns the number of science apps where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAuthorIdStatusWithTarget(long authorId,
		int status, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByAuthorIdStatusWithTarget(authorId, status,
			targetLanguage);
	}

	/**
	* Returns all the science apps where openLevel = &#63; and targetLanguage = &#63;.
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByOpenLevelWithTarget(
		java.lang.String openLevel, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOpenLevelWithTarget(openLevel, targetLanguage);
	}

	/**
	* Returns a range of all the science apps where openLevel = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByOpenLevelWithTarget(
		java.lang.String openLevel, java.lang.String targetLanguage, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOpenLevelWithTarget(openLevel, targetLanguage, start,
			end);
	}

	/**
	* Returns an ordered range of all the science apps where openLevel = &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByOpenLevelWithTarget(
		java.lang.String openLevel, java.lang.String targetLanguage, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOpenLevelWithTarget(openLevel, targetLanguage, start,
			end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where openLevel = &#63; and targetLanguage = &#63;.
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByOpenLevelWithTarget_First(
		java.lang.String openLevel, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByOpenLevelWithTarget_First(openLevel, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where openLevel = &#63; and targetLanguage = &#63;.
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByOpenLevelWithTarget_First(
		java.lang.String openLevel, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOpenLevelWithTarget_First(openLevel, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where openLevel = &#63; and targetLanguage = &#63;.
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByOpenLevelWithTarget_Last(
		java.lang.String openLevel, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByOpenLevelWithTarget_Last(openLevel, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where openLevel = &#63; and targetLanguage = &#63;.
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByOpenLevelWithTarget_Last(
		java.lang.String openLevel, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByOpenLevelWithTarget_Last(openLevel, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where openLevel = &#63; and targetLanguage = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByOpenLevelWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String openLevel,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByOpenLevelWithTarget_PrevAndNext(scienceAppId,
			openLevel, targetLanguage, orderByComparator);
	}

	/**
	* Removes all the science apps where openLevel = &#63; and targetLanguage = &#63; from the database.
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOpenLevelWithTarget(java.lang.String openLevel,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOpenLevelWithTarget(openLevel, targetLanguage);
	}

	/**
	* Returns the number of science apps where openLevel = &#63; and targetLanguage = &#63;.
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOpenLevelWithTarget(java.lang.String openLevel,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByOpenLevelWithTarget(openLevel, targetLanguage);
	}

	/**
	* Returns all the science apps where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param title the title
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameTitleWithTarget(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNameTitleWithTarget(name, title, targetLanguage);
	}

	/**
	* Returns a range of all the science apps where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param title the title
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameTitleWithTarget(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNameTitleWithTarget(name, title, targetLanguage,
			start, end);
	}

	/**
	* Returns an ordered range of all the science apps where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param title the title
	* @param targetLanguage the target language
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameTitleWithTarget(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNameTitleWithTarget(name, title, targetLanguage,
			start, end, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param title the title
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByNameTitleWithTarget_First(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByNameTitleWithTarget_First(name, title,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the first science app in the ordered set where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param title the title
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByNameTitleWithTarget_First(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameTitleWithTarget_First(name, title,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param title the title
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByNameTitleWithTarget_Last(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByNameTitleWithTarget_Last(name, title, targetLanguage,
			orderByComparator);
	}

	/**
	* Returns the last science app in the ordered set where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param title the title
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByNameTitleWithTarget_Last(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameTitleWithTarget_Last(name, title,
			targetLanguage, orderByComparator);
	}

	/**
	* Returns the science apps before and after the current science app in the ordered set where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param scienceAppId the primary key of the current science app
	* @param name the name
	* @param title the title
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp[] findByNameTitleWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence()
				   .findByNameTitleWithTarget_PrevAndNext(scienceAppId, name,
			title, targetLanguage, orderByComparator);
	}

	/**
	* Returns all the science apps where name LIKE any &#63; and title LIKE any &#63; and targetLanguage = all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param names the names
	* @param titles the titles
	* @param targetLanguages the target languages
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameTitleWithTarget(
		java.lang.String[] names, java.lang.String[] titles,
		java.lang.String[] targetLanguages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNameTitleWithTarget(names, titles, targetLanguages);
	}

	/**
	* Returns a range of all the science apps where name LIKE any &#63; and title LIKE any &#63; and targetLanguage = all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param names the names
	* @param titles the titles
	* @param targetLanguages the target languages
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameTitleWithTarget(
		java.lang.String[] names, java.lang.String[] titles,
		java.lang.String[] targetLanguages, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNameTitleWithTarget(names, titles, targetLanguages,
			start, end);
	}

	/**
	* Returns an ordered range of all the science apps where name LIKE any &#63; and title LIKE any &#63; and targetLanguage = all &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param names the names
	* @param titles the titles
	* @param targetLanguages the target languages
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameTitleWithTarget(
		java.lang.String[] names, java.lang.String[] titles,
		java.lang.String[] targetLanguages, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNameTitleWithTarget(names, titles, targetLanguages,
			start, end, orderByComparator);
	}

	/**
	* Removes all the science apps where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63; from the database.
	*
	* @param name the name
	* @param title the title
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNameTitleWithTarget(java.lang.String name,
		java.lang.String title, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNameTitleWithTarget(name, title, targetLanguage);
	}

	/**
	* Returns the number of science apps where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param title the title
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameTitleWithTarget(java.lang.String name,
		java.lang.String title, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByNameTitleWithTarget(name, title, targetLanguage);
	}

	/**
	* Returns the number of science apps where name LIKE any &#63; and title LIKE any &#63; and targetLanguage = all &#63;.
	*
	* @param names the names
	* @param titles the titles
	* @param targetLanguages the target languages
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameTitleWithTarget(java.lang.String[] names,
		java.lang.String[] titles, java.lang.String[] targetLanguages)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByNameTitleWithTarget(names, titles, targetLanguages);
	}

	/**
	* Caches the science app in the entity cache if it is enabled.
	*
	* @param scienceApp the science app
	*/
	public static void cacheResult(
		org.kisti.edison.science.model.ScienceApp scienceApp) {
		getPersistence().cacheResult(scienceApp);
	}

	/**
	* Caches the science apps in the entity cache if it is enabled.
	*
	* @param scienceApps the science apps
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.science.model.ScienceApp> scienceApps) {
		getPersistence().cacheResult(scienceApps);
	}

	/**
	* Creates a new science app with the primary key. Does not add the science app to the database.
	*
	* @param scienceAppId the primary key for the new science app
	* @return the new science app
	*/
	public static org.kisti.edison.science.model.ScienceApp create(
		long scienceAppId) {
		return getPersistence().create(scienceAppId);
	}

	/**
	* Removes the science app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppId the primary key of the science app
	* @return the science app that was removed
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp remove(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().remove(scienceAppId);
	}

	public static org.kisti.edison.science.model.ScienceApp updateImpl(
		org.kisti.edison.science.model.ScienceApp scienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(scienceApp);
	}

	/**
	* Returns the science app with the primary key or throws a {@link org.kisti.edison.science.NoSuchScienceAppException} if it could not be found.
	*
	* @param scienceAppId the primary key of the science app
	* @return the science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp findByPrimaryKey(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException {
		return getPersistence().findByPrimaryKey(scienceAppId);
	}

	/**
	* Returns the science app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scienceAppId the primary key of the science app
	* @return the science app, or <code>null</code> if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceApp fetchByPrimaryKey(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(scienceAppId);
	}

	/**
	* Returns all the science apps.
	*
	* @return the science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the science apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the science apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of science apps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the science apps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of science apps.
	*
	* @return the number of science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ScienceAppPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ScienceAppPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.science.service.ClpSerializer.getServletContextName(),
					ScienceAppPersistence.class.getName());

			ReferenceRegistry.registerReference(ScienceAppUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ScienceAppPersistence persistence) {
	}

	private static ScienceAppPersistence _persistence;
}