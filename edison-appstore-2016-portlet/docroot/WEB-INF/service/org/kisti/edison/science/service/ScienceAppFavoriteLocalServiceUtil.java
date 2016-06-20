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

package org.kisti.edison.science.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ScienceAppFavorite. This utility wraps
 * {@link org.kisti.edison.science.service.impl.ScienceAppFavoriteLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see ScienceAppFavoriteLocalService
 * @see org.kisti.edison.science.service.base.ScienceAppFavoriteLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.impl.ScienceAppFavoriteLocalServiceImpl
 * @generated
 */
public class ScienceAppFavoriteLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.science.service.impl.ScienceAppFavoriteLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the science app favorite to the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppFavorite the science app favorite
	* @return the science app favorite that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceAppFavorite addScienceAppFavorite(
		org.kisti.edison.science.model.ScienceAppFavorite scienceAppFavorite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addScienceAppFavorite(scienceAppFavorite);
	}

	/**
	* Creates a new science app favorite with the primary key. Does not add the science app favorite to the database.
	*
	* @param scienceAppFavoritePK the primary key for the new science app favorite
	* @return the new science app favorite
	*/
	public static org.kisti.edison.science.model.ScienceAppFavorite createScienceAppFavorite(
		org.kisti.edison.science.service.persistence.ScienceAppFavoritePK scienceAppFavoritePK) {
		return getService().createScienceAppFavorite(scienceAppFavoritePK);
	}

	/**
	* Deletes the science app favorite with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppFavoritePK the primary key of the science app favorite
	* @return the science app favorite that was removed
	* @throws PortalException if a science app favorite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceAppFavorite deleteScienceAppFavorite(
		org.kisti.edison.science.service.persistence.ScienceAppFavoritePK scienceAppFavoritePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteScienceAppFavorite(scienceAppFavoritePK);
	}

	/**
	* Deletes the science app favorite from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppFavorite the science app favorite
	* @return the science app favorite that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceAppFavorite deleteScienceAppFavorite(
		org.kisti.edison.science.model.ScienceAppFavorite scienceAppFavorite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteScienceAppFavorite(scienceAppFavorite);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppFavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppFavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.kisti.edison.science.model.ScienceAppFavorite fetchScienceAppFavorite(
		org.kisti.edison.science.service.persistence.ScienceAppFavoritePK scienceAppFavoritePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchScienceAppFavorite(scienceAppFavoritePK);
	}

	/**
	* Returns the science app favorite with the primary key.
	*
	* @param scienceAppFavoritePK the primary key of the science app favorite
	* @return the science app favorite
	* @throws PortalException if a science app favorite with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceAppFavorite getScienceAppFavorite(
		org.kisti.edison.science.service.persistence.ScienceAppFavoritePK scienceAppFavoritePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppFavorite(scienceAppFavoritePK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the science app favorites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppFavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science app favorites
	* @param end the upper bound of the range of science app favorites (not inclusive)
	* @return the range of science app favorites
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.science.model.ScienceAppFavorite> getScienceAppFavorites(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppFavorites(start, end);
	}

	/**
	* Returns the number of science app favorites.
	*
	* @return the number of science app favorites
	* @throws SystemException if a system exception occurred
	*/
	public static int getScienceAppFavoritesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppFavoritesCount();
	}

	/**
	* Updates the science app favorite in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scienceAppFavorite the science app favorite
	* @return the science app favorite that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.science.model.ScienceAppFavorite updateScienceAppFavorite(
		org.kisti.edison.science.model.ScienceAppFavorite scienceAppFavorite)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateScienceAppFavorite(scienceAppFavorite);
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

	public static int getScienceAppFavoriteCount(long scienceAppId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getScienceAppFavoriteCount(scienceAppId, userId);
	}

	public static int updateScienceAppFavorite(long userId, long scienceAppId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppFavoriteException {
		return getService()
				   .updateScienceAppFavorite(userId, scienceAppId, groupId);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getFavoriteAppList(
		long companyId, long groupId, long userId, java.util.Locale locale,
		boolean widthFile)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getFavoriteAppList(companyId, groupId, userId, locale,
			widthFile);
	}

	public static org.kisti.edison.science.model.ScienceAppFavorite deleteFavoriteApp(
		long scienceAppId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppFavoriteException {
		return getService().deleteFavoriteApp(scienceAppId, userId);
	}

	public static void deleteFavoriteApp(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFavoriteApp(scienceAppId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ScienceAppFavoriteLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ScienceAppFavoriteLocalService.class.getName());

			if (invokableLocalService instanceof ScienceAppFavoriteLocalService) {
				_service = (ScienceAppFavoriteLocalService)invokableLocalService;
			}
			else {
				_service = new ScienceAppFavoriteLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ScienceAppFavoriteLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ScienceAppFavoriteLocalService service) {
	}

	private static ScienceAppFavoriteLocalService _service;
}