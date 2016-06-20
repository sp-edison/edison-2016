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

import com.kisti.science.platform.app.model.PortTypeInputdeckForm;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the port type inputdeck form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeInputdeckFormPersistenceImpl
 * @see PortTypeInputdeckFormUtil
 * @generated
 */
public interface PortTypeInputdeckFormPersistence extends BasePersistence<PortTypeInputdeckForm> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PortTypeInputdeckFormUtil} to access the port type inputdeck form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the port type inputdeck form in the entity cache if it is enabled.
	*
	* @param portTypeInputdeckForm the port type inputdeck form
	*/
	public void cacheResult(
		com.kisti.science.platform.app.model.PortTypeInputdeckForm portTypeInputdeckForm);

	/**
	* Caches the port type inputdeck forms in the entity cache if it is enabled.
	*
	* @param portTypeInputdeckForms the port type inputdeck forms
	*/
	public void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckForm> portTypeInputdeckForms);

	/**
	* Creates a new port type inputdeck form with the primary key. Does not add the port type inputdeck form to the database.
	*
	* @param portTypeId the primary key for the new port type inputdeck form
	* @return the new port type inputdeck form
	*/
	public com.kisti.science.platform.app.model.PortTypeInputdeckForm create(
		long portTypeId);

	/**
	* Removes the port type inputdeck form with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeId the primary key of the port type inputdeck form
	* @return the port type inputdeck form that was removed
	* @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckFormException if a port type inputdeck form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.PortTypeInputdeckForm remove(
		long portTypeId)
		throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckFormException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kisti.science.platform.app.model.PortTypeInputdeckForm updateImpl(
		com.kisti.science.platform.app.model.PortTypeInputdeckForm portTypeInputdeckForm)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the port type inputdeck form with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchPortTypeInputdeckFormException} if it could not be found.
	*
	* @param portTypeId the primary key of the port type inputdeck form
	* @return the port type inputdeck form
	* @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckFormException if a port type inputdeck form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.PortTypeInputdeckForm findByPrimaryKey(
		long portTypeId)
		throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckFormException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the port type inputdeck form with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param portTypeId the primary key of the port type inputdeck form
	* @return the port type inputdeck form, or <code>null</code> if a port type inputdeck form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.PortTypeInputdeckForm fetchByPrimaryKey(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the port type inputdeck forms.
	*
	* @return the port type inputdeck forms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckForm> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the port type inputdeck forms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeInputdeckFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type inputdeck forms
	* @param end the upper bound of the range of port type inputdeck forms (not inclusive)
	* @return the range of port type inputdeck forms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckForm> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the port type inputdeck forms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeInputdeckFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type inputdeck forms
	* @param end the upper bound of the range of port type inputdeck forms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of port type inputdeck forms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckForm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the port type inputdeck forms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of port type inputdeck forms.
	*
	* @return the number of port type inputdeck forms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}