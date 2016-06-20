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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ScienceAppManager. This utility wraps
 * {@link com.kisti.science.platform.app.service.impl.ScienceAppManagerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppManagerLocalService
 * @see com.kisti.science.platform.app.service.base.ScienceAppManagerLocalServiceBaseImpl
 * @see com.kisti.science.platform.app.service.impl.ScienceAppManagerLocalServiceImpl
 * @generated
 */
public class ScienceAppManagerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.kisti.science.platform.app.service.impl.ScienceAppManagerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the science app manager to the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppManager the science app manager
	* @return the science app manager that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager addScienceAppManager(
		com.kisti.science.platform.app.model.ScienceAppManager scienceAppManager)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addScienceAppManager(scienceAppManager);
	}

	/**
	* Creates a new science app manager with the primary key. Does not add the science app manager to the database.
	*
	* @param scienceAppManagerId the primary key for the new science app manager
	* @return the new science app manager
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager createScienceAppManager(
		long scienceAppManagerId) {
		return getService().createScienceAppManager(scienceAppManagerId);
	}

	/**
	* Deletes the science app manager with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppManagerId the primary key of the science app manager
	* @return the science app manager that was removed
	* @throws PortalException if a science app manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager deleteScienceAppManager(
		long scienceAppManagerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteScienceAppManager(scienceAppManagerId);
	}

	/**
	* Deletes the science app manager from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppManager the science app manager
	* @return the science app manager that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager deleteScienceAppManager(
		com.kisti.science.platform.app.model.ScienceAppManager scienceAppManager)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteScienceAppManager(scienceAppManager);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.kisti.science.platform.app.model.ScienceAppManager fetchScienceAppManager(
		long scienceAppManagerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchScienceAppManager(scienceAppManagerId);
	}

	/**
	* Returns the science app manager with the primary key.
	*
	* @param scienceAppManagerId the primary key of the science app manager
	* @return the science app manager
	* @throws PortalException if a science app manager with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager getScienceAppManager(
		long scienceAppManagerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppManager(scienceAppManagerId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the science app managers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app managers
	* @param end the upper bound of the range of science app managers (not inclusive)
	* @return the range of science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppManager> getScienceAppManagers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppManagers(start, end);
	}

	/**
	* Returns the number of science app managers.
	*
	* @return the number of science app managers
	* @throws SystemException if a system exception occurred
	*/
	public static int getScienceAppManagersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppManagersCount();
	}

	/**
	* Updates the science app manager in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scienceAppManager the science app manager
	* @return the science app manager that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppManager updateScienceAppManager(
		com.kisti.science.platform.app.model.ScienceAppManager scienceAppManager)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateScienceAppManager(scienceAppManager);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.kisti.science.platform.app.model.ScienceAppManager addScienceAppManager(
		long managerId, long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addScienceAppManager(managerId, scienceAppId);
	}

	public static void removeScienceAppManagerByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeScienceAppManagerByManagerId(managerId);
	}

	public static void removeScienceAppManagerByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeScienceAppManagerByScienceAppId(scienceAppId);
	}

	public static long[] getScienceAppIdsByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppIdsByManagerId(managerId);
	}

	public static long[] getScienceAppIdsByManagerId(long managerId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppIdsByManagerId(managerId, start, end);
	}

	public static int countScienceAppIdsByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countScienceAppIdsByManagerId(managerId);
	}

	public static long[] getManagerIdsByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getManagerIdsByScienceAppId(scienceAppId);
	}

	public static long[] getManagerIdsByScienceAppId(long scienceAppId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getManagerIdsByScienceAppId(scienceAppId, start, end);
	}

	public static int countManagersByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countManagersByScienceAppId(scienceAppId);
	}

	public static boolean existScienceAppManager(long managerId,
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().existScienceAppManager(managerId, scienceAppId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ScienceAppManagerLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ScienceAppManagerLocalService.class.getName());

			if (invokableLocalService instanceof ScienceAppManagerLocalService) {
				_service = (ScienceAppManagerLocalService)invokableLocalService;
			}
			else {
				_service = new ScienceAppManagerLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ScienceAppManagerLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ScienceAppManagerLocalService service) {
	}

	private static ScienceAppManagerLocalService _service;
}