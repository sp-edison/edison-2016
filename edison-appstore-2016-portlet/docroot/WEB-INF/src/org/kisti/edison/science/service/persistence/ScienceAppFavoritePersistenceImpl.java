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

import org.kisti.edison.science.NoSuchScienceAppFavoriteException;
import org.kisti.edison.science.model.ScienceAppFavorite;
import org.kisti.edison.science.model.impl.ScienceAppFavoriteImpl;
import org.kisti.edison.science.model.impl.ScienceAppFavoriteModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the science app favorite service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see ScienceAppFavoritePersistence
 * @see ScienceAppFavoriteUtil
 * @generated
 */
public class ScienceAppFavoritePersistenceImpl extends BasePersistenceImpl<ScienceAppFavorite>
	implements ScienceAppFavoritePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScienceAppFavoriteUtil} to access the science app favorite persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScienceAppFavoriteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppFavoriteModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppFavoriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppFavoriteModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppFavoriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppFavoriteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SELECTFAVORITELIST =
		new FinderPath(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppFavoriteModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppFavoriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByselectFavoriteList",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELECTFAVORITELIST =
		new FinderPath(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppFavoriteModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppFavoriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByselectFavoriteList", new String[] { Long.class.getName() },
			ScienceAppFavoriteModelImpl.SCIENCEAPPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SELECTFAVORITELIST = new FinderPath(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppFavoriteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByselectFavoriteList", new String[] { Long.class.getName() });

	/**
	 * Returns all the science app favorites where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @return the matching science app favorites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppFavorite> findByselectFavoriteList(long scienceAppId)
		throws SystemException {
		return findByselectFavoriteList(scienceAppId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science app favorites where scienceAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppFavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scienceAppId the science app ID
	 * @param start the lower bound of the range of science app favorites
	 * @param end the upper bound of the range of science app favorites (not inclusive)
	 * @return the range of matching science app favorites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppFavorite> findByselectFavoriteList(
		long scienceAppId, int start, int end) throws SystemException {
		return findByselectFavoriteList(scienceAppId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app favorites where scienceAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppFavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scienceAppId the science app ID
	 * @param start the lower bound of the range of science app favorites
	 * @param end the upper bound of the range of science app favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science app favorites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppFavorite> findByselectFavoriteList(
		long scienceAppId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELECTFAVORITELIST;
			finderArgs = new Object[] { scienceAppId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SELECTFAVORITELIST;
			finderArgs = new Object[] {
					scienceAppId,
					
					start, end, orderByComparator
				};
		}

		List<ScienceAppFavorite> list = (List<ScienceAppFavorite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceAppFavorite scienceAppFavorite : list) {
				if ((scienceAppId != scienceAppFavorite.getScienceAppId())) {
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

			query.append(_SQL_SELECT_SCIENCEAPPFAVORITE_WHERE);

			query.append(_FINDER_COLUMN_SELECTFAVORITELIST_SCIENCEAPPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppFavoriteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scienceAppId);

				if (!pagination) {
					list = (List<ScienceAppFavorite>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppFavorite>(list);
				}
				else {
					list = (List<ScienceAppFavorite>)QueryUtil.list(q,
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
	 * Returns the first science app favorite in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app favorite
	 * @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a matching science app favorite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite findByselectFavoriteList_First(
		long scienceAppId, OrderByComparator orderByComparator)
		throws NoSuchScienceAppFavoriteException, SystemException {
		ScienceAppFavorite scienceAppFavorite = fetchByselectFavoriteList_First(scienceAppId,
				orderByComparator);

		if (scienceAppFavorite != null) {
			return scienceAppFavorite;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scienceAppId=");
		msg.append(scienceAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppFavoriteException(msg.toString());
	}

	/**
	 * Returns the first science app favorite in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app favorite, or <code>null</code> if a matching science app favorite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite fetchByselectFavoriteList_First(
		long scienceAppId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceAppFavorite> list = findByselectFavoriteList(scienceAppId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app favorite in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app favorite
	 * @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a matching science app favorite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite findByselectFavoriteList_Last(long scienceAppId,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppFavoriteException, SystemException {
		ScienceAppFavorite scienceAppFavorite = fetchByselectFavoriteList_Last(scienceAppId,
				orderByComparator);

		if (scienceAppFavorite != null) {
			return scienceAppFavorite;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scienceAppId=");
		msg.append(scienceAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppFavoriteException(msg.toString());
	}

	/**
	 * Returns the last science app favorite in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app favorite, or <code>null</code> if a matching science app favorite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite fetchByselectFavoriteList_Last(
		long scienceAppId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByselectFavoriteList(scienceAppId);

		if (count == 0) {
			return null;
		}

		List<ScienceAppFavorite> list = findByselectFavoriteList(scienceAppId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science app favorites before and after the current science app favorite in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppFavoritePK the primary key of the current science app favorite
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app favorite
	 * @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a science app favorite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite[] findByselectFavoriteList_PrevAndNext(
		ScienceAppFavoritePK scienceAppFavoritePK, long scienceAppId,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppFavoriteException, SystemException {
		ScienceAppFavorite scienceAppFavorite = findByPrimaryKey(scienceAppFavoritePK);

		Session session = null;

		try {
			session = openSession();

			ScienceAppFavorite[] array = new ScienceAppFavoriteImpl[3];

			array[0] = getByselectFavoriteList_PrevAndNext(session,
					scienceAppFavorite, scienceAppId, orderByComparator, true);

			array[1] = scienceAppFavorite;

			array[2] = getByselectFavoriteList_PrevAndNext(session,
					scienceAppFavorite, scienceAppId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceAppFavorite getByselectFavoriteList_PrevAndNext(
		Session session, ScienceAppFavorite scienceAppFavorite,
		long scienceAppId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPPFAVORITE_WHERE);

		query.append(_FINDER_COLUMN_SELECTFAVORITELIST_SCIENCEAPPID_2);

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
			query.append(ScienceAppFavoriteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(scienceAppId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceAppFavorite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceAppFavorite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science app favorites where scienceAppId = &#63; from the database.
	 *
	 * @param scienceAppId the science app ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByselectFavoriteList(long scienceAppId)
		throws SystemException {
		for (ScienceAppFavorite scienceAppFavorite : findByselectFavoriteList(
				scienceAppId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceAppFavorite);
		}
	}

	/**
	 * Returns the number of science app favorites where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @return the number of matching science app favorites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByselectFavoriteList(long scienceAppId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SELECTFAVORITELIST;

		Object[] finderArgs = new Object[] { scienceAppId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPPFAVORITE_WHERE);

			query.append(_FINDER_COLUMN_SELECTFAVORITELIST_SCIENCEAPPID_2);

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

	private static final String _FINDER_COLUMN_SELECTFAVORITELIST_SCIENCEAPPID_2 =
		"scienceAppFavorite.id.scienceAppId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_SELECTFAVORITEOBJ = new FinderPath(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppFavoriteModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppFavoriteImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByselectFavoriteObj", new String[] { Long.class.getName() },
			ScienceAppFavoriteModelImpl.SCIENCEAPPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SELECTFAVORITEOBJ = new FinderPath(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppFavoriteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByselectFavoriteObj", new String[] { Long.class.getName() });

	/**
	 * Returns the science app favorite where scienceAppId = &#63; or throws a {@link org.kisti.edison.science.NoSuchScienceAppFavoriteException} if it could not be found.
	 *
	 * @param scienceAppId the science app ID
	 * @return the matching science app favorite
	 * @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a matching science app favorite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite findByselectFavoriteObj(long scienceAppId)
		throws NoSuchScienceAppFavoriteException, SystemException {
		ScienceAppFavorite scienceAppFavorite = fetchByselectFavoriteObj(scienceAppId);

		if (scienceAppFavorite == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("scienceAppId=");
			msg.append(scienceAppId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchScienceAppFavoriteException(msg.toString());
		}

		return scienceAppFavorite;
	}

	/**
	 * Returns the science app favorite where scienceAppId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param scienceAppId the science app ID
	 * @return the matching science app favorite, or <code>null</code> if a matching science app favorite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite fetchByselectFavoriteObj(long scienceAppId)
		throws SystemException {
		return fetchByselectFavoriteObj(scienceAppId, true);
	}

	/**
	 * Returns the science app favorite where scienceAppId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param scienceAppId the science app ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching science app favorite, or <code>null</code> if a matching science app favorite could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite fetchByselectFavoriteObj(long scienceAppId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { scienceAppId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SELECTFAVORITEOBJ,
					finderArgs, this);
		}

		if (result instanceof ScienceAppFavorite) {
			ScienceAppFavorite scienceAppFavorite = (ScienceAppFavorite)result;

			if ((scienceAppId != scienceAppFavorite.getScienceAppId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SCIENCEAPPFAVORITE_WHERE);

			query.append(_FINDER_COLUMN_SELECTFAVORITEOBJ_SCIENCEAPPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scienceAppId);

				List<ScienceAppFavorite> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SELECTFAVORITEOBJ,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ScienceAppFavoritePersistenceImpl.fetchByselectFavoriteObj(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ScienceAppFavorite scienceAppFavorite = list.get(0);

					result = scienceAppFavorite;

					cacheResult(scienceAppFavorite);

					if ((scienceAppFavorite.getScienceAppId() != scienceAppId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SELECTFAVORITEOBJ,
							finderArgs, scienceAppFavorite);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SELECTFAVORITEOBJ,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ScienceAppFavorite)result;
		}
	}

	/**
	 * Removes the science app favorite where scienceAppId = &#63; from the database.
	 *
	 * @param scienceAppId the science app ID
	 * @return the science app favorite that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite removeByselectFavoriteObj(long scienceAppId)
		throws NoSuchScienceAppFavoriteException, SystemException {
		ScienceAppFavorite scienceAppFavorite = findByselectFavoriteObj(scienceAppId);

		return remove(scienceAppFavorite);
	}

	/**
	 * Returns the number of science app favorites where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @return the number of matching science app favorites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByselectFavoriteObj(long scienceAppId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SELECTFAVORITEOBJ;

		Object[] finderArgs = new Object[] { scienceAppId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPPFAVORITE_WHERE);

			query.append(_FINDER_COLUMN_SELECTFAVORITEOBJ_SCIENCEAPPID_2);

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

	private static final String _FINDER_COLUMN_SELECTFAVORITEOBJ_SCIENCEAPPID_2 = "scienceAppFavorite.id.scienceAppId = ?";

	public ScienceAppFavoritePersistenceImpl() {
		setModelClass(ScienceAppFavorite.class);
	}

	/**
	 * Caches the science app favorite in the entity cache if it is enabled.
	 *
	 * @param scienceAppFavorite the science app favorite
	 */
	@Override
	public void cacheResult(ScienceAppFavorite scienceAppFavorite) {
		EntityCacheUtil.putResult(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppFavoriteImpl.class, scienceAppFavorite.getPrimaryKey(),
			scienceAppFavorite);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SELECTFAVORITEOBJ,
			new Object[] { scienceAppFavorite.getScienceAppId() },
			scienceAppFavorite);

		scienceAppFavorite.resetOriginalValues();
	}

	/**
	 * Caches the science app favorites in the entity cache if it is enabled.
	 *
	 * @param scienceAppFavorites the science app favorites
	 */
	@Override
	public void cacheResult(List<ScienceAppFavorite> scienceAppFavorites) {
		for (ScienceAppFavorite scienceAppFavorite : scienceAppFavorites) {
			if (EntityCacheUtil.getResult(
						ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppFavoriteImpl.class,
						scienceAppFavorite.getPrimaryKey()) == null) {
				cacheResult(scienceAppFavorite);
			}
			else {
				scienceAppFavorite.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all science app favorites.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ScienceAppFavoriteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ScienceAppFavoriteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the science app favorite.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScienceAppFavorite scienceAppFavorite) {
		EntityCacheUtil.removeResult(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppFavoriteImpl.class, scienceAppFavorite.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(scienceAppFavorite);
	}

	@Override
	public void clearCache(List<ScienceAppFavorite> scienceAppFavorites) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ScienceAppFavorite scienceAppFavorite : scienceAppFavorites) {
			EntityCacheUtil.removeResult(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppFavoriteImpl.class, scienceAppFavorite.getPrimaryKey());

			clearUniqueFindersCache(scienceAppFavorite);
		}
	}

	protected void cacheUniqueFindersCache(
		ScienceAppFavorite scienceAppFavorite) {
		if (scienceAppFavorite.isNew()) {
			Object[] args = new Object[] { scienceAppFavorite.getScienceAppId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SELECTFAVORITEOBJ,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SELECTFAVORITEOBJ,
				args, scienceAppFavorite);
		}
		else {
			ScienceAppFavoriteModelImpl scienceAppFavoriteModelImpl = (ScienceAppFavoriteModelImpl)scienceAppFavorite;

			if ((scienceAppFavoriteModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SELECTFAVORITEOBJ.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppFavorite.getScienceAppId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SELECTFAVORITEOBJ,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SELECTFAVORITEOBJ,
					args, scienceAppFavorite);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ScienceAppFavorite scienceAppFavorite) {
		ScienceAppFavoriteModelImpl scienceAppFavoriteModelImpl = (ScienceAppFavoriteModelImpl)scienceAppFavorite;

		Object[] args = new Object[] { scienceAppFavorite.getScienceAppId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SELECTFAVORITEOBJ,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SELECTFAVORITEOBJ,
			args);

		if ((scienceAppFavoriteModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SELECTFAVORITEOBJ.getColumnBitmask()) != 0) {
			args = new Object[] {
					scienceAppFavoriteModelImpl.getOriginalScienceAppId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SELECTFAVORITEOBJ,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SELECTFAVORITEOBJ,
				args);
		}
	}

	/**
	 * Creates a new science app favorite with the primary key. Does not add the science app favorite to the database.
	 *
	 * @param scienceAppFavoritePK the primary key for the new science app favorite
	 * @return the new science app favorite
	 */
	@Override
	public ScienceAppFavorite create(ScienceAppFavoritePK scienceAppFavoritePK) {
		ScienceAppFavorite scienceAppFavorite = new ScienceAppFavoriteImpl();

		scienceAppFavorite.setNew(true);
		scienceAppFavorite.setPrimaryKey(scienceAppFavoritePK);

		return scienceAppFavorite;
	}

	/**
	 * Removes the science app favorite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scienceAppFavoritePK the primary key of the science app favorite
	 * @return the science app favorite that was removed
	 * @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a science app favorite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite remove(ScienceAppFavoritePK scienceAppFavoritePK)
		throws NoSuchScienceAppFavoriteException, SystemException {
		return remove((Serializable)scienceAppFavoritePK);
	}

	/**
	 * Removes the science app favorite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the science app favorite
	 * @return the science app favorite that was removed
	 * @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a science app favorite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite remove(Serializable primaryKey)
		throws NoSuchScienceAppFavoriteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ScienceAppFavorite scienceAppFavorite = (ScienceAppFavorite)session.get(ScienceAppFavoriteImpl.class,
					primaryKey);

			if (scienceAppFavorite == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScienceAppFavoriteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scienceAppFavorite);
		}
		catch (NoSuchScienceAppFavoriteException nsee) {
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
	protected ScienceAppFavorite removeImpl(
		ScienceAppFavorite scienceAppFavorite) throws SystemException {
		scienceAppFavorite = toUnwrappedModel(scienceAppFavorite);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scienceAppFavorite)) {
				scienceAppFavorite = (ScienceAppFavorite)session.get(ScienceAppFavoriteImpl.class,
						scienceAppFavorite.getPrimaryKeyObj());
			}

			if (scienceAppFavorite != null) {
				session.delete(scienceAppFavorite);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scienceAppFavorite != null) {
			clearCache(scienceAppFavorite);
		}

		return scienceAppFavorite;
	}

	@Override
	public ScienceAppFavorite updateImpl(
		org.kisti.edison.science.model.ScienceAppFavorite scienceAppFavorite)
		throws SystemException {
		scienceAppFavorite = toUnwrappedModel(scienceAppFavorite);

		boolean isNew = scienceAppFavorite.isNew();

		ScienceAppFavoriteModelImpl scienceAppFavoriteModelImpl = (ScienceAppFavoriteModelImpl)scienceAppFavorite;

		Session session = null;

		try {
			session = openSession();

			if (scienceAppFavorite.isNew()) {
				session.save(scienceAppFavorite);

				scienceAppFavorite.setNew(false);
			}
			else {
				session.merge(scienceAppFavorite);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ScienceAppFavoriteModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((scienceAppFavoriteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELECTFAVORITELIST.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppFavoriteModelImpl.getOriginalScienceAppId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SELECTFAVORITELIST,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELECTFAVORITELIST,
					args);

				args = new Object[] {
						scienceAppFavoriteModelImpl.getScienceAppId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SELECTFAVORITELIST,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SELECTFAVORITELIST,
					args);
			}
		}

		EntityCacheUtil.putResult(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppFavoriteImpl.class, scienceAppFavorite.getPrimaryKey(),
			scienceAppFavorite);

		clearUniqueFindersCache(scienceAppFavorite);
		cacheUniqueFindersCache(scienceAppFavorite);

		return scienceAppFavorite;
	}

	protected ScienceAppFavorite toUnwrappedModel(
		ScienceAppFavorite scienceAppFavorite) {
		if (scienceAppFavorite instanceof ScienceAppFavoriteImpl) {
			return scienceAppFavorite;
		}

		ScienceAppFavoriteImpl scienceAppFavoriteImpl = new ScienceAppFavoriteImpl();

		scienceAppFavoriteImpl.setNew(scienceAppFavorite.isNew());
		scienceAppFavoriteImpl.setPrimaryKey(scienceAppFavorite.getPrimaryKey());

		scienceAppFavoriteImpl.setScienceAppId(scienceAppFavorite.getScienceAppId());
		scienceAppFavoriteImpl.setUserId(scienceAppFavorite.getUserId());
		scienceAppFavoriteImpl.setGroupId(scienceAppFavorite.getGroupId());

		return scienceAppFavoriteImpl;
	}

	/**
	 * Returns the science app favorite with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app favorite
	 * @return the science app favorite
	 * @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a science app favorite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite findByPrimaryKey(Serializable primaryKey)
		throws NoSuchScienceAppFavoriteException, SystemException {
		ScienceAppFavorite scienceAppFavorite = fetchByPrimaryKey(primaryKey);

		if (scienceAppFavorite == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchScienceAppFavoriteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return scienceAppFavorite;
	}

	/**
	 * Returns the science app favorite with the primary key or throws a {@link org.kisti.edison.science.NoSuchScienceAppFavoriteException} if it could not be found.
	 *
	 * @param scienceAppFavoritePK the primary key of the science app favorite
	 * @return the science app favorite
	 * @throws org.kisti.edison.science.NoSuchScienceAppFavoriteException if a science app favorite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite findByPrimaryKey(
		ScienceAppFavoritePK scienceAppFavoritePK)
		throws NoSuchScienceAppFavoriteException, SystemException {
		return findByPrimaryKey((Serializable)scienceAppFavoritePK);
	}

	/**
	 * Returns the science app favorite with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app favorite
	 * @return the science app favorite, or <code>null</code> if a science app favorite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ScienceAppFavorite scienceAppFavorite = (ScienceAppFavorite)EntityCacheUtil.getResult(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppFavoriteImpl.class, primaryKey);

		if (scienceAppFavorite == _nullScienceAppFavorite) {
			return null;
		}

		if (scienceAppFavorite == null) {
			Session session = null;

			try {
				session = openSession();

				scienceAppFavorite = (ScienceAppFavorite)session.get(ScienceAppFavoriteImpl.class,
						primaryKey);

				if (scienceAppFavorite != null) {
					cacheResult(scienceAppFavorite);
				}
				else {
					EntityCacheUtil.putResult(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppFavoriteImpl.class, primaryKey,
						_nullScienceAppFavorite);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ScienceAppFavoriteModelImpl.ENTITY_CACHE_ENABLED,
					ScienceAppFavoriteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return scienceAppFavorite;
	}

	/**
	 * Returns the science app favorite with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scienceAppFavoritePK the primary key of the science app favorite
	 * @return the science app favorite, or <code>null</code> if a science app favorite with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppFavorite fetchByPrimaryKey(
		ScienceAppFavoritePK scienceAppFavoritePK) throws SystemException {
		return fetchByPrimaryKey((Serializable)scienceAppFavoritePK);
	}

	/**
	 * Returns all the science app favorites.
	 *
	 * @return the science app favorites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppFavorite> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science app favorites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppFavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science app favorites
	 * @param end the upper bound of the range of science app favorites (not inclusive)
	 * @return the range of science app favorites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppFavorite> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app favorites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppFavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science app favorites
	 * @param end the upper bound of the range of science app favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of science app favorites
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppFavorite> findAll(int start, int end,
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

		List<ScienceAppFavorite> list = (List<ScienceAppFavorite>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCIENCEAPPFAVORITE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCIENCEAPPFAVORITE;

				if (pagination) {
					sql = sql.concat(ScienceAppFavoriteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ScienceAppFavorite>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppFavorite>(list);
				}
				else {
					list = (List<ScienceAppFavorite>)QueryUtil.list(q,
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
	 * Removes all the science app favorites from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ScienceAppFavorite scienceAppFavorite : findAll()) {
			remove(scienceAppFavorite);
		}
	}

	/**
	 * Returns the number of science app favorites.
	 *
	 * @return the number of science app favorites
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

				Query q = session.createQuery(_SQL_COUNT_SCIENCEAPPFAVORITE);

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
	 * Initializes the science app favorite persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.science.model.ScienceAppFavorite")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ScienceAppFavorite>> listenersList = new ArrayList<ModelListener<ScienceAppFavorite>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ScienceAppFavorite>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ScienceAppFavoriteImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SCIENCEAPPFAVORITE = "SELECT scienceAppFavorite FROM ScienceAppFavorite scienceAppFavorite";
	private static final String _SQL_SELECT_SCIENCEAPPFAVORITE_WHERE = "SELECT scienceAppFavorite FROM ScienceAppFavorite scienceAppFavorite WHERE ";
	private static final String _SQL_COUNT_SCIENCEAPPFAVORITE = "SELECT COUNT(scienceAppFavorite) FROM ScienceAppFavorite scienceAppFavorite";
	private static final String _SQL_COUNT_SCIENCEAPPFAVORITE_WHERE = "SELECT COUNT(scienceAppFavorite) FROM ScienceAppFavorite scienceAppFavorite WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scienceAppFavorite.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ScienceAppFavorite exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ScienceAppFavorite exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ScienceAppFavoritePersistenceImpl.class);
	private static ScienceAppFavorite _nullScienceAppFavorite = new ScienceAppFavoriteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ScienceAppFavorite> toCacheModel() {
				return _nullScienceAppFavoriteCacheModel;
			}
		};

	private static CacheModel<ScienceAppFavorite> _nullScienceAppFavoriteCacheModel =
		new CacheModel<ScienceAppFavorite>() {
			@Override
			public ScienceAppFavorite toEntityModel() {
				return _nullScienceAppFavorite;
			}
		};
}