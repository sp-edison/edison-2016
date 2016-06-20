/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package org.kisti.edison.bestsimulation.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.kisti.edison.bestsimulation.model.Simulation;
import org.kisti.edison.bestsimulation.service.base.SimulationLocalServiceBaseImpl;
import org.kisti.edison.bestsimulation.service.persistence.SimulationPK;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.IcebreakerVcToken;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.HttpFileUtil;
import org.kisti.edison.util.TokenProviderUtil;
import org.kisti.edison.util.VCRegisterUtil;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portlet.expando.model.ExpandoColumn;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoColumnLocalServiceUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * The implementation of the simulation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.kisti.edison.bestsimulation.service.SimulationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author mhkang
 * @see org.kisti.edison.bestsimulation.service.base.SimulationLocalServiceBaseImpl
 * @see org.kisti.edison.bestsimulation.service.SimulationLocalServiceUtil
 */
public class SimulationLocalServiceImpl extends SimulationLocalServiceBaseImpl {
	private static Log log = LogFactoryUtil.getLog(SimulationLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link org.kisti.edison.bestsimulation.service.SimulationLocalServiceUtil} to access the simulation local service.
	 */
	
	public Simulation addSimulation(Map params)	throws SystemException {
		System.out.println(CustomUtil.strNull(params.get("testYn")));
		SimulationPK simulationPK = new SimulationPK();
		
		simulationPK.setGroupId((Long)params.get("groupId"));
		simulationPK.setSimulationUuid(CustomUtil.strNull(params.get("simulationUuid")));
		
		Simulation simulation = simulationPersistence.create(simulationPK);
		simulation.setUserId((Long)params.get("userId"));
		simulation.setSimulationTitle(CustomUtil.strNull(params.get("simulation_title")));
		simulation.setSimulationDescription(CustomUtil.strNull(params.get("simulation_description")));
		simulation.setScienceAppId(CustomUtil.strNull(params.get("scienceAppId")));
		simulation.setScienceAppName(CustomUtil.strNull(params.get("scienceApp_name")));
		simulation.setSimulationCreateDt(new Date());
		simulation.setCluster(CustomUtil.strNull(params.get("cluster")));
		simulation.setTestYn(CustomUtil.strNull(params.get("testYn")));
		
		return simulationPersistence.update(simulation);
	}
	
		
	
	/**
	 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	 * ■■■■■■■■■ Icebreaker Service Start ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	 */
	
	public IcebreakerVcToken getOrCreateToken(long thisGroupId, User user) throws MalformedURLException, PortalException, SystemException, IOException, ParseException{
		
		IcebreakerVcToken icebreakerVcToken = new IcebreakerVcToken();

		Group thisGroup = GroupLocalServiceUtil.getGroup(thisGroupId);		
		String userScreenName = "";
		String userPassword = "";
		String universityField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY);
		String virtualLabId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_LAB_ID);
		String classId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_CLASS_ID);
		String majorField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_MAJOR);
		
		if(EdisonUserUtil.isRegularRole(user, RoleConstants.ADMINISTRATOR) || EdisonUserUtil.isSiteRole(user, thisGroupId, RoleConstants.SITE_ADMINISTRATOR)){
			userScreenName = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_ID);
			userPassword = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_PWD);
		}else{
			userScreenName = String.valueOf(user.getScreenName());
			userPassword = user.getPassword();
		}
		
		if(VCRegisterUtil.isVcInfo(thisGroupId, userScreenName) == 200){
			
			if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId))){
			
				icebreakerVcToken.setVcToken(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId))));				
				icebreakerVcToken.setVcTokenExpired(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId)), "0"));
	
				if(Integer.parseInt(icebreakerVcToken.getVcTokenExpired()) <= Integer.parseInt(CustomUtil.dateToStringFormat(new Date(), "yyyyMMdd"))){
					//시간이 지난 토큰인 경우 새로운 토큰 발행 및 커스텀 필드 저장				
					icebreakerVcToken = TokenProviderUtil.getVcToken(thisGroupId, userScreenName, userPassword);
		
					//Icebreaker에 회원정보는 있으나 로그인 되지 않는 경우 비밀번호 변경으로 인한것으로 판단하여 비밀번호 update후에 다시 로그인하여 토큰을 요청 합니다. 
					if(icebreakerVcToken.getResultCode() != 200){
						int updateResult = VCRegisterUtil.VCUpdate(thisGroupId, userScreenName, userPassword, user.getEmailAddress());
						if(updateResult==200){
							icebreakerVcToken = TokenProviderUtil.getVcToken(thisGroupId, userScreenName, userPassword);
						}
					}
					
					if(icebreakerVcToken.getResultCode() == 200){
						icebreakerVcToken.setVcToken(icebreakerVcToken.getVcToken());					
						icebreakerVcToken.setVcTokenExpired(icebreakerVcToken.getVcTokenExpired());
						
						user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId), icebreakerVcToken.getVcToken());
						user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId), icebreakerVcToken.getVcTokenExpired());
					}else{
						System.out.println("SimulationLocalServiceImpl : Icebreaker getOrCreateToken Error !!");
					}
				}
			}else{
				//icebreaker 계정은 있으나 포털에 expando가 없는 경우 expando 추가 생성
				icebreakerVcToken = creaateExpandoUserVctoken(user, thisGroupId, userScreenName, userPassword);
			}
		}else{
			int resultRegist = VCRegisterUtil.VCRegist(thisGroupId, userScreenName, userPassword, user.getEmailAddress(), user.getFirstName(), universityField, virtualLabId, classId, majorField);
			if (resultRegist == 201) {
				//icebreaker 가입이 성공한 경우 신규 토큰 발행 및 커스텀 필드 추가
				icebreakerVcToken = creaateExpandoUserVctoken(user, thisGroupId, userScreenName, userPassword);
			}
		}
	
		return icebreakerVcToken;
	}	
	

	private static IcebreakerVcToken creaateExpandoUserVctoken(User user, long thisGroupId, String userScreenName, String userPassword) throws SystemException, MalformedURLException, PortalException, IOException, ParseException {

		IcebreakerVcToken icebreakerVcToken = new IcebreakerVcToken();
		
		//icebreaker 가입이 성공한 경우 신규 토큰 발행 및 커스텀 필드 추가
		icebreakerVcToken = TokenProviderUtil.getVcToken(thisGroupId, userScreenName, userPassword);										
		icebreakerVcToken.setVcToken(icebreakerVcToken.getVcToken());					
		icebreakerVcToken.setVcTokenExpired(icebreakerVcToken.getVcTokenExpired());
		
		if(!user.getExpandoBridge().hasAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId))){		

			user.getExpandoBridge().addAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId), false);
			user.getExpandoBridge().addAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId), false);
			
			ExpandoColumn toKenColumn = ExpandoColumnLocalServiceUtil.getColumn(
																			user.getExpandoBridge().getCompanyId(), 
																			user.getExpandoBridge().getClassName(), 
																			ExpandoTableConstants.DEFAULT_TABLE_NAME, 
																			EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId)
																			);
			setExpandoPermissions(user.getExpandoBridge().getCompanyId(), toKenColumn); 
		
			ExpandoColumn expiredColumn = ExpandoColumnLocalServiceUtil.getColumn(
																			user.getExpandoBridge().getCompanyId(), 
																			user.getExpandoBridge().getClassName(), 
																			ExpandoTableConstants.DEFAULT_TABLE_NAME, 
																			EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId)
																			);
			setExpandoPermissions(user.getExpandoBridge().getCompanyId(), expiredColumn);
		}
		
		user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(thisGroupId), icebreakerVcToken.getVcToken());
		user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(thisGroupId), icebreakerVcToken.getVcTokenExpired());
		return icebreakerVcToken;
	}
	
	private static void setExpandoPermissions(long companyId, ExpandoColumn column) throws SystemException {
        
		try {
	 
			Role userRole = RoleLocalServiceUtil.getRole(companyId, RoleConstants.USER);
			Role adminRole = RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR);
	 
	          
			if (userRole != null && adminRole != null) {
				// define actions 
				String[] actionIds = new String[] { ActionKeys.VIEW, ActionKeys.UPDATE };
				
				Map<Long, String[]> map = new HashMap();
				map.put(userRole.getRoleId(), actionIds);
				map.put(adminRole.getRoleId(), actionIds);
	                
				// set the permission
				ResourcePermissionLocalServiceUtil.setResourcePermissions(
	                															companyId, 
	                															ExpandoColumn.class.getName(), 
	                															ResourceConstants.SCOPE_INDIVIDUAL, 
	                															String.valueOf(column.getColumnId()), 
	                															map
	                															);
	                	                
	            }
	      } catch (PortalException pe) {
	      }
	}
	
	
	/**
	 * 시뮬레이션 생성
	 * @throws JSONException 
	 * @Token : Token
	 * @title : title
	 * @description : description
	 * 
	 * @return String uuid
	 */
	public Map createSimulation(String icebreakerUrl, String icebreakerZone, String vcToken, String scienceAppId, String title, String description) throws MalformedURLException, IOException{		

		Map resultMap = new HashMap();			
		

		URL url = new URL(icebreakerUrl+"/api/simulation/create?zone="+icebreakerZone);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

		//GET Token
		conn.setRequestProperty("Authorization", "Basic "+vcToken);
		
		StringBuffer bodyStr = new StringBuffer();
		
		bodyStr.append("{");
		bodyStr.append("	\"solverId\" : \""+scienceAppId+"\", ");
		bodyStr.append("	\"title\" : \""+title+"\", ");
		bodyStr.append("	\"description\" : \""+description+"\" ");
		bodyStr.append("}");
		
		OutputStream os = conn.getOutputStream();
		os.write(bodyStr.toString().getBytes());
		os.flush();

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String  output = "";		
		StringBuffer responseBuffer = new StringBuffer();			
	
		if (conn.getResponseCode() == 201) {
			while ((output = br.readLine()) != null) {
				if(!CustomUtil.strNull(output).equals("null")){
					responseBuffer.append(CustomUtil.strNull(output));						
					JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(responseBuffer.toString()));
					resultMap.put("uuid", CustomUtil.strNull(json.getString("uuid")));
					resultMap.put("cluster", CustomUtil.strNull(json.getString("cluster")));						
				}
			}				
		}else if (conn.getResponseCode() == 400) {
			System.out.println("Failed IcebreakerService [ createSimulation ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());
		}else{			
			System.out.println("Failed IcebreakerService [ createSimulation ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
		}
		
		conn.disconnect();		
		
		return resultMap;
	}
	
	
	/**
	 * 시뮬레이션 수행
	 * @simulationUuid
	 * @fileId
	 * @Token
	 * @title
	 * @description
	 * @scienceApp_name
	 * @return
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 */
	public Map executeJob(String icebreakerUrl, Map params) throws MalformedURLException, IOException, ParserConfigurationException, SAXException {		
		
		Map resultMap = null;		
		
		if(!CustomUtil.strNull(params.get("Token")).equals("")){
			
			String URL = icebreakerUrl+"/api/simulation/"+CustomUtil.strNull(params.get("simulationUuid"))+"/job/submit";
			String syncCallBackURL = CustomUtil.strNull(params.get("syncCallBackURL"));
			URL += "?url="+syncCallBackURL;
			
			log.debug("executeJob URL-->"+URL);
			URL url = new URL(URL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(300000);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/xml");
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(params.get("Token")));
			
			StringBuffer bodyStr = new StringBuffer();
			String executionStr = CustomUtil.strNull(params.get("executionStr"));
			String executionType = StringUtil.upperCase(CustomUtil.strNull(params.get("executionType"),"SEQUENTIAL"));
			
			bodyStr.append("<job>");
			bodyStr.append("	<type>"+executionType+"</type>");
			bodyStr.append("	<category>"+StringUtil.upperCase(CustomUtil.strNull(params.get("code_mpi_module"),""))+"</category>");			
			bodyStr.append("	<title>"+CustomUtil.strNull(params.get("title"))+"</title>");
			bodyStr.append("	<description>"+CustomUtil.strNull(params.get("description"))+"</description>");
			if(!CustomUtil.strNull(params.get("scienceAppId")).equals("")){
				bodyStr.append("	<solverId>"+CustomUtil.strNull(params.get("scienceAppId"))+"</solverId>");
			}
			if(!CustomUtil.strNull(params.get("scienceAppName")).equals("")){
				bodyStr.append("	<solverName>"+CustomUtil.strNull(params.get("scienceAppName"))+"</solverName>");
			}
			bodyStr.append("	<cyberLabId>"+CustomUtil.strNull(params.get("cyberLabId")," ")+"</cyberLabId>");
			bodyStr.append("	<classId>"+CustomUtil.strNull(params.get("classId")," ")+"</classId>");										
			bodyStr.append("	<executable>"+CustomUtil.strNull(params.get("exec_path"))+"</executable>");
			
			bodyStr.append(CustomUtil.strNull(params.get("execution_mpi_attributes")));								
			bodyStr.append(CustomUtil.strNull(params.get("code_library")));								
			bodyStr.append(CustomUtil.strNull(params.get("filesItem")));
			bodyStr.append("	<cluster>"+CustomUtil.strNull(params.get("cluster"))+"</cluster>");
			bodyStr.append("	<execution>"+executionStr+"</execution>");
			bodyStr.append("</job>");

			log.debug("##### SUBMIT #################################");
			log.debug(bodyStr.toString());
			log.debug("##### SUBMIT #################################");
			
			OutputStream os = conn.getOutputStream();
			os.write(bodyStr.toString().getBytes());
			os.flush();
			
			
			String  output = "";

			if (conn.getResponseCode() == 201) {
				
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				
				while ((output = br.readLine()) != null) {
					if(!CustomUtil.strNull(output).equals("null")){

					    DocumentBuilderFactory factory  =  DocumentBuilderFactory.newInstance();
					    DocumentBuilder builder    =  factory.newDocumentBuilder();	    
					    Document document     =  builder.parse(new InputSource(new StringReader(CustomUtil.strNull(output))));

					    String uuid = document.getElementsByTagName("uuid").item(0).getChildNodes().item(0).getNodeValue();
					    
					    String status = document.getElementsByTagName("status").item(0).getChildNodes().item(0).getNodeValue();
					    status = CustomUtil.getStatusConvertIceToPortal(status);  
					    
					    String submittedTime = document.getElementsByTagName("submittedTime").item(0).getChildNodes().item(0).getNodeValue();
						
					    submittedTime = submittedTime.substring(0, 19);  //2012-07-12T20:50:37					    
						submittedTime = submittedTime.replace("T", " "); //2012-07-12 20:50:37
						resultMap = new HashMap();		
						resultMap.put("uuid", uuid);
						resultMap.put("status", status);
						resultMap.put("submittedTime", submittedTime);

					}
				}				
			}else if (conn.getResponseCode() == 400) {
				System.out.println("Failed IcebreakerService [ executeJob ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());
			}else{			
				System.out.println("Failed IcebreakerService [ executeJob ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			conn.disconnect();		
		}else{
			System.out.println("Failed IcebreakerService [ executeJob ] : Token is NOT NULL - Request error code : 999");
		}

		return resultMap;
	}

	/**
	 * 시뮬레이션 수행
	 * @simulationUuid
	 * @job_uuid
	 * @Token
	 * @return status
	 */
	public Map statusJob(String icebreakerUrl, String vcToken, String simulationUuid, String job_uuid) throws MalformedURLException, IOException {		
		
		Map statusMap = new HashMap();		
		
		if(!CustomUtil.strNull(vcToken).equals("")){
			
			URL url = new URL(icebreakerUrl+"/api/simulation/"+simulationUuid+"/job/"+job_uuid+"/status");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

			//GET Token
			conn.setRequestProperty("Authorization", "Basic "+vcToken);
								
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			String  output = "";
			StringBuffer responseBuffer = new StringBuffer();

			String startTime = "";
			String endTime = "";
			Date dt = null;

			if (conn.getResponseCode() == 200) {
				while ((output = br.readLine()) != null) {
					if(!CustomUtil.strNull(output).equals("null")){
						responseBuffer.append(CustomUtil.strNull(output));	
												
						JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(responseBuffer.toString()));
						statusMap.put("status", json.getString("status"));						
						
						if(json.containsKey("startTime")){
							statusMap.put("startTime", "");
						}else{
							startTime = CustomUtil.strNull(json.getString("startTime"));
							startTime = startTime.substring(0, 19);  //2012-07-12T20:50:37
							statusMap.put("startTime", CustomUtil.replace(startTime, "T", " "));
						}
						
						if(json.containsKey("endTime")){
							statusMap.put("endTime", "");
						}else{
							endTime = CustomUtil.strNull(json.getString("endTime"));
							endTime = endTime.substring(0, 19);  //2012-07-12T20:50:37
							statusMap.put("endTime", CustomUtil.replace(endTime, "T", " "));
						}
						
					}
				}				
			}else if (conn.getResponseCode() == 400) {
				System.out.println("Failed IcebreakerService [ statusJob ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 401) {
				System.out.println("Failed IcebreakerService [ statusJob ] : UNAUTHORIZED : access denied - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 404) {
				System.out.println("Failed IcebreakerService [ statusJob ] : NOT FOUND : no existing job - HTTP error code : " + conn.getResponseCode());
			}else{			
				System.out.println("Failed IcebreakerService [ statusJob ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			conn.disconnect();		
		}else{
			System.out.println("Failed IcebreakerService [ statusJob ] : Token is NOT NULL - Request error code : 999");
		}
		
		return statusMap;
	}


	/**
	 * 시뮬레이션 수정
	 * @throws JSONException 
	 * @Token : 인증 토큰
	 * @uuid : 시뮬레이션 아이디
	 * 
	 * @return int resultCode
	 */
	public int updateSimulation(String icebreakerUrl, String simulationUuid, String vcToken, String title, String description) throws MalformedURLException, IOException {		

		int resultCode = 0;
		
				
		if(!CustomUtil.strNull(simulationUuid).equals("")){

			URL url = new URL(icebreakerUrl+"/api/simulation/"+simulationUuid);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

			//GET Token
			conn.setRequestProperty("Authorization", "Basic "+vcToken);
			
			StringBuffer bodyStr = new StringBuffer();
			
			bodyStr.append("{");
			bodyStr.append("	\"title\" : \""+title+"\", ");
			bodyStr.append("	\"description\" : \""+description+"\" ");
			bodyStr.append("}");

			OutputStream os = conn.getOutputStream();
			os.write(bodyStr.toString().getBytes());
			os.flush();
			
			resultCode = conn.getResponseCode();
			
			if (resultCode == 200) {
				System.out.println("SUCCESS IcebreakerService [ updateSimulation ] : SUCCESS - " + simulationUuid);
			}else if (resultCode == 401) {
				System.out.println("Failed IcebreakerService [ updateSimulation ] : UNAUTHORIZED : access denied - HTTP error code : " + conn.getResponseCode());
			}else if (resultCode == 404) {
				System.out.println("Failed IcebreakerService [ updateSimulation ] : NOT FOUND : not existing simulation - HTTP error code : " + conn.getResponseCode());
			}else if (resultCode == 400) {
				System.out.println("Failed IcebreakerService [ updateSimulation ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());				
			}else{			
				System.out.println("Failed IcebreakerService [ updateSimulation ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			conn.disconnect();		
		}else{
			resultCode = 999;
			System.out.println("Failed IcebreakerService [ updateSimulation ] : simulationUuid is NOT NULL - Request error code : 999");
		}
		
		return resultCode;
	}	
	
	/**
	 * 파일 업로드
	 * @param params
	 *        String	Token
	 *        File		file
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	public Map uploadFile(String cluster, String icebreakerUrl, String vcToken, File file) throws MalformedURLException, IOException, InterruptedException {
		 
		URL url = new URL(icebreakerUrl+"/api/file/upload?cluster="+cluster);
		HttpFileUtil httpFileUtil = new HttpFileUtil(url);
		
		httpFileUtil.Token = CustomUtil.strNull(vcToken);
		httpFileUtil.addFile("file", file);
		
		String resultJson = httpFileUtil.sendMultipartPost();

		Map returnMap = new HashMap();
		
		if(!CustomUtil.strNull(resultJson).equals("")){
			JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(resultJson));
			String fileId = json.getString("id");
			String filePath = json.getString("path");
			String fileSize = json.getString("size");
			
			returnMap.put("fileId", fileId);
			returnMap.put("filePath", filePath);
			returnMap.put("fileSize", fileSize);
		}
		
		return returnMap;
	}
	
	/**
	 * 파일 삭제
	 * @param icebreakerUrl
	 * @param vcToken
	 * @param fileId
	 * @throws IOException
	 */
	public void deleteFile(String icebreakerUrl, String vcToken, String fileId) throws IOException{
		URL url = new URL(icebreakerUrl+"/api/file/"+fileId);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setDoOutput(true);
		conn.setRequestMethod("DELETE");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");		
		conn.setRequestProperty("Authorization", "Basic "+vcToken);
		
		if (!conn.getResponseMessage().equals("OK")) {
			if(conn.getResponseCode()==404){
				log.error("Failed IcebreakerService [ deleteFile ] : NOT FOUND FILE");
			}else{
				throw new RuntimeException("Failed IcebreakerService [ deleteFile ] : HTTP error code : " + conn.getResponseCode());
			}
		}
	}
 	
	/**
	 * serverFile 목록
	 */
	public String getServerFileList(String icebreakerUrl, String cmd_directory, String cluster, String vcToken) throws MalformedURLException, IOException  {	
		URL url = new URL(icebreakerUrl+"/api/common/files/"+cmd_directory+"?cluster="+cluster);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");		
		conn.setRequestProperty("Authorization", "Basic "+vcToken);

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed IcebreakerService [ getServerFileList ] : HTTP error code : " + conn.getResponseCode());
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		
		String  output = "";		
		StringBuffer responseBuffer = new StringBuffer();
		
		while ((output = br.readLine()) != null) {			
			responseBuffer.append(output);
		}
		conn.disconnect();
		
		return responseBuffer.toString();
	}
		
	

	/**
	 * job별 결과 파일 zip형태로 다운로드
	 * @simulationUuid
	 * @job_uuid
	 * @Token
	 * @return status
	 */
	public InputStream downloadFileJob(String icebreakerUrl, String vcToken, String job_uuid) throws MalformedURLException, IOException {		
		 		
		InputStream returnIs = null;
		
		if(!CustomUtil.strNull(vcToken).equals("")){
			
			URL url = new URL(icebreakerUrl+"/api/job/"+CustomUtil.strNull(job_uuid)+"/download/zip");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("GET");
			
			//GET Token
			conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
			if (conn.getResponseCode() == 200) {
				returnIs = conn.getInputStream();
			}else if (conn.getResponseCode() == 400) {
				System.out.println("Failed IcebreakerService [ downloadFileJob ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 401) {
				System.out.println("Failed IcebreakerService [ downloadFileJob ] : UNAUTHORIZED : access denied - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 404) {
				System.out.println("Failed IcebreakerService [ downloadFileJob ] : NOT FOUND : no existing job - HTTP error code : " + conn.getResponseCode());
			}else{			
				System.out.println("Failed IcebreakerService [ downloadFileJob ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			conn.disconnect();		
		}else{
			System.out.println("Failed IcebreakerService [ downloadFileJob ] : Token is NOT NULL - Request error code : 999");
		}
		
		return returnIs;
	}
	
	/**
	 * job error 보기
	 * @param params
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public String errorView(String icebreakerUrl, String vcToken, String job_uuid) throws IOException{
		String resultText = "";
		if(!CustomUtil.strNull(vcToken).equals("")){
			URL url = new URL(icebreakerUrl+"/api/job/"+CustomUtil.strNull(job_uuid)+"/log/error");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "text/plain");
			conn.setRequestProperty("Content-Type", "application/xml");
			
			//GET Token
			conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
			
			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String  output = "";		
				StringBuffer responseBuffer = new StringBuffer();
				while ((output = br.readLine()) != null) {
					if(!CustomUtil.strNull(output).equals("null")){
						responseBuffer.append(CustomUtil.strNull(output)+"<br/>");	
					}
				}	
				resultText = responseBuffer.toString();
			}else if (conn.getResponseCode() == 400) {
				System.out.println("Failed IcebreakerService [ errorView ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 401) {
				System.out.println("Failed IcebreakerService [ errorView ] : UNAUTHORIZED : access denied - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 404) {
				System.out.println("Failed IcebreakerService [ errorView ] : NOT FOUND : no existing job - HTTP error code : " + conn.getResponseCode());
			}else{			
				System.out.println("Failed IcebreakerService [ errorView ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			conn.disconnect();		
		}else{
			System.out.println("Failed IcebreakerService [ errorView ] : Token is NOT NULL - Request error code : 999");
		}
		
		return resultText;
	}
	
	
	/**
	 * 파일 ID 확인
	 * @throws IOException 
	 */
	public String retrieveFileId(String icebreakerUrl, String vcToken, String job_uuid, String fileName) throws IOException{
		StringBuffer responseBuffer = new StringBuffer();
		
		if(!CustomUtil.strNull(vcToken).equals("")){
			URL url = new URL(icebreakerUrl+"/api/job/"+CustomUtil.strNull(job_uuid)+"/file?name="+CustomUtil.strNull(fileName));
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");		
			conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
			
			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				
				String  output = "";		
				while ((output = br.readLine()) != null) {			
					responseBuffer.append(output);
				}
				
			}else if (conn.getResponseCode() == 400) {
				System.out.println("Failed IcebreakerService [ retrieveFileId ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 401) {
				System.out.println("Failed IcebreakerService [ retrieveFileId ] : UNAUTHORIZED : access denied - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 404) {
				System.out.println("Failed IcebreakerService [ retrieveFileId ] : NOT FOUND : no existing job - HTTP error code : " + conn.getResponseCode());
			}else{			
				System.out.println("Failed IcebreakerService [ retrieveFileId ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			conn.disconnect();
		}else{
			System.out.println("Failed IcebreakerService [ retrieveFileId ] : Token is NOT NULL - Request error code : 999");
		}
		
		return responseBuffer.toString();
	}
	
	
	/**
	 * 디렉토리 파일 조회
	 * 일반적인 후처리기 목록은 dir = result 
	 * @throws IOException 
	 */
	public String retrievePostProcessor(String icebreakerUrl, String vcToken, String jobUuid) throws IOException{
		return retrieveDir(icebreakerUrl,vcToken,jobUuid,"result");
	}
	
	public String retrieveRemoteDir(String icebreakerUrl, String vcToken, String jobUuid,String dirPath) throws IOException{
		return retrieveDir(icebreakerUrl,vcToken,jobUuid,dirPath);
	}
	
	private String retrieveDir(String icebreakerUrl, String vcToken, String job_uuid,String dirPath) throws IOException{
		StringBuffer responseBuffer = new StringBuffer();
		
		if(!CustomUtil.strNull(vcToken).equals("")){
			if(dirPath.equals("")){
				dirPath = "result";
			}
			
			URL url = new URL(icebreakerUrl+"/api/job/"+CustomUtil.strNull(job_uuid)+"/output?dir="+dirPath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/xml");		
			conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
			
			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				
				String  output = "";		
				while ((output = br.readLine()) != null) {			
					responseBuffer.append(output);
				}
				
			}else if (conn.getResponseCode() == 400) {
				System.out.println("Failed IcebreakerService [ retrieveDir ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 401) {
				System.out.println("Failed IcebreakerService [ retrieveDir ] : UNAUTHORIZED : access denied - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 404) {
				System.out.println("Failed IcebreakerService [ retrieveDir ] : NOT FOUND : no existing job - HTTP error code : " + conn.getResponseCode());
			}else{			
				System.out.println("Failed IcebreakerService [ retrieveDir ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			conn.disconnect();
		}else{
			System.out.println("Failed IcebreakerService [ retrieveDir ] : Token is NOT NULL - Request error code : 999");
		}
		
		return responseBuffer.toString();
	}
	
	/**
	 * simulation job 중지
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public int cancleJob(String icebreakerUrl, String vcToken, String simulationUuid, String job_uuid) throws IOException {
		int resultStatus = 0;
		if(!CustomUtil.strNull(vcToken).equals("")){
			URL url = new URL(icebreakerUrl+"/api/simulation/"+CustomUtil.strNull(simulationUuid)+"/job/"+CustomUtil.strNull(job_uuid)+"/cancel");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");		
			conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
			resultStatus = conn.getResponseCode();
			
			if (conn.getResponseCode() == 401) {
				System.out.println("Failed IcebreakerService [ cancleJob ] : UNAUTHORIZED : access denied - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 404) {
				System.out.println("Failed IcebreakerService [ cancleJob ] : NOT FOUND : no existing job - HTTP error code : " + conn.getResponseCode());
			}else if (conn.getResponseCode() == 405) {
				System.out.println("Failed IcebreakerService [ cancleJob ] : NOT FOUND : no existing job - HTTP error code : " + conn.getResponseCode());
			}
		}else{
			System.out.println("Failed IcebreakerService [ cancleJob ] : Token is NOT NULL - Request error code : 999");
		}
		return resultStatus;
	}
	
	/**
	 * Cluster List 조회
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws JSONException 
	 */
	/*
	public JSONObject retrieveCluster(String icebreakerUrl, String vcToken) throws IOException{
		StringBuffer responseBuffer = new StringBuffer();
		JSONObject json = null;
		//if(!CustomUtil.strNull(params.get("Token")).equals("")){
			URL url = new URL(icebreakerUrl+"/api/cluster/list");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");		
			conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
			
			if (conn.getResponseCode() == 400) {
				System.out.println("Failed IcebreakerService [ retrieveCluster ] : BAD REQUEST: bad parameters : " + conn.getResponseCode());
			}else if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String  output = "";		
				while ((output = br.readLine()) != null) {			
					responseBuffer.append(output);
				}
				
				json = JSONObject.fromObject(JSONSerializer.toJSON(responseBuffer.toString()));
			}
			conn.disconnect();
			
		//}else{
			//System.out.println("Failed IcebreakerService [ retrieveCluster ] : Token is NOT NULL - Request error code : 999");
		//}
		return json;
	}
	
	*/
	/**
	 * job error 보기
	 * @param params
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public String getResultRead(String icebreakerUrl, String vcToken, String fileId) throws IOException{
		String resultText = "";
		if(!CustomUtil.strNull(vcToken).equals("")){
			URL url = new URL(icebreakerUrl+"/api/file/download?id="+CustomUtil.strNull(fileId));
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "text/plain");
			conn.setRequestProperty("Content-Type", "application/xml");
			
			//GET Token
			conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
			
			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String  output = "";		
				StringBuffer responseBuffer = new StringBuffer();
				while ((output = br.readLine()) != null) {
					if(!CustomUtil.strNull(output).equals("null")){
						responseBuffer.append(CustomUtil.strNull(output)+"\n");	
					}
				}	
				resultText = responseBuffer.toString();
			}else if (conn.getResponseCode() == 400) {
				System.out.println("Failed IcebreakerService [ getResultRead ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 413) {
				System.out.println("Failed IcebreakerService [ getResultRead ] : REQUEST ENTITY TO LARGE : 10MBytes Limit - HTTP error code : " + conn.getResponseCode());		
			}else{			
				System.out.println("Failed IcebreakerService [ getResultRead ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			conn.disconnect();		
		}else{
			System.out.println("Failed IcebreakerService [ getResultRead ] : Token is NOT NULL - Request error code : 999");
		}
		
		return resultText;
	}
	
	
	/**
	 * file 조회
	 * @param params
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public InputStream getFileRead(String icebreakerUrl, String vcToken, String fileId) throws IOException{
		if(!CustomUtil.strNull(vcToken).equals("")){
			URL url = new URL(icebreakerUrl+"/api/file/download?id="+CustomUtil.strNull(fileId));
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "text/plain");
			conn.setRequestProperty("Content-Type", "application/xml");
			
			//GET Token
			conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
			
			if (conn.getResponseCode() == 200) {
				return conn.getInputStream();
			}else if (conn.getResponseCode() == 400) {
				System.out.println("Failed IcebreakerService [ getFileRead ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 413) {
				System.out.println("Failed IcebreakerService [ getFileRead ] : REQUEST ENTITY TO LARGE : 10MBytes Limit - HTTP error code : " + conn.getResponseCode());		
			}else{			
				System.out.println("Failed IcebreakerService [ getFileRead ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			conn.disconnect();		
		}else{
			System.out.println("Failed IcebreakerService [ getFileRead ] : Token is NOT NULL - Request error code : 999");
		}
		
		return null;
	}	
	
	/**
	 * webgl을 위한 파일 생성 후 url 리턴(임시 사용-추후 수정 예정)
	 * @param params
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public String getResultFile(String icebreakerUrl, String vcToken, String simulationUuid, String fileName) throws IOException
	{
		String filePath = System.getProperty("catalina.home")+"/webapps/data/webgl_temp/"+simulationUuid;
		
		//uuid로 폴더 생성
		File resultFolder = new File(filePath);
		if( !resultFolder.exists() )
		{
			resultFolder.mkdirs();
		}
		
		//result.zip을 만들 폴더 생성
		resultFolder = new File(filePath+"/result");
		if( !resultFolder.exists() )
		{
			resultFolder.mkdirs();
		}
		
		File resultFile = new File(filePath+ File.separator+fileName);
		
		if(!resultFile.exists())
		{
			// 임시 : Result.zip File ID
			String resultFileStr = retrieveDir(icebreakerUrl, vcToken, simulationUuid, "/");
			String zipFileId="";
			if (!CustomUtil.strNull(resultFileStr).equals("")) {
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(resultFileStr));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				
				root1:for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject comandObj = (JSONObject) jsonArray.get(i);
					if( comandObj.getString("name").equals("result.zip")){
						zipFileId = comandObj.getString("id");
						break root1;
					}
				}
			}
			
			File tempZipFile = null;
			
			if(!CustomUtil.strNull(vcToken).equals("")){
				URL url = new URL(icebreakerUrl+"/api/file/download?id="+CustomUtil.strNull(zipFileId));
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				conn.setDoOutput(true);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "text/plain");
				conn.setRequestProperty("Content-Type", "application/xml");
				
				//GET Token
				conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
				
				//파일 생성 체크, 없을 시에 IB로부터 받아와 임시로 생성
				tempZipFile = new File(filePath+File.separator+fileName);
				if(!tempZipFile.exists())
				{
					if (conn.getResponseCode() == 200) 
					{
						InputStream inputStream = conn.getInputStream();
						FileOutputStream outputStream = new FileOutputStream( filePath+"/"+fileName );
	
					    int BUFFER_SIZE = 4096;
					    int bytesRead = -1;
					    byte[] buffer = new byte[BUFFER_SIZE];
					    while ((bytesRead = inputStream.read(buffer)) != -1) {
					    	outputStream.write(buffer, 0, bytesRead);
					    }
					    inputStream.close();
					}else if (conn.getResponseCode() == 400) {
						System.out.println("Failed IcebreakerService [ getFilePath ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());		
					}else if (conn.getResponseCode() == 413) {
						System.out.println("Failed IcebreakerService [ getFilePath ] : REQUEST ENTITY TO LARGE : 10MBytes Limit - HTTP error code : " + conn.getResponseCode());		
					}else{			
						System.out.println("Failed IcebreakerService [ getFilePath ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
					}
				}
				
				conn.disconnect();		
				
				if(tempZipFile.exists())
				{
					// Extract result.zip
					ZipInputStream zis = new ZipInputStream(new FileInputStream(tempZipFile));
					ZipEntry ze = zis.getNextEntry();
					byte[] buffer = new byte[1024];
					
					while(ze!=null)
					{
				            String entryfileName = ze.getName();
				            
				            File newFile = null;
				            
				            if (ze.isDirectory()) {
				            	newFile = new File(filePath+File.separator + entryfileName);
				                newFile.mkdirs();
				            } 
				            else 
				            {
				            	FileOutputStream fos = null;
				            	
				            	// ze가 디렉터리 임에도 ze.isDirectory()가 오동작, 따라서 result 폴더를 만들어준다.
				            	newFile = new File(filePath+File.separator + entryfileName);
				            	fos = new FileOutputStream(newFile);
/*
				            	try
				            	{
				            	}
				            	catch( FileNotFoundException e)
				            	{
				            		
				            		newFile = new File(filePath+File.separator + "result");
					                newFile.mkdirs();
					                newFile = new File(filePath+File.separator + entryfileName);
					                fos = new FileOutputStream(newFile);
				            	}
*/			
				                int len;
				                while ((len = zis.read(buffer)) > 0) 
				                {
				                    fos.write(buffer, 0, len);
				                }
				                fos.close();
				            }
				            ze = zis.getNextEntry();
				            newFile.deleteOnExit();
					}
				    	
					tempZipFile.deleteOnExit();
			        zis.closeEntry();
			    	zis.close();
			    		
			    	System.out.println("["+simulationUuid+"]UNZIP Done");
				}else{
					System.out.println("Failed IcebreakerService [ getFilePath ] : Token is NOT NULL - Request error code : 999");
				}
			}
		}
		return simulationUuid+ "/result/";
	}
	
	/**
	 * Get Current Assignd Core Count
	 * @param params
	 * @throws IOException 
	 */
	public String getCurrentAssignedCoresByUser(String icebreakerUrl, String vcToken) throws IOException{
		
		String jsonResult="";
		if(!CustomUtil.strNull(vcToken).equals("")){
			URL url = new URL(icebreakerUrl+"/api/user/core/usage");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			
			//GET Token
			conn.setRequestProperty("Authorization", "Basic "+vcToken);
			
			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String  output = "";		
				StringBuffer responseBuffer = new StringBuffer();
				while ((output = br.readLine()) != null) {
					if(!CustomUtil.strNull(output).equals("null")){
						responseBuffer.append(CustomUtil.strNull(output)+"\n");	
					}
				}	
				jsonResult = responseBuffer.toString();
			}else if (conn.getResponseCode() == 400) {
				System.out.println("Failed IcebreakerService [ getCurrentAssignedCoresByUser ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());		
			}else if (conn.getResponseCode() == 413) {
				System.out.println("Failed IcebreakerService [ getCurrentAssignedCoresByUser ] : REQUEST ENTITY TO LARGE : 10MBytes Limit - HTTP error code : " + conn.getResponseCode());		
			}else{			
				System.out.println("Failed IcebreakerService [ getCurrentAssignedCoresByUser ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			conn.disconnect();		
		}else{
			System.out.println("Failed IcebreakerService [ getCurrentAssignedCoresByUser ] : Token is NOT NULL - Request error code : 999");
		}
		return jsonResult;
	}

	/**
	 * getUserRepositorySize 조회
	 * @param params
	 * @return
	 * @throws IOException
	 * @throws JSONException 
	 */
	public String getUserRepositorySize(String icebreakerUrl, String vcToken) throws IOException{
		String repositorySize = "";
		//if(!CustomUtil.strNull(params.get("Token")).equals("")){
			URL url = new URL(icebreakerUrl+"/api/file/repository");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");		
			conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
			
			if (conn.getResponseCode() == 400) {
				System.out.println("Failed IcebreakerService [ getUserRepositorySize ] : BAD REQUEST: bad parameters : " + conn.getResponseCode());
			}else if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				String  output = "";		
				while ((output = br.readLine()) != null) {	
					repositorySize += output;
				}
			}
			conn.disconnect();
			
		//}else{
			//System.out.println("Failed IcebreakerService [ retrieveCluster ] : Token is NOT NULL - Request error code : 999");
		//}
		return CustomUtil.replace(CustomUtil.replace(repositorySize, "\"", ""), "\n", "").trim();
	}
	
	public int deleteSimulationJob(String icebreakerUrl, String vcToken, String simulationUuid, String jobUuid) throws IOException{
		URL url = new URL(icebreakerUrl+"/api/simulation/"+simulationUuid+"/job/"+jobUuid);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setDoOutput(true);
		conn.setRequestMethod("DELETE");
		conn.setRequestProperty("Accept", "text/plain");
		conn.setRequestProperty("Content-Type", "application/xml");
		
		//GET Token
		conn.setRequestProperty("Authorization", "Basic "+CustomUtil.strNull(vcToken));
		if (conn.getResponseCode() == 400) {
			log.error("Failed IcebreakerService [ deleteSimulationJob ] : BAD REQUEST: bad parameters : " + conn.getResponseCode());
		}else{
			log.error("Failed IcebreakerService [ deleteSimulationJob ] :" + conn.getResponseCode());
		}
		
		conn.disconnect();
		
		return conn.getResponseCode();
	}
	
	/**
	 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	 * ■■■■■■■■■ Icebreaker Service End ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	 * ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■
	 */	
	
}