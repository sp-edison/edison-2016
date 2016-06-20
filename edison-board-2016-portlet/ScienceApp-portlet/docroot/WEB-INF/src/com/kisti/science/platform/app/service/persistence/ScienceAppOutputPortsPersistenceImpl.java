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

import com.kisti.science.platform.app.NoSuchOutputPortsException;
import com.kisti.science.platform.app.model.ScienceAppOutputPorts;
import com.kisti.science.platform.app.model.impl.ScienceAppOutputPortsImpl;
import com.kisti.science.platform.app.model.impl.ScienceAppOutputPortsModelImpl;

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
 * The persistence implementation for the science app output ports service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppOutputPortsPersistence
 * @see ScienceAppOutputPortsUtil
 * @generated
 */
public class ScienceAppOutputPortsPersistenceImpl extends BasePersistenceImpl<ScienceAppOutputPorts>
	implements ScienceAppOutputPortsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScienceAppOutputPortsUtil} to access the science app output ports persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScienceAppOutputPortsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScienceAppOutputPortsModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppOutputPortsModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppOutputPortsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScienceAppOutputPortsModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppOutputPortsModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppOutputPortsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScienceAppOutputPortsModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppOutputPortsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ScienceAppOutputPortsPersistenceImpl() {
		setModelClass(ScienceAppOutputPorts.class);
	}

	/**
	 * Caches the science app output ports in the entity cache if it is enabled.
	 *
	 * @param scienceAppOutputPorts the science app output ports
	 */
	@Override
	public void cacheResult(ScienceAppOutputPorts scienceAppOutputPorts) {
		EntityCacheUtil.putResult(ScienceAppOutputPortsModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppOutputPortsImpl.class,
			scienceAppOutputPorts.getPrimaryKey(), scienceAppOutputPorts);

		scienceAppOutputPorts.resetOriginalValues();
	}

	/**
	 * Caches the science app output portses in the entity cache if it is enabled.
	 *
	 * @param scienceAppOutputPortses the science app output portses
	 */
	@Override
	public void cacheResult(List<ScienceAppOutputPorts> scienceAppOutputPortses) {
		for (ScienceAppOutputPorts scienceAppOutputPorts : scienceAppOutputPortses) {
			if (EntityCacheUtil.getResult(
						ScienceAppOutputPortsModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppOutputPortsImpl.class,
						scienceAppOutputPorts.getPrimaryKey()) == null) {
				cacheResult(scienceAppOutputPorts);
			}
			else {
				scienceAppOutputPorts.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all science app output portses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ScienceAppOutputPortsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ScienceAppOutputPortsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the science app output ports.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScienceAppOutputPorts scienceAppOutputPorts) {
		EntityCacheUtil.removeResult(ScienceAppOutputPortsModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppOutputPortsImpl.class,
			scienceAppOutputPorts.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ScienceAppOutputPorts> scienceAppOutputPortses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ScienceAppOutputPorts scienceAppOutputPorts : scienceAppOutputPortses) {
			EntityCacheUtil.removeResult(ScienceAppOutputPortsModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppOutputPortsImpl.class,
				scienceAppOutputPorts.getPrimaryKey());
		}
	}

	/**
	 * Creates a new science app output ports with the primary key. Does not add the science app output ports to the database.
	 *
	 * @param scienceAppId the primary key for the new science app output ports
	 * @return the new science app output ports
	 */
	@Override
	public ScienceAppOutputPorts create(long scienceAppId) {
		ScienceAppOutputPorts scienceAppOutputPorts = new ScienceAppOutputPortsImpl();

		scienceAppOutputPorts.setNew(true);
		scienceAppOutputPorts.setPrimaryKey(scienceAppId);

		return scienceAppOutputPorts;
	}

	/**
	 * Removes the science app output ports with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scienceAppId the primary key of the science app output ports
	 * @return the science app output ports that was removed
	 * @throws com.kisti.science.platform.app.NoSuchOutputPortsException if a science app output ports with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppOutputPorts remove(long scienceAppId)
		throws NoSuchOutputPortsException, SystemException {
		return remove((Serializable)scienceAppId);
	}

	/**
	 * Removes the science app output ports with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the science app output ports
	 * @return the science app output ports that was removed
	 * @throws com.kisti.science.platform.app.NoSuchOutputPortsException if a science app output ports with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppOutputPorts remove(Serializable primaryKey)
		throws NoSuchOutputPortsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ScienceAppOutputPorts scienceAppOutputPorts = (ScienceAppOutputPorts)session.get(ScienceAppOutputPortsImpl.class,
					primaryKey);

			if (scienceAppOutputPorts == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOutputPortsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scienceAppOutputPorts);
		}
		catch (NoSuchOutputPortsException nsee) {
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
	protected ScienceAppOutputPorts removeImpl(
		ScienceAppOutputPorts scienceAppOutputPorts) throws SystemException {
		scienceAppOutputPorts = toUnwrappedModel(scienceAppOutputPorts);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scienceAppOutputPorts)) {
				scienceAppOutputPorts = (ScienceAppOutputPorts)session.get(ScienceAppOutputPortsImpl.class,
						scienceAppOutputPorts.getPrimaryKeyObj());
			}

			if (scienceAppOutputPorts != null) {
				session.delete(scienceAppOutputPorts);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scienceAppOutputPorts != null) {
			clearCache(scienceAppOutputPorts);
		}

		return scienceAppOutputPorts;
	}

	@Override
	public ScienceAppOutputPorts updateImpl(
		com.kisti.science.platform.app.model.ScienceAppOutputPorts scienceAppOutputPorts)
		throws SystemException {
		scienceAppOutputPorts = toUnwrappedModel(scienceAppOutputPorts);

		boolean isNew = scienceAppOutputPorts.isNew();

		Session session = null;

		try {
			session = openSession();

			if (scienceAppOutputPorts.isNew()) {
				session.save(scienceAppOutputPorts);

				scienceAppOutputPorts.setNew(false);
			}
			else {
				session.merge(scienceAppOutputPorts);
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

		EntityCacheUtil.putResult(ScienceAppOutputPortsModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppOutputPortsImpl.class,
			scienceAppOutputPorts.getPrimaryKey(), scienceAppOutputPorts);

		return scienceAppOutputPorts;
	}

	protected ScienceAppOutputPorts toUnwrappedModel(
		ScienceAppOutputPorts scienceAppOutputPorts) {
		if (scienceAppOutputPorts instanceof ScienceAppOutputPortsImpl) {
			return scienceAppOutputPorts;
		}

		ScienceAppOutputPortsImpl scienceAppOutputPortsImpl = new ScienceAppOutputPortsImpl();

		scienceAppOutputPortsImpl.setNew(scienceAppOutputPorts.isNew());
		scienceAppOutputPortsImpl.setPrimaryKey(scienceAppOutputPorts.getPrimaryKey());

		scienceAppOutputPortsImpl.setScienceAppId(scienceAppOutputPorts.getScienceAppId());
		scienceAppOutputPortsImpl.setOutputPorts(scienceAppOutputPorts.getOutputPorts());

		return scienceAppOutputPortsImpl;
	}

	/**
	 * Returns the science app output ports with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app output ports
	 * @return the science app output ports
	 * @throws com.kisti.science.platform.app.NoSuchOutputPortsException if a science app output ports with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppOutputPorts findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOutputPortsException, SystemException {
		ScienceAppOutputPorts scienceAppOutputPorts = fetchByPrimaryKey(primaryKey);

		if (scienceAppOutputPorts == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOutputPortsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return scienceAppOutputPorts;
	}

	/**
	 * Returns the science app output ports with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchOutputPortsException} if it could not be found.
	 *
	 * @param scienceAppId the primary key of the science app output ports
	 * @return the science app output ports
	 * @throws com.kisti.science.platform.app.NoSuchOutputPortsException if a science app output ports with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppOutputPorts findByPrimaryKey(long scienceAppId)
		throws NoSuchOutputPortsException, SystemException {
		return findByPrimaryKey((Serializable)scienceAppId);
	}

	/**
	 * Returns the science app output ports with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app output ports
	 * @return the science app output ports, or <code>null</code> if a science app output ports with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppOutputPorts fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ScienceAppOutputPorts scienceAppOutputPorts = (ScienceAppOutputPorts)EntityCacheUtil.getResult(ScienceAppOutputPortsModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppOutputPortsImpl.class, primaryKey);

		if (scienceAppOutputPorts == _nullScienceAppOutputPorts) {
			return null;
		}

		if (scienceAppOutputPorts == null) {
			Session session = null;

			try {
				session = openSession();

				scienceAppOutputPorts = (ScienceAppOutputPorts)session.get(ScienceAppOutputPortsImpl.class,
						primaryKey);

				if (scienceAppOutputPorts != null) {
					cacheResult(scienceAppOutputPorts);
				}
				else {
					EntityCacheUtil.putResult(ScienceAppOutputPortsModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppOutputPortsImpl.class, primaryKey,
						_nullScienceAppOutputPorts);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ScienceAppOutputPortsModelImpl.ENTITY_CACHE_ENABLED,
					ScienceAppOutputPortsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return scienceAppOutputPorts;
	}

	/**
	 * Returns the science app output ports with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scienceAppId the primary key of the science app output ports
	 * @return the science app output ports, or <code>null</code> if a science app output ports with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppOutputPorts fetchByPrimaryKey(long scienceAppId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)scienceAppId);
	}

	/**
	 * Returns all the science app output portses.
	 *
	 * @return the science app output portses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppOutputPorts> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science app output portses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppOutputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science app output portses
	 * @param end the upper bound of the range of science app output portses (not inclusive)
	 * @return the range of science app output portses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppOutputPorts> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app output portses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppOutputPortsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science app output portses
	 * @param end the upper bound of the range of science app output portses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of science app output portses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppOutputPorts> findAll(int start, int end,
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

		List<ScienceAppOutputPorts> list = (List<ScienceAppOutputPorts>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCIENCEAPPOUTPUTPORTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCIENCEAPPOUTPUTPORTS;

				if (pagination) {
					sql = sql.concat(ScienceAppOutputPortsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ScienceAppOutputPorts>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppOutputPorts>(list);
				}
				else {
					list = (List<ScienceAppOutputPorts>)QueryUtil.list(q,
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
	 * Removes all the science app output portses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ScienceAppOutputPorts scienceAppOutputPorts : findAll()) {
			remove(scienceAppOutputPorts);
		}
	}

	/**
	 * Returns the number of science app output portses.
	 *
	 * @return the number of science app output portses
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

				Query q = session.createQuery(_SQL_COUNT_SCIENCEAPPOUTPUTPORTS);

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
	 * Initializes the science app output ports persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kisti.science.platform.app.model.ScienceAppOutputPorts")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ScienceAppOutputPorts>> listenersList = new ArrayList<ModelListener<ScienceAppOutputPorts>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ScienceAppOutputPorts>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ScienceAppOutputPortsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SCIENCEAPPOUTPUTPORTS = "SELECT scienceAppOutputPorts FROM ScienceAppOutputPorts scienceAppOutputPorts";
	private static final String _SQL_COUNT_SCIENCEAPPOUTPUTPORTS = "SELECT COUNT(scienceAppOutputPorts) FROM ScienceAppOutputPorts scienceAppOutputPorts";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scienceAppOutputPorts.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ScienceAppOutputPorts exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ScienceAppOutputPortsPersistenceImpl.class);
	private static ScienceAppOutputPorts _nullScienceAppOutputPorts = new ScienceAppOutputPortsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ScienceAppOutputPorts> toCacheModel() {
				return _nullScienceAppOutputPortsCacheModel;
			}
		};

	private static CacheModel<ScienceAppOutputPorts> _nullScienceAppOutputPortsCacheModel =
		new CacheModel<ScienceAppOutputPorts>() {
			@Override
			public ScienceAppOutputPorts toEntityModel() {
				return _nullScienceAppOutputPorts;
			}
		};
}