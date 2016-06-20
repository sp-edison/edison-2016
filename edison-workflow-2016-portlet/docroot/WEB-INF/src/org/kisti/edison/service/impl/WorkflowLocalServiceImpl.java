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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonNode;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.model.Workflow;
import org.kisti.edison.model.WorkflowInstance;
import org.kisti.edison.science.model.ScienceApp;
import org.kisti.edison.science.service.ScienceAppLocalServiceUtil;
import org.kisti.edison.science.service.constants.ScienceAppConstants;
import org.kisti.edison.service.WorkflowInstanceLocalServiceUtil;
import org.kisti.edison.service.WorkflowLocalServiceUtil;
import org.kisti.edison.service.base.WorkflowLocalServiceBaseImpl;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonPropsUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.wfapi.custom.HttpRequestor;
import org.kisti.edison.wfapi.custom.Transformer;
import org.kisti.edison.wfapi.custom.model.MWorkflow;
import org.kisti.edison.wfapi.custom.model.MWorkflow.Simulations.Simulation.ChildNodes;
import org.kisti.edison.wfapi.custom.model.MWorkflow.Simulations.Simulation.ParentNodes;
import org.springframework.http.HttpStatus;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

/**
 * The implementation of the workflow local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link org.kisti.edison.service.WorkflowLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author EDISON
 * @see org.kisti.edison.service.base.WorkflowLocalServiceBaseImpl
 * @see org.kisti.edison.service.WorkflowLocalServiceUtil
 */
public class WorkflowLocalServiceImpl extends WorkflowLocalServiceBaseImpl{
  /*
   * NOTE FOR DEVELOPERS:
   *
   * Never reference this interface directly. Always use {@link
   * org.kisti.edison.service.WorkflowLocalServiceUtil} to access the workflow
   * local service.
   */
  private final String WORKFLOW_ENGINE_URL_PRIVATE = "http://150.183.247.210:9000";
  private final String FILE_API_URL_PRIVATE = "http://150.183.247.210:8080/majin";
  //private final String WORKFLOW_TEMP_PATH = PropsUtil.get(PropsKeys.LIFERAY_HOME)+"/WORKFLOW_TEMP";
  private final String WORKFLOW_TEMP_PATH = PropsUtil.get(PropsKeys.LIFERAY_HOME)+"/WORKFLOW_TEMP";
  
  public Workflow createWorkflow(String screenLogic, String title, HttpServletRequest request)
      throws SystemException, PortalException{
    Workflow workflow = WorkflowLocalServiceUtil.createWorkflow();
    User user = PortalUtil.getUser(request);
    workflow.setTitle(title);
    workflow.setTargetLanguage(LanguageUtil.getLanguageId(PortalUtil.getLocale(request)));
    workflow.setScreenLogic(screenLogic);
    workflow.setUserId(user.getUserId());
    workflow.setCompanyId(PortalUtil.getCompany(request).getCompanyId());
    workflow.setCreateDate(new Date());
    workflow.setIsPublic(false);
    return super.workflowLocalService.addWorkflow(workflow);
  }

  public Workflow createWorkflow() throws SystemException{
    long workflowId = super.counterLocalService.increment();
    return super.workflowLocalService.createWorkflow(workflowId);
  }
  
  public Workflow copyWorkflow(long sourceWorkflowId, HttpServletRequest request) throws SystemException, PortalException{
    User user = PortalUtil.getUser(request);
    Locale locale = PortalUtil.getLocale(request);
    Workflow targetWorkflow = super.workflowLocalService.getWorkflow(sourceWorkflowId);
    targetWorkflow.setParentWorkflowId(sourceWorkflowId);
    targetWorkflow.setTitle("copied from " + targetWorkflow.getTitle(locale));
    targetWorkflow.setWorkflowId(super.counterLocalService.increment());
    targetWorkflow.setCreateDate(new Date());
    targetWorkflow.setUserId(user.getUserId());
    targetWorkflow.setIsPublic(false);
    targetWorkflow.setCompanyId(PortalUtil.getCompany(request).getCompanyId());
    return super.workflowLocalService.addWorkflow(targetWorkflow);
  }
  
  public Workflow updateWorkflow(long workflowId, Map<String, Object> workflowParam, Locale locale) 
      throws SystemException, PortalException{
    Workflow workflow = WorkflowLocalServiceUtil.getWorkflow(workflowId);
    workflow.setWorkflowModelAttributes(workflowParam, locale);
    workflow.setModifiedDate(new Date());
    return super.workflowLocalService.updateWorkflow(workflow);
  }
  
  public Workflow updateWorkflow(Map<String, Object> workflowParam) 
      throws SystemException, PortalException{
    long workflowId = GetterUtil.getLong(workflowParam.get("workflowId"));
    Workflow workflow = WorkflowLocalServiceUtil.getWorkflow(workflowId);
    boolean isPublic =  GetterUtil.getInteger(workflowParam.get("isPublic")) == 1 ? true : false;
    String serviceLang = "";
    String[] serviceLangArray = CustomUtil.paramToArray(workflowParam.get("select_languageId"));
    if(serviceLangArray != null && serviceLangArray.length > 0){
      for(int i=0 ; i< serviceLangArray.length; i++){
        serviceLang += CustomUtil.strNull(serviceLangArray[i]) + ",";
      }
    }
    workflow.setTitleMap(CustomUtil.getLocalizationMap(workflowParam, "title"));
    workflow.setDescriptionMap(CustomUtil.getLocalizationMap(workflowParam, "description"));
    workflow.setTargetLanguage(serviceLang);
    workflow.setIsPublic(isPublic);
    workflow.setModifiedDate(new Date());
    return super.workflowLocalService.updateWorkflow(workflow);
  }
  
  public List<Map<String, Object>> retrieveWorkflows(Map<String, Object> searchParam, Locale locale) throws SystemException{
    return workflowFinder.retrieveWorkflows(searchParam, locale);
  }
  
  public WorkflowInstance pauseWorkflowInstance(long workflowInstanceId) throws PortalException, SystemException, IOException{
    WorkflowInstance workflowInstance = WorkflowInstanceLocalServiceUtil.getWorkflowInstance(workflowInstanceId);
    URL url = new URL(WORKFLOW_ENGINE_URL_PRIVATE+"/api/workflow/"+workflowInstance.getWorkflowUUID()+"/pause");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("PUT");
    
    if (conn.getResponseCode() == HttpStatus.OK.value()) {
    }else{      
      System.out.println("Failed WorkflowEngineService [ pauseWorkflowInstance ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
    }
    conn.disconnect();
    return getWorkflowStatus(workflowInstanceId);
  }
  
  public WorkflowInstance resumeWorkflowInstance(long workflowInstanceId) throws PortalException, SystemException, IOException{
    WorkflowInstance workflowInstance = WorkflowInstanceLocalServiceUtil.getWorkflowInstance(workflowInstanceId);
    URL url = new URL(WORKFLOW_ENGINE_URL_PRIVATE+"/api/workflow/"+workflowInstance.getWorkflowUUID()+"/resume");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("PUT");
    
    if (conn.getResponseCode() == HttpStatus.OK.value()) {
    }else{      
      System.out.println("Failed WorkflowEngineService [ resumeWorkflowInstance ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
    }
    conn.disconnect();
    return getWorkflowStatus(workflowInstanceId);
  }
  
  public WorkflowInstance deleteWorkflowInstance(long workflowInstanceId) throws PortalException, SystemException, IOException{
    WorkflowInstance workflowInstance = WorkflowInstanceLocalServiceUtil.getWorkflowInstance(workflowInstanceId);
    URL url = new URL(WORKFLOW_ENGINE_URL_PRIVATE+"/api/workflow/"+workflowInstance.getWorkflowUUID());
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("DELETE");
    
    if (conn.getResponseCode() == HttpStatus.OK.value()) {
    }else{      
      System.out.println("Failed WorkflowEngineService [ deleteWorkflowInstance ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
    }
    conn.disconnect();
    return WorkflowInstanceLocalServiceUtil.deleteWorkflowInstance(workflowInstanceId);
  }
  
  public WorkflowInstance runWorkflow(
      long workflowId, 
      Map<String, Object> workflowParams,
      HttpServletRequest request) throws SystemException, PortalException, IOException{
    Workflow workflow = getWorkflow(workflowId);
    JsonNode workflowJson = createWorkflow(workflow, workflowParams, request);
    WorkflowInstance workflowInstance = null;
    URL url = new URL(WORKFLOW_ENGINE_URL_PRIVATE+"/api/workflow/create");
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

    conn.setDoOutput(true);
    conn.setRequestMethod("POST");
    conn.setRequestProperty("Accept", "application/json");
    conn.setRequestProperty("Content-Type", "application/json");
    
    OutputStream os = conn.getOutputStream();
    os.write(workflowJson.toString().getBytes());
    os.flush();
    
    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

    String  output = "";    
    StringBuffer responseBuffer = new StringBuffer();
    
    if (conn.getResponseCode() == HttpStatus.CREATED.value()) {
      while ((output = br.readLine()) != null) {
        if(!GetterUtil.getString(output).equals("null")){
          responseBuffer.append(GetterUtil.getString(output));            
          MWorkflow workflowReulst = Transformer.json2Pojo(responseBuffer.toString(), MWorkflow.class);
          
          workflowInstance = createWorkflowInstance(workflowReulst.getUuid(), workflow, request);
        }
      }       
    }else if (conn.getResponseCode() == HttpStatus.BAD_REQUEST.value()) {
      System.out.println("Failed WorkflowEngineService [ runWorkflow ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());
    }else{      
      System.out.println("Failed WorkflowEngineService [ runWorkflow ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
    }
    conn.disconnect();
    System.out.println(workflowInstance != null ? workflowInstance.toString() : "WorkflowInstance is null");
    return workflowInstance;
  }
  
  public WorkflowInstance createWorkflowInstance(
      String workflowUUID, 
      Workflow workflow, 
      HttpServletRequest request) throws SystemException, IOException{
    WorkflowInstance instance = WorkflowInstanceLocalServiceUtil.createWorkflowInstance();
    JsonNode workflowStatusJson = askForWorkflowStatus(workflowUUID);
    MWorkflow workflowStatus = Transformer.json2Pojo(workflowStatusJson, MWorkflow.class);
    instance.setWorkflowId(workflow.getWorkflowId());
    instance.setCompanyId(workflow.getCompanyId());
    instance.setWorkflowUUID(workflowUUID);
    instance.setTitle(workflowStatus.getTitle());
    instance.setCreateDate(GetterUtil.getDate(workflowStatus.getCreatedTime(),
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"), new Date()));
    instance.setUserId(workflow.getUserId());
    instance.setStartTime(GetterUtil.getDate(workflowStatus.getStartTime(),
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"), new Date()));
    instance.setScreenLogic(workflow.getScreenLogic());
    instance.setStatus(workflowStatus.getStatus());
    instance.setStatusResponse(workflowStatusJson.toString());
    WorkflowInstance savedWorkflowInstance = WorkflowInstanceLocalServiceUtil.addWorkflowInstance(instance);
    WorkflowInstanceLocalServiceUtil.addWorkflowWorkflowInstance(workflow.getWorkflowId(), savedWorkflowInstance.getWorkflowInstanceId());
    return savedWorkflowInstance;
  }
  
  public WorkflowInstance getWorkflowStatus(long workflowInstanceId) throws PortalException, SystemException, IOException{
    WorkflowInstance instance = WorkflowInstanceLocalServiceUtil.getWorkflowInstance(workflowInstanceId);
    JsonNode workflowStatusJson = askForWorkflowStatus(instance.getWorkflowUUID());
    return updateWorkflowInstance(workflowStatusJson, instance);
  }
  
  public WorkflowInstance updateWorkflowInstance(
      JsonNode workflowStatusJson, 
      WorkflowInstance workflowInstance) throws SystemException{
    MWorkflow workflowStatus = Transformer.json2Pojo(workflowStatusJson, MWorkflow.class);
    workflowInstance.setStatus(workflowStatus.getStatus());
    workflowInstance.setStatusResponse(workflowStatusJson.toString());
    workflowInstance.setEndTime(GetterUtil.getDate(workflowStatus.getEndTime(),
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"), null));
    return workflowInstanceLocalService.updateWorkflowInstance(workflowInstance);
  }
  
  public JsonNode askForWorkflowStatus(String workflowUUID) throws IOException{
    HttpURLConnection conn = null;
    try{
      URL url = new URL(WORKFLOW_ENGINE_URL_PRIVATE+"/api/workflow/"+workflowUUID+"/status");
      conn = (HttpURLConnection) url.openConnection();
      conn.setDoOutput(true);
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");
      conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
      if(conn.getResponseCode() == HttpStatus.OK.value()){
        String  output = "";    
        StringBuffer responseBuffer = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        while ((output = br.readLine()) != null) {
          if(!GetterUtil.getString(output).equals("null")){
            responseBuffer.append(GetterUtil.getString(output));
          }
        }
        return Transformer.string2Json(responseBuffer.toString());
      }else{
        throw new RuntimeException(
            "Failed WorkflowEngineService [ getWorkflowStatus ] : HTTP error code : "
                + conn.getResponseCode() + ", workflow UUID : " + workflowUUID);
      }
    }finally{
      if(conn != null) conn.disconnect();
    }
  }
  
  public String getWorkflowSimulationLog(String workflowUUID, String simulationUUID) throws IOException{
    return askForWorkflowSimulationLog(workflowUUID, simulationUUID, "output");
  }
  
  public String getWorkflowSimulationErrorLog(String workflowUUID, String simulationUUID) throws IOException{
    return askForWorkflowSimulationLog(workflowUUID, simulationUUID, "error");
  }
  
  private String askForWorkflowSimulationLog(String workflowUUID, String simulationUUID, String logType) throws IOException{
    HttpURLConnection conn = null;
    try{
      URL url = new URL(WORKFLOW_ENGINE_URL_PRIVATE+"/api/workflow/"+workflowUUID+"/simulation/"+ simulationUUID +"/log/" + logType);
      conn = (HttpURLConnection) url.openConnection();
      conn.setDoOutput(true);
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "text/plain");
      if(conn.getResponseCode() == HttpStatus.OK.value()){
        String  output = "";    
        StringBuffer responseBuffer = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        while ((output = br.readLine()) != null) {
          if(!GetterUtil.getString(output).equals("null")){
            responseBuffer.append(CustomUtil.strNull(output)+"<br/>");
          }
        }
        return responseBuffer.toString();
      }else{
        throw new RuntimeException(
            "Failed WorkflowEngineService [ askForWorkflowSimulationLog " + logType + " ] : HTTP error code : "
                + conn.getResponseCode() + ", workflow UUID : " + workflowUUID+ ", simulation UUID : " + simulationUUID);
      }
    }finally{
      if(conn != null) conn.disconnect();
    }
  }
  
  public JsonNode createWorkflow(
      Workflow workflow, 
      Map<String, Object> workflowParams,
      HttpServletRequest request) throws SystemException, PortalException, IOException{
    long companyId = PortalUtil.getCompanyId(request);
    Locale locale = PortalUtil.getLocale(request);
    String exec_path = PrefsPropsUtil.getString(companyId, EdisonPropsUtil.SCIENCEAPP_BASE_PATH);
    JSONObject screenLogic = JSONFactoryUtil.createJSONObject(workflow.getScreenLogic());
    JSONArray simulationJsonArray = screenLogic.getJSONArray("elements");
    User user = PortalUtil.getUser(request);
    MWorkflow mWorkflow = new MWorkflow();
    mWorkflow.setTitle(GetterUtil.getString(workflowParams.get("workflowInstanceTitle")));
    mWorkflow.setAccessToken(GetterUtil.getString(workflowParams.get("icebreakerVcToken")));
    mWorkflow.setUserId(user.getScreenName());
    mWorkflow.setSimulations(getSimulations(exec_path, locale, simulationJsonArray));
    return Transformer.pojo2Json(mWorkflow);
  }

  private List<MWorkflow.Simulations.Simulation> getSimulations(String exec_path, Locale locale, JSONArray simulationJsonArray)
      throws PortalException, SystemException, IOException, JSONException{
    MWorkflow.Simulations simulations = new MWorkflow.Simulations();
    for(int i=0; i<simulationJsonArray.length(); i++){
      String clientId = simulationJsonArray.getJSONObject(i).getString("id");
      JSONObject data = simulationJsonArray.getJSONObject(i).getJSONObject("data");
      
      ScienceApp scienceApp = ScienceAppLocalServiceUtil.getScienceApp(data.getLong("scienceAppId"));
      scienceApp.setTitle(scienceApp.getTitle(locale));
      MWorkflow.Simulations.Simulation simulation = new MWorkflow.Simulations.Simulation();
      simulation.setSolverId(String.valueOf(scienceApp.getScienceAppId()));
      simulation.setTitle(scienceApp.getName());
      simulation.setDescription(scienceApp.getTitle());
      simulation.setClientId(clientId);
      simulation.getJobs().add(getJob(exec_path, data, scienceApp));
      if(data.has("parentNodes")){
        ParentNodes parents = new ParentNodes();
        JSONArray parentsJson = data.getJSONArray("parentNodes");
        for(int j=0; j<parentsJson.length(); j++){
          parents.getParentNode().add(parentsJson.getString(j));
        }
        if(parents.getParentNode().size() > 0){
          simulation.setParentNodes(parents);
        }
      }
      if(data.has("childNodes")){
        ChildNodes children = new ChildNodes();
        JSONArray childrenJson = data.getJSONArray("childNodes");
        for(int j=0; j<childrenJson.length(); j++){
          children.getChildNode().add(childrenJson.getString(j));
        }
        if(children.getChildNode().size() > 0){
          simulation.setChildNodes(children);
        }
      }
      simulations.getSimulation().add(simulation);
    }
    return simulations.getSimulation();
  }

  private MWorkflow.Simulations.Simulation.Jobs.Job getJob(String exec_path, JSONObject data, ScienceApp scienceApp)
      throws PortalException, SystemException, IOException, JSONException{
    MWorkflow.Simulations.Simulation.Jobs.Job job = new MWorkflow.Simulations.Simulation.Jobs.Job();
    JSONObject inputports = data.getJSONObject("inputports");
    Iterator<String> inputPortNames = inputports.keys();
    job.setTitle(scienceApp.getName());
    job.setDescription(scienceApp.getTitle());
    job.setExecutable(exec_path + ScienceAppLocalServiceUtil.getScienceAppBinPath(scienceApp.getScienceAppId()));
    job.setType(scienceApp.getRunType().toUpperCase());
    job.getDependencies().getItem().add(new MWorkflow.Simulations.Simulation.Jobs.Job.Dependencies.Item("dummyKey", "dummyValue"));
    if(ScienceAppConstants.APP_RUNTYPE_PARALLEL.equals(scienceApp.getRunType())){
      String cpuValue = data.has("cpuNumber") ? data.getString("cpuNumber") : data.getString("defaultCpus");
      String category = data.getString("parallelModule");
      MWorkflow.Simulations.Simulation.Jobs.Job.Attributes.Item item 
        = new MWorkflow.Simulations.Simulation.Jobs.Job.Attributes.Item("np", cpuValue);
      job.setCategory(category != null ? category.toUpperCase() : category);
      job.getAttributes().getItem().add(item);
    }
    List<String> executions = new ArrayList<>();
    MWorkflow.Simulations.Simulation.Jobs.Job.Files files = new MWorkflow.Simulations.Simulation.Jobs.Job.Files();
    while(inputPortNames.hasNext()){
      String inputPortName = inputPortNames.next();
      JSONObject inputport = inputports.getJSONObject(inputPortName);
      MWorkflow.Simulations.Simulation.Jobs.Job.Files.Item item = new MWorkflow.Simulations.Simulation.Jobs.Job.Files.Item();
      // if parent node exist
      if(inputport.has("hasParent") && inputport.getBoolean("hasParent")){
        executions.add(inputPortName + " $cmd" + inputPortName);
        item.setKey("cmd" + inputPortName);
        item.setExpectedSource(inputport.getString("expectedSource"));
        item.setExpectedValue(inputport.getString("expectedValue"));
        files.getItem().add(item);
        continue;
      }
      String defaultEditorType = inputport.getString("defaultEditorType");
      if(ScienceAppConstants.EDITOR_TYPE_INPUT_DECK.equals(defaultEditorType)){
        JSONArray arrInputdeckData = JSONFactoryUtil.createJSONArray(inputport.getString("input-value"));
        JSONObject inputdeckData = arrInputdeckData.getJSONObject(0);
        executions.add(inputPortName + " $inputdeck");
        item.setKey("inputdeck");
        item.setValue(uploadFileToWorkflowEngine(inputdeckData.getString("file-content")));
        files.getItem().add(item);
      }else if(ScienceAppConstants.EDITOR_TYPE_FILE.equals(defaultEditorType)){
        executions.add(inputPortName + " $cmd" + inputPortName);
        JSONObject inputValue = inputport.getJSONObject("input-value");
        if(inputValue != null){
          String fileId = inputValue.getString("fileId");
          String fileName = inputValue.getString("fileName");
          File downloadFile = downloadFileApi(fileId, fileName);
          item.setKey("cmd" + inputPortName);
          item.setValue(uploadFileToWorkflowEngine(downloadFile));
          files.getItem().add(item);
        }
      }else if(ScienceAppConstants.EDITOR_TYPE_STRING.equals(defaultEditorType)){
        executions.add(inputPortName + " " + inputport.getString("input-value"));
      }else{
        executions.add(inputPortName + " $cmd" + inputPortName);
        item.setKey("cmd" + inputPortName);
        item.setValue(uploadFileToWorkflowEngine(inputport.getString("input-value")));
        files.getItem().add(item);
      }
    }
    if(files.getItem().size() > 0){
      job.setFiles(files);
    }
    if(executions.size() > 0){
      job.setExecution(StringUtils.collectionToDelimitedString(executions, " "));
    }
    return job;
  }
  
  public File downloadFileApi(String fileId, String fileName) throws IOException{
    File tempFolder = new File(WORKFLOW_TEMP_PATH);
    if(!tempFolder.exists()){
      tempFolder.mkdirs();
    }
    File downloadedFile = null;
    URL url = new URL(FILE_API_URL_PRIVATE + "/api/file/download" + "?id=" + fileId);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setDoOutput(true);
    conn.setRequestMethod("GET");
    if (conn.getResponseCode() == HttpStatus.OK.value()) {
      fileName = fileId + "_" +fileName;
      downloadedFile = new File(tempFolder + "/" + fileName);
      if(!downloadedFile.exists()){
        downloadedFile.createNewFile();
      }
      InputStream is = conn.getInputStream();
      FileOutputStream os = new FileOutputStream(downloadedFile);
      FileCopyUtils.copy(is, os);
      os.flush();
      is.close();
    }else{      
      System.out.println("Failed WorkflowEngineService [ downloadFileApi ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
    }
    conn.disconnect();
    return downloadedFile;
  }
  
  private String getFileName(String conn) {
    StringTokenizer cd = new StringTokenizer(conn, ";", false);
    String returnValue = "";
    while(cd.hasMoreTokens()){
      String token = cd.nextToken();
      if(token.contains("filename=")){
        returnValue = token.substring(token.indexOf("=")+1);
      }
    }
    return returnValue.isEmpty() ? "resultFile.tmp" : returnValue;
  }
  
  public String uploadFileToWorkflowEngine(File fileContent) throws IOException, JSONException{
    URL url = new URL(WORKFLOW_ENGINE_URL_PRIVATE+"/api/file/upload");
    HttpRequestor requestor = new HttpRequestor(url);
    requestor.addFile("file", fileContent);
    String resultString = requestor.sendMultipartPost();
    JSONObject result = JSONFactoryUtil.createJSONObject(resultString);
    System.out.println("file upload result : " + result.getString("fileId"));
    if(fileContent != null && fileContent.exists()){
      fileContent.delete();
    }
    return result.getString("fileId");
  }
  
  public String uploadFileToWorkflowEngine(InputStream fileContent) throws IOException, JSONException{
    URL url = new URL(WORKFLOW_ENGINE_URL_PRIVATE+"/api/file/upload");
    HttpRequestor requestor = new HttpRequestor(url);
    requestor.addFile("file", fileContent);
    
    String resultString = requestor.sendMultipartPost();
    JSONObject result = JSONFactoryUtil.createJSONObject(resultString);
    System.out.println("file upload result : " + result.getString("fileId"));
    return result.getString("fileId");
  }
  
  public String uploadFileToWorkflowEngine(String fileContent) throws IOException, JSONException{
    return uploadFileToWorkflowEngine(new ByteArrayInputStream(fileContent.getBytes()));
  }
  
  @SuppressWarnings("unchecked")
  public List<Workflow> getWorkflowsByLikeSearch(Map<String, Object> searchParam) throws SystemException{
    int begin = GetterUtil.getInteger(searchParam.get("begin"), -1);
    int end = GetterUtil.getInteger(searchParam.get("end"), -1);
    DynamicQuery query = makeWorkflowListWhereClause(searchParam);
    query.addOrder(OrderFactoryUtil.desc("createDate"));
    return (List<Workflow>) super.workflowLocalService.dynamicQuery(query, begin, end); 
  }

  public long getCountWorkflowsByLikeSearch(Map<String, Object> serachParam) throws SystemException{
    DynamicQuery query = makeWorkflowListWhereClause(serachParam);
    return workflowLocalService.dynamicQueryCount(query);
  }
  
  private DynamicQuery makeWorkflowListWhereClause(Map<String, Object> serachParam){
    DynamicQuery query = DynamicQueryFactoryUtil.forClass(Workflow.class);
    Iterator<String> keys = serachParam.keySet().iterator();
    while(keys.hasNext()){
      String key = keys.next();
      if("begin".equals(key) || "end".equals(key) ){
        continue;
      }
      if("targetLanguage".equals(key)){
        query.add(RestrictionsFactoryUtil.like(key, "%" + serachParam.get(key) + "%"));
      }
      if("title".equals(key)){
        query.add(RestrictionsFactoryUtil.like(key, "%" + serachParam.get(key) + "%"));
      }
      if("userId".equals(key)){
        query.add(RestrictionsFactoryUtil.eq(key, serachParam.get(key)));
      }
      if("isPublic".equals(key)){
        query.add(RestrictionsFactoryUtil.eq(key, serachParam.get(key)));
      }
    }
    return query;
  }
  
  public long getCountWorkflowInstanceByUserId(
      User user, 
      Map<String, Object> params) throws SystemException{
    long groupId = GetterUtil.getLong(params.get("groupId"));
    if(!EdisonUserUtil.isPowerUserThan(user) 
        && !EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)){
      params.put("userId", user.getUserId());
    }
    return workflowFinder.countWorkflowInstances(params);
  }
  
  public List<Map<String, Object>> getWorkflowInstanceByUserId(
      User user, 
      Map<String, Object> params,
      Locale locale
      ) throws SystemException{
    long groupId = GetterUtil.getLong(params.get("groupId"));
    if(!EdisonUserUtil.isPowerUserThan(user) 
        && !EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)){
      params.put("userId", user.getUserId());
    }
    return workflowFinder.retrieveWorkflowInstances(params, locale);
  }
}