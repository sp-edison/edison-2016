package org.kisti.edison.science.portlet.workspace;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletContext;

import org.kisti.edison.util.CustomUtil;
import org.kisti.edison.util.EdisonFileUtil;
import org.kisti.edison.util.RequestUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.ResourceServingConfigurationAction;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletConfigFactoryUtil;

import net.sf.json.JSONException;

public class ConfigurationController implements ConfigurationAction  {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)	throws Exception {
		UploadPortletRequest upload = com.liferay.portal.util.PortalUtil.getUploadPortletRequest(actionRequest);			
		Map params = RequestUtil.getParameterMap(upload);
		String myAction = CustomUtil.strNull(params.get("myaction"));
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute (WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		if(myAction.equals("fileSetting")){
			String manualAddfileName = CustomUtil.strNull(upload.getFileName("manualAddfile"));
			if(!manualAddfileName.equals("")){
				EdisonFileUtil.deleteEdisonSampleFile(groupId, "WORKSPACE_MANUAL");
				EdisonFileUtil.insertEdisonSampleFile(actionRequest, upload, userId, groupId, "manualAddfile", "WORKSPACE_MANUAL");
			}
			
			String securityAddfileName = CustomUtil.strNull(upload.getFileName("securityAddfile"));
			if(!securityAddfileName.equals("")){
				EdisonFileUtil.deleteEdisonSampleFile(groupId, "WORKSPACE_SECURITY");
				EdisonFileUtil.insertEdisonSampleFile(actionRequest, upload, userId, groupId, "securityAddfile", "WORKSPACE_SECURITY");
			}
		}
	}
	
	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute (WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		
		List manualFileList = null;
		manualFileList = EdisonFileUtil.getListEdisonSampleFile(groupId, "WORKSPACE_MANUAL");
		List securityFileList = null;
		securityFileList = EdisonFileUtil.getListEdisonSampleFile(groupId, "WORKSPACE_SECURITY");
		
		renderRequest.setAttribute("manualFileList", manualFileList);
		renderRequest.setAttribute("securityFileList", securityFileList);
		
		PortletConfig selPortletConfig = getSelPortletConfig(renderRequest);

		String configTemplate = selPortletConfig.getInitParameter(
			"config-template");
		
		if (Validator.isNotNull(configTemplate)) {
			return configTemplate;
		}

		String configJSP = selPortletConfig.getInitParameter("config-jsp");
		
		if (Validator.isNotNull(configJSP)) {
			return configJSP;
		}
		
		return "workspace/configuration.jsp";
		
	}

	protected PortletConfig getSelPortletConfig(PortletRequest portletRequest)
		throws SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String portletResource = ParamUtil.getString(
			portletRequest, "portletResource");

		Portlet selPortlet = PortletLocalServiceUtil.getPortletById(
			themeDisplay.getCompanyId(), portletResource);

		ServletContext servletContext =
			(ServletContext)portletRequest.getAttribute(WebKeys.CTX);

		PortletConfig selPortletConfig = PortletConfigFactoryUtil.create(
			selPortlet, servletContext);

		return selPortletConfig;
	}	
}
