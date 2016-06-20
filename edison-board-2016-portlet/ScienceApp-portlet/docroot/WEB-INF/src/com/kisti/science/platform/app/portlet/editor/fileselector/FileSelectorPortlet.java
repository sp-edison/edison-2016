package com.kisti.science.platform.app.portlet.editor.fileselector;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class FileSelectorPortlet extends MVCPortlet 
{
	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException 
	{
		String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
		System.err.println(portletId);
		super.doView(request, response);
	}
}
