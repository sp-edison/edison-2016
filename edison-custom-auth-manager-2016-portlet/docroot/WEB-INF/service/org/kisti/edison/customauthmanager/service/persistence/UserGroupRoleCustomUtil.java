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

package org.kisti.edison.customauthmanager.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.kisti.edison.customauthmanager.model.UserGroupRoleCustom;

import java.util.List;

/**
 * The persistence utility for the user group role custom service. This utility wraps {@link UserGroupRoleCustomPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see UserGroupRoleCustomPersistence
 * @see UserGroupRoleCustomPersistenceImpl
 * @generated
 */
public class UserGroupRoleCustomUtil {
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
	public static void clearCache(UserGroupRoleCustom userGroupRoleCustom) {
		getPersistence().clearCache(userGroupRoleCustom);
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
	public static List<UserGroupRoleCustom> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserGroupRoleCustom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserGroupRoleCustom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserGroupRoleCustom update(
		UserGroupRoleCustom userGroupRoleCustom) throws SystemException {
		return getPersistence().update(userGroupRoleCustom);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserGroupRoleCustom update(
		UserGroupRoleCustom userGroupRoleCustom, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(userGroupRoleCustom, serviceContext);
	}

	/**
	* Returns all the user group role customs where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @return the matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByGroupIdRoleId(
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupIdRoleId(groupId, roleId);
	}

	/**
	* Returns a range of all the user group role customs where groupId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param start the lower bound of the range of user group role customs
	* @param end the upper bound of the range of user group role customs (not inclusive)
	* @return the range of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByGroupIdRoleId(
		long groupId, long roleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupIdRoleId(groupId, roleId, start, end);
	}

	/**
	* Returns an ordered range of all the user group role customs where groupId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param start the lower bound of the range of user group role customs
	* @param end the upper bound of the range of user group role customs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByGroupIdRoleId(
		long groupId, long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdRoleId(groupId, roleId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first user group role custom in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByGroupIdRoleId_First(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence()
				   .findByGroupIdRoleId_First(groupId, roleId, orderByComparator);
	}

	/**
	* Returns the first user group role custom in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByGroupIdRoleId_First(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdRoleId_First(groupId, roleId,
			orderByComparator);
	}

	/**
	* Returns the last user group role custom in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByGroupIdRoleId_Last(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence()
				   .findByGroupIdRoleId_Last(groupId, roleId, orderByComparator);
	}

	/**
	* Returns the last user group role custom in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByGroupIdRoleId_Last(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdRoleId_Last(groupId, roleId, orderByComparator);
	}

	/**
	* Returns the user group role customs before and after the current user group role custom in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* @param userGroupRoleCustomPK the primary key of the current user group role custom
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom[] findByGroupIdRoleId_PrevAndNext(
		UserGroupRoleCustomPK userGroupRoleCustomPK, long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence()
				   .findByGroupIdRoleId_PrevAndNext(userGroupRoleCustomPK,
			groupId, roleId, orderByComparator);
	}

	/**
	* Removes all the user group role customs where groupId = &#63; and roleId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupIdRoleId(long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupIdRoleId(groupId, roleId);
	}

	/**
	* Returns the number of user group role customs where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @return the number of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupIdRoleId(long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupIdRoleId(groupId, roleId);
	}

	/**
	* Returns all the user group role customs where userId = &#63; and groupId = &#63; and roleId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param roleId the role ID
	* @return the matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByUserIdGroupIdRoleId(
		long userId, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdGroupIdRoleId(userId, groupId, roleId);
	}

	/**
	* Returns a range of all the user group role customs where userId = &#63; and groupId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param roleId the role ID
	* @param start the lower bound of the range of user group role customs
	* @param end the upper bound of the range of user group role customs (not inclusive)
	* @return the range of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByUserIdGroupIdRoleId(
		long userId, long groupId, long roleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdGroupIdRoleId(userId, groupId, roleId, start,
			end);
	}

	/**
	* Returns an ordered range of all the user group role customs where userId = &#63; and groupId = &#63; and roleId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param roleId the role ID
	* @param start the lower bound of the range of user group role customs
	* @param end the upper bound of the range of user group role customs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByUserIdGroupIdRoleId(
		long userId, long groupId, long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdGroupIdRoleId(userId, groupId, roleId, start,
			end, orderByComparator);
	}

	/**
	* Returns the first user group role custom in the ordered set where userId = &#63; and groupId = &#63; and roleId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByUserIdGroupIdRoleId_First(
		long userId, long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence()
				   .findByUserIdGroupIdRoleId_First(userId, groupId, roleId,
			orderByComparator);
	}

	/**
	* Returns the first user group role custom in the ordered set where userId = &#63; and groupId = &#63; and roleId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByUserIdGroupIdRoleId_First(
		long userId, long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdGroupIdRoleId_First(userId, groupId, roleId,
			orderByComparator);
	}

	/**
	* Returns the last user group role custom in the ordered set where userId = &#63; and groupId = &#63; and roleId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByUserIdGroupIdRoleId_Last(
		long userId, long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence()
				   .findByUserIdGroupIdRoleId_Last(userId, groupId, roleId,
			orderByComparator);
	}

	/**
	* Returns the last user group role custom in the ordered set where userId = &#63; and groupId = &#63; and roleId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByUserIdGroupIdRoleId_Last(
		long userId, long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdGroupIdRoleId_Last(userId, groupId, roleId,
			orderByComparator);
	}

	/**
	* Returns the user group role customs before and after the current user group role custom in the ordered set where userId = &#63; and groupId = &#63; and roleId = &#63;.
	*
	* @param userGroupRoleCustomPK the primary key of the current user group role custom
	* @param userId the user ID
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom[] findByUserIdGroupIdRoleId_PrevAndNext(
		UserGroupRoleCustomPK userGroupRoleCustomPK, long userId, long groupId,
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence()
				   .findByUserIdGroupIdRoleId_PrevAndNext(userGroupRoleCustomPK,
			userId, groupId, roleId, orderByComparator);
	}

	/**
	* Removes all the user group role customs where userId = &#63; and groupId = &#63; and roleId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param roleId the role ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdGroupIdRoleId(long userId, long groupId,
		long roleId) throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdGroupIdRoleId(userId, groupId, roleId);
	}

	/**
	* Returns the number of user group role customs where userId = &#63; and groupId = &#63; and roleId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param roleId the role ID
	* @return the number of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdGroupIdRoleId(long userId, long groupId,
		long roleId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByUserIdGroupIdRoleId(userId, groupId, roleId);
	}

	/**
	* Returns all the user group role customs where groupId = &#63; and roleId = &#63; and customId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param customId the custom ID
	* @return the matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByGroupIdRoleIdCustomId(
		long groupId, long roleId, long customId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdRoleIdCustomId(groupId, roleId, customId);
	}

	/**
	* Returns a range of all the user group role customs where groupId = &#63; and roleId = &#63; and customId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param customId the custom ID
	* @param start the lower bound of the range of user group role customs
	* @param end the upper bound of the range of user group role customs (not inclusive)
	* @return the range of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByGroupIdRoleIdCustomId(
		long groupId, long roleId, long customId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdRoleIdCustomId(groupId, roleId, customId,
			start, end);
	}

	/**
	* Returns an ordered range of all the user group role customs where groupId = &#63; and roleId = &#63; and customId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param customId the custom ID
	* @param start the lower bound of the range of user group role customs
	* @param end the upper bound of the range of user group role customs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByGroupIdRoleIdCustomId(
		long groupId, long roleId, long customId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdRoleIdCustomId(groupId, roleId, customId,
			start, end, orderByComparator);
	}

	/**
	* Returns the first user group role custom in the ordered set where groupId = &#63; and roleId = &#63; and customId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param customId the custom ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByGroupIdRoleIdCustomId_First(
		long groupId, long roleId, long customId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence()
				   .findByGroupIdRoleIdCustomId_First(groupId, roleId,
			customId, orderByComparator);
	}

	/**
	* Returns the first user group role custom in the ordered set where groupId = &#63; and roleId = &#63; and customId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param customId the custom ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByGroupIdRoleIdCustomId_First(
		long groupId, long roleId, long customId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdRoleIdCustomId_First(groupId, roleId,
			customId, orderByComparator);
	}

	/**
	* Returns the last user group role custom in the ordered set where groupId = &#63; and roleId = &#63; and customId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param customId the custom ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByGroupIdRoleIdCustomId_Last(
		long groupId, long roleId, long customId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence()
				   .findByGroupIdRoleIdCustomId_Last(groupId, roleId, customId,
			orderByComparator);
	}

	/**
	* Returns the last user group role custom in the ordered set where groupId = &#63; and roleId = &#63; and customId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param customId the custom ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByGroupIdRoleIdCustomId_Last(
		long groupId, long roleId, long customId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdRoleIdCustomId_Last(groupId, roleId,
			customId, orderByComparator);
	}

	/**
	* Returns the user group role customs before and after the current user group role custom in the ordered set where groupId = &#63; and roleId = &#63; and customId = &#63;.
	*
	* @param userGroupRoleCustomPK the primary key of the current user group role custom
	* @param groupId the group ID
	* @param roleId the role ID
	* @param customId the custom ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom[] findByGroupIdRoleIdCustomId_PrevAndNext(
		UserGroupRoleCustomPK userGroupRoleCustomPK, long groupId, long roleId,
		long customId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence()
				   .findByGroupIdRoleIdCustomId_PrevAndNext(userGroupRoleCustomPK,
			groupId, roleId, customId, orderByComparator);
	}

	/**
	* Removes all the user group role customs where groupId = &#63; and roleId = &#63; and customId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param customId the custom ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupIdRoleIdCustomId(long groupId, long roleId,
		long customId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupIdRoleIdCustomId(groupId, roleId, customId);
	}

	/**
	* Returns the number of user group role customs where groupId = &#63; and roleId = &#63; and customId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param customId the custom ID
	* @return the number of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupIdRoleIdCustomId(long groupId, long roleId,
		long customId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGroupIdRoleIdCustomId(groupId, roleId, customId);
	}

	/**
	* Returns all the user group role customs where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns a range of all the user group role customs where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of user group role customs
	* @param end the upper bound of the range of user group role customs (not inclusive)
	* @return the range of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdGroupId(userId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the user group role customs where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of user group role customs
	* @param end the upper bound of the range of user group role customs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdGroupId(userId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first user group role custom in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence()
				   .findByUserIdGroupId_First(userId, groupId, orderByComparator);
	}

	/**
	* Returns the first user group role custom in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdGroupId_First(userId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last user group role custom in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence()
				   .findByUserIdGroupId_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the last user group role custom in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdGroupId_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the user group role customs before and after the current user group role custom in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userGroupRoleCustomPK the primary key of the current user group role custom
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom[] findByUserIdGroupId_PrevAndNext(
		UserGroupRoleCustomPK userGroupRoleCustomPK, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence()
				   .findByUserIdGroupId_PrevAndNext(userGroupRoleCustomPK,
			userId, groupId, orderByComparator);
	}

	/**
	* Removes all the user group role customs where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns the number of user group role customs where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdGroupId(userId, groupId);
	}

	/**
	* Caches the user group role custom in the entity cache if it is enabled.
	*
	* @param userGroupRoleCustom the user group role custom
	*/
	public static void cacheResult(
		org.kisti.edison.customauthmanager.model.UserGroupRoleCustom userGroupRoleCustom) {
		getPersistence().cacheResult(userGroupRoleCustom);
	}

	/**
	* Caches the user group role customs in the entity cache if it is enabled.
	*
	* @param userGroupRoleCustoms the user group role customs
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> userGroupRoleCustoms) {
		getPersistence().cacheResult(userGroupRoleCustoms);
	}

	/**
	* Creates a new user group role custom with the primary key. Does not add the user group role custom to the database.
	*
	* @param userGroupRoleCustomPK the primary key for the new user group role custom
	* @return the new user group role custom
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom create(
		UserGroupRoleCustomPK userGroupRoleCustomPK) {
		return getPersistence().create(userGroupRoleCustomPK);
	}

	/**
	* Removes the user group role custom with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRoleCustomPK the primary key of the user group role custom
	* @return the user group role custom that was removed
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom remove(
		UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence().remove(userGroupRoleCustomPK);
	}

	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom updateImpl(
		org.kisti.edison.customauthmanager.model.UserGroupRoleCustom userGroupRoleCustom)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userGroupRoleCustom);
	}

	/**
	* Returns the user group role custom with the primary key or throws a {@link org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException} if it could not be found.
	*
	* @param userGroupRoleCustomPK the primary key of the user group role custom
	* @return the user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByPrimaryKey(
		UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException {
		return getPersistence().findByPrimaryKey(userGroupRoleCustomPK);
	}

	/**
	* Returns the user group role custom with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userGroupRoleCustomPK the primary key of the user group role custom
	* @return the user group role custom, or <code>null</code> if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByPrimaryKey(
		UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userGroupRoleCustomPK);
	}

	/**
	* Returns all the user group role customs.
	*
	* @return the user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user group role customs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user group role customs
	* @param end the upper bound of the range of user group role customs (not inclusive)
	* @return the range of user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user group role customs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user group role customs
	* @param end the upper bound of the range of user group role customs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user group role customs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user group role customs.
	*
	* @return the number of user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserGroupRoleCustomPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserGroupRoleCustomPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.customauthmanager.service.ClpSerializer.getServletContextName(),
					UserGroupRoleCustomPersistence.class.getName());

			ReferenceRegistry.registerReference(UserGroupRoleCustomUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserGroupRoleCustomPersistence persistence) {
	}

	private static UserGroupRoleCustomPersistence _persistence;
}