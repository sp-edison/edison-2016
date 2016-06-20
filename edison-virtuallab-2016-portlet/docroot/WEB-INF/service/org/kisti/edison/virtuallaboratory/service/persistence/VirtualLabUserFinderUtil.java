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
public class VirtualLabUserFinderUtil {
	public static java.util.List<java.lang.Object[]> getVirtualClassStudentList(
		long virtualLabId, long classId, long questionSeqNo,
		java.lang.String search_parameter, long groupId) {
		return getFinder()
				   .getVirtualClassStudentList(virtualLabId, classId,
			questionSeqNo, search_parameter, groupId);
	}

	public static java.lang.Object[] getCountVirtualClassRegisterUserList(
		long classId) {
		return getFinder().getCountVirtualClassRegisterUserList(classId);
	}

	public static org.kisti.edison.virtuallaboratory.model.VirtualLabUser getVirtualLabUserInfo(
		long classId, long userId) {
		return getFinder().getVirtualLabUserInfo(classId, userId);
	}

	public static int getStudentCount(long virtualLabId, long classId) {
		return getFinder().getStudentCount(virtualLabId, classId);
	}

	public static java.util.List<java.lang.Object[]> getUserGroupClassUser(
		long userId, long groupId) {
		return getFinder().getUserGroupClassUser(userId, groupId);
	}

	public static VirtualLabUserFinder getFinder() {
		if (_finder == null) {
			_finder = (VirtualLabUserFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.virtuallaboratory.service.ClpSerializer.getServletContextName(),
					VirtualLabUserFinder.class.getName());

			ReferenceRegistry.registerReference(VirtualLabUserFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(VirtualLabUserFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(VirtualLabUserFinderUtil.class,
			"_finder");
	}

	private static VirtualLabUserFinder _finder;
}