package org.kisti.edison.wfapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonNode;
import org.kisti.edison.model.Workflow;
import org.kisti.edison.model.WorkflowInstance;
import org.kisti.edison.service.WorkflowInstanceLocalServiceUtil;
import org.kisti.edison.service.WorkflowLocalServiceUtil;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.wfapi.custom.Transformer;
import org.kisti.edison.wfapi.custom.WorkflowBeanUtil;
import org.kisti.edison.wfapi.custom.WorkflowPagingUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

@Controller
@RequestMapping("/services/workflows")
public class WorkflowController{
  private Log log = LogFactoryUtil.getLog(getClass());
  
  @RequestMapping(value = "", method = RequestMethod.POST)
  public @ResponseBody Map<String, Object> getWorkflows(
      @RequestParam Map<String, Object> searchParam,
      @RequestParam(value = "isPublic", required = false) String isPublic,
      HttpServletRequest request)
          throws Exception{
    try{
      Locale locale = PortalUtil.getLocale(request);
      Map<String, Object> listAndPagingMap = new HashMap<>();
      User user = PortalUtil.getUser(request);
      long companyId = PortalUtil.getCompany(request).getCompanyId();
      searchParam.put("userId", user.getUserId());
      searchParam.put("companyId", companyId);
      searchParam.put("targetLanguage", LanguageUtil.getLanguageId(locale));
      if(isPublic != null && !isPublic.isEmpty()){
        boolean isPublicValue = Boolean.valueOf(isPublic);
        searchParam.put("isPublic", isPublicValue);
        if(isPublicValue){
          searchParam.remove("userId");
        }
      }
      String pagingClassName = GetterUtil.getString(searchParam.get("pagingClassName")); 
      int curPage = Integer.parseInt(CustomUtil.strNull(searchParam.get("p_curPage"), "1"));
      int linePerPage = Integer.parseInt(CustomUtil.strNull(searchParam.get("linePerPage"), "10"));
      int pagePerBlock = 5;
      int totalCnt = GetterUtil.getInteger(WorkflowLocalServiceUtil.getCountWorkflowsByLikeSearch(searchParam));
      int totalPage = WorkflowPagingUtil.getTotalPage(totalCnt, curPage, linePerPage);
      
      int begin = (curPage - 1) * linePerPage;
      int end = linePerPage;
      searchParam.put("begin", begin);
      searchParam.put("end", end);
      
      String pagingHtml = WorkflowPagingUtil.getPaging(request.getContextPath(), pagingClassName, totalCnt, curPage, linePerPage, pagePerBlock);
      
      listAndPagingMap.put("workflows", WorkflowLocalServiceUtil.retrieveWorkflows(searchParam, locale));
      listAndPagingMap.put("pagingHtml", pagingHtml);
      listAndPagingMap.put("curPage", curPage);
      listAndPagingMap.put("totalPage", totalPage);
      
      return listAndPagingMap;
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/{workflowId}", method = RequestMethod.GET)
  public @ResponseBody Map<String, Object> getWorkflow(
      @PathVariable("workflowId") long workflowId,
      HttpServletRequest request)
          throws Exception{
    try{
      Locale locale = PortalUtil.getLocale(request);
      Workflow workflow = WorkflowLocalServiceUtil.getWorkflow(workflowId);
      Map<String, Object> workflowMap = workflow.getModelAttributes();
      workflowMap.put("title", workflow.getTitle(locale));
      workflowMap.put("titleMap", workflow.getTitle());
      workflowMap.put("description", workflow.getDescription(locale));
      workflowMap.put("descriptionMap", workflow.getDescription());
      return workflowMap;
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ResponseEntity<?> add(
      @RequestParam("screenLogic") String screenLogic,
      @RequestParam("title") String title,
      HttpServletRequest request){
    try{
      log.debug("screenLogic Json\n" + screenLogic);
      Workflow workflow = WorkflowLocalServiceUtil.createWorkflow(screenLogic, title, request);
      Locale locale = PortalUtil.getLocale(request);
      Map<String, Object> workflowMap = workflow.getModelAttributes();
      workflowMap.put("title", workflow.getTitle(locale));
      workflowMap.put("titleMap", workflow.getTitle());
      workflowMap.put("description", workflow.getDescription(locale));
      workflowMap.put("descriptionMap", workflow.getDescription());
      return new ResponseEntity<>(workflowMap, HttpStatus.OK);
    }catch(Exception e){
      String errorMessage = e.getMessage();
      log.error(errorMessage, e);
      return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
  }
  
  @RequestMapping(value = "/{workflowId}/update", method = RequestMethod.POST)
  public ResponseEntity<?> update(
      @PathVariable("workflowId") long workflowId,
      @RequestBody Map<String, Object> workflowParam,
      HttpServletRequest request){
    try{
      log.debug(workflowParam != null ? workflowParam.toString() : "workflowParam is null");
      Locale locale = PortalUtil.getLocale(request);
      Workflow workflow = WorkflowLocalServiceUtil.updateWorkflow(workflowId, workflowParam, locale);
      Map<String, Object> workflowMap = workflow.getModelAttributes();
      workflowMap.put("title", workflow.getTitle(locale));
      workflowMap.put("titleMap", workflow.getTitle());
      workflowMap.put("description", workflow.getDescription(locale));
      workflowMap.put("descriptionMap", workflow.getDescription());
      return new ResponseEntity<>(workflowMap, HttpStatus.OK);
    }catch(Exception e){
      String errorMessage = e.getMessage();
      log.error(errorMessage, e);
      return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value = "/{workflowId}/copy", method = RequestMethod.POST)
  public @ResponseBody Map<String, Object> copy(
      @PathVariable("workflowId") long workflowId,
      HttpServletRequest request) throws Exception{
    try{
      Workflow workflow = WorkflowLocalServiceUtil.copyWorkflow(workflowId, request);
      Locale locale = PortalUtil.getLocale(request);
      Map<String, Object> workflowMap = workflow.getModelAttributes();
      workflowMap.put("title", workflow.getTitle(locale));
      workflowMap.put("titleMap", workflow.getTitle());
      workflowMap.put("description", workflow.getDescription(locale));
      workflowMap.put("descriptionMap", workflow.getDescription());
      return workflowMap;
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/{workflowId}/delete", method = RequestMethod.POST)
  public @ResponseBody Map<String, Object> removeWorkflow(
      @PathVariable("workflowId") long workflowId,
      HttpServletRequest request)
          throws Exception{
    try{
      return WorkflowLocalServiceUtil.deleteWorkflow(workflowId).getModelAttributes();
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/{workflowId}/run", method = RequestMethod.POST)
  public @ResponseBody Map<String, Object> runWorkflow(
      @RequestParam Map<String, Object> params, 
      @PathVariable("workflowId") long workflowId,
      HttpServletRequest request)
          throws Exception{
    try{
      WorkflowInstance instance = WorkflowLocalServiceUtil.runWorkflow(workflowId, params, request);
      return instance.getModelAttributes();
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/instance/{workflowInstanceId}", method = RequestMethod.GET)
  public @ResponseBody Map<String, Object> workflowInstance(
      @RequestParam Map<String, Object> params, 
      @PathVariable("workflowInstanceId") long workflowInstanceId,
      HttpServletRequest request)
          throws Exception{
    try{
      return WorkflowInstanceLocalServiceUtil.getWorkflowInstance(workflowInstanceId).getModelAttributes();
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/instance/{workflowInstanceId}/status", method = RequestMethod.GET)
  public @ResponseBody JsonNode workflowStatus(
      @RequestParam Map<String, Object> params, 
      @PathVariable("workflowInstanceId") long workflowInstanceId,
      HttpServletRequest request)
          throws Exception{
    try{
      JsonNode status = Transformer.string2Json(WorkflowLocalServiceUtil.getWorkflowStatus(workflowInstanceId).getStatusResponse());
      return status;
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/instance/{workflowInstanceId}/resume", method = RequestMethod.POST)
  public @ResponseBody JsonNode resumeWorkflowInstance(
      @RequestParam Map<String, Object> params, 
      @PathVariable("workflowInstanceId") long workflowInstanceId,
      HttpServletRequest request)
          throws Exception{
    try{
      JsonNode status = Transformer.string2Json(WorkflowLocalServiceUtil.resumeWorkflowInstance(workflowInstanceId).getStatusResponse());
      return status;
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/instance/workflow/{workflowUUID}/simulation/{simulationUUID}/log", method = RequestMethod.GET)
  public @ResponseBody String simulationLog(
      @RequestParam Map<String, Object> params, 
      @PathVariable("workflowUUID") String workflowUUID,
      @PathVariable("simulationUUID") String simulationUUID,
      HttpServletRequest request)
          throws Exception{
    try{
      return WorkflowLocalServiceUtil.getWorkflowSimulationLog(workflowUUID, simulationUUID).replaceAll("[\"\']", " ");
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/instance/workflow/{workflowUUID}/simulation/{simulationUUID}/errorlog", method = RequestMethod.GET)
  public @ResponseBody String simulationErrorLog(
      @RequestParam Map<String, Object> params, 
      @PathVariable("workflowUUID") String workflowUUID,
      @PathVariable("simulationUUID") String simulationUUID,
      HttpServletRequest request)
          throws Exception{
    try{
      return WorkflowLocalServiceUtil.getWorkflowSimulationErrorLog(workflowUUID, simulationUUID).replaceAll("[\"\']", " ");
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/instance/{workflowInstanceId}/pause", method = RequestMethod.POST)
  public @ResponseBody JsonNode pauseWorkflowInstance(
      @RequestParam Map<String, Object> params, 
      @PathVariable("workflowInstanceId") long workflowInstanceId,
      HttpServletRequest request)
          throws Exception{
    try{
      JsonNode status = Transformer.string2Json(WorkflowLocalServiceUtil.pauseWorkflowInstance(workflowInstanceId).getStatusResponse());
      return status;
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/instance/{workflowInstanceId}/delete", method = RequestMethod.POST)
  public @ResponseBody JsonNode removeWorkflowInstance(
      @RequestParam Map<String, Object> params, 
      @PathVariable("workflowInstanceId") long workflowInstanceId,
      HttpServletRequest request)
          throws Exception{
    try{
      JsonNode status = Transformer.string2Json(WorkflowLocalServiceUtil.deleteWorkflowInstance(workflowInstanceId).getStatusResponse());
      return status;
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @SuppressWarnings("serial")
  @RequestMapping(value = "/instance/{workflowInstanceId}/siblings", method = RequestMethod.GET)
  public @ResponseBody List<Map<String, Object>> workflowInstanceList(
      @PathVariable("workflowInstanceId") long workflowInstanceId,
      HttpServletRequest request)
          throws Exception{
    try{
      Locale locale = PortalUtil.getLocale(request);
      List<Map<String, Object>> jstreeList = new ArrayList<>();
      Map<String, Object> rootCategory = new HashMap<String, Object>(){{
        put("id", "currentWorkflowTop");
        put("parent", "#");
        put("text", "Current Workflow");
        put("type", "root");
      }};
      WorkflowInstance currInstance = WorkflowInstanceLocalServiceUtil.getWorkflowInstance(workflowInstanceId);
      Workflow workflow = WorkflowLocalServiceUtil.getWorkflow(currInstance.getWorkflowId());
      List<WorkflowInstance> workflowInstances = WorkflowInstanceLocalServiceUtil.getWorkflowWorkflowInstancesByWorkflowId(workflow.getWorkflowId());
      jstreeList.add(rootCategory);
      jstreeList.add(WorkflowBeanUtil.workflowToJstreeModel(workflow, locale));
      jstreeList.addAll(WorkflowBeanUtil.workflowInstanceToJstreeModel(workflowInstances, locale));
      return jstreeList;
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
  @RequestMapping(value = "/instance", method = RequestMethod.POST)
  public @ResponseBody Map<String, Object> workflowInstanceListByUser(
      @RequestParam Map<String, Object> searchParam, 
      HttpServletRequest request)
          throws Exception{
    try{
      Locale locale = PortalUtil.getLocale(request);
      User user = PortalUtil.getUser(request);
      Map<String, Object> listAndPagingMap = new HashMap<>();
      long companyId = PortalUtil.getCompany(request).getCompanyId();
      searchParam.put("companyId", companyId);
      String pagingClassName = GetterUtil.getString(searchParam.get("pagingClassName")); 
      int curPage = Integer.parseInt(CustomUtil.strNull(searchParam.get("p_curPage"), "1"));
      int linePerPage = Integer.parseInt(CustomUtil.strNull(searchParam.get("linePerPage"), "10"));
      int pagePerBlock = 5;
      int totalCnt = GetterUtil.getInteger(WorkflowLocalServiceUtil.getCountWorkflowInstanceByUserId(user, searchParam));
      int totalPage = WorkflowPagingUtil.getTotalPage(totalCnt, curPage, linePerPage);
      
      int begin = (curPage - 1) * linePerPage;
      int end = linePerPage;
      searchParam.put("begin", begin);
      searchParam.put("end", end);
      
      String pagingHtml = WorkflowPagingUtil.getPaging(request.getContextPath(), pagingClassName, totalCnt, curPage, linePerPage, pagePerBlock);
      
      listAndPagingMap.put("workflowInstances", WorkflowLocalServiceUtil.getWorkflowInstanceByUserId(user, searchParam, locale));
      listAndPagingMap.put("pagingHtml", pagingHtml);
      listAndPagingMap.put("curPage", curPage);
      listAndPagingMap.put("totalPage", totalPage);
      
      return listAndPagingMap;
    }catch (Exception e){
      log.error("error", e);
      throw e;
    }
  }
  
}
