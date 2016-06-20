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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for ScienceAppCategoryLink. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppCategoryLinkLocalServiceUtil
 * @see com.kisti.science.platform.app.service.base.ScienceAppCategoryLinkLocalServiceBaseImpl
 * @see com.kisti.science.platform.app.service.impl.ScienceAppCategoryLinkLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ScienceAppCategoryLinkLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScienceAppCategoryLinkLocalServiceUtil} to access the science app category link local service. Add custom service methods to {@link com.kisti.science.platform.app.service.impl.ScienceAppCategoryLinkLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the science app category link to the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppCategoryLink the science app category link
	* @return the science app category link that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink addScienceAppCategoryLink(
		com.kisti.science.platform.app.model.ScienceAppCategoryLink scienceAppCategoryLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new science app category link with the primary key. Does not add the science app category link to the database.
	*
	* @param scienceAppCategoryLinkId the primary key for the new science app category link
	* @return the new science app category link
	*/
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink createScienceAppCategoryLink(
		long scienceAppCategoryLinkId);

	/**
	* Deletes the science app category link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppCategoryLinkId the primary key of the science app category link
	* @return the science app category link that was removed
	* @throws PortalException if a science app category link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink deleteScienceAppCategoryLink(
		long scienceAppCategoryLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the science app category link from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppCategoryLink the science app category link
	* @return the science app category link that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink deleteScienceAppCategoryLink(
		com.kisti.science.platform.app.model.ScienceAppCategoryLink scienceAppCategoryLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchScienceAppCategoryLink(
		long scienceAppCategoryLinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category link with the matching UUID and company.
	*
	* @param uuid the science app category link's UUID
	* @param companyId the primary key of the company
	* @return the matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchScienceAppCategoryLinkByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category link matching the UUID and group.
	*
	* @param uuid the science app category link's UUID
	* @param groupId the primary key of the group
	* @return the matching science app category link, or <code>null</code> if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink fetchScienceAppCategoryLinkByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category link with the primary key.
	*
	* @param scienceAppCategoryLinkId the primary key of the science app category link
	* @return the science app category link
	* @throws PortalException if a science app category link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink getScienceAppCategoryLink(
		long scienceAppCategoryLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category link with the matching UUID and company.
	*
	* @param uuid the science app category link's UUID
	* @param companyId the primary key of the company
	* @return the matching science app category link
	* @throws PortalException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink getScienceAppCategoryLinkByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app category link matching the UUID and group.
	*
	* @param uuid the science app category link's UUID
	* @param groupId the primary key of the group
	* @return the matching science app category link
	* @throws PortalException if a matching science app category link could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink getScienceAppCategoryLinkByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.kisti.science.platform.app.model.ScienceAppCategoryLink> getScienceAppCategoryLinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science app category links.
	*
	* @return the number of science app category links
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getScienceAppCategoryLinksCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the science app category link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scienceAppCategoryLink the science app category link
	* @return the science app category link that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.kisti.science.platform.app.model.ScienceAppCategoryLink updateScienceAppCategoryLink(
		com.kisti.science.platform.app.model.ScienceAppCategoryLink scienceAppCategoryLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.kisti.science.platform.app.model.ScienceAppCategoryLink addScienceAppCategory(
		long categoryId, long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void removeByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void removeByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void removeAllLinks()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void update(
		com.kisti.science.platform.app.model.ScienceAppCategoryLink appCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getScienceAppIdsByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getScienceAppIdsByCategoryId(long categoryId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public int countScienceAppsByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getCategoryIdsByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getCategoryIdsByScienceAppId(long scienceAppId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public int countCategoriesByScienceAppId(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;
}