package org.kisti.edison.science.portlet.onedplotviewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.portlet.PortletException;
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
import org.kisti.edison.util.IcebreakerUtil;
import org.kisti.edison.util.RequestUtil;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class OneDPlotViewerPortlet extends MVCPortlet {
	@SuppressWarnings("rawtypes")
	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException 
	{
//		String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
//		System.err.println(portletId);
		try 
		{
			Map param = RequestUtil.getParameterMap(request);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			User user = themeDisplay.getUser();
			
//			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			long groupId = 20181;
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);

			String fileListType = CustomUtil.strNull(param.get("fileListType"));
			String fileListValue = CustomUtil.strNull(param.get("fileListValue"));
			String jobUuid = CustomUtil.strNull(param.get("jobUuid"));
			String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));

			//JSP 에서는 화면에 icebreakerUrl을 PUBLIC URL 로 전송
			//String publicIceBreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL_PUBLIC);
			
			//Test용
			//jobUuid = "2a4530a4-52cc-4f26-bec2-87ead3e49e41"; 77개
			jobUuid = "c8cfb864-aeae-46cd-9e5b-8e6887437148";
			fileListType = "EXT";
			fileListValue = "oneD";

			IcebreakerVcToken icebreakerVcToken = IcebreakerUtil.getIceBreakerToken(user, groupId, thisGroup, themeDisplay);

			String dirPath = "result";
			if(fileListType.equals("FOLDER"))
				dirPath = fileListValue;
			else if(StringUtil.equalsIgnoreCase(fileListType, "TEMP"))
				dirPath = "";
			
			String result = IcebreakerUtil.getSimulationResult(icebreakerUrl, icebreakerVcToken.getVcToken(), jobUuid, dirPath);
			if (!CustomUtil.strNull(result).equals("")) 
			{
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(result));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				
				/* 느려서 사용불가
				 * for(int i =0 ; i<jsonArray.size();i++)
				{
					jsonArray.getJSONObject(i).put("rawdata", getResultRead( icebreakerUrl,  icebreakerVcToken.getVcToken(),  jsonArray.getJSONObject(i).getString("id")));
				}
				*/
				request.setAttribute("icebreakerUrl",icebreakerUrl);
				request.setAttribute("resultDataList", IcebreakerUtil.sortJsonArray(jsonArray, fileListType,fileListValue,"name").toString());
				//request.setAttribute("resultDataList", jsonArray.toString());
			}
			
			request.setAttribute("groupId",groupId);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		super.doView(request, response);
	}
	@SuppressWarnings("rawtypes")
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
	{
		Map param = RequestUtil.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		
		try
		{
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
			IcebreakerVcToken icebreakerVcToken = IcebreakerUtil.getIceBreakerToken(user, groupId, thisGroup, themeDisplay);
			
			Map params = RequestUtil.getParameterMap(request);
			String[] fileIds = CustomUtil.strNull(params.get("fileIds")).split(",");

			StringBuffer resultDatas = new StringBuffer();
			for(int i = 0; i < fileIds.length;i++)
			{
				if(!fileIds[i].equals(""))
					resultDatas.append( getResultRead(icebreakerUrl, icebreakerVcToken.getVcToken(), fileIds[i]) );
			}
			
			PrintWriter out = response.getWriter();
			out.write(resultDatas.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
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
}