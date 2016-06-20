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

import org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException;
import org.kisti.edison.virtuallaboratory.model.VirtualLab;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabImpl;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the virtual lab service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see VirtualLabPersistence
 * @see VirtualLabUtil
 * @generated
 */
public class VirtualLabPersistenceImpl extends BasePersistenceImpl<VirtualLab>
	implements VirtualLabPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VirtualLabUtil} to access the virtual lab persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VirtualLabImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VirtualLabModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabModelImpl.FINDER_CACHE_ENABLED, VirtualLabImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VirtualLabModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabModelImpl.FINDER_CACHE_ENABLED, VirtualLabImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VirtualLabModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public VirtualLabPersistenceImpl() {
		setModelClass(VirtualLab.class);
	}

	/**
	 * Caches the virtual lab in the entity cache if it is enabled.
	 *
	 * @param virtualLab the virtual lab
	 */
	@Override
	public void cacheResult(VirtualLab virtualLab) {
		EntityCacheUtil.putResult(VirtualLabModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabImpl.class, virtualLab.getPrimaryKey(), virtualLab);

		virtualLab.resetOriginalValues();
	}

	/**
	 * Caches the virtual labs in the entity cache if it is enabled.
	 *
	 * @param virtualLabs the virtual labs
	 */
	@Override
	public void cacheResult(List<VirtualLab> virtualLabs) {
		for (VirtualLab virtualLab : virtualLabs) {
			if (EntityCacheUtil.getResult(
						VirtualLabModelImpl.ENTITY_CACHE_ENABLED,
						VirtualLabImpl.class, virtualLab.getPrimaryKey()) == null) {
				cacheResult(virtualLab);
			}
			else {
				virtualLab.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all virtual labs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VirtualLabImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VirtualLabImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the virtual lab.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VirtualLab virtualLab) {
		EntityCacheUtil.removeResult(VirtualLabModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabImpl.class, virtualLab.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VirtualLab> virtualLabs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VirtualLab virtualLab : virtualLabs) {
			EntityCacheUtil.removeResult(VirtualLabModelImpl.ENTITY_CACHE_ENABLED,
				VirtualLabImpl.class, virtualLab.getPrimaryKey());
		}
	}

	/**
	 * Creates a new virtual lab with the primary key. Does not add the virtual lab to the database.
	 *
	 * @param virtualLabId the primary key for the new virtual lab
	 * @return the new virtual lab
	 */
	@Override
	public VirtualLab create(long virtualLabId) {
		VirtualLab virtualLab = new VirtualLabImpl();

		virtualLab.setNew(true);
		virtualLab.setPrimaryKey(virtualLabId);

		return virtualLab;
	}

	/**
	 * Removes the virtual lab with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param virtualLabId the primary key of the virtual lab
	 * @return the virtual lab that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException if a virtual lab with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLab remove(long virtualLabId)
		throws NoSuchVirtualLabException, SystemException {
		return remove((Serializable)virtualLabId);
	}

	/**
	 * Removes the virtual lab with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the virtual lab
	 * @return the virtual lab that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException if a virtual lab with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLab remove(Serializable primaryKey)
		throws NoSuchVirtualLabException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VirtualLab virtualLab = (VirtualLab)session.get(VirtualLabImpl.class,
					primaryKey);

			if (virtualLab == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVirtualLabException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(virtualLab);
		}
		catch (NoSuchVirtualLabException nsee) {
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
	protected VirtualLab removeImpl(VirtualLab virtualLab)
		throws SystemException {
		virtualLab = toUnwrappedModel(virtualLab);

		virtualLabToVirtualLabClassTableMapper.deleteLeftPrimaryKeyTableMappings(virtualLab.getPrimaryKey());

		virtualLabToSurveyTableMapper.deleteLeftPrimaryKeyTableMappings(virtualLab.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(virtualLab)) {
				virtualLab = (VirtualLab)session.get(VirtualLabImpl.class,
						virtualLab.getPrimaryKeyObj());
			}

			if (virtualLab != null) {
				session.delete(virtualLab);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (virtualLab != null) {
			clearCache(virtualLab);
		}

		return virtualLab;
	}

	@Override
	public VirtualLab updateImpl(
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws SystemException {
		virtualLab = toUnwrappedModel(virtualLab);

		boolean isNew = virtualLab.isNew();

		Session session = null;

		try {
			session = openSession();

			if (virtualLab.isNew()) {
				session.save(virtualLab);

				virtualLab.setNew(false);
			}
			else {
				session.merge(virtualLab);
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

		EntityCacheUtil.putResult(VirtualLabModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabImpl.class, virtualLab.getPrimaryKey(), virtualLab);

		return virtualLab;
	}

	protected VirtualLab toUnwrappedModel(VirtualLab virtualLab) {
		if (virtualLab instanceof VirtualLabImpl) {
			return virtualLab;
		}

		VirtualLabImpl virtualLabImpl = new VirtualLabImpl();

		virtualLabImpl.setNew(virtualLab.isNew());
		virtualLabImpl.setPrimaryKey(virtualLab.getPrimaryKey());

		virtualLabImpl.setVirtualLabId(virtualLab.getVirtualLabId());
		virtualLabImpl.setGroupId(virtualLab.getGroupId());
		virtualLabImpl.setUserId(virtualLab.getUserId());
		virtualLabImpl.setVirtualLabPersonName(virtualLab.getVirtualLabPersonName());
		virtualLabImpl.setVirtualLabRequestDt(virtualLab.getVirtualLabRequestDt());
		virtualLabImpl.setVirtualLabConfirmDt(virtualLab.getVirtualLabConfirmDt());
		virtualLabImpl.setVirtualLabConfirmDescription(virtualLab.getVirtualLabConfirmDescription());
		virtualLabImpl.setVirtualLabStatus(virtualLab.getVirtualLabStatus());
		virtualLabImpl.setVirtualLabTitle(virtualLab.getVirtualLabTitle());
		virtualLabImpl.setVirtualLabDescription(virtualLab.getVirtualLabDescription());
		virtualLabImpl.setVirtualLabUseYn(virtualLab.getVirtualLabUseYn());
		virtualLabImpl.setVirtualLabUniversityField(virtualLab.getVirtualLabUniversityField());

		return virtualLabImpl;
	}

	/**
	 * Returns the virtual lab with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the virtual lab
	 * @return the virtual lab
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException if a virtual lab with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLab findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVirtualLabException, SystemException {
		VirtualLab virtualLab = fetchByPrimaryKey(primaryKey);

		if (virtualLab == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVirtualLabException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return virtualLab;
	}

	/**
	 * Returns the virtual lab with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException} if it could not be found.
	 *
	 * @param virtualLabId the primary key of the virtual lab
	 * @return the virtual lab
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabException if a virtual lab with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLab findByPrimaryKey(long virtualLabId)
		throws NoSuchVirtualLabException, SystemException {
		return findByPrimaryKey((Serializable)virtualLabId);
	}

	/**
	 * Returns the virtual lab with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the virtual lab
	 * @return the virtual lab, or <code>null</code> if a virtual lab with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLab fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VirtualLab virtualLab = (VirtualLab)EntityCacheUtil.getResult(VirtualLabModelImpl.ENTITY_CACHE_ENABLED,
				VirtualLabImpl.class, primaryKey);

		if (virtualLab == _nullVirtualLab) {
			return null;
		}

		if (virtualLab == null) {
			Session session = null;

			try {
				session = openSession();

				virtualLab = (VirtualLab)session.get(VirtualLabImpl.class,
						primaryKey);

				if (virtualLab != null) {
					cacheResult(virtualLab);
				}
				else {
					EntityCacheUtil.putResult(VirtualLabModelImpl.ENTITY_CACHE_ENABLED,
						VirtualLabImpl.class, primaryKey, _nullVirtualLab);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VirtualLabModelImpl.ENTITY_CACHE_ENABLED,
					VirtualLabImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return virtualLab;
	}

	/**
	 * Returns the virtual lab with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param virtualLabId the primary key of the virtual lab
	 * @return the virtual lab, or <code>null</code> if a virtual lab with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLab fetchByPrimaryKey(long virtualLabId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)virtualLabId);
	}

	/**
	 * Returns all the virtual labs.
	 *
	 * @return the virtual labs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLab> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the virtual labs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of virtual labs
	 * @param end the upper bound of the range of virtual labs (not inclusive)
	 * @return the range of virtual labs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLab> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the virtual labs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of virtual labs
	 * @param end the upper bound of the range of virtual labs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of virtual labs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLab> findAll(int start, int end,
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

		List<VirtualLab> list = (List<VirtualLab>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIRTUALLAB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIRTUALLAB;

				if (pagination) {
					sql = sql.concat(VirtualLabModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VirtualLab>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VirtualLab>(list);
				}
				else {
					list = (List<VirtualLab>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the virtual labs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VirtualLab virtualLab : findAll()) {
			remove(virtualLab);
		}
	}

	/**
	 * Returns the number of virtual labs.
	 *
	 * @return the number of virtual labs
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

				Query q = session.createQuery(_SQL_COUNT_VIRTUALLAB);

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
	 * Returns all the virtual lab classes associated with the virtual lab.
	 *
	 * @param pk the primary key of the virtual lab
	 * @return the virtual lab classes associated with the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk) throws SystemException {
		return getVirtualLabClasses(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the virtual lab classes associated with the virtual lab.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab
	 * @param start the lower bound of the range of virtual labs
	 * @param end the upper bound of the range of virtual labs (not inclusive)
	 * @return the range of virtual lab classes associated with the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk, int start, int end) throws SystemException {
		return getVirtualLabClasses(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the virtual lab classes associated with the virtual lab.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab
	 * @param start the lower bound of the range of virtual labs
	 * @param end the upper bound of the range of virtual labs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of virtual lab classes associated with the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> getVirtualLabClasses(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return virtualLabToVirtualLabClassTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of virtual lab classes associated with the virtual lab.
	 *
	 * @param pk the primary key of the virtual lab
	 * @return the number of virtual lab classes associated with the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getVirtualLabClassesSize(long pk) throws SystemException {
		long[] pks = virtualLabToVirtualLabClassTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the virtual lab class is associated with the virtual lab.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param virtualLabClassPK the primary key of the virtual lab class
	 * @return <code>true</code> if the virtual lab class is associated with the virtual lab; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsVirtualLabClass(long pk, long virtualLabClassPK)
		throws SystemException {
		return virtualLabToVirtualLabClassTableMapper.containsTableMapping(pk,
			virtualLabClassPK);
	}

	/**
	 * Returns <code>true</code> if the virtual lab has any virtual lab classes associated with it.
	 *
	 * @param pk the primary key of the virtual lab to check for associations with virtual lab classes
	 * @return <code>true</code> if the virtual lab has any virtual lab classes associated with it; <code>false</code> otherwise
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
	 * Adds an association between the virtual lab and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param virtualLabClassPK the primary key of the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClass(long pk, long virtualLabClassPK)
		throws SystemException {
		virtualLabToVirtualLabClassTableMapper.addTableMapping(pk,
			virtualLabClassPK);
	}

	/**
	 * Adds an association between the virtual lab and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param virtualLabClass the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClass(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws SystemException {
		virtualLabToVirtualLabClassTableMapper.addTableMapping(pk,
			virtualLabClass.getPrimaryKey());
	}

	/**
	 * Adds an association between the virtual lab and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param virtualLabClassPKs the primary keys of the virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws SystemException {
		for (long virtualLabClassPK : virtualLabClassPKs) {
			virtualLabToVirtualLabClassTableMapper.addTableMapping(pk,
				virtualLabClassPK);
		}
	}

	/**
	 * Adds an association between the virtual lab and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param virtualLabClasses the virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabClasses(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass : virtualLabClasses) {
			virtualLabToVirtualLabClassTableMapper.addTableMapping(pk,
				virtualLabClass.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the virtual lab and its virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab to clear the associated virtual lab classes from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearVirtualLabClasses(long pk) throws SystemException {
		virtualLabToVirtualLabClassTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the virtual lab and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param virtualLabClassPK the primary key of the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClass(long pk, long virtualLabClassPK)
		throws SystemException {
		virtualLabToVirtualLabClassTableMapper.deleteTableMapping(pk,
			virtualLabClassPK);
	}

	/**
	 * Removes the association between the virtual lab and the virtual lab class. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param virtualLabClass the virtual lab class
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClass(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass)
		throws SystemException {
		virtualLabToVirtualLabClassTableMapper.deleteTableMapping(pk,
			virtualLabClass.getPrimaryKey());
	}

	/**
	 * Removes the association between the virtual lab and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param virtualLabClassPKs the primary keys of the virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws SystemException {
		for (long virtualLabClassPK : virtualLabClassPKs) {
			virtualLabToVirtualLabClassTableMapper.deleteTableMapping(pk,
				virtualLabClassPK);
		}
	}

	/**
	 * Removes the association between the virtual lab and the virtual lab classes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param virtualLabClasses the virtual lab classes
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabClasses(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabClasses)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLabClass virtualLabClass : virtualLabClasses) {
			virtualLabToVirtualLabClassTableMapper.deleteTableMapping(pk,
				virtualLabClass.getPrimaryKey());
		}
	}

	/**
	 * Sets the virtual lab classes associated with the virtual lab, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param virtualLabClassPKs the primary keys of the virtual lab classes to be associated with the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setVirtualLabClasses(long pk, long[] virtualLabClassPKs)
		throws SystemException {
		Set<Long> newVirtualLabClassPKsSet = SetUtil.fromArray(virtualLabClassPKs);
		Set<Long> oldVirtualLabClassPKsSet = SetUtil.fromArray(virtualLabToVirtualLabClassTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeVirtualLabClassPKsSet = new HashSet<Long>(oldVirtualLabClassPKsSet);

		removeVirtualLabClassPKsSet.removeAll(newVirtualLabClassPKsSet);

		for (long removeVirtualLabClassPK : removeVirtualLabClassPKsSet) {
			virtualLabToVirtualLabClassTableMapper.deleteTableMapping(pk,
				removeVirtualLabClassPK);
		}

		newVirtualLabClassPKsSet.removeAll(oldVirtualLabClassPKsSet);

		for (long newVirtualLabClassPK : newVirtualLabClassPKsSet) {
			virtualLabToVirtualLabClassTableMapper.addTableMapping(pk,
				newVirtualLabClassPK);
		}
	}

	/**
	 * Sets the virtual lab classes associated with the virtual lab, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param virtualLabClasses the virtual lab classes to be associated with the virtual lab
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
			FinderCacheUtil.clearCache(VirtualLabModelImpl.MAPPING_TABLE_EDVIR_VIRTUALLABS_VIRTUALLABCLASSES_NAME);
		}
	}

	/**
	 * Returns all the surveies associated with the virtual lab.
	 *
	 * @param pk the primary key of the virtual lab
	 * @return the surveies associated with the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk) throws SystemException {
		return getSurveies(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the surveies associated with the virtual lab.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab
	 * @param start the lower bound of the range of virtual labs
	 * @param end the upper bound of the range of virtual labs (not inclusive)
	 * @return the range of surveies associated with the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk, int start, int end) throws SystemException {
		return getSurveies(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the surveies associated with the virtual lab.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the virtual lab
	 * @param start the lower bound of the range of virtual labs
	 * @param end the upper bound of the range of virtual labs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of surveies associated with the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return virtualLabToSurveyTableMapper.getRightBaseModels(pk, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of surveies associated with the virtual lab.
	 *
	 * @param pk the primary key of the virtual lab
	 * @return the number of surveies associated with the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSurveiesSize(long pk) throws SystemException {
		long[] pks = virtualLabToSurveyTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the survey is associated with the virtual lab.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param surveyPK the primary key of the survey
	 * @return <code>true</code> if the survey is associated with the virtual lab; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsSurvey(long pk, long surveyPK)
		throws SystemException {
		return virtualLabToSurveyTableMapper.containsTableMapping(pk, surveyPK);
	}

	/**
	 * Returns <code>true</code> if the virtual lab has any surveies associated with it.
	 *
	 * @param pk the primary key of the virtual lab to check for associations with surveies
	 * @return <code>true</code> if the virtual lab has any surveies associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsSurveies(long pk) throws SystemException {
		if (getSurveiesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the virtual lab and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param surveyPK the primary key of the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurvey(long pk, long surveyPK) throws SystemException {
		virtualLabToSurveyTableMapper.addTableMapping(pk, surveyPK);
	}

	/**
	 * Adds an association between the virtual lab and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param survey the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurvey(long pk,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws SystemException {
		virtualLabToSurveyTableMapper.addTableMapping(pk, survey.getPrimaryKey());
	}

	/**
	 * Adds an association between the virtual lab and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param surveyPKs the primary keys of the surveies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveies(long pk, long[] surveyPKs)
		throws SystemException {
		for (long surveyPK : surveyPKs) {
			virtualLabToSurveyTableMapper.addTableMapping(pk, surveyPK);
		}
	}

	/**
	 * Adds an association between the virtual lab and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param surveies the surveies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveies(long pk,
		List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.Survey survey : surveies) {
			virtualLabToSurveyTableMapper.addTableMapping(pk,
				survey.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the virtual lab and its surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab to clear the associated surveies from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearSurveies(long pk) throws SystemException {
		virtualLabToSurveyTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the virtual lab and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param surveyPK the primary key of the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurvey(long pk, long surveyPK) throws SystemException {
		virtualLabToSurveyTableMapper.deleteTableMapping(pk, surveyPK);
	}

	/**
	 * Removes the association between the virtual lab and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param survey the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurvey(long pk,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws SystemException {
		virtualLabToSurveyTableMapper.deleteTableMapping(pk,
			survey.getPrimaryKey());
	}

	/**
	 * Removes the association between the virtual lab and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param surveyPKs the primary keys of the surveies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveies(long pk, long[] surveyPKs)
		throws SystemException {
		for (long surveyPK : surveyPKs) {
			virtualLabToSurveyTableMapper.deleteTableMapping(pk, surveyPK);
		}
	}

	/**
	 * Removes the association between the virtual lab and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param surveies the surveies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveies(long pk,
		List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.Survey survey : surveies) {
			virtualLabToSurveyTableMapper.deleteTableMapping(pk,
				survey.getPrimaryKey());
		}
	}

	/**
	 * Sets the surveies associated with the virtual lab, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param surveyPKs the primary keys of the surveies to be associated with the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setSurveies(long pk, long[] surveyPKs)
		throws SystemException {
		Set<Long> newSurveyPKsSet = SetUtil.fromArray(surveyPKs);
		Set<Long> oldSurveyPKsSet = SetUtil.fromArray(virtualLabToSurveyTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeSurveyPKsSet = new HashSet<Long>(oldSurveyPKsSet);

		removeSurveyPKsSet.removeAll(newSurveyPKsSet);

		for (long removeSurveyPK : removeSurveyPKsSet) {
			virtualLabToSurveyTableMapper.deleteTableMapping(pk, removeSurveyPK);
		}

		newSurveyPKsSet.removeAll(oldSurveyPKsSet);

		for (long newSurveyPK : newSurveyPKsSet) {
			virtualLabToSurveyTableMapper.addTableMapping(pk, newSurveyPK);
		}
	}

	/**
	 * Sets the surveies associated with the virtual lab, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the virtual lab
	 * @param surveies the surveies to be associated with the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setSurveies(long pk,
		List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws SystemException {
		try {
			long[] surveyPKs = new long[surveies.size()];

			for (int i = 0; i < surveies.size(); i++) {
				org.kisti.edison.virtuallaboratory.model.Survey survey = surveies.get(i);

				surveyPKs[i] = survey.getPrimaryKey();
			}

			setSurveies(pk, surveyPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(VirtualLabModelImpl.MAPPING_TABLE_EDVIR_VIRTUALLABS_SURVEYS_NAME);
		}
	}

	/**
	 * Initializes the virtual lab persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.virtuallaboratory.model.VirtualLab")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VirtualLab>> listenersList = new ArrayList<ModelListener<VirtualLab>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VirtualLab>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		virtualLabToVirtualLabClassTableMapper = TableMapperFactory.getTableMapper("EDVIR_VirtualLabs_VirtualLabClasses",
				"virtualLabId", "classId", this, virtualLabClassPersistence);

		virtualLabToSurveyTableMapper = TableMapperFactory.getTableMapper("EDVIR_VirtualLabs_Surveys",
				"virtualLabId", "surveySeqNo", this, surveyPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(VirtualLabImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"EDVIR_VirtualLabs_VirtualLabClasses");
		TableMapperFactory.removeTableMapper("EDVIR_VirtualLabs_Surveys");
	}

	@BeanReference(type = VirtualLabClassPersistence.class)
	protected VirtualLabClassPersistence virtualLabClassPersistence;
	protected TableMapper<VirtualLab, org.kisti.edison.virtuallaboratory.model.VirtualLabClass> virtualLabToVirtualLabClassTableMapper;
	@BeanReference(type = SurveyPersistence.class)
	protected SurveyPersistence surveyPersistence;
	protected TableMapper<VirtualLab, org.kisti.edison.virtuallaboratory.model.Survey> virtualLabToSurveyTableMapper;
	private static final String _SQL_SELECT_VIRTUALLAB = "SELECT virtualLab FROM VirtualLab virtualLab";
	private static final String _SQL_COUNT_VIRTUALLAB = "SELECT COUNT(virtualLab) FROM VirtualLab virtualLab";
	private static final String _ORDER_BY_ENTITY_ALIAS = "virtualLab.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VirtualLab exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VirtualLabPersistenceImpl.class);
	private static VirtualLab _nullVirtualLab = new VirtualLabImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VirtualLab> toCacheModel() {
				return _nullVirtualLabCacheModel;
			}
		};

	private static CacheModel<VirtualLab> _nullVirtualLabCacheModel = new CacheModel<VirtualLab>() {
			@Override
			public VirtualLab toEntityModel() {
				return _nullVirtualLab;
			}
		};
}