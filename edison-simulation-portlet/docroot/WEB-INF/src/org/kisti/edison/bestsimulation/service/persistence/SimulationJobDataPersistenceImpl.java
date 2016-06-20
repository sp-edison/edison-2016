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

package org.kisti.edison.bestsimulation.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.kisti.edison.bestsimulation.NoSuchSimulationJobDataException;
import org.kisti.edison.bestsimulation.model.SimulationJobData;
import org.kisti.edison.bestsimulation.model.impl.SimulationJobDataImpl;
import org.kisti.edison.bestsimulation.model.impl.SimulationJobDataModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the simulation job data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see SimulationJobDataPersistence
 * @see SimulationJobDataUtil
 * @generated
 */
public class SimulationJobDataPersistenceImpl extends BasePersistenceImpl<SimulationJobData>
	implements SimulationJobDataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SimulationJobDataUtil} to access the simulation job data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SimulationJobDataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SimulationJobDataModelImpl.ENTITY_CACHE_ENABLED,
			SimulationJobDataModelImpl.FINDER_CACHE_ENABLED,
			SimulationJobDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SimulationJobDataModelImpl.ENTITY_CACHE_ENABLED,
			SimulationJobDataModelImpl.FINDER_CACHE_ENABLED,
			SimulationJobDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SimulationJobDataModelImpl.ENTITY_CACHE_ENABLED,
			SimulationJobDataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SimulationJobDataPersistenceImpl() {
		setModelClass(SimulationJobData.class);
	}

	/**
	 * Caches the simulation job data in the entity cache if it is enabled.
	 *
	 * @param simulationJobData the simulation job data
	 */
	@Override
	public void cacheResult(SimulationJobData simulationJobData) {
		EntityCacheUtil.putResult(SimulationJobDataModelImpl.ENTITY_CACHE_ENABLED,
			SimulationJobDataImpl.class, simulationJobData.getPrimaryKey(),
			simulationJobData);

		simulationJobData.resetOriginalValues();
	}

	/**
	 * Caches the simulation job datas in the entity cache if it is enabled.
	 *
	 * @param simulationJobDatas the simulation job datas
	 */
	@Override
	public void cacheResult(List<SimulationJobData> simulationJobDatas) {
		for (SimulationJobData simulationJobData : simulationJobDatas) {
			if (EntityCacheUtil.getResult(
						SimulationJobDataModelImpl.ENTITY_CACHE_ENABLED,
						SimulationJobDataImpl.class,
						simulationJobData.getPrimaryKey()) == null) {
				cacheResult(simulationJobData);
			}
			else {
				simulationJobData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all simulation job datas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SimulationJobDataImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SimulationJobDataImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the simulation job data.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SimulationJobData simulationJobData) {
		EntityCacheUtil.removeResult(SimulationJobDataModelImpl.ENTITY_CACHE_ENABLED,
			SimulationJobDataImpl.class, simulationJobData.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SimulationJobData> simulationJobDatas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SimulationJobData simulationJobData : simulationJobDatas) {
			EntityCacheUtil.removeResult(SimulationJobDataModelImpl.ENTITY_CACHE_ENABLED,
				SimulationJobDataImpl.class, simulationJobData.getPrimaryKey());
		}
	}

	/**
	 * Creates a new simulation job data with the primary key. Does not add the simulation job data to the database.
	 *
	 * @param jobUuid the primary key for the new simulation job data
	 * @return the new simulation job data
	 */
	@Override
	public SimulationJobData create(String jobUuid) {
		SimulationJobData simulationJobData = new SimulationJobDataImpl();

		simulationJobData.setNew(true);
		simulationJobData.setPrimaryKey(jobUuid);

		return simulationJobData;
	}

	/**
	 * Removes the simulation job data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobUuid the primary key of the simulation job data
	 * @return the simulation job data that was removed
	 * @throws org.kisti.edison.bestsimulation.NoSuchSimulationJobDataException if a simulation job data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SimulationJobData remove(String jobUuid)
		throws NoSuchSimulationJobDataException, SystemException {
		return remove((Serializable)jobUuid);
	}

	/**
	 * Removes the simulation job data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the simulation job data
	 * @return the simulation job data that was removed
	 * @throws org.kisti.edison.bestsimulation.NoSuchSimulationJobDataException if a simulation job data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SimulationJobData remove(Serializable primaryKey)
		throws NoSuchSimulationJobDataException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SimulationJobData simulationJobData = (SimulationJobData)session.get(SimulationJobDataImpl.class,
					primaryKey);

			if (simulationJobData == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSimulationJobDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(simulationJobData);
		}
		catch (NoSuchSimulationJobDataException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SimulationJobData removeImpl(SimulationJobData simulationJobData)
		throws SystemException {
		simulationJobData = toUnwrappedModel(simulationJobData);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(simulationJobData)) {
				simulationJobData = (SimulationJobData)session.get(SimulationJobDataImpl.class,
						simulationJobData.getPrimaryKeyObj());
			}

			if (simulationJobData != null) {
				session.delete(simulationJobData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (simulationJobData != null) {
			clearCache(simulationJobData);
		}

		return simulationJobData;
	}

	@Override
	public SimulationJobData updateImpl(
		org.kisti.edison.bestsimulation.model.SimulationJobData simulationJobData)
		throws SystemException {
		simulationJobData = toUnwrappedModel(simulationJobData);

		boolean isNew = simulationJobData.isNew();

		Session session = null;

		try {
			session = openSession();

			if (simulationJobData.isNew()) {
				session.save(simulationJobData);

				simulationJobData.setNew(false);
			}
			else {
				session.merge(simulationJobData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SimulationJobDataModelImpl.ENTITY_CACHE_ENABLED,
			SimulationJobDataImpl.class, simulationJobData.getPrimaryKey(),
			simulationJobData);

		return simulationJobData;
	}

	protected SimulationJobData toUnwrappedModel(
		SimulationJobData simulationJobData) {
		if (simulationJobData instanceof SimulationJobDataImpl) {
			return simulationJobData;
		}

		SimulationJobDataImpl simulationJobDataImpl = new SimulationJobDataImpl();

		simulationJobDataImpl.setNew(simulationJobData.isNew());
		simulationJobDataImpl.setPrimaryKey(simulationJobData.getPrimaryKey());

		simulationJobDataImpl.setJobUuid(simulationJobData.getJobUuid());
		simulationJobDataImpl.setJobData(simulationJobData.getJobData());

		return simulationJobDataImpl;
	}

	/**
	 * Returns the simulation job data with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the simulation job data
	 * @return the simulation job data
	 * @throws org.kisti.edison.bestsimulation.NoSuchSimulationJobDataException if a simulation job data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SimulationJobData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSimulationJobDataException, SystemException {
		SimulationJobData simulationJobData = fetchByPrimaryKey(primaryKey);

		if (simulationJobData == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSimulationJobDataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return simulationJobData;
	}

	/**
	 * Returns the simulation job data with the primary key or throws a {@link org.kisti.edison.bestsimulation.NoSuchSimulationJobDataException} if it could not be found.
	 *
	 * @param jobUuid the primary key of the simulation job data
	 * @return the simulation job data
	 * @throws org.kisti.edison.bestsimulation.NoSuchSimulationJobDataException if a simulation job data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SimulationJobData findByPrimaryKey(String jobUuid)
		throws NoSuchSimulationJobDataException, SystemException {
		return findByPrimaryKey((Serializable)jobUuid);
	}

	/**
	 * Returns the simulation job data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the simulation job data
	 * @return the simulation job data, or <code>null</code> if a simulation job data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SimulationJobData fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SimulationJobData simulationJobData = (SimulationJobData)EntityCacheUtil.getResult(SimulationJobDataModelImpl.ENTITY_CACHE_ENABLED,
				SimulationJobDataImpl.class, primaryKey);

		if (simulationJobData == _nullSimulationJobData) {
			return null;
		}

		if (simulationJobData == null) {
			Session session = null;

			try {
				session = openSession();

				simulationJobData = (SimulationJobData)session.get(SimulationJobDataImpl.class,
						primaryKey);

				if (simulationJobData != null) {
					cacheResult(simulationJobData);
				}
				else {
					EntityCacheUtil.putResult(SimulationJobDataModelImpl.ENTITY_CACHE_ENABLED,
						SimulationJobDataImpl.class, primaryKey,
						_nullSimulationJobData);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SimulationJobDataModelImpl.ENTITY_CACHE_ENABLED,
					SimulationJobDataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return simulationJobData;
	}

	/**
	 * Returns the simulation job data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobUuid the primary key of the simulation job data
	 * @return the simulation job data, or <code>null</code> if a simulation job data with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SimulationJobData fetchByPrimaryKey(String jobUuid)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)jobUuid);
	}

	/**
	 * Returns all the simulation job datas.
	 *
	 * @return the simulation job datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SimulationJobData> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the simulation job datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of simulation job datas
	 * @param end the upper bound of the range of simulation job datas (not inclusive)
	 * @return the range of simulation job datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SimulationJobData> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the simulation job datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.bestsimulation.model.impl.SimulationJobDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of simulation job datas
	 * @param end the upper bound of the range of simulation job datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of simulation job datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SimulationJobData> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SimulationJobData> list = (List<SimulationJobData>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SIMULATIONJOBDATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SIMULATIONJOBDATA;

				if (pagination) {
					sql = sql.concat(SimulationJobDataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SimulationJobData>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SimulationJobData>(list);
				}
				else {
					list = (List<SimulationJobData>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the simulation job datas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SimulationJobData simulationJobData : findAll()) {
			remove(simulationJobData);
		}
	}

	/**
	 * Returns the number of simulation job datas.
	 *
	 * @return the number of simulation job datas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SIMULATIONJOBDATA);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the simulation job data persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.bestsimulation.model.SimulationJobData")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SimulationJobData>> listenersList = new ArrayList<ModelListener<SimulationJobData>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SimulationJobData>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SimulationJobDataImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SIMULATIONJOBDATA = "SELECT simulationJobData FROM SimulationJobData simulationJobData";
	private static final String _SQL_COUNT_SIMULATIONJOBDATA = "SELECT COUNT(simulationJobData) FROM SimulationJobData simulationJobData";
	private static final String _ORDER_BY_ENTITY_ALIAS = "simulationJobData.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SimulationJobData exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SimulationJobDataPersistenceImpl.class);
	private static SimulationJobData _nullSimulationJobData = new SimulationJobDataImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SimulationJobData> toCacheModel() {
				return _nullSimulationJobDataCacheModel;
			}
		};

	private static CacheModel<SimulationJobData> _nullSimulationJobDataCacheModel =
		new CacheModel<SimulationJobData>() {
			@Override
			public SimulationJobData toEntityModel() {
				return _nullSimulationJobData;
			}
		};
}