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
 * Provides the local service utility for PortTypeInputdeckForm. This utility wraps
 * {@link org.kisti.edison.science.service.impl.PortTypeInputdeckFormLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see PortTypeInputdeckFormLocalService
 * @see org.kisti.edison.science.service.base.PortTypeInputdeckFormLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.impl.PortTypeInputdeckFormLocalServiceImpl
 * @generated
 */
public class PortTypeInputdeckFormLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.science.service.impl.PortTypeInputdeckFormLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the port type inputdeck form to the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeInputdeckForm the port type inputdeck form
	* @return the port type inputdeck form that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.PortTypeInputdeckForm addPortTypeInputdeckForm(
		org.kisti.edison.science.model.PortTypeInputdeckForm portTypeInputdeckForm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPortTypeInputdeckForm(portTypeInputdeckForm);
	}

	/**
	* Creates a new port type inputdeck form with the primary key. Does not add the port type inputdeck form to the database.
	*
	* @param portTypeId the primary key for the new port type inputdeck form
	* @return the new port type inputdeck form
	*/
	public static org.kisti.edison.science.model.PortTypeInputdeckForm createPortTypeInputdeckForm(
		long portTypeId) {
		return getService().createPortTypeInputdeckForm(portTypeId);
	}

	/**
	* Deletes the port type inputdeck form with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeId the primary key of the port type inputdeck form
	* @return the port type inputdeck form that was removed
	* @throws PortalException if a port type inputdeck form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.PortTypeInputdeckForm deletePortTypeInputdeckForm(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePortTypeInputdeckForm(portTypeId);
	}

	/**
	* Deletes the port type inputdeck form from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeInputdeckForm the port type inputdeck form
	* @return the port type inputdeck form that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.PortTypeInputdeckForm deletePortTypeInputdeckForm(
		org.kisti.edison.science.model.PortTypeInputdeckForm portTypeInputdeckForm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePortTypeInputdeckForm(portTypeInputdeckForm);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeInputdeckFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeInputdeckFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.kisti.edison.science.model.PortTypeInputdeckForm fetchPortTypeInputdeckForm(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPortTypeInputdeckForm(portTypeId);
	}

	/**
	* Returns the port type inputdeck form with the primary key.
	*
	* @param portTypeId the primary key of the port type inputdeck form
	* @return the port type inputdeck form
	* @throws PortalException if a port type inputdeck form with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.PortTypeInputdeckForm getPortTypeInputdeckForm(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortTypeInputdeckForm(portTypeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the port type inputdeck forms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.PortTypeInputdeckFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type inputdeck forms
	* @param end the upper bound of the range of port type inputdeck forms (not inclusive)
	* @return the range of port type inputdeck forms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.PortTypeInputdeckForm> getPortTypeInputdeckForms(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortTypeInputdeckForms(start, end);
	}

	/**
	* Returns the number of port type inputdeck forms.
	*
	* @return the number of port type inputdeck forms
	* @throws SystemException if a system exception occurred
	*/
	public static int getPortTypeInputdeckFormsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortTypeInputdeckFormsCount();
	}

	/**
	* Updates the port type inputdeck form in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portTypeInputdeckForm the port type inputdeck form
	* @return the port type inputdeck form that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.PortTypeInputdeckForm updatePortTypeInputdeckForm(
		org.kisti.edison.science.model.PortTypeInputdeckForm portTypeInputdeckForm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePortTypeInputdeckForm(portTypeInputdeckForm);
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

	public static org.kisti.edison.science.model.PortTypeInputdeckForm create(
		long portTypeId, java.lang.String inputdeckForm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().create(portTypeId, inputdeckForm);
	}

	public static java.lang.String getInputdeckFormJsonString(long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInputdeckFormJsonString(portTypeId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PortTypeInputdeckFormLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PortTypeInputdeckFormLocalService.class.getName());

			if (invokableLocalService instanceof PortTypeInputdeckFormLocalService) {
				_service = (PortTypeInputdeckFormLocalService)invokableLocalService;
			}
			else {
				_service = new PortTypeInputdeckFormLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PortTypeInputdeckFormLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PortTypeInputdeckFormLocalService service) {
	}

	private static PortTypeInputdeckFormLocalService _service;
}