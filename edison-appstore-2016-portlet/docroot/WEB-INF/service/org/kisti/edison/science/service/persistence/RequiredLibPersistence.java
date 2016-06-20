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

import org.kisti.edison.science.model.RequiredLib;

/**
 * The persistence interface for the required lib service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see RequiredLibPersistenceImpl
 * @see RequiredLibUtil
 * @generated
 */
public interface RequiredLibPersistence extends BasePersistence<RequiredLib> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RequiredLibUtil} to access the required lib persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the required lib in the entity cache if it is enabled.
	*
	* @param requiredLib the required lib
	*/
	public void cacheResult(
		org.kisti.edison.science.model.RequiredLib requiredLib);

	/**
	* Caches the required libs in the entity cache if it is enabled.
	*
	* @param requiredLibs the required libs
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.science.model.RequiredLib> requiredLibs);

	/**
	* Creates a new required lib with the primary key. Does not add the required lib to the database.
	*
	* @param requiredLibId the primary key for the new required lib
	* @return the new required lib
	*/
	public org.kisti.edison.science.model.RequiredLib create(long requiredLibId);

	/**
	* Removes the required lib with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requiredLibId the primary key of the required lib
	* @return the required lib that was removed
	* @throws org.kisti.edison.science.NoSuchRequiredLibException if a required lib with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredLib remove(long requiredLibId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchRequiredLibException;

	public org.kisti.edison.science.model.RequiredLib updateImpl(
		org.kisti.edison.science.model.RequiredLib requiredLib)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the required lib with the primary key or throws a {@link org.kisti.edison.science.NoSuchRequiredLibException} if it could not be found.
	*
	* @param requiredLibId the primary key of the required lib
	* @return the required lib
	* @throws org.kisti.edison.science.NoSuchRequiredLibException if a required lib with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredLib findByPrimaryKey(
		long requiredLibId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchRequiredLibException;

	/**
	* Returns the required lib with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requiredLibId the primary key of the required lib
	* @return the required lib, or <code>null</code> if a required lib with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredLib fetchByPrimaryKey(
		long requiredLibId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the required libs.
	*
	* @return the required libs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.RequiredLib> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the required libs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of required libs
	* @param end the upper bound of the range of required libs (not inclusive)
	* @return the range of required libs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.RequiredLib> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the required libs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of required libs
	* @param end the upper bound of the range of required libs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of required libs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.RequiredLib> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the required libs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of required libs.
	*
	* @return the number of required libs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}