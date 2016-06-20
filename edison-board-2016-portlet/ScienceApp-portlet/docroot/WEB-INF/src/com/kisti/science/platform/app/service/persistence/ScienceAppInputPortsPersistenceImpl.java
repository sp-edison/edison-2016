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

package com.kisti.science.platform.app.service.persistence;

import com.kisti.science.platform.app.NoSuchInputPortsException;
import com.kisti.science.platform.app.model.ScienceAppInputPorts;
import com.kisti.science.platform.app.model.impl.ScienceAppInputPortsImpl;
import com.kisti.science.platform.app.model.impl.ScienceAppInputPortsModelImpl;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the science app input ports service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppInputPortsPersistence
 * @see ScienceAppInputPortsUtil
 * @generated
 */
public class ScienceAppInputPortsPersistenceImpl extends BasePersistenceImpl<ScienceAppInputPorts>
	implements ScienceAppInputPortsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScienceAppInputPortsUtil} to access the science app input ports persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScienceAppInputPortsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScienceAppInputPortsModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppInputPortsModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppInputPortsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScienceAppInputPortsModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppInputPortsModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppInputPortsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScienceAppInputPortsModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppInputPortsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ScienceAppInputPortsPersistenceImpl() {
		setModelClass(ScienceAppInputPorts.class);
	}

	/**
	 * Caches the science app input ports in the entity cache if it is enabled.
	 *
	 * @param scienceAppInputPorts the science app input ports
	 */
	@Override
	public void cacheResult(ScienceAppInputPorts scienceAppInputPorts) {
		EntityCacheUtil.putResult(ScienceAppInputPortsModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppInputPortsImpl.class,
			scienceAppInputPorts.getPrimaryKey(), scienceAppInputPorts);

		scienceAppInputPorts.resetOriginalValues();
	}

	/**
	 * Caches the science app input portses in the entity cache if it is enabled.
	 *
	 * @param scienceAppInputPortses the science app input portses
	 */
	@Override
	public void cacheResult(List<ScienceAppInputPorts> scienceAppInputPortses) {
		for (ScienceAppInputPorts scienceAppInputPorts : scienceAppInputPortses) {
			if (EntityCacheUtil.getResult(
						ScienceAppInputPortsModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppInputPortsImpl.class,
						scienceAppInputPorts.getPrimaryKey()) == null) {
				cacheResult(scienceAppInputPorts);
			}
			else {
				scienceAppInputPorts.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all science app input portses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ScienceAppInputPortsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ScienceAppInputPortsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the science app input ports.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScienceAppInputPorts scienceAppInputPorts) {
		EntityCacheUtil.removeResult(ScienceAppInputPortsModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppInputPortsImpl.class, scienceAppInputPorts.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ScienceAppInputPorts> scienceAppInputPortses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ScienceAppInputPorts scienceAppInputPorts : scienceAppInputPortses) {
			EntityCacheUtil.removeResult(ScienceAppInputPortsModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppInputPortsImpl.class,
				scienceAppInputPorts.getPrimaryKey());
		}
	}

	/**
	 * Creates a new science app input ports with the primary key. Does not add the science app input ports to the database.
	 *
	 * @param scienceAppId the primary key for the new science app input ports
	 * @return the new science app input ports
	 */
	@Override
	public ScienceAppInputPorts create(long scienceAppId) {
		ScienceAppInputPorts scienceAppInputPorts = new ScienceAppInputPortsImpl();

		scienceAppInputPorts.setNew(true);
		scienceAppInputPorts.setPrimaryKey(scienceAppId);

		return scienceAppInputPorts;
	}

	/**
	 * Removes the science app input ports with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scienceAppId the primary key of the science app input ports
	 * @return the science app input ports that was removed
	 * @throws com.kisti.science.platform.app.NoSuchInputPortsException if a science app input ports with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppInputPorts remove(long scienceAppId)
		throws NoSuchInputPortsException, SystemException {
		return remove((Serializable)scienceAppId);
	}

	/**
	 * Removes the science app input ports with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the science app input ports
	 * @return the science app input ports that was removed
	 * @throws com.kisti.science.platform.app.NoSuchInputPortsException if a science app input ports with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppInputPorts remove(Serializable primaryKey)
		throws NoSuchInputPortsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ScienceAppInputPorts scienceAppInputPorts = (ScienceAppInputPorts)session.get(ScienceAppInputPortsImpl.class,
					primaryKey);

			if (scienceAppInputPorts == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInputPortsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scienceAppInputPorts);
		}
		catch (NoSuchInputPortsException nsee) {
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
	protected ScienceAppInputPorts removeImpl(
		ScienceAppInputPorts scienceAppInputPorts) throws SystemException {
		scienceAppInputPorts = toUnwrappedModel(scienceAppInputPorts);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scienceAppInputPorts)) {
				scienceAppInputPorts = (ScienceAppInputPorts)session.get(ScienceAppInputPortsImpl.class,
						scienceAppInputPorts.getPrimaryKeyObj());
			}

			if (scienceAppInputPorts != null) {
				session.delete(scienceAppInputPorts);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scienceAppInputPorts != null) {
			clearCache(scienceAppInputPorts);
		}

		return scienceAppInputPorts;
	}

	@Override
	public ScienceAppInputPorts updateImpl(
		com.kisti.science.platform.app.model.ScienceAppInputPorts scienceAppInputPorts)
		throws SystemException {
		scienceAppInputPorts = toUnwrappedModel(scienceAppInputPorts);

		boolean isNew = scienceAppInputPorts.isNew();

		Session session = null;

		try {
			session = openSession();

			if (scienceAppInputPorts.isNew()) {
				session.save(scienceAppInputPorts);

				scienceAppInputPorts.setNew(false);
			}
			else {
				session.merge(scienceAppInputPorts);
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

		EntityCacheUtil.putResult(ScienceAppInputPortsModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppInputPortsImpl.class,
			scienceAppInputPorts.getPrimaryKey(), scienceAppInputPorts);

		return scienceAppInputPorts;
	}

	protected ScienceAppInputPorts toUnwrappedModel(
		ScienceAppInputPorts scienceAppInputPorts) {
		if (scienceAppInputPorts instanceof ScienceAppInputPortsImpl) {
			return scienceAppInputPorts;
		}

		ScienceAppInputPortsImpl scienceAppInputPortsImpl = new ScienceAppInputPortsImpl();

		scienceAppInputPortsImpl.setNew(scienceAppInputPorts.isNew());
		scienceAppInputPortsImpl.setPrimaryKey(scienceAppInputPorts.getPrimaryKey());

		scienceAppInputPortsImpl.setScienceAppId(scienceAppInputPorts.getScienceAppId());
		scienceAppInputPortsImpl.setInputPorts(scienceAppInputPorts.getInputPorts());

		return scienceAppInputPortsImpl;
	}

	/**
	 * Returns the science app input ports with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app input ports
	 * @return the science app input ports
	 * @throws com.kisti.science.platform.app.NoSuchInputPortsException if a science app input ports with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppInputPorts findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInputPortsException, SystemException {
		ScienceAppInputPorts scienceAppInputPorts = fetchByPrimaryKey(primaryKey);

		if (scienceAppInputPorts == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInputPortsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return scienceAppInputPorts;
	}

	/**
	 * Returns the science app input ports with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchInputPortsException} if it could not be found.
	 *
	 * @param scienceAppId the primary key of the science app input ports
	 * @return the science app input ports
	 * @throws com.kisti.science.platform.app.NoSuchInputPortsException if a science app input ports with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppInputPorts findByPrimaryKey(long scienceAppId)
		throws NoSuchInputPortsException, SystemException {
		return findByPrimaryKey((Serializable)scienceAppId);
	}

	/**
	 * Returns the science app input ports with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app input ports
	 * @return the science app input ports, or <code>null</code> if a science app input ports with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppInputPorts fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ScienceAppInputPorts scienceAppInputPorts = (ScienceAppInputPorts)EntityCacheUtil.getResult(ScienceAppInputPortsModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppInputPortsImpl.class, primaryKey);

		if (scienceAppInputPorts == _nullScienceAppInputPorts) {
			return null;
		}

		if (scienceAppInputPorts == null) {
			Session session = null;

			try {
				session = openSession();

				scienceAppInputPorts = (ScienceAppInputPorts)session.get(ScienceAppInputPortsImpl.class,
						primaryKey);

				if (scienceAppInputPorts != null) {
					cacheResult(scienceAppInputPorts);
				}
				else {
					EntityCacheUtil.putResult(ScienceAppInputPortsModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppInputPortsImpl.class, primaryKey,
						_nullScienceAppInputPorts);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ScienceAppInputPortsModelImpl.ENTITY_CACHE_ENABLED,
					ScienceAppInputPortsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return scienceAppInputPorts;
	}

	/**
	 * Returns the science app input ports with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scienceAppId the primary key of the science app input ports
	 * @return the science app input ports, or <code>null</code> if a science app input ports with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppInputPorts fetchByPrimaryKey(long scienceAppId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)scienceAppId);
	}

	/**
	 * Returns all the science app input portses.
	 *
	 * @return the science app input portses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppInputPorts> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science app input portses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppInputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science app input portses
	 * @param end the upper bound of the range of science app input portses (not inclusive)
	 * @return the range of science app input portses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppInputPorts> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app input portses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppInputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science app input portses
	 * @param end the upper bound of the range of science app input portses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of science app input portses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppInputPorts> findAll(int start, int end,
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

		List<ScienceAppInputPorts> list = (List<ScienceAppInputPorts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCIENCEAPPINPUTPORTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCIENCEAPPINPUTPORTS;

				if (pagination) {
					sql = sql.concat(ScienceAppInputPortsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ScienceAppInputPorts>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppInputPorts>(list);
				}
				else {
					list = (List<ScienceAppInputPorts>)QueryUtil.list(q,
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
	 * Removes all the science app input portses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ScienceAppInputPorts scienceAppInputPorts : findAll()) {
			remove(scienceAppInputPorts);
		}
	}

	/**
	 * Returns the number of science app input portses.
	 *
	 * @return the number of science app input portses
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

				Query q = session.createQuery(_SQL_COUNT_SCIENCEAPPINPUTPORTS);

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
	 * Initializes the science app input ports persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kisti.science.platform.app.model.ScienceAppInputPorts")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ScienceAppInputPorts>> listenersList = new ArrayList<ModelListener<ScienceAppInputPorts>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ScienceAppInputPorts>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ScienceAppInputPortsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SCIENCEAPPINPUTPORTS = "SELECT scienceAppInputPorts FROM ScienceAppInputPorts scienceAppInputPorts";
	private static final String _SQL_COUNT_SCIENCEAPPINPUTPORTS = "SELECT COUNT(scienceAppInputPorts) FROM ScienceAppInputPorts scienceAppInputPorts";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scienceAppInputPorts.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ScienceAppInputPorts exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ScienceAppInputPortsPersistenceImpl.class);
	private static ScienceAppInputPorts _nullScienceAppInputPorts = new ScienceAppInputPortsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ScienceAppInputPorts> toCacheModel() {
				return _nullScienceAppInputPortsCacheModel;
			}
		};

	private static CacheModel<ScienceAppInputPorts> _nullScienceAppInputPortsCacheModel =
		new CacheModel<ScienceAppInputPorts>() {
			@Override
			public ScienceAppInputPorts toEntityModel() {
				return _nullScienceAppInputPorts;
			}
		};
}