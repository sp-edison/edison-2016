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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.kisti.edison.virtuallaboratory.model.SurveyQuestion;

import java.util.List;

/**
 * The persistence utility for the survey question service. This utility wraps {@link SurveyQuestionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see SurveyQuestionPersistence
 * @see SurveyQuestionPersistenceImpl
 * @generated
 */
public class SurveyQuestionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SurveyQuestion surveyQuestion) {
		getPersistence().clearCache(surveyQuestion);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SurveyQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SurveyQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SurveyQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SurveyQuestion update(SurveyQuestion surveyQuestion)
		throws SystemException {
		return getPersistence().update(surveyQuestion);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SurveyQuestion update(SurveyQuestion surveyQuestion,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(surveyQuestion, serviceContext);
	}

	/**
	* Caches the survey question in the entity cache if it is enabled.
	*
	* @param surveyQuestion the survey question
	*/
	public static void cacheResult(
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion) {
		getPersistence().cacheResult(surveyQuestion);
	}

	/**
	* Caches the survey questions in the entity cache if it is enabled.
	*
	* @param surveyQuestions the survey questions
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions) {
		getPersistence().cacheResult(surveyQuestions);
	}

	/**
	* Creates a new survey question with the primary key. Does not add the survey question to the database.
	*
	* @param questionSeqNo the primary key for the new survey question
	* @return the new survey question
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyQuestion create(
		long questionSeqNo) {
		return getPersistence().create(questionSeqNo);
	}

	/**
	* Removes the survey question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionSeqNo the primary key of the survey question
	* @return the survey question that was removed
	* @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyQuestion remove(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException {
		return getPersistence().remove(questionSeqNo);
	}

	public static org.kisti.edison.virtuallaboratory.model.SurveyQuestion updateImpl(
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(surveyQuestion);
	}

	/**
	* Returns the survey question with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException} if it could not be found.
	*
	* @param questionSeqNo the primary key of the survey question
	* @return the survey question
	* @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyQuestion findByPrimaryKey(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException {
		return getPersistence().findByPrimaryKey(questionSeqNo);
	}

	/**
	* Returns the survey question with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionSeqNo the primary key of the survey question
	* @return the survey question, or <code>null</code> if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyQuestion fetchByPrimaryKey(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(questionSeqNo);
	}

	/**
	* Returns all the survey questions.
	*
	* @return the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the survey questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the survey questions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of survey questions.
	*
	* @return the number of survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the surveies associated with the survey question.
	*
	* @param pk the primary key of the survey question
	* @return the surveies associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveies(pk);
	}

	/**
	* Returns a range of all the surveies associated with the survey question.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the survey question
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @return the range of surveies associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveies(pk, start, end);
	}

	/**
	* Returns an ordered range of all the surveies associated with the survey question.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the survey question
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of surveies associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveies(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of surveies associated with the survey question.
	*
	* @param pk the primary key of the survey question
	* @return the number of surveies associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static int getSurveiesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveiesSize(pk);
	}

	/**
	* Returns <code>true</code> if the survey is associated with the survey question.
	*
	* @param pk the primary key of the survey question
	* @param surveyPK the primary key of the survey
	* @return <code>true</code> if the survey is associated with the survey question; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsSurvey(long pk, long surveyPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsSurvey(pk, surveyPK);
	}

	/**
	* Returns <code>true</code> if the survey question has any surveies associated with it.
	*
	* @param pk the primary key of the survey question to check for associations with surveies
	* @return <code>true</code> if the survey question has any surveies associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsSurveies(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsSurveies(pk);
	}

	/**
	* Adds an association between the survey question and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyPK the primary key of the survey
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurvey(long pk, long surveyPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurvey(pk, surveyPK);
	}

	/**
	* Adds an association between the survey question and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param survey the survey
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurvey(long pk,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurvey(pk, survey);
	}

	/**
	* Adds an association between the survey question and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyPKs the primary keys of the surveies
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveies(long pk, long[] surveyPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurveies(pk, surveyPKs);
	}

	/**
	* Adds an association between the survey question and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveies the surveies
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveies(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurveies(pk, surveies);
	}

	/**
	* Clears all associations between the survey question and its surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question to clear the associated surveies from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearSurveies(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearSurveies(pk);
	}

	/**
	* Removes the association between the survey question and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyPK the primary key of the survey
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurvey(long pk, long surveyPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurvey(pk, surveyPK);
	}

	/**
	* Removes the association between the survey question and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param survey the survey
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurvey(long pk,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurvey(pk, survey);
	}

	/**
	* Removes the association between the survey question and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyPKs the primary keys of the surveies
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurveies(long pk, long[] surveyPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurveies(pk, surveyPKs);
	}

	/**
	* Removes the association between the survey question and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveies the surveies
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurveies(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurveies(pk, surveies);
	}

	/**
	* Sets the surveies associated with the survey question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyPKs the primary keys of the surveies to be associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static void setSurveies(long pk, long[] surveyPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setSurveies(pk, surveyPKs);
	}

	/**
	* Sets the surveies associated with the survey question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveies the surveies to be associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static void setSurveies(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setSurveies(pk, surveies);
	}

	/**
	* Returns all the survey answers associated with the survey question.
	*
	* @param pk the primary key of the survey question
	* @return the survey answers associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyAnswers(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveyAnswers(pk);
	}

	/**
	* Returns a range of all the survey answers associated with the survey question.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the survey question
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @return the range of survey answers associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyAnswers(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveyAnswers(pk, start, end);
	}

	/**
	* Returns an ordered range of all the survey answers associated with the survey question.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the survey question
	* @param start the lower bound of the range of survey questions
	* @param end the upper bound of the range of survey questions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey answers associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyAnswers(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getSurveyAnswers(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of survey answers associated with the survey question.
	*
	* @param pk the primary key of the survey question
	* @return the number of survey answers associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static int getSurveyAnswersSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveyAnswersSize(pk);
	}

	/**
	* Returns <code>true</code> if the survey answer is associated with the survey question.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswerPK the primary key of the survey answer
	* @return <code>true</code> if the survey answer is associated with the survey question; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsSurveyAnswer(long pk, long surveyAnswerPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsSurveyAnswer(pk, surveyAnswerPK);
	}

	/**
	* Returns <code>true</code> if the survey question has any survey answers associated with it.
	*
	* @param pk the primary key of the survey question to check for associations with survey answers
	* @return <code>true</code> if the survey question has any survey answers associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsSurveyAnswers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsSurveyAnswers(pk);
	}

	/**
	* Adds an association between the survey question and the survey answer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswerPK the primary key of the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyAnswer(long pk, long surveyAnswerPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurveyAnswer(pk, surveyAnswerPK);
	}

	/**
	* Adds an association between the survey question and the survey answer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswer the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyAnswer(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurveyAnswer(pk, surveyAnswer);
	}

	/**
	* Adds an association between the survey question and the survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswerPKs the primary keys of the survey answers
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyAnswers(long pk, long[] surveyAnswerPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurveyAnswers(pk, surveyAnswerPKs);
	}

	/**
	* Adds an association between the survey question and the survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswers the survey answers
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyAnswers(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> surveyAnswers)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurveyAnswers(pk, surveyAnswers);
	}

	/**
	* Clears all associations between the survey question and its survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question to clear the associated survey answers from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearSurveyAnswers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearSurveyAnswers(pk);
	}

	/**
	* Removes the association between the survey question and the survey answer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswerPK the primary key of the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurveyAnswer(long pk, long surveyAnswerPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurveyAnswer(pk, surveyAnswerPK);
	}

	/**
	* Removes the association between the survey question and the survey answer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswer the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurveyAnswer(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurveyAnswer(pk, surveyAnswer);
	}

	/**
	* Removes the association between the survey question and the survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswerPKs the primary keys of the survey answers
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurveyAnswers(long pk, long[] surveyAnswerPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurveyAnswers(pk, surveyAnswerPKs);
	}

	/**
	* Removes the association between the survey question and the survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswers the survey answers
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurveyAnswers(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> surveyAnswers)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurveyAnswers(pk, surveyAnswers);
	}

	/**
	* Sets the survey answers associated with the survey question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswerPKs the primary keys of the survey answers to be associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static void setSurveyAnswers(long pk, long[] surveyAnswerPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setSurveyAnswers(pk, surveyAnswerPKs);
	}

	/**
	* Sets the survey answers associated with the survey question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswers the survey answers to be associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static void setSurveyAnswers(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> surveyAnswers)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setSurveyAnswers(pk, surveyAnswers);
	}

	public static SurveyQuestionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SurveyQuestionPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.virtuallaboratory.service.ClpSerializer.getServletContextName(),
					SurveyQuestionPersistence.class.getName());

			ReferenceRegistry.registerReference(SurveyQuestionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SurveyQuestionPersistence persistence) {
	}

	private static SurveyQuestionPersistence _persistence;
}