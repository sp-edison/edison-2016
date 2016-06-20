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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for VirtualLabClassScienceApp. This utility wraps
 * {@link org.kisti.edison.virtuallaboratory.service.impl.VirtualLabClassScienceAppLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see VirtualLabClassScienceAppLocalService
 * @see org.kisti.edison.virtuallaboratory.service.base.VirtualLabClassScienceAppLocalServiceBaseImpl
 * @see org.kisti.edison.virtuallaboratory.service.impl.VirtualLabClassScienceAppLocalServiceImpl
 * @generated
 */
public class VirtualLabClassScienceAppLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.virtuallaboratory.service.impl.VirtualLabClassScienceAppLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the virtual lab class science app to the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabClassScienceApp the virtual lab class science app
	* @return the virtual lab class science app that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp addVirtualLabClassScienceApp(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addVirtualLabClassScienceApp(virtualLabClassScienceApp);
	}

	/**
	* Creates a new virtual lab class science app with the primary key. Does not add the virtual lab class science app to the database.
	*
	* @param scienceAppSeqNo the primary key for the new virtual lab class science app
	* @return the new virtual lab class science app
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp createVirtualLabClassScienceApp(
		long scienceAppSeqNo) {
		return getService().createVirtualLabClassScienceApp(scienceAppSeqNo);
	}

	/**
	* Deletes the virtual lab class science app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppSeqNo the primary key of the virtual lab class science app
	* @return the virtual lab class science app that was removed
	* @throws PortalException if a virtual lab class science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp deleteVirtualLabClassScienceApp(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteVirtualLabClassScienceApp(scienceAppSeqNo);
	}

	/**
	* Deletes the virtual lab class science app from the database. Also notifies the appropriate model listeners.
	*
	* @param virtualLabClassScienceApp the virtual lab class science app
	* @return the virtual lab class science app that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp deleteVirtualLabClassScienceApp(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteVirtualLabClassScienceApp(virtualLabClassScienceApp);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp fetchVirtualLabClassScienceApp(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchVirtualLabClassScienceApp(scienceAppSeqNo);
	}

	/**
	* Returns the virtual lab class science app with the primary key.
	*
	* @param scienceAppSeqNo the primary key of the virtual lab class science app
	* @return the virtual lab class science app
	* @throws PortalException if a virtual lab class science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp getVirtualLabClassScienceApp(
		long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabClassScienceApp(scienceAppSeqNo);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassScienceApps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabClassScienceApps(start, end);
	}

	/**
	* Returns the number of virtual lab class science apps.
	*
	* @return the number of virtual lab class science apps
	* @throws SystemException if a system exception occurred
	*/
	public static int getVirtualLabClassScienceAppsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabClassScienceAppsCount();
	}

	/**
	* Updates the virtual lab class science app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param virtualLabClassScienceApp the virtual lab class science app
	* @return the virtual lab class science app that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp updateVirtualLabClassScienceApp(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateVirtualLabClassScienceApp(virtualLabClassScienceApp);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClassVirtualLabClassScienceApp(
		long classId, long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVirtualLabClassVirtualLabClassScienceApp(classId,
			scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClassVirtualLabClassScienceApp(
		long classId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVirtualLabClassVirtualLabClassScienceApp(classId,
			virtualLabClassScienceApp);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClassVirtualLabClassScienceApps(
		long classId, long[] scienceAppSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVirtualLabClassVirtualLabClassScienceApps(classId,
			scienceAppSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabClassVirtualLabClassScienceApps(
		long classId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> VirtualLabClassScienceApps)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addVirtualLabClassVirtualLabClassScienceApps(classId,
			VirtualLabClassScienceApps);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearVirtualLabClassVirtualLabClassScienceApps(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearVirtualLabClassVirtualLabClassScienceApps(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabClassVirtualLabClassScienceApp(
		long classId, long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabClassVirtualLabClassScienceApp(classId,
			scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabClassVirtualLabClassScienceApp(
		long classId,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabClassVirtualLabClassScienceApp(classId,
			virtualLabClassScienceApp);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabClassVirtualLabClassScienceApps(
		long classId, long[] scienceAppSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabClassVirtualLabClassScienceApps(classId,
			scienceAppSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabClassVirtualLabClassScienceApps(
		long classId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> VirtualLabClassScienceApps)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteVirtualLabClassVirtualLabClassScienceApps(classId,
			VirtualLabClassScienceApps);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassVirtualLabClassScienceApps(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabClassVirtualLabClassScienceApps(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassVirtualLabClassScienceApps(
		long classId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabClassVirtualLabClassScienceApps(classId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassVirtualLabClassScienceApps(
		long classId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabClassVirtualLabClassScienceApps(classId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getVirtualLabClassVirtualLabClassScienceAppsCount(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabClassVirtualLabClassScienceAppsCount(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasVirtualLabClassVirtualLabClassScienceApp(
		long classId, long scienceAppSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasVirtualLabClassVirtualLabClassScienceApp(classId,
			scienceAppSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasVirtualLabClassVirtualLabClassScienceApps(
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasVirtualLabClassVirtualLabClassScienceApps(classId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setVirtualLabClassVirtualLabClassScienceApps(
		long classId, long[] scienceAppSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.setVirtualLabClassVirtualLabClassScienceApps(classId,
			scienceAppSeqNos);
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

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getVirtualLabClassScienceAppList(
		long companyId, long groupId, long classId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabClassScienceAppList(companyId, groupId,
			classId, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getScienceAppList(
		long companyId, long groupId, long classId,
		java.lang.String searchField, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getScienceAppList(companyId, groupId, classId, searchField,
			locale);
	}

	public static void insertVirtualLabClassScienceApp(long classId,
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().insertVirtualLabClassScienceApp(classId, scienceAppId);
	}

	public static void insertVirtualLabClassScienceAppList(long companyId,
		long classId, long groupId, java.lang.Object scienceAppCheck,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.insertVirtualLabClassScienceAppList(companyId, classId, groupId,
			scienceAppCheck, locale);
	}

	public static void clearService() {
		_service = null;
	}

	public static VirtualLabClassScienceAppLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					VirtualLabClassScienceAppLocalService.class.getName());

			if (invokableLocalService instanceof VirtualLabClassScienceAppLocalService) {
				_service = (VirtualLabClassScienceAppLocalService)invokableLocalService;
			}
			else {
				_service = new VirtualLabClassScienceAppLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(VirtualLabClassScienceAppLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(VirtualLabClassScienceAppLocalService service) {
	}

	private static VirtualLabClassScienceAppLocalService _service;
}