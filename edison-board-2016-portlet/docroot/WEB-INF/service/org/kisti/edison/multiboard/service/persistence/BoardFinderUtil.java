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
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author mhkang
 */
public class BoardFinderUtil {
	public static java.util.List<java.lang.Object[]> getCustomListBoard(
		long divCd, int begin, int listSize, long groupId,
		java.lang.String customId, java.lang.String searchValue,
		long groupBoardSeq, boolean popupYn, java.lang.String siteGroup) {
		return getFinder()
				   .getCustomListBoard(divCd, begin, listSize, groupId,
			customId, searchValue, groupBoardSeq, popupYn, siteGroup);
	}

	public static int getCustomCountBoard(long divCd, long groupId,
		java.lang.String customId, java.lang.String searchValue,
		long groupBoardSeq, java.lang.String siteGroup) {
		return getFinder()
				   .getCustomCountBoard(divCd, groupId, customId, searchValue,
			groupBoardSeq, siteGroup);
	}

	public static java.lang.Object[] getBoard(long divCd,
		java.lang.String customId, long boardSeq) {
		return getFinder().getBoard(divCd, customId, boardSeq);
	}

	public static BoardFinder getFinder() {
		if (_finder == null) {
			_finder = (BoardFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.multiboard.service.ClpSerializer.getServletContextName(),
					BoardFinder.class.getName());

			ReferenceRegistry.registerReference(BoardFinderUtil.class, "_finder");
		}

		return _finder;
	}

	public void setFinder(BoardFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BoardFinderUtil.class, "_finder");
	}

	private static BoardFinder _finder;
}