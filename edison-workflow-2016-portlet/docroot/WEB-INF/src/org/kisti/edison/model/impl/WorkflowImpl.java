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

package org.kisti.edison.model.impl;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.util.GetterUtil;

/**
 * The extended model implementation for the Workflow service. Represents a row in the &quot;EDWF_Workflow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.model.Workflow} interface.
 * </p>
 *
 * @author EDISON
 */
public class WorkflowImpl extends WorkflowBaseImpl {
  /*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a workflow model instance should use the {@link org.kisti.edison.model.Workflow} interface instead.
	 */
	public WorkflowImpl() {
	}
  public void setWorkflowModelAttributes(Map<String, Object> attributes, Locale locale){
    
    Long workflowId = GetterUtil.getLong(attributes.get("workflowId"));
    if (workflowId != null) {
      setWorkflowId(workflowId);
    }

    Long companyId = GetterUtil.getLong(attributes.get("companyId"));
    if (companyId != null) {
      setCompanyId(companyId);
    }

    Long userId = GetterUtil.getLong(attributes.get("userId"));
    if (userId != null) {
      setUserId(userId);
    }

    Date createDate = null;
    if(attributes.get("createDate") instanceof Long){
      createDate = new Date(((Long)attributes.get("createDate")).longValue());
    }else{
      createDate = (Date)attributes.get("createDate");
    }
    if (createDate != null) {
      setCreateDate(createDate);
    }

    Date modifiedDate = null;
    if(attributes.get("modifiedDate") instanceof Long){
      createDate = new Date(((Long)attributes.get("modifiedDate")).longValue());
    }else{
      modifiedDate = (Date)attributes.get("modifiedDate");
    }
    if (modifiedDate != null) {
      setModifiedDate(modifiedDate);
    }

    String title = GetterUtil.getString(attributes.get("title"));
    if(title != null && !title.isEmpty()){
      Map<Locale, String> titleMap = getTitleMap();
      titleMap.put(locale, title);
      setTitleMap(titleMap);
    }

    String description = GetterUtil.getString(attributes.get("description"));
    if(description != null && !description.isEmpty()){
      Map<Locale, String> descriptionMap = getDescriptionMap();
      descriptionMap.put(locale, description);
      setDescriptionMap(descriptionMap);;
    }
    

    Boolean isPublic = GetterUtil.getBoolean(attributes.get("isPublic"));

    if (isPublic != null) {
      setIsPublic(isPublic);
    }

    Long parentWorkflowId = GetterUtil.getLong(attributes.get("parentWorkflowId"));

    if (parentWorkflowId != null) {
      setParentWorkflowId(parentWorkflowId);
    }

    String screenLogic = GetterUtil.getString(attributes.get("screenLogic"));

    if (screenLogic != null) {
      setScreenLogic(screenLogic);
    }
  }
}