package org.kisti.edison.portalagree;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.kisti.edison.model.EdisonExpando;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.theme.ThemeDisplay;

@Controller
@RequestMapping("VIEW")
public class PortalAgreeController {
	protected static Log  log = LogFactoryUtil.getLog(PortalAgreeController.class);
	
	@RequestMapping//default
	public String view(RenderRequest renderRequest, RenderResponse response, ModelMap model) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		PermissionChecker checker = PermissionCheckerFactoryUtil.create(themeDisplay.getUser());
		boolean isSigned = checker.isSignedIn();
		
		String jspPath = "";
		
		if(isSigned){
			String languageId = themeDisplay.getUser().getLanguageId();
			
			if(languageId.equals("en_US")){
				jspPath = "portalagree/portal_agree_en_US";
			}else if(languageId.equals("ko_KR")){
				jspPath = "portalagree/portal_agree_ko_KR";
			}else{
				jspPath = "portalagree/portal_agree_error";
			}
		}else{
			model.addAttribute("message", LanguageUtil.get(themeDisplay.getLocale(), "you-do-not-have-the-required-permissions-to-access-this-content"));
			jspPath = "portalagree/portal_agree_noauth";
		}
		
		
		return jspPath;
	}
	
	@ActionMapping(params="myaction=portalAgree")
	public void portalAgree(ActionRequest request, ActionResponse response) throws IOException{
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		
		themeDisplay.getUser().getExpandoBridge().setAttribute(EdisonExpando.USER_TERMS_OF_USE_DATE, new Date());
		response.sendRedirect(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_HOME_URL));
	}
	
}