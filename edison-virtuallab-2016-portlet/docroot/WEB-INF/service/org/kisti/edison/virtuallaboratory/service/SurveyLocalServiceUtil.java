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
 * Provides the local service utility for Survey. This utility wraps
 * {@link org.kisti.edison.virtuallaboratory.service.impl.SurveyLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see SurveyLocalService
 * @see org.kisti.edison.virtuallaboratory.service.base.SurveyLocalServiceBaseImpl
 * @see org.kisti.edison.virtuallaboratory.service.impl.SurveyLocalServiceImpl
 * @generated
 */
public class SurveyLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.virtuallaboratory.service.impl.SurveyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the survey to the database. Also notifies the appropriate model listeners.
	*
	* @param survey the survey
	* @return the survey that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.Survey addSurvey(
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSurvey(survey);
	}

	/**
	* Creates a new survey with the primary key. Does not add the survey to the database.
	*
	* @param surveySeqNo the primary key for the new survey
	* @return the new survey
	*/
	public static org.kisti.edison.virtuallaboratory.model.Survey createSurvey(
		long surveySeqNo) {
		return getService().createSurvey(surveySeqNo);
	}

	/**
	* Deletes the survey with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveySeqNo the primary key of the survey
	* @return the survey that was removed
	* @throws PortalException if a survey with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.Survey deleteSurvey(
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSurvey(surveySeqNo);
	}

	/**
	* Deletes the survey from the database. Also notifies the appropriate model listeners.
	*
	* @param survey the survey
	* @return the survey that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.Survey deleteSurvey(
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSurvey(survey);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static org.kisti.edison.virtuallaboratory.model.Survey fetchSurvey(
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSurvey(surveySeqNo);
	}

	/**
	* Returns the survey with the primary key.
	*
	* @param surveySeqNo the primary key of the survey
	* @return the survey
	* @throws PortalException if a survey with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.Survey getSurvey(
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurvey(surveySeqNo);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveies(start, end);
	}

	/**
	* Returns the number of surveies.
	*
	* @return the number of surveies
	* @throws SystemException if a system exception occurred
	*/
	public static int getSurveiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveiesCount();
	}

	/**
	* Updates the survey in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param survey the survey
	* @return the survey that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.Survey updateSurvey(
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSurvey(survey);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabSurvey(long virtualLabId, long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addVirtualLabSurvey(virtualLabId, surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabSurvey(long virtualLabId,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addVirtualLabSurvey(virtualLabId, survey);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabSurveies(long virtualLabId,
		long[] surveySeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addVirtualLabSurveies(virtualLabId, surveySeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addVirtualLabSurveies(long virtualLabId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> Surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addVirtualLabSurveies(virtualLabId, Surveies);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearVirtualLabSurveies(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearVirtualLabSurveies(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabSurvey(long virtualLabId,
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVirtualLabSurvey(virtualLabId, surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabSurvey(long virtualLabId,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVirtualLabSurvey(virtualLabId, survey);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabSurveies(long virtualLabId,
		long[] surveySeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVirtualLabSurveies(virtualLabId, surveySeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteVirtualLabSurveies(long virtualLabId,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> Surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVirtualLabSurveies(virtualLabId, Surveies);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getVirtualLabSurveies(
		long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabSurveies(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getVirtualLabSurveies(
		long virtualLabId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabSurveies(virtualLabId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getVirtualLabSurveies(
		long virtualLabId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getVirtualLabSurveies(virtualLabId, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getVirtualLabSurveiesCount(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getVirtualLabSurveiesCount(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasVirtualLabSurvey(long virtualLabId,
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasVirtualLabSurvey(virtualLabId, surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasVirtualLabSurveies(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasVirtualLabSurveies(virtualLabId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setVirtualLabSurveies(long virtualLabId,
		long[] surveySeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setVirtualLabSurveies(virtualLabId, surveySeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyQuestionSurvey(long questionSeqNo,
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addSurveyQuestionSurvey(questionSeqNo, surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyQuestionSurvey(long questionSeqNo,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addSurveyQuestionSurvey(questionSeqNo, survey);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyQuestionSurveies(long questionSeqNo,
		long[] surveySeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addSurveyQuestionSurveies(questionSeqNo, surveySeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyQuestionSurveies(long questionSeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> Surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addSurveyQuestionSurveies(questionSeqNo, Surveies);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearSurveyQuestionSurveies(long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearSurveyQuestionSurveies(questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveyQuestionSurvey(long questionSeqNo,
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSurveyQuestionSurvey(questionSeqNo, surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveyQuestionSurvey(long questionSeqNo,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSurveyQuestionSurvey(questionSeqNo, survey);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveyQuestionSurveies(long questionSeqNo,
		long[] surveySeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSurveyQuestionSurveies(questionSeqNo, surveySeqNos);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteSurveyQuestionSurveies(long questionSeqNo,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> Surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteSurveyQuestionSurveies(questionSeqNo, Surveies);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveyQuestionSurveies(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyQuestionSurveies(questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveyQuestionSurveies(
		long questionSeqNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyQuestionSurveies(questionSeqNo, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveyQuestionSurveies(
		long questionSeqNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSurveyQuestionSurveies(questionSeqNo, start, end,
			orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getSurveyQuestionSurveiesCount(long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyQuestionSurveiesCount(questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasSurveyQuestionSurvey(long questionSeqNo,
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasSurveyQuestionSurvey(questionSeqNo, surveySeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasSurveyQuestionSurveies(long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasSurveyQuestionSurveies(questionSeqNo);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setSurveyQuestionSurveies(long questionSeqNo,
		long[] surveySeqNos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().setSurveyQuestionSurveies(questionSeqNo, surveySeqNos);
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

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListSurvey(
		java.util.Map<java.lang.String, java.lang.String> params,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getListSurvey(params, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getListSurveyAll(
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getListSurveyAll(locale);
	}

	public static int getCountSurvey()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountSurvey();
	}

	public static int isExistsUseDate(java.lang.String surveyDivCd,
		long surveySeqNo, java.lang.String startDate, java.lang.String endDate) {
		return getService()
				   .isExistsUseDate(surveyDivCd, surveySeqNo, startDate, endDate);
	}

	public static org.kisti.edison.virtuallaboratory.model.Survey insertSurvey(
		java.util.Map<java.lang.String, java.lang.String> params,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().insertSurvey(params, locale);
	}

	public static java.util.Map<java.lang.String, java.lang.Object> getSurveyInfomation(
		long surveySeqNo, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyInfomation(surveySeqNo, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyMappingCheckList(
		long virtualLabId, boolean checkDate, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSurveyMappingCheckList(virtualLabId, checkDate, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyMappingList(
		long virtualLabId, boolean checkDate, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSurveyMappingList(virtualLabId, checkDate, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyMappingVoteList(
		long virtualLabId, long classId, long userId, boolean checkDate,
		java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSurveyMappingVoteList(virtualLabId, classId, userId,
			checkDate, locale);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getSurveyResultList(
		long groupId, long surveySeqNo, java.lang.String searchField,
		int begin, int end, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSurveyResultList(groupId, surveySeqNo, searchField,
			begin, end, locale);
	}

	public static int getCountSurveyResultList(long groupId, long surveySeqNo,
		java.lang.String searchField, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCountSurveyResultList(groupId, surveySeqNo, searchField,
			locale);
	}

	public static int getCountSurveyCheck(long surveySeqNo, long userId,
		long classId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountSurveyCheck(surveySeqNo, userId, classId);
	}

	public static void deleteVirtualLabSurvey(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteVirtualLabSurvey(virtualLabId);
	}

	public static long getMaxQuestionSeq(long virtualLabId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMaxQuestionSeq(virtualLabId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SurveyLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SurveyLocalService.class.getName());

			if (invokableLocalService instanceof SurveyLocalService) {
				_service = (SurveyLocalService)invokableLocalService;
			}
			else {
				_service = new SurveyLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SurveyLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SurveyLocalService service) {
	}

	private static SurveyLocalService _service;
}