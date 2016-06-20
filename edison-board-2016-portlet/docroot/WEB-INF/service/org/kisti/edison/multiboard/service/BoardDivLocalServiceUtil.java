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
 * Provides the local service utility for BoardDiv. This utility wraps
 * {@link org.kisti.edison.multiboard.service.impl.BoardDivLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author mhkang
 * @see BoardDivLocalService
 * @see org.kisti.edison.multiboard.service.base.BoardDivLocalServiceBaseImpl
 * @see org.kisti.edison.multiboard.service.impl.BoardDivLocalServiceImpl
 * @generated
 */
public class BoardDivLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.multiboard.service.impl.BoardDivLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the board div to the database. Also notifies the appropriate model listeners.
	*
	* @param boardDiv the board div
	* @return the board div that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv addBoardDiv(
		org.kisti.edison.multiboard.model.BoardDiv boardDiv)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBoardDiv(boardDiv);
	}

	/**
	* Creates a new board div with the primary key. Does not add the board div to the database.
	*
	* @param divCd the primary key for the new board div
	* @return the new board div
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv createBoardDiv(
		long divCd) {
		return getService().createBoardDiv(divCd);
	}

	/**
	* Deletes the board div with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param divCd the primary key of the board div
	* @return the board div that was removed
	* @throws PortalException if a board div with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv deleteBoardDiv(
		long divCd)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBoardDiv(divCd);
	}

	/**
	* Deletes the board div from the database. Also notifies the appropriate model listeners.
	*
	* @param boardDiv the board div
	* @return the board div that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv deleteBoardDiv(
		org.kisti.edison.multiboard.model.BoardDiv boardDiv)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBoardDiv(boardDiv);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardDivModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.multiboard.model.impl.BoardDivModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.kisti.edison.multiboard.model.BoardDiv fetchBoardDiv(
		long divCd) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBoardDiv(divCd);
	}

	/**
	* Returns the board div with the primary key.
	*
	* @param divCd the primary key of the board div
	* @return the board div
	* @throws PortalException if a board div with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv getBoardDiv(
		long divCd)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBoardDiv(divCd);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.kisti.edison.multiboard.model.BoardDiv> getBoardDivs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBoardDivs(start, end);
	}

	/**
	* Returns the number of board divs.
	*
	* @return the number of board divs
	* @throws SystemException if a system exception occurred
	*/
	public static int getBoardDivsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBoardDivsCount();
	}

	/**
	* Updates the board div in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param boardDiv the board div
	* @return the board div that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.multiboard.model.BoardDiv updateBoardDiv(
		org.kisti.edison.multiboard.model.BoardDiv boardDiv)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBoardDiv(boardDiv);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addBoardBoardDiv(long boardSeq, long divCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addBoardBoardDiv(boardSeq, divCd);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addBoardBoardDiv(long boardSeq,
		org.kisti.edison.multiboard.model.BoardDiv boardDiv)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addBoardBoardDiv(boardSeq, boardDiv);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addBoardBoardDivs(long boardSeq, long[] divCds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addBoardBoardDivs(boardSeq, divCds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addBoardBoardDivs(long boardSeq,
		java.util.List<org.kisti.edison.multiboard.model.BoardDiv> BoardDivs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addBoardBoardDivs(boardSeq, BoardDivs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearBoardBoardDivs(long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearBoardBoardDivs(boardSeq);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteBoardBoardDiv(long boardSeq, long divCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBoardBoardDiv(boardSeq, divCd);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteBoardBoardDiv(long boardSeq,
		org.kisti.edison.multiboard.model.BoardDiv boardDiv)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBoardBoardDiv(boardSeq, boardDiv);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteBoardBoardDivs(long boardSeq, long[] divCds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBoardBoardDivs(boardSeq, divCds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteBoardBoardDivs(long boardSeq,
		java.util.List<org.kisti.edison.multiboard.model.BoardDiv> BoardDivs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBoardBoardDivs(boardSeq, BoardDivs);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.multiboard.model.BoardDiv> getBoardBoardDivs(
		long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBoardBoardDivs(boardSeq);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.multiboard.model.BoardDiv> getBoardBoardDivs(
		long boardSeq, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBoardBoardDivs(boardSeq, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.multiboard.model.BoardDiv> getBoardBoardDivs(
		long boardSeq, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getBoardBoardDivs(boardSeq, start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getBoardBoardDivsCount(long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBoardBoardDivsCount(boardSeq);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasBoardBoardDiv(long boardSeq, long divCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasBoardBoardDiv(boardSeq, divCd);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasBoardBoardDivs(long boardSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasBoardBoardDivs(boardSeq);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setBoardBoardDivs(long boardSeq, long[] divCds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setBoardBoardDivs(boardSeq, divCds);
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

	public static java.util.List getCustomListBoard(long divCd, int start,
		int listSize, long groupId, java.lang.String customId,
		java.lang.String searchValue, java.util.Locale locale,
		long groupBoardSeq, boolean popupYn, java.lang.String siteGroup)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCustomListBoard(divCd, start, listSize, groupId,
			customId, searchValue, locale, groupBoardSeq, popupYn, siteGroup);
	}

	public static int getCustomCountBoard(long divCd, long groupId,
		java.lang.String customId, java.lang.String searchValue,
		long groupBoardSeq, java.lang.String siteGroup)
		throws com.liferay.portal.NoSuchUserException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCustomCountBoard(divCd, groupId, customId, searchValue,
			groupBoardSeq, siteGroup);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getAllBoardDivs()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllBoardDivs();
	}

	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeAll();
	}

	public static void insertBoardDiv(long divCd,
		java.lang.String titleNmFirst, java.lang.String titleNmSecond,
		java.lang.String contentNm, java.lang.String divNm,
		boolean fileUpLoadUseYn, boolean popupYn, boolean replyYn)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.insertBoardDiv(divCd, titleNmFirst, titleNmSecond, contentNm,
			divNm, fileUpLoadUseYn, popupYn, replyYn);
	}

	public static void clearService() {
		_service = null;
	}

	public static BoardDivLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BoardDivLocalService.class.getName());

			if (invokableLocalService instanceof BoardDivLocalService) {
				_service = (BoardDivLocalService)invokableLocalService;
			}
			else {
				_service = new BoardDivLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BoardDivLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BoardDivLocalService service) {
	}

	private static BoardDivLocalService _service;
}