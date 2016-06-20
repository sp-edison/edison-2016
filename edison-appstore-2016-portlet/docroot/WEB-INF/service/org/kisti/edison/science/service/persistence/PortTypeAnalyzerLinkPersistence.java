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

import com.liferay.portal.service.persistence.BasePersistence;

import org.kisti.edison.science.model.PortTypeAnalyzerLink;

/**
 * The persistence interface for the port type analyzer link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see PortTypeAnalyzerLinkPersistenceImpl
 * @see PortTypeAnalyzerLinkUtil
 * @generated
 */
public interface PortTypeAnalyzerLinkPersistence extends BasePersistence<PortTypeAnalyzerLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PortTypeAnalyzerLinkUtil} to access the port type analyzer link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the port type analyzer links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.PortTypeAnalyzerLink> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the port type analyzer links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @return the range of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.PortTypeAnalyzerLink> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the port type analyzer links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.PortTypeAnalyzerLink> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first port type analyzer link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type analyzer link
	* @throws org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException;

	/**
	* Returns the first port type analyzer link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last port type analyzer link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type analyzer link
	* @throws org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException;

	/**
	* Returns the last port type analyzer link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the port type analyzer links before and after the current port type analyzer link in the ordered set where uuid = &#63;.
	*
	* @param portTypeAnalyzerLinkId the primary key of the current port type analyzer link
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next port type analyzer link
	* @throws org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink[] findByUuid_PrevAndNext(
		long portTypeAnalyzerLinkId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException;

	/**
	* Removes all the port type analyzer links where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of port type analyzer links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the port type analyzer links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.PortTypeAnalyzerLink> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the port type analyzer links where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @return the range of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.PortTypeAnalyzerLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the port type analyzer links where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List<org.kisti.edison.science.model.PortTypeAnalyzerLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type analyzer link
	* @throws org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException;

	/**
	* Returns the first port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type analyzer link
	* @throws org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException;

	/**
	* Returns the last port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the port type analyzer links before and after the current port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param portTypeAnalyzerLinkId the primary key of the current port type analyzer link
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next port type analyzer link
	* @throws org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink[] findByUuid_C_PrevAndNext(
		long portTypeAnalyzerLinkId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException;

	/**
	* Removes all the port type analyzer links where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of port type analyzer links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the port type analyzer links where companyId = &#63; and portTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param portTypeId the port type ID
	* @return the matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.PortTypeAnalyzerLink> findByPortTypeId(
		long companyId, long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the port type analyzer links where companyId = &#63; and portTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param portTypeId the port type ID
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @return the range of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.PortTypeAnalyzerLink> findByPortTypeId(
		long companyId, long portTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the port type analyzer links where companyId = &#63; and portTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param portTypeId the port type ID
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.PortTypeAnalyzerLink> findByPortTypeId(
		long companyId, long portTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first port type analyzer link in the ordered set where companyId = &#63; and portTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type analyzer link
	* @throws org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink findByPortTypeId_First(
		long companyId, long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException;

	/**
	* Returns the first port type analyzer link in the ordered set where companyId = &#63; and portTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink fetchByPortTypeId_First(
		long companyId, long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last port type analyzer link in the ordered set where companyId = &#63; and portTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type analyzer link
	* @throws org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink findByPortTypeId_Last(
		long companyId, long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException;

	/**
	* Returns the last port type analyzer link in the ordered set where companyId = &#63; and portTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink fetchByPortTypeId_Last(
		long companyId, long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the port type analyzer links before and after the current port type analyzer link in the ordered set where companyId = &#63; and portTypeId = &#63;.
	*
	* @param portTypeAnalyzerLinkId the primary key of the current port type analyzer link
	* @param companyId the company ID
	* @param portTypeId the port type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next port type analyzer link
	* @throws org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink[] findByPortTypeId_PrevAndNext(
		long portTypeAnalyzerLinkId, long companyId, long portTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException;

	/**
	* Removes all the port type analyzer links where companyId = &#63; and portTypeId = &#63; from the database.
	*
	* @param companyId the company ID
	* @param portTypeId the port type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPortTypeId(long companyId, long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of port type analyzer links where companyId = &#63; and portTypeId = &#63;.
	*
	* @param companyId the company ID
	* @param portTypeId the port type ID
	* @return the number of matching port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public int countByPortTypeId(long companyId, long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the port type analyzer link in the entity cache if it is enabled.
	*
	* @param portTypeAnalyzerLink the port type analyzer link
	*/
	public void cacheResult(
		org.kisti.edison.science.model.PortTypeAnalyzerLink portTypeAnalyzerLink);

	/**
	* Caches the port type analyzer links in the entity cache if it is enabled.
	*
	* @param portTypeAnalyzerLinks the port type analyzer links
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.science.model.PortTypeAnalyzerLink> portTypeAnalyzerLinks);

	/**
	* Creates a new port type analyzer link with the primary key. Does not add the port type analyzer link to the database.
	*
	* @param portTypeAnalyzerLinkId the primary key for the new port type analyzer link
	* @return the new port type analyzer link
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink create(
		long portTypeAnalyzerLinkId);

	/**
	* Removes the port type analyzer link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeAnalyzerLinkId the primary key of the port type analyzer link
	* @return the port type analyzer link that was removed
	* @throws org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink remove(
		long portTypeAnalyzerLinkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException;

	public org.kisti.edison.science.model.PortTypeAnalyzerLink updateImpl(
		org.kisti.edison.science.model.PortTypeAnalyzerLink portTypeAnalyzerLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the port type analyzer link with the primary key or throws a {@link org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException} if it could not be found.
	*
	* @param portTypeAnalyzerLinkId the primary key of the port type analyzer link
	* @return the port type analyzer link
	* @throws org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink findByPrimaryKey(
		long portTypeAnalyzerLinkId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchPortTypeAnalyzerLinkException;

	/**
	* Returns the port type analyzer link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param portTypeAnalyzerLinkId the primary key of the port type analyzer link
	* @return the port type analyzer link, or <code>null</code> if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.PortTypeAnalyzerLink fetchByPrimaryKey(
		long portTypeAnalyzerLinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the port type analyzer links.
	*
	* @return the port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.PortTypeAnalyzerLink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the port type analyzer links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @return the range of port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.PortTypeAnalyzerLink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the port type analyzer links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.PortTypeAnalyzerLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the port type analyzer links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of port type analyzer links.
	*
	* @return the number of port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}