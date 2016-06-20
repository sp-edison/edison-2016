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

import org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException;
import org.kisti.edison.virtuallaboratory.model.SurveyAnswer;
import org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerImpl;
import org.kisti.edison.virtuallaboratory.model.impl.SurveyAnswerModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the survey answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see SurveyAnswerPersistence
 * @see SurveyAnswerUtil
 * @generated
 */
public class SurveyAnswerPersistenceImpl extends BasePersistenceImpl<SurveyAnswer>
	implements SurveyAnswerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SurveyAnswerUtil} to access the survey answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SurveyAnswerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SurveyAnswerModelImpl.ENTITY_CACHE_ENABLED,
			SurveyAnswerModelImpl.FINDER_CACHE_ENABLED, SurveyAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SurveyAnswerModelImpl.ENTITY_CACHE_ENABLED,
			SurveyAnswerModelImpl.FINDER_CACHE_ENABLED, SurveyAnswerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SurveyAnswerModelImpl.ENTITY_CACHE_ENABLED,
			SurveyAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SurveyAnswerPersistenceImpl() {
		setModelClass(SurveyAnswer.class);
	}

	/**
	 * Caches the survey answer in the entity cache if it is enabled.
	 *
	 * @param surveyAnswer the survey answer
	 */
	@Override
	public void cacheResult(SurveyAnswer surveyAnswer) {
		EntityCacheUtil.putResult(SurveyAnswerModelImpl.ENTITY_CACHE_ENABLED,
			SurveyAnswerImpl.class, surveyAnswer.getPrimaryKey(), surveyAnswer);

		surveyAnswer.resetOriginalValues();
	}

	/**
	 * Caches the survey answers in the entity cache if it is enabled.
	 *
	 * @param surveyAnswers the survey answers
	 */
	@Override
	public void cacheResult(List<SurveyAnswer> surveyAnswers) {
		for (SurveyAnswer surveyAnswer : surveyAnswers) {
			if (EntityCacheUtil.getResult(
						SurveyAnswerModelImpl.ENTITY_CACHE_ENABLED,
						SurveyAnswerImpl.class, surveyAnswer.getPrimaryKey()) == null) {
				cacheResult(surveyAnswer);
			}
			else {
				surveyAnswer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all survey answers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SurveyAnswerImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SurveyAnswerImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the survey answer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SurveyAnswer surveyAnswer) {
		EntityCacheUtil.removeResult(SurveyAnswerModelImpl.ENTITY_CACHE_ENABLED,
			SurveyAnswerImpl.class, surveyAnswer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SurveyAnswer> surveyAnswers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SurveyAnswer surveyAnswer : surveyAnswers) {
			EntityCacheUtil.removeResult(SurveyAnswerModelImpl.ENTITY_CACHE_ENABLED,
				SurveyAnswerImpl.class, surveyAnswer.getPrimaryKey());
		}
	}

	/**
	 * Creates a new survey answer with the primary key. Does not add the survey answer to the database.
	 *
	 * @param SurveyAnswerId the primary key for the new survey answer
	 * @return the new survey answer
	 */
	@Override
	public SurveyAnswer create(long SurveyAnswerId) {
		SurveyAnswer surveyAnswer = new SurveyAnswerImpl();

		surveyAnswer.setNew(true);
		surveyAnswer.setPrimaryKey(SurveyAnswerId);

		return surveyAnswer;
	}

	/**
	 * Removes the survey answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param SurveyAnswerId the primary key of the survey answer
	 * @return the survey answer that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException if a survey answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyAnswer remove(long SurveyAnswerId)
		throws NoSuchSurveyAnswerException, SystemException {
		return remove((Serializable)SurveyAnswerId);
	}

	/**
	 * Removes the survey answer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the survey answer
	 * @return the survey answer that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException if a survey answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyAnswer remove(Serializable primaryKey)
		throws NoSuchSurveyAnswerException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SurveyAnswer surveyAnswer = (SurveyAnswer)session.get(SurveyAnswerImpl.class,
					primaryKey);

			if (surveyAnswer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSurveyAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(surveyAnswer);
		}
		catch (NoSuchSurveyAnswerException nsee) {
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
	protected SurveyAnswer removeImpl(SurveyAnswer surveyAnswer)
		throws SystemException {
		surveyAnswer = toUnwrappedModel(surveyAnswer);

		surveyAnswerToSurveyQuestionTableMapper.deleteLeftPrimaryKeyTableMappings(surveyAnswer.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(surveyAnswer)) {
				surveyAnswer = (SurveyAnswer)session.get(SurveyAnswerImpl.class,
						surveyAnswer.getPrimaryKeyObj());
			}

			if (surveyAnswer != null) {
				session.delete(surveyAnswer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (surveyAnswer != null) {
			clearCache(surveyAnswer);
		}

		return surveyAnswer;
	}

	@Override
	public SurveyAnswer updateImpl(
		org.kisti.edison.virtuallaboratory.model.SurveyAnswer surveyAnswer)
		throws SystemException {
		surveyAnswer = toUnwrappedModel(surveyAnswer);

		boolean isNew = surveyAnswer.isNew();

		Session session = null;

		try {
			session = openSession();

			if (surveyAnswer.isNew()) {
				session.save(surveyAnswer);

				surveyAnswer.setNew(false);
			}
			else {
				session.merge(surveyAnswer);
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

		EntityCacheUtil.putResult(SurveyAnswerModelImpl.ENTITY_CACHE_ENABLED,
			SurveyAnswerImpl.class, surveyAnswer.getPrimaryKey(), surveyAnswer);

		return surveyAnswer;
	}

	protected SurveyAnswer toUnwrappedModel(SurveyAnswer surveyAnswer) {
		if (surveyAnswer instanceof SurveyAnswerImpl) {
			return surveyAnswer;
		}

		SurveyAnswerImpl surveyAnswerImpl = new SurveyAnswerImpl();

		surveyAnswerImpl.setNew(surveyAnswer.isNew());
		surveyAnswerImpl.setPrimaryKey(surveyAnswer.getPrimaryKey());

		surveyAnswerImpl.setSurveyAnswerId(surveyAnswer.getSurveyAnswerId());
		surveyAnswerImpl.setUserId(surveyAnswer.getUserId());
		surveyAnswerImpl.setVirtualLabId(surveyAnswer.getVirtualLabId());
		surveyAnswerImpl.setClassId(surveyAnswer.getClassId());
		surveyAnswerImpl.setSubjectivityAnswer(surveyAnswer.getSubjectivityAnswer());
		surveyAnswerImpl.setObjecttivityAnswer(surveyAnswer.getObjecttivityAnswer());
		surveyAnswerImpl.setAnswerDate(surveyAnswer.getAnswerDate());

		return surveyAnswerImpl;
	}

	/**
	 * Returns the survey answer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey answer
	 * @return the survey answer
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException if a survey answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyAnswer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSurveyAnswerException, SystemException {
		SurveyAnswer surveyAnswer = fetchByPrimaryKey(primaryKey);

		if (surveyAnswer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSurveyAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return surveyAnswer;
	}

	/**
	 * Returns the survey answer with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException} if it could not be found.
	 *
	 * @param SurveyAnswerId the primary key of the survey answer
	 * @return the survey answer
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyAnswerException if a survey answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyAnswer findByPrimaryKey(long SurveyAnswerId)
		throws NoSuchSurveyAnswerException, SystemException {
		return findByPrimaryKey((Serializable)SurveyAnswerId);
	}

	/**
	 * Returns the survey answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey answer
	 * @return the survey answer, or <code>null</code> if a survey answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyAnswer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SurveyAnswer surveyAnswer = (SurveyAnswer)EntityCacheUtil.getResult(SurveyAnswerModelImpl.ENTITY_CACHE_ENABLED,
				SurveyAnswerImpl.class, primaryKey);

		if (surveyAnswer == _nullSurveyAnswer) {
			return null;
		}

		if (surveyAnswer == null) {
			Session session = null;

			try {
				session = openSession();

				surveyAnswer = (SurveyAnswer)session.get(SurveyAnswerImpl.class,
						primaryKey);

				if (surveyAnswer != null) {
					cacheResult(surveyAnswer);
				}
				else {
					EntityCacheUtil.putResult(SurveyAnswerModelImpl.ENTITY_CACHE_ENABLED,
						SurveyAnswerImpl.class, primaryKey, _nullSurveyAnswer);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SurveyAnswerModelImpl.ENTITY_CACHE_ENABLED,
					SurveyAnswerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return surveyAnswer;
	}

	/**
	 * Returns the survey answer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param SurveyAnswerId the primary key of the survey answer
	 * @return the survey answer, or <code>null</code> if a survey answer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SurveyAnswer fetchByPrimaryKey(long SurveyAnswerId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)SurveyAnswerId);
	}

	/**
	 * Returns all the survey answers.
	 *
	 * @return the survey answers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SurveyAnswer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<SurveyAnswer> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<SurveyAnswer> findAll(int start, int end,
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

		List<SurveyAnswer> list = (List<SurveyAnswer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SURVEYANSWER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SURVEYANSWER;

				if (pagination) {
					sql = sql.concat(SurveyAnswerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SurveyAnswer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SurveyAnswer>(list);
				}
				else {
					list = (List<SurveyAnswer>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the survey answers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SurveyAnswer surveyAnswer : findAll()) {
			remove(surveyAnswer);
		}
	}

	/**
	 * Returns the number of survey answers.
	 *
	 * @return the number of survey answers
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

				Query q = session.createQuery(_SQL_COUNT_SURVEYANSWER);

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
	 * Returns all the survey questions associated with the survey answer.
	 *
	 * @param pk the primary key of the survey answer
	 * @return the survey questions associated with the survey answer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk) throws SystemException {
		return getSurveyQuestions(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk, int start, int end) throws SystemException {
		return getSurveyQuestions(pk, start, end, null);
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
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return surveyAnswerToSurveyQuestionTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of survey questions associated with the survey answer.
	 *
	 * @param pk the primary key of the survey answer
	 * @return the number of survey questions associated with the survey answer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSurveyQuestionsSize(long pk) throws SystemException {
		long[] pks = surveyAnswerToSurveyQuestionTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the survey question is associated with the survey answer.
	 *
	 * @param pk the primary key of the survey answer
	 * @param surveyQuestionPK the primary key of the survey question
	 * @return <code>true</code> if the survey question is associated with the survey answer; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsSurveyQuestion(long pk, long surveyQuestionPK)
		throws SystemException {
		return surveyAnswerToSurveyQuestionTableMapper.containsTableMapping(pk,
			surveyQuestionPK);
	}

	/**
	 * Returns <code>true</code> if the survey answer has any survey questions associated with it.
	 *
	 * @param pk the primary key of the survey answer to check for associations with survey questions
	 * @return <code>true</code> if the survey answer has any survey questions associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsSurveyQuestions(long pk) throws SystemException {
		if (getSurveyQuestionsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the survey answer and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey answer
	 * @param surveyQuestionPK the primary key of the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveyQuestion(long pk, long surveyQuestionPK)
		throws SystemException {
		surveyAnswerToSurveyQuestionTableMapper.addTableMapping(pk,
			surveyQuestionPK);
	}

	/**
	 * Adds an association between the survey answer and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey answer
	 * @param surveyQuestion the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveyQuestion(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws SystemException {
		surveyAnswerToSurveyQuestionTableMapper.addTableMapping(pk,
			surveyQuestion.getPrimaryKey());
	}

	/**
	 * Adds an association between the survey answer and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey answer
	 * @param surveyQuestionPKs the primary keys of the survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws SystemException {
		for (long surveyQuestionPK : surveyQuestionPKs) {
			surveyAnswerToSurveyQuestionTableMapper.addTableMapping(pk,
				surveyQuestionPK);
		}
	}

	/**
	 * Adds an association between the survey answer and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey answer
	 * @param surveyQuestions the survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveyQuestions(long pk,
		List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion : surveyQuestions) {
			surveyAnswerToSurveyQuestionTableMapper.addTableMapping(pk,
				surveyQuestion.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the survey answer and its survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey answer to clear the associated survey questions from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearSurveyQuestions(long pk) throws SystemException {
		surveyAnswerToSurveyQuestionTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the survey answer and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey answer
	 * @param surveyQuestionPK the primary key of the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveyQuestion(long pk, long surveyQuestionPK)
		throws SystemException {
		surveyAnswerToSurveyQuestionTableMapper.deleteTableMapping(pk,
			surveyQuestionPK);
	}

	/**
	 * Removes the association between the survey answer and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey answer
	 * @param surveyQuestion the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveyQuestion(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws SystemException {
		surveyAnswerToSurveyQuestionTableMapper.deleteTableMapping(pk,
			surveyQuestion.getPrimaryKey());
	}

	/**
	 * Removes the association between the survey answer and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey answer
	 * @param surveyQuestionPKs the primary keys of the survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws SystemException {
		for (long surveyQuestionPK : surveyQuestionPKs) {
			surveyAnswerToSurveyQuestionTableMapper.deleteTableMapping(pk,
				surveyQuestionPK);
		}
	}

	/**
	 * Removes the association between the survey answer and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey answer
	 * @param surveyQuestions the survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveyQuestions(long pk,
		List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion : surveyQuestions) {
			surveyAnswerToSurveyQuestionTableMapper.deleteTableMapping(pk,
				surveyQuestion.getPrimaryKey());
		}
	}

	/**
	 * Sets the survey questions associated with the survey answer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey answer
	 * @param surveyQuestionPKs the primary keys of the survey questions to be associated with the survey answer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws SystemException {
		Set<Long> newSurveyQuestionPKsSet = SetUtil.fromArray(surveyQuestionPKs);
		Set<Long> oldSurveyQuestionPKsSet = SetUtil.fromArray(surveyAnswerToSurveyQuestionTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeSurveyQuestionPKsSet = new HashSet<Long>(oldSurveyQuestionPKsSet);

		removeSurveyQuestionPKsSet.removeAll(newSurveyQuestionPKsSet);

		for (long removeSurveyQuestionPK : removeSurveyQuestionPKsSet) {
			surveyAnswerToSurveyQuestionTableMapper.deleteTableMapping(pk,
				removeSurveyQuestionPK);
		}

		newSurveyQuestionPKsSet.removeAll(oldSurveyQuestionPKsSet);

		for (long newSurveyQuestionPK : newSurveyQuestionPKsSet) {
			surveyAnswerToSurveyQuestionTableMapper.addTableMapping(pk,
				newSurveyQuestionPK);
		}
	}

	/**
	 * Sets the survey questions associated with the survey answer, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey answer
	 * @param surveyQuestions the survey questions to be associated with the survey answer
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setSurveyQuestions(long pk,
		List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws SystemException {
		try {
			long[] surveyQuestionPKs = new long[surveyQuestions.size()];

			for (int i = 0; i < surveyQuestions.size(); i++) {
				org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion =
					surveyQuestions.get(i);

				surveyQuestionPKs[i] = surveyQuestion.getPrimaryKey();
			}

			setSurveyQuestions(pk, surveyQuestionPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SurveyAnswerModelImpl.MAPPING_TABLE_EDVIR_SURVEYQUESTIONS_SURVEYANSWERS_NAME);
		}
	}

	/**
	 * Initializes the survey answer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.virtuallaboratory.model.SurveyAnswer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SurveyAnswer>> listenersList = new ArrayList<ModelListener<SurveyAnswer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SurveyAnswer>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		surveyAnswerToSurveyQuestionTableMapper = TableMapperFactory.getTableMapper("EDVIR_SurveyQuestions_SurveyAnswers",
				"SurveyAnswerId", "questionSeqNo", this,
				surveyQuestionPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SurveyAnswerImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"EDVIR_SurveyQuestions_SurveyAnswers");
	}

	@BeanReference(type = SurveyQuestionPersistence.class)
	protected SurveyQuestionPersistence surveyQuestionPersistence;
	protected TableMapper<SurveyAnswer, org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyAnswerToSurveyQuestionTableMapper;
	private static final String _SQL_SELECT_SURVEYANSWER = "SELECT surveyAnswer FROM SurveyAnswer surveyAnswer";
	private static final String _SQL_COUNT_SURVEYANSWER = "SELECT COUNT(surveyAnswer) FROM SurveyAnswer surveyAnswer";
	private static final String _ORDER_BY_ENTITY_ALIAS = "surveyAnswer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SurveyAnswer exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SurveyAnswerPersistenceImpl.class);
	private static SurveyAnswer _nullSurveyAnswer = new SurveyAnswerImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SurveyAnswer> toCacheModel() {
				return _nullSurveyAnswerCacheModel;
			}
		};

	private static CacheModel<SurveyAnswer> _nullSurveyAnswerCacheModel = new CacheModel<SurveyAnswer>() {
			@Override
			public SurveyAnswer toEntityModel() {
				return _nullSurveyAnswer;
			}
		};
}