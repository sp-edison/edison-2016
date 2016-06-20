package org.kisti.edison.science.portlet.stringeditor;

import java.io.IOException;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class StringEditorPortlet extends MVCPortlet 
{
	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException 
	{
//		String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
		super.doView(request, response);
	}
}
