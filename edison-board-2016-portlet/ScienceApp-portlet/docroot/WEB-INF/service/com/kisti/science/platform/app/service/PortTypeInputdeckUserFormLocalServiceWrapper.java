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

package com.kisti.science.platform.app.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PortTypeInputdeckUserFormLocalService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeInputdeckUserFormLocalService
 * @generated
 */
public class PortTypeInputdeckUserFormLocalServiceWrapper
	implements PortTypeInputdeckUserFormLocalService,
		ServiceWrapper<PortTypeInputdeckUserFormLocalService> {
	public PortTypeInputdeckUserFormLocalServiceWrapper(
		PortTypeInputdeckUserFormLocalService portTypeInputdeckUserFormLocalService) {
		_portTypeInputdeckUserFormLocalService = portTypeInputdeckUserFormLocalService;
	}

	/**
	* Adds the port type inputdeck user form to the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeInputdeckUserForm the port type inputdeck user form
	* @return the port type inputdeck user form that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm addPortTypeInputdeckUserForm(
		com.kisti.science.platform.app.model.PortTypeInputdeckUserForm portTypeInputdeckUserForm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.addPortTypeInputdeckUserForm(portTypeInputdeckUserForm);
	}

	/**
	* Creates a new port type inputdeck user form with the primary key. Does not add the port type inputdeck user form to the database.
	*
	* @param inputdeckId the primary key for the new port type inputdeck user form
	* @return the new port type inputdeck user form
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm createPortTypeInputdeckUserForm(
		long inputdeckId) {
		return _portTypeInputdeckUserFormLocalService.createPortTypeInputdeckUserForm(inputdeckId);
	}

	/**
	* Deletes the port type inputdeck user form with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param inputdeckId the primary key of the port type inputdeck user form
	* @return the port type inputdeck user form that was removed
	* @throws PortalException if a port type inputdeck user form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm deletePortTypeInputdeckUserForm(
		long inputdeckId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.deletePortTypeInputdeckUserForm(inputdeckId);
	}

	/**
	* Deletes the port type inputdeck user form from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeInputdeckUserForm the port type inputdeck user form
	* @return the port type inputdeck user form that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm deletePortTypeInputdeckUserForm(
		com.kisti.science.platform.app.model.PortTypeInputdeckUserForm portTypeInputdeckUserForm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.deletePortTypeInputdeckUserForm(portTypeInputdeckUserForm);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _portTypeInputdeckUserFormLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeInputdeckUserFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeInputdeckUserFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm fetchPortTypeInputdeckUserForm(
		long inputdeckId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.fetchPortTypeInputdeckUserForm(inputdeckId);
	}

	/**
	* Returns the port type inputdeck user form with the primary key.
	*
	* @param inputdeckId the primary key of the port type inputdeck user form
	* @return the port type inputdeck user form
	* @throws PortalException if a port type inputdeck user form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm getPortTypeInputdeckUserForm(
		long inputdeckId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.getPortTypeInputdeckUserForm(inputdeckId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckUserForm> getPortTypeInputdeckUserForms(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.getPortTypeInputdeckUserForms(start,
			end);
	}

	/**
	* Returns the number of port type inputdeck user forms.
	*
	* @return the number of port type inputdeck user forms
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPortTypeInputdeckUserFormsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.getPortTypeInputdeckUserFormsCount();
	}

	/**
	* Updates the port type inputdeck user form in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portTypeInputdeckUserForm the port type inputdeck user form
	* @return the port type inputdeck user form that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm updatePortTypeInputdeckUserForm(
		com.kisti.science.platform.app.model.PortTypeInputdeckUserForm portTypeInputdeckUserForm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.updatePortTypeInputdeckUserForm(portTypeInputdeckUserForm);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _portTypeInputdeckUserFormLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_portTypeInputdeckUserFormLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _portTypeInputdeckUserFormLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.kisti.science.platform.app.model.PortTypeInputdeckUserForm> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.getAll();
	}

	@Override
	public com.kisti.science.platform.app.model.PortTypeInputdeckUserForm createPortTypeInputdeckUserForm(
		long userId, java.lang.String userName,
		java.lang.String inputdeckUserData, long portTypeId,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckUserFormLocalService.createPortTypeInputdeckUserForm(userId,
			userName, inputdeckUserData, portTypeId, sc);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PortTypeInputdeckUserFormLocalService getWrappedPortTypeInputdeckUserFormLocalService() {
		return _portTypeInputdeckUserFormLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPortTypeInputdeckUserFormLocalService(
		PortTypeInputdeckUserFormLocalService portTypeInputdeckUserFormLocalService) {
		_portTypeInputdeckUserFormLocalService = portTypeInputdeckUserFormLocalService;
	}

	@Override
	public PortTypeInputdeckUserFormLocalService getWrappedService() {
		return _portTypeInputdeckUserFormLocalService;
	}

	@Override
	public void setWrappedService(
		PortTypeInputdeckUserFormLocalService portTypeInputdeckUserFormLocalService) {
		_portTypeInputdeckUserFormLocalService = portTypeInputdeckUserFormLocalService;
	}

	private PortTypeInputdeckUserFormLocalService _portTypeInputdeckUserFormLocalService;
}