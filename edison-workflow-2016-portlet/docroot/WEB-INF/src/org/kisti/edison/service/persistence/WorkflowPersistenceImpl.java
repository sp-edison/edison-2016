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

import org.kisti.edison.NoSuchWorkflowException;
import org.kisti.edison.model.Workflow;
import org.kisti.edison.model.impl.WorkflowImpl;
import org.kisti.edison.model.impl.WorkflowModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see WorkflowPersistence
 * @see WorkflowUtil
 * @generated
 */
public class WorkflowPersistenceImpl extends BasePersistenceImpl<Workflow>
	implements WorkflowPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkflowUtil} to access the workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkflowImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowModelImpl.FINDER_CACHE_ENABLED, WorkflowImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowModelImpl.FINDER_CACHE_ENABLED, WorkflowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowModelImpl.FINDER_CACHE_ENABLED, WorkflowImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitle",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_TITLE = new FinderPath(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTitle",
			new String[] { String.class.getName() });

	/**
	 * Returns all the workflows where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the matching workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workflow> findByTitle(String title) throws SystemException {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workflows where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of workflows
	 * @param end the upper bound of the range of workflows (not inclusive)
	 * @return the range of matching workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workflow> findByTitle(String title, int start, int end)
		throws SystemException {
		return findByTitle(title, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflows where title LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of workflows
	 * @param end the upper bound of the range of workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workflow> findByTitle(String title, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
		finderArgs = new Object[] { title, start, end, orderByComparator };

		List<Workflow> list = (List<Workflow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Workflow workflow : list) {
				if (!StringUtil.wildcardMatches(workflow.getTitle(), title,
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

			query.append(_SQL_SELECT_WORKFLOW_WHERE);

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
				query.append(WorkflowModelImpl.ORDER_BY_JPQL);
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
					list = (List<Workflow>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Workflow>(list);
				}
				else {
					list = (List<Workflow>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first workflow in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow
	 * @throws org.kisti.edison.NoSuchWorkflowException if a matching workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow findByTitle_First(String title,
		OrderByComparator orderByComparator)
		throws NoSuchWorkflowException, SystemException {
		Workflow workflow = fetchByTitle_First(title, orderByComparator);

		if (workflow != null) {
			return workflow;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowException(msg.toString());
	}

	/**
	 * Returns the first workflow in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow, or <code>null</code> if a matching workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow fetchByTitle_First(String title,
		OrderByComparator orderByComparator) throws SystemException {
		List<Workflow> list = findByTitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last workflow in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow
	 * @throws org.kisti.edison.NoSuchWorkflowException if a matching workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow findByTitle_Last(String title,
		OrderByComparator orderByComparator)
		throws NoSuchWorkflowException, SystemException {
		Workflow workflow = fetchByTitle_Last(title, orderByComparator);

		if (workflow != null) {
			return workflow;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowException(msg.toString());
	}

	/**
	 * Returns the last workflow in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow, or <code>null</code> if a matching workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow fetchByTitle_Last(String title,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitle(title);

		if (count == 0) {
			return null;
		}

		List<Workflow> list = findByTitle(title, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the workflows before and after the current workflow in the ordered set where title LIKE &#63;.
	 *
	 * @param workflowId the primary key of the current workflow
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workflow
	 * @throws org.kisti.edison.NoSuchWorkflowException if a workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow[] findByTitle_PrevAndNext(long workflowId, String title,
		OrderByComparator orderByComparator)
		throws NoSuchWorkflowException, SystemException {
		Workflow workflow = findByPrimaryKey(workflowId);

		Session session = null;

		try {
			session = openSession();

			Workflow[] array = new WorkflowImpl[3];

			array[0] = getByTitle_PrevAndNext(session, workflow, title,
					orderByComparator, true);

			array[1] = workflow;

			array[2] = getByTitle_PrevAndNext(session, workflow, title,
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

	protected Workflow getByTitle_PrevAndNext(Session session,
		Workflow workflow, String title, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKFLOW_WHERE);

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
			query.append(WorkflowModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(workflow);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Workflow> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the workflows where title LIKE &#63; from the database.
	 *
	 * @param title the title
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitle(String title) throws SystemException {
		for (Workflow workflow : findByTitle(title, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(workflow);
		}
	}

	/**
	 * Returns the number of workflows where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the number of matching workflows
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

			query.append(_SQL_COUNT_WORKFLOW_WHERE);

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

	private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "workflow.title LIKE NULL";
	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "workflow.title LIKE ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(workflow.title IS NULL OR workflow.title LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISPUBLIC = new FinderPath(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowModelImpl.FINDER_CACHE_ENABLED, WorkflowImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsPublic",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC =
		new FinderPath(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowModelImpl.FINDER_CACHE_ENABLED, WorkflowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsPublic",
			new String[] { Boolean.class.getName() },
			WorkflowModelImpl.ISPUBLIC_COLUMN_BITMASK |
			WorkflowModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISPUBLIC = new FinderPath(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsPublic",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the workflows where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @return the matching workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workflow> findByIsPublic(boolean isPublic)
		throws SystemException {
		return findByIsPublic(isPublic, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the workflows where isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isPublic the is public
	 * @param start the lower bound of the range of workflows
	 * @param end the upper bound of the range of workflows (not inclusive)
	 * @return the range of matching workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workflow> findByIsPublic(boolean isPublic, int start, int end)
		throws SystemException {
		return findByIsPublic(isPublic, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflows where isPublic = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isPublic the is public
	 * @param start the lower bound of the range of workflows
	 * @param end the upper bound of the range of workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workflow> findByIsPublic(boolean isPublic, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC;
			finderArgs = new Object[] { isPublic };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISPUBLIC;
			finderArgs = new Object[] { isPublic, start, end, orderByComparator };
		}

		List<Workflow> list = (List<Workflow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Workflow workflow : list) {
				if ((isPublic != workflow.getIsPublic())) {
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

			query.append(_SQL_SELECT_WORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_ISPUBLIC_ISPUBLIC_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(WorkflowModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPublic);

				if (!pagination) {
					list = (List<Workflow>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Workflow>(list);
				}
				else {
					list = (List<Workflow>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first workflow in the ordered set where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow
	 * @throws org.kisti.edison.NoSuchWorkflowException if a matching workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow findByIsPublic_First(boolean isPublic,
		OrderByComparator orderByComparator)
		throws NoSuchWorkflowException, SystemException {
		Workflow workflow = fetchByIsPublic_First(isPublic, orderByComparator);

		if (workflow != null) {
			return workflow;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isPublic=");
		msg.append(isPublic);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowException(msg.toString());
	}

	/**
	 * Returns the first workflow in the ordered set where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching workflow, or <code>null</code> if a matching workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow fetchByIsPublic_First(boolean isPublic,
		OrderByComparator orderByComparator) throws SystemException {
		List<Workflow> list = findByIsPublic(isPublic, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last workflow in the ordered set where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow
	 * @throws org.kisti.edison.NoSuchWorkflowException if a matching workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow findByIsPublic_Last(boolean isPublic,
		OrderByComparator orderByComparator)
		throws NoSuchWorkflowException, SystemException {
		Workflow workflow = fetchByIsPublic_Last(isPublic, orderByComparator);

		if (workflow != null) {
			return workflow;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isPublic=");
		msg.append(isPublic);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchWorkflowException(msg.toString());
	}

	/**
	 * Returns the last workflow in the ordered set where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching workflow, or <code>null</code> if a matching workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow fetchByIsPublic_Last(boolean isPublic,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByIsPublic(isPublic);

		if (count == 0) {
			return null;
		}

		List<Workflow> list = findByIsPublic(isPublic, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the workflows before and after the current workflow in the ordered set where isPublic = &#63;.
	 *
	 * @param workflowId the primary key of the current workflow
	 * @param isPublic the is public
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next workflow
	 * @throws org.kisti.edison.NoSuchWorkflowException if a workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow[] findByIsPublic_PrevAndNext(long workflowId,
		boolean isPublic, OrderByComparator orderByComparator)
		throws NoSuchWorkflowException, SystemException {
		Workflow workflow = findByPrimaryKey(workflowId);

		Session session = null;

		try {
			session = openSession();

			Workflow[] array = new WorkflowImpl[3];

			array[0] = getByIsPublic_PrevAndNext(session, workflow, isPublic,
					orderByComparator, true);

			array[1] = workflow;

			array[2] = getByIsPublic_PrevAndNext(session, workflow, isPublic,
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

	protected Workflow getByIsPublic_PrevAndNext(Session session,
		Workflow workflow, boolean isPublic,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_WORKFLOW_WHERE);

		query.append(_FINDER_COLUMN_ISPUBLIC_ISPUBLIC_2);

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
			query.append(WorkflowModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isPublic);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(workflow);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Workflow> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the workflows where isPublic = &#63; from the database.
	 *
	 * @param isPublic the is public
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByIsPublic(boolean isPublic) throws SystemException {
		for (Workflow workflow : findByIsPublic(isPublic, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(workflow);
		}
	}

	/**
	 * Returns the number of workflows where isPublic = &#63;.
	 *
	 * @param isPublic the is public
	 * @return the number of matching workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIsPublic(boolean isPublic) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISPUBLIC;

		Object[] finderArgs = new Object[] { isPublic };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_WORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_ISPUBLIC_ISPUBLIC_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isPublic);

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

	private static final String _FINDER_COLUMN_ISPUBLIC_ISPUBLIC_2 = "workflow.isPublic = ?";

	public WorkflowPersistenceImpl() {
		setModelClass(Workflow.class);
	}

	/**
	 * Caches the workflow in the entity cache if it is enabled.
	 *
	 * @param workflow the workflow
	 */
	@Override
	public void cacheResult(Workflow workflow) {
		EntityCacheUtil.putResult(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowImpl.class, workflow.getPrimaryKey(), workflow);

		workflow.resetOriginalValues();
	}

	/**
	 * Caches the workflows in the entity cache if it is enabled.
	 *
	 * @param workflows the workflows
	 */
	@Override
	public void cacheResult(List<Workflow> workflows) {
		for (Workflow workflow : workflows) {
			if (EntityCacheUtil.getResult(
						WorkflowModelImpl.ENTITY_CACHE_ENABLED,
						WorkflowImpl.class, workflow.getPrimaryKey()) == null) {
				cacheResult(workflow);
			}
			else {
				workflow.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all workflows.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WorkflowImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WorkflowImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the workflow.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Workflow workflow) {
		EntityCacheUtil.removeResult(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowImpl.class, workflow.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Workflow> workflows) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Workflow workflow : workflows) {
			EntityCacheUtil.removeResult(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
				WorkflowImpl.class, workflow.getPrimaryKey());
		}
	}

	/**
	 * Creates a new workflow with the primary key. Does not add the workflow to the database.
	 *
	 * @param workflowId the primary key for the new workflow
	 * @return the new workflow
	 */
	@Override
	public Workflow create(long workflowId) {
		Workflow workflow = new WorkflowImpl();

		workflow.setNew(true);
		workflow.setPrimaryKey(workflowId);

		return workflow;
	}

	/**
	 * Removes the workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workflowId the primary key of the workflow
	 * @return the workflow that was removed
	 * @throws org.kisti.edison.NoSuchWorkflowException if a workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow remove(long workflowId)
		throws NoSuchWorkflowException, SystemException {
		return remove((Serializable)workflowId);
	}

	/**
	 * Removes the workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the workflow
	 * @return the workflow that was removed
	 * @throws org.kisti.edison.NoSuchWorkflowException if a workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow remove(Serializable primaryKey)
		throws NoSuchWorkflowException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Workflow workflow = (Workflow)session.get(WorkflowImpl.class,
					primaryKey);

			if (workflow == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkflowException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workflow);
		}
		catch (NoSuchWorkflowException nsee) {
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
	protected Workflow removeImpl(Workflow workflow) throws SystemException {
		workflow = toUnwrappedModel(workflow);

		workflowToWorkflowInstanceTableMapper.deleteLeftPrimaryKeyTableMappings(workflow.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workflow)) {
				workflow = (Workflow)session.get(WorkflowImpl.class,
						workflow.getPrimaryKeyObj());
			}

			if (workflow != null) {
				session.delete(workflow);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workflow != null) {
			clearCache(workflow);
		}

		return workflow;
	}

	@Override
	public Workflow updateImpl(org.kisti.edison.model.Workflow workflow)
		throws SystemException {
		workflow = toUnwrappedModel(workflow);

		boolean isNew = workflow.isNew();

		WorkflowModelImpl workflowModelImpl = (WorkflowModelImpl)workflow;

		Session session = null;

		try {
			session = openSession();

			if (workflow.isNew()) {
				session.save(workflow);

				workflow.setNew(false);
			}
			else {
				session.merge(workflow);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !WorkflowModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((workflowModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						workflowModelImpl.getOriginalIsPublic()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISPUBLIC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC,
					args);

				args = new Object[] { workflowModelImpl.getIsPublic() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISPUBLIC, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISPUBLIC,
					args);
			}
		}

		EntityCacheUtil.putResult(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
			WorkflowImpl.class, workflow.getPrimaryKey(), workflow);

		return workflow;
	}

	protected Workflow toUnwrappedModel(Workflow workflow) {
		if (workflow instanceof WorkflowImpl) {
			return workflow;
		}

		WorkflowImpl workflowImpl = new WorkflowImpl();

		workflowImpl.setNew(workflow.isNew());
		workflowImpl.setPrimaryKey(workflow.getPrimaryKey());

		workflowImpl.setWorkflowId(workflow.getWorkflowId());
		workflowImpl.setCompanyId(workflow.getCompanyId());
		workflowImpl.setUserId(workflow.getUserId());
		workflowImpl.setCreateDate(workflow.getCreateDate());
		workflowImpl.setModifiedDate(workflow.getModifiedDate());
		workflowImpl.setTitle(workflow.getTitle());
		workflowImpl.setDescription(workflow.getDescription());
		workflowImpl.setIsPublic(workflow.isIsPublic());
		workflowImpl.setParentWorkflowId(workflow.getParentWorkflowId());
		workflowImpl.setScreenLogic(workflow.getScreenLogic());

		return workflowImpl;
	}

	/**
	 * Returns the workflow with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the workflow
	 * @return the workflow
	 * @throws org.kisti.edison.NoSuchWorkflowException if a workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkflowException, SystemException {
		Workflow workflow = fetchByPrimaryKey(primaryKey);

		if (workflow == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkflowException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workflow;
	}

	/**
	 * Returns the workflow with the primary key or throws a {@link org.kisti.edison.NoSuchWorkflowException} if it could not be found.
	 *
	 * @param workflowId the primary key of the workflow
	 * @return the workflow
	 * @throws org.kisti.edison.NoSuchWorkflowException if a workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow findByPrimaryKey(long workflowId)
		throws NoSuchWorkflowException, SystemException {
		return findByPrimaryKey((Serializable)workflowId);
	}

	/**
	 * Returns the workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the workflow
	 * @return the workflow, or <code>null</code> if a workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Workflow workflow = (Workflow)EntityCacheUtil.getResult(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
				WorkflowImpl.class, primaryKey);

		if (workflow == _nullWorkflow) {
			return null;
		}

		if (workflow == null) {
			Session session = null;

			try {
				session = openSession();

				workflow = (Workflow)session.get(WorkflowImpl.class, primaryKey);

				if (workflow != null) {
					cacheResult(workflow);
				}
				else {
					EntityCacheUtil.putResult(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
						WorkflowImpl.class, primaryKey, _nullWorkflow);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WorkflowModelImpl.ENTITY_CACHE_ENABLED,
					WorkflowImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workflow;
	}

	/**
	 * Returns the workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workflowId the primary key of the workflow
	 * @return the workflow, or <code>null</code> if a workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Workflow fetchByPrimaryKey(long workflowId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)workflowId);
	}

	/**
	 * Returns all the workflows.
	 *
	 * @return the workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workflow> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workflows
	 * @param end the upper bound of the range of workflows (not inclusive)
	 * @return the range of workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workflow> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of workflows
	 * @param end the upper bound of the range of workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Workflow> findAll(int start, int end,
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

		List<Workflow> list = (List<Workflow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WORKFLOW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKFLOW;

				if (pagination) {
					sql = sql.concat(WorkflowModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Workflow>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Workflow>(list);
				}
				else {
					list = (List<Workflow>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the workflows from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Workflow workflow : findAll()) {
			remove(workflow);
		}
	}

	/**
	 * Returns the number of workflows.
	 *
	 * @return the number of workflows
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

				Query q = session.createQuery(_SQL_COUNT_WORKFLOW);

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
	 * Returns all the workflow instances associated with the workflow.
	 *
	 * @param pk the primary key of the workflow
	 * @return the workflow instances associated with the workflow
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.model.WorkflowInstance> getWorkflowInstances(
		long pk) throws SystemException {
		return getWorkflowInstances(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the workflow instances associated with the workflow.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the workflow
	 * @param start the lower bound of the range of workflows
	 * @param end the upper bound of the range of workflows (not inclusive)
	 * @return the range of workflow instances associated with the workflow
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.model.WorkflowInstance> getWorkflowInstances(
		long pk, int start, int end) throws SystemException {
		return getWorkflowInstances(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the workflow instances associated with the workflow.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the workflow
	 * @param start the lower bound of the range of workflows
	 * @param end the upper bound of the range of workflows (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of workflow instances associated with the workflow
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.model.WorkflowInstance> getWorkflowInstances(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return workflowToWorkflowInstanceTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of workflow instances associated with the workflow.
	 *
	 * @param pk the primary key of the workflow
	 * @return the number of workflow instances associated with the workflow
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getWorkflowInstancesSize(long pk) throws SystemException {
		long[] pks = workflowToWorkflowInstanceTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the workflow instance is associated with the workflow.
	 *
	 * @param pk the primary key of the workflow
	 * @param workflowInstancePK the primary key of the workflow instance
	 * @return <code>true</code> if the workflow instance is associated with the workflow; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsWorkflowInstance(long pk, long workflowInstancePK)
		throws SystemException {
		return workflowToWorkflowInstanceTableMapper.containsTableMapping(pk,
			workflowInstancePK);
	}

	/**
	 * Returns <code>true</code> if the workflow has any workflow instances associated with it.
	 *
	 * @param pk the primary key of the workflow to check for associations with workflow instances
	 * @return <code>true</code> if the workflow has any workflow instances associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsWorkflowInstances(long pk) throws SystemException {
		if (getWorkflowInstancesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the workflow and the workflow instance. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow
	 * @param workflowInstancePK the primary key of the workflow instance
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addWorkflowInstance(long pk, long workflowInstancePK)
		throws SystemException {
		workflowToWorkflowInstanceTableMapper.addTableMapping(pk,
			workflowInstancePK);
	}

	/**
	 * Adds an association between the workflow and the workflow instance. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow
	 * @param workflowInstance the workflow instance
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addWorkflowInstance(long pk,
		org.kisti.edison.model.WorkflowInstance workflowInstance)
		throws SystemException {
		workflowToWorkflowInstanceTableMapper.addTableMapping(pk,
			workflowInstance.getPrimaryKey());
	}

	/**
	 * Adds an association between the workflow and the workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow
	 * @param workflowInstancePKs the primary keys of the workflow instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addWorkflowInstances(long pk, long[] workflowInstancePKs)
		throws SystemException {
		for (long workflowInstancePK : workflowInstancePKs) {
			workflowToWorkflowInstanceTableMapper.addTableMapping(pk,
				workflowInstancePK);
		}
	}

	/**
	 * Adds an association between the workflow and the workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow
	 * @param workflowInstances the workflow instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addWorkflowInstances(long pk,
		List<org.kisti.edison.model.WorkflowInstance> workflowInstances)
		throws SystemException {
		for (org.kisti.edison.model.WorkflowInstance workflowInstance : workflowInstances) {
			workflowToWorkflowInstanceTableMapper.addTableMapping(pk,
				workflowInstance.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the workflow and its workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow to clear the associated workflow instances from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearWorkflowInstances(long pk) throws SystemException {
		workflowToWorkflowInstanceTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the workflow and the workflow instance. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow
	 * @param workflowInstancePK the primary key of the workflow instance
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeWorkflowInstance(long pk, long workflowInstancePK)
		throws SystemException {
		workflowToWorkflowInstanceTableMapper.deleteTableMapping(pk,
			workflowInstancePK);
	}

	/**
	 * Removes the association between the workflow and the workflow instance. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow
	 * @param workflowInstance the workflow instance
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeWorkflowInstance(long pk,
		org.kisti.edison.model.WorkflowInstance workflowInstance)
		throws SystemException {
		workflowToWorkflowInstanceTableMapper.deleteTableMapping(pk,
			workflowInstance.getPrimaryKey());
	}

	/**
	 * Removes the association between the workflow and the workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow
	 * @param workflowInstancePKs the primary keys of the workflow instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeWorkflowInstances(long pk, long[] workflowInstancePKs)
		throws SystemException {
		for (long workflowInstancePK : workflowInstancePKs) {
			workflowToWorkflowInstanceTableMapper.deleteTableMapping(pk,
				workflowInstancePK);
		}
	}

	/**
	 * Removes the association between the workflow and the workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow
	 * @param workflowInstances the workflow instances
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeWorkflowInstances(long pk,
		List<org.kisti.edison.model.WorkflowInstance> workflowInstances)
		throws SystemException {
		for (org.kisti.edison.model.WorkflowInstance workflowInstance : workflowInstances) {
			workflowToWorkflowInstanceTableMapper.deleteTableMapping(pk,
				workflowInstance.getPrimaryKey());
		}
	}

	/**
	 * Sets the workflow instances associated with the workflow, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow
	 * @param workflowInstancePKs the primary keys of the workflow instances to be associated with the workflow
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setWorkflowInstances(long pk, long[] workflowInstancePKs)
		throws SystemException {
		Set<Long> newWorkflowInstancePKsSet = SetUtil.fromArray(workflowInstancePKs);
		Set<Long> oldWorkflowInstancePKsSet = SetUtil.fromArray(workflowToWorkflowInstanceTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeWorkflowInstancePKsSet = new HashSet<Long>(oldWorkflowInstancePKsSet);

		removeWorkflowInstancePKsSet.removeAll(newWorkflowInstancePKsSet);

		for (long removeWorkflowInstancePK : removeWorkflowInstancePKsSet) {
			workflowToWorkflowInstanceTableMapper.deleteTableMapping(pk,
				removeWorkflowInstancePK);
		}

		newWorkflowInstancePKsSet.removeAll(oldWorkflowInstancePKsSet);

		for (long newWorkflowInstancePK : newWorkflowInstancePKsSet) {
			workflowToWorkflowInstanceTableMapper.addTableMapping(pk,
				newWorkflowInstancePK);
		}
	}

	/**
	 * Sets the workflow instances associated with the workflow, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the workflow
	 * @param workflowInstances the workflow instances to be associated with the workflow
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setWorkflowInstances(long pk,
		List<org.kisti.edison.model.WorkflowInstance> workflowInstances)
		throws SystemException {
		try {
			long[] workflowInstancePKs = new long[workflowInstances.size()];

			for (int i = 0; i < workflowInstances.size(); i++) {
				org.kisti.edison.model.WorkflowInstance workflowInstance = workflowInstances.get(i);

				workflowInstancePKs[i] = workflowInstance.getPrimaryKey();
			}

			setWorkflowInstances(pk, workflowInstancePKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(WorkflowModelImpl.MAPPING_TABLE_EDWF_WORKFLOW_WORKFLOWINSTANCE_NAME);
		}
	}

	/**
	 * Initializes the workflow persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.model.Workflow")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Workflow>> listenersList = new ArrayList<ModelListener<Workflow>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Workflow>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		workflowToWorkflowInstanceTableMapper = TableMapperFactory.getTableMapper("EDWF_Workflow_WorkflowInstance",
				"workflowId", "workflowInstanceId", this,
				workflowInstancePersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(WorkflowImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("EDWF_Workflow_WorkflowInstance");
	}

	@BeanReference(type = WorkflowInstancePersistence.class)
	protected WorkflowInstancePersistence workflowInstancePersistence;
	protected TableMapper<Workflow, org.kisti.edison.model.WorkflowInstance> workflowToWorkflowInstanceTableMapper;
	private static final String _SQL_SELECT_WORKFLOW = "SELECT workflow FROM Workflow workflow";
	private static final String _SQL_SELECT_WORKFLOW_WHERE = "SELECT workflow FROM Workflow workflow WHERE ";
	private static final String _SQL_COUNT_WORKFLOW = "SELECT COUNT(workflow) FROM Workflow workflow";
	private static final String _SQL_COUNT_WORKFLOW_WHERE = "SELECT COUNT(workflow) FROM Workflow workflow WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workflow.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Workflow exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Workflow exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WorkflowPersistenceImpl.class);
	private static Workflow _nullWorkflow = new WorkflowImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Workflow> toCacheModel() {
				return _nullWorkflowCacheModel;
			}
		};

	private static CacheModel<Workflow> _nullWorkflowCacheModel = new CacheModel<Workflow>() {
			@Override
			public Workflow toEntityModel() {
				return _nullWorkflow;
			}
		};
}