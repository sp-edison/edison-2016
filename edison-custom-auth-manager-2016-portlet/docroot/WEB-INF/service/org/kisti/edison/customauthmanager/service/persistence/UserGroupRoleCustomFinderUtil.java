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

package org.kisti.edison.customauthmanager.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author EDISON
 */
public class UserGroupRoleCustomFinderUtil {
	public static java.lang.Long getClassVirtualLabId(long classId) {
		return getFinder().getClassVirtualLabId(classId);
	}

	public static java.lang.Object[] getSiteLeaveOwnerTotalCnt(long userId,
		long labRoleId, long groupId, long classRoleId) {
		return getFinder()
				   .getSiteLeaveOwnerTotalCnt(userId, labRoleId, groupId,
			classRoleId);
	}

	public static java.util.List<java.lang.Object[]> getContentOwnerList(
		long userId, long roleId, long groupId, java.lang.String languageId) {
		return getFinder()
				   .getContentOwnerList(userId, roleId, groupId, languageId);
	}

	public static java.util.List<java.lang.Object[]> getVirtualLabOwnerList(
		long userId, long roleId, long groupId, java.lang.String languageId) {
		return getFinder()
				   .getVirtualLabOwnerList(userId, roleId, groupId, languageId);
	}

	public static java.util.List<java.lang.Object[]> getVirtaulClassOwnerList(
		long userId, long roleId, long groupId, java.lang.String languageId) {
		return getFinder()
				   .getVirtaulClassOwnerList(userId, roleId, groupId, languageId);
	}

	public static UserGroupRoleCustomFinder getFinder() {
		if (_finder == null) {
			_finder = (UserGroupRoleCustomFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.customauthmanager.service.ClpSerializer.getServletContextName(),
					UserGroupRoleCustomFinder.class.getName());

			ReferenceRegistry.registerReference(UserGroupRoleCustomFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(UserGroupRoleCustomFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(UserGroupRoleCustomFinderUtil.class,
			"_finder");
	}

	private static UserGroupRoleCustomFinder _finder;
}