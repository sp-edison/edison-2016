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
public class CommonLibFinderUtil {
	public static int countCommonLib(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countCommonLib(searchParam);
	}

	public static java.util.List<org.kisti.edison.science.model.CommonLib> retrieveListCommonLib(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().retrieveListCommonLib(searchParam);
	}

	public static CommonLibFinder getFinder() {
		if (_finder == null) {
			_finder = (CommonLibFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.science.service.ClpSerializer.getServletContextName(),
					CommonLibFinder.class.getName());

			ReferenceRegistry.registerReference(CommonLibFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CommonLibFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CommonLibFinderUtil.class, "_finder");
	}

	private static CommonLibFinder _finder;
}