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

import org.kisti.edison.content.model.GeneralContent;

/**
 * The persistence interface for the general content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see GeneralContentPersistenceImpl
 * @see GeneralContentUtil
 * @generated
 */
public interface GeneralContentPersistence extends BasePersistence<GeneralContent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GeneralContentUtil} to access the general content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the general contents where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.GeneralContent> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the general contents where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of general contents
	* @param end the upper bound of the range of general contents (not inclusive)
	* @return the range of matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.GeneralContent> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the general contents where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of general contents
	* @param end the upper bound of the range of general contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.GeneralContent> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first general content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException;

	/**
	* Returns the first general content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching general content, or <code>null</code> if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last general content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException;

	/**
	* Returns the last general content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching general content, or <code>null</code> if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the general contents before and after the current general content in the ordered set where groupId = &#63;.
	*
	* @param generalContentPK the primary key of the current general content
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent[] findByGroupId_PrevAndNext(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException;

	/**
	* Removes all the general contents where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of general contents where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the general contents where contentSeq = &#63;.
	*
	* @param contentSeq the content seq
	* @return the matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.GeneralContent> findByContentSeq(
		long contentSeq)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the general contents where contentSeq = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contentSeq the content seq
	* @param start the lower bound of the range of general contents
	* @param end the upper bound of the range of general contents (not inclusive)
	* @return the range of matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.GeneralContent> findByContentSeq(
		long contentSeq, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the general contents where contentSeq = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param contentSeq the content seq
	* @param start the lower bound of the range of general contents
	* @param end the upper bound of the range of general contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.GeneralContent> findByContentSeq(
		long contentSeq, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first general content in the ordered set where contentSeq = &#63;.
	*
	* @param contentSeq the content seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent findByContentSeq_First(
		long contentSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException;

	/**
	* Returns the first general content in the ordered set where contentSeq = &#63;.
	*
	* @param contentSeq the content seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching general content, or <code>null</code> if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent fetchByContentSeq_First(
		long contentSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last general content in the ordered set where contentSeq = &#63;.
	*
	* @param contentSeq the content seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent findByContentSeq_Last(
		long contentSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException;

	/**
	* Returns the last general content in the ordered set where contentSeq = &#63;.
	*
	* @param contentSeq the content seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching general content, or <code>null</code> if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent fetchByContentSeq_Last(
		long contentSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the general contents before and after the current general content in the ordered set where contentSeq = &#63;.
	*
	* @param generalContentPK the primary key of the current general content
	* @param contentSeq the content seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent[] findByContentSeq_PrevAndNext(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK,
		long contentSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException;

	/**
	* Removes all the general contents where contentSeq = &#63; from the database.
	*
	* @param contentSeq the content seq
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContentSeq(long contentSeq)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of general contents where contentSeq = &#63;.
	*
	* @param contentSeq the content seq
	* @return the number of matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByContentSeq(long contentSeq)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the general contents where groupId = &#63; and contentDiv = &#63;.
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @return the matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.GeneralContent> findByContentDiv(
		long groupId, long contentDiv)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the general contents where groupId = &#63; and contentDiv = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @param start the lower bound of the range of general contents
	* @param end the upper bound of the range of general contents (not inclusive)
	* @return the range of matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.GeneralContent> findByContentDiv(
		long groupId, long contentDiv, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the general contents where groupId = &#63; and contentDiv = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @param start the lower bound of the range of general contents
	* @param end the upper bound of the range of general contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.GeneralContent> findByContentDiv(
		long groupId, long contentDiv, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first general content in the ordered set where groupId = &#63; and contentDiv = &#63;.
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent findByContentDiv_First(
		long groupId, long contentDiv,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException;

	/**
	* Returns the first general content in the ordered set where groupId = &#63; and contentDiv = &#63;.
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching general content, or <code>null</code> if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent fetchByContentDiv_First(
		long groupId, long contentDiv,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last general content in the ordered set where groupId = &#63; and contentDiv = &#63;.
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent findByContentDiv_Last(
		long groupId, long contentDiv,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException;

	/**
	* Returns the last general content in the ordered set where groupId = &#63; and contentDiv = &#63;.
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching general content, or <code>null</code> if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent fetchByContentDiv_Last(
		long groupId, long contentDiv,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the general contents before and after the current general content in the ordered set where groupId = &#63; and contentDiv = &#63;.
	*
	* @param generalContentPK the primary key of the current general content
	* @param groupId the group ID
	* @param contentDiv the content div
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent[] findByContentDiv_PrevAndNext(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK,
		long groupId, long contentDiv,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException;

	/**
	* Removes all the general contents where groupId = &#63; and contentDiv = &#63; from the database.
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @throws SystemException if a system exception occurred
	*/
	public void removeByContentDiv(long groupId, long contentDiv)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of general contents where groupId = &#63; and contentDiv = &#63;.
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @return the number of matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByContentDiv(long groupId, long contentDiv)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the general content in the entity cache if it is enabled.
	*
	* @param generalContent the general content
	*/
	public void cacheResult(
		org.kisti.edison.content.model.GeneralContent generalContent);

	/**
	* Caches the general contents in the entity cache if it is enabled.
	*
	* @param generalContents the general contents
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.content.model.GeneralContent> generalContents);

	/**
	* Creates a new general content with the primary key. Does not add the general content to the database.
	*
	* @param generalContentPK the primary key for the new general content
	* @return the new general content
	*/
	public org.kisti.edison.content.model.GeneralContent create(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK);

	/**
	* Removes the general content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param generalContentPK the primary key of the general content
	* @return the general content that was removed
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent remove(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException;

	public org.kisti.edison.content.model.GeneralContent updateImpl(
		org.kisti.edison.content.model.GeneralContent generalContent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the general content with the primary key or throws a {@link org.kisti.edison.content.NoSuchGeneralContentException} if it could not be found.
	*
	* @param generalContentPK the primary key of the general content
	* @return the general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent findByPrimaryKey(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException;

	/**
	* Returns the general content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param generalContentPK the primary key of the general content
	* @return the general content, or <code>null</code> if a general content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.GeneralContent fetchByPrimaryKey(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the general contents.
	*
	* @return the general contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.GeneralContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the general contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of general contents
	* @param end the upper bound of the range of general contents (not inclusive)
	* @return the range of general contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.GeneralContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the general contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.GeneralContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of general contents
	* @param end the upper bound of the range of general contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of general contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.GeneralContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the general contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of general contents.
	*
	* @return the number of general contents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}