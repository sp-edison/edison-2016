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

package org.kisti.edison.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.kisti.edison.model.WorkflowInstance;

import java.util.List;

/**
 * The persistence utility for the workflow instance service. This utility wraps {@link WorkflowInstancePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see WorkflowInstancePersistence
 * @see WorkflowInstancePersistenceImpl
 * @generated
 */
public class WorkflowInstanceUtil {
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
	public static void clearCache(WorkflowInstance workflowInstance) {
		getPersistence().clearCache(workflowInstance);
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
	public static List<WorkflowInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkflowInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkflowInstance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static WorkflowInstance update(WorkflowInstance workflowInstance)
		throws SystemException {
		return getPersistence().update(workflowInstance);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static WorkflowInstance update(WorkflowInstance workflowInstance,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(workflowInstance, serviceContext);
	}

	/**
	* Returns all the workflow instances where title LIKE &#63;.
	*
	* @param title the title
	* @return the matching workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.WorkflowInstance> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title);
	}

	/**
	* Returns a range of all the workflow instances where title LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of workflow instances
	* @param end the upper bound of the range of workflow instances (not inclusive)
	* @return the range of matching workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.WorkflowInstance> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end);
	}

	/**
	* Returns an ordered range of all the workflow instances where title LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of workflow instances
	* @param end the upper bound of the range of workflow instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.WorkflowInstance> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end, orderByComparator);
	}

	/**
	* Returns the first workflow instance in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow instance
	* @throws org.kisti.edison.NoSuchWorkflowInstanceException if a matching workflow instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.WorkflowInstance findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowInstanceException {
		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the first workflow instance in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow instance, or <code>null</code> if a matching workflow instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.WorkflowInstance fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the last workflow instance in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow instance
	* @throws org.kisti.edison.NoSuchWorkflowInstanceException if a matching workflow instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.WorkflowInstance findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowInstanceException {
		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the last workflow instance in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow instance, or <code>null</code> if a matching workflow instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.WorkflowInstance fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the workflow instances before and after the current workflow instance in the ordered set where title LIKE &#63;.
	*
	* @param workflowInstanceId the primary key of the current workflow instance
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next workflow instance
	* @throws org.kisti.edison.NoSuchWorkflowInstanceException if a workflow instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.WorkflowInstance[] findByTitle_PrevAndNext(
		long workflowInstanceId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowInstanceException {
		return getPersistence()
				   .findByTitle_PrevAndNext(workflowInstanceId, title,
			orderByComparator);
	}

	/**
	* Removes all the workflow instances where title LIKE &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitle(title);
	}

	/**
	* Returns the number of workflow instances where title LIKE &#63;.
	*
	* @param title the title
	* @return the number of matching workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitle(title);
	}

	/**
	* Returns all the workflow instances where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.WorkflowInstance> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the workflow instances where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of workflow instances
	* @param end the upper bound of the range of workflow instances (not inclusive)
	* @return the range of matching workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.WorkflowInstance> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the workflow instances where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of workflow instances
	* @param end the upper bound of the range of workflow instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.WorkflowInstance> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first workflow instance in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow instance
	* @throws org.kisti.edison.NoSuchWorkflowInstanceException if a matching workflow instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.WorkflowInstance findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowInstanceException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first workflow instance in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow instance, or <code>null</code> if a matching workflow instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.WorkflowInstance fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last workflow instance in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow instance
	* @throws org.kisti.edison.NoSuchWorkflowInstanceException if a matching workflow instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.WorkflowInstance findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowInstanceException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last workflow instance in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow instance, or <code>null</code> if a matching workflow instance could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.WorkflowInstance fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the workflow instances before and after the current workflow instance in the ordered set where userId = &#63;.
	*
	* @param workflowInstanceId the primary key of the current workflow instance
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next workflow instance
	* @throws org.kisti.edison.NoSuchWorkflowInstanceException if a workflow instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.WorkflowInstance[] findByUserId_PrevAndNext(
		long workflowInstanceId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowInstanceException {
		return getPersistence()
				   .findByUserId_PrevAndNext(workflowInstanceId, userId,
			orderByComparator);
	}

	/**
	* Removes all the workflow instances where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of workflow instances where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Caches the workflow instance in the entity cache if it is enabled.
	*
	* @param workflowInstance the workflow instance
	*/
	public static void cacheResult(
		org.kisti.edison.model.WorkflowInstance workflowInstance) {
		getPersistence().cacheResult(workflowInstance);
	}

	/**
	* Caches the workflow instances in the entity cache if it is enabled.
	*
	* @param workflowInstances the workflow instances
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.model.WorkflowInstance> workflowInstances) {
		getPersistence().cacheResult(workflowInstances);
	}

	/**
	* Creates a new workflow instance with the primary key. Does not add the workflow instance to the database.
	*
	* @param workflowInstanceId the primary key for the new workflow instance
	* @return the new workflow instance
	*/
	public static org.kisti.edison.model.WorkflowInstance create(
		long workflowInstanceId) {
		return getPersistence().create(workflowInstanceId);
	}

	/**
	* Removes the workflow instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowInstanceId the primary key of the workflow instance
	* @return the workflow instance that was removed
	* @throws org.kisti.edison.NoSuchWorkflowInstanceException if a workflow instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.WorkflowInstance remove(
		long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowInstanceException {
		return getPersistence().remove(workflowInstanceId);
	}

	public static org.kisti.edison.model.WorkflowInstance updateImpl(
		org.kisti.edison.model.WorkflowInstance workflowInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(workflowInstance);
	}

	/**
	* Returns the workflow instance with the primary key or throws a {@link org.kisti.edison.NoSuchWorkflowInstanceException} if it could not be found.
	*
	* @param workflowInstanceId the primary key of the workflow instance
	* @return the workflow instance
	* @throws org.kisti.edison.NoSuchWorkflowInstanceException if a workflow instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.WorkflowInstance findByPrimaryKey(
		long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowInstanceException {
		return getPersistence().findByPrimaryKey(workflowInstanceId);
	}

	/**
	* Returns the workflow instance with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workflowInstanceId the primary key of the workflow instance
	* @return the workflow instance, or <code>null</code> if a workflow instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.WorkflowInstance fetchByPrimaryKey(
		long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(workflowInstanceId);
	}

	/**
	* Returns all the workflow instances.
	*
	* @return the workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.WorkflowInstance> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the workflow instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflow instances
	* @param end the upper bound of the range of workflow instances (not inclusive)
	* @return the range of workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.WorkflowInstance> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the workflow instances.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflow instances
	* @param end the upper bound of the range of workflow instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.WorkflowInstance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the workflow instances from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of workflow instances.
	*
	* @return the number of workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the workflows associated with the workflow instance.
	*
	* @param pk the primary key of the workflow instance
	* @return the workflows associated with the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> getWorkflows(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getWorkflows(pk);
	}

	/**
	* Returns a range of all the workflows associated with the workflow instance.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the workflow instance
	* @param start the lower bound of the range of workflow instances
	* @param end the upper bound of the range of workflow instances (not inclusive)
	* @return the range of workflows associated with the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> getWorkflows(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getWorkflows(pk, start, end);
	}

	/**
	* Returns an ordered range of all the workflows associated with the workflow instance.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the workflow instance
	* @param start the lower bound of the range of workflow instances
	* @param end the upper bound of the range of workflow instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of workflows associated with the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> getWorkflows(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getWorkflows(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of workflows associated with the workflow instance.
	*
	* @param pk the primary key of the workflow instance
	* @return the number of workflows associated with the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public static int getWorkflowsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getWorkflowsSize(pk);
	}

	/**
	* Returns <code>true</code> if the workflow is associated with the workflow instance.
	*
	* @param pk the primary key of the workflow instance
	* @param workflowPK the primary key of the workflow
	* @return <code>true</code> if the workflow is associated with the workflow instance; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsWorkflow(long pk, long workflowPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsWorkflow(pk, workflowPK);
	}

	/**
	* Returns <code>true</code> if the workflow instance has any workflows associated with it.
	*
	* @param pk the primary key of the workflow instance to check for associations with workflows
	* @return <code>true</code> if the workflow instance has any workflows associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsWorkflows(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsWorkflows(pk);
	}

	/**
	* Adds an association between the workflow instance and the workflow. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow instance
	* @param workflowPK the primary key of the workflow
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkflow(long pk, long workflowPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addWorkflow(pk, workflowPK);
	}

	/**
	* Adds an association between the workflow instance and the workflow. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow instance
	* @param workflow the workflow
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkflow(long pk,
		org.kisti.edison.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addWorkflow(pk, workflow);
	}

	/**
	* Adds an association between the workflow instance and the workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow instance
	* @param workflowPKs the primary keys of the workflows
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkflows(long pk, long[] workflowPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addWorkflows(pk, workflowPKs);
	}

	/**
	* Adds an association between the workflow instance and the workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow instance
	* @param workflows the workflows
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkflows(long pk,
		java.util.List<org.kisti.edison.model.Workflow> workflows)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addWorkflows(pk, workflows);
	}

	/**
	* Clears all associations between the workflow instance and its workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow instance to clear the associated workflows from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearWorkflows(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearWorkflows(pk);
	}

	/**
	* Removes the association between the workflow instance and the workflow. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow instance
	* @param workflowPK the primary key of the workflow
	* @throws SystemException if a system exception occurred
	*/
	public static void removeWorkflow(long pk, long workflowPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeWorkflow(pk, workflowPK);
	}

	/**
	* Removes the association between the workflow instance and the workflow. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow instance
	* @param workflow the workflow
	* @throws SystemException if a system exception occurred
	*/
	public static void removeWorkflow(long pk,
		org.kisti.edison.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeWorkflow(pk, workflow);
	}

	/**
	* Removes the association between the workflow instance and the workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow instance
	* @param workflowPKs the primary keys of the workflows
	* @throws SystemException if a system exception occurred
	*/
	public static void removeWorkflows(long pk, long[] workflowPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeWorkflows(pk, workflowPKs);
	}

	/**
	* Removes the association between the workflow instance and the workflows. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow instance
	* @param workflows the workflows
	* @throws SystemException if a system exception occurred
	*/
	public static void removeWorkflows(long pk,
		java.util.List<org.kisti.edison.model.Workflow> workflows)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeWorkflows(pk, workflows);
	}

	/**
	* Sets the workflows associated with the workflow instance, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow instance
	* @param workflowPKs the primary keys of the workflows to be associated with the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public static void setWorkflows(long pk, long[] workflowPKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setWorkflows(pk, workflowPKs);
	}

	/**
	* Sets the workflows associated with the workflow instance, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow instance
	* @param workflows the workflows to be associated with the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public static void setWorkflows(long pk,
		java.util.List<org.kisti.edison.model.Workflow> workflows)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setWorkflows(pk, workflows);
	}

	public static WorkflowInstancePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WorkflowInstancePersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.service.ClpSerializer.getServletContextName(),
					WorkflowInstancePersistence.class.getName());

			ReferenceRegistry.registerReference(WorkflowInstanceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WorkflowInstancePersistence persistence) {
	}

	private static WorkflowInstancePersistence _persistence;
}