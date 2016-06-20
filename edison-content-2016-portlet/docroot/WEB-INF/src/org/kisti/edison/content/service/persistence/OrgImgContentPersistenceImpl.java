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

package org.kisti.edison.content.service.persistence;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.kisti.edison.content.NoSuchOrgImgContentException;
import org.kisti.edison.content.model.OrgImgContent;
import org.kisti.edison.content.model.impl.OrgImgContentImpl;
import org.kisti.edison.content.model.impl.OrgImgContentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the org img content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see OrgImgContentPersistence
 * @see OrgImgContentUtil
 * @generated
 */
public class OrgImgContentPersistenceImpl extends BasePersistenceImpl<OrgImgContent>
	implements OrgImgContentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrgImgContentUtil} to access the org img content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrgImgContentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
			OrgImgContentModelImpl.FINDER_CACHE_ENABLED,
			OrgImgContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
			OrgImgContentModelImpl.FINDER_CACHE_ENABLED,
			OrgImgContentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
			OrgImgContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
			OrgImgContentModelImpl.FINDER_CACHE_ENABLED,
			OrgImgContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
			OrgImgContentModelImpl.FINDER_CACHE_ENABLED,
			OrgImgContentImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] { Long.class.getName() },
			OrgImgContentModelImpl.GROUPID_COLUMN_BITMASK |
			OrgImgContentModelImpl.ORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
			OrgImgContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the org img contents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching org img contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrgImgContent> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the org img contents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.OrgImgContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of org img contents
	 * @param end the upper bound of the range of org img contents (not inclusive)
	 * @return the range of matching org img contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrgImgContent> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the org img contents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.OrgImgContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of org img contents
	 * @param end the upper bound of the range of org img contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching org img contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrgImgContent> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<OrgImgContent> list = (List<OrgImgContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OrgImgContent orgImgContent : list) {
				if ((groupId != orgImgContent.getGroupId())) {
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

			query.append(_SQL_SELECT_ORGIMGCONTENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OrgImgContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<OrgImgContent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrgImgContent>(list);
				}
				else {
					list = (List<OrgImgContent>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first org img content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching org img content
	 * @throws org.kisti.edison.content.NoSuchOrgImgContentException if a matching org img content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgImgContent findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOrgImgContentException, SystemException {
		OrgImgContent orgImgContent = fetchByGroupId_First(groupId,
				orderByComparator);

		if (orgImgContent != null) {
			return orgImgContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrgImgContentException(msg.toString());
	}

	/**
	 * Returns the first org img content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching org img content, or <code>null</code> if a matching org img content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgImgContent fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<OrgImgContent> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last org img content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching org img content
	 * @throws org.kisti.edison.content.NoSuchOrgImgContentException if a matching org img content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgImgContent findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOrgImgContentException, SystemException {
		OrgImgContent orgImgContent = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (orgImgContent != null) {
			return orgImgContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOrgImgContentException(msg.toString());
	}

	/**
	 * Returns the last org img content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching org img content, or <code>null</code> if a matching org img content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgImgContent fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<OrgImgContent> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the org img contents before and after the current org img content in the ordered set where groupId = &#63;.
	 *
	 * @param orgImgContentPK the primary key of the current org img content
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next org img content
	 * @throws org.kisti.edison.content.NoSuchOrgImgContentException if a org img content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgImgContent[] findByGroupId_PrevAndNext(
		OrgImgContentPK orgImgContentPK, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchOrgImgContentException, SystemException {
		OrgImgContent orgImgContent = findByPrimaryKey(orgImgContentPK);

		Session session = null;

		try {
			session = openSession();

			OrgImgContent[] array = new OrgImgContentImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, orgImgContent,
					groupId, orderByComparator, true);

			array[1] = orgImgContent;

			array[2] = getByGroupId_PrevAndNext(session, orgImgContent,
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

	protected OrgImgContent getByGroupId_PrevAndNext(Session session,
		OrgImgContent orgImgContent, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ORGIMGCONTENT_WHERE);

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
			query.append(OrgImgContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(orgImgContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OrgImgContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the org img contents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (OrgImgContent orgImgContent : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(orgImgContent);
		}
	}

	/**
	 * Returns the number of org img contents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching org img contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ORGIMGCONTENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "orgImgContent.id.groupId = ?";

	public OrgImgContentPersistenceImpl() {
		setModelClass(OrgImgContent.class);
	}

	/**
	 * Caches the org img content in the entity cache if it is enabled.
	 *
	 * @param orgImgContent the org img content
	 */
	@Override
	public void cacheResult(OrgImgContent orgImgContent) {
		EntityCacheUtil.putResult(OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
			OrgImgContentImpl.class, orgImgContent.getPrimaryKey(),
			orgImgContent);

		orgImgContent.resetOriginalValues();
	}

	/**
	 * Caches the org img contents in the entity cache if it is enabled.
	 *
	 * @param orgImgContents the org img contents
	 */
	@Override
	public void cacheResult(List<OrgImgContent> orgImgContents) {
		for (OrgImgContent orgImgContent : orgImgContents) {
			if (EntityCacheUtil.getResult(
						OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
						OrgImgContentImpl.class, orgImgContent.getPrimaryKey()) == null) {
				cacheResult(orgImgContent);
			}
			else {
				orgImgContent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all org img contents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrgImgContentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrgImgContentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the org img content.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OrgImgContent orgImgContent) {
		EntityCacheUtil.removeResult(OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
			OrgImgContentImpl.class, orgImgContent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OrgImgContent> orgImgContents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OrgImgContent orgImgContent : orgImgContents) {
			EntityCacheUtil.removeResult(OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
				OrgImgContentImpl.class, orgImgContent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new org img content with the primary key. Does not add the org img content to the database.
	 *
	 * @param orgImgContentPK the primary key for the new org img content
	 * @return the new org img content
	 */
	@Override
	public OrgImgContent create(OrgImgContentPK orgImgContentPK) {
		OrgImgContent orgImgContent = new OrgImgContentImpl();

		orgImgContent.setNew(true);
		orgImgContent.setPrimaryKey(orgImgContentPK);

		return orgImgContent;
	}

	/**
	 * Removes the org img content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orgImgContentPK the primary key of the org img content
	 * @return the org img content that was removed
	 * @throws org.kisti.edison.content.NoSuchOrgImgContentException if a org img content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgImgContent remove(OrgImgContentPK orgImgContentPK)
		throws NoSuchOrgImgContentException, SystemException {
		return remove((Serializable)orgImgContentPK);
	}

	/**
	 * Removes the org img content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the org img content
	 * @return the org img content that was removed
	 * @throws org.kisti.edison.content.NoSuchOrgImgContentException if a org img content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgImgContent remove(Serializable primaryKey)
		throws NoSuchOrgImgContentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			OrgImgContent orgImgContent = (OrgImgContent)session.get(OrgImgContentImpl.class,
					primaryKey);

			if (orgImgContent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrgImgContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(orgImgContent);
		}
		catch (NoSuchOrgImgContentException nsee) {
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
	protected OrgImgContent removeImpl(OrgImgContent orgImgContent)
		throws SystemException {
		orgImgContent = toUnwrappedModel(orgImgContent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(orgImgContent)) {
				orgImgContent = (OrgImgContent)session.get(OrgImgContentImpl.class,
						orgImgContent.getPrimaryKeyObj());
			}

			if (orgImgContent != null) {
				session.delete(orgImgContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (orgImgContent != null) {
			clearCache(orgImgContent);
		}

		return orgImgContent;
	}

	@Override
	public OrgImgContent updateImpl(
		org.kisti.edison.content.model.OrgImgContent orgImgContent)
		throws SystemException {
		orgImgContent = toUnwrappedModel(orgImgContent);

		boolean isNew = orgImgContent.isNew();

		OrgImgContentModelImpl orgImgContentModelImpl = (OrgImgContentModelImpl)orgImgContent;

		Session session = null;

		try {
			session = openSession();

			if (orgImgContent.isNew()) {
				session.save(orgImgContent);

				orgImgContent.setNew(false);
			}
			else {
				session.merge(orgImgContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrgImgContentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((orgImgContentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						orgImgContentModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { orgImgContentModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
			OrgImgContentImpl.class, orgImgContent.getPrimaryKey(),
			orgImgContent);

		return orgImgContent;
	}

	protected OrgImgContent toUnwrappedModel(OrgImgContent orgImgContent) {
		if (orgImgContent instanceof OrgImgContentImpl) {
			return orgImgContent;
		}

		OrgImgContentImpl orgImgContentImpl = new OrgImgContentImpl();

		orgImgContentImpl.setNew(orgImgContent.isNew());
		orgImgContentImpl.setPrimaryKey(orgImgContent.getPrimaryKey());

		orgImgContentImpl.setOrgImgSeq(orgImgContent.getOrgImgSeq());
		orgImgContentImpl.setGroupId(orgImgContent.getGroupId());
		orgImgContentImpl.setOrder(orgImgContent.getOrder());
		orgImgContentImpl.setOrgNm(orgImgContent.getOrgNm());
		orgImgContentImpl.setOrgLink(orgImgContent.getOrgLink());
		orgImgContentImpl.setFileEntryId(orgImgContent.getFileEntryId());
		orgImgContentImpl.setInsertId(orgImgContent.getInsertId());
		orgImgContentImpl.setInsertDate(orgImgContent.getInsertDate());
		orgImgContentImpl.setUpdateId(orgImgContent.getUpdateId());
		orgImgContentImpl.setUpdateDate(orgImgContent.getUpdateDate());

		return orgImgContentImpl;
	}

	/**
	 * Returns the org img content with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the org img content
	 * @return the org img content
	 * @throws org.kisti.edison.content.NoSuchOrgImgContentException if a org img content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgImgContent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrgImgContentException, SystemException {
		OrgImgContent orgImgContent = fetchByPrimaryKey(primaryKey);

		if (orgImgContent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrgImgContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return orgImgContent;
	}

	/**
	 * Returns the org img content with the primary key or throws a {@link org.kisti.edison.content.NoSuchOrgImgContentException} if it could not be found.
	 *
	 * @param orgImgContentPK the primary key of the org img content
	 * @return the org img content
	 * @throws org.kisti.edison.content.NoSuchOrgImgContentException if a org img content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgImgContent findByPrimaryKey(OrgImgContentPK orgImgContentPK)
		throws NoSuchOrgImgContentException, SystemException {
		return findByPrimaryKey((Serializable)orgImgContentPK);
	}

	/**
	 * Returns the org img content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the org img content
	 * @return the org img content, or <code>null</code> if a org img content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgImgContent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		OrgImgContent orgImgContent = (OrgImgContent)EntityCacheUtil.getResult(OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
				OrgImgContentImpl.class, primaryKey);

		if (orgImgContent == _nullOrgImgContent) {
			return null;
		}

		if (orgImgContent == null) {
			Session session = null;

			try {
				session = openSession();

				orgImgContent = (OrgImgContent)session.get(OrgImgContentImpl.class,
						primaryKey);

				if (orgImgContent != null) {
					cacheResult(orgImgContent);
				}
				else {
					EntityCacheUtil.putResult(OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
						OrgImgContentImpl.class, primaryKey, _nullOrgImgContent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrgImgContentModelImpl.ENTITY_CACHE_ENABLED,
					OrgImgContentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return orgImgContent;
	}

	/**
	 * Returns the org img content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param orgImgContentPK the primary key of the org img content
	 * @return the org img content, or <code>null</code> if a org img content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public OrgImgContent fetchByPrimaryKey(OrgImgContentPK orgImgContentPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)orgImgContentPK);
	}

	/**
	 * Returns all the org img contents.
	 *
	 * @return the org img contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrgImgContent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the org img contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.OrgImgContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of org img contents
	 * @param end the upper bound of the range of org img contents (not inclusive)
	 * @return the range of org img contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrgImgContent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the org img contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.OrgImgContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of org img contents
	 * @param end the upper bound of the range of org img contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of org img contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<OrgImgContent> findAll(int start, int end,
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

		List<OrgImgContent> list = (List<OrgImgContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORGIMGCONTENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORGIMGCONTENT;

				if (pagination) {
					sql = sql.concat(OrgImgContentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OrgImgContent>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<OrgImgContent>(list);
				}
				else {
					list = (List<OrgImgContent>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the org img contents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (OrgImgContent orgImgContent : findAll()) {
			remove(orgImgContent);
		}
	}

	/**
	 * Returns the number of org img contents.
	 *
	 * @return the number of org img contents
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

				Query q = session.createQuery(_SQL_COUNT_ORGIMGCONTENT);

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
	 * Initializes the org img content persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.content.model.OrgImgContent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<OrgImgContent>> listenersList = new ArrayList<ModelListener<OrgImgContent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<OrgImgContent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OrgImgContentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORGIMGCONTENT = "SELECT orgImgContent FROM OrgImgContent orgImgContent";
	private static final String _SQL_SELECT_ORGIMGCONTENT_WHERE = "SELECT orgImgContent FROM OrgImgContent orgImgContent WHERE ";
	private static final String _SQL_COUNT_ORGIMGCONTENT = "SELECT COUNT(orgImgContent) FROM OrgImgContent orgImgContent";
	private static final String _SQL_COUNT_ORGIMGCONTENT_WHERE = "SELECT COUNT(orgImgContent) FROM OrgImgContent orgImgContent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "orgImgContent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OrgImgContent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OrgImgContent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrgImgContentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"order"
			});
	private static OrgImgContent _nullOrgImgContent = new OrgImgContentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OrgImgContent> toCacheModel() {
				return _nullOrgImgContentCacheModel;
			}
		};

	private static CacheModel<OrgImgContent> _nullOrgImgContentCacheModel = new CacheModel<OrgImgContent>() {
			@Override
			public OrgImgContent toEntityModel() {
				return _nullOrgImgContent;
			}
		};
}