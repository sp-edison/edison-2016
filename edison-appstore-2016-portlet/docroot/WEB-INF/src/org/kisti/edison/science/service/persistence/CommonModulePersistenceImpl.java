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

import org.kisti.edison.science.NoSuchCommonModuleException;
import org.kisti.edison.science.model.CommonModule;
import org.kisti.edison.science.model.impl.CommonModuleImpl;
import org.kisti.edison.science.model.impl.CommonModuleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the common module service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see CommonModulePersistence
 * @see CommonModuleUtil
 * @generated
 */
public class CommonModulePersistenceImpl extends BasePersistenceImpl<CommonModule>
	implements CommonModulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CommonModuleUtil} to access the common module persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CommonModuleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CommonModuleModelImpl.ENTITY_CACHE_ENABLED,
			CommonModuleModelImpl.FINDER_CACHE_ENABLED, CommonModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CommonModuleModelImpl.ENTITY_CACHE_ENABLED,
			CommonModuleModelImpl.FINDER_CACHE_ENABLED, CommonModuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CommonModuleModelImpl.ENTITY_CACHE_ENABLED,
			CommonModuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CommonModulePersistenceImpl() {
		setModelClass(CommonModule.class);
	}

	/**
	 * Caches the common module in the entity cache if it is enabled.
	 *
	 * @param commonModule the common module
	 */
	@Override
	public void cacheResult(CommonModule commonModule) {
		EntityCacheUtil.putResult(CommonModuleModelImpl.ENTITY_CACHE_ENABLED,
			CommonModuleImpl.class, commonModule.getPrimaryKey(), commonModule);

		commonModule.resetOriginalValues();
	}

	/**
	 * Caches the common modules in the entity cache if it is enabled.
	 *
	 * @param commonModules the common modules
	 */
	@Override
	public void cacheResult(List<CommonModule> commonModules) {
		for (CommonModule commonModule : commonModules) {
			if (EntityCacheUtil.getResult(
						CommonModuleModelImpl.ENTITY_CACHE_ENABLED,
						CommonModuleImpl.class, commonModule.getPrimaryKey()) == null) {
				cacheResult(commonModule);
			}
			else {
				commonModule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all common modules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CommonModuleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CommonModuleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the common module.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CommonModule commonModule) {
		EntityCacheUtil.removeResult(CommonModuleModelImpl.ENTITY_CACHE_ENABLED,
			CommonModuleImpl.class, commonModule.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CommonModule> commonModules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CommonModule commonModule : commonModules) {
			EntityCacheUtil.removeResult(CommonModuleModelImpl.ENTITY_CACHE_ENABLED,
				CommonModuleImpl.class, commonModule.getPrimaryKey());
		}
	}

	/**
	 * Creates a new common module with the primary key. Does not add the common module to the database.
	 *
	 * @param commonModuleId the primary key for the new common module
	 * @return the new common module
	 */
	@Override
	public CommonModule create(long commonModuleId) {
		CommonModule commonModule = new CommonModuleImpl();

		commonModule.setNew(true);
		commonModule.setPrimaryKey(commonModuleId);

		return commonModule;
	}

	/**
	 * Removes the common module with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commonModuleId the primary key of the common module
	 * @return the common module that was removed
	 * @throws org.kisti.edison.science.NoSuchCommonModuleException if a common module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonModule remove(long commonModuleId)
		throws NoSuchCommonModuleException, SystemException {
		return remove((Serializable)commonModuleId);
	}

	/**
	 * Removes the common module with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the common module
	 * @return the common module that was removed
	 * @throws org.kisti.edison.science.NoSuchCommonModuleException if a common module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonModule remove(Serializable primaryKey)
		throws NoSuchCommonModuleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CommonModule commonModule = (CommonModule)session.get(CommonModuleImpl.class,
					primaryKey);

			if (commonModule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCommonModuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(commonModule);
		}
		catch (NoSuchCommonModuleException nsee) {
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
	protected CommonModule removeImpl(CommonModule commonModule)
		throws SystemException {
		commonModule = toUnwrappedModel(commonModule);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commonModule)) {
				commonModule = (CommonModule)session.get(CommonModuleImpl.class,
						commonModule.getPrimaryKeyObj());
			}

			if (commonModule != null) {
				session.delete(commonModule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (commonModule != null) {
			clearCache(commonModule);
		}

		return commonModule;
	}

	@Override
	public CommonModule updateImpl(
		org.kisti.edison.science.model.CommonModule commonModule)
		throws SystemException {
		commonModule = toUnwrappedModel(commonModule);

		boolean isNew = commonModule.isNew();

		Session session = null;

		try {
			session = openSession();

			if (commonModule.isNew()) {
				session.save(commonModule);

				commonModule.setNew(false);
			}
			else {
				session.merge(commonModule);
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

		EntityCacheUtil.putResult(CommonModuleModelImpl.ENTITY_CACHE_ENABLED,
			CommonModuleImpl.class, commonModule.getPrimaryKey(), commonModule);

		return commonModule;
	}

	protected CommonModule toUnwrappedModel(CommonModule commonModule) {
		if (commonModule instanceof CommonModuleImpl) {
			return commonModule;
		}

		CommonModuleImpl commonModuleImpl = new CommonModuleImpl();

		commonModuleImpl.setNew(commonModule.isNew());
		commonModuleImpl.setPrimaryKey(commonModule.getPrimaryKey());

		commonModuleImpl.setCommonModuleId(commonModule.getCommonModuleId());
		commonModuleImpl.setGroupId(commonModule.getGroupId());
		commonModuleImpl.setCompanyId(commonModule.getCompanyId());
		commonModuleImpl.setUserId(commonModule.getUserId());
		commonModuleImpl.setCreateDate(commonModule.getCreateDate());
		commonModuleImpl.setModifiedDate(commonModule.getModifiedDate());
		commonModuleImpl.setModuleName(commonModule.getModuleName());
		commonModuleImpl.setModuleVersion(commonModule.getModuleVersion());

		return commonModuleImpl;
	}

	/**
	 * Returns the common module with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the common module
	 * @return the common module
	 * @throws org.kisti.edison.science.NoSuchCommonModuleException if a common module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonModule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCommonModuleException, SystemException {
		CommonModule commonModule = fetchByPrimaryKey(primaryKey);

		if (commonModule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCommonModuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return commonModule;
	}

	/**
	 * Returns the common module with the primary key or throws a {@link org.kisti.edison.science.NoSuchCommonModuleException} if it could not be found.
	 *
	 * @param commonModuleId the primary key of the common module
	 * @return the common module
	 * @throws org.kisti.edison.science.NoSuchCommonModuleException if a common module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonModule findByPrimaryKey(long commonModuleId)
		throws NoSuchCommonModuleException, SystemException {
		return findByPrimaryKey((Serializable)commonModuleId);
	}

	/**
	 * Returns the common module with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the common module
	 * @return the common module, or <code>null</code> if a common module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonModule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CommonModule commonModule = (CommonModule)EntityCacheUtil.getResult(CommonModuleModelImpl.ENTITY_CACHE_ENABLED,
				CommonModuleImpl.class, primaryKey);

		if (commonModule == _nullCommonModule) {
			return null;
		}

		if (commonModule == null) {
			Session session = null;

			try {
				session = openSession();

				commonModule = (CommonModule)session.get(CommonModuleImpl.class,
						primaryKey);

				if (commonModule != null) {
					cacheResult(commonModule);
				}
				else {
					EntityCacheUtil.putResult(CommonModuleModelImpl.ENTITY_CACHE_ENABLED,
						CommonModuleImpl.class, primaryKey, _nullCommonModule);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CommonModuleModelImpl.ENTITY_CACHE_ENABLED,
					CommonModuleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return commonModule;
	}

	/**
	 * Returns the common module with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commonModuleId the primary key of the common module
	 * @return the common module, or <code>null</code> if a common module with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonModule fetchByPrimaryKey(long commonModuleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)commonModuleId);
	}

	/**
	 * Returns all the common modules.
	 *
	 * @return the common modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CommonModule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the common modules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of common modules
	 * @param end the upper bound of the range of common modules (not inclusive)
	 * @return the range of common modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CommonModule> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the common modules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of common modules
	 * @param end the upper bound of the range of common modules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of common modules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CommonModule> findAll(int start, int end,
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

		List<CommonModule> list = (List<CommonModule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMMONMODULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMONMODULE;

				if (pagination) {
					sql = sql.concat(CommonModuleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CommonModule>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CommonModule>(list);
				}
				else {
					list = (List<CommonModule>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the common modules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CommonModule commonModule : findAll()) {
			remove(commonModule);
		}
	}

	/**
	 * Returns the number of common modules.
	 *
	 * @return the number of common modules
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

				Query q = session.createQuery(_SQL_COUNT_COMMONMODULE);

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
	 * Initializes the common module persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.science.model.CommonModule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CommonModule>> listenersList = new ArrayList<ModelListener<CommonModule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CommonModule>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CommonModuleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COMMONMODULE = "SELECT commonModule FROM CommonModule commonModule";
	private static final String _SQL_COUNT_COMMONMODULE = "SELECT COUNT(commonModule) FROM CommonModule commonModule";
	private static final String _ORDER_BY_ENTITY_ALIAS = "commonModule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CommonModule exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CommonModulePersistenceImpl.class);
	private static CommonModule _nullCommonModule = new CommonModuleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CommonModule> toCacheModel() {
				return _nullCommonModuleCacheModel;
			}
		};

	private static CacheModel<CommonModule> _nullCommonModuleCacheModel = new CacheModel<CommonModule>() {
			@Override
			public CommonModule toEntityModel() {
				return _nullCommonModule;
			}
		};
}