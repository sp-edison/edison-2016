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
 * Provides the local service utility for PortType. This utility wraps
 * {@link com.kisti.science.platform.app.service.impl.PortTypeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeLocalService
 * @see com.kisti.science.platform.app.service.base.PortTypeLocalServiceBaseImpl
 * @see com.kisti.science.platform.app.service.impl.PortTypeLocalServiceImpl
 * @generated
 */
public class PortTypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.kisti.science.platform.app.service.impl.PortTypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the port type to the database. Also notifies the appropriate model listeners.
	*
	* @param portType the port type
	* @return the port type that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType addPortType(
		com.kisti.science.platform.app.model.PortType portType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPortType(portType);
	}

	/**
	* Creates a new port type with the primary key. Does not add the port type to the database.
	*
	* @param portTypeId the primary key for the new port type
	* @return the new port type
	*/
	public static com.kisti.science.platform.app.model.PortType createPortType(
		long portTypeId) {
		return getService().createPortType(portTypeId);
	}

	/**
	* Deletes the port type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeId the primary key of the port type
	* @return the port type that was removed
	* @throws PortalException if a port type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType deletePortType(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePortType(portTypeId);
	}

	/**
	* Deletes the port type from the database. Also notifies the appropriate model listeners.
	*
	* @param portType the port type
	* @return the port type that was removed
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType deletePortType(
		com.kisti.science.platform.app.model.PortType portType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePortType(portType);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.kisti.science.platform.app.model.PortType fetchPortType(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPortType(portTypeId);
	}

	/**
	* Returns the port type with the matching UUID and company.
	*
	* @param uuid the port type's UUID
	* @param companyId the primary key of the company
	* @return the matching port type, or <code>null</code> if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType fetchPortTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPortTypeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the port type with the primary key.
	*
	* @param portTypeId the primary key of the port type
	* @return the port type
	* @throws PortalException if a port type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType getPortType(
		long portTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortType(portTypeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the port type with the matching UUID and company.
	*
	* @param uuid the port type's UUID
	* @param companyId the primary key of the company
	* @return the matching port type
	* @throws PortalException if a matching port type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType getPortTypeByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortTypeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of all the port types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port types
	* @param end the upper bound of the range of port types (not inclusive)
	* @return the range of port types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortType> getPortTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortTypes(start, end);
	}

	/**
	* Returns the number of port types.
	*
	* @return the number of port types
	* @throws SystemException if a system exception occurred
	*/
	public static int getPortTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortTypesCount();
	}

	/**
	* Updates the port type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portType the port type
	* @return the port type that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortType updatePortType(
		com.kisti.science.platform.app.model.PortType portType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePortType(portType);
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

	/**
	* Create a port type of a science app. If provided new port type name already exist, returns null instance.
	* Created new port type is not saved in database physically.
	*
	* @author Jerry H. Seo
	* @param String portTypeName
	* @param ServiceContext sc
	* @throws SystemException
	* @return PortType instance
	*/
	public static com.kisti.science.platform.app.model.PortType createPortType(
		java.lang.String portTypeName,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createPortType(portTypeName, sc);
	}

	/**
	* @param portTypeName
	* @return
	* @throws SystemException
	* @see com.kisti.science.platform.service.PortTypeLocalService#existPortType(java.lang.String)
	*/
	public static boolean existPortType(java.lang.String portTypeName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().existPortType(portTypeName);
	}

	public static void setPortTypeInputdeckForm(long portTypeId,
		java.lang.String inputdeckForm)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().setPortTypeInputdeckForm(portTypeId, inputdeckForm);
	}

	public static void clearService() {
		_service = null;
	}

	public static PortTypeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PortTypeLocalService.class.getName());

			if (invokableLocalService instanceof PortTypeLocalService) {
				_service = (PortTypeLocalService)invokableLocalService;
			}
			else {
				_service = new PortTypeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PortTypeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PortTypeLocalService service) {
	}

	private static PortTypeLocalService _service;
}