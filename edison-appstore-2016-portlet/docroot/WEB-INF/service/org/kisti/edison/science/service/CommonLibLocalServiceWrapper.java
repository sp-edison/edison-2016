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
 * Provides a wrapper for {@link CommonLibLocalService}.
 *
 * @author EDISON
 * @see CommonLibLocalService
 * @generated
 */
public class CommonLibLocalServiceWrapper implements CommonLibLocalService,
	ServiceWrapper<CommonLibLocalService> {
	public CommonLibLocalServiceWrapper(
		CommonLibLocalService commonLibLocalService) {
		_commonLibLocalService = commonLibLocalService;
	}

	/**
	* Adds the common lib to the database. Also notifies the appropriate model listeners.
	*
	* @param commonLib the common lib
	* @return the common lib that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.CommonLib addCommonLib(
		org.kisti.edison.science.model.CommonLib commonLib)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibLocalService.addCommonLib(commonLib);
	}

	/**
	* Creates a new common lib with the primary key. Does not add the common lib to the database.
	*
	* @param commonLibPK the primary key for the new common lib
	* @return the new common lib
	*/
	@Override
	public org.kisti.edison.science.model.CommonLib createCommonLib(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK) {
		return _commonLibLocalService.createCommonLib(commonLibPK);
	}

	/**
	* Deletes the common lib with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param commonLibPK the primary key of the common lib
	* @return the common lib that was removed
	* @throws PortalException if a common lib with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.CommonLib deleteCommonLib(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commonLibLocalService.deleteCommonLib(commonLibPK);
	}

	/**
	* Deletes the common lib from the database. Also notifies the appropriate model listeners.
	*
	* @param commonLib the common lib
	* @return the common lib that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.CommonLib deleteCommonLib(
		org.kisti.edison.science.model.CommonLib commonLib)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibLocalService.deleteCommonLib(commonLib);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commonLibLocalService.dynamicQuery();
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
		return _commonLibLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _commonLibLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _commonLibLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _commonLibLocalService.dynamicQueryCount(dynamicQuery);
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
		return _commonLibLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.kisti.edison.science.model.CommonLib fetchCommonLib(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibLocalService.fetchCommonLib(commonLibPK);
	}

	/**
	* Returns the common lib with the primary key.
	*
	* @param commonLibPK the primary key of the common lib
	* @return the common lib
	* @throws PortalException if a common lib with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.CommonLib getCommonLib(
		org.kisti.edison.science.service.persistence.CommonLibPK commonLibPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commonLibLocalService.getCommonLib(commonLibPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _commonLibLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the common libs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of common libs
	* @param end the upper bound of the range of common libs (not inclusive)
	* @return the range of common libs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.science.model.CommonLib> getCommonLibs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibLocalService.getCommonLibs(start, end);
	}

	/**
	* Returns the number of common libs.
	*
	* @return the number of common libs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCommonLibsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibLocalService.getCommonLibsCount();
	}

	/**
	* Updates the common lib in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param commonLib the common lib
	* @return the common lib that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.CommonLib updateCommonLib(
		org.kisti.edison.science.model.CommonLib commonLib)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibLocalService.updateCommonLib(commonLib);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _commonLibLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_commonLibLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _commonLibLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public int countCommonLib(long companyId, java.lang.String searchValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibLocalService.countCommonLib(companyId, searchValue);
	}

	@Override
	public java.util.List<org.kisti.edison.science.model.CommonLib> retrieveListCommonLib(
		java.lang.String searchValue, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _commonLibLocalService.retrieveListCommonLib(searchValue, begin,
			end);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CommonLibLocalService getWrappedCommonLibLocalService() {
		return _commonLibLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCommonLibLocalService(
		CommonLibLocalService commonLibLocalService) {
		_commonLibLocalService = commonLibLocalService;
	}

	@Override
	public CommonLibLocalService getWrappedService() {
		return _commonLibLocalService;
	}

	@Override
	public void setWrappedService(CommonLibLocalService commonLibLocalService) {
		_commonLibLocalService = commonLibLocalService;
	}

	private CommonLibLocalService _commonLibLocalService;
}