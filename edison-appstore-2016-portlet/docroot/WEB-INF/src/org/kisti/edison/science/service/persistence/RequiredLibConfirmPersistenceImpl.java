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

import org.kisti.edison.science.NoSuchRequiredLibConfirmException;
import org.kisti.edison.science.model.RequiredLibConfirm;
import org.kisti.edison.science.model.impl.RequiredLibConfirmImpl;
import org.kisti.edison.science.model.impl.RequiredLibConfirmModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the required lib confirm service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see RequiredLibConfirmPersistence
 * @see RequiredLibConfirmUtil
 * @generated
 */
public class RequiredLibConfirmPersistenceImpl extends BasePersistenceImpl<RequiredLibConfirm>
	implements RequiredLibConfirmPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RequiredLibConfirmUtil} to access the required lib confirm persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RequiredLibConfirmImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibConfirmModelImpl.FINDER_CACHE_ENABLED,
			RequiredLibConfirmImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibConfirmModelImpl.FINDER_CACHE_ENABLED,
			RequiredLibConfirmImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibConfirmModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SCIENCEAPPID =
		new FinderPath(RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibConfirmModelImpl.FINDER_CACHE_ENABLED,
			RequiredLibConfirmImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByScienceAppId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCIENCEAPPID =
		new FinderPath(RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibConfirmModelImpl.FINDER_CACHE_ENABLED,
			RequiredLibConfirmImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByScienceAppId",
			new String[] { Long.class.getName() },
			RequiredLibConfirmModelImpl.SCIENCEAPPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SCIENCEAPPID = new FinderPath(RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibConfirmModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByScienceAppId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the required lib confirms where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @return the matching required lib confirms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RequiredLibConfirm> findByScienceAppId(long scienceAppId)
		throws SystemException {
		return findByScienceAppId(scienceAppId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the required lib confirms where scienceAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibConfirmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scienceAppId the science app ID
	 * @param start the lower bound of the range of required lib confirms
	 * @param end the upper bound of the range of required lib confirms (not inclusive)
	 * @return the range of matching required lib confirms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RequiredLibConfirm> findByScienceAppId(long scienceAppId,
		int start, int end) throws SystemException {
		return findByScienceAppId(scienceAppId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the required lib confirms where scienceAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibConfirmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scienceAppId the science app ID
	 * @param start the lower bound of the range of required lib confirms
	 * @param end the upper bound of the range of required lib confirms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching required lib confirms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RequiredLibConfirm> findByScienceAppId(long scienceAppId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCIENCEAPPID;
			finderArgs = new Object[] { scienceAppId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SCIENCEAPPID;
			finderArgs = new Object[] {
					scienceAppId,
					
					start, end, orderByComparator
				};
		}

		List<RequiredLibConfirm> list = (List<RequiredLibConfirm>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (RequiredLibConfirm requiredLibConfirm : list) {
				if ((scienceAppId != requiredLibConfirm.getScienceAppId())) {
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

			query.append(_SQL_SELECT_REQUIREDLIBCONFIRM_WHERE);

			query.append(_FINDER_COLUMN_SCIENCEAPPID_SCIENCEAPPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RequiredLibConfirmModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scienceAppId);

				if (!pagination) {
					list = (List<RequiredLibConfirm>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RequiredLibConfirm>(list);
				}
				else {
					list = (List<RequiredLibConfirm>)QueryUtil.list(q,
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
	 * Returns the first required lib confirm in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching required lib confirm
	 * @throws org.kisti.edison.science.NoSuchRequiredLibConfirmException if a matching required lib confirm could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLibConfirm findByScienceAppId_First(long scienceAppId,
		OrderByComparator orderByComparator)
		throws NoSuchRequiredLibConfirmException, SystemException {
		RequiredLibConfirm requiredLibConfirm = fetchByScienceAppId_First(scienceAppId,
				orderByComparator);

		if (requiredLibConfirm != null) {
			return requiredLibConfirm;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scienceAppId=");
		msg.append(scienceAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequiredLibConfirmException(msg.toString());
	}

	/**
	 * Returns the first required lib confirm in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching required lib confirm, or <code>null</code> if a matching required lib confirm could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLibConfirm fetchByScienceAppId_First(long scienceAppId,
		OrderByComparator orderByComparator) throws SystemException {
		List<RequiredLibConfirm> list = findByScienceAppId(scienceAppId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last required lib confirm in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching required lib confirm
	 * @throws org.kisti.edison.science.NoSuchRequiredLibConfirmException if a matching required lib confirm could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLibConfirm findByScienceAppId_Last(long scienceAppId,
		OrderByComparator orderByComparator)
		throws NoSuchRequiredLibConfirmException, SystemException {
		RequiredLibConfirm requiredLibConfirm = fetchByScienceAppId_Last(scienceAppId,
				orderByComparator);

		if (requiredLibConfirm != null) {
			return requiredLibConfirm;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scienceAppId=");
		msg.append(scienceAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRequiredLibConfirmException(msg.toString());
	}

	/**
	 * Returns the last required lib confirm in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching required lib confirm, or <code>null</code> if a matching required lib confirm could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLibConfirm fetchByScienceAppId_Last(long scienceAppId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByScienceAppId(scienceAppId);

		if (count == 0) {
			return null;
		}

		List<RequiredLibConfirm> list = findByScienceAppId(scienceAppId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the required lib confirms before and after the current required lib confirm in the ordered set where scienceAppId = &#63;.
	 *
	 * @param requiredLibConfirmPK the primary key of the current required lib confirm
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next required lib confirm
	 * @throws org.kisti.edison.science.NoSuchRequiredLibConfirmException if a required lib confirm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLibConfirm[] findByScienceAppId_PrevAndNext(
		RequiredLibConfirmPK requiredLibConfirmPK, long scienceAppId,
		OrderByComparator orderByComparator)
		throws NoSuchRequiredLibConfirmException, SystemException {
		RequiredLibConfirm requiredLibConfirm = findByPrimaryKey(requiredLibConfirmPK);

		Session session = null;

		try {
			session = openSession();

			RequiredLibConfirm[] array = new RequiredLibConfirmImpl[3];

			array[0] = getByScienceAppId_PrevAndNext(session,
					requiredLibConfirm, scienceAppId, orderByComparator, true);

			array[1] = requiredLibConfirm;

			array[2] = getByScienceAppId_PrevAndNext(session,
					requiredLibConfirm, scienceAppId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RequiredLibConfirm getByScienceAppId_PrevAndNext(
		Session session, RequiredLibConfirm requiredLibConfirm,
		long scienceAppId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_REQUIREDLIBCONFIRM_WHERE);

		query.append(_FINDER_COLUMN_SCIENCEAPPID_SCIENCEAPPID_2);

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
			query.append(RequiredLibConfirmModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(scienceAppId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(requiredLibConfirm);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<RequiredLibConfirm> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the required lib confirms where scienceAppId = &#63; from the database.
	 *
	 * @param scienceAppId the science app ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByScienceAppId(long scienceAppId)
		throws SystemException {
		for (RequiredLibConfirm requiredLibConfirm : findByScienceAppId(
				scienceAppId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(requiredLibConfirm);
		}
	}

	/**
	 * Returns the number of required lib confirms where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @return the number of matching required lib confirms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByScienceAppId(long scienceAppId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SCIENCEAPPID;

		Object[] finderArgs = new Object[] { scienceAppId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_REQUIREDLIBCONFIRM_WHERE);

			query.append(_FINDER_COLUMN_SCIENCEAPPID_SCIENCEAPPID_2);

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

	private static final String _FINDER_COLUMN_SCIENCEAPPID_SCIENCEAPPID_2 = "requiredLibConfirm.id.scienceAppId = ?";

	public RequiredLibConfirmPersistenceImpl() {
		setModelClass(RequiredLibConfirm.class);
	}

	/**
	 * Caches the required lib confirm in the entity cache if it is enabled.
	 *
	 * @param requiredLibConfirm the required lib confirm
	 */
	@Override
	public void cacheResult(RequiredLibConfirm requiredLibConfirm) {
		EntityCacheUtil.putResult(RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibConfirmImpl.class, requiredLibConfirm.getPrimaryKey(),
			requiredLibConfirm);

		requiredLibConfirm.resetOriginalValues();
	}

	/**
	 * Caches the required lib confirms in the entity cache if it is enabled.
	 *
	 * @param requiredLibConfirms the required lib confirms
	 */
	@Override
	public void cacheResult(List<RequiredLibConfirm> requiredLibConfirms) {
		for (RequiredLibConfirm requiredLibConfirm : requiredLibConfirms) {
			if (EntityCacheUtil.getResult(
						RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
						RequiredLibConfirmImpl.class,
						requiredLibConfirm.getPrimaryKey()) == null) {
				cacheResult(requiredLibConfirm);
			}
			else {
				requiredLibConfirm.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all required lib confirms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RequiredLibConfirmImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RequiredLibConfirmImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the required lib confirm.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RequiredLibConfirm requiredLibConfirm) {
		EntityCacheUtil.removeResult(RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibConfirmImpl.class, requiredLibConfirm.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RequiredLibConfirm> requiredLibConfirms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RequiredLibConfirm requiredLibConfirm : requiredLibConfirms) {
			EntityCacheUtil.removeResult(RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
				RequiredLibConfirmImpl.class, requiredLibConfirm.getPrimaryKey());
		}
	}

	/**
	 * Creates a new required lib confirm with the primary key. Does not add the required lib confirm to the database.
	 *
	 * @param requiredLibConfirmPK the primary key for the new required lib confirm
	 * @return the new required lib confirm
	 */
	@Override
	public RequiredLibConfirm create(RequiredLibConfirmPK requiredLibConfirmPK) {
		RequiredLibConfirm requiredLibConfirm = new RequiredLibConfirmImpl();

		requiredLibConfirm.setNew(true);
		requiredLibConfirm.setPrimaryKey(requiredLibConfirmPK);

		return requiredLibConfirm;
	}

	/**
	 * Removes the required lib confirm with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param requiredLibConfirmPK the primary key of the required lib confirm
	 * @return the required lib confirm that was removed
	 * @throws org.kisti.edison.science.NoSuchRequiredLibConfirmException if a required lib confirm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLibConfirm remove(RequiredLibConfirmPK requiredLibConfirmPK)
		throws NoSuchRequiredLibConfirmException, SystemException {
		return remove((Serializable)requiredLibConfirmPK);
	}

	/**
	 * Removes the required lib confirm with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the required lib confirm
	 * @return the required lib confirm that was removed
	 * @throws org.kisti.edison.science.NoSuchRequiredLibConfirmException if a required lib confirm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLibConfirm remove(Serializable primaryKey)
		throws NoSuchRequiredLibConfirmException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RequiredLibConfirm requiredLibConfirm = (RequiredLibConfirm)session.get(RequiredLibConfirmImpl.class,
					primaryKey);

			if (requiredLibConfirm == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRequiredLibConfirmException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(requiredLibConfirm);
		}
		catch (NoSuchRequiredLibConfirmException nsee) {
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
	protected RequiredLibConfirm removeImpl(
		RequiredLibConfirm requiredLibConfirm) throws SystemException {
		requiredLibConfirm = toUnwrappedModel(requiredLibConfirm);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(requiredLibConfirm)) {
				requiredLibConfirm = (RequiredLibConfirm)session.get(RequiredLibConfirmImpl.class,
						requiredLibConfirm.getPrimaryKeyObj());
			}

			if (requiredLibConfirm != null) {
				session.delete(requiredLibConfirm);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (requiredLibConfirm != null) {
			clearCache(requiredLibConfirm);
		}

		return requiredLibConfirm;
	}

	@Override
	public RequiredLibConfirm updateImpl(
		org.kisti.edison.science.model.RequiredLibConfirm requiredLibConfirm)
		throws SystemException {
		requiredLibConfirm = toUnwrappedModel(requiredLibConfirm);

		boolean isNew = requiredLibConfirm.isNew();

		RequiredLibConfirmModelImpl requiredLibConfirmModelImpl = (RequiredLibConfirmModelImpl)requiredLibConfirm;

		Session session = null;

		try {
			session = openSession();

			if (requiredLibConfirm.isNew()) {
				session.save(requiredLibConfirm);

				requiredLibConfirm.setNew(false);
			}
			else {
				session.merge(requiredLibConfirm);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RequiredLibConfirmModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((requiredLibConfirmModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCIENCEAPPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						requiredLibConfirmModelImpl.getOriginalScienceAppId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCIENCEAPPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCIENCEAPPID,
					args);

				args = new Object[] {
						requiredLibConfirmModelImpl.getScienceAppId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SCIENCEAPPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SCIENCEAPPID,
					args);
			}
		}

		EntityCacheUtil.putResult(RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
			RequiredLibConfirmImpl.class, requiredLibConfirm.getPrimaryKey(),
			requiredLibConfirm);

		return requiredLibConfirm;
	}

	protected RequiredLibConfirm toUnwrappedModel(
		RequiredLibConfirm requiredLibConfirm) {
		if (requiredLibConfirm instanceof RequiredLibConfirmImpl) {
			return requiredLibConfirm;
		}

		RequiredLibConfirmImpl requiredLibConfirmImpl = new RequiredLibConfirmImpl();

		requiredLibConfirmImpl.setNew(requiredLibConfirm.isNew());
		requiredLibConfirmImpl.setPrimaryKey(requiredLibConfirm.getPrimaryKey());

		requiredLibConfirmImpl.setRequiredLibId(requiredLibConfirm.getRequiredLibId());
		requiredLibConfirmImpl.setScienceAppId(requiredLibConfirm.getScienceAppId());
		requiredLibConfirmImpl.setCompanyId(requiredLibConfirm.getCompanyId());
		requiredLibConfirmImpl.setUserId(requiredLibConfirm.getUserId());
		requiredLibConfirmImpl.setRequiredDate(requiredLibConfirm.getRequiredDate());
		requiredLibConfirmImpl.setConfirmDate(requiredLibConfirm.getConfirmDate());
		requiredLibConfirmImpl.setLibraryName(requiredLibConfirm.getLibraryName());
		requiredLibConfirmImpl.setLibraryVersion(requiredLibConfirm.getLibraryVersion());
		requiredLibConfirmImpl.setRequiredContent(requiredLibConfirm.getRequiredContent());
		requiredLibConfirmImpl.setRequiredState(requiredLibConfirm.getRequiredState());
		requiredLibConfirmImpl.setConfirmContent(requiredLibConfirm.getConfirmContent());

		return requiredLibConfirmImpl;
	}

	/**
	 * Returns the required lib confirm with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the required lib confirm
	 * @return the required lib confirm
	 * @throws org.kisti.edison.science.NoSuchRequiredLibConfirmException if a required lib confirm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLibConfirm findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRequiredLibConfirmException, SystemException {
		RequiredLibConfirm requiredLibConfirm = fetchByPrimaryKey(primaryKey);

		if (requiredLibConfirm == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRequiredLibConfirmException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return requiredLibConfirm;
	}

	/**
	 * Returns the required lib confirm with the primary key or throws a {@link org.kisti.edison.science.NoSuchRequiredLibConfirmException} if it could not be found.
	 *
	 * @param requiredLibConfirmPK the primary key of the required lib confirm
	 * @return the required lib confirm
	 * @throws org.kisti.edison.science.NoSuchRequiredLibConfirmException if a required lib confirm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLibConfirm findByPrimaryKey(
		RequiredLibConfirmPK requiredLibConfirmPK)
		throws NoSuchRequiredLibConfirmException, SystemException {
		return findByPrimaryKey((Serializable)requiredLibConfirmPK);
	}

	/**
	 * Returns the required lib confirm with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the required lib confirm
	 * @return the required lib confirm, or <code>null</code> if a required lib confirm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLibConfirm fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RequiredLibConfirm requiredLibConfirm = (RequiredLibConfirm)EntityCacheUtil.getResult(RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
				RequiredLibConfirmImpl.class, primaryKey);

		if (requiredLibConfirm == _nullRequiredLibConfirm) {
			return null;
		}

		if (requiredLibConfirm == null) {
			Session session = null;

			try {
				session = openSession();

				requiredLibConfirm = (RequiredLibConfirm)session.get(RequiredLibConfirmImpl.class,
						primaryKey);

				if (requiredLibConfirm != null) {
					cacheResult(requiredLibConfirm);
				}
				else {
					EntityCacheUtil.putResult(RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
						RequiredLibConfirmImpl.class, primaryKey,
						_nullRequiredLibConfirm);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RequiredLibConfirmModelImpl.ENTITY_CACHE_ENABLED,
					RequiredLibConfirmImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return requiredLibConfirm;
	}

	/**
	 * Returns the required lib confirm with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param requiredLibConfirmPK the primary key of the required lib confirm
	 * @return the required lib confirm, or <code>null</code> if a required lib confirm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RequiredLibConfirm fetchByPrimaryKey(
		RequiredLibConfirmPK requiredLibConfirmPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)requiredLibConfirmPK);
	}

	/**
	 * Returns all the required lib confirms.
	 *
	 * @return the required lib confirms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RequiredLibConfirm> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the required lib confirms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibConfirmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of required lib confirms
	 * @param end the upper bound of the range of required lib confirms (not inclusive)
	 * @return the range of required lib confirms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RequiredLibConfirm> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the required lib confirms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.RequiredLibConfirmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of required lib confirms
	 * @param end the upper bound of the range of required lib confirms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of required lib confirms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RequiredLibConfirm> findAll(int start, int end,
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

		List<RequiredLibConfirm> list = (List<RequiredLibConfirm>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_REQUIREDLIBCONFIRM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_REQUIREDLIBCONFIRM;

				if (pagination) {
					sql = sql.concat(RequiredLibConfirmModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RequiredLibConfirm>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RequiredLibConfirm>(list);
				}
				else {
					list = (List<RequiredLibConfirm>)QueryUtil.list(q,
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
	 * Removes all the required lib confirms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RequiredLibConfirm requiredLibConfirm : findAll()) {
			remove(requiredLibConfirm);
		}
	}

	/**
	 * Returns the number of required lib confirms.
	 *
	 * @return the number of required lib confirms
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

				Query q = session.createQuery(_SQL_COUNT_REQUIREDLIBCONFIRM);

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
	 * Initializes the required lib confirm persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.science.model.RequiredLibConfirm")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RequiredLibConfirm>> listenersList = new ArrayList<ModelListener<RequiredLibConfirm>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RequiredLibConfirm>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RequiredLibConfirmImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_REQUIREDLIBCONFIRM = "SELECT requiredLibConfirm FROM RequiredLibConfirm requiredLibConfirm";
	private static final String _SQL_SELECT_REQUIREDLIBCONFIRM_WHERE = "SELECT requiredLibConfirm FROM RequiredLibConfirm requiredLibConfirm WHERE ";
	private static final String _SQL_COUNT_REQUIREDLIBCONFIRM = "SELECT COUNT(requiredLibConfirm) FROM RequiredLibConfirm requiredLibConfirm";
	private static final String _SQL_COUNT_REQUIREDLIBCONFIRM_WHERE = "SELECT COUNT(requiredLibConfirm) FROM RequiredLibConfirm requiredLibConfirm WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "requiredLibConfirm.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RequiredLibConfirm exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RequiredLibConfirm exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RequiredLibConfirmPersistenceImpl.class);
	private static RequiredLibConfirm _nullRequiredLibConfirm = new RequiredLibConfirmImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RequiredLibConfirm> toCacheModel() {
				return _nullRequiredLibConfirmCacheModel;
			}
		};

	private static CacheModel<RequiredLibConfirm> _nullRequiredLibConfirmCacheModel =
		new CacheModel<RequiredLibConfirm>() {
			@Override
			public RequiredLibConfirm toEntityModel() {
				return _nullRequiredLibConfirm;
			}
		};
}