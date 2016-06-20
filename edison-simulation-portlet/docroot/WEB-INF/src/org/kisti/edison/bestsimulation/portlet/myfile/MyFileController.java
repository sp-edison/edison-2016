package org.kisti.edison.bestsimulation.portlet.myfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.EdisonRoleConstants;
import org.kisti.edison.model.IcebreakerVcToken;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonUserUtil;
import org.kisti.edison.util.HttpFileUtil;
import org.kisti.edison.util.MyFileIcebreakerUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.util.TokenProviderUtil_fileTest;
import org.kisti.edison.util.VCRegisterUtil;
import org.kisti.edison.util.VCRegisterUtil_fileTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
@RequestMapping("VIEW")
public class MyFileController {

	private static Log log = LogFactoryUtil.getLog(MyFileController.class);
	private final String ICEBREAKER_TEMP_PATH = PropsUtil.get(PropsKeys.LIFERAY_HOME)+"/ICEBREAKER_TEMP";
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model){
		try {
		
			Map param = RequestUtil.getParameterMap(request);
			
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			IcebreakerVcToken icebreakerVcToken = new IcebreakerVcToken();
			
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);		
			String userScreenName = "";
			String userPassword = "";
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			
			User user = themeDisplay.getUser();
			String universityField = "";
			String virtualLabId = "";
			String classId = "";
			String majorField = "";
			
//			String universityField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_UNIVERSITY);
//			String virtualLabId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_LAB_ID);
//			String classId = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_CLASS_ID);
//			String majorField = (String)user.getExpandoBridge().getAttribute(EdisonExpando.USER_MAJOR);
//			
//			if(thisGroup.getParentGroupId() == 0){ //포탈
//				String visitSite = themeDisplay.getUser().getExpandoBridge().getAttribute(EdisonExpando.USER_VISIT_SITE).toString();
//				List<Group> groupList = GroupLocalServiceUtil.getGroups(themeDisplay.getCompanyId(), thisGroup.getGroupId(), true);//하위 그룹 리스트
//				
//				for(Group group : groupList){
//					if(visitSite.equals(group.getName())){
//						groupId = group.getGroupId();
//						thisGroup = GroupLocalServiceUtil.getGroup(groupId);
//						break;
//					}
//				}
//			}
			
			
			if(EdisonUserUtil.isRegularRole(user, EdisonRoleConstants.ADMINISTRATOR) || EdisonUserUtil.isSiteRole(user, groupId, EdisonRoleConstants.SITE_ADMINISTRATOR)){
				userScreenName = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_ID);
				userPassword = (String)thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_PWD);
			}else{
				userScreenName = String.valueOf(user.getScreenName());
				userPassword = user.getPassword();
			}
			if(VCRegisterUtil_fileTest.isVcInfo(groupId, userScreenName) == 200){  
				if(user.getExpandoBridge().hasAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(groupId))){
					
					icebreakerVcToken.setVcToken(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(groupId))));				
					icebreakerVcToken.setVcTokenExpired(CustomUtil.strNull(user.getExpandoBridge().getAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(groupId)), "0"));
		
					if(Integer.parseInt(icebreakerVcToken.getVcTokenExpired()) <= Integer.parseInt(CustomUtil.dateToStringFormat(new Date(), "yyyyMMdd"))){
						//시간이 지난 토큰인 경우 새로운 토큰 발행 및 커스텀 필드 저장				
						icebreakerVcToken = TokenProviderUtil_fileTest.getVcToken(groupId, userScreenName, userPassword);
			
						//Icebreaker에 회원정보는 있으나 로그인 되지 않는 경우 비밀번호 변경으로 인한것으로 판단하여 비밀번호 update후에 다시 로그인하여 토큰을 요청 합니다. 
						if(icebreakerVcToken.getResultCode() != 200){
							int updateResult = VCRegisterUtil_fileTest.VCUpdate(groupId, userScreenName, userPassword, user.getEmailAddress());
							if(updateResult==200){
								icebreakerVcToken = TokenProviderUtil_fileTest.getVcToken(groupId, userScreenName, userPassword);
							}
						}
						
						if(icebreakerVcToken.getResultCode() == 200){
							icebreakerVcToken.setVcToken(icebreakerVcToken.getVcToken());					
							icebreakerVcToken.setVcTokenExpired(icebreakerVcToken.getVcTokenExpired());
							
							user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN + String.valueOf(groupId), icebreakerVcToken.getVcToken());
							user.getExpandoBridge().setAttribute(EdisonExpando.USER_VC_TOKEN_EXPIRED + String.valueOf(groupId), icebreakerVcToken.getVcTokenExpired());
						}else{
							log.debug("SimulationLocalServiceImpl : Icebreaker getOrCreateToken Error !!");
						}
					}
				}else{//icebreaker 계정은 있으나 포털에 expando가 없는 경우 expando 추가 생성
					icebreakerVcToken = MyFileIcebreakerUtil.createExpandoUserVctoken(user, groupId, userScreenName, userPassword);
				}
			}else{ // Icebreaker 계정이 없는경우
				//icebreaker 계정도 없는 경우 생성
				int resultRegist = VCRegisterUtil_fileTest.VCRegist(groupId, userScreenName, userPassword, user.getEmailAddress(), user.getFirstName(), universityField, virtualLabId, classId, majorField);
				
				if (resultRegist == 201) {
					//icebreaker 가입이 성공한 경우 신규 토큰 발행 및 커스텀 필드 추가
					icebreakerVcToken = MyFileIcebreakerUtil.createExpandoUserVctoken(user, groupId, userScreenName, userPassword);
				}
			}
			
			String icebreakerUrl = TokenProviderUtil_fileTest.getIcebreakerMajinURL(CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL)));

			if(!"".equals(icebreakerUrl)){
				model.addAttribute("icebreakerUrl", icebreakerUrl);
			}
			model.addAttribute("icebreakerVcToken", icebreakerVcToken);
			model.addAttribute("groupId", groupId);
			
			Map<String, Object> uploadMap = request.getPortletSession().getAttributeMap();
			if(uploadMap  != null){
				model.addAttribute("mode", CustomUtil.strNull(request.getPortletSession().getAttribute("mode")));
				model.addAttribute("uploadDestFolerId", CustomUtil.strNull(request.getPortletSession().getAttribute("uploadDestFolerId")));
				model.addAttribute("destFolerParents", CustomUtil.strNull(request.getPortletSession().getAttribute("destFolerParents")));
				
				request.getPortletSession().removeAttribute("mode");
				request.getPortletSession().removeAttribute("uploadDestFolerId");
				request.getPortletSession().removeAttribute("destFolerParents");
			}
			
			
			
			/*삭제필요*/
			/*String visitSite = Long.toString(PortalUtil.getScopeGroupId(request));
			
			long popupPlid = PortalUtil.getPlidFromPortletId(Long.parseLong(visitSite), "edisonmyfile_WAR_edisonsimulationportlet");
			//Preprocessor File Popup
			PortletURL preprocessorPopupRenderURL = PortletURLFactoryUtil.create(request,"edisonmyfile_WAR_edisonsimulationportlet", popupPlid, PortletRequest.RENDER_PHASE);
			preprocessorPopupRenderURL.setWindowState(LiferayWindowState.POP_UP);
			model.addAttribute("preprocessorPopupRenderURL", preprocessorPopupRenderURL);
			model.addAttribute("preprocessorPortletNamespace", PortalUtil.getPortletNamespace("edisonmyfile_WAR_edisonsimulationportlet"));*/
			//여기까지 삭제
			
			model.addAttribute("returnId", CustomUtil.strNull(param.get("returnId")));
			model.addAttribute("returnFileName", CustomUtil.strNull(param.get("returnFileName")));
			model.addAttribute("cluster", CustomUtil.strNull(param.get("cluster")));
			model.addAttribute("workflowType", CustomUtil.strNull(param.get("workflowType")));
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "myfile/view"; 
	}
	
	
	/**
	 * 최상위 폴더
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	@ResourceMapping(value ="getRepositoryFolder")
	public void getRepositoryFolder(ResourceRequest request, ResourceResponse response){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Map param = RequestUtil.getParameterMap(request);
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
	
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			String icebreakerUrl =TokenProviderUtil_fileTest.getIcebreakerMajinURL(CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL)));
			
			String icebreakerToken = CustomUtil.strNull(param.get("vcToken"));
			String responseValue = "";
			
			if(!"".equals(icebreakerUrl)){
				URL url = new URL(icebreakerUrl+"/api/folder/list");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();

				conn.setDoOutput(true);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Authorization", "Basic " + icebreakerToken);
				
				String  output = "";		
				if (conn.getResponseCode() == 200) {

					BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
					while ((output = br.readLine()) != null) {
						if(!CustomUtil.strNull(output).equals("null")){
							responseValue += output;
						}
					}
				}
				
				conn.disconnect();
			}
			
			List resultList = new ArrayList();
			if (!CustomUtil.strNull(responseValue).equals("")) {
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(responseValue));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				HashMap resultMap = null;

				for (int i = 0; i < jsonArray.size(); i++) {
					resultMap = new HashMap();
					JSONObject comandObj = (JSONObject) jsonArray.get(i);
					
					resultMap.put("fileName",comandObj.getString("name"));
					resultMap.put("path",comandObj.getString("path"));
					resultMap.put("fileId", comandObj.getString("id"));
					
					String folderId = comandObj.getString("id");
					
					if(!folderId.equals("")){
						URL url = new URL(icebreakerUrl+"/api/folder/"+folderId+"/list");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	
						conn.setDoOutput(true);
						conn.setRequestMethod("GET");
						conn.setRequestProperty("Accept", "application/json");
						conn.setRequestProperty("Authorization", "Basic " + icebreakerToken);
	
						String childResponseValue = "";
						String  output = "";		
						
						if (conn.getResponseCode() == 200) {
	
							BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
							while ((output = br.readLine()) != null) {
								if(!CustomUtil.strNull(output).equals("null")){
									childResponseValue += output;
								}
							}
							
							if (!CustomUtil.strNull(childResponseValue).equals("")) {
								JSONObject childJsonObj = JSONObject.fromObject(JSONSerializer.toJSON(childResponseValue));
								
								resultMap.put("childCnt", childJsonObj.get("count"));
							}
						}
						conn.disconnect();
					}

					resultList.add(resultMap);
				}
			}
			
			
			/*JSONObject jsonObj = new JSONObject(resultFileStr);
			org.json.JSONArray jsonArray = jsonObj.getJSONArray("files");*/
			JSONObject json = new JSONObject();
			
			json.put("dataList", resultList);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 선택한 폴더의 하위폴더 목록
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	@ResourceMapping(value ="getChildFolder")
	public void getChildFolder(ResourceRequest request, ResourceResponse response){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Map param = RequestUtil.getParameterMap(request);
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			String icebreakerUrl = TokenProviderUtil_fileTest.getIcebreakerMajinURL(CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL)));
			
			String icebreakerToken = CustomUtil.strNull(param.get("vcToken"));
			String responseValue = "";
			
			int responseCode = 0;
			String selectFolderId = CustomUtil.strNull(param.get("selectFolderId"));
			if(!"".equals(icebreakerUrl)){
				URL url = new URL(icebreakerUrl+"/api/folder/"+selectFolderId+"/list");

				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				conn.setDoOutput(true);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Authorization", "Basic " + icebreakerToken);
				
				responseCode = conn.getResponseCode();
				String  output = "";		
				if (responseCode == 200) {
					
					BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
					while ((output = br.readLine()) != null) {
						if(!CustomUtil.strNull(output).equals("null")){
							responseValue += output;
						}
					}
				}
				conn.disconnect();
			}
			
			List resultList = new ArrayList();
			if (!CustomUtil.strNull(responseValue).equals("")) {
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(responseValue));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				HashMap resultMap = null;
				
				for (int i = 0; i < jsonArray.size(); i++) {
					resultMap = new HashMap();
					JSONObject comandObj = (JSONObject) jsonArray.get(i);
					
					resultMap.put("parentFolderId", selectFolderId);
					resultMap.put("fileName",comandObj.getString("name"));
					resultMap.put("path",comandObj.getString("path"));
					resultMap.put("fileId", comandObj.getString("id"));
					
					String folderId = comandObj.getString("id");
					
					if(!folderId.equals("")){
						URL url = new URL(icebreakerUrl+"/api/folder/"+folderId+"/list");
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	
						conn.setDoOutput(true);
						conn.setRequestMethod("GET");
						conn.setRequestProperty("Accept", "application/json");
						conn.setRequestProperty("Authorization", "Basic " + icebreakerToken);
	
						String childResponseValue = "";
						String  output = "";		
						if (conn.getResponseCode() == 200) {
	
							BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
							while ((output = br.readLine()) != null) {
								if(!CustomUtil.strNull(output).equals("null")){
									childResponseValue += output;
								}
							}
							
							if (!CustomUtil.strNull(childResponseValue).equals("")) {
								JSONObject childJsonObj = JSONObject.fromObject(JSONSerializer.toJSON(childResponseValue));
								
								resultMap.put("childCnt", childJsonObj.get("count"));
							}
						}
						conn.disconnect();
					}
					resultList.add(resultMap);
				}
			}
			
			/*JSONObject jsonObj = new JSONObject(resultFileStr);
			org.json.JSONArray jsonArray = jsonObj.getJSONArray("files");*/
			JSONObject json = new JSONObject();
			json.put("responseCode", responseCode);
			json.put("dataList", resultList);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 선택한 폴더의 하위파일목록
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	@ResourceMapping(value ="getChildFile")
	public void getChildFile(ResourceRequest request, ResourceResponse response){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Map param = RequestUtil.getParameterMap(request);
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			String icebreakerUrl = TokenProviderUtil_fileTest.getIcebreakerMajinURL(CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL)));
			
			String icebreakerToken = CustomUtil.strNull(param.get("vcToken"));
			String responseValue = "";
			
			String selectFolderId = CustomUtil.strNull(param.get("selectFolderId"));
			if(!"".equals(icebreakerUrl)){
				
				String urlStr = "";
				if(!selectFolderId.equals("HOME")){
					urlStr = icebreakerUrl+"/api/file/"+selectFolderId+"/list";
				}else{
					urlStr = icebreakerUrl+"/api/file/list";
				}
				
				URL url = new URL(urlStr);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				conn.setDoOutput(true);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Authorization", "Basic " + icebreakerToken);
				
				String  output = "";		
				if (conn.getResponseCode() == 200) {
					
					BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
					while ((output = br.readLine()) != null) {
						if(!CustomUtil.strNull(output).equals("null")){
							responseValue += output;
						}
					}
				}
				conn.disconnect();
			}
			
			List resultList = new ArrayList();
			if (!CustomUtil.strNull(responseValue).equals("")) {
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(responseValue));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				HashMap resultMap = null;
				
				for (int i = 0; i < jsonArray.size(); i++) {
					resultMap = new HashMap();
					JSONObject comandObj = (JSONObject) jsonArray.get(i);
					
					resultMap.put("parentFolderId", selectFolderId);
					resultMap.put("fileName",comandObj.getString("name"));
					resultMap.put("path",comandObj.getString("path"));
					resultMap.put("fileId", comandObj.getString("id"));
					resultMap.put("parentPath",comandObj.getString("parentPath"));
					resultMap.put("lastModified", comandObj.getString("lastModified"));
					resultMap.put("fileSize", CustomUtil.fileVolumeCalc(String.valueOf(comandObj.getDouble("size"))));
					
					resultList.add(resultMap);
				}
			}
			
			/*JSONObject jsonObj = new JSONObject(resultFileStr);
			org.json.JSONArray jsonArray = jsonObj.getJSONArray("files");*/
			JSONObject json = new JSONObject();
			json.put("dataList", resultList);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 선택한 폴더의 하위폴더 생성
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	@ResourceMapping(value ="createFolder")
	public void createFolder(ResourceRequest request, ResourceResponse response){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Map param = RequestUtil.getParameterMap(request);
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			String icebreakerUrl = TokenProviderUtil_fileTest.getIcebreakerMajinURL(CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL)));
			
			String icebreakerToken = CustomUtil.strNull(param.get("vcToken"));
			
			String parentFolderId = CustomUtil.strNull(param.get("parentId"));
			String parentpath = CustomUtil.strNull(param.get("parentpath"));
			String newFolderName = CustomUtil.strNull(param.get("newFolderNm"));
			
			int responseStatus = 0;
			
			
			if(!"".equals(icebreakerUrl)){
				String urlStr = icebreakerUrl;
				if(parentFolderId.equals("HOME")){//최상위
					urlStr += "/api/folder/create?name="+newFolderName+"&cluster=EDISON-TEST";
				}else if(!parentFolderId.equals("HOME") && !parentpath.equals("")){
					urlStr += "/api/folder/create?name="+parentpath+"/"+newFolderName+"&cluster=EDISON-TEST";
				}
				URL url = new URL(urlStr);
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Authorization", "Basic " + icebreakerToken);
				
				StringBuffer bodyStr = new StringBuffer();
				bodyStr.append("<folder id='"+parentFolderId+"'>");
				bodyStr.append("<name>"+newFolderName+"</name>");
				bodyStr.append("<size>80</size>");
				bodyStr.append("<type>text/plain</type>");
				bodyStr.append("</folder>");
				
				OutputStream os = conn.getOutputStream();
				os.write(bodyStr.toString().getBytes());
				os.flush();
				
				responseStatus =  conn.getResponseCode();
				conn.disconnect();
			}
			
		
			/*JSONObject jsonObj = new JSONObject(resultFileStr);
			org.json.JSONArray jsonArray = jsonObj.getJSONArray("files");*/
			JSONObject json = new JSONObject();
			json.put("status", responseStatus);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 선택한 폴더의 이름변경
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	@ResourceMapping(value ="renameFolder")
	public void renameFolder(ResourceRequest request, ResourceResponse response){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Map param = RequestUtil.getParameterMap(request);
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			String icebreakerUrl = TokenProviderUtil_fileTest.getIcebreakerMajinURL( CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL)));
			
			String icebreakerToken = CustomUtil.strNull(param.get("vcToken"));
			
			String selectFolderId = CustomUtil.strNull(param.get("selectFolderId"));
			String newFolderName = CustomUtil.strNull(param.get("newFolderNm"));
			
			int responseStatus = 0;
			
			
			if(!"".equals(icebreakerUrl)){
				URL url = new URL(icebreakerUrl + "/api/folder/"+selectFolderId+"/"+newFolderName);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				
				conn.setDoOutput(true);
				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Authorization", "Basic " + icebreakerToken);
				
				responseStatus =  conn.getResponseCode();
				conn.disconnect();
			}
			
			
			/*JSONObject jsonObj = new JSONObject(resultFileStr);
			org.json.JSONArray jsonArray = jsonObj.getJSONArray("files");*/
			JSONObject json = new JSONObject();
			json.put("status", responseStatus);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 선택한 폴더 삭제
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	@ResourceMapping(value ="deleteFolder")
	public void deleteFolder(ResourceRequest request, ResourceResponse response){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Map param = RequestUtil.getParameterMap(request);
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			String icebreakerUrl = TokenProviderUtil_fileTest.getIcebreakerMajinURL( CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL)));
			
			String icebreakerToken = CustomUtil.strNull(param.get("vcToken"));
			
			String selectFolderId = CustomUtil.strNull(param.get("selectFolderId"));
			
			int responseStatus = 0;
			if(!"".equals(icebreakerUrl)){
				
				URL url = new URL(icebreakerUrl + "/api/folder/delete/"+selectFolderId);
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				conn.setDoOutput(true);
				conn.setRequestMethod("DELETE");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Authorization", "Basic " + icebreakerToken);
				
				
				responseStatus =  conn.getResponseCode();
				
				conn.disconnect();
			}
			
			/*JSONObject jsonObj = new JSONObject(resultFileStr);
			org.json.JSONArray jsonArray = jsonObj.getJSONArray("files");*/
			JSONObject json = new JSONObject();
			json.put("status", responseStatus);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 폴더 이동
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	@ResourceMapping(value ="moveFolder")
	public void moveFolder(ResourceRequest request, ResourceResponse response){
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Map param = RequestUtil.getParameterMap(request);
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			String icebreakerUrl = TokenProviderUtil_fileTest.getIcebreakerMajinURL( CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL)));
			
			String icebreakerToken = CustomUtil.strNull(param.get("vcToken"));
			
			String sourceId = CustomUtil.strNull(param.get("sourceId"));
			String targetId = CustomUtil.strNull(param.get("targetId"));
			
			int responseStatus = 0;

			if(!"".equals(icebreakerUrl)){
				icebreakerUrl = icebreakerUrl + "/api/folder/move/"+sourceId;
				
				if(!targetId.equals("HOME") && (!"".equals(targetId))){
					icebreakerUrl += "/"+targetId;
				}
				
				URL url = new URL(icebreakerUrl);

				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				conn.setDoOutput(true);
				conn.setRequestMethod("PUT");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Authorization", "Basic " + icebreakerToken);
				
				responseStatus =  conn.getResponseCode();
				conn.disconnect();
			
			}
		
			JSONObject json = new JSONObject();
			json.put("status", responseStatus);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 선택한 폴더 삭제
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	@ResourceMapping(value ="deleteFile")
	public void deleteFile(ResourceRequest request, ResourceResponse response){
		int deleteResponseCode = 0;
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Map param = RequestUtil.getParameterMap(request);
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			
			
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			String icebreakerUrl = TokenProviderUtil_fileTest.getIcebreakerMajinURL( CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL)));
			
			String icebreakerToken = CustomUtil.strNull(param.get("vcToken"));
			String deleteFileArray[] = CustomUtil.paramToArray(param.get("deletefileId[]"));
			
			
			if(deleteFileArray != null && deleteFileArray.length > 0){
				for(int i=0; i<deleteFileArray.length; i++){
					String deleteFileObj = deleteFileArray[i];
					
					if(!"".equals(icebreakerUrl)){
						
						URL url = new URL(icebreakerUrl + "/api/file/delete/"+deleteFileObj);

						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						
						conn.setDoOutput(true);
						conn.setRequestMethod("DELETE");
						conn.setRequestProperty("Accept", "application/json");
						conn.setRequestProperty("Authorization", "Basic " + icebreakerToken);
						
						
						deleteResponseCode = conn.getResponseCode();	
						if(deleteResponseCode != 200){
							break;
						}
						
						conn.disconnect();
					}
				}
			}
			
			JSONObject json = new JSONObject();
			
			json.put("status", deleteResponseCode);
			
			response.setContentType("application/json; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json.toString());
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 파일업로드 POPUP OPEN
	 * @param request
	 * @param model
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@RenderMapping(params = "myaction=fileUploadPopUp")
	public String fileUploadPopUp(RenderRequest request,RenderResponse response, ModelMap model){
		try {
			Map param = RequestUtil.getParameterMap(request);
			
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			String icebreakerToken = CustomUtil.strNull(param.get("vcToken"));
			
			String destFolerId = CustomUtil.strNull(param.get("destFolerId"));
			String destFolerParents = CustomUtil.strNull(param.get("destFolerParents"));
			String isPopUp = CustomUtil.strNull(param.get("isPopUp"), "false");
			
			String returnId = CustomUtil.strNull(param.get("returnId"));
			String returnFileName = CustomUtil.strNull(param.get("returnFileName"));
			String cluster = CustomUtil.strNull(param.get("cluster"));
			String workflowType = CustomUtil.strNull(param.get("workflowType"));
			
			model.addAttribute("groupId", groupId);
			model.addAttribute("vcToken", icebreakerToken);
			model.addAttribute("destFolerId", destFolerId);
			model.addAttribute("destFolerParents", destFolerParents);
			model.addAttribute("isPopUp", isPopUp);
			model.addAttribute("returnId", returnId);
			model.addAttribute("returnFileName", returnFileName);
			model.addAttribute("cluster", cluster);
			model.addAttribute("workflowType", workflowType);
			
			
			return "myfile/fileUpload";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * IB 파일업로드
	 * @param request
	 * @param response
	 * @throws SystemException
	 * @throws PortalException
	 * @throws SQLException
	 * @throws IOException
	 */
	@ActionMapping(params="myaction=fileIBUpload")
	public void fileIBUpload(ActionRequest request, ActionResponse response){
		UploadPortletRequest upload = PortalUtil.getUploadPortletRequest(request);
		Map param = RequestUtil.getParameterMap(upload);
		//temp 폴더에 파일 업로드
		File[] uploadFiles = upload.getFiles("addFile");
		String[] fileNames = upload.getFileNames("addFile");
		
		String vcToken = CustomUtil.strNull(param.get("vcToken"));
		String destFolerId = CustomUtil.strNull(param.get("destFolerId"));
		String destFolerParents = CustomUtil.strNull(param.get("destFolerParents"));
		
		
		try {
			//InputStream[] inputStream = upload.getFilesAsStream("addFile",false);
			
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			String icebreakerUrl = TokenProviderUtil_fileTest.getIcebreakerMajinURL(CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL)));
			
			if(!"".equals(icebreakerUrl)){
				URL url = new URL(icebreakerUrl+"/api/file/upload?cluster=EDISON-TEST");

				InputStream[] uploadInputStream = upload.getFilesAsStream("addFile",false);
				int responseStatus = 0;
				for(int i=0;i<uploadFiles.length;i++){
					
					HttpFileUtil httpFileUtil = new HttpFileUtil(url);
					httpFileUtil.Token = vcToken;
					
					InputStream fileObj = uploadInputStream[i];
					File tempFile = FileUtil.createTempFile(fileObj);
				
					FileOutputStream output = new FileOutputStream(ICEBREAKER_TEMP_PATH + File.separator + fileNames[i]);
					FileInputStream inputStream = new FileInputStream(tempFile);
					byte[] buffer = new byte[1024 * 8];
					int readcount = 0;
					while((readcount=inputStream.read(buffer)) != -1) {
						output.write(buffer, 0, readcount);
					}
					inputStream.close();
					output.close();
					
					if(tempFile.exists()){
						tempFile.delete();
					}
					
					File uploadfile = new File(ICEBREAKER_TEMP_PATH + File.separator + fileNames[i]);
					
					httpFileUtil.addFile("file", uploadfile);
				
					String resultJson = httpFileUtil.sendMultipartPost();
					if(!"".equals(CustomUtil.strNull(resultJson))){
						
						JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(resultJson));
						String fileId = json.getString("id");
						
						if(!"".equals(fileId) && !destFolerId.equals("HOME")){
							URL fileMoveUrl = new URL(icebreakerUrl+"/api/file/move/"+fileId+"/"+destFolerId);
	
							HttpURLConnection conn = (HttpURLConnection) fileMoveUrl.openConnection();
							
							conn.setDoOutput(true);
							conn.setRequestMethod("PUT");
							conn.setRequestProperty("Accept", "application/json");
							conn.setRequestProperty("Authorization", "Basic " + vcToken);
							
							responseStatus =  conn.getResponseCode();
							conn.disconnect();
							
							if(responseStatus == 200){
								/*response.setRenderParameter("mode", "fileUpload");
								response.setRenderParameter("uploadDestFolerId", destFolerId);
								response.setRenderParameter("destFolerParents", destFolerParents);*/
								
								request.getPortletSession().setAttribute("mode", "fileUpload");
								request.getPortletSession().setAttribute("uploadDestFolerId", destFolerId);
								request.getPortletSession().setAttribute("destFolerParents", destFolerParents);
								
								SessionMessages.add(request, EdisonMessageConstants.INSERT_SUCCESS);
							}
						}else if(destFolerId.equals("HOME")){
							SessionMessages.add(request, EdisonMessageConstants.INSERT_SUCCESS);
						}else{
							SessionErrors.add(request, EdisonMessageConstants.INSERT_ERROR);
						}
					}else{
						SessionErrors.add(request, EdisonMessageConstants.INSERT_ERROR);
					}
					
					if(uploadfile.exists()){
						uploadfile.delete();
					}
				}
			}
			

			boolean isPopUp = Boolean.valueOf(CustomUtil.strNull(param.get("isPopUp"),"false"));
			
			if(isPopUp){
				response.setWindowState(LiferayWindowState.POP_UP);
				response.setRenderParameter("p_p_state", LiferayWindowState.POP_UP.toString());
				response.setRenderParameter("returnId", CustomUtil.strNull(param.get("returnId")));
				response.setRenderParameter("returnFileName", CustomUtil.strNull(param.get("returnFileName")));				
				response.setRenderParameter("cluster", CustomUtil.strNull(param.get("cluster")));
				response.setRenderParameter("workflowType", CustomUtil.strNull(param.get("workflowType")));
			}
			
		} catch (Exception e) {
			SessionErrors.add(request, EdisonMessageConstants.INSERT_ERROR);
			e.printStackTrace();
		}
	}
	
}
