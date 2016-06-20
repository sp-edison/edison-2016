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
 * Provides a wrapper for {@link BoardDivService}.
 *
 * @author mhkang
 * @see BoardDivService
 * @generated
 */
public class BoardDivServiceWrapper implements BoardDivService,
	ServiceWrapper<BoardDivService> {
	public BoardDivServiceWrapper(BoardDivService boardDivService) {
		_boardDivService = boardDivService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _boardDivService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_boardDivService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _boardDivService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BoardDivService getWrappedBoardDivService() {
		return _boardDivService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBoardDivService(BoardDivService boardDivService) {
		_boardDivService = boardDivService;
	}

	@Override
	public BoardDivService getWrappedService() {
		return _boardDivService;
	}

	@Override
	public void setWrappedService(BoardDivService boardDivService) {
		_boardDivService = boardDivService;
	}

	private BoardDivService _boardDivService;
}