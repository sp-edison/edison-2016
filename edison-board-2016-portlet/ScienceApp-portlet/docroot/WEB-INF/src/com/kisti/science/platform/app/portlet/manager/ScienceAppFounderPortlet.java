package com.kisti.science.platform.app.portlet.manager;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.kisti.science.platform.app.model.ScienceApp;
import com.kisti.science.platform.app.service.ScienceAppLocalServiceUtil;
import com.kisti.science.platform.app.service.constants.ScienceAppConstants;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ScienceAppFounderPortlet extends MVCPortlet 
{
	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException 
	{
		try 
		{
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long plid = themeDisplay.getPlid();
			HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
			request.setAttribute("scienceAppList",getScienceAppDataJson( httpRequest, plid));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		super.doView(request, response);
	}
	
	private String getScienceAppDataJson(HttpServletRequest httpRequest, long plid)
	{
		JSONObject jsonDataList = JSONFactoryUtil.createJSONObject();
		try
		{
			List<ScienceApp> scienceAppList = null;
			scienceAppList = ScienceAppLocalServiceUtil.getAll();
			
			JSONArray editorList = JSONFactoryUtil.createJSONArray();
			JSONArray analyzerList = JSONFactoryUtil.createJSONArray();
			
			for( ScienceApp scienceApp : scienceAppList)
			{
				JSONObject jsonScienceApp = JSONFactoryUtil.createJSONObject();
				jsonScienceApp.put("token", AuthTokenUtil.getToken(httpRequest,plid, scienceApp.getExeFileName()));
				jsonScienceApp.put("scienceAppId", scienceApp.getScienceAppId() );
				jsonScienceApp.put("name", scienceApp.getName() );
				jsonScienceApp.put("title", scienceApp.getTitle() );
				jsonScienceApp.put("exeFileName", scienceApp.getExeFileName() );
				jsonScienceApp.put("plid", plid);
				
				if(scienceApp.getAppType().equals(ScienceAppConstants.APP_TYPE_EDITOR))
				{
					editorList.put(jsonScienceApp);
				}
				else if(scienceApp.getAppType().equals(ScienceAppConstants.APP_TYPE_ANALYZER))
				{
					analyzerList.put(jsonScienceApp);
				}
			}
			jsonDataList.put("editorList", editorList);
			jsonDataList.put("analyzerList", analyzerList);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return jsonDataList.toString();
	}
	
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException 
	{
		super.serveResource(request, response);
		
		String portName = ParamUtil.getString(request, "portName");
		PortletSession portletSession = request.getPortletSession();
		
		String result = getPortletSessionValue(portletSession, portName);
	
		System.err.println("Read Session ["+portName+"] Value : " + result);
		
		response.getWriter().write( result );
	}
	
	private String getPortletSessionValue(PortletSession portletSession, String portName)
	{
		String result = "";
		JSONObject receivedEvent = (JSONObject)portletSession.getAttribute(portName,PortletSession.APPLICATION_SCOPE);
		if(receivedEvent != null)
		{
			result = receivedEvent.toString();
		}
		return result;
	}
}
