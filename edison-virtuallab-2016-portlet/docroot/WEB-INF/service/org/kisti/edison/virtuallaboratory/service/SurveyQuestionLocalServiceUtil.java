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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SurveyQuestion. This utility wraps
 * {@link org.kisti.edison.virtuallaboratory.service.impl.SurveyQuestionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see SurveyQuestionLocalService
 * @see org.kisti.edison.virtuallaboratory.service.base.SurveyQuestionLocalServiceBaseImpl
 * @see org.kisti.edison.virtuallaboratory.service.impl.SurveyQuestionLocalServiceImpl
 * @generated
 */
public class SurveyQuestionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.virtuallaboratory.service.impl.SurveyQuestionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the survey question to the database. Also notifies the appropriate model listeners.
	*
	* @param surveyQuestion the survey question
	* @return the survey question that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyQuestion addSurveyQuestion(
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSurveyQuestion(surveyQuestion);
	}

	/**
	* Creates a new survey question with the primary key. Does not add the survey question to the database.
	*
	* @param questionSeqNo the primary key for the new survey question
	* @return the new survey question
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyQuestion createSurveyQuestion(
		long questionSeqNo) {
		return getService().createSurveyQuestion(questionSeqNo);
	}

	/**
	* Deletes the survey question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionSeqNo the primary key of the survey question
	* @return the survey question that was removed
	* @throws PortalException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyQuestion deleteSurveyQuestion(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSurveyQuestion(questionSeqNo);
	}

	/**
	* Deletes the survey question from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyQuestion the survey question
	* @return the survey question that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyQuestion deleteSurveyQuestion(
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSurveyQuestion(surveyQuestion);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.kisti.edison.virtuallaboratory.model.SurveyQuestion fetchSurveyQuestion(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSurveyQuestion(questionSeqNo);
	}

	/**
	* Returns the survey question with the primary key.
	*
	* @param questionSeqNo the primary key of the survey question
	* @return the survey question
	* @throws PortalException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyQuestion getSurveyQuestion(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyQuestion(questionSeqNo);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyQuestions(start, end);
	}

	/**
	* Returns the number of survey questions.
	*
	* @return the number of survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static int getSurveyQuestionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyQuestionsCount();
	}

	/**
	* Updates the survey question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param surveyQuestion the survey question
	* @return the survey question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyQuestion updateSurveyQuestion(
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSurveyQuestion(surveyQuestion);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveySurveyQuestion(long surveySeqNo,
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addSurveySurveyQuestion(surveySeqNo, questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveySurveyQuestion(long surveySeqNo,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addSurveySurveyQuestion(surveySeqNo, surveyQuestion);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveySurveyQuestions(long surveySeqNo,
		long[] questionSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addSurveySurveyQuestions(surveySeqNo, questionSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveySurveyQuestions(long surveySeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> SurveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addSurveySurveyQuestions(surveySeqNo, SurveyQuestions);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearSurveySurveyQuestions(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearSurveySurveyQuestions(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveySurveyQuestion(long surveySeqNo,
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSurveySurveyQuestion(surveySeqNo, questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveySurveyQuestion(long surveySeqNo,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSurveySurveyQuestion(surveySeqNo, surveyQuestion);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveySurveyQuestions(long surveySeqNo,
		long[] questionSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSurveySurveyQuestions(surveySeqNo, questionSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveySurveyQuestions(long surveySeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> SurveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSurveySurveyQuestions(surveySeqNo, SurveyQuestions);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveySurveyQuestions(
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveySurveyQuestions(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveySurveyQuestions(
		long surveySeqNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveySurveyQuestions(surveySeqNo, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveySurveyQuestions(
		long surveySeqNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSurveySurveyQuestions(surveySeqNo, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getSurveySurveyQuestionsCount(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveySurveyQuestionsCount(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasSurveySurveyQuestion(long surveySeqNo,
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasSurveySurveyQuestion(surveySeqNo, questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasSurveySurveyQuestions(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasSurveySurveyQuestions(surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setSurveySurveyQuestions(long surveySeqNo,
		long[] questionSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setSurveySurveyQuestions(surveySeqNo, questionSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyAnswerSurveyQuestion(long SurveyAnswerId,
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addSurveyAnswerSurveyQuestion(SurveyAnswerId, questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyAnswerSurveyQuestion(long SurveyAnswerId,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addSurveyAnswerSurveyQuestion(SurveyAnswerId, surveyQuestion);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyAnswerSurveyQuestions(long SurveyAnswerId,
		long[] questionSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addSurveyAnswerSurveyQuestions(SurveyAnswerId, questionSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyAnswerSurveyQuestions(long SurveyAnswerId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> SurveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addSurveyAnswerSurveyQuestions(SurveyAnswerId, SurveyQuestions);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearSurveyAnswerSurveyQuestions(long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearSurveyAnswerSurveyQuestions(SurveyAnswerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveyAnswerSurveyQuestion(long SurveyAnswerId,
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteSurveyAnswerSurveyQuestion(SurveyAnswerId, questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveyAnswerSurveyQuestion(long SurveyAnswerId,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteSurveyAnswerSurveyQuestion(SurveyAnswerId, surveyQuestion);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveyAnswerSurveyQuestions(long SurveyAnswerId,
		long[] questionSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteSurveyAnswerSurveyQuestions(SurveyAnswerId, questionSeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveyAnswerSurveyQuestions(long SurveyAnswerId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> SurveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteSurveyAnswerSurveyQuestions(SurveyAnswerId, SurveyQuestions);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyAnswerSurveyQuestions(
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyAnswerSurveyQuestions(SurveyAnswerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyAnswerSurveyQuestions(
		long SurveyAnswerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSurveyAnswerSurveyQuestions(SurveyAnswerId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyAnswerSurveyQuestions(
		long SurveyAnswerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSurveyAnswerSurveyQuestions(SurveyAnswerId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getSurveyAnswerSurveyQuestionsCount(long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyAnswerSurveyQuestionsCount(SurveyAnswerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasSurveyAnswerSurveyQuestion(long SurveyAnswerId,
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasSurveyAnswerSurveyQuestion(SurveyAnswerId, questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasSurveyAnswerSurveyQuestions(long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasSurveyAnswerSurveyQuestions(SurveyAnswerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setSurveyAnswerSurveyQuestions(long SurveyAnswerId,
		long[] questionSeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.setSurveyAnswerSurveyQuestions(SurveyAnswerId, questionSeqNos);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static org.kisti.edison.virtuallaboratory.model.SurveyQuestion insertSurveyQuestion(
		java.util.Map params, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().insertSurveyQuestion(params, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyQuestionInfomation(
		long surveySeqNo, java.util.Locale locale) {
		return getService().getSurveyQuestionInfomation(surveySeqNo, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyQuestionResult(
		long surveySeqNo, long virtualLabId, long classId, long groupId,
		java.util.Locale locale) {
		return getService()
				   .getSurveyQuestionResult(surveySeqNo, virtualLabId, classId,
			groupId, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyQuestionSubject(
		long surveySeqNo, long virtualLabId, long classId,
		java.lang.String questionDivCd, long questionSeqNo, long groupId) {
		return getService()
				   .getSurveyQuestionSubject(surveySeqNo, virtualLabId,
			classId, questionDivCd, questionSeqNo, groupId);
	}

	public static void deleteSurveyQuestionList(long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSurveyQuestionList(surveySeqNo);
	}

	public static java.util.List<java.lang.Long> getQuestionSeqList(
		long surveySeqNo) {
		return getService().getQuestionSeqList(surveySeqNo);
	}

	public static void clearService() {
		_service = null;
	}

	public static SurveyQuestionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SurveyQuestionLocalService.class.getName());

			if (invokableLocalService instanceof SurveyQuestionLocalService) {
				_service = (SurveyQuestionLocalService)invokableLocalService;
			}
			else {
				_service = new SurveyQuestionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SurveyQuestionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SurveyQuestionLocalService service) {
	}

	private static SurveyQuestionLocalService _service;
}