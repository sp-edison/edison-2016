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

package org.kisti.edison.science.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author EDISON
 */
public class ScienceAppManagerFinderUtil {
	public static java.util.List<java.lang.Object[]> getScienceAppManagerList(
		long userId, long groupId) {
		return getFinder().getScienceAppManagerList(userId, groupId);
	}

	public static ScienceAppManagerFinder getFinder() {
		if (_finder == null) {
			_finder = (ScienceAppManagerFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.science.service.ClpSerializer.getServletContextName(),
					ScienceAppManagerFinder.class.getName());

			ReferenceRegistry.registerReference(ScienceAppManagerFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ScienceAppManagerFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ScienceAppManagerFinderUtil.class,
			"_finder");
	}

	private static ScienceAppManagerFinder _finder;
}