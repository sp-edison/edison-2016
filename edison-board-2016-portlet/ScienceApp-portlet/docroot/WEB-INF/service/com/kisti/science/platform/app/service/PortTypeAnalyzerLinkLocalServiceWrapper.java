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
 * Provides a wrapper for {@link PortTypeAnalyzerLinkLocalService}.
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeAnalyzerLinkLocalService
 * @generated
 */
public class PortTypeAnalyzerLinkLocalServiceWrapper
	implements PortTypeAnalyzerLinkLocalService,
		ServiceWrapper<PortTypeAnalyzerLinkLocalService> {
	public PortTypeAnalyzerLinkLocalServiceWrapper(
		PortTypeAnalyzerLinkLocalService portTypeAnalyzerLinkLocalService) {
		_portTypeAnalyzerLinkLocalService = portTypeAnalyzerLinkLocalService;
	}

	/**
	* Adds the port type analyzer link to the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeAnalyzerLink the port type analyzer link
	* @return the port type analyzer link that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeAnalyzerLink addPortTypeAnalyzerLink(
		com.kisti.science.platform.app.model.PortTypeAnalyzerLink portTypeAnalyzerLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeAnalyzerLinkLocalService.addPortTypeAnalyzerLink(portTypeAnalyzerLink);
	}

	/**
	* Creates a new port type analyzer link with the primary key. Does not add the port type analyzer link to the database.
	*
	* @param portTypeAnalyzerLinkId the primary key for the new port type analyzer link
	* @return the new port type analyzer link
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeAnalyzerLink createPortTypeAnalyzerLink(
		long portTypeAnalyzerLinkId) {
		return _portTypeAnalyzerLinkLocalService.createPortTypeAnalyzerLink(portTypeAnalyzerLinkId);
	}

	/**
	* Deletes the port type analyzer link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeAnalyzerLinkId the primary key of the port type analyzer link
	* @return the port type analyzer link that was removed
	* @throws PortalException if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeAnalyzerLink deletePortTypeAnalyzerLink(
		long portTypeAnalyzerLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeAnalyzerLinkLocalService.deletePortTypeAnalyzerLink(portTypeAnalyzerLinkId);
	}

	/**
	* Deletes the port type analyzer link from the database. Also notifies the appropriate model listeners.
	*
	* @param portTypeAnalyzerLink the port type analyzer link
	* @return the port type analyzer link that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeAnalyzerLink deletePortTypeAnalyzerLink(
		com.kisti.science.platform.app.model.PortTypeAnalyzerLink portTypeAnalyzerLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeAnalyzerLinkLocalService.deletePortTypeAnalyzerLink(portTypeAnalyzerLink);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _portTypeAnalyzerLinkLocalService.dynamicQuery();
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
		return _portTypeAnalyzerLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _portTypeAnalyzerLinkLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _portTypeAnalyzerLinkLocalService.dynamicQuery(dynamicQuery,
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
		return _portTypeAnalyzerLinkLocalService.dynamicQueryCount(dynamicQuery);
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
		return _portTypeAnalyzerLinkLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.kisti.science.platform.app.model.PortTypeAnalyzerLink fetchPortTypeAnalyzerLink(
		long portTypeAnalyzerLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeAnalyzerLinkLocalService.fetchPortTypeAnalyzerLink(portTypeAnalyzerLinkId);
	}

	/**
	* Returns the port type analyzer link with the matching UUID and company.
	*
	* @param uuid the port type analyzer link's UUID
	* @param companyId the primary key of the company
	* @return the matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeAnalyzerLink fetchPortTypeAnalyzerLinkByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeAnalyzerLinkLocalService.fetchPortTypeAnalyzerLinkByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the port type analyzer link with the primary key.
	*
	* @param portTypeAnalyzerLinkId the primary key of the port type analyzer link
	* @return the port type analyzer link
	* @throws PortalException if a port type analyzer link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeAnalyzerLink getPortTypeAnalyzerLink(
		long portTypeAnalyzerLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeAnalyzerLinkLocalService.getPortTypeAnalyzerLink(portTypeAnalyzerLinkId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeAnalyzerLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the port type analyzer link with the matching UUID and company.
	*
	* @param uuid the port type analyzer link's UUID
	* @param companyId the primary key of the company
	* @return the matching port type analyzer link
	* @throws PortalException if a matching port type analyzer link could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeAnalyzerLink getPortTypeAnalyzerLinkByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _portTypeAnalyzerLinkLocalService.getPortTypeAnalyzerLinkByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of all the port type analyzer links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of port type analyzer links
	* @param end the upper bound of the range of port type analyzer links (not inclusive)
	* @return the range of port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.kisti.science.platform.app.model.PortTypeAnalyzerLink> getPortTypeAnalyzerLinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeAnalyzerLinkLocalService.getPortTypeAnalyzerLinks(start,
			end);
	}

	/**
	* Returns the number of port type analyzer links.
	*
	* @return the number of port type analyzer links
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPortTypeAnalyzerLinksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeAnalyzerLinkLocalService.getPortTypeAnalyzerLinksCount();
	}

	/**
	* Updates the port type analyzer link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param portTypeAnalyzerLink the port type analyzer link
	* @return the port type analyzer link that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.kisti.science.platform.app.model.PortTypeAnalyzerLink updatePortTypeAnalyzerLink(
		com.kisti.science.platform.app.model.PortTypeAnalyzerLink portTypeAnalyzerLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _portTypeAnalyzerLinkLocalService.updatePortTypeAnalyzerLink(portTypeAnalyzerLink);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _portTypeAnalyzerLinkLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_portTypeAnalyzerLinkLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _portTypeAnalyzerLinkLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PortTypeAnalyzerLinkLocalService getWrappedPortTypeAnalyzerLinkLocalService() {
		return _portTypeAnalyzerLinkLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPortTypeAnalyzerLinkLocalService(
		PortTypeAnalyzerLinkLocalService portTypeAnalyzerLinkLocalService) {
		_portTypeAnalyzerLinkLocalService = portTypeAnalyzerLinkLocalService;
	}

	@Override
	public PortTypeAnalyzerLinkLocalService getWrappedService() {
		return _portTypeAnalyzerLinkLocalService;
	}

	@Override
	public void setWrappedService(
		PortTypeAnalyzerLinkLocalService portTypeAnalyzerLinkLocalService) {
		_portTypeAnalyzerLinkLocalService = portTypeAnalyzerLinkLocalService;
	}

	private PortTypeAnalyzerLinkLocalService _portTypeAnalyzerLinkLocalService;
}