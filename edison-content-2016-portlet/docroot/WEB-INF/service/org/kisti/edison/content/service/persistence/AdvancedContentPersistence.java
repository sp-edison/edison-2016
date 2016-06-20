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

import org.kisti.edison.content.model.AdvancedContent;

/**
 * The persistence interface for the advanced content service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see AdvancedContentPersistenceImpl
 * @see AdvancedContentUtil
 * @generated
 */
public interface AdvancedContentPersistence extends BasePersistence<AdvancedContent> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdvancedContentUtil} to access the advanced content persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the advanced contents where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.AdvancedContent> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the advanced contents where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of advanced contents
	* @param end the upper bound of the range of advanced contents (not inclusive)
	* @return the range of matching advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.AdvancedContent> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the advanced contents where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of advanced contents
	* @param end the upper bound of the range of advanced contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.AdvancedContent> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first advanced content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advanced content
	* @throws org.kisti.edison.content.NoSuchAdvancedContentException if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.AdvancedContent findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException;

	/**
	* Returns the first advanced content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advanced content, or <code>null</code> if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.AdvancedContent fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last advanced content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advanced content
	* @throws org.kisti.edison.content.NoSuchAdvancedContentException if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.AdvancedContent findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException;

	/**
	* Returns the last advanced content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advanced content, or <code>null</code> if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.AdvancedContent fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the advanced contents before and after the current advanced content in the ordered set where groupId = &#63;.
	*
	* @param advancedContentPK the primary key of the current advanced content
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next advanced content
	* @throws org.kisti.edison.content.NoSuchAdvancedContentException if a advanced content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.AdvancedContent[] findByGroupId_PrevAndNext(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException;

	/**
	* Removes all the advanced contents where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of advanced contents where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the advanced contents where groupId = &#63; and serviceLanguage = &#63;.
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @return the matching advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.AdvancedContent> findByGroupIdSeriveLang(
		long groupId, java.lang.String serviceLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the advanced contents where groupId = &#63; and serviceLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @param start the lower bound of the range of advanced contents
	* @param end the upper bound of the range of advanced contents (not inclusive)
	* @return the range of matching advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.AdvancedContent> findByGroupIdSeriveLang(
		long groupId, java.lang.String serviceLanguage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the advanced contents where groupId = &#63; and serviceLanguage = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @param start the lower bound of the range of advanced contents
	* @param end the upper bound of the range of advanced contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.AdvancedContent> findByGroupIdSeriveLang(
		long groupId, java.lang.String serviceLanguage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first advanced content in the ordered set where groupId = &#63; and serviceLanguage = &#63;.
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advanced content
	* @throws org.kisti.edison.content.NoSuchAdvancedContentException if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.AdvancedContent findByGroupIdSeriveLang_First(
		long groupId, java.lang.String serviceLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException;

	/**
	* Returns the first advanced content in the ordered set where groupId = &#63; and serviceLanguage = &#63;.
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advanced content, or <code>null</code> if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.AdvancedContent fetchByGroupIdSeriveLang_First(
		long groupId, java.lang.String serviceLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last advanced content in the ordered set where groupId = &#63; and serviceLanguage = &#63;.
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advanced content
	* @throws org.kisti.edison.content.NoSuchAdvancedContentException if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.AdvancedContent findByGroupIdSeriveLang_Last(
		long groupId, java.lang.String serviceLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException;

	/**
	* Returns the last advanced content in the ordered set where groupId = &#63; and serviceLanguage = &#63;.
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advanced content, or <code>null</code> if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.AdvancedContent fetchByGroupIdSeriveLang_Last(
		long groupId, java.lang.String serviceLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the advanced contents before and after the current advanced content in the ordered set where groupId = &#63; and serviceLanguage = &#63;.
	*
	* @param advancedContentPK the primary key of the current advanced content
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next advanced content
	* @throws org.kisti.edison.content.NoSuchAdvancedContentException if a advanced content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.AdvancedContent[] findByGroupIdSeriveLang_PrevAndNext(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK,
		long groupId, java.lang.String serviceLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException;

	/**
	* Removes all the advanced contents where groupId = &#63; and serviceLanguage = &#63; from the database.
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupIdSeriveLang(long groupId,
		java.lang.String serviceLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of advanced contents where groupId = &#63; and serviceLanguage = &#63;.
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @return the number of matching advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupIdSeriveLang(long groupId,
		java.lang.String serviceLanguage)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the advanced content in the entity cache if it is enabled.
	*
	* @param advancedContent the advanced content
	*/
	public void cacheResult(
		org.kisti.edison.content.model.AdvancedContent advancedContent);

	/**
	* Caches the advanced contents in the entity cache if it is enabled.
	*
	* @param advancedContents the advanced contents
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.content.model.AdvancedContent> advancedContents);

	/**
	* Creates a new advanced content with the primary key. Does not add the advanced content to the database.
	*
	* @param advancedContentPK the primary key for the new advanced content
	* @return the new advanced content
	*/
	public org.kisti.edison.content.model.AdvancedContent create(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK);

	/**
	* Removes the advanced content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param advancedContentPK the primary key of the advanced content
	* @return the advanced content that was removed
	* @throws org.kisti.edison.content.NoSuchAdvancedContentException if a advanced content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.AdvancedContent remove(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException;

	public org.kisti.edison.content.model.AdvancedContent updateImpl(
		org.kisti.edison.content.model.AdvancedContent advancedContent)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the advanced content with the primary key or throws a {@link org.kisti.edison.content.NoSuchAdvancedContentException} if it could not be found.
	*
	* @param advancedContentPK the primary key of the advanced content
	* @return the advanced content
	* @throws org.kisti.edison.content.NoSuchAdvancedContentException if a advanced content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.AdvancedContent findByPrimaryKey(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException;

	/**
	* Returns the advanced content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param advancedContentPK the primary key of the advanced content
	* @return the advanced content, or <code>null</code> if a advanced content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.content.model.AdvancedContent fetchByPrimaryKey(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the advanced contents.
	*
	* @return the advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.AdvancedContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the advanced contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of advanced contents
	* @param end the upper bound of the range of advanced contents (not inclusive)
	* @return the range of advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.AdvancedContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the advanced contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.content.model.impl.AdvancedContentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of advanced contents
	* @param end the upper bound of the range of advanced contents (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.content.model.AdvancedContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the advanced contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of advanced contents.
	*
	* @return the number of advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}