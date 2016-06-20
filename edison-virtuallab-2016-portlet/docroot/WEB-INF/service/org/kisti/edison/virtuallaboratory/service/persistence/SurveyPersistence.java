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

import org.kisti.edison.virtuallaboratory.model.Survey;

/**
 * The persistence interface for the survey service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see SurveyPersistenceImpl
 * @see SurveyUtil
 * @generated
 */
public interface SurveyPersistence extends BasePersistence<Survey> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SurveyUtil} to access the survey persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the survey in the entity cache if it is enabled.
	*
	* @param survey the survey
	*/
	public void cacheResult(
		org.kisti.edison.virtuallaboratory.model.Survey survey);

	/**
	* Caches the surveies in the entity cache if it is enabled.
	*
	* @param surveies the surveies
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> surveies);

	/**
	* Creates a new survey with the primary key. Does not add the survey to the database.
	*
	* @param surveySeqNo the primary key for the new survey
	* @return the new survey
	*/
	public org.kisti.edison.virtuallaboratory.model.Survey create(
		long surveySeqNo);

	/**
	* Removes the survey with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param surveySeqNo the primary key of the survey
	* @return the survey that was removed
	* @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyException if a survey with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.Survey remove(
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchSurveyException;

	public org.kisti.edison.virtuallaboratory.model.Survey updateImpl(
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the survey with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchSurveyException} if it could not be found.
	*
	* @param surveySeqNo the primary key of the survey
	* @return the survey
	* @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyException if a survey with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.Survey findByPrimaryKey(
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.virtuallaboratory.NoSuchSurveyException;

	/**
	* Returns the survey with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param surveySeqNo the primary key of the survey
	* @return the survey, or <code>null</code> if a survey with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.virtuallaboratory.model.Survey fetchByPrimaryKey(
		long surveySeqNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the surveies.
	*
	* @return the surveies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the surveies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of surveies
	* @param end the upper bound of the range of surveies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of surveies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.Survey> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the surveies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of surveies.
	*
	* @return the number of surveies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the virtual labs associated with the survey.
	*
	* @param pk the primary key of the survey
	* @return the virtual labs associated with the survey
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the virtual labs associated with the survey.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the survey
	* @param start the lower bound of the range of surveies
	* @param end the upper bound of the range of surveies (not inclusive)
	* @return the range of virtual labs associated with the survey
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the virtual labs associated with the survey.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the survey
	* @param start the lower bound of the range of surveies
	* @param end the upper bound of the range of surveies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of virtual labs associated with the survey
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of virtual labs associated with the survey.
	*
	* @param pk the primary key of the survey
	* @return the number of virtual labs associated with the survey
	* @throws SystemException if a system exception occurred
	*/
	public int getVirtualLabsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the virtual lab is associated with the survey.
	*
	* @param pk the primary key of the survey
	* @param virtualLabPK the primary key of the virtual lab
	* @return <code>true</code> if the virtual lab is associated with the survey; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsVirtualLab(long pk, long virtualLabPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the survey has any virtual labs associated with it.
	*
	* @param pk the primary key of the survey to check for associations with virtual labs
	* @return <code>true</code> if the survey has any virtual labs associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsVirtualLabs(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param virtualLabPK the primary key of the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLab(long pk, long virtualLabPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param virtualLab the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLab(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param virtualLabPKs the primary keys of the virtual labs
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabs(long pk, long[] virtualLabPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param virtualLabs the virtual labs
	* @throws SystemException if a system exception occurred
	*/
	public void addVirtualLabs(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the survey and its virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey to clear the associated virtual labs from
	* @throws SystemException if a system exception occurred
	*/
	public void clearVirtualLabs(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param virtualLabPK the primary key of the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLab(long pk, long virtualLabPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param virtualLab the virtual lab
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLab(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param virtualLabPKs the primary keys of the virtual labs
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLabs(long pk, long[] virtualLabPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param virtualLabs the virtual labs
	* @throws SystemException if a system exception occurred
	*/
	public void removeVirtualLabs(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the virtual labs associated with the survey, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param virtualLabPKs the primary keys of the virtual labs to be associated with the survey
	* @throws SystemException if a system exception occurred
	*/
	public void setVirtualLabs(long pk, long[] virtualLabPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the virtual labs associated with the survey, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param virtualLabs the virtual labs to be associated with the survey
	* @throws SystemException if a system exception occurred
	*/
	public void setVirtualLabs(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the survey questions associated with the survey.
	*
	* @param pk the primary key of the survey
	* @return the survey questions associated with the survey
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the survey questions associated with the survey.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the survey
	* @param start the lower bound of the range of surveies
	* @param end the upper bound of the range of surveies (not inclusive)
	* @return the range of survey questions associated with the survey
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the survey questions associated with the survey.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.SurveyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the survey
	* @param start the lower bound of the range of surveies
	* @param end the upper bound of the range of surveies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of survey questions associated with the survey
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of survey questions associated with the survey.
	*
	* @param pk the primary key of the survey
	* @return the number of survey questions associated with the survey
	* @throws SystemException if a system exception occurred
	*/
	public int getSurveyQuestionsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the survey question is associated with the survey.
	*
	* @param pk the primary key of the survey
	* @param surveyQuestionPK the primary key of the survey question
	* @return <code>true</code> if the survey question is associated with the survey; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsSurveyQuestion(long pk, long surveyQuestionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the survey has any survey questions associated with it.
	*
	* @param pk the primary key of the survey to check for associations with survey questions
	* @return <code>true</code> if the survey has any survey questions associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsSurveyQuestions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param surveyQuestionPK the primary key of the survey question
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveyQuestion(long pk, long surveyQuestionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param surveyQuestion the survey question
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveyQuestion(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param surveyQuestionPKs the primary keys of the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the survey and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param surveyQuestions the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public void addSurveyQuestions(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the survey and its survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey to clear the associated survey questions from
	* @throws SystemException if a system exception occurred
	*/
	public void clearSurveyQuestions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param surveyQuestionPK the primary key of the survey question
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveyQuestion(long pk, long surveyQuestionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param surveyQuestion the survey question
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveyQuestion(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param surveyQuestionPKs the primary keys of the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the survey and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param surveyQuestions the survey questions
	* @throws SystemException if a system exception occurred
	*/
	public void removeSurveyQuestions(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the survey questions associated with the survey, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param surveyQuestionPKs the primary keys of the survey questions to be associated with the survey
	* @throws SystemException if a system exception occurred
	*/
	public void setSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the survey questions associated with the survey, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the survey
	* @param surveyQuestions the survey questions to be associated with the survey
	* @throws SystemException if a system exception occurred
	*/
	public void setSurveyQuestions(long pk,
		java.util.List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws com.liferay.portal.kernel.exception.SystemException;
}