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
 * Provides a wrapper for {@link PortTypeLocalService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeLocalService
 * @generated
 */
public class PortTypeLocalServiceWrapper implements PortTypeLocalService,
	ServiceWrapper<PortTypeLocalService> {
	public PortTypeLocalServiceWrapper(
		PortTypeLocalService portTypeLocalService) {
		_portTypeLocalService = portTypeLocalService;
	}

	/**
	* Adds the port type to the database. Also notifies the appropriate model listeners.
	*
	* @param portType the port type
	* @return the port type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortType addPortType(
		com.kisti.science.platform.app.model.PortType portType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeLocalService.addPortType(portType);
	}

	/**
	* Creates a new port type with the primary key. Does not add the port type to the database.
	*
	* @param portTypeId the primary key for the new port type
	* @return the new port type
	*/
	@Override
	public com.kisti.science.platform.app.model.PortType createPortType(
		long portTypeId) {
		return _portTypeLocalService.createPortType(portTypeId);
	}

	/**
	* Deletes the port type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeId the primary key of the port type
	* @return the port type that was removed
	* @throws PortalException if a port type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortType deletePortType(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeLocalService.deletePortType(portTypeId);
	}

	/**
	* Deletes the port type from the database. Also notifies the appropriate model listeners.
	*
	* @param portType the port type
	* @return the port type that was removed
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortType deletePortType(
		com.kisti.science.platform.app.model.PortType portType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeLocalService.deletePortType(portType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _portTypeLocalService.dynamicQuery();
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
		return _portTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _portTypeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _portTypeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _portTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _portTypeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.kisti.science.platform.app.model.PortType fetchPortType(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeLocalService.fetchPortType(portTypeId);
	}

	/**
	* Returns the port type with the matching UUID and company.
	*
	* @param uuid the port type's UUID
	* @param companyId the primary key of the company
	* @return the matching port type, or <code>null</code> if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortType fetchPortTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeLocalService.fetchPortTypeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the port type with the primary key.
	*
	* @param portTypeId the primary key of the port type
	* @return the port type
	* @throws PortalException if a port type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortType getPortType(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeLocalService.getPortType(portTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the port type with the matching UUID and company.
	*
	* @param uuid the port type's UUID
	* @param companyId the primary key of the company
	* @return the matching port type
	* @throws PortalException if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortType getPortTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeLocalService.getPortTypeByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of all the port types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port types
	* @param end the upper bound of the range of port types (not inclusive)
	* @return the range of port types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kisti.science.platform.app.model.PortType> getPortTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeLocalService.getPortTypes(start, end);
	}

	/**
	* Returns the number of port types.
	*
	* @return the number of port types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPortTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeLocalService.getPortTypesCount();
	}

	/**
	* Updates the port type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portType the port type
	* @return the port type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortType updatePortType(
		com.kisti.science.platform.app.model.PortType portType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeLocalService.updatePortType(portType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _portTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_portTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _portTypeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Create a port type of a science app. If provided new port type name already exist, returns null instance.
	* Created new port type is not saved in database physically.
	*
	* @author Jerry H. Seo
	* @param String portTypeName
	* @param ServiceContext sc
	* @throws SystemException
	* @return PortType instance
	*/
	@Override
	public com.kisti.science.platform.app.model.PortType createPortType(
		java.lang.String portTypeName,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeLocalService.createPortType(portTypeName, sc);
	}

	/**
	* @param portTypeName
	* @return
	* @throws SystemException
	* @see com.kisti.science.platform.service.PortTypeLocalService#existPortType(java.lang.String)
	*/
	@Override
	public boolean existPortType(java.lang.String portTypeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeLocalService.existPortType(portTypeName);
	}

	@Override
	public void setPortTypeInputdeckForm(long portTypeId,
		java.lang.String inputdeckForm)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_portTypeLocalService.setPortTypeInputdeckForm(portTypeId, inputdeckForm);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PortTypeLocalService getWrappedPortTypeLocalService() {
		return _portTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPortTypeLocalService(
		PortTypeLocalService portTypeLocalService) {
		_portTypeLocalService = portTypeLocalService;
	}

	@Override
	public PortTypeLocalService getWrappedService() {
		return _portTypeLocalService;
	}

	@Override
	public void setWrappedService(PortTypeLocalService portTypeLocalService) {
		_portTypeLocalService = portTypeLocalService;
	}

	private PortTypeLocalService _portTypeLocalService;
}