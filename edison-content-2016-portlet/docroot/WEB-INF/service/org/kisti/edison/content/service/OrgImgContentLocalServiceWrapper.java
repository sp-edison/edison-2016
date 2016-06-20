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

package org.kisti.edison.content.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OrgImgContentLocalService}.
 *
 * @author EDISON
 * @see OrgImgContentLocalService
 * @generated
 */
public class OrgImgContentLocalServiceWrapper
	implements OrgImgContentLocalService,
		ServiceWrapper<OrgImgContentLocalService> {
	public OrgImgContentLocalServiceWrapper(
		OrgImgContentLocalService orgImgContentLocalService) {
		_orgImgContentLocalService = orgImgContentLocalService;
	}

	/**
	* Adds the org img content to the database. Also notifies the appropriate model listeners.
	*
	* @param orgImgContent the org img content
	* @return the org img content that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.OrgImgContent addOrgImgContent(
		org.kisti.edison.content.model.OrgImgContent orgImgContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgImgContentLocalService.addOrgImgContent(orgImgContent);
	}

	/**
	* Creates a new org img content with the primary key. Does not add the org img content to the database.
	*
	* @param orgImgContentPK the primary key for the new org img content
	* @return the new org img content
	*/
	@Override
	public org.kisti.edison.content.model.OrgImgContent createOrgImgContent(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK) {
		return _orgImgContentLocalService.createOrgImgContent(orgImgContentPK);
	}

	/**
	* Deletes the org img content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orgImgContentPK the primary key of the org img content
	* @return the org img content that was removed
	* @throws PortalException if a org img content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.OrgImgContent deleteOrgImgContent(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgImgContentLocalService.deleteOrgImgContent(orgImgContentPK);
	}

	/**
	* Deletes the org img content from the database. Also notifies the appropriate model listeners.
	*
	* @param orgImgContent the org img content
	* @return the org img content that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.OrgImgContent deleteOrgImgContent(
		org.kisti.edison.content.model.OrgImgContent orgImgContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgImgContentLocalService.deleteOrgImgContent(orgImgContent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _orgImgContentLocalService.dynamicQuery();
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
		return _orgImgContentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.OrgImgContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _orgImgContentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.OrgImgContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _orgImgContentLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _orgImgContentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _orgImgContentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.content.model.OrgImgContent fetchOrgImgContent(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgImgContentLocalService.fetchOrgImgContent(orgImgContentPK);
	}

	/**
	* Returns the org img content with the primary key.
	*
	* @param orgImgContentPK the primary key of the org img content
	* @return the org img content
	* @throws PortalException if a org img content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.OrgImgContent getOrgImgContent(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgImgContentLocalService.getOrgImgContent(orgImgContentPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgImgContentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the org img contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.OrgImgContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of org img contents
	* @param end the upper bound of the range of org img contents (not inclusive)
	* @return the range of org img contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.content.model.OrgImgContent> getOrgImgContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgImgContentLocalService.getOrgImgContents(start, end);
	}

	/**
	* Returns the number of org img contents.
	*
	* @return the number of org img contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOrgImgContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgImgContentLocalService.getOrgImgContentsCount();
	}

	/**
	* Updates the org img content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param orgImgContent the org img content
	* @return the org img content that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.OrgImgContent updateOrgImgContent(
		org.kisti.edison.content.model.OrgImgContent orgImgContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgImgContentLocalService.updateOrgImgContent(orgImgContent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _orgImgContentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_orgImgContentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _orgImgContentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getOrgImgContentListByGroupId(
		long groupId, com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchOrgImgContentException {
		return _orgImgContentLocalService.getOrgImgContentListByGroupId(groupId,
			themeDisplay);
	}

	@Override
	public int getOrgImgContentCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgImgContentLocalService.getOrgImgContentCountByGroupId(groupId);
	}

	/**
	* 占쎄퀣�좑옙占쏙옙占쎌젫占쏙옙占쎈슣�좑옙占폫eorder
	*/
	@Override
	public void deleteResetOrder(long groupId, long deleteOrgImgSeq,
		long deleteOrder, long fileEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchOrgImgContentException {
		_orgImgContentLocalService.deleteResetOrder(groupId, deleteOrgImgSeq,
			deleteOrder, fileEntryId);
	}

	/**
	* 占쎄퀣�좑옙占쏙옙�낅쑓占쎈똾��獄쏉옙占쎌뮆苡�占쎌꼷��     *
	* @param groupId
	* @param param
	* @throws SystemException
	*/
	@Override
	public void updateOrgImgContentWithOrder(long groupId, java.util.Map param)
		throws com.liferay.portal.kernel.exception.SystemException {
		_orgImgContentLocalService.updateOrgImgContentWithOrder(groupId, param);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OrgImgContentLocalService getWrappedOrgImgContentLocalService() {
		return _orgImgContentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOrgImgContentLocalService(
		OrgImgContentLocalService orgImgContentLocalService) {
		_orgImgContentLocalService = orgImgContentLocalService;
	}

	@Override
	public OrgImgContentLocalService getWrappedService() {
		return _orgImgContentLocalService;
	}

	@Override
	public void setWrappedService(
		OrgImgContentLocalService orgImgContentLocalService) {
		_orgImgContentLocalService = orgImgContentLocalService;
	}

	private OrgImgContentLocalService _orgImgContentLocalService;
}