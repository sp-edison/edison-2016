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

package org.kisti.edison.science.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.kisti.edison.science.NoSuchCommonLibException;
import org.kisti.edison.science.model.CommonLib;
import org.kisti.edison.science.model.impl.CommonLibImpl;
import org.kisti.edison.science.model.impl.CommonLibModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the common lib service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see CommonLibPersistence
 * @see CommonLibUtil
 * @generated
 */
public class CommonLibPersistenceImpl extends BasePersistenceImpl<CommonLib>
	implements CommonLibPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CommonLibUtil} to access the common lib persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CommonLibImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CommonLibModelImpl.ENTITY_CACHE_ENABLED,
			CommonLibModelImpl.FINDER_CACHE_ENABLED, CommonLibImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CommonLibModelImpl.ENTITY_CACHE_ENABLED,
			CommonLibModelImpl.FINDER_CACHE_ENABLED, CommonLibImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CommonLibModelImpl.ENTITY_CACHE_ENABLED,
			CommonLibModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBNAME = new FinderPath(CommonLibModelImpl.ENTITY_CACHE_ENABLED,
			CommonLibModelImpl.FINDER_CACHE_ENABLED, CommonLibImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_LIBNAME = new FinderPath(CommonLibModelImpl.ENTITY_CACHE_ENABLED,
			CommonLibModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByLibName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the common libs where libName LIKE &#63;.
	 *
	 * @param libName the lib name
	 * @return the matching common libs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CommonLib> findByLibName(String libName)
		throws SystemException {
		return findByLibName(libName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the common libs where libName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libName the lib name
	 * @param start the lower bound of the range of common libs
	 * @param end the upper bound of the range of common libs (not inclusive)
	 * @return the range of matching common libs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CommonLib> findByLibName(String libName, int start, int end)
		throws SystemException {
		return findByLibName(libName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the common libs where libName LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param libName the lib name
	 * @param start the lower bound of the range of common libs
	 * @param end the upper bound of the range of common libs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching common libs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CommonLib> findByLibName(String libName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LIBNAME;
		finderArgs = new Object[] { libName, start, end, orderByComparator };

		List<CommonLib> list = (List<CommonLib>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CommonLib commonLib : list) {
				if (!StringUtil.wildcardMatches(commonLib.getLibName(),
							libName, CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_COMMONLIB_WHERE);

			boolean bindLibName = false;

			if (libName == null) {
				query.append(_FINDER_COLUMN_LIBNAME_LIBNAME_1);
			}
			else if (libName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIBNAME_LIBNAME_3);
			}
			else {
				bindLibName = true;

				query.append(_FINDER_COLUMN_LIBNAME_LIBNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CommonLibModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLibName) {
					qPos.add(libName);
				}

				if (!pagination) {
					list = (List<CommonLib>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CommonLib>(list);
				}
				else {
					list = (List<CommonLib>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first common lib in the ordered set where libName LIKE &#63;.
	 *
	 * @param libName the lib name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching common lib
	 * @throws org.kisti.edison.science.NoSuchCommonLibException if a matching common lib could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonLib findByLibName_First(String libName,
		OrderByComparator orderByComparator)
		throws NoSuchCommonLibException, SystemException {
		CommonLib commonLib = fetchByLibName_First(libName, orderByComparator);

		if (commonLib != null) {
			return commonLib;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libName=");
		msg.append(libName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommonLibException(msg.toString());
	}

	/**
	 * Returns the first common lib in the ordered set where libName LIKE &#63;.
	 *
	 * @param libName the lib name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching common lib, or <code>null</code> if a matching common lib could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonLib fetchByLibName_First(String libName,
		OrderByComparator orderByComparator) throws SystemException {
		List<CommonLib> list = findByLibName(libName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last common lib in the ordered set where libName LIKE &#63;.
	 *
	 * @param libName the lib name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching common lib
	 * @throws org.kisti.edison.science.NoSuchCommonLibException if a matching common lib could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonLib findByLibName_Last(String libName,
		OrderByComparator orderByComparator)
		throws NoSuchCommonLibException, SystemException {
		CommonLib commonLib = fetchByLibName_Last(libName, orderByComparator);

		if (commonLib != null) {
			return commonLib;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("libName=");
		msg.append(libName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCommonLibException(msg.toString());
	}

	/**
	 * Returns the last common lib in the ordered set where libName LIKE &#63;.
	 *
	 * @param libName the lib name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching common lib, or <code>null</code> if a matching common lib could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonLib fetchByLibName_Last(String libName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLibName(libName);

		if (count == 0) {
			return null;
		}

		List<CommonLib> list = findByLibName(libName, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the common libs before and after the current common lib in the ordered set where libName LIKE &#63;.
	 *
	 * @param commonLibPK the primary key of the current common lib
	 * @param libName the lib name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next common lib
	 * @throws org.kisti.edison.science.NoSuchCommonLibException if a common lib with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonLib[] findByLibName_PrevAndNext(CommonLibPK commonLibPK,
		String libName, OrderByComparator orderByComparator)
		throws NoSuchCommonLibException, SystemException {
		CommonLib commonLib = findByPrimaryKey(commonLibPK);

		Session session = null;

		try {
			session = openSession();

			CommonLib[] array = new CommonLibImpl[3];

			array[0] = getByLibName_PrevAndNext(session, commonLib, libName,
					orderByComparator, true);

			array[1] = commonLib;

			array[2] = getByLibName_PrevAndNext(session, commonLib, libName,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CommonLib getByLibName_PrevAndNext(Session session,
		CommonLib commonLib, String libName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMMONLIB_WHERE);

		boolean bindLibName = false;

		if (libName == null) {
			query.append(_FINDER_COLUMN_LIBNAME_LIBNAME_1);
		}
		else if (libName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LIBNAME_LIBNAME_3);
		}
		else {
			bindLibName = true;

			query.append(_FINDER_COLUMN_LIBNAME_LIBNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CommonLibModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLibName) {
			qPos.add(libName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(commonLib);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CommonLib> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the common libs where libName LIKE &#63; from the database.
	 *
	 * @param libName the lib name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLibName(String libName) throws SystemException {
		for (CommonLib commonLib : findByLibName(libName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(commonLib);
		}
	}

	/**
	 * Returns the number of common libs where libName LIKE &#63;.
	 *
	 * @param libName the lib name
	 * @return the number of matching common libs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLibName(String libName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_LIBNAME;

		Object[] finderArgs = new Object[] { libName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMMONLIB_WHERE);

			boolean bindLibName = false;

			if (libName == null) {
				query.append(_FINDER_COLUMN_LIBNAME_LIBNAME_1);
			}
			else if (libName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LIBNAME_LIBNAME_3);
			}
			else {
				bindLibName = true;

				query.append(_FINDER_COLUMN_LIBNAME_LIBNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLibName) {
					qPos.add(libName);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_LIBNAME_LIBNAME_1 = "commonLib.id.libName LIKE NULL";
	private static final String _FINDER_COLUMN_LIBNAME_LIBNAME_2 = "commonLib.id.libName LIKE ?";
	private static final String _FINDER_COLUMN_LIBNAME_LIBNAME_3 = "(commonLib.id.libName IS NULL OR commonLib.id.libName LIKE '')";

	public CommonLibPersistenceImpl() {
		setModelClass(CommonLib.class);
	}

	/**
	 * Caches the common lib in the entity cache if it is enabled.
	 *
	 * @param commonLib the common lib
	 */
	@Override
	public void cacheResult(CommonLib commonLib) {
		EntityCacheUtil.putResult(CommonLibModelImpl.ENTITY_CACHE_ENABLED,
			CommonLibImpl.class, commonLib.getPrimaryKey(), commonLib);

		commonLib.resetOriginalValues();
	}

	/**
	 * Caches the common libs in the entity cache if it is enabled.
	 *
	 * @param commonLibs the common libs
	 */
	@Override
	public void cacheResult(List<CommonLib> commonLibs) {
		for (CommonLib commonLib : commonLibs) {
			if (EntityCacheUtil.getResult(
						CommonLibModelImpl.ENTITY_CACHE_ENABLED,
						CommonLibImpl.class, commonLib.getPrimaryKey()) == null) {
				cacheResult(commonLib);
			}
			else {
				commonLib.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all common libs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CommonLibImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CommonLibImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the common lib.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CommonLib commonLib) {
		EntityCacheUtil.removeResult(CommonLibModelImpl.ENTITY_CACHE_ENABLED,
			CommonLibImpl.class, commonLib.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CommonLib> commonLibs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CommonLib commonLib : commonLibs) {
			EntityCacheUtil.removeResult(CommonLibModelImpl.ENTITY_CACHE_ENABLED,
				CommonLibImpl.class, commonLib.getPrimaryKey());
		}
	}

	/**
	 * Creates a new common lib with the primary key. Does not add the common lib to the database.
	 *
	 * @param commonLibPK the primary key for the new common lib
	 * @return the new common lib
	 */
	@Override
	public CommonLib create(CommonLibPK commonLibPK) {
		CommonLib commonLib = new CommonLibImpl();

		commonLib.setNew(true);
		commonLib.setPrimaryKey(commonLibPK);

		return commonLib;
	}

	/**
	 * Removes the common lib with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param commonLibPK the primary key of the common lib
	 * @return the common lib that was removed
	 * @throws org.kisti.edison.science.NoSuchCommonLibException if a common lib with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonLib remove(CommonLibPK commonLibPK)
		throws NoSuchCommonLibException, SystemException {
		return remove((Serializable)commonLibPK);
	}

	/**
	 * Removes the common lib with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the common lib
	 * @return the common lib that was removed
	 * @throws org.kisti.edison.science.NoSuchCommonLibException if a common lib with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonLib remove(Serializable primaryKey)
		throws NoSuchCommonLibException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CommonLib commonLib = (CommonLib)session.get(CommonLibImpl.class,
					primaryKey);

			if (commonLib == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCommonLibException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(commonLib);
		}
		catch (NoSuchCommonLibException nsee) {
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
	protected CommonLib removeImpl(CommonLib commonLib)
		throws SystemException {
		commonLib = toUnwrappedModel(commonLib);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(commonLib)) {
				commonLib = (CommonLib)session.get(CommonLibImpl.class,
						commonLib.getPrimaryKeyObj());
			}

			if (commonLib != null) {
				session.delete(commonLib);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (commonLib != null) {
			clearCache(commonLib);
		}

		return commonLib;
	}

	@Override
	public CommonLib updateImpl(
		org.kisti.edison.science.model.CommonLib commonLib)
		throws SystemException {
		commonLib = toUnwrappedModel(commonLib);

		boolean isNew = commonLib.isNew();

		Session session = null;

		try {
			session = openSession();

			if (commonLib.isNew()) {
				session.save(commonLib);

				commonLib.setNew(false);
			}
			else {
				session.merge(commonLib);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CommonLibModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(CommonLibModelImpl.ENTITY_CACHE_ENABLED,
			CommonLibImpl.class, commonLib.getPrimaryKey(), commonLib);

		return commonLib;
	}

	protected CommonLib toUnwrappedModel(CommonLib commonLib) {
		if (commonLib instanceof CommonLibImpl) {
			return commonLib;
		}

		CommonLibImpl commonLibImpl = new CommonLibImpl();

		commonLibImpl.setNew(commonLib.isNew());
		commonLibImpl.setPrimaryKey(commonLib.getPrimaryKey());

		commonLibImpl.setLibName(commonLib.getLibName());
		commonLibImpl.setLibPath(commonLib.getLibPath());
		commonLibImpl.setLibraryVersion(commonLib.getLibraryVersion());
		commonLibImpl.setCLibVer(commonLib.getCLibVer());
		commonLibImpl.setSysArch(commonLib.getSysArch());
		commonLibImpl.setKernelVer(commonLib.getKernelVer());

		return commonLibImpl;
	}

	/**
	 * Returns the common lib with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the common lib
	 * @return the common lib
	 * @throws org.kisti.edison.science.NoSuchCommonLibException if a common lib with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonLib findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCommonLibException, SystemException {
		CommonLib commonLib = fetchByPrimaryKey(primaryKey);

		if (commonLib == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCommonLibException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return commonLib;
	}

	/**
	 * Returns the common lib with the primary key or throws a {@link org.kisti.edison.science.NoSuchCommonLibException} if it could not be found.
	 *
	 * @param commonLibPK the primary key of the common lib
	 * @return the common lib
	 * @throws org.kisti.edison.science.NoSuchCommonLibException if a common lib with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonLib findByPrimaryKey(CommonLibPK commonLibPK)
		throws NoSuchCommonLibException, SystemException {
		return findByPrimaryKey((Serializable)commonLibPK);
	}

	/**
	 * Returns the common lib with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the common lib
	 * @return the common lib, or <code>null</code> if a common lib with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonLib fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CommonLib commonLib = (CommonLib)EntityCacheUtil.getResult(CommonLibModelImpl.ENTITY_CACHE_ENABLED,
				CommonLibImpl.class, primaryKey);

		if (commonLib == _nullCommonLib) {
			return null;
		}

		if (commonLib == null) {
			Session session = null;

			try {
				session = openSession();

				commonLib = (CommonLib)session.get(CommonLibImpl.class,
						primaryKey);

				if (commonLib != null) {
					cacheResult(commonLib);
				}
				else {
					EntityCacheUtil.putResult(CommonLibModelImpl.ENTITY_CACHE_ENABLED,
						CommonLibImpl.class, primaryKey, _nullCommonLib);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CommonLibModelImpl.ENTITY_CACHE_ENABLED,
					CommonLibImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return commonLib;
	}

	/**
	 * Returns the common lib with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param commonLibPK the primary key of the common lib
	 * @return the common lib, or <code>null</code> if a common lib with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CommonLib fetchByPrimaryKey(CommonLibPK commonLibPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)commonLibPK);
	}

	/**
	 * Returns all the common libs.
	 *
	 * @return the common libs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CommonLib> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the common libs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of common libs
	 * @param end the upper bound of the range of common libs (not inclusive)
	 * @return the range of common libs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CommonLib> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the common libs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.science.model.impl.CommonLibModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of common libs
	 * @param end the upper bound of the range of common libs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of common libs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CommonLib> findAll(int start, int end,
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

		List<CommonLib> list = (List<CommonLib>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMMONLIB);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMMONLIB;

				if (pagination) {
					sql = sql.concat(CommonLibModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CommonLib>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CommonLib>(list);
				}
				else {
					list = (List<CommonLib>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the common libs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CommonLib commonLib : findAll()) {
			remove(commonLib);
		}
	}

	/**
	 * Returns the number of common libs.
	 *
	 * @return the number of common libs
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

				Query q = session.createQuery(_SQL_COUNT_COMMONLIB);

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
	 * Initializes the common lib persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.science.model.CommonLib")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CommonLib>> listenersList = new ArrayList<ModelListener<CommonLib>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CommonLib>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CommonLibImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COMMONLIB = "SELECT commonLib FROM CommonLib commonLib";
	private static final String _SQL_SELECT_COMMONLIB_WHERE = "SELECT commonLib FROM CommonLib commonLib WHERE ";
	private static final String _SQL_COUNT_COMMONLIB = "SELECT COUNT(commonLib) FROM CommonLib commonLib";
	private static final String _SQL_COUNT_COMMONLIB_WHERE = "SELECT COUNT(commonLib) FROM CommonLib commonLib WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "commonLib.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CommonLib exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CommonLib exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CommonLibPersistenceImpl.class);
	private static CommonLib _nullCommonLib = new CommonLibImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CommonLib> toCacheModel() {
				return _nullCommonLibCacheModel;
			}
		};

	private static CacheModel<CommonLib> _nullCommonLibCacheModel = new CacheModel<CommonLib>() {
			@Override
			public CommonLib toEntityModel() {
				return _nullCommonLib;
			}
		};
}