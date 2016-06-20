package com.kisti.science.platform.app.portlet.analyzer.textviewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class TextViewerPortlet extends MVCPortlet 
{
	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException 
	{
		String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
		System.err.println(portletId);
		
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> resultMap = new HashMap<String,Object>();		
		resultMap.put("fileName", "testOneDplot01");
		resultMap.put("fileId", "lateral.oneD");
		resultList.add(resultMap);
		
		resultMap = new HashMap<String,Object>();		
		resultMap.put("fileName", "testOneDplot02");
		resultMap.put("fileId", "vertical.oneD");
		resultList.add(resultMap);

		request.setAttribute("resultList",resultList);
		
		String viewTemplate = getInitParameter("view-template");
		PortletContext portletContext = getPortletContext();
		PortletRequestDispatcher portletRequestDispatcher = portletContext.getRequestDispatcher(viewTemplate);
		portletRequestDispatcher.include(request, response);
	}
}
