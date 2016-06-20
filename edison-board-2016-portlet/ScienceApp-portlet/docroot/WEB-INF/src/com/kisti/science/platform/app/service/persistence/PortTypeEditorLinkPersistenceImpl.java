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

import com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException;
import com.kisti.science.platform.app.model.PortTypeEditorLink;
import com.kisti.science.platform.app.model.impl.PortTypeEditorLinkImpl;
import com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl;

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
 * The persistence implementation for the port type editor link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Jerry H. Seo & Young Suh
 * @see PortTypeEditorLinkPersistence
 * @see PortTypeEditorLinkUtil
 * @generated
 */
public class PortTypeEditorLinkPersistenceImpl extends BasePersistenceImpl<PortTypeEditorLink>
	implements PortTypeEditorLinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PortTypeEditorLinkUtil} to access the port type editor link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PortTypeEditorLinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeEditorLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeEditorLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeEditorLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeEditorLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			PortTypeEditorLinkModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the port type editor links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching port type editor links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeEditorLink> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the port type editor links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of port type editor links
	 * @param end the upper bound of the range of port type editor links (not inclusive)
	 * @return the range of matching port type editor links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeEditorLink> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the port type editor links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of port type editor links
	 * @param end the upper bound of the range of port type editor links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching port type editor links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeEditorLink> findByUuid(String uuid, int start, int end,
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

		List<PortTypeEditorLink> list = (List<PortTypeEditorLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortTypeEditorLink portTypeEditorLink : list) {
				if (!Validator.equals(uuid, portTypeEditorLink.getUuid())) {
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

			query.append(_SQL_SELECT_PORTTYPEEDITORLINK_WHERE);

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
				query.append(PortTypeEditorLinkModelImpl.ORDER_BY_JPQL);
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
					list = (List<PortTypeEditorLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PortTypeEditorLink>(list);
				}
				else {
					list = (List<PortTypeEditorLink>)QueryUtil.list(q,
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
	 * Returns the first port type editor link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching port type editor link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a matching port type editor link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeEditorLinkException, SystemException {
		PortTypeEditorLink portTypeEditorLink = fetchByUuid_First(uuid,
				orderByComparator);

		if (portTypeEditorLink != null) {
			return portTypeEditorLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortTypeEditorLinkException(msg.toString());
	}

	/**
	 * Returns the first port type editor link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<PortTypeEditorLink> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last port type editor link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching port type editor link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a matching port type editor link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeEditorLinkException, SystemException {
		PortTypeEditorLink portTypeEditorLink = fetchByUuid_Last(uuid,
				orderByComparator);

		if (portTypeEditorLink != null) {
			return portTypeEditorLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortTypeEditorLinkException(msg.toString());
	}

	/**
	 * Returns the last port type editor link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PortTypeEditorLink> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the port type editor links before and after the current port type editor link in the ordered set where uuid = &#63;.
	 *
	 * @param portTypeEditorLinkId the primary key of the current port type editor link
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next port type editor link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a port type editor link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink[] findByUuid_PrevAndNext(
		long portTypeEditorLinkId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeEditorLinkException, SystemException {
		PortTypeEditorLink portTypeEditorLink = findByPrimaryKey(portTypeEditorLinkId);

		Session session = null;

		try {
			session = openSession();

			PortTypeEditorLink[] array = new PortTypeEditorLinkImpl[3];

			array[0] = getByUuid_PrevAndNext(session, portTypeEditorLink, uuid,
					orderByComparator, true);

			array[1] = portTypeEditorLink;

			array[2] = getByUuid_PrevAndNext(session, portTypeEditorLink, uuid,
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

	protected PortTypeEditorLink getByUuid_PrevAndNext(Session session,
		PortTypeEditorLink portTypeEditorLink, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTTYPEEDITORLINK_WHERE);

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
			query.append(PortTypeEditorLinkModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(portTypeEditorLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortTypeEditorLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the port type editor links where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (PortTypeEditorLink portTypeEditorLink : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(portTypeEditorLink);
		}
	}

	/**
	 * Returns the number of port type editor links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching port type editor links
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

			query.append(_SQL_COUNT_PORTTYPEEDITORLINK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "portTypeEditorLink.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "portTypeEditorLink.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(portTypeEditorLink.uuid IS NULL OR portTypeEditorLink.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeEditorLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeEditorLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			PortTypeEditorLinkModelImpl.UUID_COLUMN_BITMASK |
			PortTypeEditorLinkModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the port type editor links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching port type editor links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeEditorLink> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the port type editor links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of port type editor links
	 * @param end the upper bound of the range of port type editor links (not inclusive)
	 * @return the range of matching port type editor links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeEditorLink> findByUuid_C(String uuid, long companyId,
		int start, int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the port type editor links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of port type editor links
	 * @param end the upper bound of the range of port type editor links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching port type editor links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeEditorLink> findByUuid_C(String uuid, long companyId,
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

		List<PortTypeEditorLink> list = (List<PortTypeEditorLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortTypeEditorLink portTypeEditorLink : list) {
				if (!Validator.equals(uuid, portTypeEditorLink.getUuid()) ||
						(companyId != portTypeEditorLink.getCompanyId())) {
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

			query.append(_SQL_SELECT_PORTTYPEEDITORLINK_WHERE);

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
				query.append(PortTypeEditorLinkModelImpl.ORDER_BY_JPQL);
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
					list = (List<PortTypeEditorLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PortTypeEditorLink>(list);
				}
				else {
					list = (List<PortTypeEditorLink>)QueryUtil.list(q,
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
	 * Returns the first port type editor link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching port type editor link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a matching port type editor link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeEditorLinkException, SystemException {
		PortTypeEditorLink portTypeEditorLink = fetchByUuid_C_First(uuid,
				companyId, orderByComparator);

		if (portTypeEditorLink != null) {
			return portTypeEditorLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortTypeEditorLinkException(msg.toString());
	}

	/**
	 * Returns the first port type editor link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PortTypeEditorLink> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last port type editor link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching port type editor link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a matching port type editor link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeEditorLinkException, SystemException {
		PortTypeEditorLink portTypeEditorLink = fetchByUuid_C_Last(uuid,
				companyId, orderByComparator);

		if (portTypeEditorLink != null) {
			return portTypeEditorLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortTypeEditorLinkException(msg.toString());
	}

	/**
	 * Returns the last port type editor link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PortTypeEditorLink> list = findByUuid_C(uuid, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the port type editor links before and after the current port type editor link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param portTypeEditorLinkId the primary key of the current port type editor link
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next port type editor link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a port type editor link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink[] findByUuid_C_PrevAndNext(
		long portTypeEditorLinkId, String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeEditorLinkException, SystemException {
		PortTypeEditorLink portTypeEditorLink = findByPrimaryKey(portTypeEditorLinkId);

		Session session = null;

		try {
			session = openSession();

			PortTypeEditorLink[] array = new PortTypeEditorLinkImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, portTypeEditorLink,
					uuid, companyId, orderByComparator, true);

			array[1] = portTypeEditorLink;

			array[2] = getByUuid_C_PrevAndNext(session, portTypeEditorLink,
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

	protected PortTypeEditorLink getByUuid_C_PrevAndNext(Session session,
		PortTypeEditorLink portTypeEditorLink, String uuid, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTTYPEEDITORLINK_WHERE);

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
			query.append(PortTypeEditorLinkModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(portTypeEditorLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortTypeEditorLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the port type editor links where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (PortTypeEditorLink portTypeEditorLink : findByUuid_C(uuid,
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(portTypeEditorLink);
		}
	}

	/**
	 * Returns the number of port type editor links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching port type editor links
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

			query.append(_SQL_COUNT_PORTTYPEEDITORLINK_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "portTypeEditorLink.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "portTypeEditorLink.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(portTypeEditorLink.uuid IS NULL OR portTypeEditorLink.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "portTypeEditorLink.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PORTTYPEID =
		new FinderPath(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeEditorLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPortTypeId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTTYPEID =
		new FinderPath(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkModelImpl.FINDER_CACHE_ENABLED,
			PortTypeEditorLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPortTypeId",
			new String[] { Long.class.getName() },
			PortTypeEditorLinkModelImpl.PORTTYPEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORTTYPEID = new FinderPath(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPortTypeId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the port type editor links where portTypeId = &#63;.
	 *
	 * @param portTypeId the port type ID
	 * @return the matching port type editor links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeEditorLink> findByPortTypeId(long portTypeId)
		throws SystemException {
		return findByPortTypeId(portTypeId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the port type editor links where portTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param portTypeId the port type ID
	 * @param start the lower bound of the range of port type editor links
	 * @param end the upper bound of the range of port type editor links (not inclusive)
	 * @return the range of matching port type editor links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeEditorLink> findByPortTypeId(long portTypeId,
		int start, int end) throws SystemException {
		return findByPortTypeId(portTypeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the port type editor links where portTypeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param portTypeId the port type ID
	 * @param start the lower bound of the range of port type editor links
	 * @param end the upper bound of the range of port type editor links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching port type editor links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeEditorLink> findByPortTypeId(long portTypeId,
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

		List<PortTypeEditorLink> list = (List<PortTypeEditorLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PortTypeEditorLink portTypeEditorLink : list) {
				if ((portTypeId != portTypeEditorLink.getPortTypeId())) {
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

			query.append(_SQL_SELECT_PORTTYPEEDITORLINK_WHERE);

			query.append(_FINDER_COLUMN_PORTTYPEID_PORTTYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PortTypeEditorLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(portTypeId);

				if (!pagination) {
					list = (List<PortTypeEditorLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PortTypeEditorLink>(list);
				}
				else {
					list = (List<PortTypeEditorLink>)QueryUtil.list(q,
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
	 * Returns the first port type editor link in the ordered set where portTypeId = &#63;.
	 *
	 * @param portTypeId the port type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching port type editor link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a matching port type editor link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink findByPortTypeId_First(long portTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeEditorLinkException, SystemException {
		PortTypeEditorLink portTypeEditorLink = fetchByPortTypeId_First(portTypeId,
				orderByComparator);

		if (portTypeEditorLink != null) {
			return portTypeEditorLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("portTypeId=");
		msg.append(portTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortTypeEditorLinkException(msg.toString());
	}

	/**
	 * Returns the first port type editor link in the ordered set where portTypeId = &#63;.
	 *
	 * @param portTypeId the port type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink fetchByPortTypeId_First(long portTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PortTypeEditorLink> list = findByPortTypeId(portTypeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last port type editor link in the ordered set where portTypeId = &#63;.
	 *
	 * @param portTypeId the port type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching port type editor link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a matching port type editor link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink findByPortTypeId_Last(long portTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeEditorLinkException, SystemException {
		PortTypeEditorLink portTypeEditorLink = fetchByPortTypeId_Last(portTypeId,
				orderByComparator);

		if (portTypeEditorLink != null) {
			return portTypeEditorLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("portTypeId=");
		msg.append(portTypeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPortTypeEditorLinkException(msg.toString());
	}

	/**
	 * Returns the last port type editor link in the ordered set where portTypeId = &#63;.
	 *
	 * @param portTypeId the port type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching port type editor link, or <code>null</code> if a matching port type editor link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink fetchByPortTypeId_Last(long portTypeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPortTypeId(portTypeId);

		if (count == 0) {
			return null;
		}

		List<PortTypeEditorLink> list = findByPortTypeId(portTypeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the port type editor links before and after the current port type editor link in the ordered set where portTypeId = &#63;.
	 *
	 * @param portTypeEditorLinkId the primary key of the current port type editor link
	 * @param portTypeId the port type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next port type editor link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a port type editor link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink[] findByPortTypeId_PrevAndNext(
		long portTypeEditorLinkId, long portTypeId,
		OrderByComparator orderByComparator)
		throws NoSuchPortTypeEditorLinkException, SystemException {
		PortTypeEditorLink portTypeEditorLink = findByPrimaryKey(portTypeEditorLinkId);

		Session session = null;

		try {
			session = openSession();

			PortTypeEditorLink[] array = new PortTypeEditorLinkImpl[3];

			array[0] = getByPortTypeId_PrevAndNext(session, portTypeEditorLink,
					portTypeId, orderByComparator, true);

			array[1] = portTypeEditorLink;

			array[2] = getByPortTypeId_PrevAndNext(session, portTypeEditorLink,
					portTypeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PortTypeEditorLink getByPortTypeId_PrevAndNext(Session session,
		PortTypeEditorLink portTypeEditorLink, long portTypeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PORTTYPEEDITORLINK_WHERE);

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
			query.append(PortTypeEditorLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(portTypeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(portTypeEditorLink);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PortTypeEditorLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the port type editor links where portTypeId = &#63; from the database.
	 *
	 * @param portTypeId the port type ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPortTypeId(long portTypeId) throws SystemException {
		for (PortTypeEditorLink portTypeEditorLink : findByPortTypeId(
				portTypeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(portTypeEditorLink);
		}
	}

	/**
	 * Returns the number of port type editor links where portTypeId = &#63;.
	 *
	 * @param portTypeId the port type ID
	 * @return the number of matching port type editor links
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

			query.append(_SQL_COUNT_PORTTYPEEDITORLINK_WHERE);

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

	private static final String _FINDER_COLUMN_PORTTYPEID_PORTTYPEID_2 = "portTypeEditorLink.portTypeId = ?";

	public PortTypeEditorLinkPersistenceImpl() {
		setModelClass(PortTypeEditorLink.class);
	}

	/**
	 * Caches the port type editor link in the entity cache if it is enabled.
	 *
	 * @param portTypeEditorLink the port type editor link
	 */
	@Override
	public void cacheResult(PortTypeEditorLink portTypeEditorLink) {
		EntityCacheUtil.putResult(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkImpl.class, portTypeEditorLink.getPrimaryKey(),
			portTypeEditorLink);

		portTypeEditorLink.resetOriginalValues();
	}

	/**
	 * Caches the port type editor links in the entity cache if it is enabled.
	 *
	 * @param portTypeEditorLinks the port type editor links
	 */
	@Override
	public void cacheResult(List<PortTypeEditorLink> portTypeEditorLinks) {
		for (PortTypeEditorLink portTypeEditorLink : portTypeEditorLinks) {
			if (EntityCacheUtil.getResult(
						PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
						PortTypeEditorLinkImpl.class,
						portTypeEditorLink.getPrimaryKey()) == null) {
				cacheResult(portTypeEditorLink);
			}
			else {
				portTypeEditorLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all port type editor links.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PortTypeEditorLinkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PortTypeEditorLinkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the port type editor link.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PortTypeEditorLink portTypeEditorLink) {
		EntityCacheUtil.removeResult(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkImpl.class, portTypeEditorLink.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PortTypeEditorLink> portTypeEditorLinks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PortTypeEditorLink portTypeEditorLink : portTypeEditorLinks) {
			EntityCacheUtil.removeResult(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
				PortTypeEditorLinkImpl.class, portTypeEditorLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new port type editor link with the primary key. Does not add the port type editor link to the database.
	 *
	 * @param portTypeEditorLinkId the primary key for the new port type editor link
	 * @return the new port type editor link
	 */
	@Override
	public PortTypeEditorLink create(long portTypeEditorLinkId) {
		PortTypeEditorLink portTypeEditorLink = new PortTypeEditorLinkImpl();

		portTypeEditorLink.setNew(true);
		portTypeEditorLink.setPrimaryKey(portTypeEditorLinkId);

		String uuid = PortalUUIDUtil.generate();

		portTypeEditorLink.setUuid(uuid);

		return portTypeEditorLink;
	}

	/**
	 * Removes the port type editor link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portTypeEditorLinkId the primary key of the port type editor link
	 * @return the port type editor link that was removed
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a port type editor link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink remove(long portTypeEditorLinkId)
		throws NoSuchPortTypeEditorLinkException, SystemException {
		return remove((Serializable)portTypeEditorLinkId);
	}

	/**
	 * Removes the port type editor link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the port type editor link
	 * @return the port type editor link that was removed
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a port type editor link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink remove(Serializable primaryKey)
		throws NoSuchPortTypeEditorLinkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PortTypeEditorLink portTypeEditorLink = (PortTypeEditorLink)session.get(PortTypeEditorLinkImpl.class,
					primaryKey);

			if (portTypeEditorLink == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPortTypeEditorLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(portTypeEditorLink);
		}
		catch (NoSuchPortTypeEditorLinkException nsee) {
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
	protected PortTypeEditorLink removeImpl(
		PortTypeEditorLink portTypeEditorLink) throws SystemException {
		portTypeEditorLink = toUnwrappedModel(portTypeEditorLink);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(portTypeEditorLink)) {
				portTypeEditorLink = (PortTypeEditorLink)session.get(PortTypeEditorLinkImpl.class,
						portTypeEditorLink.getPrimaryKeyObj());
			}

			if (portTypeEditorLink != null) {
				session.delete(portTypeEditorLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (portTypeEditorLink != null) {
			clearCache(portTypeEditorLink);
		}

		return portTypeEditorLink;
	}

	@Override
	public PortTypeEditorLink updateImpl(
		com.kisti.science.platform.app.model.PortTypeEditorLink portTypeEditorLink)
		throws SystemException {
		portTypeEditorLink = toUnwrappedModel(portTypeEditorLink);

		boolean isNew = portTypeEditorLink.isNew();

		PortTypeEditorLinkModelImpl portTypeEditorLinkModelImpl = (PortTypeEditorLinkModelImpl)portTypeEditorLink;

		if (Validator.isNull(portTypeEditorLink.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			portTypeEditorLink.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (portTypeEditorLink.isNew()) {
				session.save(portTypeEditorLink);

				portTypeEditorLink.setNew(false);
			}
			else {
				session.merge(portTypeEditorLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PortTypeEditorLinkModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((portTypeEditorLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						portTypeEditorLinkModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { portTypeEditorLinkModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((portTypeEditorLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						portTypeEditorLinkModelImpl.getOriginalUuid(),
						portTypeEditorLinkModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						portTypeEditorLinkModelImpl.getUuid(),
						portTypeEditorLinkModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((portTypeEditorLinkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTTYPEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						portTypeEditorLinkModelImpl.getOriginalPortTypeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTTYPEID,
					args);

				args = new Object[] { portTypeEditorLinkModelImpl.getPortTypeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTTYPEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTTYPEID,
					args);
			}
		}

		EntityCacheUtil.putResult(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
			PortTypeEditorLinkImpl.class, portTypeEditorLink.getPrimaryKey(),
			portTypeEditorLink);

		return portTypeEditorLink;
	}

	protected PortTypeEditorLink toUnwrappedModel(
		PortTypeEditorLink portTypeEditorLink) {
		if (portTypeEditorLink instanceof PortTypeEditorLinkImpl) {
			return portTypeEditorLink;
		}

		PortTypeEditorLinkImpl portTypeEditorLinkImpl = new PortTypeEditorLinkImpl();

		portTypeEditorLinkImpl.setNew(portTypeEditorLink.isNew());
		portTypeEditorLinkImpl.setPrimaryKey(portTypeEditorLink.getPrimaryKey());

		portTypeEditorLinkImpl.setUuid(portTypeEditorLink.getUuid());
		portTypeEditorLinkImpl.setPortTypeEditorLinkId(portTypeEditorLink.getPortTypeEditorLinkId());
		portTypeEditorLinkImpl.setCompanyId(portTypeEditorLink.getCompanyId());
		portTypeEditorLinkImpl.setPortTypeId(portTypeEditorLink.getPortTypeId());
		portTypeEditorLinkImpl.setEditorId(portTypeEditorLink.getEditorId());

		return portTypeEditorLinkImpl;
	}

	/**
	 * Returns the port type editor link with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the port type editor link
	 * @return the port type editor link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a port type editor link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPortTypeEditorLinkException, SystemException {
		PortTypeEditorLink portTypeEditorLink = fetchByPrimaryKey(primaryKey);

		if (portTypeEditorLink == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPortTypeEditorLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return portTypeEditorLink;
	}

	/**
	 * Returns the port type editor link with the primary key or throws a {@link com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException} if it could not be found.
	 *
	 * @param portTypeEditorLinkId the primary key of the port type editor link
	 * @return the port type editor link
	 * @throws com.kisti.science.platform.app.NoSuchPortTypeEditorLinkException if a port type editor link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink findByPrimaryKey(long portTypeEditorLinkId)
		throws NoSuchPortTypeEditorLinkException, SystemException {
		return findByPrimaryKey((Serializable)portTypeEditorLinkId);
	}

	/**
	 * Returns the port type editor link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the port type editor link
	 * @return the port type editor link, or <code>null</code> if a port type editor link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PortTypeEditorLink portTypeEditorLink = (PortTypeEditorLink)EntityCacheUtil.getResult(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
				PortTypeEditorLinkImpl.class, primaryKey);

		if (portTypeEditorLink == _nullPortTypeEditorLink) {
			return null;
		}

		if (portTypeEditorLink == null) {
			Session session = null;

			try {
				session = openSession();

				portTypeEditorLink = (PortTypeEditorLink)session.get(PortTypeEditorLinkImpl.class,
						primaryKey);

				if (portTypeEditorLink != null) {
					cacheResult(portTypeEditorLink);
				}
				else {
					EntityCacheUtil.putResult(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
						PortTypeEditorLinkImpl.class, primaryKey,
						_nullPortTypeEditorLink);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PortTypeEditorLinkModelImpl.ENTITY_CACHE_ENABLED,
					PortTypeEditorLinkImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return portTypeEditorLink;
	}

	/**
	 * Returns the port type editor link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param portTypeEditorLinkId the primary key of the port type editor link
	 * @return the port type editor link, or <code>null</code> if a port type editor link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PortTypeEditorLink fetchByPrimaryKey(long portTypeEditorLinkId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)portTypeEditorLinkId);
	}

	/**
	 * Returns all the port type editor links.
	 *
	 * @return the port type editor links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeEditorLink> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the port type editor links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of port type editor links
	 * @param end the upper bound of the range of port type editor links (not inclusive)
	 * @return the range of port type editor links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeEditorLink> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the port type editor links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.kisti.science.platform.app.model.impl.PortTypeEditorLinkModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of port type editor links
	 * @param end the upper bound of the range of port type editor links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of port type editor links
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PortTypeEditorLink> findAll(int start, int end,
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

		List<PortTypeEditorLink> list = (List<PortTypeEditorLink>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PORTTYPEEDITORLINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PORTTYPEEDITORLINK;

				if (pagination) {
					sql = sql.concat(PortTypeEditorLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PortTypeEditorLink>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PortTypeEditorLink>(list);
				}
				else {
					list = (List<PortTypeEditorLink>)QueryUtil.list(q,
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
	 * Removes all the port type editor links from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PortTypeEditorLink portTypeEditorLink : findAll()) {
			remove(portTypeEditorLink);
		}
	}

	/**
	 * Returns the number of port type editor links.
	 *
	 * @return the number of port type editor links
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

				Query q = session.createQuery(_SQL_COUNT_PORTTYPEEDITORLINK);

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
	 * Initializes the port type editor link persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.kisti.science.platform.app.model.PortTypeEditorLink")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PortTypeEditorLink>> listenersList = new ArrayList<ModelListener<PortTypeEditorLink>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PortTypeEditorLink>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PortTypeEditorLinkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PORTTYPEEDITORLINK = "SELECT portTypeEditorLink FROM PortTypeEditorLink portTypeEditorLink";
	private static final String _SQL_SELECT_PORTTYPEEDITORLINK_WHERE = "SELECT portTypeEditorLink FROM PortTypeEditorLink portTypeEditorLink WHERE ";
	private static final String _SQL_COUNT_PORTTYPEEDITORLINK = "SELECT COUNT(portTypeEditorLink) FROM PortTypeEditorLink portTypeEditorLink";
	private static final String _SQL_COUNT_PORTTYPEEDITORLINK_WHERE = "SELECT COUNT(portTypeEditorLink) FROM PortTypeEditorLink portTypeEditorLink WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "portTypeEditorLink.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PortTypeEditorLink exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PortTypeEditorLink exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PortTypeEditorLinkPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static PortTypeEditorLink _nullPortTypeEditorLink = new PortTypeEditorLinkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PortTypeEditorLink> toCacheModel() {
				return _nullPortTypeEditorLinkCacheModel;
			}
		};

	private static CacheModel<PortTypeEditorLink> _nullPortTypeEditorLinkCacheModel =
		new CacheModel<PortTypeEditorLink>() {
			@Override
			public PortTypeEditorLink toEntityModel() {
				return _nullPortTypeEditorLink;
			}
		};
}