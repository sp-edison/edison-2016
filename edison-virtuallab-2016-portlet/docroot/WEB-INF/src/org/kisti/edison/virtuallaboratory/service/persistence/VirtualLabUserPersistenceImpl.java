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

import org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException;
import org.kisti.edison.virtuallaboratory.model.VirtualLabUser;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserImpl;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the virtual lab user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see VirtualLabUserPersistence
 * @see VirtualLabUserUtil
 * @generated
 */
public class VirtualLabUserPersistenceImpl extends BasePersistenceImpl<VirtualLabUser>
	implements VirtualLabUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VirtualLabUserUtil} to access the virtual lab user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VirtualLabUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VirtualLabUserModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserModelImpl.FINDER_CACHE_ENABLED,
			VirtualLabUserImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VirtualLabUserModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserModelImpl.FINDER_CACHE_ENABLED,
			VirtualLabUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VirtualLabUserModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public VirtualLabUserPersistenceImpl() {
		setModelClass(VirtualLabUser.class);
	}

	/**
	 * Caches the virtual lab user in the entity cache if it is enabled.
	 *
	 * @param virtualLabUser the virtual lab user
	 */
	@Override
	public void cacheResult(VirtualLabUser virtualLabUser) {
		EntityCacheUtil.putResult(VirtualLabUserModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserImpl.class, virtualLabUser.getPrimaryKey(),
			virtualLabUser);

		virtualLabUser.resetOriginalValues();
	}

	/**
	 * Caches the virtual lab users in the entity cache if it is enabled.
	 *
	 * @param virtualLabUsers the virtual lab users
	 */
	@Override
	public void cacheResult(List<VirtualLabUser> virtualLabUsers) {
		for (VirtualLabUser virtualLabUser : virtualLabUsers) {
			if (EntityCacheUtil.getResult(
						VirtualLabUserModelImpl.ENTITY_CACHE_ENABLED,
						VirtualLabUserImpl.class, virtualLabUser.getPrimaryKey()) == null) {
				cacheResult(virtualLabUser);
			}
			else {
				virtualLabUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all virtual lab users.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VirtualLabUserImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VirtualLabUserImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the virtual lab user.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VirtualLabUser virtualLabUser) {
		EntityCacheUtil.removeResult(VirtualLabUserModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserImpl.class, virtualLabUser.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VirtualLabUser> virtualLabUsers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VirtualLabUser virtualLabUser : virtualLabUsers) {
			EntityCacheUtil.removeResult(VirtualLabUserModelImpl.ENTITY_CACHE_ENABLED,
				VirtualLabUserImpl.class, virtualLabUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new virtual lab user with the primary key. Does not add the virtual lab user to the database.
	 *
	 * @param virtualLabUserId the primary key for the new virtual lab user
	 * @return the new virtual lab user
	 */
	@Override
	public VirtualLabUser create(long virtualLabUserId) {
		VirtualLabUser virtualLabUser = new VirtualLabUserImpl();

		virtualLabUser.setNew(true);
		virtualLabUser.setPrimaryKey(virtualLabUserId);

		return virtualLabUser;
	}

	/**
	 * Removes the virtual lab user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param virtualLabUserId the primary key of the virtual lab user
	 * @return the virtual lab user that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException if a virtual lab user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUser remove(long virtualLabUserId)
		throws NoSuchVirtualLabUserException, SystemException {
		return remove((Serializable)virtualLabUserId);
	}

	/**
	 * Removes the virtual lab user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the virtual lab user
	 * @return the virtual lab user that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException if a virtual lab user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUser remove(Serializable primaryKey)
		throws NoSuchVirtualLabUserException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VirtualLabUser virtualLabUser = (VirtualLabUser)session.get(VirtualLabUserImpl.class,
					primaryKey);

			if (virtualLabUser == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVirtualLabUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(virtualLabUser);
		}
		catch (NoSuchVirtualLabUserException nsee) {
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
	protected VirtualLabUser removeImpl(VirtualLabUser virtualLabUser)
		throws SystemException {
		virtualLabUser = toUnwrappedModel(virtualLabUser);

		virtualLabUserToVirtualLabClassTableMapper.deleteLeftPrimaryKeyTableMappings(virtualLabUser.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(virtualLabUser)) {
				virtualLabUser = (VirtualLabUser)session.get(VirtualLabUserImpl.class,
						virtualLabUser.getPrimaryKeyObj());
			}

			if (virtualLabUser != null) {
				session.delete(virtualLabUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (virtualLabUser != null) {
			clearCache(virtualLabUser);
		}

		return virtualLabUser;
	}

	@Override
	public VirtualLabUser updateImpl(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws SystemException {
		virtualLabUser = toUnwrappedModel(virtualLabUser);

		boolean isNew = virtualLabUser.isNew();

		Session session = null;

		try {
			session = openSession();

			if (virtualLabUser.isNew()) {
				session.save(virtualLabUser);

				virtualLabUser.setNew(false);
			}
			else {
				session.merge(virtualLabUser);
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

		EntityCacheUtil.putResult(VirtualLabUserModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserImpl.class, virtualLabUser.getPrimaryKey(),
			virtualLabUser);

		return virtualLabUser;
	}

	protected VirtualLabUser toUnwrappedModel(VirtualLabUser virtualLabUser) {
		if (virtualLabUser instanceof VirtualLabUserImpl) {
			return virtualLabUser;
		}

		VirtualLabUserImpl virtualLabUserImpl = new VirtualLabUserImpl();

		virtualLabUserImpl.setNew(virtualLabUser.isNew());
		virtualLabUserImpl.setPrimaryKey(virtualLabUser.getPrimaryKey());

		virtualLabUserImpl.setVirtualLabUserId(virtualLabUser.getVirtualLabUserId());
		virtualLabUserImpl.setUserId(virtualLabUser.getUserId());
		virtualLabUserImpl.setUserStudentNumber(virtualLabUser.getUserStudentNumber());
		virtualLabUserImpl.setAuthRole(virtualLabUser.getAuthRole());
		virtualLabUserImpl.setUserUseYn(virtualLabUser.getUserUseYn());
		virtualLabUserImpl.setRequestSort(virtualLabUser.getRequestSort());
		virtualLabUserImpl.setProcessNote(virtualLabUser.getProcessNote());
		virtualLabUserImpl.setProcessDate(virtualLabUser.getProcessDate());
		virtualLabUserImpl.setCreateDt(virtualLabUser.getCreateDt());
		virtualLabUserImpl.setUpdateDt(virtualLabUser.getUpdateDt());

		return virtualLabUserImpl;
	}

	/**
	 * Returns the virtual lab user with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the virtual lab user
	 * @return the virtual lab user
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException if a virtual lab user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVirtualLabUserException, SystemException {
		VirtualLabUser virtualLabUser = fetchByPrimaryKey(primaryKey);

		if (virtualLabUser == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVirtualLabUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return virtualLabUser;
	}

	/**
	 * Returns the virtual lab user with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException} if it could not be found.
	 *
	 * @param virtualLabUserId the primary key of the virtual lab user
	 * @return the virtual lab user
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserException if a virtual lab user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUser findByPrimaryKey(long virtualLabUserId)
		throws NoSuchVirtualLabUserException, SystemException {
		return findByPrimaryKey((Serializable)virtualLabUserId);
	}

	/**
	 * Returns the virtual lab user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the virtual lab user
	 * @return the virtual lab user, or <code>null</code> if a virtual lab user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUser fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VirtualLabUser virtualLabUser = (VirtualLabUser)EntityCacheUtil.getResult(VirtualLabUserModelImpl.ENTITY_CACHE_ENABLED,
				VirtualLabUserImpl.class, primaryKey);

		if (virtualLabUser == _nullVirtualLabUser) {
			return null;
		}

		if (virtualLabUser == null) {
			Session session = null;

			try {
				session = openSession();

				virtualLabUser = (VirtualLabUser)session.get(VirtualLabUserImpl.class,
						primaryKey);

				if (virtualLabUser != null) {
					cacheResult(virtualLabUser);
				}
				else {
					EntityCacheUtil.putResult(VirtualLabUserModelImpl.ENTITY_CACHE_ENABLED,
						VirtualLabUserImpl.class, primaryKey,
						_nullVirtualLabUser);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VirtualLabUserModelImpl.ENTITY_CACHE_ENABLED,
					VirtualLabUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return virtualLabUser;
	}

	/**
	 * Returns the virtual lab user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param virtualLabUserId the primary key of the virtual lab user
	 * @return the virtual lab user, or <code>null</code> if a virtual lab user with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUser fetchByPrimaryKey(long virtualLabUserId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)virtualLabUserId);
	}

	/**
	 * Returns all the virtual lab users.
	 *
	 * @return the virtual lab users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabUser> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the virtual lab users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of virtual lab users
	 * @param end the upper bound of the range of virtual lab users (not inclusive)
	 * @return the range of virtual lab users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabUser> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the virtual lab users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of virtual lab users
	 * @param end the upper bound of the range of virtual lab users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of virtual lab users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabUser> findAll(int start, int end,
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

		List<VirtualLabUser> list = (List<VirtualLabUser>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIRTUALLABUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIRTUALLABUSER;

				if (pagination) {
					sql = sql.concat(VirtualLabUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VirtualLabUser>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VirtualLabUser>(list);
				}
				else {
					list = (List<VirtualLabUser>)QueryUtil.list(q,
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
	 * Removes all the virtual lab users from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VirtualLabUser virtualLabUser : findAll()) {
			remove(virtualLabUser);
		}
	}

	/**
	 * Returns the number of virtual lab users.
	 *
	 * @return the number of virtual lab users
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

				Query q = session.createQuery(_SQL_COUNT_VIRTUALLABUSER);

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
	 * Returns all the virtual lab classes associated with the virtual lab user.
	 *
	 * @param pk the primary key of the virtual lab user
	 * @return the virtual lab classes associated with the virtual lab user
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk) throws SystemException {
		return getVirtualLabClasses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the virtual lab classes associated with the virtual lab user.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab user
	 * @param start the lower bound of the range of virtual lab users
	 * @param end the upper bound of the range of virtual lab users (not inclusive)
	 * @return the range of virtual lab classes associated with the virtual lab user
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk, int start, int end) throws SystemException {
		return getVirtualLabClasses(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the virtual lab classes associated with the virtual lab user.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab user
	 * @param start the lower bound of the range of virtual lab users
	 * @param end the upper bound of the range of virtual lab users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of virtual lab classes associated with the virtual lab user
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return virtualLabUserToVirtualLabClassTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of virtual lab classes associated with the virtual lab user.
	 *
	 * @param pk the primary key of the virtual lab user
	 * @return the number of virtual lab classes associated with the virtual lab user
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getVirtualLabClassesSize(long pk) throws SystemException {
		long[] pks = virtualLabUserToVirtualLabClassTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the virtual lab class is associated with the virtual lab user.
	 *
	 * @param pk the primary key of the virtual lab user
	 * @param virtualLabClassPK the primary key of the virtual lab class
	 * @return <code>true</code> if the virtual lab class is associated with the virtual lab user; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsVirtualLabClass(long pk, long virtualLabClassPK)
		throws SystemException {
		return virtualLabUserToVirtualLabClassTableMapper.containsTableMapping(pk,
			virtualLabClassPK);
	}

	/**
	 * Returns <code>true</code> if the virtual lab user has any virtual lab classes associated with it.
	 *
	 * @param pk the primary key of the virtual lab user to check for associations with virtual lab classes
	 * @return <code>true</code> if the virtual lab user has any virtual lab classes associated with it; <code>false</code> otherwise
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
	 * Adds an association between the virtual lab user and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab user
	 * @param virtualLabClassPK the primary key of the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClass(long pk, long virtualLabClassPK)
		throws SystemException {
		virtualLabUserToVirtualLabClassTableMapper.addTableMapping(pk,
			virtualLabClassPK);
	}

	/**
	 * Adds an association between the virtual lab user and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab user
	 * @param virtualLabClass the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClass(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws SystemException {
		virtualLabUserToVirtualLabClassTableMapper.addTableMapping(pk,
			virtualLabClass.getPrimaryKey());
	}

	/**
	 * Adds an association between the virtual lab user and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab user
	 * @param virtualLabClassPKs the primary keys of the virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws SystemException {
		for (long virtualLabClassPK : virtualLabClassPKs) {
			virtualLabUserToVirtualLabClassTableMapper.addTableMapping(pk,
				virtualLabClassPK);
		}
	}

	/**
	 * Adds an association between the virtual lab user and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab user
	 * @param virtualLabClasses the virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClasses(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass : virtualLabClasses) {
			virtualLabUserToVirtualLabClassTableMapper.addTableMapping(pk,
				virtualLabClass.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the virtual lab user and its virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab user to clear the associated virtual lab classes from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearVirtualLabClasses(long pk) throws SystemException {
		virtualLabUserToVirtualLabClassTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the virtual lab user and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab user
	 * @param virtualLabClassPK the primary key of the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClass(long pk, long virtualLabClassPK)
		throws SystemException {
		virtualLabUserToVirtualLabClassTableMapper.deleteTableMapping(pk,
			virtualLabClassPK);
	}

	/**
	 * Removes the association between the virtual lab user and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab user
	 * @param virtualLabClass the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClass(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws SystemException {
		virtualLabUserToVirtualLabClassTableMapper.deleteTableMapping(pk,
			virtualLabClass.getPrimaryKey());
	}

	/**
	 * Removes the association between the virtual lab user and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab user
	 * @param virtualLabClassPKs the primary keys of the virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws SystemException {
		for (long virtualLabClassPK : virtualLabClassPKs) {
			virtualLabUserToVirtualLabClassTableMapper.deleteTableMapping(pk,
				virtualLabClassPK);
		}
	}

	/**
	 * Removes the association between the virtual lab user and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab user
	 * @param virtualLabClasses the virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClasses(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass : virtualLabClasses) {
			virtualLabUserToVirtualLabClassTableMapper.deleteTableMapping(pk,
				virtualLabClass.getPrimaryKey());
		}
	}

	/**
	 * Sets the virtual lab classes associated with the virtual lab user, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab user
	 * @param virtualLabClassPKs the primary keys of the virtual lab classes to be associated with the virtual lab user
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws SystemException {
		Set<Long> newVirtualLabClassPKsSet = SetUtil.fromArray(virtualLabClassPKs);
		Set<Long> oldVirtualLabClassPKsSet = SetUtil.fromArray(virtualLabUserToVirtualLabClassTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeVirtualLabClassPKsSet = new HashSet<Long>(oldVirtualLabClassPKsSet);

		removeVirtualLabClassPKsSet.removeAll(newVirtualLabClassPKsSet);

		for (long removeVirtualLabClassPK : removeVirtualLabClassPKsSet) {
			virtualLabUserToVirtualLabClassTableMapper.deleteTableMapping(pk,
				removeVirtualLabClassPK);
		}

		newVirtualLabClassPKsSet.removeAll(oldVirtualLabClassPKsSet);

		for (long newVirtualLabClassPK : newVirtualLabClassPKsSet) {
			virtualLabUserToVirtualLabClassTableMapper.addTableMapping(pk,
				newVirtualLabClassPK);
		}
	}

	/**
	 * Sets the virtual lab classes associated with the virtual lab user, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab user
	 * @param virtualLabClasses the virtual lab classes to be associated with the virtual lab user
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
			FinderCacheUtil.clearCache(VirtualLabUserModelImpl.MAPPING_TABLE_EDVIR_VIRTUALLABCLASSES_VIRTUALLABUSERS_NAME);
		}
	}

	/**
	 * Initializes the virtual lab user persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.virtuallaboratory.model.VirtualLabUser")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VirtualLabUser>> listenersList = new ArrayList<ModelListener<VirtualLabUser>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VirtualLabUser>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		virtualLabUserToVirtualLabClassTableMapper = TableMapperFactory.getTableMapper("EDVIR_VirtualLabClasses_VirtualLabUsers",
				"virtualLabUserId", "classId", this, virtualLabClassPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(VirtualLabUserImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"EDVIR_VirtualLabClasses_VirtualLabUsers");
	}

	@BeanReference(type = VirtualLabClassPersistence.class)
	protected VirtualLabClassPersistence virtualLabClassPersistence;
	protected TableMapper<VirtualLabUser, org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabUserToVirtualLabClassTableMapper;
	private static final String _SQL_SELECT_VIRTUALLABUSER = "SELECT virtualLabUser FROM VirtualLabUser virtualLabUser";
	private static final String _SQL_COUNT_VIRTUALLABUSER = "SELECT COUNT(virtualLabUser) FROM VirtualLabUser virtualLabUser";
	private static final String _ORDER_BY_ENTITY_ALIAS = "virtualLabUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VirtualLabUser exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VirtualLabUserPersistenceImpl.class);
	private static VirtualLabUser _nullVirtualLabUser = new VirtualLabUserImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VirtualLabUser> toCacheModel() {
				return _nullVirtualLabUserCacheModel;
			}
		};

	private static CacheModel<VirtualLabUser> _nullVirtualLabUserCacheModel = new CacheModel<VirtualLabUser>() {
			@Override
			public VirtualLabUser toEntityModel() {
				return _nullVirtualLabUser;
			}
		};
}