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

package org.kisti.edison.content.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import org.kisti.edison.content.model.OrgImgContent;
import org.kisti.edison.content.service.OrgImgContentLocalService;
import org.kisti.edison.content.service.persistence.AdvancedContentPersistence;
import org.kisti.edison.content.service.persistence.GeneralContentFinder;
import org.kisti.edison.content.service.persistence.GeneralContentPersistence;
import org.kisti.edison.content.service.persistence.OrgImgContentFinder;
import org.kisti.edison.content.service.persistence.OrgImgContentPK;
import org.kisti.edison.content.service.persistence.OrgImgContentPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the org img content local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.kisti.edison.content.service.impl.OrgImgContentLocalServiceImpl}.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.content.service.impl.OrgImgContentLocalServiceImpl
 * @see org.kisti.edison.content.service.OrgImgContentLocalServiceUtil
 * @generated
 */
public abstract class OrgImgContentLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements OrgImgContentLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.kisti.edison.content.service.OrgImgContentLocalServiceUtil} to access the org img content local service.
	 */

	/**
	 * Adds the org img content to the database. Also notifies the appropriate model listeners.
	 *
	 * @param orgImgContent the org img content
	 * @return the org img content that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public OrgImgContent addOrgImgContent(OrgImgContent orgImgContent)
		throws SystemException {
		orgImgContent.setNew(true);

		return orgImgContentPersistence.update(orgImgContent);
	}

	/**
	 * Creates a new org img content with the primary key. Does not add the org img content to the database.
	 *
	 * @param orgImgContentPK the primary key for the new org img content
	 * @return the new org img content
	 */
	@Override
	public OrgImgContent createOrgImgContent(OrgImgContentPK orgImgContentPK) {
		return orgImgContentPersistence.create(orgImgContentPK);
	}

	/**
	 * Deletes the org img content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orgImgContentPK the primary key of the org img content
	 * @return the org img content that was removed
	 * @throws PortalException if a org img content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public OrgImgContent deleteOrgImgContent(OrgImgContentPK orgImgContentPK)
		throws PortalException, SystemException {
		return orgImgContentPersistence.remove(orgImgContentPK);
	}

	/**
	 * Deletes the org img content from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orgImgContent the org img content
	 * @return the org img content that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public OrgImgContent deleteOrgImgContent(OrgImgContent orgImgContent)
		throws SystemException {
		return orgImgContentPersistence.remove(orgImgContent);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(OrgImgContent.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return orgImgContentPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return orgImgContentPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return orgImgContentPersistence.findWithDynamicQuery(dynamicQuery,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return orgImgContentPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return orgImgContentPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public OrgImgContent fetchOrgImgContent(OrgImgContentPK orgImgContentPK)
		throws SystemException {
		return orgImgContentPersistence.fetchByPrimaryKey(orgImgContentPK);
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
	public OrgImgContent getOrgImgContent(OrgImgContentPK orgImgContentPK)
		throws PortalException, SystemException {
		return orgImgContentPersistence.findByPrimaryKey(orgImgContentPK);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return orgImgContentPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<OrgImgContent> getOrgImgContents(int start, int end)
		throws SystemException {
		return orgImgContentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of org img contents.
	 *
	 * @return the number of org img contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getOrgImgContentsCount() throws SystemException {
		return orgImgContentPersistence.countAll();
	}

	/**
	 * Updates the org img content in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param orgImgContent the org img content
	 * @return the org img content that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public OrgImgContent updateOrgImgContent(OrgImgContent orgImgContent)
		throws SystemException {
		return orgImgContentPersistence.update(orgImgContent);
	}

	/**
	 * Returns the advanced content local service.
	 *
	 * @return the advanced content local service
	 */
	public org.kisti.edison.content.service.AdvancedContentLocalService getAdvancedContentLocalService() {
		return advancedContentLocalService;
	}

	/**
	 * Sets the advanced content local service.
	 *
	 * @param advancedContentLocalService the advanced content local service
	 */
	public void setAdvancedContentLocalService(
		org.kisti.edison.content.service.AdvancedContentLocalService advancedContentLocalService) {
		this.advancedContentLocalService = advancedContentLocalService;
	}

	/**
	 * Returns the advanced content remote service.
	 *
	 * @return the advanced content remote service
	 */
	public org.kisti.edison.content.service.AdvancedContentService getAdvancedContentService() {
		return advancedContentService;
	}

	/**
	 * Sets the advanced content remote service.
	 *
	 * @param advancedContentService the advanced content remote service
	 */
	public void setAdvancedContentService(
		org.kisti.edison.content.service.AdvancedContentService advancedContentService) {
		this.advancedContentService = advancedContentService;
	}

	/**
	 * Returns the advanced content persistence.
	 *
	 * @return the advanced content persistence
	 */
	public AdvancedContentPersistence getAdvancedContentPersistence() {
		return advancedContentPersistence;
	}

	/**
	 * Sets the advanced content persistence.
	 *
	 * @param advancedContentPersistence the advanced content persistence
	 */
	public void setAdvancedContentPersistence(
		AdvancedContentPersistence advancedContentPersistence) {
		this.advancedContentPersistence = advancedContentPersistence;
	}

	/**
	 * Returns the general content local service.
	 *
	 * @return the general content local service
	 */
	public org.kisti.edison.content.service.GeneralContentLocalService getGeneralContentLocalService() {
		return generalContentLocalService;
	}

	/**
	 * Sets the general content local service.
	 *
	 * @param generalContentLocalService the general content local service
	 */
	public void setGeneralContentLocalService(
		org.kisti.edison.content.service.GeneralContentLocalService generalContentLocalService) {
		this.generalContentLocalService = generalContentLocalService;
	}

	/**
	 * Returns the general content remote service.
	 *
	 * @return the general content remote service
	 */
	public org.kisti.edison.content.service.GeneralContentService getGeneralContentService() {
		return generalContentService;
	}

	/**
	 * Sets the general content remote service.
	 *
	 * @param generalContentService the general content remote service
	 */
	public void setGeneralContentService(
		org.kisti.edison.content.service.GeneralContentService generalContentService) {
		this.generalContentService = generalContentService;
	}

	/**
	 * Returns the general content persistence.
	 *
	 * @return the general content persistence
	 */
	public GeneralContentPersistence getGeneralContentPersistence() {
		return generalContentPersistence;
	}

	/**
	 * Sets the general content persistence.
	 *
	 * @param generalContentPersistence the general content persistence
	 */
	public void setGeneralContentPersistence(
		GeneralContentPersistence generalContentPersistence) {
		this.generalContentPersistence = generalContentPersistence;
	}

	/**
	 * Returns the general content finder.
	 *
	 * @return the general content finder
	 */
	public GeneralContentFinder getGeneralContentFinder() {
		return generalContentFinder;
	}

	/**
	 * Sets the general content finder.
	 *
	 * @param generalContentFinder the general content finder
	 */
	public void setGeneralContentFinder(
		GeneralContentFinder generalContentFinder) {
		this.generalContentFinder = generalContentFinder;
	}

	/**
	 * Returns the org img content local service.
	 *
	 * @return the org img content local service
	 */
	public org.kisti.edison.content.service.OrgImgContentLocalService getOrgImgContentLocalService() {
		return orgImgContentLocalService;
	}

	/**
	 * Sets the org img content local service.
	 *
	 * @param orgImgContentLocalService the org img content local service
	 */
	public void setOrgImgContentLocalService(
		org.kisti.edison.content.service.OrgImgContentLocalService orgImgContentLocalService) {
		this.orgImgContentLocalService = orgImgContentLocalService;
	}

	/**
	 * Returns the org img content remote service.
	 *
	 * @return the org img content remote service
	 */
	public org.kisti.edison.content.service.OrgImgContentService getOrgImgContentService() {
		return orgImgContentService;
	}

	/**
	 * Sets the org img content remote service.
	 *
	 * @param orgImgContentService the org img content remote service
	 */
	public void setOrgImgContentService(
		org.kisti.edison.content.service.OrgImgContentService orgImgContentService) {
		this.orgImgContentService = orgImgContentService;
	}

	/**
	 * Returns the org img content persistence.
	 *
	 * @return the org img content persistence
	 */
	public OrgImgContentPersistence getOrgImgContentPersistence() {
		return orgImgContentPersistence;
	}

	/**
	 * Sets the org img content persistence.
	 *
	 * @param orgImgContentPersistence the org img content persistence
	 */
	public void setOrgImgContentPersistence(
		OrgImgContentPersistence orgImgContentPersistence) {
		this.orgImgContentPersistence = orgImgContentPersistence;
	}

	/**
	 * Returns the org img content finder.
	 *
	 * @return the org img content finder
	 */
	public OrgImgContentFinder getOrgImgContentFinder() {
		return orgImgContentFinder;
	}

	/**
	 * Sets the org img content finder.
	 *
	 * @param orgImgContentFinder the org img content finder
	 */
	public void setOrgImgContentFinder(OrgImgContentFinder orgImgContentFinder) {
		this.orgImgContentFinder = orgImgContentFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("org.kisti.edison.content.model.OrgImgContent",
			orgImgContentLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"org.kisti.edison.content.model.OrgImgContent");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return OrgImgContent.class;
	}

	protected String getModelClassName() {
		return OrgImgContent.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = orgImgContentPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.kisti.edison.content.service.AdvancedContentLocalService.class)
	protected org.kisti.edison.content.service.AdvancedContentLocalService advancedContentLocalService;
	@BeanReference(type = org.kisti.edison.content.service.AdvancedContentService.class)
	protected org.kisti.edison.content.service.AdvancedContentService advancedContentService;
	@BeanReference(type = AdvancedContentPersistence.class)
	protected AdvancedContentPersistence advancedContentPersistence;
	@BeanReference(type = org.kisti.edison.content.service.GeneralContentLocalService.class)
	protected org.kisti.edison.content.service.GeneralContentLocalService generalContentLocalService;
	@BeanReference(type = org.kisti.edison.content.service.GeneralContentService.class)
	protected org.kisti.edison.content.service.GeneralContentService generalContentService;
	@BeanReference(type = GeneralContentPersistence.class)
	protected GeneralContentPersistence generalContentPersistence;
	@BeanReference(type = GeneralContentFinder.class)
	protected GeneralContentFinder generalContentFinder;
	@BeanReference(type = org.kisti.edison.content.service.OrgImgContentLocalService.class)
	protected org.kisti.edison.content.service.OrgImgContentLocalService orgImgContentLocalService;
	@BeanReference(type = org.kisti.edison.content.service.OrgImgContentService.class)
	protected org.kisti.edison.content.service.OrgImgContentService orgImgContentService;
	@BeanReference(type = OrgImgContentPersistence.class)
	protected OrgImgContentPersistence orgImgContentPersistence;
	@BeanReference(type = OrgImgContentFinder.class)
	protected OrgImgContentFinder orgImgContentFinder;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private OrgImgContentLocalServiceClpInvoker _clpInvoker = new OrgImgContentLocalServiceClpInvoker();
}