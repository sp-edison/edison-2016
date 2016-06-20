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

import org.kisti.edison.multiboard.model.BoardDiv;

/**
 * The persistence interface for the board div service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mhkang
 * @see BoardDivPersistenceImpl
 * @see BoardDivUtil
 * @generated
 */
public interface BoardDivPersistence extends BasePersistence<BoardDiv> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BoardDivUtil} to access the board div persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the board divs where popupYn = &#63;.
	*
	* @param popupYn the popup yn
	* @return the matching board divs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findByPopupYn(
		boolean popupYn)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findByPopupYn(
		boolean popupYn, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findByPopupYn(
		boolean popupYn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first board div in the ordered set where popupYn = &#63;.
	*
	* @param popupYn the popup yn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching board div
	* @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a matching board div could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.BoardDiv findByPopupYn_First(
		boolean popupYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException;

	/**
	* Returns the first board div in the ordered set where popupYn = &#63;.
	*
	* @param popupYn the popup yn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching board div, or <code>null</code> if a matching board div could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.BoardDiv fetchByPopupYn_First(
		boolean popupYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last board div in the ordered set where popupYn = &#63;.
	*
	* @param popupYn the popup yn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching board div
	* @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a matching board div could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.BoardDiv findByPopupYn_Last(
		boolean popupYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException;

	/**
	* Returns the last board div in the ordered set where popupYn = &#63;.
	*
	* @param popupYn the popup yn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching board div, or <code>null</code> if a matching board div could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.BoardDiv fetchByPopupYn_Last(
		boolean popupYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.multiboard.model.BoardDiv[] findByPopupYn_PrevAndNext(
		long divCd, boolean popupYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException;

	/**
	* Removes all the board divs where popupYn = &#63; from the database.
	*
	* @param popupYn the popup yn
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPopupYn(boolean popupYn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of board divs where popupYn = &#63;.
	*
	* @param popupYn the popup yn
	* @return the number of matching board divs
	* @throws SystemException if a system exception occurred
	*/
	public int countByPopupYn(boolean popupYn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the board divs where fileUpLoadUseYn = &#63;.
	*
	* @param fileUpLoadUseYn the file up load use yn
	* @return the matching board divs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findByFileUpLoadUseYn(
		boolean fileUpLoadUseYn)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findByFileUpLoadUseYn(
		boolean fileUpLoadUseYn, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findByFileUpLoadUseYn(
		boolean fileUpLoadUseYn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first board div in the ordered set where fileUpLoadUseYn = &#63;.
	*
	* @param fileUpLoadUseYn the file up load use yn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching board div
	* @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a matching board div could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.BoardDiv findByFileUpLoadUseYn_First(
		boolean fileUpLoadUseYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException;

	/**
	* Returns the first board div in the ordered set where fileUpLoadUseYn = &#63;.
	*
	* @param fileUpLoadUseYn the file up load use yn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching board div, or <code>null</code> if a matching board div could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.BoardDiv fetchByFileUpLoadUseYn_First(
		boolean fileUpLoadUseYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last board div in the ordered set where fileUpLoadUseYn = &#63;.
	*
	* @param fileUpLoadUseYn the file up load use yn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching board div
	* @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a matching board div could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.BoardDiv findByFileUpLoadUseYn_Last(
		boolean fileUpLoadUseYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException;

	/**
	* Returns the last board div in the ordered set where fileUpLoadUseYn = &#63;.
	*
	* @param fileUpLoadUseYn the file up load use yn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching board div, or <code>null</code> if a matching board div could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.BoardDiv fetchByFileUpLoadUseYn_Last(
		boolean fileUpLoadUseYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.multiboard.model.BoardDiv[] findByFileUpLoadUseYn_PrevAndNext(
		long divCd, boolean fileUpLoadUseYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException;

	/**
	* Removes all the board divs where fileUpLoadUseYn = &#63; from the database.
	*
	* @param fileUpLoadUseYn the file up load use yn
	* @throws SystemException if a system exception occurred
	*/
	public void removeByFileUpLoadUseYn(boolean fileUpLoadUseYn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of board divs where fileUpLoadUseYn = &#63;.
	*
	* @param fileUpLoadUseYn the file up load use yn
	* @return the number of matching board divs
	* @throws SystemException if a system exception occurred
	*/
	public int countByFileUpLoadUseYn(boolean fileUpLoadUseYn)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the board div in the entity cache if it is enabled.
	*
	* @param boardDiv the board div
	*/
	public void cacheResult(org.kisti.edison.multiboard.model.BoardDiv boardDiv);

	/**
	* Caches the board divs in the entity cache if it is enabled.
	*
	* @param boardDivs the board divs
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.multiboard.model.BoardDiv> boardDivs);

	/**
	* Creates a new board div with the primary key. Does not add the board div to the database.
	*
	* @param divCd the primary key for the new board div
	* @return the new board div
	*/
	public org.kisti.edison.multiboard.model.BoardDiv create(long divCd);

	/**
	* Removes the board div with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param divCd the primary key of the board div
	* @return the board div that was removed
	* @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a board div with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.BoardDiv remove(long divCd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException;

	public org.kisti.edison.multiboard.model.BoardDiv updateImpl(
		org.kisti.edison.multiboard.model.BoardDiv boardDiv)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the board div with the primary key or throws a {@link org.kisti.edison.multiboard.NoSuchBoardDivException} if it could not be found.
	*
	* @param divCd the primary key of the board div
	* @return the board div
	* @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a board div with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.BoardDiv findByPrimaryKey(
		long divCd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException;

	/**
	* Returns the board div with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param divCd the primary key of the board div
	* @return the board div, or <code>null</code> if a board div with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.multiboard.model.BoardDiv fetchByPrimaryKey(
		long divCd) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the board divs.
	*
	* @return the board divs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the board divs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of board divs.
	*
	* @return the number of board divs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the boards associated with the board div.
	*
	* @param pk the primary key of the board div
	* @return the boards associated with the board div
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.multiboard.model.Board> getBoards(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.multiboard.model.Board> getBoards(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.multiboard.model.Board> getBoards(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of boards associated with the board div.
	*
	* @param pk the primary key of the board div
	* @return the number of boards associated with the board div
	* @throws SystemException if a system exception occurred
	*/
	public int getBoardsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the board is associated with the board div.
	*
	* @param pk the primary key of the board div
	* @param boardPK the primary key of the board
	* @return <code>true</code> if the board is associated with the board div; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsBoard(long pk, long boardPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the board div has any boards associated with it.
	*
	* @param pk the primary key of the board div to check for associations with boards
	* @return <code>true</code> if the board div has any boards associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsBoards(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the board div and the board. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boardPK the primary key of the board
	* @throws SystemException if a system exception occurred
	*/
	public void addBoard(long pk, long boardPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the board div and the board. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param board the board
	* @throws SystemException if a system exception occurred
	*/
	public void addBoard(long pk, org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the board div and the boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boardPKs the primary keys of the boards
	* @throws SystemException if a system exception occurred
	*/
	public void addBoards(long pk, long[] boardPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the board div and the boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boards the boards
	* @throws SystemException if a system exception occurred
	*/
	public void addBoards(long pk,
		java.util.List<org.kisti.edison.multiboard.model.Board> boards)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the board div and its boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div to clear the associated boards from
	* @throws SystemException if a system exception occurred
	*/
	public void clearBoards(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the board div and the board. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boardPK the primary key of the board
	* @throws SystemException if a system exception occurred
	*/
	public void removeBoard(long pk, long boardPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the board div and the board. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param board the board
	* @throws SystemException if a system exception occurred
	*/
	public void removeBoard(long pk,
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the board div and the boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boardPKs the primary keys of the boards
	* @throws SystemException if a system exception occurred
	*/
	public void removeBoards(long pk, long[] boardPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the board div and the boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boards the boards
	* @throws SystemException if a system exception occurred
	*/
	public void removeBoards(long pk,
		java.util.List<org.kisti.edison.multiboard.model.Board> boards)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the boards associated with the board div, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boardPKs the primary keys of the boards to be associated with the board div
	* @throws SystemException if a system exception occurred
	*/
	public void setBoards(long pk, long[] boardPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the boards associated with the board div, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boards the boards to be associated with the board div
	* @throws SystemException if a system exception occurred
	*/
	public void setBoards(long pk,
		java.util.List<org.kisti.edison.multiboard.model.Board> boards)
		throws com.liferay.portal.kernel.exception.SystemException;
}