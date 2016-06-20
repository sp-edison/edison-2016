package com.kisti.science.platform.app.portlet.editor.stringeditor;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class StringEditorPortlet extends MVCPortlet 
{
	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException 
	{
//		String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
//		System.err.println(portletId);
		
		PortletSession portletSession = request.getPortletSession();
		String portName = ParamUtil.getString(request, "portName");
		request.setAttribute("value", getPortletSessionValue(portletSession, portName));
		super.doView(request, response);
	}
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException 
	{
		super.serveResource(request, response);
		
		String portName = ParamUtil.getString(request, "portName");
		String taskId = ParamUtil.getString(request, "taskId");
		String value = ParamUtil.getString(request, "value");
		PortletSession portletSession = request.getPortletSession();
		
		savePortletSessionValue(portletSession, taskId, portName, value);
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
	
	private void savePortletSessionValue(PortletSession portletSession, String taskId, String portName, String value)
	{
		JSONObject sendEvent = JSONFactoryUtil.createJSONObject();
		sendEvent.put("taskId", taskId);
		sendEvent.put("portName", portName);
		sendEvent.put("value", value);

		portletSession.setAttribute(portName,sendEvent,PortletSession.APPLICATION_SCOPE);
	}
}
