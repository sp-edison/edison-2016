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

import com.liferay.portal.service.persistence.BasePersistence;

import org.kisti.edison.multiboard.model.Board;

/**
 * The persistence interface for the board service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mhkang
 * @see BoardPersistenceImpl
 * @see BoardUtil
 * @generated
 */
public interface BoardPersistence extends BasePersistence<Board> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BoardUtil} to access the board persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the board in the entity cache if it is enabled.
	*
	* @param board the board
	*/
	public void cacheResult(org.kisti.edison.multiboard.model.Board board);

	/**
	* Caches the boards in the entity cache if it is enabled.
	*
	* @param boards the boards
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.multiboard.model.Board> boards);

	/**
	* Creates a new board with the primary key. Does not add the board to the database.
	*
	* @param boardSeq the primary key for the new board
	* @return the new board
	*/
	public org.kisti.edison.multiboard.model.Board create(long boardSeq);

	/**
	* Removes the board with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param boardSeq the primary key of the board
	* @return the board that was removed
	* @throws org.kisti.edison.multiboard.NoSuchBoardException if a board with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.Board remove(long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardException;

	public org.kisti.edison.multiboard.model.Board updateImpl(
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the board with the primary key or throws a {@link org.kisti.edison.multiboard.NoSuchBoardException} if it could not be found.
	*
	* @param boardSeq the primary key of the board
	* @return the board
	* @throws org.kisti.edison.multiboard.NoSuchBoardException if a board with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.Board findByPrimaryKey(
		long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardException;

	/**
	* Returns the board with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param boardSeq the primary key of the board
	* @return the board, or <code>null</code> if a board with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.Board fetchByPrimaryKey(
		long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the boards.
	*
	* @return the boards
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.multiboard.model.Board> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.multiboard.model.Board> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.multiboard.model.Board> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the boards from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of boards.
	*
	* @return the number of boards
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the board divs associated with the board.
	*
	* @param pk the primary key of the board
	* @return the board divs associated with the board
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.multiboard.model.BoardDiv> getBoardDivs(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.multiboard.model.BoardDiv> getBoardDivs(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.multiboard.model.BoardDiv> getBoardDivs(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of board divs associated with the board.
	*
	* @param pk the primary key of the board
	* @return the number of board divs associated with the board
	* @throws SystemException if a system exception occurred
	*/
	public int getBoardDivsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the board div is associated with the board.
	*
	* @param pk the primary key of the board
	* @param boardDivPK the primary key of the board div
	* @return <code>true</code> if the board div is associated with the board; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsBoardDiv(long pk, long boardDivPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the board has any board divs associated with it.
	*
	* @param pk the primary key of the board to check for associations with board divs
	* @return <code>true</code> if the board has any board divs associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsBoardDivs(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the board and the board div. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board
	* @param boardDivPK the primary key of the board div
	* @throws SystemException if a system exception occurred
	*/
	public void addBoardDiv(long pk, long boardDivPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the board and the board div. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board
	* @param boardDiv the board div
	* @throws SystemException if a system exception occurred
	*/
	public void addBoardDiv(long pk,
		org.kisti.edison.multiboard.model.BoardDiv boardDiv)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the board and the board divs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board
	* @param boardDivPKs the primary keys of the board divs
	* @throws SystemException if a system exception occurred
	*/
	public void addBoardDivs(long pk, long[] boardDivPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the board and the board divs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board
	* @param boardDivs the board divs
	* @throws SystemException if a system exception occurred
	*/
	public void addBoardDivs(long pk,
		java.util.List<org.kisti.edison.multiboard.model.BoardDiv> boardDivs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the board and its board divs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board to clear the associated board divs from
	* @throws SystemException if a system exception occurred
	*/
	public void clearBoardDivs(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the board and the board div. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board
	* @param boardDivPK the primary key of the board div
	* @throws SystemException if a system exception occurred
	*/
	public void removeBoardDiv(long pk, long boardDivPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the board and the board div. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board
	* @param boardDiv the board div
	* @throws SystemException if a system exception occurred
	*/
	public void removeBoardDiv(long pk,
		org.kisti.edison.multiboard.model.BoardDiv boardDiv)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the board and the board divs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board
	* @param boardDivPKs the primary keys of the board divs
	* @throws SystemException if a system exception occurred
	*/
	public void removeBoardDivs(long pk, long[] boardDivPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the board and the board divs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board
	* @param boardDivs the board divs
	* @throws SystemException if a system exception occurred
	*/
	public void removeBoardDivs(long pk,
		java.util.List<org.kisti.edison.multiboard.model.BoardDiv> boardDivs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the board divs associated with the board, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board
	* @param boardDivPKs the primary keys of the board divs to be associated with the board
	* @throws SystemException if a system exception occurred
	*/
	public void setBoardDivs(long pk, long[] boardDivPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the board divs associated with the board, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board
	* @param boardDivs the board divs to be associated with the board
	* @throws SystemException if a system exception occurred
	*/
	public void setBoardDivs(long pk,
		java.util.List<org.kisti.edison.multiboard.model.BoardDiv> boardDivs)
		throws com.liferay.portal.kernel.exception.SystemException;
}