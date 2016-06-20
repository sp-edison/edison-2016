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
public class SurveyFinderUtil {
	public static java.lang.Integer isExistsUseDate(
		java.lang.String surveyDivCd, long surveySeqNo,
		java.lang.String startDate, java.lang.String endDate) {
		return getFinder()
				   .isExistsUseDate(surveyDivCd, surveySeqNo, startDate, endDate);
	}

	public static java.util.List<java.lang.Object[]> getSurveyQuestion(
		long surveySeqNo) {
		return getFinder().getSurveyQuestion(surveySeqNo);
	}

	public static java.util.List<java.lang.Object[]> getSurveyQuestion(
		long surveySeqNo, long virtualLabId, long classId, long groupId) {
		return getFinder()
				   .getSurveyQuestion(surveySeqNo, virtualLabId, classId,
			groupId);
	}

	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyQuestionSubject(
		long surveySeqNo, long virtualLabId, long classId,
		java.lang.String questionDivCd, long questionSeqNo, long groupId) {
		return getFinder()
				   .getSurveyQuestionSubject(surveySeqNo, virtualLabId,
			classId, questionDivCd, questionSeqNo, groupId);
	}

	public static java.util.List<java.lang.Object[]> getSurveyMappingCheckList(
		long virtualLabId, boolean checkDate) {
		return getFinder().getSurveyMappingCheckList(virtualLabId, checkDate);
	}

	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveyMappingList(
		long virtualLabId, boolean checkDate) {
		return getFinder().getSurveyMappingList(virtualLabId, checkDate);
	}

	public static java.util.List<java.lang.Object[]> getSurveyMappingVoteList(
		long virtualLabId, long classId, long userId, boolean checkDate) {
		return getFinder()
				   .getSurveyMappingVoteList(virtualLabId, classId, userId,
			checkDate);
	}

	public static java.util.List<java.lang.Object[]> getSurveyResultList(
		long groupId, long surveySeqNo, java.lang.String searchField,
		int begin, int end, java.util.Locale locale) {
		return getFinder()
				   .getSurveyResultList(groupId, surveySeqNo, searchField,
			begin, end, locale);
	}

	public static java.lang.Integer getCountSurveyResultList(long groupId,
		long surveySeqNo, java.lang.String searchField, java.util.Locale locale) {
		return getFinder()
				   .getCountSurveyResultList(groupId, surveySeqNo, searchField,
			locale);
	}

	public static java.util.List<java.lang.Object[]> getExcelResult(
		long surveySeqNo, long virtualLabId, long classId, long groupId,
		java.lang.String languageId) {
		return getFinder()
				   .getExcelResult(surveySeqNo, virtualLabId, classId, groupId,
			languageId);
	}

	public static int getCountAnswerResult(long surveySeqNo, long virtualLabId,
		long classId) {
		return getFinder()
				   .getCountAnswerResult(surveySeqNo, virtualLabId, classId);
	}

	public static int getCountSurveyCheck(long surveySeqNo, long userId,
		long classId) {
		return getFinder().getCountSurveyCheck(surveySeqNo, userId, classId);
	}

	public static java.util.List<java.lang.Long> getQuestionSeqList(
		long surveySeqNo) {
		return getFinder().getQuestionSeqList(surveySeqNo);
	}

	public static java.lang.Long getMaxQuestionSeq(long virtualLabId) {
		return getFinder().getMaxQuestionSeq(virtualLabId);
	}

	public static SurveyFinder getFinder() {
		if (_finder == null) {
			_finder = (SurveyFinder)PortletBeanLocatorUtil.locate(org.kisti.edison.virtuallaboratory.service.ClpSerializer.getServletContextName(),
					SurveyFinder.class.getName());

			ReferenceRegistry.registerReference(SurveyFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SurveyFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SurveyFinderUtil.class, "_finder");
	}

	private static SurveyFinder _finder;
}