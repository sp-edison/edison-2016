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

/**
 * @author EDISON
 */
public interface DeveloperInfoFinder {
	public java.util.List<java.lang.Object[]> getListCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params);

	public int getCountCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params);

	public java.lang.Object[] getCustomDeveloperInfo(
		java.util.Map<java.lang.String, java.lang.Object> params);

	public java.util.List<java.lang.Object[]> getDeveloperRequestStatus(
		long groupId, long userId, java.lang.String[] requestStatus, int begin,
		int end);

	public int getCountDeveloperRequestStatus(long groupId, long userId,
		java.lang.String[] requestStatus);

	public java.lang.Object[] getCountRequestInfo(long groupId,
		java.lang.String developerStatus, java.lang.String virtualLabStatus,
		java.lang.String libRequestStatus,
		java.lang.String developerDeleteStatus);
}