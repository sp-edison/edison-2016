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

package org.kisti.edison.virtuallaboratory.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SurveyQuestionLocalService}.
 *
 * @author EDISON
 * @see SurveyQuestionLocalService
 * @generated
 */
public class SurveyQuestionLocalServiceWrapper
	implements SurveyQuestionLocalService,
		ServiceWrapper<SurveyQuestionLocalService> {
	public SurveyQuestionLocalServiceWrapper(
		SurveyQuestionLocalService surveyQuestionLocalService) {
		_surveyQuestionLocalService = surveyQuestionLocalService;
	}

	/**
	* Adds the survey question to the database. Also notifies the appropriate model listeners.
	*
	* @param surveyQuestion the survey question
	* @return the survey question that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion addSurveyQuestion(
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.addSurveyQuestion(surveyQuestion);
	}

	/**
	* Creates a new survey question with the primary key. Does not add the survey question to the database.
	*
	* @param questionSeqNo the primary key for the new survey question
	* @return the new survey question
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion createSurveyQuestion(
		long questionSeqNo) {
		return _surveyQuestionLocalService.createSurveyQuestion(questionSeqNo);
	}

	/**
	* Deletes the survey question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionSeqNo the primary key of the survey question
	* @return the survey question that was removed
	* @throws PortalException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion deleteSurveyQuestion(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.deleteSurveyQuestion(questionSeqNo);
	}

	/**
	* Deletes the survey question from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyQuestion the survey question
	* @return the survey question that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion deleteSurveyQuestion(
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.deleteSurveyQuestion(surveyQuestion);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _surveyQuestionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion fetchSurveyQuestion(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.fetchSurveyQuestion(questionSeqNo);
	}

	/**
	* Returns the survey question with the primary key.
	*
	* @param questionSeqNo the primary key of the survey question
	* @return the survey question
	* @throws PortalException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion getSurveyQuestion(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveyQuestion(questionSeqNo);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the survey questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @return the range of survey questions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveyQuestions(start, end);
	}

	/**
	* Returns the number of survey questions.
	*
	* @return the number of survey questions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyQuestionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveyQuestionsCount();
	}

	/**
	* Updates the survey question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param surveyQuestion the survey question
	* @return the survey question that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion updateSurveyQuestion(
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.updateSurveyQuestion(surveyQuestion);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveySurveyQuestion(long surveySeqNo, long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.addSurveySurveyQuestion(surveySeqNo,
			questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveySurveyQuestion(long surveySeqNo,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.addSurveySurveyQuestion(surveySeqNo,
			surveyQuestion);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveySurveyQuestions(long surveySeqNo, long[] questionSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.addSurveySurveyQuestions(surveySeqNo,
			questionSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveySurveyQuestions(long surveySeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> SurveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.addSurveySurveyQuestions(surveySeqNo,
			SurveyQuestions);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearSurveySurveyQuestions(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.clearSurveySurveyQuestions(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveySurveyQuestion(long surveySeqNo, long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.deleteSurveySurveyQuestion(surveySeqNo,
			questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveySurveyQuestion(long surveySeqNo,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.deleteSurveySurveyQuestion(surveySeqNo,
			surveyQuestion);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveySurveyQuestions(long surveySeqNo,
		long[] questionSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.deleteSurveySurveyQuestions(surveySeqNo,
			questionSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveySurveyQuestions(long surveySeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> SurveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.deleteSurveySurveyQuestions(surveySeqNo,
			SurveyQuestions);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveySurveyQuestions(
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveySurveyQuestions(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveySurveyQuestions(
		long surveySeqNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveySurveyQuestions(surveySeqNo,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveySurveyQuestions(
		long surveySeqNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveySurveyQuestions(surveySeqNo,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveySurveyQuestionsCount(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveySurveyQuestionsCount(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasSurveySurveyQuestion(long surveySeqNo, long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.hasSurveySurveyQuestion(surveySeqNo,
			questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasSurveySurveyQuestions(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.hasSurveySurveyQuestions(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setSurveySurveyQuestions(long surveySeqNo, long[] questionSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.setSurveySurveyQuestions(surveySeqNo,
			questionSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyAnswerSurveyQuestion(long SurveyAnswerId,
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.addSurveyAnswerSurveyQuestion(SurveyAnswerId,
			questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyAnswerSurveyQuestion(long SurveyAnswerId,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.addSurveyAnswerSurveyQuestion(SurveyAnswerId,
			surveyQuestion);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyAnswerSurveyQuestions(long SurveyAnswerId,
		long[] questionSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.addSurveyAnswerSurveyQuestions(SurveyAnswerId,
			questionSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyAnswerSurveyQuestions(long SurveyAnswerId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> SurveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.addSurveyAnswerSurveyQuestions(SurveyAnswerId,
			SurveyQuestions);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearSurveyAnswerSurveyQuestions(long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.clearSurveyAnswerSurveyQuestions(SurveyAnswerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyAnswerSurveyQuestion(long SurveyAnswerId,
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.deleteSurveyAnswerSurveyQuestion(SurveyAnswerId,
			questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyAnswerSurveyQuestion(long SurveyAnswerId,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.deleteSurveyAnswerSurveyQuestion(SurveyAnswerId,
			surveyQuestion);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyAnswerSurveyQuestions(long SurveyAnswerId,
		long[] questionSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.deleteSurveyAnswerSurveyQuestions(SurveyAnswerId,
			questionSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyAnswerSurveyQuestions(long SurveyAnswerId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> SurveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.deleteSurveyAnswerSurveyQuestions(SurveyAnswerId,
			SurveyQuestions);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyAnswerSurveyQuestions(
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveyAnswerSurveyQuestions(SurveyAnswerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyAnswerSurveyQuestions(
		long SurveyAnswerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveyAnswerSurveyQuestions(SurveyAnswerId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyAnswerSurveyQuestions(
		long SurveyAnswerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveyAnswerSurveyQuestions(SurveyAnswerId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyAnswerSurveyQuestionsCount(long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.getSurveyAnswerSurveyQuestionsCount(SurveyAnswerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasSurveyAnswerSurveyQuestion(long SurveyAnswerId,
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.hasSurveyAnswerSurveyQuestion(SurveyAnswerId,
			questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasSurveyAnswerSurveyQuestions(long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.hasSurveyAnswerSurveyQuestions(SurveyAnswerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setSurveyAnswerSurveyQuestions(long SurveyAnswerId,
		long[] questionSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.setSurveyAnswerSurveyQuestions(SurveyAnswerId,
			questionSeqNos);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _surveyQuestionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_surveyQuestionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _surveyQuestionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion insertSurveyQuestion(
		java.util.Map params, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyQuestionLocalService.insertSurveyQuestion(params, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyQuestionInfomation(
		long surveySeqNo, java.util.Locale locale) {
		return _surveyQuestionLocalService.getSurveyQuestionInfomation(surveySeqNo,
			locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyQuestionResult(
		long surveySeqNo, long virtualLabId, long classId, long groupId,
		java.util.Locale locale) {
		return _surveyQuestionLocalService.getSurveyQuestionResult(surveySeqNo,
			virtualLabId, classId, groupId, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyQuestionSubject(
		long surveySeqNo, long virtualLabId, long classId,
		java.lang.String questionDivCd, long questionSeqNo, long groupId) {
		return _surveyQuestionLocalService.getSurveyQuestionSubject(surveySeqNo,
			virtualLabId, classId, questionDivCd, questionSeqNo, groupId);
	}

	@Override
	public void deleteSurveyQuestionList(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyQuestionLocalService.deleteSurveyQuestionList(surveySeqNo);
	}

	@Override
	public java.util.List<java.lang.Long> getQuestionSeqList(long surveySeqNo) {
		return _surveyQuestionLocalService.getQuestionSeqList(surveySeqNo);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SurveyQuestionLocalService getWrappedSurveyQuestionLocalService() {
		return _surveyQuestionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSurveyQuestionLocalService(
		SurveyQuestionLocalService surveyQuestionLocalService) {
		_surveyQuestionLocalService = surveyQuestionLocalService;
	}

	@Override
	public SurveyQuestionLocalService getWrappedService() {
		return _surveyQuestionLocalService;
	}

	@Override
	public void setWrappedService(
		SurveyQuestionLocalService surveyQuestionLocalService) {
		_surveyQuestionLocalService = surveyQuestionLocalService;
	}

	private SurveyQuestionLocalService _surveyQuestionLocalService;
}