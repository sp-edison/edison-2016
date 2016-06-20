package org.kisti.edison.science.portlet.textviewer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
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

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class TextViewerPortlet extends MVCPortlet 
{
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
			
			long groupId = Long.parseLong(CustomUtil.strNull(param.get("groupId"), String.valueOf(PortalUtil.getScopeGroupId(request))));
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			
			String fileListType = CustomUtil.strNull(param.get("fileListType"));
			String fileListValue = CustomUtil.strNull(param.get("fileListValue"));
			String jobUuid = CustomUtil.strNull(param.get("jobUuid"));
			String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));

			//JSP 에서는 화면에 icebreakerUrl을 PUBLIC URL 로 전송
			//String publicIceBreakerUrl = (String) GroupLocalServiceUtil.getGroup(groupId).getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL_PUBLIC);

			//Test용
			//jobUuid = "40ea5908-390e-4169-8814-38573ea56a73";
			
			IcebreakerVcToken icebreakerVcToken = IcebreakerUtil.getIceBreakerToken(user, groupId, thisGroup, themeDisplay);

			String dirPath = "result";
			if(fileListType.equals("FOLDER"))
				dirPath = fileListValue;
			else if(fileListType.equals("TEMP"))
				dirPath = "";
			
			String result = IcebreakerUtil.getSimulationResult(icebreakerUrl, icebreakerVcToken.getVcToken(), jobUuid, dirPath);
			if (!CustomUtil.strNull(result).equals("")) 
			{
				JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(result));
				JSONArray jsonArray = jsonObj.getJSONArray("files");
				
				request.setAttribute("icebreakerUrl",icebreakerUrl);
				request.setAttribute("resultDataList", IcebreakerUtil.sortJsonArray(jsonArray, fileListType,fileListValue,"name").toString());
			}
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
		File tempFile = null;
		try
		{
			Map param = RequestUtil.getParameterMap(request);
			String downloadUrl = CustomUtil.strNull(param.get("downloadUrl"));
			
			URL remoteFileURL = new URL(downloadUrl);
			URLConnection uCon =  remoteFileURL.openConnection();
			InputStream is = uCon.getInputStream();
			
			tempFile = FileUtil.createTempFile(is);
			
			FileReader reader = new FileReader(tempFile);
			BufferedReader bufferReader = new BufferedReader(reader);
			String read="";
			StringBuffer readBuffer = new StringBuffer();
			int lineIndex=0;
			int areaIndex=0;
			int diviceIndex=1000;
			
			com.liferay.portal.kernel.json.JSONObject fileAreaJson = JSONFactoryUtil.createJSONObject();
			
			while((read=bufferReader.readLine())!=null)
			{
				readBuffer.append(read+"\r\n");
				if(lineIndex==diviceIndex)
				{
					fileAreaJson.put(String.valueOf(areaIndex),readBuffer.toString());
					readBuffer = new StringBuffer();
					areaIndex++;
					diviceIndex+=500;
				}
				lineIndex++;
			}
			
			if(areaIndex==0)
				fileAreaJson.put(String.valueOf(areaIndex),readBuffer.toString());				
			
			FileUtil.delete(tempFile);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(fileAreaJson.toString());
			
			reader.close();
			bufferReader.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			FileUtil.delete(tempFile);
		}
	}
}