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
public interface SurveyFinder {
	public java.lang.Integer isExistsUseDate(java.lang.String surveyDivCd,
		long surveySeqNo, java.lang.String startDate, java.lang.String endDate);

	public java.util.List<java.lang.Object[]> getSurveyQuestion(
		long surveySeqNo);

	public java.util.List<java.lang.Object[]> getSurveyQuestion(
		long surveySeqNo, long virtualLabId, long classId, long groupId);

	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyQuestionSubject(
		long surveySeqNo, long virtualLabId, long classId,
		java.lang.String questionDivCd, long questionSeqNo, long groupId);

	public java.util.List<java.lang.Object[]> getSurveyMappingCheckList(
		long virtualLabId, boolean checkDate);

	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveyMappingList(
		long virtualLabId, boolean checkDate);

	public java.util.List<java.lang.Object[]> getSurveyMappingVoteList(
		long virtualLabId, long classId, long userId, boolean checkDate);

	public java.util.List<java.lang.Object[]> getSurveyResultList(
		long groupId, long surveySeqNo, java.lang.String searchField,
		int begin, int end, java.util.Locale locale);

	public java.lang.Integer getCountSurveyResultList(long groupId,
		long surveySeqNo, java.lang.String searchField, java.util.Locale locale);

	public java.util.List<java.lang.Object[]> getExcelResult(long surveySeqNo,
		long virtualLabId, long classId, long groupId,
		java.lang.String languageId);

	public int getCountAnswerResult(long surveySeqNo, long virtualLabId,
		long classId);

	public int getCountSurveyCheck(long surveySeqNo, long userId, long classId);

	public java.util.List<java.lang.Long> getQuestionSeqList(long surveySeqNo);

	public java.lang.Long getMaxQuestionSeq(long virtualLabId);
}