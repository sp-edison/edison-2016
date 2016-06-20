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
 * Provides the local service interface for ScienceApp. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author EDISON
 * @see ScienceAppLocalServiceUtil
 * @see org.kisti.edison.science.service.base.ScienceAppLocalServiceBaseImpl
 * @see org.kisti.edison.science.service.impl.ScienceAppLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ScienceAppLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ScienceAppLocalServiceUtil} to access the science app local service. Add custom service methods to {@link org.kisti.edison.science.service.impl.ScienceAppLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the science app to the database. Also notifies the appropriate model listeners.
	*
	* @param scienceApp the science app
	* @return the science app that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.kisti.edison.science.model.ScienceApp addScienceApp(
		org.kisti.edison.science.model.ScienceApp scienceApp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new science app with the primary key. Does not add the science app to the database.
	*
	* @param scienceAppId the primary key for the new science app
	* @return the new science app
	*/
	public org.kisti.edison.science.model.ScienceApp createScienceApp(
		long scienceAppId);

	/**
	* Deletes the science app with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceAppId the primary key of the science app
	* @return the science app that was removed
	* @throws PortalException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.kisti.edison.science.model.ScienceApp deleteScienceApp(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the science app from the database. Also notifies the appropriate model listeners.
	*
	* @param scienceApp the science app
	* @return the science app that was removed
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public org.kisti.edison.science.model.ScienceApp deleteScienceApp(
		org.kisti.edison.science.model.ScienceApp scienceApp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public org.kisti.edison.science.model.ScienceApp fetchScienceApp(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app with the matching UUID and company.
	*
	* @param uuid the science app's UUID
	* @param companyId the primary key of the company
	* @return the matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.kisti.edison.science.model.ScienceApp fetchScienceAppByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app matching the UUID and group.
	*
	* @param uuid the science app's UUID
	* @param groupId the primary key of the group
	* @return the matching science app, or <code>null</code> if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.kisti.edison.science.model.ScienceApp fetchScienceAppByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app with the primary key.
	*
	* @param scienceAppId the primary key of the science app
	* @return the science app
	* @throws PortalException if a science app with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.kisti.edison.science.model.ScienceApp getScienceApp(
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app with the matching UUID and company.
	*
	* @param uuid the science app's UUID
	* @param companyId the primary key of the company
	* @return the matching science app
	* @throws PortalException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.kisti.edison.science.model.ScienceApp getScienceAppByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the science app matching the UUID and group.
	*
	* @param uuid the science app's UUID
	* @param groupId the primary key of the group
	* @return the matching science app
	* @throws PortalException if a matching science app could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.kisti.edison.science.model.ScienceApp getScienceAppByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the science apps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of science apps
	* @param end the upper bound of the range of science apps (not inclusive)
	* @return the range of science apps
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceApps(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of science apps.
	*
	* @return the number of science apps
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getScienceAppsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the science app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param scienceApp the science app
	* @return the science app that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public org.kisti.edison.science.model.ScienceApp updateScienceApp(
		org.kisti.edison.science.model.ScienceApp scienceApp)
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

	/**
	* Creates a ScienceApp instance with specified name and version.
	* The new instance created is not yet saved in the database.
	* Use addScienceApp() to save the instance.
	*
	* @param appName: ScienceApp name to be created
	* @param appVersion: ScienceApp version to be created
	* @param sc: ServiceContext instance for ScienceApp
	* @return If appName is not follows naming rules or already exists in the database, returns null.
	If appVersion is not follows versioning rules, returns null.
	Otherwise returns a ScienceApp instance with initialized data.
	
	Some attributes of the returned instance are set initial value as followings:
	-stage: ScienceAppConstants.EMPTY
	-authorId: current user id of service context instance
	-createDate: date created of service context instance
	-modifiedDate: date created of service context instance
	-userId: current user id of service context instance
	-recentModifierId: current user id of service context instance
	-groupId: scope group id of service context instance
	-companyId: company id of service context instance
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#createScienceApp(java.lang.String, java.lang.String, com.liferay.portal.service.ServiceContext)
	*/
	public org.kisti.edison.science.model.ScienceApp createScienceApp(
		java.lang.String appName, java.lang.String appVersion,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Copies ScienceApp instance to another.
	* The instance is not yet saved in the database.
	* Use addScienceApp() to save the instance.
	*
	* @param scienceAppId: original ScienceApp id to be copied
	* @param sc: service context for ScienceApp
	* @return new ScienceApp instance.
	Each attribute of the returned instance has exactly same value with original instance
	except some attributes.
	
	Some attributes of the returned instance are initialized as followings:
	-stage: ScienceAppConstants.EMPTY
	-createDate: date created of service context instance
	-modifiedDate: date created of service context instance
	-userId: current user id of service context instance
	-recentModifierId: current user id of service context instance
	-groupId: scope group id of service context instance
	-companyId: company id of service context instance
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#copyScienceApp(long, com.liferay.portal.service.ServiceContext)
	*/
	public org.kisti.edison.science.model.ScienceApp copyScienceApp(
		long scienceAppId, com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Saves the specified ScienceApp instance to database.
	*
	* @param scienceApp: ScienceApp instance to be saved.
	* @param sc: service context of the ScienceApp class
	* @return ScienceApp instance saved.
	* @throws SystemException
	* @throws PortalException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#addScienceApp(com.kisti.science.platform.model.ScienceApp, com.liferay.portal.service.ServiceContext)
	*/
	public org.kisti.edison.science.model.ScienceApp addScienceApp(
		org.kisti.edison.science.model.ScienceApp scienceApp,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void setScienceAppInputPorts(long scienceAppId,
		java.lang.String inputPorts)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getScienceAppInputPorts(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void setScienceAppOutputPorts(long scienceAppId,
		java.lang.String outputPorts)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getScienceAppOutputPorts(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Verifies ScienceApp name if the name follows specified naming rules and there is no science app
	* in the database already.
	*
	* @param appName: science app name to be tesed.
	* @return true if the name follows naming rules and brand new.
	false, Otherwise.
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#verifyScienceAppName(java.lang.String, long)
	*/
	public boolean verifyScienceAppName(java.lang.String appName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Test if there is a science app name in the database already.
	*
	* @param appName: science app name to be tesed.
	* @return true if the app name already exist in the database,
	false, otherwise
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#existAppName(java.lang.String)
	*/
	public boolean existAppName(java.lang.String appName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Test if there is an science app with the specified name and version in the database.
	*
	* @param appName: science app name to be tesed.
	* @param appVersion: science app version to be tesed.
	* @return true if a science app with the name and the version already exist in the database,
	false, otherwise.
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#existApp(java.lang.String, java.lang.String)
	*/
	public boolean existApp(java.lang.String appName,
		java.lang.String appVersion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Get the science app's latest version
	*
	* @param appName: science app name
	* @return the latest version science app instance.
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#getLatestVersion(java.lang.String)
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.kisti.edison.science.model.ScienceApp getLatestVersion(
		java.lang.String appName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Verify version number of a science app.
	* Version number of a science app should be consisted of 3 sections, {major}.{sub}.{minor}.
	* Major section number should be increased when a science app changes or added its architecture or major functions.
	* Sub section number should be increased when the science app changes functionality.
	* Minor section number should be increased when the science app fixes errors.
	* Each section must be integer and be lager than before.
	*
	* @param appName: science app name to be verified.
	* @param appVersion: science app version to be verified.
	* @return true if the version number follows naming rules and valid.
	false, Otherwise.
	* @throws SystemException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#verifyVersionNumber(java.lang.String, java.lang.String)
	*/
	public boolean verifyVersionNumber(java.lang.String appName,
		java.lang.String appVersion)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void deleteAllScienceApps()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Update a science app
	*
	* @param scienceApp: science app instance to be updated.
	* @param sc: ServiceContext instance for the ScienceApp class.
	* @return ScienceApp instance updated.
	* @throws SystemException
	* @throws PortalException
	* @see com.kisti.science.platform.service.ScienceAppLocalService#updateScienceApp(com.kisti.science.platform.model.ScienceApp, com.liferay.portal.service.ServiceContext)
	*/
	public org.kisti.edison.science.model.ScienceApp updateScienceApp(
		org.kisti.edison.science.model.ScienceApp scienceApp,
		com.liferay.portal.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByStage(
		java.lang.String stage)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByAuthorIdStatus(
		long authorId, int appStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByAuthorIdStatus(
		long authorId, int appStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByAuthorIdAppType(
		long authorId, java.lang.String appType)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByAuthorIdAppType(
		long authorId, java.lang.String appClass, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByAuthorId(
		long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByAuthorId(
		long authorId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countScienceAppsByAuthorId(long authorId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByOpenLevel(
		java.lang.String openLevel)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByOpenLevel(
		java.lang.String openLevel, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByManagerId(
		long managerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByManagerId(
		long managerId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countScienceAppsByManagerId(long managerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getScienceAppManagerIds(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getScienceAppManagerIds(long scienceAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countScienceAppManagers(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByCategoryId(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByCategoryId(
		long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public int countScienceAppsByCategoryId(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getScienceAppCategoryIds(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getScienceAppCategoryIds(long scienceAppId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int countScienceAppCategories(long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void assignScienceAppToCategories(long scienceAppId,
		long[] categoryIds)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void assignScienceAppToCategory(long scienceAppId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void assignManagersToScienceApp(long scienceAppId, long[] managerIds)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void assignManagerToScienceApp(long scienceAppId, long managerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Get path of the executable binary file.
	* The full path can be obtained by adding base directory for science apps.
	*
	* @param scienceAppId
	* @return String of the path.
	* @throws PortalException
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getScienceAppBinPath(long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Get path of the source file.
	* The full path can be obtained by adding base directory for science apps.
	*
	* @param scienceAppId
	* @return String of the path.
	* @throws PortalException
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getScienceAppSrcPath(long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all science apps in the database.
	*
	* @return int - count
	*/
	public int countAllScienceApps()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveScienceAppOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm, int start, int end);

	public int countScienceAppOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm);

	public java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveAllScienceAppOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm);

	public java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveScienceAppOnScreenName(
		java.lang.String searchTerm, int start, int end);

	public int countScienceAppOnScreenName(java.lang.String searchTerm);

	public java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveAllScienceAppOnScreenName(
		java.lang.String searchTerm);

	public java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveScienceAppOnAffiliationName(
		java.lang.String searchTerm, int start, int end);

	public int countScienceAppOnAffiliationName(java.lang.String searchTerm);

	public java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveAllScienceAppOnAffiliationName(
		java.lang.String searchTerm);

	public boolean existScienceAppPath(java.lang.String targetPath)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException;

	public void deleteScienceAppDir(java.lang.String targetDir)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException;

	public void makeScienceAppDir(java.lang.String targetDir)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException;

	/**
	* Save uploaded file to new location
	*
	* @param uploadedInputStream
	* @return
	* @throws InterruptedException
	* @throws IOException
	* @throws SystemException
	*/
	public java.io.File saveToScienceAppStorage(java.lang.String targetDir,
		java.lang.String fileName, java.io.InputStream uploadedInputStream)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException;

	/**
	* Unzip an uploaded file into a specified directory.
	*
	* @param strUnzipDirPath the directory into which unzipped files go.
	* @param zipFile zip file
	* @return process output message
	* @throws SystemException system exception
	* @throws IOException io exception
	* @throws InterruptedException interrupted exception
	*/
	public void unzipScienceAppZipFile(java.lang.String sourceFile,
		java.lang.String targetDir)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.lang.InterruptedException;

	/**
	* ADD GPLUS SERVICE
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByCategoryId(
		long categoryId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByCategoryId(
		long categoryId, java.util.Locale locale, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByScienceAppIdsAndLocale(
		long[] scienceAppIds, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getLanguageSpecificAssetCategories(
		java.util.List<com.liferay.portlet.asset.model.AssetCategory> categories,
		long parentCategoryId, java.util.Locale locale);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getScienceAppListByScienceAppIdsAndLocale(
		long[] scienceAppIds, java.util.Locale locale, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param appName
	* @param appVersion
	* @param userId
	* @param sc
	* @return
	* @throws ScienceAppException
	* @throws SystemException
	*/
	public org.kisti.edison.science.model.ScienceApp createScienceApp(
		com.liferay.portal.service.ServiceContext sc, java.util.Map params)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateScienceApp(com.liferay.portal.service.ServiceContext sc,
		java.util.Map params, long scienceAppId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.science.NoSuchScienceAppException;

	public int countScienceApp(long companyGroupId, long groupId,
		long categoryId, java.util.Locale locale,
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* 移댄뀒怨좊━���랁븯吏��딆� APP 紐⑸줉 議고쉶(EX_EDITOR)
	*
	* @param groupId
	* @param locale
	* @param searchParam
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveListScienceEditorApp(
		long companyId, java.util.Locale locale,
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* ScienceApp List 議고쉶
	*
	* @param companyGroupId
	* @param groupId
	* @param categoryId - 0��寃쎌슦 groupId瑜��듯븯���꾩껜 移댄뀒怨좊━瑜�議고쉶
	* @param locale
	* @param searchParam - 議고쉶��parameter Map
	* @param begin - �쒖옉 0 LIMIT瑜��ъ슜
	* @param end
	* @param widthFile - 紐⑸줉�먯꽌 �뚯씪���꾩슂 ��寃쎌슦 true
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveListScienceApp(
		long companyGroupId, long groupId, long categoryId,
		java.util.Locale locale,
		java.util.Map<java.lang.String, java.lang.Object> searchParam,
		int begin, int end, boolean widthFile)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.Object> getScienceAppReturnObject(
		long scienceAppId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException;

	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveListScienceAppWithOutExpando(
		long companyGroupId, long groupId, java.util.Locale locale,
		java.util.Map<java.lang.String, java.lang.Object> searchParam,
		int begin, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public org.kisti.edison.science.model.ScienceApp updateExeInfomaionScienceApp(
		com.liferay.portal.service.ServiceContext sc, java.util.Map params,
		long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getScienceAppExeSts(
		java.lang.String scienceAppId, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getMyAppListWithQna(
		java.util.Map params, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListMyAppQna(
		java.util.Map params, java.util.Locale locale);

	public void deleteScienceAppRelation(long scienceAppId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getMyAppListForProject(
		java.util.Map params, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMyAppListForProjectCount(java.util.Map params,
		java.util.Locale locale);

	public int countAppTest(long scienceAppId);

	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveListAppTest(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.kisti.edison.science.model.ScienceApp> getAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void addScienceAppFile(long companyId, java.lang.String appName,
		java.lang.String appVersion, java.lang.String fileName,
		java.io.InputStream uploadedInputStream)
		throws com.liferay.portal.kernel.exception.SystemException;
}