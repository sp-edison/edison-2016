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

package org.kisti.edison.project.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.kisti.edison.project.model.HistoryContent;

import java.util.List;

/**
 * The persistence utility for the history content service. This utility wraps {@link HistoryContentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see HistoryContentPersistence
 * @see HistoryContentPersistenceImpl
 * @generated
 */
public class HistoryContentUtil {
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
	public static void clearCache(HistoryContent historyContent) {
		getPersistence().clearCache(historyContent);
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
	public static List<HistoryContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HistoryContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HistoryContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static HistoryContent update(HistoryContent historyContent)
		throws SystemException {
		return getPersistence().update(historyContent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static HistoryContent update(HistoryContent historyContent,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(historyContent, serviceContext);
	}

	/**
	* Caches the history content in the entity cache if it is enabled.
	*
	* @param historyContent the history content
	*/
	public static void cacheResult(
		org.kisti.edison.project.model.HistoryContent historyContent) {
		getPersistence().cacheResult(historyContent);
	}

	/**
	* Caches the history contents in the entity cache if it is enabled.
	*
	* @param historyContents the history contents
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.project.model.HistoryContent> historyContents) {
		getPersistence().cacheResult(historyContents);
	}

	/**
	* Creates a new history content with the primary key. Does not add the history content to the database.
	*
	* @param historyContentPK the primary key for the new history content
	* @return the new history content
	*/
	public static org.kisti.edison.project.model.HistoryContent create(
		org.kisti.edison.project.service.persistence.HistoryContentPK historyContentPK) {
		return getPersistence().create(historyContentPK);
	}

	/**
	* Removes the history content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param historyContentPK the primary key of the history content
	* @return the history content that was removed
	* @throws org.kisti.edison.project.NoSuchHistoryContentException if a history content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.project.model.HistoryContent remove(
		org.kisti.edison.project.service.persistence.HistoryContentPK historyContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.project.NoSuchHistoryContentException {
		return getPersistence().remove(historyContentPK);
	}

	public static org.kisti.edison.project.model.HistoryContent updateImpl(
		org.kisti.edison.project.model.HistoryContent historyContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(historyContent);
	}

	/**
	* Returns the history content with the primary key or throws a {@link org.kisti.edison.project.NoSuchHistoryContentException} if it could not be found.
	*
	* @param historyContentPK the primary key of the history content
	* @return the history content
	* @throws org.kisti.edison.project.NoSuchHistoryContentException if a history content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.project.model.HistoryContent findByPrimaryKey(
		org.kisti.edison.project.service.persistence.HistoryContentPK historyContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.project.NoSuchHistoryContentException {
		return getPersistence().findByPrimaryKey(historyContentPK);
	}

	/**
	* Returns the history content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param historyContentPK the primary key of the history content
	* @return the history content, or <code>null</code> if a history content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.project.model.HistoryContent fetchByPrimaryKey(
		org.kisti.edison.project.service.persistence.HistoryContentPK historyContentPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(historyContentPK);
	}

	/**
	* Returns all the history contents.
	*
	* @return the history contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.project.model.HistoryContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the history contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.project.model.impl.HistoryContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of history contents
	* @param end the upper bound of the range of history contents (not inclusive)
	* @return the range of history contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.project.model.HistoryContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the history contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.project.model.impl.HistoryContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of history contents
	* @param end the upper bound of the range of history contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of history contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.project.model.HistoryContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the history contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of history contents.
	*
	* @return the number of history contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HistoryContentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HistoryContentPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.project.service.ClpSerializer.getServletContextName(),
					HistoryContentPersistence.class.getName());

			ReferenceRegistry.registerReference(HistoryContentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(HistoryContentPersistence persistence) {
	}

	private static HistoryContentPersistence _persistence;
}