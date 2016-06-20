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

import org.kisti.edison.virtuallaboratory.NoSuchSurveyException;
import org.kisti.edison.virtuallaboratory.model.Survey;
import org.kisti.edison.virtuallaboratory.model.impl.SurveyImpl;
import org.kisti.edison.virtuallaboratory.model.impl.SurveyModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the survey service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see SurveyPersistence
 * @see SurveyUtil
 * @generated
 */
public class SurveyPersistenceImpl extends BasePersistenceImpl<Survey>
	implements SurveyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SurveyUtil} to access the survey persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SurveyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SurveyModelImpl.ENTITY_CACHE_ENABLED,
			SurveyModelImpl.FINDER_CACHE_ENABLED, SurveyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SurveyModelImpl.ENTITY_CACHE_ENABLED,
			SurveyModelImpl.FINDER_CACHE_ENABLED, SurveyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SurveyModelImpl.ENTITY_CACHE_ENABLED,
			SurveyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SurveyPersistenceImpl() {
		setModelClass(Survey.class);
	}

	/**
	 * Caches the survey in the entity cache if it is enabled.
	 *
	 * @param survey the survey
	 */
	@Override
	public void cacheResult(Survey survey) {
		EntityCacheUtil.putResult(SurveyModelImpl.ENTITY_CACHE_ENABLED,
			SurveyImpl.class, survey.getPrimaryKey(), survey);

		survey.resetOriginalValues();
	}

	/**
	 * Caches the surveies in the entity cache if it is enabled.
	 *
	 * @param surveies the surveies
	 */
	@Override
	public void cacheResult(List<Survey> surveies) {
		for (Survey survey : surveies) {
			if (EntityCacheUtil.getResult(
						SurveyModelImpl.ENTITY_CACHE_ENABLED, SurveyImpl.class,
						survey.getPrimaryKey()) == null) {
				cacheResult(survey);
			}
			else {
				survey.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all surveies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SurveyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SurveyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the survey.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Survey survey) {
		EntityCacheUtil.removeResult(SurveyModelImpl.ENTITY_CACHE_ENABLED,
			SurveyImpl.class, survey.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Survey> surveies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Survey survey : surveies) {
			EntityCacheUtil.removeResult(SurveyModelImpl.ENTITY_CACHE_ENABLED,
				SurveyImpl.class, survey.getPrimaryKey());
		}
	}

	/**
	 * Creates a new survey with the primary key. Does not add the survey to the database.
	 *
	 * @param surveySeqNo the primary key for the new survey
	 * @return the new survey
	 */
	@Override
	public Survey create(long surveySeqNo) {
		Survey survey = new SurveyImpl();

		survey.setNew(true);
		survey.setPrimaryKey(surveySeqNo);

		return survey;
	}

	/**
	 * Removes the survey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveySeqNo the primary key of the survey
	 * @return the survey that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyException if a survey with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Survey remove(long surveySeqNo)
		throws NoSuchSurveyException, SystemException {
		return remove((Serializable)surveySeqNo);
	}

	/**
	 * Removes the survey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the survey
	 * @return the survey that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyException if a survey with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Survey remove(Serializable primaryKey)
		throws NoSuchSurveyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Survey survey = (Survey)session.get(SurveyImpl.class, primaryKey);

			if (survey == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSurveyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(survey);
		}
		catch (NoSuchSurveyException nsee) {
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
	protected Survey removeImpl(Survey survey) throws SystemException {
		survey = toUnwrappedModel(survey);

		surveyToVirtualLabTableMapper.deleteLeftPrimaryKeyTableMappings(survey.getPrimaryKey());

		surveyToSurveyQuestionTableMapper.deleteLeftPrimaryKeyTableMappings(survey.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(survey)) {
				survey = (Survey)session.get(SurveyImpl.class,
						survey.getPrimaryKeyObj());
			}

			if (survey != null) {
				session.delete(survey);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (survey != null) {
			clearCache(survey);
		}

		return survey;
	}

	@Override
	public Survey updateImpl(
		org.kisti.edison.virtuallaboratory.model.Survey survey)
		throws SystemException {
		survey = toUnwrappedModel(survey);

		boolean isNew = survey.isNew();

		Session session = null;

		try {
			session = openSession();

			if (survey.isNew()) {
				session.save(survey);

				survey.setNew(false);
			}
			else {
				session.merge(survey);
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

		EntityCacheUtil.putResult(SurveyModelImpl.ENTITY_CACHE_ENABLED,
			SurveyImpl.class, survey.getPrimaryKey(), survey);

		return survey;
	}

	protected Survey toUnwrappedModel(Survey survey) {
		if (survey instanceof SurveyImpl) {
			return survey;
		}

		SurveyImpl surveyImpl = new SurveyImpl();

		surveyImpl.setNew(survey.isNew());
		surveyImpl.setPrimaryKey(survey.getPrimaryKey());

		surveyImpl.setSurveySeqNo(survey.getSurveySeqNo());
		surveyImpl.setSurveyUseYn(survey.getSurveyUseYn());
		surveyImpl.setSurveyTitle(survey.getSurveyTitle());
		surveyImpl.setSurveyStartDate(survey.getSurveyStartDate());
		surveyImpl.setSurveyEndDate(survey.getSurveyEndDate());
		surveyImpl.setSurveyStatus(survey.getSurveyStatus());
		surveyImpl.setSurveyCreateDate(survey.getSurveyCreateDate());

		return surveyImpl;
	}

	/**
	 * Returns the survey with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey
	 * @return the survey
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyException if a survey with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Survey findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSurveyException, SystemException {
		Survey survey = fetchByPrimaryKey(primaryKey);

		if (survey == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSurveyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return survey;
	}

	/**
	 * Returns the survey with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchSurveyException} if it could not be found.
	 *
	 * @param surveySeqNo the primary key of the survey
	 * @return the survey
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchSurveyException if a survey with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Survey findByPrimaryKey(long surveySeqNo)
		throws NoSuchSurveyException, SystemException {
		return findByPrimaryKey((Serializable)surveySeqNo);
	}

	/**
	 * Returns the survey with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the survey
	 * @return the survey, or <code>null</code> if a survey with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Survey fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Survey survey = (Survey)EntityCacheUtil.getResult(SurveyModelImpl.ENTITY_CACHE_ENABLED,
				SurveyImpl.class, primaryKey);

		if (survey == _nullSurvey) {
			return null;
		}

		if (survey == null) {
			Session session = null;

			try {
				session = openSession();

				survey = (Survey)session.get(SurveyImpl.class, primaryKey);

				if (survey != null) {
					cacheResult(survey);
				}
				else {
					EntityCacheUtil.putResult(SurveyModelImpl.ENTITY_CACHE_ENABLED,
						SurveyImpl.class, primaryKey, _nullSurvey);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SurveyModelImpl.ENTITY_CACHE_ENABLED,
					SurveyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return survey;
	}

	/**
	 * Returns the survey with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveySeqNo the primary key of the survey
	 * @return the survey, or <code>null</code> if a survey with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Survey fetchByPrimaryKey(long surveySeqNo) throws SystemException {
		return fetchByPrimaryKey((Serializable)surveySeqNo);
	}

	/**
	 * Returns all the surveies.
	 *
	 * @return the surveies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Survey> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Survey> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Survey> findAll(int start, int end,
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

		List<Survey> list = (List<Survey>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SURVEY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SURVEY;

				if (pagination) {
					sql = sql.concat(SurveyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Survey>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Survey>(list);
				}
				else {
					list = (List<Survey>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the surveies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Survey survey : findAll()) {
			remove(survey);
		}
	}

	/**
	 * Returns the number of surveies.
	 *
	 * @return the number of surveies
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

				Query q = session.createQuery(_SQL_COUNT_SURVEY);

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
	 * Returns all the virtual labs associated with the survey.
	 *
	 * @param pk the primary key of the survey
	 * @return the virtual labs associated with the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		long pk) throws SystemException {
		return getVirtualLabs(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

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
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		long pk, int start, int end) throws SystemException {
		return getVirtualLabs(pk, start, end, null);
	}

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
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.VirtualLab> getVirtualLabs(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return surveyToVirtualLabTableMapper.getRightBaseModels(pk, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of virtual labs associated with the survey.
	 *
	 * @param pk the primary key of the survey
	 * @return the number of virtual labs associated with the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getVirtualLabsSize(long pk) throws SystemException {
		long[] pks = surveyToVirtualLabTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the virtual lab is associated with the survey.
	 *
	 * @param pk the primary key of the survey
	 * @param virtualLabPK the primary key of the virtual lab
	 * @return <code>true</code> if the virtual lab is associated with the survey; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsVirtualLab(long pk, long virtualLabPK)
		throws SystemException {
		return surveyToVirtualLabTableMapper.containsTableMapping(pk,
			virtualLabPK);
	}

	/**
	 * Returns <code>true</code> if the survey has any virtual labs associated with it.
	 *
	 * @param pk the primary key of the survey to check for associations with virtual labs
	 * @return <code>true</code> if the survey has any virtual labs associated with it; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsVirtualLabs(long pk) throws SystemException {
		if (getVirtualLabsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the survey and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param virtualLabPK the primary key of the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLab(long pk, long virtualLabPK)
		throws SystemException {
		surveyToVirtualLabTableMapper.addTableMapping(pk, virtualLabPK);
	}

	/**
	 * Adds an association between the survey and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param virtualLab the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLab(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws SystemException {
		surveyToVirtualLabTableMapper.addTableMapping(pk,
			virtualLab.getPrimaryKey());
	}

	/**
	 * Adds an association between the survey and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param virtualLabPKs the primary keys of the virtual labs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabs(long pk, long[] virtualLabPKs)
		throws SystemException {
		for (long virtualLabPK : virtualLabPKs) {
			surveyToVirtualLabTableMapper.addTableMapping(pk, virtualLabPK);
		}
	}

	/**
	 * Adds an association between the survey and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param virtualLabs the virtual labs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addVirtualLabs(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabs)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab : virtualLabs) {
			surveyToVirtualLabTableMapper.addTableMapping(pk,
				virtualLab.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the survey and its virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey to clear the associated virtual labs from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearVirtualLabs(long pk) throws SystemException {
		surveyToVirtualLabTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the survey and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param virtualLabPK the primary key of the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLab(long pk, long virtualLabPK)
		throws SystemException {
		surveyToVirtualLabTableMapper.deleteTableMapping(pk, virtualLabPK);
	}

	/**
	 * Removes the association between the survey and the virtual lab. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param virtualLab the virtual lab
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLab(long pk,
		org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab)
		throws SystemException {
		surveyToVirtualLabTableMapper.deleteTableMapping(pk,
			virtualLab.getPrimaryKey());
	}

	/**
	 * Removes the association between the survey and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param virtualLabPKs the primary keys of the virtual labs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabs(long pk, long[] virtualLabPKs)
		throws SystemException {
		for (long virtualLabPK : virtualLabPKs) {
			surveyToVirtualLabTableMapper.deleteTableMapping(pk, virtualLabPK);
		}
	}

	/**
	 * Removes the association between the survey and the virtual labs. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param virtualLabs the virtual labs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeVirtualLabs(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabs)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab : virtualLabs) {
			surveyToVirtualLabTableMapper.deleteTableMapping(pk,
				virtualLab.getPrimaryKey());
		}
	}

	/**
	 * Sets the virtual labs associated with the survey, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param virtualLabPKs the primary keys of the virtual labs to be associated with the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setVirtualLabs(long pk, long[] virtualLabPKs)
		throws SystemException {
		Set<Long> newVirtualLabPKsSet = SetUtil.fromArray(virtualLabPKs);
		Set<Long> oldVirtualLabPKsSet = SetUtil.fromArray(surveyToVirtualLabTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeVirtualLabPKsSet = new HashSet<Long>(oldVirtualLabPKsSet);

		removeVirtualLabPKsSet.removeAll(newVirtualLabPKsSet);

		for (long removeVirtualLabPK : removeVirtualLabPKsSet) {
			surveyToVirtualLabTableMapper.deleteTableMapping(pk,
				removeVirtualLabPK);
		}

		newVirtualLabPKsSet.removeAll(oldVirtualLabPKsSet);

		for (long newVirtualLabPK : newVirtualLabPKsSet) {
			surveyToVirtualLabTableMapper.addTableMapping(pk, newVirtualLabPK);
		}
	}

	/**
	 * Sets the virtual labs associated with the survey, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param virtualLabs the virtual labs to be associated with the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setVirtualLabs(long pk,
		List<org.kisti.edison.virtuallaboratory.model.VirtualLab> virtualLabs)
		throws SystemException {
		try {
			long[] virtualLabPKs = new long[virtualLabs.size()];

			for (int i = 0; i < virtualLabs.size(); i++) {
				org.kisti.edison.virtuallaboratory.model.VirtualLab virtualLab = virtualLabs.get(i);

				virtualLabPKs[i] = virtualLab.getPrimaryKey();
			}

			setVirtualLabs(pk, virtualLabPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			FinderCacheUtil.clearCache(SurveyModelImpl.MAPPING_TABLE_EDVIR_VIRTUALLABS_SURVEYS_NAME);
		}
	}

	/**
	 * Returns all the survey questions associated with the survey.
	 *
	 * @param pk the primary key of the survey
	 * @return the survey questions associated with the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk) throws SystemException {
		return getSurveyQuestions(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

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
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk, int start, int end) throws SystemException {
		return getSurveyQuestions(pk, start, end, null);
	}

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
	@Override
	public List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> getSurveyQuestions(
		long pk, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return surveyToSurveyQuestionTableMapper.getRightBaseModels(pk, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of survey questions associated with the survey.
	 *
	 * @param pk the primary key of the survey
	 * @return the number of survey questions associated with the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSurveyQuestionsSize(long pk) throws SystemException {
		long[] pks = surveyToSurveyQuestionTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the survey question is associated with the survey.
	 *
	 * @param pk the primary key of the survey
	 * @param surveyQuestionPK the primary key of the survey question
	 * @return <code>true</code> if the survey question is associated with the survey; <code>false</code> otherwise
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public boolean containsSurveyQuestion(long pk, long surveyQuestionPK)
		throws SystemException {
		return surveyToSurveyQuestionTableMapper.containsTableMapping(pk,
			surveyQuestionPK);
	}

	/**
	 * Returns <code>true</code> if the survey has any survey questions associated with it.
	 *
	 * @param pk the primary key of the survey to check for associations with survey questions
	 * @return <code>true</code> if the survey has any survey questions associated with it; <code>false</code> otherwise
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
	 * Adds an association between the survey and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param surveyQuestionPK the primary key of the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveyQuestion(long pk, long surveyQuestionPK)
		throws SystemException {
		surveyToSurveyQuestionTableMapper.addTableMapping(pk, surveyQuestionPK);
	}

	/**
	 * Adds an association between the survey and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param surveyQuestion the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveyQuestion(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws SystemException {
		surveyToSurveyQuestionTableMapper.addTableMapping(pk,
			surveyQuestion.getPrimaryKey());
	}

	/**
	 * Adds an association between the survey and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param surveyQuestionPKs the primary keys of the survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws SystemException {
		for (long surveyQuestionPK : surveyQuestionPKs) {
			surveyToSurveyQuestionTableMapper.addTableMapping(pk,
				surveyQuestionPK);
		}
	}

	/**
	 * Adds an association between the survey and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param surveyQuestions the survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void addSurveyQuestions(long pk,
		List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion : surveyQuestions) {
			surveyToSurveyQuestionTableMapper.addTableMapping(pk,
				surveyQuestion.getPrimaryKey());
		}
	}

	/**
	 * Clears all associations between the survey and its survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey to clear the associated survey questions from
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void clearSurveyQuestions(long pk) throws SystemException {
		surveyToSurveyQuestionTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the survey and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param surveyQuestionPK the primary key of the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveyQuestion(long pk, long surveyQuestionPK)
		throws SystemException {
		surveyToSurveyQuestionTableMapper.deleteTableMapping(pk,
			surveyQuestionPK);
	}

	/**
	 * Removes the association between the survey and the survey question. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param surveyQuestion the survey question
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveyQuestion(long pk,
		org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion)
		throws SystemException {
		surveyToSurveyQuestionTableMapper.deleteTableMapping(pk,
			surveyQuestion.getPrimaryKey());
	}

	/**
	 * Removes the association between the survey and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param surveyQuestionPKs the primary keys of the survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws SystemException {
		for (long surveyQuestionPK : surveyQuestionPKs) {
			surveyToSurveyQuestionTableMapper.deleteTableMapping(pk,
				surveyQuestionPK);
		}
	}

	/**
	 * Removes the association between the survey and the survey questions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param surveyQuestions the survey questions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeSurveyQuestions(long pk,
		List<org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyQuestions)
		throws SystemException {
		for (org.kisti.edison.virtuallaboratory.model.SurveyQuestion surveyQuestion : surveyQuestions) {
			surveyToSurveyQuestionTableMapper.deleteTableMapping(pk,
				surveyQuestion.getPrimaryKey());
		}
	}

	/**
	 * Sets the survey questions associated with the survey, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param surveyQuestionPKs the primary keys of the survey questions to be associated with the survey
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void setSurveyQuestions(long pk, long[] surveyQuestionPKs)
		throws SystemException {
		Set<Long> newSurveyQuestionPKsSet = SetUtil.fromArray(surveyQuestionPKs);
		Set<Long> oldSurveyQuestionPKsSet = SetUtil.fromArray(surveyToSurveyQuestionTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeSurveyQuestionPKsSet = new HashSet<Long>(oldSurveyQuestionPKsSet);

		removeSurveyQuestionPKsSet.removeAll(newSurveyQuestionPKsSet);

		for (long removeSurveyQuestionPK : removeSurveyQuestionPKsSet) {
			surveyToSurveyQuestionTableMapper.deleteTableMapping(pk,
				removeSurveyQuestionPK);
		}

		newSurveyQuestionPKsSet.removeAll(oldSurveyQuestionPKsSet);

		for (long newSurveyQuestionPK : newSurveyQuestionPKsSet) {
			surveyToSurveyQuestionTableMapper.addTableMapping(pk,
				newSurveyQuestionPK);
		}
	}

	/**
	 * Sets the survey questions associated with the survey, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the survey
	 * @param surveyQuestions the survey questions to be associated with the survey
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
			FinderCacheUtil.clearCache(SurveyModelImpl.MAPPING_TABLE_EDVIR_SURVEYS_SURVEYQUESTIONS_NAME);
		}
	}

	/**
	 * Initializes the survey persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.virtuallaboratory.model.Survey")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Survey>> listenersList = new ArrayList<ModelListener<Survey>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Survey>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}

		surveyToVirtualLabTableMapper = TableMapperFactory.getTableMapper("EDVIR_VirtualLabs_Surveys",
				"surveySeqNo", "virtualLabId", this, virtualLabPersistence);

		surveyToSurveyQuestionTableMapper = TableMapperFactory.getTableMapper("EDVIR_Surveys_SurveyQuestions",
				"surveySeqNo", "questionSeqNo", this, surveyQuestionPersistence);
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SurveyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("EDVIR_VirtualLabs_Surveys");
		TableMapperFactory.removeTableMapper("EDVIR_Surveys_SurveyQuestions");
	}

	@BeanReference(type = VirtualLabPersistence.class)
	protected VirtualLabPersistence virtualLabPersistence;
	protected TableMapper<Survey, org.kisti.edison.virtuallaboratory.model.VirtualLab> surveyToVirtualLabTableMapper;
	@BeanReference(type = SurveyQuestionPersistence.class)
	protected SurveyQuestionPersistence surveyQuestionPersistence;
	protected TableMapper<Survey, org.kisti.edison.virtuallaboratory.model.SurveyQuestion> surveyToSurveyQuestionTableMapper;
	private static final String _SQL_SELECT_SURVEY = "SELECT survey FROM Survey survey";
	private static final String _SQL_COUNT_SURVEY = "SELECT COUNT(survey) FROM Survey survey";
	private static final String _ORDER_BY_ENTITY_ALIAS = "survey.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Survey exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SurveyPersistenceImpl.class);
	private static Survey _nullSurvey = new SurveyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Survey> toCacheModel() {
				return _nullSurveyCacheModel;
			}
		};

	private static CacheModel<Survey> _nullSurveyCacheModel = new CacheModel<Survey>() {
			@Override
			public Survey toEntityModel() {
				return _nullSurvey;
			}
		};
}