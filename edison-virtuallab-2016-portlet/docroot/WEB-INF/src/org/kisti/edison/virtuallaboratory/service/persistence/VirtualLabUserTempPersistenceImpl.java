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

import org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException;
import org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempImpl;
import org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the virtual lab user temp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see VirtualLabUserTempPersistence
 * @see VirtualLabUserTempUtil
 * @generated
 */
public class VirtualLabUserTempPersistenceImpl extends BasePersistenceImpl<VirtualLabUserTemp>
	implements VirtualLabUserTempPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VirtualLabUserTempUtil} to access the virtual lab user temp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VirtualLabUserTempImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserTempModelImpl.FINDER_CACHE_ENABLED,
			VirtualLabUserTempImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserTempModelImpl.FINDER_CACHE_ENABLED,
			VirtualLabUserTempImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserTempModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GETLISTTEMPUSER =
		new FinderPath(VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserTempModelImpl.FINDER_CACHE_ENABLED,
			VirtualLabUserTempImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBygetListTempUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETLISTTEMPUSER =
		new FinderPath(VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserTempModelImpl.FINDER_CACHE_ENABLED,
			VirtualLabUserTempImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBygetListTempUser",
			new String[] { Long.class.getName(), Long.class.getName() },
			VirtualLabUserTempModelImpl.VIRTUALLABID_COLUMN_BITMASK |
			VirtualLabUserTempModelImpl.CLASSID_COLUMN_BITMASK |
			VirtualLabUserTempModelImpl.USERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GETLISTTEMPUSER = new FinderPath(VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserTempModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygetListTempUser",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the virtual lab user temps where virtualLabId = &#63; and classId = &#63;.
	 *
	 * @param virtualLabId the virtual lab ID
	 * @param classId the class ID
	 * @return the matching virtual lab user temps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabUserTemp> findBygetListTempUser(long virtualLabId,
		long classId) throws SystemException {
		return findBygetListTempUser(virtualLabId, classId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the virtual lab user temps where virtualLabId = &#63; and classId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param virtualLabId the virtual lab ID
	 * @param classId the class ID
	 * @param start the lower bound of the range of virtual lab user temps
	 * @param end the upper bound of the range of virtual lab user temps (not inclusive)
	 * @return the range of matching virtual lab user temps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabUserTemp> findBygetListTempUser(long virtualLabId,
		long classId, int start, int end) throws SystemException {
		return findBygetListTempUser(virtualLabId, classId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the virtual lab user temps where virtualLabId = &#63; and classId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param virtualLabId the virtual lab ID
	 * @param classId the class ID
	 * @param start the lower bound of the range of virtual lab user temps
	 * @param end the upper bound of the range of virtual lab user temps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching virtual lab user temps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabUserTemp> findBygetListTempUser(long virtualLabId,
		long classId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETLISTTEMPUSER;
			finderArgs = new Object[] { virtualLabId, classId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GETLISTTEMPUSER;
			finderArgs = new Object[] {
					virtualLabId, classId,
					
					start, end, orderByComparator
				};
		}

		List<VirtualLabUserTemp> list = (List<VirtualLabUserTemp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VirtualLabUserTemp virtualLabUserTemp : list) {
				if ((virtualLabId != virtualLabUserTemp.getVirtualLabId()) ||
						(classId != virtualLabUserTemp.getClassId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VIRTUALLABUSERTEMP_WHERE);

			query.append(_FINDER_COLUMN_GETLISTTEMPUSER_VIRTUALLABID_2);

			query.append(_FINDER_COLUMN_GETLISTTEMPUSER_CLASSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VirtualLabUserTempModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(virtualLabId);

				qPos.add(classId);

				if (!pagination) {
					list = (List<VirtualLabUserTemp>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VirtualLabUserTemp>(list);
				}
				else {
					list = (List<VirtualLabUserTemp>)QueryUtil.list(q,
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
	 * Returns the first virtual lab user temp in the ordered set where virtualLabId = &#63; and classId = &#63;.
	 *
	 * @param virtualLabId the virtual lab ID
	 * @param classId the class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching virtual lab user temp
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a matching virtual lab user temp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUserTemp findBygetListTempUser_First(long virtualLabId,
		long classId, OrderByComparator orderByComparator)
		throws NoSuchVirtualLabUserTempException, SystemException {
		VirtualLabUserTemp virtualLabUserTemp = fetchBygetListTempUser_First(virtualLabId,
				classId, orderByComparator);

		if (virtualLabUserTemp != null) {
			return virtualLabUserTemp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("virtualLabId=");
		msg.append(virtualLabId);

		msg.append(", classId=");
		msg.append(classId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVirtualLabUserTempException(msg.toString());
	}

	/**
	 * Returns the first virtual lab user temp in the ordered set where virtualLabId = &#63; and classId = &#63;.
	 *
	 * @param virtualLabId the virtual lab ID
	 * @param classId the class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching virtual lab user temp, or <code>null</code> if a matching virtual lab user temp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUserTemp fetchBygetListTempUser_First(long virtualLabId,
		long classId, OrderByComparator orderByComparator)
		throws SystemException {
		List<VirtualLabUserTemp> list = findBygetListTempUser(virtualLabId,
				classId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last virtual lab user temp in the ordered set where virtualLabId = &#63; and classId = &#63;.
	 *
	 * @param virtualLabId the virtual lab ID
	 * @param classId the class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching virtual lab user temp
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a matching virtual lab user temp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUserTemp findBygetListTempUser_Last(long virtualLabId,
		long classId, OrderByComparator orderByComparator)
		throws NoSuchVirtualLabUserTempException, SystemException {
		VirtualLabUserTemp virtualLabUserTemp = fetchBygetListTempUser_Last(virtualLabId,
				classId, orderByComparator);

		if (virtualLabUserTemp != null) {
			return virtualLabUserTemp;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("virtualLabId=");
		msg.append(virtualLabId);

		msg.append(", classId=");
		msg.append(classId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVirtualLabUserTempException(msg.toString());
	}

	/**
	 * Returns the last virtual lab user temp in the ordered set where virtualLabId = &#63; and classId = &#63;.
	 *
	 * @param virtualLabId the virtual lab ID
	 * @param classId the class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching virtual lab user temp, or <code>null</code> if a matching virtual lab user temp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUserTemp fetchBygetListTempUser_Last(long virtualLabId,
		long classId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBygetListTempUser(virtualLabId, classId);

		if (count == 0) {
			return null;
		}

		List<VirtualLabUserTemp> list = findBygetListTempUser(virtualLabId,
				classId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the virtual lab user temps before and after the current virtual lab user temp in the ordered set where virtualLabId = &#63; and classId = &#63;.
	 *
	 * @param virtualLabUserTempPK the primary key of the current virtual lab user temp
	 * @param virtualLabId the virtual lab ID
	 * @param classId the class ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next virtual lab user temp
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a virtual lab user temp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUserTemp[] findBygetListTempUser_PrevAndNext(
		VirtualLabUserTempPK virtualLabUserTempPK, long virtualLabId,
		long classId, OrderByComparator orderByComparator)
		throws NoSuchVirtualLabUserTempException, SystemException {
		VirtualLabUserTemp virtualLabUserTemp = findByPrimaryKey(virtualLabUserTempPK);

		Session session = null;

		try {
			session = openSession();

			VirtualLabUserTemp[] array = new VirtualLabUserTempImpl[3];

			array[0] = getBygetListTempUser_PrevAndNext(session,
					virtualLabUserTemp, virtualLabId, classId,
					orderByComparator, true);

			array[1] = virtualLabUserTemp;

			array[2] = getBygetListTempUser_PrevAndNext(session,
					virtualLabUserTemp, virtualLabId, classId,
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

	protected VirtualLabUserTemp getBygetListTempUser_PrevAndNext(
		Session session, VirtualLabUserTemp virtualLabUserTemp,
		long virtualLabId, long classId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIRTUALLABUSERTEMP_WHERE);

		query.append(_FINDER_COLUMN_GETLISTTEMPUSER_VIRTUALLABID_2);

		query.append(_FINDER_COLUMN_GETLISTTEMPUSER_CLASSID_2);

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
			query.append(VirtualLabUserTempModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(virtualLabId);

		qPos.add(classId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(virtualLabUserTemp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VirtualLabUserTemp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the virtual lab user temps where virtualLabId = &#63; and classId = &#63; from the database.
	 *
	 * @param virtualLabId the virtual lab ID
	 * @param classId the class ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBygetListTempUser(long virtualLabId, long classId)
		throws SystemException {
		for (VirtualLabUserTemp virtualLabUserTemp : findBygetListTempUser(
				virtualLabId, classId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(virtualLabUserTemp);
		}
	}

	/**
	 * Returns the number of virtual lab user temps where virtualLabId = &#63; and classId = &#63;.
	 *
	 * @param virtualLabId the virtual lab ID
	 * @param classId the class ID
	 * @return the number of matching virtual lab user temps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBygetListTempUser(long virtualLabId, long classId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GETLISTTEMPUSER;

		Object[] finderArgs = new Object[] { virtualLabId, classId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIRTUALLABUSERTEMP_WHERE);

			query.append(_FINDER_COLUMN_GETLISTTEMPUSER_VIRTUALLABID_2);

			query.append(_FINDER_COLUMN_GETLISTTEMPUSER_CLASSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(virtualLabId);

				qPos.add(classId);

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

	private static final String _FINDER_COLUMN_GETLISTTEMPUSER_VIRTUALLABID_2 = "virtualLabUserTemp.id.virtualLabId = ? AND ";
	private static final String _FINDER_COLUMN_GETLISTTEMPUSER_CLASSID_2 = "virtualLabUserTemp.id.classId = ?";

	public VirtualLabUserTempPersistenceImpl() {
		setModelClass(VirtualLabUserTemp.class);
	}

	/**
	 * Caches the virtual lab user temp in the entity cache if it is enabled.
	 *
	 * @param virtualLabUserTemp the virtual lab user temp
	 */
	@Override
	public void cacheResult(VirtualLabUserTemp virtualLabUserTemp) {
		EntityCacheUtil.putResult(VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserTempImpl.class, virtualLabUserTemp.getPrimaryKey(),
			virtualLabUserTemp);

		virtualLabUserTemp.resetOriginalValues();
	}

	/**
	 * Caches the virtual lab user temps in the entity cache if it is enabled.
	 *
	 * @param virtualLabUserTemps the virtual lab user temps
	 */
	@Override
	public void cacheResult(List<VirtualLabUserTemp> virtualLabUserTemps) {
		for (VirtualLabUserTemp virtualLabUserTemp : virtualLabUserTemps) {
			if (EntityCacheUtil.getResult(
						VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
						VirtualLabUserTempImpl.class,
						virtualLabUserTemp.getPrimaryKey()) == null) {
				cacheResult(virtualLabUserTemp);
			}
			else {
				virtualLabUserTemp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all virtual lab user temps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VirtualLabUserTempImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VirtualLabUserTempImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the virtual lab user temp.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VirtualLabUserTemp virtualLabUserTemp) {
		EntityCacheUtil.removeResult(VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserTempImpl.class, virtualLabUserTemp.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VirtualLabUserTemp> virtualLabUserTemps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VirtualLabUserTemp virtualLabUserTemp : virtualLabUserTemps) {
			EntityCacheUtil.removeResult(VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
				VirtualLabUserTempImpl.class, virtualLabUserTemp.getPrimaryKey());
		}
	}

	/**
	 * Creates a new virtual lab user temp with the primary key. Does not add the virtual lab user temp to the database.
	 *
	 * @param virtualLabUserTempPK the primary key for the new virtual lab user temp
	 * @return the new virtual lab user temp
	 */
	@Override
	public VirtualLabUserTemp create(VirtualLabUserTempPK virtualLabUserTempPK) {
		VirtualLabUserTemp virtualLabUserTemp = new VirtualLabUserTempImpl();

		virtualLabUserTemp.setNew(true);
		virtualLabUserTemp.setPrimaryKey(virtualLabUserTempPK);

		return virtualLabUserTemp;
	}

	/**
	 * Removes the virtual lab user temp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param virtualLabUserTempPK the primary key of the virtual lab user temp
	 * @return the virtual lab user temp that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a virtual lab user temp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUserTemp remove(VirtualLabUserTempPK virtualLabUserTempPK)
		throws NoSuchVirtualLabUserTempException, SystemException {
		return remove((Serializable)virtualLabUserTempPK);
	}

	/**
	 * Removes the virtual lab user temp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the virtual lab user temp
	 * @return the virtual lab user temp that was removed
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a virtual lab user temp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUserTemp remove(Serializable primaryKey)
		throws NoSuchVirtualLabUserTempException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VirtualLabUserTemp virtualLabUserTemp = (VirtualLabUserTemp)session.get(VirtualLabUserTempImpl.class,
					primaryKey);

			if (virtualLabUserTemp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVirtualLabUserTempException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(virtualLabUserTemp);
		}
		catch (NoSuchVirtualLabUserTempException nsee) {
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
	protected VirtualLabUserTemp removeImpl(
		VirtualLabUserTemp virtualLabUserTemp) throws SystemException {
		virtualLabUserTemp = toUnwrappedModel(virtualLabUserTemp);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(virtualLabUserTemp)) {
				virtualLabUserTemp = (VirtualLabUserTemp)session.get(VirtualLabUserTempImpl.class,
						virtualLabUserTemp.getPrimaryKeyObj());
			}

			if (virtualLabUserTemp != null) {
				session.delete(virtualLabUserTemp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (virtualLabUserTemp != null) {
			clearCache(virtualLabUserTemp);
		}

		return virtualLabUserTemp;
	}

	@Override
	public VirtualLabUserTemp updateImpl(
		org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp virtualLabUserTemp)
		throws SystemException {
		virtualLabUserTemp = toUnwrappedModel(virtualLabUserTemp);

		boolean isNew = virtualLabUserTemp.isNew();

		VirtualLabUserTempModelImpl virtualLabUserTempModelImpl = (VirtualLabUserTempModelImpl)virtualLabUserTemp;

		Session session = null;

		try {
			session = openSession();

			if (virtualLabUserTemp.isNew()) {
				session.save(virtualLabUserTemp);

				virtualLabUserTemp.setNew(false);
			}
			else {
				session.merge(virtualLabUserTemp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VirtualLabUserTempModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((virtualLabUserTempModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETLISTTEMPUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						virtualLabUserTempModelImpl.getOriginalVirtualLabId(),
						virtualLabUserTempModelImpl.getOriginalClassId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GETLISTTEMPUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETLISTTEMPUSER,
					args);

				args = new Object[] {
						virtualLabUserTempModelImpl.getVirtualLabId(),
						virtualLabUserTempModelImpl.getClassId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GETLISTTEMPUSER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GETLISTTEMPUSER,
					args);
			}
		}

		EntityCacheUtil.putResult(VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
			VirtualLabUserTempImpl.class, virtualLabUserTemp.getPrimaryKey(),
			virtualLabUserTemp);

		return virtualLabUserTemp;
	}

	protected VirtualLabUserTemp toUnwrappedModel(
		VirtualLabUserTemp virtualLabUserTemp) {
		if (virtualLabUserTemp instanceof VirtualLabUserTempImpl) {
			return virtualLabUserTemp;
		}

		VirtualLabUserTempImpl virtualLabUserTempImpl = new VirtualLabUserTempImpl();

		virtualLabUserTempImpl.setNew(virtualLabUserTemp.isNew());
		virtualLabUserTempImpl.setPrimaryKey(virtualLabUserTemp.getPrimaryKey());

		virtualLabUserTempImpl.setSeqNo(virtualLabUserTemp.getSeqNo());
		virtualLabUserTempImpl.setVirtualLabId(virtualLabUserTemp.getVirtualLabId());
		virtualLabUserTempImpl.setClassId(virtualLabUserTemp.getClassId());
		virtualLabUserTempImpl.setUserStudentNumber(virtualLabUserTemp.getUserStudentNumber());
		virtualLabUserTempImpl.setUserName(virtualLabUserTemp.getUserName());
		virtualLabUserTempImpl.setStatus(virtualLabUserTemp.isStatus());

		return virtualLabUserTempImpl;
	}

	/**
	 * Returns the virtual lab user temp with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the virtual lab user temp
	 * @return the virtual lab user temp
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a virtual lab user temp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUserTemp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVirtualLabUserTempException, SystemException {
		VirtualLabUserTemp virtualLabUserTemp = fetchByPrimaryKey(primaryKey);

		if (virtualLabUserTemp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVirtualLabUserTempException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return virtualLabUserTemp;
	}

	/**
	 * Returns the virtual lab user temp with the primary key or throws a {@link org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException} if it could not be found.
	 *
	 * @param virtualLabUserTempPK the primary key of the virtual lab user temp
	 * @return the virtual lab user temp
	 * @throws org.kisti.edison.virtuallaboratory.NoSuchVirtualLabUserTempException if a virtual lab user temp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUserTemp findByPrimaryKey(
		VirtualLabUserTempPK virtualLabUserTempPK)
		throws NoSuchVirtualLabUserTempException, SystemException {
		return findByPrimaryKey((Serializable)virtualLabUserTempPK);
	}

	/**
	 * Returns the virtual lab user temp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the virtual lab user temp
	 * @return the virtual lab user temp, or <code>null</code> if a virtual lab user temp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUserTemp fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VirtualLabUserTemp virtualLabUserTemp = (VirtualLabUserTemp)EntityCacheUtil.getResult(VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
				VirtualLabUserTempImpl.class, primaryKey);

		if (virtualLabUserTemp == _nullVirtualLabUserTemp) {
			return null;
		}

		if (virtualLabUserTemp == null) {
			Session session = null;

			try {
				session = openSession();

				virtualLabUserTemp = (VirtualLabUserTemp)session.get(VirtualLabUserTempImpl.class,
						primaryKey);

				if (virtualLabUserTemp != null) {
					cacheResult(virtualLabUserTemp);
				}
				else {
					EntityCacheUtil.putResult(VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
						VirtualLabUserTempImpl.class, primaryKey,
						_nullVirtualLabUserTemp);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VirtualLabUserTempModelImpl.ENTITY_CACHE_ENABLED,
					VirtualLabUserTempImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return virtualLabUserTemp;
	}

	/**
	 * Returns the virtual lab user temp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param virtualLabUserTempPK the primary key of the virtual lab user temp
	 * @return the virtual lab user temp, or <code>null</code> if a virtual lab user temp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VirtualLabUserTemp fetchByPrimaryKey(
		VirtualLabUserTempPK virtualLabUserTempPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)virtualLabUserTempPK);
	}

	/**
	 * Returns all the virtual lab user temps.
	 *
	 * @return the virtual lab user temps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabUserTemp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the virtual lab user temps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of virtual lab user temps
	 * @param end the upper bound of the range of virtual lab user temps (not inclusive)
	 * @return the range of virtual lab user temps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabUserTemp> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the virtual lab user temps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.virtuallaboratory.model.impl.VirtualLabUserTempModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of virtual lab user temps
	 * @param end the upper bound of the range of virtual lab user temps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of virtual lab user temps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VirtualLabUserTemp> findAll(int start, int end,
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

		List<VirtualLabUserTemp> list = (List<VirtualLabUserTemp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VIRTUALLABUSERTEMP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIRTUALLABUSERTEMP;

				if (pagination) {
					sql = sql.concat(VirtualLabUserTempModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VirtualLabUserTemp>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VirtualLabUserTemp>(list);
				}
				else {
					list = (List<VirtualLabUserTemp>)QueryUtil.list(q,
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
	 * Removes all the virtual lab user temps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VirtualLabUserTemp virtualLabUserTemp : findAll()) {
			remove(virtualLabUserTemp);
		}
	}

	/**
	 * Returns the number of virtual lab user temps.
	 *
	 * @return the number of virtual lab user temps
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

				Query q = session.createQuery(_SQL_COUNT_VIRTUALLABUSERTEMP);

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
	 * Initializes the virtual lab user temp persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.org.kisti.edison.virtuallaboratory.model.VirtualLabUserTemp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VirtualLabUserTemp>> listenersList = new ArrayList<ModelListener<VirtualLabUserTemp>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VirtualLabUserTemp>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VirtualLabUserTempImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VIRTUALLABUSERTEMP = "SELECT virtualLabUserTemp FROM VirtualLabUserTemp virtualLabUserTemp";
	private static final String _SQL_SELECT_VIRTUALLABUSERTEMP_WHERE = "SELECT virtualLabUserTemp FROM VirtualLabUserTemp virtualLabUserTemp WHERE ";
	private static final String _SQL_COUNT_VIRTUALLABUSERTEMP = "SELECT COUNT(virtualLabUserTemp) FROM VirtualLabUserTemp virtualLabUserTemp";
	private static final String _SQL_COUNT_VIRTUALLABUSERTEMP_WHERE = "SELECT COUNT(virtualLabUserTemp) FROM VirtualLabUserTemp virtualLabUserTemp WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "virtualLabUserTemp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VirtualLabUserTemp exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VirtualLabUserTemp exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VirtualLabUserTempPersistenceImpl.class);
	private static VirtualLabUserTemp _nullVirtualLabUserTemp = new VirtualLabUserTempImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VirtualLabUserTemp> toCacheModel() {
				return _nullVirtualLabUserTempCacheModel;
			}
		};

	private static CacheModel<VirtualLabUserTemp> _nullVirtualLabUserTempCacheModel =
		new CacheModel<VirtualLabUserTemp>() {
			@Override
			public VirtualLabUserTemp toEntityModel() {
				return _nullVirtualLabUserTemp;
			}
		};
}