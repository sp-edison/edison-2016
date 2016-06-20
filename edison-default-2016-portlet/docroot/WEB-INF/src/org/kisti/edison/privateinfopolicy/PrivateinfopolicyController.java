package org.kisti.edison.privateinfopolicy;

import java.text.ParseException;

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
public class PrivateinfopolicyController {
	protected static Log  log = LogFactoryUtil.getLog(PrivateinfopolicyController.class);
	
	@RequestMapping//default
	public String view(RenderRequest renderRequest, RenderResponse response, ModelMap model) throws ParseException {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String languageId = themeDisplay.getLanguageId();
		
		
		String jspPath = "";
		if(languageId.equals("en_US")){
			jspPath = "privateinfopolicy/private_info_policy_en_US";
		}else if(languageId.equals("ko_KR")){
			jspPath = "privateinfopolicy/private_info_policy_ko_KR";
		}else{
			jspPath = "privateinfopolicy/private_info_policy_error";
		}
		
		return jspPath;
	}
}
