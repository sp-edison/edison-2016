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

import org.kisti.edison.science.model.DeveloperRequest;

/**
 * The persistence interface for the developer request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see DeveloperRequestPersistenceImpl
 * @see DeveloperRequestUtil
 * @generated
 */
public interface DeveloperRequestPersistence extends BasePersistence<DeveloperRequest> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DeveloperRequestUtil} to access the developer request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the developer requests where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the developer requests where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of developer requests
	* @param end the upper bound of the range of developer requests (not inclusive)
	* @return the range of matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the developer requests where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of developer requests
	* @param end the upper bound of the range of developer requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer request
	* @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest findByUserId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException;

	/**
	* Returns the first developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer request, or <code>null</code> if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest fetchByUserId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer request
	* @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest findByUserId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException;

	/**
	* Returns the last developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer request, or <code>null</code> if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest fetchByUserId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the developer requests before and after the current developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param developerRequestPK the primary key of the current developer request
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next developer request
	* @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest[] findByUserId_PrevAndNext(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK,
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException;

	/**
	* Removes all the developer requests where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of developer requests where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the developer requests where userId = &#63; and requestSeq = &#63;.
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @return the matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserIdAndRequsetSeq(
		long userId, long requestSeq)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the developer requests where userId = &#63; and requestSeq = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @param start the lower bound of the range of developer requests
	* @param end the upper bound of the range of developer requests (not inclusive)
	* @return the range of matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserIdAndRequsetSeq(
		long userId, long requestSeq, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the developer requests where userId = &#63; and requestSeq = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @param start the lower bound of the range of developer requests
	* @param end the upper bound of the range of developer requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserIdAndRequsetSeq(
		long userId, long requestSeq, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first developer request in the ordered set where userId = &#63; and requestSeq = &#63;.
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer request
	* @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest findByUserIdAndRequsetSeq_First(
		long userId, long requestSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException;

	/**
	* Returns the first developer request in the ordered set where userId = &#63; and requestSeq = &#63;.
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer request, or <code>null</code> if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest fetchByUserIdAndRequsetSeq_First(
		long userId, long requestSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last developer request in the ordered set where userId = &#63; and requestSeq = &#63;.
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer request
	* @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest findByUserIdAndRequsetSeq_Last(
		long userId, long requestSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException;

	/**
	* Returns the last developer request in the ordered set where userId = &#63; and requestSeq = &#63;.
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer request, or <code>null</code> if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest fetchByUserIdAndRequsetSeq_Last(
		long userId, long requestSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the developer requests before and after the current developer request in the ordered set where userId = &#63; and requestSeq = &#63;.
	*
	* @param developerRequestPK the primary key of the current developer request
	* @param userId the user ID
	* @param requestSeq the request seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next developer request
	* @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest[] findByUserIdAndRequsetSeq_PrevAndNext(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK,
		long userId, long requestSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException;

	/**
	* Removes all the developer requests where userId = &#63; and requestSeq = &#63; from the database.
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdAndRequsetSeq(long userId, long requestSeq)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of developer requests where userId = &#63; and requestSeq = &#63;.
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @return the number of matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndRequsetSeq(long userId, long requestSeq)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the developer requests where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserIdAndGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the developer requests where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of developer requests
	* @param end the upper bound of the range of developer requests (not inclusive)
	* @return the range of matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserIdAndGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the developer requests where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of developer requests
	* @param end the upper bound of the range of developer requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserIdAndGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer request
	* @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest findByUserIdAndGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException;

	/**
	* Returns the first developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer request, or <code>null</code> if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest fetchByUserIdAndGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer request
	* @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest findByUserIdAndGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException;

	/**
	* Returns the last developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer request, or <code>null</code> if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest fetchByUserIdAndGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the developer requests before and after the current developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param developerRequestPK the primary key of the current developer request
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next developer request
	* @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest[] findByUserIdAndGroupId_PrevAndNext(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK,
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException;

	/**
	* Removes all the developer requests where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdAndGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of developer requests where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the developer request in the entity cache if it is enabled.
	*
	* @param developerRequest the developer request
	*/
	public void cacheResult(
		org.kisti.edison.science.model.DeveloperRequest developerRequest);

	/**
	* Caches the developer requests in the entity cache if it is enabled.
	*
	* @param developerRequests the developer requests
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.science.model.DeveloperRequest> developerRequests);

	/**
	* Creates a new developer request with the primary key. Does not add the developer request to the database.
	*
	* @param developerRequestPK the primary key for the new developer request
	* @return the new developer request
	*/
	public org.kisti.edison.science.model.DeveloperRequest create(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK);

	/**
	* Removes the developer request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param developerRequestPK the primary key of the developer request
	* @return the developer request that was removed
	* @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest remove(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException;

	public org.kisti.edison.science.model.DeveloperRequest updateImpl(
		org.kisti.edison.science.model.DeveloperRequest developerRequest)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the developer request with the primary key or throws a {@link org.kisti.edison.science.NoSuchDeveloperRequestException} if it could not be found.
	*
	* @param developerRequestPK the primary key of the developer request
	* @return the developer request
	* @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest findByPrimaryKey(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException;

	/**
	* Returns the developer request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param developerRequestPK the primary key of the developer request
	* @return the developer request, or <code>null</code> if a developer request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperRequest fetchByPrimaryKey(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the developer requests.
	*
	* @return the developer requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the developer requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of developer requests
	* @param end the upper bound of the range of developer requests (not inclusive)
	* @return the range of developer requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperRequest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the developer requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of developer requests
	* @param end the upper bound of the range of developer requests (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of developer requests
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the developer requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of developer requests.
	*
	* @return the number of developer requests
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}