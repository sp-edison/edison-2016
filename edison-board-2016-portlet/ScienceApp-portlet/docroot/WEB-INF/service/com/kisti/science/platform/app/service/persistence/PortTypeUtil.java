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

import com.kisti.science.platform.app.model.PortType;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the port type service. This utility wraps {@link PortTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypePersistence
 * @see PortTypePersistenceImpl
 * @generated
 */
public class PortTypeUtil {
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
	public static void clearCache(PortType portType) {
		getPersistence().clearCache(portType);
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
	public static List<PortType> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PortType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PortType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PortType update(PortType portType) throws SystemException {
		return getPersistence().update(portType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PortType update(PortType portType,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(portType, serviceContext);
	}

	/**
	* Returns all the port types where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching port types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortType> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the port types where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of port types
	* @param end the upper bound of the range of port types (not inclusive)
	* @return the range of matching port types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortType> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the port types where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of port types
	* @param end the upper bound of the range of port types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching port types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortType> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first port type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type
	* @throws com.kisti.science.platform.app.NoSuchPortTypeException if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first port type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type, or <code>null</code> if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last port type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type
	* @throws com.kisti.science.platform.app.NoSuchPortTypeException if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last port type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type, or <code>null</code> if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the port types before and after the current port type in the ordered set where uuid = &#63;.
	*
	* @param portTypeId the primary key of the current port type
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next port type
	* @throws com.kisti.science.platform.app.NoSuchPortTypeException if a port type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType[] findByUuid_PrevAndNext(
		long portTypeId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(portTypeId, uuid, orderByComparator);
	}

	/**
	* Removes all the port types where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of port types where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching port types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the port types where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching port types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortType> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the port types where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of port types
	* @param end the upper bound of the range of port types (not inclusive)
	* @return the range of matching port types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortType> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the port types where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of port types
	* @param end the upper bound of the range of port types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching port types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortType> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first port type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type
	* @throws com.kisti.science.platform.app.NoSuchPortTypeException if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first port type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type, or <code>null</code> if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last port type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type
	* @throws com.kisti.science.platform.app.NoSuchPortTypeException if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last port type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type, or <code>null</code> if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the port types before and after the current port type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param portTypeId the primary key of the current port type
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next port type
	* @throws com.kisti.science.platform.app.NoSuchPortTypeException if a port type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType[] findByUuid_C_PrevAndNext(
		long portTypeId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(portTypeId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the port types where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of port types where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching port types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns the port type where name = &#63; or throws a {@link com.kisti.science.platform.app.NoSuchPortTypeException} if it could not be found.
	*
	* @param name the name
	* @return the matching port type
	* @throws com.kisti.science.platform.app.NoSuchPortTypeException if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType findByName(
		java.lang.String name)
		throws com.kisti.science.platform.app.NoSuchPortTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the port type where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching port type, or <code>null</code> if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the port type where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching port type, or <code>null</code> if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the port type where name = &#63; from the database.
	*
	* @param name the name
	* @return the port type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType removeByName(
		java.lang.String name)
		throws com.kisti.science.platform.app.NoSuchPortTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of port types where name = &#63;.
	*
	* @param name the name
	* @return the number of matching port types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Caches the port type in the entity cache if it is enabled.
	*
	* @param portType the port type
	*/
	public static void cacheResult(
		com.kisti.science.platform.app.model.PortType portType) {
		getPersistence().cacheResult(portType);
	}

	/**
	* Caches the port types in the entity cache if it is enabled.
	*
	* @param portTypes the port types
	*/
	public static void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.PortType> portTypes) {
		getPersistence().cacheResult(portTypes);
	}

	/**
	* Creates a new port type with the primary key. Does not add the port type to the database.
	*
	* @param portTypeId the primary key for the new port type
	* @return the new port type
	*/
	public static com.kisti.science.platform.app.model.PortType create(
		long portTypeId) {
		return getPersistence().create(portTypeId);
	}

	/**
	* Removes the port type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeId the primary key of the port type
	* @return the port type that was removed
	* @throws com.kisti.science.platform.app.NoSuchPortTypeException if a port type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType remove(
		long portTypeId)
		throws com.kisti.science.platform.app.NoSuchPortTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(portTypeId);
	}

	public static com.kisti.science.platform.app.model.PortType updateImpl(
		com.kisti.science.platform.app.model.PortType portType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(portType);
	}

	/**
	* Returns the port type with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchPortTypeException} if it could not be found.
	*
	* @param portTypeId the primary key of the port type
	* @return the port type
	* @throws com.kisti.science.platform.app.NoSuchPortTypeException if a port type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType findByPrimaryKey(
		long portTypeId)
		throws com.kisti.science.platform.app.NoSuchPortTypeException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(portTypeId);
	}

	/**
	* Returns the port type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param portTypeId the primary key of the port type
	* @return the port type, or <code>null</code> if a port type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType fetchByPrimaryKey(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(portTypeId);
	}

	/**
	* Returns all the port types.
	*
	* @return the port types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the port types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port types
	* @param end the upper bound of the range of port types (not inclusive)
	* @return the range of port types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the port types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port types
	* @param end the upper bound of the range of port types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of port types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the port types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of port types.
	*
	* @return the number of port types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PortTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PortTypePersistence)PortletBeanLocatorUtil.locate(com.kisti.science.platform.app.service.ClpSerializer.getServletContextName(),
					PortTypePersistence.class.getName());

			ReferenceRegistry.registerReference(PortTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PortTypePersistence persistence) {
	}

	private static PortTypePersistence _persistence;
}