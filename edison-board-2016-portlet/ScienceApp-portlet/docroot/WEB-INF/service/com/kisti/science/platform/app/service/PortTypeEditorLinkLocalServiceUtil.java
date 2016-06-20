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
 * Provides the local service utility for PortTypeEditorLink. This utility wraps
 * {@link com.kisti.science.platform.app.service.impl.PortTypeEditorLinkLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeEditorLinkLocalService
 * @see com.kisti.science.platform.app.service.base.PortTypeEditorLinkLocalServiceBaseImpl
 * @see com.kisti.science.platform.app.service.impl.PortTypeEditorLinkLocalServiceImpl
 * @generated
 */
public class PortTypeEditorLinkLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.kisti.science.platform.app.service.impl.PortTypeEditorLinkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the port type editor link to the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeEditorLink the port type editor link
	* @return the port type editor link that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink addPortTypeEditorLink(
		com.kisti.science.platform.app.model.PortTypeEditorLink portTypeEditorLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPortTypeEditorLink(portTypeEditorLink);
	}

	/**
	* Creates a new port type editor link with the primary key. Does not add the port type editor link to the database.
	*
	* @param portTypeEditorLinkId the primary key for the new port type editor link
	* @return the new port type editor link
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink createPortTypeEditorLink(
		long portTypeEditorLinkId) {
		return getService().createPortTypeEditorLink(portTypeEditorLinkId);
	}

	/**
	* Deletes the port type editor link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeEditorLinkId the primary key of the port type editor link
	* @return the port type editor link that was removed
	* @throws PortalException if a port type editor link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink deletePortTypeEditorLink(
		long portTypeEditorLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePortTypeEditorLink(portTypeEditorLinkId);
	}

	/**
	* Deletes the port type editor link from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeEditorLink the port type editor link
	* @return the port type editor link that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink deletePortTypeEditorLink(
		com.kisti.science.platform.app.model.PortTypeEditorLink portTypeEditorLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePortTypeEditorLink(portTypeEditorLink);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.kisti.science.platform.app.model.PortTypeEditorLink fetchPortTypeEditorLink(
		long portTypeEditorLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPortTypeEditorLink(portTypeEditorLinkId);
	}

	/**
	* Returns the port type editor link with the matching UUID and company.
	*
	* @param uuid the port type editor link's UUID
	* @param companyId the primary key of the company
	* @return the matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink fetchPortTypeEditorLinkByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchPortTypeEditorLinkByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the port type editor link with the primary key.
	*
	* @param portTypeEditorLinkId the primary key of the port type editor link
	* @return the port type editor link
	* @throws PortalException if a port type editor link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink getPortTypeEditorLink(
		long portTypeEditorLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortTypeEditorLink(portTypeEditorLinkId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the port type editor link with the matching UUID and company.
	*
	* @param uuid the port type editor link's UUID
	* @param companyId the primary key of the company
	* @return the matching port type editor link
	* @throws PortalException if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink getPortTypeEditorLinkByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getPortTypeEditorLinkByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of all the port type editor links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type editor links
	* @param end the upper bound of the range of port type editor links (not inclusive)
	* @return the range of port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> getPortTypeEditorLinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortTypeEditorLinks(start, end);
	}

	/**
	* Returns the number of port type editor links.
	*
	* @return the number of port type editor links
	* @throws SystemException if a system exception occurred
	*/
	public static int getPortTypeEditorLinksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPortTypeEditorLinksCount();
	}

	/**
	* Updates the port type editor link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portTypeEditorLink the port type editor link
	* @return the port type editor link that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.PortTypeEditorLink updatePortTypeEditorLink(
		com.kisti.science.platform.app.model.PortTypeEditorLink portTypeEditorLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePortTypeEditorLink(portTypeEditorLink);
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

	public static void clearService() {
		_service = null;
	}

	public static PortTypeEditorLinkLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PortTypeEditorLinkLocalService.class.getName());

			if (invokableLocalService instanceof PortTypeEditorLinkLocalService) {
				_service = (PortTypeEditorLinkLocalService)invokableLocalService;
			}
			else {
				_service = new PortTypeEditorLinkLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PortTypeEditorLinkLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PortTypeEditorLinkLocalService service) {
	}

	private static PortTypeEditorLinkLocalService _service;
}