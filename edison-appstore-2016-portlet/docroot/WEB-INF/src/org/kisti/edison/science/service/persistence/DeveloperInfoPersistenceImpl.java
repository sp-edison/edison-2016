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

import org.kisti.edison.science.NoSuchDeveloperInfoException;
import org.kisti.edison.science.model.DeveloperInfo;
import org.kisti.edison.science.model.impl.DeveloperInfoImpl;
import org.kisti.edison.science.model.impl.DeveloperInfoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the developer info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see DeveloperInfoPersistence
 * @see DeveloperInfoUtil
 * @generated
 */
public class DeveloperInfoPersistenceImpl extends BasePersistenceImpl<DeveloperInfo>
	implements DeveloperInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DeveloperInfoUtil} to access the developer info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DeveloperInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperInfoModelImpl.FINDER_CACHE_ENABLED,
			DeveloperInfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperInfoModelImpl.FINDER_CACHE_ENABLED,
			DeveloperInfoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperInfoModelImpl.FINDER_CACHE_ENABLED,
			DeveloperInfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperInfoModelImpl.FINDER_CACHE_ENABLED,
			DeveloperInfoImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserId", new String[] { Long.class.getName() },
			DeveloperInfoModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the developer infos where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching developer infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperInfo> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the developer infos where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of developer infos
	 * @param end the upper bound of the range of developer infos (not inclusive)
	 * @return the range of matching developer infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperInfo> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the developer infos where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of developer infos
	 * @param end the upper bound of the range of developer infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching developer infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperInfo> findByUserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<DeveloperInfo> list = (List<DeveloperInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DeveloperInfo developerInfo : list) {
				if ((userId != developerInfo.getUserId())) {
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

			query.append(_SQL_SELECT_DEVELOPERINFO_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DeveloperInfoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<DeveloperInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeveloperInfo>(list);
				}
				else {
					list = (List<DeveloperInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first developer info in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching developer info
	 * @throws org.kisti.edison.science.NoSuchDeveloperInfoException if a matching developer info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperInfo findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchDeveloperInfoException, SystemException {
		DeveloperInfo developerInfo = fetchByUserId_First(userId,
				orderByComparator);

		if (developerInfo != null) {
			return developerInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeveloperInfoException(msg.toString());
	}

	/**
	 * Returns the first developer info in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching developer info, or <code>null</code> if a matching developer info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperInfo fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DeveloperInfo> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last developer info in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching developer info
	 * @throws org.kisti.edison.science.NoSuchDeveloperInfoException if a matching developer info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperInfo findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchDeveloperInfoException, SystemException {
		DeveloperInfo developerInfo = fetchByUserId_Last(userId,
				orderByComparator);

		if (developerInfo != null) {
			return developerInfo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeveloperInfoException(msg.toString());
	}

	/**
	 * Returns the last developer info in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching developer info, or <code>null</code> if a matching developer info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperInfo fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<DeveloperInfo> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the developer infos before and after the current developer info in the ordered set where userId = &#63;.
	 *
	 * @param developerInfoPK the primary key of the current developer info
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next developer info
	 * @throws org.kisti.edison.science.NoSuchDeveloperInfoException if a developer info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperInfo[] findByUserId_PrevAndNext(
		DeveloperInfoPK developerInfoPK, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchDeveloperInfoException, SystemException {
		DeveloperInfo developerInfo = findByPrimaryKey(developerInfoPK);

		Session session = null;

		try {
			session = openSession();

			DeveloperInfo[] array = new DeveloperInfoImpl[3];

			array[0] = getByUserId_PrevAndNext(session, developerInfo, userId,
					orderByComparator, true);

			array[1] = developerInfo;

			array[2] = getByUserId_PrevAndNext(session, developerInfo, userId,
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

	protected DeveloperInfo getByUserId_PrevAndNext(Session session,
		DeveloperInfo developerInfo, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEVELOPERINFO_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(DeveloperInfoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(developerInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DeveloperInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the developer infos where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (DeveloperInfo developerInfo : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(developerInfo);
		}
	}

	/**
	 * Returns the number of developer infos where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching developer infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEVELOPERINFO_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "developerInfo.id.userId = ?";

	public DeveloperInfoPersistenceImpl() {
		setModelClass(DeveloperInfo.class);
	}

	/**
	 * Caches the developer info in the entity cache if it is enabled.
	 *
	 * @param developerInfo the developer info
	 */
	@Override
	public void cacheResult(DeveloperInfo developerInfo) {
		EntityCacheUtil.putResult(DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperInfoImpl.class, developerInfo.getPrimaryKey(),
			developerInfo);

		developerInfo.resetOriginalValues();
	}

	/**
	 * Caches the developer infos in the entity cache if it is enabled.
	 *
	 * @param developerInfos the developer infos
	 */
	@Override
	public void cacheResult(List<DeveloperInfo> developerInfos) {
		for (DeveloperInfo developerInfo : developerInfos) {
			if (EntityCacheUtil.getResult(
						DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
						DeveloperInfoImpl.class, developerInfo.getPrimaryKey()) == null) {
				cacheResult(developerInfo);
			}
			else {
				developerInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all developer infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DeveloperInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DeveloperInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the developer info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DeveloperInfo developerInfo) {
		EntityCacheUtil.removeResult(DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperInfoImpl.class, developerInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DeveloperInfo> developerInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DeveloperInfo developerInfo : developerInfos) {
			EntityCacheUtil.removeResult(DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
				DeveloperInfoImpl.class, developerInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new developer info with the primary key. Does not add the developer info to the database.
	 *
	 * @param developerInfoPK the primary key for the new developer info
	 * @return the new developer info
	 */
	@Override
	public DeveloperInfo create(DeveloperInfoPK developerInfoPK) {
		DeveloperInfo developerInfo = new DeveloperInfoImpl();

		developerInfo.setNew(true);
		developerInfo.setPrimaryKey(developerInfoPK);

		return developerInfo;
	}

	/**
	 * Removes the developer info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param developerInfoPK the primary key of the developer info
	 * @return the developer info that was removed
	 * @throws org.kisti.edison.science.NoSuchDeveloperInfoException if a developer info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperInfo remove(DeveloperInfoPK developerInfoPK)
		throws NoSuchDeveloperInfoException, SystemException {
		return remove((Serializable)developerInfoPK);
	}

	/**
	 * Removes the developer info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the developer info
	 * @return the developer info that was removed
	 * @throws org.kisti.edison.science.NoSuchDeveloperInfoException if a developer info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperInfo remove(Serializable primaryKey)
		throws NoSuchDeveloperInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DeveloperInfo developerInfo = (DeveloperInfo)session.get(DeveloperInfoImpl.class,
					primaryKey);

			if (developerInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDeveloperInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(developerInfo);
		}
		catch (NoSuchDeveloperInfoException nsee) {
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
	protected DeveloperInfo removeImpl(DeveloperInfo developerInfo)
		throws SystemException {
		developerInfo = toUnwrappedModel(developerInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(developerInfo)) {
				developerInfo = (DeveloperInfo)session.get(DeveloperInfoImpl.class,
						developerInfo.getPrimaryKeyObj());
			}

			if (developerInfo != null) {
				session.delete(developerInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (developerInfo != null) {
			clearCache(developerInfo);
		}

		return developerInfo;
	}

	@Override
	public DeveloperInfo updateImpl(
		org.kisti.edison.science.model.DeveloperInfo developerInfo)
		throws SystemException {
		developerInfo = toUnwrappedModel(developerInfo);

		boolean isNew = developerInfo.isNew();

		DeveloperInfoModelImpl developerInfoModelImpl = (DeveloperInfoModelImpl)developerInfo;

		Session session = null;

		try {
			session = openSession();

			if (developerInfo.isNew()) {
				session.save(developerInfo);

				developerInfo.setNew(false);
			}
			else {
				session.merge(developerInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DeveloperInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((developerInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						developerInfoModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { developerInfoModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperInfoImpl.class, developerInfo.getPrimaryKey(),
			developerInfo);

		return developerInfo;
	}

	protected DeveloperInfo toUnwrappedModel(DeveloperInfo developerInfo) {
		if (developerInfo instanceof DeveloperInfoImpl) {
			return developerInfo;
		}

		DeveloperInfoImpl developerInfoImpl = new DeveloperInfoImpl();

		developerInfoImpl.setNew(developerInfo.isNew());
		developerInfoImpl.setPrimaryKey(developerInfo.getPrimaryKey());

		developerInfoImpl.setUserId(developerInfo.getUserId());
		developerInfoImpl.setGroupId(developerInfo.getGroupId());
		developerInfoImpl.setScreenName(developerInfo.getScreenName());
		developerInfoImpl.setFirstName(developerInfo.getFirstName());
		developerInfoImpl.setEmailAddress(developerInfo.getEmailAddress());
		developerInfoImpl.setUniversityField(developerInfo.getUniversityField());
		developerInfoImpl.setMajorField(developerInfo.getMajorField());
		developerInfoImpl.setUseStart(developerInfo.getUseStart());
		developerInfoImpl.setUseEnd(developerInfo.getUseEnd());
		developerInfoImpl.setDeveloperSort(developerInfo.getDeveloperSort());
		developerInfoImpl.setLanguageFortran(developerInfo.isLanguageFortran());
		developerInfoImpl.setLanguageCpp(developerInfo.isLanguageCpp());
		developerInfoImpl.setLanguagePython(developerInfo.isLanguagePython());
		developerInfoImpl.setLanguageJava(developerInfo.isLanguageJava());
		developerInfoImpl.setLanguageOther(developerInfo.isLanguageOther());
		developerInfoImpl.setLanguageOtherDescription(developerInfo.getLanguageOtherDescription());
		developerInfoImpl.setRem(developerInfo.getRem());
		developerInfoImpl.setAgreementYn(developerInfo.isAgreementYn());
		developerInfoImpl.setWrittenOathLogical(developerInfo.getWrittenOathLogical());
		developerInfoImpl.setWrittenOathPhysical(developerInfo.getWrittenOathPhysical());
		developerInfoImpl.setDetailIp(developerInfo.getDetailIp());
		developerInfoImpl.setDetailOs(developerInfo.getDetailOs());
		developerInfoImpl.setDetailCpu(developerInfo.getDetailCpu());
		developerInfoImpl.setDetailStorate(developerInfo.getDetailStorate());
		developerInfoImpl.setDetailLibrary(developerInfo.getDetailLibrary());
		developerInfoImpl.setInsertId(developerInfo.getInsertId());
		developerInfoImpl.setInsertDate(developerInfo.getInsertDate());
		developerInfoImpl.setUpdateId(developerInfo.getUpdateId());
		developerInfoImpl.setUpdateDate(developerInfo.getUpdateDate());
		developerInfoImpl.setEtc(developerInfo.getEtc());
		developerInfoImpl.setDeveloperId(developerInfo.getDeveloperId());
		developerInfoImpl.setDeveloperPassword(developerInfo.getDeveloperPassword());

		return developerInfoImpl;
	}

	/**
	 * Returns the developer info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the developer info
	 * @return the developer info
	 * @throws org.kisti.edison.science.NoSuchDeveloperInfoException if a developer info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDeveloperInfoException, SystemException {
		DeveloperInfo developerInfo = fetchByPrimaryKey(primaryKey);

		if (developerInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDeveloperInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return developerInfo;
	}

	/**
	 * Returns the developer info with the primary key or throws a {@link org.kisti.edison.science.NoSuchDeveloperInfoException} if it could not be found.
	 *
	 * @param developerInfoPK the primary key of the developer info
	 * @return the developer info
	 * @throws org.kisti.edison.science.NoSuchDeveloperInfoException if a developer info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperInfo findByPrimaryKey(DeveloperInfoPK developerInfoPK)
		throws NoSuchDeveloperInfoException, SystemException {
		return findByPrimaryKey((Serializable)developerInfoPK);
	}

	/**
	 * Returns the developer info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the developer info
	 * @return the developer info, or <code>null</code> if a developer info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DeveloperInfo developerInfo = (DeveloperInfo)EntityCacheUtil.getResult(DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
				DeveloperInfoImpl.class, primaryKey);

		if (developerInfo == _nullDeveloperInfo) {
			return null;
		}

		if (developerInfo == null) {
			Session session = null;

			try {
				session = openSession();

				developerInfo = (DeveloperInfo)session.get(DeveloperInfoImpl.class,
						primaryKey);

				if (developerInfo != null) {
					cacheResult(developerInfo);
				}
				else {
					EntityCacheUtil.putResult(DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
						DeveloperInfoImpl.class, primaryKey, _nullDeveloperInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DeveloperInfoModelImpl.ENTITY_CACHE_ENABLED,
					DeveloperInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return developerInfo;
	}

	/**
	 * Returns the developer info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param developerInfoPK the primary key of the developer info
	 * @return the developer info, or <code>null</code> if a developer info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperInfo fetchByPrimaryKey(DeveloperInfoPK developerInfoPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)developerInfoPK);
	}

	/**
	 * Returns all the developer infos.
	 *
	 * @return the developer infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the developer infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of developer infos
	 * @param end the upper bound of the range of developer infos (not inclusive)
	 * @return the range of developer infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the developer infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of developer infos
	 * @param end the upper bound of the range of developer infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of developer infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperInfo> findAll(int start, int end,
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

		List<DeveloperInfo> list = (List<DeveloperInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEVELOPERINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEVELOPERINFO;

				if (pagination) {
					sql = sql.concat(DeveloperInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DeveloperInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeveloperInfo>(list);
				}
				else {
					list = (List<DeveloperInfo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the developer infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DeveloperInfo developerInfo : findAll()) {
			remove(developerInfo);
		}
	}

	/**
	 * Returns the number of developer infos.
	 *
	 * @return the number of developer infos
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

				Query q = session.createQuery(_SQL_COUNT_DEVELOPERINFO);

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
	 * Initializes the developer info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.science.model.DeveloperInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DeveloperInfo>> listenersList = new ArrayList<ModelListener<DeveloperInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DeveloperInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DeveloperInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DEVELOPERINFO = "SELECT developerInfo FROM DeveloperInfo developerInfo";
	private static final String _SQL_SELECT_DEVELOPERINFO_WHERE = "SELECT developerInfo FROM DeveloperInfo developerInfo WHERE ";
	private static final String _SQL_COUNT_DEVELOPERINFO = "SELECT COUNT(developerInfo) FROM DeveloperInfo developerInfo";
	private static final String _SQL_COUNT_DEVELOPERINFO_WHERE = "SELECT COUNT(developerInfo) FROM DeveloperInfo developerInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "developerInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DeveloperInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DeveloperInfo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DeveloperInfoPersistenceImpl.class);
	private static DeveloperInfo _nullDeveloperInfo = new DeveloperInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DeveloperInfo> toCacheModel() {
				return _nullDeveloperInfoCacheModel;
			}
		};

	private static CacheModel<DeveloperInfo> _nullDeveloperInfoCacheModel = new CacheModel<DeveloperInfo>() {
			@Override
			public DeveloperInfo toEntityModel() {
				return _nullDeveloperInfo;
			}
		};
}