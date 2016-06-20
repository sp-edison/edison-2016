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

/**
 * @author mhkang
 */
public interface BoardFinder {
	public java.util.List<java.lang.Object[]> getCustomListBoard(long divCd,
		int begin, int listSize, long groupId, java.lang.String customId,
		java.lang.String searchValue, long groupBoardSeq, boolean popupYn,
		java.lang.String siteGroup);

	public int getCustomCountBoard(long divCd, long groupId,
		java.lang.String customId, java.lang.String searchValue,
		long groupBoardSeq, java.lang.String siteGroup);

	public java.lang.Object[] getBoard(long divCd, java.lang.String customId,
		long boardSeq);
}