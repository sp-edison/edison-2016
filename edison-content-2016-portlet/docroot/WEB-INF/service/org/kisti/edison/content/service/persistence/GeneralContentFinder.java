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

package org.kisti.edison.content.service.persistence;

/**
 * @author EDISON
 */
public interface GeneralContentFinder {
	public int getGeneralContentCount(long groupId, long contentDiv,
		java.lang.String searchText, java.util.Locale locale);

	public java.util.List<java.lang.Object[]> getGeneralContentList(
		long groupId, long contentDiv, java.lang.String searchText, int start,
		int end, java.util.Locale locale);

	public java.lang.Object[] getGeneralContent(long groupId, long contentSeq,
		java.util.Locale locale);

	public java.util.List<java.lang.Object[]> getGeneralContentForProjectList(
		long userId, java.lang.String searchText,
		java.lang.String projectCategoryId, java.lang.String languageId,
		int start, int end);

	public int getGeneralContentForProjectListCount(long userId,
		java.lang.String searchText, java.lang.String projectCategoryId,
		java.lang.String languageId);
}