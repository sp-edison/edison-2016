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

package org.kisti.edison.service.impl;

import java.util.List;

import org.kisti.edison.model.Workflow;
import org.kisti.edison.model.WorkflowInstance;
import org.kisti.edison.service.base.WorkflowInstanceLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the workflow instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.service.WorkflowInstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.service.base.WorkflowInstanceLocalServiceBaseImpl
 * @see org.kisti.edison.service.WorkflowInstanceLocalServiceUtil
 */
public class WorkflowInstanceLocalServiceImpl
	extends WorkflowInstanceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.service.WorkflowInstanceLocalServiceUtil} to access the workflow instance local service.
	 */
  
  public WorkflowInstance createWorkflowInstance() throws SystemException{
    long workflowInstanceId = super.counterLocalService.increment();
    return super.workflowInstanceLocalService.createWorkflowInstance(workflowInstanceId);
  }
  
  @SuppressWarnings("unchecked")
  public List<WorkflowInstance> getWorkflowWorkflowInstancesByWorkflowId(long workflowId) throws SystemException{
    DynamicQuery query = DynamicQueryFactoryUtil.forClass(WorkflowInstance.class);
    query.add(RestrictionsFactoryUtil.eq("workflowId", workflowId));
    query.addOrder(OrderFactoryUtil.desc("workflowInstanceId"));
    return (List<WorkflowInstance>) super.workflowInstanceLocalService.dynamicQuery(query); 
  }
  
}