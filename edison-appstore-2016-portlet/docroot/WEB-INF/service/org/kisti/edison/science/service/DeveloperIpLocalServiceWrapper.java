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
 * Provides a wrapper for {@link DeveloperIpLocalService}.
 *
 * @author EDISON
 * @see DeveloperIpLocalService
 * @generated
 */
public class DeveloperIpLocalServiceWrapper implements DeveloperIpLocalService,
	ServiceWrapper<DeveloperIpLocalService> {
	public DeveloperIpLocalServiceWrapper(
		DeveloperIpLocalService developerIpLocalService) {
		_developerIpLocalService = developerIpLocalService;
	}

	/**
	* Adds the developer ip to the database. Also notifies the appropriate model listeners.
	*
	* @param developerIp the developer ip
	* @return the developer ip that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperIp addDeveloperIp(
		org.kisti.edison.science.model.DeveloperIp developerIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerIpLocalService.addDeveloperIp(developerIp);
	}

	/**
	* Creates a new developer ip with the primary key. Does not add the developer ip to the database.
	*
	* @param developerIpPK the primary key for the new developer ip
	* @return the new developer ip
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperIp createDeveloperIp(
		org.kisti.edison.science.service.persistence.DeveloperIpPK developerIpPK) {
		return _developerIpLocalService.createDeveloperIp(developerIpPK);
	}

	/**
	* Deletes the developer ip with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param developerIpPK the primary key of the developer ip
	* @return the developer ip that was removed
	* @throws PortalException if a developer ip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperIp deleteDeveloperIp(
		org.kisti.edison.science.service.persistence.DeveloperIpPK developerIpPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _developerIpLocalService.deleteDeveloperIp(developerIpPK);
	}

	/**
	* Deletes the developer ip from the database. Also notifies the appropriate model listeners.
	*
	* @param developerIp the developer ip
	* @return the developer ip that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperIp deleteDeveloperIp(
		org.kisti.edison.science.model.DeveloperIp developerIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerIpLocalService.deleteDeveloperIp(developerIp);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _developerIpLocalService.dynamicQuery();
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
		return _developerIpLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _developerIpLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _developerIpLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _developerIpLocalService.dynamicQueryCount(dynamicQuery);
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
		return _developerIpLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.science.model.DeveloperIp fetchDeveloperIp(
		org.kisti.edison.science.service.persistence.DeveloperIpPK developerIpPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerIpLocalService.fetchDeveloperIp(developerIpPK);
	}

	/**
	* Returns the developer ip with the primary key.
	*
	* @param developerIpPK the primary key of the developer ip
	* @return the developer ip
	* @throws PortalException if a developer ip with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperIp getDeveloperIp(
		org.kisti.edison.science.service.persistence.DeveloperIpPK developerIpPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _developerIpLocalService.getDeveloperIp(developerIpPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _developerIpLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the developer ips.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of developer ips
	* @param end the upper bound of the range of developer ips (not inclusive)
	* @return the range of developer ips
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.science.model.DeveloperIp> getDeveloperIps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerIpLocalService.getDeveloperIps(start, end);
	}

	/**
	* Returns the number of developer ips.
	*
	* @return the number of developer ips
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDeveloperIpsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerIpLocalService.getDeveloperIpsCount();
	}

	/**
	* Updates the developer ip in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param developerIp the developer ip
	* @return the developer ip that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperIp updateDeveloperIp(
		org.kisti.edison.science.model.DeveloperIp developerIp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerIpLocalService.updateDeveloperIp(developerIp);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _developerIpLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_developerIpLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _developerIpLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.String>> getListCustomDeveloperIp(
		java.util.Map<java.lang.String, java.lang.String> params)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		return _developerIpLocalService.getListCustomDeveloperIp(params);
	}

	@Override
	public org.kisti.edison.science.model.DeveloperIp insertCustomDeveloperIp(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException,
			org.kisti.edison.science.NoSuchDeveloperIpException {
		return _developerIpLocalService.insertCustomDeveloperIp(params);
	}

	@Override
	public void deleteCustomDeveloperIp(
		java.util.Map<java.lang.String, java.lang.String> params)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException,
			org.kisti.edison.science.NoSuchDeveloperIpException {
		_developerIpLocalService.deleteCustomDeveloperIp(params);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DeveloperIpLocalService getWrappedDeveloperIpLocalService() {
		return _developerIpLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDeveloperIpLocalService(
		DeveloperIpLocalService developerIpLocalService) {
		_developerIpLocalService = developerIpLocalService;
	}

	@Override
	public DeveloperIpLocalService getWrappedService() {
		return _developerIpLocalService;
	}

	@Override
	public void setWrappedService(
		DeveloperIpLocalService developerIpLocalService) {
		_developerIpLocalService = developerIpLocalService;
	}

	private DeveloperIpLocalService _developerIpLocalService;
}