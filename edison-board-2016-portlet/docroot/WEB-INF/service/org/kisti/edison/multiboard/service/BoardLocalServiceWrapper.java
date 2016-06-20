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

package org.kisti.edison.multiboard.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BoardLocalService}.
 *
 * @author mhkang
 * @see BoardLocalService
 * @generated
 */
public class BoardLocalServiceWrapper implements BoardLocalService,
	ServiceWrapper<BoardLocalService> {
	public BoardLocalServiceWrapper(BoardLocalService boardLocalService) {
		_boardLocalService = boardLocalService;
	}

	/**
	* Adds the board to the database. Also notifies the appropriate model listeners.
	*
	* @param board the board
	* @return the board that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.multiboard.model.Board addBoard(
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.addBoard(board);
	}

	/**
	* Creates a new board with the primary key. Does not add the board to the database.
	*
	* @param boardSeq the primary key for the new board
	* @return the new board
	*/
	@Override
	public org.kisti.edison.multiboard.model.Board createBoard(long boardSeq) {
		return _boardLocalService.createBoard(boardSeq);
	}

	/**
	* Deletes the board with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param boardSeq the primary key of the board
	* @return the board that was removed
	* @throws PortalException if a board with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.multiboard.model.Board deleteBoard(long boardSeq)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.deleteBoard(boardSeq);
	}

	/**
	* Deletes the board from the database. Also notifies the appropriate model listeners.
	*
	* @param board the board
	* @return the board that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.multiboard.model.Board deleteBoard(
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.deleteBoard(board);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _boardLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.kisti.edison.multiboard.model.Board fetchBoard(long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.fetchBoard(boardSeq);
	}

	/**
	* Returns the board with the primary key.
	*
	* @param boardSeq the primary key of the board
	* @return the board
	* @throws PortalException if a board with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.multiboard.model.Board getBoard(long boardSeq)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.getBoard(boardSeq);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<org.kisti.edison.multiboard.model.Board> getBoards(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.getBoards(start, end);
	}

	/**
	* Returns the number of boards.
	*
	* @return the number of boards
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBoardsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.getBoardsCount();
	}

	/**
	* Updates the board in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param board the board
	* @return the board that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.multiboard.model.Board updateBoard(
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.updateBoard(board);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addBoardDivBoard(long divCd, long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		_boardLocalService.addBoardDivBoard(divCd, boardSeq);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addBoardDivBoard(long divCd,
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException {
		_boardLocalService.addBoardDivBoard(divCd, board);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addBoardDivBoards(long divCd, long[] boardSeqs)
		throws com.liferay.portal.kernel.exception.SystemException {
		_boardLocalService.addBoardDivBoards(divCd, boardSeqs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addBoardDivBoards(long divCd,
		java.util.List<org.kisti.edison.multiboard.model.Board> Boards)
		throws com.liferay.portal.kernel.exception.SystemException {
		_boardLocalService.addBoardDivBoards(divCd, Boards);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearBoardDivBoards(long divCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		_boardLocalService.clearBoardDivBoards(divCd);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteBoardDivBoard(long divCd, long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		_boardLocalService.deleteBoardDivBoard(divCd, boardSeq);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteBoardDivBoard(long divCd,
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException {
		_boardLocalService.deleteBoardDivBoard(divCd, board);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteBoardDivBoards(long divCd, long[] boardSeqs)
		throws com.liferay.portal.kernel.exception.SystemException {
		_boardLocalService.deleteBoardDivBoards(divCd, boardSeqs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteBoardDivBoards(long divCd,
		java.util.List<org.kisti.edison.multiboard.model.Board> Boards)
		throws com.liferay.portal.kernel.exception.SystemException {
		_boardLocalService.deleteBoardDivBoards(divCd, Boards);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.multiboard.model.Board> getBoardDivBoards(
		long divCd) throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.getBoardDivBoards(divCd);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.multiboard.model.Board> getBoardDivBoards(
		long divCd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.getBoardDivBoards(divCd, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.multiboard.model.Board> getBoardDivBoards(
		long divCd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.getBoardDivBoards(divCd, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBoardDivBoardsCount(long divCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.getBoardDivBoardsCount(divCd);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasBoardDivBoard(long divCd, long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.hasBoardDivBoard(divCd, boardSeq);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasBoardDivBoards(long divCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _boardLocalService.hasBoardDivBoards(divCd);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setBoardDivBoards(long divCd, long[] boardSeqs)
		throws com.liferay.portal.kernel.exception.SystemException {
		_boardLocalService.setBoardDivBoards(divCd, boardSeqs);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _boardLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_boardLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _boardLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public org.kisti.edison.multiboard.model.Board addBoard(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _boardLocalService.addBoard(params);
	}

	@Override
	public org.kisti.edison.multiboard.model.Board updateBoard(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _boardLocalService.updateBoard(params);
	}

	@Override
	public java.util.Map getBoard(long divCd, java.lang.String customId,
		long boardSeq, java.util.Locale locale) {
		return _boardLocalService.getBoard(divCd, customId, boardSeq, locale);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BoardLocalService getWrappedBoardLocalService() {
		return _boardLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBoardLocalService(BoardLocalService boardLocalService) {
		_boardLocalService = boardLocalService;
	}

	@Override
	public BoardLocalService getWrappedService() {
		return _boardLocalService;
	}

	@Override
	public void setWrappedService(BoardLocalService boardLocalService) {
		_boardLocalService = boardLocalService;
	}

	private BoardLocalService _boardLocalService;
}