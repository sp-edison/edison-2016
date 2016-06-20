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

import com.kisti.science.platform.app.model.ScienceAppCategoryLink;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the science app category link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppCategoryLinkPersistenceImpl
 * @see ScienceAppCategoryLinkUtil
 * @generated
 */
public interface ScienceAppCategoryLinkPersistence extends BasePersistence<ScienceAppCategoryLink> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScienceAppCategoryLinkUtil} to access the science app category link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the science app category links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the science app category links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of science app category links
	* @param end the upper bound of the range of science app category links (not inclusive)
	* @return the range of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the science app category links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of science app category links
	* @param end the upper bound of the range of science app category links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app category link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app category link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app category link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app category link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category links before and after the current science app category link in the ordered set where uuid = &#63;.
	*
	* @param scienceAppCategoryLinkId the primary key of the current science app category link
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink[] findByUuid_PrevAndNext(
		long scienceAppCategoryLinkId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the science app category links where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science app category links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category link where uuid = &#63; and groupId = &#63; or throws a {@link com.kisti.science.platform.app.NoSuchCategoryLinkException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the science app category link where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the science app category link that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science app category links where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science app category links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the science app category links where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of science app category links
	* @param end the upper bound of the range of science app category links (not inclusive)
	* @return the range of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the science app category links where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of science app category links
	* @param end the upper bound of the range of science app category links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app category link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app category link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app category link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app category link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category links before and after the current science app category link in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param scienceAppCategoryLinkId the primary key of the current science app category link
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink[] findByUuid_C_PrevAndNext(
		long scienceAppCategoryLinkId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the science app category links where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science app category links where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science app category links where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByCategoryId(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the science app category links where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of science app category links
	* @param end the upper bound of the range of science app category links (not inclusive)
	* @return the range of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByCategoryId(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the science app category links where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of science app category links
	* @param end the upper bound of the range of science app category links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByCategoryId(
		long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app category link in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink findByCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app category link in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchByCategoryId_First(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app category link in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink findByCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app category link in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchByCategoryId_Last(
		long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category links before and after the current science app category link in the ordered set where categoryId = &#63;.
	*
	* @param scienceAppCategoryLinkId the primary key of the current science app category link
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink[] findByCategoryId_PrevAndNext(
		long scienceAppCategoryLinkId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the science app category links where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science app category links where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science app category links where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @return the matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByAppId(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the science app category links where scienceAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scienceAppId the science app ID
	* @param start the lower bound of the range of science app category links
	* @param end the upper bound of the range of science app category links (not inclusive)
	* @return the range of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByAppId(
		long scienceAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the science app category links where scienceAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scienceAppId the science app ID
	* @param start the lower bound of the range of science app category links
	* @param end the upper bound of the range of science app category links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByAppId(
		long scienceAppId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app category link in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink findByAppId_First(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app category link in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchByAppId_First(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app category link in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink findByAppId_Last(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app category link in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchByAppId_Last(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category links before and after the current science app category link in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppCategoryLinkId the primary key of the current science app category link
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink[] findByAppId_PrevAndNext(
		long scienceAppCategoryLinkId, long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the science app category links where scienceAppId = &#63; from the database.
	*
	* @param scienceAppId the science app ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science app category links where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @return the number of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public int countByAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science app category links where parentCategoryId = &#63;.
	*
	* @param parentCategoryId the parent category ID
	* @return the matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByParentCategoryId(
		long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the science app category links where parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentCategoryId the parent category ID
	* @param start the lower bound of the range of science app category links
	* @param end the upper bound of the range of science app category links (not inclusive)
	* @return the range of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByParentCategoryId(
		long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the science app category links where parentCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentCategoryId the parent category ID
	* @param start the lower bound of the range of science app category links
	* @param end the upper bound of the range of science app category links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findByParentCategoryId(
		long parentCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app category link in the ordered set where parentCategoryId = &#63;.
	*
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink findByParentCategoryId_First(
		long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app category link in the ordered set where parentCategoryId = &#63;.
	*
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchByParentCategoryId_First(
		long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app category link in the ordered set where parentCategoryId = &#63;.
	*
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink findByParentCategoryId_Last(
		long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app category link in the ordered set where parentCategoryId = &#63;.
	*
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchByParentCategoryId_Last(
		long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category links before and after the current science app category link in the ordered set where parentCategoryId = &#63;.
	*
	* @param scienceAppCategoryLinkId the primary key of the current science app category link
	* @param parentCategoryId the parent category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink[] findByParentCategoryId_PrevAndNext(
		long scienceAppCategoryLinkId, long parentCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the science app category links where parentCategoryId = &#63; from the database.
	*
	* @param parentCategoryId the parent category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByParentCategoryId(long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science app category links where parentCategoryId = &#63;.
	*
	* @param parentCategoryId the parent category ID
	* @return the number of matching science app category links
	* @throws SystemException if a system exception occurred
	*/
	public int countByParentCategoryId(long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the science app category link in the entity cache if it is enabled.
	*
	* @param scienceAppCategoryLink the science app category link
	*/
	public void cacheResult(
		com.kisti.science.platform.app.model.ScienceAppCategoryLink scienceAppCategoryLink);

	/**
	* Caches the science app category links in the entity cache if it is enabled.
	*
	* @param scienceAppCategoryLinks the science app category links
	*/
	public void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> scienceAppCategoryLinks);

	/**
	* Creates a new science app category link with the primary key. Does not add the science app category link to the database.
	*
	* @param scienceAppCategoryLinkId the primary key for the new science app category link
	* @return the new science app category link
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink create(
		long scienceAppCategoryLinkId);

	/**
	* Removes the science app category link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppCategoryLinkId the primary key of the science app category link
	* @return the science app category link that was removed
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink remove(
		long scienceAppCategoryLinkId)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kisti.science.platform.app.model.ScienceAppCategoryLink updateImpl(
		com.kisti.science.platform.app.model.ScienceAppCategoryLink scienceAppCategoryLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category link with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchCategoryLinkException} if it could not be found.
	*
	* @param scienceAppCategoryLinkId the primary key of the science app category link
	* @return the science app category link
	* @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink findByPrimaryKey(
		long scienceAppCategoryLinkId)
		throws com.kisti.science.platform.app.NoSuchCategoryLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scienceAppCategoryLinkId the primary key of the science app category link
	* @return the science app category link, or <code>null</code> if a science app category link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchByPrimaryKey(
		long scienceAppCategoryLinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science app category links.
	*
	* @return the science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the science app category links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app category links
	* @param end the upper bound of the range of science app category links (not inclusive)
	* @return the range of science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the science app category links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app category links
	* @param end the upper bound of the range of science app category links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of science app category links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the science app category links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science app category links.
	*
	* @return the number of science app category links
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}