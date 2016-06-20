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

import org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException;
import org.kisti.edison.virtuallaboratory.model.VirtualLabClass;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassImpl;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the virtual lab class service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see VirtualLabClassPersistence
 * @see VirtualLabClassUtil
 * @generated
 */
public class VirtualLabClassPersistenceImpl extends BasePersistenceImpl<VirtualLabClass>
	implements VirtualLabClassPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VirtualLabClassUtil} to access the virtual lab class persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VirtualLabClassImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VirtualLabClassModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassModelImpl.FINDER_CACHE_ENABLED,
			VirtualLabClassImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VirtualLabClassModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassModelImpl.FINDER_CACHE_ENABLED,
			VirtualLabClassImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VirtualLabClassModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public VirtualLabClassPersistenceImpl() {
		setModelClass(VirtualLabClass.class);
	}

	/**
	 * Caches the virtual lab class in the entity cache if it is enabled.
	 *
	 * @param virtualLabClass the virtual lab class
	 */
	@Override
	public void cacheResult(VirtualLabClass virtualLabClass) {
		EntityCacheUtil.putResult(VirtualLabClassModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassImpl.class, virtualLabClass.getPrimaryKey(),
			virtualLabClass);

		virtualLabClass.resetOriginalValues();
	}

	/**
	 * Caches the virtual lab classes in the entity cache if it is enabled.
	 *
	 * @param virtualLabClasses the virtual lab classes
	 */
	@Override
	public void cacheResult(List<VirtualLabClass> virtualLabClasses) {
		for (VirtualLabClass virtualLabClass : virtualLabClasses) {
			if (EntityCacheUtil.getResult(
						VirtualLabClassModelImpl.ENTITY_CACHE_ENABLED,
						VirtualLabClassImpl.class,
						virtualLabClass.getPrimaryKey()) == null) {
				cacheResult(virtualLabClass);
			}
			else {
				virtualLabClass.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all virtual lab classes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VirtualLabClassImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VirtualLabClassImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the virtual lab class.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VirtualLabClass virtualLabClass) {
		EntityCacheUtil.removeResult(VirtualLabClassModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassImpl.class, virtualLabClass.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VirtualLabClass> virtualLabClasses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VirtualLabClass virtualLabClass : virtualLabClasses) {
			EntityCacheUtil.removeResult(VirtualLabClassModelImpl.ENTITY_CACHE_ENABLED,
				VirtualLabClassImpl.class, virtualLabClass.getPrimaryKey());
		}
	}

	/**
	 * Creates a new virtual lab class with the primary key. Does not add the virtual lab class to the database.
	 *
	 * @param classId the primary key for the new virtual lab class
	 * @return the new virtual lab class
	 */
	@Override
	public VirtualLabClass create(long classId) {
		VirtualLabClass virtualLabClass = new VirtualLabClassImpl();

		virtualLabClass.setNew(true);
		virtualLabClass.setPrimaryKey(classId);

		return virtualLabClass;
	}

	/**
	 * Removes the virtual lab class with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param classId the primary key of the virtual lab class
	 * @return the virtual lab class that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException if a virtual lab class with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClass remove(long classId)
		throws NoSuchVirtualLabClassException, SystemException {
		return remove((Serializable)classId);
	}

	/**
	 * Removes the virtual lab class with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the virtual lab class
	 * @return the virtual lab class that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException if a virtual lab class with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClass remove(Serializable primaryKey)
		throws NoSuchVirtualLabClassException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VirtualLabClass virtualLabClass = (VirtualLabClass)session.get(VirtualLabClassImpl.class,
					primaryKey);

			if (virtualLabClass == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVirtualLabClassException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(virtualLabClass);
		}
		catch (NoSuchVirtualLabClassException nsee) {
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
	protected VirtualLabClass removeImpl(VirtualLabClass virtualLabClass)
		throws SystemException {
		virtualLabClass = toUnwrappedModel(virtualLabClass);

		virtualLabClassToVirtualLabTableMapper.deleteLeftPrimaryKeyTableMappings(virtualLabClass.getPrimaryKey());

		virtualLabClassToVirtualLabClassScienceAppTableMapper.deleteLeftPrimaryKeyTableMappings(virtualLabClass.getPrimaryKey());

		virtualLabClassToVirtualLabUserTableMapper.deleteLeftPrimaryKeyTableMappings(virtualLabClass.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(virtualLabClass)) {
				virtualLabClass = (VirtualLabClass)session.get(VirtualLabClassImpl.class,
						virtualLabClass.getPrimaryKeyObj());
			}

			if (virtualLabClass != null) {
				session.delete(virtualLabClass);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (virtualLabClass != null) {
			clearCache(virtualLabClass);
		}

		return virtualLabClass;
	}

	@Override
	public VirtualLabClass updateImpl(
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws SystemException {
		virtualLabClass = toUnwrappedModel(virtualLabClass);

		boolean isNew = virtualLabClass.isNew();

		Session session = null;

		try {
			session = openSession();

			if (virtualLabClass.isNew()) {
				session.save(virtualLabClass);

				virtualLabClass.setNew(false);
			}
			else {
				session.merge(virtualLabClass);
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

		EntityCacheUtil.putResult(VirtualLabClassModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabClassImpl.class, virtualLabClass.getPrimaryKey(),
			virtualLabClass);

		return virtualLabClass;
	}

	protected VirtualLabClass toUnwrappedModel(VirtualLabClass virtualLabClass) {
		if (virtualLabClass instanceof VirtualLabClassImpl) {
			return virtualLabClass;
		}

		VirtualLabClassImpl virtualLabClassImpl = new VirtualLabClassImpl();

		virtualLabClassImpl.setNew(virtualLabClass.isNew());
		virtualLabClassImpl.setPrimaryKey(virtualLabClass.getPrimaryKey());

		virtualLabClassImpl.setClassId(virtualLabClass.getClassId());
		virtualLabClassImpl.setClassTitle(virtualLabClass.getClassTitle());
		virtualLabClassImpl.setClassStartDt(virtualLabClass.getClassStartDt());
		virtualLabClassImpl.setClassEndDt(virtualLabClass.getClassEndDt());
		virtualLabClassImpl.setClassUseYn(virtualLabClass.getClassUseYn());
		virtualLabClassImpl.setClassDescription(virtualLabClass.getClassDescription());
		virtualLabClassImpl.setClassPersonnel(virtualLabClass.getClassPersonnel());
		virtualLabClassImpl.setClassCreateDt(virtualLabClass.getClassCreateDt());
		virtualLabClassImpl.setClassUpdateDt(virtualLabClass.getClassUpdateDt());
		virtualLabClassImpl.setVirtualClassCd(virtualLabClass.getVirtualClassCd());

		return virtualLabClassImpl;
	}

	/**
	 * Returns the virtual lab class with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the virtual lab class
	 * @return the virtual lab class
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException if a virtual lab class with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClass findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVirtualLabClassException, SystemException {
		VirtualLabClass virtualLabClass = fetchByPrimaryKey(primaryKey);

		if (virtualLabClass == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVirtualLabClassException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return virtualLabClass;
	}

	/**
	 * Returns the virtual lab class with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException} if it could not be found.
	 *
	 * @param classId the primary key of the virtual lab class
	 * @return the virtual lab class
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabClassException if a virtual lab class with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClass findByPrimaryKey(long classId)
		throws NoSuchVirtualLabClassException, SystemException {
		return findByPrimaryKey((Serializable)classId);
	}

	/**
	 * Returns the virtual lab class with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the virtual lab class
	 * @return the virtual lab class, or <code>null</code> if a virtual lab class with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClass fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VirtualLabClass virtualLabClass = (VirtualLabClass)EntityCacheUtil.getResult(VirtualLabClassModelImpl.ENTITY_CACHE_ENABLED,
				VirtualLabClassImpl.class, primaryKey);

		if (virtualLabClass == _nullVirtualLabClass) {
			return null;
		}

		if (virtualLabClass == null) {
			Session session = null;

			try {
				session = openSession();

				virtualLabClass = (VirtualLabClass)session.get(VirtualLabClassImpl.class,
						primaryKey);

				if (virtualLabClass != null) {
					cacheResult(virtualLabClass);
				}
				else {
					EntityCacheUtil.putResult(VirtualLabClassModelImpl.ENTITY_CACHE_ENABLED,
						VirtualLabClassImpl.class, primaryKey,
						_nullVirtualLabClass);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VirtualLabClassModelImpl.ENTITY_CACHE_ENABLED,
					VirtualLabClassImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return virtualLabClass;
	}

	/**
	 * Returns the virtual lab class with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param classId the primary key of the virtual lab class
	 * @return the virtual lab class, or <code>null</code> if a virtual lab class with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabClass fetchByPrimaryKey(long classId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)classId);
	}

	/**
	 * Returns all the virtual lab classes.
	 *
	 * @return the virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabClass> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the virtual lab classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of virtual lab classes
	 * @param end the upper bound of the range of virtual lab classes (not inclusive)
	 * @return the range of virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabClass> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the virtual lab classes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of virtual lab classes
	 * @param end the upper bound of the range of virtual lab classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabClass> findAll(int start, int end,
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

		List<VirtualLabClass> list = (List<VirtualLabClass>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIRTUALLABCLASS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIRTUALLABCLASS;

				if (pagination) {
					sql = sql.concat(VirtualLabClassModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VirtualLabClass>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VirtualLabClass>(list);
				}
				else {
					list = (List<VirtualLabClass>)QueryUtil.list(q,
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
	 * Removes all the virtual lab classes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VirtualLabClass virtualLabClass : findAll()) {
			remove(virtualLabClass);
		}
	}

	/**
	 * Returns the number of virtual lab classes.
	 *
	 * @return the number of virtual lab classes
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

				Query q = session.createQuery(_SQL_COUNT_VIRTUALLABCLASS);

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
	 * Returns all the virtual labs associated with the virtual lab class.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @return the virtual labs associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		long pk) throws SystemException {
		return getVirtualLabs(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the virtual labs associated with the virtual lab class.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param start the lower bound of the range of virtual lab classes
	 * @param end the upper bound of the range of virtual lab classes (not inclusive)
	 * @return the range of virtual labs associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		long pk, int start, int end) throws SystemException {
		return getVirtualLabs(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the virtual labs associated with the virtual lab class.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param start the lower bound of the range of virtual lab classes
	 * @param end the upper bound of the range of virtual lab classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of virtual labs associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return virtualLabClassToVirtualLabTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of virtual labs associated with the virtual lab class.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @return the number of virtual labs associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getVirtualLabsSize(long pk) throws SystemException {
		long[] pks = virtualLabClassToVirtualLabTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the virtual lab is associated with the virtual lab class.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabPK the primary key of the virtual lab
	 * @return <code>true</code> if the virtual lab is associated with the virtual lab class; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsVirtualLab(long pk, long virtualLabPK)
		throws SystemException {
		return virtualLabClassToVirtualLabTableMapper.containsTableMapping(pk,
			virtualLabPK);
	}

	/**
	 * Returns <code>true</code> if the virtual lab class has any virtual labs associated with it.
	 *
	 * @param pk the primary key of the virtual lab class to check for associations with virtual labs
	 * @return <code>true</code> if the virtual lab class has any virtual labs associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsVirtualLabs(long pk) throws SystemException {
		if (getVirtualLabsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the virtual lab class and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabPK the primary key of the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLab(long pk, long virtualLabPK)
		throws SystemException {
		virtualLabClassToVirtualLabTableMapper.addTableMapping(pk, virtualLabPK);
	}

	/**
	 * Adds an association between the virtual lab class and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLab the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLab(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws SystemException {
		virtualLabClassToVirtualLabTableMapper.addTableMapping(pk,
			virtualLab.getPrimaryKey());
	}

	/**
	 * Adds an association between the virtual lab class and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabPKs the primary keys of the virtual labs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabs(long pk, long[] virtualLabPKs)
		throws SystemException {
		for (long virtualLabPK : virtualLabPKs) {
			virtualLabClassToVirtualLabTableMapper.addTableMapping(pk,
				virtualLabPK);
		}
	}

	/**
	 * Adds an association between the virtual lab class and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabs the virtual labs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabs(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabs)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab : virtualLabs) {
			virtualLabClassToVirtualLabTableMapper.addTableMapping(pk,
				virtualLab.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the virtual lab class and its virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class to clear the associated virtual labs from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearVirtualLabs(long pk) throws SystemException {
		virtualLabClassToVirtualLabTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the virtual lab class and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabPK the primary key of the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLab(long pk, long virtualLabPK)
		throws SystemException {
		virtualLabClassToVirtualLabTableMapper.deleteTableMapping(pk,
			virtualLabPK);
	}

	/**
	 * Removes the association between the virtual lab class and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLab the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLab(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws SystemException {
		virtualLabClassToVirtualLabTableMapper.deleteTableMapping(pk,
			virtualLab.getPrimaryKey());
	}

	/**
	 * Removes the association between the virtual lab class and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabPKs the primary keys of the virtual labs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabs(long pk, long[] virtualLabPKs)
		throws SystemException {
		for (long virtualLabPK : virtualLabPKs) {
			virtualLabClassToVirtualLabTableMapper.deleteTableMapping(pk,
				virtualLabPK);
		}
	}

	/**
	 * Removes the association between the virtual lab class and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabs the virtual labs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabs(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabs)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab : virtualLabs) {
			virtualLabClassToVirtualLabTableMapper.deleteTableMapping(pk,
				virtualLab.getPrimaryKey());
		}
	}

	/**
	 * Sets the virtual labs associated with the virtual lab class, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabPKs the primary keys of the virtual labs to be associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setVirtualLabs(long pk, long[] virtualLabPKs)
		throws SystemException {
		Set<Long> newVirtualLabPKsSet = SetUtil.fromArray(virtualLabPKs);
		Set<Long> oldVirtualLabPKsSet = SetUtil.fromArray(virtualLabClassToVirtualLabTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeVirtualLabPKsSet = new HashSet<Long>(oldVirtualLabPKsSet);

		removeVirtualLabPKsSet.removeAll(newVirtualLabPKsSet);

		for (long removeVirtualLabPK : removeVirtualLabPKsSet) {
			virtualLabClassToVirtualLabTableMapper.deleteTableMapping(pk,
				removeVirtualLabPK);
		}

		newVirtualLabPKsSet.removeAll(oldVirtualLabPKsSet);

		for (long newVirtualLabPK : newVirtualLabPKsSet) {
			virtualLabClassToVirtualLabTableMapper.addTableMapping(pk,
				newVirtualLabPK);
		}
	}

	/**
	 * Sets the virtual labs associated with the virtual lab class, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabs the virtual labs to be associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setVirtualLabs(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabs)
		throws SystemException {
		try {
			long[] virtualLabPKs = new long[virtualLabs.size()];

			for (int i = 0; i < virtualLabs.size(); i++) {
				org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab = virtualLabs.get(i);

				virtualLabPKs[i] = virtualLab.getPrimaryKey();
			}

			setVirtualLabs(pk, virtualLabPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(VirtualLabClassModelImpl.MAPPING_TABLE_EDVIR_VIRTUALLABS_VIRTUALLABCLASSES_NAME);
		}
	}

	/**
	 * Returns all the virtual lab class science apps associated with the virtual lab class.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @return the virtual lab class science apps associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassScienceApps(
		long pk) throws SystemException {
		return getVirtualLabClassScienceApps(pk, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the virtual lab class science apps associated with the virtual lab class.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param start the lower bound of the range of virtual lab classes
	 * @param end the upper bound of the range of virtual lab classes (not inclusive)
	 * @return the range of virtual lab class science apps associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassScienceApps(
		long pk, int start, int end) throws SystemException {
		return getVirtualLabClassScienceApps(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the virtual lab class science apps associated with the virtual lab class.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param start the lower bound of the range of virtual lab classes
	 * @param end the upper bound of the range of virtual lab classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of virtual lab class science apps associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> getVirtualLabClassScienceApps(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return virtualLabClassToVirtualLabClassScienceAppTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of virtual lab class science apps associated with the virtual lab class.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @return the number of virtual lab class science apps associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getVirtualLabClassScienceAppsSize(long pk)
		throws SystemException {
		long[] pks = virtualLabClassToVirtualLabClassScienceAppTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the virtual lab class science app is associated with the virtual lab class.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabClassScienceAppPK the primary key of the virtual lab class science app
	 * @return <code>true</code> if the virtual lab class science app is associated with the virtual lab class; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsVirtualLabClassScienceApp(long pk,
		long virtualLabClassScienceAppPK) throws SystemException {
		return virtualLabClassToVirtualLabClassScienceAppTableMapper.containsTableMapping(pk,
			virtualLabClassScienceAppPK);
	}

	/**
	 * Returns <code>true</code> if the virtual lab class has any virtual lab class science apps associated with it.
	 *
	 * @param pk the primary key of the virtual lab class to check for associations with virtual lab class science apps
	 * @return <code>true</code> if the virtual lab class has any virtual lab class science apps associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsVirtualLabClassScienceApps(long pk)
		throws SystemException {
		if (getVirtualLabClassScienceAppsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the virtual lab class and the virtual lab class science app. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabClassScienceAppPK the primary key of the virtual lab class science app
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClassScienceApp(long pk,
		long virtualLabClassScienceAppPK) throws SystemException {
		virtualLabClassToVirtualLabClassScienceAppTableMapper.addTableMapping(pk,
			virtualLabClassScienceAppPK);
	}

	/**
	 * Adds an association between the virtual lab class and the virtual lab class science app. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabClassScienceApp the virtual lab class science app
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClassScienceApp(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws SystemException {
		virtualLabClassToVirtualLabClassScienceAppTableMapper.addTableMapping(pk,
			virtualLabClassScienceApp.getPrimaryKey());
	}

	/**
	 * Adds an association between the virtual lab class and the virtual lab class science apps. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabClassScienceAppPKs the primary keys of the virtual lab class science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClassScienceApps(long pk,
		long[] virtualLabClassScienceAppPKs) throws SystemException {
		for (long virtualLabClassScienceAppPK : virtualLabClassScienceAppPKs) {
			virtualLabClassToVirtualLabClassScienceAppTableMapper.addTableMapping(pk,
				virtualLabClassScienceAppPK);
		}
	}

	/**
	 * Adds an association between the virtual lab class and the virtual lab class science apps. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabClassScienceApps the virtual lab class science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClassScienceApps(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> virtualLabClassScienceApps)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp : virtualLabClassScienceApps) {
			virtualLabClassToVirtualLabClassScienceAppTableMapper.addTableMapping(pk,
				virtualLabClassScienceApp.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the virtual lab class and its virtual lab class science apps. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class to clear the associated virtual lab class science apps from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearVirtualLabClassScienceApps(long pk)
		throws SystemException {
		virtualLabClassToVirtualLabClassScienceAppTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the virtual lab class and the virtual lab class science app. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabClassScienceAppPK the primary key of the virtual lab class science app
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClassScienceApp(long pk,
		long virtualLabClassScienceAppPK) throws SystemException {
		virtualLabClassToVirtualLabClassScienceAppTableMapper.deleteTableMapping(pk,
			virtualLabClassScienceAppPK);
	}

	/**
	 * Removes the association between the virtual lab class and the virtual lab class science app. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabClassScienceApp the virtual lab class science app
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClassScienceApp(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp)
		throws SystemException {
		virtualLabClassToVirtualLabClassScienceAppTableMapper.deleteTableMapping(pk,
			virtualLabClassScienceApp.getPrimaryKey());
	}

	/**
	 * Removes the association between the virtual lab class and the virtual lab class science apps. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabClassScienceAppPKs the primary keys of the virtual lab class science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClassScienceApps(long pk,
		long[] virtualLabClassScienceAppPKs) throws SystemException {
		for (long virtualLabClassScienceAppPK : virtualLabClassScienceAppPKs) {
			virtualLabClassToVirtualLabClassScienceAppTableMapper.deleteTableMapping(pk,
				virtualLabClassScienceAppPK);
		}
	}

	/**
	 * Removes the association between the virtual lab class and the virtual lab class science apps. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabClassScienceApps the virtual lab class science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClassScienceApps(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> virtualLabClassScienceApps)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp : virtualLabClassScienceApps) {
			virtualLabClassToVirtualLabClassScienceAppTableMapper.deleteTableMapping(pk,
				virtualLabClassScienceApp.getPrimaryKey());
		}
	}

	/**
	 * Sets the virtual lab class science apps associated with the virtual lab class, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabClassScienceAppPKs the primary keys of the virtual lab class science apps to be associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setVirtualLabClassScienceApps(long pk,
		long[] virtualLabClassScienceAppPKs) throws SystemException {
		Set<Long> newVirtualLabClassScienceAppPKsSet = SetUtil.fromArray(virtualLabClassScienceAppPKs);
		Set<Long> oldVirtualLabClassScienceAppPKsSet = SetUtil.fromArray(virtualLabClassToVirtualLabClassScienceAppTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeVirtualLabClassScienceAppPKsSet = new HashSet<Long>(oldVirtualLabClassScienceAppPKsSet);

		removeVirtualLabClassScienceAppPKsSet.removeAll(newVirtualLabClassScienceAppPKsSet);

		for (long removeVirtualLabClassScienceAppPK : removeVirtualLabClassScienceAppPKsSet) {
			virtualLabClassToVirtualLabClassScienceAppTableMapper.deleteTableMapping(pk,
				removeVirtualLabClassScienceAppPK);
		}

		newVirtualLabClassScienceAppPKsSet.removeAll(oldVirtualLabClassScienceAppPKsSet);

		for (long newVirtualLabClassScienceAppPK : newVirtualLabClassScienceAppPKsSet) {
			virtualLabClassToVirtualLabClassScienceAppTableMapper.addTableMapping(pk,
				newVirtualLabClassScienceAppPK);
		}
	}

	/**
	 * Sets the virtual lab class science apps associated with the virtual lab class, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabClassScienceApps the virtual lab class science apps to be associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setVirtualLabClassScienceApps(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> virtualLabClassScienceApps)
		throws SystemException {
		try {
			long[] virtualLabClassScienceAppPKs = new long[virtualLabClassScienceApps.size()];

			for (int i = 0; i < virtualLabClassScienceApps.size(); i++) {
				org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp virtualLabClassScienceApp =
					virtualLabClassScienceApps.get(i);

				virtualLabClassScienceAppPKs[i] = virtualLabClassScienceApp.getPrimaryKey();
			}

			setVirtualLabClassScienceApps(pk, virtualLabClassScienceAppPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(VirtualLabClassModelImpl.MAPPING_TABLE_EDVIR_VIRTUALLABCLASSES_VIRTUALLABCLASSSCIENCEAPPS_NAME);
		}
	}

	/**
	 * Returns all the virtual lab users associated with the virtual lab class.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @return the virtual lab users associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabUsers(
		long pk) throws SystemException {
		return getVirtualLabUsers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the virtual lab users associated with the virtual lab class.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param start the lower bound of the range of virtual lab classes
	 * @param end the upper bound of the range of virtual lab classes (not inclusive)
	 * @return the range of virtual lab users associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabUsers(
		long pk, int start, int end) throws SystemException {
		return getVirtualLabUsers(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the virtual lab users associated with the virtual lab class.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabClassModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param start the lower bound of the range of virtual lab classes
	 * @param end the upper bound of the range of virtual lab classes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of virtual lab users associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> getVirtualLabUsers(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return virtualLabClassToVirtualLabUserTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of virtual lab users associated with the virtual lab class.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @return the number of virtual lab users associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getVirtualLabUsersSize(long pk) throws SystemException {
		long[] pks = virtualLabClassToVirtualLabUserTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the virtual lab user is associated with the virtual lab class.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabUserPK the primary key of the virtual lab user
	 * @return <code>true</code> if the virtual lab user is associated with the virtual lab class; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsVirtualLabUser(long pk, long virtualLabUserPK)
		throws SystemException {
		return virtualLabClassToVirtualLabUserTableMapper.containsTableMapping(pk,
			virtualLabUserPK);
	}

	/**
	 * Returns <code>true</code> if the virtual lab class has any virtual lab users associated with it.
	 *
	 * @param pk the primary key of the virtual lab class to check for associations with virtual lab users
	 * @return <code>true</code> if the virtual lab class has any virtual lab users associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsVirtualLabUsers(long pk) throws SystemException {
		if (getVirtualLabUsersSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the virtual lab class and the virtual lab user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabUserPK the primary key of the virtual lab user
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabUser(long pk, long virtualLabUserPK)
		throws SystemException {
		virtualLabClassToVirtualLabUserTableMapper.addTableMapping(pk,
			virtualLabUserPK);
	}

	/**
	 * Adds an association between the virtual lab class and the virtual lab user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabUser the virtual lab user
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabUser(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws SystemException {
		virtualLabClassToVirtualLabUserTableMapper.addTableMapping(pk,
			virtualLabUser.getPrimaryKey());
	}

	/**
	 * Adds an association between the virtual lab class and the virtual lab users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabUserPKs the primary keys of the virtual lab users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabUsers(long pk, long[] virtualLabUserPKs)
		throws SystemException {
		for (long virtualLabUserPK : virtualLabUserPKs) {
			virtualLabClassToVirtualLabUserTableMapper.addTableMapping(pk,
				virtualLabUserPK);
		}
	}

	/**
	 * Adds an association between the virtual lab class and the virtual lab users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabUsers the virtual lab users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabUsers(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> virtualLabUsers)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser : virtualLabUsers) {
			virtualLabClassToVirtualLabUserTableMapper.addTableMapping(pk,
				virtualLabUser.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the virtual lab class and its virtual lab users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class to clear the associated virtual lab users from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearVirtualLabUsers(long pk) throws SystemException {
		virtualLabClassToVirtualLabUserTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the virtual lab class and the virtual lab user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabUserPK the primary key of the virtual lab user
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabUser(long pk, long virtualLabUserPK)
		throws SystemException {
		virtualLabClassToVirtualLabUserTableMapper.deleteTableMapping(pk,
			virtualLabUserPK);
	}

	/**
	 * Removes the association between the virtual lab class and the virtual lab user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabUser the virtual lab user
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabUser(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser)
		throws SystemException {
		virtualLabClassToVirtualLabUserTableMapper.deleteTableMapping(pk,
			virtualLabUser.getPrimaryKey());
	}

	/**
	 * Removes the association between the virtual lab class and the virtual lab users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabUserPKs the primary keys of the virtual lab users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabUsers(long pk, long[] virtualLabUserPKs)
		throws SystemException {
		for (long virtualLabUserPK : virtualLabUserPKs) {
			virtualLabClassToVirtualLabUserTableMapper.deleteTableMapping(pk,
				virtualLabUserPK);
		}
	}

	/**
	 * Removes the association between the virtual lab class and the virtual lab users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabUsers the virtual lab users
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabUsers(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> virtualLabUsers)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser : virtualLabUsers) {
			virtualLabClassToVirtualLabUserTableMapper.deleteTableMapping(pk,
				virtualLabUser.getPrimaryKey());
		}
	}

	/**
	 * Sets the virtual lab users associated with the virtual lab class, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabUserPKs the primary keys of the virtual lab users to be associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setVirtualLabUsers(long pk, long[] virtualLabUserPKs)
		throws SystemException {
		Set<Long> newVirtualLabUserPKsSet = SetUtil.fromArray(virtualLabUserPKs);
		Set<Long> oldVirtualLabUserPKsSet = SetUtil.fromArray(virtualLabClassToVirtualLabUserTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeVirtualLabUserPKsSet = new HashSet<Long>(oldVirtualLabUserPKsSet);

		removeVirtualLabUserPKsSet.removeAll(newVirtualLabUserPKsSet);

		for (long removeVirtualLabUserPK : removeVirtualLabUserPKsSet) {
			virtualLabClassToVirtualLabUserTableMapper.deleteTableMapping(pk,
				removeVirtualLabUserPK);
		}

		newVirtualLabUserPKsSet.removeAll(oldVirtualLabUserPKsSet);

		for (long newVirtualLabUserPK : newVirtualLabUserPKsSet) {
			virtualLabClassToVirtualLabUserTableMapper.addTableMapping(pk,
				newVirtualLabUserPK);
		}
	}

	/**
	 * Sets the virtual lab users associated with the virtual lab class, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab class
	 * @param virtualLabUsers the virtual lab users to be associated with the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setVirtualLabUsers(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLabUser> virtualLabUsers)
		throws SystemException {
		try {
			long[] virtualLabUserPKs = new long[virtualLabUsers.size()];

			for (int i = 0; i < virtualLabUsers.size(); i++) {
				org.kisti.edison.virtuallaboratory.model.VirtualLabUser virtualLabUser =
					virtualLabUsers.get(i);

				virtualLabUserPKs[i] = virtualLabUser.getPrimaryKey();
			}

			setVirtualLabUsers(pk, virtualLabUserPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(VirtualLabClassModelImpl.MAPPING_TABLE_EDVIR_VIRTUALLABCLASSES_VIRTUALLABUSERS_NAME);
		}
	}

	/**
	 * Initializes the virtual lab class persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.virtuallaboratory.model.VirtualLabClass")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VirtualLabClass>> listenersList = new ArrayList<ModelListener<VirtualLabClass>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VirtualLabClass>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		virtualLabClassToVirtualLabTableMapper = TableMapperFactory.getTableMapper("EDVIR_VirtualLabs_VirtualLabClasses",
				"classId", "virtualLabId", this, virtualLabPersistence);

		virtualLabClassToVirtualLabClassScienceAppTableMapper = TableMapperFactory.getTableMapper("EDVIR_VirtualLabClasses_VirtualLabClassScienceApps",
				"classId", "scienceAppSeqNo", this,
				virtualLabClassScienceAppPersistence);

		virtualLabClassToVirtualLabUserTableMapper = TableMapperFactory.getTableMapper("EDVIR_VirtualLabClasses_VirtualLabUsers",
				"classId", "virtualLabUserId", this, virtualLabUserPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(VirtualLabClassImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"EDVIR_VirtualLabs_VirtualLabClasses");
		TableMapperFactory.removeTableMapper(
			"EDVIR_VirtualLabClasses_VirtualLabClassScienceApps");
		TableMapperFactory.removeTableMapper(
			"EDVIR_VirtualLabClasses_VirtualLabUsers");
	}

	@BeanReference(type = VirtualLabPersistence.class)
	protected VirtualLabPersistence virtualLabPersistence;
	protected TableMapper<VirtualLabClass, org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabClassToVirtualLabTableMapper;
	@BeanReference(type = VirtualLabClassScienceAppPersistence.class)
	protected VirtualLabClassScienceAppPersistence virtualLabClassScienceAppPersistence;
	protected TableMapper<VirtualLabClass, org.kisti.edison.virtuallaboratory.model.VirtualLabClassScienceApp> virtualLabClassToVirtualLabClassScienceAppTableMapper;
	@BeanReference(type = VirtualLabUserPersistence.class)
	protected VirtualLabUserPersistence virtualLabUserPersistence;
	protected TableMapper<VirtualLabClass, org.kisti.edison.virtuallaboratory.model.VirtualLabUser> virtualLabClassToVirtualLabUserTableMapper;
	private static final String _SQL_SELECT_VIRTUALLABCLASS = "SELECT virtualLabClass FROM VirtualLabClass virtualLabClass";
	private static final String _SQL_COUNT_VIRTUALLABCLASS = "SELECT COUNT(virtualLabClass) FROM VirtualLabClass virtualLabClass";
	private static final String _ORDER_BY_ENTITY_ALIAS = "virtualLabClass.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VirtualLabClass exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VirtualLabClassPersistenceImpl.class);
	private static VirtualLabClass _nullVirtualLabClass = new VirtualLabClassImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VirtualLabClass> toCacheModel() {
				return _nullVirtualLabClassCacheModel;
			}
		};

	private static CacheModel<VirtualLabClass> _nullVirtualLabClassCacheModel = new CacheModel<VirtualLabClass>() {
			@Override
			public VirtualLabClass toEntityModel() {
				return _nullVirtualLabClass;
			}
		};
}