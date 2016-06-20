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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for DeveloperInfo. This utility wraps
 * {@link org.kisti.edison.science.service.impl.DeveloperInfoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see DeveloperInfoLocalService
 * @see org.kisti.edison.science.service.base.DeveloperInfoLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.impl.DeveloperInfoLocalServiceImpl
 * @generated
 */
public class DeveloperInfoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.science.service.impl.DeveloperInfoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the developer info to the database. Also notifies the appropriate model listeners.
	*
	* @param developerInfo the developer info
	* @return the developer info that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperInfo addDeveloperInfo(
		org.kisti.edison.science.model.DeveloperInfo developerInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDeveloperInfo(developerInfo);
	}

	/**
	* Creates a new developer info with the primary key. Does not add the developer info to the database.
	*
	* @param developerInfoPK the primary key for the new developer info
	* @return the new developer info
	*/
	public static org.kisti.edison.science.model.DeveloperInfo createDeveloperInfo(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK developerInfoPK) {
		return getService().createDeveloperInfo(developerInfoPK);
	}

	/**
	* Deletes the developer info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param developerInfoPK the primary key of the developer info
	* @return the developer info that was removed
	* @throws PortalException if a developer info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperInfo deleteDeveloperInfo(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK developerInfoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDeveloperInfo(developerInfoPK);
	}

	/**
	* Deletes the developer info from the database. Also notifies the appropriate model listeners.
	*
	* @param developerInfo the developer info
	* @return the developer info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperInfo deleteDeveloperInfo(
		org.kisti.edison.science.model.DeveloperInfo developerInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDeveloperInfo(developerInfo);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.kisti.edison.science.model.DeveloperInfo fetchDeveloperInfo(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK developerInfoPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDeveloperInfo(developerInfoPK);
	}

	/**
	* Returns the developer info with the primary key.
	*
	* @param developerInfoPK the primary key of the developer info
	* @return the developer info
	* @throws PortalException if a developer info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperInfo getDeveloperInfo(
		org.kisti.edison.science.service.persistence.DeveloperInfoPK developerInfoPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDeveloperInfo(developerInfoPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.kisti.edison.science.model.DeveloperInfo> getDeveloperInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDeveloperInfos(start, end);
	}

	/**
	* Returns the number of developer infos.
	*
	* @return the number of developer infos
	* @throws SystemException if a system exception occurred
	*/
	public static int getDeveloperInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDeveloperInfosCount();
	}

	/**
	* Updates the developer info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param developerInfo the developer info
	* @return the developer info that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.DeveloperInfo updateDeveloperInfo(
		org.kisti.edison.science.model.DeveloperInfo developerInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDeveloperInfo(developerInfo);
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

	public static int getScienceAppDeveloperInfoCount(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppDeveloperInfoCount(userId, groupId);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return getService().getListCustomDeveloperInfo(params, locale);
	}

	public static int getCountCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params) {
		return getService().getCountCustomDeveloperInfo(params);
	}

	public static java.util.Map<java.lang.String, java.lang.Object> getCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params,
		java.util.Locale locale) {
		return getService().getCustomDeveloperInfo(params, locale);
	}

	public static org.kisti.edison.science.model.DeveloperInfo insertCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException,
			org.kisti.edison.science.NoSuchDeveloperInfoException {
		return getService().insertCustomDeveloperInfo(params);
	}

	public static org.kisti.edison.science.model.DeveloperInfo updateCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException {
		return getService().updateCustomDeveloperInfo(params);
	}

	public static org.kisti.edison.science.model.DeveloperInfo deleteCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.String> params)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.lang.NumberFormatException,
			org.kisti.edison.science.NoSuchDeveloperInfoException {
		return getService().deleteCustomDeveloperInfo(params);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getDeveloperRequestStatus(
		long groupId, long userId, java.lang.String[] requestStatus,
		java.util.Locale locale, int begin, int end) {
		return getService()
				   .getDeveloperRequestStatus(groupId, userId, requestStatus,
			locale, begin, end);
	}

	public static int getCountDeveloperRequestStatus(long groupId, long userId,
		java.lang.String[] requestStatus) {
		return getService()
				   .getCountDeveloperRequestStatus(groupId, userId,
			requestStatus);
	}

	public static java.util.Map getCountRequestInfo(long groupId,
		java.lang.String developerStatus, java.lang.String virtualLabStatus,
		java.lang.String libRequestStatus,
		java.lang.String developerDeleteStatus) {
		return getService()
				   .getCountRequestInfo(groupId, developerStatus,
			virtualLabStatus, libRequestStatus, developerDeleteStatus);
	}

	public static void deleteWorkSpace(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.sql.SQLException {
		getService().deleteWorkSpace(userId, groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DeveloperInfoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DeveloperInfoLocalService.class.getName());

			if (invokableLocalService instanceof DeveloperInfoLocalService) {
				_service = (DeveloperInfoLocalService)invokableLocalService;
			}
			else {
				_service = new DeveloperInfoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DeveloperInfoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DeveloperInfoLocalService service) {
	}

	private static DeveloperInfoLocalService _service;
}