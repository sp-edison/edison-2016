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

import com.liferay.portal.service.persistence.BasePersistence;

import org.kisti.edison.project.model.HistoryContent;

/**
 * The persistence interface for the history content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see HistoryContentPersistenceImpl
 * @see HistoryContentUtil
 * @generated
 */
public interface HistoryContentPersistence extends BasePersistence<HistoryContent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HistoryContentUtil} to access the history content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the history content in the entity cache if it is enabled.
	*
	* @param historyContent the history content
	*/
	public void cacheResult(
		org.kisti.edison.project.model.HistoryContent historyContent);

	/**
	* Caches the history contents in the entity cache if it is enabled.
	*
	* @param historyContents the history contents
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.project.model.HistoryContent> historyContents);

	/**
	* Creates a new history content with the primary key. Does not add the history content to the database.
	*
	* @param historyContentPK the primary key for the new history content
	* @return the new history content
	*/
	public org.kisti.edison.project.model.HistoryContent create(
		org.kisti.edison.project.service.persistence.HistoryContentPK historyContentPK);

	/**
	* Removes the history content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param historyContentPK the primary key of the history content
	* @return the history content that was removed
	* @throws org.kisti.edison.project.NoSuchHistoryContentException if a history content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.project.model.HistoryContent remove(
		org.kisti.edison.project.service.persistence.HistoryContentPK historyContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.project.NoSuchHistoryContentException;

	public org.kisti.edison.project.model.HistoryContent updateImpl(
		org.kisti.edison.project.model.HistoryContent historyContent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the history content with the primary key or throws a {@link org.kisti.edison.project.NoSuchHistoryContentException} if it could not be found.
	*
	* @param historyContentPK the primary key of the history content
	* @return the history content
	* @throws org.kisti.edison.project.NoSuchHistoryContentException if a history content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.project.model.HistoryContent findByPrimaryKey(
		org.kisti.edison.project.service.persistence.HistoryContentPK historyContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.project.NoSuchHistoryContentException;

	/**
	* Returns the history content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param historyContentPK the primary key of the history content
	* @return the history content, or <code>null</code> if a history content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.project.model.HistoryContent fetchByPrimaryKey(
		org.kisti.edison.project.service.persistence.HistoryContentPK historyContentPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the history contents.
	*
	* @return the history contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.project.model.HistoryContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.project.model.HistoryContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.project.model.HistoryContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the history contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of history contents.
	*
	* @return the number of history contents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}