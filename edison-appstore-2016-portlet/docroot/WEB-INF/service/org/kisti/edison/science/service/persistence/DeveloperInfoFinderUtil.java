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
public class DeveloperInfoFinderUtil {
	public static java.util.List<java.lang.Object[]> getListCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params) {
		return getFinder().getListCustomDeveloperInfo(params);
	}

	public static int getCountCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params) {
		return getFinder().getCountCustomDeveloperInfo(params);
	}

	public static java.lang.Object[] getCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params) {
		return getFinder().getCustomDeveloperInfo(params);
	}

	public static java.util.List<java.lang.Object[]> getDeveloperRequestStatus(
		long groupId, long userId, java.lang.String[] requestStatus, int begin,
		int end) {
		return getFinder()
				   .getDeveloperRequestStatus(groupId, userId, requestStatus,
			begin, end);
	}

	public static int getCountDeveloperRequestStatus(long groupId, long userId,
		java.lang.String[] requestStatus) {
		return getFinder()
				   .getCountDeveloperRequestStatus(groupId, userId,
			requestStatus);
	}

	public static java.lang.Object[] getCountRequestInfo(long groupId,
		java.lang.String developerStatus, java.lang.String virtualLabStatus,
		java.lang.String libRequestStatus,
		java.lang.String developerDeleteStatus) {
		return getFinder()
				   .getCountRequestInfo(groupId, developerStatus,
			virtualLabStatus, libRequestStatus, developerDeleteStatus);
	}

	public static DeveloperInfoFinder getFinder() {
		if (_finder == null) {
			_finder = (DeveloperInfoFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.science.service.ClpSerializer.getServletContextName(),
					DeveloperInfoFinder.class.getName());

			ReferenceRegistry.registerReference(DeveloperInfoFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(DeveloperInfoFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(DeveloperInfoFinderUtil.class,
			"_finder");
	}

	private static DeveloperInfoFinder _finder;
}