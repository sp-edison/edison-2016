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
 * Provides a wrapper for {@link ScienceAppOutputPortsLocalService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppOutputPortsLocalService
 * @generated
 */
public class ScienceAppOutputPortsLocalServiceWrapper
	implements ScienceAppOutputPortsLocalService,
		ServiceWrapper<ScienceAppOutputPortsLocalService> {
	public ScienceAppOutputPortsLocalServiceWrapper(
		ScienceAppOutputPortsLocalService scienceAppOutputPortsLocalService) {
		_scienceAppOutputPortsLocalService = scienceAppOutputPortsLocalService;
	}

	/**
	* Adds the science app output ports to the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppOutputPorts the science app output ports
	* @return the science app output ports that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts addScienceAppOutputPorts(
		com.kisti.science.platform.app.model.ScienceAppOutputPorts scienceAppOutputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppOutputPortsLocalService.addScienceAppOutputPorts(scienceAppOutputPorts);
	}

	/**
	* Creates a new science app output ports with the primary key. Does not add the science app output ports to the database.
	*
	* @param scienceAppId the primary key for the new science app output ports
	* @return the new science app output ports
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts createScienceAppOutputPorts(
		long scienceAppId) {
		return _scienceAppOutputPortsLocalService.createScienceAppOutputPorts(scienceAppId);
	}

	/**
	* Deletes the science app output ports with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppId the primary key of the science app output ports
	* @return the science app output ports that was removed
	* @throws PortalException if a science app output ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts deleteScienceAppOutputPorts(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppOutputPortsLocalService.deleteScienceAppOutputPorts(scienceAppId);
	}

	/**
	* Deletes the science app output ports from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppOutputPorts the science app output ports
	* @return the science app output ports that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts deleteScienceAppOutputPorts(
		com.kisti.science.platform.app.model.ScienceAppOutputPorts scienceAppOutputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppOutputPortsLocalService.deleteScienceAppOutputPorts(scienceAppOutputPorts);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _scienceAppOutputPortsLocalService.dynamicQuery();
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
		return _scienceAppOutputPortsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppOutputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _scienceAppOutputPortsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppOutputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _scienceAppOutputPortsLocalService.dynamicQuery(dynamicQuery,
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
		return _scienceAppOutputPortsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _scienceAppOutputPortsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts fetchScienceAppOutputPorts(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppOutputPortsLocalService.fetchScienceAppOutputPorts(scienceAppId);
	}

	/**
	* Returns the science app output ports with the primary key.
	*
	* @param scienceAppId the primary key of the science app output ports
	* @return the science app output ports
	* @throws PortalException if a science app output ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts getScienceAppOutputPorts(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppOutputPortsLocalService.getScienceAppOutputPorts(scienceAppId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppOutputPortsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the science app output portses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppOutputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app output portses
	* @param end the upper bound of the range of science app output portses (not inclusive)
	* @return the range of science app output portses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppOutputPorts> getScienceAppOutputPortses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppOutputPortsLocalService.getScienceAppOutputPortses(start,
			end);
	}

	/**
	* Returns the number of science app output portses.
	*
	* @return the number of science app output portses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getScienceAppOutputPortsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppOutputPortsLocalService.getScienceAppOutputPortsesCount();
	}

	/**
	* Updates the science app output ports in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scienceAppOutputPorts the science app output ports
	* @return the science app output ports that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts updateScienceAppOutputPorts(
		com.kisti.science.platform.app.model.ScienceAppOutputPorts scienceAppOutputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppOutputPortsLocalService.updateScienceAppOutputPorts(scienceAppOutputPorts);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scienceAppOutputPortsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scienceAppOutputPortsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scienceAppOutputPortsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceAppOutputPorts create(
		long scienceAppId, java.lang.String outputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppOutputPortsLocalService.create(scienceAppId,
			outputPorts);
	}

	@Override
	public java.lang.String getOutputPortsJsonString(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppOutputPortsLocalService.getOutputPortsJsonString(scienceAppId);
	}

	@Override
	public void removeAllOutputPorts()
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppOutputPortsLocalService.removeAllOutputPorts();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScienceAppOutputPortsLocalService getWrappedScienceAppOutputPortsLocalService() {
		return _scienceAppOutputPortsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScienceAppOutputPortsLocalService(
		ScienceAppOutputPortsLocalService scienceAppOutputPortsLocalService) {
		_scienceAppOutputPortsLocalService = scienceAppOutputPortsLocalService;
	}

	@Override
	public ScienceAppOutputPortsLocalService getWrappedService() {
		return _scienceAppOutputPortsLocalService;
	}

	@Override
	public void setWrappedService(
		ScienceAppOutputPortsLocalService scienceAppOutputPortsLocalService) {
		_scienceAppOutputPortsLocalService = scienceAppOutputPortsLocalService;
	}

	private ScienceAppOutputPortsLocalService _scienceAppOutputPortsLocalService;
}