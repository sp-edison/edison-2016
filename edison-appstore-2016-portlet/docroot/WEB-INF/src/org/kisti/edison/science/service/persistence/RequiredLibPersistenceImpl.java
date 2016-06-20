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

import org.kisti.edison.science.NoSuchRequiredLibException;
import org.kisti.edison.science.model.RequiredLib;
import org.kisti.edison.science.model.impl.RequiredLibImpl;
import org.kisti.edison.science.model.impl.RequiredLibModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the required lib service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see RequiredLibPersistence
 * @see RequiredLibUtil
 * @generated
 */
public class RequiredLibPersistenceImpl extends BasePersistenceImpl<RequiredLib>
	implements RequiredLibPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RequiredLibUtil} to access the required lib persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RequiredLibImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RequiredLibModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibModelImpl.FINDER_CACHE_ENABLED, RequiredLibImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RequiredLibModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibModelImpl.FINDER_CACHE_ENABLED, RequiredLibImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RequiredLibModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RequiredLibPersistenceImpl() {
		setModelClass(RequiredLib.class);
	}

	/**
	 * Caches the required lib in the entity cache if it is enabled.
	 *
	 * @param requiredLib the required lib
	 */
	@Override
	public void cacheResult(RequiredLib requiredLib) {
		EntityCacheUtil.putResult(RequiredLibModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibImpl.class, requiredLib.getPrimaryKey(), requiredLib);

		requiredLib.resetOriginalValues();
	}

	/**
	 * Caches the required libs in the entity cache if it is enabled.
	 *
	 * @param requiredLibs the required libs
	 */
	@Override
	public void cacheResult(List<RequiredLib> requiredLibs) {
		for (RequiredLib requiredLib : requiredLibs) {
			if (EntityCacheUtil.getResult(
						RequiredLibModelImpl.ENTITY_CACHE_ENABLED,
						RequiredLibImpl.class, requiredLib.getPrimaryKey()) == null) {
				cacheResult(requiredLib);
			}
			else {
				requiredLib.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all required libs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RequiredLibImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RequiredLibImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the required lib.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RequiredLib requiredLib) {
		EntityCacheUtil.removeResult(RequiredLibModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibImpl.class, requiredLib.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RequiredLib> requiredLibs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RequiredLib requiredLib : requiredLibs) {
			EntityCacheUtil.removeResult(RequiredLibModelImpl.ENTITY_CACHE_ENABLED,
				RequiredLibImpl.class, requiredLib.getPrimaryKey());
		}
	}

	/**
	 * Creates a new required lib with the primary key. Does not add the required lib to the database.
	 *
	 * @param requiredLibId the primary key for the new required lib
	 * @return the new required lib
	 */
	@Override
	public RequiredLib create(long requiredLibId) {
		RequiredLib requiredLib = new RequiredLibImpl();

		requiredLib.setNew(true);
		requiredLib.setPrimaryKey(requiredLibId);

		return requiredLib;
	}

	/**
	 * Removes the required lib with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requiredLibId the primary key of the required lib
	 * @return the required lib that was removed
	 * @throws org.kisti.edison.science.NoSuchRequiredLibException if a required lib with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLib remove(long requiredLibId)
		throws NoSuchRequiredLibException, SystemException {
		return remove((Serializable)requiredLibId);
	}

	/**
	 * Removes the required lib with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the required lib
	 * @return the required lib that was removed
	 * @throws org.kisti.edison.science.NoSuchRequiredLibException if a required lib with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLib remove(Serializable primaryKey)
		throws NoSuchRequiredLibException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RequiredLib requiredLib = (RequiredLib)session.get(RequiredLibImpl.class,
					primaryKey);

			if (requiredLib == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRequiredLibException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(requiredLib);
		}
		catch (NoSuchRequiredLibException nsee) {
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
	protected RequiredLib removeImpl(RequiredLib requiredLib)
		throws SystemException {
		requiredLib = toUnwrappedModel(requiredLib);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(requiredLib)) {
				requiredLib = (RequiredLib)session.get(RequiredLibImpl.class,
						requiredLib.getPrimaryKeyObj());
			}

			if (requiredLib != null) {
				session.delete(requiredLib);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (requiredLib != null) {
			clearCache(requiredLib);
		}

		return requiredLib;
	}

	@Override
	public RequiredLib updateImpl(
		org.kisti.edison.science.model.RequiredLib requiredLib)
		throws SystemException {
		requiredLib = toUnwrappedModel(requiredLib);

		boolean isNew = requiredLib.isNew();

		Session session = null;

		try {
			session = openSession();

			if (requiredLib.isNew()) {
				session.save(requiredLib);

				requiredLib.setNew(false);
			}
			else {
				session.merge(requiredLib);
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

		EntityCacheUtil.putResult(RequiredLibModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibImpl.class, requiredLib.getPrimaryKey(), requiredLib);

		return requiredLib;
	}

	protected RequiredLib toUnwrappedModel(RequiredLib requiredLib) {
		if (requiredLib instanceof RequiredLibImpl) {
			return requiredLib;
		}

		RequiredLibImpl requiredLibImpl = new RequiredLibImpl();

		requiredLibImpl.setNew(requiredLib.isNew());
		requiredLibImpl.setPrimaryKey(requiredLib.getPrimaryKey());

		requiredLibImpl.setRequiredLibId(requiredLib.getRequiredLibId());
		requiredLibImpl.setGroupId(requiredLib.getGroupId());
		requiredLibImpl.setCompanyId(requiredLib.getCompanyId());
		requiredLibImpl.setUserId(requiredLib.getUserId());
		requiredLibImpl.setCreateDate(requiredLib.getCreateDate());
		requiredLibImpl.setModifiedDate(requiredLib.getModifiedDate());
		requiredLibImpl.setLibraryName(requiredLib.getLibraryName());
		requiredLibImpl.setLibraryVersion(requiredLib.getLibraryVersion());
		requiredLibImpl.setLibraryType(requiredLib.getLibraryType());
		requiredLibImpl.setLibrarySrcPath(requiredLib.getLibrarySrcPath());
		requiredLibImpl.setInstallScript(requiredLib.getInstallScript());

		return requiredLibImpl;
	}

	/**
	 * Returns the required lib with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the required lib
	 * @return the required lib
	 * @throws org.kisti.edison.science.NoSuchRequiredLibException if a required lib with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLib findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRequiredLibException, SystemException {
		RequiredLib requiredLib = fetchByPrimaryKey(primaryKey);

		if (requiredLib == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRequiredLibException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return requiredLib;
	}

	/**
	 * Returns the required lib with the primary key or throws a {@link org.kisti.edison.science.NoSuchRequiredLibException} if it could not be found.
	 *
	 * @param requiredLibId the primary key of the required lib
	 * @return the required lib
	 * @throws org.kisti.edison.science.NoSuchRequiredLibException if a required lib with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLib findByPrimaryKey(long requiredLibId)
		throws NoSuchRequiredLibException, SystemException {
		return findByPrimaryKey((Serializable)requiredLibId);
	}

	/**
	 * Returns the required lib with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the required lib
	 * @return the required lib, or <code>null</code> if a required lib with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLib fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RequiredLib requiredLib = (RequiredLib)EntityCacheUtil.getResult(RequiredLibModelImpl.ENTITY_CACHE_ENABLED,
				RequiredLibImpl.class, primaryKey);

		if (requiredLib == _nullRequiredLib) {
			return null;
		}

		if (requiredLib == null) {
			Session session = null;

			try {
				session = openSession();

				requiredLib = (RequiredLib)session.get(RequiredLibImpl.class,
						primaryKey);

				if (requiredLib != null) {
					cacheResult(requiredLib);
				}
				else {
					EntityCacheUtil.putResult(RequiredLibModelImpl.ENTITY_CACHE_ENABLED,
						RequiredLibImpl.class, primaryKey, _nullRequiredLib);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RequiredLibModelImpl.ENTITY_CACHE_ENABLED,
					RequiredLibImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return requiredLib;
	}

	/**
	 * Returns the required lib with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requiredLibId the primary key of the required lib
	 * @return the required lib, or <code>null</code> if a required lib with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLib fetchByPrimaryKey(long requiredLibId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)requiredLibId);
	}

	/**
	 * Returns all the required libs.
	 *
	 * @return the required libs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RequiredLib> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the required libs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of required libs
	 * @param end the upper bound of the range of required libs (not inclusive)
	 * @return the range of required libs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RequiredLib> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the required libs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of required libs
	 * @param end the upper bound of the range of required libs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of required libs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RequiredLib> findAll(int start, int end,
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

		List<RequiredLib> list = (List<RequiredLib>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REQUIREDLIB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REQUIREDLIB;

				if (pagination) {
					sql = sql.concat(RequiredLibModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RequiredLib>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RequiredLib>(list);
				}
				else {
					list = (List<RequiredLib>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the required libs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RequiredLib requiredLib : findAll()) {
			remove(requiredLib);
		}
	}

	/**
	 * Returns the number of required libs.
	 *
	 * @return the number of required libs
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

				Query q = session.createQuery(_SQL_COUNT_REQUIREDLIB);

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
	 * Initializes the required lib persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.science.model.RequiredLib")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RequiredLib>> listenersList = new ArrayList<ModelListener<RequiredLib>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RequiredLib>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RequiredLibImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_REQUIREDLIB = "SELECT requiredLib FROM RequiredLib requiredLib";
	private static final String _SQL_COUNT_REQUIREDLIB = "SELECT COUNT(requiredLib) FROM RequiredLib requiredLib";
	private static final String _ORDER_BY_ENTITY_ALIAS = "requiredLib.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RequiredLib exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RequiredLibPersistenceImpl.class);
	private static RequiredLib _nullRequiredLib = new RequiredLibImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RequiredLib> toCacheModel() {
				return _nullRequiredLibCacheModel;
			}
		};

	private static CacheModel<RequiredLib> _nullRequiredLibCacheModel = new CacheModel<RequiredLib>() {
			@Override
			public RequiredLib toEntityModel() {
				return _nullRequiredLib;
			}
		};
}