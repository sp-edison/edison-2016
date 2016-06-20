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

package org.kisti.edison.content.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author EDISON
 */
public class GeneralContentFinderUtil {
	public static int getGeneralContentCount(long groupId, long contentDiv,
		java.lang.String searchText, java.util.Locale locale) {
		return getFinder()
				   .getGeneralContentCount(groupId, contentDiv, searchText,
			locale);
	}

	public static java.util.List<java.lang.Object[]> getGeneralContentList(
		long groupId, long contentDiv, java.lang.String searchText, int start,
		int end, java.util.Locale locale) {
		return getFinder()
				   .getGeneralContentList(groupId, contentDiv, searchText,
			start, end, locale);
	}

	public static java.lang.Object[] getGeneralContent(long groupId,
		long contentSeq, java.util.Locale locale) {
		return getFinder().getGeneralContent(groupId, contentSeq, locale);
	}

	public static java.util.List<java.lang.Object[]> getGeneralContentForProjectList(
		long userId, java.lang.String searchText,
		java.lang.String projectCategoryId, java.lang.String languageId,
		int start, int end) {
		return getFinder()
				   .getGeneralContentForProjectList(userId, searchText,
			projectCategoryId, languageId, start, end);
	}

	public static int getGeneralContentForProjectListCount(long userId,
		java.lang.String searchText, java.lang.String projectCategoryId,
		java.lang.String languageId) {
		return getFinder()
				   .getGeneralContentForProjectListCount(userId, searchText,
			projectCategoryId, languageId);
	}

	public static GeneralContentFinder getFinder() {
		if (_finder == null) {
			_finder = (GeneralContentFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.content.service.ClpSerializer.getServletContextName(),
					GeneralContentFinder.class.getName());

			ReferenceRegistry.registerReference(GeneralContentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(GeneralContentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(GeneralContentFinderUtil.class,
			"_finder");
	}

	private static GeneralContentFinder _finder;
}