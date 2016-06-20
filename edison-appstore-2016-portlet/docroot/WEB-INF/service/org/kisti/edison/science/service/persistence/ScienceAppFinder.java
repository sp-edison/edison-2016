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
public interface ScienceAppFinder {
	public java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveScienceAppOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm, int start, int end);

	public int countScienceAppOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm);

	public java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveAllScienceAppOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm);

	public java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveScienceAppOnScreenName(
		java.lang.String searchTerm, int start, int end);

	public int countScienceAppOnScreenName(java.lang.String searchTerm);

	public java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveAllScienceAppOnScreenName(
		java.lang.String searchTerm);

	public java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveScienceAppOnAffiliationName(
		java.lang.String searchTerm, int start, int end);

	public int countScienceAppOnAffiliationName(java.lang.String searchTerm);

	public java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveAllScienceAppOnAffiliationName(
		java.lang.String searchTerm);

	public java.util.List<java.lang.Object[]> getFavoriteAppList(long entryId,
		long vocabularyId, long columnId, long userId, java.util.Locale locale);

	public int countScienceApp(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveListScienceEditorApp(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> retrieveListScienceApp(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Object[]> getScienceAppExeSts(
		java.lang.String scienceAppId, long groupId);

	public java.util.List<java.lang.Object[]> getMyAppListWithQna(
		java.util.Map<java.lang.String, java.lang.Object> params);

	public java.util.List<java.lang.Object[]> getListMyAppQna(
		java.util.Map<java.lang.String, java.lang.Object> params);

	public java.util.List<org.kisti.edison.science.model.ScienceApp> getMyAppListForProject(
		java.util.Map<java.lang.String, java.lang.Object> params);

	public java.util.Map<java.lang.Long, java.lang.Long> getLanguageSpecificCategories(
		java.util.Map<java.lang.String, java.lang.Object> params);

	public int getMyAppListForProjectCount(java.util.Map params,
		java.util.Locale locale);

	public java.util.List<java.lang.Object[]> retrieveListAppTest(
		java.util.Map<java.lang.String, java.lang.Object> params);

	public int countAppTest(
		java.util.Map<java.lang.String, java.lang.Object> params);
}