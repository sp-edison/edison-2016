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

package org.kisti.edison.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkflowInstanceLocalService}.
 *
 * @author EDISON
 * @see WorkflowInstanceLocalService
 * @generated
 */
public class WorkflowInstanceLocalServiceWrapper
	implements WorkflowInstanceLocalService,
		ServiceWrapper<WorkflowInstanceLocalService> {
	public WorkflowInstanceLocalServiceWrapper(
		WorkflowInstanceLocalService workflowInstanceLocalService) {
		_workflowInstanceLocalService = workflowInstanceLocalService;
	}

	/**
	* Adds the workflow instance to the database. Also notifies the appropriate model listeners.
	*
	* @param workflowInstance the workflow instance
	* @return the workflow instance that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.model.WorkflowInstance addWorkflowInstance(
		org.kisti.edison.model.WorkflowInstance workflowInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.addWorkflowInstance(workflowInstance);
	}

	/**
	* Creates a new workflow instance with the primary key. Does not add the workflow instance to the database.
	*
	* @param workflowInstanceId the primary key for the new workflow instance
	* @return the new workflow instance
	*/
	@Override
	public org.kisti.edison.model.WorkflowInstance createWorkflowInstance(
		long workflowInstanceId) {
		return _workflowInstanceLocalService.createWorkflowInstance(workflowInstanceId);
	}

	/**
	* Deletes the workflow instance with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowInstanceId the primary key of the workflow instance
	* @return the workflow instance that was removed
	* @throws PortalException if a workflow instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.model.WorkflowInstance deleteWorkflowInstance(
		long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.deleteWorkflowInstance(workflowInstanceId);
	}

	/**
	* Deletes the workflow instance from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowInstance the workflow instance
	* @return the workflow instance that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.model.WorkflowInstance deleteWorkflowInstance(
		org.kisti.edison.model.WorkflowInstance workflowInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.deleteWorkflowInstance(workflowInstance);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workflowInstanceLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowInstanceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public org.kisti.edison.model.WorkflowInstance fetchWorkflowInstance(
		long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.fetchWorkflowInstance(workflowInstanceId);
	}

	/**
	* Returns the workflow instance with the primary key.
	*
	* @param workflowInstanceId the primary key of the workflow instance
	* @return the workflow instance
	* @throws PortalException if a workflow instance with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.model.WorkflowInstance getWorkflowInstance(
		long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.getWorkflowInstance(workflowInstanceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<org.kisti.edison.model.WorkflowInstance> getWorkflowInstances(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.getWorkflowInstances(start, end);
	}

	/**
	* Returns the number of workflow instances.
	*
	* @return the number of workflow instances
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getWorkflowInstancesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.getWorkflowInstancesCount();
	}

	/**
	* Updates the workflow instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workflowInstance the workflow instance
	* @return the workflow instance that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public org.kisti.edison.model.WorkflowInstance updateWorkflowInstance(
		org.kisti.edison.model.WorkflowInstance workflowInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.updateWorkflowInstance(workflowInstance);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addWorkflowWorkflowInstance(long workflowId,
		long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflowInstanceLocalService.addWorkflowWorkflowInstance(workflowId,
			workflowInstanceId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addWorkflowWorkflowInstance(long workflowId,
		org.kisti.edison.model.WorkflowInstance workflowInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflowInstanceLocalService.addWorkflowWorkflowInstance(workflowId,
			workflowInstance);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addWorkflowWorkflowInstances(long workflowId,
		long[] workflowInstanceIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflowInstanceLocalService.addWorkflowWorkflowInstances(workflowId,
			workflowInstanceIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void addWorkflowWorkflowInstances(long workflowId,
		java.util.List<org.kisti.edison.model.WorkflowInstance> WorkflowInstances)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflowInstanceLocalService.addWorkflowWorkflowInstances(workflowId,
			WorkflowInstances);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void clearWorkflowWorkflowInstances(long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflowInstanceLocalService.clearWorkflowWorkflowInstances(workflowId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteWorkflowWorkflowInstance(long workflowId,
		long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflowInstanceLocalService.deleteWorkflowWorkflowInstance(workflowId,
			workflowInstanceId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteWorkflowWorkflowInstance(long workflowId,
		org.kisti.edison.model.WorkflowInstance workflowInstance)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflowInstanceLocalService.deleteWorkflowWorkflowInstance(workflowId,
			workflowInstance);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteWorkflowWorkflowInstances(long workflowId,
		long[] workflowInstanceIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflowInstanceLocalService.deleteWorkflowWorkflowInstances(workflowId,
			workflowInstanceIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void deleteWorkflowWorkflowInstances(long workflowId,
		java.util.List<org.kisti.edison.model.WorkflowInstance> WorkflowInstances)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflowInstanceLocalService.deleteWorkflowWorkflowInstances(workflowId,
			WorkflowInstances);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.model.WorkflowInstance> getWorkflowWorkflowInstances(
		long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.getWorkflowWorkflowInstances(workflowId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.model.WorkflowInstance> getWorkflowWorkflowInstances(
		long workflowId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.getWorkflowWorkflowInstances(workflowId,
			start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<org.kisti.edison.model.WorkflowInstance> getWorkflowWorkflowInstances(
		long workflowId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.getWorkflowWorkflowInstances(workflowId,
			start, end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getWorkflowWorkflowInstancesCount(long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.getWorkflowWorkflowInstancesCount(workflowId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasWorkflowWorkflowInstance(long workflowId,
		long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.hasWorkflowWorkflowInstance(workflowId,
			workflowInstanceId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public boolean hasWorkflowWorkflowInstances(long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowInstanceLocalService.hasWorkflowWorkflowInstances(workflowId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public void setWorkflowWorkflowInstances(long workflowId,
		long[] workflowInstanceIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflowInstanceLocalService.setWorkflowWorkflowInstances(workflowId,
			workflowInstanceIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _workflowInstanceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_workflowInstanceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _workflowInstanceLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WorkflowInstanceLocalService getWrappedWorkflowInstanceLocalService() {
		return _workflowInstanceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWorkflowInstanceLocalService(
		WorkflowInstanceLocalService workflowInstanceLocalService) {
		_workflowInstanceLocalService = workflowInstanceLocalService;
	}

	@Override
	public WorkflowInstanceLocalService getWrappedService() {
		return _workflowInstanceLocalService;
	}

	@Override
	public void setWrappedService(
		WorkflowInstanceLocalService workflowInstanceLocalService) {
		_workflowInstanceLocalService = workflowInstanceLocalService;
	}

	private WorkflowInstanceLocalService _workflowInstanceLocalService;
}