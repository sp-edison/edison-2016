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

import com.kisti.science.platform.app.NoSuchCategoryLinkException;
import com.kisti.science.platform.app.model.ScienceAppCategoryLink;
import com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkImpl;
import com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl;

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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the science app category link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see ScienceAppCategoryLinkPersistence
 * @see ScienceAppCategoryLinkUtil
 * @generated
 */
public class ScienceAppCategoryLinkPersistenceImpl extends BasePersistenceImpl<ScienceAppCategoryLink>
	implements ScienceAppCategoryLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ScienceAppCategoryLinkUtil} to access the science app category link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ScienceAppCategoryLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			ScienceAppCategoryLinkModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the science app category links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science app category links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of science app category links
	 * @param end the upper bound of the range of science app category links (not inclusive)
	 * @return the range of matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByUuid(String uuid, int start,
		int end) throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app category links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of science app category links
	 * @param end the upper bound of the range of science app category links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByUuid(String uuid, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<ScienceAppCategoryLink> list = (List<ScienceAppCategoryLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceAppCategoryLink scienceAppCategoryLink : list) {
				if (!Validator.equals(uuid, scienceAppCategoryLink.getUuid())) {
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

			query.append(_SQL_SELECT_SCIENCEAPPCATEGORYLINK_WHERE);

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
				query.append(ScienceAppCategoryLinkModelImpl.ORDER_BY_JPQL);
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
					list = (List<ScienceAppCategoryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppCategoryLink>(list);
				}
				else {
					list = (List<ScienceAppCategoryLink>)QueryUtil.list(q,
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
	 * Returns the first science app category link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = fetchByUuid_First(uuid,
				orderByComparator);

		if (scienceAppCategoryLink != null) {
			return scienceAppCategoryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryLinkException(msg.toString());
	}

	/**
	 * Returns the first science app category link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app category link, or <code>null</code> if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceAppCategoryLink> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app category link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = fetchByUuid_Last(uuid,
				orderByComparator);

		if (scienceAppCategoryLink != null) {
			return scienceAppCategoryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryLinkException(msg.toString());
	}

	/**
	 * Returns the last science app category link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app category link, or <code>null</code> if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ScienceAppCategoryLink> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science app category links before and after the current science app category link in the ordered set where uuid = &#63;.
	 *
	 * @param scienceAppCategoryLinkId the primary key of the current science app category link
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink[] findByUuid_PrevAndNext(
		long scienceAppCategoryLinkId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = findByPrimaryKey(scienceAppCategoryLinkId);

		Session session = null;

		try {
			session = openSession();

			ScienceAppCategoryLink[] array = new ScienceAppCategoryLinkImpl[3];

			array[0] = getByUuid_PrevAndNext(session, scienceAppCategoryLink,
					uuid, orderByComparator, true);

			array[1] = scienceAppCategoryLink;

			array[2] = getByUuid_PrevAndNext(session, scienceAppCategoryLink,
					uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceAppCategoryLink getByUuid_PrevAndNext(Session session,
		ScienceAppCategoryLink scienceAppCategoryLink, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPPCATEGORYLINK_WHERE);

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
			query.append(ScienceAppCategoryLinkModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(scienceAppCategoryLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceAppCategoryLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science app category links where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (ScienceAppCategoryLink scienceAppCategoryLink : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceAppCategoryLink);
		}
	}

	/**
	 * Returns the number of science app category links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching science app category links
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

			query.append(_SQL_COUNT_SCIENCEAPPCATEGORYLINK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "scienceAppCategoryLink.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "scienceAppCategoryLink.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(scienceAppCategoryLink.uuid IS NULL OR scienceAppCategoryLink.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			ScienceAppCategoryLinkModelImpl.UUID_COLUMN_BITMASK |
			ScienceAppCategoryLinkModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the science app category link where uuid = &#63; and groupId = &#63; or throws a {@link com.kisti.science.platform.app.NoSuchCategoryLinkException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink findByUUID_G(String uuid, long groupId)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = fetchByUUID_G(uuid,
				groupId);

		if (scienceAppCategoryLink == null) {
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

			throw new NoSuchCategoryLinkException(msg.toString());
		}

		return scienceAppCategoryLink;
	}

	/**
	 * Returns the science app category link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching science app category link, or <code>null</code> if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the science app category link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching science app category link, or <code>null</code> if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof ScienceAppCategoryLink) {
			ScienceAppCategoryLink scienceAppCategoryLink = (ScienceAppCategoryLink)result;

			if (!Validator.equals(uuid, scienceAppCategoryLink.getUuid()) ||
					(groupId != scienceAppCategoryLink.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SCIENCEAPPCATEGORYLINK_WHERE);

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

				List<ScienceAppCategoryLink> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					ScienceAppCategoryLink scienceAppCategoryLink = list.get(0);

					result = scienceAppCategoryLink;

					cacheResult(scienceAppCategoryLink);

					if ((scienceAppCategoryLink.getUuid() == null) ||
							!scienceAppCategoryLink.getUuid().equals(uuid) ||
							(scienceAppCategoryLink.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, scienceAppCategoryLink);
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
			return (ScienceAppCategoryLink)result;
		}
	}

	/**
	 * Removes the science app category link where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the science app category link that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink removeByUUID_G(String uuid, long groupId)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = findByUUID_G(uuid,
				groupId);

		return remove(scienceAppCategoryLink);
	}

	/**
	 * Returns the number of science app category links where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching science app category links
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

			query.append(_SQL_COUNT_SCIENCEAPPCATEGORYLINK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "scienceAppCategoryLink.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "scienceAppCategoryLink.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(scienceAppCategoryLink.uuid IS NULL OR scienceAppCategoryLink.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "scienceAppCategoryLink.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			ScienceAppCategoryLinkModelImpl.UUID_COLUMN_BITMASK |
			ScienceAppCategoryLinkModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the science app category links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science app category links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of science app category links
	 * @param end the upper bound of the range of science app category links (not inclusive)
	 * @return the range of matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByUuid_C(String uuid,
		long companyId, int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app category links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of science app category links
	 * @param end the upper bound of the range of science app category links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByUuid_C(String uuid,
		long companyId, int start, int end, OrderByComparator orderByComparator)
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

		List<ScienceAppCategoryLink> list = (List<ScienceAppCategoryLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceAppCategoryLink scienceAppCategoryLink : list) {
				if (!Validator.equals(uuid, scienceAppCategoryLink.getUuid()) ||
						(companyId != scienceAppCategoryLink.getCompanyId())) {
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

			query.append(_SQL_SELECT_SCIENCEAPPCATEGORYLINK_WHERE);

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
				query.append(ScienceAppCategoryLinkModelImpl.ORDER_BY_JPQL);
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
					list = (List<ScienceAppCategoryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppCategoryLink>(list);
				}
				else {
					list = (List<ScienceAppCategoryLink>)QueryUtil.list(q,
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
	 * Returns the first science app category link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink findByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (scienceAppCategoryLink != null) {
			return scienceAppCategoryLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryLinkException(msg.toString());
	}

	/**
	 * Returns the first science app category link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app category link, or <code>null</code> if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceAppCategoryLink> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app category link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink findByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (scienceAppCategoryLink != null) {
			return scienceAppCategoryLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryLinkException(msg.toString());
	}

	/**
	 * Returns the last science app category link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app category link, or <code>null</code> if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByUuid_C_Last(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ScienceAppCategoryLink> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science app category links before and after the current science app category link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param scienceAppCategoryLinkId the primary key of the current science app category link
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink[] findByUuid_C_PrevAndNext(
		long scienceAppCategoryLinkId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = findByPrimaryKey(scienceAppCategoryLinkId);

		Session session = null;

		try {
			session = openSession();

			ScienceAppCategoryLink[] array = new ScienceAppCategoryLinkImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, scienceAppCategoryLink,
					uuid, companyId, orderByComparator, true);

			array[1] = scienceAppCategoryLink;

			array[2] = getByUuid_C_PrevAndNext(session, scienceAppCategoryLink,
					uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceAppCategoryLink getByUuid_C_PrevAndNext(Session session,
		ScienceAppCategoryLink scienceAppCategoryLink, String uuid,
		long companyId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPPCATEGORYLINK_WHERE);

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
			query.append(ScienceAppCategoryLinkModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(scienceAppCategoryLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceAppCategoryLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science app category links where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (ScienceAppCategoryLink scienceAppCategoryLink : findByUuid_C(
				uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceAppCategoryLink);
		}
	}

	/**
	 * Returns the number of science app category links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching science app category links
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

			query.append(_SQL_COUNT_SCIENCEAPPCATEGORYLINK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "scienceAppCategoryLink.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "scienceAppCategoryLink.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(scienceAppCategoryLink.uuid IS NULL OR scienceAppCategoryLink.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "scienceAppCategoryLink.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID =
		new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryId",
			new String[] { Long.class.getName() },
			ScienceAppCategoryLinkModelImpl.CATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the science app category links where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByCategoryId(long categoryId)
		throws SystemException {
		return findByCategoryId(categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science app category links where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of science app category links
	 * @param end the upper bound of the range of science app category links (not inclusive)
	 * @return the range of matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByCategoryId(long categoryId,
		int start, int end) throws SystemException {
		return findByCategoryId(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app category links where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of science app category links
	 * @param end the upper bound of the range of science app category links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByCategoryId(long categoryId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { categoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID;
			finderArgs = new Object[] { categoryId, start, end, orderByComparator };
		}

		List<ScienceAppCategoryLink> list = (List<ScienceAppCategoryLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceAppCategoryLink scienceAppCategoryLink : list) {
				if ((categoryId != scienceAppCategoryLink.getCategoryId())) {
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

			query.append(_SQL_SELECT_SCIENCEAPPCATEGORYLINK_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppCategoryLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<ScienceAppCategoryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppCategoryLink>(list);
				}
				else {
					list = (List<ScienceAppCategoryLink>)QueryUtil.list(q,
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
	 * Returns the first science app category link in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink findByCategoryId_First(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = fetchByCategoryId_First(categoryId,
				orderByComparator);

		if (scienceAppCategoryLink != null) {
			return scienceAppCategoryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryLinkException(msg.toString());
	}

	/**
	 * Returns the first science app category link in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app category link, or <code>null</code> if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByCategoryId_First(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceAppCategoryLink> list = findByCategoryId(categoryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app category link in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink findByCategoryId_Last(long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = fetchByCategoryId_Last(categoryId,
				orderByComparator);

		if (scienceAppCategoryLink != null) {
			return scienceAppCategoryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryLinkException(msg.toString());
	}

	/**
	 * Returns the last science app category link in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app category link, or <code>null</code> if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByCategoryId_Last(long categoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategoryId(categoryId);

		if (count == 0) {
			return null;
		}

		List<ScienceAppCategoryLink> list = findByCategoryId(categoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science app category links before and after the current science app category link in the ordered set where categoryId = &#63;.
	 *
	 * @param scienceAppCategoryLinkId the primary key of the current science app category link
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink[] findByCategoryId_PrevAndNext(
		long scienceAppCategoryLinkId, long categoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = findByPrimaryKey(scienceAppCategoryLinkId);

		Session session = null;

		try {
			session = openSession();

			ScienceAppCategoryLink[] array = new ScienceAppCategoryLinkImpl[3];

			array[0] = getByCategoryId_PrevAndNext(session,
					scienceAppCategoryLink, categoryId, orderByComparator, true);

			array[1] = scienceAppCategoryLink;

			array[2] = getByCategoryId_PrevAndNext(session,
					scienceAppCategoryLink, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScienceAppCategoryLink getByCategoryId_PrevAndNext(
		Session session, ScienceAppCategoryLink scienceAppCategoryLink,
		long categoryId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPPCATEGORYLINK_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

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
			query.append(ScienceAppCategoryLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceAppCategoryLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceAppCategoryLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science app category links where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryId(long categoryId) throws SystemException {
		for (ScienceAppCategoryLink scienceAppCategoryLink : findByCategoryId(
				categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceAppCategoryLink);
		}
	}

	/**
	 * Returns the number of science app category links where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryId(long categoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYID;

		Object[] finderArgs = new Object[] { categoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPPCATEGORYLINK_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_CATEGORYID_CATEGORYID_2 = "scienceAppCategoryLink.categoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_APPID = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAppId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAppId",
			new String[] { Long.class.getName() },
			ScienceAppCategoryLinkModelImpl.SCIENCEAPPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_APPID = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAppId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the science app category links where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @return the matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByAppId(long scienceAppId)
		throws SystemException {
		return findByAppId(scienceAppId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the science app category links where scienceAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scienceAppId the science app ID
	 * @param start the lower bound of the range of science app category links
	 * @param end the upper bound of the range of science app category links (not inclusive)
	 * @return the range of matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByAppId(long scienceAppId,
		int start, int end) throws SystemException {
		return findByAppId(scienceAppId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app category links where scienceAppId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param scienceAppId the science app ID
	 * @param start the lower bound of the range of science app category links
	 * @param end the upper bound of the range of science app category links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByAppId(long scienceAppId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<ScienceAppCategoryLink> list = (List<ScienceAppCategoryLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceAppCategoryLink scienceAppCategoryLink : list) {
				if ((scienceAppId != scienceAppCategoryLink.getScienceAppId())) {
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

			query.append(_SQL_SELECT_SCIENCEAPPCATEGORYLINK_WHERE);

			query.append(_FINDER_COLUMN_APPID_SCIENCEAPPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppCategoryLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(scienceAppId);

				if (!pagination) {
					list = (List<ScienceAppCategoryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppCategoryLink>(list);
				}
				else {
					list = (List<ScienceAppCategoryLink>)QueryUtil.list(q,
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
	 * Returns the first science app category link in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink findByAppId_First(long scienceAppId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = fetchByAppId_First(scienceAppId,
				orderByComparator);

		if (scienceAppCategoryLink != null) {
			return scienceAppCategoryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scienceAppId=");
		msg.append(scienceAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryLinkException(msg.toString());
	}

	/**
	 * Returns the first science app category link in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app category link, or <code>null</code> if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByAppId_First(long scienceAppId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ScienceAppCategoryLink> list = findByAppId(scienceAppId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app category link in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink findByAppId_Last(long scienceAppId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = fetchByAppId_Last(scienceAppId,
				orderByComparator);

		if (scienceAppCategoryLink != null) {
			return scienceAppCategoryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("scienceAppId=");
		msg.append(scienceAppId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryLinkException(msg.toString());
	}

	/**
	 * Returns the last science app category link in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app category link, or <code>null</code> if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByAppId_Last(long scienceAppId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAppId(scienceAppId);

		if (count == 0) {
			return null;
		}

		List<ScienceAppCategoryLink> list = findByAppId(scienceAppId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science app category links before and after the current science app category link in the ordered set where scienceAppId = &#63;.
	 *
	 * @param scienceAppCategoryLinkId the primary key of the current science app category link
	 * @param scienceAppId the science app ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink[] findByAppId_PrevAndNext(
		long scienceAppCategoryLinkId, long scienceAppId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = findByPrimaryKey(scienceAppCategoryLinkId);

		Session session = null;

		try {
			session = openSession();

			ScienceAppCategoryLink[] array = new ScienceAppCategoryLinkImpl[3];

			array[0] = getByAppId_PrevAndNext(session, scienceAppCategoryLink,
					scienceAppId, orderByComparator, true);

			array[1] = scienceAppCategoryLink;

			array[2] = getByAppId_PrevAndNext(session, scienceAppCategoryLink,
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

	protected ScienceAppCategoryLink getByAppId_PrevAndNext(Session session,
		ScienceAppCategoryLink scienceAppCategoryLink, long scienceAppId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPPCATEGORYLINK_WHERE);

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
			query.append(ScienceAppCategoryLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(scienceAppId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceAppCategoryLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceAppCategoryLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science app category links where scienceAppId = &#63; from the database.
	 *
	 * @param scienceAppId the science app ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAppId(long scienceAppId) throws SystemException {
		for (ScienceAppCategoryLink scienceAppCategoryLink : findByAppId(
				scienceAppId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceAppCategoryLink);
		}
	}

	/**
	 * Returns the number of science app category links where scienceAppId = &#63;.
	 *
	 * @param scienceAppId the science app ID
	 * @return the number of matching science app category links
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

			query.append(_SQL_COUNT_SCIENCEAPPCATEGORYLINK_WHERE);

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

	private static final String _FINDER_COLUMN_APPID_SCIENCEAPPID_2 = "scienceAppCategoryLink.scienceAppId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTCATEGORYID =
		new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentCategoryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTCATEGORYID =
		new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentCategoryId", new String[] { Long.class.getName() },
			ScienceAppCategoryLinkModelImpl.PARENTCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTCATEGORYID = new FinderPath(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentCategoryId", new String[] { Long.class.getName() });

	/**
	 * Returns all the science app category links where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @return the matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByParentCategoryId(
		long parentCategoryId) throws SystemException {
		return findByParentCategoryId(parentCategoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science app category links where parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of science app category links
	 * @param end the upper bound of the range of science app category links (not inclusive)
	 * @return the range of matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByParentCategoryId(
		long parentCategoryId, int start, int end) throws SystemException {
		return findByParentCategoryId(parentCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app category links where parentCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentCategoryId the parent category ID
	 * @param start the lower bound of the range of science app category links
	 * @param end the upper bound of the range of science app category links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findByParentCategoryId(
		long parentCategoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTCATEGORYID;
			finderArgs = new Object[] { parentCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTCATEGORYID;
			finderArgs = new Object[] {
					parentCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<ScienceAppCategoryLink> list = (List<ScienceAppCategoryLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ScienceAppCategoryLink scienceAppCategoryLink : list) {
				if ((parentCategoryId != scienceAppCategoryLink.getParentCategoryId())) {
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

			query.append(_SQL_SELECT_SCIENCEAPPCATEGORYLINK_WHERE);

			query.append(_FINDER_COLUMN_PARENTCATEGORYID_PARENTCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ScienceAppCategoryLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentCategoryId);

				if (!pagination) {
					list = (List<ScienceAppCategoryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppCategoryLink>(list);
				}
				else {
					list = (List<ScienceAppCategoryLink>)QueryUtil.list(q,
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
	 * Returns the first science app category link in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink findByParentCategoryId_First(
		long parentCategoryId, OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = fetchByParentCategoryId_First(parentCategoryId,
				orderByComparator);

		if (scienceAppCategoryLink != null) {
			return scienceAppCategoryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentCategoryId=");
		msg.append(parentCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryLinkException(msg.toString());
	}

	/**
	 * Returns the first science app category link in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching science app category link, or <code>null</code> if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByParentCategoryId_First(
		long parentCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<ScienceAppCategoryLink> list = findByParentCategoryId(parentCategoryId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last science app category link in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink findByParentCategoryId_Last(
		long parentCategoryId, OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = fetchByParentCategoryId_Last(parentCategoryId,
				orderByComparator);

		if (scienceAppCategoryLink != null) {
			return scienceAppCategoryLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentCategoryId=");
		msg.append(parentCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryLinkException(msg.toString());
	}

	/**
	 * Returns the last science app category link in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching science app category link, or <code>null</code> if a matching science app category link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByParentCategoryId_Last(
		long parentCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByParentCategoryId(parentCategoryId);

		if (count == 0) {
			return null;
		}

		List<ScienceAppCategoryLink> list = findByParentCategoryId(parentCategoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the science app category links before and after the current science app category link in the ordered set where parentCategoryId = &#63;.
	 *
	 * @param scienceAppCategoryLinkId the primary key of the current science app category link
	 * @param parentCategoryId the parent category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink[] findByParentCategoryId_PrevAndNext(
		long scienceAppCategoryLinkId, long parentCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = findByPrimaryKey(scienceAppCategoryLinkId);

		Session session = null;

		try {
			session = openSession();

			ScienceAppCategoryLink[] array = new ScienceAppCategoryLinkImpl[3];

			array[0] = getByParentCategoryId_PrevAndNext(session,
					scienceAppCategoryLink, parentCategoryId,
					orderByComparator, true);

			array[1] = scienceAppCategoryLink;

			array[2] = getByParentCategoryId_PrevAndNext(session,
					scienceAppCategoryLink, parentCategoryId,
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

	protected ScienceAppCategoryLink getByParentCategoryId_PrevAndNext(
		Session session, ScienceAppCategoryLink scienceAppCategoryLink,
		long parentCategoryId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SCIENCEAPPCATEGORYLINK_WHERE);

		query.append(_FINDER_COLUMN_PARENTCATEGORYID_PARENTCATEGORYID_2);

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
			query.append(ScienceAppCategoryLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(scienceAppCategoryLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ScienceAppCategoryLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the science app category links where parentCategoryId = &#63; from the database.
	 *
	 * @param parentCategoryId the parent category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentCategoryId(long parentCategoryId)
		throws SystemException {
		for (ScienceAppCategoryLink scienceAppCategoryLink : findByParentCategoryId(
				parentCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(scienceAppCategoryLink);
		}
	}

	/**
	 * Returns the number of science app category links where parentCategoryId = &#63;.
	 *
	 * @param parentCategoryId the parent category ID
	 * @return the number of matching science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentCategoryId(long parentCategoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTCATEGORYID;

		Object[] finderArgs = new Object[] { parentCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SCIENCEAPPCATEGORYLINK_WHERE);

			query.append(_FINDER_COLUMN_PARENTCATEGORYID_PARENTCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentCategoryId);

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

	private static final String _FINDER_COLUMN_PARENTCATEGORYID_PARENTCATEGORYID_2 =
		"scienceAppCategoryLink.parentCategoryId = ?";

	public ScienceAppCategoryLinkPersistenceImpl() {
		setModelClass(ScienceAppCategoryLink.class);
	}

	/**
	 * Caches the science app category link in the entity cache if it is enabled.
	 *
	 * @param scienceAppCategoryLink the science app category link
	 */
	@Override
	public void cacheResult(ScienceAppCategoryLink scienceAppCategoryLink) {
		EntityCacheUtil.putResult(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			scienceAppCategoryLink.getPrimaryKey(), scienceAppCategoryLink);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] {
				scienceAppCategoryLink.getUuid(),
				scienceAppCategoryLink.getGroupId()
			}, scienceAppCategoryLink);

		scienceAppCategoryLink.resetOriginalValues();
	}

	/**
	 * Caches the science app category links in the entity cache if it is enabled.
	 *
	 * @param scienceAppCategoryLinks the science app category links
	 */
	@Override
	public void cacheResult(
		List<ScienceAppCategoryLink> scienceAppCategoryLinks) {
		for (ScienceAppCategoryLink scienceAppCategoryLink : scienceAppCategoryLinks) {
			if (EntityCacheUtil.getResult(
						ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppCategoryLinkImpl.class,
						scienceAppCategoryLink.getPrimaryKey()) == null) {
				cacheResult(scienceAppCategoryLink);
			}
			else {
				scienceAppCategoryLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all science app category links.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ScienceAppCategoryLinkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ScienceAppCategoryLinkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the science app category link.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScienceAppCategoryLink scienceAppCategoryLink) {
		EntityCacheUtil.removeResult(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			scienceAppCategoryLink.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(scienceAppCategoryLink);
	}

	@Override
	public void clearCache(List<ScienceAppCategoryLink> scienceAppCategoryLinks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ScienceAppCategoryLink scienceAppCategoryLink : scienceAppCategoryLinks) {
			EntityCacheUtil.removeResult(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppCategoryLinkImpl.class,
				scienceAppCategoryLink.getPrimaryKey());

			clearUniqueFindersCache(scienceAppCategoryLink);
		}
	}

	protected void cacheUniqueFindersCache(
		ScienceAppCategoryLink scienceAppCategoryLink) {
		if (scienceAppCategoryLink.isNew()) {
			Object[] args = new Object[] {
					scienceAppCategoryLink.getUuid(),
					scienceAppCategoryLink.getGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				scienceAppCategoryLink);
		}
		else {
			ScienceAppCategoryLinkModelImpl scienceAppCategoryLinkModelImpl = (ScienceAppCategoryLinkModelImpl)scienceAppCategoryLink;

			if ((scienceAppCategoryLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppCategoryLink.getUuid(),
						scienceAppCategoryLink.getGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					scienceAppCategoryLink);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ScienceAppCategoryLink scienceAppCategoryLink) {
		ScienceAppCategoryLinkModelImpl scienceAppCategoryLinkModelImpl = (ScienceAppCategoryLinkModelImpl)scienceAppCategoryLink;

		Object[] args = new Object[] {
				scienceAppCategoryLink.getUuid(),
				scienceAppCategoryLink.getGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((scienceAppCategoryLinkModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					scienceAppCategoryLinkModelImpl.getOriginalUuid(),
					scienceAppCategoryLinkModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new science app category link with the primary key. Does not add the science app category link to the database.
	 *
	 * @param scienceAppCategoryLinkId the primary key for the new science app category link
	 * @return the new science app category link
	 */
	@Override
	public ScienceAppCategoryLink create(long scienceAppCategoryLinkId) {
		ScienceAppCategoryLink scienceAppCategoryLink = new ScienceAppCategoryLinkImpl();

		scienceAppCategoryLink.setNew(true);
		scienceAppCategoryLink.setPrimaryKey(scienceAppCategoryLinkId);

		String uuid = PortalUUIDUtil.generate();

		scienceAppCategoryLink.setUuid(uuid);

		return scienceAppCategoryLink;
	}

	/**
	 * Removes the science app category link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scienceAppCategoryLinkId the primary key of the science app category link
	 * @return the science app category link that was removed
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink remove(long scienceAppCategoryLinkId)
		throws NoSuchCategoryLinkException, SystemException {
		return remove((Serializable)scienceAppCategoryLinkId);
	}

	/**
	 * Removes the science app category link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the science app category link
	 * @return the science app category link that was removed
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink remove(Serializable primaryKey)
		throws NoSuchCategoryLinkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ScienceAppCategoryLink scienceAppCategoryLink = (ScienceAppCategoryLink)session.get(ScienceAppCategoryLinkImpl.class,
					primaryKey);

			if (scienceAppCategoryLink == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(scienceAppCategoryLink);
		}
		catch (NoSuchCategoryLinkException nsee) {
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
	protected ScienceAppCategoryLink removeImpl(
		ScienceAppCategoryLink scienceAppCategoryLink)
		throws SystemException {
		scienceAppCategoryLink = toUnwrappedModel(scienceAppCategoryLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scienceAppCategoryLink)) {
				scienceAppCategoryLink = (ScienceAppCategoryLink)session.get(ScienceAppCategoryLinkImpl.class,
						scienceAppCategoryLink.getPrimaryKeyObj());
			}

			if (scienceAppCategoryLink != null) {
				session.delete(scienceAppCategoryLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (scienceAppCategoryLink != null) {
			clearCache(scienceAppCategoryLink);
		}

		return scienceAppCategoryLink;
	}

	@Override
	public ScienceAppCategoryLink updateImpl(
		com.kisti.science.platform.app.model.ScienceAppCategoryLink scienceAppCategoryLink)
		throws SystemException {
		scienceAppCategoryLink = toUnwrappedModel(scienceAppCategoryLink);

		boolean isNew = scienceAppCategoryLink.isNew();

		ScienceAppCategoryLinkModelImpl scienceAppCategoryLinkModelImpl = (ScienceAppCategoryLinkModelImpl)scienceAppCategoryLink;

		if (Validator.isNull(scienceAppCategoryLink.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			scienceAppCategoryLink.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (scienceAppCategoryLink.isNew()) {
				session.save(scienceAppCategoryLink);

				scienceAppCategoryLink.setNew(false);
			}
			else {
				session.merge(scienceAppCategoryLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ScienceAppCategoryLinkModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((scienceAppCategoryLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppCategoryLinkModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { scienceAppCategoryLinkModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((scienceAppCategoryLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppCategoryLinkModelImpl.getOriginalUuid(),
						scienceAppCategoryLinkModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						scienceAppCategoryLinkModelImpl.getUuid(),
						scienceAppCategoryLinkModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((scienceAppCategoryLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppCategoryLinkModelImpl.getOriginalCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);

				args = new Object[] {
						scienceAppCategoryLinkModelImpl.getCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
					args);
			}

			if ((scienceAppCategoryLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppCategoryLinkModelImpl.getOriginalScienceAppId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID,
					args);

				args = new Object[] {
						scienceAppCategoryLinkModelImpl.getScienceAppId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_APPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_APPID,
					args);
			}

			if ((scienceAppCategoryLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						scienceAppCategoryLinkModelImpl.getOriginalParentCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTCATEGORYID,
					args);

				args = new Object[] {
						scienceAppCategoryLinkModelImpl.getParentCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTCATEGORYID,
					args);
			}
		}

		EntityCacheUtil.putResult(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
			ScienceAppCategoryLinkImpl.class,
			scienceAppCategoryLink.getPrimaryKey(), scienceAppCategoryLink);

		clearUniqueFindersCache(scienceAppCategoryLink);
		cacheUniqueFindersCache(scienceAppCategoryLink);

		return scienceAppCategoryLink;
	}

	protected ScienceAppCategoryLink toUnwrappedModel(
		ScienceAppCategoryLink scienceAppCategoryLink) {
		if (scienceAppCategoryLink instanceof ScienceAppCategoryLinkImpl) {
			return scienceAppCategoryLink;
		}

		ScienceAppCategoryLinkImpl scienceAppCategoryLinkImpl = new ScienceAppCategoryLinkImpl();

		scienceAppCategoryLinkImpl.setNew(scienceAppCategoryLink.isNew());
		scienceAppCategoryLinkImpl.setPrimaryKey(scienceAppCategoryLink.getPrimaryKey());

		scienceAppCategoryLinkImpl.setUuid(scienceAppCategoryLink.getUuid());
		scienceAppCategoryLinkImpl.setScienceAppCategoryLinkId(scienceAppCategoryLink.getScienceAppCategoryLinkId());
		scienceAppCategoryLinkImpl.setGroupId(scienceAppCategoryLink.getGroupId());
		scienceAppCategoryLinkImpl.setCompanyId(scienceAppCategoryLink.getCompanyId());
		scienceAppCategoryLinkImpl.setUserId(scienceAppCategoryLink.getUserId());
		scienceAppCategoryLinkImpl.setCreateDate(scienceAppCategoryLink.getCreateDate());
		scienceAppCategoryLinkImpl.setModifiedDate(scienceAppCategoryLink.getModifiedDate());
		scienceAppCategoryLinkImpl.setCategoryId(scienceAppCategoryLink.getCategoryId());
		scienceAppCategoryLinkImpl.setScienceAppId(scienceAppCategoryLink.getScienceAppId());
		scienceAppCategoryLinkImpl.setParentCategoryId(scienceAppCategoryLink.getParentCategoryId());

		return scienceAppCategoryLinkImpl;
	}

	/**
	 * Returns the science app category link with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app category link
	 * @return the science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCategoryLinkException, SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = fetchByPrimaryKey(primaryKey);

		if (scienceAppCategoryLink == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCategoryLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return scienceAppCategoryLink;
	}

	/**
	 * Returns the science app category link with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchCategoryLinkException} if it could not be found.
	 *
	 * @param scienceAppCategoryLinkId the primary key of the science app category link
	 * @return the science app category link
	 * @throws com.kisti.science.platform.app.NoSuchCategoryLinkException if a science app category link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink findByPrimaryKey(
		long scienceAppCategoryLinkId)
		throws NoSuchCategoryLinkException, SystemException {
		return findByPrimaryKey((Serializable)scienceAppCategoryLinkId);
	}

	/**
	 * Returns the science app category link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the science app category link
	 * @return the science app category link, or <code>null</code> if a science app category link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ScienceAppCategoryLink scienceAppCategoryLink = (ScienceAppCategoryLink)EntityCacheUtil.getResult(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
				ScienceAppCategoryLinkImpl.class, primaryKey);

		if (scienceAppCategoryLink == _nullScienceAppCategoryLink) {
			return null;
		}

		if (scienceAppCategoryLink == null) {
			Session session = null;

			try {
				session = openSession();

				scienceAppCategoryLink = (ScienceAppCategoryLink)session.get(ScienceAppCategoryLinkImpl.class,
						primaryKey);

				if (scienceAppCategoryLink != null) {
					cacheResult(scienceAppCategoryLink);
				}
				else {
					EntityCacheUtil.putResult(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
						ScienceAppCategoryLinkImpl.class, primaryKey,
						_nullScienceAppCategoryLink);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ScienceAppCategoryLinkModelImpl.ENTITY_CACHE_ENABLED,
					ScienceAppCategoryLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return scienceAppCategoryLink;
	}

	/**
	 * Returns the science app category link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scienceAppCategoryLinkId the primary key of the science app category link
	 * @return the science app category link, or <code>null</code> if a science app category link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ScienceAppCategoryLink fetchByPrimaryKey(
		long scienceAppCategoryLinkId) throws SystemException {
		return fetchByPrimaryKey((Serializable)scienceAppCategoryLinkId);
	}

	/**
	 * Returns all the science app category links.
	 *
	 * @return the science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the science app category links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science app category links
	 * @param end the upper bound of the range of science app category links (not inclusive)
	 * @return the range of science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the science app category links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.ScienceAppCategoryLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of science app category links
	 * @param end the upper bound of the range of science app category links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of science app category links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ScienceAppCategoryLink> findAll(int start, int end,
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

		List<ScienceAppCategoryLink> list = (List<ScienceAppCategoryLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SCIENCEAPPCATEGORYLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SCIENCEAPPCATEGORYLINK;

				if (pagination) {
					sql = sql.concat(ScienceAppCategoryLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ScienceAppCategoryLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ScienceAppCategoryLink>(list);
				}
				else {
					list = (List<ScienceAppCategoryLink>)QueryUtil.list(q,
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
	 * Removes all the science app category links from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ScienceAppCategoryLink scienceAppCategoryLink : findAll()) {
			remove(scienceAppCategoryLink);
		}
	}

	/**
	 * Returns the number of science app category links.
	 *
	 * @return the number of science app category links
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

				Query q = session.createQuery(_SQL_COUNT_SCIENCEAPPCATEGORYLINK);

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
	 * Initializes the science app category link persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kisti.science.platform.app.model.ScienceAppCategoryLink")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ScienceAppCategoryLink>> listenersList = new ArrayList<ModelListener<ScienceAppCategoryLink>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ScienceAppCategoryLink>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ScienceAppCategoryLinkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SCIENCEAPPCATEGORYLINK = "SELECT scienceAppCategoryLink FROM ScienceAppCategoryLink scienceAppCategoryLink";
	private static final String _SQL_SELECT_SCIENCEAPPCATEGORYLINK_WHERE = "SELECT scienceAppCategoryLink FROM ScienceAppCategoryLink scienceAppCategoryLink WHERE ";
	private static final String _SQL_COUNT_SCIENCEAPPCATEGORYLINK = "SELECT COUNT(scienceAppCategoryLink) FROM ScienceAppCategoryLink scienceAppCategoryLink";
	private static final String _SQL_COUNT_SCIENCEAPPCATEGORYLINK_WHERE = "SELECT COUNT(scienceAppCategoryLink) FROM ScienceAppCategoryLink scienceAppCategoryLink WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "scienceAppCategoryLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ScienceAppCategoryLink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ScienceAppCategoryLink exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ScienceAppCategoryLinkPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static ScienceAppCategoryLink _nullScienceAppCategoryLink = new ScienceAppCategoryLinkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ScienceAppCategoryLink> toCacheModel() {
				return _nullScienceAppCategoryLinkCacheModel;
			}
		};

	private static CacheModel<ScienceAppCategoryLink> _nullScienceAppCategoryLinkCacheModel =
		new CacheModel<ScienceAppCategoryLink>() {
			@Override
			public ScienceAppCategoryLink toEntityModel() {
				return _nullScienceAppCategoryLink;
			}
		};
}