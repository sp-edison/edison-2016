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
 * Provides a wrapper for {@link DeveloperInfoLocalService}.
 *
 * @author EDISON
 * @see DeveloperInfoLocalService
 * @generated
 */
public class DeveloperInfoLocalServiceWrapper
	implements DeveloperInfoLocalService,
		ServiceWrapper<DeveloperInfoLocalService> {
	public DeveloperInfoLocalServiceWrapper(
		DeveloperInfoLocalService developerInfoLocalService) {
		_developerInfoLocalService = developerInfoLocalService;
	}

	/**
	* Adds the developer info to the database. Also notifies the appropriate model listeners.
	*
	* @param developerInfo the developer info
	* @return the developer info that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperInfo addDeveloperInfo(
		org.kisti.edison.science.model.DeveloperInfo developerInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerInfoLocalService.addDeveloperInfo(developerInfo);
	}

	/**
	* Creates a new developer info with the primary key. Does not add the developer info to the database.
	*
	* @param developerInfoPK the primary key for the new developer info
	* @return the new developer info
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperInfo createDeveloperInfo(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK developerInfoPK) {
		return _developerInfoLocalService.createDeveloperInfo(developerInfoPK);
	}

	/**
	* Deletes the developer info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param developerInfoPK the primary key of the developer info
	* @return the developer info that was removed
	* @throws PortalException if a developer info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperInfo deleteDeveloperInfo(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK developerInfoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _developerInfoLocalService.deleteDeveloperInfo(developerInfoPK);
	}

	/**
	* Deletes the developer info from the database. Also notifies the appropriate model listeners.
	*
	* @param developerInfo the developer info
	* @return the developer info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperInfo deleteDeveloperInfo(
		org.kisti.edison.science.model.DeveloperInfo developerInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerInfoLocalService.deleteDeveloperInfo(developerInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _developerInfoLocalService.dynamicQuery();
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
		return _developerInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _developerInfoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _developerInfoLocalService.dynamicQuery(dynamicQuery, start,
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
		return _developerInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _developerInfoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.science.model.DeveloperInfo fetchDeveloperInfo(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK developerInfoPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerInfoLocalService.fetchDeveloperInfo(developerInfoPK);
	}

	/**
	* Returns the developer info with the primary key.
	*
	* @param developerInfoPK the primary key of the developer info
	* @return the developer info
	* @throws PortalException if a developer info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperInfo getDeveloperInfo(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK developerInfoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _developerInfoLocalService.getDeveloperInfo(developerInfoPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _developerInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the developer infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of developer infos
	* @param end the upper bound of the range of developer infos (not inclusive)
	* @return the range of developer infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.science.model.DeveloperInfo> getDeveloperInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerInfoLocalService.getDeveloperInfos(start, end);
	}

	/**
	* Returns the number of developer infos.
	*
	* @return the number of developer infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getDeveloperInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerInfoLocalService.getDeveloperInfosCount();
	}

	/**
	* Updates the developer info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param developerInfo the developer info
	* @return the developer info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.science.model.DeveloperInfo updateDeveloperInfo(
		org.kisti.edison.science.model.DeveloperInfo developerInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerInfoLocalService.updateDeveloperInfo(developerInfo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _developerInfoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_developerInfoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _developerInfoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public int getScienceAppDeveloperInfoCount(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _developerInfoLocalService.getScienceAppDeveloperInfoCount(userId,
			groupId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return _developerInfoLocalService.getListCustomDeveloperInfo(params,
			locale);
	}

	@Override
	public int getCountCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params) {
		return _developerInfoLocalService.getCountCustomDeveloperInfo(params);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Object> getCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return _developerInfoLocalService.getCustomDeveloperInfo(params, locale);
	}

	@Override
	public org.kisti.edison.science.model.DeveloperInfo insertCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException,
			org.kisti.edison.science.NoSuchDeveloperInfoException {
		return _developerInfoLocalService.insertCustomDeveloperInfo(params);
	}

	@Override
	public org.kisti.edison.science.model.DeveloperInfo updateCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		return _developerInfoLocalService.updateCustomDeveloperInfo(params);
	}

	@Override
	public org.kisti.edison.science.model.DeveloperInfo deleteCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.String> params)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException,
			org.kisti.edison.science.NoSuchDeveloperInfoException {
		return _developerInfoLocalService.deleteCustomDeveloperInfo(params);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getDeveloperRequestStatus(
		long groupId, long userId, java.lang.String[] requestStatus,
		java.util.Locale locale, int begin, int end) {
		return _developerInfoLocalService.getDeveloperRequestStatus(groupId,
			userId, requestStatus, locale, begin, end);
	}

	@Override
	public int getCountDeveloperRequestStatus(long groupId, long userId,
		java.lang.String[] requestStatus) {
		return _developerInfoLocalService.getCountDeveloperRequestStatus(groupId,
			userId, requestStatus);
	}

	@Override
	public java.util.Map getCountRequestInfo(long groupId,
		java.lang.String developerStatus, java.lang.String virtualLabStatus,
		java.lang.String libRequestStatus,
		java.lang.String developerDeleteStatus) {
		return _developerInfoLocalService.getCountRequestInfo(groupId,
			developerStatus, virtualLabStatus, libRequestStatus,
			developerDeleteStatus);
	}

	@Override
	public void deleteWorkSpace(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.sql.SQLException {
		_developerInfoLocalService.deleteWorkSpace(userId, groupId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public DeveloperInfoLocalService getWrappedDeveloperInfoLocalService() {
		return _developerInfoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedDeveloperInfoLocalService(
		DeveloperInfoLocalService developerInfoLocalService) {
		_developerInfoLocalService = developerInfoLocalService;
	}

	@Override
	public DeveloperInfoLocalService getWrappedService() {
		return _developerInfoLocalService;
	}

	@Override
	public void setWrappedService(
		DeveloperInfoLocalService developerInfoLocalService) {
		_developerInfoLocalService = developerInfoLocalService;
	}

	private DeveloperInfoLocalService _developerInfoLocalService;
}