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

/**
 * @author EDISON
 */
public interface VirtualLabClassScienceAppFinder {
	public java.util.List<java.lang.Object[]> getVirtualLabClassScienceAppList(
		long entryId, long vocabularyId, long columnId, long classId,
		java.util.Locale locale);

	public java.util.List<java.lang.Object[]> getScienceAppList(long entryId,
		long vocabularyId, long columnId, long classId,
		java.lang.String searchField, java.util.Locale locale);
}