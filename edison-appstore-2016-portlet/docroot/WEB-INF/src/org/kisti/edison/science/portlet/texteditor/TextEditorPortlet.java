package org.kisti.edison.science.portlet.texteditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.kisti.edison.model.EdisonExpando;
import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.model.IcebreakerVcToken;
import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.HttpFileUtil;
import org.kisti.edison.util.IcebreakerUtil;
import org.kisti.edison.util.RequestUtil;
import org.kisti.edison.util.TokenProviderUtil_fileTest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
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

@Controller
@RequestMapping("VIEW")
public class TextEditorPortlet
{
	private final String ICEBREAKER_TEMP_PATH = PropsUtil.get(PropsKeys.LIFERAY_HOME)+"/ICEBREAKER_TEMP";
	
	@SuppressWarnings("rawtypes")
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response, ModelMap model)
	{
//		String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
//		System.err.println(portletId);
		try 
		{
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();

			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			//long groupId = 20181;
			//System.err.println( "GROUPID : " +groupId);
			
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			String icebreakerUrl = TokenProviderUtil_fileTest.getIcebreakerMajinURL(CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL)));
			IcebreakerVcToken icebreakerVcToken = IcebreakerUtil.getIceBreakerToken(user, groupId, thisGroup, themeDisplay);

			if(!"".equals(icebreakerUrl)){
				model.addAttribute("icebreakerUrl", icebreakerUrl);
			}
			model.addAttribute("icebreakerVcToken", icebreakerVcToken);
			model.addAttribute("groupId", groupId);
			
			Map<String, Object> uploadMap = request.getPortletSession().getAttributeMap();
			if(uploadMap  != null){
				model.addAttribute("mode", CustomUtil.strNull(request.getPortletSession().getAttribute("mode")));
				model.addAttribute("uploadDestFolerId", CustomUtil.strNull(request.getPortletSession().getAttribute("uploadDestFolerId")));
				model.addAttribute("uploadDestFileId", CustomUtil.strNull(request.getPortletSession().getAttribute("uploadDestFileId")));
				model.addAttribute("uploadDestFileName", CustomUtil.strNull(request.getPortletSession().getAttribute("uploadDestFileName")));
				model.addAttribute("destFolerParents", CustomUtil.strNull(request.getPortletSession().getAttribute("destFolerParents")));
				model.addAttribute("dialogId", CustomUtil.strNull(request.getPortletSession().getAttribute("dialogId")));
				
				request.getPortletSession().removeAttribute("mode");
				request.getPortletSession().removeAttribute("uploadDestFolerId");
				request.getPortletSession().removeAttribute("uploadDestFileId");
				request.getPortletSession().removeAttribute("uploadDestFileName");
				request.getPortletSession().removeAttribute("destFolerParents");
				request.getPortletSession().removeAttribute("dialogId");
			}
			
			model.addAttribute("returnId", CustomUtil.strNull(param.get("returnId")));
			model.addAttribute("returnFileName", CustomUtil.strNull(param.get("returnFileName")));
			model.addAttribute("cluster", CustomUtil.strNull(param.get("cluster")));
			model.addAttribute("workflowType", CustomUtil.strNull(param.get("workflowType")));
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "fileselector/view"; 
	}
	/**
	 * 최상위 폴더
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResourceMapping(value ="getRepositoryFolder")
	public void getRepositoryFolder(ResourceRequest request, ResourceResponse response){
		try {
			Map param = RequestUtil.getParameterMap(request);
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
	
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			String icebreakerUrl = TokenProviderUtil_fileTest.getIcebreakerMajinURL(CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL)));
			
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResourceMapping(value ="getChildFolder")
	public void getChildFolder(ResourceRequest request, ResourceResponse response){
		try {
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResourceMapping(value ="getChildFile")
	public void getChildFile(ResourceRequest request, ResourceResponse response){
		try {
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
	 * 폴더 이동
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	@ResourceMapping(value ="moveFolder")
	public void moveFolder(ResourceRequest request, ResourceResponse response){
		try {
			Map param = RequestUtil.getParameterMap(request);
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			String icebreakerUrl = TokenProviderUtil_fileTest.getIcebreakerMajinURL(CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL)));
			
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
	 * 파일업로드 POPUP OPEN
	 * @param request
	 * @param model
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@RenderMapping(params = "myaction=fileUploadPopUp")
	@SuppressWarnings("rawtypes")
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
			String dialogId = CustomUtil.strNull(param.get("dialogId"));
			
			model.addAttribute("groupId", groupId);
			model.addAttribute("vcToken", icebreakerToken);
			model.addAttribute("destFolerId", destFolerId);
			model.addAttribute("destFolerParents", destFolerParents);
			model.addAttribute("isPopUp", isPopUp);
			model.addAttribute("returnId", returnId);
			model.addAttribute("returnFileName", returnFileName);
			model.addAttribute("cluster", cluster);
			model.addAttribute("workflowType", workflowType);
			model.addAttribute("dialogId", dialogId);
			
			return "fileselector/fileUpload";
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
	@SuppressWarnings("rawtypes")
	public void fileIBUpload(ActionRequest request, ActionResponse response){
		UploadPortletRequest upload = PortalUtil.getUploadPortletRequest(request);
		Map param = RequestUtil.getParameterMap(upload);
		//temp 폴더에 파일 업로드
		File[] uploadFiles = upload.getFiles("addFile");
		String[] fileNames = upload.getFileNames("addFile");
		
		String vcToken = CustomUtil.strNull(param.get("vcToken"));
		String destFolerId = CustomUtil.strNull(param.get("destFolerId"));
		String destFolerParents = CustomUtil.strNull(param.get("destFolerParents"));
		String dialogId = CustomUtil.strNull(param.get("destDialogId"));

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
								request.getPortletSession().setAttribute("destFolerParents", destFolerParents);
								request.getPortletSession().setAttribute("uploadDestFileId", fileId);
								request.getPortletSession().setAttribute("uploadDestFileName", fileNames[i]);
								request.getPortletSession().setAttribute("dialogId", dialogId);
								SessionMessages.add(request, EdisonMessageConstants.INSERT_SUCCESS);
							}
						}else if(destFolerId.equals("HOME")){
							request.getPortletSession().setAttribute("uploadDestFileId", fileId);
							request.getPortletSession().setAttribute("uploadDestFileName", fileNames[i]);
							request.getPortletSession().setAttribute("dialogId", dialogId);
							
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
	
	@SuppressWarnings("rawtypes")
	@ResourceMapping(value ="savePortletSessionValue")
	private void savePortletSessionValue( ResourceRequest request, ResourceResponse response )
	{
		PortletSession portletSession = request.getPortletSession();
		Map param = RequestUtil.getParameterMap(request);
		String portName = CustomUtil.strNull(param.get("portName"));
		String taskId = CustomUtil.strNull(param.get("taskId"));
		String value = CustomUtil.strNull(param.get("value"));
		
		com.liferay.portal.kernel.json.JSONObject sendEvent = JSONFactoryUtil.createJSONObject();
		sendEvent.put("taskId", taskId);
		sendEvent.put("portName", portName);
		sendEvent.put("value", value);

		portletSession.setAttribute(portName,sendEvent,PortletSession.APPLICATION_SCOPE);
	}
	
	@SuppressWarnings("rawtypes")
	@ResourceMapping(value ="getPortletSessionValue")
	private void getPortletSessionValue( ResourceRequest request, ResourceResponse response ) throws IOException
	{
		PortletSession portletSession = request.getPortletSession();
		Map param = RequestUtil.getParameterMap(request);
		String portName = CustomUtil.strNull(param.get("portName"));
		
		String result = "";
		com.liferay.portal.kernel.json.JSONObject receivedEvent = (com.liferay.portal.kernel.json.JSONObject)portletSession.getAttribute(portName,PortletSession.APPLICATION_SCOPE);
		if(receivedEvent != null)
		{
			result = receivedEvent.toString();
		}
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(result);
	}
}
