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

package com.kisti.science.platform.app.service.persistence;

import com.kisti.science.platform.app.model.CommonPackage;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the common package service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonPackagePersistenceImpl
 * @see CommonPackageUtil
 * @generated
 */
public interface CommonPackagePersistence extends BasePersistence<CommonPackage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CommonPackageUtil} to access the common package persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the common package in the entity cache if it is enabled.
	*
	* @param commonPackage the common package
	*/
	public void cacheResult(
		com.kisti.science.platform.app.model.CommonPackage commonPackage);

	/**
	* Caches the common packages in the entity cache if it is enabled.
	*
	* @param commonPackages the common packages
	*/
	public void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.CommonPackage> commonPackages);

	/**
	* Creates a new common package with the primary key. Does not add the common package to the database.
	*
	* @param commonPackagePK the primary key for the new common package
	* @return the new common package
	*/
	public com.kisti.science.platform.app.model.CommonPackage create(
		com.kisti.science.platform.app.service.persistence.CommonPackagePK commonPackagePK);

	/**
	* Removes the common package with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commonPackagePK the primary key of the common package
	* @return the common package that was removed
	* @throws com.kisti.science.platform.app.NoSuchCommonPackageException if a common package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.CommonPackage remove(
		com.kisti.science.platform.app.service.persistence.CommonPackagePK commonPackagePK)
		throws com.kisti.science.platform.app.NoSuchCommonPackageException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kisti.science.platform.app.model.CommonPackage updateImpl(
		com.kisti.science.platform.app.model.CommonPackage commonPackage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the common package with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchCommonPackageException} if it could not be found.
	*
	* @param commonPackagePK the primary key of the common package
	* @return the common package
	* @throws com.kisti.science.platform.app.NoSuchCommonPackageException if a common package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.CommonPackage findByPrimaryKey(
		com.kisti.science.platform.app.service.persistence.CommonPackagePK commonPackagePK)
		throws com.kisti.science.platform.app.NoSuchCommonPackageException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the common package with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param commonPackagePK the primary key of the common package
	* @return the common package, or <code>null</code> if a common package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.CommonPackage fetchByPrimaryKey(
		com.kisti.science.platform.app.service.persistence.CommonPackagePK commonPackagePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the common packages.
	*
	* @return the common packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.CommonPackage> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the common packages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common packages
	* @param end the upper bound of the range of common packages (not inclusive)
	* @return the range of common packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.CommonPackage> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the common packages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common packages
	* @param end the upper bound of the range of common packages (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of common packages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.CommonPackage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the common packages from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of common packages.
	*
	* @return the number of common packages
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}