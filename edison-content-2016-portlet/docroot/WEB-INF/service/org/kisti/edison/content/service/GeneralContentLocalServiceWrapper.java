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
 * Provides a wrapper for {@link GeneralContentLocalService}.
 *
 * @author EDISON
 * @see GeneralContentLocalService
 * @generated
 */
public class GeneralContentLocalServiceWrapper
	implements GeneralContentLocalService,
		ServiceWrapper<GeneralContentLocalService> {
	public GeneralContentLocalServiceWrapper(
		GeneralContentLocalService generalContentLocalService) {
		_generalContentLocalService = generalContentLocalService;
	}

	/**
	* Adds the general content to the database. Also notifies the appropriate model listeners.
	*
	* @param generalContent the general content
	* @return the general content that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.GeneralContent addGeneralContent(
		org.kisti.edison.content.model.GeneralContent generalContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalContentLocalService.addGeneralContent(generalContent);
	}

	/**
	* Creates a new general content with the primary key. Does not add the general content to the database.
	*
	* @param generalContentPK the primary key for the new general content
	* @return the new general content
	*/
	@Override
	public org.kisti.edison.content.model.GeneralContent createGeneralContent(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK) {
		return _generalContentLocalService.createGeneralContent(generalContentPK);
	}

	/**
	* Deletes the general content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param generalContentPK the primary key of the general content
	* @return the general content that was removed
	* @throws PortalException if a general content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.GeneralContent deleteGeneralContent(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _generalContentLocalService.deleteGeneralContent(generalContentPK);
	}

	/**
	* Deletes the general content from the database. Also notifies the appropriate model listeners.
	*
	* @param generalContent the general content
	* @return the general content that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.GeneralContent deleteGeneralContent(
		org.kisti.edison.content.model.GeneralContent generalContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalContentLocalService.deleteGeneralContent(generalContent);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _generalContentLocalService.dynamicQuery();
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
		return _generalContentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _generalContentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _generalContentLocalService.dynamicQuery(dynamicQuery, start,
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
		return _generalContentLocalService.dynamicQueryCount(dynamicQuery);
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
		return _generalContentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.content.model.GeneralContent fetchGeneralContent(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalContentLocalService.fetchGeneralContent(generalContentPK);
	}

	/**
	* Returns the general content with the primary key.
	*
	* @param generalContentPK the primary key of the general content
	* @return the general content
	* @throws PortalException if a general content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.GeneralContent getGeneralContent(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _generalContentLocalService.getGeneralContent(generalContentPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _generalContentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the general contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of general contents
	* @param end the upper bound of the range of general contents (not inclusive)
	* @return the range of general contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.content.model.GeneralContent> getGeneralContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalContentLocalService.getGeneralContents(start, end);
	}

	/**
	* Returns the number of general contents.
	*
	* @return the number of general contents
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGeneralContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalContentLocalService.getGeneralContentsCount();
	}

	/**
	* Updates the general content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param generalContent the general content
	* @return the general content that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.content.model.GeneralContent updateGeneralContent(
		org.kisti.edison.content.model.GeneralContent generalContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _generalContentLocalService.updateGeneralContent(generalContent);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _generalContentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_generalContentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _generalContentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getGeneralContentStsList(
		long groupId, long contentDiv, int start, int end,
		java.util.Locale locale) throws java.lang.Exception {
		return _generalContentLocalService.getGeneralContentStsList(groupId,
			contentDiv, start, end, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getGeneralContentList(
		long groupId, long companyId, long contentDiv,
		java.lang.String searchText, int start, int end,
		com.liferay.portal.model.User user, java.util.Locale locale)
		throws java.lang.Exception {
		return _generalContentLocalService.getGeneralContentList(groupId,
			companyId, contentDiv, searchText, start, end, user, locale);
	}

	@Override
	public int getGeneralContentCountByGroupId(long groupId, long contentDiv,
		java.lang.String searchText, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException {
		return _generalContentLocalService.getGeneralContentCountByGroupId(groupId,
			contentDiv, searchText, locale);
	}

	@Override
	public void updateContentInsertId(long groupId, long contentSeq,
		long userId, java.lang.String projectYn, long projectId)
		throws java.lang.Exception {
		_generalContentLocalService.updateContentInsertId(groupId, contentSeq,
			userId, projectYn, projectId);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getGeneralContentForProjectList(
		long userId, java.lang.String searchText,
		java.lang.String projectCategoryId, java.lang.String languageId,
		int start, int end, java.util.Locale locale) throws java.lang.Exception {
		return _generalContentLocalService.getGeneralContentForProjectList(userId,
			searchText, projectCategoryId, languageId, start, end, locale);
	}

	@Override
	public org.kisti.edison.content.model.GeneralContent getGeneralContentForProjectObj(
		long contentSeq) throws java.lang.Exception {
		return _generalContentLocalService.getGeneralContentForProjectObj(contentSeq);
	}

	@Override
	public int getGeneralContentCountByGroupIdForProjectList(long userId,
		java.lang.String searchText, java.lang.String projectCategoryId,
		java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException {
		return _generalContentLocalService.getGeneralContentCountByGroupIdForProjectList(userId,
			searchText, projectCategoryId, languageId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GeneralContentLocalService getWrappedGeneralContentLocalService() {
		return _generalContentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGeneralContentLocalService(
		GeneralContentLocalService generalContentLocalService) {
		_generalContentLocalService = generalContentLocalService;
	}

	@Override
	public GeneralContentLocalService getWrappedService() {
		return _generalContentLocalService;
	}

	@Override
	public void setWrappedService(
		GeneralContentLocalService generalContentLocalService) {
		_generalContentLocalService = generalContentLocalService;
	}

	private GeneralContentLocalService _generalContentLocalService;
}