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

import org.kisti.edison.science.model.ScienceApp;

/**
 * The persistence interface for the science app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see ScienceAppPersistenceImpl
 * @see ScienceAppUtil
 * @generated
 */
public interface ScienceAppPersistence extends BasePersistence<ScienceApp> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScienceAppUtil} to access the science app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the science apps where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByUuid_PrevAndNext(
		long scienceAppId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app where uuid = &#63; and groupId = &#63; or throws a {@link org.kisti.edison.science.NoSuchScienceAppException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the science app where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the science app where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the science app that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the number of science apps where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByUuid_C_PrevAndNext(
		long scienceAppId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where name = &#63;.
	*
	* @param name the name
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByName_PrevAndNext(
		long scienceAppId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where name = &#63;.
	*
	* @param name the name
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where appType = &#63;.
	*
	* @param appType the app type
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppType(
		java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppType(
		java.lang.String appType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppType(
		java.lang.String appType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app in the ordered set where appType = &#63;.
	*
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByAppType_First(
		java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where appType = &#63;.
	*
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAppType_First(
		java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app in the ordered set where appType = &#63;.
	*
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByAppType_Last(
		java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where appType = &#63;.
	*
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAppType_Last(
		java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByAppType_PrevAndNext(
		long scienceAppId, java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where appType = &#63; from the database.
	*
	* @param appType the app type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAppType(java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where appType = &#63;.
	*
	* @param appType the app type
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByAppType(java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where appType = &#63; and runType = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppRunType(
		java.lang.String appType, java.lang.String runType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppRunType(
		java.lang.String appType, java.lang.String runType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppRunType(
		java.lang.String appType, java.lang.String runType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAppRunType_First(
		java.lang.String appType, java.lang.String runType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where appType = &#63; and runType = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAppRunType_First(
		java.lang.String appType, java.lang.String runType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAppRunType_Last(
		java.lang.String appType, java.lang.String runType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where appType = &#63; and runType = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAppRunType_Last(
		java.lang.String appType, java.lang.String runType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByAppRunType_PrevAndNext(
		long scienceAppId, java.lang.String appType, java.lang.String runType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where appType = &#63; and runType = &#63; from the database.
	*
	* @param appType the app type
	* @param runType the run type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAppRunType(java.lang.String appType,
		java.lang.String runType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where appType = &#63; and runType = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByAppRunType(java.lang.String appType,
		java.lang.String runType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorId(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorId(
		long authorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorId(
		long authorId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByAuthorId_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAuthorId_First(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByAuthorId_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where authorId = &#63;.
	*
	* @param authorId the author ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAuthorId_Last(
		long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByAuthorId_PrevAndNext(
		long scienceAppId, long authorId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where authorId = &#63; from the database.
	*
	* @param authorId the author ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAuthorId(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where authorId = &#63;.
	*
	* @param authorId the author ID
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByAuthorId(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where stage = &#63;.
	*
	* @param stage the stage
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByStage(
		java.lang.String stage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByStage(
		java.lang.String stage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByStage(
		java.lang.String stage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app in the ordered set where stage = &#63;.
	*
	* @param stage the stage
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByStage_First(
		java.lang.String stage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where stage = &#63;.
	*
	* @param stage the stage
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByStage_First(
		java.lang.String stage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app in the ordered set where stage = &#63;.
	*
	* @param stage the stage
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByStage_Last(
		java.lang.String stage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where stage = &#63;.
	*
	* @param stage the stage
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByStage_Last(
		java.lang.String stage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByStage_PrevAndNext(
		long scienceAppId, java.lang.String stage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where stage = &#63; from the database.
	*
	* @param stage the stage
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStage(java.lang.String stage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where stage = &#63;.
	*
	* @param stage the stage
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByStage(java.lang.String stage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where status = &#63;.
	*
	* @param status the status
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByStatus_PrevAndNext(
		long scienceAppId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where status = &#63;.
	*
	* @param status the status
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where title LIKE &#63;.
	*
	* @param title the title
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByTitle_PrevAndNext(
		long scienceAppId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where title LIKE &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where title LIKE &#63;.
	*
	* @param title the title
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app where name = &#63; and version = &#63; or throws a {@link org.kisti.edison.science.NoSuchScienceAppException} if it could not be found.
	*
	* @param name the name
	* @param version the version
	* @return the matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByNameVersion(
		java.lang.String name, java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the science app where name = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param version the version
	* @return the matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByNameVersion(
		java.lang.String name, java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app where name = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param version the version
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByNameVersion(
		java.lang.String name, java.lang.String version,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the science app where name = &#63; and version = &#63; from the database.
	*
	* @param name the name
	* @param version the version
	* @return the science app that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp removeByNameVersion(
		java.lang.String name, java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the number of science apps where name = &#63; and version = &#63;.
	*
	* @param name the name
	* @param version the version
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByNameVersion(java.lang.String name,
		java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where authorId = &#63; and appType = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdAppType(
		long authorId, java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdAppType(
		long authorId, java.lang.String appType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdAppType(
		long authorId, java.lang.String appType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAuthorIdAppType_First(
		long authorId, java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where authorId = &#63; and appType = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAuthorIdAppType_First(
		long authorId, java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAuthorIdAppType_Last(
		long authorId, java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where authorId = &#63; and appType = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAuthorIdAppType_Last(
		long authorId, java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByAuthorIdAppType_PrevAndNext(
		long scienceAppId, long authorId, java.lang.String appType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where authorId = &#63; and appType = &#63; from the database.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAuthorIdAppType(long authorId, java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where authorId = &#63; and appType = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByAuthorIdAppType(long authorId, java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where authorId = &#63; and status = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdStatus(
		long authorId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdStatus(
		long authorId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdStatus(
		long authorId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAuthorIdStatus_First(
		long authorId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where authorId = &#63; and status = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAuthorIdStatus_First(
		long authorId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAuthorIdStatus_Last(
		long authorId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where authorId = &#63; and status = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAuthorIdStatus_Last(
		long authorId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByAuthorIdStatus_PrevAndNext(
		long scienceAppId, long authorId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where authorId = &#63; and status = &#63; from the database.
	*
	* @param authorId the author ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAuthorIdStatus(long authorId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where authorId = &#63; and status = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByAuthorIdStatus(long authorId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where openLevel = &#63;.
	*
	* @param openLevel the open level
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByOpenLevel(
		java.lang.String openLevel)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByOpenLevel(
		java.lang.String openLevel, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByOpenLevel(
		java.lang.String openLevel, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app in the ordered set where openLevel = &#63;.
	*
	* @param openLevel the open level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByOpenLevel_First(
		java.lang.String openLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where openLevel = &#63;.
	*
	* @param openLevel the open level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByOpenLevel_First(
		java.lang.String openLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app in the ordered set where openLevel = &#63;.
	*
	* @param openLevel the open level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByOpenLevel_Last(
		java.lang.String openLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where openLevel = &#63;.
	*
	* @param openLevel the open level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByOpenLevel_Last(
		java.lang.String openLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByOpenLevel_PrevAndNext(
		long scienceAppId, java.lang.String openLevel,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where openLevel = &#63; from the database.
	*
	* @param openLevel the open level
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOpenLevel(java.lang.String openLevel)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where openLevel = &#63;.
	*
	* @param openLevel the open level
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByOpenLevel(java.lang.String openLevel)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where name = &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameWithTarget(
		java.lang.String name, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameWithTarget(
		java.lang.String name, java.lang.String targetLanguage, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameWithTarget(
		java.lang.String name, java.lang.String targetLanguage, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByNameWithTarget_First(
		java.lang.String name, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where name = &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByNameWithTarget_First(
		java.lang.String name, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByNameWithTarget_Last(
		java.lang.String name, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where name = &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByNameWithTarget_Last(
		java.lang.String name, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByNameWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String name,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where name = &#63; and targetLanguage = &#63; from the database.
	*
	* @param name the name
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNameWithTarget(java.lang.String name,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where name = &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByNameWithTarget(java.lang.String name,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where appType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppTypeWithTarget(
		java.lang.String appType, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppTypeWithTarget(
		java.lang.String appType, java.lang.String targetLanguage, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppTypeWithTarget(
		java.lang.String appType, java.lang.String targetLanguage, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAppTypeWithTarget_First(
		java.lang.String appType, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where appType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAppTypeWithTarget_First(
		java.lang.String appType, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAppTypeWithTarget_Last(
		java.lang.String appType, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where appType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAppTypeWithTarget_Last(
		java.lang.String appType, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByAppTypeWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String appType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where appType = &#63; and targetLanguage = &#63; from the database.
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAppTypeWithTarget(java.lang.String appType,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where appType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByAppTypeWithTarget(java.lang.String appType,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppRunTypeWithTarget(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppRunTypeWithTarget(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAppRunTypeWithTarget(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAppRunTypeWithTarget_First(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

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
	public org.kisti.edison.science.model.ScienceApp fetchByAppRunTypeWithTarget_First(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAppRunTypeWithTarget_Last(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

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
	public org.kisti.edison.science.model.ScienceApp fetchByAppRunTypeWithTarget_Last(
		java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByAppRunTypeWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String appType, java.lang.String runType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where appType = &#63; and runType = &#63; and targetLanguage = &#63; from the database.
	*
	* @param appType the app type
	* @param runType the run type
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAppRunTypeWithTarget(java.lang.String appType,
		java.lang.String runType, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	*
	* @param appType the app type
	* @param runType the run type
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByAppRunTypeWithTarget(java.lang.String appType,
		java.lang.String runType, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where authorId = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdWithTarget(
		long authorId, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdWithTarget(
		long authorId, java.lang.String targetLanguage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdWithTarget(
		long authorId, java.lang.String targetLanguage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAuthorIdWithTarget_First(
		long authorId, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where authorId = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAuthorIdWithTarget_First(
		long authorId, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAuthorIdWithTarget_Last(
		long authorId, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where authorId = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByAuthorIdWithTarget_Last(
		long authorId, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByAuthorIdWithTarget_PrevAndNext(
		long scienceAppId, long authorId, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where authorId = &#63; and targetLanguage = &#63; from the database.
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAuthorIdWithTarget(long authorId,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where authorId = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByAuthorIdWithTarget(long authorId,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where stage = &#63; and targetLanguage = &#63;.
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByStageWithTarget(
		java.lang.String stage, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByStageWithTarget(
		java.lang.String stage, java.lang.String targetLanguage, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByStageWithTarget(
		java.lang.String stage, java.lang.String targetLanguage, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByStageWithTarget_First(
		java.lang.String stage, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where stage = &#63; and targetLanguage = &#63;.
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByStageWithTarget_First(
		java.lang.String stage, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByStageWithTarget_Last(
		java.lang.String stage, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where stage = &#63; and targetLanguage = &#63;.
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByStageWithTarget_Last(
		java.lang.String stage, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByStageWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String stage,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where stage = &#63; and targetLanguage = &#63; from the database.
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStageWithTarget(java.lang.String stage,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where stage = &#63; and targetLanguage = &#63;.
	*
	* @param stage the stage
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByStageWithTarget(java.lang.String stage,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where status = &#63; and targetLanguage = &#63;.
	*
	* @param status the status
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByStatusWithTarget(
		int status, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByStatusWithTarget(
		int status, java.lang.String targetLanguage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByStatusWithTarget(
		int status, java.lang.String targetLanguage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByStatusWithTarget_First(
		int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where status = &#63; and targetLanguage = &#63;.
	*
	* @param status the status
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByStatusWithTarget_First(
		int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByStatusWithTarget_Last(
		int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where status = &#63; and targetLanguage = &#63;.
	*
	* @param status the status
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByStatusWithTarget_Last(
		int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByStatusWithTarget_PrevAndNext(
		long scienceAppId, int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where status = &#63; and targetLanguage = &#63; from the database.
	*
	* @param status the status
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatusWithTarget(int status,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where status = &#63; and targetLanguage = &#63;.
	*
	* @param status the status
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatusWithTarget(int status,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param title the title
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByTitleWithTarget(
		java.lang.String title, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByTitleWithTarget(
		java.lang.String title, java.lang.String targetLanguage, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByTitleWithTarget(
		java.lang.String title, java.lang.String targetLanguage, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByTitleWithTarget_First(
		java.lang.String title, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param title the title
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByTitleWithTarget_First(
		java.lang.String title, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByTitleWithTarget_Last(
		java.lang.String title, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param title the title
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByTitleWithTarget_Last(
		java.lang.String title, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByTitleWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String title,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where title LIKE &#63; and targetLanguage = &#63; from the database.
	*
	* @param title the title
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitleWithTarget(java.lang.String title,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param title the title
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitleWithTarget(java.lang.String title,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdAppTypeWithTarget(
		long authorId, java.lang.String appType, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdAppTypeWithTarget(
		long authorId, java.lang.String appType,
		java.lang.String targetLanguage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdAppTypeWithTarget(
		long authorId, java.lang.String appType,
		java.lang.String targetLanguage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAuthorIdAppTypeWithTarget_First(
		long authorId, java.lang.String appType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

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
	public org.kisti.edison.science.model.ScienceApp fetchByAuthorIdAppTypeWithTarget_First(
		long authorId, java.lang.String appType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAuthorIdAppTypeWithTarget_Last(
		long authorId, java.lang.String appType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

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
	public org.kisti.edison.science.model.ScienceApp fetchByAuthorIdAppTypeWithTarget_Last(
		long authorId, java.lang.String appType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByAuthorIdAppTypeWithTarget_PrevAndNext(
		long scienceAppId, long authorId, java.lang.String appType,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where authorId = &#63; and appType = &#63; and targetLanguage = &#63; from the database.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAuthorIdAppTypeWithTarget(long authorId,
		java.lang.String appType, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param appType the app type
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByAuthorIdAppTypeWithTarget(long authorId,
		java.lang.String appType, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdStatusWithTarget(
		long authorId, int status, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdStatusWithTarget(
		long authorId, int status, java.lang.String targetLanguage, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByAuthorIdStatusWithTarget(
		long authorId, int status, java.lang.String targetLanguage, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAuthorIdStatusWithTarget_First(
		long authorId, int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

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
	public org.kisti.edison.science.model.ScienceApp fetchByAuthorIdStatusWithTarget_First(
		long authorId, int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByAuthorIdStatusWithTarget_Last(
		long authorId, int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

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
	public org.kisti.edison.science.model.ScienceApp fetchByAuthorIdStatusWithTarget_Last(
		long authorId, int status, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByAuthorIdStatusWithTarget_PrevAndNext(
		long scienceAppId, long authorId, int status,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where authorId = &#63; and status = &#63; and targetLanguage = &#63; from the database.
	*
	* @param authorId the author ID
	* @param status the status
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAuthorIdStatusWithTarget(long authorId, int status,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	*
	* @param authorId the author ID
	* @param status the status
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByAuthorIdStatusWithTarget(long authorId, int status,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where openLevel = &#63; and targetLanguage = &#63;.
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByOpenLevelWithTarget(
		java.lang.String openLevel, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByOpenLevelWithTarget(
		java.lang.String openLevel, java.lang.String targetLanguage, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByOpenLevelWithTarget(
		java.lang.String openLevel, java.lang.String targetLanguage, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByOpenLevelWithTarget_First(
		java.lang.String openLevel, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the first science app in the ordered set where openLevel = &#63; and targetLanguage = &#63;.
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByOpenLevelWithTarget_First(
		java.lang.String openLevel, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByOpenLevelWithTarget_Last(
		java.lang.String openLevel, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the last science app in the ordered set where openLevel = &#63; and targetLanguage = &#63;.
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByOpenLevelWithTarget_Last(
		java.lang.String openLevel, java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByOpenLevelWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String openLevel,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Removes all the science apps where openLevel = &#63; and targetLanguage = &#63; from the database.
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOpenLevelWithTarget(java.lang.String openLevel,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where openLevel = &#63; and targetLanguage = &#63;.
	*
	* @param openLevel the open level
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByOpenLevelWithTarget(java.lang.String openLevel,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param title the title
	* @param targetLanguage the target language
	* @return the matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameTitleWithTarget(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameTitleWithTarget(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameTitleWithTarget(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByNameTitleWithTarget_First(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

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
	public org.kisti.edison.science.model.ScienceApp fetchByNameTitleWithTarget_First(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp findByNameTitleWithTarget_Last(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

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
	public org.kisti.edison.science.model.ScienceApp fetchByNameTitleWithTarget_Last(
		java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.science.model.ScienceApp[] findByNameTitleWithTarget_PrevAndNext(
		long scienceAppId, java.lang.String name, java.lang.String title,
		java.lang.String targetLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameTitleWithTarget(
		java.lang.String[] names, java.lang.String[] titles,
		java.lang.String[] targetLanguages)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameTitleWithTarget(
		java.lang.String[] names, java.lang.String[] titles,
		java.lang.String[] targetLanguages, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findByNameTitleWithTarget(
		java.lang.String[] names, java.lang.String[] titles,
		java.lang.String[] targetLanguages, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the science apps where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63; from the database.
	*
	* @param name the name
	* @param title the title
	* @param targetLanguage the target language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByNameTitleWithTarget(java.lang.String name,
		java.lang.String title, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	*
	* @param name the name
	* @param title the title
	* @param targetLanguage the target language
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByNameTitleWithTarget(java.lang.String name,
		java.lang.String title, java.lang.String targetLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps where name LIKE any &#63; and title LIKE any &#63; and targetLanguage = all &#63;.
	*
	* @param names the names
	* @param titles the titles
	* @param targetLanguages the target languages
	* @return the number of matching science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countByNameTitleWithTarget(java.lang.String[] names,
		java.lang.String[] titles, java.lang.String[] targetLanguages)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the science app in the entity cache if it is enabled.
	*
	* @param scienceApp the science app
	*/
	public void cacheResult(
		org.kisti.edison.science.model.ScienceApp scienceApp);

	/**
	* Caches the science apps in the entity cache if it is enabled.
	*
	* @param scienceApps the science apps
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.science.model.ScienceApp> scienceApps);

	/**
	* Creates a new science app with the primary key. Does not add the science app to the database.
	*
	* @param scienceAppId the primary key for the new science app
	* @return the new science app
	*/
	public org.kisti.edison.science.model.ScienceApp create(long scienceAppId);

	/**
	* Removes the science app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppId the primary key of the science app
	* @return the science app that was removed
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp remove(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	public org.kisti.edison.science.model.ScienceApp updateImpl(
		org.kisti.edison.science.model.ScienceApp scienceApp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app with the primary key or throws a {@link org.kisti.edison.science.NoSuchScienceAppException} if it could not be found.
	*
	* @param scienceAppId the primary key of the science app
	* @return the science app
	* @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp findByPrimaryKey(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	/**
	* Returns the science app with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scienceAppId the primary key of the science app
	* @return the science app, or <code>null</code> if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceApp fetchByPrimaryKey(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science apps.
	*
	* @return the science apps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.science.model.ScienceApp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the science apps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps.
	*
	* @return the number of science apps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}