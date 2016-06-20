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
 * Provides a wrapper for {@link DeveloperRequestLocalService}.
 *
 * @author EDISON
 * @see DeveloperRequestLocalService
 * @generated
 */
public class DeveloperRequestLocalServiceWrapper
	implements DeveloperRequestLocalService,
		ServiceWrapper<DeveloperRequestLocalService> {
	public DeveloperRequestLocalServiceWrapper(
		DeveloperRequestLocalService developerRequestLocalService) {
		_developerRequestLocalService = developerRequestLocalService;
	}

	/**
	* Adds the developer request to the database. Also notifies the appropriate model listeners.
	*
	* @param developerRequest the developer request
	* @return the developer request that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperRequest addDeveloperRequest(
		org.kisti.edison.science.model.DeveloperRequest developerRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerRequestLocalService.addDeveloperRequest(developerRequest);
	}

	/**
	* Creates a new developer request with the primary key. Does not add the developer request to the database.
	*
	* @param developerRequestPK the primary key for the new developer request
	* @return the new developer request
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperRequest createDeveloperRequest(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK) {
		return _developerRequestLocalService.createDeveloperRequest(developerRequestPK);
	}

	/**
	* Deletes the developer request with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param developerRequestPK the primary key of the developer request
	* @return the developer request that was removed
	* @throws PortalException if a developer request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperRequest deleteDeveloperRequest(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _developerRequestLocalService.deleteDeveloperRequest(developerRequestPK);
	}

	/**
	* Deletes the developer request from the database. Also notifies the appropriate model listeners.
	*
	* @param developerRequest the developer request
	* @return the developer request that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperRequest deleteDeveloperRequest(
		org.kisti.edison.science.model.DeveloperRequest developerRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerRequestLocalService.deleteDeveloperRequest(developerRequest);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _developerRequestLocalService.dynamicQuery();
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
		return _developerRequestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _developerRequestLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _developerRequestLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _developerRequestLocalService.dynamicQueryCount(dynamicQuery);
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
		return _developerRequestLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.science.model.DeveloperRequest fetchDeveloperRequest(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerRequestLocalService.fetchDeveloperRequest(developerRequestPK);
	}

	/**
	* Returns the developer request with the primary key.
	*
	* @param developerRequestPK the primary key of the developer request
	* @return the developer request
	* @throws PortalException if a developer request with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperRequest getDeveloperRequest(
		org.kisti.edison.science.service.persistence.DeveloperRequestPK developerRequestPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _developerRequestLocalService.getDeveloperRequest(developerRequestPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _developerRequestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the developer requests.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of developer requests
	* @param end the upper bound of the range of developer requests (not inclusive)
	* @return the range of developer requests
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.science.model.DeveloperRequest> getDeveloperRequests(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerRequestLocalService.getDeveloperRequests(start, end);
	}

	/**
	* Returns the number of developer requests.
	*
	* @return the number of developer requests
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDeveloperRequestsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerRequestLocalService.getDeveloperRequestsCount();
	}

	/**
	* Updates the developer request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param developerRequest the developer request
	* @return the developer request that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperRequest updateDeveloperRequest(
		org.kisti.edison.science.model.DeveloperRequest developerRequest)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerRequestLocalService.updateDeveloperRequest(developerRequest);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _developerRequestLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_developerRequestLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _developerRequestLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListCustomDeveloperRequest(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		return _developerRequestLocalService.getListCustomDeveloperRequest(params,
			locale);
	}

	@Override
	public org.kisti.edison.science.model.DeveloperRequest insertCustomDeveloperRequest(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		return _developerRequestLocalService.insertCustomDeveloperRequest(params);
	}

	@Override
	public org.kisti.edison.science.model.DeveloperRequest deleteCustomDeveloperRequest(
		java.util.Map<java.lang.String, java.lang.String> params)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException,
			org.kisti.edison.science.NoSuchDeveloperRequestException {
		return _developerRequestLocalService.deleteCustomDeveloperRequest(params);
	}

	@Override
	public void updateDeveloperRequestStatus(long userId, long groupId,
		java.lang.String workspaceStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		_developerRequestLocalService.updateDeveloperRequestStatus(userId,
			groupId, workspaceStatus);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DeveloperRequestLocalService getWrappedDeveloperRequestLocalService() {
		return _developerRequestLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDeveloperRequestLocalService(
		DeveloperRequestLocalService developerRequestLocalService) {
		_developerRequestLocalService = developerRequestLocalService;
	}

	@Override
	public DeveloperRequestLocalService getWrappedService() {
		return _developerRequestLocalService;
	}

	@Override
	public void setWrappedService(
		DeveloperRequestLocalService developerRequestLocalService) {
		_developerRequestLocalService = developerRequestLocalService;
	}

	private DeveloperRequestLocalService _developerRequestLocalService;
}