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

import com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException;
import com.kisti.science.platform.app.model.PortTypeInputdeckUserForm;
import com.kisti.science.platform.app.model.impl.PortTypeInputdeckUserFormImpl;
import com.kisti.science.platform.app.model.impl.PortTypeInputdeckUserFormModelImpl;

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
 * The persistence implementation for the port type inputdeck user form service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeInputdeckUserFormPersistence
 * @see PortTypeInputdeckUserFormUtil
 * @generated
 */
public class PortTypeInputdeckUserFormPersistenceImpl
	extends BasePersistenceImpl<PortTypeInputdeckUserForm>
	implements PortTypeInputdeckUserFormPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PortTypeInputdeckUserFormUtil} to access the port type inputdeck user form persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PortTypeInputdeckUserFormImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PortTypeInputdeckUserFormModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeInputdeckUserFormModelImpl.FINDER_CACHE_ENABLED,
			PortTypeInputdeckUserFormImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PortTypeInputdeckUserFormModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeInputdeckUserFormModelImpl.FINDER_CACHE_ENABLED,
			PortTypeInputdeckUserFormImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PortTypeInputdeckUserFormModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeInputdeckUserFormModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public PortTypeInputdeckUserFormPersistenceImpl() {
		setModelClass(PortTypeInputdeckUserForm.class);
	}

	/**
	 * Caches the port type inputdeck user form in the entity cache if it is enabled.
	 *
	 * @param portTypeInputdeckUserForm the port type inputdeck user form
	 */
	@Override
	public void cacheResult(PortTypeInputdeckUserForm portTypeInputdeckUserForm) {
		EntityCacheUtil.putResult(PortTypeInputdeckUserFormModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeInputdeckUserFormImpl.class,
			portTypeInputdeckUserForm.getPrimaryKey(), portTypeInputdeckUserForm);

		portTypeInputdeckUserForm.resetOriginalValues();
	}

	/**
	 * Caches the port type inputdeck user forms in the entity cache if it is enabled.
	 *
	 * @param portTypeInputdeckUserForms the port type inputdeck user forms
	 */
	@Override
	public void cacheResult(
		List<PortTypeInputdeckUserForm> portTypeInputdeckUserForms) {
		for (PortTypeInputdeckUserForm portTypeInputdeckUserForm : portTypeInputdeckUserForms) {
			if (EntityCacheUtil.getResult(
						PortTypeInputdeckUserFormModelImpl.ENTITY_CACHE_ENABLED,
						PortTypeInputdeckUserFormImpl.class,
						portTypeInputdeckUserForm.getPrimaryKey()) == null) {
				cacheResult(portTypeInputdeckUserForm);
			}
			else {
				portTypeInputdeckUserForm.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all port type inputdeck user forms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PortTypeInputdeckUserFormImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PortTypeInputdeckUserFormImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the port type inputdeck user form.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PortTypeInputdeckUserForm portTypeInputdeckUserForm) {
		EntityCacheUtil.removeResult(PortTypeInputdeckUserFormModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeInputdeckUserFormImpl.class,
			portTypeInputdeckUserForm.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<PortTypeInputdeckUserForm> portTypeInputdeckUserForms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PortTypeInputdeckUserForm portTypeInputdeckUserForm : portTypeInputdeckUserForms) {
			EntityCacheUtil.removeResult(PortTypeInputdeckUserFormModelImpl.ENTITY_CACHE_ENABLED,
				PortTypeInputdeckUserFormImpl.class,
				portTypeInputdeckUserForm.getPrimaryKey());
		}
	}

	/**
	 * Creates a new port type inputdeck user form with the primary key. Does not add the port type inputdeck user form to the database.
	 *
	 * @param inputdeckId the primary key for the new port type inputdeck user form
	 * @return the new port type inputdeck user form
	 */
	@Override
	public PortTypeInputdeckUserForm create(long inputdeckId) {
		PortTypeInputdeckUserForm portTypeInputdeckUserForm = new PortTypeInputdeckUserFormImpl();

		portTypeInputdeckUserForm.setNew(true);
		portTypeInputdeckUserForm.setPrimaryKey(inputdeckId);

		return portTypeInputdeckUserForm;
	}

	/**
	 * Removes the port type inputdeck user form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param inputdeckId the primary key of the port type inputdeck user form
	 * @return the port type inputdeck user form that was removed
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException if a port type inputdeck user form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeInputdeckUserForm remove(long inputdeckId)
		throws NoSuchPortTypeInputdeckUserFormException, SystemException {
		return remove((Serializable)inputdeckId);
	}

	/**
	 * Removes the port type inputdeck user form with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the port type inputdeck user form
	 * @return the port type inputdeck user form that was removed
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException if a port type inputdeck user form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeInputdeckUserForm remove(Serializable primaryKey)
		throws NoSuchPortTypeInputdeckUserFormException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PortTypeInputdeckUserForm portTypeInputdeckUserForm = (PortTypeInputdeckUserForm)session.get(PortTypeInputdeckUserFormImpl.class,
					primaryKey);

			if (portTypeInputdeckUserForm == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPortTypeInputdeckUserFormException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(portTypeInputdeckUserForm);
		}
		catch (NoSuchPortTypeInputdeckUserFormException nsee) {
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
	protected PortTypeInputdeckUserForm removeImpl(
		PortTypeInputdeckUserForm portTypeInputdeckUserForm)
		throws SystemException {
		portTypeInputdeckUserForm = toUnwrappedModel(portTypeInputdeckUserForm);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(portTypeInputdeckUserForm)) {
				portTypeInputdeckUserForm = (PortTypeInputdeckUserForm)session.get(PortTypeInputdeckUserFormImpl.class,
						portTypeInputdeckUserForm.getPrimaryKeyObj());
			}

			if (portTypeInputdeckUserForm != null) {
				session.delete(portTypeInputdeckUserForm);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (portTypeInputdeckUserForm != null) {
			clearCache(portTypeInputdeckUserForm);
		}

		return portTypeInputdeckUserForm;
	}

	@Override
	public PortTypeInputdeckUserForm updateImpl(
		com.kisti.science.platform.app.model.PortTypeInputdeckUserForm portTypeInputdeckUserForm)
		throws SystemException {
		portTypeInputdeckUserForm = toUnwrappedModel(portTypeInputdeckUserForm);

		boolean isNew = portTypeInputdeckUserForm.isNew();

		Session session = null;

		try {
			session = openSession();

			if (portTypeInputdeckUserForm.isNew()) {
				session.save(portTypeInputdeckUserForm);

				portTypeInputdeckUserForm.setNew(false);
			}
			else {
				session.merge(portTypeInputdeckUserForm);
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

		EntityCacheUtil.putResult(PortTypeInputdeckUserFormModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeInputdeckUserFormImpl.class,
			portTypeInputdeckUserForm.getPrimaryKey(), portTypeInputdeckUserForm);

		return portTypeInputdeckUserForm;
	}

	protected PortTypeInputdeckUserForm toUnwrappedModel(
		PortTypeInputdeckUserForm portTypeInputdeckUserForm) {
		if (portTypeInputdeckUserForm instanceof PortTypeInputdeckUserFormImpl) {
			return portTypeInputdeckUserForm;
		}

		PortTypeInputdeckUserFormImpl portTypeInputdeckUserFormImpl = new PortTypeInputdeckUserFormImpl();

		portTypeInputdeckUserFormImpl.setNew(portTypeInputdeckUserForm.isNew());
		portTypeInputdeckUserFormImpl.setPrimaryKey(portTypeInputdeckUserForm.getPrimaryKey());

		portTypeInputdeckUserFormImpl.setInputdeckId(portTypeInputdeckUserForm.getInputdeckId());
		portTypeInputdeckUserFormImpl.setPortTypeId(portTypeInputdeckUserForm.getPortTypeId());
		portTypeInputdeckUserFormImpl.setInputdeckUserForm(portTypeInputdeckUserForm.getInputdeckUserForm());
		portTypeInputdeckUserFormImpl.setUserId(portTypeInputdeckUserForm.getUserId());
		portTypeInputdeckUserFormImpl.setUserName(portTypeInputdeckUserForm.getUserName());

		return portTypeInputdeckUserFormImpl;
	}

	/**
	 * Returns the port type inputdeck user form with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the port type inputdeck user form
	 * @return the port type inputdeck user form
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException if a port type inputdeck user form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeInputdeckUserForm findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPortTypeInputdeckUserFormException, SystemException {
		PortTypeInputdeckUserForm portTypeInputdeckUserForm = fetchByPrimaryKey(primaryKey);

		if (portTypeInputdeckUserForm == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPortTypeInputdeckUserFormException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return portTypeInputdeckUserForm;
	}

	/**
	 * Returns the port type inputdeck user form with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException} if it could not be found.
	 *
	 * @param inputdeckId the primary key of the port type inputdeck user form
	 * @return the port type inputdeck user form
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeInputdeckUserFormException if a port type inputdeck user form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeInputdeckUserForm findByPrimaryKey(long inputdeckId)
		throws NoSuchPortTypeInputdeckUserFormException, SystemException {
		return findByPrimaryKey((Serializable)inputdeckId);
	}

	/**
	 * Returns the port type inputdeck user form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the port type inputdeck user form
	 * @return the port type inputdeck user form, or <code>null</code> if a port type inputdeck user form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeInputdeckUserForm fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PortTypeInputdeckUserForm portTypeInputdeckUserForm = (PortTypeInputdeckUserForm)EntityCacheUtil.getResult(PortTypeInputdeckUserFormModelImpl.ENTITY_CACHE_ENABLED,
				PortTypeInputdeckUserFormImpl.class, primaryKey);

		if (portTypeInputdeckUserForm == _nullPortTypeInputdeckUserForm) {
			return null;
		}

		if (portTypeInputdeckUserForm == null) {
			Session session = null;

			try {
				session = openSession();

				portTypeInputdeckUserForm = (PortTypeInputdeckUserForm)session.get(PortTypeInputdeckUserFormImpl.class,
						primaryKey);

				if (portTypeInputdeckUserForm != null) {
					cacheResult(portTypeInputdeckUserForm);
				}
				else {
					EntityCacheUtil.putResult(PortTypeInputdeckUserFormModelImpl.ENTITY_CACHE_ENABLED,
						PortTypeInputdeckUserFormImpl.class, primaryKey,
						_nullPortTypeInputdeckUserForm);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PortTypeInputdeckUserFormModelImpl.ENTITY_CACHE_ENABLED,
					PortTypeInputdeckUserFormImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return portTypeInputdeckUserForm;
	}

	/**
	 * Returns the port type inputdeck user form with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param inputdeckId the primary key of the port type inputdeck user form
	 * @return the port type inputdeck user form, or <code>null</code> if a port type inputdeck user form with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeInputdeckUserForm fetchByPrimaryKey(long inputdeckId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)inputdeckId);
	}

	/**
	 * Returns all the port type inputdeck user forms.
	 *
	 * @return the port type inputdeck user forms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeInputdeckUserForm> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the port type inputdeck user forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeInputdeckUserFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of port type inputdeck user forms
	 * @param end the upper bound of the range of port type inputdeck user forms (not inclusive)
	 * @return the range of port type inputdeck user forms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeInputdeckUserForm> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the port type inputdeck user forms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeInputdeckUserFormModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of port type inputdeck user forms
	 * @param end the upper bound of the range of port type inputdeck user forms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of port type inputdeck user forms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeInputdeckUserForm> findAll(int start, int end,
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

		List<PortTypeInputdeckUserForm> list = (List<PortTypeInputdeckUserForm>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PORTTYPEINPUTDECKUSERFORM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PORTTYPEINPUTDECKUSERFORM;

				if (pagination) {
					sql = sql.concat(PortTypeInputdeckUserFormModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PortTypeInputdeckUserForm>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PortTypeInputdeckUserForm>(list);
				}
				else {
					list = (List<PortTypeInputdeckUserForm>)QueryUtil.list(q,
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
	 * Removes all the port type inputdeck user forms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PortTypeInputdeckUserForm portTypeInputdeckUserForm : findAll()) {
			remove(portTypeInputdeckUserForm);
		}
	}

	/**
	 * Returns the number of port type inputdeck user forms.
	 *
	 * @return the number of port type inputdeck user forms
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

				Query q = session.createQuery(_SQL_COUNT_PORTTYPEINPUTDECKUSERFORM);

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
	 * Initializes the port type inputdeck user form persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kisti.science.platform.app.model.PortTypeInputdeckUserForm")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PortTypeInputdeckUserForm>> listenersList = new ArrayList<ModelListener<PortTypeInputdeckUserForm>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PortTypeInputdeckUserForm>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PortTypeInputdeckUserFormImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PORTTYPEINPUTDECKUSERFORM = "SELECT portTypeInputdeckUserForm FROM PortTypeInputdeckUserForm portTypeInputdeckUserForm";
	private static final String _SQL_COUNT_PORTTYPEINPUTDECKUSERFORM = "SELECT COUNT(portTypeInputdeckUserForm) FROM PortTypeInputdeckUserForm portTypeInputdeckUserForm";
	private static final String _ORDER_BY_ENTITY_ALIAS = "portTypeInputdeckUserForm.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PortTypeInputdeckUserForm exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PortTypeInputdeckUserFormPersistenceImpl.class);
	private static PortTypeInputdeckUserForm _nullPortTypeInputdeckUserForm = new PortTypeInputdeckUserFormImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PortTypeInputdeckUserForm> toCacheModel() {
				return _nullPortTypeInputdeckUserFormCacheModel;
			}
		};

	private static CacheModel<PortTypeInputdeckUserForm> _nullPortTypeInputdeckUserFormCacheModel =
		new CacheModel<PortTypeInputdeckUserForm>() {
			@Override
			public PortTypeInputdeckUserForm toEntityModel() {
				return _nullPortTypeInputdeckUserForm;
			}
		};
}