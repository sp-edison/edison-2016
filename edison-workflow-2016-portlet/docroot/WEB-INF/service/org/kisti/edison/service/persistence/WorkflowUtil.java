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

import org.kisti.edison.model.Workflow;

import java.util.List;

/**
 * The persistence utility for the workflow service. This utility wraps {@link WorkflowPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see WorkflowPersistence
 * @see WorkflowPersistenceImpl
 * @generated
 */
public class WorkflowUtil {
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
	public static void clearCache(Workflow workflow) {
		getPersistence().clearCache(workflow);
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
	public static List<Workflow> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Workflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Workflow> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Workflow update(Workflow workflow) throws SystemException {
		return getPersistence().update(workflow);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Workflow update(Workflow workflow,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(workflow, serviceContext);
	}

	/**
	* Returns all the workflows where title LIKE &#63;.
	*
	* @param title the title
	* @return the matching workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title);
	}

	/**
	* Returns a range of all the workflows where title LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of workflows
	* @param end the upper bound of the range of workflows (not inclusive)
	* @return the range of matching workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end);
	}

	/**
	* Returns an ordered range of all the workflows where title LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of workflows
	* @param end the upper bound of the range of workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitle(title, start, end, orderByComparator);
	}

	/**
	* Returns the first workflow in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow
	* @throws org.kisti.edison.NoSuchWorkflowException if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException {
		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the first workflow in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow, or <code>null</code> if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	* Returns the last workflow in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow
	* @throws org.kisti.edison.NoSuchWorkflowException if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException {
		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the last workflow in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow, or <code>null</code> if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	* Returns the workflows before and after the current workflow in the ordered set where title LIKE &#63;.
	*
	* @param workflowId the primary key of the current workflow
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next workflow
	* @throws org.kisti.edison.NoSuchWorkflowException if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow[] findByTitle_PrevAndNext(
		long workflowId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException {
		return getPersistence()
				   .findByTitle_PrevAndNext(workflowId, title, orderByComparator);
	}

	/**
	* Removes all the workflows where title LIKE &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitle(title);
	}

	/**
	* Returns the number of workflows where title LIKE &#63;.
	*
	* @param title the title
	* @return the number of matching workflows
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitle(title);
	}

	/**
	* Returns all the workflows where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @return the matching workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> findByIsPublic(
		boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsPublic(isPublic);
	}

	/**
	* Returns a range of all the workflows where isPublic = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isPublic the is public
	* @param start the lower bound of the range of workflows
	* @param end the upper bound of the range of workflows (not inclusive)
	* @return the range of matching workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> findByIsPublic(
		boolean isPublic, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByIsPublic(isPublic, start, end);
	}

	/**
	* Returns an ordered range of all the workflows where isPublic = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isPublic the is public
	* @param start the lower bound of the range of workflows
	* @param end the upper bound of the range of workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> findByIsPublic(
		boolean isPublic, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByIsPublic(isPublic, start, end, orderByComparator);
	}

	/**
	* Returns the first workflow in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow
	* @throws org.kisti.edison.NoSuchWorkflowException if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow findByIsPublic_First(
		boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException {
		return getPersistence().findByIsPublic_First(isPublic, orderByComparator);
	}

	/**
	* Returns the first workflow in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow, or <code>null</code> if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow fetchByIsPublic_First(
		boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByIsPublic_First(isPublic, orderByComparator);
	}

	/**
	* Returns the last workflow in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow
	* @throws org.kisti.edison.NoSuchWorkflowException if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow findByIsPublic_Last(
		boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException {
		return getPersistence().findByIsPublic_Last(isPublic, orderByComparator);
	}

	/**
	* Returns the last workflow in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow, or <code>null</code> if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow fetchByIsPublic_Last(
		boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByIsPublic_Last(isPublic, orderByComparator);
	}

	/**
	* Returns the workflows before and after the current workflow in the ordered set where isPublic = &#63;.
	*
	* @param workflowId the primary key of the current workflow
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next workflow
	* @throws org.kisti.edison.NoSuchWorkflowException if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow[] findByIsPublic_PrevAndNext(
		long workflowId, boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException {
		return getPersistence()
				   .findByIsPublic_PrevAndNext(workflowId, isPublic,
			orderByComparator);
	}

	/**
	* Removes all the workflows where isPublic = &#63; from the database.
	*
	* @param isPublic the is public
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByIsPublic(boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByIsPublic(isPublic);
	}

	/**
	* Returns the number of workflows where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @return the number of matching workflows
	* @throws SystemException if a system exception occurred
	*/
	public static int countByIsPublic(boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByIsPublic(isPublic);
	}

	/**
	* Caches the workflow in the entity cache if it is enabled.
	*
	* @param workflow the workflow
	*/
	public static void cacheResult(org.kisti.edison.model.Workflow workflow) {
		getPersistence().cacheResult(workflow);
	}

	/**
	* Caches the workflows in the entity cache if it is enabled.
	*
	* @param workflows the workflows
	*/
	public static void cacheResult(
		java.util.List<org.kisti.edison.model.Workflow> workflows) {
		getPersistence().cacheResult(workflows);
	}

	/**
	* Creates a new workflow with the primary key. Does not add the workflow to the database.
	*
	* @param workflowId the primary key for the new workflow
	* @return the new workflow
	*/
	public static org.kisti.edison.model.Workflow create(long workflowId) {
		return getPersistence().create(workflowId);
	}

	/**
	* Removes the workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowId the primary key of the workflow
	* @return the workflow that was removed
	* @throws org.kisti.edison.NoSuchWorkflowException if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow remove(long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException {
		return getPersistence().remove(workflowId);
	}

	public static org.kisti.edison.model.Workflow updateImpl(
		org.kisti.edison.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(workflow);
	}

	/**
	* Returns the workflow with the primary key or throws a {@link org.kisti.edison.NoSuchWorkflowException} if it could not be found.
	*
	* @param workflowId the primary key of the workflow
	* @return the workflow
	* @throws org.kisti.edison.NoSuchWorkflowException if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow findByPrimaryKey(
		long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException {
		return getPersistence().findByPrimaryKey(workflowId);
	}

	/**
	* Returns the workflow with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workflowId the primary key of the workflow
	* @return the workflow, or <code>null</code> if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow fetchByPrimaryKey(
		long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(workflowId);
	}

	/**
	* Returns all the workflows.
	*
	* @return the workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the workflows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflows
	* @param end the upper bound of the range of workflows (not inclusive)
	* @return the range of workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the workflows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of workflows
	* @param end the upper bound of the range of workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of workflows
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the workflows from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of workflows.
	*
	* @return the number of workflows
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the workflow instances associated with the workflow.
	*
	* @param pk the primary key of the workflow
	* @return the workflow instances associated with the workflow
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.WorkflowInstance> getWorkflowInstances(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getWorkflowInstances(pk);
	}

	/**
	* Returns a range of all the workflow instances associated with the workflow.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the workflow
	* @param start the lower bound of the range of workflows
	* @param end the upper bound of the range of workflows (not inclusive)
	* @return the range of workflow instances associated with the workflow
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.WorkflowInstance> getWorkflowInstances(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getWorkflowInstances(pk, start, end);
	}

	/**
	* Returns an ordered range of all the workflow instances associated with the workflow.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the workflow
	* @param start the lower bound of the range of workflows
	* @param end the upper bound of the range of workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of workflow instances associated with the workflow
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.WorkflowInstance> getWorkflowInstances(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getWorkflowInstances(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of workflow instances associated with the workflow.
	*
	* @param pk the primary key of the workflow
	* @return the number of workflow instances associated with the workflow
	* @throws SystemException if a system exception occurred
	*/
	public static int getWorkflowInstancesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getWorkflowInstancesSize(pk);
	}

	/**
	* Returns <code>true</code> if the workflow instance is associated with the workflow.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstancePK the primary key of the workflow instance
	* @return <code>true</code> if the workflow instance is associated with the workflow; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsWorkflowInstance(long pk,
		long workflowInstancePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsWorkflowInstance(pk, workflowInstancePK);
	}

	/**
	* Returns <code>true</code> if the workflow has any workflow instances associated with it.
	*
	* @param pk the primary key of the workflow to check for associations with workflow instances
	* @return <code>true</code> if the workflow has any workflow instances associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsWorkflowInstances(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsWorkflowInstances(pk);
	}

	/**
	* Adds an association between the workflow and the workflow instance. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstancePK the primary key of the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkflowInstance(long pk, long workflowInstancePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addWorkflowInstance(pk, workflowInstancePK);
	}

	/**
	* Adds an association between the workflow and the workflow instance. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstance the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkflowInstance(long pk,
		org.kisti.edison.model.WorkflowInstance workflowInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addWorkflowInstance(pk, workflowInstance);
	}

	/**
	* Adds an association between the workflow and the workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstancePKs the primary keys of the workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkflowInstances(long pk, long[] workflowInstancePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addWorkflowInstances(pk, workflowInstancePKs);
	}

	/**
	* Adds an association between the workflow and the workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstances the workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkflowInstances(long pk,
		java.util.List<org.kisti.edison.model.WorkflowInstance> workflowInstances)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().addWorkflowInstances(pk, workflowInstances);
	}

	/**
	* Clears all associations between the workflow and its workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow to clear the associated workflow instances from
	* @throws SystemException if a system exception occurred
	*/
	public static void clearWorkflowInstances(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().clearWorkflowInstances(pk);
	}

	/**
	* Removes the association between the workflow and the workflow instance. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstancePK the primary key of the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public static void removeWorkflowInstance(long pk, long workflowInstancePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeWorkflowInstance(pk, workflowInstancePK);
	}

	/**
	* Removes the association between the workflow and the workflow instance. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstance the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public static void removeWorkflowInstance(long pk,
		org.kisti.edison.model.WorkflowInstance workflowInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeWorkflowInstance(pk, workflowInstance);
	}

	/**
	* Removes the association between the workflow and the workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstancePKs the primary keys of the workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static void removeWorkflowInstances(long pk,
		long[] workflowInstancePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeWorkflowInstances(pk, workflowInstancePKs);
	}

	/**
	* Removes the association between the workflow and the workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstances the workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public static void removeWorkflowInstances(long pk,
		java.util.List<org.kisti.edison.model.WorkflowInstance> workflowInstances)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeWorkflowInstances(pk, workflowInstances);
	}

	/**
	* Sets the workflow instances associated with the workflow, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstancePKs the primary keys of the workflow instances to be associated with the workflow
	* @throws SystemException if a system exception occurred
	*/
	public static void setWorkflowInstances(long pk, long[] workflowInstancePKs)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setWorkflowInstances(pk, workflowInstancePKs);
	}

	/**
	* Sets the workflow instances associated with the workflow, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstances the workflow instances to be associated with the workflow
	* @throws SystemException if a system exception occurred
	*/
	public static void setWorkflowInstances(long pk,
		java.util.List<org.kisti.edison.model.WorkflowInstance> workflowInstances)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().setWorkflowInstances(pk, workflowInstances);
	}

	public static WorkflowPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WorkflowPersistence)PortletBeanLocatorUtil.locate(org.kisti.edison.service.ClpSerializer.getServletContextName(),
					WorkflowPersistence.class.getName());

			ReferenceRegistry.registerReference(WorkflowUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WorkflowPersistence persistence) {
	}

	private static WorkflowPersistence _persistence;
}