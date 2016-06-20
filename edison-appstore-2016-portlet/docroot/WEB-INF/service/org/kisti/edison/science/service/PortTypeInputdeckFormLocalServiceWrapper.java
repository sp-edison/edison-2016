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

package org.kisti.edison.science.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PortTypeInputdeckFormLocalService}.
 *
 * @author EDISON
 * @see PortTypeInputdeckFormLocalService
 * @generated
 */
public class PortTypeInputdeckFormLocalServiceWrapper
	implements PortTypeInputdeckFormLocalService,
		ServiceWrapper<PortTypeInputdeckFormLocalService> {
	public PortTypeInputdeckFormLocalServiceWrapper(
		PortTypeInputdeckFormLocalService portTypeInputdeckFormLocalService) {
		_portTypeInputdeckFormLocalService = portTypeInputdeckFormLocalService;
	}

	/**
	* Adds the port type inputdeck form to the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeInputdeckForm the port type inputdeck form
	* @return the port type inputdeck form that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.PortTypeInputdeckForm addPortTypeInputdeckForm(
		org.kisti.edison.science.model.PortTypeInputdeckForm portTypeInputdeckForm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckFormLocalService.addPortTypeInputdeckForm(portTypeInputdeckForm);
	}

	/**
	* Creates a new port type inputdeck form with the primary key. Does not add the port type inputdeck form to the database.
	*
	* @param portTypeId the primary key for the new port type inputdeck form
	* @return the new port type inputdeck form
	*/
	@Override
	public org.kisti.edison.science.model.PortTypeInputdeckForm createPortTypeInputdeckForm(
		long portTypeId) {
		return _portTypeInputdeckFormLocalService.createPortTypeInputdeckForm(portTypeId);
	}

	/**
	* Deletes the port type inputdeck form with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeId the primary key of the port type inputdeck form
	* @return the port type inputdeck form that was removed
	* @throws PortalException if a port type inputdeck form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.PortTypeInputdeckForm deletePortTypeInputdeckForm(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckFormLocalService.deletePortTypeInputdeckForm(portTypeId);
	}

	/**
	* Deletes the port type inputdeck form from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeInputdeckForm the port type inputdeck form
	* @return the port type inputdeck form that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.PortTypeInputdeckForm deletePortTypeInputdeckForm(
		org.kisti.edison.science.model.PortTypeInputdeckForm portTypeInputdeckForm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckFormLocalService.deletePortTypeInputdeckForm(portTypeInputdeckForm);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _portTypeInputdeckFormLocalService.dynamicQuery();
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
		return _portTypeInputdeckFormLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeInputdeckFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _portTypeInputdeckFormLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeInputdeckFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _portTypeInputdeckFormLocalService.dynamicQuery(dynamicQuery,
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
		return _portTypeInputdeckFormLocalService.dynamicQueryCount(dynamicQuery);
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
		return _portTypeInputdeckFormLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.science.model.PortTypeInputdeckForm fetchPortTypeInputdeckForm(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckFormLocalService.fetchPortTypeInputdeckForm(portTypeId);
	}

	/**
	* Returns the port type inputdeck form with the primary key.
	*
	* @param portTypeId the primary key of the port type inputdeck form
	* @return the port type inputdeck form
	* @throws PortalException if a port type inputdeck form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.PortTypeInputdeckForm getPortTypeInputdeckForm(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckFormLocalService.getPortTypeInputdeckForm(portTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckFormLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the port type inputdeck forms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeInputdeckFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type inputdeck forms
	* @param end the upper bound of the range of port type inputdeck forms (not inclusive)
	* @return the range of port type inputdeck forms
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.science.model.PortTypeInputdeckForm> getPortTypeInputdeckForms(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckFormLocalService.getPortTypeInputdeckForms(start,
			end);
	}

	/**
	* Returns the number of port type inputdeck forms.
	*
	* @return the number of port type inputdeck forms
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPortTypeInputdeckFormsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckFormLocalService.getPortTypeInputdeckFormsCount();
	}

	/**
	* Updates the port type inputdeck form in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portTypeInputdeckForm the port type inputdeck form
	* @return the port type inputdeck form that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.PortTypeInputdeckForm updatePortTypeInputdeckForm(
		org.kisti.edison.science.model.PortTypeInputdeckForm portTypeInputdeckForm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckFormLocalService.updatePortTypeInputdeckForm(portTypeInputdeckForm);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _portTypeInputdeckFormLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_portTypeInputdeckFormLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _portTypeInputdeckFormLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public org.kisti.edison.science.model.PortTypeInputdeckForm create(
		long portTypeId, java.lang.String inputdeckForm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckFormLocalService.create(portTypeId,
			inputdeckForm);
	}

	@Override
	public java.lang.String getInputdeckFormJsonString(long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeInputdeckFormLocalService.getInputdeckFormJsonString(portTypeId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PortTypeInputdeckFormLocalService getWrappedPortTypeInputdeckFormLocalService() {
		return _portTypeInputdeckFormLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPortTypeInputdeckFormLocalService(
		PortTypeInputdeckFormLocalService portTypeInputdeckFormLocalService) {
		_portTypeInputdeckFormLocalService = portTypeInputdeckFormLocalService;
	}

	@Override
	public PortTypeInputdeckFormLocalService getWrappedService() {
		return _portTypeInputdeckFormLocalService;
	}

	@Override
	public void setWrappedService(
		PortTypeInputdeckFormLocalService portTypeInputdeckFormLocalService) {
		_portTypeInputdeckFormLocalService = portTypeInputdeckFormLocalService;
	}

	private PortTypeInputdeckFormLocalService _portTypeInputdeckFormLocalService;
}