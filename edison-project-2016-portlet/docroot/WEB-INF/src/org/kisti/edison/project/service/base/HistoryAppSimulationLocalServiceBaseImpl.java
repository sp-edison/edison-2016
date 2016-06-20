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

package org.kisti.edison.project.service.base;

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

import org.kisti.edison.project.model.HistoryAppSimulation;
import org.kisti.edison.project.service.HistoryAppSimulationLocalService;
import org.kisti.edison.project.service.persistence.HistoryAppSimulationPK;
import org.kisti.edison.project.service.persistence.HistoryAppSimulationPersistence;
import org.kisti.edison.project.service.persistence.HistoryContentFinder;
import org.kisti.edison.project.service.persistence.HistoryContentPersistence;
import org.kisti.edison.project.service.persistence.HistoryScienceAppFinder;
import org.kisti.edison.project.service.persistence.HistoryScienceAppPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the history app simulation local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link org.kisti.edison.project.service.impl.HistoryAppSimulationLocalServiceImpl}.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.project.service.impl.HistoryAppSimulationLocalServiceImpl
 * @see org.kisti.edison.project.service.HistoryAppSimulationLocalServiceUtil
 * @generated
 */
public abstract class HistoryAppSimulationLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements HistoryAppSimulationLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link org.kisti.edison.project.service.HistoryAppSimulationLocalServiceUtil} to access the history app simulation local service.
	 */

	/**
	 * Adds the history app simulation to the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyAppSimulation the history app simulation
	 * @return the history app simulation that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public HistoryAppSimulation addHistoryAppSimulation(
		HistoryAppSimulation historyAppSimulation) throws SystemException {
		historyAppSimulation.setNew(true);

		return historyAppSimulationPersistence.update(historyAppSimulation);
	}

	/**
	 * Creates a new history app simulation with the primary key. Does not add the history app simulation to the database.
	 *
	 * @param historyAppSimulationPK the primary key for the new history app simulation
	 * @return the new history app simulation
	 */
	@Override
	public HistoryAppSimulation createHistoryAppSimulation(
		HistoryAppSimulationPK historyAppSimulationPK) {
		return historyAppSimulationPersistence.create(historyAppSimulationPK);
	}

	/**
	 * Deletes the history app simulation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyAppSimulationPK the primary key of the history app simulation
	 * @return the history app simulation that was removed
	 * @throws PortalException if a history app simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public HistoryAppSimulation deleteHistoryAppSimulation(
		HistoryAppSimulationPK historyAppSimulationPK)
		throws PortalException, SystemException {
		return historyAppSimulationPersistence.remove(historyAppSimulationPK);
	}

	/**
	 * Deletes the history app simulation from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyAppSimulation the history app simulation
	 * @return the history app simulation that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public HistoryAppSimulation deleteHistoryAppSimulation(
		HistoryAppSimulation historyAppSimulation) throws SystemException {
		return historyAppSimulationPersistence.remove(historyAppSimulation);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(HistoryAppSimulation.class,
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
		return historyAppSimulationPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.project.model.impl.HistoryAppSimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return historyAppSimulationPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.project.model.impl.HistoryAppSimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return historyAppSimulationPersistence.findWithDynamicQuery(dynamicQuery,
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
		return historyAppSimulationPersistence.countWithDynamicQuery(dynamicQuery);
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
		return historyAppSimulationPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public HistoryAppSimulation fetchHistoryAppSimulation(
		HistoryAppSimulationPK historyAppSimulationPK)
		throws SystemException {
		return historyAppSimulationPersistence.fetchByPrimaryKey(historyAppSimulationPK);
	}

	/**
	 * Returns the history app simulation with the primary key.
	 *
	 * @param historyAppSimulationPK the primary key of the history app simulation
	 * @return the history app simulation
	 * @throws PortalException if a history app simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistoryAppSimulation getHistoryAppSimulation(
		HistoryAppSimulationPK historyAppSimulationPK)
		throws PortalException, SystemException {
		return historyAppSimulationPersistence.findByPrimaryKey(historyAppSimulationPK);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return historyAppSimulationPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the history app simulations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.project.model.impl.HistoryAppSimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of history app simulations
	 * @param end the upper bound of the range of history app simulations (not inclusive)
	 * @return the range of history app simulations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistoryAppSimulation> getHistoryAppSimulations(int start,
		int end) throws SystemException {
		return historyAppSimulationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of history app simulations.
	 *
	 * @return the number of history app simulations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getHistoryAppSimulationsCount() throws SystemException {
		return historyAppSimulationPersistence.countAll();
	}

	/**
	 * Updates the history app simulation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param historyAppSimulation the history app simulation
	 * @return the history app simulation that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public HistoryAppSimulation updateHistoryAppSimulation(
		HistoryAppSimulation historyAppSimulation) throws SystemException {
		return historyAppSimulationPersistence.update(historyAppSimulation);
	}

	/**
	 * Returns the history app simulation local service.
	 *
	 * @return the history app simulation local service
	 */
	public org.kisti.edison.project.service.HistoryAppSimulationLocalService getHistoryAppSimulationLocalService() {
		return historyAppSimulationLocalService;
	}

	/**
	 * Sets the history app simulation local service.
	 *
	 * @param historyAppSimulationLocalService the history app simulation local service
	 */
	public void setHistoryAppSimulationLocalService(
		org.kisti.edison.project.service.HistoryAppSimulationLocalService historyAppSimulationLocalService) {
		this.historyAppSimulationLocalService = historyAppSimulationLocalService;
	}

	/**
	 * Returns the history app simulation remote service.
	 *
	 * @return the history app simulation remote service
	 */
	public org.kisti.edison.project.service.HistoryAppSimulationService getHistoryAppSimulationService() {
		return historyAppSimulationService;
	}

	/**
	 * Sets the history app simulation remote service.
	 *
	 * @param historyAppSimulationService the history app simulation remote service
	 */
	public void setHistoryAppSimulationService(
		org.kisti.edison.project.service.HistoryAppSimulationService historyAppSimulationService) {
		this.historyAppSimulationService = historyAppSimulationService;
	}

	/**
	 * Returns the history app simulation persistence.
	 *
	 * @return the history app simulation persistence
	 */
	public HistoryAppSimulationPersistence getHistoryAppSimulationPersistence() {
		return historyAppSimulationPersistence;
	}

	/**
	 * Sets the history app simulation persistence.
	 *
	 * @param historyAppSimulationPersistence the history app simulation persistence
	 */
	public void setHistoryAppSimulationPersistence(
		HistoryAppSimulationPersistence historyAppSimulationPersistence) {
		this.historyAppSimulationPersistence = historyAppSimulationPersistence;
	}

	/**
	 * Returns the history content local service.
	 *
	 * @return the history content local service
	 */
	public org.kisti.edison.project.service.HistoryContentLocalService getHistoryContentLocalService() {
		return historyContentLocalService;
	}

	/**
	 * Sets the history content local service.
	 *
	 * @param historyContentLocalService the history content local service
	 */
	public void setHistoryContentLocalService(
		org.kisti.edison.project.service.HistoryContentLocalService historyContentLocalService) {
		this.historyContentLocalService = historyContentLocalService;
	}

	/**
	 * Returns the history content remote service.
	 *
	 * @return the history content remote service
	 */
	public org.kisti.edison.project.service.HistoryContentService getHistoryContentService() {
		return historyContentService;
	}

	/**
	 * Sets the history content remote service.
	 *
	 * @param historyContentService the history content remote service
	 */
	public void setHistoryContentService(
		org.kisti.edison.project.service.HistoryContentService historyContentService) {
		this.historyContentService = historyContentService;
	}

	/**
	 * Returns the history content persistence.
	 *
	 * @return the history content persistence
	 */
	public HistoryContentPersistence getHistoryContentPersistence() {
		return historyContentPersistence;
	}

	/**
	 * Sets the history content persistence.
	 *
	 * @param historyContentPersistence the history content persistence
	 */
	public void setHistoryContentPersistence(
		HistoryContentPersistence historyContentPersistence) {
		this.historyContentPersistence = historyContentPersistence;
	}

	/**
	 * Returns the history content finder.
	 *
	 * @return the history content finder
	 */
	public HistoryContentFinder getHistoryContentFinder() {
		return historyContentFinder;
	}

	/**
	 * Sets the history content finder.
	 *
	 * @param historyContentFinder the history content finder
	 */
	public void setHistoryContentFinder(
		HistoryContentFinder historyContentFinder) {
		this.historyContentFinder = historyContentFinder;
	}

	/**
	 * Returns the history science app local service.
	 *
	 * @return the history science app local service
	 */
	public org.kisti.edison.project.service.HistoryScienceAppLocalService getHistoryScienceAppLocalService() {
		return historyScienceAppLocalService;
	}

	/**
	 * Sets the history science app local service.
	 *
	 * @param historyScienceAppLocalService the history science app local service
	 */
	public void setHistoryScienceAppLocalService(
		org.kisti.edison.project.service.HistoryScienceAppLocalService historyScienceAppLocalService) {
		this.historyScienceAppLocalService = historyScienceAppLocalService;
	}

	/**
	 * Returns the history science app remote service.
	 *
	 * @return the history science app remote service
	 */
	public org.kisti.edison.project.service.HistoryScienceAppService getHistoryScienceAppService() {
		return historyScienceAppService;
	}

	/**
	 * Sets the history science app remote service.
	 *
	 * @param historyScienceAppService the history science app remote service
	 */
	public void setHistoryScienceAppService(
		org.kisti.edison.project.service.HistoryScienceAppService historyScienceAppService) {
		this.historyScienceAppService = historyScienceAppService;
	}

	/**
	 * Returns the history science app persistence.
	 *
	 * @return the history science app persistence
	 */
	public HistoryScienceAppPersistence getHistoryScienceAppPersistence() {
		return historyScienceAppPersistence;
	}

	/**
	 * Sets the history science app persistence.
	 *
	 * @param historyScienceAppPersistence the history science app persistence
	 */
	public void setHistoryScienceAppPersistence(
		HistoryScienceAppPersistence historyScienceAppPersistence) {
		this.historyScienceAppPersistence = historyScienceAppPersistence;
	}

	/**
	 * Returns the history science app finder.
	 *
	 * @return the history science app finder
	 */
	public HistoryScienceAppFinder getHistoryScienceAppFinder() {
		return historyScienceAppFinder;
	}

	/**
	 * Sets the history science app finder.
	 *
	 * @param historyScienceAppFinder the history science app finder
	 */
	public void setHistoryScienceAppFinder(
		HistoryScienceAppFinder historyScienceAppFinder) {
		this.historyScienceAppFinder = historyScienceAppFinder;
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

		PersistedModelLocalServiceRegistryUtil.register("org.kisti.edison.project.model.HistoryAppSimulation",
			historyAppSimulationLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"org.kisti.edison.project.model.HistoryAppSimulation");
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
		return HistoryAppSimulation.class;
	}

	protected String getModelClassName() {
		return HistoryAppSimulation.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = historyAppSimulationPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = org.kisti.edison.project.service.HistoryAppSimulationLocalService.class)
	protected org.kisti.edison.project.service.HistoryAppSimulationLocalService historyAppSimulationLocalService;
	@BeanReference(type = org.kisti.edison.project.service.HistoryAppSimulationService.class)
	protected org.kisti.edison.project.service.HistoryAppSimulationService historyAppSimulationService;
	@BeanReference(type = HistoryAppSimulationPersistence.class)
	protected HistoryAppSimulationPersistence historyAppSimulationPersistence;
	@BeanReference(type = org.kisti.edison.project.service.HistoryContentLocalService.class)
	protected org.kisti.edison.project.service.HistoryContentLocalService historyContentLocalService;
	@BeanReference(type = org.kisti.edison.project.service.HistoryContentService.class)
	protected org.kisti.edison.project.service.HistoryContentService historyContentService;
	@BeanReference(type = HistoryContentPersistence.class)
	protected HistoryContentPersistence historyContentPersistence;
	@BeanReference(type = HistoryContentFinder.class)
	protected HistoryContentFinder historyContentFinder;
	@BeanReference(type = org.kisti.edison.project.service.HistoryScienceAppLocalService.class)
	protected org.kisti.edison.project.service.HistoryScienceAppLocalService historyScienceAppLocalService;
	@BeanReference(type = org.kisti.edison.project.service.HistoryScienceAppService.class)
	protected org.kisti.edison.project.service.HistoryScienceAppService historyScienceAppService;
	@BeanReference(type = HistoryScienceAppPersistence.class)
	protected HistoryScienceAppPersistence historyScienceAppPersistence;
	@BeanReference(type = HistoryScienceAppFinder.class)
	protected HistoryScienceAppFinder historyScienceAppFinder;
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
	private HistoryAppSimulationLocalServiceClpInvoker _clpInvoker = new HistoryAppSimulationLocalServiceClpInvoker();
}