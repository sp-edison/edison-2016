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
 * Provides a wrapper for {@link CommonModuleLocalService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonModuleLocalService
 * @generated
 */
public class CommonModuleLocalServiceWrapper implements CommonModuleLocalService,
	ServiceWrapper<CommonModuleLocalService> {
	public CommonModuleLocalServiceWrapper(
		CommonModuleLocalService commonModuleLocalService) {
		_commonModuleLocalService = commonModuleLocalService;
	}

	/**
	* Adds the common module to the database. Also notifies the appropriate model listeners.
	*
	* @param commonModule the common module
	* @return the common module that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonModule addCommonModule(
		com.kisti.science.platform.app.model.CommonModule commonModule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonModuleLocalService.addCommonModule(commonModule);
	}

	/**
	* Creates a new common module with the primary key. Does not add the common module to the database.
	*
	* @param moduleName the primary key for the new common module
	* @return the new common module
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonModule createCommonModule(
		java.lang.String moduleName) {
		return _commonModuleLocalService.createCommonModule(moduleName);
	}

	/**
	* Deletes the common module with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param moduleName the primary key of the common module
	* @return the common module that was removed
	* @throws PortalException if a common module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonModule deleteCommonModule(
		java.lang.String moduleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commonModuleLocalService.deleteCommonModule(moduleName);
	}

	/**
	* Deletes the common module from the database. Also notifies the appropriate model listeners.
	*
	* @param commonModule the common module
	* @return the common module that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonModule deleteCommonModule(
		com.kisti.science.platform.app.model.CommonModule commonModule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonModuleLocalService.deleteCommonModule(commonModule);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commonModuleLocalService.dynamicQuery();
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
		return _commonModuleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _commonModuleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _commonModuleLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _commonModuleLocalService.dynamicQueryCount(dynamicQuery);
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
		return _commonModuleLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kisti.science.platform.app.model.CommonModule fetchCommonModule(
		java.lang.String moduleName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonModuleLocalService.fetchCommonModule(moduleName);
	}

	/**
	* Returns the common module with the primary key.
	*
	* @param moduleName the primary key of the common module
	* @return the common module
	* @throws PortalException if a common module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonModule getCommonModule(
		java.lang.String moduleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commonModuleLocalService.getCommonModule(moduleName);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commonModuleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the common modules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common modules
	* @param end the upper bound of the range of common modules (not inclusive)
	* @return the range of common modules
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kisti.science.platform.app.model.CommonModule> getCommonModules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonModuleLocalService.getCommonModules(start, end);
	}

	/**
	* Returns the number of common modules.
	*
	* @return the number of common modules
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCommonModulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonModuleLocalService.getCommonModulesCount();
	}

	/**
	* Updates the common module in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commonModule the common module
	* @return the common module that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonModule updateCommonModule(
		com.kisti.science.platform.app.model.CommonModule commonModule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonModuleLocalService.updateCommonModule(commonModule);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _commonModuleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_commonModuleLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _commonModuleLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CommonModuleLocalService getWrappedCommonModuleLocalService() {
		return _commonModuleLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCommonModuleLocalService(
		CommonModuleLocalService commonModuleLocalService) {
		_commonModuleLocalService = commonModuleLocalService;
	}

	@Override
	public CommonModuleLocalService getWrappedService() {
		return _commonModuleLocalService;
	}

	@Override
	public void setWrappedService(
		CommonModuleLocalService commonModuleLocalService) {
		_commonModuleLocalService = commonModuleLocalService;
	}

	private CommonModuleLocalService _commonModuleLocalService;
}