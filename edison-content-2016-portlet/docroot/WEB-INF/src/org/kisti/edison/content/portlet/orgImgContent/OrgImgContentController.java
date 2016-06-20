package org.kisti.edison.content.portlet.orgImgContent;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;

import org.kisti.edison.content.service.OrgImgContentLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

@Controller
@RequestMapping("VIEW")
public class OrgImgContentController {
	
	private static Log log = LogFactoryUtil.getLog(OrgImgContentController.class);
	
	@RequestMapping//default
	public String view(RenderRequest renderRequest, ModelMap model){
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getSiteGroupId();
		String portletNameSpace = themeDisplay.getPortletDisplay().getNamespace();
		
		try {
			List<Map<String, Object>> orgImgContnetList = OrgImgContentLocalServiceUtil.getOrgImgContentListByGroupId(groupId,themeDisplay);
			PortletPreferences prefs = renderRequest.getPreferences();
			
			model.addAttribute("items", prefs.getValue(groupId+"_items", "6"));
			model.addAttribute("autoPlay", prefs.getValue(groupId+"_autoPlay", "4000"));
			model.addAttribute("rewindSpeed", prefs.getValue(groupId+"_rewindSpeed", "3000"));
			model.addAttribute("orgImgContnetList", orgImgContnetList);
			
		} catch (Exception e) {
			e.printStackTrace();
			//관리자에게 이메일 전송
		}
	return "orgImgContent/contentList";
	}
}
