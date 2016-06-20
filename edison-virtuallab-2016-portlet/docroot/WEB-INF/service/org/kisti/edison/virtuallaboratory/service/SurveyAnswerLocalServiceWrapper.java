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
 * Provides a wrapper for {@link SurveyAnswerLocalService}.
 *
 * @author EDISON
 * @see SurveyAnswerLocalService
 * @generated
 */
public class SurveyAnswerLocalServiceWrapper implements SurveyAnswerLocalService,
	ServiceWrapper<SurveyAnswerLocalService> {
	public SurveyAnswerLocalServiceWrapper(
		SurveyAnswerLocalService surveyAnswerLocalService) {
		_surveyAnswerLocalService = surveyAnswerLocalService;
	}

	/**
	* Adds the survey answer to the database. Also notifies the appropriate model listeners.
	*
	* @param surveyAnswer the survey answer
	* @return the survey answer that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer addSurveyAnswer(
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.addSurveyAnswer(surveyAnswer);
	}

	/**
	* Creates a new survey answer with the primary key. Does not add the survey answer to the database.
	*
	* @param SurveyAnswerId the primary key for the new survey answer
	* @return the new survey answer
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer createSurveyAnswer(
		long SurveyAnswerId) {
		return _surveyAnswerLocalService.createSurveyAnswer(SurveyAnswerId);
	}

	/**
	* Deletes the survey answer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SurveyAnswerId the primary key of the survey answer
	* @return the survey answer that was removed
	* @throws PortalException if a survey answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer deleteSurveyAnswer(
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.deleteSurveyAnswer(SurveyAnswerId);
	}

	/**
	* Deletes the survey answer from the database. Also notifies the appropriate model listeners.
	*
	* @param surveyAnswer the survey answer
	* @return the survey answer that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer deleteSurveyAnswer(
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.deleteSurveyAnswer(surveyAnswer);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _surveyAnswerLocalService.dynamicQuery();
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
		return _surveyAnswerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyAnswerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyAnswerLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _surveyAnswerLocalService.dynamicQueryCount(dynamicQuery);
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
		return _surveyAnswerLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer fetchSurveyAnswer(
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.fetchSurveyAnswer(SurveyAnswerId);
	}

	/**
	* Returns the survey answer with the primary key.
	*
	* @param SurveyAnswerId the primary key of the survey answer
	* @return the survey answer
	* @throws PortalException if a survey answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer getSurveyAnswer(
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.getSurveyAnswer(SurveyAnswerId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the survey answers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey answers
	* @param end the upper bound of the range of survey answers (not inclusive)
	* @return the range of survey answers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyAnswers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.getSurveyAnswers(start, end);
	}

	/**
	* Returns the number of survey answers.
	*
	* @return the number of survey answers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyAnswersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.getSurveyAnswersCount();
	}

	/**
	* Updates the survey answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param surveyAnswer the survey answer
	* @return the survey answer that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer updateSurveyAnswer(
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.updateSurveyAnswer(surveyAnswer);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyQuestionSurveyAnswer(long questionSeqNo,
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyAnswerLocalService.addSurveyQuestionSurveyAnswer(questionSeqNo,
			SurveyAnswerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyQuestionSurveyAnswer(long questionSeqNo,
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyAnswerLocalService.addSurveyQuestionSurveyAnswer(questionSeqNo,
			surveyAnswer);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyQuestionSurveyAnswers(long questionSeqNo,
		long[] SurveyAnswerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyAnswerLocalService.addSurveyQuestionSurveyAnswers(questionSeqNo,
			SurveyAnswerIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyQuestionSurveyAnswers(long questionSeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> SurveyAnswers)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyAnswerLocalService.addSurveyQuestionSurveyAnswers(questionSeqNo,
			SurveyAnswers);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearSurveyQuestionSurveyAnswers(long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyAnswerLocalService.clearSurveyQuestionSurveyAnswers(questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyQuestionSurveyAnswer(long questionSeqNo,
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyAnswerLocalService.deleteSurveyQuestionSurveyAnswer(questionSeqNo,
			SurveyAnswerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyQuestionSurveyAnswer(long questionSeqNo,
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyAnswerLocalService.deleteSurveyQuestionSurveyAnswer(questionSeqNo,
			surveyAnswer);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyQuestionSurveyAnswers(long questionSeqNo,
		long[] SurveyAnswerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyAnswerLocalService.deleteSurveyQuestionSurveyAnswers(questionSeqNo,
			SurveyAnswerIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyQuestionSurveyAnswers(long questionSeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> SurveyAnswers)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyAnswerLocalService.deleteSurveyQuestionSurveyAnswers(questionSeqNo,
			SurveyAnswers);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyQuestionSurveyAnswers(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.getSurveyQuestionSurveyAnswers(questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyQuestionSurveyAnswers(
		long questionSeqNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.getSurveyQuestionSurveyAnswers(questionSeqNo,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyQuestionSurveyAnswers(
		long questionSeqNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.getSurveyQuestionSurveyAnswers(questionSeqNo,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyQuestionSurveyAnswersCount(long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.getSurveyQuestionSurveyAnswersCount(questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasSurveyQuestionSurveyAnswer(long questionSeqNo,
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.hasSurveyQuestionSurveyAnswer(questionSeqNo,
			SurveyAnswerId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasSurveyQuestionSurveyAnswers(long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.hasSurveyQuestionSurveyAnswers(questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setSurveyQuestionSurveyAnswers(long questionSeqNo,
		long[] SurveyAnswerIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyAnswerLocalService.setSurveyQuestionSurveyAnswers(questionSeqNo,
			SurveyAnswerIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _surveyAnswerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_surveyAnswerLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _surveyAnswerLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer insertSurveyAnswer(
		java.util.Map<java.lang.String, java.lang.String> params)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyAnswerLocalService.insertSurveyAnswer(params);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getExcelResult(
		long surveySeqNo, long virtualLabId, long classId, long groupId,
		java.lang.String languageId) {
		return _surveyAnswerLocalService.getExcelResult(surveySeqNo,
			virtualLabId, classId, groupId, languageId);
	}

	@Override
	public int getCountAnswerResult(long surveySeqNo, long virtualLabId,
		long classId) {
		return _surveyAnswerLocalService.getCountAnswerResult(surveySeqNo,
			virtualLabId, classId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SurveyAnswerLocalService getWrappedSurveyAnswerLocalService() {
		return _surveyAnswerLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSurveyAnswerLocalService(
		SurveyAnswerLocalService surveyAnswerLocalService) {
		_surveyAnswerLocalService = surveyAnswerLocalService;
	}

	@Override
	public SurveyAnswerLocalService getWrappedService() {
		return _surveyAnswerLocalService;
	}

	@Override
	public void setWrappedService(
		SurveyAnswerLocalService surveyAnswerLocalService) {
		_surveyAnswerLocalService = surveyAnswerLocalService;
	}

	private SurveyAnswerLocalService _surveyAnswerLocalService;
}