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

import com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException;
import com.kisti.science.platform.app.model.PortTypeAnalyzerLink;
import com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkImpl;
import com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl;

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
 * The persistence implementation for the port type analyzer link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeAnalyzerLinkPersistence
 * @see PortTypeAnalyzerLinkUtil
 * @generated
 */
public class PortTypeAnalyzerLinkPersistenceImpl extends BasePersistenceImpl<PortTypeAnalyzerLink>
	implements PortTypeAnalyzerLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PortTypeAnalyzerLinkUtil} to access the port type analyzer link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PortTypeAnalyzerLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeAnalyzerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeAnalyzerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeAnalyzerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeAnalyzerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PortTypeAnalyzerLinkModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the port type analyzer links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching port type analyzer links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeAnalyzerLink> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the port type analyzer links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of port type analyzer links
	 * @param end the upper bound of the range of port type analyzer links (not inclusive)
	 * @return the range of matching port type analyzer links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeAnalyzerLink> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the port type analyzer links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of port type analyzer links
	 * @param end the upper bound of the range of port type analyzer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching port type analyzer links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeAnalyzerLink> findByUuid(String uuid, int start,
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

		List<PortTypeAnalyzerLink> list = (List<PortTypeAnalyzerLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortTypeAnalyzerLink portTypeAnalyzerLink : list) {
				if (!Validator.equals(uuid, portTypeAnalyzerLink.getUuid())) {
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

			query.append(_SQL_SELECT_PORTTYPEANALYZERLINK_WHERE);

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
				query.append(PortTypeAnalyzerLinkModelImpl.ORDER_BY_JPQL);
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
					list = (List<PortTypeAnalyzerLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PortTypeAnalyzerLink>(list);
				}
				else {
					list = (List<PortTypeAnalyzerLink>)QueryUtil.list(q,
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
	 * Returns the first port type analyzer link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching port type analyzer link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeAnalyzerLinkException, SystemException {
		PortTypeAnalyzerLink portTypeAnalyzerLink = fetchByUuid_First(uuid,
				orderByComparator);

		if (portTypeAnalyzerLink != null) {
			return portTypeAnalyzerLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortTypeAnalyzerLinkException(msg.toString());
	}

	/**
	 * Returns the first port type analyzer link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<PortTypeAnalyzerLink> list = findByUuid(uuid, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last port type analyzer link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching port type analyzer link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeAnalyzerLinkException, SystemException {
		PortTypeAnalyzerLink portTypeAnalyzerLink = fetchByUuid_Last(uuid,
				orderByComparator);

		if (portTypeAnalyzerLink != null) {
			return portTypeAnalyzerLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortTypeAnalyzerLinkException(msg.toString());
	}

	/**
	 * Returns the last port type analyzer link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PortTypeAnalyzerLink> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the port type analyzer links before and after the current port type analyzer link in the ordered set where uuid = &#63;.
	 *
	 * @param portTypeAnalyzerLinkId the primary key of the current port type analyzer link
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next port type analyzer link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink[] findByUuid_PrevAndNext(
		long portTypeAnalyzerLinkId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeAnalyzerLinkException, SystemException {
		PortTypeAnalyzerLink portTypeAnalyzerLink = findByPrimaryKey(portTypeAnalyzerLinkId);

		Session session = null;

		try {
			session = openSession();

			PortTypeAnalyzerLink[] array = new PortTypeAnalyzerLinkImpl[3];

			array[0] = getByUuid_PrevAndNext(session, portTypeAnalyzerLink,
					uuid, orderByComparator, true);

			array[1] = portTypeAnalyzerLink;

			array[2] = getByUuid_PrevAndNext(session, portTypeAnalyzerLink,
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

	protected PortTypeAnalyzerLink getByUuid_PrevAndNext(Session session,
		PortTypeAnalyzerLink portTypeAnalyzerLink, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTTYPEANALYZERLINK_WHERE);

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
			query.append(PortTypeAnalyzerLinkModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(portTypeAnalyzerLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortTypeAnalyzerLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the port type analyzer links where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (PortTypeAnalyzerLink portTypeAnalyzerLink : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(portTypeAnalyzerLink);
		}
	}

	/**
	 * Returns the number of port type analyzer links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching port type analyzer links
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

			query.append(_SQL_COUNT_PORTTYPEANALYZERLINK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "portTypeAnalyzerLink.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "portTypeAnalyzerLink.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(portTypeAnalyzerLink.uuid IS NULL OR portTypeAnalyzerLink.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeAnalyzerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeAnalyzerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PortTypeAnalyzerLinkModelImpl.UUID_COLUMN_BITMASK |
			PortTypeAnalyzerLinkModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the port type analyzer links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching port type analyzer links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeAnalyzerLink> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the port type analyzer links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of port type analyzer links
	 * @param end the upper bound of the range of port type analyzer links (not inclusive)
	 * @return the range of matching port type analyzer links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeAnalyzerLink> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the port type analyzer links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of port type analyzer links
	 * @param end the upper bound of the range of port type analyzer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching port type analyzer links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeAnalyzerLink> findByUuid_C(String uuid, long companyId,
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

		List<PortTypeAnalyzerLink> list = (List<PortTypeAnalyzerLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortTypeAnalyzerLink portTypeAnalyzerLink : list) {
				if (!Validator.equals(uuid, portTypeAnalyzerLink.getUuid()) ||
						(companyId != portTypeAnalyzerLink.getCompanyId())) {
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

			query.append(_SQL_SELECT_PORTTYPEANALYZERLINK_WHERE);

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
				query.append(PortTypeAnalyzerLinkModelImpl.ORDER_BY_JPQL);
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
					list = (List<PortTypeAnalyzerLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PortTypeAnalyzerLink>(list);
				}
				else {
					list = (List<PortTypeAnalyzerLink>)QueryUtil.list(q,
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
	 * Returns the first port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching port type analyzer link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeAnalyzerLinkException, SystemException {
		PortTypeAnalyzerLink portTypeAnalyzerLink = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (portTypeAnalyzerLink != null) {
			return portTypeAnalyzerLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortTypeAnalyzerLinkException(msg.toString());
	}

	/**
	 * Returns the first port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink fetchByUuid_C_First(String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws SystemException {
		List<PortTypeAnalyzerLink> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching port type analyzer link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeAnalyzerLinkException, SystemException {
		PortTypeAnalyzerLink portTypeAnalyzerLink = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (portTypeAnalyzerLink != null) {
			return portTypeAnalyzerLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortTypeAnalyzerLinkException(msg.toString());
	}

	/**
	 * Returns the last port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PortTypeAnalyzerLink> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the port type analyzer links before and after the current port type analyzer link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param portTypeAnalyzerLinkId the primary key of the current port type analyzer link
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next port type analyzer link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink[] findByUuid_C_PrevAndNext(
		long portTypeAnalyzerLinkId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeAnalyzerLinkException, SystemException {
		PortTypeAnalyzerLink portTypeAnalyzerLink = findByPrimaryKey(portTypeAnalyzerLinkId);

		Session session = null;

		try {
			session = openSession();

			PortTypeAnalyzerLink[] array = new PortTypeAnalyzerLinkImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, portTypeAnalyzerLink,
					uuid, companyId, orderByComparator, true);

			array[1] = portTypeAnalyzerLink;

			array[2] = getByUuid_C_PrevAndNext(session, portTypeAnalyzerLink,
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

	protected PortTypeAnalyzerLink getByUuid_C_PrevAndNext(Session session,
		PortTypeAnalyzerLink portTypeAnalyzerLink, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTTYPEANALYZERLINK_WHERE);

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
			query.append(PortTypeAnalyzerLinkModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(portTypeAnalyzerLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortTypeAnalyzerLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the port type analyzer links where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (PortTypeAnalyzerLink portTypeAnalyzerLink : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(portTypeAnalyzerLink);
		}
	}

	/**
	 * Returns the number of port type analyzer links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching port type analyzer links
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

			query.append(_SQL_COUNT_PORTTYPEANALYZERLINK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "portTypeAnalyzerLink.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "portTypeAnalyzerLink.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(portTypeAnalyzerLink.uuid IS NULL OR portTypeAnalyzerLink.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "portTypeAnalyzerLink.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PORTTYPEID =
		new FinderPath(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeAnalyzerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPortTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTTYPEID =
		new FinderPath(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeAnalyzerLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPortTypeId",
			new String[] { Long.class.getName() },
			PortTypeAnalyzerLinkModelImpl.PORTTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORTTYPEID = new FinderPath(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPortTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the port type analyzer links where portTypeId = &#63;.
	 *
	 * @param portTypeId the port type ID
	 * @return the matching port type analyzer links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeAnalyzerLink> findByPortTypeId(long portTypeId)
		throws SystemException {
		return findByPortTypeId(portTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the port type analyzer links where portTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param portTypeId the port type ID
	 * @param start the lower bound of the range of port type analyzer links
	 * @param end the upper bound of the range of port type analyzer links (not inclusive)
	 * @return the range of matching port type analyzer links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeAnalyzerLink> findByPortTypeId(long portTypeId,
		int start, int end) throws SystemException {
		return findByPortTypeId(portTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the port type analyzer links where portTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param portTypeId the port type ID
	 * @param start the lower bound of the range of port type analyzer links
	 * @param end the upper bound of the range of port type analyzer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching port type analyzer links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeAnalyzerLink> findByPortTypeId(long portTypeId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTTYPEID;
			finderArgs = new Object[] { portTypeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PORTTYPEID;
			finderArgs = new Object[] { portTypeId, start, end, orderByComparator };
		}

		List<PortTypeAnalyzerLink> list = (List<PortTypeAnalyzerLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortTypeAnalyzerLink portTypeAnalyzerLink : list) {
				if ((portTypeId != portTypeAnalyzerLink.getPortTypeId())) {
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

			query.append(_SQL_SELECT_PORTTYPEANALYZERLINK_WHERE);

			query.append(_FINDER_COLUMN_PORTTYPEID_PORTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PortTypeAnalyzerLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(portTypeId);

				if (!pagination) {
					list = (List<PortTypeAnalyzerLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PortTypeAnalyzerLink>(list);
				}
				else {
					list = (List<PortTypeAnalyzerLink>)QueryUtil.list(q,
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
	 * Returns the first port type analyzer link in the ordered set where portTypeId = &#63;.
	 *
	 * @param portTypeId the port type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching port type analyzer link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink findByPortTypeId_First(long portTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeAnalyzerLinkException, SystemException {
		PortTypeAnalyzerLink portTypeAnalyzerLink = fetchByPortTypeId_First(portTypeId,
				orderByComparator);

		if (portTypeAnalyzerLink != null) {
			return portTypeAnalyzerLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("portTypeId=");
		msg.append(portTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortTypeAnalyzerLinkException(msg.toString());
	}

	/**
	 * Returns the first port type analyzer link in the ordered set where portTypeId = &#63;.
	 *
	 * @param portTypeId the port type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink fetchByPortTypeId_First(long portTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PortTypeAnalyzerLink> list = findByPortTypeId(portTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last port type analyzer link in the ordered set where portTypeId = &#63;.
	 *
	 * @param portTypeId the port type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching port type analyzer link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a matching port type analyzer link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink findByPortTypeId_Last(long portTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeAnalyzerLinkException, SystemException {
		PortTypeAnalyzerLink portTypeAnalyzerLink = fetchByPortTypeId_Last(portTypeId,
				orderByComparator);

		if (portTypeAnalyzerLink != null) {
			return portTypeAnalyzerLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("portTypeId=");
		msg.append(portTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortTypeAnalyzerLinkException(msg.toString());
	}

	/**
	 * Returns the last port type analyzer link in the ordered set where portTypeId = &#63;.
	 *
	 * @param portTypeId the port type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching port type analyzer link, or <code>null</code> if a matching port type analyzer link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink fetchByPortTypeId_Last(long portTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPortTypeId(portTypeId);

		if (count == 0) {
			return null;
		}

		List<PortTypeAnalyzerLink> list = findByPortTypeId(portTypeId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the port type analyzer links before and after the current port type analyzer link in the ordered set where portTypeId = &#63;.
	 *
	 * @param portTypeAnalyzerLinkId the primary key of the current port type analyzer link
	 * @param portTypeId the port type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next port type analyzer link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink[] findByPortTypeId_PrevAndNext(
		long portTypeAnalyzerLinkId, long portTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeAnalyzerLinkException, SystemException {
		PortTypeAnalyzerLink portTypeAnalyzerLink = findByPrimaryKey(portTypeAnalyzerLinkId);

		Session session = null;

		try {
			session = openSession();

			PortTypeAnalyzerLink[] array = new PortTypeAnalyzerLinkImpl[3];

			array[0] = getByPortTypeId_PrevAndNext(session,
					portTypeAnalyzerLink, portTypeId, orderByComparator, true);

			array[1] = portTypeAnalyzerLink;

			array[2] = getByPortTypeId_PrevAndNext(session,
					portTypeAnalyzerLink, portTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortTypeAnalyzerLink getByPortTypeId_PrevAndNext(
		Session session, PortTypeAnalyzerLink portTypeAnalyzerLink,
		long portTypeId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTTYPEANALYZERLINK_WHERE);

		query.append(_FINDER_COLUMN_PORTTYPEID_PORTTYPEID_2);

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
			query.append(PortTypeAnalyzerLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(portTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portTypeAnalyzerLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortTypeAnalyzerLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the port type analyzer links where portTypeId = &#63; from the database.
	 *
	 * @param portTypeId the port type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPortTypeId(long portTypeId) throws SystemException {
		for (PortTypeAnalyzerLink portTypeAnalyzerLink : findByPortTypeId(
				portTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(portTypeAnalyzerLink);
		}
	}

	/**
	 * Returns the number of port type analyzer links where portTypeId = &#63;.
	 *
	 * @param portTypeId the port type ID
	 * @return the number of matching port type analyzer links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPortTypeId(long portTypeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PORTTYPEID;

		Object[] finderArgs = new Object[] { portTypeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PORTTYPEANALYZERLINK_WHERE);

			query.append(_FINDER_COLUMN_PORTTYPEID_PORTTYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(portTypeId);

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

	private static final String _FINDER_COLUMN_PORTTYPEID_PORTTYPEID_2 = "portTypeAnalyzerLink.portTypeId = ?";

	public PortTypeAnalyzerLinkPersistenceImpl() {
		setModelClass(PortTypeAnalyzerLink.class);
	}

	/**
	 * Caches the port type analyzer link in the entity cache if it is enabled.
	 *
	 * @param portTypeAnalyzerLink the port type analyzer link
	 */
	@Override
	public void cacheResult(PortTypeAnalyzerLink portTypeAnalyzerLink) {
		EntityCacheUtil.putResult(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkImpl.class,
			portTypeAnalyzerLink.getPrimaryKey(), portTypeAnalyzerLink);

		portTypeAnalyzerLink.resetOriginalValues();
	}

	/**
	 * Caches the port type analyzer links in the entity cache if it is enabled.
	 *
	 * @param portTypeAnalyzerLinks the port type analyzer links
	 */
	@Override
	public void cacheResult(List<PortTypeAnalyzerLink> portTypeAnalyzerLinks) {
		for (PortTypeAnalyzerLink portTypeAnalyzerLink : portTypeAnalyzerLinks) {
			if (EntityCacheUtil.getResult(
						PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
						PortTypeAnalyzerLinkImpl.class,
						portTypeAnalyzerLink.getPrimaryKey()) == null) {
				cacheResult(portTypeAnalyzerLink);
			}
			else {
				portTypeAnalyzerLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all port type analyzer links.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PortTypeAnalyzerLinkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PortTypeAnalyzerLinkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the port type analyzer link.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PortTypeAnalyzerLink portTypeAnalyzerLink) {
		EntityCacheUtil.removeResult(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkImpl.class, portTypeAnalyzerLink.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PortTypeAnalyzerLink> portTypeAnalyzerLinks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PortTypeAnalyzerLink portTypeAnalyzerLink : portTypeAnalyzerLinks) {
			EntityCacheUtil.removeResult(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
				PortTypeAnalyzerLinkImpl.class,
				portTypeAnalyzerLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new port type analyzer link with the primary key. Does not add the port type analyzer link to the database.
	 *
	 * @param portTypeAnalyzerLinkId the primary key for the new port type analyzer link
	 * @return the new port type analyzer link
	 */
	@Override
	public PortTypeAnalyzerLink create(long portTypeAnalyzerLinkId) {
		PortTypeAnalyzerLink portTypeAnalyzerLink = new PortTypeAnalyzerLinkImpl();

		portTypeAnalyzerLink.setNew(true);
		portTypeAnalyzerLink.setPrimaryKey(portTypeAnalyzerLinkId);

		String uuid = PortalUUIDUtil.generate();

		portTypeAnalyzerLink.setUuid(uuid);

		return portTypeAnalyzerLink;
	}

	/**
	 * Removes the port type analyzer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portTypeAnalyzerLinkId the primary key of the port type analyzer link
	 * @return the port type analyzer link that was removed
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink remove(long portTypeAnalyzerLinkId)
		throws NoSuchPortTypeAnalyzerLinkException, SystemException {
		return remove((Serializable)portTypeAnalyzerLinkId);
	}

	/**
	 * Removes the port type analyzer link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the port type analyzer link
	 * @return the port type analyzer link that was removed
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink remove(Serializable primaryKey)
		throws NoSuchPortTypeAnalyzerLinkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PortTypeAnalyzerLink portTypeAnalyzerLink = (PortTypeAnalyzerLink)session.get(PortTypeAnalyzerLinkImpl.class,
					primaryKey);

			if (portTypeAnalyzerLink == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPortTypeAnalyzerLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(portTypeAnalyzerLink);
		}
		catch (NoSuchPortTypeAnalyzerLinkException nsee) {
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
	protected PortTypeAnalyzerLink removeImpl(
		PortTypeAnalyzerLink portTypeAnalyzerLink) throws SystemException {
		portTypeAnalyzerLink = toUnwrappedModel(portTypeAnalyzerLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(portTypeAnalyzerLink)) {
				portTypeAnalyzerLink = (PortTypeAnalyzerLink)session.get(PortTypeAnalyzerLinkImpl.class,
						portTypeAnalyzerLink.getPrimaryKeyObj());
			}

			if (portTypeAnalyzerLink != null) {
				session.delete(portTypeAnalyzerLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (portTypeAnalyzerLink != null) {
			clearCache(portTypeAnalyzerLink);
		}

		return portTypeAnalyzerLink;
	}

	@Override
	public PortTypeAnalyzerLink updateImpl(
		com.kisti.science.platform.app.model.PortTypeAnalyzerLink portTypeAnalyzerLink)
		throws SystemException {
		portTypeAnalyzerLink = toUnwrappedModel(portTypeAnalyzerLink);

		boolean isNew = portTypeAnalyzerLink.isNew();

		PortTypeAnalyzerLinkModelImpl portTypeAnalyzerLinkModelImpl = (PortTypeAnalyzerLinkModelImpl)portTypeAnalyzerLink;

		if (Validator.isNull(portTypeAnalyzerLink.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			portTypeAnalyzerLink.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (portTypeAnalyzerLink.isNew()) {
				session.save(portTypeAnalyzerLink);

				portTypeAnalyzerLink.setNew(false);
			}
			else {
				session.merge(portTypeAnalyzerLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PortTypeAnalyzerLinkModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((portTypeAnalyzerLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						portTypeAnalyzerLinkModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { portTypeAnalyzerLinkModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((portTypeAnalyzerLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						portTypeAnalyzerLinkModelImpl.getOriginalUuid(),
						portTypeAnalyzerLinkModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						portTypeAnalyzerLinkModelImpl.getUuid(),
						portTypeAnalyzerLinkModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((portTypeAnalyzerLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						portTypeAnalyzerLinkModelImpl.getOriginalPortTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTTYPEID,
					args);

				args = new Object[] {
						portTypeAnalyzerLinkModelImpl.getPortTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTTYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeAnalyzerLinkImpl.class,
			portTypeAnalyzerLink.getPrimaryKey(), portTypeAnalyzerLink);

		return portTypeAnalyzerLink;
	}

	protected PortTypeAnalyzerLink toUnwrappedModel(
		PortTypeAnalyzerLink portTypeAnalyzerLink) {
		if (portTypeAnalyzerLink instanceof PortTypeAnalyzerLinkImpl) {
			return portTypeAnalyzerLink;
		}

		PortTypeAnalyzerLinkImpl portTypeAnalyzerLinkImpl = new PortTypeAnalyzerLinkImpl();

		portTypeAnalyzerLinkImpl.setNew(portTypeAnalyzerLink.isNew());
		portTypeAnalyzerLinkImpl.setPrimaryKey(portTypeAnalyzerLink.getPrimaryKey());

		portTypeAnalyzerLinkImpl.setUuid(portTypeAnalyzerLink.getUuid());
		portTypeAnalyzerLinkImpl.setPortTypeAnalyzerLinkId(portTypeAnalyzerLink.getPortTypeAnalyzerLinkId());
		portTypeAnalyzerLinkImpl.setCompanyId(portTypeAnalyzerLink.getCompanyId());
		portTypeAnalyzerLinkImpl.setPortTypeId(portTypeAnalyzerLink.getPortTypeId());
		portTypeAnalyzerLinkImpl.setAnalyzerId(portTypeAnalyzerLink.getAnalyzerId());

		return portTypeAnalyzerLinkImpl;
	}

	/**
	 * Returns the port type analyzer link with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the port type analyzer link
	 * @return the port type analyzer link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPortTypeAnalyzerLinkException, SystemException {
		PortTypeAnalyzerLink portTypeAnalyzerLink = fetchByPrimaryKey(primaryKey);

		if (portTypeAnalyzerLink == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPortTypeAnalyzerLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return portTypeAnalyzerLink;
	}

	/**
	 * Returns the port type analyzer link with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException} if it could not be found.
	 *
	 * @param portTypeAnalyzerLinkId the primary key of the port type analyzer link
	 * @return the port type analyzer link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeAnalyzerLinkException if a port type analyzer link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink findByPrimaryKey(long portTypeAnalyzerLinkId)
		throws NoSuchPortTypeAnalyzerLinkException, SystemException {
		return findByPrimaryKey((Serializable)portTypeAnalyzerLinkId);
	}

	/**
	 * Returns the port type analyzer link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the port type analyzer link
	 * @return the port type analyzer link, or <code>null</code> if a port type analyzer link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PortTypeAnalyzerLink portTypeAnalyzerLink = (PortTypeAnalyzerLink)EntityCacheUtil.getResult(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
				PortTypeAnalyzerLinkImpl.class, primaryKey);

		if (portTypeAnalyzerLink == _nullPortTypeAnalyzerLink) {
			return null;
		}

		if (portTypeAnalyzerLink == null) {
			Session session = null;

			try {
				session = openSession();

				portTypeAnalyzerLink = (PortTypeAnalyzerLink)session.get(PortTypeAnalyzerLinkImpl.class,
						primaryKey);

				if (portTypeAnalyzerLink != null) {
					cacheResult(portTypeAnalyzerLink);
				}
				else {
					EntityCacheUtil.putResult(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
						PortTypeAnalyzerLinkImpl.class, primaryKey,
						_nullPortTypeAnalyzerLink);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PortTypeAnalyzerLinkModelImpl.ENTITY_CACHE_ENABLED,
					PortTypeAnalyzerLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return portTypeAnalyzerLink;
	}

	/**
	 * Returns the port type analyzer link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param portTypeAnalyzerLinkId the primary key of the port type analyzer link
	 * @return the port type analyzer link, or <code>null</code> if a port type analyzer link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeAnalyzerLink fetchByPrimaryKey(long portTypeAnalyzerLinkId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)portTypeAnalyzerLinkId);
	}

	/**
	 * Returns all the port type analyzer links.
	 *
	 * @return the port type analyzer links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeAnalyzerLink> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the port type analyzer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of port type analyzer links
	 * @param end the upper bound of the range of port type analyzer links (not inclusive)
	 * @return the range of port type analyzer links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeAnalyzerLink> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the port type analyzer links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeAnalyzerLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of port type analyzer links
	 * @param end the upper bound of the range of port type analyzer links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of port type analyzer links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeAnalyzerLink> findAll(int start, int end,
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

		List<PortTypeAnalyzerLink> list = (List<PortTypeAnalyzerLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PORTTYPEANALYZERLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PORTTYPEANALYZERLINK;

				if (pagination) {
					sql = sql.concat(PortTypeAnalyzerLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PortTypeAnalyzerLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PortTypeAnalyzerLink>(list);
				}
				else {
					list = (List<PortTypeAnalyzerLink>)QueryUtil.list(q,
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
	 * Removes all the port type analyzer links from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PortTypeAnalyzerLink portTypeAnalyzerLink : findAll()) {
			remove(portTypeAnalyzerLink);
		}
	}

	/**
	 * Returns the number of port type analyzer links.
	 *
	 * @return the number of port type analyzer links
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

				Query q = session.createQuery(_SQL_COUNT_PORTTYPEANALYZERLINK);

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
	 * Initializes the port type analyzer link persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kisti.science.platform.app.model.PortTypeAnalyzerLink")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PortTypeAnalyzerLink>> listenersList = new ArrayList<ModelListener<PortTypeAnalyzerLink>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PortTypeAnalyzerLink>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PortTypeAnalyzerLinkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PORTTYPEANALYZERLINK = "SELECT portTypeAnalyzerLink FROM PortTypeAnalyzerLink portTypeAnalyzerLink";
	private static final String _SQL_SELECT_PORTTYPEANALYZERLINK_WHERE = "SELECT portTypeAnalyzerLink FROM PortTypeAnalyzerLink portTypeAnalyzerLink WHERE ";
	private static final String _SQL_COUNT_PORTTYPEANALYZERLINK = "SELECT COUNT(portTypeAnalyzerLink) FROM PortTypeAnalyzerLink portTypeAnalyzerLink";
	private static final String _SQL_COUNT_PORTTYPEANALYZERLINK_WHERE = "SELECT COUNT(portTypeAnalyzerLink) FROM PortTypeAnalyzerLink portTypeAnalyzerLink WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "portTypeAnalyzerLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PortTypeAnalyzerLink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PortTypeAnalyzerLink exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PortTypeAnalyzerLinkPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static PortTypeAnalyzerLink _nullPortTypeAnalyzerLink = new PortTypeAnalyzerLinkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PortTypeAnalyzerLink> toCacheModel() {
				return _nullPortTypeAnalyzerLinkCacheModel;
			}
		};

	private static CacheModel<PortTypeAnalyzerLink> _nullPortTypeAnalyzerLinkCacheModel =
		new CacheModel<PortTypeAnalyzerLink>() {
			@Override
			public PortTypeAnalyzerLink toEntityModel() {
				return _nullPortTypeAnalyzerLink;
			}
		};
}