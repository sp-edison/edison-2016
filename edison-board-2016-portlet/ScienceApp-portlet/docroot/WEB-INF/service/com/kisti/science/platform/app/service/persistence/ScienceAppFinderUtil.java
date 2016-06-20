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

package com.kisti.science.platform.app.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Jerry H. Seo & Young Suh
 */
public class ScienceAppFinderUtil {
	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsOnNameTitleScreenNameAffiliationName(searchTerm,
			start, end);
	}

	public static int countScienceAppsOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm) {
		return getFinder()
				   .countScienceAppsOnNameTitleScreenNameAffiliationName(searchTerm);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm) {
		return getFinder()
				   .retrieveScienceAppsOnNameTitleScreenNameAffiliationName(searchTerm);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(searchTerm,
			stage, start, end);
	}

	public static int countScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		return getFinder()
				   .countScienceAppsOnNameTitleScreenNameAffiliationNameByStage(searchTerm,
			stage);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		return getFinder()
				   .retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(searchTerm,
			stage);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang, int start,
		int end) {
		return getFinder()
				   .retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(searchTerm,
			targetLang, start, end);
	}

	public static int countScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		return getFinder()
				   .countScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(searchTerm,
			targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		return getFinder()
				   .retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(searchTerm,
			targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(searchTerm,
			stage, targetLang, start, end);
	}

	public static int countScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		return getFinder()
				   .countScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(searchTerm,
			stage, targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		return getFinder()
				   .retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(searchTerm,
			stage, targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenName(
		java.lang.String searchTerm, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsOnScreenName(searchTerm, start, end);
	}

	public static int countScienceAppsOnScreenName(java.lang.String searchTerm) {
		return getFinder().countScienceAppsOnScreenName(searchTerm);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenName(
		java.lang.String searchTerm) {
		return getFinder().retrieveScienceAppsOnScreenName(searchTerm);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStage(
		java.lang.String searchTerm, java.lang.String stage, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsOnScreenNameByStage(searchTerm, stage,
			start, end);
	}

	public static int countScienceAppsOnScreenNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		return getFinder().countScienceAppsOnScreenNameByStage(searchTerm, stage);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		return getFinder()
				   .retrieveScienceAppsOnScreenNameByStage(searchTerm, stage);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang, int start,
		int end) {
		return getFinder()
				   .retrieveScienceAppsOnScreenNameByTarget(searchTerm,
			targetLang, start, end);
	}

	public static int countScienceAppsOnScreenNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		return getFinder()
				   .countScienceAppsOnScreenNameByTarget(searchTerm, targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		return getFinder()
				   .retrieveScienceAppsOnScreenNameByTarget(searchTerm,
			targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsOnScreenNameByStageTarget(searchTerm,
			stage, targetLang, start, end);
	}

	public static int countScienceAppsOnScreenNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		return getFinder()
				   .countScienceAppsOnScreenNameByStageTarget(searchTerm,
			stage, targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		return getFinder()
				   .retrieveScienceAppsOnScreenNameByStageTarget(searchTerm,
			stage, targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationName(
		java.lang.String searchTerm, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsOnAffiliationName(searchTerm, start, end);
	}

	public static int countScienceAppsOnAffiliationName(
		java.lang.String searchTerm) {
		return getFinder().countScienceAppsOnAffiliationName(searchTerm);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationName(
		java.lang.String searchTerm) {
		return getFinder().retrieveScienceAppsOnAffiliationName(searchTerm);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsOnAffiliationNameByStage(searchTerm,
			stage, start, end);
	}

	public static int countScienceAppsOnAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		return getFinder()
				   .countScienceAppsOnAffiliationNameByStage(searchTerm, stage);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage) {
		return getFinder()
				   .retrieveScienceAppsOnAffiliationNameByStage(searchTerm,
			stage);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang, int start,
		int end) {
		return getFinder()
				   .retrieveScienceAppsOnAffiliationNameByTarget(searchTerm,
			targetLang, start, end);
	}

	public static int countScienceAppsOnAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		return getFinder()
				   .countScienceAppsOnAffiliationNameByTarget(searchTerm,
			targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang) {
		return getFinder()
				   .retrieveScienceAppsOnAffiliationNameByTarget(searchTerm,
			targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsOnAffiliationNameByStageTarget(searchTerm,
			stage, targetLang, start, end);
	}

	public static int countScienceAppsOnAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		return getFinder()
				   .countScienceAppsOnAffiliationNameByStageTarget(searchTerm,
			stage, targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang) {
		return getFinder()
				   .retrieveScienceAppsOnAffiliationNameByStageTarget(searchTerm,
			stage, targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyId(
		long vocabularyId, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsByVocabularyId(vocabularyId, start, end);
	}

	public static int countScienceAppsByVocabularyId(long vocabularyId) {
		return getFinder().countScienceAppsByVocabularyId(vocabularyId);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyId(
		long vocabularyId) {
		return getFinder().retrieveScienceAppsByVocabularyId(vocabularyId);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStage(
		long vocabularyId, java.lang.String stage, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsByVocabularyIdStage(vocabularyId, stage,
			start, end);
	}

	public static int countScienceAppsByVocabularyIdStage(long vocabularyId,
		java.lang.String stage) {
		return getFinder()
				   .countScienceAppsByVocabularyIdStage(vocabularyId, stage);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStage(
		long vocabularyId, java.lang.String stage) {
		return getFinder()
				   .retrieveScienceAppsByVocabularyIdStage(vocabularyId, stage);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdTarget(
		long vocabularyId, java.lang.String targetLang, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsByVocabularyIdTarget(vocabularyId,
			targetLang, start, end);
	}

	public static int countScienceAppsByVocabularyIdTarget(long vocabularyId,
		java.lang.String targetLang) {
		return getFinder()
				   .countScienceAppsByVocabularyIdTarget(vocabularyId,
			targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdTarget(
		long vocabularyId, java.lang.String targetLang) {
		return getFinder()
				   .retrieveScienceAppsByVocabularyIdTarget(vocabularyId,
			targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStageTarget(
		long vocabularyId, java.lang.String stage, java.lang.String targetLang,
		int start, int end) {
		return getFinder()
				   .retrieveScienceAppsByVocabularyIdStageTarget(vocabularyId,
			stage, targetLang, start, end);
	}

	public static int countScienceAppsByVocabularyIdStageTarget(
		long vocabularyId, java.lang.String stage, java.lang.String targetLang) {
		return getFinder()
				   .countScienceAppsByVocabularyIdStageTarget(vocabularyId,
			stage, targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStageTarget(
		long vocabularyId, java.lang.String stage, java.lang.String targetLang) {
		return getFinder()
				   .retrieveScienceAppsByVocabularyIdStageTarget(vocabularyId,
			stage, targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryId(
		long categoryId, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsByCategoryId(categoryId, start, end);
	}

	public static int countScienceAppsByCategoryId(long categoryId) {
		return getFinder().countScienceAppsByCategoryId(categoryId);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryId(
		long categoryId) {
		return getFinder().retrieveScienceAppsByCategoryId(categoryId);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStage(
		long categoryId, java.lang.String stage, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsByCategoryIdStage(categoryId, stage,
			start, end);
	}

	public static int countScienceAppsByCategoryIdStage(long categoryId,
		java.lang.String stage) {
		return getFinder().countScienceAppsByCategoryIdStage(categoryId, stage);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStage(
		long categoryId, java.lang.String stage) {
		return getFinder()
				   .retrieveScienceAppsByCategoryIdStage(categoryId, stage);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdTarget(
		long categoryId, java.lang.String targetLang, int start, int end) {
		return getFinder()
				   .retrieveScienceAppsByCategoryIdTarget(categoryId,
			targetLang, start, end);
	}

	public static int countScienceAppsByCategoryIdTarget(long categoryId,
		java.lang.String targetLang) {
		return getFinder()
				   .countScienceAppsByCategoryIdTarget(categoryId, targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdTarget(
		long categoryId, java.lang.String targetLang) {
		return getFinder()
				   .retrieveScienceAppsByCategoryIdTarget(categoryId, targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStageTarget(
		long categoryId, java.lang.String stage, java.lang.String targetLang,
		int start, int end) {
		return getFinder()
				   .retrieveScienceAppsByCategoryIdStageTarget(categoryId,
			stage, targetLang, start, end);
	}

	public static int countScienceAppsByCategoryIdStageTarget(long categoryId,
		java.lang.String stage, java.lang.String targetLang) {
		return getFinder()
				   .countScienceAppsByCategoryIdStageTarget(categoryId, stage,
			targetLang);
	}

	public static java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStageTarget(
		long categoryId, java.lang.String stage, java.lang.String targetLang) {
		return getFinder()
				   .retrieveScienceAppsByCategoryIdStageTarget(categoryId,
			stage, targetLang);
	}

	public static ScienceAppFinder getFinder() {
		if (_finder == null) {
			_finder = (ScienceAppFinder)PortletBeanLocatorUtil.locate(com.kisti.science.platform.app.service.ClpSerializer.getServletContextName(),
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