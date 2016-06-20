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
 * Provides a wrapper for {@link CommonPackageLocalService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonPackageLocalService
 * @generated
 */
public class CommonPackageLocalServiceWrapper
	implements CommonPackageLocalService,
		ServiceWrapper<CommonPackageLocalService> {
	public CommonPackageLocalServiceWrapper(
		CommonPackageLocalService commonPackageLocalService) {
		_commonPackageLocalService = commonPackageLocalService;
	}

	/**
	* Adds the common package to the database. Also notifies the appropriate model listeners.
	*
	* @param commonPackage the common package
	* @return the common package that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonPackage addCommonPackage(
		com.kisti.science.platform.app.model.CommonPackage commonPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonPackageLocalService.addCommonPackage(commonPackage);
	}

	/**
	* Creates a new common package with the primary key. Does not add the common package to the database.
	*
	* @param commonPackagePK the primary key for the new common package
	* @return the new common package
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonPackage createCommonPackage(
		com.kisti.science.platform.app.service.persistence.CommonPackagePK commonPackagePK) {
		return _commonPackageLocalService.createCommonPackage(commonPackagePK);
	}

	/**
	* Deletes the common package with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commonPackagePK the primary key of the common package
	* @return the common package that was removed
	* @throws PortalException if a common package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonPackage deleteCommonPackage(
		com.kisti.science.platform.app.service.persistence.CommonPackagePK commonPackagePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commonPackageLocalService.deleteCommonPackage(commonPackagePK);
	}

	/**
	* Deletes the common package from the database. Also notifies the appropriate model listeners.
	*
	* @param commonPackage the common package
	* @return the common package that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonPackage deleteCommonPackage(
		com.kisti.science.platform.app.model.CommonPackage commonPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonPackageLocalService.deleteCommonPackage(commonPackage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commonPackageLocalService.dynamicQuery();
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
		return _commonPackageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _commonPackageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _commonPackageLocalService.dynamicQuery(dynamicQuery, start,
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
		return _commonPackageLocalService.dynamicQueryCount(dynamicQuery);
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
		return _commonPackageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kisti.science.platform.app.model.CommonPackage fetchCommonPackage(
		com.kisti.science.platform.app.service.persistence.CommonPackagePK commonPackagePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonPackageLocalService.fetchCommonPackage(commonPackagePK);
	}

	/**
	* Returns the common package with the primary key.
	*
	* @param commonPackagePK the primary key of the common package
	* @return the common package
	* @throws PortalException if a common package with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonPackage getCommonPackage(
		com.kisti.science.platform.app.service.persistence.CommonPackagePK commonPackagePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commonPackageLocalService.getCommonPackage(commonPackagePK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commonPackageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the common packages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonPackageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common packages
	* @param end the upper bound of the range of common packages (not inclusive)
	* @return the range of common packages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kisti.science.platform.app.model.CommonPackage> getCommonPackages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonPackageLocalService.getCommonPackages(start, end);
	}

	/**
	* Returns the number of common packages.
	*
	* @return the number of common packages
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCommonPackagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonPackageLocalService.getCommonPackagesCount();
	}

	/**
	* Updates the common package in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commonPackage the common package
	* @return the common package that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonPackage updateCommonPackage(
		com.kisti.science.platform.app.model.CommonPackage commonPackage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonPackageLocalService.updateCommonPackage(commonPackage);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _commonPackageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_commonPackageLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _commonPackageLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CommonPackageLocalService getWrappedCommonPackageLocalService() {
		return _commonPackageLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCommonPackageLocalService(
		CommonPackageLocalService commonPackageLocalService) {
		_commonPackageLocalService = commonPackageLocalService;
	}

	@Override
	public CommonPackageLocalService getWrappedService() {
		return _commonPackageLocalService;
	}

	@Override
	public void setWrappedService(
		CommonPackageLocalService commonPackageLocalService) {
		_commonPackageLocalService = commonPackageLocalService;
	}

	private CommonPackageLocalService _commonPackageLocalService;
}