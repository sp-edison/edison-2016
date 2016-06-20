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

package org.kisti.edison.service.persistence;

import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import org.kisti.edison.NoSuchWorkflowInstanceException;
import org.kisti.edison.model.WorkflowInstance;
import org.kisti.edison.model.impl.WorkflowInstanceImpl;
import org.kisti.edison.model.impl.WorkflowInstanceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the workflow instance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see WorkflowInstancePersistence
 * @see WorkflowInstanceUtil
 * @generated
 */
public class WorkflowInstancePersistenceImpl extends BasePersistenceImpl<WorkflowInstance>
	implements WorkflowInstancePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkflowInstanceUtil} to access the workflow instance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkflowInstanceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowInstanceModelImpl.FINDER_CACHE_ENABLED,
			WorkflowInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowInstanceModelImpl.FINDER_CACHE_ENABLED,
			WorkflowInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowInstanceModelImpl.FINDER_CACHE_ENABLED,
			WorkflowInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTitle",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLE = new FinderPath(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTitle",
			new String[] { String.class.getName() });

	/**
	 * Returns all the workflow instances where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the matching workflow instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowInstance> findByTitle(String title)
		throws SystemException {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workflow instances where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of workflow instances
	 * @param end the upper bound of the range of workflow instances (not inclusive)
	 * @return the range of matching workflow instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowInstance> findByTitle(String title, int start, int end)
		throws SystemException {
		return findByTitle(title, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflow instances where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of workflow instances
	 * @param end the upper bound of the range of workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workflow instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowInstance> findByTitle(String title, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
		finderArgs = new Object[] { title, start, end, orderByComparator };

		List<WorkflowInstance> list = (List<WorkflowInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WorkflowInstance workflowInstance : list) {
				if (!StringUtil.wildcardMatches(workflowInstance.getTitle(),
							title, CharPool.UNDERLINE, CharPool.PERCENT,
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

			query.append(_SQL_SELECT_WORKFLOWINSTANCE_WHERE);

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
				query.append(WorkflowInstanceModelImpl.ORDER_BY_JPQL);
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
					list = (List<WorkflowInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkflowInstance>(list);
				}
				else {
					list = (List<WorkflowInstance>)QueryUtil.list(q,
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
	 * Returns the first workflow instance in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow instance
	 * @throws org.kisti.edison.NoSuchWorkflowInstanceException if a matching workflow instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance findByTitle_First(String title,
		OrderByComparator orderByComparator)
		throws NoSuchWorkflowInstanceException, SystemException {
		WorkflowInstance workflowInstance = fetchByTitle_First(title,
				orderByComparator);

		if (workflowInstance != null) {
			return workflowInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowInstanceException(msg.toString());
	}

	/**
	 * Returns the first workflow instance in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow instance, or <code>null</code> if a matching workflow instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance fetchByTitle_First(String title,
		OrderByComparator orderByComparator) throws SystemException {
		List<WorkflowInstance> list = findByTitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last workflow instance in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow instance
	 * @throws org.kisti.edison.NoSuchWorkflowInstanceException if a matching workflow instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance findByTitle_Last(String title,
		OrderByComparator orderByComparator)
		throws NoSuchWorkflowInstanceException, SystemException {
		WorkflowInstance workflowInstance = fetchByTitle_Last(title,
				orderByComparator);

		if (workflowInstance != null) {
			return workflowInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowInstanceException(msg.toString());
	}

	/**
	 * Returns the last workflow instance in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow instance, or <code>null</code> if a matching workflow instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance fetchByTitle_Last(String title,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitle(title);

		if (count == 0) {
			return null;
		}

		List<WorkflowInstance> list = findByTitle(title, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the workflow instances before and after the current workflow instance in the ordered set where title LIKE &#63;.
	 *
	 * @param workflowInstanceId the primary key of the current workflow instance
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workflow instance
	 * @throws org.kisti.edison.NoSuchWorkflowInstanceException if a workflow instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance[] findByTitle_PrevAndNext(long workflowInstanceId,
		String title, OrderByComparator orderByComparator)
		throws NoSuchWorkflowInstanceException, SystemException {
		WorkflowInstance workflowInstance = findByPrimaryKey(workflowInstanceId);

		Session session = null;

		try {
			session = openSession();

			WorkflowInstance[] array = new WorkflowInstanceImpl[3];

			array[0] = getByTitle_PrevAndNext(session, workflowInstance, title,
					orderByComparator, true);

			array[1] = workflowInstance;

			array[2] = getByTitle_PrevAndNext(session, workflowInstance, title,
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

	protected WorkflowInstance getByTitle_PrevAndNext(Session session,
		WorkflowInstance workflowInstance, String title,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKFLOWINSTANCE_WHERE);

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
			query.append(WorkflowInstanceModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(workflowInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkflowInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the workflow instances where title LIKE &#63; from the database.
	 *
	 * @param title the title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitle(String title) throws SystemException {
		for (WorkflowInstance workflowInstance : findByTitle(title,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workflowInstance);
		}
	}

	/**
	 * Returns the number of workflow instances where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the number of matching workflow instances
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

			query.append(_SQL_COUNT_WORKFLOWINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "workflowInstance.title LIKE NULL";
	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "workflowInstance.title LIKE ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(workflowInstance.title IS NULL OR workflowInstance.title LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowInstanceModelImpl.FINDER_CACHE_ENABLED,
			WorkflowInstanceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowInstanceModelImpl.FINDER_CACHE_ENABLED,
			WorkflowInstanceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			WorkflowInstanceModelImpl.USERID_COLUMN_BITMASK |
			WorkflowInstanceModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowInstanceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the workflow instances where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching workflow instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowInstance> findByUserId(long userId)
		throws SystemException {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workflow instances where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of workflow instances
	 * @param end the upper bound of the range of workflow instances (not inclusive)
	 * @return the range of matching workflow instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowInstance> findByUserId(long userId, int start, int end)
		throws SystemException {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflow instances where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of workflow instances
	 * @param end the upper bound of the range of workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workflow instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowInstance> findByUserId(long userId, int start, int end,
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

		List<WorkflowInstance> list = (List<WorkflowInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (WorkflowInstance workflowInstance : list) {
				if ((userId != workflowInstance.getUserId())) {
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

			query.append(_SQL_SELECT_WORKFLOWINSTANCE_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkflowInstanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<WorkflowInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkflowInstance>(list);
				}
				else {
					list = (List<WorkflowInstance>)QueryUtil.list(q,
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
	 * Returns the first workflow instance in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow instance
	 * @throws org.kisti.edison.NoSuchWorkflowInstanceException if a matching workflow instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance findByUserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkflowInstanceException, SystemException {
		WorkflowInstance workflowInstance = fetchByUserId_First(userId,
				orderByComparator);

		if (workflowInstance != null) {
			return workflowInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowInstanceException(msg.toString());
	}

	/**
	 * Returns the first workflow instance in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow instance, or <code>null</code> if a matching workflow instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance fetchByUserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<WorkflowInstance> list = findByUserId(userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last workflow instance in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow instance
	 * @throws org.kisti.edison.NoSuchWorkflowInstanceException if a matching workflow instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance findByUserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkflowInstanceException, SystemException {
		WorkflowInstance workflowInstance = fetchByUserId_Last(userId,
				orderByComparator);

		if (workflowInstance != null) {
			return workflowInstance;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowInstanceException(msg.toString());
	}

	/**
	 * Returns the last workflow instance in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow instance, or <code>null</code> if a matching workflow instance could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance fetchByUserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<WorkflowInstance> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the workflow instances before and after the current workflow instance in the ordered set where userId = &#63;.
	 *
	 * @param workflowInstanceId the primary key of the current workflow instance
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workflow instance
	 * @throws org.kisti.edison.NoSuchWorkflowInstanceException if a workflow instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance[] findByUserId_PrevAndNext(
		long workflowInstanceId, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchWorkflowInstanceException, SystemException {
		WorkflowInstance workflowInstance = findByPrimaryKey(workflowInstanceId);

		Session session = null;

		try {
			session = openSession();

			WorkflowInstance[] array = new WorkflowInstanceImpl[3];

			array[0] = getByUserId_PrevAndNext(session, workflowInstance,
					userId, orderByComparator, true);

			array[1] = workflowInstance;

			array[2] = getByUserId_PrevAndNext(session, workflowInstance,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected WorkflowInstance getByUserId_PrevAndNext(Session session,
		WorkflowInstance workflowInstance, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKFLOWINSTANCE_WHERE);

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
			query.append(WorkflowInstanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workflowInstance);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<WorkflowInstance> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the workflow instances where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUserId(long userId) throws SystemException {
		for (WorkflowInstance workflowInstance : findByUserId(userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(workflowInstance);
		}
	}

	/**
	 * Returns the number of workflow instances where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching workflow instances
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

			query.append(_SQL_COUNT_WORKFLOWINSTANCE_WHERE);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "workflowInstance.userId = ?";

	public WorkflowInstancePersistenceImpl() {
		setModelClass(WorkflowInstance.class);
	}

	/**
	 * Caches the workflow instance in the entity cache if it is enabled.
	 *
	 * @param workflowInstance the workflow instance
	 */
	@Override
	public void cacheResult(WorkflowInstance workflowInstance) {
		EntityCacheUtil.putResult(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowInstanceImpl.class, workflowInstance.getPrimaryKey(),
			workflowInstance);

		workflowInstance.resetOriginalValues();
	}

	/**
	 * Caches the workflow instances in the entity cache if it is enabled.
	 *
	 * @param workflowInstances the workflow instances
	 */
	@Override
	public void cacheResult(List<WorkflowInstance> workflowInstances) {
		for (WorkflowInstance workflowInstance : workflowInstances) {
			if (EntityCacheUtil.getResult(
						WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
						WorkflowInstanceImpl.class,
						workflowInstance.getPrimaryKey()) == null) {
				cacheResult(workflowInstance);
			}
			else {
				workflowInstance.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all workflow instances.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WorkflowInstanceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WorkflowInstanceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the workflow instance.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkflowInstance workflowInstance) {
		EntityCacheUtil.removeResult(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowInstanceImpl.class, workflowInstance.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WorkflowInstance> workflowInstances) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkflowInstance workflowInstance : workflowInstances) {
			EntityCacheUtil.removeResult(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
				WorkflowInstanceImpl.class, workflowInstance.getPrimaryKey());
		}
	}

	/**
	 * Creates a new workflow instance with the primary key. Does not add the workflow instance to the database.
	 *
	 * @param workflowInstanceId the primary key for the new workflow instance
	 * @return the new workflow instance
	 */
	@Override
	public WorkflowInstance create(long workflowInstanceId) {
		WorkflowInstance workflowInstance = new WorkflowInstanceImpl();

		workflowInstance.setNew(true);
		workflowInstance.setPrimaryKey(workflowInstanceId);

		return workflowInstance;
	}

	/**
	 * Removes the workflow instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowInstanceId the primary key of the workflow instance
	 * @return the workflow instance that was removed
	 * @throws org.kisti.edison.NoSuchWorkflowInstanceException if a workflow instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance remove(long workflowInstanceId)
		throws NoSuchWorkflowInstanceException, SystemException {
		return remove((Serializable)workflowInstanceId);
	}

	/**
	 * Removes the workflow instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the workflow instance
	 * @return the workflow instance that was removed
	 * @throws org.kisti.edison.NoSuchWorkflowInstanceException if a workflow instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance remove(Serializable primaryKey)
		throws NoSuchWorkflowInstanceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WorkflowInstance workflowInstance = (WorkflowInstance)session.get(WorkflowInstanceImpl.class,
					primaryKey);

			if (workflowInstance == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkflowInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workflowInstance);
		}
		catch (NoSuchWorkflowInstanceException nsee) {
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
	protected WorkflowInstance removeImpl(WorkflowInstance workflowInstance)
		throws SystemException {
		workflowInstance = toUnwrappedModel(workflowInstance);

		workflowInstanceToWorkflowTableMapper.deleteLeftPrimaryKeyTableMappings(workflowInstance.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workflowInstance)) {
				workflowInstance = (WorkflowInstance)session.get(WorkflowInstanceImpl.class,
						workflowInstance.getPrimaryKeyObj());
			}

			if (workflowInstance != null) {
				session.delete(workflowInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workflowInstance != null) {
			clearCache(workflowInstance);
		}

		return workflowInstance;
	}

	@Override
	public WorkflowInstance updateImpl(
		org.kisti.edison.model.WorkflowInstance workflowInstance)
		throws SystemException {
		workflowInstance = toUnwrappedModel(workflowInstance);

		boolean isNew = workflowInstance.isNew();

		WorkflowInstanceModelImpl workflowInstanceModelImpl = (WorkflowInstanceModelImpl)workflowInstance;

		Session session = null;

		try {
			session = openSession();

			if (workflowInstance.isNew()) {
				session.save(workflowInstance);

				workflowInstance.setNew(false);
			}
			else {
				session.merge(workflowInstance);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WorkflowInstanceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((workflowInstanceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workflowInstanceModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { workflowInstanceModelImpl.getUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowInstanceImpl.class, workflowInstance.getPrimaryKey(),
			workflowInstance);

		return workflowInstance;
	}

	protected WorkflowInstance toUnwrappedModel(
		WorkflowInstance workflowInstance) {
		if (workflowInstance instanceof WorkflowInstanceImpl) {
			return workflowInstance;
		}

		WorkflowInstanceImpl workflowInstanceImpl = new WorkflowInstanceImpl();

		workflowInstanceImpl.setNew(workflowInstance.isNew());
		workflowInstanceImpl.setPrimaryKey(workflowInstance.getPrimaryKey());

		workflowInstanceImpl.setWorkflowInstanceId(workflowInstance.getWorkflowInstanceId());
		workflowInstanceImpl.setCompanyId(workflowInstance.getCompanyId());
		workflowInstanceImpl.setUserId(workflowInstance.getUserId());
		workflowInstanceImpl.setCreateDate(workflowInstance.getCreateDate());
		workflowInstanceImpl.setModifiedDate(workflowInstance.getModifiedDate());
		workflowInstanceImpl.setTitle(workflowInstance.getTitle());
		workflowInstanceImpl.setStatus(workflowInstance.getStatus());
		workflowInstanceImpl.setStartTime(workflowInstance.getStartTime());
		workflowInstanceImpl.setEndTime(workflowInstance.getEndTime());
		workflowInstanceImpl.setWorkflowId(workflowInstance.getWorkflowId());
		workflowInstanceImpl.setWorkflowUUID(workflowInstance.getWorkflowUUID());
		workflowInstanceImpl.setScreenLogic(workflowInstance.getScreenLogic());

		return workflowInstanceImpl;
	}

	/**
	 * Returns the workflow instance with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the workflow instance
	 * @return the workflow instance
	 * @throws org.kisti.edison.NoSuchWorkflowInstanceException if a workflow instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkflowInstanceException, SystemException {
		WorkflowInstance workflowInstance = fetchByPrimaryKey(primaryKey);

		if (workflowInstance == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkflowInstanceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workflowInstance;
	}

	/**
	 * Returns the workflow instance with the primary key or throws a {@link org.kisti.edison.NoSuchWorkflowInstanceException} if it could not be found.
	 *
	 * @param workflowInstanceId the primary key of the workflow instance
	 * @return the workflow instance
	 * @throws org.kisti.edison.NoSuchWorkflowInstanceException if a workflow instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance findByPrimaryKey(long workflowInstanceId)
		throws NoSuchWorkflowInstanceException, SystemException {
		return findByPrimaryKey((Serializable)workflowInstanceId);
	}

	/**
	 * Returns the workflow instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the workflow instance
	 * @return the workflow instance, or <code>null</code> if a workflow instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WorkflowInstance workflowInstance = (WorkflowInstance)EntityCacheUtil.getResult(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
				WorkflowInstanceImpl.class, primaryKey);

		if (workflowInstance == _nullWorkflowInstance) {
			return null;
		}

		if (workflowInstance == null) {
			Session session = null;

			try {
				session = openSession();

				workflowInstance = (WorkflowInstance)session.get(WorkflowInstanceImpl.class,
						primaryKey);

				if (workflowInstance != null) {
					cacheResult(workflowInstance);
				}
				else {
					EntityCacheUtil.putResult(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
						WorkflowInstanceImpl.class, primaryKey,
						_nullWorkflowInstance);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WorkflowInstanceModelImpl.ENTITY_CACHE_ENABLED,
					WorkflowInstanceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workflowInstance;
	}

	/**
	 * Returns the workflow instance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowInstanceId the primary key of the workflow instance
	 * @return the workflow instance, or <code>null</code> if a workflow instance with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkflowInstance fetchByPrimaryKey(long workflowInstanceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)workflowInstanceId);
	}

	/**
	 * Returns all the workflow instances.
	 *
	 * @return the workflow instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowInstance> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workflow instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workflow instances
	 * @param end the upper bound of the range of workflow instances (not inclusive)
	 * @return the range of workflow instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowInstance> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflow instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workflow instances
	 * @param end the upper bound of the range of workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of workflow instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkflowInstance> findAll(int start, int end,
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

		List<WorkflowInstance> list = (List<WorkflowInstance>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WORKFLOWINSTANCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKFLOWINSTANCE;

				if (pagination) {
					sql = sql.concat(WorkflowInstanceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkflowInstance>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkflowInstance>(list);
				}
				else {
					list = (List<WorkflowInstance>)QueryUtil.list(q,
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
	 * Removes all the workflow instances from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WorkflowInstance workflowInstance : findAll()) {
			remove(workflowInstance);
		}
	}

	/**
	 * Returns the number of workflow instances.
	 *
	 * @return the number of workflow instances
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

				Query q = session.createQuery(_SQL_COUNT_WORKFLOWINSTANCE);

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
	 * Returns all the workflows associated with the workflow instance.
	 *
	 * @param pk the primary key of the workflow instance
	 * @return the workflows associated with the workflow instance
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.model.Workflow> getWorkflows(long pk)
		throws SystemException {
		return getWorkflows(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the workflows associated with the workflow instance.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the workflow instance
	 * @param start the lower bound of the range of workflow instances
	 * @param end the upper bound of the range of workflow instances (not inclusive)
	 * @return the range of workflows associated with the workflow instance
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.model.Workflow> getWorkflows(long pk,
		int start, int end) throws SystemException {
		return getWorkflows(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflows associated with the workflow instance.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the workflow instance
	 * @param start the lower bound of the range of workflow instances
	 * @param end the upper bound of the range of workflow instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of workflows associated with the workflow instance
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.model.Workflow> getWorkflows(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return workflowInstanceToWorkflowTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of workflows associated with the workflow instance.
	 *
	 * @param pk the primary key of the workflow instance
	 * @return the number of workflows associated with the workflow instance
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getWorkflowsSize(long pk) throws SystemException {
		long[] pks = workflowInstanceToWorkflowTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the workflow is associated with the workflow instance.
	 *
	 * @param pk the primary key of the workflow instance
	 * @param workflowPK the primary key of the workflow
	 * @return <code>true</code> if the workflow is associated with the workflow instance; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsWorkflow(long pk, long workflowPK)
		throws SystemException {
		return workflowInstanceToWorkflowTableMapper.containsTableMapping(pk,
			workflowPK);
	}

	/**
	 * Returns <code>true</code> if the workflow instance has any workflows associated with it.
	 *
	 * @param pk the primary key of the workflow instance to check for associations with workflows
	 * @return <code>true</code> if the workflow instance has any workflows associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsWorkflows(long pk) throws SystemException {
		if (getWorkflowsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the workflow instance and the workflow. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow instance
	 * @param workflowPK the primary key of the workflow
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addWorkflow(long pk, long workflowPK) throws SystemException {
		workflowInstanceToWorkflowTableMapper.addTableMapping(pk, workflowPK);
	}

	/**
	 * Adds an association between the workflow instance and the workflow. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow instance
	 * @param workflow the workflow
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addWorkflow(long pk, org.kisti.edison.model.Workflow workflow)
		throws SystemException {
		workflowInstanceToWorkflowTableMapper.addTableMapping(pk,
			workflow.getPrimaryKey());
	}

	/**
	 * Adds an association between the workflow instance and the workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow instance
	 * @param workflowPKs the primary keys of the workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addWorkflows(long pk, long[] workflowPKs)
		throws SystemException {
		for (long workflowPK : workflowPKs) {
			workflowInstanceToWorkflowTableMapper.addTableMapping(pk, workflowPK);
		}
	}

	/**
	 * Adds an association between the workflow instance and the workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow instance
	 * @param workflows the workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addWorkflows(long pk,
		List<org.kisti.edison.model.Workflow> workflows)
		throws SystemException {
		for (org.kisti.edison.model.Workflow workflow : workflows) {
			workflowInstanceToWorkflowTableMapper.addTableMapping(pk,
				workflow.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the workflow instance and its workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow instance to clear the associated workflows from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearWorkflows(long pk) throws SystemException {
		workflowInstanceToWorkflowTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the workflow instance and the workflow. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow instance
	 * @param workflowPK the primary key of the workflow
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeWorkflow(long pk, long workflowPK)
		throws SystemException {
		workflowInstanceToWorkflowTableMapper.deleteTableMapping(pk, workflowPK);
	}

	/**
	 * Removes the association between the workflow instance and the workflow. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow instance
	 * @param workflow the workflow
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeWorkflow(long pk, org.kisti.edison.model.Workflow workflow)
		throws SystemException {
		workflowInstanceToWorkflowTableMapper.deleteTableMapping(pk,
			workflow.getPrimaryKey());
	}

	/**
	 * Removes the association between the workflow instance and the workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow instance
	 * @param workflowPKs the primary keys of the workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeWorkflows(long pk, long[] workflowPKs)
		throws SystemException {
		for (long workflowPK : workflowPKs) {
			workflowInstanceToWorkflowTableMapper.deleteTableMapping(pk,
				workflowPK);
		}
	}

	/**
	 * Removes the association between the workflow instance and the workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow instance
	 * @param workflows the workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeWorkflows(long pk,
		List<org.kisti.edison.model.Workflow> workflows)
		throws SystemException {
		for (org.kisti.edison.model.Workflow workflow : workflows) {
			workflowInstanceToWorkflowTableMapper.deleteTableMapping(pk,
				workflow.getPrimaryKey());
		}
	}

	/**
	 * Sets the workflows associated with the workflow instance, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow instance
	 * @param workflowPKs the primary keys of the workflows to be associated with the workflow instance
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setWorkflows(long pk, long[] workflowPKs)
		throws SystemException {
		Set<Long> newWorkflowPKsSet = SetUtil.fromArray(workflowPKs);
		Set<Long> oldWorkflowPKsSet = SetUtil.fromArray(workflowInstanceToWorkflowTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeWorkflowPKsSet = new HashSet<Long>(oldWorkflowPKsSet);

		removeWorkflowPKsSet.removeAll(newWorkflowPKsSet);

		for (long removeWorkflowPK : removeWorkflowPKsSet) {
			workflowInstanceToWorkflowTableMapper.deleteTableMapping(pk,
				removeWorkflowPK);
		}

		newWorkflowPKsSet.removeAll(oldWorkflowPKsSet);

		for (long newWorkflowPK : newWorkflowPKsSet) {
			workflowInstanceToWorkflowTableMapper.addTableMapping(pk,
				newWorkflowPK);
		}
	}

	/**
	 * Sets the workflows associated with the workflow instance, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow instance
	 * @param workflows the workflows to be associated with the workflow instance
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setWorkflows(long pk,
		List<org.kisti.edison.model.Workflow> workflows)
		throws SystemException {
		try {
			long[] workflowPKs = new long[workflows.size()];

			for (int i = 0; i < workflows.size(); i++) {
				org.kisti.edison.model.Workflow workflow = workflows.get(i);

				workflowPKs[i] = workflow.getPrimaryKey();
			}

			setWorkflows(pk, workflowPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(WorkflowInstanceModelImpl.MAPPING_TABLE_EDWF_WORKFLOW_WORKFLOWINSTANCE_NAME);
		}
	}

	/**
	 * Initializes the workflow instance persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.model.WorkflowInstance")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WorkflowInstance>> listenersList = new ArrayList<ModelListener<WorkflowInstance>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WorkflowInstance>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		workflowInstanceToWorkflowTableMapper = TableMapperFactory.getTableMapper("EDWF_Workflow_WorkflowInstance",
				"workflowInstanceId", "workflowId", this, workflowPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(WorkflowInstanceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("EDWF_Workflow_WorkflowInstance");
	}

	@BeanReference(type = WorkflowPersistence.class)
	protected WorkflowPersistence workflowPersistence;
	protected TableMapper<WorkflowInstance, org.kisti.edison.model.Workflow> workflowInstanceToWorkflowTableMapper;
	private static final String _SQL_SELECT_WORKFLOWINSTANCE = "SELECT workflowInstance FROM WorkflowInstance workflowInstance";
	private static final String _SQL_SELECT_WORKFLOWINSTANCE_WHERE = "SELECT workflowInstance FROM WorkflowInstance workflowInstance WHERE ";
	private static final String _SQL_COUNT_WORKFLOWINSTANCE = "SELECT COUNT(workflowInstance) FROM WorkflowInstance workflowInstance";
	private static final String _SQL_COUNT_WORKFLOWINSTANCE_WHERE = "SELECT COUNT(workflowInstance) FROM WorkflowInstance workflowInstance WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workflowInstance.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkflowInstance exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No WorkflowInstance exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WorkflowInstancePersistenceImpl.class);
	private static WorkflowInstance _nullWorkflowInstance = new WorkflowInstanceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WorkflowInstance> toCacheModel() {
				return _nullWorkflowInstanceCacheModel;
			}
		};

	private static CacheModel<WorkflowInstance> _nullWorkflowInstanceCacheModel = new CacheModel<WorkflowInstance>() {
			@Override
			public WorkflowInstance toEntityModel() {
				return _nullWorkflowInstance;
			}
		};
}