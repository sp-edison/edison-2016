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

package org.kisti.edison.project.service.persistence;

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

import org.kisti.edison.project.NoSuchHistoryAppSimulationException;
import org.kisti.edison.project.model.HistoryAppSimulation;
import org.kisti.edison.project.model.impl.HistoryAppSimulationImpl;
import org.kisti.edison.project.model.impl.HistoryAppSimulationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the history app simulation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see HistoryAppSimulationPersistence
 * @see HistoryAppSimulationUtil
 * @generated
 */
public class HistoryAppSimulationPersistenceImpl extends BasePersistenceImpl<HistoryAppSimulation>
	implements HistoryAppSimulationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HistoryAppSimulationUtil} to access the history app simulation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HistoryAppSimulationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HistoryAppSimulationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryAppSimulationModelImpl.FINDER_CACHE_ENABLED,
			HistoryAppSimulationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HistoryAppSimulationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryAppSimulationModelImpl.FINDER_CACHE_ENABLED,
			HistoryAppSimulationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HistoryAppSimulationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryAppSimulationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public HistoryAppSimulationPersistenceImpl() {
		setModelClass(HistoryAppSimulation.class);
	}

	/**
	 * Caches the history app simulation in the entity cache if it is enabled.
	 *
	 * @param historyAppSimulation the history app simulation
	 */
	@Override
	public void cacheResult(HistoryAppSimulation historyAppSimulation) {
		EntityCacheUtil.putResult(HistoryAppSimulationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryAppSimulationImpl.class,
			historyAppSimulation.getPrimaryKey(), historyAppSimulation);

		historyAppSimulation.resetOriginalValues();
	}

	/**
	 * Caches the history app simulations in the entity cache if it is enabled.
	 *
	 * @param historyAppSimulations the history app simulations
	 */
	@Override
	public void cacheResult(List<HistoryAppSimulation> historyAppSimulations) {
		for (HistoryAppSimulation historyAppSimulation : historyAppSimulations) {
			if (EntityCacheUtil.getResult(
						HistoryAppSimulationModelImpl.ENTITY_CACHE_ENABLED,
						HistoryAppSimulationImpl.class,
						historyAppSimulation.getPrimaryKey()) == null) {
				cacheResult(historyAppSimulation);
			}
			else {
				historyAppSimulation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all history app simulations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HistoryAppSimulationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HistoryAppSimulationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the history app simulation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HistoryAppSimulation historyAppSimulation) {
		EntityCacheUtil.removeResult(HistoryAppSimulationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryAppSimulationImpl.class, historyAppSimulation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HistoryAppSimulation> historyAppSimulations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HistoryAppSimulation historyAppSimulation : historyAppSimulations) {
			EntityCacheUtil.removeResult(HistoryAppSimulationModelImpl.ENTITY_CACHE_ENABLED,
				HistoryAppSimulationImpl.class,
				historyAppSimulation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new history app simulation with the primary key. Does not add the history app simulation to the database.
	 *
	 * @param historyAppSimulationPK the primary key for the new history app simulation
	 * @return the new history app simulation
	 */
	@Override
	public HistoryAppSimulation create(
		HistoryAppSimulationPK historyAppSimulationPK) {
		HistoryAppSimulation historyAppSimulation = new HistoryAppSimulationImpl();

		historyAppSimulation.setNew(true);
		historyAppSimulation.setPrimaryKey(historyAppSimulationPK);

		return historyAppSimulation;
	}

	/**
	 * Removes the history app simulation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyAppSimulationPK the primary key of the history app simulation
	 * @return the history app simulation that was removed
	 * @throws org.kisti.edison.project.NoSuchHistoryAppSimulationException if a history app simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistoryAppSimulation remove(
		HistoryAppSimulationPK historyAppSimulationPK)
		throws NoSuchHistoryAppSimulationException, SystemException {
		return remove((Serializable)historyAppSimulationPK);
	}

	/**
	 * Removes the history app simulation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the history app simulation
	 * @return the history app simulation that was removed
	 * @throws org.kisti.edison.project.NoSuchHistoryAppSimulationException if a history app simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistoryAppSimulation remove(Serializable primaryKey)
		throws NoSuchHistoryAppSimulationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HistoryAppSimulation historyAppSimulation = (HistoryAppSimulation)session.get(HistoryAppSimulationImpl.class,
					primaryKey);

			if (historyAppSimulation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHistoryAppSimulationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(historyAppSimulation);
		}
		catch (NoSuchHistoryAppSimulationException nsee) {
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
	protected HistoryAppSimulation removeImpl(
		HistoryAppSimulation historyAppSimulation) throws SystemException {
		historyAppSimulation = toUnwrappedModel(historyAppSimulation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(historyAppSimulation)) {
				historyAppSimulation = (HistoryAppSimulation)session.get(HistoryAppSimulationImpl.class,
						historyAppSimulation.getPrimaryKeyObj());
			}

			if (historyAppSimulation != null) {
				session.delete(historyAppSimulation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (historyAppSimulation != null) {
			clearCache(historyAppSimulation);
		}

		return historyAppSimulation;
	}

	@Override
	public HistoryAppSimulation updateImpl(
		org.kisti.edison.project.model.HistoryAppSimulation historyAppSimulation)
		throws SystemException {
		historyAppSimulation = toUnwrappedModel(historyAppSimulation);

		boolean isNew = historyAppSimulation.isNew();

		Session session = null;

		try {
			session = openSession();

			if (historyAppSimulation.isNew()) {
				session.save(historyAppSimulation);

				historyAppSimulation.setNew(false);
			}
			else {
				session.merge(historyAppSimulation);
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

		EntityCacheUtil.putResult(HistoryAppSimulationModelImpl.ENTITY_CACHE_ENABLED,
			HistoryAppSimulationImpl.class,
			historyAppSimulation.getPrimaryKey(), historyAppSimulation);

		return historyAppSimulation;
	}

	protected HistoryAppSimulation toUnwrappedModel(
		HistoryAppSimulation historyAppSimulation) {
		if (historyAppSimulation instanceof HistoryAppSimulationImpl) {
			return historyAppSimulation;
		}

		HistoryAppSimulationImpl historyAppSimulationImpl = new HistoryAppSimulationImpl();

		historyAppSimulationImpl.setNew(historyAppSimulation.isNew());
		historyAppSimulationImpl.setPrimaryKey(historyAppSimulation.getPrimaryKey());

		historyAppSimulationImpl.setScienceAppId(historyAppSimulation.getScienceAppId());
		historyAppSimulationImpl.setGroupId(historyAppSimulation.getGroupId());
		historyAppSimulationImpl.setProjectCategoryId(historyAppSimulation.getProjectCategoryId());
		historyAppSimulationImpl.setTitle(historyAppSimulation.getTitle());
		historyAppSimulationImpl.setVersion(historyAppSimulation.getVersion());
		historyAppSimulationImpl.setName(historyAppSimulation.getName());
		historyAppSimulationImpl.setAffiliation_id(historyAppSimulation.getAffiliation_id());
		historyAppSimulationImpl.setAppStatus(historyAppSimulation.getAppStatus());
		historyAppSimulationImpl.setUserId(historyAppSimulation.getUserId());
		historyAppSimulationImpl.setRuntime(historyAppSimulation.getRuntime());
		historyAppSimulationImpl.setExecuteCount(historyAppSimulation.getExecuteCount());
		historyAppSimulationImpl.setAverageRuntime(historyAppSimulation.getAverageRuntime());
		historyAppSimulationImpl.setUserCount(historyAppSimulation.getUserCount());
		historyAppSimulationImpl.setInsertDate(historyAppSimulation.getInsertDate());

		return historyAppSimulationImpl;
	}

	/**
	 * Returns the history app simulation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the history app simulation
	 * @return the history app simulation
	 * @throws org.kisti.edison.project.NoSuchHistoryAppSimulationException if a history app simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistoryAppSimulation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHistoryAppSimulationException, SystemException {
		HistoryAppSimulation historyAppSimulation = fetchByPrimaryKey(primaryKey);

		if (historyAppSimulation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHistoryAppSimulationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return historyAppSimulation;
	}

	/**
	 * Returns the history app simulation with the primary key or throws a {@link org.kisti.edison.project.NoSuchHistoryAppSimulationException} if it could not be found.
	 *
	 * @param historyAppSimulationPK the primary key of the history app simulation
	 * @return the history app simulation
	 * @throws org.kisti.edison.project.NoSuchHistoryAppSimulationException if a history app simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistoryAppSimulation findByPrimaryKey(
		HistoryAppSimulationPK historyAppSimulationPK)
		throws NoSuchHistoryAppSimulationException, SystemException {
		return findByPrimaryKey((Serializable)historyAppSimulationPK);
	}

	/**
	 * Returns the history app simulation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the history app simulation
	 * @return the history app simulation, or <code>null</code> if a history app simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistoryAppSimulation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		HistoryAppSimulation historyAppSimulation = (HistoryAppSimulation)EntityCacheUtil.getResult(HistoryAppSimulationModelImpl.ENTITY_CACHE_ENABLED,
				HistoryAppSimulationImpl.class, primaryKey);

		if (historyAppSimulation == _nullHistoryAppSimulation) {
			return null;
		}

		if (historyAppSimulation == null) {
			Session session = null;

			try {
				session = openSession();

				historyAppSimulation = (HistoryAppSimulation)session.get(HistoryAppSimulationImpl.class,
						primaryKey);

				if (historyAppSimulation != null) {
					cacheResult(historyAppSimulation);
				}
				else {
					EntityCacheUtil.putResult(HistoryAppSimulationModelImpl.ENTITY_CACHE_ENABLED,
						HistoryAppSimulationImpl.class, primaryKey,
						_nullHistoryAppSimulation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(HistoryAppSimulationModelImpl.ENTITY_CACHE_ENABLED,
					HistoryAppSimulationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return historyAppSimulation;
	}

	/**
	 * Returns the history app simulation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param historyAppSimulationPK the primary key of the history app simulation
	 * @return the history app simulation, or <code>null</code> if a history app simulation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistoryAppSimulation fetchByPrimaryKey(
		HistoryAppSimulationPK historyAppSimulationPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)historyAppSimulationPK);
	}

	/**
	 * Returns all the history app simulations.
	 *
	 * @return the history app simulations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistoryAppSimulation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<HistoryAppSimulation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the history app simulations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.project.model.impl.HistoryAppSimulationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of history app simulations
	 * @param end the upper bound of the range of history app simulations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of history app simulations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistoryAppSimulation> findAll(int start, int end,
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

		List<HistoryAppSimulation> list = (List<HistoryAppSimulation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HISTORYAPPSIMULATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HISTORYAPPSIMULATION;

				if (pagination) {
					sql = sql.concat(HistoryAppSimulationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<HistoryAppSimulation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<HistoryAppSimulation>(list);
				}
				else {
					list = (List<HistoryAppSimulation>)QueryUtil.list(q,
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
	 * Removes all the history app simulations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (HistoryAppSimulation historyAppSimulation : findAll()) {
			remove(historyAppSimulation);
		}
	}

	/**
	 * Returns the number of history app simulations.
	 *
	 * @return the number of history app simulations
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

				Query q = session.createQuery(_SQL_COUNT_HISTORYAPPSIMULATION);

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
	 * Initializes the history app simulation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.project.model.HistoryAppSimulation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HistoryAppSimulation>> listenersList = new ArrayList<ModelListener<HistoryAppSimulation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HistoryAppSimulation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HistoryAppSimulationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_HISTORYAPPSIMULATION = "SELECT historyAppSimulation FROM HistoryAppSimulation historyAppSimulation";
	private static final String _SQL_COUNT_HISTORYAPPSIMULATION = "SELECT COUNT(historyAppSimulation) FROM HistoryAppSimulation historyAppSimulation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "historyAppSimulation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HistoryAppSimulation exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HistoryAppSimulationPersistenceImpl.class);
	private static HistoryAppSimulation _nullHistoryAppSimulation = new HistoryAppSimulationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HistoryAppSimulation> toCacheModel() {
				return _nullHistoryAppSimulationCacheModel;
			}
		};

	private static CacheModel<HistoryAppSimulation> _nullHistoryAppSimulationCacheModel =
		new CacheModel<HistoryAppSimulation>() {
			@Override
			public HistoryAppSimulation toEntityModel() {
				return _nullHistoryAppSimulation;
			}
		};
}