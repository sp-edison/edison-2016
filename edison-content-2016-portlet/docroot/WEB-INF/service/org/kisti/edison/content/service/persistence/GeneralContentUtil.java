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

import org.kisti.edison.content.model.GeneralContent;

import java.util.List;

/**
 * The persistence utility for the general content service. This utility wraps {@link GeneralContentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see GeneralContentPersistence
 * @see GeneralContentPersistenceImpl
 * @generated
 */
public class GeneralContentUtil {
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
	public static void clearCache(GeneralContent generalContent) {
		getPersistence().clearCache(generalContent);
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
	public static List<GeneralContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GeneralContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GeneralContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GeneralContent update(GeneralContent generalContent)
		throws SystemException {
		return getPersistence().update(generalContent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GeneralContent update(GeneralContent generalContent,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(generalContent, serviceContext);
	}

	/**
	* Returns all the general contents where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.content.model.GeneralContent> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<org.kisti.edison.content.model.GeneralContent> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<org.kisti.edison.content.model.GeneralContent> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first general content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first general content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching general content, or <code>null</code> if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last general content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last general content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching general content, or <code>null</code> if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static org.kisti.edison.content.model.GeneralContent[] findByGroupId_PrevAndNext(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(generalContentPK, groupId,
			orderByComparator);
	}

	/**
	* Removes all the general contents where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of general contents where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the general contents where contentSeq = &#63;.
	*
	* @param contentSeq the content seq
	* @return the matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.content.model.GeneralContent> findByContentSeq(
		long contentSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContentSeq(contentSeq);
	}

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
	public static java.util.List<org.kisti.edison.content.model.GeneralContent> findByContentSeq(
		long contentSeq, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContentSeq(contentSeq, start, end);
	}

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
	public static java.util.List<org.kisti.edison.content.model.GeneralContent> findByContentSeq(
		long contentSeq, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContentSeq(contentSeq, start, end, orderByComparator);
	}

	/**
	* Returns the first general content in the ordered set where contentSeq = &#63;.
	*
	* @param contentSeq the content seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent findByContentSeq_First(
		long contentSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException {
		return getPersistence()
				   .findByContentSeq_First(contentSeq, orderByComparator);
	}

	/**
	* Returns the first general content in the ordered set where contentSeq = &#63;.
	*
	* @param contentSeq the content seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching general content, or <code>null</code> if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent fetchByContentSeq_First(
		long contentSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContentSeq_First(contentSeq, orderByComparator);
	}

	/**
	* Returns the last general content in the ordered set where contentSeq = &#63;.
	*
	* @param contentSeq the content seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent findByContentSeq_Last(
		long contentSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException {
		return getPersistence()
				   .findByContentSeq_Last(contentSeq, orderByComparator);
	}

	/**
	* Returns the last general content in the ordered set where contentSeq = &#63;.
	*
	* @param contentSeq the content seq
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching general content, or <code>null</code> if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent fetchByContentSeq_Last(
		long contentSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContentSeq_Last(contentSeq, orderByComparator);
	}

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
	public static org.kisti.edison.content.model.GeneralContent[] findByContentSeq_PrevAndNext(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK,
		long contentSeq,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException {
		return getPersistence()
				   .findByContentSeq_PrevAndNext(generalContentPK, contentSeq,
			orderByComparator);
	}

	/**
	* Removes all the general contents where contentSeq = &#63; from the database.
	*
	* @param contentSeq the content seq
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContentSeq(long contentSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByContentSeq(contentSeq);
	}

	/**
	* Returns the number of general contents where contentSeq = &#63;.
	*
	* @param contentSeq the content seq
	* @return the number of matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContentSeq(long contentSeq)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByContentSeq(contentSeq);
	}

	/**
	* Returns all the general contents where groupId = &#63; and contentDiv = &#63;.
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @return the matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.content.model.GeneralContent> findByContentDiv(
		long groupId, long contentDiv)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContentDiv(groupId, contentDiv);
	}

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
	public static java.util.List<org.kisti.edison.content.model.GeneralContent> findByContentDiv(
		long groupId, long contentDiv, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByContentDiv(groupId, contentDiv, start, end);
	}

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
	public static java.util.List<org.kisti.edison.content.model.GeneralContent> findByContentDiv(
		long groupId, long contentDiv, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByContentDiv(groupId, contentDiv, start, end,
			orderByComparator);
	}

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
	public static org.kisti.edison.content.model.GeneralContent findByContentDiv_First(
		long groupId, long contentDiv,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException {
		return getPersistence()
				   .findByContentDiv_First(groupId, contentDiv,
			orderByComparator);
	}

	/**
	* Returns the first general content in the ordered set where groupId = &#63; and contentDiv = &#63;.
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching general content, or <code>null</code> if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent fetchByContentDiv_First(
		long groupId, long contentDiv,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContentDiv_First(groupId, contentDiv,
			orderByComparator);
	}

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
	public static org.kisti.edison.content.model.GeneralContent findByContentDiv_Last(
		long groupId, long contentDiv,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException {
		return getPersistence()
				   .findByContentDiv_Last(groupId, contentDiv, orderByComparator);
	}

	/**
	* Returns the last general content in the ordered set where groupId = &#63; and contentDiv = &#63;.
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching general content, or <code>null</code> if a matching general content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent fetchByContentDiv_Last(
		long groupId, long contentDiv,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByContentDiv_Last(groupId, contentDiv,
			orderByComparator);
	}

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
	public static org.kisti.edison.content.model.GeneralContent[] findByContentDiv_PrevAndNext(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK,
		long groupId, long contentDiv,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException {
		return getPersistence()
				   .findByContentDiv_PrevAndNext(generalContentPK, groupId,
			contentDiv, orderByComparator);
	}

	/**
	* Removes all the general contents where groupId = &#63; and contentDiv = &#63; from the database.
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByContentDiv(long groupId, long contentDiv)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByContentDiv(groupId, contentDiv);
	}

	/**
	* Returns the number of general contents where groupId = &#63; and contentDiv = &#63;.
	*
	* @param groupId the group ID
	* @param contentDiv the content div
	* @return the number of matching general contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByContentDiv(long groupId, long contentDiv)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByContentDiv(groupId, contentDiv);
	}

	/**
	* Caches the general content in the entity cache if it is enabled.
	*
	* @param generalContent the general content
	*/
	public static void cacheResult(
		org.kisti.edison.content.model.GeneralContent generalContent) {
		getPersistence().cacheResult(generalContent);
	}

	/**
	* Caches the general contents in the entity cache if it is enabled.
	*
	* @param generalContents the general contents
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.content.model.GeneralContent> generalContents) {
		getPersistence().cacheResult(generalContents);
	}

	/**
	* Creates a new general content with the primary key. Does not add the general content to the database.
	*
	* @param generalContentPK the primary key for the new general content
	* @return the new general content
	*/
	public static org.kisti.edison.content.model.GeneralContent create(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK) {
		return getPersistence().create(generalContentPK);
	}

	/**
	* Removes the general content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param generalContentPK the primary key of the general content
	* @return the general content that was removed
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent remove(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException {
		return getPersistence().remove(generalContentPK);
	}

	public static org.kisti.edison.content.model.GeneralContent updateImpl(
		org.kisti.edison.content.model.GeneralContent generalContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(generalContent);
	}

	/**
	* Returns the general content with the primary key or throws a {@link org.kisti.edison.content.NoSuchGeneralContentException} if it could not be found.
	*
	* @param generalContentPK the primary key of the general content
	* @return the general content
	* @throws org.kisti.edison.content.NoSuchGeneralContentException if a general content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent findByPrimaryKey(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchGeneralContentException {
		return getPersistence().findByPrimaryKey(generalContentPK);
	}

	/**
	* Returns the general content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param generalContentPK the primary key of the general content
	* @return the general content, or <code>null</code> if a general content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.GeneralContent fetchByPrimaryKey(
		org.kisti.edison.content.service.persistence.GeneralContentPK generalContentPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(generalContentPK);
	}

	/**
	* Returns all the general contents.
	*
	* @return the general contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.content.model.GeneralContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.kisti.edison.content.model.GeneralContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.kisti.edison.content.model.GeneralContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the general contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of general contents.
	*
	* @return the number of general contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GeneralContentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GeneralContentPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.content.service.ClpSerializer.getServletContextName(),
					GeneralContentPersistence.class.getName());

			ReferenceRegistry.registerReference(GeneralContentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GeneralContentPersistence persistence) {
	}

	private static GeneralContentPersistence _persistence;
}