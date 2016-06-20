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

import org.kisti.edison.science.model.DeveloperRequest;

import java.util.List;

/**
 * The persistence utility for the developer request service. This utility wraps {@link DeveloperRequestPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see DeveloperRequestPersistence
 * @see DeveloperRequestPersistenceImpl
 * @generated
 */
public class DeveloperRequestUtil {
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
	public static void clearCache(DeveloperRequest developerRequest) {
		getPersistence().clearCache(developerRequest);
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
	public static List<DeveloperRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DeveloperRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DeveloperRequest> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DeveloperRequest update(DeveloperRequest developerRequest)
		throws SystemException {
		return getPersistence().update(developerRequest);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DeveloperRequest update(DeveloperRequest developerRequest,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(developerRequest, serviceContext);
	}

	/**
	* Returns all the developer requests where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, groupId);
	}

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
	public static java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, groupId, start, end);
	}

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
	public static java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, groupId, start, end, orderByComparator);
	}

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
	public static org.kisti.edison.science.model.DeveloperRequest findByUserId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException {
		return getPersistence()
				   .findByUserId_First(userId, groupId, orderByComparator);
	}

	/**
	* Returns the first developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer request, or <code>null</code> if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperRequest fetchByUserId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserId_First(userId, groupId, orderByComparator);
	}

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
	public static org.kisti.edison.science.model.DeveloperRequest findByUserId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException {
		return getPersistence()
				   .findByUserId_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the last developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer request, or <code>null</code> if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperRequest fetchByUserId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserId_Last(userId, groupId, orderByComparator);
	}

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
	public static org.kisti.edison.science.model.DeveloperRequest[] findByUserId_PrevAndNext(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK,
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException {
		return getPersistence()
				   .findByUserId_PrevAndNext(developerRequestPK, userId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the developer requests where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId, groupId);
	}

	/**
	* Returns the number of developer requests where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId, groupId);
	}

	/**
	* Returns all the developer requests where userId = &#63; and requestSeq = &#63;.
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @return the matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserIdAndRequsetSeq(
		long userId, long requestSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdAndRequsetSeq(userId, requestSeq);
	}

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
	public static java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserIdAndRequsetSeq(
		long userId, long requestSeq, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdAndRequsetSeq(userId, requestSeq, start, end);
	}

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
	public static java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserIdAndRequsetSeq(
		long userId, long requestSeq, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdAndRequsetSeq(userId, requestSeq, start, end,
			orderByComparator);
	}

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
	public static org.kisti.edison.science.model.DeveloperRequest findByUserIdAndRequsetSeq_First(
		long userId, long requestSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException {
		return getPersistence()
				   .findByUserIdAndRequsetSeq_First(userId, requestSeq,
			orderByComparator);
	}

	/**
	* Returns the first developer request in the ordered set where userId = &#63; and requestSeq = &#63;.
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer request, or <code>null</code> if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperRequest fetchByUserIdAndRequsetSeq_First(
		long userId, long requestSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndRequsetSeq_First(userId, requestSeq,
			orderByComparator);
	}

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
	public static org.kisti.edison.science.model.DeveloperRequest findByUserIdAndRequsetSeq_Last(
		long userId, long requestSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException {
		return getPersistence()
				   .findByUserIdAndRequsetSeq_Last(userId, requestSeq,
			orderByComparator);
	}

	/**
	* Returns the last developer request in the ordered set where userId = &#63; and requestSeq = &#63;.
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer request, or <code>null</code> if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperRequest fetchByUserIdAndRequsetSeq_Last(
		long userId, long requestSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndRequsetSeq_Last(userId, requestSeq,
			orderByComparator);
	}

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
	public static org.kisti.edison.science.model.DeveloperRequest[] findByUserIdAndRequsetSeq_PrevAndNext(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK,
		long userId, long requestSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException {
		return getPersistence()
				   .findByUserIdAndRequsetSeq_PrevAndNext(developerRequestPK,
			userId, requestSeq, orderByComparator);
	}

	/**
	* Removes all the developer requests where userId = &#63; and requestSeq = &#63; from the database.
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdAndRequsetSeq(long userId, long requestSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdAndRequsetSeq(userId, requestSeq);
	}

	/**
	* Returns the number of developer requests where userId = &#63; and requestSeq = &#63;.
	*
	* @param userId the user ID
	* @param requestSeq the request seq
	* @return the number of matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdAndRequsetSeq(long userId, long requestSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdAndRequsetSeq(userId, requestSeq);
	}

	/**
	* Returns all the developer requests where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserIdAndGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdAndGroupId(userId, groupId);
	}

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
	public static java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserIdAndGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdAndGroupId(userId, groupId, start, end);
	}

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
	public static java.util.List<org.kisti.edison.science.model.DeveloperRequest> findByUserIdAndGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdAndGroupId(userId, groupId, start, end,
			orderByComparator);
	}

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
	public static org.kisti.edison.science.model.DeveloperRequest findByUserIdAndGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException {
		return getPersistence()
				   .findByUserIdAndGroupId_First(userId, groupId,
			orderByComparator);
	}

	/**
	* Returns the first developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer request, or <code>null</code> if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperRequest fetchByUserIdAndGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndGroupId_First(userId, groupId,
			orderByComparator);
	}

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
	public static org.kisti.edison.science.model.DeveloperRequest findByUserIdAndGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException {
		return getPersistence()
				   .findByUserIdAndGroupId_Last(userId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last developer request in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer request, or <code>null</code> if a matching developer request could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperRequest fetchByUserIdAndGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndGroupId_Last(userId, groupId,
			orderByComparator);
	}

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
	public static org.kisti.edison.science.model.DeveloperRequest[] findByUserIdAndGroupId_PrevAndNext(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK,
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException {
		return getPersistence()
				   .findByUserIdAndGroupId_PrevAndNext(developerRequestPK,
			userId, groupId, orderByComparator);
	}

	/**
	* Removes all the developer requests where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdAndGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdAndGroupId(userId, groupId);
	}

	/**
	* Returns the number of developer requests where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching developer requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdAndGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdAndGroupId(userId, groupId);
	}

	/**
	* Caches the developer request in the entity cache if it is enabled.
	*
	* @param developerRequest the developer request
	*/
	public static void cacheResult(
		org.kisti.edison.science.model.DeveloperRequest developerRequest) {
		getPersistence().cacheResult(developerRequest);
	}

	/**
	* Caches the developer requests in the entity cache if it is enabled.
	*
	* @param developerRequests the developer requests
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.science.model.DeveloperRequest> developerRequests) {
		getPersistence().cacheResult(developerRequests);
	}

	/**
	* Creates a new developer request with the primary key. Does not add the developer request to the database.
	*
	* @param developerRequestPK the primary key for the new developer request
	* @return the new developer request
	*/
	public static org.kisti.edison.science.model.DeveloperRequest create(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK) {
		return getPersistence().create(developerRequestPK);
	}

	/**
	* Removes the developer request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param developerRequestPK the primary key of the developer request
	* @return the developer request that was removed
	* @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperRequest remove(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException {
		return getPersistence().remove(developerRequestPK);
	}

	public static org.kisti.edison.science.model.DeveloperRequest updateImpl(
		org.kisti.edison.science.model.DeveloperRequest developerRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(developerRequest);
	}

	/**
	* Returns the developer request with the primary key or throws a {@link org.kisti.edison.science.NoSuchDeveloperRequestException} if it could not be found.
	*
	* @param developerRequestPK the primary key of the developer request
	* @return the developer request
	* @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperRequest findByPrimaryKey(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperRequestException {
		return getPersistence().findByPrimaryKey(developerRequestPK);
	}

	/**
	* Returns the developer request with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param developerRequestPK the primary key of the developer request
	* @return the developer request, or <code>null</code> if a developer request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperRequest fetchByPrimaryKey(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(developerRequestPK);
	}

	/**
	* Returns all the developer requests.
	*
	* @return the developer requests
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.DeveloperRequest> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.kisti.edison.science.model.DeveloperRequest> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.kisti.edison.science.model.DeveloperRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the developer requests from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of developer requests.
	*
	* @return the number of developer requests
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DeveloperRequestPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DeveloperRequestPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.science.service.ClpSerializer.getServletContextName(),
					DeveloperRequestPersistence.class.getName());

			ReferenceRegistry.registerReference(DeveloperRequestUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DeveloperRequestPersistence persistence) {
	}

	private static DeveloperRequestPersistence _persistence;
}