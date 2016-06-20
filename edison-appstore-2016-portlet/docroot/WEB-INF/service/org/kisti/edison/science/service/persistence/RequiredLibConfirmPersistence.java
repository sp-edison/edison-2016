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

import org.kisti.edison.science.model.RequiredLibConfirm;

/**
 * The persistence interface for the required lib confirm service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see RequiredLibConfirmPersistenceImpl
 * @see RequiredLibConfirmUtil
 * @generated
 */
public interface RequiredLibConfirmPersistence extends BasePersistence<RequiredLibConfirm> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RequiredLibConfirmUtil} to access the required lib confirm persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the required lib confirms where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @return the matching required lib confirms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.RequiredLibConfirm> findByScienceAppId(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the required lib confirms where scienceAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibConfirmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scienceAppId the science app ID
	* @param start the lower bound of the range of required lib confirms
	* @param end the upper bound of the range of required lib confirms (not inclusive)
	* @return the range of matching required lib confirms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.RequiredLibConfirm> findByScienceAppId(
		long scienceAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the required lib confirms where scienceAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibConfirmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scienceAppId the science app ID
	* @param start the lower bound of the range of required lib confirms
	* @param end the upper bound of the range of required lib confirms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching required lib confirms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.RequiredLibConfirm> findByScienceAppId(
		long scienceAppId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first required lib confirm in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching required lib confirm
	* @throws org.kisti.edison.science.NoSuchRequiredLibConfirmException if a matching required lib confirm could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredLibConfirm findByScienceAppId_First(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchRequiredLibConfirmException;

	/**
	* Returns the first required lib confirm in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching required lib confirm, or <code>null</code> if a matching required lib confirm could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredLibConfirm fetchByScienceAppId_First(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last required lib confirm in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching required lib confirm
	* @throws org.kisti.edison.science.NoSuchRequiredLibConfirmException if a matching required lib confirm could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredLibConfirm findByScienceAppId_Last(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchRequiredLibConfirmException;

	/**
	* Returns the last required lib confirm in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching required lib confirm, or <code>null</code> if a matching required lib confirm could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredLibConfirm fetchByScienceAppId_Last(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the required lib confirms before and after the current required lib confirm in the ordered set where scienceAppId = &#63;.
	*
	* @param requiredLibConfirmPK the primary key of the current required lib confirm
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next required lib confirm
	* @throws org.kisti.edison.science.NoSuchRequiredLibConfirmException if a required lib confirm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredLibConfirm[] findByScienceAppId_PrevAndNext(
		org.kisti.edison.science.service.persistence.RequiredLibConfirmPK requiredLibConfirmPK,
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchRequiredLibConfirmException;

	/**
	* Removes all the required lib confirms where scienceAppId = &#63; from the database.
	*
	* @param scienceAppId the science app ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of required lib confirms where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @return the number of matching required lib confirms
	* @throws SystemException if a system exception occurred
	*/
	public int countByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the required lib confirm in the entity cache if it is enabled.
	*
	* @param requiredLibConfirm the required lib confirm
	*/
	public void cacheResult(
		org.kisti.edison.science.model.RequiredLibConfirm requiredLibConfirm);

	/**
	* Caches the required lib confirms in the entity cache if it is enabled.
	*
	* @param requiredLibConfirms the required lib confirms
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.science.model.RequiredLibConfirm> requiredLibConfirms);

	/**
	* Creates a new required lib confirm with the primary key. Does not add the required lib confirm to the database.
	*
	* @param requiredLibConfirmPK the primary key for the new required lib confirm
	* @return the new required lib confirm
	*/
	public org.kisti.edison.science.model.RequiredLibConfirm create(
		org.kisti.edison.science.service.persistence.RequiredLibConfirmPK requiredLibConfirmPK);

	/**
	* Removes the required lib confirm with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requiredLibConfirmPK the primary key of the required lib confirm
	* @return the required lib confirm that was removed
	* @throws org.kisti.edison.science.NoSuchRequiredLibConfirmException if a required lib confirm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredLibConfirm remove(
		org.kisti.edison.science.service.persistence.RequiredLibConfirmPK requiredLibConfirmPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchRequiredLibConfirmException;

	public org.kisti.edison.science.model.RequiredLibConfirm updateImpl(
		org.kisti.edison.science.model.RequiredLibConfirm requiredLibConfirm)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the required lib confirm with the primary key or throws a {@link org.kisti.edison.science.NoSuchRequiredLibConfirmException} if it could not be found.
	*
	* @param requiredLibConfirmPK the primary key of the required lib confirm
	* @return the required lib confirm
	* @throws org.kisti.edison.science.NoSuchRequiredLibConfirmException if a required lib confirm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredLibConfirm findByPrimaryKey(
		org.kisti.edison.science.service.persistence.RequiredLibConfirmPK requiredLibConfirmPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchRequiredLibConfirmException;

	/**
	* Returns the required lib confirm with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requiredLibConfirmPK the primary key of the required lib confirm
	* @return the required lib confirm, or <code>null</code> if a required lib confirm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredLibConfirm fetchByPrimaryKey(
		org.kisti.edison.science.service.persistence.RequiredLibConfirmPK requiredLibConfirmPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the required lib confirms.
	*
	* @return the required lib confirms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.RequiredLibConfirm> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the required lib confirms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibConfirmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of required lib confirms
	* @param end the upper bound of the range of required lib confirms (not inclusive)
	* @return the range of required lib confirms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.RequiredLibConfirm> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the required lib confirms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibConfirmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of required lib confirms
	* @param end the upper bound of the range of required lib confirms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of required lib confirms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.RequiredLibConfirm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the required lib confirms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of required lib confirms.
	*
	* @return the number of required lib confirms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}