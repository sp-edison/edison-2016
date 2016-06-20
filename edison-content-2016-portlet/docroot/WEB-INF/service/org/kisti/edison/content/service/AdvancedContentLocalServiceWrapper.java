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
 * Provides a wrapper for {@link AdvancedContentLocalService}.
 *
 * @author EDISON
 * @see AdvancedContentLocalService
 * @generated
 */
public class AdvancedContentLocalServiceWrapper
	implements AdvancedContentLocalService,
		ServiceWrapper<AdvancedContentLocalService> {
	public AdvancedContentLocalServiceWrapper(
		AdvancedContentLocalService advancedContentLocalService) {
		_advancedContentLocalService = advancedContentLocalService;
	}

	/**
	* Adds the advanced content to the database. Also notifies the appropriate model listeners.
	*
	* @param advancedContent the advanced content
	* @return the advanced content that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.AdvancedContent addAdvancedContent(
		org.kisti.edison.content.model.AdvancedContent advancedContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advancedContentLocalService.addAdvancedContent(advancedContent);
	}

	/**
	* Creates a new advanced content with the primary key. Does not add the advanced content to the database.
	*
	* @param advancedContentPK the primary key for the new advanced content
	* @return the new advanced content
	*/
	@Override
	public org.kisti.edison.content.model.AdvancedContent createAdvancedContent(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK) {
		return _advancedContentLocalService.createAdvancedContent(advancedContentPK);
	}

	/**
	* Deletes the advanced content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param advancedContentPK the primary key of the advanced content
	* @return the advanced content that was removed
	* @throws PortalException if a advanced content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.AdvancedContent deleteAdvancedContent(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advancedContentLocalService.deleteAdvancedContent(advancedContentPK);
	}

	/**
	* Deletes the advanced content from the database. Also notifies the appropriate model listeners.
	*
	* @param advancedContent the advanced content
	* @return the advanced content that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.AdvancedContent deleteAdvancedContent(
		org.kisti.edison.content.model.AdvancedContent advancedContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advancedContentLocalService.deleteAdvancedContent(advancedContent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _advancedContentLocalService.dynamicQuery();
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
		return _advancedContentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _advancedContentLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _advancedContentLocalService.dynamicQuery(dynamicQuery, start,
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
		return _advancedContentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _advancedContentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.content.model.AdvancedContent fetchAdvancedContent(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advancedContentLocalService.fetchAdvancedContent(advancedContentPK);
	}

	/**
	* Returns the advanced content with the primary key.
	*
	* @param advancedContentPK the primary key of the advanced content
	* @return the advanced content
	* @throws PortalException if a advanced content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.AdvancedContent getAdvancedContent(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advancedContentLocalService.getAdvancedContent(advancedContentPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _advancedContentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the advanced contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of advanced contents
	* @param end the upper bound of the range of advanced contents (not inclusive)
	* @return the range of advanced contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.content.model.AdvancedContent> getAdvancedContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advancedContentLocalService.getAdvancedContents(start, end);
	}

	/**
	* Returns the number of advanced contents.
	*
	* @return the number of advanced contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAdvancedContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advancedContentLocalService.getAdvancedContentsCount();
	}

	/**
	* Updates the advanced content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param advancedContent the advanced content
	* @return the advanced content that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.AdvancedContent updateAdvancedContent(
		org.kisti.edison.content.model.AdvancedContent advancedContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advancedContentLocalService.updateAdvancedContent(advancedContent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _advancedContentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_advancedContentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _advancedContentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getAdvancedContentListByGroupId(
		long groupId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _advancedContentLocalService.getAdvancedContentListByGroupId(groupId,
			locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getAdvancedContentListByGroupId(
		long groupId, com.liferay.portal.model.User user,
		java.util.Locale locale,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws java.lang.Exception {
		return _advancedContentLocalService.getAdvancedContentListByGroupId(groupId,
			user, locale, themeDisplay);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AdvancedContentLocalService getWrappedAdvancedContentLocalService() {
		return _advancedContentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAdvancedContentLocalService(
		AdvancedContentLocalService advancedContentLocalService) {
		_advancedContentLocalService = advancedContentLocalService;
	}

	@Override
	public AdvancedContentLocalService getWrappedService() {
		return _advancedContentLocalService;
	}

	@Override
	public void setWrappedService(
		AdvancedContentLocalService advancedContentLocalService) {
		_advancedContentLocalService = advancedContentLocalService;
	}

	private AdvancedContentLocalService _advancedContentLocalService;
}