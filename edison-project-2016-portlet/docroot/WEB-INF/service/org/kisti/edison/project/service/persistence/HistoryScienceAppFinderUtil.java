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

package org.kisti.edison.project.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author EDISON
 */
public class HistoryScienceAppFinderUtil {
	public static java.util.List<java.lang.Object[]> getMajorAchievementsList(
		java.lang.String projectYn, java.lang.String key) {
		return getFinder().getMajorAchievementsList(projectYn, key);
	}

	public static java.util.List<java.lang.Object[]> getScienceAppCenterList(
		java.lang.String propertyKey) {
		return getFinder().getScienceAppCenterList(propertyKey);
	}

	public static java.util.List<java.lang.Object[]> getAppDetailList(
		long jobPhase, long columnId, long categoryId,
		java.lang.String languageId) {
		return getFinder()
				   .getAppDetailList(jobPhase, columnId, categoryId, languageId);
	}

	public static HistoryScienceAppFinder getFinder() {
		if (_finder == null) {
			_finder = (HistoryScienceAppFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.project.service.ClpSerializer.getServletContextName(),
					HistoryScienceAppFinder.class.getName());

			ReferenceRegistry.registerReference(HistoryScienceAppFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(HistoryScienceAppFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(HistoryScienceAppFinderUtil.class,
			"_finder");
	}

	private static HistoryScienceAppFinder _finder;
}