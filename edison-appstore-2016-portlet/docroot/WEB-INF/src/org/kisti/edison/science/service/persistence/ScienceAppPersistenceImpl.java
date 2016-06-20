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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.kisti.edison.science.NoSuchScienceAppException;
import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.model.impl.ScienceAppImpl;
import org.kisti.edison.science.model.impl.ScienceAppModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the science app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see ScienceAppPersistence
 * @see ScienceAppUtil
 * @generated
 */
public class ScienceAppPersistenceImpl extends BasePersistenceImpl<ScienceApp>
	implements ScienceAppPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScienceAppUtil} to access the science app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScienceAppImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ScienceAppModelImpl.UUID_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the science apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!Validator.equals(uuid, scienceApp.getUuid())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByUuid_First(uuid, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceApp> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByUuid_Last(uuid, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where uuid = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByUuid_PrevAndNext(long scienceAppId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByUuid_PrevAndNext(session, scienceApp, uuid,
					orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByUuid_PrevAndNext(session, scienceApp, uuid,
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

	protected ScienceApp getByUuid_PrevAndNext(Session session,
		ScienceApp scienceApp, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ScienceApp scienceApp : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "scienceApp.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "scienceApp.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(scienceApp.uuid IS NULL OR scienceApp.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ScienceAppModelImpl.UUID_COLUMN_BITMASK |
			ScienceAppModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the science app where uuid = &#63; and groupId = &#63; or throws a {@link org.kisti.edison.science.NoSuchScienceAppException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByUUID_G(String uuid, long groupId)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByUUID_G(uuid, groupId);

		if (scienceApp == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchScienceAppException(msg.toString());
		}

		return scienceApp;
	}

	/**
	 * Returns the science app where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the science app where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ScienceApp) {
			ScienceApp scienceApp = (ScienceApp)result;

			if (!Validator.equals(uuid, scienceApp.getUuid()) ||
					(groupId != scienceApp.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<ScienceApp> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ScienceApp scienceApp = list.get(0);

					result = scienceApp;

					cacheResult(scienceApp);

					if ((scienceApp.getUuid() == null) ||
							!scienceApp.getUuid().equals(uuid) ||
							(scienceApp.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, scienceApp);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
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
			return (ScienceApp)result;
		}
	}

	/**
	 * Removes the science app where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the science app that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp removeByUUID_G(String uuid, long groupId)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByUUID_G(uuid, groupId);

		return remove(scienceApp);
	}

	/**
	 * Returns the number of science apps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "scienceApp.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "scienceApp.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(scienceApp.uuid IS NULL OR scienceApp.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "scienceApp.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ScienceAppModelImpl.UUID_COLUMN_BITMASK |
			ScienceAppModelImpl.COMPANYID_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the science apps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!Validator.equals(uuid, scienceApp.getUuid()) ||
						(companyId != scienceApp.getCompanyId())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceApp> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByUuid_C_PrevAndNext(long scienceAppId,
		String uuid, long companyId, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, scienceApp, uuid,
					companyId, orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByUuid_C_PrevAndNext(session, scienceApp, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceApp getByUuid_C_PrevAndNext(Session session,
		ScienceApp scienceApp, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ScienceApp scienceApp : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "scienceApp.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "scienceApp.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(scienceApp.uuid IS NULL OR scienceApp.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "scienceApp.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByName",
			new String[] { String.class.getName() },
			ScienceAppModelImpl.NAME_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the science apps where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
			finderArgs = new Object[] { name, start, end, orderByComparator };
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!Validator.equals(name, scienceApp.getName())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByName_First(name, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceApp> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByName_Last(name, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where name = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByName_PrevAndNext(long scienceAppId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByName_PrevAndNext(session, scienceApp, name,
					orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByName_PrevAndNext(session, scienceApp, name,
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

	protected ScienceApp getByName_PrevAndNext(Session session,
		ScienceApp scienceApp, String name,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where name = &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (ScienceApp scienceApp : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "scienceApp.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "scienceApp.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(scienceApp.name IS NULL OR scienceApp.name = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPTYPE = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPTYPE =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAppType",
			new String[] { String.class.getName() },
			ScienceAppModelImpl.APPTYPE_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPTYPE = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAppType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the science apps where appType = &#63;.
	 *
	 * @param appType the app type
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAppType(String appType)
		throws SystemException {
		return findByAppType(appType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where appType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appType the app type
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAppType(String appType, int start, int end)
		throws SystemException {
		return findByAppType(appType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where appType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appType the app type
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAppType(String appType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPTYPE;
			finderArgs = new Object[] { appType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPTYPE;
			finderArgs = new Object[] { appType, start, end, orderByComparator };
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!Validator.equals(appType, scienceApp.getAppType())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindAppType = false;

			if (appType == null) {
				query.append(_FINDER_COLUMN_APPTYPE_APPTYPE_1);
			}
			else if (appType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPTYPE_APPTYPE_3);
			}
			else {
				bindAppType = true;

				query.append(_FINDER_COLUMN_APPTYPE_APPTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppType) {
					qPos.add(appType);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where appType = &#63;.
	 *
	 * @param appType the app type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAppType_First(String appType,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAppType_First(appType, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appType=");
		msg.append(appType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where appType = &#63;.
	 *
	 * @param appType the app type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAppType_First(String appType,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceApp> list = findByAppType(appType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where appType = &#63;.
	 *
	 * @param appType the app type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAppType_Last(String appType,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAppType_Last(appType, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appType=");
		msg.append(appType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where appType = &#63;.
	 *
	 * @param appType the app type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAppType_Last(String appType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAppType(appType);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByAppType(appType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where appType = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param appType the app type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByAppType_PrevAndNext(long scienceAppId,
		String appType, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByAppType_PrevAndNext(session, scienceApp, appType,
					orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByAppType_PrevAndNext(session, scienceApp, appType,
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

	protected ScienceApp getByAppType_PrevAndNext(Session session,
		ScienceApp scienceApp, String appType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindAppType = false;

		if (appType == null) {
			query.append(_FINDER_COLUMN_APPTYPE_APPTYPE_1);
		}
		else if (appType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPTYPE_APPTYPE_3);
		}
		else {
			bindAppType = true;

			query.append(_FINDER_COLUMN_APPTYPE_APPTYPE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAppType) {
			qPos.add(appType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where appType = &#63; from the database.
	 *
	 * @param appType the app type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAppType(String appType) throws SystemException {
		for (ScienceApp scienceApp : findByAppType(appType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where appType = &#63;.
	 *
	 * @param appType the app type
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAppType(String appType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPTYPE;

		Object[] finderArgs = new Object[] { appType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindAppType = false;

			if (appType == null) {
				query.append(_FINDER_COLUMN_APPTYPE_APPTYPE_1);
			}
			else if (appType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPTYPE_APPTYPE_3);
			}
			else {
				bindAppType = true;

				query.append(_FINDER_COLUMN_APPTYPE_APPTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppType) {
					qPos.add(appType);
				}

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

	private static final String _FINDER_COLUMN_APPTYPE_APPTYPE_1 = "scienceApp.appType IS NULL";
	private static final String _FINDER_COLUMN_APPTYPE_APPTYPE_2 = "scienceApp.appType = ?";
	private static final String _FINDER_COLUMN_APPTYPE_APPTYPE_3 = "(scienceApp.appType IS NULL OR scienceApp.appType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPRUNTYPE =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppRunType",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRUNTYPE =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAppRunType",
			new String[] { String.class.getName(), String.class.getName() },
			ScienceAppModelImpl.APPTYPE_COLUMN_BITMASK |
			ScienceAppModelImpl.RUNTYPE_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPRUNTYPE = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAppRunType",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the science apps where appType = &#63; and runType = &#63;.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAppRunType(String appType, String runType)
		throws SystemException {
		return findByAppRunType(appType, runType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where appType = &#63; and runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAppRunType(String appType, String runType,
		int start, int end) throws SystemException {
		return findByAppRunType(appType, runType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where appType = &#63; and runType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAppRunType(String appType, String runType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRUNTYPE;
			finderArgs = new Object[] { appType, runType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPRUNTYPE;
			finderArgs = new Object[] {
					appType, runType,
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!Validator.equals(appType, scienceApp.getAppType()) ||
						!Validator.equals(runType, scienceApp.getRunType())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindAppType = false;

			if (appType == null) {
				query.append(_FINDER_COLUMN_APPRUNTYPE_APPTYPE_1);
			}
			else if (appType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPRUNTYPE_APPTYPE_3);
			}
			else {
				bindAppType = true;

				query.append(_FINDER_COLUMN_APPRUNTYPE_APPTYPE_2);
			}

			boolean bindRunType = false;

			if (runType == null) {
				query.append(_FINDER_COLUMN_APPRUNTYPE_RUNTYPE_1);
			}
			else if (runType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPRUNTYPE_RUNTYPE_3);
			}
			else {
				bindRunType = true;

				query.append(_FINDER_COLUMN_APPRUNTYPE_RUNTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppType) {
					qPos.add(appType);
				}

				if (bindRunType) {
					qPos.add(runType);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where appType = &#63; and runType = &#63;.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAppRunType_First(String appType, String runType,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAppRunType_First(appType, runType,
				orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appType=");
		msg.append(appType);

		msg.append(", runType=");
		msg.append(runType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where appType = &#63; and runType = &#63;.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAppRunType_First(String appType, String runType,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceApp> list = findByAppRunType(appType, runType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where appType = &#63; and runType = &#63;.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAppRunType_Last(String appType, String runType,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAppRunType_Last(appType, runType,
				orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appType=");
		msg.append(appType);

		msg.append(", runType=");
		msg.append(runType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where appType = &#63; and runType = &#63;.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAppRunType_Last(String appType, String runType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAppRunType(appType, runType);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByAppRunType(appType, runType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where appType = &#63; and runType = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param appType the app type
	 * @param runType the run type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByAppRunType_PrevAndNext(long scienceAppId,
		String appType, String runType, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByAppRunType_PrevAndNext(session, scienceApp,
					appType, runType, orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByAppRunType_PrevAndNext(session, scienceApp,
					appType, runType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceApp getByAppRunType_PrevAndNext(Session session,
		ScienceApp scienceApp, String appType, String runType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindAppType = false;

		if (appType == null) {
			query.append(_FINDER_COLUMN_APPRUNTYPE_APPTYPE_1);
		}
		else if (appType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPRUNTYPE_APPTYPE_3);
		}
		else {
			bindAppType = true;

			query.append(_FINDER_COLUMN_APPRUNTYPE_APPTYPE_2);
		}

		boolean bindRunType = false;

		if (runType == null) {
			query.append(_FINDER_COLUMN_APPRUNTYPE_RUNTYPE_1);
		}
		else if (runType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPRUNTYPE_RUNTYPE_3);
		}
		else {
			bindRunType = true;

			query.append(_FINDER_COLUMN_APPRUNTYPE_RUNTYPE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAppType) {
			qPos.add(appType);
		}

		if (bindRunType) {
			qPos.add(runType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where appType = &#63; and runType = &#63; from the database.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAppRunType(String appType, String runType)
		throws SystemException {
		for (ScienceApp scienceApp : findByAppRunType(appType, runType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where appType = &#63; and runType = &#63;.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAppRunType(String appType, String runType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPRUNTYPE;

		Object[] finderArgs = new Object[] { appType, runType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindAppType = false;

			if (appType == null) {
				query.append(_FINDER_COLUMN_APPRUNTYPE_APPTYPE_1);
			}
			else if (appType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPRUNTYPE_APPTYPE_3);
			}
			else {
				bindAppType = true;

				query.append(_FINDER_COLUMN_APPRUNTYPE_APPTYPE_2);
			}

			boolean bindRunType = false;

			if (runType == null) {
				query.append(_FINDER_COLUMN_APPRUNTYPE_RUNTYPE_1);
			}
			else if (runType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPRUNTYPE_RUNTYPE_3);
			}
			else {
				bindRunType = true;

				query.append(_FINDER_COLUMN_APPRUNTYPE_RUNTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppType) {
					qPos.add(appType);
				}

				if (bindRunType) {
					qPos.add(runType);
				}

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

	private static final String _FINDER_COLUMN_APPRUNTYPE_APPTYPE_1 = "scienceApp.appType IS NULL AND ";
	private static final String _FINDER_COLUMN_APPRUNTYPE_APPTYPE_2 = "scienceApp.appType = ? AND ";
	private static final String _FINDER_COLUMN_APPRUNTYPE_APPTYPE_3 = "(scienceApp.appType IS NULL OR scienceApp.appType = '') AND ";
	private static final String _FINDER_COLUMN_APPRUNTYPE_RUNTYPE_1 = "scienceApp.runType IS NULL";
	private static final String _FINDER_COLUMN_APPRUNTYPE_RUNTYPE_2 = "scienceApp.runType = ?";
	private static final String _FINDER_COLUMN_APPRUNTYPE_RUNTYPE_3 = "(scienceApp.runType IS NULL OR scienceApp.runType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORID = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuthorId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuthorId",
			new String[] { Long.class.getName() },
			ScienceAppModelImpl.AUTHORID_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHORID = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthorId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the science apps where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorId(long authorId)
		throws SystemException {
		return findByAuthorId(authorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the science apps where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorId(long authorId, int start, int end)
		throws SystemException {
		return findByAuthorId(authorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where authorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorId(long authorId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID;
			finderArgs = new Object[] { authorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORID;
			finderArgs = new Object[] { authorId, start, end, orderByComparator };
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if ((authorId != scienceApp.getAuthorId())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAuthorId_First(long authorId,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAuthorId_First(authorId,
				orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAuthorId_First(long authorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceApp> list = findByAuthorId(authorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAuthorId_Last(long authorId,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAuthorId_Last(authorId, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAuthorId_Last(long authorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAuthorId(authorId);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByAuthorId(authorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where authorId = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param authorId the author ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByAuthorId_PrevAndNext(long scienceAppId,
		long authorId, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByAuthorId_PrevAndNext(session, scienceApp, authorId,
					orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByAuthorId_PrevAndNext(session, scienceApp, authorId,
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

	protected ScienceApp getByAuthorId_PrevAndNext(Session session,
		ScienceApp scienceApp, long authorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		query.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(authorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where authorId = &#63; from the database.
	 *
	 * @param authorId the author ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAuthorId(long authorId) throws SystemException {
		for (ScienceApp scienceApp : findByAuthorId(authorId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where authorId = &#63;.
	 *
	 * @param authorId the author ID
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAuthorId(long authorId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHORID;

		Object[] finderArgs = new Object[] { authorId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_AUTHORID_AUTHORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

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

	private static final String _FINDER_COLUMN_AUTHORID_AUTHORID_2 = "scienceApp.authorId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STAGE = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStage",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAGE = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStage",
			new String[] { String.class.getName() },
			ScienceAppModelImpl.STAGE_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STAGE = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStage",
			new String[] { String.class.getName() });

	/**
	 * Returns all the science apps where stage = &#63;.
	 *
	 * @param stage the stage
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByStage(String stage) throws SystemException {
		return findByStage(stage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where stage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stage the stage
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByStage(String stage, int start, int end)
		throws SystemException {
		return findByStage(stage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where stage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stage the stage
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByStage(String stage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAGE;
			finderArgs = new Object[] { stage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STAGE;
			finderArgs = new Object[] { stage, start, end, orderByComparator };
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!Validator.equals(stage, scienceApp.getStage())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindStage = false;

			if (stage == null) {
				query.append(_FINDER_COLUMN_STAGE_STAGE_1);
			}
			else if (stage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STAGE_STAGE_3);
			}
			else {
				bindStage = true;

				query.append(_FINDER_COLUMN_STAGE_STAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStage) {
					qPos.add(stage);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where stage = &#63;.
	 *
	 * @param stage the stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByStage_First(String stage,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByStage_First(stage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stage=");
		msg.append(stage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where stage = &#63;.
	 *
	 * @param stage the stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByStage_First(String stage,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceApp> list = findByStage(stage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where stage = &#63;.
	 *
	 * @param stage the stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByStage_Last(String stage,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByStage_Last(stage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stage=");
		msg.append(stage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where stage = &#63;.
	 *
	 * @param stage the stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByStage_Last(String stage,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStage(stage);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByStage(stage, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where stage = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param stage the stage
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByStage_PrevAndNext(long scienceAppId,
		String stage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByStage_PrevAndNext(session, scienceApp, stage,
					orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByStage_PrevAndNext(session, scienceApp, stage,
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

	protected ScienceApp getByStage_PrevAndNext(Session session,
		ScienceApp scienceApp, String stage,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindStage = false;

		if (stage == null) {
			query.append(_FINDER_COLUMN_STAGE_STAGE_1);
		}
		else if (stage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STAGE_STAGE_3);
		}
		else {
			bindStage = true;

			query.append(_FINDER_COLUMN_STAGE_STAGE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStage) {
			qPos.add(stage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where stage = &#63; from the database.
	 *
	 * @param stage the stage
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStage(String stage) throws SystemException {
		for (ScienceApp scienceApp : findByStage(stage, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where stage = &#63;.
	 *
	 * @param stage the stage
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStage(String stage) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STAGE;

		Object[] finderArgs = new Object[] { stage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindStage = false;

			if (stage == null) {
				query.append(_FINDER_COLUMN_STAGE_STAGE_1);
			}
			else if (stage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STAGE_STAGE_3);
			}
			else {
				bindStage = true;

				query.append(_FINDER_COLUMN_STAGE_STAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStage) {
					qPos.add(stage);
				}

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

	private static final String _FINDER_COLUMN_STAGE_STAGE_1 = "scienceApp.stage IS NULL";
	private static final String _FINDER_COLUMN_STAGE_STAGE_2 = "scienceApp.stage = ?";
	private static final String _FINDER_COLUMN_STAGE_STAGE_3 = "(scienceApp.stage IS NULL OR scienceApp.stage = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			ScienceAppModelImpl.STATUS_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the science apps where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByStatus(int status) throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByStatus(int status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByStatus(int status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if ((status != scienceApp.getStatus())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByStatus_First(status, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByStatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceApp> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByStatus_Last(status, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByStatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where status = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByStatus_PrevAndNext(long scienceAppId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByStatus_PrevAndNext(session, scienceApp, status,
					orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByStatus_PrevAndNext(session, scienceApp, status,
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

	protected ScienceApp getByStatus_PrevAndNext(Session session,
		ScienceApp scienceApp, int status, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(int status) throws SystemException {
		for (ScienceApp scienceApp : findByStatus(status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "scienceApp.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLE = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTitle",
			new String[] { String.class.getName() });

	/**
	 * Returns all the science apps where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByTitle(String title) throws SystemException {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByTitle(String title, int start, int end)
		throws SystemException {
		return findByTitle(title, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByTitle(String title, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
		finderArgs = new Object[] { title, start, end, orderByComparator };

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!StringUtil.wildcardMatches(scienceApp.getTitle(), title,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByTitle_First(String title,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByTitle_First(title, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByTitle_First(String title,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceApp> list = findByTitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByTitle_Last(String title,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByTitle_Last(title, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByTitle_Last(String title,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitle(title);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByTitle(title, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where title LIKE &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByTitle_PrevAndNext(long scienceAppId,
		String title, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByTitle_PrevAndNext(session, scienceApp, title,
					orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByTitle_PrevAndNext(session, scienceApp, title,
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

	protected ScienceApp getByTitle_PrevAndNext(Session session,
		ScienceApp scienceApp, String title,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindTitle = false;

		if (title == null) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_1);
		}
		else if (title.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_3);
		}
		else {
			bindTitle = true;

			query.append(_FINDER_COLUMN_TITLE_TITLE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTitle) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where title LIKE &#63; from the database.
	 *
	 * @param title the title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitle(String title) throws SystemException {
		for (ScienceApp scienceApp : findByTitle(title, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTitle(String title) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLE;

		Object[] finderArgs = new Object[] { title };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
				}

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

	private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "scienceApp.title LIKE NULL";
	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "scienceApp.title LIKE ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(scienceApp.title IS NULL OR scienceApp.title LIKE '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAMEVERSION = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNameVersion",
			new String[] { String.class.getName(), String.class.getName() },
			ScienceAppModelImpl.NAME_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMEVERSION = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNameVersion",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the science app where name = &#63; and version = &#63; or throws a {@link org.kisti.edison.science.NoSuchScienceAppException} if it could not be found.
	 *
	 * @param name the name
	 * @param version the version
	 * @return the matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByNameVersion(String name, String version)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByNameVersion(name, version);

		if (scienceApp == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(", version=");
			msg.append(version);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchScienceAppException(msg.toString());
		}

		return scienceApp;
	}

	/**
	 * Returns the science app where name = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param version the version
	 * @return the matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByNameVersion(String name, String version)
		throws SystemException {
		return fetchByNameVersion(name, version, true);
	}

	/**
	 * Returns the science app where name = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param version the version
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByNameVersion(String name, String version,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { name, version };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAMEVERSION,
					finderArgs, this);
		}

		if (result instanceof ScienceApp) {
			ScienceApp scienceApp = (ScienceApp)result;

			if (!Validator.equals(name, scienceApp.getName()) ||
					!Validator.equals(version, scienceApp.getVersion())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEVERSION_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEVERSION_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEVERSION_NAME_2);
			}

			boolean bindVersion = false;

			if (version == null) {
				query.append(_FINDER_COLUMN_NAMEVERSION_VERSION_1);
			}
			else if (version.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEVERSION_VERSION_3);
			}
			else {
				bindVersion = true;

				query.append(_FINDER_COLUMN_NAMEVERSION_VERSION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (bindVersion) {
					qPos.add(version);
				}

				List<ScienceApp> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEVERSION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ScienceAppPersistenceImpl.fetchByNameVersion(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ScienceApp scienceApp = list.get(0);

					result = scienceApp;

					cacheResult(scienceApp);

					if ((scienceApp.getName() == null) ||
							!scienceApp.getName().equals(name) ||
							(scienceApp.getVersion() == null) ||
							!scienceApp.getVersion().equals(version)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEVERSION,
							finderArgs, scienceApp);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEVERSION,
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
			return (ScienceApp)result;
		}
	}

	/**
	 * Removes the science app where name = &#63; and version = &#63; from the database.
	 *
	 * @param name the name
	 * @param version the version
	 * @return the science app that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp removeByNameVersion(String name, String version)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByNameVersion(name, version);

		return remove(scienceApp);
	}

	/**
	 * Returns the number of science apps where name = &#63; and version = &#63;.
	 *
	 * @param name the name
	 * @param version the version
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNameVersion(String name, String version)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMEVERSION;

		Object[] finderArgs = new Object[] { name, version };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEVERSION_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEVERSION_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEVERSION_NAME_2);
			}

			boolean bindVersion = false;

			if (version == null) {
				query.append(_FINDER_COLUMN_NAMEVERSION_VERSION_1);
			}
			else if (version.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEVERSION_VERSION_3);
			}
			else {
				bindVersion = true;

				query.append(_FINDER_COLUMN_NAMEVERSION_VERSION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (bindVersion) {
					qPos.add(version);
				}

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

	private static final String _FINDER_COLUMN_NAMEVERSION_NAME_1 = "scienceApp.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEVERSION_NAME_2 = "scienceApp.name = ? AND ";
	private static final String _FINDER_COLUMN_NAMEVERSION_NAME_3 = "(scienceApp.name IS NULL OR scienceApp.name = '') AND ";
	private static final String _FINDER_COLUMN_NAMEVERSION_VERSION_1 = "scienceApp.version IS NULL";
	private static final String _FINDER_COLUMN_NAMEVERSION_VERSION_2 = "scienceApp.version = ?";
	private static final String _FINDER_COLUMN_NAMEVERSION_VERSION_3 = "(scienceApp.version IS NULL OR scienceApp.version = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORIDAPPTYPE =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuthorIdAppType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDAPPTYPE =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuthorIdAppType",
			new String[] { Long.class.getName(), String.class.getName() },
			ScienceAppModelImpl.AUTHORID_COLUMN_BITMASK |
			ScienceAppModelImpl.APPTYPE_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHORIDAPPTYPE = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAuthorIdAppType",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the science apps where authorId = &#63; and appType = &#63;.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdAppType(long authorId, String appType)
		throws SystemException {
		return findByAuthorIdAppType(authorId, appType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where authorId = &#63; and appType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdAppType(long authorId,
		String appType, int start, int end) throws SystemException {
		return findByAuthorIdAppType(authorId, appType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where authorId = &#63; and appType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdAppType(long authorId,
		String appType, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDAPPTYPE;
			finderArgs = new Object[] { authorId, appType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORIDAPPTYPE;
			finderArgs = new Object[] {
					authorId, appType,
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if ((authorId != scienceApp.getAuthorId()) ||
						!Validator.equals(appType, scienceApp.getAppType())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_AUTHORIDAPPTYPE_AUTHORID_2);

			boolean bindAppType = false;

			if (appType == null) {
				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPE_APPTYPE_1);
			}
			else if (appType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPE_APPTYPE_3);
			}
			else {
				bindAppType = true;

				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPE_APPTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				if (bindAppType) {
					qPos.add(appType);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where authorId = &#63; and appType = &#63;.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAuthorIdAppType_First(long authorId,
		String appType, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAuthorIdAppType_First(authorId, appType,
				orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(", appType=");
		msg.append(appType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where authorId = &#63; and appType = &#63;.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAuthorIdAppType_First(long authorId,
		String appType, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceApp> list = findByAuthorIdAppType(authorId, appType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where authorId = &#63; and appType = &#63;.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAuthorIdAppType_Last(long authorId, String appType,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAuthorIdAppType_Last(authorId, appType,
				orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(", appType=");
		msg.append(appType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where authorId = &#63; and appType = &#63;.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAuthorIdAppType_Last(long authorId,
		String appType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAuthorIdAppType(authorId, appType);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByAuthorIdAppType(authorId, appType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where authorId = &#63; and appType = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByAuthorIdAppType_PrevAndNext(long scienceAppId,
		long authorId, String appType, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByAuthorIdAppType_PrevAndNext(session, scienceApp,
					authorId, appType, orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByAuthorIdAppType_PrevAndNext(session, scienceApp,
					authorId, appType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceApp getByAuthorIdAppType_PrevAndNext(Session session,
		ScienceApp scienceApp, long authorId, String appType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		query.append(_FINDER_COLUMN_AUTHORIDAPPTYPE_AUTHORID_2);

		boolean bindAppType = false;

		if (appType == null) {
			query.append(_FINDER_COLUMN_AUTHORIDAPPTYPE_APPTYPE_1);
		}
		else if (appType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_AUTHORIDAPPTYPE_APPTYPE_3);
		}
		else {
			bindAppType = true;

			query.append(_FINDER_COLUMN_AUTHORIDAPPTYPE_APPTYPE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(authorId);

		if (bindAppType) {
			qPos.add(appType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where authorId = &#63; and appType = &#63; from the database.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAuthorIdAppType(long authorId, String appType)
		throws SystemException {
		for (ScienceApp scienceApp : findByAuthorIdAppType(authorId, appType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where authorId = &#63; and appType = &#63;.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAuthorIdAppType(long authorId, String appType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHORIDAPPTYPE;

		Object[] finderArgs = new Object[] { authorId, appType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_AUTHORIDAPPTYPE_AUTHORID_2);

			boolean bindAppType = false;

			if (appType == null) {
				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPE_APPTYPE_1);
			}
			else if (appType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPE_APPTYPE_3);
			}
			else {
				bindAppType = true;

				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPE_APPTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				if (bindAppType) {
					qPos.add(appType);
				}

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

	private static final String _FINDER_COLUMN_AUTHORIDAPPTYPE_AUTHORID_2 = "scienceApp.authorId = ? AND ";
	private static final String _FINDER_COLUMN_AUTHORIDAPPTYPE_APPTYPE_1 = "scienceApp.appType IS NULL";
	private static final String _FINDER_COLUMN_AUTHORIDAPPTYPE_APPTYPE_2 = "scienceApp.appType = ?";
	private static final String _FINDER_COLUMN_AUTHORIDAPPTYPE_APPTYPE_3 = "(scienceApp.appType IS NULL OR scienceApp.appType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORIDSTATUS =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuthorIdStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDSTATUS =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuthorIdStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			ScienceAppModelImpl.AUTHORID_COLUMN_BITMASK |
			ScienceAppModelImpl.STATUS_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHORIDSTATUS = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthorIdStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the science apps where authorId = &#63; and status = &#63;.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdStatus(long authorId, int status)
		throws SystemException {
		return findByAuthorIdStatus(authorId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where authorId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdStatus(long authorId, int status,
		int start, int end) throws SystemException {
		return findByAuthorIdStatus(authorId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where authorId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdStatus(long authorId, int status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDSTATUS;
			finderArgs = new Object[] { authorId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORIDSTATUS;
			finderArgs = new Object[] {
					authorId, status,
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if ((authorId != scienceApp.getAuthorId()) ||
						(status != scienceApp.getStatus())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_AUTHORIDSTATUS_AUTHORID_2);

			query.append(_FINDER_COLUMN_AUTHORIDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				qPos.add(status);

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where authorId = &#63; and status = &#63;.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAuthorIdStatus_First(long authorId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAuthorIdStatus_First(authorId, status,
				orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where authorId = &#63; and status = &#63;.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAuthorIdStatus_First(long authorId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceApp> list = findByAuthorIdStatus(authorId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where authorId = &#63; and status = &#63;.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAuthorIdStatus_Last(long authorId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAuthorIdStatus_Last(authorId, status,
				orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where authorId = &#63; and status = &#63;.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAuthorIdStatus_Last(long authorId, int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAuthorIdStatus(authorId, status);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByAuthorIdStatus(authorId, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where authorId = &#63; and status = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param authorId the author ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByAuthorIdStatus_PrevAndNext(long scienceAppId,
		long authorId, int status, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByAuthorIdStatus_PrevAndNext(session, scienceApp,
					authorId, status, orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByAuthorIdStatus_PrevAndNext(session, scienceApp,
					authorId, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceApp getByAuthorIdStatus_PrevAndNext(Session session,
		ScienceApp scienceApp, long authorId, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		query.append(_FINDER_COLUMN_AUTHORIDSTATUS_AUTHORID_2);

		query.append(_FINDER_COLUMN_AUTHORIDSTATUS_STATUS_2);

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(authorId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where authorId = &#63; and status = &#63; from the database.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAuthorIdStatus(long authorId, int status)
		throws SystemException {
		for (ScienceApp scienceApp : findByAuthorIdStatus(authorId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where authorId = &#63; and status = &#63;.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAuthorIdStatus(long authorId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHORIDSTATUS;

		Object[] finderArgs = new Object[] { authorId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_AUTHORIDSTATUS_AUTHORID_2);

			query.append(_FINDER_COLUMN_AUTHORIDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_AUTHORIDSTATUS_AUTHORID_2 = "scienceApp.authorId = ? AND ";
	private static final String _FINDER_COLUMN_AUTHORIDSTATUS_STATUS_2 = "scienceApp.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPENLEVEL =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOpenLevel",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENLEVEL =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOpenLevel",
			new String[] { String.class.getName() },
			ScienceAppModelImpl.OPENLEVEL_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPENLEVEL = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOpenLevel",
			new String[] { String.class.getName() });

	/**
	 * Returns all the science apps where openLevel = &#63;.
	 *
	 * @param openLevel the open level
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByOpenLevel(String openLevel)
		throws SystemException {
		return findByOpenLevel(openLevel, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the science apps where openLevel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openLevel the open level
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByOpenLevel(String openLevel, int start, int end)
		throws SystemException {
		return findByOpenLevel(openLevel, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where openLevel = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openLevel the open level
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByOpenLevel(String openLevel, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENLEVEL;
			finderArgs = new Object[] { openLevel };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OPENLEVEL;
			finderArgs = new Object[] { openLevel, start, end, orderByComparator };
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!Validator.equals(openLevel, scienceApp.getOpenLevel())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindOpenLevel = false;

			if (openLevel == null) {
				query.append(_FINDER_COLUMN_OPENLEVEL_OPENLEVEL_1);
			}
			else if (openLevel.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPENLEVEL_OPENLEVEL_3);
			}
			else {
				bindOpenLevel = true;

				query.append(_FINDER_COLUMN_OPENLEVEL_OPENLEVEL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOpenLevel) {
					qPos.add(openLevel);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where openLevel = &#63;.
	 *
	 * @param openLevel the open level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByOpenLevel_First(String openLevel,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByOpenLevel_First(openLevel,
				orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("openLevel=");
		msg.append(openLevel);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where openLevel = &#63;.
	 *
	 * @param openLevel the open level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByOpenLevel_First(String openLevel,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceApp> list = findByOpenLevel(openLevel, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where openLevel = &#63;.
	 *
	 * @param openLevel the open level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByOpenLevel_Last(String openLevel,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByOpenLevel_Last(openLevel,
				orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("openLevel=");
		msg.append(openLevel);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where openLevel = &#63;.
	 *
	 * @param openLevel the open level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByOpenLevel_Last(String openLevel,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOpenLevel(openLevel);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByOpenLevel(openLevel, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where openLevel = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param openLevel the open level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByOpenLevel_PrevAndNext(long scienceAppId,
		String openLevel, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByOpenLevel_PrevAndNext(session, scienceApp,
					openLevel, orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByOpenLevel_PrevAndNext(session, scienceApp,
					openLevel, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceApp getByOpenLevel_PrevAndNext(Session session,
		ScienceApp scienceApp, String openLevel,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindOpenLevel = false;

		if (openLevel == null) {
			query.append(_FINDER_COLUMN_OPENLEVEL_OPENLEVEL_1);
		}
		else if (openLevel.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OPENLEVEL_OPENLEVEL_3);
		}
		else {
			bindOpenLevel = true;

			query.append(_FINDER_COLUMN_OPENLEVEL_OPENLEVEL_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOpenLevel) {
			qPos.add(openLevel);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where openLevel = &#63; from the database.
	 *
	 * @param openLevel the open level
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOpenLevel(String openLevel) throws SystemException {
		for (ScienceApp scienceApp : findByOpenLevel(openLevel,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where openLevel = &#63;.
	 *
	 * @param openLevel the open level
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOpenLevel(String openLevel) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPENLEVEL;

		Object[] finderArgs = new Object[] { openLevel };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindOpenLevel = false;

			if (openLevel == null) {
				query.append(_FINDER_COLUMN_OPENLEVEL_OPENLEVEL_1);
			}
			else if (openLevel.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPENLEVEL_OPENLEVEL_3);
			}
			else {
				bindOpenLevel = true;

				query.append(_FINDER_COLUMN_OPENLEVEL_OPENLEVEL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOpenLevel) {
					qPos.add(openLevel);
				}

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

	private static final String _FINDER_COLUMN_OPENLEVEL_OPENLEVEL_1 = "scienceApp.openLevel IS NULL";
	private static final String _FINDER_COLUMN_OPENLEVEL_OPENLEVEL_2 = "scienceApp.openLevel = ?";
	private static final String _FINDER_COLUMN_OPENLEVEL_OPENLEVEL_3 = "(scienceApp.openLevel IS NULL OR scienceApp.openLevel = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNameWithTarget",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNameWithTarget",
			new String[] { String.class.getName(), String.class.getName() },
			ScienceAppModelImpl.NAME_COLUMN_BITMASK |
			ScienceAppModelImpl.TARGETLANGUAGE_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMEWITHTARGET = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNameWithTarget",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the science apps where name = &#63; and targetLanguage = &#63;.
	 *
	 * @param name the name
	 * @param targetLanguage the target language
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByNameWithTarget(String name,
		String targetLanguage) throws SystemException {
		return findByNameWithTarget(name, targetLanguage, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where name = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByNameWithTarget(String name,
		String targetLanguage, int start, int end) throws SystemException {
		return findByNameWithTarget(name, targetLanguage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where name = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByNameWithTarget(String name,
		String targetLanguage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEWITHTARGET;
			finderArgs = new Object[] { name, targetLanguage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEWITHTARGET;
			finderArgs = new Object[] {
					name, targetLanguage,
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!Validator.equals(name, scienceApp.getName()) ||
						!Validator.equals(targetLanguage,
							scienceApp.getTargetLanguage())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEWITHTARGET_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEWITHTARGET_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEWITHTARGET_NAME_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_NAMEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_NAMEWITHTARGET_TARGETLANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where name = &#63; and targetLanguage = &#63;.
	 *
	 * @param name the name
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByNameWithTarget_First(String name,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByNameWithTarget_First(name,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where name = &#63; and targetLanguage = &#63;.
	 *
	 * @param name the name
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByNameWithTarget_First(String name,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceApp> list = findByNameWithTarget(name, targetLanguage, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where name = &#63; and targetLanguage = &#63;.
	 *
	 * @param name the name
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByNameWithTarget_Last(String name,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByNameWithTarget_Last(name,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where name = &#63; and targetLanguage = &#63;.
	 *
	 * @param name the name
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByNameWithTarget_Last(String name,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByNameWithTarget(name, targetLanguage);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByNameWithTarget(name, targetLanguage,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where name = &#63; and targetLanguage = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param name the name
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByNameWithTarget_PrevAndNext(long scienceAppId,
		String name, String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByNameWithTarget_PrevAndNext(session, scienceApp,
					name, targetLanguage, orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByNameWithTarget_PrevAndNext(session, scienceApp,
					name, targetLanguage, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceApp getByNameWithTarget_PrevAndNext(Session session,
		ScienceApp scienceApp, String name, String targetLanguage,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAMEWITHTARGET_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAMEWITHTARGET_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAMEWITHTARGET_NAME_2);
		}

		boolean bindTargetLanguage = false;

		if (targetLanguage == null) {
			query.append(_FINDER_COLUMN_NAMEWITHTARGET_TARGETLANGUAGE_1);
		}
		else if (targetLanguage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAMEWITHTARGET_TARGETLANGUAGE_3);
		}
		else {
			bindTargetLanguage = true;

			query.append(_FINDER_COLUMN_NAMEWITHTARGET_TARGETLANGUAGE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (bindTargetLanguage) {
			qPos.add(targetLanguage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where name = &#63; and targetLanguage = &#63; from the database.
	 *
	 * @param name the name
	 * @param targetLanguage the target language
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNameWithTarget(String name, String targetLanguage)
		throws SystemException {
		for (ScienceApp scienceApp : findByNameWithTarget(name, targetLanguage,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where name = &#63; and targetLanguage = &#63;.
	 *
	 * @param name the name
	 * @param targetLanguage the target language
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNameWithTarget(String name, String targetLanguage)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMEWITHTARGET;

		Object[] finderArgs = new Object[] { name, targetLanguage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEWITHTARGET_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEWITHTARGET_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEWITHTARGET_NAME_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_NAMEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_NAMEWITHTARGET_TARGETLANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

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

	private static final String _FINDER_COLUMN_NAMEWITHTARGET_NAME_1 = "scienceApp.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEWITHTARGET_NAME_2 = "scienceApp.name = ? AND ";
	private static final String _FINDER_COLUMN_NAMEWITHTARGET_NAME_3 = "(scienceApp.name IS NULL OR scienceApp.name = '') AND ";
	private static final String _FINDER_COLUMN_NAMEWITHTARGET_TARGETLANGUAGE_1 = "scienceApp.targetLanguage IS NULL";
	private static final String _FINDER_COLUMN_NAMEWITHTARGET_TARGETLANGUAGE_2 = "scienceApp.targetLanguage = ?";
	private static final String _FINDER_COLUMN_NAMEWITHTARGET_TARGETLANGUAGE_3 = "(scienceApp.targetLanguage IS NULL OR scienceApp.targetLanguage = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPTYPEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppTypeWithTarget",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPTYPEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAppTypeWithTarget",
			new String[] { String.class.getName(), String.class.getName() },
			ScienceAppModelImpl.APPTYPE_COLUMN_BITMASK |
			ScienceAppModelImpl.TARGETLANGUAGE_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPTYPEWITHTARGET = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAppTypeWithTarget",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the science apps where appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAppTypeWithTarget(String appType,
		String targetLanguage) throws SystemException {
		return findByAppTypeWithTarget(appType, targetLanguage,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where appType = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAppTypeWithTarget(String appType,
		String targetLanguage, int start, int end) throws SystemException {
		return findByAppTypeWithTarget(appType, targetLanguage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where appType = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAppTypeWithTarget(String appType,
		String targetLanguage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPTYPEWITHTARGET;
			finderArgs = new Object[] { appType, targetLanguage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPTYPEWITHTARGET;
			finderArgs = new Object[] {
					appType, targetLanguage,
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!Validator.equals(appType, scienceApp.getAppType()) ||
						!Validator.equals(targetLanguage,
							scienceApp.getTargetLanguage())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindAppType = false;

			if (appType == null) {
				query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_APPTYPE_1);
			}
			else if (appType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_APPTYPE_3);
			}
			else {
				bindAppType = true;

				query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_APPTYPE_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_TARGETLANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppType) {
					qPos.add(appType);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAppTypeWithTarget_First(String appType,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAppTypeWithTarget_First(appType,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appType=");
		msg.append(appType);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAppTypeWithTarget_First(String appType,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceApp> list = findByAppTypeWithTarget(appType,
				targetLanguage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAppTypeWithTarget_Last(String appType,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAppTypeWithTarget_Last(appType,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appType=");
		msg.append(appType);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAppTypeWithTarget_Last(String appType,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAppTypeWithTarget(appType, targetLanguage);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByAppTypeWithTarget(appType,
				targetLanguage, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByAppTypeWithTarget_PrevAndNext(long scienceAppId,
		String appType, String targetLanguage,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByAppTypeWithTarget_PrevAndNext(session, scienceApp,
					appType, targetLanguage, orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByAppTypeWithTarget_PrevAndNext(session, scienceApp,
					appType, targetLanguage, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceApp getByAppTypeWithTarget_PrevAndNext(Session session,
		ScienceApp scienceApp, String appType, String targetLanguage,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindAppType = false;

		if (appType == null) {
			query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_APPTYPE_1);
		}
		else if (appType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_APPTYPE_3);
		}
		else {
			bindAppType = true;

			query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_APPTYPE_2);
		}

		boolean bindTargetLanguage = false;

		if (targetLanguage == null) {
			query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_TARGETLANGUAGE_1);
		}
		else if (targetLanguage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_TARGETLANGUAGE_3);
		}
		else {
			bindTargetLanguage = true;

			query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_TARGETLANGUAGE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAppType) {
			qPos.add(appType);
		}

		if (bindTargetLanguage) {
			qPos.add(targetLanguage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where appType = &#63; and targetLanguage = &#63; from the database.
	 *
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAppTypeWithTarget(String appType, String targetLanguage)
		throws SystemException {
		for (ScienceApp scienceApp : findByAppTypeWithTarget(appType,
				targetLanguage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAppTypeWithTarget(String appType, String targetLanguage)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPTYPEWITHTARGET;

		Object[] finderArgs = new Object[] { appType, targetLanguage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindAppType = false;

			if (appType == null) {
				query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_APPTYPE_1);
			}
			else if (appType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_APPTYPE_3);
			}
			else {
				bindAppType = true;

				query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_APPTYPE_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_APPTYPEWITHTARGET_TARGETLANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppType) {
					qPos.add(appType);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

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

	private static final String _FINDER_COLUMN_APPTYPEWITHTARGET_APPTYPE_1 = "scienceApp.appType IS NULL AND ";
	private static final String _FINDER_COLUMN_APPTYPEWITHTARGET_APPTYPE_2 = "scienceApp.appType = ? AND ";
	private static final String _FINDER_COLUMN_APPTYPEWITHTARGET_APPTYPE_3 = "(scienceApp.appType IS NULL OR scienceApp.appType = '') AND ";
	private static final String _FINDER_COLUMN_APPTYPEWITHTARGET_TARGETLANGUAGE_1 =
		"scienceApp.targetLanguage IS NULL";
	private static final String _FINDER_COLUMN_APPTYPEWITHTARGET_TARGETLANGUAGE_2 =
		"scienceApp.targetLanguage = ?";
	private static final String _FINDER_COLUMN_APPTYPEWITHTARGET_TARGETLANGUAGE_3 =
		"(scienceApp.targetLanguage IS NULL OR scienceApp.targetLanguage = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPRUNTYPEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAppRunTypeWithTarget",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRUNTYPEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAppRunTypeWithTarget",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			ScienceAppModelImpl.APPTYPE_COLUMN_BITMASK |
			ScienceAppModelImpl.RUNTYPE_COLUMN_BITMASK |
			ScienceAppModelImpl.TARGETLANGUAGE_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPRUNTYPEWITHTARGET = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAppRunTypeWithTarget",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the science apps where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param targetLanguage the target language
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAppRunTypeWithTarget(String appType,
		String runType, String targetLanguage) throws SystemException {
		return findByAppRunTypeWithTarget(appType, runType, targetLanguage,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAppRunTypeWithTarget(String appType,
		String runType, String targetLanguage, int start, int end)
		throws SystemException {
		return findByAppRunTypeWithTarget(appType, runType, targetLanguage,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAppRunTypeWithTarget(String appType,
		String runType, String targetLanguage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRUNTYPEWITHTARGET;
			finderArgs = new Object[] { appType, runType, targetLanguage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_APPRUNTYPEWITHTARGET;
			finderArgs = new Object[] {
					appType, runType, targetLanguage,
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!Validator.equals(appType, scienceApp.getAppType()) ||
						!Validator.equals(runType, scienceApp.getRunType()) ||
						!Validator.equals(targetLanguage,
							scienceApp.getTargetLanguage())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindAppType = false;

			if (appType == null) {
				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_APPTYPE_1);
			}
			else if (appType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_APPTYPE_3);
			}
			else {
				bindAppType = true;

				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_APPTYPE_2);
			}

			boolean bindRunType = false;

			if (runType == null) {
				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_RUNTYPE_1);
			}
			else if (runType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_RUNTYPE_3);
			}
			else {
				bindRunType = true;

				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_RUNTYPE_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_TARGETLANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppType) {
					qPos.add(appType);
				}

				if (bindRunType) {
					qPos.add(runType);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAppRunTypeWithTarget_First(String appType,
		String runType, String targetLanguage,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAppRunTypeWithTarget_First(appType,
				runType, targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appType=");
		msg.append(appType);

		msg.append(", runType=");
		msg.append(runType);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAppRunTypeWithTarget_First(String appType,
		String runType, String targetLanguage,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceApp> list = findByAppRunTypeWithTarget(appType, runType,
				targetLanguage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAppRunTypeWithTarget_Last(String appType,
		String runType, String targetLanguage,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAppRunTypeWithTarget_Last(appType,
				runType, targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appType=");
		msg.append(appType);

		msg.append(", runType=");
		msg.append(runType);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAppRunTypeWithTarget_Last(String appType,
		String runType, String targetLanguage,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAppRunTypeWithTarget(appType, runType, targetLanguage);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByAppRunTypeWithTarget(appType, runType,
				targetLanguage, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param appType the app type
	 * @param runType the run type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByAppRunTypeWithTarget_PrevAndNext(
		long scienceAppId, String appType, String runType,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByAppRunTypeWithTarget_PrevAndNext(session,
					scienceApp, appType, runType, targetLanguage,
					orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByAppRunTypeWithTarget_PrevAndNext(session,
					scienceApp, appType, runType, targetLanguage,
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

	protected ScienceApp getByAppRunTypeWithTarget_PrevAndNext(
		Session session, ScienceApp scienceApp, String appType, String runType,
		String targetLanguage, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindAppType = false;

		if (appType == null) {
			query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_APPTYPE_1);
		}
		else if (appType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_APPTYPE_3);
		}
		else {
			bindAppType = true;

			query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_APPTYPE_2);
		}

		boolean bindRunType = false;

		if (runType == null) {
			query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_RUNTYPE_1);
		}
		else if (runType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_RUNTYPE_3);
		}
		else {
			bindRunType = true;

			query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_RUNTYPE_2);
		}

		boolean bindTargetLanguage = false;

		if (targetLanguage == null) {
			query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_TARGETLANGUAGE_1);
		}
		else if (targetLanguage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_TARGETLANGUAGE_3);
		}
		else {
			bindTargetLanguage = true;

			query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_TARGETLANGUAGE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAppType) {
			qPos.add(appType);
		}

		if (bindRunType) {
			qPos.add(runType);
		}

		if (bindTargetLanguage) {
			qPos.add(targetLanguage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where appType = &#63; and runType = &#63; and targetLanguage = &#63; from the database.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param targetLanguage the target language
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAppRunTypeWithTarget(String appType, String runType,
		String targetLanguage) throws SystemException {
		for (ScienceApp scienceApp : findByAppRunTypeWithTarget(appType,
				runType, targetLanguage, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where appType = &#63; and runType = &#63; and targetLanguage = &#63;.
	 *
	 * @param appType the app type
	 * @param runType the run type
	 * @param targetLanguage the target language
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAppRunTypeWithTarget(String appType, String runType,
		String targetLanguage) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_APPRUNTYPEWITHTARGET;

		Object[] finderArgs = new Object[] { appType, runType, targetLanguage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindAppType = false;

			if (appType == null) {
				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_APPTYPE_1);
			}
			else if (appType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_APPTYPE_3);
			}
			else {
				bindAppType = true;

				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_APPTYPE_2);
			}

			boolean bindRunType = false;

			if (runType == null) {
				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_RUNTYPE_1);
			}
			else if (runType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_RUNTYPE_3);
			}
			else {
				bindRunType = true;

				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_RUNTYPE_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_APPRUNTYPEWITHTARGET_TARGETLANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAppType) {
					qPos.add(appType);
				}

				if (bindRunType) {
					qPos.add(runType);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

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

	private static final String _FINDER_COLUMN_APPRUNTYPEWITHTARGET_APPTYPE_1 = "scienceApp.appType IS NULL AND ";
	private static final String _FINDER_COLUMN_APPRUNTYPEWITHTARGET_APPTYPE_2 = "scienceApp.appType = ? AND ";
	private static final String _FINDER_COLUMN_APPRUNTYPEWITHTARGET_APPTYPE_3 = "(scienceApp.appType IS NULL OR scienceApp.appType = '') AND ";
	private static final String _FINDER_COLUMN_APPRUNTYPEWITHTARGET_RUNTYPE_1 = "scienceApp.runType IS NULL AND ";
	private static final String _FINDER_COLUMN_APPRUNTYPEWITHTARGET_RUNTYPE_2 = "scienceApp.runType = ? AND ";
	private static final String _FINDER_COLUMN_APPRUNTYPEWITHTARGET_RUNTYPE_3 = "(scienceApp.runType IS NULL OR scienceApp.runType = '') AND ";
	private static final String _FINDER_COLUMN_APPRUNTYPEWITHTARGET_TARGETLANGUAGE_1 =
		"scienceApp.targetLanguage IS NULL";
	private static final String _FINDER_COLUMN_APPRUNTYPEWITHTARGET_TARGETLANGUAGE_2 =
		"scienceApp.targetLanguage = ?";
	private static final String _FINDER_COLUMN_APPRUNTYPEWITHTARGET_TARGETLANGUAGE_3 =
		"(scienceApp.targetLanguage IS NULL OR scienceApp.targetLanguage = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORIDWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuthorIdWithTarget",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAuthorIdWithTarget",
			new String[] { Long.class.getName(), String.class.getName() },
			ScienceAppModelImpl.AUTHORID_COLUMN_BITMASK |
			ScienceAppModelImpl.TARGETLANGUAGE_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHORIDWITHTARGET = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAuthorIdWithTarget",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the science apps where authorId = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param targetLanguage the target language
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdWithTarget(long authorId,
		String targetLanguage) throws SystemException {
		return findByAuthorIdWithTarget(authorId, targetLanguage,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where authorId = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdWithTarget(long authorId,
		String targetLanguage, int start, int end) throws SystemException {
		return findByAuthorIdWithTarget(authorId, targetLanguage, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the science apps where authorId = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdWithTarget(long authorId,
		String targetLanguage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDWITHTARGET;
			finderArgs = new Object[] { authorId, targetLanguage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORIDWITHTARGET;
			finderArgs = new Object[] {
					authorId, targetLanguage,
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if ((authorId != scienceApp.getAuthorId()) ||
						!Validator.equals(targetLanguage,
							scienceApp.getTargetLanguage())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_AUTHORIDWITHTARGET_AUTHORID_2);

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_AUTHORIDWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORIDWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_AUTHORIDWITHTARGET_TARGETLANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where authorId = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAuthorIdWithTarget_First(long authorId,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAuthorIdWithTarget_First(authorId,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where authorId = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAuthorIdWithTarget_First(long authorId,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceApp> list = findByAuthorIdWithTarget(authorId,
				targetLanguage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where authorId = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAuthorIdWithTarget_Last(long authorId,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAuthorIdWithTarget_Last(authorId,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where authorId = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAuthorIdWithTarget_Last(long authorId,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAuthorIdWithTarget(authorId, targetLanguage);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByAuthorIdWithTarget(authorId,
				targetLanguage, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where authorId = &#63; and targetLanguage = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param authorId the author ID
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByAuthorIdWithTarget_PrevAndNext(
		long scienceAppId, long authorId, String targetLanguage,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByAuthorIdWithTarget_PrevAndNext(session, scienceApp,
					authorId, targetLanguage, orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByAuthorIdWithTarget_PrevAndNext(session, scienceApp,
					authorId, targetLanguage, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceApp getByAuthorIdWithTarget_PrevAndNext(Session session,
		ScienceApp scienceApp, long authorId, String targetLanguage,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		query.append(_FINDER_COLUMN_AUTHORIDWITHTARGET_AUTHORID_2);

		boolean bindTargetLanguage = false;

		if (targetLanguage == null) {
			query.append(_FINDER_COLUMN_AUTHORIDWITHTARGET_TARGETLANGUAGE_1);
		}
		else if (targetLanguage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_AUTHORIDWITHTARGET_TARGETLANGUAGE_3);
		}
		else {
			bindTargetLanguage = true;

			query.append(_FINDER_COLUMN_AUTHORIDWITHTARGET_TARGETLANGUAGE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(authorId);

		if (bindTargetLanguage) {
			qPos.add(targetLanguage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where authorId = &#63; and targetLanguage = &#63; from the database.
	 *
	 * @param authorId the author ID
	 * @param targetLanguage the target language
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAuthorIdWithTarget(long authorId, String targetLanguage)
		throws SystemException {
		for (ScienceApp scienceApp : findByAuthorIdWithTarget(authorId,
				targetLanguage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where authorId = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param targetLanguage the target language
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAuthorIdWithTarget(long authorId, String targetLanguage)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHORIDWITHTARGET;

		Object[] finderArgs = new Object[] { authorId, targetLanguage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_AUTHORIDWITHTARGET_AUTHORID_2);

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_AUTHORIDWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORIDWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_AUTHORIDWITHTARGET_TARGETLANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

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

	private static final String _FINDER_COLUMN_AUTHORIDWITHTARGET_AUTHORID_2 = "scienceApp.authorId = ? AND ";
	private static final String _FINDER_COLUMN_AUTHORIDWITHTARGET_TARGETLANGUAGE_1 =
		"scienceApp.targetLanguage IS NULL";
	private static final String _FINDER_COLUMN_AUTHORIDWITHTARGET_TARGETLANGUAGE_2 =
		"scienceApp.targetLanguage = ?";
	private static final String _FINDER_COLUMN_AUTHORIDWITHTARGET_TARGETLANGUAGE_3 =
		"(scienceApp.targetLanguage IS NULL OR scienceApp.targetLanguage = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STAGEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStageWithTarget",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAGEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStageWithTarget",
			new String[] { String.class.getName(), String.class.getName() },
			ScienceAppModelImpl.STAGE_COLUMN_BITMASK |
			ScienceAppModelImpl.TARGETLANGUAGE_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STAGEWITHTARGET = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStageWithTarget",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the science apps where stage = &#63; and targetLanguage = &#63;.
	 *
	 * @param stage the stage
	 * @param targetLanguage the target language
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByStageWithTarget(String stage,
		String targetLanguage) throws SystemException {
		return findByStageWithTarget(stage, targetLanguage, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where stage = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stage the stage
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByStageWithTarget(String stage,
		String targetLanguage, int start, int end) throws SystemException {
		return findByStageWithTarget(stage, targetLanguage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where stage = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stage the stage
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByStageWithTarget(String stage,
		String targetLanguage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAGEWITHTARGET;
			finderArgs = new Object[] { stage, targetLanguage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STAGEWITHTARGET;
			finderArgs = new Object[] {
					stage, targetLanguage,
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!Validator.equals(stage, scienceApp.getStage()) ||
						!Validator.equals(targetLanguage,
							scienceApp.getTargetLanguage())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindStage = false;

			if (stage == null) {
				query.append(_FINDER_COLUMN_STAGEWITHTARGET_STAGE_1);
			}
			else if (stage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STAGEWITHTARGET_STAGE_3);
			}
			else {
				bindStage = true;

				query.append(_FINDER_COLUMN_STAGEWITHTARGET_STAGE_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_STAGEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STAGEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_STAGEWITHTARGET_TARGETLANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStage) {
					qPos.add(stage);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where stage = &#63; and targetLanguage = &#63;.
	 *
	 * @param stage the stage
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByStageWithTarget_First(String stage,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByStageWithTarget_First(stage,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stage=");
		msg.append(stage);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where stage = &#63; and targetLanguage = &#63;.
	 *
	 * @param stage the stage
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByStageWithTarget_First(String stage,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceApp> list = findByStageWithTarget(stage, targetLanguage, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where stage = &#63; and targetLanguage = &#63;.
	 *
	 * @param stage the stage
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByStageWithTarget_Last(String stage,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByStageWithTarget_Last(stage,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stage=");
		msg.append(stage);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where stage = &#63; and targetLanguage = &#63;.
	 *
	 * @param stage the stage
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByStageWithTarget_Last(String stage,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStageWithTarget(stage, targetLanguage);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByStageWithTarget(stage, targetLanguage,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where stage = &#63; and targetLanguage = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param stage the stage
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByStageWithTarget_PrevAndNext(long scienceAppId,
		String stage, String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByStageWithTarget_PrevAndNext(session, scienceApp,
					stage, targetLanguage, orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByStageWithTarget_PrevAndNext(session, scienceApp,
					stage, targetLanguage, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceApp getByStageWithTarget_PrevAndNext(Session session,
		ScienceApp scienceApp, String stage, String targetLanguage,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindStage = false;

		if (stage == null) {
			query.append(_FINDER_COLUMN_STAGEWITHTARGET_STAGE_1);
		}
		else if (stage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STAGEWITHTARGET_STAGE_3);
		}
		else {
			bindStage = true;

			query.append(_FINDER_COLUMN_STAGEWITHTARGET_STAGE_2);
		}

		boolean bindTargetLanguage = false;

		if (targetLanguage == null) {
			query.append(_FINDER_COLUMN_STAGEWITHTARGET_TARGETLANGUAGE_1);
		}
		else if (targetLanguage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STAGEWITHTARGET_TARGETLANGUAGE_3);
		}
		else {
			bindTargetLanguage = true;

			query.append(_FINDER_COLUMN_STAGEWITHTARGET_TARGETLANGUAGE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStage) {
			qPos.add(stage);
		}

		if (bindTargetLanguage) {
			qPos.add(targetLanguage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where stage = &#63; and targetLanguage = &#63; from the database.
	 *
	 * @param stage the stage
	 * @param targetLanguage the target language
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStageWithTarget(String stage, String targetLanguage)
		throws SystemException {
		for (ScienceApp scienceApp : findByStageWithTarget(stage,
				targetLanguage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where stage = &#63; and targetLanguage = &#63;.
	 *
	 * @param stage the stage
	 * @param targetLanguage the target language
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStageWithTarget(String stage, String targetLanguage)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STAGEWITHTARGET;

		Object[] finderArgs = new Object[] { stage, targetLanguage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindStage = false;

			if (stage == null) {
				query.append(_FINDER_COLUMN_STAGEWITHTARGET_STAGE_1);
			}
			else if (stage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STAGEWITHTARGET_STAGE_3);
			}
			else {
				bindStage = true;

				query.append(_FINDER_COLUMN_STAGEWITHTARGET_STAGE_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_STAGEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STAGEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_STAGEWITHTARGET_TARGETLANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStage) {
					qPos.add(stage);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

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

	private static final String _FINDER_COLUMN_STAGEWITHTARGET_STAGE_1 = "scienceApp.stage IS NULL AND ";
	private static final String _FINDER_COLUMN_STAGEWITHTARGET_STAGE_2 = "scienceApp.stage = ? AND ";
	private static final String _FINDER_COLUMN_STAGEWITHTARGET_STAGE_3 = "(scienceApp.stage IS NULL OR scienceApp.stage = '') AND ";
	private static final String _FINDER_COLUMN_STAGEWITHTARGET_TARGETLANGUAGE_1 = "scienceApp.targetLanguage IS NULL";
	private static final String _FINDER_COLUMN_STAGEWITHTARGET_TARGETLANGUAGE_2 = "scienceApp.targetLanguage = ?";
	private static final String _FINDER_COLUMN_STAGEWITHTARGET_TARGETLANGUAGE_3 = "(scienceApp.targetLanguage IS NULL OR scienceApp.targetLanguage = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusWithTarget",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStatusWithTarget",
			new String[] { Integer.class.getName(), String.class.getName() },
			ScienceAppModelImpl.STATUS_COLUMN_BITMASK |
			ScienceAppModelImpl.TARGETLANGUAGE_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSWITHTARGET = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusWithTarget",
			new String[] { Integer.class.getName(), String.class.getName() });

	/**
	 * Returns all the science apps where status = &#63; and targetLanguage = &#63;.
	 *
	 * @param status the status
	 * @param targetLanguage the target language
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByStatusWithTarget(int status,
		String targetLanguage) throws SystemException {
		return findByStatusWithTarget(status, targetLanguage,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where status = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByStatusWithTarget(int status,
		String targetLanguage, int start, int end) throws SystemException {
		return findByStatusWithTarget(status, targetLanguage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where status = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByStatusWithTarget(int status,
		String targetLanguage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSWITHTARGET;
			finderArgs = new Object[] { status, targetLanguage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSWITHTARGET;
			finderArgs = new Object[] {
					status, targetLanguage,
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if ((status != scienceApp.getStatus()) ||
						!Validator.equals(targetLanguage,
							scienceApp.getTargetLanguage())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_STATUSWITHTARGET_STATUS_2);

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_STATUSWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUSWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_STATUSWITHTARGET_TARGETLANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where status = &#63; and targetLanguage = &#63;.
	 *
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByStatusWithTarget_First(int status,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByStatusWithTarget_First(status,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where status = &#63; and targetLanguage = &#63;.
	 *
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByStatusWithTarget_First(int status,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceApp> list = findByStatusWithTarget(status, targetLanguage,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where status = &#63; and targetLanguage = &#63;.
	 *
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByStatusWithTarget_Last(int status,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByStatusWithTarget_Last(status,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where status = &#63; and targetLanguage = &#63;.
	 *
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByStatusWithTarget_Last(int status,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStatusWithTarget(status, targetLanguage);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByStatusWithTarget(status, targetLanguage,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where status = &#63; and targetLanguage = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByStatusWithTarget_PrevAndNext(long scienceAppId,
		int status, String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByStatusWithTarget_PrevAndNext(session, scienceApp,
					status, targetLanguage, orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByStatusWithTarget_PrevAndNext(session, scienceApp,
					status, targetLanguage, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceApp getByStatusWithTarget_PrevAndNext(Session session,
		ScienceApp scienceApp, int status, String targetLanguage,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		query.append(_FINDER_COLUMN_STATUSWITHTARGET_STATUS_2);

		boolean bindTargetLanguage = false;

		if (targetLanguage == null) {
			query.append(_FINDER_COLUMN_STATUSWITHTARGET_TARGETLANGUAGE_1);
		}
		else if (targetLanguage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUSWITHTARGET_TARGETLANGUAGE_3);
		}
		else {
			bindTargetLanguage = true;

			query.append(_FINDER_COLUMN_STATUSWITHTARGET_TARGETLANGUAGE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (bindTargetLanguage) {
			qPos.add(targetLanguage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where status = &#63; and targetLanguage = &#63; from the database.
	 *
	 * @param status the status
	 * @param targetLanguage the target language
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatusWithTarget(int status, String targetLanguage)
		throws SystemException {
		for (ScienceApp scienceApp : findByStatusWithTarget(status,
				targetLanguage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where status = &#63; and targetLanguage = &#63;.
	 *
	 * @param status the status
	 * @param targetLanguage the target language
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatusWithTarget(int status, String targetLanguage)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUSWITHTARGET;

		Object[] finderArgs = new Object[] { status, targetLanguage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_STATUSWITHTARGET_STATUS_2);

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_STATUSWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUSWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_STATUSWITHTARGET_TARGETLANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

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

	private static final String _FINDER_COLUMN_STATUSWITHTARGET_STATUS_2 = "scienceApp.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUSWITHTARGET_TARGETLANGUAGE_1 =
		"scienceApp.targetLanguage IS NULL";
	private static final String _FINDER_COLUMN_STATUSWITHTARGET_TARGETLANGUAGE_2 =
		"scienceApp.targetLanguage = ?";
	private static final String _FINDER_COLUMN_STATUSWITHTARGET_TARGETLANGUAGE_3 =
		"(scienceApp.targetLanguage IS NULL OR scienceApp.targetLanguage = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitleWithTarget",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTitleWithTarget",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the science apps where title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param title the title
	 * @param targetLanguage the target language
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByTitleWithTarget(String title,
		String targetLanguage) throws SystemException {
		return findByTitleWithTarget(title, targetLanguage, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByTitleWithTarget(String title,
		String targetLanguage, int start, int end) throws SystemException {
		return findByTitleWithTarget(title, targetLanguage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByTitleWithTarget(String title,
		String targetLanguage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLEWITHTARGET;
		finderArgs = new Object[] {
				title, targetLanguage,
				
				start, end, orderByComparator
			};

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!StringUtil.wildcardMatches(scienceApp.getTitle(), title,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						!Validator.equals(targetLanguage,
							scienceApp.getTargetLanguage())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLEWITHTARGET_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLEWITHTARGET_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLEWITHTARGET_TITLE_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_TITLEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_TITLEWITHTARGET_TARGETLANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByTitleWithTarget_First(String title,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByTitleWithTarget_First(title,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByTitleWithTarget_First(String title,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceApp> list = findByTitleWithTarget(title, targetLanguage, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByTitleWithTarget_Last(String title,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByTitleWithTarget_Last(title,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByTitleWithTarget_Last(String title,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTitleWithTarget(title, targetLanguage);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByTitleWithTarget(title, targetLanguage,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByTitleWithTarget_PrevAndNext(long scienceAppId,
		String title, String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByTitleWithTarget_PrevAndNext(session, scienceApp,
					title, targetLanguage, orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByTitleWithTarget_PrevAndNext(session, scienceApp,
					title, targetLanguage, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceApp getByTitleWithTarget_PrevAndNext(Session session,
		ScienceApp scienceApp, String title, String targetLanguage,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindTitle = false;

		if (title == null) {
			query.append(_FINDER_COLUMN_TITLEWITHTARGET_TITLE_1);
		}
		else if (title.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TITLEWITHTARGET_TITLE_3);
		}
		else {
			bindTitle = true;

			query.append(_FINDER_COLUMN_TITLEWITHTARGET_TITLE_2);
		}

		boolean bindTargetLanguage = false;

		if (targetLanguage == null) {
			query.append(_FINDER_COLUMN_TITLEWITHTARGET_TARGETLANGUAGE_1);
		}
		else if (targetLanguage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TITLEWITHTARGET_TARGETLANGUAGE_3);
		}
		else {
			bindTargetLanguage = true;

			query.append(_FINDER_COLUMN_TITLEWITHTARGET_TARGETLANGUAGE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTitle) {
			qPos.add(title);
		}

		if (bindTargetLanguage) {
			qPos.add(targetLanguage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where title LIKE &#63; and targetLanguage = &#63; from the database.
	 *
	 * @param title the title
	 * @param targetLanguage the target language
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitleWithTarget(String title, String targetLanguage)
		throws SystemException {
		for (ScienceApp scienceApp : findByTitleWithTarget(title,
				targetLanguage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param title the title
	 * @param targetLanguage the target language
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTitleWithTarget(String title, String targetLanguage)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLEWITHTARGET;

		Object[] finderArgs = new Object[] { title, targetLanguage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLEWITHTARGET_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLEWITHTARGET_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_TITLEWITHTARGET_TITLE_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_TITLEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_TITLEWITHTARGET_TARGETLANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTitle) {
					qPos.add(title);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

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

	private static final String _FINDER_COLUMN_TITLEWITHTARGET_TITLE_1 = "scienceApp.title LIKE NULL AND ";
	private static final String _FINDER_COLUMN_TITLEWITHTARGET_TITLE_2 = "scienceApp.title LIKE ? AND ";
	private static final String _FINDER_COLUMN_TITLEWITHTARGET_TITLE_3 = "(scienceApp.title IS NULL OR scienceApp.title LIKE '') AND ";
	private static final String _FINDER_COLUMN_TITLEWITHTARGET_TARGETLANGUAGE_1 = "scienceApp.targetLanguage IS NULL";
	private static final String _FINDER_COLUMN_TITLEWITHTARGET_TARGETLANGUAGE_2 = "scienceApp.targetLanguage = ?";
	private static final String _FINDER_COLUMN_TITLEWITHTARGET_TARGETLANGUAGE_3 = "(scienceApp.targetLanguage IS NULL OR scienceApp.targetLanguage = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORIDAPPTYPEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAuthorIdAppTypeWithTarget",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDAPPTYPEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAuthorIdAppTypeWithTarget",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			ScienceAppModelImpl.AUTHORID_COLUMN_BITMASK |
			ScienceAppModelImpl.APPTYPE_COLUMN_BITMASK |
			ScienceAppModelImpl.TARGETLANGUAGE_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHORIDAPPTYPEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAuthorIdAppTypeWithTarget",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the science apps where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdAppTypeWithTarget(long authorId,
		String appType, String targetLanguage) throws SystemException {
		return findByAuthorIdAppTypeWithTarget(authorId, appType,
			targetLanguage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdAppTypeWithTarget(long authorId,
		String appType, String targetLanguage, int start, int end)
		throws SystemException {
		return findByAuthorIdAppTypeWithTarget(authorId, appType,
			targetLanguage, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdAppTypeWithTarget(long authorId,
		String appType, String targetLanguage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDAPPTYPEWITHTARGET;
			finderArgs = new Object[] { authorId, appType, targetLanguage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORIDAPPTYPEWITHTARGET;
			finderArgs = new Object[] {
					authorId, appType, targetLanguage,
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if ((authorId != scienceApp.getAuthorId()) ||
						!Validator.equals(appType, scienceApp.getAppType()) ||
						!Validator.equals(targetLanguage,
							scienceApp.getTargetLanguage())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_AUTHORID_2);

			boolean bindAppType = false;

			if (appType == null) {
				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_APPTYPE_1);
			}
			else if (appType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_APPTYPE_3);
			}
			else {
				bindAppType = true;

				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_APPTYPE_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_TARGETLANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				if (bindAppType) {
					qPos.add(appType);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAuthorIdAppTypeWithTarget_First(long authorId,
		String appType, String targetLanguage,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAuthorIdAppTypeWithTarget_First(authorId,
				appType, targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(", appType=");
		msg.append(appType);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAuthorIdAppTypeWithTarget_First(long authorId,
		String appType, String targetLanguage,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceApp> list = findByAuthorIdAppTypeWithTarget(authorId,
				appType, targetLanguage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAuthorIdAppTypeWithTarget_Last(long authorId,
		String appType, String targetLanguage,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAuthorIdAppTypeWithTarget_Last(authorId,
				appType, targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(", appType=");
		msg.append(appType);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAuthorIdAppTypeWithTarget_Last(long authorId,
		String appType, String targetLanguage,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAuthorIdAppTypeWithTarget(authorId, appType,
				targetLanguage);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByAuthorIdAppTypeWithTarget(authorId,
				appType, targetLanguage, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByAuthorIdAppTypeWithTarget_PrevAndNext(
		long scienceAppId, long authorId, String appType,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByAuthorIdAppTypeWithTarget_PrevAndNext(session,
					scienceApp, authorId, appType, targetLanguage,
					orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByAuthorIdAppTypeWithTarget_PrevAndNext(session,
					scienceApp, authorId, appType, targetLanguage,
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

	protected ScienceApp getByAuthorIdAppTypeWithTarget_PrevAndNext(
		Session session, ScienceApp scienceApp, long authorId, String appType,
		String targetLanguage, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_AUTHORID_2);

		boolean bindAppType = false;

		if (appType == null) {
			query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_APPTYPE_1);
		}
		else if (appType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_APPTYPE_3);
		}
		else {
			bindAppType = true;

			query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_APPTYPE_2);
		}

		boolean bindTargetLanguage = false;

		if (targetLanguage == null) {
			query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_TARGETLANGUAGE_1);
		}
		else if (targetLanguage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_TARGETLANGUAGE_3);
		}
		else {
			bindTargetLanguage = true;

			query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_TARGETLANGUAGE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(authorId);

		if (bindAppType) {
			qPos.add(appType);
		}

		if (bindTargetLanguage) {
			qPos.add(targetLanguage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where authorId = &#63; and appType = &#63; and targetLanguage = &#63; from the database.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAuthorIdAppTypeWithTarget(long authorId,
		String appType, String targetLanguage) throws SystemException {
		for (ScienceApp scienceApp : findByAuthorIdAppTypeWithTarget(authorId,
				appType, targetLanguage, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where authorId = &#63; and appType = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param appType the app type
	 * @param targetLanguage the target language
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAuthorIdAppTypeWithTarget(long authorId, String appType,
		String targetLanguage) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHORIDAPPTYPEWITHTARGET;

		Object[] finderArgs = new Object[] { authorId, appType, targetLanguage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_AUTHORID_2);

			boolean bindAppType = false;

			if (appType == null) {
				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_APPTYPE_1);
			}
			else if (appType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_APPTYPE_3);
			}
			else {
				bindAppType = true;

				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_APPTYPE_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_TARGETLANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				if (bindAppType) {
					qPos.add(appType);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

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

	private static final String _FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_AUTHORID_2 =
		"scienceApp.authorId = ? AND ";
	private static final String _FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_APPTYPE_1 =
		"scienceApp.appType IS NULL AND ";
	private static final String _FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_APPTYPE_2 =
		"scienceApp.appType = ? AND ";
	private static final String _FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_APPTYPE_3 =
		"(scienceApp.appType IS NULL OR scienceApp.appType = '') AND ";
	private static final String _FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_TARGETLANGUAGE_1 =
		"scienceApp.targetLanguage IS NULL";
	private static final String _FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_TARGETLANGUAGE_2 =
		"scienceApp.targetLanguage = ?";
	private static final String _FINDER_COLUMN_AUTHORIDAPPTYPEWITHTARGET_TARGETLANGUAGE_3 =
		"(scienceApp.targetLanguage IS NULL OR scienceApp.targetLanguage = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORIDSTATUSWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAuthorIdStatusWithTarget",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDSTATUSWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAuthorIdStatusWithTarget",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			},
			ScienceAppModelImpl.AUTHORID_COLUMN_BITMASK |
			ScienceAppModelImpl.STATUS_COLUMN_BITMASK |
			ScienceAppModelImpl.TARGETLANGUAGE_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHORIDSTATUSWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAuthorIdStatusWithTarget",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the science apps where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param targetLanguage the target language
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdStatusWithTarget(long authorId,
		int status, String targetLanguage) throws SystemException {
		return findByAuthorIdStatusWithTarget(authorId, status, targetLanguage,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdStatusWithTarget(long authorId,
		int status, String targetLanguage, int start, int end)
		throws SystemException {
		return findByAuthorIdStatusWithTarget(authorId, status, targetLanguage,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByAuthorIdStatusWithTarget(long authorId,
		int status, String targetLanguage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDSTATUSWITHTARGET;
			finderArgs = new Object[] { authorId, status, targetLanguage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORIDSTATUSWITHTARGET;
			finderArgs = new Object[] {
					authorId, status, targetLanguage,
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if ((authorId != scienceApp.getAuthorId()) ||
						(status != scienceApp.getStatus()) ||
						!Validator.equals(targetLanguage,
							scienceApp.getTargetLanguage())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_AUTHORID_2);

			query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_STATUS_2);

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_TARGETLANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				qPos.add(status);

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAuthorIdStatusWithTarget_First(long authorId,
		int status, String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAuthorIdStatusWithTarget_First(authorId,
				status, targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAuthorIdStatusWithTarget_First(long authorId,
		int status, String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceApp> list = findByAuthorIdStatusWithTarget(authorId,
				status, targetLanguage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByAuthorIdStatusWithTarget_Last(long authorId,
		int status, String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByAuthorIdStatusWithTarget_Last(authorId,
				status, targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorId=");
		msg.append(authorId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByAuthorIdStatusWithTarget_Last(long authorId,
		int status, String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAuthorIdStatusWithTarget(authorId, status,
				targetLanguage);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByAuthorIdStatusWithTarget(authorId,
				status, targetLanguage, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param authorId the author ID
	 * @param status the status
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByAuthorIdStatusWithTarget_PrevAndNext(
		long scienceAppId, long authorId, int status, String targetLanguage,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByAuthorIdStatusWithTarget_PrevAndNext(session,
					scienceApp, authorId, status, targetLanguage,
					orderByComparator, true);

			array[1] = scienceApp;

			array[2] = getByAuthorIdStatusWithTarget_PrevAndNext(session,
					scienceApp, authorId, status, targetLanguage,
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

	protected ScienceApp getByAuthorIdStatusWithTarget_PrevAndNext(
		Session session, ScienceApp scienceApp, long authorId, int status,
		String targetLanguage, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_AUTHORID_2);

		query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_STATUS_2);

		boolean bindTargetLanguage = false;

		if (targetLanguage == null) {
			query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_TARGETLANGUAGE_1);
		}
		else if (targetLanguage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_TARGETLANGUAGE_3);
		}
		else {
			bindTargetLanguage = true;

			query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_TARGETLANGUAGE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(authorId);

		qPos.add(status);

		if (bindTargetLanguage) {
			qPos.add(targetLanguage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where authorId = &#63; and status = &#63; and targetLanguage = &#63; from the database.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param targetLanguage the target language
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAuthorIdStatusWithTarget(long authorId, int status,
		String targetLanguage) throws SystemException {
		for (ScienceApp scienceApp : findByAuthorIdStatusWithTarget(authorId,
				status, targetLanguage, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where authorId = &#63; and status = &#63; and targetLanguage = &#63;.
	 *
	 * @param authorId the author ID
	 * @param status the status
	 * @param targetLanguage the target language
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAuthorIdStatusWithTarget(long authorId, int status,
		String targetLanguage) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHORIDSTATUSWITHTARGET;

		Object[] finderArgs = new Object[] { authorId, status, targetLanguage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_AUTHORID_2);

			query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_STATUS_2);

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_TARGETLANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(authorId);

				qPos.add(status);

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

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

	private static final String _FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_AUTHORID_2 =
		"scienceApp.authorId = ? AND ";
	private static final String _FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_STATUS_2 =
		"scienceApp.status = ? AND ";
	private static final String _FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_TARGETLANGUAGE_1 =
		"scienceApp.targetLanguage IS NULL";
	private static final String _FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_TARGETLANGUAGE_2 =
		"scienceApp.targetLanguage = ?";
	private static final String _FINDER_COLUMN_AUTHORIDSTATUSWITHTARGET_TARGETLANGUAGE_3 =
		"(scienceApp.targetLanguage IS NULL OR scienceApp.targetLanguage = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OPENLEVELWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOpenLevelWithTarget",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENLEVELWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByOpenLevelWithTarget",
			new String[] { String.class.getName(), String.class.getName() },
			ScienceAppModelImpl.OPENLEVEL_COLUMN_BITMASK |
			ScienceAppModelImpl.TARGETLANGUAGE_COLUMN_BITMASK |
			ScienceAppModelImpl.CREATEDATE_COLUMN_BITMASK |
			ScienceAppModelImpl.VERSION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OPENLEVELWITHTARGET = new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByOpenLevelWithTarget",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the science apps where openLevel = &#63; and targetLanguage = &#63;.
	 *
	 * @param openLevel the open level
	 * @param targetLanguage the target language
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByOpenLevelWithTarget(String openLevel,
		String targetLanguage) throws SystemException {
		return findByOpenLevelWithTarget(openLevel, targetLanguage,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where openLevel = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openLevel the open level
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByOpenLevelWithTarget(String openLevel,
		String targetLanguage, int start, int end) throws SystemException {
		return findByOpenLevelWithTarget(openLevel, targetLanguage, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the science apps where openLevel = &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param openLevel the open level
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByOpenLevelWithTarget(String openLevel,
		String targetLanguage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENLEVELWITHTARGET;
			finderArgs = new Object[] { openLevel, targetLanguage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OPENLEVELWITHTARGET;
			finderArgs = new Object[] {
					openLevel, targetLanguage,
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!Validator.equals(openLevel, scienceApp.getOpenLevel()) ||
						!Validator.equals(targetLanguage,
							scienceApp.getTargetLanguage())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindOpenLevel = false;

			if (openLevel == null) {
				query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_OPENLEVEL_1);
			}
			else if (openLevel.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_OPENLEVEL_3);
			}
			else {
				bindOpenLevel = true;

				query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_OPENLEVEL_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_TARGETLANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOpenLevel) {
					qPos.add(openLevel);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where openLevel = &#63; and targetLanguage = &#63;.
	 *
	 * @param openLevel the open level
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByOpenLevelWithTarget_First(String openLevel,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByOpenLevelWithTarget_First(openLevel,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("openLevel=");
		msg.append(openLevel);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where openLevel = &#63; and targetLanguage = &#63;.
	 *
	 * @param openLevel the open level
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByOpenLevelWithTarget_First(String openLevel,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceApp> list = findByOpenLevelWithTarget(openLevel,
				targetLanguage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where openLevel = &#63; and targetLanguage = &#63;.
	 *
	 * @param openLevel the open level
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByOpenLevelWithTarget_Last(String openLevel,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByOpenLevelWithTarget_Last(openLevel,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("openLevel=");
		msg.append(openLevel);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where openLevel = &#63; and targetLanguage = &#63;.
	 *
	 * @param openLevel the open level
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByOpenLevelWithTarget_Last(String openLevel,
		String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByOpenLevelWithTarget(openLevel, targetLanguage);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByOpenLevelWithTarget(openLevel,
				targetLanguage, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where openLevel = &#63; and targetLanguage = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param openLevel the open level
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByOpenLevelWithTarget_PrevAndNext(
		long scienceAppId, String openLevel, String targetLanguage,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByOpenLevelWithTarget_PrevAndNext(session,
					scienceApp, openLevel, targetLanguage, orderByComparator,
					true);

			array[1] = scienceApp;

			array[2] = getByOpenLevelWithTarget_PrevAndNext(session,
					scienceApp, openLevel, targetLanguage, orderByComparator,
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

	protected ScienceApp getByOpenLevelWithTarget_PrevAndNext(Session session,
		ScienceApp scienceApp, String openLevel, String targetLanguage,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindOpenLevel = false;

		if (openLevel == null) {
			query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_OPENLEVEL_1);
		}
		else if (openLevel.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_OPENLEVEL_3);
		}
		else {
			bindOpenLevel = true;

			query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_OPENLEVEL_2);
		}

		boolean bindTargetLanguage = false;

		if (targetLanguage == null) {
			query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_TARGETLANGUAGE_1);
		}
		else if (targetLanguage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_TARGETLANGUAGE_3);
		}
		else {
			bindTargetLanguage = true;

			query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_TARGETLANGUAGE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOpenLevel) {
			qPos.add(openLevel);
		}

		if (bindTargetLanguage) {
			qPos.add(targetLanguage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science apps where openLevel = &#63; and targetLanguage = &#63; from the database.
	 *
	 * @param openLevel the open level
	 * @param targetLanguage the target language
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOpenLevelWithTarget(String openLevel,
		String targetLanguage) throws SystemException {
		for (ScienceApp scienceApp : findByOpenLevelWithTarget(openLevel,
				targetLanguage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where openLevel = &#63; and targetLanguage = &#63;.
	 *
	 * @param openLevel the open level
	 * @param targetLanguage the target language
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOpenLevelWithTarget(String openLevel,
		String targetLanguage) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OPENLEVELWITHTARGET;

		Object[] finderArgs = new Object[] { openLevel, targetLanguage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindOpenLevel = false;

			if (openLevel == null) {
				query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_OPENLEVEL_1);
			}
			else if (openLevel.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_OPENLEVEL_3);
			}
			else {
				bindOpenLevel = true;

				query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_OPENLEVEL_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_OPENLEVELWITHTARGET_TARGETLANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOpenLevel) {
					qPos.add(openLevel);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

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

	private static final String _FINDER_COLUMN_OPENLEVELWITHTARGET_OPENLEVEL_1 = "scienceApp.openLevel IS NULL AND ";
	private static final String _FINDER_COLUMN_OPENLEVELWITHTARGET_OPENLEVEL_2 = "scienceApp.openLevel = ? AND ";
	private static final String _FINDER_COLUMN_OPENLEVELWITHTARGET_OPENLEVEL_3 = "(scienceApp.openLevel IS NULL OR scienceApp.openLevel = '') AND ";
	private static final String _FINDER_COLUMN_OPENLEVELWITHTARGET_TARGETLANGUAGE_1 =
		"scienceApp.targetLanguage IS NULL";
	private static final String _FINDER_COLUMN_OPENLEVELWITHTARGET_TARGETLANGUAGE_2 =
		"scienceApp.targetLanguage = ?";
	private static final String _FINDER_COLUMN_OPENLEVELWITHTARGET_TARGETLANGUAGE_3 =
		"(scienceApp.targetLanguage IS NULL OR scienceApp.targetLanguage = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMETITLEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, ScienceAppImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNameTitleWithTarget",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAMETITLEWITHTARGET =
		new FinderPath(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByNameTitleWithTarget",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the science apps where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param name the name
	 * @param title the title
	 * @param targetLanguage the target language
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByNameTitleWithTarget(String name,
		String title, String targetLanguage) throws SystemException {
		return findByNameTitleWithTarget(name, title, targetLanguage,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByNameTitleWithTarget(String name,
		String title, String targetLanguage, int start, int end)
		throws SystemException {
		return findByNameTitleWithTarget(name, title, targetLanguage, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param name the name
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByNameTitleWithTarget(String name,
		String title, String targetLanguage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMETITLEWITHTARGET;
		finderArgs = new Object[] {
				name, title, targetLanguage,
				
				start, end, orderByComparator
			};

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!StringUtil.wildcardMatches(scienceApp.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						!StringUtil.wildcardMatches(scienceApp.getTitle(),
							title, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						!Validator.equals(targetLanguage,
							scienceApp.getTargetLanguage())) {
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

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_2);
			}

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (bindTitle) {
					qPos.add(title);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first science app in the ordered set where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param name the name
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByNameTitleWithTarget_First(String name,
		String title, String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByNameTitleWithTarget_First(name, title,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", title=");
		msg.append(title);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the first science app in the ordered set where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param name the name
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByNameTitleWithTarget_First(String name,
		String title, String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceApp> list = findByNameTitleWithTarget(name, title,
				targetLanguage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app in the ordered set where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param name the name
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByNameTitleWithTarget_Last(String name, String title,
		String targetLanguage, OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByNameTitleWithTarget_Last(name, title,
				targetLanguage, orderByComparator);

		if (scienceApp != null) {
			return scienceApp;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", title=");
		msg.append(title);

		msg.append(", targetLanguage=");
		msg.append(targetLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchScienceAppException(msg.toString());
	}

	/**
	 * Returns the last science app in the ordered set where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param name the name
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app, or <code>null</code> if a matching science app could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByNameTitleWithTarget_Last(String name,
		String title, String targetLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByNameTitleWithTarget(name, title, targetLanguage);

		if (count == 0) {
			return null;
		}

		List<ScienceApp> list = findByNameTitleWithTarget(name, title,
				targetLanguage, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science apps before and after the current science app in the ordered set where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param scienceAppId the primary key of the current science app
	 * @param name the name
	 * @param title the title
	 * @param targetLanguage the target language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp[] findByNameTitleWithTarget_PrevAndNext(
		long scienceAppId, String name, String title, String targetLanguage,
		OrderByComparator orderByComparator)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = findByPrimaryKey(scienceAppId);

		Session session = null;

		try {
			session = openSession();

			ScienceApp[] array = new ScienceAppImpl[3];

			array[0] = getByNameTitleWithTarget_PrevAndNext(session,
					scienceApp, name, title, targetLanguage, orderByComparator,
					true);

			array[1] = scienceApp;

			array[2] = getByNameTitleWithTarget_PrevAndNext(session,
					scienceApp, name, title, targetLanguage, orderByComparator,
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

	protected ScienceApp getByNameTitleWithTarget_PrevAndNext(Session session,
		ScienceApp scienceApp, String name, String title,
		String targetLanguage, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_2);
		}

		boolean bindTitle = false;

		if (title == null) {
			query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_1);
		}
		else if (title.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_3);
		}
		else {
			bindTitle = true;

			query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_2);
		}

		boolean bindTargetLanguage = false;

		if (targetLanguage == null) {
			query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_1);
		}
		else if (targetLanguage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_3);
		}
		else {
			bindTargetLanguage = true;

			query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_2);
		}

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
			query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (bindTitle) {
			qPos.add(title);
		}

		if (bindTargetLanguage) {
			qPos.add(targetLanguage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceApp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceApp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the science apps where name LIKE any &#63; and title LIKE any &#63; and targetLanguage = all &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param names the names
	 * @param titles the titles
	 * @param targetLanguages the target languages
	 * @return the matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByNameTitleWithTarget(String[] names,
		String[] titles, String[] targetLanguages) throws SystemException {
		return findByNameTitleWithTarget(names, titles, targetLanguages,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps where name LIKE any &#63; and title LIKE any &#63; and targetLanguage = all &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param names the names
	 * @param titles the titles
	 * @param targetLanguages the target languages
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByNameTitleWithTarget(String[] names,
		String[] titles, String[] targetLanguages, int start, int end)
		throws SystemException {
		return findByNameTitleWithTarget(names, titles, targetLanguages, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the science apps where name LIKE any &#63; and title LIKE any &#63; and targetLanguage = all &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param names the names
	 * @param titles the titles
	 * @param targetLanguages the target languages
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findByNameTitleWithTarget(String[] names,
		String[] titles, String[] targetLanguages, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		if ((names != null) && (names.length == 1) && (titles != null) &&
				(titles.length == 1) && (targetLanguages != null) &&
				(targetLanguages.length == 1)) {
			return findByNameTitleWithTarget(names[0], titles[0],
				targetLanguages[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderArgs = new Object[] {
					StringUtil.merge(names), StringUtil.merge(titles),
					StringUtil.merge(targetLanguages)
				};
		}
		else {
			finderArgs = new Object[] {
					StringUtil.merge(names), StringUtil.merge(titles),
					StringUtil.merge(targetLanguages),
					
					start, end, orderByComparator
				};
		}

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMETITLEWITHTARGET,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceApp scienceApp : list) {
				if (!ArrayUtil.contains(names, scienceApp.getName()) ||
						!ArrayUtil.contains(titles, scienceApp.getTitle()) ||
						!ArrayUtil.contains(targetLanguages,
							scienceApp.getTargetLanguage())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_SCIENCEAPP_WHERE);

			boolean conjunctionable = false;

			if ((names == null) || (names.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < names.length; i++) {
					String name = names[i];

					if (name == null) {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_4);
					}
					else if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_5);
					}

					if ((i + 1) < names.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((titles == null) || (titles.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < titles.length; i++) {
					String title = titles[i];

					if (title == null) {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_4);
					}
					else if (title.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_6);
					}
					else {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_5);
					}

					if ((i + 1) < titles.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((targetLanguages == null) || (targetLanguages.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < targetLanguages.length; i++) {
					String targetLanguage = targetLanguages[i];

					if (targetLanguage == null) {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_4);
					}
					else if (targetLanguage.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_6);
					}
					else {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_5);
					}

					if ((i + 1) < targetLanguages.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (names != null) {
					qPos.add(names);
				}

				if (titles != null) {
					qPos.add(titles);
				}

				if (targetLanguages != null) {
					qPos.add(targetLanguages);
				}

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMETITLEWITHTARGET,
					finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMETITLEWITHTARGET,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the science apps where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63; from the database.
	 *
	 * @param name the name
	 * @param title the title
	 * @param targetLanguage the target language
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNameTitleWithTarget(String name, String title,
		String targetLanguage) throws SystemException {
		for (ScienceApp scienceApp : findByNameTitleWithTarget(name, title,
				targetLanguage, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps where name LIKE &#63; and title LIKE &#63; and targetLanguage = &#63;.
	 *
	 * @param name the name
	 * @param title the title
	 * @param targetLanguage the target language
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNameTitleWithTarget(String name, String title,
		String targetLanguage) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAMETITLEWITHTARGET;

		Object[] finderArgs = new Object[] { name, title, targetLanguage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_2);
			}

			boolean bindTitle = false;

			if (title == null) {
				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_1);
			}
			else if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_3);
			}
			else {
				bindTitle = true;

				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_2);
			}

			boolean bindTargetLanguage = false;

			if (targetLanguage == null) {
				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_1);
			}
			else if (targetLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_3);
			}
			else {
				bindTargetLanguage = true;

				query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (bindTitle) {
					qPos.add(title);
				}

				if (bindTargetLanguage) {
					qPos.add(targetLanguage);
				}

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

	/**
	 * Returns the number of science apps where name LIKE any &#63; and title LIKE any &#63; and targetLanguage = all &#63;.
	 *
	 * @param names the names
	 * @param titles the titles
	 * @param targetLanguages the target languages
	 * @return the number of matching science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNameTitleWithTarget(String[] names, String[] titles,
		String[] targetLanguages) throws SystemException {
		Object[] finderArgs = new Object[] {
				StringUtil.merge(names), StringUtil.merge(titles),
				StringUtil.merge(targetLanguages)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAMETITLEWITHTARGET,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_SCIENCEAPP_WHERE);

			boolean conjunctionable = false;

			if ((names == null) || (names.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < names.length; i++) {
					String name = names[i];

					if (name == null) {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_4);
					}
					else if (name.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_6);
					}
					else {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_5);
					}

					if ((i + 1) < names.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((titles == null) || (titles.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < titles.length; i++) {
					String title = titles[i];

					if (title == null) {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_4);
					}
					else if (title.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_6);
					}
					else {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_5);
					}

					if ((i + 1) < titles.length) {
						query.append(WHERE_OR);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			if ((targetLanguages == null) || (targetLanguages.length > 0)) {
				if (conjunctionable) {
					query.append(WHERE_AND);
				}

				query.append(StringPool.OPEN_PARENTHESIS);

				for (int i = 0; i < targetLanguages.length; i++) {
					String targetLanguage = targetLanguages[i];

					if (targetLanguage == null) {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_4);
					}
					else if (targetLanguage.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_6);
					}
					else {
						query.append(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_5);
					}

					if ((i + 1) < targetLanguages.length) {
						query.append(WHERE_AND);
					}
				}

				query.append(StringPool.CLOSE_PARENTHESIS);

				conjunctionable = true;
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (names != null) {
					qPos.add(names);
				}

				if (titles != null) {
					qPos.add(titles);
				}

				if (targetLanguages != null) {
					qPos.add(targetLanguages);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAMETITLEWITHTARGET,
					finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAMETITLEWITHTARGET,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_1 = "scienceApp.name LIKE NULL AND ";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_2 = "scienceApp.name LIKE ? AND ";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_3 = "(scienceApp.name IS NULL OR scienceApp.name LIKE '') AND ";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_4 = "(" +
		removeConjunction(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_1) + ")";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_5 = "(" +
		removeConjunction(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_2) + ")";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_6 = "(" +
		removeConjunction(_FINDER_COLUMN_NAMETITLEWITHTARGET_NAME_3) + ")";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_1 = "scienceApp.title LIKE NULL AND ";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_2 = "scienceApp.title LIKE ? AND ";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_3 = "(scienceApp.title IS NULL OR scienceApp.title LIKE '') AND ";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_4 = "(" +
		removeConjunction(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_1) + ")";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_5 = "(" +
		removeConjunction(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_2) + ")";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_6 = "(" +
		removeConjunction(_FINDER_COLUMN_NAMETITLEWITHTARGET_TITLE_3) + ")";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_1 =
		"scienceApp.targetLanguage IS NULL";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_2 =
		"scienceApp.targetLanguage = ?";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_3 =
		"(scienceApp.targetLanguage IS NULL OR scienceApp.targetLanguage = '')";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_4 =
		"(" +
		removeConjunction(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_1) +
		")";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_5 =
		"(" +
		removeConjunction(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_2) +
		")";
	private static final String _FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_6 =
		"(" +
		removeConjunction(_FINDER_COLUMN_NAMETITLEWITHTARGET_TARGETLANGUAGE_3) +
		")";

	public ScienceAppPersistenceImpl() {
		setModelClass(ScienceApp.class);
	}

	/**
	 * Caches the science app in the entity cache if it is enabled.
	 *
	 * @param scienceApp the science app
	 */
	@Override
	public void cacheResult(ScienceApp scienceApp) {
		EntityCacheUtil.putResult(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppImpl.class, scienceApp.getPrimaryKey(), scienceApp);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { scienceApp.getUuid(), scienceApp.getGroupId() },
			scienceApp);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEVERSION,
			new Object[] { scienceApp.getName(), scienceApp.getVersion() },
			scienceApp);

		scienceApp.resetOriginalValues();
	}

	/**
	 * Caches the science apps in the entity cache if it is enabled.
	 *
	 * @param scienceApps the science apps
	 */
	@Override
	public void cacheResult(List<ScienceApp> scienceApps) {
		for (ScienceApp scienceApp : scienceApps) {
			if (EntityCacheUtil.getResult(
						ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppImpl.class, scienceApp.getPrimaryKey()) == null) {
				cacheResult(scienceApp);
			}
			else {
				scienceApp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all science apps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ScienceAppImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ScienceAppImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the science app.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScienceApp scienceApp) {
		EntityCacheUtil.removeResult(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppImpl.class, scienceApp.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(scienceApp);
	}

	@Override
	public void clearCache(List<ScienceApp> scienceApps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ScienceApp scienceApp : scienceApps) {
			EntityCacheUtil.removeResult(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppImpl.class, scienceApp.getPrimaryKey());

			clearUniqueFindersCache(scienceApp);
		}
	}

	protected void cacheUniqueFindersCache(ScienceApp scienceApp) {
		if (scienceApp.isNew()) {
			Object[] args = new Object[] {
					scienceApp.getUuid(), scienceApp.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				scienceApp);

			args = new Object[] { scienceApp.getName(), scienceApp.getVersion() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEVERSION, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEVERSION, args,
				scienceApp);
		}
		else {
			ScienceAppModelImpl scienceAppModelImpl = (ScienceAppModelImpl)scienceApp;

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceApp.getUuid(), scienceApp.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					scienceApp);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAMEVERSION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceApp.getName(), scienceApp.getVersion()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEVERSION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEVERSION,
					args, scienceApp);
			}
		}
	}

	protected void clearUniqueFindersCache(ScienceApp scienceApp) {
		ScienceAppModelImpl scienceAppModelImpl = (ScienceAppModelImpl)scienceApp;

		Object[] args = new Object[] {
				scienceApp.getUuid(), scienceApp.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((scienceAppModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					scienceAppModelImpl.getOriginalUuid(),
					scienceAppModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] { scienceApp.getName(), scienceApp.getVersion() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEVERSION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEVERSION, args);

		if ((scienceAppModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAMEVERSION.getColumnBitmask()) != 0) {
			args = new Object[] {
					scienceAppModelImpl.getOriginalName(),
					scienceAppModelImpl.getOriginalVersion()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEVERSION, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEVERSION, args);
		}
	}

	/**
	 * Creates a new science app with the primary key. Does not add the science app to the database.
	 *
	 * @param scienceAppId the primary key for the new science app
	 * @return the new science app
	 */
	@Override
	public ScienceApp create(long scienceAppId) {
		ScienceApp scienceApp = new ScienceAppImpl();

		scienceApp.setNew(true);
		scienceApp.setPrimaryKey(scienceAppId);

		String uuid = PortalUUIDUtil.generate();

		scienceApp.setUuid(uuid);

		return scienceApp;
	}

	/**
	 * Removes the science app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scienceAppId the primary key of the science app
	 * @return the science app that was removed
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp remove(long scienceAppId)
		throws NoSuchScienceAppException, SystemException {
		return remove((Serializable)scienceAppId);
	}

	/**
	 * Removes the science app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the science app
	 * @return the science app that was removed
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp remove(Serializable primaryKey)
		throws NoSuchScienceAppException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ScienceApp scienceApp = (ScienceApp)session.get(ScienceAppImpl.class,
					primaryKey);

			if (scienceApp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScienceAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scienceApp);
		}
		catch (NoSuchScienceAppException nsee) {
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
	protected ScienceApp removeImpl(ScienceApp scienceApp)
		throws SystemException {
		scienceApp = toUnwrappedModel(scienceApp);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scienceApp)) {
				scienceApp = (ScienceApp)session.get(ScienceAppImpl.class,
						scienceApp.getPrimaryKeyObj());
			}

			if (scienceApp != null) {
				session.delete(scienceApp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scienceApp != null) {
			clearCache(scienceApp);
		}

		return scienceApp;
	}

	@Override
	public ScienceApp updateImpl(
		org.kisti.edison.science.model.ScienceApp scienceApp)
		throws SystemException {
		scienceApp = toUnwrappedModel(scienceApp);

		boolean isNew = scienceApp.isNew();

		ScienceAppModelImpl scienceAppModelImpl = (ScienceAppModelImpl)scienceApp;

		if (Validator.isNull(scienceApp.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			scienceApp.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (scienceApp.isNew()) {
				session.save(scienceApp);

				scienceApp.setNew(false);
			}
			else {
				session.merge(scienceApp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ScienceAppModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { scienceAppModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalUuid(),
						scienceAppModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						scienceAppModelImpl.getUuid(),
						scienceAppModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);

				args = new Object[] { scienceAppModelImpl.getName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAME,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalAppType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPTYPE,
					args);

				args = new Object[] { scienceAppModelImpl.getAppType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPTYPE,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRUNTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalAppType(),
						scienceAppModelImpl.getOriginalRunType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPRUNTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRUNTYPE,
					args);

				args = new Object[] {
						scienceAppModelImpl.getAppType(),
						scienceAppModelImpl.getRunType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPRUNTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRUNTYPE,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalAuthorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID,
					args);

				args = new Object[] { scienceAppModelImpl.getAuthorId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORID,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAGE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalStage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STAGE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAGE,
					args);

				args = new Object[] { scienceAppModelImpl.getStage() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STAGE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAGE,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { scienceAppModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDAPPTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalAuthorId(),
						scienceAppModelImpl.getOriginalAppType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORIDAPPTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDAPPTYPE,
					args);

				args = new Object[] {
						scienceAppModelImpl.getAuthorId(),
						scienceAppModelImpl.getAppType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORIDAPPTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDAPPTYPE,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalAuthorId(),
						scienceAppModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORIDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDSTATUS,
					args);

				args = new Object[] {
						scienceAppModelImpl.getAuthorId(),
						scienceAppModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORIDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDSTATUS,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENLEVEL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalOpenLevel()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPENLEVEL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENLEVEL,
					args);

				args = new Object[] { scienceAppModelImpl.getOpenLevel() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPENLEVEL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENLEVEL,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEWITHTARGET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalName(),
						scienceAppModelImpl.getOriginalTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEWITHTARGET,
					args);

				args = new Object[] {
						scienceAppModelImpl.getName(),
						scienceAppModelImpl.getTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NAMEWITHTARGET,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPTYPEWITHTARGET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalAppType(),
						scienceAppModelImpl.getOriginalTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPTYPEWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPTYPEWITHTARGET,
					args);

				args = new Object[] {
						scienceAppModelImpl.getAppType(),
						scienceAppModelImpl.getTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPTYPEWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPTYPEWITHTARGET,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRUNTYPEWITHTARGET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalAppType(),
						scienceAppModelImpl.getOriginalRunType(),
						scienceAppModelImpl.getOriginalTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPRUNTYPEWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRUNTYPEWITHTARGET,
					args);

				args = new Object[] {
						scienceAppModelImpl.getAppType(),
						scienceAppModelImpl.getRunType(),
						scienceAppModelImpl.getTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPRUNTYPEWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPRUNTYPEWITHTARGET,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDWITHTARGET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalAuthorId(),
						scienceAppModelImpl.getOriginalTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORIDWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDWITHTARGET,
					args);

				args = new Object[] {
						scienceAppModelImpl.getAuthorId(),
						scienceAppModelImpl.getTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORIDWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDWITHTARGET,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAGEWITHTARGET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalStage(),
						scienceAppModelImpl.getOriginalTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STAGEWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAGEWITHTARGET,
					args);

				args = new Object[] {
						scienceAppModelImpl.getStage(),
						scienceAppModelImpl.getTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STAGEWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STAGEWITHTARGET,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSWITHTARGET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalStatus(),
						scienceAppModelImpl.getOriginalTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSWITHTARGET,
					args);

				args = new Object[] {
						scienceAppModelImpl.getStatus(),
						scienceAppModelImpl.getTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSWITHTARGET,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDAPPTYPEWITHTARGET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalAuthorId(),
						scienceAppModelImpl.getOriginalAppType(),
						scienceAppModelImpl.getOriginalTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORIDAPPTYPEWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDAPPTYPEWITHTARGET,
					args);

				args = new Object[] {
						scienceAppModelImpl.getAuthorId(),
						scienceAppModelImpl.getAppType(),
						scienceAppModelImpl.getTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORIDAPPTYPEWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDAPPTYPEWITHTARGET,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDSTATUSWITHTARGET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalAuthorId(),
						scienceAppModelImpl.getOriginalStatus(),
						scienceAppModelImpl.getOriginalTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORIDSTATUSWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDSTATUSWITHTARGET,
					args);

				args = new Object[] {
						scienceAppModelImpl.getAuthorId(),
						scienceAppModelImpl.getStatus(),
						scienceAppModelImpl.getTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORIDSTATUSWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORIDSTATUSWITHTARGET,
					args);
			}

			if ((scienceAppModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENLEVELWITHTARGET.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppModelImpl.getOriginalOpenLevel(),
						scienceAppModelImpl.getOriginalTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPENLEVELWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENLEVELWITHTARGET,
					args);

				args = new Object[] {
						scienceAppModelImpl.getOpenLevel(),
						scienceAppModelImpl.getTargetLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OPENLEVELWITHTARGET,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OPENLEVELWITHTARGET,
					args);
			}
		}

		EntityCacheUtil.putResult(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppImpl.class, scienceApp.getPrimaryKey(), scienceApp);

		clearUniqueFindersCache(scienceApp);
		cacheUniqueFindersCache(scienceApp);

		return scienceApp;
	}

	protected ScienceApp toUnwrappedModel(ScienceApp scienceApp) {
		if (scienceApp instanceof ScienceAppImpl) {
			return scienceApp;
		}

		ScienceAppImpl scienceAppImpl = new ScienceAppImpl();

		scienceAppImpl.setNew(scienceApp.isNew());
		scienceAppImpl.setPrimaryKey(scienceApp.getPrimaryKey());

		scienceAppImpl.setUuid(scienceApp.getUuid());
		scienceAppImpl.setScienceAppId(scienceApp.getScienceAppId());
		scienceAppImpl.setGroupId(scienceApp.getGroupId());
		scienceAppImpl.setCompanyId(scienceApp.getCompanyId());
		scienceAppImpl.setUserId(scienceApp.getUserId());
		scienceAppImpl.setCreateDate(scienceApp.getCreateDate());
		scienceAppImpl.setModifiedDate(scienceApp.getModifiedDate());
		scienceAppImpl.setName(scienceApp.getName());
		scienceAppImpl.setVersion(scienceApp.getVersion());
		scienceAppImpl.setTitle(scienceApp.getTitle());
		scienceAppImpl.setDescriptionId(scienceApp.getDescriptionId());
		scienceAppImpl.setPreviousVersionId(scienceApp.getPreviousVersionId());
		scienceAppImpl.setIconId(scienceApp.getIconId());
		scienceAppImpl.setManualId(scienceApp.getManualId());
		scienceAppImpl.setExeFileName(scienceApp.getExeFileName());
		scienceAppImpl.setAppType(scienceApp.getAppType());
		scienceAppImpl.setRunType(scienceApp.getRunType());
		scienceAppImpl.setAuthorId(scienceApp.getAuthorId());
		scienceAppImpl.setStage(scienceApp.getStage());
		scienceAppImpl.setStatus(scienceApp.getStatus());
		scienceAppImpl.setRecentModifierId(scienceApp.getRecentModifierId());
		scienceAppImpl.setParallelModule(scienceApp.getParallelModule());
		scienceAppImpl.setMaxCpus(scienceApp.getMaxCpus());
		scienceAppImpl.setDefaultCpus(scienceApp.getDefaultCpus());
		scienceAppImpl.setStatusDate(scienceApp.getStatusDate());
		scienceAppImpl.setOpenLevel(scienceApp.getOpenLevel());
		scienceAppImpl.setLicense(scienceApp.getLicense());
		scienceAppImpl.setSrcFileName(scienceApp.getSrcFileName());
		scienceAppImpl.setTargetLanguage(scienceApp.getTargetLanguage());
		scienceAppImpl.setDevelopers(scienceApp.getDevelopers());
		scienceAppImpl.setEditorType(scienceApp.getEditorType());
		scienceAppImpl.setSwTest(scienceApp.isSwTest());
		scienceAppImpl.setProjectCategoryId(scienceApp.getProjectCategoryId());

		return scienceAppImpl;
	}

	/**
	 * Returns the science app with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app
	 * @return the science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchScienceAppException, SystemException {
		ScienceApp scienceApp = fetchByPrimaryKey(primaryKey);

		if (scienceApp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchScienceAppException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return scienceApp;
	}

	/**
	 * Returns the science app with the primary key or throws a {@link org.kisti.edison.science.NoSuchScienceAppException} if it could not be found.
	 *
	 * @param scienceAppId the primary key of the science app
	 * @return the science app
	 * @throws org.kisti.edison.science.NoSuchScienceAppException if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp findByPrimaryKey(long scienceAppId)
		throws NoSuchScienceAppException, SystemException {
		return findByPrimaryKey((Serializable)scienceAppId);
	}

	/**
	 * Returns the science app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app
	 * @return the science app, or <code>null</code> if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ScienceApp scienceApp = (ScienceApp)EntityCacheUtil.getResult(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppImpl.class, primaryKey);

		if (scienceApp == _nullScienceApp) {
			return null;
		}

		if (scienceApp == null) {
			Session session = null;

			try {
				session = openSession();

				scienceApp = (ScienceApp)session.get(ScienceAppImpl.class,
						primaryKey);

				if (scienceApp != null) {
					cacheResult(scienceApp);
				}
				else {
					EntityCacheUtil.putResult(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppImpl.class, primaryKey, _nullScienceApp);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ScienceAppModelImpl.ENTITY_CACHE_ENABLED,
					ScienceAppImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return scienceApp;
	}

	/**
	 * Returns the science app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scienceAppId the primary key of the science app
	 * @return the science app, or <code>null</code> if a science app with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceApp fetchByPrimaryKey(long scienceAppId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)scienceAppId);
	}

	/**
	 * Returns all the science apps.
	 *
	 * @return the science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @return the range of science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the science apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.ScienceAppModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science apps
	 * @param end the upper bound of the range of science apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of science apps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceApp> findAll(int start, int end,
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

		List<ScienceApp> list = (List<ScienceApp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCIENCEAPP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCIENCEAPP;

				if (pagination) {
					sql = sql.concat(ScienceAppModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceApp>(list);
				}
				else {
					list = (List<ScienceApp>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the science apps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ScienceApp scienceApp : findAll()) {
			remove(scienceApp);
		}
	}

	/**
	 * Returns the number of science apps.
	 *
	 * @return the number of science apps
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

				Query q = session.createQuery(_SQL_COUNT_SCIENCEAPP);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the science app persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.science.model.ScienceApp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ScienceApp>> listenersList = new ArrayList<ModelListener<ScienceApp>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ScienceApp>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ScienceAppImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SCIENCEAPP = "SELECT scienceApp FROM ScienceApp scienceApp";
	private static final String _SQL_SELECT_SCIENCEAPP_WHERE = "SELECT scienceApp FROM ScienceApp scienceApp WHERE ";
	private static final String _SQL_COUNT_SCIENCEAPP = "SELECT COUNT(scienceApp) FROM ScienceApp scienceApp";
	private static final String _SQL_COUNT_SCIENCEAPP_WHERE = "SELECT COUNT(scienceApp) FROM ScienceApp scienceApp WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scienceApp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ScienceApp exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ScienceApp exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ScienceAppPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ScienceApp _nullScienceApp = new ScienceAppImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ScienceApp> toCacheModel() {
				return _nullScienceAppCacheModel;
			}
		};

	private static CacheModel<ScienceApp> _nullScienceAppCacheModel = new CacheModel<ScienceApp>() {
			@Override
			public ScienceApp toEntityModel() {
				return _nullScienceApp;
			}
		};
}