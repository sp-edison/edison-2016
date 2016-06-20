package org.kisti.edison.science.portlet.requestPopup;

import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.kisti.edison.model.EdisonMessageConstants;
import org.kisti.edison.science.service.DeveloperInfoLocalServiceUtil;
import org.kisti.edison.science.service.constants.RequiredLibConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;

@Controller
@RequestMapping("VIEW")   
public class RequestPopupController {
	private static Log log = LogFactoryUtil.getLog(RequestPopupController.class);
	
	@RequestMapping//default
	public String view(RenderRequest request, RenderResponse response,ModelMap model) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute (WebKeys.THEME_DISPLAY);
			
			long parentGroupId = GroupLocalServiceUtil.getGroup(PortalUtil.getScopeGroupId(request)).getParentGroupId();
			
			if(parentGroupId == 0) {
				Map requestInfo = DeveloperInfoLocalServiceUtil.getCountRequestInfo(0, "1202001", "1401001", RequiredLibConstants.LIB_STATE_REQUIRE, "1202007");	// 1202001 개발자 요청, 1401001 가상실험실 요청, RequiredLibConstants.LIB_STATE_REQUIRE 라이브러리 요청
				long workspacePlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "edisondeveloperrequestlist_WAR_edisonappstore2016portlet");
				PortletURL workspaceURL = PortletURLFactoryUtil.create(request, "edisondeveloperrequestlist_WAR_edisonappstore2016portlet", workspacePlid, PortletRequest.RENDER_PHASE);
				
				long virtualLabPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "edisonvirtuallabrequestlist_WAR_edisonvirtuallab2016portlet");
				PortletURL virtualLabURL = PortletURLFactoryUtil.create(request, "edisonvirtuallabrequestlist_WAR_edisonvirtuallab2016portlet", virtualLabPlid, PortletRequest.RENDER_PHASE);
				
				long libRequestPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "edisonlibraryrequiredlist_WAR_edisonappstore2016portlet");
				PortletURL libRequestURL = PortletURLFactoryUtil.create(request, "edisonlibraryrequiredlist_WAR_edisonappstore2016portlet", libRequestPlid, PortletRequest.RENDER_PHASE);
				
				model.addAttribute("isSite", true);
				model.addAttribute("workspaceURL", workspaceURL.toString());
				model.addAttribute("virtualLabURL", virtualLabURL.toString());
				model.addAttribute("libRequestURL", libRequestURL.toString());
				model.addAttribute("requestInfo", requestInfo);
			}else {
				Map requestInfo = DeveloperInfoLocalServiceUtil.getCountRequestInfo(themeDisplay.getScopeGroupId(), "1202001", "1401001", "", "1202007");	// 1202001 개발자 요청, 1401001 가상실험실 요청
				long workspacePlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "edisonworkspace_WAR_edisonappstore2016portlet");
				PortletURL workspaceURL = PortletURLFactoryUtil.create(request, "edisonworkspace_WAR_edisonappstore2016portlet", workspacePlid, PortletRequest.RENDER_PHASE);
				
				long virtualLabPlid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), "edisonvirtuallabrequestmanagement_WAR_edisonvirtuallab2016portlet");
				PortletURL virtualLabURL = PortletURLFactoryUtil.create(request, "edisonvirtuallabrequestmanagement_WAR_edisonvirtuallab2016portlet", virtualLabPlid, PortletRequest.RENDER_PHASE);
				
				model.addAttribute("isSite", false);
				model.addAttribute("workspaceURL", workspaceURL.toString());
				model.addAttribute("virtualLabURL", virtualLabURL.toString());
				model.addAttribute("requestInfo", requestInfo);
			}
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			
			//Session Error Message
			SessionErrors.add(request, EdisonMessageConstants.SEARCH_ERROR);
		}
		return "requestPopup/popupView";
	}
}
