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

import com.liferay.portal.service.persistence.BasePersistence;

import org.kisti.edison.customauthmanager.model.UserGroupRoleCustom;

/**
 * The persistence interface for the user group role custom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see UserGroupRoleCustomPersistenceImpl
 * @see UserGroupRoleCustomUtil
 * @generated
 */
public interface UserGroupRoleCustomPersistence extends BasePersistence<UserGroupRoleCustom> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserGroupRoleCustomUtil} to access the user group role custom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the user group role customs where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @return the matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByGroupIdRoleId(
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByGroupIdRoleId(
		long groupId, long roleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByGroupIdRoleId(
		long groupId, long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByGroupIdRoleId_First(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

	/**
	* Returns the first user group role custom in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByGroupIdRoleId_First(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByGroupIdRoleId_Last(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

	/**
	* Returns the last user group role custom in the ordered set where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByGroupIdRoleId_Last(
		long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom[] findByGroupIdRoleId_PrevAndNext(
		UserGroupRoleCustomPK userGroupRoleCustomPK, long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

	/**
	* Removes all the user group role customs where groupId = &#63; and roleId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupIdRoleId(long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user group role customs where groupId = &#63; and roleId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @return the number of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupIdRoleId(long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user group role customs where userId = &#63; and groupId = &#63; and roleId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param roleId the role ID
	* @return the matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByUserIdGroupIdRoleId(
		long userId, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByUserIdGroupIdRoleId(
		long userId, long groupId, long roleId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByUserIdGroupIdRoleId(
		long userId, long groupId, long roleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByUserIdGroupIdRoleId_First(
		long userId, long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByUserIdGroupIdRoleId_First(
		long userId, long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByUserIdGroupIdRoleId_Last(
		long userId, long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByUserIdGroupIdRoleId_Last(
		long userId, long groupId, long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom[] findByUserIdGroupIdRoleId_PrevAndNext(
		UserGroupRoleCustomPK userGroupRoleCustomPK, long userId, long groupId,
		long roleId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

	/**
	* Removes all the user group role customs where userId = &#63; and groupId = &#63; and roleId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param roleId the role ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdGroupIdRoleId(long userId, long groupId,
		long roleId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user group role customs where userId = &#63; and groupId = &#63; and roleId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param roleId the role ID
	* @return the number of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdGroupIdRoleId(long userId, long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user group role customs where groupId = &#63; and roleId = &#63; and customId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param customId the custom ID
	* @return the matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByGroupIdRoleIdCustomId(
		long groupId, long roleId, long customId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByGroupIdRoleIdCustomId(
		long groupId, long roleId, long customId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByGroupIdRoleIdCustomId(
		long groupId, long roleId, long customId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByGroupIdRoleIdCustomId_First(
		long groupId, long roleId, long customId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByGroupIdRoleIdCustomId_First(
		long groupId, long roleId, long customId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByGroupIdRoleIdCustomId_Last(
		long groupId, long roleId, long customId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByGroupIdRoleIdCustomId_Last(
		long groupId, long roleId, long customId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom[] findByGroupIdRoleIdCustomId_PrevAndNext(
		UserGroupRoleCustomPK userGroupRoleCustomPK, long groupId, long roleId,
		long customId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

	/**
	* Removes all the user group role customs where groupId = &#63; and roleId = &#63; and customId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param customId the custom ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupIdRoleIdCustomId(long groupId, long roleId,
		long customId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user group role customs where groupId = &#63; and roleId = &#63; and customId = &#63;.
	*
	* @param groupId the group ID
	* @param roleId the role ID
	* @param customId the custom ID
	* @return the number of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupIdRoleIdCustomId(long groupId, long roleId,
		long customId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user group role customs where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByUserIdGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByUserIdGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findByUserIdGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

	/**
	* Returns the first user group role custom in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByUserIdGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

	/**
	* Returns the last user group role custom in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByUserIdGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom[] findByUserIdGroupId_PrevAndNext(
		UserGroupRoleCustomPK userGroupRoleCustomPK, long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

	/**
	* Removes all the user group role customs where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user group role customs where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user group role custom in the entity cache if it is enabled.
	*
	* @param userGroupRoleCustom the user group role custom
	*/
	public void cacheResult(
		org.kisti.edison.customauthmanager.model.UserGroupRoleCustom userGroupRoleCustom);

	/**
	* Caches the user group role customs in the entity cache if it is enabled.
	*
	* @param userGroupRoleCustoms the user group role customs
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> userGroupRoleCustoms);

	/**
	* Creates a new user group role custom with the primary key. Does not add the user group role custom to the database.
	*
	* @param userGroupRoleCustomPK the primary key for the new user group role custom
	* @return the new user group role custom
	*/
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom create(
		UserGroupRoleCustomPK userGroupRoleCustomPK);

	/**
	* Removes the user group role custom with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupRoleCustomPK the primary key of the user group role custom
	* @return the user group role custom that was removed
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom remove(
		UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom updateImpl(
		org.kisti.edison.customauthmanager.model.UserGroupRoleCustom userGroupRoleCustom)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user group role custom with the primary key or throws a {@link org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException} if it could not be found.
	*
	* @param userGroupRoleCustomPK the primary key of the user group role custom
	* @return the user group role custom
	* @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom findByPrimaryKey(
		UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;

	/**
	* Returns the user group role custom with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userGroupRoleCustomPK the primary key of the user group role custom
	* @return the user group role custom, or <code>null</code> if a user group role custom with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.customauthmanager.model.UserGroupRoleCustom fetchByPrimaryKey(
		UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user group role customs.
	*
	* @return the user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.customauthmanager.model.UserGroupRoleCustom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user group role customs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user group role customs.
	*
	* @return the number of user group role customs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}