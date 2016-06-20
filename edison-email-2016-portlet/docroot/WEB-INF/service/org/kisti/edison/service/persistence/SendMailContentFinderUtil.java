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

package org.kisti.edison.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author EDISON
 */
public class SendMailContentFinderUtil {
	public static int retrieveCountSentMailContent(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().retrieveCountSentMailContent(searchParam);
	}

	public static java.util.List<java.lang.Object[]> retrieveSentMailContent(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().retrieveSentMailContent(searchParam);
	}

	public static SendMailContentFinder getFinder() {
		if (_finder == null) {
			_finder = (SendMailContentFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.service.ClpSerializer.getServletContextName(),
					SendMailContentFinder.class.getName());

			ReferenceRegistry.registerReference(SendMailContentFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SendMailContentFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SendMailContentFinderUtil.class,
			"_finder");
	}

	private static SendMailContentFinder _finder;
}