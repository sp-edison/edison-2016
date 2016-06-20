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
public class PortTypeAnalyzerLinkFinderUtil {
	public static java.util.List<java.lang.Object[]> retrieveListPortTypeAnalyzerLinkWithAppName(
		long companyId, long portTypeId) {
		return getFinder()
				   .retrieveListPortTypeAnalyzerLinkWithAppName(companyId,
			portTypeId);
	}

	public static PortTypeAnalyzerLinkFinder getFinder() {
		if (_finder == null) {
			_finder = (PortTypeAnalyzerLinkFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.science.service.ClpSerializer.getServletContextName(),
					PortTypeAnalyzerLinkFinder.class.getName());

			ReferenceRegistry.registerReference(PortTypeAnalyzerLinkFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(PortTypeAnalyzerLinkFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PortTypeAnalyzerLinkFinderUtil.class,
			"_finder");
	}

	private static PortTypeAnalyzerLinkFinder _finder;
}