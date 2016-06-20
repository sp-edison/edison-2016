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

import com.kisti.science.platform.app.model.PortTypeEditorLink;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the port type editor link service. This utility wraps {@link PortTypeEditorLinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeEditorLinkPersistence
 * @see PortTypeEditorLinkPersistenceImpl
 * @generated
 */
public class PortTypeEditorLinkUtil {
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
	public static void clearCache(PortTypeEditorLink portTypeEditorLink) {
		getPersistence().clearCache(portTypeEditorLink);
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
	public static List<PortTypeEditorLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PortTypeEditorLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PortTypeEditorLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PortTypeEditorLink update(
		PortTypeEditorLink portTypeEditorLink) throws SystemException {
		return getPersistence().update(portTypeEditorLink);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PortTypeEditorLink update(
		PortTypeEditorLink portTypeEditorLink, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(portTypeEditorLink, serviceContext);
	}

	/**
	* Returns all the port type editor links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the port type editor links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of port type editor links
	* @param end the upper bound of the range of port type editor links (not inclusive)
	* @return the range of matching port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the port type editor links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of port type editor links
	* @param end the upper bound of the range of port type editor links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first port type editor link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type editor link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first port type editor link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last port type editor link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type editor link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last port type editor link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the port type editor links before and after the current port type editor link in the ordered set where uuid = &#63;.
	*
	* @param portTypeEditorLinkId the primary key of the current port type editor link
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next port type editor link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a port type editor link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink[] findByUuid_PrevAndNext(
		long portTypeEditorLinkId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(portTypeEditorLinkId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the port type editor links where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of port type editor links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the port type editor links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the port type editor links where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of port type editor links
	* @param end the upper bound of the range of port type editor links (not inclusive)
	* @return the range of matching port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the port type editor links where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of port type editor links
	* @param end the upper bound of the range of port type editor links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first port type editor link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type editor link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first port type editor link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last port type editor link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type editor link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last port type editor link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the port type editor links before and after the current port type editor link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param portTypeEditorLinkId the primary key of the current port type editor link
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next port type editor link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a port type editor link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink[] findByUuid_C_PrevAndNext(
		long portTypeEditorLinkId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(portTypeEditorLinkId, uuid,
			companyId, orderByComparator);
	}

	/**
	* Removes all the port type editor links where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of port type editor links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the port type editor links where portTypeId = &#63;.
	*
	* @param portTypeId the port type ID
	* @return the matching port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> findByPortTypeId(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPortTypeId(portTypeId);
	}

	/**
	* Returns a range of all the port type editor links where portTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param portTypeId the port type ID
	* @param start the lower bound of the range of port type editor links
	* @param end the upper bound of the range of port type editor links (not inclusive)
	* @return the range of matching port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> findByPortTypeId(
		long portTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPortTypeId(portTypeId, start, end);
	}

	/**
	* Returns an ordered range of all the port type editor links where portTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param portTypeId the port type ID
	* @param start the lower bound of the range of port type editor links
	* @param end the upper bound of the range of port type editor links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> findByPortTypeId(
		long portTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPortTypeId(portTypeId, start, end, orderByComparator);
	}

	/**
	* Returns the first port type editor link in the ordered set where portTypeId = &#63;.
	*
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type editor link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink findByPortTypeId_First(
		long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPortTypeId_First(portTypeId, orderByComparator);
	}

	/**
	* Returns the first port type editor link in the ordered set where portTypeId = &#63;.
	*
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink fetchByPortTypeId_First(
		long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPortTypeId_First(portTypeId, orderByComparator);
	}

	/**
	* Returns the last port type editor link in the ordered set where portTypeId = &#63;.
	*
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type editor link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink findByPortTypeId_Last(
		long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPortTypeId_Last(portTypeId, orderByComparator);
	}

	/**
	* Returns the last port type editor link in the ordered set where portTypeId = &#63;.
	*
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink fetchByPortTypeId_Last(
		long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPortTypeId_Last(portTypeId, orderByComparator);
	}

	/**
	* Returns the port type editor links before and after the current port type editor link in the ordered set where portTypeId = &#63;.
	*
	* @param portTypeEditorLinkId the primary key of the current port type editor link
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next port type editor link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a port type editor link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink[] findByPortTypeId_PrevAndNext(
		long portTypeEditorLinkId, long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPortTypeId_PrevAndNext(portTypeEditorLinkId,
			portTypeId, orderByComparator);
	}

	/**
	* Removes all the port type editor links where portTypeId = &#63; from the database.
	*
	* @param portTypeId the port type ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPortTypeId(long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPortTypeId(portTypeId);
	}

	/**
	* Returns the number of port type editor links where portTypeId = &#63;.
	*
	* @param portTypeId the port type ID
	* @return the number of matching port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPortTypeId(long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPortTypeId(portTypeId);
	}

	/**
	* Caches the port type editor link in the entity cache if it is enabled.
	*
	* @param portTypeEditorLink the port type editor link
	*/
	public static void cacheResult(
		com.kisti.science.platform.app.model.PortTypeEditorLink portTypeEditorLink) {
		getPersistence().cacheResult(portTypeEditorLink);
	}

	/**
	* Caches the port type editor links in the entity cache if it is enabled.
	*
	* @param portTypeEditorLinks the port type editor links
	*/
	public static void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> portTypeEditorLinks) {
		getPersistence().cacheResult(portTypeEditorLinks);
	}

	/**
	* Creates a new port type editor link with the primary key. Does not add the port type editor link to the database.
	*
	* @param portTypeEditorLinkId the primary key for the new port type editor link
	* @return the new port type editor link
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink create(
		long portTypeEditorLinkId) {
		return getPersistence().create(portTypeEditorLinkId);
	}

	/**
	* Removes the port type editor link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeEditorLinkId the primary key of the port type editor link
	* @return the port type editor link that was removed
	* @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a port type editor link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink remove(
		long portTypeEditorLinkId)
		throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(portTypeEditorLinkId);
	}

	public static com.kisti.science.platform.app.model.PortTypeEditorLink updateImpl(
		com.kisti.science.platform.app.model.PortTypeEditorLink portTypeEditorLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(portTypeEditorLink);
	}

	/**
	* Returns the port type editor link with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException} if it could not be found.
	*
	* @param portTypeEditorLinkId the primary key of the port type editor link
	* @return the port type editor link
	* @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a port type editor link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink findByPrimaryKey(
		long portTypeEditorLinkId)
		throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(portTypeEditorLinkId);
	}

	/**
	* Returns the port type editor link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param portTypeEditorLinkId the primary key of the port type editor link
	* @return the port type editor link, or <code>null</code> if a port type editor link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink fetchByPrimaryKey(
		long portTypeEditorLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(portTypeEditorLinkId);
	}

	/**
	* Returns all the port type editor links.
	*
	* @return the port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the port type editor links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type editor links
	* @param end the upper bound of the range of port type editor links (not inclusive)
	* @return the range of port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the port type editor links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type editor links
	* @param end the upper bound of the range of port type editor links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the port type editor links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of port type editor links.
	*
	* @return the number of port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PortTypeEditorLinkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PortTypeEditorLinkPersistence)PortletBeanLocatorUtil.locate(com.kisti.science.platform.app.service.ClpSerializer.getServletContextName(),
					PortTypeEditorLinkPersistence.class.getName());

			ReferenceRegistry.registerReference(PortTypeEditorLinkUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PortTypeEditorLinkPersistence persistence) {
	}

	private static PortTypeEditorLinkPersistence _persistence;
}