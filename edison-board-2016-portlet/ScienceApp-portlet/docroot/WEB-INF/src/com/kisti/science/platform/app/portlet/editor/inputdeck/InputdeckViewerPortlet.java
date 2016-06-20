package com.kisti.science.platform.app.portlet.editor.inputdeck;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.kisti.science.platform.app.model.PortTypeInputdeckForm;
import com.kisti.science.platform.app.service.PortTypeInputdeckFormLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class InputdeckViewerPortlet extends MVCPortlet 
{
	@Override
	public void doView(RenderRequest request, RenderResponse response) throws IOException, PortletException 
	{
		String portletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
		System.err.println(portletId);
		request.setAttribute("inputdeckFormDataList", getInputdeckFormDataJson());
		
		super.doView(request, response);
	} 
	
	private String getInputdeckFormDataJson()
	{
		List<PortTypeInputdeckForm> inputdeckFormDataList=null;
		
		try 
		{
			inputdeckFormDataList = PortTypeInputdeckFormLocalServiceUtil.getAll();
		} 
		catch (SystemException e) 
		{
			e.printStackTrace();
		}

		JSONArray inputdeckFormJsonList = JSONFactoryUtil.createJSONArray();
		
		for(PortTypeInputdeckForm inputdeckForm : inputdeckFormDataList)
		{
			JSONObject jsonInputdeckForm = JSONFactoryUtil.createJSONObject();
			jsonInputdeckForm.put("inputdeckFormId", inputdeckForm.getPortTypeId());
			jsonInputdeckForm.put("inputdeckForm", inputdeckForm.getInputdeckForm());
			inputdeckFormJsonList.put(jsonInputdeckForm);
		}
		
		return inputdeckFormJsonList.toString();
	}
}
