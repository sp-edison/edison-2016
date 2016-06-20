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

package org.kisti.edison.multiboard.service.persistence;

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

import org.kisti.edison.multiboard.NoSuchBoardDivException;
import org.kisti.edison.multiboard.model.BoardDiv;
import org.kisti.edison.multiboard.model.impl.BoardDivImpl;
import org.kisti.edison.multiboard.model.impl.BoardDivModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the board div service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mhkang
 * @see BoardDivPersistence
 * @see BoardDivUtil
 * @generated
 */
public class BoardDivPersistenceImpl extends BasePersistenceImpl<BoardDiv>
	implements BoardDivPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BoardDivUtil} to access the board div persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BoardDivImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
			BoardDivModelImpl.FINDER_CACHE_ENABLED, BoardDivImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
			BoardDivModelImpl.FINDER_CACHE_ENABLED, BoardDivImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
			BoardDivModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_POPUPYN = new FinderPath(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
			BoardDivModelImpl.FINDER_CACHE_ENABLED, BoardDivImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPopupYn",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POPUPYN =
		new FinderPath(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
			BoardDivModelImpl.FINDER_CACHE_ENABLED, BoardDivImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPopupYn",
			new String[] { Boolean.class.getName() },
			BoardDivModelImpl.POPUPYN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_POPUPYN = new FinderPath(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
			BoardDivModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPopupYn",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the board divs where popupYn = &#63;.
	 *
	 * @param popupYn the popup yn
	 * @return the matching board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BoardDiv> findByPopupYn(boolean popupYn)
		throws SystemException {
		return findByPopupYn(popupYn, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the board divs where popupYn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardDivModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param popupYn the popup yn
	 * @param start the lower bound of the range of board divs
	 * @param end the upper bound of the range of board divs (not inclusive)
	 * @return the range of matching board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BoardDiv> findByPopupYn(boolean popupYn, int start, int end)
		throws SystemException {
		return findByPopupYn(popupYn, start, end, null);
	}

	/**
	 * Returns an ordered range of all the board divs where popupYn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardDivModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param popupYn the popup yn
	 * @param start the lower bound of the range of board divs
	 * @param end the upper bound of the range of board divs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BoardDiv> findByPopupYn(boolean popupYn, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POPUPYN;
			finderArgs = new Object[] { popupYn };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_POPUPYN;
			finderArgs = new Object[] { popupYn, start, end, orderByComparator };
		}

		List<BoardDiv> list = (List<BoardDiv>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BoardDiv boardDiv : list) {
				if ((popupYn != boardDiv.getPopupYn())) {
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

			query.append(_SQL_SELECT_BOARDDIV_WHERE);

			query.append(_FINDER_COLUMN_POPUPYN_POPUPYN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BoardDivModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(popupYn);

				if (!pagination) {
					list = (List<BoardDiv>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BoardDiv>(list);
				}
				else {
					list = (List<BoardDiv>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first board div in the ordered set where popupYn = &#63;.
	 *
	 * @param popupYn the popup yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching board div
	 * @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a matching board div could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv findByPopupYn_First(boolean popupYn,
		OrderByComparator orderByComparator)
		throws NoSuchBoardDivException, SystemException {
		BoardDiv boardDiv = fetchByPopupYn_First(popupYn, orderByComparator);

		if (boardDiv != null) {
			return boardDiv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("popupYn=");
		msg.append(popupYn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBoardDivException(msg.toString());
	}

	/**
	 * Returns the first board div in the ordered set where popupYn = &#63;.
	 *
	 * @param popupYn the popup yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching board div, or <code>null</code> if a matching board div could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv fetchByPopupYn_First(boolean popupYn,
		OrderByComparator orderByComparator) throws SystemException {
		List<BoardDiv> list = findByPopupYn(popupYn, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last board div in the ordered set where popupYn = &#63;.
	 *
	 * @param popupYn the popup yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching board div
	 * @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a matching board div could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv findByPopupYn_Last(boolean popupYn,
		OrderByComparator orderByComparator)
		throws NoSuchBoardDivException, SystemException {
		BoardDiv boardDiv = fetchByPopupYn_Last(popupYn, orderByComparator);

		if (boardDiv != null) {
			return boardDiv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("popupYn=");
		msg.append(popupYn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBoardDivException(msg.toString());
	}

	/**
	 * Returns the last board div in the ordered set where popupYn = &#63;.
	 *
	 * @param popupYn the popup yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching board div, or <code>null</code> if a matching board div could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv fetchByPopupYn_Last(boolean popupYn,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPopupYn(popupYn);

		if (count == 0) {
			return null;
		}

		List<BoardDiv> list = findByPopupYn(popupYn, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the board divs before and after the current board div in the ordered set where popupYn = &#63;.
	 *
	 * @param divCd the primary key of the current board div
	 * @param popupYn the popup yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next board div
	 * @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a board div with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv[] findByPopupYn_PrevAndNext(long divCd, boolean popupYn,
		OrderByComparator orderByComparator)
		throws NoSuchBoardDivException, SystemException {
		BoardDiv boardDiv = findByPrimaryKey(divCd);

		Session session = null;

		try {
			session = openSession();

			BoardDiv[] array = new BoardDivImpl[3];

			array[0] = getByPopupYn_PrevAndNext(session, boardDiv, popupYn,
					orderByComparator, true);

			array[1] = boardDiv;

			array[2] = getByPopupYn_PrevAndNext(session, boardDiv, popupYn,
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

	protected BoardDiv getByPopupYn_PrevAndNext(Session session,
		BoardDiv boardDiv, boolean popupYn,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOARDDIV_WHERE);

		query.append(_FINDER_COLUMN_POPUPYN_POPUPYN_2);

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
			query.append(BoardDivModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(popupYn);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(boardDiv);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BoardDiv> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the board divs where popupYn = &#63; from the database.
	 *
	 * @param popupYn the popup yn
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPopupYn(boolean popupYn) throws SystemException {
		for (BoardDiv boardDiv : findByPopupYn(popupYn, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(boardDiv);
		}
	}

	/**
	 * Returns the number of board divs where popupYn = &#63;.
	 *
	 * @param popupYn the popup yn
	 * @return the number of matching board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPopupYn(boolean popupYn) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_POPUPYN;

		Object[] finderArgs = new Object[] { popupYn };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOARDDIV_WHERE);

			query.append(_FINDER_COLUMN_POPUPYN_POPUPYN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(popupYn);

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

	private static final String _FINDER_COLUMN_POPUPYN_POPUPYN_2 = "boardDiv.popupYn = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEUPLOADUSEYN =
		new FinderPath(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
			BoardDivModelImpl.FINDER_CACHE_ENABLED, BoardDivImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFileUpLoadUseYn",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUPLOADUSEYN =
		new FinderPath(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
			BoardDivModelImpl.FINDER_CACHE_ENABLED, BoardDivImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFileUpLoadUseYn",
			new String[] { Boolean.class.getName() },
			BoardDivModelImpl.FILEUPLOADUSEYN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FILEUPLOADUSEYN = new FinderPath(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
			BoardDivModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFileUpLoadUseYn", new String[] { Boolean.class.getName() });

	/**
	 * Returns all the board divs where fileUpLoadUseYn = &#63;.
	 *
	 * @param fileUpLoadUseYn the file up load use yn
	 * @return the matching board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BoardDiv> findByFileUpLoadUseYn(boolean fileUpLoadUseYn)
		throws SystemException {
		return findByFileUpLoadUseYn(fileUpLoadUseYn, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the board divs where fileUpLoadUseYn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardDivModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fileUpLoadUseYn the file up load use yn
	 * @param start the lower bound of the range of board divs
	 * @param end the upper bound of the range of board divs (not inclusive)
	 * @return the range of matching board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BoardDiv> findByFileUpLoadUseYn(boolean fileUpLoadUseYn,
		int start, int end) throws SystemException {
		return findByFileUpLoadUseYn(fileUpLoadUseYn, start, end, null);
	}

	/**
	 * Returns an ordered range of all the board divs where fileUpLoadUseYn = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardDivModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param fileUpLoadUseYn the file up load use yn
	 * @param start the lower bound of the range of board divs
	 * @param end the upper bound of the range of board divs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BoardDiv> findByFileUpLoadUseYn(boolean fileUpLoadUseYn,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUPLOADUSEYN;
			finderArgs = new Object[] { fileUpLoadUseYn };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FILEUPLOADUSEYN;
			finderArgs = new Object[] {
					fileUpLoadUseYn,
					
					start, end, orderByComparator
				};
		}

		List<BoardDiv> list = (List<BoardDiv>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BoardDiv boardDiv : list) {
				if ((fileUpLoadUseYn != boardDiv.getFileUpLoadUseYn())) {
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

			query.append(_SQL_SELECT_BOARDDIV_WHERE);

			query.append(_FINDER_COLUMN_FILEUPLOADUSEYN_FILEUPLOADUSEYN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BoardDivModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileUpLoadUseYn);

				if (!pagination) {
					list = (List<BoardDiv>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BoardDiv>(list);
				}
				else {
					list = (List<BoardDiv>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first board div in the ordered set where fileUpLoadUseYn = &#63;.
	 *
	 * @param fileUpLoadUseYn the file up load use yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching board div
	 * @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a matching board div could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv findByFileUpLoadUseYn_First(boolean fileUpLoadUseYn,
		OrderByComparator orderByComparator)
		throws NoSuchBoardDivException, SystemException {
		BoardDiv boardDiv = fetchByFileUpLoadUseYn_First(fileUpLoadUseYn,
				orderByComparator);

		if (boardDiv != null) {
			return boardDiv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileUpLoadUseYn=");
		msg.append(fileUpLoadUseYn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBoardDivException(msg.toString());
	}

	/**
	 * Returns the first board div in the ordered set where fileUpLoadUseYn = &#63;.
	 *
	 * @param fileUpLoadUseYn the file up load use yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching board div, or <code>null</code> if a matching board div could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv fetchByFileUpLoadUseYn_First(boolean fileUpLoadUseYn,
		OrderByComparator orderByComparator) throws SystemException {
		List<BoardDiv> list = findByFileUpLoadUseYn(fileUpLoadUseYn, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last board div in the ordered set where fileUpLoadUseYn = &#63;.
	 *
	 * @param fileUpLoadUseYn the file up load use yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching board div
	 * @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a matching board div could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv findByFileUpLoadUseYn_Last(boolean fileUpLoadUseYn,
		OrderByComparator orderByComparator)
		throws NoSuchBoardDivException, SystemException {
		BoardDiv boardDiv = fetchByFileUpLoadUseYn_Last(fileUpLoadUseYn,
				orderByComparator);

		if (boardDiv != null) {
			return boardDiv;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fileUpLoadUseYn=");
		msg.append(fileUpLoadUseYn);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBoardDivException(msg.toString());
	}

	/**
	 * Returns the last board div in the ordered set where fileUpLoadUseYn = &#63;.
	 *
	 * @param fileUpLoadUseYn the file up load use yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching board div, or <code>null</code> if a matching board div could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv fetchByFileUpLoadUseYn_Last(boolean fileUpLoadUseYn,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByFileUpLoadUseYn(fileUpLoadUseYn);

		if (count == 0) {
			return null;
		}

		List<BoardDiv> list = findByFileUpLoadUseYn(fileUpLoadUseYn, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the board divs before and after the current board div in the ordered set where fileUpLoadUseYn = &#63;.
	 *
	 * @param divCd the primary key of the current board div
	 * @param fileUpLoadUseYn the file up load use yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next board div
	 * @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a board div with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv[] findByFileUpLoadUseYn_PrevAndNext(long divCd,
		boolean fileUpLoadUseYn, OrderByComparator orderByComparator)
		throws NoSuchBoardDivException, SystemException {
		BoardDiv boardDiv = findByPrimaryKey(divCd);

		Session session = null;

		try {
			session = openSession();

			BoardDiv[] array = new BoardDivImpl[3];

			array[0] = getByFileUpLoadUseYn_PrevAndNext(session, boardDiv,
					fileUpLoadUseYn, orderByComparator, true);

			array[1] = boardDiv;

			array[2] = getByFileUpLoadUseYn_PrevAndNext(session, boardDiv,
					fileUpLoadUseYn, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BoardDiv getByFileUpLoadUseYn_PrevAndNext(Session session,
		BoardDiv boardDiv, boolean fileUpLoadUseYn,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BOARDDIV_WHERE);

		query.append(_FINDER_COLUMN_FILEUPLOADUSEYN_FILEUPLOADUSEYN_2);

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
			query.append(BoardDivModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fileUpLoadUseYn);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(boardDiv);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BoardDiv> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the board divs where fileUpLoadUseYn = &#63; from the database.
	 *
	 * @param fileUpLoadUseYn the file up load use yn
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByFileUpLoadUseYn(boolean fileUpLoadUseYn)
		throws SystemException {
		for (BoardDiv boardDiv : findByFileUpLoadUseYn(fileUpLoadUseYn,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(boardDiv);
		}
	}

	/**
	 * Returns the number of board divs where fileUpLoadUseYn = &#63;.
	 *
	 * @param fileUpLoadUseYn the file up load use yn
	 * @return the number of matching board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFileUpLoadUseYn(boolean fileUpLoadUseYn)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FILEUPLOADUSEYN;

		Object[] finderArgs = new Object[] { fileUpLoadUseYn };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BOARDDIV_WHERE);

			query.append(_FINDER_COLUMN_FILEUPLOADUSEYN_FILEUPLOADUSEYN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fileUpLoadUseYn);

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

	private static final String _FINDER_COLUMN_FILEUPLOADUSEYN_FILEUPLOADUSEYN_2 =
		"boardDiv.fileUpLoadUseYn = ?";

	public BoardDivPersistenceImpl() {
		setModelClass(BoardDiv.class);
	}

	/**
	 * Caches the board div in the entity cache if it is enabled.
	 *
	 * @param boardDiv the board div
	 */
	@Override
	public void cacheResult(BoardDiv boardDiv) {
		EntityCacheUtil.putResult(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
			BoardDivImpl.class, boardDiv.getPrimaryKey(), boardDiv);

		boardDiv.resetOriginalValues();
	}

	/**
	 * Caches the board divs in the entity cache if it is enabled.
	 *
	 * @param boardDivs the board divs
	 */
	@Override
	public void cacheResult(List<BoardDiv> boardDivs) {
		for (BoardDiv boardDiv : boardDivs) {
			if (EntityCacheUtil.getResult(
						BoardDivModelImpl.ENTITY_CACHE_ENABLED,
						BoardDivImpl.class, boardDiv.getPrimaryKey()) == null) {
				cacheResult(boardDiv);
			}
			else {
				boardDiv.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all board divs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BoardDivImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BoardDivImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the board div.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BoardDiv boardDiv) {
		EntityCacheUtil.removeResult(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
			BoardDivImpl.class, boardDiv.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BoardDiv> boardDivs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BoardDiv boardDiv : boardDivs) {
			EntityCacheUtil.removeResult(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
				BoardDivImpl.class, boardDiv.getPrimaryKey());
		}
	}

	/**
	 * Creates a new board div with the primary key. Does not add the board div to the database.
	 *
	 * @param divCd the primary key for the new board div
	 * @return the new board div
	 */
	@Override
	public BoardDiv create(long divCd) {
		BoardDiv boardDiv = new BoardDivImpl();

		boardDiv.setNew(true);
		boardDiv.setPrimaryKey(divCd);

		return boardDiv;
	}

	/**
	 * Removes the board div with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param divCd the primary key of the board div
	 * @return the board div that was removed
	 * @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a board div with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv remove(long divCd)
		throws NoSuchBoardDivException, SystemException {
		return remove((Serializable)divCd);
	}

	/**
	 * Removes the board div with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the board div
	 * @return the board div that was removed
	 * @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a board div with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv remove(Serializable primaryKey)
		throws NoSuchBoardDivException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BoardDiv boardDiv = (BoardDiv)session.get(BoardDivImpl.class,
					primaryKey);

			if (boardDiv == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBoardDivException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(boardDiv);
		}
		catch (NoSuchBoardDivException nsee) {
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
	protected BoardDiv removeImpl(BoardDiv boardDiv) throws SystemException {
		boardDiv = toUnwrappedModel(boardDiv);

		boardDivToBoardTableMapper.deleteLeftPrimaryKeyTableMappings(boardDiv.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(boardDiv)) {
				boardDiv = (BoardDiv)session.get(BoardDivImpl.class,
						boardDiv.getPrimaryKeyObj());
			}

			if (boardDiv != null) {
				session.delete(boardDiv);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (boardDiv != null) {
			clearCache(boardDiv);
		}

		return boardDiv;
	}

	@Override
	public BoardDiv updateImpl(
		org.kisti.edison.multiboard.model.BoardDiv boardDiv)
		throws SystemException {
		boardDiv = toUnwrappedModel(boardDiv);

		boolean isNew = boardDiv.isNew();

		BoardDivModelImpl boardDivModelImpl = (BoardDivModelImpl)boardDiv;

		Session session = null;

		try {
			session = openSession();

			if (boardDiv.isNew()) {
				session.save(boardDiv);

				boardDiv.setNew(false);
			}
			else {
				session.merge(boardDiv);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BoardDivModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((boardDivModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POPUPYN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						boardDivModelImpl.getOriginalPopupYn()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POPUPYN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POPUPYN,
					args);

				args = new Object[] { boardDivModelImpl.getPopupYn() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_POPUPYN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_POPUPYN,
					args);
			}

			if ((boardDivModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUPLOADUSEYN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						boardDivModelImpl.getOriginalFileUpLoadUseYn()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEUPLOADUSEYN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUPLOADUSEYN,
					args);

				args = new Object[] { boardDivModelImpl.getFileUpLoadUseYn() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FILEUPLOADUSEYN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FILEUPLOADUSEYN,
					args);
			}
		}

		EntityCacheUtil.putResult(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
			BoardDivImpl.class, boardDiv.getPrimaryKey(), boardDiv);

		return boardDiv;
	}

	protected BoardDiv toUnwrappedModel(BoardDiv boardDiv) {
		if (boardDiv instanceof BoardDivImpl) {
			return boardDiv;
		}

		BoardDivImpl boardDivImpl = new BoardDivImpl();

		boardDivImpl.setNew(boardDiv.isNew());
		boardDivImpl.setPrimaryKey(boardDiv.getPrimaryKey());

		boardDivImpl.setDivCd(boardDiv.getDivCd());
		boardDivImpl.setTitleNm(boardDiv.getTitleNm());
		boardDivImpl.setContentNm(boardDiv.getContentNm());
		boardDivImpl.setDivNm(boardDiv.getDivNm());
		boardDivImpl.setFileUpLoadUseYn(boardDiv.isFileUpLoadUseYn());
		boardDivImpl.setPopupYn(boardDiv.isPopupYn());
		boardDivImpl.setReplyYn(boardDiv.isReplyYn());

		return boardDivImpl;
	}

	/**
	 * Returns the board div with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the board div
	 * @return the board div
	 * @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a board div with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBoardDivException, SystemException {
		BoardDiv boardDiv = fetchByPrimaryKey(primaryKey);

		if (boardDiv == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBoardDivException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return boardDiv;
	}

	/**
	 * Returns the board div with the primary key or throws a {@link org.kisti.edison.multiboard.NoSuchBoardDivException} if it could not be found.
	 *
	 * @param divCd the primary key of the board div
	 * @return the board div
	 * @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a board div with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv findByPrimaryKey(long divCd)
		throws NoSuchBoardDivException, SystemException {
		return findByPrimaryKey((Serializable)divCd);
	}

	/**
	 * Returns the board div with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the board div
	 * @return the board div, or <code>null</code> if a board div with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BoardDiv boardDiv = (BoardDiv)EntityCacheUtil.getResult(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
				BoardDivImpl.class, primaryKey);

		if (boardDiv == _nullBoardDiv) {
			return null;
		}

		if (boardDiv == null) {
			Session session = null;

			try {
				session = openSession();

				boardDiv = (BoardDiv)session.get(BoardDivImpl.class, primaryKey);

				if (boardDiv != null) {
					cacheResult(boardDiv);
				}
				else {
					EntityCacheUtil.putResult(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
						BoardDivImpl.class, primaryKey, _nullBoardDiv);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BoardDivModelImpl.ENTITY_CACHE_ENABLED,
					BoardDivImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return boardDiv;
	}

	/**
	 * Returns the board div with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param divCd the primary key of the board div
	 * @return the board div, or <code>null</code> if a board div with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BoardDiv fetchByPrimaryKey(long divCd) throws SystemException {
		return fetchByPrimaryKey((Serializable)divCd);
	}

	/**
	 * Returns all the board divs.
	 *
	 * @return the board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BoardDiv> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the board divs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardDivModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of board divs
	 * @param end the upper bound of the range of board divs (not inclusive)
	 * @return the range of board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BoardDiv> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the board divs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardDivModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of board divs
	 * @param end the upper bound of the range of board divs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BoardDiv> findAll(int start, int end,
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

		List<BoardDiv> list = (List<BoardDiv>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BOARDDIV);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOARDDIV;

				if (pagination) {
					sql = sql.concat(BoardDivModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BoardDiv>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BoardDiv>(list);
				}
				else {
					list = (List<BoardDiv>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the board divs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BoardDiv boardDiv : findAll()) {
			remove(boardDiv);
		}
	}

	/**
	 * Returns the number of board divs.
	 *
	 * @return the number of board divs
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

				Query q = session.createQuery(_SQL_COUNT_BOARDDIV);

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
	 * Returns all the boards associated with the board div.
	 *
	 * @param pk the primary key of the board div
	 * @return the boards associated with the board div
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.multiboard.model.Board> getBoards(long pk)
		throws SystemException {
		return getBoards(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the boards associated with the board div.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardDivModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the board div
	 * @param start the lower bound of the range of board divs
	 * @param end the upper bound of the range of board divs (not inclusive)
	 * @return the range of boards associated with the board div
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.multiboard.model.Board> getBoards(long pk,
		int start, int end) throws SystemException {
		return getBoards(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the boards associated with the board div.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardDivModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the board div
	 * @param start the lower bound of the range of board divs
	 * @param end the upper bound of the range of board divs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of boards associated with the board div
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.multiboard.model.Board> getBoards(long pk,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return boardDivToBoardTableMapper.getRightBaseModels(pk, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of boards associated with the board div.
	 *
	 * @param pk the primary key of the board div
	 * @return the number of boards associated with the board div
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getBoardsSize(long pk) throws SystemException {
		long[] pks = boardDivToBoardTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the board is associated with the board div.
	 *
	 * @param pk the primary key of the board div
	 * @param boardPK the primary key of the board
	 * @return <code>true</code> if the board is associated with the board div; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsBoard(long pk, long boardPK)
		throws SystemException {
		return boardDivToBoardTableMapper.containsTableMapping(pk, boardPK);
	}

	/**
	 * Returns <code>true</code> if the board div has any boards associated with it.
	 *
	 * @param pk the primary key of the board div to check for associations with boards
	 * @return <code>true</code> if the board div has any boards associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsBoards(long pk) throws SystemException {
		if (getBoardsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the board div and the board. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board div
	 * @param boardPK the primary key of the board
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addBoard(long pk, long boardPK) throws SystemException {
		boardDivToBoardTableMapper.addTableMapping(pk, boardPK);
	}

	/**
	 * Adds an association between the board div and the board. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board div
	 * @param board the board
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addBoard(long pk, org.kisti.edison.multiboard.model.Board board)
		throws SystemException {
		boardDivToBoardTableMapper.addTableMapping(pk, board.getPrimaryKey());
	}

	/**
	 * Adds an association between the board div and the boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board div
	 * @param boardPKs the primary keys of the boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addBoards(long pk, long[] boardPKs) throws SystemException {
		for (long boardPK : boardPKs) {
			boardDivToBoardTableMapper.addTableMapping(pk, boardPK);
		}
	}

	/**
	 * Adds an association between the board div and the boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board div
	 * @param boards the boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addBoards(long pk,
		List<org.kisti.edison.multiboard.model.Board> boards)
		throws SystemException {
		for (org.kisti.edison.multiboard.model.Board board : boards) {
			boardDivToBoardTableMapper.addTableMapping(pk, board.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the board div and its boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board div to clear the associated boards from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearBoards(long pk) throws SystemException {
		boardDivToBoardTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the board div and the board. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board div
	 * @param boardPK the primary key of the board
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBoard(long pk, long boardPK) throws SystemException {
		boardDivToBoardTableMapper.deleteTableMapping(pk, boardPK);
	}

	/**
	 * Removes the association between the board div and the board. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board div
	 * @param board the board
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBoard(long pk,
		org.kisti.edison.multiboard.model.Board board)
		throws SystemException {
		boardDivToBoardTableMapper.deleteTableMapping(pk, board.getPrimaryKey());
	}

	/**
	 * Removes the association between the board div and the boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board div
	 * @param boardPKs the primary keys of the boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBoards(long pk, long[] boardPKs)
		throws SystemException {
		for (long boardPK : boardPKs) {
			boardDivToBoardTableMapper.deleteTableMapping(pk, boardPK);
		}
	}

	/**
	 * Removes the association between the board div and the boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board div
	 * @param boards the boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBoards(long pk,
		List<org.kisti.edison.multiboard.model.Board> boards)
		throws SystemException {
		for (org.kisti.edison.multiboard.model.Board board : boards) {
			boardDivToBoardTableMapper.deleteTableMapping(pk,
				board.getPrimaryKey());
		}
	}

	/**
	 * Sets the boards associated with the board div, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board div
	 * @param boardPKs the primary keys of the boards to be associated with the board div
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setBoards(long pk, long[] boardPKs) throws SystemException {
		Set<Long> newBoardPKsSet = SetUtil.fromArray(boardPKs);
		Set<Long> oldBoardPKsSet = SetUtil.fromArray(boardDivToBoardTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeBoardPKsSet = new HashSet<Long>(oldBoardPKsSet);

		removeBoardPKsSet.removeAll(newBoardPKsSet);

		for (long removeBoardPK : removeBoardPKsSet) {
			boardDivToBoardTableMapper.deleteTableMapping(pk, removeBoardPK);
		}

		newBoardPKsSet.removeAll(oldBoardPKsSet);

		for (long newBoardPK : newBoardPKsSet) {
			boardDivToBoardTableMapper.addTableMapping(pk, newBoardPK);
		}
	}

	/**
	 * Sets the boards associated with the board div, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board div
	 * @param boards the boards to be associated with the board div
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setBoards(long pk,
		List<org.kisti.edison.multiboard.model.Board> boards)
		throws SystemException {
		try {
			long[] boardPKs = new long[boards.size()];

			for (int i = 0; i < boards.size(); i++) {
				org.kisti.edison.multiboard.model.Board board = boards.get(i);

				boardPKs[i] = board.getPrimaryKey();
			}

			setBoards(pk, boardPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(BoardDivModelImpl.MAPPING_TABLE_EDCON_BOARDDIV_BOARD_NAME);
		}
	}

	/**
	 * Initializes the board div persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.multiboard.model.BoardDiv")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BoardDiv>> listenersList = new ArrayList<ModelListener<BoardDiv>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BoardDiv>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		boardDivToBoardTableMapper = TableMapperFactory.getTableMapper("EDCON_BoardDiv_Board",
				"divCd", "boardSeq", this, boardPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BoardDivImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("EDCON_BoardDiv_Board");
	}

	@BeanReference(type = BoardPersistence.class)
	protected BoardPersistence boardPersistence;
	protected TableMapper<BoardDiv, org.kisti.edison.multiboard.model.Board> boardDivToBoardTableMapper;
	private static final String _SQL_SELECT_BOARDDIV = "SELECT boardDiv FROM BoardDiv boardDiv";
	private static final String _SQL_SELECT_BOARDDIV_WHERE = "SELECT boardDiv FROM BoardDiv boardDiv WHERE ";
	private static final String _SQL_COUNT_BOARDDIV = "SELECT COUNT(boardDiv) FROM BoardDiv boardDiv";
	private static final String _SQL_COUNT_BOARDDIV_WHERE = "SELECT COUNT(boardDiv) FROM BoardDiv boardDiv WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "boardDiv.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BoardDiv exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BoardDiv exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BoardDivPersistenceImpl.class);
	private static BoardDiv _nullBoardDiv = new BoardDivImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BoardDiv> toCacheModel() {
				return _nullBoardDivCacheModel;
			}
		};

	private static CacheModel<BoardDiv> _nullBoardDivCacheModel = new CacheModel<BoardDiv>() {
			@Override
			public BoardDiv toEntityModel() {
				return _nullBoardDiv;
			}
		};
}