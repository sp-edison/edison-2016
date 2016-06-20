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

import org.kisti.edison.science.model.CommonLib;

/**
 * The persistence interface for the common lib service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see CommonLibPersistenceImpl
 * @see CommonLibUtil
 * @generated
 */
public interface CommonLibPersistence extends BasePersistence<CommonLib> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommonLibUtil} to access the common lib persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the common libs where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @return the matching common libs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.CommonLib> findByLibName(
		java.lang.String libName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the common libs where libName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libName the lib name
	* @param start the lower bound of the range of common libs
	* @param end the upper bound of the range of common libs (not inclusive)
	* @return the range of matching common libs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.CommonLib> findByLibName(
		java.lang.String libName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the common libs where libName LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param libName the lib name
	* @param start the lower bound of the range of common libs
	* @param end the upper bound of the range of common libs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching common libs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.CommonLib> findByLibName(
		java.lang.String libName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first common lib in the ordered set where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching common lib
	* @throws org.kisti.edison.science.NoSuchCommonLibException if a matching common lib could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.CommonLib findByLibName_First(
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchCommonLibException;

	/**
	* Returns the first common lib in the ordered set where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching common lib, or <code>null</code> if a matching common lib could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.CommonLib fetchByLibName_First(
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last common lib in the ordered set where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching common lib
	* @throws org.kisti.edison.science.NoSuchCommonLibException if a matching common lib could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.CommonLib findByLibName_Last(
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchCommonLibException;

	/**
	* Returns the last common lib in the ordered set where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching common lib, or <code>null</code> if a matching common lib could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.CommonLib fetchByLibName_Last(
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the common libs before and after the current common lib in the ordered set where libName LIKE &#63;.
	*
	* @param commonLibPK the primary key of the current common lib
	* @param libName the lib name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next common lib
	* @throws org.kisti.edison.science.NoSuchCommonLibException if a common lib with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.CommonLib[] findByLibName_PrevAndNext(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK,
		java.lang.String libName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchCommonLibException;

	/**
	* Removes all the common libs where libName LIKE &#63; from the database.
	*
	* @param libName the lib name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLibName(java.lang.String libName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of common libs where libName LIKE &#63;.
	*
	* @param libName the lib name
	* @return the number of matching common libs
	* @throws SystemException if a system exception occurred
	*/
	public int countByLibName(java.lang.String libName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the common lib in the entity cache if it is enabled.
	*
	* @param commonLib the common lib
	*/
	public void cacheResult(org.kisti.edison.science.model.CommonLib commonLib);

	/**
	* Caches the common libs in the entity cache if it is enabled.
	*
	* @param commonLibs the common libs
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.science.model.CommonLib> commonLibs);

	/**
	* Creates a new common lib with the primary key. Does not add the common lib to the database.
	*
	* @param commonLibPK the primary key for the new common lib
	* @return the new common lib
	*/
	public org.kisti.edison.science.model.CommonLib create(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK);

	/**
	* Removes the common lib with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commonLibPK the primary key of the common lib
	* @return the common lib that was removed
	* @throws org.kisti.edison.science.NoSuchCommonLibException if a common lib with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.CommonLib remove(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchCommonLibException;

	public org.kisti.edison.science.model.CommonLib updateImpl(
		org.kisti.edison.science.model.CommonLib commonLib)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the common lib with the primary key or throws a {@link org.kisti.edison.science.NoSuchCommonLibException} if it could not be found.
	*
	* @param commonLibPK the primary key of the common lib
	* @return the common lib
	* @throws org.kisti.edison.science.NoSuchCommonLibException if a common lib with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.CommonLib findByPrimaryKey(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchCommonLibException;

	/**
	* Returns the common lib with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param commonLibPK the primary key of the common lib
	* @return the common lib, or <code>null</code> if a common lib with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.CommonLib fetchByPrimaryKey(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the common libs.
	*
	* @return the common libs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.CommonLib> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the common libs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common libs
	* @param end the upper bound of the range of common libs (not inclusive)
	* @return the range of common libs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.CommonLib> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the common libs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common libs
	* @param end the upper bound of the range of common libs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of common libs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.CommonLib> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the common libs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of common libs.
	*
	* @return the number of common libs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}