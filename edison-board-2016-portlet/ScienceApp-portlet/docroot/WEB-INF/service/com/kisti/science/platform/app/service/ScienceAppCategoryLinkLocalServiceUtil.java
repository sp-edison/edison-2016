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
 * Provides the local service utility for ScienceAppCategoryLink. This utility wraps
 * {@link com.kisti.science.platform.app.service.impl.ScienceAppCategoryLinkLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppCategoryLinkLocalService
 * @see com.kisti.science.platform.app.service.base.ScienceAppCategoryLinkLocalServiceBaseImpl
 * @see com.kisti.science.platform.app.service.impl.ScienceAppCategoryLinkLocalServiceImpl
 * @generated
 */
public class ScienceAppCategoryLinkLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.kisti.science.platform.app.service.impl.ScienceAppCategoryLinkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the science app category link to the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppCategoryLink the science app category link
	* @return the science app category link that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppCategoryLink addScienceAppCategoryLink(
		com.kisti.science.platform.app.model.ScienceAppCategoryLink scienceAppCategoryLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addScienceAppCategoryLink(scienceAppCategoryLink);
	}

	/**
	* Creates a new science app category link with the primary key. Does not add the science app category link to the database.
	*
	* @param scienceAppCategoryLinkId the primary key for the new science app category link
	* @return the new science app category link
	*/
	public static com.kisti.science.platform.app.model.ScienceAppCategoryLink createScienceAppCategoryLink(
		long scienceAppCategoryLinkId) {
		return getService()
				   .createScienceAppCategoryLink(scienceAppCategoryLinkId);
	}

	/**
	* Deletes the science app category link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppCategoryLinkId the primary key of the science app category link
	* @return the science app category link that was removed
	* @throws PortalException if a science app category link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppCategoryLink deleteScienceAppCategoryLink(
		long scienceAppCategoryLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteScienceAppCategoryLink(scienceAppCategoryLinkId);
	}

	/**
	* Deletes the science app category link from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppCategoryLink the science app category link
	* @return the science app category link that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppCategoryLink deleteScienceAppCategoryLink(
		com.kisti.science.platform.app.model.ScienceAppCategoryLink scienceAppCategoryLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteScienceAppCategoryLink(scienceAppCategoryLink);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchScienceAppCategoryLink(
		long scienceAppCategoryLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchScienceAppCategoryLink(scienceAppCategoryLinkId);
	}

	/**
	* Returns the science app category link with the matching UUID and company.
	*
	* @param uuid the science app category link's UUID
	* @param companyId the primary key of the company
	* @return the matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchScienceAppCategoryLinkByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchScienceAppCategoryLinkByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the science app category link matching the UUID and group.
	*
	* @param uuid the science app category link's UUID
	* @param groupId the primary key of the group
	* @return the matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchScienceAppCategoryLinkByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchScienceAppCategoryLinkByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the science app category link with the primary key.
	*
	* @param scienceAppCategoryLinkId the primary key of the science app category link
	* @return the science app category link
	* @throws PortalException if a science app category link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppCategoryLink getScienceAppCategoryLink(
		long scienceAppCategoryLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppCategoryLink(scienceAppCategoryLinkId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the science app category link with the matching UUID and company.
	*
	* @param uuid the science app category link's UUID
	* @param companyId the primary key of the company
	* @return the matching science app category link
	* @throws PortalException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppCategoryLink getScienceAppCategoryLinkByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getScienceAppCategoryLinkByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the science app category link matching the UUID and group.
	*
	* @param uuid the science app category link's UUID
	* @param groupId the primary key of the group
	* @return the matching science app category link
	* @throws PortalException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppCategoryLink getScienceAppCategoryLinkByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getScienceAppCategoryLinkByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the science app category links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app category links
	* @param end the upper bound of the range of science app category links (not inclusive)
	* @return the range of science app category links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> getScienceAppCategoryLinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppCategoryLinks(start, end);
	}

	/**
	* Returns the number of science app category links.
	*
	* @return the number of science app category links
	* @throws SystemException if a system exception occurred
	*/
	public static int getScienceAppCategoryLinksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppCategoryLinksCount();
	}

	/**
	* Updates the science app category link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scienceAppCategoryLink the science app category link
	* @return the science app category link that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.kisti.science.platform.app.model.ScienceAppCategoryLink updateScienceAppCategoryLink(
		com.kisti.science.platform.app.model.ScienceAppCategoryLink scienceAppCategoryLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateScienceAppCategoryLink(scienceAppCategoryLink);
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

	public static com.kisti.science.platform.app.model.ScienceAppCategoryLink addScienceAppCategory(
		long categoryId, long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addScienceAppCategory(categoryId, scienceAppId);
	}

	public static void removeByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeByCategoryId(categoryId);
	}

	public static void removeByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeByScienceAppId(scienceAppId);
	}

	public static void removeAllLinks()
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeAllLinks();
	}

	public static void update(
		com.kisti.science.platform.app.model.ScienceAppCategoryLink appCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().update(appCategory);
	}

	public static long[] getScienceAppIdsByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppIdsByCategoryId(categoryId);
	}

	public static long[] getScienceAppIdsByCategoryId(long categoryId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppIdsByCategoryId(categoryId, start, end);
	}

	public static int countScienceAppsByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countScienceAppsByCategoryId(categoryId);
	}

	public static long[] getCategoryIdsByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoryIdsByScienceAppId(scienceAppId);
	}

	public static long[] getCategoryIdsByScienceAppId(long scienceAppId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCategoryIdsByScienceAppId(scienceAppId, start, end);
	}

	public static int countCategoriesByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().countCategoriesByScienceAppId(scienceAppId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ScienceAppCategoryLinkLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ScienceAppCategoryLinkLocalService.class.getName());

			if (invokableLocalService instanceof ScienceAppCategoryLinkLocalService) {
				_service = (ScienceAppCategoryLinkLocalService)invokableLocalService;
			}
			else {
				_service = new ScienceAppCategoryLinkLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ScienceAppCategoryLinkLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ScienceAppCategoryLinkLocalService service) {
	}

	private static ScienceAppCategoryLinkLocalService _service;
}