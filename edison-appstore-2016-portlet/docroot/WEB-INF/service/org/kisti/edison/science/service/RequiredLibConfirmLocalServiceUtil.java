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
 * Provides the local service utility for RequiredLibConfirm. This utility wraps
 * {@link org.kisti.edison.science.service.impl.RequiredLibConfirmLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see RequiredLibConfirmLocalService
 * @see org.kisti.edison.science.service.base.RequiredLibConfirmLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.impl.RequiredLibConfirmLocalServiceImpl
 * @generated
 */
public class RequiredLibConfirmLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.science.service.impl.RequiredLibConfirmLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the required lib confirm to the database. Also notifies the appropriate model listeners.
	*
	* @param requiredLibConfirm the required lib confirm
	* @return the required lib confirm that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.RequiredLibConfirm addRequiredLibConfirm(
		org.kisti.edison.science.model.RequiredLibConfirm requiredLibConfirm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addRequiredLibConfirm(requiredLibConfirm);
	}

	/**
	* Creates a new required lib confirm with the primary key. Does not add the required lib confirm to the database.
	*
	* @param requiredLibConfirmPK the primary key for the new required lib confirm
	* @return the new required lib confirm
	*/
	public static org.kisti.edison.science.model.RequiredLibConfirm createRequiredLibConfirm(
		org.kisti.edison.science.service.persistence.RequiredLibConfirmPK requiredLibConfirmPK) {
		return getService().createRequiredLibConfirm(requiredLibConfirmPK);
	}

	/**
	* Deletes the required lib confirm with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param requiredLibConfirmPK the primary key of the required lib confirm
	* @return the required lib confirm that was removed
	* @throws PortalException if a required lib confirm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.RequiredLibConfirm deleteRequiredLibConfirm(
		org.kisti.edison.science.service.persistence.RequiredLibConfirmPK requiredLibConfirmPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRequiredLibConfirm(requiredLibConfirmPK);
	}

	/**
	* Deletes the required lib confirm from the database. Also notifies the appropriate model listeners.
	*
	* @param requiredLibConfirm the required lib confirm
	* @return the required lib confirm that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.RequiredLibConfirm deleteRequiredLibConfirm(
		org.kisti.edison.science.model.RequiredLibConfirm requiredLibConfirm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteRequiredLibConfirm(requiredLibConfirm);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibConfirmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibConfirmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.kisti.edison.science.model.RequiredLibConfirm fetchRequiredLibConfirm(
		org.kisti.edison.science.service.persistence.RequiredLibConfirmPK requiredLibConfirmPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchRequiredLibConfirm(requiredLibConfirmPK);
	}

	/**
	* Returns the required lib confirm with the primary key.
	*
	* @param requiredLibConfirmPK the primary key of the required lib confirm
	* @return the required lib confirm
	* @throws PortalException if a required lib confirm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.RequiredLibConfirm getRequiredLibConfirm(
		org.kisti.edison.science.service.persistence.RequiredLibConfirmPK requiredLibConfirmPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRequiredLibConfirm(requiredLibConfirmPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the required lib confirms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibConfirmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of required lib confirms
	* @param end the upper bound of the range of required lib confirms (not inclusive)
	* @return the range of required lib confirms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.RequiredLibConfirm> getRequiredLibConfirms(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRequiredLibConfirms(start, end);
	}

	/**
	* Returns the number of required lib confirms.
	*
	* @return the number of required lib confirms
	* @throws SystemException if a system exception occurred
	*/
	public static int getRequiredLibConfirmsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getRequiredLibConfirmsCount();
	}

	/**
	* Updates the required lib confirm in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param requiredLibConfirm the required lib confirm
	* @return the required lib confirm that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.RequiredLibConfirm updateRequiredLibConfirm(
		org.kisti.edison.science.model.RequiredLibConfirm requiredLibConfirm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRequiredLibConfirm(requiredLibConfirm);
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

	public static int countByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countByScienceAppId(scienceAppId);
	}

	public static java.util.List<org.kisti.edison.science.model.RequiredLibConfirm> findByScienceAppId(
		long scienceAppId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByScienceAppId(scienceAppId, start, end,
			orderByComparator);
	}

	public static int getCountRequiredConfirm(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountRequiredConfirm(searchParam);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getRequiredLibConfirmList(
		java.util.Map<java.lang.String, java.lang.Object> searchParam,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRequiredLibConfirmList(searchParam, begin, end);
	}

	public static java.util.Map<java.lang.String, java.lang.Object> getRequiredLibConfirmMap(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRequiredLibConfirmMap(searchParam);
	}

	public static org.kisti.edison.science.model.RequiredLibConfirm getRequiredLibConfirmObject(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRequiredLibConfirmObject(searchParam);
	}

	public static void clearService() {
		_service = null;
	}

	public static RequiredLibConfirmLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					RequiredLibConfirmLocalService.class.getName());

			if (invokableLocalService instanceof RequiredLibConfirmLocalService) {
				_service = (RequiredLibConfirmLocalService)invokableLocalService;
			}
			else {
				_service = new RequiredLibConfirmLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(RequiredLibConfirmLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(RequiredLibConfirmLocalService service) {
	}

	private static RequiredLibConfirmLocalService _service;
}