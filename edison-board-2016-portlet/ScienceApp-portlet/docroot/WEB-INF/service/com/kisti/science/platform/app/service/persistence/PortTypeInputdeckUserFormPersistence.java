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

import com.kisti.science.platform.app.model.PortTypeInputdeckUserForm;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the port type inputdeck user form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeInputdeckUserFormPersistenceImpl
 * @see PortTypeInputdeckUserFormUtil
 * @generated
 */
public interface PortTypeInputdeckUserFormPersistence extends BasePersistence<PortTypeInputdeckUserForm> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PortTypeInputdeckUserFormUtil} to access the port type inputdeck user form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the port type inputdeck user form in the entity cache if it is enabled.
	*
	* @param portTypeInputdeckUserForm the port type inputdeck user form
	*/
	public void cacheResult(
		com.kisti.science.platform.app.model.PortTypeInputdeckUserForm portTypeInputdeckUserForm);

	/**
	* Caches the port type inputdeck user forms in the entity cache if it is enabled.
	*
	* @param portTypeInputdeckUserForms the port type inputdeck user forms
	*/
	public void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckUserForm> portTypeInputdeckUserForms);

	/**
	* Creates a new port type inputdeck user form with the primary key. Does not add the port type inputdeck user form to the database.
	*
	* @param inputdeckId the primary key for the new port type inputdeck user form
	* @return the new port type inputdeck user form
	*/
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm create(
		long inputdeckId);

	/**
	* Removes the port type inputdeck user form with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inputdeckId the primary key of the port type inputdeck user form
	* @return the port type inputdeck user form that was removed
	* @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException if a port type inputdeck user form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm remove(
		long inputdeckId)
		throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm updateImpl(
		com.kisti.science.platform.app.model.PortTypeInputdeckUserForm portTypeInputdeckUserForm)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the port type inputdeck user form with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException} if it could not be found.
	*
	* @param inputdeckId the primary key of the port type inputdeck user form
	* @return the port type inputdeck user form
	* @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException if a port type inputdeck user form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm findByPrimaryKey(
		long inputdeckId)
		throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the port type inputdeck user form with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param inputdeckId the primary key of the port type inputdeck user form
	* @return the port type inputdeck user form, or <code>null</code> if a port type inputdeck user form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm fetchByPrimaryKey(
		long inputdeckId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the port type inputdeck user forms.
	*
	* @return the port type inputdeck user forms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckUserForm> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the port type inputdeck user forms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeInputdeckUserFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type inputdeck user forms
	* @param end the upper bound of the range of port type inputdeck user forms (not inclusive)
	* @return the range of port type inputdeck user forms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckUserForm> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the port type inputdeck user forms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeInputdeckUserFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type inputdeck user forms
	* @param end the upper bound of the range of port type inputdeck user forms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of port type inputdeck user forms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckUserForm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the port type inputdeck user forms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of port type inputdeck user forms.
	*
	* @return the number of port type inputdeck user forms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}