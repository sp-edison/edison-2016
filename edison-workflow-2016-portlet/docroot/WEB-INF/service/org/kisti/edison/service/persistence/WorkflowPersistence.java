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

import com.liferay.portal.service.persistence.BasePersistence;

import org.kisti.edison.model.Workflow;

/**
 * The persistence interface for the workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EDISON
 * @see WorkflowPersistenceImpl
 * @see WorkflowUtil
 * @generated
 */
public interface WorkflowPersistence extends BasePersistence<Workflow> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkflowUtil} to access the workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the workflows where title LIKE &#63;.
	*
	* @param title the title
	* @return the matching workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.Workflow> findByTitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.model.Workflow> findByTitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.model.Workflow> findByTitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first workflow in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow
	* @throws org.kisti.edison.NoSuchWorkflowException if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.Workflow findByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException;

	/**
	* Returns the first workflow in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow, or <code>null</code> if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.Workflow fetchByTitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last workflow in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow
	* @throws org.kisti.edison.NoSuchWorkflowException if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.Workflow findByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException;

	/**
	* Returns the last workflow in the ordered set where title LIKE &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow, or <code>null</code> if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.Workflow fetchByTitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.model.Workflow[] findByTitle_PrevAndNext(
		long workflowId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException;

	/**
	* Removes all the workflows where title LIKE &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workflows where title LIKE &#63;.
	*
	* @param title the title
	* @return the number of matching workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the workflows where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @return the matching workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.Workflow> findByIsPublic(
		boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.model.Workflow> findByIsPublic(
		boolean isPublic, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.model.Workflow> findByIsPublic(
		boolean isPublic, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first workflow in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow
	* @throws org.kisti.edison.NoSuchWorkflowException if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.Workflow findByIsPublic_First(
		boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException;

	/**
	* Returns the first workflow in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching workflow, or <code>null</code> if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.Workflow fetchByIsPublic_First(
		boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last workflow in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow
	* @throws org.kisti.edison.NoSuchWorkflowException if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.Workflow findByIsPublic_Last(
		boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException;

	/**
	* Returns the last workflow in the ordered set where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching workflow, or <code>null</code> if a matching workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.Workflow fetchByIsPublic_Last(
		boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.kisti.edison.model.Workflow[] findByIsPublic_PrevAndNext(
		long workflowId, boolean isPublic,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException;

	/**
	* Removes all the workflows where isPublic = &#63; from the database.
	*
	* @param isPublic the is public
	* @throws SystemException if a system exception occurred
	*/
	public void removeByIsPublic(boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workflows where isPublic = &#63;.
	*
	* @param isPublic the is public
	* @return the number of matching workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countByIsPublic(boolean isPublic)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the workflow in the entity cache if it is enabled.
	*
	* @param workflow the workflow
	*/
	public void cacheResult(org.kisti.edison.model.Workflow workflow);

	/**
	* Caches the workflows in the entity cache if it is enabled.
	*
	* @param workflows the workflows
	*/
	public void cacheResult(
		java.util.List<org.kisti.edison.model.Workflow> workflows);

	/**
	* Creates a new workflow with the primary key. Does not add the workflow to the database.
	*
	* @param workflowId the primary key for the new workflow
	* @return the new workflow
	*/
	public org.kisti.edison.model.Workflow create(long workflowId);

	/**
	* Removes the workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowId the primary key of the workflow
	* @return the workflow that was removed
	* @throws org.kisti.edison.NoSuchWorkflowException if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.Workflow remove(long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException;

	public org.kisti.edison.model.Workflow updateImpl(
		org.kisti.edison.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the workflow with the primary key or throws a {@link org.kisti.edison.NoSuchWorkflowException} if it could not be found.
	*
	* @param workflowId the primary key of the workflow
	* @return the workflow
	* @throws org.kisti.edison.NoSuchWorkflowException if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.Workflow findByPrimaryKey(long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.kisti.edison.NoSuchWorkflowException;

	/**
	* Returns the workflow with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workflowId the primary key of the workflow
	* @return the workflow, or <code>null</code> if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.kisti.edison.model.Workflow fetchByPrimaryKey(long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the workflows.
	*
	* @return the workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.Workflow> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.model.Workflow> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.model.Workflow> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the workflows from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workflows.
	*
	* @return the number of workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the workflow instances associated with the workflow.
	*
	* @param pk the primary key of the workflow
	* @return the workflow instances associated with the workflow
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.kisti.edison.model.WorkflowInstance> getWorkflowInstances(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.model.WorkflowInstance> getWorkflowInstances(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.kisti.edison.model.WorkflowInstance> getWorkflowInstances(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of workflow instances associated with the workflow.
	*
	* @param pk the primary key of the workflow
	* @return the number of workflow instances associated with the workflow
	* @throws SystemException if a system exception occurred
	*/
	public int getWorkflowInstancesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the workflow instance is associated with the workflow.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstancePK the primary key of the workflow instance
	* @return <code>true</code> if the workflow instance is associated with the workflow; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsWorkflowInstance(long pk, long workflowInstancePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the workflow has any workflow instances associated with it.
	*
	* @param pk the primary key of the workflow to check for associations with workflow instances
	* @return <code>true</code> if the workflow has any workflow instances associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsWorkflowInstances(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the workflow and the workflow instance. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstancePK the primary key of the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkflowInstance(long pk, long workflowInstancePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the workflow and the workflow instance. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstance the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkflowInstance(long pk,
		org.kisti.edison.model.WorkflowInstance workflowInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the workflow and the workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstancePKs the primary keys of the workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkflowInstances(long pk, long[] workflowInstancePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the workflow and the workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstances the workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public void addWorkflowInstances(long pk,
		java.util.List<org.kisti.edison.model.WorkflowInstance> workflowInstances)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the workflow and its workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow to clear the associated workflow instances from
	* @throws SystemException if a system exception occurred
	*/
	public void clearWorkflowInstances(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the workflow and the workflow instance. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstancePK the primary key of the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkflowInstance(long pk, long workflowInstancePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the workflow and the workflow instance. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstance the workflow instance
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkflowInstance(long pk,
		org.kisti.edison.model.WorkflowInstance workflowInstance)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the workflow and the workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstancePKs the primary keys of the workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkflowInstances(long pk, long[] workflowInstancePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the workflow and the workflow instances. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstances the workflow instances
	* @throws SystemException if a system exception occurred
	*/
	public void removeWorkflowInstances(long pk,
		java.util.List<org.kisti.edison.model.WorkflowInstance> workflowInstances)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the workflow instances associated with the workflow, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstancePKs the primary keys of the workflow instances to be associated with the workflow
	* @throws SystemException if a system exception occurred
	*/
	public void setWorkflowInstances(long pk, long[] workflowInstancePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the workflow instances associated with the workflow, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the workflow
	* @param workflowInstances the workflow instances to be associated with the workflow
	* @throws SystemException if a system exception occurred
	*/
	public void setWorkflowInstances(long pk,
		java.util.List<org.kisti.edison.model.WorkflowInstance> workflowInstances)
		throws com.liferay.portal.kernel.exception.SystemException;
}