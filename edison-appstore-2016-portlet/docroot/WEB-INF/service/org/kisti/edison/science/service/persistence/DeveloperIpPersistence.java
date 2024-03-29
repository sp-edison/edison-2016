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

import org.kisti.edison.science.model.DeveloperIp;

/**
 * The persistence interface for the developer ip service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see DeveloperIpPersistenceImpl
 * @see DeveloperIpUtil
 * @generated
 */
public interface DeveloperIpPersistence extends BasePersistence<DeveloperIp> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DeveloperIpUtil} to access the developer ip persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the developer ips where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching developer ips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperIp> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the developer ips where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of developer ips
	* @param end the upper bound of the range of developer ips (not inclusive)
	* @return the range of matching developer ips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperIp> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the developer ips where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of developer ips
	* @param end the upper bound of the range of developer ips (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching developer ips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperIp> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first developer ip in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer ip
	* @throws org.kisti.edison.science.NoSuchDeveloperIpException if a matching developer ip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperIp findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperIpException;

	/**
	* Returns the first developer ip in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer ip, or <code>null</code> if a matching developer ip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperIp fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last developer ip in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer ip
	* @throws org.kisti.edison.science.NoSuchDeveloperIpException if a matching developer ip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperIp findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperIpException;

	/**
	* Returns the last developer ip in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer ip, or <code>null</code> if a matching developer ip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperIp fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the developer ips before and after the current developer ip in the ordered set where userId = &#63;.
	*
	* @param developerIpPK the primary key of the current developer ip
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next developer ip
	* @throws org.kisti.edison.science.NoSuchDeveloperIpException if a developer ip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperIp[] findByUserId_PrevAndNext(
		org.kisti.edison.science.service.persistence.DeveloperIpPK developerIpPK,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperIpException;

	/**
	* Removes all the developer ips where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of developer ips where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching developer ips
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the developer ips where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching developer ips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperIp> findByGroupId(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the developer ips where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of developer ips
	* @param end the upper bound of the range of developer ips (not inclusive)
	* @return the range of matching developer ips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperIp> findByGroupId(
		long userId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the developer ips where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of developer ips
	* @param end the upper bound of the range of developer ips (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching developer ips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperIp> findByGroupId(
		long userId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first developer ip in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer ip
	* @throws org.kisti.edison.science.NoSuchDeveloperIpException if a matching developer ip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperIp findByGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperIpException;

	/**
	* Returns the first developer ip in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer ip, or <code>null</code> if a matching developer ip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperIp fetchByGroupId_First(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last developer ip in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer ip
	* @throws org.kisti.edison.science.NoSuchDeveloperIpException if a matching developer ip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperIp findByGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperIpException;

	/**
	* Returns the last developer ip in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer ip, or <code>null</code> if a matching developer ip could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperIp fetchByGroupId_Last(
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the developer ips before and after the current developer ip in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param developerIpPK the primary key of the current developer ip
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next developer ip
	* @throws org.kisti.edison.science.NoSuchDeveloperIpException if a developer ip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperIp[] findByGroupId_PrevAndNext(
		org.kisti.edison.science.service.persistence.DeveloperIpPK developerIpPK,
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperIpException;

	/**
	* Removes all the developer ips where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of developer ips where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching developer ips
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the developer ip in the entity cache if it is enabled.
	*
	* @param developerIp the developer ip
	*/
	public void cacheResult(
		org.kisti.edison.science.model.DeveloperIp developerIp);

	/**
	* Caches the developer ips in the entity cache if it is enabled.
	*
	* @param developerIps the developer ips
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.science.model.DeveloperIp> developerIps);

	/**
	* Creates a new developer ip with the primary key. Does not add the developer ip to the database.
	*
	* @param developerIpPK the primary key for the new developer ip
	* @return the new developer ip
	*/
	public org.kisti.edison.science.model.DeveloperIp create(
		org.kisti.edison.science.service.persistence.DeveloperIpPK developerIpPK);

	/**
	* Removes the developer ip with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param developerIpPK the primary key of the developer ip
	* @return the developer ip that was removed
	* @throws org.kisti.edison.science.NoSuchDeveloperIpException if a developer ip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperIp remove(
		org.kisti.edison.science.service.persistence.DeveloperIpPK developerIpPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperIpException;

	public org.kisti.edison.science.model.DeveloperIp updateImpl(
		org.kisti.edison.science.model.DeveloperIp developerIp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the developer ip with the primary key or throws a {@link org.kisti.edison.science.NoSuchDeveloperIpException} if it could not be found.
	*
	* @param developerIpPK the primary key of the developer ip
	* @return the developer ip
	* @throws org.kisti.edison.science.NoSuchDeveloperIpException if a developer ip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperIp findByPrimaryKey(
		org.kisti.edison.science.service.persistence.DeveloperIpPK developerIpPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperIpException;

	/**
	* Returns the developer ip with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param developerIpPK the primary key of the developer ip
	* @return the developer ip, or <code>null</code> if a developer ip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperIp fetchByPrimaryKey(
		org.kisti.edison.science.service.persistence.DeveloperIpPK developerIpPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the developer ips.
	*
	* @return the developer ips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperIp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the developer ips.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of developer ips
	* @param end the upper bound of the range of developer ips (not inclusive)
	* @return the range of developer ips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperIp> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the developer ips.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of developer ips
	* @param end the upper bound of the range of developer ips (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of developer ips
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperIp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the developer ips from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of developer ips.
	*
	* @return the number of developer ips
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}