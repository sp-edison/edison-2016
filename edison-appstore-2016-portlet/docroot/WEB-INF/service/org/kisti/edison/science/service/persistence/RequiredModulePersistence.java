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

import org.kisti.edison.science.model.RequiredModule;

/**
 * The persistence interface for the required module service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see RequiredModulePersistenceImpl
 * @see RequiredModuleUtil
 * @generated
 */
public interface RequiredModulePersistence extends BasePersistence<RequiredModule> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RequiredModuleUtil} to access the required module persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the required module in the entity cache if it is enabled.
	*
	* @param requiredModule the required module
	*/
	public void cacheResult(
		org.kisti.edison.science.model.RequiredModule requiredModule);

	/**
	* Caches the required modules in the entity cache if it is enabled.
	*
	* @param requiredModules the required modules
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.science.model.RequiredModule> requiredModules);

	/**
	* Creates a new required module with the primary key. Does not add the required module to the database.
	*
	* @param requiredModuleId the primary key for the new required module
	* @return the new required module
	*/
	public org.kisti.edison.science.model.RequiredModule create(
		long requiredModuleId);

	/**
	* Removes the required module with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requiredModuleId the primary key of the required module
	* @return the required module that was removed
	* @throws org.kisti.edison.science.NoSuchRequiredModuleException if a required module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredModule remove(
		long requiredModuleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchRequiredModuleException;

	public org.kisti.edison.science.model.RequiredModule updateImpl(
		org.kisti.edison.science.model.RequiredModule requiredModule)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the required module with the primary key or throws a {@link org.kisti.edison.science.NoSuchRequiredModuleException} if it could not be found.
	*
	* @param requiredModuleId the primary key of the required module
	* @return the required module
	* @throws org.kisti.edison.science.NoSuchRequiredModuleException if a required module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredModule findByPrimaryKey(
		long requiredModuleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchRequiredModuleException;

	/**
	* Returns the required module with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param requiredModuleId the primary key of the required module
	* @return the required module, or <code>null</code> if a required module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.science.model.RequiredModule fetchByPrimaryKey(
		long requiredModuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the required modules.
	*
	* @return the required modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.RequiredModule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the required modules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of required modules
	* @param end the upper bound of the range of required modules (not inclusive)
	* @return the range of required modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.RequiredModule> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the required modules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of required modules
	* @param end the upper bound of the range of required modules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of required modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.science.model.RequiredModule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the required modules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of required modules.
	*
	* @return the number of required modules
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}