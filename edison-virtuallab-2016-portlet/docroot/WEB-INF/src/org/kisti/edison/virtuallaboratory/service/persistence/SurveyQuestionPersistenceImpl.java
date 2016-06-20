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

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.service.persistence.impl.TableMapper;
import com.liferay.portal.service.persistence.impl.TableMapperFactory;

import org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException;
import org.kisti.edison.virtuallaboratory.model.SurveyQuestion;
import org.kisti.edison.virtuallaboratory.model.impl.SurveyQuestionImpl;
import org.kisti.edison.virtuallaboratory.model.impl.SurveyQuestionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the survey question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see SurveyQuestionPersistence
 * @see SurveyQuestionUtil
 * @generated
 */
public class SurveyQuestionPersistenceImpl extends BasePersistenceImpl<SurveyQuestion>
	implements SurveyQuestionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SurveyQuestionUtil} to access the survey question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SurveyQuestionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED,
			SurveyQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SurveyQuestionPersistenceImpl() {
		setModelClass(SurveyQuestion.class);
	}

	/**
	 * Caches the survey question in the entity cache if it is enabled.
	 *
	 * @param surveyQuestion the survey question
	 */
	@Override
	public void cacheResult(SurveyQuestion surveyQuestion) {
		EntityCacheUtil.putResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionImpl.class, surveyQuestion.getPrimaryKey(),
			surveyQuestion);

		surveyQuestion.resetOriginalValues();
	}

	/**
	 * Caches the survey questions in the entity cache if it is enabled.
	 *
	 * @param surveyQuestions the survey questions
	 */
	@Override
	public void cacheResult(List<SurveyQuestion> surveyQuestions) {
		for (SurveyQuestion surveyQuestion : surveyQuestions) {
			if (EntityCacheUtil.getResult(
						SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
						SurveyQuestionImpl.class, surveyQuestion.getPrimaryKey()) == null) {
				cacheResult(surveyQuestion);
			}
			else {
				surveyQuestion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all survey questions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SurveyQuestionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SurveyQuestionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the survey question.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SurveyQuestion surveyQuestion) {
		EntityCacheUtil.removeResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionImpl.class, surveyQuestion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SurveyQuestion> surveyQuestions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SurveyQuestion surveyQuestion : surveyQuestions) {
			EntityCacheUtil.removeResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
				SurveyQuestionImpl.class, surveyQuestion.getPrimaryKey());
		}
	}

	/**
	 * Creates a new survey question with the primary key. Does not add the survey question to the database.
	 *
	 * @param questionSeqNo the primary key for the new survey question
	 * @return the new survey question
	 */
	@Override
	public SurveyQuestion create(long questionSeqNo) {
		SurveyQuestion surveyQuestion = new SurveyQuestionImpl();

		surveyQuestion.setNew(true);
		surveyQuestion.setPrimaryKey(questionSeqNo);

		return surveyQuestion;
	}

	/**
	 * Removes the survey question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionSeqNo the primary key of the survey question
	 * @return the survey question that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion remove(long questionSeqNo)
		throws NoSuchSurveyQuestionException, SystemException {
		return remove((Serializable)questionSeqNo);
	}

	/**
	 * Removes the survey question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the survey question
	 * @return the survey question that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion remove(Serializable primaryKey)
		throws NoSuchSurveyQuestionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SurveyQuestion surveyQuestion = (SurveyQuestion)session.get(SurveyQuestionImpl.class,
					primaryKey);

			if (surveyQuestion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSurveyQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(surveyQuestion);
		}
		catch (NoSuchSurveyQuestionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SurveyQuestion removeImpl(SurveyQuestion surveyQuestion)
		throws SystemException {
		surveyQuestion = toUnwrappedModel(surveyQuestion);

		surveyQuestionToSurveyTableMapper.deleteLeftPrimaryKeyTableMappings(surveyQuestion.getPrimaryKey());

		surveyQuestionToSurveyAnswerTableMapper.deleteLeftPrimaryKeyTableMappings(surveyQuestion.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(surveyQuestion)) {
				surveyQuestion = (SurveyQuestion)session.get(SurveyQuestionImpl.class,
						surveyQuestion.getPrimaryKeyObj());
			}

			if (surveyQuestion != null) {
				session.delete(surveyQuestion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (surveyQuestion != null) {
			clearCache(surveyQuestion);
		}

		return surveyQuestion;
	}

	@Override
	public SurveyQuestion updateImpl(
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws SystemException {
		surveyQuestion = toUnwrappedModel(surveyQuestion);

		boolean isNew = surveyQuestion.isNew();

		Session session = null;

		try {
			session = openSession();

			if (surveyQuestion.isNew()) {
				session.save(surveyQuestion);

				surveyQuestion.setNew(false);
			}
			else {
				session.merge(surveyQuestion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
			SurveyQuestionImpl.class, surveyQuestion.getPrimaryKey(),
			surveyQuestion);

		return surveyQuestion;
	}

	protected SurveyQuestion toUnwrappedModel(SurveyQuestion surveyQuestion) {
		if (surveyQuestion instanceof SurveyQuestionImpl) {
			return surveyQuestion;
		}

		SurveyQuestionImpl surveyQuestionImpl = new SurveyQuestionImpl();

		surveyQuestionImpl.setNew(surveyQuestion.isNew());
		surveyQuestionImpl.setPrimaryKey(surveyQuestion.getPrimaryKey());

		surveyQuestionImpl.setQuestionSeqNo(surveyQuestion.getQuestionSeqNo());
		surveyQuestionImpl.setQuestionDivCd(surveyQuestion.getQuestionDivCd());
		surveyQuestionImpl.setQuestionTitle(surveyQuestion.getQuestionTitle());
		surveyQuestionImpl.setQuestion1(surveyQuestion.getQuestion1());
		surveyQuestionImpl.setQuestion2(surveyQuestion.getQuestion2());
		surveyQuestionImpl.setQuestion3(surveyQuestion.getQuestion3());
		surveyQuestionImpl.setQuestion4(surveyQuestion.getQuestion4());
		surveyQuestionImpl.setQuestion5(surveyQuestion.getQuestion5());
		surveyQuestionImpl.setQuestion6(surveyQuestion.getQuestion6());
		surveyQuestionImpl.setQuestion7(surveyQuestion.getQuestion7());
		surveyQuestionImpl.setQuestion8(surveyQuestion.getQuestion8());
		surveyQuestionImpl.setQuestion9(surveyQuestion.getQuestion9());
		surveyQuestionImpl.setQuestion10(surveyQuestion.getQuestion10());

		return surveyQuestionImpl;
	}

	/**
	 * Returns the survey question with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey question
	 * @return the survey question
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSurveyQuestionException, SystemException {
		SurveyQuestion surveyQuestion = fetchByPrimaryKey(primaryKey);

		if (surveyQuestion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSurveyQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return surveyQuestion;
	}

	/**
	 * Returns the survey question with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException} if it could not be found.
	 *
	 * @param questionSeqNo the primary key of the survey question
	 * @return the survey question
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyQuestionException if a survey question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion findByPrimaryKey(long questionSeqNo)
		throws NoSuchSurveyQuestionException, SystemException {
		return findByPrimaryKey((Serializable)questionSeqNo);
	}

	/**
	 * Returns the survey question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey question
	 * @return the survey question, or <code>null</code> if a survey question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SurveyQuestion surveyQuestion = (SurveyQuestion)EntityCacheUtil.getResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
				SurveyQuestionImpl.class, primaryKey);

		if (surveyQuestion == _nullSurveyQuestion) {
			return null;
		}

		if (surveyQuestion == null) {
			Session session = null;

			try {
				session = openSession();

				surveyQuestion = (SurveyQuestion)session.get(SurveyQuestionImpl.class,
						primaryKey);

				if (surveyQuestion != null) {
					cacheResult(surveyQuestion);
				}
				else {
					EntityCacheUtil.putResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
						SurveyQuestionImpl.class, primaryKey,
						_nullSurveyQuestion);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SurveyQuestionModelImpl.ENTITY_CACHE_ENABLED,
					SurveyQuestionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return surveyQuestion;
	}

	/**
	 * Returns the survey question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionSeqNo the primary key of the survey question
	 * @return the survey question, or <code>null</code> if a survey question with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyQuestion fetchByPrimaryKey(long questionSeqNo)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)questionSeqNo);
	}

	/**
	 * Returns all the survey questions.
	 *
	 * @return the survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyQuestion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<SurveyQuestion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SurveyQuestion> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SurveyQuestion> list = (List<SurveyQuestion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SURVEYQUESTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SURVEYQUESTION;

				if (pagination) {
					sql = sql.concat(SurveyQuestionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyQuestion>(list);
				}
				else {
					list = (List<SurveyQuestion>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the survey questions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SurveyQuestion surveyQuestion : findAll()) {
			remove(surveyQuestion);
		}
	}

	/**
	 * Returns the number of survey questions.
	 *
	 * @return the number of survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SURVEYQUESTION);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns all the surveies associated with the survey question.
	 *
	 * @param pk the primary key of the survey question
	 * @return the surveies associated with the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk) throws SystemException {
		return getSurveies(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk, int start, int end) throws SystemException {
		return getSurveies(pk, start, end, null);
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
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.Survey> getSurveies(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return surveyQuestionToSurveyTableMapper.getRightBaseModels(pk, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of surveies associated with the survey question.
	 *
	 * @param pk the primary key of the survey question
	 * @return the number of surveies associated with the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSurveiesSize(long pk) throws SystemException {
		long[] pks = surveyQuestionToSurveyTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the survey is associated with the survey question.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyPK the primary key of the survey
	 * @return <code>true</code> if the survey is associated with the survey question; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsSurvey(long pk, long surveyPK)
		throws SystemException {
		return surveyQuestionToSurveyTableMapper.containsTableMapping(pk,
			surveyPK);
	}

	/**
	 * Returns <code>true</code> if the survey question has any surveies associated with it.
	 *
	 * @param pk the primary key of the survey question to check for associations with surveies
	 * @return <code>true</code> if the survey question has any surveies associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsSurveies(long pk) throws SystemException {
		if (getSurveiesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the survey question and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyPK the primary key of the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurvey(long pk, long surveyPK) throws SystemException {
		surveyQuestionToSurveyTableMapper.addTableMapping(pk, surveyPK);
	}

	/**
	 * Adds an association between the survey question and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param survey the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurvey(long pk,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws SystemException {
		surveyQuestionToSurveyTableMapper.addTableMapping(pk,
			survey.getPrimaryKey());
	}

	/**
	 * Adds an association between the survey question and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyPKs the primary keys of the surveies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveies(long pk, long[] surveyPKs)
		throws SystemException {
		for (long surveyPK : surveyPKs) {
			surveyQuestionToSurveyTableMapper.addTableMapping(pk, surveyPK);
		}
	}

	/**
	 * Adds an association between the survey question and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveies the surveies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveies(long pk,
		List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.Survey survey : surveies) {
			surveyQuestionToSurveyTableMapper.addTableMapping(pk,
				survey.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the survey question and its surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question to clear the associated surveies from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearSurveies(long pk) throws SystemException {
		surveyQuestionToSurveyTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the survey question and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyPK the primary key of the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurvey(long pk, long surveyPK) throws SystemException {
		surveyQuestionToSurveyTableMapper.deleteTableMapping(pk, surveyPK);
	}

	/**
	 * Removes the association between the survey question and the survey. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param survey the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurvey(long pk,
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws SystemException {
		surveyQuestionToSurveyTableMapper.deleteTableMapping(pk,
			survey.getPrimaryKey());
	}

	/**
	 * Removes the association between the survey question and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyPKs the primary keys of the surveies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveies(long pk, long[] surveyPKs)
		throws SystemException {
		for (long surveyPK : surveyPKs) {
			surveyQuestionToSurveyTableMapper.deleteTableMapping(pk, surveyPK);
		}
	}

	/**
	 * Removes the association between the survey question and the surveies. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveies the surveies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveies(long pk,
		List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.Survey survey : surveies) {
			surveyQuestionToSurveyTableMapper.deleteTableMapping(pk,
				survey.getPrimaryKey());
		}
	}

	/**
	 * Sets the surveies associated with the survey question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyPKs the primary keys of the surveies to be associated with the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setSurveies(long pk, long[] surveyPKs)
		throws SystemException {
		Set<Long> newSurveyPKsSet = SetUtil.fromArray(surveyPKs);
		Set<Long> oldSurveyPKsSet = SetUtil.fromArray(surveyQuestionToSurveyTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeSurveyPKsSet = new HashSet<Long>(oldSurveyPKsSet);

		removeSurveyPKsSet.removeAll(newSurveyPKsSet);

		for (long removeSurveyPK : removeSurveyPKsSet) {
			surveyQuestionToSurveyTableMapper.deleteTableMapping(pk,
				removeSurveyPK);
		}

		newSurveyPKsSet.removeAll(oldSurveyPKsSet);

		for (long newSurveyPK : newSurveyPKsSet) {
			surveyQuestionToSurveyTableMapper.addTableMapping(pk, newSurveyPK);
		}
	}

	/**
	 * Sets the surveies associated with the survey question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveies the surveies to be associated with the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setSurveies(long pk,
		List<org.kisti.edison.virtuallaboratory.model.Survey> surveies)
		throws SystemException {
		try {
			long[] surveyPKs = new long[surveies.size()];

			for (int i = 0; i < surveies.size(); i++) {
				org.kisti.edison.virtuallaboratory.model.Survey survey = surveies.get(i);

				surveyPKs[i] = survey.getPrimaryKey();
			}

			setSurveies(pk, surveyPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SurveyQuestionModelImpl.MAPPING_TABLE_EDVIR_SURVEYS_SURVEYQUESTIONS_NAME);
		}
	}

	/**
	 * Returns all the survey answers associated with the survey question.
	 *
	 * @param pk the primary key of the survey question
	 * @return the survey answers associated with the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyAnswers(
		long pk) throws SystemException {
		return getSurveyAnswers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyAnswers(
		long pk, int start, int end) throws SystemException {
		return getSurveyAnswers(pk, start, end, null);
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
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> getSurveyAnswers(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return surveyQuestionToSurveyAnswerTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of survey answers associated with the survey question.
	 *
	 * @param pk the primary key of the survey question
	 * @return the number of survey answers associated with the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSurveyAnswersSize(long pk) throws SystemException {
		long[] pks = surveyQuestionToSurveyAnswerTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the survey answer is associated with the survey question.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyAnswerPK the primary key of the survey answer
	 * @return <code>true</code> if the survey answer is associated with the survey question; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsSurveyAnswer(long pk, long surveyAnswerPK)
		throws SystemException {
		return surveyQuestionToSurveyAnswerTableMapper.containsTableMapping(pk,
			surveyAnswerPK);
	}

	/**
	 * Returns <code>true</code> if the survey question has any survey answers associated with it.
	 *
	 * @param pk the primary key of the survey question to check for associations with survey answers
	 * @return <code>true</code> if the survey question has any survey answers associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsSurveyAnswers(long pk) throws SystemException {
		if (getSurveyAnswersSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the survey question and the survey answer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyAnswerPK the primary key of the survey answer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveyAnswer(long pk, long surveyAnswerPK)
		throws SystemException {
		surveyQuestionToSurveyAnswerTableMapper.addTableMapping(pk,
			surveyAnswerPK);
	}

	/**
	 * Adds an association between the survey question and the survey answer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyAnswer the survey answer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveyAnswer(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws SystemException {
		surveyQuestionToSurveyAnswerTableMapper.addTableMapping(pk,
			surveyAnswer.getPrimaryKey());
	}

	/**
	 * Adds an association between the survey question and the survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyAnswerPKs the primary keys of the survey answers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveyAnswers(long pk, long[] surveyAnswerPKs)
		throws SystemException {
		for (long surveyAnswerPK : surveyAnswerPKs) {
			surveyQuestionToSurveyAnswerTableMapper.addTableMapping(pk,
				surveyAnswerPK);
		}
	}

	/**
	 * Adds an association between the survey question and the survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyAnswers the survey answers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveyAnswers(long pk,
		List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> surveyAnswers)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer : surveyAnswers) {
			surveyQuestionToSurveyAnswerTableMapper.addTableMapping(pk,
				surveyAnswer.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the survey question and its survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question to clear the associated survey answers from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearSurveyAnswers(long pk) throws SystemException {
		surveyQuestionToSurveyAnswerTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the survey question and the survey answer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyAnswerPK the primary key of the survey answer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveyAnswer(long pk, long surveyAnswerPK)
		throws SystemException {
		surveyQuestionToSurveyAnswerTableMapper.deleteTableMapping(pk,
			surveyAnswerPK);
	}

	/**
	 * Removes the association between the survey question and the survey answer. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyAnswer the survey answer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveyAnswer(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws SystemException {
		surveyQuestionToSurveyAnswerTableMapper.deleteTableMapping(pk,
			surveyAnswer.getPrimaryKey());
	}

	/**
	 * Removes the association between the survey question and the survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyAnswerPKs the primary keys of the survey answers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveyAnswers(long pk, long[] surveyAnswerPKs)
		throws SystemException {
		for (long surveyAnswerPK : surveyAnswerPKs) {
			surveyQuestionToSurveyAnswerTableMapper.deleteTableMapping(pk,
				surveyAnswerPK);
		}
	}

	/**
	 * Removes the association between the survey question and the survey answers. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyAnswers the survey answers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveyAnswers(long pk,
		List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> surveyAnswers)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer : surveyAnswers) {
			surveyQuestionToSurveyAnswerTableMapper.deleteTableMapping(pk,
				surveyAnswer.getPrimaryKey());
		}
	}

	/**
	 * Sets the survey answers associated with the survey question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyAnswerPKs the primary keys of the survey answers to be associated with the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setSurveyAnswers(long pk, long[] surveyAnswerPKs)
		throws SystemException {
		Set<Long> newSurveyAnswerPKsSet = SetUtil.fromArray(surveyAnswerPKs);
		Set<Long> oldSurveyAnswerPKsSet = SetUtil.fromArray(surveyQuestionToSurveyAnswerTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeSurveyAnswerPKsSet = new HashSet<Long>(oldSurveyAnswerPKsSet);

		removeSurveyAnswerPKsSet.removeAll(newSurveyAnswerPKsSet);

		for (long removeSurveyAnswerPK : removeSurveyAnswerPKsSet) {
			surveyQuestionToSurveyAnswerTableMapper.deleteTableMapping(pk,
				removeSurveyAnswerPK);
		}

		newSurveyAnswerPKsSet.removeAll(oldSurveyAnswerPKsSet);

		for (long newSurveyAnswerPK : newSurveyAnswerPKsSet) {
			surveyQuestionToSurveyAnswerTableMapper.addTableMapping(pk,
				newSurveyAnswerPK);
		}
	}

	/**
	 * Sets the survey answers associated with the survey question, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey question
	 * @param surveyAnswers the survey answers to be associated with the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setSurveyAnswers(long pk,
		List<org.kisti.edison.virtuallaboratory.model.SurveyAnswer> surveyAnswers)
		throws SystemException {
		try {
			long[] surveyAnswerPKs = new long[surveyAnswers.size()];

			for (int i = 0; i < surveyAnswers.size(); i++) {
				org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer =
					surveyAnswers.get(i);

				surveyAnswerPKs[i] = surveyAnswer.getPrimaryKey();
			}

			setSurveyAnswers(pk, surveyAnswerPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SurveyQuestionModelImpl.MAPPING_TABLE_EDVIR_SURVEYQUESTIONS_SURVEYANSWERS_NAME);
		}
	}

	/**
	 * Initializes the survey question persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.virtuallaboratory.model.SurveyQuestion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SurveyQuestion>> listenersList = new ArrayList<ModelListener<SurveyQuestion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SurveyQuestion>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		surveyQuestionToSurveyTableMapper = TableMapperFactory.getTableMapper("EDVIR_Surveys_SurveyQuestions",
				"questionSeqNo", "surveySeqNo", this, surveyPersistence);

		surveyQuestionToSurveyAnswerTableMapper = TableMapperFactory.getTableMapper("EDVIR_SurveyQuestions_SurveyAnswers",
				"questionSeqNo", "SurveyAnswerId", this, surveyAnswerPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SurveyQuestionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("EDVIR_Surveys_SurveyQuestions");
		TableMapperFactory.removeTableMapper(
			"EDVIR_SurveyQuestions_SurveyAnswers");
	}

	@BeanReference(type = SurveyPersistence.class)
	protected SurveyPersistence surveyPersistence;
	protected TableMapper<SurveyQuestion, org.kisti.edison.virtuallaboratory.model.Survey> surveyQuestionToSurveyTableMapper;
	@BeanReference(type = SurveyAnswerPersistence.class)
	protected SurveyAnswerPersistence surveyAnswerPersistence;
	protected TableMapper<SurveyQuestion, org.kisti.edison.virtuallaboratory.model.SurveyAnswer> surveyQuestionToSurveyAnswerTableMapper;
	private static final String _SQL_SELECT_SURVEYQUESTION = "SELECT surveyQuestion FROM SurveyQuestion surveyQuestion";
	private static final String _SQL_COUNT_SURVEYQUESTION = "SELECT COUNT(surveyQuestion) FROM SurveyQuestion surveyQuestion";
	private static final String _ORDER_BY_ENTITY_ALIAS = "surveyQuestion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SurveyQuestion exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SurveyQuestionPersistenceImpl.class);
	private static SurveyQuestion _nullSurveyQuestion = new SurveyQuestionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SurveyQuestion> toCacheModel() {
				return _nullSurveyQuestionCacheModel;
			}
		};

	private static CacheModel<SurveyQuestion> _nullSurveyQuestionCacheModel = new CacheModel<SurveyQuestion>() {
			@Override
			public SurveyQuestion toEntityModel() {
				return _nullSurveyQuestion;
			}
		};
}