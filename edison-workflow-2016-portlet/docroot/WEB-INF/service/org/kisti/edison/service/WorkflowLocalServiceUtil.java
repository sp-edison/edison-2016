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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Workflow. This utility wraps
 * {@link org.kisti.edison.service.impl.WorkflowLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EDISON
 * @see WorkflowLocalService
 * @see org.kisti.edison.service.base.WorkflowLocalServiceBaseImpl
 * @see org.kisti.edison.service.impl.WorkflowLocalServiceImpl
 * @generated
 */
public class WorkflowLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.kisti.edison.service.impl.WorkflowLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the workflow to the database. Also notifies the appropriate model listeners.
	*
	* @param workflow the workflow
	* @return the workflow that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow addWorkflow(
		org.kisti.edison.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addWorkflow(workflow);
	}

	/**
	* Creates a new workflow with the primary key. Does not add the workflow to the database.
	*
	* @param workflowId the primary key for the new workflow
	* @return the new workflow
	*/
	public static org.kisti.edison.model.Workflow createWorkflow(
		long workflowId) {
		return getService().createWorkflow(workflowId);
	}

	/**
	* Deletes the workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowId the primary key of the workflow
	* @return the workflow that was removed
	* @throws PortalException if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow deleteWorkflow(
		long workflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWorkflow(workflowId);
	}

	/**
	* Deletes the workflow from the database. Also notifies the appropriate model listeners.
	*
	* @param workflow the workflow
	* @return the workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow deleteWorkflow(
		org.kisti.edison.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteWorkflow(workflow);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.kisti.edison.model.impl.WorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static org.kisti.edison.model.Workflow fetchWorkflow(long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchWorkflow(workflowId);
	}

	/**
	* Returns the workflow with the primary key.
	*
	* @param workflowId the primary key of the workflow
	* @return the workflow
	* @throws PortalException if a workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow getWorkflow(long workflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkflow(workflowId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<org.kisti.edison.model.Workflow> getWorkflows(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkflows(start, end);
	}

	/**
	* Returns the number of workflows.
	*
	* @return the number of workflows
	* @throws SystemException if a system exception occurred
	*/
	public static int getWorkflowsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkflowsCount();
	}

	/**
	* Updates the workflow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workflow the workflow
	* @return the workflow that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.kisti.edison.model.Workflow updateWorkflow(
		org.kisti.edison.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWorkflow(workflow);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkflowInstanceWorkflow(long workflowInstanceId,
		long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addWorkflowInstanceWorkflow(workflowInstanceId, workflowId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkflowInstanceWorkflow(long workflowInstanceId,
		org.kisti.edison.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addWorkflowInstanceWorkflow(workflowInstanceId, workflow);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkflowInstanceWorkflows(long workflowInstanceId,
		long[] workflowIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.addWorkflowInstanceWorkflows(workflowInstanceId, workflowIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void addWorkflowInstanceWorkflows(long workflowInstanceId,
		java.util.List<org.kisti.edison.model.Workflow> Workflows)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().addWorkflowInstanceWorkflows(workflowInstanceId, Workflows);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void clearWorkflowInstanceWorkflows(long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().clearWorkflowInstanceWorkflows(workflowInstanceId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWorkflowInstanceWorkflow(long workflowInstanceId,
		long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteWorkflowInstanceWorkflow(workflowInstanceId, workflowId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWorkflowInstanceWorkflow(long workflowInstanceId,
		org.kisti.edison.model.Workflow workflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteWorkflowInstanceWorkflow(workflowInstanceId, workflow);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWorkflowInstanceWorkflows(
		long workflowInstanceId, long[] workflowIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteWorkflowInstanceWorkflows(workflowInstanceId, workflowIds);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteWorkflowInstanceWorkflows(
		long workflowInstanceId,
		java.util.List<org.kisti.edison.model.Workflow> Workflows)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteWorkflowInstanceWorkflows(workflowInstanceId, Workflows);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> getWorkflowInstanceWorkflows(
		long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkflowInstanceWorkflows(workflowInstanceId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> getWorkflowInstanceWorkflows(
		long workflowInstanceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getWorkflowInstanceWorkflows(workflowInstanceId, start, end);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.kisti.edison.model.Workflow> getWorkflowInstanceWorkflows(
		long workflowInstanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getWorkflowInstanceWorkflows(workflowInstanceId, start,
			end, orderByComparator);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static int getWorkflowInstanceWorkflowsCount(long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkflowInstanceWorkflowsCount(workflowInstanceId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasWorkflowInstanceWorkflow(long workflowInstanceId,
		long workflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .hasWorkflowInstanceWorkflow(workflowInstanceId, workflowId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static boolean hasWorkflowInstanceWorkflows(long workflowInstanceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasWorkflowInstanceWorkflows(workflowInstanceId);
	}

	/**
	* @throws SystemException if a system exception occurred
	*/
	public static void setWorkflowInstanceWorkflows(long workflowInstanceId,
		long[] workflowIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.setWorkflowInstanceWorkflows(workflowInstanceId, workflowIds);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static org.kisti.edison.model.Workflow createWorkflow(
		java.lang.String screenLogic, java.lang.String title,
		javax.servlet.http.HttpServletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().createWorkflow(screenLogic, title, request);
	}

	public static org.kisti.edison.model.Workflow createWorkflow()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createWorkflow();
	}

	public static org.kisti.edison.model.Workflow copyWorkflow(
		long sourceWorkflowId, javax.servlet.http.HttpServletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().copyWorkflow(sourceWorkflowId, request);
	}

	public static org.kisti.edison.model.Workflow updateWorkflow(
		long workflowId,
		java.util.Map<java.lang.String, java.lang.Object> workflowParam)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateWorkflow(workflowId, workflowParam);
	}

	public static java.util.List<java.util.Map<java.lang.String, java.lang.Object>> retrieveWorkflows(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().retrieveWorkflows(searchParam);
	}

	public static org.codehaus.jackson.JsonNode runWorkflow(long workflowId,
		java.util.Map<java.lang.String, java.lang.Object> iceBreakerInfo,
		javax.servlet.http.HttpServletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService().runWorkflow(workflowId, iceBreakerInfo, request);
	}

	public static org.codehaus.jackson.JsonNode createWorkflow(
		long workflowId,
		java.util.Map<java.lang.String, java.lang.Object> iceBreakerInfo,
		javax.servlet.http.HttpServletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException {
		return getService().createWorkflow(workflowId, iceBreakerInfo, request);
	}

	public static java.lang.String uploadFileToWorkflowEngine(
		java.lang.String fileContent)
		throws com.liferay.portal.kernel.json.JSONException, java.io.IOException {
		return getService().uploadFileToWorkflowEngine(fileContent);
	}

	public static java.lang.String getIceBreakAccessToken(
		javax.servlet.http.HttpServletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.io.IOException, java.net.MalformedURLException,
			java.text.ParseException {
		return getService().getIceBreakAccessToken(request);
	}

	public static java.util.List<org.kisti.edison.model.Workflow> getWorkflowsByLikeSearch(
		java.util.Map<java.lang.String, java.lang.Object> searchParam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getWorkflowsByLikeSearch(searchParam);
	}

	public static long getCountWorkflowsByLikeSearch(
		java.util.Map<java.lang.String, java.lang.Object> serachParam)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountWorkflowsByLikeSearch(serachParam);
	}

	public static void clearService() {
		_service = null;
	}

	public static WorkflowLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WorkflowLocalService.class.getName());

			if (invokableLocalService instanceof WorkflowLocalService) {
				_service = (WorkflowLocalService)invokableLocalService;
			}
			else {
				_service = new WorkflowLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(WorkflowLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(WorkflowLocalService service) {
	}

	private static WorkflowLocalService _service;
}