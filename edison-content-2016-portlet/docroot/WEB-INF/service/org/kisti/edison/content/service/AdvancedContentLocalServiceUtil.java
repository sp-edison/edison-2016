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
 * Provides the local service utility for AdvancedContent. This utility wraps
 * {@link org.kisti.edison.content.service.impl.AdvancedContentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see AdvancedContentLocalService
 * @see org.kisti.edison.content.service.base.AdvancedContentLocalServiceBaseImpl
 * @see org.kisti.edison.content.service.impl.AdvancedContentLocalServiceImpl
 * @generated
 */
public class AdvancedContentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.content.service.impl.AdvancedContentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the advanced content to the database. Also notifies the appropriate model listeners.
	*
	* @param advancedContent the advanced content
	* @return the advanced content that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent addAdvancedContent(
		org.kisti.edison.content.model.AdvancedContent advancedContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAdvancedContent(advancedContent);
	}

	/**
	* Creates a new advanced content with the primary key. Does not add the advanced content to the database.
	*
	* @param advancedContentPK the primary key for the new advanced content
	* @return the new advanced content
	*/
	public static org.kisti.edison.content.model.AdvancedContent createAdvancedContent(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK) {
		return getService().createAdvancedContent(advancedContentPK);
	}

	/**
	* Deletes the advanced content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param advancedContentPK the primary key of the advanced content
	* @return the advanced content that was removed
	* @throws PortalException if a advanced content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent deleteAdvancedContent(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAdvancedContent(advancedContentPK);
	}

	/**
	* Deletes the advanced content from the database. Also notifies the appropriate model listeners.
	*
	* @param advancedContent the advanced content
	* @return the advanced content that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent deleteAdvancedContent(
		org.kisti.edison.content.model.AdvancedContent advancedContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAdvancedContent(advancedContent);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.kisti.edison.content.model.AdvancedContent fetchAdvancedContent(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAdvancedContent(advancedContentPK);
	}

	/**
	* Returns the advanced content with the primary key.
	*
	* @param advancedContentPK the primary key of the advanced content
	* @return the advanced content
	* @throws PortalException if a advanced content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent getAdvancedContent(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdvancedContent(advancedContentPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.kisti.edison.content.model.AdvancedContent> getAdvancedContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdvancedContents(start, end);
	}

	/**
	* Returns the number of advanced contents.
	*
	* @return the number of advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public static int getAdvancedContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdvancedContentsCount();
	}

	/**
	* Updates the advanced content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param advancedContent the advanced content
	* @return the advanced content that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent updateAdvancedContent(
		org.kisti.edison.content.model.AdvancedContent advancedContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAdvancedContent(advancedContent);
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

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getAdvancedContentListByGroupId(
		long groupId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAdvancedContentListByGroupId(groupId, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getAdvancedContentListByGroupId(
		long groupId, com.liferay.portal.model.User user,
		java.util.Locale locale,
		com.liferay.portal.theme.ThemeDisplay themeDisplay)
		throws java.lang.Exception {
		return getService()
				   .getAdvancedContentListByGroupId(groupId, user, locale,
			themeDisplay);
	}

	public static void clearService() {
		_service = null;
	}

	public static AdvancedContentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AdvancedContentLocalService.class.getName());

			if (invokableLocalService instanceof AdvancedContentLocalService) {
				_service = (AdvancedContentLocalService)invokableLocalService;
			}
			else {
				_service = new AdvancedContentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AdvancedContentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AdvancedContentLocalService service) {
	}

	private static AdvancedContentLocalService _service;
}