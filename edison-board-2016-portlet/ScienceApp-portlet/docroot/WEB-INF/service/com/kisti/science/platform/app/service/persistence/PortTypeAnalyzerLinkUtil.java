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

import com.kisti.science.platform.app.model.PortTypeAnalyzerLink;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the port type analyzer link service. This utility wraps {@link PortTypeAnalyzerLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeAnalyzerLinkPersistence
 * @see PortTypeAnalyzerLinkPersistenceImpl
 * @generated
 */
public class PortTypeAnalyzerLinkUtil {
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
	public static void clearCache(PortTypeAnalyzerLink portTypeAnalyzerLink) {
		getPersistence().clearCache(portTypeAnalyzerLink);
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
	public static List<PortTypeAnalyzerLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PortTypeAnalyzerLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PortTypeAnalyzerLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PortTypeAnalyzerLink update(
		PortTypeAnalyzerLink portTypeAnalyzerLink) throws SystemException {
		return getPersistence().update(portTypeAnalyzerLink);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PortTypeAnalyzerLink update(
		PortTypeAnalyzerLink portTypeAnalyzerLink, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(portTypeAnalyzerLink, serviceContext);
	}

	/**
	* Returns all the port type analyzer links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the port type analyzer links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @return the range of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the port type analyzer links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first port type analyzer link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type analyzer link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first port type analyzer link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last port type analyzer link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type analyzer link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last port type analyzer link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the port type analyzer links before and after the current port type analyzer link in the ordered set where uuid = &#63;.
	*
	* @param portTypeAnalyzerLinkId the primary key of the current port type analyzer link
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next port type analyzer link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink[] findByUuid_PrevAndNext(
		long portTypeAnalyzerLinkId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(portTypeAnalyzerLinkId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the port type analyzer links where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of port type analyzer links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the port type analyzer links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the port type analyzer links where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @return the range of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the port type analyzer links where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type analyzer link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type analyzer link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the port type analyzer links before and after the current port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param portTypeAnalyzerLinkId the primary key of the current port type analyzer link
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next port type analyzer link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink[] findByUuid_C_PrevAndNext(
		long portTypeAnalyzerLinkId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(portTypeAnalyzerLinkId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the port type analyzer links where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of port type analyzer links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the port type analyzer links where portTypeId = &#63;.
	*
	* @param portTypeId the port type ID
	* @return the matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> findByPortTypeId(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPortTypeId(portTypeId);
	}

	/**
	* Returns a range of all the port type analyzer links where portTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param portTypeId the port type ID
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @return the range of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> findByPortTypeId(
		long portTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPortTypeId(portTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the port type analyzer links where portTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param portTypeId the port type ID
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> findByPortTypeId(
		long portTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPortTypeId(portTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first port type analyzer link in the ordered set where portTypeId = &#63;.
	*
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type analyzer link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink findByPortTypeId_First(
		long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPortTypeId_First(portTypeId, orderByComparator);
	}

	/**
	* Returns the first port type analyzer link in the ordered set where portTypeId = &#63;.
	*
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink fetchByPortTypeId_First(
		long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPortTypeId_First(portTypeId, orderByComparator);
	}

	/**
	* Returns the last port type analyzer link in the ordered set where portTypeId = &#63;.
	*
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type analyzer link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink findByPortTypeId_Last(
		long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPortTypeId_Last(portTypeId, orderByComparator);
	}

	/**
	* Returns the last port type analyzer link in the ordered set where portTypeId = &#63;.
	*
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink fetchByPortTypeId_Last(
		long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPortTypeId_Last(portTypeId, orderByComparator);
	}

	/**
	* Returns the port type analyzer links before and after the current port type analyzer link in the ordered set where portTypeId = &#63;.
	*
	* @param portTypeAnalyzerLinkId the primary key of the current port type analyzer link
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next port type analyzer link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink[] findByPortTypeId_PrevAndNext(
		long portTypeAnalyzerLinkId, long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPortTypeId_PrevAndNext(portTypeAnalyzerLinkId,
			portTypeId, orderByComparator);
	}

	/**
	* Removes all the port type analyzer links where portTypeId = &#63; from the database.
	*
	* @param portTypeId the port type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPortTypeId(long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPortTypeId(portTypeId);
	}

	/**
	* Returns the number of port type analyzer links where portTypeId = &#63;.
	*
	* @param portTypeId the port type ID
	* @return the number of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPortTypeId(long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPortTypeId(portTypeId);
	}

	/**
	* Caches the port type analyzer link in the entity cache if it is enabled.
	*
	* @param portTypeAnalyzerLink the port type analyzer link
	*/
	public static void cacheResult(
		com.kisti.science.platform.app.model.PortTypeAnalyzerLink portTypeAnalyzerLink) {
		getPersistence().cacheResult(portTypeAnalyzerLink);
	}

	/**
	* Caches the port type analyzer links in the entity cache if it is enabled.
	*
	* @param portTypeAnalyzerLinks the port type analyzer links
	*/
	public static void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> portTypeAnalyzerLinks) {
		getPersistence().cacheResult(portTypeAnalyzerLinks);
	}

	/**
	* Creates a new port type analyzer link with the primary key. Does not add the port type analyzer link to the database.
	*
	* @param portTypeAnalyzerLinkId the primary key for the new port type analyzer link
	* @return the new port type analyzer link
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink create(
		long portTypeAnalyzerLinkId) {
		return getPersistence().create(portTypeAnalyzerLinkId);
	}

	/**
	* Removes the port type analyzer link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeAnalyzerLinkId the primary key of the port type analyzer link
	* @return the port type analyzer link that was removed
	* @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink remove(
		long portTypeAnalyzerLinkId)
		throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(portTypeAnalyzerLinkId);
	}

	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink updateImpl(
		com.kisti.science.platform.app.model.PortTypeAnalyzerLink portTypeAnalyzerLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(portTypeAnalyzerLink);
	}

	/**
	* Returns the port type analyzer link with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException} if it could not be found.
	*
	* @param portTypeAnalyzerLinkId the primary key of the port type analyzer link
	* @return the port type analyzer link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink findByPrimaryKey(
		long portTypeAnalyzerLinkId)
		throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(portTypeAnalyzerLinkId);
	}

	/**
	* Returns the port type analyzer link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param portTypeAnalyzerLinkId the primary key of the port type analyzer link
	* @return the port type analyzer link, or <code>null</code> if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeAnalyzerLink fetchByPrimaryKey(
		long portTypeAnalyzerLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(portTypeAnalyzerLinkId);
	}

	/**
	* Returns all the port type analyzer links.
	*
	* @return the port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the port type analyzer links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @return the range of port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the port type analyzer links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the port type analyzer links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of port type analyzer links.
	*
	* @return the number of port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PortTypeAnalyzerLinkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PortTypeAnalyzerLinkPersistence)PortletBeanLocatorUtil.locate(com.kisti.science.platform.app.service.ClpSerializer.getServletContextName(),
					PortTypeAnalyzerLinkPersistence.class.getName());

			ReferenceRegistry.registerReference(PortTypeAnalyzerLinkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PortTypeAnalyzerLinkPersistence persistence) {
	}

	private static PortTypeAnalyzerLinkPersistence _persistence;
}