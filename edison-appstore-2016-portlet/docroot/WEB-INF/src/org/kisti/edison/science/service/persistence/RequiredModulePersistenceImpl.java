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

package org.kisti.edison.science.service.persistence;

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

import org.kisti.edison.science.NoSuchRequiredModuleException;
import org.kisti.edison.science.model.RequiredModule;
import org.kisti.edison.science.model.impl.RequiredModuleImpl;
import org.kisti.edison.science.model.impl.RequiredModuleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the required module service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see RequiredModulePersistence
 * @see RequiredModuleUtil
 * @generated
 */
public class RequiredModulePersistenceImpl extends BasePersistenceImpl<RequiredModule>
	implements RequiredModulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RequiredModuleUtil} to access the required module persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RequiredModuleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RequiredModuleModelImpl.ENTITY_CACHE_ENABLED,
			RequiredModuleModelImpl.FINDER_CACHE_ENABLED,
			RequiredModuleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RequiredModuleModelImpl.ENTITY_CACHE_ENABLED,
			RequiredModuleModelImpl.FINDER_CACHE_ENABLED,
			RequiredModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RequiredModuleModelImpl.ENTITY_CACHE_ENABLED,
			RequiredModuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RequiredModulePersistenceImpl() {
		setModelClass(RequiredModule.class);
	}

	/**
	 * Caches the required module in the entity cache if it is enabled.
	 *
	 * @param requiredModule the required module
	 */
	@Override
	public void cacheResult(RequiredModule requiredModule) {
		EntityCacheUtil.putResult(RequiredModuleModelImpl.ENTITY_CACHE_ENABLED,
			RequiredModuleImpl.class, requiredModule.getPrimaryKey(),
			requiredModule);

		requiredModule.resetOriginalValues();
	}

	/**
	 * Caches the required modules in the entity cache if it is enabled.
	 *
	 * @param requiredModules the required modules
	 */
	@Override
	public void cacheResult(List<RequiredModule> requiredModules) {
		for (RequiredModule requiredModule : requiredModules) {
			if (EntityCacheUtil.getResult(
						RequiredModuleModelImpl.ENTITY_CACHE_ENABLED,
						RequiredModuleImpl.class, requiredModule.getPrimaryKey()) == null) {
				cacheResult(requiredModule);
			}
			else {
				requiredModule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all required modules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RequiredModuleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RequiredModuleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the required module.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RequiredModule requiredModule) {
		EntityCacheUtil.removeResult(RequiredModuleModelImpl.ENTITY_CACHE_ENABLED,
			RequiredModuleImpl.class, requiredModule.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RequiredModule> requiredModules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RequiredModule requiredModule : requiredModules) {
			EntityCacheUtil.removeResult(RequiredModuleModelImpl.ENTITY_CACHE_ENABLED,
				RequiredModuleImpl.class, requiredModule.getPrimaryKey());
		}
	}

	/**
	 * Creates a new required module with the primary key. Does not add the required module to the database.
	 *
	 * @param requiredModuleId the primary key for the new required module
	 * @return the new required module
	 */
	@Override
	public RequiredModule create(long requiredModuleId) {
		RequiredModule requiredModule = new RequiredModuleImpl();

		requiredModule.setNew(true);
		requiredModule.setPrimaryKey(requiredModuleId);

		return requiredModule;
	}

	/**
	 * Removes the required module with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requiredModuleId the primary key of the required module
	 * @return the required module that was removed
	 * @throws org.kisti.edison.science.NoSuchRequiredModuleException if a required module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredModule remove(long requiredModuleId)
		throws NoSuchRequiredModuleException, SystemException {
		return remove((Serializable)requiredModuleId);
	}

	/**
	 * Removes the required module with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the required module
	 * @return the required module that was removed
	 * @throws org.kisti.edison.science.NoSuchRequiredModuleException if a required module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredModule remove(Serializable primaryKey)
		throws NoSuchRequiredModuleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RequiredModule requiredModule = (RequiredModule)session.get(RequiredModuleImpl.class,
					primaryKey);

			if (requiredModule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRequiredModuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(requiredModule);
		}
		catch (NoSuchRequiredModuleException nsee) {
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
	protected RequiredModule removeImpl(RequiredModule requiredModule)
		throws SystemException {
		requiredModule = toUnwrappedModel(requiredModule);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(requiredModule)) {
				requiredModule = (RequiredModule)session.get(RequiredModuleImpl.class,
						requiredModule.getPrimaryKeyObj());
			}

			if (requiredModule != null) {
				session.delete(requiredModule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (requiredModule != null) {
			clearCache(requiredModule);
		}

		return requiredModule;
	}

	@Override
	public RequiredModule updateImpl(
		org.kisti.edison.science.model.RequiredModule requiredModule)
		throws SystemException {
		requiredModule = toUnwrappedModel(requiredModule);

		boolean isNew = requiredModule.isNew();

		Session session = null;

		try {
			session = openSession();

			if (requiredModule.isNew()) {
				session.save(requiredModule);

				requiredModule.setNew(false);
			}
			else {
				session.merge(requiredModule);
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

		EntityCacheUtil.putResult(RequiredModuleModelImpl.ENTITY_CACHE_ENABLED,
			RequiredModuleImpl.class, requiredModule.getPrimaryKey(),
			requiredModule);

		return requiredModule;
	}

	protected RequiredModule toUnwrappedModel(RequiredModule requiredModule) {
		if (requiredModule instanceof RequiredModuleImpl) {
			return requiredModule;
		}

		RequiredModuleImpl requiredModuleImpl = new RequiredModuleImpl();

		requiredModuleImpl.setNew(requiredModule.isNew());
		requiredModuleImpl.setPrimaryKey(requiredModule.getPrimaryKey());

		requiredModuleImpl.setRequiredModuleId(requiredModule.getRequiredModuleId());
		requiredModuleImpl.setGroupId(requiredModule.getGroupId());
		requiredModuleImpl.setCompanyId(requiredModule.getCompanyId());
		requiredModuleImpl.setUserId(requiredModule.getUserId());
		requiredModuleImpl.setCreateDate(requiredModule.getCreateDate());
		requiredModuleImpl.setModifiedDate(requiredModule.getModifiedDate());
		requiredModuleImpl.setModuleName(requiredModule.getModuleName());
		requiredModuleImpl.setModuleVersion(requiredModule.getModuleVersion());

		return requiredModuleImpl;
	}

	/**
	 * Returns the required module with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the required module
	 * @return the required module
	 * @throws org.kisti.edison.science.NoSuchRequiredModuleException if a required module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredModule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRequiredModuleException, SystemException {
		RequiredModule requiredModule = fetchByPrimaryKey(primaryKey);

		if (requiredModule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRequiredModuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return requiredModule;
	}

	/**
	 * Returns the required module with the primary key or throws a {@link org.kisti.edison.science.NoSuchRequiredModuleException} if it could not be found.
	 *
	 * @param requiredModuleId the primary key of the required module
	 * @return the required module
	 * @throws org.kisti.edison.science.NoSuchRequiredModuleException if a required module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredModule findByPrimaryKey(long requiredModuleId)
		throws NoSuchRequiredModuleException, SystemException {
		return findByPrimaryKey((Serializable)requiredModuleId);
	}

	/**
	 * Returns the required module with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the required module
	 * @return the required module, or <code>null</code> if a required module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredModule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RequiredModule requiredModule = (RequiredModule)EntityCacheUtil.getResult(RequiredModuleModelImpl.ENTITY_CACHE_ENABLED,
				RequiredModuleImpl.class, primaryKey);

		if (requiredModule == _nullRequiredModule) {
			return null;
		}

		if (requiredModule == null) {
			Session session = null;

			try {
				session = openSession();

				requiredModule = (RequiredModule)session.get(RequiredModuleImpl.class,
						primaryKey);

				if (requiredModule != null) {
					cacheResult(requiredModule);
				}
				else {
					EntityCacheUtil.putResult(RequiredModuleModelImpl.ENTITY_CACHE_ENABLED,
						RequiredModuleImpl.class, primaryKey,
						_nullRequiredModule);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RequiredModuleModelImpl.ENTITY_CACHE_ENABLED,
					RequiredModuleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return requiredModule;
	}

	/**
	 * Returns the required module with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requiredModuleId the primary key of the required module
	 * @return the required module, or <code>null</code> if a required module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredModule fetchByPrimaryKey(long requiredModuleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)requiredModuleId);
	}

	/**
	 * Returns all the required modules.
	 *
	 * @return the required modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RequiredModule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the required modules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of required modules
	 * @param end the upper bound of the range of required modules (not inclusive)
	 * @return the range of required modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RequiredModule> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the required modules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of required modules
	 * @param end the upper bound of the range of required modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of required modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RequiredModule> findAll(int start, int end,
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

		List<RequiredModule> list = (List<RequiredModule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REQUIREDMODULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REQUIREDMODULE;

				if (pagination) {
					sql = sql.concat(RequiredModuleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RequiredModule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RequiredModule>(list);
				}
				else {
					list = (List<RequiredModule>)QueryUtil.list(q,
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
	 * Removes all the required modules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RequiredModule requiredModule : findAll()) {
			remove(requiredModule);
		}
	}

	/**
	 * Returns the number of required modules.
	 *
	 * @return the number of required modules
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

				Query q = session.createQuery(_SQL_COUNT_REQUIREDMODULE);

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
	 * Initializes the required module persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.science.model.RequiredModule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RequiredModule>> listenersList = new ArrayList<ModelListener<RequiredModule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RequiredModule>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RequiredModuleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_REQUIREDMODULE = "SELECT requiredModule FROM RequiredModule requiredModule";
	private static final String _SQL_COUNT_REQUIREDMODULE = "SELECT COUNT(requiredModule) FROM RequiredModule requiredModule";
	private static final String _ORDER_BY_ENTITY_ALIAS = "requiredModule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RequiredModule exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RequiredModulePersistenceImpl.class);
	private static RequiredModule _nullRequiredModule = new RequiredModuleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RequiredModule> toCacheModel() {
				return _nullRequiredModuleCacheModel;
			}
		};

	private static CacheModel<RequiredModule> _nullRequiredModuleCacheModel = new CacheModel<RequiredModule>() {
			@Override
			public RequiredModule toEntityModel() {
				return _nullRequiredModule;
			}
		};
}