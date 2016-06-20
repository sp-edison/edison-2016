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

package org.kisti.edison.virtuallaboratory.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author EDISON
 */
public class VirtualLabClassScienceAppFinderUtil {
	public static java.util.List<java.lang.Object[]> getVirtualLabClassScienceAppList(
		long entryId, long vocabularyId, long columnId, long classId,
		java.util.Locale locale) {
		return getFinder()
				   .getVirtualLabClassScienceAppList(entryId, vocabularyId,
			columnId, classId, locale);
	}

	public static java.util.List<java.lang.Object[]> getScienceAppList(
		long entryId, long vocabularyId, long columnId, long classId,
		java.lang.String searchField, java.util.Locale locale) {
		return getFinder()
				   .getScienceAppList(entryId, vocabularyId, columnId, classId,
			searchField, locale);
	}

	public static VirtualLabClassScienceAppFinder getFinder() {
		if (_finder == null) {
			_finder = (VirtualLabClassScienceAppFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.virtuallaboratory.service.ClpSerializer.getServletContextName(),
					VirtualLabClassScienceAppFinder.class.getName());

			ReferenceRegistry.registerReference(VirtualLabClassScienceAppFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VirtualLabClassScienceAppFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VirtualLabClassScienceAppFinderUtil.class,
			"_finder");
	}

	private static VirtualLabClassScienceAppFinder _finder;
}