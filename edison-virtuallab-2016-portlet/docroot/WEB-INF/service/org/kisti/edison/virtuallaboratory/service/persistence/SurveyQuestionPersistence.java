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

import com.liferay.portal.service.persistence.BasePersistence;

import org.kisti.edison.virtuallaboratory.model.SurveyQuestion;

/**
 * The persistence interface for the survey question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see SurveyQuestionPersistenceImpl
 * @see SurveyQuestionUtil
 * @generated
 */
public interface SurveyQuestionPersistence extends BasePersistence<SurveyQuestion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SurveyQuestionUtil} to access the survey question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the survey question in the entity cache if it is enabled.
	*
	* @param surveyQuestion the survey question
	*/
	public void cacheResult(
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion);

	/**
	* Caches the survey questions in the entity cache if it is enabled.
	*
	* @param surveyQuestions the survey questions
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions);

	/**
	* Creates a new survey question with the primary key. Does not add the survey question to the database.
	*
	* @param questionSeqNo the primary key for the new survey question
	* @return the new survey question
	*/
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion create(
		long questionSeqNo);

	/**
	* Removes the survey question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionSeqNo the primary key of the survey question
	* @return the survey question that was removed
	* @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion remove(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException;

	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion updateImpl(
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey question with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException} if it could not be found.
	*
	* @param questionSeqNo the primary key of the survey question
	* @return the survey question
	* @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion findByPrimaryKey(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException;

	/**
	* Returns the survey question with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param questionSeqNo the primary key of the survey question
	* @return the survey question, or <code>null</code> if a survey question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.SurveyQuestion fetchByPrimaryKey(
		long questionSeqNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey questions.
	*
	* @return the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey questions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey questions.
	*
	* @return the number of survey questions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the surveies associated with the survey question.
	*
	* @param pk the primary key of the survey question
	* @return the surveies associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of surveies associated with the survey question.
	*
	* @param pk the primary key of the survey question
	* @return the number of surveies associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public int getSurveiesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the survey is associated with the survey question.
	*
	* @param pk the primary key of the survey question
	* @param surveyPK the primary key of the survey
	* @return <code>true</code> if the survey is associated with the survey question; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsSurvey(long pk, long surveyPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the survey question has any surveies associated with it.
	*
	* @param pk the primary key of the survey question to check for associations with surveies
	* @return <code>true</code> if the survey question has any surveies associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsSurveies(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey question and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyPK the primary key of the survey
	* @throws SystemException if a system exception occurred
	*/
	public void addSurvey(long pk, long surveyPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey question and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param survey the survey
	* @throws SystemException if a system exception occurred
	*/
	public void addSurvey(long pk,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey question and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyPKs the primary keys of the surveies
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveies(long pk, long[] surveyPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey question and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveies the surveies
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveies(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the survey question and its surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question to clear the associated surveies from
	* @throws SystemException if a system exception occurred
	*/
	public void clearSurveies(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey question and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyPK the primary key of the survey
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurvey(long pk, long surveyPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey question and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param survey the survey
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurvey(long pk,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey question and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyPKs the primary keys of the surveies
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveies(long pk, long[] surveyPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey question and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveies the surveies
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveies(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the surveies associated with the survey question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyPKs the primary keys of the surveies to be associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public void setSurveies(long pk, long[] surveyPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the surveies associated with the survey question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveies the surveies to be associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public void setSurveies(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey answers associated with the survey question.
	*
	* @param pk the primary key of the survey question
	* @return the survey answers associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyAnswers(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyAnswers(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyAnswers(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey answers associated with the survey question.
	*
	* @param pk the primary key of the survey question
	* @return the number of survey answers associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public int getSurveyAnswersSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the survey answer is associated with the survey question.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswerPK the primary key of the survey answer
	* @return <code>true</code> if the survey answer is associated with the survey question; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsSurveyAnswer(long pk, long surveyAnswerPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the survey question has any survey answers associated with it.
	*
	* @param pk the primary key of the survey question to check for associations with survey answers
	* @return <code>true</code> if the survey question has any survey answers associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsSurveyAnswers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey question and the survey answer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswerPK the primary key of the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveyAnswer(long pk, long surveyAnswerPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey question and the survey answer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswer the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveyAnswer(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey question and the survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswerPKs the primary keys of the survey answers
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveyAnswers(long pk, long[] surveyAnswerPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey question and the survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswers the survey answers
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveyAnswers(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> surveyAnswers)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the survey question and its survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question to clear the associated survey answers from
	* @throws SystemException if a system exception occurred
	*/
	public void clearSurveyAnswers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey question and the survey answer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswerPK the primary key of the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveyAnswer(long pk, long surveyAnswerPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey question and the survey answer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswer the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveyAnswer(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey question and the survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswerPKs the primary keys of the survey answers
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveyAnswers(long pk, long[] surveyAnswerPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey question and the survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswers the survey answers
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveyAnswers(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> surveyAnswers)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the survey answers associated with the survey question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswerPKs the primary keys of the survey answers to be associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public void setSurveyAnswers(long pk, long[] surveyAnswerPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the survey answers associated with the survey question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey question
	* @param surveyAnswers the survey answers to be associated with the survey question
	* @throws SystemException if a system exception occurred
	*/
	public void setSurveyAnswers(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> surveyAnswers)
		throws com.liferay.portal.kernel.exception.SystemException;
}