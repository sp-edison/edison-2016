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

import org.kisti.edison.science.model.DeveloperInfo;

/**
 * The persistence interface for the developer info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see DeveloperInfoPersistenceImpl
 * @see DeveloperInfoUtil
 * @generated
 */
public interface DeveloperInfoPersistence extends BasePersistence<DeveloperInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DeveloperInfoUtil} to access the developer info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the developer infos where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching developer infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperInfo> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the developer infos where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of developer infos
	* @param end the upper bound of the range of developer infos (not inclusive)
	* @return the range of matching developer infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperInfo> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the developer infos where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of developer infos
	* @param end the upper bound of the range of developer infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching developer infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperInfo> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first developer info in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer info
	* @throws org.kisti.edison.science.NoSuchDeveloperInfoException if a matching developer info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperInfo findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperInfoException;

	/**
	* Returns the first developer info in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching developer info, or <code>null</code> if a matching developer info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperInfo fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last developer info in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer info
	* @throws org.kisti.edison.science.NoSuchDeveloperInfoException if a matching developer info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperInfo findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperInfoException;

	/**
	* Returns the last developer info in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching developer info, or <code>null</code> if a matching developer info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperInfo fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the developer infos before and after the current developer info in the ordered set where userId = &#63;.
	*
	* @param developerInfoPK the primary key of the current developer info
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next developer info
	* @throws org.kisti.edison.science.NoSuchDeveloperInfoException if a developer info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperInfo[] findByUserId_PrevAndNext(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK developerInfoPK,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperInfoException;

	/**
	* Removes all the developer infos where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of developer infos where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching developer infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the developer info in the entity cache if it is enabled.
	*
	* @param developerInfo the developer info
	*/
	public void cacheResult(
		org.kisti.edison.science.model.DeveloperInfo developerInfo);

	/**
	* Caches the developer infos in the entity cache if it is enabled.
	*
	* @param developerInfos the developer infos
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.science.model.DeveloperInfo> developerInfos);

	/**
	* Creates a new developer info with the primary key. Does not add the developer info to the database.
	*
	* @param developerInfoPK the primary key for the new developer info
	* @return the new developer info
	*/
	public org.kisti.edison.science.model.DeveloperInfo create(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK developerInfoPK);

	/**
	* Removes the developer info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param developerInfoPK the primary key of the developer info
	* @return the developer info that was removed
	* @throws org.kisti.edison.science.NoSuchDeveloperInfoException if a developer info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperInfo remove(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK developerInfoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperInfoException;

	public org.kisti.edison.science.model.DeveloperInfo updateImpl(
		org.kisti.edison.science.model.DeveloperInfo developerInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the developer info with the primary key or throws a {@link org.kisti.edison.science.NoSuchDeveloperInfoException} if it could not be found.
	*
	* @param developerInfoPK the primary key of the developer info
	* @return the developer info
	* @throws org.kisti.edison.science.NoSuchDeveloperInfoException if a developer info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperInfo findByPrimaryKey(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK developerInfoPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchDeveloperInfoException;

	/**
	* Returns the developer info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param developerInfoPK the primary key of the developer info
	* @return the developer info, or <code>null</code> if a developer info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.DeveloperInfo fetchByPrimaryKey(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK developerInfoPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the developer infos.
	*
	* @return the developer infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the developer infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of developer infos
	* @param end the upper bound of the range of developer infos (not inclusive)
	* @return the range of developer infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the developer infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of developer infos
	* @param end the upper bound of the range of developer infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of developer infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.DeveloperInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the developer infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of developer infos.
	*
	* @return the number of developer infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}