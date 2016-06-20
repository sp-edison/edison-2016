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

package org.kisti.edison.virtuallaboratory.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VirtualLabClassScienceAppLocalService}.
 *
 * @author EDISON
 * @see VirtualLabClassScienceAppLocalService
 * @generated
 */
public class VirtualLabClassScienceAppLocalServiceWrapper
	implements VirtualLabClassScienceAppLocalService,
		ServiceWrapper<VirtualLabClassScienceAppLocalService> {
	public VirtualLabClassScienceAppLocalServiceWrapper(
		VirtualLabClassScienceAppLocalService virtualLabClassScienceAppLocalService) {
		_virtualLabClassScienceAppLocalService = virtualLabClassScienceAppLocalService;
	}

	/**
	* Adds the virtual lab class science app to the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabClassScienceApp the virtual lab class science app
	* @return the virtual lab class science app that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp addVirtualLabClassScienceApp(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.addVirtualLabClassScienceApp(virtualLabClassScienceApp);
	}

	/**
	* Creates a new virtual lab class science app with the primary key. Does not add the virtual lab class science app to the database.
	*
	* @param scienceAppSeqNo the primary key for the new virtual lab class science app
	* @return the new virtual lab class science app
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp createVirtualLabClassScienceApp(
		long scienceAppSeqNo) {
		return _virtualLabClassScienceAppLocalService.createVirtualLabClassScienceApp(scienceAppSeqNo);
	}

	/**
	* Deletes the virtual lab class science app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppSeqNo the primary key of the virtual lab class science app
	* @return the virtual lab class science app that was removed
	* @throws PortalException if a virtual lab class science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp deleteVirtualLabClassScienceApp(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.deleteVirtualLabClassScienceApp(scienceAppSeqNo);
	}

	/**
	* Deletes the virtual lab class science app from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabClassScienceApp the virtual lab class science app
	* @return the virtual lab class science app that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp deleteVirtualLabClassScienceApp(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.deleteVirtualLabClassScienceApp(virtualLabClassScienceApp);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _virtualLabClassScienceAppLocalService.dynamicQuery();
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
		return _virtualLabClassScienceAppLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _virtualLabClassScienceAppLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _virtualLabClassScienceAppLocalService.dynamicQuery(dynamicQuery,
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
		return _virtualLabClassScienceAppLocalService.dynamicQueryCount(dynamicQuery);
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
		return _virtualLabClassScienceAppLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp fetchVirtualLabClassScienceApp(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.fetchVirtualLabClassScienceApp(scienceAppSeqNo);
	}

	/**
	* Returns the virtual lab class science app with the primary key.
	*
	* @param scienceAppSeqNo the primary key of the virtual lab class science app
	* @return the virtual lab class science app
	* @throws PortalException if a virtual lab class science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp getVirtualLabClassScienceApp(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.getVirtualLabClassScienceApp(scienceAppSeqNo);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the virtual lab class science apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of virtual lab class science apps
	* @param end the upper bound of the range of virtual lab class science apps (not inclusive)
	* @return the range of virtual lab class science apps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassScienceApps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.getVirtualLabClassScienceApps(start,
			end);
	}

	/**
	* Returns the number of virtual lab class science apps.
	*
	* @return the number of virtual lab class science apps
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVirtualLabClassScienceAppsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.getVirtualLabClassScienceAppsCount();
	}

	/**
	* Updates the virtual lab class science app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param virtualLabClassScienceApp the virtual lab class science app
	* @return the virtual lab class science app that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp updateVirtualLabClassScienceApp(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.updateVirtualLabClassScienceApp(virtualLabClassScienceApp);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassVirtualLabClassScienceApp(long classId,
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassScienceAppLocalService.addVirtualLabClassVirtualLabClassScienceApp(classId,
			scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassVirtualLabClassScienceApp(long classId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassScienceAppLocalService.addVirtualLabClassVirtualLabClassScienceApp(classId,
			virtualLabClassScienceApp);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassVirtualLabClassScienceApps(long classId,
		long[] scienceAppSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassScienceAppLocalService.addVirtualLabClassVirtualLabClassScienceApps(classId,
			scienceAppSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabClassVirtualLabClassScienceApps(long classId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> VirtualLabClassScienceApps)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassScienceAppLocalService.addVirtualLabClassVirtualLabClassScienceApps(classId,
			VirtualLabClassScienceApps);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearVirtualLabClassVirtualLabClassScienceApps(long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassScienceAppLocalService.clearVirtualLabClassVirtualLabClassScienceApps(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassVirtualLabClassScienceApp(long classId,
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassScienceAppLocalService.deleteVirtualLabClassVirtualLabClassScienceApp(classId,
			scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassVirtualLabClassScienceApp(long classId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassScienceAppLocalService.deleteVirtualLabClassVirtualLabClassScienceApp(classId,
			virtualLabClassScienceApp);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassVirtualLabClassScienceApps(long classId,
		long[] scienceAppSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassScienceAppLocalService.deleteVirtualLabClassVirtualLabClassScienceApps(classId,
			scienceAppSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabClassVirtualLabClassScienceApps(long classId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> VirtualLabClassScienceApps)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassScienceAppLocalService.deleteVirtualLabClassVirtualLabClassScienceApps(classId,
			VirtualLabClassScienceApps);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassVirtualLabClassScienceApps(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.getVirtualLabClassVirtualLabClassScienceApps(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassVirtualLabClassScienceApps(
		long classId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.getVirtualLabClassVirtualLabClassScienceApps(classId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassVirtualLabClassScienceApps(
		long classId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.getVirtualLabClassVirtualLabClassScienceApps(classId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVirtualLabClassVirtualLabClassScienceAppsCount(long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.getVirtualLabClassVirtualLabClassScienceAppsCount(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabClassVirtualLabClassScienceApp(long classId,
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.hasVirtualLabClassVirtualLabClassScienceApp(classId,
			scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabClassVirtualLabClassScienceApps(long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.hasVirtualLabClassVirtualLabClassScienceApps(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setVirtualLabClassVirtualLabClassScienceApps(long classId,
		long[] scienceAppSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassScienceAppLocalService.setVirtualLabClassVirtualLabClassScienceApps(classId,
			scienceAppSeqNos);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _virtualLabClassScienceAppLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_virtualLabClassScienceAppLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _virtualLabClassScienceAppLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualLabClassScienceAppList(
		long companyId, long groupId, long classId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.getVirtualLabClassScienceAppList(companyId,
			groupId, classId, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getScienceAppList(
		long companyId, long groupId, long classId,
		java.lang.String searchField, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _virtualLabClassScienceAppLocalService.getScienceAppList(companyId,
			groupId, classId, searchField, locale);
	}

	@Override
	public void insertVirtualLabClassScienceApp(long classId, long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassScienceAppLocalService.insertVirtualLabClassScienceApp(classId,
			scienceAppId);
	}

	@Override
	public void insertVirtualLabClassScienceAppList(long companyId,
		long classId, long groupId, java.lang.Object scienceAppCheck,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_virtualLabClassScienceAppLocalService.insertVirtualLabClassScienceAppList(companyId,
			classId, groupId, scienceAppCheck, locale);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VirtualLabClassScienceAppLocalService getWrappedVirtualLabClassScienceAppLocalService() {
		return _virtualLabClassScienceAppLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVirtualLabClassScienceAppLocalService(
		VirtualLabClassScienceAppLocalService virtualLabClassScienceAppLocalService) {
		_virtualLabClassScienceAppLocalService = virtualLabClassScienceAppLocalService;
	}

	@Override
	public VirtualLabClassScienceAppLocalService getWrappedService() {
		return _virtualLabClassScienceAppLocalService;
	}

	@Override
	public void setWrappedService(
		VirtualLabClassScienceAppLocalService virtualLabClassScienceAppLocalService) {
		_virtualLabClassScienceAppLocalService = virtualLabClassScienceAppLocalService;
	}

	private VirtualLabClassScienceAppLocalService _virtualLabClassScienceAppLocalService;
}