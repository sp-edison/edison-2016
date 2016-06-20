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

import org.kisti.edison.virtuallaboratory.model.SurveyAnswer;

/**
 * The persistence interface for the survey answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see SurveyAnswerPersistenceImpl
 * @see SurveyAnswerUtil
 * @generated
 */
public interface SurveyAnswerPersistence extends BasePersistence<SurveyAnswer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SurveyAnswerUtil} to access the survey answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the survey answer in the entity cache if it is enabled.
	*
	* @param surveyAnswer the survey answer
	*/
	public void cacheResult(
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer);

	/**
	* Caches the survey answers in the entity cache if it is enabled.
	*
	* @param surveyAnswers the survey answers
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> surveyAnswers);

	/**
	* Creates a new survey answer with the primary key. Does not add the survey answer to the database.
	*
	* @param SurveyAnswerId the primary key for the new survey answer
	* @return the new survey answer
	*/
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer create(
		long SurveyAnswerId);

	/**
	* Removes the survey answer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SurveyAnswerId the primary key of the survey answer
	* @return the survey answer that was removed
	* @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException if a survey answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer remove(
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException;

	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer updateImpl(
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey answer with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException} if it could not be found.
	*
	* @param SurveyAnswerId the primary key of the survey answer
	* @return the survey answer
	* @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException if a survey answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer findByPrimaryKey(
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException;

	/**
	* Returns the survey answer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param SurveyAnswerId the primary key of the survey answer
	* @return the survey answer, or <code>null</code> if a survey answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.SurveyAnswer fetchByPrimaryKey(
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey answers.
	*
	* @return the survey answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey answers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of survey answers
	* @param end the upper bound of the range of survey answers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey answers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the survey answers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey answers.
	*
	* @return the number of survey answers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey questions associated with the survey answer.
	*
	* @param pk the primary key of the survey answer
	* @return the survey questions associated with the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey questions associated with the survey answer.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the survey answer
	* @param start the lower bound of the range of survey answers
	* @param end the upper bound of the range of survey answers (not inclusive)
	* @return the range of survey questions associated with the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey questions associated with the survey answer.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the survey answer
	* @param start the lower bound of the range of survey answers
	* @param end the upper bound of the range of survey answers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey questions associated with the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey questions associated with the survey answer.
	*
	* @param pk the primary key of the survey answer
	* @return the number of survey questions associated with the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public int getSurveyQuestionsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the survey question is associated with the survey answer.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestionPK the primary key of the survey question
	* @return <code>true</code> if the survey question is associated with the survey answer; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsSurveyQuestion(long pk, long surveyQuestionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the survey answer has any survey questions associated with it.
	*
	* @param pk the primary key of the survey answer to check for associations with survey questions
	* @return <code>true</code> if the survey answer has any survey questions associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsSurveyQuestions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey answer and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestionPK the primary key of the survey question
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveyQuestion(long pk, long surveyQuestionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey answer and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestion the survey question
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveyQuestion(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey answer and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestionPKs the primary keys of the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey answer and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestions the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveyQuestions(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the survey answer and its survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer to clear the associated survey questions from
	* @throws SystemException if a system exception occurred
	*/
	public void clearSurveyQuestions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey answer and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestionPK the primary key of the survey question
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveyQuestion(long pk, long surveyQuestionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey answer and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestion the survey question
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveyQuestion(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey answer and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestionPKs the primary keys of the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey answer and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestions the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveyQuestions(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the survey questions associated with the survey answer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestionPKs the primary keys of the survey questions to be associated with the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public void setSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the survey questions associated with the survey answer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestions the survey questions to be associated with the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public void setSurveyQuestions(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException;
}