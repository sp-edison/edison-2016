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
public class RequiredLibFinderUtil {
	public static int getCountRequiredLib(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getCountRequiredLib(searchParam);
	}

	public static java.util.List<java.lang.Object[]> getRequiredLibList(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getRequiredLibList(searchParam);
	}

	public static java.util.List<java.lang.Object[]> getRequiredLib(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getRequiredLib(searchParam);
	}

	public static RequiredLibFinder getFinder() {
		if (_finder == null) {
			_finder = (RequiredLibFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.science.service.ClpSerializer.getServletContextName(),
					RequiredLibFinder.class.getName());

			ReferenceRegistry.registerReference(RequiredLibFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(RequiredLibFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(RequiredLibFinderUtil.class,
			"_finder");
	}

	private static RequiredLibFinder _finder;
}