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

import org.kisti.edison.science.NoSuchDeveloperIpException;
import org.kisti.edison.science.model.DeveloperIp;
import org.kisti.edison.science.model.impl.DeveloperIpImpl;
import org.kisti.edison.science.model.impl.DeveloperIpModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the developer ip service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see DeveloperIpPersistence
 * @see DeveloperIpUtil
 * @generated
 */
public class DeveloperIpPersistenceImpl extends BasePersistenceImpl<DeveloperIp>
	implements DeveloperIpPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DeveloperIpUtil} to access the developer ip persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DeveloperIpImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperIpModelImpl.FINDER_CACHE_ENABLED, DeveloperIpImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperIpModelImpl.FINDER_CACHE_ENABLED, DeveloperIpImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperIpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperIpModelImpl.FINDER_CACHE_ENABLED, DeveloperIpImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperIpModelImpl.FINDER_CACHE_ENABLED, DeveloperIpImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			DeveloperIpModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperIpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the developer ips where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching developer ips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperIp> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the developer ips where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of developer ips
	 * @param end the upper bound of the range of developer ips (not inclusive)
	 * @return the range of matching developer ips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperIp> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the developer ips where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of developer ips
	 * @param end the upper bound of the range of developer ips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching developer ips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperIp> findByUserId(long userId, int start, int end,
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

		List<DeveloperIp> list = (List<DeveloperIp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DeveloperIp developerIp : list) {
				if ((userId != developerIp.getUserId())) {
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

			query.append(_SQL_SELECT_DEVELOPERIP_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DeveloperIpModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<DeveloperIp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeveloperIp>(list);
				}
				else {
					list = (List<DeveloperIp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first developer ip in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching developer ip
	 * @throws org.kisti.edison.science.NoSuchDeveloperIpException if a matching developer ip could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchDeveloperIpException, SystemException {
		DeveloperIp developerIp = fetchByUserId_First(userId, orderByComparator);

		if (developerIp != null) {
			return developerIp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeveloperIpException(msg.toString());
	}

	/**
	 * Returns the first developer ip in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching developer ip, or <code>null</code> if a matching developer ip could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DeveloperIp> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last developer ip in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching developer ip
	 * @throws org.kisti.edison.science.NoSuchDeveloperIpException if a matching developer ip could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchDeveloperIpException, SystemException {
		DeveloperIp developerIp = fetchByUserId_Last(userId, orderByComparator);

		if (developerIp != null) {
			return developerIp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeveloperIpException(msg.toString());
	}

	/**
	 * Returns the last developer ip in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching developer ip, or <code>null</code> if a matching developer ip could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<DeveloperIp> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the developer ips before and after the current developer ip in the ordered set where userId = &#63;.
	 *
	 * @param developerIpPK the primary key of the current developer ip
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next developer ip
	 * @throws org.kisti.edison.science.NoSuchDeveloperIpException if a developer ip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp[] findByUserId_PrevAndNext(DeveloperIpPK developerIpPK,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchDeveloperIpException, SystemException {
		DeveloperIp developerIp = findByPrimaryKey(developerIpPK);

		Session session = null;

		try {
			session = openSession();

			DeveloperIp[] array = new DeveloperIpImpl[3];

			array[0] = getByUserId_PrevAndNext(session, developerIp, userId,
					orderByComparator, true);

			array[1] = developerIp;

			array[2] = getByUserId_PrevAndNext(session, developerIp, userId,
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

	protected DeveloperIp getByUserId_PrevAndNext(Session session,
		DeveloperIp developerIp, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEVELOPERIP_WHERE);

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
			query.append(DeveloperIpModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(developerIp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DeveloperIp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the developer ips where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (DeveloperIp developerIp : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(developerIp);
		}
	}

	/**
	 * Returns the number of developer ips where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching developer ips
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

			query.append(_SQL_COUNT_DEVELOPERIP_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "developerIp.id.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperIpModelImpl.FINDER_CACHE_ENABLED, DeveloperIpImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperIpModelImpl.FINDER_CACHE_ENABLED, DeveloperIpImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			DeveloperIpModelImpl.USERID_COLUMN_BITMASK |
			DeveloperIpModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperIpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the developer ips where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching developer ips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperIp> findByGroupId(long userId, long groupId)
		throws SystemException {
		return findByGroupId(userId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the developer ips where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of developer ips
	 * @param end the upper bound of the range of developer ips (not inclusive)
	 * @return the range of matching developer ips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperIp> findByGroupId(long userId, long groupId,
		int start, int end) throws SystemException {
		return findByGroupId(userId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the developer ips where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of developer ips
	 * @param end the upper bound of the range of developer ips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching developer ips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperIp> findByGroupId(long userId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { userId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] {
					userId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<DeveloperIp> list = (List<DeveloperIp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DeveloperIp developerIp : list) {
				if ((userId != developerIp.getUserId()) ||
						(groupId != developerIp.getGroupId())) {
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

			query.append(_SQL_SELECT_DEVELOPERIP_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_USERID_2);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DeveloperIpModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<DeveloperIp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeveloperIp>(list);
				}
				else {
					list = (List<DeveloperIp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first developer ip in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching developer ip
	 * @throws org.kisti.edison.science.NoSuchDeveloperIpException if a matching developer ip could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp findByGroupId_First(long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDeveloperIpException, SystemException {
		DeveloperIp developerIp = fetchByGroupId_First(userId, groupId,
				orderByComparator);

		if (developerIp != null) {
			return developerIp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeveloperIpException(msg.toString());
	}

	/**
	 * Returns the first developer ip in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching developer ip, or <code>null</code> if a matching developer ip could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp fetchByGroupId_First(long userId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DeveloperIp> list = findByGroupId(userId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last developer ip in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching developer ip
	 * @throws org.kisti.edison.science.NoSuchDeveloperIpException if a matching developer ip could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp findByGroupId_Last(long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDeveloperIpException, SystemException {
		DeveloperIp developerIp = fetchByGroupId_Last(userId, groupId,
				orderByComparator);

		if (developerIp != null) {
			return developerIp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeveloperIpException(msg.toString());
	}

	/**
	 * Returns the last developer ip in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching developer ip, or <code>null</code> if a matching developer ip could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp fetchByGroupId_Last(long userId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(userId, groupId);

		if (count == 0) {
			return null;
		}

		List<DeveloperIp> list = findByGroupId(userId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the developer ips before and after the current developer ip in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param developerIpPK the primary key of the current developer ip
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next developer ip
	 * @throws org.kisti.edison.science.NoSuchDeveloperIpException if a developer ip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp[] findByGroupId_PrevAndNext(
		DeveloperIpPK developerIpPK, long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDeveloperIpException, SystemException {
		DeveloperIp developerIp = findByPrimaryKey(developerIpPK);

		Session session = null;

		try {
			session = openSession();

			DeveloperIp[] array = new DeveloperIpImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, developerIp, userId,
					groupId, orderByComparator, true);

			array[1] = developerIp;

			array[2] = getByGroupId_PrevAndNext(session, developerIp, userId,
					groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DeveloperIp getByGroupId_PrevAndNext(Session session,
		DeveloperIp developerIp, long userId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEVELOPERIP_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_USERID_2);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(DeveloperIpModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(developerIp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DeveloperIp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the developer ips where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long userId, long groupId)
		throws SystemException {
		for (DeveloperIp developerIp : findByGroupId(userId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(developerIp);
		}
	}

	/**
	 * Returns the number of developer ips where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching developer ips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long userId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { userId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DEVELOPERIP_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_USERID_2);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_USERID_2 = "developerIp.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "developerIp.id.groupId = ?";

	public DeveloperIpPersistenceImpl() {
		setModelClass(DeveloperIp.class);
	}

	/**
	 * Caches the developer ip in the entity cache if it is enabled.
	 *
	 * @param developerIp the developer ip
	 */
	@Override
	public void cacheResult(DeveloperIp developerIp) {
		EntityCacheUtil.putResult(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperIpImpl.class, developerIp.getPrimaryKey(), developerIp);

		developerIp.resetOriginalValues();
	}

	/**
	 * Caches the developer ips in the entity cache if it is enabled.
	 *
	 * @param developerIps the developer ips
	 */
	@Override
	public void cacheResult(List<DeveloperIp> developerIps) {
		for (DeveloperIp developerIp : developerIps) {
			if (EntityCacheUtil.getResult(
						DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
						DeveloperIpImpl.class, developerIp.getPrimaryKey()) == null) {
				cacheResult(developerIp);
			}
			else {
				developerIp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all developer ips.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DeveloperIpImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DeveloperIpImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the developer ip.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DeveloperIp developerIp) {
		EntityCacheUtil.removeResult(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperIpImpl.class, developerIp.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DeveloperIp> developerIps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DeveloperIp developerIp : developerIps) {
			EntityCacheUtil.removeResult(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
				DeveloperIpImpl.class, developerIp.getPrimaryKey());
		}
	}

	/**
	 * Creates a new developer ip with the primary key. Does not add the developer ip to the database.
	 *
	 * @param developerIpPK the primary key for the new developer ip
	 * @return the new developer ip
	 */
	@Override
	public DeveloperIp create(DeveloperIpPK developerIpPK) {
		DeveloperIp developerIp = new DeveloperIpImpl();

		developerIp.setNew(true);
		developerIp.setPrimaryKey(developerIpPK);

		return developerIp;
	}

	/**
	 * Removes the developer ip with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param developerIpPK the primary key of the developer ip
	 * @return the developer ip that was removed
	 * @throws org.kisti.edison.science.NoSuchDeveloperIpException if a developer ip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp remove(DeveloperIpPK developerIpPK)
		throws NoSuchDeveloperIpException, SystemException {
		return remove((Serializable)developerIpPK);
	}

	/**
	 * Removes the developer ip with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the developer ip
	 * @return the developer ip that was removed
	 * @throws org.kisti.edison.science.NoSuchDeveloperIpException if a developer ip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp remove(Serializable primaryKey)
		throws NoSuchDeveloperIpException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DeveloperIp developerIp = (DeveloperIp)session.get(DeveloperIpImpl.class,
					primaryKey);

			if (developerIp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDeveloperIpException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(developerIp);
		}
		catch (NoSuchDeveloperIpException nsee) {
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
	protected DeveloperIp removeImpl(DeveloperIp developerIp)
		throws SystemException {
		developerIp = toUnwrappedModel(developerIp);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(developerIp)) {
				developerIp = (DeveloperIp)session.get(DeveloperIpImpl.class,
						developerIp.getPrimaryKeyObj());
			}

			if (developerIp != null) {
				session.delete(developerIp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (developerIp != null) {
			clearCache(developerIp);
		}

		return developerIp;
	}

	@Override
	public DeveloperIp updateImpl(
		org.kisti.edison.science.model.DeveloperIp developerIp)
		throws SystemException {
		developerIp = toUnwrappedModel(developerIp);

		boolean isNew = developerIp.isNew();

		DeveloperIpModelImpl developerIpModelImpl = (DeveloperIpModelImpl)developerIp;

		Session session = null;

		try {
			session = openSession();

			if (developerIp.isNew()) {
				session.save(developerIp);

				developerIp.setNew(false);
			}
			else {
				session.merge(developerIp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DeveloperIpModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((developerIpModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						developerIpModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { developerIpModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((developerIpModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						developerIpModelImpl.getOriginalUserId(),
						developerIpModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						developerIpModelImpl.getUserId(),
						developerIpModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperIpImpl.class, developerIp.getPrimaryKey(), developerIp);

		return developerIp;
	}

	protected DeveloperIp toUnwrappedModel(DeveloperIp developerIp) {
		if (developerIp instanceof DeveloperIpImpl) {
			return developerIp;
		}

		DeveloperIpImpl developerIpImpl = new DeveloperIpImpl();

		developerIpImpl.setNew(developerIp.isNew());
		developerIpImpl.setPrimaryKey(developerIp.getPrimaryKey());

		developerIpImpl.setIpSeq(developerIp.getIpSeq());
		developerIpImpl.setUserId(developerIp.getUserId());
		developerIpImpl.setGroupId(developerIp.getGroupId());
		developerIpImpl.setIp1(developerIp.getIp1());
		developerIpImpl.setIp2(developerIp.getIp2());
		developerIpImpl.setIp3(developerIp.getIp3());
		developerIpImpl.setIp4(developerIp.getIp4());
		developerIpImpl.setInsertId(developerIp.getInsertId());
		developerIpImpl.setInsertDate(developerIp.getInsertDate());
		developerIpImpl.setUpdateId(developerIp.getUpdateId());
		developerIpImpl.setUpdateDate(developerIp.getUpdateDate());

		return developerIpImpl;
	}

	/**
	 * Returns the developer ip with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the developer ip
	 * @return the developer ip
	 * @throws org.kisti.edison.science.NoSuchDeveloperIpException if a developer ip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDeveloperIpException, SystemException {
		DeveloperIp developerIp = fetchByPrimaryKey(primaryKey);

		if (developerIp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDeveloperIpException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return developerIp;
	}

	/**
	 * Returns the developer ip with the primary key or throws a {@link org.kisti.edison.science.NoSuchDeveloperIpException} if it could not be found.
	 *
	 * @param developerIpPK the primary key of the developer ip
	 * @return the developer ip
	 * @throws org.kisti.edison.science.NoSuchDeveloperIpException if a developer ip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp findByPrimaryKey(DeveloperIpPK developerIpPK)
		throws NoSuchDeveloperIpException, SystemException {
		return findByPrimaryKey((Serializable)developerIpPK);
	}

	/**
	 * Returns the developer ip with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the developer ip
	 * @return the developer ip, or <code>null</code> if a developer ip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DeveloperIp developerIp = (DeveloperIp)EntityCacheUtil.getResult(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
				DeveloperIpImpl.class, primaryKey);

		if (developerIp == _nullDeveloperIp) {
			return null;
		}

		if (developerIp == null) {
			Session session = null;

			try {
				session = openSession();

				developerIp = (DeveloperIp)session.get(DeveloperIpImpl.class,
						primaryKey);

				if (developerIp != null) {
					cacheResult(developerIp);
				}
				else {
					EntityCacheUtil.putResult(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
						DeveloperIpImpl.class, primaryKey, _nullDeveloperIp);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DeveloperIpModelImpl.ENTITY_CACHE_ENABLED,
					DeveloperIpImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return developerIp;
	}

	/**
	 * Returns the developer ip with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param developerIpPK the primary key of the developer ip
	 * @return the developer ip, or <code>null</code> if a developer ip with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperIp fetchByPrimaryKey(DeveloperIpPK developerIpPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)developerIpPK);
	}

	/**
	 * Returns all the developer ips.
	 *
	 * @return the developer ips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperIp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the developer ips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of developer ips
	 * @param end the upper bound of the range of developer ips (not inclusive)
	 * @return the range of developer ips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperIp> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the developer ips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperIpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of developer ips
	 * @param end the upper bound of the range of developer ips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of developer ips
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperIp> findAll(int start, int end,
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

		List<DeveloperIp> list = (List<DeveloperIp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEVELOPERIP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEVELOPERIP;

				if (pagination) {
					sql = sql.concat(DeveloperIpModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DeveloperIp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeveloperIp>(list);
				}
				else {
					list = (List<DeveloperIp>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the developer ips from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DeveloperIp developerIp : findAll()) {
			remove(developerIp);
		}
	}

	/**
	 * Returns the number of developer ips.
	 *
	 * @return the number of developer ips
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

				Query q = session.createQuery(_SQL_COUNT_DEVELOPERIP);

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
	 * Initializes the developer ip persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.science.model.DeveloperIp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DeveloperIp>> listenersList = new ArrayList<ModelListener<DeveloperIp>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DeveloperIp>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DeveloperIpImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DEVELOPERIP = "SELECT developerIp FROM DeveloperIp developerIp";
	private static final String _SQL_SELECT_DEVELOPERIP_WHERE = "SELECT developerIp FROM DeveloperIp developerIp WHERE ";
	private static final String _SQL_COUNT_DEVELOPERIP = "SELECT COUNT(developerIp) FROM DeveloperIp developerIp";
	private static final String _SQL_COUNT_DEVELOPERIP_WHERE = "SELECT COUNT(developerIp) FROM DeveloperIp developerIp WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "developerIp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DeveloperIp exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DeveloperIp exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DeveloperIpPersistenceImpl.class);
	private static DeveloperIp _nullDeveloperIp = new DeveloperIpImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DeveloperIp> toCacheModel() {
				return _nullDeveloperIpCacheModel;
			}
		};

	private static CacheModel<DeveloperIp> _nullDeveloperIpCacheModel = new CacheModel<DeveloperIp>() {
			@Override
			public DeveloperIp toEntityModel() {
				return _nullDeveloperIp;
			}
		};
}