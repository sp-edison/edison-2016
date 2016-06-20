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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.kisti.edison.content.NoSuchGeneralContentException;
import org.kisti.edison.content.model.GeneralContent;
import org.kisti.edison.content.model.impl.GeneralContentImpl;
import org.kisti.edison.content.model.impl.GeneralContentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the general content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see GeneralContentPersistence
 * @see GeneralContentUtil
 * @generated
 */
public class GeneralContentPersistenceImpl extends BasePersistenceImpl<GeneralContent>
	implements GeneralContentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeneralContentUtil} to access the general content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeneralContentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentModelImpl.FINDER_CACHE_ENABLED,
			GeneralContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentModelImpl.FINDER_CACHE_ENABLED,
			GeneralContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentModelImpl.FINDER_CACHE_ENABLED,
			GeneralContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentModelImpl.FINDER_CACHE_ENABLED,
			GeneralContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			GeneralContentModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the general contents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralContent> findByGroupId(long groupId)
		throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the general contents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of general contents
	 * @param end the upper bound of the range of general contents (not inclusive)
	 * @return the range of matching general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralContent> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the general contents where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of general contents
	 * @param end the upper bound of the range of general contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralContent> findByGroupId(long groupId, int start, int end,
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

		List<GeneralContent> list = (List<GeneralContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GeneralContent generalContent : list) {
				if ((groupId != generalContent.getGroupId())) {
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

			query.append(_SQL_SELECT_GENERALCONTENT_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GeneralContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<GeneralContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeneralContent>(list);
				}
				else {
					list = (List<GeneralContent>)QueryUtil.list(q,
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
	 * Returns the first general content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching general content
	 * @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchGeneralContentException, SystemException {
		GeneralContent generalContent = fetchByGroupId_First(groupId,
				orderByComparator);

		if (generalContent != null) {
			return generalContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeneralContentException(msg.toString());
	}

	/**
	 * Returns the first general content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching general content, or <code>null</code> if a matching general content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GeneralContent> list = findByGroupId(groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last general content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching general content
	 * @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchGeneralContentException, SystemException {
		GeneralContent generalContent = fetchByGroupId_Last(groupId,
				orderByComparator);

		if (generalContent != null) {
			return generalContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeneralContentException(msg.toString());
	}

	/**
	 * Returns the last general content in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching general content, or <code>null</code> if a matching general content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<GeneralContent> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the general contents before and after the current general content in the ordered set where groupId = &#63;.
	 *
	 * @param generalContentPK the primary key of the current general content
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next general content
	 * @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent[] findByGroupId_PrevAndNext(
		GeneralContentPK generalContentPK, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchGeneralContentException, SystemException {
		GeneralContent generalContent = findByPrimaryKey(generalContentPK);

		Session session = null;

		try {
			session = openSession();

			GeneralContent[] array = new GeneralContentImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, generalContent,
					groupId, orderByComparator, true);

			array[1] = generalContent;

			array[2] = getByGroupId_PrevAndNext(session, generalContent,
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

	protected GeneralContent getByGroupId_PrevAndNext(Session session,
		GeneralContent generalContent, long groupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GENERALCONTENT_WHERE);

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
			query.append(GeneralContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(generalContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GeneralContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the general contents where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (GeneralContent generalContent : findByGroupId(groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(generalContent);
		}
	}

	/**
	 * Returns the number of general contents where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching general contents
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

			query.append(_SQL_COUNT_GENERALCONTENT_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "generalContent.id.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENTSEQ =
		new FinderPath(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentModelImpl.FINDER_CACHE_ENABLED,
			GeneralContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContentSeq",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTSEQ =
		new FinderPath(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentModelImpl.FINDER_CACHE_ENABLED,
			GeneralContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContentSeq",
			new String[] { Long.class.getName() },
			GeneralContentModelImpl.CONTENTSEQ_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTENTSEQ = new FinderPath(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContentSeq",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the general contents where contentSeq = &#63;.
	 *
	 * @param contentSeq the content seq
	 * @return the matching general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralContent> findByContentSeq(long contentSeq)
		throws SystemException {
		return findByContentSeq(contentSeq, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the general contents where contentSeq = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contentSeq the content seq
	 * @param start the lower bound of the range of general contents
	 * @param end the upper bound of the range of general contents (not inclusive)
	 * @return the range of matching general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralContent> findByContentSeq(long contentSeq, int start,
		int end) throws SystemException {
		return findByContentSeq(contentSeq, start, end, null);
	}

	/**
	 * Returns an ordered range of all the general contents where contentSeq = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param contentSeq the content seq
	 * @param start the lower bound of the range of general contents
	 * @param end the upper bound of the range of general contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralContent> findByContentSeq(long contentSeq, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTSEQ;
			finderArgs = new Object[] { contentSeq };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENTSEQ;
			finderArgs = new Object[] { contentSeq, start, end, orderByComparator };
		}

		List<GeneralContent> list = (List<GeneralContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GeneralContent generalContent : list) {
				if ((contentSeq != generalContent.getContentSeq())) {
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

			query.append(_SQL_SELECT_GENERALCONTENT_WHERE);

			query.append(_FINDER_COLUMN_CONTENTSEQ_CONTENTSEQ_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GeneralContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contentSeq);

				if (!pagination) {
					list = (List<GeneralContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeneralContent>(list);
				}
				else {
					list = (List<GeneralContent>)QueryUtil.list(q,
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
	 * Returns the first general content in the ordered set where contentSeq = &#63;.
	 *
	 * @param contentSeq the content seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching general content
	 * @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent findByContentSeq_First(long contentSeq,
		OrderByComparator orderByComparator)
		throws NoSuchGeneralContentException, SystemException {
		GeneralContent generalContent = fetchByContentSeq_First(contentSeq,
				orderByComparator);

		if (generalContent != null) {
			return generalContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contentSeq=");
		msg.append(contentSeq);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeneralContentException(msg.toString());
	}

	/**
	 * Returns the first general content in the ordered set where contentSeq = &#63;.
	 *
	 * @param contentSeq the content seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching general content, or <code>null</code> if a matching general content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent fetchByContentSeq_First(long contentSeq,
		OrderByComparator orderByComparator) throws SystemException {
		List<GeneralContent> list = findByContentSeq(contentSeq, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last general content in the ordered set where contentSeq = &#63;.
	 *
	 * @param contentSeq the content seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching general content
	 * @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent findByContentSeq_Last(long contentSeq,
		OrderByComparator orderByComparator)
		throws NoSuchGeneralContentException, SystemException {
		GeneralContent generalContent = fetchByContentSeq_Last(contentSeq,
				orderByComparator);

		if (generalContent != null) {
			return generalContent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("contentSeq=");
		msg.append(contentSeq);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeneralContentException(msg.toString());
	}

	/**
	 * Returns the last general content in the ordered set where contentSeq = &#63;.
	 *
	 * @param contentSeq the content seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching general content, or <code>null</code> if a matching general content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent fetchByContentSeq_Last(long contentSeq,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContentSeq(contentSeq);

		if (count == 0) {
			return null;
		}

		List<GeneralContent> list = findByContentSeq(contentSeq, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the general contents before and after the current general content in the ordered set where contentSeq = &#63;.
	 *
	 * @param generalContentPK the primary key of the current general content
	 * @param contentSeq the content seq
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next general content
	 * @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent[] findByContentSeq_PrevAndNext(
		GeneralContentPK generalContentPK, long contentSeq,
		OrderByComparator orderByComparator)
		throws NoSuchGeneralContentException, SystemException {
		GeneralContent generalContent = findByPrimaryKey(generalContentPK);

		Session session = null;

		try {
			session = openSession();

			GeneralContent[] array = new GeneralContentImpl[3];

			array[0] = getByContentSeq_PrevAndNext(session, generalContent,
					contentSeq, orderByComparator, true);

			array[1] = generalContent;

			array[2] = getByContentSeq_PrevAndNext(session, generalContent,
					contentSeq, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GeneralContent getByContentSeq_PrevAndNext(Session session,
		GeneralContent generalContent, long contentSeq,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GENERALCONTENT_WHERE);

		query.append(_FINDER_COLUMN_CONTENTSEQ_CONTENTSEQ_2);

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
			query.append(GeneralContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(contentSeq);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(generalContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GeneralContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the general contents where contentSeq = &#63; from the database.
	 *
	 * @param contentSeq the content seq
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContentSeq(long contentSeq) throws SystemException {
		for (GeneralContent generalContent : findByContentSeq(contentSeq,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(generalContent);
		}
	}

	/**
	 * Returns the number of general contents where contentSeq = &#63;.
	 *
	 * @param contentSeq the content seq
	 * @return the number of matching general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContentSeq(long contentSeq) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTENTSEQ;

		Object[] finderArgs = new Object[] { contentSeq };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GENERALCONTENT_WHERE);

			query.append(_FINDER_COLUMN_CONTENTSEQ_CONTENTSEQ_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(contentSeq);

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

	private static final String _FINDER_COLUMN_CONTENTSEQ_CONTENTSEQ_2 = "generalContent.id.contentSeq = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENTDIV =
		new FinderPath(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentModelImpl.FINDER_CACHE_ENABLED,
			GeneralContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByContentDiv",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTDIV =
		new FinderPath(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentModelImpl.FINDER_CACHE_ENABLED,
			GeneralContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByContentDiv",
			new String[] { Long.class.getName(), Long.class.getName() },
			GeneralContentModelImpl.GROUPID_COLUMN_BITMASK |
			GeneralContentModelImpl.CONTENTDIV_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTENTDIV = new FinderPath(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContentDiv",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the general contents where groupId = &#63; and contentDiv = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentDiv the content div
	 * @return the matching general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralContent> findByContentDiv(long groupId, long contentDiv)
		throws SystemException {
		return findByContentDiv(groupId, contentDiv, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the general contents where groupId = &#63; and contentDiv = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentDiv the content div
	 * @param start the lower bound of the range of general contents
	 * @param end the upper bound of the range of general contents (not inclusive)
	 * @return the range of matching general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralContent> findByContentDiv(long groupId, long contentDiv,
		int start, int end) throws SystemException {
		return findByContentDiv(groupId, contentDiv, start, end, null);
	}

	/**
	 * Returns an ordered range of all the general contents where groupId = &#63; and contentDiv = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param contentDiv the content div
	 * @param start the lower bound of the range of general contents
	 * @param end the upper bound of the range of general contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralContent> findByContentDiv(long groupId, long contentDiv,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTDIV;
			finderArgs = new Object[] { groupId, contentDiv };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONTENTDIV;
			finderArgs = new Object[] {
					groupId, contentDiv,
					
					start, end, orderByComparator
				};
		}

		List<GeneralContent> list = (List<GeneralContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GeneralContent generalContent : list) {
				if ((groupId != generalContent.getGroupId()) ||
						(contentDiv != generalContent.getContentDiv())) {
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

			query.append(_SQL_SELECT_GENERALCONTENT_WHERE);

			query.append(_FINDER_COLUMN_CONTENTDIV_GROUPID_2);

			query.append(_FINDER_COLUMN_CONTENTDIV_CONTENTDIV_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GeneralContentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(contentDiv);

				if (!pagination) {
					list = (List<GeneralContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeneralContent>(list);
				}
				else {
					list = (List<GeneralContent>)QueryUtil.list(q,
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
	 * Returns the first general content in the ordered set where groupId = &#63; and contentDiv = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentDiv the content div
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching general content
	 * @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent findByContentDiv_First(long groupId, long contentDiv,
		OrderByComparator orderByComparator)
		throws NoSuchGeneralContentException, SystemException {
		GeneralContent generalContent = fetchByContentDiv_First(groupId,
				contentDiv, orderByComparator);

		if (generalContent != null) {
			return generalContent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentDiv=");
		msg.append(contentDiv);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeneralContentException(msg.toString());
	}

	/**
	 * Returns the first general content in the ordered set where groupId = &#63; and contentDiv = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentDiv the content div
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching general content, or <code>null</code> if a matching general content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent fetchByContentDiv_First(long groupId,
		long contentDiv, OrderByComparator orderByComparator)
		throws SystemException {
		List<GeneralContent> list = findByContentDiv(groupId, contentDiv, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last general content in the ordered set where groupId = &#63; and contentDiv = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentDiv the content div
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching general content
	 * @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent findByContentDiv_Last(long groupId, long contentDiv,
		OrderByComparator orderByComparator)
		throws NoSuchGeneralContentException, SystemException {
		GeneralContent generalContent = fetchByContentDiv_Last(groupId,
				contentDiv, orderByComparator);

		if (generalContent != null) {
			return generalContent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", contentDiv=");
		msg.append(contentDiv);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeneralContentException(msg.toString());
	}

	/**
	 * Returns the last general content in the ordered set where groupId = &#63; and contentDiv = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentDiv the content div
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching general content, or <code>null</code> if a matching general content could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent fetchByContentDiv_Last(long groupId, long contentDiv,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByContentDiv(groupId, contentDiv);

		if (count == 0) {
			return null;
		}

		List<GeneralContent> list = findByContentDiv(groupId, contentDiv,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the general contents before and after the current general content in the ordered set where groupId = &#63; and contentDiv = &#63;.
	 *
	 * @param generalContentPK the primary key of the current general content
	 * @param groupId the group ID
	 * @param contentDiv the content div
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next general content
	 * @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent[] findByContentDiv_PrevAndNext(
		GeneralContentPK generalContentPK, long groupId, long contentDiv,
		OrderByComparator orderByComparator)
		throws NoSuchGeneralContentException, SystemException {
		GeneralContent generalContent = findByPrimaryKey(generalContentPK);

		Session session = null;

		try {
			session = openSession();

			GeneralContent[] array = new GeneralContentImpl[3];

			array[0] = getByContentDiv_PrevAndNext(session, generalContent,
					groupId, contentDiv, orderByComparator, true);

			array[1] = generalContent;

			array[2] = getByContentDiv_PrevAndNext(session, generalContent,
					groupId, contentDiv, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GeneralContent getByContentDiv_PrevAndNext(Session session,
		GeneralContent generalContent, long groupId, long contentDiv,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GENERALCONTENT_WHERE);

		query.append(_FINDER_COLUMN_CONTENTDIV_GROUPID_2);

		query.append(_FINDER_COLUMN_CONTENTDIV_CONTENTDIV_2);

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
			query.append(GeneralContentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(contentDiv);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(generalContent);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GeneralContent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the general contents where groupId = &#63; and contentDiv = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param contentDiv the content div
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByContentDiv(long groupId, long contentDiv)
		throws SystemException {
		for (GeneralContent generalContent : findByContentDiv(groupId,
				contentDiv, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(generalContent);
		}
	}

	/**
	 * Returns the number of general contents where groupId = &#63; and contentDiv = &#63;.
	 *
	 * @param groupId the group ID
	 * @param contentDiv the content div
	 * @return the number of matching general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContentDiv(long groupId, long contentDiv)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTENTDIV;

		Object[] finderArgs = new Object[] { groupId, contentDiv };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GENERALCONTENT_WHERE);

			query.append(_FINDER_COLUMN_CONTENTDIV_GROUPID_2);

			query.append(_FINDER_COLUMN_CONTENTDIV_CONTENTDIV_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(contentDiv);

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

	private static final String _FINDER_COLUMN_CONTENTDIV_GROUPID_2 = "generalContent.id.groupId = ? AND ";
	private static final String _FINDER_COLUMN_CONTENTDIV_CONTENTDIV_2 = "generalContent.contentDiv = ?";

	public GeneralContentPersistenceImpl() {
		setModelClass(GeneralContent.class);
	}

	/**
	 * Caches the general content in the entity cache if it is enabled.
	 *
	 * @param generalContent the general content
	 */
	@Override
	public void cacheResult(GeneralContent generalContent) {
		EntityCacheUtil.putResult(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentImpl.class, generalContent.getPrimaryKey(),
			generalContent);

		generalContent.resetOriginalValues();
	}

	/**
	 * Caches the general contents in the entity cache if it is enabled.
	 *
	 * @param generalContents the general contents
	 */
	@Override
	public void cacheResult(List<GeneralContent> generalContents) {
		for (GeneralContent generalContent : generalContents) {
			if (EntityCacheUtil.getResult(
						GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
						GeneralContentImpl.class, generalContent.getPrimaryKey()) == null) {
				cacheResult(generalContent);
			}
			else {
				generalContent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all general contents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GeneralContentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GeneralContentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the general content.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GeneralContent generalContent) {
		EntityCacheUtil.removeResult(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentImpl.class, generalContent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GeneralContent> generalContents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GeneralContent generalContent : generalContents) {
			EntityCacheUtil.removeResult(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
				GeneralContentImpl.class, generalContent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new general content with the primary key. Does not add the general content to the database.
	 *
	 * @param generalContentPK the primary key for the new general content
	 * @return the new general content
	 */
	@Override
	public GeneralContent create(GeneralContentPK generalContentPK) {
		GeneralContent generalContent = new GeneralContentImpl();

		generalContent.setNew(true);
		generalContent.setPrimaryKey(generalContentPK);

		return generalContent;
	}

	/**
	 * Removes the general content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param generalContentPK the primary key of the general content
	 * @return the general content that was removed
	 * @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent remove(GeneralContentPK generalContentPK)
		throws NoSuchGeneralContentException, SystemException {
		return remove((Serializable)generalContentPK);
	}

	/**
	 * Removes the general content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the general content
	 * @return the general content that was removed
	 * @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent remove(Serializable primaryKey)
		throws NoSuchGeneralContentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GeneralContent generalContent = (GeneralContent)session.get(GeneralContentImpl.class,
					primaryKey);

			if (generalContent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeneralContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(generalContent);
		}
		catch (NoSuchGeneralContentException nsee) {
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
	protected GeneralContent removeImpl(GeneralContent generalContent)
		throws SystemException {
		generalContent = toUnwrappedModel(generalContent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(generalContent)) {
				generalContent = (GeneralContent)session.get(GeneralContentImpl.class,
						generalContent.getPrimaryKeyObj());
			}

			if (generalContent != null) {
				session.delete(generalContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (generalContent != null) {
			clearCache(generalContent);
		}

		return generalContent;
	}

	@Override
	public GeneralContent updateImpl(
		org.kisti.edison.content.model.GeneralContent generalContent)
		throws SystemException {
		generalContent = toUnwrappedModel(generalContent);

		boolean isNew = generalContent.isNew();

		GeneralContentModelImpl generalContentModelImpl = (GeneralContentModelImpl)generalContent;

		Session session = null;

		try {
			session = openSession();

			if (generalContent.isNew()) {
				session.save(generalContent);

				generalContent.setNew(false);
			}
			else {
				session.merge(generalContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GeneralContentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((generalContentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						generalContentModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { generalContentModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((generalContentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTSEQ.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						generalContentModelImpl.getOriginalContentSeq()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTENTSEQ,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTSEQ,
					args);

				args = new Object[] { generalContentModelImpl.getContentSeq() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTENTSEQ,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTSEQ,
					args);
			}

			if ((generalContentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTDIV.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						generalContentModelImpl.getOriginalGroupId(),
						generalContentModelImpl.getOriginalContentDiv()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTENTDIV,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTDIV,
					args);

				args = new Object[] {
						generalContentModelImpl.getGroupId(),
						generalContentModelImpl.getContentDiv()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTENTDIV,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONTENTDIV,
					args);
			}
		}

		EntityCacheUtil.putResult(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
			GeneralContentImpl.class, generalContent.getPrimaryKey(),
			generalContent);

		return generalContent;
	}

	protected GeneralContent toUnwrappedModel(GeneralContent generalContent) {
		if (generalContent instanceof GeneralContentImpl) {
			return generalContent;
		}

		GeneralContentImpl generalContentImpl = new GeneralContentImpl();

		generalContentImpl.setNew(generalContent.isNew());
		generalContentImpl.setPrimaryKey(generalContent.getPrimaryKey());

		generalContentImpl.setContentSeq(generalContent.getContentSeq());
		generalContentImpl.setGroupId(generalContent.getGroupId());
		generalContentImpl.setContentDiv(generalContent.getContentDiv());
		generalContentImpl.setTitle(generalContent.getTitle());
		generalContentImpl.setDownloadCnt(generalContent.getDownloadCnt());
		generalContentImpl.setServiceLanguage(generalContent.getServiceLanguage());
		generalContentImpl.setProjectYn(generalContent.getProjectYn());
		generalContentImpl.setProjectId(generalContent.getProjectId());
		generalContentImpl.setInsertId(generalContent.getInsertId());
		generalContentImpl.setInsertDate(generalContent.getInsertDate());
		generalContentImpl.setUpdateId(generalContent.getUpdateId());
		generalContentImpl.setUpdateDate(generalContent.getUpdateDate());

		return generalContentImpl;
	}

	/**
	 * Returns the general content with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the general content
	 * @return the general content
	 * @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeneralContentException, SystemException {
		GeneralContent generalContent = fetchByPrimaryKey(primaryKey);

		if (generalContent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeneralContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return generalContent;
	}

	/**
	 * Returns the general content with the primary key or throws a {@link org.kisti.edison.content.NoSuchGeneralContentException} if it could not be found.
	 *
	 * @param generalContentPK the primary key of the general content
	 * @return the general content
	 * @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent findByPrimaryKey(GeneralContentPK generalContentPK)
		throws NoSuchGeneralContentException, SystemException {
		return findByPrimaryKey((Serializable)generalContentPK);
	}

	/**
	 * Returns the general content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the general content
	 * @return the general content, or <code>null</code> if a general content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GeneralContent generalContent = (GeneralContent)EntityCacheUtil.getResult(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
				GeneralContentImpl.class, primaryKey);

		if (generalContent == _nullGeneralContent) {
			return null;
		}

		if (generalContent == null) {
			Session session = null;

			try {
				session = openSession();

				generalContent = (GeneralContent)session.get(GeneralContentImpl.class,
						primaryKey);

				if (generalContent != null) {
					cacheResult(generalContent);
				}
				else {
					EntityCacheUtil.putResult(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
						GeneralContentImpl.class, primaryKey,
						_nullGeneralContent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GeneralContentModelImpl.ENTITY_CACHE_ENABLED,
					GeneralContentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return generalContent;
	}

	/**
	 * Returns the general content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param generalContentPK the primary key of the general content
	 * @return the general content, or <code>null</code> if a general content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GeneralContent fetchByPrimaryKey(GeneralContentPK generalContentPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)generalContentPK);
	}

	/**
	 * Returns all the general contents.
	 *
	 * @return the general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralContent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the general contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of general contents
	 * @param end the upper bound of the range of general contents (not inclusive)
	 * @return the range of general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralContent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the general contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of general contents
	 * @param end the upper bound of the range of general contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of general contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GeneralContent> findAll(int start, int end,
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

		List<GeneralContent> list = (List<GeneralContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GENERALCONTENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GENERALCONTENT;

				if (pagination) {
					sql = sql.concat(GeneralContentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GeneralContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GeneralContent>(list);
				}
				else {
					list = (List<GeneralContent>)QueryUtil.list(q,
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
	 * Removes all the general contents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GeneralContent generalContent : findAll()) {
			remove(generalContent);
		}
	}

	/**
	 * Returns the number of general contents.
	 *
	 * @return the number of general contents
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

				Query q = session.createQuery(_SQL_COUNT_GENERALCONTENT);

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
	 * Initializes the general content persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.content.model.GeneralContent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GeneralContent>> listenersList = new ArrayList<ModelListener<GeneralContent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GeneralContent>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GeneralContentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GENERALCONTENT = "SELECT generalContent FROM GeneralContent generalContent";
	private static final String _SQL_SELECT_GENERALCONTENT_WHERE = "SELECT generalContent FROM GeneralContent generalContent WHERE ";
	private static final String _SQL_COUNT_GENERALCONTENT = "SELECT COUNT(generalContent) FROM GeneralContent generalContent";
	private static final String _SQL_COUNT_GENERALCONTENT_WHERE = "SELECT COUNT(generalContent) FROM GeneralContent generalContent WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "generalContent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GeneralContent exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GeneralContent exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GeneralContentPersistenceImpl.class);
	private static GeneralContent _nullGeneralContent = new GeneralContentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GeneralContent> toCacheModel() {
				return _nullGeneralContentCacheModel;
			}
		};

	private static CacheModel<GeneralContent> _nullGeneralContentCacheModel = new CacheModel<GeneralContent>() {
			@Override
			public GeneralContent toEntityModel() {
				return _nullGeneralContent;
			}
		};
}