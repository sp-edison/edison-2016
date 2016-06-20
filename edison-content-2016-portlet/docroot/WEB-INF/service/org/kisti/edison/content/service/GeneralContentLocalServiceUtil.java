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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for GeneralContent. This utility wraps
 * {@link org.kisti.edison.content.service.impl.GeneralContentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see GeneralContentLocalService
 * @see org.kisti.edison.content.service.base.GeneralContentLocalServiceBaseImpl
 * @see org.kisti.edison.content.service.impl.GeneralContentLocalServiceImpl
 * @generated
 */
public class GeneralContentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.content.service.impl.GeneralContentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the general content to the database. Also notifies the appropriate model listeners.
	*
	* @param generalContent the general content
	* @return the general content that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent addGeneralContent(
		org.kisti.edison.content.model.GeneralContent generalContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGeneralContent(generalContent);
	}

	/**
	* Creates a new general content with the primary key. Does not add the general content to the database.
	*
	* @param generalContentPK the primary key for the new general content
	* @return the new general content
	*/
	public static org.kisti.edison.content.model.GeneralContent createGeneralContent(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK) {
		return getService().createGeneralContent(generalContentPK);
	}

	/**
	* Deletes the general content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param generalContentPK the primary key of the general content
	* @return the general content that was removed
	* @throws PortalException if a general content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent deleteGeneralContent(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGeneralContent(generalContentPK);
	}

	/**
	* Deletes the general content from the database. Also notifies the appropriate model listeners.
	*
	* @param generalContent the general content
	* @return the general content that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent deleteGeneralContent(
		org.kisti.edison.content.model.GeneralContent generalContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGeneralContent(generalContent);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.kisti.edison.content.model.GeneralContent fetchGeneralContent(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGeneralContent(generalContentPK);
	}

	/**
	* Returns the general content with the primary key.
	*
	* @param generalContentPK the primary key of the general content
	* @return the general content
	* @throws PortalException if a general content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent getGeneralContent(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGeneralContent(generalContentPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.kisti.edison.content.model.GeneralContent> getGeneralContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGeneralContents(start, end);
	}

	/**
	* Returns the number of general contents.
	*
	* @return the number of general contents
	* @throws SystemException if a system exception occurred
	*/
	public static int getGeneralContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGeneralContentsCount();
	}

	/**
	* Updates the general content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param generalContent the general content
	* @return the general content that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent updateGeneralContent(
		org.kisti.edison.content.model.GeneralContent generalContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGeneralContent(generalContent);
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

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getGeneralContentStsList(
		long groupId, long contentDiv, int start, int end,
		java.util.Locale locale) throws java.lang.Exception {
		return getService()
				   .getGeneralContentStsList(groupId, contentDiv, start, end,
			locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getGeneralContentList(
		long groupId, long companyId, long contentDiv,
		java.lang.String searchText, int start, int end,
		com.liferay.portal.model.User user, java.util.Locale locale)
		throws java.lang.Exception {
		return getService()
				   .getGeneralContentList(groupId, companyId, contentDiv,
			searchText, start, end, user, locale);
	}

	public static int getGeneralContentCountByGroupId(long groupId,
		long contentDiv, java.lang.String searchText, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException {
		return getService()
				   .getGeneralContentCountByGroupId(groupId, contentDiv,
			searchText, locale);
	}

	public static void updateContentInsertId(long groupId, long contentSeq,
		long userId, java.lang.String projectYn, long projectId)
		throws java.lang.Exception {
		getService()
			.updateContentInsertId(groupId, contentSeq, userId, projectYn,
			projectId);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getGeneralContentForProjectList(
		long userId, java.lang.String searchText,
		java.lang.String projectCategoryId, java.lang.String languageId,
		int start, int end, java.util.Locale locale) throws java.lang.Exception {
		return getService()
				   .getGeneralContentForProjectList(userId, searchText,
			projectCategoryId, languageId, start, end, locale);
	}

	public static org.kisti.edison.content.model.GeneralContent getGeneralContentForProjectObj(
		long contentSeq) throws java.lang.Exception {
		return getService().getGeneralContentForProjectObj(contentSeq);
	}

	public static int getGeneralContentCountByGroupIdForProjectList(
		long userId, java.lang.String searchText,
		java.lang.String projectCategoryId, java.lang.String languageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, javax.xml.parsers.ParserConfigurationException,
			org.xml.sax.SAXException {
		return getService()
				   .getGeneralContentCountByGroupIdForProjectList(userId,
			searchText, projectCategoryId, languageId);
	}

	public static void clearService() {
		_service = null;
	}

	public static GeneralContentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GeneralContentLocalService.class.getName());

			if (invokableLocalService instanceof GeneralContentLocalService) {
				_service = (GeneralContentLocalService)invokableLocalService;
			}
			else {
				_service = new GeneralContentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(GeneralContentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GeneralContentLocalService service) {
	}

	private static GeneralContentLocalService _service;
}