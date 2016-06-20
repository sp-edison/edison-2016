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

package org.kisti.edison.customauthmanager.service.persistence;

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

import org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException;
import org.kisti.edison.customauthmanager.model.UserGroupRoleCustom;
import org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomImpl;
import org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the user group role custom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see UserGroupRoleCustomPersistence
 * @see UserGroupRoleCustomUtil
 * @generated
 */
public class UserGroupRoleCustomPersistenceImpl extends BasePersistenceImpl<UserGroupRoleCustom>
	implements UserGroupRoleCustomPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserGroupRoleCustomUtil} to access the user group role custom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserGroupRoleCustomImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED,
			UserGroupRoleCustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED,
			UserGroupRoleCustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDROLEID =
		new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED,
			UserGroupRoleCustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdRoleId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDROLEID =
		new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED,
			UserGroupRoleCustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupIdRoleId",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserGroupRoleCustomModelImpl.GROUPID_COLUMN_BITMASK |
			UserGroupRoleCustomModelImpl.ROLEID_COLUMN_BITMASK |
			UserGroupRoleCustomModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDROLEID = new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupIdRoleId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the user group role customs where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @return the matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findByGroupIdRoleId(long groupId,
		long roleId) throws SystemException {
		return findByGroupIdRoleId(groupId, roleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user group role customs where groupId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of user group role customs
	 * @param end the upper bound of the range of user group role customs (not inclusive)
	 * @return the range of matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findByGroupIdRoleId(long groupId,
		long roleId, int start, int end) throws SystemException {
		return findByGroupIdRoleId(groupId, roleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user group role customs where groupId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of user group role customs
	 * @param end the upper bound of the range of user group role customs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findByGroupIdRoleId(long groupId,
		long roleId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDROLEID;
			finderArgs = new Object[] { groupId, roleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDROLEID;
			finderArgs = new Object[] {
					groupId, roleId,
					
					start, end, orderByComparator
				};
		}

		List<UserGroupRoleCustom> list = (List<UserGroupRoleCustom>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserGroupRoleCustom userGroupRoleCustom : list) {
				if ((groupId != userGroupRoleCustom.getGroupId()) ||
						(roleId != userGroupRoleCustom.getRoleId())) {
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

			query.append(_SQL_SELECT_USERGROUPROLECUSTOM_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDROLEID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDROLEID_ROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserGroupRoleCustomModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roleId);

				if (!pagination) {
					list = (List<UserGroupRoleCustom>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserGroupRoleCustom>(list);
				}
				else {
					list = (List<UserGroupRoleCustom>)QueryUtil.list(q,
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
	 * Returns the first user group role custom in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom findByGroupIdRoleId_First(long groupId,
		long roleId, OrderByComparator orderByComparator)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		UserGroupRoleCustom userGroupRoleCustom = fetchByGroupIdRoleId_First(groupId,
				roleId, orderByComparator);

		if (userGroupRoleCustom != null) {
			return userGroupRoleCustom;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserGroupRoleCustomException(msg.toString());
	}

	/**
	 * Returns the first user group role custom in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom fetchByGroupIdRoleId_First(long groupId,
		long roleId, OrderByComparator orderByComparator)
		throws SystemException {
		List<UserGroupRoleCustom> list = findByGroupIdRoleId(groupId, roleId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user group role custom in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom findByGroupIdRoleId_Last(long groupId,
		long roleId, OrderByComparator orderByComparator)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		UserGroupRoleCustom userGroupRoleCustom = fetchByGroupIdRoleId_Last(groupId,
				roleId, orderByComparator);

		if (userGroupRoleCustom != null) {
			return userGroupRoleCustom;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserGroupRoleCustomException(msg.toString());
	}

	/**
	 * Returns the last user group role custom in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom fetchByGroupIdRoleId_Last(long groupId,
		long roleId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupIdRoleId(groupId, roleId);

		if (count == 0) {
			return null;
		}

		List<UserGroupRoleCustom> list = findByGroupIdRoleId(groupId, roleId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user group role customs before and after the current user group role custom in the ordered set where groupId = &#63; and roleId = &#63;.
	 *
	 * @param userGroupRoleCustomPK the primary key of the current user group role custom
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom[] findByGroupIdRoleId_PrevAndNext(
		UserGroupRoleCustomPK userGroupRoleCustomPK, long groupId, long roleId,
		OrderByComparator orderByComparator)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		UserGroupRoleCustom userGroupRoleCustom = findByPrimaryKey(userGroupRoleCustomPK);

		Session session = null;

		try {
			session = openSession();

			UserGroupRoleCustom[] array = new UserGroupRoleCustomImpl[3];

			array[0] = getByGroupIdRoleId_PrevAndNext(session,
					userGroupRoleCustom, groupId, roleId, orderByComparator,
					true);

			array[1] = userGroupRoleCustom;

			array[2] = getByGroupIdRoleId_PrevAndNext(session,
					userGroupRoleCustom, groupId, roleId, orderByComparator,
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

	protected UserGroupRoleCustom getByGroupIdRoleId_PrevAndNext(
		Session session, UserGroupRoleCustom userGroupRoleCustom, long groupId,
		long roleId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERGROUPROLECUSTOM_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDROLEID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDROLEID_ROLEID_2);

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
			query.append(UserGroupRoleCustomModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(roleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userGroupRoleCustom);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserGroupRoleCustom> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user group role customs where groupId = &#63; and roleId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupIdRoleId(long groupId, long roleId)
		throws SystemException {
		for (UserGroupRoleCustom userGroupRoleCustom : findByGroupIdRoleId(
				groupId, roleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userGroupRoleCustom);
		}
	}

	/**
	 * Returns the number of user group role customs where groupId = &#63; and roleId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @return the number of matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupIdRoleId(long groupId, long roleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDROLEID;

		Object[] finderArgs = new Object[] { groupId, roleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERGROUPROLECUSTOM_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDROLEID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDROLEID_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roleId);

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

	private static final String _FINDER_COLUMN_GROUPIDROLEID_GROUPID_2 = "userGroupRoleCustom.id.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDROLEID_ROLEID_2 = "userGroupRoleCustom.id.roleId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDGROUPIDROLEID =
		new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED,
			UserGroupRoleCustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserIdGroupIdRoleId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPIDROLEID =
		new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED,
			UserGroupRoleCustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserIdGroupIdRoleId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			UserGroupRoleCustomModelImpl.USERID_COLUMN_BITMASK |
			UserGroupRoleCustomModelImpl.GROUPID_COLUMN_BITMASK |
			UserGroupRoleCustomModelImpl.ROLEID_COLUMN_BITMASK |
			UserGroupRoleCustomModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDGROUPIDROLEID = new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserIdGroupIdRoleId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the user group role customs where userId = &#63; and groupId = &#63; and roleId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @return the matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findByUserIdGroupIdRoleId(long userId,
		long groupId, long roleId) throws SystemException {
		return findByUserIdGroupIdRoleId(userId, groupId, roleId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user group role customs where userId = &#63; and groupId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of user group role customs
	 * @param end the upper bound of the range of user group role customs (not inclusive)
	 * @return the range of matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findByUserIdGroupIdRoleId(long userId,
		long groupId, long roleId, int start, int end)
		throws SystemException {
		return findByUserIdGroupIdRoleId(userId, groupId, roleId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the user group role customs where userId = &#63; and groupId = &#63; and roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param start the lower bound of the range of user group role customs
	 * @param end the upper bound of the range of user group role customs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findByUserIdGroupIdRoleId(long userId,
		long groupId, long roleId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPIDROLEID;
			finderArgs = new Object[] { userId, groupId, roleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDGROUPIDROLEID;
			finderArgs = new Object[] {
					userId, groupId, roleId,
					
					start, end, orderByComparator
				};
		}

		List<UserGroupRoleCustom> list = (List<UserGroupRoleCustom>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserGroupRoleCustom userGroupRoleCustom : list) {
				if ((userId != userGroupRoleCustom.getUserId()) ||
						(groupId != userGroupRoleCustom.getGroupId()) ||
						(roleId != userGroupRoleCustom.getRoleId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_USERGROUPROLECUSTOM_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPIDROLEID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPIDROLEID_GROUPID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPIDROLEID_ROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserGroupRoleCustomModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				qPos.add(roleId);

				if (!pagination) {
					list = (List<UserGroupRoleCustom>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserGroupRoleCustom>(list);
				}
				else {
					list = (List<UserGroupRoleCustom>)QueryUtil.list(q,
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
	 * Returns the first user group role custom in the ordered set where userId = &#63; and groupId = &#63; and roleId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom findByUserIdGroupIdRoleId_First(long userId,
		long groupId, long roleId, OrderByComparator orderByComparator)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		UserGroupRoleCustom userGroupRoleCustom = fetchByUserIdGroupIdRoleId_First(userId,
				groupId, roleId, orderByComparator);

		if (userGroupRoleCustom != null) {
			return userGroupRoleCustom;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserGroupRoleCustomException(msg.toString());
	}

	/**
	 * Returns the first user group role custom in the ordered set where userId = &#63; and groupId = &#63; and roleId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom fetchByUserIdGroupIdRoleId_First(long userId,
		long groupId, long roleId, OrderByComparator orderByComparator)
		throws SystemException {
		List<UserGroupRoleCustom> list = findByUserIdGroupIdRoleId(userId,
				groupId, roleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user group role custom in the ordered set where userId = &#63; and groupId = &#63; and roleId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom findByUserIdGroupIdRoleId_Last(long userId,
		long groupId, long roleId, OrderByComparator orderByComparator)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		UserGroupRoleCustom userGroupRoleCustom = fetchByUserIdGroupIdRoleId_Last(userId,
				groupId, roleId, orderByComparator);

		if (userGroupRoleCustom != null) {
			return userGroupRoleCustom;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserGroupRoleCustomException(msg.toString());
	}

	/**
	 * Returns the last user group role custom in the ordered set where userId = &#63; and groupId = &#63; and roleId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom fetchByUserIdGroupIdRoleId_Last(long userId,
		long groupId, long roleId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdGroupIdRoleId(userId, groupId, roleId);

		if (count == 0) {
			return null;
		}

		List<UserGroupRoleCustom> list = findByUserIdGroupIdRoleId(userId,
				groupId, roleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user group role customs before and after the current user group role custom in the ordered set where userId = &#63; and groupId = &#63; and roleId = &#63;.
	 *
	 * @param userGroupRoleCustomPK the primary key of the current user group role custom
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom[] findByUserIdGroupIdRoleId_PrevAndNext(
		UserGroupRoleCustomPK userGroupRoleCustomPK, long userId, long groupId,
		long roleId, OrderByComparator orderByComparator)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		UserGroupRoleCustom userGroupRoleCustom = findByPrimaryKey(userGroupRoleCustomPK);

		Session session = null;

		try {
			session = openSession();

			UserGroupRoleCustom[] array = new UserGroupRoleCustomImpl[3];

			array[0] = getByUserIdGroupIdRoleId_PrevAndNext(session,
					userGroupRoleCustom, userId, groupId, roleId,
					orderByComparator, true);

			array[1] = userGroupRoleCustom;

			array[2] = getByUserIdGroupIdRoleId_PrevAndNext(session,
					userGroupRoleCustom, userId, groupId, roleId,
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

	protected UserGroupRoleCustom getByUserIdGroupIdRoleId_PrevAndNext(
		Session session, UserGroupRoleCustom userGroupRoleCustom, long userId,
		long groupId, long roleId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERGROUPROLECUSTOM_WHERE);

		query.append(_FINDER_COLUMN_USERIDGROUPIDROLEID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPIDROLEID_GROUPID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPIDROLEID_ROLEID_2);

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
			query.append(UserGroupRoleCustomModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		qPos.add(roleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userGroupRoleCustom);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserGroupRoleCustom> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user group role customs where userId = &#63; and groupId = &#63; and roleId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdGroupIdRoleId(long userId, long groupId,
		long roleId) throws SystemException {
		for (UserGroupRoleCustom userGroupRoleCustom : findByUserIdGroupIdRoleId(
				userId, groupId, roleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(userGroupRoleCustom);
		}
	}

	/**
	 * Returns the number of user group role customs where userId = &#63; and groupId = &#63; and roleId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @return the number of matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdGroupIdRoleId(long userId, long groupId, long roleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDGROUPIDROLEID;

		Object[] finderArgs = new Object[] { userId, groupId, roleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_USERGROUPROLECUSTOM_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPIDROLEID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPIDROLEID_GROUPID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPIDROLEID_ROLEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				qPos.add(roleId);

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

	private static final String _FINDER_COLUMN_USERIDGROUPIDROLEID_USERID_2 = "userGroupRoleCustom.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDGROUPIDROLEID_GROUPID_2 = "userGroupRoleCustom.id.groupId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDGROUPIDROLEID_ROLEID_2 = "userGroupRoleCustom.id.roleId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDROLEIDCUSTOMID =
		new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED,
			UserGroupRoleCustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupIdRoleIdCustomId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDROLEIDCUSTOMID =
		new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED,
			UserGroupRoleCustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdRoleIdCustomId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			UserGroupRoleCustomModelImpl.GROUPID_COLUMN_BITMASK |
			UserGroupRoleCustomModelImpl.ROLEID_COLUMN_BITMASK |
			UserGroupRoleCustomModelImpl.CUSTOMID_COLUMN_BITMASK |
			UserGroupRoleCustomModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDROLEIDCUSTOMID = new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdRoleIdCustomId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the user group role customs where groupId = &#63; and roleId = &#63; and customId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param customId the custom ID
	 * @return the matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findByGroupIdRoleIdCustomId(long groupId,
		long roleId, long customId) throws SystemException {
		return findByGroupIdRoleIdCustomId(groupId, roleId, customId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user group role customs where groupId = &#63; and roleId = &#63; and customId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param customId the custom ID
	 * @param start the lower bound of the range of user group role customs
	 * @param end the upper bound of the range of user group role customs (not inclusive)
	 * @return the range of matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findByGroupIdRoleIdCustomId(long groupId,
		long roleId, long customId, int start, int end)
		throws SystemException {
		return findByGroupIdRoleIdCustomId(groupId, roleId, customId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the user group role customs where groupId = &#63; and roleId = &#63; and customId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param customId the custom ID
	 * @param start the lower bound of the range of user group role customs
	 * @param end the upper bound of the range of user group role customs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findByGroupIdRoleIdCustomId(long groupId,
		long roleId, long customId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDROLEIDCUSTOMID;
			finderArgs = new Object[] { groupId, roleId, customId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDROLEIDCUSTOMID;
			finderArgs = new Object[] {
					groupId, roleId, customId,
					
					start, end, orderByComparator
				};
		}

		List<UserGroupRoleCustom> list = (List<UserGroupRoleCustom>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserGroupRoleCustom userGroupRoleCustom : list) {
				if ((groupId != userGroupRoleCustom.getGroupId()) ||
						(roleId != userGroupRoleCustom.getRoleId()) ||
						(customId != userGroupRoleCustom.getCustomId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_USERGROUPROLECUSTOM_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDROLEIDCUSTOMID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDROLEIDCUSTOMID_ROLEID_2);

			query.append(_FINDER_COLUMN_GROUPIDROLEIDCUSTOMID_CUSTOMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserGroupRoleCustomModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roleId);

				qPos.add(customId);

				if (!pagination) {
					list = (List<UserGroupRoleCustom>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserGroupRoleCustom>(list);
				}
				else {
					list = (List<UserGroupRoleCustom>)QueryUtil.list(q,
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
	 * Returns the first user group role custom in the ordered set where groupId = &#63; and roleId = &#63; and customId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom findByGroupIdRoleIdCustomId_First(long groupId,
		long roleId, long customId, OrderByComparator orderByComparator)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		UserGroupRoleCustom userGroupRoleCustom = fetchByGroupIdRoleIdCustomId_First(groupId,
				roleId, customId, orderByComparator);

		if (userGroupRoleCustom != null) {
			return userGroupRoleCustom;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(", customId=");
		msg.append(customId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserGroupRoleCustomException(msg.toString());
	}

	/**
	 * Returns the first user group role custom in the ordered set where groupId = &#63; and roleId = &#63; and customId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom fetchByGroupIdRoleIdCustomId_First(
		long groupId, long roleId, long customId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UserGroupRoleCustom> list = findByGroupIdRoleIdCustomId(groupId,
				roleId, customId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user group role custom in the ordered set where groupId = &#63; and roleId = &#63; and customId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom findByGroupIdRoleIdCustomId_Last(long groupId,
		long roleId, long customId, OrderByComparator orderByComparator)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		UserGroupRoleCustom userGroupRoleCustom = fetchByGroupIdRoleIdCustomId_Last(groupId,
				roleId, customId, orderByComparator);

		if (userGroupRoleCustom != null) {
			return userGroupRoleCustom;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", roleId=");
		msg.append(roleId);

		msg.append(", customId=");
		msg.append(customId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserGroupRoleCustomException(msg.toString());
	}

	/**
	 * Returns the last user group role custom in the ordered set where groupId = &#63; and roleId = &#63; and customId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom fetchByGroupIdRoleIdCustomId_Last(long groupId,
		long roleId, long customId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupIdRoleIdCustomId(groupId, roleId, customId);

		if (count == 0) {
			return null;
		}

		List<UserGroupRoleCustom> list = findByGroupIdRoleIdCustomId(groupId,
				roleId, customId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user group role customs before and after the current user group role custom in the ordered set where groupId = &#63; and roleId = &#63; and customId = &#63;.
	 *
	 * @param userGroupRoleCustomPK the primary key of the current user group role custom
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom[] findByGroupIdRoleIdCustomId_PrevAndNext(
		UserGroupRoleCustomPK userGroupRoleCustomPK, long groupId, long roleId,
		long customId, OrderByComparator orderByComparator)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		UserGroupRoleCustom userGroupRoleCustom = findByPrimaryKey(userGroupRoleCustomPK);

		Session session = null;

		try {
			session = openSession();

			UserGroupRoleCustom[] array = new UserGroupRoleCustomImpl[3];

			array[0] = getByGroupIdRoleIdCustomId_PrevAndNext(session,
					userGroupRoleCustom, groupId, roleId, customId,
					orderByComparator, true);

			array[1] = userGroupRoleCustom;

			array[2] = getByGroupIdRoleIdCustomId_PrevAndNext(session,
					userGroupRoleCustom, groupId, roleId, customId,
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

	protected UserGroupRoleCustom getByGroupIdRoleIdCustomId_PrevAndNext(
		Session session, UserGroupRoleCustom userGroupRoleCustom, long groupId,
		long roleId, long customId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERGROUPROLECUSTOM_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDROLEIDCUSTOMID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDROLEIDCUSTOMID_ROLEID_2);

		query.append(_FINDER_COLUMN_GROUPIDROLEIDCUSTOMID_CUSTOMID_2);

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
			query.append(UserGroupRoleCustomModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(roleId);

		qPos.add(customId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userGroupRoleCustom);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserGroupRoleCustom> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user group role customs where groupId = &#63; and roleId = &#63; and customId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param customId the custom ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupIdRoleIdCustomId(long groupId, long roleId,
		long customId) throws SystemException {
		for (UserGroupRoleCustom userGroupRoleCustom : findByGroupIdRoleIdCustomId(
				groupId, roleId, customId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(userGroupRoleCustom);
		}
	}

	/**
	 * Returns the number of user group role customs where groupId = &#63; and roleId = &#63; and customId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param roleId the role ID
	 * @param customId the custom ID
	 * @return the number of matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupIdRoleIdCustomId(long groupId, long roleId,
		long customId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDROLEIDCUSTOMID;

		Object[] finderArgs = new Object[] { groupId, roleId, customId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_USERGROUPROLECUSTOM_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDROLEIDCUSTOMID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDROLEIDCUSTOMID_ROLEID_2);

			query.append(_FINDER_COLUMN_GROUPIDROLEIDCUSTOMID_CUSTOMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(roleId);

				qPos.add(customId);

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

	private static final String _FINDER_COLUMN_GROUPIDROLEIDCUSTOMID_GROUPID_2 = "userGroupRoleCustom.id.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDROLEIDCUSTOMID_ROLEID_2 = "userGroupRoleCustom.id.roleId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDROLEIDCUSTOMID_CUSTOMID_2 = "userGroupRoleCustom.id.customId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDGROUPID =
		new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED,
			UserGroupRoleCustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID =
		new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED,
			UserGroupRoleCustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserGroupRoleCustomModelImpl.USERID_COLUMN_BITMASK |
			UserGroupRoleCustomModelImpl.GROUPID_COLUMN_BITMASK |
			UserGroupRoleCustomModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDGROUPID = new FinderPath(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the user group role customs where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findByUserIdGroupId(long userId,
		long groupId) throws SystemException {
		return findByUserIdGroupId(userId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user group role customs where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of user group role customs
	 * @param end the upper bound of the range of user group role customs (not inclusive)
	 * @return the range of matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findByUserIdGroupId(long userId,
		long groupId, int start, int end) throws SystemException {
		return findByUserIdGroupId(userId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user group role customs where userId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of user group role customs
	 * @param end the upper bound of the range of user group role customs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findByUserIdGroupId(long userId,
		long groupId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID;
			finderArgs = new Object[] { userId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDGROUPID;
			finderArgs = new Object[] {
					userId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<UserGroupRoleCustom> list = (List<UserGroupRoleCustom>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserGroupRoleCustom userGroupRoleCustom : list) {
				if ((userId != userGroupRoleCustom.getUserId()) ||
						(groupId != userGroupRoleCustom.getGroupId())) {
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

			query.append(_SQL_SELECT_USERGROUPROLECUSTOM_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UserGroupRoleCustomModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserGroupRoleCustom>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserGroupRoleCustom>(list);
				}
				else {
					list = (List<UserGroupRoleCustom>)QueryUtil.list(q,
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
	 * Returns the first user group role custom in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom findByUserIdGroupId_First(long userId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		UserGroupRoleCustom userGroupRoleCustom = fetchByUserIdGroupId_First(userId,
				groupId, orderByComparator);

		if (userGroupRoleCustom != null) {
			return userGroupRoleCustom;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserGroupRoleCustomException(msg.toString());
	}

	/**
	 * Returns the first user group role custom in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom fetchByUserIdGroupId_First(long userId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<UserGroupRoleCustom> list = findByUserIdGroupId(userId, groupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user group role custom in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom findByUserIdGroupId_Last(long userId,
		long groupId, OrderByComparator orderByComparator)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		UserGroupRoleCustom userGroupRoleCustom = fetchByUserIdGroupId_Last(userId,
				groupId, orderByComparator);

		if (userGroupRoleCustom != null) {
			return userGroupRoleCustom;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUserGroupRoleCustomException(msg.toString());
	}

	/**
	 * Returns the last user group role custom in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group role custom, or <code>null</code> if a matching user group role custom could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom fetchByUserIdGroupId_Last(long userId,
		long groupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUserIdGroupId(userId, groupId);

		if (count == 0) {
			return null;
		}

		List<UserGroupRoleCustom> list = findByUserIdGroupId(userId, groupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user group role customs before and after the current user group role custom in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userGroupRoleCustomPK the primary key of the current user group role custom
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom[] findByUserIdGroupId_PrevAndNext(
		UserGroupRoleCustomPK userGroupRoleCustomPK, long userId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		UserGroupRoleCustom userGroupRoleCustom = findByPrimaryKey(userGroupRoleCustomPK);

		Session session = null;

		try {
			session = openSession();

			UserGroupRoleCustom[] array = new UserGroupRoleCustomImpl[3];

			array[0] = getByUserIdGroupId_PrevAndNext(session,
					userGroupRoleCustom, userId, groupId, orderByComparator,
					true);

			array[1] = userGroupRoleCustom;

			array[2] = getByUserIdGroupId_PrevAndNext(session,
					userGroupRoleCustom, userId, groupId, orderByComparator,
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

	protected UserGroupRoleCustom getByUserIdGroupId_PrevAndNext(
		Session session, UserGroupRoleCustom userGroupRoleCustom, long userId,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERGROUPROLECUSTOM_WHERE);

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

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
			query.append(UserGroupRoleCustomModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(userGroupRoleCustom);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UserGroupRoleCustom> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user group role customs where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		for (UserGroupRoleCustom userGroupRoleCustom : findByUserIdGroupId(
				userId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(userGroupRoleCustom);
		}
	}

	/**
	 * Returns the number of user group role customs where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUserIdGroupId(long userId, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDGROUPID;

		Object[] finderArgs = new Object[] { userId, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERGROUPROLECUSTOM_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

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

	private static final String _FINDER_COLUMN_USERIDGROUPID_USERID_2 = "userGroupRoleCustom.id.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDGROUPID_GROUPID_2 = "userGroupRoleCustom.id.groupId = ?";

	public UserGroupRoleCustomPersistenceImpl() {
		setModelClass(UserGroupRoleCustom.class);
	}

	/**
	 * Caches the user group role custom in the entity cache if it is enabled.
	 *
	 * @param userGroupRoleCustom the user group role custom
	 */
	@Override
	public void cacheResult(UserGroupRoleCustom userGroupRoleCustom) {
		EntityCacheUtil.putResult(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomImpl.class, userGroupRoleCustom.getPrimaryKey(),
			userGroupRoleCustom);

		userGroupRoleCustom.resetOriginalValues();
	}

	/**
	 * Caches the user group role customs in the entity cache if it is enabled.
	 *
	 * @param userGroupRoleCustoms the user group role customs
	 */
	@Override
	public void cacheResult(List<UserGroupRoleCustom> userGroupRoleCustoms) {
		for (UserGroupRoleCustom userGroupRoleCustom : userGroupRoleCustoms) {
			if (EntityCacheUtil.getResult(
						UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
						UserGroupRoleCustomImpl.class,
						userGroupRoleCustom.getPrimaryKey()) == null) {
				cacheResult(userGroupRoleCustom);
			}
			else {
				userGroupRoleCustom.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user group role customs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UserGroupRoleCustomImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UserGroupRoleCustomImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user group role custom.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserGroupRoleCustom userGroupRoleCustom) {
		EntityCacheUtil.removeResult(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomImpl.class, userGroupRoleCustom.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserGroupRoleCustom> userGroupRoleCustoms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserGroupRoleCustom userGroupRoleCustom : userGroupRoleCustoms) {
			EntityCacheUtil.removeResult(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
				UserGroupRoleCustomImpl.class,
				userGroupRoleCustom.getPrimaryKey());
		}
	}

	/**
	 * Creates a new user group role custom with the primary key. Does not add the user group role custom to the database.
	 *
	 * @param userGroupRoleCustomPK the primary key for the new user group role custom
	 * @return the new user group role custom
	 */
	@Override
	public UserGroupRoleCustom create(
		UserGroupRoleCustomPK userGroupRoleCustomPK) {
		UserGroupRoleCustom userGroupRoleCustom = new UserGroupRoleCustomImpl();

		userGroupRoleCustom.setNew(true);
		userGroupRoleCustom.setPrimaryKey(userGroupRoleCustomPK);

		return userGroupRoleCustom;
	}

	/**
	 * Removes the user group role custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroupRoleCustomPK the primary key of the user group role custom
	 * @return the user group role custom that was removed
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom remove(
		UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		return remove((Serializable)userGroupRoleCustomPK);
	}

	/**
	 * Removes the user group role custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user group role custom
	 * @return the user group role custom that was removed
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom remove(Serializable primaryKey)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UserGroupRoleCustom userGroupRoleCustom = (UserGroupRoleCustom)session.get(UserGroupRoleCustomImpl.class,
					primaryKey);

			if (userGroupRoleCustom == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserGroupRoleCustomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userGroupRoleCustom);
		}
		catch (NoSuchUserGroupRoleCustomException nsee) {
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
	protected UserGroupRoleCustom removeImpl(
		UserGroupRoleCustom userGroupRoleCustom) throws SystemException {
		userGroupRoleCustom = toUnwrappedModel(userGroupRoleCustom);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userGroupRoleCustom)) {
				userGroupRoleCustom = (UserGroupRoleCustom)session.get(UserGroupRoleCustomImpl.class,
						userGroupRoleCustom.getPrimaryKeyObj());
			}

			if (userGroupRoleCustom != null) {
				session.delete(userGroupRoleCustom);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userGroupRoleCustom != null) {
			clearCache(userGroupRoleCustom);
		}

		return userGroupRoleCustom;
	}

	@Override
	public UserGroupRoleCustom updateImpl(
		org.kisti.edison.customauthmanager.model.UserGroupRoleCustom userGroupRoleCustom)
		throws SystemException {
		userGroupRoleCustom = toUnwrappedModel(userGroupRoleCustom);

		boolean isNew = userGroupRoleCustom.isNew();

		UserGroupRoleCustomModelImpl userGroupRoleCustomModelImpl = (UserGroupRoleCustomModelImpl)userGroupRoleCustom;

		Session session = null;

		try {
			session = openSession();

			if (userGroupRoleCustom.isNew()) {
				session.save(userGroupRoleCustom);

				userGroupRoleCustom.setNew(false);
			}
			else {
				session.merge(userGroupRoleCustom);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserGroupRoleCustomModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((userGroupRoleCustomModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDROLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userGroupRoleCustomModelImpl.getOriginalGroupId(),
						userGroupRoleCustomModelImpl.getOriginalRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDROLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDROLEID,
					args);

				args = new Object[] {
						userGroupRoleCustomModelImpl.getGroupId(),
						userGroupRoleCustomModelImpl.getRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDROLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDROLEID,
					args);
			}

			if ((userGroupRoleCustomModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPIDROLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userGroupRoleCustomModelImpl.getOriginalUserId(),
						userGroupRoleCustomModelImpl.getOriginalGroupId(),
						userGroupRoleCustomModelImpl.getOriginalRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPIDROLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPIDROLEID,
					args);

				args = new Object[] {
						userGroupRoleCustomModelImpl.getUserId(),
						userGroupRoleCustomModelImpl.getGroupId(),
						userGroupRoleCustomModelImpl.getRoleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPIDROLEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPIDROLEID,
					args);
			}

			if ((userGroupRoleCustomModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDROLEIDCUSTOMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userGroupRoleCustomModelImpl.getOriginalGroupId(),
						userGroupRoleCustomModelImpl.getOriginalRoleId(),
						userGroupRoleCustomModelImpl.getOriginalCustomId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDROLEIDCUSTOMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDROLEIDCUSTOMID,
					args);

				args = new Object[] {
						userGroupRoleCustomModelImpl.getGroupId(),
						userGroupRoleCustomModelImpl.getRoleId(),
						userGroupRoleCustomModelImpl.getCustomId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDROLEIDCUSTOMID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDROLEIDCUSTOMID,
					args);
			}

			if ((userGroupRoleCustomModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userGroupRoleCustomModelImpl.getOriginalUserId(),
						userGroupRoleCustomModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID,
					args);

				args = new Object[] {
						userGroupRoleCustomModelImpl.getUserId(),
						userGroupRoleCustomModelImpl.getGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
			UserGroupRoleCustomImpl.class, userGroupRoleCustom.getPrimaryKey(),
			userGroupRoleCustom);

		return userGroupRoleCustom;
	}

	protected UserGroupRoleCustom toUnwrappedModel(
		UserGroupRoleCustom userGroupRoleCustom) {
		if (userGroupRoleCustom instanceof UserGroupRoleCustomImpl) {
			return userGroupRoleCustom;
		}

		UserGroupRoleCustomImpl userGroupRoleCustomImpl = new UserGroupRoleCustomImpl();

		userGroupRoleCustomImpl.setNew(userGroupRoleCustom.isNew());
		userGroupRoleCustomImpl.setPrimaryKey(userGroupRoleCustom.getPrimaryKey());

		userGroupRoleCustomImpl.setUserId(userGroupRoleCustom.getUserId());
		userGroupRoleCustomImpl.setGroupId(userGroupRoleCustom.getGroupId());
		userGroupRoleCustomImpl.setRoleId(userGroupRoleCustom.getRoleId());
		userGroupRoleCustomImpl.setCustomId(userGroupRoleCustom.getCustomId());
		userGroupRoleCustomImpl.setCreateDate(userGroupRoleCustom.getCreateDate());

		return userGroupRoleCustomImpl;
	}

	/**
	 * Returns the user group role custom with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user group role custom
	 * @return the user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		UserGroupRoleCustom userGroupRoleCustom = fetchByPrimaryKey(primaryKey);

		if (userGroupRoleCustom == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserGroupRoleCustomException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userGroupRoleCustom;
	}

	/**
	 * Returns the user group role custom with the primary key or throws a {@link org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException} if it could not be found.
	 *
	 * @param userGroupRoleCustomPK the primary key of the user group role custom
	 * @return the user group role custom
	 * @throws org.kisti.edison.customauthmanager.NoSuchUserGroupRoleCustomException if a user group role custom with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom findByPrimaryKey(
		UserGroupRoleCustomPK userGroupRoleCustomPK)
		throws NoSuchUserGroupRoleCustomException, SystemException {
		return findByPrimaryKey((Serializable)userGroupRoleCustomPK);
	}

	/**
	 * Returns the user group role custom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user group role custom
	 * @return the user group role custom, or <code>null</code> if a user group role custom with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UserGroupRoleCustom userGroupRoleCustom = (UserGroupRoleCustom)EntityCacheUtil.getResult(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
				UserGroupRoleCustomImpl.class, primaryKey);

		if (userGroupRoleCustom == _nullUserGroupRoleCustom) {
			return null;
		}

		if (userGroupRoleCustom == null) {
			Session session = null;

			try {
				session = openSession();

				userGroupRoleCustom = (UserGroupRoleCustom)session.get(UserGroupRoleCustomImpl.class,
						primaryKey);

				if (userGroupRoleCustom != null) {
					cacheResult(userGroupRoleCustom);
				}
				else {
					EntityCacheUtil.putResult(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
						UserGroupRoleCustomImpl.class, primaryKey,
						_nullUserGroupRoleCustom);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UserGroupRoleCustomModelImpl.ENTITY_CACHE_ENABLED,
					UserGroupRoleCustomImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userGroupRoleCustom;
	}

	/**
	 * Returns the user group role custom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userGroupRoleCustomPK the primary key of the user group role custom
	 * @return the user group role custom, or <code>null</code> if a user group role custom with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UserGroupRoleCustom fetchByPrimaryKey(
		UserGroupRoleCustomPK userGroupRoleCustomPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)userGroupRoleCustomPK);
	}

	/**
	 * Returns all the user group role customs.
	 *
	 * @return the user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user group role customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user group role customs
	 * @param end the upper bound of the range of user group role customs (not inclusive)
	 * @return the range of user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user group role customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.customauthmanager.model.impl.UserGroupRoleCustomModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user group role customs
	 * @param end the upper bound of the range of user group role customs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user group role customs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UserGroupRoleCustom> findAll(int start, int end,
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

		List<UserGroupRoleCustom> list = (List<UserGroupRoleCustom>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USERGROUPROLECUSTOM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERGROUPROLECUSTOM;

				if (pagination) {
					sql = sql.concat(UserGroupRoleCustomModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserGroupRoleCustom>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UserGroupRoleCustom>(list);
				}
				else {
					list = (List<UserGroupRoleCustom>)QueryUtil.list(q,
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
	 * Removes all the user group role customs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UserGroupRoleCustom userGroupRoleCustom : findAll()) {
			remove(userGroupRoleCustom);
		}
	}

	/**
	 * Returns the number of user group role customs.
	 *
	 * @return the number of user group role customs
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

				Query q = session.createQuery(_SQL_COUNT_USERGROUPROLECUSTOM);

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
	 * Initializes the user group role custom persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.customauthmanager.model.UserGroupRoleCustom")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UserGroupRoleCustom>> listenersList = new ArrayList<ModelListener<UserGroupRoleCustom>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UserGroupRoleCustom>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UserGroupRoleCustomImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_USERGROUPROLECUSTOM = "SELECT userGroupRoleCustom FROM UserGroupRoleCustom userGroupRoleCustom";
	private static final String _SQL_SELECT_USERGROUPROLECUSTOM_WHERE = "SELECT userGroupRoleCustom FROM UserGroupRoleCustom userGroupRoleCustom WHERE ";
	private static final String _SQL_COUNT_USERGROUPROLECUSTOM = "SELECT COUNT(userGroupRoleCustom) FROM UserGroupRoleCustom userGroupRoleCustom";
	private static final String _SQL_COUNT_USERGROUPROLECUSTOM_WHERE = "SELECT COUNT(userGroupRoleCustom) FROM UserGroupRoleCustom userGroupRoleCustom WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userGroupRoleCustom.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserGroupRoleCustom exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserGroupRoleCustom exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UserGroupRoleCustomPersistenceImpl.class);
	private static UserGroupRoleCustom _nullUserGroupRoleCustom = new UserGroupRoleCustomImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UserGroupRoleCustom> toCacheModel() {
				return _nullUserGroupRoleCustomCacheModel;
			}
		};

	private static CacheModel<UserGroupRoleCustom> _nullUserGroupRoleCustomCacheModel =
		new CacheModel<UserGroupRoleCustom>() {
			@Override
			public UserGroupRoleCustom toEntityModel() {
				return _nullUserGroupRoleCustom;
			}
		};
}