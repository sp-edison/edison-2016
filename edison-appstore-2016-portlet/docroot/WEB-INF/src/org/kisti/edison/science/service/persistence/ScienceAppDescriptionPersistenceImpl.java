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

import org.kisti.edison.science.NoSuchScienceAppDescriptionException;
import org.kisti.edison.science.model.ScienceAppDescription;
import org.kisti.edison.science.model.impl.ScienceAppDescriptionImpl;
import org.kisti.edison.science.model.impl.ScienceAppDescriptionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the science app description service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see ScienceAppDescriptionPersistence
 * @see ScienceAppDescriptionUtil
 * @generated
 */
public class ScienceAppDescriptionPersistenceImpl extends BasePersistenceImpl<ScienceAppDescription>
	implements ScienceAppDescriptionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScienceAppDescriptionUtil} to access the science app description persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScienceAppDescriptionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScienceAppDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppDescriptionModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppDescriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScienceAppDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppDescriptionModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppDescriptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScienceAppDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppDescriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ScienceAppDescriptionPersistenceImpl() {
		setModelClass(ScienceAppDescription.class);
	}

	/**
	 * Caches the science app description in the entity cache if it is enabled.
	 *
	 * @param scienceAppDescription the science app description
	 */
	@Override
	public void cacheResult(ScienceAppDescription scienceAppDescription) {
		EntityCacheUtil.putResult(ScienceAppDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppDescriptionImpl.class,
			scienceAppDescription.getPrimaryKey(), scienceAppDescription);

		scienceAppDescription.resetOriginalValues();
	}

	/**
	 * Caches the science app descriptions in the entity cache if it is enabled.
	 *
	 * @param scienceAppDescriptions the science app descriptions
	 */
	@Override
	public void cacheResult(List<ScienceAppDescription> scienceAppDescriptions) {
		for (ScienceAppDescription scienceAppDescription : scienceAppDescriptions) {
			if (EntityCacheUtil.getResult(
						ScienceAppDescriptionModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppDescriptionImpl.class,
						scienceAppDescription.getPrimaryKey()) == null) {
				cacheResult(scienceAppDescription);
			}
			else {
				scienceAppDescription.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all science app descriptions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ScienceAppDescriptionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ScienceAppDescriptionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the science app description.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScienceAppDescription scienceAppDescription) {
		EntityCacheUtil.removeResult(ScienceAppDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppDescriptionImpl.class,
			scienceAppDescription.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ScienceAppDescription> scienceAppDescriptions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ScienceAppDescription scienceAppDescription : scienceAppDescriptions) {
			EntityCacheUtil.removeResult(ScienceAppDescriptionModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppDescriptionImpl.class,
				scienceAppDescription.getPrimaryKey());
		}
	}

	/**
	 * Creates a new science app description with the primary key. Does not add the science app description to the database.
	 *
	 * @param descriptionId the primary key for the new science app description
	 * @return the new science app description
	 */
	@Override
	public ScienceAppDescription create(long descriptionId) {
		ScienceAppDescription scienceAppDescription = new ScienceAppDescriptionImpl();

		scienceAppDescription.setNew(true);
		scienceAppDescription.setPrimaryKey(descriptionId);

		return scienceAppDescription;
	}

	/**
	 * Removes the science app description with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param descriptionId the primary key of the science app description
	 * @return the science app description that was removed
	 * @throws org.kisti.edison.science.NoSuchScienceAppDescriptionException if a science app description with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppDescription remove(long descriptionId)
		throws NoSuchScienceAppDescriptionException, SystemException {
		return remove((Serializable)descriptionId);
	}

	/**
	 * Removes the science app description with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the science app description
	 * @return the science app description that was removed
	 * @throws org.kisti.edison.science.NoSuchScienceAppDescriptionException if a science app description with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppDescription remove(Serializable primaryKey)
		throws NoSuchScienceAppDescriptionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ScienceAppDescription scienceAppDescription = (ScienceAppDescription)session.get(ScienceAppDescriptionImpl.class,
					primaryKey);

			if (scienceAppDescription == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScienceAppDescriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scienceAppDescription);
		}
		catch (NoSuchScienceAppDescriptionException nsee) {
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
	protected ScienceAppDescription removeImpl(
		ScienceAppDescription scienceAppDescription) throws SystemException {
		scienceAppDescription = toUnwrappedModel(scienceAppDescription);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scienceAppDescription)) {
				scienceAppDescription = (ScienceAppDescription)session.get(ScienceAppDescriptionImpl.class,
						scienceAppDescription.getPrimaryKeyObj());
			}

			if (scienceAppDescription != null) {
				session.delete(scienceAppDescription);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scienceAppDescription != null) {
			clearCache(scienceAppDescription);
		}

		return scienceAppDescription;
	}

	@Override
	public ScienceAppDescription updateImpl(
		org.kisti.edison.science.model.ScienceAppDescription scienceAppDescription)
		throws SystemException {
		scienceAppDescription = toUnwrappedModel(scienceAppDescription);

		boolean isNew = scienceAppDescription.isNew();

		Session session = null;

		try {
			session = openSession();

			if (scienceAppDescription.isNew()) {
				session.save(scienceAppDescription);

				scienceAppDescription.setNew(false);
			}
			else {
				session.merge(scienceAppDescription);
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

		EntityCacheUtil.putResult(ScienceAppDescriptionModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppDescriptionImpl.class,
			scienceAppDescription.getPrimaryKey(), scienceAppDescription);

		return scienceAppDescription;
	}

	protected ScienceAppDescription toUnwrappedModel(
		ScienceAppDescription scienceAppDescription) {
		if (scienceAppDescription instanceof ScienceAppDescriptionImpl) {
			return scienceAppDescription;
		}

		ScienceAppDescriptionImpl scienceAppDescriptionImpl = new ScienceAppDescriptionImpl();

		scienceAppDescriptionImpl.setNew(scienceAppDescription.isNew());
		scienceAppDescriptionImpl.setPrimaryKey(scienceAppDescription.getPrimaryKey());

		scienceAppDescriptionImpl.setDescriptionId(scienceAppDescription.getDescriptionId());
		scienceAppDescriptionImpl.setContent(scienceAppDescription.getContent());
		scienceAppDescriptionImpl.setInsertId(scienceAppDescription.getInsertId());
		scienceAppDescriptionImpl.setInsertDt(scienceAppDescription.getInsertDt());
		scienceAppDescriptionImpl.setUpdateId(scienceAppDescription.getUpdateId());
		scienceAppDescriptionImpl.setUpdateDt(scienceAppDescription.getUpdateDt());

		return scienceAppDescriptionImpl;
	}

	/**
	 * Returns the science app description with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app description
	 * @return the science app description
	 * @throws org.kisti.edison.science.NoSuchScienceAppDescriptionException if a science app description with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppDescription findByPrimaryKey(Serializable primaryKey)
		throws NoSuchScienceAppDescriptionException, SystemException {
		ScienceAppDescription scienceAppDescription = fetchByPrimaryKey(primaryKey);

		if (scienceAppDescription == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchScienceAppDescriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return scienceAppDescription;
	}

	/**
	 * Returns the science app description with the primary key or throws a {@link org.kisti.edison.science.NoSuchScienceAppDescriptionException} if it could not be found.
	 *
	 * @param descriptionId the primary key of the science app description
	 * @return the science app description
	 * @throws org.kisti.edison.science.NoSuchScienceAppDescriptionException if a science app description with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppDescription findByPrimaryKey(long descriptionId)
		throws NoSuchScienceAppDescriptionException, SystemException {
		return findByPrimaryKey((Serializable)descriptionId);
	}

	/**
	 * Returns the science app description with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app description
	 * @return the science app description, or <code>null</code> if a science app description with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppDescription fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ScienceAppDescription scienceAppDescription = (ScienceAppDescription)EntityCacheUtil.getResult(ScienceAppDescriptionModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppDescriptionImpl.class, primaryKey);

		if (scienceAppDescription == _nullScienceAppDescription) {
			return null;
		}

		if (scienceAppDescription == null) {
			Session session = null;

			try {
				session = openSession();

				scienceAppDescription = (ScienceAppDescription)session.get(ScienceAppDescriptionImpl.class,
						primaryKey);

				if (scienceAppDescription != null) {
					cacheResult(scienceAppDescription);
				}
				else {
					EntityCacheUtil.putResult(ScienceAppDescriptionModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppDescriptionImpl.class, primaryKey,
						_nullScienceAppDescription);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ScienceAppDescriptionModelImpl.ENTITY_CACHE_ENABLED,
					ScienceAppDescriptionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return scienceAppDescription;
	}

	/**
	 * Returns the science app description with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param descriptionId the primary key of the science app description
	 * @return the science app description, or <code>null</code> if a science app description with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppDescription fetchByPrimaryKey(long descriptionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)descriptionId);
	}

	/**
	 * Returns all the science app descriptions.
	 *
	 * @return the science app descriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppDescription> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science app descriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science app descriptions
	 * @param end the upper bound of the range of science app descriptions (not inclusive)
	 * @return the range of science app descriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppDescription> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app descriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppDescriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science app descriptions
	 * @param end the upper bound of the range of science app descriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of science app descriptions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppDescription> findAll(int start, int end,
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

		List<ScienceAppDescription> list = (List<ScienceAppDescription>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCIENCEAPPDESCRIPTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCIENCEAPPDESCRIPTION;

				if (pagination) {
					sql = sql.concat(ScienceAppDescriptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ScienceAppDescription>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppDescription>(list);
				}
				else {
					list = (List<ScienceAppDescription>)QueryUtil.list(q,
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
	 * Removes all the science app descriptions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ScienceAppDescription scienceAppDescription : findAll()) {
			remove(scienceAppDescription);
		}
	}

	/**
	 * Returns the number of science app descriptions.
	 *
	 * @return the number of science app descriptions
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

				Query q = session.createQuery(_SQL_COUNT_SCIENCEAPPDESCRIPTION);

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
	 * Initializes the science app description persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.science.model.ScienceAppDescription")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ScienceAppDescription>> listenersList = new ArrayList<ModelListener<ScienceAppDescription>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ScienceAppDescription>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ScienceAppDescriptionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SCIENCEAPPDESCRIPTION = "SELECT scienceAppDescription FROM ScienceAppDescription scienceAppDescription";
	private static final String _SQL_COUNT_SCIENCEAPPDESCRIPTION = "SELECT COUNT(scienceAppDescription) FROM ScienceAppDescription scienceAppDescription";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scienceAppDescription.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ScienceAppDescription exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ScienceAppDescriptionPersistenceImpl.class);
	private static ScienceAppDescription _nullScienceAppDescription = new ScienceAppDescriptionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ScienceAppDescription> toCacheModel() {
				return _nullScienceAppDescriptionCacheModel;
			}
		};

	private static CacheModel<ScienceAppDescription> _nullScienceAppDescriptionCacheModel =
		new CacheModel<ScienceAppDescription>() {
			@Override
			public ScienceAppDescription toEntityModel() {
				return _nullScienceAppDescription;
			}
		};
}