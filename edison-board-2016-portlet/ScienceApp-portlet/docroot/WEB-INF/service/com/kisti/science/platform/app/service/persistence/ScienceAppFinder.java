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

/**
 * @author Jerry H. Seo & Young Suh
 */
public interface ScienceAppFinder {
	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm, int start, int end);

	public int countScienceAppsOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationName(
		java.lang.String searchTerm);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage, int start, int end);

	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang, int start,
		int end);

	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang, int start, int end);

	public int countScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnNameTitleScreenNameAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenName(
		java.lang.String searchTerm, int start, int end);

	public int countScienceAppsOnScreenName(java.lang.String searchTerm);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenName(
		java.lang.String searchTerm);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStage(
		java.lang.String searchTerm, java.lang.String stage, int start, int end);

	public int countScienceAppsOnScreenNameByStage(
		java.lang.String searchTerm, java.lang.String stage);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStage(
		java.lang.String searchTerm, java.lang.String stage);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang, int start,
		int end);

	public int countScienceAppsOnScreenNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang, int start, int end);

	public int countScienceAppsOnScreenNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnScreenNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationName(
		java.lang.String searchTerm, int start, int end);

	public int countScienceAppsOnAffiliationName(java.lang.String searchTerm);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationName(
		java.lang.String searchTerm);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage, int start, int end);

	public int countScienceAppsOnAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStage(
		java.lang.String searchTerm, java.lang.String stage);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang, int start,
		int end);

	public int countScienceAppsOnAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByTarget(
		java.lang.String searchTerm, java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang, int start, int end);

	public int countScienceAppsOnAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsOnAffiliationNameByStageTarget(
		java.lang.String searchTerm, java.lang.String stage,
		java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyId(
		long vocabularyId, int start, int end);

	public int countScienceAppsByVocabularyId(long vocabularyId);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyId(
		long vocabularyId);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStage(
		long vocabularyId, java.lang.String stage, int start, int end);

	public int countScienceAppsByVocabularyIdStage(long vocabularyId,
		java.lang.String stage);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStage(
		long vocabularyId, java.lang.String stage);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdTarget(
		long vocabularyId, java.lang.String targetLang, int start, int end);

	public int countScienceAppsByVocabularyIdTarget(long vocabularyId,
		java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdTarget(
		long vocabularyId, java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStageTarget(
		long vocabularyId, java.lang.String stage, java.lang.String targetLang,
		int start, int end);

	public int countScienceAppsByVocabularyIdStageTarget(long vocabularyId,
		java.lang.String stage, java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByVocabularyIdStageTarget(
		long vocabularyId, java.lang.String stage, java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryId(
		long categoryId, int start, int end);

	public int countScienceAppsByCategoryId(long categoryId);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryId(
		long categoryId);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStage(
		long categoryId, java.lang.String stage, int start, int end);

	public int countScienceAppsByCategoryIdStage(long categoryId,
		java.lang.String stage);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStage(
		long categoryId, java.lang.String stage);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdTarget(
		long categoryId, java.lang.String targetLang, int start, int end);

	public int countScienceAppsByCategoryIdTarget(long categoryId,
		java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdTarget(
		long categoryId, java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStageTarget(
		long categoryId, java.lang.String stage, java.lang.String targetLang,
		int start, int end);

	public int countScienceAppsByCategoryIdStageTarget(long categoryId,
		java.lang.String stage, java.lang.String targetLang);

	public java.util.List<com.kisti.science.platform.app.model.ScienceApp> retrieveScienceAppsByCategoryIdStageTarget(
		long categoryId, java.lang.String stage, java.lang.String targetLang);
}