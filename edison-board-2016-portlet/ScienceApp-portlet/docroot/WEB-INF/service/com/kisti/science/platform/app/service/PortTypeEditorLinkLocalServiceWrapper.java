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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PortTypeEditorLinkLocalService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeEditorLinkLocalService
 * @generated
 */
public class PortTypeEditorLinkLocalServiceWrapper
	implements PortTypeEditorLinkLocalService,
		ServiceWrapper<PortTypeEditorLinkLocalService> {
	public PortTypeEditorLinkLocalServiceWrapper(
		PortTypeEditorLinkLocalService portTypeEditorLinkLocalService) {
		_portTypeEditorLinkLocalService = portTypeEditorLinkLocalService;
	}

	/**
	* Adds the port type editor link to the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeEditorLink the port type editor link
	* @return the port type editor link that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeEditorLink addPortTypeEditorLink(
		com.kisti.science.platform.app.model.PortTypeEditorLink portTypeEditorLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeEditorLinkLocalService.addPortTypeEditorLink(portTypeEditorLink);
	}

	/**
	* Creates a new port type editor link with the primary key. Does not add the port type editor link to the database.
	*
	* @param portTypeEditorLinkId the primary key for the new port type editor link
	* @return the new port type editor link
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeEditorLink createPortTypeEditorLink(
		long portTypeEditorLinkId) {
		return _portTypeEditorLinkLocalService.createPortTypeEditorLink(portTypeEditorLinkId);
	}

	/**
	* Deletes the port type editor link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeEditorLinkId the primary key of the port type editor link
	* @return the port type editor link that was removed
	* @throws PortalException if a port type editor link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeEditorLink deletePortTypeEditorLink(
		long portTypeEditorLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeEditorLinkLocalService.deletePortTypeEditorLink(portTypeEditorLinkId);
	}

	/**
	* Deletes the port type editor link from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeEditorLink the port type editor link
	* @return the port type editor link that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeEditorLink deletePortTypeEditorLink(
		com.kisti.science.platform.app.model.PortTypeEditorLink portTypeEditorLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeEditorLinkLocalService.deletePortTypeEditorLink(portTypeEditorLink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _portTypeEditorLinkLocalService.dynamicQuery();
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
		return _portTypeEditorLinkLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeEditorLinkLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeEditorLinkLocalService.dynamicQuery(dynamicQuery,
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
		return _portTypeEditorLinkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _portTypeEditorLinkLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kisti.science.platform.app.model.PortTypeEditorLink fetchPortTypeEditorLink(
		long portTypeEditorLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeEditorLinkLocalService.fetchPortTypeEditorLink(portTypeEditorLinkId);
	}

	/**
	* Returns the port type editor link with the matching UUID and company.
	*
	* @param uuid the port type editor link's UUID
	* @param companyId the primary key of the company
	* @return the matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeEditorLink fetchPortTypeEditorLinkByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeEditorLinkLocalService.fetchPortTypeEditorLinkByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the port type editor link with the primary key.
	*
	* @param portTypeEditorLinkId the primary key of the port type editor link
	* @return the port type editor link
	* @throws PortalException if a port type editor link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeEditorLink getPortTypeEditorLink(
		long portTypeEditorLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeEditorLinkLocalService.getPortTypeEditorLink(portTypeEditorLinkId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeEditorLinkLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.kisti.science.platform.app.model.PortTypeEditorLink getPortTypeEditorLinkByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeEditorLinkLocalService.getPortTypeEditorLinkByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public java.util.List<com.kisti.science.platform.app.model.PortTypeEditorLink> getPortTypeEditorLinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeEditorLinkLocalService.getPortTypeEditorLinks(start, end);
	}

	/**
	* Returns the number of port type editor links.
	*
	* @return the number of port type editor links
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPortTypeEditorLinksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeEditorLinkLocalService.getPortTypeEditorLinksCount();
	}

	/**
	* Updates the port type editor link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portTypeEditorLink the port type editor link
	* @return the port type editor link that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeEditorLink updatePortTypeEditorLink(
		com.kisti.science.platform.app.model.PortTypeEditorLink portTypeEditorLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeEditorLinkLocalService.updatePortTypeEditorLink(portTypeEditorLink);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _portTypeEditorLinkLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_portTypeEditorLinkLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _portTypeEditorLinkLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PortTypeEditorLinkLocalService getWrappedPortTypeEditorLinkLocalService() {
		return _portTypeEditorLinkLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPortTypeEditorLinkLocalService(
		PortTypeEditorLinkLocalService portTypeEditorLinkLocalService) {
		_portTypeEditorLinkLocalService = portTypeEditorLinkLocalService;
	}

	@Override
	public PortTypeEditorLinkLocalService getWrappedService() {
		return _portTypeEditorLinkLocalService;
	}

	@Override
	public void setWrappedService(
		PortTypeEditorLinkLocalService portTypeEditorLinkLocalService) {
		_portTypeEditorLinkLocalService = portTypeEditorLinkLocalService;
	}

	private PortTypeEditorLinkLocalService _portTypeEditorLinkLocalService;
}