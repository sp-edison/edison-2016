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
public class VirtualLabClassFinderUtil {
	public static java.lang.Object[] getVirtualClassInfo(long classId) {
		return getFinder().getVirtualClassInfo(classId);
	}

	public static java.util.List<java.lang.Object[]> getVirtualClassList(
		java.util.Map params) {
		return getFinder().getVirtualClassList(params);
	}

	public static int getVirtualClassListCount(java.util.Map params) {
		return getFinder().getVirtualClassListCount(params);
	}

	public static java.util.List<java.lang.Long> getVirtualClassBoardSeqList(
		long groupId, long classId) {
		return getFinder().getVirtualClassBoardSeqList(groupId, classId);
	}

	public static java.util.List<java.lang.Object[]> getVirtualClassStatisticsList(
		java.util.Map params, java.util.Locale locale) {
		return getFinder().getVirtualClassStatisticsList(params, locale);
	}

	public static int getCountVirtualClassStatistics(java.util.Map params,
		java.util.Locale locale) {
		return getFinder().getCountVirtualClassStatistics(params, locale);
	}

	public static java.util.List<java.lang.Object[]> getVirtualClassStatisticsExcelList(
		java.util.Map params, java.util.Locale locale) {
		return getFinder().getVirtualClassStatisticsExcelList(params, locale);
	}

	public static VirtualLabClassFinder getFinder() {
		if (_finder == null) {
			_finder = (VirtualLabClassFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.virtuallaboratory.service.ClpSerializer.getServletContextName(),
					VirtualLabClassFinder.class.getName());

			ReferenceRegistry.registerReference(VirtualLabClassFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VirtualLabClassFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VirtualLabClassFinderUtil.class,
			"_finder");
	}

	private static VirtualLabClassFinder _finder;
}