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

import org.kisti.edison.virtuallaboratory.model.SurveyAnswer;

import java.util.List;

/**
 * The persistence utility for the survey answer service. This utility wraps {@link SurveyAnswerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see SurveyAnswerPersistence
 * @see SurveyAnswerPersistenceImpl
 * @generated
 */
public class SurveyAnswerUtil {
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
	public static void clearCache(SurveyAnswer surveyAnswer) {
		getPersistence().clearCache(surveyAnswer);
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
	public static List<SurveyAnswer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SurveyAnswer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SurveyAnswer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SurveyAnswer update(SurveyAnswer surveyAnswer)
		throws SystemException {
		return getPersistence().update(surveyAnswer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SurveyAnswer update(SurveyAnswer surveyAnswer,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(surveyAnswer, serviceContext);
	}

	/**
	* Caches the survey answer in the entity cache if it is enabled.
	*
	* @param surveyAnswer the survey answer
	*/
	public static void cacheResult(
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer) {
		getPersistence().cacheResult(surveyAnswer);
	}

	/**
	* Caches the survey answers in the entity cache if it is enabled.
	*
	* @param surveyAnswers the survey answers
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> surveyAnswers) {
		getPersistence().cacheResult(surveyAnswers);
	}

	/**
	* Creates a new survey answer with the primary key. Does not add the survey answer to the database.
	*
	* @param SurveyAnswerId the primary key for the new survey answer
	* @return the new survey answer
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyAnswer create(
		long SurveyAnswerId) {
		return getPersistence().create(SurveyAnswerId);
	}

	/**
	* Removes the survey answer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param SurveyAnswerId the primary key of the survey answer
	* @return the survey answer that was removed
	* @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException if a survey answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyAnswer remove(
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException {
		return getPersistence().remove(SurveyAnswerId);
	}

	public static org.kisti.edison.virtuallaboratory.model.SurveyAnswer updateImpl(
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(surveyAnswer);
	}

	/**
	* Returns the survey answer with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException} if it could not be found.
	*
	* @param SurveyAnswerId the primary key of the survey answer
	* @return the survey answer
	* @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException if a survey answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyAnswer findByPrimaryKey(
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException {
		return getPersistence().findByPrimaryKey(SurveyAnswerId);
	}

	/**
	* Returns the survey answer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param SurveyAnswerId the primary key of the survey answer
	* @return the survey answer, or <code>null</code> if a survey answer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.virtuallaboratory.model.SurveyAnswer fetchByPrimaryKey(
		long SurveyAnswerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(SurveyAnswerId);
	}

	/**
	* Returns all the survey answers.
	*
	* @return the survey answers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the survey answers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of survey answers.
	*
	* @return the number of survey answers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the survey questions associated with the survey answer.
	*
	* @param pk the primary key of the survey answer
	* @return the survey questions associated with the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveyQuestions(pk);
	}

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
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveyQuestions(pk, start, end);
	}

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
	public static java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getSurveyQuestions(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of survey questions associated with the survey answer.
	*
	* @param pk the primary key of the survey answer
	* @return the number of survey questions associated with the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public static int getSurveyQuestionsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getSurveyQuestionsSize(pk);
	}

	/**
	* Returns <code>true</code> if the survey question is associated with the survey answer.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestionPK the primary key of the survey question
	* @return <code>true</code> if the survey question is associated with the survey answer; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsSurveyQuestion(long pk, long surveyQuestionPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsSurveyQuestion(pk, surveyQuestionPK);
	}

	/**
	* Returns <code>true</code> if the survey answer has any survey questions associated with it.
	*
	* @param pk the primary key of the survey answer to check for associations with survey questions
	* @return <code>true</code> if the survey answer has any survey questions associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsSurveyQuestions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsSurveyQuestions(pk);
	}

	/**
	* Adds an association between the survey answer and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestionPK the primary key of the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyQuestion(long pk, long surveyQuestionPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurveyQuestion(pk, surveyQuestionPK);
	}

	/**
	* Adds an association between the survey answer and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestion the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyQuestion(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurveyQuestion(pk, surveyQuestion);
	}

	/**
	* Adds an association between the survey answer and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestionPKs the primary keys of the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurveyQuestions(pk, surveyQuestionPKs);
	}

	/**
	* Adds an association between the survey answer and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestions the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static void addSurveyQuestions(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addSurveyQuestions(pk, surveyQuestions);
	}

	/**
	* Clears all associations between the survey answer and its survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer to clear the associated survey questions from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearSurveyQuestions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearSurveyQuestions(pk);
	}

	/**
	* Removes the association between the survey answer and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestionPK the primary key of the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurveyQuestion(long pk, long surveyQuestionPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurveyQuestion(pk, surveyQuestionPK);
	}

	/**
	* Removes the association between the survey answer and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestion the survey question
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurveyQuestion(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurveyQuestion(pk, surveyQuestion);
	}

	/**
	* Removes the association between the survey answer and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestionPKs the primary keys of the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurveyQuestions(pk, surveyQuestionPKs);
	}

	/**
	* Removes the association between the survey answer and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestions the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public static void removeSurveyQuestions(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeSurveyQuestions(pk, surveyQuestions);
	}

	/**
	* Sets the survey questions associated with the survey answer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestionPKs the primary keys of the survey questions to be associated with the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public static void setSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setSurveyQuestions(pk, surveyQuestionPKs);
	}

	/**
	* Sets the survey questions associated with the survey answer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey answer
	* @param surveyQuestions the survey questions to be associated with the survey answer
	* @throws SystemException if a system exception occurred
	*/
	public static void setSurveyQuestions(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setSurveyQuestions(pk, surveyQuestions);
	}

	public static SurveyAnswerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SurveyAnswerPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.virtuallaboratory.service.ClpSerializer.getServletContextName(),
					SurveyAnswerPersistence.class.getName());

			ReferenceRegistry.registerReference(SurveyAnswerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SurveyAnswerPersistence persistence) {
	}

	private static SurveyAnswerPersistence _persistence;
}