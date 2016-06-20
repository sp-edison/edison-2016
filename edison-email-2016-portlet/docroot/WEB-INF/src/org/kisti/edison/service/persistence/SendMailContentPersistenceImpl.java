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

package org.kisti.edison.service.persistence;

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

import org.kisti.edison.NoSuchSendMailContentException;
import org.kisti.edison.model.SendMailContent;
import org.kisti.edison.model.impl.SendMailContentImpl;
import org.kisti.edison.model.impl.SendMailContentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the send mail content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see SendMailContentPersistence
 * @see SendMailContentUtil
 * @generated
 */
public class SendMailContentPersistenceImpl extends BasePersistenceImpl<SendMailContent>
	implements SendMailContentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SendMailContentUtil} to access the send mail content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SendMailContentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SendMailContentModelImpl.ENTITY_CACHE_ENABLED,
			SendMailContentModelImpl.FINDER_CACHE_ENABLED,
			SendMailContentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SendMailContentModelImpl.ENTITY_CACHE_ENABLED,
			SendMailContentModelImpl.FINDER_CACHE_ENABLED,
			SendMailContentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SendMailContentModelImpl.ENTITY_CACHE_ENABLED,
			SendMailContentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SendMailContentPersistenceImpl() {
		setModelClass(SendMailContent.class);
	}

	/**
	 * Caches the send mail content in the entity cache if it is enabled.
	 *
	 * @param sendMailContent the send mail content
	 */
	@Override
	public void cacheResult(SendMailContent sendMailContent) {
		EntityCacheUtil.putResult(SendMailContentModelImpl.ENTITY_CACHE_ENABLED,
			SendMailContentImpl.class, sendMailContent.getPrimaryKey(),
			sendMailContent);

		sendMailContent.resetOriginalValues();
	}

	/**
	 * Caches the send mail contents in the entity cache if it is enabled.
	 *
	 * @param sendMailContents the send mail contents
	 */
	@Override
	public void cacheResult(List<SendMailContent> sendMailContents) {
		for (SendMailContent sendMailContent : sendMailContents) {
			if (EntityCacheUtil.getResult(
						SendMailContentModelImpl.ENTITY_CACHE_ENABLED,
						SendMailContentImpl.class,
						sendMailContent.getPrimaryKey()) == null) {
				cacheResult(sendMailContent);
			}
			else {
				sendMailContent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all send mail contents.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SendMailContentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SendMailContentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the send mail content.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SendMailContent sendMailContent) {
		EntityCacheUtil.removeResult(SendMailContentModelImpl.ENTITY_CACHE_ENABLED,
			SendMailContentImpl.class, sendMailContent.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SendMailContent> sendMailContents) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SendMailContent sendMailContent : sendMailContents) {
			EntityCacheUtil.removeResult(SendMailContentModelImpl.ENTITY_CACHE_ENABLED,
				SendMailContentImpl.class, sendMailContent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new send mail content with the primary key. Does not add the send mail content to the database.
	 *
	 * @param sendMailId the primary key for the new send mail content
	 * @return the new send mail content
	 */
	@Override
	public SendMailContent create(long sendMailId) {
		SendMailContent sendMailContent = new SendMailContentImpl();

		sendMailContent.setNew(true);
		sendMailContent.setPrimaryKey(sendMailId);

		return sendMailContent;
	}

	/**
	 * Removes the send mail content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sendMailId the primary key of the send mail content
	 * @return the send mail content that was removed
	 * @throws org.kisti.edison.NoSuchSendMailContentException if a send mail content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SendMailContent remove(long sendMailId)
		throws NoSuchSendMailContentException, SystemException {
		return remove((Serializable)sendMailId);
	}

	/**
	 * Removes the send mail content with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the send mail content
	 * @return the send mail content that was removed
	 * @throws org.kisti.edison.NoSuchSendMailContentException if a send mail content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SendMailContent remove(Serializable primaryKey)
		throws NoSuchSendMailContentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SendMailContent sendMailContent = (SendMailContent)session.get(SendMailContentImpl.class,
					primaryKey);

			if (sendMailContent == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSendMailContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sendMailContent);
		}
		catch (NoSuchSendMailContentException nsee) {
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
	protected SendMailContent removeImpl(SendMailContent sendMailContent)
		throws SystemException {
		sendMailContent = toUnwrappedModel(sendMailContent);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sendMailContent)) {
				sendMailContent = (SendMailContent)session.get(SendMailContentImpl.class,
						sendMailContent.getPrimaryKeyObj());
			}

			if (sendMailContent != null) {
				session.delete(sendMailContent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sendMailContent != null) {
			clearCache(sendMailContent);
		}

		return sendMailContent;
	}

	@Override
	public SendMailContent updateImpl(
		org.kisti.edison.model.SendMailContent sendMailContent)
		throws SystemException {
		sendMailContent = toUnwrappedModel(sendMailContent);

		boolean isNew = sendMailContent.isNew();

		Session session = null;

		try {
			session = openSession();

			if (sendMailContent.isNew()) {
				session.save(sendMailContent);

				sendMailContent.setNew(false);
			}
			else {
				session.merge(sendMailContent);
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

		EntityCacheUtil.putResult(SendMailContentModelImpl.ENTITY_CACHE_ENABLED,
			SendMailContentImpl.class, sendMailContent.getPrimaryKey(),
			sendMailContent);

		return sendMailContent;
	}

	protected SendMailContent toUnwrappedModel(SendMailContent sendMailContent) {
		if (sendMailContent instanceof SendMailContentImpl) {
			return sendMailContent;
		}

		SendMailContentImpl sendMailContentImpl = new SendMailContentImpl();

		sendMailContentImpl.setNew(sendMailContent.isNew());
		sendMailContentImpl.setPrimaryKey(sendMailContent.getPrimaryKey());

		sendMailContentImpl.setSendMailId(sendMailContent.getSendMailId());
		sendMailContentImpl.setUserId(sendMailContent.getUserId());
		sendMailContentImpl.setSendCount(sendMailContent.getSendCount());
		sendMailContentImpl.setSuccessCount(sendMailContent.getSuccessCount());
		sendMailContentImpl.setFailCount(sendMailContent.getFailCount());
		sendMailContentImpl.setSendDate(sendMailContent.getSendDate());
		sendMailContentImpl.setSiteGroup(sendMailContent.getSiteGroup());
		sendMailContentImpl.setUserGroup(sendMailContent.getUserGroup());
		sendMailContentImpl.setState(sendMailContent.getState());
		sendMailContentImpl.setTitle(sendMailContent.getTitle());
		sendMailContentImpl.setContent(sendMailContent.getContent());

		return sendMailContentImpl;
	}

	/**
	 * Returns the send mail content with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the send mail content
	 * @return the send mail content
	 * @throws org.kisti.edison.NoSuchSendMailContentException if a send mail content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SendMailContent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSendMailContentException, SystemException {
		SendMailContent sendMailContent = fetchByPrimaryKey(primaryKey);

		if (sendMailContent == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSendMailContentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sendMailContent;
	}

	/**
	 * Returns the send mail content with the primary key or throws a {@link org.kisti.edison.NoSuchSendMailContentException} if it could not be found.
	 *
	 * @param sendMailId the primary key of the send mail content
	 * @return the send mail content
	 * @throws org.kisti.edison.NoSuchSendMailContentException if a send mail content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SendMailContent findByPrimaryKey(long sendMailId)
		throws NoSuchSendMailContentException, SystemException {
		return findByPrimaryKey((Serializable)sendMailId);
	}

	/**
	 * Returns the send mail content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the send mail content
	 * @return the send mail content, or <code>null</code> if a send mail content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SendMailContent fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SendMailContent sendMailContent = (SendMailContent)EntityCacheUtil.getResult(SendMailContentModelImpl.ENTITY_CACHE_ENABLED,
				SendMailContentImpl.class, primaryKey);

		if (sendMailContent == _nullSendMailContent) {
			return null;
		}

		if (sendMailContent == null) {
			Session session = null;

			try {
				session = openSession();

				sendMailContent = (SendMailContent)session.get(SendMailContentImpl.class,
						primaryKey);

				if (sendMailContent != null) {
					cacheResult(sendMailContent);
				}
				else {
					EntityCacheUtil.putResult(SendMailContentModelImpl.ENTITY_CACHE_ENABLED,
						SendMailContentImpl.class, primaryKey,
						_nullSendMailContent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SendMailContentModelImpl.ENTITY_CACHE_ENABLED,
					SendMailContentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sendMailContent;
	}

	/**
	 * Returns the send mail content with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sendMailId the primary key of the send mail content
	 * @return the send mail content, or <code>null</code> if a send mail content with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SendMailContent fetchByPrimaryKey(long sendMailId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)sendMailId);
	}

	/**
	 * Returns all the send mail contents.
	 *
	 * @return the send mail contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SendMailContent> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the send mail contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.SendMailContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of send mail contents
	 * @param end the upper bound of the range of send mail contents (not inclusive)
	 * @return the range of send mail contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SendMailContent> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the send mail contents.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.SendMailContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of send mail contents
	 * @param end the upper bound of the range of send mail contents (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of send mail contents
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SendMailContent> findAll(int start, int end,
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

		List<SendMailContent> list = (List<SendMailContent>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SENDMAILCONTENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SENDMAILCONTENT;

				if (pagination) {
					sql = sql.concat(SendMailContentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SendMailContent>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SendMailContent>(list);
				}
				else {
					list = (List<SendMailContent>)QueryUtil.list(q,
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
	 * Removes all the send mail contents from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SendMailContent sendMailContent : findAll()) {
			remove(sendMailContent);
		}
	}

	/**
	 * Returns the number of send mail contents.
	 *
	 * @return the number of send mail contents
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

				Query q = session.createQuery(_SQL_COUNT_SENDMAILCONTENT);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the send mail content persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.model.SendMailContent")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SendMailContent>> listenersList = new ArrayList<ModelListener<SendMailContent>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SendMailContent>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SendMailContentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SENDMAILCONTENT = "SELECT sendMailContent FROM SendMailContent sendMailContent";
	private static final String _SQL_COUNT_SENDMAILCONTENT = "SELECT COUNT(sendMailContent) FROM SendMailContent sendMailContent";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sendMailContent.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SendMailContent exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SendMailContentPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"state"
			});
	private static SendMailContent _nullSendMailContent = new SendMailContentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SendMailContent> toCacheModel() {
				return _nullSendMailContentCacheModel;
			}
		};

	private static CacheModel<SendMailContent> _nullSendMailContentCacheModel = new CacheModel<SendMailContent>() {
			@Override
			public SendMailContent toEntityModel() {
				return _nullSendMailContent;
			}
		};
}