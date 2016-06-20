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
 * Provides a wrapper for {@link SurveyLocalService}.
 *
 * @author EDISON
 * @see SurveyLocalService
 * @generated
 */
public class SurveyLocalServiceWrapper implements SurveyLocalService,
	ServiceWrapper<SurveyLocalService> {
	public SurveyLocalServiceWrapper(SurveyLocalService surveyLocalService) {
		_surveyLocalService = surveyLocalService;
	}

	/**
	* Adds the survey to the database. Also notifies the appropriate model listeners.
	*
	* @param survey the survey
	* @return the survey that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.Survey addSurvey(
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.addSurvey(survey);
	}

	/**
	* Creates a new survey with the primary key. Does not add the survey to the database.
	*
	* @param surveySeqNo the primary key for the new survey
	* @return the new survey
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.Survey createSurvey(
		long surveySeqNo) {
		return _surveyLocalService.createSurvey(surveySeqNo);
	}

	/**
	* Deletes the survey with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveySeqNo the primary key of the survey
	* @return the survey that was removed
	* @throws PortalException if a survey with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.Survey deleteSurvey(
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.deleteSurvey(surveySeqNo);
	}

	/**
	* Deletes the survey from the database. Also notifies the appropriate model listeners.
	*
	* @param survey the survey
	* @return the survey that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.Survey deleteSurvey(
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.deleteSurvey(survey);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _surveyLocalService.dynamicQuery();
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
		return _surveyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _surveyLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _surveyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _surveyLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.Survey fetchSurvey(
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.fetchSurvey(surveySeqNo);
	}

	/**
	* Returns the survey with the primary key.
	*
	* @param surveySeqNo the primary key of the survey
	* @return the survey
	* @throws PortalException if a survey with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.Survey getSurvey(
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getSurvey(surveySeqNo);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the surveies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of surveies
	* @param end the upper bound of the range of surveies (not inclusive)
	* @return the range of surveies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getSurveies(start, end);
	}

	/**
	* Returns the number of surveies.
	*
	* @return the number of surveies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getSurveiesCount();
	}

	/**
	* Updates the survey in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param survey the survey
	* @return the survey that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.virtuallaboratory.model.Survey updateSurvey(
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.updateSurvey(survey);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabSurvey(long virtualLabId, long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.addVirtualLabSurvey(virtualLabId, surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabSurvey(long virtualLabId,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.addVirtualLabSurvey(virtualLabId, survey);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabSurveies(long virtualLabId, long[] surveySeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.addVirtualLabSurveies(virtualLabId, surveySeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addVirtualLabSurveies(long virtualLabId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> Surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.addVirtualLabSurveies(virtualLabId, Surveies);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearVirtualLabSurveies(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.clearVirtualLabSurveies(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabSurvey(long virtualLabId, long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.deleteVirtualLabSurvey(virtualLabId, surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabSurvey(long virtualLabId,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.deleteVirtualLabSurvey(virtualLabId, survey);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabSurveies(long virtualLabId, long[] surveySeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.deleteVirtualLabSurveies(virtualLabId, surveySeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteVirtualLabSurveies(long virtualLabId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> Surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.deleteVirtualLabSurveies(virtualLabId, Surveies);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getVirtualLabSurveies(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getVirtualLabSurveies(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getVirtualLabSurveies(
		long virtualLabId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getVirtualLabSurveies(virtualLabId, start,
			end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getVirtualLabSurveies(
		long virtualLabId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getVirtualLabSurveies(virtualLabId, start,
			end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVirtualLabSurveiesCount(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getVirtualLabSurveiesCount(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabSurvey(long virtualLabId, long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.hasVirtualLabSurvey(virtualLabId, surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasVirtualLabSurveies(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.hasVirtualLabSurveies(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setVirtualLabSurveies(long virtualLabId, long[] surveySeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.setVirtualLabSurveies(virtualLabId, surveySeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyQuestionSurvey(long questionSeqNo, long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.addSurveyQuestionSurvey(questionSeqNo, surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyQuestionSurvey(long questionSeqNo,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.addSurveyQuestionSurvey(questionSeqNo, survey);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyQuestionSurveies(long questionSeqNo,
		long[] surveySeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.addSurveyQuestionSurveies(questionSeqNo,
			surveySeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addSurveyQuestionSurveies(long questionSeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> Surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.addSurveyQuestionSurveies(questionSeqNo, Surveies);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearSurveyQuestionSurveies(long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.clearSurveyQuestionSurveies(questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyQuestionSurvey(long questionSeqNo, long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.deleteSurveyQuestionSurvey(questionSeqNo,
			surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyQuestionSurvey(long questionSeqNo,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.deleteSurveyQuestionSurvey(questionSeqNo, survey);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyQuestionSurveies(long questionSeqNo,
		long[] surveySeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.deleteSurveyQuestionSurveies(questionSeqNo,
			surveySeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteSurveyQuestionSurveies(long questionSeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> Surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.deleteSurveyQuestionSurveies(questionSeqNo, Surveies);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveyQuestionSurveies(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getSurveyQuestionSurveies(questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveyQuestionSurveies(
		long questionSeqNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getSurveyQuestionSurveies(questionSeqNo,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveyQuestionSurveies(
		long questionSeqNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getSurveyQuestionSurveies(questionSeqNo,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSurveyQuestionSurveiesCount(long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getSurveyQuestionSurveiesCount(questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasSurveyQuestionSurvey(long questionSeqNo, long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.hasSurveyQuestionSurvey(questionSeqNo,
			surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasSurveyQuestionSurveies(long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.hasSurveyQuestionSurveies(questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setSurveyQuestionSurveies(long questionSeqNo,
		long[] surveySeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.setSurveyQuestionSurveies(questionSeqNo,
			surveySeqNos);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _surveyLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_surveyLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _surveyLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListSurvey(
		java.util.Map<java.lang.String, java.lang.String> params,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getListSurvey(params, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListSurveyAll(
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getListSurveyAll(locale);
	}

	@Override
	public int getCountSurvey()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getCountSurvey();
	}

	@Override
	public int isExistsUseDate(java.lang.String surveyDivCd, long surveySeqNo,
		java.lang.String startDate, java.lang.String endDate) {
		return _surveyLocalService.isExistsUseDate(surveyDivCd, surveySeqNo,
			startDate, endDate);
	}

	@Override
	public org.kisti.edison.virtuallaboratory.model.Survey insertSurvey(
		java.util.Map<java.lang.String, java.lang.String> params,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.insertSurvey(params, locale);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.Object> getSurveyInfomation(
		long surveySeqNo, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getSurveyInfomation(surveySeqNo, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyMappingCheckList(
		long virtualLabId, boolean checkDate, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getSurveyMappingCheckList(virtualLabId,
			checkDate, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyMappingList(
		long virtualLabId, boolean checkDate, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getSurveyMappingList(virtualLabId,
			checkDate, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyMappingVoteList(
		long virtualLabId, long classId, long userId, boolean checkDate,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getSurveyMappingVoteList(virtualLabId,
			classId, userId, checkDate, locale);
	}

	@Override
	public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyResultList(
		long groupId, long surveySeqNo, java.lang.String searchField,
		int begin, int end, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getSurveyResultList(groupId, surveySeqNo,
			searchField, begin, end, locale);
	}

	@Override
	public int getCountSurveyResultList(long groupId, long surveySeqNo,
		java.lang.String searchField, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getCountSurveyResultList(groupId,
			surveySeqNo, searchField, locale);
	}

	@Override
	public int getCountSurveyCheck(long surveySeqNo, long userId, long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getCountSurveyCheck(surveySeqNo, userId,
			classId);
	}

	@Override
	public void deleteVirtualLabSurvey(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_surveyLocalService.deleteVirtualLabSurvey(virtualLabId);
	}

	@Override
	public long getMaxQuestionSeq(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _surveyLocalService.getMaxQuestionSeq(virtualLabId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SurveyLocalService getWrappedSurveyLocalService() {
		return _surveyLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSurveyLocalService(
		SurveyLocalService surveyLocalService) {
		_surveyLocalService = surveyLocalService;
	}

	@Override
	public SurveyLocalService getWrappedService() {
		return _surveyLocalService;
	}

	@Override
	public void setWrappedService(SurveyLocalService surveyLocalService) {
		_surveyLocalService = surveyLocalService;
	}

	private SurveyLocalService _surveyLocalService;
}