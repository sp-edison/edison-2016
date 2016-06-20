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
 * Provides a wrapper for {@link ScienceAppInputPortsLocalService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppInputPortsLocalService
 * @generated
 */
public class ScienceAppInputPortsLocalServiceWrapper
	implements ScienceAppInputPortsLocalService,
		ServiceWrapper<ScienceAppInputPortsLocalService> {
	public ScienceAppInputPortsLocalServiceWrapper(
		ScienceAppInputPortsLocalService scienceAppInputPortsLocalService) {
		_scienceAppInputPortsLocalService = scienceAppInputPortsLocalService;
	}

	/**
	* Adds the science app input ports to the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppInputPorts the science app input ports
	* @return the science app input ports that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceAppInputPorts addScienceAppInputPorts(
		com.kisti.science.platform.app.model.ScienceAppInputPorts scienceAppInputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppInputPortsLocalService.addScienceAppInputPorts(scienceAppInputPorts);
	}

	/**
	* Creates a new science app input ports with the primary key. Does not add the science app input ports to the database.
	*
	* @param scienceAppId the primary key for the new science app input ports
	* @return the new science app input ports
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceAppInputPorts createScienceAppInputPorts(
		long scienceAppId) {
		return _scienceAppInputPortsLocalService.createScienceAppInputPorts(scienceAppId);
	}

	/**
	* Deletes the science app input ports with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppId the primary key of the science app input ports
	* @return the science app input ports that was removed
	* @throws PortalException if a science app input ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceAppInputPorts deleteScienceAppInputPorts(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppInputPortsLocalService.deleteScienceAppInputPorts(scienceAppId);
	}

	/**
	* Deletes the science app input ports from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppInputPorts the science app input ports
	* @return the science app input ports that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceAppInputPorts deleteScienceAppInputPorts(
		com.kisti.science.platform.app.model.ScienceAppInputPorts scienceAppInputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppInputPortsLocalService.deleteScienceAppInputPorts(scienceAppInputPorts);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _scienceAppInputPortsLocalService.dynamicQuery();
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
		return _scienceAppInputPortsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppInputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _scienceAppInputPortsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppInputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _scienceAppInputPortsLocalService.dynamicQuery(dynamicQuery,
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
		return _scienceAppInputPortsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _scienceAppInputPortsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceAppInputPorts fetchScienceAppInputPorts(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppInputPortsLocalService.fetchScienceAppInputPorts(scienceAppId);
	}

	/**
	* Returns the science app input ports with the primary key.
	*
	* @param scienceAppId the primary key of the science app input ports
	* @return the science app input ports
	* @throws PortalException if a science app input ports with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceAppInputPorts getScienceAppInputPorts(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppInputPortsLocalService.getScienceAppInputPorts(scienceAppId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppInputPortsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the science app input portses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppInputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app input portses
	* @param end the upper bound of the range of science app input portses (not inclusive)
	* @return the range of science app input portses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppInputPorts> getScienceAppInputPortses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppInputPortsLocalService.getScienceAppInputPortses(start,
			end);
	}

	/**
	* Returns the number of science app input portses.
	*
	* @return the number of science app input portses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getScienceAppInputPortsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppInputPortsLocalService.getScienceAppInputPortsesCount();
	}

	/**
	* Updates the science app input ports in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scienceAppInputPorts the science app input ports
	* @return the science app input ports that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.ScienceAppInputPorts updateScienceAppInputPorts(
		com.kisti.science.platform.app.model.ScienceAppInputPorts scienceAppInputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppInputPortsLocalService.updateScienceAppInputPorts(scienceAppInputPorts);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _scienceAppInputPortsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_scienceAppInputPortsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _scienceAppInputPortsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.kisti.science.platform.app.model.ScienceAppInputPorts create(
		long scienceAppId, java.lang.String inputPorts)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppInputPortsLocalService.create(scienceAppId, inputPorts);
	}

	@Override
	public java.lang.String getInputPortsJsonString(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _scienceAppInputPortsLocalService.getInputPortsJsonString(scienceAppId);
	}

	@Override
	public void removeAllInputPorts()
		throws com.liferay.portal.kernel.exception.SystemException {
		_scienceAppInputPortsLocalService.removeAllInputPorts();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ScienceAppInputPortsLocalService getWrappedScienceAppInputPortsLocalService() {
		return _scienceAppInputPortsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedScienceAppInputPortsLocalService(
		ScienceAppInputPortsLocalService scienceAppInputPortsLocalService) {
		_scienceAppInputPortsLocalService = scienceAppInputPortsLocalService;
	}

	@Override
	public ScienceAppInputPortsLocalService getWrappedService() {
		return _scienceAppInputPortsLocalService;
	}

	@Override
	public void setWrappedService(
		ScienceAppInputPortsLocalService scienceAppInputPortsLocalService) {
		_scienceAppInputPortsLocalService = scienceAppInputPortsLocalService;
	}

	private ScienceAppInputPortsLocalService _scienceAppInputPortsLocalService;
}