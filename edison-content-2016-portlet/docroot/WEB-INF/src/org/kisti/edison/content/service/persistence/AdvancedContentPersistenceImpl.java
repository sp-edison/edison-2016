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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.kisti.edison.content.NoSuchAdvancedContentException;
import org.kisti.edison.content.model.AdvancedContent;
import org.kisti.edison.content.model.impl.AdvancedContentImpl;
import org.kisti.edison.content.model.impl.AdvancedContentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the advanced content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see AdvancedContentPersistence
 * @see AdvancedContentUtil
 * @generated
 */
public class AdvancedContentPersistenceImpl extends BasePersistenceImpl<AdvancedContent>
	implements AdvancedContentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdvancedContentUtil} to access the advanced content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdvancedContentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
			AdvancedContentModelImpl.FINDER_CACHE_ENABLED,
			AdvancedContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
			AdvancedContentModelImpl.FINDER_CACHE_ENABLED,
			AdvancedContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
			AdvancedContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
			AdvancedContentModelImpl.FINDER_CACHE_ENABLED,
			AdvancedContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
			AdvancedContentModelImpl.FINDER_CACHE_ENABLED,
			AdvancedContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			AdvancedContentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
			AdvancedContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the advanced contents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching advanced contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvancedContent> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the advanced contents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of advanced contents
	 * @param end the upper bound of the range of advanced contents (not inclusive)
	 * @return the range of matching advanced contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvancedContent> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the advanced contents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of advanced contents
	 * @param end the upper bound of the range of advanced contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching advanced contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvancedContent> findByGroupId(long groupId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<AdvancedContent> list = (List<AdvancedContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdvancedContent advancedContent : list) {
				if ((groupId != advancedContent.getGroupId())) {
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

			query.append(_SQL_SELECT_ADVANCEDCONTENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdvancedContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<AdvancedContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdvancedContent>(list);
				}
				else {
					list = (List<AdvancedContent>)QueryUtil.list(q,
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
	 * Returns the first advanced content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching advanced content
	 * @throws org.kisti.edison.content.NoSuchAdvancedContentException if a matching advanced content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvancedContentException, SystemException {
		AdvancedContent advancedContent = fetchByGroupId_First(groupId,
				orderByComparator);

		if (advancedContent != null) {
			return advancedContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvancedContentException(msg.toString());
	}

	/**
	 * Returns the first advanced content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching advanced content, or <code>null</code> if a matching advanced content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<AdvancedContent> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last advanced content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching advanced content
	 * @throws org.kisti.edison.content.NoSuchAdvancedContentException if a matching advanced content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvancedContentException, SystemException {
		AdvancedContent advancedContent = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (advancedContent != null) {
			return advancedContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvancedContentException(msg.toString());
	}

	/**
	 * Returns the last advanced content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching advanced content, or <code>null</code> if a matching advanced content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<AdvancedContent> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the advanced contents before and after the current advanced content in the ordered set where groupId = &#63;.
	 *
	 * @param advancedContentPK the primary key of the current advanced content
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next advanced content
	 * @throws org.kisti.edison.content.NoSuchAdvancedContentException if a advanced content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent[] findByGroupId_PrevAndNext(
		AdvancedContentPK advancedContentPK, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchAdvancedContentException, SystemException {
		AdvancedContent advancedContent = findByPrimaryKey(advancedContentPK);

		Session session = null;

		try {
			session = openSession();

			AdvancedContent[] array = new AdvancedContentImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, advancedContent,
					groupId, orderByComparator, true);

			array[1] = advancedContent;

			array[2] = getByGroupId_PrevAndNext(session, advancedContent,
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

	protected AdvancedContent getByGroupId_PrevAndNext(Session session,
		AdvancedContent advancedContent, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVANCEDCONTENT_WHERE);

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
			query.append(AdvancedContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(advancedContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdvancedContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the advanced contents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (AdvancedContent advancedContent : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(advancedContent);
		}
	}

	/**
	 * Returns the number of advanced contents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching advanced contents
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

			query.append(_SQL_COUNT_ADVANCEDCONTENT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "advancedContent.id.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDSERIVELANG =
		new FinderPath(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
			AdvancedContentModelImpl.FINDER_CACHE_ENABLED,
			AdvancedContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupIdSeriveLang",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDSERIVELANG =
		new FinderPath(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
			AdvancedContentModelImpl.FINDER_CACHE_ENABLED,
			AdvancedContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdSeriveLang",
			new String[] { Long.class.getName(), String.class.getName() },
			AdvancedContentModelImpl.GROUPID_COLUMN_BITMASK |
			AdvancedContentModelImpl.SERVICELANGUAGE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDSERIVELANG = new FinderPath(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
			AdvancedContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdSeriveLang",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the advanced contents where groupId = &#63; and serviceLanguage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param serviceLanguage the service language
	 * @return the matching advanced contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvancedContent> findByGroupIdSeriveLang(long groupId,
		String serviceLanguage) throws SystemException {
		return findByGroupIdSeriveLang(groupId, serviceLanguage,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the advanced contents where groupId = &#63; and serviceLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param serviceLanguage the service language
	 * @param start the lower bound of the range of advanced contents
	 * @param end the upper bound of the range of advanced contents (not inclusive)
	 * @return the range of matching advanced contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvancedContent> findByGroupIdSeriveLang(long groupId,
		String serviceLanguage, int start, int end) throws SystemException {
		return findByGroupIdSeriveLang(groupId, serviceLanguage, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the advanced contents where groupId = &#63; and serviceLanguage = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param serviceLanguage the service language
	 * @param start the lower bound of the range of advanced contents
	 * @param end the upper bound of the range of advanced contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching advanced contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvancedContent> findByGroupIdSeriveLang(long groupId,
		String serviceLanguage, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDSERIVELANG;
			finderArgs = new Object[] { groupId, serviceLanguage };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDSERIVELANG;
			finderArgs = new Object[] {
					groupId, serviceLanguage,
					
					start, end, orderByComparator
				};
		}

		List<AdvancedContent> list = (List<AdvancedContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (AdvancedContent advancedContent : list) {
				if ((groupId != advancedContent.getGroupId()) ||
						!Validator.equals(serviceLanguage,
							advancedContent.getServiceLanguage())) {
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

			query.append(_SQL_SELECT_ADVANCEDCONTENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDSERIVELANG_GROUPID_2);

			boolean bindServiceLanguage = false;

			if (serviceLanguage == null) {
				query.append(_FINDER_COLUMN_GROUPIDSERIVELANG_SERVICELANGUAGE_1);
			}
			else if (serviceLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPIDSERIVELANG_SERVICELANGUAGE_3);
			}
			else {
				bindServiceLanguage = true;

				query.append(_FINDER_COLUMN_GROUPIDSERIVELANG_SERVICELANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdvancedContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindServiceLanguage) {
					qPos.add(serviceLanguage);
				}

				if (!pagination) {
					list = (List<AdvancedContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdvancedContent>(list);
				}
				else {
					list = (List<AdvancedContent>)QueryUtil.list(q,
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
	 * Returns the first advanced content in the ordered set where groupId = &#63; and serviceLanguage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param serviceLanguage the service language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching advanced content
	 * @throws org.kisti.edison.content.NoSuchAdvancedContentException if a matching advanced content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent findByGroupIdSeriveLang_First(long groupId,
		String serviceLanguage, OrderByComparator orderByComparator)
		throws NoSuchAdvancedContentException, SystemException {
		AdvancedContent advancedContent = fetchByGroupIdSeriveLang_First(groupId,
				serviceLanguage, orderByComparator);

		if (advancedContent != null) {
			return advancedContent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", serviceLanguage=");
		msg.append(serviceLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvancedContentException(msg.toString());
	}

	/**
	 * Returns the first advanced content in the ordered set where groupId = &#63; and serviceLanguage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param serviceLanguage the service language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching advanced content, or <code>null</code> if a matching advanced content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent fetchByGroupIdSeriveLang_First(long groupId,
		String serviceLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		List<AdvancedContent> list = findByGroupIdSeriveLang(groupId,
				serviceLanguage, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last advanced content in the ordered set where groupId = &#63; and serviceLanguage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param serviceLanguage the service language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching advanced content
	 * @throws org.kisti.edison.content.NoSuchAdvancedContentException if a matching advanced content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent findByGroupIdSeriveLang_Last(long groupId,
		String serviceLanguage, OrderByComparator orderByComparator)
		throws NoSuchAdvancedContentException, SystemException {
		AdvancedContent advancedContent = fetchByGroupIdSeriveLang_Last(groupId,
				serviceLanguage, orderByComparator);

		if (advancedContent != null) {
			return advancedContent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", serviceLanguage=");
		msg.append(serviceLanguage);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdvancedContentException(msg.toString());
	}

	/**
	 * Returns the last advanced content in the ordered set where groupId = &#63; and serviceLanguage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param serviceLanguage the service language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching advanced content, or <code>null</code> if a matching advanced content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent fetchByGroupIdSeriveLang_Last(long groupId,
		String serviceLanguage, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGroupIdSeriveLang(groupId, serviceLanguage);

		if (count == 0) {
			return null;
		}

		List<AdvancedContent> list = findByGroupIdSeriveLang(groupId,
				serviceLanguage, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the advanced contents before and after the current advanced content in the ordered set where groupId = &#63; and serviceLanguage = &#63;.
	 *
	 * @param advancedContentPK the primary key of the current advanced content
	 * @param groupId the group ID
	 * @param serviceLanguage the service language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next advanced content
	 * @throws org.kisti.edison.content.NoSuchAdvancedContentException if a advanced content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent[] findByGroupIdSeriveLang_PrevAndNext(
		AdvancedContentPK advancedContentPK, long groupId,
		String serviceLanguage, OrderByComparator orderByComparator)
		throws NoSuchAdvancedContentException, SystemException {
		AdvancedContent advancedContent = findByPrimaryKey(advancedContentPK);

		Session session = null;

		try {
			session = openSession();

			AdvancedContent[] array = new AdvancedContentImpl[3];

			array[0] = getByGroupIdSeriveLang_PrevAndNext(session,
					advancedContent, groupId, serviceLanguage,
					orderByComparator, true);

			array[1] = advancedContent;

			array[2] = getByGroupIdSeriveLang_PrevAndNext(session,
					advancedContent, groupId, serviceLanguage,
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

	protected AdvancedContent getByGroupIdSeriveLang_PrevAndNext(
		Session session, AdvancedContent advancedContent, long groupId,
		String serviceLanguage, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADVANCEDCONTENT_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDSERIVELANG_GROUPID_2);

		boolean bindServiceLanguage = false;

		if (serviceLanguage == null) {
			query.append(_FINDER_COLUMN_GROUPIDSERIVELANG_SERVICELANGUAGE_1);
		}
		else if (serviceLanguage.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_GROUPIDSERIVELANG_SERVICELANGUAGE_3);
		}
		else {
			bindServiceLanguage = true;

			query.append(_FINDER_COLUMN_GROUPIDSERIVELANG_SERVICELANGUAGE_2);
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
			query.append(AdvancedContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindServiceLanguage) {
			qPos.add(serviceLanguage);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(advancedContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdvancedContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the advanced contents where groupId = &#63; and serviceLanguage = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param serviceLanguage the service language
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupIdSeriveLang(long groupId, String serviceLanguage)
		throws SystemException {
		for (AdvancedContent advancedContent : findByGroupIdSeriveLang(
				groupId, serviceLanguage, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(advancedContent);
		}
	}

	/**
	 * Returns the number of advanced contents where groupId = &#63; and serviceLanguage = &#63;.
	 *
	 * @param groupId the group ID
	 * @param serviceLanguage the service language
	 * @return the number of matching advanced contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupIdSeriveLang(long groupId, String serviceLanguage)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDSERIVELANG;

		Object[] finderArgs = new Object[] { groupId, serviceLanguage };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ADVANCEDCONTENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDSERIVELANG_GROUPID_2);

			boolean bindServiceLanguage = false;

			if (serviceLanguage == null) {
				query.append(_FINDER_COLUMN_GROUPIDSERIVELANG_SERVICELANGUAGE_1);
			}
			else if (serviceLanguage.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GROUPIDSERIVELANG_SERVICELANGUAGE_3);
			}
			else {
				bindServiceLanguage = true;

				query.append(_FINDER_COLUMN_GROUPIDSERIVELANG_SERVICELANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindServiceLanguage) {
					qPos.add(serviceLanguage);
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

	private static final String _FINDER_COLUMN_GROUPIDSERIVELANG_GROUPID_2 = "advancedContent.id.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDSERIVELANG_SERVICELANGUAGE_1 =
		"advancedContent.serviceLanguage IS NULL";
	private static final String _FINDER_COLUMN_GROUPIDSERIVELANG_SERVICELANGUAGE_2 =
		"advancedContent.serviceLanguage = ?";
	private static final String _FINDER_COLUMN_GROUPIDSERIVELANG_SERVICELANGUAGE_3 =
		"(advancedContent.serviceLanguage IS NULL OR advancedContent.serviceLanguage = '')";

	public AdvancedContentPersistenceImpl() {
		setModelClass(AdvancedContent.class);
	}

	/**
	 * Caches the advanced content in the entity cache if it is enabled.
	 *
	 * @param advancedContent the advanced content
	 */
	@Override
	public void cacheResult(AdvancedContent advancedContent) {
		EntityCacheUtil.putResult(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
			AdvancedContentImpl.class, advancedContent.getPrimaryKey(),
			advancedContent);

		advancedContent.resetOriginalValues();
	}

	/**
	 * Caches the advanced contents in the entity cache if it is enabled.
	 *
	 * @param advancedContents the advanced contents
	 */
	@Override
	public void cacheResult(List<AdvancedContent> advancedContents) {
		for (AdvancedContent advancedContent : advancedContents) {
			if (EntityCacheUtil.getResult(
						AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
						AdvancedContentImpl.class,
						advancedContent.getPrimaryKey()) == null) {
				cacheResult(advancedContent);
			}
			else {
				advancedContent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all advanced contents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AdvancedContentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AdvancedContentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the advanced content.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdvancedContent advancedContent) {
		EntityCacheUtil.removeResult(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
			AdvancedContentImpl.class, advancedContent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdvancedContent> advancedContents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdvancedContent advancedContent : advancedContents) {
			EntityCacheUtil.removeResult(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
				AdvancedContentImpl.class, advancedContent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new advanced content with the primary key. Does not add the advanced content to the database.
	 *
	 * @param advancedContentPK the primary key for the new advanced content
	 * @return the new advanced content
	 */
	@Override
	public AdvancedContent create(AdvancedContentPK advancedContentPK) {
		AdvancedContent advancedContent = new AdvancedContentImpl();

		advancedContent.setNew(true);
		advancedContent.setPrimaryKey(advancedContentPK);

		return advancedContent;
	}

	/**
	 * Removes the advanced content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param advancedContentPK the primary key of the advanced content
	 * @return the advanced content that was removed
	 * @throws org.kisti.edison.content.NoSuchAdvancedContentException if a advanced content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent remove(AdvancedContentPK advancedContentPK)
		throws NoSuchAdvancedContentException, SystemException {
		return remove((Serializable)advancedContentPK);
	}

	/**
	 * Removes the advanced content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the advanced content
	 * @return the advanced content that was removed
	 * @throws org.kisti.edison.content.NoSuchAdvancedContentException if a advanced content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent remove(Serializable primaryKey)
		throws NoSuchAdvancedContentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AdvancedContent advancedContent = (AdvancedContent)session.get(AdvancedContentImpl.class,
					primaryKey);

			if (advancedContent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdvancedContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(advancedContent);
		}
		catch (NoSuchAdvancedContentException nsee) {
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
	protected AdvancedContent removeImpl(AdvancedContent advancedContent)
		throws SystemException {
		advancedContent = toUnwrappedModel(advancedContent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(advancedContent)) {
				advancedContent = (AdvancedContent)session.get(AdvancedContentImpl.class,
						advancedContent.getPrimaryKeyObj());
			}

			if (advancedContent != null) {
				session.delete(advancedContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (advancedContent != null) {
			clearCache(advancedContent);
		}

		return advancedContent;
	}

	@Override
	public AdvancedContent updateImpl(
		org.kisti.edison.content.model.AdvancedContent advancedContent)
		throws SystemException {
		advancedContent = toUnwrappedModel(advancedContent);

		boolean isNew = advancedContent.isNew();

		AdvancedContentModelImpl advancedContentModelImpl = (AdvancedContentModelImpl)advancedContent;

		Session session = null;

		try {
			session = openSession();

			if (advancedContent.isNew()) {
				session.save(advancedContent);

				advancedContent.setNew(false);
			}
			else {
				session.merge(advancedContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AdvancedContentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((advancedContentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						advancedContentModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { advancedContentModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((advancedContentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDSERIVELANG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						advancedContentModelImpl.getOriginalGroupId(),
						advancedContentModelImpl.getOriginalServiceLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDSERIVELANG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDSERIVELANG,
					args);

				args = new Object[] {
						advancedContentModelImpl.getGroupId(),
						advancedContentModelImpl.getServiceLanguage()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPIDSERIVELANG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDSERIVELANG,
					args);
			}
		}

		EntityCacheUtil.putResult(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
			AdvancedContentImpl.class, advancedContent.getPrimaryKey(),
			advancedContent);

		return advancedContent;
	}

	protected AdvancedContent toUnwrappedModel(AdvancedContent advancedContent) {
		if (advancedContent instanceof AdvancedContentImpl) {
			return advancedContent;
		}

		AdvancedContentImpl advancedContentImpl = new AdvancedContentImpl();

		advancedContentImpl.setNew(advancedContent.isNew());
		advancedContentImpl.setPrimaryKey(advancedContent.getPrimaryKey());

		advancedContentImpl.setContentSeq(advancedContent.getContentSeq());
		advancedContentImpl.setGroupId(advancedContent.getGroupId());
		advancedContentImpl.setTitle(advancedContent.getTitle());
		advancedContentImpl.setResume(advancedContent.getResume());
		advancedContentImpl.setContentFilePath(advancedContent.getContentFilePath());
		advancedContentImpl.setContentFileNm(advancedContent.getContentFileNm());
		advancedContentImpl.setContentStartFileNm(advancedContent.getContentStartFileNm());
		advancedContentImpl.setServiceLanguage(advancedContent.getServiceLanguage());
		advancedContentImpl.setViewCnt(advancedContent.getViewCnt());
		advancedContentImpl.setInsertId(advancedContent.getInsertId());
		advancedContentImpl.setInsertDate(advancedContent.getInsertDate());
		advancedContentImpl.setUpdateId(advancedContent.getUpdateId());
		advancedContentImpl.setUpdateDate(advancedContent.getUpdateDate());

		return advancedContentImpl;
	}

	/**
	 * Returns the advanced content with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the advanced content
	 * @return the advanced content
	 * @throws org.kisti.edison.content.NoSuchAdvancedContentException if a advanced content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdvancedContentException, SystemException {
		AdvancedContent advancedContent = fetchByPrimaryKey(primaryKey);

		if (advancedContent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdvancedContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return advancedContent;
	}

	/**
	 * Returns the advanced content with the primary key or throws a {@link org.kisti.edison.content.NoSuchAdvancedContentException} if it could not be found.
	 *
	 * @param advancedContentPK the primary key of the advanced content
	 * @return the advanced content
	 * @throws org.kisti.edison.content.NoSuchAdvancedContentException if a advanced content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent findByPrimaryKey(AdvancedContentPK advancedContentPK)
		throws NoSuchAdvancedContentException, SystemException {
		return findByPrimaryKey((Serializable)advancedContentPK);
	}

	/**
	 * Returns the advanced content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the advanced content
	 * @return the advanced content, or <code>null</code> if a advanced content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		AdvancedContent advancedContent = (AdvancedContent)EntityCacheUtil.getResult(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
				AdvancedContentImpl.class, primaryKey);

		if (advancedContent == _nullAdvancedContent) {
			return null;
		}

		if (advancedContent == null) {
			Session session = null;

			try {
				session = openSession();

				advancedContent = (AdvancedContent)session.get(AdvancedContentImpl.class,
						primaryKey);

				if (advancedContent != null) {
					cacheResult(advancedContent);
				}
				else {
					EntityCacheUtil.putResult(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
						AdvancedContentImpl.class, primaryKey,
						_nullAdvancedContent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(AdvancedContentModelImpl.ENTITY_CACHE_ENABLED,
					AdvancedContentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return advancedContent;
	}

	/**
	 * Returns the advanced content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param advancedContentPK the primary key of the advanced content
	 * @return the advanced content, or <code>null</code> if a advanced content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AdvancedContent fetchByPrimaryKey(
		AdvancedContentPK advancedContentPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)advancedContentPK);
	}

	/**
	 * Returns all the advanced contents.
	 *
	 * @return the advanced contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvancedContent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the advanced contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of advanced contents
	 * @param end the upper bound of the range of advanced contents (not inclusive)
	 * @return the range of advanced contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvancedContent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the advanced contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of advanced contents
	 * @param end the upper bound of the range of advanced contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of advanced contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<AdvancedContent> findAll(int start, int end,
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

		List<AdvancedContent> list = (List<AdvancedContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ADVANCEDCONTENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADVANCEDCONTENT;

				if (pagination) {
					sql = sql.concat(AdvancedContentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AdvancedContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<AdvancedContent>(list);
				}
				else {
					list = (List<AdvancedContent>)QueryUtil.list(q,
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
	 * Removes all the advanced contents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (AdvancedContent advancedContent : findAll()) {
			remove(advancedContent);
		}
	}

	/**
	 * Returns the number of advanced contents.
	 *
	 * @return the number of advanced contents
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

				Query q = session.createQuery(_SQL_COUNT_ADVANCEDCONTENT);

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
	 * Initializes the advanced content persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.content.model.AdvancedContent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AdvancedContent>> listenersList = new ArrayList<ModelListener<AdvancedContent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AdvancedContent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AdvancedContentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ADVANCEDCONTENT = "SELECT advancedContent FROM AdvancedContent advancedContent";
	private static final String _SQL_SELECT_ADVANCEDCONTENT_WHERE = "SELECT advancedContent FROM AdvancedContent advancedContent WHERE ";
	private static final String _SQL_COUNT_ADVANCEDCONTENT = "SELECT COUNT(advancedContent) FROM AdvancedContent advancedContent";
	private static final String _SQL_COUNT_ADVANCEDCONTENT_WHERE = "SELECT COUNT(advancedContent) FROM AdvancedContent advancedContent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "advancedContent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdvancedContent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdvancedContent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AdvancedContentPersistenceImpl.class);
	private static AdvancedContent _nullAdvancedContent = new AdvancedContentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AdvancedContent> toCacheModel() {
				return _nullAdvancedContentCacheModel;
			}
		};

	private static CacheModel<AdvancedContent> _nullAdvancedContentCacheModel = new CacheModel<AdvancedContent>() {
			@Override
			public AdvancedContent toEntityModel() {
				return _nullAdvancedContent;
			}
		};
}