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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Board. This utility wraps
 * {@link org.kisti.edison.multiboard.service.impl.BoardLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author mhkang
 * @see BoardLocalService
 * @see org.kisti.edison.multiboard.service.base.BoardLocalServiceBaseImpl
 * @see org.kisti.edison.multiboard.service.impl.BoardLocalServiceImpl
 * @generated
 */
public class BoardLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.multiboard.service.impl.BoardLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the board to the database. Also notifies the appropriate model listeners.
	*
	* @param board the board
	* @return the board that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.Board addBoard(
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBoard(board);
	}

	/**
	* Creates a new board with the primary key. Does not add the board to the database.
	*
	* @param boardSeq the primary key for the new board
	* @return the new board
	*/
	public static org.kisti.edison.multiboard.model.Board createBoard(
		long boardSeq) {
		return getService().createBoard(boardSeq);
	}

	/**
	* Deletes the board with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param boardSeq the primary key of the board
	* @return the board that was removed
	* @throws PortalException if a board with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.Board deleteBoard(
		long boardSeq)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBoard(boardSeq);
	}

	/**
	* Deletes the board from the database. Also notifies the appropriate model listeners.
	*
	* @param board the board
	* @return the board that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.Board deleteBoard(
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBoard(board);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.kisti.edison.multiboard.model.Board fetchBoard(
		long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBoard(boardSeq);
	}

	/**
	* Returns the board with the primary key.
	*
	* @param boardSeq the primary key of the board
	* @return the board
	* @throws PortalException if a board with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.Board getBoard(
		long boardSeq)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBoard(boardSeq);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.kisti.edison.multiboard.model.Board> getBoards(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBoards(start, end);
	}

	/**
	* Returns the number of boards.
	*
	* @return the number of boards
	* @throws SystemException if a system exception occurred
	*/
	public static int getBoardsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBoardsCount();
	}

	/**
	* Updates the board in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param board the board
	* @return the board that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.Board updateBoard(
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBoard(board);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addBoardDivBoard(long divCd, long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addBoardDivBoard(divCd, boardSeq);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addBoardDivBoard(long divCd,
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addBoardDivBoard(divCd, board);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addBoardDivBoards(long divCd, long[] boardSeqs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addBoardDivBoards(divCd, boardSeqs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addBoardDivBoards(long divCd,
		java.util.List<org.kisti.edison.multiboard.model.Board> Boards)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addBoardDivBoards(divCd, Boards);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearBoardDivBoards(long divCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearBoardDivBoards(divCd);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteBoardDivBoard(long divCd, long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBoardDivBoard(divCd, boardSeq);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteBoardDivBoard(long divCd,
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBoardDivBoard(divCd, board);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteBoardDivBoards(long divCd, long[] boardSeqs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBoardDivBoards(divCd, boardSeqs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteBoardDivBoards(long divCd,
		java.util.List<org.kisti.edison.multiboard.model.Board> Boards)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBoardDivBoards(divCd, Boards);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.multiboard.model.Board> getBoardDivBoards(
		long divCd) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBoardDivBoards(divCd);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.multiboard.model.Board> getBoardDivBoards(
		long divCd, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBoardDivBoards(divCd, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.multiboard.model.Board> getBoardDivBoards(
		long divCd, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getBoardDivBoards(divCd, start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getBoardDivBoardsCount(long divCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBoardDivBoardsCount(divCd);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasBoardDivBoard(long divCd, long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasBoardDivBoard(divCd, boardSeq);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasBoardDivBoards(long divCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasBoardDivBoards(divCd);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setBoardDivBoards(long divCd, long[] boardSeqs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setBoardDivBoards(divCd, boardSeqs);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static org.kisti.edison.multiboard.model.Board addBoard(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService().addBoard(params);
	}

	public static org.kisti.edison.multiboard.model.Board updateBoard(
		java.util.Map<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.NoSuchModelException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService().updateBoard(params);
	}

	public static java.util.Map getBoard(long divCd, java.lang.String customId,
		long boardSeq, java.util.Locale locale) {
		return getService().getBoard(divCd, customId, boardSeq, locale);
	}

	public static void clearService() {
		_service = null;
	}

	public static BoardLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BoardLocalService.class.getName());

			if (invokableLocalService instanceof BoardLocalService) {
				_service = (BoardLocalService)invokableLocalService;
			}
			else {
				_service = new BoardLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BoardLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BoardLocalService service) {
	}

	private static BoardLocalService _service;
}