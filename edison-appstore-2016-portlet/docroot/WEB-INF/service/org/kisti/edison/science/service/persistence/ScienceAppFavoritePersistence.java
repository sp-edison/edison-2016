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

import org.kisti.edison.science.model.ScienceAppFavorite;

/**
 * The persistence interface for the science app favorite service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see ScienceAppFavoritePersistenceImpl
 * @see ScienceAppFavoriteUtil
 * @generated
 */
public interface ScienceAppFavoritePersistence extends BasePersistence<ScienceAppFavorite> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScienceAppFavoriteUtil} to access the science app favorite persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the science app favorites where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @return the matching science app favorites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceAppFavorite> findByselectFavoriteList(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the science app favorites where scienceAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppFavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scienceAppId the science app ID
	* @param start the lower bound of the range of science app favorites
	* @param end the upper bound of the range of science app favorites (not inclusive)
	* @return the range of matching science app favorites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceAppFavorite> findByselectFavoriteList(
		long scienceAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the science app favorites where scienceAppId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppFavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param scienceAppId the science app ID
	* @param start the lower bound of the range of science app favorites
	* @param end the upper bound of the range of science app favorites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching science app favorites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceAppFavorite> findByselectFavoriteList(
		long scienceAppId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first science app favorite in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app favorite
	* @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a matching science app favorite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppFavorite findByselectFavoriteList_First(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppFavoriteException;

	/**
	* Returns the first science app favorite in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching science app favorite, or <code>null</code> if a matching science app favorite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppFavorite fetchByselectFavoriteList_First(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last science app favorite in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app favorite
	* @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a matching science app favorite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppFavorite findByselectFavoriteList_Last(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppFavoriteException;

	/**
	* Returns the last science app favorite in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching science app favorite, or <code>null</code> if a matching science app favorite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppFavorite fetchByselectFavoriteList_Last(
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app favorites before and after the current science app favorite in the ordered set where scienceAppId = &#63;.
	*
	* @param scienceAppFavoritePK the primary key of the current science app favorite
	* @param scienceAppId the science app ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next science app favorite
	* @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a science app favorite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppFavorite[] findByselectFavoriteList_PrevAndNext(
		org.kisti.edison.science.service.persistence.ScienceAppFavoritePK scienceAppFavoritePK,
		long scienceAppId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppFavoriteException;

	/**
	* Removes all the science app favorites where scienceAppId = &#63; from the database.
	*
	* @param scienceAppId the science app ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByselectFavoriteList(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science app favorites where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @return the number of matching science app favorites
	* @throws SystemException if a system exception occurred
	*/
	public int countByselectFavoriteList(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app favorite where scienceAppId = &#63; or throws a {@link org.kisti.edison.science.NoSuchScienceAppFavoriteException} if it could not be found.
	*
	* @param scienceAppId the science app ID
	* @return the matching science app favorite
	* @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a matching science app favorite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppFavorite findByselectFavoriteObj(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppFavoriteException;

	/**
	* Returns the science app favorite where scienceAppId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param scienceAppId the science app ID
	* @return the matching science app favorite, or <code>null</code> if a matching science app favorite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppFavorite fetchByselectFavoriteObj(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app favorite where scienceAppId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param scienceAppId the science app ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching science app favorite, or <code>null</code> if a matching science app favorite could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppFavorite fetchByselectFavoriteObj(
		long scienceAppId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the science app favorite where scienceAppId = &#63; from the database.
	*
	* @param scienceAppId the science app ID
	* @return the science app favorite that was removed
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppFavorite removeByselectFavoriteObj(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppFavoriteException;

	/**
	* Returns the number of science app favorites where scienceAppId = &#63;.
	*
	* @param scienceAppId the science app ID
	* @return the number of matching science app favorites
	* @throws SystemException if a system exception occurred
	*/
	public int countByselectFavoriteObj(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the science app favorite in the entity cache if it is enabled.
	*
	* @param scienceAppFavorite the science app favorite
	*/
	public void cacheResult(
		org.kisti.edison.science.model.ScienceAppFavorite scienceAppFavorite);

	/**
	* Caches the science app favorites in the entity cache if it is enabled.
	*
	* @param scienceAppFavorites the science app favorites
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.science.model.ScienceAppFavorite> scienceAppFavorites);

	/**
	* Creates a new science app favorite with the primary key. Does not add the science app favorite to the database.
	*
	* @param scienceAppFavoritePK the primary key for the new science app favorite
	* @return the new science app favorite
	*/
	public org.kisti.edison.science.model.ScienceAppFavorite create(
		org.kisti.edison.science.service.persistence.ScienceAppFavoritePK scienceAppFavoritePK);

	/**
	* Removes the science app favorite with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppFavoritePK the primary key of the science app favorite
	* @return the science app favorite that was removed
	* @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a science app favorite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppFavorite remove(
		org.kisti.edison.science.service.persistence.ScienceAppFavoritePK scienceAppFavoritePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppFavoriteException;

	public org.kisti.edison.science.model.ScienceAppFavorite updateImpl(
		org.kisti.edison.science.model.ScienceAppFavorite scienceAppFavorite)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app favorite with the primary key or throws a {@link org.kisti.edison.science.NoSuchScienceAppFavoriteException} if it could not be found.
	*
	* @param scienceAppFavoritePK the primary key of the science app favorite
	* @return the science app favorite
	* @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a science app favorite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppFavorite findByPrimaryKey(
		org.kisti.edison.science.service.persistence.ScienceAppFavoritePK scienceAppFavoritePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppFavoriteException;

	/**
	* Returns the science app favorite with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param scienceAppFavoritePK the primary key of the science app favorite
	* @return the science app favorite, or <code>null</code> if a science app favorite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.ScienceAppFavorite fetchByPrimaryKey(
		org.kisti.edison.science.service.persistence.ScienceAppFavoritePK scienceAppFavoritePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the science app favorites.
	*
	* @return the science app favorites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceAppFavorite> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the science app favorites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppFavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app favorites
	* @param end the upper bound of the range of science app favorites (not inclusive)
	* @return the range of science app favorites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceAppFavorite> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the science app favorites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppFavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app favorites
	* @param end the upper bound of the range of science app favorites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of science app favorites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.ScienceAppFavorite> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the science app favorites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science app favorites.
	*
	* @return the number of science app favorites
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}