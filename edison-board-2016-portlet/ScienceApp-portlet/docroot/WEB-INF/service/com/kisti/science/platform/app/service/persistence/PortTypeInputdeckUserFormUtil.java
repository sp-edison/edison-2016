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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the port type inputdeck user form service. This utility wraps {@link PortTypeInputdeckUserFormPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeInputdeckUserFormPersistence
 * @see PortTypeInputdeckUserFormPersistenceImpl
 * @generated
 */
public class PortTypeInputdeckUserFormUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(
		PortTypeInputdeckUserForm portTypeInputdeckUserForm) {
		getPersistence().clearCache(portTypeInputdeckUserForm);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PortTypeInputdeckUserForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PortTypeInputdeckUserForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PortTypeInputdeckUserForm> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PortTypeInputdeckUserForm update(
		PortTypeInputdeckUserForm portTypeInputdeckUserForm)
		throws SystemException {
		return getPersistence().update(portTypeInputdeckUserForm);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PortTypeInputdeckUserForm update(
		PortTypeInputdeckUserForm portTypeInputdeckUserForm,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(portTypeInputdeckUserForm, serviceContext);
	}

	/**
	* Caches the port type inputdeck user form in the entity cache if it is enabled.
	*
	* @param portTypeInputdeckUserForm the port type inputdeck user form
	*/
	public static void cacheResult(
		com.kisti.science.platform.app.model.PortTypeInputdeckUserForm portTypeInputdeckUserForm) {
		getPersistence().cacheResult(portTypeInputdeckUserForm);
	}

	/**
	* Caches the port type inputdeck user forms in the entity cache if it is enabled.
	*
	* @param portTypeInputdeckUserForms the port type inputdeck user forms
	*/
	public static void cacheResult(
		java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckUserForm> portTypeInputdeckUserForms) {
		getPersistence().cacheResult(portTypeInputdeckUserForms);
	}

	/**
	* Creates a new port type inputdeck user form with the primary key. Does not add the port type inputdeck user form to the database.
	*
	* @param inputdeckId the primary key for the new port type inputdeck user form
	* @return the new port type inputdeck user form
	*/
	public static com.kisti.science.platform.app.model.PortTypeInputdeckUserForm create(
		long inputdeckId) {
		return getPersistence().create(inputdeckId);
	}

	/**
	* Removes the port type inputdeck user form with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inputdeckId the primary key of the port type inputdeck user form
	* @return the port type inputdeck user form that was removed
	* @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException if a port type inputdeck user form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeInputdeckUserForm remove(
		long inputdeckId)
		throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(inputdeckId);
	}

	public static com.kisti.science.platform.app.model.PortTypeInputdeckUserForm updateImpl(
		com.kisti.science.platform.app.model.PortTypeInputdeckUserForm portTypeInputdeckUserForm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(portTypeInputdeckUserForm);
	}

	/**
	* Returns the port type inputdeck user form with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException} if it could not be found.
	*
	* @param inputdeckId the primary key of the port type inputdeck user form
	* @return the port type inputdeck user form
	* @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException if a port type inputdeck user form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeInputdeckUserForm findByPrimaryKey(
		long inputdeckId)
		throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(inputdeckId);
	}

	/**
	* Returns the port type inputdeck user form with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param inputdeckId the primary key of the port type inputdeck user form
	* @return the port type inputdeck user form, or <code>null</code> if a port type inputdeck user form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeInputdeckUserForm fetchByPrimaryKey(
		long inputdeckId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(inputdeckId);
	}

	/**
	* Returns all the port type inputdeck user forms.
	*
	* @return the port type inputdeck user forms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckUserForm> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckUserForm> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckUserForm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the port type inputdeck user forms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of port type inputdeck user forms.
	*
	* @return the number of port type inputdeck user forms
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PortTypeInputdeckUserFormPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PortTypeInputdeckUserFormPersistence)PortletBeanLocatorUtil.locate(com.kisti.science.platform.app.service.ClpSerializer.getServletContextName(),
					PortTypeInputdeckUserFormPersistence.class.getName());

			ReferenceRegistry.registerReference(PortTypeInputdeckUserFormUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PortTypeInputdeckUserFormPersistence persistence) {
	}

	private static PortTypeInputdeckUserFormPersistence _persistence;
}