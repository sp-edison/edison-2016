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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.kisti.edison.content.model.AdvancedContent;

import java.util.List;

/**
 * The persistence utility for the advanced content service. This utility wraps {@link AdvancedContentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see AdvancedContentPersistence
 * @see AdvancedContentPersistenceImpl
 * @generated
 */
public class AdvancedContentUtil {
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
	public static void clearCache(AdvancedContent advancedContent) {
		getPersistence().clearCache(advancedContent);
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
	public static List<AdvancedContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdvancedContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdvancedContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static AdvancedContent update(AdvancedContent advancedContent)
		throws SystemException {
		return getPersistence().update(advancedContent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static AdvancedContent update(AdvancedContent advancedContent,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(advancedContent, serviceContext);
	}

	/**
	* Returns all the advanced contents where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.content.model.AdvancedContent> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<org.kisti.edison.content.model.AdvancedContent> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<org.kisti.edison.content.model.AdvancedContent> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first advanced content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advanced content
	* @throws org.kisti.edison.content.NoSuchAdvancedContentException if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first advanced content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advanced content, or <code>null</code> if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last advanced content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advanced content
	* @throws org.kisti.edison.content.NoSuchAdvancedContentException if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last advanced content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advanced content, or <code>null</code> if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static org.kisti.edison.content.model.AdvancedContent[] findByGroupId_PrevAndNext(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(advancedContentPK, groupId,
			orderByComparator);
	}

	/**
	* Removes all the advanced contents where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of advanced contents where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the advanced contents where groupId = &#63; and serviceLanguage = &#63;.
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @return the matching advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.content.model.AdvancedContent> findByGroupIdSeriveLang(
		long groupId, java.lang.String serviceLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupIdSeriveLang(groupId, serviceLanguage);
	}

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
	public static java.util.List<org.kisti.edison.content.model.AdvancedContent> findByGroupIdSeriveLang(
		long groupId, java.lang.String serviceLanguage, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdSeriveLang(groupId, serviceLanguage, start, end);
	}

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
	public static java.util.List<org.kisti.edison.content.model.AdvancedContent> findByGroupIdSeriveLang(
		long groupId, java.lang.String serviceLanguage, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupIdSeriveLang(groupId, serviceLanguage, start,
			end, orderByComparator);
	}

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
	public static org.kisti.edison.content.model.AdvancedContent findByGroupIdSeriveLang_First(
		long groupId, java.lang.String serviceLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException {
		return getPersistence()
				   .findByGroupIdSeriveLang_First(groupId, serviceLanguage,
			orderByComparator);
	}

	/**
	* Returns the first advanced content in the ordered set where groupId = &#63; and serviceLanguage = &#63;.
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching advanced content, or <code>null</code> if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent fetchByGroupIdSeriveLang_First(
		long groupId, java.lang.String serviceLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdSeriveLang_First(groupId, serviceLanguage,
			orderByComparator);
	}

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
	public static org.kisti.edison.content.model.AdvancedContent findByGroupIdSeriveLang_Last(
		long groupId, java.lang.String serviceLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException {
		return getPersistence()
				   .findByGroupIdSeriveLang_Last(groupId, serviceLanguage,
			orderByComparator);
	}

	/**
	* Returns the last advanced content in the ordered set where groupId = &#63; and serviceLanguage = &#63;.
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching advanced content, or <code>null</code> if a matching advanced content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent fetchByGroupIdSeriveLang_Last(
		long groupId, java.lang.String serviceLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGroupIdSeriveLang_Last(groupId, serviceLanguage,
			orderByComparator);
	}

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
	public static org.kisti.edison.content.model.AdvancedContent[] findByGroupIdSeriveLang_PrevAndNext(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK,
		long groupId, java.lang.String serviceLanguage,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException {
		return getPersistence()
				   .findByGroupIdSeriveLang_PrevAndNext(advancedContentPK,
			groupId, serviceLanguage, orderByComparator);
	}

	/**
	* Removes all the advanced contents where groupId = &#63; and serviceLanguage = &#63; from the database.
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupIdSeriveLang(long groupId,
		java.lang.String serviceLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupIdSeriveLang(groupId, serviceLanguage);
	}

	/**
	* Returns the number of advanced contents where groupId = &#63; and serviceLanguage = &#63;.
	*
	* @param groupId the group ID
	* @param serviceLanguage the service language
	* @return the number of matching advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupIdSeriveLang(long groupId,
		java.lang.String serviceLanguage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGroupIdSeriveLang(groupId, serviceLanguage);
	}

	/**
	* Caches the advanced content in the entity cache if it is enabled.
	*
	* @param advancedContent the advanced content
	*/
	public static void cacheResult(
		org.kisti.edison.content.model.AdvancedContent advancedContent) {
		getPersistence().cacheResult(advancedContent);
	}

	/**
	* Caches the advanced contents in the entity cache if it is enabled.
	*
	* @param advancedContents the advanced contents
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.content.model.AdvancedContent> advancedContents) {
		getPersistence().cacheResult(advancedContents);
	}

	/**
	* Creates a new advanced content with the primary key. Does not add the advanced content to the database.
	*
	* @param advancedContentPK the primary key for the new advanced content
	* @return the new advanced content
	*/
	public static org.kisti.edison.content.model.AdvancedContent create(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK) {
		return getPersistence().create(advancedContentPK);
	}

	/**
	* Removes the advanced content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param advancedContentPK the primary key of the advanced content
	* @return the advanced content that was removed
	* @throws org.kisti.edison.content.NoSuchAdvancedContentException if a advanced content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent remove(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException {
		return getPersistence().remove(advancedContentPK);
	}

	public static org.kisti.edison.content.model.AdvancedContent updateImpl(
		org.kisti.edison.content.model.AdvancedContent advancedContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(advancedContent);
	}

	/**
	* Returns the advanced content with the primary key or throws a {@link org.kisti.edison.content.NoSuchAdvancedContentException} if it could not be found.
	*
	* @param advancedContentPK the primary key of the advanced content
	* @return the advanced content
	* @throws org.kisti.edison.content.NoSuchAdvancedContentException if a advanced content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent findByPrimaryKey(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchAdvancedContentException {
		return getPersistence().findByPrimaryKey(advancedContentPK);
	}

	/**
	* Returns the advanced content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param advancedContentPK the primary key of the advanced content
	* @return the advanced content, or <code>null</code> if a advanced content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.AdvancedContent fetchByPrimaryKey(
		org.kisti.edison.content.service.persistence.AdvancedContentPK advancedContentPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(advancedContentPK);
	}

	/**
	* Returns all the advanced contents.
	*
	* @return the advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.content.model.AdvancedContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.kisti.edison.content.model.AdvancedContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.kisti.edison.content.model.AdvancedContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the advanced contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of advanced contents.
	*
	* @return the number of advanced contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AdvancedContentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AdvancedContentPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.content.service.ClpSerializer.getServletContextName(),
					AdvancedContentPersistence.class.getName());

			ReferenceRegistry.registerReference(AdvancedContentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(AdvancedContentPersistence persistence) {
	}

	private static AdvancedContentPersistence _persistence;
}