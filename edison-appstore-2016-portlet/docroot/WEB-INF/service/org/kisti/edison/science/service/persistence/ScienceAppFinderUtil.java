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
public class ScienceAppFinderUtil {
	public static java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveScienceAppOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm, int start, int end) {
		return getFinder()
				   .retrieveScienceAppOnNameTitleScreenNameAffiliationName(searchTerm,
			start, end);
	}

	public static int countScienceAppOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm) {
		return getFinder()
				   .countScienceAppOnNameTitleScreenNameAffiliationName(searchTerm);
	}

	public static java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveAllScienceAppOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm) {
		return getFinder()
				   .retrieveAllScienceAppOnNameTitleScreenNameAffiliationName(searchTerm);
	}

	public static java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveScienceAppOnScreenName(
		java.lang.String searchTerm, int start, int end) {
		return getFinder().retrieveScienceAppOnScreenName(searchTerm, start, end);
	}

	public static int countScienceAppOnScreenName(java.lang.String searchTerm) {
		return getFinder().countScienceAppOnScreenName(searchTerm);
	}

	public static java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveAllScienceAppOnScreenName(
		java.lang.String searchTerm) {
		return getFinder().retrieveAllScienceAppOnScreenName(searchTerm);
	}

	public static java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveScienceAppOnAffiliationName(
		java.lang.String searchTerm, int start, int end) {
		return getFinder()
				   .retrieveScienceAppOnAffiliationName(searchTerm, start, end);
	}

	public static int countScienceAppOnAffiliationName(
		java.lang.String searchTerm) {
		return getFinder().countScienceAppOnAffiliationName(searchTerm);
	}

	public static java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveAllScienceAppOnAffiliationName(
		java.lang.String searchTerm) {
		return getFinder().retrieveAllScienceAppOnAffiliationName(searchTerm);
	}

	public static java.util.List<java.lang.Object[]> getFavoriteAppList(
		long entryId, long vocabularyId, long columnId, long userId,
		java.util.Locale locale) {
		return getFinder()
				   .getFavoriteAppList(entryId, vocabularyId, columnId, userId,
			locale);
	}

	public static int countScienceApp(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().countScienceApp(searchParam);
	}

	public static java.util.List<org.kisti.edison.science.model.ScienceApp> retrieveListScienceEditorApp(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().retrieveListScienceEditorApp(searchParam);
	}

	public static java.util.List<java.lang.Object[]> retrieveListScienceApp(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().retrieveListScienceApp(searchParam);
	}

	public static java.util.List<java.lang.Object[]> getScienceAppExeSts(
		java.lang.String scienceAppId, long groupId) {
		return getFinder().getScienceAppExeSts(scienceAppId, groupId);
	}

	public static java.util.List<java.lang.Object[]> getMyAppListWithQna(
		java.util.Map<java.lang.String, java.lang.Object> params) {
		return getFinder().getMyAppListWithQna(params);
	}

	public static java.util.List<java.lang.Object[]> getListMyAppQna(
		java.util.Map<java.lang.String, java.lang.Object> params) {
		return getFinder().getListMyAppQna(params);
	}

	public static java.util.List<org.kisti.edison.science.model.ScienceApp> getMyAppListForProject(
		java.util.Map<java.lang.String, java.lang.Object> params) {
		return getFinder().getMyAppListForProject(params);
	}

	public static java.util.Map<java.lang.Long, java.lang.Long> getLanguageSpecificCategories(
		java.util.Map<java.lang.String, java.lang.Object> params) {
		return getFinder().getLanguageSpecificCategories(params);
	}

	public static int getMyAppListForProjectCount(java.util.Map params,
		java.util.Locale locale) {
		return getFinder().getMyAppListForProjectCount(params, locale);
	}

	public static java.util.List<java.lang.Object[]> retrieveListAppTest(
		java.util.Map<java.lang.String, java.lang.Object> params) {
		return getFinder().retrieveListAppTest(params);
	}

	public static int countAppTest(
		java.util.Map<java.lang.String, java.lang.Object> params) {
		return getFinder().countAppTest(params);
	}

	public static ScienceAppFinder getFinder() {
		if (_finder == null) {
			_finder = (ScienceAppFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.science.service.ClpSerializer.getServletContextName(),
					ScienceAppFinder.class.getName());

			ReferenceRegistry.registerReference(ScienceAppFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ScienceAppFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ScienceAppFinderUtil.class,
			"_finder");
	}

	private static ScienceAppFinder _finder;
}