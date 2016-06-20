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

import org.kisti.edison.science.NoSuchDeveloperRequestException;
import org.kisti.edison.science.model.DeveloperRequest;
import org.kisti.edison.science.model.impl.DeveloperRequestImpl;
import org.kisti.edison.science.model.impl.DeveloperRequestModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the developer request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see DeveloperRequestPersistence
 * @see DeveloperRequestUtil
 * @generated
 */
public class DeveloperRequestPersistenceImpl extends BasePersistenceImpl<DeveloperRequest>
	implements DeveloperRequestPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DeveloperRequestUtil} to access the developer request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DeveloperRequestImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestModelImpl.FINDER_CACHE_ENABLED,
			DeveloperRequestImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestModelImpl.FINDER_CACHE_ENABLED,
			DeveloperRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestModelImpl.FINDER_CACHE_ENABLED,
			DeveloperRequestImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestModelImpl.FINDER_CACHE_ENABLED,
			DeveloperRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName(), Long.class.getName() },
			DeveloperRequestModelImpl.USERID_COLUMN_BITMASK |
			DeveloperRequestModelImpl.GROUPID_COLUMN_BITMASK |
			DeveloperRequestModelImpl.INSERTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the developer requests where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperRequest> findByUserId(long userId, long groupId)
		throws SystemException {
		return findByUserId(userId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the developer requests where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of developer requests
	 * @param end the upper bound of the range of developer requests (not inclusive)
	 * @return the range of matching developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperRequest> findByUserId(long userId, long groupId,
		int start, int end) throws SystemException {
		return findByUserId(userId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the developer requests where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of developer requests
	 * @param end the upper bound of the range of developer requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperRequest> findByUserId(long userId, long groupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] {
					userId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<DeveloperRequest> list = (List<DeveloperRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DeveloperRequest developerRequest : list) {
				if ((userId != developerRequest.getUserId()) ||
						(groupId != developerRequest.getGroupId())) {
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

			query.append(_SQL_SELECT_DEVELOPERREQUEST_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DeveloperRequestModelImpl.ORDER_BY_JPQL);
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
					list = (List<DeveloperRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeveloperRequest>(list);
				}
				else {
					list = (List<DeveloperRequest>)QueryUtil.list(q,
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
	 * Returns the first developer request in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching developer request
	 * @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a matching developer request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest findByUserId_First(long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDeveloperRequestException, SystemException {
		DeveloperRequest developerRequest = fetchByUserId_First(userId,
				groupId, orderByComparator);

		if (developerRequest != null) {
			return developerRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeveloperRequestException(msg.toString());
	}

	/**
	 * Returns the first developer request in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching developer request, or <code>null</code> if a matching developer request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest fetchByUserId_First(long userId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DeveloperRequest> list = findByUserId(userId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last developer request in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching developer request
	 * @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a matching developer request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest findByUserId_Last(long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDeveloperRequestException, SystemException {
		DeveloperRequest developerRequest = fetchByUserId_Last(userId, groupId,
				orderByComparator);

		if (developerRequest != null) {
			return developerRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeveloperRequestException(msg.toString());
	}

	/**
	 * Returns the last developer request in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching developer request, or <code>null</code> if a matching developer request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest fetchByUserId_Last(long userId, long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId, groupId);

		if (count == 0) {
			return null;
		}

		List<DeveloperRequest> list = findByUserId(userId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the developer requests before and after the current developer request in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param developerRequestPK the primary key of the current developer request
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next developer request
	 * @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest[] findByUserId_PrevAndNext(
		DeveloperRequestPK developerRequestPK, long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDeveloperRequestException, SystemException {
		DeveloperRequest developerRequest = findByPrimaryKey(developerRequestPK);

		Session session = null;

		try {
			session = openSession();

			DeveloperRequest[] array = new DeveloperRequestImpl[3];

			array[0] = getByUserId_PrevAndNext(session, developerRequest,
					userId, groupId, orderByComparator, true);

			array[1] = developerRequest;

			array[2] = getByUserId_PrevAndNext(session, developerRequest,
					userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DeveloperRequest getByUserId_PrevAndNext(Session session,
		DeveloperRequest developerRequest, long userId, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEVELOPERREQUEST_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		query.append(_FINDER_COLUMN_USERID_GROUPID_2);

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
			query.append(DeveloperRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(developerRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DeveloperRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the developer requests where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId, long groupId)
		throws SystemException {
		for (DeveloperRequest developerRequest : findByUserId(userId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(developerRequest);
		}
	}

	/**
	 * Returns the number of developer requests where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserId(long userId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DEVELOPERREQUEST_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			query.append(_FINDER_COLUMN_USERID_GROUPID_2);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "developerRequest.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERID_GROUPID_2 = "developerRequest.id.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDREQUSETSEQ =
		new FinderPath(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestModelImpl.FINDER_CACHE_ENABLED,
			DeveloperRequestImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdAndRequsetSeq",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDREQUSETSEQ =
		new FinderPath(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestModelImpl.FINDER_CACHE_ENABLED,
			DeveloperRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdAndRequsetSeq",
			new String[] { Long.class.getName(), Long.class.getName() },
			DeveloperRequestModelImpl.USERID_COLUMN_BITMASK |
			DeveloperRequestModelImpl.REQUESTSEQ_COLUMN_BITMASK |
			DeveloperRequestModelImpl.INSERTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDREQUSETSEQ = new FinderPath(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndRequsetSeq",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the developer requests where userId = &#63; and requestSeq = &#63;.
	 *
	 * @param userId the user ID
	 * @param requestSeq the request seq
	 * @return the matching developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperRequest> findByUserIdAndRequsetSeq(long userId,
		long requestSeq) throws SystemException {
		return findByUserIdAndRequsetSeq(userId, requestSeq, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the developer requests where userId = &#63; and requestSeq = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param requestSeq the request seq
	 * @param start the lower bound of the range of developer requests
	 * @param end the upper bound of the range of developer requests (not inclusive)
	 * @return the range of matching developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperRequest> findByUserIdAndRequsetSeq(long userId,
		long requestSeq, int start, int end) throws SystemException {
		return findByUserIdAndRequsetSeq(userId, requestSeq, start, end, null);
	}

	/**
	 * Returns an ordered range of all the developer requests where userId = &#63; and requestSeq = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param requestSeq the request seq
	 * @param start the lower bound of the range of developer requests
	 * @param end the upper bound of the range of developer requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperRequest> findByUserIdAndRequsetSeq(long userId,
		long requestSeq, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDREQUSETSEQ;
			finderArgs = new Object[] { userId, requestSeq };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDREQUSETSEQ;
			finderArgs = new Object[] {
					userId, requestSeq,
					
					start, end, orderByComparator
				};
		}

		List<DeveloperRequest> list = (List<DeveloperRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DeveloperRequest developerRequest : list) {
				if ((userId != developerRequest.getUserId()) ||
						(requestSeq != developerRequest.getRequestSeq())) {
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

			query.append(_SQL_SELECT_DEVELOPERREQUEST_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDREQUSETSEQ_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDREQUSETSEQ_REQUESTSEQ_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DeveloperRequestModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(requestSeq);

				if (!pagination) {
					list = (List<DeveloperRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeveloperRequest>(list);
				}
				else {
					list = (List<DeveloperRequest>)QueryUtil.list(q,
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
	 * Returns the first developer request in the ordered set where userId = &#63; and requestSeq = &#63;.
	 *
	 * @param userId the user ID
	 * @param requestSeq the request seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching developer request
	 * @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a matching developer request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest findByUserIdAndRequsetSeq_First(long userId,
		long requestSeq, OrderByComparator orderByComparator)
		throws NoSuchDeveloperRequestException, SystemException {
		DeveloperRequest developerRequest = fetchByUserIdAndRequsetSeq_First(userId,
				requestSeq, orderByComparator);

		if (developerRequest != null) {
			return developerRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", requestSeq=");
		msg.append(requestSeq);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeveloperRequestException(msg.toString());
	}

	/**
	 * Returns the first developer request in the ordered set where userId = &#63; and requestSeq = &#63;.
	 *
	 * @param userId the user ID
	 * @param requestSeq the request seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching developer request, or <code>null</code> if a matching developer request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest fetchByUserIdAndRequsetSeq_First(long userId,
		long requestSeq, OrderByComparator orderByComparator)
		throws SystemException {
		List<DeveloperRequest> list = findByUserIdAndRequsetSeq(userId,
				requestSeq, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last developer request in the ordered set where userId = &#63; and requestSeq = &#63;.
	 *
	 * @param userId the user ID
	 * @param requestSeq the request seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching developer request
	 * @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a matching developer request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest findByUserIdAndRequsetSeq_Last(long userId,
		long requestSeq, OrderByComparator orderByComparator)
		throws NoSuchDeveloperRequestException, SystemException {
		DeveloperRequest developerRequest = fetchByUserIdAndRequsetSeq_Last(userId,
				requestSeq, orderByComparator);

		if (developerRequest != null) {
			return developerRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", requestSeq=");
		msg.append(requestSeq);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeveloperRequestException(msg.toString());
	}

	/**
	 * Returns the last developer request in the ordered set where userId = &#63; and requestSeq = &#63;.
	 *
	 * @param userId the user ID
	 * @param requestSeq the request seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching developer request, or <code>null</code> if a matching developer request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest fetchByUserIdAndRequsetSeq_Last(long userId,
		long requestSeq, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdAndRequsetSeq(userId, requestSeq);

		if (count == 0) {
			return null;
		}

		List<DeveloperRequest> list = findByUserIdAndRequsetSeq(userId,
				requestSeq, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the developer requests before and after the current developer request in the ordered set where userId = &#63; and requestSeq = &#63;.
	 *
	 * @param developerRequestPK the primary key of the current developer request
	 * @param userId the user ID
	 * @param requestSeq the request seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next developer request
	 * @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest[] findByUserIdAndRequsetSeq_PrevAndNext(
		DeveloperRequestPK developerRequestPK, long userId, long requestSeq,
		OrderByComparator orderByComparator)
		throws NoSuchDeveloperRequestException, SystemException {
		DeveloperRequest developerRequest = findByPrimaryKey(developerRequestPK);

		Session session = null;

		try {
			session = openSession();

			DeveloperRequest[] array = new DeveloperRequestImpl[3];

			array[0] = getByUserIdAndRequsetSeq_PrevAndNext(session,
					developerRequest, userId, requestSeq, orderByComparator,
					true);

			array[1] = developerRequest;

			array[2] = getByUserIdAndRequsetSeq_PrevAndNext(session,
					developerRequest, userId, requestSeq, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DeveloperRequest getByUserIdAndRequsetSeq_PrevAndNext(
		Session session, DeveloperRequest developerRequest, long userId,
		long requestSeq, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEVELOPERREQUEST_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDREQUSETSEQ_USERID_2);

		query.append(_FINDER_COLUMN_USERIDANDREQUSETSEQ_REQUESTSEQ_2);

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
			query.append(DeveloperRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(requestSeq);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(developerRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DeveloperRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the developer requests where userId = &#63; and requestSeq = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param requestSeq the request seq
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdAndRequsetSeq(long userId, long requestSeq)
		throws SystemException {
		for (DeveloperRequest developerRequest : findByUserIdAndRequsetSeq(
				userId, requestSeq, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(developerRequest);
		}
	}

	/**
	 * Returns the number of developer requests where userId = &#63; and requestSeq = &#63;.
	 *
	 * @param userId the user ID
	 * @param requestSeq the request seq
	 * @return the number of matching developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndRequsetSeq(long userId, long requestSeq)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDREQUSETSEQ;

		Object[] finderArgs = new Object[] { userId, requestSeq };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DEVELOPERREQUEST_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDREQUSETSEQ_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDREQUSETSEQ_REQUESTSEQ_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(requestSeq);

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

	private static final String _FINDER_COLUMN_USERIDANDREQUSETSEQ_USERID_2 = "developerRequest.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDREQUSETSEQ_REQUESTSEQ_2 = "developerRequest.id.requestSeq = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDGROUPID =
		new FinderPath(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestModelImpl.FINDER_CACHE_ENABLED,
			DeveloperRequestImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDGROUPID =
		new FinderPath(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestModelImpl.FINDER_CACHE_ENABLED,
			DeveloperRequestImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			DeveloperRequestModelImpl.USERID_COLUMN_BITMASK |
			DeveloperRequestModelImpl.GROUPID_COLUMN_BITMASK |
			DeveloperRequestModelImpl.INSERTDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDANDGROUPID = new FinderPath(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdAndGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the developer requests where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperRequest> findByUserIdAndGroupId(long userId,
		long groupId) throws SystemException {
		return findByUserIdAndGroupId(userId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the developer requests where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of developer requests
	 * @param end the upper bound of the range of developer requests (not inclusive)
	 * @return the range of matching developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperRequest> findByUserIdAndGroupId(long userId,
		long groupId, int start, int end) throws SystemException {
		return findByUserIdAndGroupId(userId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the developer requests where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of developer requests
	 * @param end the upper bound of the range of developer requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperRequest> findByUserIdAndGroupId(long userId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDGROUPID;
			finderArgs = new Object[] { userId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDANDGROUPID;
			finderArgs = new Object[] {
					userId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<DeveloperRequest> list = (List<DeveloperRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DeveloperRequest developerRequest : list) {
				if ((userId != developerRequest.getUserId()) ||
						(groupId != developerRequest.getGroupId())) {
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

			query.append(_SQL_SELECT_DEVELOPERREQUEST_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DeveloperRequestModelImpl.ORDER_BY_JPQL);
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
					list = (List<DeveloperRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeveloperRequest>(list);
				}
				else {
					list = (List<DeveloperRequest>)QueryUtil.list(q,
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
	 * Returns the first developer request in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching developer request
	 * @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a matching developer request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest findByUserIdAndGroupId_First(long userId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchDeveloperRequestException, SystemException {
		DeveloperRequest developerRequest = fetchByUserIdAndGroupId_First(userId,
				groupId, orderByComparator);

		if (developerRequest != null) {
			return developerRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeveloperRequestException(msg.toString());
	}

	/**
	 * Returns the first developer request in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching developer request, or <code>null</code> if a matching developer request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest fetchByUserIdAndGroupId_First(long userId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<DeveloperRequest> list = findByUserIdAndGroupId(userId, groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last developer request in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching developer request
	 * @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a matching developer request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest findByUserIdAndGroupId_Last(long userId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchDeveloperRequestException, SystemException {
		DeveloperRequest developerRequest = fetchByUserIdAndGroupId_Last(userId,
				groupId, orderByComparator);

		if (developerRequest != null) {
			return developerRequest;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDeveloperRequestException(msg.toString());
	}

	/**
	 * Returns the last developer request in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching developer request, or <code>null</code> if a matching developer request could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest fetchByUserIdAndGroupId_Last(long userId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdAndGroupId(userId, groupId);

		if (count == 0) {
			return null;
		}

		List<DeveloperRequest> list = findByUserIdAndGroupId(userId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the developer requests before and after the current developer request in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param developerRequestPK the primary key of the current developer request
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next developer request
	 * @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest[] findByUserIdAndGroupId_PrevAndNext(
		DeveloperRequestPK developerRequestPK, long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchDeveloperRequestException, SystemException {
		DeveloperRequest developerRequest = findByPrimaryKey(developerRequestPK);

		Session session = null;

		try {
			session = openSession();

			DeveloperRequest[] array = new DeveloperRequestImpl[3];

			array[0] = getByUserIdAndGroupId_PrevAndNext(session,
					developerRequest, userId, groupId, orderByComparator, true);

			array[1] = developerRequest;

			array[2] = getByUserIdAndGroupId_PrevAndNext(session,
					developerRequest, userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DeveloperRequest getByUserIdAndGroupId_PrevAndNext(
		Session session, DeveloperRequest developerRequest, long userId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEVELOPERREQUEST_WHERE);

		query.append(_FINDER_COLUMN_USERIDANDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDANDGROUPID_GROUPID_2);

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
			query.append(DeveloperRequestModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(developerRequest);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DeveloperRequest> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the developer requests where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdAndGroupId(long userId, long groupId)
		throws SystemException {
		for (DeveloperRequest developerRequest : findByUserIdAndGroupId(
				userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(developerRequest);
		}
	}

	/**
	 * Returns the number of developer requests where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdAndGroupId(long userId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDANDGROUPID;

		Object[] finderArgs = new Object[] { userId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DEVELOPERREQUEST_WHERE);

			query.append(_FINDER_COLUMN_USERIDANDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDANDGROUPID_GROUPID_2);

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

	private static final String _FINDER_COLUMN_USERIDANDGROUPID_USERID_2 = "developerRequest.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDANDGROUPID_GROUPID_2 = "developerRequest.id.groupId = ?";

	public DeveloperRequestPersistenceImpl() {
		setModelClass(DeveloperRequest.class);
	}

	/**
	 * Caches the developer request in the entity cache if it is enabled.
	 *
	 * @param developerRequest the developer request
	 */
	@Override
	public void cacheResult(DeveloperRequest developerRequest) {
		EntityCacheUtil.putResult(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestImpl.class, developerRequest.getPrimaryKey(),
			developerRequest);

		developerRequest.resetOriginalValues();
	}

	/**
	 * Caches the developer requests in the entity cache if it is enabled.
	 *
	 * @param developerRequests the developer requests
	 */
	@Override
	public void cacheResult(List<DeveloperRequest> developerRequests) {
		for (DeveloperRequest developerRequest : developerRequests) {
			if (EntityCacheUtil.getResult(
						DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
						DeveloperRequestImpl.class,
						developerRequest.getPrimaryKey()) == null) {
				cacheResult(developerRequest);
			}
			else {
				developerRequest.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all developer requests.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DeveloperRequestImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DeveloperRequestImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the developer request.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DeveloperRequest developerRequest) {
		EntityCacheUtil.removeResult(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestImpl.class, developerRequest.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<DeveloperRequest> developerRequests) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DeveloperRequest developerRequest : developerRequests) {
			EntityCacheUtil.removeResult(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
				DeveloperRequestImpl.class, developerRequest.getPrimaryKey());
		}
	}

	/**
	 * Creates a new developer request with the primary key. Does not add the developer request to the database.
	 *
	 * @param developerRequestPK the primary key for the new developer request
	 * @return the new developer request
	 */
	@Override
	public DeveloperRequest create(DeveloperRequestPK developerRequestPK) {
		DeveloperRequest developerRequest = new DeveloperRequestImpl();

		developerRequest.setNew(true);
		developerRequest.setPrimaryKey(developerRequestPK);

		return developerRequest;
	}

	/**
	 * Removes the developer request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param developerRequestPK the primary key of the developer request
	 * @return the developer request that was removed
	 * @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest remove(DeveloperRequestPK developerRequestPK)
		throws NoSuchDeveloperRequestException, SystemException {
		return remove((Serializable)developerRequestPK);
	}

	/**
	 * Removes the developer request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the developer request
	 * @return the developer request that was removed
	 * @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest remove(Serializable primaryKey)
		throws NoSuchDeveloperRequestException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DeveloperRequest developerRequest = (DeveloperRequest)session.get(DeveloperRequestImpl.class,
					primaryKey);

			if (developerRequest == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDeveloperRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(developerRequest);
		}
		catch (NoSuchDeveloperRequestException nsee) {
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
	protected DeveloperRequest removeImpl(DeveloperRequest developerRequest)
		throws SystemException {
		developerRequest = toUnwrappedModel(developerRequest);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(developerRequest)) {
				developerRequest = (DeveloperRequest)session.get(DeveloperRequestImpl.class,
						developerRequest.getPrimaryKeyObj());
			}

			if (developerRequest != null) {
				session.delete(developerRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (developerRequest != null) {
			clearCache(developerRequest);
		}

		return developerRequest;
	}

	@Override
	public DeveloperRequest updateImpl(
		org.kisti.edison.science.model.DeveloperRequest developerRequest)
		throws SystemException {
		developerRequest = toUnwrappedModel(developerRequest);

		boolean isNew = developerRequest.isNew();

		DeveloperRequestModelImpl developerRequestModelImpl = (DeveloperRequestModelImpl)developerRequest;

		Session session = null;

		try {
			session = openSession();

			if (developerRequest.isNew()) {
				session.save(developerRequest);

				developerRequest.setNew(false);
			}
			else {
				session.merge(developerRequest);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DeveloperRequestModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((developerRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						developerRequestModelImpl.getOriginalUserId(),
						developerRequestModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						developerRequestModelImpl.getUserId(),
						developerRequestModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((developerRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDREQUSETSEQ.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						developerRequestModelImpl.getOriginalUserId(),
						developerRequestModelImpl.getOriginalRequestSeq()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDREQUSETSEQ,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDREQUSETSEQ,
					args);

				args = new Object[] {
						developerRequestModelImpl.getUserId(),
						developerRequestModelImpl.getRequestSeq()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDREQUSETSEQ,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDREQUSETSEQ,
					args);
			}

			if ((developerRequestModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						developerRequestModelImpl.getOriginalUserId(),
						developerRequestModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDGROUPID,
					args);

				args = new Object[] {
						developerRequestModelImpl.getUserId(),
						developerRequestModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDANDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDANDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
			DeveloperRequestImpl.class, developerRequest.getPrimaryKey(),
			developerRequest);

		return developerRequest;
	}

	protected DeveloperRequest toUnwrappedModel(
		DeveloperRequest developerRequest) {
		if (developerRequest instanceof DeveloperRequestImpl) {
			return developerRequest;
		}

		DeveloperRequestImpl developerRequestImpl = new DeveloperRequestImpl();

		developerRequestImpl.setNew(developerRequest.isNew());
		developerRequestImpl.setPrimaryKey(developerRequest.getPrimaryKey());

		developerRequestImpl.setRequestSeq(developerRequest.getRequestSeq());
		developerRequestImpl.setUserId(developerRequest.getUserId());
		developerRequestImpl.setGroupId(developerRequest.getGroupId());
		developerRequestImpl.setRequestSort(developerRequest.getRequestSort());
		developerRequestImpl.setRequestDate(developerRequest.getRequestDate());
		developerRequestImpl.setRequestNote(developerRequest.getRequestNote());
		developerRequestImpl.setRequestStatus(developerRequest.getRequestStatus());
		developerRequestImpl.setProcessDate(developerRequest.getProcessDate());
		developerRequestImpl.setProcessNote(developerRequest.getProcessNote());
		developerRequestImpl.setInsertId(developerRequest.getInsertId());
		developerRequestImpl.setInsertDate(developerRequest.getInsertDate());
		developerRequestImpl.setUpdateId(developerRequest.getUpdateId());
		developerRequestImpl.setUpdateDate(developerRequest.getUpdateDate());

		return developerRequestImpl;
	}

	/**
	 * Returns the developer request with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the developer request
	 * @return the developer request
	 * @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDeveloperRequestException, SystemException {
		DeveloperRequest developerRequest = fetchByPrimaryKey(primaryKey);

		if (developerRequest == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDeveloperRequestException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return developerRequest;
	}

	/**
	 * Returns the developer request with the primary key or throws a {@link org.kisti.edison.science.NoSuchDeveloperRequestException} if it could not be found.
	 *
	 * @param developerRequestPK the primary key of the developer request
	 * @return the developer request
	 * @throws org.kisti.edison.science.NoSuchDeveloperRequestException if a developer request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest findByPrimaryKey(
		DeveloperRequestPK developerRequestPK)
		throws NoSuchDeveloperRequestException, SystemException {
		return findByPrimaryKey((Serializable)developerRequestPK);
	}

	/**
	 * Returns the developer request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the developer request
	 * @return the developer request, or <code>null</code> if a developer request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DeveloperRequest developerRequest = (DeveloperRequest)EntityCacheUtil.getResult(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
				DeveloperRequestImpl.class, primaryKey);

		if (developerRequest == _nullDeveloperRequest) {
			return null;
		}

		if (developerRequest == null) {
			Session session = null;

			try {
				session = openSession();

				developerRequest = (DeveloperRequest)session.get(DeveloperRequestImpl.class,
						primaryKey);

				if (developerRequest != null) {
					cacheResult(developerRequest);
				}
				else {
					EntityCacheUtil.putResult(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
						DeveloperRequestImpl.class, primaryKey,
						_nullDeveloperRequest);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DeveloperRequestModelImpl.ENTITY_CACHE_ENABLED,
					DeveloperRequestImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return developerRequest;
	}

	/**
	 * Returns the developer request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param developerRequestPK the primary key of the developer request
	 * @return the developer request, or <code>null</code> if a developer request with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DeveloperRequest fetchByPrimaryKey(
		DeveloperRequestPK developerRequestPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)developerRequestPK);
	}

	/**
	 * Returns all the developer requests.
	 *
	 * @return the developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperRequest> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the developer requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of developer requests
	 * @param end the upper bound of the range of developer requests (not inclusive)
	 * @return the range of developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperRequest> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the developer requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.DeveloperRequestModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of developer requests
	 * @param end the upper bound of the range of developer requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of developer requests
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DeveloperRequest> findAll(int start, int end,
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

		List<DeveloperRequest> list = (List<DeveloperRequest>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEVELOPERREQUEST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEVELOPERREQUEST;

				if (pagination) {
					sql = sql.concat(DeveloperRequestModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DeveloperRequest>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DeveloperRequest>(list);
				}
				else {
					list = (List<DeveloperRequest>)QueryUtil.list(q,
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
	 * Removes all the developer requests from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DeveloperRequest developerRequest : findAll()) {
			remove(developerRequest);
		}
	}

	/**
	 * Returns the number of developer requests.
	 *
	 * @return the number of developer requests
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

				Query q = session.createQuery(_SQL_COUNT_DEVELOPERREQUEST);

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
	 * Initializes the developer request persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.science.model.DeveloperRequest")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DeveloperRequest>> listenersList = new ArrayList<ModelListener<DeveloperRequest>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DeveloperRequest>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DeveloperRequestImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DEVELOPERREQUEST = "SELECT developerRequest FROM DeveloperRequest developerRequest";
	private static final String _SQL_SELECT_DEVELOPERREQUEST_WHERE = "SELECT developerRequest FROM DeveloperRequest developerRequest WHERE ";
	private static final String _SQL_COUNT_DEVELOPERREQUEST = "SELECT COUNT(developerRequest) FROM DeveloperRequest developerRequest";
	private static final String _SQL_COUNT_DEVELOPERREQUEST_WHERE = "SELECT COUNT(developerRequest) FROM DeveloperRequest developerRequest WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "developerRequest.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DeveloperRequest exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DeveloperRequest exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DeveloperRequestPersistenceImpl.class);
	private static DeveloperRequest _nullDeveloperRequest = new DeveloperRequestImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DeveloperRequest> toCacheModel() {
				return _nullDeveloperRequestCacheModel;
			}
		};

	private static CacheModel<DeveloperRequest> _nullDeveloperRequestCacheModel = new CacheModel<DeveloperRequest>() {
			@Override
			public DeveloperRequest toEntityModel() {
				return _nullDeveloperRequest;
			}
		};
}