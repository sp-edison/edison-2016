package org.kisti.edison.termsofuse;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

@Controller
@RequestMapping("VIEW")
public class TermsOfUseController {
	protected static Log  log = LogFactoryUtil.getLog(TermsOfUseController.class);
	
	@RequestMapping//default
	public String view(RenderRequest renderRequest, RenderResponse response, ModelMap model){
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		
		
		String jspPath = "";
		if(languageId.equals("en_US")){
			jspPath = "termsofuse/terms_of_use_en_US";
		}else if(languageId.equals("ko_KR")){
			jspPath = "termsofuse/terms_of_use_ko_KR";
		}else{
			jspPath = "termsofuse/terms_of_use_error";
		}
		
		return jspPath;
	}
}
