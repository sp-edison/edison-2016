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

package org.kisti.edison.content.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.kisti.edison.content.model.OrgImgContent;

/**
 * The persistence interface for the org img content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see OrgImgContentPersistenceImpl
 * @see OrgImgContentUtil
 * @generated
 */
public interface OrgImgContentPersistence extends BasePersistence<OrgImgContent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrgImgContentUtil} to access the org img content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the org img contents where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching org img contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.OrgImgContent> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the org img contents where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.OrgImgContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of org img contents
	* @param end the upper bound of the range of org img contents (not inclusive)
	* @return the range of matching org img contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.OrgImgContent> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the org img contents where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.OrgImgContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of org img contents
	* @param end the upper bound of the range of org img contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching org img contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.OrgImgContent> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first org img content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching org img content
	* @throws org.kisti.edison.content.NoSuchOrgImgContentException if a matching org img content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.OrgImgContent findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchOrgImgContentException;

	/**
	* Returns the first org img content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching org img content, or <code>null</code> if a matching org img content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.OrgImgContent fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last org img content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching org img content
	* @throws org.kisti.edison.content.NoSuchOrgImgContentException if a matching org img content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.OrgImgContent findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchOrgImgContentException;

	/**
	* Returns the last org img content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching org img content, or <code>null</code> if a matching org img content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.OrgImgContent fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the org img contents before and after the current org img content in the ordered set where groupId = &#63;.
	*
	* @param orgImgContentPK the primary key of the current org img content
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next org img content
	* @throws org.kisti.edison.content.NoSuchOrgImgContentException if a org img content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.OrgImgContent[] findByGroupId_PrevAndNext(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchOrgImgContentException;

	/**
	* Removes all the org img contents where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of org img contents where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching org img contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the org img content in the entity cache if it is enabled.
	*
	* @param orgImgContent the org img content
	*/
	public void cacheResult(
		org.kisti.edison.content.model.OrgImgContent orgImgContent);

	/**
	* Caches the org img contents in the entity cache if it is enabled.
	*
	* @param orgImgContents the org img contents
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.content.model.OrgImgContent> orgImgContents);

	/**
	* Creates a new org img content with the primary key. Does not add the org img content to the database.
	*
	* @param orgImgContentPK the primary key for the new org img content
	* @return the new org img content
	*/
	public org.kisti.edison.content.model.OrgImgContent create(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK);

	/**
	* Removes the org img content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orgImgContentPK the primary key of the org img content
	* @return the org img content that was removed
	* @throws org.kisti.edison.content.NoSuchOrgImgContentException if a org img content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.OrgImgContent remove(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchOrgImgContentException;

	public org.kisti.edison.content.model.OrgImgContent updateImpl(
		org.kisti.edison.content.model.OrgImgContent orgImgContent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the org img content with the primary key or throws a {@link org.kisti.edison.content.NoSuchOrgImgContentException} if it could not be found.
	*
	* @param orgImgContentPK the primary key of the org img content
	* @return the org img content
	* @throws org.kisti.edison.content.NoSuchOrgImgContentException if a org img content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.OrgImgContent findByPrimaryKey(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchOrgImgContentException;

	/**
	* Returns the org img content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orgImgContentPK the primary key of the org img content
	* @return the org img content, or <code>null</code> if a org img content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.OrgImgContent fetchByPrimaryKey(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the org img contents.
	*
	* @return the org img contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.OrgImgContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the org img contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.OrgImgContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of org img contents
	* @param end the upper bound of the range of org img contents (not inclusive)
	* @return the range of org img contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.OrgImgContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the org img contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.OrgImgContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of org img contents
	* @param end the upper bound of the range of org img contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of org img contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.OrgImgContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the org img contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of org img contents.
	*
	* @return the number of org img contents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}