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

import org.kisti.edison.content.model.OrgImgContent;

import java.util.List;

/**
 * The persistence utility for the org img content service. This utility wraps {@link OrgImgContentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see OrgImgContentPersistence
 * @see OrgImgContentPersistenceImpl
 * @generated
 */
public class OrgImgContentUtil {
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
	public static void clearCache(OrgImgContent orgImgContent) {
		getPersistence().clearCache(orgImgContent);
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
	public static List<OrgImgContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OrgImgContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OrgImgContent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OrgImgContent update(OrgImgContent orgImgContent)
		throws SystemException {
		return getPersistence().update(orgImgContent);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OrgImgContent update(OrgImgContent orgImgContent,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(orgImgContent, serviceContext);
	}

	/**
	* Returns all the org img contents where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching org img contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.content.model.OrgImgContent> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<org.kisti.edison.content.model.OrgImgContent> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<org.kisti.edison.content.model.OrgImgContent> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first org img content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching org img content
	* @throws org.kisti.edison.content.NoSuchOrgImgContentException if a matching org img content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.OrgImgContent findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchOrgImgContentException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first org img content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching org img content, or <code>null</code> if a matching org img content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.OrgImgContent fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last org img content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching org img content
	* @throws org.kisti.edison.content.NoSuchOrgImgContentException if a matching org img content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.OrgImgContent findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchOrgImgContentException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last org img content in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching org img content, or <code>null</code> if a matching org img content could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.OrgImgContent fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static org.kisti.edison.content.model.OrgImgContent[] findByGroupId_PrevAndNext(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchOrgImgContentException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(orgImgContentPK, groupId,
			orderByComparator);
	}

	/**
	* Removes all the org img contents where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of org img contents where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching org img contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Caches the org img content in the entity cache if it is enabled.
	*
	* @param orgImgContent the org img content
	*/
	public static void cacheResult(
		org.kisti.edison.content.model.OrgImgContent orgImgContent) {
		getPersistence().cacheResult(orgImgContent);
	}

	/**
	* Caches the org img contents in the entity cache if it is enabled.
	*
	* @param orgImgContents the org img contents
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.content.model.OrgImgContent> orgImgContents) {
		getPersistence().cacheResult(orgImgContents);
	}

	/**
	* Creates a new org img content with the primary key. Does not add the org img content to the database.
	*
	* @param orgImgContentPK the primary key for the new org img content
	* @return the new org img content
	*/
	public static org.kisti.edison.content.model.OrgImgContent create(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK) {
		return getPersistence().create(orgImgContentPK);
	}

	/**
	* Removes the org img content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orgImgContentPK the primary key of the org img content
	* @return the org img content that was removed
	* @throws org.kisti.edison.content.NoSuchOrgImgContentException if a org img content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.OrgImgContent remove(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchOrgImgContentException {
		return getPersistence().remove(orgImgContentPK);
	}

	public static org.kisti.edison.content.model.OrgImgContent updateImpl(
		org.kisti.edison.content.model.OrgImgContent orgImgContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(orgImgContent);
	}

	/**
	* Returns the org img content with the primary key or throws a {@link org.kisti.edison.content.NoSuchOrgImgContentException} if it could not be found.
	*
	* @param orgImgContentPK the primary key of the org img content
	* @return the org img content
	* @throws org.kisti.edison.content.NoSuchOrgImgContentException if a org img content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.OrgImgContent findByPrimaryKey(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.content.NoSuchOrgImgContentException {
		return getPersistence().findByPrimaryKey(orgImgContentPK);
	}

	/**
	* Returns the org img content with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orgImgContentPK the primary key of the org img content
	* @return the org img content, or <code>null</code> if a org img content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.content.model.OrgImgContent fetchByPrimaryKey(
		org.kisti.edison.content.service.persistence.OrgImgContentPK orgImgContentPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(orgImgContentPK);
	}

	/**
	* Returns all the org img contents.
	*
	* @return the org img contents
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.content.model.OrgImgContent> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<org.kisti.edison.content.model.OrgImgContent> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.kisti.edison.content.model.OrgImgContent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the org img contents from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of org img contents.
	*
	* @return the number of org img contents
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OrgImgContentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OrgImgContentPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.content.service.ClpSerializer.getServletContextName(),
					OrgImgContentPersistence.class.getName());

			ReferenceRegistry.registerReference(OrgImgContentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(OrgImgContentPersistence persistence) {
	}

	private static OrgImgContentPersistence _persistence;
}