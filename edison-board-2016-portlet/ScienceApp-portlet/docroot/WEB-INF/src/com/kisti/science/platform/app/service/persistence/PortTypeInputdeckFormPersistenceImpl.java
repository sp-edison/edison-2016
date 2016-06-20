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

import com.kisti.science.platform.app.NoSuchPortTypeInputdeckFormException;
import com.kisti.science.platform.app.model.PortTypeInputdeckForm;
import com.kisti.science.platform.app.model.impl.PortTypeInputdeckFormImpl;
import com.kisti.science.platform.app.model.impl.PortTypeInputdeckFormModelImpl;

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
 * The persistence implementation for the port type inputdeck form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeInputdeckFormPersistence
 * @see PortTypeInputdeckFormUtil
 * @generated
 */
public class PortTypeInputdeckFormPersistenceImpl extends BasePersistenceImpl<PortTypeInputdeckForm>
	implements PortTypeInputdeckFormPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PortTypeInputdeckFormUtil} to access the port type inputdeck form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PortTypeInputdeckFormImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PortTypeInputdeckFormModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeInputdeckFormModelImpl.FINDER_CACHE_ENABLED,
			PortTypeInputdeckFormImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PortTypeInputdeckFormModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeInputdeckFormModelImpl.FINDER_CACHE_ENABLED,
			PortTypeInputdeckFormImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PortTypeInputdeckFormModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeInputdeckFormModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PortTypeInputdeckFormPersistenceImpl() {
		setModelClass(PortTypeInputdeckForm.class);
	}

	/**
	 * Caches the port type inputdeck form in the entity cache if it is enabled.
	 *
	 * @param portTypeInputdeckForm the port type inputdeck form
	 */
	@Override
	public void cacheResult(PortTypeInputdeckForm portTypeInputdeckForm) {
		EntityCacheUtil.putResult(PortTypeInputdeckFormModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeInputdeckFormImpl.class,
			portTypeInputdeckForm.getPrimaryKey(), portTypeInputdeckForm);

		portTypeInputdeckForm.resetOriginalValues();
	}

	/**
	 * Caches the port type inputdeck forms in the entity cache if it is enabled.
	 *
	 * @param portTypeInputdeckForms the port type inputdeck forms
	 */
	@Override
	public void cacheResult(List<PortTypeInputdeckForm> portTypeInputdeckForms) {
		for (PortTypeInputdeckForm portTypeInputdeckForm : portTypeInputdeckForms) {
			if (EntityCacheUtil.getResult(
						PortTypeInputdeckFormModelImpl.ENTITY_CACHE_ENABLED,
						PortTypeInputdeckFormImpl.class,
						portTypeInputdeckForm.getPrimaryKey()) == null) {
				cacheResult(portTypeInputdeckForm);
			}
			else {
				portTypeInputdeckForm.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all port type inputdeck forms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PortTypeInputdeckFormImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PortTypeInputdeckFormImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the port type inputdeck form.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PortTypeInputdeckForm portTypeInputdeckForm) {
		EntityCacheUtil.removeResult(PortTypeInputdeckFormModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeInputdeckFormImpl.class,
			portTypeInputdeckForm.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PortTypeInputdeckForm> portTypeInputdeckForms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PortTypeInputdeckForm portTypeInputdeckForm : portTypeInputdeckForms) {
			EntityCacheUtil.removeResult(PortTypeInputdeckFormModelImpl.ENTITY_CACHE_ENABLED,
				PortTypeInputdeckFormImpl.class,
				portTypeInputdeckForm.getPrimaryKey());
		}
	}

	/**
	 * Creates a new port type inputdeck form with the primary key. Does not add the port type inputdeck form to the database.
	 *
	 * @param portTypeId the primary key for the new port type inputdeck form
	 * @return the new port type inputdeck form
	 */
	@Override
	public PortTypeInputdeckForm create(long portTypeId) {
		PortTypeInputdeckForm portTypeInputdeckForm = new PortTypeInputdeckFormImpl();

		portTypeInputdeckForm.setNew(true);
		portTypeInputdeckForm.setPrimaryKey(portTypeId);

		return portTypeInputdeckForm;
	}

	/**
	 * Removes the port type inputdeck form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portTypeId the primary key of the port type inputdeck form
	 * @return the port type inputdeck form that was removed
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckFormException if a port type inputdeck form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeInputdeckForm remove(long portTypeId)
		throws NoSuchPortTypeInputdeckFormException, SystemException {
		return remove((Serializable)portTypeId);
	}

	/**
	 * Removes the port type inputdeck form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the port type inputdeck form
	 * @return the port type inputdeck form that was removed
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckFormException if a port type inputdeck form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeInputdeckForm remove(Serializable primaryKey)
		throws NoSuchPortTypeInputdeckFormException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PortTypeInputdeckForm portTypeInputdeckForm = (PortTypeInputdeckForm)session.get(PortTypeInputdeckFormImpl.class,
					primaryKey);

			if (portTypeInputdeckForm == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPortTypeInputdeckFormException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(portTypeInputdeckForm);
		}
		catch (NoSuchPortTypeInputdeckFormException nsee) {
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
	protected PortTypeInputdeckForm removeImpl(
		PortTypeInputdeckForm portTypeInputdeckForm) throws SystemException {
		portTypeInputdeckForm = toUnwrappedModel(portTypeInputdeckForm);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(portTypeInputdeckForm)) {
				portTypeInputdeckForm = (PortTypeInputdeckForm)session.get(PortTypeInputdeckFormImpl.class,
						portTypeInputdeckForm.getPrimaryKeyObj());
			}

			if (portTypeInputdeckForm != null) {
				session.delete(portTypeInputdeckForm);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (portTypeInputdeckForm != null) {
			clearCache(portTypeInputdeckForm);
		}

		return portTypeInputdeckForm;
	}

	@Override
	public PortTypeInputdeckForm updateImpl(
		com.kisti.science.platform.app.model.PortTypeInputdeckForm portTypeInputdeckForm)
		throws SystemException {
		portTypeInputdeckForm = toUnwrappedModel(portTypeInputdeckForm);

		boolean isNew = portTypeInputdeckForm.isNew();

		Session session = null;

		try {
			session = openSession();

			if (portTypeInputdeckForm.isNew()) {
				session.save(portTypeInputdeckForm);

				portTypeInputdeckForm.setNew(false);
			}
			else {
				session.merge(portTypeInputdeckForm);
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

		EntityCacheUtil.putResult(PortTypeInputdeckFormModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeInputdeckFormImpl.class,
			portTypeInputdeckForm.getPrimaryKey(), portTypeInputdeckForm);

		return portTypeInputdeckForm;
	}

	protected PortTypeInputdeckForm toUnwrappedModel(
		PortTypeInputdeckForm portTypeInputdeckForm) {
		if (portTypeInputdeckForm instanceof PortTypeInputdeckFormImpl) {
			return portTypeInputdeckForm;
		}

		PortTypeInputdeckFormImpl portTypeInputdeckFormImpl = new PortTypeInputdeckFormImpl();

		portTypeInputdeckFormImpl.setNew(portTypeInputdeckForm.isNew());
		portTypeInputdeckFormImpl.setPrimaryKey(portTypeInputdeckForm.getPrimaryKey());

		portTypeInputdeckFormImpl.setPortTypeId(portTypeInputdeckForm.getPortTypeId());
		portTypeInputdeckFormImpl.setInputdeckForm(portTypeInputdeckForm.getInputdeckForm());

		return portTypeInputdeckFormImpl;
	}

	/**
	 * Returns the port type inputdeck form with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the port type inputdeck form
	 * @return the port type inputdeck form
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckFormException if a port type inputdeck form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeInputdeckForm findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPortTypeInputdeckFormException, SystemException {
		PortTypeInputdeckForm portTypeInputdeckForm = fetchByPrimaryKey(primaryKey);

		if (portTypeInputdeckForm == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPortTypeInputdeckFormException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return portTypeInputdeckForm;
	}

	/**
	 * Returns the port type inputdeck form with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchPortTypeInputdeckFormException} if it could not be found.
	 *
	 * @param portTypeId the primary key of the port type inputdeck form
	 * @return the port type inputdeck form
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckFormException if a port type inputdeck form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeInputdeckForm findByPrimaryKey(long portTypeId)
		throws NoSuchPortTypeInputdeckFormException, SystemException {
		return findByPrimaryKey((Serializable)portTypeId);
	}

	/**
	 * Returns the port type inputdeck form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the port type inputdeck form
	 * @return the port type inputdeck form, or <code>null</code> if a port type inputdeck form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeInputdeckForm fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PortTypeInputdeckForm portTypeInputdeckForm = (PortTypeInputdeckForm)EntityCacheUtil.getResult(PortTypeInputdeckFormModelImpl.ENTITY_CACHE_ENABLED,
				PortTypeInputdeckFormImpl.class, primaryKey);

		if (portTypeInputdeckForm == _nullPortTypeInputdeckForm) {
			return null;
		}

		if (portTypeInputdeckForm == null) {
			Session session = null;

			try {
				session = openSession();

				portTypeInputdeckForm = (PortTypeInputdeckForm)session.get(PortTypeInputdeckFormImpl.class,
						primaryKey);

				if (portTypeInputdeckForm != null) {
					cacheResult(portTypeInputdeckForm);
				}
				else {
					EntityCacheUtil.putResult(PortTypeInputdeckFormModelImpl.ENTITY_CACHE_ENABLED,
						PortTypeInputdeckFormImpl.class, primaryKey,
						_nullPortTypeInputdeckForm);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PortTypeInputdeckFormModelImpl.ENTITY_CACHE_ENABLED,
					PortTypeInputdeckFormImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return portTypeInputdeckForm;
	}

	/**
	 * Returns the port type inputdeck form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param portTypeId the primary key of the port type inputdeck form
	 * @return the port type inputdeck form, or <code>null</code> if a port type inputdeck form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeInputdeckForm fetchByPrimaryKey(long portTypeId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)portTypeId);
	}

	/**
	 * Returns all the port type inputdeck forms.
	 *
	 * @return the port type inputdeck forms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeInputdeckForm> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the port type inputdeck forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeInputdeckFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of port type inputdeck forms
	 * @param end the upper bound of the range of port type inputdeck forms (not inclusive)
	 * @return the range of port type inputdeck forms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeInputdeckForm> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the port type inputdeck forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeInputdeckFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of port type inputdeck forms
	 * @param end the upper bound of the range of port type inputdeck forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of port type inputdeck forms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeInputdeckForm> findAll(int start, int end,
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

		List<PortTypeInputdeckForm> list = (List<PortTypeInputdeckForm>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PORTTYPEINPUTDECKFORM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PORTTYPEINPUTDECKFORM;

				if (pagination) {
					sql = sql.concat(PortTypeInputdeckFormModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PortTypeInputdeckForm>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PortTypeInputdeckForm>(list);
				}
				else {
					list = (List<PortTypeInputdeckForm>)QueryUtil.list(q,
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
	 * Removes all the port type inputdeck forms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PortTypeInputdeckForm portTypeInputdeckForm : findAll()) {
			remove(portTypeInputdeckForm);
		}
	}

	/**
	 * Returns the number of port type inputdeck forms.
	 *
	 * @return the number of port type inputdeck forms
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

				Query q = session.createQuery(_SQL_COUNT_PORTTYPEINPUTDECKFORM);

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
	 * Initializes the port type inputdeck form persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kisti.science.platform.app.model.PortTypeInputdeckForm")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PortTypeInputdeckForm>> listenersList = new ArrayList<ModelListener<PortTypeInputdeckForm>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PortTypeInputdeckForm>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PortTypeInputdeckFormImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PORTTYPEINPUTDECKFORM = "SELECT portTypeInputdeckForm FROM PortTypeInputdeckForm portTypeInputdeckForm";
	private static final String _SQL_COUNT_PORTTYPEINPUTDECKFORM = "SELECT COUNT(portTypeInputdeckForm) FROM PortTypeInputdeckForm portTypeInputdeckForm";
	private static final String _ORDER_BY_ENTITY_ALIAS = "portTypeInputdeckForm.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PortTypeInputdeckForm exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PortTypeInputdeckFormPersistenceImpl.class);
	private static PortTypeInputdeckForm _nullPortTypeInputdeckForm = new PortTypeInputdeckFormImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PortTypeInputdeckForm> toCacheModel() {
				return _nullPortTypeInputdeckFormCacheModel;
			}
		};

	private static CacheModel<PortTypeInputdeckForm> _nullPortTypeInputdeckFormCacheModel =
		new CacheModel<PortTypeInputdeckForm>() {
			@Override
			public PortTypeInputdeckForm toEntityModel() {
				return _nullPortTypeInputdeckForm;
			}
		};
}