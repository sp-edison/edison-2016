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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.kisti.edison.multiboard.model.BoardDiv;

import java.util.List;

/**
 * The persistence utility for the board div service. This utility wraps {@link BoardDivPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author mhkang
 * @see BoardDivPersistence
 * @see BoardDivPersistenceImpl
 * @generated
 */
public class BoardDivUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(BoardDiv boardDiv) {
		getPersistence().clearCache(boardDiv);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BoardDiv> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BoardDiv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BoardDiv> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BoardDiv update(BoardDiv boardDiv) throws SystemException {
		return getPersistence().update(boardDiv);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BoardDiv update(BoardDiv boardDiv,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(boardDiv, serviceContext);
	}

	/**
	* Returns all the board divs where popupYn = &#63;.
	*
	* @param popupYn the popup yn
	* @return the matching board divs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findByPopupYn(
		boolean popupYn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPopupYn(popupYn);
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
	public static java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findByPopupYn(
		boolean popupYn, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPopupYn(popupYn, start, end);
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
	public static java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findByPopupYn(
		boolean popupYn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPopupYn(popupYn, start, end, orderByComparator);
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
	public static org.kisti.edison.multiboard.model.BoardDiv findByPopupYn_First(
		boolean popupYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException {
		return getPersistence().findByPopupYn_First(popupYn, orderByComparator);
	}

	/**
	* Returns the first board div in the ordered set where popupYn = &#63;.
	*
	* @param popupYn the popup yn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching board div, or <code>null</code> if a matching board div could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv fetchByPopupYn_First(
		boolean popupYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPopupYn_First(popupYn, orderByComparator);
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
	public static org.kisti.edison.multiboard.model.BoardDiv findByPopupYn_Last(
		boolean popupYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException {
		return getPersistence().findByPopupYn_Last(popupYn, orderByComparator);
	}

	/**
	* Returns the last board div in the ordered set where popupYn = &#63;.
	*
	* @param popupYn the popup yn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching board div, or <code>null</code> if a matching board div could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv fetchByPopupYn_Last(
		boolean popupYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPopupYn_Last(popupYn, orderByComparator);
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
	public static org.kisti.edison.multiboard.model.BoardDiv[] findByPopupYn_PrevAndNext(
		long divCd, boolean popupYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException {
		return getPersistence()
				   .findByPopupYn_PrevAndNext(divCd, popupYn, orderByComparator);
	}

	/**
	* Removes all the board divs where popupYn = &#63; from the database.
	*
	* @param popupYn the popup yn
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPopupYn(boolean popupYn)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPopupYn(popupYn);
	}

	/**
	* Returns the number of board divs where popupYn = &#63;.
	*
	* @param popupYn the popup yn
	* @return the number of matching board divs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPopupYn(boolean popupYn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPopupYn(popupYn);
	}

	/**
	* Returns all the board divs where fileUpLoadUseYn = &#63;.
	*
	* @param fileUpLoadUseYn the file up load use yn
	* @return the matching board divs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findByFileUpLoadUseYn(
		boolean fileUpLoadUseYn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByFileUpLoadUseYn(fileUpLoadUseYn);
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
	public static java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findByFileUpLoadUseYn(
		boolean fileUpLoadUseYn, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFileUpLoadUseYn(fileUpLoadUseYn, start, end);
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
	public static java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findByFileUpLoadUseYn(
		boolean fileUpLoadUseYn, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByFileUpLoadUseYn(fileUpLoadUseYn, start, end,
			orderByComparator);
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
	public static org.kisti.edison.multiboard.model.BoardDiv findByFileUpLoadUseYn_First(
		boolean fileUpLoadUseYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException {
		return getPersistence()
				   .findByFileUpLoadUseYn_First(fileUpLoadUseYn,
			orderByComparator);
	}

	/**
	* Returns the first board div in the ordered set where fileUpLoadUseYn = &#63;.
	*
	* @param fileUpLoadUseYn the file up load use yn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching board div, or <code>null</code> if a matching board div could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv fetchByFileUpLoadUseYn_First(
		boolean fileUpLoadUseYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileUpLoadUseYn_First(fileUpLoadUseYn,
			orderByComparator);
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
	public static org.kisti.edison.multiboard.model.BoardDiv findByFileUpLoadUseYn_Last(
		boolean fileUpLoadUseYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException {
		return getPersistence()
				   .findByFileUpLoadUseYn_Last(fileUpLoadUseYn,
			orderByComparator);
	}

	/**
	* Returns the last board div in the ordered set where fileUpLoadUseYn = &#63;.
	*
	* @param fileUpLoadUseYn the file up load use yn
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching board div, or <code>null</code> if a matching board div could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv fetchByFileUpLoadUseYn_Last(
		boolean fileUpLoadUseYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByFileUpLoadUseYn_Last(fileUpLoadUseYn,
			orderByComparator);
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
	public static org.kisti.edison.multiboard.model.BoardDiv[] findByFileUpLoadUseYn_PrevAndNext(
		long divCd, boolean fileUpLoadUseYn,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException {
		return getPersistence()
				   .findByFileUpLoadUseYn_PrevAndNext(divCd, fileUpLoadUseYn,
			orderByComparator);
	}

	/**
	* Removes all the board divs where fileUpLoadUseYn = &#63; from the database.
	*
	* @param fileUpLoadUseYn the file up load use yn
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByFileUpLoadUseYn(boolean fileUpLoadUseYn)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByFileUpLoadUseYn(fileUpLoadUseYn);
	}

	/**
	* Returns the number of board divs where fileUpLoadUseYn = &#63;.
	*
	* @param fileUpLoadUseYn the file up load use yn
	* @return the number of matching board divs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByFileUpLoadUseYn(boolean fileUpLoadUseYn)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByFileUpLoadUseYn(fileUpLoadUseYn);
	}

	/**
	* Caches the board div in the entity cache if it is enabled.
	*
	* @param boardDiv the board div
	*/
	public static void cacheResult(
		org.kisti.edison.multiboard.model.BoardDiv boardDiv) {
		getPersistence().cacheResult(boardDiv);
	}

	/**
	* Caches the board divs in the entity cache if it is enabled.
	*
	* @param boardDivs the board divs
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.multiboard.model.BoardDiv> boardDivs) {
		getPersistence().cacheResult(boardDivs);
	}

	/**
	* Creates a new board div with the primary key. Does not add the board div to the database.
	*
	* @param divCd the primary key for the new board div
	* @return the new board div
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv create(long divCd) {
		return getPersistence().create(divCd);
	}

	/**
	* Removes the board div with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param divCd the primary key of the board div
	* @return the board div that was removed
	* @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a board div with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv remove(long divCd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException {
		return getPersistence().remove(divCd);
	}

	public static org.kisti.edison.multiboard.model.BoardDiv updateImpl(
		org.kisti.edison.multiboard.model.BoardDiv boardDiv)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(boardDiv);
	}

	/**
	* Returns the board div with the primary key or throws a {@link org.kisti.edison.multiboard.NoSuchBoardDivException} if it could not be found.
	*
	* @param divCd the primary key of the board div
	* @return the board div
	* @throws org.kisti.edison.multiboard.NoSuchBoardDivException if a board div with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv findByPrimaryKey(
		long divCd)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.multiboard.NoSuchBoardDivException {
		return getPersistence().findByPrimaryKey(divCd);
	}

	/**
	* Returns the board div with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param divCd the primary key of the board div
	* @return the board div, or <code>null</code> if a board div with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv fetchByPrimaryKey(
		long divCd) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(divCd);
	}

	/**
	* Returns all the board divs.
	*
	* @return the board divs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<org.kisti.edison.multiboard.model.BoardDiv> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the board divs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of board divs.
	*
	* @return the number of board divs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the boards associated with the board div.
	*
	* @param pk the primary key of the board div
	* @return the boards associated with the board div
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.multiboard.model.Board> getBoards(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getBoards(pk);
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
	public static java.util.List<org.kisti.edison.multiboard.model.Board> getBoards(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getBoards(pk, start, end);
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
	public static java.util.List<org.kisti.edison.multiboard.model.Board> getBoards(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getBoards(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of boards associated with the board div.
	*
	* @param pk the primary key of the board div
	* @return the number of boards associated with the board div
	* @throws SystemException if a system exception occurred
	*/
	public static int getBoardsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getBoardsSize(pk);
	}

	/**
	* Returns <code>true</code> if the board is associated with the board div.
	*
	* @param pk the primary key of the board div
	* @param boardPK the primary key of the board
	* @return <code>true</code> if the board is associated with the board div; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsBoard(long pk, long boardPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsBoard(pk, boardPK);
	}

	/**
	* Returns <code>true</code> if the board div has any boards associated with it.
	*
	* @param pk the primary key of the board div to check for associations with boards
	* @return <code>true</code> if the board div has any boards associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsBoards(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsBoards(pk);
	}

	/**
	* Adds an association between the board div and the board. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boardPK the primary key of the board
	* @throws SystemException if a system exception occurred
	*/
	public static void addBoard(long pk, long boardPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addBoard(pk, boardPK);
	}

	/**
	* Adds an association between the board div and the board. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param board the board
	* @throws SystemException if a system exception occurred
	*/
	public static void addBoard(long pk,
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addBoard(pk, board);
	}

	/**
	* Adds an association between the board div and the boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boardPKs the primary keys of the boards
	* @throws SystemException if a system exception occurred
	*/
	public static void addBoards(long pk, long[] boardPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addBoards(pk, boardPKs);
	}

	/**
	* Adds an association between the board div and the boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boards the boards
	* @throws SystemException if a system exception occurred
	*/
	public static void addBoards(long pk,
		java.util.List<org.kisti.edison.multiboard.model.Board> boards)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addBoards(pk, boards);
	}

	/**
	* Clears all associations between the board div and its boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div to clear the associated boards from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearBoards(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearBoards(pk);
	}

	/**
	* Removes the association between the board div and the board. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boardPK the primary key of the board
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBoard(long pk, long boardPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBoard(pk, boardPK);
	}

	/**
	* Removes the association between the board div and the board. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param board the board
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBoard(long pk,
		org.kisti.edison.multiboard.model.Board board)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBoard(pk, board);
	}

	/**
	* Removes the association between the board div and the boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boardPKs the primary keys of the boards
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBoards(long pk, long[] boardPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBoards(pk, boardPKs);
	}

	/**
	* Removes the association between the board div and the boards. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boards the boards
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBoards(long pk,
		java.util.List<org.kisti.edison.multiboard.model.Board> boards)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBoards(pk, boards);
	}

	/**
	* Sets the boards associated with the board div, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boardPKs the primary keys of the boards to be associated with the board div
	* @throws SystemException if a system exception occurred
	*/
	public static void setBoards(long pk, long[] boardPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setBoards(pk, boardPKs);
	}

	/**
	* Sets the boards associated with the board div, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the board div
	* @param boards the boards to be associated with the board div
	* @throws SystemException if a system exception occurred
	*/
	public static void setBoards(long pk,
		java.util.List<org.kisti.edison.multiboard.model.Board> boards)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setBoards(pk, boards);
	}

	public static BoardDivPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BoardDivPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.multiboard.service.ClpSerializer.getServletContextName(),
					BoardDivPersistence.class.getName());

			ReferenceRegistry.registerReference(BoardDivUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BoardDivPersistence persistence) {
	}

	private static BoardDivPersistence _persistence;
}