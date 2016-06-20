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
 * Provides a wrapper for {@link CommonLibraryLocalService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see CommonLibraryLocalService
 * @generated
 */
public class CommonLibraryLocalServiceWrapper
	implements CommonLibraryLocalService,
		ServiceWrapper<CommonLibraryLocalService> {
	public CommonLibraryLocalServiceWrapper(
		CommonLibraryLocalService commonLibraryLocalService) {
		_commonLibraryLocalService = commonLibraryLocalService;
	}

	/**
	* Adds the common library to the database. Also notifies the appropriate model listeners.
	*
	* @param commonLibrary the common library
	* @return the common library that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonLibrary addCommonLibrary(
		com.kisti.science.platform.app.model.CommonLibrary commonLibrary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibraryLocalService.addCommonLibrary(commonLibrary);
	}

	/**
	* Creates a new common library with the primary key. Does not add the common library to the database.
	*
	* @param commonLibraryPK the primary key for the new common library
	* @return the new common library
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonLibrary createCommonLibrary(
		com.kisti.science.platform.app.service.persistence.CommonLibraryPK commonLibraryPK) {
		return _commonLibraryLocalService.createCommonLibrary(commonLibraryPK);
	}

	/**
	* Deletes the common library with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commonLibraryPK the primary key of the common library
	* @return the common library that was removed
	* @throws PortalException if a common library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonLibrary deleteCommonLibrary(
		com.kisti.science.platform.app.service.persistence.CommonLibraryPK commonLibraryPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commonLibraryLocalService.deleteCommonLibrary(commonLibraryPK);
	}

	/**
	* Deletes the common library from the database. Also notifies the appropriate model listeners.
	*
	* @param commonLibrary the common library
	* @return the common library that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonLibrary deleteCommonLibrary(
		com.kisti.science.platform.app.model.CommonLibrary commonLibrary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibraryLocalService.deleteCommonLibrary(commonLibrary);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commonLibraryLocalService.dynamicQuery();
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
		return _commonLibraryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _commonLibraryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _commonLibraryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _commonLibraryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _commonLibraryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kisti.science.platform.app.model.CommonLibrary fetchCommonLibrary(
		com.kisti.science.platform.app.service.persistence.CommonLibraryPK commonLibraryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibraryLocalService.fetchCommonLibrary(commonLibraryPK);
	}

	/**
	* Returns the common library with the primary key.
	*
	* @param commonLibraryPK the primary key of the common library
	* @return the common library
	* @throws PortalException if a common library with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonLibrary getCommonLibrary(
		com.kisti.science.platform.app.service.persistence.CommonLibraryPK commonLibraryPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commonLibraryLocalService.getCommonLibrary(commonLibraryPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commonLibraryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the common libraries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.CommonLibraryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common libraries
	* @param end the upper bound of the range of common libraries (not inclusive)
	* @return the range of common libraries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kisti.science.platform.app.model.CommonLibrary> getCommonLibraries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibraryLocalService.getCommonLibraries(start, end);
	}

	/**
	* Returns the number of common libraries.
	*
	* @return the number of common libraries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCommonLibrariesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibraryLocalService.getCommonLibrariesCount();
	}

	/**
	* Updates the common library in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commonLibrary the common library
	* @return the common library that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.CommonLibrary updateCommonLibrary(
		com.kisti.science.platform.app.model.CommonLibrary commonLibrary)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibraryLocalService.updateCommonLibrary(commonLibrary);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _commonLibraryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_commonLibraryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _commonLibraryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CommonLibraryLocalService getWrappedCommonLibraryLocalService() {
		return _commonLibraryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCommonLibraryLocalService(
		CommonLibraryLocalService commonLibraryLocalService) {
		_commonLibraryLocalService = commonLibraryLocalService;
	}

	@Override
	public CommonLibraryLocalService getWrappedService() {
		return _commonLibraryLocalService;
	}

	@Override
	public void setWrappedService(
		CommonLibraryLocalService commonLibraryLocalService) {
		_commonLibraryLocalService = commonLibraryLocalService;
	}

	private CommonLibraryLocalService _commonLibraryLocalService;
}