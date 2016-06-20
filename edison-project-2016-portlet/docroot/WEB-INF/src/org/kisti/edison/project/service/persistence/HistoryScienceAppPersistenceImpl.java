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

import org.kisti.edison.project.NoSuchHistoryScienceAppException;
import org.kisti.edison.project.model.HistoryScienceApp;
import org.kisti.edison.project.model.impl.HistoryScienceAppImpl;
import org.kisti.edison.project.model.impl.HistoryScienceAppModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the history science app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see HistoryScienceAppPersistence
 * @see HistoryScienceAppUtil
 * @generated
 */
public class HistoryScienceAppPersistenceImpl extends BasePersistenceImpl<HistoryScienceApp>
	implements HistoryScienceAppPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HistoryScienceAppUtil} to access the history science app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HistoryScienceAppImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HistoryScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			HistoryScienceAppModelImpl.FINDER_CACHE_ENABLED,
			HistoryScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HistoryScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			HistoryScienceAppModelImpl.FINDER_CACHE_ENABLED,
			HistoryScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HistoryScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			HistoryScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public HistoryScienceAppPersistenceImpl() {
		setModelClass(HistoryScienceApp.class);
	}

	/**
	 * Caches the history science app in the entity cache if it is enabled.
	 *
	 * @param historyScienceApp the history science app
	 */
	@Override
	public void cacheResult(HistoryScienceApp historyScienceApp) {
		EntityCacheUtil.putResult(HistoryScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			HistoryScienceAppImpl.class, historyScienceApp.getPrimaryKey(),
			historyScienceApp);

		historyScienceApp.resetOriginalValues();
	}

	/**
	 * Caches the history science apps in the entity cache if it is enabled.
	 *
	 * @param historyScienceApps the history science apps
	 */
	@Override
	public void cacheResult(List<HistoryScienceApp> historyScienceApps) {
		for (HistoryScienceApp historyScienceApp : historyScienceApps) {
			if (EntityCacheUtil.getResult(
						HistoryScienceAppModelImpl.ENTITY_CACHE_ENABLED,
						HistoryScienceAppImpl.class,
						historyScienceApp.getPrimaryKey()) == null) {
				cacheResult(historyScienceApp);
			}
			else {
				historyScienceApp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all history science apps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HistoryScienceAppImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HistoryScienceAppImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the history science app.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HistoryScienceApp historyScienceApp) {
		EntityCacheUtil.removeResult(HistoryScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			HistoryScienceAppImpl.class, historyScienceApp.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HistoryScienceApp> historyScienceApps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HistoryScienceApp historyScienceApp : historyScienceApps) {
			EntityCacheUtil.removeResult(HistoryScienceAppModelImpl.ENTITY_CACHE_ENABLED,
				HistoryScienceAppImpl.class, historyScienceApp.getPrimaryKey());
		}
	}

	/**
	 * Creates a new history science app with the primary key. Does not add the history science app to the database.
	 *
	 * @param historyScienceAppPK the primary key for the new history science app
	 * @return the new history science app
	 */
	@Override
	public HistoryScienceApp create(HistoryScienceAppPK historyScienceAppPK) {
		HistoryScienceApp historyScienceApp = new HistoryScienceAppImpl();

		historyScienceApp.setNew(true);
		historyScienceApp.setPrimaryKey(historyScienceAppPK);

		return historyScienceApp;
	}

	/**
	 * Removes the history science app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param historyScienceAppPK the primary key of the history science app
	 * @return the history science app that was removed
	 * @throws org.kisti.edison.project.NoSuchHistoryScienceAppException if a history science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistoryScienceApp remove(HistoryScienceAppPK historyScienceAppPK)
		throws NoSuchHistoryScienceAppException, SystemException {
		return remove((Serializable)historyScienceAppPK);
	}

	/**
	 * Removes the history science app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the history science app
	 * @return the history science app that was removed
	 * @throws org.kisti.edison.project.NoSuchHistoryScienceAppException if a history science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistoryScienceApp remove(Serializable primaryKey)
		throws NoSuchHistoryScienceAppException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HistoryScienceApp historyScienceApp = (HistoryScienceApp)session.get(HistoryScienceAppImpl.class,
					primaryKey);

			if (historyScienceApp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHistoryScienceAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(historyScienceApp);
		}
		catch (NoSuchHistoryScienceAppException nsee) {
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
	protected HistoryScienceApp removeImpl(HistoryScienceApp historyScienceApp)
		throws SystemException {
		historyScienceApp = toUnwrappedModel(historyScienceApp);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(historyScienceApp)) {
				historyScienceApp = (HistoryScienceApp)session.get(HistoryScienceAppImpl.class,
						historyScienceApp.getPrimaryKeyObj());
			}

			if (historyScienceApp != null) {
				session.delete(historyScienceApp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (historyScienceApp != null) {
			clearCache(historyScienceApp);
		}

		return historyScienceApp;
	}

	@Override
	public HistoryScienceApp updateImpl(
		org.kisti.edison.project.model.HistoryScienceApp historyScienceApp)
		throws SystemException {
		historyScienceApp = toUnwrappedModel(historyScienceApp);

		boolean isNew = historyScienceApp.isNew();

		Session session = null;

		try {
			session = openSession();

			if (historyScienceApp.isNew()) {
				session.save(historyScienceApp);

				historyScienceApp.setNew(false);
			}
			else {
				session.merge(historyScienceApp);
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

		EntityCacheUtil.putResult(HistoryScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			HistoryScienceAppImpl.class, historyScienceApp.getPrimaryKey(),
			historyScienceApp);

		return historyScienceApp;
	}

	protected HistoryScienceApp toUnwrappedModel(
		HistoryScienceApp historyScienceApp) {
		if (historyScienceApp instanceof HistoryScienceAppImpl) {
			return historyScienceApp;
		}

		HistoryScienceAppImpl historyScienceAppImpl = new HistoryScienceAppImpl();

		historyScienceAppImpl.setNew(historyScienceApp.isNew());
		historyScienceAppImpl.setPrimaryKey(historyScienceApp.getPrimaryKey());

		historyScienceAppImpl.setScienceAppId(historyScienceApp.getScienceAppId());
		historyScienceAppImpl.setGroupId(historyScienceApp.getGroupId());
		historyScienceAppImpl.setProjectCategoryId(historyScienceApp.getProjectCategoryId());
		historyScienceAppImpl.setTitle(historyScienceApp.getTitle());
		historyScienceAppImpl.setVersion(historyScienceApp.getVersion());
		historyScienceAppImpl.setName(historyScienceApp.getName());
		historyScienceAppImpl.setAffiliation_id(historyScienceApp.getAffiliation_id());
		historyScienceAppImpl.setAppStatus(historyScienceApp.getAppStatus());
		historyScienceAppImpl.setUserId(historyScienceApp.getUserId());
		historyScienceAppImpl.setInsertDate(historyScienceApp.getInsertDate());

		return historyScienceAppImpl;
	}

	/**
	 * Returns the history science app with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the history science app
	 * @return the history science app
	 * @throws org.kisti.edison.project.NoSuchHistoryScienceAppException if a history science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistoryScienceApp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHistoryScienceAppException, SystemException {
		HistoryScienceApp historyScienceApp = fetchByPrimaryKey(primaryKey);

		if (historyScienceApp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHistoryScienceAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return historyScienceApp;
	}

	/**
	 * Returns the history science app with the primary key or throws a {@link org.kisti.edison.project.NoSuchHistoryScienceAppException} if it could not be found.
	 *
	 * @param historyScienceAppPK the primary key of the history science app
	 * @return the history science app
	 * @throws org.kisti.edison.project.NoSuchHistoryScienceAppException if a history science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistoryScienceApp findByPrimaryKey(
		HistoryScienceAppPK historyScienceAppPK)
		throws NoSuchHistoryScienceAppException, SystemException {
		return findByPrimaryKey((Serializable)historyScienceAppPK);
	}

	/**
	 * Returns the history science app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the history science app
	 * @return the history science app, or <code>null</code> if a history science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistoryScienceApp fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		HistoryScienceApp historyScienceApp = (HistoryScienceApp)EntityCacheUtil.getResult(HistoryScienceAppModelImpl.ENTITY_CACHE_ENABLED,
				HistoryScienceAppImpl.class, primaryKey);

		if (historyScienceApp == _nullHistoryScienceApp) {
			return null;
		}

		if (historyScienceApp == null) {
			Session session = null;

			try {
				session = openSession();

				historyScienceApp = (HistoryScienceApp)session.get(HistoryScienceAppImpl.class,
						primaryKey);

				if (historyScienceApp != null) {
					cacheResult(historyScienceApp);
				}
				else {
					EntityCacheUtil.putResult(HistoryScienceAppModelImpl.ENTITY_CACHE_ENABLED,
						HistoryScienceAppImpl.class, primaryKey,
						_nullHistoryScienceApp);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(HistoryScienceAppModelImpl.ENTITY_CACHE_ENABLED,
					HistoryScienceAppImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return historyScienceApp;
	}

	/**
	 * Returns the history science app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param historyScienceAppPK the primary key of the history science app
	 * @return the history science app, or <code>null</code> if a history science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistoryScienceApp fetchByPrimaryKey(
		HistoryScienceAppPK historyScienceAppPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)historyScienceAppPK);
	}

	/**
	 * Returns all the history science apps.
	 *
	 * @return the history science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistoryScienceApp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the history science apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.project.model.impl.HistoryScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of history science apps
	 * @param end the upper bound of the range of history science apps (not inclusive)
	 * @return the range of history science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistoryScienceApp> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the history science apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.project.model.impl.HistoryScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of history science apps
	 * @param end the upper bound of the range of history science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of history science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistoryScienceApp> findAll(int start, int end,
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

		List<HistoryScienceApp> list = (List<HistoryScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HISTORYSCIENCEAPP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HISTORYSCIENCEAPP;

				if (pagination) {
					sql = sql.concat(HistoryScienceAppModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<HistoryScienceApp>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<HistoryScienceApp>(list);
				}
				else {
					list = (List<HistoryScienceApp>)QueryUtil.list(q,
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
	 * Removes all the history science apps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (HistoryScienceApp historyScienceApp : findAll()) {
			remove(historyScienceApp);
		}
	}

	/**
	 * Returns the number of history science apps.
	 *
	 * @return the number of history science apps
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

				Query q = session.createQuery(_SQL_COUNT_HISTORYSCIENCEAPP);

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
	 * Initializes the history science app persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.project.model.HistoryScienceApp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HistoryScienceApp>> listenersList = new ArrayList<ModelListener<HistoryScienceApp>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HistoryScienceApp>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HistoryScienceAppImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_HISTORYSCIENCEAPP = "SELECT historyScienceApp FROM HistoryScienceApp historyScienceApp";
	private static final String _SQL_COUNT_HISTORYSCIENCEAPP = "SELECT COUNT(historyScienceApp) FROM HistoryScienceApp historyScienceApp";
	private static final String _ORDER_BY_ENTITY_ALIAS = "historyScienceApp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HistoryScienceApp exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HistoryScienceAppPersistenceImpl.class);
	private static HistoryScienceApp _nullHistoryScienceApp = new HistoryScienceAppImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HistoryScienceApp> toCacheModel() {
				return _nullHistoryScienceAppCacheModel;
			}
		};

	private static CacheModel<HistoryScienceApp> _nullHistoryScienceAppCacheModel =
		new CacheModel<HistoryScienceApp>() {
			@Override
			public HistoryScienceApp toEntityModel() {
				return _nullHistoryScienceApp;
			}
		};
}