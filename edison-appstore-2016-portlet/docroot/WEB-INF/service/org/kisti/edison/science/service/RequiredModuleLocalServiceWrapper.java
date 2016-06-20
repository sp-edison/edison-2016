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
 * Provides a wrapper for {@link RequiredModuleLocalService}.
 *
 * @author EDISON
 * @see RequiredModuleLocalService
 * @generated
 */
public class RequiredModuleLocalServiceWrapper
	implements RequiredModuleLocalService,
		ServiceWrapper<RequiredModuleLocalService> {
	public RequiredModuleLocalServiceWrapper(
		RequiredModuleLocalService requiredModuleLocalService) {
		_requiredModuleLocalService = requiredModuleLocalService;
	}

	/**
	* Adds the required module to the database. Also notifies the appropriate model listeners.
	*
	* @param requiredModule the required module
	* @return the required module that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.RequiredModule addRequiredModule(
		org.kisti.edison.science.model.RequiredModule requiredModule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requiredModuleLocalService.addRequiredModule(requiredModule);
	}

	/**
	* Creates a new required module with the primary key. Does not add the required module to the database.
	*
	* @param requiredModuleId the primary key for the new required module
	* @return the new required module
	*/
	@Override
	public org.kisti.edison.science.model.RequiredModule createRequiredModule(
		long requiredModuleId) {
		return _requiredModuleLocalService.createRequiredModule(requiredModuleId);
	}

	/**
	* Deletes the required module with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requiredModuleId the primary key of the required module
	* @return the required module that was removed
	* @throws PortalException if a required module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.RequiredModule deleteRequiredModule(
		long requiredModuleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _requiredModuleLocalService.deleteRequiredModule(requiredModuleId);
	}

	/**
	* Deletes the required module from the database. Also notifies the appropriate model listeners.
	*
	* @param requiredModule the required module
	* @return the required module that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.RequiredModule deleteRequiredModule(
		org.kisti.edison.science.model.RequiredModule requiredModule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requiredModuleLocalService.deleteRequiredModule(requiredModule);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _requiredModuleLocalService.dynamicQuery();
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
		return _requiredModuleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _requiredModuleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _requiredModuleLocalService.dynamicQuery(dynamicQuery, start,
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
		return _requiredModuleLocalService.dynamicQueryCount(dynamicQuery);
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
		return _requiredModuleLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.science.model.RequiredModule fetchRequiredModule(
		long requiredModuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requiredModuleLocalService.fetchRequiredModule(requiredModuleId);
	}

	/**
	* Returns the required module with the primary key.
	*
	* @param requiredModuleId the primary key of the required module
	* @return the required module
	* @throws PortalException if a required module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.RequiredModule getRequiredModule(
		long requiredModuleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _requiredModuleLocalService.getRequiredModule(requiredModuleId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _requiredModuleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the required modules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of required modules
	* @param end the upper bound of the range of required modules (not inclusive)
	* @return the range of required modules
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.science.model.RequiredModule> getRequiredModules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requiredModuleLocalService.getRequiredModules(start, end);
	}

	/**
	* Returns the number of required modules.
	*
	* @return the number of required modules
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRequiredModulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requiredModuleLocalService.getRequiredModulesCount();
	}

	/**
	* Updates the required module in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param requiredModule the required module
	* @return the required module that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.RequiredModule updateRequiredModule(
		org.kisti.edison.science.model.RequiredModule requiredModule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _requiredModuleLocalService.updateRequiredModule(requiredModule);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _requiredModuleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_requiredModuleLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _requiredModuleLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RequiredModuleLocalService getWrappedRequiredModuleLocalService() {
		return _requiredModuleLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRequiredModuleLocalService(
		RequiredModuleLocalService requiredModuleLocalService) {
		_requiredModuleLocalService = requiredModuleLocalService;
	}

	@Override
	public RequiredModuleLocalService getWrappedService() {
		return _requiredModuleLocalService;
	}

	@Override
	public void setWrappedService(
		RequiredModuleLocalService requiredModuleLocalService) {
		_requiredModuleLocalService = requiredModuleLocalService;
	}

	private RequiredModuleLocalService _requiredModuleLocalService;
}