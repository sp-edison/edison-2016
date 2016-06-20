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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import org.kisti.edison.multiboard.NoSuchBoardException;
import org.kisti.edison.multiboard.model.Board;
import org.kisti.edison.multiboard.model.impl.BoardImpl;
import org.kisti.edison.multiboard.model.impl.BoardModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the board service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mhkang
 * @see BoardPersistence
 * @see BoardUtil
 * @generated
 */
public class BoardPersistenceImpl extends BasePersistenceImpl<Board>
	implements BoardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BoardUtil} to access the board persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BoardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BoardModelImpl.ENTITY_CACHE_ENABLED,
			BoardModelImpl.FINDER_CACHE_ENABLED, BoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BoardModelImpl.ENTITY_CACHE_ENABLED,
			BoardModelImpl.FINDER_CACHE_ENABLED, BoardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BoardModelImpl.ENTITY_CACHE_ENABLED,
			BoardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BoardPersistenceImpl() {
		setModelClass(Board.class);
	}

	/**
	 * Caches the board in the entity cache if it is enabled.
	 *
	 * @param board the board
	 */
	@Override
	public void cacheResult(Board board) {
		EntityCacheUtil.putResult(BoardModelImpl.ENTITY_CACHE_ENABLED,
			BoardImpl.class, board.getPrimaryKey(), board);

		board.resetOriginalValues();
	}

	/**
	 * Caches the boards in the entity cache if it is enabled.
	 *
	 * @param boards the boards
	 */
	@Override
	public void cacheResult(List<Board> boards) {
		for (Board board : boards) {
			if (EntityCacheUtil.getResult(BoardModelImpl.ENTITY_CACHE_ENABLED,
						BoardImpl.class, board.getPrimaryKey()) == null) {
				cacheResult(board);
			}
			else {
				board.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all boards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BoardImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BoardImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the board.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Board board) {
		EntityCacheUtil.removeResult(BoardModelImpl.ENTITY_CACHE_ENABLED,
			BoardImpl.class, board.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Board> boards) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Board board : boards) {
			EntityCacheUtil.removeResult(BoardModelImpl.ENTITY_CACHE_ENABLED,
				BoardImpl.class, board.getPrimaryKey());
		}
	}

	/**
	 * Creates a new board with the primary key. Does not add the board to the database.
	 *
	 * @param boardSeq the primary key for the new board
	 * @return the new board
	 */
	@Override
	public Board create(long boardSeq) {
		Board board = new BoardImpl();

		board.setNew(true);
		board.setPrimaryKey(boardSeq);

		return board;
	}

	/**
	 * Removes the board with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param boardSeq the primary key of the board
	 * @return the board that was removed
	 * @throws org.kisti.edison.multiboard.NoSuchBoardException if a board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Board remove(long boardSeq)
		throws NoSuchBoardException, SystemException {
		return remove((Serializable)boardSeq);
	}

	/**
	 * Removes the board with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the board
	 * @return the board that was removed
	 * @throws org.kisti.edison.multiboard.NoSuchBoardException if a board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Board remove(Serializable primaryKey)
		throws NoSuchBoardException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Board board = (Board)session.get(BoardImpl.class, primaryKey);

			if (board == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBoardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(board);
		}
		catch (NoSuchBoardException nsee) {
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
	protected Board removeImpl(Board board) throws SystemException {
		board = toUnwrappedModel(board);

		boardToBoardDivTableMapper.deleteLeftPrimaryKeyTableMappings(board.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(board)) {
				board = (Board)session.get(BoardImpl.class,
						board.getPrimaryKeyObj());
			}

			if (board != null) {
				session.delete(board);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (board != null) {
			clearCache(board);
		}

		return board;
	}

	@Override
	public Board updateImpl(org.kisti.edison.multiboard.model.Board board)
		throws SystemException {
		board = toUnwrappedModel(board);

		boolean isNew = board.isNew();

		Session session = null;

		try {
			session = openSession();

			if (board.isNew()) {
				session.save(board);

				board.setNew(false);
			}
			else {
				session.merge(board);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(BoardModelImpl.ENTITY_CACHE_ENABLED,
			BoardImpl.class, board.getPrimaryKey(), board);

		return board;
	}

	protected Board toUnwrappedModel(Board board) {
		if (board instanceof BoardImpl) {
			return board;
		}

		BoardImpl boardImpl = new BoardImpl();

		boardImpl.setNew(board.isNew());
		boardImpl.setPrimaryKey(board.getPrimaryKey());

		boardImpl.setBoardSeq(board.getBoardSeq());
		boardImpl.setTitle(board.getTitle());
		boardImpl.setContent(board.getContent());
		boardImpl.setGroupId(board.getGroupId());
		boardImpl.setCustomId(board.getCustomId());
		boardImpl.setWriterId(board.getWriterId());
		boardImpl.setWriterDate(board.getWriterDate());
		boardImpl.setReadCnt(board.getReadCnt());
		boardImpl.setGroupBoardSeq(board.getGroupBoardSeq());
		boardImpl.setGroupBoardTurn(board.getGroupBoardTurn());
		boardImpl.setReplyDepth(board.getReplyDepth());
		boardImpl.setSiteGroup(board.getSiteGroup());
		boardImpl.setPopupYn(board.isPopupYn());
		boardImpl.setPopupStartDt(board.getPopupStartDt());
		boardImpl.setPopupEndDt(board.getPopupEndDt());
		boardImpl.setInsertId(board.getInsertId());
		boardImpl.setInsertDt(board.getInsertDt());
		boardImpl.setUpdateId(board.getUpdateId());
		boardImpl.setUpdateDt(board.getUpdateDt());

		return boardImpl;
	}

	/**
	 * Returns the board with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the board
	 * @return the board
	 * @throws org.kisti.edison.multiboard.NoSuchBoardException if a board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Board findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBoardException, SystemException {
		Board board = fetchByPrimaryKey(primaryKey);

		if (board == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBoardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return board;
	}

	/**
	 * Returns the board with the primary key or throws a {@link org.kisti.edison.multiboard.NoSuchBoardException} if it could not be found.
	 *
	 * @param boardSeq the primary key of the board
	 * @return the board
	 * @throws org.kisti.edison.multiboard.NoSuchBoardException if a board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Board findByPrimaryKey(long boardSeq)
		throws NoSuchBoardException, SystemException {
		return findByPrimaryKey((Serializable)boardSeq);
	}

	/**
	 * Returns the board with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the board
	 * @return the board, or <code>null</code> if a board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Board fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Board board = (Board)EntityCacheUtil.getResult(BoardModelImpl.ENTITY_CACHE_ENABLED,
				BoardImpl.class, primaryKey);

		if (board == _nullBoard) {
			return null;
		}

		if (board == null) {
			Session session = null;

			try {
				session = openSession();

				board = (Board)session.get(BoardImpl.class, primaryKey);

				if (board != null) {
					cacheResult(board);
				}
				else {
					EntityCacheUtil.putResult(BoardModelImpl.ENTITY_CACHE_ENABLED,
						BoardImpl.class, primaryKey, _nullBoard);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BoardModelImpl.ENTITY_CACHE_ENABLED,
					BoardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return board;
	}

	/**
	 * Returns the board with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param boardSeq the primary key of the board
	 * @return the board, or <code>null</code> if a board with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Board fetchByPrimaryKey(long boardSeq) throws SystemException {
		return fetchByPrimaryKey((Serializable)boardSeq);
	}

	/**
	 * Returns all the boards.
	 *
	 * @return the boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Board> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the boards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of boards
	 * @param end the upper bound of the range of boards (not inclusive)
	 * @return the range of boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Board> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the boards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of boards
	 * @param end the upper bound of the range of boards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of boards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Board> findAll(int start, int end,
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

		List<Board> list = (List<Board>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BOARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BOARD;

				if (pagination) {
					sql = sql.concat(BoardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Board>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Board>(list);
				}
				else {
					list = (List<Board>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the boards from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Board board : findAll()) {
			remove(board);
		}
	}

	/**
	 * Returns the number of boards.
	 *
	 * @return the number of boards
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

				Query q = session.createQuery(_SQL_COUNT_BOARD);

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
	 * Returns all the board divs associated with the board.
	 *
	 * @param pk the primary key of the board
	 * @return the board divs associated with the board
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.multiboard.model.BoardDiv> getBoardDivs(
		long pk) throws SystemException {
		return getBoardDivs(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the board divs associated with the board.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the board
	 * @param start the lower bound of the range of boards
	 * @param end the upper bound of the range of boards (not inclusive)
	 * @return the range of board divs associated with the board
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.multiboard.model.BoardDiv> getBoardDivs(
		long pk, int start, int end) throws SystemException {
		return getBoardDivs(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the board divs associated with the board.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the board
	 * @param start the lower bound of the range of boards
	 * @param end the upper bound of the range of boards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of board divs associated with the board
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.multiboard.model.BoardDiv> getBoardDivs(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return boardToBoardDivTableMapper.getRightBaseModels(pk, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of board divs associated with the board.
	 *
	 * @param pk the primary key of the board
	 * @return the number of board divs associated with the board
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getBoardDivsSize(long pk) throws SystemException {
		long[] pks = boardToBoardDivTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the board div is associated with the board.
	 *
	 * @param pk the primary key of the board
	 * @param boardDivPK the primary key of the board div
	 * @return <code>true</code> if the board div is associated with the board; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsBoardDiv(long pk, long boardDivPK)
		throws SystemException {
		return boardToBoardDivTableMapper.containsTableMapping(pk, boardDivPK);
	}

	/**
	 * Returns <code>true</code> if the board has any board divs associated with it.
	 *
	 * @param pk the primary key of the board to check for associations with board divs
	 * @return <code>true</code> if the board has any board divs associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsBoardDivs(long pk) throws SystemException {
		if (getBoardDivsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the board and the board div. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board
	 * @param boardDivPK the primary key of the board div
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addBoardDiv(long pk, long boardDivPK) throws SystemException {
		boardToBoardDivTableMapper.addTableMapping(pk, boardDivPK);
	}

	/**
	 * Adds an association between the board and the board div. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board
	 * @param boardDiv the board div
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addBoardDiv(long pk,
		org.kisti.edison.multiboard.model.BoardDiv boardDiv)
		throws SystemException {
		boardToBoardDivTableMapper.addTableMapping(pk, boardDiv.getPrimaryKey());
	}

	/**
	 * Adds an association between the board and the board divs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board
	 * @param boardDivPKs the primary keys of the board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addBoardDivs(long pk, long[] boardDivPKs)
		throws SystemException {
		for (long boardDivPK : boardDivPKs) {
			boardToBoardDivTableMapper.addTableMapping(pk, boardDivPK);
		}
	}

	/**
	 * Adds an association between the board and the board divs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board
	 * @param boardDivs the board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addBoardDivs(long pk,
		List<org.kisti.edison.multiboard.model.BoardDiv> boardDivs)
		throws SystemException {
		for (org.kisti.edison.multiboard.model.BoardDiv boardDiv : boardDivs) {
			boardToBoardDivTableMapper.addTableMapping(pk,
				boardDiv.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the board and its board divs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board to clear the associated board divs from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearBoardDivs(long pk) throws SystemException {
		boardToBoardDivTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the board and the board div. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board
	 * @param boardDivPK the primary key of the board div
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBoardDiv(long pk, long boardDivPK)
		throws SystemException {
		boardToBoardDivTableMapper.deleteTableMapping(pk, boardDivPK);
	}

	/**
	 * Removes the association between the board and the board div. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board
	 * @param boardDiv the board div
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBoardDiv(long pk,
		org.kisti.edison.multiboard.model.BoardDiv boardDiv)
		throws SystemException {
		boardToBoardDivTableMapper.deleteTableMapping(pk,
			boardDiv.getPrimaryKey());
	}

	/**
	 * Removes the association between the board and the board divs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board
	 * @param boardDivPKs the primary keys of the board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBoardDivs(long pk, long[] boardDivPKs)
		throws SystemException {
		for (long boardDivPK : boardDivPKs) {
			boardToBoardDivTableMapper.deleteTableMapping(pk, boardDivPK);
		}
	}

	/**
	 * Removes the association between the board and the board divs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board
	 * @param boardDivs the board divs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBoardDivs(long pk,
		List<org.kisti.edison.multiboard.model.BoardDiv> boardDivs)
		throws SystemException {
		for (org.kisti.edison.multiboard.model.BoardDiv boardDiv : boardDivs) {
			boardToBoardDivTableMapper.deleteTableMapping(pk,
				boardDiv.getPrimaryKey());
		}
	}

	/**
	 * Sets the board divs associated with the board, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board
	 * @param boardDivPKs the primary keys of the board divs to be associated with the board
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setBoardDivs(long pk, long[] boardDivPKs)
		throws SystemException {
		Set<Long> newBoardDivPKsSet = SetUtil.fromArray(boardDivPKs);
		Set<Long> oldBoardDivPKsSet = SetUtil.fromArray(boardToBoardDivTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeBoardDivPKsSet = new HashSet<Long>(oldBoardDivPKsSet);

		removeBoardDivPKsSet.removeAll(newBoardDivPKsSet);

		for (long removeBoardDivPK : removeBoardDivPKsSet) {
			boardToBoardDivTableMapper.deleteTableMapping(pk, removeBoardDivPK);
		}

		newBoardDivPKsSet.removeAll(oldBoardDivPKsSet);

		for (long newBoardDivPK : newBoardDivPKsSet) {
			boardToBoardDivTableMapper.addTableMapping(pk, newBoardDivPK);
		}
	}

	/**
	 * Sets the board divs associated with the board, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the board
	 * @param boardDivs the board divs to be associated with the board
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setBoardDivs(long pk,
		List<org.kisti.edison.multiboard.model.BoardDiv> boardDivs)
		throws SystemException {
		try {
			long[] boardDivPKs = new long[boardDivs.size()];

			for (int i = 0; i < boardDivs.size(); i++) {
				org.kisti.edison.multiboard.model.BoardDiv boardDiv = boardDivs.get(i);

				boardDivPKs[i] = boardDiv.getPrimaryKey();
			}

			setBoardDivs(pk, boardDivPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(BoardModelImpl.MAPPING_TABLE_EDCON_BOARDDIV_BOARD_NAME);
		}
	}

	/**
	 * Initializes the board persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.multiboard.model.Board")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Board>> listenersList = new ArrayList<ModelListener<Board>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Board>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		boardToBoardDivTableMapper = TableMapperFactory.getTableMapper("EDCON_BoardDiv_Board",
				"boardSeq", "divCd", this, boardDivPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(BoardImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("EDCON_BoardDiv_Board");
	}

	@BeanReference(type = BoardDivPersistence.class)
	protected BoardDivPersistence boardDivPersistence;
	protected TableMapper<Board, org.kisti.edison.multiboard.model.BoardDiv> boardToBoardDivTableMapper;
	private static final String _SQL_SELECT_BOARD = "SELECT board FROM Board board";
	private static final String _SQL_COUNT_BOARD = "SELECT COUNT(board) FROM Board board";
	private static final String _ORDER_BY_ENTITY_ALIAS = "board.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Board exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BoardPersistenceImpl.class);
	private static Board _nullBoard = new BoardImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Board> toCacheModel() {
				return _nullBoardCacheModel;
			}
		};

	private static CacheModel<Board> _nullBoardCacheModel = new CacheModel<Board>() {
			@Override
			public Board toEntityModel() {
				return _nullBoard;
			}
		};
}