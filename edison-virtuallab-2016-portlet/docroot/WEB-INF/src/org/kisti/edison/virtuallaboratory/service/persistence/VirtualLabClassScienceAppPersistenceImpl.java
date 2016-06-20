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

package org.kisti.edison.virtuallaboratory.service.persistence;

import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassScienceAppException;
import org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppImpl;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the virtual lab class science app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see VirtualLabClassScienceAppPersistence
 * @see VirtualLabClassScienceAppUtil
 * @generated
 */
public class VirtualLabClassScienceAppPersistenceImpl
	extends BasePersistenceImpl<VirtualLabClassScienceApp>
	implements VirtualLabClassScienceAppPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VirtualLabClassScienceAppUtil} to access the virtual lab class science app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VirtualLabClassScienceAppImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VirtualLabClassScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassScienceAppModelImpl.FINDER_CACHE_ENABLED,
			VirtualLabClassScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VirtualLabClassScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassScienceAppModelImpl.FINDER_CACHE_ENABLED,
			VirtualLabClassScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VirtualLabClassScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassScienceAppModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public VirtualLabClassScienceAppPersistenceImpl() {
		setModelClass(VirtualLabClassScienceApp.class);
	}

	/**
	 * Caches the virtual lab class science app in the entity cache if it is enabled.
	 *
	 * @param virtualLabClassScienceApp the virtual lab class science app
	 */
	@Override
	public void cacheResult(VirtualLabClassScienceApp virtualLabClassScienceApp) {
		EntityCacheUtil.putResult(VirtualLabClassScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassScienceAppImpl.class,
			virtualLabClassScienceApp.getPrimaryKey(), virtualLabClassScienceApp);

		virtualLabClassScienceApp.resetOriginalValues();
	}

	/**
	 * Caches the virtual lab class science apps in the entity cache if it is enabled.
	 *
	 * @param virtualLabClassScienceApps the virtual lab class science apps
	 */
	@Override
	public void cacheResult(
		List<VirtualLabClassScienceApp> virtualLabClassScienceApps) {
		for (VirtualLabClassScienceApp virtualLabClassScienceApp : virtualLabClassScienceApps) {
			if (EntityCacheUtil.getResult(
						VirtualLabClassScienceAppModelImpl.ENTITY_CACHE_ENABLED,
						VirtualLabClassScienceAppImpl.class,
						virtualLabClassScienceApp.getPrimaryKey()) == null) {
				cacheResult(virtualLabClassScienceApp);
			}
			else {
				virtualLabClassScienceApp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all virtual lab class science apps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VirtualLabClassScienceAppImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VirtualLabClassScienceAppImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the virtual lab class science app.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VirtualLabClassScienceApp virtualLabClassScienceApp) {
		EntityCacheUtil.removeResult(VirtualLabClassScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassScienceAppImpl.class,
			virtualLabClassScienceApp.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<VirtualLabClassScienceApp> virtualLabClassScienceApps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VirtualLabClassScienceApp virtualLabClassScienceApp : virtualLabClassScienceApps) {
			EntityCacheUtil.removeResult(VirtualLabClassScienceAppModelImpl.ENTITY_CACHE_ENABLED,
				VirtualLabClassScienceAppImpl.class,
				virtualLabClassScienceApp.getPrimaryKey());
		}
	}

	/**
	 * Creates a new virtual lab class science app with the primary key. Does not add the virtual lab class science app to the database.
	 *
	 * @param scienceAppSeqNo the primary key for the new virtual lab class science app
	 * @return the new virtual lab class science app
	 */
	@Override
	public VirtualLabClassScienceApp create(long scienceAppSeqNo) {
		VirtualLabClassScienceApp virtualLabClassScienceApp = new VirtualLabClassScienceAppImpl();

		virtualLabClassScienceApp.setNew(true);
		virtualLabClassScienceApp.setPrimaryKey(scienceAppSeqNo);

		return virtualLabClassScienceApp;
	}

	/**
	 * Removes the virtual lab class science app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scienceAppSeqNo the primary key of the virtual lab class science app
	 * @return the virtual lab class science app that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassScienceAppException if a virtual lab class science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClassScienceApp remove(long scienceAppSeqNo)
		throws NoSuchVirtualLabClassScienceAppException, SystemException {
		return remove((Serializable)scienceAppSeqNo);
	}

	/**
	 * Removes the virtual lab class science app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the virtual lab class science app
	 * @return the virtual lab class science app that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassScienceAppException if a virtual lab class science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClassScienceApp remove(Serializable primaryKey)
		throws NoSuchVirtualLabClassScienceAppException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VirtualLabClassScienceApp virtualLabClassScienceApp = (VirtualLabClassScienceApp)session.get(VirtualLabClassScienceAppImpl.class,
					primaryKey);

			if (virtualLabClassScienceApp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVirtualLabClassScienceAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(virtualLabClassScienceApp);
		}
		catch (NoSuchVirtualLabClassScienceAppException nsee) {
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
	protected VirtualLabClassScienceApp removeImpl(
		VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws SystemException {
		virtualLabClassScienceApp = toUnwrappedModel(virtualLabClassScienceApp);

		virtualLabClassScienceAppToVirtualLabClassTableMapper.deleteLeftPrimaryKeyTableMappings(virtualLabClassScienceApp.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(virtualLabClassScienceApp)) {
				virtualLabClassScienceApp = (VirtualLabClassScienceApp)session.get(VirtualLabClassScienceAppImpl.class,
						virtualLabClassScienceApp.getPrimaryKeyObj());
			}

			if (virtualLabClassScienceApp != null) {
				session.delete(virtualLabClassScienceApp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (virtualLabClassScienceApp != null) {
			clearCache(virtualLabClassScienceApp);
		}

		return virtualLabClassScienceApp;
	}

	@Override
	public VirtualLabClassScienceApp updateImpl(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws SystemException {
		virtualLabClassScienceApp = toUnwrappedModel(virtualLabClassScienceApp);

		boolean isNew = virtualLabClassScienceApp.isNew();

		Session session = null;

		try {
			session = openSession();

			if (virtualLabClassScienceApp.isNew()) {
				session.save(virtualLabClassScienceApp);

				virtualLabClassScienceApp.setNew(false);
			}
			else {
				session.merge(virtualLabClassScienceApp);
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

		EntityCacheUtil.putResult(VirtualLabClassScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassScienceAppImpl.class,
			virtualLabClassScienceApp.getPrimaryKey(), virtualLabClassScienceApp);

		return virtualLabClassScienceApp;
	}

	protected VirtualLabClassScienceApp toUnwrappedModel(
		VirtualLabClassScienceApp virtualLabClassScienceApp) {
		if (virtualLabClassScienceApp instanceof VirtualLabClassScienceAppImpl) {
			return virtualLabClassScienceApp;
		}

		VirtualLabClassScienceAppImpl virtualLabClassScienceAppImpl = new VirtualLabClassScienceAppImpl();

		virtualLabClassScienceAppImpl.setNew(virtualLabClassScienceApp.isNew());
		virtualLabClassScienceAppImpl.setPrimaryKey(virtualLabClassScienceApp.getPrimaryKey());

		virtualLabClassScienceAppImpl.setScienceAppSeqNo(virtualLabClassScienceApp.getScienceAppSeqNo());
		virtualLabClassScienceAppImpl.setScienceAppId(virtualLabClassScienceApp.getScienceAppId());
		virtualLabClassScienceAppImpl.setCreateDate(virtualLabClassScienceApp.getCreateDate());

		return virtualLabClassScienceAppImpl;
	}

	/**
	 * Returns the virtual lab class science app with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the virtual lab class science app
	 * @return the virtual lab class science app
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassScienceAppException if a virtual lab class science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClassScienceApp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVirtualLabClassScienceAppException, SystemException {
		VirtualLabClassScienceApp virtualLabClassScienceApp = fetchByPrimaryKey(primaryKey);

		if (virtualLabClassScienceApp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVirtualLabClassScienceAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return virtualLabClassScienceApp;
	}

	/**
	 * Returns the virtual lab class science app with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassScienceAppException} if it could not be found.
	 *
	 * @param scienceAppSeqNo the primary key of the virtual lab class science app
	 * @return the virtual lab class science app
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassScienceAppException if a virtual lab class science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClassScienceApp findByPrimaryKey(long scienceAppSeqNo)
		throws NoSuchVirtualLabClassScienceAppException, SystemException {
		return findByPrimaryKey((Serializable)scienceAppSeqNo);
	}

	/**
	 * Returns the virtual lab class science app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the virtual lab class science app
	 * @return the virtual lab class science app, or <code>null</code> if a virtual lab class science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClassScienceApp fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VirtualLabClassScienceApp virtualLabClassScienceApp = (VirtualLabClassScienceApp)EntityCacheUtil.getResult(VirtualLabClassScienceAppModelImpl.ENTITY_CACHE_ENABLED,
				VirtualLabClassScienceAppImpl.class, primaryKey);

		if (virtualLabClassScienceApp == _nullVirtualLabClassScienceApp) {
			return null;
		}

		if (virtualLabClassScienceApp == null) {
			Session session = null;

			try {
				session = openSession();

				virtualLabClassScienceApp = (VirtualLabClassScienceApp)session.get(VirtualLabClassScienceAppImpl.class,
						primaryKey);

				if (virtualLabClassScienceApp != null) {
					cacheResult(virtualLabClassScienceApp);
				}
				else {
					EntityCacheUtil.putResult(VirtualLabClassScienceAppModelImpl.ENTITY_CACHE_ENABLED,
						VirtualLabClassScienceAppImpl.class, primaryKey,
						_nullVirtualLabClassScienceApp);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VirtualLabClassScienceAppModelImpl.ENTITY_CACHE_ENABLED,
					VirtualLabClassScienceAppImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return virtualLabClassScienceApp;
	}

	/**
	 * Returns the virtual lab class science app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scienceAppSeqNo the primary key of the virtual lab class science app
	 * @return the virtual lab class science app, or <code>null</code> if a virtual lab class science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClassScienceApp fetchByPrimaryKey(long scienceAppSeqNo)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)scienceAppSeqNo);
	}

	/**
	 * Returns all the virtual lab class science apps.
	 *
	 * @return the virtual lab class science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabClassScienceApp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the virtual lab class science apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of virtual lab class science apps
	 * @param end the upper bound of the range of virtual lab class science apps (not inclusive)
	 * @return the range of virtual lab class science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabClassScienceApp> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the virtual lab class science apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of virtual lab class science apps
	 * @param end the upper bound of the range of virtual lab class science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of virtual lab class science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabClassScienceApp> findAll(int start, int end,
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

		List<VirtualLabClassScienceApp> list = (List<VirtualLabClassScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIRTUALLABCLASSSCIENCEAPP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIRTUALLABCLASSSCIENCEAPP;

				if (pagination) {
					sql = sql.concat(VirtualLabClassScienceAppModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VirtualLabClassScienceApp>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VirtualLabClassScienceApp>(list);
				}
				else {
					list = (List<VirtualLabClassScienceApp>)QueryUtil.list(q,
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
	 * Removes all the virtual lab class science apps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VirtualLabClassScienceApp virtualLabClassScienceApp : findAll()) {
			remove(virtualLabClassScienceApp);
		}
	}

	/**
	 * Returns the number of virtual lab class science apps.
	 *
	 * @return the number of virtual lab class science apps
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

				Query q = session.createQuery(_SQL_COUNT_VIRTUALLABCLASSSCIENCEAPP);

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
	 * Returns all the virtual lab classes associated with the virtual lab class science app.
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @return the virtual lab classes associated with the virtual lab class science app
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk) throws SystemException {
		return getVirtualLabClasses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the virtual lab classes associated with the virtual lab class science app.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @param start the lower bound of the range of virtual lab class science apps
	 * @param end the upper bound of the range of virtual lab class science apps (not inclusive)
	 * @return the range of virtual lab classes associated with the virtual lab class science app
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk, int start, int end) throws SystemException {
		return getVirtualLabClasses(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the virtual lab classes associated with the virtual lab class science app.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @param start the lower bound of the range of virtual lab class science apps
	 * @param end the upper bound of the range of virtual lab class science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of virtual lab classes associated with the virtual lab class science app
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return virtualLabClassScienceAppToVirtualLabClassTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of virtual lab classes associated with the virtual lab class science app.
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @return the number of virtual lab classes associated with the virtual lab class science app
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getVirtualLabClassesSize(long pk) throws SystemException {
		long[] pks = virtualLabClassScienceAppToVirtualLabClassTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the virtual lab class is associated with the virtual lab class science app.
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @param virtualLabClassPK the primary key of the virtual lab class
	 * @return <code>true</code> if the virtual lab class is associated with the virtual lab class science app; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsVirtualLabClass(long pk, long virtualLabClassPK)
		throws SystemException {
		return virtualLabClassScienceAppToVirtualLabClassTableMapper.containsTableMapping(pk,
			virtualLabClassPK);
	}

	/**
	 * Returns <code>true</code> if the virtual lab class science app has any virtual lab classes associated with it.
	 *
	 * @param pk the primary key of the virtual lab class science app to check for associations with virtual lab classes
	 * @return <code>true</code> if the virtual lab class science app has any virtual lab classes associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsVirtualLabClasses(long pk) throws SystemException {
		if (getVirtualLabClassesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the virtual lab class science app and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @param virtualLabClassPK the primary key of the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClass(long pk, long virtualLabClassPK)
		throws SystemException {
		virtualLabClassScienceAppToVirtualLabClassTableMapper.addTableMapping(pk,
			virtualLabClassPK);
	}

	/**
	 * Adds an association between the virtual lab class science app and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @param virtualLabClass the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClass(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws SystemException {
		virtualLabClassScienceAppToVirtualLabClassTableMapper.addTableMapping(pk,
			virtualLabClass.getPrimaryKey());
	}

	/**
	 * Adds an association between the virtual lab class science app and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @param virtualLabClassPKs the primary keys of the virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws SystemException {
		for (long virtualLabClassPK : virtualLabClassPKs) {
			virtualLabClassScienceAppToVirtualLabClassTableMapper.addTableMapping(pk,
				virtualLabClassPK);
		}
	}

	/**
	 * Adds an association between the virtual lab class science app and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @param virtualLabClasses the virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClasses(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass : virtualLabClasses) {
			virtualLabClassScienceAppToVirtualLabClassTableMapper.addTableMapping(pk,
				virtualLabClass.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the virtual lab class science app and its virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class science app to clear the associated virtual lab classes from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearVirtualLabClasses(long pk) throws SystemException {
		virtualLabClassScienceAppToVirtualLabClassTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the virtual lab class science app and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @param virtualLabClassPK the primary key of the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClass(long pk, long virtualLabClassPK)
		throws SystemException {
		virtualLabClassScienceAppToVirtualLabClassTableMapper.deleteTableMapping(pk,
			virtualLabClassPK);
	}

	/**
	 * Removes the association between the virtual lab class science app and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @param virtualLabClass the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClass(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws SystemException {
		virtualLabClassScienceAppToVirtualLabClassTableMapper.deleteTableMapping(pk,
			virtualLabClass.getPrimaryKey());
	}

	/**
	 * Removes the association between the virtual lab class science app and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @param virtualLabClassPKs the primary keys of the virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws SystemException {
		for (long virtualLabClassPK : virtualLabClassPKs) {
			virtualLabClassScienceAppToVirtualLabClassTableMapper.deleteTableMapping(pk,
				virtualLabClassPK);
		}
	}

	/**
	 * Removes the association between the virtual lab class science app and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @param virtualLabClasses the virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClasses(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass : virtualLabClasses) {
			virtualLabClassScienceAppToVirtualLabClassTableMapper.deleteTableMapping(pk,
				virtualLabClass.getPrimaryKey());
		}
	}

	/**
	 * Sets the virtual lab classes associated with the virtual lab class science app, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @param virtualLabClassPKs the primary keys of the virtual lab classes to be associated with the virtual lab class science app
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws SystemException {
		Set<Long> newVirtualLabClassPKsSet = SetUtil.fromArray(virtualLabClassPKs);
		Set<Long> oldVirtualLabClassPKsSet = SetUtil.fromArray(virtualLabClassScienceAppToVirtualLabClassTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeVirtualLabClassPKsSet = new HashSet<Long>(oldVirtualLabClassPKsSet);

		removeVirtualLabClassPKsSet.removeAll(newVirtualLabClassPKsSet);

		for (long removeVirtualLabClassPK : removeVirtualLabClassPKsSet) {
			virtualLabClassScienceAppToVirtualLabClassTableMapper.deleteTableMapping(pk,
				removeVirtualLabClassPK);
		}

		newVirtualLabClassPKsSet.removeAll(oldVirtualLabClassPKsSet);

		for (long newVirtualLabClassPK : newVirtualLabClassPKsSet) {
			virtualLabClassScienceAppToVirtualLabClassTableMapper.addTableMapping(pk,
				newVirtualLabClassPK);
		}
	}

	/**
	 * Sets the virtual lab classes associated with the virtual lab class science app, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class science app
	 * @param virtualLabClasses the virtual lab classes to be associated with the virtual lab class science app
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setVirtualLabClasses(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws SystemException {
		try {
			long[] virtualLabClassPKs = new long[virtualLabClasses.size()];

			for (int i = 0; i < virtualLabClasses.size(); i++) {
				org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass =
					virtualLabClasses.get(i);

				virtualLabClassPKs[i] = virtualLabClass.getPrimaryKey();
			}

			setVirtualLabClasses(pk, virtualLabClassPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(VirtualLabClassScienceAppModelImpl.MAPPING_TABLE_EDVIR_VIRTUALLABCLASSES_VIRTUALLABCLASSSCIENCEAPPS_NAME);
		}
	}

	/**
	 * Initializes the virtual lab class science app persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VirtualLabClassScienceApp>> listenersList = new ArrayList<ModelListener<VirtualLabClassScienceApp>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VirtualLabClassScienceApp>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		virtualLabClassScienceAppToVirtualLabClassTableMapper = TableMapperFactory.getTableMapper("EDVIR_VirtualLabClasses_VirtualLabClassScienceApps",
				"scienceAppSeqNo", "classId", this, virtualLabClassPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(VirtualLabClassScienceAppImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"EDVIR_VirtualLabClasses_VirtualLabClassScienceApps");
	}

	@BeanReference(type = VirtualLabClassPersistence.class)
	protected VirtualLabClassPersistence virtualLabClassPersistence;
	protected TableMapper<VirtualLabClassScienceApp, org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClassScienceAppToVirtualLabClassTableMapper;
	private static final String _SQL_SELECT_VIRTUALLABCLASSSCIENCEAPP = "SELECT virtualLabClassScienceApp FROM VirtualLabClassScienceApp virtualLabClassScienceApp";
	private static final String _SQL_COUNT_VIRTUALLABCLASSSCIENCEAPP = "SELECT COUNT(virtualLabClassScienceApp) FROM VirtualLabClassScienceApp virtualLabClassScienceApp";
	private static final String _ORDER_BY_ENTITY_ALIAS = "virtualLabClassScienceApp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VirtualLabClassScienceApp exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VirtualLabClassScienceAppPersistenceImpl.class);
	private static VirtualLabClassScienceApp _nullVirtualLabClassScienceApp = new VirtualLabClassScienceAppImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VirtualLabClassScienceApp> toCacheModel() {
				return _nullVirtualLabClassScienceAppCacheModel;
			}
		};

	private static CacheModel<VirtualLabClassScienceApp> _nullVirtualLabClassScienceAppCacheModel =
		new CacheModel<VirtualLabClassScienceApp>() {
			@Override
			public VirtualLabClassScienceApp toEntityModel() {
				return _nullVirtualLabClassScienceApp;
			}
		};
}