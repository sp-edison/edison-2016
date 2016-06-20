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

/**
 * @author EDISON
 */
public interface UserGroupRoleCustomFinder {
	public java.lang.Long getClassVirtualLabId(long classId);

	public java.lang.Object[] getSiteLeaveOwnerTotalCnt(long userId,
		long labRoleId, long groupId, long classRoleId);

	public java.util.List<java.lang.Object[]> getContentOwnerList(long userId,
		long roleId, long groupId, java.lang.String languageId);

	public java.util.List<java.lang.Object[]> getVirtualLabOwnerList(
		long userId, long roleId, long groupId, java.lang.String languageId);

	public java.util.List<java.lang.Object[]> getVirtaulClassOwnerList(
		long userId, long roleId, long groupId, java.lang.String languageId);
}