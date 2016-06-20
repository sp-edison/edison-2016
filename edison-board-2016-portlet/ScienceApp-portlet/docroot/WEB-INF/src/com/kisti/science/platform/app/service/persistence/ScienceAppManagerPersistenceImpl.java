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

import com.kisti.science.platform.app.NoSuchManagerException;
import com.kisti.science.platform.app.model.ScienceAppManager;
import com.kisti.science.platform.app.model.impl.ScienceAppManagerImpl;
import com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
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
 * The persistence implementation for the science app manager service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppManagerPersistence
 * @see ScienceAppManagerUtil
 * @generated
 */
public class ScienceAppManagerPersistenceImpl extends BasePersistenceImpl<ScienceAppManager>
	implements ScienceAppManagerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScienceAppManagerUtil} to access the science app manager persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScienceAppManagerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppManagerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppManagerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPIDMANAGERID =
		new FinderPath(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppManagerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppIdManagerId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPIDMANAGERID =
		new FinderPath(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppManagerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAppIdManagerId",
			new String[] { Long.class.getName(), Long.class.getName() },
			ScienceAppManagerModelImpl.SCIENCEAPPID_COLUMN_BITMASK |
			ScienceAppManagerModelImpl.MANAGERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPIDMANAGERID = new FinderPath(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAppIdManagerId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the science app managers where scienceAppId = &#63; and managerId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param managerId the manager ID
	 * @return the matching science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppManager> findByAppIdManagerId(long scienceAppId,
		long managerId) throws SystemException {
		return findByAppIdManagerId(scienceAppId, managerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science app managers where scienceAppId = &#63; and managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scienceAppId the science app ID
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of science app managers
	 * @param end the upper bound of the range of science app managers (not inclusive)
	 * @return the range of matching science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppManager> findByAppIdManagerId(long scienceAppId,
		long managerId, int start, int end) throws SystemException {
		return findByAppIdManagerId(scienceAppId, managerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app managers where scienceAppId = &#63; and managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scienceAppId the science app ID
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of science app managers
	 * @param end the upper bound of the range of science app managers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppManager> findByAppIdManagerId(long scienceAppId,
		long managerId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPIDMANAGERID;
			finderArgs = new Object[] { scienceAppId, managerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPIDMANAGERID;
			finderArgs = new Object[] {
					scienceAppId, managerId,
					
					start, end, orderByComparator
				};
		}

		List<ScienceAppManager> list = (List<ScienceAppManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceAppManager scienceAppManager : list) {
				if ((scienceAppId != scienceAppManager.getScienceAppId()) ||
						(managerId != scienceAppManager.getManagerId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SCIENCEAPPMANAGER_WHERE);

			query.append(_FINDER_COLUMN_APPIDMANAGERID_SCIENCEAPPID_2);

			query.append(_FINDER_COLUMN_APPIDMANAGERID_MANAGERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scienceAppId);

				qPos.add(managerId);

				if (!pagination) {
					list = (List<ScienceAppManager>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppManager>(list);
				}
				else {
					list = (List<ScienceAppManager>)QueryUtil.list(q,
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
	 * Returns the first science app manager in the ordered set where scienceAppId = &#63; and managerId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app manager
	 * @throws com.kisti.science.platform.app.NoSuchManagerException if a matching science app manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager findByAppIdManagerId_First(long scienceAppId,
		long managerId, OrderByComparator orderByComparator)
		throws NoSuchManagerException, SystemException {
		ScienceAppManager scienceAppManager = fetchByAppIdManagerId_First(scienceAppId,
				managerId, orderByComparator);

		if (scienceAppManager != null) {
			return scienceAppManager;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scienceAppId=");
		msg.append(scienceAppId);

		msg.append(", managerId=");
		msg.append(managerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchManagerException(msg.toString());
	}

	/**
	 * Returns the first science app manager in the ordered set where scienceAppId = &#63; and managerId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app manager, or <code>null</code> if a matching science app manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager fetchByAppIdManagerId_First(long scienceAppId,
		long managerId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceAppManager> list = findByAppIdManagerId(scienceAppId,
				managerId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app manager in the ordered set where scienceAppId = &#63; and managerId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app manager
	 * @throws com.kisti.science.platform.app.NoSuchManagerException if a matching science app manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager findByAppIdManagerId_Last(long scienceAppId,
		long managerId, OrderByComparator orderByComparator)
		throws NoSuchManagerException, SystemException {
		ScienceAppManager scienceAppManager = fetchByAppIdManagerId_Last(scienceAppId,
				managerId, orderByComparator);

		if (scienceAppManager != null) {
			return scienceAppManager;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scienceAppId=");
		msg.append(scienceAppId);

		msg.append(", managerId=");
		msg.append(managerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchManagerException(msg.toString());
	}

	/**
	 * Returns the last science app manager in the ordered set where scienceAppId = &#63; and managerId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app manager, or <code>null</code> if a matching science app manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager fetchByAppIdManagerId_Last(long scienceAppId,
		long managerId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAppIdManagerId(scienceAppId, managerId);

		if (count == 0) {
			return null;
		}

		List<ScienceAppManager> list = findByAppIdManagerId(scienceAppId,
				managerId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science app managers before and after the current science app manager in the ordered set where scienceAppId = &#63; and managerId = &#63;.
	 *
	 * @param scienceAppManagerId the primary key of the current science app manager
	 * @param scienceAppId the science app ID
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app manager
	 * @throws com.kisti.science.platform.app.NoSuchManagerException if a science app manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager[] findByAppIdManagerId_PrevAndNext(
		long scienceAppManagerId, long scienceAppId, long managerId,
		OrderByComparator orderByComparator)
		throws NoSuchManagerException, SystemException {
		ScienceAppManager scienceAppManager = findByPrimaryKey(scienceAppManagerId);

		Session session = null;

		try {
			session = openSession();

			ScienceAppManager[] array = new ScienceAppManagerImpl[3];

			array[0] = getByAppIdManagerId_PrevAndNext(session,
					scienceAppManager, scienceAppId, managerId,
					orderByComparator, true);

			array[1] = scienceAppManager;

			array[2] = getByAppIdManagerId_PrevAndNext(session,
					scienceAppManager, scienceAppId, managerId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceAppManager getByAppIdManagerId_PrevAndNext(
		Session session, ScienceAppManager scienceAppManager,
		long scienceAppId, long managerId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPPMANAGER_WHERE);

		query.append(_FINDER_COLUMN_APPIDMANAGERID_SCIENCEAPPID_2);

		query.append(_FINDER_COLUMN_APPIDMANAGERID_MANAGERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ScienceAppManagerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(scienceAppId);

		qPos.add(managerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceAppManager);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceAppManager> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science app managers where scienceAppId = &#63; and managerId = &#63; from the database.
	 *
	 * @param scienceAppId the science app ID
	 * @param managerId the manager ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAppIdManagerId(long scienceAppId, long managerId)
		throws SystemException {
		for (ScienceAppManager scienceAppManager : findByAppIdManagerId(
				scienceAppId, managerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(scienceAppManager);
		}
	}

	/**
	 * Returns the number of science app managers where scienceAppId = &#63; and managerId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param managerId the manager ID
	 * @return the number of matching science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAppIdManagerId(long scienceAppId, long managerId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPIDMANAGERID;

		Object[] finderArgs = new Object[] { scienceAppId, managerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPPMANAGER_WHERE);

			query.append(_FINDER_COLUMN_APPIDMANAGERID_SCIENCEAPPID_2);

			query.append(_FINDER_COLUMN_APPIDMANAGERID_MANAGERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scienceAppId);

				qPos.add(managerId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_APPIDMANAGERID_SCIENCEAPPID_2 = "scienceAppManager.scienceAppId = ? AND ";
	private static final String _FINDER_COLUMN_APPIDMANAGERID_MANAGERID_2 = "scienceAppManager.managerId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPID = new FinderPath(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppManagerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID = new FinderPath(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppManagerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAppId",
			new String[] { Long.class.getName() },
			ScienceAppManagerModelImpl.SCIENCEAPPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPID = new FinderPath(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAppId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the science app managers where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @return the matching science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppManager> findByAppId(long scienceAppId)
		throws SystemException {
		return findByAppId(scienceAppId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the science app managers where scienceAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scienceAppId the science app ID
	 * @param start the lower bound of the range of science app managers
	 * @param end the upper bound of the range of science app managers (not inclusive)
	 * @return the range of matching science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppManager> findByAppId(long scienceAppId, int start,
		int end) throws SystemException {
		return findByAppId(scienceAppId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app managers where scienceAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scienceAppId the science app ID
	 * @param start the lower bound of the range of science app managers
	 * @param end the upper bound of the range of science app managers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppManager> findByAppId(long scienceAppId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID;
			finderArgs = new Object[] { scienceAppId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPID;
			finderArgs = new Object[] {
					scienceAppId,
					
					start, end, orderByComparator
				};
		}

		List<ScienceAppManager> list = (List<ScienceAppManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceAppManager scienceAppManager : list) {
				if ((scienceAppId != scienceAppManager.getScienceAppId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SCIENCEAPPMANAGER_WHERE);

			query.append(_FINDER_COLUMN_APPID_SCIENCEAPPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scienceAppId);

				if (!pagination) {
					list = (List<ScienceAppManager>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppManager>(list);
				}
				else {
					list = (List<ScienceAppManager>)QueryUtil.list(q,
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
	 * Returns the first science app manager in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app manager
	 * @throws com.kisti.science.platform.app.NoSuchManagerException if a matching science app manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager findByAppId_First(long scienceAppId,
		OrderByComparator orderByComparator)
		throws NoSuchManagerException, SystemException {
		ScienceAppManager scienceAppManager = fetchByAppId_First(scienceAppId,
				orderByComparator);

		if (scienceAppManager != null) {
			return scienceAppManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scienceAppId=");
		msg.append(scienceAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchManagerException(msg.toString());
	}

	/**
	 * Returns the first science app manager in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app manager, or <code>null</code> if a matching science app manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager fetchByAppId_First(long scienceAppId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceAppManager> list = findByAppId(scienceAppId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app manager in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app manager
	 * @throws com.kisti.science.platform.app.NoSuchManagerException if a matching science app manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager findByAppId_Last(long scienceAppId,
		OrderByComparator orderByComparator)
		throws NoSuchManagerException, SystemException {
		ScienceAppManager scienceAppManager = fetchByAppId_Last(scienceAppId,
				orderByComparator);

		if (scienceAppManager != null) {
			return scienceAppManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scienceAppId=");
		msg.append(scienceAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchManagerException(msg.toString());
	}

	/**
	 * Returns the last science app manager in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app manager, or <code>null</code> if a matching science app manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager fetchByAppId_Last(long scienceAppId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAppId(scienceAppId);

		if (count == 0) {
			return null;
		}

		List<ScienceAppManager> list = findByAppId(scienceAppId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science app managers before and after the current science app manager in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppManagerId the primary key of the current science app manager
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app manager
	 * @throws com.kisti.science.platform.app.NoSuchManagerException if a science app manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager[] findByAppId_PrevAndNext(
		long scienceAppManagerId, long scienceAppId,
		OrderByComparator orderByComparator)
		throws NoSuchManagerException, SystemException {
		ScienceAppManager scienceAppManager = findByPrimaryKey(scienceAppManagerId);

		Session session = null;

		try {
			session = openSession();

			ScienceAppManager[] array = new ScienceAppManagerImpl[3];

			array[0] = getByAppId_PrevAndNext(session, scienceAppManager,
					scienceAppId, orderByComparator, true);

			array[1] = scienceAppManager;

			array[2] = getByAppId_PrevAndNext(session, scienceAppManager,
					scienceAppId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceAppManager getByAppId_PrevAndNext(Session session,
		ScienceAppManager scienceAppManager, long scienceAppId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPPMANAGER_WHERE);

		query.append(_FINDER_COLUMN_APPID_SCIENCEAPPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ScienceAppManagerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(scienceAppId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceAppManager);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceAppManager> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science app managers where scienceAppId = &#63; from the database.
	 *
	 * @param scienceAppId the science app ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAppId(long scienceAppId) throws SystemException {
		for (ScienceAppManager scienceAppManager : findByAppId(scienceAppId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceAppManager);
		}
	}

	/**
	 * Returns the number of science app managers where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @return the number of matching science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAppId(long scienceAppId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPID;

		Object[] finderArgs = new Object[] { scienceAppId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPPMANAGER_WHERE);

			query.append(_FINDER_COLUMN_APPID_SCIENCEAPPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scienceAppId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_APPID_SCIENCEAPPID_2 = "scienceAppManager.scienceAppId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MANAGERID =
		new FinderPath(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppManagerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByManagerId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANAGERID =
		new FinderPath(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppManagerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByManagerId",
			new String[] { Long.class.getName() },
			ScienceAppManagerModelImpl.MANAGERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MANAGERID = new FinderPath(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByManagerId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the science app managers where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @return the matching science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppManager> findByManagerId(long managerId)
		throws SystemException {
		return findByManagerId(managerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the science app managers where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of science app managers
	 * @param end the upper bound of the range of science app managers (not inclusive)
	 * @return the range of matching science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppManager> findByManagerId(long managerId, int start,
		int end) throws SystemException {
		return findByManagerId(managerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app managers where managerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param managerId the manager ID
	 * @param start the lower bound of the range of science app managers
	 * @param end the upper bound of the range of science app managers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppManager> findByManagerId(long managerId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANAGERID;
			finderArgs = new Object[] { managerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MANAGERID;
			finderArgs = new Object[] { managerId, start, end, orderByComparator };
		}

		List<ScienceAppManager> list = (List<ScienceAppManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceAppManager scienceAppManager : list) {
				if ((managerId != scienceAppManager.getManagerId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SCIENCEAPPMANAGER_WHERE);

			query.append(_FINDER_COLUMN_MANAGERID_MANAGERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppManagerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(managerId);

				if (!pagination) {
					list = (List<ScienceAppManager>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppManager>(list);
				}
				else {
					list = (List<ScienceAppManager>)QueryUtil.list(q,
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
	 * Returns the first science app manager in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app manager
	 * @throws com.kisti.science.platform.app.NoSuchManagerException if a matching science app manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager findByManagerId_First(long managerId,
		OrderByComparator orderByComparator)
		throws NoSuchManagerException, SystemException {
		ScienceAppManager scienceAppManager = fetchByManagerId_First(managerId,
				orderByComparator);

		if (scienceAppManager != null) {
			return scienceAppManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("managerId=");
		msg.append(managerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchManagerException(msg.toString());
	}

	/**
	 * Returns the first science app manager in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app manager, or <code>null</code> if a matching science app manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager fetchByManagerId_First(long managerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceAppManager> list = findByManagerId(managerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app manager in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app manager
	 * @throws com.kisti.science.platform.app.NoSuchManagerException if a matching science app manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager findByManagerId_Last(long managerId,
		OrderByComparator orderByComparator)
		throws NoSuchManagerException, SystemException {
		ScienceAppManager scienceAppManager = fetchByManagerId_Last(managerId,
				orderByComparator);

		if (scienceAppManager != null) {
			return scienceAppManager;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("managerId=");
		msg.append(managerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchManagerException(msg.toString());
	}

	/**
	 * Returns the last science app manager in the ordered set where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app manager, or <code>null</code> if a matching science app manager could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager fetchByManagerId_Last(long managerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByManagerId(managerId);

		if (count == 0) {
			return null;
		}

		List<ScienceAppManager> list = findByManagerId(managerId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science app managers before and after the current science app manager in the ordered set where managerId = &#63;.
	 *
	 * @param scienceAppManagerId the primary key of the current science app manager
	 * @param managerId the manager ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app manager
	 * @throws com.kisti.science.platform.app.NoSuchManagerException if a science app manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager[] findByManagerId_PrevAndNext(
		long scienceAppManagerId, long managerId,
		OrderByComparator orderByComparator)
		throws NoSuchManagerException, SystemException {
		ScienceAppManager scienceAppManager = findByPrimaryKey(scienceAppManagerId);

		Session session = null;

		try {
			session = openSession();

			ScienceAppManager[] array = new ScienceAppManagerImpl[3];

			array[0] = getByManagerId_PrevAndNext(session, scienceAppManager,
					managerId, orderByComparator, true);

			array[1] = scienceAppManager;

			array[2] = getByManagerId_PrevAndNext(session, scienceAppManager,
					managerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceAppManager getByManagerId_PrevAndNext(Session session,
		ScienceAppManager scienceAppManager, long managerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPPMANAGER_WHERE);

		query.append(_FINDER_COLUMN_MANAGERID_MANAGERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ScienceAppManagerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(managerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceAppManager);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceAppManager> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science app managers where managerId = &#63; from the database.
	 *
	 * @param managerId the manager ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByManagerId(long managerId) throws SystemException {
		for (ScienceAppManager scienceAppManager : findByManagerId(managerId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceAppManager);
		}
	}

	/**
	 * Returns the number of science app managers where managerId = &#63;.
	 *
	 * @param managerId the manager ID
	 * @return the number of matching science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByManagerId(long managerId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MANAGERID;

		Object[] finderArgs = new Object[] { managerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPPMANAGER_WHERE);

			query.append(_FINDER_COLUMN_MANAGERID_MANAGERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(managerId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_MANAGERID_MANAGERID_2 = "scienceAppManager.managerId = ?";

	public ScienceAppManagerPersistenceImpl() {
		setModelClass(ScienceAppManager.class);
	}

	/**
	 * Caches the science app manager in the entity cache if it is enabled.
	 *
	 * @param scienceAppManager the science app manager
	 */
	@Override
	public void cacheResult(ScienceAppManager scienceAppManager) {
		EntityCacheUtil.putResult(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerImpl.class, scienceAppManager.getPrimaryKey(),
			scienceAppManager);

		scienceAppManager.resetOriginalValues();
	}

	/**
	 * Caches the science app managers in the entity cache if it is enabled.
	 *
	 * @param scienceAppManagers the science app managers
	 */
	@Override
	public void cacheResult(List<ScienceAppManager> scienceAppManagers) {
		for (ScienceAppManager scienceAppManager : scienceAppManagers) {
			if (EntityCacheUtil.getResult(
						ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppManagerImpl.class,
						scienceAppManager.getPrimaryKey()) == null) {
				cacheResult(scienceAppManager);
			}
			else {
				scienceAppManager.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all science app managers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ScienceAppManagerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ScienceAppManagerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the science app manager.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScienceAppManager scienceAppManager) {
		EntityCacheUtil.removeResult(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerImpl.class, scienceAppManager.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ScienceAppManager> scienceAppManagers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ScienceAppManager scienceAppManager : scienceAppManagers) {
			EntityCacheUtil.removeResult(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppManagerImpl.class, scienceAppManager.getPrimaryKey());
		}
	}

	/**
	 * Creates a new science app manager with the primary key. Does not add the science app manager to the database.
	 *
	 * @param scienceAppManagerId the primary key for the new science app manager
	 * @return the new science app manager
	 */
	@Override
	public ScienceAppManager create(long scienceAppManagerId) {
		ScienceAppManager scienceAppManager = new ScienceAppManagerImpl();

		scienceAppManager.setNew(true);
		scienceAppManager.setPrimaryKey(scienceAppManagerId);

		return scienceAppManager;
	}

	/**
	 * Removes the science app manager with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scienceAppManagerId the primary key of the science app manager
	 * @return the science app manager that was removed
	 * @throws com.kisti.science.platform.app.NoSuchManagerException if a science app manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager remove(long scienceAppManagerId)
		throws NoSuchManagerException, SystemException {
		return remove((Serializable)scienceAppManagerId);
	}

	/**
	 * Removes the science app manager with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the science app manager
	 * @return the science app manager that was removed
	 * @throws com.kisti.science.platform.app.NoSuchManagerException if a science app manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager remove(Serializable primaryKey)
		throws NoSuchManagerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ScienceAppManager scienceAppManager = (ScienceAppManager)session.get(ScienceAppManagerImpl.class,
					primaryKey);

			if (scienceAppManager == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchManagerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scienceAppManager);
		}
		catch (NoSuchManagerException nsee) {
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
	protected ScienceAppManager removeImpl(ScienceAppManager scienceAppManager)
		throws SystemException {
		scienceAppManager = toUnwrappedModel(scienceAppManager);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scienceAppManager)) {
				scienceAppManager = (ScienceAppManager)session.get(ScienceAppManagerImpl.class,
						scienceAppManager.getPrimaryKeyObj());
			}

			if (scienceAppManager != null) {
				session.delete(scienceAppManager);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scienceAppManager != null) {
			clearCache(scienceAppManager);
		}

		return scienceAppManager;
	}

	@Override
	public ScienceAppManager updateImpl(
		com.kisti.science.platform.app.model.ScienceAppManager scienceAppManager)
		throws SystemException {
		scienceAppManager = toUnwrappedModel(scienceAppManager);

		boolean isNew = scienceAppManager.isNew();

		ScienceAppManagerModelImpl scienceAppManagerModelImpl = (ScienceAppManagerModelImpl)scienceAppManager;

		Session session = null;

		try {
			session = openSession();

			if (scienceAppManager.isNew()) {
				session.save(scienceAppManager);

				scienceAppManager.setNew(false);
			}
			else {
				session.merge(scienceAppManager);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ScienceAppManagerModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((scienceAppManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPIDMANAGERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppManagerModelImpl.getOriginalScienceAppId(),
						scienceAppManagerModelImpl.getOriginalManagerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPIDMANAGERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPIDMANAGERID,
					args);

				args = new Object[] {
						scienceAppManagerModelImpl.getScienceAppId(),
						scienceAppManagerModelImpl.getManagerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPIDMANAGERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPIDMANAGERID,
					args);
			}

			if ((scienceAppManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppManagerModelImpl.getOriginalScienceAppId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID,
					args);

				args = new Object[] { scienceAppManagerModelImpl.getScienceAppId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID,
					args);
			}

			if ((scienceAppManagerModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANAGERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppManagerModelImpl.getOriginalManagerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MANAGERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANAGERID,
					args);

				args = new Object[] { scienceAppManagerModelImpl.getManagerId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MANAGERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MANAGERID,
					args);
			}
		}

		EntityCacheUtil.putResult(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppManagerImpl.class, scienceAppManager.getPrimaryKey(),
			scienceAppManager);

		return scienceAppManager;
	}

	protected ScienceAppManager toUnwrappedModel(
		ScienceAppManager scienceAppManager) {
		if (scienceAppManager instanceof ScienceAppManagerImpl) {
			return scienceAppManager;
		}

		ScienceAppManagerImpl scienceAppManagerImpl = new ScienceAppManagerImpl();

		scienceAppManagerImpl.setNew(scienceAppManager.isNew());
		scienceAppManagerImpl.setPrimaryKey(scienceAppManager.getPrimaryKey());

		scienceAppManagerImpl.setScienceAppManagerId(scienceAppManager.getScienceAppManagerId());
		scienceAppManagerImpl.setUserId(scienceAppManager.getUserId());
		scienceAppManagerImpl.setCreateDate(scienceAppManager.getCreateDate());
		scienceAppManagerImpl.setScienceAppId(scienceAppManager.getScienceAppId());
		scienceAppManagerImpl.setManagerId(scienceAppManager.getManagerId());

		return scienceAppManagerImpl;
	}

	/**
	 * Returns the science app manager with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app manager
	 * @return the science app manager
	 * @throws com.kisti.science.platform.app.NoSuchManagerException if a science app manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager findByPrimaryKey(Serializable primaryKey)
		throws NoSuchManagerException, SystemException {
		ScienceAppManager scienceAppManager = fetchByPrimaryKey(primaryKey);

		if (scienceAppManager == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchManagerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return scienceAppManager;
	}

	/**
	 * Returns the science app manager with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchManagerException} if it could not be found.
	 *
	 * @param scienceAppManagerId the primary key of the science app manager
	 * @return the science app manager
	 * @throws com.kisti.science.platform.app.NoSuchManagerException if a science app manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager findByPrimaryKey(long scienceAppManagerId)
		throws NoSuchManagerException, SystemException {
		return findByPrimaryKey((Serializable)scienceAppManagerId);
	}

	/**
	 * Returns the science app manager with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app manager
	 * @return the science app manager, or <code>null</code> if a science app manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ScienceAppManager scienceAppManager = (ScienceAppManager)EntityCacheUtil.getResult(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppManagerImpl.class, primaryKey);

		if (scienceAppManager == _nullScienceAppManager) {
			return null;
		}

		if (scienceAppManager == null) {
			Session session = null;

			try {
				session = openSession();

				scienceAppManager = (ScienceAppManager)session.get(ScienceAppManagerImpl.class,
						primaryKey);

				if (scienceAppManager != null) {
					cacheResult(scienceAppManager);
				}
				else {
					EntityCacheUtil.putResult(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppManagerImpl.class, primaryKey,
						_nullScienceAppManager);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ScienceAppManagerModelImpl.ENTITY_CACHE_ENABLED,
					ScienceAppManagerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return scienceAppManager;
	}

	/**
	 * Returns the science app manager with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scienceAppManagerId the primary key of the science app manager
	 * @return the science app manager, or <code>null</code> if a science app manager with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppManager fetchByPrimaryKey(long scienceAppManagerId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)scienceAppManagerId);
	}

	/**
	 * Returns all the science app managers.
	 *
	 * @return the science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppManager> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science app managers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science app managers
	 * @param end the upper bound of the range of science app managers (not inclusive)
	 * @return the range of science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppManager> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app managers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppManagerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science app managers
	 * @param end the upper bound of the range of science app managers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of science app managers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppManager> findAll(int start, int end,
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

		List<ScienceAppManager> list = (List<ScienceAppManager>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCIENCEAPPMANAGER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCIENCEAPPMANAGER;

				if (pagination) {
					sql = sql.concat(ScienceAppManagerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ScienceAppManager>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppManager>(list);
				}
				else {
					list = (List<ScienceAppManager>)QueryUtil.list(q,
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
	 * Removes all the science app managers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ScienceAppManager scienceAppManager : findAll()) {
			remove(scienceAppManager);
		}
	}

	/**
	 * Returns the number of science app managers.
	 *
	 * @return the number of science app managers
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

				Query q = session.createQuery(_SQL_COUNT_SCIENCEAPPMANAGER);

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
	 * Initializes the science app manager persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kisti.science.platform.app.model.ScienceAppManager")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ScienceAppManager>> listenersList = new ArrayList<ModelListener<ScienceAppManager>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ScienceAppManager>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ScienceAppManagerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SCIENCEAPPMANAGER = "SELECT scienceAppManager FROM ScienceAppManager scienceAppManager";
	private static final String _SQL_SELECT_SCIENCEAPPMANAGER_WHERE = "SELECT scienceAppManager FROM ScienceAppManager scienceAppManager WHERE ";
	private static final String _SQL_COUNT_SCIENCEAPPMANAGER = "SELECT COUNT(scienceAppManager) FROM ScienceAppManager scienceAppManager";
	private static final String _SQL_COUNT_SCIENCEAPPMANAGER_WHERE = "SELECT COUNT(scienceAppManager) FROM ScienceAppManager scienceAppManager WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scienceAppManager.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ScienceAppManager exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ScienceAppManager exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ScienceAppManagerPersistenceImpl.class);
	private static ScienceAppManager _nullScienceAppManager = new ScienceAppManagerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ScienceAppManager> toCacheModel() {
				return _nullScienceAppManagerCacheModel;
			}
		};

	private static CacheModel<ScienceAppManager> _nullScienceAppManagerCacheModel =
		new CacheModel<ScienceAppManager>() {
			@Override
			public ScienceAppManager toEntityModel() {
				return _nullScienceAppManager;
			}
		};
}